var vm = new Vue({
    el: '.page-content',
    data: {
        meeting: {},
        shouldJoin: '',
        realJoin: '',
        loginId: ''
    },
    methods: {
        selectMeetingNum: function () {
            this.shouldJoin = this.meeting.makeUser.slice(1, -1).split(",");
            axios({
                url: '/meeting/selectShouldJoin',
                params: {mid: this.meeting.id}
            }).then(response => {
                /*console.log(response);*/
                this.realJoin = response.data.obj.length;
            }).catch(error => {
                layer.msg(error.message);
            })
        },
        changeMeetingJoin: function () {
            if (localStorage.getItem("loginUser") != undefined && localStorage.getItem("loginUser") != null) {
                this.loginId = JSON.parse(localStorage.getItem("loginUser")).id;
            }
            let indexOf = this.shouldJoin.indexOf(this.loginId + "");

            if (indexOf == -1) {
                layer.msg("吖屎啦内，不要你")
            } else {
                if (this.meeting.status == 2) {
                    layer.msg("吖屎，已经结束了")
                } else {
                    axios({
                        url: '/meetingJoin/shouldMeetingJoin',
                        params: {mid: this.meeting.id, uid: this.loginId}
                    }).then(response => {
                        let obj = response.data.obj;
                        if (obj == null || obj.length == 0) {
                            axios({
                                url: '/meetingJoin/joinMeeting',
                                params: {mid: this.meeting.id, uid: this.loginId}
                            }).then(response => {
                                this.meeting.flag = false;
                            })
                        } else {
                            layer.msg('你确定退出么？', {
                                time: 0 //不自动关闭
                                , btn: ['是的', '取消']
                                , yes: function (index) {
                                    layer.close(index);
                                    axios({
                                        url: '/meetingJoin/delJoinMeeting',
                                        params: {mid: this.meeting.id, uid: this.loginId}
                                    }).then(response => {
                                        this.meeting.flag = true;
                                        layer.msg("您已退出")
                                    })
                                }
                            });
                        }
                        this.selectMeetingNum();
                    }).catch(error => {
                        layer.msg(error.message);
                    })
                }
            }
        }

    },
    created: function () {
        this.meeting = parent.layer.obj;
        this.selectMeetingNum();
    }
})
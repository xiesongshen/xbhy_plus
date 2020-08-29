var vm = new Vue({
    el: '.page-content',
    data: {
        pageInfo: {
            pageNum: 1,
            pageSize: 4
        },
        meeting: {
            status: ''
        },
    },
    methods: {
        selectPage: function () {
            axios({
                url: `/meeting/selectMeeting/${this.pageInfo.pageNum}/${this.pageInfo.pageSize}`,
                data: this.meeting,
                method: 'post'
            }).then((response) => {
                /*console.log(response.data.obj);*/
                this.pageInfo = response.data.obj;

                if (localStorage.getItem("loginUser") != undefined && localStorage.getItem("loginUser") != null) {
                    var loginId = JSON.parse(localStorage.getItem("loginUser")).id;
                }
                let list = this.pageInfo.list;
                for (const listElement of list) {
                    let split = listElement.makeUser.slice(1, -1).split(",");
                    let indexOf = split.indexOf(loginId + "");
                    if (indexOf == -1) {
                        listElement.flag = true;
                    } else {
                        axios({
                            url: '/meetingJoin/shouldMeetingJoin',
                            params: {mid: listElement.id, uid: loginId}
                        }).then(response => {
                            let obj = response.data.obj;
                            if (obj == null || obj.length == 0) {
                                listElement.flag = true;
                            } else {
                                listElement.flag = false;
                            }
                        })
                    }
                }
                console.log("11")

                setInterval(this._selectPage(this.pageInfo.pageNum,this.pageInfo.pageSize), 5000);
            }).catch((error) => {
                layer.msg(error.message);
            });
        },
        _selectPage: function (pageNum, pageSize) {
            this.pageInfo.pageNum = pageNum;
            this.pageInfo.pageSize = pageSize;
            this.selectPage();
        },

        toDetail: function (meeting) {
            meeting.startNoTime = meeting.startTime.split(" ")[0];
            layer.obj = meeting;
            console.log(this.meeting.flag);
            layer.open({
                type: 2,
                area: ['60%', '80%'],
                fixed: false, //不固定
                content: '/meeting/toDetail',
                end: () => {
                    this.selectPage();
                    let list = this.pageInfo.list;
                    console.log(list);
                    let obj = layer.obj;
                    console.log(obj);
                }
            })
        },
        toInsert: function () {
            layer.open({
                type: 2,
                area: ['60%', '70%'],
                fixed: false, //不固定
                content: '/meeting/toInsert',
                end: () => {
                    this.selectPage();
                }
            })
        },
    },
    created: function () {
        this.selectPage();
    }
})
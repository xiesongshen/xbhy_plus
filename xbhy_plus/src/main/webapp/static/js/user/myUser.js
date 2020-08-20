var vm = new Vue({
    el: '.page-content',
    data: {
        pageInfo: {
            pageNum: 1,
            pageSize: 5
        },
        user: {},
    },
    methods: {
        userMsg: function () {
            if (localStorage.getItem("loginUser") != undefined && localStorage.getItem("loginUser") != null) {
                this.user = JSON.parse(localStorage.getItem("loginUser"));
            }
            axios({
                url: `/user/selectFocus/${this.pageInfo.pageNum}/${this.pageInfo.pageSize}`,
                params: {id: this.user.id}
            }).then(response => {
                /*  console.log(response.data.obj)*/
                this.pageInfo = response.data.obj
            }).catch(error => {
                layer.msg(error.message);
            })
        },

        _selectPage: function (pageNum, pageSize) {
            this.pageInfo.pageNum = pageNum;
            this.pageInfo.pageSize = pageSize;
            this.userMsg();
        },

        toDetail: function (user) {
            if (user.isSecret == 1) {
                layer.msg("该用户设置不可见")
            } else {
                axios({
                    url: '/user/addLook',
                    data: user,
                    method: 'put'
                }).then(response => {
                    layer.obj = response.data.obj[0];
                    layer.open({
                        type: 2,
                        area: ['60%', '80%'],
                        fixed: false, //不固定
                        content: '/user/toDetail',
                        end: () => {
                            this.userMsg();
                        }
                    })
                }).catch(error => {
                    layer.msg(error.message);
                });

            }
        },
        delFocus: function (id) {
            layer.msg('取消关注？', {
                time: 0 //不自动关闭
                , btn: ['是', '否']
                , yes: index => {
                    axios({
                        url: '/userFocus/delFocus',
                        params: {userFocusId: id, userId: this.user.id}
                    }).then(response => {
                        if (response.data.success) {
                            layer.close(index);
                            this.userMsg();
                            layer.msg(response.data.msg);
                        } else {
                            layer.msg(response.data.msg);
                        }
                    }).catch(error => {
                        layer.msg(error.message)
                    })
                }
            })
        }
    }, created: function () {
        this.userMsg();
    }
})
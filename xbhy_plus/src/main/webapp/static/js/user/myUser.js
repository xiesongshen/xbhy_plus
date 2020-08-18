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
        },
        selectFocus: function () {
            axios({
                url: `/user/selectFocus/${this.pageInfo.pageNum}/${this.pageInfo.pageSize}`,
                params: {id: this.user.id}
            }).then(response => {
                console.log(response.data.obj)
                this.pageInfo = response.data.obj
            }).catch(error => {
                layer.msg(error.message);
            })
        },
        toDetail: function (user) {
            layer.obj = user;
            layer.open({
                type: 2,
                area: ['60%', '80%'],
                fixed: false, //不固定
                content: '/user/toDetail',
            })
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
                            this.selectFocus();
                            layer.msg(response.data.msg);
                        }else {
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
        this.selectFocus();
    }
})
var vm = new Vue({
    el: '.page-content',
    data: {
        pageInfo: {
            pageNum: 1,
            pageSize: 5
        },
        name: '',
        uid: '',
    },
    methods: {
        selectPage: function () {
            if (localStorage.getItem("loginUser") != undefined && localStorage.getItem("loginUser") != null) {
                this.uid = JSON.parse(localStorage.getItem("loginUser")).id;
            }
            axios({
                url: `/user/selectPage/${this.pageInfo.pageNum}/${this.pageInfo.pageSize}`,
                params: {username: this.name}
            }).then((response) => {
                this.pageInfo = response.data.obj;

                axios({
                    url: '/user/selectF',
                    params: {id: this.uid}
                }).then(response => {
                    let list = this.pageInfo.list;

                    let obj = response.data.obj;

                    for (let j = 0; j < obj.length; j++) {
                        const objElement = obj[j];
                        for (let i = 0; i < list.length; i++) {
                            const listElement = list[i];
                            if (listElement.id == objElement.id) {
                                listElement.flag = true;
                            }
                        }
                    }

                    console.log(list);

                }).catch(error => {
                    layer.msg(error.message);
                })

            }).catch((error) => {
                console.log(error);
            })
        },
        _selectPage: function (pageNum, pageSize) {
            this.pageInfo.pageNum = pageNum;
            this.pageInfo.pageSize = pageSize;
            this.selectPage();
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
                    console.log(response);
                    layer.obj = response.data.obj[0];
                    layer.open({
                        type: 2,
                        area: ['60%', '80%'],
                        fixed: false, //不固定
                        content: '/user/toDetail',
                        end: () => {
                            this.selectPage();
                        }
                    })
                }).catch(error => {
                    layer.msg(error.message);
                });

            }
        },
        addFocus: function (id, event) {
            if (localStorage.getItem("loginUser") != undefined && localStorage.getItem("loginUser") != null) {
                this.uid = JSON.parse(localStorage.getItem("loginUser")).id;
            }
            this.userFocusId = id;

            if (event.path[0].checked) {
                if (this.uid == this.userFocusId) {
                    layer.msg("不可以关注自己噢")
                    event.path[0].checked = false;
                } else {
                    axios({
                        url: '/userFocus/addFocus',
                        params: {uid: this.uid, userFocusId: this.userFocusId}
                    }).then(response => {
                        layer.msg(response.data.msg);
                    }).catch(error => {
                        layer.msg(error.message);
                    })
                }
            } else {
                axios({
                    url: '/userFocus/delFocus',
                    params: {uid: this.uid, userFocusId: this.userFocusId}
                }).then(response => {
                    layer.msg(response.data.msg);
                }).catch(error => {
                    layer.msg(error.message);
                })
            }
        },

    },
    created: function () {
        this.selectPage();
    }
});


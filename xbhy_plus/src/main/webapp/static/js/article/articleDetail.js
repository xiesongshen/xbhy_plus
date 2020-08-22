var vm = new Vue({
    el: '.page-content',
    data: {
        article: {},
        action: true,
        id: '',
        ScCount: '',
        LoginUid:'',
        userFocus:{},
        OtherScUser:{}
    },
    methods: {
        changeSC: function () {
            //添加收藏
            if (this.action) {
                axios({
                    url: '/favorite/addSC',
                    params: {uid: this.id, aid: this.article.id}
                }).then(response => {
                    if (response.data.success) {
                        this.action = false;
                        layer.msg(response.data.msg)
                        this.selectSC();
                        this.selectScSArticlesByAid();
                    } else {
                        layer.msg(response.data.msg)
                    }
                }).catch(error => {
                    layer.msg(error.message);
                })
            } else {
                axios({
                    url: '/favorite/delSC',
                    params: {uid: this.id, aid: this.article.id}
                }).then(response => {
                    if (response.data.success) {
                        this.action = true;
                        layer.msg(response.data.msg);
                        this.selectSC();
                        this.selectScSArticlesByAid();
                    } else {
                        layer.msg(response.data.msg)
                    }
                }).catch(error => {
                    layer.msg(error.message);
                })
            }
        },
        selectSC: function () {
            if (localStorage.getItem("loginUser") != undefined && localStorage.getItem("loginUser") != null) {
                this.id = JSON.parse(localStorage.getItem("loginUser")).id;
            }
            console.log(JSON.parse(localStorage.getItem("loginUser")));

            axios({
                url: '/favorite/selectAll',
                params: {id: this.id}
            }).then(response => {
                let obj = response.data.obj;

                for (const objElement of obj) {
                    if (objElement.id == this.article.id) {
                        this.action = false;
                    }
                }

                /*console.log(this.article)*/

            }).catch(error => {
                layer.msg(error.message)
            });
            this.selectFocusByid();
        },
        selectScSArticlesByAid: function () {
            axios({
                url: '/article/selectScSArticlesByAid',
                params: {id: this.article.id}
            }).then(response => {
                if (response.data.obj == null) {
                    this.ScCount = '0';
                } else {
                    this.ScCount = response.data.obj.count;
                }
            }).catch(error => {
                layer.msg(error.message);
            })
        },
        selectFocusByid: function () {
            if (localStorage.getItem("loginUser") != undefined && localStorage.getItem("loginUser") != null) {
                this.LoginUid = JSON.parse(localStorage.getItem("loginUser")).id;
            }
            axios({
                url: '/user/selectFocusByid',
                data: {id: this.LoginUid}
            }).then(response => {
                /*console.log(response)*/
                this.userFocus = response.data.obj;
            }).catch(error => {
                layer.msg(error.message)
            });
            this.selectMyUserSc();
        },
        selectMyUserSc:function () {
            axios({
                url:'/user/selectMyUserSc',
                params:{aid:this.article.id,uid:this.LoginUid}
            }).then(response=>{
                this.OtherScUser = response.data.obj;
            }).catch(error=>{
                layer.msg(error.message);
            })
        },
        toDetail:function (ou) {
            if (ou.isSecret == 1) {
                layer.msg("该用户设置不可见")
            } else {
                axios({
                    url: '/user/addLook',
                    data: ou,
                    method: 'put'
                }).then(response => {
                    layer.obj = response.data.obj[0];
                    /*console.log(response.data.obj[0])*/
                    layer.open({
                        type: 2,
                        area: ['60%', '80%'],
                        fixed: false, //不固定
                        content: '/user/toDetail',
                        end: () => {
                            this.selectSC();
                            ou.look = response.data.obj[0].look;
                        }
                    })
                }).catch(error => {
                    layer.msg(error.message);
                });

            }
        }
    },
    created: function () {
        this.article = parent.layer.obj;
        this.selectSC();
        this.selectScSArticlesByAid();
    }
})
var vm = new Vue({
    el: '.page-content',
    data: {
        article: {},
        action: true,
        id: '',
        ScCount: ''
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
            })
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
        }
    },
    created: function () {
        this.article = parent.layer.obj;
        this.selectSC();
        this.selectScSArticlesByAid();
    }
})
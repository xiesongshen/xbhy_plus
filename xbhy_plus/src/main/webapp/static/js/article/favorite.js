var vm = new Vue({
    el: '.page-content',
    data: {
        pageInfo: {
            pageNum: 1,
            pageSize: 4
        },
        title: '',
        id: '',
        ScCount: ''
    },
    methods: {
        selectPage: function () {
            if (localStorage.getItem("loginUser") != undefined && localStorage.getItem("loginUser") != null) {
                this.id = JSON.parse(localStorage.getItem("loginUser")).id;
            }
            axios({
                url: `/favorite/selectPage/${this.pageInfo.pageNum}/${this.pageInfo.pageSize}`,
                params: {id: this.id, title: this.title}
            }).then((response) => {
                /*console.log(response);*/
                this.pageInfo = response.data.obj;
                axios({
                    url: '/article/scArticle',
                }).then(response => {
                    let list = this.pageInfo.list;

                    let obj = response.data.obj;

                    for (let i = 0; i < obj.length; i++) {
                        const objElement = obj[i];
                        for (let i = 0; i < list.length; i++) {
                            const listElement = list[i];
                            if (objElement.id == listElement.id) {
                                listElement.count = objElement.count;
                            }
                        }
                    }
                }).catch(error => {
                    layer.msg(error.message);
                })
            }).catch((error) => {
                console.log(error);
            });
        },
        _selectPage: function (pageNum, pageSize) {
            this.pageInfo.pageNum = pageNum;
            this.pageInfo.pageSize = pageSize;
            this.selectPage();
        },

        toDetail: function (article) {
            axios({
                url: '/article/addLook',
                data: article,
                method: 'put'
            }).then(response => {
                /*console.log(response);*/
                layer.obj = response.data.obj[0];
                layer.open({
                    type: 2,
                    area: ['60%', '80%'],
                    fixed: false, //不固定
                    content: '/article/toDetail',
                    end: () => {
                        this.selectPage();
                    }
                })
            })
        },

    },
    created: function () {
        this.selectPage();
    }
})
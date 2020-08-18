var vm = new Vue({
    el:'.page-content',
    data:{
        pageInfo:{
            pageNum: 1,
            pageSize: 4
        },
        title:''
    },
    methods:{
        selectPage: function () {
            axios({
                url: `/article/selectPage/${this.pageInfo.pageNum}/${this.pageInfo.pageSize}`,
                params:{title:this.title}
            }).then((response) => {
                /*console.log(response.data.obj);*/
                this.pageInfo = response.data.obj;
            }).catch((error) => {
                console.log(error);
            })
        },
        _selectPage: function (pageNum, pageSize) {
            this.pageInfo.pageNum = pageNum;
            this.pageInfo.pageSize = pageSize;
            this.selectPage();
        },

        toDetail:function (article) {
            axios({
                url:'/article/addLook',
                data:article,
                method:'put'
            }).then(response=>{
                /*console.log(response);*/
                layer.obj = response.data.obj[0];
                layer.open({
                    type: 2,
                    area: ['60%', '80%'],
                    fixed: false, //不固定
                    content: '/article/toDetail',
                    end:()=>{
                        this.selectPage();
                    }
                })
            }).catch(error=>{
                layer.msg(error.message);
            });
        },
        toInsert:function () {
            layer.open({
                type: 2,
                area: ['60%', '50%'],
                fixed: false, //不固定
                content: '/article/toInsert',
                end: () => {
                    /*console.log(layer.success);*/
                    if (layer.success == undefined || !layer.success) {
                        this.selectPage();
                    }
                }
            })
        },
    },
    created:function () {
        this.selectPage();
    }
})
var vm = new Vue({
    el: '.page-content',
    data: {
        user: {},
        focusCount: '',
    },
    methods: {
        selectFocusCount: function () {
            axios({
                url: '/userFocus/selectFocusCount',
                params: {id: this.user.id}
            }).then(response => {
                /* console.log(response);*/
                if (response.data.obj == null) {
                    this.focusCount = 0;
                } else {
                    this.focusCount = response.data.obj.count;
                }
            }).catch(error => {
                layer.msg(error.message)
            });

        },
        doUpdate:function () {
            axios({
                url:'/user/doUpdate',
                data:this.user,
                method:'put'
            }).then(response=>{
                if (response.data.success){
                    layer.msg("更新成功")
                    let index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    parent.layer.obj = response.data.obj
                }else {
                    layer.msg("更新失敗")
                }
            }).catch(error=>{
                layer.msg(error.message);
            })
        }

    },
    created: function () {
        this.user = parent.layer.obj;
        this.selectFocusCount();
    }
})
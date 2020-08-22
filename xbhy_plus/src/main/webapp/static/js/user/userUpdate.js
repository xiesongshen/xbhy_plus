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
        doUpdate: function () {
            axios({
                url: '/user/doUpdate',
                data: this.user,
                method: 'put'
            }).then(response => {
                if (response.data.success) {
                    layer.msg("更新成功")
                    let index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    parent.layer.obj = response.data.obj
                    /*console.log(response.data.obj);*/
                } else {
                    layer.msg("更新失敗")
                }
            }).catch(error => {
                layer.msg(error.message);
            })
        },
        uploadImg: function (e) {
            let file = e.target.files[0]
            /* eslint-disable no-undef */
            let param = new FormData()  // 创建form对象
            param.append('file', file)  // 通过append向form对象添加数据
            param.append('chunk', '0') // 添加form表单中其他数据
            /*console.log(param.get('file'))*/ // FormData私有类对象，访问不到，可以通过get判断值是否传进去
            let config = {
                headers: {'Content-Type': 'multipart/form-data'}
            }
            // 添加请求头
            axios.post('/user/uploadImg', param, config)
                .then(res => {
                    this.user.pic = res.data.url;
                    /* console.log(res.data)*/
                })
        }

    },
    created: function () {
        this.user = parent.layer.obj;
        this.selectFocusCount();
    }
});


$(".avatar").click(function () {
    $("#picFile").click();
});


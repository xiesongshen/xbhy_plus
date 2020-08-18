var vm = new Vue({
    el: '.page-content',
    data: {
        article: {},
        success: '',
    },
    methods: {
        doInsert: function () {
            axios({
                url: '/article/doInsert',
                data: this.article,
                method:'post'
            }).then(response => {
                if (response.data.success) {

                    let index = parent.layer.getFrameIndex(window.name);

                    parent.layer.close(index);
                    parent.layer.msg(response.data.msg);
                    parent.layer.success = response.data.success;
                    this.success = response.data.success;
                } else {
                    parent.layer.msg(response.data.msg)
                }
            }).catch(error => {
                layer.msg(error.message);
            })
        }

    },
})
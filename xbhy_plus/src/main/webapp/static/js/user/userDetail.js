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


    },
    created: function () {
        this.user = parent.layer.obj;
        this.selectFocusCount();
    }
})
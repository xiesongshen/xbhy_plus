var vm = new Vue({
    el: '.page-content',
    data: {
        dept: {}
    },
    methods: {
        selectPage: function () {
            axios({
                url: '/dept/selectCount',
            }).then((response) => {
                console.log(response);
                this.dept = response.data.obj;
            }).catch((error) => {
                layer.msg(error.message);
            })
        },
    },
    created: function () {
        this.selectPage();
    }
})
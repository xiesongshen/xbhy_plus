var vm = new Vue({
    el: '.page-content',
    data: {
        user:{}
    },
    methods: {

    },
    created: function () {
        this.user = parent.layer.obj;
    }
})
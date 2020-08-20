var vm = new Vue({
    el: '.page-content',
    data: {
        meeting: {},
    },
    methods: {

    },
    created: function () {
        this.meeting = parent.layer.obj;
    }
})
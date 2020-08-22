var vm = new Vue({
    el: '.myBox',
    data: {
        email: '',
        password: '',
        code: ''
    },
    methods: {
        sendCode: function () {

            axios({
                url: "/user/email",
                params: {email: this.email},
            }).then(response => {
                layer.msg(response.data.mag)
            }).catch(error => {
                layer.msg(error.message)
            })
        },
        doUpdate: function () {
            axios({
                url: '/user/updatePassord',
                params: {email: this.email, code: this.code, password: this.password}
            }).then(response => {
                layer.msg(response.data.mag);
                if (response.data.success){
                    location.href="/index.html";
                }
            }).catch(error => {
                layer.msg(error.message)
            })
        }
    }
})
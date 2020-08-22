var vm = new Vue({
    el: '.myBox',
    data: {
        user: {},
        passwordR: ''
    },
    methods: {
        doInsert: function () {
            if (this.passwordR == this.user.password) {
                axios({
                    url: '/user/doInsert',
                    data: this.user,
                    method:'post'
                }).then(response => {
                    if (response.data.success){
                        location.href="/index.html";
                    } else {
                        layer.msg(response.data.msg)
                    }
                }).catch(error => {
                    console.log(error.message);
                })
            } else {
                layer.msg("密码请一致")
            }

        }
    }
})
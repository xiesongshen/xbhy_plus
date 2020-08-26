var vm = new Vue({
    el: '.myBox',
    data: {
        user: {},
        passwordR: ''
    },
    methods: {
        doInsert: function () {
            if (this.user.username == null && this.email == null && this.user.passive == null) {
                layer.msg("请输入个人信息")
            } else {
                if (this.passwordR == this.user.password) {
                    axios({
                        url: '/user/doInsert',
                        data: this.user,
                        method: 'post'
                    }).then(response => {
                        if (response.data.success) {
                            location.href = "/index.html";
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
        },
        checkEmail: function () {
            axios({
                url: `/user/checkEmail`,
                params: {email: this.user.email}
            }).then(response => {
                console.log(response);
                if (response.data.obj != null) {
                    layer.msg("该邮箱已被注册");
                    $("#form-email").val("");
                }
            }).catch(error => {
                console.log(error.message);
            })
        },
        checkUsername: function () {
            axios({
                url: `/user/checkUsername`,
                params: {username: this.user.username}
            }).then(response => {
                console.log(response);
                if (response.data.obj != null) {
                    layer.msg("用户名已存在");
                    $("#form-username").val("");
                }
            }).catch(error => {
                console.log(error.message);
            })
        },
        checkPasswordR: function () {
            if (this.passwordR != this.user.password) {
                layer.msg("密码请一致")
            }
        }
    }
})
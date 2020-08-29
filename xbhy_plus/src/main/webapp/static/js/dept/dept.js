var vm = new Vue({
    el: '.page-content',
    data: {
        dept: {},
        deptPer: {},
    },
    methods: {
        selectPage: function () {
            axios({
                url: '/dept/selectCount',
            }).then((response) => {
                let obj = response.data.obj;
                for (const objElement of obj) {
                    objElement.flag = false;
                }
                this.dept = obj;
                console.log(obj)
            }).catch((error) => {
                layer.msg(error.message);
            })

        },

        selectPer: function (id) {
            let dept = this.dept;
            for (const deptElement of dept) {
                if (deptElement.id == id) {
                    deptElement.flag = !deptElement.flag;
                } else {
                    deptElement.flag = false;
                }
            }
            axios({
                url: '/user/selectUserByDid',
                params: {id: id}
            }).then(response => {
                this.deptPer = response.data.obj;
            }).catch((error) => {
                layer.msg(error.message);
            })

        },
        toDetail: function (user) {
            if (user.isSecret == 1) {
                layer.msg("该用户设置不可见")
            } else {
                axios({
                    url: '/user/addLook',
                    data: user,
                    method: 'put'
                }).then(response => {
                    layer.obj = response.data.obj[0];
                    layer.open({
                        type: 2,
                        area: ['60%', '70%'],
                        fixed: false, //不固定
                        content: '/user/toDetail',
                        end: () => {
                            user.look = response.data.obj[0].look;
                        }
                    })
                }).catch(error => {
                    layer.msg(error.message);
                });

            }
        },

    },
    created: function () {
        this.selectPage();
    }
})
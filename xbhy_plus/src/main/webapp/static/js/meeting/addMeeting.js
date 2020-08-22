var vm = new Vue({
    el: '.page-content',
    data: {
        meeting: {},
        allDept: {},
        deptUser: {}
    },
    methods: {
        doInsert: function () {
            let startTime = this.meeting.startTime;
            if (startTime != undefined) {
                this.meeting.startTime = startTime.replace("T", " ");
            }

            let endTime = this.meeting.endTime;
            if (startTime != undefined) {
                this.meeting.endTime = endTime.replace("T", " ");
            }

            if (this.meeting.startTime == undefined || this.meeting.endTime == undefined
                || this.meeting.title == undefined || this.meeting.content == undefined
                || this.meeting.deptId == undefined || this.meeting.joinUser == undefined) {
                layer.msg("請輸入會議詳情")
            } else {
                axios({
                    url: '/meeting/doInsert',
                    data: this.meeting,
                    method: 'post'
                }).then(response => {
                    if (response.data.success) {
                        let index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                        parent.layer.msg(response.data.msg)
                    } else {
                        layer.msg("添加失败")
                    }
                }).catch(error => {
                    layer.msg(error.message);
                })
            }

        },
        selectAllDept: function () {
            axios({
                url: '/dept/findAllDept'
            }).then(response => {
                /*console.log(response);*/
                this.allDept = response.data.obj;
            })
        },
        findUserByDid: function (id) {
            axios({
                url: '/user/selectUserByDid',
                params: {id: id}
            }).then(response => {
                /* console.log(response);*/
                this.deptUser = response.data.obj;
                console.log($(".selectpicker").selectpicker);

                /*$('.joinUser').selectpicker('val', '');*/
                $(".selectpicker").selectpicker('refresh');
                $(".selectpicker").selectpicker('render');
                /*$('.joinUser').selectpicker('refresh');*/
            }).catch(error => {
                layer.msg(error.message);
            })
        }
    },
    created: function () {
        this.selectAllDept();
    }
});

$("#endTime").change(function () {
    if ($(this).val() < ($("#startTime").val())) {
        $(this).val("");
        layer.msg("结束时间不允许小于开始时间")
    } else if (($("#startTime").val().length == 0)) {
        layer.msg("请输入开始时间")
    }
});
$("#endTime").blur(function () {
    if ($(this).val().length == 0) {
        layer.msg("请输入结束时间")
    }
})

$("#startTime").blur(function () {
    if ($(this).val().length == 0) {
        layer.msg("请输入开始时间")
    }
});

$("#title").blur(function () {
    if ($(this).val().length == 0) {
        layer.msg("标题不能为空")
    }
});

$("#content").blur(function () {
    if ($(this).val().length == 0) {
        layer.msg("内容不能为空")
    }
});


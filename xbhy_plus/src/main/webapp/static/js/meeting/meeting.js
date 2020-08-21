var vm = new Vue({
    el: '.page-content',
    data: {
        pageInfo: {
            pageNum: 1,
            pageSize: 4
        },
        meeting: {
            status: ''
        }
    },
    methods: {
        selectPage: function () {
            axios({
                url: `/meeting/selectMeeting/${this.pageInfo.pageNum}/${this.pageInfo.pageSize}`,
                data: this.meeting,
                method: 'post'
            }).then((response) => {
                /*console.log(response.data.obj);*/
                this.pageInfo = response.data.obj;
            }).catch((error) => {
                layer.msg(error.message);
            })
        },
        _selectPage: function (pageNum, pageSize) {
            this.pageInfo.pageNum = pageNum;
            this.pageInfo.pageSize = pageSize;
            this.selectPage();
        },

        toDetail: function (meeting) {
            meeting.startNoTime = meeting.startTime.split(" ")[0];
            meeting.flag = true;
            layer.obj = meeting;
            layer.open({
                type: 2,
                area: ['60%', '80%'],
                fixed: false, //不固定
                content: '/meeting/toDetail',
            })
        },
        toInsert: function () {
            layer.open({
                type: 2,
                area: ['60%', '70%'],
                fixed: false, //不固定
                content: '/meeting/toInsert',
                end: () => {
                    /*console.log(layer.success);*/
                    if (layer.success == undefined || !layer.success) {
                        this.selectPage();
                    }
                }
            })
        },
    },
    created: function () {
        this.selectPage();
    }
})
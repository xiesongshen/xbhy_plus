package com.xss.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "meeting_join")
public class MeetingJoin {
    /**
     * 需参加人id
     */
    @Column(name = "u_id")
    private Integer uId;

    /**
     * 会议id
     */
    @Column(name = "c_id")
    private Integer cId;

    /**
     * 获取需参加人id
     *
     * @return u_id - 需参加人id
     */
    public Integer getuId() {
        return uId;
    }

    /**
     * 设置需参加人id
     *
     * @param uId 需参加人id
     */
    public void setuId(Integer uId) {
        this.uId = uId;
    }

    /**
     * 获取会议id
     *
     * @return c_id - 会议id
     */
    public Integer getcId() {
        return cId;
    }

    /**
     * 设置会议id
     *
     * @param cId 会议id
     */
    public void setcId(Integer cId) {
        this.cId = cId;
    }
}
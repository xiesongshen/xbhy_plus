package com.xss.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "userfocus")
public class Userfocus {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户关注的朋友id
     */
    @Id
    @Column(name = "user_focus_id")
    private Integer userFocusId;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Transient
    private Integer count;

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户关注的朋友id
     *
     * @return user_focus_id - 用户关注的朋友id
     */
    public Integer getUserFocusId() {
        return userFocusId;
    }

    /**
     * 设置用户关注的朋友id
     *
     * @param userFocusId 用户关注的朋友id
     */
    public void setUserFocusId(Integer userFocusId) {
        this.userFocusId = userFocusId;
    }
}
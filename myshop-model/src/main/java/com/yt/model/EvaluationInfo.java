package com.yt.model;

import java.sql.Date;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Evaluation
 * @Description 评论模型
 * @createTime 2020年02月15日 15:01:00
 */
public class EvaluationInfo {
    private Integer id;
    private Integer evaluationInfoId;
    private String username;
    private String evaluationInfo;
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEvaluationInfoId() {
        return evaluationInfoId;
    }

    public void setEvaluationInfoId(Integer evaluationInfoId) {
        this.evaluationInfoId = evaluationInfoId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEvaluationInfo() {
        return evaluationInfo;
    }

    public void setEvaluationInfo(String evaluationInfo) {
        this.evaluationInfo = evaluationInfo;
    }
}

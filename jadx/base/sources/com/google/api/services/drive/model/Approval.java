package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class Approval extends GenericJson {

    @Key
    private String approvalId;

    @Key
    private String completeTime;

    @Key
    private String createTime;

    @Key
    private String dueTime;

    @Key
    private User initiator;

    @Key
    private String kind;

    @Key
    private String modifyTime;

    @Key
    private List<ReviewerResponse> reviewerResponses;

    @Key
    private String status;

    @Key
    private String targetFileId;

    public String getApprovalId() {
        return this.approvalId;
    }

    public Approval setApprovalId(String str) {
        this.approvalId = str;
        return this;
    }

    public String getCompleteTime() {
        return this.completeTime;
    }

    public Approval setCompleteTime(String str) {
        this.completeTime = str;
        return this;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public Approval setCreateTime(String str) {
        this.createTime = str;
        return this;
    }

    public String getDueTime() {
        return this.dueTime;
    }

    public Approval setDueTime(String str) {
        this.dueTime = str;
        return this;
    }

    public User getInitiator() {
        return this.initiator;
    }

    public Approval setInitiator(User user) {
        this.initiator = user;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Approval setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public Approval setModifyTime(String str) {
        this.modifyTime = str;
        return this;
    }

    public List<ReviewerResponse> getReviewerResponses() {
        return this.reviewerResponses;
    }

    public Approval setReviewerResponses(List<ReviewerResponse> list) {
        this.reviewerResponses = list;
        return this;
    }

    public String getStatus() {
        return this.status;
    }

    public Approval setStatus(String str) {
        this.status = str;
        return this;
    }

    public String getTargetFileId() {
        return this.targetFileId;
    }

    public Approval setTargetFileId(String str) {
        this.targetFileId = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Approval set(String str, Object obj) {
        return (Approval) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Approval clone() {
        return (Approval) super.clone();
    }
}

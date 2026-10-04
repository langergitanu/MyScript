package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class AccessProposal extends GenericJson {

    @Key
    private String createTime;

    @Key
    private String fileId;

    @Key
    private String proposalId;

    @Key
    private String recipientEmailAddress;

    @Key
    private String requestMessage;

    @Key
    private String requesterEmailAddress;

    @Key
    private List<AccessProposalRoleAndView> rolesAndViews;

    public String getCreateTime() {
        return this.createTime;
    }

    public AccessProposal setCreateTime(String str) {
        this.createTime = str;
        return this;
    }

    public String getFileId() {
        return this.fileId;
    }

    public AccessProposal setFileId(String str) {
        this.fileId = str;
        return this;
    }

    public String getProposalId() {
        return this.proposalId;
    }

    public AccessProposal setProposalId(String str) {
        this.proposalId = str;
        return this;
    }

    public String getRecipientEmailAddress() {
        return this.recipientEmailAddress;
    }

    public AccessProposal setRecipientEmailAddress(String str) {
        this.recipientEmailAddress = str;
        return this;
    }

    public String getRequestMessage() {
        return this.requestMessage;
    }

    public AccessProposal setRequestMessage(String str) {
        this.requestMessage = str;
        return this;
    }

    public String getRequesterEmailAddress() {
        return this.requesterEmailAddress;
    }

    public AccessProposal setRequesterEmailAddress(String str) {
        this.requesterEmailAddress = str;
        return this;
    }

    public List<AccessProposalRoleAndView> getRolesAndViews() {
        return this.rolesAndViews;
    }

    public AccessProposal setRolesAndViews(List<AccessProposalRoleAndView> list) {
        this.rolesAndViews = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public AccessProposal set(String str, Object obj) {
        return (AccessProposal) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public AccessProposal clone() {
        return (AccessProposal) super.clone();
    }
}

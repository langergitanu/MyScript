package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class Reply extends GenericJson {

    @Key
    private String action;

    @Key
    private String assigneeEmailAddress;

    @Key
    private User author;

    @Key
    private String content;

    @Key
    private DateTime createdTime;

    @Key
    private Boolean deleted;

    @Key
    private String htmlContent;

    /* JADX INFO: renamed from: id */
    @Key
    private String f971id;

    @Key
    private String kind;

    @Key
    private List<String> mentionedEmailAddresses;

    @Key
    private DateTime modifiedTime;

    public String getAction() {
        return this.action;
    }

    public Reply setAction(String str) {
        this.action = str;
        return this;
    }

    public String getAssigneeEmailAddress() {
        return this.assigneeEmailAddress;
    }

    public Reply setAssigneeEmailAddress(String str) {
        this.assigneeEmailAddress = str;
        return this;
    }

    public User getAuthor() {
        return this.author;
    }

    public Reply setAuthor(User user) {
        this.author = user;
        return this;
    }

    public String getContent() {
        return this.content;
    }

    public Reply setContent(String str) {
        this.content = str;
        return this;
    }

    public DateTime getCreatedTime() {
        return this.createdTime;
    }

    public Reply setCreatedTime(DateTime dateTime) {
        this.createdTime = dateTime;
        return this;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public Reply setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public String getHtmlContent() {
        return this.htmlContent;
    }

    public Reply setHtmlContent(String str) {
        this.htmlContent = str;
        return this;
    }

    public String getId() {
        return this.f971id;
    }

    public Reply setId(String str) {
        this.f971id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Reply setKind(String str) {
        this.kind = str;
        return this;
    }

    public List<String> getMentionedEmailAddresses() {
        return this.mentionedEmailAddresses;
    }

    public Reply setMentionedEmailAddresses(List<String> list) {
        this.mentionedEmailAddresses = list;
        return this;
    }

    public DateTime getModifiedTime() {
        return this.modifiedTime;
    }

    public Reply setModifiedTime(DateTime dateTime) {
        this.modifiedTime = dateTime;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Reply set(String str, Object obj) {
        return (Reply) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Reply clone() {
        return (Reply) super.clone();
    }
}

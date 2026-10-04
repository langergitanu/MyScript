package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes6.dex */
public final class ReviewerResponse extends GenericJson {

    @Key
    private String kind;

    @Key
    private String response;

    @Key
    private User reviewer;

    public String getKind() {
        return this.kind;
    }

    public ReviewerResponse setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getResponse() {
        return this.response;
    }

    public ReviewerResponse setResponse(String str) {
        this.response = str;
        return this;
    }

    public User getReviewer() {
        return this.reviewer;
    }

    public ReviewerResponse setReviewer(User user) {
        this.reviewer = user;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ReviewerResponse set(String str, Object obj) {
        return (ReviewerResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ReviewerResponse clone() {
        return (ReviewerResponse) super.clone();
    }
}

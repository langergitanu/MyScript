package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class ApprovalList extends GenericJson {

    @Key
    private List<Approval> items;

    @Key
    private String kind;

    @Key
    private String nextPageToken;

    static {
        Data.nullOf(Approval.class);
    }

    public List<Approval> getItems() {
        return this.items;
    }

    public ApprovalList setItems(List<Approval> list) {
        this.items = list;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public ApprovalList setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public ApprovalList setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ApprovalList set(String str, Object obj) {
        return (ApprovalList) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ApprovalList clone() {
        return (ApprovalList) super.clone();
    }
}

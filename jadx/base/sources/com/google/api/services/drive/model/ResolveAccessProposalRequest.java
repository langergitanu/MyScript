package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class ResolveAccessProposalRequest extends GenericJson {

    @Key
    private String action;

    @Key
    private List<String> role;

    @Key
    private Boolean sendNotification;

    @Key
    private String view;

    public String getAction() {
        return this.action;
    }

    public ResolveAccessProposalRequest setAction(String str) {
        this.action = str;
        return this;
    }

    public List<String> getRole() {
        return this.role;
    }

    public ResolveAccessProposalRequest setRole(List<String> list) {
        this.role = list;
        return this;
    }

    public Boolean getSendNotification() {
        return this.sendNotification;
    }

    public ResolveAccessProposalRequest setSendNotification(Boolean bool) {
        this.sendNotification = bool;
        return this;
    }

    public String getView() {
        return this.view;
    }

    public ResolveAccessProposalRequest setView(String str) {
        this.view = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ResolveAccessProposalRequest set(String str, Object obj) {
        return (ResolveAccessProposalRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ResolveAccessProposalRequest clone() {
        return (ResolveAccessProposalRequest) super.clone();
    }
}

package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes6.dex */
public final class AccessProposalRoleAndView extends GenericJson {

    @Key
    private String role;

    @Key
    private String view;

    public String getRole() {
        return this.role;
    }

    public AccessProposalRoleAndView setRole(String str) {
        this.role = str;
        return this;
    }

    public String getView() {
        return this.view;
    }

    public AccessProposalRoleAndView setView(String str) {
        this.view = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public AccessProposalRoleAndView set(String str, Object obj) {
        return (AccessProposalRoleAndView) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public AccessProposalRoleAndView clone() {
        return (AccessProposalRoleAndView) super.clone();
    }
}

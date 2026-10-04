package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class ListAccessProposalsResponse extends GenericJson {

    @Key
    private List<AccessProposal> accessProposals;

    @Key
    private String nextPageToken;

    static {
        Data.nullOf(AccessProposal.class);
    }

    public List<AccessProposal> getAccessProposals() {
        return this.accessProposals;
    }

    public ListAccessProposalsResponse setAccessProposals(List<AccessProposal> list) {
        this.accessProposals = list;
        return this;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public ListAccessProposalsResponse setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListAccessProposalsResponse set(String str, Object obj) {
        return (ListAccessProposalsResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListAccessProposalsResponse clone() {
        return (ListAccessProposalsResponse) super.clone();
    }
}

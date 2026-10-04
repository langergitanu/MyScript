package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes6.dex */
public final class DownloadRestrictionsMetadata extends GenericJson {

    @Key
    private DownloadRestriction effectiveDownloadRestrictionWithContext;

    @Key
    private DownloadRestriction itemDownloadRestriction;

    public DownloadRestriction getEffectiveDownloadRestrictionWithContext() {
        return this.effectiveDownloadRestrictionWithContext;
    }

    public DownloadRestrictionsMetadata setEffectiveDownloadRestrictionWithContext(DownloadRestriction downloadRestriction) {
        this.effectiveDownloadRestrictionWithContext = downloadRestriction;
        return this;
    }

    public DownloadRestriction getItemDownloadRestriction() {
        return this.itemDownloadRestriction;
    }

    public DownloadRestrictionsMetadata setItemDownloadRestriction(DownloadRestriction downloadRestriction) {
        this.itemDownloadRestriction = downloadRestriction;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public DownloadRestrictionsMetadata set(String str, Object obj) {
        return (DownloadRestrictionsMetadata) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public DownloadRestrictionsMetadata clone() {
        return (DownloadRestrictionsMetadata) super.clone();
    }
}

package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes6.dex */
public final class DownloadRestriction extends GenericJson {

    @Key
    private Boolean restrictedForReaders;

    @Key
    private Boolean restrictedForWriters;

    public Boolean getRestrictedForReaders() {
        return this.restrictedForReaders;
    }

    public DownloadRestriction setRestrictedForReaders(Boolean bool) {
        this.restrictedForReaders = bool;
        return this;
    }

    public Boolean getRestrictedForWriters() {
        return this.restrictedForWriters;
    }

    public DownloadRestriction setRestrictedForWriters(Boolean bool) {
        this.restrictedForWriters = bool;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public DownloadRestriction set(String str, Object obj) {
        return (DownloadRestriction) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public DownloadRestriction clone() {
        return (DownloadRestriction) super.clone();
    }
}

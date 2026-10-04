package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes6.dex */
public final class GenerateCseTokenResponse extends GenericJson {

    @JsonString
    @Key
    private Long currentKaclsId;

    @Key
    private String currentKaclsName;

    @Key
    private String fileId;

    @Key
    private String jwt;

    @Key
    private String kind;

    public Long getCurrentKaclsId() {
        return this.currentKaclsId;
    }

    public GenerateCseTokenResponse setCurrentKaclsId(Long l) {
        this.currentKaclsId = l;
        return this;
    }

    public String getCurrentKaclsName() {
        return this.currentKaclsName;
    }

    public GenerateCseTokenResponse setCurrentKaclsName(String str) {
        this.currentKaclsName = str;
        return this;
    }

    public String getFileId() {
        return this.fileId;
    }

    public GenerateCseTokenResponse setFileId(String str) {
        this.fileId = str;
        return this;
    }

    public String getJwt() {
        return this.jwt;
    }

    public GenerateCseTokenResponse setJwt(String str) {
        this.jwt = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public GenerateCseTokenResponse setKind(String str) {
        this.kind = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public GenerateCseTokenResponse set(String str, Object obj) {
        return (GenerateCseTokenResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public GenerateCseTokenResponse clone() {
        return (GenerateCseTokenResponse) super.clone();
    }
}

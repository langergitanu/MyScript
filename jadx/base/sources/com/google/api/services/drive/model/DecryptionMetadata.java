package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes6.dex */
public final class DecryptionMetadata extends GenericJson {

    @Key
    private String aes256GcmChunkSize;

    @Key
    private String encryptionResourceKeyHash;

    @Key
    private String jwt;

    @JsonString
    @Key
    private Long kaclsId;

    @Key
    private String kaclsName;

    @Key
    private String keyFormat;

    @Key
    private String wrappedKey;

    public String getAes256GcmChunkSize() {
        return this.aes256GcmChunkSize;
    }

    public DecryptionMetadata setAes256GcmChunkSize(String str) {
        this.aes256GcmChunkSize = str;
        return this;
    }

    public String getEncryptionResourceKeyHash() {
        return this.encryptionResourceKeyHash;
    }

    public DecryptionMetadata setEncryptionResourceKeyHash(String str) {
        this.encryptionResourceKeyHash = str;
        return this;
    }

    public String getJwt() {
        return this.jwt;
    }

    public DecryptionMetadata setJwt(String str) {
        this.jwt = str;
        return this;
    }

    public Long getKaclsId() {
        return this.kaclsId;
    }

    public DecryptionMetadata setKaclsId(Long l) {
        this.kaclsId = l;
        return this;
    }

    public String getKaclsName() {
        return this.kaclsName;
    }

    public DecryptionMetadata setKaclsName(String str) {
        this.kaclsName = str;
        return this;
    }

    public String getKeyFormat() {
        return this.keyFormat;
    }

    public DecryptionMetadata setKeyFormat(String str) {
        this.keyFormat = str;
        return this;
    }

    public String getWrappedKey() {
        return this.wrappedKey;
    }

    public DecryptionMetadata setWrappedKey(String str) {
        this.wrappedKey = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public DecryptionMetadata set(String str, Object obj) {
        return (DecryptionMetadata) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public DecryptionMetadata clone() {
        return (DecryptionMetadata) super.clone();
    }
}

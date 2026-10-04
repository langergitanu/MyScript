package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes6.dex */
public final class ClientEncryptionDetails extends GenericJson {

    @Key
    private DecryptionMetadata decryptionMetadata;

    @Key
    private String encryptionState;

    public DecryptionMetadata getDecryptionMetadata() {
        return this.decryptionMetadata;
    }

    public ClientEncryptionDetails setDecryptionMetadata(DecryptionMetadata decryptionMetadata) {
        this.decryptionMetadata = decryptionMetadata;
        return this;
    }

    public String getEncryptionState() {
        return this.encryptionState;
    }

    public ClientEncryptionDetails setEncryptionState(String str) {
        this.encryptionState = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ClientEncryptionDetails set(String str, Object obj) {
        return (ClientEncryptionDetails) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ClientEncryptionDetails clone() {
        return (ClientEncryptionDetails) super.clone();
    }
}

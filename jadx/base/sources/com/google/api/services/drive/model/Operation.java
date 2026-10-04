package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class Operation extends GenericJson {

    @Key
    private Boolean done;

    @Key
    private Status error;

    @Key
    private Map<String, Object> metadata;

    @Key
    private String name;

    @Key
    private Map<String, Object> response;

    public Boolean getDone() {
        return this.done;
    }

    public Operation setDone(Boolean bool) {
        this.done = bool;
        return this;
    }

    public Status getError() {
        return this.error;
    }

    public Operation setError(Status status) {
        this.error = status;
        return this;
    }

    public Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public Operation setMetadata(Map<String, Object> map) {
        this.metadata = map;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Operation setName(String str) {
        this.name = str;
        return this;
    }

    public Map<String, Object> getResponse() {
        return this.response;
    }

    public Operation setResponse(Map<String, Object> map) {
        this.response = map;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Operation set(String str, Object obj) {
        return (Operation) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Operation clone() {
        return (Operation) super.clone();
    }
}

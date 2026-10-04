package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class Status extends GenericJson {

    @Key
    private Integer code;

    @Key
    private List<Map<String, Object>> details;

    @Key
    private String message;

    public Integer getCode() {
        return this.code;
    }

    public Status setCode(Integer num) {
        this.code = num;
        return this;
    }

    public List<Map<String, Object>> getDetails() {
        return this.details;
    }

    public Status setDetails(List<Map<String, Object>> list) {
        this.details = list;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public Status setMessage(String str) {
        this.message = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Status set(String str, Object obj) {
        return (Status) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Status clone() {
        return (Status) super.clone();
    }
}

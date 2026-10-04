package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class Json {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Json(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Json json) {
        if (json == null) {
            return 0L;
        }
        return json.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Json(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public JsonType getType() {
        return JsonType.swigToEnum(ATKCoreJNI.Json_getType(this.swigCPtr, this));
    }

    public String getStringValue() {
        return new String(ATKCoreJNI.Json_getStringValue(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public double getNumberValue() {
        return ATKCoreJNI.Json_getNumberValue(this.swigCPtr, this);
    }

    public boolean getBooleanValue() {
        return ATKCoreJNI.Json_getBooleanValue(this.swigCPtr, this);
    }

    public JsonObjectIterator getObjectEntries() {
        return new JsonObjectIterator(ATKCoreJNI.Json_getObjectEntries(this.swigCPtr, this), true);
    }

    public Json getObjectEntryValue(String str) {
        return new Json(ATKCoreJNI.Json_getObjectEntryValue(this.swigCPtr, this, str.getBytes()), true);
    }

    public void putObjectEntry(String str, Json json) {
        ATKCoreJNI.Json_putObjectEntry(this.swigCPtr, this, str.getBytes(), getCPtr(json), json);
    }

    public void removeObjectEntry(String str) {
        ATKCoreJNI.Json_removeObjectEntry(this.swigCPtr, this, str.getBytes());
    }

    public int getArrayLength() {
        return ATKCoreJNI.Json_getArrayLength(this.swigCPtr, this);
    }

    public Json getArrayValueAt(int i) {
        return new Json(ATKCoreJNI.Json_getArrayValueAt(this.swigCPtr, this, i), true);
    }

    public void insertArrayValueAt(int i, Json json) {
        ATKCoreJNI.Json_insertArrayValueAt(this.swigCPtr, this, i, getCPtr(json), json);
    }

    public void removeArrayValueAt(int i) {
        ATKCoreJNI.Json_removeArrayValueAt(this.swigCPtr, this, i);
    }

    public long getStringValueAsTimestamp() {
        return ATKCoreJNI.Json_getStringValueAsTimestamp(this.swigCPtr, this);
    }

    public long getIntegerValue() {
        return ATKCoreJNI.Json_getIntegerValue(this.swigCPtr, this);
    }

    public Json getValueForPath(String str) {
        return new Json(ATKCoreJNI.Json_getValueForPath(this.swigCPtr, this, str.getBytes()), true);
    }

    public void setValueForPath(String str, Json json) {
        ATKCoreJNI.Json_setValueForPath(this.swigCPtr, this, str.getBytes(), getCPtr(json), json);
    }

    public void removeValueForPath(String str) {
        ATKCoreJNI.Json_removeValueForPath(this.swigCPtr, this, str.getBytes());
    }

    public String getStringValueForPath(String str) {
        return new String(ATKCoreJNI.Json_getStringValueForPath(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public void setStringValueForPath(String str, String str2) {
        ATKCoreJNI.Json_setStringValueForPath(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public double getNumberValueForPath(String str) {
        return ATKCoreJNI.Json_getNumberValueForPath(this.swigCPtr, this, str.getBytes());
    }

    public void setNumberValueForPath(String str, double d) {
        ATKCoreJNI.Json_setNumberValueForPath(this.swigCPtr, this, str.getBytes(), d);
    }

    public boolean getBooleanValueForPath(String str) {
        return ATKCoreJNI.Json_getBooleanValueForPath(this.swigCPtr, this, str.getBytes());
    }

    public void setBooleanValueForPath(String str, boolean z) {
        ATKCoreJNI.Json_setBooleanValueForPath(this.swigCPtr, this, str.getBytes(), z);
    }

    public long getIntegerValueForPath(String str) {
        return ATKCoreJNI.Json_getIntegerValueForPath(this.swigCPtr, this, str.getBytes());
    }

    public void setIntegerValueForPath(String str, long j) {
        ATKCoreJNI.Json_setIntegerValueForPath(this.swigCPtr, this, str.getBytes(), j);
    }

    public String getStringValueForPath2(String str, String str2) {
        return new String(ATKCoreJNI.Json_getStringValueForPath2(this.swigCPtr, this, str.getBytes(), str2.getBytes()), StandardCharsets.UTF_8);
    }

    public double getNumberValueForPath2(String str, double d) {
        return ATKCoreJNI.Json_getNumberValueForPath2(this.swigCPtr, this, str.getBytes(), d);
    }

    public boolean getBooleanValueForPath2(String str, boolean z) {
        return ATKCoreJNI.Json_getBooleanValueForPath2(this.swigCPtr, this, str.getBytes(), z);
    }

    public long getIntegerValueForPath2(String str, long j) {
        return ATKCoreJNI.Json_getIntegerValueForPath2(this.swigCPtr, this, str.getBytes(), j);
    }

    public boolean equals(Json json) {
        return ATKCoreJNI.Json_equals(this.swigCPtr, this, getCPtr(json), json);
    }

    public static Json createNull() {
        return new Json(ATKCoreJNI.Json_createNull(), true);
    }

    public static Json createString(String str) {
        return new Json(ATKCoreJNI.Json_createString(str.getBytes()), true);
    }

    public static Json createNumber(double d) {
        return new Json(ATKCoreJNI.Json_createNumber(d), true);
    }

    public static Json createBoolean(boolean z) {
        return new Json(ATKCoreJNI.Json_createBoolean(z), true);
    }

    public static Json createObject() {
        return new Json(ATKCoreJNI.Json_createObject(), true);
    }

    public static Json createArray() {
        return new Json(ATKCoreJNI.Json_createArray(), true);
    }

    public static Json parse(String str) {
        return new Json(ATKCoreJNI.Json_parse(str.getBytes()), true);
    }

    public static Json createStringFromTimestamp(long j) {
        return new Json(ATKCoreJNI.Json_createStringFromTimestamp(j), true);
    }

    public static Json createInteger(long j) {
        return new Json(ATKCoreJNI.Json_createInteger(j), true);
    }

    public static Json generateUUID() {
        return new Json(ATKCoreJNI.Json_generateUUID(), true);
    }

    public Json(Json json) {
        this(ATKCoreJNI.new_Json(getCPtr(json), json), true);
    }
}

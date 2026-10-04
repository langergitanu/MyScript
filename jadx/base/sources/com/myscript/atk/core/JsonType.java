package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum JsonType {
    JSON_NULL(0),
    JSON_STRING(1),
    JSON_NUMBER(2),
    JSON_BOOLEAN(3),
    JSON_OBJECT(4),
    JSON_ARRAY(5);

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static JsonType swigToEnum(int i) {
        JsonType[] jsonTypeArr = (JsonType[]) JsonType.class.getEnumConstants();
        if (i < jsonTypeArr.length && i >= 0) {
            JsonType jsonType = jsonTypeArr[i];
            if (jsonType.swigValue == i) {
                return jsonType;
            }
        }
        for (JsonType jsonType2 : jsonTypeArr) {
            if (jsonType2.swigValue == i) {
                return jsonType2;
            }
        }
        throw new IllegalArgumentException("No enum " + JsonType.class + " with value " + i);
    }

    JsonType() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    JsonType(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    JsonType(JsonType jsonType) {
        int i = jsonType.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}

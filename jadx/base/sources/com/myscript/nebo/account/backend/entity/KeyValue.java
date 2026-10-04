package com.myscript.nebo.account.backend.entity;

import com.google.gson.annotations.SerializedName;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyValue.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/entity/KeyValue;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class KeyValue {

    @SerializedName(SubscriberAttributeKt.JSON_NAME_KEY)
    private final String key;

    @SerializedName("value")
    private final String value;

    public static /* synthetic */ KeyValue copy$default(KeyValue keyValue, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = keyValue.key;
        }
        if ((i & 2) != 0) {
            str2 = keyValue.value;
        }
        return keyValue.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final KeyValue copy(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new KeyValue(key, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyValue)) {
            return false;
        }
        KeyValue keyValue = (KeyValue) other;
        return Intrinsics.areEqual(this.key, keyValue.key) && Intrinsics.areEqual(this.value, keyValue.value);
    }

    public int hashCode() {
        int iHashCode = this.key.hashCode() * 31;
        String str = this.value;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "KeyValue(key=" + this.key + ", value=" + this.value + ")";
    }

    public KeyValue(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.value = str;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }
}

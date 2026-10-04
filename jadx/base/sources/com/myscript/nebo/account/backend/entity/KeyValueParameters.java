package com.myscript.nebo.account.backend.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyValue.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/entity/KeyValueParameters;", "", "value", "", "writeOnce", "", "<init>", "(Ljava/lang/String;Z)V", "getValue", "()Ljava/lang/String;", "getWriteOnce", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class KeyValueParameters {

    @SerializedName("value")
    private final String value;

    @SerializedName("writeOnce")
    private final boolean writeOnce;

    public static /* synthetic */ KeyValueParameters copy$default(KeyValueParameters keyValueParameters, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = keyValueParameters.value;
        }
        if ((i & 2) != 0) {
            z = keyValueParameters.writeOnce;
        }
        return keyValueParameters.copy(str, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getWriteOnce() {
        return this.writeOnce;
    }

    public final KeyValueParameters copy(String value, boolean writeOnce) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new KeyValueParameters(value, writeOnce);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyValueParameters)) {
            return false;
        }
        KeyValueParameters keyValueParameters = (KeyValueParameters) other;
        return Intrinsics.areEqual(this.value, keyValueParameters.value) && this.writeOnce == keyValueParameters.writeOnce;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + Boolean.hashCode(this.writeOnce);
    }

    public String toString() {
        return "KeyValueParameters(value=" + this.value + ", writeOnce=" + this.writeOnce + ")";
    }

    public KeyValueParameters(String value, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.writeOnce = z;
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean getWriteOnce() {
        return this.writeOnce;
    }
}

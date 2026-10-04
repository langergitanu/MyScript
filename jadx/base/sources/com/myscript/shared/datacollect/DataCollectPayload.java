package com.myscript.shared.datacollect;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataCollectPayload.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/shared/datacollect/DataCollectPayload;", "", "uuid", "", "signature", "namespace", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "getSignature", "getNamespace", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class DataCollectPayload {

    @SerializedName("namespace")
    private final String namespace;

    @SerializedName("signature")
    private final String signature;

    @SerializedName("uuid")
    private final String uuid;

    public static /* synthetic */ DataCollectPayload copy$default(DataCollectPayload dataCollectPayload, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dataCollectPayload.uuid;
        }
        if ((i & 2) != 0) {
            str2 = dataCollectPayload.signature;
        }
        if ((i & 4) != 0) {
            str3 = dataCollectPayload.namespace;
        }
        return dataCollectPayload.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNamespace() {
        return this.namespace;
    }

    public final DataCollectPayload copy(String uuid, String signature, String namespace) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(signature, "signature");
        return new DataCollectPayload(uuid, signature, namespace);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataCollectPayload)) {
            return false;
        }
        DataCollectPayload dataCollectPayload = (DataCollectPayload) other;
        return Intrinsics.areEqual(this.uuid, dataCollectPayload.uuid) && Intrinsics.areEqual(this.signature, dataCollectPayload.signature) && Intrinsics.areEqual(this.namespace, dataCollectPayload.namespace);
    }

    public int hashCode() {
        int iHashCode = ((this.uuid.hashCode() * 31) + this.signature.hashCode()) * 31;
        String str = this.namespace;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DataCollectPayload(uuid=" + this.uuid + ", signature=" + this.signature + ", namespace=" + this.namespace + ")";
    }

    public DataCollectPayload(String uuid, String signature, String str) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(signature, "signature");
        this.uuid = uuid;
        this.signature = signature;
        this.namespace = str;
    }

    public /* synthetic */ DataCollectPayload(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getNamespace() {
        return this.namespace;
    }
}

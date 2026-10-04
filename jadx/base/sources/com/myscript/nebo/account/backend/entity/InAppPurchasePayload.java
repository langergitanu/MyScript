package com.myscript.nebo.account.backend.entity;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InAppPurchasePayload.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/entity/InAppPurchasePayload;", "", "token", "", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "productId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getPackageName", "getProductId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class InAppPurchasePayload {

    @SerializedName(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME)
    private final String packageName;

    @SerializedName("productId")
    private final String productId;

    @SerializedName("token")
    private final String token;

    public static /* synthetic */ InAppPurchasePayload copy$default(InAppPurchasePayload inAppPurchasePayload, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inAppPurchasePayload.token;
        }
        if ((i & 2) != 0) {
            str2 = inAppPurchasePayload.packageName;
        }
        if ((i & 4) != 0) {
            str3 = inAppPurchasePayload.productId;
        }
        return inAppPurchasePayload.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    public final InAppPurchasePayload copy(String token, String packageName, String productId) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(productId, "productId");
        return new InAppPurchasePayload(token, packageName, productId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InAppPurchasePayload)) {
            return false;
        }
        InAppPurchasePayload inAppPurchasePayload = (InAppPurchasePayload) other;
        return Intrinsics.areEqual(this.token, inAppPurchasePayload.token) && Intrinsics.areEqual(this.packageName, inAppPurchasePayload.packageName) && Intrinsics.areEqual(this.productId, inAppPurchasePayload.productId);
    }

    public int hashCode() {
        return (((this.token.hashCode() * 31) + this.packageName.hashCode()) * 31) + this.productId.hashCode();
    }

    public String toString() {
        return "InAppPurchasePayload(token=" + this.token + ", packageName=" + this.packageName + ", productId=" + this.productId + ")";
    }

    public InAppPurchasePayload(String token, String packageName, String productId) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(productId, "productId");
        this.token = token;
        this.packageName = packageName;
        this.productId = productId;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getProductId() {
        return this.productId;
    }
}

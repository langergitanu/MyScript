package com.myscript.nebo.account.backend.entity;

import com.google.gson.annotations.SerializedName;
import com.myscript.nebo.account.backend.entity.NeboAccount;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InAppPurchaseResponse.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/entity/InAppPurchaseResponse;", "", "inApps", "", "Lcom/myscript/nebo/account/backend/entity/InApp;", "features", "Lcom/myscript/nebo/account/backend/entity/NeboAccount$Feature;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getInApps", "()Ljava/util/List;", "getFeatures", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class InAppPurchaseResponse {

    @SerializedName("features")
    private final List<NeboAccount.Feature> features;

    @SerializedName("inapps")
    private final List<InApp> inApps;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InAppPurchaseResponse copy$default(InAppPurchaseResponse inAppPurchaseResponse, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = inAppPurchaseResponse.inApps;
        }
        if ((i & 2) != 0) {
            list2 = inAppPurchaseResponse.features;
        }
        return inAppPurchaseResponse.copy(list, list2);
    }

    public final List<InApp> component1() {
        return this.inApps;
    }

    public final List<NeboAccount.Feature> component2() {
        return this.features;
    }

    public final InAppPurchaseResponse copy(List<InApp> inApps, List<NeboAccount.Feature> features) {
        Intrinsics.checkNotNullParameter(inApps, "inApps");
        Intrinsics.checkNotNullParameter(features, "features");
        return new InAppPurchaseResponse(inApps, features);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InAppPurchaseResponse)) {
            return false;
        }
        InAppPurchaseResponse inAppPurchaseResponse = (InAppPurchaseResponse) other;
        return Intrinsics.areEqual(this.inApps, inAppPurchaseResponse.inApps) && Intrinsics.areEqual(this.features, inAppPurchaseResponse.features);
    }

    public int hashCode() {
        return (this.inApps.hashCode() * 31) + this.features.hashCode();
    }

    public String toString() {
        return "InAppPurchaseResponse(inApps=" + this.inApps + ", features=" + this.features + ")";
    }

    public InAppPurchaseResponse(List<InApp> inApps, List<NeboAccount.Feature> features) {
        Intrinsics.checkNotNullParameter(inApps, "inApps");
        Intrinsics.checkNotNullParameter(features, "features");
        this.inApps = inApps;
        this.features = features;
    }

    public final List<InApp> getInApps() {
        return this.inApps;
    }

    public final List<NeboAccount.Feature> getFeatures() {
        return this.features;
    }
}

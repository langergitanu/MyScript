package com.myscript.nebo.account.backend.entity;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InApp.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003Je\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fHÆ\u0001J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020'HÖ\u0081\u0004J\n\u0010(\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/entity/InApp;", "", "subscriptionId", "", "endOfValidity", "endOfIntroOfferPeriod", "endOfTrialPeriod", "endOfGracefulPeriod", "store", "Lcom/myscript/nebo/account/backend/entity/Store;", "details", "customAttributes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/myscript/nebo/account/backend/entity/Store;Ljava/lang/String;Ljava/util/Map;)V", "getSubscriptionId", "()Ljava/lang/String;", "getEndOfValidity", "getEndOfIntroOfferPeriod", "getEndOfTrialPeriod", "getEndOfGracefulPeriod", "getStore", "()Lcom/myscript/nebo/account/backend/entity/Store;", "getDetails", "getCustomAttributes", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class InApp {

    @SerializedName("customAttributes")
    private final Map<String, String> customAttributes;

    @SerializedName("details")
    private final String details;

    @SerializedName("endOfGracefullPeriod")
    private final String endOfGracefulPeriod;

    @SerializedName("endOfIntroOfferPeriod")
    private final String endOfIntroOfferPeriod;

    @SerializedName("endOfTrialPeriod")
    private final String endOfTrialPeriod;

    @SerializedName("endOfValidity")
    private final String endOfValidity;

    @SerializedName("store")
    private final Store store;

    @SerializedName("subscriptionId")
    private final String subscriptionId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InApp copy$default(InApp inApp, String str, String str2, String str3, String str4, String str5, Store store, String str6, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inApp.subscriptionId;
        }
        if ((i & 2) != 0) {
            str2 = inApp.endOfValidity;
        }
        if ((i & 4) != 0) {
            str3 = inApp.endOfIntroOfferPeriod;
        }
        if ((i & 8) != 0) {
            str4 = inApp.endOfTrialPeriod;
        }
        if ((i & 16) != 0) {
            str5 = inApp.endOfGracefulPeriod;
        }
        if ((i & 32) != 0) {
            store = inApp.store;
        }
        if ((i & 64) != 0) {
            str6 = inApp.details;
        }
        if ((i & 128) != 0) {
            map = inApp.customAttributes;
        }
        String str7 = str6;
        Map map2 = map;
        String str8 = str5;
        Store store2 = store;
        return inApp.copy(str, str2, str3, str4, str8, store2, str7, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEndOfValidity() {
        return this.endOfValidity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEndOfIntroOfferPeriod() {
        return this.endOfIntroOfferPeriod;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEndOfTrialPeriod() {
        return this.endOfTrialPeriod;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEndOfGracefulPeriod() {
        return this.endOfGracefulPeriod;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Store getStore() {
        return this.store;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    public final Map<String, String> component8() {
        return this.customAttributes;
    }

    public final InApp copy(String subscriptionId, String endOfValidity, String endOfIntroOfferPeriod, String endOfTrialPeriod, String endOfGracefulPeriod, Store store, String details, Map<String, String> customAttributes) {
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullParameter(endOfValidity, "endOfValidity");
        Intrinsics.checkNotNullParameter(endOfIntroOfferPeriod, "endOfIntroOfferPeriod");
        Intrinsics.checkNotNullParameter(endOfTrialPeriod, "endOfTrialPeriod");
        Intrinsics.checkNotNullParameter(endOfGracefulPeriod, "endOfGracefulPeriod");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(customAttributes, "customAttributes");
        return new InApp(subscriptionId, endOfValidity, endOfIntroOfferPeriod, endOfTrialPeriod, endOfGracefulPeriod, store, details, customAttributes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InApp)) {
            return false;
        }
        InApp inApp = (InApp) other;
        return Intrinsics.areEqual(this.subscriptionId, inApp.subscriptionId) && Intrinsics.areEqual(this.endOfValidity, inApp.endOfValidity) && Intrinsics.areEqual(this.endOfIntroOfferPeriod, inApp.endOfIntroOfferPeriod) && Intrinsics.areEqual(this.endOfTrialPeriod, inApp.endOfTrialPeriod) && Intrinsics.areEqual(this.endOfGracefulPeriod, inApp.endOfGracefulPeriod) && this.store == inApp.store && Intrinsics.areEqual(this.details, inApp.details) && Intrinsics.areEqual(this.customAttributes, inApp.customAttributes);
    }

    public int hashCode() {
        return (((((((((((((this.subscriptionId.hashCode() * 31) + this.endOfValidity.hashCode()) * 31) + this.endOfIntroOfferPeriod.hashCode()) * 31) + this.endOfTrialPeriod.hashCode()) * 31) + this.endOfGracefulPeriod.hashCode()) * 31) + this.store.hashCode()) * 31) + this.details.hashCode()) * 31) + this.customAttributes.hashCode();
    }

    public String toString() {
        return "InApp(subscriptionId=" + this.subscriptionId + ", endOfValidity=" + this.endOfValidity + ", endOfIntroOfferPeriod=" + this.endOfIntroOfferPeriod + ", endOfTrialPeriod=" + this.endOfTrialPeriod + ", endOfGracefulPeriod=" + this.endOfGracefulPeriod + ", store=" + this.store + ", details=" + this.details + ", customAttributes=" + this.customAttributes + ")";
    }

    public InApp(String subscriptionId, String endOfValidity, String endOfIntroOfferPeriod, String endOfTrialPeriod, String endOfGracefulPeriod, Store store, String details, Map<String, String> customAttributes) {
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullParameter(endOfValidity, "endOfValidity");
        Intrinsics.checkNotNullParameter(endOfIntroOfferPeriod, "endOfIntroOfferPeriod");
        Intrinsics.checkNotNullParameter(endOfTrialPeriod, "endOfTrialPeriod");
        Intrinsics.checkNotNullParameter(endOfGracefulPeriod, "endOfGracefulPeriod");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(customAttributes, "customAttributes");
        this.subscriptionId = subscriptionId;
        this.endOfValidity = endOfValidity;
        this.endOfIntroOfferPeriod = endOfIntroOfferPeriod;
        this.endOfTrialPeriod = endOfTrialPeriod;
        this.endOfGracefulPeriod = endOfGracefulPeriod;
        this.store = store;
        this.details = details;
        this.customAttributes = customAttributes;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final String getEndOfValidity() {
        return this.endOfValidity;
    }

    public final String getEndOfIntroOfferPeriod() {
        return this.endOfIntroOfferPeriod;
    }

    public final String getEndOfTrialPeriod() {
        return this.endOfTrialPeriod;
    }

    public final String getEndOfGracefulPeriod() {
        return this.endOfGracefulPeriod;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getDetails() {
        return this.details;
    }

    public final Map<String, String> getCustomAttributes() {
        return this.customAttributes;
    }
}

package com.myscript.nebo.account.backend.entity;

import com.google.gson.annotations.SerializedName;
import com.survicate.surveys.surveys.FormSurveyFieldType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: InApp.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/entity/Store;", "", "<init>", "(Ljava/lang/String;I)V", "myscriptVolumePurchase", "appleNeboLegacy", "appleNeboInAppLegacy", "myscript", "apple", "google", FormSurveyFieldType.ORGANIZATION, "googleInApp", "GoogleInAppLegacy", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Store {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Store[] $VALUES;

    @SerializedName("MYSCRIPT_VOLUME_PURCHASE")
    public static final Store myscriptVolumePurchase = new Store("myscriptVolumePurchase", 0);

    @SerializedName("APPLE_NEBO_LEGACY")
    public static final Store appleNeboLegacy = new Store("appleNeboLegacy", 1);

    @SerializedName("APPLE_NEBO_IAP_LEGACY")
    public static final Store appleNeboInAppLegacy = new Store("appleNeboInAppLegacy", 2);

    @SerializedName("MYSCRIPT")
    public static final Store myscript = new Store("myscript", 3);

    @SerializedName("APPLE")
    public static final Store apple = new Store("apple", 4);

    @SerializedName("GOOGLE")
    public static final Store google = new Store("google", 5);

    @SerializedName("ORGANIZATION")
    public static final Store organization = new Store(FormSurveyFieldType.ORGANIZATION, 6);

    @SerializedName("GOOGLE_IAP")
    public static final Store googleInApp = new Store("googleInApp", 7);

    @SerializedName("GOOGLE_IAP_LEGACY")
    public static final Store GoogleInAppLegacy = new Store("GoogleInAppLegacy", 8);

    private static final /* synthetic */ Store[] $values() {
        return new Store[]{myscriptVolumePurchase, appleNeboLegacy, appleNeboInAppLegacy, myscript, apple, google, organization, googleInApp, GoogleInAppLegacy};
    }

    public static EnumEntries<Store> getEntries() {
        return $ENTRIES;
    }

    public static Store valueOf(String str) {
        return (Store) Enum.valueOf(Store.class, str);
    }

    public static Store[] values() {
        return (Store[]) $VALUES.clone();
    }

    private Store(String str, int i) {
    }

    static {
        Store[] storeArr$values = $values();
        $VALUES = storeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(storeArr$values);
    }
}

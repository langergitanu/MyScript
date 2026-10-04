package com.myscript.nebo.penpanel;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardSettings.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ShowKeyboardOnTapPreference;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "defaultValue", "", "<init>", "(Ljava/lang/String;Z)V", "getKey", "()Ljava/lang/String;", "getDefaultValue", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ShowKeyboardOnTapPreference {
    private final boolean defaultValue;
    private final String key;

    public static /* synthetic */ ShowKeyboardOnTapPreference copy$default(ShowKeyboardOnTapPreference showKeyboardOnTapPreference, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = showKeyboardOnTapPreference.key;
        }
        if ((i & 2) != 0) {
            z = showKeyboardOnTapPreference.defaultValue;
        }
        return showKeyboardOnTapPreference.copy(str, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getDefaultValue() {
        return this.defaultValue;
    }

    public final ShowKeyboardOnTapPreference copy(String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new ShowKeyboardOnTapPreference(key, defaultValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShowKeyboardOnTapPreference)) {
            return false;
        }
        ShowKeyboardOnTapPreference showKeyboardOnTapPreference = (ShowKeyboardOnTapPreference) other;
        return Intrinsics.areEqual(this.key, showKeyboardOnTapPreference.key) && this.defaultValue == showKeyboardOnTapPreference.defaultValue;
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + Boolean.hashCode(this.defaultValue);
    }

    public String toString() {
        return "ShowKeyboardOnTapPreference(key=" + this.key + ", defaultValue=" + this.defaultValue + ")";
    }

    public ShowKeyboardOnTapPreference(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.defaultValue = z;
    }

    public final boolean getDefaultValue() {
        return this.defaultValue;
    }

    public final String getKey() {
        return this.key;
    }
}

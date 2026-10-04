package com.myscript.nebo.sso.api.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSOAccount.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/entity/Consent;", "", "lastConsentDate", "", "version", "", "<init>", "(Ljava/lang/String;I)V", "getLastConsentDate", "()Ljava/lang/String;", "getVersion", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Consent {

    @SerializedName("lastConsentDate")
    private final String lastConsentDate;

    @SerializedName("version")
    private final int version;

    public static /* synthetic */ Consent copy$default(Consent consent, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consent.lastConsentDate;
        }
        if ((i2 & 2) != 0) {
            i = consent.version;
        }
        return consent.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLastConsentDate() {
        return this.lastConsentDate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final Consent copy(String lastConsentDate, int version) {
        Intrinsics.checkNotNullParameter(lastConsentDate, "lastConsentDate");
        return new Consent(lastConsentDate, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Consent)) {
            return false;
        }
        Consent consent = (Consent) other;
        return Intrinsics.areEqual(this.lastConsentDate, consent.lastConsentDate) && this.version == consent.version;
    }

    public int hashCode() {
        return (this.lastConsentDate.hashCode() * 31) + Integer.hashCode(this.version);
    }

    public String toString() {
        return "Consent(lastConsentDate=" + this.lastConsentDate + ", version=" + this.version + ")";
    }

    public Consent(String lastConsentDate, int i) {
        Intrinsics.checkNotNullParameter(lastConsentDate, "lastConsentDate");
        this.lastConsentDate = lastConsentDate;
        this.version = i;
    }

    public final String getLastConsentDate() {
        return this.lastConsentDate;
    }

    public final int getVersion() {
        return this.version;
    }
}

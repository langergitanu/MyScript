package com.survicate.surveys.entities.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Respondent.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000f¨\u0006\u0019"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/Respondent;", "", "uuid", "", "verificationTimeMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "getUuid", "()Ljava/lang/String;", "getVerificationTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "isVerified", "", "()Z", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/survicate/surveys/entities/models/Respondent;", "equals", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class Respondent {
    private final String uuid;
    private final Long verificationTimeMs;

    public static /* synthetic */ Respondent copy$default(Respondent respondent, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = respondent.uuid;
        }
        if ((i & 2) != 0) {
            l = respondent.verificationTimeMs;
        }
        return respondent.copy(str, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getVerificationTimeMs() {
        return this.verificationTimeMs;
    }

    public final Respondent copy(String uuid, Long verificationTimeMs) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new Respondent(uuid, verificationTimeMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Respondent)) {
            return false;
        }
        Respondent respondent = (Respondent) other;
        return Intrinsics.areEqual(this.uuid, respondent.uuid) && Intrinsics.areEqual(this.verificationTimeMs, respondent.verificationTimeMs);
    }

    public int hashCode() {
        int iHashCode = this.uuid.hashCode() * 31;
        Long l = this.verificationTimeMs;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "Respondent(uuid=" + this.uuid + ", verificationTimeMs=" + this.verificationTimeMs + ')';
    }

    public Respondent(String uuid, Long l) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.uuid = uuid;
        this.verificationTimeMs = l;
    }

    public /* synthetic */ Respondent(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : l);
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final Long getVerificationTimeMs() {
        return this.verificationTimeMs;
    }

    public final boolean isVerified() {
        return this.verificationTimeMs != null;
    }
}

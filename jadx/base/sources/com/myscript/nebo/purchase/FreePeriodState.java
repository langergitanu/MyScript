package com.myscript.nebo.purchase;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: SubscriptionRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0010J\u0010\u0010\u0017\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0010J8\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010¨\u0006#"}, m1599d2 = {"Lcom/myscript/nebo/purchase/FreePeriodState;", "", NotificationCompat.CATEGORY_STATUS, "Lcom/myscript/nebo/purchase/FreePeriodStatus;", "type", "Lcom/myscript/nebo/purchase/FreePeriodType;", "remainingDays", "Lkotlin/time/Duration;", "durationDays", "<init>", "(Lcom/myscript/nebo/purchase/FreePeriodStatus;Lcom/myscript/nebo/purchase/FreePeriodType;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStatus", "()Lcom/myscript/nebo/purchase/FreePeriodStatus;", "getType", "()Lcom/myscript/nebo/purchase/FreePeriodType;", "getRemainingDays-UwyO8pc", "()J", "J", "getDurationDays-UwyO8pc", "component1", "component2", "component3", "component3-UwyO8pc", "component4", "component4-UwyO8pc", "copy", "copy-VTINZ0E", "(Lcom/myscript/nebo/purchase/FreePeriodStatus;Lcom/myscript/nebo/purchase/FreePeriodType;JJ)Lcom/myscript/nebo/purchase/FreePeriodState;", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class FreePeriodState {
    public static final int $stable = 0;
    private final long durationDays;
    private final long remainingDays;
    private final FreePeriodStatus status;
    private final FreePeriodType type;

    public /* synthetic */ FreePeriodState(FreePeriodStatus freePeriodStatus, FreePeriodType freePeriodType, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(freePeriodStatus, freePeriodType, j, j2);
    }

    /* JADX INFO: renamed from: copy-VTINZ0E$default, reason: not valid java name */
    public static /* synthetic */ FreePeriodState m13340copyVTINZ0E$default(FreePeriodState freePeriodState, FreePeriodStatus freePeriodStatus, FreePeriodType freePeriodType, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            freePeriodStatus = freePeriodState.status;
        }
        if ((i & 2) != 0) {
            freePeriodType = freePeriodState.type;
        }
        if ((i & 4) != 0) {
            j = freePeriodState.remainingDays;
        }
        if ((i & 8) != 0) {
            j2 = freePeriodState.durationDays;
        }
        long j3 = j2;
        return freePeriodState.m13343copyVTINZ0E(freePeriodStatus, freePeriodType, j, j3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FreePeriodStatus getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FreePeriodType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3-UwyO8pc, reason: not valid java name and from getter */
    public final long getRemainingDays() {
        return this.remainingDays;
    }

    /* JADX INFO: renamed from: component4-UwyO8pc, reason: not valid java name and from getter */
    public final long getDurationDays() {
        return this.durationDays;
    }

    /* JADX INFO: renamed from: copy-VTINZ0E, reason: not valid java name */
    public final FreePeriodState m13343copyVTINZ0E(FreePeriodStatus status, FreePeriodType type, long remainingDays, long durationDays) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(type, "type");
        return new FreePeriodState(status, type, remainingDays, durationDays, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FreePeriodState)) {
            return false;
        }
        FreePeriodState freePeriodState = (FreePeriodState) other;
        return this.status == freePeriodState.status && this.type == freePeriodState.type && Duration.m15861equalsimpl0(this.remainingDays, freePeriodState.remainingDays) && Duration.m15861equalsimpl0(this.durationDays, freePeriodState.durationDays);
    }

    public int hashCode() {
        return (((((this.status.hashCode() * 31) + this.type.hashCode()) * 31) + Duration.m15877hashCodeimpl(this.remainingDays)) * 31) + Duration.m15877hashCodeimpl(this.durationDays);
    }

    public String toString() {
        return "FreePeriodState(status=" + this.status + ", type=" + this.type + ", remainingDays=" + Duration.m15896toStringimpl(this.remainingDays) + ", durationDays=" + Duration.m15896toStringimpl(this.durationDays) + ")";
    }

    private FreePeriodState(FreePeriodStatus status, FreePeriodType type, long j, long j2) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(type, "type");
        this.status = status;
        this.type = type;
        this.remainingDays = j;
        this.durationDays = j2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FreePeriodState(FreePeriodStatus freePeriodStatus, FreePeriodType freePeriodType, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long duration;
        FreePeriodStatus freePeriodStatus2 = (i & 1) != 0 ? FreePeriodStatus.Unknown : freePeriodStatus;
        FreePeriodType freePeriodType2 = (i & 2) != 0 ? FreePeriodType.None : freePeriodType;
        long jM15951getZEROUwyO8pc = (i & 4) != 0 ? Duration.INSTANCE.m15951getZEROUwyO8pc() : j;
        if ((i & 8) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            duration = DurationKt.toDuration(0, DurationUnit.DAYS);
        } else {
            duration = j2;
        }
        this(freePeriodStatus2, freePeriodType2, jM15951getZEROUwyO8pc, duration, null);
    }

    public final FreePeriodStatus getStatus() {
        return this.status;
    }

    public final FreePeriodType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: getRemainingDays-UwyO8pc, reason: not valid java name */
    public final long m13345getRemainingDaysUwyO8pc() {
        return this.remainingDays;
    }

    /* JADX INFO: renamed from: getDurationDays-UwyO8pc, reason: not valid java name */
    public final long m13344getDurationDaysUwyO8pc() {
        return this.durationDays;
    }
}

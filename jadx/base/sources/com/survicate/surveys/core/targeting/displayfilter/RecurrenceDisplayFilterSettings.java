package com.survicate.surveys.core.targeting.displayfilter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecurrenceDisplayFilterSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J:\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/RecurrenceDisplayFilterSettings;", "", "recurring", "", "recurringPeriodSeconds", "", "recurringStopAfterSeconds", "surveyThrottleDays", "", "<init>", "(ZJLjava/lang/Long;Ljava/lang/Integer;)V", "getRecurring", "()Z", "getRecurringPeriodSeconds", "()J", "getRecurringStopAfterSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSurveyThrottleDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(ZJLjava/lang/Long;Ljava/lang/Integer;)Lcom/survicate/surveys/core/targeting/displayfilter/RecurrenceDisplayFilterSettings;", "equals", "other", "hashCode", "toString", "", "Companion", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class RecurrenceDisplayFilterSettings {
    public static final long RECURRING_PERIOD_INSTANTLY = -1;
    private final boolean recurring;
    private final long recurringPeriodSeconds;
    private final Long recurringStopAfterSeconds;
    private final Integer surveyThrottleDays;

    public static /* synthetic */ RecurrenceDisplayFilterSettings copy$default(RecurrenceDisplayFilterSettings recurrenceDisplayFilterSettings, boolean z, long j, Long l, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            z = recurrenceDisplayFilterSettings.recurring;
        }
        if ((i & 2) != 0) {
            j = recurrenceDisplayFilterSettings.recurringPeriodSeconds;
        }
        if ((i & 4) != 0) {
            l = recurrenceDisplayFilterSettings.recurringStopAfterSeconds;
        }
        if ((i & 8) != 0) {
            num = recurrenceDisplayFilterSettings.surveyThrottleDays;
        }
        return recurrenceDisplayFilterSettings.copy(z, j, l, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getRecurring() {
        return this.recurring;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getRecurringPeriodSeconds() {
        return this.recurringPeriodSeconds;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getRecurringStopAfterSeconds() {
        return this.recurringStopAfterSeconds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getSurveyThrottleDays() {
        return this.surveyThrottleDays;
    }

    public final RecurrenceDisplayFilterSettings copy(boolean recurring, long recurringPeriodSeconds, Long recurringStopAfterSeconds, Integer surveyThrottleDays) {
        return new RecurrenceDisplayFilterSettings(recurring, recurringPeriodSeconds, recurringStopAfterSeconds, surveyThrottleDays);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecurrenceDisplayFilterSettings)) {
            return false;
        }
        RecurrenceDisplayFilterSettings recurrenceDisplayFilterSettings = (RecurrenceDisplayFilterSettings) other;
        return this.recurring == recurrenceDisplayFilterSettings.recurring && this.recurringPeriodSeconds == recurrenceDisplayFilterSettings.recurringPeriodSeconds && Intrinsics.areEqual(this.recurringStopAfterSeconds, recurrenceDisplayFilterSettings.recurringStopAfterSeconds) && Intrinsics.areEqual(this.surveyThrottleDays, recurrenceDisplayFilterSettings.surveyThrottleDays);
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.recurring) * 31) + Long.hashCode(this.recurringPeriodSeconds)) * 31;
        Long l = this.recurringStopAfterSeconds;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.surveyThrottleDays;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "RecurrenceDisplayFilterSettings(recurring=" + this.recurring + ", recurringPeriodSeconds=" + this.recurringPeriodSeconds + ", recurringStopAfterSeconds=" + this.recurringStopAfterSeconds + ", surveyThrottleDays=" + this.surveyThrottleDays + ')';
    }

    public RecurrenceDisplayFilterSettings(boolean z, long j, Long l, Integer num) {
        this.recurring = z;
        this.recurringPeriodSeconds = j;
        this.recurringStopAfterSeconds = l;
        this.surveyThrottleDays = num;
    }

    public final boolean getRecurring() {
        return this.recurring;
    }

    public final long getRecurringPeriodSeconds() {
        return this.recurringPeriodSeconds;
    }

    public final Long getRecurringStopAfterSeconds() {
        return this.recurringStopAfterSeconds;
    }

    public final Integer getSurveyThrottleDays() {
        return this.surveyThrottleDays;
    }
}

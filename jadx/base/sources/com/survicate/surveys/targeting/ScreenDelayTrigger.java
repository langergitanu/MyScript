package com.survicate.surveys.targeting;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenDelayTargeting.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m1599d2 = {"Lcom/survicate/surveys/targeting/ScreenDelayTrigger;", "", "screenName", "", "delayInSeconds", "", "<init>", "(Ljava/lang/String;I)V", "getScreenName", "()Ljava/lang/String;", "getDelayInSeconds", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class ScreenDelayTrigger {
    private final int delayInSeconds;
    private final String screenName;

    public static /* synthetic */ ScreenDelayTrigger copy$default(ScreenDelayTrigger screenDelayTrigger, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = screenDelayTrigger.screenName;
        }
        if ((i2 & 2) != 0) {
            i = screenDelayTrigger.delayInSeconds;
        }
        return screenDelayTrigger.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getScreenName() {
        return this.screenName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDelayInSeconds() {
        return this.delayInSeconds;
    }

    public final ScreenDelayTrigger copy(String screenName, int delayInSeconds) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        return new ScreenDelayTrigger(screenName, delayInSeconds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScreenDelayTrigger)) {
            return false;
        }
        ScreenDelayTrigger screenDelayTrigger = (ScreenDelayTrigger) other;
        return Intrinsics.areEqual(this.screenName, screenDelayTrigger.screenName) && this.delayInSeconds == screenDelayTrigger.delayInSeconds;
    }

    public int hashCode() {
        return (this.screenName.hashCode() * 31) + Integer.hashCode(this.delayInSeconds);
    }

    public String toString() {
        return "ScreenDelayTrigger(screenName=" + this.screenName + ", delayInSeconds=" + this.delayInSeconds + ')';
    }

    public ScreenDelayTrigger(String screenName, int i) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        this.screenName = screenName;
        this.delayInSeconds = i;
    }

    public final int getDelayInSeconds() {
        return this.delayInSeconds;
    }

    public final String getScreenName() {
        return this.screenName;
    }
}

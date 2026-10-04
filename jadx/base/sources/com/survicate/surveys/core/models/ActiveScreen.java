package com.survicate.surveys.core.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActiveScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/survicate/surveys/core/models/ActiveScreen;", "", "screenName", "", "timeOfCreationMs", "", "<init>", "(Ljava/lang/String;J)V", "getScreenName", "()Ljava/lang/String;", "getTimeOfCreationMs", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class ActiveScreen {
    private final String screenName;
    private final long timeOfCreationMs;

    public static /* synthetic */ ActiveScreen copy$default(ActiveScreen activeScreen, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activeScreen.screenName;
        }
        if ((i & 2) != 0) {
            j = activeScreen.timeOfCreationMs;
        }
        return activeScreen.copy(str, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getScreenName() {
        return this.screenName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTimeOfCreationMs() {
        return this.timeOfCreationMs;
    }

    public final ActiveScreen copy(String screenName, long timeOfCreationMs) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        return new ActiveScreen(screenName, timeOfCreationMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveScreen)) {
            return false;
        }
        ActiveScreen activeScreen = (ActiveScreen) other;
        return Intrinsics.areEqual(this.screenName, activeScreen.screenName) && this.timeOfCreationMs == activeScreen.timeOfCreationMs;
    }

    public int hashCode() {
        return (this.screenName.hashCode() * 31) + Long.hashCode(this.timeOfCreationMs);
    }

    public String toString() {
        return "ActiveScreen(screenName=" + this.screenName + ", timeOfCreationMs=" + this.timeOfCreationMs + ')';
    }

    public ActiveScreen(String screenName, long j) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        this.screenName = screenName;
        this.timeOfCreationMs = j;
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final long getTimeOfCreationMs() {
        return this.timeOfCreationMs;
    }
}

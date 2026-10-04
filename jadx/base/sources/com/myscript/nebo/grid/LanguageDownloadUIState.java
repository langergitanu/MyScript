package com.myscript.nebo.grid;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadLanguageDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/grid/LanguageDownloadUIState;", "", NotificationCompat.CATEGORY_STATUS, "Lcom/myscript/nebo/grid/Status;", "progress", "", "max", "languageDisplayName", "", "<init>", "(Lcom/myscript/nebo/grid/Status;IILjava/lang/String;)V", "getStatus", "()Lcom/myscript/nebo/grid/Status;", "getProgress", "()I", "getMax", "getLanguageDisplayName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class LanguageDownloadUIState {
    public static final int $stable = 0;
    private final String languageDisplayName;
    private final int max;
    private final int progress;
    private final Status status;

    public static /* synthetic */ LanguageDownloadUIState copy$default(LanguageDownloadUIState languageDownloadUIState, Status status, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            status = languageDownloadUIState.status;
        }
        if ((i3 & 2) != 0) {
            i = languageDownloadUIState.progress;
        }
        if ((i3 & 4) != 0) {
            i2 = languageDownloadUIState.max;
        }
        if ((i3 & 8) != 0) {
            str = languageDownloadUIState.languageDisplayName;
        }
        return languageDownloadUIState.copy(status, i, i2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMax() {
        return this.max;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLanguageDisplayName() {
        return this.languageDisplayName;
    }

    public final LanguageDownloadUIState copy(Status status, int progress, int max, String languageDisplayName) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(languageDisplayName, "languageDisplayName");
        return new LanguageDownloadUIState(status, progress, max, languageDisplayName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LanguageDownloadUIState)) {
            return false;
        }
        LanguageDownloadUIState languageDownloadUIState = (LanguageDownloadUIState) other;
        return this.status == languageDownloadUIState.status && this.progress == languageDownloadUIState.progress && this.max == languageDownloadUIState.max && Intrinsics.areEqual(this.languageDisplayName, languageDownloadUIState.languageDisplayName);
    }

    public int hashCode() {
        return (((((this.status.hashCode() * 31) + Integer.hashCode(this.progress)) * 31) + Integer.hashCode(this.max)) * 31) + this.languageDisplayName.hashCode();
    }

    public String toString() {
        return "LanguageDownloadUIState(status=" + this.status + ", progress=" + this.progress + ", max=" + this.max + ", languageDisplayName=" + this.languageDisplayName + ")";
    }

    public LanguageDownloadUIState(Status status, int i, int i2, String languageDisplayName) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(languageDisplayName, "languageDisplayName");
        this.status = status;
        this.progress = i;
        this.max = i2;
        this.languageDisplayName = languageDisplayName;
    }

    public /* synthetic */ LanguageDownloadUIState(Status status, int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(status, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 100 : i2, str);
    }

    public final String getLanguageDisplayName() {
        return this.languageDisplayName;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final Status getStatus() {
        return this.status;
    }
}

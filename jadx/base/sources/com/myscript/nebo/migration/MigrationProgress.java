package com.myscript.nebo.migration;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MigrationProgress.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/migration/MigrationProgress;", "", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/myscript/nebo/migration/Phase;", "percent", "", "error", "Lcom/myscript/nebo/migration/MigrationError;", "<init>", "(Lcom/myscript/nebo/migration/Phase;ILcom/myscript/nebo/migration/MigrationError;)V", "getPhase", "()Lcom/myscript/nebo/migration/Phase;", "getPercent", "()I", "getError", "()Lcom/myscript/nebo/migration/MigrationError;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class MigrationProgress {
    public static final int $stable = 0;
    private final MigrationError error;
    private final int percent;
    private final Phase phase;

    public MigrationProgress() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ MigrationProgress copy$default(MigrationProgress migrationProgress, Phase phase, int i, MigrationError migrationError, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            phase = migrationProgress.phase;
        }
        if ((i2 & 2) != 0) {
            i = migrationProgress.percent;
        }
        if ((i2 & 4) != 0) {
            migrationError = migrationProgress.error;
        }
        return migrationProgress.copy(phase, i, migrationError);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Phase getPhase() {
        return this.phase;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPercent() {
        return this.percent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MigrationError getError() {
        return this.error;
    }

    public final MigrationProgress copy(Phase phase, int percent, MigrationError error) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        return new MigrationProgress(phase, percent, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MigrationProgress)) {
            return false;
        }
        MigrationProgress migrationProgress = (MigrationProgress) other;
        return this.phase == migrationProgress.phase && this.percent == migrationProgress.percent && this.error == migrationProgress.error;
    }

    public int hashCode() {
        int iHashCode = ((this.phase.hashCode() * 31) + Integer.hashCode(this.percent)) * 31;
        MigrationError migrationError = this.error;
        return iHashCode + (migrationError == null ? 0 : migrationError.hashCode());
    }

    public String toString() {
        return "MigrationProgress(phase=" + this.phase + ", percent=" + this.percent + ", error=" + this.error + ")";
    }

    public MigrationProgress(Phase phase, int i, MigrationError migrationError) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        this.phase = phase;
        this.percent = i;
        this.error = migrationError;
    }

    public /* synthetic */ MigrationProgress(Phase phase, int i, MigrationError migrationError, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Phase.Idle : phase, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? null : migrationError);
    }

    public final Phase getPhase() {
        return this.phase;
    }

    public final int getPercent() {
        return this.percent;
    }

    public final MigrationError getError() {
        return this.error;
    }
}

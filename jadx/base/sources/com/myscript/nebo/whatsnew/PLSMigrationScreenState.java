package com.myscript.nebo.whatsnew;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.myscript.nebo.C6079R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PLSMigrationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u000e\u000f\u0010\u0011B)\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u0082\u0001\u0004\u0012\u0013\u0014\u0015¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState;", "", "illustrationRes", "", "titleRes", "textRes", "ctaLabelRes", "<init>", "(IIII)V", "getIllustrationRes", "()I", "getTitleRes", "getTextRes", "getCtaLabelRes", "Preparing", "Migrating", "EndWithSync", "EndWithoutSync", "Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState$EndWithSync;", "Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState$EndWithoutSync;", "Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState$Migrating;", "Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState$Preparing;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class PLSMigrationScreenState {
    public static final int $stable = 0;
    private final int ctaLabelRes;
    private final int illustrationRes;
    private final int textRes;
    private final int titleRes;

    public /* synthetic */ PLSMigrationScreenState(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4);
    }

    private PLSMigrationScreenState(int i, int i2, int i3, int i4) {
        this.illustrationRes = i;
        this.titleRes = i2;
        this.textRes = i3;
        this.ctaLabelRes = i4;
    }

    public final int getIllustrationRes() {
        return this.illustrationRes;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final int getTextRes() {
        return this.textRes;
    }

    public final int getCtaLabelRes() {
        return this.ctaLabelRes;
    }

    /* JADX INFO: compiled from: PLSMigrationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState$Preparing;", "Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Preparing extends PLSMigrationScreenState {
        public static final int $stable = 0;
        public static final Preparing INSTANCE = new Preparing();

        private Preparing() {
            super(C6079R.drawable.pls_migration_illustration_step1, C6079R.string.pls_migration_step1_title, C6079R.string.pls_migration_step1_text, C6079R.string.pls_migration_step1_cta, null);
        }
    }

    /* JADX INFO: compiled from: PLSMigrationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState$Migrating;", "Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState;", "isOngoing", "", "migrationProgress", "", "migrationTotal", "<init>", "(ZII)V", "()Z", "getMigrationProgress", "()I", "getMigrationTotal", "toString", "", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Migrating extends PLSMigrationScreenState {
        public static final int $stable = 0;
        private final boolean isOngoing;
        private final int migrationProgress;
        private final int migrationTotal;

        public Migrating() {
            this(false, 0, 0, 7, null);
        }

        public static /* synthetic */ Migrating copy$default(Migrating migrating, boolean z, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z = migrating.isOngoing;
            }
            if ((i3 & 2) != 0) {
                i = migrating.migrationProgress;
            }
            if ((i3 & 4) != 0) {
                i2 = migrating.migrationTotal;
            }
            return migrating.copy(z, i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsOngoing() {
            return this.isOngoing;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getMigrationProgress() {
            return this.migrationProgress;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getMigrationTotal() {
            return this.migrationTotal;
        }

        public final Migrating copy(boolean isOngoing, int migrationProgress, int migrationTotal) {
            return new Migrating(isOngoing, migrationProgress, migrationTotal);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Migrating)) {
                return false;
            }
            Migrating migrating = (Migrating) other;
            return this.isOngoing == migrating.isOngoing && this.migrationProgress == migrating.migrationProgress && this.migrationTotal == migrating.migrationTotal;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.isOngoing) * 31) + Integer.hashCode(this.migrationProgress)) * 31) + Integer.hashCode(this.migrationTotal);
        }

        public /* synthetic */ Migrating(boolean z, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
        }

        public final boolean isOngoing() {
            return this.isOngoing;
        }

        public final int getMigrationProgress() {
            return this.migrationProgress;
        }

        public final int getMigrationTotal() {
            return this.migrationTotal;
        }

        public Migrating(boolean z, int i, int i2) {
            super(C6079R.drawable.pls_migration_illustration_step1, C6079R.string.pls_migration_step1_title, C6079R.string.pls_migration_step1_text, C6079R.string.pls_migration_step1_cta, null);
            this.isOngoing = z;
            this.migrationProgress = i;
            this.migrationTotal = i2;
        }

        public String toString() {
            return "Migrating(" + this.migrationProgress + DomExceptionUtils.SEPARATOR + this.migrationTotal + ") ongoing? " + this.isOngoing;
        }
    }

    /* JADX INFO: compiled from: PLSMigrationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState$EndWithSync;", "Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EndWithSync extends PLSMigrationScreenState {
        public static final int $stable = 0;
        public static final EndWithSync INSTANCE = new EndWithSync();

        private EndWithSync() {
            super(C6079R.drawable.pls_migration_illustration_step2_sync, C6079R.string.pls_migration_step2_sync_title, C6079R.string.pls_migration_step2_sync_text, C6079R.string.pls_migration_step2_sync_cta, null);
        }
    }

    /* JADX INFO: compiled from: PLSMigrationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState$EndWithoutSync;", "Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EndWithoutSync extends PLSMigrationScreenState {
        public static final int $stable = 0;
        public static final EndWithoutSync INSTANCE = new EndWithoutSync();

        private EndWithoutSync() {
            super(C6079R.drawable.pls_migration_illustration_step2_no_sync, C6079R.string.pls_migration_step2_no_sync_title, C6079R.string.pls_migration_step2_no_sync_text, C6079R.string.pls_migration_step2_no_sync_cta, null);
        }
    }
}

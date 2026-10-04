package com.myscript.nebo.p034ui.compose;

import kotlin.Metadata;

/* JADX INFO: compiled from: LenovoMigrationOnboarding.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/ui/compose/MigrationOnboardingPage;", "", "titleRes", "", "descriptionRes", "illustrationRes", "<init>", "(III)V", "getTitleRes", "()I", "getDescriptionRes", "getIllustrationRes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class MigrationOnboardingPage {
    public static final int $stable = 0;
    private final int descriptionRes;
    private final int illustrationRes;
    private final int titleRes;

    public static /* synthetic */ MigrationOnboardingPage copy$default(MigrationOnboardingPage migrationOnboardingPage, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = migrationOnboardingPage.titleRes;
        }
        if ((i4 & 2) != 0) {
            i2 = migrationOnboardingPage.descriptionRes;
        }
        if ((i4 & 4) != 0) {
            i3 = migrationOnboardingPage.illustrationRes;
        }
        return migrationOnboardingPage.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTitleRes() {
        return this.titleRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDescriptionRes() {
        return this.descriptionRes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getIllustrationRes() {
        return this.illustrationRes;
    }

    public final MigrationOnboardingPage copy(int titleRes, int descriptionRes, int illustrationRes) {
        return new MigrationOnboardingPage(titleRes, descriptionRes, illustrationRes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MigrationOnboardingPage)) {
            return false;
        }
        MigrationOnboardingPage migrationOnboardingPage = (MigrationOnboardingPage) other;
        return this.titleRes == migrationOnboardingPage.titleRes && this.descriptionRes == migrationOnboardingPage.descriptionRes && this.illustrationRes == migrationOnboardingPage.illustrationRes;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.titleRes) * 31) + Integer.hashCode(this.descriptionRes)) * 31) + Integer.hashCode(this.illustrationRes);
    }

    public String toString() {
        return "MigrationOnboardingPage(titleRes=" + this.titleRes + ", descriptionRes=" + this.descriptionRes + ", illustrationRes=" + this.illustrationRes + ")";
    }

    public MigrationOnboardingPage(int i, int i2, int i3) {
        this.titleRes = i;
        this.descriptionRes = i2;
        this.illustrationRes = i3;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final int getDescriptionRes() {
        return this.descriptionRes;
    }

    public final int getIllustrationRes() {
        return this.illustrationRes;
    }
}

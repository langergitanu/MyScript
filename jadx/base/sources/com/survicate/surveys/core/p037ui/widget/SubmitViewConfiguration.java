package com.survicate.surveys.core.p037ui.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubmitViewState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001e"}, m1599d2 = {"Lcom/survicate/surveys/core/ui/widget/SubmitViewConfiguration;", "", "backButtonText", "", "submitButtonText", "hasNavigationButtons", "", "isFirstSurveyPoint", "isFirstPointForFirstTime", "forceCenter", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZZ)V", "getBackButtonText", "()Ljava/lang/String;", "getSubmitButtonText", "getHasNavigationButtons", "()Z", "getForceCenter", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SubmitViewConfiguration {
    private final String backButtonText;
    private final boolean forceCenter;
    private final boolean hasNavigationButtons;
    private final boolean isFirstPointForFirstTime;
    private final boolean isFirstSurveyPoint;
    private final String submitButtonText;

    public static /* synthetic */ SubmitViewConfiguration copy$default(SubmitViewConfiguration submitViewConfiguration, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = submitViewConfiguration.backButtonText;
        }
        if ((i & 2) != 0) {
            str2 = submitViewConfiguration.submitButtonText;
        }
        if ((i & 4) != 0) {
            z = submitViewConfiguration.hasNavigationButtons;
        }
        if ((i & 8) != 0) {
            z2 = submitViewConfiguration.isFirstSurveyPoint;
        }
        if ((i & 16) != 0) {
            z3 = submitViewConfiguration.isFirstPointForFirstTime;
        }
        if ((i & 32) != 0) {
            z4 = submitViewConfiguration.forceCenter;
        }
        boolean z5 = z3;
        boolean z6 = z4;
        return submitViewConfiguration.copy(str, str2, z, z2, z5, z6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBackButtonText() {
        return this.backButtonText;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubmitButtonText() {
        return this.submitButtonText;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasNavigationButtons() {
        return this.hasNavigationButtons;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsFirstSurveyPoint() {
        return this.isFirstSurveyPoint;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsFirstPointForFirstTime() {
        return this.isFirstPointForFirstTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getForceCenter() {
        return this.forceCenter;
    }

    public final SubmitViewConfiguration copy(String backButtonText, String submitButtonText, boolean hasNavigationButtons, boolean isFirstSurveyPoint, boolean isFirstPointForFirstTime, boolean forceCenter) {
        Intrinsics.checkNotNullParameter(backButtonText, "backButtonText");
        Intrinsics.checkNotNullParameter(submitButtonText, "submitButtonText");
        return new SubmitViewConfiguration(backButtonText, submitButtonText, hasNavigationButtons, isFirstSurveyPoint, isFirstPointForFirstTime, forceCenter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubmitViewConfiguration)) {
            return false;
        }
        SubmitViewConfiguration submitViewConfiguration = (SubmitViewConfiguration) other;
        return Intrinsics.areEqual(this.backButtonText, submitViewConfiguration.backButtonText) && Intrinsics.areEqual(this.submitButtonText, submitViewConfiguration.submitButtonText) && this.hasNavigationButtons == submitViewConfiguration.hasNavigationButtons && this.isFirstSurveyPoint == submitViewConfiguration.isFirstSurveyPoint && this.isFirstPointForFirstTime == submitViewConfiguration.isFirstPointForFirstTime && this.forceCenter == submitViewConfiguration.forceCenter;
    }

    public int hashCode() {
        return (((((((((this.backButtonText.hashCode() * 31) + this.submitButtonText.hashCode()) * 31) + Boolean.hashCode(this.hasNavigationButtons)) * 31) + Boolean.hashCode(this.isFirstSurveyPoint)) * 31) + Boolean.hashCode(this.isFirstPointForFirstTime)) * 31) + Boolean.hashCode(this.forceCenter);
    }

    public String toString() {
        return "SubmitViewConfiguration(backButtonText=" + this.backButtonText + ", submitButtonText=" + this.submitButtonText + ", hasNavigationButtons=" + this.hasNavigationButtons + ", isFirstSurveyPoint=" + this.isFirstSurveyPoint + ", isFirstPointForFirstTime=" + this.isFirstPointForFirstTime + ", forceCenter=" + this.forceCenter + ')';
    }

    public SubmitViewConfiguration(String backButtonText, String submitButtonText, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(backButtonText, "backButtonText");
        Intrinsics.checkNotNullParameter(submitButtonText, "submitButtonText");
        this.backButtonText = backButtonText;
        this.submitButtonText = submitButtonText;
        this.hasNavigationButtons = z;
        this.isFirstSurveyPoint = z2;
        this.isFirstPointForFirstTime = z3;
        this.forceCenter = z4;
    }

    public final String getBackButtonText() {
        return this.backButtonText;
    }

    public final String getSubmitButtonText() {
        return this.submitButtonText;
    }

    public final boolean getHasNavigationButtons() {
        return this.hasNavigationButtons;
    }

    public final boolean isFirstSurveyPoint() {
        return this.isFirstSurveyPoint;
    }

    public final boolean isFirstPointForFirstTime() {
        return this.isFirstPointForFirstTime;
    }

    public final boolean getForceCenter() {
        return this.forceCenter;
    }
}

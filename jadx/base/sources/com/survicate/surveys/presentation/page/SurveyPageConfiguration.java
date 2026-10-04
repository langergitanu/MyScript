package com.survicate.surveys.presentation.page;

import kotlin.Metadata;

/* JADX INFO: compiled from: SurveyPageConfiguration.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\t¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/SurveyPageConfiguration;", "", "isFullScreen", "", "isFooterVisible", "hasNavigationButtons", "isFirstSurveyPoint", "<init>", "(ZZZZ)V", "()Z", "getHasNavigationButtons", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurveyPageConfiguration {
    private final boolean hasNavigationButtons;
    private final boolean isFirstSurveyPoint;
    private final boolean isFooterVisible;
    private final boolean isFullScreen;

    public static /* synthetic */ SurveyPageConfiguration copy$default(SurveyPageConfiguration surveyPageConfiguration, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = surveyPageConfiguration.isFullScreen;
        }
        if ((i & 2) != 0) {
            z2 = surveyPageConfiguration.isFooterVisible;
        }
        if ((i & 4) != 0) {
            z3 = surveyPageConfiguration.hasNavigationButtons;
        }
        if ((i & 8) != 0) {
            z4 = surveyPageConfiguration.isFirstSurveyPoint;
        }
        return surveyPageConfiguration.copy(z, z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsFullScreen() {
        return this.isFullScreen;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsFooterVisible() {
        return this.isFooterVisible;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasNavigationButtons() {
        return this.hasNavigationButtons;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsFirstSurveyPoint() {
        return this.isFirstSurveyPoint;
    }

    public final SurveyPageConfiguration copy(boolean isFullScreen, boolean isFooterVisible, boolean hasNavigationButtons, boolean isFirstSurveyPoint) {
        return new SurveyPageConfiguration(isFullScreen, isFooterVisible, hasNavigationButtons, isFirstSurveyPoint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyPageConfiguration)) {
            return false;
        }
        SurveyPageConfiguration surveyPageConfiguration = (SurveyPageConfiguration) other;
        return this.isFullScreen == surveyPageConfiguration.isFullScreen && this.isFooterVisible == surveyPageConfiguration.isFooterVisible && this.hasNavigationButtons == surveyPageConfiguration.hasNavigationButtons && this.isFirstSurveyPoint == surveyPageConfiguration.isFirstSurveyPoint;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.isFullScreen) * 31) + Boolean.hashCode(this.isFooterVisible)) * 31) + Boolean.hashCode(this.hasNavigationButtons)) * 31) + Boolean.hashCode(this.isFirstSurveyPoint);
    }

    public String toString() {
        return "SurveyPageConfiguration(isFullScreen=" + this.isFullScreen + ", isFooterVisible=" + this.isFooterVisible + ", hasNavigationButtons=" + this.hasNavigationButtons + ", isFirstSurveyPoint=" + this.isFirstSurveyPoint + ')';
    }

    public SurveyPageConfiguration(boolean z, boolean z2, boolean z3, boolean z4) {
        this.isFullScreen = z;
        this.isFooterVisible = z2;
        this.hasNavigationButtons = z3;
        this.isFirstSurveyPoint = z4;
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }

    public final boolean isFooterVisible() {
        return this.isFooterVisible;
    }

    public final boolean getHasNavigationButtons() {
        return this.hasNavigationButtons;
    }

    public final boolean isFirstSurveyPoint() {
        return this.isFirstSurveyPoint;
    }
}

package com.survicate.surveys.presentation.widget;

import com.survicate.surveys.entities.survey.theme.ThemeSettings;
import com.survicate.surveys.infrastructure.network.image.SurvicateImageLoader;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSurveyHeader.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003JW\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/SurveyHeaderBindingData;", "", "themeSettings", "Lcom/survicate/surveys/entities/survey/theme/ThemeSettings;", "imageLoader", "Lcom/survicate/surveys/infrastructure/network/image/SurvicateImageLoader;", "showProgressBar", "", "surveyProgressInPercents", "", "hasLanguageSelector", "languageCodes", "", "", "selectedLanguageCode", "<init>", "(Lcom/survicate/surveys/entities/survey/theme/ThemeSettings;Lcom/survicate/surveys/infrastructure/network/image/SurvicateImageLoader;ZDZLjava/util/List;Ljava/lang/String;)V", "getThemeSettings", "()Lcom/survicate/surveys/entities/survey/theme/ThemeSettings;", "getImageLoader", "()Lcom/survicate/surveys/infrastructure/network/image/SurvicateImageLoader;", "getShowProgressBar", "()Z", "getSurveyProgressInPercents", "()D", "getHasLanguageSelector", "getLanguageCodes", "()Ljava/util/List;", "getSelectedLanguageCode", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurveyHeaderBindingData {
    private final boolean hasLanguageSelector;
    private final SurvicateImageLoader imageLoader;
    private final List<String> languageCodes;
    private final String selectedLanguageCode;
    private final boolean showProgressBar;
    private final double surveyProgressInPercents;
    private final ThemeSettings themeSettings;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyHeaderBindingData copy$default(SurveyHeaderBindingData surveyHeaderBindingData, ThemeSettings themeSettings, SurvicateImageLoader survicateImageLoader, boolean z, double d, boolean z2, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            themeSettings = surveyHeaderBindingData.themeSettings;
        }
        if ((i & 2) != 0) {
            survicateImageLoader = surveyHeaderBindingData.imageLoader;
        }
        if ((i & 4) != 0) {
            z = surveyHeaderBindingData.showProgressBar;
        }
        if ((i & 8) != 0) {
            d = surveyHeaderBindingData.surveyProgressInPercents;
        }
        if ((i & 16) != 0) {
            z2 = surveyHeaderBindingData.hasLanguageSelector;
        }
        if ((i & 32) != 0) {
            list = surveyHeaderBindingData.languageCodes;
        }
        if ((i & 64) != 0) {
            str = surveyHeaderBindingData.selectedLanguageCode;
        }
        String str2 = str;
        boolean z3 = z2;
        double d2 = d;
        boolean z4 = z;
        return surveyHeaderBindingData.copy(themeSettings, survicateImageLoader, z4, d2, z3, list, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ThemeSettings getThemeSettings() {
        return this.themeSettings;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SurvicateImageLoader getImageLoader() {
        return this.imageLoader;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowProgressBar() {
        return this.showProgressBar;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getSurveyProgressInPercents() {
        return this.surveyProgressInPercents;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getHasLanguageSelector() {
        return this.hasLanguageSelector;
    }

    public final List<String> component6() {
        return this.languageCodes;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSelectedLanguageCode() {
        return this.selectedLanguageCode;
    }

    public final SurveyHeaderBindingData copy(ThemeSettings themeSettings, SurvicateImageLoader imageLoader, boolean showProgressBar, double surveyProgressInPercents, boolean hasLanguageSelector, List<String> languageCodes, String selectedLanguageCode) {
        Intrinsics.checkNotNullParameter(themeSettings, "themeSettings");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(languageCodes, "languageCodes");
        return new SurveyHeaderBindingData(themeSettings, imageLoader, showProgressBar, surveyProgressInPercents, hasLanguageSelector, languageCodes, selectedLanguageCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyHeaderBindingData)) {
            return false;
        }
        SurveyHeaderBindingData surveyHeaderBindingData = (SurveyHeaderBindingData) other;
        return Intrinsics.areEqual(this.themeSettings, surveyHeaderBindingData.themeSettings) && Intrinsics.areEqual(this.imageLoader, surveyHeaderBindingData.imageLoader) && this.showProgressBar == surveyHeaderBindingData.showProgressBar && Double.compare(this.surveyProgressInPercents, surveyHeaderBindingData.surveyProgressInPercents) == 0 && this.hasLanguageSelector == surveyHeaderBindingData.hasLanguageSelector && Intrinsics.areEqual(this.languageCodes, surveyHeaderBindingData.languageCodes) && Intrinsics.areEqual(this.selectedLanguageCode, surveyHeaderBindingData.selectedLanguageCode);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.themeSettings.hashCode() * 31) + this.imageLoader.hashCode()) * 31) + Boolean.hashCode(this.showProgressBar)) * 31) + Double.hashCode(this.surveyProgressInPercents)) * 31) + Boolean.hashCode(this.hasLanguageSelector)) * 31) + this.languageCodes.hashCode()) * 31;
        String str = this.selectedLanguageCode;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SurveyHeaderBindingData(themeSettings=" + this.themeSettings + ", imageLoader=" + this.imageLoader + ", showProgressBar=" + this.showProgressBar + ", surveyProgressInPercents=" + this.surveyProgressInPercents + ", hasLanguageSelector=" + this.hasLanguageSelector + ", languageCodes=" + this.languageCodes + ", selectedLanguageCode=" + this.selectedLanguageCode + ')';
    }

    public SurveyHeaderBindingData(ThemeSettings themeSettings, SurvicateImageLoader imageLoader, boolean z, double d, boolean z2, List<String> languageCodes, String str) {
        Intrinsics.checkNotNullParameter(themeSettings, "themeSettings");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(languageCodes, "languageCodes");
        this.themeSettings = themeSettings;
        this.imageLoader = imageLoader;
        this.showProgressBar = z;
        this.surveyProgressInPercents = d;
        this.hasLanguageSelector = z2;
        this.languageCodes = languageCodes;
        this.selectedLanguageCode = str;
    }

    public final ThemeSettings getThemeSettings() {
        return this.themeSettings;
    }

    public final SurvicateImageLoader getImageLoader() {
        return this.imageLoader;
    }

    public final boolean getShowProgressBar() {
        return this.showProgressBar;
    }

    public final double getSurveyProgressInPercents() {
        return this.surveyProgressInPercents;
    }

    public final boolean getHasLanguageSelector() {
        return this.hasLanguageSelector;
    }

    public /* synthetic */ SurveyHeaderBindingData(ThemeSettings themeSettings, SurvicateImageLoader survicateImageLoader, boolean z, double d, boolean z2, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(themeSettings, survicateImageLoader, z, d, z2, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? null : str);
    }

    public final List<String> getLanguageCodes() {
        return this.languageCodes;
    }

    public final String getSelectedLanguageCode() {
        return this.selectedLanguageCode;
    }
}

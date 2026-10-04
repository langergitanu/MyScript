package com.survicate.surveys.entities.survey;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.survicate.surveys.entities.survey.translations.SurveySettingsTranslation;
import com.survicate.surveys.entities.survey.translations.Translatable;
import com.survicate.surveys.surveys.PresentationStyle;
import com.survicate.surveys.utils.MiscUtilsKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: SurveySettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 o2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001:\u0002opBÁ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001a\u0010\u001bB·\u0001\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001a\u0010\u001fJ\b\u0010N\u001a\u00020\fH\u0016J\u0012\u0010O\u001a\u00020\u00002\b\u0010P\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010R\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010S\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010T\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010U\u001a\u00020\fHÆ\u0003J\t\u0010V\u001a\u00020\u0006HÆ\u0003J\t\u0010W\u001a\u00020\u000fHÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010Y\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\t\u0010Z\u001a\u00020\u0006HÆ\u0003J\t\u0010[\u001a\u00020\u0006HÆ\u0003J\t\u0010\\\u001a\u00020\u0006HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010^\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010_\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010'JÈ\u0001\u0010a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010bJ\u0013\u0010c\u001a\u00020\u00062\b\u0010d\u001a\u0004\u0018\u00010eHÖ\u0003J\t\u0010f\u001a\u00020\bHÖ\u0001J%\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\u00002\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020mH\u0001¢\u0006\u0002\bnR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010$\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010(\u0012\u0004\b%\u0010!\u001a\u0004\b&\u0010'R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010,\u0012\u0004\b)\u0010!\u001a\u0004\b*\u0010+R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010!\u001a\u0004\b.\u0010/R\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010!\u001a\u0004\b1\u00102R\u001c\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010!\u001a\u0004\b4\u00105R\u001c\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010!\u001a\u0004\b7\u00108R \u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010<\u0012\u0004\b9\u0010!\u001a\u0004\b:\u0010;R \u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010,\u0012\u0004\b=\u0010!\u001a\u0004\b>\u0010+R\u001c\u0010\u0012\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010!\u001a\u0004\b@\u00105R\u001c\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010!\u001a\u0004\bB\u00105R\u001c\u0010\u0014\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010!\u001a\u0004\bD\u00105R \u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010,\u0012\u0004\bE\u0010!\u001a\u0004\bF\u0010+R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010!\u001a\u0004\bH\u00102R$\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010!\u001a\u0004\bJ\u0010KR \u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010(\u0012\u0004\bL\u0010!\u001a\u0004\bM\u0010'¨\u0006q"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/SurveySettings;", "Lcom/survicate/surveys/entities/survey/translations/Translatable;", "Lcom/survicate/surveys/entities/survey/translations/SurveySettingsTranslation;", "percentage", "", "displayNotEngaged", "", "displayDelaySeconds", "", "messages", "Lcom/survicate/surveys/entities/survey/SurveyMessages;", "presentationStyle", "", "recurring", "recurringPeriodSeconds", "", "recurringStopAfterSeconds", "surveyThrottleDays", "hideFooter", "showProgressBar", "navigationEnabled", "followupLimit", "surveyLanguage", "languages", "", "showLanguageSelector", "<init>", "(Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/survicate/surveys/entities/survey/SurveyMessages;Ljava/lang/String;ZJLjava/lang/Long;Ljava/lang/Integer;ZZZLjava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/survicate/surveys/entities/survey/SurveyMessages;Ljava/lang/String;ZJLjava/lang/Long;Ljava/lang/Integer;ZZZLjava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPercentage$annotations", "()V", "getPercentage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDisplayNotEngaged$annotations", "getDisplayNotEngaged", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisplayDelaySeconds$annotations", "getDisplayDelaySeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessages$annotations", "getMessages", "()Lcom/survicate/surveys/entities/survey/SurveyMessages;", "getPresentationStyle$annotations", "getPresentationStyle", "()Ljava/lang/String;", "getRecurring$annotations", "getRecurring", "()Z", "getRecurringPeriodSeconds$annotations", "getRecurringPeriodSeconds", "()J", "getRecurringStopAfterSeconds$annotations", "getRecurringStopAfterSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSurveyThrottleDays$annotations", "getSurveyThrottleDays", "getHideFooter$annotations", "getHideFooter", "getShowProgressBar$annotations", "getShowProgressBar", "getNavigationEnabled$annotations", "getNavigationEnabled", "getFollowupLimit$annotations", "getFollowupLimit", "getSurveyLanguage$annotations", "getSurveyLanguage", "getLanguages$annotations", "getLanguages", "()Ljava/util/List;", "getShowLanguageSelector$annotations", "getShowLanguageSelector", "toString", "translatedWith", "translation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/survicate/surveys/entities/survey/SurveyMessages;Ljava/lang/String;ZJLjava/lang/Long;Ljava/lang/Integer;ZZZLjava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lcom/survicate/surveys/entities/survey/SurveySettings;", "equals", "other", "", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "Companion", "$serializer", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveySettings implements Translatable<SurveySettingsTranslation, SurveySettings> {
    public static final long RECURRING_PERIOD_INSTANTLY = -1;
    private final Integer displayDelaySeconds;
    private final Boolean displayNotEngaged;
    private final Integer followupLimit;
    private final boolean hideFooter;
    private final List<String> languages;
    private final SurveyMessages messages;
    private final boolean navigationEnabled;
    private final Double percentage;
    private final String presentationStyle;
    private final boolean recurring;
    private final long recurringPeriodSeconds;
    private final Long recurringStopAfterSeconds;
    private final Boolean showLanguageSelector;
    private final boolean showProgressBar;
    private final String surveyLanguage;
    private final Integer surveyThrottleDays;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.SurveySettings$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveySettings._childSerializers$_anonymous_();
        }
    }), null};

    public SurveySettings() {
        this((Double) null, (Boolean) null, (Integer) null, (SurveyMessages) null, (String) null, false, 0L, (Long) null, (Integer) null, false, false, false, (Integer) null, (String) null, (List) null, (Boolean) null, 65535, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveySettings copy$default(SurveySettings surveySettings, Double d, Boolean bool, Integer num, SurveyMessages surveyMessages, String str, boolean z, long j, Long l, Integer num2, boolean z2, boolean z3, boolean z4, Integer num3, String str2, List list, Boolean bool2, int i, Object obj) {
        Double d2 = (i & 1) != 0 ? surveySettings.percentage : d;
        return surveySettings.copy(d2, (i & 2) != 0 ? surveySettings.displayNotEngaged : bool, (i & 4) != 0 ? surveySettings.displayDelaySeconds : num, (i & 8) != 0 ? surveySettings.messages : surveyMessages, (i & 16) != 0 ? surveySettings.presentationStyle : str, (i & 32) != 0 ? surveySettings.recurring : z, (i & 64) != 0 ? surveySettings.recurringPeriodSeconds : j, (i & 128) != 0 ? surveySettings.recurringStopAfterSeconds : l, (i & 256) != 0 ? surveySettings.surveyThrottleDays : num2, (i & 512) != 0 ? surveySettings.hideFooter : z2, (i & 1024) != 0 ? surveySettings.showProgressBar : z3, (i & 2048) != 0 ? surveySettings.navigationEnabled : z4, (i & 4096) != 0 ? surveySettings.followupLimit : num3, (i & 8192) != 0 ? surveySettings.surveyLanguage : str2, (i & 16384) != 0 ? surveySettings.languages : list, (i & 32768) != 0 ? surveySettings.showLanguageSelector : bool2);
    }

    @SerialName("display_delay")
    public static /* synthetic */ void getDisplayDelaySeconds$annotations() {
    }

    @SerialName("display_not_engaged")
    public static /* synthetic */ void getDisplayNotEngaged$annotations() {
    }

    @SerialName("followup_limit")
    public static /* synthetic */ void getFollowupLimit$annotations() {
    }

    @SerialName("hide_footer")
    public static /* synthetic */ void getHideFooter$annotations() {
    }

    @SerialName("languages")
    public static /* synthetic */ void getLanguages$annotations() {
    }

    @SerialName("messages")
    public static /* synthetic */ void getMessages$annotations() {
    }

    @SerialName("navigation_enabled")
    public static /* synthetic */ void getNavigationEnabled$annotations() {
    }

    @SerialName("display_percentage")
    public static /* synthetic */ void getPercentage$annotations() {
    }

    @SerialName("place_to_show")
    public static /* synthetic */ void getPresentationStyle$annotations() {
    }

    @SerialName("recurring")
    public static /* synthetic */ void getRecurring$annotations() {
    }

    @SerialName("recurring_period")
    public static /* synthetic */ void getRecurringPeriodSeconds$annotations() {
    }

    @SerialName("recurring_stop_after")
    public static /* synthetic */ void getRecurringStopAfterSeconds$annotations() {
    }

    @SerialName("show_language_selector")
    public static /* synthetic */ void getShowLanguageSelector$annotations() {
    }

    @SerialName("show_progress_bar")
    public static /* synthetic */ void getShowProgressBar$annotations() {
    }

    @SerialName("survey_language")
    public static /* synthetic */ void getSurveyLanguage$annotations() {
    }

    @SerialName("survey_throttle")
    public static /* synthetic */ void getSurveyThrottleDays$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getPercentage() {
        return this.percentage;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getHideFooter() {
        return this.hideFooter;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getShowProgressBar() {
        return this.showProgressBar;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getNavigationEnabled() {
        return this.navigationEnabled;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getFollowupLimit() {
        return this.followupLimit;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getSurveyLanguage() {
        return this.surveyLanguage;
    }

    public final List<String> component15() {
        return this.languages;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Boolean getShowLanguageSelector() {
        return this.showLanguageSelector;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getDisplayNotEngaged() {
        return this.displayNotEngaged;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getDisplayDelaySeconds() {
        return this.displayDelaySeconds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SurveyMessages getMessages() {
        return this.messages;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPresentationStyle() {
        return this.presentationStyle;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getRecurring() {
        return this.recurring;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getRecurringPeriodSeconds() {
        return this.recurringPeriodSeconds;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getRecurringStopAfterSeconds() {
        return this.recurringStopAfterSeconds;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getSurveyThrottleDays() {
        return this.surveyThrottleDays;
    }

    public final SurveySettings copy(Double percentage, Boolean displayNotEngaged, Integer displayDelaySeconds, SurveyMessages messages, String presentationStyle, boolean recurring, long recurringPeriodSeconds, Long recurringStopAfterSeconds, Integer surveyThrottleDays, boolean hideFooter, boolean showProgressBar, boolean navigationEnabled, Integer followupLimit, String surveyLanguage, List<String> languages, Boolean showLanguageSelector) {
        Intrinsics.checkNotNullParameter(presentationStyle, "presentationStyle");
        return new SurveySettings(percentage, displayNotEngaged, displayDelaySeconds, messages, presentationStyle, recurring, recurringPeriodSeconds, recurringStopAfterSeconds, surveyThrottleDays, hideFooter, showProgressBar, navigationEnabled, followupLimit, surveyLanguage, languages, showLanguageSelector);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveySettings)) {
            return false;
        }
        SurveySettings surveySettings = (SurveySettings) other;
        return Intrinsics.areEqual((Object) this.percentage, (Object) surveySettings.percentage) && Intrinsics.areEqual(this.displayNotEngaged, surveySettings.displayNotEngaged) && Intrinsics.areEqual(this.displayDelaySeconds, surveySettings.displayDelaySeconds) && Intrinsics.areEqual(this.messages, surveySettings.messages) && Intrinsics.areEqual(this.presentationStyle, surveySettings.presentationStyle) && this.recurring == surveySettings.recurring && this.recurringPeriodSeconds == surveySettings.recurringPeriodSeconds && Intrinsics.areEqual(this.recurringStopAfterSeconds, surveySettings.recurringStopAfterSeconds) && Intrinsics.areEqual(this.surveyThrottleDays, surveySettings.surveyThrottleDays) && this.hideFooter == surveySettings.hideFooter && this.showProgressBar == surveySettings.showProgressBar && this.navigationEnabled == surveySettings.navigationEnabled && Intrinsics.areEqual(this.followupLimit, surveySettings.followupLimit) && Intrinsics.areEqual(this.surveyLanguage, surveySettings.surveyLanguage) && Intrinsics.areEqual(this.languages, surveySettings.languages) && Intrinsics.areEqual(this.showLanguageSelector, surveySettings.showLanguageSelector);
    }

    public int hashCode() {
        Double d = this.percentage;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Boolean bool = this.displayNotEngaged;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.displayDelaySeconds;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        SurveyMessages surveyMessages = this.messages;
        int iHashCode4 = (((((((iHashCode3 + (surveyMessages == null ? 0 : surveyMessages.hashCode())) * 31) + this.presentationStyle.hashCode()) * 31) + Boolean.hashCode(this.recurring)) * 31) + Long.hashCode(this.recurringPeriodSeconds)) * 31;
        Long l = this.recurringStopAfterSeconds;
        int iHashCode5 = (iHashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num2 = this.surveyThrottleDays;
        int iHashCode6 = (((((((iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31) + Boolean.hashCode(this.hideFooter)) * 31) + Boolean.hashCode(this.showProgressBar)) * 31) + Boolean.hashCode(this.navigationEnabled)) * 31;
        Integer num3 = this.followupLimit;
        int iHashCode7 = (iHashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.surveyLanguage;
        int iHashCode8 = (iHashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.languages;
        int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool2 = this.showLanguageSelector;
        return iHashCode9 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public /* synthetic */ SurveySettings(int i, Double d, Boolean bool, Integer num, SurveyMessages surveyMessages, String str, boolean z, long j, Long l, Integer num2, boolean z2, boolean z3, boolean z4, Integer num3, String str2, List list, Boolean bool2, SerializationConstructorMarker serializationConstructorMarker) {
        this.percentage = (i & 1) == 0 ? Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) : d;
        if ((i & 2) == 0) {
            this.displayNotEngaged = false;
        } else {
            this.displayNotEngaged = bool;
        }
        if ((i & 4) == 0) {
            this.displayDelaySeconds = 0;
        } else {
            this.displayDelaySeconds = num;
        }
        if ((i & 8) == 0) {
            this.messages = null;
        } else {
            this.messages = surveyMessages;
        }
        if ((i & 16) == 0) {
            this.presentationStyle = PresentationStyle.FULLSCREEN;
        } else {
            this.presentationStyle = str;
        }
        if ((i & 32) == 0) {
            this.recurring = false;
        } else {
            this.recurring = z;
        }
        if ((i & 64) == 0) {
            this.recurringPeriodSeconds = 0L;
        } else {
            this.recurringPeriodSeconds = j;
        }
        if ((i & 128) == 0) {
            this.recurringStopAfterSeconds = null;
        } else {
            this.recurringStopAfterSeconds = l;
        }
        if ((i & 256) == 0) {
            this.surveyThrottleDays = null;
        } else {
            this.surveyThrottleDays = num2;
        }
        if ((i & 512) == 0) {
            this.hideFooter = false;
        } else {
            this.hideFooter = z2;
        }
        if ((i & 1024) == 0) {
            this.showProgressBar = true;
        } else {
            this.showProgressBar = z3;
        }
        if ((i & 2048) == 0) {
            this.navigationEnabled = false;
        } else {
            this.navigationEnabled = z4;
        }
        if ((i & 4096) == 0) {
            this.followupLimit = null;
        } else {
            this.followupLimit = num3;
        }
        if ((i & 8192) == 0) {
            this.surveyLanguage = null;
        } else {
            this.surveyLanguage = str2;
        }
        if ((i & 16384) == 0) {
            this.languages = null;
        } else {
            this.languages = list;
        }
        if ((i & 32768) == 0) {
            this.showLanguageSelector = null;
        } else {
            this.showLanguageSelector = bool2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveySettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Integer num;
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual((Object) self.percentage, (Object) Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE))) {
            output.encodeNullableSerializableElement(serialDesc, 0, DoubleSerializer.INSTANCE, self.percentage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual((Object) self.displayNotEngaged, (Object) false)) {
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.displayNotEngaged);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || (num = self.displayDelaySeconds) == null || num.intValue() != 0) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.displayDelaySeconds);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.messages != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, SurveyMessages$$serializer.INSTANCE, self.messages);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.presentationStyle, PresentationStyle.FULLSCREEN)) {
            output.encodeStringElement(serialDesc, 4, self.presentationStyle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.recurring) {
            output.encodeBooleanElement(serialDesc, 5, self.recurring);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.recurringPeriodSeconds != 0) {
            output.encodeLongElement(serialDesc, 6, self.recurringPeriodSeconds);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.recurringStopAfterSeconds != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, LongSerializer.INSTANCE, self.recurringStopAfterSeconds);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.surveyThrottleDays != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.surveyThrottleDays);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.hideFooter) {
            output.encodeBooleanElement(serialDesc, 9, self.hideFooter);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !self.showProgressBar) {
            output.encodeBooleanElement(serialDesc, 10, self.showProgressBar);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.navigationEnabled) {
            output.encodeBooleanElement(serialDesc, 11, self.navigationEnabled);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.followupLimit != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, IntSerializer.INSTANCE, self.followupLimit);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.surveyLanguage != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.surveyLanguage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.languages != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, lazyArr[14].getValue(), self.languages);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 15) && self.showLanguageSelector == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 15, BooleanSerializer.INSTANCE, self.showLanguageSelector);
    }

    public SurveySettings(Double d, Boolean bool, Integer num, SurveyMessages surveyMessages, String presentationStyle, boolean z, long j, Long l, Integer num2, boolean z2, boolean z3, boolean z4, Integer num3, String str, List<String> list, Boolean bool2) {
        Intrinsics.checkNotNullParameter(presentationStyle, "presentationStyle");
        this.percentage = d;
        this.displayNotEngaged = bool;
        this.displayDelaySeconds = num;
        this.messages = surveyMessages;
        this.presentationStyle = presentationStyle;
        this.recurring = z;
        this.recurringPeriodSeconds = j;
        this.recurringStopAfterSeconds = l;
        this.surveyThrottleDays = num2;
        this.hideFooter = z2;
        this.showProgressBar = z3;
        this.navigationEnabled = z4;
        this.followupLimit = num3;
        this.surveyLanguage = str;
        this.languages = list;
        this.showLanguageSelector = bool2;
    }

    public final Double getPercentage() {
        return this.percentage;
    }

    public /* synthetic */ SurveySettings(Double d, Boolean bool, Integer num, SurveyMessages surveyMessages, String str, boolean z, long j, Long l, Integer num2, boolean z2, boolean z3, boolean z4, Integer num3, String str2, List list, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) : d, (i & 2) != 0 ? false : bool, (i & 4) != 0 ? 0 : num, (i & 8) != 0 ? null : surveyMessages, (i & 16) != 0 ? PresentationStyle.FULLSCREEN : str, (i & 32) != 0 ? false : z, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? null : l, (i & 256) != 0 ? null : num2, (i & 512) != 0 ? false : z2, (i & 1024) != 0 ? true : z3, (i & 2048) == 0 ? z4 : false, (i & 4096) != 0 ? null : num3, (i & 8192) != 0 ? null : str2, (i & 16384) != 0 ? null : list, (i & 32768) != 0 ? null : bool2);
    }

    public final Boolean getDisplayNotEngaged() {
        return this.displayNotEngaged;
    }

    public final Integer getDisplayDelaySeconds() {
        return this.displayDelaySeconds;
    }

    public final SurveyMessages getMessages() {
        return this.messages;
    }

    public final String getPresentationStyle() {
        return this.presentationStyle;
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

    public final boolean getHideFooter() {
        return this.hideFooter;
    }

    public final boolean getShowProgressBar() {
        return this.showProgressBar;
    }

    public final boolean getNavigationEnabled() {
        return this.navigationEnabled;
    }

    public final Integer getFollowupLimit() {
        return this.followupLimit;
    }

    public final String getSurveyLanguage() {
        return this.surveyLanguage;
    }

    public final List<String> getLanguages() {
        return this.languages;
    }

    public final Boolean getShowLanguageSelector() {
        return this.showLanguageSelector;
    }

    public String toString() {
        return MiscUtilsKt.reflectionToString(this);
    }

    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    public SurveySettings translatedWith(SurveySettingsTranslation translation) {
        SurveyMessages surveyMessagesTranslatedWith2;
        if (translation != null) {
            SurveyMessages surveyMessages = this.messages;
            surveyMessagesTranslatedWith2 = surveyMessages != null ? surveyMessages.translatedWith(translation.getMessages()) : null;
        } else {
            surveyMessagesTranslatedWith2 = this.messages;
        }
        return copy$default(this, null, null, null, surveyMessagesTranslatedWith2, null, false, 0L, null, null, false, false, false, null, null, null, null, 65527, null);
    }

    /* JADX INFO: compiled from: SurveySettings.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/SurveySettings$Companion;", "", "<init>", "()V", "RECURRING_PERIOD_INSTANTLY", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/SurveySettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SurveySettings> serializer() {
            return SurveySettings$$serializer.INSTANCE;
        }
    }
}

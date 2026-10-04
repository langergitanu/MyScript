package com.survicate.surveys.targeting;

import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.core.providers.ActiveScreenProvider;
import com.survicate.surveys.core.providers.LocaleProvider;
import com.survicate.surveys.core.providers.PresentationStateProvider;
import com.survicate.surveys.core.providers.SurveyChanceStore;
import com.survicate.surveys.core.targeting.audience.AudienceFilter;
import com.survicate.surveys.core.targeting.audience.BackendTargetingAudienceFilter;
import com.survicate.surveys.core.targeting.backend.BackendTargetingResultProvider;
import com.survicate.surveys.core.targeting.displayfilter.DisplayFilter;
import com.survicate.surveys.core.targeting.displayfilter.OneSurveyInSessionDisplayFilter;
import com.survicate.surveys.core.targeting.displayfilter.ScreenDisplayFilter;
import com.survicate.surveys.core.targeting.displayfilter.SurveyChanceDisplayFilter;
import com.survicate.surveys.core.targeting.provider.CoreUserTraitsProvider;
import com.survicate.surveys.entities.survey.NetworkSurvey;
import com.survicate.surveys.entities.survey.NetworkSurveyKt;
import com.survicate.surveys.entities.survey.audience.AudienceVisitorType;
import com.survicate.surveys.entities.survey.audience.NetworkAudience;
import com.survicate.surveys.entities.survey.audience.NetworkAudienceFilter;
import com.survicate.surveys.entities.survey.audience.NetworkAudienceFiltersKt;
import com.survicate.surveys.entities.survey.audience.NetworkAudienceKnownUserFilter;
import com.survicate.surveys.entities.survey.audience.NetworkAudienceLocaleFilter;
import com.survicate.surveys.entities.survey.audience.NetworkAudiencePlatformFilter;
import com.survicate.surveys.entities.survey.audience.NetworkAudienceScreenOrientationFilter;
import com.survicate.surveys.entities.survey.audience.NetworkAudienceUserFilter;
import com.survicate.surveys.targeting.displayfilter.EventDisplayFilter;
import com.survicate.surveys.targeting.displayfilter.RecurrenceDisplayFilter;
import com.survicate.surveys.targeting.provider.ActiveEventProvider;
import com.survicate.surveys.targeting.provider.DelayedEventProvider;
import com.survicate.surveys.targeting.provider.PresentationTimesProvider;
import com.survicate.surveys.targeting.provider.SeenSurveysProvider;
import com.survicate.surveys.utils.AndroidScreenOrientationProvider;
import com.survicate.surveys.utils.FeatureFlags;
import com.survicate.surveys.utils.TimestampProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TargetingFiltersFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001fJ\u0010\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010!\u001a\u00020\"H\u0002J\u001e\u0010+\u001a\u00020,2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001fH\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010!\u001a\u00020\"H\u0002J\u0014\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u001f2\u0006\u00101\u001a\u00020$J\u0010\u00102\u001a\u0002032\u0006\u00101\u001a\u00020$H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, m1599d2 = {"Lcom/survicate/surveys/targeting/TargetingFiltersFactory;", "", "activeScreenProvider", "Lcom/survicate/surveys/core/providers/ActiveScreenProvider;", "activeEventProvider", "Lcom/survicate/surveys/targeting/provider/ActiveEventProvider;", "userTraitsProvider", "Lcom/survicate/surveys/core/targeting/provider/CoreUserTraitsProvider;", "seenSurveysProvider", "Lcom/survicate/surveys/targeting/provider/SeenSurveysProvider;", "presentationTimesProvider", "Lcom/survicate/surveys/targeting/provider/PresentationTimesProvider;", "delayedEventProvider", "Lcom/survicate/surveys/targeting/provider/DelayedEventProvider;", "localeProvider", "Lcom/survicate/surveys/core/providers/LocaleProvider;", "screenOrientationProvider", "Lcom/survicate/surveys/utils/AndroidScreenOrientationProvider;", "presentationStateProvider", "Lcom/survicate/surveys/core/providers/PresentationStateProvider;", "surveyChanceStore", "Lcom/survicate/surveys/core/providers/SurveyChanceStore;", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "backendTargetingResultProvider", "Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultProvider;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "<init>", "(Lcom/survicate/surveys/core/providers/ActiveScreenProvider;Lcom/survicate/surveys/targeting/provider/ActiveEventProvider;Lcom/survicate/surveys/core/targeting/provider/CoreUserTraitsProvider;Lcom/survicate/surveys/targeting/provider/SeenSurveysProvider;Lcom/survicate/surveys/targeting/provider/PresentationTimesProvider;Lcom/survicate/surveys/targeting/provider/DelayedEventProvider;Lcom/survicate/surveys/core/providers/LocaleProvider;Lcom/survicate/surveys/utils/AndroidScreenOrientationProvider;Lcom/survicate/surveys/core/providers/PresentationStateProvider;Lcom/survicate/surveys/core/providers/SurveyChanceStore;Lcom/survicate/surveys/utils/TimestampProvider;Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultProvider;Lcom/survicate/surveys/core/logging/SdkLogger;)V", "createDisplayFilters", "", "Lcom/survicate/surveys/core/targeting/displayfilter/DisplayFilter;", "survey", "Lcom/survicate/surveys/entities/survey/NetworkSurvey;", "audiences", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudience;", "createScreenFilter", "Lcom/survicate/surveys/core/targeting/displayfilter/ScreenDisplayFilter;", "createEventFilter", "Lcom/survicate/surveys/targeting/displayfilter/EventDisplayFilter;", "createOneSurveyInSessionFilter", "Lcom/survicate/surveys/core/targeting/displayfilter/OneSurveyInSessionDisplayFilter;", "createRecurrenceFilter", "Lcom/survicate/surveys/targeting/displayfilter/RecurrenceDisplayFilter;", "createSurveyChanceFilter", "Lcom/survicate/surveys/core/targeting/displayfilter/SurveyChanceDisplayFilter;", "createAudienceFilters", "Lcom/survicate/surveys/core/targeting/audience/AudienceFilter;", "audience", "createBackendTargetingFilter", "Lcom/survicate/surveys/core/targeting/audience/BackendTargetingAudienceFilter;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TargetingFiltersFactory {
    private final ActiveEventProvider activeEventProvider;
    private final ActiveScreenProvider activeScreenProvider;
    private final BackendTargetingResultProvider backendTargetingResultProvider;
    private final DelayedEventProvider delayedEventProvider;
    private final LocaleProvider localeProvider;
    private final SdkLogger logger;
    private final PresentationStateProvider presentationStateProvider;
    private final PresentationTimesProvider presentationTimesProvider;
    private final AndroidScreenOrientationProvider screenOrientationProvider;
    private final SeenSurveysProvider seenSurveysProvider;
    private final SurveyChanceStore surveyChanceStore;
    private final TimestampProvider timestampProvider;
    private final CoreUserTraitsProvider userTraitsProvider;

    public TargetingFiltersFactory(ActiveScreenProvider activeScreenProvider, ActiveEventProvider activeEventProvider, CoreUserTraitsProvider userTraitsProvider, SeenSurveysProvider seenSurveysProvider, PresentationTimesProvider presentationTimesProvider, DelayedEventProvider delayedEventProvider, LocaleProvider localeProvider, AndroidScreenOrientationProvider screenOrientationProvider, PresentationStateProvider presentationStateProvider, SurveyChanceStore surveyChanceStore, TimestampProvider timestampProvider, BackendTargetingResultProvider backendTargetingResultProvider, SdkLogger logger) {
        Intrinsics.checkNotNullParameter(activeScreenProvider, "activeScreenProvider");
        Intrinsics.checkNotNullParameter(activeEventProvider, "activeEventProvider");
        Intrinsics.checkNotNullParameter(userTraitsProvider, "userTraitsProvider");
        Intrinsics.checkNotNullParameter(seenSurveysProvider, "seenSurveysProvider");
        Intrinsics.checkNotNullParameter(presentationTimesProvider, "presentationTimesProvider");
        Intrinsics.checkNotNullParameter(delayedEventProvider, "delayedEventProvider");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        Intrinsics.checkNotNullParameter(screenOrientationProvider, "screenOrientationProvider");
        Intrinsics.checkNotNullParameter(presentationStateProvider, "presentationStateProvider");
        Intrinsics.checkNotNullParameter(surveyChanceStore, "surveyChanceStore");
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        Intrinsics.checkNotNullParameter(backendTargetingResultProvider, "backendTargetingResultProvider");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.activeScreenProvider = activeScreenProvider;
        this.activeEventProvider = activeEventProvider;
        this.userTraitsProvider = userTraitsProvider;
        this.seenSurveysProvider = seenSurveysProvider;
        this.presentationTimesProvider = presentationTimesProvider;
        this.delayedEventProvider = delayedEventProvider;
        this.localeProvider = localeProvider;
        this.screenOrientationProvider = screenOrientationProvider;
        this.presentationStateProvider = presentationStateProvider;
        this.surveyChanceStore = surveyChanceStore;
        this.timestampProvider = timestampProvider;
        this.backendTargetingResultProvider = backendTargetingResultProvider;
        this.logger = logger;
    }

    public final List<DisplayFilter> createDisplayFilters(NetworkSurvey survey, List<NetworkAudience> audiences) {
        Intrinsics.checkNotNullParameter(survey, "survey");
        Intrinsics.checkNotNullParameter(audiences, "audiences");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayList;
        arrayList2.add(createScreenFilter(survey));
        arrayList2.add(createEventFilter(survey));
        arrayList2.add(createOneSurveyInSessionFilter(survey));
        arrayList2.add(createRecurrenceFilter(survey, audiences));
        arrayList2.add(createSurveyChanceFilter(survey));
        return CollectionsKt.filterNotNull(arrayList);
    }

    private final ScreenDisplayFilter createScreenFilter(NetworkSurvey survey) {
        return new ScreenDisplayFilter(survey.getScreens(), survey.getSettings().getDisplayDelaySeconds() != null ? r7.intValue() : 0L, this.activeScreenProvider, this.timestampProvider);
    }

    private final EventDisplayFilter createEventFilter(NetworkSurvey survey) {
        return new EventDisplayFilter(survey.getId(), survey.getEvents(), this.activeEventProvider, this.delayedEventProvider, this.timestampProvider);
    }

    private final OneSurveyInSessionDisplayFilter createOneSurveyInSessionFilter(NetworkSurvey survey) {
        return new OneSurveyInSessionDisplayFilter(Intrinsics.areEqual((Object) survey.getSettings().getDisplayNotEngaged(), (Object) true), this.presentationStateProvider);
    }

    private final RecurrenceDisplayFilter createRecurrenceFilter(NetworkSurvey survey, List<NetworkAudience> audiences) {
        return new RecurrenceDisplayFilter(survey.getId(), survey.getSettings(), NetworkSurveyKt.isContactMode(survey, audiences), this.backendTargetingResultProvider, this.seenSurveysProvider, this.presentationTimesProvider, this.timestampProvider);
    }

    private final SurveyChanceDisplayFilter createSurveyChanceFilter(NetworkSurvey survey) {
        return new SurveyChanceDisplayFilter(survey.getId(), survey.getSettings().getPercentage(), this.surveyChanceStore, null, 8, null);
    }

    public final List<AudienceFilter> createAudienceFilters(NetworkAudience audience) {
        Intrinsics.checkNotNullParameter(audience, "audience");
        ArrayList arrayList = new ArrayList();
        List<NetworkAudienceFilter> filters = audience.getFilters();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : filters) {
            if (obj instanceof NetworkAudienceLocaleFilter) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            arrayList4.add(NetworkAudienceFiltersKt.toDomainModel((NetworkAudienceLocaleFilter) it.next(), this.localeProvider));
        }
        ArrayList arrayList5 = arrayList;
        CollectionsKt.addAll(arrayList5, arrayList4);
        List<NetworkAudienceFilter> filters2 = audience.getFilters();
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : filters2) {
            if (obj2 instanceof NetworkAudienceKnownUserFilter) {
                arrayList6.add(obj2);
            }
        }
        ArrayList arrayList7 = arrayList6;
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
        Iterator it2 = arrayList7.iterator();
        while (it2.hasNext()) {
            arrayList8.add(NetworkAudienceFiltersKt.toDomainModel((NetworkAudienceKnownUserFilter) it2.next(), this.userTraitsProvider));
        }
        CollectionsKt.addAll(arrayList5, arrayList8);
        List<NetworkAudienceFilter> filters3 = audience.getFilters();
        ArrayList arrayList9 = new ArrayList();
        for (Object obj3 : filters3) {
            if (obj3 instanceof NetworkAudiencePlatformFilter) {
                arrayList9.add(obj3);
            }
        }
        ArrayList arrayList10 = arrayList9;
        ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList10, 10));
        Iterator it3 = arrayList10.iterator();
        while (it3.hasNext()) {
            arrayList11.add(NetworkAudienceFiltersKt.toDomainModel((NetworkAudiencePlatformFilter) it3.next()));
        }
        CollectionsKt.addAll(arrayList5, arrayList11);
        List<NetworkAudienceFilter> filters4 = audience.getFilters();
        ArrayList arrayList12 = new ArrayList();
        for (Object obj4 : filters4) {
            if (obj4 instanceof NetworkAudienceUserFilter) {
                arrayList12.add(obj4);
            }
        }
        ArrayList arrayList13 = arrayList12;
        ArrayList arrayList14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList13, 10));
        Iterator it4 = arrayList13.iterator();
        while (it4.hasNext()) {
            arrayList14.add(NetworkAudienceFiltersKt.toDomainModel((NetworkAudienceUserFilter) it4.next(), this.userTraitsProvider, this.timestampProvider));
        }
        CollectionsKt.addAll(arrayList5, arrayList14);
        List<NetworkAudienceFilter> filters5 = audience.getFilters();
        ArrayList arrayList15 = new ArrayList();
        for (Object obj5 : filters5) {
            if (obj5 instanceof NetworkAudienceScreenOrientationFilter) {
                arrayList15.add(obj5);
            }
        }
        ArrayList arrayList16 = arrayList15;
        ArrayList arrayList17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList16, 10));
        Iterator it5 = arrayList16.iterator();
        while (it5.hasNext()) {
            arrayList17.add(NetworkAudienceFiltersKt.toDomainModel((NetworkAudienceScreenOrientationFilter) it5.next(), this.screenOrientationProvider));
        }
        CollectionsKt.addAll(arrayList5, arrayList17);
        if (audience.getVisitorType() == AudienceVisitorType.IDENTIFIED && Intrinsics.areEqual((Object) audience.getHasBackendFilters(), (Object) true) && FeatureFlags.INSTANCE.isBackendTargetingEnabled()) {
            arrayList5.add(createBackendTargetingFilter(audience));
        }
        return arrayList;
    }

    private final BackendTargetingAudienceFilter createBackendTargetingFilter(NetworkAudience audience) {
        return new BackendTargetingAudienceFilter(audience.getId(), this.backendTargetingResultProvider);
    }
}

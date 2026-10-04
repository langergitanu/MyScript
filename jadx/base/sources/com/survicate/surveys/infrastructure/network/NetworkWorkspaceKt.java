package com.survicate.surveys.infrastructure.network;

import com.survicate.surveys.core.targeting.displayfilter.DisplayFilter;
import com.survicate.surveys.entities.models.EventSuggestion;
import com.survicate.surveys.entities.survey.Integration;
import com.survicate.surveys.entities.survey.NetworkSurvey;
import com.survicate.surveys.entities.survey.NetworkTargetingEvent;
import com.survicate.surveys.entities.survey.NetworkTargetingEventKt;
import com.survicate.surveys.entities.survey.Survey;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.Workspace;
import com.survicate.surveys.entities.survey.audience.NetworkAudience;
import com.survicate.surveys.entities.survey.audience.NetworkAudienceKt;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.QuestionPointAnswer;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.theme.ThemeConfiguration;
import com.survicate.surveys.entities.survey.theme.network.NetworkTheme;
import com.survicate.surveys.entities.survey.theme.network.NetworkThemeKt;
import com.survicate.surveys.entities.survey.translations.SurveyTranslation;
import com.survicate.surveys.presentation.smileyscale.SmileyScaleUtils;
import com.survicate.surveys.targeting.TargetingFiltersFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkWorkspace.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0002\u001a\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u0016\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\bH\u0002\u001a\u001a\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00180\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a\u0012\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\b*\u00020\u0002H\u0002¨\u0006\u001d"}, m1599d2 = {"mapToWorkspace", "Lcom/survicate/surveys/entities/survey/Workspace;", "Lcom/survicate/surveys/infrastructure/network/NetworkWorkspace;", "lastUpdatedAt", "Ljava/util/Date;", "targetingFiltersFactory", "Lcom/survicate/surveys/targeting/TargetingFiltersFactory;", "mapSurveys", "", "Lcom/survicate/surveys/entities/survey/Survey;", "validateSurveyPoints", "", "surveyPoints", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "validateAnswerType", "surveyPoint", "validatePossibleAnswers", "questionPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "validateSmileyScaleAnswers", "answers", "Lcom/survicate/surveys/entities/survey/questions/question/QuestionPointAnswer;", "findMatchingThemeConfig", "Lcom/survicate/surveys/entities/survey/theme/ThemeConfiguration;", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkTheme;", "networkSurvey", "Lcom/survicate/surveys/entities/survey/NetworkSurvey;", "mapMobileTargetingEvents", "Lcom/survicate/surveys/entities/models/EventSuggestion;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class NetworkWorkspaceKt {
    public static final Workspace mapToWorkspace(NetworkWorkspace networkWorkspace, Date lastUpdatedAt, TargetingFiltersFactory targetingFiltersFactory) {
        Intrinsics.checkNotNullParameter(networkWorkspace, "<this>");
        Intrinsics.checkNotNullParameter(lastUpdatedAt, "lastUpdatedAt");
        Intrinsics.checkNotNullParameter(targetingFiltersFactory, "targetingFiltersFactory");
        List<Survey> listMapSurveys = mapSurveys(networkWorkspace, targetingFiltersFactory);
        List<Integration> integrations = networkWorkspace.getIntegrations();
        String panelAnswerUrlTemplate = networkWorkspace.getPanelAnswerUrlTemplate();
        List<EventSuggestion> listMapMobileTargetingEvents = mapMobileTargetingEvents(networkWorkspace);
        boolean targetingEventsEnabled = networkWorkspace.getTargetingEventsEnabled();
        boolean backendTargetingEnabled = networkWorkspace.getBackendTargetingEnabled();
        boolean enforceUserAuthentication = networkWorkspace.getEnforceUserAuthentication();
        List<SurveyTranslation> translations = networkWorkspace.getTranslations();
        if (translations == null) {
            translations = CollectionsKt.emptyList();
        }
        return new Workspace(lastUpdatedAt, listMapSurveys, integrations, panelAnswerUrlTemplate, listMapMobileTargetingEvents, targetingEventsEnabled, backendTargetingEnabled, enforceUserAuthentication, translations);
    }

    private static final List<Survey> mapSurveys(NetworkWorkspace networkWorkspace, TargetingFiltersFactory targetingFiltersFactory) {
        List<NetworkSurvey> surveys = networkWorkspace.getSurveys();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(surveys, 10));
        for (NetworkSurvey networkSurvey : surveys) {
            validateSurveyPoints(networkSurvey.getPoints());
            List<NetworkAudience> audiences = networkWorkspace.getAudiences();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : audiences) {
                if (networkSurvey.getAudiencesIds().contains(Long.valueOf(((NetworkAudience) obj).getId()))) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            ThemeConfiguration themeConfigurationFindMatchingThemeConfig = findMatchingThemeConfig(networkWorkspace.getThemes(), networkSurvey);
            String id = networkSurvey.getId();
            String name = networkSurvey.getName();
            if (name == null) {
                name = "";
            }
            String str = name;
            List<SurveyPoint> points = networkSurvey.getPoints();
            List<DisplayFilter> listCreateDisplayFilters = targetingFiltersFactory.createDisplayFilters(networkSurvey, arrayList3);
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                arrayList5.add(NetworkAudienceKt.toDomainModel((NetworkAudience) it.next(), targetingFiltersFactory));
            }
            arrayList.add(new Survey(id, str, points, listCreateDisplayFilters, arrayList5, networkSurvey.getSettings(), themeConfigurationFindMatchingThemeConfig));
        }
        return arrayList;
    }

    private static final void validateSurveyPoints(List<? extends SurveyPoint> list) {
        for (SurveyPoint surveyPoint : list) {
            validateAnswerType(surveyPoint);
            if (surveyPoint instanceof SurveyQuestionSurveyPoint) {
                validatePossibleAnswers((SurveyQuestionSurveyPoint) surveyPoint);
            }
        }
    }

    private static final void validateAnswerType(SurveyPoint surveyPoint) {
        if (SurveyAnswerType.INSTANCE.fromString(surveyPoint.getAnswerType()) == null) {
            throw new IllegalArgumentException(("Unknown answer type: " + surveyPoint.getAnswerType()).toString());
        }
    }

    private static final void validatePossibleAnswers(SurveyQuestionSurveyPoint surveyQuestionSurveyPoint) {
        if (Intrinsics.areEqual(surveyQuestionSurveyPoint.getAnswerType(), SurveyAnswerType.TEXT.getKey()) || Intrinsics.areEqual(surveyQuestionSurveyPoint.getAnswerType(), SurveyAnswerType.DATE.getKey())) {
            return;
        }
        Iterator<QuestionPointAnswer> it = surveyQuestionSurveyPoint.getAnswers().iterator();
        while (it.hasNext()) {
            if (it.next().getPossibleAnswer() == null) {
                throw new IllegalArgumentException(("The possibleAnswer value is missing for answer type: " + surveyQuestionSurveyPoint.getAnswerType()).toString());
            }
        }
        if (Intrinsics.areEqual(surveyQuestionSurveyPoint.getAnswerType(), SurveyAnswerType.SMILEY_SCALE.getKey())) {
            validateSmileyScaleAnswers(surveyQuestionSurveyPoint.getAnswers());
        }
    }

    private static final void validateSmileyScaleAnswers(List<QuestionPointAnswer> list) {
        if (!SmileyScaleUtils.INSTANCE.validateAnswerOptions(list)) {
            throw new IllegalArgumentException("Invalid Smiley Scale answer options".toString());
        }
    }

    private static final ThemeConfiguration findMatchingThemeConfig(List<NetworkTheme> list, NetworkSurvey networkSurvey) {
        Object next;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((NetworkTheme) next).getId() == networkSurvey.getThemeId()) {
                break;
            }
        }
        NetworkTheme networkTheme = (NetworkTheme) next;
        if (networkTheme == null) {
            throw new IllegalArgumentException("Theme not found for survey " + networkSurvey.getId());
        }
        return NetworkThemeKt.toThemeConfiguration(networkTheme);
    }

    private static final List<EventSuggestion> mapMobileTargetingEvents(NetworkWorkspace networkWorkspace) {
        List<NetworkTargetingEvent> targetingEvents = networkWorkspace.getTargetingEvents();
        ArrayList arrayList = new ArrayList();
        for (Object obj : targetingEvents) {
            if (Intrinsics.areEqual(((NetworkTargetingEvent) obj).getType(), NetworkTargetingEvent.TYPE_MOBILE)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(NetworkTargetingEventKt.toEventSuggestion((NetworkTargetingEvent) it.next()));
        }
        return arrayList3;
    }
}

package com.survicate.surveys.entities.survey;

import com.survicate.surveys.entities.models.EventSuggestion;
import com.survicate.surveys.entities.survey.translations.SurveyTranslation;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Workspace.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003J\t\u0010(\u001a\u00020\u000eHÆ\u0003J\t\u0010)\u001a\u00020\u000eHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005HÆ\u0003J{\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018¨\u00061"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/Workspace;", "", "lastUpdatedAt", "Ljava/util/Date;", "surveys", "", "Lcom/survicate/surveys/entities/survey/Survey;", "integrations", "Lcom/survicate/surveys/entities/survey/Integration;", "panelAnswerUrlTemplate", "", "eventSuggestions", "Lcom/survicate/surveys/entities/models/EventSuggestion;", "eventSuggestionsEnabled", "", "backendTargetingEnabled", "enforceUserAuthentication", "translations", "Lcom/survicate/surveys/entities/survey/translations/SurveyTranslation;", "<init>", "(Ljava/util/Date;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;ZZZLjava/util/List;)V", "getLastUpdatedAt", "()Ljava/util/Date;", "getSurveys", "()Ljava/util/List;", "getIntegrations", "getPanelAnswerUrlTemplate", "()Ljava/lang/String;", "getEventSuggestions", "getEventSuggestionsEnabled", "()Z", "getBackendTargetingEnabled", "getEnforceUserAuthentication", "getTranslations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class Workspace {
    private final boolean backendTargetingEnabled;
    private final boolean enforceUserAuthentication;
    private final List<EventSuggestion> eventSuggestions;
    private final boolean eventSuggestionsEnabled;
    private final List<Integration> integrations;
    private final Date lastUpdatedAt;
    private final String panelAnswerUrlTemplate;
    private final List<Survey> surveys;
    private final List<SurveyTranslation> translations;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Workspace copy$default(Workspace workspace, Date date, List list, List list2, String str, List list3, boolean z, boolean z2, boolean z3, List list4, int i, Object obj) {
        if ((i & 1) != 0) {
            date = workspace.lastUpdatedAt;
        }
        if ((i & 2) != 0) {
            list = workspace.surveys;
        }
        if ((i & 4) != 0) {
            list2 = workspace.integrations;
        }
        if ((i & 8) != 0) {
            str = workspace.panelAnswerUrlTemplate;
        }
        if ((i & 16) != 0) {
            list3 = workspace.eventSuggestions;
        }
        if ((i & 32) != 0) {
            z = workspace.eventSuggestionsEnabled;
        }
        if ((i & 64) != 0) {
            z2 = workspace.backendTargetingEnabled;
        }
        if ((i & 128) != 0) {
            z3 = workspace.enforceUserAuthentication;
        }
        if ((i & 256) != 0) {
            list4 = workspace.translations;
        }
        boolean z4 = z3;
        List list5 = list4;
        boolean z5 = z;
        boolean z6 = z2;
        List list6 = list3;
        List list7 = list2;
        return workspace.copy(date, list, list7, str, list6, z5, z6, z4, list5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Date getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public final List<Survey> component2() {
        return this.surveys;
    }

    public final List<Integration> component3() {
        return this.integrations;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPanelAnswerUrlTemplate() {
        return this.panelAnswerUrlTemplate;
    }

    public final List<EventSuggestion> component5() {
        return this.eventSuggestions;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getEventSuggestionsEnabled() {
        return this.eventSuggestionsEnabled;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getBackendTargetingEnabled() {
        return this.backendTargetingEnabled;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getEnforceUserAuthentication() {
        return this.enforceUserAuthentication;
    }

    public final List<SurveyTranslation> component9() {
        return this.translations;
    }

    public final Workspace copy(Date lastUpdatedAt, List<Survey> surveys, List<Integration> integrations, String panelAnswerUrlTemplate, List<EventSuggestion> eventSuggestions, boolean eventSuggestionsEnabled, boolean backendTargetingEnabled, boolean enforceUserAuthentication, List<SurveyTranslation> translations) {
        Intrinsics.checkNotNullParameter(lastUpdatedAt, "lastUpdatedAt");
        Intrinsics.checkNotNullParameter(surveys, "surveys");
        Intrinsics.checkNotNullParameter(integrations, "integrations");
        Intrinsics.checkNotNullParameter(panelAnswerUrlTemplate, "panelAnswerUrlTemplate");
        Intrinsics.checkNotNullParameter(eventSuggestions, "eventSuggestions");
        Intrinsics.checkNotNullParameter(translations, "translations");
        return new Workspace(lastUpdatedAt, surveys, integrations, panelAnswerUrlTemplate, eventSuggestions, eventSuggestionsEnabled, backendTargetingEnabled, enforceUserAuthentication, translations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Workspace)) {
            return false;
        }
        Workspace workspace = (Workspace) other;
        return Intrinsics.areEqual(this.lastUpdatedAt, workspace.lastUpdatedAt) && Intrinsics.areEqual(this.surveys, workspace.surveys) && Intrinsics.areEqual(this.integrations, workspace.integrations) && Intrinsics.areEqual(this.panelAnswerUrlTemplate, workspace.panelAnswerUrlTemplate) && Intrinsics.areEqual(this.eventSuggestions, workspace.eventSuggestions) && this.eventSuggestionsEnabled == workspace.eventSuggestionsEnabled && this.backendTargetingEnabled == workspace.backendTargetingEnabled && this.enforceUserAuthentication == workspace.enforceUserAuthentication && Intrinsics.areEqual(this.translations, workspace.translations);
    }

    public int hashCode() {
        return (((((((((((((((this.lastUpdatedAt.hashCode() * 31) + this.surveys.hashCode()) * 31) + this.integrations.hashCode()) * 31) + this.panelAnswerUrlTemplate.hashCode()) * 31) + this.eventSuggestions.hashCode()) * 31) + Boolean.hashCode(this.eventSuggestionsEnabled)) * 31) + Boolean.hashCode(this.backendTargetingEnabled)) * 31) + Boolean.hashCode(this.enforceUserAuthentication)) * 31) + this.translations.hashCode();
    }

    public String toString() {
        return "Workspace(lastUpdatedAt=" + this.lastUpdatedAt + ", surveys=" + this.surveys + ", integrations=" + this.integrations + ", panelAnswerUrlTemplate=" + this.panelAnswerUrlTemplate + ", eventSuggestions=" + this.eventSuggestions + ", eventSuggestionsEnabled=" + this.eventSuggestionsEnabled + ", backendTargetingEnabled=" + this.backendTargetingEnabled + ", enforceUserAuthentication=" + this.enforceUserAuthentication + ", translations=" + this.translations + ')';
    }

    public Workspace(Date lastUpdatedAt, List<Survey> surveys, List<Integration> integrations, String panelAnswerUrlTemplate, List<EventSuggestion> eventSuggestions, boolean z, boolean z2, boolean z3, List<SurveyTranslation> translations) {
        Intrinsics.checkNotNullParameter(lastUpdatedAt, "lastUpdatedAt");
        Intrinsics.checkNotNullParameter(surveys, "surveys");
        Intrinsics.checkNotNullParameter(integrations, "integrations");
        Intrinsics.checkNotNullParameter(panelAnswerUrlTemplate, "panelAnswerUrlTemplate");
        Intrinsics.checkNotNullParameter(eventSuggestions, "eventSuggestions");
        Intrinsics.checkNotNullParameter(translations, "translations");
        this.lastUpdatedAt = lastUpdatedAt;
        this.surveys = surveys;
        this.integrations = integrations;
        this.panelAnswerUrlTemplate = panelAnswerUrlTemplate;
        this.eventSuggestions = eventSuggestions;
        this.eventSuggestionsEnabled = z;
        this.backendTargetingEnabled = z2;
        this.enforceUserAuthentication = z3;
        this.translations = translations;
    }

    public final Date getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public final List<Survey> getSurveys() {
        return this.surveys;
    }

    public final List<Integration> getIntegrations() {
        return this.integrations;
    }

    public final String getPanelAnswerUrlTemplate() {
        return this.panelAnswerUrlTemplate;
    }

    public final List<EventSuggestion> getEventSuggestions() {
        return this.eventSuggestions;
    }

    public final boolean getEventSuggestionsEnabled() {
        return this.eventSuggestionsEnabled;
    }

    public final boolean getBackendTargetingEnabled() {
        return this.backendTargetingEnabled;
    }

    public final boolean getEnforceUserAuthentication() {
        return this.enforceUserAuthentication;
    }

    public final List<SurveyTranslation> getTranslations() {
        return this.translations;
    }
}

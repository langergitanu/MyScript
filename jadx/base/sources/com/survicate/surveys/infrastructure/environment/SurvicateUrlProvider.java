package com.survicate.surveys.infrastructure.environment;

import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SurvicateUrlProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/environment/SurvicateUrlProvider;", "Lcom/survicate/surveys/infrastructure/environment/UrlProvider;", "hostProvider", "Lcom/survicate/surveys/infrastructure/environment/HostProvider;", "workspaceKeyProvider", "Lcom/survicate/surveys/infrastructure/environment/WorkspaceKeyProvider;", "<init>", "(Lcom/survicate/surveys/infrastructure/environment/HostProvider;Lcom/survicate/surveys/infrastructure/environment/WorkspaceKeyProvider;)V", "surveyBaseUrl", "", "respondentBaseUrl", "contactsBaseUrl", "resolveWorkspaceUrl", "Ljava/net/URI;", "resolveInstalledUrl", "resolveQuestionAnsweredUrl", "surveyId", "resolveSurveySeenUrl", "resolveEventSuggestionUrl", "resolveFollowUpQuestionUrl", "resolveUserVerificationUrl", "resolveUserAttributesUrl", "resolveUserEventsUrl", "resolveSurveyInteractionsUrl", "resolveBackendTargetingUrl", "getRespondentUrl", "endpoint", "getEndpointStringUrl", "apiHost", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateUrlProvider implements UrlProvider {
    private final String contactsBaseUrl;
    private final String respondentBaseUrl;
    private final String surveyBaseUrl;
    private final WorkspaceKeyProvider workspaceKeyProvider;

    public SurvicateUrlProvider(HostProvider hostProvider, WorkspaceKeyProvider workspaceKeyProvider) {
        Intrinsics.checkNotNullParameter(hostProvider, "hostProvider");
        Intrinsics.checkNotNullParameter(workspaceKeyProvider, "workspaceKeyProvider");
        this.workspaceKeyProvider = workspaceKeyProvider;
        this.surveyBaseUrl = hostProvider.obtainSurveyHost();
        this.respondentBaseUrl = hostProvider.obtainRespondentHost();
        this.contactsBaseUrl = hostProvider.obtainContactsHost();
    }

    @Override // com.survicate.surveys.infrastructure.environment.UrlProvider
    public URI resolveWorkspaceUrl() {
        return new URI(getEndpointStringUrl(this.surveyBaseUrl, "workspaces/{workspaceKey}/mobile_surveys_v8_2.json"));
    }

    @Override // com.survicate.surveys.infrastructure.environment.UrlProvider
    public URI resolveInstalledUrl() {
        return new URI(getEndpointStringUrl(this.respondentBaseUrl, "workspaces/{workspaceKey}/installed.json"));
    }

    @Override // com.survicate.surveys.infrastructure.environment.UrlProvider
    public URI resolveQuestionAnsweredUrl(String surveyId) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        return getRespondentUrl("workspaces/{workspaceKey}/surveys/{surveyId}/answered_v3.json", surveyId);
    }

    @Override // com.survicate.surveys.infrastructure.environment.UrlProvider
    public URI resolveSurveySeenUrl(String surveyId) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        return getRespondentUrl("workspaces/{workspaceKey}/surveys/{surveyId}/seen.json", surveyId);
    }

    @Override // com.survicate.surveys.infrastructure.environment.UrlProvider
    public URI resolveEventSuggestionUrl() {
        return new URI(getEndpointStringUrl(this.respondentBaseUrl, "workspaces/{workspaceKey}/targeting_event.json"));
    }

    @Override // com.survicate.surveys.infrastructure.environment.UrlProvider
    public URI resolveFollowUpQuestionUrl() {
        return new URI(getEndpointStringUrl(this.respondentBaseUrl, "boosted-questions/generate-questions"));
    }

    @Override // com.survicate.surveys.infrastructure.environment.UrlProvider
    public URI resolveUserVerificationUrl() {
        return new URI(getEndpointStringUrl(this.contactsBaseUrl, "contacts/workspaces/{workspaceKey}/verify_user"));
    }

    @Override // com.survicate.surveys.infrastructure.environment.UrlProvider
    public URI resolveUserAttributesUrl() {
        return new URI(getEndpointStringUrl(this.contactsBaseUrl, "contacts/workspaces/{workspaceKey}/user_attributes"));
    }

    @Override // com.survicate.surveys.infrastructure.environment.UrlProvider
    public URI resolveUserEventsUrl() {
        return new URI(getEndpointStringUrl(this.contactsBaseUrl, "contacts/workspaces/{workspaceKey}/user_events"));
    }

    @Override // com.survicate.surveys.infrastructure.environment.UrlProvider
    public URI resolveSurveyInteractionsUrl() {
        return new URI(getEndpointStringUrl(this.contactsBaseUrl, "contacts/workspaces/{workspaceKey}/survey_interactions"));
    }

    @Override // com.survicate.surveys.infrastructure.environment.UrlProvider
    public URI resolveBackendTargetingUrl() {
        return new URI(getEndpointStringUrl(this.contactsBaseUrl, "contacts/workspaces/{workspaceKey}/targeting"));
    }

    private final URI getRespondentUrl(String endpoint, String surveyId) {
        return new URI(StringsKt.replace$default(getEndpointStringUrl(this.respondentBaseUrl, endpoint), "{surveyId}", surveyId, false, 4, (Object) null));
    }

    private final String getEndpointStringUrl(String apiHost, String endpoint) {
        return StringsKt.replace$default(apiHost + endpoint, "{workspaceKey}", this.workspaceKeyProvider.getWorkspaceKey(), false, 4, (Object) null);
    }
}

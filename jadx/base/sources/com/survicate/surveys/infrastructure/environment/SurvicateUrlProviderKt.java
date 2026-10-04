package com.survicate.surveys.infrastructure.environment;

import kotlin.Metadata;

/* JADX INFO: compiled from: SurvicateUrlProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"WORKSPACE_KEY_PLACEHOLDER", "", "SURVEY_ID_PLACEHOLDER", "WORKSPACE_ENDPOINT", "INSTALLED_ENDPOINT", "ANSWERS_ENDPOINT", "SEEN_ENDPOINT", "EVENT_SUGGESTION_ENDPOINT", "FOLLOW_UP_QUESTION_ENDPOINT", "USER_VERIFICATION_ENDPOINT", "USER_ATTRIBUTES_ENDPOINT", "USER_EVENTS_ENDPOINT", "SURVEY_INTERACTIONS_ENDPOINT", "BACKEND_TARGETING_ENDPOINT", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateUrlProviderKt {
    private static final String ANSWERS_ENDPOINT = "workspaces/{workspaceKey}/surveys/{surveyId}/answered_v3.json";
    private static final String BACKEND_TARGETING_ENDPOINT = "contacts/workspaces/{workspaceKey}/targeting";
    private static final String EVENT_SUGGESTION_ENDPOINT = "workspaces/{workspaceKey}/targeting_event.json";
    private static final String FOLLOW_UP_QUESTION_ENDPOINT = "boosted-questions/generate-questions";
    private static final String INSTALLED_ENDPOINT = "workspaces/{workspaceKey}/installed.json";
    private static final String SEEN_ENDPOINT = "workspaces/{workspaceKey}/surveys/{surveyId}/seen.json";
    private static final String SURVEY_ID_PLACEHOLDER = "{surveyId}";
    private static final String SURVEY_INTERACTIONS_ENDPOINT = "contacts/workspaces/{workspaceKey}/survey_interactions";
    private static final String USER_ATTRIBUTES_ENDPOINT = "contacts/workspaces/{workspaceKey}/user_attributes";
    private static final String USER_EVENTS_ENDPOINT = "contacts/workspaces/{workspaceKey}/user_events";
    private static final String USER_VERIFICATION_ENDPOINT = "contacts/workspaces/{workspaceKey}/verify_user";
    private static final String WORKSPACE_ENDPOINT = "workspaces/{workspaceKey}/mobile_surveys_v8_2.json";
    private static final String WORKSPACE_KEY_PLACEHOLDER = "{workspaceKey}";
}

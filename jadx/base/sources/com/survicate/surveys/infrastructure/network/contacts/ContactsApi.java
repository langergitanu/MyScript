package com.survicate.surveys.infrastructure.network.contacts;

import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContactsApi.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH&¨\u0006\u0010"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApi;", "", "verifyUser", "", "requestBody", "Lcom/survicate/surveys/infrastructure/network/contacts/UserVerificationRequestBody;", "sendUserAttributes", "Lcom/survicate/surveys/infrastructure/network/contacts/UserAttributesRequestBody;", "sendUserEvents", "Lcom/survicate/surveys/infrastructure/network/contacts/UserEventsRequestBody;", "sendSurveyInteractions", "Lcom/survicate/surveys/infrastructure/network/contacts/SurveyInteractionsRequestBody;", "checkBackendTargeting", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingResult;", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingRequestBody;", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ContactsApi {
    public static final int ATTRIBUTES_CHUNK_SIZE = 100;
    public static final int CHAR_LIMIT = 255;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int EVENTS_CHUNK_SIZE = 100;

    BackendTargetingResult checkBackendTargeting(BackendTargetingRequestBody requestBody) throws IOException;

    void sendSurveyInteractions(SurveyInteractionsRequestBody requestBody) throws IOException;

    void sendUserAttributes(UserAttributesRequestBody requestBody) throws IOException;

    void sendUserEvents(UserEventsRequestBody requestBody) throws IOException;

    void verifyUser(UserVerificationRequestBody requestBody) throws IOException;

    /* JADX INFO: compiled from: ContactsApi.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApi$Companion;", "", "<init>", "()V", "CHAR_LIMIT", "", "ATTRIBUTES_CHUNK_SIZE", "EVENTS_CHUNK_SIZE", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ATTRIBUTES_CHUNK_SIZE = 100;
        public static final int CHAR_LIMIT = 255;
        public static final int EVENTS_CHUNK_SIZE = 100;

        private Companion() {
        }
    }
}

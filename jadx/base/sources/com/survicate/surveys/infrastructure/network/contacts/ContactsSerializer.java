package com.survicate.surveys.infrastructure.network.contacts;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContactsSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H&¨\u0006\u0014"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsSerializer;", "", "serializeUserVerificationRequestBody", "", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/contacts/UserVerificationRequestBody;", "serializeUserAttributesRequestBody", "Lcom/survicate/surveys/infrastructure/network/contacts/UserAttributesRequestBody;", "serializeUserEventsRequestBody", "Lcom/survicate/surveys/infrastructure/network/contacts/UserEventsRequestBody;", "serializeSurveyInteractionsRequestBody", "Lcom/survicate/surveys/infrastructure/network/contacts/SurveyInteractionsRequestBody;", "serializeBackendTargetingRequestBody", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingRequestBody;", "deserializeBackendTargetingResult", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingResult;", "response", "deserializeErrorBody", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsErrorBody;", "rawBody", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ContactsSerializer {
    BackendTargetingResult deserializeBackendTargetingResult(String response);

    ContactsErrorBody deserializeErrorBody(String rawBody);

    String serializeBackendTargetingRequestBody(BackendTargetingRequestBody body);

    String serializeSurveyInteractionsRequestBody(SurveyInteractionsRequestBody body);

    String serializeUserAttributesRequestBody(UserAttributesRequestBody body);

    String serializeUserEventsRequestBody(UserEventsRequestBody body);

    String serializeUserVerificationRequestBody(UserVerificationRequestBody body);
}

package com.survicate.surveys.infrastructure.network.contacts;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.infrastructure.network.URLRequest;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContactsRequestFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH&¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsRequestFactory;", "", "createUserVerificationRequest", "Lcom/survicate/surveys/infrastructure/network/URLRequest;", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/contacts/UserVerificationRequestBody;", "createUserAttributesRequest", "Lcom/survicate/surveys/infrastructure/network/contacts/UserAttributesRequestBody;", "createUserEventsRequest", "Lcom/survicate/surveys/infrastructure/network/contacts/UserEventsRequestBody;", "createSurveyInteractionsRequest", "Lcom/survicate/surveys/infrastructure/network/contacts/SurveyInteractionsRequestBody;", "createBackendTargetingRequest", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ContactsRequestFactory {
    URLRequest createBackendTargetingRequest(BackendTargetingRequestBody body);

    URLRequest createSurveyInteractionsRequest(SurveyInteractionsRequestBody body);

    URLRequest createUserAttributesRequest(UserAttributesRequestBody body);

    URLRequest createUserEventsRequest(UserEventsRequestBody body);

    URLRequest createUserVerificationRequest(UserVerificationRequestBody body);
}

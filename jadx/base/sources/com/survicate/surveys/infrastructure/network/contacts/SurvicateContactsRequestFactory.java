package com.survicate.surveys.infrastructure.network.contacts;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.infrastructure.environment.UrlProvider;
import com.survicate.surveys.infrastructure.network.URLRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactsRequestFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/SurvicateContactsRequestFactory;", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsRequestFactory;", "urlProvider", "Lcom/survicate/surveys/infrastructure/environment/UrlProvider;", "contactsSerializer", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsSerializer;", "<init>", "(Lcom/survicate/surveys/infrastructure/environment/UrlProvider;Lcom/survicate/surveys/infrastructure/network/contacts/ContactsSerializer;)V", "createUserVerificationRequest", "Lcom/survicate/surveys/infrastructure/network/URLRequest;", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/contacts/UserVerificationRequestBody;", "createUserAttributesRequest", "Lcom/survicate/surveys/infrastructure/network/contacts/UserAttributesRequestBody;", "createUserEventsRequest", "Lcom/survicate/surveys/infrastructure/network/contacts/UserEventsRequestBody;", "createSurveyInteractionsRequest", "Lcom/survicate/surveys/infrastructure/network/contacts/SurveyInteractionsRequestBody;", "createBackendTargetingRequest", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateContactsRequestFactory implements ContactsRequestFactory {
    private final ContactsSerializer contactsSerializer;
    private final UrlProvider urlProvider;

    public SurvicateContactsRequestFactory(UrlProvider urlProvider, ContactsSerializer contactsSerializer) {
        Intrinsics.checkNotNullParameter(urlProvider, "urlProvider");
        Intrinsics.checkNotNullParameter(contactsSerializer, "contactsSerializer");
        this.urlProvider = urlProvider;
        this.contactsSerializer = contactsSerializer;
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsRequestFactory
    public URLRequest createUserVerificationRequest(UserVerificationRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return new URLRequest(this.urlProvider.resolveUserVerificationUrl(), "POST", this.contactsSerializer.serializeUserVerificationRequestBody(body));
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsRequestFactory
    public URLRequest createUserAttributesRequest(UserAttributesRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return new URLRequest(this.urlProvider.resolveUserAttributesUrl(), "POST", this.contactsSerializer.serializeUserAttributesRequestBody(body));
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsRequestFactory
    public URLRequest createUserEventsRequest(UserEventsRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return new URLRequest(this.urlProvider.resolveUserEventsUrl(), "POST", this.contactsSerializer.serializeUserEventsRequestBody(body));
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsRequestFactory
    public URLRequest createSurveyInteractionsRequest(SurveyInteractionsRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return new URLRequest(this.urlProvider.resolveSurveyInteractionsUrl(), "POST", this.contactsSerializer.serializeSurveyInteractionsRequestBody(body));
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsRequestFactory
    public URLRequest createBackendTargetingRequest(BackendTargetingRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return new URLRequest(this.urlProvider.resolveBackendTargetingUrl(), "POST", this.contactsSerializer.serializeBackendTargetingRequestBody(body));
    }
}

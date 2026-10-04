package com.survicate.surveys.infrastructure.network.contacts;

import androidx.exifinterface.media.ExifInterface;
import com.survicate.surveys.infrastructure.network.HttpException;
import com.survicate.surveys.infrastructure.network.SurvicateHttpClient;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactsApi.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0016H\u0016J!\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001aH\u0002¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/SurvicateContactsApi;", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApi;", "httpClient", "Lcom/survicate/surveys/infrastructure/network/SurvicateHttpClient;", "requestFactory", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsRequestFactory;", "serializer", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsSerializer;", "<init>", "(Lcom/survicate/surveys/infrastructure/network/SurvicateHttpClient;Lcom/survicate/surveys/infrastructure/network/contacts/ContactsRequestFactory;Lcom/survicate/surveys/infrastructure/network/contacts/ContactsSerializer;)V", "verifyUser", "", "requestBody", "Lcom/survicate/surveys/infrastructure/network/contacts/UserVerificationRequestBody;", "sendUserAttributes", "Lcom/survicate/surveys/infrastructure/network/contacts/UserAttributesRequestBody;", "sendUserEvents", "Lcom/survicate/surveys/infrastructure/network/contacts/UserEventsRequestBody;", "sendSurveyInteractions", "Lcom/survicate/surveys/infrastructure/network/contacts/SurveyInteractionsRequestBody;", "checkBackendTargeting", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingResult;", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingRequestBody;", "runMappingException", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "parseErrorMessage", "", "exception", "Lcom/survicate/surveys/infrastructure/network/HttpException;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateContactsApi implements ContactsApi {
    private final SurvicateHttpClient httpClient;
    private final ContactsRequestFactory requestFactory;
    private final ContactsSerializer serializer;

    public SurvicateContactsApi(SurvicateHttpClient httpClient, ContactsRequestFactory requestFactory, ContactsSerializer serializer) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.httpClient = httpClient;
        this.requestFactory = requestFactory;
        this.serializer = serializer;
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsApi
    public void verifyUser(final UserVerificationRequestBody requestBody) throws ContactsHttpException {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        runMappingException(new Function0() { // from class: com.survicate.surveys.infrastructure.network.contacts.SurvicateContactsApi$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurvicateContactsApi.verifyUser$lambda$0(this.f$0, requestBody);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String verifyUser$lambda$0(SurvicateContactsApi survicateContactsApi, UserVerificationRequestBody userVerificationRequestBody) {
        return survicateContactsApi.httpClient.loadUrlResponse(survicateContactsApi.requestFactory.createUserVerificationRequest(userVerificationRequestBody));
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsApi
    public void sendUserAttributes(final UserAttributesRequestBody requestBody) throws ContactsHttpException {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        runMappingException(new Function0() { // from class: com.survicate.surveys.infrastructure.network.contacts.SurvicateContactsApi$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurvicateContactsApi.sendUserAttributes$lambda$1(this.f$0, requestBody);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sendUserAttributes$lambda$1(SurvicateContactsApi survicateContactsApi, UserAttributesRequestBody userAttributesRequestBody) {
        return survicateContactsApi.httpClient.loadUrlResponse(survicateContactsApi.requestFactory.createUserAttributesRequest(userAttributesRequestBody));
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsApi
    public void sendUserEvents(final UserEventsRequestBody requestBody) throws ContactsHttpException {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        runMappingException(new Function0() { // from class: com.survicate.surveys.infrastructure.network.contacts.SurvicateContactsApi$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurvicateContactsApi.sendUserEvents$lambda$2(this.f$0, requestBody);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sendUserEvents$lambda$2(SurvicateContactsApi survicateContactsApi, UserEventsRequestBody userEventsRequestBody) {
        return survicateContactsApi.httpClient.loadUrlResponse(survicateContactsApi.requestFactory.createUserEventsRequest(userEventsRequestBody));
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsApi
    public void sendSurveyInteractions(final SurveyInteractionsRequestBody requestBody) throws ContactsHttpException {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        runMappingException(new Function0() { // from class: com.survicate.surveys.infrastructure.network.contacts.SurvicateContactsApi$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurvicateContactsApi.sendSurveyInteractions$lambda$3(this.f$0, requestBody);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sendSurveyInteractions$lambda$3(SurvicateContactsApi survicateContactsApi, SurveyInteractionsRequestBody surveyInteractionsRequestBody) {
        return survicateContactsApi.httpClient.loadUrlResponse(survicateContactsApi.requestFactory.createSurveyInteractionsRequest(surveyInteractionsRequestBody));
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsApi
    public BackendTargetingResult checkBackendTargeting(final BackendTargetingRequestBody requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        return (BackendTargetingResult) runMappingException(new Function0() { // from class: com.survicate.surveys.infrastructure.network.contacts.SurvicateContactsApi$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurvicateContactsApi.checkBackendTargeting$lambda$4(this.f$0, requestBody);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackendTargetingResult checkBackendTargeting$lambda$4(SurvicateContactsApi survicateContactsApi, BackendTargetingRequestBody backendTargetingRequestBody) throws IOException {
        String strLoadUrlResponse = survicateContactsApi.httpClient.loadUrlResponse(survicateContactsApi.requestFactory.createBackendTargetingRequest(backendTargetingRequestBody));
        if (strLoadUrlResponse == null) {
            throw new IOException("Failed to check backend targeting: empty API response");
        }
        return survicateContactsApi.serializer.deserializeBackendTargetingResult(strLoadUrlResponse);
    }

    private final <T> T runMappingException(Function0<? extends T> block) throws ContactsHttpException {
        try {
            return block.invoke();
        } catch (HttpException e) {
            throw new ContactsHttpException(e.getResponseCode(), parseErrorMessage(e));
        }
    }

    private final String parseErrorMessage(HttpException exception) {
        String errorBody = exception.getErrorBody();
        if (errorBody == null) {
            return "";
        }
        try {
            return this.serializer.deserializeErrorBody(errorBody).getMessage();
        } catch (Exception unused) {
            return "";
        }
    }
}

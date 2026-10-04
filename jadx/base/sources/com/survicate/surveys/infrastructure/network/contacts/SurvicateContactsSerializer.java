package com.survicate.surveys.infrastructure.network.contacts;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: ContactsSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/SurvicateContactsSerializer;", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsSerializer;", "jsonSerialization", "Lkotlinx/serialization/json/Json;", "<init>", "(Lkotlinx/serialization/json/Json;)V", "serializeUserVerificationRequestBody", "", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/contacts/UserVerificationRequestBody;", "serializeUserAttributesRequestBody", "Lcom/survicate/surveys/infrastructure/network/contacts/UserAttributesRequestBody;", "serializeUserEventsRequestBody", "Lcom/survicate/surveys/infrastructure/network/contacts/UserEventsRequestBody;", "serializeSurveyInteractionsRequestBody", "Lcom/survicate/surveys/infrastructure/network/contacts/SurveyInteractionsRequestBody;", "serializeBackendTargetingRequestBody", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingRequestBody;", "deserializeBackendTargetingResult", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingResult;", "response", "deserializeErrorBody", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsErrorBody;", "rawBody", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateContactsSerializer implements ContactsSerializer {
    private final Json jsonSerialization;

    public SurvicateContactsSerializer(Json jsonSerialization) {
        Intrinsics.checkNotNullParameter(jsonSerialization, "jsonSerialization");
        this.jsonSerialization = jsonSerialization;
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsSerializer
    public String serializeUserVerificationRequestBody(UserVerificationRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return json.encodeToString(UserVerificationRequestBody.INSTANCE.serializer(), body);
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsSerializer
    public String serializeUserAttributesRequestBody(UserAttributesRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return json.encodeToString(UserAttributesRequestBody.INSTANCE.serializer(), body);
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsSerializer
    public String serializeUserEventsRequestBody(UserEventsRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return json.encodeToString(UserEventsRequestBody.INSTANCE.serializer(), body);
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsSerializer
    public String serializeSurveyInteractionsRequestBody(SurveyInteractionsRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return json.encodeToString(SurveyInteractionsRequestBody.INSTANCE.serializer(), body);
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsSerializer
    public String serializeBackendTargetingRequestBody(BackendTargetingRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return json.encodeToString(BackendTargetingRequestBody.INSTANCE.serializer(), body);
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsSerializer
    public BackendTargetingResult deserializeBackendTargetingResult(String response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return (BackendTargetingResult) json.decodeFromString(BackendTargetingResult.INSTANCE.serializer(), response);
    }

    @Override // com.survicate.surveys.infrastructure.network.contacts.ContactsSerializer
    public ContactsErrorBody deserializeErrorBody(String rawBody) {
        Intrinsics.checkNotNullParameter(rawBody, "rawBody");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return (ContactsErrorBody) json.decodeFromString(ContactsErrorBody.INSTANCE.serializer(), rawBody);
    }
}

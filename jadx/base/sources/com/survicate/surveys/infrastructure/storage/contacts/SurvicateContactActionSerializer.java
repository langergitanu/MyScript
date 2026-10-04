package com.survicate.surveys.infrastructure.storage.contacts;

import com.survicate.surveys.entities.models.ContactAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: ContactActionSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/contacts/SurvicateContactActionSerializer;", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactActionSerializer;", "jsonSerialization", "Lkotlinx/serialization/json/Json;", "<init>", "(Lkotlinx/serialization/json/Json;)V", "serializeContactActions", "", "actions", "", "Lcom/survicate/surveys/entities/models/ContactAction;", "deserializeContactActions", "serializedActions", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateContactActionSerializer implements ContactActionSerializer {
    private final Json jsonSerialization;

    public SurvicateContactActionSerializer(Json jsonSerialization) {
        Intrinsics.checkNotNullParameter(jsonSerialization, "jsonSerialization");
        this.jsonSerialization = jsonSerialization;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactActionSerializer
    public String serializeContactActions(List<? extends ContactAction> actions) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return json.encodeToString(new ArrayListSerializer(ContactAction.INSTANCE.serializer()), actions);
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactActionSerializer
    public List<ContactAction> deserializeContactActions(String serializedActions) {
        Intrinsics.checkNotNullParameter(serializedActions, "serializedActions");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return (List) json.decodeFromString(new ArrayListSerializer(ContactAction.INSTANCE.serializer()), serializedActions);
    }
}

package com.survicate.surveys.infrastructure.network.contacts;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.entities.models.ContactAction;
import com.survicate.surveys.infrastructure.network.contacts.ContactsApiModels;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: SurveyInteractionsRequestBody.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 +2\u00020\u0001:\u0002*+B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fBI\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000b\u0010\u0014J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010!¨\u0006,"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/SurveyInteractionsRequestBody;", "", "user", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$User;", "respondent", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Respondent;", "surveys", "", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$SurveyInteraction;", TtmlNode.TAG_METADATA, "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Metadata;", "<init>", "(Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$User;Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Respondent;Ljava/util/List;Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Metadata;)V", "action", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction;", "(Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$User;Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Respondent;Ljava/util/List;Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Metadata;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUser$annotations", "()V", "getUser", "()Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$User;", "getRespondent$annotations", "getRespondent", "()Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Respondent;", "getSurveys$annotations", "getSurveys", "()Ljava/util/List;", "getMetadata$annotations", "getMetadata", "()Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Metadata;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final class SurveyInteractionsRequestBody {
    private final ContactsApiModels.Metadata metadata;
    private final ContactsApiModels.Respondent respondent;
    private final List<ContactsApiModels.SurveyInteraction> surveys;
    private final ContactsApiModels.User user;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.infrastructure.network.contacts.SurveyInteractionsRequestBody$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyInteractionsRequestBody._childSerializers$_anonymous_();
        }
    }), null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(ContactsApiModels$SurveyInteraction$$serializer.INSTANCE);
    }

    @SerialName(TtmlNode.TAG_METADATA)
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @SerialName("respondent")
    public static /* synthetic */ void getRespondent$annotations() {
    }

    @SerialName("surveys")
    public static /* synthetic */ void getSurveys$annotations() {
    }

    @SerialName("user")
    public static /* synthetic */ void getUser$annotations() {
    }

    /* JADX INFO: compiled from: SurveyInteractionsRequestBody.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/SurveyInteractionsRequestBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/contacts/SurveyInteractionsRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyInteractionsRequestBody> serializer() {
            return SurveyInteractionsRequestBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyInteractionsRequestBody(int i, ContactsApiModels.User user, ContactsApiModels.Respondent respondent, List list, ContactsApiModels.Metadata metadata, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, SurveyInteractionsRequestBody$$serializer.INSTANCE.getDescriptor());
        }
        this.user = user;
        this.respondent = respondent;
        this.surveys = list;
        this.metadata = metadata;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyInteractionsRequestBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, ContactsApiModels$User$$serializer.INSTANCE, self.user);
        output.encodeSerializableElement(serialDesc, 1, ContactsApiModels$Respondent$$serializer.INSTANCE, self.respondent);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.surveys);
        output.encodeSerializableElement(serialDesc, 3, ContactsApiModels$Metadata$$serializer.INSTANCE, self.metadata);
    }

    private SurveyInteractionsRequestBody(ContactsApiModels.User user, ContactsApiModels.Respondent respondent, List<ContactsApiModels.SurveyInteraction> list, ContactsApiModels.Metadata metadata) {
        this.user = user;
        this.respondent = respondent;
        this.surveys = list;
        this.metadata = metadata;
    }

    public final ContactsApiModels.User getUser() {
        return this.user;
    }

    public final ContactsApiModels.Respondent getRespondent() {
        return this.respondent;
    }

    public final List<ContactsApiModels.SurveyInteraction> getSurveys() {
        return this.surveys;
    }

    public final ContactsApiModels.Metadata getMetadata() {
        return this.metadata;
    }

    public SurveyInteractionsRequestBody(ContactAction.SurveyInteraction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        ContactsApiModels.User user = new ContactsApiModels.User(action.getUserId(), action.getUserKey());
        ContactsApiModels.Respondent respondent = new ContactsApiModels.Respondent(action.getRespondentUuid());
        List<ContactAction.SurveyInteraction.Interaction> interactions = action.getInteractions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(interactions, 10));
        Iterator<T> it = interactions.iterator();
        while (it.hasNext()) {
            arrayList.add(ContactsApiModelsKt.toApiModel((ContactAction.SurveyInteraction.Interaction) it.next()));
        }
        this(user, respondent, arrayList, ContactsApiModels.INSTANCE.buildMetadata("1.0.0"));
    }
}

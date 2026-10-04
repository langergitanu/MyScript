package com.survicate.surveys.entities.models;

import com.survicate.surveys.entities.models.ContactAction;
import com.survicate.surveys.traits.UserTrait;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: ContactAction.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u000f2\u00020\u0001:\u0006\n\u000b\f\r\u000e\u000fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005\u0082\u0001\u0004\u0010\u0011\u0012\u0013¨\u0006\u0014"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction;", "", "userId", "", "getUserId", "()Ljava/lang/String;", "userKey", "getUserKey", "respondentUuid", "getRespondentUuid", "VerifyUser", "SetAttributes", "InvokeEvent", "SurveyInteraction", "SurveyInteractionType", "Companion", "Lcom/survicate/surveys/entities/models/ContactAction$InvokeEvent;", "Lcom/survicate/surveys/entities/models/ContactAction$SetAttributes;", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction;", "Lcom/survicate/surveys/entities/models/ContactAction$VerifyUser;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public interface ContactAction {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String getRespondentUuid();

    String getUserId();

    String getUserKey();

    /* JADX INFO: compiled from: ContactAction.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/models/ContactAction;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<ContactAction> serializer() {
            return new SealedClassSerializer("com.survicate.surveys.entities.models.ContactAction", Reflection.getOrCreateKotlinClass(ContactAction.class), new KClass[]{Reflection.getOrCreateKotlinClass(InvokeEvent.class), Reflection.getOrCreateKotlinClass(SetAttributes.class), Reflection.getOrCreateKotlinClass(SurveyInteraction.class), Reflection.getOrCreateKotlinClass(VerifyUser.class)}, new KSerializer[]{ContactAction$InvokeEvent$$serializer.INSTANCE, ContactAction$SetAttributes$$serializer.INSTANCE, ContactAction$SurveyInteraction$$serializer.INSTANCE, ContactAction$VerifyUser$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    /* JADX INFO: compiled from: ContactAction.kt */
    @Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010¨\u0006)"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$VerifyUser;", "Lcom/survicate/surveys/entities/models/ContactAction;", "userId", "", "userKey", "respondentUuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUserId$annotations", "()V", "getUserId", "()Ljava/lang/String;", "getUserKey$annotations", "getUserKey", "getRespondentUuid$annotations", "getRespondentUuid", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    @Serializable
    @SerialName("verify")
    public static final /* data */ class VerifyUser implements ContactAction {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String respondentUuid;
        private final String userId;
        private final String userKey;

        public static /* synthetic */ VerifyUser copy$default(VerifyUser verifyUser, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = verifyUser.userId;
            }
            if ((i & 2) != 0) {
                str2 = verifyUser.userKey;
            }
            if ((i & 4) != 0) {
                str3 = verifyUser.respondentUuid;
            }
            return verifyUser.copy(str, str2, str3);
        }

        @SerialName("respondent_uuid")
        public static /* synthetic */ void getRespondentUuid$annotations() {
        }

        @SerialName("user_id")
        public static /* synthetic */ void getUserId$annotations() {
        }

        @SerialName(UserTrait.USER_KEY)
        public static /* synthetic */ void getUserKey$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUserKey() {
            return this.userKey;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getRespondentUuid() {
            return this.respondentUuid;
        }

        public final VerifyUser copy(String userId, String userKey, String respondentUuid) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(userKey, "userKey");
            Intrinsics.checkNotNullParameter(respondentUuid, "respondentUuid");
            return new VerifyUser(userId, userKey, respondentUuid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerifyUser)) {
                return false;
            }
            VerifyUser verifyUser = (VerifyUser) other;
            return Intrinsics.areEqual(this.userId, verifyUser.userId) && Intrinsics.areEqual(this.userKey, verifyUser.userKey) && Intrinsics.areEqual(this.respondentUuid, verifyUser.respondentUuid);
        }

        public int hashCode() {
            return (((this.userId.hashCode() * 31) + this.userKey.hashCode()) * 31) + this.respondentUuid.hashCode();
        }

        public String toString() {
            return "VerifyUser(userId=" + this.userId + ", userKey=" + this.userKey + ", respondentUuid=" + this.respondentUuid + ')';
        }

        /* JADX INFO: compiled from: ContactAction.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$VerifyUser$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/models/ContactAction$VerifyUser;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<VerifyUser> serializer() {
                return ContactAction$VerifyUser$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ VerifyUser(int i, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, ContactAction$VerifyUser$$serializer.INSTANCE.getDescriptor());
            }
            this.userId = str;
            this.userKey = str2;
            this.respondentUuid = str3;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$survicate_sdk_release(VerifyUser self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.getUserId());
            output.encodeStringElement(serialDesc, 1, self.getUserKey());
            output.encodeStringElement(serialDesc, 2, self.getRespondentUuid());
        }

        public VerifyUser(String userId, String userKey, String respondentUuid) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(userKey, "userKey");
            Intrinsics.checkNotNullParameter(respondentUuid, "respondentUuid");
            this.userId = userId;
            this.userKey = userKey;
            this.respondentUuid = respondentUuid;
        }

        @Override // com.survicate.surveys.entities.models.ContactAction
        public String getUserId() {
            return this.userId;
        }

        @Override // com.survicate.surveys.entities.models.ContactAction
        public String getUserKey() {
            return this.userKey;
        }

        @Override // com.survicate.surveys.entities.models.ContactAction
        public String getRespondentUuid() {
            return this.respondentUuid;
        }
    }

    /* JADX INFO: compiled from: ContactAction.kt */
    @Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0003./0B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nBI\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\fHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a¨\u00061"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$SetAttributes;", "Lcom/survicate/surveys/entities/models/ContactAction;", "userId", "", "userKey", "respondentUuid", "attributes", "", "Lcom/survicate/surveys/entities/models/ContactAction$SetAttributes$Attribute;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUserId$annotations", "()V", "getUserId", "()Ljava/lang/String;", "getUserKey$annotations", "getUserKey", "getRespondentUuid$annotations", "getRespondentUuid", "getAttributes$annotations", "getAttributes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "Attribute", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    @Serializable
    @SerialName("set_attributes")
    public static final /* data */ class SetAttributes implements ContactAction {
        private final List<Attribute> attributes;
        private final String respondentUuid;
        private final String userId;
        private final String userKey;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.models.ContactAction$SetAttributes$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ContactAction.SetAttributes._childSerializers$_anonymous_();
            }
        })};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(ContactAction$SetAttributes$Attribute$$serializer.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SetAttributes copy$default(SetAttributes setAttributes, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = setAttributes.userId;
            }
            if ((i & 2) != 0) {
                str2 = setAttributes.userKey;
            }
            if ((i & 4) != 0) {
                str3 = setAttributes.respondentUuid;
            }
            if ((i & 8) != 0) {
                list = setAttributes.attributes;
            }
            return setAttributes.copy(str, str2, str3, list);
        }

        @SerialName("attributes")
        public static /* synthetic */ void getAttributes$annotations() {
        }

        @SerialName("respondent_uuid")
        public static /* synthetic */ void getRespondentUuid$annotations() {
        }

        @SerialName("user_id")
        public static /* synthetic */ void getUserId$annotations() {
        }

        @SerialName(UserTrait.USER_KEY)
        public static /* synthetic */ void getUserKey$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUserKey() {
            return this.userKey;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getRespondentUuid() {
            return this.respondentUuid;
        }

        public final List<Attribute> component4() {
            return this.attributes;
        }

        public final SetAttributes copy(String userId, String userKey, String respondentUuid, List<Attribute> attributes) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(userKey, "userKey");
            Intrinsics.checkNotNullParameter(respondentUuid, "respondentUuid");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            return new SetAttributes(userId, userKey, respondentUuid, attributes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetAttributes)) {
                return false;
            }
            SetAttributes setAttributes = (SetAttributes) other;
            return Intrinsics.areEqual(this.userId, setAttributes.userId) && Intrinsics.areEqual(this.userKey, setAttributes.userKey) && Intrinsics.areEqual(this.respondentUuid, setAttributes.respondentUuid) && Intrinsics.areEqual(this.attributes, setAttributes.attributes);
        }

        public int hashCode() {
            return (((((this.userId.hashCode() * 31) + this.userKey.hashCode()) * 31) + this.respondentUuid.hashCode()) * 31) + this.attributes.hashCode();
        }

        public String toString() {
            return "SetAttributes(userId=" + this.userId + ", userKey=" + this.userKey + ", respondentUuid=" + this.respondentUuid + ", attributes=" + this.attributes + ')';
        }

        /* JADX INFO: compiled from: ContactAction.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$SetAttributes$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/models/ContactAction$SetAttributes;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SetAttributes> serializer() {
                return ContactAction$SetAttributes$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SetAttributes(int i, String str, String str2, String str3, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, ContactAction$SetAttributes$$serializer.INSTANCE.getDescriptor());
            }
            this.userId = str;
            this.userKey = str2;
            this.respondentUuid = str3;
            this.attributes = list;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$survicate_sdk_release(SetAttributes self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.getUserId());
            output.encodeStringElement(serialDesc, 1, self.getUserKey());
            output.encodeStringElement(serialDesc, 2, self.getRespondentUuid());
            output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.attributes);
        }

        public SetAttributes(String userId, String userKey, String respondentUuid, List<Attribute> attributes) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(userKey, "userKey");
            Intrinsics.checkNotNullParameter(respondentUuid, "respondentUuid");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            this.userId = userId;
            this.userKey = userKey;
            this.respondentUuid = respondentUuid;
            this.attributes = attributes;
        }

        @Override // com.survicate.surveys.entities.models.ContactAction
        public String getUserId() {
            return this.userId;
        }

        @Override // com.survicate.surveys.entities.models.ContactAction
        public String getUserKey() {
            return this.userKey;
        }

        @Override // com.survicate.surveys.entities.models.ContactAction
        public String getRespondentUuid() {
            return this.respondentUuid;
        }

        public final List<Attribute> getAttributes() {
            return this.attributes;
        }

        /* JADX INFO: compiled from: ContactAction.kt */
        @Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J.\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$SetAttributes$Attribute;", "", "name", "", "value", "timestampMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getValue$annotations", "getValue", "getTimestampMs$annotations", "getTimestampMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/survicate/surveys/entities/models/ContactAction$SetAttributes$Attribute;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        @Serializable
        public static final /* data */ class Attribute {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String name;
            private final Long timestampMs;
            private final String value;

            public static /* synthetic */ Attribute copy$default(Attribute attribute, String str, String str2, Long l, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = attribute.name;
                }
                if ((i & 2) != 0) {
                    str2 = attribute.value;
                }
                if ((i & 4) != 0) {
                    l = attribute.timestampMs;
                }
                return attribute.copy(str, str2, l);
            }

            @SerialName("name")
            public static /* synthetic */ void getName$annotations() {
            }

            @SerialName("timestamp_ms")
            public static /* synthetic */ void getTimestampMs$annotations() {
            }

            @SerialName("value")
            public static /* synthetic */ void getValue$annotations() {
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Long getTimestampMs() {
                return this.timestampMs;
            }

            public final Attribute copy(String name, String value, Long timestampMs) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                return new Attribute(name, value, timestampMs);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Attribute)) {
                    return false;
                }
                Attribute attribute = (Attribute) other;
                return Intrinsics.areEqual(this.name, attribute.name) && Intrinsics.areEqual(this.value, attribute.value) && Intrinsics.areEqual(this.timestampMs, attribute.timestampMs);
            }

            public int hashCode() {
                int iHashCode = ((this.name.hashCode() * 31) + this.value.hashCode()) * 31;
                Long l = this.timestampMs;
                return iHashCode + (l == null ? 0 : l.hashCode());
            }

            public String toString() {
                return "Attribute(name=" + this.name + ", value=" + this.value + ", timestampMs=" + this.timestampMs + ')';
            }

            /* JADX INFO: compiled from: ContactAction.kt */
            @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$SetAttributes$Attribute$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/models/ContactAction$SetAttributes$Attribute;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Attribute> serializer() {
                    return ContactAction$SetAttributes$Attribute$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ Attribute(int i, String str, String str2, Long l, SerializationConstructorMarker serializationConstructorMarker) {
                if (7 != (i & 7)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 7, ContactAction$SetAttributes$Attribute$$serializer.INSTANCE.getDescriptor());
                }
                this.name = str;
                this.value = str2;
                this.timestampMs = l;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$survicate_sdk_release(Attribute self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeStringElement(serialDesc, 0, self.name);
                output.encodeStringElement(serialDesc, 1, self.value);
                output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.timestampMs);
            }

            public Attribute(String name, String value, Long l) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                this.name = name;
                this.value = value;
                this.timestampMs = l;
            }

            public final String getName() {
                return this.name;
            }

            public final String getValue() {
                return this.value;
            }

            public final Long getTimestampMs() {
                return this.timestampMs;
            }
        }
    }

    /* JADX INFO: compiled from: ContactAction.kt */
    @Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 42\u00020\u0001:\u0003234B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fBQ\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003JA\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u000eHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0005\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0013\u001a\u0004\b\t\u0010\u001e¨\u00065"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$InvokeEvent;", "Lcom/survicate/surveys/entities/models/ContactAction;", "userId", "", "userKey", "respondentUuid", "events", "", "Lcom/survicate/surveys/entities/models/ContactAction$InvokeEvent$Event;", "isScheduled", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUserId$annotations", "()V", "getUserId", "()Ljava/lang/String;", "getUserKey$annotations", "getUserKey", "getRespondentUuid$annotations", "getRespondentUuid", "getEvents$annotations", "getEvents", "()Ljava/util/List;", "isScheduled$annotations", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "Event", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    @Serializable
    @SerialName("invoke_event")
    public static final /* data */ class InvokeEvent implements ContactAction {
        private final List<Event> events;
        private final boolean isScheduled;
        private final String respondentUuid;
        private final String userId;
        private final String userKey;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.models.ContactAction$InvokeEvent$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ContactAction.InvokeEvent._childSerializers$_anonymous_();
            }
        }), null};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(ContactAction$InvokeEvent$Event$$serializer.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvokeEvent copy$default(InvokeEvent invokeEvent, String str, String str2, String str3, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invokeEvent.userId;
            }
            if ((i & 2) != 0) {
                str2 = invokeEvent.userKey;
            }
            if ((i & 4) != 0) {
                str3 = invokeEvent.respondentUuid;
            }
            if ((i & 8) != 0) {
                list = invokeEvent.events;
            }
            if ((i & 16) != 0) {
                z = invokeEvent.isScheduled;
            }
            boolean z2 = z;
            String str4 = str3;
            return invokeEvent.copy(str, str2, str4, list, z2);
        }

        @SerialName("events")
        public static /* synthetic */ void getEvents$annotations() {
        }

        @SerialName("respondent_uuid")
        public static /* synthetic */ void getRespondentUuid$annotations() {
        }

        @SerialName("user_id")
        public static /* synthetic */ void getUserId$annotations() {
        }

        @SerialName(UserTrait.USER_KEY)
        public static /* synthetic */ void getUserKey$annotations() {
        }

        @SerialName("is_scheduled")
        public static /* synthetic */ void isScheduled$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUserKey() {
            return this.userKey;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getRespondentUuid() {
            return this.respondentUuid;
        }

        public final List<Event> component4() {
            return this.events;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsScheduled() {
            return this.isScheduled;
        }

        public final InvokeEvent copy(String userId, String userKey, String respondentUuid, List<Event> events, boolean isScheduled) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(userKey, "userKey");
            Intrinsics.checkNotNullParameter(respondentUuid, "respondentUuid");
            Intrinsics.checkNotNullParameter(events, "events");
            return new InvokeEvent(userId, userKey, respondentUuid, events, isScheduled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvokeEvent)) {
                return false;
            }
            InvokeEvent invokeEvent = (InvokeEvent) other;
            return Intrinsics.areEqual(this.userId, invokeEvent.userId) && Intrinsics.areEqual(this.userKey, invokeEvent.userKey) && Intrinsics.areEqual(this.respondentUuid, invokeEvent.respondentUuid) && Intrinsics.areEqual(this.events, invokeEvent.events) && this.isScheduled == invokeEvent.isScheduled;
        }

        public int hashCode() {
            return (((((((this.userId.hashCode() * 31) + this.userKey.hashCode()) * 31) + this.respondentUuid.hashCode()) * 31) + this.events.hashCode()) * 31) + Boolean.hashCode(this.isScheduled);
        }

        public String toString() {
            return "InvokeEvent(userId=" + this.userId + ", userKey=" + this.userKey + ", respondentUuid=" + this.respondentUuid + ", events=" + this.events + ", isScheduled=" + this.isScheduled + ')';
        }

        /* JADX INFO: compiled from: ContactAction.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$InvokeEvent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/models/ContactAction$InvokeEvent;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<InvokeEvent> serializer() {
                return ContactAction$InvokeEvent$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ InvokeEvent(int i, String str, String str2, String str3, List list, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (i & 31)) {
                PluginExceptionsKt.throwMissingFieldException(i, 31, ContactAction$InvokeEvent$$serializer.INSTANCE.getDescriptor());
            }
            this.userId = str;
            this.userKey = str2;
            this.respondentUuid = str3;
            this.events = list;
            this.isScheduled = z;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$survicate_sdk_release(InvokeEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.getUserId());
            output.encodeStringElement(serialDesc, 1, self.getUserKey());
            output.encodeStringElement(serialDesc, 2, self.getRespondentUuid());
            output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.events);
            output.encodeBooleanElement(serialDesc, 4, self.isScheduled);
        }

        public InvokeEvent(String userId, String userKey, String respondentUuid, List<Event> events, boolean z) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(userKey, "userKey");
            Intrinsics.checkNotNullParameter(respondentUuid, "respondentUuid");
            Intrinsics.checkNotNullParameter(events, "events");
            this.userId = userId;
            this.userKey = userKey;
            this.respondentUuid = respondentUuid;
            this.events = events;
            this.isScheduled = z;
        }

        @Override // com.survicate.surveys.entities.models.ContactAction
        public String getUserId() {
            return this.userId;
        }

        @Override // com.survicate.surveys.entities.models.ContactAction
        public String getUserKey() {
            return this.userKey;
        }

        @Override // com.survicate.surveys.entities.models.ContactAction
        public String getRespondentUuid() {
            return this.respondentUuid;
        }

        public final List<Event> getEvents() {
            return this.events;
        }

        public final boolean isScheduled() {
            return this.isScheduled;
        }

        /* JADX INFO: compiled from: ContactAction.kt */
        @Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$InvokeEvent$Event;", "", "name", "", "timestampMs", "", "<init>", "(Ljava/lang/String;J)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getTimestampMs$annotations", "getTimestampMs", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        @Serializable
        public static final /* data */ class Event {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String name;
            private final long timestampMs;

            public static /* synthetic */ Event copy$default(Event event, String str, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = event.name;
                }
                if ((i & 2) != 0) {
                    j = event.timestampMs;
                }
                return event.copy(str, j);
            }

            @SerialName("name")
            public static /* synthetic */ void getName$annotations() {
            }

            @SerialName("timestamp_ms")
            public static /* synthetic */ void getTimestampMs$annotations() {
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getTimestampMs() {
                return this.timestampMs;
            }

            public final Event copy(String name, long timestampMs) {
                Intrinsics.checkNotNullParameter(name, "name");
                return new Event(name, timestampMs);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Event)) {
                    return false;
                }
                Event event = (Event) other;
                return Intrinsics.areEqual(this.name, event.name) && this.timestampMs == event.timestampMs;
            }

            public int hashCode() {
                return (this.name.hashCode() * 31) + Long.hashCode(this.timestampMs);
            }

            public String toString() {
                return "Event(name=" + this.name + ", timestampMs=" + this.timestampMs + ')';
            }

            /* JADX INFO: compiled from: ContactAction.kt */
            @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$InvokeEvent$Event$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/models/ContactAction$InvokeEvent$Event;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Event> serializer() {
                    return ContactAction$InvokeEvent$Event$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ Event(int i, String str, long j, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, ContactAction$InvokeEvent$Event$$serializer.INSTANCE.getDescriptor());
                }
                this.name = str;
                this.timestampMs = j;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$survicate_sdk_release(Event self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeStringElement(serialDesc, 0, self.name);
                output.encodeLongElement(serialDesc, 1, self.timestampMs);
            }

            public Event(String name, long j) {
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
                this.timestampMs = j;
            }

            public final String getName() {
                return this.name;
            }

            public final long getTimestampMs() {
                return this.timestampMs;
            }
        }
    }

    /* JADX INFO: compiled from: ContactAction.kt */
    @Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0003./0B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nBI\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\fHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a¨\u00061"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction;", "Lcom/survicate/surveys/entities/models/ContactAction;", "userId", "", "userKey", "respondentUuid", "interactions", "", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction$Interaction;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUserId$annotations", "()V", "getUserId", "()Ljava/lang/String;", "getUserKey$annotations", "getUserKey", "getRespondentUuid$annotations", "getRespondentUuid", "getInteractions$annotations", "getInteractions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "Interaction", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    @Serializable
    @SerialName("survey_interaction")
    public static final /* data */ class SurveyInteraction implements ContactAction {
        private final List<Interaction> interactions;
        private final String respondentUuid;
        private final String userId;
        private final String userKey;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.models.ContactAction$SurveyInteraction$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ContactAction.SurveyInteraction._childSerializers$_anonymous_();
            }
        })};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(ContactAction$SurveyInteraction$Interaction$$serializer.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SurveyInteraction copy$default(SurveyInteraction surveyInteraction, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = surveyInteraction.userId;
            }
            if ((i & 2) != 0) {
                str2 = surveyInteraction.userKey;
            }
            if ((i & 4) != 0) {
                str3 = surveyInteraction.respondentUuid;
            }
            if ((i & 8) != 0) {
                list = surveyInteraction.interactions;
            }
            return surveyInteraction.copy(str, str2, str3, list);
        }

        @SerialName("interactions")
        public static /* synthetic */ void getInteractions$annotations() {
        }

        @SerialName("respondent_uuid")
        public static /* synthetic */ void getRespondentUuid$annotations() {
        }

        @SerialName("user_id")
        public static /* synthetic */ void getUserId$annotations() {
        }

        @SerialName(UserTrait.USER_KEY)
        public static /* synthetic */ void getUserKey$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUserKey() {
            return this.userKey;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getRespondentUuid() {
            return this.respondentUuid;
        }

        public final List<Interaction> component4() {
            return this.interactions;
        }

        public final SurveyInteraction copy(String userId, String userKey, String respondentUuid, List<Interaction> interactions) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(userKey, "userKey");
            Intrinsics.checkNotNullParameter(respondentUuid, "respondentUuid");
            Intrinsics.checkNotNullParameter(interactions, "interactions");
            return new SurveyInteraction(userId, userKey, respondentUuid, interactions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SurveyInteraction)) {
                return false;
            }
            SurveyInteraction surveyInteraction = (SurveyInteraction) other;
            return Intrinsics.areEqual(this.userId, surveyInteraction.userId) && Intrinsics.areEqual(this.userKey, surveyInteraction.userKey) && Intrinsics.areEqual(this.respondentUuid, surveyInteraction.respondentUuid) && Intrinsics.areEqual(this.interactions, surveyInteraction.interactions);
        }

        public int hashCode() {
            return (((((this.userId.hashCode() * 31) + this.userKey.hashCode()) * 31) + this.respondentUuid.hashCode()) * 31) + this.interactions.hashCode();
        }

        public String toString() {
            return "SurveyInteraction(userId=" + this.userId + ", userKey=" + this.userKey + ", respondentUuid=" + this.respondentUuid + ", interactions=" + this.interactions + ')';
        }

        /* JADX INFO: compiled from: ContactAction.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SurveyInteraction> serializer() {
                return ContactAction$SurveyInteraction$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SurveyInteraction(int i, String str, String str2, String str3, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, ContactAction$SurveyInteraction$$serializer.INSTANCE.getDescriptor());
            }
            this.userId = str;
            this.userKey = str2;
            this.respondentUuid = str3;
            this.interactions = list;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyInteraction self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.getUserId());
            output.encodeStringElement(serialDesc, 1, self.getUserKey());
            output.encodeStringElement(serialDesc, 2, self.getRespondentUuid());
            output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.interactions);
        }

        public SurveyInteraction(String userId, String userKey, String respondentUuid, List<Interaction> interactions) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(userKey, "userKey");
            Intrinsics.checkNotNullParameter(respondentUuid, "respondentUuid");
            Intrinsics.checkNotNullParameter(interactions, "interactions");
            this.userId = userId;
            this.userKey = userKey;
            this.respondentUuid = respondentUuid;
            this.interactions = interactions;
        }

        @Override // com.survicate.surveys.entities.models.ContactAction
        public String getUserId() {
            return this.userId;
        }

        @Override // com.survicate.surveys.entities.models.ContactAction
        public String getUserKey() {
            return this.userKey;
        }

        @Override // com.survicate.surveys.entities.models.ContactAction
        public String getRespondentUuid() {
            return this.respondentUuid;
        }

        public final List<Interaction> getInteractions() {
            return this.interactions;
        }

        /* JADX INFO: compiled from: ContactAction.kt */
        @Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J'\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018¨\u0006,"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction$Interaction;", "", "surveyId", "", "timestampMs", "", "type", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteractionType;", "<init>", "(Ljava/lang/String;JLcom/survicate/surveys/entities/models/ContactAction$SurveyInteractionType;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLcom/survicate/surveys/entities/models/ContactAction$SurveyInteractionType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSurveyId$annotations", "()V", "getSurveyId", "()Ljava/lang/String;", "getTimestampMs$annotations", "getTimestampMs", "()J", "getType$annotations", "getType", "()Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteractionType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        @Serializable
        public static final /* data */ class Interaction {
            private final String surveyId;
            private final long timestampMs;
            private final SurveyInteractionType type;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.models.ContactAction$SurveyInteraction$Interaction$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ContactAction.SurveyInteraction.Interaction._childSerializers$_anonymous_();
                }
            })};

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return SurveyInteractionType.INSTANCE.serializer();
            }

            public static /* synthetic */ Interaction copy$default(Interaction interaction, String str, long j, SurveyInteractionType surveyInteractionType, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = interaction.surveyId;
                }
                if ((i & 2) != 0) {
                    j = interaction.timestampMs;
                }
                if ((i & 4) != 0) {
                    surveyInteractionType = interaction.type;
                }
                return interaction.copy(str, j, surveyInteractionType);
            }

            @SerialName("survey_id")
            public static /* synthetic */ void getSurveyId$annotations() {
            }

            @SerialName("timestamp_ms")
            public static /* synthetic */ void getTimestampMs$annotations() {
            }

            @SerialName("type")
            public static /* synthetic */ void getType$annotations() {
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSurveyId() {
                return this.surveyId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getTimestampMs() {
                return this.timestampMs;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final SurveyInteractionType getType() {
                return this.type;
            }

            public final Interaction copy(String surveyId, long timestampMs, SurveyInteractionType type) {
                Intrinsics.checkNotNullParameter(surveyId, "surveyId");
                Intrinsics.checkNotNullParameter(type, "type");
                return new Interaction(surveyId, timestampMs, type);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Interaction)) {
                    return false;
                }
                Interaction interaction = (Interaction) other;
                return Intrinsics.areEqual(this.surveyId, interaction.surveyId) && this.timestampMs == interaction.timestampMs && this.type == interaction.type;
            }

            public int hashCode() {
                return (((this.surveyId.hashCode() * 31) + Long.hashCode(this.timestampMs)) * 31) + this.type.hashCode();
            }

            public String toString() {
                return "Interaction(surveyId=" + this.surveyId + ", timestampMs=" + this.timestampMs + ", type=" + this.type + ')';
            }

            /* JADX INFO: compiled from: ContactAction.kt */
            @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction$Interaction$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction$Interaction;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Interaction> serializer() {
                    return ContactAction$SurveyInteraction$Interaction$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ Interaction(int i, String str, long j, SurveyInteractionType surveyInteractionType, SerializationConstructorMarker serializationConstructorMarker) {
                if (7 != (i & 7)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 7, ContactAction$SurveyInteraction$Interaction$$serializer.INSTANCE.getDescriptor());
                }
                this.surveyId = str;
                this.timestampMs = j;
                this.type = surveyInteractionType;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$survicate_sdk_release(Interaction self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                output.encodeStringElement(serialDesc, 0, self.surveyId);
                output.encodeLongElement(serialDesc, 1, self.timestampMs);
                output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.type);
            }

            public Interaction(String surveyId, long j, SurveyInteractionType type) {
                Intrinsics.checkNotNullParameter(surveyId, "surveyId");
                Intrinsics.checkNotNullParameter(type, "type");
                this.surveyId = surveyId;
                this.timestampMs = j;
                this.type = type;
            }

            public final String getSurveyId() {
                return this.surveyId;
            }

            public final long getTimestampMs() {
                return this.timestampMs;
            }

            public final SurveyInteractionType getType() {
                return this.type;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: ContactAction.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteractionType;", "", "<init>", "(Ljava/lang/String;I)V", "SEEN", "ANSWERED", "COMPLETED", "CLOSED", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    @Serializable
    public static final class SurveyInteractionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SurveyInteractionType[] $VALUES;
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;

        @SerialName("seen")
        public static final SurveyInteractionType SEEN = new SurveyInteractionType("SEEN", 0);

        @SerialName("answered")
        public static final SurveyInteractionType ANSWERED = new SurveyInteractionType("ANSWERED", 1);

        @SerialName("completed")
        public static final SurveyInteractionType COMPLETED = new SurveyInteractionType("COMPLETED", 2);

        @SerialName("closed")
        public static final SurveyInteractionType CLOSED = new SurveyInteractionType("CLOSED", 3);

        private static final /* synthetic */ SurveyInteractionType[] $values() {
            return new SurveyInteractionType[]{SEEN, ANSWERED, COMPLETED, CLOSED};
        }

        public static EnumEntries<SurveyInteractionType> getEntries() {
            return $ENTRIES;
        }

        /* JADX INFO: compiled from: ContactAction.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteractionType$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteractionType;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) SurveyInteractionType.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<SurveyInteractionType> serializer() {
                return get$cachedSerializer();
            }
        }

        private SurveyInteractionType(String str, int i) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.models.ContactAction.SurveyInteractionType", values(), new String[]{"seen", "answered", "completed", "closed"}, new Annotation[][]{null, null, null, null}, null);
        }

        static {
            SurveyInteractionType[] surveyInteractionTypeArr$values = $values();
            $VALUES = surveyInteractionTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(surveyInteractionTypeArr$values);
            INSTANCE = new Companion(null);
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.models.ContactAction$SurveyInteractionType$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ContactAction.SurveyInteractionType._init_$_anonymous_();
                }
            });
        }

        public static SurveyInteractionType valueOf(String str) {
            return (SurveyInteractionType) Enum.valueOf(SurveyInteractionType.class, str);
        }

        public static SurveyInteractionType[] values() {
            return (SurveyInteractionType[]) $VALUES.clone();
        }
    }
}

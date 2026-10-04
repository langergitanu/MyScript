package com.survicate.surveys.infrastructure.network.contacts;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.survicate.surveys.entities.models.ContactAction;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.infrastructure.network.UserAgentBuilder;
import com.survicate.surveys.infrastructure.network.contacts.ContactsApiModels;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: ContactsApiModels.kt */
/* JADX INFO: loaded from: classes8.dex */
@kotlin.Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels;", "", "<init>", "()V", "User", LogTags.RESPONDENT, "Attribute", "Event", "SurveyInteraction", "SurveyInteractionType", "Metadata", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ContactsApiModels {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ContactsApiModels.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006$"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$User;", "", "id", "", SubscriberAttributeKt.JSON_NAME_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getKey$annotations", "getKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    @Serializable
    public static final /* data */ class User {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;
        private final String key;

        public static /* synthetic */ User copy$default(User user, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = user.id;
            }
            if ((i & 2) != 0) {
                str2 = user.key;
            }
            return user.copy(str, str2);
        }

        @SerialName("id")
        public static /* synthetic */ void getId$annotations() {
        }

        @SerialName(SubscriberAttributeKt.JSON_NAME_KEY)
        public static /* synthetic */ void getKey$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        public final User copy(String id, String key) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(key, "key");
            return new User(id, key);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof User)) {
                return false;
            }
            User user = (User) other;
            return Intrinsics.areEqual(this.id, user.id) && Intrinsics.areEqual(this.key, user.key);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.key.hashCode();
        }

        public String toString() {
            return "User(id=" + this.id + ", key=" + this.key + ')';
        }

        /* JADX INFO: compiled from: ContactsApiModels.kt */
        @kotlin.Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$User$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$User;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<User> serializer() {
                return ContactsApiModels$User$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ User(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, ContactsApiModels$User$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.key = str2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$survicate_sdk_release(User self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.key);
        }

        public User(String id, String key) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(key, "key");
            this.id = id;
            this.key = key;
        }

        public final String getId() {
            return this.id;
        }

        public final String getKey() {
            return this.key;
        }
    }

    /* JADX INFO: compiled from: ContactsApiModels.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Respondent;", "", "uuid", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUuid$annotations", "()V", "getUuid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    @Serializable
    public static final /* data */ class Respondent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String uuid;

        public static /* synthetic */ Respondent copy$default(Respondent respondent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = respondent.uuid;
            }
            return respondent.copy(str);
        }

        @SerialName("uuid")
        public static /* synthetic */ void getUuid$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUuid() {
            return this.uuid;
        }

        public final Respondent copy(String uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            return new Respondent(uuid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Respondent) && Intrinsics.areEqual(this.uuid, ((Respondent) other).uuid);
        }

        public int hashCode() {
            return this.uuid.hashCode();
        }

        public String toString() {
            return "Respondent(uuid=" + this.uuid + ')';
        }

        /* JADX INFO: compiled from: ContactsApiModels.kt */
        @kotlin.Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Respondent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Respondent;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Respondent> serializer() {
                return ContactsApiModels$Respondent$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Respondent(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, ContactsApiModels$Respondent$$serializer.INSTANCE.getDescriptor());
            }
            this.uuid = str;
        }

        public Respondent(String uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            this.uuid = uuid;
        }

        public final String getUuid() {
            return this.uuid;
        }
    }

    /* JADX INFO: compiled from: ContactsApiModels.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J.\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Attribute;", "", "name", "", "value", "timestampMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getValue$annotations", "getValue", "getTimestampMs$annotations", "getTimestampMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Attribute;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
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

        @SerialName(DiagnosticsEntry.TIMESTAMP_KEY)
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

        /* JADX INFO: compiled from: ContactsApiModels.kt */
        @kotlin.Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Attribute$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Attribute;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Attribute> serializer() {
                return ContactsApiModels$Attribute$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Attribute(int i, String str, String str2, Long l, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, ContactsApiModels$Attribute$$serializer.INSTANCE.getDescriptor());
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

    /* JADX INFO: compiled from: ContactsApiModels.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Event;", "", "name", "", "timestampMs", "", "<init>", "(Ljava/lang/String;J)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getTimestampMs$annotations", "getTimestampMs", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
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

        @SerialName(DiagnosticsEntry.TIMESTAMP_KEY)
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

        /* JADX INFO: compiled from: ContactsApiModels.kt */
        @kotlin.Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Event$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Event;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Event> serializer() {
                return ContactsApiModels$Event$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Event(int i, String str, long j, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, ContactsApiModels$Event$$serializer.INSTANCE.getDescriptor());
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

    /* JADX INFO: compiled from: ContactsApiModels.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fB7\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\b\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J'\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u000eHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u001b¨\u0006/"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$SurveyInteraction;", "", "id", "", "timestampMs", "", "type", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$SurveyInteractionType;", "<init>", "(Ljava/lang/String;JLcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$SurveyInteractionType;)V", "interaction", "Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction$Interaction;", "(Lcom/survicate/surveys/entities/models/ContactAction$SurveyInteraction$Interaction;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$SurveyInteractionType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getTimestampMs$annotations", "getTimestampMs", "()J", "getType$annotations", "getType", "()Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$SurveyInteractionType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    @Serializable
    public static final /* data */ class SurveyInteraction {
        private final String id;
        private final long timestampMs;
        private final SurveyInteractionType type;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.infrastructure.network.contacts.ContactsApiModels$SurveyInteraction$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ContactsApiModels.SurveyInteraction._childSerializers$_anonymous_();
            }
        })};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return SurveyInteractionType.INSTANCE.serializer();
        }

        public static /* synthetic */ SurveyInteraction copy$default(SurveyInteraction surveyInteraction, String str, long j, SurveyInteractionType surveyInteractionType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = surveyInteraction.id;
            }
            if ((i & 2) != 0) {
                j = surveyInteraction.timestampMs;
            }
            if ((i & 4) != 0) {
                surveyInteractionType = surveyInteraction.type;
            }
            return surveyInteraction.copy(str, j, surveyInteractionType);
        }

        @SerialName("id")
        public static /* synthetic */ void getId$annotations() {
        }

        @SerialName(DiagnosticsEntry.TIMESTAMP_KEY)
        public static /* synthetic */ void getTimestampMs$annotations() {
        }

        @SerialName("type")
        public static /* synthetic */ void getType$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimestampMs() {
            return this.timestampMs;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final SurveyInteractionType getType() {
            return this.type;
        }

        public final SurveyInteraction copy(String id, long timestampMs, SurveyInteractionType type) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new SurveyInteraction(id, timestampMs, type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SurveyInteraction)) {
                return false;
            }
            SurveyInteraction surveyInteraction = (SurveyInteraction) other;
            return Intrinsics.areEqual(this.id, surveyInteraction.id) && this.timestampMs == surveyInteraction.timestampMs && this.type == surveyInteraction.type;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + Long.hashCode(this.timestampMs)) * 31) + this.type.hashCode();
        }

        public String toString() {
            return "SurveyInteraction(id=" + this.id + ", timestampMs=" + this.timestampMs + ", type=" + this.type + ')';
        }

        /* JADX INFO: compiled from: ContactsApiModels.kt */
        @kotlin.Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$SurveyInteraction$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$SurveyInteraction;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SurveyInteraction> serializer() {
                return ContactsApiModels$SurveyInteraction$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SurveyInteraction(int i, String str, long j, SurveyInteractionType surveyInteractionType, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, ContactsApiModels$SurveyInteraction$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.timestampMs = j;
            this.type = surveyInteractionType;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyInteraction self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeLongElement(serialDesc, 1, self.timestampMs);
            output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.type);
        }

        public SurveyInteraction(String id, long j, SurveyInteractionType type) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.timestampMs = j;
            this.type = type;
        }

        public final String getId() {
            return this.id;
        }

        public final long getTimestampMs() {
            return this.timestampMs;
        }

        public final SurveyInteractionType getType() {
            return this.type;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SurveyInteraction(ContactAction.SurveyInteraction.Interaction interaction) {
            this(interaction.getSurveyId(), interaction.getTimestampMs(), ContactsApiModelsKt.toApiModel(interaction.getType()));
            Intrinsics.checkNotNullParameter(interaction, "interaction");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: ContactsApiModels.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$SurveyInteractionType;", "", "<init>", "(Ljava/lang/String;I)V", "SEEN", "ANSWERED", "COMPLETED", "CLOSED", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
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

        /* JADX INFO: compiled from: ContactsApiModels.kt */
        @kotlin.Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$SurveyInteractionType$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$SurveyInteractionType;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
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
            return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.infrastructure.network.contacts.ContactsApiModels.SurveyInteractionType", values(), new String[]{"seen", "answered", "completed", "closed"}, new Annotation[][]{null, null, null, null}, null);
        }

        static {
            SurveyInteractionType[] surveyInteractionTypeArr$values = $values();
            $VALUES = surveyInteractionTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(surveyInteractionTypeArr$values);
            INSTANCE = new Companion(null);
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.infrastructure.network.contacts.ContactsApiModels$SurveyInteractionType$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ContactsApiModels.SurveyInteractionType._init_$_anonymous_();
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

    /* JADX INFO: compiled from: ContactsApiModels.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006$"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Metadata;", "", "version", "", "userAgent", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVersion$annotations", "()V", "getVersion", "()Ljava/lang/String;", "getUserAgent$annotations", "getUserAgent", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    @Serializable
    public static final /* data */ class Metadata {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String userAgent;
        private final String version;

        public static /* synthetic */ Metadata copy$default(Metadata metadata, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = metadata.version;
            }
            if ((i & 2) != 0) {
                str2 = metadata.userAgent;
            }
            return metadata.copy(str, str2);
        }

        @SerialName("user_agent")
        public static /* synthetic */ void getUserAgent$annotations() {
        }

        @SerialName("version")
        public static /* synthetic */ void getVersion$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUserAgent() {
            return this.userAgent;
        }

        public final Metadata copy(String version, String userAgent) {
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(userAgent, "userAgent");
            return new Metadata(version, userAgent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Metadata)) {
                return false;
            }
            Metadata metadata = (Metadata) other;
            return Intrinsics.areEqual(this.version, metadata.version) && Intrinsics.areEqual(this.userAgent, metadata.userAgent);
        }

        public int hashCode() {
            return (this.version.hashCode() * 31) + this.userAgent.hashCode();
        }

        public String toString() {
            return "Metadata(version=" + this.version + ", userAgent=" + this.userAgent + ')';
        }

        /* JADX INFO: compiled from: ContactsApiModels.kt */
        @kotlin.Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Metadata$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Metadata;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Metadata> serializer() {
                return ContactsApiModels$Metadata$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Metadata(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, ContactsApiModels$Metadata$$serializer.INSTANCE.getDescriptor());
            }
            this.version = str;
            this.userAgent = str2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$survicate_sdk_release(Metadata self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.version);
            output.encodeStringElement(serialDesc, 1, self.userAgent);
        }

        public Metadata(String version, String userAgent) {
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(userAgent, "userAgent");
            this.version = version;
            this.userAgent = userAgent;
        }

        public final String getVersion() {
            return this.version;
        }

        public final String getUserAgent() {
            return this.userAgent;
        }
    }

    /* JADX INFO: compiled from: ContactsApiModels.kt */
    @kotlin.Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Companion;", "", "<init>", "()V", "buildMetadata", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApiModels$Metadata;", "version", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Metadata buildMetadata(String version) {
            Intrinsics.checkNotNullParameter(version, "version");
            return new Metadata(version, UserAgentBuilder.INSTANCE.build());
        }
    }
}

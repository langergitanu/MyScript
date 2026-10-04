package com.survicate.surveys.entities.models;

import com.survicate.surveys.IntegrationPayload;
import com.survicate.surveys.ResponseAttribute;
import com.survicate.surveys.ResponseAttribute$$serializer;
import com.survicate.surveys.entities.models.RespondentEvent;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.infrastructure.network.SurveyAnswer$$serializer;
import com.survicate.surveys.infrastructure.network.VisitData;
import com.survicate.surveys.infrastructure.network.VisitData$$serializer;
import com.survicate.surveys.infrastructure.network.VisitorData;
import com.survicate.surveys.infrastructure.network.VisitorData$$serializer;
import com.survicate.surveys.infrastructure.serialization.IntegrationPayloadSerializer;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: RespondentEvent.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00042\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/RespondentEvent;", "", "SurveySeen", "QuestionAnswered", "Companion", "Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;", "Lcom/survicate/surveys/entities/models/RespondentEvent$SurveySeen;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public interface RespondentEvent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: RespondentEvent.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/RespondentEvent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/models/RespondentEvent;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<RespondentEvent> serializer() {
            return new SealedClassSerializer("com.survicate.surveys.entities.models.RespondentEvent", Reflection.getOrCreateKotlinClass(RespondentEvent.class), new KClass[]{Reflection.getOrCreateKotlinClass(QuestionAnswered.class), Reflection.getOrCreateKotlinClass(SurveySeen.class)}, new KSerializer[]{RespondentEvent$QuestionAnswered$$serializer.INSTANCE, RespondentEvent$SurveySeen$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    /* JADX INFO: compiled from: RespondentEvent.kt */
    @Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016¨\u0006*"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/RespondentEvent$SurveySeen;", "Lcom/survicate/surveys/entities/models/RespondentEvent;", "id", "", "surveyId", "surveyFirstSeen", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getSurveyId$annotations", "getSurveyId", "getSurveyFirstSeen$annotations", "getSurveyFirstSeen", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    @Serializable
    @SerialName("seen")
    public static final /* data */ class SurveySeen implements RespondentEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;
        private final boolean surveyFirstSeen;
        private final String surveyId;

        public static /* synthetic */ SurveySeen copy$default(SurveySeen surveySeen, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = surveySeen.id;
            }
            if ((i & 2) != 0) {
                str2 = surveySeen.surveyId;
            }
            if ((i & 4) != 0) {
                z = surveySeen.surveyFirstSeen;
            }
            return surveySeen.copy(str, str2, z);
        }

        @SerialName("id")
        public static /* synthetic */ void getId$annotations() {
        }

        @SerialName("survey_first_seen")
        public static /* synthetic */ void getSurveyFirstSeen$annotations() {
        }

        @SerialName("survey_id")
        public static /* synthetic */ void getSurveyId$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSurveyId() {
            return this.surveyId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getSurveyFirstSeen() {
            return this.surveyFirstSeen;
        }

        public final SurveySeen copy(String id, String surveyId, boolean surveyFirstSeen) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(surveyId, "surveyId");
            return new SurveySeen(id, surveyId, surveyFirstSeen);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SurveySeen)) {
                return false;
            }
            SurveySeen surveySeen = (SurveySeen) other;
            return Intrinsics.areEqual(this.id, surveySeen.id) && Intrinsics.areEqual(this.surveyId, surveySeen.surveyId) && this.surveyFirstSeen == surveySeen.surveyFirstSeen;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.surveyId.hashCode()) * 31) + Boolean.hashCode(this.surveyFirstSeen);
        }

        public String toString() {
            return "SurveySeen(id=" + this.id + ", surveyId=" + this.surveyId + ", surveyFirstSeen=" + this.surveyFirstSeen + ')';
        }

        /* JADX INFO: compiled from: RespondentEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/RespondentEvent$SurveySeen$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/models/RespondentEvent$SurveySeen;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SurveySeen> serializer() {
                return RespondentEvent$SurveySeen$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SurveySeen(int i, String str, String str2, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, RespondentEvent$SurveySeen$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.surveyId = str2;
            this.surveyFirstSeen = z;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveySeen self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.surveyId);
            output.encodeBooleanElement(serialDesc, 2, self.surveyFirstSeen);
        }

        public SurveySeen(String id, String surveyId, boolean z) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(surveyId, "surveyId");
            this.id = id;
            this.surveyId = surveyId;
            this.surveyFirstSeen = z;
        }

        public final String getId() {
            return this.id;
        }

        public final String getSurveyId() {
            return this.surveyId;
        }

        public final boolean getSurveyFirstSeen() {
            return this.surveyFirstSeen;
        }
    }

    /* JADX INFO: compiled from: RespondentEvent.kt */
    @Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 U2\u00020\u0001:\u0002TUBs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017B\u0093\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0016\u0010\u001cJ\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\t\u0010?\u001a\u00020\nHÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u0010A\u001a\u00020\u000fHÆ\u0003J\u0015\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00107J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\fHÆ\u0003J\u008e\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\u000f2\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\t\u0010J\u001a\u00020\u0019HÖ\u0001J\t\u0010K\u001a\u00020\u0003HÖ\u0001J%\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0001¢\u0006\u0002\bSR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010(R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u001e\u001a\u0004\b*\u0010+R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010.R\u001c\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u001e\u001a\u0004\b0\u00101R(\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001e\u001a\u0004\b3\u00104R \u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00108\u0012\u0004\b5\u0010\u001e\u001a\u0004\b6\u00107R$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010\u001e\u001a\u0004\b:\u0010.¨\u0006V"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;", "Lcom/survicate/surveys/entities/models/RespondentEvent;", "surveyId", "", "responseUuid", "surveyPointId", "", "visitorData", "Lcom/survicate/surveys/infrastructure/network/VisitorData;", "visitData", "Lcom/survicate/surveys/infrastructure/network/VisitData;", "responses", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "overwrite", "", "integrations", "", "Lcom/survicate/surveys/IntegrationPayload;", "disclaimerAccepted", "responseAttributes", "Lcom/survicate/surveys/ResponseAttribute;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLcom/survicate/surveys/infrastructure/network/VisitorData;Lcom/survicate/surveys/infrastructure/network/VisitData;Ljava/util/List;ZLjava/util/Map;Ljava/lang/Boolean;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JLcom/survicate/surveys/infrastructure/network/VisitorData;Lcom/survicate/surveys/infrastructure/network/VisitData;Ljava/util/List;ZLjava/util/Map;Ljava/lang/Boolean;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSurveyId$annotations", "()V", "getSurveyId", "()Ljava/lang/String;", "getResponseUuid$annotations", "getResponseUuid", "getSurveyPointId$annotations", "getSurveyPointId", "()J", "getVisitorData$annotations", "getVisitorData", "()Lcom/survicate/surveys/infrastructure/network/VisitorData;", "getVisitData$annotations", "getVisitData", "()Lcom/survicate/surveys/infrastructure/network/VisitData;", "getResponses$annotations", "getResponses", "()Ljava/util/List;", "getOverwrite$annotations", "getOverwrite", "()Z", "getIntegrations$annotations", "getIntegrations", "()Ljava/util/Map;", "getDisclaimerAccepted$annotations", "getDisclaimerAccepted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResponseAttributes$annotations", "getResponseAttributes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;JLcom/survicate/surveys/infrastructure/network/VisitorData;Lcom/survicate/surveys/infrastructure/network/VisitData;Ljava/util/List;ZLjava/util/Map;Ljava/lang/Boolean;Ljava/util/List;)Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    @Serializable
    @SerialName("answered")
    public static final /* data */ class QuestionAnswered implements RespondentEvent {
        private final Boolean disclaimerAccepted;
        private final Map<String, IntegrationPayload> integrations;
        private final boolean overwrite;
        private final List<ResponseAttribute> responseAttributes;
        private final String responseUuid;
        private final List<SurveyAnswer> responses;
        private final String surveyId;
        private final long surveyPointId;
        private final VisitData visitData;
        private final VisitorData visitorData;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.models.RespondentEvent$QuestionAnswered$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RespondentEvent.QuestionAnswered._childSerializers$_anonymous_();
            }
        }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.models.RespondentEvent$QuestionAnswered$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RespondentEvent.QuestionAnswered._childSerializers$_anonymous_$0();
            }
        }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.models.RespondentEvent$QuestionAnswered$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RespondentEvent.QuestionAnswered._childSerializers$_anonymous_$1();
            }
        })};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(SurveyAnswer$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new LinkedHashMapSerializer(StringSerializer.INSTANCE, IntegrationPayloadSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new ArrayListSerializer(ResponseAttribute$$serializer.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ QuestionAnswered copy$default(QuestionAnswered questionAnswered, String str, String str2, long j, VisitorData visitorData, VisitData visitData, List list, boolean z, Map map, Boolean bool, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = questionAnswered.surveyId;
            }
            if ((i & 2) != 0) {
                str2 = questionAnswered.responseUuid;
            }
            if ((i & 4) != 0) {
                j = questionAnswered.surveyPointId;
            }
            if ((i & 8) != 0) {
                visitorData = questionAnswered.visitorData;
            }
            if ((i & 16) != 0) {
                visitData = questionAnswered.visitData;
            }
            if ((i & 32) != 0) {
                list = questionAnswered.responses;
            }
            if ((i & 64) != 0) {
                z = questionAnswered.overwrite;
            }
            if ((i & 128) != 0) {
                map = questionAnswered.integrations;
            }
            if ((i & 256) != 0) {
                bool = questionAnswered.disclaimerAccepted;
            }
            if ((i & 512) != 0) {
                list2 = questionAnswered.responseAttributes;
            }
            Boolean bool2 = bool;
            List list3 = list2;
            Map map2 = map;
            List list4 = list;
            VisitorData visitorData2 = visitorData;
            long j2 = j;
            return questionAnswered.copy(str, str2, j2, visitorData2, visitData, list4, z, map2, bool2, list3);
        }

        @SerialName("disclaimer_accepted")
        public static /* synthetic */ void getDisclaimerAccepted$annotations() {
        }

        @SerialName("integrations")
        public static /* synthetic */ void getIntegrations$annotations() {
        }

        @SerialName("overwrite")
        public static /* synthetic */ void getOverwrite$annotations() {
        }

        @SerialName("response_attributes")
        public static /* synthetic */ void getResponseAttributes$annotations() {
        }

        @SerialName("response_uuid")
        public static /* synthetic */ void getResponseUuid$annotations() {
        }

        @SerialName("visit_points")
        public static /* synthetic */ void getResponses$annotations() {
        }

        @SerialName("survey_id")
        public static /* synthetic */ void getSurveyId$annotations() {
        }

        @SerialName("survey_point_id")
        public static /* synthetic */ void getSurveyPointId$annotations() {
        }

        @SerialName("visit")
        public static /* synthetic */ void getVisitData$annotations() {
        }

        @SerialName("visitor")
        public static /* synthetic */ void getVisitorData$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSurveyId() {
            return this.surveyId;
        }

        public final List<ResponseAttribute> component10() {
            return this.responseAttributes;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getResponseUuid() {
            return this.responseUuid;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getSurveyPointId() {
            return this.surveyPointId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final VisitorData getVisitorData() {
            return this.visitorData;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final VisitData getVisitData() {
            return this.visitData;
        }

        public final List<SurveyAnswer> component6() {
            return this.responses;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getOverwrite() {
            return this.overwrite;
        }

        public final Map<String, IntegrationPayload> component8() {
            return this.integrations;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getDisclaimerAccepted() {
            return this.disclaimerAccepted;
        }

        public final QuestionAnswered copy(String surveyId, String responseUuid, long surveyPointId, VisitorData visitorData, VisitData visitData, List<SurveyAnswer> responses, boolean overwrite, Map<String, IntegrationPayload> integrations, Boolean disclaimerAccepted, List<ResponseAttribute> responseAttributes) {
            Intrinsics.checkNotNullParameter(surveyId, "surveyId");
            Intrinsics.checkNotNullParameter(responseUuid, "responseUuid");
            Intrinsics.checkNotNullParameter(visitorData, "visitorData");
            Intrinsics.checkNotNullParameter(visitData, "visitData");
            Intrinsics.checkNotNullParameter(responses, "responses");
            Intrinsics.checkNotNullParameter(integrations, "integrations");
            return new QuestionAnswered(surveyId, responseUuid, surveyPointId, visitorData, visitData, responses, overwrite, integrations, disclaimerAccepted, responseAttributes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuestionAnswered)) {
                return false;
            }
            QuestionAnswered questionAnswered = (QuestionAnswered) other;
            return Intrinsics.areEqual(this.surveyId, questionAnswered.surveyId) && Intrinsics.areEqual(this.responseUuid, questionAnswered.responseUuid) && this.surveyPointId == questionAnswered.surveyPointId && Intrinsics.areEqual(this.visitorData, questionAnswered.visitorData) && Intrinsics.areEqual(this.visitData, questionAnswered.visitData) && Intrinsics.areEqual(this.responses, questionAnswered.responses) && this.overwrite == questionAnswered.overwrite && Intrinsics.areEqual(this.integrations, questionAnswered.integrations) && Intrinsics.areEqual(this.disclaimerAccepted, questionAnswered.disclaimerAccepted) && Intrinsics.areEqual(this.responseAttributes, questionAnswered.responseAttributes);
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((this.surveyId.hashCode() * 31) + this.responseUuid.hashCode()) * 31) + Long.hashCode(this.surveyPointId)) * 31) + this.visitorData.hashCode()) * 31) + this.visitData.hashCode()) * 31) + this.responses.hashCode()) * 31) + Boolean.hashCode(this.overwrite)) * 31) + this.integrations.hashCode()) * 31;
            Boolean bool = this.disclaimerAccepted;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            List<ResponseAttribute> list = this.responseAttributes;
            return iHashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "QuestionAnswered(surveyId=" + this.surveyId + ", responseUuid=" + this.responseUuid + ", surveyPointId=" + this.surveyPointId + ", visitorData=" + this.visitorData + ", visitData=" + this.visitData + ", responses=" + this.responses + ", overwrite=" + this.overwrite + ", integrations=" + this.integrations + ", disclaimerAccepted=" + this.disclaimerAccepted + ", responseAttributes=" + this.responseAttributes + ')';
        }

        /* JADX INFO: compiled from: RespondentEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<QuestionAnswered> serializer() {
                return RespondentEvent$QuestionAnswered$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ QuestionAnswered(int i, String str, String str2, long j, VisitorData visitorData, VisitData visitData, List list, boolean z, Map map, Boolean bool, List list2, SerializationConstructorMarker serializationConstructorMarker) {
            if (1023 != (i & 1023)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1023, RespondentEvent$QuestionAnswered$$serializer.INSTANCE.getDescriptor());
            }
            this.surveyId = str;
            this.responseUuid = str2;
            this.surveyPointId = j;
            this.visitorData = visitorData;
            this.visitData = visitData;
            this.responses = list;
            this.overwrite = z;
            this.integrations = map;
            this.disclaimerAccepted = bool;
            this.responseAttributes = list2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$survicate_sdk_release(QuestionAnswered self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.surveyId);
            output.encodeStringElement(serialDesc, 1, self.responseUuid);
            output.encodeLongElement(serialDesc, 2, self.surveyPointId);
            output.encodeSerializableElement(serialDesc, 3, VisitorData$$serializer.INSTANCE, self.visitorData);
            output.encodeSerializableElement(serialDesc, 4, VisitData$$serializer.INSTANCE, self.visitData);
            output.encodeSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.responses);
            output.encodeBooleanElement(serialDesc, 6, self.overwrite);
            output.encodeSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.integrations);
            output.encodeNullableSerializableElement(serialDesc, 8, BooleanSerializer.INSTANCE, self.disclaimerAccepted);
            output.encodeNullableSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.responseAttributes);
        }

        public QuestionAnswered(String surveyId, String responseUuid, long j, VisitorData visitorData, VisitData visitData, List<SurveyAnswer> responses, boolean z, Map<String, IntegrationPayload> integrations, Boolean bool, List<ResponseAttribute> list) {
            Intrinsics.checkNotNullParameter(surveyId, "surveyId");
            Intrinsics.checkNotNullParameter(responseUuid, "responseUuid");
            Intrinsics.checkNotNullParameter(visitorData, "visitorData");
            Intrinsics.checkNotNullParameter(visitData, "visitData");
            Intrinsics.checkNotNullParameter(responses, "responses");
            Intrinsics.checkNotNullParameter(integrations, "integrations");
            this.surveyId = surveyId;
            this.responseUuid = responseUuid;
            this.surveyPointId = j;
            this.visitorData = visitorData;
            this.visitData = visitData;
            this.responses = responses;
            this.overwrite = z;
            this.integrations = integrations;
            this.disclaimerAccepted = bool;
            this.responseAttributes = list;
        }

        public final String getSurveyId() {
            return this.surveyId;
        }

        public final String getResponseUuid() {
            return this.responseUuid;
        }

        public final long getSurveyPointId() {
            return this.surveyPointId;
        }

        public final VisitorData getVisitorData() {
            return this.visitorData;
        }

        public final VisitData getVisitData() {
            return this.visitData;
        }

        public final List<SurveyAnswer> getResponses() {
            return this.responses;
        }

        public final boolean getOverwrite() {
            return this.overwrite;
        }

        public final Map<String, IntegrationPayload> getIntegrations() {
            return this.integrations;
        }

        public final Boolean getDisclaimerAccepted() {
            return this.disclaimerAccepted;
        }

        public final List<ResponseAttribute> getResponseAttributes() {
            return this.responseAttributes;
        }
    }
}

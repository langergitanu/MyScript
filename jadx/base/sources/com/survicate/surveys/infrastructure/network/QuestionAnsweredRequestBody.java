package com.survicate.surveys.infrastructure.network;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.survicate.surveys.IntegrationPayload;
import com.survicate.surveys.ResponseAttribute;
import com.survicate.surveys.ResponseAttribute$$serializer;
import com.survicate.surveys.entities.models.RespondentEvent;
import com.survicate.surveys.infrastructure.serialization.IntegrationPayloadSerializer;
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
import kotlinx.serialization.KSerializer;
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

/* JADX INFO: compiled from: QuestionAnsweredRequestBody.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 G2\u00020\u0001:\u0002FGBy\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u0016\u0010\u001aB\u0093\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u0016\u0010\u001fJ%\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0001¢\u0006\u0002\bER\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010!\u001a\u0004\b%\u0010#R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010!\u001a\u0004\b*\u0010+R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010!\u001a\u0004\b-\u0010.R$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010!\u001a\u0004\b0\u00101R\u001c\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010!\u001a\u0004\b3\u00104R(\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010!\u001a\u0004\b6\u00107R \u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010;\u0012\u0004\b8\u0010!\u001a\u0004\b9\u0010:R$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010!\u001a\u0004\b=\u00101¨\u0006H"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/QuestionAnsweredRequestBody;", "", "version", "", "responseUuid", "surveyPointId", "", "visitorData", "Lcom/survicate/surveys/infrastructure/network/VisitorData;", "visitData", "Lcom/survicate/surveys/infrastructure/network/VisitData;", "responses", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "overwrite", "", "integrations", "", "Lcom/survicate/surveys/IntegrationPayload;", "disclaimerAccepted", "responseAttributes", "Lcom/survicate/surveys/ResponseAttribute;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLcom/survicate/surveys/infrastructure/network/VisitorData;Lcom/survicate/surveys/infrastructure/network/VisitData;Ljava/util/List;ZLjava/util/Map;Ljava/lang/Boolean;Ljava/util/List;)V", NotificationCompat.CATEGORY_EVENT, "Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;", "(Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JLcom/survicate/surveys/infrastructure/network/VisitorData;Lcom/survicate/surveys/infrastructure/network/VisitData;Ljava/util/List;ZLjava/util/Map;Ljava/lang/Boolean;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVersion$annotations", "()V", "getVersion", "()Ljava/lang/String;", "getResponseUuid$annotations", "getResponseUuid", "getSurveyPointId$annotations", "getSurveyPointId", "()J", "getVisitorData$annotations", "getVisitorData", "()Lcom/survicate/surveys/infrastructure/network/VisitorData;", "getVisitData$annotations", "getVisitData", "()Lcom/survicate/surveys/infrastructure/network/VisitData;", "getResponses$annotations", "getResponses", "()Ljava/util/List;", "getOverwrite$annotations", "getOverwrite", "()Z", "getIntegrations$annotations", "getIntegrations", "()Ljava/util/Map;", "getDisclaimerAccepted$annotations", "getDisclaimerAccepted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResponseAttributes$annotations", "getResponseAttributes", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final class QuestionAnsweredRequestBody {
    private final Boolean disclaimerAccepted;
    private final Map<String, IntegrationPayload> integrations;
    private final boolean overwrite;
    private final List<ResponseAttribute> responseAttributes;
    private final String responseUuid;
    private final List<SurveyAnswer> responses;
    private final long surveyPointId;
    private final String version;
    private final VisitData visitData;
    private final VisitorData visitorData;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.infrastructure.network.QuestionAnsweredRequestBody$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return QuestionAnsweredRequestBody._childSerializers$_anonymous_();
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.infrastructure.network.QuestionAnsweredRequestBody$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return QuestionAnsweredRequestBody._childSerializers$_anonymous_$0();
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.infrastructure.network.QuestionAnsweredRequestBody$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return QuestionAnsweredRequestBody._childSerializers$_anonymous_$1();
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

    @SerialName("survey_point_id")
    public static /* synthetic */ void getSurveyPointId$annotations() {
    }

    @SerialName("version")
    public static /* synthetic */ void getVersion$annotations() {
    }

    @SerialName("visit")
    public static /* synthetic */ void getVisitData$annotations() {
    }

    @SerialName("visitor")
    public static /* synthetic */ void getVisitorData$annotations() {
    }

    /* JADX INFO: compiled from: QuestionAnsweredRequestBody.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/QuestionAnsweredRequestBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/QuestionAnsweredRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<QuestionAnsweredRequestBody> serializer() {
            return QuestionAnsweredRequestBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ QuestionAnsweredRequestBody(int i, String str, String str2, long j, VisitorData visitorData, VisitData visitData, List list, boolean z, Map map, Boolean bool, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1022 != (i & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED)) {
            PluginExceptionsKt.throwMissingFieldException(i, AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, QuestionAnsweredRequestBody$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.version = "4.1";
        } else {
            this.version = str;
        }
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
    public static final /* synthetic */ void write$Self$survicate_sdk_release(QuestionAnsweredRequestBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.version, "4.1")) {
            output.encodeStringElement(serialDesc, 0, self.version);
        }
        output.encodeStringElement(serialDesc, 1, self.responseUuid);
        output.encodeLongElement(serialDesc, 2, self.surveyPointId);
        output.encodeSerializableElement(serialDesc, 3, VisitorData$$serializer.INSTANCE, self.visitorData);
        output.encodeSerializableElement(serialDesc, 4, VisitData$$serializer.INSTANCE, self.visitData);
        output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.responses);
        output.encodeBooleanElement(serialDesc, 6, self.overwrite);
        output.encodeSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.integrations);
        output.encodeNullableSerializableElement(serialDesc, 8, BooleanSerializer.INSTANCE, self.disclaimerAccepted);
        output.encodeNullableSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.responseAttributes);
    }

    private QuestionAnsweredRequestBody(String str, String str2, long j, VisitorData visitorData, VisitData visitData, List<SurveyAnswer> list, boolean z, Map<String, IntegrationPayload> map, Boolean bool, List<ResponseAttribute> list2) {
        this.version = str;
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

    public final String getVersion() {
        return this.version;
    }

    /* synthetic */ QuestionAnsweredRequestBody(String str, String str2, long j, VisitorData visitorData, VisitData visitData, List list, boolean z, Map map, Boolean bool, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "4.1" : str, str2, j, visitorData, visitData, list, z, map, bool, list2);
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QuestionAnsweredRequestBody(RespondentEvent.QuestionAnswered event) {
        this((String) null, event.getResponseUuid(), event.getSurveyPointId(), event.getVisitorData(), event.getVisitData(), event.getResponses(), event.getOverwrite(), event.getIntegrations(), event.getDisclaimerAccepted(), event.getResponseAttributes(), 1, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(event, "event");
    }
}

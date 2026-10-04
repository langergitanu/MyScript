package com.survicate.surveys.infrastructure.network;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
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
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: SurveyAnswer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 X2\u00020\u0001:\u0002WXB\u009b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0014\u0010\u0015Bo\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0014\u0010\u001aJ\u0013\u0010L\u001a\u00020\u00032\b\u0010M\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010N\u001a\u00020\u0017H\u0016J%\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0001¢\u0006\u0002\bVR(\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010/\u0012\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R&\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u001c\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R$\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010\u001c\u001a\u0004\b4\u00105\"\u0004\b6\u00107R&\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u0010\u001c\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)R,\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010\u001c\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R&\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b@\u0010\u001c\u001a\u0004\bA\u0010'\"\u0004\bB\u0010)R(\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010/\u0012\u0004\bC\u0010\u001c\u001a\u0004\bD\u0010,\"\u0004\bE\u0010.R&\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bF\u0010\u001c\u001a\u0004\bG\u0010'\"\u0004\bH\u0010)R&\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bI\u0010\u001c\u001a\u0004\bJ\u0010'\"\u0004\bK\u0010)¨\u0006Y"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "", "finished", "", "ctaSuccess", FirebaseAnalytics.Param.CONTENT, "", "questionAnswerId", "", "answerType", "completionRate", "", ClientCookie.COMMENT_ATTR, "followUp", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswerFollowUp;", "answer", "answerId", "matrixGroupName", "matrixColumnName", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;DLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;DLjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFinished$annotations", "()V", "getFinished", "()Ljava/lang/Boolean;", "setFinished", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCtaSuccess$annotations", "getCtaSuccess", "setCtaSuccess", "getContent$annotations", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getQuestionAnswerId$annotations", "getQuestionAnswerId", "()Ljava/lang/Long;", "setQuestionAnswerId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getAnswerType$annotations", "getAnswerType", "setAnswerType", "getCompletionRate$annotations", "getCompletionRate", "()D", "setCompletionRate", "(D)V", "getComment$annotations", "getComment", "setComment", "getFollowUp$annotations", "getFollowUp", "()Ljava/util/List;", "setFollowUp", "(Ljava/util/List;)V", "getAnswer$annotations", "getAnswer", "setAnswer", "getAnswerId$annotations", "getAnswerId", "setAnswerId", "getMatrixGroupName$annotations", "getMatrixGroupName", "setMatrixGroupName", "getMatrixColumnName$annotations", "getMatrixColumnName", "setMatrixColumnName", "equals", "other", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final class SurveyAnswer {
    private String answer;
    private Long answerId;
    private String answerType;
    private String comment;
    private double completionRate;
    private String content;
    private Boolean ctaSuccess;
    private Boolean finished;
    private List<SurveyAnswerFollowUp> followUp;
    private String matrixColumnName;
    private String matrixGroupName;
    private Long questionAnswerId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.infrastructure.network.SurveyAnswer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyAnswer._childSerializers$_anonymous_();
        }
    })};

    public SurveyAnswer() {
        this(null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, 4095, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(SurveyAnswerFollowUp$$serializer.INSTANCE);
    }

    @Transient
    public static /* synthetic */ void getAnswer$annotations() {
    }

    @Transient
    public static /* synthetic */ void getAnswerId$annotations() {
    }

    @SerialName("answer_type")
    public static /* synthetic */ void getAnswerType$annotations() {
    }

    @SerialName(ClientCookie.COMMENT_ATTR)
    public static /* synthetic */ void getComment$annotations() {
    }

    @SerialName("completion_rate")
    public static /* synthetic */ void getCompletionRate$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.CONTENT)
    public static /* synthetic */ void getContent$annotations() {
    }

    @SerialName("cta_success")
    public static /* synthetic */ void getCtaSuccess$annotations() {
    }

    @SerialName("finished")
    public static /* synthetic */ void getFinished$annotations() {
    }

    @SerialName("follow_ups")
    public static /* synthetic */ void getFollowUp$annotations() {
    }

    @Transient
    public static /* synthetic */ void getMatrixColumnName$annotations() {
    }

    @Transient
    public static /* synthetic */ void getMatrixGroupName$annotations() {
    }

    @SerialName("survey_question_answer_id")
    public static /* synthetic */ void getQuestionAnswerId$annotations() {
    }

    /* JADX INFO: compiled from: SurveyAnswer.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/SurveyAnswer$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyAnswer> serializer() {
            return SurveyAnswer$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyAnswer(int i, Boolean bool, Boolean bool2, String str, Long l, String str2, double d, String str3, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.finished = null;
        } else {
            this.finished = bool;
        }
        if ((i & 2) == 0) {
            this.ctaSuccess = null;
        } else {
            this.ctaSuccess = bool2;
        }
        if ((i & 4) == 0) {
            this.content = null;
        } else {
            this.content = str;
        }
        if ((i & 8) == 0) {
            this.questionAnswerId = null;
        } else {
            this.questionAnswerId = l;
        }
        if ((i & 16) == 0) {
            this.answerType = null;
        } else {
            this.answerType = str2;
        }
        if ((i & 32) == 0) {
            this.completionRate = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            this.completionRate = d;
        }
        if ((i & 64) == 0) {
            this.comment = null;
        } else {
            this.comment = str3;
        }
        if ((i & 128) == 0) {
            this.followUp = null;
        } else {
            this.followUp = list;
        }
        this.answer = null;
        this.answerId = null;
        this.matrixGroupName = null;
        this.matrixColumnName = null;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyAnswer self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.finished != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.finished);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.ctaSuccess != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.ctaSuccess);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.content != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.content);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.questionAnswerId != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.questionAnswerId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.answerType != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.answerType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || Double.compare(self.completionRate, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) != 0) {
            output.encodeDoubleElement(serialDesc, 5, self.completionRate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.comment != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.comment);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.followUp == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.followUp);
    }

    public SurveyAnswer(Boolean bool, Boolean bool2, String str, Long l, String str2, double d, String str3, List<SurveyAnswerFollowUp> list, String str4, Long l2, String str5, String str6) {
        this.finished = bool;
        this.ctaSuccess = bool2;
        this.content = str;
        this.questionAnswerId = l;
        this.answerType = str2;
        this.completionRate = d;
        this.comment = str3;
        this.followUp = list;
        this.answer = str4;
        this.answerId = l2;
        this.matrixGroupName = str5;
        this.matrixColumnName = str6;
    }

    public /* synthetic */ SurveyAnswer(Boolean bool, Boolean bool2, String str, Long l, String str2, double d, String str3, List list, String str4, Long l2, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : l2, (i & 1024) != 0 ? null : str5, (i & 2048) != 0 ? null : str6);
    }

    public final Boolean getFinished() {
        return this.finished;
    }

    public final void setFinished(Boolean bool) {
        this.finished = bool;
    }

    public final Boolean getCtaSuccess() {
        return this.ctaSuccess;
    }

    public final void setCtaSuccess(Boolean bool) {
        this.ctaSuccess = bool;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final Long getQuestionAnswerId() {
        return this.questionAnswerId;
    }

    public final void setQuestionAnswerId(Long l) {
        this.questionAnswerId = l;
    }

    public final String getAnswerType() {
        return this.answerType;
    }

    public final void setAnswerType(String str) {
        this.answerType = str;
    }

    public final double getCompletionRate() {
        return this.completionRate;
    }

    public final void setCompletionRate(double d) {
        this.completionRate = d;
    }

    public final String getComment() {
        return this.comment;
    }

    public final void setComment(String str) {
        this.comment = str;
    }

    public final List<SurveyAnswerFollowUp> getFollowUp() {
        return this.followUp;
    }

    public final void setFollowUp(List<SurveyAnswerFollowUp> list) {
        this.followUp = list;
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final void setAnswer(String str) {
        this.answer = str;
    }

    public final Long getAnswerId() {
        return this.answerId;
    }

    public final void setAnswerId(Long l) {
        this.answerId = l;
    }

    public final String getMatrixGroupName() {
        return this.matrixGroupName;
    }

    public final void setMatrixGroupName(String str) {
        this.matrixGroupName = str;
    }

    public final String getMatrixColumnName() {
        return this.matrixColumnName;
    }

    public final void setMatrixColumnName(String str) {
        this.matrixColumnName = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.survicate.surveys.infrastructure.network.SurveyAnswer");
        SurveyAnswer surveyAnswer = (SurveyAnswer) other;
        return Intrinsics.areEqual(this.finished, surveyAnswer.finished) && Intrinsics.areEqual(this.ctaSuccess, surveyAnswer.ctaSuccess) && Intrinsics.areEqual(this.content, surveyAnswer.content) && Intrinsics.areEqual(this.questionAnswerId, surveyAnswer.questionAnswerId) && Intrinsics.areEqual(this.answerType, surveyAnswer.answerType) && this.completionRate == surveyAnswer.completionRate && Intrinsics.areEqual(this.comment, surveyAnswer.comment) && Intrinsics.areEqual(this.followUp, surveyAnswer.followUp);
    }

    public int hashCode() {
        Boolean bool = this.finished;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.ctaSuccess;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str = this.content;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.questionAnswerId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.answerType;
        int iHashCode5 = (((iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + Double.hashCode(this.completionRate)) * 31;
        String str3 = this.comment;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<SurveyAnswerFollowUp> list = this.followUp;
        return iHashCode6 + (list != null ? list.hashCode() : 0);
    }
}

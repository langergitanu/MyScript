package com.survicate.surveys.entities.survey.surveyLogic.display;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.presentation.date.micro.MicroDatePickerFragment;
import com.survicate.surveys.surveys.CtaSurveyAnswerType;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: TextDisplayLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fBG\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0006\u0010$\u001a\u00020\u000eJ\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u000eHÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000eJ%\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\b7R\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001e¨\u0006:"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/display/TextDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/DisplayLogic;", "pointId", "", "answerType", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "groupOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "groups", "", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/TextDisplayLogicGroup;", "<init>", "(JLcom/survicate/surveys/entities/survey/SurveyAnswerType;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLcom/survicate/surveys/entities/survey/SurveyAnswerType;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPointId$annotations", "()V", "getPointId", "()J", "getAnswerType$annotations", "getAnswerType", "()Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "getGroupOperator$annotations", "getGroupOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getGroups$annotations", "getGroups", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class TextDisplayLogic extends DisplayLogic {
    private final SurveyAnswerType answerType;
    private final SurveyLogicOperator groupOperator;
    private final List<TextDisplayLogicGroup> groups;
    private final long pointId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<TextDisplayLogic> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.display.TextDisplayLogic$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TextDisplayLogic._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.display.TextDisplayLogic$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TextDisplayLogic._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.display.TextDisplayLogic$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TextDisplayLogic._childSerializers$_anonymous_$1();
        }
    })};

    /* JADX INFO: compiled from: TextDisplayLogic.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<TextDisplayLogic> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TextDisplayLogic createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            SurveyAnswerType surveyAnswerTypeValueOf = SurveyAnswerType.valueOf(parcel.readString());
            SurveyLogicOperator surveyLogicOperatorValueOf = SurveyLogicOperator.valueOf(parcel.readString());
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(TextDisplayLogicGroup.CREATOR.createFromParcel(parcel));
            }
            return new TextDisplayLogic(j, surveyAnswerTypeValueOf, surveyLogicOperatorValueOf, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TextDisplayLogic[] newArray(int i) {
            return new TextDisplayLogic[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.SurveyAnswerType", SurveyAnswerType.values(), new String[]{QuestionSurveyAnswerType.SMILEY_SCALE, QuestionSurveyAnswerType.SINGLE, QuestionSurveyAnswerType.MULTIPLE, "text", QuestionSurveyAnswerType.DATE, QuestionSurveyAnswerType.CSAT, QuestionSurveyAnswerType.NUMERICAL, QuestionSurveyAnswerType.SHAPE, QuestionSurveyAnswerType.MATRIX, "nps", "form", CtaSurveyAnswerType.BUTTON_NEXT, CtaSurveyAnswerType.BUTTON_CLOSE, CtaSurveyAnswerType.BUTTON_LINK}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator", SurveyLogicOperator.values(), new String[]{"or", "and"}, new Annotation[][]{null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(TextDisplayLogicGroup$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextDisplayLogic copy$default(TextDisplayLogic textDisplayLogic, long j, SurveyAnswerType surveyAnswerType, SurveyLogicOperator surveyLogicOperator, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = textDisplayLogic.pointId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            surveyAnswerType = textDisplayLogic.answerType;
        }
        SurveyAnswerType surveyAnswerType2 = surveyAnswerType;
        if ((i & 4) != 0) {
            surveyLogicOperator = textDisplayLogic.groupOperator;
        }
        SurveyLogicOperator surveyLogicOperator2 = surveyLogicOperator;
        if ((i & 8) != 0) {
            list = textDisplayLogic.groups;
        }
        return textDisplayLogic.copy(j2, surveyAnswerType2, surveyLogicOperator2, list);
    }

    @SerialName("answer_type")
    public static /* synthetic */ void getAnswerType$annotations() {
    }

    @SerialName("group_operator")
    public static /* synthetic */ void getGroupOperator$annotations() {
    }

    @SerialName("groups")
    public static /* synthetic */ void getGroups$annotations() {
    }

    @SerialName(MicroDatePickerFragment.POINT_ID)
    public static /* synthetic */ void getPointId$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getPointId() {
        return this.pointId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SurveyAnswerType getAnswerType() {
        return this.answerType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SurveyLogicOperator getGroupOperator() {
        return this.groupOperator;
    }

    public final List<TextDisplayLogicGroup> component4() {
        return this.groups;
    }

    public final TextDisplayLogic copy(long pointId, SurveyAnswerType answerType, SurveyLogicOperator groupOperator, List<TextDisplayLogicGroup> groups) {
        Intrinsics.checkNotNullParameter(answerType, "answerType");
        Intrinsics.checkNotNullParameter(groupOperator, "groupOperator");
        Intrinsics.checkNotNullParameter(groups, "groups");
        return new TextDisplayLogic(pointId, answerType, groupOperator, groups);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextDisplayLogic)) {
            return false;
        }
        TextDisplayLogic textDisplayLogic = (TextDisplayLogic) other;
        return this.pointId == textDisplayLogic.pointId && this.answerType == textDisplayLogic.answerType && this.groupOperator == textDisplayLogic.groupOperator && Intrinsics.areEqual(this.groups, textDisplayLogic.groups);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.pointId) * 31) + this.answerType.hashCode()) * 31) + this.groupOperator.hashCode()) * 31) + this.groups.hashCode();
    }

    public String toString() {
        return "TextDisplayLogic(pointId=" + this.pointId + ", answerType=" + this.answerType + ", groupOperator=" + this.groupOperator + ", groups=" + this.groups + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.pointId);
        dest.writeString(this.answerType.name());
        dest.writeString(this.groupOperator.name());
        List<TextDisplayLogicGroup> list = this.groups;
        dest.writeInt(list.size());
        Iterator<TextDisplayLogicGroup> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }

    /* JADX INFO: compiled from: TextDisplayLogic.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/display/TextDisplayLogic$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/TextDisplayLogic;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TextDisplayLogic> serializer() {
            return TextDisplayLogic$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextDisplayLogic(int i, long j, SurveyAnswerType surveyAnswerType, SurveyLogicOperator surveyLogicOperator, List list, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, TextDisplayLogic$$serializer.INSTANCE.getDescriptor());
        }
        this.pointId = j;
        this.answerType = surveyAnswerType;
        this.groupOperator = surveyLogicOperator;
        this.groups = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(TextDisplayLogic self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.getPointId());
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.getAnswerType());
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.getGroupOperator());
        output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.groups);
    }

    @Override // com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic
    public long getPointId() {
        return this.pointId;
    }

    @Override // com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic
    public SurveyAnswerType getAnswerType() {
        return this.answerType;
    }

    @Override // com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic
    public SurveyLogicOperator getGroupOperator() {
        return this.groupOperator;
    }

    public final List<TextDisplayLogicGroup> getGroups() {
        return this.groups;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextDisplayLogic(long j, SurveyAnswerType answerType, SurveyLogicOperator groupOperator, List<TextDisplayLogicGroup> groups) {
        super(null);
        Intrinsics.checkNotNullParameter(answerType, "answerType");
        Intrinsics.checkNotNullParameter(groupOperator, "groupOperator");
        Intrinsics.checkNotNullParameter(groups, "groups");
        this.pointId = j;
        this.answerType = answerType;
        this.groupOperator = groupOperator;
        this.groups = groups;
    }
}

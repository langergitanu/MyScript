package com.survicate.surveys.entities.survey.surveyLogic.display;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyLogicMatrixCondition;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: MatrixDisplayLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 72\u00020\u0001:\u000267B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bBO\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J=\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0006\u0010\"\u001a\u00020\rJ\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\rHÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\rJ%\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u001c¨\u00068"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/display/MatrixDisplayLogicGroup;", "Landroid/os/Parcelable;", "condition", "Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixCondition;", "value", "", "", "answerId", "answerIdOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "<init>", "(Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixCondition;Ljava/util/List;Ljava/util/List;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixCondition;Ljava/util/List;Ljava/util/List;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCondition$annotations", "()V", "getCondition", "()Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixCondition;", "getValue$annotations", "getValue", "()Ljava/util/List;", "getAnswerId$annotations", "getAnswerId", "getAnswerIdOperator$annotations", "getAnswerIdOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class MatrixDisplayLogicGroup implements Parcelable {
    private final List<Long> answerId;
    private final SurveyLogicOperator answerIdOperator;
    private final SurveyLogicMatrixCondition condition;
    private final List<Long> value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<MatrixDisplayLogicGroup> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.display.MatrixDisplayLogicGroup$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MatrixDisplayLogicGroup._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.display.MatrixDisplayLogicGroup$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MatrixDisplayLogicGroup._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.display.MatrixDisplayLogicGroup$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MatrixDisplayLogicGroup._childSerializers$_anonymous_$1();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.display.MatrixDisplayLogicGroup$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MatrixDisplayLogicGroup._childSerializers$_anonymous_$2();
        }
    })};

    /* JADX INFO: compiled from: MatrixDisplayLogic.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<MatrixDisplayLogicGroup> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MatrixDisplayLogicGroup createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            SurveyLogicMatrixCondition surveyLogicMatrixConditionValueOf = SurveyLogicMatrixCondition.valueOf(parcel.readString());
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(Long.valueOf(parcel.readLong()));
            }
            ArrayList arrayList2 = arrayList;
            int i3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList3.add(Long.valueOf(parcel.readLong()));
            }
            return new MatrixDisplayLogicGroup(surveyLogicMatrixConditionValueOf, arrayList2, arrayList3, SurveyLogicOperator.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MatrixDisplayLogicGroup[] newArray(int i) {
            return new MatrixDisplayLogicGroup[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyLogicMatrixCondition", SurveyLogicMatrixCondition.values(), new String[]{"is", "is_not", "is_between", "has_any_value"}, new Annotation[][]{null, null, null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(LongSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(LongSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator", SurveyLogicOperator.values(), new String[]{"or", "and"}, new Annotation[][]{null, null}, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MatrixDisplayLogicGroup copy$default(MatrixDisplayLogicGroup matrixDisplayLogicGroup, SurveyLogicMatrixCondition surveyLogicMatrixCondition, List list, List list2, SurveyLogicOperator surveyLogicOperator, int i, Object obj) {
        if ((i & 1) != 0) {
            surveyLogicMatrixCondition = matrixDisplayLogicGroup.condition;
        }
        if ((i & 2) != 0) {
            list = matrixDisplayLogicGroup.value;
        }
        if ((i & 4) != 0) {
            list2 = matrixDisplayLogicGroup.answerId;
        }
        if ((i & 8) != 0) {
            surveyLogicOperator = matrixDisplayLogicGroup.answerIdOperator;
        }
        return matrixDisplayLogicGroup.copy(surveyLogicMatrixCondition, list, list2, surveyLogicOperator);
    }

    @SerialName("answer_id")
    public static /* synthetic */ void getAnswerId$annotations() {
    }

    @SerialName("answer_id_operator")
    public static /* synthetic */ void getAnswerIdOperator$annotations() {
    }

    @SerialName("condition")
    public static /* synthetic */ void getCondition$annotations() {
    }

    @SerialName("value")
    public static /* synthetic */ void getValue$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SurveyLogicMatrixCondition getCondition() {
        return this.condition;
    }

    public final List<Long> component2() {
        return this.value;
    }

    public final List<Long> component3() {
        return this.answerId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SurveyLogicOperator getAnswerIdOperator() {
        return this.answerIdOperator;
    }

    public final MatrixDisplayLogicGroup copy(SurveyLogicMatrixCondition condition, List<Long> value, List<Long> answerId, SurveyLogicOperator answerIdOperator) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(answerId, "answerId");
        Intrinsics.checkNotNullParameter(answerIdOperator, "answerIdOperator");
        return new MatrixDisplayLogicGroup(condition, value, answerId, answerIdOperator);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixDisplayLogicGroup)) {
            return false;
        }
        MatrixDisplayLogicGroup matrixDisplayLogicGroup = (MatrixDisplayLogicGroup) other;
        return this.condition == matrixDisplayLogicGroup.condition && Intrinsics.areEqual(this.value, matrixDisplayLogicGroup.value) && Intrinsics.areEqual(this.answerId, matrixDisplayLogicGroup.answerId) && this.answerIdOperator == matrixDisplayLogicGroup.answerIdOperator;
    }

    public int hashCode() {
        return (((((this.condition.hashCode() * 31) + this.value.hashCode()) * 31) + this.answerId.hashCode()) * 31) + this.answerIdOperator.hashCode();
    }

    public String toString() {
        return "MatrixDisplayLogicGroup(condition=" + this.condition + ", value=" + this.value + ", answerId=" + this.answerId + ", answerIdOperator=" + this.answerIdOperator + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.condition.name());
        List<Long> list = this.value;
        dest.writeInt(list.size());
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            dest.writeLong(it.next().longValue());
        }
        List<Long> list2 = this.answerId;
        dest.writeInt(list2.size());
        Iterator<Long> it2 = list2.iterator();
        while (it2.hasNext()) {
            dest.writeLong(it2.next().longValue());
        }
        dest.writeString(this.answerIdOperator.name());
    }

    /* JADX INFO: compiled from: MatrixDisplayLogic.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/display/MatrixDisplayLogicGroup$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/MatrixDisplayLogicGroup;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<MatrixDisplayLogicGroup> serializer() {
            return MatrixDisplayLogicGroup$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ MatrixDisplayLogicGroup(int i, SurveyLogicMatrixCondition surveyLogicMatrixCondition, List list, List list2, SurveyLogicOperator surveyLogicOperator, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, MatrixDisplayLogicGroup$$serializer.INSTANCE.getDescriptor());
        }
        this.condition = surveyLogicMatrixCondition;
        this.value = list;
        this.answerId = list2;
        this.answerIdOperator = surveyLogicOperator;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(MatrixDisplayLogicGroup self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.condition);
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.value);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.answerId);
        output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.answerIdOperator);
    }

    public MatrixDisplayLogicGroup(SurveyLogicMatrixCondition condition, List<Long> value, List<Long> answerId, SurveyLogicOperator answerIdOperator) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(answerId, "answerId");
        Intrinsics.checkNotNullParameter(answerIdOperator, "answerIdOperator");
        this.condition = condition;
        this.value = value;
        this.answerId = answerId;
        this.answerIdOperator = answerIdOperator;
    }

    public final SurveyLogicMatrixCondition getCondition() {
        return this.condition;
    }

    public final List<Long> getValue() {
        return this.value;
    }

    public final List<Long> getAnswerId() {
        return this.answerId;
    }

    public final SurveyLogicOperator getAnswerIdOperator() {
        return this.answerIdOperator;
    }
}

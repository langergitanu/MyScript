package com.survicate.surveys.entities.survey.surveyLogic.matrix;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
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

/* JADX INFO: compiled from: SurveyLogicMatrixGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0002@ABE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\r\u0010\u000eB_\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003JS\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0001J\u0006\u0010,\u001a\u00020\u0003J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0003J%\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\b?R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\"R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010\u001f¨\u0006B"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixGroup;", "Landroid/os/Parcelable;", "orderNumber", "", "uid", "", "condition", "Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixCondition;", "values", "", "answerIdOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "answerIds", "<init>", "(IJLcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixCondition;Ljava/util/List;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIJLcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixCondition;Ljava/util/List;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOrderNumber$annotations", "()V", "getOrderNumber", "()I", "getUid$annotations", "getUid", "()J", "getCondition$annotations", "getCondition", "()Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixCondition;", "getValues$annotations", "getValues", "()Ljava/util/List;", "getAnswerIdOperator$annotations", "getAnswerIdOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getAnswerIds$annotations", "getAnswerIds", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveyLogicMatrixGroup implements Parcelable {
    private final SurveyLogicOperator answerIdOperator;
    private final List<Long> answerIds;
    private final SurveyLogicMatrixCondition condition;
    private final int orderNumber;
    private final long uid;
    private final List<Long> values;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyLogicMatrixGroup> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyLogicMatrixGroup$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyLogicMatrixGroup._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyLogicMatrixGroup$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyLogicMatrixGroup._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyLogicMatrixGroup$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyLogicMatrixGroup._childSerializers$_anonymous_$1();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyLogicMatrixGroup$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyLogicMatrixGroup._childSerializers$_anonymous_$2();
        }
    })};

    /* JADX INFO: compiled from: SurveyLogicMatrixGroup.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyLogicMatrixGroup> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyLogicMatrixGroup createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            long j = parcel.readLong();
            SurveyLogicMatrixCondition surveyLogicMatrixConditionValueOf = SurveyLogicMatrixCondition.valueOf(parcel.readString());
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(Long.valueOf(parcel.readLong()));
            }
            ArrayList arrayList2 = arrayList;
            SurveyLogicOperator surveyLogicOperatorValueOf = parcel.readInt() == 0 ? null : SurveyLogicOperator.valueOf(parcel.readString());
            int i4 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i4);
            for (int i5 = 0; i5 != i4; i5++) {
                arrayList3.add(Long.valueOf(parcel.readLong()));
            }
            return new SurveyLogicMatrixGroup(i, j, surveyLogicMatrixConditionValueOf, arrayList2, surveyLogicOperatorValueOf, arrayList3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyLogicMatrixGroup[] newArray(int i) {
            return new SurveyLogicMatrixGroup[i];
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
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator", SurveyLogicOperator.values(), new String[]{"or", "and"}, new Annotation[][]{null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(LongSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyLogicMatrixGroup copy$default(SurveyLogicMatrixGroup surveyLogicMatrixGroup, int i, long j, SurveyLogicMatrixCondition surveyLogicMatrixCondition, List list, SurveyLogicOperator surveyLogicOperator, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = surveyLogicMatrixGroup.orderNumber;
        }
        if ((i2 & 2) != 0) {
            j = surveyLogicMatrixGroup.uid;
        }
        if ((i2 & 4) != 0) {
            surveyLogicMatrixCondition = surveyLogicMatrixGroup.condition;
        }
        if ((i2 & 8) != 0) {
            list = surveyLogicMatrixGroup.values;
        }
        if ((i2 & 16) != 0) {
            surveyLogicOperator = surveyLogicMatrixGroup.answerIdOperator;
        }
        if ((i2 & 32) != 0) {
            list2 = surveyLogicMatrixGroup.answerIds;
        }
        return surveyLogicMatrixGroup.copy(i, j, surveyLogicMatrixCondition, list, surveyLogicOperator, list2);
    }

    @SerialName("answer_id_operator")
    public static /* synthetic */ void getAnswerIdOperator$annotations() {
    }

    @SerialName("answer_id")
    public static /* synthetic */ void getAnswerIds$annotations() {
    }

    @SerialName("condition")
    public static /* synthetic */ void getCondition$annotations() {
    }

    @SerialName("order_number")
    public static /* synthetic */ void getOrderNumber$annotations() {
    }

    @SerialName("uid")
    public static /* synthetic */ void getUid$annotations() {
    }

    @SerialName("value")
    public static /* synthetic */ void getValues$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getOrderNumber() {
        return this.orderNumber;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getUid() {
        return this.uid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SurveyLogicMatrixCondition getCondition() {
        return this.condition;
    }

    public final List<Long> component4() {
        return this.values;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final SurveyLogicOperator getAnswerIdOperator() {
        return this.answerIdOperator;
    }

    public final List<Long> component6() {
        return this.answerIds;
    }

    public final SurveyLogicMatrixGroup copy(int orderNumber, long uid, SurveyLogicMatrixCondition condition, List<Long> values, SurveyLogicOperator answerIdOperator, List<Long> answerIds) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(answerIds, "answerIds");
        return new SurveyLogicMatrixGroup(orderNumber, uid, condition, values, answerIdOperator, answerIds);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyLogicMatrixGroup)) {
            return false;
        }
        SurveyLogicMatrixGroup surveyLogicMatrixGroup = (SurveyLogicMatrixGroup) other;
        return this.orderNumber == surveyLogicMatrixGroup.orderNumber && this.uid == surveyLogicMatrixGroup.uid && this.condition == surveyLogicMatrixGroup.condition && Intrinsics.areEqual(this.values, surveyLogicMatrixGroup.values) && this.answerIdOperator == surveyLogicMatrixGroup.answerIdOperator && Intrinsics.areEqual(this.answerIds, surveyLogicMatrixGroup.answerIds);
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.orderNumber) * 31) + Long.hashCode(this.uid)) * 31) + this.condition.hashCode()) * 31) + this.values.hashCode()) * 31;
        SurveyLogicOperator surveyLogicOperator = this.answerIdOperator;
        return ((iHashCode + (surveyLogicOperator == null ? 0 : surveyLogicOperator.hashCode())) * 31) + this.answerIds.hashCode();
    }

    public String toString() {
        return "SurveyLogicMatrixGroup(orderNumber=" + this.orderNumber + ", uid=" + this.uid + ", condition=" + this.condition + ", values=" + this.values + ", answerIdOperator=" + this.answerIdOperator + ", answerIds=" + this.answerIds + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.orderNumber);
        dest.writeLong(this.uid);
        dest.writeString(this.condition.name());
        List<Long> list = this.values;
        dest.writeInt(list.size());
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            dest.writeLong(it.next().longValue());
        }
        SurveyLogicOperator surveyLogicOperator = this.answerIdOperator;
        if (surveyLogicOperator == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(surveyLogicOperator.name());
        }
        List<Long> list2 = this.answerIds;
        dest.writeInt(list2.size());
        Iterator<Long> it2 = list2.iterator();
        while (it2.hasNext()) {
            dest.writeLong(it2.next().longValue());
        }
    }

    /* JADX INFO: compiled from: SurveyLogicMatrixGroup.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixGroup$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixGroup;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyLogicMatrixGroup> serializer() {
            return SurveyLogicMatrixGroup$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyLogicMatrixGroup(int i, int i2, long j, SurveyLogicMatrixCondition surveyLogicMatrixCondition, List list, SurveyLogicOperator surveyLogicOperator, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, SurveyLogicMatrixGroup$$serializer.INSTANCE.getDescriptor());
        }
        this.orderNumber = i2;
        this.uid = j;
        this.condition = surveyLogicMatrixCondition;
        this.values = list;
        this.answerIdOperator = surveyLogicOperator;
        this.answerIds = list2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyLogicMatrixGroup self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.orderNumber);
        output.encodeLongElement(serialDesc, 1, self.uid);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.condition);
        output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.values);
        output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.answerIdOperator);
        output.encodeSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.answerIds);
    }

    public SurveyLogicMatrixGroup(int i, long j, SurveyLogicMatrixCondition condition, List<Long> values, SurveyLogicOperator surveyLogicOperator, List<Long> answerIds) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(answerIds, "answerIds");
        this.orderNumber = i;
        this.uid = j;
        this.condition = condition;
        this.values = values;
        this.answerIdOperator = surveyLogicOperator;
        this.answerIds = answerIds;
    }

    public final int getOrderNumber() {
        return this.orderNumber;
    }

    public final long getUid() {
        return this.uid;
    }

    public final SurveyLogicMatrixCondition getCondition() {
        return this.condition;
    }

    public final List<Long> getValues() {
        return this.values;
    }

    public final SurveyLogicOperator getAnswerIdOperator() {
        return this.answerIdOperator;
    }

    public final List<Long> getAnswerIds() {
        return this.answerIds;
    }
}

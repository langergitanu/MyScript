package com.survicate.surveys.entities.survey.surveyLogic.multiple;

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

/* JADX INFO: compiled from: SurveyPointMultipleLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0002@AB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\u0004\b\r\u0010\u000eBW\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\fHÆ\u0003JM\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fHÆ\u0001J\u0006\u0010,\u001a\u00020\u0003J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0003J%\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\b?R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010!R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010$¨\u0006B"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyPointMultipleLogic;", "Landroid/os/Parcelable;", "orderNumber", "", "uid", "", "goTo", "condition", "Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyLogicMultipleCondition;", "logicOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "values", "", "<init>", "(IJJLcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyLogicMultipleCondition;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIJJLcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyLogicMultipleCondition;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOrderNumber$annotations", "()V", "getOrderNumber", "()I", "getUid$annotations", "getUid", "()J", "getGoTo$annotations", "getGoTo", "getCondition$annotations", "getCondition", "()Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyLogicMultipleCondition;", "getLogicOperator$annotations", "getLogicOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getValues$annotations", "getValues", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveyPointMultipleLogic implements Parcelable {
    private final SurveyLogicMultipleCondition condition;
    private final long goTo;
    private final SurveyLogicOperator logicOperator;
    private final int orderNumber;
    private final long uid;
    private final List<Long> values;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyPointMultipleLogic> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.multiple.SurveyPointMultipleLogic$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointMultipleLogic._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.multiple.SurveyPointMultipleLogic$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointMultipleLogic._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.multiple.SurveyPointMultipleLogic$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointMultipleLogic._childSerializers$_anonymous_$1();
        }
    })};

    /* JADX INFO: compiled from: SurveyPointMultipleLogic.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyPointMultipleLogic> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointMultipleLogic createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            SurveyLogicMultipleCondition surveyLogicMultipleConditionValueOf = SurveyLogicMultipleCondition.valueOf(parcel.readString());
            SurveyLogicOperator surveyLogicOperatorValueOf = parcel.readInt() == 0 ? null : SurveyLogicOperator.valueOf(parcel.readString());
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(Long.valueOf(parcel.readLong()));
            }
            return new SurveyPointMultipleLogic(i, j, j2, surveyLogicMultipleConditionValueOf, surveyLogicOperatorValueOf, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointMultipleLogic[] newArray(int i) {
            return new SurveyPointMultipleLogic[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return SurveyLogicMultipleCondition.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator", SurveyLogicOperator.values(), new String[]{"or", "and"}, new Annotation[][]{null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(LongSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyPointMultipleLogic copy$default(SurveyPointMultipleLogic surveyPointMultipleLogic, int i, long j, long j2, SurveyLogicMultipleCondition surveyLogicMultipleCondition, SurveyLogicOperator surveyLogicOperator, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = surveyPointMultipleLogic.orderNumber;
        }
        if ((i2 & 2) != 0) {
            j = surveyPointMultipleLogic.uid;
        }
        if ((i2 & 4) != 0) {
            j2 = surveyPointMultipleLogic.goTo;
        }
        if ((i2 & 8) != 0) {
            surveyLogicMultipleCondition = surveyPointMultipleLogic.condition;
        }
        if ((i2 & 16) != 0) {
            surveyLogicOperator = surveyPointMultipleLogic.logicOperator;
        }
        if ((i2 & 32) != 0) {
            list = surveyPointMultipleLogic.values;
        }
        List list2 = list;
        SurveyLogicMultipleCondition surveyLogicMultipleCondition2 = surveyLogicMultipleCondition;
        long j3 = j2;
        return surveyPointMultipleLogic.copy(i, j, j3, surveyLogicMultipleCondition2, surveyLogicOperator, list2);
    }

    @SerialName("condition")
    public static /* synthetic */ void getCondition$annotations() {
    }

    @SerialName("go_to")
    public static /* synthetic */ void getGoTo$annotations() {
    }

    @SerialName("operator")
    public static /* synthetic */ void getLogicOperator$annotations() {
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
    public final long getGoTo() {
        return this.goTo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SurveyLogicMultipleCondition getCondition() {
        return this.condition;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final SurveyLogicOperator getLogicOperator() {
        return this.logicOperator;
    }

    public final List<Long> component6() {
        return this.values;
    }

    public final SurveyPointMultipleLogic copy(int orderNumber, long uid, long goTo, SurveyLogicMultipleCondition condition, SurveyLogicOperator logicOperator, List<Long> values) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(values, "values");
        return new SurveyPointMultipleLogic(orderNumber, uid, goTo, condition, logicOperator, values);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyPointMultipleLogic)) {
            return false;
        }
        SurveyPointMultipleLogic surveyPointMultipleLogic = (SurveyPointMultipleLogic) other;
        return this.orderNumber == surveyPointMultipleLogic.orderNumber && this.uid == surveyPointMultipleLogic.uid && this.goTo == surveyPointMultipleLogic.goTo && this.condition == surveyPointMultipleLogic.condition && this.logicOperator == surveyPointMultipleLogic.logicOperator && Intrinsics.areEqual(this.values, surveyPointMultipleLogic.values);
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.orderNumber) * 31) + Long.hashCode(this.uid)) * 31) + Long.hashCode(this.goTo)) * 31) + this.condition.hashCode()) * 31;
        SurveyLogicOperator surveyLogicOperator = this.logicOperator;
        return ((iHashCode + (surveyLogicOperator == null ? 0 : surveyLogicOperator.hashCode())) * 31) + this.values.hashCode();
    }

    public String toString() {
        return "SurveyPointMultipleLogic(orderNumber=" + this.orderNumber + ", uid=" + this.uid + ", goTo=" + this.goTo + ", condition=" + this.condition + ", logicOperator=" + this.logicOperator + ", values=" + this.values + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.orderNumber);
        dest.writeLong(this.uid);
        dest.writeLong(this.goTo);
        dest.writeString(this.condition.name());
        SurveyLogicOperator surveyLogicOperator = this.logicOperator;
        if (surveyLogicOperator == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(surveyLogicOperator.name());
        }
        List<Long> list = this.values;
        dest.writeInt(list.size());
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            dest.writeLong(it.next().longValue());
        }
    }

    /* JADX INFO: compiled from: SurveyPointMultipleLogic.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyPointMultipleLogic$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyPointMultipleLogic;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyPointMultipleLogic> serializer() {
            return SurveyPointMultipleLogic$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyPointMultipleLogic(int i, int i2, long j, long j2, SurveyLogicMultipleCondition surveyLogicMultipleCondition, SurveyLogicOperator surveyLogicOperator, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, SurveyPointMultipleLogic$$serializer.INSTANCE.getDescriptor());
        }
        this.orderNumber = i2;
        this.uid = j;
        this.goTo = j2;
        this.condition = surveyLogicMultipleCondition;
        this.logicOperator = surveyLogicOperator;
        this.values = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyPointMultipleLogic self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.orderNumber);
        output.encodeLongElement(serialDesc, 1, self.uid);
        output.encodeLongElement(serialDesc, 2, self.goTo);
        output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.condition);
        output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.logicOperator);
        output.encodeSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.values);
    }

    public SurveyPointMultipleLogic(int i, long j, long j2, SurveyLogicMultipleCondition condition, SurveyLogicOperator surveyLogicOperator, List<Long> values) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(values, "values");
        this.orderNumber = i;
        this.uid = j;
        this.goTo = j2;
        this.condition = condition;
        this.logicOperator = surveyLogicOperator;
        this.values = values;
    }

    public final int getOrderNumber() {
        return this.orderNumber;
    }

    public final long getUid() {
        return this.uid;
    }

    public final long getGoTo() {
        return this.goTo;
    }

    public final SurveyLogicMultipleCondition getCondition() {
        return this.condition;
    }

    public final SurveyLogicOperator getLogicOperator() {
        return this.logicOperator;
    }

    public final List<Long> getValues() {
        return this.values;
    }
}

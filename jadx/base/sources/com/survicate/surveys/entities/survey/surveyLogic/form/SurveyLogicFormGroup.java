package com.survicate.surveys.entities.survey.surveyLogic.form;

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

/* JADX INFO: compiled from: SurveyLogicFormGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0002<=B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\f\u0010\rBO\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003JC\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0001J\u0006\u0010(\u001a\u00020\u0003J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0003J%\u00105\u001a\u0002012\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\b;R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010!¨\u0006>"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormGroup;", "Landroid/os/Parcelable;", "orderNumber", "", "uid", "", "condition", "Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormCondition;", "fieldOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "fields", "", "<init>", "(IJLcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormCondition;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIJLcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormCondition;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOrderNumber$annotations", "()V", "getOrderNumber", "()I", "getUid$annotations", "getUid", "()J", "getCondition$annotations", "getCondition", "()Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormCondition;", "getFieldOperator$annotations", "getFieldOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getFields$annotations", "getFields", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveyLogicFormGroup implements Parcelable {
    private final SurveyLogicFormCondition condition;
    private final SurveyLogicOperator fieldOperator;
    private final List<Long> fields;
    private final int orderNumber;
    private final long uid;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyLogicFormGroup> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.form.SurveyLogicFormGroup$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyLogicFormGroup._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.form.SurveyLogicFormGroup$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyLogicFormGroup._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.form.SurveyLogicFormGroup$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyLogicFormGroup._childSerializers$_anonymous_$1();
        }
    })};

    /* JADX INFO: compiled from: SurveyLogicFormGroup.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyLogicFormGroup> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyLogicFormGroup createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            long j = parcel.readLong();
            SurveyLogicFormCondition surveyLogicFormConditionValueOf = SurveyLogicFormCondition.valueOf(parcel.readString());
            SurveyLogicOperator surveyLogicOperatorValueOf = parcel.readInt() == 0 ? null : SurveyLogicOperator.valueOf(parcel.readString());
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(Long.valueOf(parcel.readLong()));
            }
            return new SurveyLogicFormGroup(i, j, surveyLogicFormConditionValueOf, surveyLogicOperatorValueOf, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyLogicFormGroup[] newArray(int i) {
            return new SurveyLogicFormGroup[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.surveyLogic.form.SurveyLogicFormCondition", SurveyLogicFormCondition.values(), new String[]{"is_filled_in", "is_not_filled_in", "has_any_value"}, new Annotation[][]{null, null, null}, null);
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
    public static /* synthetic */ SurveyLogicFormGroup copy$default(SurveyLogicFormGroup surveyLogicFormGroup, int i, long j, SurveyLogicFormCondition surveyLogicFormCondition, SurveyLogicOperator surveyLogicOperator, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = surveyLogicFormGroup.orderNumber;
        }
        if ((i2 & 2) != 0) {
            j = surveyLogicFormGroup.uid;
        }
        if ((i2 & 4) != 0) {
            surveyLogicFormCondition = surveyLogicFormGroup.condition;
        }
        if ((i2 & 8) != 0) {
            surveyLogicOperator = surveyLogicFormGroup.fieldOperator;
        }
        if ((i2 & 16) != 0) {
            list = surveyLogicFormGroup.fields;
        }
        List list2 = list;
        SurveyLogicFormCondition surveyLogicFormCondition2 = surveyLogicFormCondition;
        return surveyLogicFormGroup.copy(i, j, surveyLogicFormCondition2, surveyLogicOperator, list2);
    }

    @SerialName("condition")
    public static /* synthetic */ void getCondition$annotations() {
    }

    @SerialName("field_id_operator")
    public static /* synthetic */ void getFieldOperator$annotations() {
    }

    @SerialName("field_id")
    public static /* synthetic */ void getFields$annotations() {
    }

    @SerialName("order_number")
    public static /* synthetic */ void getOrderNumber$annotations() {
    }

    @SerialName("uid")
    public static /* synthetic */ void getUid$annotations() {
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
    public final SurveyLogicFormCondition getCondition() {
        return this.condition;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SurveyLogicOperator getFieldOperator() {
        return this.fieldOperator;
    }

    public final List<Long> component5() {
        return this.fields;
    }

    public final SurveyLogicFormGroup copy(int orderNumber, long uid, SurveyLogicFormCondition condition, SurveyLogicOperator fieldOperator, List<Long> fields) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(fields, "fields");
        return new SurveyLogicFormGroup(orderNumber, uid, condition, fieldOperator, fields);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyLogicFormGroup)) {
            return false;
        }
        SurveyLogicFormGroup surveyLogicFormGroup = (SurveyLogicFormGroup) other;
        return this.orderNumber == surveyLogicFormGroup.orderNumber && this.uid == surveyLogicFormGroup.uid && this.condition == surveyLogicFormGroup.condition && this.fieldOperator == surveyLogicFormGroup.fieldOperator && Intrinsics.areEqual(this.fields, surveyLogicFormGroup.fields);
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.orderNumber) * 31) + Long.hashCode(this.uid)) * 31) + this.condition.hashCode()) * 31;
        SurveyLogicOperator surveyLogicOperator = this.fieldOperator;
        return ((iHashCode + (surveyLogicOperator == null ? 0 : surveyLogicOperator.hashCode())) * 31) + this.fields.hashCode();
    }

    public String toString() {
        return "SurveyLogicFormGroup(orderNumber=" + this.orderNumber + ", uid=" + this.uid + ", condition=" + this.condition + ", fieldOperator=" + this.fieldOperator + ", fields=" + this.fields + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.orderNumber);
        dest.writeLong(this.uid);
        dest.writeString(this.condition.name());
        SurveyLogicOperator surveyLogicOperator = this.fieldOperator;
        if (surveyLogicOperator == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(surveyLogicOperator.name());
        }
        List<Long> list = this.fields;
        dest.writeInt(list.size());
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            dest.writeLong(it.next().longValue());
        }
    }

    /* JADX INFO: compiled from: SurveyLogicFormGroup.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormGroup$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormGroup;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyLogicFormGroup> serializer() {
            return SurveyLogicFormGroup$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyLogicFormGroup(int i, int i2, long j, SurveyLogicFormCondition surveyLogicFormCondition, SurveyLogicOperator surveyLogicOperator, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, SurveyLogicFormGroup$$serializer.INSTANCE.getDescriptor());
        }
        this.orderNumber = i2;
        this.uid = j;
        this.condition = surveyLogicFormCondition;
        this.fieldOperator = surveyLogicOperator;
        this.fields = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyLogicFormGroup self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.orderNumber);
        output.encodeLongElement(serialDesc, 1, self.uid);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.condition);
        output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.fieldOperator);
        output.encodeSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.fields);
    }

    public SurveyLogicFormGroup(int i, long j, SurveyLogicFormCondition condition, SurveyLogicOperator surveyLogicOperator, List<Long> fields) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(fields, "fields");
        this.orderNumber = i;
        this.uid = j;
        this.condition = condition;
        this.fieldOperator = surveyLogicOperator;
        this.fields = fields;
    }

    public final int getOrderNumber() {
        return this.orderNumber;
    }

    public final long getUid() {
        return this.uid;
    }

    public final SurveyLogicFormCondition getCondition() {
        return this.condition;
    }

    public final SurveyLogicOperator getFieldOperator() {
        return this.fieldOperator;
    }

    public final List<Long> getFields() {
        return this.fields;
    }
}

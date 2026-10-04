package com.survicate.surveys.entities.survey.surveyLogic.display;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.entities.survey.surveyLogic.form.SurveyLogicFormCondition;
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

/* JADX INFO: compiled from: FormDisplayLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0006\u0010\u001e\u001a\u00020\fJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\fHÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fJ%\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019¨\u00064"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/display/FormDisplayLogicGroup;", "Landroid/os/Parcelable;", "condition", "Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormCondition;", "fieldIdOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "fieldId", "", "", "<init>", "(Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormCondition;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormCondition;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCondition$annotations", "()V", "getCondition", "()Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormCondition;", "getFieldIdOperator$annotations", "getFieldIdOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getFieldId$annotations", "getFieldId", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class FormDisplayLogicGroup implements Parcelable {
    private final SurveyLogicFormCondition condition;
    private final List<Long> fieldId;
    private final SurveyLogicOperator fieldIdOperator;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<FormDisplayLogicGroup> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.display.FormDisplayLogicGroup$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return FormDisplayLogicGroup._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.display.FormDisplayLogicGroup$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return FormDisplayLogicGroup._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.display.FormDisplayLogicGroup$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return FormDisplayLogicGroup._childSerializers$_anonymous_$1();
        }
    })};

    /* JADX INFO: compiled from: FormDisplayLogic.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<FormDisplayLogicGroup> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FormDisplayLogicGroup createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            SurveyLogicFormCondition surveyLogicFormConditionValueOf = SurveyLogicFormCondition.valueOf(parcel.readString());
            SurveyLogicOperator surveyLogicOperatorValueOf = SurveyLogicOperator.valueOf(parcel.readString());
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(Long.valueOf(parcel.readLong()));
            }
            return new FormDisplayLogicGroup(surveyLogicFormConditionValueOf, surveyLogicOperatorValueOf, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FormDisplayLogicGroup[] newArray(int i) {
            return new FormDisplayLogicGroup[i];
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
    public static /* synthetic */ FormDisplayLogicGroup copy$default(FormDisplayLogicGroup formDisplayLogicGroup, SurveyLogicFormCondition surveyLogicFormCondition, SurveyLogicOperator surveyLogicOperator, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            surveyLogicFormCondition = formDisplayLogicGroup.condition;
        }
        if ((i & 2) != 0) {
            surveyLogicOperator = formDisplayLogicGroup.fieldIdOperator;
        }
        if ((i & 4) != 0) {
            list = formDisplayLogicGroup.fieldId;
        }
        return formDisplayLogicGroup.copy(surveyLogicFormCondition, surveyLogicOperator, list);
    }

    @SerialName("condition")
    public static /* synthetic */ void getCondition$annotations() {
    }

    @SerialName("field_id")
    public static /* synthetic */ void getFieldId$annotations() {
    }

    @SerialName("field_id_operator")
    public static /* synthetic */ void getFieldIdOperator$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SurveyLogicFormCondition getCondition() {
        return this.condition;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SurveyLogicOperator getFieldIdOperator() {
        return this.fieldIdOperator;
    }

    public final List<Long> component3() {
        return this.fieldId;
    }

    public final FormDisplayLogicGroup copy(SurveyLogicFormCondition condition, SurveyLogicOperator fieldIdOperator, List<Long> fieldId) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(fieldIdOperator, "fieldIdOperator");
        Intrinsics.checkNotNullParameter(fieldId, "fieldId");
        return new FormDisplayLogicGroup(condition, fieldIdOperator, fieldId);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormDisplayLogicGroup)) {
            return false;
        }
        FormDisplayLogicGroup formDisplayLogicGroup = (FormDisplayLogicGroup) other;
        return this.condition == formDisplayLogicGroup.condition && this.fieldIdOperator == formDisplayLogicGroup.fieldIdOperator && Intrinsics.areEqual(this.fieldId, formDisplayLogicGroup.fieldId);
    }

    public int hashCode() {
        return (((this.condition.hashCode() * 31) + this.fieldIdOperator.hashCode()) * 31) + this.fieldId.hashCode();
    }

    public String toString() {
        return "FormDisplayLogicGroup(condition=" + this.condition + ", fieldIdOperator=" + this.fieldIdOperator + ", fieldId=" + this.fieldId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.condition.name());
        dest.writeString(this.fieldIdOperator.name());
        List<Long> list = this.fieldId;
        dest.writeInt(list.size());
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            dest.writeLong(it.next().longValue());
        }
    }

    /* JADX INFO: compiled from: FormDisplayLogic.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/display/FormDisplayLogicGroup$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/FormDisplayLogicGroup;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<FormDisplayLogicGroup> serializer() {
            return FormDisplayLogicGroup$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ FormDisplayLogicGroup(int i, SurveyLogicFormCondition surveyLogicFormCondition, SurveyLogicOperator surveyLogicOperator, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, FormDisplayLogicGroup$$serializer.INSTANCE.getDescriptor());
        }
        this.condition = surveyLogicFormCondition;
        this.fieldIdOperator = surveyLogicOperator;
        this.fieldId = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(FormDisplayLogicGroup self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.condition);
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.fieldIdOperator);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.fieldId);
    }

    public FormDisplayLogicGroup(SurveyLogicFormCondition condition, SurveyLogicOperator fieldIdOperator, List<Long> fieldId) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(fieldIdOperator, "fieldIdOperator");
        Intrinsics.checkNotNullParameter(fieldId, "fieldId");
        this.condition = condition;
        this.fieldIdOperator = fieldIdOperator;
        this.fieldId = fieldId;
    }

    public final SurveyLogicFormCondition getCondition() {
        return this.condition;
    }

    public final SurveyLogicOperator getFieldIdOperator() {
        return this.fieldIdOperator;
    }

    public final List<Long> getFieldId() {
        return this.fieldId;
    }
}

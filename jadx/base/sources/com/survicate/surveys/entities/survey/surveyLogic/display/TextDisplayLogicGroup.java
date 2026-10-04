package com.survicate.surveys.entities.survey.surveyLogic.display;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.entities.survey.surveyLogic.text.SurveyLogicTextCondition;
import java.lang.annotation.Annotation;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: TextDisplayLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0006\u0010\u001e\u001a\u00020\fJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\fHÖ\u0001J\t\u0010$\u001a\u00020\bHÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\fJ%\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019¨\u00063"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/display/TextDisplayLogicGroup;", "Landroid/os/Parcelable;", "condition", "Lcom/survicate/surveys/entities/survey/surveyLogic/text/SurveyLogicTextCondition;", "valueOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "value", "", "", "<init>", "(Lcom/survicate/surveys/entities/survey/surveyLogic/text/SurveyLogicTextCondition;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/survicate/surveys/entities/survey/surveyLogic/text/SurveyLogicTextCondition;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCondition$annotations", "()V", "getCondition", "()Lcom/survicate/surveys/entities/survey/surveyLogic/text/SurveyLogicTextCondition;", "getValueOperator$annotations", "getValueOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getValue$annotations", "getValue", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class TextDisplayLogicGroup implements Parcelable {
    private final SurveyLogicTextCondition condition;
    private final List<String> value;
    private final SurveyLogicOperator valueOperator;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<TextDisplayLogicGroup> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.display.TextDisplayLogicGroup$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TextDisplayLogicGroup._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.display.TextDisplayLogicGroup$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TextDisplayLogicGroup._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.display.TextDisplayLogicGroup$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TextDisplayLogicGroup._childSerializers$_anonymous_$1();
        }
    })};

    /* JADX INFO: compiled from: TextDisplayLogic.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<TextDisplayLogicGroup> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TextDisplayLogicGroup createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TextDisplayLogicGroup(SurveyLogicTextCondition.valueOf(parcel.readString()), SurveyLogicOperator.valueOf(parcel.readString()), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TextDisplayLogicGroup[] newArray(int i) {
            return new TextDisplayLogicGroup[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.surveyLogic.text.SurveyLogicTextCondition", SurveyLogicTextCondition.values(), new String[]{"answer_contains", "answer_doesnt_contain", "question_is_answered", "question_is_not_answered", "has_any_value"}, new Annotation[][]{null, null, null, null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator", SurveyLogicOperator.values(), new String[]{"or", "and"}, new Annotation[][]{null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextDisplayLogicGroup copy$default(TextDisplayLogicGroup textDisplayLogicGroup, SurveyLogicTextCondition surveyLogicTextCondition, SurveyLogicOperator surveyLogicOperator, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            surveyLogicTextCondition = textDisplayLogicGroup.condition;
        }
        if ((i & 2) != 0) {
            surveyLogicOperator = textDisplayLogicGroup.valueOperator;
        }
        if ((i & 4) != 0) {
            list = textDisplayLogicGroup.value;
        }
        return textDisplayLogicGroup.copy(surveyLogicTextCondition, surveyLogicOperator, list);
    }

    @SerialName("condition")
    public static /* synthetic */ void getCondition$annotations() {
    }

    @SerialName("value")
    public static /* synthetic */ void getValue$annotations() {
    }

    @SerialName("value_operator")
    public static /* synthetic */ void getValueOperator$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SurveyLogicTextCondition getCondition() {
        return this.condition;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SurveyLogicOperator getValueOperator() {
        return this.valueOperator;
    }

    public final List<String> component3() {
        return this.value;
    }

    public final TextDisplayLogicGroup copy(SurveyLogicTextCondition condition, SurveyLogicOperator valueOperator, List<String> value) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(valueOperator, "valueOperator");
        Intrinsics.checkNotNullParameter(value, "value");
        return new TextDisplayLogicGroup(condition, valueOperator, value);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextDisplayLogicGroup)) {
            return false;
        }
        TextDisplayLogicGroup textDisplayLogicGroup = (TextDisplayLogicGroup) other;
        return this.condition == textDisplayLogicGroup.condition && this.valueOperator == textDisplayLogicGroup.valueOperator && Intrinsics.areEqual(this.value, textDisplayLogicGroup.value);
    }

    public int hashCode() {
        return (((this.condition.hashCode() * 31) + this.valueOperator.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return "TextDisplayLogicGroup(condition=" + this.condition + ", valueOperator=" + this.valueOperator + ", value=" + this.value + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.condition.name());
        dest.writeString(this.valueOperator.name());
        dest.writeStringList(this.value);
    }

    /* JADX INFO: compiled from: TextDisplayLogic.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/display/TextDisplayLogicGroup$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/TextDisplayLogicGroup;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TextDisplayLogicGroup> serializer() {
            return TextDisplayLogicGroup$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ TextDisplayLogicGroup(int i, SurveyLogicTextCondition surveyLogicTextCondition, SurveyLogicOperator surveyLogicOperator, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, TextDisplayLogicGroup$$serializer.INSTANCE.getDescriptor());
        }
        this.condition = surveyLogicTextCondition;
        this.valueOperator = surveyLogicOperator;
        this.value = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(TextDisplayLogicGroup self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.condition);
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.valueOperator);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.value);
    }

    public TextDisplayLogicGroup(SurveyLogicTextCondition condition, SurveyLogicOperator valueOperator, List<String> value) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(valueOperator, "valueOperator");
        Intrinsics.checkNotNullParameter(value, "value");
        this.condition = condition;
        this.valueOperator = valueOperator;
        this.value = value;
    }

    public final SurveyLogicTextCondition getCondition() {
        return this.condition;
    }

    public final SurveyLogicOperator getValueOperator() {
        return this.valueOperator;
    }

    public final List<String> getValue() {
        return this.value;
    }
}

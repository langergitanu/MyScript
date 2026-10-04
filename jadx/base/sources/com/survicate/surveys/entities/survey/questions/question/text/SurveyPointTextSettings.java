package com.survicate.surveys.entities.survey.questions.question.text;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings$$serializer;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage$$serializer;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.text.SurveyPointTextLogic;
import com.survicate.surveys.entities.survey.surveyLogic.text.SurveyPointTextLogic$$serializer;
import com.survicate.surveys.entities.survey.translations.SurveyPointSettingsTranslation;
import com.survicate.surveys.infrastructure.serialization.DisplayLogicSerializer;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: SurveyPointTextSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@SerialName("text")
@Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 P2\u00020\u0001:\u0002OPBU\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012Bm\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\u0012\u00100\u001a\u00020\u00012\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010,Jj\u0010:\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010;J\u0006\u0010<\u001a\u00020\u0010J\u0013\u0010=\u001a\u00020\u00062\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020\u0010HÖ\u0001J\t\u0010A\u001a\u00020BHÖ\u0001J\u0016\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0010J%\u0010H\u001a\u00020D2\u0006\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0001¢\u0006\u0002\bNR\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001e\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010!R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010$R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001aR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010)R \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010-\u0012\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u0006Q"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/text/SurveyPointTextSettings;", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionPointSettings;", "logic", "", "Lcom/survicate/surveys/entities/survey/surveyLogic/text/SurveyPointTextLogic;", "mandatory", "", "disclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "displayLogicOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "displayLogic", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/DisplayLogic;", "surveyPointImage", "Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "followUpQuestionCount", "", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/Boolean;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLogic$annotations", "()V", "getLogic", "()Ljava/util/List;", "getMandatory$annotations", "getMandatory", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisclaimerSettings$annotations", "getDisclaimerSettings", "()Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "getDisplayLogicOperator$annotations", "getDisplayLogicOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getDisplayLogic$annotations", "getDisplayLogic", "getSurveyPointImage$annotations", "getSurveyPointImage", "()Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "getFollowUpQuestionCount$annotations", "getFollowUpQuestionCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "isMandatory", "()Z", "translatedWith", "translation", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointSettingsTranslation;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;Ljava/lang/Integer;)Lcom/survicate/surveys/entities/survey/questions/question/text/SurveyPointTextSettings;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveyPointTextSettings implements SurveyQuestionPointSettings {
    private final DisclaimerSettings disclaimerSettings;
    private final List<DisplayLogic> displayLogic;
    private final SurveyLogicOperator displayLogicOperator;
    private final Integer followUpQuestionCount;
    private final List<SurveyPointTextLogic> logic;
    private final Boolean mandatory;
    private final SurveyPointImage surveyPointImage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyPointTextSettings> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.text.SurveyPointTextSettings$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointTextSettings._childSerializers$_anonymous_();
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.text.SurveyPointTextSettings$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointTextSettings._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.text.SurveyPointTextSettings$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointTextSettings._childSerializers$_anonymous_$1();
        }
    }), null, null};

    /* JADX INFO: compiled from: SurveyPointTextSettings.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyPointTextSettings> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointTextSettings createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(SurveyPointTextLogic.CREATOR.createFromParcel(parcel));
            }
            ArrayList arrayList2 = arrayList;
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            DisclaimerSettings disclaimerSettingsCreateFromParcel = parcel.readInt() == 0 ? null : DisclaimerSettings.CREATOR.createFromParcel(parcel);
            SurveyLogicOperator surveyLogicOperatorValueOf = parcel.readInt() == 0 ? null : SurveyLogicOperator.valueOf(parcel.readString());
            int i3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList3.add(parcel.readParcelable(SurveyPointTextSettings.class.getClassLoader()));
            }
            return new SurveyPointTextSettings(arrayList2, boolValueOf, disclaimerSettingsCreateFromParcel, surveyLogicOperatorValueOf, arrayList3, parcel.readInt() == 0 ? null : SurveyPointImage.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointTextSettings[] newArray(int i) {
            return new SurveyPointTextSettings[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(SurveyPointTextLogic$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator", SurveyLogicOperator.values(), new String[]{"or", "and"}, new Annotation[][]{null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(DisplayLogicSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyPointTextSettings copy$default(SurveyPointTextSettings surveyPointTextSettings, List list, Boolean bool, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List list2, SurveyPointImage surveyPointImage, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            list = surveyPointTextSettings.logic;
        }
        if ((i & 2) != 0) {
            bool = surveyPointTextSettings.mandatory;
        }
        if ((i & 4) != 0) {
            disclaimerSettings = surveyPointTextSettings.disclaimerSettings;
        }
        if ((i & 8) != 0) {
            surveyLogicOperator = surveyPointTextSettings.displayLogicOperator;
        }
        if ((i & 16) != 0) {
            list2 = surveyPointTextSettings.displayLogic;
        }
        if ((i & 32) != 0) {
            surveyPointImage = surveyPointTextSettings.surveyPointImage;
        }
        if ((i & 64) != 0) {
            num = surveyPointTextSettings.followUpQuestionCount;
        }
        SurveyPointImage surveyPointImage2 = surveyPointImage;
        Integer num2 = num;
        List list3 = list2;
        DisclaimerSettings disclaimerSettings2 = disclaimerSettings;
        return surveyPointTextSettings.copy(list, bool, disclaimerSettings2, surveyLogicOperator, list3, surveyPointImage2, num2);
    }

    @SerialName("disclaimer_settings")
    public static /* synthetic */ void getDisclaimerSettings$annotations() {
    }

    @SerialName("display_logic")
    public static /* synthetic */ void getDisplayLogic$annotations() {
    }

    @SerialName("display_logic_operator")
    public static /* synthetic */ void getDisplayLogicOperator$annotations() {
    }

    @SerialName("followup_questions")
    public static /* synthetic */ void getFollowUpQuestionCount$annotations() {
    }

    @SerialName("logic")
    public static /* synthetic */ void getLogic$annotations() {
    }

    @SerialName("mandatory")
    public static /* synthetic */ void getMandatory$annotations() {
    }

    @SerialName("point_image")
    public static /* synthetic */ void getSurveyPointImage$annotations() {
    }

    public final List<SurveyPointTextLogic> component1() {
        return this.logic;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getMandatory() {
        return this.mandatory;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DisclaimerSettings getDisclaimerSettings() {
        return this.disclaimerSettings;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SurveyLogicOperator getDisplayLogicOperator() {
        return this.displayLogicOperator;
    }

    public final List<DisplayLogic> component5() {
        return this.displayLogic;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SurveyPointImage getSurveyPointImage() {
        return this.surveyPointImage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getFollowUpQuestionCount() {
        return this.followUpQuestionCount;
    }

    public final SurveyPointTextSettings copy(List<SurveyPointTextLogic> logic, Boolean mandatory, DisclaimerSettings disclaimerSettings, SurveyLogicOperator displayLogicOperator, List<? extends DisplayLogic> displayLogic, SurveyPointImage surveyPointImage, Integer followUpQuestionCount) {
        Intrinsics.checkNotNullParameter(logic, "logic");
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        return new SurveyPointTextSettings(logic, mandatory, disclaimerSettings, displayLogicOperator, displayLogic, surveyPointImage, followUpQuestionCount);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyPointTextSettings)) {
            return false;
        }
        SurveyPointTextSettings surveyPointTextSettings = (SurveyPointTextSettings) other;
        return Intrinsics.areEqual(this.logic, surveyPointTextSettings.logic) && Intrinsics.areEqual(this.mandatory, surveyPointTextSettings.mandatory) && Intrinsics.areEqual(this.disclaimerSettings, surveyPointTextSettings.disclaimerSettings) && this.displayLogicOperator == surveyPointTextSettings.displayLogicOperator && Intrinsics.areEqual(this.displayLogic, surveyPointTextSettings.displayLogic) && Intrinsics.areEqual(this.surveyPointImage, surveyPointTextSettings.surveyPointImage) && Intrinsics.areEqual(this.followUpQuestionCount, surveyPointTextSettings.followUpQuestionCount);
    }

    public int hashCode() {
        int iHashCode = this.logic.hashCode() * 31;
        Boolean bool = this.mandatory;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        DisclaimerSettings disclaimerSettings = this.disclaimerSettings;
        int iHashCode3 = (iHashCode2 + (disclaimerSettings == null ? 0 : disclaimerSettings.hashCode())) * 31;
        SurveyLogicOperator surveyLogicOperator = this.displayLogicOperator;
        int iHashCode4 = (((iHashCode3 + (surveyLogicOperator == null ? 0 : surveyLogicOperator.hashCode())) * 31) + this.displayLogic.hashCode()) * 31;
        SurveyPointImage surveyPointImage = this.surveyPointImage;
        int iHashCode5 = (iHashCode4 + (surveyPointImage == null ? 0 : surveyPointImage.hashCode())) * 31;
        Integer num = this.followUpQuestionCount;
        return iHashCode5 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "SurveyPointTextSettings(logic=" + this.logic + ", mandatory=" + this.mandatory + ", disclaimerSettings=" + this.disclaimerSettings + ", displayLogicOperator=" + this.displayLogicOperator + ", displayLogic=" + this.displayLogic + ", surveyPointImage=" + this.surveyPointImage + ", followUpQuestionCount=" + this.followUpQuestionCount + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        List<SurveyPointTextLogic> list = this.logic;
        dest.writeInt(list.size());
        Iterator<SurveyPointTextLogic> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        Boolean bool = this.mandatory;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        DisclaimerSettings disclaimerSettings = this.disclaimerSettings;
        if (disclaimerSettings == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            disclaimerSettings.writeToParcel(dest, flags);
        }
        SurveyLogicOperator surveyLogicOperator = this.displayLogicOperator;
        if (surveyLogicOperator == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(surveyLogicOperator.name());
        }
        List<DisplayLogic> list2 = this.displayLogic;
        dest.writeInt(list2.size());
        Iterator<DisplayLogic> it2 = list2.iterator();
        while (it2.hasNext()) {
            dest.writeParcelable(it2.next(), flags);
        }
        SurveyPointImage surveyPointImage = this.surveyPointImage;
        if (surveyPointImage == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            surveyPointImage.writeToParcel(dest, flags);
        }
        Integer num = this.followUpQuestionCount;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
    }

    /* JADX INFO: compiled from: SurveyPointTextSettings.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/text/SurveyPointTextSettings$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/questions/question/text/SurveyPointTextSettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyPointTextSettings> serializer() {
            return SurveyPointTextSettings$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyPointTextSettings(int i, List list, Boolean bool, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List list2, SurveyPointImage surveyPointImage, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i, 127, SurveyPointTextSettings$$serializer.INSTANCE.getDescriptor());
        }
        this.logic = list;
        this.mandatory = bool;
        this.disclaimerSettings = disclaimerSettings;
        this.displayLogicOperator = surveyLogicOperator;
        this.displayLogic = list2;
        this.surveyPointImage = surveyPointImage;
        this.followUpQuestionCount = num;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyPointTextSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.logic);
        output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.mandatory);
        output.encodeNullableSerializableElement(serialDesc, 2, DisclaimerSettings$$serializer.INSTANCE, self.getDisclaimerSettings());
        output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.getDisplayLogicOperator());
        output.encodeSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.getDisplayLogic());
        output.encodeNullableSerializableElement(serialDesc, 5, SurveyPointImage$$serializer.INSTANCE, self.getSurveyPointImage());
        output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.followUpQuestionCount);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SurveyPointTextSettings(List<SurveyPointTextLogic> logic, Boolean bool, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List<? extends DisplayLogic> displayLogic, SurveyPointImage surveyPointImage, Integer num) {
        Intrinsics.checkNotNullParameter(logic, "logic");
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        this.logic = logic;
        this.mandatory = bool;
        this.disclaimerSettings = disclaimerSettings;
        this.displayLogicOperator = surveyLogicOperator;
        this.displayLogic = displayLogic;
        this.surveyPointImage = surveyPointImage;
        this.followUpQuestionCount = num;
    }

    public final List<SurveyPointTextLogic> getLogic() {
        return this.logic;
    }

    public final Boolean getMandatory() {
        return this.mandatory;
    }

    @Override // com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings
    public DisclaimerSettings getDisclaimerSettings() {
        return this.disclaimerSettings;
    }

    @Override // com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings
    public SurveyLogicOperator getDisplayLogicOperator() {
        return this.displayLogicOperator;
    }

    @Override // com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings
    public List<DisplayLogic> getDisplayLogic() {
        return this.displayLogic;
    }

    @Override // com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings
    public SurveyPointImage getSurveyPointImage() {
        return this.surveyPointImage;
    }

    public final Integer getFollowUpQuestionCount() {
        return this.followUpQuestionCount;
    }

    @Override // com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings
    /* JADX INFO: renamed from: isMandatory */
    public boolean getIsMandatory() {
        return Intrinsics.areEqual((Object) this.mandatory, (Object) true);
    }

    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    public SurveyQuestionPointSettings translatedWith(SurveyPointSettingsTranslation translation) {
        DisclaimerSettings disclaimerSettingsTranslatedWith;
        DisclaimerSettings disclaimerSettings = getDisclaimerSettings();
        SurveyPointImage surveyPointImageTranslatedWith = null;
        if (disclaimerSettings != null) {
            disclaimerSettingsTranslatedWith = disclaimerSettings.translatedWith(translation != null ? translation.getDisclaimerSettings() : null);
        } else {
            disclaimerSettingsTranslatedWith = null;
        }
        SurveyPointImage surveyPointImage = getSurveyPointImage();
        if (surveyPointImage != null) {
            surveyPointImageTranslatedWith = surveyPointImage.translatedWith(translation != null ? translation.getSurveyPointImage() : null);
        }
        return copy$default(this, null, null, disclaimerSettingsTranslatedWith, null, null, surveyPointImageTranslatedWith, null, 91, null);
    }
}

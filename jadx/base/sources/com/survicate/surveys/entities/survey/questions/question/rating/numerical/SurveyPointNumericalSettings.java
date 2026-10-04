package com.survicate.surveys.entities.survey.questions.question.rating.numerical;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings$$serializer;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage$$serializer;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.questions.question.rating.SurveyPointRatingSettings;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.range.SurveyPointRangeLogic;
import com.survicate.surveys.entities.survey.surveyLogic.range.SurveyPointRangeLogic$$serializer;
import com.survicate.surveys.entities.survey.translations.SurveyPointSettingsTranslation;
import com.survicate.surveys.infrastructure.serialization.DisplayLogicSerializer;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import com.survicate.surveys.utils.extensions.StringExtensionsKt;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: SurveyPointNumericalSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@SerialName(QuestionSurveyAnswerType.NUMERICAL)
@Metadata(m1598d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 [2\u00020\u0001:\u0002Z[Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015B\u008b\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0014\u0010\u001aJ\u0012\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010B\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0090\u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010GJ\u0006\u0010H\u001a\u00020\u0017J\u0013\u0010I\u001a\u00020\t2\b\u0010J\u001a\u0004\u0018\u00010KHÖ\u0003J\t\u0010L\u001a\u00020\u0017HÖ\u0001J\t\u0010M\u001a\u00020\u0003HÖ\u0001J\u0016\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0017J%\u0010S\u001a\u00020O2\u0006\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0001¢\u0006\u0002\bYR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010&R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001eR \u0010\u000b\u001a\u0004\u0018\u00010\t8\u0016X\u0097\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b*\u0010\u001c\u001a\u0004\b\u000b\u0010&R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010-R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001c\u001a\u0004\b/\u00100R\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010#R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u001c\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006\\"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/rating/numerical/SurveyPointNumericalSettings;", "Lcom/survicate/surveys/entities/survey/questions/question/rating/SurveyPointRatingSettings;", "leftText", "", "rightText", "logic", "", "Lcom/survicate/surveys/entities/survey/surveyLogic/range/SurveyPointRangeLogic;", "mandatory", "", "commentLabel", "isCommentMandatory", "disclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "displayLogicOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "displayLogic", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/DisplayLogic;", "surveyPointImage", "Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLeftText$annotations", "()V", "getLeftText", "()Ljava/lang/String;", "getRightText$annotations", "getRightText", "getLogic$annotations", "getLogic", "()Ljava/util/List;", "getMandatory$annotations", "getMandatory", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCommentLabel$annotations", "getCommentLabel", "isCommentMandatory$annotations", "getDisclaimerSettings$annotations", "getDisclaimerSettings", "()Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "getDisplayLogicOperator$annotations", "getDisplayLogicOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getDisplayLogic$annotations", "getDisplayLogic", "getSurveyPointImage$annotations", "getSurveyPointImage", "()Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "isMandatory", "()Z", "translatedWith", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionPointSettings;", "translation", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointSettingsTranslation;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;)Lcom/survicate/surveys/entities/survey/questions/question/rating/numerical/SurveyPointNumericalSettings;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveyPointNumericalSettings implements SurveyPointRatingSettings {
    private final String commentLabel;
    private final DisclaimerSettings disclaimerSettings;
    private final List<DisplayLogic> displayLogic;
    private final SurveyLogicOperator displayLogicOperator;
    private final Boolean isCommentMandatory;
    private final String leftText;
    private final List<SurveyPointRangeLogic> logic;
    private final Boolean mandatory;
    private final String rightText;
    private final SurveyPointImage surveyPointImage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyPointNumericalSettings> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.rating.numerical.SurveyPointNumericalSettings$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointNumericalSettings._childSerializers$_anonymous_();
        }
    }), null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.rating.numerical.SurveyPointNumericalSettings$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointNumericalSettings._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.rating.numerical.SurveyPointNumericalSettings$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointNumericalSettings._childSerializers$_anonymous_$1();
        }
    }), null};

    /* JADX INFO: compiled from: SurveyPointNumericalSettings.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyPointNumericalSettings> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointNumericalSettings createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(SurveyPointRangeLogic.CREATOR.createFromParcel(parcel));
                }
            }
            ArrayList arrayList2 = arrayList;
            Boolean boolValueOf2 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String string3 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            DisclaimerSettings disclaimerSettingsCreateFromParcel = parcel.readInt() == 0 ? null : DisclaimerSettings.CREATOR.createFromParcel(parcel);
            SurveyLogicOperator surveyLogicOperatorValueOf = parcel.readInt() == 0 ? null : SurveyLogicOperator.valueOf(parcel.readString());
            int i3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList3.add(parcel.readParcelable(SurveyPointNumericalSettings.class.getClassLoader()));
            }
            return new SurveyPointNumericalSettings(string, string2, arrayList2, boolValueOf2, string3, boolValueOf, disclaimerSettingsCreateFromParcel, surveyLogicOperatorValueOf, arrayList3, parcel.readInt() != 0 ? SurveyPointImage.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointNumericalSettings[] newArray(int i) {
            return new SurveyPointNumericalSettings[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(SurveyPointRangeLogic$$serializer.INSTANCE);
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
    public static /* synthetic */ SurveyPointNumericalSettings copy$default(SurveyPointNumericalSettings surveyPointNumericalSettings, String str, String str2, List list, Boolean bool, String str3, Boolean bool2, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List list2, SurveyPointImage surveyPointImage, int i, Object obj) {
        if ((i & 1) != 0) {
            str = surveyPointNumericalSettings.leftText;
        }
        if ((i & 2) != 0) {
            str2 = surveyPointNumericalSettings.rightText;
        }
        if ((i & 4) != 0) {
            list = surveyPointNumericalSettings.logic;
        }
        if ((i & 8) != 0) {
            bool = surveyPointNumericalSettings.mandatory;
        }
        if ((i & 16) != 0) {
            str3 = surveyPointNumericalSettings.commentLabel;
        }
        if ((i & 32) != 0) {
            bool2 = surveyPointNumericalSettings.isCommentMandatory;
        }
        if ((i & 64) != 0) {
            disclaimerSettings = surveyPointNumericalSettings.disclaimerSettings;
        }
        if ((i & 128) != 0) {
            surveyLogicOperator = surveyPointNumericalSettings.displayLogicOperator;
        }
        if ((i & 256) != 0) {
            list2 = surveyPointNumericalSettings.displayLogic;
        }
        if ((i & 512) != 0) {
            surveyPointImage = surveyPointNumericalSettings.surveyPointImage;
        }
        List list3 = list2;
        SurveyPointImage surveyPointImage2 = surveyPointImage;
        DisclaimerSettings disclaimerSettings2 = disclaimerSettings;
        SurveyLogicOperator surveyLogicOperator2 = surveyLogicOperator;
        String str4 = str3;
        Boolean bool3 = bool2;
        return surveyPointNumericalSettings.copy(str, str2, list, bool, str4, bool3, disclaimerSettings2, surveyLogicOperator2, list3, surveyPointImage2);
    }

    @SerialName("comment_label")
    public static /* synthetic */ void getCommentLabel$annotations() {
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

    @SerialName("text_on_the_left")
    public static /* synthetic */ void getLeftText$annotations() {
    }

    @SerialName("logic")
    public static /* synthetic */ void getLogic$annotations() {
    }

    @SerialName("mandatory")
    public static /* synthetic */ void getMandatory$annotations() {
    }

    @SerialName("text_on_the_right")
    public static /* synthetic */ void getRightText$annotations() {
    }

    @SerialName("point_image")
    public static /* synthetic */ void getSurveyPointImage$annotations() {
    }

    @SerialName("mandatory_comment")
    public static /* synthetic */ void isCommentMandatory$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLeftText() {
        return this.leftText;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final SurveyPointImage getSurveyPointImage() {
        return this.surveyPointImage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRightText() {
        return this.rightText;
    }

    public final List<SurveyPointRangeLogic> component3() {
        return this.logic;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getMandatory() {
        return this.mandatory;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCommentLabel() {
        return this.commentLabel;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getIsCommentMandatory() {
        return this.isCommentMandatory;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final DisclaimerSettings getDisclaimerSettings() {
        return this.disclaimerSettings;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final SurveyLogicOperator getDisplayLogicOperator() {
        return this.displayLogicOperator;
    }

    public final List<DisplayLogic> component9() {
        return this.displayLogic;
    }

    public final SurveyPointNumericalSettings copy(String leftText, String rightText, List<SurveyPointRangeLogic> logic, Boolean mandatory, String commentLabel, Boolean isCommentMandatory, DisclaimerSettings disclaimerSettings, SurveyLogicOperator displayLogicOperator, List<? extends DisplayLogic> displayLogic, SurveyPointImage surveyPointImage) {
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        return new SurveyPointNumericalSettings(leftText, rightText, logic, mandatory, commentLabel, isCommentMandatory, disclaimerSettings, displayLogicOperator, displayLogic, surveyPointImage);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyPointNumericalSettings)) {
            return false;
        }
        SurveyPointNumericalSettings surveyPointNumericalSettings = (SurveyPointNumericalSettings) other;
        return Intrinsics.areEqual(this.leftText, surveyPointNumericalSettings.leftText) && Intrinsics.areEqual(this.rightText, surveyPointNumericalSettings.rightText) && Intrinsics.areEqual(this.logic, surveyPointNumericalSettings.logic) && Intrinsics.areEqual(this.mandatory, surveyPointNumericalSettings.mandatory) && Intrinsics.areEqual(this.commentLabel, surveyPointNumericalSettings.commentLabel) && Intrinsics.areEqual(this.isCommentMandatory, surveyPointNumericalSettings.isCommentMandatory) && Intrinsics.areEqual(this.disclaimerSettings, surveyPointNumericalSettings.disclaimerSettings) && this.displayLogicOperator == surveyPointNumericalSettings.displayLogicOperator && Intrinsics.areEqual(this.displayLogic, surveyPointNumericalSettings.displayLogic) && Intrinsics.areEqual(this.surveyPointImage, surveyPointNumericalSettings.surveyPointImage);
    }

    public int hashCode() {
        String str = this.leftText;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.rightText;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<SurveyPointRangeLogic> list = this.logic;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.mandatory;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.commentLabel;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool2 = this.isCommentMandatory;
        int iHashCode6 = (iHashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        DisclaimerSettings disclaimerSettings = this.disclaimerSettings;
        int iHashCode7 = (iHashCode6 + (disclaimerSettings == null ? 0 : disclaimerSettings.hashCode())) * 31;
        SurveyLogicOperator surveyLogicOperator = this.displayLogicOperator;
        int iHashCode8 = (((iHashCode7 + (surveyLogicOperator == null ? 0 : surveyLogicOperator.hashCode())) * 31) + this.displayLogic.hashCode()) * 31;
        SurveyPointImage surveyPointImage = this.surveyPointImage;
        return iHashCode8 + (surveyPointImage != null ? surveyPointImage.hashCode() : 0);
    }

    public String toString() {
        return "SurveyPointNumericalSettings(leftText=" + this.leftText + ", rightText=" + this.rightText + ", logic=" + this.logic + ", mandatory=" + this.mandatory + ", commentLabel=" + this.commentLabel + ", isCommentMandatory=" + this.isCommentMandatory + ", disclaimerSettings=" + this.disclaimerSettings + ", displayLogicOperator=" + this.displayLogicOperator + ", displayLogic=" + this.displayLogic + ", surveyPointImage=" + this.surveyPointImage + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.leftText);
        dest.writeString(this.rightText);
        List<SurveyPointRangeLogic> list = this.logic;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<SurveyPointRangeLogic> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        Boolean bool = this.mandatory;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.commentLabel);
        Boolean bool2 = this.isCommentMandatory;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
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
    }

    /* JADX INFO: compiled from: SurveyPointNumericalSettings.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/rating/numerical/SurveyPointNumericalSettings$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/questions/question/rating/numerical/SurveyPointNumericalSettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyPointNumericalSettings> serializer() {
            return SurveyPointNumericalSettings$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyPointNumericalSettings(int i, String str, String str2, List list, Boolean bool, String str3, Boolean bool2, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List list2, SurveyPointImage surveyPointImage, SerializationConstructorMarker serializationConstructorMarker) {
        if (1023 != (i & 1023)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1023, SurveyPointNumericalSettings$$serializer.INSTANCE.getDescriptor());
        }
        this.leftText = str;
        this.rightText = str2;
        this.logic = list;
        this.mandatory = bool;
        this.commentLabel = str3;
        this.isCommentMandatory = bool2;
        this.disclaimerSettings = disclaimerSettings;
        this.displayLogicOperator = surveyLogicOperator;
        this.displayLogic = list2;
        this.surveyPointImage = surveyPointImage;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyPointNumericalSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.leftText);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.rightText);
        output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.logic);
        output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.mandatory);
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.commentLabel);
        output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.isCommentMandatory());
        output.encodeNullableSerializableElement(serialDesc, 6, DisclaimerSettings$$serializer.INSTANCE, self.getDisclaimerSettings());
        output.encodeNullableSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.getDisplayLogicOperator());
        output.encodeSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.getDisplayLogic());
        output.encodeNullableSerializableElement(serialDesc, 9, SurveyPointImage$$serializer.INSTANCE, self.getSurveyPointImage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SurveyPointNumericalSettings(String str, String str2, List<SurveyPointRangeLogic> list, Boolean bool, String str3, Boolean bool2, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List<? extends DisplayLogic> displayLogic, SurveyPointImage surveyPointImage) {
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        this.leftText = str;
        this.rightText = str2;
        this.logic = list;
        this.mandatory = bool;
        this.commentLabel = str3;
        this.isCommentMandatory = bool2;
        this.disclaimerSettings = disclaimerSettings;
        this.displayLogicOperator = surveyLogicOperator;
        this.displayLogic = displayLogic;
        this.surveyPointImage = surveyPointImage;
    }

    public final String getLeftText() {
        return this.leftText;
    }

    public final String getRightText() {
        return this.rightText;
    }

    public final List<SurveyPointRangeLogic> getLogic() {
        return this.logic;
    }

    public final Boolean getMandatory() {
        return this.mandatory;
    }

    public final String getCommentLabel() {
        return this.commentLabel;
    }

    @Override // com.survicate.surveys.entities.survey.questions.question.rating.SurveyPointRatingSettings
    public Boolean isCommentMandatory() {
        return this.isCommentMandatory;
    }

    @Override // com.survicate.surveys.entities.survey.questions.question.rating.SurveyPointRatingSettings, com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings
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

    @Override // com.survicate.surveys.entities.survey.questions.question.rating.SurveyPointRatingSettings, com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings
    /* JADX INFO: renamed from: isMandatory */
    public boolean getIsMandatory() {
        return Intrinsics.areEqual((Object) this.mandatory, (Object) true);
    }

    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    public SurveyQuestionPointSettings translatedWith(SurveyPointSettingsTranslation translation) {
        DisclaimerSettings disclaimerSettingsTranslatedWith;
        SurveyPointImage surveyPointImageTranslatedWith = null;
        String strIfNullOrBlankNullable = StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getLeftText() : null, this.leftText);
        String strIfNullOrBlankNullable2 = StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getRightText() : null, this.rightText);
        String strIfNullOrBlankNullable3 = StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getCommentLabel() : null, this.commentLabel);
        DisclaimerSettings disclaimerSettings = getDisclaimerSettings();
        if (disclaimerSettings != null) {
            disclaimerSettingsTranslatedWith = disclaimerSettings.translatedWith(translation != null ? translation.getDisclaimerSettings() : null);
        } else {
            disclaimerSettingsTranslatedWith = null;
        }
        SurveyPointImage surveyPointImage = getSurveyPointImage();
        if (surveyPointImage != null) {
            surveyPointImageTranslatedWith = surveyPointImage.translatedWith(translation != null ? translation.getSurveyPointImage() : null);
        }
        return copy$default(this, strIfNullOrBlankNullable, strIfNullOrBlankNullable2, null, null, strIfNullOrBlankNullable3, null, disclaimerSettingsTranslatedWith, null, null, surveyPointImageTranslatedWith, 428, null);
    }
}

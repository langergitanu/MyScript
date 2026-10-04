package com.survicate.surveys.entities.survey.questions.question.multiple;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings$$serializer;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage$$serializer;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.multiple.SurveyPointMultipleLogic;
import com.survicate.surveys.entities.survey.surveyLogic.multiple.SurveyPointMultipleLogic$$serializer;
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

/* JADX INFO: compiled from: SurveyPointMultipleSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@SerialName(QuestionSurveyAnswerType.MULTIPLE)
@Metadata(m1598d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Z2\u00020\u0001:\u0002YZBu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015B\u008b\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0014\u0010\u001aJ\u0012\u00108\u001a\u00020\u00012\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010?\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010A\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0090\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010FJ\u0006\u0010G\u001a\u00020\u0017J\u0013\u0010H\u001a\u00020\u00032\b\u0010I\u001a\u0004\u0018\u00010JHÖ\u0003J\t\u0010K\u001a\u00020\u0017HÖ\u0001J\t\u0010L\u001a\u00020\nHÖ\u0001J\u0016\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0017J%\u0010R\u001a\u00020N2\u0006\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0001¢\u0006\u0002\bXR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001f\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001f\u0012\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010$R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001f\u0012\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001eR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010)R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001f\u0012\u0004\b*\u0010\u001c\u001a\u0004\b\u000b\u0010\u001eR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010-R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001c\u001a\u0004\b/\u00100R\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010$R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u001c\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006["}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/multiple/SurveyPointMultipleSettings;", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionPointSettings;", "randomizeAnswers", "", "randomizeExceptLast", "logic", "", "Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyPointMultipleLogic;", "mandatory", "commentLabel", "", "isCommentMandatory", "disclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "displayLogicOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "displayLogic", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/DisplayLogic;", "surveyPointImage", "Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRandomizeAnswers$annotations", "()V", "getRandomizeAnswers", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRandomizeExceptLast$annotations", "getRandomizeExceptLast", "getLogic$annotations", "getLogic", "()Ljava/util/List;", "getMandatory$annotations", "getMandatory", "getCommentLabel$annotations", "getCommentLabel", "()Ljava/lang/String;", "isCommentMandatory$annotations", "getDisclaimerSettings$annotations", "getDisclaimerSettings", "()Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "getDisplayLogicOperator$annotations", "getDisplayLogicOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getDisplayLogic$annotations", "getDisplayLogic", "getSurveyPointImage$annotations", "getSurveyPointImage", "()Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "isMandatory", "()Z", "translatedWith", "translation", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointSettingsTranslation;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;)Lcom/survicate/surveys/entities/survey/questions/question/multiple/SurveyPointMultipleSettings;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveyPointMultipleSettings implements SurveyQuestionPointSettings {
    private final String commentLabel;
    private final DisclaimerSettings disclaimerSettings;
    private final List<DisplayLogic> displayLogic;
    private final SurveyLogicOperator displayLogicOperator;
    private final Boolean isCommentMandatory;
    private final List<SurveyPointMultipleLogic> logic;
    private final Boolean mandatory;
    private final Boolean randomizeAnswers;
    private final Boolean randomizeExceptLast;
    private final SurveyPointImage surveyPointImage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyPointMultipleSettings> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.multiple.SurveyPointMultipleSettings$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointMultipleSettings._childSerializers$_anonymous_();
        }
    }), null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.multiple.SurveyPointMultipleSettings$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointMultipleSettings._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.multiple.SurveyPointMultipleSettings$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointMultipleSettings._childSerializers$_anonymous_$1();
        }
    }), null};

    /* JADX INFO: compiled from: SurveyPointMultipleSettings.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyPointMultipleSettings> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointMultipleSettings createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean boolValueOf2 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(SurveyPointMultipleLogic.CREATOR.createFromParcel(parcel));
                }
            }
            ArrayList arrayList2 = arrayList;
            Boolean boolValueOf3 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String string = parcel.readString();
            Boolean boolValueOf4 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            DisclaimerSettings disclaimerSettingsCreateFromParcel = parcel.readInt() == 0 ? null : DisclaimerSettings.CREATOR.createFromParcel(parcel);
            SurveyLogicOperator surveyLogicOperatorValueOf = parcel.readInt() == 0 ? null : SurveyLogicOperator.valueOf(parcel.readString());
            int i3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList3.add(parcel.readParcelable(SurveyPointMultipleSettings.class.getClassLoader()));
            }
            return new SurveyPointMultipleSettings(boolValueOf, boolValueOf2, arrayList2, boolValueOf3, string, boolValueOf4, disclaimerSettingsCreateFromParcel, surveyLogicOperatorValueOf, arrayList3, parcel.readInt() != 0 ? SurveyPointImage.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointMultipleSettings[] newArray(int i) {
            return new SurveyPointMultipleSettings[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(SurveyPointMultipleLogic$$serializer.INSTANCE);
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
    public static /* synthetic */ SurveyPointMultipleSettings copy$default(SurveyPointMultipleSettings surveyPointMultipleSettings, Boolean bool, Boolean bool2, List list, Boolean bool3, String str, Boolean bool4, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List list2, SurveyPointImage surveyPointImage, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = surveyPointMultipleSettings.randomizeAnswers;
        }
        if ((i & 2) != 0) {
            bool2 = surveyPointMultipleSettings.randomizeExceptLast;
        }
        if ((i & 4) != 0) {
            list = surveyPointMultipleSettings.logic;
        }
        if ((i & 8) != 0) {
            bool3 = surveyPointMultipleSettings.mandatory;
        }
        if ((i & 16) != 0) {
            str = surveyPointMultipleSettings.commentLabel;
        }
        if ((i & 32) != 0) {
            bool4 = surveyPointMultipleSettings.isCommentMandatory;
        }
        if ((i & 64) != 0) {
            disclaimerSettings = surveyPointMultipleSettings.disclaimerSettings;
        }
        if ((i & 128) != 0) {
            surveyLogicOperator = surveyPointMultipleSettings.displayLogicOperator;
        }
        if ((i & 256) != 0) {
            list2 = surveyPointMultipleSettings.displayLogic;
        }
        if ((i & 512) != 0) {
            surveyPointImage = surveyPointMultipleSettings.surveyPointImage;
        }
        List list3 = list2;
        SurveyPointImage surveyPointImage2 = surveyPointImage;
        DisclaimerSettings disclaimerSettings2 = disclaimerSettings;
        SurveyLogicOperator surveyLogicOperator2 = surveyLogicOperator;
        String str2 = str;
        Boolean bool5 = bool4;
        return surveyPointMultipleSettings.copy(bool, bool2, list, bool3, str2, bool5, disclaimerSettings2, surveyLogicOperator2, list3, surveyPointImage2);
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

    @SerialName("logic")
    public static /* synthetic */ void getLogic$annotations() {
    }

    @SerialName("mandatory")
    public static /* synthetic */ void getMandatory$annotations() {
    }

    @SerialName("randomize_answers")
    public static /* synthetic */ void getRandomizeAnswers$annotations() {
    }

    @SerialName("randomize_except_last")
    public static /* synthetic */ void getRandomizeExceptLast$annotations() {
    }

    @SerialName("point_image")
    public static /* synthetic */ void getSurveyPointImage$annotations() {
    }

    @SerialName("mandatory_comment")
    public static /* synthetic */ void isCommentMandatory$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getRandomizeAnswers() {
        return this.randomizeAnswers;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final SurveyPointImage getSurveyPointImage() {
        return this.surveyPointImage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getRandomizeExceptLast() {
        return this.randomizeExceptLast;
    }

    public final List<SurveyPointMultipleLogic> component3() {
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

    public final SurveyPointMultipleSettings copy(Boolean randomizeAnswers, Boolean randomizeExceptLast, List<SurveyPointMultipleLogic> logic, Boolean mandatory, String commentLabel, Boolean isCommentMandatory, DisclaimerSettings disclaimerSettings, SurveyLogicOperator displayLogicOperator, List<? extends DisplayLogic> displayLogic, SurveyPointImage surveyPointImage) {
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        return new SurveyPointMultipleSettings(randomizeAnswers, randomizeExceptLast, logic, mandatory, commentLabel, isCommentMandatory, disclaimerSettings, displayLogicOperator, displayLogic, surveyPointImage);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyPointMultipleSettings)) {
            return false;
        }
        SurveyPointMultipleSettings surveyPointMultipleSettings = (SurveyPointMultipleSettings) other;
        return Intrinsics.areEqual(this.randomizeAnswers, surveyPointMultipleSettings.randomizeAnswers) && Intrinsics.areEqual(this.randomizeExceptLast, surveyPointMultipleSettings.randomizeExceptLast) && Intrinsics.areEqual(this.logic, surveyPointMultipleSettings.logic) && Intrinsics.areEqual(this.mandatory, surveyPointMultipleSettings.mandatory) && Intrinsics.areEqual(this.commentLabel, surveyPointMultipleSettings.commentLabel) && Intrinsics.areEqual(this.isCommentMandatory, surveyPointMultipleSettings.isCommentMandatory) && Intrinsics.areEqual(this.disclaimerSettings, surveyPointMultipleSettings.disclaimerSettings) && this.displayLogicOperator == surveyPointMultipleSettings.displayLogicOperator && Intrinsics.areEqual(this.displayLogic, surveyPointMultipleSettings.displayLogic) && Intrinsics.areEqual(this.surveyPointImage, surveyPointMultipleSettings.surveyPointImage);
    }

    public int hashCode() {
        Boolean bool = this.randomizeAnswers;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.randomizeExceptLast;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        List<SurveyPointMultipleLogic> list = this.logic;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool3 = this.mandatory;
        int iHashCode4 = (iHashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str = this.commentLabel;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool4 = this.isCommentMandatory;
        int iHashCode6 = (iHashCode5 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        DisclaimerSettings disclaimerSettings = this.disclaimerSettings;
        int iHashCode7 = (iHashCode6 + (disclaimerSettings == null ? 0 : disclaimerSettings.hashCode())) * 31;
        SurveyLogicOperator surveyLogicOperator = this.displayLogicOperator;
        int iHashCode8 = (((iHashCode7 + (surveyLogicOperator == null ? 0 : surveyLogicOperator.hashCode())) * 31) + this.displayLogic.hashCode()) * 31;
        SurveyPointImage surveyPointImage = this.surveyPointImage;
        return iHashCode8 + (surveyPointImage != null ? surveyPointImage.hashCode() : 0);
    }

    public String toString() {
        return "SurveyPointMultipleSettings(randomizeAnswers=" + this.randomizeAnswers + ", randomizeExceptLast=" + this.randomizeExceptLast + ", logic=" + this.logic + ", mandatory=" + this.mandatory + ", commentLabel=" + this.commentLabel + ", isCommentMandatory=" + this.isCommentMandatory + ", disclaimerSettings=" + this.disclaimerSettings + ", displayLogicOperator=" + this.displayLogicOperator + ", displayLogic=" + this.displayLogic + ", surveyPointImage=" + this.surveyPointImage + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Boolean bool = this.randomizeAnswers;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.randomizeExceptLast;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        List<SurveyPointMultipleLogic> list = this.logic;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<SurveyPointMultipleLogic> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        Boolean bool3 = this.mandatory;
        if (bool3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.commentLabel);
        Boolean bool4 = this.isCommentMandatory;
        if (bool4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool4.booleanValue() ? 1 : 0);
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

    /* JADX INFO: compiled from: SurveyPointMultipleSettings.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/multiple/SurveyPointMultipleSettings$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/questions/question/multiple/SurveyPointMultipleSettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyPointMultipleSettings> serializer() {
            return SurveyPointMultipleSettings$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyPointMultipleSettings(int i, Boolean bool, Boolean bool2, List list, Boolean bool3, String str, Boolean bool4, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List list2, SurveyPointImage surveyPointImage, SerializationConstructorMarker serializationConstructorMarker) {
        if (1023 != (i & 1023)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1023, SurveyPointMultipleSettings$$serializer.INSTANCE.getDescriptor());
        }
        this.randomizeAnswers = bool;
        this.randomizeExceptLast = bool2;
        this.logic = list;
        this.mandatory = bool3;
        this.commentLabel = str;
        this.isCommentMandatory = bool4;
        this.disclaimerSettings = disclaimerSettings;
        this.displayLogicOperator = surveyLogicOperator;
        this.displayLogic = list2;
        this.surveyPointImage = surveyPointImage;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyPointMultipleSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.randomizeAnswers);
        output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.randomizeExceptLast);
        output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.logic);
        output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.mandatory);
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.commentLabel);
        output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.isCommentMandatory);
        output.encodeNullableSerializableElement(serialDesc, 6, DisclaimerSettings$$serializer.INSTANCE, self.getDisclaimerSettings());
        output.encodeNullableSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.getDisplayLogicOperator());
        output.encodeSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.getDisplayLogic());
        output.encodeNullableSerializableElement(serialDesc, 9, SurveyPointImage$$serializer.INSTANCE, self.getSurveyPointImage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SurveyPointMultipleSettings(Boolean bool, Boolean bool2, List<SurveyPointMultipleLogic> list, Boolean bool3, String str, Boolean bool4, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List<? extends DisplayLogic> displayLogic, SurveyPointImage surveyPointImage) {
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        this.randomizeAnswers = bool;
        this.randomizeExceptLast = bool2;
        this.logic = list;
        this.mandatory = bool3;
        this.commentLabel = str;
        this.isCommentMandatory = bool4;
        this.disclaimerSettings = disclaimerSettings;
        this.displayLogicOperator = surveyLogicOperator;
        this.displayLogic = displayLogic;
        this.surveyPointImage = surveyPointImage;
    }

    public final Boolean getRandomizeAnswers() {
        return this.randomizeAnswers;
    }

    public final Boolean getRandomizeExceptLast() {
        return this.randomizeExceptLast;
    }

    public final List<SurveyPointMultipleLogic> getLogic() {
        return this.logic;
    }

    public final Boolean getMandatory() {
        return this.mandatory;
    }

    public final String getCommentLabel() {
        return this.commentLabel;
    }

    public final Boolean isCommentMandatory() {
        return this.isCommentMandatory;
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

    @Override // com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings
    /* JADX INFO: renamed from: isMandatory */
    public boolean getIsMandatory() {
        return Intrinsics.areEqual((Object) this.mandatory, (Object) true);
    }

    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    public SurveyQuestionPointSettings translatedWith(SurveyPointSettingsTranslation translation) {
        DisclaimerSettings disclaimerSettingsTranslatedWith;
        SurveyPointImage surveyPointImageTranslatedWith = null;
        String strIfNullOrBlankNullable = StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getCommentLabel() : null, this.commentLabel);
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
        return copy$default(this, null, null, null, null, strIfNullOrBlankNullable, null, disclaimerSettingsTranslatedWith, null, null, surveyPointImageTranslatedWith, 431, null);
    }
}

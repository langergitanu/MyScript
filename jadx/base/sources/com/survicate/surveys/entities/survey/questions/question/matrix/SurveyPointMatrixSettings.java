package com.survicate.surveys.entities.survey.questions.question.matrix;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings$$serializer;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage$$serializer;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyPointMatrixLogic;
import com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyPointMatrixLogic$$serializer;
import com.survicate.surveys.entities.survey.translations.SurveyPointSettingsTranslation;
import com.survicate.surveys.infrastructure.serialization.DisplayLogicSerializer;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import com.survicate.surveys.utils.extensions.StringExtensionsKt;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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

/* JADX INFO: compiled from: SurveyPointMatrixSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \\2\u00020\u0001:\u0002[\\Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017B\u0093\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0016\u0010\u001cJ\u0012\u0010:\u001a\u00020\u00012\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\fHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u008f\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0006\u0010I\u001a\u00020\u0019J\u0013\u0010J\u001a\u00020\u00032\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\t\u0010M\u001a\u00020\u0019HÖ\u0001J\t\u0010N\u001a\u00020\fHÖ\u0001J\u0016\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0019J%\u0010T\u001a\u00020P2\u0006\u0010U\u001a\u00020\u00002\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0001¢\u0006\u0002\bZR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010%R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010 R\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001e\u001a\u0004\b+\u0010,R\u001c\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001e\u001a\u0004\b\r\u0010 R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001e\u001a\u0004\b/\u00100R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u001e\u001a\u0004\b2\u00103R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00068\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u001e\u001a\u0004\b5\u0010%R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001e\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010 ¨\u0006]"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/matrix/SurveyPointMatrixSettings;", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionPointSettings;", "randomizeAnswers", "", "randomizeExceptLast", "scale", "", "Lcom/survicate/surveys/entities/survey/questions/question/matrix/MatrixColumn;", "logic", "Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyPointMatrixLogic;", "mandatory", "commentLabel", "", "isCommentMandatory", "disclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "displayLogicOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "displayLogic", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/DisplayLogic;", "surveyPointImage", "Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "<init>", "(ZZLjava/util/List;Ljava/util/List;ZLjava/lang/String;ZLcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZLjava/util/List;Ljava/util/List;ZLjava/lang/String;ZLcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRandomizeAnswers$annotations", "()V", "getRandomizeAnswers", "()Z", "getRandomizeExceptLast$annotations", "getRandomizeExceptLast", "getScale$annotations", "getScale", "()Ljava/util/List;", "getLogic$annotations", "getLogic", "getMandatory$annotations", "getMandatory", "getCommentLabel$annotations", "getCommentLabel", "()Ljava/lang/String;", "isCommentMandatory$annotations", "getDisclaimerSettings$annotations", "getDisclaimerSettings", "()Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "getDisplayLogicOperator$annotations", "getDisplayLogicOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getDisplayLogic$annotations", "getDisplayLogic", "getSurveyPointImage$annotations", "getSurveyPointImage", "()Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "isMandatory", "translatedWith", "translation", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointSettingsTranslation;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
@SerialName(QuestionSurveyAnswerType.MATRIX)
public final /* data */ class SurveyPointMatrixSettings implements SurveyQuestionPointSettings {
    private final String commentLabel;
    private final DisclaimerSettings disclaimerSettings;
    private final List<DisplayLogic> displayLogic;
    private final SurveyLogicOperator displayLogicOperator;
    private final boolean isCommentMandatory;
    private final List<SurveyPointMatrixLogic> logic;
    private final boolean mandatory;
    private final boolean randomizeAnswers;
    private final boolean randomizeExceptLast;
    private final List<MatrixColumn> scale;
    private final SurveyPointImage surveyPointImage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyPointMatrixSettings> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.matrix.SurveyPointMatrixSettings$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointMatrixSettings._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.matrix.SurveyPointMatrixSettings$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointMatrixSettings._childSerializers$_anonymous_$2();
        }
    }), null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.matrix.SurveyPointMatrixSettings$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointMatrixSettings._childSerializers$_anonymous_$3();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.question.matrix.SurveyPointMatrixSettings$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyPointMatrixSettings._childSerializers$_anonymous_$4();
        }
    }), null};

    /* JADX INFO: compiled from: SurveyPointMatrixSettings.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyPointMatrixSettings> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointMatrixSettings createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(MatrixColumn.CREATOR.createFromParcel(parcel));
            }
            ArrayList arrayList2 = arrayList;
            int i3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList3.add(SurveyPointMatrixLogic.CREATOR.createFromParcel(parcel));
            }
            ArrayList arrayList4 = arrayList3;
            boolean z3 = parcel.readInt() != 0;
            String string = parcel.readString();
            boolean z4 = parcel.readInt() != 0;
            DisclaimerSettings disclaimerSettingsCreateFromParcel = parcel.readInt() == 0 ? null : DisclaimerSettings.CREATOR.createFromParcel(parcel);
            SurveyLogicOperator surveyLogicOperatorValueOf = parcel.readInt() == 0 ? null : SurveyLogicOperator.valueOf(parcel.readString());
            int i5 = parcel.readInt();
            ArrayList arrayList5 = new ArrayList(i5);
            for (int i6 = 0; i6 != i5; i6++) {
                arrayList5.add(parcel.readParcelable(SurveyPointMatrixSettings.class.getClassLoader()));
            }
            return new SurveyPointMatrixSettings(z, z2, arrayList2, arrayList4, z3, string, z4, disclaimerSettingsCreateFromParcel, surveyLogicOperatorValueOf, arrayList5, parcel.readInt() != 0 ? SurveyPointImage.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyPointMatrixSettings[] newArray(int i) {
            return new SurveyPointMatrixSettings[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(MatrixColumn$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(SurveyPointMatrixLogic$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator", SurveyLogicOperator.values(), new String[]{"or", "and"}, new Annotation[][]{null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new ArrayListSerializer(DisplayLogicSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyPointMatrixSettings copy$default(SurveyPointMatrixSettings surveyPointMatrixSettings, boolean z, boolean z2, List list, List list2, boolean z3, String str, boolean z4, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List list3, SurveyPointImage surveyPointImage, int i, Object obj) {
        if ((i & 1) != 0) {
            z = surveyPointMatrixSettings.randomizeAnswers;
        }
        if ((i & 2) != 0) {
            z2 = surveyPointMatrixSettings.randomizeExceptLast;
        }
        if ((i & 4) != 0) {
            list = surveyPointMatrixSettings.scale;
        }
        if ((i & 8) != 0) {
            list2 = surveyPointMatrixSettings.logic;
        }
        if ((i & 16) != 0) {
            z3 = surveyPointMatrixSettings.mandatory;
        }
        if ((i & 32) != 0) {
            str = surveyPointMatrixSettings.commentLabel;
        }
        if ((i & 64) != 0) {
            z4 = surveyPointMatrixSettings.isCommentMandatory;
        }
        if ((i & 128) != 0) {
            disclaimerSettings = surveyPointMatrixSettings.disclaimerSettings;
        }
        if ((i & 256) != 0) {
            surveyLogicOperator = surveyPointMatrixSettings.displayLogicOperator;
        }
        if ((i & 512) != 0) {
            list3 = surveyPointMatrixSettings.displayLogic;
        }
        if ((i & 1024) != 0) {
            surveyPointImage = surveyPointMatrixSettings.surveyPointImage;
        }
        List list4 = list3;
        SurveyPointImage surveyPointImage2 = surveyPointImage;
        DisclaimerSettings disclaimerSettings2 = disclaimerSettings;
        SurveyLogicOperator surveyLogicOperator2 = surveyLogicOperator;
        String str2 = str;
        boolean z5 = z4;
        boolean z6 = z3;
        List list5 = list;
        return surveyPointMatrixSettings.copy(z, z2, list5, list2, z6, str2, z5, disclaimerSettings2, surveyLogicOperator2, list4, surveyPointImage2);
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

    @SerialName("scale")
    public static /* synthetic */ void getScale$annotations() {
    }

    @SerialName("point_image")
    public static /* synthetic */ void getSurveyPointImage$annotations() {
    }

    @SerialName("mandatory_comment")
    public static /* synthetic */ void isCommentMandatory$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getRandomizeAnswers() {
        return this.randomizeAnswers;
    }

    public final List<DisplayLogic> component10() {
        return this.displayLogic;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final SurveyPointImage getSurveyPointImage() {
        return this.surveyPointImage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getRandomizeExceptLast() {
        return this.randomizeExceptLast;
    }

    public final List<MatrixColumn> component3() {
        return this.scale;
    }

    public final List<SurveyPointMatrixLogic> component4() {
        return this.logic;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getMandatory() {
        return this.mandatory;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCommentLabel() {
        return this.commentLabel;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsCommentMandatory() {
        return this.isCommentMandatory;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final DisclaimerSettings getDisclaimerSettings() {
        return this.disclaimerSettings;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final SurveyLogicOperator getDisplayLogicOperator() {
        return this.displayLogicOperator;
    }

    public final SurveyPointMatrixSettings copy(boolean randomizeAnswers, boolean randomizeExceptLast, List<MatrixColumn> scale, List<SurveyPointMatrixLogic> logic, boolean mandatory, String commentLabel, boolean isCommentMandatory, DisclaimerSettings disclaimerSettings, SurveyLogicOperator displayLogicOperator, List<? extends DisplayLogic> displayLogic, SurveyPointImage surveyPointImage) {
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(logic, "logic");
        Intrinsics.checkNotNullParameter(commentLabel, "commentLabel");
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        return new SurveyPointMatrixSettings(randomizeAnswers, randomizeExceptLast, scale, logic, mandatory, commentLabel, isCommentMandatory, disclaimerSettings, displayLogicOperator, displayLogic, surveyPointImage);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyPointMatrixSettings)) {
            return false;
        }
        SurveyPointMatrixSettings surveyPointMatrixSettings = (SurveyPointMatrixSettings) other;
        return this.randomizeAnswers == surveyPointMatrixSettings.randomizeAnswers && this.randomizeExceptLast == surveyPointMatrixSettings.randomizeExceptLast && Intrinsics.areEqual(this.scale, surveyPointMatrixSettings.scale) && Intrinsics.areEqual(this.logic, surveyPointMatrixSettings.logic) && this.mandatory == surveyPointMatrixSettings.mandatory && Intrinsics.areEqual(this.commentLabel, surveyPointMatrixSettings.commentLabel) && this.isCommentMandatory == surveyPointMatrixSettings.isCommentMandatory && Intrinsics.areEqual(this.disclaimerSettings, surveyPointMatrixSettings.disclaimerSettings) && this.displayLogicOperator == surveyPointMatrixSettings.displayLogicOperator && Intrinsics.areEqual(this.displayLogic, surveyPointMatrixSettings.displayLogic) && Intrinsics.areEqual(this.surveyPointImage, surveyPointMatrixSettings.surveyPointImage);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((Boolean.hashCode(this.randomizeAnswers) * 31) + Boolean.hashCode(this.randomizeExceptLast)) * 31) + this.scale.hashCode()) * 31) + this.logic.hashCode()) * 31) + Boolean.hashCode(this.mandatory)) * 31) + this.commentLabel.hashCode()) * 31) + Boolean.hashCode(this.isCommentMandatory)) * 31;
        DisclaimerSettings disclaimerSettings = this.disclaimerSettings;
        int iHashCode2 = (iHashCode + (disclaimerSettings == null ? 0 : disclaimerSettings.hashCode())) * 31;
        SurveyLogicOperator surveyLogicOperator = this.displayLogicOperator;
        int iHashCode3 = (((iHashCode2 + (surveyLogicOperator == null ? 0 : surveyLogicOperator.hashCode())) * 31) + this.displayLogic.hashCode()) * 31;
        SurveyPointImage surveyPointImage = this.surveyPointImage;
        return iHashCode3 + (surveyPointImage != null ? surveyPointImage.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SurveyPointMatrixSettings(randomizeAnswers=");
        sb.append(this.randomizeAnswers).append(", randomizeExceptLast=").append(this.randomizeExceptLast).append(", scale=").append(this.scale).append(", logic=").append(this.logic).append(", mandatory=").append(this.mandatory).append(", commentLabel=").append(this.commentLabel).append(", isCommentMandatory=").append(this.isCommentMandatory).append(", disclaimerSettings=").append(this.disclaimerSettings).append(", displayLogicOperator=").append(this.displayLogicOperator).append(", displayLogic=").append(this.displayLogic).append(", surveyPointImage=").append(this.surveyPointImage).append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.randomizeAnswers ? 1 : 0);
        dest.writeInt(this.randomizeExceptLast ? 1 : 0);
        List<MatrixColumn> list = this.scale;
        dest.writeInt(list.size());
        Iterator<MatrixColumn> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        List<SurveyPointMatrixLogic> list2 = this.logic;
        dest.writeInt(list2.size());
        Iterator<SurveyPointMatrixLogic> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(dest, flags);
        }
        dest.writeInt(this.mandatory ? 1 : 0);
        dest.writeString(this.commentLabel);
        dest.writeInt(this.isCommentMandatory ? 1 : 0);
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
        List<DisplayLogic> list3 = this.displayLogic;
        dest.writeInt(list3.size());
        Iterator<DisplayLogic> it3 = list3.iterator();
        while (it3.hasNext()) {
            dest.writeParcelable(it3.next(), flags);
        }
        SurveyPointImage surveyPointImage = this.surveyPointImage;
        if (surveyPointImage == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            surveyPointImage.writeToParcel(dest, flags);
        }
    }

    /* JADX INFO: compiled from: SurveyPointMatrixSettings.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/matrix/SurveyPointMatrixSettings$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/questions/question/matrix/SurveyPointMatrixSettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyPointMatrixSettings> serializer() {
            return SurveyPointMatrixSettings$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyPointMatrixSettings(int i, boolean z, boolean z2, List list, List list2, boolean z3, String str, boolean z4, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List list3, SurveyPointImage surveyPointImage, SerializationConstructorMarker serializationConstructorMarker) {
        if (2047 != (i & 2047)) {
            PluginExceptionsKt.throwMissingFieldException(i, 2047, SurveyPointMatrixSettings$$serializer.INSTANCE.getDescriptor());
        }
        this.randomizeAnswers = z;
        this.randomizeExceptLast = z2;
        this.scale = list;
        this.logic = list2;
        this.mandatory = z3;
        this.commentLabel = str;
        this.isCommentMandatory = z4;
        this.disclaimerSettings = disclaimerSettings;
        this.displayLogicOperator = surveyLogicOperator;
        this.displayLogic = list3;
        this.surveyPointImage = surveyPointImage;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyPointMatrixSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeBooleanElement(serialDesc, 0, self.randomizeAnswers);
        output.encodeBooleanElement(serialDesc, 1, self.randomizeExceptLast);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.scale);
        output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.logic);
        output.encodeBooleanElement(serialDesc, 4, self.mandatory);
        output.encodeStringElement(serialDesc, 5, self.commentLabel);
        output.encodeBooleanElement(serialDesc, 6, self.isCommentMandatory);
        output.encodeNullableSerializableElement(serialDesc, 7, DisclaimerSettings$$serializer.INSTANCE, self.getDisclaimerSettings());
        output.encodeNullableSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.getDisplayLogicOperator());
        output.encodeSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.getDisplayLogic());
        output.encodeNullableSerializableElement(serialDesc, 10, SurveyPointImage$$serializer.INSTANCE, self.getSurveyPointImage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SurveyPointMatrixSettings(boolean z, boolean z2, List<MatrixColumn> scale, List<SurveyPointMatrixLogic> logic, boolean z3, String commentLabel, boolean z4, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List<? extends DisplayLogic> displayLogic, SurveyPointImage surveyPointImage) {
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(logic, "logic");
        Intrinsics.checkNotNullParameter(commentLabel, "commentLabel");
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        this.randomizeAnswers = z;
        this.randomizeExceptLast = z2;
        this.scale = scale;
        this.logic = logic;
        this.mandatory = z3;
        this.commentLabel = commentLabel;
        this.isCommentMandatory = z4;
        this.disclaimerSettings = disclaimerSettings;
        this.displayLogicOperator = surveyLogicOperator;
        this.displayLogic = displayLogic;
        this.surveyPointImage = surveyPointImage;
    }

    public final boolean getRandomizeAnswers() {
        return this.randomizeAnswers;
    }

    public final boolean getRandomizeExceptLast() {
        return this.randomizeExceptLast;
    }

    public final List<MatrixColumn> getScale() {
        return this.scale;
    }

    public final List<SurveyPointMatrixLogic> getLogic() {
        return this.logic;
    }

    public final boolean getMandatory() {
        return this.mandatory;
    }

    public final String getCommentLabel() {
        return this.commentLabel;
    }

    public final boolean isCommentMandatory() {
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
        return this.mandatory;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SurveyQuestionPointSettings translatedWith(SurveyPointSettingsTranslation translation) {
        SurveyPointImage surveyPointImageTranslatedWith;
        DisclaimerSettings disclaimerSettingsTranslatedWith;
        String name;
        Map<String, String> matrixScale;
        String str;
        List<MatrixColumn> list = this.scale;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (true) {
            surveyPointImageTranslatedWith = null;
            if (!it.hasNext()) {
                break;
            }
            MatrixColumn matrixColumn = (MatrixColumn) it.next();
            if (translation != null && (matrixScale = translation.getMatrixScale()) != null && (str = matrixScale.get(String.valueOf(matrixColumn.getId()))) != null) {
                name = str.length() > 0 ? str : null;
                if (name != null) {
                }
            } else {
                name = matrixColumn.getName();
            }
            arrayList.add(new MatrixColumn(matrixColumn.getId(), name));
        }
        ArrayList arrayList2 = arrayList;
        String strIfNullOrBlank = StringExtensionsKt.ifNullOrBlank(translation != null ? translation.getCommentLabel() : null, this.commentLabel);
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
        return copy$default(this, false, false, arrayList2, null, false, strIfNullOrBlank, false, disclaimerSettingsTranslatedWith, null, null, surveyPointImageTranslatedWith, 859, null);
    }
}

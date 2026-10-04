package com.survicate.surveys.entities.survey.questions.nps;

import android.os.Parcel;
import android.os.Parcelable;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings$$serializer;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage$$serializer;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.range.SurveyPointRangeLogic;
import com.survicate.surveys.entities.survey.surveyLogic.range.SurveyPointRangeLogic$$serializer;
import com.survicate.surveys.entities.survey.translations.SurveyPointSettingsTranslation;
import com.survicate.surveys.entities.survey.translations.Translatable;
import com.survicate.surveys.infrastructure.serialization.DisplayLogicSerializer;
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

/* JADX INFO: compiled from: SurveyNpsPointSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 d2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0002:\u0002cdB\u0085\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aB\u009b\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u0019\u0010\u001fJ\u0012\u0010A\u001a\u00020\u00002\b\u0010B\u001a\u0004\u0018\u00010\u0003H\u0016J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\t\u0010G\u001a\u00020\rHÆ\u0003J\t\u0010H\u001a\u00020\rHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010K\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00160\nHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0018HÆ\u0003J¤\u0001\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010PJ\u0006\u0010Q\u001a\u00020\u001cJ\u0013\u0010R\u001a\u00020\r2\b\u0010S\u001a\u0004\u0018\u00010THÖ\u0003J\t\u0010U\u001a\u00020\u001cHÖ\u0001J\t\u0010V\u001a\u00020\u0005HÖ\u0001J\u0016\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u001cJ%\u0010\\\u001a\u00020X2\u0006\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0001¢\u0006\u0002\bbR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010!\u001a\u0004\b%\u0010#R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010!\u001a\u0004\b'\u0010(R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010!\u001a\u0004\b*\u0010+R\u001c\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010!\u001a\u0004\b-\u0010.R\u001c\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010!\u001a\u0004\b0\u0010.R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010!\u001a\u0004\b2\u0010#R \u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00105\u0012\u0004\b3\u0010!\u001a\u0004\b\u0010\u00104R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010!\u001a\u0004\b7\u00108R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010!\u001a\u0004\b:\u0010;R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010!\u001a\u0004\b=\u0010+R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010!\u001a\u0004\b?\u0010@¨\u0006e"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings;", "Landroid/os/Parcelable;", "Lcom/survicate/surveys/entities/survey/translations/Translatable;", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointSettingsTranslation;", "textOnTheLeft", "", "textOnTheRight", "answersLayout", "Lcom/survicate/surveys/entities/survey/questions/nps/AnswerLayout;", "logic", "", "Lcom/survicate/surveys/entities/survey/surveyLogic/range/SurveyPointRangeLogic;", "mandatory", "", "addComment", "commentLabel", "isCommentMandatory", "disclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "displayLogicOperator", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "displayLogic", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/DisplayLogic;", "surveyPointImage", "Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/survicate/surveys/entities/survey/questions/nps/AnswerLayout;Ljava/util/List;ZZLjava/lang/String;Ljava/lang/Boolean;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/survicate/surveys/entities/survey/questions/nps/AnswerLayout;Ljava/util/List;ZZLjava/lang/String;Ljava/lang/Boolean;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTextOnTheLeft$annotations", "()V", "getTextOnTheLeft", "()Ljava/lang/String;", "getTextOnTheRight$annotations", "getTextOnTheRight", "getAnswersLayout$annotations", "getAnswersLayout", "()Lcom/survicate/surveys/entities/survey/questions/nps/AnswerLayout;", "getLogic$annotations", "getLogic", "()Ljava/util/List;", "getMandatory$annotations", "getMandatory", "()Z", "getAddComment$annotations", "getAddComment", "getCommentLabel$annotations", "getCommentLabel", "isCommentMandatory$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisclaimerSettings$annotations", "getDisclaimerSettings", "()Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "getDisplayLogicOperator$annotations", "getDisplayLogicOperator", "()Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "getDisplayLogic$annotations", "getDisplayLogic", "getSurveyPointImage$annotations", "getSurveyPointImage", "()Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "translatedWith", "translation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/survicate/surveys/entities/survey/questions/nps/AnswerLayout;Ljava/util/List;ZZLjava/lang/String;Ljava/lang/Boolean;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;Ljava/util/List;Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;)Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class SurveyNpsPointSettings implements Parcelable, Translatable<SurveyPointSettingsTranslation, SurveyNpsPointSettings> {
    private final boolean addComment;
    private final AnswerLayout answersLayout;
    private final String commentLabel;
    private final DisclaimerSettings disclaimerSettings;
    private final List<DisplayLogic> displayLogic;
    private final SurveyLogicOperator displayLogicOperator;
    private final Boolean isCommentMandatory;
    private final List<SurveyPointRangeLogic> logic;
    private final boolean mandatory;
    private final SurveyPointImage surveyPointImage;
    private final String textOnTheLeft;
    private final String textOnTheRight;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SurveyNpsPointSettings> CREATOR = new Creator();
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.nps.SurveyNpsPointSettings$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyNpsPointSettings._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.nps.SurveyNpsPointSettings$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyNpsPointSettings._childSerializers$_anonymous_$0();
        }
    }), null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.nps.SurveyNpsPointSettings$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyNpsPointSettings._childSerializers$_anonymous_$1();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.questions.nps.SurveyNpsPointSettings$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurveyNpsPointSettings._childSerializers$_anonymous_$2();
        }
    }), null};

    /* JADX INFO: compiled from: SurveyNpsPointSettings.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyNpsPointSettings> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        public final SurveyNpsPointSettings createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            int i;
            ArrayList arrayList2;
            boolean z;
            boolean z2;
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            AnswerLayout answerLayoutValueOf = parcel.readInt() == 0 ? null : AnswerLayout.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i2 = parcel.readInt();
                arrayList = new ArrayList(i2);
                for (int i3 = 0; i3 != i2; i3++) {
                    arrayList.add(SurveyPointRangeLogic.CREATOR.createFromParcel(parcel));
                }
            }
            ArrayList arrayList3 = arrayList;
            boolean z3 = 1;
            if (parcel.readInt() != 0) {
                i = 0;
                arrayList2 = arrayList3;
                z = true;
            } else {
                i = 0;
                arrayList2 = arrayList3;
                z = false;
            }
            if (parcel.readInt() != 0) {
                z2 = true;
            } else {
                z2 = true;
                z3 = i;
            }
            String string3 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolean z4 = z2;
                if (parcel.readInt() == 0) {
                    z4 = i;
                }
                boolValueOf = Boolean.valueOf(z4);
            }
            DisclaimerSettings disclaimerSettingsCreateFromParcel = parcel.readInt() == 0 ? null : DisclaimerSettings.CREATOR.createFromParcel(parcel);
            SurveyLogicOperator surveyLogicOperatorValueOf = parcel.readInt() == 0 ? null : SurveyLogicOperator.valueOf(parcel.readString());
            int i4 = parcel.readInt();
            ArrayList arrayList4 = new ArrayList(i4);
            while (i != i4) {
                arrayList4.add(parcel.readParcelable(SurveyNpsPointSettings.class.getClassLoader()));
                i++;
            }
            return new SurveyNpsPointSettings(string, string2, answerLayoutValueOf, arrayList2, z, z3, string3, boolValueOf, disclaimerSettingsCreateFromParcel, surveyLogicOperatorValueOf, arrayList4, parcel.readInt() != 0 ? SurveyPointImage.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SurveyNpsPointSettings[] newArray(int i) {
            return new SurveyNpsPointSettings[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.questions.nps.AnswerLayout", AnswerLayout.values(), new String[]{"default", "horizontal"}, new Annotation[][]{null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(SurveyPointRangeLogic$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator", SurveyLogicOperator.values(), new String[]{"or", "and"}, new Annotation[][]{null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(DisplayLogicSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyNpsPointSettings copy$default(SurveyNpsPointSettings surveyNpsPointSettings, String str, String str2, AnswerLayout answerLayout, List list, boolean z, boolean z2, String str3, Boolean bool, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List list2, SurveyPointImage surveyPointImage, int i, Object obj) {
        if ((i & 1) != 0) {
            str = surveyNpsPointSettings.textOnTheLeft;
        }
        if ((i & 2) != 0) {
            str2 = surveyNpsPointSettings.textOnTheRight;
        }
        if ((i & 4) != 0) {
            answerLayout = surveyNpsPointSettings.answersLayout;
        }
        if ((i & 8) != 0) {
            list = surveyNpsPointSettings.logic;
        }
        if ((i & 16) != 0) {
            z = surveyNpsPointSettings.mandatory;
        }
        if ((i & 32) != 0) {
            z2 = surveyNpsPointSettings.addComment;
        }
        if ((i & 64) != 0) {
            str3 = surveyNpsPointSettings.commentLabel;
        }
        if ((i & 128) != 0) {
            bool = surveyNpsPointSettings.isCommentMandatory;
        }
        if ((i & 256) != 0) {
            disclaimerSettings = surveyNpsPointSettings.disclaimerSettings;
        }
        if ((i & 512) != 0) {
            surveyLogicOperator = surveyNpsPointSettings.displayLogicOperator;
        }
        if ((i & 1024) != 0) {
            list2 = surveyNpsPointSettings.displayLogic;
        }
        if ((i & 2048) != 0) {
            surveyPointImage = surveyNpsPointSettings.surveyPointImage;
        }
        List list3 = list2;
        SurveyPointImage surveyPointImage2 = surveyPointImage;
        DisclaimerSettings disclaimerSettings2 = disclaimerSettings;
        SurveyLogicOperator surveyLogicOperator2 = surveyLogicOperator;
        String str4 = str3;
        Boolean bool2 = bool;
        boolean z3 = z;
        boolean z4 = z2;
        return surveyNpsPointSettings.copy(str, str2, answerLayout, list, z3, z4, str4, bool2, disclaimerSettings2, surveyLogicOperator2, list3, surveyPointImage2);
    }

    @SerialName("add_comment")
    public static /* synthetic */ void getAddComment$annotations() {
    }

    @SerialName("answers_layout")
    public static /* synthetic */ void getAnswersLayout$annotations() {
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

    @SerialName("point_image")
    public static /* synthetic */ void getSurveyPointImage$annotations() {
    }

    @SerialName("text_on_the_left")
    public static /* synthetic */ void getTextOnTheLeft$annotations() {
    }

    @SerialName("text_on_the_right")
    public static /* synthetic */ void getTextOnTheRight$annotations() {
    }

    @SerialName("mandatory_comment")
    public static /* synthetic */ void isCommentMandatory$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTextOnTheLeft() {
        return this.textOnTheLeft;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final SurveyLogicOperator getDisplayLogicOperator() {
        return this.displayLogicOperator;
    }

    public final List<DisplayLogic> component11() {
        return this.displayLogic;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final SurveyPointImage getSurveyPointImage() {
        return this.surveyPointImage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTextOnTheRight() {
        return this.textOnTheRight;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AnswerLayout getAnswersLayout() {
        return this.answersLayout;
    }

    public final List<SurveyPointRangeLogic> component4() {
        return this.logic;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getMandatory() {
        return this.mandatory;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getAddComment() {
        return this.addComment;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCommentLabel() {
        return this.commentLabel;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getIsCommentMandatory() {
        return this.isCommentMandatory;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final DisclaimerSettings getDisclaimerSettings() {
        return this.disclaimerSettings;
    }

    public final SurveyNpsPointSettings copy(String textOnTheLeft, String textOnTheRight, AnswerLayout answersLayout, List<SurveyPointRangeLogic> logic, boolean mandatory, boolean addComment, String commentLabel, Boolean isCommentMandatory, DisclaimerSettings disclaimerSettings, SurveyLogicOperator displayLogicOperator, List<? extends DisplayLogic> displayLogic, SurveyPointImage surveyPointImage) {
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        return new SurveyNpsPointSettings(textOnTheLeft, textOnTheRight, answersLayout, logic, mandatory, addComment, commentLabel, isCommentMandatory, disclaimerSettings, displayLogicOperator, displayLogic, surveyPointImage);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyNpsPointSettings)) {
            return false;
        }
        SurveyNpsPointSettings surveyNpsPointSettings = (SurveyNpsPointSettings) other;
        return Intrinsics.areEqual(this.textOnTheLeft, surveyNpsPointSettings.textOnTheLeft) && Intrinsics.areEqual(this.textOnTheRight, surveyNpsPointSettings.textOnTheRight) && this.answersLayout == surveyNpsPointSettings.answersLayout && Intrinsics.areEqual(this.logic, surveyNpsPointSettings.logic) && this.mandatory == surveyNpsPointSettings.mandatory && this.addComment == surveyNpsPointSettings.addComment && Intrinsics.areEqual(this.commentLabel, surveyNpsPointSettings.commentLabel) && Intrinsics.areEqual(this.isCommentMandatory, surveyNpsPointSettings.isCommentMandatory) && Intrinsics.areEqual(this.disclaimerSettings, surveyNpsPointSettings.disclaimerSettings) && this.displayLogicOperator == surveyNpsPointSettings.displayLogicOperator && Intrinsics.areEqual(this.displayLogic, surveyNpsPointSettings.displayLogic) && Intrinsics.areEqual(this.surveyPointImage, surveyNpsPointSettings.surveyPointImage);
    }

    public int hashCode() {
        String str = this.textOnTheLeft;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.textOnTheRight;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        AnswerLayout answerLayout = this.answersLayout;
        int iHashCode3 = (iHashCode2 + (answerLayout == null ? 0 : answerLayout.hashCode())) * 31;
        List<SurveyPointRangeLogic> list = this.logic;
        int iHashCode4 = (((((iHashCode3 + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.mandatory)) * 31) + Boolean.hashCode(this.addComment)) * 31;
        String str3 = this.commentLabel;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.isCommentMandatory;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        DisclaimerSettings disclaimerSettings = this.disclaimerSettings;
        int iHashCode7 = (iHashCode6 + (disclaimerSettings == null ? 0 : disclaimerSettings.hashCode())) * 31;
        SurveyLogicOperator surveyLogicOperator = this.displayLogicOperator;
        int iHashCode8 = (((iHashCode7 + (surveyLogicOperator == null ? 0 : surveyLogicOperator.hashCode())) * 31) + this.displayLogic.hashCode()) * 31;
        SurveyPointImage surveyPointImage = this.surveyPointImage;
        return iHashCode8 + (surveyPointImage != null ? surveyPointImage.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SurveyNpsPointSettings(textOnTheLeft=");
        sb.append(this.textOnTheLeft).append(", textOnTheRight=").append(this.textOnTheRight).append(", answersLayout=").append(this.answersLayout).append(", logic=").append(this.logic).append(", mandatory=").append(this.mandatory).append(", addComment=").append(this.addComment).append(", commentLabel=").append(this.commentLabel).append(", isCommentMandatory=").append(this.isCommentMandatory).append(", disclaimerSettings=").append(this.disclaimerSettings).append(", displayLogicOperator=").append(this.displayLogicOperator).append(", displayLogic=").append(this.displayLogic).append(", surveyPointImage=");
        sb.append(this.surveyPointImage).append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.textOnTheLeft);
        dest.writeString(this.textOnTheRight);
        AnswerLayout answerLayout = this.answersLayout;
        if (answerLayout == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(answerLayout.name());
        }
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
        dest.writeInt(this.mandatory ? 1 : 0);
        dest.writeInt(this.addComment ? 1 : 0);
        dest.writeString(this.commentLabel);
        Boolean bool = this.isCommentMandatory;
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
    }

    /* JADX INFO: compiled from: SurveyNpsPointSettings.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SurveyNpsPointSettings> serializer() {
            return SurveyNpsPointSettings$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SurveyNpsPointSettings(int i, String str, String str2, AnswerLayout answerLayout, List list, boolean z, boolean z2, String str3, Boolean bool, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List list2, SurveyPointImage surveyPointImage, SerializationConstructorMarker serializationConstructorMarker) {
        if (4095 != (i & 4095)) {
            PluginExceptionsKt.throwMissingFieldException(i, 4095, SurveyNpsPointSettings$$serializer.INSTANCE.getDescriptor());
        }
        this.textOnTheLeft = str;
        this.textOnTheRight = str2;
        this.answersLayout = answerLayout;
        this.logic = list;
        this.mandatory = z;
        this.addComment = z2;
        this.commentLabel = str3;
        this.isCommentMandatory = bool;
        this.disclaimerSettings = disclaimerSettings;
        this.displayLogicOperator = surveyLogicOperator;
        this.displayLogic = list2;
        this.surveyPointImage = surveyPointImage;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(SurveyNpsPointSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.textOnTheLeft);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.textOnTheRight);
        output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.answersLayout);
        output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.logic);
        output.encodeBooleanElement(serialDesc, 4, self.mandatory);
        output.encodeBooleanElement(serialDesc, 5, self.addComment);
        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.commentLabel);
        output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.isCommentMandatory);
        output.encodeNullableSerializableElement(serialDesc, 8, DisclaimerSettings$$serializer.INSTANCE, self.disclaimerSettings);
        output.encodeNullableSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.displayLogicOperator);
        output.encodeSerializableElement(serialDesc, 10, lazyArr[10].getValue(), self.displayLogic);
        output.encodeNullableSerializableElement(serialDesc, 11, SurveyPointImage$$serializer.INSTANCE, self.surveyPointImage);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SurveyNpsPointSettings(String str, String str2, AnswerLayout answerLayout, List<SurveyPointRangeLogic> list, boolean z, boolean z2, String str3, Boolean bool, DisclaimerSettings disclaimerSettings, SurveyLogicOperator surveyLogicOperator, List<? extends DisplayLogic> displayLogic, SurveyPointImage surveyPointImage) {
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        this.textOnTheLeft = str;
        this.textOnTheRight = str2;
        this.answersLayout = answerLayout;
        this.logic = list;
        this.mandatory = z;
        this.addComment = z2;
        this.commentLabel = str3;
        this.isCommentMandatory = bool;
        this.disclaimerSettings = disclaimerSettings;
        this.displayLogicOperator = surveyLogicOperator;
        this.displayLogic = displayLogic;
        this.surveyPointImage = surveyPointImage;
    }

    public final String getTextOnTheLeft() {
        return this.textOnTheLeft;
    }

    public final String getTextOnTheRight() {
        return this.textOnTheRight;
    }

    public final AnswerLayout getAnswersLayout() {
        return this.answersLayout;
    }

    public final List<SurveyPointRangeLogic> getLogic() {
        return this.logic;
    }

    public final boolean getMandatory() {
        return this.mandatory;
    }

    public final boolean getAddComment() {
        return this.addComment;
    }

    public final String getCommentLabel() {
        return this.commentLabel;
    }

    public final Boolean isCommentMandatory() {
        return this.isCommentMandatory;
    }

    public final DisclaimerSettings getDisclaimerSettings() {
        return this.disclaimerSettings;
    }

    public final SurveyLogicOperator getDisplayLogicOperator() {
        return this.displayLogicOperator;
    }

    public final List<DisplayLogic> getDisplayLogic() {
        return this.displayLogic;
    }

    public final SurveyPointImage getSurveyPointImage() {
        return this.surveyPointImage;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.survicate.surveys.entities.survey.translations.Translatable
    public SurveyNpsPointSettings translatedWith(SurveyPointSettingsTranslation translation) {
        DisclaimerSettings disclaimerSettingsTranslatedWith;
        SurveyPointImage surveyPointImageTranslatedWith = null;
        String strIfNullOrBlankNullable = StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getLeftText() : null, this.textOnTheLeft);
        String strIfNullOrBlankNullable2 = StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getRightText() : null, this.textOnTheRight);
        String strIfNullOrBlankNullable3 = StringExtensionsKt.ifNullOrBlankNullable(translation != null ? translation.getCommentLabel() : null, this.commentLabel);
        DisclaimerSettings disclaimerSettings = this.disclaimerSettings;
        if (disclaimerSettings != null) {
            disclaimerSettingsTranslatedWith = disclaimerSettings.translatedWith(translation != null ? translation.getDisclaimerSettings() : null);
        } else {
            disclaimerSettingsTranslatedWith = null;
        }
        SurveyPointImage surveyPointImage = this.surveyPointImage;
        if (surveyPointImage != null) {
            surveyPointImageTranslatedWith = surveyPointImage.translatedWith(translation != null ? translation.getSurveyPointImage() : null);
        }
        return copy$default(this, strIfNullOrBlankNullable, strIfNullOrBlankNullable2, null, null, false, false, strIfNullOrBlankNullable3, null, disclaimerSettingsTranslatedWith, null, null, surveyPointImageTranslatedWith, 1724, null);
    }
}

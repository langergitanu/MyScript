package com.survicate.surveys.infrastructure.serialization;

import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.surveyLogic.display.DateDisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.display.FormDisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.display.MatrixDisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.display.MultipleChoiceDisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.display.RangeDisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.display.SingleChoiceDisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.display.TextDisplayLogic;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.JsonContentPolymorphicSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: DisplayLogicSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/serialization/DisplayLogicSerializer;", "Lkotlinx/serialization/json/JsonContentPolymorphicSerializer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/DisplayLogic;", "<init>", "()V", "selectDeserializer", "Lkotlinx/serialization/DeserializationStrategy;", "element", "Lkotlinx/serialization/json/JsonElement;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicSerializer extends JsonContentPolymorphicSerializer<DisplayLogic> {
    public static final DisplayLogicSerializer INSTANCE = new DisplayLogicSerializer();

    /* JADX INFO: compiled from: DisplayLogicSerializer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyAnswerType.values().length];
            try {
                iArr[SurveyAnswerType.SMILEY_SCALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyAnswerType.SINGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurveyAnswerType.MULTIPLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SurveyAnswerType.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SurveyAnswerType.DATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SurveyAnswerType.CSAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SurveyAnswerType.NUMERICAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SurveyAnswerType.SHAPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SurveyAnswerType.MATRIX.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SurveyAnswerType.NPS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SurveyAnswerType.FORM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[SurveyAnswerType.BUTTON_NEXT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[SurveyAnswerType.BUTTON_CLOSE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[SurveyAnswerType.BUTTON_LINK.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private DisplayLogicSerializer() {
        super(Reflection.getOrCreateKotlinClass(DisplayLogic.class));
    }

    @Override // kotlinx.serialization.json.JsonContentPolymorphicSerializer
    protected DeserializationStrategy<DisplayLogic> selectDeserializer(JsonElement element) {
        JsonElement jsonElement;
        String strAsStringOrNull;
        Intrinsics.checkNotNullParameter(element, "element");
        JsonObject jsonObjectAsObjectOrNull = KotlinxSerializationExtKt.asObjectOrNull(element);
        if (jsonObjectAsObjectOrNull == null || (jsonElement = (JsonElement) jsonObjectAsObjectOrNull.get((Object) "answer_type")) == null || (strAsStringOrNull = KotlinxSerializationExtKt.asStringOrNull(jsonElement)) == null) {
            throw new SerializationException("Missing answer_type in display logic object");
        }
        SurveyAnswerType surveyAnswerTypeFromString = SurveyAnswerType.INSTANCE.fromString(strAsStringOrNull);
        if (surveyAnswerTypeFromString == null) {
            throw new SerializationException("Unknown answer type: " + strAsStringOrNull);
        }
        switch (WhenMappings.$EnumSwitchMapping$0[surveyAnswerTypeFromString.ordinal()]) {
            case 1:
                return RangeDisplayLogic.INSTANCE.serializer();
            case 2:
                return SingleChoiceDisplayLogic.INSTANCE.serializer();
            case 3:
                return MultipleChoiceDisplayLogic.INSTANCE.serializer();
            case 4:
                return TextDisplayLogic.INSTANCE.serializer();
            case 5:
                return DateDisplayLogic.INSTANCE.serializer();
            case 6:
                return RangeDisplayLogic.INSTANCE.serializer();
            case 7:
                return RangeDisplayLogic.INSTANCE.serializer();
            case 8:
                return RangeDisplayLogic.INSTANCE.serializer();
            case 9:
                return MatrixDisplayLogic.INSTANCE.serializer();
            case 10:
                return RangeDisplayLogic.INSTANCE.serializer();
            case 11:
                return FormDisplayLogic.INSTANCE.serializer();
            case 12:
                throw new SerializationException("Button next display logic is not supported");
            case 13:
                throw new SerializationException("Button close display logic is not supported");
            case 14:
                throw new SerializationException("Button link display logic is not supported");
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}

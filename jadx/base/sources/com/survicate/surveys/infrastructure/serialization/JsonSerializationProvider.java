package com.survicate.surveys.infrastructure.serialization;

import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.cta.ButtonCloseCtaSettings;
import com.survicate.surveys.entities.survey.questions.cta.ButtonLinkCtaSettings;
import com.survicate.surveys.entities.survey.questions.cta.ButtonNextCtaSettings;
import com.survicate.surveys.entities.survey.questions.cta.CtaSettings;
import com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint;
import com.survicate.surveys.entities.survey.questions.form.SurveyFormSurveyPoint;
import com.survicate.surveys.entities.survey.questions.nps.SurveyNpsSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.date.SurveyPointDateSettings;
import com.survicate.surveys.entities.survey.questions.question.matrix.SurveyPointMatrixSettings;
import com.survicate.surveys.entities.survey.questions.question.multiple.SurveyPointMultipleSettings;
import com.survicate.surveys.entities.survey.questions.question.rating.csat.SurveyPointCsatSettings;
import com.survicate.surveys.entities.survey.questions.question.rating.numerical.SurveyPointNumericalSettings;
import com.survicate.surveys.entities.survey.questions.question.rating.shape.SurveyPointShapeSettings;
import com.survicate.surveys.entities.survey.questions.question.single.SurveyPointSingleSettings;
import com.survicate.surveys.entities.survey.questions.question.smileyScale.SurveyPointSmileyScaleSettings;
import com.survicate.surveys.entities.survey.questions.question.text.SurveyPointTextSettings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;

/* JADX INFO: compiled from: JsonSerializationProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0007R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/serialization/JsonSerializationProvider;", "", "<init>", "()V", "module", "Lkotlinx/serialization/modules/SerializersModule;", "getModule", "()Lkotlinx/serialization/modules/SerializersModule;", "provide", "Lkotlinx/serialization/json/Json;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class JsonSerializationProvider {
    public static final JsonSerializationProvider INSTANCE = new JsonSerializationProvider();

    private JsonSerializationProvider() {
    }

    @JvmStatic
    public static final Json provide() {
        return JsonKt.Json$default(null, new Function1() { // from class: com.survicate.surveys.infrastructure.serialization.JsonSerializationProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JsonSerializationProvider.provide$lambda$4((JsonBuilder) obj);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit provide$lambda$4(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setExplicitNulls(false);
        Json.setEncodeDefaults(true);
        Json.setSerializersModule(INSTANCE.getModule());
        return Unit.INSTANCE;
    }

    private final SerializersModule getModule() {
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        PolymorphicModuleBuilder polymorphicModuleBuilder = new PolymorphicModuleBuilder(Reflection.getOrCreateKotlinClass(SurveyPoint.class), null);
        polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(SurveyQuestionSurveyPoint.class), SurveyQuestionSurveyPointSerializer.INSTANCE);
        polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(SurveyCtaSurveyPoint.class), SurveyCtaSurveyPointSerializer.INSTANCE);
        polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(SurveyNpsSurveyPoint.class), SurveyNpsSurveyPoint.INSTANCE.serializer());
        polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(SurveyFormSurveyPoint.class), SurveyFormSurveyPoint.INSTANCE.serializer());
        polymorphicModuleBuilder.buildTo(serializersModuleBuilder);
        PolymorphicModuleBuilder polymorphicModuleBuilder2 = new PolymorphicModuleBuilder(Reflection.getOrCreateKotlinClass(SurveyQuestionPointSettings.class), null);
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(SurveyPointSingleSettings.class), SurveyPointSingleSettings.INSTANCE.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(SurveyPointMultipleSettings.class), SurveyPointMultipleSettings.INSTANCE.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(SurveyPointSmileyScaleSettings.class), SurveyPointSmileyScaleSettings.INSTANCE.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(SurveyPointNumericalSettings.class), SurveyPointNumericalSettings.INSTANCE.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(SurveyPointCsatSettings.class), SurveyPointCsatSettings.INSTANCE.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(SurveyPointShapeSettings.class), SurveyPointShapeSettings.INSTANCE.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(SurveyPointTextSettings.class), SurveyPointTextSettings.INSTANCE.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(SurveyPointDateSettings.class), SurveyPointDateSettings.INSTANCE.serializer());
        polymorphicModuleBuilder2.subclass(Reflection.getOrCreateKotlinClass(SurveyPointMatrixSettings.class), SurveyPointMatrixSettings.INSTANCE.serializer());
        polymorphicModuleBuilder2.buildTo(serializersModuleBuilder);
        PolymorphicModuleBuilder polymorphicModuleBuilder3 = new PolymorphicModuleBuilder(Reflection.getOrCreateKotlinClass(CtaSettings.class), null);
        polymorphicModuleBuilder3.subclass(Reflection.getOrCreateKotlinClass(ButtonNextCtaSettings.class), ButtonNextCtaSettings.INSTANCE.serializer());
        polymorphicModuleBuilder3.subclass(Reflection.getOrCreateKotlinClass(ButtonCloseCtaSettings.class), ButtonCloseCtaSettings.INSTANCE.serializer());
        polymorphicModuleBuilder3.subclass(Reflection.getOrCreateKotlinClass(ButtonLinkCtaSettings.class), ButtonLinkCtaSettings.INSTANCE.serializer());
        polymorphicModuleBuilder3.buildTo(serializersModuleBuilder);
        return serializersModuleBuilder.build();
    }
}

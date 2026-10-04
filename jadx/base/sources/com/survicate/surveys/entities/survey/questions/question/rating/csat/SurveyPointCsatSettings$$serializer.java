package com.survicate.surveys.entities.survey.questions.question.rating.csat;

import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings$$serializer;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage$$serializer;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonClassDiscriminator;

/* JADX INFO: compiled from: SurveyPointCsatSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/entities/survey/questions/question/rating/csat/SurveyPointCsatSettings.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/survicate/surveys/entities/survey/questions/question/rating/csat/SurveyPointCsatSettings;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class SurveyPointCsatSettings$$serializer implements GeneratedSerializer<SurveyPointCsatSettings> {
    public static final SurveyPointCsatSettings$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private SurveyPointCsatSettings$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SurveyPointCsatSettings$$serializer surveyPointCsatSettings$$serializer = new SurveyPointCsatSettings$$serializer();
        INSTANCE = surveyPointCsatSettings$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor(QuestionSurveyAnswerType.CSAT, surveyPointCsatSettings$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("logic", false);
        pluginGeneratedSerialDescriptor.addElement("mandatory", false);
        pluginGeneratedSerialDescriptor.addElement("comment_label", false);
        pluginGeneratedSerialDescriptor.addElement("mandatory_comment", false);
        pluginGeneratedSerialDescriptor.addElement("disclaimer_settings", false);
        pluginGeneratedSerialDescriptor.addElement("display_logic_operator", false);
        pluginGeneratedSerialDescriptor.addElement("display_logic", false);
        pluginGeneratedSerialDescriptor.addElement("point_image", false);
        final String str = "answer_type";
        pluginGeneratedSerialDescriptor.pushClassAnnotation(new JsonClassDiscriminator(str) { // from class: com.survicate.surveys.entities.survey.questions.question.rating.csat.SurveyPointCsatSettings$$serializer$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0
            private final /* synthetic */ String discriminator;

            {
                Intrinsics.checkNotNullParameter(str, "discriminator");
                this.discriminator = str;
            }

            @Override // java.lang.annotation.Annotation
            public final /* synthetic */ Class annotationType() {
                return JsonClassDiscriminator.class;
            }

            @Override // kotlinx.serialization.json.JsonClassDiscriminator
            public final /* synthetic */ String discriminator() {
                return this.discriminator;
            }

            @Override // java.lang.annotation.Annotation
            public final boolean equals(Object obj) {
                return (obj instanceof JsonClassDiscriminator) && Intrinsics.areEqual(discriminator(), ((JsonClassDiscriminator) obj).discriminator());
            }

            @Override // java.lang.annotation.Annotation
            public final int hashCode() {
                return ("discriminator".hashCode() * 127) ^ this.discriminator.hashCode();
            }

            @Override // java.lang.annotation.Annotation
            public final String toString() {
                return "@kotlinx.serialization.json.JsonClassDiscriminator(discriminator=" + this.discriminator + ')';
            }
        });
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr = SurveyPointCsatSettings.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable((KSerializer) lazyArr[0].getValue()), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DisclaimerSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[5].getValue()), lazyArr[6].getValue(), BuiltinSerializersKt.getNullable(SurveyPointImage$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SurveyPointCsatSettings deserialize(Decoder decoder) {
        SurveyLogicOperator surveyLogicOperator;
        Boolean bool;
        DisclaimerSettings disclaimerSettings;
        String str;
        int i;
        SurveyPointImage surveyPointImage;
        List list;
        Boolean bool2;
        List list2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = SurveyPointCsatSettings.$childSerializers;
        int i2 = 7;
        List list3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            bool = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, null);
            String str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, null);
            DisclaimerSettings disclaimerSettings2 = (DisclaimerSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, DisclaimerSettings$$serializer.INSTANCE, null);
            SurveyLogicOperator surveyLogicOperator2 = (SurveyLogicOperator) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), null);
            i = 255;
            list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), null);
            surveyPointImage = (SurveyPointImage) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, SurveyPointImage$$serializer.INSTANCE, null);
            bool2 = bool3;
            disclaimerSettings = disclaimerSettings2;
            str = str2;
            surveyLogicOperator = surveyLogicOperator2;
            list = list4;
        } else {
            boolean z = true;
            int i3 = 0;
            SurveyPointImage surveyPointImage2 = null;
            List list5 = null;
            SurveyLogicOperator surveyLogicOperator3 = null;
            DisclaimerSettings disclaimerSettings3 = null;
            Boolean bool4 = null;
            String str3 = null;
            Boolean bool5 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                        break;
                    case 0:
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list3);
                        i3 |= 1;
                        i2 = 7;
                        break;
                    case 1:
                        bool4 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, bool4);
                        i3 |= 2;
                        i2 = 7;
                        break;
                    case 2:
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str3);
                        i3 |= 4;
                        i2 = 7;
                        break;
                    case 3:
                        bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, bool5);
                        i3 |= 8;
                        i2 = 7;
                        break;
                    case 4:
                        disclaimerSettings3 = (DisclaimerSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, DisclaimerSettings$$serializer.INSTANCE, disclaimerSettings3);
                        i3 |= 16;
                        i2 = 7;
                        break;
                    case 5:
                        surveyLogicOperator3 = (SurveyLogicOperator) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), surveyLogicOperator3);
                        i3 |= 32;
                        break;
                    case 6:
                        list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list5);
                        i3 |= 64;
                        break;
                    case 7:
                        surveyPointImage2 = (SurveyPointImage) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, SurveyPointImage$$serializer.INSTANCE, surveyPointImage2);
                        i3 |= 128;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            String str4 = str3;
            surveyLogicOperator = surveyLogicOperator3;
            bool = bool4;
            disclaimerSettings = disclaimerSettings3;
            str = str4;
            i = i3;
            surveyPointImage = surveyPointImage2;
            list = list3;
            bool2 = bool5;
            list2 = list5;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SurveyPointCsatSettings(i, list, bool, str, bool2, disclaimerSettings, surveyLogicOperator, list2, surveyPointImage, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SurveyPointCsatSettings value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        SurveyPointCsatSettings.write$Self$survicate_sdk_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}

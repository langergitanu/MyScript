package com.survicate.surveys.entities.survey.questions.question.rating.numerical;

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

/* JADX INFO: compiled from: SurveyPointNumericalSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/entities/survey/questions/question/rating/numerical/SurveyPointNumericalSettings.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/survicate/surveys/entities/survey/questions/question/rating/numerical/SurveyPointNumericalSettings;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class SurveyPointNumericalSettings$$serializer implements GeneratedSerializer<SurveyPointNumericalSettings> {
    public static final SurveyPointNumericalSettings$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private SurveyPointNumericalSettings$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SurveyPointNumericalSettings$$serializer surveyPointNumericalSettings$$serializer = new SurveyPointNumericalSettings$$serializer();
        INSTANCE = surveyPointNumericalSettings$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor(QuestionSurveyAnswerType.NUMERICAL, surveyPointNumericalSettings$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("text_on_the_left", false);
        pluginGeneratedSerialDescriptor.addElement("text_on_the_right", false);
        pluginGeneratedSerialDescriptor.addElement("logic", false);
        pluginGeneratedSerialDescriptor.addElement("mandatory", false);
        pluginGeneratedSerialDescriptor.addElement("comment_label", false);
        pluginGeneratedSerialDescriptor.addElement("mandatory_comment", false);
        pluginGeneratedSerialDescriptor.addElement("disclaimer_settings", false);
        pluginGeneratedSerialDescriptor.addElement("display_logic_operator", false);
        pluginGeneratedSerialDescriptor.addElement("display_logic", false);
        pluginGeneratedSerialDescriptor.addElement("point_image", false);
        final String str = "answer_type";
        pluginGeneratedSerialDescriptor.pushClassAnnotation(new JsonClassDiscriminator(str) { // from class: com.survicate.surveys.entities.survey.questions.question.rating.numerical.SurveyPointNumericalSettings$$serializer$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0
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
        Lazy[] lazyArr = SurveyPointNumericalSettings.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DisclaimerSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[7].getValue()), lazyArr[8].getValue(), BuiltinSerializersKt.getNullable(SurveyPointImage$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SurveyPointNumericalSettings deserialize(Decoder decoder) {
        List list;
        String str;
        String str2;
        List list2;
        SurveyLogicOperator surveyLogicOperator;
        Boolean bool;
        DisclaimerSettings disclaimerSettings;
        SurveyPointImage surveyPointImage;
        String str3;
        Boolean bool2;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = SurveyPointNumericalSettings.$childSerializers;
        int i2 = 9;
        int i3 = 8;
        String str4 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            List list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            Boolean bool4 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, BooleanSerializer.INSTANCE, null);
            DisclaimerSettings disclaimerSettings2 = (DisclaimerSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, DisclaimerSettings$$serializer.INSTANCE, null);
            SurveyLogicOperator surveyLogicOperator2 = (SurveyLogicOperator) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), null);
            list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), null);
            str = str5;
            surveyPointImage = (SurveyPointImage) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, SurveyPointImage$$serializer.INSTANCE, null);
            disclaimerSettings = disclaimerSettings2;
            bool = bool4;
            bool2 = bool3;
            str3 = str7;
            surveyLogicOperator = surveyLogicOperator2;
            list = list3;
            str2 = str6;
            i = 1023;
        } else {
            int i4 = 7;
            int i5 = 2;
            boolean z = true;
            int i6 = 0;
            List list4 = null;
            SurveyLogicOperator surveyLogicOperator3 = null;
            Boolean bool5 = null;
            DisclaimerSettings disclaimerSettings3 = null;
            SurveyPointImage surveyPointImage2 = null;
            String str8 = null;
            Boolean bool6 = null;
            List list5 = null;
            String str9 = null;
            while (z) {
                int i7 = i3;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 9;
                        i3 = 8;
                        i5 = 2;
                        i4 = 7;
                        break;
                    case 0:
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str4);
                        i6 |= 1;
                        i2 = 9;
                        i3 = 8;
                        i5 = 2;
                        i4 = 7;
                        break;
                    case 1:
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str9);
                        i6 |= 2;
                        i2 = 9;
                        i3 = 8;
                        i5 = 2;
                        i4 = 7;
                        break;
                    case 2:
                        list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, (DeserializationStrategy) lazyArr[i5].getValue(), list5);
                        i6 |= 4;
                        i2 = 9;
                        i3 = 8;
                        i4 = 7;
                        break;
                    case 3:
                        bool6 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, bool6);
                        i6 |= 8;
                        i2 = 9;
                        i3 = 8;
                        i4 = 7;
                        break;
                    case 4:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str8);
                        i6 |= 16;
                        i2 = 9;
                        i3 = 8;
                        i4 = 7;
                        break;
                    case 5:
                        bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, BooleanSerializer.INSTANCE, bool5);
                        i6 |= 32;
                        i2 = 9;
                        i3 = 8;
                        i4 = 7;
                        break;
                    case 6:
                        disclaimerSettings3 = (DisclaimerSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, DisclaimerSettings$$serializer.INSTANCE, disclaimerSettings3);
                        i6 |= 64;
                        i2 = 9;
                        i3 = 8;
                        i4 = 7;
                        break;
                    case 7:
                        surveyLogicOperator3 = (SurveyLogicOperator) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, (DeserializationStrategy) lazyArr[i4].getValue(), surveyLogicOperator3);
                        i6 |= 128;
                        i2 = 9;
                        i3 = 8;
                        break;
                    case 8:
                        list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i7, (DeserializationStrategy) lazyArr[i7].getValue(), list4);
                        i6 |= 256;
                        i3 = i7;
                        i2 = 9;
                        break;
                    case 9:
                        surveyPointImage2 = (SurveyPointImage) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, SurveyPointImage$$serializer.INSTANCE, surveyPointImage2);
                        i6 |= 512;
                        i3 = i7;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            String str10 = str9;
            list = list5;
            str = str4;
            str2 = str10;
            list2 = list4;
            surveyLogicOperator = surveyLogicOperator3;
            bool = bool5;
            disclaimerSettings = disclaimerSettings3;
            surveyPointImage = surveyPointImage2;
            str3 = str8;
            bool2 = bool6;
            i = i6;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SurveyPointNumericalSettings(i, str, str2, list, bool2, str3, bool, disclaimerSettings, surveyLogicOperator, list2, surveyPointImage, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SurveyPointNumericalSettings value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        SurveyPointNumericalSettings.write$Self$survicate_sdk_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}

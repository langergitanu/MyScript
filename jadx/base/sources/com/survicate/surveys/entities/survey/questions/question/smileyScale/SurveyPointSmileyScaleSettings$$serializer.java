package com.survicate.surveys.entities.survey.questions.question.smileyScale;

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

/* JADX INFO: compiled from: SurveyPointSmileyScaleSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/entities/survey/questions/question/smileyScale/SurveyPointSmileyScaleSettings.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/survicate/surveys/entities/survey/questions/question/smileyScale/SurveyPointSmileyScaleSettings;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class SurveyPointSmileyScaleSettings$$serializer implements GeneratedSerializer<SurveyPointSmileyScaleSettings> {
    public static final SurveyPointSmileyScaleSettings$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private SurveyPointSmileyScaleSettings$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SurveyPointSmileyScaleSettings$$serializer surveyPointSmileyScaleSettings$$serializer = new SurveyPointSmileyScaleSettings$$serializer();
        INSTANCE = surveyPointSmileyScaleSettings$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor(QuestionSurveyAnswerType.SMILEY_SCALE, surveyPointSmileyScaleSettings$$serializer, 11);
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
        pluginGeneratedSerialDescriptor.addElement("scale_style", false);
        final String str = "answer_type";
        pluginGeneratedSerialDescriptor.pushClassAnnotation(new JsonClassDiscriminator(str) { // from class: com.survicate.surveys.entities.survey.questions.question.smileyScale.SurveyPointSmileyScaleSettings$$serializer$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0
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
        Lazy[] lazyArr = SurveyPointSmileyScaleSettings.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DisclaimerSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[7].getValue()), lazyArr[8].getValue(), BuiltinSerializersKt.getNullable(SurveyPointImage$$serializer.INSTANCE), SmileyScaleStyle$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SurveyPointSmileyScaleSettings deserialize(Decoder decoder) {
        DisclaimerSettings disclaimerSettings;
        String str;
        List list;
        Boolean bool;
        Boolean bool2;
        List list2;
        SmileyScaleStyle smileyScaleStyle;
        SurveyPointImage surveyPointImage;
        String str2;
        String str3;
        SurveyLogicOperator surveyLogicOperator;
        int i;
        Lazy[] lazyArr;
        Lazy[] lazyArr2;
        Lazy[] lazyArr3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr4 = SurveyPointSmileyScaleSettings.$childSerializers;
        String str4 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            List list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr4[2].getValue(), null);
            Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            Boolean bool4 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, BooleanSerializer.INSTANCE, null);
            DisclaimerSettings disclaimerSettings2 = (DisclaimerSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, DisclaimerSettings$$serializer.INSTANCE, null);
            SurveyLogicOperator surveyLogicOperator2 = (SurveyLogicOperator) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr4[7].getValue(), null);
            List list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr4[8].getValue(), null);
            SurveyPointImage surveyPointImage2 = (SurveyPointImage) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, SurveyPointImage$$serializer.INSTANCE, null);
            list = list4;
            smileyScaleStyle = (SmileyScaleStyle) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 10, SmileyScaleStyle$$serializer.INSTANCE, null);
            surveyPointImage = surveyPointImage2;
            surveyLogicOperator = surveyLogicOperator2;
            bool = bool3;
            str3 = str6;
            disclaimerSettings = disclaimerSettings2;
            i = 2047;
            str2 = str7;
            list2 = list3;
            bool2 = bool4;
            str = str5;
        } else {
            int i2 = 7;
            int i3 = 8;
            int i4 = 2;
            boolean z = true;
            int i5 = 0;
            SmileyScaleStyle smileyScaleStyle2 = null;
            SurveyLogicOperator surveyLogicOperator3 = null;
            DisclaimerSettings disclaimerSettings3 = null;
            String str8 = null;
            Boolean bool5 = null;
            List list5 = null;
            SurveyPointImage surveyPointImage3 = null;
            Boolean bool6 = null;
            List list6 = null;
            String str9 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        lazyArr = lazyArr4;
                        z = false;
                        lazyArr4 = lazyArr;
                        i4 = 2;
                        i2 = 7;
                        i3 = 8;
                        break;
                    case 0:
                        lazyArr = lazyArr4;
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str4);
                        i5 |= 1;
                        lazyArr4 = lazyArr;
                        i4 = 2;
                        i2 = 7;
                        i3 = 8;
                        break;
                    case 1:
                        lazyArr = lazyArr4;
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str9);
                        i5 |= 2;
                        lazyArr4 = lazyArr;
                        i4 = 2;
                        i2 = 7;
                        i3 = 8;
                        break;
                    case 2:
                        lazyArr2 = lazyArr4;
                        list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, (DeserializationStrategy) lazyArr2[i4].getValue(), list6);
                        i5 |= 4;
                        lazyArr4 = lazyArr2;
                        i2 = 7;
                        i3 = 8;
                        break;
                    case 3:
                        lazyArr2 = lazyArr4;
                        bool6 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, bool6);
                        i5 |= 8;
                        lazyArr4 = lazyArr2;
                        i2 = 7;
                        i3 = 8;
                        break;
                    case 4:
                        lazyArr2 = lazyArr4;
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str8);
                        i5 |= 16;
                        lazyArr4 = lazyArr2;
                        i2 = 7;
                        i3 = 8;
                        break;
                    case 5:
                        lazyArr2 = lazyArr4;
                        bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, BooleanSerializer.INSTANCE, bool5);
                        i5 |= 32;
                        lazyArr4 = lazyArr2;
                        i2 = 7;
                        i3 = 8;
                        break;
                    case 6:
                        lazyArr2 = lazyArr4;
                        disclaimerSettings3 = (DisclaimerSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, DisclaimerSettings$$serializer.INSTANCE, disclaimerSettings3);
                        i5 |= 64;
                        lazyArr4 = lazyArr2;
                        i2 = 7;
                        i3 = 8;
                        break;
                    case 7:
                        Lazy[] lazyArr5 = lazyArr4;
                        surveyLogicOperator3 = (SurveyLogicOperator) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, (DeserializationStrategy) lazyArr5[i2].getValue(), surveyLogicOperator3);
                        i5 |= 128;
                        lazyArr4 = lazyArr5;
                        i3 = 8;
                        break;
                    case 8:
                        lazyArr3 = lazyArr4;
                        list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i3, (DeserializationStrategy) lazyArr3[i3].getValue(), list5);
                        i5 |= 256;
                        lazyArr4 = lazyArr3;
                        break;
                    case 9:
                        lazyArr3 = lazyArr4;
                        surveyPointImage3 = (SurveyPointImage) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, SurveyPointImage$$serializer.INSTANCE, surveyPointImage3);
                        i5 |= 512;
                        lazyArr4 = lazyArr3;
                        break;
                    case 10:
                        smileyScaleStyle2 = (SmileyScaleStyle) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 10, SmileyScaleStyle$$serializer.INSTANCE, smileyScaleStyle2);
                        i5 |= 1024;
                        lazyArr4 = lazyArr4;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            List list7 = list6;
            disclaimerSettings = disclaimerSettings3;
            str = str4;
            list = list5;
            bool = bool6;
            bool2 = bool5;
            list2 = list7;
            smileyScaleStyle = smileyScaleStyle2;
            surveyPointImage = surveyPointImage3;
            str2 = str8;
            str3 = str9;
            surveyLogicOperator = surveyLogicOperator3;
            i = i5;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SurveyPointSmileyScaleSettings(i, str, str3, list2, bool, str2, bool2, disclaimerSettings, surveyLogicOperator, list, surveyPointImage, smileyScaleStyle, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SurveyPointSmileyScaleSettings value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        SurveyPointSmileyScaleSettings.write$Self$survicate_sdk_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}

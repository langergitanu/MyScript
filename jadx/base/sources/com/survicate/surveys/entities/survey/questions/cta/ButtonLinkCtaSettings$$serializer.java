package com.survicate.surveys.entities.survey.questions.cta;

import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings$$serializer;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage$$serializer;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.surveys.CtaSurveyAnswerType;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonClassDiscriminator;

/* JADX INFO: compiled from: ButtonLinkCtaSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/entities/survey/questions/cta/ButtonLinkCtaSettings.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/survicate/surveys/entities/survey/questions/cta/ButtonLinkCtaSettings;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class ButtonLinkCtaSettings$$serializer implements GeneratedSerializer<ButtonLinkCtaSettings> {
    public static final ButtonLinkCtaSettings$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private ButtonLinkCtaSettings$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ButtonLinkCtaSettings$$serializer buttonLinkCtaSettings$$serializer = new ButtonLinkCtaSettings$$serializer();
        INSTANCE = buttonLinkCtaSettings$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor(CtaSurveyAnswerType.BUTTON_LINK, buttonLinkCtaSettings$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("link", false);
        pluginGeneratedSerialDescriptor.addElement("text", false);
        pluginGeneratedSerialDescriptor.addElement("disclaimer_settings", false);
        pluginGeneratedSerialDescriptor.addElement("display_logic_operator", false);
        pluginGeneratedSerialDescriptor.addElement("display_logic", false);
        pluginGeneratedSerialDescriptor.addElement("point_image", false);
        final String str = "answer_type";
        pluginGeneratedSerialDescriptor.pushClassAnnotation(new JsonClassDiscriminator(str) { // from class: com.survicate.surveys.entities.survey.questions.cta.ButtonLinkCtaSettings$$serializer$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0
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
        Lazy[] lazyArr = ButtonLinkCtaSettings.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DisclaimerSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[3].getValue()), lazyArr[4].getValue(), BuiltinSerializersKt.getNullable(SurveyPointImage$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ButtonLinkCtaSettings deserialize(Decoder decoder) {
        List list;
        SurveyPointImage surveyPointImage;
        DisclaimerSettings disclaimerSettings;
        SurveyLogicOperator surveyLogicOperator;
        String str;
        String str2;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ButtonLinkCtaSettings.$childSerializers;
        int i2 = 5;
        String str3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            DisclaimerSettings disclaimerSettings2 = (DisclaimerSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, DisclaimerSettings$$serializer.INSTANCE, null);
            SurveyLogicOperator surveyLogicOperator2 = (SurveyLogicOperator) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
            str = str4;
            surveyPointImage = (SurveyPointImage) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, SurveyPointImage$$serializer.INSTANCE, null);
            disclaimerSettings = disclaimerSettings2;
            surveyLogicOperator = surveyLogicOperator2;
            i = 63;
            str2 = str5;
        } else {
            boolean z = true;
            int i3 = 0;
            String str6 = null;
            DisclaimerSettings disclaimerSettings3 = null;
            SurveyLogicOperator surveyLogicOperator3 = null;
            List list2 = null;
            SurveyPointImage surveyPointImage2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 5;
                        break;
                    case 0:
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str3);
                        i3 |= 1;
                        i2 = 5;
                        break;
                    case 1:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str6);
                        i3 |= 2;
                        break;
                    case 2:
                        disclaimerSettings3 = (DisclaimerSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, DisclaimerSettings$$serializer.INSTANCE, disclaimerSettings3);
                        i3 |= 4;
                        break;
                    case 3:
                        surveyLogicOperator3 = (SurveyLogicOperator) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), surveyLogicOperator3);
                        i3 |= 8;
                        break;
                    case 4:
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list2);
                        i3 |= 16;
                        break;
                    case 5:
                        surveyPointImage2 = (SurveyPointImage) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, SurveyPointImage$$serializer.INSTANCE, surveyPointImage2);
                        i3 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            list = list2;
            surveyPointImage = surveyPointImage2;
            disclaimerSettings = disclaimerSettings3;
            surveyLogicOperator = surveyLogicOperator3;
            str = str3;
            str2 = str6;
            i = i3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ButtonLinkCtaSettings(i, str, str2, disclaimerSettings, surveyLogicOperator, list, surveyPointImage, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ButtonLinkCtaSettings value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        ButtonLinkCtaSettings.write$Self$survicate_sdk_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}

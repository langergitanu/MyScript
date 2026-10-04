package com.survicate.surveys.entities.survey.questions.nps;

import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings$$serializer;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage;
import com.survicate.surveys.entities.survey.questions.SurveyPointImage$$serializer;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
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

/* JADX INFO: compiled from: SurveyNpsPointSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class SurveyNpsPointSettings$$serializer implements GeneratedSerializer<SurveyNpsPointSettings> {
    public static final SurveyNpsPointSettings$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private SurveyNpsPointSettings$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SurveyNpsPointSettings$$serializer surveyNpsPointSettings$$serializer = new SurveyNpsPointSettings$$serializer();
        INSTANCE = surveyNpsPointSettings$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.survicate.surveys.entities.survey.questions.nps.SurveyNpsPointSettings", surveyNpsPointSettings$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("text_on_the_left", false);
        pluginGeneratedSerialDescriptor.addElement("text_on_the_right", false);
        pluginGeneratedSerialDescriptor.addElement("answers_layout", false);
        pluginGeneratedSerialDescriptor.addElement("logic", false);
        pluginGeneratedSerialDescriptor.addElement("mandatory", false);
        pluginGeneratedSerialDescriptor.addElement("add_comment", false);
        pluginGeneratedSerialDescriptor.addElement("comment_label", false);
        pluginGeneratedSerialDescriptor.addElement("mandatory_comment", false);
        pluginGeneratedSerialDescriptor.addElement("disclaimer_settings", false);
        pluginGeneratedSerialDescriptor.addElement("display_logic_operator", false);
        pluginGeneratedSerialDescriptor.addElement("display_logic", false);
        pluginGeneratedSerialDescriptor.addElement("point_image", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr = SurveyNpsPointSettings.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[3].getValue()), BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DisclaimerSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[9].getValue()), lazyArr[10].getValue(), BuiltinSerializersKt.getNullable(SurveyPointImage$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SurveyNpsPointSettings deserialize(Decoder decoder) {
        AnswerLayout answerLayout;
        String str;
        List list;
        SurveyLogicOperator surveyLogicOperator;
        DisclaimerSettings disclaimerSettings;
        Boolean bool;
        String str2;
        List list2;
        boolean z;
        boolean z2;
        String str3;
        SurveyPointImage surveyPointImage;
        int i;
        Lazy[] lazyArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr2 = SurveyNpsPointSettings.$childSerializers;
        int i2 = 10;
        String str4 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            AnswerLayout answerLayout2 = (AnswerLayout) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr2[2].getValue(), null);
            List list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr2[3].getValue(), null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 4);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 5);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, BooleanSerializer.INSTANCE, null);
            DisclaimerSettings disclaimerSettings2 = (DisclaimerSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, DisclaimerSettings$$serializer.INSTANCE, null);
            SurveyLogicOperator surveyLogicOperator2 = (SurveyLogicOperator) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr2[9].getValue(), null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr2[10].getValue(), null);
            surveyPointImage = (SurveyPointImage) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, SurveyPointImage$$serializer.INSTANCE, null);
            bool = bool2;
            str2 = str6;
            z = zDecodeBooleanElement2;
            disclaimerSettings = disclaimerSettings2;
            z2 = zDecodeBooleanElement;
            surveyLogicOperator = surveyLogicOperator2;
            list2 = list3;
            answerLayout = answerLayout2;
            str3 = str5;
            i = 4095;
        } else {
            int i3 = 11;
            List list4 = null;
            SurveyLogicOperator surveyLogicOperator3 = null;
            DisclaimerSettings disclaimerSettings3 = null;
            SurveyPointImage surveyPointImage2 = null;
            Boolean bool3 = null;
            int i4 = 9;
            int i5 = 3;
            int i6 = 2;
            boolean z3 = true;
            int i7 = 0;
            boolean zDecodeBooleanElement3 = false;
            boolean zDecodeBooleanElement4 = false;
            String str7 = null;
            List list5 = null;
            AnswerLayout answerLayout3 = null;
            String str8 = null;
            while (z3) {
                int i8 = i2;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z3 = false;
                        lazyArr2 = lazyArr2;
                        i2 = 10;
                        i6 = 2;
                        i5 = 3;
                        i4 = 9;
                        break;
                    case 0:
                        lazyArr = lazyArr2;
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str4);
                        i7 |= 1;
                        lazyArr2 = lazyArr;
                        i3 = 11;
                        i2 = 10;
                        i6 = 2;
                        i5 = 3;
                        i4 = 9;
                        break;
                    case 1:
                        lazyArr = lazyArr2;
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str8);
                        i7 |= 2;
                        lazyArr2 = lazyArr;
                        i3 = 11;
                        i2 = 10;
                        i6 = 2;
                        i5 = 3;
                        i4 = 9;
                        break;
                    case 2:
                        Lazy[] lazyArr3 = lazyArr2;
                        answerLayout3 = (AnswerLayout) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i6, (DeserializationStrategy) lazyArr3[i6].getValue(), answerLayout3);
                        i7 |= 4;
                        lazyArr2 = lazyArr3;
                        i3 = 11;
                        i2 = 10;
                        i5 = 3;
                        i4 = 9;
                        break;
                    case 3:
                        list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, (DeserializationStrategy) lazyArr2[i5].getValue(), list5);
                        i7 |= 8;
                        lazyArr2 = lazyArr2;
                        i3 = 11;
                        i2 = 10;
                        i4 = 9;
                        break;
                    case 4:
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 4);
                        i7 |= 16;
                        i3 = 11;
                        i2 = 10;
                        i4 = 9;
                        break;
                    case 5:
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 5);
                        i7 |= 32;
                        i3 = 11;
                        i2 = 10;
                        i4 = 9;
                        break;
                    case 6:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str7);
                        i7 |= 64;
                        i3 = 11;
                        i2 = 10;
                        i4 = 9;
                        break;
                    case 7:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, BooleanSerializer.INSTANCE, bool3);
                        i7 |= 128;
                        i3 = 11;
                        i2 = 10;
                        i4 = 9;
                        break;
                    case 8:
                        disclaimerSettings3 = (DisclaimerSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, DisclaimerSettings$$serializer.INSTANCE, disclaimerSettings3);
                        i7 |= 256;
                        i3 = 11;
                        i2 = 10;
                        i4 = 9;
                        break;
                    case 9:
                        surveyLogicOperator3 = (SurveyLogicOperator) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, (DeserializationStrategy) lazyArr2[i4].getValue(), surveyLogicOperator3);
                        i7 |= 512;
                        i3 = 11;
                        i2 = 10;
                        break;
                    case 10:
                        list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i8, (DeserializationStrategy) lazyArr2[i8].getValue(), list4);
                        i7 |= 1024;
                        i2 = i8;
                        i3 = 11;
                        break;
                    case 11:
                        surveyPointImage2 = (SurveyPointImage) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, SurveyPointImage$$serializer.INSTANCE, surveyPointImage2);
                        i7 |= 2048;
                        i2 = i8;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            String str9 = str8;
            answerLayout = answerLayout3;
            str = str9;
            list = list4;
            surveyLogicOperator = surveyLogicOperator3;
            disclaimerSettings = disclaimerSettings3;
            bool = bool3;
            str2 = str7;
            list2 = list5;
            z = zDecodeBooleanElement3;
            z2 = zDecodeBooleanElement4;
            str3 = str4;
            surveyPointImage = surveyPointImage2;
            i = i7;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SurveyNpsPointSettings(i, str3, str, answerLayout, list2, z2, z, str2, bool, disclaimerSettings, surveyLogicOperator, list, surveyPointImage, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SurveyNpsPointSettings value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        SurveyNpsPointSettings.write$Self$survicate_sdk_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}

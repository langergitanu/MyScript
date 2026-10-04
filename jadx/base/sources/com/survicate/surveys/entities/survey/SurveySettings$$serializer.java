package com.survicate.surveys.entities.survey;

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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: SurveySettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/entities/survey/SurveySettings.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/survicate/surveys/entities/survey/SurveySettings;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class SurveySettings$$serializer implements GeneratedSerializer<SurveySettings> {
    public static final SurveySettings$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private SurveySettings$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SurveySettings$$serializer surveySettings$$serializer = new SurveySettings$$serializer();
        INSTANCE = surveySettings$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.survicate.surveys.entities.survey.SurveySettings", surveySettings$$serializer, 16);
        pluginGeneratedSerialDescriptor.addElement("display_percentage", true);
        pluginGeneratedSerialDescriptor.addElement("display_not_engaged", true);
        pluginGeneratedSerialDescriptor.addElement("display_delay", true);
        pluginGeneratedSerialDescriptor.addElement("messages", true);
        pluginGeneratedSerialDescriptor.addElement("place_to_show", true);
        pluginGeneratedSerialDescriptor.addElement("recurring", true);
        pluginGeneratedSerialDescriptor.addElement("recurring_period", true);
        pluginGeneratedSerialDescriptor.addElement("recurring_stop_after", true);
        pluginGeneratedSerialDescriptor.addElement("survey_throttle", true);
        pluginGeneratedSerialDescriptor.addElement("hide_footer", true);
        pluginGeneratedSerialDescriptor.addElement("show_progress_bar", true);
        pluginGeneratedSerialDescriptor.addElement("navigation_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("followup_limit", true);
        pluginGeneratedSerialDescriptor.addElement("survey_language", true);
        pluginGeneratedSerialDescriptor.addElement("languages", true);
        pluginGeneratedSerialDescriptor.addElement("show_language_selector", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(SurveyMessages$$serializer.INSTANCE), StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) SurveySettings.$childSerializers[14].getValue()), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final SurveySettings deserialize(Decoder decoder) {
        Double d;
        int i;
        List list;
        String str;
        Integer num;
        Long l;
        Boolean bool;
        Integer num2;
        String str2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long j;
        Boolean bool2;
        SurveyMessages surveyMessages;
        Integer num3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = SurveySettings.$childSerializers;
        int i2 = 10;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            d = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, DoubleSerializer.INSTANCE, null);
            Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, null);
            Integer num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, null);
            SurveyMessages surveyMessages2 = (SurveyMessages) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, SurveyMessages$$serializer.INSTANCE, null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 5);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 6);
            Long l2 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, LongSerializer.INSTANCE, null);
            Integer num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, null);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 9);
            boolean zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 10);
            boolean zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 11);
            Integer num6 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, IntSerializer.INSTANCE, null);
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, null);
            i = 65535;
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 14, (DeserializationStrategy) lazyArr[14].getValue(), null);
            bool = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 15, BooleanSerializer.INSTANCE, null);
            z = zDecodeBooleanElement3;
            z2 = zDecodeBooleanElement2;
            z4 = zDecodeBooleanElement4;
            str = str3;
            surveyMessages = surveyMessages2;
            num = num6;
            j = jDecodeLongElement;
            num3 = num4;
            l = l2;
            num2 = num5;
            z3 = zDecodeBooleanElement;
            str2 = strDecodeStringElement;
            bool2 = bool3;
        } else {
            int i3 = 15;
            boolean zDecodeBooleanElement5 = false;
            boolean zDecodeBooleanElement6 = false;
            boolean zDecodeBooleanElement7 = false;
            boolean zDecodeBooleanElement8 = false;
            boolean z5 = true;
            d = null;
            SurveyMessages surveyMessages3 = null;
            Integer num7 = null;
            List list2 = null;
            String str4 = null;
            Integer num8 = null;
            Long l3 = null;
            Boolean bool4 = null;
            Integer num9 = null;
            String strDecodeStringElement2 = null;
            long jDecodeLongElement2 = 0;
            i = 0;
            Boolean bool5 = null;
            while (z5) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z5 = false;
                        i2 = 10;
                        break;
                    case 0:
                        d = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, DoubleSerializer.INSTANCE, d);
                        i |= 1;
                        i3 = 15;
                        i2 = 10;
                        break;
                    case 1:
                        bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, bool5);
                        i |= 2;
                        i3 = 15;
                        i2 = 10;
                        break;
                    case 2:
                        num7 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num7);
                        i |= 4;
                        i3 = 15;
                        i2 = 10;
                        break;
                    case 3:
                        surveyMessages3 = (SurveyMessages) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, SurveyMessages$$serializer.INSTANCE, surveyMessages3);
                        i |= 8;
                        i3 = 15;
                        i2 = 10;
                        break;
                    case 4:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
                        i |= 16;
                        i3 = 15;
                        i2 = 10;
                        break;
                    case 5:
                        zDecodeBooleanElement7 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 5);
                        i |= 32;
                        i3 = 15;
                        i2 = 10;
                        break;
                    case 6:
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 6);
                        i |= 64;
                        i3 = 15;
                        i2 = 10;
                        break;
                    case 7:
                        l3 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, LongSerializer.INSTANCE, l3);
                        i |= 128;
                        i3 = 15;
                        i2 = 10;
                        break;
                    case 8:
                        num9 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, num9);
                        i |= 256;
                        i3 = 15;
                        i2 = 10;
                        break;
                    case 9:
                        zDecodeBooleanElement6 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 9);
                        i |= 512;
                        i3 = 15;
                        i2 = 10;
                        break;
                    case 10:
                        int i4 = i2;
                        zDecodeBooleanElement5 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i4);
                        i |= 1024;
                        i2 = i4;
                        i3 = 15;
                        break;
                    case 11:
                        zDecodeBooleanElement8 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 11);
                        i |= 2048;
                        i3 = 15;
                        i2 = 10;
                        break;
                    case 12:
                        num8 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, IntSerializer.INSTANCE, num8);
                        i |= 4096;
                        i3 = 15;
                        i2 = 10;
                        break;
                    case 13:
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str4);
                        i |= 8192;
                        i3 = 15;
                        i2 = 10;
                        break;
                    case 14:
                        list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 14, (DeserializationStrategy) lazyArr[14].getValue(), list2);
                        i |= 16384;
                        i3 = 15;
                        break;
                    case 15:
                        bool4 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, BooleanSerializer.INSTANCE, bool4);
                        i |= 32768;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            list = list2;
            str = str4;
            num = num8;
            l = l3;
            bool = bool4;
            num2 = num9;
            str2 = strDecodeStringElement2;
            z = zDecodeBooleanElement5;
            z2 = zDecodeBooleanElement6;
            z3 = zDecodeBooleanElement7;
            z4 = zDecodeBooleanElement8;
            j = jDecodeLongElement2;
            bool2 = bool5;
            surveyMessages = surveyMessages3;
            num3 = num7;
        }
        int i5 = i;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SurveySettings(i5, d, bool2, num3, surveyMessages, str2, z3, j, l, num2, z2, z, z4, num, str, list, bool, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SurveySettings value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        SurveySettings.write$Self$survicate_sdk_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}

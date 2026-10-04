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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: NetworkSurvey.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/entities/survey/NetworkSurvey.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/survicate/surveys/entities/survey/NetworkSurvey;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class NetworkSurvey$$serializer implements GeneratedSerializer<NetworkSurvey> {
    public static final NetworkSurvey$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private NetworkSurvey$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        NetworkSurvey$$serializer networkSurvey$$serializer = new NetworkSurvey$$serializer();
        INSTANCE = networkSurvey$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.survicate.surveys.entities.survey.NetworkSurvey", networkSurvey$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("points", false);
        pluginGeneratedSerialDescriptor.addElement("screens", false);
        pluginGeneratedSerialDescriptor.addElement("events", false);
        pluginGeneratedSerialDescriptor.addElement("audiences_ids", false);
        pluginGeneratedSerialDescriptor.addElement("settings", false);
        pluginGeneratedSerialDescriptor.addElement("theme_id", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr = NetworkSurvey.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, lazyArr[3].getValue(), lazyArr[4].getValue(), lazyArr[5].getValue(), lazyArr[6].getValue(), SurveySettings$$serializer.INSTANCE, IntSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final NetworkSurvey deserialize(Decoder decoder) {
        List list;
        String str;
        List list2;
        String str2;
        int iDecodeIntElement;
        List list3;
        SurveySettings surveySettings;
        int i;
        String str3;
        List list4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = NetworkSurvey.$childSerializers;
        int i2 = 7;
        int i3 = 8;
        int i4 = 5;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            List list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            List list6 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
            List list7 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), null);
            list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), null);
            surveySettings = (SurveySettings) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 7, SurveySettings$$serializer.INSTANCE, null);
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 8);
            str3 = strDecodeStringElement2;
            list4 = list7;
            list2 = list5;
            list = list6;
            str2 = str4;
            str = strDecodeStringElement;
            i = 511;
        } else {
            int i5 = 3;
            int i6 = 4;
            boolean z = true;
            int iDecodeIntElement2 = 0;
            List list8 = null;
            List list9 = null;
            SurveySettings surveySettings2 = null;
            List list10 = null;
            String strDecodeStringElement3 = null;
            String str5 = null;
            String strDecodeStringElement4 = null;
            int i7 = 0;
            List list11 = null;
            while (z) {
                int i8 = i4;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                        i4 = 5;
                        i5 = 3;
                        i6 = 4;
                        break;
                    case 0:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i7 |= 1;
                        i2 = 7;
                        i3 = 8;
                        i4 = 5;
                        i5 = 3;
                        i6 = 4;
                        break;
                    case 1:
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str5);
                        i7 |= 2;
                        i2 = 7;
                        i3 = 8;
                        i4 = 5;
                        i5 = 3;
                        i6 = 4;
                        break;
                    case 2:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i7 |= 4;
                        i2 = 7;
                        i4 = 5;
                        i6 = 4;
                        break;
                    case 3:
                        list11 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i5, (DeserializationStrategy) lazyArr[i5].getValue(), list11);
                        i7 |= 8;
                        i2 = 7;
                        i4 = 5;
                        i6 = 4;
                        break;
                    case 4:
                        list10 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i6, (DeserializationStrategy) lazyArr[i6].getValue(), list10);
                        i7 |= 16;
                        i2 = 7;
                        i4 = 5;
                        break;
                    case 5:
                        list8 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i8, (DeserializationStrategy) lazyArr[i8].getValue(), list8);
                        i7 |= 32;
                        i4 = i8;
                        i2 = 7;
                        break;
                    case 6:
                        list9 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list9);
                        i7 |= 64;
                        i4 = i8;
                        break;
                    case 7:
                        surveySettings2 = (SurveySettings) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i2, SurveySettings$$serializer.INSTANCE, surveySettings2);
                        i7 |= 128;
                        i4 = i8;
                        break;
                    case 8:
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, i3);
                        i7 |= 256;
                        i4 = i8;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            String str6 = str5;
            list = list10;
            str = strDecodeStringElement3;
            list2 = list11;
            str2 = str6;
            iDecodeIntElement = iDecodeIntElement2;
            list3 = list9;
            surveySettings = surveySettings2;
            i = i7;
            str3 = strDecodeStringElement4;
            list4 = list8;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NetworkSurvey(i, str, str2, str3, list2, list, list4, list3, surveySettings, iDecodeIntElement, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, NetworkSurvey value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        NetworkSurvey.write$Self$survicate_sdk_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}

package com.survicate.surveys.entities.survey.theme.network;

import com.survicate.surveys.infrastructure.serialization.ColorSerializer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: NetworkColorScheme.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/entities/survey/theme/network/NetworkColorScheme.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkColorScheme;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class NetworkColorScheme$$serializer implements GeneratedSerializer<NetworkColorScheme> {
    public static final NetworkColorScheme$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private NetworkColorScheme$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        NetworkColorScheme$$serializer networkColorScheme$$serializer = new NetworkColorScheme$$serializer();
        INSTANCE = networkColorScheme$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.survicate.surveys.entities.survey.theme.network.NetworkColorScheme", networkColorScheme$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("question", false);
        pluginGeneratedSerialDescriptor.addElement("answer", false);
        pluginGeneratedSerialDescriptor.addElement("button", false);
        pluginGeneratedSerialDescriptor.addElement("background", false);
        pluginGeneratedSerialDescriptor.addElement("progress_bar", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ColorSerializer.INSTANCE, ColorSerializer.INSTANCE, ColorSerializer.INSTANCE, ColorSerializer.INSTANCE, ColorSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final NetworkColorScheme deserialize(Decoder decoder) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            iIntValue = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ColorSerializer.INSTANCE, 0)).intValue();
            int iIntValue4 = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ColorSerializer.INSTANCE, 0)).intValue();
            int iIntValue5 = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, ColorSerializer.INSTANCE, 0)).intValue();
            iIntValue2 = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, ColorSerializer.INSTANCE, 0)).intValue();
            iIntValue3 = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, ColorSerializer.INSTANCE, 0)).intValue();
            i = iIntValue5;
            i2 = iIntValue4;
            i3 = 31;
        } else {
            boolean z = true;
            iIntValue = 0;
            int iIntValue6 = 0;
            int iIntValue7 = 0;
            int iIntValue8 = 0;
            int iIntValue9 = 0;
            int i4 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    iIntValue = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ColorSerializer.INSTANCE, Integer.valueOf(iIntValue))).intValue();
                    i4 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    iIntValue9 = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ColorSerializer.INSTANCE, Integer.valueOf(iIntValue9))).intValue();
                    i4 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    iIntValue8 = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, ColorSerializer.INSTANCE, Integer.valueOf(iIntValue8))).intValue();
                    i4 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    iIntValue6 = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, ColorSerializer.INSTANCE, Integer.valueOf(iIntValue6))).intValue();
                    i4 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    iIntValue7 = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, ColorSerializer.INSTANCE, Integer.valueOf(iIntValue7))).intValue();
                    i4 |= 16;
                }
            }
            iIntValue2 = iIntValue6;
            iIntValue3 = iIntValue7;
            i = iIntValue8;
            i2 = iIntValue9;
            i3 = i4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NetworkColorScheme(i3, iIntValue, i2, i, iIntValue2, iIntValue3, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, NetworkColorScheme value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        NetworkColorScheme.write$Self$survicate_sdk_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}

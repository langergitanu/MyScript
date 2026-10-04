package com.survicate.surveys.entities.survey.theme.network;

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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: NetworkTheme.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/entities/survey/theme/network/NetworkTheme.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/survicate/surveys/entities/survey/theme/network/NetworkTheme;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class NetworkTheme$$serializer implements GeneratedSerializer<NetworkTheme> {
    public static final NetworkTheme$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private NetworkTheme$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        NetworkTheme$$serializer networkTheme$$serializer = new NetworkTheme$$serializer();
        INSTANCE = networkTheme$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.survicate.surveys.entities.survey.theme.network.NetworkTheme", networkTheme$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("has_dark_mode", false);
        pluginGeneratedSerialDescriptor.addElement("color_scheme", false);
        pluginGeneratedSerialDescriptor.addElement("color_scheme_dark", false);
        pluginGeneratedSerialDescriptor.addElement("settings", false);
        pluginGeneratedSerialDescriptor.addElement("settings_dark", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, NetworkTheme.$childSerializers[1].getValue(), BooleanSerializer.INSTANCE, NetworkColorScheme$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(NetworkColorScheme$$serializer.INSTANCE), NetworkThemeSettings$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(NetworkThemeSettings$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final NetworkTheme deserialize(Decoder decoder) {
        int iDecodeIntElement;
        NetworkColorScheme networkColorScheme;
        NetworkColorScheme networkColorScheme2;
        NetworkThemeSettings networkThemeSettings;
        NetworkThemeSettings networkThemeSettings2;
        int i;
        NetworkThemeType networkThemeType;
        boolean z;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = NetworkTheme.$childSerializers;
        int i2 = 6;
        int i3 = 5;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
            NetworkThemeType networkThemeType2 = (NetworkThemeType) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
            NetworkColorScheme networkColorScheme3 = (NetworkColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, NetworkColorScheme$$serializer.INSTANCE, null);
            NetworkColorScheme networkColorScheme4 = (NetworkColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, NetworkColorScheme$$serializer.INSTANCE, null);
            NetworkThemeSettings networkThemeSettings3 = (NetworkThemeSettings) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, NetworkThemeSettings$$serializer.INSTANCE, null);
            networkThemeType = networkThemeType2;
            networkThemeSettings = (NetworkThemeSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, NetworkThemeSettings$$serializer.INSTANCE, null);
            networkThemeSettings2 = networkThemeSettings3;
            networkColorScheme = networkColorScheme3;
            networkColorScheme2 = networkColorScheme4;
            z = zDecodeBooleanElement;
            i = 127;
        } else {
            boolean z2 = true;
            iDecodeIntElement = 0;
            int i4 = 0;
            NetworkThemeSettings networkThemeSettings4 = null;
            NetworkThemeType networkThemeType3 = null;
            networkColorScheme = null;
            networkColorScheme2 = null;
            boolean zDecodeBooleanElement2 = false;
            NetworkThemeSettings networkThemeSettings5 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        i2 = 6;
                        break;
                    case 0:
                        iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                        i4 |= 1;
                        i2 = 6;
                        i3 = 5;
                        break;
                    case 1:
                        networkThemeType3 = (NetworkThemeType) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), networkThemeType3);
                        i4 |= 2;
                        i2 = 6;
                        i3 = 5;
                        break;
                    case 2:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
                        i4 |= 4;
                        break;
                    case 3:
                        networkColorScheme = (NetworkColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, NetworkColorScheme$$serializer.INSTANCE, networkColorScheme);
                        i4 |= 8;
                        break;
                    case 4:
                        networkColorScheme2 = (NetworkColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, NetworkColorScheme$$serializer.INSTANCE, networkColorScheme2);
                        i4 |= 16;
                        break;
                    case 5:
                        networkThemeSettings5 = (NetworkThemeSettings) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i3, NetworkThemeSettings$$serializer.INSTANCE, networkThemeSettings5);
                        i4 |= 32;
                        break;
                    case 6:
                        networkThemeSettings4 = (NetworkThemeSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, NetworkThemeSettings$$serializer.INSTANCE, networkThemeSettings4);
                        i4 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            networkThemeSettings = networkThemeSettings4;
            networkThemeSettings2 = networkThemeSettings5;
            i = i4;
            networkThemeType = networkThemeType3;
            z = zDecodeBooleanElement2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NetworkTheme(i, iDecodeIntElement, networkThemeType, z, networkColorScheme, networkColorScheme2, networkThemeSettings2, networkThemeSettings, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, NetworkTheme value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        NetworkTheme.write$Self$survicate_sdk_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}

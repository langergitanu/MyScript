package com.survicate.surveys.infrastructure.network;

import com.survicate.surveys.infrastructure.serialization.TranslationsSerializer;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: NetworkWorkspace.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/infrastructure/network/NetworkWorkspace.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/survicate/surveys/infrastructure/network/NetworkWorkspace;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class NetworkWorkspace$$serializer implements GeneratedSerializer<NetworkWorkspace> {
    public static final NetworkWorkspace$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private NetworkWorkspace$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        NetworkWorkspace$$serializer networkWorkspace$$serializer = new NetworkWorkspace$$serializer();
        INSTANCE = networkWorkspace$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.survicate.surveys.infrastructure.network.NetworkWorkspace", networkWorkspace$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("surveys", true);
        pluginGeneratedSerialDescriptor.addElement("themes", true);
        pluginGeneratedSerialDescriptor.addElement("audiences", true);
        pluginGeneratedSerialDescriptor.addElement("installing", false);
        pluginGeneratedSerialDescriptor.addElement("integrations", true);
        pluginGeneratedSerialDescriptor.addElement("panel_answer_url", false);
        pluginGeneratedSerialDescriptor.addElement("targeting_events", true);
        pluginGeneratedSerialDescriptor.addElement("targeting_events_enabled", false);
        pluginGeneratedSerialDescriptor.addElement("backend_targeting_enabled", false);
        pluginGeneratedSerialDescriptor.addElement("enforce_user_authentication", false);
        pluginGeneratedSerialDescriptor.addElement("translations", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr = NetworkWorkspace.$childSerializers;
        return new KSerializer[]{lazyArr[0].getValue(), lazyArr[1].getValue(), lazyArr[2].getValue(), BooleanSerializer.INSTANCE, lazyArr[4].getValue(), StringSerializer.INSTANCE, lazyArr[6].getValue(), BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(TranslationsSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final NetworkWorkspace deserialize(Decoder decoder) {
        boolean z;
        List list;
        List list2;
        int i;
        boolean z2;
        List list3;
        List list4;
        List list5;
        boolean z3;
        boolean z4;
        String str;
        List list6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = NetworkWorkspace.$childSerializers;
        int i2 = 10;
        int i3 = 9;
        int i4 = 7;
        int i5 = 0;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list7 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            List list8 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
            List list9 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 5);
            List list10 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), null);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 7);
            boolean zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 8);
            boolean zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 9);
            list6 = list10;
            list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, TranslationsSerializer.INSTANCE, null);
            z = zDecodeBooleanElement4;
            z3 = zDecodeBooleanElement2;
            str = strDecodeStringElement;
            z2 = zDecodeBooleanElement3;
            i = 2047;
            list4 = list9;
            list3 = list8;
            list = list7;
            z4 = zDecodeBooleanElement;
        } else {
            int i6 = 4;
            int i7 = 2;
            int i8 = 1;
            boolean z5 = true;
            boolean zDecodeBooleanElement5 = false;
            boolean zDecodeBooleanElement6 = false;
            boolean zDecodeBooleanElement7 = false;
            List list11 = null;
            List list12 = null;
            List list13 = null;
            List list14 = null;
            List list15 = null;
            List list16 = null;
            String strDecodeStringElement2 = null;
            boolean zDecodeBooleanElement8 = false;
            while (z5) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z5 = false;
                        i3 = 9;
                        i4 = 7;
                        i8 = 1;
                        i7 = 2;
                        i6 = 4;
                        break;
                    case 0:
                        i5 |= 1;
                        list15 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list15);
                        i2 = 10;
                        i3 = 9;
                        i4 = 7;
                        i8 = 1;
                        i7 = 2;
                        i6 = 4;
                        break;
                    case 1:
                        i5 |= 2;
                        list16 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i8, (DeserializationStrategy) lazyArr[i8].getValue(), list16);
                        i2 = 10;
                        i3 = 9;
                        i4 = 7;
                        i7 = 2;
                        i6 = 4;
                        break;
                    case 2:
                        list14 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i7, (DeserializationStrategy) lazyArr[i7].getValue(), list14);
                        i5 |= 4;
                        i2 = 10;
                        i3 = 9;
                        i6 = 4;
                        break;
                    case 3:
                        zDecodeBooleanElement6 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i5 |= 8;
                        i2 = 10;
                        i3 = 9;
                        break;
                    case 4:
                        list13 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i6, (DeserializationStrategy) lazyArr[i6].getValue(), list13);
                        i5 |= 16;
                        i2 = 10;
                        i3 = 9;
                        break;
                    case 5:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 5);
                        i5 |= 32;
                        break;
                    case 6:
                        list11 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list11);
                        i5 |= 64;
                        break;
                    case 7:
                        zDecodeBooleanElement8 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i4);
                        i5 |= 128;
                        break;
                    case 8:
                        zDecodeBooleanElement7 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 8);
                        i5 |= 256;
                        break;
                    case 9:
                        zDecodeBooleanElement5 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i3);
                        i5 |= 512;
                        break;
                    case 10:
                        list12 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, TranslationsSerializer.INSTANCE, list12);
                        i5 |= 1024;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            List list17 = list16;
            z = zDecodeBooleanElement5;
            list = list15;
            list2 = list12;
            i = i5;
            z2 = zDecodeBooleanElement7;
            list3 = list17;
            list4 = list13;
            list5 = list14;
            z3 = zDecodeBooleanElement8;
            z4 = zDecodeBooleanElement6;
            str = strDecodeStringElement2;
            list6 = list11;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NetworkWorkspace(i, list, list3, list5, z4, list4, str, list6, z3, z2, z, list2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, NetworkWorkspace value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        NetworkWorkspace.write$Self$survicate_sdk_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}

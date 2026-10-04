package com.revenuecat.purchases.common.remoteconfig;

import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: RemoteConfiguration.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/common/remoteconfig/RemoteConfiguration.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfiguration;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class RemoteConfiguration$$serializer implements GeneratedSerializer<RemoteConfiguration> {
    public static final RemoteConfiguration$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        RemoteConfiguration$$serializer remoteConfiguration$$serializer = new RemoteConfiguration$$serializer();
        INSTANCE = remoteConfiguration$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.remoteconfig.RemoteConfiguration", remoteConfiguration$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement(ClientCookie.DOMAIN_ATTR, false);
        pluginGeneratedSerialDescriptor.addElement("subdomains", true);
        pluginGeneratedSerialDescriptor.addElement("app_uuid", true);
        pluginGeneratedSerialDescriptor.addElement("manifest", false);
        pluginGeneratedSerialDescriptor.addElement("active_topics", true);
        pluginGeneratedSerialDescriptor.addElement("prefetch_blobs", true);
        pluginGeneratedSerialDescriptor.addElement("topics", true);
        pluginGeneratedSerialDescriptor.addElement("state_hash", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RemoteConfiguration$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = RemoteConfiguration.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, kSerializerArr[1], BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, kSerializerArr[4], kSerializerArr[5], kSerializerArr[6], BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public RemoteConfiguration deserialize(Decoder decoder) {
        List list;
        String str;
        String strDecodeStringElement;
        String str2;
        Map map;
        List list2;
        List list3;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = RemoteConfiguration.$childSerializers;
        int i3 = 7;
        int i4 = 6;
        int i5 = 4;
        String strDecodeStringElement2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            List list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], null);
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            List list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            List list6 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            map = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, kSerializerArr[6], null);
            strDecodeStringElement2 = strDecodeStringElement3;
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            strDecodeStringElement = strDecodeStringElement4;
            str = str3;
            i = 255;
            list2 = list6;
            list3 = list5;
            list = list4;
        } else {
            boolean z = true;
            int i6 = 0;
            String str4 = null;
            Map map2 = null;
            List list7 = null;
            List list8 = null;
            list = null;
            str = null;
            strDecodeStringElement = null;
            while (z) {
                int i7 = i5;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 7;
                        i5 = 4;
                        break;
                    case 0:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i6 |= 1;
                        i3 = 7;
                        i4 = 6;
                        i5 = 4;
                        break;
                    case 1:
                        list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], list);
                        i6 |= 2;
                        i3 = 7;
                        i4 = 6;
                        i5 = 4;
                        break;
                    case 2:
                        str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str);
                        i6 |= 4;
                        i3 = 7;
                        i4 = 6;
                        i5 = 4;
                        break;
                    case 3:
                        i2 = i7;
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                        i6 |= 8;
                        i5 = i2;
                        i3 = 7;
                        break;
                    case 4:
                        i2 = i7;
                        list8 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i2, kSerializerArr[i7], list8);
                        i6 |= 16;
                        i5 = i2;
                        i3 = 7;
                        break;
                    case 5:
                        list7 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], list7);
                        i6 |= 32;
                        i5 = i7;
                        break;
                    case 6:
                        map2 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i4, kSerializerArr[i4], map2);
                        i6 |= 64;
                        i5 = i7;
                        break;
                    case 7:
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, StringSerializer.INSTANCE, str4);
                        i6 |= 128;
                        i5 = i7;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str2 = str4;
            map = map2;
            list2 = list7;
            list3 = list8;
            i = i6;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new RemoteConfiguration(i, strDecodeStringElement2, list, str, strDecodeStringElement, list3, list2, map, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, RemoteConfiguration value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        RemoteConfiguration.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

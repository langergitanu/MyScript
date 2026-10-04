package com.revenuecat.purchases.common.events;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.BackendEvent;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: BackendEvent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/common/events/BackendEvent.Ad.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class BackendEvent$Ad$$serializer implements GeneratedSerializer<BackendEvent.C7172Ad> {
    public static final BackendEvent$Ad$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        BackendEvent$Ad$$serializer backendEvent$Ad$$serializer = new BackendEvent$Ad$$serializer();
        INSTANCE = backendEvent$Ad$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ad", backendEvent$Ad$$serializer, 23);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("version", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("timestamp_ms", false);
        pluginGeneratedSerialDescriptor.addElement("network_name", true);
        pluginGeneratedSerialDescriptor.addElement("mediator_name", false);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.AD_FORMAT, true);
        pluginGeneratedSerialDescriptor.addElement("placement", false);
        pluginGeneratedSerialDescriptor.addElement("ad_unit_id", false);
        pluginGeneratedSerialDescriptor.addElement("impression_id", false);
        pluginGeneratedSerialDescriptor.addElement("app_user_id", false);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.APP_SESSION_ID_KEY, false);
        pluginGeneratedSerialDescriptor.addElement("capture_method", true);
        pluginGeneratedSerialDescriptor.addElement("revenue_micros", true);
        pluginGeneratedSerialDescriptor.addElement("currency", true);
        pluginGeneratedSerialDescriptor.addElement("precision", true);
        pluginGeneratedSerialDescriptor.addElement("mediator_error_code", true);
        pluginGeneratedSerialDescriptor.addElement("reward_verification_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("reward_type", true);
        pluginGeneratedSerialDescriptor.addElement("reward_virtual_currency_code", true);
        pluginGeneratedSerialDescriptor.addElement("reward_virtual_currency_amount", true);
        pluginGeneratedSerialDescriptor.addElement("reward_entitlement_id", true);
        pluginGeneratedSerialDescriptor.addElement("reward_failure_reason", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BackendEvent$Ad$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public BackendEvent.C7172Ad deserialize(Decoder decoder) {
        Integer num;
        String str;
        String str2;
        Boolean bool;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        long j;
        Integer num2;
        String str12;
        String str13;
        int i;
        String str14;
        String str15;
        String str16;
        Long l;
        int i2;
        String str17;
        Integer num3;
        String str18;
        int i3;
        int i4;
        Integer num4;
        Long l2;
        String str19;
        Integer num5;
        Long l3;
        String str20;
        String str21;
        Integer num6;
        Long l4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 3);
            String str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
            String str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, null);
            String str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
            String str25 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, null);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 10);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 11);
            String str26 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, null);
            Long l5 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, LongSerializer.INSTANCE, null);
            String str27 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, null);
            String str28 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, null);
            Integer num7 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, IntSerializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 17, BooleanSerializer.INSTANCE, null);
            String str29 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 18, StringSerializer.INSTANCE, null);
            String str30 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 19, StringSerializer.INSTANCE, null);
            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 20, IntSerializer.INSTANCE, null);
            String str31 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 21, StringSerializer.INSTANCE, null);
            str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 22, StringSerializer.INSTANCE, null);
            str17 = str22;
            str14 = str30;
            str2 = str29;
            bool = bool2;
            num2 = num7;
            str13 = str31;
            str5 = strDecodeStringElement3;
            str9 = str23;
            str6 = strDecodeStringElement4;
            str10 = str24;
            i = 8388607;
            str3 = str28;
            str16 = strDecodeStringElement;
            str11 = str25;
            str = str26;
            j = jDecodeLongElement;
            str15 = str27;
            l = l5;
            str8 = strDecodeStringElement6;
            str7 = strDecodeStringElement5;
            str4 = strDecodeStringElement2;
            i2 = iDecodeIntElement;
        } else {
            boolean z = true;
            int iDecodeIntElement2 = 0;
            Integer num8 = null;
            Long l6 = null;
            String str32 = null;
            String str33 = null;
            Integer num9 = null;
            String str34 = null;
            String str35 = null;
            String str36 = null;
            String str37 = null;
            Boolean bool3 = null;
            String str38 = null;
            String str39 = null;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            String strDecodeStringElement9 = null;
            String strDecodeStringElement10 = null;
            String str40 = null;
            String str41 = null;
            long jDecodeLongElement2 = 0;
            int i5 = 0;
            String str42 = null;
            String strDecodeStringElement11 = null;
            String strDecodeStringElement12 = null;
            while (z) {
                String str43 = str34;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        num4 = num8;
                        l2 = l6;
                        str19 = str32;
                        z = false;
                        str34 = str43;
                        str32 = str19;
                        l6 = l2;
                        num8 = num4;
                        break;
                    case 0:
                        num5 = num8;
                        l3 = l6;
                        str20 = str32;
                        str21 = str43;
                        strDecodeStringElement11 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i5 |= 1;
                        num8 = num5;
                        str34 = str21;
                        str32 = str20;
                        l6 = l3;
                        break;
                    case 1:
                        num5 = num8;
                        l3 = l6;
                        str20 = str32;
                        str21 = str43;
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
                        i5 |= 2;
                        num8 = num5;
                        str34 = str21;
                        str32 = str20;
                        l6 = l3;
                        break;
                    case 2:
                        num5 = num8;
                        l3 = l6;
                        str20 = str32;
                        str21 = str43;
                        strDecodeStringElement12 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i5 |= 4;
                        num8 = num5;
                        str34 = str21;
                        str32 = str20;
                        l6 = l3;
                        break;
                    case 3:
                        num5 = num8;
                        l3 = l6;
                        str20 = str32;
                        str21 = str43;
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(descriptor2, 3);
                        i5 |= 8;
                        num8 = num5;
                        str34 = str21;
                        str32 = str20;
                        l6 = l3;
                        break;
                    case 4:
                        l3 = l6;
                        str20 = str32;
                        str21 = str43;
                        str40 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str40);
                        i5 |= 16;
                        num8 = num8;
                        str41 = str41;
                        str34 = str21;
                        str32 = str20;
                        l6 = l3;
                        break;
                    case 5:
                        num5 = num8;
                        l3 = l6;
                        str20 = str32;
                        str21 = str43;
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
                        i5 |= 32;
                        num8 = num5;
                        str34 = str21;
                        str32 = str20;
                        l6 = l3;
                        break;
                    case 6:
                        num5 = num8;
                        l3 = l6;
                        str20 = str32;
                        str21 = str43;
                        str41 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str41);
                        i5 |= 64;
                        num8 = num5;
                        str34 = str21;
                        str32 = str20;
                        l6 = l3;
                        break;
                    case 7:
                        num4 = num8;
                        l2 = l6;
                        str19 = str32;
                        i5 |= 128;
                        str34 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str43);
                        str32 = str19;
                        l6 = l2;
                        num8 = num4;
                        break;
                    case 8:
                        num6 = num8;
                        l4 = l6;
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
                        i5 |= 256;
                        num8 = num6;
                        l6 = l4;
                        str34 = str43;
                        break;
                    case 9:
                        num6 = num8;
                        l4 = l6;
                        str32 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, str32);
                        i5 |= 512;
                        num8 = num6;
                        l6 = l4;
                        str34 = str43;
                        break;
                    case 10:
                        num3 = num8;
                        str18 = str32;
                        strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 10);
                        i5 |= 1024;
                        num8 = num3;
                        str34 = str43;
                        str32 = str18;
                        break;
                    case 11:
                        num3 = num8;
                        str18 = str32;
                        strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 11);
                        i5 |= 2048;
                        num8 = num3;
                        str34 = str43;
                        str32 = str18;
                        break;
                    case 12:
                        num3 = num8;
                        str18 = str32;
                        str33 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, str33);
                        i5 |= 4096;
                        num8 = num3;
                        str34 = str43;
                        str32 = str18;
                        break;
                    case 13:
                        num3 = num8;
                        str18 = str32;
                        l6 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, LongSerializer.INSTANCE, l6);
                        i5 |= 8192;
                        num8 = num3;
                        str34 = str43;
                        str32 = str18;
                        break;
                    case 14:
                        num3 = num8;
                        str18 = str32;
                        str39 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, str39);
                        i5 |= 16384;
                        num8 = num3;
                        str34 = str43;
                        str32 = str18;
                        break;
                    case 15:
                        num3 = num8;
                        str18 = str32;
                        str38 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, str38);
                        i3 = 32768;
                        i5 |= i3;
                        num8 = num3;
                        str34 = str43;
                        str32 = str18;
                        break;
                    case 16:
                        num3 = num8;
                        str18 = str32;
                        num9 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, IntSerializer.INSTANCE, num9);
                        i3 = 65536;
                        i5 |= i3;
                        num8 = num3;
                        str34 = str43;
                        str32 = str18;
                        break;
                    case 17:
                        num3 = num8;
                        str18 = str32;
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 17, BooleanSerializer.INSTANCE, bool3);
                        i3 = 131072;
                        i5 |= i3;
                        num8 = num3;
                        str34 = str43;
                        str32 = str18;
                        break;
                    case 18:
                        num3 = num8;
                        str18 = str32;
                        str37 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 18, StringSerializer.INSTANCE, str37);
                        i3 = 262144;
                        i5 |= i3;
                        num8 = num3;
                        str34 = str43;
                        str32 = str18;
                        break;
                    case 19:
                        str18 = str32;
                        num3 = num8;
                        str36 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 19, StringSerializer.INSTANCE, str36);
                        i3 = 524288;
                        i5 |= i3;
                        num8 = num3;
                        str34 = str43;
                        str32 = str18;
                        break;
                    case 20:
                        str18 = str32;
                        num8 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 20, IntSerializer.INSTANCE, num8);
                        i4 = 1048576;
                        i5 |= i4;
                        str34 = str43;
                        str32 = str18;
                        break;
                    case 21:
                        str18 = str32;
                        str42 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 21, StringSerializer.INSTANCE, str42);
                        i4 = 2097152;
                        i5 |= i4;
                        str34 = str43;
                        str32 = str18;
                        break;
                    case 22:
                        str18 = str32;
                        str35 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 22, StringSerializer.INSTANCE, str35);
                        i4 = 4194304;
                        i5 |= i4;
                        str34 = str43;
                        str32 = str18;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            num = num8;
            str = str33;
            str2 = str37;
            bool = bool3;
            str3 = str38;
            str4 = strDecodeStringElement12;
            str5 = strDecodeStringElement7;
            str6 = strDecodeStringElement8;
            str7 = strDecodeStringElement9;
            str8 = strDecodeStringElement10;
            str9 = str41;
            str10 = str34;
            str11 = str32;
            j = jDecodeLongElement2;
            num2 = num9;
            str12 = str35;
            str13 = str42;
            i = i5;
            str14 = str36;
            str15 = str39;
            str16 = strDecodeStringElement11;
            l = l6;
            i2 = iDecodeIntElement2;
            str17 = str40;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new BackendEvent.C7172Ad(i, str16, i2, str4, j, str17, str5, str9, str10, str6, str11, str7, str8, str, l, str15, str3, num2, bool, str2, str14, num, str13, str12, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, BackendEvent.C7172Ad value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        BackendEvent.C7172Ad.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

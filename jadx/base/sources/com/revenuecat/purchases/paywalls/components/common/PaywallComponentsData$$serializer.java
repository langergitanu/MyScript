package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.utils.serializers.DefaultLocaleIdSerializer;
import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PaywallComponentsData.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/paywalls/components/common/PaywallComponentsData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PaywallComponentsData$$serializer implements GeneratedSerializer<PaywallComponentsData> {
    public static final PaywallComponentsData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallComponentsData$$serializer paywallComponentsData$$serializer = new PaywallComponentsData$$serializer();
        INSTANCE = paywallComponentsData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData", paywallComponentsData$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("template_name", false);
        pluginGeneratedSerialDescriptor.addElement("asset_base_url", false);
        pluginGeneratedSerialDescriptor.addElement("components_config", false);
        pluginGeneratedSerialDescriptor.addElement("components_localizations", false);
        pluginGeneratedSerialDescriptor.addElement("default_locale", true);
        pluginGeneratedSerialDescriptor.addElement("revision", true);
        pluginGeneratedSerialDescriptor.addElement("zero_decimal_place_countries", true);
        pluginGeneratedSerialDescriptor.addElement("exit_offers", true);
        pluginGeneratedSerialDescriptor.addElement("play_store_product_change_mode", true);
        pluginGeneratedSerialDescriptor.addElement("automatically_scale_font_size", true);
        pluginGeneratedSerialDescriptor.addElement("state_declarations", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallComponentsData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, URLSerializer.INSTANCE, ComponentsConfig$$serializer.INSTANCE, PaywallComponentsData.$childSerializers[4], DefaultLocaleIdSerializer.INSTANCE, IntSerializer.INSTANCE, GoogleListSerializer.INSTANCE, BuiltinSerializersKt.getNullable(ExitOffers$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ProductChangeConfigSerializer.INSTANCE), BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StateDeclarationMapSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallComponentsData deserialize(Decoder decoder) {
        Map map;
        ExitOffers exitOffers;
        List list;
        int i;
        Map map2;
        String str;
        String str2;
        ComponentsConfig componentsConfig;
        String str3;
        boolean z;
        int i2;
        ProductChangeConfig productChangeConfig;
        URL url;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = PaywallComponentsData.$childSerializers;
        int i3 = 10;
        int i4 = 9;
        int i5 = 7;
        int i6 = 6;
        Map map3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            URL url2 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, URLSerializer.INSTANCE, null);
            ComponentsConfig componentsConfig2 = (ComponentsConfig) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, ComponentsConfig$$serializer.INSTANCE, null);
            Map map4 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            LocaleId localeId = (LocaleId) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, DefaultLocaleIdSerializer.INSTANCE, null);
            String strM13803unboximpl = localeId != null ? localeId.m13803unboximpl() : null;
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 6);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, GoogleListSerializer.INSTANCE, null);
            ExitOffers exitOffers2 = (ExitOffers) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, ExitOffers$$serializer.INSTANCE, null);
            ProductChangeConfig productChangeConfig2 = (ProductChangeConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, ProductChangeConfigSerializer.INSTANCE, null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 10);
            map = map4;
            map2 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StateDeclarationMapSerializer.INSTANCE, null);
            z = zDecodeBooleanElement;
            productChangeConfig = productChangeConfig2;
            list = list2;
            i2 = iDecodeIntElement;
            str = strM13803unboximpl;
            componentsConfig = componentsConfig2;
            exitOffers = exitOffers2;
            i = 4095;
            str2 = strDecodeStringElement;
            url = url2;
            str3 = str4;
        } else {
            int i7 = 11;
            ExitOffers exitOffers3 = null;
            List list3 = null;
            String str5 = null;
            String strM13803unboximpl2 = null;
            ComponentsConfig componentsConfig3 = null;
            URL url3 = null;
            String strDecodeStringElement2 = null;
            boolean z2 = true;
            int i8 = 0;
            boolean zDecodeBooleanElement2 = false;
            int iDecodeIntElement2 = 0;
            ProductChangeConfig productChangeConfig3 = null;
            Map map5 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        i3 = 10;
                        i4 = 9;
                        i5 = 7;
                        i6 = 6;
                        break;
                    case 0:
                        i8 |= 1;
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str5);
                        i7 = 11;
                        i3 = 10;
                        i4 = 9;
                        i5 = 7;
                        i6 = 6;
                        break;
                    case 1:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i8 |= 2;
                        i7 = 11;
                        i3 = 10;
                        i4 = 9;
                        i5 = 7;
                        break;
                    case 2:
                        url3 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, URLSerializer.INSTANCE, url3);
                        i8 |= 4;
                        i7 = 11;
                        i3 = 10;
                        i4 = 9;
                        i5 = 7;
                        break;
                    case 3:
                        i8 |= 8;
                        componentsConfig3 = (ComponentsConfig) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, ComponentsConfig$$serializer.INSTANCE, componentsConfig3);
                        i7 = 11;
                        i3 = 10;
                        i4 = 9;
                        break;
                    case 4:
                        map3 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], map3);
                        i8 |= 16;
                        i7 = 11;
                        i3 = 10;
                        break;
                    case 5:
                        LocaleId localeId2 = (LocaleId) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, DefaultLocaleIdSerializer.INSTANCE, strM13803unboximpl2 != null ? LocaleId.m13797boximpl(strM13803unboximpl2) : null);
                        strM13803unboximpl2 = localeId2 != null ? localeId2.m13803unboximpl() : null;
                        i8 |= 32;
                        i7 = 11;
                        i3 = 10;
                        break;
                    case 6:
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, i6);
                        i8 |= 64;
                        break;
                    case 7:
                        list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i5, GoogleListSerializer.INSTANCE, list3);
                        i8 |= 128;
                        break;
                    case 8:
                        exitOffers3 = (ExitOffers) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, ExitOffers$$serializer.INSTANCE, exitOffers3);
                        i8 |= 256;
                        break;
                    case 9:
                        productChangeConfig3 = (ProductChangeConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i4, ProductChangeConfigSerializer.INSTANCE, productChangeConfig3);
                        i8 |= 512;
                        break;
                    case 10:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, i3);
                        i8 |= 1024;
                        break;
                    case 11:
                        map5 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i7, StateDeclarationMapSerializer.INSTANCE, map5);
                        i8 |= 2048;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            String str6 = str5;
            ComponentsConfig componentsConfig4 = componentsConfig3;
            map = map3;
            exitOffers = exitOffers3;
            list = list3;
            i = i8;
            map2 = map5;
            str = strM13803unboximpl2;
            str2 = strDecodeStringElement2;
            componentsConfig = componentsConfig4;
            str3 = str6;
            z = zDecodeBooleanElement2;
            i2 = iDecodeIntElement2;
            productChangeConfig = productChangeConfig3;
            url = url3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PaywallComponentsData(i, str3, str2, url, componentsConfig, map, str, i2, list, exitOffers, productChangeConfig, z, map2, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallComponentsData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PaywallComponentsData.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

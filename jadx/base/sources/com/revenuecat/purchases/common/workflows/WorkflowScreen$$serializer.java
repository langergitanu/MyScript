package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.checkpoints.CheckpointWorkflowResolverImpl;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig$$serializer;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers$$serializer;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfigSerializer;
import com.revenuecat.purchases.paywalls.components.common.StateDeclarationMapSerializer;
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
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* JADX INFO: compiled from: WorkflowModels.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/common/workflows/WorkflowScreen.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/workflows/WorkflowScreen;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class WorkflowScreen$$serializer implements GeneratedSerializer<WorkflowScreen> {
    public static final WorkflowScreen$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WorkflowScreen$$serializer workflowScreen$$serializer = new WorkflowScreen$$serializer();
        INSTANCE = workflowScreen$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.workflows.WorkflowScreen", workflowScreen$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("template_name", false);
        pluginGeneratedSerialDescriptor.addElement("revision", true);
        pluginGeneratedSerialDescriptor.addElement("asset_base_url", false);
        pluginGeneratedSerialDescriptor.addElement("components_config", false);
        pluginGeneratedSerialDescriptor.addElement("components_localizations", false);
        pluginGeneratedSerialDescriptor.addElement("default_locale", true);
        pluginGeneratedSerialDescriptor.addElement("config", true);
        pluginGeneratedSerialDescriptor.addElement(CheckpointWorkflowResolverImpl.OFFERING_IDENTIFIER_PARAM, true);
        pluginGeneratedSerialDescriptor.addElement("zero_decimal_place_countries", true);
        pluginGeneratedSerialDescriptor.addElement("exit_offers", true);
        pluginGeneratedSerialDescriptor.addElement("play_store_product_change_mode", true);
        pluginGeneratedSerialDescriptor.addElement("automatically_scale_font_size", true);
        pluginGeneratedSerialDescriptor.addElement("state_declarations", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WorkflowScreen$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, IntSerializer.INSTANCE, URLSerializer.INSTANCE, ComponentsConfig$$serializer.INSTANCE, WorkflowScreen.$childSerializers[5], DefaultLocaleIdSerializer.INSTANCE, JsonObjectSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), GoogleListSerializer.INSTANCE, BuiltinSerializersKt.getNullable(ExitOffers$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ProductChangeConfigSerializer.INSTANCE), BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StateDeclarationMapSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WorkflowScreen deserialize(Decoder decoder) {
        ExitOffers exitOffers;
        int i;
        Map map;
        Map map2;
        ComponentsConfig componentsConfig;
        String str;
        ProductChangeConfig productChangeConfig;
        List list;
        JsonObject jsonObject;
        String str2;
        String str3;
        boolean z;
        int i2;
        String str4;
        URL url;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = WorkflowScreen.$childSerializers;
        int i3 = 10;
        int i4 = 9;
        char c = '\b';
        Map map3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 2);
            URL url2 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, URLSerializer.INSTANCE, null);
            ComponentsConfig componentsConfig2 = (ComponentsConfig) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, ComponentsConfig$$serializer.INSTANCE, null);
            Map map4 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            LocaleId localeId = (LocaleId) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, DefaultLocaleIdSerializer.INSTANCE, null);
            String strM13803unboximpl = localeId != null ? localeId.m13803unboximpl() : null;
            JsonObject jsonObject2 = (JsonObject) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, JsonObjectSerializer.INSTANCE, null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 9, GoogleListSerializer.INSTANCE, null);
            ExitOffers exitOffers2 = (ExitOffers) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, ExitOffers$$serializer.INSTANCE, null);
            ProductChangeConfig productChangeConfig2 = (ProductChangeConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, ProductChangeConfigSerializer.INSTANCE, null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 12);
            map2 = map4;
            map = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StateDeclarationMapSerializer.INSTANCE, null);
            exitOffers = exitOffers2;
            list = list2;
            jsonObject = jsonObject2;
            str3 = strM13803unboximpl;
            str4 = str6;
            productChangeConfig = productChangeConfig2;
            z = zDecodeBooleanElement;
            i = iDecodeIntElement;
            str = str5;
            url = url2;
            componentsConfig = componentsConfig2;
            str2 = strDecodeStringElement;
            i2 = 16383;
        } else {
            int i5 = 13;
            int iDecodeIntElement2 = 0;
            boolean zDecodeBooleanElement2 = false;
            boolean z2 = true;
            ProductChangeConfig productChangeConfig3 = null;
            List list3 = null;
            JsonObject jsonObject3 = null;
            ExitOffers exitOffers3 = null;
            String str7 = null;
            String strDecodeStringElement2 = null;
            String strM13803unboximpl2 = null;
            URL url3 = null;
            ComponentsConfig componentsConfig3 = null;
            int i6 = 5;
            int i7 = 0;
            Map map5 = null;
            String str8 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        i3 = 10;
                        i4 = 9;
                        c = '\b';
                        i6 = 5;
                        break;
                    case 0:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str7);
                        i7 |= 1;
                        i5 = 13;
                        i3 = 10;
                        i4 = 9;
                        c = '\b';
                        i6 = 5;
                        break;
                    case 1:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i7 |= 2;
                        i5 = 13;
                        i3 = 10;
                        i4 = 9;
                        c = '\b';
                        i6 = 5;
                        break;
                    case 2:
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 2);
                        i7 |= 4;
                        i5 = 13;
                        i3 = 10;
                        i4 = 9;
                        c = '\b';
                        i6 = 5;
                        break;
                    case 3:
                        url3 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, URLSerializer.INSTANCE, url3);
                        i7 |= 8;
                        i5 = 13;
                        i3 = 10;
                        i4 = 9;
                        c = '\b';
                        i6 = 5;
                        break;
                    case 4:
                        componentsConfig3 = (ComponentsConfig) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, ComponentsConfig$$serializer.INSTANCE, componentsConfig3);
                        i7 |= 16;
                        i5 = 13;
                        i3 = 10;
                        i4 = 9;
                        c = '\b';
                        i6 = 5;
                        break;
                    case 5:
                        map3 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i6, kSerializerArr[i6], map3);
                        i7 |= 32;
                        i5 = 13;
                        i3 = 10;
                        i4 = 9;
                        c = '\b';
                        break;
                    case 6:
                        LocaleId localeId2 = (LocaleId) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, DefaultLocaleIdSerializer.INSTANCE, strM13803unboximpl2 != null ? LocaleId.m13797boximpl(strM13803unboximpl2) : null);
                        strM13803unboximpl2 = localeId2 != null ? localeId2.m13803unboximpl() : null;
                        i7 |= 64;
                        i5 = 13;
                        i3 = 10;
                        i4 = 9;
                        c = '\b';
                        break;
                    case 7:
                        jsonObject3 = (JsonObject) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, JsonObjectSerializer.INSTANCE, jsonObject3);
                        i7 |= 128;
                        i5 = 13;
                        i3 = 10;
                        c = '\b';
                        break;
                    case 8:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, str8);
                        i7 |= 256;
                        c = '\b';
                        i5 = 13;
                        i3 = 10;
                        break;
                    case 9:
                        list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i4, GoogleListSerializer.INSTANCE, list3);
                        i7 |= 512;
                        i5 = 13;
                        c = '\b';
                        break;
                    case 10:
                        exitOffers3 = (ExitOffers) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, ExitOffers$$serializer.INSTANCE, exitOffers3);
                        i7 |= 1024;
                        i5 = 13;
                        c = '\b';
                        break;
                    case 11:
                        productChangeConfig3 = (ProductChangeConfig) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, ProductChangeConfigSerializer.INSTANCE, productChangeConfig3);
                        i7 |= 2048;
                        i5 = 13;
                        c = '\b';
                        break;
                    case 12:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 12);
                        i7 |= 4096;
                        break;
                    case 13:
                        map5 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i5, StateDeclarationMapSerializer.INSTANCE, map5);
                        i7 |= 8192;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            int i8 = iDecodeIntElement2;
            exitOffers = exitOffers3;
            i = i8;
            map = map5;
            map2 = map3;
            componentsConfig = componentsConfig3;
            str = str7;
            productChangeConfig = productChangeConfig3;
            list = list3;
            jsonObject = jsonObject3;
            str2 = strDecodeStringElement2;
            str3 = strM13803unboximpl2;
            z = zDecodeBooleanElement2;
            i2 = i7;
            str4 = str8;
            url = url3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new WorkflowScreen(i2, str, str2, i, url, componentsConfig, map2, str3, jsonObject, str4, list, exitOffers, productChangeConfig, z, map, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WorkflowScreen value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        WorkflowScreen.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

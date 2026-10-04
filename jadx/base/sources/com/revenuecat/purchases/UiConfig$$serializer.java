package com.revenuecat.purchases;

import com.myscript.nebo.LaunchActivity;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.components.common.LocalizedVariableLocalizationKeyMapSerializer;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: UiConfig.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/UiConfig.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/UiConfig;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class UiConfig$$serializer implements GeneratedSerializer<UiConfig> {
    public static final UiConfig$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        UiConfig$$serializer uiConfig$$serializer = new UiConfig$$serializer();
        INSTANCE = uiConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.UiConfig", uiConfig$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement(LaunchActivity.LaunchRoute.App, false);
        pluginGeneratedSerialDescriptor.addElement("localizations", false);
        pluginGeneratedSerialDescriptor.addElement("variable_config", false);
        pluginGeneratedSerialDescriptor.addElement("custom_variables", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UiConfig$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{UiConfig$AppConfig$$serializer.INSTANCE, LocalizedVariableLocalizationKeyMapSerializer.INSTANCE, UiConfig$VariableConfig$$serializer.INSTANCE, UiConfig.$childSerializers[3]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public UiConfig deserialize(Decoder decoder) {
        int i;
        UiConfig.AppConfig appConfig;
        Map map;
        UiConfig.VariableConfig variableConfig;
        Map map2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = UiConfig.$childSerializers;
        UiConfig.AppConfig appConfig2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            UiConfig.AppConfig appConfig3 = (UiConfig.AppConfig) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, UiConfig$AppConfig$$serializer.INSTANCE, null);
            Map map3 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, LocalizedVariableLocalizationKeyMapSerializer.INSTANCE, null);
            UiConfig.VariableConfig variableConfig2 = (UiConfig.VariableConfig) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, UiConfig$VariableConfig$$serializer.INSTANCE, null);
            map2 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], null);
            appConfig = appConfig3;
            variableConfig = variableConfig2;
            i = 15;
            map = map3;
        } else {
            boolean z = true;
            int i2 = 0;
            Map map4 = null;
            UiConfig.VariableConfig variableConfig3 = null;
            Map map5 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    appConfig2 = (UiConfig.AppConfig) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, UiConfig$AppConfig$$serializer.INSTANCE, appConfig2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    map4 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, LocalizedVariableLocalizationKeyMapSerializer.INSTANCE, map4);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    variableConfig3 = (UiConfig.VariableConfig) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, UiConfig$VariableConfig$$serializer.INSTANCE, variableConfig3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    map5 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], map5);
                    i2 |= 8;
                }
            }
            i = i2;
            appConfig = appConfig2;
            map = map4;
            variableConfig = variableConfig3;
            map2 = map5;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new UiConfig(i, appConfig, map, variableConfig, map2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, UiConfig value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        UiConfig.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

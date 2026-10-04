package com.revenuecat.purchases.common.workflows;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.utils.serializers.JsonObjectToMapSerializer;
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

/* JADX INFO: compiled from: WorkflowModels.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/common/workflows/PublishedWorkflow.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PublishedWorkflow$$serializer implements GeneratedSerializer<PublishedWorkflow> {
    public static final PublishedWorkflow$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PublishedWorkflow$$serializer publishedWorkflow$$serializer = new PublishedWorkflow$$serializer();
        INSTANCE = publishedWorkflow$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.workflows.PublishedWorkflow", publishedWorkflow$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement(Keys.DISPLAY_NAME, false);
        pluginGeneratedSerialDescriptor.addElement("initial_step_id", false);
        pluginGeneratedSerialDescriptor.addElement("steps", false);
        pluginGeneratedSerialDescriptor.addElement("screens", false);
        pluginGeneratedSerialDescriptor.addElement(TtmlNode.TAG_METADATA, true);
        pluginGeneratedSerialDescriptor.addElement("hash", true);
        pluginGeneratedSerialDescriptor.addElement("single_step_fallback_id", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PublishedWorkflow$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = PublishedWorkflow.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, kSerializerArr[3], kSerializerArr[4], JsonObjectToMapSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PublishedWorkflow deserialize(Decoder decoder) {
        String strDecodeStringElement;
        String strDecodeStringElement2;
        Map map;
        String str;
        String str2;
        Map map2;
        Map map3;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = PublishedWorkflow.$childSerializers;
        int i2 = 7;
        int i3 = 4;
        String strDecodeStringElement3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            Map map4 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], null);
            Map map5 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            Map map6 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, JsonObjectToMapSerializer.INSTANCE, null);
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, null);
            map3 = map5;
            strDecodeStringElement3 = strDecodeStringElement4;
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            str = str3;
            map2 = map6;
            strDecodeStringElement2 = strDecodeStringElement6;
            map = map4;
            i = 255;
            strDecodeStringElement = strDecodeStringElement5;
        } else {
            boolean z = true;
            int i4 = 0;
            String str4 = null;
            String str5 = null;
            Map map7 = null;
            Map map8 = null;
            strDecodeStringElement = null;
            strDecodeStringElement2 = null;
            map = null;
            while (z) {
                int i5 = i3;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 4;
                        break;
                    case 0:
                        i4 |= 1;
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i2 = 7;
                        i3 = 4;
                        break;
                    case 1:
                        i4 |= 2;
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i2 = 7;
                        i3 = 4;
                        break;
                    case 2:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i4 |= 4;
                        i2 = 7;
                        i3 = 4;
                        break;
                    case 3:
                        map = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], map);
                        i4 |= 8;
                        i2 = 7;
                        i3 = 4;
                        break;
                    case 4:
                        map8 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i5, kSerializerArr[i5], map8);
                        i4 |= 16;
                        i3 = i5;
                        i2 = 7;
                        break;
                    case 5:
                        map7 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, JsonObjectToMapSerializer.INSTANCE, map7);
                        i4 |= 32;
                        i3 = i5;
                        break;
                    case 6:
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str4);
                        i4 |= 64;
                        i3 = i5;
                        break;
                    case 7:
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, StringSerializer.INSTANCE, str5);
                        i4 |= 128;
                        i3 = i5;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = str4;
            str2 = str5;
            map2 = map7;
            map3 = map8;
            i = i4;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PublishedWorkflow(i, strDecodeStringElement3, strDecodeStringElement, strDecodeStringElement2, map, map3, map2, str, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PublishedWorkflow value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PublishedWorkflow.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

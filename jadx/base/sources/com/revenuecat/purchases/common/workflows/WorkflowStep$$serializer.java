package com.revenuecat.purchases.common.workflows;

import androidx.media3.extractor.text.ttml.TtmlNode;
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
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* JADX INFO: compiled from: WorkflowModels.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/common/workflows/WorkflowStep.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/workflows/WorkflowStep;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class WorkflowStep$$serializer implements GeneratedSerializer<WorkflowStep> {
    public static final WorkflowStep$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WorkflowStep$$serializer workflowStep$$serializer = new WorkflowStep$$serializer();
        INSTANCE = workflowStep$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.workflows.WorkflowStep", workflowStep$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("screen_id", true);
        pluginGeneratedSerialDescriptor.addElement("param_values", true);
        pluginGeneratedSerialDescriptor.addElement("triggers", true);
        pluginGeneratedSerialDescriptor.addElement("outputs", true);
        pluginGeneratedSerialDescriptor.addElement("trigger_actions", true);
        pluginGeneratedSerialDescriptor.addElement(TtmlNode.TAG_METADATA, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WorkflowStep$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = WorkflowStep.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), kSerializerArr[3], kSerializerArr[4], kSerializerArr[5], kSerializerArr[6], BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WorkflowStep deserialize(Decoder decoder) {
        String strDecodeStringElement;
        String str;
        Map map;
        Map map2;
        JsonElement jsonElement;
        Map map3;
        List list;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = WorkflowStep.$childSerializers;
        int i2 = 7;
        int i3 = 4;
        String strDecodeStringElement2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            String str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            Map map4 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], null);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            Map map5 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            map2 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, kSerializerArr[6], null);
            strDecodeStringElement2 = strDecodeStringElement3;
            jsonElement = (JsonElement) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, JsonElementSerializer.INSTANCE, null);
            str = str2;
            i = 255;
            map3 = map5;
            map = map4;
            list = list2;
            strDecodeStringElement = strDecodeStringElement4;
        } else {
            int i4 = 3;
            boolean z = true;
            int i5 = 0;
            Map map6 = null;
            JsonElement jsonElement2 = null;
            Map map7 = null;
            List list3 = null;
            strDecodeStringElement = null;
            str = null;
            map = null;
            while (z) {
                int i6 = i3;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 4;
                        i4 = 3;
                        break;
                    case 0:
                        i5 |= 1;
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i2 = 7;
                        i3 = 4;
                        i4 = 3;
                        break;
                    case 1:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i5 |= 2;
                        i2 = 7;
                        i3 = 4;
                        i4 = 3;
                        break;
                    case 2:
                        str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str);
                        i5 |= 4;
                        i2 = 7;
                        i3 = 4;
                        i4 = 3;
                        break;
                    case 3:
                        map = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i4, kSerializerArr[i4], map);
                        i5 |= 8;
                        i2 = 7;
                        i3 = 4;
                        break;
                    case 4:
                        list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i6, kSerializerArr[i6], list3);
                        i5 |= 16;
                        i3 = i6;
                        i2 = 7;
                        break;
                    case 5:
                        map7 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], map7);
                        i5 |= 32;
                        i3 = i6;
                        break;
                    case 6:
                        map6 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, kSerializerArr[6], map6);
                        i5 |= 64;
                        i3 = i6;
                        break;
                    case 7:
                        jsonElement2 = (JsonElement) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, JsonElementSerializer.INSTANCE, jsonElement2);
                        i5 |= 128;
                        i3 = i6;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            map2 = map6;
            jsonElement = jsonElement2;
            map3 = map7;
            list = list3;
            i = i5;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new WorkflowStep(i, strDecodeStringElement2, strDecodeStringElement, str, map, list, map3, map2, jsonElement, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WorkflowStep value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        WorkflowStep.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}

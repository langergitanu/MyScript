package com.survicate.surveys.entities.models;

import com.survicate.surveys.entities.models.RespondentEvent;
import com.survicate.surveys.infrastructure.network.VisitData;
import com.survicate.surveys.infrastructure.network.VisitData$$serializer;
import com.survicate.surveys.infrastructure.network.VisitorData;
import com.survicate.surveys.infrastructure.network.VisitorData$$serializer;
import java.util.List;
import java.util.Map;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: RespondentEvent.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/entities/models/RespondentEvent.QuestionAnswered.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class RespondentEvent$QuestionAnswered$$serializer implements GeneratedSerializer<RespondentEvent.QuestionAnswered> {
    public static final RespondentEvent$QuestionAnswered$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private RespondentEvent$QuestionAnswered$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RespondentEvent$QuestionAnswered$$serializer respondentEvent$QuestionAnswered$$serializer = new RespondentEvent$QuestionAnswered$$serializer();
        INSTANCE = respondentEvent$QuestionAnswered$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("answered", respondentEvent$QuestionAnswered$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("survey_id", false);
        pluginGeneratedSerialDescriptor.addElement("response_uuid", false);
        pluginGeneratedSerialDescriptor.addElement("survey_point_id", false);
        pluginGeneratedSerialDescriptor.addElement("visitor", false);
        pluginGeneratedSerialDescriptor.addElement("visit", false);
        pluginGeneratedSerialDescriptor.addElement("visit_points", false);
        pluginGeneratedSerialDescriptor.addElement("overwrite", false);
        pluginGeneratedSerialDescriptor.addElement("integrations", false);
        pluginGeneratedSerialDescriptor.addElement("disclaimer_accepted", false);
        pluginGeneratedSerialDescriptor.addElement("response_attributes", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr = RespondentEvent.QuestionAnswered.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, VisitorData$$serializer.INSTANCE, VisitData$$serializer.INSTANCE, lazyArr[5].getValue(), BooleanSerializer.INSTANCE, lazyArr[7].getValue(), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[9].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final RespondentEvent.QuestionAnswered deserialize(Decoder decoder) {
        VisitData visitData;
        List list;
        VisitorData visitorData;
        int i;
        long j;
        boolean z;
        List list2;
        String str;
        Boolean bool;
        String str2;
        Map map;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = RespondentEvent.QuestionAnswered.$childSerializers;
        int i2 = 8;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
            VisitorData visitorData2 = (VisitorData) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, VisitorData$$serializer.INSTANCE, null);
            VisitData visitData2 = (VisitData) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, VisitData$$serializer.INSTANCE, null);
            List list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 6);
            Map map2 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), null);
            z = zDecodeBooleanElement;
            visitorData = visitorData2;
            list2 = list3;
            str = strDecodeStringElement2;
            visitData = visitData2;
            str2 = strDecodeStringElement;
            bool = bool2;
            i = 1023;
            map = map2;
            j = jDecodeLongElement;
        } else {
            int i3 = 5;
            boolean z2 = true;
            boolean zDecodeBooleanElement2 = false;
            Map map3 = null;
            Boolean bool3 = null;
            List list4 = null;
            List list5 = null;
            visitData = null;
            long jDecodeLongElement2 = 0;
            int i4 = 0;
            VisitorData visitorData3 = null;
            String strDecodeStringElement3 = null;
            String strDecodeStringElement4 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        i2 = 8;
                        i3 = 5;
                        break;
                    case 0:
                        i4 |= 1;
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 = 8;
                        i3 = 5;
                        break;
                    case 1:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i4 |= 2;
                        i2 = 8;
                        i3 = 5;
                        break;
                    case 2:
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
                        i4 |= 4;
                        i2 = 8;
                        i3 = 5;
                        break;
                    case 3:
                        visitorData3 = (VisitorData) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, VisitorData$$serializer.INSTANCE, visitorData3);
                        i4 |= 8;
                        i2 = 8;
                        i3 = 5;
                        break;
                    case 4:
                        visitData = (VisitData) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, VisitData$$serializer.INSTANCE, visitData);
                        i4 |= 16;
                        i2 = 8;
                        i3 = 5;
                        break;
                    case 5:
                        list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i3, (DeserializationStrategy) lazyArr[i3].getValue(), list4);
                        i4 |= 32;
                        i2 = 8;
                        break;
                    case 6:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 6);
                        i4 |= 64;
                        break;
                    case 7:
                        map3 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), map3);
                        i4 |= 128;
                        break;
                    case 8:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, BooleanSerializer.INSTANCE, bool3);
                        i4 |= 256;
                        break;
                    case 9:
                        list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), list5);
                        i4 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            list = list5;
            visitorData = visitorData3;
            i = i4;
            j = jDecodeLongElement2;
            z = zDecodeBooleanElement2;
            list2 = list4;
            str = strDecodeStringElement4;
            bool = bool3;
            str2 = strDecodeStringElement3;
            map = map3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new RespondentEvent.QuestionAnswered(i, str2, str, j, visitorData, visitData, list2, z, map, bool, list, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, RespondentEvent.QuestionAnswered value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        RespondentEvent.QuestionAnswered.write$Self$survicate_sdk_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}

package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.PartitionedPrefix;
import aws.sdk.kotlin.services.p010s3.model.SimplePrefix;
import aws.sdk.kotlin.services.p010s3.model.TargetObjectKeyFormat;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableKt;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TargetObjectKeyFormatDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeTargetObjectKeyFormatDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/TargetObjectKeyFormat;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TargetObjectKeyFormatDocumentSerializerKt {
    public static final void serializeTargetObjectKeyFormatDocument(Serializer serializer, TargetObjectKeyFormat input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("PartitionedPrefix"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("SimplePrefix"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("TargetObjectKeyFormat"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        PartitionedPrefix partitionedPrefix = input.getPartitionedPrefix();
        if (partitionedPrefix != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, partitionedPrefix, C3619x9f98e6b0.INSTANCE);
        }
        SimplePrefix simplePrefix = input.getSimplePrefix();
        if (simplePrefix != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor2, simplePrefix, C3620x9f98ea71.INSTANCE);
        }
        structSerializerBeginStruct.endStruct();
    }
}

package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.CompletedPart;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompletedPartDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeCompletedPartDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/CompletedPart;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CompletedPartDocumentSerializerKt {
    public static final void serializeCompletedPartDocument(Serializer serializer, CompletedPart input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("ChecksumCRC32"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("ChecksumCRC32C"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("ChecksumCRC64NVME"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("ChecksumSHA1"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("ChecksumSHA256"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("ETag"));
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(SerialKind.Integer.INSTANCE, new XmlSerialName("PartNumber"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("CompletedPart"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        builder.field(sdkFieldDescriptor7);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        String checksumCrc32 = input.getChecksumCrc32();
        if (checksumCrc32 != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor, checksumCrc32);
        }
        String checksumCrc32C = input.getChecksumCrc32C();
        if (checksumCrc32C != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, checksumCrc32C);
        }
        String checksumCrc64Nvme = input.getChecksumCrc64Nvme();
        if (checksumCrc64Nvme != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor3, checksumCrc64Nvme);
        }
        String checksumSha1 = input.getChecksumSha1();
        if (checksumSha1 != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor4, checksumSha1);
        }
        String checksumSha256 = input.getChecksumSha256();
        if (checksumSha256 != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor5, checksumSha256);
        }
        String eTag = input.getETag();
        if (eTag != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor6, eTag);
        }
        Integer partNumber = input.getPartNumber();
        if (partNumber != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor7, partNumber.intValue());
        }
        structSerializerBeginStruct.endStruct();
    }
}

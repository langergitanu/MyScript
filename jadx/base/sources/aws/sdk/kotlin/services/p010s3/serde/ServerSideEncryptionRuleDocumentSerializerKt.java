package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.BlockedEncryptionTypes;
import aws.sdk.kotlin.services.p010s3.model.ServerSideEncryptionByDefault;
import aws.sdk.kotlin.services.p010s3.model.ServerSideEncryptionRule;
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

/* JADX INFO: compiled from: ServerSideEncryptionRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeServerSideEncryptionRuleDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionRule;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ServerSideEncryptionRuleDocumentSerializerKt {
    public static final void serializeServerSideEncryptionRuleDocument(Serializer serializer, ServerSideEncryptionRule input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("ApplyServerSideEncryptionByDefault"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("BlockedEncryptionTypes"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Boolean.INSTANCE, new XmlSerialName("BucketKeyEnabled"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("ServerSideEncryptionRule"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        ServerSideEncryptionByDefault applyServerSideEncryptionByDefault = input.getApplyServerSideEncryptionByDefault();
        if (applyServerSideEncryptionByDefault != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, applyServerSideEncryptionByDefault, C3610xa6c8d086.INSTANCE);
        }
        BlockedEncryptionTypes blockedEncryptionTypes = input.getBlockedEncryptionTypes();
        if (blockedEncryptionTypes != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor2, blockedEncryptionTypes, C3611xa6c8d447.INSTANCE);
        }
        Boolean bucketKeyEnabled = input.getBucketKeyEnabled();
        if (bucketKeyEnabled != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor3, bucketKeyEnabled.booleanValue());
        }
        structSerializerBeginStruct.endStruct();
    }
}

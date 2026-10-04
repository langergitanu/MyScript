package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.PublicAccessBlockConfiguration;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PublicAccessBlockConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"serializePublicAccessBlockConfigurationPayloadWithXmlNamePublicAccessBlockConfiguration", "", "input", "Laws/sdk/kotlin/services/s3/model/PublicAccessBlockConfiguration;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PublicAccessBlockConfigurationPayloadSerializerKt {
    /* JADX INFO: renamed from: serializePublicAccessBlockConfigurationPayloadWithXmlNamePublicAccessBlockConfiguration */
    public static final byte[] m491x4903feda(PublicAccessBlockConfiguration input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlSerializer xmlSerializer = new XmlSerializer(null, 1, null);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Boolean.INSTANCE, new XmlSerialName("BlockPublicAcls"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Boolean.INSTANCE, new XmlSerialName("BlockPublicPolicy"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Boolean.INSTANCE, new XmlSerialName("IgnorePublicAcls"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.Boolean.INSTANCE, new XmlSerialName("RestrictPublicBuckets"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("PublicAccessBlockConfiguration"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        StructSerializer structSerializerBeginStruct = xmlSerializer.beginStruct(builder.build());
        Boolean blockPublicAcls = input.getBlockPublicAcls();
        if (blockPublicAcls != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor, blockPublicAcls.booleanValue());
        }
        Boolean blockPublicPolicy = input.getBlockPublicPolicy();
        if (blockPublicPolicy != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, blockPublicPolicy.booleanValue());
        }
        Boolean ignorePublicAcls = input.getIgnorePublicAcls();
        if (ignorePublicAcls != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor3, ignorePublicAcls.booleanValue());
        }
        Boolean restrictPublicBuckets = input.getRestrictPublicBuckets();
        if (restrictPublicBuckets != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor4, restrictPublicBuckets.booleanValue());
        }
        structSerializerBeginStruct.endStruct();
        return xmlSerializer.toByteArray();
    }
}

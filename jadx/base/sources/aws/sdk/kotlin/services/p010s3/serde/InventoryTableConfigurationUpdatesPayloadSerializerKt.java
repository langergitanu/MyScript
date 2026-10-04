package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.InventoryTableConfigurationUpdates;
import aws.sdk.kotlin.services.p010s3.model.MetadataTableEncryptionConfiguration;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableKt;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InventoryTableConfigurationUpdatesPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"serializeInventoryTableConfigurationUpdatesPayloadWithXmlNameInventoryTableConfiguration", "", "input", "Laws/sdk/kotlin/services/s3/model/InventoryTableConfigurationUpdates;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InventoryTableConfigurationUpdatesPayloadSerializerKt {
    /* JADX INFO: renamed from: serializeInventoryTableConfigurationUpdatesPayloadWithXmlNameInventoryTableConfiguration */
    public static final byte[] m482x9026dcf0(InventoryTableConfigurationUpdates input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlSerializer xmlSerializer = new XmlSerializer(null, 1, null);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("ConfigurationState"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("EncryptionConfiguration"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("InventoryTableConfiguration"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        StructSerializer structSerializerBeginStruct = xmlSerializer.beginStruct(builder.build());
        structSerializerBeginStruct.field(sdkFieldDescriptor, input.getConfigurationState().getValue());
        MetadataTableEncryptionConfiguration encryptionConfiguration = input.getEncryptionConfiguration();
        if (encryptionConfiguration != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor2, encryptionConfiguration, C3533x84818e38.INSTANCE);
        }
        structSerializerBeginStruct.endStruct();
        return xmlSerializer.toByteArray();
    }
}

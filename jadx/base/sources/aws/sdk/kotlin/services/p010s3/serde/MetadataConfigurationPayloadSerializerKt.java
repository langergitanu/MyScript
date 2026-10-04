package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.InventoryTableConfiguration;
import aws.sdk.kotlin.services.p010s3.model.JournalTableConfiguration;
import aws.sdk.kotlin.services.p010s3.model.MetadataConfiguration;
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

/* JADX INFO: compiled from: MetadataConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"serializeMetadataConfigurationPayloadWithXmlNameMetadataConfiguration", "", "input", "Laws/sdk/kotlin/services/s3/model/MetadataConfiguration;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MetadataConfigurationPayloadSerializerKt {
    /* JADX INFO: renamed from: serializeMetadataConfigurationPayloadWithXmlNameMetadataConfiguration */
    public static final byte[] m486x23a97872(MetadataConfiguration input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlSerializer xmlSerializer = new XmlSerializer(null, 1, null);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("InventoryTableConfiguration"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("JournalTableConfiguration"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("MetadataConfiguration"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        StructSerializer structSerializerBeginStruct = xmlSerializer.beginStruct(builder.build());
        InventoryTableConfiguration inventoryTableConfiguration = input.getInventoryTableConfiguration();
        if (inventoryTableConfiguration != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, inventoryTableConfiguration, C3557x1f90e717.INSTANCE);
        }
        JournalTableConfiguration journalTableConfiguration = input.getJournalTableConfiguration();
        if (journalTableConfiguration != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor2, journalTableConfiguration, C3558x1f90ead8.INSTANCE);
        }
        structSerializerBeginStruct.endStruct();
        return xmlSerializer.toByteArray();
    }
}

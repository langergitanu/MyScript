package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import aws.sdk.kotlin.services.p010s3.model.DeleteMarkerReplication;
import aws.sdk.kotlin.services.p010s3.model.Destination;
import aws.sdk.kotlin.services.p010s3.model.ExistingObjectReplication;
import aws.sdk.kotlin.services.p010s3.model.ReplicationRule;
import aws.sdk.kotlin.services.p010s3.model.ReplicationRuleFilter;
import aws.sdk.kotlin.services.p010s3.model.SourceSelectionCriteria;
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
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: ReplicationRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeReplicationRuleDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/ReplicationRule;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ReplicationRuleDocumentSerializerKt {
    public static final void serializeReplicationRuleDocument(Serializer serializer, ReplicationRule input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("DeleteMarkerReplication"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName(HttpHeaders.DESTINATION));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("ExistingObjectReplication"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("Filter"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("ID"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName(TextFieldImplKt.PrefixId));
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(SerialKind.Integer.INSTANCE, new XmlSerialName("Priority"));
        SdkFieldDescriptor sdkFieldDescriptor8 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("SourceSelectionCriteria"));
        SdkFieldDescriptor sdkFieldDescriptor9 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("Status"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("ReplicationRule"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        builder.field(sdkFieldDescriptor7);
        builder.field(sdkFieldDescriptor8);
        builder.field(sdkFieldDescriptor9);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        DeleteMarkerReplication deleteMarkerReplication = input.getDeleteMarkerReplication();
        if (deleteMarkerReplication != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, deleteMarkerReplication, C3584x2a797f0.INSTANCE);
        }
        Destination destination = input.getDestination();
        if (destination != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor2, destination, C3585x2a79bb1.INSTANCE);
        }
        ExistingObjectReplication existingObjectReplication = input.getExistingObjectReplication();
        if (existingObjectReplication != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor3, existingObjectReplication, C3586x2a79f72.INSTANCE);
        }
        ReplicationRuleFilter filter = input.getFilter();
        if (filter != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor4, filter, C3587x2a7a333.INSTANCE);
        }
        String id = input.getId();
        if (id != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor5, id);
        }
        String prefix = input.getPrefix();
        if (prefix != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor6, prefix);
        }
        Integer priority = input.getPriority();
        if (priority != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor7, priority.intValue());
        }
        SourceSelectionCriteria sourceSelectionCriteria = input.getSourceSelectionCriteria();
        if (sourceSelectionCriteria != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor8, sourceSelectionCriteria, C3588x2a7b237.INSTANCE);
        }
        structSerializerBeginStruct.field(sdkFieldDescriptor9, input.getStatus().getValue());
        structSerializerBeginStruct.endStruct();
    }
}

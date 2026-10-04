package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ReplicaModifications;
import aws.sdk.kotlin.services.p010s3.model.SourceSelectionCriteria;
import aws.sdk.kotlin.services.p010s3.model.SseKmsEncryptedObjects;
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

/* JADX INFO: compiled from: SourceSelectionCriteriaDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeSourceSelectionCriteriaDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SourceSelectionCriteriaDocumentSerializerKt {
    public static final void serializeSourceSelectionCriteriaDocument(Serializer serializer, SourceSelectionCriteria input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("ReplicaModifications"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("SseKmsEncryptedObjects"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("SourceSelectionCriteria"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        ReplicaModifications replicaModifications = input.getReplicaModifications();
        if (replicaModifications != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, replicaModifications, C3612xe640eef0.INSTANCE);
        }
        SseKmsEncryptedObjects sseKmsEncryptedObjects = input.getSseKmsEncryptedObjects();
        if (sseKmsEncryptedObjects != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor2, sseKmsEncryptedObjects, C3613xe640f2b1.INSTANCE);
        }
        structSerializerBeginStruct.endStruct();
    }
}

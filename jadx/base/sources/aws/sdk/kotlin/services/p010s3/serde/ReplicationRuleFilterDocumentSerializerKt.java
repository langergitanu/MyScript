package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import aws.sdk.kotlin.services.p010s3.model.ReplicationRuleAndOperator;
import aws.sdk.kotlin.services.p010s3.model.ReplicationRuleFilter;
import aws.sdk.kotlin.services.p010s3.model.Tag;
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

/* JADX INFO: compiled from: ReplicationRuleFilterDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeReplicationRuleFilterDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/ReplicationRuleFilter;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ReplicationRuleFilterDocumentSerializerKt {
    public static final void serializeReplicationRuleFilterDocument(Serializer serializer, ReplicationRuleFilter input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("And"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName(TextFieldImplKt.PrefixId));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("Tag"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("ReplicationRuleFilter"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        ReplicationRuleAndOperator and = input.getAnd();
        if (and != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, and, C3589x78d31470.INSTANCE);
        }
        String prefix = input.getPrefix();
        if (prefix != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, prefix);
        }
        Tag tag = input.getTag();
        if (tag != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor3, tag, C3590x78d31bf2.INSTANCE);
        }
        structSerializerBeginStruct.endStruct();
    }
}

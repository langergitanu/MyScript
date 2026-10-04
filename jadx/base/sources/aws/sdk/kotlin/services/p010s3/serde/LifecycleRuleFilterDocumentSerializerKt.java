package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import aws.sdk.kotlin.services.p010s3.model.LifecycleRuleAndOperator;
import aws.sdk.kotlin.services.p010s3.model.LifecycleRuleFilter;
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

/* JADX INFO: compiled from: LifecycleRuleFilterDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeLifecycleRuleFilterDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/LifecycleRuleFilter;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LifecycleRuleFilterDocumentSerializerKt {
    public static final void serializeLifecycleRuleFilterDocument(Serializer serializer, LifecycleRuleFilter input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("And"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Long.INSTANCE, new XmlSerialName("ObjectSizeGreaterThan"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Long.INSTANCE, new XmlSerialName("ObjectSizeLessThan"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName(TextFieldImplKt.PrefixId));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("Tag"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("LifecycleRuleFilter"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        LifecycleRuleAndOperator and = input.getAnd();
        if (and != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, and, C3546xefddafb0.INSTANCE);
        }
        Long objectSizeGreaterThan = input.getObjectSizeGreaterThan();
        if (objectSizeGreaterThan != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, objectSizeGreaterThan.longValue());
        }
        Long objectSizeLessThan = input.getObjectSizeLessThan();
        if (objectSizeLessThan != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor3, objectSizeLessThan.longValue());
        }
        String prefix = input.getPrefix();
        if (prefix != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor4, prefix);
        }
        Tag tag = input.getTag();
        if (tag != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor5, tag, C3547xefddbeb4.INSTANCE);
        }
        structSerializerBeginStruct.endStruct();
    }
}

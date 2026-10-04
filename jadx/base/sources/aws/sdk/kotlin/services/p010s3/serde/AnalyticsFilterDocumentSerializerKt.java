package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import aws.sdk.kotlin.services.p010s3.model.AnalyticsFilter;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableKt;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.SerializationException;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalyticsFilterDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeAnalyticsFilterDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/AnalyticsFilter;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AnalyticsFilterDocumentSerializerKt {
    public static final void serializeAnalyticsFilterDocument(Serializer serializer, AnalyticsFilter input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("And"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName(TextFieldImplKt.PrefixId));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("Tag"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("AnalyticsFilter"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        if (input instanceof AnalyticsFilter.And) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, ((AnalyticsFilter.And) input).getValue(), C3487x5ea2bfe3.INSTANCE);
        } else if (input instanceof AnalyticsFilter.Prefix) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, ((AnalyticsFilter.Prefix) input).getValue());
        } else {
            if (!(input instanceof AnalyticsFilter.Tag)) {
                if (!(input instanceof AnalyticsFilter.SdkUnknown)) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new SerializationException("Cannot serialize SdkUnknown");
            }
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor3, ((AnalyticsFilter.Tag) input).getValue(), C3488x5ea2bfe4.INSTANCE);
        }
        structSerializerBeginStruct.endStruct();
    }
}

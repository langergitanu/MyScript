package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import aws.sdk.kotlin.services.p010s3.model.AnalyticsS3BucketDestination;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalyticsS3BucketDestinationDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeAnalyticsS3BucketDestinationDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/AnalyticsS3BucketDestination;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AnalyticsS3BucketDestinationDocumentSerializerKt {
    public static final void serializeAnalyticsS3BucketDestinationDocument(Serializer serializer, AnalyticsS3BucketDestination input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("Bucket"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("BucketAccountId"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("Format"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName(TextFieldImplKt.PrefixId));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("AnalyticsS3BucketDestination"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        structSerializerBeginStruct.field(sdkFieldDescriptor, input.getBucket());
        String bucketAccountId = input.getBucketAccountId();
        if (bucketAccountId != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, bucketAccountId);
        }
        structSerializerBeginStruct.field(sdkFieldDescriptor3, input.getFormat().getValue());
        String prefix = input.getPrefix();
        if (prefix != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor4, prefix);
        }
        structSerializerBeginStruct.endStruct();
    }
}

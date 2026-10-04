package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ObjectLockRetention;
import aws.sdk.kotlin.services.p010s3.model.ObjectLockRetentionMode;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerializer;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObjectLockRetentionPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"serializeObjectLockRetentionPayloadWithXmlNameRetention", "", "input", "Laws/sdk/kotlin/services/s3/model/ObjectLockRetention;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ObjectLockRetentionPayloadSerializerKt {
    public static final byte[] serializeObjectLockRetentionPayloadWithXmlNameRetention(ObjectLockRetention input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlSerializer xmlSerializer = new XmlSerializer(null, 1, null);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("Mode"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Timestamp.INSTANCE, new XmlSerialName("RetainUntilDate"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("Retention"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        StructSerializer structSerializerBeginStruct = xmlSerializer.beginStruct(builder.build());
        ObjectLockRetentionMode mode = input.getMode();
        if (mode != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor, mode.getValue());
        }
        Instant retainUntilDate = input.getRetainUntilDate();
        if (retainUntilDate != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, retainUntilDate, TimestampFormat.ISO_8601);
        }
        structSerializerBeginStruct.endStruct();
        return xmlSerializer.toByteArray();
    }
}

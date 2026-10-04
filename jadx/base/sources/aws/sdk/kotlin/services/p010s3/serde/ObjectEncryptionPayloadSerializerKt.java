package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ObjectEncryption;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObjectEncryptionPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"serializeObjectEncryptionPayload", "", "input", "Laws/sdk/kotlin/services/s3/model/ObjectEncryption;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ObjectEncryptionPayloadSerializerKt {
    public static final byte[] serializeObjectEncryptionPayload(ObjectEncryption input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlSerializer xmlSerializer = new XmlSerializer(null, 1, null);
        ObjectEncryptionDocumentSerializerKt.serializeObjectEncryptionDocument(xmlSerializer, input);
        return xmlSerializer.toByteArray();
    }
}

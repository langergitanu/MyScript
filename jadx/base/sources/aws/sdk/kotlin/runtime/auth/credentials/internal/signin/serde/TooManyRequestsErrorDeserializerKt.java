package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.serde;

import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.OAuth2ErrorCode;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.TooManyRequestsError;
import aws.smithy.kotlin.runtime.serde.Deserializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.json.JsonDeserializer;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import kotlin.Metadata;

/* JADX INFO: compiled from: TooManyRequestsErrorDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, m1599d2 = {"deserializeTooManyRequestsErrorError", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/TooManyRequestsError$Builder;", "payload", "", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TooManyRequestsErrorDeserializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void deserializeTooManyRequestsErrorError(TooManyRequestsError.Builder builder, byte[] bArr) {
        JsonDeserializer jsonDeserializer = new JsonDeserializer(bArr);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new JsonSerialName("error"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("message"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder2 = new SdkObjectDescriptor.Builder();
        builder2.field(sdkFieldDescriptor);
        builder2.field(sdkFieldDescriptor2);
        Deserializer.FieldIterator fieldIteratorDeserializeStruct = jsonDeserializer.deserializeStruct(builder2.build());
        while (true) {
            Integer numFindNextFieldIndex = fieldIteratorDeserializeStruct.findNextFieldIndex();
            int index = sdkFieldDescriptor.getIndex();
            if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index) {
                builder.setError(OAuth2ErrorCode.INSTANCE.fromValue(fieldIteratorDeserializeStruct.deserializeString()));
            } else {
                int index2 = sdkFieldDescriptor2.getIndex();
                if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index2) {
                    builder.setMessage(fieldIteratorDeserializeStruct.deserializeString());
                } else if (numFindNextFieldIndex == null) {
                    return;
                } else {
                    fieldIteratorDeserializeStruct.skipValue();
                }
            }
        }
    }
}

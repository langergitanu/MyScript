package aws.sdk.kotlin.runtime.auth.credentials.internal.sso.serde;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.model.RoleCredentials;
import aws.smithy.kotlin.runtime.serde.Deserializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoleCredentialsDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeRoleCredentialsDocument", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/model/RoleCredentials;", "deserializer", "Laws/smithy/kotlin/runtime/serde/Deserializer;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RoleCredentialsDocumentDeserializerKt {
    public static final RoleCredentials deserializeRoleCredentialsDocument(Deserializer deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        RoleCredentials.Builder builder = new RoleCredentials.Builder();
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("accessKeyId"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Long.INSTANCE, new JsonSerialName("expiration"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("secretAccessKey"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("sessionToken"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder2 = new SdkObjectDescriptor.Builder();
        builder2.field(sdkFieldDescriptor);
        builder2.field(sdkFieldDescriptor2);
        builder2.field(sdkFieldDescriptor3);
        builder2.field(sdkFieldDescriptor4);
        Deserializer.FieldIterator fieldIteratorDeserializeStruct = deserializer.deserializeStruct(builder2.build());
        while (true) {
            Integer numFindNextFieldIndex = fieldIteratorDeserializeStruct.findNextFieldIndex();
            int index = sdkFieldDescriptor.getIndex();
            if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index) {
                builder.setAccessKeyId(fieldIteratorDeserializeStruct.deserializeString());
            } else {
                int index2 = sdkFieldDescriptor2.getIndex();
                if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index2) {
                    builder.setExpiration(fieldIteratorDeserializeStruct.deserializeLong());
                } else {
                    int index3 = sdkFieldDescriptor3.getIndex();
                    if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index3) {
                        builder.setSecretAccessKey(fieldIteratorDeserializeStruct.deserializeString());
                    } else {
                        int index4 = sdkFieldDescriptor4.getIndex();
                        if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index4) {
                            builder.setSessionToken(fieldIteratorDeserializeStruct.deserializeString());
                        } else if (numFindNextFieldIndex != null) {
                            fieldIteratorDeserializeStruct.skipValue();
                        } else {
                            builder.correctErrors$aws_config();
                            return builder.build();
                        }
                    }
                }
            }
        }
    }
}

package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.serde;

import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenResponseBody;
import aws.smithy.kotlin.runtime.serde.Deserializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateOAuth2TokenResponseBodyDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeCreateOAuth2TokenResponseBodyDocument", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody;", "deserializer", "Laws/smithy/kotlin/runtime/serde/Deserializer;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateOAuth2TokenResponseBodyDocumentDeserializerKt {
    public static final CreateOAuth2TokenResponseBody deserializeCreateOAuth2TokenResponseBodyDocument(Deserializer deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        CreateOAuth2TokenResponseBody.Builder builder = new CreateOAuth2TokenResponseBody.Builder();
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new JsonSerialName("accessToken"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.Integer.INSTANCE, new JsonSerialName("expiresIn"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("idToken"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("refreshToken"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("tokenType"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder2 = new SdkObjectDescriptor.Builder();
        builder2.field(sdkFieldDescriptor);
        builder2.field(sdkFieldDescriptor2);
        builder2.field(sdkFieldDescriptor3);
        builder2.field(sdkFieldDescriptor4);
        builder2.field(sdkFieldDescriptor5);
        Deserializer.FieldIterator fieldIteratorDeserializeStruct = deserializer.deserializeStruct(builder2.build());
        while (true) {
            Integer numFindNextFieldIndex = fieldIteratorDeserializeStruct.findNextFieldIndex();
            int index = sdkFieldDescriptor.getIndex();
            if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index) {
                builder.setAccessToken(AccessTokenDocumentDeserializerKt.deserializeAccessTokenDocument(deserializer));
            } else {
                int index2 = sdkFieldDescriptor2.getIndex();
                if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index2) {
                    builder.setExpiresIn(Integer.valueOf(fieldIteratorDeserializeStruct.deserializeInt()));
                } else {
                    int index3 = sdkFieldDescriptor3.getIndex();
                    if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index3) {
                        builder.setIdToken(fieldIteratorDeserializeStruct.deserializeString());
                    } else {
                        int index4 = sdkFieldDescriptor4.getIndex();
                        if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index4) {
                            builder.setRefreshToken(fieldIteratorDeserializeStruct.deserializeString());
                        } else {
                            int index5 = sdkFieldDescriptor5.getIndex();
                            if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index5) {
                                builder.setTokenType(fieldIteratorDeserializeStruct.deserializeString());
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
}

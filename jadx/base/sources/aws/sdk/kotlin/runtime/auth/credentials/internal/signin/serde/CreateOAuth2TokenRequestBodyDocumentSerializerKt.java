package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.serde;

import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenRequestBody;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateOAuth2TokenRequestBodyDocumentSerializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeCreateOAuth2TokenRequestBodyDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequestBody;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateOAuth2TokenRequestBodyDocumentSerializerKt {
    public static final void serializeCreateOAuth2TokenRequestBodyDocument(Serializer serializer, CreateOAuth2TokenRequestBody input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("clientId"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("code"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("codeVerifier"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("grantType"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("redirectUri"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("refreshToken"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        structSerializerBeginStruct.field(sdkFieldDescriptor, input.getClientId());
        structSerializerBeginStruct.field(sdkFieldDescriptor4, input.getGrantType());
        String code = input.getCode();
        if (code != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor2, code);
        }
        String redirectUri = input.getRedirectUri();
        if (redirectUri != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor5, redirectUri);
        }
        String codeVerifier = input.getCodeVerifier();
        if (codeVerifier != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor3, codeVerifier);
        }
        String refreshToken = input.getRefreshToken();
        if (refreshToken != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor6, refreshToken);
        }
        structSerializerBeginStruct.endStruct();
    }
}

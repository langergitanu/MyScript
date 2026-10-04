package aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.serde;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.model.AuthorizationPendingException;
import aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.model.CreateTokenResponse;
import aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.model.SsoOidcException;
import aws.smithy.kotlin.runtime.awsprotocol.ErrorDetails;
import aws.smithy.kotlin.runtime.awsprotocol.ProtocolErrorsKt;
import aws.smithy.kotlin.runtime.awsprotocol.ResponseUtilsKt;
import aws.smithy.kotlin.runtime.awsprotocol.json.RestJsonErrorDeserializer;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.serde.Deserializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.json.JsonDeserializer;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;

/* JADX INFO: compiled from: CreateTokenOperationDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\f"}, m1599d2 = {"throwCreateTokenError", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "payload", "", "deserializeCreateTokenOperationBody", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenResponse$Builder;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateTokenOperationDeserializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Void throwCreateTokenError(ExecutionContext executionContext, HttpCall httpCall, byte[] bArr) {
        AuthorizationPendingException ssoOidcException;
        HttpResponse httpResponseWithPayload = ResponseUtilsKt.withPayload(httpCall.getResponse(), bArr);
        HttpCall httpCallCopy$default = HttpCall.copy$default(httpCall, null, httpResponseWithPayload, 1, null);
        try {
            ErrorDetails errorDetailsDeserialize = RestJsonErrorDeserializer.INSTANCE.deserialize(httpCall.getResponse().getHeaders(), bArr);
            String code = errorDetailsDeserialize.getCode();
            if (code != null) {
                switch (code.hashCode()) {
                    case -1190608143:
                        ssoOidcException = !code.equals("AuthorizationPendingException") ? new SsoOidcException(errorDetailsDeserialize.getMessage()) : new AuthorizationPendingExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                        break;
                    case -1101695507:
                        if (code.equals("InvalidClientException")) {
                            ssoOidcException = new InvalidClientExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case -608224069:
                        if (code.equals("ExpiredTokenException")) {
                            ssoOidcException = new ExpiredTokenExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case -213094100:
                        if (code.equals("SlowDownException")) {
                            ssoOidcException = new SlowDownExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case 122859728:
                        if (code.equals("AccessDeniedException")) {
                            ssoOidcException = new AccessDeniedExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case 369611024:
                        if (code.equals("UnauthorizedClientException")) {
                            ssoOidcException = new UnauthorizedClientExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case 734598063:
                        if (code.equals("InternalServerException")) {
                            ssoOidcException = new InternalServerExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case 797925906:
                        if (code.equals("InvalidScopeException")) {
                            ssoOidcException = new InvalidScopeExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case 1148038775:
                        if (code.equals("InvalidRequestException")) {
                            ssoOidcException = new InvalidRequestExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case 1302626378:
                        if (code.equals("InvalidGrantException")) {
                            ssoOidcException = new InvalidGrantExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case 2022771054:
                        if (code.equals("UnsupportedGrantTypeException")) {
                            ssoOidcException = new UnsupportedGrantTypeExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                }
            }
            ProtocolErrorsKt.setAseErrorMetadata(ssoOidcException, httpResponseWithPayload, errorDetailsDeserialize);
            throw ssoOidcException;
        } catch (Exception e) {
            SsoOidcException ssoOidcException2 = new SsoOidcException("Failed to parse response as 'restJson1' error", e);
            ProtocolErrorsKt.setAseErrorMetadata(ssoOidcException2, httpCallCopy$default.getResponse(), null);
            throw ssoOidcException2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deserializeCreateTokenOperationBody(CreateTokenResponse.Builder builder, byte[] bArr) {
        JsonDeserializer jsonDeserializer = new JsonDeserializer(bArr);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new JsonSerialName("accessToken"));
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
        Deserializer.FieldIterator fieldIteratorDeserializeStruct = jsonDeserializer.deserializeStruct(builder2.build());
        while (true) {
            Integer numFindNextFieldIndex = fieldIteratorDeserializeStruct.findNextFieldIndex();
            int index = sdkFieldDescriptor.getIndex();
            if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index) {
                builder.setAccessToken(fieldIteratorDeserializeStruct.deserializeString());
            } else {
                int index2 = sdkFieldDescriptor2.getIndex();
                if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index2) {
                    builder.setExpiresIn(fieldIteratorDeserializeStruct.deserializeInt());
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
                            } else if (numFindNextFieldIndex == null) {
                                return;
                            } else {
                                fieldIteratorDeserializeStruct.skipValue();
                            }
                        }
                    }
                }
            }
        }
    }
}

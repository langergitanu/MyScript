package aws.sdk.kotlin.runtime.auth.credentials.internal.sso.serde;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.model.GetRoleCredentialsResponse;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.model.SsoException;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.model.UnauthorizedException;
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

/* JADX INFO: compiled from: GetRoleCredentialsOperationDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\f"}, m1599d2 = {"throwGetRoleCredentialsError", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "payload", "", "deserializeGetRoleCredentialsOperationBody", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/model/GetRoleCredentialsResponse$Builder;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetRoleCredentialsOperationDeserializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Void throwGetRoleCredentialsError(ExecutionContext executionContext, HttpCall httpCall, byte[] bArr) {
        UnauthorizedException ssoException;
        HttpResponse httpResponseWithPayload = ResponseUtilsKt.withPayload(httpCall.getResponse(), bArr);
        HttpCall httpCallCopy$default = HttpCall.copy$default(httpCall, null, httpResponseWithPayload, 1, null);
        try {
            ErrorDetails errorDetailsDeserialize = RestJsonErrorDeserializer.INSTANCE.deserialize(httpCall.getResponse().getHeaders(), bArr);
            String code = errorDetailsDeserialize.getCode();
            if (code != null) {
                switch (code.hashCode()) {
                    case -1362904677:
                        ssoException = !code.equals("UnauthorizedException") ? new SsoException(errorDetailsDeserialize.getMessage()) : new UnauthorizedExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                        break;
                    case 1148038775:
                        if (code.equals("InvalidRequestException")) {
                            ssoException = new InvalidRequestExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case 1384808312:
                        if (code.equals("TooManyRequestsException")) {
                            ssoException = new TooManyRequestsExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case 1821306386:
                        if (code.equals("ResourceNotFoundException")) {
                            ssoException = new ResourceNotFoundExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                }
            }
            ProtocolErrorsKt.setAseErrorMetadata(ssoException, httpResponseWithPayload, errorDetailsDeserialize);
            throw ssoException;
        } catch (Exception e) {
            SsoException ssoException2 = new SsoException("Failed to parse response as 'restJson1' error", e);
            ProtocolErrorsKt.setAseErrorMetadata(ssoException2, httpCallCopy$default.getResponse(), null);
            throw ssoException2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deserializeGetRoleCredentialsOperationBody(GetRoleCredentialsResponse.Builder builder, byte[] bArr) {
        JsonDeserializer jsonDeserializer = new JsonDeserializer(bArr);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new JsonSerialName("roleCredentials"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder2 = new SdkObjectDescriptor.Builder();
        builder2.field(sdkFieldDescriptor);
        JsonDeserializer jsonDeserializer2 = jsonDeserializer;
        Deserializer.FieldIterator fieldIteratorDeserializeStruct = jsonDeserializer2.deserializeStruct(builder2.build());
        while (true) {
            Integer numFindNextFieldIndex = fieldIteratorDeserializeStruct.findNextFieldIndex();
            int index = sdkFieldDescriptor.getIndex();
            if (numFindNextFieldIndex != null && numFindNextFieldIndex.intValue() == index) {
                builder.setRoleCredentials(RoleCredentialsDocumentDeserializerKt.deserializeRoleCredentialsDocument(jsonDeserializer2));
            } else if (numFindNextFieldIndex == null) {
                return;
            } else {
                fieldIteratorDeserializeStruct.skipValue();
            }
        }
    }
}

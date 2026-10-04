package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.serde;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.AccessDeniedException;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.SigninException;
import aws.smithy.kotlin.runtime.awsprotocol.ErrorDetails;
import aws.smithy.kotlin.runtime.awsprotocol.ProtocolErrorsKt;
import aws.smithy.kotlin.runtime.awsprotocol.ResponseUtilsKt;
import aws.smithy.kotlin.runtime.awsprotocol.json.RestJsonErrorDeserializer;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;

/* JADX INFO: compiled from: CreateOAuth2TokenOperationDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\b"}, m1599d2 = {"throwCreateOAuth2TokenError", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "payload", "", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateOAuth2TokenOperationDeserializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Void throwCreateOAuth2TokenError(ExecutionContext executionContext, HttpCall httpCall, byte[] bArr) {
        AccessDeniedException signinException;
        HttpResponse httpResponseWithPayload = ResponseUtilsKt.withPayload(httpCall.getResponse(), bArr);
        HttpCall httpCallCopy$default = HttpCall.copy$default(httpCall, null, httpResponseWithPayload, 1, null);
        try {
            ErrorDetails errorDetailsDeserialize = RestJsonErrorDeserializer.INSTANCE.deserialize(httpCall.getResponse().getHeaders(), bArr);
            String code = errorDetailsDeserialize.getCode();
            if (code != null) {
                switch (code.hashCode()) {
                    case 122859728:
                        signinException = !code.equals("AccessDeniedException") ? new SigninException(errorDetailsDeserialize.getMessage()) : new AccessDeniedExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                        break;
                    case 734598063:
                        if (code.equals("InternalServerException")) {
                            signinException = new InternalServerExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case 973045169:
                        if (code.equals("TooManyRequestsError")) {
                            signinException = new TooManyRequestsErrorDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                    case 1601562550:
                        if (code.equals("ValidationException")) {
                            signinException = new ValidationExceptionDeserializer().deserialize(executionContext, httpCallCopy$default, bArr);
                            break;
                        }
                        break;
                }
            }
            ProtocolErrorsKt.setAseErrorMetadata(signinException, httpResponseWithPayload, errorDetailsDeserialize);
            throw signinException;
        } catch (Exception e) {
            SigninException signinException2 = new SigninException("Failed to parse response as 'restJson1' error", e);
            ProtocolErrorsKt.setAseErrorMetadata(signinException2, httpCallCopy$default.getResponse(), null);
            throw signinException2;
        }
    }
}

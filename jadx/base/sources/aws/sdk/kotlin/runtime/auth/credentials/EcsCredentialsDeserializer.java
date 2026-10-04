package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.runtime.auth.credentials.JsonCredentialsResponse;
import aws.sdk.kotlin.runtime.auth.credentials.internal.CredentialsExtKt;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderException;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.HttpStatusCodeKt;
import aws.smithy.kotlin.runtime.http.operation.HttpDeserializer;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.serde.json.JsonDeserializer;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EcsCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/EcsCredentialsDeserializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer$NonStreaming;", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "<init>", "()V", "deserialize", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "payload", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class EcsCredentialsDeserializer implements HttpDeserializer.NonStreaming<Credentials> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpDeserializer.NonStreaming
    public Credentials deserialize(ExecutionContext context, HttpCall call, byte[] payload) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(call, "call");
        HttpResponse response = call.getResponse();
        if (!HttpStatusCodeKt.isSuccess(response.getStatus())) {
            EcsCredentialsProviderKt.throwCredentialsResponseException(response, payload);
            throw new KotlinNothingValueException();
        }
        if (payload == null) {
            throw new CredentialsProviderException("HTTP credentials response did not contain a payload", null, 2, null);
        }
        JsonCredentialsResponse jsonCredentialsResponseDeserializeJsonCredentials = JsonCredentialsDeserializerKt.deserializeJsonCredentials(new JsonDeserializer(payload));
        if (!(jsonCredentialsResponseDeserializeJsonCredentials instanceof JsonCredentialsResponse.SessionCredentials)) {
            throw new CredentialsProviderException("HTTP credentials response was not of expected format", null, 2, null);
        }
        JsonCredentialsResponse.SessionCredentials sessionCredentials = (JsonCredentialsResponse.SessionCredentials) jsonCredentialsResponseDeserializeJsonCredentials;
        return CredentialsExtKt.credentials(sessionCredentials.getAccessKeyId(), sessionCredentials.getSecretAccessKey(), sessionCredentials.getSessionToken(), sessionCredentials.getExpiration(), "EcsContainer", sessionCredentials.getAccountId());
    }
}

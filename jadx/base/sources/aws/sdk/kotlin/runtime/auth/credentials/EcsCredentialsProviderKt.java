package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.auth.credentials.JsonCredentialsResponse;
import aws.smithy.kotlin.runtime.ErrorMetadata;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderException;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.http.HttpStatusCodeKt;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.net.IpAddr;
import aws.smithy.kotlin.runtime.net.IpV4Addr;
import aws.smithy.kotlin.runtime.net.IpV6Addr;
import aws.smithy.kotlin.runtime.serde.json.JsonDeserializer;
import com.google.common.base.Ascii;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EcsCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002\u001a\u001c\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"AWS_CONTAINER_SERVICE_ENDPOINT", "", "PROVIDER_NAME", "throwCredentialsResponseException", "", "response", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "payload", "", "tryParseErrorResponse", "Laws/sdk/kotlin/runtime/auth/credentials/JsonCredentialsResponse$Error;", "ecsV4Addr", "Laws/smithy/kotlin/runtime/net/IpV4Addr;", "eksV4Addr", "eksV6Addr", "Laws/smithy/kotlin/runtime/net/IpV6Addr;", "allowedAddrs", "", "Laws/smithy/kotlin/runtime/net/IpAddr;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EcsCredentialsProviderKt {
    private static final String AWS_CONTAINER_SERVICE_ENDPOINT = "http://169.254.170.2";
    private static final String PROVIDER_NAME = "EcsContainer";
    private static final Set<IpAddr> allowedAddrs;
    private static final IpV4Addr ecsV4Addr;
    private static final IpV4Addr eksV4Addr;
    private static final IpV6Addr eksV6Addr;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void throwCredentialsResponseException(HttpResponse httpResponse, byte[] bArr) {
        String str;
        JsonCredentialsResponse.Error errorTryParseErrorResponse = tryParseErrorResponse(httpResponse, bArr);
        if (errorTryParseErrorResponse == null || (str = "code=" + errorTryParseErrorResponse.getCode() + "; message=" + errorTryParseErrorResponse.getMessage()) == null) {
            str = "HTTP " + httpResponse.getStatus();
        }
        CredentialsProviderException credentialsProviderException = new CredentialsProviderException("Error retrieving credentials from container service: " + str, null, 2, null);
        credentialsProviderException.getSdkErrorMetadata().getAttributes().set(ErrorMetadata.INSTANCE.getThrottlingError(), Boolean.valueOf(Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getTooManyRequests())));
        credentialsProviderException.getSdkErrorMetadata().getAttributes().set(ErrorMetadata.INSTANCE.getRetryable(), Boolean.valueOf(credentialsProviderException.getSdkErrorMetadata().isThrottling() || HttpStatusCodeKt.category(httpResponse.getStatus()) == HttpStatusCode.Category.SERVER_ERROR));
        throw credentialsProviderException;
    }

    private static final JsonCredentialsResponse.Error tryParseErrorResponse(HttpResponse httpResponse, byte[] bArr) {
        if (Intrinsics.areEqual(httpResponse.getHeaders().get("Content-Type"), "application/json") && bArr != null) {
            JsonCredentialsResponse jsonCredentialsResponseDeserializeJsonCredentials = JsonCredentialsDeserializerKt.deserializeJsonCredentials(new JsonDeserializer(bArr));
            if (jsonCredentialsResponseDeserializeJsonCredentials instanceof JsonCredentialsResponse.Error) {
                return (JsonCredentialsResponse.Error) jsonCredentialsResponseDeserializeJsonCredentials;
            }
        }
        return null;
    }

    static {
        IpV4Addr ipV4Addr = new IpV4Addr((byte) -87, (byte) -2, (byte) -86, (byte) 2, null);
        ecsV4Addr = ipV4Addr;
        IpV4Addr ipV4Addr2 = new IpV4Addr((byte) -87, (byte) -2, (byte) -86, Ascii.ETB, null);
        eksV4Addr = ipV4Addr2;
        IpV6Addr ipV6Addr = new IpV6Addr((short) -768, (short) 3778, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 35, null, 256, null);
        eksV6Addr = ipV6Addr;
        allowedAddrs = SetsKt.setOf((Object[]) new IpAddr[]{IpV4Addr.INSTANCE.getLOCALHOST(), IpV6Addr.INSTANCE.getLOCALHOST(), ipV4Addr, ipV4Addr2, ipV6Addr});
    }
}

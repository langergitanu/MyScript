package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImdsEndpointProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m1599d2 = {"EC2_METADATA_SERVICE_ENDPOINT_PROFILE_KEY", "", "EC2_METADATA_SERVICE_ENDPOINT_MODE_PROFILE_KEY", "toEndpoint", "Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ImdsEndpointProviderKt {
    public static final String EC2_METADATA_SERVICE_ENDPOINT_MODE_PROFILE_KEY = "ec2_metadata_service_endpoint_mode";
    public static final String EC2_METADATA_SERVICE_ENDPOINT_PROFILE_KEY = "ec2_metadata_service_endpoint";

    public static final Endpoint toEndpoint(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Endpoint(str);
    }
}

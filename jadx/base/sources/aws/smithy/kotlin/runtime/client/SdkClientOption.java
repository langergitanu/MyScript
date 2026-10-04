package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.collections.AttributeKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: SdkClientOption.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\b¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/SdkClientOption;", "", "<init>", "()V", "OperationName", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "", "getOperationName", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "ServiceName", "getServiceName", "ClientName", "getClientName", "IdempotencyTokenProvider", "Laws/smithy/kotlin/runtime/client/IdempotencyTokenProvider;", "getIdempotencyTokenProvider", "LogMode", "Laws/smithy/kotlin/runtime/client/LogMode;", "getLogMode", "EndpointDiscoveryEnabled", "", "getEndpointDiscoveryEnabled", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkClientOption {
    public static final SdkClientOption INSTANCE = new SdkClientOption();
    private static final AttributeKey<String> OperationName = new AttributeKey<>("aws.smithy.kotlin#OperationName");
    private static final AttributeKey<String> ServiceName = new AttributeKey<>("aws.smithy.kotlin#ServiceName");
    private static final AttributeKey<String> ClientName = new AttributeKey<>("aws.smithy.kotlin#ClientName");
    private static final AttributeKey<IdempotencyTokenProvider> IdempotencyTokenProvider = new AttributeKey<>("aws.smithy.kotlin#IdempotencyTokenProvider");
    private static final AttributeKey<LogMode> LogMode = new AttributeKey<>("aws.smithy.kotlin#LogMode");
    private static final AttributeKey<Boolean> EndpointDiscoveryEnabled = new AttributeKey<>("aws.smithy.kotlin#EndpointDiscoveryEnabled");

    private SdkClientOption() {
    }

    public final AttributeKey<String> getOperationName() {
        return OperationName;
    }

    public final AttributeKey<String> getServiceName() {
        return ServiceName;
    }

    public final AttributeKey<String> getClientName() {
        return ClientName;
    }

    public final AttributeKey<IdempotencyTokenProvider> getIdempotencyTokenProvider() {
        return IdempotencyTokenProvider;
    }

    public final AttributeKey<LogMode> getLogMode() {
        return LogMode;
    }

    public final AttributeKey<Boolean> getEndpointDiscoveryEnabled() {
        return EndpointDiscoveryEnabled;
    }
}

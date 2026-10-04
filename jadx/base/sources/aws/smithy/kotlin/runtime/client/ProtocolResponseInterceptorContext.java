package aws.smithy.kotlin.runtime.client;

import kotlin.Metadata;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004R\u0012\u0010\u0005\u001a\u00028\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;", "I", "ProtocolRequest", "ProtocolResponse", "Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;", "protocolResponse", "getProtocolResponse", "()Ljava/lang/Object;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ProtocolResponseInterceptorContext<I, ProtocolRequest, ProtocolResponse> extends ProtocolRequestInterceptorContext<I, ProtocolRequest> {
    ProtocolResponse getProtocolResponse();
}

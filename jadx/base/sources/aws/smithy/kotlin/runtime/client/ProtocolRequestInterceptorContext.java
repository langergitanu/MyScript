package aws.smithy.kotlin.runtime.client;

import kotlin.Metadata;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0012\u0010\u0004\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;", "I", "ProtocolRequest", "Laws/smithy/kotlin/runtime/client/RequestInterceptorContext;", "protocolRequest", "getProtocolRequest", "()Ljava/lang/Object;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ProtocolRequestInterceptorContext<I, ProtocolRequest> extends RequestInterceptorContext<I> {
    ProtocolRequest getProtocolRequest();
}

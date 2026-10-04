package aws.smithy.kotlin.runtime.client;

import kotlin.Metadata;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/ResponseInterceptorContext;", "I", "O", "ProtocolRequest", "ProtocolResponse", "Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;", "response", "Lkotlin/Result;", "getResponse-d1pmJ48", "()Ljava/lang/Object;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ResponseInterceptorContext<I, O, ProtocolRequest, ProtocolResponse> extends ProtocolResponseInterceptorContext<I, ProtocolRequest, ProtocolResponse> {
    /* JADX INFO: renamed from: getResponse-d1pmJ48, reason: not valid java name */
    Object mo12149getResponsed1pmJ48();
}

package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.operation.ModifyRequestMiddleware;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MutateHeaders.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BI\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\rJ,\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u00112\u0010\u0010\u0012\u001a\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/middleware/MutateHeaders;", "Laws/smithy/kotlin/runtime/http/operation/ModifyRequestMiddleware;", "", "", "override", "append", "setMissing", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "name", "value", "", "set", "(Ljava/lang/String;Ljava/lang/String;)V", "setIfMissing", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "req", "modifyRequest", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/http/HeadersBuilder;", "overrides", "Laws/smithy/kotlin/runtime/http/HeadersBuilder;", "additional", "conditionallySet", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MutateHeaders implements ModifyRequestMiddleware {
    private final HeadersBuilder additional;
    private final HeadersBuilder conditionallySet;
    private final HeadersBuilder overrides;

    public MutateHeaders() {
        this(null, null, null, 7, null);
    }

    public MutateHeaders(Map<String, String> override, Map<String, String> append, Map<String, String> setMissing) {
        Intrinsics.checkNotNullParameter(override, "override");
        Intrinsics.checkNotNullParameter(append, "append");
        Intrinsics.checkNotNullParameter(setMissing, "setMissing");
        this.overrides = new HeadersBuilder();
        this.additional = new HeadersBuilder();
        this.conditionallySet = new HeadersBuilder();
        for (Map.Entry<String, String> entry : override.entrySet()) {
            set(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, String> entry2 : append.entrySet()) {
            append(entry2.getKey(), entry2.getValue());
        }
        for (Map.Entry<String, String> entry3 : setMissing.entrySet()) {
            setIfMissing(entry3.getKey(), entry3.getValue());
        }
    }

    @Override // aws.smithy.kotlin.runtime.http.operation.ModifyRequestMiddleware
    @InternalApi
    public /* bridge */ void install(SdkHttpOperation<?, ?> sdkHttpOperation) {
        super.install(sdkHttpOperation);
    }

    public /* synthetic */ MutateHeaders(Map map, Map map2, Map map3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? MapsKt.emptyMap() : map2, (i & 4) != 0 ? MapsKt.emptyMap() : map3);
    }

    public final void set(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.overrides.set(name, value);
    }

    public final void append(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.additional.append(name, value);
    }

    public final void setIfMissing(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.conditionallySet.append(name, value);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.middleware.ModifyRequest
    public Object modifyRequest(OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super OperationRequest<HttpRequestBuilder>> continuation) {
        Iterator<T> it = this.additional.entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            operationRequest.getSubject().getHeaders().appendAll((String) entry.getKey(), (List) entry.getValue());
        }
        Iterator<T> it2 = this.overrides.entries().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            operationRequest.getSubject().getHeaders().set((String) entry2.getKey(), CollectionsKt.last((List) entry2.getValue()));
        }
        Iterator<T> it3 = this.conditionallySet.entries().iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            String str = (String) entry3.getKey();
            List list = (List) entry3.getValue();
            if (!operationRequest.getSubject().getHeaders().contains(str)) {
                operationRequest.getSubject().getHeaders().set(str, CollectionsKt.last(list));
            }
        }
        return operationRequest;
    }
}

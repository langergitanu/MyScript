package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.http.engine.internal.HttpClientMetrics;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OkHttpUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/SdkRequestTag;", "", "execContext", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "metrics", "Laws/smithy/kotlin/runtime/http/engine/internal/HttpClientMetrics;", "<init>", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Lkotlin/coroutines/CoroutineContext;Laws/smithy/kotlin/runtime/http/engine/internal/HttpClientMetrics;)V", "getExecContext", "()Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "getCallContext", "()Lkotlin/coroutines/CoroutineContext;", "getMetrics", "()Laws/smithy/kotlin/runtime/http/engine/internal/HttpClientMetrics;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class SdkRequestTag {
    private final CoroutineContext callContext;
    private final ExecutionContext execContext;
    private final HttpClientMetrics metrics;

    public static /* synthetic */ SdkRequestTag copy$default(SdkRequestTag sdkRequestTag, ExecutionContext executionContext, CoroutineContext coroutineContext, HttpClientMetrics httpClientMetrics, int i, Object obj) {
        if ((i & 1) != 0) {
            executionContext = sdkRequestTag.execContext;
        }
        if ((i & 2) != 0) {
            coroutineContext = sdkRequestTag.callContext;
        }
        if ((i & 4) != 0) {
            httpClientMetrics = sdkRequestTag.metrics;
        }
        return sdkRequestTag.copy(executionContext, coroutineContext, httpClientMetrics);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ExecutionContext getExecContext() {
        return this.execContext;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CoroutineContext getCallContext() {
        return this.callContext;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final HttpClientMetrics getMetrics() {
        return this.metrics;
    }

    public final SdkRequestTag copy(ExecutionContext execContext, CoroutineContext callContext, HttpClientMetrics metrics) {
        Intrinsics.checkNotNullParameter(execContext, "execContext");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return new SdkRequestTag(execContext, callContext, metrics);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SdkRequestTag)) {
            return false;
        }
        SdkRequestTag sdkRequestTag = (SdkRequestTag) other;
        return Intrinsics.areEqual(this.execContext, sdkRequestTag.execContext) && Intrinsics.areEqual(this.callContext, sdkRequestTag.callContext) && Intrinsics.areEqual(this.metrics, sdkRequestTag.metrics);
    }

    public int hashCode() {
        return (((this.execContext.hashCode() * 31) + this.callContext.hashCode()) * 31) + this.metrics.hashCode();
    }

    public String toString() {
        return "SdkRequestTag(execContext=" + this.execContext + ", callContext=" + this.callContext + ", metrics=" + this.metrics + ')';
    }

    public SdkRequestTag(ExecutionContext execContext, CoroutineContext callContext, HttpClientMetrics metrics) {
        Intrinsics.checkNotNullParameter(execContext, "execContext");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this.execContext = execContext;
        this.callContext = callContext;
        this.metrics = metrics;
    }

    public final CoroutineContext getCallContext() {
        return this.callContext;
    }

    public final ExecutionContext getExecContext() {
        return this.execContext;
    }

    public final HttpClientMetrics getMetrics() {
        return this.metrics;
    }
}

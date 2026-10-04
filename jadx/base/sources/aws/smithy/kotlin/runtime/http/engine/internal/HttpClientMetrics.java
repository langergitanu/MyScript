package aws.smithy.kotlin.runtime.http.engine.internal;

import androidx.media3.exoplayer.upstream.CmcdData;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.metrics.AsyncMeasurement;
import aws.smithy.kotlin.runtime.telemetry.metrics.AsyncMeasurementHandle;
import aws.smithy.kotlin.runtime.telemetry.metrics.Histogram;
import aws.smithy.kotlin.runtime.telemetry.metrics.Meter;
import aws.smithy.kotlin.runtime.telemetry.metrics.MonotonicCounter;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpClientMetrics.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0010\u0010\f\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u00020\r2\u0010\u0010\f\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R!\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR!\u0010 \u001a\f\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001b8\u0006¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR!\u0010\"\u001a\f\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001b8\u0006¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010&R\u0017\u0010+\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010/\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b0\u0010.R!\u00101\u001a\f\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001b8\u0006¢\u0006\f\n\u0004\b1\u0010\u001d\u001a\u0004\b2\u0010\u001fR$\u00108\u001a\u00020\n2\u0006\u00103\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010;\u001a\u00020\n2\u0006\u00103\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u00105\"\u0004\b:\u00107R$\u0010>\u001a\u00020\n2\u0006\u00103\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u00105\"\u0004\b=\u00107R$\u0010A\u001a\u00020\n2\u0006\u00103\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u00105\"\u0004\b@\u00107R$\u0010D\u001a\u00020\n2\u0006\u00103\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u00105\"\u0004\bC\u00107R$\u0010G\u001a\u00020\n2\u0006\u00103\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u00105\"\u0004\bF\u00107¨\u0006H"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/internal/HttpClientMetrics;", "Ljava/io/Closeable;", "Laws/smithy/kotlin/runtime/io/Closeable;", "", "scope", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "provider", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;)V", "Laws/smithy/kotlin/runtime/telemetry/metrics/AsyncMeasurement;", "", "Laws/smithy/kotlin/runtime/telemetry/metrics/LongAsyncMeasurement;", "measurement", "", "recordRequestsState", "(Laws/smithy/kotlin/runtime/telemetry/metrics/AsyncMeasurement;)V", "recordConnectionState", "close", "()V", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getProvider", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "Laws/smithy/kotlin/runtime/telemetry/metrics/Meter;", "meter", "Laws/smithy/kotlin/runtime/telemetry/metrics/Meter;", "Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;", "", "Laws/smithy/kotlin/runtime/telemetry/metrics/DoubleHistogram;", "connectionAcquireDuration", "Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;", "getConnectionAcquireDuration", "()Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;", "requestsQueuedDuration", "getRequestsQueuedDuration", "connectionUptime", "getConnectionUptime", "Laws/smithy/kotlin/runtime/telemetry/metrics/AsyncMeasurementHandle;", "connectionLimitHandle", "Laws/smithy/kotlin/runtime/telemetry/metrics/AsyncMeasurementHandle;", "connectionUsageHandle", "requestsConcurrencyLimitHandle", "requestsHandle", "Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;", "bytesSent", "Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;", "getBytesSent", "()Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;", "bytesReceived", "getBytesReceived", "timeToFirstByteDuration", "getTimeToFirstByteDuration", "value", "getConnectionsLimit", "()J", "setConnectionsLimit", "(J)V", "connectionsLimit", "getRequestConcurrencyLimit", "setRequestConcurrencyLimit", "requestConcurrencyLimit", "getIdleConnections", "setIdleConnections", "idleConnections", "getAcquiredConnections", "setAcquiredConnections", "acquiredConnections", "getQueuedRequests", "setQueuedRequests", "queuedRequests", "getInFlightRequests", "setInFlightRequests", "inFlightRequests", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpClientMetrics implements Closeable {
    private volatile /* synthetic */ long _acquiredConnections;
    private volatile /* synthetic */ long _connectionsLimit;
    private volatile /* synthetic */ long _idleConnections;
    private volatile /* synthetic */ long _inFlightRequests;
    private volatile /* synthetic */ long _queuedRequests;
    private volatile /* synthetic */ long _requestConcurrencyLimit;
    private final MonotonicCounter bytesReceived;
    private final MonotonicCounter bytesSent;
    private final Histogram<Double> connectionAcquireDuration;
    private final AsyncMeasurementHandle connectionLimitHandle;
    private final Histogram<Double> connectionUptime;
    private final AsyncMeasurementHandle connectionUsageHandle;
    private final Meter meter;
    private final TelemetryProvider provider;
    private final AsyncMeasurementHandle requestsConcurrencyLimitHandle;
    private final AsyncMeasurementHandle requestsHandle;
    private final Histogram<Double> requestsQueuedDuration;
    private final Histogram<Double> timeToFirstByteDuration;
    private static final /* synthetic */ AtomicLongFieldUpdater _connectionsLimit$FU = AtomicLongFieldUpdater.newUpdater(HttpClientMetrics.class, "_connectionsLimit");
    private static final /* synthetic */ AtomicLongFieldUpdater _idleConnections$FU = AtomicLongFieldUpdater.newUpdater(HttpClientMetrics.class, "_idleConnections");
    private static final /* synthetic */ AtomicLongFieldUpdater _acquiredConnections$FU = AtomicLongFieldUpdater.newUpdater(HttpClientMetrics.class, "_acquiredConnections");
    private static final /* synthetic */ AtomicLongFieldUpdater _requestConcurrencyLimit$FU = AtomicLongFieldUpdater.newUpdater(HttpClientMetrics.class, "_requestConcurrencyLimit");
    private static final /* synthetic */ AtomicLongFieldUpdater _queuedRequests$FU = AtomicLongFieldUpdater.newUpdater(HttpClientMetrics.class, "_queuedRequests");
    private static final /* synthetic */ AtomicLongFieldUpdater _inFlightRequests$FU = AtomicLongFieldUpdater.newUpdater(HttpClientMetrics.class, "_inFlightRequests");

    public HttpClientMetrics(String scope, TelemetryProvider provider) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.provider = provider;
        Meter orCreateMeter = provider.getMeterProvider().getOrCreateMeter(scope);
        this.meter = orCreateMeter;
        this._connectionsLimit = 0L;
        this._idleConnections = 0L;
        this._acquiredConnections = 0L;
        this._requestConcurrencyLimit = 0L;
        this._queuedRequests = 0L;
        this._inFlightRequests = 0L;
        this.connectionAcquireDuration = orCreateMeter.createDoubleHistogram("smithy.client.http.connections.acquire_duration", CmcdData.STREAMING_FORMAT_SS, "The amount of time requests take to acquire a connection from the pool");
        this.requestsQueuedDuration = orCreateMeter.createDoubleHistogram("smithy.client.http.requests.queued_duration", CmcdData.STREAMING_FORMAT_SS, "The amount of time a request spent queued waiting to be executed by the HTTP client");
        this.connectionUptime = orCreateMeter.createDoubleHistogram("smithy.client.http.connections.uptime", CmcdData.STREAMING_FORMAT_SS, "The amount of time a connection has been open");
        this.connectionLimitHandle = orCreateMeter.createAsyncUpDownCounter("smithy.client.http.connections.limit", new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.internal.HttpClientMetrics$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HttpClientMetrics.connectionLimitHandle$lambda$0(this.f$0, (AsyncMeasurement) obj);
            }
        }, "{connection}", "Max connections configured for the HTTP client");
        this.connectionUsageHandle = orCreateMeter.createAsyncUpDownCounter("smithy.client.http.connections.usage", new HttpClientMetrics$connectionUsageHandle$1(this), "{connection}", "Current state of connections (idle, acquired)");
        this.requestsConcurrencyLimitHandle = orCreateMeter.createAsyncUpDownCounter("smithy.client.http.requests.limit", new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.internal.HttpClientMetrics$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HttpClientMetrics.requestsConcurrencyLimitHandle$lambda$0(this.f$0, (AsyncMeasurement) obj);
            }
        }, "{request}", "Max concurrent requests configured for the HTTP client");
        this.requestsHandle = orCreateMeter.createAsyncUpDownCounter("smithy.client.http.requests.usage", new HttpClientMetrics$requestsHandle$1(this), "{request}", "The current state of HTTP client request concurrency (queued, in-flight)");
        this.bytesSent = orCreateMeter.createMonotonicCounter("smithy.client.http.bytes_sent", "By", "The total number of bytes sent by the HTTP client");
        this.bytesReceived = orCreateMeter.createMonotonicCounter("smithy.client.http.bytes_received", "By", "The total number of bytes received by the HTTP client");
        this.timeToFirstByteDuration = orCreateMeter.createDoubleHistogram("smithy.client.http.time_to_first_byte", CmcdData.STREAMING_FORMAT_SS, "The amount of time after a request has been sent spent waiting on a response from the remote server");
    }

    public final TelemetryProvider getProvider() {
        return this.provider;
    }

    public final Histogram<Double> getConnectionAcquireDuration() {
        return this.connectionAcquireDuration;
    }

    public final Histogram<Double> getRequestsQueuedDuration() {
        return this.requestsQueuedDuration;
    }

    public final Histogram<Double> getConnectionUptime() {
        return this.connectionUptime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectionLimitHandle$lambda$0(HttpClientMetrics httpClientMetrics, AsyncMeasurement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AsyncMeasurement.record$default(it, Long.valueOf(httpClientMetrics._connectionsLimit), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestsConcurrencyLimitHandle$lambda$0(HttpClientMetrics httpClientMetrics, AsyncMeasurement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AsyncMeasurement.record$default(it, Long.valueOf(httpClientMetrics._requestConcurrencyLimit), null, null, 6, null);
        return Unit.INSTANCE;
    }

    public final MonotonicCounter getBytesSent() {
        return this.bytesSent;
    }

    public final MonotonicCounter getBytesReceived() {
        return this.bytesReceived;
    }

    public final Histogram<Double> getTimeToFirstByteDuration() {
        return this.timeToFirstByteDuration;
    }

    /* JADX INFO: renamed from: getConnectionsLimit, reason: from getter */
    public final long get_connectionsLimit() {
        return this._connectionsLimit;
    }

    /* JADX INFO: renamed from: getRequestConcurrencyLimit, reason: from getter */
    public final long get_requestConcurrencyLimit() {
        return this._requestConcurrencyLimit;
    }

    /* JADX INFO: renamed from: getIdleConnections, reason: from getter */
    public final long get_idleConnections() {
        return this._idleConnections;
    }

    /* JADX INFO: renamed from: getAcquiredConnections, reason: from getter */
    public final long get_acquiredConnections() {
        return this._acquiredConnections;
    }

    /* JADX INFO: renamed from: getQueuedRequests, reason: from getter */
    public final long get_queuedRequests() {
        return this._queuedRequests;
    }

    /* JADX INFO: renamed from: getInFlightRequests, reason: from getter */
    public final long get_inFlightRequests() {
        return this._inFlightRequests;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordRequestsState(AsyncMeasurement<Long> measurement) {
        AsyncMeasurement.record$default(measurement, Long.valueOf(get_inFlightRequests()), HttpClientMetricAttributes.INSTANCE.getInFlightRequest(), null, 4, null);
        AsyncMeasurement.record$default(measurement, Long.valueOf(get_queuedRequests()), HttpClientMetricAttributes.INSTANCE.getQueuedRequest(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordConnectionState(AsyncMeasurement<Long> measurement) {
        AsyncMeasurement.record$default(measurement, Long.valueOf(get_idleConnections()), HttpClientMetricAttributes.INSTANCE.getIdleConnection(), null, 4, null);
        AsyncMeasurement.record$default(measurement, Long.valueOf(get_acquiredConnections()), HttpClientMetricAttributes.INSTANCE.getAcquiredConnection(), null, 4, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Object objM14499constructorimpl;
        Object objM14499constructorimpl2;
        Object objM14499constructorimpl3;
        Object objM14499constructorimpl4;
        Result[] resultArr = new Result[4];
        AsyncMeasurementHandle asyncMeasurementHandle = this.connectionLimitHandle;
        try {
            Result.Companion companion = Result.INSTANCE;
            asyncMeasurementHandle.stop();
            objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        resultArr[0] = Result.m14498boximpl(objM14499constructorimpl);
        AsyncMeasurementHandle asyncMeasurementHandle2 = this.connectionUsageHandle;
        try {
            Result.Companion companion3 = Result.INSTANCE;
            asyncMeasurementHandle2.stop();
            objM14499constructorimpl2 = Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(th2));
        }
        resultArr[1] = Result.m14498boximpl(objM14499constructorimpl2);
        AsyncMeasurementHandle asyncMeasurementHandle3 = this.requestsHandle;
        try {
            Result.Companion companion5 = Result.INSTANCE;
            asyncMeasurementHandle3.stop();
            objM14499constructorimpl3 = Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.INSTANCE;
            objM14499constructorimpl3 = Result.m14499constructorimpl(ResultKt.createFailure(th3));
        }
        resultArr[2] = Result.m14498boximpl(objM14499constructorimpl3);
        AsyncMeasurementHandle asyncMeasurementHandle4 = this.requestsConcurrencyLimitHandle;
        try {
            Result.Companion companion7 = Result.INSTANCE;
            asyncMeasurementHandle4.stop();
            objM14499constructorimpl4 = Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th4) {
            Result.Companion companion8 = Result.INSTANCE;
            objM14499constructorimpl4 = Result.m14499constructorimpl(ResultKt.createFailure(th4));
        }
        resultArr[3] = Result.m14498boximpl(objM14499constructorimpl4);
        List listListOf = CollectionsKt.listOf((Object[]) resultArr);
        ArrayList arrayList = new ArrayList();
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(((Result) it.next()).getValue());
            if (thM14502exceptionOrNullimpl != null) {
                arrayList.add(thM14502exceptionOrNullimpl);
            }
        }
        ArrayList arrayList2 = arrayList;
        Throwable th5 = (Throwable) CollectionsKt.firstOrNull((List) arrayList2);
        if (th5 != null) {
            Iterator it2 = CollectionsKt.drop(arrayList2, 1).iterator();
            while (it2.hasNext()) {
                th5.addSuppressed((Throwable) it2.next());
            }
            throw th5;
        }
    }

    public final void setConnectionsLimit(long j) {
        while (true) {
            long j2 = j;
            if (_connectionsLimit$FU.compareAndSet(this, this._connectionsLimit, j2)) {
                return;
            } else {
                j = j2;
            }
        }
    }

    public final void setRequestConcurrencyLimit(long j) {
        while (true) {
            long j2 = j;
            if (_requestConcurrencyLimit$FU.compareAndSet(this, this._requestConcurrencyLimit, j2)) {
                return;
            } else {
                j = j2;
            }
        }
    }

    public final void setIdleConnections(long j) {
        while (true) {
            long j2 = j;
            if (_idleConnections$FU.compareAndSet(this, this._idleConnections, j2)) {
                return;
            } else {
                j = j2;
            }
        }
    }

    public final void setAcquiredConnections(long j) {
        while (true) {
            long j2 = j;
            if (_acquiredConnections$FU.compareAndSet(this, this._acquiredConnections, j2)) {
                return;
            } else {
                j = j2;
            }
        }
    }

    public final void setQueuedRequests(long j) {
        while (true) {
            long j2 = j;
            if (_queuedRequests$FU.compareAndSet(this, this._queuedRequests, j2)) {
                return;
            } else {
                j = j2;
            }
        }
    }

    public final void setInFlightRequests(long j) {
        while (true) {
            long j2 = j;
            if (_inFlightRequests$FU.compareAndSet(this, this._inFlightRequests, j2)) {
                return;
            } else {
                j = j2;
            }
        }
    }
}

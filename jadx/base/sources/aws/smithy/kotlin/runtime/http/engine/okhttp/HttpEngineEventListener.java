package aws.smithy.kotlin.runtime.http.engine.okhttp;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.engine.EngineAttributes;
import aws.smithy.kotlin.runtime.http.engine.internal.HttpClientMetrics;
import aws.smithy.kotlin.runtime.net.DefaultHostResolverJVMKt;
import aws.smithy.kotlin.runtime.net.HostResolver;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContextKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.telemetry.logging.LoggerProvider;
import aws.smithy.kotlin.runtime.telemetry.metrics.HistogramKt;
import aws.smithy.kotlin.runtime.telemetry.trace.SpanStatus;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpanExtKt;
import aws.smithy.kotlin.runtime.telemetry.trace.Tracer;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpVersion;

/* JADX INFO: compiled from: HttpEngineEventListener.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u001e\u001a\u00020\u001f2\u0012\b\u0004\u0010 \u001a\f\u0012\u0004\u0012\u00020\"0!j\u0002`#H\u0082\bJ%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0012\b\u0004\u0010 \u001a\f\u0012\u0004\u0012\u00020\"0!j\u0002`#H\u0082\bJ\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\"H\u0016J&\u0010)\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\"2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0018\u0010-\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/H\u0016J&\u00100\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\f\u00101\u001a\b\u0012\u0004\u0012\u0002020+H\u0016J \u00103\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000202H\u0016J\u0010\u00107\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u00108\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J*\u0010;\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002022\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J2\u0010>\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002022\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010?\u001a\u00020@H\u0016J\u0018\u0010A\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010E\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010I\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020KH\u0016J\u0018\u0010L\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010M\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010N\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010R\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020KH\u0016J\u0018\u0010S\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020@H\u0016J\u0018\u0010T\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010U\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010V\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010W\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010X\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020PH\u0016J\u0018\u0010Y\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020PH\u0016J\u0018\u0010[\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010\\\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/HttpEngineEventListener;", "Lokhttp3/EventListener;", "pool", "Lokhttp3/ConnectionPool;", "hr", "Laws/smithy/kotlin/runtime/net/HostResolver;", "dispatcher", "Lokhttp3/Dispatcher;", "metrics", "Laws/smithy/kotlin/runtime/http/engine/internal/HttpClientMetrics;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "<init>", "(Lokhttp3/ConnectionPool;Laws/smithy/kotlin/runtime/net/HostResolver;Lokhttp3/Dispatcher;Laws/smithy/kotlin/runtime/http/engine/internal/HttpClientMetrics;Lokhttp3/Call;)V", "provider", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "traceSpan", "Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "logger", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "callTimeStart", "Lkotlin/time/TimeMark;", "signaledQueuedDuration", "", "queuedDuration", "Lkotlin/time/Duration;", "J", "signaledConnectAcquireDuration", "dnsStartTime", "requestTimeEnd", "trace", "", NotificationCompat.CATEGORY_MESSAGE, "Lkotlin/Function0;", "", "Laws/smithy/kotlin/runtime/telemetry/logging/MessageSupplier;", "throwable", "", "callStart", "dnsStart", "domainName", "dnsEnd", "inetAddressList", "", "Ljava/net/InetAddress;", "proxySelectStart", ImagesContract.URL, "Lokhttp3/HttpUrl;", "proxySelectEnd", "proxies", "Ljava/net/Proxy;", "connectStart", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "proxy", "secureConnectStart", "secureConnectEnd", "handshake", "Lokhttp3/Handshake;", "connectEnd", "protocol", "Lokhttp3/Protocol;", "connectFailed", "ioe", "Ljava/io/IOException;", "connectionAcquired", "connection", "Lokhttp3/Connection;", "requestHeadersStart", "requestHeadersEnd", "request", "Lokhttp3/Request;", "requestBodyStart", "requestBodyEnd", "byteCount", "", "requestFailed", "responseHeadersStart", "responseHeadersEnd", "response", "Lokhttp3/Response;", "responseBodyStart", "responseBodyEnd", "responseFailed", "connectionReleased", "callEnd", "callFailed", "canceled", "satisfactionFailure", "cacheConditionalHit", "cachedResponse", "cacheHit", "cacheMiss", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpEngineEventListener extends EventListener {
    private TimeMark callTimeStart;
    private final Dispatcher dispatcher;
    private TimeMark dnsStartTime;
    private final HostResolver hr;
    private final Logger logger;
    private final HttpClientMetrics metrics;
    private final ConnectionPool pool;
    private final TelemetryProvider provider;
    private long queuedDuration;
    private TimeMark requestTimeEnd;
    private boolean signaledConnectAcquireDuration;
    private boolean signaledQueuedDuration;
    private final TraceSpan traceSpan;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpEngineEventListener(ConnectionPool pool, HostResolver hr, Dispatcher dispatcher, HttpClientMetrics metrics, Call call) {
        Logger orCreateLogger;
        CoroutineContext callContext;
        CoroutineContext callContext2;
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(hr, "hr");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(call, "call");
        this.pool = pool;
        this.hr = hr;
        this.dispatcher = dispatcher;
        this.metrics = metrics;
        SdkRequestTag sdkRequestTag = (SdkRequestTag) call.request().tag(SdkRequestTag.class);
        TelemetryProvider none = (sdkRequestTag == null || (callContext2 = sdkRequestTag.getCallContext()) == null || (none = TelemetryProviderContextKt.getTelemetryProvider(callContext2)) == null) ? TelemetryProvider.INSTANCE.getNone() : none;
        this.provider = none;
        this.traceSpan = Tracer.createSpan$default(none.getTracerProvider().getOrCreateTracer(HttpEngineEventListenerKt.TELEMETRY_SCOPE), HttpVersion.HTTP, null, null, null, 14, null);
        SdkRequestTag sdkRequestTag2 = (SdkRequestTag) call.request().tag(SdkRequestTag.class);
        if (sdkRequestTag2 == null || (callContext = sdkRequestTag2.getCallContext()) == null) {
            LoggerProvider none2 = LoggerProvider.INSTANCE.getNone();
            String qualifiedName = Reflection.getOrCreateKotlinClass(OkHttpEngine.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("getLogger<T> cannot be used on an anonymous object".toString());
            }
            orCreateLogger = none2.getOrCreateLogger(qualifiedName);
        } else {
            String qualifiedName2 = Reflection.getOrCreateKotlinClass(OkHttpEngine.class).getQualifiedName();
            if (qualifiedName2 == null) {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            orCreateLogger = CoroutineContextLogExtKt.logger(callContext, qualifiedName2);
            if (orCreateLogger == null) {
            }
        }
        this.logger = orCreateLogger;
        Duration.Companion companion = Duration.INSTANCE;
        this.queuedDuration = DurationKt.toDuration(0, DurationUnit.SECONDS);
    }

    private final void trace(final Function0<String> msg) {
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener.trace.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return msg.invoke();
            }
        }, 1, null);
    }

    private final void trace(Throwable throwable, final Function0<String> msg) {
        this.logger.trace(throwable, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener.trace.2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return msg.invoke();
            }
        });
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.callTimeStart = TimeSource.Monotonic.ValueTimeMark.m15975boximpl(TimeSource.Monotonic.INSTANCE.m15974markNowz9LOYto());
        this.metrics.setQueuedRequests(this.dispatcher.queuedCallsCount());
        this.metrics.setInFlightRequests(this.dispatcher.runningCallsCount());
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$callStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "call started";
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, final String domainName) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        this.dnsStartTime = TimeSource.Monotonic.ValueTimeMark.m15975boximpl(TimeSource.Monotonic.INSTANCE.m15974markNowz9LOYto());
        if (!this.signaledQueuedDuration) {
            TimeMark timeMark = this.callTimeStart;
            if (timeMark == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            this.queuedDuration = timeMark.mo15844elapsedNowUwyO8pc();
            HistogramKt.m12286recordSecondsdWUq8MI$default(this.metrics.getRequestsQueuedDuration(), this.queuedDuration, null, null, 6, null);
            this.signaledQueuedDuration = true;
        }
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$dnsStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "dns query: domain=" + domainName;
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, final InetSocketAddress inetSocketAddress, final Proxy proxy, final Protocol protocol, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        this.logger.trace(ioe, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$connectFailed$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "connect failed: addr=" + inetSocketAddress + "; proxy=" + proxy + "; protocol=" + protocol;
            }
        });
        HostResolver hostResolver = this.hr;
        InetAddress address = inetSocketAddress.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
        hostResolver.reportFailure(DefaultHostResolverJVMKt.toHostAddress(address));
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, final Connection connection) {
        long jM15884minusLRDsOJo;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.metrics.setAcquiredConnections(this.pool.connectionCount());
        this.metrics.setIdleConnections(this.pool.idleConnectionCount());
        TimeMark timeMark = this.callTimeStart;
        if (timeMark == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        if (!this.signaledQueuedDuration) {
            this.signaledQueuedDuration = true;
            this.queuedDuration = timeMark.mo15844elapsedNowUwyO8pc();
            HistogramKt.m12286recordSecondsdWUq8MI$default(this.metrics.getRequestsQueuedDuration(), this.queuedDuration, null, null, 6, null);
        }
        if (!this.signaledConnectAcquireDuration) {
            this.signaledConnectAcquireDuration = true;
            TimeMark timeMark2 = this.dnsStartTime;
            if (timeMark2 != null) {
                Intrinsics.checkNotNull(timeMark2);
                jM15884minusLRDsOJo = timeMark2.mo15844elapsedNowUwyO8pc();
            } else {
                jM15884minusLRDsOJo = Duration.m15884minusLRDsOJo(timeMark.mo15844elapsedNowUwyO8pc(), this.queuedDuration);
            }
            HistogramKt.m12286recordSecondsdWUq8MI$default(this.metrics.getConnectionAcquireDuration(), jM15884minusLRDsOJo, null, null, 6, null);
        }
        final int iIdentityHashCode = System.identityHashCode(connection);
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$connectionAcquired$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "connection acquired: conn(id=" + iIdentityHashCode + ")=" + connection + "; connPool: total=" + this.pool.connectionCount() + ", idle=" + this.pool.idleConnectionCount();
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.body() == null) {
            this.requestTimeEnd = TimeSource.Monotonic.ValueTimeMark.m15975boximpl(TimeSource.Monotonic.INSTANCE.m15974markNowz9LOYto());
        }
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$requestHeadersEnd$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "finished sending request headers";
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, final long byteCount) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.requestTimeEnd = TimeSource.Monotonic.ValueTimeMark.m15975boximpl(TimeSource.Monotonic.INSTANCE.m15974markNowz9LOYto());
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$requestBodyEnd$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "finished sending request body: bytesSent=" + byteCount;
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void requestFailed(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        this.logger.trace(ioe, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$requestFailed$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "request failed";
            }
        });
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        ExecutionContext execContext;
        Intrinsics.checkNotNullParameter(call, "call");
        TimeMark timeMark = this.requestTimeEnd;
        if (timeMark != null) {
            long jMo15844elapsedNowUwyO8pc = timeMark.mo15844elapsedNowUwyO8pc();
            HistogramKt.m12286recordSecondsdWUq8MI$default(this.metrics.getTimeToFirstByteDuration(), jMo15844elapsedNowUwyO8pc, null, null, 6, null);
            SdkRequestTag sdkRequestTag = (SdkRequestTag) call.request().tag(SdkRequestTag.class);
            if (sdkRequestTag != null && (execContext = sdkRequestTag.getExecContext()) != null) {
                execContext.set(EngineAttributes.INSTANCE.getTimeToFirstByte(), Duration.m15854boximpl(jMo15844elapsedNowUwyO8pc));
            }
        }
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$responseHeadersStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "response headers start";
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        final long contentLength = response.body().getContentLength();
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$responseHeadersEnd$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "response headers end: contentLengthHeader=" + contentLength;
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void responseFailed(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        this.logger.trace(ioe, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$responseFailed$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "response failed";
            }
        });
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, final Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.metrics.setAcquiredConnections(this.pool.connectionCount());
        this.metrics.setIdleConnections(this.pool.idleConnectionCount());
        final int iIdentityHashCode = System.identityHashCode(connection);
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$connectionReleased$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "connection released: conn(id=" + iIdentityHashCode + ")=" + connection + "; connPool: total=" + this.pool.connectionCount() + ", idle=" + this.pool.idleConnectionCount();
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.metrics.setQueuedRequests(this.dispatcher.queuedCallsCount());
        this.metrics.setInFlightRequests(this.dispatcher.runningCallsCount());
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$callEnd$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "call complete";
            }
        }, 1, null);
        this.traceSpan.close();
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        this.metrics.setQueuedRequests(this.dispatcher.queuedCallsCount());
        this.metrics.setInFlightRequests(this.dispatcher.runningCallsCount());
        IOException iOException = ioe;
        this.logger.trace(iOException, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$callFailed$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "call failed";
            }
        });
        TraceSpanExtKt.recordException(this.traceSpan, iOException, true);
        this.traceSpan.setStatus(SpanStatus.ERROR);
        this.traceSpan.close();
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, final String domainName, final List<? extends InetAddress> inetAddressList) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        Intrinsics.checkNotNullParameter(inetAddressList, "inetAddressList");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$dnsEnd$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "dns resolved: domain=" + domainName + "; records=" + inetAddressList;
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void proxySelectStart(Call call, final HttpUrl url) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$proxySelectStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "proxy select start: url=" + url;
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void proxySelectEnd(Call call, final HttpUrl url, final List<? extends Proxy> proxies) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(proxies, "proxies");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$proxySelectEnd$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "proxy select end: url=" + url + "; proxies=" + proxies;
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, final InetSocketAddress inetSocketAddress, final Proxy proxy) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$connectStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "starting connection: addr=" + inetSocketAddress + "; proxy=" + proxy;
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$secureConnectStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "initiating TLS connection";
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, final Handshake handshake) {
        Intrinsics.checkNotNullParameter(call, "call");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$secureConnectEnd$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "TLS connect end: handshake=" + handshake;
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, final InetSocketAddress inetSocketAddress, final Proxy proxy, final Protocol protocol) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$connectEnd$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "connection established: addr=" + inetSocketAddress + "; proxy=" + proxy + "; protocol=" + protocol;
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$requestHeadersStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "sending request headers";
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$requestBodyStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "sending request body";
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$responseBodyStart$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "response body available";
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, final long byteCount) {
        Intrinsics.checkNotNullParameter(call, "call");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$responseBodyEnd$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "response body finished: bytesConsumed=" + byteCount;
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void canceled(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$canceled$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "call cancelled";
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void satisfactionFailure(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$satisfactionFailure$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "cache satisfaction failure";
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void cacheConditionalHit(Call call, Response cachedResponse) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$cacheConditionalHit$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "cache conditional hit";
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void cacheHit(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$cacheHit$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "cache hit";
            }
        }, 1, null);
    }

    @Override // okhttp3.EventListener
    public void cacheMiss(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        Logger.trace$default(this.logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener$cacheMiss$$inlined$trace$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "cache miss";
            }
        }, 1, null);
    }
}

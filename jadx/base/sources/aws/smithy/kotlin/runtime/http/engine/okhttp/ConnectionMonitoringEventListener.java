package aws.smithy.kotlin.runtime.http.engine.okhttp;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.internal._UtilCommonKt;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: compiled from: ConnectionMonitoringEventListener.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u001e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u001aR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/ConnectionMonitoringEventListener;", "Lokhttp3/EventListener;", "Ljava/io/Closeable;", "Laws/smithy/kotlin/runtime/io/Closeable;", "pollInterval", "Lkotlin/time/Duration;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "monitorScope", "Lkotlinx/coroutines/CoroutineScope;", "monitors", "Ljava/util/concurrent/ConcurrentHashMap;", "Lokhttp3/Connection;", "Lkotlinx/coroutines/Job;", "close", "", "callContext", "Lkotlin/coroutines/CoroutineContext;", "Lokhttp3/Call;", "connectionAcquired", NotificationCompat.CATEGORY_CALL, "connection", "connectionReleased", "doMonitor", "conn", "(Lokhttp3/Connection;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ConnectionMonitoringEventListener extends EventListener implements Closeable {
    private final CoroutineScope monitorScope;
    private final ConcurrentHashMap<Connection, Job> monitors;
    private final long pollInterval;

    public /* synthetic */ ConnectionMonitoringEventListener(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    private ConnectionMonitoringEventListener(long j) {
        this.pollInterval = j;
        this.monitorScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.monitors = new ConcurrentHashMap<>();
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$close$1 */
    /* JADX INFO: compiled from: ConnectionMonitoringEventListener.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$close$1", m1609f = "ConnectionMonitoringEventListener.kt", m1610i = {0, 0}, m1611l = {40}, m1612m = "invokeSuspend", m1613n = {"$this$runBlocking", "monitorJob"}, m1614nl = {41}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C37011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C37011(Continuation<? super C37011> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C37011 c37011 = ConnectionMonitoringEventListener.this.new C37011(continuation);
            c37011.L$0 = obj;
            return c37011;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C37011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext.Element element = ConnectionMonitoringEventListener.this.monitorScope.getCoroutineContext().get(Job.INSTANCE);
                if (element == null) {
                    throw new IllegalArgumentException(("Connection idle monitor scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
                }
                Job job = (Job) element;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(job);
                this.label = 1;
                if (JobKt.cancelAndJoin(job, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        BuildersKt__BuildersKt.runBlocking$default(null, new C37011(null), 1, null);
    }

    private final CoroutineContext callContext(Call call) {
        CoroutineContext callContext;
        SdkRequestTag sdkRequestTag = (SdkRequestTag) call.request().tag(SdkRequestTag.class);
        return (sdkRequestTag == null || (callContext = sdkRequestTag.getCallContext()) == null) ? Dispatchers.getIO() : callContext;
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, final Connection connection) throws InterruptedException {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        super.connectionAcquired(call, connection);
        Job jobRemove = this.monitors.remove(connection);
        if (jobRemove != null) {
            CoroutineContext coroutineContextCallContext = callContext(call);
            String qualifiedName = Reflection.getOrCreateKotlinClass(ConnectionMonitoringEventListener.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            Logger logger = CoroutineContextLogExtKt.logger(coroutineContextCallContext, qualifiedName);
            Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ConnectionMonitoringEventListener.connectionAcquired$lambda$0$0(connection);
                }
            }, 1, null);
            long jM15974markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m15974markNowz9LOYto();
            BuildersKt.runBlocking(coroutineContextCallContext, new C3702xfb7d1470(jobRemove, null));
            final long jM15979elapsedNowUwyO8pc = TimeSource.Monotonic.ValueTimeMark.m15979elapsedNowUwyO8pc(jM15974markNowz9LOYto);
            Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ConnectionMonitoringEventListener.connectionAcquired$lambda$0$2(connection, jM15979elapsedNowUwyO8pc);
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String connectionAcquired$lambda$0$0(Connection connection) {
        return "Cancel monitoring for " + connection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String connectionAcquired$lambda$0$2(Connection connection, long j) {
        return "Monitoring canceled for " + connection + " in " + ((Object) Duration.m15896toStringimpl(j));
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, final Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        super.connectionReleased(call, connection);
        int iIdentityHashCode = System.identityHashCode(connection);
        CoroutineContext coroutineContextCallContext = callContext(call);
        final Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.monitorScope, new CoroutineName("okhttp-conn-monitor-for-" + iIdentityHashCode), null, new ConnectionMonitoringEventListener$connectionReleased$monitor$1(this, connection, coroutineContextCallContext, null), 2, null);
        String qualifiedName = Reflection.getOrCreateKotlinClass(ConnectionMonitoringEventListener.class).getQualifiedName();
        if (qualifiedName != null) {
            Logger.trace$default(CoroutineContextLogExtKt.logger(coroutineContextCallContext, qualifiedName), null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ConnectionMonitoringEventListener.connectionReleased$lambda$0(jobLaunch$default, connection);
                }
            }, 1, null);
            this.monitors.put(connection, jobLaunch$default);
            return;
        }
        throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String connectionReleased$lambda$0(Job job, Connection connection) {
        return "Launched coroutine " + job + " to monitor " + connection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doMonitor(final Connection connection, CoroutineContext coroutineContext, Continuation<? super Unit> continuation) throws SocketException {
        boolean z;
        Throwable th;
        Function0<String> function0;
        String qualifiedName = Reflection.getOrCreateKotlinClass(ConnectionMonitoringEventListener.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
        }
        Logger logger = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
        Socket javaNetSocket = connection.getJavaNetSocket();
        try {
            BufferedSource bufferedSourcePeek = Okio.buffer(Okio.source(javaNetSocket)).peek();
            Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ConnectionMonitoringEventListener.doMonitor$lambda$1(connection);
                }
            }, 1, null);
            int soTimeout = javaNetSocket.getSoTimeout();
            try {
                javaNetSocket.setSoTimeout((int) Duration.m15867getInWholeMillisecondsimpl(this.pollInterval));
                while (JobKt.isActive(continuation.getContext())) {
                    try {
                        try {
                            Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ConnectionMonitoringEventListener.doMonitor$lambda$2(connection);
                                }
                            }, 1, null);
                            bufferedSourcePeek.readByte();
                        } catch (SocketTimeoutException unused) {
                            Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ConnectionMonitoringEventListener.doMonitor$lambda$3(connection);
                                }
                            }, 1, null);
                        }
                    } catch (IOException unused2) {
                        Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ConnectionMonitoringEventListener.doMonitor$lambda$4(connection);
                            }
                        }, 1, null);
                        _UtilCommonKt.closeQuietly(javaNetSocket);
                        try {
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            z = false;
                            try {
                                logger.warn(th, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ConnectionMonitoringEventListener.doMonitor$lambda$6(connection);
                                    }
                                });
                                if (z) {
                                    Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ConnectionMonitoringEventListener.doMonitor$lambda$7();
                                        }
                                    }, 1, null);
                                    try {
                                        connection.getJavaNetSocket().setSoTimeout(soTimeout);
                                        Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda7
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return ConnectionMonitoringEventListener.doMonitor$lambda$8();
                                            }
                                        }, 1, null);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        function0 = new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda8
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return ConnectionMonitoringEventListener.doMonitor$lambda$9(connection);
                                            }
                                        };
                                        logger.warn(th, function0);
                                    }
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th4) {
                                if (z) {
                                    Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ConnectionMonitoringEventListener.doMonitor$lambda$7();
                                        }
                                    }, 1, null);
                                    try {
                                        connection.getJavaNetSocket().setSoTimeout(soTimeout);
                                        Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda7
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return ConnectionMonitoringEventListener.doMonitor$lambda$8();
                                            }
                                        }, 1, null);
                                    } catch (Throwable th5) {
                                        logger.warn(th5, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda8
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return ConnectionMonitoringEventListener.doMonitor$lambda$9(connection);
                                            }
                                        });
                                    }
                                }
                                throw th4;
                            }
                        }
                    }
                }
                Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ConnectionMonitoringEventListener.doMonitor$lambda$5();
                    }
                }, 1, null);
                Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ConnectionMonitoringEventListener.doMonitor$lambda$7();
                    }
                }, 1, null);
                try {
                    connection.getJavaNetSocket().setSoTimeout(soTimeout);
                    Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ConnectionMonitoringEventListener.doMonitor$lambda$8();
                        }
                    }, 1, null);
                } catch (Throwable th6) {
                    th = th6;
                    function0 = new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ConnectionMonitoringEventListener.doMonitor$lambda$9(connection);
                        }
                    };
                    logger.warn(th, function0);
                }
            } catch (Throwable th7) {
                th = th7;
                z = true;
            }
            return Unit.INSTANCE;
        } catch (SocketException unused3) {
            Logger.trace$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.ConnectionMonitoringEventListener$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ConnectionMonitoringEventListener.doMonitor$lambda$0(connection);
                }
            }, 1, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String doMonitor$lambda$0(Connection connection) {
        return "Socket for " + connection + " closed before monitoring started. Skipping polling loop.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String doMonitor$lambda$1(Connection connection) {
        return "Commence socket monitoring for " + connection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String doMonitor$lambda$2(Connection connection) {
        return "Polling socket for " + connection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String doMonitor$lambda$3(Connection connection) {
        return "Socket still alive for " + connection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String doMonitor$lambda$4(Connection connection) {
        return "Socket closed remotely for " + connection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String doMonitor$lambda$5() {
        return "Monitoring coroutine has been cancelled. Ending polling loop.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String doMonitor$lambda$6(Connection connection) {
        return "Failed to poll " + connection + ". Ending polling loop. Connection may be unstable now.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String doMonitor$lambda$7() {
        return "Attempting to reset soTimeout...";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String doMonitor$lambda$8() {
        return "soTimeout reset.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String doMonitor$lambda$9(Connection connection) {
        return "Failed to reset socket timeout on " + connection + ". Connection may be unstable now.";
    }
}

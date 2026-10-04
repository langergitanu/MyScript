package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.InternalApi;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: HttpClientEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB\u0019\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineBase;", "Laws/smithy/kotlin/runtime/http/engine/CloseableHttpClientEngine;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "", "engineName", "(Ljava/lang/String;)V", "baseContext", "(Ljava/lang/String;Lkotlin/coroutines/CoroutineContext;)V", "", "close", "()V", "shutdown", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class HttpClientEngineBase implements CloseableHttpClientEngine {
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientEngineBase.class, "closed");
    private volatile /* synthetic */ int closed;
    private final CoroutineContext coroutineContext;

    protected void shutdown() {
    }

    private HttpClientEngineBase(CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
        this.closed = 0;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpClientEngineBase(String engineName) {
        this(engineName, EmptyCoroutineContext.INSTANCE);
        Intrinsics.checkNotNullParameter(engineName, "engineName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpClientEngineBase(String engineName, CoroutineContext baseContext) {
        this(baseContext.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("http-client-engine-" + engineName + "-context")));
        Intrinsics.checkNotNullParameter(engineName, "engineName");
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (closed$FU.compareAndSet(this, 0, 1)) {
            CoroutineContext.Element element = getCoroutineContext().get(Job.INSTANCE);
            CompletableJob completableJob = element instanceof CompletableJob ? (CompletableJob) element : null;
            if (completableJob == null) {
                return;
            }
            completableJob.complete();
            completableJob.invokeOnCompletion(new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.HttpClientEngineBase$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HttpClientEngineBase.close$lambda$0(this.f$0, (Throwable) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit close$lambda$0(HttpClientEngineBase httpClientEngineBase, Throwable th) {
        httpClientEngineBase.shutdown();
        return Unit.INSTANCE;
    }
}

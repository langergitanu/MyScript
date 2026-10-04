package androidx.room.coroutines;

import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: ConnectionPoolImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bJ@\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010#2\u0006\u0010$\u001a\u00020\u00192\"\u0010%\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H#0(\u0012\u0006\u0012\u0004\u0018\u00010)0&H\u0096@¢\u0006\u0002\u0010*J\"\u0010+\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0006\u0012\u0004\u0018\u00010.0,*\u00020\rH\u0082H¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0011H\u0002J\u0010\u00103\u001a\u0002042\u0006\u0010$\u001a\u00020\u0019H\u0002J\b\u00105\u001a\u000206H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u001cX\u0080\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00067"}, m1599d2 = {"Landroidx/room/coroutines/ConnectionPoolImpl;", "Landroidx/room/coroutines/ConnectionPool;", "driver", "Landroidx/sqlite/SQLiteDriver;", "fileName", "", "<init>", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;)V", "maxNumOfReaders", "", "maxNumOfWriters", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;II)V", "readers", "Landroidx/room/coroutines/Pool;", "writers", "threadLocal", "Ljava/lang/ThreadLocal;", "Landroidx/room/coroutines/PooledConnectionImpl;", "Landroidx/room/concurrent/ThreadLocal;", "Ljava/lang/ThreadLocal;", "_isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isClosed", "", "()Z", "timeout", "Lkotlin/time/Duration;", "getTimeout-UwyO8pc$room_runtime_release", "()J", "setTimeout-LRDsOJo$room_runtime_release", "(J)V", "J", "useConnection", "R", "isReadOnly", "block", "Lkotlin/Function2;", "Landroidx/room/Transactor;", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireWithTimeout", "Lkotlin/Pair;", "Landroidx/room/coroutines/ConnectionWithLock;", "", "(Landroidx/room/coroutines/Pool;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConnectionContext", "Lkotlin/coroutines/CoroutineContext;", "connection", "throwTimeoutException", "", "close", "", "room-runtime_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ConnectionPoolImpl implements ConnectionPool {
    private final AtomicBoolean _isClosed;
    private final SQLiteDriver driver;
    private final Pool readers;
    private final ThreadLocal<PooledConnectionImpl> threadLocal;
    private long timeout;
    private final Pool writers;

    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$1 */
    /* JADX INFO: compiled from: ConnectionPoolImpl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.room.coroutines.ConnectionPoolImpl", m1609f = "ConnectionPoolImpl.kt", m1610i = {2, 2, 2, 2, 2, 2, 2, 3, 3}, m1611l = {114, 118, 541, 147}, m1612m = "useConnection", m1613n = {"this", "block", "pool", "connection", "currentContext", "connection$iv", "isReadOnly", "pool", "connection"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1"})
    static final class C26771<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C26771(Continuation<? super C26771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConnectionPoolImpl.this.useConnection(false, null, this);
        }
    }

    private final boolean isClosed() {
        return this._isClosed.get();
    }

    /* JADX INFO: renamed from: getTimeout-UwyO8pc$room_runtime_release, reason: not valid java name and from getter */
    public final long getTimeout() {
        return this.timeout;
    }

    /* JADX INFO: renamed from: setTimeout-LRDsOJo$room_runtime_release, reason: not valid java name */
    public final void m11784setTimeoutLRDsOJo$room_runtime_release(long j) {
        this.timeout = j;
    }

    public ConnectionPoolImpl(final SQLiteDriver driver, final String fileName) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.threadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        Duration.Companion companion = Duration.INSTANCE;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        this.driver = driver;
        Pool pool = new Pool(1, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return driver.open(fileName);
            }
        });
        this.readers = pool;
        this.writers = pool;
    }

    public ConnectionPoolImpl(final SQLiteDriver driver, final String fileName, int i, int i2) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.threadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        Duration.Companion companion = Duration.INSTANCE;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        if (i <= 0) {
            throw new IllegalArgumentException("Maximum number of readers must be greater than 0".toString());
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("Maximum number of writers must be greater than 0".toString());
        }
        this.driver = driver;
        this.readers = new Pool(i, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ConnectionPoolImpl._init_$lambda$4(driver, fileName);
            }
        });
        this.writers = new Pool(i2, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return driver.open(fileName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$4(SQLiteDriver sQLiteDriver, String str) {
        SQLiteConnection sQLiteConnectionOpen = sQLiteDriver.open(str);
        SQLite.execSQL(sQLiteConnectionOpen, "PRAGMA query_only = 1");
        return sQLiteConnectionOpen;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a0 A[Catch: all -> 0x01b1, TRY_LEAVE, TryCatch #2 {all -> 0x01b1, blocks: (B:86:0x019a, B:88:0x01a0), top: B:116:0x019a }] */
    @Override // androidx.room.coroutines.ConnectionPool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object useConnection(boolean z, Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        C26771 c26771;
        Pool pool;
        Ref.ObjectRef objectRef;
        Throwable th;
        Pool pool2;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Pool pool3;
        CoroutineContext coroutineContext;
        ConnectionPoolImpl connectionPoolImpl;
        Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function22;
        Ref.ObjectRef objectRef4;
        ConnectionPoolImpl connectionPoolImpl2;
        boolean z2;
        Ref.ObjectRef objectRef5;
        ConnectionPoolImpl connectionPoolImpl3;
        T pooledConnectionImpl;
        PooledConnectionImpl pooledConnectionImpl2;
        boolean z3 = z;
        Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function23 = function2;
        if (continuation instanceof C26771) {
            c26771 = (C26771) continuation;
            if ((c26771.label & Integer.MIN_VALUE) != 0) {
                c26771.label -= Integer.MIN_VALUE;
            } else {
                c26771 = new C26771(continuation);
            }
        }
        Object objWithContext = c26771.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c26771.label;
        boolean z4 = true;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objWithContext);
                if (isClosed()) {
                    SQLite.throwSQLiteException(21, "Connection pool is closed");
                    throw new KotlinNothingValueException();
                }
                PooledConnectionImpl connectionWrapper = this.threadLocal.get();
                if (connectionWrapper == null) {
                    ConnectionElement connectionElement = (ConnectionElement) c26771.get$context().get(ConnectionElement.INSTANCE);
                    connectionWrapper = connectionElement != null ? connectionElement.getConnectionWrapper() : null;
                }
                if (connectionWrapper != null) {
                    if (!z3 && connectionWrapper.getIsReadOnly()) {
                        SQLite.throwSQLiteException(1, "Cannot upgrade connection from reader to writer");
                        throw new KotlinNothingValueException();
                    }
                    if (c26771.get$context().get(ConnectionElement.INSTANCE) == null) {
                        CoroutineContext coroutineContextCreateConnectionContext = createConnectionContext(connectionWrapper);
                        C26782 c26782 = new C26782(function23, connectionWrapper, null);
                        c26771.label = 1;
                        Object objWithContext2 = BuildersKt.withContext(coroutineContextCreateConnectionContext, c26782, c26771);
                        if (objWithContext2 != coroutine_suspended) {
                            return objWithContext2;
                        }
                    } else {
                        c26771.label = 2;
                        Object objInvoke = function23.invoke(connectionWrapper, c26771);
                        if (objInvoke != coroutine_suspended) {
                            return objInvoke;
                        }
                    }
                } else {
                    if (z3) {
                        pool = this.readers;
                    } else {
                        pool = this.writers;
                    }
                    Pool pool4 = pool;
                    objectRef = new Ref.ObjectRef();
                    try {
                        CoroutineContext coroutineContext2 = c26771.get$context();
                        objectRef2 = new Ref.ObjectRef();
                        try {
                            long j = this.timeout;
                            C26762 c26762 = new C26762(objectRef2, pool4, null);
                            c26771.L$0 = this;
                            c26771.L$1 = function23;
                            c26771.L$2 = pool4;
                            c26771.L$3 = objectRef;
                            c26771.L$4 = coroutineContext2;
                            c26771.L$5 = objectRef2;
                            c26771.Z$0 = z3;
                            c26771.label = 3;
                            if (TimeoutKt.m16018withTimeoutKLykuaI(j, c26762, c26771) != coroutine_suspended) {
                                objectRef3 = objectRef;
                                pool3 = pool4;
                                coroutineContext = coroutineContext2;
                                function22 = function23;
                                objectRef4 = objectRef2;
                                connectionPoolImpl2 = this;
                                Ref.ObjectRef objectRef6 = objectRef4;
                                z2 = z3;
                                objectRef5 = objectRef3;
                                connectionPoolImpl3 = connectionPoolImpl2;
                                objectRef2 = objectRef6;
                                th = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            objectRef3 = objectRef;
                            pool3 = pool4;
                            coroutineContext = coroutineContext2;
                            connectionPoolImpl = this;
                            Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function24 = function23;
                            z2 = z3;
                            objectRef5 = objectRef3;
                            connectionPoolImpl3 = connectionPoolImpl;
                            function22 = function24;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        pool2 = pool4;
                        throw th;
                    }
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(objWithContext);
                return objWithContext;
            }
            if (i == 2) {
                ResultKt.throwOnFailure(objWithContext);
                return objWithContext;
            }
            if (i == 3) {
                z3 = c26771.Z$0;
                objectRef4 = (Ref.ObjectRef) c26771.L$5;
                coroutineContext = (CoroutineContext) c26771.L$4;
                objectRef3 = (Ref.ObjectRef) c26771.L$3;
                pool3 = (Pool) c26771.L$2;
                function22 = (Function2) c26771.L$1;
                connectionPoolImpl2 = (ConnectionPoolImpl) c26771.L$0;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    Ref.ObjectRef objectRef62 = objectRef4;
                    z2 = z3;
                    objectRef5 = objectRef3;
                    connectionPoolImpl3 = connectionPoolImpl2;
                    objectRef2 = objectRef62;
                    th = null;
                } catch (Throwable th4) {
                    th = th4;
                    objectRef2 = objectRef4;
                    function23 = function22;
                    connectionPoolImpl = connectionPoolImpl2;
                    Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function242 = function23;
                    z2 = z3;
                    objectRef5 = objectRef3;
                    connectionPoolImpl3 = connectionPoolImpl;
                    function22 = function242;
                }
            } else {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef5 = (Ref.ObjectRef) c26771.L$1;
                pool2 = (Pool) c26771.L$0;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    try {
                        pooledConnectionImpl2 = (PooledConnectionImpl) objectRef5.element;
                        if (pooledConnectionImpl2 != null) {
                            pooledConnectionImpl2.markRecycled();
                            pooledConnectionImpl2.getDelegate().markReleased();
                            pool2.recycle(pooledConnectionImpl2.getDelegate());
                        }
                    } catch (Throwable unused) {
                    }
                    return objWithContext;
                } catch (Throwable th5) {
                    th = th5;
                    objectRef = objectRef5;
                    th = th;
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
            Pair pairM1606to = TuplesKt.m1606to(objectRef2.element, th);
            ConnectionWithLock connectionWithLock = (ConnectionWithLock) pairM1606to.component1();
            Throwable th6 = (Throwable) pairM1606to.component2();
            if (connectionWithLock != null) {
                ConnectionWithLock connectionWithLockMarkAcquired = connectionWithLock.markAcquired(coroutineContext);
                if (connectionPoolImpl3.readers == connectionPoolImpl3.writers || !z2) {
                    z4 = false;
                }
                pooledConnectionImpl = new PooledConnectionImpl(connectionWithLockMarkAcquired, z4);
            } else {
                pooledConnectionImpl = 0;
            }
            objectRef5.element = pooledConnectionImpl;
            if (th6 instanceof TimeoutCancellationException) {
                connectionPoolImpl3.throwTimeoutException(z2);
                throw new KotlinNothingValueException();
            }
            if (th6 != null) {
                throw th6;
            }
            if (objectRef5.element == 0) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            CoroutineContext coroutineContextCreateConnectionContext2 = connectionPoolImpl3.createConnectionContext((PooledConnectionImpl) objectRef5.element);
            C26794 c26794 = new C26794(function22, objectRef5, null);
            c26771.L$0 = pool3;
            c26771.L$1 = objectRef5;
            c26771.L$2 = null;
            c26771.L$3 = null;
            c26771.L$4 = null;
            c26771.L$5 = null;
            c26771.label = 4;
            objWithContext = BuildersKt.withContext(coroutineContextCreateConnectionContext2, c26794, c26771);
            if (objWithContext != coroutine_suspended) {
                pool2 = pool3;
                pooledConnectionImpl2 = (PooledConnectionImpl) objectRef5.element;
                if (pooledConnectionImpl2 != null) {
                }
                return objWithContext;
            }
            return coroutine_suspended;
        } catch (Throwable th7) {
            th = th7;
            pool2 = pool3;
            objectRef = objectRef5;
            th = th;
            throw th;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$2 */
    /* JADX INFO: compiled from: ConnectionPoolImpl.kt */
    @Metadata(m1598d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$2", m1609f = "ConnectionPoolImpl.kt", m1610i = {}, m1611l = {115}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C26782<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function2<Transactor, Continuation<? super R>, Object> $block;
        final /* synthetic */ PooledConnectionImpl $confinedConnection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C26782(Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, PooledConnectionImpl pooledConnectionImpl, Continuation<? super C26782> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.$confinedConnection = pooledConnectionImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C26782(this.$block, this.$confinedConnection, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((C26782) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Function2<Transactor, Continuation<? super R>, Object> function2 = this.$block;
            PooledConnectionImpl pooledConnectionImpl = this.$confinedConnection;
            this.label = 1;
            Object objInvoke = function2.invoke(pooledConnectionImpl, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$4 */
    /* JADX INFO: compiled from: ConnectionPoolImpl.kt */
    @Metadata(m1598d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$4", m1609f = "ConnectionPoolImpl.kt", m1610i = {}, m1611l = {147}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C26794<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function2<Transactor, Continuation<? super R>, Object> $block;
        final /* synthetic */ Ref.ObjectRef<PooledConnectionImpl> $connection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C26794(Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Ref.ObjectRef<PooledConnectionImpl> objectRef, Continuation<? super C26794> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.$connection = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C26794(this.$block, this.$connection, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((C26794) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.room.coroutines.ConnectionPoolImpl$useConnection$4<R> for r3v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r4)
                return r4
            Lf:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L17:
                kotlin.ResultKt.throwOnFailure(r4)
                kotlin.jvm.functions.Function2<androidx.room.Transactor, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r4 = r3.$block
                kotlin.jvm.internal.Ref$ObjectRef<androidx.room.coroutines.PooledConnectionImpl> r1 = r3.$connection
                T r1 = r1.element
                r3.label = r2
                java.lang.Object r4 = r4.invoke(r1, r3)
                if (r4 != r0) goto L29
                return r0
            L29:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.ConnectionPoolImpl.C26794.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Object acquireWithTimeout(Pool pool, Continuation<? super Pair<ConnectionWithLock, ? extends Throwable>> continuation) {
        Object obj;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            obj = null;
            TimeoutKt.m16018withTimeoutKLykuaI(this.timeout, new C26762(objectRef, pool, null), continuation);
        } catch (Throwable th) {
            obj = th;
        }
        return TuplesKt.m1606to(objectRef.element, obj);
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$acquireWithTimeout$2 */
    /* JADX INFO: compiled from: ConnectionPoolImpl.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.room.coroutines.ConnectionPoolImpl$acquireWithTimeout$2", m1609f = "ConnectionPoolImpl.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_7_1}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    public static final class C26762 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<ConnectionWithLock> $connection;
        final /* synthetic */ Pool $this_acquireWithTimeout;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26762(Ref.ObjectRef<ConnectionWithLock> objectRef, Pool pool, Continuation<? super C26762> continuation) {
            super(2, continuation);
            this.$connection = objectRef;
            this.$this_acquireWithTimeout = pool;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C26762(this.$connection, this.$this_acquireWithTimeout, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C26762) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef<ConnectionWithLock> objectRef;
            T t;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<ConnectionWithLock> objectRef2 = this.$connection;
                this.L$0 = objectRef2;
                this.label = 1;
                Object objAcquire = this.$this_acquireWithTimeout.acquire(this);
                if (objAcquire == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                t = objAcquire;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                t = obj;
            }
            objectRef.element = t;
            return Unit.INSTANCE;
        }
    }

    private final CoroutineContext createConnectionContext(PooledConnectionImpl connection) {
        return new ConnectionElement(connection).plus(ThreadLocal_jvmAndroidKt.asContextElement(this.threadLocal, connection));
    }

    private final Void throwTimeoutException(boolean isReadOnly) {
        String str = isReadOnly ? "reader" : "writer";
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.").append("\n\nWriter pool:\n");
        this.writers.dump(sb);
        sb.append("Reader pool:").append('\n');
        this.readers.dump(sb);
        SQLite.throwSQLiteException(5, sb.toString());
        throw new KotlinNothingValueException();
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this._isClosed.compareAndSet(false, true)) {
            this.readers.close();
            this.writers.close();
        }
    }
}

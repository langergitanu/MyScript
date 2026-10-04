package androidx.datastore.core;

import androidx.compose.p004ui.spatial.RectListKt;
import androidx.exifinterface.media.ExifInterface;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: MultiProcessCoordinator.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 52\u00020\u0001:\u00015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0096@¢\u0006\u0002\u0010\u0015J8\u0010\u0016\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0017H\u0096@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u001fH\u0002J\f\u00102\u001a\u00020\f*\u00020\u0005H\u0002J\f\u00103\u001a\u00020\f*\u00020\u0005H\u0002J:\u00104\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102$\b\u0004\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0017H\u0082H¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b%\u0010\tR\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b.\u0010/*\u0004\b,\u0010-¨\u00066"}, m1599d2 = {"Landroidx/datastore/core/MultiProcessCoordinator;", "Landroidx/datastore/core/InterProcessCoordinator;", WebViewMessageType.CONTEXT, "Lkotlin/coroutines/CoroutineContext;", "file", "Ljava/io/File;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "updateNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "getUpdateNotifications", "()Lkotlinx/coroutines/flow/Flow;", "lock", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVersion", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementAndGetVersion", "LOCK_SUFFIX", "", "VERSION_SUFFIX", "LOCK_ERROR_MESSAGE", "inMemoryMutex", "Lkotlinx/coroutines/sync/Mutex;", "lockFile", "getLockFile", "lockFile$delegate", "Lkotlin/Lazy;", "lazySharedCounter", "Lkotlin/Lazy;", "Landroidx/datastore/core/SharedCounter;", "sharedCounter", "getSharedCounter$delegate", "(Landroidx/datastore/core/MultiProcessCoordinator;)Ljava/lang/Object;", "getSharedCounter", "()Landroidx/datastore/core/SharedCounter;", "fileWithSuffix", "suffix", "createIfNotExists", "createParentDirectories", "withLazyCounter", "Companion", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class MultiProcessCoordinator implements InterProcessCoordinator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEADLOCK_ERROR_MESSAGE = "Resource deadlock would occur";
    private static final long INITIAL_WAIT_MILLIS = 10;
    private static final long MAX_WAIT_MILLIS = 60000;
    private final String LOCK_ERROR_MESSAGE;
    private final String LOCK_SUFFIX;
    private final String VERSION_SUFFIX;
    private final CoroutineContext context;
    private final File file;
    private final Mutex inMemoryMutex;
    private final Lazy<SharedCounter> lazySharedCounter;

    /* JADX INFO: renamed from: lockFile$delegate, reason: from kotlin metadata */
    private final Lazy lockFile;
    private final Flow<Unit> updateNotifications;

    /* JADX INFO: renamed from: androidx.datastore.core.MultiProcessCoordinator$lock$1 */
    /* JADX INFO: compiled from: MultiProcessCoordinator.android.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.MultiProcessCoordinator", m1609f = "MultiProcessCoordinator.android.kt", m1610i = {0, 0, 1, 1, 2, 2}, m1611l = {213, 47, 48}, m1612m = "lock", m1613n = {"block", "$this$withLock_u24default$iv", "block", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "lock"}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$2"}, m1616v = 1)
    static final class C18791<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C18791(Continuation<? super C18791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiProcessCoordinator.this.lock(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.MultiProcessCoordinator$tryLock$1 */
    /* JADX INFO: compiled from: MultiProcessCoordinator.android.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.MultiProcessCoordinator", m1609f = "MultiProcessCoordinator.android.kt", m1610i = {0, 0, 1, 1, 1}, m1611l = {RectListKt.BitOffsetForGesturable, PDFACompliance.e_PDFA9_2}, m1612m = "tryLock", m1613n = {"$this$withTryLock_u24default$iv", "locked$iv", "$this$withTryLock_u24default$iv", "lock", "locked$iv"}, m1615s = {"L$0", "Z$0", "L$0", "L$2", "Z$0"}, m1616v = 1)
    static final class C18801<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C18801(Continuation<? super C18801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiProcessCoordinator.this.tryLock(null, this);
        }
    }

    public MultiProcessCoordinator(CoroutineContext context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        this.context = context;
        this.file = file;
        this.updateNotifications = MulticastFileObserver.INSTANCE.observe(file);
        this.LOCK_SUFFIX = ".lock";
        this.VERSION_SUFFIX = ".version";
        this.LOCK_ERROR_MESSAGE = "fcntl failed: EAGAIN";
        this.inMemoryMutex = MutexKt.Mutex$default(false, 1, null);
        this.lockFile = LazyKt.lazy(new Function0() { // from class: androidx.datastore.core.MultiProcessCoordinator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MultiProcessCoordinator.lockFile_delegate$lambda$0(this.f$0);
            }
        });
        this.lazySharedCounter = LazyKt.lazy(new Function0() { // from class: androidx.datastore.core.MultiProcessCoordinator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MultiProcessCoordinator.lazySharedCounter$lambda$0(this.f$0);
            }
        });
    }

    protected final File getFile() {
        return this.file;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Flow<Unit> getUpdateNotifications() {
        return this.updateNotifications;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba A[Catch: all -> 0x00d8, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x00d8, blocks: (B:42:0x00ba, B:53:0x00d4, B:56:0x00dc), top: B:65:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d4 A[Catch: all -> 0x00d8, TRY_ENTER, TryCatch #3 {all -> 0x00d8, blocks: (B:42:0x00ba, B:53:0x00d4, B:56:0x00dc), top: B:65:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v21, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object lock(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) throws Throwable {
        C18791 c18791;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Throwable th;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        ?? r10;
        ?? r2;
        ?? r11;
        FileLock fileLock;
        FileLock fileLock2;
        Object objInvoke;
        ?? r1;
        ?? r112;
        ?? r0;
        if (continuation instanceof C18791) {
            c18791 = (C18791) continuation;
            if ((c18791.label & Integer.MIN_VALUE) != 0) {
                c18791.label -= Integer.MIN_VALUE;
            } else {
                c18791 = new C18791(continuation);
            }
        }
        ?? r113 = c18791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18791.label;
        try {
            try {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            r113 = c18791;
            fileOutputStream = coroutine_suspended;
        }
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(r113);
                    Mutex mutex = this.inMemoryMutex;
                    c18791.L$0 = function1;
                    c18791.L$1 = mutex;
                    c18791.label = 1;
                    Object objLock = mutex.lock(null, c18791);
                    r113 = mutex;
                    if (objLock != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        fileLock = (FileLock) c18791.L$2;
                        java.io.Closeable closeable = (java.io.Closeable) c18791.L$1;
                        Mutex mutex2 = (Mutex) c18791.L$0;
                        try {
                            ResultKt.throwOnFailure(r113);
                            r0 = mutex2;
                            r1 = closeable;
                            r112 = r113;
                            if (fileLock != null) {
                                fileLock.release();
                            }
                            try {
                                kotlin.p039io.CloseableKt.closeFinally(r1, null);
                                r0.unlock(null);
                                return r112;
                            } catch (Throwable th4) {
                                th = th4;
                                r113 = r0;
                                r113.unlock(null);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            if (fileLock != null) {
                            }
                            throw th;
                        }
                    }
                    r10 = (java.io.Closeable) c18791.L$2;
                    r2 = (Mutex) c18791.L$1;
                    function12 = (Function1) c18791.L$0;
                    try {
                        ResultKt.throwOnFailure(r113);
                        r2 = r2;
                        r10 = r10;
                        r11 = r113;
                        fileLock2 = (FileLock) r11;
                        try {
                            c18791.L$0 = r2;
                            c18791.L$1 = r10;
                            c18791.L$2 = fileLock2;
                            c18791.label = 3;
                            objInvoke = function12.invoke(c18791);
                            if (objInvoke != coroutine_suspended) {
                                r1 = r10;
                                fileLock = fileLock2;
                                r112 = objInvoke;
                                r0 = r2;
                                if (fileLock != null) {
                                }
                                kotlin.p039io.CloseableKt.closeFinally(r1, null);
                                r0.unlock(null);
                                return r112;
                            }
                            return coroutine_suspended;
                        } catch (Throwable th6) {
                            fileLock = fileLock2;
                            th = th6;
                            if (fileLock != null) {
                                fileLock.release();
                            }
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        fileLock = null;
                        if (fileLock != null) {
                        }
                        throw th;
                    }
                }
                Mutex mutex3 = (Mutex) c18791.L$1;
                Function1<? super Continuation<? super T>, ? extends Object> function13 = (Function1) c18791.L$0;
                ResultKt.throwOnFailure(r113);
                r113 = mutex3;
                function1 = function13;
                Companion companion = INSTANCE;
                c18791.L$0 = function1;
                c18791.L$1 = r113;
                c18791.L$2 = fileOutputStream;
                c18791.label = 2;
                Object exclusiveFileLockWithRetryIfDeadlock = companion.getExclusiveFileLockWithRetryIfDeadlock(fileOutputStream2, c18791);
                if (exclusiveFileLockWithRetryIfDeadlock != coroutine_suspended) {
                    function12 = function1;
                    r10 = fileOutputStream;
                    r2 = r113;
                    r11 = exclusiveFileLockWithRetryIfDeadlock;
                    fileLock2 = (FileLock) r11;
                    c18791.L$0 = r2;
                    c18791.L$1 = r10;
                    c18791.L$2 = fileLock2;
                    c18791.label = 3;
                    objInvoke = function12.invoke(c18791);
                    if (objInvoke != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th8) {
                th = th8;
                fileLock = null;
                if (fileLock != null) {
                }
                throw th;
            }
            fileOutputStream2 = fileOutputStream;
        } catch (Throwable th9) {
            th = th9;
            try {
                throw th;
            } catch (Throwable th10) {
                kotlin.p039io.CloseableKt.closeFinally(fileOutputStream, th);
                throw th10;
            }
        }
        fileOutputStream = new FileOutputStream(getLockFile());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e7 A[Catch: all -> 0x0100, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0100, blocks: (B:58:0x00e7, B:67:0x00fc, B:70:0x0105), top: B:87:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fc A[Catch: all -> 0x0100, TRY_ENTER, TryCatch #1 {all -> 0x0100, blocks: (B:58:0x00e7, B:67:0x00fc, B:70:0x0105), top: B:87:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0116  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.datastore.core.MultiProcessCoordinator$tryLock$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v3, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v6 */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object tryLock(Function2<? super Boolean, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        ?? c18801;
        ?? TryLock;
        ?? r11;
        Throwable th;
        FileLock fileLock;
        String message;
        FileLock fileLockTryLock;
        Mutex mutex;
        boolean z;
        java.io.Closeable closeable;
        Mutex mutex2;
        boolean z2;
        ?? r2 = function2;
        if (continuation instanceof C18801) {
            C18801 c188012 = (C18801) continuation;
            if ((c188012.label & Integer.MIN_VALUE) != 0) {
                c188012.label -= Integer.MIN_VALUE;
                c18801 = c188012;
            } else {
                c18801 = new C18801(continuation);
            }
        }
        Object objInvoke = c18801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r5 = c18801.label;
        try {
            try {
                if (r5 != 0) {
                    if (r5 == 1) {
                        z2 = c18801.Z$0;
                        mutex2 = (Mutex) c18801.L$0;
                        ResultKt.throwOnFailure(objInvoke);
                        if (z2) {
                            mutex2.unlock(null);
                        }
                        return objInvoke;
                    }
                    if (r5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z = c18801.Z$0;
                    fileLock = (FileLock) c18801.L$2;
                    java.io.Closeable closeable2 = (java.io.Closeable) c18801.L$1;
                    mutex = (Mutex) c18801.L$0;
                    try {
                        ResultKt.throwOnFailure(objInvoke);
                        closeable = closeable2;
                        if (fileLock != null) {
                            fileLock.release();
                        }
                        kotlin.p039io.CloseableKt.closeFinally(closeable, null);
                        if (z) {
                            mutex.unlock(null);
                        }
                        return objInvoke;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileLock != null) {
                        }
                        throw th;
                    }
                }
                ResultKt.throwOnFailure(objInvoke);
                Mutex mutex3 = this.inMemoryMutex;
                TryLock = mutex3.tryLock(null);
                try {
                    if (TryLock == 0) {
                        Boolean boolBoxBoolean = Boxing.boxBoolean(false);
                        c18801.L$0 = mutex3;
                        c18801.Z$0 = TryLock;
                        c18801.label = 1;
                        objInvoke = r2.invoke(boolBoxBoolean, c18801);
                        if (objInvoke != coroutine_suspended) {
                            mutex2 = mutex3;
                            z2 = TryLock == true ? 1 : 0;
                            if (z2) {
                            }
                            return objInvoke;
                        }
                    } else {
                        FileInputStream fileInputStream = new FileInputStream(getLockFile());
                        try {
                            try {
                                try {
                                    fileLockTryLock = fileInputStream.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                                } catch (IOException e) {
                                    String message2 = e.getMessage();
                                    if ((message2 == null || !StringsKt.startsWith$default(message2, this.LOCK_ERROR_MESSAGE, false, 2, (Object) null)) && ((message = e.getMessage()) == null || !StringsKt.startsWith$default(message, DEADLOCK_ERROR_MESSAGE, false, 2, (Object) null))) {
                                        throw e;
                                    }
                                    fileLockTryLock = null;
                                }
                                try {
                                    Boolean boolBoxBoolean2 = Boxing.boxBoolean(fileLockTryLock != null);
                                    c18801.L$0 = mutex3;
                                    c18801.L$1 = fileInputStream;
                                    c18801.L$2 = fileLockTryLock;
                                    c18801.Z$0 = TryLock;
                                    c18801.label = 2;
                                    objInvoke = r2.invoke(boolBoxBoolean2, c18801);
                                    if (objInvoke != coroutine_suspended) {
                                        mutex = mutex3;
                                        z = TryLock == true ? 1 : 0;
                                        closeable = fileInputStream;
                                        fileLock = fileLockTryLock;
                                        if (fileLock != null) {
                                        }
                                        kotlin.p039io.CloseableKt.closeFinally(closeable, null);
                                        if (z) {
                                        }
                                        return objInvoke;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileLock = fileLockTryLock;
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fileLock = null;
                                if (fileLock != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            c18801 = mutex3;
                            TryLock = TryLock;
                            r11 = fileInputStream;
                            try {
                                throw th;
                            } catch (Throwable th6) {
                                try {
                                    kotlin.p039io.CloseableKt.closeFinally(r11, th);
                                    throw th6;
                                } catch (Throwable th7) {
                                    th = th7;
                                    r2 = TryLock;
                                    if (r2 != 0) {
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                } catch (Throwable th8) {
                    th = th8;
                    c18801 = mutex3;
                    r2 = TryLock;
                    if (r2 != 0) {
                        c18801.unlock(null);
                    }
                    throw th;
                }
            } catch (Throwable th9) {
                TryLock = r2;
                r11 = r5;
                th = th9;
                c18801 = c18801;
            }
        } catch (Throwable th10) {
            th = th10;
            if (r2 != 0) {
            }
            throw th;
        }
    }

    private final File getLockFile() {
        return (File) this.lockFile.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File lockFile_delegate$lambda$0(MultiProcessCoordinator multiProcessCoordinator) throws IOException {
        File fileFileWithSuffix = multiProcessCoordinator.fileWithSuffix(multiProcessCoordinator.LOCK_SUFFIX);
        multiProcessCoordinator.createIfNotExists(fileFileWithSuffix);
        return fileFileWithSuffix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedCounter lazySharedCounter$lambda$0(final MultiProcessCoordinator multiProcessCoordinator) {
        return SharedCounter.INSTANCE.create$datastore_core(new Function0() { // from class: androidx.datastore.core.MultiProcessCoordinator$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MultiProcessCoordinator.lazySharedCounter$lambda$0$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File lazySharedCounter$lambda$0$0(MultiProcessCoordinator multiProcessCoordinator) throws IOException {
        File fileFileWithSuffix = multiProcessCoordinator.fileWithSuffix(multiProcessCoordinator.VERSION_SUFFIX);
        multiProcessCoordinator.createIfNotExists(fileFileWithSuffix);
        return fileFileWithSuffix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedCounter getSharedCounter() {
        return this.lazySharedCounter.getValue();
    }

    private final File fileWithSuffix(String suffix) {
        return new File(this.file.getAbsolutePath() + suffix);
    }

    private final void createIfNotExists(File file) throws IOException {
        createParentDirectories(file);
        if (file.exists()) {
            return;
        }
        file.createNewFile();
    }

    private final void createParentDirectories(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException("Unable to create parent directories of " + file);
            }
        }
    }

    private final <T> Object withLazyCounter(Function2<? super SharedCounter, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (this.lazySharedCounter.isInitialized()) {
            return function2.invoke(getSharedCounter(), continuation);
        }
        return BuildersKt.withContext(this.context, new C18812(function2, this, null), continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.datastore.core.MultiProcessCoordinator$withLazyCounter$2 */
    /* JADX INFO: compiled from: MultiProcessCoordinator.android.kt */
    @Metadata(m1598d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.MultiProcessCoordinator$withLazyCounter$2", m1609f = "MultiProcessCoordinator.android.kt", m1610i = {}, m1611l = {166}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    public static final class C18812<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<SharedCounter, Continuation<? super T>, Object> $block;
        int label;
        final /* synthetic */ MultiProcessCoordinator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C18812(Function2<? super SharedCounter, ? super Continuation<? super T>, ? extends Object> function2, MultiProcessCoordinator multiProcessCoordinator, Continuation<? super C18812> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.this$0 = multiProcessCoordinator;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18812(this.$block, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C18812) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Function2<SharedCounter, Continuation<? super T>, Object> function2 = this.$block;
            SharedCounter sharedCounter = this.this$0.getSharedCounter();
            this.label = 1;
            Object objInvoke = function2.invoke(sharedCounter, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            return this.$block.invoke(this.this$0.getSharedCounter(), this);
        }
    }

    /* JADX INFO: compiled from: MultiProcessCoordinator.android.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Landroidx/datastore/core/MultiProcessCoordinator$Companion;", "", "<init>", "()V", "getExclusiveFileLockWithRetryIfDeadlock", "Ljava/nio/channels/FileLock;", "lockFileStream", "Ljava/io/FileOutputStream;", "(Ljava/io/FileOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DEADLOCK_ERROR_MESSAGE", "", "INITIAL_WAIT_MILLIS", "", "MAX_WAIT_MILLIS", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0081 -> B:27:0x0084). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object getExclusiveFileLockWithRetryIfDeadlock(FileOutputStream fileOutputStream, Continuation<? super FileLock> continuation) throws IOException {
            C1877xe413854a c1877xe413854a;
            long j;
            C1877xe413854a c1877xe413854a2;
            if (continuation instanceof C1877xe413854a) {
                c1877xe413854a = (C1877xe413854a) continuation;
                if ((c1877xe413854a.label & Integer.MIN_VALUE) != 0) {
                    c1877xe413854a.label -= Integer.MIN_VALUE;
                } else {
                    c1877xe413854a = new C1877xe413854a(this, continuation);
                }
            }
            Object obj = c1877xe413854a.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = c1877xe413854a.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = c1877xe413854a.J$0;
                fileOutputStream = (FileOutputStream) c1877xe413854a.L$0;
                ResultKt.throwOnFailure(obj);
                c1877xe413854a2 = c1877xe413854a;
                j *= (long) 2;
                if (j > MultiProcessCoordinator.MAX_WAIT_MILLIS) {
                    try {
                    } catch (IOException e) {
                        String message = e.getMessage();
                        if (message == null || !StringsKt.contains$default((CharSequence) message, (CharSequence) MultiProcessCoordinator.DEADLOCK_ERROR_MESSAGE, false, 2, (Object) null)) {
                            throw e;
                        }
                        c1877xe413854a2.L$0 = fileOutputStream;
                        c1877xe413854a2.J$0 = j;
                        c1877xe413854a2.label = 1;
                        if (DelayKt.delay(j, c1877xe413854a2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    FileLock fileLockLock = fileOutputStream.getChannel().lock(0L, Long.MAX_VALUE, false);
                    Intrinsics.checkNotNullExpressionValue(fileLockLock, "lock(...)");
                    return fileLockLock;
                }
                FileLock fileLockLock2 = fileOutputStream.getChannel().lock(0L, Long.MAX_VALUE, false);
                Intrinsics.checkNotNullExpressionValue(fileLockLock2, "lock(...)");
                return fileLockLock2;
            }
            ResultKt.throwOnFailure(obj);
            j = MultiProcessCoordinator.INITIAL_WAIT_MILLIS;
            c1877xe413854a2 = c1877xe413854a;
            if (j > MultiProcessCoordinator.MAX_WAIT_MILLIS) {
            }
        }
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object getVersion(Continuation<? super Integer> continuation) {
        if (this.lazySharedCounter.isInitialized()) {
            return Boxing.boxInt(getSharedCounter().getValue());
        }
        return BuildersKt.withContext(this.context, new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this, null), continuation);
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object incrementAndGetVersion(Continuation<? super Integer> continuation) {
        if (this.lazySharedCounter.isInitialized()) {
            return Boxing.boxInt(getSharedCounter().incrementAndGetValue());
        }
        return BuildersKt.withContext(this.context, new C1878xb55e9682(this, null), continuation);
    }
}

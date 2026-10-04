package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.common.networking.ETagPayloadStore;
import java.io.File;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: FileStorage.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJX\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0001\u0010\u00152B\u0010\u0016\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0017¢\u0006\u0002\b\u001fH\u0096@¢\u0006\u0002\u0010 J=\u0010!\u001a\u00020\u000b2-\u0010\u0016\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\"¢\u0006\u0002\b\u001fH\u0096@¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\u000bH\u0002J\f\u0010'\u001a\u00020\u000b*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m1599d2 = {"Landroidx/datastore/core/FileStorageConnection;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/StorageConnection;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "<init>", "(Ljava/io/File;Landroidx/datastore/core/Serializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "readScope", "R", "block", "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "checkNotClosed", "createParentDirectories", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class FileStorageConnection<T> implements StorageConnection<T> {
    private final java.util.concurrent.atomic.AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final File file;
    private final Function0<Unit> onClose;
    private final Serializer<T> serializer;
    private final Mutex transactionMutex;

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorageConnection$readScope$1 */
    /* JADX INFO: compiled from: FileStorage.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.FileStorageConnection", m1609f = "FileStorage.kt", m1610i = {0, 0}, m1611l = {96}, m1612m = "readScope", m1613n = {"$this$use$iv", "lock"}, m1615s = {"L$0", "Z$0"}, m1616v = 1)
    static final class C18731<R> extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18731(FileStorageConnection<T> fileStorageConnection, Continuation<? super C18731> continuation) {
            super(continuation);
            this.this$0 = fileStorageConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readScope(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorageConnection$writeScope$1 */
    /* JADX INFO: compiled from: FileStorage.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.FileStorageConnection", m1609f = "FileStorage.kt", m1610i = {0, 0, 1, 1, 1}, m1611l = {238, 112}, m1612m = "writeScope", m1613n = {"block", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "scratchFile", "$this$use$iv"}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, m1616v = 1)
    static final class C18741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FileStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18741(FileStorageConnection<T> fileStorageConnection, Continuation<? super C18741> continuation) {
            super(continuation);
            this.this$0 = fileStorageConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeScope(null, this);
        }
    }

    public FileStorageConnection(File file, Serializer<T> serializer, InterProcessCoordinator coordinator, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.file = file;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.transactionMutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // androidx.datastore.core.StorageConnection
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a A[Catch: all -> 0x0089, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0089, blocks: (B:31:0x007a, B:38:0x0088, B:37:0x0085, B:34:0x0080), top: B:50:0x0023, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3<? super androidx.datastore.core.ReadScope<T>, ? super java.lang.Boolean, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object readScope(Function3<? super ReadScope<T>, ? super Boolean, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) throws Throwable {
        C18731 c18731;
        Throwable th;
        Closeable closeable;
        ?? r9;
        if (continuation instanceof C18731) {
            c18731 = (C18731) continuation;
            if ((c18731.label & Integer.MIN_VALUE) != 0) {
                c18731.label -= Integer.MIN_VALUE;
            } else {
                c18731 = new C18731(this, continuation);
            }
        }
        Object obj = c18731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18731.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function3 = (Function3<? super ReadScope<T>, ? super Boolean, ? super Continuation<? super R>, ? extends Object>) c18731.Z$0;
                closeable = (Closeable) c18731.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    r9 = function3;
                    try {
                        closeable.close();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (th == null) {
                        throw th;
                    }
                    if (r9 != 0) {
                        Mutex.DefaultImpls.unlock$default(this.transactionMutex, null, 1, null);
                    }
                    return obj;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        closeable.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th, th4);
                    }
                    throw th;
                }
            }
            ResultKt.throwOnFailure(obj);
            checkNotClosed();
            boolean zTryLock$default = Mutex.DefaultImpls.tryLock$default(this.transactionMutex, null, 1, null);
            try {
                FileReadScope fileReadScope = new FileReadScope(this.file, this.serializer);
                try {
                    Boolean boolBoxBoolean = Boxing.boxBoolean(zTryLock$default);
                    c18731.L$0 = fileReadScope;
                    c18731.Z$0 = zTryLock$default;
                    c18731.label = 1;
                    Object objInvoke = function3.invoke(fileReadScope, boolBoxBoolean, c18731);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objInvoke;
                    r9 = zTryLock$default;
                    closeable = fileReadScope;
                    closeable.close();
                    th = null;
                    if (th == null) {
                    }
                } catch (Throwable th5) {
                    th = th5;
                    function3 = zTryLock$default;
                    closeable = fileReadScope;
                    closeable.close();
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                function3 = zTryLock$default;
                if (function3 != 0) {
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            if (function3 != 0) {
                Mutex.DefaultImpls.unlock$default(this.transactionMutex, null, 1, null);
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6 A[Catch: all -> 0x0101, IOException -> 0x0104, TRY_ENTER, TryCatch #0 {all -> 0x0101, blocks: (B:34:0x00b6, B:36:0x00bc, B:39:0x00c5, B:40:0x00e9, B:41:0x00ea, B:44:0x00f2, B:51:0x0100, B:50:0x00fd), top: B:64:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f2 A[Catch: all -> 0x0101, IOException -> 0x0104, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0101, blocks: (B:34:0x00b6, B:36:0x00bc, B:39:0x00c5, B:40:0x00e9, B:41:0x00ea, B:44:0x00f2, B:51:0x0100, B:50:0x00fd), top: B:64:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r10v14, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.File, java.lang.Object] */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeScope(Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        C18741 c18741;
        ?? r10;
        ?? file;
        FileWriteScope fileWriteScope;
        Throwable th;
        Closeable closeable;
        ?? r1;
        ?? r2;
        if (continuation instanceof C18741) {
            c18741 = (C18741) continuation;
            if ((c18741.label & Integer.MIN_VALUE) != 0) {
                c18741.label -= Integer.MIN_VALUE;
            } else {
                c18741 = new C18741(this, continuation);
            }
        }
        Object obj = c18741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18741.label;
        try {
            try {
            } catch (Throwable th2) {
                th = th2;
                r10 = c18741;
                r10.unlock(null);
                throw th;
            }
            try {
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            checkNotClosed();
                            createParentDirectories(this.file);
                            Mutex mutex = this.transactionMutex;
                            c18741.L$0 = function2;
                            c18741.L$1 = mutex;
                            c18741.label = 1;
                            Object objLock = mutex.lock(null, c18741);
                            r10 = mutex;
                            if (objLock != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            closeable = (Closeable) c18741.L$2;
                            File file2 = (File) c18741.L$1;
                            Mutex mutex2 = (Mutex) c18741.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                r1 = mutex2;
                                r2 = file2;
                                Unit unit = Unit.INSTANCE;
                                try {
                                    closeable.close();
                                    th = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                                if (th != null) {
                                    if (r2.exists() && !FileMoves_androidKt.atomicMoveTo(r2, this.file)) {
                                        throw new IOException("Unable to rename " + r2 + " to " + this.file + ". This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                    r1.unlock(null);
                                    return Unit.INSTANCE;
                                }
                                throw th;
                            } catch (Throwable th4) {
                                th = th4;
                                try {
                                    closeable.close();
                                } catch (Throwable th5) {
                                    ExceptionsKt.addSuppressed(th, th5);
                                }
                                throw th;
                            }
                        }
                        Mutex mutex3 = (Mutex) c18741.L$1;
                        Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function22 = (Function2) c18741.L$0;
                        ResultKt.throwOnFailure(obj);
                        r10 = mutex3;
                        function2 = function22;
                        c18741.L$0 = r10;
                        c18741.L$1 = file;
                        c18741.L$2 = fileWriteScope;
                        c18741.label = 2;
                        if (function2.invoke(fileWriteScope, c18741) != coroutine_suspended) {
                            r1 = r10;
                            r2 = file;
                            closeable = fileWriteScope;
                            Unit unit3 = Unit.INSTANCE;
                            closeable.close();
                            th = null;
                            if (th != null) {
                            }
                        }
                        return coroutine_suspended;
                    } catch (Throwable th6) {
                        th = th6;
                        closeable = fileWriteScope;
                        closeable.close();
                        throw th;
                    }
                    fileWriteScope = new FileWriteScope(file, this.serializer);
                } catch (IOException e) {
                    e = e;
                    if (file.exists()) {
                        file.delete();
                    }
                    throw e;
                }
                file = new File(this.file.getAbsolutePath() + ETagPayloadStore.TEMP_SUFFIX);
            } catch (Throwable th7) {
                th = th7;
                r10.unlock(null);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            r10 = c18741;
            file = coroutine_suspended;
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.".toString());
        }
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
}

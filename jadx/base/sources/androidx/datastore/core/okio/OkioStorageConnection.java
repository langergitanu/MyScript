package androidx.datastore.core.okio;

import androidx.datastore.core.Closeable;
import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.ReadScope;
import androidx.datastore.core.StorageConnection;
import androidx.datastore.core.WriteScope;
import androidx.exifinterface.media.ExifInterface;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.common.networking.ETagPayloadStore;
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
import okio.FileSystem;
import okio.Path;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: OkioStorage.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJX\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0001\u0010\u00172B\u0010\u0018\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u0019¢\u0006\u0002\b!H\u0096@¢\u0006\u0002\u0010\"J=\u0010#\u001a\u00020\r2-\u0010\u0018\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0$¢\u0006\u0002\b!H\u0096@¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\rH\u0002J\b\u0010(\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, m1599d2 = {"Landroidx/datastore/core/okio/OkioStorageConnection;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/StorageConnection;", "fileSystem", "Lokio/FileSystem;", ClientCookie.PATH_ATTR, "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "<init>", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "readScope", "R", "block", "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkNotClosed", "close", "datastore-core-okio"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class OkioStorageConnection<T> implements StorageConnection<T> {
    private final AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final FileSystem fileSystem;
    private final Function0<Unit> onClose;
    private final Path path;
    private final OkioSerializer<T> serializer;
    private final Mutex transactionMutex;

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioStorageConnection$readScope$1 */
    /* JADX INFO: compiled from: OkioStorage.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.okio.OkioStorageConnection", m1609f = "OkioStorage.kt", m1610i = {0, 0}, m1611l = {113}, m1612m = "readScope", m1613n = {"$this$use$iv", "lock"}, m1615s = {"L$0", "Z$0"}, m1616v = 1)
    static final class C18921<R> extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18921(OkioStorageConnection<T> okioStorageConnection, Continuation<? super C18921> continuation) {
            super(continuation);
            this.this$0 = okioStorageConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readScope(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioStorageConnection$writeScope$1 */
    /* JADX INFO: compiled from: OkioStorage.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.okio.OkioStorageConnection", m1609f = "OkioStorage.kt", m1610i = {0, 0, 0, 1, 1, 1}, m1611l = {PDFACompliance.e_PDFA2_4_2, PDFACompliance.e_PDFA1_3_1}, m1612m = "writeScope", m1613n = {"block", "parentDir", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "scratchPath", "$this$use$iv"}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, m1616v = 1)
    static final class C18931 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioStorageConnection<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18931(OkioStorageConnection<T> okioStorageConnection, Continuation<? super C18931> continuation) {
            super(continuation);
            this.this$0 = okioStorageConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeScope(null, this);
        }
    }

    public OkioStorageConnection(FileSystem fileSystem, Path path, OkioSerializer<T> serializer, InterProcessCoordinator coordinator, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.fileSystem = fileSystem;
        this.path = path;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new AtomicBoolean(false);
        this.transactionMutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // androidx.datastore.core.StorageConnection
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007c A[Catch: all -> 0x008b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x008b, blocks: (B:31:0x007c, B:38:0x008a, B:37:0x0087, B:34:0x0082), top: B:52:0x0023, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3<? super androidx.datastore.core.ReadScope<T>, ? super java.lang.Boolean, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v9 */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object readScope(Function3<? super ReadScope<T>, ? super Boolean, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) throws Throwable {
        C18921 c18921;
        Throwable th;
        Closeable closeable;
        ?? r10;
        if (continuation instanceof C18921) {
            c18921 = (C18921) continuation;
            if ((c18921.label & Integer.MIN_VALUE) != 0) {
                c18921.label -= Integer.MIN_VALUE;
            } else {
                c18921 = new C18921(this, continuation);
            }
        }
        Object obj = c18921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18921.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function3 = (Function3<? super ReadScope<T>, ? super Boolean, ? super Continuation<? super R>, ? extends Object>) c18921.Z$0;
                closeable = (Closeable) c18921.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    r10 = function3;
                    try {
                        closeable.close();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (th == null) {
                        throw th;
                    }
                    if (r10 != 0) {
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
                OkioReadScope okioReadScope = new OkioReadScope(this.fileSystem, this.path, this.serializer);
                try {
                    Boolean boolBoxBoolean = Boxing.boxBoolean(zTryLock$default);
                    c18921.L$0 = okioReadScope;
                    c18921.Z$0 = zTryLock$default;
                    c18921.label = 1;
                    Object objInvoke = function3.invoke(okioReadScope, boolBoxBoolean, c18921);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objInvoke;
                    r10 = zTryLock$default;
                    closeable = okioReadScope;
                    closeable.close();
                    th = null;
                    if (th == null) {
                    }
                } catch (Throwable th5) {
                    th = th5;
                    function3 = zTryLock$default;
                    closeable = okioReadScope;
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
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9 A[Catch: all -> 0x00ef, IOException -> 0x00f2, TRY_ENTER, TryCatch #5 {IOException -> 0x00f2, blocks: (B:36:0x00c9, B:38:0x00d1, B:42:0x00e0, B:49:0x00ee, B:48:0x00eb), top: B:75:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e0 A[Catch: all -> 0x00ef, IOException -> 0x00f2, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x00f2, blocks: (B:36:0x00c9, B:38:0x00d1, B:42:0x00e0, B:49:0x00ee, B:48:0x00eb), top: B:75:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [okio.FileSystem] */
    /* JADX WARN: Type inference failed for: r0v5, types: [okio.FileSystem] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [okio.Path] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [okio.Path] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, okio.Path] */
    /* JADX WARN: Type inference failed for: r5v6, types: [okio.FileSystem] */
    /* JADX WARN: Type inference failed for: r9v19, types: [okio.FileSystem] */
    /* JADX WARN: Type inference failed for: r9v23, types: [okio.FileSystem] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeScope(Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        C18931 c18931;
        ?? r10;
        ?? Resolve;
        Path pathParent;
        OkioWriteScope okioWriteScope;
        Throwable th;
        Closeable closeable;
        ?? r0;
        ?? r1;
        if (continuation instanceof C18931) {
            c18931 = (C18931) continuation;
            if ((c18931.label & Integer.MIN_VALUE) != 0) {
                c18931.label -= Integer.MIN_VALUE;
            } else {
                c18931 = new C18931(this, continuation);
            }
        }
        Object obj = c18931.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18931.label;
        try {
            try {
                try {
                    try {
                        try {
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                checkNotClosed();
                                pathParent = this.path.parent();
                                if (pathParent == null) {
                                    throw new IllegalStateException("must have a parent path".toString());
                                }
                                this.fileSystem.createDirectories(pathParent, false);
                                Mutex mutex = this.transactionMutex;
                                c18931.L$0 = function2;
                                c18931.L$1 = pathParent;
                                c18931.L$2 = mutex;
                                c18931.label = 1;
                                Object objLock = mutex.lock(null, c18931);
                                r10 = mutex;
                                if (objLock != coroutine_suspended) {
                                }
                                return coroutine_suspended;
                            }
                            if (i != 1) {
                                if (i != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                closeable = (Closeable) c18931.L$2;
                                Path path = (Path) c18931.L$1;
                                Mutex mutex2 = (Mutex) c18931.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    r0 = mutex2;
                                    r1 = path;
                                    Unit unit = Unit.INSTANCE;
                                    try {
                                        closeable.close();
                                        th = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                    if (th != null) {
                                        if (this.fileSystem.exists(r1)) {
                                            this.fileSystem.atomicMove(r1, this.path);
                                        }
                                        Unit unit2 = Unit.INSTANCE;
                                        r0.unlock(null);
                                        return Unit.INSTANCE;
                                    }
                                    throw th;
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
                            Mutex mutex3 = (Mutex) c18931.L$2;
                            pathParent = (Path) c18931.L$1;
                            Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function22 = (Function2) c18931.L$0;
                            ResultKt.throwOnFailure(obj);
                            r10 = mutex3;
                            function2 = function22;
                            c18931.L$0 = r10;
                            c18931.L$1 = Resolve;
                            c18931.L$2 = okioWriteScope;
                            c18931.label = 2;
                            if (function2.invoke(okioWriteScope, c18931) != coroutine_suspended) {
                                r0 = r10;
                                r1 = Resolve;
                                closeable = okioWriteScope;
                                Unit unit3 = Unit.INSTANCE;
                                closeable.close();
                                th = null;
                                if (th != null) {
                                }
                            }
                            return coroutine_suspended;
                        } catch (Throwable th5) {
                            th = th5;
                            closeable = okioWriteScope;
                            closeable.close();
                            throw th;
                        }
                        this.fileSystem.delete(Resolve, false);
                        okioWriteScope = new OkioWriteScope(this.fileSystem, Resolve, this.serializer);
                    } catch (IOException e) {
                        e = e;
                        if (this.fileSystem.exists(Resolve)) {
                            try {
                                this.fileSystem.delete(Resolve);
                            } catch (IOException unused) {
                            }
                        }
                        throw e;
                    }
                    Resolve = pathParent.resolve(this.path.name() + ETagPayloadStore.TEMP_SUFFIX);
                } catch (Throwable th6) {
                    th = th6;
                    r10.unlock(null);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                r10 = c18931;
                Resolve = coroutine_suspended;
            }
        } catch (Throwable th7) {
            th = th7;
            r10 = c18931;
            r10.unlock(null);
            throw th;
        }
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.".toString());
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }
}

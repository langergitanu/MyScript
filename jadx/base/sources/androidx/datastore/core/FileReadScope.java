package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileStorage.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000f\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Landroidx/datastore/core/FileReadScope;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/ReadScope;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "<init>", "(Ljava/io/File;Landroidx/datastore/core/Serializer;)V", "getFile", "()Ljava/io/File;", "getSerializer", "()Landroidx/datastore/core/Serializer;", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "readData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "checkNotClosed", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public class FileReadScope<T> implements ReadScope<T> {
    private final java.util.concurrent.atomic.AtomicBoolean closed;
    private final File file;
    private final Serializer<T> serializer;

    @Override // androidx.datastore.core.ReadScope
    public Object readData(Continuation<? super T> continuation) {
        return readData$suspendImpl(this, continuation);
    }

    public FileReadScope(File file, Serializer<T> serializer) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.file = file;
        this.serializer = serializer;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
    }

    protected final File getFile() {
        return this.file;
    }

    protected final Serializer<T> getSerializer() {
        return this.serializer;
    }

    /* JADX INFO: renamed from: androidx.datastore.core.FileReadScope$readData$2 */
    /* JADX INFO: compiled from: FileStorage.kt */
    @Metadata(m1598d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n"}, m1599d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.FileReadScope$readData$2", m1609f = "FileStorage.kt", m1610i = {}, m1611l = {162, 170}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {}, m1616v = 1)
    static final class C18722 extends SuspendLambda implements Function1<Continuation<? super T>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ FileReadScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18722(FileReadScope<T> fileReadScope, Continuation<? super C18722> continuation) {
            super(1, continuation);
            this.this$0 = fileReadScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C18722(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super T> continuation) {
            return ((C18722) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
        
            if (r8 == r0) goto L34;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v12, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Exception {
            java.io.Closeable closeable;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            try {
                try {
                    try {
                    } catch (FileNotFoundException unused) {
                        if (this.this$0.getFile().exists()) {
                            FileInputStream fileInputStream = new FileInputStream(this.this$0.getFile());
                            try {
                                this.L$0 = fileInputStream;
                                this.label = 2;
                                Object from = this.this$0.getSerializer().readFrom(fileInputStream, this);
                                if (from != coroutine_suspended) {
                                    closeable = fileInputStream;
                                    obj = from;
                                }
                                return coroutine_suspended;
                            } catch (Throwable th2) {
                                closeable = fileInputStream;
                                th = th2;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    kotlin.p039io.CloseableKt.closeFinally(closeable, th);
                                    throw th3;
                                }
                            }
                        }
                        return this.this$0.getSerializer().getDefaultValue();
                    }
                    if (r1 == 0) {
                        ResultKt.throwOnFailure(obj);
                        FileInputStream fileInputStream2 = new FileInputStream(this.this$0.getFile());
                        this.L$0 = fileInputStream2;
                        this.label = 1;
                        obj = this.this$0.getSerializer().readFrom(fileInputStream2, this);
                        r1 = fileInputStream2;
                    } else {
                        if (r1 != 1) {
                            if (r1 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            closeable = (java.io.Closeable) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                kotlin.p039io.CloseableKt.closeFinally(closeable, null);
                                return obj;
                            } catch (Throwable th4) {
                                th = th4;
                                throw th;
                            }
                        }
                        java.io.Closeable closeable2 = (java.io.Closeable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        r1 = closeable2;
                    }
                    kotlin.p039io.CloseableKt.closeFinally(r1, null);
                    return obj;
                } catch (Exception e) {
                    if (e instanceof FileNotFoundException) {
                        throw DirectBootExceptionUtilKt.wrapExceptionIfDueToDirectBoot(this.this$0.getFile().getParent(), e);
                    }
                    throw e;
                }
            } finally {
            }
        }
    }

    static /* synthetic */ <T> Object readData$suspendImpl(FileReadScope<T> fileReadScope, Continuation<? super T> continuation) {
        fileReadScope.checkNotClosed();
        return FileStorageKt.runFileDiagnosticsIfNotCorruption(((FileReadScope) fileReadScope).file, new C18722(fileReadScope, null), continuation);
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
    }

    protected final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.".toString());
        }
    }
}

package androidx.datastore.core.okio;

import androidx.datastore.core.DirectBootExceptionUtilKt;
import androidx.datastore.core.WriteScope;
import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.io.FileNotFoundException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.FileHandle;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: OkioStorage.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"Landroidx/datastore/core/okio/OkioWriteScope;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/okio/OkioReadScope;", "Landroidx/datastore/core/WriteScope;", "fileSystem", "Lokio/FileSystem;", ClientCookie.PATH_ATTR, "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "<init>", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;)V", "writeData", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class OkioWriteScope<T> extends OkioReadScope<T> implements WriteScope<T> {

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioWriteScope$writeData$1 */
    /* JADX INFO: compiled from: OkioStorage.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.okio.OkioWriteScope", m1609f = "OkioStorage.kt", m1610i = {0, 0, 0}, m1611l = {214}, m1612m = "writeData", m1613n = {"$this$use$iv", "handle", "$this$use$iv"}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 1)
    static final class C18941 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioWriteScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18941(OkioWriteScope<T> okioWriteScope, Continuation<? super C18941> continuation) {
            super(continuation);
            this.this$0 = okioWriteScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeData(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioWriteScope(FileSystem fileSystem, Path path, OkioSerializer<T> serializer) {
        super(fileSystem, path, serializer);
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2 A[Catch: all -> 0x00ad, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x00ad, blocks: (B:45:0x00a2, B:51:0x00ac, B:20:0x0055), top: B:85:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac A[Catch: all -> 0x00ad, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x00ad, blocks: (B:45:0x00a2, B:51:0x00ac, B:20:0x0055), top: B:85:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.datastore.core.WriteScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeData(T t, Continuation<? super Unit> continuation) throws Exception {
        C18941 c18941;
        FileHandle fileHandleOpenReadWrite;
        Closeable closeable;
        Throwable th;
        Closeable closeable2;
        FileHandle fileHandle;
        Throwable th2;
        if (continuation instanceof C18941) {
            c18941 = (C18941) continuation;
            if ((c18941.label & Integer.MIN_VALUE) != 0) {
                c18941.label -= Integer.MIN_VALUE;
            } else {
                c18941 = new C18941(this, continuation);
            }
        }
        Object obj = c18941.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18941.label;
        Throwable th3 = null;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                checkClose();
                fileHandleOpenReadWrite = getFileSystem().openReadWrite(getPath());
                try {
                    FileHandle fileHandle2 = fileHandleOpenReadWrite;
                    BufferedSink bufferedSinkBuffer = Okio.buffer(FileHandle.sink$default(fileHandle2, 0L, 1, null));
                    try {
                        OkioSerializer<T> serializer = getSerializer();
                        c18941.L$0 = fileHandleOpenReadWrite;
                        c18941.L$1 = fileHandle2;
                        c18941.L$2 = bufferedSinkBuffer;
                        c18941.label = 1;
                        if (serializer.writeTo(t, bufferedSinkBuffer, c18941) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        closeable = fileHandleOpenReadWrite;
                        fileHandle = fileHandle2;
                        closeable2 = bufferedSinkBuffer;
                    } catch (Throwable th4) {
                        closeable = fileHandleOpenReadWrite;
                        th = th4;
                        closeable2 = bufferedSinkBuffer;
                        if (closeable2 != null) {
                        }
                        th2 = th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (fileHandleOpenReadWrite != null) {
                    }
                    th3 = th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable2 = (Closeable) c18941.L$2;
                fileHandle = (FileHandle) c18941.L$1;
                closeable = (Closeable) c18941.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th6) {
                    th = th6;
                    if (closeable2 != null) {
                        try {
                            closeable2.close();
                        } catch (Throwable th7) {
                            try {
                                ExceptionsKt.addSuppressed(th, th7);
                            } catch (Throwable th8) {
                                th = th8;
                                fileHandleOpenReadWrite = closeable;
                                if (fileHandleOpenReadWrite != null) {
                                    try {
                                        fileHandleOpenReadWrite.close();
                                    } catch (Throwable th9) {
                                        ExceptionsKt.addSuppressed(th, th9);
                                    }
                                }
                                th3 = th;
                            }
                        }
                    }
                    th2 = th;
                }
            }
            fileHandle.flush();
            Unit unit = Unit.INSTANCE;
            if (closeable2 != null) {
                try {
                    closeable2.close();
                    th2 = null;
                } catch (Throwable th10) {
                    th2 = th10;
                }
                Closeable closeable3 = closeable;
                if (th2 != null) {
                    Unit unit2 = Unit.INSTANCE;
                    if (closeable3 != null) {
                        try {
                            closeable3.close();
                        } catch (Throwable th11) {
                            th3 = th11;
                        }
                    }
                } else {
                    throw th2;
                }
            } else {
                th2 = null;
                Closeable closeable32 = closeable;
                if (th2 != null) {
                }
            }
            if (th3 == null) {
                return Unit.INSTANCE;
            }
            throw th3;
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                throw DirectBootExceptionUtilKt.wrapExceptionIfDueToDirectBoot(String.valueOf(getPath().parent()), e);
            }
            throw e;
        }
    }
}

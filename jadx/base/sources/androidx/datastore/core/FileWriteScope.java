package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m1599d2 = {"Landroidx/datastore/core/FileWriteScope;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/FileReadScope;", "Landroidx/datastore/core/WriteScope;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "<init>", "(Ljava/io/File;Landroidx/datastore/core/Serializer;)V", "writeData", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class FileWriteScope<T> extends FileReadScope<T> implements WriteScope<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriteScope(File file, Serializer<T> serializer) {
        super(file, serializer);
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    /* JADX INFO: renamed from: androidx.datastore.core.FileWriteScope$writeData$2 */
    /* JADX INFO: compiled from: FileStorage.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.FileWriteScope$writeData$2", m1609f = "FileStorage.kt", m1610i = {0}, m1611l = {206}, m1612m = "invokeSuspend", m1613n = {"stream"}, m1615s = {"L$1"}, m1616v = 1)
    static final class C18762 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ T $value;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ FileWriteScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18762(FileWriteScope<T> fileWriteScope, T t, Continuation<? super C18762> continuation) {
            super(1, continuation);
            this.this$0 = fileWriteScope;
            this.$value = t;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C18762(this.this$0, this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C18762) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            FileOutputStream fileOutputStream;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            try {
                try {
                    if (r1 == 0) {
                        ResultKt.throwOnFailure(obj);
                        FileOutputStream fileOutputStream2 = new FileOutputStream(this.this$0.getFile());
                        FileWriteScope<T> fileWriteScope = this.this$0;
                        T t = this.$value;
                        FileOutputStream fileOutputStream3 = fileOutputStream2;
                        Serializer<T> serializer = fileWriteScope.getSerializer();
                        UncloseableOutputStream uncloseableOutputStream = new UncloseableOutputStream(fileOutputStream3);
                        this.L$0 = fileOutputStream2;
                        this.L$1 = fileOutputStream3;
                        this.label = 1;
                        if (serializer.writeTo(t, uncloseableOutputStream, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        fileOutputStream = fileOutputStream3;
                        r1 = fileOutputStream2;
                    } else {
                        if (r1 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        fileOutputStream = (FileOutputStream) this.L$1;
                        java.io.Closeable closeable = (java.io.Closeable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        r1 = closeable;
                    }
                    fileOutputStream.getFD().sync();
                    Unit unit = Unit.INSTANCE;
                    kotlin.p039io.CloseableKt.closeFinally(r1, null);
                    return Unit.INSTANCE;
                } finally {
                }
            } catch (Exception e) {
                if (e instanceof FileNotFoundException) {
                    throw DirectBootExceptionUtilKt.wrapExceptionIfDueToDirectBoot(this.this$0.getFile().getParent(), e);
                }
                throw e;
            }
        }
    }

    @Override // androidx.datastore.core.WriteScope
    public Object writeData(T t, Continuation<? super Unit> continuation) throws IOException {
        checkNotClosed();
        Object objRunFileDiagnosticsIfNotCorruption = FileStorageKt.runFileDiagnosticsIfNotCorruption(getFile(), new C18762(this, t, null), continuation);
        return objRunFileDiagnosticsIfNotCorruption == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunFileDiagnosticsIfNotCorruption : Unit.INSTANCE;
    }
}

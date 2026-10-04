package androidx.datastore.core;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FileStorage.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0082@¢\u0006\u0002\u0010\b¨\u0006\t"}, m1599d2 = {"runFileDiagnosticsIfNotCorruption", ExifInterface.GPS_DIRECTION_TRUE, "file", "Ljava/io/File;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/io/File;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class FileStorageKt {

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorageKt$runFileDiagnosticsIfNotCorruption$1 */
    /* JADX INFO: compiled from: FileStorage.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.datastore.core.FileStorageKt", m1609f = "FileStorage.kt", m1610i = {0}, m1611l = {224}, m1612m = "runFileDiagnosticsIfNotCorruption", m1613n = {"file"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C18751<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C18751(Continuation<? super C18751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileStorageKt.runFileDiagnosticsIfNotCorruption(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object runFileDiagnosticsIfNotCorruption(File file, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) throws IOException {
        C18751 c18751;
        if (continuation instanceof C18751) {
            c18751 = (C18751) continuation;
            if ((c18751.label & Integer.MIN_VALUE) != 0) {
                c18751.label -= Integer.MIN_VALUE;
            } else {
                c18751 = new C18751(continuation);
            }
        }
        Object obj = c18751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18751.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            c18751.L$0 = file;
            c18751.label = 1;
            Object objInvoke = function1.invoke(c18751);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        } catch (IOException e) {
            if (e instanceof CorruptionException) {
                throw e;
            }
            throw FileDiagnostics.INSTANCE.attachFileDebugInfo(file, e);
        }
    }
}

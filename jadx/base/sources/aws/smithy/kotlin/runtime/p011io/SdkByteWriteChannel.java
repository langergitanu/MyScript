package aws.smithy.kotlin.runtime.p011io;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: SdkByteWriteChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016¨\u0006\u001fÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkByteWriteChannel;", "Ljava/io/Closeable;", "Laws/smithy/kotlin/runtime/io/Closeable;", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", FirebaseAnalytics.Param.SOURCE, "", "byteCount", "", "write", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "flush", "()V", "", "getAvailableForWrite", "()I", "availableForWrite", "isClosedForWrite", "()Z", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "getTotalBytesWritten", "()J", "totalBytesWritten", "getAutoFlush", "autoFlush", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SdkByteWriteChannel extends Closeable {
    boolean close(Throwable cause);

    void flush();

    boolean getAutoFlush();

    int getAvailableForWrite();

    Throwable getClosedCause();

    long getTotalBytesWritten();

    boolean isClosedForWrite();

    Object write(SdkBuffer sdkBuffer, long j, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: SdkByteWriteChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object write$default(SdkByteWriteChannel sdkByteWriteChannel, SdkBuffer sdkBuffer, long j, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
        if ((i & 2) != 0) {
            j = sdkBuffer.getSize();
        }
        return sdkByteWriteChannel.write(sdkBuffer, j, continuation);
    }
}

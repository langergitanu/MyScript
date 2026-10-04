package aws.smithy.kotlin.runtime.p011io;

import aws.smithy.kotlin.runtime.InternalApi;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GzipByteReadChannelJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u001d¨\u0006\""}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/GzipByteReadChannel;", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "channel", "<init>", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;)V", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "sink", "", "limit", "read", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "gzipBuffer", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "Ljava/util/zip/GZIPOutputStream;", "gzipOutputStream", "Ljava/util/zip/GZIPOutputStream;", "gzipOutputStreamClosed", "Z", "", "getAvailableForRead", "()I", "availableForRead", "isClosedForRead", "()Z", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForWrite", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GzipByteReadChannel implements SdkByteReadChannel {
    private final SdkByteReadChannel channel;
    private final SdkBuffer gzipBuffer;
    private final GZIPOutputStream gzipOutputStream;
    private boolean gzipOutputStreamClosed;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.GzipByteReadChannel$read$1 */
    /* JADX INFO: compiled from: GzipByteReadChannelJVM.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.GzipByteReadChannel", m1609f = "GzipByteReadChannelJVM.kt", m1610i = {0, 0, 0}, m1611l = {32}, m1612m = "read", m1613n = {"sink", "temp", "limit"}, m1614nl = {34}, m1615s = {"L$0", "L$1", "J$0"}, m1616v = 2)
    static final class C37451 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C37451(Continuation<? super C37451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GzipByteReadChannel.this.read(null, 0L, this);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public Throwable getClosedCause() {
        return this.channel.getClosedCause();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForWrite() {
        return this.channel.isClosedForWrite();
    }

    public GzipByteReadChannel(SdkByteReadChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        SdkBuffer sdkBuffer = new SdkBuffer();
        this.gzipBuffer = sdkBuffer;
        this.gzipOutputStream = new GZIPOutputStream(sdkBuffer.outputStream(), true);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public int getAvailableForRead() {
        return (int) this.gzipBuffer.getSize();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForRead() {
        return this.channel.isClosedForRead() && this.gzipBuffer.exhausted() && this.gzipOutputStreamClosed;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object read(SdkBuffer sdkBuffer, long j, Continuation<? super Long> continuation) {
        C37451 c37451;
        SdkBuffer sdkBuffer2;
        Object obj;
        if (continuation instanceof C37451) {
            c37451 = (C37451) continuation;
            if ((c37451.label & Integer.MIN_VALUE) != 0) {
                c37451.label -= Integer.MIN_VALUE;
            } else {
                c37451 = new C37451(continuation);
            }
        }
        Object obj2 = c37451.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37451.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            if (j < 0) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (j == 0) {
                return Boxing.boxLong(0L);
            }
            sdkBuffer2 = new SdkBuffer();
            SdkByteReadChannel sdkByteReadChannel = this.channel;
            c37451.L$0 = sdkBuffer;
            c37451.L$1 = sdkBuffer2;
            c37451.J$0 = j;
            c37451.label = 1;
            obj = sdkByteReadChannel.read(sdkBuffer2, j, c37451);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c37451.J$0;
            SdkBuffer sdkBuffer3 = (SdkBuffer) c37451.L$1;
            SdkBuffer sdkBuffer4 = (SdkBuffer) c37451.L$0;
            ResultKt.throwOnFailure(obj2);
            sdkBuffer2 = sdkBuffer3;
            sdkBuffer = sdkBuffer4;
            obj = obj2;
        }
        long jLongValue = ((Number) obj).longValue();
        if (jLongValue == -1) {
            this.gzipOutputStream.close();
            this.gzipOutputStreamClosed = true;
        }
        if (jLongValue == -1 && this.gzipBuffer.exhausted()) {
            return Boxing.boxLong(-1L);
        }
        if (jLongValue >= 0) {
            this.gzipOutputStream.write(sdkBuffer2.readByteArray());
            this.gzipOutputStream.flush();
        }
        return Boxing.boxLong(this.gzipBuffer.read(sdkBuffer, j));
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean cancel(Throwable cause) {
        this.gzipOutputStream.close();
        return this.channel.cancel(cause);
    }
}

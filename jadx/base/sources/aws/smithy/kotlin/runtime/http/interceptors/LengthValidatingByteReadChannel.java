package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.p011io.EOFException;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResponseLengthValidationInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u000e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u000e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010 ¨\u0006\""}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/LengthValidatingByteReadChannel;", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "chan", "", "expectedContentLength", "<init>", "(Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;J)V", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "sink", "limit", "read", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "J", "bytesReceived", "getBytesReceived", "()J", "setBytesReceived", "(J)V", "", "getAvailableForRead", "()I", "availableForRead", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForRead", "()Z", "isClosedForWrite", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class LengthValidatingByteReadChannel implements SdkByteReadChannel {
    private long bytesReceived;
    private final SdkByteReadChannel chan;
    private final long expectedContentLength;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.interceptors.LengthValidatingByteReadChannel$read$1 */
    /* JADX INFO: compiled from: ResponseLengthValidationInterceptor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.LengthValidatingByteReadChannel", m1609f = "ResponseLengthValidationInterceptor.kt", m1610i = {0, 0}, m1611l = {73}, m1612m = "read", m1613n = {"sink", "limit"}, m1614nl = {74}, m1615s = {"L$0", "J$0"}, m1616v = 2)
    static final class C37221 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C37221(Continuation<? super C37221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LengthValidatingByteReadChannel.this.read(null, 0L, this);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean cancel(Throwable cause) {
        return this.chan.cancel(cause);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public int getAvailableForRead() {
        return this.chan.getAvailableForRead();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public Throwable getClosedCause() {
        return this.chan.getClosedCause();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForRead() {
        return this.chan.isClosedForRead();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForWrite() {
        return this.chan.isClosedForWrite();
    }

    public LengthValidatingByteReadChannel(SdkByteReadChannel chan, long j) {
        Intrinsics.checkNotNullParameter(chan, "chan");
        this.chan = chan;
        this.expectedContentLength = j;
    }

    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    public final void setBytesReceived(long j) {
        this.bytesReceived = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object read(SdkBuffer sdkBuffer, long j, Continuation<? super Long> continuation) throws EOFException {
        C37221 c37221;
        if (continuation instanceof C37221) {
            c37221 = (C37221) continuation;
            if ((c37221.label & Integer.MIN_VALUE) != 0) {
                c37221.label -= Integer.MIN_VALUE;
            } else {
                c37221 = new C37221(continuation);
            }
        }
        Object obj = c37221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37221.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SdkByteReadChannel sdkByteReadChannel = this.chan;
            c37221.L$0 = SpillingKt.nullOutSpilledVariable(sdkBuffer);
            c37221.J$0 = j;
            c37221.label = 1;
            obj = sdkByteReadChannel.read(sdkBuffer, j, c37221);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = c37221.J$0;
            ResultKt.throwOnFailure(obj);
        }
        long jLongValue = ((Number) obj).longValue();
        if (!this.chan.isClosedForRead()) {
            long j3 = this.bytesReceived;
            if (j3 <= this.expectedContentLength) {
                this.bytesReceived = j3 + jLongValue;
                return obj;
            }
        }
        if (jLongValue != -1) {
            this.bytesReceived += jLongValue;
        }
        ResponseLengthValidationInterceptorKt.validateContentLength(this.expectedContentLength, Boxing.boxLong(this.bytesReceived));
        return obj;
    }
}

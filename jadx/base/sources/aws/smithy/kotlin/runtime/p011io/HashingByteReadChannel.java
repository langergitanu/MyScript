package aws.smithy.kotlin.runtime.p011io;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.hashing.HashFunction;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HashingByteReadChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0096@¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00128\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00128\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010\u001f¨\u0006!"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/HashingByteReadChannel;", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "hash", "chan", "<init>", "(Laws/smithy/kotlin/runtime/hashing/HashFunction;Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;)V", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "sink", "", "limit", "read", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "digest", "()[B", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "", "getAvailableForRead", "()I", "availableForRead", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForRead", "()Z", "isClosedForWrite", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HashingByteReadChannel implements SdkByteReadChannel {
    private final SdkByteReadChannel chan;
    private final HashFunction hash;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.HashingByteReadChannel$read$1 */
    /* JADX INFO: compiled from: HashingByteReadChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.HashingByteReadChannel", m1609f = "HashingByteReadChannel.kt", m1610i = {0, 0, 0}, m1611l = {23}, m1612m = "read", m1613n = {"sink", "bufferedHashingSink", "limit"}, m1614nl = {24}, m1615s = {"L$0", "L$1", "J$0"}, m1616v = 2)
    static final class C37461 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C37461(Continuation<? super C37461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HashingByteReadChannel.this.read(null, 0L, this);
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

    public HashingByteReadChannel(HashFunction hash, SdkByteReadChannel chan) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(chan, "chan");
        this.hash = hash;
        this.chan = chan;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object read(SdkBuffer sdkBuffer, long j, Continuation<? super Long> continuation) throws IOException {
        C37461 c37461;
        SdkBufferedSink sdkBufferedSink;
        if (continuation instanceof C37461) {
            c37461 = (C37461) continuation;
            if ((c37461.label & Integer.MIN_VALUE) != 0) {
                c37461.label -= Integer.MIN_VALUE;
            } else {
                c37461 = new C37461(continuation);
            }
        }
        Object obj = c37461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37461.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SdkBufferedSink sdkBufferedSinkBuffer = SdkIoKt.buffer(new HashingSink(this.hash, sdkBuffer));
            SdkByteReadChannel sdkByteReadChannel = this.chan;
            SdkBuffer buffer = sdkBufferedSinkBuffer.getBuffer();
            c37461.L$0 = SpillingKt.nullOutSpilledVariable(sdkBuffer);
            c37461.L$1 = sdkBufferedSinkBuffer;
            c37461.J$0 = j;
            c37461.label = 1;
            Object obj2 = sdkByteReadChannel.read(buffer, j, c37461);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = obj2;
            sdkBufferedSink = sdkBufferedSinkBuffer;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = c37461.J$0;
            sdkBufferedSink = (SdkBufferedSink) c37461.L$1;
            ResultKt.throwOnFailure(obj);
        }
        ((Number) obj).longValue();
        sdkBufferedSink.emit();
        return obj;
    }

    public final byte[] digest() {
        return this.hash.digest();
    }
}

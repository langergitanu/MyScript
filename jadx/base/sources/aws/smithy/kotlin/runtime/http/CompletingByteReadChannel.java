package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.HashingByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: compiled from: HttpBody.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0001R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u0014X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u0010X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u0010X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001b¨\u0006\u001d"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/CompletingByteReadChannel;", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "hashingChannel", "Laws/smithy/kotlin/runtime/io/HashingByteReadChannel;", "<init>", "(Lkotlinx/coroutines/CompletableDeferred;Laws/smithy/kotlin/runtime/io/HashingByteReadChannel;)V", "read", "", "sink", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "limit", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "cause", "", "availableForRead", "", "getAvailableForRead", "()I", "closedCause", "getClosedCause", "()Ljava/lang/Throwable;", "isClosedForRead", "()Z", "isClosedForWrite", "http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CompletingByteReadChannel implements SdkByteReadChannel {
    private final CompletableDeferred<String> deferred;
    private final HashingByteReadChannel hashingChannel;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.CompletingByteReadChannel$read$1 */
    /* JADX INFO: compiled from: HttpBody.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.CompletingByteReadChannel", m1609f = "HttpBody.kt", m1610i = {0, 0}, m1611l = {229}, m1612m = "read", m1613n = {"sink", "limit"}, m1614nl = {230}, m1615s = {"L$0", "J$0"}, m1616v = 2)
    static final class C36901 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C36901(Continuation<? super C36901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CompletingByteReadChannel.this.read(null, 0L, this);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean cancel(Throwable cause) {
        return this.hashingChannel.cancel(cause);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public int getAvailableForRead() {
        return this.hashingChannel.getAvailableForRead();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public Throwable getClosedCause() {
        return this.hashingChannel.getClosedCause();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForRead() {
        return this.hashingChannel.isClosedForRead();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForWrite() {
        return this.hashingChannel.isClosedForWrite();
    }

    public CompletingByteReadChannel(CompletableDeferred<String> deferred, HashingByteReadChannel hashingChannel) {
        Intrinsics.checkNotNullParameter(deferred, "deferred");
        Intrinsics.checkNotNullParameter(hashingChannel, "hashingChannel");
        this.deferred = deferred;
        this.hashingChannel = hashingChannel;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object read(SdkBuffer sdkBuffer, long j, Continuation<? super Long> continuation) throws IOException {
        C36901 c36901;
        if (continuation instanceof C36901) {
            c36901 = (C36901) continuation;
            if ((c36901.label & Integer.MIN_VALUE) != 0) {
                c36901.label -= Integer.MIN_VALUE;
            } else {
                c36901 = new C36901(continuation);
            }
        }
        Object obj = c36901.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36901.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HashingByteReadChannel hashingByteReadChannel = this.hashingChannel;
            c36901.L$0 = SpillingKt.nullOutSpilledVariable(sdkBuffer);
            c36901.J$0 = j;
            c36901.label = 1;
            obj = hashingByteReadChannel.read(sdkBuffer, j, c36901);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = c36901.J$0;
            ResultKt.throwOnFailure(obj);
        }
        if (((Number) obj).longValue() == -1) {
            this.deferred.complete(Base64Kt.encodeBase64String(this.hashingChannel.digest()));
        }
        return obj;
    }
}

package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.p011io.HashingByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.text.encoding.Base64Kt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlexibleChecksumsResponseInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00108\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00108\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001d¨\u0006\u001f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/ChecksumValidatingByteReadChannel;", "Laws/smithy/kotlin/runtime/io/SdkByteReadChannel;", "", "expectedChecksum", "Laws/smithy/kotlin/runtime/io/HashingByteReadChannel;", "hashingChan", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/io/HashingByteReadChannel;)V", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "sink", "", "limit", "read", "(Laws/smithy/kotlin/runtime/io/SdkBuffer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/lang/String;", "Laws/smithy/kotlin/runtime/io/HashingByteReadChannel;", "", "getAvailableForRead", "()I", "availableForRead", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForRead", "()Z", "isClosedForWrite", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class ChecksumValidatingByteReadChannel implements SdkByteReadChannel {
    private final String expectedChecksum;
    private final HashingByteReadChannel hashingChan;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.interceptors.ChecksumValidatingByteReadChannel$read$1 */
    /* JADX INFO: compiled from: FlexibleChecksumsResponseInterceptor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.ChecksumValidatingByteReadChannel", m1609f = "FlexibleChecksumsResponseInterceptor.kt", m1610i = {0, 0}, m1611l = {PDFACompliance.e_PDFA1_4_1}, m1612m = "read", m1613n = {"sink", "limit"}, m1614nl = {PDFACompliance.e_PDFA1_4_2}, m1615s = {"L$0", "J$0"}, m1616v = 2)
    static final class C37101 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C37101(Continuation<? super C37101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChecksumValidatingByteReadChannel.this.read(null, 0L, this);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean cancel(Throwable cause) {
        return this.hashingChan.cancel(cause);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public int getAvailableForRead() {
        return this.hashingChan.getAvailableForRead();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public Throwable getClosedCause() {
        return this.hashingChan.getClosedCause();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForRead() {
        return this.hashingChan.isClosedForRead();
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    public boolean isClosedForWrite() {
        return this.hashingChan.isClosedForWrite();
    }

    public ChecksumValidatingByteReadChannel(String expectedChecksum, HashingByteReadChannel hashingChan) {
        Intrinsics.checkNotNullParameter(expectedChecksum, "expectedChecksum");
        Intrinsics.checkNotNullParameter(hashingChan, "hashingChan");
        this.expectedChecksum = expectedChecksum;
        this.hashingChan = hashingChan;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object read(SdkBuffer sdkBuffer, long j, Continuation<? super Long> continuation) throws IOException {
        C37101 c37101;
        if (continuation instanceof C37101) {
            c37101 = (C37101) continuation;
            if ((c37101.label & Integer.MIN_VALUE) != 0) {
                c37101.label -= Integer.MIN_VALUE;
            } else {
                c37101 = new C37101(continuation);
            }
        }
        Object obj = c37101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37101.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HashingByteReadChannel hashingByteReadChannel = this.hashingChan;
            c37101.L$0 = SpillingKt.nullOutSpilledVariable(sdkBuffer);
            c37101.J$0 = j;
            c37101.label = 1;
            obj = hashingByteReadChannel.read(sdkBuffer, j, c37101);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = c37101.J$0;
            ResultKt.throwOnFailure(obj);
        }
        if (((Number) obj).longValue() == -1) {
            FlexibleChecksumsResponseInterceptorKt.validateAndThrow(this.expectedChecksum, Base64Kt.encodeBase64String(this.hashingChan.digest()));
        }
        return obj;
    }
}

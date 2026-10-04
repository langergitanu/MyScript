package aws.smithy.kotlin.runtime.p011io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: SdkByteWriteChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a0\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkByteWriteChannel;", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", FirebaseAnalytics.Param.SOURCE, "", "writeAvailable", "(Laws/smithy/kotlin/runtime/io/SdkByteWriteChannel;Laws/smithy/kotlin/runtime/io/SdkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", TypedValues.CycleType.S_WAVE_OFFSET, "limit", "", "write", "(Laws/smithy/kotlin/runtime/io/SdkByteWriteChannel;[BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkByteWriteChannelKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.SdkByteWriteChannelKt$writeAvailable$1 */
    /* JADX INFO: compiled from: SdkByteWriteChannel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.SdkByteWriteChannelKt", m1609f = "SdkByteWriteChannel.kt", m1610i = {0, 0, 0}, m1611l = {80}, m1612m = "writeAvailable", m1613n = {"$this$writeAvailable", FirebaseAnalytics.Param.SOURCE, "wc"}, m1614nl = {PDFACompliance.e_PDFA8_1}, m1615s = {"L$0", "L$1", "J$0"}, m1616v = 2)
    static final class C37591 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C37591(Continuation<? super C37591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SdkByteWriteChannelKt.writeAvailable(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object writeAvailable(SdkByteWriteChannel sdkByteWriteChannel, SdkBuffer sdkBuffer, Continuation<? super Long> continuation) {
        C37591 c37591;
        long j;
        if (continuation instanceof C37591) {
            c37591 = (C37591) continuation;
            if ((c37591.label & Integer.MIN_VALUE) != 0) {
                c37591.label -= Integer.MIN_VALUE;
            } else {
                c37591 = new C37591(continuation);
            }
        }
        Object obj = c37591.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37591.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long jMin = Math.min(sdkByteWriteChannel.getAvailableForWrite(), sdkBuffer.getSize());
            c37591.L$0 = SpillingKt.nullOutSpilledVariable(sdkByteWriteChannel);
            c37591.L$1 = SpillingKt.nullOutSpilledVariable(sdkBuffer);
            c37591.J$0 = jMin;
            c37591.label = 1;
            if (sdkByteWriteChannel.write(sdkBuffer, jMin, c37591) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = jMin;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c37591.J$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxLong(j);
    }

    public static /* synthetic */ Object write$default(SdkByteWriteChannel sdkByteWriteChannel, byte[] bArr, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return write(sdkByteWriteChannel, bArr, i, i2, continuation);
    }

    public static final Object write(SdkByteWriteChannel sdkByteWriteChannel, byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) throws IOException {
        SdkBuffer sdkBuffer = new SdkBuffer();
        sdkBuffer.write(bArr, i, i2);
        Object objWrite$default = SdkByteWriteChannel.write$default(sdkByteWriteChannel, sdkBuffer, 0L, continuation, 2, null);
        return objWrite$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWrite$default : Unit.INSTANCE;
    }
}

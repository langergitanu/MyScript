package aws.smithy.kotlin.runtime.content;

import androidx.compose.material.TextFieldImplKt;
import aws.smithy.kotlin.runtime.p011io.SdkByteChannel;
import aws.smithy.kotlin.runtime.p011io.SdkByteWriteChannelKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ByteStream.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.content.ByteStreamKt$toByteStream$job$1", m1609f = "ByteStream.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_4_1}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {TextFieldImplKt.AnimationDuration}, m1615s = {}, m1616v = 2)
final class ByteStreamKt$toByteStream$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SdkByteChannel $ch;
    final /* synthetic */ Long $contentLength;
    final /* synthetic */ Flow<byte[]> $this_toByteStream;
    final /* synthetic */ Ref.LongRef $totalWritten;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ByteStreamKt$toByteStream$job$1(Flow<byte[]> flow, Long l, Ref.LongRef longRef, SdkByteChannel sdkByteChannel, Continuation<? super ByteStreamKt$toByteStream$job$1> continuation) {
        super(2, continuation);
        this.$this_toByteStream = flow;
        this.$contentLength = l;
        this.$totalWritten = longRef;
        this.$ch = sdkByteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ByteStreamKt$toByteStream$job$1(this.$this_toByteStream, this.$contentLength, this.$totalWritten, this.$ch, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ByteStreamKt$toByteStream$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.content.ByteStreamKt$toByteStream$job$1$1 */
    /* JADX INFO: compiled from: ByteStream.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final class C36871<T> implements FlowCollector {
        final /* synthetic */ SdkByteChannel $ch;
        final /* synthetic */ Long $contentLength;
        final /* synthetic */ Ref.LongRef $totalWritten;

        C36871(SdkByteChannel sdkByteChannel, Ref.LongRef longRef, Long l) {
            this.$ch = sdkByteChannel;
            this.$totalWritten = longRef;
            this.$contentLength = l;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((byte[]) obj, (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(byte[] bArr, Continuation<? super Unit> continuation) {
            ByteStreamKt$toByteStream$job$1$1$emit$1 byteStreamKt$toByteStream$job$1$1$emit$1;
            byte[] bArr2;
            if (continuation instanceof ByteStreamKt$toByteStream$job$1$1$emit$1) {
                byteStreamKt$toByteStream$job$1$1$emit$1 = (ByteStreamKt$toByteStream$job$1$1$emit$1) continuation;
                if ((byteStreamKt$toByteStream$job$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    byteStreamKt$toByteStream$job$1$1$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    byteStreamKt$toByteStream$job$1$1$emit$1 = new ByteStreamKt$toByteStream$job$1$1$emit$1(this, continuation);
                }
            }
            ByteStreamKt$toByteStream$job$1$1$emit$1 byteStreamKt$toByteStream$job$1$1$emit$12 = byteStreamKt$toByteStream$job$1$1$emit$1;
            Object obj = byteStreamKt$toByteStream$job$1$1$emit$12.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = byteStreamKt$toByteStream$job$1$1$emit$12.label;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SdkByteChannel sdkByteChannel = this.$ch;
                byteStreamKt$toByteStream$job$1$1$emit$12.L$0 = bArr;
                byteStreamKt$toByteStream$job$1$1$emit$12.label = 1;
                if (SdkByteWriteChannelKt.write$default(sdkByteChannel, bArr, 0, 0, byteStreamKt$toByteStream$job$1$1$emit$12, 6, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bArr2 = bArr;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bArr2 = (byte[]) byteStreamKt$toByteStream$job$1$1$emit$12.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.$totalWritten.element += (long) bArr2.length;
            if (this.$contentLength != null && this.$totalWritten.element > this.$contentLength.longValue()) {
                z = false;
            }
            Ref.LongRef longRef = this.$totalWritten;
            Long l = this.$contentLength;
            if (!z) {
                throw new IllegalStateException((longRef.element + " bytes collected from flow exceeds reported content length of " + l).toString());
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$this_toByteStream.collect(new C36871(this.$ch, this.$totalWritten, this.$contentLength), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (this.$contentLength != null) {
            long j = this.$totalWritten.element;
            Long l = this.$contentLength;
            if (l == null || j != l.longValue()) {
                z = false;
            }
        }
        Long l2 = this.$contentLength;
        Ref.LongRef longRef = this.$totalWritten;
        if (!z) {
            throw new IllegalStateException(("expected " + l2 + " bytes collected from flow, got " + longRef.element).toString());
        }
        this.$ch.close();
        return Unit.INSTANCE;
    }
}

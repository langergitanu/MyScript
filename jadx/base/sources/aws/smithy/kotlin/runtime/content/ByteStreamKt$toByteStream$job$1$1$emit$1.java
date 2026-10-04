package aws.smithy.kotlin.runtime.content;

import aws.smithy.kotlin.runtime.content.ByteStreamKt$toByteStream$job$1;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ByteStream.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.content.ByteStreamKt$toByteStream$job$1$1", m1609f = "ByteStream.kt", m1610i = {0}, m1611l = {PDFACompliance.e_PDFA1_4_2}, m1612m = "emit", m1613n = {"bytes"}, m1614nl = {143}, m1615s = {"L$0"}, m1616v = 2)
final class ByteStreamKt$toByteStream$job$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteStreamKt$toByteStream$job$1.C36871<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ByteStreamKt$toByteStream$job$1$1$emit$1(ByteStreamKt$toByteStream$job$1.C36871<? super T> c36871, Continuation<? super ByteStreamKt$toByteStream$job$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c36871;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((byte[]) null, (Continuation<? super Unit>) this);
    }
}

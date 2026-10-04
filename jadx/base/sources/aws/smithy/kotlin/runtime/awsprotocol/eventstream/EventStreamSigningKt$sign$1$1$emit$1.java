package aws.smithy.kotlin.runtime.awsprotocol.eventstream;

import androidx.constraintlayout.widget.ConstraintLayout;
import aws.smithy.kotlin.runtime.awsprotocol.eventstream.EventStreamSigningKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: EventStreamSigning.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.awsprotocol.eventstream.EventStreamSigningKt$sign$1$1", m1609f = "EventStreamSigning.kt", m1610i = {0, 0, 1, 1, 2, 2, 2}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE, 57, 59}, m1612m = "emit", m1613n = {"message", "buffer", "message", "buffer", "message", "buffer", "result"}, m1614nl = {57, 58, 60}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2"}, m1616v = 2)
final class EventStreamSigningKt$sign$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventStreamSigningKt.C36601.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    EventStreamSigningKt$sign$1$1$emit$1(EventStreamSigningKt.C36601.AnonymousClass1<? super T> anonymousClass1, Continuation<? super EventStreamSigningKt$sign$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Message) null, (Continuation<? super Unit>) this);
    }
}

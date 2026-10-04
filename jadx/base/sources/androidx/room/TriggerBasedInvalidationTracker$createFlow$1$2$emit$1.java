package androidx.room;

import androidx.room.TriggerBasedInvalidationTracker$createFlow$1;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: InvalidationTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2", m1609f = "InvalidationTracker.kt", m1610i = {0, 0, 1, 1}, m1611l = {PDFACompliance.e_PDFA2_4_1, 250}, m1612m = "emit", m1613n = {"this", "newVersions", "this", "newVersions"}, m1615s = {"L$0", "L$1", "L$0", "L$1"})
final class TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TriggerBasedInvalidationTracker$createFlow$1.C26692<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TriggerBasedInvalidationTracker$createFlow$1$2$emit$1(TriggerBasedInvalidationTracker$createFlow$1.C26692<? super T> c26692, Continuation<? super TriggerBasedInvalidationTracker$createFlow$1$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = c26692;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((int[]) null, (Continuation<? super Unit>) this);
    }
}

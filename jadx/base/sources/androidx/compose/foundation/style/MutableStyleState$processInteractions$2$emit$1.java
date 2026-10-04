package androidx.compose.foundation.style;

import androidx.compose.foundation.interaction.Interaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: StyleState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.foundation.style.MutableStyleState$processInteractions$2", m1609f = "StyleState.kt", m1610i = {0}, m1611l = {626}, m1612m = "emit", m1613n = {"interaction"}, m1615s = {"L$0"}, m1616v = 1)
final class MutableStyleState$processInteractions$2$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MutableStyleState$processInteractions$2<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MutableStyleState$processInteractions$2$emit$1(MutableStyleState$processInteractions$2<? super T> mutableStyleState$processInteractions$2, Continuation<? super MutableStyleState$processInteractions$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = mutableStyleState$processInteractions$2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Interaction) null, (Continuation<? super Unit>) this);
    }
}

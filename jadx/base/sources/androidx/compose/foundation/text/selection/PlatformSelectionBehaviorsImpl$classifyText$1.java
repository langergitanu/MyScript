package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: PlatformSelectionBehaviors.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl", m1609f = "PlatformSelectionBehaviors.android.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1}, m1611l = {369, 380}, m1612m = "classifyText-M8tDOmk", m1613n = {"text", "textClassifier", "$this$withLock_u24default$iv", "selection", "text", "textClassification", "$this$withLock_u24default$iv", "selection"}, m1615s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0"}, m1616v = 1)
final class PlatformSelectionBehaviorsImpl$classifyText$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlatformSelectionBehaviorsImpl$classifyText$1(PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, Continuation<? super PlatformSelectionBehaviorsImpl$classifyText$1> continuation) {
        super(continuation);
        this.this$0 = platformSelectionBehaviorsImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m3990classifyTextM8tDOmk(null, 0L, null, this);
    }
}

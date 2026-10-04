package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior", m1609f = "SearchBar.kt", m1610i = {0, 0, 1}, m1611l = {972, 986}, m1612m = "settleSearchBar-OhffZ5M", m1613n = {"remainingVelocity", "scrollFraction", "remainingVelocity"}, m1615s = {"L$0", "F$0", "L$0"})
final class EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EnterAlwaysSearchBarScrollBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1(EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior, Continuation<? super EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1> continuation) {
        super(continuation);
        this.this$0 = enterAlwaysSearchBarScrollBehavior;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m5037settleSearchBarOhffZ5M(0.0f, this);
    }
}

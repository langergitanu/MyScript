package androidx.compose.material;

import androidx.compose.material.BackdropScaffoldKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1 */
/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1", m1609f = "BackdropScaffold.kt", m1610i = {0}, m1611l = {671}, m1612m = "onPreFling-QWom1Mo", m1613n = {"available"}, m1615s = {"J$0"}, m1616v = 1)
final class C0835x677cf7ed extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BackdropScaffoldKt.C08331 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0835x677cf7ed(BackdropScaffoldKt.C08331 c08331, Continuation<? super C0835x677cf7ed> continuation) {
        super(continuation);
        this.this$0 = c08331;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo2957onPreFlingQWom1Mo(0L, this);
    }
}

package androidx.compose.material;

import androidx.compose.material.DrawerKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 */
/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", m1609f = "Drawer.kt", m1610i = {0}, m1611l = {813}, m1612m = "onPreFling-QWom1Mo", m1613n = {"available"}, m1615s = {"J$0"}, m1616v = 1)
final class C0852x425444c4 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DrawerKt.C08501 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0852x425444c4(DrawerKt.C08501 c08501, Continuation<? super C0852x425444c4> continuation) {
        super(continuation);
        this.this$0 = c08501;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo2957onPreFlingQWom1Mo(0L, this);
    }
}

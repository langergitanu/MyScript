package androidx.compose.material;

import androidx.compose.material.BottomSheetScaffoldKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 */
/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", m1609f = "BottomSheetScaffold.kt", m1610i = {0}, m1611l = {581}, m1612m = "onPostFling-RZ2iAVY", m1613n = {"available"}, m1615s = {"J$0"}, m1616v = 1)
final class C0839x8eaee744 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BottomSheetScaffoldKt.C08381 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0839x8eaee744(BottomSheetScaffoldKt.C08381 c08381, Continuation<? super C0839x8eaee744> continuation) {
        super(continuation);
        this.this$0 = c08381;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo2379onPostFlingRZ2iAVY(0L, 0L, this);
    }
}

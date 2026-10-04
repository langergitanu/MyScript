package androidx.compose.foundation.relocation;

import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.relocation.BringIntoViewModifierNodeKt;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: BringIntoViewRequester.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, m1599d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterImpl;", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "<init>", "()V", "nodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "getNodes", "()Landroidx/compose/runtime/collection/MutableVector;", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class BringIntoViewRequesterImpl implements BringIntoViewRequester {
    private final MutableVector<BringIntoViewRequesterNode> nodes = new MutableVector<>(new BringIntoViewRequesterNode[16], 0);

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 */
    /* JADX INFO: compiled from: BringIntoViewRequester.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.foundation.relocation.BringIntoViewRequesterImpl", m1609f = "BringIntoViewRequester.kt", m1610i = {0, 0, 0, 0}, m1611l = {102}, m1612m = "bringIntoView", m1613n = {"rect", "content$iv", "i$iv", "size$iv"}, m1615s = {"L$0", "L$1", "I$0", "I$1"}, m1616v = 1)
    static final class C06271 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C06271(Continuation<? super C06271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BringIntoViewRequesterImpl.this.bringIntoView(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect bringIntoView$lambda$0$0(Rect rect) {
        return rect;
    }

    public final MutableVector<BringIntoViewRequesterNode> getNodes() {
        return this.nodes;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x006c -> B:19:0x006f). Please report as a decompilation issue!!! */
    @Override // androidx.compose.foundation.relocation.BringIntoViewRequester
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object bringIntoView(Rect rect, Continuation<? super Unit> continuation) {
        C06271 c06271;
        final Rect rect2;
        int i;
        Object[] objArr;
        int i2;
        if (continuation instanceof C06271) {
            c06271 = (C06271) continuation;
            if ((c06271.label & Integer.MIN_VALUE) != 0) {
                c06271.label -= Integer.MIN_VALUE;
            } else {
                c06271 = new C06271(continuation);
            }
        }
        Object obj = c06271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c06271.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableVector<BringIntoViewRequesterNode> mutableVector = this.nodes;
            BringIntoViewRequesterNode[] bringIntoViewRequesterNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            rect2 = rect;
            i = size;
            objArr = bringIntoViewRequesterNodeArr;
            i2 = 0;
            if (i2 < i) {
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c06271.I$1;
            i2 = c06271.I$0;
            objArr = (Object[]) c06271.L$1;
            Rect rect3 = (Rect) c06271.L$0;
            ResultKt.throwOnFailure(obj);
            rect2 = rect3;
            i2++;
            if (i2 < i) {
                BringIntoViewRequesterNode bringIntoViewRequesterNode = (BringIntoViewRequesterNode) objArr[i2];
                Function0 function0 = new Function0() { // from class: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BringIntoViewRequesterImpl.bringIntoView$lambda$0$0(rect2);
                    }
                };
                c06271.L$0 = rect2;
                c06271.L$1 = objArr;
                c06271.I$0 = i2;
                c06271.I$1 = i;
                c06271.label = 1;
                if (BringIntoViewModifierNodeKt.bringIntoView(bringIntoViewRequesterNode, function0, c06271) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i2++;
                if (i2 < i) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}

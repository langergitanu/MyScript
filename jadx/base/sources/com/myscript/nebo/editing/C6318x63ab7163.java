package com.myscript.nebo.editing;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$childPageListener$1$pageSelected$1$updatedPages$1 */
/* JADX INFO: compiled from: ChildPagesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/nebo/editing/ChildPage;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$childPageListener$1$pageSelected$1$updatedPages$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {333}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {335}, m1615s = {}, m1616v = 2)
final class C6318x63ab7163 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ChildPage>>, Object> {
    final /* synthetic */ String $selectedPageId;
    int label;
    final /* synthetic */ ChildPagesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C6318x63ab7163(String str, ChildPagesViewModel childPagesViewModel, Continuation<? super C6318x63ab7163> continuation) {
        super(2, continuation);
        this.$selectedPageId = str;
        this.this$0 = childPagesViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C6318x63ab7163(this.$selectedPageId, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ChildPage>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<ChildPage>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<ChildPage>> continuation) {
        return ((C6318x63ab7163) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object next;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$selectedPageId;
            ImmutableList immutableList = (ImmutableList) this.this$0._childPages.getValue();
            if (immutableList != null) {
                Iterator<E> it = immutableList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((ChildPage) next).isActive()) {
                        break;
                    }
                }
                ChildPage childPage = (ChildPage) next;
                String id = childPage != null ? childPage.getId() : null;
                if (Intrinsics.areEqual(str, id)) {
                    return null;
                }
                this.label = 1;
                obj = ChildPagesViewModel.computeChildPages$default(this.this$0, this.$selectedPageId, null, this, 2, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return (List) obj;
    }
}

package com.myscript.nebo.editing;

import com.myscript.nebo.editing.PageViewModel;
import com.myscript.snt.core.PageKey;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$pageListener$1$onPageUUIDReset$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class PageViewModel$pageListener$1$onPageUUIDReset$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PageViewModel$pageListener$1 $listener;
    final /* synthetic */ PageKey $newKey;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageViewModel$pageListener$1$onPageUUIDReset$1(PageViewModel pageViewModel, PageKey pageKey, PageViewModel$pageListener$1 pageViewModel$pageListener$1, Continuation<? super PageViewModel$pageListener$1$onPageUUIDReset$1> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
        this.$newKey = pageKey;
        this.$listener = pageViewModel$pageListener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$pageListener$1$onPageUUIDReset$1(this.this$0, this.$newKey, this.$listener, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PageViewModel$pageListener$1$onPageUUIDReset$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objCopy$default;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PageViewModel.State state = (PageViewModel.State) this.this$0._state.getValue();
            if (state instanceof PageViewModel.State.Loaded) {
                objCopy$default = PageViewModel.State.Loaded.copy$default((PageViewModel.State.Loaded) state, this.$newKey, null, 2, null);
            } else if (state instanceof PageViewModel.State.ReadyToLoad) {
                objCopy$default = ((PageViewModel.State.ReadyToLoad) state).copy(this.$newKey);
            } else {
                if (!(state instanceof PageViewModel.State.LoadingError)) {
                    if (state instanceof PageViewModel.State.Unloaded) {
                        return Unit.INSTANCE;
                    }
                    if (state != null) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return Unit.INSTANCE;
                }
                objCopy$default = PageViewModel.State.LoadingError.copy$default((PageViewModel.State.LoadingError) state, this.$newKey, null, 2, null);
            }
            this.this$0.repository.addPageListener(this.$newKey, this.$listener);
            this.this$0._state.setValue(objCopy$default);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

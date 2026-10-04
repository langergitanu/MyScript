package com.myscript.nebo.editing.p028ui.compose;

import androidx.compose.runtime.MutableState;
import com.myscript.nebo.editing.ChildPage;
import com.myscript.nebo.editing.ChildPageAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ChildPagesPane.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$ChildPageItem$13$1", m1609f = "ChildPagesPane.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class ChildPagesPaneKt$ChildPageItem$13$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChildPage $childPage;
    final /* synthetic */ MutableState<List<ChildPageAction>> $childPageActions$delegate;
    final /* synthetic */ MutableState<Boolean> $moreMenuOpened$delegate;
    final /* synthetic */ Function1<ChildPage, List<ChildPageAction>> $onChildPageActionsRequest;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ChildPagesPaneKt$ChildPageItem$13$1(Function1<? super ChildPage, ? extends List<? extends ChildPageAction>> function1, ChildPage childPage, MutableState<Boolean> mutableState, MutableState<List<ChildPageAction>> mutableState2, Continuation<? super ChildPagesPaneKt$ChildPageItem$13$1> continuation) {
        super(2, continuation);
        this.$onChildPageActionsRequest = function1;
        this.$childPage = childPage;
        this.$moreMenuOpened$delegate = mutableState;
        this.$childPageActions$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChildPagesPaneKt$ChildPageItem$13$1(this.$onChildPageActionsRequest, this.$childPage, this.$moreMenuOpened$delegate, this.$childPageActions$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChildPagesPaneKt$ChildPageItem$13$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<ChildPageAction> listEmptyList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MutableState<List<ChildPageAction>> mutableState = this.$childPageActions$delegate;
        if (ChildPagesPaneKt.ChildPageItem$lambda$16(this.$moreMenuOpened$delegate)) {
            listEmptyList = this.$onChildPageActionsRequest.invoke(this.$childPage);
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        mutableState.setValue(listEmptyList);
        return Unit.INSTANCE;
    }
}

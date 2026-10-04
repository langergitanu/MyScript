package com.myscript.nebo.grid.p029ui.compose;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotStateKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: notesListView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.grid.ui.compose.NotesListViewKt$NotesListView$2$1", m1609f = "notesListView.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_3_2}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {137}, m1615s = {}, m1616v = 2)
final class NotesListViewKt$NotesListView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $itemHeight$delegate;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function2<Integer, Integer, Unit> $onScroll;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NotesListViewKt$NotesListView$2$1(LazyListState lazyListState, Function2<? super Integer, ? super Integer, Unit> function2, MutableIntState mutableIntState, Continuation<? super NotesListViewKt$NotesListView$2$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
        this.$onScroll = function2;
        this.$itemHeight$delegate = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotesListViewKt$NotesListView$2$1(this.$lazyListState, this.$onScroll, this.$itemHeight$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotesListViewKt$NotesListView$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final LazyListState lazyListState = this.$lazyListState;
            Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$NotesListView$2$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NotesListViewKt$NotesListView$2$1.invokeSuspend$lambda$0(lazyListState);
                }
            });
            final LazyListState lazyListState2 = this.$lazyListState;
            final Function2<Integer, Integer, Unit> function2 = this.$onScroll;
            final MutableIntState mutableIntState = this.$itemHeight$delegate;
            this.label = 1;
            if (flowSnapshotFlow.collect(new FlowCollector() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$NotesListView$2$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Pair<Integer, Integer>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Pair<Integer, Integer> pair, Continuation<? super Unit> continuation) {
                    int iIntValue = pair.component1().intValue();
                    function2.invoke(Boxing.boxInt((iIntValue * NotesListViewKt.NotesListView$lambda$1(mutableIntState)) + pair.component2().intValue()), Boxing.boxInt(lazyListState2.getLayoutInfo().getTotalItemsCount() * NotesListViewKt.NotesListView$lambda$1(mutableIntState)));
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair invokeSuspend$lambda$0(LazyListState lazyListState) {
        return TuplesKt.m1606to(Integer.valueOf(lazyListState.getFirstVisibleItemIndex()), Integer.valueOf(lazyListState.getFirstVisibleItemScrollOffset()));
    }
}

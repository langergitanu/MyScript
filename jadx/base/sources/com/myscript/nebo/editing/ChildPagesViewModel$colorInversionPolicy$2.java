package com.myscript.nebo.editing;

import androidx.lifecycle.MutableLiveData;
import com.myscript.nebo.dms.core.model.SelectionState;
import com.myscript.snt.dms.IPaginatedContainer;
import com.myscript.snt.dms.NotebookManager;
import com.myscript.snt.dms.PDFManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ChildPagesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$colorInversionPolicy$2", m1609f = "ChildPagesViewModel.kt", m1610i = {0}, m1611l = {294}, m1612m = "invokeSuspend", m1613n = {"currentSelectionStates"}, m1614nl = {298}, m1615s = {"L$0"}, m1616v = 2)
final class ChildPagesViewModel$colorInversionPolicy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ChildPagesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChildPagesViewModel$colorInversionPolicy$2(ChildPagesViewModel childPagesViewModel, Continuation<? super ChildPagesViewModel$colorInversionPolicy$2> continuation) {
        super(2, continuation);
        this.this$0 = childPagesViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChildPagesViewModel$colorInversionPolicy$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChildPagesViewModel$colorInversionPolicy$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LinkedHashMap linkedHashMapEmptyMap;
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ImmutableList immutableList = (ImmutableList) this.this$0._childPages.getValue();
            if (immutableList == null) {
                linkedHashMapEmptyMap = MapsKt.emptyMap();
            } else {
                ImmutableList<ChildPage> immutableList2 = immutableList;
                linkedHashMapEmptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(immutableList2, 10)), 16));
                for (ChildPage childPage : immutableList2) {
                    Pair pairM1606to = TuplesKt.m1606to(childPage.getId(), childPage.getSelectionState());
                    linkedHashMapEmptyMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
                }
            }
            MutableLiveData mutableLiveData2 = this.this$0._childPages;
            this.L$0 = SpillingKt.nullOutSpilledVariable(linkedHashMapEmptyMap);
            this.L$1 = mutableLiveData2;
            this.label = 1;
            Object objWithContext = BuildersKt.withContext(this.this$0.workDispatcher, new C63211(this.this$0, linkedHashMapEmptyMap, null), this);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = mutableLiveData2;
            obj = objWithContext;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData.setValue(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$colorInversionPolicy$2$1 */
    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/myscript/nebo/editing/ChildPage;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$colorInversionPolicy$2$1", m1609f = "ChildPagesViewModel.kt", m1610i = {0}, m1611l = {296}, m1612m = "invokeSuspend", m1613n = {"selectedPage"}, m1614nl = {-1}, m1615s = {"L$0"}, m1616v = 2)
    static final class C63211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImmutableList<? extends ChildPage>>, Object> {
        final /* synthetic */ Map<String, SelectionState> $currentSelectionStates;
        Object L$0;
        int label;
        final /* synthetic */ ChildPagesViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C63211(ChildPagesViewModel childPagesViewModel, Map<String, ? extends SelectionState> map, Continuation<? super C63211> continuation) {
            super(2, continuation);
            this.this$0 = childPagesViewModel;
            this.$currentSelectionStates = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C63211(this.this$0, this.$currentSelectionStates, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ImmutableList<? extends ChildPage>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super ImmutableList<ChildPage>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ImmutableList<ChildPage>> continuation) {
            return ((C63211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AutoCloseable autoCloseableNewRef;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IPaginatedContainer paginatedContainer = this.this$0.getPaginatedContainer();
                String str = null;
                if (paginatedContainer != null) {
                    if (paginatedContainer instanceof NotebookManager) {
                        autoCloseableNewRef = NotebookManager.newRef((NotebookManager) paginatedContainer);
                    } else {
                        if (!(paginatedContainer instanceof PDFManager)) {
                            throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                        }
                        autoCloseableNewRef = PDFManager.newRef((PDFManager) paginatedContainer);
                    }
                    if (autoCloseableNewRef != null) {
                        AutoCloseable autoCloseable = autoCloseableNewRef;
                        try {
                            String strSelectedPage = ((IPaginatedContainer) autoCloseable).selectedPage();
                            AutoCloseableKt.closeFinally(autoCloseable, null);
                            str = strSelectedPage;
                        } finally {
                        }
                    }
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                this.label = 1;
                obj = this.this$0.computeChildPages(str, this.$currentSelectionStates, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ExtensionsKt.toImmutableList((Iterable) obj);
        }
    }
}

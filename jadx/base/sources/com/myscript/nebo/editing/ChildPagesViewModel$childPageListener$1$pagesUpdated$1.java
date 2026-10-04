package com.myscript.nebo.editing;

import com.myscript.snt.dms.IPaginatedContainer;
import com.myscript.snt.dms.NotebookManager;
import com.myscript.snt.dms.PDFManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ChildPagesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$childPageListener$1$pagesUpdated$1", m1609f = "ChildPagesViewModel.kt", m1610i = {0}, m1611l = {362}, m1612m = "invokeSuspend", m1613n = {"selectedPageId"}, m1614nl = {370}, m1615s = {"L$0"}, m1616v = 2)
final class ChildPagesViewModel$childPageListener$1$pagesUpdated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChildPagesNavigationState $previousState;
    Object L$0;
    int label;
    final /* synthetic */ ChildPagesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChildPagesViewModel$childPageListener$1$pagesUpdated$1(ChildPagesViewModel childPagesViewModel, ChildPagesNavigationState childPagesNavigationState, Continuation<? super ChildPagesViewModel$childPageListener$1$pagesUpdated$1> continuation) {
        super(2, continuation);
        this.this$0 = childPagesViewModel;
        this.$previousState = childPagesNavigationState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChildPagesViewModel$childPageListener$1$pagesUpdated$1(this.this$0, this.$previousState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChildPagesViewModel$childPageListener$1$pagesUpdated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x012b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String strSelectedPage;
        AutoCloseable autoCloseableNewRef;
        AutoCloseable autoCloseable;
        AutoCloseable autoCloseableNewRef2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        ChildPagesNavigationState childPagesNavigationState = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IPaginatedContainer paginatedContainer = this.this$0.getPaginatedContainer();
            if (paginatedContainer == null) {
                strSelectedPage = null;
                this.L$0 = SpillingKt.nullOutSpilledVariable(strSelectedPage);
                this.label = 1;
                obj = BuildersKt.withContext(this.this$0.workDispatcher, new C6319x2562d676(this.this$0, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (paginatedContainer instanceof NotebookManager) {
                    autoCloseableNewRef = NotebookManager.newRef((NotebookManager) paginatedContainer);
                } else {
                    if (!(paginatedContainer instanceof PDFManager)) {
                        throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                    }
                    autoCloseableNewRef = PDFManager.newRef((PDFManager) paginatedContainer);
                }
                if (autoCloseableNewRef != null) {
                    autoCloseable = autoCloseableNewRef;
                    try {
                        strSelectedPage = ((IPaginatedContainer) autoCloseable).selectedPage();
                        AutoCloseableKt.closeFinally(autoCloseable, null);
                    } finally {
                    }
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(strSelectedPage);
                this.label = 1;
                obj = BuildersKt.withContext(this.this$0.workDispatcher, new C6319x2562d676(this.this$0, null), this);
                if (obj == coroutine_suspended) {
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List<ChildPage> list = (List) obj;
        if (ChildPagesViewModel.INSTANCE.confirmStructuralChange((List) this.this$0._childPages.getValue(), list)) {
            this.this$0._childPages.setValue(ExtensionsKt.toImmutableList(list));
        }
        if (this.$previousState != null) {
            IPaginatedContainer paginatedContainer2 = this.this$0.getPaginatedContainer();
            if (paginatedContainer2 != null) {
                ChildPagesNavigationState childPagesNavigationState2 = this.$previousState;
                if (paginatedContainer2 instanceof NotebookManager) {
                    autoCloseableNewRef2 = NotebookManager.newRef((NotebookManager) paginatedContainer2);
                } else {
                    if (!(paginatedContainer2 instanceof PDFManager)) {
                        throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                    }
                    autoCloseableNewRef2 = PDFManager.newRef((PDFManager) paginatedContainer2);
                }
                if (autoCloseableNewRef2 != null) {
                    autoCloseable = autoCloseableNewRef2;
                    try {
                        IPaginatedContainer iPaginatedContainer = (IPaginatedContainer) autoCloseable;
                        String strSelectedPage2 = iPaginatedContainer.selectedPage();
                        List<com.myscript.snt.dms.PageProperties> listPages = iPaginatedContainer.pages();
                        Intrinsics.checkNotNullExpressionValue(listPages, "pages(...)");
                        Iterator<com.myscript.snt.dms.PageProperties> it = listPages.iterator();
                        int i2 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = -1;
                                break;
                            }
                            if (Intrinsics.areEqual(it.next().getPageId(), strSelectedPage2)) {
                                break;
                            }
                            i2++;
                        }
                        ChildPagesNavigationState childPagesNavigationStateCopy$default = ChildPagesNavigationState.copy$default(childPagesNavigationState2, strSelectedPage2, RangesKt.coerceAtLeast(i2 + 1, 1), false, (int) iPaginatedContainer.pageCount(), false, true, 20, null);
                        AutoCloseableKt.closeFinally(autoCloseable, null);
                        childPagesNavigationState = childPagesNavigationStateCopy$default;
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                if (childPagesNavigationState == null) {
                    childPagesNavigationState = new ChildPagesNavigationState(null, 0, false, 0, false, false, 63, null);
                }
                if (!Intrinsics.areEqual(childPagesNavigationState, this.$previousState)) {
                    this.this$0._childPagesNavigationState.setValue(childPagesNavigationState);
                }
            }
        }
        return Unit.INSTANCE;
    }
}

package com.myscript.nebo.editing;

import com.pdftron.pdf.pdfa.PDFACompliance;
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
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ChildPagesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$childPageListener$1$pageSelected$1", m1609f = "ChildPagesViewModel.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA3_3_1}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {338}, m1615s = {}, m1616v = 2)
final class ChildPagesViewModel$childPageListener$1$pageSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $pageCount;
    final /* synthetic */ String $selectedPageId;
    final /* synthetic */ long $selectedPageNumber;
    final /* synthetic */ boolean $userAction;
    int label;
    final /* synthetic */ ChildPagesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChildPagesViewModel$childPageListener$1$pageSelected$1(ChildPagesViewModel childPagesViewModel, long j, long j2, String str, boolean z, Continuation<? super ChildPagesViewModel$childPageListener$1$pageSelected$1> continuation) {
        super(2, continuation);
        this.this$0 = childPagesViewModel;
        this.$selectedPageNumber = j;
        this.$pageCount = j2;
        this.$selectedPageId = str;
        this.$userAction = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChildPagesViewModel$childPageListener$1$pageSelected$1(this.this$0, this.$selectedPageNumber, this.$pageCount, this.$selectedPageId, this.$userAction, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChildPagesViewModel$childPageListener$1$pageSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(this.this$0.workDispatcher, new C6318x63ab7163(this.$selectedPageId, this.this$0, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        if (list != null) {
            this.this$0._childPages.setValue(ExtensionsKt.toImmutableList(list));
        }
        ChildPagesNavigationState childPagesNavigationState = (ChildPagesNavigationState) this.this$0._childPagesNavigationState.getValue();
        if (childPagesNavigationState == null) {
            return Unit.INSTANCE;
        }
        boolean zIsChildPagesCompatible = this.this$0.isChildPagesCompatible();
        ChildPagesNavigationState childPagesNavigationStateCopy = childPagesNavigationState.copy(this.$selectedPageId, (int) this.$selectedPageNumber, this.$userAction, (int) this.$pageCount, zIsChildPagesCompatible, false);
        if (!Intrinsics.areEqual(childPagesNavigationStateCopy, childPagesNavigationState)) {
            this.this$0._childPagesNavigationState.setValue(childPagesNavigationStateCopy);
        }
        return Unit.INSTANCE;
    }
}

package com.myscript.nebo.dms.p026ui.compose;

import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: folderActionPane.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$FolderList$1$1", m1609f = "folderActionPane.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class FolderActionPaneKt$FolderList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<C1486Dp> $currentFolderSpacing$delegate;
    final /* synthetic */ float $folderSpacing;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FolderActionPaneKt$FolderList$1$1(float f, MutableState<C1486Dp> mutableState, Continuation<? super FolderActionPaneKt$FolderList$1$1> continuation) {
        super(2, continuation);
        this.$folderSpacing = f;
        this.$currentFolderSpacing$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FolderActionPaneKt$FolderList$1$1(this.$folderSpacing, this.$currentFolderSpacing$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FolderActionPaneKt$FolderList$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FolderActionPaneKt.FolderList_3J_VO9M$lambda$2(this.$currentFolderSpacing$delegate, this.$folderSpacing);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

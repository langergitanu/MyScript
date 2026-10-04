package com.myscript.nebo.dms.core;

import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.snt.dms.DMSSyncState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LibraryViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryViewModel$onSyncUpdate$1$syncStateChanged$1", m1609f = "LibraryViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class LibraryViewModel$onSyncUpdate$1$syncStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LibraryRepository.SyncFailureReason $failureReason;
    final /* synthetic */ int $impactedFolderCount;
    final /* synthetic */ DMSSyncState $state;
    int label;
    final /* synthetic */ LibraryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibraryViewModel$onSyncUpdate$1$syncStateChanged$1(LibraryViewModel libraryViewModel, DMSSyncState dMSSyncState, int i, LibraryRepository.SyncFailureReason syncFailureReason, Continuation<? super LibraryViewModel$onSyncUpdate$1$syncStateChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = libraryViewModel;
        this.$state = dMSSyncState;
        this.$impactedFolderCount = i;
        this.$failureReason = syncFailureReason;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LibraryViewModel$onSyncUpdate$1$syncStateChanged$1(this.this$0, this.$state, this.$impactedFolderCount, this.$failureReason, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LibraryViewModel$onSyncUpdate$1$syncStateChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.syncState = this.$state;
        this.this$0.syncStateNotebookCount = this.$impactedFolderCount;
        this.this$0.syncFailureReason = this.$failureReason;
        this.this$0.updateSyncToolbarUIState();
        return Unit.INSTANCE;
    }
}

package com.myscript.nebo.dms.core;

import androidx.lifecycle.MutableLiveData;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.LibraryViewModel;
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
@DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryViewModel$collapseToolbar$2", m1609f = "LibraryViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class LibraryViewModel$collapseToolbar$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LibraryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibraryViewModel$collapseToolbar$2(LibraryViewModel libraryViewModel, Continuation<? super LibraryViewModel$collapseToolbar$2> continuation) {
        super(2, continuation);
        this.this$0 = libraryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LibraryViewModel$collapseToolbar$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LibraryViewModel$collapseToolbar$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            NeboNetworkState value = this.this$0.networkStateRepository.getNeboNetworkState().getValue();
            if (this.this$0.repository.getHasCloudProvider() && (value instanceof NeboNetworkState.Connected) && ((NeboNetworkState.Connected) value).isEnabled()) {
                MutableLiveData mutableLiveData = this.this$0._syncToolbarUIState;
                LibraryViewModel.SyncToolbarUIState syncToolbarUIState = (LibraryViewModel.SyncToolbarUIState) this.this$0._syncToolbarUIState.getValue();
                mutableLiveData.setValue(syncToolbarUIState != null ? LibraryViewModel.SyncToolbarUIState.copy$default(syncToolbarUIState, false, false, false, 0L, C6208R.string.sync_header_activated, 0, C6208R.string.sync_details_duration, null, 0, 0, 0, null, null, false, null, false, 65455, null) : null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

package com.myscript.nebo.inspector;

import androidx.lifecycle.MutableLiveData;
import com.myscript.nebo.inspector.State;
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

/* JADX INFO: compiled from: NeboFilesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboFilesViewModel$onLibraryUpdate$1$onCollectionsLoaded$1", m1609f = "NeboFilesViewModel.kt", m1610i = {}, m1611l = {86, 87, 88}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {87, 88, 85}, m1615s = {}, m1616v = 2)
final class NeboFilesViewModel$onLibraryUpdate$1$onCollectionsLoaded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: $s */
    final /* synthetic */ State f1372$s;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ NeboFilesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboFilesViewModel$onLibraryUpdate$1$onCollectionsLoaded$1(NeboFilesViewModel neboFilesViewModel, State state, Continuation<? super NeboFilesViewModel$onLibraryUpdate$1$onCollectionsLoaded$1> continuation) {
        super(2, continuation);
        this.this$0 = neboFilesViewModel;
        this.f1372$s = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NeboFilesViewModel$onLibraryUpdate$1$onCollectionsLoaded$1(this.this$0, this.f1372$s, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NeboFilesViewModel$onLibraryUpdate$1$onCollectionsLoaded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        State.Loaded loaded;
        State.Loading loading;
        State.Empty empty;
        State stateCopy;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._state;
            State state = this.f1372$s;
            if (state instanceof State.Empty) {
                State.Empty empty2 = (State.Empty) state;
                this.L$0 = mutableLiveData;
                this.L$1 = empty2;
                this.label = 1;
                Object objComputeStats = this.this$0.computeStats(this);
                if (objComputeStats != coroutine_suspended) {
                    empty = empty2;
                    obj = objComputeStats;
                    stateCopy = empty.copy((Stats) obj);
                }
            } else if (state instanceof State.Loading) {
                State.Loading loading2 = (State.Loading) state;
                this.L$0 = mutableLiveData;
                this.L$1 = loading2;
                this.label = 2;
                Object objComputeStats2 = this.this$0.computeStats(this);
                if (objComputeStats2 != coroutine_suspended) {
                    loading = loading2;
                    obj = objComputeStats2;
                    stateCopy = loading.copy((Stats) obj);
                }
            } else if (state instanceof State.Loaded) {
                State.Loaded loaded2 = (State.Loaded) state;
                this.L$0 = mutableLiveData;
                this.L$1 = loaded2;
                this.label = 3;
                Object objComputeStats3 = this.this$0.computeStats(this);
                if (objComputeStats3 != coroutine_suspended) {
                    loaded = loaded2;
                    obj = objComputeStats3;
                    stateCopy = State.Loaded.copy$default(loaded, null, (Stats) obj, 1, null);
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            empty = (State.Empty) this.L$1;
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
            stateCopy = empty.copy((Stats) obj);
        } else if (i == 2) {
            loading = (State.Loading) this.L$1;
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
            stateCopy = loading.copy((Stats) obj);
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            loaded = (State.Loaded) this.L$1;
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
            stateCopy = State.Loaded.copy$default(loaded, null, (Stats) obj, 1, null);
        }
        mutableLiveData.setValue(stateCopy);
        return Unit.INSTANCE;
    }
}

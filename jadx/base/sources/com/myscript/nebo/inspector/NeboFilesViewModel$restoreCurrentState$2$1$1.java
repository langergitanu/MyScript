package com.myscript.nebo.inspector;

import android.util.Log;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.myscript.android.utils.ColorExt;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NeboFilesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.inspector.NeboFilesViewModel$restoreCurrentState$2$1$1", m1609f = "NeboFilesViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class NeboFilesViewModel$restoreCurrentState$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NeboFile $lostFile;
    final /* synthetic */ Function1<NeboFile, String> $outputNotebookNameFn;
    final /* synthetic */ CollectionKey $restorationCollectionKey;
    final /* synthetic */ AtomicInteger $restoredCount;
    final /* synthetic */ State $state;
    int label;
    final /* synthetic */ NeboFilesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NeboFilesViewModel$restoreCurrentState$2$1$1(Function1<? super NeboFile, String> function1, NeboFile neboFile, NeboFilesViewModel neboFilesViewModel, CollectionKey collectionKey, AtomicInteger atomicInteger, State state, Continuation<? super NeboFilesViewModel$restoreCurrentState$2$1$1> continuation) {
        super(2, continuation);
        this.$outputNotebookNameFn = function1;
        this.$lostFile = neboFile;
        this.this$0 = neboFilesViewModel;
        this.$restorationCollectionKey = collectionKey;
        this.$restoredCount = atomicInteger;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NeboFilesViewModel$restoreCurrentState$2$1$1(this.$outputNotebookNameFn, this.$lostFile, this.this$0, this.$restorationCollectionKey, this.$restoredCount, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NeboFilesViewModel$restoreCurrentState$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        NotebookKey notebookKeyCreateFolder = this.this$0.repository.createFolder(this.$restorationCollectionKey, this.$outputNotebookNameFn.invoke(this.$lostFile), ColorExt.getOpaque(10563835));
        if (notebookKeyCreateFolder != null) {
            this.this$0.repository.importNeboFile(this.$lostFile.getFile(), notebookKeyCreateFolder);
            int iIncrementAndGet = this.$restoredCount.incrementAndGet();
            Log.d("NeboFilesViewModel", "restored " + this.$lostFile.getFile() + " (" + iIncrementAndGet + DomExceptionUtils.SEPARATOR + this.$state.getFiles().size() + ")");
        } else {
            Log.e("NeboFilesViewModel", "unable to restore " + this.$lostFile.getFile());
        }
        return Unit.INSTANCE;
    }
}

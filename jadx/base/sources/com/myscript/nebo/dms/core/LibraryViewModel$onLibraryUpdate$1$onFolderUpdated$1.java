package com.myscript.nebo.dms.core;

import androidx.lifecycle.MutableLiveData;
import com.myscript.nebo.dms.core.LibraryViewModel;
import com.myscript.snt.core.NotebookKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LibraryViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryViewModel$onLibraryUpdate$1$onFolderUpdated$1", m1609f = "LibraryViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class LibraryViewModel$onLibraryUpdate$1$onFolderUpdated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NotebookKey $notebookKey;
    int label;
    final /* synthetic */ LibraryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibraryViewModel$onLibraryUpdate$1$onFolderUpdated$1(LibraryViewModel libraryViewModel, NotebookKey notebookKey, Continuation<? super LibraryViewModel$onLibraryUpdate$1$onFolderUpdated$1> continuation) {
        super(2, continuation);
        this.this$0 = libraryViewModel;
        this.$notebookKey = notebookKey;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LibraryViewModel$onLibraryUpdate$1$onFolderUpdated$1(this.this$0, this.$notebookKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LibraryViewModel$onLibraryUpdate$1$onFolderUpdated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List listEmptyList = (List) this.this$0._notebookSyncUIStates.getValue();
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List list = listEmptyList;
            NotebookKey notebookKey = this.$notebookKey;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics.areEqual(((LibraryViewModel.NotebookSyncUIState) it.next()).getNotebookKey(), notebookKey)) {
                        MutableLiveData mutableLiveData = this.this$0._notebookSyncUIStates;
                        NotebookKey notebookKey2 = this.$notebookKey;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : list) {
                            if (!Intrinsics.areEqual(((LibraryViewModel.NotebookSyncUIState) obj2).getNotebookKey(), notebookKey2)) {
                                arrayList.add(obj2);
                            }
                        }
                        mutableLiveData.setValue(arrayList);
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

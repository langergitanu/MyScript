package com.myscript.nebo.dms.core;

import com.myscript.nebo.dms.core.LibraryViewModel;
import com.myscript.snt.core.NotebookKey;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LibraryViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.dms.core.LibraryViewModel$onLibraryUpdate$1$onCollectionsLoaded$1", m1609f = "LibraryViewModel.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA3_3_2}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {335}, m1615s = {}, m1616v = 2)
final class LibraryViewModel$onLibraryUpdate$1$onCollectionsLoaded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LibraryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibraryViewModel$onLibraryUpdate$1$onCollectionsLoaded$1(LibraryViewModel libraryViewModel, Continuation<? super LibraryViewModel$onLibraryUpdate$1$onCollectionsLoaded$1> continuation) {
        super(2, continuation);
        this.this$0 = libraryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LibraryViewModel$onLibraryUpdate$1$onCollectionsLoaded$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LibraryViewModel$onLibraryUpdate$1$onCollectionsLoaded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(this.this$0.workDispatcher, new C6240xe67ed35e(this.this$0, null), this);
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
        if (this.this$0.isSearching()) {
            this.this$0.filter(list);
        } else {
            this.this$0._state.setValue(new LibraryViewModel.State.Loaded(list, null, 2, null));
        }
        NotebookKey lastOpenedFolderKey = this.this$0.repository.getLastOpenedFolderKey();
        if (lastOpenedFolderKey != null) {
            if (!Intrinsics.areEqual(this.this$0._openNotebookKey.getValue(), lastOpenedFolderKey)) {
                this.this$0.openFolder(lastOpenedFolderKey, false);
            }
        } else {
            this.this$0.closeFolder();
        }
        return Unit.INSTANCE;
    }
}

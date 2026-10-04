package com.myscript.nebo.editing;

import android.content.DialogInterface;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.dms.C6208R;
import com.myscript.snt.core.PageKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: EditingActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.EditingActivity$syncListener$1$conflictedPageCopies$2", m1609f = "EditingActivity.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class EditingActivity$syncListener$1$conflictedPageCopies$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PageKey> $duplicatedPageKeys;
    int label;
    final /* synthetic */ EditingActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    EditingActivity$syncListener$1$conflictedPageCopies$2(EditingActivity editingActivity, List<? extends PageKey> list, Continuation<? super EditingActivity$syncListener$1$conflictedPageCopies$2> continuation) {
        super(2, continuation);
        this.this$0 = editingActivity;
        this.$duplicatedPageKeys = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditingActivity$syncListener$1$conflictedPageCopies$2(this.this$0, this.$duplicatedPageKeys, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EditingActivity$syncListener$1$conflictedPageCopies$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        new MaterialAlertDialogBuilder(this.this$0).setTitle(C6208R.string.sync_page_conflict_title).setMessage((CharSequence) this.this$0.getResources().getQuantityString(C6208R.plurals.sync_page_conflict_message, this.$duplicatedPageKeys.size(), Boxing.boxInt(this.$duplicatedPageKeys.size()))).setPositiveButton(C6183R.string.dialog_ok, (DialogInterface.OnClickListener) null).show();
        return Unit.INSTANCE;
    }
}

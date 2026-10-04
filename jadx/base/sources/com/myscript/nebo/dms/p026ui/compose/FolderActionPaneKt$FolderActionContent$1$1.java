package com.myscript.nebo.dms.p026ui.compose;

import androidx.compose.p004ui.focus.FocusRequester;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.TextRangeKt;
import androidx.compose.p004ui.text.input.TextFieldValue;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: folderActionPane.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$FolderActionContent$1$1", m1609f = "folderActionPane.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class FolderActionPaneKt$FolderActionContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ String $folderName;
    final /* synthetic */ MutableState<TextFieldValue> $textValue;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FolderActionPaneKt$FolderActionContent$1$1(FocusRequester focusRequester, MutableState<TextFieldValue> mutableState, String str, Continuation<? super FolderActionPaneKt$FolderActionContent$1$1> continuation) {
        super(2, continuation);
        this.$focusRequester = focusRequester;
        this.$textValue = mutableState;
        this.$folderName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FolderActionPaneKt$FolderActionContent$1$1(this.$focusRequester, this.$textValue, this.$folderName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FolderActionPaneKt$FolderActionContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        FocusRequester.m7808requestFocus3ESFkO8$default(this.$focusRequester, 0, 1, null);
        MutableState<TextFieldValue> mutableState = this.$textValue;
        String str = this.$folderName;
        mutableState.setValue(new TextFieldValue(str, TextRangeKt.TextRange(str.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
        return Unit.INSTANCE;
    }
}

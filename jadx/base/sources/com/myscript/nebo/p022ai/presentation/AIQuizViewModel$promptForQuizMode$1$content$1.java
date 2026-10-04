package com.myscript.nebo.p022ai.presentation;

import com.myscript.nebo.p022ai.presentation.compose.AiTextSelection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AIQuizViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.ai.presentation.AIQuizViewModel$promptForQuizMode$1$content$1", m1609f = "AIQuizViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class AIQuizViewModel$promptForQuizMode$1$content$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ AIQuizViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AIQuizViewModel$promptForQuizMode$1$content$1(AIQuizViewModel aIQuizViewModel, Continuation<? super AIQuizViewModel$promptForQuizMode$1$content$1> continuation) {
        super(2, continuation);
        this.this$0 = aIQuizViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AIQuizViewModel$promptForQuizMode$1$content$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((AIQuizViewModel$promptForQuizMode$1$content$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AiTextSelection aiTextSelection;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Function0 function0 = this.this$0.textRetriever;
            String selectedText = (function0 == null || (aiTextSelection = (AiTextSelection) function0.invoke()) == null) ? null : aiTextSelection.getSelectedText();
            if (selectedText == null) {
                selectedText = "";
            }
            return StringsKt.trim((CharSequence) selectedText).toString();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

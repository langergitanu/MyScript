package com.myscript.nebo.sso.api;

import com.myscript.nebo.sso.api.entity.ShareNotesPayload;
import com.pdftron.pdf.pdfa.PDFACompliance;
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

/* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOManager$saveShareMyNotesSetting$1$isSharedWithMyScriptUpdated$1 */
/* JADX INFO: compiled from: SSOManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager$saveShareMyNotesSetting$1$isSharedWithMyScriptUpdated$1", m1609f = "SSOManager.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA2_9_1}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {292}, m1615s = {}, m1616v = 2)
final class C6843xeaec52fc extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ShareNotesPayload $body;
    int label;
    final /* synthetic */ SSOManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C6843xeaec52fc(SSOManager sSOManager, ShareNotesPayload shareNotesPayload, Continuation<? super C6843xeaec52fc> continuation) {
        super(2, continuation);
        this.this$0 = sSOManager;
        this.$body = shareNotesPayload;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C6843xeaec52fc(this.this$0, this.$body, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((C6843xeaec52fc) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.ssoApi.saveShareMyNotesSetting(this.$body, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        boolean zIsSharedWithMyScript = ((ShareNotesPayload) obj).isSharedWithMyScript();
        this.this$0.userData.setNotesSharingActivated(zIsSharedWithMyScript);
        return Boxing.boxBoolean(zIsSharedWithMyScript);
    }
}

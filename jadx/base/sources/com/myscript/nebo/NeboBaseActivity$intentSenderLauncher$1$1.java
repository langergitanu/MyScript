package com.myscript.nebo;

import androidx.window.core.layout.WindowSizeClass;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NeboBaseActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$intentSenderLauncher$1$1", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA8_4_1}, m1615s = {}, m1616v = 2)
final class NeboBaseActivity$intentSenderLauncher$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthorizationResult $authorizationResult;
    final /* synthetic */ CancellableContinuation<Result<Unit>> $continuation;
    int label;
    final /* synthetic */ NeboBaseActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NeboBaseActivity$intentSenderLauncher$1$1(NeboBaseActivity neboBaseActivity, AuthorizationResult authorizationResult, CancellableContinuation<? super Result<Unit>> cancellableContinuation, Continuation<? super NeboBaseActivity$intentSenderLauncher$1$1> continuation) {
        super(2, continuation);
        this.this$0 = neboBaseActivity;
        this.$authorizationResult = authorizationResult;
        this.$continuation = cancellableContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NeboBaseActivity$intentSenderLauncher$1$1(this.this$0, this.$authorizationResult, this.$continuation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NeboBaseActivity$intentSenderLauncher$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM12800handleAuthorizationResultgIAlus;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            objM12800handleAuthorizationResultgIAlus = this.this$0.m12800handleAuthorizationResultgIAlus(this.$authorizationResult, this);
            if (objM12800handleAuthorizationResultgIAlus == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objM12800handleAuthorizationResultgIAlus = ((Result) obj).getValue();
        }
        CancellableContinuation<Result<Unit>> cancellableContinuation = this.$continuation;
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m14499constructorimpl(Result.m14498boximpl(objM12800handleAuthorizationResultgIAlus)));
        }
        return Unit.INSTANCE;
    }
}

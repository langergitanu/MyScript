package com.myscript.nebo;

import androidx.credentials.exceptions.GetCredentialException;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: NeboBaseActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity", m1609f = "NeboBaseActivity.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, m1611l = {PDFACompliance.e_PDFA7_8_2, PDFACompliance.e_PDFA7_8_6, 793}, m1612m = "driveManualSignIn-IoAF18A", m1613n = {"credentialManager", "request", "googleIdOption", "$i$a$-runCatching-NeboBaseActivity$driveManualSignIn$2", "credentialManager", "request", "googleIdOption", "result", "$i$a$-runCatching-NeboBaseActivity$driveManualSignIn$2", "credentialManager", "request", "googleIdOption", "e", "$i$a$-runCatching-NeboBaseActivity$driveManualSignIn$2"}, m1614nl = {PDFACompliance.e_PDFA7_8_6, PDFACompliance.e_PDFA7_8_7, 794}, m1615s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m1616v = 2)
final class NeboBaseActivity$driveManualSignIn$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NeboBaseActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboBaseActivity$driveManualSignIn$1(NeboBaseActivity neboBaseActivity, Continuation<? super NeboBaseActivity$driveManualSignIn$1> continuation) {
        super(continuation);
        this.this$0 = neboBaseActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws GetCredentialException {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM12802driveManualSignInIoAF18A = this.this$0.m12802driveManualSignInIoAF18A(this);
        return objM12802driveManualSignInIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12802driveManualSignInIoAF18A : Result.m14498boximpl(objM12802driveManualSignInIoAF18A);
    }
}

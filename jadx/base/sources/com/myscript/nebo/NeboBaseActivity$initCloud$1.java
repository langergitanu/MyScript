package com.myscript.nebo;

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
@DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity", m1609f = "NeboBaseActivity.kt", m1610i = {0, 0, 0, 1, 1, 1}, m1611l = {PDFACompliance.e_PDFA7_3_7, PDFACompliance.e_PDFA7_3_9}, m1612m = "initCloud-IoAF18A", m1613n = {"preferences", "$i$a$-runCatching-NeboBaseActivity$initCloud$2", "needsAuthCode", "preferences", "$i$a$-runCatching-NeboBaseActivity$initCloud$2", "needsAuthCode"}, m1614nl = {PDFACompliance.e_PDFA7_3_9, 741}, m1615s = {"L$0", "I$0", "Z$0", "L$0", "I$0", "Z$0"}, m1616v = 2)
final class NeboBaseActivity$initCloud$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NeboBaseActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboBaseActivity$initCloud$1(NeboBaseActivity neboBaseActivity, Continuation<? super NeboBaseActivity$initCloud$1> continuation) {
        super(continuation);
        this.this$0 = neboBaseActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM12803initCloudIoAF18A = this.this$0.m12803initCloudIoAF18A(this);
        return objM12803initCloudIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12803initCloudIoAF18A : Result.m14498boximpl(objM12803initCloudIoAF18A);
    }
}

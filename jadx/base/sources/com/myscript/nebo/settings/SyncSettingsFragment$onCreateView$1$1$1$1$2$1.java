package com.myscript.nebo.settings;

import com.myscript.nebo.analytics.firebase.LoginOrigin;
import com.myscript.nebo.sso.api.ISSOManager;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SyncSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "token", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.settings.SyncSettingsFragment$onCreateView$1$1$1$1$2$1", m1609f = "SyncSettingsFragment.kt", m1610i = {0}, m1611l = {PDFACompliance.e_PDFA1_8_3}, m1612m = "invokeSuspend", m1613n = {"token"}, m1614nl = {PDFACompliance.e_PDFA1_8_4}, m1615s = {"L$0"}, m1616v = 2)
final class SyncSettingsFragment$onCreateView$1$1$1$1$2$1 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SyncSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SyncSettingsFragment$onCreateView$1$1$1$1$2$1(SyncSettingsFragment syncSettingsFragment, Continuation<? super SyncSettingsFragment$onCreateView$1$1$1$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = syncSettingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SyncSettingsFragment$onCreateView$1$1$1$1$2$1 syncSettingsFragment$onCreateView$1$1$1$1$2$1 = new SyncSettingsFragment$onCreateView$1$1$1$1$2$1(this.this$0, continuation);
        syncSettingsFragment$onCreateView$1$1$1$1$2$1.L$0 = obj;
        return syncSettingsFragment$onCreateView$1$1$1$1$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Boolean> continuation) {
        return ((SyncSettingsFragment$onCreateView$1$1$1$1$2$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str = (String) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ISSOManager iSSOManager = this.this$0.ssoManager;
            if (iSSOManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
                iSSOManager = null;
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(str);
            this.label = 1;
            obj = iSSOManager.startNativeLoginWithGoogle(str, LoginOrigin.Sync.getValue(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (zBooleanValue) {
            this.this$0.updateCloudSettingsUI();
        }
        return Boxing.boxBoolean(zBooleanValue);
    }
}

package com.myscript.nebo.purchase;

import android.content.SharedPreferences;
import com.myscript.nebo.account.backend.Backend;
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

/* JADX INFO: compiled from: SubscriptionRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionRepository$loginListener$1$onLogout$1", m1609f = "SubscriptionRepository.kt", m1610i = {}, m1611l = {196, 197}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {197, 203}, m1615s = {}, m1616v = 2)
final class SubscriptionRepository$loginListener$1$onLogout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$loginListener$1$onLogout$1(SubscriptionRepository subscriptionRepository, Continuation<? super SubscriptionRepository$loginListener$1$onLogout$1> continuation) {
        super(2, continuation);
        this.this$0 = subscriptionRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubscriptionRepository$loginListener$1$onLogout$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SubscriptionRepository$loginListener$1$onLogout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0080, code lost:
    
        if (r7.resetCachedValues(kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) r1), r6) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.lastConfiguredAppUserId = null;
            this.this$0.alreadyConfiguredWithoutInternet = false;
            this.this$0.alreadyConfiguredWithInternet = false;
            SharedPreferences.Editor editorEdit = this.this$0.sharedPreferences.edit();
            editorEdit.remove("PREF_MAILSERVICES_LINK_RC_DONE_KEY");
            editorEdit.apply();
            this.this$0._isPreConfigured.setValue(Boxing.boxBoolean(false));
            this.label = 1;
            if (this.this$0.backend.resetAppUserId(this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        Backend backend = this.this$0.backend;
        String[] strArr = {"app_id_1", "app_id_2"};
        this.label = 2;
    }
}

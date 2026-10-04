package com.myscript.nebo;

import com.myscript.nebo.cloudsync.CloudManager;
import com.myscript.nebo.common.MainThreadBus;
import com.myscript.nebo.events.OnSSOTokenInvalidEvent;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.nebo.utils.Session;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NeboApplication.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.NeboApplication$Companion$onTokenInvalid$1", m1609f = "NeboApplication.kt", m1610i = {}, m1611l = {1011, 1012}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {1012, 1016}, m1615s = {}, m1616v = 2)
final class NeboApplication$Companion$onTokenInvalid$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CloudManager $cloudManager;
    final /* synthetic */ UserData $userData;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboApplication$Companion$onTokenInvalid$1(UserData userData, CloudManager cloudManager, Continuation<? super NeboApplication$Companion$onTokenInvalid$1> continuation) {
        super(2, continuation);
        this.$userData = userData;
        this.$cloudManager = cloudManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NeboApplication$Companion$onTokenInvalid$1(this.$userData, this.$cloudManager, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NeboApplication$Companion$onTokenInvalid$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.myscript.nebo.NeboApplication$Companion$onTokenInvalid$1.C60471(null), r4) == r0) goto L15;
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
            this.$userData.logout();
            this.label = 1;
            if (this.$cloudManager.disconnect(this) != coroutine_suspended) {
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
        this.label = 2;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboApplication$Companion$onTokenInvalid$1$1 */
    /* JADX INFO: compiled from: NeboApplication.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboApplication$Companion$onTokenInvalid$1$1", m1609f = "NeboApplication.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C60471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C60471(Continuation<? super C60471> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C60471(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Session.needToDisplaySSOTokenInvalidated = true;
            MainThreadBus.eventBus.post(new OnSSOTokenInvalidEvent());
            return Unit.INSTANCE;
        }
    }
}

package com.myscript.nebo;

import com.myscript.nebo.dms.core.IAutoSyncTimerManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NeboApplication.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.NeboApplication$onCreate$10$onCloudSyncInitialized$1", m1609f = "NeboApplication.kt", m1610i = {}, m1611l = {584}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {585}, m1615s = {}, m1616v = 2)
final class NeboApplication$onCreate$10$onCloudSyncInitialized$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NeboApplication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboApplication$onCreate$10$onCloudSyncInitialized$1(NeboApplication neboApplication, Continuation<? super NeboApplication$onCreate$10$onCloudSyncInitialized$1> continuation) {
        super(2, continuation);
        this.this$0 = neboApplication;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NeboApplication$onCreate$10$onCloudSyncInitialized$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NeboApplication$onCreate$10$onCloudSyncInitialized$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IAutoSyncTimerManager iAutoSyncTimerManager = this.this$0.autoSyncTimerManager;
            if (iAutoSyncTimerManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("autoSyncTimerManager");
                iAutoSyncTimerManager = null;
            }
            this.label = 1;
            if (iAutoSyncTimerManager.start(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

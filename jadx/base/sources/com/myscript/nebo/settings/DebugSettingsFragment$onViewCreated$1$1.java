package com.myscript.nebo.settings;

import android.content.ComponentCallbacks2;
import com.myscript.nebo.discoverability.DiscoverabilityManager;
import com.myscript.nebo.discoverability.session.SessionManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DebugSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.settings.DebugSettingsFragment$onViewCreated$1$1", m1609f = "DebugSettingsFragment.kt", m1610i = {0, 1}, m1611l = {38, 39}, m1612m = "invokeSuspend", m1613n = {"discoverabilityManagerProvider", "discoverabilityManagerProvider"}, m1614nl = {39, 42}, m1615s = {"L$0", "L$0"}, m1616v = 2)
final class DebugSettingsFragment$onViewCreated$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DebugSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DebugSettingsFragment$onViewCreated$1$1(DebugSettingsFragment debugSettingsFragment, Continuation<? super DebugSettingsFragment$onViewCreated$1$1> continuation) {
        super(2, continuation);
        this.this$0 = debugSettingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugSettingsFragment$onViewCreated$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugSettingsFragment$onViewCreated$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        if (r7.clearDataStore(r6) == r0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DiscoverabilityManager.Provider provider;
        DiscoverabilityManager discoverabilityManagerProvideGridDiscoverabilityManager;
        SessionManager.Provider provider2;
        SessionManager sessionManagerProvideDiscoverySessionManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ComponentCallbacks2 application = this.this$0.requireActivity().getApplication();
            provider = application instanceof DiscoverabilityManager.Provider ? (DiscoverabilityManager.Provider) application : null;
            if (provider != null && (discoverabilityManagerProvideGridDiscoverabilityManager = provider.provideGridDiscoverabilityManager()) != null) {
                this.L$0 = provider;
                this.label = 1;
                if (discoverabilityManagerProvideGridDiscoverabilityManager.clearDataStore(this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ComponentCallbacks2 application2 = this.this$0.requireActivity().getApplication();
                provider2 = application2 instanceof SessionManager.Provider ? (SessionManager.Provider) application2 : null;
                if (provider2 != null && (sessionManagerProvideDiscoverySessionManager = provider2.provideDiscoverySessionManager()) != null) {
                    sessionManagerProvideDiscoverySessionManager.clearSessionCount();
                }
                return Unit.INSTANCE;
            }
            provider = (DiscoverabilityManager.Provider) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (provider != null && (r7 = provider.provideEditingDiscoverabilityManager()) != null) {
            this.L$0 = SpillingKt.nullOutSpilledVariable(provider);
            this.label = 2;
        }
        ComponentCallbacks2 application22 = this.this$0.requireActivity().getApplication();
        if (application22 instanceof SessionManager.Provider) {
        }
        if (provider2 != null) {
            sessionManagerProvideDiscoverySessionManager.clearSessionCount();
        }
        return Unit.INSTANCE;
    }
}

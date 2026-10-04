package androidx.privacysandbox.ads.adservices.adid;

import androidx.core.os.OutcomeReceiverKt;
import androidx.credentials.CredentialManager$$ExternalSyntheticLambda0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: AdIdManagerImplCommon.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u0006H\u0097@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\bH\u0083@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Landroidx/privacysandbox/ads/adservices/adid/AdIdManagerImplCommon;", "Landroidx/privacysandbox/ads/adservices/adid/AdIdManager;", "mAdIdManager", "Landroid/adservices/adid/AdIdManager;", "(Landroid/adservices/adid/AdIdManager;)V", "convertResponse", "Landroidx/privacysandbox/ads/adservices/adid/AdId;", "response", "Landroid/adservices/adid/AdId;", "getAdId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdIdAsyncInternal", "ads-adservices_release"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public class AdIdManagerImplCommon extends AdIdManager {
    private final android.adservices.adid.AdIdManager mAdIdManager;

    /* JADX INFO: renamed from: androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$getAdId$1 */
    /* JADX INFO: compiled from: AdIdManagerImplCommon.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon", m1609f = "AdIdManagerImplCommon.kt", m1610i = {}, m1611l = {40}, m1612m = "getAdId$suspendImpl", m1613n = {}, m1615s = {})
    static final class C25571 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C25571(Continuation<? super C25571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AdIdManagerImplCommon.getAdId$suspendImpl(AdIdManagerImplCommon.this, this);
        }
    }

    @Override // androidx.privacysandbox.ads.adservices.adid.AdIdManager
    public Object getAdId(Continuation<? super AdId> continuation) {
        return getAdId$suspendImpl(this, continuation);
    }

    public AdIdManagerImplCommon(android.adservices.adid.AdIdManager mAdIdManager) {
        Intrinsics.checkNotNullParameter(mAdIdManager, "mAdIdManager");
        this.mAdIdManager = mAdIdManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object getAdId$suspendImpl(AdIdManagerImplCommon adIdManagerImplCommon, Continuation<? super AdId> continuation) {
        C25571 c25571;
        if (continuation instanceof C25571) {
            c25571 = (C25571) continuation;
            if ((c25571.label & Integer.MIN_VALUE) != 0) {
                c25571.label -= Integer.MIN_VALUE;
            } else {
                c25571 = adIdManagerImplCommon.new C25571(continuation);
            }
        }
        Object adIdAsyncInternal = c25571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c25571.label;
        if (i == 0) {
            ResultKt.throwOnFailure(adIdAsyncInternal);
            c25571.L$0 = adIdManagerImplCommon;
            c25571.label = 1;
            adIdAsyncInternal = adIdManagerImplCommon.getAdIdAsyncInternal(c25571);
            if (adIdAsyncInternal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            adIdManagerImplCommon = (AdIdManagerImplCommon) c25571.L$0;
            ResultKt.throwOnFailure(adIdAsyncInternal);
        }
        return adIdManagerImplCommon.convertResponse((android.adservices.adid.AdId) adIdAsyncInternal);
    }

    private final AdId convertResponse(android.adservices.adid.AdId response) {
        String adId = response.getAdId();
        Intrinsics.checkNotNullExpressionValue(adId, "response.adId");
        return new AdId(adId, response.isLimitAdTrackingEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAdIdAsyncInternal(Continuation<? super android.adservices.adid.AdId> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.mAdIdManager.getAdId(new CredentialManager$$ExternalSyntheticLambda0(), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}

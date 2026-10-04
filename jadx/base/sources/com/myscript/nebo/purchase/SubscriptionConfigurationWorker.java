package com.myscript.nebo.purchase;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.media3.common.MimeTypes;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.myscript.nebo.IAsyncDataComponent;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubscriptionConfigurationWorker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/purchase/SubscriptionConfigurationWorker;", "Landroidx/work/CoroutineWorker;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "subscriptionRepository", "Lcom/myscript/nebo/purchase/ISubscriptionRepository;", "userProfileManager", "Lcom/myscript/nebo/account/UserProfileManager;", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SubscriptionConfigurationWorker extends CoroutineWorker {
    public static final int $stable = 8;
    private final NeboNetworkStateRepository networkStateRepository;
    private final ISubscriptionRepository subscriptionRepository;
    private final UserProfileManager userProfileManager;

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionConfigurationWorker$doWork$1 */
    /* JADX INFO: compiled from: SubscriptionConfigurationWorker.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionConfigurationWorker", m1609f = "SubscriptionConfigurationWorker.kt", m1610i = {2}, m1611l = {26, 27, 31}, m1612m = "doWork", m1613n = {"hasInternetAccess"}, m1614nl = {27, 29, 34}, m1615s = {"I$0"}, m1616v = 2)
    static final class C67321 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        C67321(Continuation<? super C67321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionConfigurationWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SubscriptionConfigurationWorker(Context application, WorkerParameters workerParams) {
        super(application, workerParams);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        ISubscriptionRepository.Provider provider = application instanceof ISubscriptionRepository.Provider ? (ISubscriptionRepository.Provider) application : null;
        this.subscriptionRepository = provider != null ? provider.provideSubscriptionRepository() : null;
        UserProfileManager.Provider provider2 = application instanceof UserProfileManager.Provider ? (UserProfileManager.Provider) application : null;
        this.userProfileManager = provider2 != null ? provider2.provideUserProfileManager() : null;
        NeboNetworkStateRepositoryProvider neboNetworkStateRepositoryProvider = application instanceof NeboNetworkStateRepositoryProvider ? (NeboNetworkStateRepositoryProvider) application : null;
        this.networkStateRepository = neboNetworkStateRepositoryProvider != null ? neboNetworkStateRepositoryProvider.provideNeboNetworkStateRepository() : null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0089, code lost:
    
        if (r2.loadInitialDataIfNeeded(r0) == r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        C67321 c67321;
        boolean z;
        LiveData<NeboNetworkState> neboNetworkState;
        if (continuation instanceof C67321) {
            c67321 = (C67321) continuation;
            if ((c67321.label & Integer.MIN_VALUE) != 0) {
                c67321.label -= Integer.MIN_VALUE;
            } else {
                c67321 = new C67321(continuation);
            }
        }
        Object obj = c67321.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c67321.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ISubscriptionRepository iSubscriptionRepository = this.subscriptionRepository;
            if (iSubscriptionRepository != null) {
                c67321.label = 1;
                if (iSubscriptionRepository.preConfigure(c67321) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i2 = c67321.I$0;
                    ResultKt.throwOnFailure(obj);
                    ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
                    Intrinsics.checkNotNullExpressionValue(resultSuccess, "success(...)");
                    return resultSuccess;
                }
                ResultKt.throwOnFailure(obj);
                NeboNetworkStateRepository neboNetworkStateRepository = this.networkStateRepository;
                z = ((neboNetworkStateRepository != null || (neboNetworkState = neboNetworkStateRepository.getNeboNetworkState()) == null) ? null : neboNetworkState.getValue()) instanceof NeboNetworkState.Connected;
                if (z) {
                    UserProfileManager userProfileManager = this.userProfileManager;
                    IAsyncDataComponent iAsyncDataComponent = userProfileManager instanceof IAsyncDataComponent ? (IAsyncDataComponent) userProfileManager : null;
                    if (iAsyncDataComponent != null) {
                        c67321.I$0 = z ? 1 : 0;
                        c67321.label = 3;
                    }
                }
                ListenableWorker.Result resultSuccess2 = ListenableWorker.Result.success();
                Intrinsics.checkNotNullExpressionValue(resultSuccess2, "success(...)");
                return resultSuccess2;
            }
            ResultKt.throwOnFailure(obj);
        }
        ISubscriptionRepository iSubscriptionRepository2 = this.subscriptionRepository;
        if (iSubscriptionRepository2 != null) {
            c67321.label = 2;
            if (iSubscriptionRepository2.updateConfiguration(c67321) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        NeboNetworkStateRepository neboNetworkStateRepository2 = this.networkStateRepository;
        z = ((neboNetworkStateRepository2 != null || (neboNetworkState = neboNetworkStateRepository2.getNeboNetworkState()) == null) ? null : neboNetworkState.getValue()) instanceof NeboNetworkState.Connected;
        if (z) {
        }
        ListenableWorker.Result resultSuccess22 = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(resultSuccess22, "success(...)");
        return resultSuccess22;
    }
}

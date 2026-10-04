package com.myscript.nebo.purchase;

import android.content.Context;
import androidx.media3.common.MimeTypes;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubscriptionPreConfigurationWorker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/purchase/SubscriptionPreConfigurationWorker;", "Landroidx/work/CoroutineWorker;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "subscriptionRepository", "Lcom/myscript/nebo/purchase/ISubscriptionRepository;", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SubscriptionPreConfigurationWorker extends CoroutineWorker {
    public static final int $stable = 8;
    private final ISubscriptionRepository subscriptionRepository;

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.SubscriptionPreConfigurationWorker$doWork$1 */
    /* JADX INFO: compiled from: SubscriptionPreConfigurationWorker.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.SubscriptionPreConfigurationWorker", m1609f = "SubscriptionPreConfigurationWorker.kt", m1610i = {}, m1611l = {17}, m1612m = "doWork", m1613n = {}, m1614nl = {19}, m1615s = {}, m1616v = 2)
    static final class C67331 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C67331(Continuation<? super C67331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionPreConfigurationWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SubscriptionPreConfigurationWorker(Context application, WorkerParameters workerParams) {
        super(application, workerParams);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        ISubscriptionRepository.Provider provider = application instanceof ISubscriptionRepository.Provider ? (ISubscriptionRepository.Provider) application : null;
        this.subscriptionRepository = provider != null ? provider.provideSubscriptionRepository() : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        C67331 c67331;
        if (continuation instanceof C67331) {
            c67331 = (C67331) continuation;
            if ((c67331.label & Integer.MIN_VALUE) != 0) {
                c67331.label -= Integer.MIN_VALUE;
            } else {
                c67331 = new C67331(continuation);
            }
        }
        Object obj = c67331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c67331.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ISubscriptionRepository iSubscriptionRepository = this.subscriptionRepository;
            if (iSubscriptionRepository != null) {
                c67331.label = 1;
                if (iSubscriptionRepository.preConfigure(c67331) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(resultSuccess, "success(...)");
        return resultSuccess;
    }
}

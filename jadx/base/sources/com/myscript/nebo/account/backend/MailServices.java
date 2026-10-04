package com.myscript.nebo.account.backend;

import com.myscript.nebo.account.backend.entity.RevenueCatCustomerRequest;
import com.myscript.nebo.log.TechnicalLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: MailServices.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/account/backend/MailServices;", "Lcom/myscript/nebo/account/backend/IMailServices;", "httpClient", "Lokhttp3/OkHttpClient;", "baseUrl", "", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "<init>", "(Lokhttp3/OkHttpClient;Ljava/lang/String;Lcom/myscript/nebo/log/TechnicalLogger;)V", "getLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "mailApi", "Lcom/myscript/nebo/account/backend/MailServicesApi;", "kotlin.jvm.PlatformType", "linkToRevenueCat", "", "appUserId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "optInTrialStarted", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MailServices implements IMailServices {
    private final TechnicalLogger logger;
    private final MailServicesApi mailApi;

    /* JADX INFO: renamed from: com.myscript.nebo.account.backend.MailServices$linkToRevenueCat$1 */
    /* JADX INFO: compiled from: MailServices.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.account.backend.MailServices", m1609f = "MailServices.kt", m1610i = {0, 0, 0}, m1611l = {35}, m1612m = "linkToRevenueCat", m1613n = {"appUserId", "$this$linkToRevenueCat_u24lambda_u240", "$i$a$-runCatching-MailServices$linkToRevenueCat$2"}, m1614nl = {36}, m1615s = {"L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C60821 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C60821(Continuation<? super C60821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MailServices.this.linkToRevenueCat(null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.account.backend.MailServices$optInTrialStarted$1 */
    /* JADX INFO: compiled from: MailServices.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.account.backend.MailServices", m1609f = "MailServices.kt", m1610i = {0, 0, 0}, m1611l = {44}, m1612m = "optInTrialStarted", m1613n = {"appUserId", "$this$optInTrialStarted_u24lambda_u240", "$i$a$-runCatching-MailServices$optInTrialStarted$2"}, m1614nl = {45}, m1615s = {"L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C60831 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C60831(Continuation<? super C60831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MailServices.this.optInTrialStarted(null, this);
        }
    }

    public MailServices(OkHttpClient httpClient, String baseUrl, TechnicalLogger logger) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.mailApi = (MailServicesApi) new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(httpClient).build().create(MailServicesApi.class);
    }

    public final TechnicalLogger getLogger() {
        return this.logger;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.account.backend.IMailServices
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object linkToRevenueCat(String str, Continuation<? super Boolean> continuation) {
        C60821 c60821;
        Object objM14499constructorimpl;
        if (continuation instanceof C60821) {
            c60821 = (C60821) continuation;
            if ((c60821.label & Integer.MIN_VALUE) != 0) {
                c60821.label -= Integer.MIN_VALUE;
            } else {
                c60821 = new C60821(continuation);
            }
        }
        Object obj = c60821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c60821.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                MailServices mailServices = this;
                MailServicesApi mailServicesApi = this.mailApi;
                RevenueCatCustomerRequest revenueCatCustomerRequest = new RevenueCatCustomerRequest(str);
                c60821.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c60821.L$1 = SpillingKt.nullOutSpilledVariable(this);
                c60821.I$0 = 0;
                c60821.label = 1;
                if (mailServicesApi.linkToRevenueCat(revenueCatCustomerRequest, c60821) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c60821.I$0;
                ResultKt.throwOnFailure(obj);
            }
            objM14499constructorimpl = Result.m14499constructorimpl(Boxing.boxBoolean(true));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
            this.logger.logError(new RuntimeException("Error while connecting mailservices with rc", thM14502exceptionOrNullimpl));
        }
        return Result.m14505isFailureimpl(objM14499constructorimpl) ? Boxing.boxBoolean(false) : objM14499constructorimpl;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.account.backend.IMailServices
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object optInTrialStarted(String str, Continuation<? super Boolean> continuation) {
        C60831 c60831;
        Object objM14499constructorimpl;
        if (continuation instanceof C60831) {
            c60831 = (C60831) continuation;
            if ((c60831.label & Integer.MIN_VALUE) != 0) {
                c60831.label -= Integer.MIN_VALUE;
            } else {
                c60831 = new C60831(continuation);
            }
        }
        Object obj = c60831.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c60831.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                MailServices mailServices = this;
                MailServicesApi mailServicesApi = this.mailApi;
                RevenueCatCustomerRequest revenueCatCustomerRequest = new RevenueCatCustomerRequest(str);
                c60831.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c60831.L$1 = SpillingKt.nullOutSpilledVariable(this);
                c60831.I$0 = 0;
                c60831.label = 1;
                if (mailServicesApi.optInTrialStarted(revenueCatCustomerRequest, c60831) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c60831.I$0;
                ResultKt.throwOnFailure(obj);
            }
            objM14499constructorimpl = Result.m14499constructorimpl(Boxing.boxBoolean(true));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
            this.logger.logError(new RuntimeException("Error while connecting mailservices with app user id", thM14502exceptionOrNullimpl));
        }
        return Result.m14505isFailureimpl(objM14499constructorimpl) ? Boxing.boxBoolean(false) : objM14499constructorimpl;
    }
}

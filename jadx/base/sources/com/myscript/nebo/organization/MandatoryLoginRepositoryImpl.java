package com.myscript.nebo.organization;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.myscript.nebo.account.backend.Backend;
import com.myscript.nebo.account.backend.entity.NeboAccount;
import com.myscript.nebo.common.IClock;
import com.myscript.nebo.organization.MandatoryLoginRepository;
import com.myscript.nebo.sso.api.ISSOManager;
import com.myscript.nebo.sso.model.UserData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MandatoryLoginRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/organization/MandatoryLoginRepositoryImpl;", "Lcom/myscript/nebo/organization/MandatoryLoginRepository;", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "ssoManager", "Lcom/myscript/nebo/sso/api/ISSOManager;", "neboBackend", "Lcom/myscript/nebo/account/backend/Backend;", "clock", "Lcom/myscript/nebo/common/IClock;", "<init>", "(Lcom/myscript/nebo/sso/model/UserData;Lcom/myscript/nebo/sso/api/ISSOManager;Lcom/myscript/nebo/account/backend/Backend;Lcom/myscript/nebo/common/IClock;)V", "getAuthorizeUrl", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasUser", "", "canOpenApp", "logout", "", "login", "authorizationCode", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadOrganizationState", "Lcom/myscript/nebo/organization/MandatoryLoginRepository$OrganizationState;", "saveOrganizationState", "lastFetch", "", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MandatoryLoginRepositoryImpl implements MandatoryLoginRepository {
    private final IClock clock;
    private final Backend neboBackend;
    private final ISSOManager ssoManager;
    private final UserData userData;

    /* JADX INFO: renamed from: com.myscript.nebo.organization.MandatoryLoginRepositoryImpl$loadOrganizationState$1 */
    /* JADX INFO: compiled from: MandatoryLoginRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.organization.MandatoryLoginRepositoryImpl", m1609f = "MandatoryLoginRepository.kt", m1610i = {}, m1611l = {50}, m1612m = "loadOrganizationState", m1613n = {}, m1614nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m1615s = {}, m1616v = 2)
    static final class C66701 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C66701(Continuation<? super C66701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MandatoryLoginRepositoryImpl.this.loadOrganizationState(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.organization.MandatoryLoginRepositoryImpl$login$1 */
    /* JADX INFO: compiled from: MandatoryLoginRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.organization.MandatoryLoginRepositoryImpl", m1609f = "MandatoryLoginRepository.kt", m1610i = {0}, m1611l = {45}, m1612m = "login", m1613n = {"authorizationCode"}, m1614nl = {46}, m1615s = {"L$0"}, m1616v = 2)
    static final class C66711 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C66711(Continuation<? super C66711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MandatoryLoginRepositoryImpl.this.login(null, this);
        }
    }

    public MandatoryLoginRepositoryImpl(UserData userData, ISSOManager ssoManager, Backend neboBackend, IClock clock) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(ssoManager, "ssoManager");
        Intrinsics.checkNotNullParameter(neboBackend, "neboBackend");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.userData = userData;
        this.ssoManager = ssoManager;
        this.neboBackend = neboBackend;
        this.clock = clock;
    }

    @Override // com.myscript.nebo.organization.MandatoryLoginRepository
    public Object getAuthorizeUrl(Continuation<? super String> continuation) {
        return this.ssoManager.buildAuthorizeUrl(continuation);
    }

    @Override // com.myscript.nebo.organization.MandatoryLoginRepository
    public boolean hasUser() {
        return this.userData.hasUser();
    }

    @Override // com.myscript.nebo.organization.MandatoryLoginRepository
    public boolean canOpenApp() {
        return this.userData.hasOrganizationOpenApp();
    }

    @Override // com.myscript.nebo.organization.MandatoryLoginRepository
    public void logout() {
        this.userData.logout();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.organization.MandatoryLoginRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object login(String str, Continuation<? super Boolean> continuation) {
        C66711 c66711;
        if (continuation instanceof C66711) {
            c66711 = (C66711) continuation;
            if ((c66711.label & Integer.MIN_VALUE) != 0) {
                c66711.label -= Integer.MIN_VALUE;
            } else {
                c66711 = new C66711(continuation);
            }
        }
        Object obj = c66711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c66711.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ISSOManager iSSOManager = this.ssoManager;
            c66711.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c66711.label = 1;
            if (iSSOManager.login(str, null, c66711) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(this.userData.hasUser());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.organization.MandatoryLoginRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadOrganizationState(Continuation<? super MandatoryLoginRepository.OrganizationState> continuation) {
        C66701 c66701;
        if (continuation instanceof C66701) {
            c66701 = (C66701) continuation;
            if ((c66701.label & Integer.MIN_VALUE) != 0) {
                c66701.label -= Integer.MIN_VALUE;
            } else {
                c66701 = new C66701(continuation);
            }
        }
        Object neboAccount = c66701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c66701.label;
        if (i == 0) {
            ResultKt.throwOnFailure(neboAccount);
            Backend backend = this.neboBackend;
            c66701.label = 1;
            neboAccount = backend.getNeboAccount(c66701);
            if (neboAccount == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(neboAccount);
        }
        NeboAccount neboAccount2 = (NeboAccount) neboAccount;
        if (neboAccount2 != null) {
            return new MandatoryLoginRepository.OrganizationState(neboAccount2.getCanOpenApp(), this.clock.getTime());
        }
        return new MandatoryLoginRepository.OrganizationState(this.userData.hasOrganizationOpenApp(), this.userData.getOrganizationLastFetch());
    }

    @Override // com.myscript.nebo.organization.MandatoryLoginRepository
    public void saveOrganizationState(boolean canOpenApp, long lastFetch) {
        this.userData.saveOrganizationOpenApp(canOpenApp);
        this.userData.setOrganizationLastFetch(lastFetch);
    }
}

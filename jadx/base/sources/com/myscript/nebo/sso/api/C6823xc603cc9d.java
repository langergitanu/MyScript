package com.myscript.nebo.sso.api;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.sso.api.auth.SSOAuthApi;
import com.myscript.nebo.sso.api.discovery.DiscoveredSSOConfiguration;
import com.myscript.nebo.sso.api.discovery.DiscoveryApi;
import com.myscript.nebo.sso.model.UserData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.HttpException;

/* JADX INFO: renamed from: com.myscript.nebo.sso.api.SSOHttpClientKt$buildSSOHttpClient$authenticator$1$newAccessToken$1 */
/* JADX INFO: compiled from: SSOHttpClient.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOHttpClientKt$buildSSOHttpClient$authenticator$1$newAccessToken$1", m1609f = "SSOHttpClient.kt", m1610i = {}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {53, 57}, m1615s = {}, m1616v = 2)
final class C6823xc603cc9d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ SSOConfiguration $config;
    final /* synthetic */ DiscoveryApi $discoveryApi;
    final /* synthetic */ TechnicalLogger $logger;
    final /* synthetic */ SSOAuthApi $ssoAuthApi;
    final /* synthetic */ UserData $userData;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C6823xc603cc9d(SSOAuthApi sSOAuthApi, DiscoveryApi discoveryApi, SSOConfiguration sSOConfiguration, UserData userData, TechnicalLogger technicalLogger, Continuation<? super C6823xc603cc9d> continuation) {
        super(2, continuation);
        this.$ssoAuthApi = sSOAuthApi;
        this.$discoveryApi = discoveryApi;
        this.$config = sSOConfiguration;
        this.$userData = userData;
        this.$logger = technicalLogger;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C6823xc603cc9d(this.$ssoAuthApi, this.$discoveryApi, this.$config, this.$userData, this.$logger, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((C6823xc603cc9d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        if (r12 == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SSOAuthApi sSOAuthApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sSOAuthApi = this.$ssoAuthApi;
                this.L$0 = sSOAuthApi;
                this.label = 1;
                obj = this.$discoveryApi.discoverSSOConfiguration(this);
                if (obj == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return ((SSOAuthApi.AccessTokenResponse) obj).getAccessToken();
            }
            sSOAuthApi = (SSOAuthApi) this.L$0;
            ResultKt.throwOnFailure(obj);
            SSOAuthApi sSOAuthApi2 = sSOAuthApi;
            this.L$0 = null;
            this.label = 2;
            obj = sSOAuthApi2.refreshToken(((DiscoveredSSOConfiguration) obj).getTokenEndpoint(), "refresh_token", this.$config.getClientId(), this.$config.getClientSecret(), this.$userData.getRefreshToken(), this);
        } catch (HttpException e) {
            TechnicalLogger technicalLogger = this.$logger;
            if (technicalLogger != null) {
                technicalLogger.logError(new RuntimeException("Token re-negociation failed", e));
            }
            this.$userData.setRefreshToken("");
            this.$userData.setAccessToken("");
            return null;
        }
    }
}

package com.myscript.nebo.sso.api;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.apache.http.HttpStatus;
import retrofit2.Response;

/* JADX INFO: compiled from: SSOManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "Lretrofit2/Response;", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager$startNativeLoginFlow$2$response$1", m1609f = "SSOManager.kt", m1610i = {}, m1611l = {HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
final class SSOManager$startNativeLoginFlow$2$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<Unit>>, Object> {
    final /* synthetic */ NativeLoginApi $api;
    final /* synthetic */ String $authorizeUrl;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SSOManager$startNativeLoginFlow$2$response$1(NativeLoginApi nativeLoginApi, String str, Continuation<? super SSOManager$startNativeLoginFlow$2$response$1> continuation) {
        super(2, continuation);
        this.$api = nativeLoginApi;
        this.$authorizeUrl = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SSOManager$startNativeLoginFlow$2$response$1(this.$api, this.$authorizeUrl, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response<Unit>> continuation) {
        return ((SSOManager$startNativeLoginFlow$2$response$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object objAuthorize = this.$api.authorize(this.$authorizeUrl, this);
        return objAuthorize == coroutine_suspended ? coroutine_suspended : objAuthorize;
    }
}

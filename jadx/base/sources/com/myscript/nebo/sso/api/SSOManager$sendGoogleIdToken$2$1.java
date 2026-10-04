package com.myscript.nebo.sso.api;

import androidx.media3.extractor.text.ttml.TtmlNode;
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
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: SSOManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.sso.api.SSOManager$sendGoogleIdToken$2$1", m1609f = "SSOManager.kt", m1610i = {0}, m1611l = {386}, m1612m = "invokeSuspend", m1613n = {TtmlNode.TAG_BODY}, m1614nl = {391}, m1615s = {"L$0"}, m1616v = 2)
final class SSOManager$sendGoogleIdToken$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NativeLoginApi $api;
    final /* synthetic */ String $idToken;
    final /* synthetic */ SSOManager $this_runCatching;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SSOManager$sendGoogleIdToken$2$1(String str, SSOManager sSOManager, NativeLoginApi nativeLoginApi, Continuation<? super SSOManager$sendGoogleIdToken$2$1> continuation) {
        super(2, continuation);
        this.$idToken = str;
        this.$this_runCatching = sSOManager;
        this.$api = nativeLoginApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SSOManager$sendGoogleIdToken$2$1(this.$idToken, this.$this_runCatching, this.$api, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SSOManager$sendGoogleIdToken$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestBody requestBodyCreate = RequestBody.INSTANCE.create(this.$idToken, MediaType.INSTANCE.get("text/plain"));
            SSOManager sSOManager = this.$this_runCatching;
            sSOManager.log("POST /public/openid/google (Client-Id=" + sSOManager.config.getClientId() + ", Nebo-Version=Android " + this.$this_runCatching.appVersion + ")");
            NativeLoginApi nativeLoginApi = this.$api;
            String clientId = this.$this_runCatching.config.getClientId();
            String str = this.$this_runCatching.appVersion;
            this.L$0 = SpillingKt.nullOutSpilledVariable(requestBodyCreate);
            this.label = 1;
            if (nativeLoginApi.loginWithGoogle(clientId, "Android " + str, requestBodyCreate, this) == coroutine_suspended) {
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

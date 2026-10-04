package aws.sdk.kotlin.runtime.auth.credentials;

import aws.smithy.kotlin.runtime.collections.Attributes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: LoginTokenProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/auth/credentials/LoginToken;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.LoginTokenProvider$resolve$token$1", m1609f = "LoginTokenProvider.kt", m1610i = {}, m1611l = {HttpStatusCodesKt.HTTP_EARLY_HINTS}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
final class LoginTokenProvider$resolve$token$1 extends SuspendLambda implements Function1<Continuation<? super LoginToken>, Object> {
    final /* synthetic */ Attributes $attributes;
    int label;
    final /* synthetic */ LoginTokenProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoginTokenProvider$resolve$token$1(LoginTokenProvider loginTokenProvider, Attributes attributes, Continuation<? super LoginTokenProvider$resolve$token$1> continuation) {
        super(1, continuation);
        this.this$0 = loginTokenProvider;
        this.$attributes = attributes;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new LoginTokenProvider$resolve$token$1(this.this$0, this.$attributes, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super LoginToken> continuation) {
        return ((LoginTokenProvider$resolve$token$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        Object token = this.this$0.getToken(this.$attributes, this);
        return token == coroutine_suspended ? coroutine_suspended : token;
    }
}

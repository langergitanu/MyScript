package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.compose.p004ui.spatial.RectListKt;
import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.SigninClient;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LoginCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/SigninClient;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.LoginCredentialsProvider$client$1", m1609f = "LoginCredentialsProvider.kt", m1610i = {}, m1611l = {RectListKt.BitOffsetForGesturable}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
final class LoginCredentialsProvider$client$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SigninClient>, Object> {
    int label;
    final /* synthetic */ LoginCredentialsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoginCredentialsProvider$client$1(LoginCredentialsProvider loginCredentialsProvider, Continuation<? super LoginCredentialsProvider$client$1> continuation) {
        super(2, continuation);
        this.this$0 = loginCredentialsProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginCredentialsProvider$client$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SigninClient> continuation) {
        return ((LoginCredentialsProvider$client$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        Object objSigninClient = LoginCredentialsProviderKt.signinClient(this.this$0.getRegion(), this.this$0.getHttpClient(), this);
        return objSigninClient == coroutine_suspended ? coroutine_suspended : objSigninClient;
    }
}

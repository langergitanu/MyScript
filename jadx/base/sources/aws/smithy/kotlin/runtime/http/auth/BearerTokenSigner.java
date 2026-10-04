package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.identity.Identity;
import aws.smithy.kotlin.runtime.net.SchemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: BearerTokenSigner.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/BearerTokenSigner;", "Laws/smithy/kotlin/runtime/http/auth/HttpSigner;", "<init>", "()V", "sign", "", "signingRequest", "Laws/smithy/kotlin/runtime/http/auth/SignHttpRequest;", "(Laws/smithy/kotlin/runtime/http/auth/SignHttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-auth"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BearerTokenSigner implements HttpSigner {
    @Override // aws.smithy.kotlin.runtime.http.auth.HttpSigner
    public Object sign(SignHttpRequest signHttpRequest, Continuation<? super Unit> continuation) {
        Identity identity = signHttpRequest.getIdentity();
        if (!(identity instanceof BearerToken)) {
            throw new IllegalStateException(("expected a " + Reflection.getOrCreateKotlinClass(BearerToken.class) + " identity; found " + Reflection.getOrCreateKotlinClass(signHttpRequest.getIdentity().getClass())).toString());
        }
        if (!SchemeKt.isSecure(signHttpRequest.getHttpRequest().getUrl().getScheme())) {
            throw new IllegalStateException("https is required to use Bearer token auth".toString());
        }
        signHttpRequest.getHttpRequest().getHeaders().set("Authorization", "Bearer " + ((BearerToken) identity).getToken());
        return Unit.INSTANCE;
    }
}

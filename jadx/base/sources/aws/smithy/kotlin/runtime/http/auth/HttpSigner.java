package aws.smithy.kotlin.runtime.http.auth;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: HttpSigner.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/HttpSigner;", "", "sign", "", "signingRequest", "Laws/smithy/kotlin/runtime/http/auth/SignHttpRequest;", "(Laws/smithy/kotlin/runtime/http/auth/SignHttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-auth-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface HttpSigner {
    Object sign(SignHttpRequest signHttpRequest, Continuation<? super Unit> continuation);
}

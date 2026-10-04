package aws.smithy.kotlin.runtime.http.auth;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: AnonymousAuthScheme.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/AnonymousHttpSigner;", "Laws/smithy/kotlin/runtime/http/auth/HttpSigner;", "<init>", "()V", "sign", "", "signingRequest", "Laws/smithy/kotlin/runtime/http/auth/SignHttpRequest;", "(Laws/smithy/kotlin/runtime/http/auth/SignHttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-auth"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AnonymousHttpSigner implements HttpSigner {
    public static final AnonymousHttpSigner INSTANCE = new AnonymousHttpSigner();

    private AnonymousHttpSigner() {
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.HttpSigner
    public Object sign(SignHttpRequest signHttpRequest, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}

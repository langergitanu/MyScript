package aws.smithy.kotlin.runtime.auth.awssigning;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AuthTokenGenerator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.AuthTokenGenerator", m1609f = "AuthTokenGenerator.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m1611l = {41, 49}, m1612m = "generateAuthToken-exY8QGI", m1613n = {"endpoint", TtmlNode.TAG_REGION, "req", "this_$iv", "$this$generateAuthToken_exY8QGI_u24lambda_u241", "expiration", "$i$f$invoke", "$i$a$-invoke-AuthTokenGenerator$generateAuthToken$config$1", "endpoint", TtmlNode.TAG_REGION, "req", "config", "expiration"}, m1614nl = {42, -1}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$5", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "J$0"}, m1616v = 2)
final class AuthTokenGenerator$generateAuthToken$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthTokenGenerator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AuthTokenGenerator$generateAuthToken$1(AuthTokenGenerator authTokenGenerator, Continuation<? super AuthTokenGenerator$generateAuthToken$1> continuation) {
        super(continuation);
        this.this$0 = authTokenGenerator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m12132generateAuthTokenexY8QGI(null, null, 0L, this);
    }
}

package aws.sdk.kotlin.runtime.config.imds;

import androidx.media3.extractor.p007ts.TsExtractor;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.util.ExpiringValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TokenMiddleware.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Laws/smithy/kotlin/runtime/util/ExpiringValue;", "Laws/sdk/kotlin/runtime/config/imds/Token;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$modifyRequest$token$1", m1609f = "TokenMiddleware.kt", m1610i = {}, m1611l = {45}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {TsExtractor.TS_STREAM_TYPE_DVBSUBS}, m1615s = {}, m1616v = 2)
final class TokenMiddleware$modifyRequest$token$1 extends SuspendLambda implements Function1<Continuation<? super ExpiringValue<Token>>, Object> {
    final /* synthetic */ OperationRequest<HttpRequestBuilder> $req;
    int label;
    final /* synthetic */ TokenMiddleware this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TokenMiddleware$modifyRequest$token$1(TokenMiddleware tokenMiddleware, OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super TokenMiddleware$modifyRequest$token$1> continuation) {
        super(1, continuation);
        this.this$0 = tokenMiddleware;
        this.$req = operationRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TokenMiddleware$modifyRequest$token$1(this.this$0, this.$req, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ExpiringValue<Token>> continuation) {
        return ((TokenMiddleware$modifyRequest$token$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TokenMiddleware tokenMiddleware = this.this$0;
            this.label = 1;
            obj = tokenMiddleware.getToken(tokenMiddleware.clock, this.$req, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Token token = (Token) obj;
        return new ExpiringValue(token, token.getExpires());
    }
}

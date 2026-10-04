package aws.sdk.kotlin.services.p010s3.serde;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.model.SelectObjectContentResponse;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.HttpStatusCodeKt;
import aws.smithy.kotlin.runtime.http.operation.HttpDeserializer;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: SelectObjectContentOperationDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/serde/SelectObjectContentOperationDeserializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer$Streaming;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentResponse;", "<init>", "()V", "deserialize", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/http/HttpCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SelectObjectContentOperationDeserializer implements HttpDeserializer.Streaming<SelectObjectContentResponse> {

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.SelectObjectContentOperationDeserializer$deserialize$1 */
    /* JADX INFO: compiled from: SelectObjectContentOperationDeserializer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.serde.SelectObjectContentOperationDeserializer", m1609f = "SelectObjectContentOperationDeserializer.kt", m1610i = {0, 0, 0, 1, 1, 1, 1}, m1611l = {37, 42}, m1612m = "deserialize", m1613n = {WebViewMessageType.CONTEXT, NotificationCompat.CATEGORY_CALL, "response", WebViewMessageType.CONTEXT, NotificationCompat.CATEGORY_CALL, "response", "builder"}, m1614nl = {38, 43}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, m1616v = 2)
    static final class C36001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C36001(Continuation<? super C36001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectObjectContentOperationDeserializer.this.deserialize(null, null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x007b, code lost:
    
        if (r8 == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpDeserializer.Streaming
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deserialize(ExecutionContext executionContext, HttpCall httpCall, Continuation<? super SelectObjectContentResponse> continuation) {
        C36001 c36001;
        SelectObjectContentResponse.Builder builder;
        if (continuation instanceof C36001) {
            c36001 = (C36001) continuation;
            if ((c36001.label & Integer.MIN_VALUE) != 0) {
                c36001.label -= Integer.MIN_VALUE;
            } else {
                c36001 = new C36001(continuation);
            }
        }
        Object all = c36001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36001.label;
        if (i != 0) {
            if (i == 1) {
                httpCall = (HttpCall) c36001.L$1;
                executionContext = (ExecutionContext) c36001.L$0;
                ResultKt.throwOnFailure(all);
                SelectObjectContentOperationDeserializerKt.throwSelectObjectContentError(executionContext, httpCall, (byte[]) all);
                throw new KotlinNothingValueException();
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            builder = (SelectObjectContentResponse.Builder) c36001.L$3;
            ResultKt.throwOnFailure(all);
            builder.correctErrors$s3();
            return builder.build();
        }
        ResultKt.throwOnFailure(all);
        HttpResponse response = httpCall.getResponse();
        if (!HttpStatusCodeKt.isSuccess(response.getStatus())) {
            HttpBody body = response.getBody();
            c36001.L$0 = executionContext;
            c36001.L$1 = httpCall;
            c36001.L$2 = SpillingKt.nullOutSpilledVariable(response);
            c36001.label = 1;
            all = HttpBodyKt.readAll(body, c36001);
        } else {
            SelectObjectContentResponse.Builder builder2 = new SelectObjectContentResponse.Builder();
            c36001.L$0 = SpillingKt.nullOutSpilledVariable(executionContext);
            c36001.L$1 = SpillingKt.nullOutSpilledVariable(httpCall);
            c36001.L$2 = SpillingKt.nullOutSpilledVariable(response);
            c36001.L$3 = builder2;
            c36001.label = 2;
            if (SelectObjectContentOperationDeserializerKt.deserializeSelectObjectContentOperationBody(builder2, httpCall, c36001) != coroutine_suspended) {
                builder = builder2;
                builder.correctErrors$s3();
                return builder.build();
            }
        }
        return coroutine_suspended;
    }
}

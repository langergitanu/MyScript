package aws.sdk.kotlin.services.p010s3.serde;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.model.GetObjectTorrentResponse;
import aws.sdk.kotlin.services.p010s3.model.RequestCharged;
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

/* JADX INFO: compiled from: GetObjectTorrentOperationDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/serde/GetObjectTorrentOperationDeserializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer$Streaming;", "Laws/sdk/kotlin/services/s3/model/GetObjectTorrentResponse;", "<init>", "()V", "deserialize", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/http/HttpCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetObjectTorrentOperationDeserializer implements HttpDeserializer.Streaming<GetObjectTorrentResponse> {

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.GetObjectTorrentOperationDeserializer$deserialize$1 */
    /* JADX INFO: compiled from: GetObjectTorrentOperationDeserializer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.serde.GetObjectTorrentOperationDeserializer", m1609f = "GetObjectTorrentOperationDeserializer.kt", m1610i = {0, 0, 0}, m1611l = {30}, m1612m = "deserialize", m1613n = {WebViewMessageType.CONTEXT, NotificationCompat.CATEGORY_CALL, "response"}, m1614nl = {31}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C35151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C35151(Continuation<? super C35151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetObjectTorrentOperationDeserializer.this.deserialize(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpDeserializer.Streaming
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deserialize(ExecutionContext executionContext, HttpCall httpCall, Continuation<? super GetObjectTorrentResponse> continuation) {
        C35151 c35151;
        if (continuation instanceof C35151) {
            c35151 = (C35151) continuation;
            if ((c35151.label & Integer.MIN_VALUE) != 0) {
                c35151.label -= Integer.MIN_VALUE;
            } else {
                c35151 = new C35151(continuation);
            }
        }
        Object all = c35151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c35151.label;
        if (i == 0) {
            ResultKt.throwOnFailure(all);
            HttpResponse response = httpCall.getResponse();
            if (!HttpStatusCodeKt.isSuccess(response.getStatus())) {
                HttpBody body = response.getBody();
                c35151.L$0 = executionContext;
                c35151.L$1 = httpCall;
                c35151.L$2 = SpillingKt.nullOutSpilledVariable(response);
                c35151.label = 1;
                all = HttpBodyKt.readAll(body, c35151);
                if (all == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                GetObjectTorrentResponse.Builder builder = new GetObjectTorrentResponse.Builder();
                String str = response.getHeaders().get("x-amz-request-charged");
                builder.setRequestCharged(str != null ? RequestCharged.INSTANCE.fromValue(str) : null);
                builder.setBody(HttpBodyKt.toByteStream(response.getBody()));
                builder.correctErrors$s3();
                return builder.build();
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            httpCall = (HttpCall) c35151.L$1;
            executionContext = (ExecutionContext) c35151.L$0;
            ResultKt.throwOnFailure(all);
        }
        GetObjectTorrentOperationDeserializerKt.throwGetObjectTorrentError(executionContext, httpCall, (byte[]) all);
        throw new KotlinNothingValueException();
    }
}

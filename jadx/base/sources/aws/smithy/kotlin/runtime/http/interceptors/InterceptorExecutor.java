package aws.smithy.kotlin.runtime.http.interceptors;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.businessmetrics.SmithyBusinessMetric;
import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.operation.OperationTypeInfo;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InterceptorExecutor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b!\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003BA\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012(\u0010\u000b\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n0\u0006\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0016\u001a\u00028\u0002\"\u0004\b\u0002\u0010\u00102\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0015\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J=\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00020\u0018\"\u0004\b\u0002\u0010\u00102\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJF\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00182.\u0010\u001f\u001a*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u001e0\u001dH\u0082\b¢\u0006\u0004\b \u0010!J\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00182\u0006\u0010#\u001a\u00028\u0000¢\u0006\u0004\b$\u0010%J\u0018\u0010'\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u001e2\u0006\u0010#\u001a\u00028\u0000¢\u0006\u0004\b)\u0010*Jc\u00101\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\b2I\u0010\u001f\u001aE\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u001e0,H\u0082\b¢\u0006\u0004\b1\u00102Jk\u00101\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\b2\u0006\u00103\u001a\u00020\t2I\u0010\u001f\u001aE\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000304¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u001e0,H\u0082\b¢\u0006\u0004\b1\u00105Jc\u00106\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2I\u0010\u001f\u001aE\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\b0,H\u0082\b¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\b¢\u0006\u0004\b8\u00109J\u0018\u0010:\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0086@¢\u0006\u0004\b:\u0010;J\u001b\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00182\u0006\u0010+\u001a\u00020\b¢\u0006\u0004\b<\u0010=J\u0018\u0010?\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0086@¢\u0006\u0004\b?\u0010;J\u0015\u0010@\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\b¢\u0006\u0004\b@\u00109J\u0015\u0010A\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\b¢\u0006\u0004\bA\u00109J\u0018\u0010B\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0086@¢\u0006\u0004\bB\u0010;J\u0015\u0010C\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\b¢\u0006\u0004\bC\u00109J\u0015\u0010F\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bF\u0010GJ\u0018\u0010H\u001a\u00020\t2\u0006\u0010E\u001a\u00020DH\u0086@¢\u0006\u0004\bH\u0010IJ\u0015\u0010J\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bJ\u0010GJ\u001d\u0010L\u001a\u00020\u001e2\u0006\u0010K\u001a\u00028\u00012\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bL\u0010MJ6\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010N\u001a\u00020\b2\b\u0010O\u001a\u0004\u0018\u00010\tH\u0086@¢\u0006\u0004\bP\u0010QJ-\u0010S\u001a\u00020\u001e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010N\u001a\u00020\b2\b\u0010O\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bS\u0010TJ$\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018H\u0086@¢\u0006\u0004\bU\u0010(J!\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018¢\u0006\u0004\bW\u0010%J-\u0010Z\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\b2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030-H\u0002¢\u0006\u0004\bZ\u0010[R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\\R6\u0010\u000b\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010]R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010^R\u0018\u0010_\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010a\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010c\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010d¨\u0006e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "I", "O", "", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "execContext", "", "Laws/smithy/kotlin/runtime/client/Interceptor;", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "interceptors", "Laws/smithy/kotlin/runtime/http/operation/OperationTypeInfo;", "typeInfo", "<init>", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Ljava/util/List;Laws/smithy/kotlin/runtime/http/operation/OperationTypeInfo;)V", ExifInterface.GPS_DIRECTION_TRUE, "", TypedValues.CycleType.S_WAVE_PHASE, "Lkotlin/reflect/KClass;", "expected", "actual", "checkType", "(Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Result;", "result", "checkResultType-mYkaXTg", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "checkResultType", "Lkotlin/Function1;", "", "block", "executeAll-IoAF18A", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "executeAll", "input", "readBeforeExecution-IoAF18A", "(Ljava/lang/Object;)Ljava/lang/Object;", "readBeforeExecution", "modifyBeforeSerialization", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readBeforeSerialization", "(Ljava/lang/Object;)V", "request", "Lkotlin/Function2;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpProtocolRequestInterceptorContext;", "Lkotlin/ParameterName;", "name", WebViewMessageType.CONTEXT, "readHttpHook", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;Lkotlin/jvm/functions/Function2;)V", "response", "Laws/smithy/kotlin/runtime/http/interceptors/HttpProtocolResponseInterceptorContext;", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/http/response/HttpResponse;Lkotlin/jvm/functions/Function2;)V", "modifyHttpRequestHook", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;Lkotlin/jvm/functions/Function2;)Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "readAfterSerialization", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;)V", "modifyBeforeRetryLoop", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readBeforeAttempt-IoAF18A", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;)Ljava/lang/Object;", "readBeforeAttempt", "modifyBeforeSigning", "readBeforeSigning", "readAfterSigning", "modifyBeforeTransmit", "readBeforeTransmit", "Laws/smithy/kotlin/runtime/http/HttpCall;", NotificationCompat.CATEGORY_CALL, "readAfterTransmit", "(Laws/smithy/kotlin/runtime/http/HttpCall;)V", "modifyBeforeDeserialization", "(Laws/smithy/kotlin/runtime/http/HttpCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readBeforeDeserialization", "output", "readAfterDeserialization", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/http/HttpCall;)V", "httpRequest", "httpResponse", "modifyBeforeAttemptCompletion-3t6e044", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/http/response/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "modifyBeforeAttemptCompletion", "readAfterAttempt", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/http/response/HttpResponse;)V", "modifyBeforeCompletion-KWTtemM", "modifyBeforeCompletion", "readAfterExecution-bjn95JY", "readAfterExecution", "modifiedRequest", "updateBusinessMetrics", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/http/interceptors/HttpProtocolRequestInterceptorContext;)V", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "Ljava/util/List;", "Laws/smithy/kotlin/runtime/http/operation/OperationTypeInfo;", "_lastInput", "Ljava/lang/Object;", "_lastHttpRequest", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "_lastHttpResponse", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InterceptorExecutor<I, O> {
    private HttpRequest _lastHttpRequest;
    private HttpResponse _lastHttpResponse;
    private I _lastInput;
    private final ExecutionContext execContext;
    private final List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors;
    private final OperationTypeInfo typeInfo;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeDeserialization$1 */
    /* JADX INFO: compiled from: InterceptorExecutor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor", m1609f = "InterceptorExecutor.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {238}, m1612m = "modifyBeforeDeserialization", m1613n = {NotificationCompat.CATEGORY_CALL, "input", WebViewMessageType.CONTEXT, "$this$modifyBeforeDeserialization_u24lambda_u240", "$this$fold$iv", "initial$iv", "accumulator$iv", "element$iv", "interceptor", "ctx", "$i$a$-runCatching-InterceptorExecutor$modifyBeforeDeserialization$modified$1", "$i$f$fold", "$i$a$-fold-InterceptorExecutor$modifyBeforeDeserialization$modified$1$1"}, m1614nl = {239}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2"}, m1616v = 2)
    static final class C37171 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ InterceptorExecutor<I, O> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37171(InterceptorExecutor<I, O> interceptorExecutor, Continuation<? super C37171> continuation) {
            super(continuation);
            this.this$0 = interceptorExecutor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.modifyBeforeDeserialization(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeRetryLoop$1 */
    /* JADX INFO: compiled from: InterceptorExecutor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor", m1609f = "InterceptorExecutor.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {190}, m1612m = "modifyBeforeRetryLoop", m1613n = {"request", "this_$iv", "request$iv", "input$iv", "context$iv", "$this$modifyHttpRequestHook_u24lambda_u240$iv", "$this$fold$iv$iv", "initial$iv$iv", "accumulator$iv$iv", "element$iv$iv", "interceptor$iv", "ctx$iv", WebViewMessageType.CONTEXT, "interceptor", "$i$f$modifyHttpRequestHook", "$i$a$-runCatching-InterceptorExecutor$modifyHttpRequestHook$modified$1$iv", "$i$f$fold", "$i$a$-fold-InterceptorExecutor$modifyHttpRequestHook$modified$1$1$iv", "$i$a$-modifyHttpRequestHook-InterceptorExecutor$modifyBeforeRetryLoop$2"}, m1614nl = {191}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "I$3", "I$4"}, m1616v = 2)
    static final class C37181 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ InterceptorExecutor<I, O> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37181(InterceptorExecutor<I, O> interceptorExecutor, Continuation<? super C37181> continuation) {
            super(continuation);
            this.this$0 = interceptorExecutor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.modifyBeforeRetryLoop(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeSerialization$1 */
    /* JADX INFO: compiled from: InterceptorExecutor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor", m1609f = "InterceptorExecutor.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {134}, m1612m = "modifyBeforeSerialization", m1613n = {"input", WebViewMessageType.CONTEXT, "$this$fold$iv", "initial$iv", "accumulator$iv", "element$iv", "interceptor", "ctx", "$i$f$fold", "$i$a$-fold-InterceptorExecutor$modifyBeforeSerialization$modified$1"}, m1614nl = {135}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "I$0", "I$1"}, m1616v = 2)
    static final class C37191 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ InterceptorExecutor<I, O> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37191(InterceptorExecutor<I, O> interceptorExecutor, Continuation<? super C37191> continuation) {
            super(continuation);
            this.this$0 = interceptorExecutor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.modifyBeforeSerialization(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeSigning$1 */
    /* JADX INFO: compiled from: InterceptorExecutor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor", m1609f = "InterceptorExecutor.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {206}, m1612m = "modifyBeforeSigning", m1613n = {"request", "this_$iv", "request$iv", "input$iv", "context$iv", "$this$modifyHttpRequestHook_u24lambda_u240$iv", "$this$fold$iv$iv", "initial$iv$iv", "accumulator$iv$iv", "element$iv$iv", "interceptor$iv", "ctx$iv", WebViewMessageType.CONTEXT, "interceptor", "$i$f$modifyHttpRequestHook", "$i$a$-runCatching-InterceptorExecutor$modifyHttpRequestHook$modified$1$iv", "$i$f$fold", "$i$a$-fold-InterceptorExecutor$modifyHttpRequestHook$modified$1$1$iv", "$i$a$-modifyHttpRequestHook-InterceptorExecutor$modifyBeforeSigning$2"}, m1614nl = {207}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "I$3", "I$4"}, m1616v = 2)
    static final class C37201 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ InterceptorExecutor<I, O> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37201(InterceptorExecutor<I, O> interceptorExecutor, Continuation<? super C37201> continuation) {
            super(continuation);
            this.this$0 = interceptorExecutor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.modifyBeforeSigning(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeTransmit$1 */
    /* JADX INFO: compiled from: InterceptorExecutor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor", m1609f = "InterceptorExecutor.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {220}, m1612m = "modifyBeforeTransmit", m1613n = {"request", "this_$iv", "request$iv", "input$iv", "context$iv", "$this$modifyHttpRequestHook_u24lambda_u240$iv", "$this$fold$iv$iv", "initial$iv$iv", "accumulator$iv$iv", "element$iv$iv", "interceptor$iv", "ctx$iv", WebViewMessageType.CONTEXT, "interceptor", "$i$f$modifyHttpRequestHook", "$i$a$-runCatching-InterceptorExecutor$modifyHttpRequestHook$modified$1$iv", "$i$f$fold", "$i$a$-fold-InterceptorExecutor$modifyHttpRequestHook$modified$1$1$iv", "$i$a$-modifyHttpRequestHook-InterceptorExecutor$modifyBeforeTransmit$2"}, m1614nl = {PDFACompliance.e_PDFA2_2_1}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "I$3", "I$4"}, m1616v = 2)
    static final class C37211 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ InterceptorExecutor<I, O> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37211(InterceptorExecutor<I, O> interceptorExecutor, Continuation<? super C37211> continuation) {
            super(continuation);
            this.this$0 = interceptorExecutor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.modifyBeforeTransmit(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InterceptorExecutor(ExecutionContext execContext, List<? extends Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors, OperationTypeInfo typeInfo) {
        Intrinsics.checkNotNullParameter(execContext, "execContext");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(typeInfo, "typeInfo");
        this.execContext = execContext;
        this.interceptors = interceptors;
        this.typeInfo = typeInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T checkType(String phase, KClass<?> expected, Object actual) {
        if (expected.isInstance(actual)) {
            return actual;
        }
        throw new IllegalStateException((phase + " invalid type conversion: found " + Reflection.getOrCreateKotlinClass(actual.getClass()) + "; expected " + expected).toString());
    }

    /* JADX INFO: renamed from: checkResultType-mYkaXTg, reason: not valid java name */
    private final <T> Object m12208checkResultTypemYkaXTg(String phase, Object result, KClass<?> expected) {
        if (!Result.m14506isSuccessimpl(result)) {
            return Result.m14499constructorimpl(result);
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m14499constructorimpl(checkType(phase, expected, result));
    }

    /* JADX INFO: renamed from: executeAll-IoAF18A, reason: not valid java name */
    private final Object m12209executeAllIoAF18A(Function1<? super Interceptor<Object, Object, HttpRequest, HttpResponse>, Unit> block) {
        Object objM14499constructorimpl;
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list = this.interceptors;
        Result.Companion companion = Result.INSTANCE;
        Object objM14499constructorimpl2 = Result.m14499constructorimpl(Unit.INSTANCE);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Interceptor interceptor = (Interceptor) it.next();
            try {
                Result.Companion companion2 = Result.INSTANCE;
                InterceptorExecutor<I, O> interceptorExecutor = this;
                block.invoke(interceptor);
                objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
            if (thM14502exceptionOrNullimpl == null) {
            } else {
                Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                if (thM14502exceptionOrNullimpl2 != null) {
                    ExceptionsKt.addSuppressed(thM14502exceptionOrNullimpl, thM14502exceptionOrNullimpl2);
                }
                Result.Companion companion4 = Result.INSTANCE;
                objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(thM14502exceptionOrNullimpl));
            }
        }
        return objM14499constructorimpl2;
    }

    /* JADX INFO: renamed from: readBeforeExecution-IoAF18A, reason: not valid java name */
    public final Object m12214readBeforeExecutionIoAF18A(I input) {
        Object objM14499constructorimpl;
        this._lastInput = input;
        Intrinsics.checkNotNull(input, "null cannot be cast to non-null type kotlin.Any");
        HttpInputInterceptorContext httpInputInterceptorContext = new HttpInputInterceptorContext(input, this.execContext);
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list = this.interceptors;
        Result.Companion companion = Result.INSTANCE;
        Object objM14499constructorimpl2 = Result.m14499constructorimpl(Unit.INSTANCE);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Interceptor interceptor = (Interceptor) it.next();
            try {
                Result.Companion companion2 = Result.INSTANCE;
                InterceptorExecutor<I, O> interceptorExecutor = this;
                interceptor.readBeforeExecution(httpInputInterceptorContext);
                objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
            if (thM14502exceptionOrNullimpl == null) {
            } else {
                Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                if (thM14502exceptionOrNullimpl2 != null) {
                    ExceptionsKt.addSuppressed(thM14502exceptionOrNullimpl, thM14502exceptionOrNullimpl2);
                }
                Result.Companion companion4 = Result.INSTANCE;
                objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(thM14502exceptionOrNullimpl));
            }
        }
        return objM14499constructorimpl2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v5, types: [aws.smithy.kotlin.runtime.http.interceptors.HttpInputInterceptorContext] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00cc -> B:12:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object modifyBeforeSerialization(I i, Continuation<? super I> continuation) {
        C37191 c37191;
        Iterator it;
        HttpInputInterceptorContext httpInputInterceptorContext;
        Iterable iterable;
        HttpInputInterceptorContext httpInputInterceptorContext2;
        int i2;
        ?? r11;
        Object obj = i;
        if (continuation instanceof C37191) {
            c37191 = (C37191) continuation;
            if ((c37191.label & Integer.MIN_VALUE) != 0) {
                c37191.label -= Integer.MIN_VALUE;
            } else {
                c37191 = new C37191(this, continuation);
            }
        }
        Object obj2 = c37191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c37191.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj2);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            HttpInputInterceptorContext httpInputInterceptorContext3 = new HttpInputInterceptorContext(obj, this.execContext);
            List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list = this.interceptors;
            it = list.iterator();
            httpInputInterceptorContext = httpInputInterceptorContext3;
            HttpInputInterceptorContext httpInputInterceptorContext4 = httpInputInterceptorContext;
            iterable = list;
            httpInputInterceptorContext2 = httpInputInterceptorContext4;
            i2 = 0;
            r11 = httpInputInterceptorContext4;
            if (it.hasNext()) {
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = c37191.I$1;
            int i5 = c37191.I$0;
            HttpInputInterceptorContext httpInputInterceptorContext5 = (HttpInputInterceptorContext) c37191.L$8;
            Object obj3 = c37191.L$6;
            it = (Iterator) c37191.L$5;
            httpInputInterceptorContext = (HttpInputInterceptorContext) c37191.L$3;
            iterable = (Iterable) c37191.L$2;
            HttpInputInterceptorContext httpInputInterceptorContext6 = (HttpInputInterceptorContext) c37191.L$1;
            Object obj4 = c37191.L$0;
            ResultKt.throwOnFailure(obj2);
            C37191 c371912 = c37191;
            int i6 = i5;
            obj = obj4;
            HttpInputInterceptorContext httpInputInterceptorContext7 = httpInputInterceptorContext5;
            ?? r112 = httpInputInterceptorContext6;
            ?? r12 = r112;
            Iterable iterable2 = iterable;
            HttpInputInterceptorContext httpInputInterceptorContext8 = httpInputInterceptorContext;
            Iterator it2 = it;
            HttpInputInterceptorContext httpInputInterceptorContext9 = httpInputInterceptorContext7;
            C37191 c371913 = c371912;
            checkType("modifyBeforeSerialization", this.typeInfo.getInputType(), obj2);
            r12.setRequest(obj2);
            i2 = i6;
            c37191 = c371913;
            httpInputInterceptorContext2 = httpInputInterceptorContext9;
            it = it2;
            httpInputInterceptorContext = httpInputInterceptorContext8;
            iterable = iterable2;
            r11 = r12;
            if (it.hasNext()) {
                Object next = it.next();
                Interceptor interceptor = (Interceptor) next;
                c37191.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                c37191.L$1 = r11;
                c37191.L$2 = SpillingKt.nullOutSpilledVariable(iterable);
                c37191.L$3 = SpillingKt.nullOutSpilledVariable(httpInputInterceptorContext);
                c37191.L$4 = SpillingKt.nullOutSpilledVariable(httpInputInterceptorContext2);
                c37191.L$5 = it;
                c37191.L$6 = SpillingKt.nullOutSpilledVariable(next);
                c37191.L$7 = SpillingKt.nullOutSpilledVariable(interceptor);
                c37191.L$8 = httpInputInterceptorContext2;
                c37191.I$0 = i2;
                c37191.I$1 = 0;
                c37191.label = 1;
                Object objModifyBeforeSerialization = interceptor.modifyBeforeSerialization(httpInputInterceptorContext2, c37191);
                if (objModifyBeforeSerialization == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c371912 = c37191;
                i6 = i2;
                obj2 = objModifyBeforeSerialization;
                httpInputInterceptorContext7 = httpInputInterceptorContext2;
                r112 = r11;
                ?? r122 = r112;
                Iterable iterable22 = iterable;
                HttpInputInterceptorContext httpInputInterceptorContext82 = httpInputInterceptorContext;
                Iterator it22 = it;
                HttpInputInterceptorContext httpInputInterceptorContext92 = httpInputInterceptorContext7;
                C37191 c3719132 = c371912;
                checkType("modifyBeforeSerialization", this.typeInfo.getInputType(), obj2);
                r122.setRequest(obj2);
                i2 = i6;
                c37191 = c3719132;
                httpInputInterceptorContext2 = httpInputInterceptorContext92;
                it = it22;
                httpInputInterceptorContext = httpInputInterceptorContext82;
                iterable = iterable22;
                r11 = r122;
                if (it.hasNext()) {
                    return httpInputInterceptorContext2.getRequest();
                }
            }
        }
    }

    public final void readBeforeSerialization(I input) {
        this._lastInput = input;
        Intrinsics.checkNotNull(input, "null cannot be cast to non-null type kotlin.Any");
        HttpInputInterceptorContext httpInputInterceptorContext = new HttpInputInterceptorContext(input, this.execContext);
        Iterator<T> it = this.interceptors.iterator();
        while (it.hasNext()) {
            ((Interceptor) it.next()).readBeforeSerialization(httpInputInterceptorContext);
        }
    }

    private final void readHttpHook(HttpRequest request, Function2<? super Interceptor<Object, Object, HttpRequest, HttpResponse>, ? super HttpProtocolRequestInterceptorContext<Object>, Unit> block) {
        this._lastHttpRequest = request;
        I i = this._lastInput;
        if (i == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Any");
        HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext = new HttpProtocolRequestInterceptorContext(i, request, this.execContext);
        Iterator<T> it = this.interceptors.iterator();
        while (it.hasNext()) {
            block.invoke((Interceptor) it.next(), httpProtocolRequestInterceptorContext);
        }
    }

    private final void readHttpHook(HttpRequest request, HttpResponse response, Function2<? super Interceptor<Object, Object, HttpRequest, HttpResponse>, ? super HttpProtocolResponseInterceptorContext<Object>, Unit> block) {
        I i = this._lastInput;
        if (i == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Any");
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext = new HttpProtocolResponseInterceptorContext(i, request, response, this.execContext);
        Iterator<T> it = this.interceptors.iterator();
        while (it.hasNext()) {
            block.invoke((Interceptor) it.next(), httpProtocolResponseInterceptorContext);
        }
    }

    private final HttpRequest modifyHttpRequestHook(HttpRequest request, Function2<? super Interceptor<Object, Object, HttpRequest, HttpResponse>, ? super HttpProtocolRequestInterceptorContext<Object>, ? extends HttpRequest> block) {
        Object objM14499constructorimpl;
        I i = this._lastInput;
        if (i == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Any");
        HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext = new HttpProtocolRequestInterceptorContext(i, request, this.execContext);
        try {
            Result.Companion companion = Result.INSTANCE;
            InterceptorExecutor<I, O> interceptorExecutor = this;
            Iterator<T> it = this.interceptors.iterator();
            while (it.hasNext()) {
                httpProtocolRequestInterceptorContext.setProtocolRequest(block.invoke((Interceptor) it.next(), httpProtocolRequestInterceptorContext));
            }
            objM14499constructorimpl = Result.m14499constructorimpl(httpProtocolRequestInterceptorContext);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        ResultKt.throwOnFailure(objM14499constructorimpl);
        return ((HttpProtocolRequestInterceptorContext) objM14499constructorimpl).getProtocolRequest();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d2 A[Catch: all -> 0x0090, TryCatch #0 {all -> 0x0090, blocks: (B:12:0x0076, B:29:0x0152, B:23:0x00cc, B:25:0x00d2, B:30:0x016f, B:22:0x00b2), top: B:37:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x016f A[Catch: all -> 0x0090, TRY_LEAVE, TryCatch #0 {all -> 0x0090, blocks: (B:12:0x0076, B:29:0x0152, B:23:0x00cc, B:25:0x00d2, B:30:0x016f, B:22:0x00b2), top: B:37:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0140 -> B:14:0x008c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object modifyBeforeRetryLoop(HttpRequest httpRequest, Continuation<? super HttpRequest> continuation) {
        C37181 c37181;
        Object objM14499constructorimpl;
        HttpRequest httpRequest2;
        InterceptorExecutor<I, O> interceptorExecutor;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext2;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext3;
        Iterable iterable;
        Iterator it;
        int i;
        int i2;
        int i3;
        Object obj;
        C37181 c371812;
        HttpRequest httpRequest3;
        InterceptorExecutor<I, O> interceptorExecutor2;
        if (continuation instanceof C37181) {
            c37181 = (C37181) continuation;
            if ((c37181.label & Integer.MIN_VALUE) != 0) {
                c37181.label -= Integer.MIN_VALUE;
            } else {
                c37181 = new C37181(this, continuation);
            }
        }
        Object obj2 = c37181.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c37181.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj2);
            I i5 = this._lastInput;
            if (i5 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Intrinsics.checkNotNull(i5, "null cannot be cast to non-null type kotlin.Any");
            httpRequest2 = httpRequest;
            HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext4 = new HttpProtocolRequestInterceptorContext<>(i5, httpRequest2, this.execContext);
            Result.Companion companion2 = Result.INSTANCE;
            InterceptorExecutor<I, O> interceptorExecutor3 = this;
            List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list = this.interceptors;
            interceptorExecutor = this;
            httpProtocolRequestInterceptorContext = httpProtocolRequestInterceptorContext4;
            httpProtocolRequestInterceptorContext2 = httpProtocolRequestInterceptorContext;
            httpProtocolRequestInterceptorContext3 = httpProtocolRequestInterceptorContext2;
            iterable = list;
            it = list.iterator();
            i = 0;
            i2 = 0;
            i3 = 0;
            obj = i5;
            c371812 = c37181;
            httpRequest3 = httpRequest2;
            interceptorExecutor2 = interceptorExecutor;
            if (it.hasNext()) {
            }
            ResultKt.throwOnFailure(objM14499constructorimpl);
            return ((HttpProtocolRequestInterceptorContext) objM14499constructorimpl).getProtocolRequest();
        }
        if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i6 = c37181.I$4;
        int i7 = c37181.I$3;
        int i8 = c37181.I$2;
        int i9 = c37181.I$1;
        int i10 = c37181.I$0;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext5 = (HttpProtocolRequestInterceptorContext) c37181.L$15;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext6 = (HttpProtocolRequestInterceptorContext) c37181.L$13;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext7 = (HttpProtocolRequestInterceptorContext) c37181.L$12;
        Object obj3 = c37181.L$10;
        Iterator it2 = (Iterator) c37181.L$9;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext8 = (HttpProtocolRequestInterceptorContext) c37181.L$7;
        Iterable iterable2 = (Iterable) c37181.L$6;
        InterceptorExecutor<I, O> interceptorExecutor4 = (InterceptorExecutor) c37181.L$5;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext9 = (HttpProtocolRequestInterceptorContext) c37181.L$4;
        Object obj4 = c37181.L$3;
        HttpRequest httpRequest4 = (HttpRequest) c37181.L$2;
        InterceptorExecutor<I, O> interceptorExecutor5 = (InterceptorExecutor) c37181.L$1;
        HttpRequest httpRequest5 = (HttpRequest) c37181.L$0;
        ResultKt.throwOnFailure(obj2);
        Iterable iterable3 = iterable2;
        InterceptorExecutor<I, O> interceptorExecutor6 = interceptorExecutor4;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext10 = httpProtocolRequestInterceptorContext7;
        Iterator it3 = it2;
        int i11 = i10;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext11 = httpProtocolRequestInterceptorContext6;
        Object obj5 = obj4;
        httpProtocolRequestInterceptorContext = httpProtocolRequestInterceptorContext5;
        int i12 = i9;
        HttpRequest httpRequest6 = httpRequest5;
        Object objModifyBeforeRetryLoop = obj2;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext12 = httpProtocolRequestInterceptorContext8;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext13 = httpProtocolRequestInterceptorContext9;
        i = i8;
        c371812 = c37181;
        HttpRequest httpRequest7 = httpRequest4;
        updateBusinessMetrics(httpRequest6, (HttpRequest) objModifyBeforeRetryLoop, httpProtocolRequestInterceptorContext11);
        httpProtocolRequestInterceptorContext.setProtocolRequest((HttpRequest) objModifyBeforeRetryLoop);
        httpRequest3 = httpRequest7;
        httpRequest2 = httpRequest6;
        obj = obj5;
        i2 = i12;
        i3 = i11;
        httpProtocolRequestInterceptorContext = httpProtocolRequestInterceptorContext13;
        httpProtocolRequestInterceptorContext2 = httpProtocolRequestInterceptorContext10;
        it = it3;
        httpProtocolRequestInterceptorContext3 = httpProtocolRequestInterceptorContext12;
        interceptorExecutor2 = interceptorExecutor5;
        iterable = iterable3;
        interceptorExecutor = interceptorExecutor6;
        if (it.hasNext()) {
            Object next = it.next();
            httpRequest4 = httpRequest3;
            Interceptor interceptor = (Interceptor) next;
            interceptorExecutor5 = interceptorExecutor2;
            c371812.L$0 = httpRequest2;
            HttpRequest httpRequest8 = httpRequest2;
            c371812.L$1 = SpillingKt.nullOutSpilledVariable(interceptorExecutor5);
            c371812.L$2 = SpillingKt.nullOutSpilledVariable(httpRequest4);
            c371812.L$3 = SpillingKt.nullOutSpilledVariable(obj);
            c371812.L$4 = httpProtocolRequestInterceptorContext;
            c371812.L$5 = SpillingKt.nullOutSpilledVariable(interceptorExecutor);
            c371812.L$6 = SpillingKt.nullOutSpilledVariable(iterable);
            c371812.L$7 = SpillingKt.nullOutSpilledVariable(httpProtocolRequestInterceptorContext3);
            c371812.L$8 = SpillingKt.nullOutSpilledVariable(httpProtocolRequestInterceptorContext2);
            c371812.L$9 = it;
            c371812.L$10 = SpillingKt.nullOutSpilledVariable(next);
            c371812.L$11 = SpillingKt.nullOutSpilledVariable(interceptor);
            c371812.L$12 = httpProtocolRequestInterceptorContext2;
            c371812.L$13 = httpProtocolRequestInterceptorContext;
            c371812.L$14 = SpillingKt.nullOutSpilledVariable(interceptor);
            c371812.L$15 = httpProtocolRequestInterceptorContext;
            c371812.I$0 = i3;
            c371812.I$1 = i2;
            c371812.I$2 = i;
            c371812.I$3 = 0;
            c371812.I$4 = 0;
            c371812.label = 1;
            objModifyBeforeRetryLoop = interceptor.modifyBeforeRetryLoop(httpProtocolRequestInterceptorContext, c371812);
            if (objModifyBeforeRetryLoop == coroutine_suspended) {
                return coroutine_suspended;
            }
            int i13 = i2;
            obj5 = obj;
            httpRequest6 = httpRequest8;
            iterable3 = iterable;
            httpProtocolRequestInterceptorContext10 = httpProtocolRequestInterceptorContext2;
            i11 = i3;
            i12 = i13;
            httpProtocolRequestInterceptorContext12 = httpProtocolRequestInterceptorContext3;
            interceptorExecutor6 = interceptorExecutor;
            httpProtocolRequestInterceptorContext13 = httpProtocolRequestInterceptorContext;
            it3 = it;
            httpProtocolRequestInterceptorContext11 = httpProtocolRequestInterceptorContext13;
            HttpRequest httpRequest72 = httpRequest4;
            updateBusinessMetrics(httpRequest6, (HttpRequest) objModifyBeforeRetryLoop, httpProtocolRequestInterceptorContext11);
            httpProtocolRequestInterceptorContext.setProtocolRequest((HttpRequest) objModifyBeforeRetryLoop);
            httpRequest3 = httpRequest72;
            httpRequest2 = httpRequest6;
            obj = obj5;
            i2 = i12;
            i3 = i11;
            httpProtocolRequestInterceptorContext = httpProtocolRequestInterceptorContext13;
            httpProtocolRequestInterceptorContext2 = httpProtocolRequestInterceptorContext10;
            it = it3;
            httpProtocolRequestInterceptorContext3 = httpProtocolRequestInterceptorContext12;
            interceptorExecutor2 = interceptorExecutor5;
            iterable = iterable3;
            interceptorExecutor = interceptorExecutor6;
            if (it.hasNext()) {
                objM14499constructorimpl = Result.m14499constructorimpl(httpProtocolRequestInterceptorContext2);
            }
        }
        ResultKt.throwOnFailure(objM14499constructorimpl);
        return ((HttpProtocolRequestInterceptorContext) objM14499constructorimpl).getProtocolRequest();
    }

    /* JADX INFO: renamed from: readBeforeAttempt-IoAF18A, reason: not valid java name */
    public final Object m12213readBeforeAttemptIoAF18A(HttpRequest request) {
        Object objM14499constructorimpl;
        Intrinsics.checkNotNullParameter(request, "request");
        this._lastHttpResponse = null;
        I i = this._lastInput;
        if (i == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Any");
        HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext = new HttpProtocolRequestInterceptorContext(i, request, this.execContext);
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list = this.interceptors;
        Result.Companion companion = Result.INSTANCE;
        Object objM14499constructorimpl2 = Result.m14499constructorimpl(Unit.INSTANCE);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Interceptor interceptor = (Interceptor) it.next();
            try {
                Result.Companion companion2 = Result.INSTANCE;
                InterceptorExecutor<I, O> interceptorExecutor = this;
                interceptor.readBeforeAttempt(httpProtocolRequestInterceptorContext);
                objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
            if (thM14502exceptionOrNullimpl == null) {
            } else {
                Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                if (thM14502exceptionOrNullimpl2 != null) {
                    ExceptionsKt.addSuppressed(thM14502exceptionOrNullimpl, thM14502exceptionOrNullimpl2);
                }
                Result.Companion companion4 = Result.INSTANCE;
                objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(thM14502exceptionOrNullimpl));
            }
        }
        return objM14499constructorimpl2;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d2 A[Catch: all -> 0x0090, TryCatch #0 {all -> 0x0090, blocks: (B:12:0x0076, B:29:0x0152, B:23:0x00cc, B:25:0x00d2, B:30:0x016f, B:22:0x00b2), top: B:37:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x016f A[Catch: all -> 0x0090, TRY_LEAVE, TryCatch #0 {all -> 0x0090, blocks: (B:12:0x0076, B:29:0x0152, B:23:0x00cc, B:25:0x00d2, B:30:0x016f, B:22:0x00b2), top: B:37:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0140 -> B:14:0x008c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object modifyBeforeSigning(HttpRequest httpRequest, Continuation<? super HttpRequest> continuation) {
        C37201 c37201;
        Object objM14499constructorimpl;
        HttpRequest httpRequest2;
        InterceptorExecutor<I, O> interceptorExecutor;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext2;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext3;
        Iterable iterable;
        Iterator it;
        int i;
        int i2;
        int i3;
        Object obj;
        C37201 c372012;
        HttpRequest httpRequest3;
        InterceptorExecutor<I, O> interceptorExecutor2;
        if (continuation instanceof C37201) {
            c37201 = (C37201) continuation;
            if ((c37201.label & Integer.MIN_VALUE) != 0) {
                c37201.label -= Integer.MIN_VALUE;
            } else {
                c37201 = new C37201(this, continuation);
            }
        }
        Object obj2 = c37201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c37201.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj2);
            I i5 = this._lastInput;
            if (i5 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Intrinsics.checkNotNull(i5, "null cannot be cast to non-null type kotlin.Any");
            httpRequest2 = httpRequest;
            HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext4 = new HttpProtocolRequestInterceptorContext<>(i5, httpRequest2, this.execContext);
            Result.Companion companion2 = Result.INSTANCE;
            InterceptorExecutor<I, O> interceptorExecutor3 = this;
            List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list = this.interceptors;
            interceptorExecutor = this;
            httpProtocolRequestInterceptorContext = httpProtocolRequestInterceptorContext4;
            httpProtocolRequestInterceptorContext2 = httpProtocolRequestInterceptorContext;
            httpProtocolRequestInterceptorContext3 = httpProtocolRequestInterceptorContext2;
            iterable = list;
            it = list.iterator();
            i = 0;
            i2 = 0;
            i3 = 0;
            obj = i5;
            c372012 = c37201;
            httpRequest3 = httpRequest2;
            interceptorExecutor2 = interceptorExecutor;
            if (it.hasNext()) {
            }
            ResultKt.throwOnFailure(objM14499constructorimpl);
            return ((HttpProtocolRequestInterceptorContext) objM14499constructorimpl).getProtocolRequest();
        }
        if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i6 = c37201.I$4;
        int i7 = c37201.I$3;
        int i8 = c37201.I$2;
        int i9 = c37201.I$1;
        int i10 = c37201.I$0;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext5 = (HttpProtocolRequestInterceptorContext) c37201.L$15;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext6 = (HttpProtocolRequestInterceptorContext) c37201.L$13;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext7 = (HttpProtocolRequestInterceptorContext) c37201.L$12;
        Object obj3 = c37201.L$10;
        Iterator it2 = (Iterator) c37201.L$9;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext8 = (HttpProtocolRequestInterceptorContext) c37201.L$7;
        Iterable iterable2 = (Iterable) c37201.L$6;
        InterceptorExecutor<I, O> interceptorExecutor4 = (InterceptorExecutor) c37201.L$5;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext9 = (HttpProtocolRequestInterceptorContext) c37201.L$4;
        Object obj4 = c37201.L$3;
        HttpRequest httpRequest4 = (HttpRequest) c37201.L$2;
        InterceptorExecutor<I, O> interceptorExecutor5 = (InterceptorExecutor) c37201.L$1;
        HttpRequest httpRequest5 = (HttpRequest) c37201.L$0;
        ResultKt.throwOnFailure(obj2);
        Iterable iterable3 = iterable2;
        InterceptorExecutor<I, O> interceptorExecutor6 = interceptorExecutor4;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext10 = httpProtocolRequestInterceptorContext7;
        Iterator it3 = it2;
        int i11 = i10;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext11 = httpProtocolRequestInterceptorContext6;
        Object obj5 = obj4;
        httpProtocolRequestInterceptorContext = httpProtocolRequestInterceptorContext5;
        int i12 = i9;
        HttpRequest httpRequest6 = httpRequest5;
        Object objModifyBeforeSigning = obj2;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext12 = httpProtocolRequestInterceptorContext8;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext13 = httpProtocolRequestInterceptorContext9;
        i = i8;
        c372012 = c37201;
        HttpRequest httpRequest7 = httpRequest4;
        updateBusinessMetrics(httpRequest6, (HttpRequest) objModifyBeforeSigning, httpProtocolRequestInterceptorContext11);
        httpProtocolRequestInterceptorContext.setProtocolRequest((HttpRequest) objModifyBeforeSigning);
        httpRequest3 = httpRequest7;
        httpRequest2 = httpRequest6;
        obj = obj5;
        i2 = i12;
        i3 = i11;
        httpProtocolRequestInterceptorContext = httpProtocolRequestInterceptorContext13;
        httpProtocolRequestInterceptorContext2 = httpProtocolRequestInterceptorContext10;
        it = it3;
        httpProtocolRequestInterceptorContext3 = httpProtocolRequestInterceptorContext12;
        interceptorExecutor2 = interceptorExecutor5;
        iterable = iterable3;
        interceptorExecutor = interceptorExecutor6;
        if (it.hasNext()) {
            Object next = it.next();
            httpRequest4 = httpRequest3;
            Interceptor interceptor = (Interceptor) next;
            interceptorExecutor5 = interceptorExecutor2;
            c372012.L$0 = httpRequest2;
            HttpRequest httpRequest8 = httpRequest2;
            c372012.L$1 = SpillingKt.nullOutSpilledVariable(interceptorExecutor5);
            c372012.L$2 = SpillingKt.nullOutSpilledVariable(httpRequest4);
            c372012.L$3 = SpillingKt.nullOutSpilledVariable(obj);
            c372012.L$4 = httpProtocolRequestInterceptorContext;
            c372012.L$5 = SpillingKt.nullOutSpilledVariable(interceptorExecutor);
            c372012.L$6 = SpillingKt.nullOutSpilledVariable(iterable);
            c372012.L$7 = SpillingKt.nullOutSpilledVariable(httpProtocolRequestInterceptorContext3);
            c372012.L$8 = SpillingKt.nullOutSpilledVariable(httpProtocolRequestInterceptorContext2);
            c372012.L$9 = it;
            c372012.L$10 = SpillingKt.nullOutSpilledVariable(next);
            c372012.L$11 = SpillingKt.nullOutSpilledVariable(interceptor);
            c372012.L$12 = httpProtocolRequestInterceptorContext2;
            c372012.L$13 = httpProtocolRequestInterceptorContext;
            c372012.L$14 = SpillingKt.nullOutSpilledVariable(interceptor);
            c372012.L$15 = httpProtocolRequestInterceptorContext;
            c372012.I$0 = i3;
            c372012.I$1 = i2;
            c372012.I$2 = i;
            c372012.I$3 = 0;
            c372012.I$4 = 0;
            c372012.label = 1;
            objModifyBeforeSigning = interceptor.modifyBeforeSigning(httpProtocolRequestInterceptorContext, c372012);
            if (objModifyBeforeSigning == coroutine_suspended) {
                return coroutine_suspended;
            }
            int i13 = i2;
            obj5 = obj;
            httpRequest6 = httpRequest8;
            iterable3 = iterable;
            httpProtocolRequestInterceptorContext10 = httpProtocolRequestInterceptorContext2;
            i11 = i3;
            i12 = i13;
            httpProtocolRequestInterceptorContext12 = httpProtocolRequestInterceptorContext3;
            interceptorExecutor6 = interceptorExecutor;
            httpProtocolRequestInterceptorContext13 = httpProtocolRequestInterceptorContext;
            it3 = it;
            httpProtocolRequestInterceptorContext11 = httpProtocolRequestInterceptorContext13;
            HttpRequest httpRequest72 = httpRequest4;
            updateBusinessMetrics(httpRequest6, (HttpRequest) objModifyBeforeSigning, httpProtocolRequestInterceptorContext11);
            httpProtocolRequestInterceptorContext.setProtocolRequest((HttpRequest) objModifyBeforeSigning);
            httpRequest3 = httpRequest72;
            httpRequest2 = httpRequest6;
            obj = obj5;
            i2 = i12;
            i3 = i11;
            httpProtocolRequestInterceptorContext = httpProtocolRequestInterceptorContext13;
            httpProtocolRequestInterceptorContext2 = httpProtocolRequestInterceptorContext10;
            it = it3;
            httpProtocolRequestInterceptorContext3 = httpProtocolRequestInterceptorContext12;
            interceptorExecutor2 = interceptorExecutor5;
            iterable = iterable3;
            interceptorExecutor = interceptorExecutor6;
            if (it.hasNext()) {
                objM14499constructorimpl = Result.m14499constructorimpl(httpProtocolRequestInterceptorContext2);
            }
        }
        ResultKt.throwOnFailure(objM14499constructorimpl);
        return ((HttpProtocolRequestInterceptorContext) objM14499constructorimpl).getProtocolRequest();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d2 A[Catch: all -> 0x0090, TryCatch #0 {all -> 0x0090, blocks: (B:12:0x0076, B:29:0x0152, B:23:0x00cc, B:25:0x00d2, B:30:0x016f, B:22:0x00b2), top: B:37:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x016f A[Catch: all -> 0x0090, TRY_LEAVE, TryCatch #0 {all -> 0x0090, blocks: (B:12:0x0076, B:29:0x0152, B:23:0x00cc, B:25:0x00d2, B:30:0x016f, B:22:0x00b2), top: B:37:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0140 -> B:14:0x008c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object modifyBeforeTransmit(HttpRequest httpRequest, Continuation<? super HttpRequest> continuation) {
        C37211 c37211;
        Object objM14499constructorimpl;
        HttpRequest httpRequest2;
        InterceptorExecutor<I, O> interceptorExecutor;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext2;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext3;
        Iterable iterable;
        Iterator it;
        int i;
        int i2;
        int i3;
        Object obj;
        C37211 c372112;
        HttpRequest httpRequest3;
        InterceptorExecutor<I, O> interceptorExecutor2;
        if (continuation instanceof C37211) {
            c37211 = (C37211) continuation;
            if ((c37211.label & Integer.MIN_VALUE) != 0) {
                c37211.label -= Integer.MIN_VALUE;
            } else {
                c37211 = new C37211(this, continuation);
            }
        }
        Object obj2 = c37211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c37211.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj2);
            I i5 = this._lastInput;
            if (i5 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Intrinsics.checkNotNull(i5, "null cannot be cast to non-null type kotlin.Any");
            httpRequest2 = httpRequest;
            HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext4 = new HttpProtocolRequestInterceptorContext<>(i5, httpRequest2, this.execContext);
            Result.Companion companion2 = Result.INSTANCE;
            InterceptorExecutor<I, O> interceptorExecutor3 = this;
            List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list = this.interceptors;
            interceptorExecutor = this;
            httpProtocolRequestInterceptorContext = httpProtocolRequestInterceptorContext4;
            httpProtocolRequestInterceptorContext2 = httpProtocolRequestInterceptorContext;
            httpProtocolRequestInterceptorContext3 = httpProtocolRequestInterceptorContext2;
            iterable = list;
            it = list.iterator();
            i = 0;
            i2 = 0;
            i3 = 0;
            obj = i5;
            c372112 = c37211;
            httpRequest3 = httpRequest2;
            interceptorExecutor2 = interceptorExecutor;
            if (it.hasNext()) {
            }
            ResultKt.throwOnFailure(objM14499constructorimpl);
            return ((HttpProtocolRequestInterceptorContext) objM14499constructorimpl).getProtocolRequest();
        }
        if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i6 = c37211.I$4;
        int i7 = c37211.I$3;
        int i8 = c37211.I$2;
        int i9 = c37211.I$1;
        int i10 = c37211.I$0;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext5 = (HttpProtocolRequestInterceptorContext) c37211.L$15;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext6 = (HttpProtocolRequestInterceptorContext) c37211.L$13;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext7 = (HttpProtocolRequestInterceptorContext) c37211.L$12;
        Object obj3 = c37211.L$10;
        Iterator it2 = (Iterator) c37211.L$9;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext8 = (HttpProtocolRequestInterceptorContext) c37211.L$7;
        Iterable iterable2 = (Iterable) c37211.L$6;
        InterceptorExecutor<I, O> interceptorExecutor4 = (InterceptorExecutor) c37211.L$5;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext9 = (HttpProtocolRequestInterceptorContext) c37211.L$4;
        Object obj4 = c37211.L$3;
        HttpRequest httpRequest4 = (HttpRequest) c37211.L$2;
        InterceptorExecutor<I, O> interceptorExecutor5 = (InterceptorExecutor) c37211.L$1;
        HttpRequest httpRequest5 = (HttpRequest) c37211.L$0;
        ResultKt.throwOnFailure(obj2);
        Iterable iterable3 = iterable2;
        InterceptorExecutor<I, O> interceptorExecutor6 = interceptorExecutor4;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext10 = httpProtocolRequestInterceptorContext7;
        Iterator it3 = it2;
        int i11 = i10;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext11 = httpProtocolRequestInterceptorContext6;
        Object obj5 = obj4;
        httpProtocolRequestInterceptorContext = httpProtocolRequestInterceptorContext5;
        int i12 = i9;
        HttpRequest httpRequest6 = httpRequest5;
        Object objModifyBeforeTransmit = obj2;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext12 = httpProtocolRequestInterceptorContext8;
        HttpProtocolRequestInterceptorContext<Object> httpProtocolRequestInterceptorContext13 = httpProtocolRequestInterceptorContext9;
        i = i8;
        c372112 = c37211;
        HttpRequest httpRequest7 = httpRequest4;
        updateBusinessMetrics(httpRequest6, (HttpRequest) objModifyBeforeTransmit, httpProtocolRequestInterceptorContext11);
        httpProtocolRequestInterceptorContext.setProtocolRequest((HttpRequest) objModifyBeforeTransmit);
        httpRequest3 = httpRequest7;
        httpRequest2 = httpRequest6;
        obj = obj5;
        i2 = i12;
        i3 = i11;
        httpProtocolRequestInterceptorContext = httpProtocolRequestInterceptorContext13;
        httpProtocolRequestInterceptorContext2 = httpProtocolRequestInterceptorContext10;
        it = it3;
        httpProtocolRequestInterceptorContext3 = httpProtocolRequestInterceptorContext12;
        interceptorExecutor2 = interceptorExecutor5;
        iterable = iterable3;
        interceptorExecutor = interceptorExecutor6;
        if (it.hasNext()) {
            Object next = it.next();
            httpRequest4 = httpRequest3;
            Interceptor interceptor = (Interceptor) next;
            interceptorExecutor5 = interceptorExecutor2;
            c372112.L$0 = httpRequest2;
            HttpRequest httpRequest8 = httpRequest2;
            c372112.L$1 = SpillingKt.nullOutSpilledVariable(interceptorExecutor5);
            c372112.L$2 = SpillingKt.nullOutSpilledVariable(httpRequest4);
            c372112.L$3 = SpillingKt.nullOutSpilledVariable(obj);
            c372112.L$4 = httpProtocolRequestInterceptorContext;
            c372112.L$5 = SpillingKt.nullOutSpilledVariable(interceptorExecutor);
            c372112.L$6 = SpillingKt.nullOutSpilledVariable(iterable);
            c372112.L$7 = SpillingKt.nullOutSpilledVariable(httpProtocolRequestInterceptorContext3);
            c372112.L$8 = SpillingKt.nullOutSpilledVariable(httpProtocolRequestInterceptorContext2);
            c372112.L$9 = it;
            c372112.L$10 = SpillingKt.nullOutSpilledVariable(next);
            c372112.L$11 = SpillingKt.nullOutSpilledVariable(interceptor);
            c372112.L$12 = httpProtocolRequestInterceptorContext2;
            c372112.L$13 = httpProtocolRequestInterceptorContext;
            c372112.L$14 = SpillingKt.nullOutSpilledVariable(interceptor);
            c372112.L$15 = httpProtocolRequestInterceptorContext;
            c372112.I$0 = i3;
            c372112.I$1 = i2;
            c372112.I$2 = i;
            c372112.I$3 = 0;
            c372112.I$4 = 0;
            c372112.label = 1;
            objModifyBeforeTransmit = interceptor.modifyBeforeTransmit(httpProtocolRequestInterceptorContext, c372112);
            if (objModifyBeforeTransmit == coroutine_suspended) {
                return coroutine_suspended;
            }
            int i13 = i2;
            obj5 = obj;
            httpRequest6 = httpRequest8;
            iterable3 = iterable;
            httpProtocolRequestInterceptorContext10 = httpProtocolRequestInterceptorContext2;
            i11 = i3;
            i12 = i13;
            httpProtocolRequestInterceptorContext12 = httpProtocolRequestInterceptorContext3;
            interceptorExecutor6 = interceptorExecutor;
            httpProtocolRequestInterceptorContext13 = httpProtocolRequestInterceptorContext;
            it3 = it;
            httpProtocolRequestInterceptorContext11 = httpProtocolRequestInterceptorContext13;
            HttpRequest httpRequest72 = httpRequest4;
            updateBusinessMetrics(httpRequest6, (HttpRequest) objModifyBeforeTransmit, httpProtocolRequestInterceptorContext11);
            httpProtocolRequestInterceptorContext.setProtocolRequest((HttpRequest) objModifyBeforeTransmit);
            httpRequest3 = httpRequest72;
            httpRequest2 = httpRequest6;
            obj = obj5;
            i2 = i12;
            i3 = i11;
            httpProtocolRequestInterceptorContext = httpProtocolRequestInterceptorContext13;
            httpProtocolRequestInterceptorContext2 = httpProtocolRequestInterceptorContext10;
            it = it3;
            httpProtocolRequestInterceptorContext3 = httpProtocolRequestInterceptorContext12;
            interceptorExecutor2 = interceptorExecutor5;
            iterable = iterable3;
            interceptorExecutor = interceptorExecutor6;
            if (it.hasNext()) {
                objM14499constructorimpl = Result.m14499constructorimpl(httpProtocolRequestInterceptorContext2);
            }
        }
        ResultKt.throwOnFailure(objM14499constructorimpl);
        return ((HttpProtocolRequestInterceptorContext) objM14499constructorimpl).getProtocolRequest();
    }

    public final void readAfterTransmit(HttpCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        HttpRequest request = call.getRequest();
        HttpResponse response = call.getResponse();
        I i = this._lastInput;
        if (i == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Any");
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext = new HttpProtocolResponseInterceptorContext(i, request, response, this.execContext);
        Iterator<T> it = this.interceptors.iterator();
        while (it.hasNext()) {
            ((Interceptor) it.next()).readAfterTransmit(httpProtocolResponseInterceptorContext);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b4 A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:12:0x005c, B:28:0x0117, B:22:0x00ae, B:24:0x00b4, B:29:0x0129, B:21:0x0096), top: B:36:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0129 A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:12:0x005c, B:28:0x0117, B:22:0x00ae, B:24:0x00b4, B:29:0x0129, B:21:0x0096), top: B:36:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0109 -> B:28:0x0117). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object modifyBeforeDeserialization(HttpCall httpCall, Continuation<? super HttpResponse> continuation) {
        C37171 c37171;
        Object objM14499constructorimpl;
        Object obj;
        InterceptorExecutor<I, O> interceptorExecutor;
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext;
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext2;
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext3;
        Iterable iterable;
        Iterator it;
        int i;
        int i2;
        HttpCall httpCall2;
        if (continuation instanceof C37171) {
            c37171 = (C37171) continuation;
            if ((c37171.label & Integer.MIN_VALUE) != 0) {
                c37171.label -= Integer.MIN_VALUE;
            } else {
                c37171 = new C37171(this, continuation);
            }
        }
        Object obj2 = c37171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c37171.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj2);
            I i4 = this._lastInput;
            if (i4 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Intrinsics.checkNotNull(i4, "null cannot be cast to non-null type kotlin.Any");
            HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext4 = new HttpProtocolResponseInterceptorContext(i4, httpCall.getRequest(), httpCall.getResponse(), this.execContext);
            Result.Companion companion2 = Result.INSTANCE;
            InterceptorExecutor<I, O> interceptorExecutor2 = this;
            List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list = this.interceptors;
            obj = i4;
            interceptorExecutor = this;
            httpProtocolResponseInterceptorContext = httpProtocolResponseInterceptorContext4;
            httpProtocolResponseInterceptorContext2 = httpProtocolResponseInterceptorContext;
            httpProtocolResponseInterceptorContext3 = httpProtocolResponseInterceptorContext2;
            iterable = list;
            it = list.iterator();
            i = 0;
            i2 = 0;
            httpCall2 = httpCall;
            if (it.hasNext()) {
            }
            ResultKt.throwOnFailure(objM14499constructorimpl);
            return ((HttpProtocolResponseInterceptorContext) objM14499constructorimpl).getProtocolResponse();
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i5 = c37171.I$2;
        int i6 = c37171.I$1;
        int i7 = c37171.I$0;
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext5 = (HttpProtocolResponseInterceptorContext) c37171.L$11;
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext6 = (HttpProtocolResponseInterceptorContext) c37171.L$10;
        Object obj3 = c37171.L$8;
        Iterator it2 = (Iterator) c37171.L$7;
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext7 = (HttpProtocolResponseInterceptorContext) c37171.L$5;
        Iterable iterable2 = (Iterable) c37171.L$4;
        InterceptorExecutor<I, O> interceptorExecutor3 = (InterceptorExecutor) c37171.L$3;
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext8 = (HttpProtocolResponseInterceptorContext) c37171.L$2;
        Object obj4 = c37171.L$1;
        HttpCall httpCall3 = (HttpCall) c37171.L$0;
        ResultKt.throwOnFailure(obj2);
        Object objModifyBeforeDeserialization = obj2;
        Object obj5 = obj4;
        InterceptorExecutor<I, O> interceptorExecutor4 = interceptorExecutor3;
        Iterable iterable3 = iterable2;
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext9 = httpProtocolResponseInterceptorContext7;
        Iterator it3 = it2;
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext10 = httpProtocolResponseInterceptorContext6;
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext11 = httpProtocolResponseInterceptorContext5;
        int i8 = i7;
        int i9 = i6;
        C37171 c371712 = c37171;
        HttpCall httpCall4 = httpCall3;
        httpProtocolResponseInterceptorContext11.setProtocolResponse((HttpResponse) objModifyBeforeDeserialization);
        httpCall2 = httpCall4;
        c37171 = c371712;
        i = i9;
        i2 = i8;
        httpProtocolResponseInterceptorContext2 = httpProtocolResponseInterceptorContext10;
        it = it3;
        httpProtocolResponseInterceptorContext3 = httpProtocolResponseInterceptorContext9;
        iterable = iterable3;
        httpProtocolResponseInterceptorContext = httpProtocolResponseInterceptorContext8;
        interceptorExecutor = interceptorExecutor4;
        obj = obj5;
        if (it.hasNext()) {
            Object next = it.next();
            Interceptor interceptor = (Interceptor) next;
            HttpCall httpCall5 = httpCall2;
            c37171.L$0 = SpillingKt.nullOutSpilledVariable(httpCall5);
            c37171.L$1 = SpillingKt.nullOutSpilledVariable(obj);
            c37171.L$2 = httpProtocolResponseInterceptorContext;
            c37171.L$3 = SpillingKt.nullOutSpilledVariable(interceptorExecutor);
            c37171.L$4 = SpillingKt.nullOutSpilledVariable(iterable);
            c37171.L$5 = SpillingKt.nullOutSpilledVariable(httpProtocolResponseInterceptorContext3);
            c37171.L$6 = SpillingKt.nullOutSpilledVariable(httpProtocolResponseInterceptorContext2);
            c37171.L$7 = it;
            c37171.L$8 = SpillingKt.nullOutSpilledVariable(next);
            c37171.L$9 = SpillingKt.nullOutSpilledVariable(interceptor);
            c37171.L$10 = httpProtocolResponseInterceptorContext2;
            c37171.L$11 = httpProtocolResponseInterceptorContext;
            c37171.I$0 = i2;
            c37171.I$1 = i;
            c37171.I$2 = 0;
            c37171.label = 1;
            objModifyBeforeDeserialization = interceptor.modifyBeforeDeserialization(httpProtocolResponseInterceptorContext, c37171);
            if (objModifyBeforeDeserialization == coroutine_suspended) {
                return coroutine_suspended;
            }
            httpProtocolResponseInterceptorContext8 = httpProtocolResponseInterceptorContext;
            obj5 = obj;
            i8 = i2;
            interceptorExecutor4 = interceptorExecutor;
            i9 = i;
            iterable3 = iterable;
            c371712 = c37171;
            httpProtocolResponseInterceptorContext9 = httpProtocolResponseInterceptorContext3;
            httpCall4 = httpCall5;
            it3 = it;
            httpProtocolResponseInterceptorContext10 = httpProtocolResponseInterceptorContext2;
            httpProtocolResponseInterceptorContext11 = httpProtocolResponseInterceptorContext8;
            httpProtocolResponseInterceptorContext11.setProtocolResponse((HttpResponse) objModifyBeforeDeserialization);
            httpCall2 = httpCall4;
            c37171 = c371712;
            i = i9;
            i2 = i8;
            httpProtocolResponseInterceptorContext2 = httpProtocolResponseInterceptorContext10;
            it = it3;
            httpProtocolResponseInterceptorContext3 = httpProtocolResponseInterceptorContext9;
            iterable = iterable3;
            httpProtocolResponseInterceptorContext = httpProtocolResponseInterceptorContext8;
            interceptorExecutor = interceptorExecutor4;
            obj = obj5;
            if (it.hasNext()) {
                objM14499constructorimpl = Result.m14499constructorimpl(httpProtocolResponseInterceptorContext2);
            }
        }
        ResultKt.throwOnFailure(objM14499constructorimpl);
        return ((HttpProtocolResponseInterceptorContext) objM14499constructorimpl).getProtocolResponse();
    }

    public final void readBeforeDeserialization(HttpCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        HttpRequest request = call.getRequest();
        HttpResponse response = call.getResponse();
        I i = this._lastInput;
        if (i == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Any");
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext = new HttpProtocolResponseInterceptorContext(i, request, response, this.execContext);
        Iterator<T> it = this.interceptors.iterator();
        while (it.hasNext()) {
            ((Interceptor) it.next()).readBeforeDeserialization(httpProtocolResponseInterceptorContext);
        }
    }

    public final void readAfterDeserialization(O output, HttpCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        I i = this._lastInput;
        if (i == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Result.Companion companion = Result.INSTANCE;
        Intrinsics.checkNotNull(output, "null cannot be cast to non-null type kotlin.Any");
        Object objM14499constructorimpl = Result.m14499constructorimpl(output);
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Any");
        HttpInputOutputInterceptorContext httpInputOutputInterceptorContext = new HttpInputOutputInterceptorContext(i, objM14499constructorimpl, call, this.execContext);
        Iterator<T> it = this.interceptors.iterator();
        while (it.hasNext()) {
            ((Interceptor) it.next()).readAfterDeserialization(httpInputOutputInterceptorContext);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00cc A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:12:0x0062, B:28:0x0140, B:22:0x00c4, B:24:0x00cc, B:29:0x015a, B:21:0x00a9), top: B:39:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x015a A[Catch: all -> 0x0083, TRY_LEAVE, TryCatch #0 {all -> 0x0083, blocks: (B:12:0x0062, B:28:0x0140, B:22:0x00c4, B:24:0x00cc, B:29:0x015a, B:21:0x00a9), top: B:39:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0130 -> B:28:0x0140). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: modifyBeforeAttemptCompletion-3t6e044, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m12210modifyBeforeAttemptCompletion3t6e044(Object obj, HttpRequest httpRequest, HttpResponse httpResponse, Continuation<? super Result<? extends O>> continuation) {
        InterceptorExecutor$modifyBeforeAttemptCompletion$1 interceptorExecutor$modifyBeforeAttemptCompletion$1;
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Iterable iterable;
        InterceptorExecutor<I, O> interceptorExecutor;
        Iterator it;
        HttpAttemptInterceptorContext httpAttemptInterceptorContext;
        HttpAttemptInterceptorContext httpAttemptInterceptorContext2;
        HttpAttemptInterceptorContext httpAttemptInterceptorContext3;
        Object obj2;
        int i;
        int i2;
        HttpResponse httpResponse2;
        InterceptorExecutor$modifyBeforeAttemptCompletion$1 interceptorExecutor$modifyBeforeAttemptCompletion$12;
        HttpRequest httpRequest2;
        if (continuation instanceof InterceptorExecutor$modifyBeforeAttemptCompletion$1) {
            interceptorExecutor$modifyBeforeAttemptCompletion$1 = (InterceptorExecutor$modifyBeforeAttemptCompletion$1) continuation;
            if ((interceptorExecutor$modifyBeforeAttemptCompletion$1.label & Integer.MIN_VALUE) != 0) {
                interceptorExecutor$modifyBeforeAttemptCompletion$1.label -= Integer.MIN_VALUE;
            } else {
                interceptorExecutor$modifyBeforeAttemptCompletion$1 = new InterceptorExecutor$modifyBeforeAttemptCompletion$1(this, continuation);
            }
        }
        Object obj3 = interceptorExecutor$modifyBeforeAttemptCompletion$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = interceptorExecutor$modifyBeforeAttemptCompletion$1.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = interceptorExecutor$modifyBeforeAttemptCompletion$1.I$2;
            int i5 = interceptorExecutor$modifyBeforeAttemptCompletion$1.I$1;
            int i6 = interceptorExecutor$modifyBeforeAttemptCompletion$1.I$0;
            HttpAttemptInterceptorContext httpAttemptInterceptorContext4 = (HttpAttemptInterceptorContext) interceptorExecutor$modifyBeforeAttemptCompletion$1.L$12;
            Object obj4 = interceptorExecutor$modifyBeforeAttemptCompletion$1.L$10;
            Iterator it2 = (Iterator) interceptorExecutor$modifyBeforeAttemptCompletion$1.L$9;
            HttpAttemptInterceptorContext httpAttemptInterceptorContext5 = (HttpAttemptInterceptorContext) interceptorExecutor$modifyBeforeAttemptCompletion$1.L$7;
            Iterable iterable2 = (Iterable) interceptorExecutor$modifyBeforeAttemptCompletion$1.L$6;
            InterceptorExecutor<I, O> interceptorExecutor2 = (InterceptorExecutor) interceptorExecutor$modifyBeforeAttemptCompletion$1.L$5;
            HttpAttemptInterceptorContext httpAttemptInterceptorContext6 = (HttpAttemptInterceptorContext) interceptorExecutor$modifyBeforeAttemptCompletion$1.L$4;
            Object obj5 = interceptorExecutor$modifyBeforeAttemptCompletion$1.L$3;
            HttpResponse httpResponse3 = (HttpResponse) interceptorExecutor$modifyBeforeAttemptCompletion$1.L$2;
            HttpRequest httpRequest3 = (HttpRequest) interceptorExecutor$modifyBeforeAttemptCompletion$1.L$1;
            Object obj6 = interceptorExecutor$modifyBeforeAttemptCompletion$1.L$0;
            ResultKt.throwOnFailure(obj3);
            InterceptorExecutor$modifyBeforeAttemptCompletion$1 interceptorExecutor$modifyBeforeAttemptCompletion$13 = interceptorExecutor$modifyBeforeAttemptCompletion$1;
            httpRequest2 = httpRequest3;
            int i7 = i5;
            Object value = ((Result) obj3).getValue();
            Object obj7 = obj5;
            HttpAttemptInterceptorContext httpAttemptInterceptorContext7 = httpAttemptInterceptorContext6;
            InterceptorExecutor<I, O> interceptorExecutor3 = interceptorExecutor2;
            Iterable iterable3 = iterable2;
            HttpAttemptInterceptorContext httpAttemptInterceptorContext8 = httpAttemptInterceptorContext5;
            Iterator it3 = it2;
            HttpAttemptInterceptorContext httpAttemptInterceptorContext9 = httpAttemptInterceptorContext4;
            int i8 = i6;
            obj = obj6;
            interceptorExecutor3.m12208checkResultTypemYkaXTg("modifyBeforeAttemptCompletion", value, interceptorExecutor3.typeInfo.getOutputType());
            httpAttemptInterceptorContext9.setResponse(value);
            httpResponse2 = httpResponse3;
            interceptorExecutor$modifyBeforeAttemptCompletion$12 = interceptorExecutor$modifyBeforeAttemptCompletion$13;
            i = i7;
            i2 = i8;
            httpAttemptInterceptorContext = httpAttemptInterceptorContext9;
            it = it3;
            httpAttemptInterceptorContext2 = httpAttemptInterceptorContext8;
            iterable = iterable3;
            interceptorExecutor = interceptorExecutor3;
            httpAttemptInterceptorContext3 = httpAttemptInterceptorContext7;
            obj2 = obj7;
            Object obj8 = obj;
            if (it.hasNext()) {
                Object next = it.next();
                obj = obj8;
                Interceptor interceptor = (Interceptor) next;
                HttpRequest httpRequest4 = httpRequest2;
                HttpResponse httpResponse4 = httpResponse2;
                interceptorExecutor$modifyBeforeAttemptCompletion$12.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                interceptorExecutor$modifyBeforeAttemptCompletion$12.L$1 = SpillingKt.nullOutSpilledVariable(httpRequest4);
                interceptorExecutor$modifyBeforeAttemptCompletion$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse4);
                interceptorExecutor$modifyBeforeAttemptCompletion$12.L$3 = SpillingKt.nullOutSpilledVariable(obj2);
                interceptorExecutor$modifyBeforeAttemptCompletion$12.L$4 = SpillingKt.nullOutSpilledVariable(httpAttemptInterceptorContext3);
                interceptorExecutor$modifyBeforeAttemptCompletion$12.L$5 = interceptorExecutor;
                interceptorExecutor$modifyBeforeAttemptCompletion$12.L$6 = SpillingKt.nullOutSpilledVariable(iterable);
                interceptorExecutor$modifyBeforeAttemptCompletion$12.L$7 = SpillingKt.nullOutSpilledVariable(httpAttemptInterceptorContext2);
                interceptorExecutor$modifyBeforeAttemptCompletion$12.L$8 = SpillingKt.nullOutSpilledVariable(httpAttemptInterceptorContext);
                interceptorExecutor$modifyBeforeAttemptCompletion$12.L$9 = it;
                interceptorExecutor$modifyBeforeAttemptCompletion$12.L$10 = SpillingKt.nullOutSpilledVariable(next);
                interceptorExecutor$modifyBeforeAttemptCompletion$12.L$11 = SpillingKt.nullOutSpilledVariable(interceptor);
                interceptorExecutor$modifyBeforeAttemptCompletion$12.L$12 = httpAttemptInterceptorContext;
                interceptorExecutor$modifyBeforeAttemptCompletion$12.I$0 = i2;
                interceptorExecutor$modifyBeforeAttemptCompletion$12.I$1 = i;
                interceptorExecutor$modifyBeforeAttemptCompletion$12.I$2 = 0;
                interceptorExecutor$modifyBeforeAttemptCompletion$12.label = 1;
                Object objMo12026modifyBeforeAttemptCompletiongIAlus = interceptor.mo12026modifyBeforeAttemptCompletiongIAlus(httpAttemptInterceptorContext, interceptorExecutor$modifyBeforeAttemptCompletion$12);
                if (objMo12026modifyBeforeAttemptCompletiongIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                httpRequest2 = httpRequest4;
                value = objMo12026modifyBeforeAttemptCompletiongIAlus;
                obj7 = obj2;
                httpAttemptInterceptorContext7 = httpAttemptInterceptorContext3;
                interceptorExecutor3 = interceptorExecutor;
                iterable3 = iterable;
                httpAttemptInterceptorContext8 = httpAttemptInterceptorContext2;
                it3 = it;
                httpAttemptInterceptorContext9 = httpAttemptInterceptorContext;
                i8 = i2;
                i7 = i;
                interceptorExecutor$modifyBeforeAttemptCompletion$13 = interceptorExecutor$modifyBeforeAttemptCompletion$12;
                httpResponse3 = httpResponse4;
                interceptorExecutor3.m12208checkResultTypemYkaXTg("modifyBeforeAttemptCompletion", value, interceptorExecutor3.typeInfo.getOutputType());
                httpAttemptInterceptorContext9.setResponse(value);
                httpResponse2 = httpResponse3;
                interceptorExecutor$modifyBeforeAttemptCompletion$12 = interceptorExecutor$modifyBeforeAttemptCompletion$13;
                i = i7;
                i2 = i8;
                httpAttemptInterceptorContext = httpAttemptInterceptorContext9;
                it = it3;
                httpAttemptInterceptorContext2 = httpAttemptInterceptorContext8;
                iterable = iterable3;
                interceptorExecutor = interceptorExecutor3;
                httpAttemptInterceptorContext3 = httpAttemptInterceptorContext7;
                obj2 = obj7;
                Object obj82 = obj;
                if (it.hasNext()) {
                    objM14499constructorimpl = Result.m14499constructorimpl(Result.m14498boximpl(httpAttemptInterceptorContext.mo12149getResponsed1pmJ48()));
                }
            }
            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
            if (thM14502exceptionOrNullimpl != null) {
                return m12208checkResultTypemYkaXTg("modifyBeforeAttemptCompletion", ((Result) objM14499constructorimpl).getValue(), this.typeInfo.getOutputType());
            }
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(thM14502exceptionOrNullimpl));
        }
        ResultKt.throwOnFailure(obj3);
        I i9 = this._lastInput;
        if (i9 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(i9, "null cannot be cast to non-null type kotlin.Any");
        HttpAttemptInterceptorContext httpAttemptInterceptorContext10 = new HttpAttemptInterceptorContext(i9, obj, httpRequest, httpResponse, this.execContext);
        Result.Companion companion3 = Result.INSTANCE;
        InterceptorExecutor<I, O> interceptorExecutor4 = this;
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list = this.interceptors;
        iterable = list;
        interceptorExecutor = this;
        it = list.iterator();
        httpAttemptInterceptorContext = httpAttemptInterceptorContext10;
        httpAttemptInterceptorContext2 = httpAttemptInterceptorContext;
        httpAttemptInterceptorContext3 = httpAttemptInterceptorContext2;
        obj2 = i9;
        i = 0;
        i2 = 0;
        httpResponse2 = httpResponse;
        interceptorExecutor$modifyBeforeAttemptCompletion$12 = interceptorExecutor$modifyBeforeAttemptCompletion$1;
        httpRequest2 = httpRequest;
        Object obj822 = obj;
        if (it.hasNext()) {
        }
        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
        }
    }

    public final void readAfterAttempt(Object result, HttpRequest httpRequest, HttpResponse httpResponse) {
        Object objM14499constructorimpl;
        Intrinsics.checkNotNullParameter(httpRequest, "httpRequest");
        I i = this._lastInput;
        if (i == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this._lastHttpResponse = httpResponse;
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Any");
        HttpAttemptInterceptorContext httpAttemptInterceptorContext = new HttpAttemptInterceptorContext(i, result, httpRequest, httpResponse, this.execContext);
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list = this.interceptors;
        Result.Companion companion = Result.INSTANCE;
        Object objM14499constructorimpl2 = Result.m14499constructorimpl(Unit.INSTANCE);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Interceptor interceptor = (Interceptor) it.next();
            try {
                Result.Companion companion2 = Result.INSTANCE;
                InterceptorExecutor<I, O> interceptorExecutor = this;
                interceptor.readAfterAttempt(httpAttemptInterceptorContext);
                objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
            if (thM14502exceptionOrNullimpl == null) {
            } else {
                Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                if (thM14502exceptionOrNullimpl2 != null) {
                    ExceptionsKt.addSuppressed(thM14502exceptionOrNullimpl, thM14502exceptionOrNullimpl2);
                }
                Result.Companion companion4 = Result.INSTANCE;
                objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(thM14502exceptionOrNullimpl));
            }
        }
        ResultKt.throwOnFailure(objM14499constructorimpl2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a8 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:12:0x0058, B:28:0x0101, B:22:0x00a2, B:24:0x00a8, B:29:0x0111, B:21:0x008a), top: B:39:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0111 A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #0 {all -> 0x0066, blocks: (B:12:0x0058, B:28:0x0101, B:22:0x00a2, B:24:0x00a8, B:29:0x0111, B:21:0x008a), top: B:39:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00fd -> B:28:0x0101). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: modifyBeforeCompletion-KWTtemM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m12211modifyBeforeCompletionKWTtemM(Object obj, Continuation<? super Result<? extends O>> continuation) {
        InterceptorExecutor$modifyBeforeCompletion$1 interceptorExecutor$modifyBeforeCompletion$1;
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Iterable iterable;
        InterceptorExecutor<I, O> interceptorExecutor;
        Iterator it;
        HttpFinalInterceptorContext httpFinalInterceptorContext;
        HttpFinalInterceptorContext httpFinalInterceptorContext2;
        Object obj2;
        int i;
        Object obj3;
        HttpFinalInterceptorContext httpFinalInterceptorContext3;
        int i2;
        if (continuation instanceof InterceptorExecutor$modifyBeforeCompletion$1) {
            interceptorExecutor$modifyBeforeCompletion$1 = (InterceptorExecutor$modifyBeforeCompletion$1) continuation;
            if ((interceptorExecutor$modifyBeforeCompletion$1.label & Integer.MIN_VALUE) != 0) {
                interceptorExecutor$modifyBeforeCompletion$1.label -= Integer.MIN_VALUE;
            } else {
                interceptorExecutor$modifyBeforeCompletion$1 = new InterceptorExecutor$modifyBeforeCompletion$1(this, continuation);
            }
        }
        Object obj4 = interceptorExecutor$modifyBeforeCompletion$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = interceptorExecutor$modifyBeforeCompletion$1.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = interceptorExecutor$modifyBeforeCompletion$1.I$2;
            int i5 = interceptorExecutor$modifyBeforeCompletion$1.I$1;
            i2 = interceptorExecutor$modifyBeforeCompletion$1.I$0;
            httpFinalInterceptorContext3 = (HttpFinalInterceptorContext) interceptorExecutor$modifyBeforeCompletion$1.L$10;
            Object obj5 = interceptorExecutor$modifyBeforeCompletion$1.L$8;
            it = (Iterator) interceptorExecutor$modifyBeforeCompletion$1.L$7;
            httpFinalInterceptorContext = (HttpFinalInterceptorContext) interceptorExecutor$modifyBeforeCompletion$1.L$5;
            iterable = (Iterable) interceptorExecutor$modifyBeforeCompletion$1.L$4;
            interceptorExecutor = (InterceptorExecutor) interceptorExecutor$modifyBeforeCompletion$1.L$3;
            httpFinalInterceptorContext2 = (HttpFinalInterceptorContext) interceptorExecutor$modifyBeforeCompletion$1.L$2;
            obj2 = interceptorExecutor$modifyBeforeCompletion$1.L$1;
            Object obj6 = interceptorExecutor$modifyBeforeCompletion$1.L$0;
            ResultKt.throwOnFailure(obj4);
            Object objMo12027modifyBeforeCompletiongIAlus = ((Result) obj4).getValue();
            int i6 = i5;
            InterceptorExecutor$modifyBeforeCompletion$1 interceptorExecutor$modifyBeforeCompletion$12 = interceptorExecutor$modifyBeforeCompletion$1;
            Object obj7 = obj6;
            interceptorExecutor.m12208checkResultTypemYkaXTg("modifyBeforeCompletion", objMo12027modifyBeforeCompletiongIAlus, interceptorExecutor.typeInfo.getOutputType());
            httpFinalInterceptorContext3.setResponse(objMo12027modifyBeforeCompletiongIAlus);
            obj3 = obj7;
            interceptorExecutor$modifyBeforeCompletion$1 = interceptorExecutor$modifyBeforeCompletion$12;
            i = i6;
            if (it.hasNext()) {
                Object next = it.next();
                Interceptor interceptor = (Interceptor) next;
                Object obj8 = obj3;
                interceptorExecutor$modifyBeforeCompletion$1.L$0 = SpillingKt.nullOutSpilledVariable(obj8);
                interceptorExecutor$modifyBeforeCompletion$1.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                interceptorExecutor$modifyBeforeCompletion$1.L$2 = SpillingKt.nullOutSpilledVariable(httpFinalInterceptorContext2);
                interceptorExecutor$modifyBeforeCompletion$1.L$3 = interceptorExecutor;
                interceptorExecutor$modifyBeforeCompletion$1.L$4 = SpillingKt.nullOutSpilledVariable(iterable);
                interceptorExecutor$modifyBeforeCompletion$1.L$5 = SpillingKt.nullOutSpilledVariable(httpFinalInterceptorContext);
                interceptorExecutor$modifyBeforeCompletion$1.L$6 = SpillingKt.nullOutSpilledVariable(httpFinalInterceptorContext3);
                interceptorExecutor$modifyBeforeCompletion$1.L$7 = it;
                interceptorExecutor$modifyBeforeCompletion$1.L$8 = SpillingKt.nullOutSpilledVariable(next);
                interceptorExecutor$modifyBeforeCompletion$1.L$9 = SpillingKt.nullOutSpilledVariable(interceptor);
                interceptorExecutor$modifyBeforeCompletion$1.L$10 = httpFinalInterceptorContext3;
                interceptorExecutor$modifyBeforeCompletion$1.I$0 = i2;
                interceptorExecutor$modifyBeforeCompletion$1.I$1 = i;
                interceptorExecutor$modifyBeforeCompletion$1.I$2 = 0;
                interceptorExecutor$modifyBeforeCompletion$1.label = 1;
                objMo12027modifyBeforeCompletiongIAlus = interceptor.mo12027modifyBeforeCompletiongIAlus(httpFinalInterceptorContext3, interceptorExecutor$modifyBeforeCompletion$1);
                if (objMo12027modifyBeforeCompletiongIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i6 = i;
                interceptorExecutor$modifyBeforeCompletion$12 = interceptorExecutor$modifyBeforeCompletion$1;
                obj7 = obj8;
                interceptorExecutor.m12208checkResultTypemYkaXTg("modifyBeforeCompletion", objMo12027modifyBeforeCompletiongIAlus, interceptorExecutor.typeInfo.getOutputType());
                httpFinalInterceptorContext3.setResponse(objMo12027modifyBeforeCompletiongIAlus);
                obj3 = obj7;
                interceptorExecutor$modifyBeforeCompletion$1 = interceptorExecutor$modifyBeforeCompletion$12;
                i = i6;
                if (it.hasNext()) {
                    objM14499constructorimpl = Result.m14499constructorimpl(Result.m14498boximpl(httpFinalInterceptorContext3.mo12149getResponsed1pmJ48()));
                }
            }
            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
            if (thM14502exceptionOrNullimpl != null) {
                return m12208checkResultTypemYkaXTg("modifyBeforeCompletion", ((Result) objM14499constructorimpl).getValue(), this.typeInfo.getOutputType());
            }
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(thM14502exceptionOrNullimpl));
        }
        ResultKt.throwOnFailure(obj4);
        I i7 = this._lastInput;
        if (i7 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(i7, "null cannot be cast to non-null type kotlin.Any");
        HttpFinalInterceptorContext httpFinalInterceptorContext4 = new HttpFinalInterceptorContext(i7, obj, this._lastHttpRequest, this._lastHttpResponse, this.execContext);
        Result.Companion companion3 = Result.INSTANCE;
        InterceptorExecutor<I, O> interceptorExecutor2 = this;
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list = this.interceptors;
        iterable = list;
        interceptorExecutor = this;
        it = list.iterator();
        httpFinalInterceptorContext = httpFinalInterceptorContext4;
        httpFinalInterceptorContext2 = httpFinalInterceptorContext;
        obj2 = i7;
        i = 0;
        obj3 = obj;
        httpFinalInterceptorContext3 = httpFinalInterceptorContext2;
        i2 = 0;
        if (it.hasNext()) {
        }
        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
        if (thM14502exceptionOrNullimpl != null) {
        }
    }

    /* JADX INFO: renamed from: readAfterExecution-bjn95JY, reason: not valid java name */
    public final Object m12212readAfterExecutionbjn95JY(Object result) {
        Object obj;
        Object objM14499constructorimpl;
        I i = this._lastInput;
        if (i == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Any");
        HttpFinalInterceptorContext httpFinalInterceptorContext = new HttpFinalInterceptorContext(i, result, this._lastHttpRequest, this._lastHttpResponse, this.execContext);
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list = this.interceptors;
        Result.Companion companion = Result.INSTANCE;
        Object objM14499constructorimpl2 = Result.m14499constructorimpl(Unit.INSTANCE);
        Iterator<T> it = list.iterator();
        loop0: while (true) {
            obj = objM14499constructorimpl2;
            while (it.hasNext()) {
                Interceptor interceptor = (Interceptor) it.next();
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    InterceptorExecutor<I, O> interceptorExecutor = this;
                    interceptor.readAfterExecution(httpFinalInterceptorContext);
                    objM14499constructorimpl = Result.m14499constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                if (thM14502exceptionOrNullimpl == null) {
                } else {
                    Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(obj);
                    if (thM14502exceptionOrNullimpl2 != null) {
                        ExceptionsKt.addSuppressed(thM14502exceptionOrNullimpl, thM14502exceptionOrNullimpl2);
                    }
                    Result.Companion companion4 = Result.INSTANCE;
                    objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(thM14502exceptionOrNullimpl));
                }
            }
            break loop0;
        }
        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(obj);
        if (thM14502exceptionOrNullimpl3 == null) {
            return m12208checkResultTypemYkaXTg("readAfterExecution", httpFinalInterceptorContext.mo12149getResponsed1pmJ48(), this.typeInfo.getOutputType());
        }
        Throwable thM14502exceptionOrNullimpl4 = Result.m14502exceptionOrNullimpl(result);
        if (thM14502exceptionOrNullimpl4 != null) {
            ExceptionsKt.addSuppressed(thM14502exceptionOrNullimpl3, thM14502exceptionOrNullimpl4);
        }
        Result.Companion companion5 = Result.INSTANCE;
        return Result.m14499constructorimpl(ResultKt.createFailure(thM14502exceptionOrNullimpl3));
    }

    private final void updateBusinessMetrics(HttpRequest request, HttpRequest modifiedRequest, HttpProtocolRequestInterceptorContext<Object> context) {
        if (Intrinsics.areEqual(modifiedRequest.getUrl(), request.getUrl())) {
            return;
        }
        if (BusinessMetricsUtilsKt.containsBusinessMetric(context.getExecutionContext(), SmithyBusinessMetric.ACCOUNT_ID_BASED_ENDPOINT) && !StringsKt.contains$default((CharSequence) modifiedRequest.getUrl().getEncoded(), (CharSequence) AttributesKt.get(context.getExecutionContext().getAttributes(), BusinessMetricsUtilsKt.getAccountIdBasedEndpointAccountId()), false, 2, (Object) null)) {
            BusinessMetricsUtilsKt.removeBusinessMetric(context.getExecutionContext(), SmithyBusinessMetric.ACCOUNT_ID_BASED_ENDPOINT);
        }
        if (BusinessMetricsUtilsKt.containsBusinessMetric(context.getExecutionContext(), SmithyBusinessMetric.SERVICE_ENDPOINT_OVERRIDE)) {
            BusinessMetricsUtilsKt.removeBusinessMetric(context.getExecutionContext(), SmithyBusinessMetric.SERVICE_ENDPOINT_OVERRIDE);
        }
    }

    public final void readAfterSerialization(HttpRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this._lastHttpRequest = request;
        I i = this._lastInput;
        if (i == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Any");
        HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext = new HttpProtocolRequestInterceptorContext(i, request, this.execContext);
        Iterator<T> it = this.interceptors.iterator();
        while (it.hasNext()) {
            ((Interceptor) it.next()).readAfterSerialization(httpProtocolRequestInterceptorContext);
        }
    }

    public final void readBeforeSigning(HttpRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this._lastHttpRequest = request;
        I i = this._lastInput;
        if (i == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Any");
        HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext = new HttpProtocolRequestInterceptorContext(i, request, this.execContext);
        Iterator<T> it = this.interceptors.iterator();
        while (it.hasNext()) {
            ((Interceptor) it.next()).readBeforeSigning(httpProtocolRequestInterceptorContext);
        }
    }

    public final void readAfterSigning(HttpRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this._lastHttpRequest = request;
        I i = this._lastInput;
        if (i == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Any");
        HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext = new HttpProtocolRequestInterceptorContext(i, request, this.execContext);
        Iterator<T> it = this.interceptors.iterator();
        while (it.hasNext()) {
            ((Interceptor) it.next()).readAfterSigning(httpProtocolRequestInterceptorContext);
        }
    }

    public final void readBeforeTransmit(HttpRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this._lastHttpRequest = request;
        I i = this._lastInput;
        if (i == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.Any");
        HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext = new HttpProtocolRequestInterceptorContext(i, request, this.execContext);
        Iterator<T> it = this.interceptors.iterator();
        while (it.hasNext()) {
            ((Interceptor) it.next()).readBeforeTransmit(httpProtocolRequestInterceptorContext);
        }
    }
}

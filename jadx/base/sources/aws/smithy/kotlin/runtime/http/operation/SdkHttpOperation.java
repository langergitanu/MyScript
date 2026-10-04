package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.util.Uuid;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: SdkHttpOperation.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 :*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001:BQ\b\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0018J\u001b\u0010\u0015\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u001b¢\u0006\u0004\b\u0015\u0010\u001cJ!\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d¢\u0006\u0004\b\u0015\u0010\u001eR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010\r\u001a\u00020\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010\u000f\u001a\u00020\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010.\u001a\u0004\b/\u00100R9\u00106\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020402j\u0002`5018\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109¨\u0006;"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "I", "O", "", "Laws/smithy/kotlin/runtime/http/operation/SdkOperationExecution;", "execution", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "serializer", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "deserializer", "Laws/smithy/kotlin/runtime/http/operation/OperationTypeInfo;", "typeInfo", "Laws/smithy/kotlin/runtime/http/operation/SdkOperationTelemetry;", "telemetry", "<init>", "(Laws/smithy/kotlin/runtime/http/operation/SdkOperationExecution;Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;Laws/smithy/kotlin/runtime/http/operation/OperationTypeInfo;Laws/smithy/kotlin/runtime/http/operation/SdkOperationTelemetry;)V", "Laws/smithy/kotlin/runtime/http/operation/ModifyRequestMiddleware;", "middleware", "", "install", "(Laws/smithy/kotlin/runtime/http/operation/ModifyRequestMiddleware;)V", "Laws/smithy/kotlin/runtime/http/operation/InitializeMiddleware;", "(Laws/smithy/kotlin/runtime/http/operation/InitializeMiddleware;)V", "Laws/smithy/kotlin/runtime/http/operation/MutateMiddleware;", "(Laws/smithy/kotlin/runtime/http/operation/MutateMiddleware;)V", "Laws/smithy/kotlin/runtime/http/operation/ReceiveMiddleware;", "(Laws/smithy/kotlin/runtime/http/operation/ReceiveMiddleware;)V", "Laws/smithy/kotlin/runtime/http/operation/InlineMiddleware;", "(Laws/smithy/kotlin/runtime/http/operation/InlineMiddleware;)V", "Laws/smithy/kotlin/runtime/http/operation/SdkOperationExecution;", "getExecution", "()Laws/smithy/kotlin/runtime/http/operation/SdkOperationExecution;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "getContext", "()Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "getSerializer$http_client", "()Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "getDeserializer$http_client", "()Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "Laws/smithy/kotlin/runtime/http/operation/OperationTypeInfo;", "getTypeInfo$http_client", "()Laws/smithy/kotlin/runtime/http/operation/OperationTypeInfo;", "Laws/smithy/kotlin/runtime/http/operation/SdkOperationTelemetry;", "getTelemetry$http_client", "()Laws/smithy/kotlin/runtime/http/operation/SdkOperationTelemetry;", "", "Laws/smithy/kotlin/runtime/client/Interceptor;", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "interceptors", "Ljava/util/List;", "getInterceptors", "()Ljava/util/List;", "Companion", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkHttpOperation<I, O> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ExecutionContext context;
    private final HttpDeserializer<O> deserializer;
    private final SdkOperationExecution<I, O> execution;
    private final List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors;
    private final HttpSerializer<I> serializer;
    private final SdkOperationTelemetry telemetry;
    private final OperationTypeInfo typeInfo;

    public SdkHttpOperation(SdkOperationExecution<I, O> execution, ExecutionContext context, HttpSerializer<I> serializer, HttpDeserializer<O> deserializer, OperationTypeInfo typeInfo, SdkOperationTelemetry telemetry) {
        Intrinsics.checkNotNullParameter(execution, "execution");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(typeInfo, "typeInfo");
        Intrinsics.checkNotNullParameter(telemetry, "telemetry");
        this.execution = execution;
        this.context = context;
        this.serializer = serializer;
        this.deserializer = deserializer;
        this.typeInfo = typeInfo;
        this.telemetry = telemetry;
        context.set(HttpOperationContext.INSTANCE.getSdkInvocationId(), Uuid.INSTANCE.random().getStringRep());
        this.interceptors = new ArrayList();
    }

    public final SdkOperationExecution<I, O> getExecution() {
        return this.execution;
    }

    public final ExecutionContext getContext() {
        return this.context;
    }

    public final HttpSerializer<I> getSerializer$http_client() {
        return this.serializer;
    }

    public final HttpDeserializer<O> getDeserializer$http_client() {
        return this.deserializer;
    }

    /* JADX INFO: renamed from: getTypeInfo$http_client, reason: from getter */
    public final OperationTypeInfo getTypeInfo() {
        return this.typeInfo;
    }

    /* JADX INFO: renamed from: getTelemetry$http_client, reason: from getter */
    public final SdkOperationTelemetry getTelemetry() {
        return this.telemetry;
    }

    public final List<Interceptor<Object, Object, HttpRequest, HttpResponse>> getInterceptors() {
        return this.interceptors;
    }

    public final void install(ModifyRequestMiddleware middleware) {
        Intrinsics.checkNotNullParameter(middleware, "middleware");
        middleware.install(this);
    }

    public final void install(InitializeMiddleware<I, O> middleware) {
        Intrinsics.checkNotNullParameter(middleware, "middleware");
        middleware.install(this);
    }

    public final void install(MutateMiddleware<O> middleware) {
        Intrinsics.checkNotNullParameter(middleware, "middleware");
        middleware.install(this);
    }

    public final void install(ReceiveMiddleware middleware) {
        Intrinsics.checkNotNullParameter(middleware, "middleware");
        middleware.install(this);
    }

    public final void install(InlineMiddleware<I, O> middleware) {
        Intrinsics.checkNotNullParameter(middleware, "middleware");
        middleware.install(this);
    }

    /* JADX INFO: compiled from: SdkHttpOperation.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000b\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u00012#\u0010\n\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation$Companion;", "", "<init>", "()V", "I", "O", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperationBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "build", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ <I, O> SdkHttpOperation<I, O> build(Function1<? super SdkHttpOperationBuilder<I, O>, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Intrinsics.reifiedOperationMarker(4, "I");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(4, "O");
            SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Object.class));
            block.invoke(sdkHttpOperationBuilder);
            return sdkHttpOperationBuilder.build();
        }
    }
}

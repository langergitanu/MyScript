package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.client.SdkClientOption;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: SdkHttpOperation.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u001f\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0018\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR#\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010&\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R$\u00104\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010,\u001a\u0004\b5\u0010.\"\u0004\b6\u00100¨\u00067"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperationBuilder;", "I", "O", "", "Lkotlin/reflect/KClass;", "inputType", "outputType", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)V", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "build", "()Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "Lkotlin/reflect/KClass;", "Laws/smithy/kotlin/runtime/http/operation/SdkOperationTelemetry;", "telemetry", "Laws/smithy/kotlin/runtime/http/operation/SdkOperationTelemetry;", "getTelemetry", "()Laws/smithy/kotlin/runtime/http/operation/SdkOperationTelemetry;", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "serializeWith", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "getSerializeWith", "()Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "setSerializeWith", "(Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;)V", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "deserializeWith", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "getDeserializeWith", "()Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "setDeserializeWith", "(Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;)V", "Laws/smithy/kotlin/runtime/http/operation/SdkOperationExecution;", "execution", "Laws/smithy/kotlin/runtime/http/operation/SdkOperationExecution;", "getExecution", "()Laws/smithy/kotlin/runtime/http/operation/SdkOperationExecution;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "getContext", "()Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "", "operationName", "Ljava/lang/String;", "getOperationName", "()Ljava/lang/String;", "setOperationName", "(Ljava/lang/String;)V", "serviceName", "getServiceName", "setServiceName", "hostPrefix", "getHostPrefix", "setHostPrefix", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkHttpOperationBuilder<I, O> {
    private final ExecutionContext context;
    private HttpDeserializer<O> deserializeWith;
    private final SdkOperationExecution<I, O> execution;
    private String hostPrefix;
    private final KClass<?> inputType;
    private String operationName;
    private final KClass<?> outputType;
    private HttpSerializer<I> serializeWith;
    private String serviceName;
    private final SdkOperationTelemetry telemetry;

    public SdkHttpOperationBuilder(KClass<?> inputType, KClass<?> outputType) {
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        Intrinsics.checkNotNullParameter(outputType, "outputType");
        this.inputType = inputType;
        this.outputType = outputType;
        this.telemetry = new SdkOperationTelemetry();
        this.execution = new SdkOperationExecution<>();
        this.context = new ExecutionContext();
    }

    public final SdkOperationTelemetry getTelemetry() {
        return this.telemetry;
    }

    public final HttpSerializer<I> getSerializeWith() {
        return this.serializeWith;
    }

    public final void setSerializeWith(HttpSerializer<I> httpSerializer) {
        this.serializeWith = httpSerializer;
    }

    public final HttpDeserializer<O> getDeserializeWith() {
        return this.deserializeWith;
    }

    public final void setDeserializeWith(HttpDeserializer<O> httpDeserializer) {
        this.deserializeWith = httpDeserializer;
    }

    public final SdkOperationExecution<I, O> getExecution() {
        return this.execution;
    }

    public final ExecutionContext getContext() {
        return this.context;
    }

    public final String getOperationName() {
        return this.operationName;
    }

    public final void setOperationName(String str) {
        this.operationName = str;
    }

    public final String getServiceName() {
        return this.serviceName;
    }

    public final void setServiceName(String str) {
        this.serviceName = str;
    }

    public final String getHostPrefix() {
        return this.hostPrefix;
    }

    public final void setHostPrefix(String str) {
        this.hostPrefix = str;
    }

    public final SdkHttpOperation<I, O> build() {
        HttpSerializer<I> httpSerializer = this.serializeWith;
        if (httpSerializer == null) {
            throw new IllegalArgumentException("SdkHttpOperation.serializeWith must not be null".toString());
        }
        HttpDeserializer<O> httpDeserializer = this.deserializeWith;
        if (httpDeserializer == null) {
            throw new IllegalArgumentException("SdkHttpOperation.deserializeWith must not be null".toString());
        }
        if (this.operationName == null) {
            throw new IllegalArgumentException("operationName is a required HTTP execution attribute".toString());
        }
        if (this.serviceName == null) {
            throw new IllegalArgumentException("serviceName is a required HTTP execution attribute".toString());
        }
        ExecutionContext executionContext = this.context;
        AttributeKey<String> operationName = SdkClientOption.INSTANCE.getOperationName();
        String str = this.operationName;
        Intrinsics.checkNotNull(str);
        executionContext.set(operationName, str);
        ExecutionContext executionContext2 = this.context;
        AttributeKey<String> serviceName = SdkClientOption.INSTANCE.getServiceName();
        String str2 = this.serviceName;
        Intrinsics.checkNotNull(str2);
        executionContext2.set(serviceName, str2);
        String str3 = this.hostPrefix;
        if (str3 != null) {
            this.context.set(HttpOperationContext.INSTANCE.getHostPrefix(), str3);
        }
        return new SdkHttpOperation<>(this.execution, this.context, httpSerializer, httpDeserializer, new OperationTypeInfo(this.inputType, this.outputType), this.telemetry);
    }
}

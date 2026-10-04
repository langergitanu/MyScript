package aws.smithy.kotlin.runtime.http.config;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.config.HttpEngineConfig;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpClientConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0006R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig;", "", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "httpClient", "Builder", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface HttpEngineConfig {
    HttpClientEngine getHttpClient();

    /* JADX INFO: compiled from: HttpClientConfig.kt */
    @HttpEngineConfigDsl
    @Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\u00020\u00042\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H&¢\u0006\u0004\b\u0007\u0010\bJR\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\t*\u00020\u0003\"\b\b\u0001\u0010\u000b*\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H&¢\u0006\u0004\b\u0007\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\n8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig$Builder;", "", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "httpClient", "(Lkotlin/jvm/functions/Function1;)V", "B", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", ExifInterface.LONGITUDE_EAST, "Laws/smithy/kotlin/runtime/http/config/EngineFactory;", "engineFactory", "(Laws/smithy/kotlin/runtime/http/config/EngineFactory;Lkotlin/jvm/functions/Function1;)V", "Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig;", "buildHttpEngineConfig", "()Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig;", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "setHttpClient", "(Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)V", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder {
        @InternalApi
        HttpEngineConfig buildHttpEngineConfig();

        HttpClientEngine getHttpClient();

        <B extends HttpClientEngineConfig.Builder, E extends HttpClientEngine> void httpClient(EngineFactory<? extends B, E> engineFactory, Function1<? super B, Unit> block);

        void httpClient(Function1<? super HttpClientEngineConfig.Builder, Unit> block);

        void setHttpClient(HttpClientEngine httpClientEngine);

        /* JADX INFO: compiled from: HttpClientConfig.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class DefaultImpls {
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ void httpClient$default(Builder builder, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: httpClient");
            }
            if ((i & 1) != 0) {
                function1 = new Function1() { // from class: aws.smithy.kotlin.runtime.http.config.HttpEngineConfig$Builder$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return HttpEngineConfig.Builder.httpClient$lambda$0((HttpClientEngineConfig.Builder) obj2);
                    }
                };
            }
            builder.httpClient(function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static Unit httpClient$lambda$0(HttpClientEngineConfig.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<this>");
            return Unit.INSTANCE;
        }

        static /* synthetic */ void httpClient$default(Builder builder, EngineFactory engineFactory, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: httpClient");
            }
            if ((i & 2) != 0) {
                function1 = new Function1() { // from class: aws.smithy.kotlin.runtime.http.config.HttpEngineConfig$Builder$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return HttpEngineConfig.Builder.httpClient$lambda$1((HttpClientEngineConfig.Builder) obj2);
                    }
                };
            }
            builder.httpClient(engineFactory, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static Unit httpClient$lambda$1(HttpClientEngineConfig.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<this>");
            return Unit.INSTANCE;
        }
    }
}

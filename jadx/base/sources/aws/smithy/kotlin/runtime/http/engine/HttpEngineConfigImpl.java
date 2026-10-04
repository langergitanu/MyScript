package aws.smithy.kotlin.runtime.http.engine;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.config.EngineFactory;
import aws.smithy.kotlin.runtime.http.config.HttpEngineConfig;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;
import aws.smithy.kotlin.runtime.http.engine.HttpEngineConfigImpl;
import aws.smithy.kotlin.runtime.http.engine.internal.ManagedHttpClientEngineKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpEngineConfigImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpEngineConfigImpl;", "Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig;", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "<init>", "(Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)V", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "BuilderImpl", "SupplierState", "http-client-engine-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpEngineConfigImpl implements HttpEngineConfig {
    private final HttpClientEngine httpClient;

    public /* synthetic */ HttpEngineConfigImpl(HttpClientEngine httpClientEngine, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpClientEngine);
    }

    private HttpEngineConfigImpl(HttpClientEngine httpClientEngine) {
        this.httpClient = httpClientEngine;
    }

    @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig
    public HttpClientEngine getHttpClient() {
        return this.httpClient;
    }

    /* JADX INFO: compiled from: HttpEngineConfigImpl.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0011\u001a\u00020\u00072\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0016JI\u0010\u0011\u001a\u00020\u0007\"\b\b\u0000\u0010\u0017*\u00020\u0006\"\b\b\u0001\u0010\u0018*\u00020\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u001a2\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0016JK\u0010\u001b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0017*\u00020\u0006\"\b\b\u0001\u0010\u0018*\u00020\u000b2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0018\u0018\u00010\u001a2\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R#\u0010\u0004\u001a\u0017\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\t¢\u0006\u0002\b\bX\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\n\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\t¢\u0006\u0002\b\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpEngineConfigImpl$BuilderImpl;", "Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig$Builder;", "<init>", "()V", "configApplicator", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "Laws/smithy/kotlin/runtime/http/engine/ConfigApplicator;", "engineConstructor", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "engineSupplier", "Lkotlin/Function0;", "state", "Laws/smithy/kotlin/runtime/http/engine/HttpEngineConfigImpl$SupplierState;", "value", "httpClient", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "setHttpClient", "(Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)V", "block", "B", ExifInterface.LONGITUDE_EAST, "engineFactory", "Laws/smithy/kotlin/runtime/http/config/EngineFactory;", "httpClientImpl", "buildHttpEngineConfig", "Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig;", "http-client-engine-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class BuilderImpl implements HttpEngineConfig.Builder {
        private HttpClientEngine httpClient;
        private Function1<? super HttpClientEngineConfig.Builder, Unit> configApplicator = new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.HttpEngineConfigImpl$BuilderImpl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HttpEngineConfigImpl.BuilderImpl.configApplicator$lambda$0((HttpClientEngineConfig.Builder) obj);
            }
        };
        private Function1<? super Function1<? super HttpClientEngineConfig.Builder, Unit>, ? extends HttpClientEngine> engineConstructor = HttpEngineConfigImpl$BuilderImpl$engineConstructor$1.INSTANCE;
        private Function0<? extends HttpClientEngine> engineSupplier = new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.HttpEngineConfigImpl$BuilderImpl$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HttpEngineConfigImpl.BuilderImpl.engineSupplier$lambda$0(this.f$0);
            }
        };
        private SupplierState state = SupplierState.NOT_INITIALIZED;

        /* JADX INFO: compiled from: HttpEngineConfigImpl.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SupplierState.values().length];
                try {
                    iArr[SupplierState.NOT_INITIALIZED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SupplierState.EXPLICIT_ENGINE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final HttpClientEngine _set_httpClient_$lambda$1(HttpClientEngine httpClientEngine) {
            return httpClientEngine;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit configApplicator$lambda$0(HttpClientEngineConfig.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<this>");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final HttpClientEngine engineSupplier$lambda$0(BuilderImpl builderImpl) {
            return ManagedHttpClientEngineKt.manage(builderImpl.engineConstructor.invoke(new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.HttpEngineConfigImpl$BuilderImpl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HttpEngineConfigImpl.BuilderImpl.engineSupplier$lambda$0$0((HttpClientEngineConfig.Builder) obj);
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit engineSupplier$lambda$0$0(HttpClientEngineConfig.Builder engineConstructor) {
            Intrinsics.checkNotNullParameter(engineConstructor, "$this$engineConstructor");
            return Unit.INSTANCE;
        }

        @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
        public HttpClientEngine getHttpClient() {
            return this.httpClient;
        }

        @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
        public void setHttpClient(final HttpClientEngine httpClientEngine) {
            SupplierState supplierState;
            Function0<? extends HttpClientEngine> function0;
            Function1<HttpClientEngineConfig.Builder, Unit> builderApplicator;
            HttpClientEngineConfig config;
            if (WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()] == 1) {
                supplierState = SupplierState.INITIALIZED;
            } else {
                supplierState = SupplierState.EXPLICIT_ENGINE;
            }
            this.state = supplierState;
            this.httpClient = httpClientEngine;
            if (httpClientEngine == null) {
                this.engineConstructor = HttpEngineConfigImpl$BuilderImpl$httpClient$1.INSTANCE;
                function0 = new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.HttpEngineConfigImpl$BuilderImpl$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HttpEngineConfigImpl.BuilderImpl._set_httpClient_$lambda$0(this.f$0);
                    }
                };
            } else {
                function0 = new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.HttpEngineConfigImpl$BuilderImpl$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HttpEngineConfigImpl.BuilderImpl._set_httpClient_$lambda$1(httpClientEngine);
                    }
                };
            }
            this.engineSupplier = function0;
            if (httpClientEngine == null || (config = httpClientEngine.getConfig()) == null || (builderApplicator = config.toBuilderApplicator()) == null) {
                builderApplicator = new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.HttpEngineConfigImpl$BuilderImpl$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HttpEngineConfigImpl.BuilderImpl._set_httpClient_$lambda$2((HttpClientEngineConfig.Builder) obj);
                    }
                };
            }
            this.configApplicator = builderApplicator;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final HttpClientEngine _set_httpClient_$lambda$0(BuilderImpl builderImpl) {
            return ManagedHttpClientEngineKt.manage(builderImpl.engineConstructor.invoke(new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.HttpEngineConfigImpl$BuilderImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HttpEngineConfigImpl.BuilderImpl._set_httpClient_$lambda$0$0((HttpClientEngineConfig.Builder) obj);
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit _set_httpClient_$lambda$0$0(HttpClientEngineConfig.Builder engineConstructor) {
            Intrinsics.checkNotNullParameter(engineConstructor, "$this$engineConstructor");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit _set_httpClient_$lambda$2(HttpClientEngineConfig.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<this>");
            return Unit.INSTANCE;
        }

        @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
        public void httpClient(Function1<? super HttpClientEngineConfig.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            httpClientImpl(null, block);
        }

        @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
        public <B extends HttpClientEngineConfig.Builder, E extends HttpClientEngine> void httpClient(EngineFactory<? extends B, E> engineFactory, Function1<? super B, Unit> block) {
            Intrinsics.checkNotNullParameter(engineFactory, "engineFactory");
            Intrinsics.checkNotNullParameter(block, "block");
            httpClientImpl(engineFactory, block);
        }

        private final <B extends HttpClientEngineConfig.Builder, E extends HttpClientEngine> void httpClientImpl(EngineFactory<? extends B, E> engineFactory, final Function1<? super B, Unit> block) {
            if (WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()] == 2) {
                throw new ClientException("Engine configuration cannot be given after an explicit engine instance has already been set");
            }
            this.state = SupplierState.EXPLICIT_CONFIG;
            if (engineFactory != null) {
                this.engineConstructor = engineFactory.getEngineConstructor();
            }
            final Function1<? super HttpClientEngineConfig.Builder, Unit> function1 = this.configApplicator;
            this.configApplicator = new Function1() { // from class: aws.smithy.kotlin.runtime.http.engine.HttpEngineConfigImpl$BuilderImpl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HttpEngineConfigImpl.BuilderImpl.httpClientImpl$lambda$1(function1, block, (HttpClientEngineConfig.Builder) obj);
                }
            };
            this.engineSupplier = new Function0() { // from class: aws.smithy.kotlin.runtime.http.engine.HttpEngineConfigImpl$BuilderImpl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HttpEngineConfigImpl.BuilderImpl.httpClientImpl$lambda$2(this.f$0);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit httpClientImpl$lambda$1(Function1 function1, Function1 function12, HttpClientEngineConfig.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<this>");
            function1.invoke(builder);
            function12.invoke(builder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final HttpClientEngine httpClientImpl$lambda$2(BuilderImpl builderImpl) {
            return ManagedHttpClientEngineKt.manage(builderImpl.engineConstructor.invoke(builderImpl.configApplicator));
        }

        @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
        public HttpEngineConfig buildHttpEngineConfig() {
            return new HttpEngineConfigImpl(this.engineSupplier.invoke(), null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: HttpEngineConfigImpl.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/HttpEngineConfigImpl$SupplierState;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_INITIALIZED", "INITIALIZED", "EXPLICIT_CONFIG", "EXPLICIT_ENGINE", "http-client-engine-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final class SupplierState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SupplierState[] $VALUES;
        public static final SupplierState NOT_INITIALIZED = new SupplierState("NOT_INITIALIZED", 0);
        public static final SupplierState INITIALIZED = new SupplierState("INITIALIZED", 1);
        public static final SupplierState EXPLICIT_CONFIG = new SupplierState("EXPLICIT_CONFIG", 2);
        public static final SupplierState EXPLICIT_ENGINE = new SupplierState("EXPLICIT_ENGINE", 3);

        private static final /* synthetic */ SupplierState[] $values() {
            return new SupplierState[]{NOT_INITIALIZED, INITIALIZED, EXPLICIT_CONFIG, EXPLICIT_ENGINE};
        }

        public static EnumEntries<SupplierState> getEntries() {
            return $ENTRIES;
        }

        public static SupplierState valueOf(String str) {
            return (SupplierState) Enum.valueOf(SupplierState.class, str);
        }

        public static SupplierState[] values() {
            return (SupplierState[]) $VALUES.clone();
        }

        private SupplierState(String str, int i) {
        }

        static {
            SupplierState[] supplierStateArr$values = $values();
            $VALUES = supplierStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(supplierStateArr$values);
        }
    }
}

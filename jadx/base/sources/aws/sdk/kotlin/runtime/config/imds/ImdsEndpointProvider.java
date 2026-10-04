package aws.sdk.kotlin.runtime.config.imds;

import androidx.constraintlayout.widget.ConstraintLayout;
import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.config.imds.EndpointConfiguration;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.http.operation.EndpointResolver;
import aws.smithy.kotlin.runtime.http.operation.ResolveEndpointRequest;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.LazyAsyncValueKt;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImdsEndpointProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nH\u0080@¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0016\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0082@¢\u0006\u0002\u0010\u0014J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0082@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/ImdsEndpointProvider;", "Laws/smithy/kotlin/runtime/http/operation/EndpointResolver;", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "endpointConfiguration", "Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration;", "<init>", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/sdk/kotlin/runtime/config/imds/EndpointConfiguration;)V", "resolvedEndpoint", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "activeProfile", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "resolve", "request", "Laws/smithy/kotlin/runtime/http/operation/ResolveEndpointRequest;", "(Laws/smithy/kotlin/runtime/http/operation/ResolveEndpointRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveImdsEndpoint", "resolveImdsEndpoint$aws_config", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doResolveEndpoint", "resolveEndpointFromConfig", "loadEndpointFromEnv", "loadEndpointFromProfile", "loadEndpointModeFromEnv", "Laws/sdk/kotlin/runtime/config/imds/EndpointMode;", "loadEndpointModeFromProfile", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ImdsEndpointProvider implements EndpointResolver {
    private final LazyAsyncValue<ConfigSection> activeProfile;
    private final EndpointConfiguration endpointConfiguration;
    private final PlatformProvider platformProvider;
    private final LazyAsyncValue<Endpoint> resolvedEndpoint;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$loadEndpointFromProfile$1 */
    /* JADX INFO: compiled from: ImdsEndpointProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider", m1609f = "ImdsEndpointProvider.kt", m1610i = {}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, m1612m = "loadEndpointFromProfile", m1613n = {}, m1614nl = {53}, m1615s = {}, m1616v = 2)
    static final class C31091 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C31091(Continuation<? super C31091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImdsEndpointProvider.this.loadEndpointFromProfile(this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$loadEndpointModeFromProfile$1 */
    /* JADX INFO: compiled from: ImdsEndpointProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider", m1609f = "ImdsEndpointProvider.kt", m1610i = {}, m1611l = {59}, m1612m = "loadEndpointModeFromProfile", m1613n = {}, m1614nl = {60}, m1615s = {}, m1616v = 2)
    static final class C31101 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C31101(Continuation<? super C31101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImdsEndpointProvider.this.loadEndpointModeFromProfile(this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$resolveEndpointFromConfig$1 */
    /* JADX INFO: compiled from: ImdsEndpointProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider", m1609f = "ImdsEndpointProvider.kt", m1610i = {1}, m1611l = {38, 44}, m1612m = "resolveEndpointFromConfig", m1613n = {"endpoint"}, m1614nl = {39, 42}, m1615s = {"L$0"}, m1616v = 2)
    static final class C31111 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C31111(Continuation<? super C31111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImdsEndpointProvider.this.resolveEndpointFromConfig(this);
        }
    }

    public ImdsEndpointProvider(PlatformProvider platformProvider, EndpointConfiguration endpointConfiguration) {
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        Intrinsics.checkNotNullParameter(endpointConfiguration, "endpointConfiguration");
        this.platformProvider = platformProvider;
        this.endpointConfiguration = endpointConfiguration;
        this.resolvedEndpoint = LazyAsyncValueKt.asyncLazy(new ImdsEndpointProvider$resolvedEndpoint$1(this));
        this.activeProfile = LazyAsyncValueKt.asyncLazy(new ImdsEndpointProvider$activeProfile$1(this, null));
    }

    @Override // aws.smithy.kotlin.runtime.http.operation.EndpointResolver
    public Object resolve(ResolveEndpointRequest resolveEndpointRequest, Continuation<? super Endpoint> continuation) {
        return resolveImdsEndpoint$aws_config(continuation);
    }

    public final Object resolveImdsEndpoint$aws_config(Continuation<? super Endpoint> continuation) {
        return this.resolvedEndpoint.get(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doResolveEndpoint(Continuation<? super Endpoint> continuation) {
        EndpointConfiguration endpointConfiguration = this.endpointConfiguration;
        return endpointConfiguration instanceof EndpointConfiguration.Custom ? ((EndpointConfiguration.Custom) endpointConfiguration).getEndpoint() : resolveEndpointFromConfig(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        if (r6 == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0073, code lost:
    
        if (r6 == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveEndpointFromConfig(Continuation<? super Endpoint> continuation) {
        C31111 c31111;
        Endpoint endpointLoadEndpointFromEnv;
        EndpointMode mode;
        if (continuation instanceof C31111) {
            c31111 = (C31111) continuation;
            if ((c31111.label & Integer.MIN_VALUE) != 0) {
                c31111.label -= Integer.MIN_VALUE;
            } else {
                c31111 = new C31111(continuation);
            }
        }
        Object objLoadEndpointFromProfile = c31111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31111.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objLoadEndpointFromProfile);
            endpointLoadEndpointFromEnv = loadEndpointFromEnv();
            if (endpointLoadEndpointFromEnv != null) {
                if (endpointLoadEndpointFromEnv == null) {
                    return endpointLoadEndpointFromEnv;
                }
                EndpointConfiguration endpointConfiguration = this.endpointConfiguration;
                if (endpointConfiguration instanceof EndpointConfiguration.ModeOverride) {
                    mode = ((EndpointConfiguration.ModeOverride) endpointConfiguration).getMode();
                } else {
                    EndpointMode endpointModeLoadEndpointModeFromEnv = loadEndpointModeFromEnv();
                    if (endpointModeLoadEndpointModeFromEnv == null) {
                        c31111.L$0 = SpillingKt.nullOutSpilledVariable(endpointLoadEndpointFromEnv);
                        c31111.label = 2;
                        objLoadEndpointFromProfile = loadEndpointModeFromProfile(c31111);
                    } else {
                        mode = endpointModeLoadEndpointModeFromEnv;
                    }
                }
                return mode.getDefaultEndpoint();
            }
            c31111.label = 1;
            objLoadEndpointFromProfile = loadEndpointFromProfile(c31111);
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objLoadEndpointFromProfile);
            mode = (EndpointMode) objLoadEndpointFromProfile;
            if (mode == null) {
                mode = EndpointMode.IPv4;
            }
            return mode.getDefaultEndpoint();
        }
        ResultKt.throwOnFailure(objLoadEndpointFromProfile);
        endpointLoadEndpointFromEnv = (Endpoint) objLoadEndpointFromProfile;
        if (endpointLoadEndpointFromEnv == null) {
        }
    }

    private final Endpoint loadEndpointFromEnv() {
        String str = (String) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsEc2MetadataServiceEndpoint(), this.platformProvider);
        if (str != null) {
            return ImdsEndpointProviderKt.toEndpoint(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadEndpointFromProfile(Continuation<? super Endpoint> continuation) {
        C31091 c31091;
        if (continuation instanceof C31091) {
            c31091 = (C31091) continuation;
            if ((c31091.label & Integer.MIN_VALUE) != 0) {
                c31091.label -= Integer.MIN_VALUE;
            } else {
                c31091 = new C31091(continuation);
            }
        }
        Object obj = c31091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31091.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LazyAsyncValue<ConfigSection> lazyAsyncValue = this.activeProfile;
            c31091.label = 1;
            obj = lazyAsyncValue.get(c31091);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String orNull$default = ConfigSection.getOrNull$default((ConfigSection) obj, ImdsEndpointProviderKt.EC2_METADATA_SERVICE_ENDPOINT_PROFILE_KEY, null, 2, null);
        if (orNull$default != null) {
            return ImdsEndpointProviderKt.toEndpoint(orNull$default);
        }
        return null;
    }

    private final EndpointMode loadEndpointModeFromEnv() {
        String str = (String) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsEc2MetadataServiceEndpointMode(), this.platformProvider);
        if (str != null) {
            return EndpointMode.INSTANCE.fromValue(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadEndpointModeFromProfile(Continuation<? super EndpointMode> continuation) {
        C31101 c31101;
        if (continuation instanceof C31101) {
            c31101 = (C31101) continuation;
            if ((c31101.label & Integer.MIN_VALUE) != 0) {
                c31101.label -= Integer.MIN_VALUE;
            } else {
                c31101 = new C31101(continuation);
            }
        }
        Object obj = c31101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31101.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LazyAsyncValue<ConfigSection> lazyAsyncValue = this.activeProfile;
            c31101.label = 1;
            obj = lazyAsyncValue.get(c31101);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String orNull$default = ConfigSection.getOrNull$default((ConfigSection) obj, ImdsEndpointProviderKt.EC2_METADATA_SERVICE_ENDPOINT_MODE_PROFILE_KEY, null, 2, null);
        if (orNull$default != null) {
            return EndpointMode.INSTANCE.fromValue(orNull$default);
        }
        return null;
    }
}

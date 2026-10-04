package aws.sdk.kotlin.runtime.config.endpoints;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.p007ts.TsExtractor;
import aws.sdk.kotlin.runtime.ConfigurationException;
import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.sdk.kotlin.runtime.client.AwsClientOption;
import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.config.AwsSdkSettingKt;
import aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt;
import aws.sdk.kotlin.runtime.config.profile.AwsProfileKt;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfigKt;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.LazyAsyncValueKt;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Resolvers.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005H\u0087@¢\u0006\u0002\u0010\b\u001a.\u0010\t\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005H\u0087@¢\u0006\u0002\u0010\b\u001a@\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0087@¢\u0006\u0002\u0010\u0012\u001a$\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H\u0082@¢\u0006\u0002\u0010\b\u001a,\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005H\u0087@¢\u0006\u0002\u0010\b\u001a\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a4\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u00052\u0006\u0010\u001b\u001a\u00020\u0001H\u0087@¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, m1599d2 = {"resolveUseFips", "", "provider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "profile", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveUseDualStack", "resolveEndpointUrl", "Laws/smithy/kotlin/runtime/net/url/Url;", "sharedConfig", "Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;", "sysPropSuffix", "", "envSuffix", "sharedConfigKey", "(Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/util/PlatformProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveIgnoreEndpointUrls", "resolveAccountIdEndpointMode", "Laws/sdk/kotlin/runtime/config/endpoints/AccountIdEndpointMode;", "resolveAccountId", "endpointMode", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "resolveEndpointDiscoveryEnabled", "serviceRequiresEpDiscovery", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ResolversKt {

    /* JADX INFO: compiled from: Resolvers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AccountIdEndpointMode.values().length];
            try {
                iArr[AccountIdEndpointMode.PREFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AccountIdEndpointMode.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AccountIdEndpointMode.REQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveAccountIdEndpointMode$1 */
    /* JADX INFO: compiled from: Resolvers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.endpoints.ResolversKt", m1609f = "Resolvers.kt", m1610i = {0, 0}, m1611l = {TsExtractor.TS_STREAM_TYPE_DVBSUBS}, m1612m = "resolveAccountIdEndpointMode", m1613n = {"provider", "profile"}, m1614nl = {88}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C30981 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30981(Continuation<? super C30981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResolversKt.resolveAccountIdEndpointMode(null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveEndpointDiscoveryEnabled$1 */
    /* JADX INFO: compiled from: Resolvers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.endpoints.ResolversKt", m1609f = "Resolvers.kt", m1610i = {0, 0, 0}, m1611l = {110}, m1612m = "resolveEndpointDiscoveryEnabled", m1613n = {"provider", "profile", "serviceRequiresEpDiscovery"}, m1614nl = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m1615s = {"L$0", "L$1", "Z$0"}, m1616v = 2)
    static final class C31001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C31001(Continuation<? super C31001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResolversKt.resolveEndpointDiscoveryEnabled(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveEndpointUrl$1 */
    /* JADX INFO: compiled from: Resolvers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.endpoints.ResolversKt", m1609f = "Resolvers.kt", m1610i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT, TsExtractor.TS_SYNC_BYTE}, m1612m = "resolveEndpointUrl", m1613n = {"sharedConfig", "sysPropSuffix", "envSuffix", "sharedConfigKey", "provider", "sharedConfig", "sysPropSuffix", "envSuffix", "sharedConfigKey", "provider"}, m1614nl = {67, 70}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, m1616v = 2)
    static final class C31021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C31021(Continuation<? super C31021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResolversKt.resolveEndpointUrl(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveIgnoreEndpointUrls$1 */
    /* JADX INFO: compiled from: Resolvers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.endpoints.ResolversKt", m1609f = "Resolvers.kt", m1610i = {0, 0}, m1611l = {MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64}, m1612m = "resolveIgnoreEndpointUrls", m1613n = {"provider", "sharedConfig"}, m1614nl = {77}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C31031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C31031(Continuation<? super C31031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResolversKt.resolveIgnoreEndpointUrls(null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveUseDualStack$1 */
    /* JADX INFO: compiled from: Resolvers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.endpoints.ResolversKt", m1609f = "Resolvers.kt", m1610i = {0, 0}, m1611l = {38}, m1612m = "resolveUseDualStack", m1613n = {"provider", "profile"}, m1614nl = {-1}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C31041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C31041(Continuation<? super C31041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResolversKt.resolveUseDualStack(null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveUseFips$1 */
    /* JADX INFO: compiled from: Resolvers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.endpoints.ResolversKt", m1609f = "Resolvers.kt", m1610i = {0, 0}, m1611l = {28}, m1612m = "resolveUseFips", m1613n = {"provider", "profile"}, m1614nl = {-1}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C31061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C31061(Continuation<? super C31061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResolversKt.resolveUseFips(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalSdkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveUseFips(PlatformProvider platformProvider, LazyAsyncValue<ConfigSection> lazyAsyncValue, Continuation<? super Boolean> continuation) {
        C31061 c31061;
        if (continuation instanceof C31061) {
            c31061 = (C31061) continuation;
            if ((c31061.label & Integer.MIN_VALUE) != 0) {
                c31061.label -= Integer.MIN_VALUE;
            } else {
                c31061 = new C31061(continuation);
            }
        }
        Object obj = c31061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31061.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Boolean bool = (Boolean) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsUseFipsEndpoint(), platformProvider);
            if (bool != null) {
                return bool;
            }
            c31061.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
            c31061.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
            c31061.label = 1;
            obj = lazyAsyncValue.get(c31061);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return AwsProfileKt.getUseFips((ConfigSection) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveUseFips$2 */
    /* JADX INFO: compiled from: Resolvers.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveUseFips$2", m1609f = "Resolvers.kt", m1610i = {}, m1611l = {26}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    public static final class C31072 extends SuspendLambda implements Function1<Continuation<? super ConfigSection>, Object> {
        final /* synthetic */ PlatformProvider $provider;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31072(PlatformProvider platformProvider, Continuation<? super C31072> continuation) {
            super(1, continuation);
            this.$provider = platformProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C31072(this.$provider, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ConfigSection> continuation) {
            return ((C31072) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AwsConfigLoaderKt.loadAwsSharedConfig$default(this.$provider, null, null, this, 6, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((AwsSharedConfig) obj).getActiveProfile();
        }
    }

    public static /* synthetic */ Object resolveUseFips$default(PlatformProvider platformProvider, LazyAsyncValue lazyAsyncValue, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        if ((i & 2) != 0) {
            lazyAsyncValue = LazyAsyncValueKt.asyncLazy(new C31072(platformProvider, null));
        }
        return resolveUseFips(platformProvider, lazyAsyncValue, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalSdkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveUseDualStack(PlatformProvider platformProvider, LazyAsyncValue<ConfigSection> lazyAsyncValue, Continuation<? super Boolean> continuation) {
        C31041 c31041;
        if (continuation instanceof C31041) {
            c31041 = (C31041) continuation;
            if ((c31041.label & Integer.MIN_VALUE) != 0) {
                c31041.label -= Integer.MIN_VALUE;
            } else {
                c31041 = new C31041(continuation);
            }
        }
        Object obj = c31041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31041.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Boolean bool = (Boolean) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsUseDualStackEndpoint(), platformProvider);
            if (bool != null) {
                return bool;
            }
            c31041.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
            c31041.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
            c31041.label = 1;
            obj = lazyAsyncValue.get(c31041);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return AwsProfileKt.getUseDualStack((ConfigSection) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveUseDualStack$2 */
    /* JADX INFO: compiled from: Resolvers.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveUseDualStack$2", m1609f = "Resolvers.kt", m1610i = {}, m1611l = {36}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    public static final class C31052 extends SuspendLambda implements Function1<Continuation<? super ConfigSection>, Object> {
        final /* synthetic */ PlatformProvider $provider;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31052(PlatformProvider platformProvider, Continuation<? super C31052> continuation) {
            super(1, continuation);
            this.$provider = platformProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C31052(this.$provider, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ConfigSection> continuation) {
            return ((C31052) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AwsConfigLoaderKt.loadAwsSharedConfig$default(this.$provider, null, null, this, 6, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((AwsSharedConfig) obj).getActiveProfile();
        }
    }

    public static /* synthetic */ Object resolveUseDualStack$default(PlatformProvider platformProvider, LazyAsyncValue lazyAsyncValue, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        if ((i & 2) != 0) {
            lazyAsyncValue = LazyAsyncValueKt.asyncLazy(new C31052(platformProvider, null));
        }
        return resolveUseDualStack(platformProvider, lazyAsyncValue, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalSdkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveEndpointUrl(LazyAsyncValue<AwsSharedConfig> lazyAsyncValue, String str, String str2, String str3, PlatformProvider platformProvider, Continuation<? super Url> continuation) {
        C31021 c31021;
        String str4;
        if (continuation instanceof C31021) {
            c31021 = (C31021) continuation;
            if ((c31021.label & Integer.MIN_VALUE) != 0) {
                c31021.label -= Integer.MIN_VALUE;
            } else {
                c31021 = new C31021(continuation);
            }
        }
        Object objResolveIgnoreEndpointUrls = c31021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31021.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objResolveIgnoreEndpointUrls);
            c31021.L$0 = lazyAsyncValue;
            c31021.L$1 = str;
            c31021.L$2 = str2;
            c31021.L$3 = str3;
            c31021.L$4 = platformProvider;
            c31021.label = 1;
            objResolveIgnoreEndpointUrls = resolveIgnoreEndpointUrls(platformProvider, lazyAsyncValue, c31021);
            if (objResolveIgnoreEndpointUrls != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str4 = (String) c31021.L$3;
            ResultKt.throwOnFailure(objResolveIgnoreEndpointUrls);
            return AwsSharedConfigKt.resolveEndpointUrl((AwsSharedConfig) objResolveIgnoreEndpointUrls, str4);
        }
        platformProvider = (PlatformProvider) c31021.L$4;
        str3 = (String) c31021.L$3;
        str2 = (String) c31021.L$2;
        str = (String) c31021.L$1;
        lazyAsyncValue = (LazyAsyncValue) c31021.L$0;
        ResultKt.throwOnFailure(objResolveIgnoreEndpointUrls);
        if (((Boolean) objResolveIgnoreEndpointUrls).booleanValue()) {
            return null;
        }
        Url urlResolveEndpointUrl = AwsSdkSettingKt.resolveEndpointUrl(AwsSdkSetting.INSTANCE, platformProvider, str, str2);
        if (urlResolveEndpointUrl != null) {
            return urlResolveEndpointUrl;
        }
        c31021.L$0 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
        c31021.L$1 = SpillingKt.nullOutSpilledVariable(str);
        c31021.L$2 = SpillingKt.nullOutSpilledVariable(str2);
        c31021.L$3 = str3;
        c31021.L$4 = SpillingKt.nullOutSpilledVariable(platformProvider);
        c31021.label = 2;
        objResolveIgnoreEndpointUrls = lazyAsyncValue.get(c31021);
        if (objResolveIgnoreEndpointUrls != coroutine_suspended) {
            str4 = str3;
            return AwsSharedConfigKt.resolveEndpointUrl((AwsSharedConfig) objResolveIgnoreEndpointUrls, str4);
        }
        return coroutine_suspended;
    }

    public static /* synthetic */ Object resolveEndpointUrl$default(LazyAsyncValue lazyAsyncValue, String str, String str2, String str3, PlatformProvider platformProvider, Continuation continuation, int i, Object obj) {
        if ((i & 16) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        return resolveEndpointUrl(lazyAsyncValue, str, str2, str3, platformProvider, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveIgnoreEndpointUrls(PlatformProvider platformProvider, LazyAsyncValue<AwsSharedConfig> lazyAsyncValue, Continuation<? super Boolean> continuation) {
        C31031 c31031;
        boolean zBooleanValue;
        if (continuation instanceof C31031) {
            c31031 = (C31031) continuation;
            if ((c31031.label & Integer.MIN_VALUE) != 0) {
                c31031.label -= Integer.MIN_VALUE;
            } else {
                c31031 = new C31031(continuation);
            }
        }
        Object obj = c31031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31031.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Boolean bool = (Boolean) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsIgnoreEndpointUrls(), platformProvider);
            if (bool == null) {
                c31031.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
                c31031.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
                c31031.label = 1;
                obj = lazyAsyncValue.get(c31031);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                zBooleanValue = bool.booleanValue();
                return Boxing.boxBoolean(zBooleanValue);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Boolean ignoreEndpointUrls = AwsProfileKt.getIgnoreEndpointUrls(((AwsSharedConfig) obj).getActiveProfile());
        zBooleanValue = ignoreEndpointUrls != null ? ignoreEndpointUrls.booleanValue() : false;
        return Boxing.boxBoolean(zBooleanValue);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalSdkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveAccountIdEndpointMode(PlatformProvider platformProvider, LazyAsyncValue<ConfigSection> lazyAsyncValue, Continuation<? super AccountIdEndpointMode> continuation) {
        C30981 c30981;
        if (continuation instanceof C30981) {
            c30981 = (C30981) continuation;
            if ((c30981.label & Integer.MIN_VALUE) != 0) {
                c30981.label -= Integer.MIN_VALUE;
            } else {
                c30981 = new C30981(continuation);
            }
        }
        Object obj = c30981.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30981.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AccountIdEndpointMode accountIdEndpointMode = (AccountIdEndpointMode) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsAccountIdEndpointMode(), platformProvider);
            if (accountIdEndpointMode != null) {
                return accountIdEndpointMode;
            }
            c30981.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
            c30981.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
            c30981.label = 1;
            obj = lazyAsyncValue.get(c30981);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        AccountIdEndpointMode accountIdEndpointMode2 = AwsProfileKt.getAccountIdEndpointMode((ConfigSection) obj);
        return accountIdEndpointMode2 == null ? AccountIdEndpointMode.PREFERRED : accountIdEndpointMode2;
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveAccountIdEndpointMode$2 */
    /* JADX INFO: compiled from: Resolvers.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveAccountIdEndpointMode$2", m1609f = "Resolvers.kt", m1610i = {}, m1611l = {87}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C30992 extends SuspendLambda implements Function1<Continuation<? super ConfigSection>, Object> {
        final /* synthetic */ PlatformProvider $provider;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C30992(PlatformProvider platformProvider, Continuation<? super C30992> continuation) {
            super(1, continuation);
            this.$provider = platformProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C30992(this.$provider, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ConfigSection> continuation) {
            return ((C30992) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AwsConfigLoaderKt.loadAwsSharedConfig$default(this.$provider, null, null, this, 6, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((AwsSharedConfig) obj).getActiveProfile();
        }
    }

    public static /* synthetic */ Object resolveAccountIdEndpointMode$default(PlatformProvider platformProvider, LazyAsyncValue lazyAsyncValue, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        if ((i & 2) != 0) {
            lazyAsyncValue = LazyAsyncValueKt.asyncLazy(new C30992(platformProvider, null));
        }
        return resolveAccountIdEndpointMode(platformProvider, lazyAsyncValue, continuation);
    }

    @InternalSdkApi
    public static final String resolveAccountId(AccountIdEndpointMode endpointMode, Attributes attributes) {
        Intrinsics.checkNotNullParameter(endpointMode, "endpointMode");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        int i = WhenMappings.$EnumSwitchMapping$0[endpointMode.ordinal()];
        if (i == 1) {
            return (String) attributes.getOrNull(AwsClientOption.INSTANCE.getAccountId());
        }
        if (i == 2) {
            return null;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        String str = (String) attributes.getOrNull(AwsClientOption.INSTANCE.getAccountId());
        if (str != null) {
            return str;
        }
        throw new ConfigurationException("AccountIdEndpointMode is set to required but no AWS account ID found");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalSdkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveEndpointDiscoveryEnabled(PlatformProvider platformProvider, LazyAsyncValue<ConfigSection> lazyAsyncValue, boolean z, Continuation<? super Boolean> continuation) {
        C31001 c31001;
        if (continuation instanceof C31001) {
            c31001 = (C31001) continuation;
            if ((c31001.label & Integer.MIN_VALUE) != 0) {
                c31001.label -= Integer.MIN_VALUE;
            } else {
                c31001 = new C31001(continuation);
            }
        }
        Object obj = c31001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31001.label;
        boolean zBooleanValue = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Boolean bool = (Boolean) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsEndpointDiscoveryEnabled(), platformProvider);
            if (bool == null) {
                c31001.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
                c31001.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
                c31001.Z$0 = z;
                c31001.label = 1;
                obj = lazyAsyncValue.get(c31001);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                zBooleanValue = bool.booleanValue();
                return Boxing.boxBoolean(zBooleanValue);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = c31001.Z$0;
            ResultKt.throwOnFailure(obj);
        }
        Boolean endpointDiscoveryEnabled = AwsProfileKt.getEndpointDiscoveryEnabled((ConfigSection) obj);
        if (endpointDiscoveryEnabled != null) {
            zBooleanValue = endpointDiscoveryEnabled.booleanValue();
        } else if (!z) {
            zBooleanValue = false;
        }
        return Boxing.boxBoolean(zBooleanValue);
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveEndpointDiscoveryEnabled$2 */
    /* JADX INFO: compiled from: Resolvers.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.endpoints.ResolversKt$resolveEndpointDiscoveryEnabled$2", m1609f = "Resolvers.kt", m1610i = {}, m1611l = {107}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C31012 extends SuspendLambda implements Function1<Continuation<? super ConfigSection>, Object> {
        final /* synthetic */ PlatformProvider $provider;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31012(PlatformProvider platformProvider, Continuation<? super C31012> continuation) {
            super(1, continuation);
            this.$provider = platformProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C31012(this.$provider, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ConfigSection> continuation) {
            return ((C31012) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AwsConfigLoaderKt.loadAwsSharedConfig$default(this.$provider, null, null, this, 6, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((AwsSharedConfig) obj).getActiveProfile();
        }
    }

    public static /* synthetic */ Object resolveEndpointDiscoveryEnabled$default(PlatformProvider platformProvider, LazyAsyncValue lazyAsyncValue, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        if ((i & 2) != 0) {
            lazyAsyncValue = LazyAsyncValueKt.asyncLazy(new C31012(platformProvider, null));
        }
        return resolveEndpointDiscoveryEnabled(platformProvider, lazyAsyncValue, z, continuation);
    }
}

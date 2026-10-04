package aws.sdk.kotlin.runtime.region;

import aws.sdk.kotlin.runtime.config.imds.ImdsClient;
import aws.sdk.kotlin.runtime.config.imds.InstanceMetadataProvider;
import aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.smithy.kotlin.runtime.client.region.RegionProvider;
import aws.smithy.kotlin.runtime.client.region.RegionProviderChain;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.LazyAsyncValueKt;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultRegionProviderChainJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004B5\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/runtime/region/DefaultRegionProviderChain;", "Laws/smithy/kotlin/runtime/client/region/RegionProviderChain;", "Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "Ljava/io/Closeable;", "Laws/smithy/kotlin/runtime/io/Closeable;", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "imdsClient", "Lkotlin/Lazy;", "Laws/sdk/kotlin/runtime/config/imds/InstanceMetadataProvider;", "profile", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "<init>", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Lkotlin/Lazy;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;)V", "close", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultRegionProviderChain extends RegionProviderChain implements RegionProvider, Closeable {
    public DefaultRegionProviderChain() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultRegionProviderChain(PlatformProvider platformProvider, Lazy<? extends InstanceMetadataProvider> imdsClient, LazyAsyncValue<ConfigSection> profile) {
        super(new JvmSystemPropRegionProvider(platformProvider), new EnvironmentRegionProvider(platformProvider), new ProfileRegionProvider(profile), new ImdsRegionProvider(imdsClient, platformProvider));
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        Intrinsics.checkNotNullParameter(imdsClient, "imdsClient");
        Intrinsics.checkNotNullParameter(profile, "profile");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DefaultRegionProviderChain(PlatformProvider platformProvider, Lazy lazy, LazyAsyncValue lazyAsyncValue, int i, DefaultConstructorMarker defaultConstructorMarker) {
        platformProvider = (i & 1) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider;
        this(platformProvider, (i & 2) != 0 ? LazyKt.lazy(new Function0() { // from class: aws.sdk.kotlin.runtime.region.DefaultRegionProviderChain$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DefaultRegionProviderChain._init_$lambda$0();
            }
        }) : lazy, (i & 4) != 0 ? LazyAsyncValueKt.asyncLazy(new C31302(platformProvider, null)) : lazyAsyncValue);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        for (RegionProvider regionProvider : getProviders()) {
            if (regionProvider instanceof Closeable) {
                ((Closeable) regionProvider).close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImdsClient _init_$lambda$0() {
        return new ImdsClient();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.region.DefaultRegionProviderChain$2 */
    /* JADX INFO: compiled from: DefaultRegionProviderChainJVM.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.region.DefaultRegionProviderChain$2", m1609f = "DefaultRegionProviderChainJVM.kt", m1610i = {}, m1611l = {35}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    public static final class C31302 extends SuspendLambda implements Function1<Continuation<? super ConfigSection>, Object> {
        final /* synthetic */ PlatformProvider $platformProvider;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31302(PlatformProvider platformProvider, Continuation<? super C31302> continuation) {
            super(1, continuation);
            this.$platformProvider = platformProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C31302(this.$platformProvider, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ConfigSection> continuation) {
            return ((C31302) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AwsConfigLoaderKt.loadAwsSharedConfig$default(this.$platformProvider, null, null, this, 6, null);
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
}

package aws.sdk.kotlin.runtime.region;

import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.config.imds.ImdsClient;
import aws.sdk.kotlin.runtime.config.imds.InstanceMetadataProvider;
import aws.smithy.kotlin.runtime.client.region.RegionProvider;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.LazyAsyncValueKt;
import aws.smithy.kotlin.runtime.util.PlatformEnvironProvider;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import java.io.Closeable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImdsRegionProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B!\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Laws/sdk/kotlin/runtime/region/ImdsRegionProvider;", "Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "Ljava/io/Closeable;", "Laws/smithy/kotlin/runtime/io/Closeable;", "client", "Lkotlin/Lazy;", "Laws/sdk/kotlin/runtime/config/imds/InstanceMetadataProvider;", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;", "<init>", "(Lkotlin/Lazy;Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;)V", "resolvedRegion", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "", "getRegion", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadRegion", "close", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ImdsRegionProvider implements RegionProvider, Closeable {
    private final Lazy<InstanceMetadataProvider> client;
    private final PlatformEnvironProvider platformProvider;
    private final LazyAsyncValue<String> resolvedRegion;

    /* JADX WARN: Multi-variable type inference failed */
    public ImdsRegionProvider() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImdsRegionProvider(Lazy<? extends InstanceMetadataProvider> client, PlatformEnvironProvider platformProvider) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        this.client = client;
        this.platformProvider = platformProvider;
        this.resolvedRegion = LazyAsyncValueKt.asyncLazy(new ImdsRegionProvider$resolvedRegion$1(this));
    }

    public /* synthetic */ ImdsRegionProvider(Lazy lazy, PlatformProvider platformProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? LazyKt.lazy(new Function0() { // from class: aws.sdk.kotlin.runtime.region.ImdsRegionProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImdsRegionProvider._init_$lambda$0();
            }
        }) : lazy, (i & 2) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImdsClient _init_$lambda$0() {
        return new ImdsClient();
    }

    @Override // aws.smithy.kotlin.runtime.client.region.RegionProvider
    public Object getRegion(Continuation<? super String> continuation) {
        if (Intrinsics.areEqual(EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsEc2MetadataDisabled(), this.platformProvider), Boxing.boxBoolean(true))) {
            return null;
        }
        return this.resolvedRegion.get(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadRegion(Continuation<? super String> continuation) {
        return this.client.getValue().get("/latest/meta-data/placement/region", continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.client.isInitialized()) {
            this.client.getValue().close();
        }
    }
}

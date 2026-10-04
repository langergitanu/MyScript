package aws.sdk.kotlin.runtime.region;

import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.smithy.kotlin.runtime.client.region.RegionProvider;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import aws.smithy.kotlin.runtime.util.PropertyProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JvmSystemPropRegionProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/runtime/region/JvmSystemPropRegionProvider;", "Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "propertyProvider", "Laws/smithy/kotlin/runtime/util/PropertyProvider;", "<init>", "(Laws/smithy/kotlin/runtime/util/PropertyProvider;)V", "getRegion", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JvmSystemPropRegionProvider implements RegionProvider {
    private final PropertyProvider propertyProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public JvmSystemPropRegionProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public JvmSystemPropRegionProvider(PropertyProvider propertyProvider) {
        Intrinsics.checkNotNullParameter(propertyProvider, "propertyProvider");
        this.propertyProvider = propertyProvider;
    }

    public /* synthetic */ JvmSystemPropRegionProvider(PlatformProvider platformProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PlatformProvider.INSTANCE.getSystem() : platformProvider);
    }

    @Override // aws.smithy.kotlin.runtime.client.region.RegionProvider
    public Object getRegion(Continuation<? super String> continuation) {
        return this.propertyProvider.getProperty(AwsSdkSetting.INSTANCE.getAwsRegion().getSysProp());
    }
}

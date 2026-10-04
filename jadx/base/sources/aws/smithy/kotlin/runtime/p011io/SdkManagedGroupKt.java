package aws.smithy.kotlin.runtime.p011io;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkManagedGroup.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkManagedGroup;", "", "resource", "", "addIfManaged", "(Laws/smithy/kotlin/runtime/io/SdkManagedGroup;Ljava/lang/Object;)V", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkManagedGroupKt {
    @InternalApi
    public static final void addIfManaged(SdkManagedGroup sdkManagedGroup, Object resource) {
        Intrinsics.checkNotNullParameter(sdkManagedGroup, "<this>");
        Intrinsics.checkNotNullParameter(resource, "resource");
        if (resource instanceof SdkManaged) {
            sdkManagedGroup.add((SdkManaged) resource);
        }
    }
}

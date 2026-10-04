package aws.smithy.kotlin.runtime.p011io;

import aws.smithy.kotlin.runtime.InternalApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkManagedGroup.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\r¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkManagedGroup;", "", "", "Laws/smithy/kotlin/runtime/io/SdkManaged;", "resources", "<init>", "(Ljava/util/List;)V", "resource", "", "add", "(Laws/smithy/kotlin/runtime/io/SdkManaged;)V", "unshareAll", "()V", "Ljava/util/List;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkManagedGroup {
    private final List<SdkManaged> resources;

    /* JADX WARN: Multi-variable type inference failed */
    public SdkManagedGroup() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public SdkManagedGroup(List<SdkManaged> resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.resources = resources;
    }

    public /* synthetic */ SdkManagedGroup(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public final void add(SdkManaged resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        resource.share();
        this.resources.add(resource);
    }

    public final void unshareAll() {
        Iterator<T> it = this.resources.iterator();
        while (it.hasNext()) {
            ((SdkManaged) it.next()).unshare();
        }
    }
}

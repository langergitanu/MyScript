package aws.smithy.kotlin.runtime.p011io;

import aws.smithy.kotlin.runtime.InternalApi;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkManagedCloseable.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\n¨\u0006\u000b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkManagedCloseable;", "Laws/smithy/kotlin/runtime/io/SdkManagedBase;", "Ljava/io/Closeable;", "Laws/smithy/kotlin/runtime/io/Closeable;", "closeable", "<init>", "(Ljava/io/Closeable;)V", "", "unshare", "()Z", "Ljava/io/Closeable;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class SdkManagedCloseable extends SdkManagedBase {
    private final Closeable closeable;

    public SdkManagedCloseable(Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "closeable");
        this.closeable = closeable;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkManagedBase, aws.smithy.kotlin.runtime.p011io.SdkManaged
    public boolean unshare() throws IOException {
        boolean zUnshare = super.unshare();
        if (zUnshare) {
            this.closeable.close();
        }
        return zUnshare;
    }
}

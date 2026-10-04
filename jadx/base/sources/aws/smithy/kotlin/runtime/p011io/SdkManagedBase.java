package aws.smithy.kotlin.runtime.p011io;

import aws.smithy.kotlin.runtime.InternalApi;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: SdkManaged.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\t\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/SdkManagedBase;", "Laws/smithy/kotlin/runtime/io/SdkManaged;", "<init>", "()V", "", FirebaseAnalytics.Event.SHARE, "", "unshare", "()Z", "aws/smithy/kotlin/runtime/io/SdkManagedBase$state$1", "state", "Laws/smithy/kotlin/runtime/io/SdkManagedBase$state$1;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class SdkManagedBase implements SdkManaged {
    private final SdkManagedBase$state$1 state = new SdkManagedBase$state$1();

    @Override // aws.smithy.kotlin.runtime.p011io.SdkManaged
    public void share() {
        synchronized (this.state) {
            if (this.state.getIsUnshared()) {
                throw new IllegalStateException("caller attempted to share() a fully unshared object".toString());
            }
            SdkManagedBase$state$1 sdkManagedBase$state$1 = this.state;
            sdkManagedBase$state$1.setShareCount(sdkManagedBase$state$1.getShareCount() + 1);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.SdkManaged
    public boolean unshare() {
        synchronized (this.state) {
            if (this.state.getIsUnshared()) {
                return false;
            }
            this.state.setShareCount(r1.getShareCount() - 1);
            if (this.state.getShareCount() > 0) {
                return false;
            }
            this.state.setUnshared(true);
            return true;
        }
    }
}

package aws.smithy.kotlin.runtime.p011io;

import kotlin.Metadata;

/* JADX INFO: compiled from: SdkManaged.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"aws/smithy/kotlin/runtime/io/SdkManagedBase$state$1", "", "", "shareCount", "I", "getShareCount", "()I", "setShareCount", "(I)V", "", "isUnshared", "Z", "()Z", "setUnshared", "(Z)V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkManagedBase$state$1 {
    private boolean isUnshared;
    private int shareCount;

    SdkManagedBase$state$1() {
    }

    public final int getShareCount() {
        return this.shareCount;
    }

    public final void setShareCount(int i) {
        this.shareCount = i;
    }

    /* JADX INFO: renamed from: isUnshared, reason: from getter */
    public final boolean getIsUnshared() {
        return this.isUnshared;
    }

    public final void setUnshared(boolean z) {
        this.isUnshared = z;
    }
}

package aws.sdk.kotlin.runtime.auth.credentials;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginTokenProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/ECKeyData;", "", "d", "", "x", "y", "<init>", "([B[B[B)V", "getD", "()[B", "getX", "getY", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ECKeyData {
    private final byte[] d;
    private final byte[] x;
    private final byte[] y;

    public static /* synthetic */ ECKeyData copy$default(ECKeyData eCKeyData, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = eCKeyData.d;
        }
        if ((i & 2) != 0) {
            bArr2 = eCKeyData.x;
        }
        if ((i & 4) != 0) {
            bArr3 = eCKeyData.y;
        }
        return eCKeyData.copy(bArr, bArr2, bArr3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final byte[] getD() {
        return this.d;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final byte[] getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final byte[] getY() {
        return this.y;
    }

    public final ECKeyData copy(byte[] d, byte[] x, byte[] y) {
        Intrinsics.checkNotNullParameter(d, "d");
        Intrinsics.checkNotNullParameter(x, "x");
        Intrinsics.checkNotNullParameter(y, "y");
        return new ECKeyData(d, x, y);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECKeyData)) {
            return false;
        }
        ECKeyData eCKeyData = (ECKeyData) other;
        return Intrinsics.areEqual(this.d, eCKeyData.d) && Intrinsics.areEqual(this.x, eCKeyData.x) && Intrinsics.areEqual(this.y, eCKeyData.y);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.d) * 31) + Arrays.hashCode(this.x)) * 31) + Arrays.hashCode(this.y);
    }

    public String toString() {
        return "ECKeyData(d=" + Arrays.toString(this.d) + ", x=" + Arrays.toString(this.x) + ", y=" + Arrays.toString(this.y) + ')';
    }

    public ECKeyData(byte[] d, byte[] x, byte[] y) {
        Intrinsics.checkNotNullParameter(d, "d");
        Intrinsics.checkNotNullParameter(x, "x");
        Intrinsics.checkNotNullParameter(y, "y");
        this.d = d;
        this.x = x;
        this.y = y;
    }

    public final byte[] getD() {
        return this.d;
    }

    public final byte[] getX() {
        return this.x;
    }

    public final byte[] getY() {
        return this.y;
    }
}

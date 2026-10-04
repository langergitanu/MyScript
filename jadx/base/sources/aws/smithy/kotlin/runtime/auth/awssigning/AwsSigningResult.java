package aws.smithy.kotlin.runtime.auth.awssigning;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsSigningResult.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0096\u0082\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\u000e\u0010\u0012\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "output", "signature", "", "<init>", "(Ljava/lang/Object;[B)V", "getOutput", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSignature", "()[B", "equals", "", "other", "hashCode", "", "component1", "component2", "copy", "(Ljava/lang/Object;[B)Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningResult;", "toString", "", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class AwsSigningResult<T> {
    private final T output;
    private final byte[] signature;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AwsSigningResult copy$default(AwsSigningResult awsSigningResult, Object obj, byte[] bArr, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = awsSigningResult.output;
        }
        if ((i & 2) != 0) {
            bArr = awsSigningResult.signature;
        }
        return awsSigningResult.copy(obj, bArr);
    }

    public final T component1() {
        return this.output;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final byte[] getSignature() {
        return this.signature;
    }

    public final AwsSigningResult<T> copy(T output, byte[] signature) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        return new AwsSigningResult<>(output, signature);
    }

    public String toString() {
        return "AwsSigningResult(output=" + this.output + ", signature=" + Arrays.toString(this.signature) + ')';
    }

    public AwsSigningResult(T t, byte[] signature) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        this.output = t;
        this.signature = signature;
    }

    public final T getOutput() {
        return this.output;
    }

    public final byte[] getSignature() {
        return this.signature;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        AwsSigningResult awsSigningResult = (AwsSigningResult) other;
        return Intrinsics.areEqual(this.output, awsSigningResult.output) && Arrays.equals(this.signature, awsSigningResult.signature);
    }

    public int hashCode() {
        T t = this.output;
        return ((t != null ? t.hashCode() : 0) * 31) + Arrays.hashCode(this.signature);
    }
}

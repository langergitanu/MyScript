package aws.smithy.kotlin.runtime.hashing;

import aws.smithy.kotlin.runtime.InternalApi;
import com.revenuecat.purchases.common.verification.SigningManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Sha256.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"", SigningManager.POST_PARAMS_ALGORITHM, "([B)[B", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Sha256Kt {
    @InternalApi
    public static final byte[] sha256(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return HashFunctionKt.hash(new Sha256(), bArr);
    }
}

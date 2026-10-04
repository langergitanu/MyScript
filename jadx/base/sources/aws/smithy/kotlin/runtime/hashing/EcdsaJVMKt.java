package aws.smithy.kotlin.runtime.hashing;

import aws.smithy.kotlin.runtime.content.BigInteger;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.InvalidKeySpecException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EcdsaJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"", SubscriberAttributeKt.JSON_NAME_KEY, "message", "ecdsaSecp256r1", "([B[B)[B", "Laws/smithy/kotlin/runtime/content/BigInteger;", "Ljava/math/BigInteger;", "toJvm", "(Laws/smithy/kotlin/runtime/content/BigInteger;)Ljava/math/BigInteger;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EcdsaJVMKt {
    public static final byte[] ecdsaSecp256r1(byte[] key, byte[] message) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        BigInteger bigInteger = new BigInteger(key);
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
        PrivateKey privateKey = keyPairGenerator.generateKeyPair().getPrivate();
        Intrinsics.checkNotNull(privateKey, "null cannot be cast to non-null type java.security.interfaces.ECPrivateKey");
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance("EC").generatePrivate(new ECPrivateKeySpec(toJvm(bigInteger), ((ECPrivateKey) privateKey).getParams()));
        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initSign(privateKeyGeneratePrivate);
        signature.update(message);
        byte[] bArrSign = signature.sign();
        Intrinsics.checkNotNullExpressionValue(bArrSign, "sign(...)");
        return bArrSign;
    }

    private static final java.math.BigInteger toJvm(BigInteger bigInteger) {
        return new java.math.BigInteger(1, bigInteger.toByteArray());
    }
}

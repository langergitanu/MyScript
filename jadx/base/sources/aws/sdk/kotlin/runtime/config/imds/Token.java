package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.time.Instant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: Token.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/Token;", "", "value", "", ClientCookie.EXPIRES_ATTR, "Laws/smithy/kotlin/runtime/time/Instant;", "<init>", "([BLaws/smithy/kotlin/runtime/time/Instant;)V", "getValue", "()[B", "getExpires", "()Laws/smithy/kotlin/runtime/time/Instant;", "equals", "", "other", "hashCode", "", "component1", "component2", "copy", "toString", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class Token {
    private final Instant expires;
    private final byte[] value;

    public static /* synthetic */ Token copy$default(Token token, byte[] bArr, Instant instant, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = token.value;
        }
        if ((i & 2) != 0) {
            instant = token.expires;
        }
        return token.copy(bArr, instant);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final byte[] getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Instant getExpires() {
        return this.expires;
    }

    public final Token copy(byte[] value, Instant expires) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(expires, "expires");
        return new Token(value, expires);
    }

    public String toString() {
        return "Token(value=" + Arrays.toString(this.value) + ", expires=" + this.expires + ')';
    }

    public Token(byte[] value, Instant expires) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(expires, "expires");
        this.value = value;
        this.expires = expires;
    }

    public final Instant getExpires() {
        return this.expires;
    }

    public final byte[] getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Token token = (Token) other;
        return Arrays.equals(this.value, token.value) && Intrinsics.areEqual(this.expires, token.expires);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.value) * 31) + this.expires.hashCode();
    }
}

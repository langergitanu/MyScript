package aws.smithy.kotlin.runtime.text.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Encodable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u0000  2\u00020\u0001:\u0001 B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u00020\rH\u0096\u0080\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0017\u0010\u001f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b\u001f\u0010\u001e¨\u0006!"}, m1599d2 = {"Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "", "", "decoded", "encoded", "Laws/smithy/kotlin/runtime/text/encoding/Encoding;", "encoding", "<init>", "(Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/text/encoding/Encoding;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "reencode", "()Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "newEncoding", "(Laws/smithy/kotlin/runtime/text/encoding/Encoding;)Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getDecoded", "getEncoded", "Laws/smithy/kotlin/runtime/text/encoding/Encoding;", "getEncoding", "()Laws/smithy/kotlin/runtime/text/encoding/Encoding;", "isEmpty", "Z", "()Z", "isNotEmpty", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Encodable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Encodable Empty = new Encodable("", "", Encoding.INSTANCE.getNone$runtime_core());
    private final String decoded;
    private final String encoded;
    private final Encoding encoding;
    private final boolean isEmpty;
    private final boolean isNotEmpty;

    public Encodable(String decoded, String encoded, Encoding encoding) {
        Intrinsics.checkNotNullParameter(decoded, "decoded");
        Intrinsics.checkNotNullParameter(encoded, "encoded");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        this.decoded = decoded;
        this.encoded = encoded;
        this.encoding = encoding;
        boolean z = decoded.length() == 0 && encoded.length() == 0;
        this.isEmpty = z;
        this.isNotEmpty = !z;
    }

    public final String getDecoded() {
        return this.decoded;
    }

    public final String getEncoded() {
        return this.encoded;
    }

    public final Encoding getEncoding() {
        return this.encoding;
    }

    /* JADX INFO: compiled from: Encodable.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/text/encoding/Encodable$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "Empty", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "getEmpty", "()Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Encodable getEmpty() {
            return Encodable.Empty;
        }
    }

    /* JADX INFO: renamed from: isEmpty, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    /* JADX INFO: renamed from: isNotEmpty, reason: from getter */
    public final boolean getIsNotEmpty() {
        return this.isNotEmpty;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Encodable)) {
            return false;
        }
        Encodable encodable = (Encodable) other;
        return Intrinsics.areEqual(this.decoded, encodable.decoded) && Intrinsics.areEqual(this.encoded, encodable.encoded);
    }

    public int hashCode() {
        return (this.decoded.hashCode() * 31) + this.encoded.hashCode();
    }

    public final Encodable reencode() {
        return reencode(this.encoding);
    }

    public final Encodable reencode(Encoding newEncoding) {
        Intrinsics.checkNotNullParameter(newEncoding, "newEncoding");
        return newEncoding.encodableFromDecoded(this.decoded);
    }

    public String toString() {
        return "Encodable(decoded=" + this.decoded + ", encoded=" + this.encoded + ", encoding=" + this.encoding.getName() + ")";
    }
}

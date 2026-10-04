package aws.smithy.kotlin.runtime.text.encoding;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Encoding.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/text/encoding/Encoding;", "", "", "encoded", "decode", "(Ljava/lang/String;)Ljava/lang/String;", "decoded", "encode", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "encodableFromDecoded", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "encodableFromEncoded", "getName", "()Ljava/lang/String;", "name", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Encoding {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String decode(String encoded);

    String encode(String decoded);

    String getName();

    /* JADX INFO: compiled from: Encoding.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/text/encoding/Encoding$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/text/encoding/Encoding;", "None", "Laws/smithy/kotlin/runtime/text/encoding/Encoding;", "getNone$runtime_core", "()Laws/smithy/kotlin/runtime/text/encoding/Encoding;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Encoding None = new Encoding() { // from class: aws.smithy.kotlin.runtime.text.encoding.Encoding$Companion$None$1
            private final String name = "(no encoding)";

            @Override // aws.smithy.kotlin.runtime.text.encoding.Encoding
            public String decode(String encoded) {
                Intrinsics.checkNotNullParameter(encoded, "encoded");
                return encoded;
            }

            @Override // aws.smithy.kotlin.runtime.text.encoding.Encoding
            public String encode(String decoded) {
                Intrinsics.checkNotNullParameter(decoded, "decoded");
                return decoded;
            }

            @Override // aws.smithy.kotlin.runtime.text.encoding.Encoding
            public /* bridge */ Encodable encodableFromDecoded(String str) {
                return super.encodableFromDecoded(str);
            }

            @Override // aws.smithy.kotlin.runtime.text.encoding.Encoding
            public /* bridge */ Encodable encodableFromEncoded(String str) {
                return super.encodableFromEncoded(str);
            }

            @Override // aws.smithy.kotlin.runtime.text.encoding.Encoding
            public String getName() {
                return this.name;
            }
        };

        private Companion() {
        }

        public final Encoding getNone$runtime_core() {
            return None;
        }
    }

    /* JADX INFO: compiled from: Encoding.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Encodable encodableFromDecoded(Encoding encoding, String decoded) {
            Intrinsics.checkNotNullParameter(decoded, "decoded");
            return Encoding.super.encodableFromDecoded(decoded);
        }

        @Deprecated
        public static Encodable encodableFromEncoded(Encoding encoding, String encoded) {
            Intrinsics.checkNotNullParameter(encoded, "encoded");
            return Encoding.super.encodableFromEncoded(encoded);
        }
    }

    default Encodable encodableFromDecoded(String decoded) {
        Intrinsics.checkNotNullParameter(decoded, "decoded");
        return new Encodable(decoded, encode(decoded), this);
    }

    default Encodable encodableFromEncoded(String encoded) {
        Intrinsics.checkNotNullParameter(encoded, "encoded");
        return new Encodable(decode(encoded), encoded, this);
    }
}

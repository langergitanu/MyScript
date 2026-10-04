package aws.smithy.kotlin.runtime.auth.awssigning;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HashSpecification.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification;", "", "<init>", "()V", "CalculateFromPayload", "HashLiteral", "UnsignedPayload", "EmptyBody", "StreamingAws4HmacSha256Payload", "StreamingAws4HmacSha256PayloadWithTrailers", "StreamingUnsignedPayloadWithTrailers", "StreamingAws4HmacSha256Events", "Precalculated", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$CalculateFromPayload;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$HashLiteral;", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class HashSpecification {
    public /* synthetic */ HashSpecification(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HashSpecification() {
    }

    /* JADX INFO: compiled from: HashSpecification.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$CalculateFromPayload;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification;", "<init>", "()V", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class CalculateFromPayload extends HashSpecification {
        public static final CalculateFromPayload INSTANCE = new CalculateFromPayload();

        private CalculateFromPayload() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: HashSpecification.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0007\b\t\n\u000b\f\r\u000e¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$HashLiteral;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification;", "hash", "", "<init>", "(Ljava/lang/String;)V", "getHash", "()Ljava/lang/String;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$EmptyBody;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$Precalculated;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$StreamingAws4HmacSha256Events;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$StreamingAws4HmacSha256Payload;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$StreamingAws4HmacSha256PayloadWithTrailers;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$StreamingUnsignedPayloadWithTrailers;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$UnsignedPayload;", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class HashLiteral extends HashSpecification {
        private final String hash;

        public /* synthetic */ HashLiteral(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        private HashLiteral(String str) {
            super(null);
            this.hash = str;
        }

        public String getHash() {
            return this.hash;
        }
    }

    /* JADX INFO: compiled from: HashSpecification.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$UnsignedPayload;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$HashLiteral;", "<init>", "()V", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class UnsignedPayload extends HashLiteral {
        public static final UnsignedPayload INSTANCE = new UnsignedPayload();

        private UnsignedPayload() {
            super("UNSIGNED-PAYLOAD", null);
        }
    }

    /* JADX INFO: compiled from: HashSpecification.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$EmptyBody;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$HashLiteral;", "<init>", "()V", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EmptyBody extends HashLiteral {
        public static final EmptyBody INSTANCE = new EmptyBody();

        private EmptyBody() {
            super("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", null);
        }
    }

    /* JADX INFO: compiled from: HashSpecification.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$StreamingAws4HmacSha256Payload;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$HashLiteral;", "<init>", "()V", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class StreamingAws4HmacSha256Payload extends HashLiteral {
        public static final StreamingAws4HmacSha256Payload INSTANCE = new StreamingAws4HmacSha256Payload();

        private StreamingAws4HmacSha256Payload() {
            super("STREAMING-AWS4-HMAC-SHA256-PAYLOAD", null);
        }
    }

    /* JADX INFO: compiled from: HashSpecification.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$StreamingAws4HmacSha256PayloadWithTrailers;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$HashLiteral;", "<init>", "()V", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class StreamingAws4HmacSha256PayloadWithTrailers extends HashLiteral {
        public static final StreamingAws4HmacSha256PayloadWithTrailers INSTANCE = new StreamingAws4HmacSha256PayloadWithTrailers();

        private StreamingAws4HmacSha256PayloadWithTrailers() {
            super("STREAMING-AWS4-HMAC-SHA256-PAYLOAD-TRAILER", null);
        }
    }

    /* JADX INFO: compiled from: HashSpecification.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$StreamingUnsignedPayloadWithTrailers;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$HashLiteral;", "<init>", "()V", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class StreamingUnsignedPayloadWithTrailers extends HashLiteral {
        public static final StreamingUnsignedPayloadWithTrailers INSTANCE = new StreamingUnsignedPayloadWithTrailers();

        private StreamingUnsignedPayloadWithTrailers() {
            super("STREAMING-UNSIGNED-PAYLOAD-TRAILER", null);
        }
    }

    /* JADX INFO: compiled from: HashSpecification.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$StreamingAws4HmacSha256Events;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$HashLiteral;", "<init>", "()V", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class StreamingAws4HmacSha256Events extends HashLiteral {
        public static final StreamingAws4HmacSha256Events INSTANCE = new StreamingAws4HmacSha256Events();

        private StreamingAws4HmacSha256Events() {
            super("STREAMING-AWS4-HMAC-SHA256-EVENTS", null);
        }
    }

    /* JADX INFO: compiled from: HashSpecification.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$Precalculated;", "Laws/smithy/kotlin/runtime/auth/awssigning/HashSpecification$HashLiteral;", "hash", "", "<init>", "(Ljava/lang/String;)V", "getHash", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Precalculated extends HashLiteral {
        private final String hash;

        public static /* synthetic */ Precalculated copy$default(Precalculated precalculated, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = precalculated.hash;
            }
            return precalculated.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getHash() {
            return this.hash;
        }

        public final Precalculated copy(String hash) {
            Intrinsics.checkNotNullParameter(hash, "hash");
            return new Precalculated(hash);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Precalculated) && Intrinsics.areEqual(this.hash, ((Precalculated) other).hash);
        }

        public int hashCode() {
            return this.hash.hashCode();
        }

        public String toString() {
            return "Precalculated(hash=" + this.hash + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Precalculated(String hash) {
            super(hash, null);
            Intrinsics.checkNotNullParameter(hash, "hash");
            this.hash = hash;
        }

        @Override // aws.smithy.kotlin.runtime.auth.awssigning.HashSpecification.HashLiteral
        public String getHash() {
            return this.hash;
        }
    }
}

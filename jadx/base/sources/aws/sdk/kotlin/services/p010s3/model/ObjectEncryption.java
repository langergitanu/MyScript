package aws.sdk.kotlin.services.p010s3.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObjectEncryption.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0082\u0001\u0002\t\n¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ObjectEncryption;", "", "<init>", "()V", "asSsekms", "Laws/sdk/kotlin/services/s3/model/SsekmsEncryption;", "asSsekmsOrNull", "Ssekms", "SdkUnknown", "Laws/sdk/kotlin/services/s3/model/ObjectEncryption$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/ObjectEncryption$Ssekms;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class ObjectEncryption {
    public /* synthetic */ ObjectEncryption(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ObjectEncryption() {
    }

    /* JADX INFO: compiled from: ObjectEncryption.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ObjectEncryption$Ssekms;", "Laws/sdk/kotlin/services/s3/model/ObjectEncryption;", "value", "Laws/sdk/kotlin/services/s3/model/SsekmsEncryption;", "<init>", "(Laws/sdk/kotlin/services/s3/model/SsekmsEncryption;)V", "getValue", "()Laws/sdk/kotlin/services/s3/model/SsekmsEncryption;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Ssekms extends ObjectEncryption {
        private final SsekmsEncryption value;

        public static /* synthetic */ Ssekms copy$default(Ssekms ssekms, SsekmsEncryption ssekmsEncryption, int i, Object obj) {
            if ((i & 1) != 0) {
                ssekmsEncryption = ssekms.value;
            }
            return ssekms.copy(ssekmsEncryption);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SsekmsEncryption getValue() {
            return this.value;
        }

        public final Ssekms copy(SsekmsEncryption value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Ssekms(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Ssekms) && Intrinsics.areEqual(this.value, ((Ssekms) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Ssekms(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ssekms(SsekmsEncryption value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final SsekmsEncryption getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: ObjectEncryption.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ObjectEncryption$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/ObjectEncryption;", "<init>", "()V", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class SdkUnknown extends ObjectEncryption {
        public static final SdkUnknown INSTANCE = new SdkUnknown();

        private SdkUnknown() {
            super(null);
        }
    }

    public final SsekmsEncryption asSsekms() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.ObjectEncryption.Ssekms");
        return ((Ssekms) this).getValue();
    }

    public final SsekmsEncryption asSsekmsOrNull() {
        Ssekms ssekms = this instanceof Ssekms ? (Ssekms) this : null;
        if (ssekms != null) {
            return ssekms.getValue();
        }
        return null;
    }
}

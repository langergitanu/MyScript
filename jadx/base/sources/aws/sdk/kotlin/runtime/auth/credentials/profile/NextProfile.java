package aws.sdk.kotlin.runtime.auth.credentials.profile;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfileChain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/NextProfile;", "", "<init>", "()V", "SelfReference", "Named", "Laws/sdk/kotlin/runtime/auth/credentials/profile/NextProfile$Named;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/NextProfile$SelfReference;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
abstract class NextProfile {
    public /* synthetic */ NextProfile(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: ProfileChain.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/NextProfile$SelfReference;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/NextProfile;", "<init>", "()V", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class SelfReference extends NextProfile {
        public static final SelfReference INSTANCE = new SelfReference();

        private SelfReference() {
            super(null);
        }
    }

    private NextProfile() {
    }

    /* JADX INFO: compiled from: ProfileChain.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/NextProfile$Named;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/NextProfile;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Named extends NextProfile {
        private final String name;

        public static /* synthetic */ Named copy$default(Named named, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = named.name;
            }
            return named.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Named copy(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Named(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Named) && Intrinsics.areEqual(this.name, ((Named) other).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "Named(name=" + this.name + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Named(String name) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final String getName() {
            return this.name;
        }
    }
}

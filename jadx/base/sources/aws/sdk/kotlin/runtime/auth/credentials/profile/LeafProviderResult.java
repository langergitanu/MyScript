package aws.sdk.kotlin.runtime.auth.credentials.profile;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfileChain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProviderResult;", "", "<init>", "()V", "Ok", "Err", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProviderResult$Err;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProviderResult$Ok;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
abstract class LeafProviderResult {
    public /* synthetic */ LeafProviderResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LeafProviderResult() {
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.auth.credentials.profile.LeafProviderResult$Ok */
    /* JADX INFO: compiled from: ProfileChain.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProviderResult$Ok;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProviderResult;", "provider", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;)V", "getProvider", "()Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class C3090Ok extends LeafProviderResult {
        private final LeafProvider provider;

        public static /* synthetic */ C3090Ok copy$default(C3090Ok c3090Ok, LeafProvider leafProvider, int i, Object obj) {
            if ((i & 1) != 0) {
                leafProvider = c3090Ok.provider;
            }
            return c3090Ok.copy(leafProvider);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LeafProvider getProvider() {
            return this.provider;
        }

        public final C3090Ok copy(LeafProvider provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            return new C3090Ok(provider);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof C3090Ok) && Intrinsics.areEqual(this.provider, ((C3090Ok) other).provider);
        }

        public int hashCode() {
            return this.provider.hashCode();
        }

        public String toString() {
            return "Ok(provider=" + this.provider + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3090Ok(LeafProvider provider) {
            super(null);
            Intrinsics.checkNotNullParameter(provider, "provider");
            this.provider = provider;
        }

        public final LeafProvider getProvider() {
            return this.provider;
        }
    }

    /* JADX INFO: compiled from: ProfileChain.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProviderResult$Err;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProviderResult;", "errorMessage", "", "<init>", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Err extends LeafProviderResult {
        private final String errorMessage;

        public static /* synthetic */ Err copy$default(Err err, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = err.errorMessage;
            }
            return err.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final Err copy(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            return new Err(errorMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Err) && Intrinsics.areEqual(this.errorMessage, ((Err) other).errorMessage);
        }

        public int hashCode() {
            return this.errorMessage.hashCode();
        }

        public String toString() {
            return "Err(errorMessage=" + this.errorMessage + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Err(String errorMessage) {
            super(null);
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }
}

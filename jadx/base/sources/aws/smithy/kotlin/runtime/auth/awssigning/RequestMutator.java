package aws.smithy.kotlin.runtime.auth.awssigning;

import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import kotlin.Metadata;

/* JADX INFO: compiled from: RequestMutator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u0000 \n2\u00020\u0001:\u0001\nJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/RequestMutator;", "", "appendAuth", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "config", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "canonical", "Laws/smithy/kotlin/runtime/auth/awssigning/CanonicalRequest;", "signatureHex", "", "Companion", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface RequestMutator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    HttpRequest appendAuth(AwsSigningConfig config, CanonicalRequest canonical, String signatureHex);

    /* JADX INFO: compiled from: RequestMutator.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/RequestMutator$Companion;", "", "<init>", "()V", Profile.DEFAULT_PROFILE_NAME, "Laws/smithy/kotlin/runtime/auth/awssigning/DefaultRequestMutator;", "getDefault", "()Laws/smithy/kotlin/runtime/auth/awssigning/DefaultRequestMutator;", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final DefaultRequestMutator Default = new DefaultRequestMutator();

        private Companion() {
        }

        public final DefaultRequestMutator getDefault() {
            return Default;
        }
    }
}

package aws.smithy.kotlin.runtime.auth.awssigning;

import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Canonicalizer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\b¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/Canonicalizer;", "", "canonicalRequest", "Laws/smithy/kotlin/runtime/auth/awssigning/CanonicalRequest;", "request", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "config", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Canonicalizer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Object canonicalRequest(HttpRequest httpRequest, AwsSigningConfig awsSigningConfig, Continuation<? super CanonicalRequest> continuation);

    /* JADX INFO: compiled from: Canonicalizer.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/Canonicalizer$Companion;", "", "<init>", "()V", Profile.DEFAULT_PROFILE_NAME, "Laws/smithy/kotlin/runtime/auth/awssigning/DefaultCanonicalizer;", "getDefault", "()Laws/smithy/kotlin/runtime/auth/awssigning/DefaultCanonicalizer;", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final DefaultCanonicalizer Default = new DefaultCanonicalizer(null, 1, 0 == true ? 1 : 0);

        private Companion() {
        }

        public final DefaultCanonicalizer getDefault() {
            return Default;
        }
    }
}

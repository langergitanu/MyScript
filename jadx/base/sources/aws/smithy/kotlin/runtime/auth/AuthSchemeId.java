package aws.smithy.kotlin.runtime.auth;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthSchemeId.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "", "id", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getId", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "Companion", "identity-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@JvmInline
public final class AuthSchemeId {
    private final String id;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String Anonymous = m12117constructorimpl("smithy.api#noAuth");
    private static final String HttpBasic = m12117constructorimpl("smithy.api#httpBasicAuth");
    private static final String HttpDigest = m12117constructorimpl("smithy.api#httpDigestAuth");
    private static final String HttpBearer = m12117constructorimpl("smithy.api#httpBearerAuth");
    private static final String HttpApiKey = m12117constructorimpl("smithy.api#httpApiKeyAuth");
    private static final String AwsSigV4 = m12117constructorimpl("aws.auth#sigv4");
    private static final String AwsSigV4Asymmetric = m12117constructorimpl("aws.auth#sigv4a");

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AuthSchemeId m12116boximpl(String str) {
        return new AuthSchemeId(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m12117constructorimpl(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return id;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m12118equalsimpl(String str, Object obj) {
        return (obj instanceof AuthSchemeId) && Intrinsics.areEqual(str, ((AuthSchemeId) obj).m12122unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m12119equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m12120hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m12121toStringimpl(String str) {
        return "AuthSchemeId(id=" + str + ')';
    }

    public boolean equals(Object other) {
        return m12118equalsimpl(this.id, other);
    }

    public int hashCode() {
        return m12120hashCodeimpl(this.id);
    }

    public String toString() {
        return m12121toStringimpl(this.id);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m12122unboximpl() {
        return this.id;
    }

    /* JADX INFO: compiled from: AuthSchemeId.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/AuthSchemeId$Companion;", "", "<init>", "()V", "Anonymous", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "getAnonymous-DepwgT4", "()Ljava/lang/String;", "Ljava/lang/String;", "HttpBasic", "getHttpBasic-DepwgT4", "HttpDigest", "getHttpDigest-DepwgT4", "HttpBearer", "getHttpBearer-DepwgT4", "HttpApiKey", "getHttpApiKey-DepwgT4", "AwsSigV4", "getAwsSigV4-DepwgT4", "AwsSigV4Asymmetric", "getAwsSigV4Asymmetric-DepwgT4", "identity-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getAnonymous-DepwgT4, reason: not valid java name */
        public final String m12123getAnonymousDepwgT4() {
            return AuthSchemeId.Anonymous;
        }

        /* JADX INFO: renamed from: getHttpBasic-DepwgT4, reason: not valid java name */
        public final String m12127getHttpBasicDepwgT4() {
            return AuthSchemeId.HttpBasic;
        }

        /* JADX INFO: renamed from: getHttpDigest-DepwgT4, reason: not valid java name */
        public final String m12129getHttpDigestDepwgT4() {
            return AuthSchemeId.HttpDigest;
        }

        /* JADX INFO: renamed from: getHttpBearer-DepwgT4, reason: not valid java name */
        public final String m12128getHttpBearerDepwgT4() {
            return AuthSchemeId.HttpBearer;
        }

        /* JADX INFO: renamed from: getHttpApiKey-DepwgT4, reason: not valid java name */
        public final String m12126getHttpApiKeyDepwgT4() {
            return AuthSchemeId.HttpApiKey;
        }

        /* JADX INFO: renamed from: getAwsSigV4-DepwgT4, reason: not valid java name */
        public final String m12124getAwsSigV4DepwgT4() {
            return AuthSchemeId.AwsSigV4;
        }

        /* JADX INFO: renamed from: getAwsSigV4Asymmetric-DepwgT4, reason: not valid java name */
        public final String m12125getAwsSigV4AsymmetricDepwgT4() {
            return AuthSchemeId.AwsSigV4Asymmetric;
        }
    }

    private /* synthetic */ AuthSchemeId(String str) {
        this.id = str;
    }

    public final String getId() {
        return this.id;
    }
}

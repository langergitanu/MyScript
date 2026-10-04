package aws.smithy.kotlin.runtime.auth.awscredentials;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import aws.smithy.kotlin.runtime.identity.Identity;
import aws.smithy.kotlin.runtime.identity.IdentityAttributes;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Credentials.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fR\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "Laws/smithy/kotlin/runtime/identity/Identity;", "", "getAccessKeyId", "()Ljava/lang/String;", "accessKeyId", "getSecretAccessKey", "secretAccessKey", "getSessionToken", "sessionToken", "getProviderName", "providerName", "Companion", "aws-credentials"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Credentials extends Identity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String getAccessKeyId();

    String getSecretAccessKey();

    default String getSessionToken() {
        return null;
    }

    /* JADX INFO: compiled from: Credentials.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials$Companion;", "", "<init>", "()V", "", "accessKeyId", "secretAccessKey", "sessionToken", "Laws/smithy/kotlin/runtime/time/Instant;", "expiration", "providerName", "Laws/smithy/kotlin/runtime/collections/Attributes;", "attributes", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "invoke", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/time/Instant;Ljava/lang/String;Laws/smithy/kotlin/runtime/collections/Attributes;)Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "aws-credentials"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ Credentials invoke$default(Companion companion, String str, String str2, String str3, Instant instant, String str4, Attributes attributes, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                instant = null;
            }
            if ((i & 16) != 0) {
                str4 = null;
            }
            if ((i & 32) != 0) {
                attributes = null;
            }
            return companion.invoke(str, str2, str3, instant, str4, attributes);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Credentials invoke(String accessKeyId, String secretAccessKey, String sessionToken, Instant expiration, String providerName, Attributes attributes) {
            MutableAttributes mutableAttributes;
            Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
            Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
            if (providerName != null) {
                if (!Intrinsics.areEqual(attributes != null ? (String) attributes.getOrNull(IdentityAttributes.INSTANCE.getProviderName()) : null, providerName)) {
                    if (attributes == null || (mutableAttributes = AttributesKt.toMutableAttributes(attributes)) == null) {
                        mutableAttributes = AttributesKt.mutableAttributes();
                    }
                    AttributesKt.setIfValueNotNull(mutableAttributes, IdentityAttributes.INSTANCE.getProviderName(), providerName);
                    attributes = mutableAttributes;
                }
            } else if (attributes == null) {
                attributes = AttributesKt.emptyAttributes();
            }
            return new CredentialsImpl(accessKeyId, secretAccessKey, sessionToken, expiration, attributes);
        }
    }

    /* JADX INFO: compiled from: Credentials.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String getSessionToken(Credentials credentials) {
            return Credentials.super.getSessionToken();
        }

        @Deprecated
        public static String getProviderName(Credentials credentials) {
            return Credentials.super.getProviderName();
        }
    }

    default String getProviderName() {
        return (String) getAttributes().getOrNull(IdentityAttributes.INSTANCE.getProviderName());
    }
}

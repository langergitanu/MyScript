package aws.smithy.kotlin.runtime.auth.awscredentials;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import aws.smithy.kotlin.runtime.identity.IdentityAttributes;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Credentials.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aU\u0010\n\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "", "accessKeyId", "secretAccessKey", "sessionToken", "Laws/smithy/kotlin/runtime/time/Instant;", "expiration", "providerName", "Laws/smithy/kotlin/runtime/collections/Attributes;", "attributes", "copy", "(Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/time/Instant;Ljava/lang/String;Laws/smithy/kotlin/runtime/collections/Attributes;)Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "aws-credentials"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CredentialsKt {
    public static /* synthetic */ Credentials copy$default(Credentials credentials, String str, String str2, String str3, Instant instant, String str4, Attributes attributes, int i, Object obj) {
        if ((i & 1) != 0) {
            str = credentials.getAccessKeyId();
        }
        if ((i & 2) != 0) {
            str2 = credentials.getSecretAccessKey();
        }
        if ((i & 4) != 0) {
            str3 = credentials.getSessionToken();
        }
        if ((i & 8) != 0) {
            instant = credentials.getExpiration();
        }
        if ((i & 16) != 0) {
            str4 = credentials.getProviderName();
        }
        if ((i & 32) != 0) {
            attributes = credentials.getAttributes();
        }
        String str5 = str4;
        Attributes attributes2 = attributes;
        return copy(credentials, str, str2, str3, instant, str5, attributes2);
    }

    public static final Credentials copy(Credentials credentials, String accessKeyId, String secretAccessKey, String str, Instant instant, String str2, Attributes attributes) {
        MutableAttributes mutableAttributes;
        Intrinsics.checkNotNullParameter(credentials, "<this>");
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        if (credentials.getProviderName() != null && str2 == null) {
            MutableAttributes mutableAttributes2 = null;
            if (attributes != null && (mutableAttributes = AttributesKt.toMutableAttributes(attributes)) != null) {
                mutableAttributes.remove(IdentityAttributes.INSTANCE.getProviderName());
                if (AttributesKt.isNotEmpty(mutableAttributes)) {
                    mutableAttributes2 = mutableAttributes;
                }
            }
            attributes = mutableAttributes2;
        }
        return Credentials.INSTANCE.invoke(accessKeyId, secretAccessKey, str, instant, str2, attributes);
    }
}

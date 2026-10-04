package aws.sdk.kotlin.runtime.auth.credentials.internal;

import aws.sdk.kotlin.runtime.client.AwsClientOption;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import aws.smithy.kotlin.runtime.identity.IdentityAttributes;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CredentialsExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0000¨\u0006\n"}, m1599d2 = {"credentials", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "accessKeyId", "", "secretAccessKey", "sessionToken", "expiration", "Laws/smithy/kotlin/runtime/time/Instant;", "providerName", "accountId", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CredentialsExtKt {
    public static /* synthetic */ Credentials credentials$default(String str, String str2, String str3, Instant instant, String str4, String str5, int i, Object obj) {
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
            str5 = null;
        }
        return credentials(str, str2, str3, instant, str4, str5);
    }

    public static final Credentials credentials(String accessKeyId, String secretAccessKey, String str, Instant instant, String str2, String str3) {
        MutableAttributes mutableAttributesEmptyAttributes;
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        if (str2 != null || str3 != null) {
            MutableAttributes mutableAttributes = AttributesKt.mutableAttributes();
            AttributesKt.setIfValueNotNull(mutableAttributes, IdentityAttributes.INSTANCE.getProviderName(), str2);
            AttributesKt.setIfValueNotNull(mutableAttributes, AwsClientOption.INSTANCE.getAccountId(), str3);
            mutableAttributesEmptyAttributes = mutableAttributes;
        } else {
            mutableAttributesEmptyAttributes = AttributesKt.emptyAttributes();
        }
        return Credentials.Companion.invoke$default(Credentials.INSTANCE, accessKeyId, secretAccessKey, str, instant, null, mutableAttributesEmptyAttributes, 16, null);
    }
}

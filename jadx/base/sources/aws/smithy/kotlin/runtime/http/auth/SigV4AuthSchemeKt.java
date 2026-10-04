package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.AuthOption;
import aws.smithy.kotlin.runtime.auth.AuthOptionKt;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningAttributes;
import aws.smithy.kotlin.runtime.auth.awssigning.HashSpecification;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SigV4AuthScheme.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aG\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u00020\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0000\u001aC\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"sigV4", "Laws/smithy/kotlin/runtime/auth/AuthOption;", "unsignedPayload", "", "serviceName", "", "signingRegion", "disableDoubleUriEncode", "normalizeUriPath", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Laws/smithy/kotlin/runtime/auth/AuthOption;", "setNotBlank", "", "Laws/smithy/kotlin/runtime/collections/MutableAttributes;", SubscriberAttributeKt.JSON_NAME_KEY, "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "value", "setCommonSigV4Attrs", "attrs", "(Laws/smithy/kotlin/runtime/collections/MutableAttributes;ZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "http-auth-aws"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SigV4AuthSchemeKt {
    public static /* synthetic */ AuthOption sigV4$default(boolean z, String str, String str2, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        return sigV4(z, str, str2, bool, bool2);
    }

    @InternalApi
    public static final AuthOption sigV4(boolean z, String str, String str2, Boolean bool, Boolean bool2) {
        MutableAttributes mutableAttributesEmptyAttributes;
        if (z || str != null || str2 != null || bool != null || bool2 != null) {
            MutableAttributes mutableAttributes = AttributesKt.mutableAttributes();
            setNotBlank(mutableAttributes, AwsSigningAttributes.INSTANCE.getSigningRegion(), str2);
            setCommonSigV4Attrs(mutableAttributes, z, str, bool, bool2);
            mutableAttributesEmptyAttributes = mutableAttributes;
        } else {
            mutableAttributesEmptyAttributes = AttributesKt.emptyAttributes();
        }
        return AuthOptionKt.m12114AuthOptionJh0Pmzk(AuthSchemeId.INSTANCE.m12124getAwsSigV4DepwgT4(), mutableAttributesEmptyAttributes);
    }

    public static final void setNotBlank(MutableAttributes mutableAttributes, AttributeKey<String> key, String str) {
        Intrinsics.checkNotNullParameter(mutableAttributes, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return;
        }
        mutableAttributes.set(key, str);
    }

    public static /* synthetic */ void setCommonSigV4Attrs$default(MutableAttributes mutableAttributes, boolean z, String str, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        setCommonSigV4Attrs(mutableAttributes, z, str, bool, bool2);
    }

    public static final void setCommonSigV4Attrs(MutableAttributes attrs, boolean z, String str, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        if (z) {
            attrs.set(AwsSigningAttributes.INSTANCE.getHashSpecification(), HashSpecification.UnsignedPayload.INSTANCE);
        }
        setNotBlank(attrs, AwsSigningAttributes.INSTANCE.getSigningService(), str);
        if (bool != null) {
            attrs.set(AwsSigningAttributes.INSTANCE.getUseDoubleUriEncode(), Boolean.valueOf(!bool.booleanValue()));
        }
        if (bool2 != null) {
            attrs.set(AwsSigningAttributes.INSTANCE.getNormalizeUriPath(), bool2);
        }
    }
}

package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.AuthOption;
import aws.smithy.kotlin.runtime.auth.AuthOptionKt;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningAttributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: SigV4AsymmetricAuthScheme.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001aM\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m1599d2 = {"sigV4A", "Laws/smithy/kotlin/runtime/auth/AuthOption;", "unsignedPayload", "", "serviceName", "", "signingRegionSet", "", "disableDoubleUriEncode", "normalizeUriPath", "(ZLjava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)Laws/smithy/kotlin/runtime/auth/AuthOption;", "http-auth-aws"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SigV4AsymmetricAuthSchemeKt {
    public static /* synthetic */ AuthOption sigV4A$default(boolean z, String str, List list, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            bool2 = null;
        }
        return sigV4A(z, str, list, bool, bool2);
    }

    @InternalApi
    public static final AuthOption sigV4A(boolean z, String str, List<String> list, Boolean bool, Boolean bool2) {
        MutableAttributes mutableAttributesEmptyAttributes;
        if (z || str != null || list != null || bool != null || bool2 != null) {
            MutableAttributes mutableAttributes = AttributesKt.mutableAttributes();
            List<String> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                mutableAttributes.set(AwsSigningAttributes.INSTANCE.getSigningRegionSet(), CollectionsKt.toSet(list));
            }
            SigV4AuthSchemeKt.setCommonSigV4Attrs(mutableAttributes, z, str, bool, bool2);
            mutableAttributesEmptyAttributes = mutableAttributes;
        } else {
            mutableAttributesEmptyAttributes = AttributesKt.emptyAttributes();
        }
        return AuthOptionKt.m12114AuthOptionJh0Pmzk(AuthSchemeId.INSTANCE.m12125getAwsSigV4AsymmetricDepwgT4(), mutableAttributesEmptyAttributes);
    }
}

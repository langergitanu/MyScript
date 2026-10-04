package aws.smithy.kotlin.runtime.identity;

import aws.smithy.kotlin.runtime.collections.AttributeKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: IdentityAttributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/identity/IdentityAttributes;", "", "<init>", "()V", "ProviderName", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "", "getProviderName", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "identity-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class IdentityAttributes {
    public static final IdentityAttributes INSTANCE = new IdentityAttributes();
    private static final AttributeKey<String> ProviderName = new AttributeKey<>("aws.smithy.kotlin#IdentityProviderName");

    private IdentityAttributes() {
    }

    public final AttributeKey<String> getProviderName() {
        return ProviderName;
    }
}

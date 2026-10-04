package aws.smithy.kotlin.runtime.identity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IdentityAttributes.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"providerName", "", "Laws/smithy/kotlin/runtime/identity/Identity;", "getProviderName", "(Laws/smithy/kotlin/runtime/identity/Identity;)Ljava/lang/String;", "identity-api"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class IdentityAttributesKt {
    public static final String getProviderName(Identity identity) {
        Intrinsics.checkNotNullParameter(identity, "<this>");
        return (String) identity.getAttributes().getOrNull(IdentityAttributes.INSTANCE.getProviderName());
    }
}

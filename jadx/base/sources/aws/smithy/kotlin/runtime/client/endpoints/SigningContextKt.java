package aws.smithy.kotlin.runtime.client.endpoints;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.AuthOption;
import aws.smithy.kotlin.runtime.collections.AttributeKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SigningContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\"(\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"SigningContextAttributeKey", "Laws/smithy/kotlin/runtime/collections/AttributeKey;", "", "Laws/smithy/kotlin/runtime/auth/AuthOption;", "getSigningContextAttributeKey$annotations", "()V", "getSigningContextAttributeKey", "()Laws/smithy/kotlin/runtime/collections/AttributeKey;", "authOptions", "Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;", "getAuthOptions$annotations", "(Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;)V", "getAuthOptions", "(Laws/smithy/kotlin/runtime/client/endpoints/Endpoint;)Ljava/util/List;", "smithy-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SigningContextKt {
    private static final AttributeKey<List<AuthOption>> SigningContextAttributeKey = new AttributeKey<>("aws.smithy.kotlin#endpointAuthSchemes");

    @InternalApi
    public static /* synthetic */ void getAuthOptions$annotations(Endpoint endpoint) {
    }

    @InternalApi
    public static /* synthetic */ void getSigningContextAttributeKey$annotations() {
    }

    public static final AttributeKey<List<AuthOption>> getSigningContextAttributeKey() {
        return SigningContextAttributeKey;
    }

    public static final List<AuthOption> getAuthOptions(Endpoint endpoint) {
        Intrinsics.checkNotNullParameter(endpoint, "<this>");
        List<AuthOption> list = (List) endpoint.getAttributes().getOrNull(SigningContextAttributeKey);
        return list == null ? CollectionsKt.emptyList() : list;
    }
}

package aws.smithy.kotlin.runtime.auth;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthOption.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"AuthOption", "Laws/smithy/kotlin/runtime/auth/AuthOption;", "id", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "AuthOption-Jh0Pmzk", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/collections/Attributes;)Laws/smithy/kotlin/runtime/auth/AuthOption;", "identity-api"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AuthOptionKt {
    /* JADX INFO: renamed from: AuthOption-Jh0Pmzk, reason: not valid java name */
    public static final AuthOption m12114AuthOptionJh0Pmzk(String id, Attributes attributes) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new AuthOptionImpl(id, attributes, null);
    }

    /* JADX INFO: renamed from: AuthOption-Jh0Pmzk$default, reason: not valid java name */
    public static /* synthetic */ AuthOption m12115AuthOptionJh0Pmzk$default(String str, Attributes attributes, int i, Object obj) {
        if ((i & 2) != 0) {
            attributes = AttributesKt.emptyAttributes();
        }
        return m12114AuthOptionJh0Pmzk(str, attributes);
    }
}

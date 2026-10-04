package aws.smithy.kotlin.runtime.auth;

import aws.smithy.kotlin.runtime.collections.Attributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthOption.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\tJ\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/AuthOptionImpl;", "Laws/smithy/kotlin/runtime/auth/AuthOption;", "schemeId", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSchemeId-DepwgT4", "()Ljava/lang/String;", "Ljava/lang/String;", "getAttributes", "()Laws/smithy/kotlin/runtime/collections/Attributes;", "component1", "component1-DepwgT4", "component2", "copy", "copy-Jh0Pmzk", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/collections/Attributes;)Laws/smithy/kotlin/runtime/auth/AuthOptionImpl;", "equals", "", "other", "", "hashCode", "", "toString", "", "identity-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* data */ class AuthOptionImpl implements AuthOption {
    private final Attributes attributes;
    private final String schemeId;

    public /* synthetic */ AuthOptionImpl(String str, Attributes attributes, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, attributes);
    }

    /* JADX INFO: renamed from: copy-Jh0Pmzk$default, reason: not valid java name */
    public static /* synthetic */ AuthOptionImpl m12111copyJh0Pmzk$default(AuthOptionImpl authOptionImpl, String str, Attributes attributes, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authOptionImpl.schemeId;
        }
        if ((i & 2) != 0) {
            attributes = authOptionImpl.attributes;
        }
        return authOptionImpl.m12113copyJh0Pmzk(str, attributes);
    }

    /* JADX INFO: renamed from: component1-DepwgT4, reason: not valid java name and from getter */
    public final String getSchemeId() {
        return this.schemeId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Attributes getAttributes() {
        return this.attributes;
    }

    /* JADX INFO: renamed from: copy-Jh0Pmzk, reason: not valid java name */
    public final AuthOptionImpl m12113copyJh0Pmzk(String schemeId, Attributes attributes) {
        Intrinsics.checkNotNullParameter(schemeId, "schemeId");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new AuthOptionImpl(schemeId, attributes, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthOptionImpl)) {
            return false;
        }
        AuthOptionImpl authOptionImpl = (AuthOptionImpl) other;
        return AuthSchemeId.m12119equalsimpl0(this.schemeId, authOptionImpl.schemeId) && Intrinsics.areEqual(this.attributes, authOptionImpl.attributes);
    }

    public int hashCode() {
        return (AuthSchemeId.m12120hashCodeimpl(this.schemeId) * 31) + this.attributes.hashCode();
    }

    public String toString() {
        return "AuthOptionImpl(schemeId=" + ((Object) AuthSchemeId.m12121toStringimpl(this.schemeId)) + ", attributes=" + this.attributes + ')';
    }

    private AuthOptionImpl(String schemeId, Attributes attributes) {
        Intrinsics.checkNotNullParameter(schemeId, "schemeId");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.schemeId = schemeId;
        this.attributes = attributes;
    }

    @Override // aws.smithy.kotlin.runtime.auth.AuthOption
    /* JADX INFO: renamed from: getSchemeId-DepwgT4 */
    public String mo12110getSchemeIdDepwgT4() {
        return this.schemeId;
    }

    @Override // aws.smithy.kotlin.runtime.auth.AuthOption
    public Attributes getAttributes() {
        return this.attributes;
    }
}

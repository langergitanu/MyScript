package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.identity.Identity;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnonymousAuthScheme.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/AnonymousIdentity;", "Laws/smithy/kotlin/runtime/identity/Identity;", "<init>", "()V", "expiration", "Laws/smithy/kotlin/runtime/time/Instant;", "getExpiration", "()Laws/smithy/kotlin/runtime/time/Instant;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "getAttributes", "()Laws/smithy/kotlin/runtime/collections/Attributes;", "http-auth"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AnonymousIdentity implements Identity {
    public static final AnonymousIdentity INSTANCE = new AnonymousIdentity();
    private static final Attributes attributes = AttributesKt.emptyAttributes();
    private static final Instant expiration = null;

    private AnonymousIdentity() {
    }

    @Override // aws.smithy.kotlin.runtime.identity.Identity
    public Instant getExpiration() {
        return expiration;
    }

    @Override // aws.smithy.kotlin.runtime.identity.Identity
    public Attributes getAttributes() {
        return attributes;
    }
}

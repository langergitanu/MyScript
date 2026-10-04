package aws.smithy.kotlin.runtime.identity;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;

/* JADX INFO: compiled from: Identity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/identity/Identity;", "", "expiration", "Laws/smithy/kotlin/runtime/time/Instant;", "getExpiration", "()Laws/smithy/kotlin/runtime/time/Instant;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "getAttributes", "()Laws/smithy/kotlin/runtime/collections/Attributes;", "identity-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Identity {
    Attributes getAttributes();

    Instant getExpiration();
}

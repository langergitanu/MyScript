package aws.smithy.kotlin.runtime.client;

import aws.smithy.kotlin.runtime.util.Uuid;
import kotlin.Metadata;

/* JADX INFO: compiled from: IdempotencyTokenProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/DefaultIdempotencyTokenProvider;", "Laws/smithy/kotlin/runtime/client/IdempotencyTokenProvider;", "<init>", "()V", "generateToken", "", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class DefaultIdempotencyTokenProvider implements IdempotencyTokenProvider {
    @Override // aws.smithy.kotlin.runtime.client.IdempotencyTokenProvider
    public String generateToken() {
        return Uuid.INSTANCE.random().getStringRep();
    }
}

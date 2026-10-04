package aws.sdk.kotlin.runtime.auth.credentials.internal;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.http.auth.BearerToken;
import aws.smithy.kotlin.runtime.http.auth.CloseableBearerTokenProvider;
import aws.smithy.kotlin.runtime.p011io.SdkManagedCloseable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManagedBearerTokenProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096A¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/ManagedTokenProvider;", "Laws/smithy/kotlin/runtime/io/SdkManagedCloseable;", "Laws/smithy/kotlin/runtime/http/auth/CloseableBearerTokenProvider;", "delegate", "<init>", "(Laws/smithy/kotlin/runtime/http/auth/CloseableBearerTokenProvider;)V", "close", "", "resolve", "Laws/smithy/kotlin/runtime/http/auth/BearerToken;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class ManagedTokenProvider extends SdkManagedCloseable implements CloseableBearerTokenProvider {
    private final CloseableBearerTokenProvider delegate;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.BearerTokenProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    public Object resolve(Attributes attributes, Continuation<? super BearerToken> continuation) {
        return this.delegate.resolve(attributes, continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManagedTokenProvider(CloseableBearerTokenProvider delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }
}

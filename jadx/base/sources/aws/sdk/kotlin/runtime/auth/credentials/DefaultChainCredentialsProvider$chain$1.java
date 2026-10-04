package aws.sdk.kotlin.runtime.auth.credentials;

import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultChainCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class DefaultChainCredentialsProvider$chain$1 extends FunctionReferenceImpl implements Function1<String, String> {
    DefaultChainCredentialsProvider$chain$1(Object obj) {
        super(1, obj, PlatformProvider.class, "getProperty", "getProperty(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((PlatformProvider) this.receiver).getProperty(p0);
    }
}

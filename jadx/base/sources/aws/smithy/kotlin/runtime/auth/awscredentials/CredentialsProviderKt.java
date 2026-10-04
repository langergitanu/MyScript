package aws.smithy.kotlin.runtime.auth.awscredentials;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CredentialsProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "", "getSimpleClassName", "(Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;)Ljava/lang/String;", "simpleClassName", "aws-credentials"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CredentialsProviderKt {
    public static final String getSimpleClassName(CredentialsProvider credentialsProvider) {
        Intrinsics.checkNotNullParameter(credentialsProvider, "<this>");
        String simpleName = Reflection.getOrCreateKotlinClass(credentialsProvider.getClass()).getSimpleName();
        return simpleName == null ? "AnonymousCredentialsProvider" : simpleName;
    }
}

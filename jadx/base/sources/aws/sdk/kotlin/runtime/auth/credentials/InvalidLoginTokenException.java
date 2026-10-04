package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.ConfigurationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginTokenProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/InvalidLoginTokenException;", "Laws/sdk/kotlin/runtime/ConfigurationException;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InvalidLoginTokenException extends ConfigurationException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidLoginTokenException(String message, Throwable th) {
        super(message, th);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public /* synthetic */ InvalidLoginTokenException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }
}

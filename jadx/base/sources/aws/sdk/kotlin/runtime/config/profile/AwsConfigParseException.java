package aws.sdk.kotlin.runtime.config.profile;

import aws.sdk.kotlin.runtime.ConfigurationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsConfigParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/AwsConfigParseException;", "Laws/sdk/kotlin/runtime/ConfigurationException;", "message", "", "lineNumber", "", "<init>", "(Ljava/lang/String;I)V", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsConfigParseException extends ConfigurationException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AwsConfigParseException(String message, int i) {
        super(TextKt.contextMessage(message, Integer.valueOf(i)));
        Intrinsics.checkNotNullParameter(message, "message");
    }
}

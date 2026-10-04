package aws.sdk.kotlin.runtime.config.imds;

import kotlin.Metadata;

/* JADX INFO: compiled from: TokenMiddleware.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m1599d2 = {"TOKEN_REFRESH_BUFFER_SECONDS", "", "X_AWS_EC2_METADATA_TOKEN_TTL_SECONDS", "", "X_AWS_EC2_METADATA_TOKEN", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TokenMiddlewareKt {
    public static final int TOKEN_REFRESH_BUFFER_SECONDS = 120;
    public static final String X_AWS_EC2_METADATA_TOKEN = "x-aws-ec2-metadata-token";
    public static final String X_AWS_EC2_METADATA_TOKEN_TTL_SECONDS = "x-aws-ec2-metadata-token-ttl-seconds";
}

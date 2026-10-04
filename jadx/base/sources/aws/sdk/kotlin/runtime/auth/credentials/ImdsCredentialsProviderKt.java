package aws.sdk.kotlin.runtime.auth.credentials;

import kotlin.Metadata;

/* JADX INFO: compiled from: ImdsCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, m1599d2 = {"CREDENTIALS_BASE_PATH", "", "CODE_ASSUME_ROLE_UNAUTHORIZED_ACCESS", "PROVIDER_NAME", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ImdsCredentialsProviderKt {
    private static final String CODE_ASSUME_ROLE_UNAUTHORIZED_ACCESS = "AssumeRoleUnauthorizedAccess";
    private static final String CREDENTIALS_BASE_PATH = "/latest/meta-data/iam/security-credentials/";
    private static final String PROVIDER_NAME = "IMDSv2";
}

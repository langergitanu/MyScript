package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.identity.Identity;
import kotlin.Metadata;

/* JADX INFO: compiled from: BearerTokenProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/BearerToken;", "Laws/smithy/kotlin/runtime/identity/Identity;", "token", "", "getToken", "()Ljava/lang/String;", "http-auth"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface BearerToken extends Identity {
    String getToken();
}

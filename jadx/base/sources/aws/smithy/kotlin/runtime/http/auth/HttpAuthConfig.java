package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: HttpAuthConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\nR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/HttpAuthConfig;", "", "authSchemes", "", "Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "getAuthSchemes", "()Ljava/util/List;", "authSchemePreference", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "getAuthSchemePreference", "Builder", "http-auth-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface HttpAuthConfig {

    /* JADX INFO: compiled from: HttpAuthConfig.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/HttpAuthConfig$Builder;", "", "authSchemes", "", "Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "getAuthSchemes", "()Ljava/util/List;", "setAuthSchemes", "(Ljava/util/List;)V", "authSchemePreference", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "getAuthSchemePreference", "setAuthSchemePreference", "http-auth-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder {
        List<AuthSchemeId> getAuthSchemePreference();

        List<AuthScheme> getAuthSchemes();

        void setAuthSchemePreference(List<AuthSchemeId> list);

        void setAuthSchemes(List<? extends AuthScheme> list);
    }

    List<AuthSchemeId> getAuthSchemePreference();

    List<AuthScheme> getAuthSchemes();
}

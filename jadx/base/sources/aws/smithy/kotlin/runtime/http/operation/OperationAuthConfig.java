package aws.smithy.kotlin.runtime.http.operation;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.AuthOption;
import aws.smithy.kotlin.runtime.auth.AuthOptionKt;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.http.auth.AuthScheme;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.identity.IdentityProviderConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OperationAuth.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J:\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u00020\u0018HÖ\u0081\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001c\u001a\u00020\u001bHÖ\u0081\u0004¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\rR#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\u000fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010\u0011¨\u0006%"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig;", "", "Laws/smithy/kotlin/runtime/http/operation/AuthSchemeResolver;", "authSchemeResolver", "", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "configuredAuthSchemes", "Laws/smithy/kotlin/runtime/identity/IdentityProviderConfig;", "identityProviderConfig", "<init>", "(Laws/smithy/kotlin/runtime/http/operation/AuthSchemeResolver;Ljava/util/Map;Laws/smithy/kotlin/runtime/identity/IdentityProviderConfig;)V", "component1", "()Laws/smithy/kotlin/runtime/http/operation/AuthSchemeResolver;", "component2", "()Ljava/util/Map;", "component3", "()Laws/smithy/kotlin/runtime/identity/IdentityProviderConfig;", "copy", "(Laws/smithy/kotlin/runtime/http/operation/AuthSchemeResolver;Ljava/util/Map;Laws/smithy/kotlin/runtime/identity/IdentityProviderConfig;)Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Laws/smithy/kotlin/runtime/http/operation/AuthSchemeResolver;", "getAuthSchemeResolver", "Ljava/util/Map;", "getConfiguredAuthSchemes", "Laws/smithy/kotlin/runtime/identity/IdentityProviderConfig;", "getIdentityProviderConfig", "Companion", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class OperationAuthConfig {
    private final AuthSchemeResolver authSchemeResolver;
    private final Map<AuthSchemeId, AuthScheme> configuredAuthSchemes;
    private final IdentityProviderConfig identityProviderConfig;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final OperationAuthConfig Anonymous = OperationAuthKt.AnonymousAuthConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OperationAuthConfig copy$default(OperationAuthConfig operationAuthConfig, AuthSchemeResolver authSchemeResolver, Map map, IdentityProviderConfig identityProviderConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            authSchemeResolver = operationAuthConfig.authSchemeResolver;
        }
        if ((i & 2) != 0) {
            map = operationAuthConfig.configuredAuthSchemes;
        }
        if ((i & 4) != 0) {
            identityProviderConfig = operationAuthConfig.identityProviderConfig;
        }
        return operationAuthConfig.copy(authSchemeResolver, map, identityProviderConfig);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AuthSchemeResolver getAuthSchemeResolver() {
        return this.authSchemeResolver;
    }

    public final Map<AuthSchemeId, AuthScheme> component2() {
        return this.configuredAuthSchemes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final IdentityProviderConfig getIdentityProviderConfig() {
        return this.identityProviderConfig;
    }

    public final OperationAuthConfig copy(AuthSchemeResolver authSchemeResolver, Map<AuthSchemeId, ? extends AuthScheme> configuredAuthSchemes, IdentityProviderConfig identityProviderConfig) {
        Intrinsics.checkNotNullParameter(authSchemeResolver, "authSchemeResolver");
        Intrinsics.checkNotNullParameter(configuredAuthSchemes, "configuredAuthSchemes");
        Intrinsics.checkNotNullParameter(identityProviderConfig, "identityProviderConfig");
        return new OperationAuthConfig(authSchemeResolver, configuredAuthSchemes, identityProviderConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperationAuthConfig)) {
            return false;
        }
        OperationAuthConfig operationAuthConfig = (OperationAuthConfig) other;
        return Intrinsics.areEqual(this.authSchemeResolver, operationAuthConfig.authSchemeResolver) && Intrinsics.areEqual(this.configuredAuthSchemes, operationAuthConfig.configuredAuthSchemes) && Intrinsics.areEqual(this.identityProviderConfig, operationAuthConfig.identityProviderConfig);
    }

    public int hashCode() {
        return (((this.authSchemeResolver.hashCode() * 31) + this.configuredAuthSchemes.hashCode()) * 31) + this.identityProviderConfig.hashCode();
    }

    public String toString() {
        return "OperationAuthConfig(authSchemeResolver=" + this.authSchemeResolver + ", configuredAuthSchemes=" + this.configuredAuthSchemes + ", identityProviderConfig=" + this.identityProviderConfig + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OperationAuthConfig(AuthSchemeResolver authSchemeResolver, Map<AuthSchemeId, ? extends AuthScheme> configuredAuthSchemes, IdentityProviderConfig identityProviderConfig) {
        Intrinsics.checkNotNullParameter(authSchemeResolver, "authSchemeResolver");
        Intrinsics.checkNotNullParameter(configuredAuthSchemes, "configuredAuthSchemes");
        Intrinsics.checkNotNullParameter(identityProviderConfig, "identityProviderConfig");
        this.authSchemeResolver = authSchemeResolver;
        this.configuredAuthSchemes = configuredAuthSchemes;
        this.identityProviderConfig = identityProviderConfig;
    }

    public final AuthSchemeResolver getAuthSchemeResolver() {
        return this.authSchemeResolver;
    }

    public final Map<AuthSchemeId, AuthScheme> getConfiguredAuthSchemes() {
        return this.configuredAuthSchemes;
    }

    public final IdentityProviderConfig getIdentityProviderConfig() {
        return this.identityProviderConfig;
    }

    /* JADX INFO: compiled from: OperationAuth.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig$Companion;", "", "<init>", "()V", "Laws/smithy/kotlin/runtime/identity/IdentityProviderConfig;", "identityProviderConfig", "", "Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "authSchemes", "Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig;", TypedValues.TransitionType.S_FROM, "(Laws/smithy/kotlin/runtime/identity/IdentityProviderConfig;[Laws/smithy/kotlin/runtime/http/auth/AuthScheme;)Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig;", "Anonymous", "Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig;", "getAnonymous", "()Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OperationAuthConfig getAnonymous() {
            return OperationAuthConfig.Anonymous;
        }

        public final OperationAuthConfig from(IdentityProviderConfig identityProviderConfig, final AuthScheme... authSchemes) {
            Intrinsics.checkNotNullParameter(identityProviderConfig, "identityProviderConfig");
            Intrinsics.checkNotNullParameter(authSchemes, "authSchemes");
            AuthSchemeResolver authSchemeResolver = new AuthSchemeResolver() { // from class: aws.smithy.kotlin.runtime.http.operation.OperationAuthConfig$Companion$from$resolver$1
                @Override // aws.smithy.kotlin.runtime.http.operation.AuthSchemeResolver
                public final Object resolve(OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super List<? extends AuthOption>> continuation) {
                    AuthScheme[] authSchemeArr = authSchemes;
                    ArrayList arrayList = new ArrayList(authSchemeArr.length);
                    for (AuthScheme authScheme : authSchemeArr) {
                        arrayList.add(AuthOptionKt.m12115AuthOptionJh0Pmzk$default(authScheme.getSchemeId(), null, 2, null));
                    }
                    return arrayList;
                }
            };
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(authSchemes.length), 16));
            for (AuthScheme authScheme : authSchemes) {
                linkedHashMap.put(AuthSchemeId.m12116boximpl(authScheme.getSchemeId()), authScheme);
            }
            return new OperationAuthConfig(authSchemeResolver, linkedHashMap, identityProviderConfig);
        }
    }
}

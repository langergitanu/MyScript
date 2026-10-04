package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.auth;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.endpoints.StsEndpointProvider;
import aws.smithy.kotlin.runtime.auth.AuthOption;
import aws.smithy.kotlin.runtime.auth.AuthOptionKt;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.http.auth.ReprioritizeAuthOptionsKt;
import aws.smithy.kotlin.runtime.http.auth.SigV4AuthSchemeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DefaultStsAuthSchemeProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/auth/DefaultStsAuthSchemeProvider;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/auth/StsAuthSchemeProvider;", "endpointProvider", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/endpoints/StsEndpointProvider;", "authSchemePreference", "", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/endpoints/StsEndpointProvider;Ljava/util/List;)V", "operationOverrides", "", "", "Laws/smithy/kotlin/runtime/auth/AuthOption;", "serviceDefaults", "resolveAuthScheme", "params", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/auth/StsAuthSchemeParameters;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/auth/StsAuthSchemeParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultStsAuthSchemeProvider implements StsAuthSchemeProvider {
    private final List<AuthSchemeId> authSchemePreference;
    private final StsEndpointProvider endpointProvider;
    private final Map<String, List<AuthOption>> operationOverrides;
    private final List<AuthOption> serviceDefaults;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultStsAuthSchemeProvider() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public DefaultStsAuthSchemeProvider(StsEndpointProvider stsEndpointProvider, List<AuthSchemeId> list) {
        this.endpointProvider = stsEndpointProvider;
        this.authSchemePreference = list;
        this.operationOverrides = MapsKt.mapOf(TuplesKt.m1606to("AssumeRoleWithWebIdentity", CollectionsKt.listOf(AuthOptionKt.m12115AuthOptionJh0Pmzk$default(AuthSchemeId.INSTANCE.m12123getAnonymousDepwgT4(), null, 2, null))));
        this.serviceDefaults = CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(false, null, null, null, null, 31, null));
    }

    public /* synthetic */ DefaultStsAuthSchemeProvider(StsEndpointProvider stsEndpointProvider, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : stsEndpointProvider, (i & 2) != 0 ? null : list);
    }

    @Override // aws.smithy.kotlin.runtime.auth.AuthSchemeProvider
    public /* bridge */ /* synthetic */ Object resolveAuthScheme(StsAuthSchemeParameters stsAuthSchemeParameters, Continuation continuation) {
        return resolveAuthScheme2(stsAuthSchemeParameters, (Continuation<? super List<? extends AuthOption>>) continuation);
    }

    /* JADX INFO: renamed from: resolveAuthScheme, reason: avoid collision after fix types in other method */
    public Object resolveAuthScheme2(StsAuthSchemeParameters stsAuthSchemeParameters, Continuation<? super List<? extends AuthOption>> continuation) {
        List<AuthOption> listReprioritizeAuthOptions;
        List<AuthOption> list = this.operationOverrides.get(stsAuthSchemeParameters.getOperationName());
        if (list == null) {
            list = this.serviceDefaults;
        }
        List<AuthOption> list2 = list;
        List<AuthSchemeId> list3 = this.authSchemePreference;
        return (list3 == null || (listReprioritizeAuthOptions = ReprioritizeAuthOptionsKt.reprioritizeAuthOptions(list3, list2)) == null) ? list2 : listReprioritizeAuthOptions;
    }
}

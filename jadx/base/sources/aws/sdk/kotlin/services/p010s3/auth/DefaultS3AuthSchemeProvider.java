package aws.sdk.kotlin.services.p010s3.auth;

import aws.sdk.kotlin.services.p010s3.endpoints.S3EndpointParameters;
import aws.sdk.kotlin.services.p010s3.endpoints.S3EndpointProvider;
import aws.sdk.kotlin.services.p010s3.express.SigV4S3ExpressAuthSchemeKt;
import aws.smithy.kotlin.runtime.auth.AuthOption;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.client.endpoints.SigningContextKt;
import aws.smithy.kotlin.runtime.http.auth.EndpointAuthKt;
import aws.smithy.kotlin.runtime.http.auth.ReprioritizeAuthOptionsKt;
import aws.smithy.kotlin.runtime.http.auth.SigV4AsymmetricAuthSchemeKt;
import aws.smithy.kotlin.runtime.http.auth.SigV4AuthSchemeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DefaultS3AuthSchemeProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/auth/DefaultS3AuthSchemeProvider;", "Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeProvider;", "endpointProvider", "Laws/sdk/kotlin/services/s3/endpoints/S3EndpointProvider;", "authSchemePreference", "", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "<init>", "(Laws/sdk/kotlin/services/s3/endpoints/S3EndpointProvider;Ljava/util/List;)V", "operationOverrides", "", "", "Laws/smithy/kotlin/runtime/auth/AuthOption;", "serviceDefaults", "resolveAuthScheme", "params", "Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeParameters;", "(Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultS3AuthSchemeProvider implements S3AuthSchemeProvider {
    private final List<AuthSchemeId> authSchemePreference;
    private final S3EndpointProvider endpointProvider;
    private final Map<String, List<AuthOption>> operationOverrides;
    private final List<AuthOption> serviceDefaults;

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.auth.DefaultS3AuthSchemeProvider$resolveAuthScheme$1 */
    /* JADX INFO: compiled from: DefaultS3AuthSchemeProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.auth.DefaultS3AuthSchemeProvider", m1609f = "DefaultS3AuthSchemeProvider.kt", m1610i = {0, 0, 0}, m1611l = {32}, m1612m = "resolveAuthScheme", m1613n = {"params", "modeledAuthOptions", "endpointParams"}, m1614nl = {33}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C31371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C31371(Continuation<? super C31371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultS3AuthSchemeProvider.this.resolveAuthScheme2((S3AuthSchemeParameters) null, (Continuation<? super List<? extends AuthOption>>) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultS3AuthSchemeProvider() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public DefaultS3AuthSchemeProvider(S3EndpointProvider s3EndpointProvider, List<AuthSchemeId> list) {
        this.endpointProvider = s3EndpointProvider;
        this.authSchemePreference = list;
        this.operationOverrides = MapsKt.mapOf(TuplesKt.m1606to("WriteGetObjectResponse", CollectionsKt.listOf(SigV4AuthSchemeKt.sigV4$default(true, null, null, null, null, 30, null))));
        this.serviceDefaults = CollectionsKt.listOf((Object[]) new AuthOption[]{SigV4AuthSchemeKt.sigV4$default(false, null, null, null, null, 31, null), SigV4AsymmetricAuthSchemeKt.sigV4A$default(false, null, null, null, null, 31, null), SigV4S3ExpressAuthSchemeKt.sigV4S3Express$default(false, null, null, null, null, 31, null)});
    }

    public /* synthetic */ DefaultS3AuthSchemeProvider(S3EndpointProvider s3EndpointProvider, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : s3EndpointProvider, (i & 2) != 0 ? null : list);
    }

    @Override // aws.smithy.kotlin.runtime.auth.AuthSchemeProvider
    public /* bridge */ /* synthetic */ Object resolveAuthScheme(S3AuthSchemeParameters s3AuthSchemeParameters, Continuation continuation) {
        return resolveAuthScheme2(s3AuthSchemeParameters, (Continuation<? super List<? extends AuthOption>>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: resolveAuthScheme, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resolveAuthScheme2(S3AuthSchemeParameters s3AuthSchemeParameters, Continuation<? super List<? extends AuthOption>> continuation) {
        C31371 c31371;
        List<AuthOption> listEmptyList;
        List<AuthOption> list;
        List<AuthOption> listReprioritizeAuthOptions;
        if (continuation instanceof C31371) {
            c31371 = (C31371) continuation;
            if ((c31371.label & Integer.MIN_VALUE) != 0) {
                c31371.label -= Integer.MIN_VALUE;
            } else {
                c31371 = new C31371(continuation);
            }
        }
        Object obj = c31371.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31371.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List<AuthOption> list2 = this.operationOverrides.get(s3AuthSchemeParameters.getOperationName());
            if (list2 == null) {
                list2 = this.serviceDefaults;
            }
            List<AuthOption> list3 = list2;
            S3EndpointParameters endpointParameters = s3AuthSchemeParameters.getEndpointParameters();
            S3EndpointProvider s3EndpointProvider = this.endpointProvider;
            if (s3EndpointProvider != null && endpointParameters != null) {
                c31371.L$0 = SpillingKt.nullOutSpilledVariable(s3AuthSchemeParameters);
                c31371.L$1 = list3;
                c31371.L$2 = SpillingKt.nullOutSpilledVariable(endpointParameters);
                c31371.label = 1;
                Object objResolveEndpoint = s3EndpointProvider.resolveEndpoint(endpointParameters, c31371);
                if (objResolveEndpoint == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objResolveEndpoint;
                list = list3;
            } else {
                listEmptyList = CollectionsKt.emptyList();
                list = list3;
                List<AuthOption> listMergeAuthOptions = EndpointAuthKt.mergeAuthOptions(list, listEmptyList);
                List<AuthSchemeId> list4 = this.authSchemePreference;
                return (list4 != null || (listReprioritizeAuthOptions = ReprioritizeAuthOptionsKt.reprioritizeAuthOptions(list4, listMergeAuthOptions)) == null) ? listMergeAuthOptions : listReprioritizeAuthOptions;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) c31371.L$1;
            ResultKt.throwOnFailure(obj);
        }
        listEmptyList = SigningContextKt.getAuthOptions((Endpoint) obj);
        List<AuthOption> listMergeAuthOptions2 = EndpointAuthKt.mergeAuthOptions(list, listEmptyList);
        List<AuthSchemeId> list42 = this.authSchemePreference;
        if (list42 != null) {
        }
    }
}

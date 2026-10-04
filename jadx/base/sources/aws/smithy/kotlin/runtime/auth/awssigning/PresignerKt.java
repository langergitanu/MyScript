package aws.smithy.kotlin.runtime.auth.awssigning;

import androidx.constraintlayout.widget.ConstraintLayout;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.AuthOption;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningConfig;
import aws.smithy.kotlin.runtime.auth.awssigning.HashSpecification;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.client.endpoints.SigningContextKt;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.http.operation.EndpointResolver;
import aws.smithy.kotlin.runtime.http.operation.OperationEndpointKt;
import aws.smithy.kotlin.runtime.http.operation.ResolveEndpointRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestKt;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Presigner.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0087@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, m1599d2 = {"presignRequest", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "unsignedRequestBuilder", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "ctx", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "credentialsProvider", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "endpointResolver", "Laws/smithy/kotlin/runtime/http/operation/EndpointResolver;", "signer", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "signingConfig", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "(Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;Laws/smithy/kotlin/runtime/http/operation/EndpointResolver;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-signing-common"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PresignerKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.PresignerKt$presignRequest$1 */
    /* JADX INFO: compiled from: Presigner.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.PresignerKt", m1609f = "Presigner.kt", m1610i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m1611l = {32, 34, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m1612m = "presignRequest", m1613n = {"unsignedRequestBuilder", "ctx", "credentialsProvider", "endpointResolver", "signer", "signingConfig", "unsignedRequestBuilder", "ctx", "credentialsProvider", "endpointResolver", "signer", "signingConfig", "credentials", "eprRequest", "unsignedRequestBuilder", "ctx", "credentialsProvider", "endpointResolver", "signer", "signingConfig", "credentials", "eprRequest", "endpoint", "signingContext", "config"}, m1614nl = {33, 35, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, m1616v = 2)
    static final class C36511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C36511(Continuation<? super C36511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PresignerKt.presignRequest(null, null, null, null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0159 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @InternalApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object presignRequest(HttpRequestBuilder httpRequestBuilder, ExecutionContext executionContext, CredentialsProvider credentialsProvider, EndpointResolver endpointResolver, AwsSigner awsSigner, Function1<? super AwsSigningConfig.Builder, Unit> function1, Continuation<? super HttpRequest> continuation) {
        C36511 c36511;
        EndpointResolver endpointResolver2;
        CredentialsProvider credentialsProvider2;
        HttpRequestBuilder httpRequestBuilder2;
        Function1<? super AwsSigningConfig.Builder, Unit> function12;
        ExecutionContext executionContext2;
        AwsSigner awsSigner2;
        Function1<? super AwsSigningConfig.Builder, Unit> function13;
        ResolveEndpointRequest resolveEndpointRequest;
        HttpRequestBuilder httpRequestBuilder3;
        ExecutionContext executionContext3;
        CredentialsProvider credentialsProvider3;
        AwsSigner awsSigner3;
        Credentials credentials;
        Iterator<T> it;
        Object next;
        AuthOption authOption;
        Object objSign;
        Endpoint endpoint;
        if (continuation instanceof C36511) {
            c36511 = (C36511) continuation;
            if ((c36511.label & Integer.MIN_VALUE) != 0) {
                c36511.label -= Integer.MIN_VALUE;
            } else {
                c36511 = new C36511(continuation);
            }
        }
        Object objResolve = c36511.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36511.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objResolve);
            httpRequestBuilder.setBody(HttpBody.Empty.INSTANCE);
            MutableAttributes attributes = executionContext.getAttributes();
            c36511.L$0 = httpRequestBuilder;
            c36511.L$1 = executionContext;
            c36511.L$2 = SpillingKt.nullOutSpilledVariable(credentialsProvider);
            endpointResolver2 = endpointResolver;
            c36511.L$3 = endpointResolver2;
            c36511.L$4 = awsSigner;
            c36511.L$5 = function1;
            c36511.label = 1;
            credentialsProvider2 = credentialsProvider;
            objResolve = credentialsProvider2.resolve(attributes, c36511);
            if (objResolve != coroutine_suspended) {
                httpRequestBuilder2 = httpRequestBuilder;
                function12 = function1;
                executionContext2 = executionContext;
                awsSigner2 = awsSigner;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                endpoint = (Endpoint) c36511.L$8;
                ResultKt.throwOnFailure(objResolve);
                HttpRequest httpRequest = (HttpRequest) ((AwsSigningResult) objResolve).getOutput();
                HttpMethod method = httpRequest.getMethod();
                Url.Companion companion = Url.INSTANCE;
                Url.Builder builder = new Url.Builder();
                builder.setScheme(endpoint.getUri().getScheme());
                builder.setHost(endpoint.getUri().getHost());
                builder.setPort(Boxing.boxInt(endpoint.getUri().getPort()));
                builder.getPath().copyFrom(httpRequest.getUrl().getPath());
                builder.getParameters().copyFrom(httpRequest.getUrl().getParameters());
                return HttpRequestKt.HttpRequest$default(method, builder.build(), httpRequest.getHeaders(), HttpBody.Empty.INSTANCE, null, 16, null);
            }
            resolveEndpointRequest = (ResolveEndpointRequest) c36511.L$7;
            credentials = (Credentials) c36511.L$6;
            function13 = (Function1) c36511.L$5;
            awsSigner3 = (AwsSigner) c36511.L$4;
            endpointResolver2 = (EndpointResolver) c36511.L$3;
            credentialsProvider3 = (CredentialsProvider) c36511.L$2;
            executionContext3 = (ExecutionContext) c36511.L$1;
            httpRequestBuilder3 = (HttpRequestBuilder) c36511.L$0;
            ResultKt.throwOnFailure(objResolve);
            Endpoint endpoint2 = (Endpoint) objResolve;
            OperationEndpointKt.setResolvedEndpoint(httpRequestBuilder3, executionContext3, endpoint2);
            it = SigningContextKt.getAuthOptions(endpoint2).iterator();
            while (true) {
                if (it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (AuthSchemeId.m12119equalsimpl0(((AuthOption) next).mo12110getSchemeIdDepwgT4(), AuthSchemeId.INSTANCE.m12124getAwsSigV4DepwgT4())) {
                    break;
                }
            }
            authOption = (AuthOption) next;
            if (authOption != null || (attributesEmptyAttributes = authOption.getAttributes()) == null) {
                Attributes attributesEmptyAttributes = AttributesKt.emptyAttributes();
            }
            AwsSigningConfig.Companion companion2 = AwsSigningConfig.INSTANCE;
            AwsSigningConfig.Builder builder2 = new AwsSigningConfig.Builder();
            builder2.setRegion((String) attributesEmptyAttributes.getOrNull(AwsSigningAttributes.INSTANCE.getSigningRegion()));
            builder2.setService((String) attributesEmptyAttributes.getOrNull(AwsSigningAttributes.INSTANCE.getSigningService()));
            builder2.setCredentials(credentials);
            builder2.setSignedBodyHeader(AwsSignedBodyHeader.X_AMZ_CONTENT_SHA256);
            builder2.setSignatureType(AwsSignatureType.HTTP_REQUEST_VIA_QUERY_PARAMS);
            builder2.setHashSpecification(HashSpecification.UnsignedPayload.INSTANCE);
            function13.invoke(builder2);
            AwsSigningConfig awsSigningConfigBuild = builder2.build();
            HttpRequest httpRequestBuild = httpRequestBuilder3.build();
            c36511.L$0 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder3);
            c36511.L$1 = SpillingKt.nullOutSpilledVariable(executionContext3);
            c36511.L$2 = SpillingKt.nullOutSpilledVariable(credentialsProvider3);
            c36511.L$3 = SpillingKt.nullOutSpilledVariable(endpointResolver2);
            c36511.L$4 = SpillingKt.nullOutSpilledVariable(awsSigner3);
            c36511.L$5 = SpillingKt.nullOutSpilledVariable(function13);
            c36511.L$6 = SpillingKt.nullOutSpilledVariable(credentials);
            c36511.L$7 = SpillingKt.nullOutSpilledVariable(resolveEndpointRequest);
            c36511.L$8 = endpoint2;
            c36511.L$9 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes);
            c36511.L$10 = SpillingKt.nullOutSpilledVariable(awsSigningConfigBuild);
            c36511.label = 3;
            objSign = awsSigner3.sign(httpRequestBuild, awsSigningConfigBuild, c36511);
            if (objSign != coroutine_suspended) {
                objResolve = objSign;
                endpoint = endpoint2;
                HttpRequest httpRequest2 = (HttpRequest) ((AwsSigningResult) objResolve).getOutput();
                HttpMethod method2 = httpRequest2.getMethod();
                Url.Companion companion3 = Url.INSTANCE;
                Url.Builder builder3 = new Url.Builder();
                builder3.setScheme(endpoint.getUri().getScheme());
                builder3.setHost(endpoint.getUri().getHost());
                builder3.setPort(Boxing.boxInt(endpoint.getUri().getPort()));
                builder3.getPath().copyFrom(httpRequest2.getUrl().getPath());
                builder3.getParameters().copyFrom(httpRequest2.getUrl().getParameters());
                return HttpRequestKt.HttpRequest$default(method2, builder3.build(), httpRequest2.getHeaders(), HttpBody.Empty.INSTANCE, null, 16, null);
            }
            return coroutine_suspended;
        }
        function12 = (Function1) c36511.L$5;
        awsSigner2 = (AwsSigner) c36511.L$4;
        EndpointResolver endpointResolver3 = (EndpointResolver) c36511.L$3;
        CredentialsProvider credentialsProvider4 = (CredentialsProvider) c36511.L$2;
        executionContext2 = (ExecutionContext) c36511.L$1;
        httpRequestBuilder2 = (HttpRequestBuilder) c36511.L$0;
        ResultKt.throwOnFailure(objResolve);
        endpointResolver2 = endpointResolver3;
        credentialsProvider2 = credentialsProvider4;
        Credentials credentials2 = (Credentials) objResolve;
        ResolveEndpointRequest resolveEndpointRequest2 = new ResolveEndpointRequest(executionContext2, httpRequestBuilder2.build(), credentials2);
        c36511.L$0 = httpRequestBuilder2;
        c36511.L$1 = executionContext2;
        c36511.L$2 = SpillingKt.nullOutSpilledVariable(credentialsProvider2);
        c36511.L$3 = SpillingKt.nullOutSpilledVariable(endpointResolver2);
        c36511.L$4 = awsSigner2;
        c36511.L$5 = function12;
        c36511.L$6 = credentials2;
        c36511.L$7 = SpillingKt.nullOutSpilledVariable(resolveEndpointRequest2);
        c36511.label = 2;
        Object objResolve2 = endpointResolver2.resolve(resolveEndpointRequest2, c36511);
        if (objResolve2 != coroutine_suspended) {
            function13 = function12;
            resolveEndpointRequest = resolveEndpointRequest2;
            httpRequestBuilder3 = httpRequestBuilder2;
            executionContext3 = executionContext2;
            credentialsProvider3 = credentialsProvider2;
            awsSigner3 = awsSigner2;
            credentials = credentials2;
            objResolve = objResolve2;
            Endpoint endpoint22 = (Endpoint) objResolve;
            OperationEndpointKt.setResolvedEndpoint(httpRequestBuilder3, executionContext3, endpoint22);
            it = SigningContextKt.getAuthOptions(endpoint22).iterator();
            while (true) {
                if (it.hasNext()) {
                }
            }
            authOption = (AuthOption) next;
            if (authOption != null) {
            }
            Attributes attributesEmptyAttributes2 = AttributesKt.emptyAttributes();
            AwsSigningConfig.Companion companion22 = AwsSigningConfig.INSTANCE;
            AwsSigningConfig.Builder builder22 = new AwsSigningConfig.Builder();
            builder22.setRegion((String) attributesEmptyAttributes2.getOrNull(AwsSigningAttributes.INSTANCE.getSigningRegion()));
            builder22.setService((String) attributesEmptyAttributes2.getOrNull(AwsSigningAttributes.INSTANCE.getSigningService()));
            builder22.setCredentials(credentials);
            builder22.setSignedBodyHeader(AwsSignedBodyHeader.X_AMZ_CONTENT_SHA256);
            builder22.setSignatureType(AwsSignatureType.HTTP_REQUEST_VIA_QUERY_PARAMS);
            builder22.setHashSpecification(HashSpecification.UnsignedPayload.INSTANCE);
            function13.invoke(builder22);
            AwsSigningConfig awsSigningConfigBuild2 = builder22.build();
            HttpRequest httpRequestBuild2 = httpRequestBuilder3.build();
            c36511.L$0 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder3);
            c36511.L$1 = SpillingKt.nullOutSpilledVariable(executionContext3);
            c36511.L$2 = SpillingKt.nullOutSpilledVariable(credentialsProvider3);
            c36511.L$3 = SpillingKt.nullOutSpilledVariable(endpointResolver2);
            c36511.L$4 = SpillingKt.nullOutSpilledVariable(awsSigner3);
            c36511.L$5 = SpillingKt.nullOutSpilledVariable(function13);
            c36511.L$6 = SpillingKt.nullOutSpilledVariable(credentials);
            c36511.L$7 = SpillingKt.nullOutSpilledVariable(resolveEndpointRequest);
            c36511.L$8 = endpoint22;
            c36511.L$9 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes2);
            c36511.L$10 = SpillingKt.nullOutSpilledVariable(awsSigningConfigBuild2);
            c36511.label = 3;
            objSign = awsSigner3.sign(httpRequestBuild2, awsSigningConfigBuild2, c36511);
            if (objSign != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }
}

package aws.sdk.kotlin.services.p010s3.presigners;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.sdk.kotlin.services.p010s3.S3Client;
import aws.sdk.kotlin.services.p010s3.endpoints.internal.EndpointResolverAdapter;
import aws.sdk.kotlin.services.p010s3.model.DeleteObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.PutObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.UploadPartRequest;
import aws.sdk.kotlin.services.p010s3.serde.DeleteObjectOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutObjectOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.UploadPartOperationSerializer;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigner;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningConfig;
import aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerJVMKt;
import aws.smithy.kotlin.runtime.auth.awssigning.PresignerKt;
import aws.smithy.kotlin.runtime.client.SdkClientOption;
import aws.smithy.kotlin.runtime.http.operation.HttpOperationContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: compiled from: Presigners.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086@¢\u0006\u0002\u0010\u0010\u001a$\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001a=\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00122\b\b\u0002\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086@¢\u0006\u0002\u0010\u0015\u001a$\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019\u001a=\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00172\b\b\u0002\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086@¢\u0006\u0002\u0010\u001a\u001a$\u0010\u001b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u001d\u0010\u001e\u001a=\u0010\u001b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001c2\b\b\u0002\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086@¢\u0006\u0002\u0010\u001f¨\u0006 "}, m1599d2 = {"presignDeleteObject", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/sdk/kotlin/services/s3/S3Client;", "input", "Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest;", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "presignDeleteObject-exY8QGI", "(Laws/sdk/kotlin/services/s3/S3Client;Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signer", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "configBlock", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "(Laws/sdk/kotlin/services/s3/S3Client;Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presignGetObject", "Laws/sdk/kotlin/services/s3/model/GetObjectRequest;", "presignGetObject-exY8QGI", "(Laws/sdk/kotlin/services/s3/S3Client;Laws/sdk/kotlin/services/s3/model/GetObjectRequest;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Laws/sdk/kotlin/services/s3/S3Client;Laws/sdk/kotlin/services/s3/model/GetObjectRequest;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presignPutObject", "Laws/sdk/kotlin/services/s3/model/PutObjectRequest;", "presignPutObject-exY8QGI", "(Laws/sdk/kotlin/services/s3/S3Client;Laws/sdk/kotlin/services/s3/model/PutObjectRequest;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Laws/sdk/kotlin/services/s3/S3Client;Laws/sdk/kotlin/services/s3/model/PutObjectRequest;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presignUploadPart", "Laws/sdk/kotlin/services/s3/model/UploadPartRequest;", "presignUploadPart-exY8QGI", "(Laws/sdk/kotlin/services/s3/S3Client;Laws/sdk/kotlin/services/s3/model/UploadPartRequest;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Laws/sdk/kotlin/services/s3/S3Client;Laws/sdk/kotlin/services/s3/model/UploadPartRequest;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PresignersKt {
    /* JADX INFO: renamed from: presignDeleteObject-exY8QGI, reason: not valid java name */
    public static final Object m12082presignDeleteObjectexY8QGI(S3Client s3Client, DeleteObjectRequest deleteObjectRequest, final long j, Continuation<? super HttpRequest> continuation) {
        return presignDeleteObject$default(s3Client, deleteObjectRequest, null, new Function1() { // from class: aws.sdk.kotlin.services.s3.presigners.PresignersKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PresignersKt.presignDeleteObject_exY8QGI$lambda$0(j, (AwsSigningConfig.Builder) obj);
            }
        }, continuation, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit presignDeleteObject_exY8QGI$lambda$0(long j, AwsSigningConfig.Builder presignDeleteObject) {
        Intrinsics.checkNotNullParameter(presignDeleteObject, "$this$presignDeleteObject");
        presignDeleteObject.m12135setExpiresAfterBwNAW2A(Duration.m15854boximpl(j));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object presignDeleteObject$default(S3Client s3Client, DeleteObjectRequest deleteObjectRequest, AwsSigner awsSigner, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            awsSigner = DefaultAwsSignerJVMKt.getDefaultAwsSigner();
        }
        return presignDeleteObject(s3Client, deleteObjectRequest, awsSigner, function1, continuation);
    }

    public static final Object presignDeleteObject(final S3Client s3Client, DeleteObjectRequest deleteObjectRequest, AwsSigner awsSigner, final Function1<? super AwsSigningConfig.Builder, Unit> function1, Continuation<? super HttpRequest> continuation) {
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.set(SdkClientOption.INSTANCE.getOperationName(), "DeleteObject");
        executionContext.set(HttpOperationContext.INSTANCE.getOperationInput(), deleteObjectRequest);
        return PresignerKt.presignRequest(new DeleteObjectOperationSerializer().serialize(executionContext, deleteObjectRequest), executionContext, s3Client.getConfig().getCredentialsProvider(), new EndpointResolverAdapter(s3Client.getConfig()), awsSigner, new Function1() { // from class: aws.sdk.kotlin.services.s3.presigners.PresignersKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PresignersKt.presignDeleteObject$lambda$1(s3Client, function1, (AwsSigningConfig.Builder) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit presignDeleteObject$lambda$1(S3Client s3Client, Function1 function1, AwsSigningConfig.Builder presignRequest) {
        Intrinsics.checkNotNullParameter(presignRequest, "$this$presignRequest");
        if (presignRequest.getService() == null) {
            presignRequest.setService("s3");
        }
        if (presignRequest.getRegion() == null) {
            presignRequest.setRegion(s3Client.getConfig().getRegion());
        }
        presignRequest.setUseDoubleUriEncode(false);
        presignRequest.setNormalizeUriPath(false);
        function1.invoke(presignRequest);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: presignGetObject-exY8QGI, reason: not valid java name */
    public static final Object m12083presignGetObjectexY8QGI(S3Client s3Client, GetObjectRequest getObjectRequest, final long j, Continuation<? super HttpRequest> continuation) {
        return presignGetObject$default(s3Client, getObjectRequest, null, new Function1() { // from class: aws.sdk.kotlin.services.s3.presigners.PresignersKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PresignersKt.presignGetObject_exY8QGI$lambda$0(j, (AwsSigningConfig.Builder) obj);
            }
        }, continuation, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit presignGetObject_exY8QGI$lambda$0(long j, AwsSigningConfig.Builder presignGetObject) {
        Intrinsics.checkNotNullParameter(presignGetObject, "$this$presignGetObject");
        presignGetObject.m12135setExpiresAfterBwNAW2A(Duration.m15854boximpl(j));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object presignGetObject$default(S3Client s3Client, GetObjectRequest getObjectRequest, AwsSigner awsSigner, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            awsSigner = DefaultAwsSignerJVMKt.getDefaultAwsSigner();
        }
        return presignGetObject(s3Client, getObjectRequest, awsSigner, function1, continuation);
    }

    public static final Object presignGetObject(final S3Client s3Client, GetObjectRequest getObjectRequest, AwsSigner awsSigner, final Function1<? super AwsSigningConfig.Builder, Unit> function1, Continuation<? super HttpRequest> continuation) {
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.set(SdkClientOption.INSTANCE.getOperationName(), "GetObject");
        executionContext.set(HttpOperationContext.INSTANCE.getOperationInput(), getObjectRequest);
        return PresignerKt.presignRequest(new GetObjectOperationSerializer().serialize(executionContext, getObjectRequest), executionContext, s3Client.getConfig().getCredentialsProvider(), new EndpointResolverAdapter(s3Client.getConfig()), awsSigner, new Function1() { // from class: aws.sdk.kotlin.services.s3.presigners.PresignersKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PresignersKt.presignGetObject$lambda$1(s3Client, function1, (AwsSigningConfig.Builder) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit presignGetObject$lambda$1(S3Client s3Client, Function1 function1, AwsSigningConfig.Builder presignRequest) {
        Intrinsics.checkNotNullParameter(presignRequest, "$this$presignRequest");
        if (presignRequest.getService() == null) {
            presignRequest.setService("s3");
        }
        if (presignRequest.getRegion() == null) {
            presignRequest.setRegion(s3Client.getConfig().getRegion());
        }
        presignRequest.setUseDoubleUriEncode(false);
        presignRequest.setNormalizeUriPath(false);
        function1.invoke(presignRequest);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: presignPutObject-exY8QGI, reason: not valid java name */
    public static final Object m12084presignPutObjectexY8QGI(S3Client s3Client, PutObjectRequest putObjectRequest, final long j, Continuation<? super HttpRequest> continuation) {
        return presignPutObject$default(s3Client, putObjectRequest, null, new Function1() { // from class: aws.sdk.kotlin.services.s3.presigners.PresignersKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PresignersKt.presignPutObject_exY8QGI$lambda$0(j, (AwsSigningConfig.Builder) obj);
            }
        }, continuation, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit presignPutObject_exY8QGI$lambda$0(long j, AwsSigningConfig.Builder presignPutObject) {
        Intrinsics.checkNotNullParameter(presignPutObject, "$this$presignPutObject");
        presignPutObject.m12135setExpiresAfterBwNAW2A(Duration.m15854boximpl(j));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object presignPutObject$default(S3Client s3Client, PutObjectRequest putObjectRequest, AwsSigner awsSigner, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            awsSigner = DefaultAwsSignerJVMKt.getDefaultAwsSigner();
        }
        return presignPutObject(s3Client, putObjectRequest, awsSigner, function1, continuation);
    }

    public static final Object presignPutObject(final S3Client s3Client, PutObjectRequest putObjectRequest, AwsSigner awsSigner, final Function1<? super AwsSigningConfig.Builder, Unit> function1, Continuation<? super HttpRequest> continuation) {
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.set(SdkClientOption.INSTANCE.getOperationName(), "PutObject");
        executionContext.set(HttpOperationContext.INSTANCE.getOperationInput(), putObjectRequest);
        return PresignerKt.presignRequest(new PutObjectOperationSerializer().serialize(executionContext, putObjectRequest), executionContext, s3Client.getConfig().getCredentialsProvider(), new EndpointResolverAdapter(s3Client.getConfig()), awsSigner, new Function1() { // from class: aws.sdk.kotlin.services.s3.presigners.PresignersKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PresignersKt.presignPutObject$lambda$1(s3Client, function1, (AwsSigningConfig.Builder) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit presignPutObject$lambda$1(S3Client s3Client, Function1 function1, AwsSigningConfig.Builder presignRequest) {
        Intrinsics.checkNotNullParameter(presignRequest, "$this$presignRequest");
        if (presignRequest.getService() == null) {
            presignRequest.setService("s3");
        }
        if (presignRequest.getRegion() == null) {
            presignRequest.setRegion(s3Client.getConfig().getRegion());
        }
        presignRequest.setUseDoubleUriEncode(false);
        presignRequest.setNormalizeUriPath(false);
        function1.invoke(presignRequest);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: presignUploadPart-exY8QGI, reason: not valid java name */
    public static final Object m12085presignUploadPartexY8QGI(S3Client s3Client, UploadPartRequest uploadPartRequest, final long j, Continuation<? super HttpRequest> continuation) {
        return presignUploadPart$default(s3Client, uploadPartRequest, null, new Function1() { // from class: aws.sdk.kotlin.services.s3.presigners.PresignersKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PresignersKt.presignUploadPart_exY8QGI$lambda$0(j, (AwsSigningConfig.Builder) obj);
            }
        }, continuation, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit presignUploadPart_exY8QGI$lambda$0(long j, AwsSigningConfig.Builder presignUploadPart) {
        Intrinsics.checkNotNullParameter(presignUploadPart, "$this$presignUploadPart");
        presignUploadPart.m12135setExpiresAfterBwNAW2A(Duration.m15854boximpl(j));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object presignUploadPart$default(S3Client s3Client, UploadPartRequest uploadPartRequest, AwsSigner awsSigner, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            awsSigner = DefaultAwsSignerJVMKt.getDefaultAwsSigner();
        }
        return presignUploadPart(s3Client, uploadPartRequest, awsSigner, function1, continuation);
    }

    public static final Object presignUploadPart(final S3Client s3Client, UploadPartRequest uploadPartRequest, AwsSigner awsSigner, final Function1<? super AwsSigningConfig.Builder, Unit> function1, Continuation<? super HttpRequest> continuation) {
        ExecutionContext executionContext = new ExecutionContext();
        executionContext.set(SdkClientOption.INSTANCE.getOperationName(), "UploadPart");
        executionContext.set(HttpOperationContext.INSTANCE.getOperationInput(), uploadPartRequest);
        return PresignerKt.presignRequest(new UploadPartOperationSerializer().serialize(executionContext, uploadPartRequest), executionContext, s3Client.getConfig().getCredentialsProvider(), new EndpointResolverAdapter(s3Client.getConfig()), awsSigner, new Function1() { // from class: aws.sdk.kotlin.services.s3.presigners.PresignersKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PresignersKt.presignUploadPart$lambda$1(s3Client, function1, (AwsSigningConfig.Builder) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit presignUploadPart$lambda$1(S3Client s3Client, Function1 function1, AwsSigningConfig.Builder presignRequest) {
        Intrinsics.checkNotNullParameter(presignRequest, "$this$presignRequest");
        if (presignRequest.getService() == null) {
            presignRequest.setService("s3");
        }
        if (presignRequest.getRegion() == null) {
            presignRequest.setRegion(s3Client.getConfig().getRegion());
        }
        presignRequest.setUseDoubleUriEncode(false);
        presignRequest.setNormalizeUriPath(false);
        function1.invoke(presignRequest);
        return Unit.INSTANCE;
    }
}

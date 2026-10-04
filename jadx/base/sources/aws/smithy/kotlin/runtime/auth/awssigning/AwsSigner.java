package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: AwsSigner.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u000eJ,\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "", "sign", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningResult;", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "request", "config", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signChunk", "", "chunkBody", "", "prevSignature", "([B[BLaws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signChunkTrailer", "trailingHeaders", "Laws/smithy/kotlin/runtime/http/Headers;", "(Laws/smithy/kotlin/runtime/http/Headers;[BLaws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-signing-common"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface AwsSigner {
    Object sign(HttpRequest httpRequest, AwsSigningConfig awsSigningConfig, Continuation<? super AwsSigningResult<HttpRequest>> continuation);

    Object signChunk(byte[] bArr, byte[] bArr2, AwsSigningConfig awsSigningConfig, Continuation<? super AwsSigningResult<Unit>> continuation);

    Object signChunkTrailer(Headers headers, byte[] bArr, AwsSigningConfig awsSigningConfig, Continuation<? super AwsSigningResult<Unit>> continuation);
}

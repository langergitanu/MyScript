package aws.sdk.kotlin.services.p010s3.serde;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.model.ChecksumType;
import aws.sdk.kotlin.services.p010s3.model.GetObjectResponse;
import aws.sdk.kotlin.services.p010s3.model.ObjectLockLegalHoldStatus;
import aws.sdk.kotlin.services.p010s3.model.ObjectLockMode;
import aws.sdk.kotlin.services.p010s3.model.ReplicationStatus;
import aws.sdk.kotlin.services.p010s3.model.RequestCharged;
import aws.sdk.kotlin.services.p010s3.model.ServerSideEncryption;
import aws.sdk.kotlin.services.p010s3.model.StorageClass;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.HttpStatusCodeKt;
import aws.smithy.kotlin.runtime.http.operation.HttpDeserializer;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.time.Instant;
import com.google.common.net.HttpHeaders;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GetObjectOperationDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/serde/GetObjectOperationDeserializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer$Streaming;", "Laws/sdk/kotlin/services/s3/model/GetObjectResponse;", "<init>", "()V", "deserialize", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/http/HttpCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetObjectOperationDeserializer implements HttpDeserializer.Streaming<GetObjectResponse> {

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.GetObjectOperationDeserializer$deserialize$1 */
    /* JADX INFO: compiled from: GetObjectOperationDeserializer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.serde.GetObjectOperationDeserializer", m1609f = "GetObjectOperationDeserializer.kt", m1610i = {0, 0, 0}, m1611l = {37}, m1612m = "deserialize", m1613n = {WebViewMessageType.CONTEXT, NotificationCompat.CATEGORY_CALL, "response"}, m1614nl = {38}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C35141 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C35141(Continuation<? super C35141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetObjectOperationDeserializer.this.deserialize(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpDeserializer.Streaming
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deserialize(ExecutionContext executionContext, HttpCall httpCall, Continuation<? super GetObjectResponse> continuation) throws Throwable {
        C35141 c35141;
        if (continuation instanceof C35141) {
            c35141 = (C35141) continuation;
            if ((c35141.label & Integer.MIN_VALUE) != 0) {
                c35141.label -= Integer.MIN_VALUE;
            } else {
                c35141 = new C35141(continuation);
            }
        }
        Object all = c35141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c35141.label;
        if (i == 0) {
            ResultKt.throwOnFailure(all);
            HttpResponse response = httpCall.getResponse();
            if (!HttpStatusCodeKt.isSuccess(response.getStatus())) {
                HttpBody body = response.getBody();
                c35141.L$0 = executionContext;
                c35141.L$1 = httpCall;
                c35141.L$2 = SpillingKt.nullOutSpilledVariable(response);
                c35141.label = 1;
                all = HttpBodyKt.readAll(body, c35141);
                if (all == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                GetObjectResponse.Builder builder = new GetObjectResponse.Builder();
                builder.setAcceptRanges(response.getHeaders().get("accept-ranges"));
                String str = response.getHeaders().get("x-amz-server-side-encryption-bucket-key-enabled");
                builder.setBucketKeyEnabled(str != null ? Boxing.boxBoolean(Boolean.parseBoolean(str)) : null);
                builder.setCacheControl(response.getHeaders().get("Cache-Control"));
                builder.setChecksumCrc32(response.getHeaders().get("x-amz-checksum-crc32"));
                builder.setChecksumCrc32C(response.getHeaders().get("x-amz-checksum-crc32c"));
                builder.setChecksumCrc64Nvme(response.getHeaders().get("x-amz-checksum-crc64nvme"));
                builder.setChecksumSha1(response.getHeaders().get("x-amz-checksum-sha1"));
                builder.setChecksumSha256(response.getHeaders().get("x-amz-checksum-sha256"));
                String str2 = response.getHeaders().get("x-amz-checksum-type");
                builder.setChecksumType(str2 != null ? ChecksumType.INSTANCE.fromValue(str2) : null);
                builder.setContentDisposition(response.getHeaders().get(HttpHeaders.CONTENT_DISPOSITION));
                builder.setContentEncoding(response.getHeaders().get("Content-Encoding"));
                builder.setContentLanguage(response.getHeaders().get("Content-Language"));
                String str3 = response.getHeaders().get("Content-Length");
                builder.setContentLength(str3 != null ? Boxing.boxLong(Long.parseLong(str3)) : null);
                builder.setContentRange(response.getHeaders().get("Content-Range"));
                builder.setContentType(response.getHeaders().get("Content-Type"));
                String str4 = response.getHeaders().get("x-amz-delete-marker");
                builder.setDeleteMarker(str4 != null ? Boxing.boxBoolean(Boolean.parseBoolean(str4)) : null);
                builder.setETag(response.getHeaders().get("ETag"));
                builder.setExpiration(response.getHeaders().get("x-amz-expiration"));
                String str5 = response.getHeaders().get("Expires");
                builder.setExpires(str5 != null ? Instant.INSTANCE.fromRfc5322(str5) : null);
                builder.setExpiresString(response.getHeaders().get("ExpiresString"));
                String str6 = response.getHeaders().get("Last-Modified");
                builder.setLastModified(str6 != null ? Instant.INSTANCE.fromRfc5322(str6) : null);
                String str7 = response.getHeaders().get("x-amz-missing-meta");
                builder.setMissingMeta(str7 != null ? Boxing.boxInt(Integer.parseInt(str7)) : null);
                String str8 = response.getHeaders().get("x-amz-object-lock-legal-hold");
                builder.setObjectLockLegalHoldStatus(str8 != null ? ObjectLockLegalHoldStatus.INSTANCE.fromValue(str8) : null);
                String str9 = response.getHeaders().get("x-amz-object-lock-mode");
                builder.setObjectLockMode(str9 != null ? ObjectLockMode.INSTANCE.fromValue(str9) : null);
                String str10 = response.getHeaders().get("x-amz-object-lock-retain-until-date");
                builder.setObjectLockRetainUntilDate(str10 != null ? Instant.INSTANCE.fromIso8601(str10) : null);
                String str11 = response.getHeaders().get("x-amz-mp-parts-count");
                builder.setPartsCount(str11 != null ? Boxing.boxInt(Integer.parseInt(str11)) : null);
                String str12 = response.getHeaders().get("x-amz-replication-status");
                builder.setReplicationStatus(str12 != null ? ReplicationStatus.INSTANCE.fromValue(str12) : null);
                String str13 = response.getHeaders().get("x-amz-request-charged");
                builder.setRequestCharged(str13 != null ? RequestCharged.INSTANCE.fromValue(str13) : null);
                builder.setRestore(response.getHeaders().get("x-amz-restore"));
                builder.setSseCustomerAlgorithm(response.getHeaders().get("x-amz-server-side-encryption-customer-algorithm"));
                builder.setSseCustomerKeyMd5(response.getHeaders().get("x-amz-server-side-encryption-customer-key-MD5"));
                builder.setSsekmsKeyId(response.getHeaders().get("x-amz-server-side-encryption-aws-kms-key-id"));
                String str14 = response.getHeaders().get("x-amz-server-side-encryption");
                builder.setServerSideEncryption(str14 != null ? ServerSideEncryption.INSTANCE.fromValue(str14) : null);
                String str15 = response.getHeaders().get("x-amz-storage-class");
                builder.setStorageClass(str15 != null ? StorageClass.INSTANCE.fromValue(str15) : null);
                String str16 = response.getHeaders().get("x-amz-tagging-count");
                builder.setTagCount(str16 != null ? Boxing.boxInt(Integer.parseInt(str16)) : null);
                builder.setVersionId(response.getHeaders().get("x-amz-version-id"));
                builder.setWebsiteRedirectLocation(response.getHeaders().get("x-amz-website-redirect-location"));
                Set<String> setNames = response.getHeaders().names();
                ArrayList arrayList = new ArrayList();
                for (Object obj : setNames) {
                    if (StringsKt.startsWith$default((String) obj, "x-amz-meta-", false, 2, (Object) null)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList<String> arrayList2 = arrayList;
                if (!arrayList2.isEmpty()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (String str17 : arrayList2) {
                        String str18 = response.getHeaders().get(str17);
                        if (str18 != null) {
                            linkedHashMap.put(StringsKt.removePrefix(str17, (CharSequence) "x-amz-meta-"), str18);
                        }
                    }
                    builder.setMetadata(linkedHashMap);
                } else {
                    builder.setMetadata(MapsKt.emptyMap());
                }
                builder.setBody(HttpBodyKt.toByteStream(response.getBody()));
                builder.correctErrors$s3();
                return builder.build();
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            httpCall = (HttpCall) c35141.L$1;
            executionContext = (ExecutionContext) c35141.L$0;
            ResultKt.throwOnFailure(all);
        }
        GetObjectOperationDeserializerKt.throwGetObjectError(executionContext, httpCall, (byte[]) all);
        throw new KotlinNothingValueException();
    }
}

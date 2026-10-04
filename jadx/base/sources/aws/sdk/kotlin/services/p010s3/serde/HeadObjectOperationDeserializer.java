package aws.sdk.kotlin.services.p010s3.serde;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.model.ArchiveStatus;
import aws.sdk.kotlin.services.p010s3.model.ChecksumType;
import aws.sdk.kotlin.services.p010s3.model.HeadObjectResponse;
import aws.sdk.kotlin.services.p010s3.model.ObjectLockLegalHoldStatus;
import aws.sdk.kotlin.services.p010s3.model.ObjectLockMode;
import aws.sdk.kotlin.services.p010s3.model.ReplicationStatus;
import aws.sdk.kotlin.services.p010s3.model.RequestCharged;
import aws.sdk.kotlin.services.p010s3.model.ServerSideEncryption;
import aws.sdk.kotlin.services.p010s3.model.StorageClass;
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
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HeadObjectOperationDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/serde/HeadObjectOperationDeserializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer$NonStreaming;", "Laws/sdk/kotlin/services/s3/model/HeadObjectResponse;", "<init>", "()V", "deserialize", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "payload", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HeadObjectOperationDeserializer implements HttpDeserializer.NonStreaming<HeadObjectResponse> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpDeserializer.NonStreaming
    public HeadObjectResponse deserialize(ExecutionContext context, HttpCall call, byte[] payload) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(call, "call");
        HttpResponse response = call.getResponse();
        if (!HttpStatusCodeKt.isSuccess(response.getStatus())) {
            HeadObjectOperationDeserializerKt.throwHeadObjectError(context, call, payload);
            throw new KotlinNothingValueException();
        }
        HeadObjectResponse.Builder builder = new HeadObjectResponse.Builder();
        builder.setAcceptRanges(response.getHeaders().get("accept-ranges"));
        String str = response.getHeaders().get("x-amz-archive-status");
        builder.setArchiveStatus(str != null ? ArchiveStatus.INSTANCE.fromValue(str) : null);
        String str2 = response.getHeaders().get("x-amz-server-side-encryption-bucket-key-enabled");
        builder.setBucketKeyEnabled(str2 != null ? Boolean.valueOf(Boolean.parseBoolean(str2)) : null);
        builder.setCacheControl(response.getHeaders().get("Cache-Control"));
        builder.setChecksumCrc32(response.getHeaders().get("x-amz-checksum-crc32"));
        builder.setChecksumCrc32C(response.getHeaders().get("x-amz-checksum-crc32c"));
        builder.setChecksumCrc64Nvme(response.getHeaders().get("x-amz-checksum-crc64nvme"));
        builder.setChecksumSha1(response.getHeaders().get("x-amz-checksum-sha1"));
        builder.setChecksumSha256(response.getHeaders().get("x-amz-checksum-sha256"));
        String str3 = response.getHeaders().get("x-amz-checksum-type");
        builder.setChecksumType(str3 != null ? ChecksumType.INSTANCE.fromValue(str3) : null);
        builder.setContentDisposition(response.getHeaders().get(HttpHeaders.CONTENT_DISPOSITION));
        builder.setContentEncoding(response.getHeaders().get("Content-Encoding"));
        builder.setContentLanguage(response.getHeaders().get("Content-Language"));
        String str4 = response.getHeaders().get("Content-Length");
        builder.setContentLength(str4 != null ? Long.valueOf(Long.parseLong(str4)) : null);
        builder.setContentRange(response.getHeaders().get("Content-Range"));
        builder.setContentType(response.getHeaders().get("Content-Type"));
        String str5 = response.getHeaders().get("x-amz-delete-marker");
        builder.setDeleteMarker(str5 != null ? Boolean.valueOf(Boolean.parseBoolean(str5)) : null);
        builder.setETag(response.getHeaders().get("ETag"));
        builder.setExpiration(response.getHeaders().get("x-amz-expiration"));
        String str6 = response.getHeaders().get("Expires");
        builder.setExpires(str6 != null ? Instant.INSTANCE.fromRfc5322(str6) : null);
        builder.setExpiresString(response.getHeaders().get("ExpiresString"));
        String str7 = response.getHeaders().get("Last-Modified");
        builder.setLastModified(str7 != null ? Instant.INSTANCE.fromRfc5322(str7) : null);
        String str8 = response.getHeaders().get("x-amz-missing-meta");
        builder.setMissingMeta(str8 != null ? Integer.valueOf(Integer.parseInt(str8)) : null);
        String str9 = response.getHeaders().get("x-amz-object-lock-legal-hold");
        builder.setObjectLockLegalHoldStatus(str9 != null ? ObjectLockLegalHoldStatus.INSTANCE.fromValue(str9) : null);
        String str10 = response.getHeaders().get("x-amz-object-lock-mode");
        builder.setObjectLockMode(str10 != null ? ObjectLockMode.INSTANCE.fromValue(str10) : null);
        String str11 = response.getHeaders().get("x-amz-object-lock-retain-until-date");
        builder.setObjectLockRetainUntilDate(str11 != null ? Instant.INSTANCE.fromIso8601(str11) : null);
        String str12 = response.getHeaders().get("x-amz-mp-parts-count");
        builder.setPartsCount(str12 != null ? Integer.valueOf(Integer.parseInt(str12)) : null);
        String str13 = response.getHeaders().get("x-amz-replication-status");
        builder.setReplicationStatus(str13 != null ? ReplicationStatus.INSTANCE.fromValue(str13) : null);
        String str14 = response.getHeaders().get("x-amz-request-charged");
        builder.setRequestCharged(str14 != null ? RequestCharged.INSTANCE.fromValue(str14) : null);
        builder.setRestore(response.getHeaders().get("x-amz-restore"));
        builder.setSseCustomerAlgorithm(response.getHeaders().get("x-amz-server-side-encryption-customer-algorithm"));
        builder.setSseCustomerKeyMd5(response.getHeaders().get("x-amz-server-side-encryption-customer-key-MD5"));
        builder.setSsekmsKeyId(response.getHeaders().get("x-amz-server-side-encryption-aws-kms-key-id"));
        String str15 = response.getHeaders().get("x-amz-server-side-encryption");
        builder.setServerSideEncryption(str15 != null ? ServerSideEncryption.INSTANCE.fromValue(str15) : null);
        String str16 = response.getHeaders().get("x-amz-storage-class");
        builder.setStorageClass(str16 != null ? StorageClass.INSTANCE.fromValue(str16) : null);
        String str17 = response.getHeaders().get("x-amz-tagging-count");
        builder.setTagCount(str17 != null ? Integer.valueOf(Integer.parseInt(str17)) : null);
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
            for (String str18 : arrayList2) {
                String str19 = response.getHeaders().get(str18);
                if (str19 != null) {
                    linkedHashMap.put(StringsKt.removePrefix(str18, (CharSequence) "x-amz-meta-"), str19);
                }
            }
            builder.setMetadata(linkedHashMap);
        } else {
            builder.setMetadata(MapsKt.emptyMap());
        }
        builder.correctErrors$s3();
        return builder.build();
    }
}

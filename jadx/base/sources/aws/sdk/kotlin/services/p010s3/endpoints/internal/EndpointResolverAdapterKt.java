package aws.sdk.kotlin.services.p010s3.endpoints.internal;

import aws.sdk.kotlin.services.p010s3.S3Client;
import aws.sdk.kotlin.services.p010s3.endpoints.S3EndpointParameters;
import aws.sdk.kotlin.services.p010s3.model.AbortMultipartUploadRequest;
import aws.sdk.kotlin.services.p010s3.model.CompleteMultipartUploadRequest;
import aws.sdk.kotlin.services.p010s3.model.CopyObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.CreateBucketMetadataConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.CreateBucketMetadataTableConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.CreateBucketRequest;
import aws.sdk.kotlin.services.p010s3.model.CreateMultipartUploadRequest;
import aws.sdk.kotlin.services.p010s3.model.CreateSessionRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketAnalyticsConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketCorsRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketEncryptionRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketIntelligentTieringConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketInventoryConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketLifecycleRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketMetadataConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketMetadataTableConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketMetricsConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketOwnershipControlsRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketPolicyRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketReplicationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketTaggingRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketWebsiteRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteObjectTaggingRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteObjectsRequest;
import aws.sdk.kotlin.services.p010s3.model.DeletePublicAccessBlockRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketAbacRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketAccelerateConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketAclRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketAnalyticsConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketCorsRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketEncryptionRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketIntelligentTieringConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketInventoryConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketLifecycleConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketLocationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketLoggingRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketMetadataConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketMetadataTableConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketMetricsConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketNotificationConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketOwnershipControlsRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketPolicyRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketPolicyStatusRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketReplicationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketRequestPaymentRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketTaggingRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketVersioningRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketWebsiteRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectAclRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectAttributesRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectLegalHoldRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectLockConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectRetentionRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectTaggingRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectTorrentRequest;
import aws.sdk.kotlin.services.p010s3.model.GetPublicAccessBlockRequest;
import aws.sdk.kotlin.services.p010s3.model.HeadBucketRequest;
import aws.sdk.kotlin.services.p010s3.model.HeadObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.ListBucketAnalyticsConfigurationsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListBucketIntelligentTieringConfigurationsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListBucketInventoryConfigurationsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListBucketMetricsConfigurationsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListMultipartUploadsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListObjectVersionsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListObjectsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListObjectsV2Request;
import aws.sdk.kotlin.services.p010s3.model.ListPartsRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketAbacRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketAccelerateConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketAclRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketAnalyticsConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketCorsRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketEncryptionRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketIntelligentTieringConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketInventoryConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketLifecycleConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketLoggingRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketMetricsConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketNotificationConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketOwnershipControlsRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketPolicyRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketReplicationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketRequestPaymentRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketTaggingRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketVersioningRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketWebsiteRequest;
import aws.sdk.kotlin.services.p010s3.model.PutObjectAclRequest;
import aws.sdk.kotlin.services.p010s3.model.PutObjectLegalHoldRequest;
import aws.sdk.kotlin.services.p010s3.model.PutObjectLockConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.PutObjectRetentionRequest;
import aws.sdk.kotlin.services.p010s3.model.PutObjectTaggingRequest;
import aws.sdk.kotlin.services.p010s3.model.PutPublicAccessBlockRequest;
import aws.sdk.kotlin.services.p010s3.model.RenameObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.RestoreObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.SelectObjectContentRequest;
import aws.sdk.kotlin.services.p010s3.model.UpdateBucketMetadataInventoryTableConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.UpdateBucketMetadataJournalTableConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.UpdateObjectEncryptionRequest;
import aws.sdk.kotlin.services.p010s3.model.UploadPartCopyRequest;
import aws.sdk.kotlin.services.p010s3.model.UploadPartRequest;
import aws.smithy.kotlin.runtime.client.SdkClientOption;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.operation.HttpOperationContext;
import aws.smithy.kotlin.runtime.http.operation.ResolveEndpointRequest;
import aws.smithy.kotlin.runtime.net.url.Url;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EndpointResolverAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\bm\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010!\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\"\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010#\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010$\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010%\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010&\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010'\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010(\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010)\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010*\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010+\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010,\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010-\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010.\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010/\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u00100\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u00101\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u00102\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u00103\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u00104\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u00105\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u00106\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u00107\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u00108\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u00109\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010:\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010;\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010<\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010=\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010>\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010?\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010@\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010A\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010B\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010C\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010D\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010E\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010F\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010G\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010H\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010I\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010J\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010K\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010L\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010M\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010N\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010O\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010P\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010Q\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010R\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010S\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010T\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010U\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010V\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010W\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010X\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010Y\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010Z\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010[\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\\\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010]\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010^\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010_\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010`\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010d\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010g\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010h\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010i\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010j\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010k\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010l\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010m\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010o\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010p\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010q\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010s\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010t\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010u\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010v\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010w\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010x\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001c\u0010y\u001a\u00020\t*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\"0\u0010\n\u001a$\u0012\u0004\u0012\u00020\f\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000*0\b\u0002\u0010\u0006\"\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u00072\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0007¨\u0006z"}, m1599d2 = {"resolveEndpointParams", "Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters;", "config", "Laws/sdk/kotlin/services/s3/S3Client$Config;", "request", "Laws/smithy/kotlin/runtime/http/operation/ResolveEndpointRequest;", "BindOperationContextParamsFn", "Lkotlin/Function2;", "Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters$Builder;", "", "opContextBindings", "", "", "Laws/sdk/kotlin/services/s3/endpoints/internal/BindOperationContextParamsFn;", "bindAbortMultipartUploadEndpointContext", "builder", "bindCompleteMultipartUploadEndpointContext", "bindCopyObjectEndpointContext", "bindCreateBucketEndpointContext", "bindCreateBucketMetadataConfigurationEndpointContext", "bindCreateBucketMetadataTableConfigurationEndpointContext", "bindCreateMultipartUploadEndpointContext", "bindCreateSessionEndpointContext", "bindDeleteBucketEndpointContext", "bindDeleteBucketAnalyticsConfigurationEndpointContext", "bindDeleteBucketCorsEndpointContext", "bindDeleteBucketEncryptionEndpointContext", "bindDeleteBucketIntelligentTieringConfigurationEndpointContext", "bindDeleteBucketInventoryConfigurationEndpointContext", "bindDeleteBucketLifecycleEndpointContext", "bindDeleteBucketMetadataConfigurationEndpointContext", "bindDeleteBucketMetadataTableConfigurationEndpointContext", "bindDeleteBucketMetricsConfigurationEndpointContext", "bindDeleteBucketOwnershipControlsEndpointContext", "bindDeleteBucketPolicyEndpointContext", "bindDeleteBucketReplicationEndpointContext", "bindDeleteBucketTaggingEndpointContext", "bindDeleteBucketWebsiteEndpointContext", "bindDeleteObjectEndpointContext", "bindDeleteObjectsEndpointContext", "bindDeleteObjectTaggingEndpointContext", "bindDeletePublicAccessBlockEndpointContext", "bindGetBucketAbacEndpointContext", "bindGetBucketAccelerateConfigurationEndpointContext", "bindGetBucketAclEndpointContext", "bindGetBucketAnalyticsConfigurationEndpointContext", "bindGetBucketCorsEndpointContext", "bindGetBucketEncryptionEndpointContext", "bindGetBucketIntelligentTieringConfigurationEndpointContext", "bindGetBucketInventoryConfigurationEndpointContext", "bindGetBucketLifecycleConfigurationEndpointContext", "bindGetBucketLocationEndpointContext", "bindGetBucketLoggingEndpointContext", "bindGetBucketMetadataConfigurationEndpointContext", "bindGetBucketMetadataTableConfigurationEndpointContext", "bindGetBucketMetricsConfigurationEndpointContext", "bindGetBucketNotificationConfigurationEndpointContext", "bindGetBucketOwnershipControlsEndpointContext", "bindGetBucketPolicyEndpointContext", "bindGetBucketPolicyStatusEndpointContext", "bindGetBucketReplicationEndpointContext", "bindGetBucketRequestPaymentEndpointContext", "bindGetBucketTaggingEndpointContext", "bindGetBucketVersioningEndpointContext", "bindGetBucketWebsiteEndpointContext", "bindGetObjectEndpointContext", "bindGetObjectAclEndpointContext", "bindGetObjectAttributesEndpointContext", "bindGetObjectLegalHoldEndpointContext", "bindGetObjectLockConfigurationEndpointContext", "bindGetObjectRetentionEndpointContext", "bindGetObjectTaggingEndpointContext", "bindGetObjectTorrentEndpointContext", "bindGetPublicAccessBlockEndpointContext", "bindHeadBucketEndpointContext", "bindHeadObjectEndpointContext", "bindListBucketAnalyticsConfigurationsEndpointContext", "bindListBucketIntelligentTieringConfigurationsEndpointContext", "bindListBucketInventoryConfigurationsEndpointContext", "bindListBucketMetricsConfigurationsEndpointContext", "bindListDirectoryBucketsEndpointContext", "bindListMultipartUploadsEndpointContext", "bindListObjectsEndpointContext", "bindListObjectsV2EndpointContext", "bindListObjectVersionsEndpointContext", "bindListPartsEndpointContext", "bindPutBucketAbacEndpointContext", "bindPutBucketAccelerateConfigurationEndpointContext", "bindPutBucketAclEndpointContext", "bindPutBucketAnalyticsConfigurationEndpointContext", "bindPutBucketCorsEndpointContext", "bindPutBucketEncryptionEndpointContext", "bindPutBucketIntelligentTieringConfigurationEndpointContext", "bindPutBucketInventoryConfigurationEndpointContext", "bindPutBucketLifecycleConfigurationEndpointContext", "bindPutBucketLoggingEndpointContext", "bindPutBucketMetricsConfigurationEndpointContext", "bindPutBucketNotificationConfigurationEndpointContext", "bindPutBucketOwnershipControlsEndpointContext", "bindPutBucketPolicyEndpointContext", "bindPutBucketReplicationEndpointContext", "bindPutBucketRequestPaymentEndpointContext", "bindPutBucketTaggingEndpointContext", "bindPutBucketVersioningEndpointContext", "bindPutBucketWebsiteEndpointContext", "bindPutObjectEndpointContext", "bindPutObjectAclEndpointContext", "bindPutObjectLegalHoldEndpointContext", "bindPutObjectLockConfigurationEndpointContext", "bindPutObjectRetentionEndpointContext", "bindPutObjectTaggingEndpointContext", "bindPutPublicAccessBlockEndpointContext", "bindRenameObjectEndpointContext", "bindRestoreObjectEndpointContext", "bindSelectObjectContentEndpointContext", "bindUpdateBucketMetadataInventoryTableConfigurationEndpointContext", "bindUpdateBucketMetadataJournalTableConfigurationEndpointContext", "bindUpdateObjectEncryptionEndpointContext", "bindUploadPartEndpointContext", "bindUploadPartCopyEndpointContext", "bindWriteGetObjectResponseEndpointContext", "bindAwsBuiltins", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EndpointResolverAdapterKt {
    private static final Map<String, Function2<S3EndpointParameters.Builder, ResolveEndpointRequest, Unit>> opContextBindings = MapsKt.mapOf(TuplesKt.m1606to("AbortMultipartUpload", EndpointResolverAdapterKt$opContextBindings$1.INSTANCE), TuplesKt.m1606to("CompleteMultipartUpload", EndpointResolverAdapterKt$opContextBindings$2.INSTANCE), TuplesKt.m1606to("CopyObject", EndpointResolverAdapterKt$opContextBindings$3.INSTANCE), TuplesKt.m1606to("CreateBucket", EndpointResolverAdapterKt$opContextBindings$4.INSTANCE), TuplesKt.m1606to("CreateBucketMetadataConfiguration", EndpointResolverAdapterKt$opContextBindings$5.INSTANCE), TuplesKt.m1606to("CreateBucketMetadataTableConfiguration", EndpointResolverAdapterKt$opContextBindings$6.INSTANCE), TuplesKt.m1606to("CreateMultipartUpload", EndpointResolverAdapterKt$opContextBindings$7.INSTANCE), TuplesKt.m1606to("CreateSession", EndpointResolverAdapterKt$opContextBindings$8.INSTANCE), TuplesKt.m1606to("DeleteBucket", EndpointResolverAdapterKt$opContextBindings$9.INSTANCE), TuplesKt.m1606to("DeleteBucketAnalyticsConfiguration", EndpointResolverAdapterKt$opContextBindings$10.INSTANCE), TuplesKt.m1606to("DeleteBucketCors", EndpointResolverAdapterKt$opContextBindings$11.INSTANCE), TuplesKt.m1606to("DeleteBucketEncryption", EndpointResolverAdapterKt$opContextBindings$12.INSTANCE), TuplesKt.m1606to("DeleteBucketIntelligentTieringConfiguration", EndpointResolverAdapterKt$opContextBindings$13.INSTANCE), TuplesKt.m1606to("DeleteBucketInventoryConfiguration", EndpointResolverAdapterKt$opContextBindings$14.INSTANCE), TuplesKt.m1606to("DeleteBucketLifecycle", EndpointResolverAdapterKt$opContextBindings$15.INSTANCE), TuplesKt.m1606to("DeleteBucketMetadataConfiguration", EndpointResolverAdapterKt$opContextBindings$16.INSTANCE), TuplesKt.m1606to("DeleteBucketMetadataTableConfiguration", EndpointResolverAdapterKt$opContextBindings$17.INSTANCE), TuplesKt.m1606to("DeleteBucketMetricsConfiguration", EndpointResolverAdapterKt$opContextBindings$18.INSTANCE), TuplesKt.m1606to("DeleteBucketOwnershipControls", EndpointResolverAdapterKt$opContextBindings$19.INSTANCE), TuplesKt.m1606to("DeleteBucketPolicy", EndpointResolverAdapterKt$opContextBindings$20.INSTANCE), TuplesKt.m1606to("DeleteBucketReplication", EndpointResolverAdapterKt$opContextBindings$21.INSTANCE), TuplesKt.m1606to("DeleteBucketTagging", EndpointResolverAdapterKt$opContextBindings$22.INSTANCE), TuplesKt.m1606to("DeleteBucketWebsite", EndpointResolverAdapterKt$opContextBindings$23.INSTANCE), TuplesKt.m1606to("DeleteObject", EndpointResolverAdapterKt$opContextBindings$24.INSTANCE), TuplesKt.m1606to("DeleteObjects", EndpointResolverAdapterKt$opContextBindings$25.INSTANCE), TuplesKt.m1606to("DeleteObjectTagging", EndpointResolverAdapterKt$opContextBindings$26.INSTANCE), TuplesKt.m1606to("DeletePublicAccessBlock", EndpointResolverAdapterKt$opContextBindings$27.INSTANCE), TuplesKt.m1606to("GetBucketAbac", EndpointResolverAdapterKt$opContextBindings$28.INSTANCE), TuplesKt.m1606to("GetBucketAccelerateConfiguration", EndpointResolverAdapterKt$opContextBindings$29.INSTANCE), TuplesKt.m1606to("GetBucketAcl", EndpointResolverAdapterKt$opContextBindings$30.INSTANCE), TuplesKt.m1606to("GetBucketAnalyticsConfiguration", EndpointResolverAdapterKt$opContextBindings$31.INSTANCE), TuplesKt.m1606to("GetBucketCors", EndpointResolverAdapterKt$opContextBindings$32.INSTANCE), TuplesKt.m1606to("GetBucketEncryption", EndpointResolverAdapterKt$opContextBindings$33.INSTANCE), TuplesKt.m1606to("GetBucketIntelligentTieringConfiguration", EndpointResolverAdapterKt$opContextBindings$34.INSTANCE), TuplesKt.m1606to("GetBucketInventoryConfiguration", EndpointResolverAdapterKt$opContextBindings$35.INSTANCE), TuplesKt.m1606to("GetBucketLifecycleConfiguration", EndpointResolverAdapterKt$opContextBindings$36.INSTANCE), TuplesKt.m1606to("GetBucketLocation", EndpointResolverAdapterKt$opContextBindings$37.INSTANCE), TuplesKt.m1606to("GetBucketLogging", EndpointResolverAdapterKt$opContextBindings$38.INSTANCE), TuplesKt.m1606to("GetBucketMetadataConfiguration", EndpointResolverAdapterKt$opContextBindings$39.INSTANCE), TuplesKt.m1606to("GetBucketMetadataTableConfiguration", EndpointResolverAdapterKt$opContextBindings$40.INSTANCE), TuplesKt.m1606to("GetBucketMetricsConfiguration", EndpointResolverAdapterKt$opContextBindings$41.INSTANCE), TuplesKt.m1606to("GetBucketNotificationConfiguration", EndpointResolverAdapterKt$opContextBindings$42.INSTANCE), TuplesKt.m1606to("GetBucketOwnershipControls", EndpointResolverAdapterKt$opContextBindings$43.INSTANCE), TuplesKt.m1606to("GetBucketPolicy", EndpointResolverAdapterKt$opContextBindings$44.INSTANCE), TuplesKt.m1606to("GetBucketPolicyStatus", EndpointResolverAdapterKt$opContextBindings$45.INSTANCE), TuplesKt.m1606to("GetBucketReplication", EndpointResolverAdapterKt$opContextBindings$46.INSTANCE), TuplesKt.m1606to("GetBucketRequestPayment", EndpointResolverAdapterKt$opContextBindings$47.INSTANCE), TuplesKt.m1606to("GetBucketTagging", EndpointResolverAdapterKt$opContextBindings$48.INSTANCE), TuplesKt.m1606to("GetBucketVersioning", EndpointResolverAdapterKt$opContextBindings$49.INSTANCE), TuplesKt.m1606to("GetBucketWebsite", EndpointResolverAdapterKt$opContextBindings$50.INSTANCE), TuplesKt.m1606to("GetObject", EndpointResolverAdapterKt$opContextBindings$51.INSTANCE), TuplesKt.m1606to("GetObjectAcl", EndpointResolverAdapterKt$opContextBindings$52.INSTANCE), TuplesKt.m1606to("GetObjectAttributes", EndpointResolverAdapterKt$opContextBindings$53.INSTANCE), TuplesKt.m1606to("GetObjectLegalHold", EndpointResolverAdapterKt$opContextBindings$54.INSTANCE), TuplesKt.m1606to("GetObjectLockConfiguration", EndpointResolverAdapterKt$opContextBindings$55.INSTANCE), TuplesKt.m1606to("GetObjectRetention", EndpointResolverAdapterKt$opContextBindings$56.INSTANCE), TuplesKt.m1606to("GetObjectTagging", EndpointResolverAdapterKt$opContextBindings$57.INSTANCE), TuplesKt.m1606to("GetObjectTorrent", EndpointResolverAdapterKt$opContextBindings$58.INSTANCE), TuplesKt.m1606to("GetPublicAccessBlock", EndpointResolverAdapterKt$opContextBindings$59.INSTANCE), TuplesKt.m1606to("HeadBucket", EndpointResolverAdapterKt$opContextBindings$60.INSTANCE), TuplesKt.m1606to("HeadObject", EndpointResolverAdapterKt$opContextBindings$61.INSTANCE), TuplesKt.m1606to("ListBucketAnalyticsConfigurations", EndpointResolverAdapterKt$opContextBindings$62.INSTANCE), TuplesKt.m1606to("ListBucketIntelligentTieringConfigurations", EndpointResolverAdapterKt$opContextBindings$63.INSTANCE), TuplesKt.m1606to("ListBucketInventoryConfigurations", EndpointResolverAdapterKt$opContextBindings$64.INSTANCE), TuplesKt.m1606to("ListBucketMetricsConfigurations", EndpointResolverAdapterKt$opContextBindings$65.INSTANCE), TuplesKt.m1606to("ListDirectoryBuckets", EndpointResolverAdapterKt$opContextBindings$66.INSTANCE), TuplesKt.m1606to("ListMultipartUploads", EndpointResolverAdapterKt$opContextBindings$67.INSTANCE), TuplesKt.m1606to("ListObjects", EndpointResolverAdapterKt$opContextBindings$68.INSTANCE), TuplesKt.m1606to("ListObjectsV2", EndpointResolverAdapterKt$opContextBindings$69.INSTANCE), TuplesKt.m1606to("ListObjectVersions", EndpointResolverAdapterKt$opContextBindings$70.INSTANCE), TuplesKt.m1606to("ListParts", EndpointResolverAdapterKt$opContextBindings$71.INSTANCE), TuplesKt.m1606to("PutBucketAbac", EndpointResolverAdapterKt$opContextBindings$72.INSTANCE), TuplesKt.m1606to("PutBucketAccelerateConfiguration", EndpointResolverAdapterKt$opContextBindings$73.INSTANCE), TuplesKt.m1606to("PutBucketAcl", EndpointResolverAdapterKt$opContextBindings$74.INSTANCE), TuplesKt.m1606to("PutBucketAnalyticsConfiguration", EndpointResolverAdapterKt$opContextBindings$75.INSTANCE), TuplesKt.m1606to("PutBucketCors", EndpointResolverAdapterKt$opContextBindings$76.INSTANCE), TuplesKt.m1606to("PutBucketEncryption", EndpointResolverAdapterKt$opContextBindings$77.INSTANCE), TuplesKt.m1606to("PutBucketIntelligentTieringConfiguration", EndpointResolverAdapterKt$opContextBindings$78.INSTANCE), TuplesKt.m1606to("PutBucketInventoryConfiguration", EndpointResolverAdapterKt$opContextBindings$79.INSTANCE), TuplesKt.m1606to("PutBucketLifecycleConfiguration", EndpointResolverAdapterKt$opContextBindings$80.INSTANCE), TuplesKt.m1606to("PutBucketLogging", EndpointResolverAdapterKt$opContextBindings$81.INSTANCE), TuplesKt.m1606to("PutBucketMetricsConfiguration", EndpointResolverAdapterKt$opContextBindings$82.INSTANCE), TuplesKt.m1606to("PutBucketNotificationConfiguration", EndpointResolverAdapterKt$opContextBindings$83.INSTANCE), TuplesKt.m1606to("PutBucketOwnershipControls", EndpointResolverAdapterKt$opContextBindings$84.INSTANCE), TuplesKt.m1606to("PutBucketPolicy", EndpointResolverAdapterKt$opContextBindings$85.INSTANCE), TuplesKt.m1606to("PutBucketReplication", EndpointResolverAdapterKt$opContextBindings$86.INSTANCE), TuplesKt.m1606to("PutBucketRequestPayment", EndpointResolverAdapterKt$opContextBindings$87.INSTANCE), TuplesKt.m1606to("PutBucketTagging", EndpointResolverAdapterKt$opContextBindings$88.INSTANCE), TuplesKt.m1606to("PutBucketVersioning", EndpointResolverAdapterKt$opContextBindings$89.INSTANCE), TuplesKt.m1606to("PutBucketWebsite", EndpointResolverAdapterKt$opContextBindings$90.INSTANCE), TuplesKt.m1606to("PutObject", EndpointResolverAdapterKt$opContextBindings$91.INSTANCE), TuplesKt.m1606to("PutObjectAcl", EndpointResolverAdapterKt$opContextBindings$92.INSTANCE), TuplesKt.m1606to("PutObjectLegalHold", EndpointResolverAdapterKt$opContextBindings$93.INSTANCE), TuplesKt.m1606to("PutObjectLockConfiguration", EndpointResolverAdapterKt$opContextBindings$94.INSTANCE), TuplesKt.m1606to("PutObjectRetention", EndpointResolverAdapterKt$opContextBindings$95.INSTANCE), TuplesKt.m1606to("PutObjectTagging", EndpointResolverAdapterKt$opContextBindings$96.INSTANCE), TuplesKt.m1606to("PutPublicAccessBlock", EndpointResolverAdapterKt$opContextBindings$97.INSTANCE), TuplesKt.m1606to("RenameObject", EndpointResolverAdapterKt$opContextBindings$98.INSTANCE), TuplesKt.m1606to("RestoreObject", EndpointResolverAdapterKt$opContextBindings$99.INSTANCE), TuplesKt.m1606to("SelectObjectContent", EndpointResolverAdapterKt$opContextBindings$100.INSTANCE), TuplesKt.m1606to("UpdateBucketMetadataInventoryTableConfiguration", EndpointResolverAdapterKt$opContextBindings$101.INSTANCE), TuplesKt.m1606to("UpdateBucketMetadataJournalTableConfiguration", EndpointResolverAdapterKt$opContextBindings$102.INSTANCE), TuplesKt.m1606to("UpdateObjectEncryption", EndpointResolverAdapterKt$opContextBindings$103.INSTANCE), TuplesKt.m1606to("UploadPart", EndpointResolverAdapterKt$opContextBindings$104.INSTANCE), TuplesKt.m1606to("UploadPartCopy", EndpointResolverAdapterKt$opContextBindings$105.INSTANCE), TuplesKt.m1606to("WriteGetObjectResponse", EndpointResolverAdapterKt$opContextBindings$106.INSTANCE));

    public static final S3EndpointParameters resolveEndpointParams(S3Client.Config config, ResolveEndpointRequest request) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(request, "request");
        S3EndpointParameters.Companion companion = S3EndpointParameters.INSTANCE;
        S3EndpointParameters.Builder builder = new S3EndpointParameters.Builder();
        builder.setRegion(config.getRegion());
        bindAwsBuiltins(builder, config, request);
        Url endpointUrl = config.getEndpointUrl();
        builder.setEndpoint(endpointUrl != null ? endpointUrl.getEncoded() : null);
        builder.setDisableS3ExpressSessionAuth(Boolean.valueOf(config.getDisableS3ExpressSessionAuth()));
        Function2<S3EndpointParameters.Builder, ResolveEndpointRequest, Unit> function2 = opContextBindings.get((String) AttributesKt.get(request.getContext(), SdkClientOption.INSTANCE.getOperationName()));
        if (function2 != null) {
            function2.invoke(builder, request);
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindAbortMultipartUploadEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.AbortMultipartUploadRequest");
        AbortMultipartUploadRequest abortMultipartUploadRequest = (AbortMultipartUploadRequest) obj;
        builder.setBucket(abortMultipartUploadRequest.getBucket());
        builder.setKey(abortMultipartUploadRequest.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindCompleteMultipartUploadEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.CompleteMultipartUploadRequest");
        CompleteMultipartUploadRequest completeMultipartUploadRequest = (CompleteMultipartUploadRequest) obj;
        builder.setBucket(completeMultipartUploadRequest.getBucket());
        builder.setKey(completeMultipartUploadRequest.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindCopyObjectEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.CopyObjectRequest");
        CopyObjectRequest copyObjectRequest = (CopyObjectRequest) obj;
        builder.setBucket(copyObjectRequest.getBucket());
        builder.setKey(copyObjectRequest.getKey());
        builder.setCopySource(copyObjectRequest.getCopySource());
        builder.setDisableS3ExpressSessionAuth(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindCreateBucketEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.CreateBucketRequest");
        builder.setBucket(((CreateBucketRequest) obj).getBucket());
        builder.setDisableAccessPoints(true);
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindCreateBucketMetadataConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.CreateBucketMetadataConfigurationRequest");
        builder.setBucket(((CreateBucketMetadataConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindCreateBucketMetadataTableConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.CreateBucketMetadataTableConfigurationRequest");
        builder.setBucket(((CreateBucketMetadataTableConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindCreateMultipartUploadEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.CreateMultipartUploadRequest");
        CreateMultipartUploadRequest createMultipartUploadRequest = (CreateMultipartUploadRequest) obj;
        builder.setBucket(createMultipartUploadRequest.getBucket());
        builder.setKey(createMultipartUploadRequest.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindCreateSessionEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.CreateSessionRequest");
        builder.setBucket(((CreateSessionRequest) obj).getBucket());
        builder.setDisableS3ExpressSessionAuth(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketRequest");
        builder.setBucket(((DeleteBucketRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketAnalyticsConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketAnalyticsConfigurationRequest");
        builder.setBucket(((DeleteBucketAnalyticsConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketCorsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketCorsRequest");
        builder.setBucket(((DeleteBucketCorsRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketEncryptionEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketEncryptionRequest");
        builder.setBucket(((DeleteBucketEncryptionRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketIntelligentTieringConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketIntelligentTieringConfigurationRequest");
        builder.setBucket(((DeleteBucketIntelligentTieringConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketInventoryConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketInventoryConfigurationRequest");
        builder.setBucket(((DeleteBucketInventoryConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketLifecycleEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketLifecycleRequest");
        builder.setBucket(((DeleteBucketLifecycleRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketMetadataConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketMetadataConfigurationRequest");
        builder.setBucket(((DeleteBucketMetadataConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketMetadataTableConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketMetadataTableConfigurationRequest");
        builder.setBucket(((DeleteBucketMetadataTableConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketMetricsConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketMetricsConfigurationRequest");
        builder.setBucket(((DeleteBucketMetricsConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketOwnershipControlsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketOwnershipControlsRequest");
        builder.setBucket(((DeleteBucketOwnershipControlsRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketPolicyEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketPolicyRequest");
        builder.setBucket(((DeleteBucketPolicyRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketReplicationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketReplicationRequest");
        builder.setBucket(((DeleteBucketReplicationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketTaggingEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketTaggingRequest");
        builder.setBucket(((DeleteBucketTaggingRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteBucketWebsiteEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteBucketWebsiteRequest");
        builder.setBucket(((DeleteBucketWebsiteRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteObjectEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteObjectRequest");
        DeleteObjectRequest deleteObjectRequest = (DeleteObjectRequest) obj;
        builder.setBucket(deleteObjectRequest.getBucket());
        builder.setKey(deleteObjectRequest.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteObjectsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteObjectsRequest");
        builder.setBucket(((DeleteObjectsRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeleteObjectTaggingEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeleteObjectTaggingRequest");
        builder.setBucket(((DeleteObjectTaggingRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindDeletePublicAccessBlockEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.DeletePublicAccessBlockRequest");
        builder.setBucket(((DeletePublicAccessBlockRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketAbacEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketAbacRequest");
        builder.setBucket(((GetBucketAbacRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketAccelerateConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketAccelerateConfigurationRequest");
        builder.setBucket(((GetBucketAccelerateConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketAclEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketAclRequest");
        builder.setBucket(((GetBucketAclRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketAnalyticsConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketAnalyticsConfigurationRequest");
        builder.setBucket(((GetBucketAnalyticsConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketCorsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketCorsRequest");
        builder.setBucket(((GetBucketCorsRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketEncryptionEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketEncryptionRequest");
        builder.setBucket(((GetBucketEncryptionRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketIntelligentTieringConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketIntelligentTieringConfigurationRequest");
        builder.setBucket(((GetBucketIntelligentTieringConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketInventoryConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketInventoryConfigurationRequest");
        builder.setBucket(((GetBucketInventoryConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketLifecycleConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketLifecycleConfigurationRequest");
        builder.setBucket(((GetBucketLifecycleConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketLocationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketLocationRequest");
        builder.setBucket(((GetBucketLocationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketLoggingEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketLoggingRequest");
        builder.setBucket(((GetBucketLoggingRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketMetadataConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketMetadataConfigurationRequest");
        builder.setBucket(((GetBucketMetadataConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketMetadataTableConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketMetadataTableConfigurationRequest");
        builder.setBucket(((GetBucketMetadataTableConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketMetricsConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketMetricsConfigurationRequest");
        builder.setBucket(((GetBucketMetricsConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketNotificationConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketNotificationConfigurationRequest");
        builder.setBucket(((GetBucketNotificationConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketOwnershipControlsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketOwnershipControlsRequest");
        builder.setBucket(((GetBucketOwnershipControlsRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketPolicyEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketPolicyRequest");
        builder.setBucket(((GetBucketPolicyRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketPolicyStatusEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketPolicyStatusRequest");
        builder.setBucket(((GetBucketPolicyStatusRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketReplicationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketReplicationRequest");
        builder.setBucket(((GetBucketReplicationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketRequestPaymentEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketRequestPaymentRequest");
        builder.setBucket(((GetBucketRequestPaymentRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketTaggingEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketTaggingRequest");
        builder.setBucket(((GetBucketTaggingRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketVersioningEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketVersioningRequest");
        builder.setBucket(((GetBucketVersioningRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetBucketWebsiteEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetBucketWebsiteRequest");
        builder.setBucket(((GetBucketWebsiteRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetObjectEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetObjectRequest");
        GetObjectRequest getObjectRequest = (GetObjectRequest) obj;
        builder.setBucket(getObjectRequest.getBucket());
        builder.setKey(getObjectRequest.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetObjectAclEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetObjectAclRequest");
        GetObjectAclRequest getObjectAclRequest = (GetObjectAclRequest) obj;
        builder.setBucket(getObjectAclRequest.getBucket());
        builder.setKey(getObjectAclRequest.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetObjectAttributesEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetObjectAttributesRequest");
        builder.setBucket(((GetObjectAttributesRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetObjectLegalHoldEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetObjectLegalHoldRequest");
        builder.setBucket(((GetObjectLegalHoldRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetObjectLockConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetObjectLockConfigurationRequest");
        builder.setBucket(((GetObjectLockConfigurationRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetObjectRetentionEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetObjectRetentionRequest");
        builder.setBucket(((GetObjectRetentionRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetObjectTaggingEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetObjectTaggingRequest");
        builder.setBucket(((GetObjectTaggingRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetObjectTorrentEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetObjectTorrentRequest");
        builder.setBucket(((GetObjectTorrentRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGetPublicAccessBlockEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.GetPublicAccessBlockRequest");
        builder.setBucket(((GetPublicAccessBlockRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindHeadBucketEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.HeadBucketRequest");
        builder.setBucket(((HeadBucketRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindHeadObjectEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.HeadObjectRequest");
        HeadObjectRequest headObjectRequest = (HeadObjectRequest) obj;
        builder.setBucket(headObjectRequest.getBucket());
        builder.setKey(headObjectRequest.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindListBucketAnalyticsConfigurationsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.ListBucketAnalyticsConfigurationsRequest");
        builder.setBucket(((ListBucketAnalyticsConfigurationsRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindListBucketIntelligentTieringConfigurationsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.ListBucketIntelligentTieringConfigurationsRequest");
        builder.setBucket(((ListBucketIntelligentTieringConfigurationsRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindListBucketInventoryConfigurationsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.ListBucketInventoryConfigurationsRequest");
        builder.setBucket(((ListBucketInventoryConfigurationsRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindListBucketMetricsConfigurationsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.ListBucketMetricsConfigurationsRequest");
        builder.setBucket(((ListBucketMetricsConfigurationsRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindListDirectoryBucketsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindListMultipartUploadsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.ListMultipartUploadsRequest");
        ListMultipartUploadsRequest listMultipartUploadsRequest = (ListMultipartUploadsRequest) obj;
        builder.setBucket(listMultipartUploadsRequest.getBucket());
        builder.setPrefix(listMultipartUploadsRequest.getPrefix());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindListObjectsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.ListObjectsRequest");
        ListObjectsRequest listObjectsRequest = (ListObjectsRequest) obj;
        builder.setBucket(listObjectsRequest.getBucket());
        builder.setPrefix(listObjectsRequest.getPrefix());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindListObjectsV2EndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.ListObjectsV2Request");
        ListObjectsV2Request listObjectsV2Request = (ListObjectsV2Request) obj;
        builder.setBucket(listObjectsV2Request.getBucket());
        builder.setPrefix(listObjectsV2Request.getPrefix());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindListObjectVersionsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.ListObjectVersionsRequest");
        ListObjectVersionsRequest listObjectVersionsRequest = (ListObjectVersionsRequest) obj;
        builder.setBucket(listObjectVersionsRequest.getBucket());
        builder.setPrefix(listObjectVersionsRequest.getPrefix());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindListPartsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.ListPartsRequest");
        ListPartsRequest listPartsRequest = (ListPartsRequest) obj;
        builder.setBucket(listPartsRequest.getBucket());
        builder.setKey(listPartsRequest.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketAbacEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketAbacRequest");
        builder.setBucket(((PutBucketAbacRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketAccelerateConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketAccelerateConfigurationRequest");
        builder.setBucket(((PutBucketAccelerateConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketAclEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketAclRequest");
        builder.setBucket(((PutBucketAclRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketAnalyticsConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketAnalyticsConfigurationRequest");
        builder.setBucket(((PutBucketAnalyticsConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketCorsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketCorsRequest");
        builder.setBucket(((PutBucketCorsRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketEncryptionEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketEncryptionRequest");
        builder.setBucket(((PutBucketEncryptionRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketIntelligentTieringConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketIntelligentTieringConfigurationRequest");
        builder.setBucket(((PutBucketIntelligentTieringConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketInventoryConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketInventoryConfigurationRequest");
        builder.setBucket(((PutBucketInventoryConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketLifecycleConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketLifecycleConfigurationRequest");
        builder.setBucket(((PutBucketLifecycleConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketLoggingEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketLoggingRequest");
        builder.setBucket(((PutBucketLoggingRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketMetricsConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketMetricsConfigurationRequest");
        builder.setBucket(((PutBucketMetricsConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketNotificationConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketNotificationConfigurationRequest");
        builder.setBucket(((PutBucketNotificationConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketOwnershipControlsEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketOwnershipControlsRequest");
        builder.setBucket(((PutBucketOwnershipControlsRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketPolicyEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketPolicyRequest");
        builder.setBucket(((PutBucketPolicyRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketReplicationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketReplicationRequest");
        builder.setBucket(((PutBucketReplicationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketRequestPaymentEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketRequestPaymentRequest");
        builder.setBucket(((PutBucketRequestPaymentRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketTaggingEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketTaggingRequest");
        builder.setBucket(((PutBucketTaggingRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketVersioningEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketVersioningRequest");
        builder.setBucket(((PutBucketVersioningRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutBucketWebsiteEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutBucketWebsiteRequest");
        builder.setBucket(((PutBucketWebsiteRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutObjectEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutObjectRequest");
        PutObjectRequest putObjectRequest = (PutObjectRequest) obj;
        builder.setBucket(putObjectRequest.getBucket());
        builder.setKey(putObjectRequest.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutObjectAclEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutObjectAclRequest");
        PutObjectAclRequest putObjectAclRequest = (PutObjectAclRequest) obj;
        builder.setBucket(putObjectAclRequest.getBucket());
        builder.setKey(putObjectAclRequest.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutObjectLegalHoldEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutObjectLegalHoldRequest");
        builder.setBucket(((PutObjectLegalHoldRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutObjectLockConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutObjectLockConfigurationRequest");
        builder.setBucket(((PutObjectLockConfigurationRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutObjectRetentionEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutObjectRetentionRequest");
        builder.setBucket(((PutObjectRetentionRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutObjectTaggingEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutObjectTaggingRequest");
        builder.setBucket(((PutObjectTaggingRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPutPublicAccessBlockEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.PutPublicAccessBlockRequest");
        builder.setBucket(((PutPublicAccessBlockRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindRenameObjectEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.RenameObjectRequest");
        RenameObjectRequest renameObjectRequest = (RenameObjectRequest) obj;
        builder.setBucket(renameObjectRequest.getBucket());
        builder.setKey(renameObjectRequest.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindRestoreObjectEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.RestoreObjectRequest");
        builder.setBucket(((RestoreObjectRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindSelectObjectContentEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.SelectObjectContentRequest");
        builder.setBucket(((SelectObjectContentRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: bindUpdateBucketMetadataInventoryTableConfigurationEndpointContext */
    public static final void m353xf7ed5d15(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.UpdateBucketMetadataInventoryTableConfigurationRequest");
        builder.setBucket(((UpdateBucketMetadataInventoryTableConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindUpdateBucketMetadataJournalTableConfigurationEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.UpdateBucketMetadataJournalTableConfigurationRequest");
        builder.setBucket(((UpdateBucketMetadataJournalTableConfigurationRequest) obj).getBucket());
        builder.setUseS3ExpressControlEndpoint(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindUpdateObjectEncryptionEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.UpdateObjectEncryptionRequest");
        builder.setBucket(((UpdateObjectEncryptionRequest) obj).getBucket());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindUploadPartEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.UploadPartRequest");
        UploadPartRequest uploadPartRequest = (UploadPartRequest) obj;
        builder.setBucket(uploadPartRequest.getBucket());
        builder.setKey(uploadPartRequest.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindUploadPartCopyEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        Object obj = AttributesKt.get(resolveEndpointRequest.getContext(), HttpOperationContext.INSTANCE.getOperationInput());
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.UploadPartCopyRequest");
        builder.setBucket(((UploadPartCopyRequest) obj).getBucket());
        builder.setDisableS3ExpressSessionAuth(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindWriteGetObjectResponseEndpointContext(S3EndpointParameters.Builder builder, ResolveEndpointRequest resolveEndpointRequest) {
        builder.setUseObjectLambdaEndpoint(true);
    }

    private static final void bindAwsBuiltins(S3EndpointParameters.Builder builder, S3Client.Config config, ResolveEndpointRequest resolveEndpointRequest) {
        builder.setUseFips(Boolean.valueOf(config.getUseFips()));
        builder.setUseDualStack(Boolean.valueOf(config.getUseDualStack()));
        builder.setForcePathStyle(Boolean.valueOf(config.getForcePathStyle()));
        builder.setAccelerate(Boolean.valueOf(config.getEnableAccelerate()));
        builder.setUseGlobalEndpoint(false);
        builder.setDisableMultiRegionAccessPoints(Boolean.valueOf(config.getDisableMrap()));
        builder.setUseArnRegion(Boolean.valueOf(config.getUseArnRegion()));
    }
}

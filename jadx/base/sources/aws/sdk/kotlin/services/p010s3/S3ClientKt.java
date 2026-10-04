package aws.sdk.kotlin.services.p010s3;

import aws.sdk.kotlin.services.p010s3.S3Client;
import aws.sdk.kotlin.services.p010s3.model.AbortMultipartUploadRequest;
import aws.sdk.kotlin.services.p010s3.model.AbortMultipartUploadResponse;
import aws.sdk.kotlin.services.p010s3.model.CompleteMultipartUploadRequest;
import aws.sdk.kotlin.services.p010s3.model.CompleteMultipartUploadResponse;
import aws.sdk.kotlin.services.p010s3.model.CopyObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.CopyObjectResponse;
import aws.sdk.kotlin.services.p010s3.model.CreateBucketMetadataConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.CreateBucketMetadataConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.CreateBucketMetadataTableConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.CreateBucketMetadataTableConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.CreateBucketRequest;
import aws.sdk.kotlin.services.p010s3.model.CreateBucketResponse;
import aws.sdk.kotlin.services.p010s3.model.CreateMultipartUploadRequest;
import aws.sdk.kotlin.services.p010s3.model.CreateMultipartUploadResponse;
import aws.sdk.kotlin.services.p010s3.model.CreateSessionRequest;
import aws.sdk.kotlin.services.p010s3.model.CreateSessionResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketAnalyticsConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketAnalyticsConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketCorsRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketCorsResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketEncryptionRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketEncryptionResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketIntelligentTieringConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketIntelligentTieringConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketInventoryConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketInventoryConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketLifecycleRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketLifecycleResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketMetadataConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketMetadataConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketMetadataTableConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketMetadataTableConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketMetricsConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketMetricsConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketOwnershipControlsRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketOwnershipControlsResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketPolicyRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketPolicyResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketReplicationRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketReplicationResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketTaggingRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketTaggingResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketWebsiteRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteBucketWebsiteResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteObjectResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteObjectTaggingRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteObjectTaggingResponse;
import aws.sdk.kotlin.services.p010s3.model.DeleteObjectsRequest;
import aws.sdk.kotlin.services.p010s3.model.DeleteObjectsResponse;
import aws.sdk.kotlin.services.p010s3.model.DeletePublicAccessBlockRequest;
import aws.sdk.kotlin.services.p010s3.model.DeletePublicAccessBlockResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketAbacRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketAbacResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketAccelerateConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketAccelerateConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketAclRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketAclResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketAnalyticsConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketAnalyticsConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketCorsRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketCorsResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketEncryptionRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketEncryptionResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketIntelligentTieringConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketIntelligentTieringConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketInventoryConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketInventoryConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketLifecycleConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketLifecycleConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketLocationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketLocationResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketLoggingRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketLoggingResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketMetadataConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketMetadataConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketMetadataTableConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketMetadataTableConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketMetricsConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketMetricsConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketNotificationConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketNotificationConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketOwnershipControlsRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketOwnershipControlsResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketPolicyRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketPolicyResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketPolicyStatusRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketPolicyStatusResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketReplicationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketReplicationResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketRequestPaymentRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketRequestPaymentResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketTaggingRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketTaggingResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketVersioningRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketVersioningResponse;
import aws.sdk.kotlin.services.p010s3.model.GetBucketWebsiteRequest;
import aws.sdk.kotlin.services.p010s3.model.GetBucketWebsiteResponse;
import aws.sdk.kotlin.services.p010s3.model.GetObjectAclRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectAclResponse;
import aws.sdk.kotlin.services.p010s3.model.GetObjectAttributesRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectAttributesResponse;
import aws.sdk.kotlin.services.p010s3.model.GetObjectLegalHoldRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectLegalHoldResponse;
import aws.sdk.kotlin.services.p010s3.model.GetObjectLockConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectLockConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.GetObjectRetentionRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectRetentionResponse;
import aws.sdk.kotlin.services.p010s3.model.GetObjectTaggingRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectTaggingResponse;
import aws.sdk.kotlin.services.p010s3.model.GetPublicAccessBlockRequest;
import aws.sdk.kotlin.services.p010s3.model.GetPublicAccessBlockResponse;
import aws.sdk.kotlin.services.p010s3.model.HeadBucketRequest;
import aws.sdk.kotlin.services.p010s3.model.HeadBucketResponse;
import aws.sdk.kotlin.services.p010s3.model.HeadObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.HeadObjectResponse;
import aws.sdk.kotlin.services.p010s3.model.ListBucketAnalyticsConfigurationsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListBucketAnalyticsConfigurationsResponse;
import aws.sdk.kotlin.services.p010s3.model.ListBucketIntelligentTieringConfigurationsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListBucketIntelligentTieringConfigurationsResponse;
import aws.sdk.kotlin.services.p010s3.model.ListBucketInventoryConfigurationsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListBucketInventoryConfigurationsResponse;
import aws.sdk.kotlin.services.p010s3.model.ListBucketMetricsConfigurationsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListBucketMetricsConfigurationsResponse;
import aws.sdk.kotlin.services.p010s3.model.ListBucketsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListBucketsResponse;
import aws.sdk.kotlin.services.p010s3.model.ListDirectoryBucketsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListDirectoryBucketsResponse;
import aws.sdk.kotlin.services.p010s3.model.ListMultipartUploadsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListMultipartUploadsResponse;
import aws.sdk.kotlin.services.p010s3.model.ListObjectVersionsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListObjectVersionsResponse;
import aws.sdk.kotlin.services.p010s3.model.ListObjectsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListObjectsResponse;
import aws.sdk.kotlin.services.p010s3.model.ListObjectsV2Request;
import aws.sdk.kotlin.services.p010s3.model.ListObjectsV2Response;
import aws.sdk.kotlin.services.p010s3.model.ListPartsRequest;
import aws.sdk.kotlin.services.p010s3.model.ListPartsResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketAbacRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketAbacResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketAccelerateConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketAccelerateConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketAclRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketAclResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketAnalyticsConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketAnalyticsConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketCorsRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketCorsResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketEncryptionRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketEncryptionResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketIntelligentTieringConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketIntelligentTieringConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketInventoryConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketInventoryConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketLifecycleConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketLifecycleConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketLoggingRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketLoggingResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketMetricsConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketMetricsConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketNotificationConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketNotificationConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketOwnershipControlsRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketOwnershipControlsResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketPolicyRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketPolicyResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketReplicationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketReplicationResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketRequestPaymentRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketRequestPaymentResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketTaggingRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketTaggingResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketVersioningRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketVersioningResponse;
import aws.sdk.kotlin.services.p010s3.model.PutBucketWebsiteRequest;
import aws.sdk.kotlin.services.p010s3.model.PutBucketWebsiteResponse;
import aws.sdk.kotlin.services.p010s3.model.PutObjectAclRequest;
import aws.sdk.kotlin.services.p010s3.model.PutObjectAclResponse;
import aws.sdk.kotlin.services.p010s3.model.PutObjectLegalHoldRequest;
import aws.sdk.kotlin.services.p010s3.model.PutObjectLegalHoldResponse;
import aws.sdk.kotlin.services.p010s3.model.PutObjectLockConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.PutObjectLockConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.PutObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.PutObjectResponse;
import aws.sdk.kotlin.services.p010s3.model.PutObjectRetentionRequest;
import aws.sdk.kotlin.services.p010s3.model.PutObjectRetentionResponse;
import aws.sdk.kotlin.services.p010s3.model.PutObjectTaggingRequest;
import aws.sdk.kotlin.services.p010s3.model.PutObjectTaggingResponse;
import aws.sdk.kotlin.services.p010s3.model.PutPublicAccessBlockRequest;
import aws.sdk.kotlin.services.p010s3.model.PutPublicAccessBlockResponse;
import aws.sdk.kotlin.services.p010s3.model.RenameObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.RenameObjectResponse;
import aws.sdk.kotlin.services.p010s3.model.RestoreObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.RestoreObjectResponse;
import aws.sdk.kotlin.services.p010s3.model.UpdateBucketMetadataInventoryTableConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.UpdateBucketMetadataInventoryTableConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.UpdateBucketMetadataJournalTableConfigurationRequest;
import aws.sdk.kotlin.services.p010s3.model.UpdateBucketMetadataJournalTableConfigurationResponse;
import aws.sdk.kotlin.services.p010s3.model.UpdateObjectEncryptionRequest;
import aws.sdk.kotlin.services.p010s3.model.UpdateObjectEncryptionResponse;
import aws.sdk.kotlin.services.p010s3.model.UploadPartCopyRequest;
import aws.sdk.kotlin.services.p010s3.model.UploadPartCopyResponse;
import aws.sdk.kotlin.services.p010s3.model.UploadPartRequest;
import aws.sdk.kotlin.services.p010s3.model.UploadPartResponse;
import aws.sdk.kotlin.services.p010s3.model.WriteGetObjectResponseRequest;
import aws.sdk.kotlin.services.p010s3.model.WriteGetObjectResponseResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: S3Client.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000´\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u001a-\u0010\u000b\u001a\u00020\f*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010\u000f\u001a\u00020\u0010*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010\u0012\u001a\u00020\u0013*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010\u0015\u001a\u00020\u0016*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010\u0018\u001a\u00020\u0019*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010\u001b\u001a\u00020\u001c*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010\u001e\u001a\u00020\u001f*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010!\u001a\u00020\"*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010$\u001a\u00020%*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010'\u001a\u00020(*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010*\u001a\u00020+*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010-\u001a\u00020.*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u00100\u001a\u000201*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u00103\u001a\u000204*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u00106\u001a\u000207*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u00109\u001a\u00020:*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010<\u001a\u00020=*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010?\u001a\u00020@*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010B\u001a\u00020C*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010E\u001a\u00020F*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010H\u001a\u00020I*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010K\u001a\u00020L*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010N\u001a\u00020O*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010Q\u001a\u00020R*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010T\u001a\u00020U*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010W\u001a\u00020X*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010Z\u001a\u00020[*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010]\u001a\u00020^*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010`\u001a\u00020a*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010c\u001a\u00020d*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010f\u001a\u00020g*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010i\u001a\u00020j*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010l\u001a\u00020m*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010o\u001a\u00020p*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010r\u001a\u00020s*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010u\u001a\u00020v*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010x\u001a\u00020y*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a-\u0010{\u001a\u00020|*\u00020\u00052\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a.\u0010~\u001a\u00020\u007f*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0081\u0001\u001a\u00030\u0082\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0084\u0001\u001a\u00030\u0085\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0086\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0087\u0001\u001a\u00030\u0088\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0089\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u008a\u0001\u001a\u00030\u008b\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u008c\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u008d\u0001\u001a\u00030\u008e\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u008f\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0090\u0001\u001a\u00030\u0091\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0092\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0093\u0001\u001a\u00030\u0094\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0095\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0096\u0001\u001a\u00030\u0097\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0098\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0099\u0001\u001a\u00030\u009a\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u009b\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u009c\u0001\u001a\u00030\u009d\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u009e\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u009f\u0001\u001a\u00030 \u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030¡\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010¢\u0001\u001a\u00030£\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030¤\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010¥\u0001\u001a\u00030¦\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030§\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010¨\u0001\u001a\u00030©\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030ª\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010«\u0001\u001a\u00030¬\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u00ad\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010®\u0001\u001a\u00030¯\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030°\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010±\u0001\u001a\u00030²\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030³\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010´\u0001\u001a\u00030µ\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030¶\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010·\u0001\u001a\u00030¸\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030¹\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010º\u0001\u001a\u00030»\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030¼\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010½\u0001\u001a\u00030¾\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030¿\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010À\u0001\u001a\u00030Á\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030Â\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010Ã\u0001\u001a\u00030Ä\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030Å\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010Æ\u0001\u001a\u00030Ç\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030È\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010É\u0001\u001a\u00030Ê\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030Ë\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010Ì\u0001\u001a\u00030Í\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030Î\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010Ï\u0001\u001a\u00030Ð\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030Ñ\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010Ò\u0001\u001a\u00030Ó\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030Ô\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010Õ\u0001\u001a\u00030Ö\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030×\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010Ø\u0001\u001a\u00030Ù\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030Ú\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010Û\u0001\u001a\u00030Ü\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030Ý\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010Þ\u0001\u001a\u00030ß\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030à\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010á\u0001\u001a\u00030â\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030ã\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010ä\u0001\u001a\u00030å\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030æ\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010ç\u0001\u001a\u00030è\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030é\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010ê\u0001\u001a\u00030ë\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030ì\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010í\u0001\u001a\u00030î\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030ï\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010ð\u0001\u001a\u00030ñ\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030ò\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010ó\u0001\u001a\u00030ô\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030õ\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010ö\u0001\u001a\u00030÷\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030ø\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010ù\u0001\u001a\u00030ú\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030û\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010ü\u0001\u001a\u00030ý\u0001*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030þ\u0001\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010ÿ\u0001\u001a\u00030\u0080\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0081\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0082\u0002\u001a\u00030\u0083\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0084\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0085\u0002\u001a\u00030\u0086\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0087\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0088\u0002\u001a\u00030\u0089\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u008a\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u008b\u0002\u001a\u00030\u008c\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u008d\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u008e\u0002\u001a\u00030\u008f\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0090\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0091\u0002\u001a\u00030\u0092\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0093\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0094\u0002\u001a\u00030\u0095\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0096\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u0097\u0002\u001a\u00030\u0098\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u0099\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u009a\u0002\u001a\u00030\u009b\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u009c\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010\u009d\u0002\u001a\u00030\u009e\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030\u009f\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010 \u0002\u001a\u00030¡\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030¢\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010£\u0002\u001a\u00030¤\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030¥\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010¦\u0002\u001a\u00030§\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030¨\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010©\u0002\u001a\u00030ª\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030«\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010¬\u0002\u001a\u00030\u00ad\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030®\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010¯\u0002\u001a\u00030°\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030±\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010²\u0002\u001a\u00030³\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030´\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010µ\u0002\u001a\u00030¶\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030·\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010¸\u0002\u001a\u00030¹\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030º\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010»\u0002\u001a\u00030¼\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030½\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010¾\u0002\u001a\u00030¿\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030À\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\u001a0\u0010Á\u0002\u001a\u00030Â\u0002*\u00020\u00052\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0005\u0012\u00030Ã\u0002\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086H¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006Ä\u0002"}, m1599d2 = {"ServiceId", "", "SdkVersion", "ServiceApiVersion", "withConfig", "Laws/sdk/kotlin/services/s3/S3Client;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/S3Client$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "abortMultipartUpload", "Laws/sdk/kotlin/services/s3/model/AbortMultipartUploadResponse;", "Laws/sdk/kotlin/services/s3/model/AbortMultipartUploadRequest$Builder;", "(Laws/sdk/kotlin/services/s3/S3Client;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeMultipartUpload", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadResponse;", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest$Builder;", "copyObject", "Laws/sdk/kotlin/services/s3/model/CopyObjectResponse;", "Laws/sdk/kotlin/services/s3/model/CopyObjectRequest$Builder;", "createBucket", "Laws/sdk/kotlin/services/s3/model/CreateBucketResponse;", "Laws/sdk/kotlin/services/s3/model/CreateBucketRequest$Builder;", "createBucketMetadataConfiguration", "Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataConfigurationRequest$Builder;", "createBucketMetadataTableConfiguration", "Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataTableConfigurationRequest$Builder;", "createMultipartUpload", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadResponse;", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest$Builder;", "createSession", "Laws/sdk/kotlin/services/s3/model/CreateSessionResponse;", "Laws/sdk/kotlin/services/s3/model/CreateSessionRequest$Builder;", "deleteBucket", "Laws/sdk/kotlin/services/s3/model/DeleteBucketResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketRequest$Builder;", "deleteBucketAnalyticsConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketAnalyticsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketAnalyticsConfigurationRequest$Builder;", "deleteBucketCors", "Laws/sdk/kotlin/services/s3/model/DeleteBucketCorsResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketCorsRequest$Builder;", "deleteBucketEncryption", "Laws/sdk/kotlin/services/s3/model/DeleteBucketEncryptionResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketEncryptionRequest$Builder;", "deleteBucketIntelligentTieringConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketIntelligentTieringConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketIntelligentTieringConfigurationRequest$Builder;", "deleteBucketInventoryConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketInventoryConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketInventoryConfigurationRequest$Builder;", "deleteBucketLifecycle", "Laws/sdk/kotlin/services/s3/model/DeleteBucketLifecycleResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketLifecycleRequest$Builder;", "deleteBucketMetadataConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataConfigurationRequest$Builder;", "deleteBucketMetadataTableConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataTableConfigurationRequest$Builder;", "deleteBucketMetricsConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetricsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetricsConfigurationRequest$Builder;", "deleteBucketOwnershipControls", "Laws/sdk/kotlin/services/s3/model/DeleteBucketOwnershipControlsResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketOwnershipControlsRequest$Builder;", "deleteBucketPolicy", "Laws/sdk/kotlin/services/s3/model/DeleteBucketPolicyResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketPolicyRequest$Builder;", "deleteBucketReplication", "Laws/sdk/kotlin/services/s3/model/DeleteBucketReplicationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketReplicationRequest$Builder;", "deleteBucketTagging", "Laws/sdk/kotlin/services/s3/model/DeleteBucketTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketTaggingRequest$Builder;", "deleteBucketWebsite", "Laws/sdk/kotlin/services/s3/model/DeleteBucketWebsiteResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketWebsiteRequest$Builder;", "deleteObject", "Laws/sdk/kotlin/services/s3/model/DeleteObjectResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest$Builder;", "deleteObjectTagging", "Laws/sdk/kotlin/services/s3/model/DeleteObjectTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteObjectTaggingRequest$Builder;", "deleteObjects", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest$Builder;", "deletePublicAccessBlock", "Laws/sdk/kotlin/services/s3/model/DeletePublicAccessBlockResponse;", "Laws/sdk/kotlin/services/s3/model/DeletePublicAccessBlockRequest$Builder;", "getBucketAbac", "Laws/sdk/kotlin/services/s3/model/GetBucketAbacResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketAbacRequest$Builder;", "getBucketAccelerateConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketAccelerateConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketAccelerateConfigurationRequest$Builder;", "getBucketAcl", "Laws/sdk/kotlin/services/s3/model/GetBucketAclResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketAclRequest$Builder;", "getBucketAnalyticsConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketAnalyticsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketAnalyticsConfigurationRequest$Builder;", "getBucketCors", "Laws/sdk/kotlin/services/s3/model/GetBucketCorsResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketCorsRequest$Builder;", "getBucketEncryption", "Laws/sdk/kotlin/services/s3/model/GetBucketEncryptionResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketEncryptionRequest$Builder;", "getBucketIntelligentTieringConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationRequest$Builder;", "getBucketInventoryConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketInventoryConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketInventoryConfigurationRequest$Builder;", "getBucketLifecycleConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationRequest$Builder;", "getBucketLocation", "Laws/sdk/kotlin/services/s3/model/GetBucketLocationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketLocationRequest$Builder;", "getBucketLogging", "Laws/sdk/kotlin/services/s3/model/GetBucketLoggingResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketLoggingRequest$Builder;", "getBucketMetadataConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataConfigurationRequest$Builder;", "getBucketMetadataTableConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationRequest$Builder;", "getBucketMetricsConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketMetricsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketMetricsConfigurationRequest$Builder;", "getBucketNotificationConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationRequest$Builder;", "getBucketOwnershipControls", "Laws/sdk/kotlin/services/s3/model/GetBucketOwnershipControlsResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketOwnershipControlsRequest$Builder;", "getBucketPolicy", "Laws/sdk/kotlin/services/s3/model/GetBucketPolicyResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketPolicyRequest$Builder;", "getBucketPolicyStatus", "Laws/sdk/kotlin/services/s3/model/GetBucketPolicyStatusResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketPolicyStatusRequest$Builder;", "getBucketReplication", "Laws/sdk/kotlin/services/s3/model/GetBucketReplicationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketReplicationRequest$Builder;", "getBucketRequestPayment", "Laws/sdk/kotlin/services/s3/model/GetBucketRequestPaymentResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketRequestPaymentRequest$Builder;", "getBucketTagging", "Laws/sdk/kotlin/services/s3/model/GetBucketTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketTaggingRequest$Builder;", "getBucketVersioning", "Laws/sdk/kotlin/services/s3/model/GetBucketVersioningResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketVersioningRequest$Builder;", "getBucketWebsite", "Laws/sdk/kotlin/services/s3/model/GetBucketWebsiteResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketWebsiteRequest$Builder;", "getObjectAcl", "Laws/sdk/kotlin/services/s3/model/GetObjectAclResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectAclRequest$Builder;", "getObjectAttributes", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesRequest$Builder;", "getObjectLegalHold", "Laws/sdk/kotlin/services/s3/model/GetObjectLegalHoldResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectLegalHoldRequest$Builder;", "getObjectLockConfiguration", "Laws/sdk/kotlin/services/s3/model/GetObjectLockConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectLockConfigurationRequest$Builder;", "getObjectRetention", "Laws/sdk/kotlin/services/s3/model/GetObjectRetentionResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectRetentionRequest$Builder;", "getObjectTagging", "Laws/sdk/kotlin/services/s3/model/GetObjectTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectTaggingRequest$Builder;", "getPublicAccessBlock", "Laws/sdk/kotlin/services/s3/model/GetPublicAccessBlockResponse;", "Laws/sdk/kotlin/services/s3/model/GetPublicAccessBlockRequest$Builder;", "headBucket", "Laws/sdk/kotlin/services/s3/model/HeadBucketResponse;", "Laws/sdk/kotlin/services/s3/model/HeadBucketRequest$Builder;", "headObject", "Laws/sdk/kotlin/services/s3/model/HeadObjectResponse;", "Laws/sdk/kotlin/services/s3/model/HeadObjectRequest$Builder;", "listBucketAnalyticsConfigurations", "Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsRequest$Builder;", "listBucketIntelligentTieringConfigurations", "Laws/sdk/kotlin/services/s3/model/ListBucketIntelligentTieringConfigurationsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketIntelligentTieringConfigurationsRequest$Builder;", "listBucketInventoryConfigurations", "Laws/sdk/kotlin/services/s3/model/ListBucketInventoryConfigurationsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketInventoryConfigurationsRequest$Builder;", "listBucketMetricsConfigurations", "Laws/sdk/kotlin/services/s3/model/ListBucketMetricsConfigurationsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketMetricsConfigurationsRequest$Builder;", "listBuckets", "Laws/sdk/kotlin/services/s3/model/ListBucketsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketsRequest$Builder;", "listDirectoryBuckets", "Laws/sdk/kotlin/services/s3/model/ListDirectoryBucketsResponse;", "Laws/sdk/kotlin/services/s3/model/ListDirectoryBucketsRequest$Builder;", "listMultipartUploads", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsResponse;", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest$Builder;", "listObjectVersions", "Laws/sdk/kotlin/services/s3/model/ListObjectVersionsResponse;", "Laws/sdk/kotlin/services/s3/model/ListObjectVersionsRequest$Builder;", "listObjects", "Laws/sdk/kotlin/services/s3/model/ListObjectsResponse;", "Laws/sdk/kotlin/services/s3/model/ListObjectsRequest$Builder;", "listObjectsV2", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Response;", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request$Builder;", "listParts", "Laws/sdk/kotlin/services/s3/model/ListPartsResponse;", "Laws/sdk/kotlin/services/s3/model/ListPartsRequest$Builder;", "putBucketAbac", "Laws/sdk/kotlin/services/s3/model/PutBucketAbacResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketAbacRequest$Builder;", "putBucketAccelerateConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketAccelerateConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketAccelerateConfigurationRequest$Builder;", "putBucketAcl", "Laws/sdk/kotlin/services/s3/model/PutBucketAclResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest$Builder;", "putBucketAnalyticsConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest$Builder;", "putBucketCors", "Laws/sdk/kotlin/services/s3/model/PutBucketCorsResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketCorsRequest$Builder;", "putBucketEncryption", "Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest$Builder;", "putBucketIntelligentTieringConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketIntelligentTieringConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketIntelligentTieringConfigurationRequest$Builder;", "putBucketInventoryConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketInventoryConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketInventoryConfigurationRequest$Builder;", "putBucketLifecycleConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest$Builder;", "putBucketLogging", "Laws/sdk/kotlin/services/s3/model/PutBucketLoggingResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketLoggingRequest$Builder;", "putBucketMetricsConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketMetricsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketMetricsConfigurationRequest$Builder;", "putBucketNotificationConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketNotificationConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketNotificationConfigurationRequest$Builder;", "putBucketOwnershipControls", "Laws/sdk/kotlin/services/s3/model/PutBucketOwnershipControlsResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketOwnershipControlsRequest$Builder;", "putBucketPolicy", "Laws/sdk/kotlin/services/s3/model/PutBucketPolicyResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketPolicyRequest$Builder;", "putBucketReplication", "Laws/sdk/kotlin/services/s3/model/PutBucketReplicationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketReplicationRequest$Builder;", "putBucketRequestPayment", "Laws/sdk/kotlin/services/s3/model/PutBucketRequestPaymentResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketRequestPaymentRequest$Builder;", "putBucketTagging", "Laws/sdk/kotlin/services/s3/model/PutBucketTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketTaggingRequest$Builder;", "putBucketVersioning", "Laws/sdk/kotlin/services/s3/model/PutBucketVersioningResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketVersioningRequest$Builder;", "putBucketWebsite", "Laws/sdk/kotlin/services/s3/model/PutBucketWebsiteResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketWebsiteRequest$Builder;", "putObject", "Laws/sdk/kotlin/services/s3/model/PutObjectResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectRequest$Builder;", "putObjectAcl", "Laws/sdk/kotlin/services/s3/model/PutObjectAclResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectAclRequest$Builder;", "putObjectLegalHold", "Laws/sdk/kotlin/services/s3/model/PutObjectLegalHoldResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectLegalHoldRequest$Builder;", "putObjectLockConfiguration", "Laws/sdk/kotlin/services/s3/model/PutObjectLockConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectLockConfigurationRequest$Builder;", "putObjectRetention", "Laws/sdk/kotlin/services/s3/model/PutObjectRetentionResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest$Builder;", "putObjectTagging", "Laws/sdk/kotlin/services/s3/model/PutObjectTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectTaggingRequest$Builder;", "putPublicAccessBlock", "Laws/sdk/kotlin/services/s3/model/PutPublicAccessBlockResponse;", "Laws/sdk/kotlin/services/s3/model/PutPublicAccessBlockRequest$Builder;", "renameObject", "Laws/sdk/kotlin/services/s3/model/RenameObjectResponse;", "Laws/sdk/kotlin/services/s3/model/RenameObjectRequest$Builder;", "restoreObject", "Laws/sdk/kotlin/services/s3/model/RestoreObjectResponse;", "Laws/sdk/kotlin/services/s3/model/RestoreObjectRequest$Builder;", "updateBucketMetadataInventoryTableConfiguration", "Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataInventoryTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataInventoryTableConfigurationRequest$Builder;", "updateBucketMetadataJournalTableConfiguration", "Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataJournalTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataJournalTableConfigurationRequest$Builder;", "updateObjectEncryption", "Laws/sdk/kotlin/services/s3/model/UpdateObjectEncryptionResponse;", "Laws/sdk/kotlin/services/s3/model/UpdateObjectEncryptionRequest$Builder;", "uploadPart", "Laws/sdk/kotlin/services/s3/model/UploadPartResponse;", "Laws/sdk/kotlin/services/s3/model/UploadPartRequest$Builder;", "uploadPartCopy", "Laws/sdk/kotlin/services/s3/model/UploadPartCopyResponse;", "Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest$Builder;", "writeGetObjectResponse", "Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseResponse;", "Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest$Builder;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3ClientKt {
    public static final String SdkVersion = "1.6.17";
    public static final String ServiceApiVersion = "2006-03-01";
    public static final String ServiceId = "S3";

    public static final S3Client withConfig(S3Client s3Client, Function1<? super S3Client.Config.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(s3Client, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        S3Client.Config.Builder builder = s3Client.getConfig().toBuilder();
        block.invoke(builder);
        return new DefaultS3Client(builder.build());
    }

    public static final Object abortMultipartUpload(S3Client s3Client, Function1<? super AbortMultipartUploadRequest.Builder, Unit> function1, Continuation<? super AbortMultipartUploadResponse> continuation) {
        AbortMultipartUploadRequest.Builder builder = new AbortMultipartUploadRequest.Builder();
        function1.invoke(builder);
        return s3Client.abortMultipartUpload(builder.build(), continuation);
    }

    private static final Object abortMultipartUpload$$forInline(S3Client s3Client, Function1<? super AbortMultipartUploadRequest.Builder, Unit> function1, Continuation<? super AbortMultipartUploadResponse> continuation) {
        AbortMultipartUploadRequest.Builder builder = new AbortMultipartUploadRequest.Builder();
        function1.invoke(builder);
        return s3Client.abortMultipartUpload(builder.build(), continuation);
    }

    public static final Object completeMultipartUpload(S3Client s3Client, Function1<? super CompleteMultipartUploadRequest.Builder, Unit> function1, Continuation<? super CompleteMultipartUploadResponse> continuation) {
        CompleteMultipartUploadRequest.Builder builder = new CompleteMultipartUploadRequest.Builder();
        function1.invoke(builder);
        return s3Client.completeMultipartUpload(builder.build(), continuation);
    }

    private static final Object completeMultipartUpload$$forInline(S3Client s3Client, Function1<? super CompleteMultipartUploadRequest.Builder, Unit> function1, Continuation<? super CompleteMultipartUploadResponse> continuation) {
        CompleteMultipartUploadRequest.Builder builder = new CompleteMultipartUploadRequest.Builder();
        function1.invoke(builder);
        return s3Client.completeMultipartUpload(builder.build(), continuation);
    }

    public static final Object copyObject(S3Client s3Client, Function1<? super CopyObjectRequest.Builder, Unit> function1, Continuation<? super CopyObjectResponse> continuation) {
        CopyObjectRequest.Builder builder = new CopyObjectRequest.Builder();
        function1.invoke(builder);
        return s3Client.copyObject(builder.build(), continuation);
    }

    private static final Object copyObject$$forInline(S3Client s3Client, Function1<? super CopyObjectRequest.Builder, Unit> function1, Continuation<? super CopyObjectResponse> continuation) {
        CopyObjectRequest.Builder builder = new CopyObjectRequest.Builder();
        function1.invoke(builder);
        return s3Client.copyObject(builder.build(), continuation);
    }

    public static final Object createBucket(S3Client s3Client, Function1<? super CreateBucketRequest.Builder, Unit> function1, Continuation<? super CreateBucketResponse> continuation) {
        CreateBucketRequest.Builder builder = new CreateBucketRequest.Builder();
        function1.invoke(builder);
        return s3Client.createBucket(builder.build(), continuation);
    }

    private static final Object createBucket$$forInline(S3Client s3Client, Function1<? super CreateBucketRequest.Builder, Unit> function1, Continuation<? super CreateBucketResponse> continuation) {
        CreateBucketRequest.Builder builder = new CreateBucketRequest.Builder();
        function1.invoke(builder);
        return s3Client.createBucket(builder.build(), continuation);
    }

    public static final Object createBucketMetadataConfiguration(S3Client s3Client, Function1<? super CreateBucketMetadataConfigurationRequest.Builder, Unit> function1, Continuation<? super CreateBucketMetadataConfigurationResponse> continuation) {
        CreateBucketMetadataConfigurationRequest.Builder builder = new CreateBucketMetadataConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.createBucketMetadataConfiguration(builder.build(), continuation);
    }

    private static final Object createBucketMetadataConfiguration$$forInline(S3Client s3Client, Function1<? super CreateBucketMetadataConfigurationRequest.Builder, Unit> function1, Continuation<? super CreateBucketMetadataConfigurationResponse> continuation) {
        CreateBucketMetadataConfigurationRequest.Builder builder = new CreateBucketMetadataConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.createBucketMetadataConfiguration(builder.build(), continuation);
    }

    public static final Object createBucketMetadataTableConfiguration(S3Client s3Client, Function1<? super CreateBucketMetadataTableConfigurationRequest.Builder, Unit> function1, Continuation<? super CreateBucketMetadataTableConfigurationResponse> continuation) {
        CreateBucketMetadataTableConfigurationRequest.Builder builder = new CreateBucketMetadataTableConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.createBucketMetadataTableConfiguration(builder.build(), continuation);
    }

    private static final Object createBucketMetadataTableConfiguration$$forInline(S3Client s3Client, Function1<? super CreateBucketMetadataTableConfigurationRequest.Builder, Unit> function1, Continuation<? super CreateBucketMetadataTableConfigurationResponse> continuation) {
        CreateBucketMetadataTableConfigurationRequest.Builder builder = new CreateBucketMetadataTableConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.createBucketMetadataTableConfiguration(builder.build(), continuation);
    }

    public static final Object createMultipartUpload(S3Client s3Client, Function1<? super CreateMultipartUploadRequest.Builder, Unit> function1, Continuation<? super CreateMultipartUploadResponse> continuation) {
        CreateMultipartUploadRequest.Builder builder = new CreateMultipartUploadRequest.Builder();
        function1.invoke(builder);
        return s3Client.createMultipartUpload(builder.build(), continuation);
    }

    private static final Object createMultipartUpload$$forInline(S3Client s3Client, Function1<? super CreateMultipartUploadRequest.Builder, Unit> function1, Continuation<? super CreateMultipartUploadResponse> continuation) {
        CreateMultipartUploadRequest.Builder builder = new CreateMultipartUploadRequest.Builder();
        function1.invoke(builder);
        return s3Client.createMultipartUpload(builder.build(), continuation);
    }

    public static final Object createSession(S3Client s3Client, Function1<? super CreateSessionRequest.Builder, Unit> function1, Continuation<? super CreateSessionResponse> continuation) {
        CreateSessionRequest.Builder builder = new CreateSessionRequest.Builder();
        function1.invoke(builder);
        return s3Client.createSession(builder.build(), continuation);
    }

    private static final Object createSession$$forInline(S3Client s3Client, Function1<? super CreateSessionRequest.Builder, Unit> function1, Continuation<? super CreateSessionResponse> continuation) {
        CreateSessionRequest.Builder builder = new CreateSessionRequest.Builder();
        function1.invoke(builder);
        return s3Client.createSession(builder.build(), continuation);
    }

    public static final Object deleteBucket(S3Client s3Client, Function1<? super DeleteBucketRequest.Builder, Unit> function1, Continuation<? super DeleteBucketResponse> continuation) {
        DeleteBucketRequest.Builder builder = new DeleteBucketRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucket(builder.build(), continuation);
    }

    private static final Object deleteBucket$$forInline(S3Client s3Client, Function1<? super DeleteBucketRequest.Builder, Unit> function1, Continuation<? super DeleteBucketResponse> continuation) {
        DeleteBucketRequest.Builder builder = new DeleteBucketRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucket(builder.build(), continuation);
    }

    public static final Object deleteBucketAnalyticsConfiguration(S3Client s3Client, Function1<? super DeleteBucketAnalyticsConfigurationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketAnalyticsConfigurationResponse> continuation) {
        DeleteBucketAnalyticsConfigurationRequest.Builder builder = new DeleteBucketAnalyticsConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketAnalyticsConfiguration(builder.build(), continuation);
    }

    private static final Object deleteBucketAnalyticsConfiguration$$forInline(S3Client s3Client, Function1<? super DeleteBucketAnalyticsConfigurationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketAnalyticsConfigurationResponse> continuation) {
        DeleteBucketAnalyticsConfigurationRequest.Builder builder = new DeleteBucketAnalyticsConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketAnalyticsConfiguration(builder.build(), continuation);
    }

    public static final Object deleteBucketCors(S3Client s3Client, Function1<? super DeleteBucketCorsRequest.Builder, Unit> function1, Continuation<? super DeleteBucketCorsResponse> continuation) {
        DeleteBucketCorsRequest.Builder builder = new DeleteBucketCorsRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketCors(builder.build(), continuation);
    }

    private static final Object deleteBucketCors$$forInline(S3Client s3Client, Function1<? super DeleteBucketCorsRequest.Builder, Unit> function1, Continuation<? super DeleteBucketCorsResponse> continuation) {
        DeleteBucketCorsRequest.Builder builder = new DeleteBucketCorsRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketCors(builder.build(), continuation);
    }

    public static final Object deleteBucketEncryption(S3Client s3Client, Function1<? super DeleteBucketEncryptionRequest.Builder, Unit> function1, Continuation<? super DeleteBucketEncryptionResponse> continuation) {
        DeleteBucketEncryptionRequest.Builder builder = new DeleteBucketEncryptionRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketEncryption(builder.build(), continuation);
    }

    private static final Object deleteBucketEncryption$$forInline(S3Client s3Client, Function1<? super DeleteBucketEncryptionRequest.Builder, Unit> function1, Continuation<? super DeleteBucketEncryptionResponse> continuation) {
        DeleteBucketEncryptionRequest.Builder builder = new DeleteBucketEncryptionRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketEncryption(builder.build(), continuation);
    }

    public static final Object deleteBucketIntelligentTieringConfiguration(S3Client s3Client, Function1<? super DeleteBucketIntelligentTieringConfigurationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketIntelligentTieringConfigurationResponse> continuation) {
        DeleteBucketIntelligentTieringConfigurationRequest.Builder builder = new DeleteBucketIntelligentTieringConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketIntelligentTieringConfiguration(builder.build(), continuation);
    }

    private static final Object deleteBucketIntelligentTieringConfiguration$$forInline(S3Client s3Client, Function1<? super DeleteBucketIntelligentTieringConfigurationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketIntelligentTieringConfigurationResponse> continuation) {
        DeleteBucketIntelligentTieringConfigurationRequest.Builder builder = new DeleteBucketIntelligentTieringConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketIntelligentTieringConfiguration(builder.build(), continuation);
    }

    public static final Object deleteBucketInventoryConfiguration(S3Client s3Client, Function1<? super DeleteBucketInventoryConfigurationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketInventoryConfigurationResponse> continuation) {
        DeleteBucketInventoryConfigurationRequest.Builder builder = new DeleteBucketInventoryConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketInventoryConfiguration(builder.build(), continuation);
    }

    private static final Object deleteBucketInventoryConfiguration$$forInline(S3Client s3Client, Function1<? super DeleteBucketInventoryConfigurationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketInventoryConfigurationResponse> continuation) {
        DeleteBucketInventoryConfigurationRequest.Builder builder = new DeleteBucketInventoryConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketInventoryConfiguration(builder.build(), continuation);
    }

    public static final Object deleteBucketLifecycle(S3Client s3Client, Function1<? super DeleteBucketLifecycleRequest.Builder, Unit> function1, Continuation<? super DeleteBucketLifecycleResponse> continuation) {
        DeleteBucketLifecycleRequest.Builder builder = new DeleteBucketLifecycleRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketLifecycle(builder.build(), continuation);
    }

    private static final Object deleteBucketLifecycle$$forInline(S3Client s3Client, Function1<? super DeleteBucketLifecycleRequest.Builder, Unit> function1, Continuation<? super DeleteBucketLifecycleResponse> continuation) {
        DeleteBucketLifecycleRequest.Builder builder = new DeleteBucketLifecycleRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketLifecycle(builder.build(), continuation);
    }

    public static final Object deleteBucketMetadataConfiguration(S3Client s3Client, Function1<? super DeleteBucketMetadataConfigurationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketMetadataConfigurationResponse> continuation) {
        DeleteBucketMetadataConfigurationRequest.Builder builder = new DeleteBucketMetadataConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketMetadataConfiguration(builder.build(), continuation);
    }

    private static final Object deleteBucketMetadataConfiguration$$forInline(S3Client s3Client, Function1<? super DeleteBucketMetadataConfigurationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketMetadataConfigurationResponse> continuation) {
        DeleteBucketMetadataConfigurationRequest.Builder builder = new DeleteBucketMetadataConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketMetadataConfiguration(builder.build(), continuation);
    }

    public static final Object deleteBucketMetadataTableConfiguration(S3Client s3Client, Function1<? super DeleteBucketMetadataTableConfigurationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketMetadataTableConfigurationResponse> continuation) {
        DeleteBucketMetadataTableConfigurationRequest.Builder builder = new DeleteBucketMetadataTableConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketMetadataTableConfiguration(builder.build(), continuation);
    }

    private static final Object deleteBucketMetadataTableConfiguration$$forInline(S3Client s3Client, Function1<? super DeleteBucketMetadataTableConfigurationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketMetadataTableConfigurationResponse> continuation) {
        DeleteBucketMetadataTableConfigurationRequest.Builder builder = new DeleteBucketMetadataTableConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketMetadataTableConfiguration(builder.build(), continuation);
    }

    public static final Object deleteBucketMetricsConfiguration(S3Client s3Client, Function1<? super DeleteBucketMetricsConfigurationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketMetricsConfigurationResponse> continuation) {
        DeleteBucketMetricsConfigurationRequest.Builder builder = new DeleteBucketMetricsConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketMetricsConfiguration(builder.build(), continuation);
    }

    private static final Object deleteBucketMetricsConfiguration$$forInline(S3Client s3Client, Function1<? super DeleteBucketMetricsConfigurationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketMetricsConfigurationResponse> continuation) {
        DeleteBucketMetricsConfigurationRequest.Builder builder = new DeleteBucketMetricsConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketMetricsConfiguration(builder.build(), continuation);
    }

    public static final Object deleteBucketOwnershipControls(S3Client s3Client, Function1<? super DeleteBucketOwnershipControlsRequest.Builder, Unit> function1, Continuation<? super DeleteBucketOwnershipControlsResponse> continuation) {
        DeleteBucketOwnershipControlsRequest.Builder builder = new DeleteBucketOwnershipControlsRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketOwnershipControls(builder.build(), continuation);
    }

    private static final Object deleteBucketOwnershipControls$$forInline(S3Client s3Client, Function1<? super DeleteBucketOwnershipControlsRequest.Builder, Unit> function1, Continuation<? super DeleteBucketOwnershipControlsResponse> continuation) {
        DeleteBucketOwnershipControlsRequest.Builder builder = new DeleteBucketOwnershipControlsRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketOwnershipControls(builder.build(), continuation);
    }

    public static final Object deleteBucketPolicy(S3Client s3Client, Function1<? super DeleteBucketPolicyRequest.Builder, Unit> function1, Continuation<? super DeleteBucketPolicyResponse> continuation) {
        DeleteBucketPolicyRequest.Builder builder = new DeleteBucketPolicyRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketPolicy(builder.build(), continuation);
    }

    private static final Object deleteBucketPolicy$$forInline(S3Client s3Client, Function1<? super DeleteBucketPolicyRequest.Builder, Unit> function1, Continuation<? super DeleteBucketPolicyResponse> continuation) {
        DeleteBucketPolicyRequest.Builder builder = new DeleteBucketPolicyRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketPolicy(builder.build(), continuation);
    }

    public static final Object deleteBucketReplication(S3Client s3Client, Function1<? super DeleteBucketReplicationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketReplicationResponse> continuation) {
        DeleteBucketReplicationRequest.Builder builder = new DeleteBucketReplicationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketReplication(builder.build(), continuation);
    }

    private static final Object deleteBucketReplication$$forInline(S3Client s3Client, Function1<? super DeleteBucketReplicationRequest.Builder, Unit> function1, Continuation<? super DeleteBucketReplicationResponse> continuation) {
        DeleteBucketReplicationRequest.Builder builder = new DeleteBucketReplicationRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketReplication(builder.build(), continuation);
    }

    public static final Object deleteBucketTagging(S3Client s3Client, Function1<? super DeleteBucketTaggingRequest.Builder, Unit> function1, Continuation<? super DeleteBucketTaggingResponse> continuation) {
        DeleteBucketTaggingRequest.Builder builder = new DeleteBucketTaggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketTagging(builder.build(), continuation);
    }

    private static final Object deleteBucketTagging$$forInline(S3Client s3Client, Function1<? super DeleteBucketTaggingRequest.Builder, Unit> function1, Continuation<? super DeleteBucketTaggingResponse> continuation) {
        DeleteBucketTaggingRequest.Builder builder = new DeleteBucketTaggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketTagging(builder.build(), continuation);
    }

    public static final Object deleteBucketWebsite(S3Client s3Client, Function1<? super DeleteBucketWebsiteRequest.Builder, Unit> function1, Continuation<? super DeleteBucketWebsiteResponse> continuation) {
        DeleteBucketWebsiteRequest.Builder builder = new DeleteBucketWebsiteRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketWebsite(builder.build(), continuation);
    }

    private static final Object deleteBucketWebsite$$forInline(S3Client s3Client, Function1<? super DeleteBucketWebsiteRequest.Builder, Unit> function1, Continuation<? super DeleteBucketWebsiteResponse> continuation) {
        DeleteBucketWebsiteRequest.Builder builder = new DeleteBucketWebsiteRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteBucketWebsite(builder.build(), continuation);
    }

    public static final Object deleteObject(S3Client s3Client, Function1<? super DeleteObjectRequest.Builder, Unit> function1, Continuation<? super DeleteObjectResponse> continuation) {
        DeleteObjectRequest.Builder builder = new DeleteObjectRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteObject(builder.build(), continuation);
    }

    private static final Object deleteObject$$forInline(S3Client s3Client, Function1<? super DeleteObjectRequest.Builder, Unit> function1, Continuation<? super DeleteObjectResponse> continuation) {
        DeleteObjectRequest.Builder builder = new DeleteObjectRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteObject(builder.build(), continuation);
    }

    public static final Object deleteObjectTagging(S3Client s3Client, Function1<? super DeleteObjectTaggingRequest.Builder, Unit> function1, Continuation<? super DeleteObjectTaggingResponse> continuation) {
        DeleteObjectTaggingRequest.Builder builder = new DeleteObjectTaggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteObjectTagging(builder.build(), continuation);
    }

    private static final Object deleteObjectTagging$$forInline(S3Client s3Client, Function1<? super DeleteObjectTaggingRequest.Builder, Unit> function1, Continuation<? super DeleteObjectTaggingResponse> continuation) {
        DeleteObjectTaggingRequest.Builder builder = new DeleteObjectTaggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteObjectTagging(builder.build(), continuation);
    }

    public static final Object deleteObjects(S3Client s3Client, Function1<? super DeleteObjectsRequest.Builder, Unit> function1, Continuation<? super DeleteObjectsResponse> continuation) {
        DeleteObjectsRequest.Builder builder = new DeleteObjectsRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteObjects(builder.build(), continuation);
    }

    private static final Object deleteObjects$$forInline(S3Client s3Client, Function1<? super DeleteObjectsRequest.Builder, Unit> function1, Continuation<? super DeleteObjectsResponse> continuation) {
        DeleteObjectsRequest.Builder builder = new DeleteObjectsRequest.Builder();
        function1.invoke(builder);
        return s3Client.deleteObjects(builder.build(), continuation);
    }

    public static final Object deletePublicAccessBlock(S3Client s3Client, Function1<? super DeletePublicAccessBlockRequest.Builder, Unit> function1, Continuation<? super DeletePublicAccessBlockResponse> continuation) {
        DeletePublicAccessBlockRequest.Builder builder = new DeletePublicAccessBlockRequest.Builder();
        function1.invoke(builder);
        return s3Client.deletePublicAccessBlock(builder.build(), continuation);
    }

    private static final Object deletePublicAccessBlock$$forInline(S3Client s3Client, Function1<? super DeletePublicAccessBlockRequest.Builder, Unit> function1, Continuation<? super DeletePublicAccessBlockResponse> continuation) {
        DeletePublicAccessBlockRequest.Builder builder = new DeletePublicAccessBlockRequest.Builder();
        function1.invoke(builder);
        return s3Client.deletePublicAccessBlock(builder.build(), continuation);
    }

    public static final Object getBucketAbac(S3Client s3Client, Function1<? super GetBucketAbacRequest.Builder, Unit> function1, Continuation<? super GetBucketAbacResponse> continuation) {
        GetBucketAbacRequest.Builder builder = new GetBucketAbacRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketAbac(builder.build(), continuation);
    }

    private static final Object getBucketAbac$$forInline(S3Client s3Client, Function1<? super GetBucketAbacRequest.Builder, Unit> function1, Continuation<? super GetBucketAbacResponse> continuation) {
        GetBucketAbacRequest.Builder builder = new GetBucketAbacRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketAbac(builder.build(), continuation);
    }

    public static final Object getBucketAccelerateConfiguration(S3Client s3Client, Function1<? super GetBucketAccelerateConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketAccelerateConfigurationResponse> continuation) {
        GetBucketAccelerateConfigurationRequest.Builder builder = new GetBucketAccelerateConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketAccelerateConfiguration(builder.build(), continuation);
    }

    private static final Object getBucketAccelerateConfiguration$$forInline(S3Client s3Client, Function1<? super GetBucketAccelerateConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketAccelerateConfigurationResponse> continuation) {
        GetBucketAccelerateConfigurationRequest.Builder builder = new GetBucketAccelerateConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketAccelerateConfiguration(builder.build(), continuation);
    }

    public static final Object getBucketAcl(S3Client s3Client, Function1<? super GetBucketAclRequest.Builder, Unit> function1, Continuation<? super GetBucketAclResponse> continuation) {
        GetBucketAclRequest.Builder builder = new GetBucketAclRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketAcl(builder.build(), continuation);
    }

    private static final Object getBucketAcl$$forInline(S3Client s3Client, Function1<? super GetBucketAclRequest.Builder, Unit> function1, Continuation<? super GetBucketAclResponse> continuation) {
        GetBucketAclRequest.Builder builder = new GetBucketAclRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketAcl(builder.build(), continuation);
    }

    public static final Object getBucketAnalyticsConfiguration(S3Client s3Client, Function1<? super GetBucketAnalyticsConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketAnalyticsConfigurationResponse> continuation) {
        GetBucketAnalyticsConfigurationRequest.Builder builder = new GetBucketAnalyticsConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketAnalyticsConfiguration(builder.build(), continuation);
    }

    private static final Object getBucketAnalyticsConfiguration$$forInline(S3Client s3Client, Function1<? super GetBucketAnalyticsConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketAnalyticsConfigurationResponse> continuation) {
        GetBucketAnalyticsConfigurationRequest.Builder builder = new GetBucketAnalyticsConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketAnalyticsConfiguration(builder.build(), continuation);
    }

    public static final Object getBucketCors(S3Client s3Client, Function1<? super GetBucketCorsRequest.Builder, Unit> function1, Continuation<? super GetBucketCorsResponse> continuation) {
        GetBucketCorsRequest.Builder builder = new GetBucketCorsRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketCors(builder.build(), continuation);
    }

    private static final Object getBucketCors$$forInline(S3Client s3Client, Function1<? super GetBucketCorsRequest.Builder, Unit> function1, Continuation<? super GetBucketCorsResponse> continuation) {
        GetBucketCorsRequest.Builder builder = new GetBucketCorsRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketCors(builder.build(), continuation);
    }

    public static final Object getBucketEncryption(S3Client s3Client, Function1<? super GetBucketEncryptionRequest.Builder, Unit> function1, Continuation<? super GetBucketEncryptionResponse> continuation) {
        GetBucketEncryptionRequest.Builder builder = new GetBucketEncryptionRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketEncryption(builder.build(), continuation);
    }

    private static final Object getBucketEncryption$$forInline(S3Client s3Client, Function1<? super GetBucketEncryptionRequest.Builder, Unit> function1, Continuation<? super GetBucketEncryptionResponse> continuation) {
        GetBucketEncryptionRequest.Builder builder = new GetBucketEncryptionRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketEncryption(builder.build(), continuation);
    }

    public static final Object getBucketIntelligentTieringConfiguration(S3Client s3Client, Function1<? super GetBucketIntelligentTieringConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketIntelligentTieringConfigurationResponse> continuation) {
        GetBucketIntelligentTieringConfigurationRequest.Builder builder = new GetBucketIntelligentTieringConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketIntelligentTieringConfiguration(builder.build(), continuation);
    }

    private static final Object getBucketIntelligentTieringConfiguration$$forInline(S3Client s3Client, Function1<? super GetBucketIntelligentTieringConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketIntelligentTieringConfigurationResponse> continuation) {
        GetBucketIntelligentTieringConfigurationRequest.Builder builder = new GetBucketIntelligentTieringConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketIntelligentTieringConfiguration(builder.build(), continuation);
    }

    public static final Object getBucketInventoryConfiguration(S3Client s3Client, Function1<? super GetBucketInventoryConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketInventoryConfigurationResponse> continuation) {
        GetBucketInventoryConfigurationRequest.Builder builder = new GetBucketInventoryConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketInventoryConfiguration(builder.build(), continuation);
    }

    private static final Object getBucketInventoryConfiguration$$forInline(S3Client s3Client, Function1<? super GetBucketInventoryConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketInventoryConfigurationResponse> continuation) {
        GetBucketInventoryConfigurationRequest.Builder builder = new GetBucketInventoryConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketInventoryConfiguration(builder.build(), continuation);
    }

    public static final Object getBucketLifecycleConfiguration(S3Client s3Client, Function1<? super GetBucketLifecycleConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketLifecycleConfigurationResponse> continuation) {
        GetBucketLifecycleConfigurationRequest.Builder builder = new GetBucketLifecycleConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketLifecycleConfiguration(builder.build(), continuation);
    }

    private static final Object getBucketLifecycleConfiguration$$forInline(S3Client s3Client, Function1<? super GetBucketLifecycleConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketLifecycleConfigurationResponse> continuation) {
        GetBucketLifecycleConfigurationRequest.Builder builder = new GetBucketLifecycleConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketLifecycleConfiguration(builder.build(), continuation);
    }

    public static final Object getBucketLocation(S3Client s3Client, Function1<? super GetBucketLocationRequest.Builder, Unit> function1, Continuation<? super GetBucketLocationResponse> continuation) {
        GetBucketLocationRequest.Builder builder = new GetBucketLocationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketLocation(builder.build(), continuation);
    }

    private static final Object getBucketLocation$$forInline(S3Client s3Client, Function1<? super GetBucketLocationRequest.Builder, Unit> function1, Continuation<? super GetBucketLocationResponse> continuation) {
        GetBucketLocationRequest.Builder builder = new GetBucketLocationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketLocation(builder.build(), continuation);
    }

    public static final Object getBucketLogging(S3Client s3Client, Function1<? super GetBucketLoggingRequest.Builder, Unit> function1, Continuation<? super GetBucketLoggingResponse> continuation) {
        GetBucketLoggingRequest.Builder builder = new GetBucketLoggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketLogging(builder.build(), continuation);
    }

    private static final Object getBucketLogging$$forInline(S3Client s3Client, Function1<? super GetBucketLoggingRequest.Builder, Unit> function1, Continuation<? super GetBucketLoggingResponse> continuation) {
        GetBucketLoggingRequest.Builder builder = new GetBucketLoggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketLogging(builder.build(), continuation);
    }

    public static final Object getBucketMetadataConfiguration(S3Client s3Client, Function1<? super GetBucketMetadataConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketMetadataConfigurationResponse> continuation) {
        GetBucketMetadataConfigurationRequest.Builder builder = new GetBucketMetadataConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketMetadataConfiguration(builder.build(), continuation);
    }

    private static final Object getBucketMetadataConfiguration$$forInline(S3Client s3Client, Function1<? super GetBucketMetadataConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketMetadataConfigurationResponse> continuation) {
        GetBucketMetadataConfigurationRequest.Builder builder = new GetBucketMetadataConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketMetadataConfiguration(builder.build(), continuation);
    }

    public static final Object getBucketMetadataTableConfiguration(S3Client s3Client, Function1<? super GetBucketMetadataTableConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketMetadataTableConfigurationResponse> continuation) {
        GetBucketMetadataTableConfigurationRequest.Builder builder = new GetBucketMetadataTableConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketMetadataTableConfiguration(builder.build(), continuation);
    }

    private static final Object getBucketMetadataTableConfiguration$$forInline(S3Client s3Client, Function1<? super GetBucketMetadataTableConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketMetadataTableConfigurationResponse> continuation) {
        GetBucketMetadataTableConfigurationRequest.Builder builder = new GetBucketMetadataTableConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketMetadataTableConfiguration(builder.build(), continuation);
    }

    public static final Object getBucketMetricsConfiguration(S3Client s3Client, Function1<? super GetBucketMetricsConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketMetricsConfigurationResponse> continuation) {
        GetBucketMetricsConfigurationRequest.Builder builder = new GetBucketMetricsConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketMetricsConfiguration(builder.build(), continuation);
    }

    private static final Object getBucketMetricsConfiguration$$forInline(S3Client s3Client, Function1<? super GetBucketMetricsConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketMetricsConfigurationResponse> continuation) {
        GetBucketMetricsConfigurationRequest.Builder builder = new GetBucketMetricsConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketMetricsConfiguration(builder.build(), continuation);
    }

    public static final Object getBucketNotificationConfiguration(S3Client s3Client, Function1<? super GetBucketNotificationConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketNotificationConfigurationResponse> continuation) {
        GetBucketNotificationConfigurationRequest.Builder builder = new GetBucketNotificationConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketNotificationConfiguration(builder.build(), continuation);
    }

    private static final Object getBucketNotificationConfiguration$$forInline(S3Client s3Client, Function1<? super GetBucketNotificationConfigurationRequest.Builder, Unit> function1, Continuation<? super GetBucketNotificationConfigurationResponse> continuation) {
        GetBucketNotificationConfigurationRequest.Builder builder = new GetBucketNotificationConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketNotificationConfiguration(builder.build(), continuation);
    }

    public static final Object getBucketOwnershipControls(S3Client s3Client, Function1<? super GetBucketOwnershipControlsRequest.Builder, Unit> function1, Continuation<? super GetBucketOwnershipControlsResponse> continuation) {
        GetBucketOwnershipControlsRequest.Builder builder = new GetBucketOwnershipControlsRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketOwnershipControls(builder.build(), continuation);
    }

    private static final Object getBucketOwnershipControls$$forInline(S3Client s3Client, Function1<? super GetBucketOwnershipControlsRequest.Builder, Unit> function1, Continuation<? super GetBucketOwnershipControlsResponse> continuation) {
        GetBucketOwnershipControlsRequest.Builder builder = new GetBucketOwnershipControlsRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketOwnershipControls(builder.build(), continuation);
    }

    public static final Object getBucketPolicy(S3Client s3Client, Function1<? super GetBucketPolicyRequest.Builder, Unit> function1, Continuation<? super GetBucketPolicyResponse> continuation) {
        GetBucketPolicyRequest.Builder builder = new GetBucketPolicyRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketPolicy(builder.build(), continuation);
    }

    private static final Object getBucketPolicy$$forInline(S3Client s3Client, Function1<? super GetBucketPolicyRequest.Builder, Unit> function1, Continuation<? super GetBucketPolicyResponse> continuation) {
        GetBucketPolicyRequest.Builder builder = new GetBucketPolicyRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketPolicy(builder.build(), continuation);
    }

    public static final Object getBucketPolicyStatus(S3Client s3Client, Function1<? super GetBucketPolicyStatusRequest.Builder, Unit> function1, Continuation<? super GetBucketPolicyStatusResponse> continuation) {
        GetBucketPolicyStatusRequest.Builder builder = new GetBucketPolicyStatusRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketPolicyStatus(builder.build(), continuation);
    }

    private static final Object getBucketPolicyStatus$$forInline(S3Client s3Client, Function1<? super GetBucketPolicyStatusRequest.Builder, Unit> function1, Continuation<? super GetBucketPolicyStatusResponse> continuation) {
        GetBucketPolicyStatusRequest.Builder builder = new GetBucketPolicyStatusRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketPolicyStatus(builder.build(), continuation);
    }

    public static final Object getBucketReplication(S3Client s3Client, Function1<? super GetBucketReplicationRequest.Builder, Unit> function1, Continuation<? super GetBucketReplicationResponse> continuation) {
        GetBucketReplicationRequest.Builder builder = new GetBucketReplicationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketReplication(builder.build(), continuation);
    }

    private static final Object getBucketReplication$$forInline(S3Client s3Client, Function1<? super GetBucketReplicationRequest.Builder, Unit> function1, Continuation<? super GetBucketReplicationResponse> continuation) {
        GetBucketReplicationRequest.Builder builder = new GetBucketReplicationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketReplication(builder.build(), continuation);
    }

    public static final Object getBucketRequestPayment(S3Client s3Client, Function1<? super GetBucketRequestPaymentRequest.Builder, Unit> function1, Continuation<? super GetBucketRequestPaymentResponse> continuation) {
        GetBucketRequestPaymentRequest.Builder builder = new GetBucketRequestPaymentRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketRequestPayment(builder.build(), continuation);
    }

    private static final Object getBucketRequestPayment$$forInline(S3Client s3Client, Function1<? super GetBucketRequestPaymentRequest.Builder, Unit> function1, Continuation<? super GetBucketRequestPaymentResponse> continuation) {
        GetBucketRequestPaymentRequest.Builder builder = new GetBucketRequestPaymentRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketRequestPayment(builder.build(), continuation);
    }

    public static final Object getBucketTagging(S3Client s3Client, Function1<? super GetBucketTaggingRequest.Builder, Unit> function1, Continuation<? super GetBucketTaggingResponse> continuation) {
        GetBucketTaggingRequest.Builder builder = new GetBucketTaggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketTagging(builder.build(), continuation);
    }

    private static final Object getBucketTagging$$forInline(S3Client s3Client, Function1<? super GetBucketTaggingRequest.Builder, Unit> function1, Continuation<? super GetBucketTaggingResponse> continuation) {
        GetBucketTaggingRequest.Builder builder = new GetBucketTaggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketTagging(builder.build(), continuation);
    }

    public static final Object getBucketVersioning(S3Client s3Client, Function1<? super GetBucketVersioningRequest.Builder, Unit> function1, Continuation<? super GetBucketVersioningResponse> continuation) {
        GetBucketVersioningRequest.Builder builder = new GetBucketVersioningRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketVersioning(builder.build(), continuation);
    }

    private static final Object getBucketVersioning$$forInline(S3Client s3Client, Function1<? super GetBucketVersioningRequest.Builder, Unit> function1, Continuation<? super GetBucketVersioningResponse> continuation) {
        GetBucketVersioningRequest.Builder builder = new GetBucketVersioningRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketVersioning(builder.build(), continuation);
    }

    public static final Object getBucketWebsite(S3Client s3Client, Function1<? super GetBucketWebsiteRequest.Builder, Unit> function1, Continuation<? super GetBucketWebsiteResponse> continuation) {
        GetBucketWebsiteRequest.Builder builder = new GetBucketWebsiteRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketWebsite(builder.build(), continuation);
    }

    private static final Object getBucketWebsite$$forInline(S3Client s3Client, Function1<? super GetBucketWebsiteRequest.Builder, Unit> function1, Continuation<? super GetBucketWebsiteResponse> continuation) {
        GetBucketWebsiteRequest.Builder builder = new GetBucketWebsiteRequest.Builder();
        function1.invoke(builder);
        return s3Client.getBucketWebsite(builder.build(), continuation);
    }

    public static final Object getObjectAcl(S3Client s3Client, Function1<? super GetObjectAclRequest.Builder, Unit> function1, Continuation<? super GetObjectAclResponse> continuation) {
        GetObjectAclRequest.Builder builder = new GetObjectAclRequest.Builder();
        function1.invoke(builder);
        return s3Client.getObjectAcl(builder.build(), continuation);
    }

    private static final Object getObjectAcl$$forInline(S3Client s3Client, Function1<? super GetObjectAclRequest.Builder, Unit> function1, Continuation<? super GetObjectAclResponse> continuation) {
        GetObjectAclRequest.Builder builder = new GetObjectAclRequest.Builder();
        function1.invoke(builder);
        return s3Client.getObjectAcl(builder.build(), continuation);
    }

    public static final Object getObjectAttributes(S3Client s3Client, Function1<? super GetObjectAttributesRequest.Builder, Unit> function1, Continuation<? super GetObjectAttributesResponse> continuation) {
        GetObjectAttributesRequest.Builder builder = new GetObjectAttributesRequest.Builder();
        function1.invoke(builder);
        return s3Client.getObjectAttributes(builder.build(), continuation);
    }

    private static final Object getObjectAttributes$$forInline(S3Client s3Client, Function1<? super GetObjectAttributesRequest.Builder, Unit> function1, Continuation<? super GetObjectAttributesResponse> continuation) {
        GetObjectAttributesRequest.Builder builder = new GetObjectAttributesRequest.Builder();
        function1.invoke(builder);
        return s3Client.getObjectAttributes(builder.build(), continuation);
    }

    public static final Object getObjectLegalHold(S3Client s3Client, Function1<? super GetObjectLegalHoldRequest.Builder, Unit> function1, Continuation<? super GetObjectLegalHoldResponse> continuation) {
        GetObjectLegalHoldRequest.Builder builder = new GetObjectLegalHoldRequest.Builder();
        function1.invoke(builder);
        return s3Client.getObjectLegalHold(builder.build(), continuation);
    }

    private static final Object getObjectLegalHold$$forInline(S3Client s3Client, Function1<? super GetObjectLegalHoldRequest.Builder, Unit> function1, Continuation<? super GetObjectLegalHoldResponse> continuation) {
        GetObjectLegalHoldRequest.Builder builder = new GetObjectLegalHoldRequest.Builder();
        function1.invoke(builder);
        return s3Client.getObjectLegalHold(builder.build(), continuation);
    }

    public static final Object getObjectLockConfiguration(S3Client s3Client, Function1<? super GetObjectLockConfigurationRequest.Builder, Unit> function1, Continuation<? super GetObjectLockConfigurationResponse> continuation) {
        GetObjectLockConfigurationRequest.Builder builder = new GetObjectLockConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getObjectLockConfiguration(builder.build(), continuation);
    }

    private static final Object getObjectLockConfiguration$$forInline(S3Client s3Client, Function1<? super GetObjectLockConfigurationRequest.Builder, Unit> function1, Continuation<? super GetObjectLockConfigurationResponse> continuation) {
        GetObjectLockConfigurationRequest.Builder builder = new GetObjectLockConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.getObjectLockConfiguration(builder.build(), continuation);
    }

    public static final Object getObjectRetention(S3Client s3Client, Function1<? super GetObjectRetentionRequest.Builder, Unit> function1, Continuation<? super GetObjectRetentionResponse> continuation) {
        GetObjectRetentionRequest.Builder builder = new GetObjectRetentionRequest.Builder();
        function1.invoke(builder);
        return s3Client.getObjectRetention(builder.build(), continuation);
    }

    private static final Object getObjectRetention$$forInline(S3Client s3Client, Function1<? super GetObjectRetentionRequest.Builder, Unit> function1, Continuation<? super GetObjectRetentionResponse> continuation) {
        GetObjectRetentionRequest.Builder builder = new GetObjectRetentionRequest.Builder();
        function1.invoke(builder);
        return s3Client.getObjectRetention(builder.build(), continuation);
    }

    public static final Object getObjectTagging(S3Client s3Client, Function1<? super GetObjectTaggingRequest.Builder, Unit> function1, Continuation<? super GetObjectTaggingResponse> continuation) {
        GetObjectTaggingRequest.Builder builder = new GetObjectTaggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.getObjectTagging(builder.build(), continuation);
    }

    private static final Object getObjectTagging$$forInline(S3Client s3Client, Function1<? super GetObjectTaggingRequest.Builder, Unit> function1, Continuation<? super GetObjectTaggingResponse> continuation) {
        GetObjectTaggingRequest.Builder builder = new GetObjectTaggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.getObjectTagging(builder.build(), continuation);
    }

    public static final Object getPublicAccessBlock(S3Client s3Client, Function1<? super GetPublicAccessBlockRequest.Builder, Unit> function1, Continuation<? super GetPublicAccessBlockResponse> continuation) {
        GetPublicAccessBlockRequest.Builder builder = new GetPublicAccessBlockRequest.Builder();
        function1.invoke(builder);
        return s3Client.getPublicAccessBlock(builder.build(), continuation);
    }

    private static final Object getPublicAccessBlock$$forInline(S3Client s3Client, Function1<? super GetPublicAccessBlockRequest.Builder, Unit> function1, Continuation<? super GetPublicAccessBlockResponse> continuation) {
        GetPublicAccessBlockRequest.Builder builder = new GetPublicAccessBlockRequest.Builder();
        function1.invoke(builder);
        return s3Client.getPublicAccessBlock(builder.build(), continuation);
    }

    public static final Object headBucket(S3Client s3Client, Function1<? super HeadBucketRequest.Builder, Unit> function1, Continuation<? super HeadBucketResponse> continuation) {
        HeadBucketRequest.Builder builder = new HeadBucketRequest.Builder();
        function1.invoke(builder);
        return s3Client.headBucket(builder.build(), continuation);
    }

    private static final Object headBucket$$forInline(S3Client s3Client, Function1<? super HeadBucketRequest.Builder, Unit> function1, Continuation<? super HeadBucketResponse> continuation) {
        HeadBucketRequest.Builder builder = new HeadBucketRequest.Builder();
        function1.invoke(builder);
        return s3Client.headBucket(builder.build(), continuation);
    }

    public static final Object headObject(S3Client s3Client, Function1<? super HeadObjectRequest.Builder, Unit> function1, Continuation<? super HeadObjectResponse> continuation) {
        HeadObjectRequest.Builder builder = new HeadObjectRequest.Builder();
        function1.invoke(builder);
        return s3Client.headObject(builder.build(), continuation);
    }

    private static final Object headObject$$forInline(S3Client s3Client, Function1<? super HeadObjectRequest.Builder, Unit> function1, Continuation<? super HeadObjectResponse> continuation) {
        HeadObjectRequest.Builder builder = new HeadObjectRequest.Builder();
        function1.invoke(builder);
        return s3Client.headObject(builder.build(), continuation);
    }

    public static final Object listBucketAnalyticsConfigurations(S3Client s3Client, Function1<? super ListBucketAnalyticsConfigurationsRequest.Builder, Unit> function1, Continuation<? super ListBucketAnalyticsConfigurationsResponse> continuation) {
        ListBucketAnalyticsConfigurationsRequest.Builder builder = new ListBucketAnalyticsConfigurationsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listBucketAnalyticsConfigurations(builder.build(), continuation);
    }

    private static final Object listBucketAnalyticsConfigurations$$forInline(S3Client s3Client, Function1<? super ListBucketAnalyticsConfigurationsRequest.Builder, Unit> function1, Continuation<? super ListBucketAnalyticsConfigurationsResponse> continuation) {
        ListBucketAnalyticsConfigurationsRequest.Builder builder = new ListBucketAnalyticsConfigurationsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listBucketAnalyticsConfigurations(builder.build(), continuation);
    }

    public static final Object listBucketIntelligentTieringConfigurations(S3Client s3Client, Function1<? super ListBucketIntelligentTieringConfigurationsRequest.Builder, Unit> function1, Continuation<? super ListBucketIntelligentTieringConfigurationsResponse> continuation) {
        ListBucketIntelligentTieringConfigurationsRequest.Builder builder = new ListBucketIntelligentTieringConfigurationsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listBucketIntelligentTieringConfigurations(builder.build(), continuation);
    }

    private static final Object listBucketIntelligentTieringConfigurations$$forInline(S3Client s3Client, Function1<? super ListBucketIntelligentTieringConfigurationsRequest.Builder, Unit> function1, Continuation<? super ListBucketIntelligentTieringConfigurationsResponse> continuation) {
        ListBucketIntelligentTieringConfigurationsRequest.Builder builder = new ListBucketIntelligentTieringConfigurationsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listBucketIntelligentTieringConfigurations(builder.build(), continuation);
    }

    public static final Object listBucketInventoryConfigurations(S3Client s3Client, Function1<? super ListBucketInventoryConfigurationsRequest.Builder, Unit> function1, Continuation<? super ListBucketInventoryConfigurationsResponse> continuation) {
        ListBucketInventoryConfigurationsRequest.Builder builder = new ListBucketInventoryConfigurationsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listBucketInventoryConfigurations(builder.build(), continuation);
    }

    private static final Object listBucketInventoryConfigurations$$forInline(S3Client s3Client, Function1<? super ListBucketInventoryConfigurationsRequest.Builder, Unit> function1, Continuation<? super ListBucketInventoryConfigurationsResponse> continuation) {
        ListBucketInventoryConfigurationsRequest.Builder builder = new ListBucketInventoryConfigurationsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listBucketInventoryConfigurations(builder.build(), continuation);
    }

    public static final Object listBucketMetricsConfigurations(S3Client s3Client, Function1<? super ListBucketMetricsConfigurationsRequest.Builder, Unit> function1, Continuation<? super ListBucketMetricsConfigurationsResponse> continuation) {
        ListBucketMetricsConfigurationsRequest.Builder builder = new ListBucketMetricsConfigurationsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listBucketMetricsConfigurations(builder.build(), continuation);
    }

    private static final Object listBucketMetricsConfigurations$$forInline(S3Client s3Client, Function1<? super ListBucketMetricsConfigurationsRequest.Builder, Unit> function1, Continuation<? super ListBucketMetricsConfigurationsResponse> continuation) {
        ListBucketMetricsConfigurationsRequest.Builder builder = new ListBucketMetricsConfigurationsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listBucketMetricsConfigurations(builder.build(), continuation);
    }

    public static final Object listBuckets(S3Client s3Client, Function1<? super ListBucketsRequest.Builder, Unit> function1, Continuation<? super ListBucketsResponse> continuation) {
        ListBucketsRequest.Builder builder = new ListBucketsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listBuckets(builder.build(), continuation);
    }

    private static final Object listBuckets$$forInline(S3Client s3Client, Function1<? super ListBucketsRequest.Builder, Unit> function1, Continuation<? super ListBucketsResponse> continuation) {
        ListBucketsRequest.Builder builder = new ListBucketsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listBuckets(builder.build(), continuation);
    }

    public static final Object listDirectoryBuckets(S3Client s3Client, Function1<? super ListDirectoryBucketsRequest.Builder, Unit> function1, Continuation<? super ListDirectoryBucketsResponse> continuation) {
        ListDirectoryBucketsRequest.Builder builder = new ListDirectoryBucketsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listDirectoryBuckets(builder.build(), continuation);
    }

    private static final Object listDirectoryBuckets$$forInline(S3Client s3Client, Function1<? super ListDirectoryBucketsRequest.Builder, Unit> function1, Continuation<? super ListDirectoryBucketsResponse> continuation) {
        ListDirectoryBucketsRequest.Builder builder = new ListDirectoryBucketsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listDirectoryBuckets(builder.build(), continuation);
    }

    public static final Object listMultipartUploads(S3Client s3Client, Function1<? super ListMultipartUploadsRequest.Builder, Unit> function1, Continuation<? super ListMultipartUploadsResponse> continuation) {
        ListMultipartUploadsRequest.Builder builder = new ListMultipartUploadsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listMultipartUploads(builder.build(), continuation);
    }

    private static final Object listMultipartUploads$$forInline(S3Client s3Client, Function1<? super ListMultipartUploadsRequest.Builder, Unit> function1, Continuation<? super ListMultipartUploadsResponse> continuation) {
        ListMultipartUploadsRequest.Builder builder = new ListMultipartUploadsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listMultipartUploads(builder.build(), continuation);
    }

    public static final Object listObjectVersions(S3Client s3Client, Function1<? super ListObjectVersionsRequest.Builder, Unit> function1, Continuation<? super ListObjectVersionsResponse> continuation) {
        ListObjectVersionsRequest.Builder builder = new ListObjectVersionsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listObjectVersions(builder.build(), continuation);
    }

    private static final Object listObjectVersions$$forInline(S3Client s3Client, Function1<? super ListObjectVersionsRequest.Builder, Unit> function1, Continuation<? super ListObjectVersionsResponse> continuation) {
        ListObjectVersionsRequest.Builder builder = new ListObjectVersionsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listObjectVersions(builder.build(), continuation);
    }

    public static final Object listObjects(S3Client s3Client, Function1<? super ListObjectsRequest.Builder, Unit> function1, Continuation<? super ListObjectsResponse> continuation) {
        ListObjectsRequest.Builder builder = new ListObjectsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listObjects(builder.build(), continuation);
    }

    private static final Object listObjects$$forInline(S3Client s3Client, Function1<? super ListObjectsRequest.Builder, Unit> function1, Continuation<? super ListObjectsResponse> continuation) {
        ListObjectsRequest.Builder builder = new ListObjectsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listObjects(builder.build(), continuation);
    }

    public static final Object listObjectsV2(S3Client s3Client, Function1<? super ListObjectsV2Request.Builder, Unit> function1, Continuation<? super ListObjectsV2Response> continuation) {
        ListObjectsV2Request.Builder builder = new ListObjectsV2Request.Builder();
        function1.invoke(builder);
        return s3Client.listObjectsV2(builder.build(), continuation);
    }

    private static final Object listObjectsV2$$forInline(S3Client s3Client, Function1<? super ListObjectsV2Request.Builder, Unit> function1, Continuation<? super ListObjectsV2Response> continuation) {
        ListObjectsV2Request.Builder builder = new ListObjectsV2Request.Builder();
        function1.invoke(builder);
        return s3Client.listObjectsV2(builder.build(), continuation);
    }

    public static final Object listParts(S3Client s3Client, Function1<? super ListPartsRequest.Builder, Unit> function1, Continuation<? super ListPartsResponse> continuation) {
        ListPartsRequest.Builder builder = new ListPartsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listParts(builder.build(), continuation);
    }

    private static final Object listParts$$forInline(S3Client s3Client, Function1<? super ListPartsRequest.Builder, Unit> function1, Continuation<? super ListPartsResponse> continuation) {
        ListPartsRequest.Builder builder = new ListPartsRequest.Builder();
        function1.invoke(builder);
        return s3Client.listParts(builder.build(), continuation);
    }

    public static final Object putBucketAbac(S3Client s3Client, Function1<? super PutBucketAbacRequest.Builder, Unit> function1, Continuation<? super PutBucketAbacResponse> continuation) {
        PutBucketAbacRequest.Builder builder = new PutBucketAbacRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketAbac(builder.build(), continuation);
    }

    private static final Object putBucketAbac$$forInline(S3Client s3Client, Function1<? super PutBucketAbacRequest.Builder, Unit> function1, Continuation<? super PutBucketAbacResponse> continuation) {
        PutBucketAbacRequest.Builder builder = new PutBucketAbacRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketAbac(builder.build(), continuation);
    }

    public static final Object putBucketAccelerateConfiguration(S3Client s3Client, Function1<? super PutBucketAccelerateConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketAccelerateConfigurationResponse> continuation) {
        PutBucketAccelerateConfigurationRequest.Builder builder = new PutBucketAccelerateConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketAccelerateConfiguration(builder.build(), continuation);
    }

    private static final Object putBucketAccelerateConfiguration$$forInline(S3Client s3Client, Function1<? super PutBucketAccelerateConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketAccelerateConfigurationResponse> continuation) {
        PutBucketAccelerateConfigurationRequest.Builder builder = new PutBucketAccelerateConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketAccelerateConfiguration(builder.build(), continuation);
    }

    public static final Object putBucketAcl(S3Client s3Client, Function1<? super PutBucketAclRequest.Builder, Unit> function1, Continuation<? super PutBucketAclResponse> continuation) {
        PutBucketAclRequest.Builder builder = new PutBucketAclRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketAcl(builder.build(), continuation);
    }

    private static final Object putBucketAcl$$forInline(S3Client s3Client, Function1<? super PutBucketAclRequest.Builder, Unit> function1, Continuation<? super PutBucketAclResponse> continuation) {
        PutBucketAclRequest.Builder builder = new PutBucketAclRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketAcl(builder.build(), continuation);
    }

    public static final Object putBucketAnalyticsConfiguration(S3Client s3Client, Function1<? super PutBucketAnalyticsConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketAnalyticsConfigurationResponse> continuation) {
        PutBucketAnalyticsConfigurationRequest.Builder builder = new PutBucketAnalyticsConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketAnalyticsConfiguration(builder.build(), continuation);
    }

    private static final Object putBucketAnalyticsConfiguration$$forInline(S3Client s3Client, Function1<? super PutBucketAnalyticsConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketAnalyticsConfigurationResponse> continuation) {
        PutBucketAnalyticsConfigurationRequest.Builder builder = new PutBucketAnalyticsConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketAnalyticsConfiguration(builder.build(), continuation);
    }

    public static final Object putBucketCors(S3Client s3Client, Function1<? super PutBucketCorsRequest.Builder, Unit> function1, Continuation<? super PutBucketCorsResponse> continuation) {
        PutBucketCorsRequest.Builder builder = new PutBucketCorsRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketCors(builder.build(), continuation);
    }

    private static final Object putBucketCors$$forInline(S3Client s3Client, Function1<? super PutBucketCorsRequest.Builder, Unit> function1, Continuation<? super PutBucketCorsResponse> continuation) {
        PutBucketCorsRequest.Builder builder = new PutBucketCorsRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketCors(builder.build(), continuation);
    }

    public static final Object putBucketEncryption(S3Client s3Client, Function1<? super PutBucketEncryptionRequest.Builder, Unit> function1, Continuation<? super PutBucketEncryptionResponse> continuation) {
        PutBucketEncryptionRequest.Builder builder = new PutBucketEncryptionRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketEncryption(builder.build(), continuation);
    }

    private static final Object putBucketEncryption$$forInline(S3Client s3Client, Function1<? super PutBucketEncryptionRequest.Builder, Unit> function1, Continuation<? super PutBucketEncryptionResponse> continuation) {
        PutBucketEncryptionRequest.Builder builder = new PutBucketEncryptionRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketEncryption(builder.build(), continuation);
    }

    public static final Object putBucketIntelligentTieringConfiguration(S3Client s3Client, Function1<? super PutBucketIntelligentTieringConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketIntelligentTieringConfigurationResponse> continuation) {
        PutBucketIntelligentTieringConfigurationRequest.Builder builder = new PutBucketIntelligentTieringConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketIntelligentTieringConfiguration(builder.build(), continuation);
    }

    private static final Object putBucketIntelligentTieringConfiguration$$forInline(S3Client s3Client, Function1<? super PutBucketIntelligentTieringConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketIntelligentTieringConfigurationResponse> continuation) {
        PutBucketIntelligentTieringConfigurationRequest.Builder builder = new PutBucketIntelligentTieringConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketIntelligentTieringConfiguration(builder.build(), continuation);
    }

    public static final Object putBucketInventoryConfiguration(S3Client s3Client, Function1<? super PutBucketInventoryConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketInventoryConfigurationResponse> continuation) {
        PutBucketInventoryConfigurationRequest.Builder builder = new PutBucketInventoryConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketInventoryConfiguration(builder.build(), continuation);
    }

    private static final Object putBucketInventoryConfiguration$$forInline(S3Client s3Client, Function1<? super PutBucketInventoryConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketInventoryConfigurationResponse> continuation) {
        PutBucketInventoryConfigurationRequest.Builder builder = new PutBucketInventoryConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketInventoryConfiguration(builder.build(), continuation);
    }

    public static final Object putBucketLifecycleConfiguration(S3Client s3Client, Function1<? super PutBucketLifecycleConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketLifecycleConfigurationResponse> continuation) {
        PutBucketLifecycleConfigurationRequest.Builder builder = new PutBucketLifecycleConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketLifecycleConfiguration(builder.build(), continuation);
    }

    private static final Object putBucketLifecycleConfiguration$$forInline(S3Client s3Client, Function1<? super PutBucketLifecycleConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketLifecycleConfigurationResponse> continuation) {
        PutBucketLifecycleConfigurationRequest.Builder builder = new PutBucketLifecycleConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketLifecycleConfiguration(builder.build(), continuation);
    }

    public static final Object putBucketLogging(S3Client s3Client, Function1<? super PutBucketLoggingRequest.Builder, Unit> function1, Continuation<? super PutBucketLoggingResponse> continuation) {
        PutBucketLoggingRequest.Builder builder = new PutBucketLoggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketLogging(builder.build(), continuation);
    }

    private static final Object putBucketLogging$$forInline(S3Client s3Client, Function1<? super PutBucketLoggingRequest.Builder, Unit> function1, Continuation<? super PutBucketLoggingResponse> continuation) {
        PutBucketLoggingRequest.Builder builder = new PutBucketLoggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketLogging(builder.build(), continuation);
    }

    public static final Object putBucketMetricsConfiguration(S3Client s3Client, Function1<? super PutBucketMetricsConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketMetricsConfigurationResponse> continuation) {
        PutBucketMetricsConfigurationRequest.Builder builder = new PutBucketMetricsConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketMetricsConfiguration(builder.build(), continuation);
    }

    private static final Object putBucketMetricsConfiguration$$forInline(S3Client s3Client, Function1<? super PutBucketMetricsConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketMetricsConfigurationResponse> continuation) {
        PutBucketMetricsConfigurationRequest.Builder builder = new PutBucketMetricsConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketMetricsConfiguration(builder.build(), continuation);
    }

    public static final Object putBucketNotificationConfiguration(S3Client s3Client, Function1<? super PutBucketNotificationConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketNotificationConfigurationResponse> continuation) {
        PutBucketNotificationConfigurationRequest.Builder builder = new PutBucketNotificationConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketNotificationConfiguration(builder.build(), continuation);
    }

    private static final Object putBucketNotificationConfiguration$$forInline(S3Client s3Client, Function1<? super PutBucketNotificationConfigurationRequest.Builder, Unit> function1, Continuation<? super PutBucketNotificationConfigurationResponse> continuation) {
        PutBucketNotificationConfigurationRequest.Builder builder = new PutBucketNotificationConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketNotificationConfiguration(builder.build(), continuation);
    }

    public static final Object putBucketOwnershipControls(S3Client s3Client, Function1<? super PutBucketOwnershipControlsRequest.Builder, Unit> function1, Continuation<? super PutBucketOwnershipControlsResponse> continuation) {
        PutBucketOwnershipControlsRequest.Builder builder = new PutBucketOwnershipControlsRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketOwnershipControls(builder.build(), continuation);
    }

    private static final Object putBucketOwnershipControls$$forInline(S3Client s3Client, Function1<? super PutBucketOwnershipControlsRequest.Builder, Unit> function1, Continuation<? super PutBucketOwnershipControlsResponse> continuation) {
        PutBucketOwnershipControlsRequest.Builder builder = new PutBucketOwnershipControlsRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketOwnershipControls(builder.build(), continuation);
    }

    public static final Object putBucketPolicy(S3Client s3Client, Function1<? super PutBucketPolicyRequest.Builder, Unit> function1, Continuation<? super PutBucketPolicyResponse> continuation) {
        PutBucketPolicyRequest.Builder builder = new PutBucketPolicyRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketPolicy(builder.build(), continuation);
    }

    private static final Object putBucketPolicy$$forInline(S3Client s3Client, Function1<? super PutBucketPolicyRequest.Builder, Unit> function1, Continuation<? super PutBucketPolicyResponse> continuation) {
        PutBucketPolicyRequest.Builder builder = new PutBucketPolicyRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketPolicy(builder.build(), continuation);
    }

    public static final Object putBucketReplication(S3Client s3Client, Function1<? super PutBucketReplicationRequest.Builder, Unit> function1, Continuation<? super PutBucketReplicationResponse> continuation) {
        PutBucketReplicationRequest.Builder builder = new PutBucketReplicationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketReplication(builder.build(), continuation);
    }

    private static final Object putBucketReplication$$forInline(S3Client s3Client, Function1<? super PutBucketReplicationRequest.Builder, Unit> function1, Continuation<? super PutBucketReplicationResponse> continuation) {
        PutBucketReplicationRequest.Builder builder = new PutBucketReplicationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketReplication(builder.build(), continuation);
    }

    public static final Object putBucketRequestPayment(S3Client s3Client, Function1<? super PutBucketRequestPaymentRequest.Builder, Unit> function1, Continuation<? super PutBucketRequestPaymentResponse> continuation) {
        PutBucketRequestPaymentRequest.Builder builder = new PutBucketRequestPaymentRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketRequestPayment(builder.build(), continuation);
    }

    private static final Object putBucketRequestPayment$$forInline(S3Client s3Client, Function1<? super PutBucketRequestPaymentRequest.Builder, Unit> function1, Continuation<? super PutBucketRequestPaymentResponse> continuation) {
        PutBucketRequestPaymentRequest.Builder builder = new PutBucketRequestPaymentRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketRequestPayment(builder.build(), continuation);
    }

    public static final Object putBucketTagging(S3Client s3Client, Function1<? super PutBucketTaggingRequest.Builder, Unit> function1, Continuation<? super PutBucketTaggingResponse> continuation) {
        PutBucketTaggingRequest.Builder builder = new PutBucketTaggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketTagging(builder.build(), continuation);
    }

    private static final Object putBucketTagging$$forInline(S3Client s3Client, Function1<? super PutBucketTaggingRequest.Builder, Unit> function1, Continuation<? super PutBucketTaggingResponse> continuation) {
        PutBucketTaggingRequest.Builder builder = new PutBucketTaggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketTagging(builder.build(), continuation);
    }

    public static final Object putBucketVersioning(S3Client s3Client, Function1<? super PutBucketVersioningRequest.Builder, Unit> function1, Continuation<? super PutBucketVersioningResponse> continuation) {
        PutBucketVersioningRequest.Builder builder = new PutBucketVersioningRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketVersioning(builder.build(), continuation);
    }

    private static final Object putBucketVersioning$$forInline(S3Client s3Client, Function1<? super PutBucketVersioningRequest.Builder, Unit> function1, Continuation<? super PutBucketVersioningResponse> continuation) {
        PutBucketVersioningRequest.Builder builder = new PutBucketVersioningRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketVersioning(builder.build(), continuation);
    }

    public static final Object putBucketWebsite(S3Client s3Client, Function1<? super PutBucketWebsiteRequest.Builder, Unit> function1, Continuation<? super PutBucketWebsiteResponse> continuation) {
        PutBucketWebsiteRequest.Builder builder = new PutBucketWebsiteRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketWebsite(builder.build(), continuation);
    }

    private static final Object putBucketWebsite$$forInline(S3Client s3Client, Function1<? super PutBucketWebsiteRequest.Builder, Unit> function1, Continuation<? super PutBucketWebsiteResponse> continuation) {
        PutBucketWebsiteRequest.Builder builder = new PutBucketWebsiteRequest.Builder();
        function1.invoke(builder);
        return s3Client.putBucketWebsite(builder.build(), continuation);
    }

    public static final Object putObject(S3Client s3Client, Function1<? super PutObjectRequest.Builder, Unit> function1, Continuation<? super PutObjectResponse> continuation) {
        PutObjectRequest.Builder builder = new PutObjectRequest.Builder();
        function1.invoke(builder);
        return s3Client.putObject(builder.build(), continuation);
    }

    private static final Object putObject$$forInline(S3Client s3Client, Function1<? super PutObjectRequest.Builder, Unit> function1, Continuation<? super PutObjectResponse> continuation) {
        PutObjectRequest.Builder builder = new PutObjectRequest.Builder();
        function1.invoke(builder);
        return s3Client.putObject(builder.build(), continuation);
    }

    public static final Object putObjectAcl(S3Client s3Client, Function1<? super PutObjectAclRequest.Builder, Unit> function1, Continuation<? super PutObjectAclResponse> continuation) {
        PutObjectAclRequest.Builder builder = new PutObjectAclRequest.Builder();
        function1.invoke(builder);
        return s3Client.putObjectAcl(builder.build(), continuation);
    }

    private static final Object putObjectAcl$$forInline(S3Client s3Client, Function1<? super PutObjectAclRequest.Builder, Unit> function1, Continuation<? super PutObjectAclResponse> continuation) {
        PutObjectAclRequest.Builder builder = new PutObjectAclRequest.Builder();
        function1.invoke(builder);
        return s3Client.putObjectAcl(builder.build(), continuation);
    }

    public static final Object putObjectLegalHold(S3Client s3Client, Function1<? super PutObjectLegalHoldRequest.Builder, Unit> function1, Continuation<? super PutObjectLegalHoldResponse> continuation) {
        PutObjectLegalHoldRequest.Builder builder = new PutObjectLegalHoldRequest.Builder();
        function1.invoke(builder);
        return s3Client.putObjectLegalHold(builder.build(), continuation);
    }

    private static final Object putObjectLegalHold$$forInline(S3Client s3Client, Function1<? super PutObjectLegalHoldRequest.Builder, Unit> function1, Continuation<? super PutObjectLegalHoldResponse> continuation) {
        PutObjectLegalHoldRequest.Builder builder = new PutObjectLegalHoldRequest.Builder();
        function1.invoke(builder);
        return s3Client.putObjectLegalHold(builder.build(), continuation);
    }

    public static final Object putObjectLockConfiguration(S3Client s3Client, Function1<? super PutObjectLockConfigurationRequest.Builder, Unit> function1, Continuation<? super PutObjectLockConfigurationResponse> continuation) {
        PutObjectLockConfigurationRequest.Builder builder = new PutObjectLockConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putObjectLockConfiguration(builder.build(), continuation);
    }

    private static final Object putObjectLockConfiguration$$forInline(S3Client s3Client, Function1<? super PutObjectLockConfigurationRequest.Builder, Unit> function1, Continuation<? super PutObjectLockConfigurationResponse> continuation) {
        PutObjectLockConfigurationRequest.Builder builder = new PutObjectLockConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.putObjectLockConfiguration(builder.build(), continuation);
    }

    public static final Object putObjectRetention(S3Client s3Client, Function1<? super PutObjectRetentionRequest.Builder, Unit> function1, Continuation<? super PutObjectRetentionResponse> continuation) {
        PutObjectRetentionRequest.Builder builder = new PutObjectRetentionRequest.Builder();
        function1.invoke(builder);
        return s3Client.putObjectRetention(builder.build(), continuation);
    }

    private static final Object putObjectRetention$$forInline(S3Client s3Client, Function1<? super PutObjectRetentionRequest.Builder, Unit> function1, Continuation<? super PutObjectRetentionResponse> continuation) {
        PutObjectRetentionRequest.Builder builder = new PutObjectRetentionRequest.Builder();
        function1.invoke(builder);
        return s3Client.putObjectRetention(builder.build(), continuation);
    }

    public static final Object putObjectTagging(S3Client s3Client, Function1<? super PutObjectTaggingRequest.Builder, Unit> function1, Continuation<? super PutObjectTaggingResponse> continuation) {
        PutObjectTaggingRequest.Builder builder = new PutObjectTaggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.putObjectTagging(builder.build(), continuation);
    }

    private static final Object putObjectTagging$$forInline(S3Client s3Client, Function1<? super PutObjectTaggingRequest.Builder, Unit> function1, Continuation<? super PutObjectTaggingResponse> continuation) {
        PutObjectTaggingRequest.Builder builder = new PutObjectTaggingRequest.Builder();
        function1.invoke(builder);
        return s3Client.putObjectTagging(builder.build(), continuation);
    }

    public static final Object putPublicAccessBlock(S3Client s3Client, Function1<? super PutPublicAccessBlockRequest.Builder, Unit> function1, Continuation<? super PutPublicAccessBlockResponse> continuation) {
        PutPublicAccessBlockRequest.Builder builder = new PutPublicAccessBlockRequest.Builder();
        function1.invoke(builder);
        return s3Client.putPublicAccessBlock(builder.build(), continuation);
    }

    private static final Object putPublicAccessBlock$$forInline(S3Client s3Client, Function1<? super PutPublicAccessBlockRequest.Builder, Unit> function1, Continuation<? super PutPublicAccessBlockResponse> continuation) {
        PutPublicAccessBlockRequest.Builder builder = new PutPublicAccessBlockRequest.Builder();
        function1.invoke(builder);
        return s3Client.putPublicAccessBlock(builder.build(), continuation);
    }

    public static final Object renameObject(S3Client s3Client, Function1<? super RenameObjectRequest.Builder, Unit> function1, Continuation<? super RenameObjectResponse> continuation) {
        RenameObjectRequest.Builder builder = new RenameObjectRequest.Builder();
        function1.invoke(builder);
        return s3Client.renameObject(builder.build(), continuation);
    }

    private static final Object renameObject$$forInline(S3Client s3Client, Function1<? super RenameObjectRequest.Builder, Unit> function1, Continuation<? super RenameObjectResponse> continuation) {
        RenameObjectRequest.Builder builder = new RenameObjectRequest.Builder();
        function1.invoke(builder);
        return s3Client.renameObject(builder.build(), continuation);
    }

    public static final Object restoreObject(S3Client s3Client, Function1<? super RestoreObjectRequest.Builder, Unit> function1, Continuation<? super RestoreObjectResponse> continuation) {
        RestoreObjectRequest.Builder builder = new RestoreObjectRequest.Builder();
        function1.invoke(builder);
        return s3Client.restoreObject(builder.build(), continuation);
    }

    private static final Object restoreObject$$forInline(S3Client s3Client, Function1<? super RestoreObjectRequest.Builder, Unit> function1, Continuation<? super RestoreObjectResponse> continuation) {
        RestoreObjectRequest.Builder builder = new RestoreObjectRequest.Builder();
        function1.invoke(builder);
        return s3Client.restoreObject(builder.build(), continuation);
    }

    public static final Object updateBucketMetadataInventoryTableConfiguration(S3Client s3Client, Function1<? super UpdateBucketMetadataInventoryTableConfigurationRequest.Builder, Unit> function1, Continuation<? super UpdateBucketMetadataInventoryTableConfigurationResponse> continuation) {
        UpdateBucketMetadataInventoryTableConfigurationRequest.Builder builder = new UpdateBucketMetadataInventoryTableConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.updateBucketMetadataInventoryTableConfiguration(builder.build(), continuation);
    }

    private static final Object updateBucketMetadataInventoryTableConfiguration$$forInline(S3Client s3Client, Function1<? super UpdateBucketMetadataInventoryTableConfigurationRequest.Builder, Unit> function1, Continuation<? super UpdateBucketMetadataInventoryTableConfigurationResponse> continuation) {
        UpdateBucketMetadataInventoryTableConfigurationRequest.Builder builder = new UpdateBucketMetadataInventoryTableConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.updateBucketMetadataInventoryTableConfiguration(builder.build(), continuation);
    }

    public static final Object updateBucketMetadataJournalTableConfiguration(S3Client s3Client, Function1<? super UpdateBucketMetadataJournalTableConfigurationRequest.Builder, Unit> function1, Continuation<? super UpdateBucketMetadataJournalTableConfigurationResponse> continuation) {
        UpdateBucketMetadataJournalTableConfigurationRequest.Builder builder = new UpdateBucketMetadataJournalTableConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.updateBucketMetadataJournalTableConfiguration(builder.build(), continuation);
    }

    private static final Object updateBucketMetadataJournalTableConfiguration$$forInline(S3Client s3Client, Function1<? super UpdateBucketMetadataJournalTableConfigurationRequest.Builder, Unit> function1, Continuation<? super UpdateBucketMetadataJournalTableConfigurationResponse> continuation) {
        UpdateBucketMetadataJournalTableConfigurationRequest.Builder builder = new UpdateBucketMetadataJournalTableConfigurationRequest.Builder();
        function1.invoke(builder);
        return s3Client.updateBucketMetadataJournalTableConfiguration(builder.build(), continuation);
    }

    public static final Object updateObjectEncryption(S3Client s3Client, Function1<? super UpdateObjectEncryptionRequest.Builder, Unit> function1, Continuation<? super UpdateObjectEncryptionResponse> continuation) {
        UpdateObjectEncryptionRequest.Builder builder = new UpdateObjectEncryptionRequest.Builder();
        function1.invoke(builder);
        return s3Client.updateObjectEncryption(builder.build(), continuation);
    }

    private static final Object updateObjectEncryption$$forInline(S3Client s3Client, Function1<? super UpdateObjectEncryptionRequest.Builder, Unit> function1, Continuation<? super UpdateObjectEncryptionResponse> continuation) {
        UpdateObjectEncryptionRequest.Builder builder = new UpdateObjectEncryptionRequest.Builder();
        function1.invoke(builder);
        return s3Client.updateObjectEncryption(builder.build(), continuation);
    }

    public static final Object uploadPart(S3Client s3Client, Function1<? super UploadPartRequest.Builder, Unit> function1, Continuation<? super UploadPartResponse> continuation) {
        UploadPartRequest.Builder builder = new UploadPartRequest.Builder();
        function1.invoke(builder);
        return s3Client.uploadPart(builder.build(), continuation);
    }

    private static final Object uploadPart$$forInline(S3Client s3Client, Function1<? super UploadPartRequest.Builder, Unit> function1, Continuation<? super UploadPartResponse> continuation) {
        UploadPartRequest.Builder builder = new UploadPartRequest.Builder();
        function1.invoke(builder);
        return s3Client.uploadPart(builder.build(), continuation);
    }

    public static final Object uploadPartCopy(S3Client s3Client, Function1<? super UploadPartCopyRequest.Builder, Unit> function1, Continuation<? super UploadPartCopyResponse> continuation) {
        UploadPartCopyRequest.Builder builder = new UploadPartCopyRequest.Builder();
        function1.invoke(builder);
        return s3Client.uploadPartCopy(builder.build(), continuation);
    }

    private static final Object uploadPartCopy$$forInline(S3Client s3Client, Function1<? super UploadPartCopyRequest.Builder, Unit> function1, Continuation<? super UploadPartCopyResponse> continuation) {
        UploadPartCopyRequest.Builder builder = new UploadPartCopyRequest.Builder();
        function1.invoke(builder);
        return s3Client.uploadPartCopy(builder.build(), continuation);
    }

    public static final Object writeGetObjectResponse(S3Client s3Client, Function1<? super WriteGetObjectResponseRequest.Builder, Unit> function1, Continuation<? super WriteGetObjectResponseResponse> continuation) {
        WriteGetObjectResponseRequest.Builder builder = new WriteGetObjectResponseRequest.Builder();
        function1.invoke(builder);
        return s3Client.writeGetObjectResponse(builder.build(), continuation);
    }

    private static final Object writeGetObjectResponse$$forInline(S3Client s3Client, Function1<? super WriteGetObjectResponseRequest.Builder, Unit> function1, Continuation<? super WriteGetObjectResponseResponse> continuation) {
        WriteGetObjectResponseRequest.Builder builder = new WriteGetObjectResponseRequest.Builder();
        function1.invoke(builder);
        return s3Client.writeGetObjectResponse(builder.build(), continuation);
    }
}

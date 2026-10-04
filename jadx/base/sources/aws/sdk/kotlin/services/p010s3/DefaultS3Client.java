package aws.sdk.kotlin.services.p010s3;

import androidx.exifinterface.media.ExifInterface;
import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider;
import aws.sdk.kotlin.runtime.config.AwsSdkClientOption;
import aws.sdk.kotlin.runtime.http.ApiMetadata;
import aws.sdk.kotlin.runtime.http.AwsUserAgentMetadata;
import aws.sdk.kotlin.runtime.http.interceptors.AwsSpanInterceptor;
import aws.sdk.kotlin.runtime.http.interceptors.IgnoreCompositeFlexibleChecksumResponseInterceptor;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.AwsBusinessMetric;
import aws.sdk.kotlin.runtime.http.interceptors.businessmetrics.BusinessMetricsInterceptor;
import aws.sdk.kotlin.runtime.http.middleware.AwsRetryHeaderMiddleware;
import aws.sdk.kotlin.runtime.http.middleware.RecursionDetection;
import aws.sdk.kotlin.runtime.http.middleware.UserAgent;
import aws.sdk.kotlin.services.p010s3.S3Client;
import aws.sdk.kotlin.services.p010s3.auth.S3AuthSchemeProviderAdapter;
import aws.sdk.kotlin.services.p010s3.auth.S3IdentityProviderConfigAdapter;
import aws.sdk.kotlin.services.p010s3.endpoints.internal.EndpointResolverAdapter;
import aws.sdk.kotlin.services.p010s3.express.S3ExpressDefaultChecksumAlgorithm;
import aws.sdk.kotlin.services.p010s3.express.SigV4S3ExpressAuthScheme;
import aws.sdk.kotlin.services.p010s3.internal.ExpiresFieldInterceptor;
import aws.sdk.kotlin.services.p010s3.internal.Handle200ErrorsInterceptor;
import aws.sdk.kotlin.services.p010s3.model.AbortMultipartUploadRequest;
import aws.sdk.kotlin.services.p010s3.model.AbortMultipartUploadResponse;
import aws.sdk.kotlin.services.p010s3.model.ChecksumAlgorithm;
import aws.sdk.kotlin.services.p010s3.model.ChecksumMode;
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
import aws.sdk.kotlin.services.p010s3.model.GetObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectResponse;
import aws.sdk.kotlin.services.p010s3.model.GetObjectRetentionRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectRetentionResponse;
import aws.sdk.kotlin.services.p010s3.model.GetObjectTaggingRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectTaggingResponse;
import aws.sdk.kotlin.services.p010s3.model.GetObjectTorrentRequest;
import aws.sdk.kotlin.services.p010s3.model.GetObjectTorrentResponse;
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
import aws.sdk.kotlin.services.p010s3.model.SelectObjectContentRequest;
import aws.sdk.kotlin.services.p010s3.model.SelectObjectContentResponse;
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
import aws.sdk.kotlin.services.p010s3.serde.AbortMultipartUploadOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.AbortMultipartUploadOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.C3623x17887c98;
import aws.sdk.kotlin.services.p010s3.serde.C3625x1b5a8a97;
import aws.sdk.kotlin.services.p010s3.serde.C3626x928e16dd;
import aws.sdk.kotlin.services.p010s3.serde.CompleteMultipartUploadOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.CompleteMultipartUploadOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.CopyObjectOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.CopyObjectOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.CreateBucketMetadataConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.CreateBucketMetadataConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.CreateBucketMetadataTableConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.CreateBucketMetadataTableConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.CreateBucketOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.CreateBucketOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.CreateMultipartUploadOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.CreateMultipartUploadOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.CreateSessionOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.CreateSessionOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketAnalyticsConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketAnalyticsConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketCorsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketCorsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketEncryptionOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketEncryptionOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketIntelligentTieringConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketIntelligentTieringConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketInventoryConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketInventoryConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketLifecycleOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketLifecycleOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketMetadataConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketMetadataConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketMetadataTableConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketMetadataTableConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketMetricsConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketMetricsConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketOwnershipControlsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketOwnershipControlsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketPolicyOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketPolicyOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketReplicationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketReplicationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketTaggingOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketTaggingOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketWebsiteOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteBucketWebsiteOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteObjectOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteObjectOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteObjectTaggingOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteObjectTaggingOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteObjectsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeleteObjectsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.DeletePublicAccessBlockOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.DeletePublicAccessBlockOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketAbacOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketAbacOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketAccelerateConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketAccelerateConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketAclOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketAclOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketAnalyticsConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketAnalyticsConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketCorsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketCorsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketEncryptionOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketEncryptionOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketIntelligentTieringConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketIntelligentTieringConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketInventoryConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketInventoryConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketLifecycleConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketLifecycleConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketLocationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketLocationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketLoggingOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketLoggingOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketMetadataConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketMetadataConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketMetadataTableConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketMetadataTableConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketMetricsConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketMetricsConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketNotificationConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketNotificationConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketOwnershipControlsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketOwnershipControlsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketPolicyOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketPolicyOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketPolicyStatusOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketPolicyStatusOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketReplicationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketReplicationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketRequestPaymentOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketRequestPaymentOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketTaggingOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketTaggingOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketVersioningOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketVersioningOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketWebsiteOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetBucketWebsiteOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectAclOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectAclOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectAttributesOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectAttributesOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectLegalHoldOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectLegalHoldOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectLockConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectLockConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectRetentionOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectRetentionOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectTaggingOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectTaggingOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectTorrentOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetObjectTorrentOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.GetPublicAccessBlockOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.GetPublicAccessBlockOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.HeadBucketOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.HeadBucketOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.HeadObjectOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.HeadObjectOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.ListBucketAnalyticsConfigurationsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.ListBucketAnalyticsConfigurationsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.ListBucketIntelligentTieringConfigurationsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.ListBucketIntelligentTieringConfigurationsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.ListBucketInventoryConfigurationsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.ListBucketInventoryConfigurationsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.ListBucketMetricsConfigurationsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.ListBucketMetricsConfigurationsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.ListBucketsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.ListBucketsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.ListDirectoryBucketsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.ListDirectoryBucketsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.ListMultipartUploadsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.ListMultipartUploadsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.ListObjectVersionsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.ListObjectVersionsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.ListObjectsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.ListObjectsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.ListObjectsV2OperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.ListObjectsV2OperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.ListPartsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.ListPartsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketAbacOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketAbacOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketAccelerateConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketAccelerateConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketAclOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketAclOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketAnalyticsConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketAnalyticsConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketCorsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketCorsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketEncryptionOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketEncryptionOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketIntelligentTieringConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketIntelligentTieringConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketInventoryConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketInventoryConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketLifecycleConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketLifecycleConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketLoggingOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketLoggingOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketMetricsConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketMetricsConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketNotificationConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketNotificationConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketOwnershipControlsOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketOwnershipControlsOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketPolicyOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketPolicyOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketReplicationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketReplicationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketRequestPaymentOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketRequestPaymentOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketTaggingOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketTaggingOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketVersioningOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketVersioningOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketWebsiteOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutBucketWebsiteOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutObjectAclOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutObjectAclOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutObjectLegalHoldOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutObjectLegalHoldOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutObjectLockConfigurationOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutObjectLockConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutObjectOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutObjectOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutObjectRetentionOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutObjectRetentionOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutObjectTaggingOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutObjectTaggingOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.PutPublicAccessBlockOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.PutPublicAccessBlockOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.RenameObjectOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.RenameObjectOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.RestoreObjectOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.RestoreObjectOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.SelectObjectContentOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.SelectObjectContentOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.UpdateBucketMetadataJournalTableConfigurationOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.UpdateObjectEncryptionOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.UpdateObjectEncryptionOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.UploadPartCopyOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.UploadPartCopyOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.UploadPartOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.UploadPartOperationSerializer;
import aws.sdk.kotlin.services.p010s3.serde.WriteGetObjectResponseOperationDeserializer;
import aws.sdk.kotlin.services.p010s3.serde.WriteGetObjectResponseOperationSerializer;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSignedBodyHeader;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningAttributes;
import aws.smithy.kotlin.runtime.auth.awssigning.DefaultAwsSignerJVMKt;
import aws.smithy.kotlin.runtime.awsprotocol.AwsAttributes;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.businessmetrics.SmithyBusinessMetric;
import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.client.SdkClientOption;
import aws.smithy.kotlin.runtime.client.config.RequestHttpChecksumConfig;
import aws.smithy.kotlin.runtime.client.config.ResponseHttpChecksumConfig;
import aws.smithy.kotlin.runtime.collections.AttributesBuilder;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.SdkHttpClient;
import aws.smithy.kotlin.runtime.http.auth.AuthScheme;
import aws.smithy.kotlin.runtime.http.auth.SigV4AsymmetricAuthScheme;
import aws.smithy.kotlin.runtime.http.auth.SigV4AuthScheme;
import aws.smithy.kotlin.runtime.http.interceptors.ContinueInterceptor;
import aws.smithy.kotlin.runtime.http.interceptors.FlexibleChecksumsRequestInterceptor;
import aws.smithy.kotlin.runtime.http.interceptors.ResponseLengthValidationInterceptor;
import aws.smithy.kotlin.runtime.http.operation.HttpOperationContext;
import aws.smithy.kotlin.runtime.http.operation.OperationAuthConfig;
import aws.smithy.kotlin.runtime.http.operation.OperationMetrics;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationBuilder;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt;
import aws.smithy.kotlin.runtime.http.operation.SdkOperationTelemetry;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.p011io.SdkManagedGroup;
import aws.smithy.kotlin.runtime.p011io.SdkManagedGroupKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DefaultS3Client.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000ì\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020%H\u0096@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020)H\u0096@¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020,2\u0006\u0010\u001c\u001a\u00020-H\u0096@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u0002002\u0006\u0010\u001c\u001a\u000201H\u0096@¢\u0006\u0002\u00102J\u0016\u00103\u001a\u0002042\u0006\u0010\u001c\u001a\u000205H\u0096@¢\u0006\u0002\u00106J\u0016\u00107\u001a\u0002082\u0006\u0010\u001c\u001a\u000209H\u0096@¢\u0006\u0002\u0010:J\u0016\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020=H\u0096@¢\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020@2\u0006\u0010\u001c\u001a\u00020AH\u0096@¢\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020D2\u0006\u0010\u001c\u001a\u00020EH\u0096@¢\u0006\u0002\u0010FJ\u0016\u0010G\u001a\u00020H2\u0006\u0010\u001c\u001a\u00020IH\u0096@¢\u0006\u0002\u0010JJ\u0016\u0010K\u001a\u00020L2\u0006\u0010\u001c\u001a\u00020MH\u0096@¢\u0006\u0002\u0010NJ\u0016\u0010O\u001a\u00020P2\u0006\u0010\u001c\u001a\u00020QH\u0096@¢\u0006\u0002\u0010RJ\u0016\u0010S\u001a\u00020T2\u0006\u0010\u001c\u001a\u00020UH\u0096@¢\u0006\u0002\u0010VJ\u0016\u0010W\u001a\u00020X2\u0006\u0010\u001c\u001a\u00020YH\u0096@¢\u0006\u0002\u0010ZJ\u0016\u0010[\u001a\u00020\\2\u0006\u0010\u001c\u001a\u00020]H\u0096@¢\u0006\u0002\u0010^J\u0016\u0010_\u001a\u00020`2\u0006\u0010\u001c\u001a\u00020aH\u0096@¢\u0006\u0002\u0010bJ\u0016\u0010c\u001a\u00020d2\u0006\u0010\u001c\u001a\u00020eH\u0096@¢\u0006\u0002\u0010fJ\u0016\u0010g\u001a\u00020h2\u0006\u0010\u001c\u001a\u00020iH\u0096@¢\u0006\u0002\u0010jJ\u0016\u0010k\u001a\u00020l2\u0006\u0010\u001c\u001a\u00020mH\u0096@¢\u0006\u0002\u0010nJ\u0016\u0010o\u001a\u00020p2\u0006\u0010\u001c\u001a\u00020qH\u0096@¢\u0006\u0002\u0010rJ\u0016\u0010s\u001a\u00020t2\u0006\u0010\u001c\u001a\u00020uH\u0096@¢\u0006\u0002\u0010vJ\u0016\u0010w\u001a\u00020x2\u0006\u0010\u001c\u001a\u00020yH\u0096@¢\u0006\u0002\u0010zJ\u0016\u0010{\u001a\u00020|2\u0006\u0010\u001c\u001a\u00020}H\u0096@¢\u0006\u0002\u0010~J\u0019\u0010\u007f\u001a\u00030\u0080\u00012\u0007\u0010\u001c\u001a\u00030\u0081\u0001H\u0096@¢\u0006\u0003\u0010\u0082\u0001J\u001a\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u001c\u001a\u00030\u0085\u0001H\u0096@¢\u0006\u0003\u0010\u0086\u0001J\u001a\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u001c\u001a\u00030\u0089\u0001H\u0096@¢\u0006\u0003\u0010\u008a\u0001J\u001a\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010\u001c\u001a\u00030\u008d\u0001H\u0096@¢\u0006\u0003\u0010\u008e\u0001J\u001a\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u001c\u001a\u00030\u0091\u0001H\u0096@¢\u0006\u0003\u0010\u0092\u0001J\u001a\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u001c\u001a\u00030\u0095\u0001H\u0096@¢\u0006\u0003\u0010\u0096\u0001J\u001a\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u001c\u001a\u00030\u0099\u0001H\u0096@¢\u0006\u0003\u0010\u009a\u0001J\u001a\u0010\u009b\u0001\u001a\u00030\u009c\u00012\u0007\u0010\u001c\u001a\u00030\u009d\u0001H\u0096@¢\u0006\u0003\u0010\u009e\u0001J\u001a\u0010\u009f\u0001\u001a\u00030 \u00012\u0007\u0010\u001c\u001a\u00030¡\u0001H\u0096@¢\u0006\u0003\u0010¢\u0001J\u001a\u0010£\u0001\u001a\u00030¤\u00012\u0007\u0010\u001c\u001a\u00030¥\u0001H\u0096@¢\u0006\u0003\u0010¦\u0001J\u001a\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010\u001c\u001a\u00030©\u0001H\u0096@¢\u0006\u0003\u0010ª\u0001J\u001a\u0010«\u0001\u001a\u00030¬\u00012\u0007\u0010\u001c\u001a\u00030\u00ad\u0001H\u0096@¢\u0006\u0003\u0010®\u0001J\u001a\u0010¯\u0001\u001a\u00030°\u00012\u0007\u0010\u001c\u001a\u00030±\u0001H\u0096@¢\u0006\u0003\u0010²\u0001J\u001a\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010\u001c\u001a\u00030µ\u0001H\u0096@¢\u0006\u0003\u0010¶\u0001J\u001a\u0010·\u0001\u001a\u00030¸\u00012\u0007\u0010\u001c\u001a\u00030¹\u0001H\u0096@¢\u0006\u0003\u0010º\u0001J\u001a\u0010»\u0001\u001a\u00030¼\u00012\u0007\u0010\u001c\u001a\u00030½\u0001H\u0096@¢\u0006\u0003\u0010¾\u0001J\u001a\u0010¿\u0001\u001a\u00030À\u00012\u0007\u0010\u001c\u001a\u00030Á\u0001H\u0096@¢\u0006\u0003\u0010Â\u0001J\u001a\u0010Ã\u0001\u001a\u00030Ä\u00012\u0007\u0010\u001c\u001a\u00030Å\u0001H\u0096@¢\u0006\u0003\u0010Æ\u0001J\u001a\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010\u001c\u001a\u00030É\u0001H\u0096@¢\u0006\u0003\u0010Ê\u0001J\u001a\u0010Ë\u0001\u001a\u00030Ì\u00012\u0007\u0010\u001c\u001a\u00030Í\u0001H\u0096@¢\u0006\u0003\u0010Î\u0001J\u001a\u0010Ï\u0001\u001a\u00030Ð\u00012\u0007\u0010\u001c\u001a\u00030Ñ\u0001H\u0096@¢\u0006\u0003\u0010Ò\u0001J\u001a\u0010Ó\u0001\u001a\u00030Ô\u00012\u0007\u0010\u001c\u001a\u00030Õ\u0001H\u0096@¢\u0006\u0003\u0010Ö\u0001J\u001a\u0010×\u0001\u001a\u00030Ø\u00012\u0007\u0010\u001c\u001a\u00030Ù\u0001H\u0096@¢\u0006\u0003\u0010Ú\u0001J\u001a\u0010Û\u0001\u001a\u00030Ü\u00012\u0007\u0010\u001c\u001a\u00030Ý\u0001H\u0096@¢\u0006\u0003\u0010Þ\u0001J\u001a\u0010ß\u0001\u001a\u00030à\u00012\u0007\u0010\u001c\u001a\u00030á\u0001H\u0096@¢\u0006\u0003\u0010â\u0001JK\u0010ã\u0001\u001a\u0003Hä\u0001\"\u0005\b\u0000\u0010ä\u00012\u0007\u0010\u001c\u001a\u00030å\u00012(\u0010æ\u0001\u001a#\b\u0001\u0012\u0005\u0012\u00030è\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u0003Hä\u00010é\u0001\u0012\u0007\u0012\u0005\u0018\u00010ê\u00010ç\u0001H\u0096@¢\u0006\u0003\u0010ë\u0001J\u001a\u0010ì\u0001\u001a\u00030í\u00012\u0007\u0010\u001c\u001a\u00030î\u0001H\u0096@¢\u0006\u0003\u0010ï\u0001J\u001a\u0010ð\u0001\u001a\u00030ñ\u00012\u0007\u0010\u001c\u001a\u00030ò\u0001H\u0096@¢\u0006\u0003\u0010ó\u0001J\u001a\u0010ô\u0001\u001a\u00030õ\u00012\u0007\u0010\u001c\u001a\u00030ö\u0001H\u0096@¢\u0006\u0003\u0010÷\u0001J\u001a\u0010ø\u0001\u001a\u00030ù\u00012\u0007\u0010\u001c\u001a\u00030ú\u0001H\u0096@¢\u0006\u0003\u0010û\u0001J\u001a\u0010ü\u0001\u001a\u00030ý\u00012\u0007\u0010\u001c\u001a\u00030þ\u0001H\u0096@¢\u0006\u0003\u0010ÿ\u0001J\u001a\u0010\u0080\u0002\u001a\u00030\u0081\u00022\u0007\u0010\u001c\u001a\u00030\u0082\u0002H\u0096@¢\u0006\u0003\u0010\u0083\u0002JK\u0010\u0084\u0002\u001a\u0003Hä\u0001\"\u0005\b\u0000\u0010ä\u00012\u0007\u0010\u001c\u001a\u00030\u0085\u00022(\u0010æ\u0001\u001a#\b\u0001\u0012\u0005\u0012\u00030\u0086\u0002\u0012\f\u0012\n\u0012\u0005\u0012\u0003Hä\u00010é\u0001\u0012\u0007\u0012\u0005\u0018\u00010ê\u00010ç\u0001H\u0096@¢\u0006\u0003\u0010\u0087\u0002J\u001a\u0010\u0088\u0002\u001a\u00030\u0089\u00022\u0007\u0010\u001c\u001a\u00030\u008a\u0002H\u0096@¢\u0006\u0003\u0010\u008b\u0002J\u001a\u0010\u008c\u0002\u001a\u00030\u008d\u00022\u0007\u0010\u001c\u001a\u00030\u008e\u0002H\u0096@¢\u0006\u0003\u0010\u008f\u0002J\u001a\u0010\u0090\u0002\u001a\u00030\u0091\u00022\u0007\u0010\u001c\u001a\u00030\u0092\u0002H\u0096@¢\u0006\u0003\u0010\u0093\u0002J\u001a\u0010\u0094\u0002\u001a\u00030\u0095\u00022\u0007\u0010\u001c\u001a\u00030\u0096\u0002H\u0096@¢\u0006\u0003\u0010\u0097\u0002J\u001a\u0010\u0098\u0002\u001a\u00030\u0099\u00022\u0007\u0010\u001c\u001a\u00030\u009a\u0002H\u0096@¢\u0006\u0003\u0010\u009b\u0002J\u001a\u0010\u009c\u0002\u001a\u00030\u009d\u00022\u0007\u0010\u001c\u001a\u00030\u009e\u0002H\u0096@¢\u0006\u0003\u0010\u009f\u0002J\u001a\u0010 \u0002\u001a\u00030¡\u00022\u0007\u0010\u001c\u001a\u00030¢\u0002H\u0096@¢\u0006\u0003\u0010£\u0002J\u001a\u0010¤\u0002\u001a\u00030¥\u00022\u0007\u0010\u001c\u001a\u00030¦\u0002H\u0096@¢\u0006\u0003\u0010§\u0002J\u001a\u0010¨\u0002\u001a\u00030©\u00022\u0007\u0010\u001c\u001a\u00030ª\u0002H\u0096@¢\u0006\u0003\u0010«\u0002J\u001a\u0010¬\u0002\u001a\u00030\u00ad\u00022\u0007\u0010\u001c\u001a\u00030®\u0002H\u0096@¢\u0006\u0003\u0010¯\u0002J\u001a\u0010°\u0002\u001a\u00030±\u00022\u0007\u0010\u001c\u001a\u00030²\u0002H\u0096@¢\u0006\u0003\u0010³\u0002J\u001a\u0010´\u0002\u001a\u00030µ\u00022\u0007\u0010\u001c\u001a\u00030¶\u0002H\u0096@¢\u0006\u0003\u0010·\u0002J\u001a\u0010¸\u0002\u001a\u00030¹\u00022\u0007\u0010\u001c\u001a\u00030º\u0002H\u0096@¢\u0006\u0003\u0010»\u0002J\u001a\u0010¼\u0002\u001a\u00030½\u00022\u0007\u0010\u001c\u001a\u00030¾\u0002H\u0096@¢\u0006\u0003\u0010¿\u0002J\u001a\u0010À\u0002\u001a\u00030Á\u00022\u0007\u0010\u001c\u001a\u00030Â\u0002H\u0096@¢\u0006\u0003\u0010Ã\u0002J\u001a\u0010Ä\u0002\u001a\u00030Å\u00022\u0007\u0010\u001c\u001a\u00030Æ\u0002H\u0096@¢\u0006\u0003\u0010Ç\u0002J\u001a\u0010È\u0002\u001a\u00030É\u00022\u0007\u0010\u001c\u001a\u00030Ê\u0002H\u0096@¢\u0006\u0003\u0010Ë\u0002J\u001a\u0010Ì\u0002\u001a\u00030Í\u00022\u0007\u0010\u001c\u001a\u00030Î\u0002H\u0096@¢\u0006\u0003\u0010Ï\u0002J\u001a\u0010Ð\u0002\u001a\u00030Ñ\u00022\u0007\u0010\u001c\u001a\u00030Ò\u0002H\u0096@¢\u0006\u0003\u0010Ó\u0002J\u001a\u0010Ô\u0002\u001a\u00030Õ\u00022\u0007\u0010\u001c\u001a\u00030Ö\u0002H\u0096@¢\u0006\u0003\u0010×\u0002J\u001a\u0010Ø\u0002\u001a\u00030Ù\u00022\u0007\u0010\u001c\u001a\u00030Ú\u0002H\u0096@¢\u0006\u0003\u0010Û\u0002J\u001a\u0010Ü\u0002\u001a\u00030Ý\u00022\u0007\u0010\u001c\u001a\u00030Þ\u0002H\u0096@¢\u0006\u0003\u0010ß\u0002J\u001a\u0010à\u0002\u001a\u00030á\u00022\u0007\u0010\u001c\u001a\u00030â\u0002H\u0096@¢\u0006\u0003\u0010ã\u0002J\u001a\u0010ä\u0002\u001a\u00030å\u00022\u0007\u0010\u001c\u001a\u00030æ\u0002H\u0096@¢\u0006\u0003\u0010ç\u0002J\u001a\u0010è\u0002\u001a\u00030é\u00022\u0007\u0010\u001c\u001a\u00030ê\u0002H\u0096@¢\u0006\u0003\u0010ë\u0002J\u001a\u0010ì\u0002\u001a\u00030í\u00022\u0007\u0010\u001c\u001a\u00030î\u0002H\u0096@¢\u0006\u0003\u0010ï\u0002J\u001a\u0010ð\u0002\u001a\u00030ñ\u00022\u0007\u0010\u001c\u001a\u00030ò\u0002H\u0096@¢\u0006\u0003\u0010ó\u0002J\u001a\u0010ô\u0002\u001a\u00030õ\u00022\u0007\u0010\u001c\u001a\u00030ö\u0002H\u0096@¢\u0006\u0003\u0010÷\u0002J\u001a\u0010ø\u0002\u001a\u00030ù\u00022\u0007\u0010\u001c\u001a\u00030ú\u0002H\u0096@¢\u0006\u0003\u0010û\u0002J\u001a\u0010ü\u0002\u001a\u00030ý\u00022\u0007\u0010\u001c\u001a\u00030þ\u0002H\u0096@¢\u0006\u0003\u0010ÿ\u0002J\u001a\u0010\u0080\u0003\u001a\u00030\u0081\u00032\u0007\u0010\u001c\u001a\u00030\u0082\u0003H\u0096@¢\u0006\u0003\u0010\u0083\u0003J\u001a\u0010\u0084\u0003\u001a\u00030\u0085\u00032\u0007\u0010\u001c\u001a\u00030\u0086\u0003H\u0096@¢\u0006\u0003\u0010\u0087\u0003J\u001a\u0010\u0088\u0003\u001a\u00030\u0089\u00032\u0007\u0010\u001c\u001a\u00030\u008a\u0003H\u0096@¢\u0006\u0003\u0010\u008b\u0003J\u001a\u0010\u008c\u0003\u001a\u00030\u008d\u00032\u0007\u0010\u001c\u001a\u00030\u008e\u0003H\u0096@¢\u0006\u0003\u0010\u008f\u0003J\u001a\u0010\u0090\u0003\u001a\u00030\u0091\u00032\u0007\u0010\u001c\u001a\u00030\u0092\u0003H\u0096@¢\u0006\u0003\u0010\u0093\u0003J\u001a\u0010\u0094\u0003\u001a\u00030\u0095\u00032\u0007\u0010\u001c\u001a\u00030\u0096\u0003H\u0096@¢\u0006\u0003\u0010\u0097\u0003J\u001a\u0010\u0098\u0003\u001a\u00030\u0099\u00032\u0007\u0010\u001c\u001a\u00030\u009a\u0003H\u0096@¢\u0006\u0003\u0010\u009b\u0003J\u001a\u0010\u009c\u0003\u001a\u00030\u009d\u00032\u0007\u0010\u001c\u001a\u00030\u009e\u0003H\u0096@¢\u0006\u0003\u0010\u009f\u0003J\u001a\u0010 \u0003\u001a\u00030¡\u00032\u0007\u0010\u001c\u001a\u00030¢\u0003H\u0096@¢\u0006\u0003\u0010£\u0003J\u001a\u0010¤\u0003\u001a\u00030¥\u00032\u0007\u0010\u001c\u001a\u00030¦\u0003H\u0096@¢\u0006\u0003\u0010§\u0003J\u001a\u0010¨\u0003\u001a\u00030©\u00032\u0007\u0010\u001c\u001a\u00030ª\u0003H\u0096@¢\u0006\u0003\u0010«\u0003J\u001a\u0010¬\u0003\u001a\u00030\u00ad\u00032\u0007\u0010\u001c\u001a\u00030®\u0003H\u0096@¢\u0006\u0003\u0010¯\u0003JK\u0010°\u0003\u001a\u0003Hä\u0001\"\u0005\b\u0000\u0010ä\u00012\u0007\u0010\u001c\u001a\u00030±\u00032(\u0010æ\u0001\u001a#\b\u0001\u0012\u0005\u0012\u00030²\u0003\u0012\f\u0012\n\u0012\u0005\u0012\u0003Hä\u00010é\u0001\u0012\u0007\u0012\u0005\u0018\u00010ê\u00010ç\u0001H\u0096@¢\u0006\u0003\u0010³\u0003J\u001a\u0010´\u0003\u001a\u00030µ\u00032\u0007\u0010\u001c\u001a\u00030¶\u0003H\u0096@¢\u0006\u0003\u0010·\u0003J\u001a\u0010¸\u0003\u001a\u00030¹\u00032\u0007\u0010\u001c\u001a\u00030º\u0003H\u0096@¢\u0006\u0003\u0010»\u0003J\u001a\u0010¼\u0003\u001a\u00030½\u00032\u0007\u0010\u001c\u001a\u00030¾\u0003H\u0096@¢\u0006\u0003\u0010¿\u0003J\u001a\u0010À\u0003\u001a\u00030Á\u00032\u0007\u0010\u001c\u001a\u00030Â\u0003H\u0096@¢\u0006\u0003\u0010Ã\u0003J\u001a\u0010Ä\u0003\u001a\u00030Å\u00032\u0007\u0010\u001c\u001a\u00030Æ\u0003H\u0096@¢\u0006\u0003\u0010Ç\u0003J\u001a\u0010È\u0003\u001a\u00030É\u00032\u0007\u0010\u001c\u001a\u00030Ê\u0003H\u0096@¢\u0006\u0003\u0010Ë\u0003J\n\u0010Ì\u0003\u001a\u00030Í\u0003H\u0016J\u0014\u0010Î\u0003\u001a\u00030Í\u00032\b\u0010Ï\u0003\u001a\u00030Ð\u0003H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Ñ\u0003"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/DefaultS3Client;", "Laws/sdk/kotlin/services/s3/S3Client;", "config", "Laws/sdk/kotlin/services/s3/S3Client$Config;", "<init>", "(Laws/sdk/kotlin/services/s3/S3Client$Config;)V", "getConfig", "()Laws/sdk/kotlin/services/s3/S3Client$Config;", "managedResources", "Laws/smithy/kotlin/runtime/io/SdkManagedGroup;", "client", "Laws/smithy/kotlin/runtime/http/SdkHttpClient;", "identityProviderConfig", "Laws/sdk/kotlin/services/s3/auth/S3IdentityProviderConfigAdapter;", "configuredAuthSchemes", "", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "authSchemeAdapter", "Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeProviderAdapter;", "telemetryScope", "", "opMetrics", "Laws/smithy/kotlin/runtime/http/operation/OperationMetrics;", "awsUserAgentMetadata", "Laws/sdk/kotlin/runtime/http/AwsUserAgentMetadata;", "abortMultipartUpload", "Laws/sdk/kotlin/services/s3/model/AbortMultipartUploadResponse;", "input", "Laws/sdk/kotlin/services/s3/model/AbortMultipartUploadRequest;", "(Laws/sdk/kotlin/services/s3/model/AbortMultipartUploadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeMultipartUpload", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadResponse;", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest;", "(Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyObject", "Laws/sdk/kotlin/services/s3/model/CopyObjectResponse;", "Laws/sdk/kotlin/services/s3/model/CopyObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/CopyObjectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBucket", "Laws/sdk/kotlin/services/s3/model/CreateBucketResponse;", "Laws/sdk/kotlin/services/s3/model/CreateBucketRequest;", "(Laws/sdk/kotlin/services/s3/model/CreateBucketRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBucketMetadataConfiguration", "Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBucketMetadataTableConfiguration", "Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataTableConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataTableConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createMultipartUpload", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadResponse;", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest;", "(Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSession", "Laws/sdk/kotlin/services/s3/model/CreateSessionResponse;", "Laws/sdk/kotlin/services/s3/model/CreateSessionRequest;", "(Laws/sdk/kotlin/services/s3/model/CreateSessionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucket", "Laws/sdk/kotlin/services/s3/model/DeleteBucketResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketAnalyticsConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketAnalyticsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketAnalyticsConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketAnalyticsConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketCors", "Laws/sdk/kotlin/services/s3/model/DeleteBucketCorsResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketCorsRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketCorsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketEncryption", "Laws/sdk/kotlin/services/s3/model/DeleteBucketEncryptionResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketEncryptionRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketEncryptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketIntelligentTieringConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketIntelligentTieringConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketIntelligentTieringConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketIntelligentTieringConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketInventoryConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketInventoryConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketInventoryConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketInventoryConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketLifecycle", "Laws/sdk/kotlin/services/s3/model/DeleteBucketLifecycleResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketLifecycleRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketLifecycleRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketMetadataConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketMetadataTableConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataTableConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataTableConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketMetricsConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetricsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetricsConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketMetricsConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketOwnershipControls", "Laws/sdk/kotlin/services/s3/model/DeleteBucketOwnershipControlsResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketOwnershipControlsRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketOwnershipControlsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketPolicy", "Laws/sdk/kotlin/services/s3/model/DeleteBucketPolicyResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketPolicyRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketPolicyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketReplication", "Laws/sdk/kotlin/services/s3/model/DeleteBucketReplicationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketReplicationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketReplicationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketTagging", "Laws/sdk/kotlin/services/s3/model/DeleteBucketTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketTaggingRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketTaggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketWebsite", "Laws/sdk/kotlin/services/s3/model/DeleteBucketWebsiteResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketWebsiteRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketWebsiteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteObject", "Laws/sdk/kotlin/services/s3/model/DeleteObjectResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteObjectTagging", "Laws/sdk/kotlin/services/s3/model/DeleteObjectTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteObjectTaggingRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectTaggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteObjects", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePublicAccessBlock", "Laws/sdk/kotlin/services/s3/model/DeletePublicAccessBlockResponse;", "Laws/sdk/kotlin/services/s3/model/DeletePublicAccessBlockRequest;", "(Laws/sdk/kotlin/services/s3/model/DeletePublicAccessBlockRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketAbac", "Laws/sdk/kotlin/services/s3/model/GetBucketAbacResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketAbacRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketAbacRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketAccelerateConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketAccelerateConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketAccelerateConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketAccelerateConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketAcl", "Laws/sdk/kotlin/services/s3/model/GetBucketAclResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketAclRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketAclRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketAnalyticsConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketAnalyticsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketAnalyticsConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketAnalyticsConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketCors", "Laws/sdk/kotlin/services/s3/model/GetBucketCorsResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketCorsRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketCorsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketEncryption", "Laws/sdk/kotlin/services/s3/model/GetBucketEncryptionResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketEncryptionRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketEncryptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketIntelligentTieringConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketInventoryConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketInventoryConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketInventoryConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketInventoryConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketLifecycleConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketLocation", "Laws/sdk/kotlin/services/s3/model/GetBucketLocationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketLocationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketLocationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketLogging", "Laws/sdk/kotlin/services/s3/model/GetBucketLoggingResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketLoggingRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketLoggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketMetadataConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketMetadataConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketMetadataTableConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketMetricsConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketMetricsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketMetricsConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketMetricsConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketNotificationConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketOwnershipControls", "Laws/sdk/kotlin/services/s3/model/GetBucketOwnershipControlsResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketOwnershipControlsRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketOwnershipControlsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketPolicy", "Laws/sdk/kotlin/services/s3/model/GetBucketPolicyResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketPolicyRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketPolicyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketPolicyStatus", "Laws/sdk/kotlin/services/s3/model/GetBucketPolicyStatusResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketPolicyStatusRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketPolicyStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketReplication", "Laws/sdk/kotlin/services/s3/model/GetBucketReplicationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketReplicationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketReplicationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketRequestPayment", "Laws/sdk/kotlin/services/s3/model/GetBucketRequestPaymentResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketRequestPaymentRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketRequestPaymentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketTagging", "Laws/sdk/kotlin/services/s3/model/GetBucketTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketTaggingRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketTaggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketVersioning", "Laws/sdk/kotlin/services/s3/model/GetBucketVersioningResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketVersioningRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketVersioningRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketWebsite", "Laws/sdk/kotlin/services/s3/model/GetBucketWebsiteResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketWebsiteRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketWebsiteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObject", ExifInterface.GPS_DIRECTION_TRUE, "Laws/sdk/kotlin/services/s3/model/GetObjectRequest;", "block", "Lkotlin/Function2;", "Laws/sdk/kotlin/services/s3/model/GetObjectResponse;", "Lkotlin/coroutines/Continuation;", "", "(Laws/sdk/kotlin/services/s3/model/GetObjectRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectAcl", "Laws/sdk/kotlin/services/s3/model/GetObjectAclResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectAclRequest;", "(Laws/sdk/kotlin/services/s3/model/GetObjectAclRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectAttributes", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesRequest;", "(Laws/sdk/kotlin/services/s3/model/GetObjectAttributesRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectLegalHold", "Laws/sdk/kotlin/services/s3/model/GetObjectLegalHoldResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectLegalHoldRequest;", "(Laws/sdk/kotlin/services/s3/model/GetObjectLegalHoldRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectLockConfiguration", "Laws/sdk/kotlin/services/s3/model/GetObjectLockConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectLockConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetObjectLockConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectRetention", "Laws/sdk/kotlin/services/s3/model/GetObjectRetentionResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectRetentionRequest;", "(Laws/sdk/kotlin/services/s3/model/GetObjectRetentionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectTagging", "Laws/sdk/kotlin/services/s3/model/GetObjectTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectTaggingRequest;", "(Laws/sdk/kotlin/services/s3/model/GetObjectTaggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectTorrent", "Laws/sdk/kotlin/services/s3/model/GetObjectTorrentRequest;", "Laws/sdk/kotlin/services/s3/model/GetObjectTorrentResponse;", "(Laws/sdk/kotlin/services/s3/model/GetObjectTorrentRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPublicAccessBlock", "Laws/sdk/kotlin/services/s3/model/GetPublicAccessBlockResponse;", "Laws/sdk/kotlin/services/s3/model/GetPublicAccessBlockRequest;", "(Laws/sdk/kotlin/services/s3/model/GetPublicAccessBlockRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "headBucket", "Laws/sdk/kotlin/services/s3/model/HeadBucketResponse;", "Laws/sdk/kotlin/services/s3/model/HeadBucketRequest;", "(Laws/sdk/kotlin/services/s3/model/HeadBucketRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "headObject", "Laws/sdk/kotlin/services/s3/model/HeadObjectResponse;", "Laws/sdk/kotlin/services/s3/model/HeadObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/HeadObjectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listBucketAnalyticsConfigurations", "Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listBucketIntelligentTieringConfigurations", "Laws/sdk/kotlin/services/s3/model/ListBucketIntelligentTieringConfigurationsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketIntelligentTieringConfigurationsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListBucketIntelligentTieringConfigurationsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listBucketInventoryConfigurations", "Laws/sdk/kotlin/services/s3/model/ListBucketInventoryConfigurationsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketInventoryConfigurationsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListBucketInventoryConfigurationsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listBucketMetricsConfigurations", "Laws/sdk/kotlin/services/s3/model/ListBucketMetricsConfigurationsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketMetricsConfigurationsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListBucketMetricsConfigurationsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listBuckets", "Laws/sdk/kotlin/services/s3/model/ListBucketsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListBucketsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listDirectoryBuckets", "Laws/sdk/kotlin/services/s3/model/ListDirectoryBucketsResponse;", "Laws/sdk/kotlin/services/s3/model/ListDirectoryBucketsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListDirectoryBucketsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listMultipartUploads", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsResponse;", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listObjectVersions", "Laws/sdk/kotlin/services/s3/model/ListObjectVersionsResponse;", "Laws/sdk/kotlin/services/s3/model/ListObjectVersionsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListObjectVersionsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listObjects", "Laws/sdk/kotlin/services/s3/model/ListObjectsResponse;", "Laws/sdk/kotlin/services/s3/model/ListObjectsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListObjectsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listObjectsV2", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Response;", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request;", "(Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listParts", "Laws/sdk/kotlin/services/s3/model/ListPartsResponse;", "Laws/sdk/kotlin/services/s3/model/ListPartsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListPartsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketAbac", "Laws/sdk/kotlin/services/s3/model/PutBucketAbacResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketAbacRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketAbacRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketAccelerateConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketAccelerateConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketAccelerateConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketAccelerateConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketAcl", "Laws/sdk/kotlin/services/s3/model/PutBucketAclResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketAnalyticsConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketCors", "Laws/sdk/kotlin/services/s3/model/PutBucketCorsResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketCorsRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketCorsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketEncryption", "Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketIntelligentTieringConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketIntelligentTieringConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketIntelligentTieringConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketIntelligentTieringConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketInventoryConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketInventoryConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketInventoryConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketInventoryConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketLifecycleConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketLogging", "Laws/sdk/kotlin/services/s3/model/PutBucketLoggingResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketLoggingRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketLoggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketMetricsConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketMetricsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketMetricsConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketMetricsConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketNotificationConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketNotificationConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketNotificationConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketNotificationConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketOwnershipControls", "Laws/sdk/kotlin/services/s3/model/PutBucketOwnershipControlsResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketOwnershipControlsRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketOwnershipControlsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketPolicy", "Laws/sdk/kotlin/services/s3/model/PutBucketPolicyResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketPolicyRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketPolicyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketReplication", "Laws/sdk/kotlin/services/s3/model/PutBucketReplicationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketReplicationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketReplicationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketRequestPayment", "Laws/sdk/kotlin/services/s3/model/PutBucketRequestPaymentResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketRequestPaymentRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketRequestPaymentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketTagging", "Laws/sdk/kotlin/services/s3/model/PutBucketTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketTaggingRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketTaggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketVersioning", "Laws/sdk/kotlin/services/s3/model/PutBucketVersioningResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketVersioningRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketVersioningRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketWebsite", "Laws/sdk/kotlin/services/s3/model/PutBucketWebsiteResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketWebsiteRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketWebsiteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putObject", "Laws/sdk/kotlin/services/s3/model/PutObjectResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putObjectAcl", "Laws/sdk/kotlin/services/s3/model/PutObjectAclResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectAclRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectAclRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putObjectLegalHold", "Laws/sdk/kotlin/services/s3/model/PutObjectLegalHoldResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectLegalHoldRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectLegalHoldRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putObjectLockConfiguration", "Laws/sdk/kotlin/services/s3/model/PutObjectLockConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectLockConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectLockConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putObjectRetention", "Laws/sdk/kotlin/services/s3/model/PutObjectRetentionResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putObjectTagging", "Laws/sdk/kotlin/services/s3/model/PutObjectTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectTaggingRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectTaggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putPublicAccessBlock", "Laws/sdk/kotlin/services/s3/model/PutPublicAccessBlockResponse;", "Laws/sdk/kotlin/services/s3/model/PutPublicAccessBlockRequest;", "(Laws/sdk/kotlin/services/s3/model/PutPublicAccessBlockRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renameObject", "Laws/sdk/kotlin/services/s3/model/RenameObjectResponse;", "Laws/sdk/kotlin/services/s3/model/RenameObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/RenameObjectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreObject", "Laws/sdk/kotlin/services/s3/model/RestoreObjectResponse;", "Laws/sdk/kotlin/services/s3/model/RestoreObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/RestoreObjectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectObjectContent", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentResponse;", "(Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBucketMetadataInventoryTableConfiguration", "Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataInventoryTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataInventoryTableConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataInventoryTableConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBucketMetadataJournalTableConfiguration", "Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataJournalTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataJournalTableConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataJournalTableConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateObjectEncryption", "Laws/sdk/kotlin/services/s3/model/UpdateObjectEncryptionResponse;", "Laws/sdk/kotlin/services/s3/model/UpdateObjectEncryptionRequest;", "(Laws/sdk/kotlin/services/s3/model/UpdateObjectEncryptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadPart", "Laws/sdk/kotlin/services/s3/model/UploadPartResponse;", "Laws/sdk/kotlin/services/s3/model/UploadPartRequest;", "(Laws/sdk/kotlin/services/s3/model/UploadPartRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadPartCopy", "Laws/sdk/kotlin/services/s3/model/UploadPartCopyResponse;", "Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest;", "(Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeGetObjectResponse", "Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseResponse;", "Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest;", "(Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "mergeServiceDefaults", "ctx", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultS3Client implements S3Client {
    private final S3AuthSchemeProviderAdapter authSchemeAdapter;
    private final AwsUserAgentMetadata awsUserAgentMetadata;
    private final SdkHttpClient client;
    private final S3Client.Config config;
    private final Map<AuthSchemeId, AuthScheme> configuredAuthSchemes;
    private final S3IdentityProviderConfigAdapter identityProviderConfig;
    private final SdkManagedGroup managedResources;
    private final OperationMetrics opMetrics;
    private final String telemetryScope;

    /* JADX INFO: compiled from: DefaultS3Client.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ResponseHttpChecksumConfig.values().length];
            try {
                iArr[ResponseHttpChecksumConfig.WHEN_SUPPORTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResponseHttpChecksumConfig.WHEN_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[RequestHttpChecksumConfig.values().length];
            try {
                iArr2[RequestHttpChecksumConfig.WHEN_SUPPORTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[RequestHttpChecksumConfig.WHEN_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public DefaultS3Client(S3Client.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.managedResources = new SdkManagedGroup(null, 1, null);
        this.client = new SdkHttpClient(getConfig().getHttpClient());
        this.identityProviderConfig = new S3IdentityProviderConfigAdapter(getConfig());
        List<AuthScheme> authSchemes = getConfig().getAuthSchemes();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(authSchemes, 10)), 16));
        for (Object obj : authSchemes) {
            linkedHashMap.put(AuthSchemeId.m12116boximpl(((AuthScheme) obj).getSchemeId()), obj);
        }
        Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
        AuthSchemeId authSchemeIdM12116boximpl = AuthSchemeId.m12116boximpl(AuthSchemeId.INSTANCE.m12124getAwsSigV4DepwgT4());
        if (mutableMap.get(authSchemeIdM12116boximpl) == null) {
            mutableMap.put(authSchemeIdM12116boximpl, new SigV4AuthScheme(DefaultAwsSignerJVMKt.getDefaultAwsSigner(), "s3"));
        }
        AuthSchemeId authSchemeIdM12116boximpl2 = AuthSchemeId.m12116boximpl(AuthSchemeId.INSTANCE.m12125getAwsSigV4AsymmetricDepwgT4());
        if (mutableMap.get(authSchemeIdM12116boximpl2) == null) {
            mutableMap.put(authSchemeIdM12116boximpl2, new SigV4AsymmetricAuthScheme(DefaultAwsSignerJVMKt.getDefaultAwsSigner(), "s3"));
        }
        AuthSchemeId authSchemeIdM12116boximpl3 = AuthSchemeId.m12116boximpl(AuthSchemeId.m12117constructorimpl("aws.auth#sigv4s3express"));
        if (mutableMap.get(authSchemeIdM12116boximpl3) == null) {
            mutableMap.put(authSchemeIdM12116boximpl3, new SigV4S3ExpressAuthScheme(DefaultAwsSignerJVMKt.getDefaultAwsSigner(), "s3"));
        }
        this.configuredAuthSchemes = MapsKt.toMap(mutableMap);
        this.authSchemeAdapter = new S3AuthSchemeProviderAdapter(getConfig());
        this.telemetryScope = "aws.sdk.kotlin.services.s3";
        this.opMetrics = new OperationMetrics("aws.sdk.kotlin.services.s3", getConfig().getTelemetryProvider());
        SdkManagedGroupKt.addIfManaged(this.managedResources, getConfig().getHttpClient());
        SdkManagedGroupKt.addIfManaged(this.managedResources, getConfig().getExpressCredentialsProvider());
        SdkManagedGroupKt.addIfManaged(this.managedResources, getConfig().getCredentialsProvider());
        this.awsUserAgentMetadata = AwsUserAgentMetadata.INSTANCE.fromEnvironment(new ApiMetadata(S3ClientKt.ServiceId, "1.6.17"), getConfig().getApplicationId());
    }

    @Override // aws.smithy.kotlin.runtime.client.SdkClient
    public S3Client.Config getConfig() {
        return this.config;
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest, Continuation<? super AbortMultipartUploadResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(AbortMultipartUploadRequest.class), Reflection.getOrCreateKotlinClass(AbortMultipartUploadResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new AbortMultipartUploadOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new AbortMultipartUploadOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("AbortMultipartUpload");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = abortMultipartUploadRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, abortMultipartUploadRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest, Continuation<? super CompleteMultipartUploadResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(CompleteMultipartUploadRequest.class), Reflection.getOrCreateKotlinClass(CompleteMultipartUploadResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new CompleteMultipartUploadOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new CompleteMultipartUploadOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("CompleteMultipartUpload");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = completeMultipartUploadRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, completeMultipartUploadRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object copyObject(CopyObjectRequest copyObjectRequest, Continuation<? super CopyObjectResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(CopyObjectRequest.class), Reflection.getOrCreateKotlinClass(CopyObjectResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new CopyObjectOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new CopyObjectOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("CopyObject");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = copyObjectRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(ExpiresFieldInterceptor.INSTANCE);
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, copyObjectRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object createBucket(CreateBucketRequest createBucketRequest, Continuation<? super CreateBucketResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(CreateBucketRequest.class), Reflection.getOrCreateKotlinClass(CreateBucketResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new CreateBucketOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new CreateBucketOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("CreateBucket");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = createBucketRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, createBucketRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object createBucketMetadataConfiguration(CreateBucketMetadataConfigurationRequest createBucketMetadataConfigurationRequest, Continuation<? super CreateBucketMetadataConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(CreateBucketMetadataConfigurationRequest.class), Reflection.getOrCreateKotlinClass(CreateBucketMetadataConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new CreateBucketMetadataConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new CreateBucketMetadataConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("CreateBucketMetadataConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = createBucketMetadataConfigurationRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = createBucketMetadataConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, createBucketMetadataConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object createBucketMetadataTableConfiguration(CreateBucketMetadataTableConfigurationRequest createBucketMetadataTableConfigurationRequest, Continuation<? super CreateBucketMetadataTableConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(CreateBucketMetadataTableConfigurationRequest.class), Reflection.getOrCreateKotlinClass(CreateBucketMetadataTableConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new CreateBucketMetadataTableConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new CreateBucketMetadataTableConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("CreateBucketMetadataTableConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = createBucketMetadataTableConfigurationRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = createBucketMetadataTableConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, createBucketMetadataTableConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object createMultipartUpload(CreateMultipartUploadRequest createMultipartUploadRequest, Continuation<? super CreateMultipartUploadResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(CreateMultipartUploadRequest.class), Reflection.getOrCreateKotlinClass(CreateMultipartUploadResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new CreateMultipartUploadOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new CreateMultipartUploadOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("CreateMultipartUpload");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = createMultipartUploadRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(ExpiresFieldInterceptor.INSTANCE);
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, createMultipartUploadRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object createSession(CreateSessionRequest createSessionRequest, Continuation<? super CreateSessionResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(CreateSessionRequest.class), Reflection.getOrCreateKotlinClass(CreateSessionResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new CreateSessionOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new CreateSessionOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("CreateSession");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = createSessionRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, createSessionRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucket(DeleteBucketRequest deleteBucketRequest, Continuation<? super DeleteBucketResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucket");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketAnalyticsConfiguration(DeleteBucketAnalyticsConfigurationRequest deleteBucketAnalyticsConfigurationRequest, Continuation<? super DeleteBucketAnalyticsConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketAnalyticsConfigurationRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketAnalyticsConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketAnalyticsConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketAnalyticsConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketAnalyticsConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketAnalyticsConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketAnalyticsConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketCors(DeleteBucketCorsRequest deleteBucketCorsRequest, Continuation<? super DeleteBucketCorsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketCorsRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketCorsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketCorsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketCorsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketCors");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketCorsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketCorsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketEncryption(DeleteBucketEncryptionRequest deleteBucketEncryptionRequest, Continuation<? super DeleteBucketEncryptionResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketEncryptionRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketEncryptionResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketEncryptionOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketEncryptionOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketEncryption");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketEncryptionRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketEncryptionRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketIntelligentTieringConfiguration(DeleteBucketIntelligentTieringConfigurationRequest deleteBucketIntelligentTieringConfigurationRequest, Continuation<? super DeleteBucketIntelligentTieringConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketIntelligentTieringConfigurationRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketIntelligentTieringConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketIntelligentTieringConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketIntelligentTieringConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketIntelligentTieringConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketIntelligentTieringConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketIntelligentTieringConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketInventoryConfiguration(DeleteBucketInventoryConfigurationRequest deleteBucketInventoryConfigurationRequest, Continuation<? super DeleteBucketInventoryConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketInventoryConfigurationRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketInventoryConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketInventoryConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketInventoryConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketInventoryConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketInventoryConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketInventoryConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketLifecycle(DeleteBucketLifecycleRequest deleteBucketLifecycleRequest, Continuation<? super DeleteBucketLifecycleResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketLifecycleRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketLifecycleResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketLifecycleOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketLifecycleOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketLifecycle");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketLifecycleRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketLifecycleRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketMetadataConfiguration(DeleteBucketMetadataConfigurationRequest deleteBucketMetadataConfigurationRequest, Continuation<? super DeleteBucketMetadataConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketMetadataConfigurationRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketMetadataConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketMetadataConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketMetadataConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketMetadataConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketMetadataConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketMetadataConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketMetadataTableConfiguration(DeleteBucketMetadataTableConfigurationRequest deleteBucketMetadataTableConfigurationRequest, Continuation<? super DeleteBucketMetadataTableConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketMetadataTableConfigurationRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketMetadataTableConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketMetadataTableConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketMetadataTableConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketMetadataTableConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketMetadataTableConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketMetadataTableConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketMetricsConfiguration(DeleteBucketMetricsConfigurationRequest deleteBucketMetricsConfigurationRequest, Continuation<? super DeleteBucketMetricsConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketMetricsConfigurationRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketMetricsConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketMetricsConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketMetricsConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketMetricsConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketMetricsConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketMetricsConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketOwnershipControls(DeleteBucketOwnershipControlsRequest deleteBucketOwnershipControlsRequest, Continuation<? super DeleteBucketOwnershipControlsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketOwnershipControlsRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketOwnershipControlsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketOwnershipControlsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketOwnershipControlsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketOwnershipControls");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketOwnershipControlsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketOwnershipControlsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketPolicy(DeleteBucketPolicyRequest deleteBucketPolicyRequest, Continuation<? super DeleteBucketPolicyResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketPolicyRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketPolicyResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketPolicyOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketPolicyOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketPolicy");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketPolicyRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketPolicyRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketReplication(DeleteBucketReplicationRequest deleteBucketReplicationRequest, Continuation<? super DeleteBucketReplicationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketReplicationRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketReplicationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketReplicationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketReplicationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketReplication");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketReplicationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketReplicationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketTagging(DeleteBucketTaggingRequest deleteBucketTaggingRequest, Continuation<? super DeleteBucketTaggingResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketTaggingRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketTaggingResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketTaggingOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketTaggingOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketTagging");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketTaggingRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketTaggingRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteBucketWebsite(DeleteBucketWebsiteRequest deleteBucketWebsiteRequest, Continuation<? super DeleteBucketWebsiteResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteBucketWebsiteRequest.class), Reflection.getOrCreateKotlinClass(DeleteBucketWebsiteResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteBucketWebsiteOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteBucketWebsiteOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteBucketWebsite");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteBucketWebsiteRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteBucketWebsiteRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteObject(DeleteObjectRequest deleteObjectRequest, Continuation<? super DeleteObjectResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteObjectRequest.class), Reflection.getOrCreateKotlinClass(DeleteObjectResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteObjectOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteObjectOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteObject");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteObjectRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteObjectRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteObjectTagging(DeleteObjectTaggingRequest deleteObjectTaggingRequest, Continuation<? super DeleteObjectTaggingResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteObjectTaggingRequest.class), Reflection.getOrCreateKotlinClass(DeleteObjectTaggingResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteObjectTaggingOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteObjectTaggingOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteObjectTagging");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteObjectTaggingRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteObjectTaggingRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deleteObjects(DeleteObjectsRequest deleteObjectsRequest, Continuation<? super DeleteObjectsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeleteObjectsRequest.class), Reflection.getOrCreateKotlinClass(DeleteObjectsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeleteObjectsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeleteObjectsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeleteObjects");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = deleteObjectsRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deleteObjectsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deleteObjectsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object deletePublicAccessBlock(DeletePublicAccessBlockRequest deletePublicAccessBlockRequest, Continuation<? super DeletePublicAccessBlockResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(DeletePublicAccessBlockRequest.class), Reflection.getOrCreateKotlinClass(DeletePublicAccessBlockResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new DeletePublicAccessBlockOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new DeletePublicAccessBlockOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("DeletePublicAccessBlock");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = deletePublicAccessBlockRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, deletePublicAccessBlockRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketAbac(GetBucketAbacRequest getBucketAbacRequest, Continuation<? super GetBucketAbacResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketAbacRequest.class), Reflection.getOrCreateKotlinClass(GetBucketAbacResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketAbacOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketAbacOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketAbac");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketAbacRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketAbacRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketAccelerateConfiguration(GetBucketAccelerateConfigurationRequest getBucketAccelerateConfigurationRequest, Continuation<? super GetBucketAccelerateConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketAccelerateConfigurationRequest.class), Reflection.getOrCreateKotlinClass(GetBucketAccelerateConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketAccelerateConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketAccelerateConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketAccelerateConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketAccelerateConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketAccelerateConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketAcl(GetBucketAclRequest getBucketAclRequest, Continuation<? super GetBucketAclResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketAclRequest.class), Reflection.getOrCreateKotlinClass(GetBucketAclResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketAclOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketAclOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketAcl");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketAclRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketAclRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketAnalyticsConfiguration(GetBucketAnalyticsConfigurationRequest getBucketAnalyticsConfigurationRequest, Continuation<? super GetBucketAnalyticsConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketAnalyticsConfigurationRequest.class), Reflection.getOrCreateKotlinClass(GetBucketAnalyticsConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketAnalyticsConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketAnalyticsConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketAnalyticsConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketAnalyticsConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketAnalyticsConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketCors(GetBucketCorsRequest getBucketCorsRequest, Continuation<? super GetBucketCorsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketCorsRequest.class), Reflection.getOrCreateKotlinClass(GetBucketCorsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketCorsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketCorsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketCors");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketCorsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketCorsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketEncryption(GetBucketEncryptionRequest getBucketEncryptionRequest, Continuation<? super GetBucketEncryptionResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketEncryptionRequest.class), Reflection.getOrCreateKotlinClass(GetBucketEncryptionResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketEncryptionOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketEncryptionOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketEncryption");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketEncryptionRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketEncryptionRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketIntelligentTieringConfiguration(GetBucketIntelligentTieringConfigurationRequest getBucketIntelligentTieringConfigurationRequest, Continuation<? super GetBucketIntelligentTieringConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketIntelligentTieringConfigurationRequest.class), Reflection.getOrCreateKotlinClass(GetBucketIntelligentTieringConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketIntelligentTieringConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketIntelligentTieringConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketIntelligentTieringConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketIntelligentTieringConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketIntelligentTieringConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketInventoryConfiguration(GetBucketInventoryConfigurationRequest getBucketInventoryConfigurationRequest, Continuation<? super GetBucketInventoryConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketInventoryConfigurationRequest.class), Reflection.getOrCreateKotlinClass(GetBucketInventoryConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketInventoryConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketInventoryConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketInventoryConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketInventoryConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketInventoryConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketLifecycleConfiguration(GetBucketLifecycleConfigurationRequest getBucketLifecycleConfigurationRequest, Continuation<? super GetBucketLifecycleConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketLifecycleConfigurationRequest.class), Reflection.getOrCreateKotlinClass(GetBucketLifecycleConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketLifecycleConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketLifecycleConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketLifecycleConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketLifecycleConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketLifecycleConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketLocation(GetBucketLocationRequest getBucketLocationRequest, Continuation<? super GetBucketLocationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketLocationRequest.class), Reflection.getOrCreateKotlinClass(GetBucketLocationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketLocationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketLocationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketLocation");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketLocationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketLocationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketLogging(GetBucketLoggingRequest getBucketLoggingRequest, Continuation<? super GetBucketLoggingResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketLoggingRequest.class), Reflection.getOrCreateKotlinClass(GetBucketLoggingResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketLoggingOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketLoggingOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketLogging");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketLoggingRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketLoggingRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketMetadataConfiguration(GetBucketMetadataConfigurationRequest getBucketMetadataConfigurationRequest, Continuation<? super GetBucketMetadataConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketMetadataConfigurationRequest.class), Reflection.getOrCreateKotlinClass(GetBucketMetadataConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketMetadataConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketMetadataConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketMetadataConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketMetadataConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketMetadataConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketMetadataTableConfiguration(GetBucketMetadataTableConfigurationRequest getBucketMetadataTableConfigurationRequest, Continuation<? super GetBucketMetadataTableConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketMetadataTableConfigurationRequest.class), Reflection.getOrCreateKotlinClass(GetBucketMetadataTableConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketMetadataTableConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketMetadataTableConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketMetadataTableConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketMetadataTableConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketMetadataTableConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketMetricsConfiguration(GetBucketMetricsConfigurationRequest getBucketMetricsConfigurationRequest, Continuation<? super GetBucketMetricsConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketMetricsConfigurationRequest.class), Reflection.getOrCreateKotlinClass(GetBucketMetricsConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketMetricsConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketMetricsConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketMetricsConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketMetricsConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketMetricsConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketNotificationConfiguration(GetBucketNotificationConfigurationRequest getBucketNotificationConfigurationRequest, Continuation<? super GetBucketNotificationConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketNotificationConfigurationRequest.class), Reflection.getOrCreateKotlinClass(GetBucketNotificationConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketNotificationConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketNotificationConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketNotificationConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketNotificationConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketNotificationConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketOwnershipControls(GetBucketOwnershipControlsRequest getBucketOwnershipControlsRequest, Continuation<? super GetBucketOwnershipControlsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketOwnershipControlsRequest.class), Reflection.getOrCreateKotlinClass(GetBucketOwnershipControlsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketOwnershipControlsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketOwnershipControlsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketOwnershipControls");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketOwnershipControlsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketOwnershipControlsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketPolicy(GetBucketPolicyRequest getBucketPolicyRequest, Continuation<? super GetBucketPolicyResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketPolicyRequest.class), Reflection.getOrCreateKotlinClass(GetBucketPolicyResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketPolicyOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketPolicyOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketPolicy");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketPolicyRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketPolicyRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketPolicyStatus(GetBucketPolicyStatusRequest getBucketPolicyStatusRequest, Continuation<? super GetBucketPolicyStatusResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketPolicyStatusRequest.class), Reflection.getOrCreateKotlinClass(GetBucketPolicyStatusResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketPolicyStatusOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketPolicyStatusOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketPolicyStatus");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketPolicyStatusRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketPolicyStatusRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketReplication(GetBucketReplicationRequest getBucketReplicationRequest, Continuation<? super GetBucketReplicationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketReplicationRequest.class), Reflection.getOrCreateKotlinClass(GetBucketReplicationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketReplicationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketReplicationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketReplication");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketReplicationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketReplicationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketRequestPayment(GetBucketRequestPaymentRequest getBucketRequestPaymentRequest, Continuation<? super GetBucketRequestPaymentResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketRequestPaymentRequest.class), Reflection.getOrCreateKotlinClass(GetBucketRequestPaymentResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketRequestPaymentOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketRequestPaymentOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketRequestPayment");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketRequestPaymentRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketRequestPaymentRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketTagging(GetBucketTaggingRequest getBucketTaggingRequest, Continuation<? super GetBucketTaggingResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketTaggingRequest.class), Reflection.getOrCreateKotlinClass(GetBucketTaggingResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketTaggingOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketTaggingOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketTagging");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketTaggingRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketTaggingRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketVersioning(GetBucketVersioningRequest getBucketVersioningRequest, Continuation<? super GetBucketVersioningResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketVersioningRequest.class), Reflection.getOrCreateKotlinClass(GetBucketVersioningResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketVersioningOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketVersioningOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketVersioning");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketVersioningRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketVersioningRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getBucketWebsite(GetBucketWebsiteRequest getBucketWebsiteRequest, Continuation<? super GetBucketWebsiteResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetBucketWebsiteRequest.class), Reflection.getOrCreateKotlinClass(GetBucketWebsiteResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetBucketWebsiteOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetBucketWebsiteOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetBucketWebsite");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getBucketWebsiteRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getBucketWebsiteRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public <T> Object getObject(GetObjectRequest getObjectRequest, Function2<? super GetObjectResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetObjectRequest.class), Reflection.getOrCreateKotlinClass(GetObjectResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetObjectOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetObjectOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetObject");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        ChecksumMode checksumMode = getObjectRequest.getChecksumMode();
        interceptors.add(new IgnoreCompositeFlexibleChecksumResponseInterceptor(Intrinsics.areEqual(checksumMode != null ? checksumMode.getValue() : null, "ENABLED"), getConfig().getResponseChecksumValidation()));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(new ResponseLengthValidationInterceptor());
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getObjectRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(ExpiresFieldInterceptor.INSTANCE);
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.execute(sdkHttpOperationBuild, this.client, getObjectRequest, function2, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getObjectAcl(GetObjectAclRequest getObjectAclRequest, Continuation<? super GetObjectAclResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetObjectAclRequest.class), Reflection.getOrCreateKotlinClass(GetObjectAclResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetObjectAclOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetObjectAclOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetObjectAcl");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getObjectAclRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getObjectAclRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getObjectAttributes(GetObjectAttributesRequest getObjectAttributesRequest, Continuation<? super GetObjectAttributesResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetObjectAttributesRequest.class), Reflection.getOrCreateKotlinClass(GetObjectAttributesResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetObjectAttributesOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetObjectAttributesOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetObjectAttributes");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getObjectAttributesRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getObjectAttributesRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getObjectLegalHold(GetObjectLegalHoldRequest getObjectLegalHoldRequest, Continuation<? super GetObjectLegalHoldResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetObjectLegalHoldRequest.class), Reflection.getOrCreateKotlinClass(GetObjectLegalHoldResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetObjectLegalHoldOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetObjectLegalHoldOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetObjectLegalHold");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getObjectLegalHoldRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getObjectLegalHoldRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getObjectLockConfiguration(GetObjectLockConfigurationRequest getObjectLockConfigurationRequest, Continuation<? super GetObjectLockConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetObjectLockConfigurationRequest.class), Reflection.getOrCreateKotlinClass(GetObjectLockConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetObjectLockConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetObjectLockConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetObjectLockConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getObjectLockConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getObjectLockConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getObjectRetention(GetObjectRetentionRequest getObjectRetentionRequest, Continuation<? super GetObjectRetentionResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetObjectRetentionRequest.class), Reflection.getOrCreateKotlinClass(GetObjectRetentionResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetObjectRetentionOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetObjectRetentionOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetObjectRetention");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getObjectRetentionRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getObjectRetentionRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getObjectTagging(GetObjectTaggingRequest getObjectTaggingRequest, Continuation<? super GetObjectTaggingResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetObjectTaggingRequest.class), Reflection.getOrCreateKotlinClass(GetObjectTaggingResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetObjectTaggingOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetObjectTaggingOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetObjectTagging");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getObjectTaggingRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getObjectTaggingRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public <T> Object getObjectTorrent(GetObjectTorrentRequest getObjectTorrentRequest, Function2<? super GetObjectTorrentResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetObjectTorrentRequest.class), Reflection.getOrCreateKotlinClass(GetObjectTorrentResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetObjectTorrentOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetObjectTorrentOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetObjectTorrent");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getObjectTorrentRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.execute(sdkHttpOperationBuild, this.client, getObjectTorrentRequest, function2, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object getPublicAccessBlock(GetPublicAccessBlockRequest getPublicAccessBlockRequest, Continuation<? super GetPublicAccessBlockResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(GetPublicAccessBlockRequest.class), Reflection.getOrCreateKotlinClass(GetPublicAccessBlockResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new GetPublicAccessBlockOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new GetPublicAccessBlockOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("GetPublicAccessBlock");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = getPublicAccessBlockRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, getPublicAccessBlockRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object headBucket(HeadBucketRequest headBucketRequest, Continuation<? super HeadBucketResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(HeadBucketRequest.class), Reflection.getOrCreateKotlinClass(HeadBucketResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new HeadBucketOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new HeadBucketOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("HeadBucket");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = headBucketRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, headBucketRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object headObject(HeadObjectRequest headObjectRequest, Continuation<? super HeadObjectResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(HeadObjectRequest.class), Reflection.getOrCreateKotlinClass(HeadObjectResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new HeadObjectOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new HeadObjectOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("HeadObject");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = headObjectRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(ExpiresFieldInterceptor.INSTANCE);
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, headObjectRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object listBucketAnalyticsConfigurations(ListBucketAnalyticsConfigurationsRequest listBucketAnalyticsConfigurationsRequest, Continuation<? super ListBucketAnalyticsConfigurationsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(ListBucketAnalyticsConfigurationsRequest.class), Reflection.getOrCreateKotlinClass(ListBucketAnalyticsConfigurationsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new ListBucketAnalyticsConfigurationsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new ListBucketAnalyticsConfigurationsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("ListBucketAnalyticsConfigurations");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = listBucketAnalyticsConfigurationsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, listBucketAnalyticsConfigurationsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object listBucketIntelligentTieringConfigurations(ListBucketIntelligentTieringConfigurationsRequest listBucketIntelligentTieringConfigurationsRequest, Continuation<? super ListBucketIntelligentTieringConfigurationsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(ListBucketIntelligentTieringConfigurationsRequest.class), Reflection.getOrCreateKotlinClass(ListBucketIntelligentTieringConfigurationsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new ListBucketIntelligentTieringConfigurationsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new ListBucketIntelligentTieringConfigurationsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("ListBucketIntelligentTieringConfigurations");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = listBucketIntelligentTieringConfigurationsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, listBucketIntelligentTieringConfigurationsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object listBucketInventoryConfigurations(ListBucketInventoryConfigurationsRequest listBucketInventoryConfigurationsRequest, Continuation<? super ListBucketInventoryConfigurationsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(ListBucketInventoryConfigurationsRequest.class), Reflection.getOrCreateKotlinClass(ListBucketInventoryConfigurationsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new ListBucketInventoryConfigurationsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new ListBucketInventoryConfigurationsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("ListBucketInventoryConfigurations");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = listBucketInventoryConfigurationsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, listBucketInventoryConfigurationsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object listBucketMetricsConfigurations(ListBucketMetricsConfigurationsRequest listBucketMetricsConfigurationsRequest, Continuation<? super ListBucketMetricsConfigurationsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(ListBucketMetricsConfigurationsRequest.class), Reflection.getOrCreateKotlinClass(ListBucketMetricsConfigurationsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new ListBucketMetricsConfigurationsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new ListBucketMetricsConfigurationsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("ListBucketMetricsConfigurations");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = listBucketMetricsConfigurationsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, listBucketMetricsConfigurationsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object listBuckets(ListBucketsRequest listBucketsRequest, Continuation<? super ListBucketsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(ListBucketsRequest.class), Reflection.getOrCreateKotlinClass(ListBucketsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new ListBucketsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new ListBucketsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("ListBuckets");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, listBucketsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object listDirectoryBuckets(ListDirectoryBucketsRequest listDirectoryBucketsRequest, Continuation<? super ListDirectoryBucketsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(ListDirectoryBucketsRequest.class), Reflection.getOrCreateKotlinClass(ListDirectoryBucketsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new ListDirectoryBucketsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new ListDirectoryBucketsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("ListDirectoryBuckets");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, listDirectoryBucketsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest, Continuation<? super ListMultipartUploadsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(ListMultipartUploadsRequest.class), Reflection.getOrCreateKotlinClass(ListMultipartUploadsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new ListMultipartUploadsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new ListMultipartUploadsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("ListMultipartUploads");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = listMultipartUploadsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, listMultipartUploadsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object listObjectVersions(ListObjectVersionsRequest listObjectVersionsRequest, Continuation<? super ListObjectVersionsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(ListObjectVersionsRequest.class), Reflection.getOrCreateKotlinClass(ListObjectVersionsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new ListObjectVersionsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new ListObjectVersionsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("ListObjectVersions");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = listObjectVersionsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, listObjectVersionsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object listObjects(ListObjectsRequest listObjectsRequest, Continuation<? super ListObjectsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(ListObjectsRequest.class), Reflection.getOrCreateKotlinClass(ListObjectsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new ListObjectsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new ListObjectsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("ListObjects");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = listObjectsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, listObjectsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object listObjectsV2(ListObjectsV2Request listObjectsV2Request, Continuation<? super ListObjectsV2Response> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(ListObjectsV2Request.class), Reflection.getOrCreateKotlinClass(ListObjectsV2Response.class));
        sdkHttpOperationBuilder.setSerializeWith(new ListObjectsV2OperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new ListObjectsV2OperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("ListObjectsV2");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = listObjectsV2Request.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, listObjectsV2Request, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object listParts(ListPartsRequest listPartsRequest, Continuation<? super ListPartsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(ListPartsRequest.class), Reflection.getOrCreateKotlinClass(ListPartsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new ListPartsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new ListPartsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("ListParts");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = listPartsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, listPartsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketAbac(PutBucketAbacRequest putBucketAbacRequest, Continuation<? super PutBucketAbacResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketAbacRequest.class), Reflection.getOrCreateKotlinClass(PutBucketAbacResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketAbacOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketAbacOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketAbac");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketAbacRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(false, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketAbacRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketAbacRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketAccelerateConfiguration(PutBucketAccelerateConfigurationRequest putBucketAccelerateConfigurationRequest, Continuation<? super PutBucketAccelerateConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketAccelerateConfigurationRequest.class), Reflection.getOrCreateKotlinClass(PutBucketAccelerateConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketAccelerateConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketAccelerateConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketAccelerateConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketAccelerateConfigurationRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(false, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketAccelerateConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketAccelerateConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketAcl(PutBucketAclRequest putBucketAclRequest, Continuation<? super PutBucketAclResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketAclRequest.class), Reflection.getOrCreateKotlinClass(PutBucketAclResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketAclOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketAclOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketAcl");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketAclRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketAclRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketAclRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketAnalyticsConfiguration(PutBucketAnalyticsConfigurationRequest putBucketAnalyticsConfigurationRequest, Continuation<? super PutBucketAnalyticsConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketAnalyticsConfigurationRequest.class), Reflection.getOrCreateKotlinClass(PutBucketAnalyticsConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketAnalyticsConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketAnalyticsConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketAnalyticsConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketAnalyticsConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketAnalyticsConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketCors(PutBucketCorsRequest putBucketCorsRequest, Continuation<? super PutBucketCorsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketCorsRequest.class), Reflection.getOrCreateKotlinClass(PutBucketCorsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketCorsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketCorsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketCors");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketCorsRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketCorsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketCorsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketEncryption(PutBucketEncryptionRequest putBucketEncryptionRequest, Continuation<? super PutBucketEncryptionResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketEncryptionRequest.class), Reflection.getOrCreateKotlinClass(PutBucketEncryptionResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketEncryptionOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketEncryptionOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketEncryption");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketEncryptionRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketEncryptionRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketEncryptionRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketIntelligentTieringConfiguration(PutBucketIntelligentTieringConfigurationRequest putBucketIntelligentTieringConfigurationRequest, Continuation<? super PutBucketIntelligentTieringConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketIntelligentTieringConfigurationRequest.class), Reflection.getOrCreateKotlinClass(PutBucketIntelligentTieringConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketIntelligentTieringConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketIntelligentTieringConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketIntelligentTieringConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketIntelligentTieringConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketIntelligentTieringConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketInventoryConfiguration(PutBucketInventoryConfigurationRequest putBucketInventoryConfigurationRequest, Continuation<? super PutBucketInventoryConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketInventoryConfigurationRequest.class), Reflection.getOrCreateKotlinClass(PutBucketInventoryConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketInventoryConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketInventoryConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketInventoryConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketInventoryConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketInventoryConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketLifecycleConfiguration(PutBucketLifecycleConfigurationRequest putBucketLifecycleConfigurationRequest, Continuation<? super PutBucketLifecycleConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketLifecycleConfigurationRequest.class), Reflection.getOrCreateKotlinClass(PutBucketLifecycleConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketLifecycleConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketLifecycleConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketLifecycleConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketLifecycleConfigurationRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketLifecycleConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketLifecycleConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketLogging(PutBucketLoggingRequest putBucketLoggingRequest, Continuation<? super PutBucketLoggingResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketLoggingRequest.class), Reflection.getOrCreateKotlinClass(PutBucketLoggingResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketLoggingOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketLoggingOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketLogging");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketLoggingRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketLoggingRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketLoggingRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketMetricsConfiguration(PutBucketMetricsConfigurationRequest putBucketMetricsConfigurationRequest, Continuation<? super PutBucketMetricsConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketMetricsConfigurationRequest.class), Reflection.getOrCreateKotlinClass(PutBucketMetricsConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketMetricsConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketMetricsConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketMetricsConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketMetricsConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketMetricsConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketNotificationConfiguration(PutBucketNotificationConfigurationRequest putBucketNotificationConfigurationRequest, Continuation<? super PutBucketNotificationConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketNotificationConfigurationRequest.class), Reflection.getOrCreateKotlinClass(PutBucketNotificationConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketNotificationConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketNotificationConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketNotificationConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketNotificationConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketNotificationConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketOwnershipControls(PutBucketOwnershipControlsRequest putBucketOwnershipControlsRequest, Continuation<? super PutBucketOwnershipControlsResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketOwnershipControlsRequest.class), Reflection.getOrCreateKotlinClass(PutBucketOwnershipControlsResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketOwnershipControlsOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketOwnershipControlsOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketOwnershipControls");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketOwnershipControlsRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketOwnershipControlsRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketOwnershipControlsRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketPolicy(PutBucketPolicyRequest putBucketPolicyRequest, Continuation<? super PutBucketPolicyResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketPolicyRequest.class), Reflection.getOrCreateKotlinClass(PutBucketPolicyResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketPolicyOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketPolicyOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketPolicy");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketPolicyRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketPolicyRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketPolicyRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketReplication(PutBucketReplicationRequest putBucketReplicationRequest, Continuation<? super PutBucketReplicationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketReplicationRequest.class), Reflection.getOrCreateKotlinClass(PutBucketReplicationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketReplicationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketReplicationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketReplication");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketReplicationRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketReplicationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketReplicationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketRequestPayment(PutBucketRequestPaymentRequest putBucketRequestPaymentRequest, Continuation<? super PutBucketRequestPaymentResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketRequestPaymentRequest.class), Reflection.getOrCreateKotlinClass(PutBucketRequestPaymentResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketRequestPaymentOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketRequestPaymentOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketRequestPayment");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketRequestPaymentRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketRequestPaymentRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketRequestPaymentRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketTagging(PutBucketTaggingRequest putBucketTaggingRequest, Continuation<? super PutBucketTaggingResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketTaggingRequest.class), Reflection.getOrCreateKotlinClass(PutBucketTaggingResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketTaggingOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketTaggingOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketTagging");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketTaggingRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketTaggingRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketTaggingRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketVersioning(PutBucketVersioningRequest putBucketVersioningRequest, Continuation<? super PutBucketVersioningResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketVersioningRequest.class), Reflection.getOrCreateKotlinClass(PutBucketVersioningResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketVersioningOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketVersioningOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketVersioning");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketVersioningRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketVersioningRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketVersioningRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putBucketWebsite(PutBucketWebsiteRequest putBucketWebsiteRequest, Continuation<? super PutBucketWebsiteResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutBucketWebsiteRequest.class), Reflection.getOrCreateKotlinClass(PutBucketWebsiteResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutBucketWebsiteOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutBucketWebsiteOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutBucketWebsite");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putBucketWebsiteRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putBucketWebsiteRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putBucketWebsiteRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putObject(PutObjectRequest putObjectRequest, Continuation<? super PutObjectResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutObjectRequest.class), Reflection.getOrCreateKotlinClass(PutObjectResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutObjectOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutObjectOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutObject");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putObjectRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(false, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putObjectRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(ExpiresFieldInterceptor.INSTANCE);
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putObjectRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putObjectAcl(PutObjectAclRequest putObjectAclRequest, Continuation<? super PutObjectAclResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutObjectAclRequest.class), Reflection.getOrCreateKotlinClass(PutObjectAclResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutObjectAclOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutObjectAclOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutObjectAcl");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putObjectAclRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putObjectAclRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putObjectAclRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putObjectLegalHold(PutObjectLegalHoldRequest putObjectLegalHoldRequest, Continuation<? super PutObjectLegalHoldResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutObjectLegalHoldRequest.class), Reflection.getOrCreateKotlinClass(PutObjectLegalHoldResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutObjectLegalHoldOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutObjectLegalHoldOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutObjectLegalHold");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putObjectLegalHoldRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putObjectLegalHoldRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putObjectLegalHoldRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putObjectLockConfiguration(PutObjectLockConfigurationRequest putObjectLockConfigurationRequest, Continuation<? super PutObjectLockConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutObjectLockConfigurationRequest.class), Reflection.getOrCreateKotlinClass(PutObjectLockConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutObjectLockConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutObjectLockConfigurationOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutObjectLockConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putObjectLockConfigurationRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putObjectLockConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putObjectLockConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putObjectRetention(PutObjectRetentionRequest putObjectRetentionRequest, Continuation<? super PutObjectRetentionResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutObjectRetentionRequest.class), Reflection.getOrCreateKotlinClass(PutObjectRetentionResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutObjectRetentionOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutObjectRetentionOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutObjectRetention");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putObjectRetentionRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putObjectRetentionRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putObjectRetentionRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putObjectTagging(PutObjectTaggingRequest putObjectTaggingRequest, Continuation<? super PutObjectTaggingResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutObjectTaggingRequest.class), Reflection.getOrCreateKotlinClass(PutObjectTaggingResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutObjectTaggingOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutObjectTaggingOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutObjectTagging");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putObjectTaggingRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putObjectTaggingRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putObjectTaggingRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object putPublicAccessBlock(PutPublicAccessBlockRequest putPublicAccessBlockRequest, Continuation<? super PutPublicAccessBlockResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(PutPublicAccessBlockRequest.class), Reflection.getOrCreateKotlinClass(PutPublicAccessBlockResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new PutPublicAccessBlockOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new PutPublicAccessBlockOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("PutPublicAccessBlock");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = putPublicAccessBlockRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = putPublicAccessBlockRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, putPublicAccessBlockRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object renameObject(RenameObjectRequest renameObjectRequest, Continuation<? super RenameObjectResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(RenameObjectRequest.class), Reflection.getOrCreateKotlinClass(RenameObjectResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new RenameObjectOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new RenameObjectOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("RenameObject");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = renameObjectRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, renameObjectRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object restoreObject(RestoreObjectRequest restoreObjectRequest, Continuation<? super RestoreObjectResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(RestoreObjectRequest.class), Reflection.getOrCreateKotlinClass(RestoreObjectResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new RestoreObjectOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new RestoreObjectOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("RestoreObject");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = restoreObjectRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(false, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = restoreObjectRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, restoreObjectRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public <T> Object selectObjectContent(SelectObjectContentRequest selectObjectContentRequest, Function2<? super SelectObjectContentResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(SelectObjectContentRequest.class), Reflection.getOrCreateKotlinClass(SelectObjectContentResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new SelectObjectContentOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new SelectObjectContentOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("SelectObjectContent");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = selectObjectContentRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.execute(sdkHttpOperationBuild, this.client, selectObjectContentRequest, function2, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object updateBucketMetadataInventoryTableConfiguration(UpdateBucketMetadataInventoryTableConfigurationRequest updateBucketMetadataInventoryTableConfigurationRequest, Continuation<? super UpdateBucketMetadataInventoryTableConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(UpdateBucketMetadataInventoryTableConfigurationRequest.class), Reflection.getOrCreateKotlinClass(UpdateBucketMetadataInventoryTableConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new C3625x1b5a8a97());
        sdkHttpOperationBuilder.setDeserializeWith(new C3623x17887c98());
        sdkHttpOperationBuilder.setOperationName("UpdateBucketMetadataInventoryTableConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = updateBucketMetadataInventoryTableConfigurationRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = updateBucketMetadataInventoryTableConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, updateBucketMetadataInventoryTableConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object updateBucketMetadataJournalTableConfiguration(UpdateBucketMetadataJournalTableConfigurationRequest updateBucketMetadataJournalTableConfigurationRequest, Continuation<? super UpdateBucketMetadataJournalTableConfigurationResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(UpdateBucketMetadataJournalTableConfigurationRequest.class), Reflection.getOrCreateKotlinClass(UpdateBucketMetadataJournalTableConfigurationResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new UpdateBucketMetadataJournalTableConfigurationOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new C3626x928e16dd());
        sdkHttpOperationBuilder.setOperationName("UpdateBucketMetadataJournalTableConfiguration");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = updateBucketMetadataJournalTableConfigurationRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = updateBucketMetadataJournalTableConfigurationRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, updateBucketMetadataJournalTableConfigurationRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object updateObjectEncryption(UpdateObjectEncryptionRequest updateObjectEncryptionRequest, Continuation<? super UpdateObjectEncryptionResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(UpdateObjectEncryptionRequest.class), Reflection.getOrCreateKotlinClass(UpdateObjectEncryptionResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new UpdateObjectEncryptionOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new UpdateObjectEncryptionOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("UpdateObjectEncryption");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(false));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = updateObjectEncryptionRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(true, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = updateObjectEncryptionRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, updateObjectEncryptionRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object uploadPart(UploadPartRequest uploadPartRequest, Continuation<? super UploadPartResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(UploadPartRequest.class), Reflection.getOrCreateKotlinClass(UploadPartResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new UploadPartOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new UploadPartOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("UploadPart");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(HttpOperationContext.INSTANCE.getDefaultChecksumAlgorithm(), "CRC32");
        sdkHttpOperationBuild.getInterceptors().add(new S3ExpressDefaultChecksumAlgorithm(true));
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$1[getConfig().getRequestChecksumCalculation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_WHEN_REQUIRED);
        }
        List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = sdkHttpOperationBuild.getInterceptors();
        RequestHttpChecksumConfig requestChecksumCalculation = getConfig().getRequestChecksumCalculation();
        ChecksumAlgorithm checksumAlgorithm = uploadPartRequest.getChecksumAlgorithm();
        interceptors.add(new FlexibleChecksumsRequestInterceptor(false, requestChecksumCalculation, checksumAlgorithm != null ? checksumAlgorithm.getValue() : null));
        int i2 = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i2 == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = uploadPartRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, uploadPartRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object uploadPartCopy(UploadPartCopyRequest uploadPartCopyRequest, Continuation<? super UploadPartCopyResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(UploadPartCopyRequest.class), Reflection.getOrCreateKotlinClass(UploadPartCopyResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new UploadPartCopyOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new UploadPartCopyOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("UploadPartCopy");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        Long continueHeaderThresholdBytes = getConfig().getContinueHeaderThresholdBytes();
        if (continueHeaderThresholdBytes != null) {
            Boxing.boxBoolean(sdkHttpOperationBuild.getInterceptors().add(new ContinueInterceptor(continueHeaderThresholdBytes.longValue())));
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        String bucket = uploadPartCopyRequest.getBucket();
        if (bucket != null) {
            sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getBucket(), bucket);
        }
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, uploadPartCopyRequest, continuation);
    }

    @Override // aws.sdk.kotlin.services.p010s3.S3Client
    public Object writeGetObjectResponse(WriteGetObjectResponseRequest writeGetObjectResponseRequest, Continuation<? super WriteGetObjectResponseResponse> continuation) {
        SdkHttpOperation.Companion companion = SdkHttpOperation.INSTANCE;
        SdkHttpOperationBuilder sdkHttpOperationBuilder = new SdkHttpOperationBuilder(Reflection.getOrCreateKotlinClass(WriteGetObjectResponseRequest.class), Reflection.getOrCreateKotlinClass(WriteGetObjectResponseResponse.class));
        sdkHttpOperationBuilder.setSerializeWith(new WriteGetObjectResponseOperationSerializer());
        sdkHttpOperationBuilder.setDeserializeWith(new WriteGetObjectResponseOperationDeserializer());
        sdkHttpOperationBuilder.setOperationName("WriteGetObjectResponse");
        sdkHttpOperationBuilder.setServiceName(S3ClientKt.ServiceId);
        SdkOperationTelemetry telemetry = sdkHttpOperationBuilder.getTelemetry();
        telemetry.setProvider(getConfig().getTelemetryProvider());
        telemetry.setScope(this.telemetryScope);
        telemetry.setMetrics(this.opMetrics);
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("rpc.system", "aws-api");
        telemetry.setAttributes(attributesBuilder.getAttributes());
        sdkHttpOperationBuilder.getExecution().setAuth(new OperationAuthConfig(this.authSchemeAdapter, this.configuredAuthSchemes, this.identityProviderConfig));
        sdkHttpOperationBuilder.getExecution().setEndpointResolver(new EndpointResolverAdapter(getConfig()));
        sdkHttpOperationBuilder.getExecution().setRetryStrategy(getConfig().getRetryStrategy());
        sdkHttpOperationBuilder.getExecution().setRetryPolicy(getConfig().getRetryPolicy());
        SdkHttpOperation sdkHttpOperationBuild = sdkHttpOperationBuilder.build();
        mergeServiceDefaults(sdkHttpOperationBuild.getContext());
        sdkHttpOperationBuild.getContext().set(AwsSigningAttributes.INSTANCE.getSignedBodyHeader(), AwsSignedBodyHeader.X_AMZ_CONTENT_SHA256);
        sdkHttpOperationBuild.install(new AwsRetryHeaderMiddleware());
        sdkHttpOperationBuild.getInterceptors().add(AwsSpanInterceptor.INSTANCE);
        int i = WhenMappings.$EnumSwitchMapping$0[getConfig().getResponseChecksumValidation().ordinal()];
        if (i == 1) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_SUPPORTED);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_RES_WHEN_REQUIRED);
        }
        sdkHttpOperationBuild.getInterceptors().add(Handle200ErrorsInterceptor.INSTANCE);
        sdkHttpOperationBuild.getContext().set(S3Attributes.INSTANCE.getExpressClient(), this);
        sdkHttpOperationBuild.getInterceptors().add(ExpiresFieldInterceptor.INSTANCE);
        sdkHttpOperationBuild.getInterceptors().add(new BusinessMetricsInterceptor());
        if (getConfig().getCredentialsProvider() instanceof StaticCredentialsProvider) {
            BusinessMetricsUtilsKt.emitBusinessMetric(sdkHttpOperationBuild.getContext(), (BusinessMetric) AwsBusinessMetric.Credentials.CREDENTIALS_CODE);
        }
        sdkHttpOperationBuild.install(new UserAgent(this.awsUserAgentMetadata));
        sdkHttpOperationBuild.install(new RecursionDetection(null, 1, null));
        sdkHttpOperationBuild.getInterceptors().addAll(getConfig().getInterceptors());
        return SdkHttpOperationKt.roundTrip(sdkHttpOperationBuild, this.client, writeGetObjectResponseRequest, continuation);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.managedResources.unshareAll();
    }

    private final void mergeServiceDefaults(ExecutionContext ctx) {
        ExecutionContext executionContext = ctx;
        AttributesKt.putIfAbsentNotNull(executionContext, HttpOperationContext.INSTANCE.getAttemptTimeout(), getConfig().getAttemptTimeout());
        AttributesKt.putIfAbsentNotNull(executionContext, HttpOperationContext.INSTANCE.getCallTimeout(), getConfig().getCallTimeout());
        AttributesKt.putIfAbsent(executionContext, SdkClientOption.INSTANCE.getClientName(), getConfig().getClientName());
        AttributesKt.putIfAbsent(executionContext, SdkClientOption.INSTANCE.getLogMode(), getConfig().getLogMode());
        AttributesKt.putIfAbsentNotNull(executionContext, SdkClientOption.INSTANCE.getIdempotencyTokenProvider(), getConfig().getIdempotencyTokenProvider());
        AttributesKt.putIfAbsentNotNull(executionContext, AwsAttributes.INSTANCE.getRegion(), getConfig().getRegion());
        AttributesKt.putIfAbsentNotNull(executionContext, AwsSigningAttributes.INSTANCE.getSigningRegion(), getConfig().getRegion());
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.INSTANCE.getSigningService(), "s3");
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.INSTANCE.getCredentialsProvider(), getConfig().getCredentialsProvider());
        AttributesKt.putIfAbsentNotNull(executionContext, AwsSdkClientOption.INSTANCE.getApplicationId(), getConfig().getApplicationId());
        AttributesKt.putIfAbsentNotNull(executionContext, AwsSigningAttributes.INSTANCE.getConfigSigningRegionSet(), getConfig().getSigV4aSigningRegionSet());
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.INSTANCE.getNormalizeUriPath(), false);
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.INSTANCE.getUseDoubleUriEncode(), false);
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.INSTANCE.getSignedBodyHeader(), AwsSignedBodyHeader.X_AMZ_CONTENT_SHA256);
        AttributesKt.putIfAbsent(executionContext, AwsSigningAttributes.INSTANCE.getEnableAwsChunked(), Boolean.valueOf(getConfig().getEnableAwsChunked()));
    }
}

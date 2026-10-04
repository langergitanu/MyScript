package aws.sdk.kotlin.services.p010s3;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.auth.credentials.DefaultChainCredentialsProvider;
import aws.sdk.kotlin.runtime.auth.credentials.internal.ManagedCredentialsProviderKt;
import aws.sdk.kotlin.runtime.config.AbstractAwsSdkClientFactory;
import aws.sdk.kotlin.runtime.config.AwsSdkClientConfig;
import aws.sdk.kotlin.runtime.config.endpoints.ResolversKt;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.sdk.kotlin.runtime.http.retries.AwsRetryPolicy;
import aws.sdk.kotlin.runtime.region.DefaultRegionProviderChain;
import aws.sdk.kotlin.runtime.region.ValidateRegionKt;
import aws.sdk.kotlin.services.p010s3.auth.DefaultS3AuthSchemeProvider;
import aws.sdk.kotlin.services.p010s3.auth.S3AuthSchemeProvider;
import aws.sdk.kotlin.services.p010s3.endpoints.DefaultS3EndpointProvider;
import aws.sdk.kotlin.services.p010s3.endpoints.S3EndpointProvider;
import aws.sdk.kotlin.services.p010s3.express.DefaultS3ExpressCredentialsProvider;
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
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderConfig;
import aws.smithy.kotlin.runtime.auth.awscredentials.SigV4aClientConfig;
import aws.smithy.kotlin.runtime.awsprotocol.ClockSkewInterceptor;
import aws.smithy.kotlin.runtime.client.AbstractSdkClientBuilder;
import aws.smithy.kotlin.runtime.client.IdempotencyTokenConfig;
import aws.smithy.kotlin.runtime.client.IdempotencyTokenProvider;
import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.client.LogMode;
import aws.smithy.kotlin.runtime.client.RetryClientConfig;
import aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig;
import aws.smithy.kotlin.runtime.client.RetryStrategyClientConfigImpl;
import aws.smithy.kotlin.runtime.client.SdkClient;
import aws.smithy.kotlin.runtime.client.SdkClientConfig;
import aws.smithy.kotlin.runtime.client.config.HttpChecksumConfig;
import aws.smithy.kotlin.runtime.client.config.RequestHttpChecksumConfig;
import aws.smithy.kotlin.runtime.client.config.ResponseHttpChecksumConfig;
import aws.smithy.kotlin.runtime.client.region.RegionProvider;
import aws.smithy.kotlin.runtime.http.auth.AuthScheme;
import aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig;
import aws.smithy.kotlin.runtime.http.config.EngineFactory;
import aws.smithy.kotlin.runtime.http.config.HttpClientConfig;
import aws.smithy.kotlin.runtime.http.config.HttpEngineConfig;
import aws.smithy.kotlin.runtime.http.config.TimeoutConfig;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineConfig;
import aws.smithy.kotlin.runtime.http.engine.HttpEngineConfigImpl;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.retries.RetryStrategy;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy;
import aws.smithy.kotlin.runtime.retries.policy.RetryPolicy;
import aws.smithy.kotlin.runtime.telemetry.GlobalTelemetryProviderKt;
import aws.smithy.kotlin.runtime.telemetry.TelemetryConfig;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.util.DslFactory;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: compiled from: S3Client.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000¦\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 ¸\u00032\u00020\u0001:\u0006¸\u0003¹\u0003º\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\u001dH¦@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\b\u001a\u00020!H¦@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020$2\u0006\u0010\b\u001a\u00020%H¦@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020(2\u0006\u0010\b\u001a\u00020)H¦@¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020,2\u0006\u0010\b\u001a\u00020-H¦@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u0002002\u0006\u0010\b\u001a\u000201H¦@¢\u0006\u0002\u00102J\u0016\u00103\u001a\u0002042\u0006\u0010\b\u001a\u000205H¦@¢\u0006\u0002\u00106J\u0016\u00107\u001a\u0002082\u0006\u0010\b\u001a\u000209H¦@¢\u0006\u0002\u0010:J\u0016\u0010;\u001a\u00020<2\u0006\u0010\b\u001a\u00020=H¦@¢\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020@2\u0006\u0010\b\u001a\u00020AH¦@¢\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020D2\u0006\u0010\b\u001a\u00020EH¦@¢\u0006\u0002\u0010FJ\u0016\u0010G\u001a\u00020H2\u0006\u0010\b\u001a\u00020IH¦@¢\u0006\u0002\u0010JJ\u0016\u0010K\u001a\u00020L2\u0006\u0010\b\u001a\u00020MH¦@¢\u0006\u0002\u0010NJ\u0016\u0010O\u001a\u00020P2\u0006\u0010\b\u001a\u00020QH¦@¢\u0006\u0002\u0010RJ\u0016\u0010S\u001a\u00020T2\u0006\u0010\b\u001a\u00020UH¦@¢\u0006\u0002\u0010VJ\u0016\u0010W\u001a\u00020X2\u0006\u0010\b\u001a\u00020YH¦@¢\u0006\u0002\u0010ZJ\u0016\u0010[\u001a\u00020\\2\u0006\u0010\b\u001a\u00020]H¦@¢\u0006\u0002\u0010^J\u0016\u0010_\u001a\u00020`2\u0006\u0010\b\u001a\u00020aH¦@¢\u0006\u0002\u0010bJ\u0016\u0010c\u001a\u00020d2\u0006\u0010\b\u001a\u00020eH¦@¢\u0006\u0002\u0010fJ\u0016\u0010g\u001a\u00020h2\u0006\u0010\b\u001a\u00020iH¦@¢\u0006\u0002\u0010jJ\u0016\u0010k\u001a\u00020l2\u0006\u0010\b\u001a\u00020mH¦@¢\u0006\u0002\u0010nJ\u0016\u0010o\u001a\u00020p2\u0006\u0010\b\u001a\u00020qH¦@¢\u0006\u0002\u0010rJ\u0016\u0010s\u001a\u00020t2\u0006\u0010\b\u001a\u00020uH¦@¢\u0006\u0002\u0010vJ\u0016\u0010w\u001a\u00020x2\u0006\u0010\b\u001a\u00020yH¦@¢\u0006\u0002\u0010zJ\u0016\u0010{\u001a\u00020|2\u0006\u0010\b\u001a\u00020}H¦@¢\u0006\u0002\u0010~J\u0019\u0010\u007f\u001a\u00030\u0080\u00012\u0007\u0010\b\u001a\u00030\u0081\u0001H¦@¢\u0006\u0003\u0010\u0082\u0001J\u001a\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\b\u001a\u00030\u0085\u0001H¦@¢\u0006\u0003\u0010\u0086\u0001J\u001a\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0007\u0010\b\u001a\u00030\u0089\u0001H¦@¢\u0006\u0003\u0010\u008a\u0001J\u001a\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010\b\u001a\u00030\u008d\u0001H¦@¢\u0006\u0003\u0010\u008e\u0001J\u001a\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\b\u001a\u00030\u0091\u0001H¦@¢\u0006\u0003\u0010\u0092\u0001J\u001a\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\b\u001a\u00030\u0095\u0001H¦@¢\u0006\u0003\u0010\u0096\u0001J\u001a\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0007\u0010\b\u001a\u00030\u0099\u0001H¦@¢\u0006\u0003\u0010\u009a\u0001J\u001a\u0010\u009b\u0001\u001a\u00030\u009c\u00012\u0007\u0010\b\u001a\u00030\u009d\u0001H¦@¢\u0006\u0003\u0010\u009e\u0001J\u001a\u0010\u009f\u0001\u001a\u00030 \u00012\u0007\u0010\b\u001a\u00030¡\u0001H¦@¢\u0006\u0003\u0010¢\u0001J\u001a\u0010£\u0001\u001a\u00030¤\u00012\u0007\u0010\b\u001a\u00030¥\u0001H¦@¢\u0006\u0003\u0010¦\u0001J\u001a\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010\b\u001a\u00030©\u0001H¦@¢\u0006\u0003\u0010ª\u0001J\u001a\u0010«\u0001\u001a\u00030¬\u00012\u0007\u0010\b\u001a\u00030\u00ad\u0001H¦@¢\u0006\u0003\u0010®\u0001J\u001a\u0010¯\u0001\u001a\u00030°\u00012\u0007\u0010\b\u001a\u00030±\u0001H¦@¢\u0006\u0003\u0010²\u0001J\u001a\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010\b\u001a\u00030µ\u0001H¦@¢\u0006\u0003\u0010¶\u0001J\u001a\u0010·\u0001\u001a\u00030¸\u00012\u0007\u0010\b\u001a\u00030¹\u0001H¦@¢\u0006\u0003\u0010º\u0001J\u001a\u0010»\u0001\u001a\u00030¼\u00012\u0007\u0010\b\u001a\u00030½\u0001H¦@¢\u0006\u0003\u0010¾\u0001J\u001a\u0010¿\u0001\u001a\u00030À\u00012\u0007\u0010\b\u001a\u00030Á\u0001H¦@¢\u0006\u0003\u0010Â\u0001J\u001a\u0010Ã\u0001\u001a\u00030Ä\u00012\u0007\u0010\b\u001a\u00030Å\u0001H¦@¢\u0006\u0003\u0010Æ\u0001J\u001a\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010\b\u001a\u00030É\u0001H¦@¢\u0006\u0003\u0010Ê\u0001J\u001a\u0010Ë\u0001\u001a\u00030Ì\u00012\u0007\u0010\b\u001a\u00030Í\u0001H¦@¢\u0006\u0003\u0010Î\u0001JK\u0010Ï\u0001\u001a\u0003HÐ\u0001\"\u0005\b\u0000\u0010Ð\u00012\u0007\u0010\b\u001a\u00030Ñ\u00012(\u0010Ò\u0001\u001a#\b\u0001\u0012\u0005\u0012\u00030Ô\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u0003HÐ\u00010Õ\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010Ó\u0001H¦@¢\u0006\u0003\u0010×\u0001J\u001a\u0010Ø\u0001\u001a\u00030Ù\u00012\u0007\u0010\b\u001a\u00030Ú\u0001H¦@¢\u0006\u0003\u0010Û\u0001J\u001a\u0010Ü\u0001\u001a\u00030Ý\u00012\u0007\u0010\b\u001a\u00030Þ\u0001H¦@¢\u0006\u0003\u0010ß\u0001J\u001a\u0010à\u0001\u001a\u00030á\u00012\u0007\u0010\b\u001a\u00030â\u0001H¦@¢\u0006\u0003\u0010ã\u0001J\u001a\u0010ä\u0001\u001a\u00030å\u00012\u0007\u0010\b\u001a\u00030æ\u0001H¦@¢\u0006\u0003\u0010ç\u0001J\u001a\u0010è\u0001\u001a\u00030é\u00012\u0007\u0010\b\u001a\u00030ê\u0001H¦@¢\u0006\u0003\u0010ë\u0001J\u001a\u0010ì\u0001\u001a\u00030í\u00012\u0007\u0010\b\u001a\u00030î\u0001H¦@¢\u0006\u0003\u0010ï\u0001JK\u0010ð\u0001\u001a\u0003HÐ\u0001\"\u0005\b\u0000\u0010Ð\u00012\u0007\u0010\b\u001a\u00030ñ\u00012(\u0010Ò\u0001\u001a#\b\u0001\u0012\u0005\u0012\u00030ò\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u0003HÐ\u00010Õ\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010Ó\u0001H¦@¢\u0006\u0003\u0010ó\u0001J\u001a\u0010ô\u0001\u001a\u00030õ\u00012\u0007\u0010\b\u001a\u00030ö\u0001H¦@¢\u0006\u0003\u0010÷\u0001J\u001a\u0010ø\u0001\u001a\u00030ù\u00012\u0007\u0010\b\u001a\u00030ú\u0001H¦@¢\u0006\u0003\u0010û\u0001J\u001a\u0010ü\u0001\u001a\u00030ý\u00012\u0007\u0010\b\u001a\u00030þ\u0001H¦@¢\u0006\u0003\u0010ÿ\u0001J\u001a\u0010\u0080\u0002\u001a\u00030\u0081\u00022\u0007\u0010\b\u001a\u00030\u0082\u0002H¦@¢\u0006\u0003\u0010\u0083\u0002J\u001a\u0010\u0084\u0002\u001a\u00030\u0085\u00022\u0007\u0010\b\u001a\u00030\u0086\u0002H¦@¢\u0006\u0003\u0010\u0087\u0002J\u001a\u0010\u0088\u0002\u001a\u00030\u0089\u00022\u0007\u0010\b\u001a\u00030\u008a\u0002H¦@¢\u0006\u0003\u0010\u008b\u0002J\u001a\u0010\u008c\u0002\u001a\u00030\u008d\u00022\u0007\u0010\b\u001a\u00030\u008e\u0002H¦@¢\u0006\u0003\u0010\u008f\u0002J\u001c\u0010\u0090\u0002\u001a\u00030\u0091\u00022\t\b\u0002\u0010\b\u001a\u00030\u0092\u0002H¦@¢\u0006\u0003\u0010\u0093\u0002J\u001c\u0010\u0094\u0002\u001a\u00030\u0095\u00022\t\b\u0002\u0010\b\u001a\u00030\u0096\u0002H¦@¢\u0006\u0003\u0010\u0097\u0002J\u001a\u0010\u0098\u0002\u001a\u00030\u0099\u00022\u0007\u0010\b\u001a\u00030\u009a\u0002H¦@¢\u0006\u0003\u0010\u009b\u0002J\u001a\u0010\u009c\u0002\u001a\u00030\u009d\u00022\u0007\u0010\b\u001a\u00030\u009e\u0002H¦@¢\u0006\u0003\u0010\u009f\u0002J\u001a\u0010 \u0002\u001a\u00030¡\u00022\u0007\u0010\b\u001a\u00030¢\u0002H¦@¢\u0006\u0003\u0010£\u0002J\u001a\u0010¤\u0002\u001a\u00030¥\u00022\u0007\u0010\b\u001a\u00030¦\u0002H¦@¢\u0006\u0003\u0010§\u0002J\u001a\u0010¨\u0002\u001a\u00030©\u00022\u0007\u0010\b\u001a\u00030ª\u0002H¦@¢\u0006\u0003\u0010«\u0002J\u001a\u0010¬\u0002\u001a\u00030\u00ad\u00022\u0007\u0010\b\u001a\u00030®\u0002H¦@¢\u0006\u0003\u0010¯\u0002J\u001a\u0010°\u0002\u001a\u00030±\u00022\u0007\u0010\b\u001a\u00030²\u0002H¦@¢\u0006\u0003\u0010³\u0002J\u001a\u0010´\u0002\u001a\u00030µ\u00022\u0007\u0010\b\u001a\u00030¶\u0002H¦@¢\u0006\u0003\u0010·\u0002J\u001a\u0010¸\u0002\u001a\u00030¹\u00022\u0007\u0010\b\u001a\u00030º\u0002H¦@¢\u0006\u0003\u0010»\u0002J\u001a\u0010¼\u0002\u001a\u00030½\u00022\u0007\u0010\b\u001a\u00030¾\u0002H¦@¢\u0006\u0003\u0010¿\u0002J\u001a\u0010À\u0002\u001a\u00030Á\u00022\u0007\u0010\b\u001a\u00030Â\u0002H¦@¢\u0006\u0003\u0010Ã\u0002J\u001a\u0010Ä\u0002\u001a\u00030Å\u00022\u0007\u0010\b\u001a\u00030Æ\u0002H¦@¢\u0006\u0003\u0010Ç\u0002J\u001a\u0010È\u0002\u001a\u00030É\u00022\u0007\u0010\b\u001a\u00030Ê\u0002H¦@¢\u0006\u0003\u0010Ë\u0002J\u001a\u0010Ì\u0002\u001a\u00030Í\u00022\u0007\u0010\b\u001a\u00030Î\u0002H¦@¢\u0006\u0003\u0010Ï\u0002J\u001a\u0010Ð\u0002\u001a\u00030Ñ\u00022\u0007\u0010\b\u001a\u00030Ò\u0002H¦@¢\u0006\u0003\u0010Ó\u0002J\u001a\u0010Ô\u0002\u001a\u00030Õ\u00022\u0007\u0010\b\u001a\u00030Ö\u0002H¦@¢\u0006\u0003\u0010×\u0002J\u001a\u0010Ø\u0002\u001a\u00030Ù\u00022\u0007\u0010\b\u001a\u00030Ú\u0002H¦@¢\u0006\u0003\u0010Û\u0002J\u001a\u0010Ü\u0002\u001a\u00030Ý\u00022\u0007\u0010\b\u001a\u00030Þ\u0002H¦@¢\u0006\u0003\u0010ß\u0002J\u001a\u0010à\u0002\u001a\u00030á\u00022\u0007\u0010\b\u001a\u00030â\u0002H¦@¢\u0006\u0003\u0010ã\u0002J\u001a\u0010ä\u0002\u001a\u00030å\u00022\u0007\u0010\b\u001a\u00030æ\u0002H¦@¢\u0006\u0003\u0010ç\u0002J\u001a\u0010è\u0002\u001a\u00030é\u00022\u0007\u0010\b\u001a\u00030ê\u0002H¦@¢\u0006\u0003\u0010ë\u0002J\u001a\u0010ì\u0002\u001a\u00030í\u00022\u0007\u0010\b\u001a\u00030î\u0002H¦@¢\u0006\u0003\u0010ï\u0002J\u001a\u0010ð\u0002\u001a\u00030ñ\u00022\u0007\u0010\b\u001a\u00030ò\u0002H¦@¢\u0006\u0003\u0010ó\u0002J\u001a\u0010ô\u0002\u001a\u00030õ\u00022\u0007\u0010\b\u001a\u00030ö\u0002H¦@¢\u0006\u0003\u0010÷\u0002J\u001a\u0010ø\u0002\u001a\u00030ù\u00022\u0007\u0010\b\u001a\u00030ú\u0002H¦@¢\u0006\u0003\u0010û\u0002J\u001a\u0010ü\u0002\u001a\u00030ý\u00022\u0007\u0010\b\u001a\u00030þ\u0002H¦@¢\u0006\u0003\u0010ÿ\u0002J\u001a\u0010\u0080\u0003\u001a\u00030\u0081\u00032\u0007\u0010\b\u001a\u00030\u0082\u0003H¦@¢\u0006\u0003\u0010\u0083\u0003J\u001a\u0010\u0084\u0003\u001a\u00030\u0085\u00032\u0007\u0010\b\u001a\u00030\u0086\u0003H¦@¢\u0006\u0003\u0010\u0087\u0003J\u001a\u0010\u0088\u0003\u001a\u00030\u0089\u00032\u0007\u0010\b\u001a\u00030\u008a\u0003H¦@¢\u0006\u0003\u0010\u008b\u0003J\u001a\u0010\u008c\u0003\u001a\u00030\u008d\u00032\u0007\u0010\b\u001a\u00030\u008e\u0003H¦@¢\u0006\u0003\u0010\u008f\u0003J\u001a\u0010\u0090\u0003\u001a\u00030\u0091\u00032\u0007\u0010\b\u001a\u00030\u0092\u0003H¦@¢\u0006\u0003\u0010\u0093\u0003J\u001a\u0010\u0094\u0003\u001a\u00030\u0095\u00032\u0007\u0010\b\u001a\u00030\u0096\u0003H¦@¢\u0006\u0003\u0010\u0097\u0003J\u001a\u0010\u0098\u0003\u001a\u00030\u0099\u00032\u0007\u0010\b\u001a\u00030\u009a\u0003H¦@¢\u0006\u0003\u0010\u009b\u0003JK\u0010\u009c\u0003\u001a\u0003HÐ\u0001\"\u0005\b\u0000\u0010Ð\u00012\u0007\u0010\b\u001a\u00030\u009d\u00032(\u0010Ò\u0001\u001a#\b\u0001\u0012\u0005\u0012\u00030\u009e\u0003\u0012\f\u0012\n\u0012\u0005\u0012\u0003HÐ\u00010Õ\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010Ó\u0001H¦@¢\u0006\u0003\u0010\u009f\u0003J\u001a\u0010 \u0003\u001a\u00030¡\u00032\u0007\u0010\b\u001a\u00030¢\u0003H¦@¢\u0006\u0003\u0010£\u0003J\u001a\u0010¤\u0003\u001a\u00030¥\u00032\u0007\u0010\b\u001a\u00030¦\u0003H¦@¢\u0006\u0003\u0010§\u0003J\u001a\u0010¨\u0003\u001a\u00030©\u00032\u0007\u0010\b\u001a\u00030ª\u0003H¦@¢\u0006\u0003\u0010«\u0003J\u001a\u0010¬\u0003\u001a\u00030\u00ad\u00032\u0007\u0010\b\u001a\u00030®\u0003H¦@¢\u0006\u0003\u0010¯\u0003J\u001a\u0010°\u0003\u001a\u00030±\u00032\u0007\u0010\b\u001a\u00030²\u0003H¦@¢\u0006\u0003\u0010³\u0003J\u001a\u0010´\u0003\u001a\u00030µ\u00032\u0007\u0010\b\u001a\u00030¶\u0003H¦@¢\u0006\u0003\u0010·\u0003R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006»\u0003À\u0006\u0003"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/S3Client;", "Laws/smithy/kotlin/runtime/client/SdkClient;", "config", "Laws/sdk/kotlin/services/s3/S3Client$Config;", "getConfig", "()Laws/sdk/kotlin/services/s3/S3Client$Config;", "abortMultipartUpload", "Laws/sdk/kotlin/services/s3/model/AbortMultipartUploadResponse;", "input", "Laws/sdk/kotlin/services/s3/model/AbortMultipartUploadRequest;", "(Laws/sdk/kotlin/services/s3/model/AbortMultipartUploadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeMultipartUpload", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadResponse;", "Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest;", "(Laws/sdk/kotlin/services/s3/model/CompleteMultipartUploadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyObject", "Laws/sdk/kotlin/services/s3/model/CopyObjectResponse;", "Laws/sdk/kotlin/services/s3/model/CopyObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/CopyObjectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBucket", "Laws/sdk/kotlin/services/s3/model/CreateBucketResponse;", "Laws/sdk/kotlin/services/s3/model/CreateBucketRequest;", "(Laws/sdk/kotlin/services/s3/model/CreateBucketRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBucketMetadataConfiguration", "Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBucketMetadataTableConfiguration", "Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataTableConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/CreateBucketMetadataTableConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createMultipartUpload", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadResponse;", "Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest;", "(Laws/sdk/kotlin/services/s3/model/CreateMultipartUploadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSession", "Laws/sdk/kotlin/services/s3/model/CreateSessionResponse;", "Laws/sdk/kotlin/services/s3/model/CreateSessionRequest;", "(Laws/sdk/kotlin/services/s3/model/CreateSessionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucket", "Laws/sdk/kotlin/services/s3/model/DeleteBucketResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketAnalyticsConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketAnalyticsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketAnalyticsConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketAnalyticsConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketCors", "Laws/sdk/kotlin/services/s3/model/DeleteBucketCorsResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketCorsRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketCorsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketEncryption", "Laws/sdk/kotlin/services/s3/model/DeleteBucketEncryptionResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketEncryptionRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketEncryptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketIntelligentTieringConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketIntelligentTieringConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketIntelligentTieringConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketIntelligentTieringConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketInventoryConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketInventoryConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketInventoryConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketInventoryConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketLifecycle", "Laws/sdk/kotlin/services/s3/model/DeleteBucketLifecycleResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketLifecycleRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketLifecycleRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketMetadataConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketMetadataTableConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataTableConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketMetadataTableConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketMetricsConfiguration", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetricsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketMetricsConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketMetricsConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketOwnershipControls", "Laws/sdk/kotlin/services/s3/model/DeleteBucketOwnershipControlsResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketOwnershipControlsRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketOwnershipControlsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketPolicy", "Laws/sdk/kotlin/services/s3/model/DeleteBucketPolicyResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketPolicyRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketPolicyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketReplication", "Laws/sdk/kotlin/services/s3/model/DeleteBucketReplicationResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketReplicationRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketReplicationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketTagging", "Laws/sdk/kotlin/services/s3/model/DeleteBucketTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketTaggingRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketTaggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBucketWebsite", "Laws/sdk/kotlin/services/s3/model/DeleteBucketWebsiteResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteBucketWebsiteRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteBucketWebsiteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteObject", "Laws/sdk/kotlin/services/s3/model/DeleteObjectResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteObjectTagging", "Laws/sdk/kotlin/services/s3/model/DeleteObjectTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteObjectTaggingRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectTaggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteObjects", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsResponse;", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePublicAccessBlock", "Laws/sdk/kotlin/services/s3/model/DeletePublicAccessBlockResponse;", "Laws/sdk/kotlin/services/s3/model/DeletePublicAccessBlockRequest;", "(Laws/sdk/kotlin/services/s3/model/DeletePublicAccessBlockRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketAbac", "Laws/sdk/kotlin/services/s3/model/GetBucketAbacResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketAbacRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketAbacRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketAccelerateConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketAccelerateConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketAccelerateConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketAccelerateConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketAcl", "Laws/sdk/kotlin/services/s3/model/GetBucketAclResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketAclRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketAclRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketAnalyticsConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketAnalyticsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketAnalyticsConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketAnalyticsConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketCors", "Laws/sdk/kotlin/services/s3/model/GetBucketCorsResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketCorsRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketCorsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketEncryption", "Laws/sdk/kotlin/services/s3/model/GetBucketEncryptionResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketEncryptionRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketEncryptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketIntelligentTieringConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketInventoryConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketInventoryConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketInventoryConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketInventoryConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketLifecycleConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketLocation", "Laws/sdk/kotlin/services/s3/model/GetBucketLocationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketLocationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketLocationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketLogging", "Laws/sdk/kotlin/services/s3/model/GetBucketLoggingResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketLoggingRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketLoggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketMetadataConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketMetadataConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketMetadataTableConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketMetricsConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketMetricsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketMetricsConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketMetricsConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketNotificationConfiguration", "Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketOwnershipControls", "Laws/sdk/kotlin/services/s3/model/GetBucketOwnershipControlsResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketOwnershipControlsRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketOwnershipControlsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketPolicy", "Laws/sdk/kotlin/services/s3/model/GetBucketPolicyResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketPolicyRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketPolicyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketPolicyStatus", "Laws/sdk/kotlin/services/s3/model/GetBucketPolicyStatusResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketPolicyStatusRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketPolicyStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketReplication", "Laws/sdk/kotlin/services/s3/model/GetBucketReplicationResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketReplicationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketReplicationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketRequestPayment", "Laws/sdk/kotlin/services/s3/model/GetBucketRequestPaymentResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketRequestPaymentRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketRequestPaymentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketTagging", "Laws/sdk/kotlin/services/s3/model/GetBucketTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketTaggingRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketTaggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketVersioning", "Laws/sdk/kotlin/services/s3/model/GetBucketVersioningResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketVersioningRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketVersioningRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBucketWebsite", "Laws/sdk/kotlin/services/s3/model/GetBucketWebsiteResponse;", "Laws/sdk/kotlin/services/s3/model/GetBucketWebsiteRequest;", "(Laws/sdk/kotlin/services/s3/model/GetBucketWebsiteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObject", ExifInterface.GPS_DIRECTION_TRUE, "Laws/sdk/kotlin/services/s3/model/GetObjectRequest;", "block", "Lkotlin/Function2;", "Laws/sdk/kotlin/services/s3/model/GetObjectResponse;", "Lkotlin/coroutines/Continuation;", "", "(Laws/sdk/kotlin/services/s3/model/GetObjectRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectAcl", "Laws/sdk/kotlin/services/s3/model/GetObjectAclResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectAclRequest;", "(Laws/sdk/kotlin/services/s3/model/GetObjectAclRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectAttributes", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesRequest;", "(Laws/sdk/kotlin/services/s3/model/GetObjectAttributesRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectLegalHold", "Laws/sdk/kotlin/services/s3/model/GetObjectLegalHoldResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectLegalHoldRequest;", "(Laws/sdk/kotlin/services/s3/model/GetObjectLegalHoldRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectLockConfiguration", "Laws/sdk/kotlin/services/s3/model/GetObjectLockConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectLockConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/GetObjectLockConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectRetention", "Laws/sdk/kotlin/services/s3/model/GetObjectRetentionResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectRetentionRequest;", "(Laws/sdk/kotlin/services/s3/model/GetObjectRetentionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectTagging", "Laws/sdk/kotlin/services/s3/model/GetObjectTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/GetObjectTaggingRequest;", "(Laws/sdk/kotlin/services/s3/model/GetObjectTaggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObjectTorrent", "Laws/sdk/kotlin/services/s3/model/GetObjectTorrentRequest;", "Laws/sdk/kotlin/services/s3/model/GetObjectTorrentResponse;", "(Laws/sdk/kotlin/services/s3/model/GetObjectTorrentRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPublicAccessBlock", "Laws/sdk/kotlin/services/s3/model/GetPublicAccessBlockResponse;", "Laws/sdk/kotlin/services/s3/model/GetPublicAccessBlockRequest;", "(Laws/sdk/kotlin/services/s3/model/GetPublicAccessBlockRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "headBucket", "Laws/sdk/kotlin/services/s3/model/HeadBucketResponse;", "Laws/sdk/kotlin/services/s3/model/HeadBucketRequest;", "(Laws/sdk/kotlin/services/s3/model/HeadBucketRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "headObject", "Laws/sdk/kotlin/services/s3/model/HeadObjectResponse;", "Laws/sdk/kotlin/services/s3/model/HeadObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/HeadObjectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listBucketAnalyticsConfigurations", "Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listBucketIntelligentTieringConfigurations", "Laws/sdk/kotlin/services/s3/model/ListBucketIntelligentTieringConfigurationsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketIntelligentTieringConfigurationsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListBucketIntelligentTieringConfigurationsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listBucketInventoryConfigurations", "Laws/sdk/kotlin/services/s3/model/ListBucketInventoryConfigurationsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketInventoryConfigurationsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListBucketInventoryConfigurationsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listBucketMetricsConfigurations", "Laws/sdk/kotlin/services/s3/model/ListBucketMetricsConfigurationsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketMetricsConfigurationsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListBucketMetricsConfigurationsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listBuckets", "Laws/sdk/kotlin/services/s3/model/ListBucketsResponse;", "Laws/sdk/kotlin/services/s3/model/ListBucketsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListBucketsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listDirectoryBuckets", "Laws/sdk/kotlin/services/s3/model/ListDirectoryBucketsResponse;", "Laws/sdk/kotlin/services/s3/model/ListDirectoryBucketsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListDirectoryBucketsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listMultipartUploads", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsResponse;", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listObjectVersions", "Laws/sdk/kotlin/services/s3/model/ListObjectVersionsResponse;", "Laws/sdk/kotlin/services/s3/model/ListObjectVersionsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListObjectVersionsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listObjects", "Laws/sdk/kotlin/services/s3/model/ListObjectsResponse;", "Laws/sdk/kotlin/services/s3/model/ListObjectsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListObjectsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listObjectsV2", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Response;", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request;", "(Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listParts", "Laws/sdk/kotlin/services/s3/model/ListPartsResponse;", "Laws/sdk/kotlin/services/s3/model/ListPartsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListPartsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketAbac", "Laws/sdk/kotlin/services/s3/model/PutBucketAbacResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketAbacRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketAbacRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketAccelerateConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketAccelerateConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketAccelerateConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketAccelerateConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketAcl", "Laws/sdk/kotlin/services/s3/model/PutBucketAclResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketAnalyticsConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketCors", "Laws/sdk/kotlin/services/s3/model/PutBucketCorsResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketCorsRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketCorsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketEncryption", "Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketIntelligentTieringConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketIntelligentTieringConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketIntelligentTieringConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketIntelligentTieringConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketInventoryConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketInventoryConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketInventoryConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketInventoryConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketLifecycleConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketLogging", "Laws/sdk/kotlin/services/s3/model/PutBucketLoggingResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketLoggingRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketLoggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketMetricsConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketMetricsConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketMetricsConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketMetricsConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketNotificationConfiguration", "Laws/sdk/kotlin/services/s3/model/PutBucketNotificationConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketNotificationConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketNotificationConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketOwnershipControls", "Laws/sdk/kotlin/services/s3/model/PutBucketOwnershipControlsResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketOwnershipControlsRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketOwnershipControlsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketPolicy", "Laws/sdk/kotlin/services/s3/model/PutBucketPolicyResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketPolicyRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketPolicyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketReplication", "Laws/sdk/kotlin/services/s3/model/PutBucketReplicationResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketReplicationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketReplicationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketRequestPayment", "Laws/sdk/kotlin/services/s3/model/PutBucketRequestPaymentResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketRequestPaymentRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketRequestPaymentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketTagging", "Laws/sdk/kotlin/services/s3/model/PutBucketTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketTaggingRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketTaggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketVersioning", "Laws/sdk/kotlin/services/s3/model/PutBucketVersioningResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketVersioningRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketVersioningRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBucketWebsite", "Laws/sdk/kotlin/services/s3/model/PutBucketWebsiteResponse;", "Laws/sdk/kotlin/services/s3/model/PutBucketWebsiteRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketWebsiteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putObject", "Laws/sdk/kotlin/services/s3/model/PutObjectResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putObjectAcl", "Laws/sdk/kotlin/services/s3/model/PutObjectAclResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectAclRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectAclRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putObjectLegalHold", "Laws/sdk/kotlin/services/s3/model/PutObjectLegalHoldResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectLegalHoldRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectLegalHoldRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putObjectLockConfiguration", "Laws/sdk/kotlin/services/s3/model/PutObjectLockConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectLockConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectLockConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putObjectRetention", "Laws/sdk/kotlin/services/s3/model/PutObjectRetentionResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectRetentionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putObjectTagging", "Laws/sdk/kotlin/services/s3/model/PutObjectTaggingResponse;", "Laws/sdk/kotlin/services/s3/model/PutObjectTaggingRequest;", "(Laws/sdk/kotlin/services/s3/model/PutObjectTaggingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putPublicAccessBlock", "Laws/sdk/kotlin/services/s3/model/PutPublicAccessBlockResponse;", "Laws/sdk/kotlin/services/s3/model/PutPublicAccessBlockRequest;", "(Laws/sdk/kotlin/services/s3/model/PutPublicAccessBlockRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renameObject", "Laws/sdk/kotlin/services/s3/model/RenameObjectResponse;", "Laws/sdk/kotlin/services/s3/model/RenameObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/RenameObjectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreObject", "Laws/sdk/kotlin/services/s3/model/RestoreObjectResponse;", "Laws/sdk/kotlin/services/s3/model/RestoreObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/RestoreObjectRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectObjectContent", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentResponse;", "(Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBucketMetadataInventoryTableConfiguration", "Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataInventoryTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataInventoryTableConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataInventoryTableConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBucketMetadataJournalTableConfiguration", "Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataJournalTableConfigurationResponse;", "Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataJournalTableConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/UpdateBucketMetadataJournalTableConfigurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateObjectEncryption", "Laws/sdk/kotlin/services/s3/model/UpdateObjectEncryptionResponse;", "Laws/sdk/kotlin/services/s3/model/UpdateObjectEncryptionRequest;", "(Laws/sdk/kotlin/services/s3/model/UpdateObjectEncryptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadPart", "Laws/sdk/kotlin/services/s3/model/UploadPartResponse;", "Laws/sdk/kotlin/services/s3/model/UploadPartRequest;", "(Laws/sdk/kotlin/services/s3/model/UploadPartRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadPartCopy", "Laws/sdk/kotlin/services/s3/model/UploadPartCopyResponse;", "Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest;", "(Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeGetObjectResponse", "Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseResponse;", "Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest;", "(Laws/sdk/kotlin/services/s3/model/WriteGetObjectResponseRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Builder", "Config", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface S3Client extends SdkClient {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmStatic
    static Builder builder() {
        return INSTANCE.builder();
    }

    Object abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest, Continuation<? super AbortMultipartUploadResponse> continuation);

    Object completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest, Continuation<? super CompleteMultipartUploadResponse> continuation);

    Object copyObject(CopyObjectRequest copyObjectRequest, Continuation<? super CopyObjectResponse> continuation);

    Object createBucket(CreateBucketRequest createBucketRequest, Continuation<? super CreateBucketResponse> continuation);

    Object createBucketMetadataConfiguration(CreateBucketMetadataConfigurationRequest createBucketMetadataConfigurationRequest, Continuation<? super CreateBucketMetadataConfigurationResponse> continuation);

    Object createBucketMetadataTableConfiguration(CreateBucketMetadataTableConfigurationRequest createBucketMetadataTableConfigurationRequest, Continuation<? super CreateBucketMetadataTableConfigurationResponse> continuation);

    Object createMultipartUpload(CreateMultipartUploadRequest createMultipartUploadRequest, Continuation<? super CreateMultipartUploadResponse> continuation);

    Object createSession(CreateSessionRequest createSessionRequest, Continuation<? super CreateSessionResponse> continuation);

    Object deleteBucket(DeleteBucketRequest deleteBucketRequest, Continuation<? super DeleteBucketResponse> continuation);

    Object deleteBucketAnalyticsConfiguration(DeleteBucketAnalyticsConfigurationRequest deleteBucketAnalyticsConfigurationRequest, Continuation<? super DeleteBucketAnalyticsConfigurationResponse> continuation);

    Object deleteBucketCors(DeleteBucketCorsRequest deleteBucketCorsRequest, Continuation<? super DeleteBucketCorsResponse> continuation);

    Object deleteBucketEncryption(DeleteBucketEncryptionRequest deleteBucketEncryptionRequest, Continuation<? super DeleteBucketEncryptionResponse> continuation);

    Object deleteBucketIntelligentTieringConfiguration(DeleteBucketIntelligentTieringConfigurationRequest deleteBucketIntelligentTieringConfigurationRequest, Continuation<? super DeleteBucketIntelligentTieringConfigurationResponse> continuation);

    Object deleteBucketInventoryConfiguration(DeleteBucketInventoryConfigurationRequest deleteBucketInventoryConfigurationRequest, Continuation<? super DeleteBucketInventoryConfigurationResponse> continuation);

    Object deleteBucketLifecycle(DeleteBucketLifecycleRequest deleteBucketLifecycleRequest, Continuation<? super DeleteBucketLifecycleResponse> continuation);

    Object deleteBucketMetadataConfiguration(DeleteBucketMetadataConfigurationRequest deleteBucketMetadataConfigurationRequest, Continuation<? super DeleteBucketMetadataConfigurationResponse> continuation);

    Object deleteBucketMetadataTableConfiguration(DeleteBucketMetadataTableConfigurationRequest deleteBucketMetadataTableConfigurationRequest, Continuation<? super DeleteBucketMetadataTableConfigurationResponse> continuation);

    Object deleteBucketMetricsConfiguration(DeleteBucketMetricsConfigurationRequest deleteBucketMetricsConfigurationRequest, Continuation<? super DeleteBucketMetricsConfigurationResponse> continuation);

    Object deleteBucketOwnershipControls(DeleteBucketOwnershipControlsRequest deleteBucketOwnershipControlsRequest, Continuation<? super DeleteBucketOwnershipControlsResponse> continuation);

    Object deleteBucketPolicy(DeleteBucketPolicyRequest deleteBucketPolicyRequest, Continuation<? super DeleteBucketPolicyResponse> continuation);

    Object deleteBucketReplication(DeleteBucketReplicationRequest deleteBucketReplicationRequest, Continuation<? super DeleteBucketReplicationResponse> continuation);

    Object deleteBucketTagging(DeleteBucketTaggingRequest deleteBucketTaggingRequest, Continuation<? super DeleteBucketTaggingResponse> continuation);

    Object deleteBucketWebsite(DeleteBucketWebsiteRequest deleteBucketWebsiteRequest, Continuation<? super DeleteBucketWebsiteResponse> continuation);

    Object deleteObject(DeleteObjectRequest deleteObjectRequest, Continuation<? super DeleteObjectResponse> continuation);

    Object deleteObjectTagging(DeleteObjectTaggingRequest deleteObjectTaggingRequest, Continuation<? super DeleteObjectTaggingResponse> continuation);

    Object deleteObjects(DeleteObjectsRequest deleteObjectsRequest, Continuation<? super DeleteObjectsResponse> continuation);

    Object deletePublicAccessBlock(DeletePublicAccessBlockRequest deletePublicAccessBlockRequest, Continuation<? super DeletePublicAccessBlockResponse> continuation);

    Object getBucketAbac(GetBucketAbacRequest getBucketAbacRequest, Continuation<? super GetBucketAbacResponse> continuation);

    Object getBucketAccelerateConfiguration(GetBucketAccelerateConfigurationRequest getBucketAccelerateConfigurationRequest, Continuation<? super GetBucketAccelerateConfigurationResponse> continuation);

    Object getBucketAcl(GetBucketAclRequest getBucketAclRequest, Continuation<? super GetBucketAclResponse> continuation);

    Object getBucketAnalyticsConfiguration(GetBucketAnalyticsConfigurationRequest getBucketAnalyticsConfigurationRequest, Continuation<? super GetBucketAnalyticsConfigurationResponse> continuation);

    Object getBucketCors(GetBucketCorsRequest getBucketCorsRequest, Continuation<? super GetBucketCorsResponse> continuation);

    Object getBucketEncryption(GetBucketEncryptionRequest getBucketEncryptionRequest, Continuation<? super GetBucketEncryptionResponse> continuation);

    Object getBucketIntelligentTieringConfiguration(GetBucketIntelligentTieringConfigurationRequest getBucketIntelligentTieringConfigurationRequest, Continuation<? super GetBucketIntelligentTieringConfigurationResponse> continuation);

    Object getBucketInventoryConfiguration(GetBucketInventoryConfigurationRequest getBucketInventoryConfigurationRequest, Continuation<? super GetBucketInventoryConfigurationResponse> continuation);

    Object getBucketLifecycleConfiguration(GetBucketLifecycleConfigurationRequest getBucketLifecycleConfigurationRequest, Continuation<? super GetBucketLifecycleConfigurationResponse> continuation);

    Object getBucketLocation(GetBucketLocationRequest getBucketLocationRequest, Continuation<? super GetBucketLocationResponse> continuation);

    Object getBucketLogging(GetBucketLoggingRequest getBucketLoggingRequest, Continuation<? super GetBucketLoggingResponse> continuation);

    Object getBucketMetadataConfiguration(GetBucketMetadataConfigurationRequest getBucketMetadataConfigurationRequest, Continuation<? super GetBucketMetadataConfigurationResponse> continuation);

    Object getBucketMetadataTableConfiguration(GetBucketMetadataTableConfigurationRequest getBucketMetadataTableConfigurationRequest, Continuation<? super GetBucketMetadataTableConfigurationResponse> continuation);

    Object getBucketMetricsConfiguration(GetBucketMetricsConfigurationRequest getBucketMetricsConfigurationRequest, Continuation<? super GetBucketMetricsConfigurationResponse> continuation);

    Object getBucketNotificationConfiguration(GetBucketNotificationConfigurationRequest getBucketNotificationConfigurationRequest, Continuation<? super GetBucketNotificationConfigurationResponse> continuation);

    Object getBucketOwnershipControls(GetBucketOwnershipControlsRequest getBucketOwnershipControlsRequest, Continuation<? super GetBucketOwnershipControlsResponse> continuation);

    Object getBucketPolicy(GetBucketPolicyRequest getBucketPolicyRequest, Continuation<? super GetBucketPolicyResponse> continuation);

    Object getBucketPolicyStatus(GetBucketPolicyStatusRequest getBucketPolicyStatusRequest, Continuation<? super GetBucketPolicyStatusResponse> continuation);

    Object getBucketReplication(GetBucketReplicationRequest getBucketReplicationRequest, Continuation<? super GetBucketReplicationResponse> continuation);

    Object getBucketRequestPayment(GetBucketRequestPaymentRequest getBucketRequestPaymentRequest, Continuation<? super GetBucketRequestPaymentResponse> continuation);

    Object getBucketTagging(GetBucketTaggingRequest getBucketTaggingRequest, Continuation<? super GetBucketTaggingResponse> continuation);

    Object getBucketVersioning(GetBucketVersioningRequest getBucketVersioningRequest, Continuation<? super GetBucketVersioningResponse> continuation);

    Object getBucketWebsite(GetBucketWebsiteRequest getBucketWebsiteRequest, Continuation<? super GetBucketWebsiteResponse> continuation);

    @Override // aws.smithy.kotlin.runtime.client.SdkClient
    Config getConfig();

    <T> Object getObject(GetObjectRequest getObjectRequest, Function2<? super GetObjectResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);

    Object getObjectAcl(GetObjectAclRequest getObjectAclRequest, Continuation<? super GetObjectAclResponse> continuation);

    Object getObjectAttributes(GetObjectAttributesRequest getObjectAttributesRequest, Continuation<? super GetObjectAttributesResponse> continuation);

    Object getObjectLegalHold(GetObjectLegalHoldRequest getObjectLegalHoldRequest, Continuation<? super GetObjectLegalHoldResponse> continuation);

    Object getObjectLockConfiguration(GetObjectLockConfigurationRequest getObjectLockConfigurationRequest, Continuation<? super GetObjectLockConfigurationResponse> continuation);

    Object getObjectRetention(GetObjectRetentionRequest getObjectRetentionRequest, Continuation<? super GetObjectRetentionResponse> continuation);

    Object getObjectTagging(GetObjectTaggingRequest getObjectTaggingRequest, Continuation<? super GetObjectTaggingResponse> continuation);

    <T> Object getObjectTorrent(GetObjectTorrentRequest getObjectTorrentRequest, Function2<? super GetObjectTorrentResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);

    Object getPublicAccessBlock(GetPublicAccessBlockRequest getPublicAccessBlockRequest, Continuation<? super GetPublicAccessBlockResponse> continuation);

    Object headBucket(HeadBucketRequest headBucketRequest, Continuation<? super HeadBucketResponse> continuation);

    Object headObject(HeadObjectRequest headObjectRequest, Continuation<? super HeadObjectResponse> continuation);

    Object listBucketAnalyticsConfigurations(ListBucketAnalyticsConfigurationsRequest listBucketAnalyticsConfigurationsRequest, Continuation<? super ListBucketAnalyticsConfigurationsResponse> continuation);

    Object listBucketIntelligentTieringConfigurations(ListBucketIntelligentTieringConfigurationsRequest listBucketIntelligentTieringConfigurationsRequest, Continuation<? super ListBucketIntelligentTieringConfigurationsResponse> continuation);

    Object listBucketInventoryConfigurations(ListBucketInventoryConfigurationsRequest listBucketInventoryConfigurationsRequest, Continuation<? super ListBucketInventoryConfigurationsResponse> continuation);

    Object listBucketMetricsConfigurations(ListBucketMetricsConfigurationsRequest listBucketMetricsConfigurationsRequest, Continuation<? super ListBucketMetricsConfigurationsResponse> continuation);

    Object listBuckets(ListBucketsRequest listBucketsRequest, Continuation<? super ListBucketsResponse> continuation);

    Object listDirectoryBuckets(ListDirectoryBucketsRequest listDirectoryBucketsRequest, Continuation<? super ListDirectoryBucketsResponse> continuation);

    Object listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest, Continuation<? super ListMultipartUploadsResponse> continuation);

    Object listObjectVersions(ListObjectVersionsRequest listObjectVersionsRequest, Continuation<? super ListObjectVersionsResponse> continuation);

    Object listObjects(ListObjectsRequest listObjectsRequest, Continuation<? super ListObjectsResponse> continuation);

    Object listObjectsV2(ListObjectsV2Request listObjectsV2Request, Continuation<? super ListObjectsV2Response> continuation);

    Object listParts(ListPartsRequest listPartsRequest, Continuation<? super ListPartsResponse> continuation);

    Object putBucketAbac(PutBucketAbacRequest putBucketAbacRequest, Continuation<? super PutBucketAbacResponse> continuation);

    Object putBucketAccelerateConfiguration(PutBucketAccelerateConfigurationRequest putBucketAccelerateConfigurationRequest, Continuation<? super PutBucketAccelerateConfigurationResponse> continuation);

    Object putBucketAcl(PutBucketAclRequest putBucketAclRequest, Continuation<? super PutBucketAclResponse> continuation);

    Object putBucketAnalyticsConfiguration(PutBucketAnalyticsConfigurationRequest putBucketAnalyticsConfigurationRequest, Continuation<? super PutBucketAnalyticsConfigurationResponse> continuation);

    Object putBucketCors(PutBucketCorsRequest putBucketCorsRequest, Continuation<? super PutBucketCorsResponse> continuation);

    Object putBucketEncryption(PutBucketEncryptionRequest putBucketEncryptionRequest, Continuation<? super PutBucketEncryptionResponse> continuation);

    Object putBucketIntelligentTieringConfiguration(PutBucketIntelligentTieringConfigurationRequest putBucketIntelligentTieringConfigurationRequest, Continuation<? super PutBucketIntelligentTieringConfigurationResponse> continuation);

    Object putBucketInventoryConfiguration(PutBucketInventoryConfigurationRequest putBucketInventoryConfigurationRequest, Continuation<? super PutBucketInventoryConfigurationResponse> continuation);

    Object putBucketLifecycleConfiguration(PutBucketLifecycleConfigurationRequest putBucketLifecycleConfigurationRequest, Continuation<? super PutBucketLifecycleConfigurationResponse> continuation);

    Object putBucketLogging(PutBucketLoggingRequest putBucketLoggingRequest, Continuation<? super PutBucketLoggingResponse> continuation);

    Object putBucketMetricsConfiguration(PutBucketMetricsConfigurationRequest putBucketMetricsConfigurationRequest, Continuation<? super PutBucketMetricsConfigurationResponse> continuation);

    Object putBucketNotificationConfiguration(PutBucketNotificationConfigurationRequest putBucketNotificationConfigurationRequest, Continuation<? super PutBucketNotificationConfigurationResponse> continuation);

    Object putBucketOwnershipControls(PutBucketOwnershipControlsRequest putBucketOwnershipControlsRequest, Continuation<? super PutBucketOwnershipControlsResponse> continuation);

    Object putBucketPolicy(PutBucketPolicyRequest putBucketPolicyRequest, Continuation<? super PutBucketPolicyResponse> continuation);

    Object putBucketReplication(PutBucketReplicationRequest putBucketReplicationRequest, Continuation<? super PutBucketReplicationResponse> continuation);

    Object putBucketRequestPayment(PutBucketRequestPaymentRequest putBucketRequestPaymentRequest, Continuation<? super PutBucketRequestPaymentResponse> continuation);

    Object putBucketTagging(PutBucketTaggingRequest putBucketTaggingRequest, Continuation<? super PutBucketTaggingResponse> continuation);

    Object putBucketVersioning(PutBucketVersioningRequest putBucketVersioningRequest, Continuation<? super PutBucketVersioningResponse> continuation);

    Object putBucketWebsite(PutBucketWebsiteRequest putBucketWebsiteRequest, Continuation<? super PutBucketWebsiteResponse> continuation);

    Object putObject(PutObjectRequest putObjectRequest, Continuation<? super PutObjectResponse> continuation);

    Object putObjectAcl(PutObjectAclRequest putObjectAclRequest, Continuation<? super PutObjectAclResponse> continuation);

    Object putObjectLegalHold(PutObjectLegalHoldRequest putObjectLegalHoldRequest, Continuation<? super PutObjectLegalHoldResponse> continuation);

    Object putObjectLockConfiguration(PutObjectLockConfigurationRequest putObjectLockConfigurationRequest, Continuation<? super PutObjectLockConfigurationResponse> continuation);

    Object putObjectRetention(PutObjectRetentionRequest putObjectRetentionRequest, Continuation<? super PutObjectRetentionResponse> continuation);

    Object putObjectTagging(PutObjectTaggingRequest putObjectTaggingRequest, Continuation<? super PutObjectTaggingResponse> continuation);

    Object putPublicAccessBlock(PutPublicAccessBlockRequest putPublicAccessBlockRequest, Continuation<? super PutPublicAccessBlockResponse> continuation);

    Object renameObject(RenameObjectRequest renameObjectRequest, Continuation<? super RenameObjectResponse> continuation);

    Object restoreObject(RestoreObjectRequest restoreObjectRequest, Continuation<? super RestoreObjectResponse> continuation);

    <T> Object selectObjectContent(SelectObjectContentRequest selectObjectContentRequest, Function2<? super SelectObjectContentResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);

    Object updateBucketMetadataInventoryTableConfiguration(UpdateBucketMetadataInventoryTableConfigurationRequest updateBucketMetadataInventoryTableConfigurationRequest, Continuation<? super UpdateBucketMetadataInventoryTableConfigurationResponse> continuation);

    Object updateBucketMetadataJournalTableConfiguration(UpdateBucketMetadataJournalTableConfigurationRequest updateBucketMetadataJournalTableConfigurationRequest, Continuation<? super UpdateBucketMetadataJournalTableConfigurationResponse> continuation);

    Object updateObjectEncryption(UpdateObjectEncryptionRequest updateObjectEncryptionRequest, Continuation<? super UpdateObjectEncryptionResponse> continuation);

    Object uploadPart(UploadPartRequest uploadPartRequest, Continuation<? super UploadPartResponse> continuation);

    Object uploadPartCopy(UploadPartCopyRequest uploadPartCopyRequest, Continuation<? super UploadPartCopyResponse> continuation);

    Object writeGetObjectResponse(WriteGetObjectResponseRequest writeGetObjectResponseRequest, Continuation<? super WriteGetObjectResponseResponse> continuation);

    /* JADX INFO: compiled from: S3Client.kt */
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0017J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0014J6\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110\rH\u0094@¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/S3Client$Companion;", "Laws/sdk/kotlin/runtime/config/AbstractAwsSdkClientFactory;", "Laws/sdk/kotlin/services/s3/S3Client$Config;", "Laws/sdk/kotlin/services/s3/S3Client$Config$Builder;", "Laws/sdk/kotlin/services/s3/S3Client;", "Laws/sdk/kotlin/services/s3/S3Client$Builder;", "<init>", "()V", "builder", "finalizeConfig", "", "finalizeEnvironmentalConfig", "sharedConfig", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;", "activeProfile", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "(Laws/sdk/kotlin/services/s3/S3Client$Builder;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion extends AbstractAwsSdkClientFactory<Config, Config.Builder, S3Client, Builder> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @Override // aws.sdk.kotlin.runtime.config.AbstractAwsSdkClientFactory
        public /* bridge */ /* synthetic */ Object finalizeEnvironmentalConfig(SdkClient.Builder builder, LazyAsyncValue lazyAsyncValue, LazyAsyncValue lazyAsyncValue2, Continuation continuation) {
            return finalizeEnvironmentalConfig((Builder) builder, (LazyAsyncValue<AwsSharedConfig>) lazyAsyncValue, (LazyAsyncValue<ConfigSection>) lazyAsyncValue2, (Continuation<? super Unit>) continuation);
        }

        @Override // aws.smithy.kotlin.runtime.client.SdkClientFactory
        @JvmStatic
        public Builder builder() {
            return new Builder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // aws.smithy.kotlin.runtime.client.AbstractSdkClientFactory
        public void finalizeConfig(Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            super.finalizeConfig(builder);
            builder.getConfig().getInterceptors().add(0, new ClockSkewInterceptor());
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00e7, code lost:
        
            if (aws.sdk.kotlin.services.p010s3.internal.FinalizeS3ConfigKt.finalizeS3Config$default(r1, r2, null, r6, 4, null) == r0) goto L31;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected Object finalizeEnvironmentalConfig(Builder builder, LazyAsyncValue<AwsSharedConfig> lazyAsyncValue, LazyAsyncValue<ConfigSection> lazyAsyncValue2, Continuation<? super Unit> continuation) {
            S3Client$Companion$finalizeEnvironmentalConfig$1 s3Client$Companion$finalizeEnvironmentalConfig$1;
            Config.Builder config;
            Url endpointUrl;
            S3Client$Companion$finalizeEnvironmentalConfig$1 s3Client$Companion$finalizeEnvironmentalConfig$12;
            LazyAsyncValue<AwsSharedConfig> lazyAsyncValue3;
            Builder builder2;
            Config.Builder builder3;
            LazyAsyncValue<ConfigSection> lazyAsyncValue4;
            LazyAsyncValue<AwsSharedConfig> lazyAsyncValue5;
            if (continuation instanceof S3Client$Companion$finalizeEnvironmentalConfig$1) {
                s3Client$Companion$finalizeEnvironmentalConfig$1 = (S3Client$Companion$finalizeEnvironmentalConfig$1) continuation;
                if ((s3Client$Companion$finalizeEnvironmentalConfig$1.label & Integer.MIN_VALUE) != 0) {
                    s3Client$Companion$finalizeEnvironmentalConfig$1.label -= Integer.MIN_VALUE;
                } else {
                    s3Client$Companion$finalizeEnvironmentalConfig$1 = new S3Client$Companion$finalizeEnvironmentalConfig$1(this, continuation);
                }
            }
            S3Client$Companion$finalizeEnvironmentalConfig$1 s3Client$Companion$finalizeEnvironmentalConfig$13 = s3Client$Companion$finalizeEnvironmentalConfig$1;
            Object objResolveEndpointUrl$default = s3Client$Companion$finalizeEnvironmentalConfig$13.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = s3Client$Companion$finalizeEnvironmentalConfig$13.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objResolveEndpointUrl$default);
                s3Client$Companion$finalizeEnvironmentalConfig$13.L$0 = builder;
                s3Client$Companion$finalizeEnvironmentalConfig$13.L$1 = lazyAsyncValue;
                s3Client$Companion$finalizeEnvironmentalConfig$13.L$2 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue2);
                s3Client$Companion$finalizeEnvironmentalConfig$13.label = 1;
                if (super.finalizeEnvironmentalConfig(builder, lazyAsyncValue, lazyAsyncValue2, (Continuation<? super Unit>) s3Client$Companion$finalizeEnvironmentalConfig$13) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                lazyAsyncValue2 = (LazyAsyncValue) s3Client$Companion$finalizeEnvironmentalConfig$13.L$2;
                lazyAsyncValue = (LazyAsyncValue) s3Client$Companion$finalizeEnvironmentalConfig$13.L$1;
                builder = (Builder) s3Client$Companion$finalizeEnvironmentalConfig$13.L$0;
                ResultKt.throwOnFailure(objResolveEndpointUrl$default);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objResolveEndpointUrl$default);
                    return Unit.INSTANCE;
                }
                builder3 = (Config.Builder) s3Client$Companion$finalizeEnvironmentalConfig$13.L$3;
                lazyAsyncValue4 = (LazyAsyncValue) s3Client$Companion$finalizeEnvironmentalConfig$13.L$2;
                lazyAsyncValue5 = (LazyAsyncValue) s3Client$Companion$finalizeEnvironmentalConfig$13.L$1;
                builder2 = (Builder) s3Client$Companion$finalizeEnvironmentalConfig$13.L$0;
                ResultKt.throwOnFailure(objResolveEndpointUrl$default);
                s3Client$Companion$finalizeEnvironmentalConfig$12 = s3Client$Companion$finalizeEnvironmentalConfig$13;
                endpointUrl = (Url) objResolveEndpointUrl$default;
                lazyAsyncValue3 = lazyAsyncValue5;
                lazyAsyncValue2 = lazyAsyncValue4;
                config = builder3;
                config.setEndpointUrl(endpointUrl);
                s3Client$Companion$finalizeEnvironmentalConfig$12.L$0 = SpillingKt.nullOutSpilledVariable(builder2);
                s3Client$Companion$finalizeEnvironmentalConfig$12.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue3);
                s3Client$Companion$finalizeEnvironmentalConfig$12.L$2 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue2);
                s3Client$Companion$finalizeEnvironmentalConfig$12.L$3 = null;
                s3Client$Companion$finalizeEnvironmentalConfig$12.label = 3;
            }
            LazyAsyncValue<AwsSharedConfig> lazyAsyncValue6 = lazyAsyncValue;
            config = builder.getConfig();
            endpointUrl = builder.getConfig().getEndpointUrl();
            if (endpointUrl == null) {
                s3Client$Companion$finalizeEnvironmentalConfig$13.L$0 = builder;
                s3Client$Companion$finalizeEnvironmentalConfig$13.L$1 = lazyAsyncValue6;
                s3Client$Companion$finalizeEnvironmentalConfig$13.L$2 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue2);
                s3Client$Companion$finalizeEnvironmentalConfig$13.L$3 = config;
                s3Client$Companion$finalizeEnvironmentalConfig$13.label = 2;
                s3Client$Companion$finalizeEnvironmentalConfig$12 = s3Client$Companion$finalizeEnvironmentalConfig$13;
                objResolveEndpointUrl$default = ResolversKt.resolveEndpointUrl$default(lazyAsyncValue6, S3ClientKt.ServiceId, S3ClientKt.ServiceId, "s3", null, s3Client$Companion$finalizeEnvironmentalConfig$12, 16, null);
                if (objResolveEndpointUrl$default != coroutine_suspended) {
                    builder2 = builder;
                    builder3 = config;
                    lazyAsyncValue4 = lazyAsyncValue2;
                    lazyAsyncValue5 = lazyAsyncValue6;
                    endpointUrl = (Url) objResolveEndpointUrl$default;
                    lazyAsyncValue3 = lazyAsyncValue5;
                    lazyAsyncValue2 = lazyAsyncValue4;
                    config = builder3;
                    config.setEndpointUrl(endpointUrl);
                    s3Client$Companion$finalizeEnvironmentalConfig$12.L$0 = SpillingKt.nullOutSpilledVariable(builder2);
                    s3Client$Companion$finalizeEnvironmentalConfig$12.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue3);
                    s3Client$Companion$finalizeEnvironmentalConfig$12.L$2 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue2);
                    s3Client$Companion$finalizeEnvironmentalConfig$12.L$3 = null;
                    s3Client$Companion$finalizeEnvironmentalConfig$12.label = 3;
                }
                return coroutine_suspended;
            }
            s3Client$Companion$finalizeEnvironmentalConfig$12 = s3Client$Companion$finalizeEnvironmentalConfig$13;
            lazyAsyncValue3 = lazyAsyncValue6;
            builder2 = builder;
            config.setEndpointUrl(endpointUrl);
            s3Client$Companion$finalizeEnvironmentalConfig$12.L$0 = SpillingKt.nullOutSpilledVariable(builder2);
            s3Client$Companion$finalizeEnvironmentalConfig$12.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue3);
            s3Client$Companion$finalizeEnvironmentalConfig$12.L$2 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue2);
            s3Client$Companion$finalizeEnvironmentalConfig$12.L$3 = null;
            s3Client$Companion$finalizeEnvironmentalConfig$12.label = 3;
        }
    }

    /* JADX INFO: compiled from: S3Client.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\t\b\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0014R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/S3Client$Builder;", "Laws/smithy/kotlin/runtime/client/AbstractSdkClientBuilder;", "Laws/sdk/kotlin/services/s3/S3Client$Config;", "Laws/sdk/kotlin/services/s3/S3Client$Config$Builder;", "Laws/sdk/kotlin/services/s3/S3Client;", "<init>", "()V", "config", "getConfig", "()Laws/sdk/kotlin/services/s3/S3Client$Config$Builder;", "newClient", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder extends AbstractSdkClientBuilder<Config, Config.Builder, S3Client> {
        private final Config.Builder config = new Config.Builder();

        @Override // aws.smithy.kotlin.runtime.client.SdkClient.Builder
        public Config.Builder getConfig() {
            return this.config;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // aws.smithy.kotlin.runtime.client.AbstractSdkClientBuilder
        public S3Client newClient(Config config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new DefaultS3Client(config);
        }
    }

    /* JADX INFO: compiled from: S3Client.kt */
    @Metadata(m1598d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0081\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r:\u0004\u0081\u0001\u0082\u0001B\u0011\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010x\u001a\u00020\u000fR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020&0!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0016\u0010(\u001a\u0004\u0018\u00010\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0015\u0010*\u001a\u0004\u0018\u00010+¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0014\u0010/\u001a\u000200X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u00107\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b8\u00106R\u0011\u00109\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b:\u00106R\u0011\u0010;\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b<\u00106R\u0011\u0010=\u001a\u00020>¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010A\u001a\u0004\u0018\u00010B¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010E\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\bF\u00102R\u0011\u0010G\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\bH\u00106R\u0014\u0010I\u001a\u00020JX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR6\u0010M\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020Q0Nj\u0002`R0!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010$R\u0014\u0010T\u001a\u00020UX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020YX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020]X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u001c\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010O0aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u001c\u0010d\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0014\u0010h\u001a\u00020iX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0011\u0010l\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\bm\u00106R\u0014\u0010n\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u00106R\u0014\u0010p\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u00106R\u0016\u0010r\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u0015R\u0011\u0010t\u001a\u00020u¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0012\u0010y\u001a\u00020zX\u0096\u0005¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0013\u0010}\u001a\u00020~X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001¨\u0006\u0083\u0001"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/S3Client$Config;", "Laws/sdk/kotlin/runtime/config/AwsSdkClientConfig;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProviderConfig;", "Laws/smithy/kotlin/runtime/http/auth/HttpAuthConfig;", "Laws/smithy/kotlin/runtime/client/config/HttpChecksumConfig;", "Laws/smithy/kotlin/runtime/http/config/HttpClientConfig;", "Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig;", "Laws/smithy/kotlin/runtime/client/IdempotencyTokenConfig;", "Laws/smithy/kotlin/runtime/client/RetryClientConfig;", "Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfig;", "Laws/smithy/kotlin/runtime/client/SdkClientConfig;", "Laws/smithy/kotlin/runtime/auth/awscredentials/SigV4aClientConfig;", "Laws/smithy/kotlin/runtime/telemetry/TelemetryConfig;", "Laws/smithy/kotlin/runtime/http/config/TimeoutConfig;", "builder", "Laws/sdk/kotlin/services/s3/S3Client$Config$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/S3Client$Config$Builder;)V", "clientName", "", "getClientName", "()Ljava/lang/String;", TtmlNode.TAG_REGION, "getRegion", "regionProvider", "Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "getRegionProvider", "()Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "attemptTimeout", "Lkotlin/time/Duration;", "getAttemptTimeout-FghU774", "()Lkotlin/time/Duration;", "authSchemePreference", "", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "getAuthSchemePreference", "()Ljava/util/List;", "authSchemes", "Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "getAuthSchemes", "callTimeout", "getCallTimeout-FghU774", "continueHeaderThresholdBytes", "", "getContinueHeaderThresholdBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "credentialsProvider", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "getCredentialsProvider", "()Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "disableMrap", "", "getDisableMrap", "()Z", "disableS3ExpressSessionAuth", "getDisableS3ExpressSessionAuth", "enableAccelerate", "getEnableAccelerate", "enableAwsChunked", "getEnableAwsChunked", "endpointProvider", "Laws/sdk/kotlin/services/s3/endpoints/S3EndpointProvider;", "getEndpointProvider", "()Laws/sdk/kotlin/services/s3/endpoints/S3EndpointProvider;", "endpointUrl", "Laws/smithy/kotlin/runtime/net/url/Url;", "getEndpointUrl", "()Laws/smithy/kotlin/runtime/net/url/Url;", "expressCredentialsProvider", "getExpressCredentialsProvider", "forcePathStyle", "getForcePathStyle", "idempotencyTokenProvider", "Laws/smithy/kotlin/runtime/client/IdempotencyTokenProvider;", "getIdempotencyTokenProvider", "()Laws/smithy/kotlin/runtime/client/IdempotencyTokenProvider;", "interceptors", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "getInterceptors", "logMode", "Laws/smithy/kotlin/runtime/client/LogMode;", "getLogMode", "()Laws/smithy/kotlin/runtime/client/LogMode;", "requestChecksumCalculation", "Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "getRequestChecksumCalculation", "()Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "responseChecksumValidation", "Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "getResponseChecksumValidation", "()Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "retryPolicy", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "getRetryPolicy", "()Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "sigV4aSigningRegionSet", "", "getSigV4aSigningRegionSet", "()Ljava/util/Set;", "telemetryProvider", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getTelemetryProvider", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "useArnRegion", "getUseArnRegion", "useDualStack", "getUseDualStack", "useFips", "getUseFips", "applicationId", "getApplicationId", "authSchemeProvider", "Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeProvider;", "getAuthSchemeProvider", "()Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeProvider;", "toBuilder", "httpClient", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "retryStrategy", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "getRetryStrategy", "()Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Config implements AwsSdkClientConfig, CredentialsProviderConfig, HttpAuthConfig, HttpChecksumConfig, HttpClientConfig, HttpEngineConfig, IdempotencyTokenConfig, RetryClientConfig, RetryStrategyClientConfig, SdkClientConfig, SigV4aClientConfig, TelemetryConfig, TimeoutConfig {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final /* synthetic */ HttpEngineConfig $$delegate_0;
        private final /* synthetic */ RetryStrategyClientConfig $$delegate_1;
        private final String applicationId;
        private final Duration attemptTimeout;
        private final List<AuthSchemeId> authSchemePreference;
        private final S3AuthSchemeProvider authSchemeProvider;
        private final List<AuthScheme> authSchemes;
        private final Duration callTimeout;
        private final String clientName;
        private final Long continueHeaderThresholdBytes;
        private final CredentialsProvider credentialsProvider;
        private final boolean disableMrap;
        private final boolean disableS3ExpressSessionAuth;
        private final boolean enableAccelerate;
        private final boolean enableAwsChunked;
        private final S3EndpointProvider endpointProvider;
        private final Url endpointUrl;
        private final CredentialsProvider expressCredentialsProvider;
        private final boolean forcePathStyle;
        private final IdempotencyTokenProvider idempotencyTokenProvider;
        private final List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors;
        private final LogMode logMode;
        private final String region;
        private final RegionProvider regionProvider;
        private final RequestHttpChecksumConfig requestChecksumCalculation;
        private final ResponseHttpChecksumConfig responseChecksumValidation;
        private final RetryPolicy<Object> retryPolicy;
        private final Set<String> sigV4aSigningRegionSet;
        private final TelemetryProvider telemetryProvider;
        private final boolean useArnRegion;
        private final boolean useDualStack;
        private final boolean useFips;

        public /* synthetic */ Config(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig
        public HttpClientEngine getHttpClient() {
            return this.$$delegate_0.getHttpClient();
        }

        @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig
        public RetryStrategy getRetryStrategy() {
            return this.$$delegate_1.getRetryStrategy();
        }

        private Config(Builder builder) {
            this.$$delegate_0 = builder.buildHttpEngineConfig();
            this.$$delegate_1 = builder.buildRetryStrategyClientConfig();
            this.clientName = builder.getClientName();
            String region = builder.getRegion();
            region = region == null ? (String) BuildersKt__BuildersKt.runBlocking$default(null, new S3Client$Config$region$1(builder, null), 1, null) : region;
            this.region = region != null ? ValidateRegionKt.validateRegion(region) : null;
            DefaultRegionProviderChain regionProvider = builder.getRegionProvider();
            this.regionProvider = regionProvider == null ? new DefaultRegionProviderChain(null, null, null, 7, null) : regionProvider;
            this.attemptTimeout = builder.getAttemptTimeout();
            this.authSchemePreference = builder.getAuthSchemePreference();
            this.authSchemes = builder.getAuthSchemes();
            this.callTimeout = builder.getCallTimeout();
            this.continueHeaderThresholdBytes = builder.getContinueHeaderThresholdBytes();
            CredentialsProvider credentialsProvider = builder.getCredentialsProvider();
            this.credentialsProvider = credentialsProvider == null ? ManagedCredentialsProviderKt.manage(new DefaultChainCredentialsProvider(null, null, getHttpClient(), getRegion(), 3, null)) : credentialsProvider;
            Boolean disableMrap = builder.getDisableMrap();
            this.disableMrap = disableMrap != null ? disableMrap.booleanValue() : false;
            Boolean disableS3ExpressSessionAuth = builder.getDisableS3ExpressSessionAuth();
            this.disableS3ExpressSessionAuth = disableS3ExpressSessionAuth != null ? disableS3ExpressSessionAuth.booleanValue() : false;
            Boolean enableAccelerate = builder.getEnableAccelerate();
            this.enableAccelerate = enableAccelerate != null ? enableAccelerate.booleanValue() : false;
            Boolean enableAwsChunked = builder.getEnableAwsChunked();
            this.enableAwsChunked = enableAwsChunked != null ? enableAwsChunked.booleanValue() : true;
            DefaultS3EndpointProvider endpointProvider = builder.getEndpointProvider();
            endpointProvider = endpointProvider == null ? new DefaultS3EndpointProvider() : endpointProvider;
            this.endpointProvider = endpointProvider;
            this.endpointUrl = builder.getEndpointUrl();
            DefaultS3ExpressCredentialsProvider expressCredentialsProvider = builder.getExpressCredentialsProvider();
            this.expressCredentialsProvider = expressCredentialsProvider == null ? new DefaultS3ExpressCredentialsProvider(null, null, null, 0L, 15, null) : expressCredentialsProvider;
            Boolean forcePathStyle = builder.getForcePathStyle();
            this.forcePathStyle = forcePathStyle != null ? forcePathStyle.booleanValue() : false;
            IdempotencyTokenProvider idempotencyTokenProvider = builder.getIdempotencyTokenProvider();
            this.idempotencyTokenProvider = idempotencyTokenProvider == null ? IdempotencyTokenProvider.INSTANCE.getDefault() : idempotencyTokenProvider;
            this.interceptors = builder.getInterceptors();
            LogMode.Default logMode = builder.getLogMode();
            this.logMode = logMode == null ? LogMode.Default.INSTANCE : logMode;
            RequestHttpChecksumConfig requestChecksumCalculation = builder.getRequestChecksumCalculation();
            this.requestChecksumCalculation = requestChecksumCalculation == null ? RequestHttpChecksumConfig.WHEN_SUPPORTED : requestChecksumCalculation;
            ResponseHttpChecksumConfig responseChecksumValidation = builder.getResponseChecksumValidation();
            this.responseChecksumValidation = responseChecksumValidation == null ? ResponseHttpChecksumConfig.WHEN_SUPPORTED : responseChecksumValidation;
            AwsRetryPolicy retryPolicy = builder.getRetryPolicy();
            this.retryPolicy = retryPolicy == null ? AwsRetryPolicy.INSTANCE.getDefault() : retryPolicy;
            this.sigV4aSigningRegionSet = builder.getSigV4aSigningRegionSet();
            TelemetryProvider telemetryProvider = builder.getTelemetryProvider();
            this.telemetryProvider = telemetryProvider == null ? GlobalTelemetryProviderKt.getGlobal(TelemetryProvider.INSTANCE) : telemetryProvider;
            Boolean useArnRegion = builder.getUseArnRegion();
            this.useArnRegion = useArnRegion != null ? useArnRegion.booleanValue() : false;
            Boolean useDualStack = builder.getUseDualStack();
            this.useDualStack = useDualStack != null ? useDualStack.booleanValue() : false;
            Boolean useFips = builder.getUseFips();
            this.useFips = useFips != null ? useFips.booleanValue() : false;
            this.applicationId = builder.getApplicationId();
            DefaultS3AuthSchemeProvider authSchemeProvider = builder.getAuthSchemeProvider();
            this.authSchemeProvider = authSchemeProvider == null ? new DefaultS3AuthSchemeProvider(endpointProvider, getAuthSchemePreference()) : authSchemeProvider;
        }

        @Override // aws.smithy.kotlin.runtime.client.SdkClientConfig
        public String getClientName() {
            return this.clientName;
        }

        @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig
        public String getRegion() {
            return this.region;
        }

        @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig
        public RegionProvider getRegionProvider() {
            return this.regionProvider;
        }

        @Override // aws.smithy.kotlin.runtime.http.config.TimeoutConfig
        /* JADX INFO: renamed from: getAttemptTimeout-FghU774, reason: from getter */
        public Duration getAttemptTimeout() {
            return this.attemptTimeout;
        }

        @Override // aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig
        public List<AuthSchemeId> getAuthSchemePreference() {
            return this.authSchemePreference;
        }

        @Override // aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig
        public List<AuthScheme> getAuthSchemes() {
            return this.authSchemes;
        }

        @Override // aws.smithy.kotlin.runtime.http.config.TimeoutConfig
        /* JADX INFO: renamed from: getCallTimeout-FghU774, reason: from getter */
        public Duration getCallTimeout() {
            return this.callTimeout;
        }

        public final Long getContinueHeaderThresholdBytes() {
            return this.continueHeaderThresholdBytes;
        }

        @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderConfig
        public CredentialsProvider getCredentialsProvider() {
            return this.credentialsProvider;
        }

        public final boolean getDisableMrap() {
            return this.disableMrap;
        }

        public final boolean getDisableS3ExpressSessionAuth() {
            return this.disableS3ExpressSessionAuth;
        }

        public final boolean getEnableAccelerate() {
            return this.enableAccelerate;
        }

        public final boolean getEnableAwsChunked() {
            return this.enableAwsChunked;
        }

        public final S3EndpointProvider getEndpointProvider() {
            return this.endpointProvider;
        }

        public final Url getEndpointUrl() {
            return this.endpointUrl;
        }

        public final CredentialsProvider getExpressCredentialsProvider() {
            return this.expressCredentialsProvider;
        }

        public final boolean getForcePathStyle() {
            return this.forcePathStyle;
        }

        @Override // aws.smithy.kotlin.runtime.client.IdempotencyTokenConfig
        public IdempotencyTokenProvider getIdempotencyTokenProvider() {
            return this.idempotencyTokenProvider;
        }

        @Override // aws.smithy.kotlin.runtime.http.config.HttpClientConfig
        public List<Interceptor<Object, Object, HttpRequest, HttpResponse>> getInterceptors() {
            return this.interceptors;
        }

        @Override // aws.smithy.kotlin.runtime.client.SdkClientConfig
        public LogMode getLogMode() {
            return this.logMode;
        }

        @Override // aws.smithy.kotlin.runtime.client.config.HttpChecksumConfig
        public RequestHttpChecksumConfig getRequestChecksumCalculation() {
            return this.requestChecksumCalculation;
        }

        @Override // aws.smithy.kotlin.runtime.client.config.HttpChecksumConfig
        public ResponseHttpChecksumConfig getResponseChecksumValidation() {
            return this.responseChecksumValidation;
        }

        @Override // aws.smithy.kotlin.runtime.client.RetryClientConfig
        public RetryPolicy<Object> getRetryPolicy() {
            return this.retryPolicy;
        }

        @Override // aws.smithy.kotlin.runtime.auth.awscredentials.SigV4aClientConfig
        public Set<String> getSigV4aSigningRegionSet() {
            return this.sigV4aSigningRegionSet;
        }

        @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryConfig
        public TelemetryProvider getTelemetryProvider() {
            return this.telemetryProvider;
        }

        public final boolean getUseArnRegion() {
            return this.useArnRegion;
        }

        @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig
        public boolean getUseDualStack() {
            return this.useDualStack;
        }

        @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig
        public boolean getUseFips() {
            return this.useFips;
        }

        @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig
        public String getApplicationId() {
            return this.applicationId;
        }

        /* JADX INFO: compiled from: S3Client.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\nø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/S3Client$Config$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/S3Client$Config;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/S3Client$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Config invoke(Function1<? super Builder, Unit> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                Builder builder = new Builder();
                block.invoke(builder);
                return builder.build();
            }
        }

        public final S3AuthSchemeProvider getAuthSchemeProvider() {
            return this.authSchemeProvider;
        }

        public final Builder toBuilder() {
            Builder builder = new Builder();
            builder.setClientName(getClientName());
            builder.setRegion(getRegion());
            builder.setRegionProvider(getRegionProvider());
            builder.mo12049setAttemptTimeoutBwNAW2A(getAttemptTimeout());
            builder.setAuthSchemePreference(getAuthSchemePreference());
            builder.setAuthSchemes(getAuthSchemes());
            builder.mo12050setCallTimeoutBwNAW2A(getCallTimeout());
            builder.setContinueHeaderThresholdBytes(this.continueHeaderThresholdBytes);
            builder.setCredentialsProvider(getCredentialsProvider());
            builder.setDisableMrap(Boolean.valueOf(this.disableMrap));
            builder.setDisableS3ExpressSessionAuth(Boolean.valueOf(this.disableS3ExpressSessionAuth));
            builder.setEnableAccelerate(Boolean.valueOf(this.enableAccelerate));
            builder.setEnableAwsChunked(Boolean.valueOf(this.enableAwsChunked));
            builder.setEndpointProvider(this.endpointProvider);
            builder.setEndpointUrl(this.endpointUrl);
            builder.setExpressCredentialsProvider(this.expressCredentialsProvider);
            builder.setForcePathStyle(Boolean.valueOf(this.forcePathStyle));
            builder.setHttpClient(getHttpClient());
            builder.setIdempotencyTokenProvider(getIdempotencyTokenProvider());
            builder.setInterceptors(CollectionsKt.toMutableList((Collection) getInterceptors()));
            builder.setLogMode(getLogMode());
            builder.setRequestChecksumCalculation(getRequestChecksumCalculation());
            builder.setResponseChecksumValidation(getResponseChecksumValidation());
            builder.setRetryPolicy(getRetryPolicy());
            builder.setRetryStrategy(getRetryStrategy());
            builder.setSigV4aSigningRegionSet(getSigV4aSigningRegionSet());
            builder.setTelemetryProvider(getTelemetryProvider());
            builder.setUseArnRegion(Boolean.valueOf(this.useArnRegion));
            builder.setUseDualStack(Boolean.valueOf(getUseDualStack()));
            builder.setUseFips(Boolean.valueOf(getUseFips()));
            builder.setApplicationId(getApplicationId());
            builder.setAuthSchemeProvider(this.authSchemeProvider);
            return builder;
        }

        /* JADX INFO: compiled from: S3Client.kt */
        @Metadata(m1598d1 = {"\u0000¶\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\b\u0012\u0004\u0012\u00020\u000b0\n2\u00020\f2\u00020\r2\u00020\u000eB\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010¨\u0001\u001a\u00020\u000bH\u0016J\u000b\u0010©\u0001\u001a\u00030ª\u0001H\u0097\u0001J\u000b\u0010«\u0001\u001a\u00030¬\u0001H\u0097\u0001J)\u0010\u00ad\u0001\u001a\u00030®\u00012\u001c\u0010¯\u0001\u001a\u0017\u0012\u0005\u0012\u00030±\u0001\u0012\u0005\u0012\u00030®\u00010°\u0001¢\u0006\u0003\b²\u0001H\u0096\u0001JY\u0010\u00ad\u0001\u001a\u00030®\u0001\"\n\b\u0000\u0010³\u0001*\u00030±\u0001\"\n\b\u0001\u0010´\u0001*\u00030µ\u00012\u0016\u0010¶\u0001\u001a\u0011\u0012\u0005\u0012\u0003H³\u0001\u0012\u0005\u0012\u0003H´\u00010·\u00012\u001c\u0010¯\u0001\u001a\u0017\u0012\u0005\u0012\u0003H³\u0001\u0012\u0005\u0012\u00030®\u00010°\u0001¢\u0006\u0003\b²\u0001H\u0096\u0001J)\u0010¸\u0001\u001a\u00030®\u00012\u001c\u0010¯\u0001\u001a\u0017\u0012\u0005\u0012\u00030¹\u0001\u0012\u0005\u0012\u00030®\u00010°\u0001¢\u0006\u0003\b²\u0001H\u0096\u0001JY\u0010¸\u0001\u001a\u00030®\u0001\"\n\b\u0000\u0010³\u0001*\u00030º\u0001\"\n\b\u0001\u0010»\u0001*\u00030¼\u00012\u0016\u0010½\u0001\u001a\u0011\u0012\u0005\u0012\u0003H³\u0001\u0012\u0005\u0012\u0003H»\u00010¾\u00012\u001c\u0010¯\u0001\u001a\u0017\u0012\u0005\u0012\u0003H³\u0001\u0012\u0005\u0012\u00030®\u00010°\u0001¢\u0006\u0003\b²\u0001H\u0096\u0001R\u001a\u0010\u0011\u001a\u00020\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\b\u0012\u0004\u0012\u00020.0'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\u001c\u00101\u001a\u0004\u0018\u00010!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010#\"\u0004\b3\u0010%R\u001e\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010H\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bI\u0010D\"\u0004\bJ\u0010FR\u001e\u0010K\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bL\u0010D\"\u0004\bM\u0010FR\u001e\u0010N\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bO\u0010D\"\u0004\bP\u0010FR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001c\u0010]\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010>\"\u0004\b_\u0010@R\u001e\u0010`\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\ba\u0010D\"\u0004\bb\u0010FR\u001c\u0010c\u001a\u0004\u0018\u00010dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR<\u0010i\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020n0kj\u0002`o0jX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010*\"\u0004\bq\u0010,R\u001c\u0010r\u001a\u0004\u0018\u00010sX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001c\u0010x\u001a\u0004\u0018\u00010yX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R \u0010~\u001a\u0004\u0018\u00010\u007fX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R*\u0010\u0084\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010l\u0018\u00010\u0085\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R(\u0010\u008a\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u008b\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R!\u0010\u0096\u0001\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b\u0097\u0001\u0010D\"\u0005\b\u0098\u0001\u0010FR!\u0010\u0099\u0001\u001a\u0004\u0018\u00010BX\u0096\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b\u009a\u0001\u0010D\"\u0005\b\u009b\u0001\u0010FR!\u0010\u009c\u0001\u001a\u0004\u0018\u00010BX\u0096\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b\u009d\u0001\u0010D\"\u0005\b\u009e\u0001\u0010FR\u001f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0012X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010\u0014\"\u0005\b¡\u0001\u0010\u0016R\"\u0010¢\u0001\u001a\u0005\u0018\u00010£\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R \u0010\u00ad\u0001\u001a\u0005\u0018\u00010µ\u0001X\u0096\u000f¢\u0006\u0010\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R \u0010¸\u0001\u001a\u0005\u0018\u00010¼\u0001X\u0096\u000f¢\u0006\u0010\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001¨\u0006Ç\u0001"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/S3Client$Config$Builder;", "Laws/sdk/kotlin/runtime/config/AwsSdkClientConfig$Builder;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProviderConfig$Builder;", "Laws/smithy/kotlin/runtime/http/auth/HttpAuthConfig$Builder;", "Laws/smithy/kotlin/runtime/client/config/HttpChecksumConfig$Builder;", "Laws/smithy/kotlin/runtime/http/config/HttpClientConfig$Builder;", "Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig$Builder;", "Laws/smithy/kotlin/runtime/client/IdempotencyTokenConfig$Builder;", "Laws/smithy/kotlin/runtime/client/RetryClientConfig$Builder;", "Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfig$Builder;", "Laws/smithy/kotlin/runtime/client/SdkClientConfig$Builder;", "Laws/sdk/kotlin/services/s3/S3Client$Config;", "Laws/smithy/kotlin/runtime/auth/awscredentials/SigV4aClientConfig$Builder;", "Laws/smithy/kotlin/runtime/telemetry/TelemetryConfig$Builder;", "Laws/smithy/kotlin/runtime/http/config/TimeoutConfig$Builder;", "<init>", "()V", "clientName", "", "getClientName", "()Ljava/lang/String;", "setClientName", "(Ljava/lang/String;)V", TtmlNode.TAG_REGION, "getRegion", "setRegion", "regionProvider", "Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "getRegionProvider", "()Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "setRegionProvider", "(Laws/smithy/kotlin/runtime/client/region/RegionProvider;)V", "attemptTimeout", "Lkotlin/time/Duration;", "getAttemptTimeout-FghU774", "()Lkotlin/time/Duration;", "setAttemptTimeout-BwNAW2A", "(Lkotlin/time/Duration;)V", "authSchemePreference", "", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "getAuthSchemePreference", "()Ljava/util/List;", "setAuthSchemePreference", "(Ljava/util/List;)V", "authSchemes", "Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "getAuthSchemes", "setAuthSchemes", "callTimeout", "getCallTimeout-FghU774", "setCallTimeout-BwNAW2A", "continueHeaderThresholdBytes", "", "getContinueHeaderThresholdBytes", "()Ljava/lang/Long;", "setContinueHeaderThresholdBytes", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "credentialsProvider", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "getCredentialsProvider", "()Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "setCredentialsProvider", "(Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;)V", "disableMrap", "", "getDisableMrap", "()Ljava/lang/Boolean;", "setDisableMrap", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "disableS3ExpressSessionAuth", "getDisableS3ExpressSessionAuth", "setDisableS3ExpressSessionAuth", "enableAccelerate", "getEnableAccelerate", "setEnableAccelerate", "enableAwsChunked", "getEnableAwsChunked", "setEnableAwsChunked", "endpointProvider", "Laws/sdk/kotlin/services/s3/endpoints/S3EndpointProvider;", "getEndpointProvider", "()Laws/sdk/kotlin/services/s3/endpoints/S3EndpointProvider;", "setEndpointProvider", "(Laws/sdk/kotlin/services/s3/endpoints/S3EndpointProvider;)V", "endpointUrl", "Laws/smithy/kotlin/runtime/net/url/Url;", "getEndpointUrl", "()Laws/smithy/kotlin/runtime/net/url/Url;", "setEndpointUrl", "(Laws/smithy/kotlin/runtime/net/url/Url;)V", "expressCredentialsProvider", "getExpressCredentialsProvider", "setExpressCredentialsProvider", "forcePathStyle", "getForcePathStyle", "setForcePathStyle", "idempotencyTokenProvider", "Laws/smithy/kotlin/runtime/client/IdempotencyTokenProvider;", "getIdempotencyTokenProvider", "()Laws/smithy/kotlin/runtime/client/IdempotencyTokenProvider;", "setIdempotencyTokenProvider", "(Laws/smithy/kotlin/runtime/client/IdempotencyTokenProvider;)V", "interceptors", "", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "getInterceptors", "setInterceptors", "logMode", "Laws/smithy/kotlin/runtime/client/LogMode;", "getLogMode", "()Laws/smithy/kotlin/runtime/client/LogMode;", "setLogMode", "(Laws/smithy/kotlin/runtime/client/LogMode;)V", "requestChecksumCalculation", "Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "getRequestChecksumCalculation", "()Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "setRequestChecksumCalculation", "(Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;)V", "responseChecksumValidation", "Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "getResponseChecksumValidation", "()Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "setResponseChecksumValidation", "(Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;)V", "retryPolicy", "Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "getRetryPolicy", "()Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;", "setRetryPolicy", "(Laws/smithy/kotlin/runtime/retries/policy/RetryPolicy;)V", "sigV4aSigningRegionSet", "", "getSigV4aSigningRegionSet", "()Ljava/util/Set;", "setSigV4aSigningRegionSet", "(Ljava/util/Set;)V", "telemetryProvider", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getTelemetryProvider", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "setTelemetryProvider", "(Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;)V", "useArnRegion", "getUseArnRegion", "setUseArnRegion", "useDualStack", "getUseDualStack", "setUseDualStack", "useFips", "getUseFips", "setUseFips", "applicationId", "getApplicationId", "setApplicationId", "authSchemeProvider", "Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeProvider;", "getAuthSchemeProvider", "()Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeProvider;", "setAuthSchemeProvider", "(Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeProvider;)V", "build", "buildHttpEngineConfig", "Laws/smithy/kotlin/runtime/http/config/HttpEngineConfig;", "buildRetryStrategyClientConfig", "Laws/smithy/kotlin/runtime/client/RetryStrategyClientConfig;", "httpClient", "", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngineConfig$Builder;", "Lkotlin/ExtensionFunctionType;", "B", ExifInterface.LONGITUDE_EAST, "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "engineFactory", "Laws/smithy/kotlin/runtime/http/config/EngineFactory;", "retryStrategy", "Laws/smithy/kotlin/runtime/retries/StandardRetryStrategy$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/RetryStrategy$Config$Builder;", "R", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "factory", "Laws/smithy/kotlin/runtime/util/DslFactory;", "getHttpClient", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "setHttpClient", "(Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)V", "getRetryStrategy", "()Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "setRetryStrategy", "(Laws/smithy/kotlin/runtime/retries/RetryStrategy;)V", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Builder implements AwsSdkClientConfig.Builder, CredentialsProviderConfig.Builder, HttpAuthConfig.Builder, HttpChecksumConfig.Builder, HttpClientConfig.Builder, HttpEngineConfig.Builder, IdempotencyTokenConfig.Builder, RetryClientConfig.Builder, RetryStrategyClientConfig.Builder, SdkClientConfig.Builder<Config>, SigV4aClientConfig.Builder, TelemetryConfig.Builder, TimeoutConfig.Builder {
            private String applicationId;
            private Duration attemptTimeout;
            private List<AuthSchemeId> authSchemePreference;
            private S3AuthSchemeProvider authSchemeProvider;
            private Duration callTimeout;
            private CredentialsProvider credentialsProvider;
            private Boolean disableMrap;
            private Boolean disableS3ExpressSessionAuth;
            private Boolean enableAccelerate;
            private Boolean enableAwsChunked;
            private S3EndpointProvider endpointProvider;
            private Url endpointUrl;
            private CredentialsProvider expressCredentialsProvider;
            private Boolean forcePathStyle;
            private IdempotencyTokenProvider idempotencyTokenProvider;
            private LogMode logMode;
            private String region;
            private RegionProvider regionProvider;
            private RequestHttpChecksumConfig requestChecksumCalculation;
            private ResponseHttpChecksumConfig responseChecksumValidation;
            private RetryPolicy<Object> retryPolicy;
            private Set<String> sigV4aSigningRegionSet;
            private TelemetryProvider telemetryProvider;
            private Boolean useArnRegion;
            private Boolean useDualStack;
            private Boolean useFips;
            private final /* synthetic */ HttpEngineConfigImpl.BuilderImpl $$delegate_0 = new HttpEngineConfigImpl.BuilderImpl();
            private final /* synthetic */ RetryStrategyClientConfigImpl.BuilderImpl $$delegate_1 = new RetryStrategyClientConfigImpl.BuilderImpl();
            private String clientName = S3ClientKt.ServiceId;
            private List<? extends AuthScheme> authSchemes = CollectionsKt.emptyList();
            private Long continueHeaderThresholdBytes = 2097152L;
            private List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors = new ArrayList();

            @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
            @InternalApi
            public HttpEngineConfig buildHttpEngineConfig() {
                return this.$$delegate_0.buildHttpEngineConfig();
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
            @InternalApi
            public RetryStrategyClientConfig buildRetryStrategyClientConfig() {
                return this.$$delegate_1.buildRetryStrategyClientConfig();
            }

            @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
            public HttpClientEngine getHttpClient() {
                return this.$$delegate_0.getHttpClient();
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
            public RetryStrategy getRetryStrategy() {
                return this.$$delegate_1.getRetryStrategy();
            }

            @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
            public <B extends HttpClientEngineConfig.Builder, E extends HttpClientEngine> void httpClient(EngineFactory<? extends B, E> engineFactory, Function1<? super B, Unit> block) {
                Intrinsics.checkNotNullParameter(engineFactory, "engineFactory");
                Intrinsics.checkNotNullParameter(block, "block");
                this.$$delegate_0.httpClient(engineFactory, block);
            }

            @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
            public void httpClient(Function1<? super HttpClientEngineConfig.Builder, Unit> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                this.$$delegate_0.httpClient(block);
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
            public <B extends RetryStrategy.Config.Builder, R extends RetryStrategy> void retryStrategy(DslFactory<? extends B, ? extends R> factory, Function1<? super B, Unit> block) {
                Intrinsics.checkNotNullParameter(factory, "factory");
                Intrinsics.checkNotNullParameter(block, "block");
                this.$$delegate_1.retryStrategy(factory, block);
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
            public void retryStrategy(Function1<? super StandardRetryStrategy.Config.Builder, Unit> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                this.$$delegate_1.retryStrategy(block);
            }

            @Override // aws.smithy.kotlin.runtime.http.config.HttpEngineConfig.Builder
            public void setHttpClient(HttpClientEngine httpClientEngine) {
                this.$$delegate_0.setHttpClient(httpClientEngine);
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig.Builder
            public void setRetryStrategy(RetryStrategy retryStrategy) {
                this.$$delegate_1.setRetryStrategy(retryStrategy);
            }

            @Override // aws.smithy.kotlin.runtime.client.SdkClientConfig.Builder
            public String getClientName() {
                return this.clientName;
            }

            @Override // aws.smithy.kotlin.runtime.client.SdkClientConfig.Builder
            public void setClientName(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.clientName = str;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public String getRegion() {
                return this.region;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public void setRegion(String str) {
                this.region = str;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public RegionProvider getRegionProvider() {
                return this.regionProvider;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public void setRegionProvider(RegionProvider regionProvider) {
                this.regionProvider = regionProvider;
            }

            @Override // aws.smithy.kotlin.runtime.http.config.TimeoutConfig.Builder
            /* JADX INFO: renamed from: getAttemptTimeout-FghU774, reason: from getter */
            public Duration getAttemptTimeout() {
                return this.attemptTimeout;
            }

            @Override // aws.smithy.kotlin.runtime.http.config.TimeoutConfig.Builder
            /* JADX INFO: renamed from: setAttemptTimeout-BwNAW2A */
            public void mo12049setAttemptTimeoutBwNAW2A(Duration duration) {
                this.attemptTimeout = duration;
            }

            @Override // aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig.Builder
            public List<AuthSchemeId> getAuthSchemePreference() {
                return this.authSchemePreference;
            }

            @Override // aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig.Builder
            public void setAuthSchemePreference(List<AuthSchemeId> list) {
                this.authSchemePreference = list;
            }

            @Override // aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig.Builder
            public List<AuthScheme> getAuthSchemes() {
                return this.authSchemes;
            }

            @Override // aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig.Builder
            public void setAuthSchemes(List<? extends AuthScheme> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.authSchemes = list;
            }

            @Override // aws.smithy.kotlin.runtime.http.config.TimeoutConfig.Builder
            /* JADX INFO: renamed from: getCallTimeout-FghU774, reason: from getter */
            public Duration getCallTimeout() {
                return this.callTimeout;
            }

            @Override // aws.smithy.kotlin.runtime.http.config.TimeoutConfig.Builder
            /* JADX INFO: renamed from: setCallTimeout-BwNAW2A */
            public void mo12050setCallTimeoutBwNAW2A(Duration duration) {
                this.callTimeout = duration;
            }

            public final Long getContinueHeaderThresholdBytes() {
                return this.continueHeaderThresholdBytes;
            }

            public final void setContinueHeaderThresholdBytes(Long l) {
                this.continueHeaderThresholdBytes = l;
            }

            @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderConfig.Builder
            public CredentialsProvider getCredentialsProvider() {
                return this.credentialsProvider;
            }

            @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderConfig.Builder
            public void setCredentialsProvider(CredentialsProvider credentialsProvider) {
                this.credentialsProvider = credentialsProvider;
            }

            public final Boolean getDisableMrap() {
                return this.disableMrap;
            }

            public final void setDisableMrap(Boolean bool) {
                this.disableMrap = bool;
            }

            public final Boolean getDisableS3ExpressSessionAuth() {
                return this.disableS3ExpressSessionAuth;
            }

            public final void setDisableS3ExpressSessionAuth(Boolean bool) {
                this.disableS3ExpressSessionAuth = bool;
            }

            public final Boolean getEnableAccelerate() {
                return this.enableAccelerate;
            }

            public final void setEnableAccelerate(Boolean bool) {
                this.enableAccelerate = bool;
            }

            public final Boolean getEnableAwsChunked() {
                return this.enableAwsChunked;
            }

            public final void setEnableAwsChunked(Boolean bool) {
                this.enableAwsChunked = bool;
            }

            public final S3EndpointProvider getEndpointProvider() {
                return this.endpointProvider;
            }

            public final void setEndpointProvider(S3EndpointProvider s3EndpointProvider) {
                this.endpointProvider = s3EndpointProvider;
            }

            public final Url getEndpointUrl() {
                return this.endpointUrl;
            }

            public final void setEndpointUrl(Url url) {
                this.endpointUrl = url;
            }

            public final CredentialsProvider getExpressCredentialsProvider() {
                return this.expressCredentialsProvider;
            }

            public final void setExpressCredentialsProvider(CredentialsProvider credentialsProvider) {
                this.expressCredentialsProvider = credentialsProvider;
            }

            public final Boolean getForcePathStyle() {
                return this.forcePathStyle;
            }

            public final void setForcePathStyle(Boolean bool) {
                this.forcePathStyle = bool;
            }

            @Override // aws.smithy.kotlin.runtime.client.IdempotencyTokenConfig.Builder
            public IdempotencyTokenProvider getIdempotencyTokenProvider() {
                return this.idempotencyTokenProvider;
            }

            @Override // aws.smithy.kotlin.runtime.client.IdempotencyTokenConfig.Builder
            public void setIdempotencyTokenProvider(IdempotencyTokenProvider idempotencyTokenProvider) {
                this.idempotencyTokenProvider = idempotencyTokenProvider;
            }

            @Override // aws.smithy.kotlin.runtime.http.config.HttpClientConfig.Builder
            public List<Interceptor<Object, Object, HttpRequest, HttpResponse>> getInterceptors() {
                return this.interceptors;
            }

            @Override // aws.smithy.kotlin.runtime.http.config.HttpClientConfig.Builder
            public void setInterceptors(List<Interceptor<Object, Object, HttpRequest, HttpResponse>> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.interceptors = list;
            }

            @Override // aws.smithy.kotlin.runtime.client.SdkClientConfig.Builder
            public LogMode getLogMode() {
                return this.logMode;
            }

            @Override // aws.smithy.kotlin.runtime.client.SdkClientConfig.Builder
            public void setLogMode(LogMode logMode) {
                this.logMode = logMode;
            }

            @Override // aws.smithy.kotlin.runtime.client.config.HttpChecksumConfig.Builder
            public RequestHttpChecksumConfig getRequestChecksumCalculation() {
                return this.requestChecksumCalculation;
            }

            @Override // aws.smithy.kotlin.runtime.client.config.HttpChecksumConfig.Builder
            public void setRequestChecksumCalculation(RequestHttpChecksumConfig requestHttpChecksumConfig) {
                this.requestChecksumCalculation = requestHttpChecksumConfig;
            }

            @Override // aws.smithy.kotlin.runtime.client.config.HttpChecksumConfig.Builder
            public ResponseHttpChecksumConfig getResponseChecksumValidation() {
                return this.responseChecksumValidation;
            }

            @Override // aws.smithy.kotlin.runtime.client.config.HttpChecksumConfig.Builder
            public void setResponseChecksumValidation(ResponseHttpChecksumConfig responseHttpChecksumConfig) {
                this.responseChecksumValidation = responseHttpChecksumConfig;
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryClientConfig.Builder
            public RetryPolicy<Object> getRetryPolicy() {
                return this.retryPolicy;
            }

            @Override // aws.smithy.kotlin.runtime.client.RetryClientConfig.Builder
            public void setRetryPolicy(RetryPolicy<Object> retryPolicy) {
                this.retryPolicy = retryPolicy;
            }

            @Override // aws.smithy.kotlin.runtime.auth.awscredentials.SigV4aClientConfig.Builder
            public Set<String> getSigV4aSigningRegionSet() {
                return this.sigV4aSigningRegionSet;
            }

            @Override // aws.smithy.kotlin.runtime.auth.awscredentials.SigV4aClientConfig.Builder
            public void setSigV4aSigningRegionSet(Set<String> set) {
                this.sigV4aSigningRegionSet = set;
            }

            @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryConfig.Builder
            public TelemetryProvider getTelemetryProvider() {
                return this.telemetryProvider;
            }

            @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryConfig.Builder
            public void setTelemetryProvider(TelemetryProvider telemetryProvider) {
                this.telemetryProvider = telemetryProvider;
            }

            public final Boolean getUseArnRegion() {
                return this.useArnRegion;
            }

            public final void setUseArnRegion(Boolean bool) {
                this.useArnRegion = bool;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public Boolean getUseDualStack() {
                return this.useDualStack;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public void setUseDualStack(Boolean bool) {
                this.useDualStack = bool;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public Boolean getUseFips() {
                return this.useFips;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public void setUseFips(Boolean bool) {
                this.useFips = bool;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public String getApplicationId() {
                return this.applicationId;
            }

            @Override // aws.sdk.kotlin.runtime.config.AwsSdkClientConfig.Builder
            public void setApplicationId(String str) {
                this.applicationId = str;
            }

            public final S3AuthSchemeProvider getAuthSchemeProvider() {
                return this.authSchemeProvider;
            }

            public final void setAuthSchemeProvider(S3AuthSchemeProvider s3AuthSchemeProvider) {
                this.authSchemeProvider = s3AuthSchemeProvider;
            }

            @Override // aws.smithy.kotlin.runtime.util.Buildable
            public Config build() {
                return new Config(this, null);
            }
        }
    }

    /* JADX INFO: compiled from: S3Client.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object listBuckets$default(S3Client s3Client, ListBucketsRequest listBucketsRequest, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listBuckets");
        }
        if ((i & 1) != 0) {
            listBucketsRequest = ListBucketsRequest.INSTANCE.invoke(new Function1() { // from class: aws.sdk.kotlin.services.s3.S3Client$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return S3Client.listBuckets$lambda$0((ListBucketsRequest.Builder) obj2);
                }
            });
        }
        return s3Client.listBuckets(listBucketsRequest, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Unit listBuckets$lambda$0(ListBucketsRequest.Builder ListBucketsRequest) {
        Intrinsics.checkNotNullParameter(ListBucketsRequest, "$this$ListBucketsRequest");
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object listDirectoryBuckets$default(S3Client s3Client, ListDirectoryBucketsRequest listDirectoryBucketsRequest, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listDirectoryBuckets");
        }
        if ((i & 1) != 0) {
            listDirectoryBucketsRequest = ListDirectoryBucketsRequest.INSTANCE.invoke(new Function1() { // from class: aws.sdk.kotlin.services.s3.S3Client$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return S3Client.listDirectoryBuckets$lambda$0((ListDirectoryBucketsRequest.Builder) obj2);
                }
            });
        }
        return s3Client.listDirectoryBuckets(listDirectoryBucketsRequest, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Unit listDirectoryBuckets$lambda$0(ListDirectoryBucketsRequest.Builder ListDirectoryBucketsRequest) {
        Intrinsics.checkNotNullParameter(ListDirectoryBucketsRequest, "$this$ListDirectoryBucketsRequest");
        return Unit.INSTANCE;
    }
}

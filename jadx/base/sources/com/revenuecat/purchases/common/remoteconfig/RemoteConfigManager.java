package com.revenuecat.purchases.common.remoteconfig;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.services.p010s3.express.S3ExpressDefaultChecksumAlgorithmKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.JsonTools;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.GetRemoteConfigErrorHandlingBehavior;
import com.revenuecat.purchases.common.JsonProvider;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DateExtensionsKt;
import com.revenuecat.purchases.common.networking.RCContainer;
import com.revenuecat.purchases.common.networking.RCContainerFormatException;
import com.revenuecat.purchases.common.networking.RCElement;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceHandle;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfiguration;
import com.survicate.surveys.TextRecallingManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerializersModule;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: RemoteConfigManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\n\b\u0000\u0018\u0000 \u0080\u00012\u00020\u0001:\u0002\u0080\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0019¢\u0006\u0002\u0010\u001cJ\u000e\u00104\u001a\u000203H\u0082@¢\u0006\u0002\u00105J\u000e\u00106\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u00105J\u0018\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:H\u0086@¢\u0006\u0002\u0010;J(\u0010<\u001a\u0004\u0018\u0001H=\"\u0006\b\u0000\u0010=\u0018\u00012\u0006\u00109\u001a\u00020:2\u0006\u0010>\u001a\u00020\u0016H\u0086H¢\u0006\u0002\u0010?J<\u0010<\u001a\u0004\u0018\u0001H=\"\u0004\b\u0000\u0010=2\u0006\u00109\u001a\u00020:2\u0006\u0010>\u001a\u00020\u00162\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020A\u0012\u0006\u0012\u0004\u0018\u0001H=0\u0018H\u0086@¢\u0006\u0002\u0010BJ\u000e\u0010C\u001a\u0002032\u0006\u0010D\u001a\u00020\u0016J\u0006\u0010E\u001a\u000203J \u0010F\u001a\u0004\u0018\u00010G2\u0006\u00109\u001a\u00020:2\u0006\u0010>\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010?J\u0018\u0010H\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:H\u0082@¢\u0006\u0002\u0010;J\u0018\u0010I\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:H\u0086@¢\u0006\u0002\u0010;J\u0018\u0010J\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:H\u0086@¢\u0006\u0002\u0010;J\b\u0010K\u001a\u000203H\u0002J\u001e\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020N2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00160PH\u0002J\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020RH\u0002J \u0010T\u001a\u0002032\u0006\u0010U\u001a\u00020\u001f2\u0006\u0010V\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u0016H\u0002J8\u0010X\u001a\u0002032\u0006\u0010U\u001a\u00020\u001f2\u0006\u0010V\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u00192\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0002J.\u0010^\u001a\u0002032\u0006\u0010U\u001a\u00020\u001f2\b\u0010_\u001a\u0004\u0018\u00010`2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010a\u001a\u0004\u0018\u00010,H\u0002J\u001a\u0010b\u001a\u0002032\u0006\u0010U\u001a\u00020\u001f2\b\u0010a\u001a\u0004\u0018\u00010,H\u0002J\u0018\u0010c\u001a\u0002032\u0006\u0010U\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020[H\u0002J\u0010\u0010d\u001a\u00020\u00192\u0006\u0010e\u001a\u00020,H\u0002J(\u0010f\u001a\u0002032\u0006\u0010V\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u001f2\u0006\u0010g\u001a\u00020\u00162\u0006\u0010h\u001a\u00020RH\u0002J\u001a\u0010i\u001a\u0002032\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010V\u001a\u00020\u0019H\u0002J.\u0010j\u001a\u0004\u0018\u0001H=\"\u0006\b\u0000\u0010=\u0018\u00012\u0006\u00109\u001a\u00020:2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00160lH\u0086H¢\u0006\u0002\u0010mJB\u0010j\u001a\u0004\u0018\u0001H=\"\u0004\b\u0000\u0010=2\u0006\u00109\u001a\u00020:2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00160l2\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020n\u0012\u0006\u0012\u0004\u0018\u0001H=0\u0018H\u0086@¢\u0006\u0002\u0010oJ&\u0010p\u001a\u0004\u0018\u00010n2\u0006\u00109\u001a\u00020:2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00160lH\u0082@¢\u0006\u0002\u0010mJ.\u0010q\u001a\u0002032\b\u0010r\u001a\u0004\u0018\u00010`2\u0006\u0010s\u001a\u00020t2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010a\u001a\u0004\u0018\u00010,H\u0002J$\u0010u\u001a\u0002032\u0006\u0010s\u001a\u00020t2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002080wH\u0002J\u001e\u0010x\u001a\u0002032\u0006\u0010V\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u00162\u0006\u0010y\u001a\u00020RJ(\u0010x\u001a\u0002032\u0006\u0010V\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u00162\u0006\u0010y\u001a\u00020R2\u0006\u0010z\u001a\u00020\u0019H\u0002J\u001e\u0010{\u001a\u0002032\u0006\u0010V\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u00162\u0006\u0010y\u001a\u00020RJ\u000e\u0010|\u001a\u0002032\u0006\u0010}\u001a\u000200J\u0010\u0010~\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u001fH\u0002J \u0010\u007f\u001a\u0004\u0018\u00010A2\u0006\u00109\u001a\u00020:2\u0006\u0010>\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010?J\u0018\u00109\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:H\u0086@¢\u0006\u0002\u0010;R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0081\u0001"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager;", "", S3ExpressDefaultChecksumAlgorithmKt.S3_EXPRESS_ENDPOINT_PROPERTY_KEY, "Lcom/revenuecat/purchases/common/Backend;", "diskCache", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigDiskCache;", "blobStore", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobStore;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "topicStore", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigTopicStore;", "sourceProvider", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceProvider;", "blobFetcher", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher;", "appUserIDProvider", "Lkotlin/Function0;", "", "cacheDurationProvider", "Lkotlin/Function1;", "", "Lkotlin/time/Duration;", "enabled", "(Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigDiskCache;Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobStore;Lcom/revenuecat/purchases/common/DateProvider;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigTopicStore;Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceProvider;Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Z)V", "cacheLock", "configGeneration", "", "getConfigGeneration", "()I", "currentAppUserID", "epoch", "Ljava/util/concurrent/atomic/AtomicInteger;", "generation", "hasCommittedInitialConfig", "isDisabled", "()Z", "isRefreshing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastRefreshAttemptAt", "Ljava/util/Date;", "lastRefreshedAt", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigCommitListener;", "refreshCompletion", "Lkotlinx/coroutines/CompletableDeferred;", "", "awaitConfigForRead", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInFlightRefresh", "awaitTopicAndPrefetchBlobsReady", "Lcom/revenuecat/purchases/common/remoteconfig/ConfigTopic;", "topic", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigTopic;", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigTopic;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "blobData", ExifInterface.GPS_DIRECTION_TRUE, "itemKey", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigTopic;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transform", "", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigTopic;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCache", "appUserID", "close", "committedItem", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfiguration$ConfigItem;", "committedTopic", "committedTopicAfterInFlightRefresh", "committedTopicOrNull", "completeRefresh", "extractInlineBlobs", TtmlNode.RUBY_CONTAINER, "Lcom/revenuecat/purchases/common/networking/RCContainer;", "refsToKeep", "", "fetchContextForRequest", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigFetchContext;", "requested", "fetchFromFallback", "requestEpoch", "appInBackground", ClientCookie.DOMAIN_ATTR, "handleMainRefreshError", "hasCachedConfig", "error", "Lcom/revenuecat/purchases/PurchasesError;", "behavior", "Lcom/revenuecat/purchases/common/GetRemoteConfigErrorHandlingBehavior;", "handleMainRefreshSuccess", "persisted", "Lcom/revenuecat/purchases/common/remoteconfig/PersistedRemoteConfigurationState;", "requestDate", "handleNotModified", "handleRefreshError", "isRefreshAttemptCooldownElapsed", "now", "issueConfigRequest", "requestAppUserID", "requestFetchContext", "logRefreshStart", "mergeItemsBlobData", "itemKeys", "", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigTopic;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/serialization/json/JsonObject;", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigTopic;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergedBlobObject", "persist", "previous", "response", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfiguration;", "prefetchBlobs", "mergedTopics", "", "refreshRemoteConfig", "fetchContext", "staleGated", "refreshRemoteConfigIfStale", "registerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "releaseGuardIfOwned", "resolveBlobBytes", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RemoteConfigManager {
    private static final Companion Companion = new Companion(null);
    private static final String DEFAULT_DOMAIN = "app";
    private static final long REFRESH_ATTEMPT_COOLDOWN;
    private final Function0<String> appUserIDProvider;
    private final Backend backend;
    private final RemoteConfigBlobFetcher blobFetcher;
    private final RemoteConfigBlobStore blobStore;
    private final Function1<Boolean, Duration> cacheDurationProvider;
    private final Object cacheLock;
    private volatile String currentAppUserID;
    private final DateProvider dateProvider;
    private final RemoteConfigDiskCache diskCache;
    private final boolean enabled;
    private final AtomicInteger epoch;
    private final AtomicInteger generation;
    private boolean hasCommittedInitialConfig;
    private final CoroutineDispatcher ioDispatcher;
    private final AtomicBoolean isRefreshing;
    private volatile Date lastRefreshAttemptAt;
    private volatile Date lastRefreshedAt;
    private final CopyOnWriteArrayList<RemoteConfigCommitListener> listeners;
    private volatile CompletableDeferred<Unit> refreshCompletion;
    private final CoroutineScope scope;
    private final RemoteConfigSourceProvider sourceProvider;
    private final RemoteConfigTopicStore topicStore;

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$awaitConfigForRead$1 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager", m1609f = "RemoteConfigManager.kt", m1610i = {0}, m1611l = {PDFACompliance.e_PDFA5_2_1, 537}, m1612m = "awaitConfigForRead", m1613n = {"this"}, m1615s = {"L$0"})
    static final class C72221 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C72221(Continuation<? super C72221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteConfigManager.this.awaitConfigForRead(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$awaitInFlightRefresh$1 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager", m1609f = "RemoteConfigManager.kt", m1610i = {}, m1611l = {553}, m1612m = "awaitInFlightRefresh", m1613n = {}, m1615s = {})
    static final class C72231 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C72231(Continuation<? super C72231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteConfigManager.this.awaitInFlightRefresh(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$committedItem$1 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager", m1609f = "RemoteConfigManager.kt", m1610i = {0, 0, 0}, m1611l = {825}, m1612m = "committedItem", m1613n = {"this", "topic", "itemKey"}, m1615s = {"L$0", "L$1", "L$2"})
    static final class C72271 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C72271(Continuation<? super C72271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteConfigManager.this.committedItem(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$committedTopic$1 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager", m1609f = "RemoteConfigManager.kt", m1610i = {0, 0}, m1611l = {648}, m1612m = "committedTopic", m1613n = {"topic", "$this$committedTopic_u24lambda_u2420"}, m1615s = {"L$0", "L$1"})
    static final class C72281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C72281(Continuation<? super C72281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteConfigManager.this.committedTopic(null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$mergedBlobObject$1 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager", m1609f = "RemoteConfigManager.kt", m1610i = {0, 0}, m1611l = {763}, m1612m = "mergedBlobObject", m1613n = {"topic", UserMetadata.KEYDATA_FILENAME}, m1615s = {"L$0", "L$1"})
    static final class C72391 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C72391(Continuation<? super C72391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteConfigManager.this.mergedBlobObject(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$resolveBlobBytes$1 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager", m1609f = "RemoteConfigManager.kt", m1610i = {0, 0, 1, 1, 1}, m1611l = {799, 805}, m1612m = "resolveBlobBytes", m1613n = {"this", "itemKey", "this", "itemKey", "ref"}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class C72401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C72401(Continuation<? super C72401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteConfigManager.this.resolveBlobBytes(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RemoteConfigManager(Backend backend, RemoteConfigDiskCache diskCache, RemoteConfigBlobStore blobStore, DateProvider dateProvider, CoroutineScope scope, CoroutineDispatcher ioDispatcher, RemoteConfigTopicStore topicStore, RemoteConfigSourceProvider sourceProvider, RemoteConfigBlobFetcher blobFetcher, Function0<String> appUserIDProvider, Function1<? super Boolean, Duration> cacheDurationProvider, boolean z) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(diskCache, "diskCache");
        Intrinsics.checkNotNullParameter(blobStore, "blobStore");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(topicStore, "topicStore");
        Intrinsics.checkNotNullParameter(sourceProvider, "sourceProvider");
        Intrinsics.checkNotNullParameter(blobFetcher, "blobFetcher");
        Intrinsics.checkNotNullParameter(appUserIDProvider, "appUserIDProvider");
        Intrinsics.checkNotNullParameter(cacheDurationProvider, "cacheDurationProvider");
        this.backend = backend;
        this.diskCache = diskCache;
        this.blobStore = blobStore;
        this.dateProvider = dateProvider;
        this.scope = scope;
        this.ioDispatcher = ioDispatcher;
        this.topicStore = topicStore;
        this.sourceProvider = sourceProvider;
        this.blobFetcher = blobFetcher;
        this.appUserIDProvider = appUserIDProvider;
        this.cacheDurationProvider = cacheDurationProvider;
        this.enabled = z;
        this.isRefreshing = new AtomicBoolean(false);
        this.epoch = new AtomicInteger(0);
        this.cacheLock = new Object();
        this.generation = new AtomicInteger(0);
        this.listeners = new CopyOnWriteArrayList<>();
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ RemoteConfigManager(com.revenuecat.purchases.common.Backend r16, com.revenuecat.purchases.common.remoteconfig.RemoteConfigDiskCache r17, com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobStore r18, com.revenuecat.purchases.common.DateProvider r19, kotlinx.coroutines.CoroutineScope r20, kotlinx.coroutines.CoroutineDispatcher r21, com.revenuecat.purchases.common.remoteconfig.RemoteConfigTopicStore r22, com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceProvider r23, com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher r24, kotlin.jvm.functions.Function0 r25, kotlin.jvm.functions.Function1 r26, boolean r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 8
            if (r1 == 0) goto Lf
            com.revenuecat.purchases.common.DefaultDateProvider r1 = new com.revenuecat.purchases.common.DefaultDateProvider
            r1.<init>()
            com.revenuecat.purchases.common.DateProvider r1 = (com.revenuecat.purchases.common.DateProvider) r1
            r6 = r1
            goto L11
        Lf:
            r6 = r19
        L11:
            r1 = r0 & 16
            r2 = 1
            if (r1 == 0) goto L2b
            r1 = 0
            kotlinx.coroutines.CompletableJob r1 = kotlinx.coroutines.SupervisorKt.SupervisorJob$default(r1, r2, r1)
            kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            kotlin.coroutines.CoroutineContext r1 = r1.plus(r3)
            kotlinx.coroutines.CoroutineScope r1 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r1)
            r7 = r1
            goto L2d
        L2b:
            r7 = r20
        L2d:
            r1 = r0 & 32
            if (r1 == 0) goto L37
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
            r8 = r1
            goto L39
        L37:
            r8 = r21
        L39:
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L43
            com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$1 r1 = new kotlin.jvm.functions.Function0() { // from class: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.1
                static {
                    /*
                        com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$1 r0 = new com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$1) com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.1.INSTANCE com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.C72201.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.C72201.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Void invoke() {
                    /*
                        r1 = this;
                        r0 = 0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.C72201.invoke():java.lang.Void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r1 = this;
                        java.lang.Void r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.C72201.invoke():java.lang.Object");
                }
            }
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r12 = r1
            goto L45
        L43:
            r12 = r25
        L45:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L4f
            com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$2 r1 = com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.C72212.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r13 = r1
            goto L51
        L4f:
            r13 = r26
        L51:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L64
            r14 = r2
            r3 = r16
            r4 = r17
            r5 = r18
            r9 = r22
            r10 = r23
            r11 = r24
            r2 = r15
            goto L73
        L64:
            r14 = r27
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r9 = r22
            r10 = r23
            r11 = r24
        L73:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.<init>(com.revenuecat.purchases.common.Backend, com.revenuecat.purchases.common.remoteconfig.RemoteConfigDiskCache, com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobStore, com.revenuecat.purchases.common.DateProvider, kotlinx.coroutines.CoroutineScope, kotlinx.coroutines.CoroutineDispatcher, com.revenuecat.purchases.common.remoteconfig.RemoteConfigTopicStore, com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceProvider, com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$2 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class C72212 extends FunctionReferenceImpl implements Function1<Boolean, Duration> {
        public static final C72212 INSTANCE = new C72212();

        C72212() {
            super(1, DateExtensionsKt.class, "cacheDuration", "cacheDuration(Z)J", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Duration invoke(Boolean bool) {
            return Duration.m15854boximpl(m13741invoke5sfh64U(bool.booleanValue()));
        }

        /* JADX INFO: renamed from: invoke-5sfh64U, reason: not valid java name */
        public final long m13741invoke5sfh64U(boolean z) {
            return DateExtensionsKt.cacheDuration(z);
        }
    }

    public final boolean isDisabled() {
        return !this.enabled;
    }

    public final int getConfigGeneration() {
        return this.generation.get();
    }

    public final void registerListener(RemoteConfigCommitListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void refreshRemoteConfigIfStale(boolean appInBackground, String appUserID, RemoteConfigFetchContext fetchContext) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(fetchContext, "fetchContext");
        if (DateExtensionsKt.isCacheStale(this.lastRefreshedAt, appInBackground, this.dateProvider, this.cacheDurationProvider)) {
            refreshRemoteConfig(appInBackground, appUserID, fetchContext, true);
            return;
        }
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Committed remote configuration is still fresh; skipping the " + fetchContext.getWireName() + " refresh.");
        }
    }

    public final void refreshRemoteConfig(boolean appInBackground, String appUserID, RemoteConfigFetchContext fetchContext) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(fetchContext, "fetchContext");
        refreshRemoteConfig(appInBackground, appUserID, fetchContext, false);
    }

    private final void refreshRemoteConfig(boolean appInBackground, String appUserID, RemoteConfigFetchContext fetchContext, boolean staleGated) {
        boolean z;
        int i;
        if (!isDisabled()) {
            synchronized (this.cacheLock) {
                Date now = this.dateProvider.getNow();
                z = false;
                if (!this.isRefreshing.get()) {
                    if (!staleGated || isRefreshAttemptCooldownElapsed(now)) {
                        if (staleGated) {
                            this.lastRefreshAttemptAt = now;
                        }
                        z = true;
                        this.isRefreshing.set(true);
                        i = this.epoch.get();
                        String str = this.currentAppUserID;
                        if (str != null) {
                            appUserID = str;
                        }
                        fetchContext = fetchContextForRequest(fetchContext);
                        this.refreshCompletion = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                    } else {
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "Remote config refresh was attempted recently. Skipping stale-gated refresh.");
                        }
                    }
                } else {
                    LogLevel logLevel2 = LogLevel.DEBUG;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.mo1541d("[Purchases] - " + logLevel2.name(), "Remote config refresh already in progress. Skipping.");
                    }
                }
                i = 0;
            }
            if (z) {
                issueConfigRequest(appInBackground, i, appUserID, fetchContext);
                return;
            }
            return;
        }
        LogLevel logLevel3 = LogLevel.DEBUG;
        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
            currentLogHandler3.mo1541d("[Purchases] - " + logLevel3.name(), "Remote config is disabled for this SDK configuration. Skipping refresh.");
        }
    }

    private final void issueConfigRequest(final boolean appInBackground, final int requestEpoch, String requestAppUserID, RemoteConfigFetchContext requestFetchContext) {
        String domain;
        ArrayList arrayListEmptyList;
        List<String> prefetchBlobs;
        Long lastRefreshTime;
        final PersistedRemoteConfigurationState persistedRemoteConfigurationState = this.diskCache.read();
        Set<String> setCachedRefs = this.blobStore.cachedRefs();
        if (persistedRemoteConfigurationState == null || (domain = persistedRemoteConfigurationState.getDomain()) == null) {
            domain = "app";
        }
        final String str = domain;
        logRefreshStart(persistedRemoteConfigurationState, appInBackground);
        Backend backend = this.backend;
        Date date = null;
        String manifest = persistedRemoteConfigurationState != null ? persistedRemoteConfigurationState.getManifest() : null;
        if (persistedRemoteConfigurationState != null && (lastRefreshTime = persistedRemoteConfigurationState.getLastRefreshTime()) != null) {
            date = new Date(lastRefreshTime.longValue());
        }
        Date date2 = date;
        if (persistedRemoteConfigurationState == null || (prefetchBlobs = persistedRemoteConfigurationState.getPrefetchBlobs()) == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : prefetchBlobs) {
                if (setCachedRefs.contains((String) obj)) {
                    arrayList.add(obj);
                }
            }
            arrayListEmptyList = arrayList;
        }
        backend.getRemoteConfig(appInBackground, requestAppUserID, requestFetchContext, str, manifest, date2, arrayListEmptyList, new Function3<RCContainer, Date, VerificationResult, Unit>() { // from class: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.issueConfigRequest.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RCContainer rCContainer, Date date3, VerificationResult verificationResult) {
                invoke2(rCContainer, date3, verificationResult);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RCContainer rCContainer, Date date3, VerificationResult verificationResult) {
                Intrinsics.checkNotNullParameter(verificationResult, "<anonymous parameter 2>");
                RemoteConfigManager.this.handleMainRefreshSuccess(requestEpoch, persistedRemoteConfigurationState, rCContainer, date3);
            }
        }, new Function2<PurchasesError, GetRemoteConfigErrorHandlingBehavior, Unit>() { // from class: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.issueConfigRequest.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, GetRemoteConfigErrorHandlingBehavior getRemoteConfigErrorHandlingBehavior) {
                invoke2(purchasesError, getRemoteConfigErrorHandlingBehavior);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError error, GetRemoteConfigErrorHandlingBehavior behavior) {
                Intrinsics.checkNotNullParameter(error, "error");
                Intrinsics.checkNotNullParameter(behavior, "behavior");
                RemoteConfigManager.this.handleMainRefreshError(requestEpoch, appInBackground, str, persistedRemoteConfigurationState != null, error, behavior);
            }
        });
    }

    private final boolean isRefreshAttemptCooldownElapsed(Date now) {
        Date date = this.lastRefreshAttemptAt;
        return date == null || Duration.m15855compareToLRDsOJo(DurationExtensionsKt.between(Duration.INSTANCE, date, now), REFRESH_ATTEMPT_COOLDOWN) >= 0;
    }

    private final RemoteConfigFetchContext fetchContextForRequest(RemoteConfigFetchContext requested) {
        return this.hasCommittedInitialConfig ? requested : RemoteConfigFetchContext.AppStart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMainRefreshSuccess(int requestEpoch, PersistedRemoteConfigurationState persisted, RCContainer container, Date requestDate) {
        if (this.epoch.get() != requestEpoch) {
            return;
        }
        if (requestDate == null) {
            LogLevel logLevel = LogLevel.WARN;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Remote config response carried no X-RevenueCat-Request-Time header. Keeping the previous refresh time; the server cannot see how fresh this client's configuration is.");
            }
        }
        if (container != null) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C72332(container, this, requestEpoch, persisted, requestDate, null), 3, null);
        } else {
            handleNotModified(requestEpoch, requestDate);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$handleMainRefreshSuccess$2 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$handleMainRefreshSuccess$2", m1609f = "RemoteConfigManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72332 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RCContainer $container;
        final /* synthetic */ PersistedRemoteConfigurationState $persisted;
        final /* synthetic */ Date $requestDate;
        final /* synthetic */ int $requestEpoch;
        int label;
        final /* synthetic */ RemoteConfigManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72332(RCContainer rCContainer, RemoteConfigManager remoteConfigManager, int i, PersistedRemoteConfigurationState persistedRemoteConfigurationState, Date date, Continuation<? super C72332> continuation) {
            super(2, continuation);
            this.$container = rCContainer;
            this.this$0 = remoteConfigManager;
            this.$requestEpoch = i;
            this.$persisted = persistedRemoteConfigurationState;
            this.$requestDate = date;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C72332(this.$container, this.this$0, this.$requestEpoch, this.$persisted, this.$requestDate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C72332) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            RemoteConfiguration remoteConfiguration;
            Object obj2;
            RemoteConfigManager remoteConfigManager;
            int i;
            PersistedRemoteConfigurationState persistedRemoteConfigurationState;
            RCContainer rCContainer;
            Date date;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                try {
                    remoteConfiguration = RemoteConfiguration.INSTANCE.parse(this.$container.getConfig());
                    obj2 = this.this$0.cacheLock;
                    remoteConfigManager = this.this$0;
                    i = this.$requestEpoch;
                    persistedRemoteConfigurationState = this.$persisted;
                    rCContainer = this.$container;
                    date = this.$requestDate;
                } catch (RCContainerFormatException e) {
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to decode remote config response. Keeping the cached configuration.", e);
                } catch (SerializationException e2) {
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to parse remote config response. Keeping the cached configuration.", e2);
                }
                synchronized (obj2) {
                    if (remoteConfigManager.epoch.get() != i) {
                        return Unit.INSTANCE;
                    }
                    remoteConfigManager.persist(persistedRemoteConfigurationState, remoteConfiguration, rCContainer, date);
                    Unit unit = Unit.INSTANCE;
                    this.this$0.releaseGuardIfOwned(this.$requestEpoch);
                    return Unit.INSTANCE;
                }
            } finally {
                this.this$0.releaseGuardIfOwned(this.$requestEpoch);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMainRefreshError(int requestEpoch, boolean appInBackground, String domain, boolean hasCachedConfig, PurchasesError error, GetRemoteConfigErrorHandlingBehavior behavior) {
        if (behavior == GetRemoteConfigErrorHandlingBehavior.SHOULD_RETRY && !hasCachedConfig) {
            fetchFromFallback(requestEpoch, appInBackground, domain);
        } else {
            handleRefreshError(requestEpoch, error);
        }
    }

    private final void fetchFromFallback(final int requestEpoch, boolean appInBackground, String domain) {
        if (this.epoch.get() != requestEpoch) {
            return;
        }
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Main remote config request failed with no cached config; trying the fallback endpoint.");
        }
        this.backend.getRemoteConfigFallback(appInBackground, domain, new Function2<RemoteConfiguration, VerificationResult, Unit>() { // from class: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.fetchFromFallback.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(RemoteConfiguration remoteConfiguration, VerificationResult verificationResult) {
                invoke2(remoteConfiguration, verificationResult);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RemoteConfiguration response, VerificationResult verificationResult) {
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(verificationResult, "<anonymous parameter 1>");
                if (RemoteConfigManager.this.epoch.get() != requestEpoch) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(RemoteConfigManager.this.scope, null, null, new AnonymousClass1(RemoteConfigManager.this, requestEpoch, response, null), 3, null);
            }

            /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$fetchFromFallback$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: RemoteConfigManager.kt */
            @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
            @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$fetchFromFallback$2$1", m1609f = "RemoteConfigManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ int $requestEpoch;
                final /* synthetic */ RemoteConfiguration $response;
                int label;
                final /* synthetic */ RemoteConfigManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(RemoteConfigManager remoteConfigManager, int i, RemoteConfiguration remoteConfiguration, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = remoteConfigManager;
                    this.$requestEpoch = i;
                    this.$response = remoteConfiguration;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$requestEpoch, this.$response, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        try {
                            Object obj2 = this.this$0.cacheLock;
                            RemoteConfigManager remoteConfigManager = this.this$0;
                            int i = this.$requestEpoch;
                            RemoteConfiguration remoteConfiguration = this.$response;
                            synchronized (obj2) {
                                if (remoteConfigManager.epoch.get() != i) {
                                    return Unit.INSTANCE;
                                }
                                remoteConfigManager.persist(null, remoteConfiguration, null, null);
                                Unit unit = Unit.INSTANCE;
                                this.this$0.releaseGuardIfOwned(this.$requestEpoch);
                                return Unit.INSTANCE;
                            }
                        } finally {
                            this.this$0.releaseGuardIfOwned(this.$requestEpoch);
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.fetchFromFallback.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError) {
                invoke2(purchasesError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                RemoteConfigManager.this.handleRefreshError(requestEpoch, error);
            }
        });
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$handleNotModified$2 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$handleNotModified$2", m1609f = "RemoteConfigManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72342 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Date $requestDate;
        final /* synthetic */ int $requestEpoch;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72342(int i, Date date, Continuation<? super C72342> continuation) {
            super(2, continuation);
            this.$requestEpoch = i;
            this.$requestDate = date;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RemoteConfigManager.this.new C72342(this.$requestEpoch, this.$requestDate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C72342) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PersistedRemoteConfigurationState persistedRemoteConfigurationState;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    Object obj2 = RemoteConfigManager.this.cacheLock;
                    RemoteConfigManager remoteConfigManager = RemoteConfigManager.this;
                    int i = this.$requestEpoch;
                    Date date = this.$requestDate;
                    synchronized (obj2) {
                        if (remoteConfigManager.epoch.get() != i) {
                            return Unit.INSTANCE;
                        }
                        remoteConfigManager.lastRefreshedAt = remoteConfigManager.dateProvider.getNow();
                        remoteConfigManager.lastRefreshAttemptAt = null;
                        remoteConfigManager.hasCommittedInitialConfig = true;
                        if (date != null && (persistedRemoteConfigurationState = remoteConfigManager.diskCache.read()) != null) {
                            Boxing.boxBoolean(remoteConfigManager.diskCache.write(PersistedRemoteConfigurationState.copy$default(persistedRemoteConfigurationState, null, null, null, null, null, Boxing.boxLong(date.getTime()), 31, null)));
                        }
                        Unit unit = Unit.INSTANCE;
                        RemoteConfigManager.this.releaseGuardIfOwned(this.$requestEpoch);
                        return Unit.INSTANCE;
                    }
                } finally {
                    RemoteConfigManager.this.releaseGuardIfOwned(this.$requestEpoch);
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleRefreshError(int requestEpoch, PurchasesError error) {
        if (releaseGuardIfOwned(requestEpoch)) {
            LogUtilsKt.errorLog(error);
        }
    }

    public final void clearCache(String appUserID) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        JobKt__JobKt.cancelChildren$default(this.scope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        synchronized (this.cacheLock) {
            this.epoch.incrementAndGet();
            this.currentAppUserID = appUserID;
            this.isRefreshing.set(false);
            this.lastRefreshedAt = null;
            this.lastRefreshAttemptAt = null;
            completeRefresh();
            this.diskCache.clear();
            this.blobStore.clear();
            this.sourceProvider.clear();
            int iIncrementAndGet = this.generation.incrementAndGet();
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((RemoteConfigCommitListener) it.next()).onConfigInvalidated(iIncrementAndGet);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void close() {
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        synchronized (this.cacheLock) {
            this.isRefreshing.set(false);
            completeRefresh();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean releaseGuardIfOwned(int requestEpoch) {
        boolean z;
        synchronized (this.cacheLock) {
            z = this.epoch.get() == requestEpoch;
            if (z) {
                this.isRefreshing.set(false);
                completeRefresh();
            }
        }
        return z;
    }

    private final void completeRefresh() {
        CompletableDeferred<Unit> completableDeferred = this.refreshCompletion;
        if (completableDeferred != null) {
            completableDeferred.complete(Unit.INSTANCE);
        }
        this.refreshCompletion = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e1, code lost:
    
        if (r2.awaitInFlightRefresh(r0) == r1) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitConfigForRead(Continuation<? super Unit> continuation) {
        C72221 c72221;
        RemoteConfigManager remoteConfigManager;
        if (continuation instanceof C72221) {
            c72221 = (C72221) continuation;
            if ((c72221.label & Integer.MIN_VALUE) != 0) {
                c72221.label -= Integer.MIN_VALUE;
            } else {
                c72221 = new C72221(continuation);
            }
        }
        Object objAwaitInFlightRefresh = c72221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72221.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitInFlightRefresh);
            c72221.L$0 = this;
            c72221.label = 1;
            objAwaitInFlightRefresh = awaitInFlightRefresh(c72221);
            if (objAwaitInFlightRefresh != coroutine_suspended) {
                remoteConfigManager = this;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwaitInFlightRefresh);
            return Unit.INSTANCE;
        }
        remoteConfigManager = (RemoteConfigManager) c72221.L$0;
        ResultKt.throwOnFailure(objAwaitInFlightRefresh);
        if (((Boolean) objAwaitInFlightRefresh).booleanValue()) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Cold remote config read waiting on the refresh already in progress.");
            }
            return Unit.INSTANCE;
        }
        String strInvoke = remoteConfigManager.currentAppUserID;
        if (strInvoke == null) {
            strInvoke = remoteConfigManager.appUserIDProvider.invoke();
        }
        if (strInvoke == null || StringsKt.isBlank(strInvoke)) {
            strInvoke = null;
        }
        if (remoteConfigManager.isDisabled() || strInvoke == null) {
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.mo1544v("[Purchases] - " + logLevel2.name(), "Cold remote config read skipped on-demand sync (disabled=" + remoteConfigManager.isDisabled() + ", user known=" + (strInvoke != null) + ").");
            }
            return Unit.INSTANCE;
        }
        LogLevel logLevel3 = LogLevel.VERBOSE;
        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
            currentLogHandler3.mo1544v("[Purchases] - " + logLevel3.name(), "Cold remote config read requesting an on-demand sync.");
        }
        remoteConfigManager.refreshRemoteConfigIfStale(false, strInvoke, RemoteConfigFetchContext.Read);
        c72221.L$0 = null;
        c72221.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitInFlightRefresh(Continuation<? super Boolean> continuation) {
        C72231 c72231;
        CompletableDeferred<Unit> completableDeferred;
        if (continuation instanceof C72231) {
            c72231 = (C72231) continuation;
            if ((c72231.label & Integer.MIN_VALUE) != 0) {
                c72231.label -= Integer.MIN_VALUE;
            } else {
                c72231 = new C72231(continuation);
            }
        }
        Object obj = c72231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72231.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            synchronized (this.cacheLock) {
                completableDeferred = this.refreshCompletion;
            }
            if (completableDeferred == null) {
                return Boxing.boxBoolean(false);
            }
            c72231.label = 1;
            if (completableDeferred.await(c72231) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$topic$2 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/common/remoteconfig/ConfigTopic;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$topic$2", m1609f = "RemoteConfigManager.kt", m1610i = {}, m1611l = {568}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72412 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ConfigTopic>, Object> {
        final /* synthetic */ RemoteConfigTopic $topic;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72412(RemoteConfigTopic remoteConfigTopic, Continuation<? super C72412> continuation) {
            super(2, continuation);
            this.$topic = remoteConfigTopic;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RemoteConfigManager.this.new C72412(this.$topic, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ConfigTopic> continuation) {
            return ((C72412) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objCommittedTopic = RemoteConfigManager.this.committedTopic(this.$topic, this);
            return objCommittedTopic == coroutine_suspended ? coroutine_suspended : objCommittedTopic;
        }
    }

    public final Object topic(RemoteConfigTopic remoteConfigTopic, Continuation<? super ConfigTopic> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C72412(remoteConfigTopic, null), continuation);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$committedTopicOrNull$2 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/common/remoteconfig/ConfigTopic;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$committedTopicOrNull$2", m1609f = "RemoteConfigManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72302 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ConfigTopic>, Object> {
        final /* synthetic */ RemoteConfigTopic $topic;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72302(RemoteConfigTopic remoteConfigTopic, Continuation<? super C72302> continuation) {
            super(2, continuation);
            this.$topic = remoteConfigTopic;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RemoteConfigManager.this.new C72302(this.$topic, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ConfigTopic> continuation) {
            return ((C72302) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (RemoteConfigManager.this.isDisabled()) {
                return null;
            }
            return RemoteConfigManager.this.topicStore.topic(this.$topic);
        }
    }

    public final Object committedTopicOrNull(RemoteConfigTopic remoteConfigTopic, Continuation<? super ConfigTopic> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C72302(remoteConfigTopic, null), continuation);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$committedTopicAfterInFlightRefresh$2 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/common/remoteconfig/ConfigTopic;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$committedTopicAfterInFlightRefresh$2", m1609f = "RemoteConfigManager.kt", m1610i = {}, m1611l = {590}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72292 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ConfigTopic>, Object> {
        final /* synthetic */ RemoteConfigTopic $topic;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72292(RemoteConfigTopic remoteConfigTopic, Continuation<? super C72292> continuation) {
            super(2, continuation);
            this.$topic = remoteConfigTopic;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RemoteConfigManager.this.new C72292(this.$topic, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ConfigTopic> continuation) {
            return ((C72292) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RemoteConfigManager.this.awaitInFlightRefresh(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (RemoteConfigManager.this.isDisabled()) {
                return null;
            }
            return RemoteConfigManager.this.topicStore.topic(this.$topic);
        }
    }

    public final Object committedTopicAfterInFlightRefresh(RemoteConfigTopic remoteConfigTopic, Continuation<? super ConfigTopic> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C72292(remoteConfigTopic, null), continuation);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$awaitTopicAndPrefetchBlobsReady$2 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/common/remoteconfig/ConfigTopic;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$awaitTopicAndPrefetchBlobsReady$2", m1609f = "RemoteConfigManager.kt", m1610i = {1, 2}, m1611l = {615, 624, 629}, m1612m = "invokeSuspend", m1613n = {"committed", "committed"}, m1615s = {"L$0", "L$0"})
    static final class C72242 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ConfigTopic>, Object> {
        final /* synthetic */ RemoteConfigTopic $topic;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72242(RemoteConfigTopic remoteConfigTopic, Continuation<? super C72242> continuation) {
            super(2, continuation);
            this.$topic = remoteConfigTopic;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RemoteConfigManager.this.new C72242(this.$topic, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ConfigTopic> continuation) {
            return ((C72242) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        
            if (r11 == r0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0117, code lost:
        
            if (r11 != r0) goto L41;
         */
        /* JADX WARN: Path cross not found for [B:32:0x00a2, B:38:0x0108], limit reached: 55 */
        /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0117 -> B:41:0x011a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ConfigTopic configTopic;
            ConfigTopic configTopic2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = RemoteConfigManager.this.committedTopic(this.$topic, this);
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    configTopic2 = (ConfigTopic) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    configTopic = (ConfigTopic) obj;
                    if (!Intrinsics.areEqual(configTopic, configTopic2)) {
                        RemoteConfigTopic remoteConfigTopic = this.$topic;
                        LogLevel logLevel = LogLevel.VERBOSE;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Committed '" + remoteConfigTopic.getWireName() + "' changed during prefetch wait; re-awaiting.");
                        }
                        configTopic2 = configTopic;
                        if (configTopic2 != null) {
                            Collection<RemoteConfiguration.ConfigItem> collectionValues = configTopic2.values();
                            ArrayList arrayList = new ArrayList();
                            for (Object obj2 : collectionValues) {
                                if (((RemoteConfiguration.ConfigItem) obj2).getPrefetch()) {
                                    arrayList.add(obj2);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                String blobRef = ((RemoteConfiguration.ConfigItem) it.next()).getBlobRef();
                                if (blobRef != null) {
                                    arrayList2.add(blobRef);
                                }
                            }
                            ArrayList arrayList3 = arrayList2;
                            if (!arrayList3.isEmpty()) {
                                RemoteConfigTopic remoteConfigTopic2 = this.$topic;
                                LogLevel logLevel2 = LogLevel.VERBOSE;
                                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                    currentLogHandler2.mo1544v("[Purchases] - " + logLevel2.name(), "Awaiting " + arrayList3.size() + " prefetch blob(s) for topic '" + remoteConfigTopic2.getWireName() + "'.");
                                }
                                this.L$0 = configTopic2;
                                this.label = 2;
                                if (RemoteConfigManager.this.blobFetcher.ensureDownloaded(arrayList3, this) != coroutine_suspended) {
                                }
                                return coroutine_suspended;
                            }
                            this.L$0 = configTopic2;
                            this.label = 3;
                            obj = RemoteConfigManager.this.committedTopic(this.$topic, this);
                        }
                    }
                    return configTopic2;
                }
                configTopic2 = (ConfigTopic) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = configTopic2;
                this.label = 3;
                obj = RemoteConfigManager.this.committedTopic(this.$topic, this);
            }
            configTopic = (ConfigTopic) obj;
            configTopic2 = configTopic;
            if (configTopic2 != null) {
            }
            return configTopic2;
        }
    }

    public final Object awaitTopicAndPrefetchBlobsReady(RemoteConfigTopic remoteConfigTopic, Continuation<? super ConfigTopic> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C72242(remoteConfigTopic, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object committedTopic(RemoteConfigTopic remoteConfigTopic, Continuation<? super ConfigTopic> continuation) {
        C72281 c72281;
        ConfigTopic configTopic;
        RemoteConfigTopic remoteConfigTopic2;
        RemoteConfigManager remoteConfigManager;
        LogLevel logLevel;
        String str;
        if (continuation instanceof C72281) {
            c72281 = (C72281) continuation;
            if ((c72281.label & Integer.MIN_VALUE) != 0) {
                c72281.label -= Integer.MIN_VALUE;
            } else {
                c72281 = new C72281(continuation);
            }
        }
        Object obj = c72281.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72281.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!isDisabled()) {
                configTopic = this.topicStore.topic(remoteConfigTopic);
                if (configTopic == null) {
                    c72281.L$0 = remoteConfigTopic;
                    c72281.L$1 = this;
                    c72281.label = 1;
                    if (awaitConfigForRead(c72281) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    remoteConfigTopic2 = remoteConfigTopic;
                    remoteConfigManager = this;
                }
                logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    String str2 = "[Purchases] - " + logLevel.name();
                    if (configTopic == null || (str = configTopic.size() + " items") == null) {
                        str = "not cached";
                    }
                    currentLogHandler.mo1544v(str2, "Reading remote config topic '" + remoteConfigTopic.getWireName() + "': " + str + '.');
                }
                return configTopic;
            }
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) > 0) {
                return null;
            }
            currentLogHandler2.mo1544v("[Purchases] - " + logLevel2.name(), "Remote config disabled; skipping topic read '" + remoteConfigTopic.getWireName() + "'.");
            return null;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        remoteConfigManager = (RemoteConfigManager) c72281.L$1;
        remoteConfigTopic2 = (RemoteConfigTopic) c72281.L$0;
        ResultKt.throwOnFailure(obj);
        configTopic = remoteConfigManager.topicStore.topic(remoteConfigTopic2);
        remoteConfigTopic = remoteConfigTopic2;
        logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
        }
        return configTopic;
    }

    public final /* synthetic */ <T> Object blobData(RemoteConfigTopic remoteConfigTopic, final String str, Continuation<? super T> continuation) {
        Intrinsics.needClassReification();
        return blobData(remoteConfigTopic, str, new Function1<byte[], T>() { // from class: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.blobData.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(byte[] bytes) {
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                try {
                    Json json = JsonTools.INSTANCE.getJson();
                    String strDecodeToString = StringsKt.decodeToString(bytes);
                    SerializersModule serializersModule = json.getSerializersModule();
                    Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                    return (T) json.decodeFromString(SerializersKt.serializer(serializersModule, (KType) null), strDecodeToString);
                } catch (SerializationException e) {
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to parse remote config blob for item '" + str + "' as JSON.", e);
                    return null;
                }
            }
        }, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$blobData$4 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1598d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$blobData$4", m1609f = "RemoteConfigManager.kt", m1610i = {}, m1611l = {698}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72264<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ String $itemKey;
        final /* synthetic */ RemoteConfigTopic $topic;
        final /* synthetic */ Function1<byte[], T> $transform;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C72264(RemoteConfigTopic remoteConfigTopic, String str, Function1<? super byte[], ? extends T> function1, Continuation<? super C72264> continuation) {
            super(2, continuation);
            this.$topic = remoteConfigTopic;
            this.$itemKey = str;
            this.$transform = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RemoteConfigManager.this.new C72264(this.$topic, this.$itemKey, this.$transform, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C72264) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = RemoteConfigManager.this.resolveBlobBytes(this.$topic, this.$itemKey, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            byte[] bArr = (byte[]) obj;
            if (bArr != null) {
                return this.$transform.invoke(bArr);
            }
            return null;
        }
    }

    public final <T> Object blobData(RemoteConfigTopic remoteConfigTopic, String str, Function1<? super byte[], ? extends T> function1, Continuation<? super T> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C72264(remoteConfigTopic, str, function1, null), continuation);
    }

    public final /* synthetic */ <T> Object mergeItemsBlobData(final RemoteConfigTopic remoteConfigTopic, Collection<String> collection, Continuation<? super T> continuation) {
        Intrinsics.needClassReification();
        return mergeItemsBlobData(remoteConfigTopic, collection, new Function1<JsonObject, T>() { // from class: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager.mergeItemsBlobData.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(JsonObject merged) {
                Intrinsics.checkNotNullParameter(merged, "merged");
                try {
                    Json json = JsonTools.INSTANCE.getJson();
                    SerializersModule serializersModule = json.getSerializersModule();
                    Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                    return (T) json.decodeFromJsonElement(SerializersKt.serializer(serializersModule, (KType) null), merged);
                } catch (SerializationException e) {
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to decode merged remote config blobs from topic '" + remoteConfigTopic.getWireName() + "' as JSON.", e);
                    return null;
                }
            }
        }, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$mergeItemsBlobData$4 */
    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1598d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$mergeItemsBlobData$4", m1609f = "RemoteConfigManager.kt", m1610i = {}, m1611l = {743}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72384<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Collection<String> $itemKeys;
        final /* synthetic */ RemoteConfigTopic $topic;
        final /* synthetic */ Function1<JsonObject, T> $transform;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C72384(RemoteConfigTopic remoteConfigTopic, Collection<String> collection, Function1<? super JsonObject, ? extends T> function1, Continuation<? super C72384> continuation) {
            super(2, continuation);
            this.$topic = remoteConfigTopic;
            this.$itemKeys = collection;
            this.$transform = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RemoteConfigManager.this.new C72384(this.$topic, this.$itemKeys, this.$transform, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C72384) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = RemoteConfigManager.this.mergedBlobObject(this.$topic, this.$itemKeys, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            JsonObject jsonObject = (JsonObject) obj;
            if (jsonObject != null) {
                return this.$transform.invoke(jsonObject);
            }
            return null;
        }
    }

    public final <T> Object mergeItemsBlobData(RemoteConfigTopic remoteConfigTopic, Collection<String> collection, Function1<? super JsonObject, ? extends T> function1, Continuation<? super T> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C72384(remoteConfigTopic, collection, function1, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mergedBlobObject(RemoteConfigTopic remoteConfigTopic, Collection<String> collection, Continuation<? super JsonObject> continuation) {
        C72391 c72391;
        RemoteConfigTopic remoteConfigTopic2;
        List<String> list;
        if (continuation instanceof C72391) {
            c72391 = (C72391) continuation;
            if ((c72391.label & Integer.MIN_VALUE) != 0) {
                c72391.label -= Integer.MIN_VALUE;
            } else {
                c72391 = new C72391(continuation);
            }
        }
        Object objCoroutineScope = c72391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72391.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCoroutineScope);
            if (isDisabled()) {
                LogLevel logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Remote config disabled; skipping merged read for topic '" + remoteConfigTopic.getWireName() + "'.");
                }
                return null;
            }
            List listDistinct = CollectionsKt.distinct(collection);
            if (listDistinct.isEmpty()) {
                LogLevel logLevel2 = LogLevel.VERBOSE;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.mo1544v("[Purchases] - " + logLevel2.name(), "No item keys requested for merged remote config read in topic '" + remoteConfigTopic.getWireName() + "'.");
                }
                return null;
            }
            RemoteConfigManager$mergedBlobObject$resolved$1 remoteConfigManager$mergedBlobObject$resolved$1 = new RemoteConfigManager$mergedBlobObject$resolved$1(listDistinct, this, remoteConfigTopic, null);
            c72391.L$0 = remoteConfigTopic;
            c72391.L$1 = listDistinct;
            c72391.label = 1;
            objCoroutineScope = CoroutineScopeKt.coroutineScope(remoteConfigManager$mergedBlobObject$resolved$1, c72391);
            if (objCoroutineScope == coroutine_suspended) {
                return coroutine_suspended;
            }
            remoteConfigTopic2 = remoteConfigTopic;
            list = listDistinct;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) c72391.L$1;
            remoteConfigTopic2 = (RemoteConfigTopic) c72391.L$0;
            ResultKt.throwOnFailure(objCoroutineScope);
        }
        Map map = (Map) objCoroutineScope;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (((byte[]) entry.getValue()) == null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set setKeySet = linkedHashMap.keySet();
        if (!setKeySet.isEmpty()) {
            LogLevel logLevel3 = LogLevel.WARN;
            LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                currentLogHandler3.mo1545w("[Purchases] - " + logLevel3.name(), "Could not resolve remote config blob(s) for " + setKeySet.size() + " of " + map.size() + " requested item(s) in topic '" + remoteConfigTopic2.getWireName() + "': " + setKeySet + ". Returning null.");
            }
            return null;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (String str : list) {
            try {
                Json defaultJson = JsonProvider.INSTANCE.getDefaultJson();
                Object value = MapsKt.getValue(map, str);
                Intrinsics.checkNotNull(value);
                linkedHashMap2.put(str, defaultJson.parseToJsonElement(StringsKt.decodeToString((byte[]) value)));
            } catch (SerializationException e) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Remote config blob for item '" + str + "' in topic '" + remoteConfigTopic2.getWireName() + "' is not valid JSON.", e);
                return null;
            }
        }
        return new JsonObject(linkedHashMap2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveBlobBytes(RemoteConfigTopic remoteConfigTopic, String str, Continuation<? super byte[]> continuation) {
        C72401 c72401;
        RemoteConfigManager remoteConfigManager;
        RemoteConfigManager remoteConfigManager2;
        String str2;
        if (continuation instanceof C72401) {
            c72401 = (C72401) continuation;
            if ((c72401.label & Integer.MIN_VALUE) != 0) {
                c72401.label -= Integer.MIN_VALUE;
            } else {
                c72401 = new C72401(continuation);
            }
        }
        Object objCommittedItem = c72401.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72401.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCommittedItem);
            if (isDisabled()) {
                LogLevel logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Remote config disabled; skipping read of item '" + str + "'.");
                }
                return null;
            }
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.mo1544v("[Purchases] - " + logLevel2.name(), "Reading remote config blob (topic='" + remoteConfigTopic.getWireName() + "', item='" + str + "').");
            }
            c72401.L$0 = this;
            c72401.L$1 = str;
            c72401.label = 1;
            objCommittedItem = committedItem(remoteConfigTopic, str, c72401);
            if (objCommittedItem != coroutine_suspended) {
                remoteConfigManager = this;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) c72401.L$2;
            str = (String) c72401.L$1;
            remoteConfigManager2 = (RemoteConfigManager) c72401.L$0;
            ResultKt.throwOnFailure(objCommittedItem);
            if (!((Boolean) objCommittedItem).booleanValue()) {
                byte[] bArr = remoteConfigManager2.blobStore.read(str2);
                if (bArr != null) {
                    LogLevel logLevel3 = LogLevel.VERBOSE;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.mo1544v("[Purchases] - " + logLevel3.name(), "Resolved '" + str + "' from remote config blob '" + str2 + "' (" + bArr.length + " bytes).");
                        return bArr;
                    }
                } else {
                    LogLevel logLevel4 = LogLevel.WARN;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler4.mo1545w("[Purchases] - " + logLevel4.name(), "Remote config blob '" + str2 + "' for item '" + str + "' downloaded but read back null.");
                    }
                }
                return bArr;
            }
            LogLevel logLevel5 = LogLevel.WARN;
            LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                currentLogHandler5.mo1545w("[Purchases] - " + logLevel5.name(), "Failed to resolve remote config blob '" + str2 + "' for item '" + str + "'.");
            }
            return null;
        }
        str = (String) c72401.L$1;
        remoteConfigManager = (RemoteConfigManager) c72401.L$0;
        ResultKt.throwOnFailure(objCommittedItem);
        RemoteConfiguration.ConfigItem configItem = (RemoteConfiguration.ConfigItem) objCommittedItem;
        String blobRef = configItem != null ? configItem.getBlobRef() : null;
        if (blobRef != null) {
            RemoteConfigBlobFetcher remoteConfigBlobFetcher = remoteConfigManager.blobFetcher;
            c72401.L$0 = remoteConfigManager;
            c72401.L$1 = str;
            c72401.L$2 = blobRef;
            c72401.label = 2;
            Object objEnsureDownloaded = remoteConfigBlobFetcher.ensureDownloaded(blobRef, c72401);
            if (objEnsureDownloaded != coroutine_suspended) {
                remoteConfigManager2 = remoteConfigManager;
                str2 = blobRef;
                objCommittedItem = objEnsureDownloaded;
                if (!((Boolean) objCommittedItem).booleanValue()) {
                }
            }
            return coroutine_suspended;
        }
        LogLevel logLevel6 = LogLevel.VERBOSE;
        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
            currentLogHandler6.mo1544v("[Purchases] - " + logLevel6.name(), "Remote config item '" + str + "' is missing or has no blob ref; returning null.");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object committedItem(RemoteConfigTopic remoteConfigTopic, String str, Continuation<? super RemoteConfiguration.ConfigItem> continuation) {
        C72271 c72271;
        RemoteConfigManager remoteConfigManager;
        RemoteConfiguration.ConfigItem configItem;
        if (continuation instanceof C72271) {
            c72271 = (C72271) continuation;
            if ((c72271.label & Integer.MIN_VALUE) != 0) {
                c72271.label -= Integer.MIN_VALUE;
            } else {
                c72271 = new C72271(continuation);
            }
        }
        Object obj = c72271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c72271.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ConfigTopic configTopic = this.topicStore.topic(remoteConfigTopic);
            if (configTopic != null && (configItem = (RemoteConfiguration.ConfigItem) configTopic.get((Object) str)) != null) {
                return configItem;
            }
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Remote config item '" + str + "' not committed yet; awaiting config.");
            }
            c72271.L$0 = this;
            c72271.L$1 = remoteConfigTopic;
            c72271.L$2 = str;
            c72271.label = 1;
            if (awaitConfigForRead(c72271) == coroutine_suspended) {
                return coroutine_suspended;
            }
            remoteConfigManager = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c72271.L$2;
            remoteConfigTopic = (RemoteConfigTopic) c72271.L$1;
            remoteConfigManager = (RemoteConfigManager) c72271.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ConfigTopic configTopic2 = remoteConfigManager.topicStore.topic(remoteConfigTopic);
        RemoteConfiguration.ConfigItem configItem2 = configTopic2 != null ? (RemoteConfiguration.ConfigItem) configTopic2.get((Object) str) : null;
        if (configItem2 == null) {
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.mo1544v("[Purchases] - " + logLevel2.name(), "Remote config item '" + str + "' not found in topic '" + remoteConfigTopic.getWireName() + "'.");
            }
        }
        return configItem2;
    }

    private final void prefetchBlobs(RemoteConfiguration response, Map<String, ConfigTopic> mergedTopics) {
        String blobRef;
        this.sourceProvider.restartIfExhausted(RemoteConfigSourceHandle.Purpose.BLOB);
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.addAll(response.getPrefetchBlobs());
        Iterator<T> it = mergedTopics.values().iterator();
        while (it.hasNext()) {
            for (RemoteConfiguration.ConfigItem configItem : ((ConfigTopic) it.next()).values()) {
                if (configItem.getPrefetch() && (blobRef = configItem.getBlobRef()) != null) {
                    listCreateListBuilder.add(blobRef);
                }
            }
        }
        List listDistinct = CollectionsKt.distinct(CollectionsKt.build(listCreateListBuilder));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listDistinct) {
            if (!this.blobStore.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Prefetching " + arrayList2.size() + " remote config blob(s).");
        }
        this.blobFetcher.prefetch(arrayList2);
    }

    private final void extractInlineBlobs(RCContainer container, Set<String> refsToKeep) {
        for (RCElement rCElement : container.getContentElements()) {
            String strChecksumBase64 = rCElement.checksumBase64();
            if (refsToKeep.contains(strChecksumBase64) && !this.blobStore.contains(strChecksumBase64)) {
                try {
                    byte[] bArrDecode = rCElement.decode();
                    if (this.blobStore.write(strChecksumBase64, bArrDecode)) {
                        LogLevel logLevel = LogLevel.VERBOSE;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Stored inlined remote config blob '" + strChecksumBase64 + "' (" + bArrDecode.length + " bytes).");
                        }
                    }
                } catch (RCContainerFormatException e) {
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Skipping remote config blob '" + strChecksumBase64 + "': could not decode or verify its content.", e);
                }
            }
        }
    }

    /* JADX INFO: compiled from: RemoteConfigManager.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u0006X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigManager$Companion;", "", "()V", "DEFAULT_DOMAIN", "", "REFRESH_ATTEMPT_COOLDOWN", "Lkotlin/time/Duration;", "J", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        REFRESH_ATTEMPT_COOLDOWN = DurationKt.toDuration(1, DurationUnit.MINUTES);
    }

    private final void handleNotModified(int requestEpoch, Date requestDate) {
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "Remote config unchanged (204 Not Modified).");
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C72342(requestEpoch, requestDate, null), 3, null);
    }

    private final void logRefreshStart(PersistedRemoteConfigurationState persisted, boolean appInBackground) {
        String domain;
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            StringBuilder sb = new StringBuilder("Refreshing remote config (domain=");
            if (persisted == null || (domain = persisted.getDomain()) == null) {
                domain = "app";
            }
            currentLogHandler.mo1544v(str, sb.append(domain).append(", manifest present=").append((persisted != null ? persisted.getManifest() : null) != null).append(", appInBackground=").append(appInBackground).append(").").toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void persist(PersistedRemoteConfigurationState previous, RemoteConfiguration response, RCContainer container, Date requestDate) {
        Map<String, ConfigTopic> mapEmptyMap;
        Long l;
        Long lastRefreshTime;
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            String strJoinToString$default = CollectionsKt.joinToString$default(response.getTopics().entrySet(), null, null, null, 0, null, new Function1<Map.Entry<? extends String, ? extends ConfigTopic>, CharSequence>() { // from class: com.revenuecat.purchases.common.remoteconfig.RemoteConfigManager$persist$1$changed$1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final CharSequence invoke2(Map.Entry<String, ConfigTopic> entry) {
                    Intrinsics.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
                    return entry.getKey() + " -> items=" + entry.getValue().keySet();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends ConfigTopic> entry) {
                    return invoke2((Map.Entry<String, ConfigTopic>) entry);
                }
            }, 31, null);
            StringBuilder sbAppend = new StringBuilder("Received remote config: active topics=").append(response.getActiveTopics()).append("; changed topics: [");
            String str2 = strJoinToString$default;
            if (str2.length() == 0) {
                str2 = "none";
            }
            currentLogHandler.mo1541d(str, sbAppend.append(str2).append("].").toString());
        }
        if (previous == null || (mapEmptyMap = previous.getTopics()) == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        Map mapPlus = MapsKt.plus(mapEmptyMap, response.getTopics());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapPlus.entrySet()) {
            if (response.getActiveTopics().contains((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        Set<String> setPlus = SetsKt.plus(CollectionsKt.toSet(response.getPrefetchBlobs()), (Iterable) CollectionsKt.flatten(RemoteConfigManagerKt.toTopicBlobRefs(linkedHashMap2).values()));
        RemoteConfigDiskCache remoteConfigDiskCache = this.diskCache;
        String domain = response.getDomain();
        String manifest = response.getManifest();
        List<String> activeTopics = response.getActiveTopics();
        List<String> prefetchBlobs = response.getPrefetchBlobs();
        if (requestDate != null) {
            lastRefreshTime = Long.valueOf(requestDate.getTime());
        } else {
            if (previous == null) {
                l = null;
                if (!remoteConfigDiskCache.write(new PersistedRemoteConfigurationState(domain, manifest, activeTopics, prefetchBlobs, linkedHashMap2, l))) {
                    this.lastRefreshedAt = this.dateProvider.getNow();
                    this.lastRefreshAttemptAt = null;
                    this.hasCommittedInitialConfig = true;
                    LogLevel logLevel2 = LogLevel.DEBUG;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.mo1541d("[Purchases] - " + logLevel2.name(), "Persisted remote config (domain=" + response.getDomain() + TextRecallingManager.ANSWER_SEPARATOR + response.getActiveTopics().size() + " active topics, " + setPlus.size() + " blobs wanted).");
                    }
                    if (container != null) {
                        extractInlineBlobs(container, setPlus);
                    }
                    this.blobStore.retainOnly(setPlus);
                    prefetchBlobs(response, linkedHashMap2);
                    int iIncrementAndGet = this.generation.incrementAndGet();
                    Iterator<T> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        ((RemoteConfigCommitListener) it.next()).onConfigCommitted(iIncrementAndGet);
                    }
                    return;
                }
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Skipping remote config blob sync: failed to persist the configuration.", null);
                return;
            }
            lastRefreshTime = previous.getLastRefreshTime();
        }
        l = lastRefreshTime;
        if (!remoteConfigDiskCache.write(new PersistedRemoteConfigurationState(domain, manifest, activeTopics, prefetchBlobs, linkedHashMap2, l))) {
        }
    }
}

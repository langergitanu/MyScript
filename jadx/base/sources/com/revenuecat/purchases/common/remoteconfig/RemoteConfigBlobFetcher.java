package com.revenuecat.purchases.common.remoteconfig;

import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigSourceHandle;
import com.revenuecat.purchases.utils.DefaultUrlConnectionFactory;
import com.revenuecat.purchases.utils.UrlConnection;
import com.revenuecat.purchases.utils.UrlConnectionFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p039io.ByteStreamsKt;
import kotlin.p039io.CloseableKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: RemoteConfigBlobFetcher.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0000\u0018\u0000 72\u00020\u0001:\u0004789:B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u000fH\u0002J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020!0%2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'H\u0002J\u0016\u0010(\u001a\u00020!2\u0006\u0010#\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010)J\u001c\u0010(\u001a\u00020!2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0+H\u0086@¢\u0006\u0002\u0010,J\u0012\u0010-\u001a\u0004\u0018\u00010\u000f2\u0006\u0010.\u001a\u00020\u000fH\u0002J\u0014\u0010/\u001a\u00020\u001c2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0+J\u000e\u00100\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u00101J\u0018\u00102\u001a\u0002032\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0002J \u00104\u001a\u0002032\u0006\u00105\u001a\u0002062\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher;", "", "blobStore", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobStore;", "sourceProvider", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceProvider;", "timeoutManager", "Lcom/revenuecat/purchases/common/networking/HTTPTimeoutManager;", "urlConnectionFactory", "Lcom/revenuecat/purchases/utils/UrlConnectionFactory;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobStore;Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigSourceProvider;Lcom/revenuecat/purchases/common/networking/HTTPTimeoutManager;Lcom/revenuecat/purchases/utils/UrlConnectionFactory;Lkotlinx/coroutines/CoroutineScope;)V", "inFlight", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "lock", "pending", "Ljava/util/HashMap;", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher$PendingDownload;", "Lkotlin/collections/HashMap;", "queue", "Ljava/util/PriorityQueue;", "seqCounter", "", "signal", "Lkotlinx/coroutines/channels/Channel;", "", "claimNext", "complete", "download", "result", "", "downloadAndStore", "ref", "enqueue", "Lkotlinx/coroutines/CompletableDeferred;", LogFactory.PRIORITY_KEY, "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher$Priority;", "ensureDownloaded", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refs", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hostOf", ImagesContract.URL, "prefetch", "runWorker", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryDownloadVerifyStore", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher$DownloadOutcome;", "verifyAndStore", "bytes", "", "Companion", "DownloadOutcome", "PendingDownload", "Priority", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RemoteConfigBlobFetcher {
    private static final Companion Companion = new Companion(null);
    private static final int MAX_CONCURRENT_DOWNLOADS = 4;
    private static final int QUEUE_INITIAL_CAPACITY = 11;
    private final RemoteConfigBlobStore blobStore;
    private final HashSet<String> inFlight;
    private final Object lock;
    private final HashMap<String, PendingDownload> pending;
    private final PriorityQueue<PendingDownload> queue;
    private final CoroutineScope scope;
    private long seqCounter;
    private final Channel<Unit> signal;
    private final RemoteConfigSourceProvider sourceProvider;
    private final HTTPTimeoutManager timeoutManager;
    private final UrlConnectionFactory urlConnectionFactory;

    /* JADX INFO: compiled from: RemoteConfigBlobFetcher.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher$DownloadOutcome;", "", "(Ljava/lang/String;I)V", "SUCCESS", "SOURCE_UNHEALTHY", "BLOB_UNAVAILABLE", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private enum DownloadOutcome {
        SUCCESS,
        SOURCE_UNHEALTHY,
        BLOB_UNAVAILABLE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RemoteConfigBlobFetcher.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher$Priority;", "", "(Ljava/lang/String;I)V", "LOW", "HIGH", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    enum Priority {
        LOW,
        HIGH
    }

    /* JADX INFO: compiled from: RemoteConfigBlobFetcher.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadOutcome.values().length];
            try {
                iArr[DownloadOutcome.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DownloadOutcome.BLOB_UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DownloadOutcome.SOURCE_UNHEALTHY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$runWorker$1 */
    /* JADX INFO: compiled from: RemoteConfigBlobFetcher.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher", m1609f = "RemoteConfigBlobFetcher.kt", m1610i = {0}, m1611l = {156}, m1612m = "runWorker", m1613n = {"this"}, m1615s = {"L$0"})
    static final class C72181 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C72181(Continuation<? super C72181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteConfigBlobFetcher.this.runWorker(this);
        }
    }

    public RemoteConfigBlobFetcher(RemoteConfigBlobStore blobStore, RemoteConfigSourceProvider sourceProvider, HTTPTimeoutManager timeoutManager, UrlConnectionFactory urlConnectionFactory, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(blobStore, "blobStore");
        Intrinsics.checkNotNullParameter(sourceProvider, "sourceProvider");
        Intrinsics.checkNotNullParameter(timeoutManager, "timeoutManager");
        Intrinsics.checkNotNullParameter(urlConnectionFactory, "urlConnectionFactory");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.blobStore = blobStore;
        this.sourceProvider = sourceProvider;
        this.timeoutManager = timeoutManager;
        this.urlConnectionFactory = urlConnectionFactory;
        this.scope = scope;
        this.lock = new Object();
        this.pending = new HashMap<>();
        this.inFlight = new HashSet<>();
        final Comparator comparator = new Comparator() { // from class: com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$special$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((RemoteConfigBlobFetcher.PendingDownload) t2).getPriority(), ((RemoteConfigBlobFetcher.PendingDownload) t).getPriority());
            }
        };
        this.queue = new PriorityQueue<>(11, new Comparator() { // from class: com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$special$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Long.valueOf(((RemoteConfigBlobFetcher.PendingDownload) t).getSeq()), Long.valueOf(((RemoteConfigBlobFetcher.PendingDownload) t2).getSeq()));
            }
        });
        this.signal = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        for (int i = 0; i < 4; i++) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new RemoteConfigBlobFetcher$1$1(this, null), 3, null);
        }
    }

    public /* synthetic */ RemoteConfigBlobFetcher(RemoteConfigBlobStore remoteConfigBlobStore, RemoteConfigSourceProvider remoteConfigSourceProvider, HTTPTimeoutManager hTTPTimeoutManager, DefaultUrlConnectionFactory defaultUrlConnectionFactory, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(remoteConfigBlobStore, remoteConfigSourceProvider, hTTPTimeoutManager, (i & 8) != 0 ? new DefaultUrlConnectionFactory() : defaultUrlConnectionFactory, (i & 16) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RemoteConfigBlobFetcher.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\u0002\u0010\fR\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher$PendingDownload;", "", "ref", "", LogFactory.PRIORITY_KEY, "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher$Priority;", "seq", "", "awaiters", "", "Lkotlinx/coroutines/CompletableDeferred;", "", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher$Priority;JLjava/util/List;)V", "getAwaiters", "()Ljava/util/List;", "getPriority", "()Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher$Priority;", "setPriority", "(Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher$Priority;)V", "getRef", "()Ljava/lang/String;", "getSeq", "()J", "setSeq", "(J)V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    static final class PendingDownload {
        private final List<CompletableDeferred<Boolean>> awaiters;
        private Priority priority;
        private final String ref;
        private long seq;

        public PendingDownload(String ref, Priority priority, long j, List<CompletableDeferred<Boolean>> awaiters) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            Intrinsics.checkNotNullParameter(priority, "priority");
            Intrinsics.checkNotNullParameter(awaiters, "awaiters");
            this.ref = ref;
            this.priority = priority;
            this.seq = j;
            this.awaiters = awaiters;
        }

        public final String getRef() {
            return this.ref;
        }

        public final Priority getPriority() {
            return this.priority;
        }

        public final void setPriority(Priority priority) {
            Intrinsics.checkNotNullParameter(priority, "<set-?>");
            this.priority = priority;
        }

        public final long getSeq() {
            return this.seq;
        }

        public final void setSeq(long j) {
            this.seq = j;
        }

        public /* synthetic */ PendingDownload(String str, Priority priority, long j, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, priority, j, (i & 8) != 0 ? new ArrayList() : arrayList);
        }

        public final List<CompletableDeferred<Boolean>> getAwaiters() {
            return this.awaiters;
        }
    }

    public final Object ensureDownloaded(String str, Continuation<? super Boolean> continuation) {
        if (RemoteConfigUtils.INSTANCE.isValidRef(str)) {
            if (!this.blobStore.contains(str)) {
                this.sourceProvider.restartIfExhausted(RemoteConfigSourceHandle.Purpose.BLOB);
                return enqueue(str, Priority.HIGH).await(continuation);
            }
            return Boxing.boxBoolean(true);
        }
        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Refusing to download remote config blob with malformed ref '" + str + "'.", null);
        return Boxing.boxBoolean(false);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$ensureDownloaded$4 */
    /* JADX INFO: compiled from: RemoteConfigBlobFetcher.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$ensureDownloaded$4", m1609f = "RemoteConfigBlobFetcher.kt", m1610i = {}, m1611l = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72164 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ List<String> $refs;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RemoteConfigBlobFetcher this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72164(List<String> list, RemoteConfigBlobFetcher remoteConfigBlobFetcher, Continuation<? super C72164> continuation) {
            super(2, continuation);
            this.$refs = list;
            this.this$0 = remoteConfigBlobFetcher;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C72164 c72164 = new C72164(this.$refs, this.this$0, continuation);
            c72164.L$0 = obj;
            return c72164;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C72164) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                List<String> list = this.$refs;
                RemoteConfigBlobFetcher remoteConfigBlobFetcher = this.this$0;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new RemoteConfigBlobFetcher$ensureDownloaded$4$1$1(remoteConfigBlobFetcher, (String) it.next(), null), 3, null));
                }
                this.label = 1;
                obj = AwaitKt.awaitAll(arrayList, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Iterable iterable = (Iterable) obj;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it2 = iterable.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!((Boolean) it2.next()).booleanValue()) {
                        z = false;
                        break;
                    }
                }
            }
            return Boxing.boxBoolean(z);
        }
    }

    public final Object ensureDownloaded(List<String> list, Continuation<? super Boolean> continuation) {
        return CoroutineScopeKt.coroutineScope(new C72164(list, this, null), continuation);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$prefetch$1 */
    /* JADX INFO: compiled from: RemoteConfigBlobFetcher.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$prefetch$1", m1609f = "RemoteConfigBlobFetcher.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C72171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $refs;
        int label;
        final /* synthetic */ RemoteConfigBlobFetcher this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C72171(List<String> list, RemoteConfigBlobFetcher remoteConfigBlobFetcher, Continuation<? super C72171> continuation) {
            super(2, continuation);
            this.$refs = list;
            this.this$0 = remoteConfigBlobFetcher;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C72171(this.$refs, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C72171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Ref.IntRef intRef = new Ref.IntRef();
            List<String> list = this.$refs;
            RemoteConfigBlobFetcher remoteConfigBlobFetcher = this.this$0;
            for (String str : list) {
                if (RemoteConfigUtils.INSTANCE.isValidRef(str) && !remoteConfigBlobFetcher.blobStore.contains(str)) {
                    remoteConfigBlobFetcher.enqueue(str, Priority.LOW);
                    intRef.element++;
                }
            }
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Enqueued " + intRef.element + " remote config blob(s) for prefetch.");
            }
            return Unit.INSTANCE;
        }
    }

    public final void prefetch(List<String> refs) {
        Intrinsics.checkNotNullParameter(refs, "refs");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C72171(refs, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CompletableDeferred<Boolean> enqueue(String ref, Priority priority) {
        synchronized (this.lock) {
            CompletableDeferred<Boolean> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            PendingDownload pendingDownload = this.pending.get(ref);
            if (pendingDownload != null) {
                pendingDownload.getAwaiters().add(completableDeferredCompletableDeferred$default);
                if (priority.compareTo(pendingDownload.getPriority()) > 0 && !this.inFlight.contains(ref)) {
                    this.queue.remove(pendingDownload);
                    pendingDownload.setPriority(priority);
                    long j = this.seqCounter;
                    this.seqCounter = 1 + j;
                    pendingDownload.setSeq(j);
                    this.queue.offer(pendingDownload);
                }
                return completableDeferredCompletableDeferred$default;
            }
            long j2 = this.seqCounter;
            this.seqCounter = 1 + j2;
            PendingDownload pendingDownload2 = new PendingDownload(ref, priority, j2, null, 8, null);
            pendingDownload2.getAwaiters().add(completableDeferredCompletableDeferred$default);
            this.pending.put(ref, pendingDownload2);
            this.queue.offer(pendingDownload2);
            this.signal.mo16021trySendJP2dKIU(Unit.INSTANCE);
            return completableDeferredCompletableDeferred$default;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0044 -> B:18:0x0047). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object runWorker(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher.C72181
            if (r0 == 0) goto L14
            r0 = r10
            com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$runWorker$1 r0 = (com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher.C72181) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$runWorker$1 r0 = new com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$runWorker$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r2 = r0.L$0
            com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher r2 = (com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L47
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L36:
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r9
        L3a:
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r10 = r2.signal
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r10 = r10.receive(r0)
            if (r10 != r1) goto L47
            return r1
        L47:
            com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$PendingDownload r10 = r2.claimNext()
            if (r10 != 0) goto L4e
            goto L3a
        L4e:
            r4 = 0
            java.lang.String r5 = r10.getRef()     // Catch: java.lang.Throwable -> L58
            boolean r5 = r2.downloadAndStore(r5)     // Catch: java.lang.Throwable -> L58
            goto L7c
        L58:
            r5 = move-exception
            com.revenuecat.purchases.LogHandler r6 = com.revenuecat.purchases.common.LogWrapperKt.getCurrentLogHandler()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Unexpected failure downloading remote config blob '"
            r7.<init>(r8)
            java.lang.String r8 = r10.getRef()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = "'."
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "[Purchases] - ERROR"
            r6.mo1542e(r8, r7, r5)
            r5 = r4
        L7c:
            if (r5 != 0) goto L8a
            com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobStore r5 = r2.blobStore
            java.lang.String r6 = r10.getRef()
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L8b
        L8a:
            r4 = r3
        L8b:
            r2.complete(r10, r4)
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher.runWorker(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final PendingDownload claimNext() {
        PendingDownload pendingDownloadPoll;
        synchronized (this.lock) {
            pendingDownloadPoll = this.queue.poll();
            if (pendingDownloadPoll != null) {
                Intrinsics.checkNotNullExpressionValue(pendingDownloadPoll, "poll()");
                this.inFlight.add(pendingDownloadPoll.getRef());
            } else {
                pendingDownloadPoll = null;
            }
        }
        return pendingDownloadPoll;
    }

    private final void complete(PendingDownload download, boolean result) {
        List list;
        synchronized (this.lock) {
            this.pending.remove(download.getRef());
            this.inFlight.remove(download.getRef());
            list = CollectionsKt.toList(download.getAwaiters());
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((CompletableDeferred) it.next()).complete(Boolean.valueOf(result));
        }
    }

    private final boolean downloadAndStore(String ref) {
        if (this.blobStore.contains(ref)) {
            return true;
        }
        RemoteConfigSourceHandle current = this.sourceProvider.getCurrent(RemoteConfigSourceHandle.Purpose.BLOB);
        Boolean bool = null;
        while (current != null && bool == null) {
            String str = ref;
            int i = WhenMappings.$EnumSwitchMapping$0[tryDownloadVerifyStore(StringsKt.replace$default(current.getUrl(), "{blob_ref}", str, false, 4, (Object) null), str).ordinal()];
            if (i == 1) {
                bool = true;
            } else if (i == 2) {
                bool = false;
            } else if (i == 3) {
                this.sourceProvider.reportUnhealthy(current);
                RemoteConfigSourceHandle current2 = this.sourceProvider.getCurrent(RemoteConfigSourceHandle.Purpose.BLOB);
                LogLevel logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Remote config blob source unhealthy for '" + str + "'; " + (current2 != null ? "falling over to the next source." : "no sources left."));
                }
                current = current2;
            }
            ref = str;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010f A[PHI: r0 r2
      0x010f: PHI (r0v14 com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$DownloadOutcome) = 
      (r0v11 com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$DownloadOutcome)
      (r0v19 com.revenuecat.purchases.common.remoteconfig.RemoteConfigBlobFetcher$DownloadOutcome)
     binds: [B:45:0x010d, B:55:0x014b] A[DONT_GENERATE, DONT_INLINE]
      0x010f: PHI (r2v7 com.revenuecat.purchases.utils.UrlConnection) = (r2v4 com.revenuecat.purchases.utils.UrlConnection), (r2v8 com.revenuecat.purchases.utils.UrlConnection) binds: [B:45:0x010d, B:55:0x014b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015c  */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v13, types: [com.revenuecat.purchases.utils.UrlConnection] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final DownloadOutcome tryDownloadVerifyStore(String url, String ref) throws Throwable {
        char c;
        UrlConnection urlConnection;
        String str;
        String str2;
        UrlConnection urlConnection2;
        HTTPTimeoutManager.RequestResult requestResult;
        UrlConnection urlConnectionCreateConnection$default;
        DownloadOutcome downloadOutcome;
        ?? r3;
        HTTPTimeoutManager.RequestResult requestResult2;
        DownloadOutcome downloadOutcomeVerifyAndStore;
        String strHostOf = hostOf(url);
        int timeoutForRequest = (int) this.timeoutManager.getTimeoutForRequest(strHostOf, false, false, false, true);
        HTTPTimeoutManager.RequestResult requestResult3 = HTTPTimeoutManager.RequestResult.OTHER_RESULT;
        ?? r32 = 0;
        try {
            try {
                str = url;
                str2 = "Timed out downloading remote config blob '";
                c = '.';
            } catch (Throwable th) {
                th = th;
                r32 = 46;
            }
            try {
                urlConnectionCreateConnection$default = UrlConnectionFactory.createConnection$default(this.urlConnectionFactory, str, timeoutForRequest, timeoutForRequest, null, 8, null);
                try {
                    int responseCode = urlConnectionCreateConnection$default.getResponseCode();
                    if (responseCode == 200) {
                        InputStream inputStream = urlConnectionCreateConnection$default.getInputStream();
                        try {
                            byte[] bytes = ByteStreamsKt.readBytes(inputStream);
                            CloseableKt.closeFinally(inputStream, null);
                            requestResult3 = HTTPTimeoutManager.RequestResult.SUCCESS_ON_MAIN_BACKEND;
                            downloadOutcomeVerifyAndStore = verifyAndStore(bytes, ref, str);
                        } finally {
                        }
                    } else if (responseCode != 404) {
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "HTTP " + responseCode + " downloading remote config blob '" + ref + "' from " + str + '.', null);
                        downloadOutcomeVerifyAndStore = DownloadOutcome.SOURCE_UNHEALTHY;
                    } else {
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Remote config blob '" + ref + "' not found at " + str + " (404).", null);
                        downloadOutcomeVerifyAndStore = DownloadOutcome.BLOB_UNAVAILABLE;
                    }
                    this.timeoutManager.recordRequestResult(strHostOf, requestResult3);
                    if (urlConnectionCreateConnection$default != null) {
                        urlConnectionCreateConnection$default.disconnect();
                    }
                    return downloadOutcomeVerifyAndStore;
                } catch (SocketTimeoutException e) {
                    e = e;
                    LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", str2 + ref + "' from " + str + c, e);
                    requestResult2 = HTTPTimeoutManager.RequestResult.MAIN_SOURCE_TIMED_OUT;
                    try {
                        downloadOutcome = DownloadOutcome.SOURCE_UNHEALTHY;
                        this.timeoutManager.recordRequestResult(strHostOf, requestResult2);
                        if (urlConnectionCreateConnection$default != null) {
                            urlConnectionCreateConnection$default.disconnect();
                        }
                        return downloadOutcome;
                    } catch (Throwable th2) {
                        th = th2;
                        requestResult = requestResult2;
                        r3 = urlConnectionCreateConnection$default;
                        this.timeoutManager.recordRequestResult(strHostOf, requestResult);
                        if (r3 != 0) {
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    requestResult = requestResult3;
                    try {
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to download remote config blob '" + ref + "' from " + str + c, e);
                        downloadOutcome = DownloadOutcome.SOURCE_UNHEALTHY;
                        this.timeoutManager.recordRequestResult(strHostOf, requestResult);
                        if (urlConnectionCreateConnection$default != null) {
                        }
                        return downloadOutcome;
                    } catch (Throwable th3) {
                        th = th3;
                        r3 = urlConnectionCreateConnection$default;
                        this.timeoutManager.recordRequestResult(strHostOf, requestResult);
                        if (r3 != 0) {
                            r3.disconnect();
                        }
                        throw th;
                    }
                }
            } catch (SocketTimeoutException e3) {
                e = e3;
                urlConnection2 = null;
                urlConnectionCreateConnection$default = urlConnection2;
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", str2 + ref + "' from " + str + c, e);
                requestResult2 = HTTPTimeoutManager.RequestResult.MAIN_SOURCE_TIMED_OUT;
                downloadOutcome = DownloadOutcome.SOURCE_UNHEALTHY;
                this.timeoutManager.recordRequestResult(strHostOf, requestResult2);
                if (urlConnectionCreateConnection$default != null) {
                }
                return downloadOutcome;
            } catch (IOException e4) {
                e = e4;
                urlConnection = null;
                urlConnectionCreateConnection$default = urlConnection;
                requestResult = requestResult3;
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to download remote config blob '" + ref + "' from " + str + c, e);
                downloadOutcome = DownloadOutcome.SOURCE_UNHEALTHY;
                this.timeoutManager.recordRequestResult(strHostOf, requestResult);
                if (urlConnectionCreateConnection$default != null) {
                }
                return downloadOutcome;
            } catch (Throwable th4) {
                th = th4;
                r32 = 0;
                requestResult = requestResult3;
                r3 = r32;
                this.timeoutManager.recordRequestResult(strHostOf, requestResult);
                if (r3 != 0) {
                }
                throw th;
            }
        } catch (SocketTimeoutException e5) {
            e = e5;
            str2 = "Timed out downloading remote config blob '";
            c = '.';
            urlConnection2 = null;
            str = url;
        } catch (IOException e6) {
            e = e6;
            c = '.';
            urlConnection = null;
            str = url;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private final String hostOf(String url) {
        try {
            String host = new URL(url).getHost();
            if (host != null) {
                if (!StringsKt.isBlank(host)) {
                    return host;
                }
            }
            return null;
        } catch (MalformedURLException e) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Could not resolve host for remote config blob URL " + url + ": " + e.getMessage());
            }
            return null;
        }
    }

    private final DownloadOutcome verifyAndStore(byte[] bytes, String ref, String url) {
        if (Intrinsics.areEqual(RemoteConfigUtils.INSTANCE.contentAddressRef(bytes), ref)) {
            if (!this.blobStore.write(ref, bytes)) {
                return DownloadOutcome.BLOB_UNAVAILABLE;
            }
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Downloaded and stored remote config blob '" + ref + "' (" + bytes.length + " bytes) from " + url + '.');
            }
            return DownloadOutcome.SUCCESS;
        }
        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Remote config blob '" + ref + "' from " + url + " failed content-address verification.", null);
        return DownloadOutcome.BLOB_UNAVAILABLE;
    }

    /* JADX INFO: compiled from: RemoteConfigBlobFetcher.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigBlobFetcher$Companion;", "", "()V", "MAX_CONCURRENT_DOWNLOADS", "", "QUEUE_INITIAL_CAPACITY", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

package com.revenuecat.purchases.storage;

import android.content.Context;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.utils.DefaultUrlConnectionFactory;
import com.revenuecat.purchases.utils.UrlConnection;
import com.revenuecat.purchases.utils.UrlConnectionFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.CloseableKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.NonCancellable;

/* JADX INFO: compiled from: DefaultFileRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001:\u0002'(B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006BA\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010\u001f\u001a\u00020 2\u001a\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001c0#0\"H\u0016J\"\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, m1599d2 = {"Lcom/revenuecat/purchases/storage/DefaultFileRepository;", "Lcom/revenuecat/purchases/storage/FileRepository;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "subDir", "", "(Landroid/content/Context;Ljava/lang/String;)V", "store", "Lcom/revenuecat/purchases/storage/KeyedDeferredValueStore;", "Lcom/revenuecat/purchases/storage/DefaultFileRepository$CacheKey;", "Ljava/net/URI;", "fileCacheManager", "Lcom/revenuecat/purchases/storage/LocalFileCache;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "logHandler", "Lcom/revenuecat/purchases/LogHandler;", "urlConnectionFactory", "Lcom/revenuecat/purchases/utils/UrlConnectionFactory;", "(Lcom/revenuecat/purchases/storage/KeyedDeferredValueStore;Lcom/revenuecat/purchases/storage/LocalFileCache;Lkotlinx/coroutines/CoroutineScope;Lcom/revenuecat/purchases/LogHandler;Lcom/revenuecat/purchases/utils/UrlConnectionFactory;)V", "getStore$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/storage/KeyedDeferredValueStore;", "downloadFile", "Lcom/revenuecat/purchases/utils/UrlConnection;", ImagesContract.URL, "Ljava/net/URL;", "generateOrGetCachedFileURL", "checksum", "Lcom/revenuecat/purchases/models/Checksum;", "(Ljava/net/URL;Lcom/revenuecat/purchases/models/Checksum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFile", "prefetch", "", "urls", "", "Lkotlin/Pair;", "saveCachedFile", "uri", "connectionWithStream", "CacheKey", "Error", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class DefaultFileRepository implements FileRepository {
    private final LocalFileCache fileCacheManager;
    private final CoroutineScope ioScope;
    private final LogHandler logHandler;
    private final KeyedDeferredValueStore<CacheKey, URI> store;
    private final UrlConnectionFactory urlConnectionFactory;

    public DefaultFileRepository(KeyedDeferredValueStore<CacheKey, URI> store, LocalFileCache fileCacheManager, CoroutineScope ioScope, LogHandler logHandler, UrlConnectionFactory urlConnectionFactory) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(fileCacheManager, "fileCacheManager");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(logHandler, "logHandler");
        Intrinsics.checkNotNullParameter(urlConnectionFactory, "urlConnectionFactory");
        this.store = store;
        this.fileCacheManager = fileCacheManager;
        this.ioScope = ioScope;
        this.logHandler = logHandler;
        this.urlConnectionFactory = urlConnectionFactory;
    }

    public /* synthetic */ DefaultFileRepository(KeyedDeferredValueStore keyedDeferredValueStore, LocalFileCache localFileCache, CoroutineScope coroutineScope, LogHandler logHandler, DefaultUrlConnectionFactory defaultUrlConnectionFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new KeyedDeferredValueStore(null, 1, null) : keyedDeferredValueStore, localFileCache, (i & 4) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(NonCancellable.INSTANCE)) : coroutineScope, (i & 8) != 0 ? LogWrapperKt.getCurrentLogHandler() : logHandler, (i & 16) != 0 ? new DefaultUrlConnectionFactory() : defaultUrlConnectionFactory);
    }

    public final KeyedDeferredValueStore<CacheKey, URI> getStore$purchases_defaultsRelease() {
        return this.store;
    }

    /* JADX INFO: compiled from: DefaultFileRepository.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/storage/DefaultFileRepository$CacheKey;", "", ImagesContract.URL, "Ljava/net/URL;", "checksum", "Lcom/revenuecat/purchases/models/Checksum;", "(Ljava/net/URL;Lcom/revenuecat/purchases/models/Checksum;)V", "getChecksum", "()Lcom/revenuecat/purchases/models/Checksum;", "getUrl", "()Ljava/net/URL;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class CacheKey {
        private final Checksum checksum;
        private final URL url;

        public static /* synthetic */ CacheKey copy$default(CacheKey cacheKey, URL url, Checksum checksum, int i, Object obj) {
            if ((i & 1) != 0) {
                url = cacheKey.url;
            }
            if ((i & 2) != 0) {
                checksum = cacheKey.checksum;
            }
            return cacheKey.copy(url, checksum);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final URL getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Checksum getChecksum() {
            return this.checksum;
        }

        public final CacheKey copy(URL url, Checksum checksum) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new CacheKey(url, checksum);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) other;
            return Intrinsics.areEqual(this.url, cacheKey.url) && Intrinsics.areEqual(this.checksum, cacheKey.checksum);
        }

        public int hashCode() {
            int iHashCode = this.url.hashCode() * 31;
            Checksum checksum = this.checksum;
            return iHashCode + (checksum == null ? 0 : checksum.hashCode());
        }

        public String toString() {
            return "CacheKey(url=" + this.url + ", checksum=" + this.checksum + ')';
        }

        public CacheKey(URL url, Checksum checksum) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.checksum = checksum;
        }

        public final URL getUrl() {
            return this.url;
        }

        public final Checksum getChecksum() {
            return this.checksum;
        }
    }

    public /* synthetic */ DefaultFileRepository(Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? DefaultFileCache.DEFAULT_SUBDIR : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultFileRepository(Context context, String subDir) {
        this(null, new DefaultFileCache(context, subDir), null, null, null, 29, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subDir, "subDir");
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.storage.DefaultFileRepository$prefetch$1 */
    /* JADX INFO: compiled from: DefaultFileRepository.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.storage.DefaultFileRepository$prefetch$1", m1609f = "DefaultFileRepository.kt", m1610i = {0}, m1611l = {96}, m1612m = "invokeSuspend", m1613n = {ImagesContract.URL}, m1615s = {"L$2"})
    static final class C74471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Pair<URL, Checksum>> $urls;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ DefaultFileRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C74471(List<Pair<URL, Checksum>> list, DefaultFileRepository defaultFileRepository, Continuation<? super C74471> continuation) {
            super(2, continuation);
            this.$urls = list;
            this.this$0 = defaultFileRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C74471(this.$urls, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C74471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005b -> B:13:0x0034). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterator it;
            DefaultFileRepository defaultFileRepository;
            URL url;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<Pair<URL, Checksum>> list = this.$urls;
                DefaultFileRepository defaultFileRepository2 = this.this$0;
                it = list.iterator();
                defaultFileRepository = defaultFileRepository2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                url = (URL) this.L$2;
                it = (Iterator) this.L$1;
                defaultFileRepository = (DefaultFileRepository) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (IOException e) {
                    defaultFileRepository.logHandler.mo1542e("FileRepository", "Prefetch failed for " + url + ": " + e, e);
                }
            }
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                url = (URL) pair.component1();
                Checksum checksum = (Checksum) pair.component2();
                this.L$0 = defaultFileRepository;
                this.L$1 = it;
                this.L$2 = url;
                this.label = 1;
                if (defaultFileRepository.generateOrGetCachedFileURL(url, checksum, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.revenuecat.purchases.storage.FileRepository
    public void prefetch(List<Pair<URL, Checksum>> urls) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C74471(urls, this, null), 3, null);
    }

    @Override // com.revenuecat.purchases.storage.FileRepository
    public Object generateOrGetCachedFileURL(final URL url, final Checksum checksum, Continuation<? super URI> continuation) {
        return this.store.getOrPut(new CacheKey(url, checksum), new Function0<Deferred<? extends URI>>() { // from class: com.revenuecat.purchases.storage.DefaultFileRepository.generateOrGetCachedFileURL.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: renamed from: com.revenuecat.purchases.storage.DefaultFileRepository$generateOrGetCachedFileURL$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: DefaultFileRepository.kt */
            @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "Ljava/net/URI;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
            @DebugMetadata(m1608c = "com.revenuecat.purchases.storage.DefaultFileRepository$generateOrGetCachedFileURL$2$1", m1609f = "DefaultFileRepository.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super URI>, Object> {
                final /* synthetic */ Checksum $checksum;
                final /* synthetic */ URL $url;
                int label;
                final /* synthetic */ DefaultFileRepository this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(DefaultFileRepository defaultFileRepository, URL url, Checksum checksum, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = defaultFileRepository;
                    this.$url = url;
                    this.$checksum = checksum;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$url, this.$checksum, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super URI> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Error.FailedToFetchFileFromRemoteSource, Error.FailedToCreateCacheDirectory {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    URI uriGenerateLocalFilesystemURI = this.this$0.fileCacheManager.generateLocalFilesystemURI(this.$url, this.$checksum);
                    if (uriGenerateLocalFilesystemURI != null) {
                        if (this.this$0.fileCacheManager.cachedContentExists(uriGenerateLocalFilesystemURI)) {
                            return uriGenerateLocalFilesystemURI;
                        }
                        this.this$0.saveCachedFile(uriGenerateLocalFilesystemURI, this.this$0.downloadFile(this.$url), this.$checksum);
                        return uriGenerateLocalFilesystemURI;
                    }
                    String string = this.$url.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "url.toString()");
                    Error.FailedToCreateCacheDirectory failedToCreateCacheDirectory = new Error.FailedToCreateCacheDirectory(string);
                    this.this$0.logHandler.mo1542e("FileRepository", "Failed to create cache directory for " + this.$url, failedToCreateCacheDirectory);
                    throw failedToCreateCacheDirectory;
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final Deferred<? extends URI> invoke() {
                return BuildersKt__Builders_commonKt.async$default(DefaultFileRepository.this.ioScope, null, null, new AnonymousClass1(DefaultFileRepository.this, url, checksum, null), 3, null);
            }
        }).await(continuation);
    }

    @Override // com.revenuecat.purchases.storage.FileRepository
    public URI getFile(URL url, Checksum checksum) {
        Intrinsics.checkNotNullParameter(url, "url");
        URI uriGenerateLocalFilesystemURI = this.fileCacheManager.generateLocalFilesystemURI(url, checksum);
        if (uriGenerateLocalFilesystemURI == null || !this.fileCacheManager.cachedContentExists(uriGenerateLocalFilesystemURI)) {
            return null;
        }
        return uriGenerateLocalFilesystemURI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveCachedFile(URI uri, UrlConnection connectionWithStream, Checksum checksum) {
        try {
            try {
                InputStream inputStream = connectionWithStream.getInputStream();
                try {
                    this.fileCacheManager.saveData(inputStream, uri, checksum);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(inputStream, null);
                } finally {
                }
            } finally {
                connectionWithStream.disconnect();
            }
        } catch (Checksum.ChecksumValidationException e) {
            String str = "Checksum validation failed for " + uri + ": " + e.getMessage();
            this.logHandler.mo1542e("FileRepository", str, e);
            throw new Error.ChecksumValidationFailed(str);
        } catch (IOException e2) {
            String str2 = "Failed to save cached file: " + uri + ". Error: " + e2.getLocalizedMessage();
            this.logHandler.mo1542e("FileRepository", str2, e2);
            throw new Error.FailedToSaveCachedFile(str2);
        }
    }

    /* JADX INFO: compiled from: DefaultFileRepository.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/storage/DefaultFileRepository$Error;", "Ljava/io/IOException;", "message", "", "(Ljava/lang/String;)V", "ChecksumValidationFailed", "FailedToCreateCacheDirectory", "FailedToFetchFileFromRemoteSource", "FailedToSaveCachedFile", "Lcom/revenuecat/purchases/storage/DefaultFileRepository$Error$ChecksumValidationFailed;", "Lcom/revenuecat/purchases/storage/DefaultFileRepository$Error$FailedToCreateCacheDirectory;", "Lcom/revenuecat/purchases/storage/DefaultFileRepository$Error$FailedToFetchFileFromRemoteSource;", "Lcom/revenuecat/purchases/storage/DefaultFileRepository$Error$FailedToSaveCachedFile;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static abstract class Error extends IOException {
        public /* synthetic */ Error(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        private Error(String str) {
            super(str);
        }

        /* JADX INFO: compiled from: DefaultFileRepository.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/storage/DefaultFileRepository$Error$FailedToCreateCacheDirectory;", "Lcom/revenuecat/purchases/storage/DefaultFileRepository$Error;", ImagesContract.URL, "", "(Ljava/lang/String;)V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class FailedToCreateCacheDirectory extends Error {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FailedToCreateCacheDirectory(String url) {
                super("Failed to create cache directory for " + url, null);
                Intrinsics.checkNotNullParameter(url, "url");
            }
        }

        /* JADX INFO: compiled from: DefaultFileRepository.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/storage/DefaultFileRepository$Error$FailedToSaveCachedFile;", "Lcom/revenuecat/purchases/storage/DefaultFileRepository$Error;", "message", "", "(Ljava/lang/String;)V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class FailedToSaveCachedFile extends Error {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FailedToSaveCachedFile(String message) {
                super(message, null);
                Intrinsics.checkNotNullParameter(message, "message");
            }
        }

        /* JADX INFO: compiled from: DefaultFileRepository.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/storage/DefaultFileRepository$Error$FailedToFetchFileFromRemoteSource;", "Lcom/revenuecat/purchases/storage/DefaultFileRepository$Error;", "message", "", "(Ljava/lang/String;)V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class FailedToFetchFileFromRemoteSource extends Error {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FailedToFetchFileFromRemoteSource(String message) {
                super(message, null);
                Intrinsics.checkNotNullParameter(message, "message");
            }
        }

        /* JADX INFO: compiled from: DefaultFileRepository.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/storage/DefaultFileRepository$Error$ChecksumValidationFailed;", "Lcom/revenuecat/purchases/storage/DefaultFileRepository$Error;", "message", "", "(Ljava/lang/String;)V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class ChecksumValidationFailed extends Error {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ChecksumValidationFailed(String message) {
                super(message, null);
                Intrinsics.checkNotNullParameter(message, "message");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UrlConnection downloadFile(URL url) throws Error.FailedToFetchFileFromRemoteSource {
        try {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Downloading remote file from " + url);
            }
            UrlConnectionFactory urlConnectionFactory = this.urlConnectionFactory;
            String string = url.toString();
            Intrinsics.checkNotNullExpressionValue(string, "url.toString()");
            UrlConnection urlConnectionCreateConnection$default = UrlConnectionFactory.createConnection$default(urlConnectionFactory, string, 5000, 5000, null, 8, null);
            if (urlConnectionCreateConnection$default.getResponseCode() == 200) {
                return urlConnectionCreateConnection$default;
            }
            urlConnectionCreateConnection$default.disconnect();
            throw new IOException("HTTP " + urlConnectionCreateConnection$default.getResponseCode() + " when downloading file at: " + url);
        } catch (IOException e) {
            String str = "Failed to fetch file from remote source: " + url + ". Error: " + e.getLocalizedMessage();
            this.logHandler.mo1542e("FileRepository", str, e);
            throw new Error.FailedToFetchFileFromRemoteSource(str);
        }
    }
}

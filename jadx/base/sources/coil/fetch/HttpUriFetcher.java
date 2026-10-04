package coil.fetch;

import android.net.Uri;
import android.os.NetworkOnMainThreadException;
import android.webkit.MimeTypeMap;
import androidx.webkit.ProxyConfig;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import coil.decode.ImageSources;
import coil.disk.DiskCache;
import coil.fetch.Fetcher;
import coil.network.CacheResponse;
import coil.network.CacheStrategy;
import coil.network.HttpException;
import coil.request.Options;
import coil.util.Calls;
import coil.util.Utils;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.myscript.snt.core.SearchMatchParser;
import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;

/* JADX INFO: compiled from: HttpUriFetcher.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 22\u00020\u0001:\u000212B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J.\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!H\u0001¢\u0006\u0002\b\"J\u0018\u0010#\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010$\u001a\u0004\u0018\u00010\u001b*\u00020\u0013H\u0002J\f\u0010%\u001a\u00020&*\u00020\u0013H\u0002J\f\u0010%\u001a\u00020&*\u00020'H\u0002J\f\u0010(\u001a\u00020)*\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00063"}, m1599d2 = {"Lcoil/fetch/HttpUriFetcher;", "Lcoil/fetch/Fetcher;", ImagesContract.URL, "", "options", "Lcoil/request/Options;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "<init>", "(Ljava/lang/String;Lcoil/request/Options;Lkotlin/Lazy;Lkotlin/Lazy;Z)V", RemoteConfigComponent.FETCH_FILE_NAME, "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFromDiskCache", "Lcoil/disk/DiskCache$Snapshot;", "writeToDiskCache", "snapshot", "request", "Lokhttp3/Request;", "response", "Lokhttp3/Response;", "cacheResponse", "Lcoil/network/CacheResponse;", "newRequest", "executeNetworkRequest", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "contentType", "Lokhttp3/MediaType;", "getMimeType$coil_base_release", "isCacheable", "toCacheResponse", "toImageSource", "Lcoil/decode/ImageSource;", "Lokhttp3/ResponseBody;", "toDataSource", "Lcoil/decode/DataSource;", "diskCacheKey", "getDiskCacheKey", "()Ljava/lang/String;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "Factory", "Companion", "coil-base_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class HttpUriFetcher implements Fetcher {
    private static final String MIME_TYPE_TEXT_PLAIN = "text/plain";
    private final Lazy<Call.Factory> callFactory;
    private final Lazy<DiskCache> diskCache;
    private final Options options;
    private final boolean respectCacheHeaders;
    private final String url;
    private static final CacheControl CACHE_CONTROL_FORCE_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().noStore().build();
    private static final CacheControl CACHE_CONTROL_NO_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().onlyIfCached().build();

    /* JADX INFO: renamed from: coil.fetch.HttpUriFetcher$executeNetworkRequest$1 */
    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.fetch.HttpUriFetcher", m1609f = "HttpUriFetcher.kt", m1610i = {}, m1611l = {224}, m1612m = "executeNetworkRequest", m1613n = {}, m1615s = {})
    static final class C38271 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C38271(Continuation<? super C38271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpUriFetcher.this.executeNetworkRequest(null, this);
        }
    }

    /* JADX INFO: renamed from: coil.fetch.HttpUriFetcher$fetch$1 */
    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.fetch.HttpUriFetcher", m1609f = "HttpUriFetcher.kt", m1610i = {0, 0, 0, 1, 1, 1}, m1611l = {77, 106}, m1612m = RemoteConfigComponent.FETCH_FILE_NAME, m1613n = {"this", "snapshot", "cacheStrategy", "this", "snapshot", "response"}, m1615s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class C38281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C38281(Continuation<? super C38281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpUriFetcher.this.fetch(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpUriFetcher(String str, Options options, Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean z) {
        this.url = str;
        this.options = options;
        this.callFactory = lazy;
        this.diskCache = lazy2;
        this.respectCacheHeaders = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0129 A[Catch: Exception -> 0x01a3, TryCatch #4 {Exception -> 0x01a3, blocks: (B:68:0x0187, B:52:0x011b, B:54:0x0129, B:56:0x0137, B:57:0x013b, B:59:0x0145, B:61:0x0151, B:63:0x0169), top: B:87:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0145 A[Catch: Exception -> 0x01a3, TryCatch #4 {Exception -> 0x01a3, blocks: (B:68:0x0187, B:52:0x011b, B:54:0x0129, B:56:0x0137, B:57:0x013b, B:59:0x0145, B:61:0x0151, B:63:0x0169), top: B:87:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r0v12, types: [coil.fetch.HttpUriFetcher] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r11v0, types: [coil.fetch.HttpUriFetcher, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [coil.disk.DiskCache$Snapshot] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20, types: [coil.disk.DiskCache$Snapshot] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v9, types: [coil.fetch.HttpUriFetcher, java.lang.Object] */
    @Override // coil.fetch.Fetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetch(Continuation<? super FetchResult> continuation) throws Exception {
        C38281 c38281;
        ?? r4;
        CacheStrategy cacheStrategyCompute;
        ?? r2;
        CacheStrategy cacheStrategy;
        ?? r6;
        Response response;
        Response response2;
        Exception e;
        DiskCache.Snapshot snapshotWriteToDiskCache;
        ?? r0;
        if (continuation instanceof C38281) {
            c38281 = (C38281) continuation;
            if ((c38281.label & Integer.MIN_VALUE) != 0) {
                c38281.label -= Integer.MIN_VALUE;
            } else {
                c38281 = new C38281(continuation);
            }
        }
        Object obj = c38281.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r22 = c38281.label;
        try {
            if (r22 == 0) {
                ResultKt.throwOnFailure(obj);
                DiskCache.Snapshot fromDiskCache = readFromDiskCache();
                try {
                    if (fromDiskCache != null) {
                        Long size = getFileSystem().metadata(fromDiskCache.getMetadata()).getSize();
                        if (size != null && size.longValue() == 0) {
                            return new SourceResult(toImageSource(fromDiskCache), getMimeType$coil_base_release(this.url, null), DataSource.DISK);
                        }
                        if (this.respectCacheHeaders) {
                            cacheStrategyCompute = new CacheStrategy.Factory(newRequest(), toCacheResponse(fromDiskCache)).compute();
                            if (cacheStrategyCompute.getNetworkRequest() == null && cacheStrategyCompute.getCacheResponse() != null) {
                                return new SourceResult(toImageSource(fromDiskCache), getMimeType$coil_base_release(this.url, cacheStrategyCompute.getCacheResponse().getContentType()), DataSource.DISK);
                            }
                        } else {
                            ImageSource imageSource = toImageSource(fromDiskCache);
                            String str = this.url;
                            CacheResponse cacheResponse = toCacheResponse(fromDiskCache);
                            return new SourceResult(imageSource, getMimeType$coil_base_release(str, cacheResponse != null ? cacheResponse.getContentType() : null), DataSource.DISK);
                        }
                    } else {
                        cacheStrategyCompute = new CacheStrategy.Factory(newRequest(), null).compute();
                    }
                    Request networkRequest = cacheStrategyCompute.getNetworkRequest();
                    Intrinsics.checkNotNull(networkRequest);
                    c38281.L$0 = this;
                    c38281.L$1 = fromDiskCache;
                    c38281.L$2 = cacheStrategyCompute;
                    c38281.label = 1;
                    Object objExecuteNetworkRequest = executeNetworkRequest(networkRequest, c38281);
                    if (objExecuteNetworkRequest != coroutine_suspended) {
                        CacheStrategy cacheStrategy2 = cacheStrategyCompute;
                        r2 = fromDiskCache;
                        obj = objExecuteNetworkRequest;
                        cacheStrategy = cacheStrategy2;
                        r6 = this;
                        response = (Response) obj;
                        ResponseBody responseBodyRequireBody = Utils.requireBody(response);
                        snapshotWriteToDiskCache = r6.writeToDiskCache(r2, cacheStrategy.getNetworkRequest(), response, cacheStrategy.getCacheResponse());
                        if (snapshotWriteToDiskCache == null) {
                        }
                    }
                    return coroutine_suspended;
                } catch (Exception e2) {
                    r4 = fromDiskCache;
                    e = e2;
                    if (r4 != 0) {
                        Utils.closeQuietly((Closeable) r4);
                    }
                    throw e;
                }
            }
            if (r22 != 1) {
                if (r22 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                response2 = (Response) c38281.L$2;
                HttpUriFetcher httpUriFetcher = (HttpUriFetcher) c38281.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    r0 = httpUriFetcher;
                    Response response3 = (Response) obj;
                    ResponseBody responseBodyRequireBody2 = Utils.requireBody(response3);
                    return new SourceResult(r0.toImageSource(responseBodyRequireBody2), r0.getMimeType$coil_base_release(r0.url, responseBodyRequireBody2.getMediaType()), r0.toDataSource(response3));
                } catch (Exception e3) {
                    e = e3;
                    Utils.closeQuietly(response2);
                    throw e;
                }
            }
            CacheStrategy cacheStrategy3 = (CacheStrategy) c38281.L$2;
            r4 = (DiskCache.Snapshot) c38281.L$1;
            HttpUriFetcher httpUriFetcher2 = (HttpUriFetcher) c38281.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                cacheStrategy = cacheStrategy3;
                r2 = r4;
                r6 = httpUriFetcher2;
                response = (Response) obj;
                ResponseBody responseBodyRequireBody3 = Utils.requireBody(response);
                try {
                    snapshotWriteToDiskCache = r6.writeToDiskCache(r2, cacheStrategy.getNetworkRequest(), response, cacheStrategy.getCacheResponse());
                    if (snapshotWriteToDiskCache == null) {
                        ImageSource imageSource2 = r6.toImageSource(snapshotWriteToDiskCache);
                        String str2 = r6.url;
                        CacheResponse cacheResponse2 = r6.toCacheResponse(snapshotWriteToDiskCache);
                        return new SourceResult(imageSource2, r6.getMimeType$coil_base_release(str2, cacheResponse2 != null ? cacheResponse2.getContentType() : null), DataSource.NETWORK);
                    }
                    if (responseBodyRequireBody3.getSource().request(1L)) {
                        return new SourceResult(r6.toImageSource(responseBodyRequireBody3), r6.getMimeType$coil_base_release(r6.url, responseBodyRequireBody3.getMediaType()), r6.toDataSource(response));
                    }
                    Utils.closeQuietly(response);
                    Request requestNewRequest = r6.newRequest();
                    c38281.L$0 = r6;
                    c38281.L$1 = snapshotWriteToDiskCache;
                    c38281.L$2 = response;
                    c38281.label = 2;
                    Object objExecuteNetworkRequest2 = r6.executeNetworkRequest(requestNewRequest, c38281);
                    if (objExecuteNetworkRequest2 != coroutine_suspended) {
                        response2 = response;
                        obj = objExecuteNetworkRequest2;
                        r0 = r6;
                        Response response32 = (Response) obj;
                        ResponseBody responseBodyRequireBody22 = Utils.requireBody(response32);
                        return new SourceResult(r0.toImageSource(responseBodyRequireBody22), r0.getMimeType$coil_base_release(r0.url, responseBodyRequireBody22.getMediaType()), r0.toDataSource(response32));
                    }
                    return coroutine_suspended;
                } catch (Exception e4) {
                    response2 = response;
                    e = e4;
                    Utils.closeQuietly(response2);
                    throw e;
                }
            } catch (Exception e5) {
                e = e5;
                if (r4 != 0) {
                }
                throw e;
            }
        } catch (Exception e6) {
            e = e6;
            r4 = r22;
        }
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        DiskCache value;
        if (!this.options.getDiskCachePolicy().getReadEnabled() || (value = this.diskCache.getValue()) == null) {
            return null;
        }
        return value.openSnapshot(getDiskCacheKey());
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00c1 A[Catch: all -> 0x010c, Exception -> 0x010e, TRY_LEAVE, TryCatch #3 {Exception -> 0x010e, blocks: (B:15:0x002d, B:18:0x0038, B:66:0x0100, B:34:0x0089, B:31:0x0082, B:35:0x008a, B:51:0x00c1, B:69:0x010a, B:64:0x00fb, B:70:0x010b, B:48:0x00bb), top: B:84:0x002d, outer: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010b A[Catch: all -> 0x010c, Exception -> 0x010e, TRY_LEAVE, TryCatch #3 {Exception -> 0x010e, blocks: (B:15:0x002d, B:18:0x0038, B:66:0x0100, B:34:0x0089, B:31:0x0082, B:35:0x008a, B:51:0x00c1, B:69:0x010a, B:64:0x00fb, B:70:0x010b, B:48:0x00bb), top: B:84:0x002d, outer: #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final DiskCache.Snapshot writeToDiskCache(DiskCache.Snapshot snapshot, Request request, Response response, CacheResponse cacheResponse) {
        DiskCache.Editor editorOpenEditor;
        Throwable th;
        Throwable th2 = null;
        if (!isCacheable(request, response)) {
            if (snapshot != null) {
                Utils.closeQuietly(snapshot);
            }
            return null;
        }
        if (snapshot != null) {
            editorOpenEditor = snapshot.closeAndOpenEditor();
        } else {
            DiskCache value = this.diskCache.getValue();
            editorOpenEditor = value != null ? value.openEditor(getDiskCacheKey()) : null;
        }
        try {
            if (editorOpenEditor == null) {
                return null;
            }
            try {
                if (response.code() == 304 && cacheResponse != null) {
                    Response responseBuild = response.newBuilder().headers(CacheStrategy.INSTANCE.combineHeaders(cacheResponse.getResponseHeaders(), response.headers())).build();
                    BufferedSink bufferedSinkBuffer = Okio.buffer(getFileSystem().sink(editorOpenEditor.getMetadata(), false));
                    try {
                        new CacheResponse(responseBuild).writeTo(bufferedSinkBuffer);
                        Unit unit = Unit.INSTANCE;
                        if (bufferedSinkBuffer != null) {
                            try {
                                bufferedSinkBuffer.close();
                            } catch (Throwable th3) {
                                th2 = th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (bufferedSinkBuffer != null) {
                            try {
                                bufferedSinkBuffer.close();
                            } catch (Throwable th5) {
                                ExceptionsKt.addSuppressed(th2, th5);
                            }
                        }
                    }
                    if (th2 != null) {
                        throw th2;
                    }
                } else {
                    BufferedSink bufferedSinkBuffer2 = Okio.buffer(getFileSystem().sink(editorOpenEditor.getMetadata(), false));
                    try {
                        new CacheResponse(response).writeTo(bufferedSinkBuffer2);
                        Unit unit2 = Unit.INSTANCE;
                    } catch (Throwable th6) {
                        if (bufferedSinkBuffer2 != null) {
                            try {
                                bufferedSinkBuffer2.close();
                            } catch (Throwable th7) {
                                ExceptionsKt.addSuppressed(th6, th7);
                            }
                        }
                        th = th6;
                    }
                    if (bufferedSinkBuffer2 != null) {
                        try {
                            bufferedSinkBuffer2.close();
                            th = null;
                        } catch (Throwable th8) {
                            th = th8;
                        }
                        if (th == null) {
                            throw th;
                        }
                        BufferedSink bufferedSinkBuffer3 = Okio.buffer(getFileSystem().sink(editorOpenEditor.getData(), false));
                        try {
                            ResponseBody responseBodyBody = response.body();
                            Intrinsics.checkNotNull(responseBodyBody);
                            Long.valueOf(responseBodyBody.getSource().readAll(bufferedSinkBuffer3));
                            if (bufferedSinkBuffer3 != null) {
                                try {
                                    bufferedSinkBuffer3.close();
                                } catch (Throwable th9) {
                                    th2 = th9;
                                }
                            }
                        } catch (Throwable th10) {
                            th2 = th10;
                            if (bufferedSinkBuffer3 != null) {
                                try {
                                    bufferedSinkBuffer3.close();
                                } catch (Throwable th11) {
                                    ExceptionsKt.addSuppressed(th2, th11);
                                }
                            }
                        }
                        if (th2 != null) {
                            throw th2;
                        }
                    } else {
                        th = null;
                        if (th == null) {
                        }
                    }
                }
                return editorOpenEditor.commitAndOpenSnapshot();
            } catch (Exception e) {
                Utils.abortQuietly(editorOpenEditor);
                throw e;
            }
        } finally {
            Utils.closeQuietly(response);
        }
    }

    private final Request newRequest() {
        Request.Builder builderHeaders = new Request.Builder().url(this.url).headers(this.options.getHeaders());
        for (Map.Entry<Class<?>, Object> entry : this.options.getTags().asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            builderHeaders.tag((Class<? super Object>) key, entry.getValue());
        }
        boolean readEnabled = this.options.getDiskCachePolicy().getReadEnabled();
        boolean readEnabled2 = this.options.getNetworkCachePolicy().getReadEnabled();
        if (!readEnabled2 && readEnabled) {
            builderHeaders.cacheControl(CacheControl.FORCE_CACHE);
        } else if (!readEnabled2 || readEnabled) {
            if (!readEnabled2 && !readEnabled) {
                builderHeaders.cacheControl(CACHE_CONTROL_NO_NETWORK_NO_CACHE);
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            builderHeaders.cacheControl(CacheControl.FORCE_NETWORK);
        } else {
            builderHeaders.cacheControl(CACHE_CONTROL_FORCE_NETWORK_NO_CACHE);
        }
        return builderHeaders.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeNetworkRequest(Request request, Continuation<? super Response> continuation) throws IOException {
        C38271 c38271;
        Response responseExecute;
        if (continuation instanceof C38271) {
            c38271 = (C38271) continuation;
            if ((c38271.label & Integer.MIN_VALUE) != 0) {
                c38271.label -= Integer.MIN_VALUE;
            } else {
                c38271 = new C38271(continuation);
            }
        }
        Object objAwait = c38271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c38271.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            if (Utils.isMainThread()) {
                if (this.options.getNetworkCachePolicy().getReadEnabled()) {
                    throw new NetworkOnMainThreadException();
                }
                responseExecute = this.callFactory.getValue().newCall(request).execute();
                if (!responseExecute.getIsSuccessful() || responseExecute.code() == 304) {
                    return responseExecute;
                }
                ResponseBody responseBodyBody = responseExecute.body();
                if (responseBodyBody != null) {
                    Utils.closeQuietly(responseBodyBody);
                }
                throw new HttpException(responseExecute);
            }
            Call callNewCall = this.callFactory.getValue().newCall(request);
            c38271.label = 1;
            objAwait = Calls.await(callNewCall, c38271);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwait);
        }
        responseExecute = (Response) objAwait;
        if (responseExecute.getIsSuccessful()) {
        }
        return responseExecute;
    }

    public final String getMimeType$coil_base_release(String url, MediaType contentType) {
        String mimeTypeFromUrl;
        String string = contentType != null ? contentType.toString() : null;
        if ((string == null || StringsKt.startsWith$default(string, "text/plain", false, 2, (Object) null)) && (mimeTypeFromUrl = Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), url)) != null) {
            return mimeTypeFromUrl;
        }
        if (string != null) {
            return StringsKt.substringBefore$default(string, SearchMatchParser.DELIMETER, (String) null, 2, (Object) null);
        }
        return null;
    }

    private final boolean isCacheable(Request request, Response response) {
        if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            return !this.respectCacheHeaders || CacheStrategy.INSTANCE.isCacheable(request, response);
        }
        return false;
    }

    private final CacheResponse toCacheResponse(DiskCache.Snapshot snapshot) throws Throwable {
        CacheResponse cacheResponse;
        Throwable th;
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(getFileSystem().source(snapshot.getMetadata()));
            try {
                cacheResponse = new CacheResponse(bufferedSourceBuffer);
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    th = null;
                }
            } catch (Throwable th3) {
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th3, th4);
                    }
                }
                cacheResponse = null;
                th = th3;
            }
            if (th == null) {
                return cacheResponse;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    private final ImageSource toImageSource(DiskCache.Snapshot snapshot) {
        return ImageSources.create(snapshot.getData(), getFileSystem(), getDiskCacheKey(), snapshot);
    }

    private final ImageSource toImageSource(ResponseBody responseBody) {
        return ImageSources.create(responseBody.getSource(), this.options.getContext());
    }

    private final DataSource toDataSource(Response response) {
        return response.networkResponse() != null ? DataSource.NETWORK : DataSource.DISK;
    }

    private final String getDiskCacheKey() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    private final FileSystem getFileSystem() {
        DiskCache value = this.diskCache.getValue();
        Intrinsics.checkNotNull(value);
        return value.getFileSystem();
    }

    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcoil/fetch/HttpUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "<init>", "(Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "coil-base_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Lazy<Call.Factory> callFactory;
        private final Lazy<DiskCache> diskCache;
        private final boolean respectCacheHeaders;

        /* JADX WARN: Multi-variable type inference failed */
        public Factory(Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean z) {
            this.callFactory = lazy;
            this.diskCache = lazy2;
            this.respectCacheHeaders = z;
        }

        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(Uri data, Options options, ImageLoader imageLoader) {
            if (isApplicable(data)) {
                return new HttpUriFetcher(data.toString(), options, this.callFactory, this.diskCache, this.respectCacheHeaders);
            }
            return null;
        }

        private final boolean isApplicable(Uri data) {
            return Intrinsics.areEqual(data.getScheme(), "http") || Intrinsics.areEqual(data.getScheme(), ProxyConfig.MATCH_HTTPS);
        }
    }
}

package coil.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.media3.extractor.p007ts.TsExtractor;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.decode.FileImageSource;
import coil.decode.ImageSource;
import coil.fetch.DrawableResult;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.intercept.Interceptor;
import coil.memory.MemoryCache;
import coil.memory.MemoryCacheService;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Scale;
import coil.size.Size;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.DrawableUtils;
import coil.util.Logger;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: EngineInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 42\u00020\u0001:\u000234B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ6\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010#J>\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010'J0\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0081@¢\u0006\u0004\b*\u0010+J&\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u0010\"\u001a\u00020\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, m1599d2 = {"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/Interceptor;", "imageLoader", "Lcoil/ImageLoader;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "requestService", "Lcoil/request/RequestService;", "logger", "Lcoil/util/Logger;", "<init>", "(Lcoil/ImageLoader;Lcoil/util/SystemCallbacks;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "intercept", "Lcoil/request/ImageResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "(Lcoil/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "request", "Lcoil/request/ImageRequest;", "mappedData", "", "_options", "Lcoil/request/Options;", "eventListener", "Lcoil/EventListener;", "(Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", RemoteConfigComponent.FETCH_FILE_NAME, "Lcoil/fetch/FetchResult;", "components", "Lcoil/ComponentRegistry;", "options", "(Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decode", "fetchResult", "Lcoil/fetch/SourceResult;", "(Lcoil/fetch/SourceResult;Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transform", "result", "transform$coil_base_release", "(Lcoil/intercept/EngineInterceptor$ExecuteResult;Lcoil/request/ImageRequest;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertDrawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "transformations", "", "Lcoil/transform/Transformation;", "ExecuteResult", "Companion", "coil-base_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class EngineInterceptor implements Interceptor {
    private static final String TAG = "EngineInterceptor";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final MemoryCacheService memoryCacheService;
    private final RequestService requestService;
    private final SystemCallbacks systemCallbacks;

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$decode$1 */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.intercept.EngineInterceptor", m1609f = "EngineInterceptor.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {203}, m1612m = "decode", m1613n = {"this", "fetchResult", "components", "request", "mappedData", "options", "eventListener", "decoder", "searchIndex"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"})
    static final class C38301 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C38301(Continuation<? super C38301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.decode(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$execute$1 */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.intercept.EngineInterceptor", m1609f = "EngineInterceptor.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m1611l = {WebSocketProtocol.PAYLOAD_SHORT, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 148}, m1612m = "execute", m1613n = {"this", "request", "mappedData", "eventListener", "options", "components", "fetchResult", "this", "request", "eventListener", "options", "fetchResult"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C38311 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C38311(Continuation<? super C38311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.execute(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$fetch$1 */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.intercept.EngineInterceptor", m1609f = "EngineInterceptor.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {169}, m1612m = RemoteConfigComponent.FETCH_FILE_NAME, m1613n = {"this", "components", "request", "mappedData", "options", "eventListener", "fetcher", "searchIndex"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
    static final class C38321 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C38321(Continuation<? super C38321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.fetch(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$intercept$1 */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.intercept.EngineInterceptor", m1609f = "EngineInterceptor.kt", m1610i = {0, 0}, m1611l = {75}, m1612m = "intercept", m1613n = {"this", "chain"}, m1615s = {"L$0", "L$1"})
    static final class C38331 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C38331(Continuation<? super C38331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.intercept(null, this);
        }
    }

    public EngineInterceptor(ImageLoader imageLoader, SystemCallbacks systemCallbacks, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.systemCallbacks = systemCallbacks;
        this.requestService = requestService;
        this.logger = logger;
        this.memoryCacheService = new MemoryCacheService(imageLoader, requestService, logger);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // coil.intercept.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object intercept(Interceptor.Chain chain, Continuation<? super ImageResult> continuation) throws Throwable {
        C38331 c38331;
        Throwable th;
        EngineInterceptor engineInterceptor;
        MemoryCache.Value cacheValue;
        if (continuation instanceof C38331) {
            c38331 = (C38331) continuation;
            if ((c38331.label & Integer.MIN_VALUE) != 0) {
                c38331.label -= Integer.MIN_VALUE;
            } else {
                c38331 = new C38331(continuation);
            }
        }
        Object obj = c38331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c38331.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                ImageRequest request = chain.getRequest();
                Object data = request.getData();
                Size size = chain.getSize();
                EventListener eventListener = Utils.getEventListener(chain);
                Options options = this.requestService.options(request, size);
                Scale scale = options.getScale();
                eventListener.mapStart(request, data);
                Object map = this.imageLoader.getComponents().map(data, options);
                eventListener.mapEnd(request, map);
                MemoryCache.Key keyNewCacheKey = this.memoryCacheService.newCacheKey(request, map, options, eventListener);
                if (keyNewCacheKey != null) {
                    try {
                        cacheValue = this.memoryCacheService.getCacheValue(request, keyNewCacheKey, size, scale);
                    } catch (Throwable th2) {
                        th = th2;
                        engineInterceptor = this;
                    }
                } else {
                    cacheValue = null;
                }
                if (cacheValue != null) {
                    return this.memoryCacheService.newResult(chain, request, keyNewCacheKey, cacheValue);
                }
                CoroutineDispatcher fetcherDispatcher = request.getFetcherDispatcher();
                try {
                    C38342 c38342 = new C38342(request, map, options, eventListener, keyNewCacheKey, chain, null);
                    c38331.L$0 = this;
                    c38331.L$1 = chain;
                    c38331.label = 1;
                    Object objWithContext = BuildersKt.withContext(fetcherDispatcher, c38342, c38331);
                    return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
                } catch (Throwable th3) {
                    th = th3;
                    engineInterceptor = this;
                    chain = chain;
                }
            } catch (Throwable th4) {
                th = th4;
                engineInterceptor = this;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            chain = (Interceptor.Chain) c38331.L$1;
            engineInterceptor = (EngineInterceptor) c38331.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                return obj;
            } catch (Throwable th5) {
                th = th5;
            }
        }
        if (th instanceof CancellationException) {
            throw th;
        }
        return engineInterceptor.requestService.errorResult(chain.getRequest(), th);
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$intercept$2 */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcoil/request/SuccessResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.intercept.EngineInterceptor$intercept$2", m1609f = "EngineInterceptor.kt", m1610i = {}, m1611l = {77}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C38342 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SuccessResult>, Object> {
        final /* synthetic */ MemoryCache.Key $cacheKey;
        final /* synthetic */ Interceptor.Chain $chain;
        final /* synthetic */ EventListener $eventListener;
        final /* synthetic */ Object $mappedData;
        final /* synthetic */ Options $options;
        final /* synthetic */ ImageRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C38342(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, MemoryCache.Key key, Interceptor.Chain chain, Continuation<? super C38342> continuation) {
            super(2, continuation);
            this.$request = imageRequest;
            this.$mappedData = obj;
            this.$options = options;
            this.$eventListener = eventListener;
            this.$cacheKey = key;
            this.$chain = chain;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EngineInterceptor.this.new C38342(this.$request, this.$mappedData, this.$options, this.$eventListener, this.$cacheKey, this.$chain, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SuccessResult> continuation) {
            return ((C38342) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = EngineInterceptor.this.execute(this.$request, this.$mappedData, this.$options, this.$eventListener, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ExecuteResult executeResult = (ExecuteResult) obj;
            EngineInterceptor.this.systemCallbacks.registerMemoryPressureCallbacks();
            boolean cacheValue = EngineInterceptor.this.memoryCacheService.setCacheValue(this.$cacheKey, this.$request, executeResult);
            Drawable drawable = executeResult.getDrawable();
            ImageRequest imageRequest = this.$request;
            DataSource dataSource = executeResult.getDataSource();
            MemoryCache.Key key = this.$cacheKey;
            if (!cacheValue) {
                key = null;
            }
            return new SuccessResult(drawable, imageRequest, dataSource, key, executeResult.getDiskCacheKey(), executeResult.getIsSampled(), Utils.isPlaceholderCached(this.$chain));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01d2, code lost:
    
        if (r0 == r9) goto L70;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0201  */
    /* JADX WARN: Type inference failed for: r2v11, types: [T, coil.request.Options] */
    /* JADX WARN: Type inference failed for: r2v16, types: [T, coil.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, coil.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) throws Throwable {
        C38311 c38311;
        SourceResult sourceResult;
        ImageSource source;
        EngineInterceptor engineInterceptor;
        ImageRequest imageRequest2;
        Object obj2;
        EventListener eventListener2;
        Ref.ObjectRef objectRef;
        T t;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        ImageRequest imageRequest3;
        Ref.ObjectRef objectRef6;
        EventListener eventListener3;
        ExecuteResult executeResult;
        EngineInterceptor engineInterceptor2;
        SourceResult sourceResult2;
        ImageSource source2;
        Object obj3;
        Object obj4;
        Bitmap bitmap;
        if (continuation instanceof C38311) {
            c38311 = (C38311) continuation;
            if ((c38311.label & Integer.MIN_VALUE) != 0) {
                c38311.label -= Integer.MIN_VALUE;
            } else {
                c38311 = new C38311(continuation);
            }
        }
        C38311 c383112 = c38311;
        Object obj5 = c383112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Ref.ObjectRef objectRef7 = c383112.label;
        try {
            if (objectRef7 == 0) {
                ResultKt.throwOnFailure(obj5);
                Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
                objectRef8.element = options;
                Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
                objectRef9.element = this.imageLoader.getComponents();
                Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
                try {
                    objectRef8.element = this.requestService.updateOptionsOnWorkerThread((Options) objectRef8.element);
                    if (imageRequest.getFetcherFactory() != null || imageRequest.getDecoderFactory() != null) {
                        ComponentRegistry.Builder builderNewBuilder = ((ComponentRegistry) objectRef9.element).newBuilder();
                        Pair<Fetcher.Factory<?>, Class<?>> fetcherFactory = imageRequest.getFetcherFactory();
                        if (fetcherFactory != null) {
                            builderNewBuilder.getFetcherFactories$coil_base_release().add(0, fetcherFactory);
                        }
                        Decoder.Factory decoderFactory = imageRequest.getDecoderFactory();
                        if (decoderFactory != null) {
                            builderNewBuilder.getDecoderFactories$coil_base_release().add(0, decoderFactory);
                        }
                        objectRef9.element = builderNewBuilder.build();
                    }
                    ComponentRegistry componentRegistry = (ComponentRegistry) objectRef9.element;
                    Options options2 = (Options) objectRef8.element;
                    c383112.L$0 = this;
                    c383112.L$1 = imageRequest;
                    c383112.L$2 = obj;
                    c383112.L$3 = eventListener;
                    c383112.L$4 = objectRef8;
                    c383112.L$5 = objectRef9;
                    c383112.L$6 = objectRef10;
                    c383112.L$7 = objectRef10;
                    c383112.label = 1;
                    Object objFetch = fetch(componentRegistry, imageRequest, obj, options2, eventListener, c383112);
                    if (objFetch != coroutine_suspended) {
                        engineInterceptor = this;
                        imageRequest2 = imageRequest;
                        obj2 = obj;
                        eventListener2 = eventListener;
                        objectRef = objectRef8;
                        t = objFetch;
                        objectRef2 = objectRef9;
                        objectRef3 = objectRef10;
                        objectRef4 = objectRef3;
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    th = th;
                    objectRef7 = objectRef10;
                    T t2 = objectRef7.element;
                    sourceResult = t2 instanceof SourceResult ? (SourceResult) t2 : null;
                    if (sourceResult != null && (source = sourceResult.getSource()) != null) {
                        Utils.closeQuietly(source);
                    }
                    throw th;
                }
            }
            if (objectRef7 == 1) {
                objectRef3 = (Ref.ObjectRef) c383112.L$7;
                objectRef4 = (Ref.ObjectRef) c383112.L$6;
                Ref.ObjectRef objectRef11 = (Ref.ObjectRef) c383112.L$5;
                Ref.ObjectRef objectRef12 = (Ref.ObjectRef) c383112.L$4;
                EventListener eventListener4 = (EventListener) c383112.L$3;
                Object obj6 = c383112.L$2;
                ImageRequest imageRequest4 = (ImageRequest) c383112.L$1;
                EngineInterceptor engineInterceptor3 = (EngineInterceptor) c383112.L$0;
                try {
                    ResultKt.throwOnFailure(obj5);
                    objectRef2 = objectRef11;
                    objectRef = objectRef12;
                    eventListener2 = eventListener4;
                    obj2 = obj6;
                    imageRequest2 = imageRequest4;
                    engineInterceptor = engineInterceptor3;
                    t = obj5;
                } catch (Throwable th2) {
                    th = th2;
                    objectRef7 = objectRef4;
                    T t22 = objectRef7.element;
                    if (t22 instanceof SourceResult) {
                    }
                    if (sourceResult != null) {
                        Utils.closeQuietly(source);
                    }
                    throw th;
                }
            } else {
                if (objectRef7 != 2) {
                    if (objectRef7 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj5);
                    obj4 = obj5;
                    ExecuteResult executeResult2 = (ExecuteResult) obj4;
                    Drawable drawable = executeResult2.getDrawable();
                    BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
                    if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                        bitmap.prepareToDraw();
                    }
                    return executeResult2;
                }
                objectRef5 = (Ref.ObjectRef) c383112.L$4;
                objectRef6 = (Ref.ObjectRef) c383112.L$3;
                eventListener3 = (EventListener) c383112.L$2;
                imageRequest3 = (ImageRequest) c383112.L$1;
                engineInterceptor2 = (EngineInterceptor) c383112.L$0;
                ResultKt.throwOnFailure(obj5);
                obj3 = obj5;
                executeResult = (ExecuteResult) obj3;
                engineInterceptor = engineInterceptor2;
                EventListener eventListener5 = eventListener3;
                ExecuteResult executeResult3 = executeResult;
                Ref.ObjectRef objectRef13 = objectRef6;
                T t3 = objectRef5.element;
                sourceResult2 = t3 instanceof SourceResult ? (SourceResult) t3 : null;
                if (sourceResult2 != null && (source2 = sourceResult2.getSource()) != null) {
                    Utils.closeQuietly(source2);
                }
                Options options3 = (Options) objectRef13.element;
                c383112.L$0 = null;
                c383112.L$1 = null;
                c383112.L$2 = null;
                c383112.L$3 = null;
                c383112.L$4 = null;
                c383112.L$5 = null;
                c383112.L$6 = null;
                c383112.L$7 = null;
                c383112.label = 3;
                Object objTransform$coil_base_release = engineInterceptor.transform$coil_base_release(executeResult3, imageRequest3, options3, eventListener5, c383112);
                obj4 = objTransform$coil_base_release;
            }
            objectRef3.element = t;
            FetchResult fetchResult = (FetchResult) objectRef4.element;
            if (!(fetchResult instanceof SourceResult)) {
                objectRef5 = objectRef4;
                imageRequest3 = imageRequest2;
                objectRef6 = objectRef;
                eventListener3 = eventListener2;
                if (!(fetchResult instanceof DrawableResult)) {
                    throw new NoWhenBranchMatchedException();
                }
                executeResult = new ExecuteResult(((DrawableResult) objectRef5.element).getDrawable(), ((DrawableResult) objectRef5.element).getIsSampled(), ((DrawableResult) objectRef5.element).getDataSource(), null);
                EventListener eventListener52 = eventListener3;
                ExecuteResult executeResult32 = executeResult;
                Ref.ObjectRef objectRef132 = objectRef6;
                T t32 = objectRef5.element;
                if (t32 instanceof SourceResult) {
                }
                if (sourceResult2 != null) {
                }
                Options options32 = (Options) objectRef132.element;
                c383112.L$0 = null;
                c383112.L$1 = null;
                c383112.L$2 = null;
                c383112.L$3 = null;
                c383112.L$4 = null;
                c383112.L$5 = null;
                c383112.L$6 = null;
                c383112.L$7 = null;
                c383112.label = 3;
                Object objTransform$coil_base_release2 = engineInterceptor.transform$coil_base_release(executeResult32, imageRequest3, options32, eventListener52, c383112);
                obj4 = objTransform$coil_base_release2;
            } else {
                CoroutineDispatcher decoderDispatcher = imageRequest2.getDecoderDispatcher();
                Ref.ObjectRef objectRef14 = objectRef4;
                try {
                    objectRef5 = objectRef14;
                    imageRequest3 = imageRequest2;
                    objectRef6 = objectRef;
                    eventListener3 = eventListener2;
                    EngineInterceptor$execute$executeResult$1 engineInterceptor$execute$executeResult$1 = new EngineInterceptor$execute$executeResult$1(engineInterceptor, objectRef14, objectRef2, imageRequest2, obj2, objectRef, eventListener2, null);
                    c383112.L$0 = engineInterceptor;
                    c383112.L$1 = imageRequest3;
                    c383112.L$2 = eventListener3;
                    c383112.L$3 = objectRef6;
                    c383112.L$4 = objectRef5;
                    c383112.L$5 = null;
                    c383112.L$6 = null;
                    c383112.L$7 = null;
                    c383112.label = 2;
                    Object objWithContext = BuildersKt.withContext(decoderDispatcher, engineInterceptor$execute$executeResult$1, c383112);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    engineInterceptor2 = engineInterceptor;
                    obj3 = objWithContext;
                    executeResult = (ExecuteResult) obj3;
                    engineInterceptor = engineInterceptor2;
                    EventListener eventListener522 = eventListener3;
                    ExecuteResult executeResult322 = executeResult;
                    Ref.ObjectRef objectRef1322 = objectRef6;
                    T t322 = objectRef5.element;
                    if (t322 instanceof SourceResult) {
                    }
                    if (sourceResult2 != null) {
                        Utils.closeQuietly(source2);
                    }
                    Options options322 = (Options) objectRef1322.element;
                    c383112.L$0 = null;
                    c383112.L$1 = null;
                    c383112.L$2 = null;
                    c383112.L$3 = null;
                    c383112.L$4 = null;
                    c383112.L$5 = null;
                    c383112.L$6 = null;
                    c383112.L$7 = null;
                    c383112.label = 3;
                    Object objTransform$coil_base_release22 = engineInterceptor.transform$coil_base_release(executeResult322, imageRequest3, options322, eventListener522, c383112);
                    obj4 = objTransform$coil_base_release22;
                } catch (Throwable th3) {
                    th = th3;
                    objectRef7 = objectRef14;
                    T t222 = objectRef7.element;
                    if (t222 instanceof SourceResult) {
                    }
                    if (sourceResult != null) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0092 -> B:21:0x0096). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetch(ComponentRegistry componentRegistry, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super FetchResult> continuation) {
        C38321 c38321;
        int i;
        EngineInterceptor engineInterceptor;
        Pair<Fetcher, Integer> pairNewFetcher;
        ImageSource source;
        if (continuation instanceof C38321) {
            c38321 = (C38321) continuation;
            if ((c38321.label & Integer.MIN_VALUE) != 0) {
                c38321.label -= Integer.MIN_VALUE;
            } else {
                c38321 = new C38321(continuation);
            }
        }
        Object obj2 = c38321.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c38321.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            i = 0;
            engineInterceptor = this;
            pairNewFetcher = componentRegistry.newFetcher(obj, options, engineInterceptor.imageLoader, i);
            if (pairNewFetcher != null) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c38321.I$0;
            Fetcher fetcher = (Fetcher) c38321.L$6;
            EventListener eventListener2 = (EventListener) c38321.L$5;
            options = (Options) c38321.L$4;
            Object obj3 = c38321.L$3;
            ImageRequest imageRequest2 = (ImageRequest) c38321.L$2;
            ComponentRegistry componentRegistry2 = (ComponentRegistry) c38321.L$1;
            engineInterceptor = (EngineInterceptor) c38321.L$0;
            ResultKt.throwOnFailure(obj2);
            C38321 c383212 = c38321;
            int i4 = i3;
            componentRegistry = componentRegistry2;
            C38321 c383213 = c383212;
            Fetcher first = fetcher;
            imageRequest = imageRequest2;
            eventListener = eventListener2;
            obj = obj3;
            FetchResult fetchResult = (FetchResult) obj2;
            try {
                eventListener.fetchEnd(imageRequest, first, options, fetchResult);
                if (fetchResult == null) {
                    return fetchResult;
                }
                i = i4;
                c38321 = c383213;
                pairNewFetcher = componentRegistry.newFetcher(obj, options, engineInterceptor.imageLoader, i);
                if (pairNewFetcher != null) {
                    throw new IllegalStateException(("Unable to create a fetcher that supports: " + obj).toString());
                }
                first = pairNewFetcher.getFirst();
                int iIntValue = pairNewFetcher.getSecond().intValue() + 1;
                eventListener.fetchStart(imageRequest, first, options);
                c38321.L$0 = engineInterceptor;
                c38321.L$1 = componentRegistry;
                c38321.L$2 = imageRequest;
                c38321.L$3 = obj;
                c38321.L$4 = options;
                c38321.L$5 = eventListener;
                c38321.L$6 = first;
                c38321.I$0 = iIntValue;
                c38321.label = 1;
                Object objFetch = first.fetch(c38321);
                if (objFetch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                C38321 c383214 = c38321;
                i4 = iIntValue;
                obj2 = objFetch;
                c383213 = c383214;
                FetchResult fetchResult2 = (FetchResult) obj2;
                eventListener.fetchEnd(imageRequest, first, options, fetchResult2);
                if (fetchResult2 == null) {
                }
            } catch (Throwable th) {
                SourceResult sourceResult = fetchResult2 instanceof SourceResult ? (SourceResult) fetchResult2 : null;
                if (sourceResult != null && (source = sourceResult.getSource()) != null) {
                    Utils.closeQuietly(source);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0098 -> B:21:0x009f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object decode(SourceResult sourceResult, ComponentRegistry componentRegistry, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        C38301 c38301;
        int i;
        EngineInterceptor engineInterceptor;
        Pair<Decoder, Integer> pairNewDecoder;
        if (continuation instanceof C38301) {
            c38301 = (C38301) continuation;
            if ((c38301.label & Integer.MIN_VALUE) != 0) {
                c38301.label -= Integer.MIN_VALUE;
            } else {
                c38301 = new C38301(continuation);
            }
        }
        Object obj2 = c38301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c38301.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            i = 0;
            engineInterceptor = this;
            pairNewDecoder = componentRegistry.newDecoder(sourceResult, options, engineInterceptor.imageLoader, i);
            if (pairNewDecoder != null) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c38301.I$0;
            Decoder decoder = (Decoder) c38301.L$7;
            EventListener eventListener2 = (EventListener) c38301.L$6;
            Options options2 = (Options) c38301.L$5;
            Object obj3 = c38301.L$4;
            ImageRequest imageRequest2 = (ImageRequest) c38301.L$3;
            ComponentRegistry componentRegistry2 = (ComponentRegistry) c38301.L$2;
            SourceResult sourceResult2 = (SourceResult) c38301.L$1;
            engineInterceptor = (EngineInterceptor) c38301.L$0;
            ResultKt.throwOnFailure(obj2);
            C38301 c383012 = c38301;
            int i4 = i3;
            sourceResult = sourceResult2;
            C38301 c383013 = c383012;
            eventListener = eventListener2;
            imageRequest = imageRequest2;
            options = options2;
            obj = obj3;
            DecodeResult decodeResult = (DecodeResult) obj2;
            eventListener.decodeEnd(imageRequest, decoder, options, decodeResult);
            if (decodeResult != null) {
                i = i4;
                componentRegistry = componentRegistry2;
                c38301 = c383013;
                pairNewDecoder = componentRegistry.newDecoder(sourceResult, options, engineInterceptor.imageLoader, i);
                if (pairNewDecoder != null) {
                    throw new IllegalStateException(("Unable to create a decoder that supports: " + obj).toString());
                }
                Decoder first = pairNewDecoder.getFirst();
                int iIntValue = pairNewDecoder.getSecond().intValue() + 1;
                eventListener.decodeStart(imageRequest, first, options);
                c38301.L$0 = engineInterceptor;
                c38301.L$1 = sourceResult;
                c38301.L$2 = componentRegistry;
                c38301.L$3 = imageRequest;
                c38301.L$4 = obj;
                c38301.L$5 = options;
                c38301.L$6 = eventListener;
                c38301.L$7 = first;
                c38301.I$0 = iIntValue;
                c38301.label = 1;
                Object objDecode = first.decode(c38301);
                if (objDecode == coroutine_suspended) {
                    return coroutine_suspended;
                }
                componentRegistry2 = componentRegistry;
                decoder = first;
                C38301 c383014 = c38301;
                i4 = iIntValue;
                obj2 = objDecode;
                c383013 = c383014;
                DecodeResult decodeResult2 = (DecodeResult) obj2;
                eventListener.decodeEnd(imageRequest, decoder, options, decodeResult2);
                if (decodeResult2 != null) {
                }
            } else {
                Drawable drawable = decodeResult2.getDrawable();
                boolean isSampled = decodeResult2.getIsSampled();
                DataSource dataSource = sourceResult.getDataSource();
                ImageSource source = sourceResult.getSource();
                FileImageSource fileImageSource = source instanceof FileImageSource ? (FileImageSource) source : null;
                return new ExecuteResult(drawable, isSampled, dataSource, fileImageSource != null ? fileImageSource.getDiskCacheKey() : null);
            }
        }
    }

    public final Object transform$coil_base_release(ExecuteResult executeResult, ImageRequest imageRequest, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        List<Transformation> transformations = imageRequest.getTransformations();
        if (!transformations.isEmpty()) {
            if (!(executeResult.getDrawable() instanceof BitmapDrawable) && !imageRequest.getAllowConversionToBitmap()) {
                Logger logger = this.logger;
                if (logger != null && logger.getLevel() <= 4) {
                    logger.log(TAG, 4, "allowConversionToBitmap=false, skipping transformations for type " + executeResult.getDrawable().getClass().getCanonicalName() + '.', null);
                }
            } else {
                return BuildersKt.withContext(imageRequest.getTransformationDispatcher(), new EngineInterceptor$transform$3(this, executeResult, options, transformations, eventListener, imageRequest, null), continuation);
            }
        }
        return executeResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap convertDrawableToBitmap(Drawable drawable, Options options, List<? extends Transformation> transformations) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config safeConfig = Bitmaps.getSafeConfig(bitmap);
            if (ArraysKt.contains(Utils.getVALID_TRANSFORMATION_CONFIGS(), safeConfig)) {
                return bitmap;
            }
            Logger logger = this.logger;
            if (logger != null && logger.getLevel() <= 4) {
                logger.log(TAG, 4, "Converting bitmap with config " + safeConfig + " to apply transformations: " + transformations + '.', null);
            }
        } else {
            Logger logger2 = this.logger;
            if (logger2 != null && logger2.getLevel() <= 4) {
                logger2.log(TAG, 4, "Converting drawable of type " + drawable.getClass().getCanonicalName() + " to apply transformations: " + transformations + '.', null);
            }
        }
        return DrawableUtils.INSTANCE.convertToBitmap(drawable, options.getConfig(), options.getSize(), options.getScale(), options.getAllowInexactSize());
    }

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ0\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, m1599d2 = {"Lcoil/intercept/EngineInterceptor$ExecuteResult;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "isSampled", "", "dataSource", "Lcoil/decode/DataSource;", "diskCacheKey", "", "<init>", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;Ljava/lang/String;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "getDataSource", "()Lcoil/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "copy", "coil-base_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class ExecuteResult {
        private final DataSource dataSource;
        private final String diskCacheKey;
        private final Drawable drawable;
        private final boolean isSampled;

        public ExecuteResult(Drawable drawable, boolean z, DataSource dataSource, String str) {
            this.drawable = drawable;
            this.isSampled = z;
            this.dataSource = dataSource;
            this.diskCacheKey = str;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* JADX INFO: renamed from: isSampled, reason: from getter */
        public final boolean getIsSampled() {
            return this.isSampled;
        }

        public final DataSource getDataSource() {
            return this.dataSource;
        }

        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }

        public static /* synthetic */ ExecuteResult copy$default(ExecuteResult executeResult, Drawable drawable, boolean z, DataSource dataSource, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                drawable = executeResult.drawable;
            }
            if ((i & 2) != 0) {
                z = executeResult.isSampled;
            }
            if ((i & 4) != 0) {
                dataSource = executeResult.dataSource;
            }
            if ((i & 8) != 0) {
                str = executeResult.diskCacheKey;
            }
            return executeResult.copy(drawable, z, dataSource, str);
        }

        public final ExecuteResult copy(Drawable drawable, boolean isSampled, DataSource dataSource, String diskCacheKey) {
            return new ExecuteResult(drawable, isSampled, dataSource, diskCacheKey);
        }
    }
}

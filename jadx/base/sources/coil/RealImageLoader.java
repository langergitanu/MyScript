package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.Lifecycle;
import androidx.media3.extractor.p007ts.TsExtractor;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.BitmapFactoryDecoder;
import coil.decode.DataSource;
import coil.disk.DiskCache;
import coil.fetch.AssetUriFetcher;
import coil.fetch.BitmapFetcher;
import coil.fetch.ByteBufferFetcher;
import coil.fetch.ContentUriFetcher;
import coil.fetch.DrawableFetcher;
import coil.fetch.FileFetcher;
import coil.fetch.HttpUriFetcher;
import coil.fetch.ResourceUriFetcher;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.key.FileKeyer;
import coil.key.UriKeyer;
import coil.map.ByteArrayMapper;
import coil.map.FileUriMapper;
import coil.map.HttpUrlMapper;
import coil.map.ResourceIntMapper;
import coil.map.ResourceUriMapper;
import coil.map.StringMapper;
import coil.memory.MemoryCache;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.NullRequestData;
import coil.request.NullRequestDataException;
import coil.request.OneShotDisposable;
import coil.request.RequestDelegate;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.transition.NoneTransition;
import coil.transition.Transition;
import coil.transition.TransitionTarget;
import coil.util.ImageLoaderOptions;
import coil.util.Lifecycles;
import coil.util.Logger;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Call;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: RealImageLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \\2\u00020\u0001:\u0001\\Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J\u0016\u0010A\u001a\u00020B2\u0006\u0010?\u001a\u00020@H\u0096@¢\u0006\u0002\u0010CJ\u001e\u0010D\u001a\u00020B2\u0006\u0010E\u001a\u00020@2\u0006\u0010F\u001a\u00020GH\u0083@¢\u0006\u0002\u0010HJ\u0015\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020GH\u0000¢\u0006\u0002\bLJ\b\u0010;\u001a\u00020JH\u0016J\b\u0010M\u001a\u00020NH\u0016J\"\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020UH\u0002J\"\u0010V\u001a\u00020J2\u0006\u0010P\u001a\u00020W2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020UH\u0002J\u0018\u0010X\u001a\u00020J2\u0006\u0010?\u001a\u00020@2\u0006\u0010T\u001a\u00020UH\u0002J1\u0010Y\u001a\u00020J2\u0006\u0010P\u001a\u00020B2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020U2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020J0[H\u0082\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010-\u001a\u0004\u0018\u00010\b8VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b0\u00101*\u0004\b.\u0010/R\u001d\u00102\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b4\u00105*\u0004\b3\u0010/R\u0014\u00106\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020:09X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, m1599d2 = {"Lcoil/RealImageLoader;", "Lcoil/ImageLoader;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "defaults", "Lcoil/request/DefaultRequestOptions;", "memoryCacheLazy", "Lkotlin/Lazy;", "Lcoil/memory/MemoryCache;", "diskCacheLazy", "Lcoil/disk/DiskCache;", "callFactoryLazy", "Lokhttp3/Call$Factory;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "componentRegistry", "Lcoil/ComponentRegistry;", "options", "Lcoil/util/ImageLoaderOptions;", "logger", "Lcoil/util/Logger;", "<init>", "(Landroid/content/Context;Lcoil/request/DefaultRequestOptions;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil/EventListener$Factory;Lcoil/ComponentRegistry;Lcoil/util/ImageLoaderOptions;Lcoil/util/Logger;)V", "getContext", "()Landroid/content/Context;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "getMemoryCacheLazy", "()Lkotlin/Lazy;", "getDiskCacheLazy", "getCallFactoryLazy", "getEventListenerFactory", "()Lcoil/EventListener$Factory;", "getComponentRegistry", "()Lcoil/ComponentRegistry;", "getOptions", "()Lcoil/util/ImageLoaderOptions;", "getLogger", "()Lcoil/util/Logger;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "requestService", "Lcoil/request/RequestService;", "memoryCache", "getMemoryCache$delegate", "(Lcoil/RealImageLoader;)Ljava/lang/Object;", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "diskCache", "getDiskCache$delegate", "getDiskCache", "()Lcoil/disk/DiskCache;", "components", "getComponents", "interceptors", "", "Lcoil/intercept/Interceptor;", "shutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeMain", "initialRequest", "type", "", "(Lcoil/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTrimMemory", "", FirebaseAnalytics.Param.LEVEL, "onTrimMemory$coil_base_release", "newBuilder", "Lcoil/ImageLoader$Builder;", "onSuccess", "result", "Lcoil/request/SuccessResult;", TypedValues.AttributesType.S_TARGET, "Lcoil/target/Target;", "eventListener", "Lcoil/EventListener;", "onError", "Lcoil/request/ErrorResult;", "onCancel", "transition", "setDrawable", "Lkotlin/Function0;", "Companion", "coil-base_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class RealImageLoader implements ImageLoader {
    private static final int REQUEST_TYPE_ENQUEUE = 0;
    private static final int REQUEST_TYPE_EXECUTE = 1;
    private static final String TAG = "RealImageLoader";
    private final Lazy<Call.Factory> callFactoryLazy;
    private final ComponentRegistry componentRegistry;
    private final ComponentRegistry components;
    private final Context context;
    private final DefaultRequestOptions defaults;
    private final Lazy<DiskCache> diskCacheLazy;
    private final EventListener.Factory eventListenerFactory;
    private final List<Interceptor> interceptors;
    private final Logger logger;
    private final Lazy<MemoryCache> memoryCacheLazy;
    private final ImageLoaderOptions options;
    private final RequestService requestService;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()).plus(new RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this)));
    private final AtomicBoolean shutdown;
    private final SystemCallbacks systemCallbacks;

    /* JADX INFO: renamed from: coil.RealImageLoader$executeMain$1 */
    /* JADX INFO: compiled from: RealImageLoader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.RealImageLoader", m1609f = "RealImageLoader.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2}, m1611l = {PDFACompliance.e_PDFA1_7_1, PDFACompliance.e_PDFA1_8_3, PDFACompliance.e_PDFA1_8_7}, m1612m = "executeMain", m1613n = {"this", "requestDelegate", "request", "eventListener", "this", "requestDelegate", "request", "eventListener", "placeholderBitmap", "this", "requestDelegate", "request", "eventListener"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
    static final class C38091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C38091(Continuation<? super C38091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealImageLoader.this.executeMain(null, 0, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealImageLoader(Context context, DefaultRequestOptions defaultRequestOptions, Lazy<? extends MemoryCache> lazy, Lazy<? extends DiskCache> lazy2, Lazy<? extends Call.Factory> lazy3, EventListener.Factory factory, ComponentRegistry componentRegistry, ImageLoaderOptions imageLoaderOptions, Logger logger) {
        this.context = context;
        this.defaults = defaultRequestOptions;
        this.memoryCacheLazy = lazy;
        this.diskCacheLazy = lazy2;
        this.callFactoryLazy = lazy3;
        this.eventListenerFactory = factory;
        this.componentRegistry = componentRegistry;
        this.options = imageLoaderOptions;
        this.logger = logger;
        SystemCallbacks systemCallbacks = new SystemCallbacks(this);
        this.systemCallbacks = systemCallbacks;
        RealImageLoader realImageLoader = this;
        RequestService requestService = new RequestService(realImageLoader, systemCallbacks, logger);
        this.requestService = requestService;
        this.components = componentRegistry.newBuilder().add(new HttpUrlMapper(), HttpUrl.class).add(new StringMapper(), String.class).add(new FileUriMapper(), Uri.class).add(new ResourceUriMapper(), Uri.class).add(new ResourceIntMapper(), Integer.class).add(new ByteArrayMapper(), byte[].class).add(new UriKeyer(), Uri.class).add(new FileKeyer(imageLoaderOptions.getAddLastModifiedToFileCacheKey()), File.class).add(new HttpUriFetcher.Factory(lazy3, lazy2, imageLoaderOptions.getRespectCacheHeaders()), Uri.class).add(new FileFetcher.Factory(), File.class).add(new AssetUriFetcher.Factory(), Uri.class).add(new ContentUriFetcher.Factory(), Uri.class).add(new ResourceUriFetcher.Factory(), Uri.class).add(new DrawableFetcher.Factory(), Drawable.class).add(new BitmapFetcher.Factory(), Bitmap.class).add(new ByteBufferFetcher.Factory(), ByteBuffer.class).add(new BitmapFactoryDecoder.Factory(imageLoaderOptions.getBitmapFactoryMaxParallelism(), imageLoaderOptions.getBitmapFactoryExifOrientationPolicy())).build();
        this.interceptors = CollectionsKt.plus((Collection<? extends EngineInterceptor>) getComponents().getInterceptors(), new EngineInterceptor(realImageLoader, systemCallbacks, requestService, logger));
        this.shutdown = new AtomicBoolean(false);
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // coil.ImageLoader
    public DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    public final Lazy<MemoryCache> getMemoryCacheLazy() {
        return this.memoryCacheLazy;
    }

    public final Lazy<DiskCache> getDiskCacheLazy() {
        return this.diskCacheLazy;
    }

    public final Lazy<Call.Factory> getCallFactoryLazy() {
        return this.callFactoryLazy;
    }

    public final EventListener.Factory getEventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final ComponentRegistry getComponentRegistry() {
        return this.componentRegistry;
    }

    public final ImageLoaderOptions getOptions() {
        return this.options;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    @Override // coil.ImageLoader
    public MemoryCache getMemoryCache() {
        return this.memoryCacheLazy.getValue();
    }

    @Override // coil.ImageLoader
    public DiskCache getDiskCache() {
        return this.diskCacheLazy.getValue();
    }

    @Override // coil.ImageLoader
    public ComponentRegistry getComponents() {
        return this.components;
    }

    @Override // coil.ImageLoader
    public Disposable enqueue(ImageRequest request) {
        Deferred<? extends ImageResult> deferredAsync$default = BuildersKt__Builders_commonKt.async$default(this.scope, null, null, new RealImageLoader$enqueue$job$1(this, request, null), 3, null);
        if (request.getTarget() instanceof ViewTarget) {
            return Utils.getRequestManager(((ViewTarget) request.getTarget()).getView()).getDisposable(deferredAsync$default);
        }
        return new OneShotDisposable(deferredAsync$default);
    }

    @Override // coil.ImageLoader
    public Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation) {
        if (imageRequest.getTarget() instanceof ViewTarget) {
            return CoroutineScopeKt.coroutineScope(new C38072(imageRequest, this, null), continuation);
        }
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new C38083(imageRequest, null), continuation);
    }

    /* JADX INFO: renamed from: coil.RealImageLoader$execute$2 */
    /* JADX INFO: compiled from: RealImageLoader.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcoil/request/ImageResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.RealImageLoader$execute$2", m1609f = "RealImageLoader.kt", m1610i = {}, m1611l = {TsExtractor.TS_STREAM_TYPE_DTS}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C38072 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {
        final /* synthetic */ ImageRequest $request;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RealImageLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C38072(ImageRequest imageRequest, RealImageLoader realImageLoader, Continuation<? super C38072> continuation) {
            super(2, continuation);
            this.$request = imageRequest;
            this.this$0 = realImageLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C38072 c38072 = new C38072(this.$request, this.this$0, continuation);
            c38072.L$0 = obj;
            return c38072;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageResult> continuation) {
            return ((C38072) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Deferred<? extends ImageResult> deferredAsync$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, Dispatchers.getMain().getImmediate(), null, new RealImageLoader$execute$2$job$1(this.this$0, this.$request, null), 2, null);
            Utils.getRequestManager(((ViewTarget) this.$request.getTarget()).getView()).getDisposable(deferredAsync$default);
            this.label = 1;
            Object objAwait = deferredAsync$default.await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    /* JADX INFO: renamed from: coil.RealImageLoader$execute$3 */
    /* JADX INFO: compiled from: RealImageLoader.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcoil/request/ImageResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.RealImageLoader$execute$3", m1609f = "RealImageLoader.kt", m1610i = {}, m1611l = {143}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C38083 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {
        final /* synthetic */ ImageRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C38083(ImageRequest imageRequest, Continuation<? super C38083> continuation) {
            super(2, continuation);
            this.$request = imageRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RealImageLoader.this.new C38083(this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageResult> continuation) {
            return ((C38083) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Object objExecuteMain = RealImageLoader.this.executeMain(this.$request, 1, this);
            return objExecuteMain == coroutine_suspended ? coroutine_suspended : objExecuteMain;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(18:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(4:(1:(7:13|113|14|72|(1:74)(2:75|(1:77)(2:80|81))|78|79)(2:18|19))(13:20|107|21|22|23|102|65|66|111|67|68|(5:71|72|(0)(0)|78|79)|70)|114|92|(3:94|95|96)(2:97|98))(4:26|105|27|41))(4:32|104|33|(2:35|(3:37|(2:40|41)|70)(1:42))(2:88|89))|109|43|(11:45|(1:47)(1:48)|(1:50)|(1:53)(1:54)|55|(1:57)|58|(1:60)|61|(9:64|23|102|65|66|111|67|68|(0))|70)|51|(0)(0)|55|(0)|58|(0)|61|(0)|70|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01b6, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01b7, code lost:
    
        r6 = r2;
        r4 = r5;
        r5 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010c A[Catch: all -> 0x01b6, TryCatch #4 {all -> 0x01b6, blocks: (B:43:0x00f0, B:45:0x00f6, B:47:0x00fc, B:50:0x0104, B:53:0x010c, B:55:0x0120, B:57:0x0126, B:58:0x0129, B:60:0x0132, B:61:0x0135, B:54:0x011c), top: B:109:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011c A[Catch: all -> 0x01b6, TryCatch #4 {all -> 0x01b6, blocks: (B:43:0x00f0, B:45:0x00f6, B:47:0x00fc, B:50:0x0104, B:53:0x010c, B:55:0x0120, B:57:0x0126, B:58:0x0129, B:60:0x0132, B:61:0x0135, B:54:0x011c), top: B:109:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0126 A[Catch: all -> 0x01b6, TryCatch #4 {all -> 0x01b6, blocks: (B:43:0x00f0, B:45:0x00f6, B:47:0x00fc, B:50:0x0104, B:53:0x010c, B:55:0x0120, B:57:0x0126, B:58:0x0129, B:60:0x0132, B:61:0x0135, B:54:0x011c), top: B:109:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0132 A[Catch: all -> 0x01b6, TryCatch #4 {all -> 0x01b6, blocks: (B:43:0x00f0, B:45:0x00f6, B:47:0x00fc, B:50:0x0104, B:53:0x010c, B:55:0x0120, B:57:0x0126, B:58:0x0129, B:60:0x0132, B:61:0x0135, B:54:0x011c), top: B:109:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0189 A[Catch: all -> 0x004c, TryCatch #6 {all -> 0x004c, blocks: (B:14:0x0047, B:72:0x0183, B:74:0x0189, B:75:0x0194, B:77:0x0198, B:80:0x01a6, B:81:0x01ab), top: B:113:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0194 A[Catch: all -> 0x004c, TryCatch #6 {all -> 0x004c, blocks: (B:14:0x0047, B:72:0x0183, B:74:0x0189, B:75:0x0194, B:77:0x0198, B:80:0x01a6, B:81:0x01ab), top: B:113:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ca A[Catch: all -> 0x01df, TRY_LEAVE, TryCatch #7 {all -> 0x01df, blocks: (B:92:0x01c6, B:94:0x01ca, B:97:0x01db, B:98:0x01de), top: B:114:0x01c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01db A[Catch: all -> 0x01df, TRY_ENTER, TryCatch #7 {all -> 0x01df, blocks: (B:92:0x01c6, B:94:0x01ca, B:97:0x01db, B:98:0x01de), top: B:114:0x01c6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeMain(ImageRequest imageRequest, int i, Continuation<? super ImageResult> continuation) {
        C38091 c38091;
        RequestDelegate requestDelegate;
        ImageRequest imageRequestBuild;
        RealImageLoader realImageLoader;
        RequestDelegate requestDelegate2;
        EventListener eventListener;
        RealImageLoader realImageLoader2;
        ImageRequest imageRequest2;
        EventListener eventListener2;
        RequestDelegate requestDelegate3;
        Bitmap bitmap;
        Target target;
        ImageRequest.Listener listener;
        Object size;
        ImageRequest imageRequest3;
        RealImageLoader realImageLoader3;
        RequestDelegate requestDelegate4;
        EventListener eventListener3;
        ImageResult imageResult;
        if (continuation instanceof C38091) {
            c38091 = (C38091) continuation;
            if ((c38091.label & Integer.MIN_VALUE) != 0) {
                c38091.label -= Integer.MIN_VALUE;
            } else {
                c38091 = new C38091(continuation);
            }
        }
        Object objWithContext = c38091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c38091.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            requestDelegate = this.requestService.requestDelegate(imageRequest, JobKt.getJob(c38091.getContext()));
            requestDelegate.assertActive();
            imageRequestBuild = ImageRequest.newBuilder$default(imageRequest, null, 1, null).defaults(getDefaults()).build();
            EventListener eventListenerCreate = this.eventListenerFactory.create(imageRequestBuild);
            try {
                if (imageRequestBuild.getData() == NullRequestData.INSTANCE) {
                    throw new NullRequestDataException();
                }
                requestDelegate.start();
                if (i == 0) {
                    Lifecycle lifecycle = imageRequestBuild.getLifecycle();
                    c38091.L$0 = this;
                    c38091.L$1 = requestDelegate;
                    c38091.L$2 = imageRequestBuild;
                    c38091.L$3 = eventListenerCreate;
                    c38091.label = 1;
                    if (Lifecycles.awaitStarted(lifecycle, c38091) != coroutine_suspended) {
                        realImageLoader2 = this;
                        imageRequest2 = imageRequestBuild;
                        eventListener2 = eventListenerCreate;
                        requestDelegate3 = requestDelegate;
                        requestDelegate = requestDelegate3;
                    }
                    return coroutine_suspended;
                }
                realImageLoader2 = this;
                imageRequest2 = imageRequestBuild;
                eventListener2 = eventListenerCreate;
            } catch (Throwable th) {
                th = th;
                realImageLoader = this;
                requestDelegate2 = requestDelegate;
                eventListener = eventListenerCreate;
            }
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    bitmap = (Bitmap) c38091.L$4;
                    eventListener2 = (EventListener) c38091.L$3;
                    ImageRequest imageRequest4 = (ImageRequest) c38091.L$2;
                    requestDelegate4 = (RequestDelegate) c38091.L$1;
                    RealImageLoader realImageLoader4 = (RealImageLoader) c38091.L$0;
                    try {
                        ResultKt.throwOnFailure(objWithContext);
                        imageRequest3 = imageRequest4;
                        realImageLoader3 = realImageLoader4;
                        Bitmap bitmap2 = bitmap;
                        try {
                            Size size2 = (Size) objWithContext;
                            eventListener2.resolveSizeEnd(imageRequest3, size2);
                            CoroutineDispatcher interceptorDispatcher = imageRequest3.getInterceptorDispatcher();
                            eventListener3 = eventListener2;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        eventListener = eventListener2;
                        imageRequestBuild = imageRequest4;
                        requestDelegate2 = requestDelegate4;
                        realImageLoader = realImageLoader4;
                    }
                    try {
                        RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1(imageRequest3, realImageLoader3, size2, eventListener3, bitmap2, null);
                        c38091.L$0 = realImageLoader3;
                        c38091.L$1 = requestDelegate4;
                        c38091.L$2 = imageRequest3;
                        c38091.L$3 = eventListener2;
                        c38091.L$4 = null;
                        c38091.label = 3;
                        objWithContext = BuildersKt.withContext(interceptorDispatcher, realImageLoader$executeMain$result$1, c38091);
                        if (objWithContext != coroutine_suspended) {
                            eventListener = eventListener2;
                            requestDelegate2 = requestDelegate4;
                            imageRequestBuild = imageRequest3;
                            realImageLoader = realImageLoader3;
                            imageResult = (ImageResult) objWithContext;
                            if (!(imageResult instanceof SuccessResult)) {
                            }
                            return imageResult;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th4) {
                        th = th4;
                        eventListener2 = eventListener3;
                        eventListener = eventListener2;
                        requestDelegate2 = requestDelegate4;
                        imageRequestBuild = imageRequest3;
                        realImageLoader = realImageLoader3;
                        if (th instanceof CancellationException) {
                        }
                    }
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    eventListener = (EventListener) c38091.L$3;
                    imageRequestBuild = (ImageRequest) c38091.L$2;
                    requestDelegate2 = (RequestDelegate) c38091.L$1;
                    realImageLoader = (RealImageLoader) c38091.L$0;
                    try {
                        ResultKt.throwOnFailure(objWithContext);
                        imageResult = (ImageResult) objWithContext;
                        if (!(imageResult instanceof SuccessResult)) {
                            realImageLoader.onSuccess((SuccessResult) imageResult, imageRequestBuild.getTarget(), eventListener);
                        } else {
                            if (!(imageResult instanceof ErrorResult)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            realImageLoader.onError((ErrorResult) imageResult, imageRequestBuild.getTarget(), eventListener);
                        }
                        return imageResult;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                try {
                    if (th instanceof CancellationException) {
                        realImageLoader.onCancel(imageRequestBuild, eventListener);
                        throw th;
                    }
                    ErrorResult errorResult = realImageLoader.requestService.errorResult(imageRequestBuild, th);
                    realImageLoader.onError(errorResult, imageRequestBuild.getTarget(), eventListener);
                    return errorResult;
                } finally {
                    requestDelegate2.complete();
                }
            }
            eventListener2 = (EventListener) c38091.L$3;
            imageRequest2 = (ImageRequest) c38091.L$2;
            requestDelegate3 = (RequestDelegate) c38091.L$1;
            realImageLoader2 = (RealImageLoader) c38091.L$0;
            try {
                ResultKt.throwOnFailure(objWithContext);
                requestDelegate = requestDelegate3;
            } catch (Throwable th6) {
                th = th6;
                eventListener = eventListener2;
                imageRequestBuild = imageRequest2;
                requestDelegate2 = requestDelegate3;
                realImageLoader = realImageLoader2;
                if (th instanceof CancellationException) {
                }
            }
        }
        MemoryCache memoryCache = realImageLoader2.getMemoryCache();
        if (memoryCache != null) {
            MemoryCache.Key placeholderMemoryCacheKey = imageRequest2.getPlaceholderMemoryCacheKey();
            MemoryCache.Value value = placeholderMemoryCacheKey != null ? memoryCache.get(placeholderMemoryCacheKey) : null;
            if (value != null) {
                bitmap = value.getBitmap();
            }
            BitmapDrawable bitmapDrawable = bitmap == null ? new BitmapDrawable(imageRequest2.getContext().getResources(), bitmap) : imageRequest2.getPlaceholder();
            target = imageRequest2.getTarget();
            if (target != null) {
                target.onStart(bitmapDrawable);
            }
            eventListener2.onStart(imageRequest2);
            listener = imageRequest2.getListener();
            if (listener != null) {
                listener.onStart(imageRequest2);
            }
            eventListener2.resolveSizeStart(imageRequest2);
            SizeResolver sizeResolver = imageRequest2.getSizeResolver();
            c38091.L$0 = realImageLoader2;
            c38091.L$1 = requestDelegate;
            c38091.L$2 = imageRequest2;
            c38091.L$3 = eventListener2;
            c38091.L$4 = bitmap;
            c38091.label = 2;
            size = sizeResolver.size(c38091);
            if (size != coroutine_suspended) {
                imageRequest3 = imageRequest2;
                realImageLoader3 = realImageLoader2;
                requestDelegate4 = requestDelegate;
                objWithContext = size;
                Bitmap bitmap22 = bitmap;
                Size size22 = (Size) objWithContext;
                eventListener2.resolveSizeEnd(imageRequest3, size22);
                CoroutineDispatcher interceptorDispatcher2 = imageRequest3.getInterceptorDispatcher();
                eventListener3 = eventListener2;
                RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$12 = new RealImageLoader$executeMain$result$1(imageRequest3, realImageLoader3, size22, eventListener3, bitmap22, null);
                c38091.L$0 = realImageLoader3;
                c38091.L$1 = requestDelegate4;
                c38091.L$2 = imageRequest3;
                c38091.L$3 = eventListener2;
                c38091.L$4 = null;
                c38091.label = 3;
                objWithContext = BuildersKt.withContext(interceptorDispatcher2, realImageLoader$executeMain$result$12, c38091);
                if (objWithContext != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
        bitmap = null;
        if (bitmap == null) {
        }
        target = imageRequest2.getTarget();
        if (target != null) {
        }
        eventListener2.onStart(imageRequest2);
        listener = imageRequest2.getListener();
        if (listener != null) {
        }
        eventListener2.resolveSizeStart(imageRequest2);
        SizeResolver sizeResolver2 = imageRequest2.getSizeResolver();
        c38091.L$0 = realImageLoader2;
        c38091.L$1 = requestDelegate;
        c38091.L$2 = imageRequest2;
        c38091.L$3 = eventListener2;
        c38091.L$4 = bitmap;
        c38091.label = 2;
        size = sizeResolver2.size(c38091);
        if (size != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    public final void onTrimMemory$coil_base_release(int level) {
        MemoryCache value;
        Lazy<MemoryCache> lazy = this.memoryCacheLazy;
        if (lazy == null || (value = lazy.getValue()) == null) {
            return;
        }
        value.trimMemory(level);
    }

    @Override // coil.ImageLoader
    public void shutdown() {
        if (this.shutdown.getAndSet(true)) {
            return;
        }
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        this.systemCallbacks.shutdown();
        MemoryCache memoryCache = getMemoryCache();
        if (memoryCache != null) {
            memoryCache.clear();
        }
    }

    @Override // coil.ImageLoader
    public ImageLoader.Builder newBuilder() {
        return new ImageLoader.Builder(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onSuccess(SuccessResult result, Target target, EventListener eventListener) {
        ImageRequest request = result.getRequest();
        DataSource dataSource = result.getDataSource();
        Logger logger = this.logger;
        if (logger != null && logger.getLevel() <= 4) {
            logger.log(TAG, 4, Utils.getEmoji(dataSource) + " Successful (" + dataSource.name() + ") - " + request.getData(), null);
        }
        if (target instanceof TransitionTarget) {
            SuccessResult successResult = result;
            Transition transitionCreate = successResult.getRequest().getTransitionFactory().create((TransitionTarget) target, successResult);
            if (!(transitionCreate instanceof NoneTransition)) {
                eventListener.transitionStart(successResult.getRequest(), transitionCreate);
                transitionCreate.transition();
                eventListener.transitionEnd(successResult.getRequest(), transitionCreate);
            }
        } else if (target != null) {
            target.onSuccess(result.getDrawable());
        }
        eventListener.onSuccess(request, result);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onSuccess(request, result);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onError(ErrorResult result, Target target, EventListener eventListener) {
        ImageRequest request = result.getRequest();
        Logger logger = this.logger;
        if (logger != null && logger.getLevel() <= 4) {
            logger.log(TAG, 4, "🚨 Failed - " + request.getData() + " - " + result.getThrowable(), null);
        }
        if (target instanceof TransitionTarget) {
            ErrorResult errorResult = result;
            Transition transitionCreate = errorResult.getRequest().getTransitionFactory().create((TransitionTarget) target, errorResult);
            if (!(transitionCreate instanceof NoneTransition)) {
                eventListener.transitionStart(errorResult.getRequest(), transitionCreate);
                transitionCreate.transition();
                eventListener.transitionEnd(errorResult.getRequest(), transitionCreate);
            }
        } else if (target != null) {
            target.onError(result.getDrawable());
        }
        eventListener.onError(request, result);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onError(request, result);
        }
    }

    private final void onCancel(ImageRequest request, EventListener eventListener) {
        Logger logger = this.logger;
        if (logger != null && logger.getLevel() <= 4) {
            logger.log(TAG, 4, "🏗  Cancelled - " + request.getData(), null);
        }
        eventListener.onCancel(request);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onCancel(request);
        }
    }

    private final void transition(ImageResult result, Target target, EventListener eventListener, Function0<Unit> setDrawable) {
        if (!(target instanceof TransitionTarget)) {
            setDrawable.invoke();
            return;
        }
        Transition transitionCreate = result.getRequest().getTransitionFactory().create((TransitionTarget) target, result);
        if (transitionCreate instanceof NoneTransition) {
            setDrawable.invoke();
            return;
        }
        eventListener.transitionStart(result.getRequest(), transitionCreate);
        transitionCreate.transition();
        eventListener.transitionEnd(result.getRequest(), transitionCreate);
    }
}

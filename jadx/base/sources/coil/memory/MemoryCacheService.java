package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.DecodeUtils;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.memory.MemoryCache;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.Utils;
import com.survicate.surveys.TextRecallingManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MemoryCacheService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001,B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J(\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J5\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001dJ0\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001f\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010&\u001a\u00020\u001b*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u0004\u0018\u00010)*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, m1599d2 = {"Lcoil/memory/MemoryCacheService;", "", "imageLoader", "Lcoil/ImageLoader;", "requestService", "Lcoil/request/RequestService;", "logger", "Lcoil/util/Logger;", "<init>", "(Lcoil/ImageLoader;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "newCacheKey", "Lcoil/memory/MemoryCache$Key;", "request", "Lcoil/request/ImageRequest;", "mappedData", "options", "Lcoil/request/Options;", "eventListener", "Lcoil/EventListener;", "getCacheValue", "Lcoil/memory/MemoryCache$Value;", "cacheKey", "size", "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "isCacheValueValid", "", "cacheValue", "isCacheValueValid$coil_base_release", "isSizeValid", "setCacheValue", "result", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "newResult", "Lcoil/request/SuccessResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "isSampled", "(Lcoil/memory/MemoryCache$Value;)Z", "diskCacheKey", "", "getDiskCacheKey", "(Lcoil/memory/MemoryCache$Value;)Ljava/lang/String;", "Companion", "coil-base_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class MemoryCacheService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_DISK_CACHE_KEY = "coil#disk_cache_key";
    public static final String EXTRA_IS_SAMPLED = "coil#is_sampled";
    public static final String EXTRA_TRANSFORMATION_INDEX = "coil#transformation_";
    public static final String EXTRA_TRANSFORMATION_SIZE = "coil#transformation_size";
    private static final String TAG = "MemoryCacheService";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final RequestService requestService;

    public MemoryCacheService(ImageLoader imageLoader, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.requestService = requestService;
        this.logger = logger;
    }

    public final MemoryCache.Key newCacheKey(ImageRequest request, Object mappedData, Options options, EventListener eventListener) {
        MemoryCache.Key memoryCacheKey = request.getMemoryCacheKey();
        if (memoryCacheKey != null) {
            return memoryCacheKey;
        }
        eventListener.keyStart(request, mappedData);
        String strKey = this.imageLoader.getComponents().key(mappedData, options);
        eventListener.keyEnd(request, strKey);
        if (strKey == null) {
            return null;
        }
        List<Transformation> transformations = request.getTransformations();
        Map<String, String> mapMemoryCacheKeys = request.getParameters().memoryCacheKeys();
        if (transformations.isEmpty() && mapMemoryCacheKeys.isEmpty()) {
            return new MemoryCache.Key(strKey, null, 2, null);
        }
        Map mutableMap = MapsKt.toMutableMap(mapMemoryCacheKeys);
        if (!transformations.isEmpty()) {
            List<Transformation> transformations2 = request.getTransformations();
            int size = transformations2.size();
            for (int i = 0; i < size; i++) {
                mutableMap.put(EXTRA_TRANSFORMATION_INDEX + i, transformations2.get(i).getCacheKey());
            }
            mutableMap.put(EXTRA_TRANSFORMATION_SIZE, options.getSize().toString());
        }
        return new MemoryCache.Key(strKey, mutableMap);
    }

    public final MemoryCache.Value getCacheValue(ImageRequest request, MemoryCache.Key cacheKey, Size size, Scale scale) {
        if (!request.getMemoryCachePolicy().getReadEnabled()) {
            return null;
        }
        MemoryCache memoryCache = this.imageLoader.getMemoryCache();
        MemoryCache.Value value = memoryCache != null ? memoryCache.get(cacheKey) : null;
        if (value == null || !isCacheValueValid$coil_base_release(request, cacheKey, value, size, scale)) {
            return null;
        }
        return value;
    }

    public final boolean isCacheValueValid$coil_base_release(ImageRequest request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue, Size size, Scale scale) {
        if (!this.requestService.isConfigValidForHardware(request, Bitmaps.getSafeConfig(cacheValue.getBitmap()))) {
            Logger logger = this.logger;
            if (logger == null || logger.getLevel() > 3) {
                return false;
            }
            logger.log(TAG, 3, request.getData() + ": Cached bitmap is hardware-backed, which is incompatible with the request.", null);
            return false;
        }
        return isSizeValid(request, cacheKey, cacheValue, size, scale);
    }

    private final boolean isSizeValid(ImageRequest request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue, Size size, Scale scale) {
        double d;
        String str;
        boolean zIsSampled = isSampled(cacheValue);
        if (Sizes.isOriginal(size)) {
            if (!zIsSampled) {
                return true;
            }
            Logger logger = this.logger;
            if (logger != null && logger.getLevel() <= 3) {
                logger.log(TAG, 3, request.getData() + ": Requested original size, but cached image is sampled.", null);
            }
            return false;
        }
        String str2 = cacheKey.getExtras().get(EXTRA_TRANSFORMATION_SIZE);
        if (str2 != null) {
            return Intrinsics.areEqual(str2, size.toString());
        }
        int width = cacheValue.getBitmap().getWidth();
        int height = cacheValue.getBitmap().getHeight();
        Dimension width2 = size.getWidth();
        int i = width2 instanceof Dimension.Pixels ? ((Dimension.Pixels) width2).px : Integer.MAX_VALUE;
        Dimension height2 = size.getHeight();
        int i2 = height2 instanceof Dimension.Pixels ? ((Dimension.Pixels) height2).px : Integer.MAX_VALUE;
        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, i, i2, scale);
        boolean allowInexactSize = Requests.getAllowInexactSize(request);
        if (!allowInexactSize) {
            d = 1.0d;
            str = TAG;
            if ((!Utils.isMinOrMax(i) && Math.abs(i - width) > 1) || (!Utils.isMinOrMax(i2) && Math.abs(i2 - height) > 1)) {
            }
            return true;
        }
        double dCoerceAtMost = RangesKt.coerceAtMost(dComputeSizeMultiplier, 1.0d);
        d = 1.0d;
        str = TAG;
        if (Math.abs(((double) i) - (((double) width) * dCoerceAtMost)) <= 1.0d || Math.abs(((double) i2) - (dCoerceAtMost * ((double) height))) <= 1.0d) {
            return true;
        }
        if (dComputeSizeMultiplier != d && !allowInexactSize) {
            Logger logger2 = this.logger;
            if (logger2 != null && logger2.getLevel() <= 3) {
                logger2.log(str, 3, request.getData() + ": Cached image's request size (" + width + TextRecallingManager.ANSWER_SEPARATOR + height + ") does not exactly match the requested size (" + size.getWidth() + TextRecallingManager.ANSWER_SEPARATOR + size.getHeight() + TextRecallingManager.ANSWER_SEPARATOR + scale + ").", null);
            }
            return false;
        }
        String str3 = str;
        if (dComputeSizeMultiplier > d && zIsSampled) {
            Logger logger3 = this.logger;
            if (logger3 != null && logger3.getLevel() <= 3) {
                logger3.log(str3, 3, request.getData() + ": Cached image's request size (" + width + TextRecallingManager.ANSWER_SEPARATOR + height + ") is smaller than the requested size (" + size.getWidth() + TextRecallingManager.ANSWER_SEPARATOR + size.getHeight() + TextRecallingManager.ANSWER_SEPARATOR + scale + ").", null);
            }
            return false;
        }
        return true;
    }

    public final boolean setCacheValue(MemoryCache.Key cacheKey, ImageRequest request, EngineInterceptor.ExecuteResult result) {
        MemoryCache memoryCache;
        Bitmap bitmap;
        if (request.getMemoryCachePolicy().getWriteEnabled() && (memoryCache = this.imageLoader.getMemoryCache()) != null && cacheKey != null) {
            Drawable drawable = result.getDrawable();
            BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
            if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(EXTRA_IS_SAMPLED, Boolean.valueOf(result.getIsSampled()));
                String diskCacheKey = result.getDiskCacheKey();
                if (diskCacheKey != null) {
                    linkedHashMap.put(EXTRA_DISK_CACHE_KEY, diskCacheKey);
                }
                memoryCache.set(cacheKey, new MemoryCache.Value(bitmap, linkedHashMap));
                return true;
            }
        }
        return false;
    }

    public final SuccessResult newResult(Interceptor.Chain chain, ImageRequest request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue) {
        return new SuccessResult(new BitmapDrawable(request.getContext().getResources(), cacheValue.getBitmap()), request, DataSource.MEMORY_CACHE, cacheKey, getDiskCacheKey(cacheValue), isSampled(cacheValue), Utils.isPlaceholderCached(chain));
    }

    private final boolean isSampled(MemoryCache.Value value) {
        Object obj = value.getExtras().get(EXTRA_IS_SAMPLED);
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final String getDiskCacheKey(MemoryCache.Value value) {
        Object obj = value.getExtras().get(EXTRA_DISK_CACHE_KEY);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* JADX INFO: compiled from: MemoryCacheService.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003R\u0016\u0010\f\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0003¨\u0006\u000e"}, m1599d2 = {"Lcoil/memory/MemoryCacheService$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_TRANSFORMATION_INDEX", "getEXTRA_TRANSFORMATION_INDEX$coil_base_release$annotations", "EXTRA_TRANSFORMATION_SIZE", "getEXTRA_TRANSFORMATION_SIZE$coil_base_release$annotations", "EXTRA_IS_SAMPLED", "getEXTRA_IS_SAMPLED$coil_base_release$annotations", "EXTRA_DISK_CACHE_KEY", "getEXTRA_DISK_CACHE_KEY$coil_base_release$annotations", "coil-base_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getEXTRA_DISK_CACHE_KEY$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getEXTRA_IS_SAMPLED$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getEXTRA_TRANSFORMATION_INDEX$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getEXTRA_TRANSFORMATION_SIZE$coil_base_release$annotations() {
        }

        private Companion() {
        }
    }
}

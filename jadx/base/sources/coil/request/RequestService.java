package coil.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import coil.ImageLoader;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.util.Bitmaps;
import coil.util.HardwareBitmapService;
import coil.util.HardwareBitmaps;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: RequestService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003J\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, m1599d2 = {"Lcoil/request/RequestService;", "", "imageLoader", "Lcoil/ImageLoader;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "logger", "Lcoil/util/Logger;", "<init>", "(Lcoil/ImageLoader;Lcoil/util/SystemCallbacks;Lcoil/util/Logger;)V", "hardwareBitmapService", "Lcoil/util/HardwareBitmapService;", "requestDelegate", "Lcoil/request/RequestDelegate;", "initialRequest", "Lcoil/request/ImageRequest;", "job", "Lkotlinx/coroutines/Job;", "errorResult", "Lcoil/request/ErrorResult;", "request", "throwable", "", "options", "Lcoil/request/Options;", "size", "Lcoil/size/Size;", "isConfigValidForHardware", "", "requestedConfig", "Landroid/graphics/Bitmap$Config;", "updateOptionsOnWorkerThread", "isBitmapConfigValidWorkerThread", "isConfigValidForHardwareAllocation", "isConfigValidForTransformations", "coil-base_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class RequestService {
    private final HardwareBitmapService hardwareBitmapService;
    private final ImageLoader imageLoader;
    private final SystemCallbacks systemCallbacks;

    public RequestService(ImageLoader imageLoader, SystemCallbacks systemCallbacks, Logger logger) {
        this.imageLoader = imageLoader;
        this.systemCallbacks = systemCallbacks;
        this.hardwareBitmapService = HardwareBitmaps.HardwareBitmapService(logger);
    }

    public final RequestDelegate requestDelegate(ImageRequest initialRequest, Job job) {
        Lifecycle lifecycle = initialRequest.getLifecycle();
        Target target = initialRequest.getTarget();
        if (target instanceof ViewTarget) {
            return new ViewTargetRequestDelegate(this.imageLoader, initialRequest, (ViewTarget) target, lifecycle, job);
        }
        return new BaseRequestDelegate(lifecycle, job);
    }

    public final ErrorResult errorResult(ImageRequest request, Throwable throwable) {
        Drawable error;
        if (!(throwable instanceof NullRequestDataException) || (error = request.getFallback()) == null) {
            error = request.getError();
        }
        return new ErrorResult(error, request, throwable);
    }

    public final Options options(ImageRequest request, Size size) {
        Scale scale;
        Bitmap.Config bitmapConfig = (isConfigValidForTransformations(request) && isConfigValidForHardwareAllocation(request, size)) ? request.getBitmapConfig() : Bitmap.Config.ARGB_8888;
        if (Intrinsics.areEqual(size.getWidth(), Dimension.Undefined.INSTANCE) || Intrinsics.areEqual(size.getHeight(), Dimension.Undefined.INSTANCE)) {
            scale = Scale.FIT;
        } else {
            scale = request.getScale();
        }
        return new Options(request.getContext(), bitmapConfig, request.getColorSpace(), size, scale, Requests.getAllowInexactSize(request), request.getAllowRgb565() && request.getTransformations().isEmpty() && bitmapConfig != Bitmap.Config.ALPHA_8, request.getPremultipliedAlpha(), request.getDiskCacheKey(), request.getHeaders(), request.getTags(), request.getParameters(), request.getMemoryCachePolicy(), request.getDiskCachePolicy(), request.getNetworkCachePolicy());
    }

    public final boolean isConfigValidForHardware(ImageRequest request, Bitmap.Config requestedConfig) {
        if (!Bitmaps.isHardware(requestedConfig)) {
            return true;
        }
        if (!request.getAllowHardware()) {
            return false;
        }
        Target target = request.getTarget();
        if (target instanceof ViewTarget) {
            View view = ((ViewTarget) target).getView();
            if (view.isAttachedToWindow() && !view.isHardwareAccelerated()) {
                return false;
            }
        }
        return true;
    }

    public final Options updateOptionsOnWorkerThread(Options options) {
        boolean z;
        Bitmap.Config config = options.getConfig();
        CachePolicy networkCachePolicy = options.getNetworkCachePolicy();
        boolean z2 = true;
        if (isBitmapConfigValidWorkerThread(options)) {
            z = false;
        } else {
            config = Bitmap.Config.ARGB_8888;
            z = true;
        }
        Bitmap.Config config2 = config;
        if (!options.getNetworkCachePolicy().getReadEnabled() || this.systemCallbacks.isOnline()) {
            z2 = z;
        } else {
            networkCachePolicy = CachePolicy.DISABLED;
        }
        CachePolicy cachePolicy = networkCachePolicy;
        if (z2) {
            return options.copy((16381 & 1) != 0 ? options.context : null, (16381 & 2) != 0 ? options.config : config2, (16381 & 4) != 0 ? options.colorSpace : null, (16381 & 8) != 0 ? options.size : null, (16381 & 16) != 0 ? options.scale : null, (16381 & 32) != 0 ? options.allowInexactSize : false, (16381 & 64) != 0 ? options.allowRgb565 : false, (16381 & 128) != 0 ? options.premultipliedAlpha : false, (16381 & 256) != 0 ? options.diskCacheKey : null, (16381 & 512) != 0 ? options.headers : null, (16381 & 1024) != 0 ? options.tags : null, (16381 & 2048) != 0 ? options.parameters : null, (16381 & 4096) != 0 ? options.memoryCachePolicy : null, (16381 & 8192) != 0 ? options.diskCachePolicy : null, (16381 & 16384) != 0 ? options.networkCachePolicy : cachePolicy);
        }
        return options;
    }

    private final boolean isBitmapConfigValidWorkerThread(Options options) {
        return !Bitmaps.isHardware(options.getConfig()) || this.hardwareBitmapService.getAllowHardware();
    }

    private final boolean isConfigValidForHardwareAllocation(ImageRequest request, Size size) {
        if (Bitmaps.isHardware(request.getBitmapConfig())) {
            return isConfigValidForHardware(request, request.getBitmapConfig()) && this.hardwareBitmapService.allowHardwareMainThread(size);
        }
        return true;
    }

    private final boolean isConfigValidForTransformations(ImageRequest request) {
        return request.getTransformations().isEmpty() || ArraysKt.contains(Utils.getVALID_TRANSFORMATION_CONFIGS(), request.getBitmapConfig());
    }
}

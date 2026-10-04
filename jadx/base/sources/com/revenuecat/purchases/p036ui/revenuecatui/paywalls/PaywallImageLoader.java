package com.revenuecat.purchases.p036ui.revenuecatui.paywalls;

import android.content.Context;
import coil.ImageLoader;
import coil.disk.DiskCache;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.FilesKt;

/* JADX INFO: compiled from: PaywallImageLoader.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/paywalls/PaywallImageLoader;", "", "()V", "CACHE_FOLDER", "", "MAX_CACHE_SIZE_BYTES", "", "cached", "Lcoil/ImageLoader;", "get", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallImageLoader {
    private static final String CACHE_FOLDER = "revenuecatui_cache";
    private static final long MAX_CACHE_SIZE_BYTES = 26214400;
    private static ImageLoader cached;
    public static final PaywallImageLoader INSTANCE = new PaywallImageLoader();
    public static final int $stable = 8;

    private PaywallImageLoader() {
    }

    public final synchronized ImageLoader get(final Context context) {
        ImageLoader imageLoaderBuild;
        Intrinsics.checkNotNullParameter(context, "context");
        imageLoaderBuild = cached;
        if (imageLoaderBuild == null) {
            imageLoaderBuild = new ImageLoader.Builder(context).diskCache(new Function0<DiskCache>() { // from class: com.revenuecat.purchases.ui.revenuecatui.paywalls.PaywallImageLoader.get.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DiskCache invoke() {
                    DiskCache.Builder builder = new DiskCache.Builder();
                    File cacheDir = context.getCacheDir();
                    Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
                    return builder.directory(FilesKt.resolve(cacheDir, PaywallImageLoader.CACHE_FOLDER)).maxSizeBytes(PaywallImageLoader.MAX_CACHE_SIZE_BYTES).build();
                }
            }).build();
            cached = imageLoaderBuild;
        }
        return imageLoaderBuild;
    }
}

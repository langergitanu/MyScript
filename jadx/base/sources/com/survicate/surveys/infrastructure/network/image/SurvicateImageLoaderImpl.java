package com.survicate.surveys.infrastructure.network.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import coil.ComponentRegistry;
import coil.ImageLoader;
import coil.ImageLoaders;
import coil.decode.GifDecoder;
import coil.decode.ImageDecoderDecoder;
import coil.decode.SvgDecoder;
import coil.request.ImageRequest;
import coil.target.ImageViewTarget;
import coil.transform.CircleCropTransformation;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SurvicateImageLoaderImpl.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\b\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u000e\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J6\u0010\u000f\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/image/SurvicateImageLoaderImpl;", "Lcom/survicate/surveys/infrastructure/network/image/SurvicateImageLoader;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "imageLoader", "Lcoil/ImageLoader;", "loadCompanyLogo", "", "imageView", "Landroid/widget/ImageView;", "data", "", "loadAvatar", "loadSurveyPointImage", "imageUrl", "onLoadingComplete", "Lkotlin/Function1;", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateImageLoaderImpl implements SurvicateImageLoader {
    private final ImageLoader imageLoader;

    public SurvicateImageLoaderImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ImageLoader.Builder builderNewBuilder = ImageLoaders.create(context).newBuilder();
        ComponentRegistry.Builder builder = new ComponentRegistry.Builder();
        builder.add(new SvgDecoder.Factory(false, 1, null));
        if (Build.VERSION.SDK_INT >= 28) {
            builder.add(new ImageDecoderDecoder.Factory(false, 1, null));
        } else {
            builder.add(new GifDecoder.Factory(false, 1, null));
        }
        Unit unit = Unit.INSTANCE;
        this.imageLoader = builderNewBuilder.components(builder.build()).build();
    }

    @Override // com.survicate.surveys.infrastructure.network.image.SurvicateImageLoader
    public void loadCompanyLogo(Context context, ImageView imageView, String data) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        String str = data;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        if (context == null) {
            context = imageView.getContext();
        }
        Intrinsics.checkNotNull(context);
        this.imageLoader.enqueue(new ImageRequest.Builder(context).data(data).target(imageView).build());
    }

    @Override // com.survicate.surveys.infrastructure.network.image.SurvicateImageLoader
    public void loadAvatar(Context context, ImageView imageView, String data) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        String str = data;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        if (context == null) {
            context = imageView.getContext();
        }
        Intrinsics.checkNotNull(context);
        this.imageLoader.enqueue(new ImageRequest.Builder(context).data(data).target(imageView).transformations(new CircleCropTransformation()).build());
    }

    @Override // com.survicate.surveys.infrastructure.network.image.SurvicateImageLoader
    public void loadSurveyPointImage(Context context, final ImageView imageView, String imageUrl, final Function1<? super Boolean, Unit> onLoadingComplete) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(onLoadingComplete, "onLoadingComplete");
        ImageViewTarget imageViewTarget = new ImageViewTarget(imageView) { // from class: com.survicate.surveys.infrastructure.network.image.SurvicateImageLoaderImpl$loadSurveyPointImage$target$1
            @Override // coil.target.GenericViewTarget, coil.target.Target
            public void onSuccess(Drawable result) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.onSuccess(result);
                onLoadingComplete.invoke(true);
            }

            @Override // coil.target.GenericViewTarget, coil.target.Target
            public void onError(Drawable error) {
                super.onError(error);
                onLoadingComplete.invoke(false);
            }
        };
        if (context == null) {
            context = imageView.getContext();
        }
        Intrinsics.checkNotNull(context);
        this.imageLoader.enqueue(new ImageRequest.Builder(context).data(imageUrl).target(imageViewTarget).build());
    }
}

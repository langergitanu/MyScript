package com.survicate.surveys.infrastructure.network.image;

import android.content.Context;
import android.widget.ImageView;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SurvicateImageLoader.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J6\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000eH&¨\u0006\u0010"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/image/SurvicateImageLoader;", "", "loadCompanyLogo", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "imageView", "Landroid/widget/ImageView;", "data", "", "loadAvatar", "loadSurveyPointImage", "imageUrl", "onLoadingComplete", "Lkotlin/Function1;", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SurvicateImageLoader {
    void loadAvatar(Context context, ImageView imageView, String data);

    void loadCompanyLogo(Context context, ImageView imageView, String data);

    void loadSurveyPointImage(Context context, ImageView imageView, String imageUrl, Function1<? super Boolean, Unit> onLoadingComplete);
}

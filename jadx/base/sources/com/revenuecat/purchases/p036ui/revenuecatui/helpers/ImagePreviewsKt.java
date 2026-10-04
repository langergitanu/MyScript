package com.revenuecat.purchases.p036ui.revenuecatui.helpers;

import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import coil.ImageLoader;
import coil.request.ImageRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePreviews.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u000b\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0010"}, m1599d2 = {"LocalPreviewImageLoader", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcoil/ImageLoader;", "getLocalPreviewImageLoader", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvidePreviewImageLoader", "", "imageLoader", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lcoil/ImageLoader;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "getPreviewPlaceholderBlocking", "Landroidx/compose/ui/graphics/painter/Painter;", "imageRequest", "Lcoil/request/ImageRequest;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ImagePreviewsKt {
    private static final /* synthetic */ ProvidableCompositionLocal<ImageLoader> LocalPreviewImageLoader = CompositionLocalKt.staticCompositionLocalOf(new Function0<ImageLoader>() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt$LocalPreviewImageLoader$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ImageLoader invoke() {
            return null;
        }
    });

    public static final /* synthetic */ Painter getPreviewPlaceholderBlocking(ImageLoader imageLoader, ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageLoader, "<this>");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return null;
    }

    public static final ProvidableCompositionLocal<ImageLoader> getLocalPreviewImageLoader() {
        return LocalPreviewImageLoader;
    }

    public static final /* synthetic */ void ProvidePreviewImageLoader(final ImageLoader imageLoader, final Function2 content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-887489443);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvidePreviewImageLoader)P(1)21@938L173:ImagePreviews.kt#i2nnek");
        if ((i & 48) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(content) ? 32 : 16) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 17) != 16 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-887489443, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.ProvidePreviewImageLoader (ImagePreviews.kt:21)");
            }
            CompositionLocalKt.CompositionLocalProvider(LocalPreviewImageLoader.provides(null), (Function2<? super Composer, ? super Integer, Unit>) content, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt.ProvidePreviewImageLoader.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ImagePreviewsKt.ProvidePreviewImageLoader(imageLoader, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}

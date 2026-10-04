package com.revenuecat.purchases.p036ui.revenuecatui.components.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.tooling.preview.PreviewParameter;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.DefaultLivePlaybackSpeedControl;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.p007ts.PsExtractor;
import coil.ComponentRegistry;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.intercept.Interceptor;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import com.emergetools.snapshots.annotations.EmergeSnapshotConfig;
import com.revenuecat.purchases.p036ui.revenuecatui.C7495R;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.FitModeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.ThemeImageUrlsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.AspectRatio;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.AspectRatioKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.BorderKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.OverlayKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.ShadowKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ImageComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.RemoteImageKt;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ImagePreviewsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyMapKt;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: ImageComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\u0017\u0010\f\u001a\u00020\u00012\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\u0017\u0010\u0013\u001a\u00020\u00012\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0017\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u0018\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001ao\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+H\u0003¢\u0006\u0002\u0010,\u001a\u001f\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\b\u0003\u00101\u001a\u000202H\u0003¢\u0006\u0002\u00103\u001a\u0015\u0010-\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u00104\u001a\"\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000207H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a4\u0010;\u001a\u00020<*\u00020=2\b\b\u0001\u0010>\u001a\u0002072\b\b\u0001\u0010?\u001a\u0002072\b\b\u0001\u0010@\u001a\u000202H\u0000ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a\f\u0010C\u001a\u000202*\u00020DH\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E²\u0006\n\u0010F\u001a\u00020GX\u008a\u0084\u0002"}, m1599d2 = {"ImageComponentView", "", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ImageComponentStyle;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ImageComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview", "(Landroidx/compose/runtime/Composer;I)V", "ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview", "ImageComponentView_Preview", "parameters", "Lcom/revenuecat/purchases/ui/revenuecatui/components/image/PreviewParameters;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/image/PreviewParameters;Landroidx/compose/runtime/Composer;I)V", "ImageComponentView_Preview_FixedFixedFitMargin", "ImageComponentView_Preview_LinearGradient", "ImageComponentView_Preview_Margin_Padding", "ImageComponentView_Preview_MaskShape", "maskShape", "Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;", "(Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;Landroidx/compose/runtime/Composer;I)V", "ImageComponentView_Preview_RadialGradient", "ImageComponentView_Preview_SmallerContainer", "previewImageComponentStyle", "themeImageUrls", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "fitMode", "Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;", "shape", "visible", "", "overlay", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "marginValues", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/FitMode;Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;ZLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ImageComponentStyle;", "previewImageLoader", "Lcoil/ImageLoader;", "imageUrls", "Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;", "resource", "", "(Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;ILandroidx/compose/runtime/Composer;II)Lcoil/ImageLoader;", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Landroidx/compose/runtime/Composer;I)Lcoil/ImageLoader;", "previewThemeImageUrls", "widthPx", "Lkotlin/UInt;", "heightPx", "previewThemeImageUrls-feOb9K0", "(II)Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "width", "height", "background", "toBitmap-gd2BlFg", "(Landroid/graphics/drawable/Drawable;III)Landroid/graphics/Bitmap;", "toRgbColor", "", "revenuecatui_defaultsRelease", "composeShape", "Landroidx/compose/ui/graphics/Shape;"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class ImageComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void ImageComponentView(final ImageComponentStyle style, final PaywallState.Loaded.Components state, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final ImageComponentState imageComponentStateRememberUpdatedImageComponentState;
        Modifier modifier3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-818730302);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImageComponentView)P(2,1)88@4790L94,97@5174L84,106@5729L28,108@5839L46,101@5464L958:ImageComponentView.kt#2dmy50");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(style) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(state) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-818730302, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView (ImageComponentView.kt:86)");
                }
                imageComponentStateRememberUpdatedImageComponentState = ImageComponentStateKt.rememberUpdatedImageComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT);
                if (imageComponentStateRememberUpdatedImageComponentState.getVisible()) {
                    modifier3 = modifier2;
                } else {
                    ColorStyles overlay = imageComponentStateRememberUpdatedImageComponentState.getOverlay();
                    composerStartRestartGroup.startReplaceGroup(-747768360);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "94@4958L15");
                    ColorStyle forCurrentTheme = overlay == null ? null : ColorStyleKt.getForCurrentTheme(overlay, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    BorderStyles border = imageComponentStateRememberUpdatedImageComponentState.getBorder();
                    composerStartRestartGroup.startReplaceGroup(-747766383);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*95@5025L32");
                    BorderStyle borderStyleRememberBorderStyle = border == null ? null : BorderStyleKt.rememberBorderStyle(border, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    ShadowStyles shadow = imageComponentStateRememberUpdatedImageComponentState.getShadow();
                    composerStartRestartGroup.startReplaceGroup(-747763631);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*96@5111L32");
                    ShadowStyle shadowStyleRememberShadowStyle = shadow != null ? ShadowStyleKt.rememberShadowStyle(shadow, composerStartRestartGroup, 0) : null;
                    composerStartRestartGroup.endReplaceGroup();
                    Shape shape = imageComponentStateRememberUpdatedImageComponentState.getShape();
                    composerStartRestartGroup.startReplaceGroup(-747761379);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ImageComponentView.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(shape);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt$ImageComponentView$composeShape$2$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Shape invoke() {
                                Shape shape2 = imageComponentStateRememberUpdatedImageComponentState.getShape();
                                return shape2 == null ? RectangleShapeKt.getRectangleShape() : shape2;
                            }
                        });
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final State state2 = (State) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    modifier3 = modifier2;
                    Modifier modifierPadding = PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(SizeKt.size$default(modifier2, imageComponentStateRememberUpdatedImageComponentState.getSizePlusMargin(), null, null, 6, null), imageComponentStateRememberUpdatedImageComponentState.getMarginAdjustedAspectRatio(), new Function2<Modifier, AspectRatio, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView.1
                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, AspectRatio it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return AspectRatioKt.aspectRatio(applyIfNotNull, it);
                        }
                    }), imageComponentStateRememberUpdatedImageComponentState.getMargin());
                    composerStartRestartGroup.startReplaceGroup(-747743675);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ImageComponentView.kt#9igjgp");
                    boolean zChanged2 = composerStartRestartGroup.changed(state2);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt$ImageComponentView$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                Intrinsics.checkNotNullParameter(it, "it");
                                return ShadowKt.shadow(applyIfNotNull, it, ImageComponentViewKt.ImageComponentView$lambda$3(state2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierClip = ClipKt.clip(ModifierExtensionsKt.applyIfNotNull(modifierPadding, shadowStyleRememberShadowStyle, (Function2) objRememberedValue2), ImageComponentView$lambda$3(state2));
                    composerStartRestartGroup.startReplaceGroup(-747740137);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ImageComponentView.kt#9igjgp");
                    boolean zChanged3 = composerStartRestartGroup.changed(state2);
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = (Function2) new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt$ImageComponentView$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                Intrinsics.checkNotNullParameter(it, "it");
                                return PaddingKt.m2854padding3ABfNKs(BorderKt.border(applyIfNotNull, it, ImageComponentViewKt.ImageComponentView$lambda$3(state2)), it.m13932getWidthD9Ej5fM());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierApplyIfNotNull = ModifierExtensionsKt.applyIfNotNull(modifierClip, borderStyleRememberBorderStyle, (Function2) objRememberedValue3);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierApplyIfNotNull);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                    Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 696877126, "C110@5911L501:ImageComponentView.kt#2dmy50");
                    String string = imageComponentStateRememberUpdatedImageComponentState.getImageUrls().getWebp().toString();
                    Intrinsics.checkNotNullExpressionValue(string, "imageState.imageUrls.webp.toString()");
                    RemoteImageKt.RemoteImage(string, PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(ModifierExtensionsKt.applyIfNotNull(SizeKt.size$default(Modifier.INSTANCE, imageComponentStateRememberUpdatedImageComponentState.getSize(), null, null, 6, null), imageComponentStateRememberUpdatedImageComponentState.getAspectRatio(), new Function2<Modifier, AspectRatio, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt$ImageComponentView$4$1
                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, AspectRatio it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return AspectRatioKt.aspectRatio(applyIfNotNull, it);
                        }
                    }), forCurrentTheme, new Function2<Modifier, ColorStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt$ImageComponentView$4$2
                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, ColorStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return OverlayKt.overlay$default(applyIfNotNull, it, null, 2, null);
                        }
                    }), imageComponentStateRememberUpdatedImageComponentState.getPadding()), imageComponentStateRememberUpdatedImageComponentState.getImageUrls().getWebpLowRes().toString(), imageComponentStateRememberUpdatedImageComponentState.getContentScale(), null, null, 0.0f, null, composerStartRestartGroup, 0, PsExtractor.VIDEO_STREAM_MASK);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        ImageComponentViewKt.ImageComponentView(style, state, modifier4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        modifier2 = modifier;
        if ((i3 & 147) == 146) {
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            imageComponentStateRememberUpdatedImageComponentState = ImageComponentStateKt.rememberUpdatedImageComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT);
            if (imageComponentStateRememberUpdatedImageComponentState.getVisible()) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.95f)
    public static final void ImageComponentView_Preview(@PreviewParameter(provider = PreviewParametersProvider.class) final PreviewParameters previewParameters, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1427202611);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImageComponentView_Preview)203@9126L34,203@9162L742,203@9100L804:ImageComponentView.kt#2dmy50");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(previewParameters) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1427202611, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview (ImageComponentView.kt:201)");
            }
            final ThemeImageUrls themeImageUrlsM13889previewThemeImageUrlsfeOb9K0 = m13889previewThemeImageUrlsfeOb9K0(previewParameters.getImageWidth(), previewParameters.getImageHeight());
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM13889previewThemeImageUrlsfeOb9K0, composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(-463386670, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C204@9172L726:ImageComponentView.kt#2dmy50");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-463386670, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview.<anonymous> (ImageComponentView.kt:204)");
                        }
                        Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m8182getRed0d7_KjU(), null, 2, null);
                        ThemeImageUrls themeImageUrls = themeImageUrlsM13889previewThemeImageUrlsfeOb9K0;
                        PreviewParameters previewParameters2 = previewParameters;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2016backgroundbw27NRU$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer2);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -575628085, "C206@9284L544,219@9854L19,205@9240L648:ImageComponentView.kt#2dmy50");
                        ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, previewParameters2.getViewSize(), previewParameters2.getFitMode(), new MaskShape.Rectangle(new CornerRadiuses.C7411Dp(20.0d, 20.0d, 20.0d, 20.0d)), false, null, null, null, null, null, composer2, 3072, 1008), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ImageComponentViewKt.ImageComponentView_Preview(previewParameters, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1105161640);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview)230@10161L34,230@10197L590,230@10135L652:ImageComponentView.kt#2dmy50");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1105161640, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview (ImageComponentView.kt:228)");
            }
            final ThemeImageUrls themeImageUrlsM13889previewThemeImageUrlsfeOb9K0 = m13889previewThemeImageUrlsfeOb9K0(100, 100);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM13889previewThemeImageUrlsfeOb9K0, composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(-1367814797, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C231@10207L574:ImageComponentView.kt#2dmy50");
                    if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1367814797, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview.<anonymous> (ImageComponentView.kt:231)");
                        }
                        Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(androidx.compose.foundation.layout.SizeKt.m2929width3ABfNKs(androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m8182getRed0d7_KjU(), null, 2, null), 0.0f, 1, null), C1486Dp.m11017constructorimpl(200)), C1486Dp.m11017constructorimpl(20));
                        ThemeImageUrls themeImageUrls = themeImageUrlsM13889previewThemeImageUrlsfeOb9K0;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2854padding3ABfNKs);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer2);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -980278092, "C239@10455L256,245@10737L19,238@10411L360:ImageComponentView.kt#2dmy50");
                        ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), FitMode.FILL, new MaskShape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), false, null, null, null, null, null, composer2, 3504, 1008), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ImageComponentViewKt.ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1217970940);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview)256@11044L34,256@11080L590,256@11018L652:ImageComponentView.kt#2dmy50");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1217970940, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview (ImageComponentView.kt:254)");
            }
            final ThemeImageUrls themeImageUrlsM13889previewThemeImageUrlsfeOb9K0 = m13889previewThemeImageUrlsfeOb9K0(100, 100);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM13889previewThemeImageUrlsfeOb9K0, composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(955317783, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C257@11090L574:ImageComponentView.kt#2dmy50");
                    if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(955317783, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview.<anonymous> (ImageComponentView.kt:257)");
                        }
                        Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(androidx.compose.foundation.layout.SizeKt.m2910height3ABfNKs(androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m8182getRed0d7_KjU(), null, 2, null), 0.0f, 1, null), C1486Dp.m11017constructorimpl(200)), C1486Dp.m11017constructorimpl(20));
                        ThemeImageUrls themeImageUrls = themeImageUrlsM13889previewThemeImageUrlsfeOb9K0;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2854padding3ABfNKs);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer2);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 2102969592, "C265@11338L256,271@11620L19,264@11294L360:ImageComponentView.kt#2dmy50");
                        ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), SizeConstraint.Fill.INSTANCE), FitMode.FILL, new MaskShape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), false, null, null, null, null, null, composer2, 3504, 1008), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ImageComponentViewKt.ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void ImageComponentView_Preview_SmallerContainer(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1125682689);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImageComponentView_Preview_SmallerContainer)282@11906L34,282@11942L836,282@11880L898:ImageComponentView.kt#2dmy50");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1125682689, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_SmallerContainer (ImageComponentView.kt:280)");
            }
            final ThemeImageUrls themeImageUrlsM13889previewThemeImageUrlsfeOb9K0 = m13889previewThemeImageUrlsfeOb9K0(400, 400);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM13889previewThemeImageUrlsfeOb9K0, composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(-161866748, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_SmallerContainer.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C283@11952L820:ImageComponentView.kt#2dmy50");
                    if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-161866748, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_SmallerContainer.<anonymous> (ImageComponentView.kt:283)");
                        }
                        Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(androidx.compose.foundation.layout.SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(200)), Color.INSTANCE.m8175getBlue0d7_KjU(), null, 2, null);
                        ThemeImageUrls themeImageUrls = themeImageUrlsM13889previewThemeImageUrlsfeOb9K0;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2016backgroundbw27NRU$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer2);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1242448238, "C289@12137L565,302@12728L19,288@12093L669:ImageComponentView.kt#2dmy50");
                        ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(new SizeConstraint.Fixed(400, null), new SizeConstraint.Fixed(400, null)), FitMode.FIT, new MaskShape.Rectangle(new CornerRadiuses.C7411Dp(20.0d, 20.0d, 20.0d, 20.0d)), false, null, null, null, null, null, composer2, 3504, 1008), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_SmallerContainer.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ImageComponentViewKt.ImageComponentView_Preview_SmallerContainer(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void ImageComponentView_Preview_Margin_Padding(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-370346004);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImageComponentView_Preview_Margin_Padding)313@13012L34,313@13048L986,313@12986L1048:ImageComponentView.kt#2dmy50");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-370346004, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_Margin_Padding (ImageComponentView.kt:311)");
            }
            final ThemeImageUrls themeImageUrlsM13889previewThemeImageUrlsfeOb9K0 = m13889previewThemeImageUrlsfeOb9K0(400, 400);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM13889previewThemeImageUrlsfeOb9K0, composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(1369202481, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_Margin_Padding.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C314@13058L970:ImageComponentView.kt#2dmy50");
                    if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1369202481, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_Margin_Padding.<anonymous> (ImageComponentView.kt:314)");
                        }
                        Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(androidx.compose.foundation.layout.SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(200)), Color.INSTANCE.m8178getGray0d7_KjU(), null, 2, null);
                        ThemeImageUrls themeImageUrls = themeImageUrlsM13889previewThemeImageUrlsfeOb9K0;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2016backgroundbw27NRU$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer2);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 840944325, "C320@13243L715,336@13984L19,319@13199L819:ImageComponentView.kt#2dmy50");
                        float f = 20;
                        ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(new SizeConstraint.Fixed(400, null), new SizeConstraint.Fixed(400, null)), FitMode.FIT, new MaskShape.Rectangle(new CornerRadiuses.C7411Dp(20.0d, 20.0d, 20.0d, 20.0d)), false, null, PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), null, null, composer2, 819465648, 304), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_Margin_Padding.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ImageComponentViewKt.ImageComponentView_Preview_Margin_Padding(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void ImageComponentView_Preview_LinearGradient(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(246381111);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImageComponentView_Preview_LinearGradient)348@14293L34,348@14329L1950,348@14267L2012:ImageComponentView.kt#2dmy50");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(246381111, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_LinearGradient (ImageComponentView.kt:346)");
            }
            final ThemeImageUrls themeImageUrlsM13889previewThemeImageUrlsfeOb9K0 = m13889previewThemeImageUrlsfeOb9K0(400, 400);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM13889previewThemeImageUrlsfeOb9K0, composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(1985929596, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_LinearGradient.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C349@14339L1934:ImageComponentView.kt#2dmy50");
                    if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1985929596, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_LinearGradient.<anonymous> (ImageComponentView.kt:349)");
                        }
                        Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m8182getRed0d7_KjU(), null, 2, null);
                        ThemeImageUrls themeImageUrls = themeImageUrlsM13889previewThemeImageUrlsfeOb9K0;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2016backgroundbw27NRU$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer2);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -973879005, "C351@14451L1752,389@16229L19,350@14407L1856:ImageComponentView.kt#2dmy50");
                        ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(new SizeConstraint.Fixed(400, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), FitMode.FIT, new MaskShape.Rectangle(new CornerRadiuses.C7411Dp(20.0d, 20.0d, 20.0d, 20.0d)), false, new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(0.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(android.graphics.Color.parseColor("#88FF0000"), 0.0f), new ColorInfo.Gradient.Point(android.graphics.Color.parseColor("#8800FF00"), 50.0f), new ColorInfo.Gradient.Point(android.graphics.Color.parseColor("#880000FF"), 100.0f)}))), null, 2, null), null, null, new BorderStyles(C1486Dp.m11017constructorimpl(10), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null), null, composer2, 3504, 720), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_LinearGradient.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ImageComponentViewKt.ImageComponentView_Preview_LinearGradient(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void ImageComponentView_Preview_RadialGradient(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1728211453);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImageComponentView_Preview_RadialGradient)401@16538L34,401@16574L1648,401@16512L1710:ImageComponentView.kt#2dmy50");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1728211453, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_RadialGradient (ImageComponentView.kt:399)");
            }
            final ThemeImageUrls themeImageUrlsM13889previewThemeImageUrlsfeOb9K0 = m13889previewThemeImageUrlsfeOb9K0(400, 400);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM13889previewThemeImageUrlsfeOb9K0, composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(-827207358, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_RadialGradient.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C402@16584L1632:ImageComponentView.kt#2dmy50");
                    if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-827207358, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_RadialGradient.<anonymous> (ImageComponentView.kt:402)");
                        }
                        Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m8182getRed0d7_KjU(), null, 2, null);
                        ThemeImageUrls themeImageUrls = themeImageUrlsM13889previewThemeImageUrlsfeOb9K0;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2016backgroundbw27NRU$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer2);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1252823735, "C404@16696L1450,435@18172L19,403@16652L1554:ImageComponentView.kt#2dmy50");
                        ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(new SizeConstraint.Fixed(400, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), FitMode.FIT, new MaskShape.Rectangle(new CornerRadiuses.C7411Dp(20.0d, 20.0d, 20.0d, 20.0d)), false, new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(android.graphics.Color.parseColor("#88FF0000"), 0.0f), new ColorInfo.Gradient.Point(android.graphics.Color.parseColor("#8800FF00"), 50.0f), new ColorInfo.Gradient.Point(android.graphics.Color.parseColor("#880000FF"), 100.0f)}))), null, 2, null), null, null, null, null, composer2, 3504, 976), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_RadialGradient.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ImageComponentViewKt.ImageComponentView_Preview_RadialGradient(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void ImageComponentView_Preview_MaskShape(@PreviewParameter(provider = MaskShapeProvider.class) final MaskShape maskShape, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(916782022);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImageComponentView_Preview_MaskShape)464@18985L34,464@19021L455,464@18959L517:ImageComponentView.kt#2dmy50");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(maskShape) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(916782022, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_MaskShape (ImageComponentView.kt:462)");
            }
            final ThemeImageUrls themeImageUrlsM13889previewThemeImageUrlsfeOb9K0 = m13889previewThemeImageUrlsfeOb9K0(400, 200);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM13889previewThemeImageUrlsfeOb9K0, composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(-569034613, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_MaskShape.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C465@19031L439:ImageComponentView.kt#2dmy50");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-569034613, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_MaskShape.<anonymous> (ImageComponentView.kt:465)");
                        }
                        Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m8175getBlue0d7_KjU(), null, 2, null);
                        ThemeImageUrls themeImageUrls = themeImageUrlsM13889previewThemeImageUrlsfeOb9K0;
                        MaskShape maskShape2 = maskShape;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2016backgroundbw27NRU$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer2);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 795901877, "C467@19144L256,473@19426L19,466@19100L360:ImageComponentView.kt#2dmy50");
                        ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(new SizeConstraint.Fixed(400, null), new SizeConstraint.Fixed(200, null)), FitMode.FIT, maskShape2, false, null, null, null, null, null, composer2, 432, 1008), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_MaskShape.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ImageComponentViewKt.ImageComponentView_Preview_MaskShape(maskShape, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = DefaultLivePlaybackSpeedControl.DEFAULT_FALLBACK_MIN_PLAYBACK_SPEED)
    public static final void ImageComponentView_Preview_FixedFixedFitMargin(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1911339503);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ImageComponentView_Preview_FixedFixedFitMargin)484@19713L34,484@19749L596,484@19687L658:ImageComponentView.kt#2dmy50");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1911339503, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_FixedFixedFitMargin (ImageComponentView.kt:482)");
            }
            final ThemeImageUrls themeImageUrlsM13889previewThemeImageUrlsfeOb9K0 = m13889previewThemeImageUrlsfeOb9K0(96, 96);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM13889previewThemeImageUrlsfeOb9K0, composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(-1199303222, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_FixedFixedFitMargin.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C485@19759L580:ImageComponentView.kt#2dmy50");
                    if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1199303222, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_FixedFixedFitMargin.<anonymous> (ImageComponentView.kt:485)");
                        }
                        Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m8182getRed0d7_KjU(), null, 2, null);
                        ThemeImageUrls themeImageUrls = themeImageUrlsM13889previewThemeImageUrlsfeOb9K0;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2016backgroundbw27NRU$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer2);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 182381309, "C487@19871L398,496@20295L19,486@19827L502:ImageComponentView.kt#2dmy50");
                        ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(new SizeConstraint.Fixed(24, null), new SizeConstraint.Fixed(24, null)), FitMode.FIT, new MaskShape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), false, null, null, PaddingKt.m2851PaddingValuesa9UjIt4$default(0.0f, 0.0f, C1486Dp.m11017constructorimpl(8), 0.0f, 11, null), null, null, composer2, 918556080, 112), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_FixedFixedFitMargin.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ImageComponentViewKt.ImageComponentView_Preview_FixedFixedFitMargin(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final ImageLoader previewImageLoader(ThemeImageUrls themeImageUrls, Composer composer, int i) {
        composer.startReplaceGroup(-845849021);
        ComposerKt.sourceInformation(composer, "C(previewImageLoader)541@21553L19,541@21507L66:ImageComponentView.kt#2dmy50");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-845849021, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.previewImageLoader (ImageComponentView.kt:541)");
        }
        ImageLoader imageLoaderPreviewImageLoader = previewImageLoader(ThemeImageUrlsKt.getUrlsForCurrentTheme(themeImageUrls, composer, i & 14), 0, composer, 0, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return imageLoaderPreviewImageLoader;
    }

    private static final ImageLoader previewImageLoader(final ImageUrls imageUrls, final int i, Composer composer, int i2, int i3) {
        composer.startReplaceGroup(-536172673);
        ComposerKt.sourceInformation(composer, "C(previewImageLoader)548@21746L7,*551@21832L682:ImageComponentView.kt#2dmy50");
        if ((i3 & 2) != 0) {
            i = C7495R.drawable.f2964android;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-536172673, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.previewImageLoader (ImageComponentView.kt:547)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Context context = (Context) objConsume;
        ImageLoader.Builder builder = new ImageLoader.Builder(context);
        ComponentRegistry.Builder builder2 = new ComponentRegistry.Builder();
        composer.startReplaceGroup(-2000729967);
        ComposerKt.sourceInformation(composer, "CC(remember):ImageComponentView.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(context) | ((((i2 & 112) ^ 48) > 32 && composer.changed(i)) || (i2 & 48) == 32) | ((((i2 & 14) ^ 6) > 4 && composer.changed(imageUrls)) || (i2 & 6) == 4);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Interceptor) new Interceptor() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt$previewImageLoader$1$1$1
                @Override // coil.intercept.Interceptor
                public final Object intercept(Interceptor.Chain chain, Continuation<? super ImageResult> continuation) {
                    Resources resources = chain.getRequest().getContext().getResources();
                    Drawable drawable = context.getDrawable(i);
                    Intrinsics.checkNotNull(drawable);
                    int width = imageUrls.getWidth();
                    int height = imageUrls.getHeight();
                    ImageUrls imageUrls2 = imageUrls;
                    return new SuccessResult(new BitmapDrawable(resources, ImageComponentViewKt.m13890toBitmapgd2BlFg(drawable, width, height, ImageComponentViewKt.toRgbColor(new StringBuilder().append(imageUrls2.getOriginal()).append(AbstractJsonLexerKt.COLON).append((Object) UInt.m14640toStringimpl(imageUrls2.getWidth())).append((Object) UInt.m14640toStringimpl(imageUrls2.getHeight())).toString()))), chain.getRequest(), DataSource.MEMORY, null, null, false, false, 120, null);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceGroup();
        builder2.add((Interceptor) objRememberedValue);
        ImageLoader imageLoaderBuild = builder.components(builder2.build()).build();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return imageLoaderBuild;
    }

    /* JADX INFO: renamed from: previewThemeImageUrls-feOb9K0, reason: not valid java name */
    private static final ThemeImageUrls m13889previewThemeImageUrlsfeOb9K0(int i, int i2) {
        return new ThemeImageUrls(new ImageUrls(new URL("https://preview"), new URL("https://preview"), new URL("https://preview"), i, i2, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: toBitmap-gd2BlFg, reason: not valid java name */
    public static final Bitmap m13890toBitmapgd2BlFg(Drawable toBitmap, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(toBitmap, "$this$toBitmap");
        Rect bounds = toBitmap.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        int i4 = bounds.left;
        int i5 = bounds.top;
        int i6 = bounds.right;
        int i7 = bounds.bottom;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width.toInt…oInt(), Config.ARGB_8888)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(i3);
        toBitmap.setBounds(0, 0, i, i2);
        toBitmap.draw(canvas);
        toBitmap.setBounds(i4, i5, i6, i7);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toRgbColor(String str) {
        int iHashCode = str.hashCode();
        return (iHashCode & 255) | (((iHashCode >> 16) & 255) << 16) | (-16777216) | (((iHashCode >> 8) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageComponentStyle previewImageComponentStyle(ThemeImageUrls themeImageUrls, Size size, FitMode fitMode, MaskShape maskShape, boolean z, ColorStyles colorStyles, PaddingValues paddingValues, PaddingValues paddingValues2, BorderStyles borderStyles, ShadowStyles shadowStyles, Composer composer, int i, int i2) {
        composer.startReplaceGroup(-1478132064);
        ComposerKt.sourceInformation(composer, "C(previewImageComponentStyle)P(8,7,1,6,9,3,4,2):ImageComponentView.kt#2dmy50");
        boolean z2 = (i2 & 16) != 0 ? true : z;
        ColorStyles colorStyles2 = (i2 & 32) != 0 ? null : colorStyles;
        PaddingValues paddingValuesM2847PaddingValues0680j_4 = (i2 & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : paddingValues;
        PaddingValues paddingValuesM2847PaddingValues0680j_42 = (i2 & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : paddingValues2;
        BorderStyles borderStyles2 = (i2 & 256) != 0 ? new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8176getCyan0d7_KjU())), null, 2, null), null) : borderStyles;
        ShadowStyles shadowStyles2 = (i2 & 512) != 0 ? new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(10), C1486Dp.m11017constructorimpl(0), C1486Dp.m11017constructorimpl(3), null) : shadowStyles;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1478132064, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.previewImageComponentStyle (ImageComponentView.kt:523)");
        }
        ImageComponentStyle imageComponentStyle = new ImageComponentStyle(NonEmptyMapKt.nonEmptyMapOf(TuplesKt.m1606to(LocaleId.m13797boximpl(LocaleId.m13798constructorimpl("en_US")), themeImageUrls), new Pair[0]), z2, size, paddingValuesM2847PaddingValues0680j_4, paddingValuesM2847PaddingValues0680j_42, ShapeKt.toShape(maskShape), borderStyles2, shadowStyles2, colorStyles2, FitModeKt.toContentScale(fitMode), null, null, null, null, CollectionsKt.emptyList(), false, 43008, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return imageComponentStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Shape ImageComponentView$lambda$3(State<? extends Shape> state) {
        return state.getValue();
    }
}

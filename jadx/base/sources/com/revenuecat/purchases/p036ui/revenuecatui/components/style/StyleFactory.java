package com.revenuecat.purchases.p036ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsSpec;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.ColorAlias;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.p036ui.revenuecatui.components.LocalizedTextPartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedCarouselPartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedIconPartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedImagePartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedPackagePartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedStackPartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedTabsPartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedTimelineItemPartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedTimelinePartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedVideoPartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedWebViewPartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.AlignmentKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.FitModeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.FontKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.FontSpecKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.StyleFactory;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TabControlStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TabsComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.OverflowExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.PageControlExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyMapKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PromoOfferResolver;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResultKt;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.FallbackHeaderComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.ImageComponent;
import com.revenuecat.purchases.paywalls.components.PackageComponent;
import com.revenuecat.purchases.paywalls.components.PartialCarouselComponent;
import com.revenuecat.purchases.paywalls.components.PartialIconComponent;
import com.revenuecat.purchases.paywalls.components.PartialImageComponent;
import com.revenuecat.purchases.paywalls.components.PartialPackageComponent;
import com.revenuecat.purchases.paywalls.components.PartialStackComponent;
import com.revenuecat.purchases.paywalls.components.PartialTabsComponent;
import com.revenuecat.purchases.paywalls.components.PartialTextComponent;
import com.revenuecat.purchases.paywalls.components.PartialTimelineComponent;
import com.revenuecat.purchases.paywalls.components.PartialTimelineComponentItem;
import com.revenuecat.purchases.paywalls.components.PartialVideoComponent;
import com.revenuecat.purchases.paywalls.components.PartialWebViewComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TabControlButtonComponent;
import com.revenuecat.purchases.paywalls.components.TabControlComponent;
import com.revenuecat.purchases.paywalls.components.TabControlToggleComponent;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
import com.revenuecat.purchases.paywalls.components.TextComponent;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.VideoComponent;
import com.revenuecat.purchases.paywalls.components.WebViewComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StyleFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000®\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u008c\u00012\u00020\u0001:\u0006\u008c\u0001\u008d\u0001\u008e\u0001B\u0083\u0001\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u00070\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\t\u0012\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u00030\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J>\u0010\u0017\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00182\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!J>\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u00182\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020\u00152\b\b\u0002\u0010)\u001a\u00020\u0015J0\u0010*\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u00182\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010\u000bH\u0002J(\u0010/\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u000100\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u00102\u001a\u000203H\u0002J(\u00104\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u000105\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u00106\u001a\u000207H\u0002J(\u00108\u001a\u0014\u0012\u0004\u0012\u000200\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\b\u0010\u001d\u001a\u0004\u0018\u000109H\u0002J(\u0010:\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010;\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020<H\u0002J&\u0010=\u001a\u0014\u0012\u0004\u0012\u00020>\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020?H\u0002J&\u0010@\u001a\u0014\u0012\u0004\u0012\u00020A\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020BH\u0002J&\u0010C\u001a\u0014\u0012\u0004\u0012\u00020D\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020EH\u0002J&\u0010F\u001a\u0014\u0012\u0004\u0012\u00020G\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020HH\u0002J&\u0010I\u001a\u0014\u0012\u0004\u0012\u00020J\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020KH\u0002J(\u0010L\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010M\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020&H\u0002J(\u0010N\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010O\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020PH\u0002J&\u0010Q\u001a\u0014\u0012\u0004\u0012\u00020;\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020RH\u0002J&\u0010S\u001a\u0014\u0012\u0004\u0012\u00020T\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020UH\u0002J&\u0010V\u001a\u0014\u0012\u0004\u0012\u00020W\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020XH\u0002J&\u0010Y\u001a\u0014\u0012\u0004\u0012\u00020Z\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020[H\u0002J&\u0010\\\u001a\u0014\u0012\u0004\u0012\u00020]\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020^H\u0002J&\u0010_\u001a\u0014\u0012\u0004\u0012\u00020`\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020aH\u0002J6\u0010b\u001a\u0014\u0012\u0004\u0012\u00020c\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020iH\u0002J&\u0010j\u001a\u0014\u0012\u0004\u0012\u00020g\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010k\u001a\u00020lH\u0002J:\u0010m\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\f\u0010n\u001a\b\u0012\u0004\u0012\u00020e0o2\u0006\u0010f\u001a\u00020gH\u0002J&\u0010p\u001a\u0014\u0012\u0004\u0012\u00020q\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020rH\u0002J&\u0010s\u001a\u0014\u0012\u0004\u0012\u00020t\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010u\u001a\u00020vH\u0002J&\u0010w\u001a\u0014\u0012\u0004\u0012\u00020x\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020yH\u0002J&\u0010z\u001a\u0014\u0012\u0004\u0012\u00020{\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020|H\u0002J&\u0010}\u001a\u0014\u0012\u0004\u0012\u00020~\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001a0\u0018*\u0002012\u0006\u0010%\u001a\u00020\u007fH\u0002J\u0019\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001*\u00020\u00132\u0007\u0010\u0082\u0001\u001a\u00020\u0011H\u0002JE\u0010\u0083\u0001\u001a\"\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u0084\u00010\u0003\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0085\u00010\u001a0\u0018*\u00030\u0084\u00012\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0005H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001JE\u0010\u0083\u0001\u001a\"\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u0089\u00010\u0003\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u00010\u001a0\u0018*\u00030\u0089\u00012\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0005H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0087\u0001\u0010\u008b\u0001R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u008f\u0001"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory;", "", "localizations", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/ktx/LocalizationDictionary;", "colorAliases", "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "fontAliases", "Lcom/revenuecat/purchases/FontAlias;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "variableLocalizations", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "", "offering", "Lcom/revenuecat/purchases/Offering;", "stripRules", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;Ljava/util/Map;Ljava/util/Map;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;Lcom/revenuecat/purchases/Offering;Z)V", "buttonComponentStyleUrlDestination", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Url;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingStringLocalization;", "urlLid", FirebaseAnalytics.Param.METHOD, "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "componentInteractionValue", "buttonComponentStyleUrlDestination-xW_dp2A", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "create", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleResult;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "component", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "applyTopWindowInsets", "applyBottomWindowInsets", "applyHorizontalWindowInsets", "createBackgroundStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "background", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "convertAction", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope;", "action", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "convertDestination", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination;", FirebaseAnalytics.Param.DESTINATION, "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "convertPurchaseButtonMethod", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;", "createButtonComponentStyleOrNull", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent;", "createCarouselComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;", "createCountdownComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CountdownComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent;", "createHeaderComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/HeaderComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/HeaderComponent;", "createIconComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/IconComponent;", "createImageComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ImageComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/ImageComponent;", "createInternal", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "createPackageComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/PackageComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/PackageComponent;", "createPurchaseButtonComponentStyle", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent;", "createStackComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "createStickyFooterComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StickyFooterComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/StickyFooterComponent;", "createTabControlButtonComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlButtonComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/TabControlButtonComponent;", "createTabControlToggleComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlToggleComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/TabControlToggleComponent;", "createTabsComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabsComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/TabsComponent;", "createTabsComponentStyleTab", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabsComponentStyle$Tab;", "componentTab", "Lcom/revenuecat/purchases/paywalls/components/TabsComponent$Tab;", "control", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;", "tabIndex", "", "createTabsComponentStyleTabControl", "componentControl", "Lcom/revenuecat/purchases/paywalls/components/TabsComponent$TabControl;", "createTabsComponentStyleTabs", "componentTabs", "", "createTextComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/TextComponent;", "createTimelineComponentItemStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ItemStyle;", "item", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Item;", "createTimelineComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent;", "createVideoComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/VideoComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/VideoComponent;", "createWebViewComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/WebViewComponentStyle;", "Lcom/revenuecat/purchases/paywalls/components/WebViewComponent;", "getPackageOrNull", "Lcom/revenuecat/purchases/Package;", Keys.IDENTIFIER, "withLocalizedOverrides", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingImageLocalization;", "overrideSourceLid", "withLocalizedOverrides-TDPsjl0", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError$MissingVideoLocalization;", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;Ljava/lang/String;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Companion", "StyleFactoryScope", "StyleResult", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class StyleFactory {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Shape.Rectangle DEFAULT_SHAPE = new Shape.Rectangle((CornerRadiuses) (0 == true ? 1 : 0), 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    private static final float DEFAULT_SPACING = 0.0f;
    private static final boolean DEFAULT_VISIBILITY = true;
    private final Map<ColorAlias, ColorScheme> colorAliases;
    private final Map<FontAlias, FontSpec> fontAliases;
    private final NonEmptyMap<LocaleId, NonEmptyMap<LocalizationKey, LocalizationData>> localizations;
    private final Offering offering;
    private final boolean stripRules;
    private final NonEmptyMap<LocaleId, NonEmptyMap<VariableLocalizationKey, String>> variableLocalizations;

    /* JADX INFO: compiled from: StyleFactory.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonComponent.UrlMethod.values().length];
            try {
                iArr[ButtonComponent.UrlMethod.IN_APP_BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.EXTERNAL_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.DEEP_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StyleFactory(NonEmptyMap<LocaleId, ? extends NonEmptyMap<LocalizationKey, ? extends LocalizationData>> localizations, Map<ColorAlias, ColorScheme> colorAliases, Map<FontAlias, ? extends FontSpec> fontAliases, NonEmptyMap<LocaleId, NonEmptyMap<VariableLocalizationKey, String>> variableLocalizations, Offering offering, boolean z) {
        Intrinsics.checkNotNullParameter(localizations, "localizations");
        Intrinsics.checkNotNullParameter(colorAliases, "colorAliases");
        Intrinsics.checkNotNullParameter(fontAliases, "fontAliases");
        Intrinsics.checkNotNullParameter(variableLocalizations, "variableLocalizations");
        Intrinsics.checkNotNullParameter(offering, "offering");
        this.localizations = localizations;
        this.colorAliases = colorAliases;
        this.fontAliases = fontAliases;
        this.variableLocalizations = variableLocalizations;
        this.offering = offering;
        this.stripRules = z;
    }

    public /* synthetic */ StyleFactory(NonEmptyMap nonEmptyMap, Map map, Map map2, NonEmptyMap nonEmptyMap2, Offering offering, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nonEmptyMap, map, map2, nonEmptyMap2, offering, (i & 32) != 0 ? false : z);
    }

    /* JADX INFO: compiled from: StyleFactory.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$Companion;", "", "()V", "DEFAULT_SHAPE", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape$Rectangle;", "getDEFAULT_SHAPE$revenuecatui_defaultsRelease", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shape$Rectangle;", "DEFAULT_SPACING", "", "DEFAULT_VISIBILITY", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Shape.Rectangle getDEFAULT_SHAPE$revenuecatui_defaultsRelease() {
            return StyleFactory.DEFAULT_SHAPE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StyleFactory.kt */
    @Metadata(m1598d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001:\u0004\u0098\u0001\u0099\u0001B¿\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012 \b\u0002\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0015\u0012\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0015¢\u0006\u0002\u0010\u001aJ\u000e\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020gJ\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0013HÆ\u0003J!\u0010k\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0015HÂ\u0003J\u0015\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0015HÂ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010o\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010p\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000f\u0010q\u001a\b\u0012\u0004\u0012\u00020\n0\fHÆ\u0003J\u0015\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000eHÆ\u0003J\t\u0010s\u001a\u00020\u0007HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0011HÆ\u0003JÈ\u0001\u0010u\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132 \b\u0002\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u00152\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0015HÆ\u0001¢\u0006\u0002\u0010vJ\u0013\u0010w\u001a\u00020\u00182\b\u0010x\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010y\u001a\u00020\u0007HÖ\u0001J\u000e\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020\u0017J\u0010\u0010}\u001a\u00020{2\u0006\u0010~\u001a\u00020\u0003H\u0002J\t\u0010\u007f\u001a\u00020\nHÖ\u0001JO\u0010\u0080\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0082\u00010\u0081\u0001\"\u0005\b\u0000\u0010\u0082\u00012\u0015\b\b\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u001a\u0010\u0084\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u0003H\u0082\u00010\u0016¢\u0006\u0003\b\u0085\u0001H\u0086\bø\u0001\u0000JA\u0010\u0086\u0001\u001a\u0003H\u0082\u0001\"\u0005\b\u0000\u0010\u0082\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u001a\u0010\u0084\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u0003H\u0082\u00010\u0016¢\u0006\u0003\b\u0085\u0001¢\u0006\u0003\u0010\u0087\u0001JE\u0010\u0088\u0001\u001a\u0003H\u0082\u0001\"\u0005\b\u0000\u0010\u0082\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001a\u0010\u0084\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u0003H\u0082\u00010\u0016¢\u0006\u0003\b\u0085\u0001¢\u0006\u0003\u0010\u0089\u0001J9\u0010\u008a\u0001\u001a\u0003H\u0082\u0001\"\u0005\b\u0000\u0010\u0082\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0084\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u0003H\u0082\u00010\u0016¢\u0006\u0003\b\u0085\u0001¢\u0006\u0003\u0010\u008b\u0001J9\u0010\u008c\u0001\u001a\u0003H\u0082\u0001\"\u0005\b\u0000\u0010\u0082\u00012\u0006\u0010\b\u001a\u00020\u00072\u001a\u0010\u0084\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u0003H\u0082\u00010\u0016¢\u0006\u0003\b\u0085\u0001¢\u0006\u0003\u0010\u008d\u0001JW\u0010\u008e\u0001\u001a\u0003H\u0082\u0001\"\u0005\b\u0000\u0010\u0082\u00012\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0090\u0001\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010\f2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\n2\u001a\u0010\u0084\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u0003H\u0082\u00010\u0016¢\u0006\u0003\b\u0085\u0001¢\u0006\u0003\u0010\u0093\u0001J'\u0010\u0094\u0001\u001a\u0003H\u0082\u0001\"\t\b\u0000\u0010\u0082\u0001*\u00020g*\u0003H\u0082\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u0018¢\u0006\u0003\u0010\u0096\u0001J'\u0010\u0097\u0001\u001a\u0003H\u0082\u0001\"\t\b\u0000\u0010\u0082\u0001*\u00020g*\u0003H\u0082\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u0018¢\u0006\u0003\u0010\u0096\u0001R\u001b\u0010\u001b\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f*\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R&\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0011\u0010>\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b?\u0010\u001fR\u001b\u0010@\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\bB\u0010\u001f*\u0004\bA\u0010\u001dR\u0013\u0010C\u001a\u0004\u0018\u00010D8F¢\u0006\u0006\u001a\u0004\bE\u0010FR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0011\u0010K\u001a\u00020L8F¢\u0006\u0006\u001a\u0004\bM\u0010NR \u0010O\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030P0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00030PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010R\u001a\u0004\u0018\u00010S8F¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0013\u0010V\u001a\u0004\u0018\u00010W8F¢\u0006\u0006\u001a\u0004\bX\u0010YR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b^\u0010*\"\u0004\b_\u0010,R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b`\u0010*\"\u0004\ba\u0010,R\u0011\u0010b\u001a\u00020c¢\u0006\b\n\u0000\u001a\u0004\bd\u0010e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u009a\u0001"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope;", "", "packageInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;", "tabControl", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;", "tabControlIndex", "", "tabIndex", "enclosingTabsComponentName", "", "enclosingTabsOrderedTabIds", "", "enclosingTabContextNamesById", "", "enclosingTabsDefaultTabIndexForInteraction", "countdownDate", "Ljava/util/Date;", "countFrom", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "countPredicates", "", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "", "countValues", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;ILjava/util/Date;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;Ljava/util/Map;Ljava/util/Map;)V", "applyTopWindowInsets", "getApplyTopWindowInsets$delegate", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope;)Ljava/lang/Object;", "getApplyTopWindowInsets", "()Z", "getCountFrom", "()Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "setCountFrom", "(Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;)V", "getCountdownDate", "()Ljava/util/Date;", "setCountdownDate", "(Ljava/util/Date;)V", "defaultTabIndex", "getDefaultTabIndex", "()Ljava/lang/Integer;", "setDefaultTabIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEnclosingTabContextNamesById", "()Ljava/util/Map;", "setEnclosingTabContextNamesById", "(Ljava/util/Map;)V", "getEnclosingTabsComponentName", "()Ljava/lang/String;", "setEnclosingTabsComponentName", "(Ljava/lang/String;)V", "getEnclosingTabsDefaultTabIndexForInteraction", "()I", "setEnclosingTabsDefaultTabIndexForInteraction", "(I)V", "getEnclosingTabsOrderedTabIds", "()Ljava/util/List;", "setEnclosingTabsOrderedTabIds", "(Ljava/util/List;)V", "heroImageDetected", "getHeroImageDetected", "ignoreTopWindowInsets", "getIgnoreTopWindowInsets$delegate", "getIgnoreTopWindowInsets", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getPackageInfo", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;", "setPackageInfo", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;)V", Keys.PACKAGES, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "getPackages", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "packagesByTab", "", "packagesOutsideTabs", "rcPackage", "Lcom/revenuecat/purchases/Package;", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getTabControl", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;", "setTabControl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;)V", "getTabControlIndex", "setTabControlIndex", "getTabIndex", "setTabIndex", "windowInsetsState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope$WindowInsetsState;", "getWindowInsetsState", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope$WindowInsetsState;", "applyTopWindowInsetsIfNotYetApplied", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", TypedValues.TransitionType.S_TO, "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;ILjava/util/Date;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;Ljava/util/Map;Ljava/util/Map;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope;", "equals", "other", "hashCode", "recordComponent", "", "component", "recordPackage", "pkg", "toString", "withCount", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope$WithCount;", ExifInterface.GPS_DIRECTION_TRUE, "predicate", "block", "Lkotlin/ExtensionFunctionType;", "withCountdown", "(Ljava/util/Date;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withSelectedScope", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withTabControl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withTabIndex", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withTabsInteractionContext", "tabsComponentName", "tabs", "Lcom/revenuecat/purchases/paywalls/components/TabsComponent$Tab;", "defaultTabId", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "applyBottomWindowInsetsIfNecessary", "shouldApply", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Z)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "applyHorizontalWindowInsetsIfNecessary", "WindowInsetsState", "WithCount", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    static final /* data */ class StyleFactoryScope {
        private CountdownComponent.CountFrom countFrom;
        private final Map<Integer, Function1<PaywallComponent, Boolean>> countPredicates;
        private final Map<Integer, Integer> countValues;
        private Date countdownDate;
        private Integer defaultTabIndex;
        private Map<String, String> enclosingTabContextNamesById;
        private String enclosingTabsComponentName;
        private int enclosingTabsDefaultTabIndexForInteraction;
        private List<String> enclosingTabsOrderedTabIds;
        private PaywallState.Loaded.Components.AvailablePackages.Info packageInfo;
        private final Map<Integer, List<PaywallState.Loaded.Components.AvailablePackages.Info>> packagesByTab;
        private final List<PaywallState.Loaded.Components.AvailablePackages.Info> packagesOutsideTabs;
        private TabControlStyle tabControl;
        private Integer tabControlIndex;
        private Integer tabIndex;
        private final WindowInsetsState windowInsetsState;

        public StyleFactoryScope() {
            this(null, null, null, null, null, null, null, 0, null, null, null, null, 4095, null);
        }

        private final Map<Integer, Function1<PaywallComponent, Boolean>> component11() {
            return this.countPredicates;
        }

        private final Map<Integer, Integer> component12() {
            return this.countValues;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StyleFactoryScope copy$default(StyleFactoryScope styleFactoryScope, PaywallState.Loaded.Components.AvailablePackages.Info info, TabControlStyle tabControlStyle, Integer num, Integer num2, String str, List list, Map map, int i, Date date, CountdownComponent.CountFrom countFrom, Map map2, Map map3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                info = styleFactoryScope.packageInfo;
            }
            if ((i2 & 2) != 0) {
                tabControlStyle = styleFactoryScope.tabControl;
            }
            if ((i2 & 4) != 0) {
                num = styleFactoryScope.tabControlIndex;
            }
            if ((i2 & 8) != 0) {
                num2 = styleFactoryScope.tabIndex;
            }
            if ((i2 & 16) != 0) {
                str = styleFactoryScope.enclosingTabsComponentName;
            }
            if ((i2 & 32) != 0) {
                list = styleFactoryScope.enclosingTabsOrderedTabIds;
            }
            if ((i2 & 64) != 0) {
                map = styleFactoryScope.enclosingTabContextNamesById;
            }
            if ((i2 & 128) != 0) {
                i = styleFactoryScope.enclosingTabsDefaultTabIndexForInteraction;
            }
            if ((i2 & 256) != 0) {
                date = styleFactoryScope.countdownDate;
            }
            if ((i2 & 512) != 0) {
                countFrom = styleFactoryScope.countFrom;
            }
            if ((i2 & 1024) != 0) {
                map2 = styleFactoryScope.countPredicates;
            }
            if ((i2 & 2048) != 0) {
                map3 = styleFactoryScope.countValues;
            }
            Map map4 = map2;
            Map map5 = map3;
            Date date2 = date;
            CountdownComponent.CountFrom countFrom2 = countFrom;
            Map map6 = map;
            int i3 = i;
            String str2 = str;
            List list2 = list;
            return styleFactoryScope.copy(info, tabControlStyle, num, num2, str2, list2, map6, i3, date2, countFrom2, map4, map5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PaywallState.Loaded.Components.AvailablePackages.Info getPackageInfo() {
            return this.packageInfo;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final CountdownComponent.CountFrom getCountFrom() {
            return this.countFrom;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final TabControlStyle getTabControl() {
            return this.tabControl;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getTabControlIndex() {
            return this.tabControlIndex;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getTabIndex() {
            return this.tabIndex;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getEnclosingTabsComponentName() {
            return this.enclosingTabsComponentName;
        }

        public final List<String> component6() {
            return this.enclosingTabsOrderedTabIds;
        }

        public final Map<String, String> component7() {
            return this.enclosingTabContextNamesById;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getEnclosingTabsDefaultTabIndexForInteraction() {
            return this.enclosingTabsDefaultTabIndexForInteraction;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Date getCountdownDate() {
            return this.countdownDate;
        }

        public final StyleFactoryScope copy(PaywallState.Loaded.Components.AvailablePackages.Info packageInfo, TabControlStyle tabControl, Integer tabControlIndex, Integer tabIndex, String enclosingTabsComponentName, List<String> enclosingTabsOrderedTabIds, Map<String, String> enclosingTabContextNamesById, int enclosingTabsDefaultTabIndexForInteraction, Date countdownDate, CountdownComponent.CountFrom countFrom, Map<Integer, Function1<PaywallComponent, Boolean>> countPredicates, Map<Integer, Integer> countValues) {
            Intrinsics.checkNotNullParameter(enclosingTabsOrderedTabIds, "enclosingTabsOrderedTabIds");
            Intrinsics.checkNotNullParameter(enclosingTabContextNamesById, "enclosingTabContextNamesById");
            Intrinsics.checkNotNullParameter(countFrom, "countFrom");
            Intrinsics.checkNotNullParameter(countPredicates, "countPredicates");
            Intrinsics.checkNotNullParameter(countValues, "countValues");
            return new StyleFactoryScope(packageInfo, tabControl, tabControlIndex, tabIndex, enclosingTabsComponentName, enclosingTabsOrderedTabIds, enclosingTabContextNamesById, enclosingTabsDefaultTabIndexForInteraction, countdownDate, countFrom, countPredicates, countValues);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StyleFactoryScope)) {
                return false;
            }
            StyleFactoryScope styleFactoryScope = (StyleFactoryScope) other;
            return Intrinsics.areEqual(this.packageInfo, styleFactoryScope.packageInfo) && Intrinsics.areEqual(this.tabControl, styleFactoryScope.tabControl) && Intrinsics.areEqual(this.tabControlIndex, styleFactoryScope.tabControlIndex) && Intrinsics.areEqual(this.tabIndex, styleFactoryScope.tabIndex) && Intrinsics.areEqual(this.enclosingTabsComponentName, styleFactoryScope.enclosingTabsComponentName) && Intrinsics.areEqual(this.enclosingTabsOrderedTabIds, styleFactoryScope.enclosingTabsOrderedTabIds) && Intrinsics.areEqual(this.enclosingTabContextNamesById, styleFactoryScope.enclosingTabContextNamesById) && this.enclosingTabsDefaultTabIndexForInteraction == styleFactoryScope.enclosingTabsDefaultTabIndexForInteraction && Intrinsics.areEqual(this.countdownDate, styleFactoryScope.countdownDate) && this.countFrom == styleFactoryScope.countFrom && Intrinsics.areEqual(this.countPredicates, styleFactoryScope.countPredicates) && Intrinsics.areEqual(this.countValues, styleFactoryScope.countValues);
        }

        public int hashCode() {
            PaywallState.Loaded.Components.AvailablePackages.Info info = this.packageInfo;
            int iHashCode = (info == null ? 0 : info.hashCode()) * 31;
            TabControlStyle tabControlStyle = this.tabControl;
            int iHashCode2 = (iHashCode + (tabControlStyle == null ? 0 : tabControlStyle.hashCode())) * 31;
            Integer num = this.tabControlIndex;
            int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.tabIndex;
            int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str = this.enclosingTabsComponentName;
            int iHashCode5 = (((((((iHashCode4 + (str == null ? 0 : str.hashCode())) * 31) + this.enclosingTabsOrderedTabIds.hashCode()) * 31) + this.enclosingTabContextNamesById.hashCode()) * 31) + Integer.hashCode(this.enclosingTabsDefaultTabIndexForInteraction)) * 31;
            Date date = this.countdownDate;
            return ((((((iHashCode5 + (date != null ? date.hashCode() : 0)) * 31) + this.countFrom.hashCode()) * 31) + this.countPredicates.hashCode()) * 31) + this.countValues.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("StyleFactoryScope(packageInfo=");
            sb.append(this.packageInfo).append(", tabControl=").append(this.tabControl).append(", tabControlIndex=").append(this.tabControlIndex).append(", tabIndex=").append(this.tabIndex).append(", enclosingTabsComponentName=").append(this.enclosingTabsComponentName).append(", enclosingTabsOrderedTabIds=").append(this.enclosingTabsOrderedTabIds).append(", enclosingTabContextNamesById=").append(this.enclosingTabContextNamesById).append(", enclosingTabsDefaultTabIndexForInteraction=").append(this.enclosingTabsDefaultTabIndexForInteraction).append(", countdownDate=").append(this.countdownDate).append(", countFrom=").append(this.countFrom).append(", countPredicates=").append(this.countPredicates).append(", countValues=");
            sb.append(this.countValues).append(')');
            return sb.toString();
        }

        public StyleFactoryScope(PaywallState.Loaded.Components.AvailablePackages.Info info, TabControlStyle tabControlStyle, Integer num, Integer num2, String str, List<String> enclosingTabsOrderedTabIds, Map<String, String> enclosingTabContextNamesById, int i, Date date, CountdownComponent.CountFrom countFrom, Map<Integer, Function1<PaywallComponent, Boolean>> countPredicates, Map<Integer, Integer> countValues) {
            Intrinsics.checkNotNullParameter(enclosingTabsOrderedTabIds, "enclosingTabsOrderedTabIds");
            Intrinsics.checkNotNullParameter(enclosingTabContextNamesById, "enclosingTabContextNamesById");
            Intrinsics.checkNotNullParameter(countFrom, "countFrom");
            Intrinsics.checkNotNullParameter(countPredicates, "countPredicates");
            Intrinsics.checkNotNullParameter(countValues, "countValues");
            this.packageInfo = info;
            this.tabControl = tabControlStyle;
            this.tabControlIndex = num;
            this.tabIndex = num2;
            this.enclosingTabsComponentName = str;
            this.enclosingTabsOrderedTabIds = enclosingTabsOrderedTabIds;
            this.enclosingTabContextNamesById = enclosingTabContextNamesById;
            this.enclosingTabsDefaultTabIndexForInteraction = i;
            this.countdownDate = date;
            this.countFrom = countFrom;
            this.countPredicates = countPredicates;
            this.countValues = countValues;
            this.windowInsetsState = new WindowInsetsState();
            this.packagesOutsideTabs = new ArrayList();
            this.packagesByTab = new LinkedHashMap();
        }

        public final PaywallState.Loaded.Components.AvailablePackages.Info getPackageInfo() {
            return this.packageInfo;
        }

        public final void setPackageInfo(PaywallState.Loaded.Components.AvailablePackages.Info info) {
            this.packageInfo = info;
        }

        public final TabControlStyle getTabControl() {
            return this.tabControl;
        }

        public final void setTabControl(TabControlStyle tabControlStyle) {
            this.tabControl = tabControlStyle;
        }

        public final Integer getTabControlIndex() {
            return this.tabControlIndex;
        }

        public final void setTabControlIndex(Integer num) {
            this.tabControlIndex = num;
        }

        public final Integer getTabIndex() {
            return this.tabIndex;
        }

        public final void setTabIndex(Integer num) {
            this.tabIndex = num;
        }

        public final String getEnclosingTabsComponentName() {
            return this.enclosingTabsComponentName;
        }

        public final void setEnclosingTabsComponentName(String str) {
            this.enclosingTabsComponentName = str;
        }

        public /* synthetic */ StyleFactoryScope(PaywallState.Loaded.Components.AvailablePackages.Info info, TabControlStyle tabControlStyle, Integer num, Integer num2, String str, List list, Map map, int i, Date date, CountdownComponent.CountFrom countFrom, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : info, (i2 & 2) != 0 ? null : tabControlStyle, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list, (i2 & 64) != 0 ? MapsKt.emptyMap() : map, (i2 & 128) != 0 ? 0 : i, (i2 & 256) != 0 ? null : date, (i2 & 512) != 0 ? CountdownComponent.CountFrom.DAYS : countFrom, (i2 & 1024) != 0 ? new LinkedHashMap() : linkedHashMap, (i2 & 2048) != 0 ? new LinkedHashMap() : linkedHashMap2);
        }

        public final List<String> getEnclosingTabsOrderedTabIds() {
            return this.enclosingTabsOrderedTabIds;
        }

        public final void setEnclosingTabsOrderedTabIds(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.enclosingTabsOrderedTabIds = list;
        }

        public final Map<String, String> getEnclosingTabContextNamesById() {
            return this.enclosingTabContextNamesById;
        }

        public final void setEnclosingTabContextNamesById(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.enclosingTabContextNamesById = map;
        }

        public final int getEnclosingTabsDefaultTabIndexForInteraction() {
            return this.enclosingTabsDefaultTabIndexForInteraction;
        }

        public final void setEnclosingTabsDefaultTabIndexForInteraction(int i) {
            this.enclosingTabsDefaultTabIndexForInteraction = i;
        }

        public final Date getCountdownDate() {
            return this.countdownDate;
        }

        public final void setCountdownDate(Date date) {
            this.countdownDate = date;
        }

        public final CountdownComponent.CountFrom getCountFrom() {
            return this.countFrom;
        }

        public final void setCountFrom(CountdownComponent.CountFrom countFrom) {
            Intrinsics.checkNotNullParameter(countFrom, "<set-?>");
            this.countFrom = countFrom;
        }

        /* JADX INFO: compiled from: StyleFactory.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope$WithCount;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "count", "", "(Ljava/lang/Object;I)V", "getCount", "()I", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/Object;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope$WithCount;", "equals", "", "other", "hashCode", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class WithCount<T> {
            public static final int $stable = 0;
            private final int count;
            private final T value;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ WithCount copy$default(WithCount withCount, Object obj, int i, int i2, Object obj2) {
                if ((i2 & 1) != 0) {
                    obj = withCount.value;
                }
                if ((i2 & 2) != 0) {
                    i = withCount.count;
                }
                return withCount.copy(obj, i);
            }

            public final T component1() {
                return this.value;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            public final WithCount<T> copy(T value, int count) {
                return new WithCount<>(value, count);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof WithCount)) {
                    return false;
                }
                WithCount withCount = (WithCount) other;
                return Intrinsics.areEqual(this.value, withCount.value) && this.count == withCount.count;
            }

            public int hashCode() {
                T t = this.value;
                return ((t == null ? 0 : t.hashCode()) * 31) + Integer.hashCode(this.count);
            }

            public String toString() {
                return "WithCount(value=" + this.value + ", count=" + this.count + ')';
            }

            public WithCount(T t, int i) {
                this.value = t;
                this.count = i;
            }

            public final T getValue() {
                return this.value;
            }

            public final int getCount() {
                return this.count;
            }
        }

        /* JADX INFO: compiled from: StyleFactory.kt */
        @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017R\u001c\u0010\u0003\u001a\u00020\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u0018\u0010\u0013\u001a\u00020\u0004*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0004*\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018¨\u0006\u001c"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleFactoryScope$WindowInsetsState;", "", "()V", "applyTopWindowInsets", "", "getApplyTopWindowInsets", "()Z", "setApplyTopWindowInsets", "(Z)V", "heroImageDetected", "getHeroImageDetected", "setHeroImageDetected", "ignoreTopWindowInsets", "getIgnoreTopWindowInsets", "setIgnoreTopWindowInsets", "stillLookingForHeaderMedia", "topWindowInsetsApplied", "getTopWindowInsetsApplied", "setTopWindowInsetsApplied", "isFill", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "(Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;)Z", "isHeaderMedia", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "(Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;)Z", "handleHeaderMediaViewWindowInsets", "", "component", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        private static final class WindowInsetsState {
            private boolean applyTopWindowInsets;
            private boolean heroImageDetected;
            private boolean ignoreTopWindowInsets;
            private boolean stillLookingForHeaderMedia = true;
            private boolean topWindowInsetsApplied;

            public final void setApplyTopWindowInsets(boolean z) {
                this.applyTopWindowInsets = z;
            }

            public final boolean getApplyTopWindowInsets() {
                boolean z = this.applyTopWindowInsets;
                this.applyTopWindowInsets = false;
                return z;
            }

            public final void setIgnoreTopWindowInsets(boolean z) {
                this.ignoreTopWindowInsets = z;
            }

            public final boolean getIgnoreTopWindowInsets() {
                boolean z = this.ignoreTopWindowInsets;
                this.ignoreTopWindowInsets = false;
                return z;
            }

            public final boolean getTopWindowInsetsApplied() {
                return this.topWindowInsetsApplied;
            }

            public final void setTopWindowInsetsApplied(boolean z) {
                this.topWindowInsetsApplied = z;
            }

            public final boolean getHeroImageDetected() {
                return this.heroImageDetected;
            }

            public final void setHeroImageDetected(boolean z) {
                this.heroImageDetected = z;
            }

            public final void handleHeaderMediaViewWindowInsets(PaywallComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                boolean z = false;
                if (!(component instanceof StackComponent)) {
                    if (component instanceof ImageComponent ? true : component instanceof VideoComponent ? true : component instanceof WebViewComponent) {
                        if (this.stillLookingForHeaderMedia) {
                            boolean zIsHeaderMedia = isHeaderMedia(component);
                            this.ignoreTopWindowInsets = zIsHeaderMedia;
                            this.heroImageDetected = zIsHeaderMedia;
                        }
                        this.stillLookingForHeaderMedia = false;
                        return;
                    }
                    if (component instanceof FallbackHeaderComponent) {
                        return;
                    }
                    this.stillLookingForHeaderMedia = false;
                    return;
                }
                if (this.stillLookingForHeaderMedia) {
                    StackComponent stackComponent = (StackComponent) component;
                    Dimension dimension = stackComponent.getDimension();
                    if (dimension instanceof Dimension.ZLayer) {
                        PaywallComponent paywallComponent = (PaywallComponent) CollectionsKt.firstOrNull(stackComponent.getComponents());
                        if (paywallComponent != null && isHeaderMedia(paywallComponent)) {
                            z = true;
                        }
                        this.topWindowInsetsApplied = z;
                        this.heroImageDetected = z;
                    } else {
                        if (!(dimension instanceof Dimension.Horizontal ? true : dimension instanceof Dimension.Vertical)) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    this.applyTopWindowInsets = z;
                }
            }

            private final boolean isHeaderMedia(PaywallComponent paywallComponent) {
                if (paywallComponent instanceof ImageComponent) {
                    return isFill(((ImageComponent) paywallComponent).getSize().getWidth());
                }
                if (paywallComponent instanceof VideoComponent) {
                    return isFill(((VideoComponent) paywallComponent).getSize().getWidth());
                }
                if (paywallComponent instanceof WebViewComponent) {
                    return isFill(((WebViewComponent) paywallComponent).getSize().getWidth());
                }
                return false;
            }

            private final boolean isFill(SizeConstraint sizeConstraint) {
                if (sizeConstraint instanceof SizeConstraint.Fill) {
                    return true;
                }
                if (sizeConstraint instanceof SizeConstraint.Fit ? true : sizeConstraint instanceof SizeConstraint.Fixed) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        public final WindowInsetsState getWindowInsetsState() {
            return this.windowInsetsState;
        }

        public final boolean getApplyTopWindowInsets() {
            return this.windowInsetsState.getApplyTopWindowInsets();
        }

        public final boolean getIgnoreTopWindowInsets() {
            return this.windowInsetsState.getIgnoreTopWindowInsets();
        }

        public final boolean getHeroImageDetected() {
            return this.windowInsetsState.getHeroImageDetected();
        }

        public final Integer getDefaultTabIndex() {
            return this.defaultTabIndex;
        }

        public final void setDefaultTabIndex(Integer num) {
            this.defaultTabIndex = num;
        }

        public final Package getRcPackage() {
            PaywallState.Loaded.Components.AvailablePackages.Info info = this.packageInfo;
            if (info != null) {
                return info.getPkg();
            }
            return null;
        }

        public final ResolvedOffer getResolvedOffer() {
            PaywallState.Loaded.Components.AvailablePackages.Info info = this.packageInfo;
            if (info != null) {
                return info.getResolvedOffer();
            }
            return null;
        }

        public final OfferEligibility getOfferEligibility() {
            PaywallState.Loaded.Components.AvailablePackages.Info info = this.packageInfo;
            if (info != null) {
                return PackageExtensionsKt.calculateOfferEligibility(info.getResolvedOffer(), info.getPkg());
            }
            return null;
        }

        public final PaywallState.Loaded.Components.AvailablePackages getPackages() {
            return new PaywallState.Loaded.Components.AvailablePackages(this.packagesOutsideTabs, this.packagesByTab);
        }

        public final <T> T withSelectedScope(PaywallState.Loaded.Components.AvailablePackages.Info packageInfo, Integer tabControlIndex, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            if (packageInfo != null) {
                recordPackage(packageInfo);
            }
            StyleFactoryScope styleFactoryScopeCopy$default = copy$default(this, null, null, null, null, null, null, null, 0, null, null, null, null, 4095, null);
            this.packageInfo = packageInfo;
            this.tabControlIndex = tabControlIndex;
            T tInvoke = block.invoke(this);
            this.packageInfo = styleFactoryScopeCopy$default.packageInfo;
            this.tabControlIndex = styleFactoryScopeCopy$default.tabControlIndex;
            return tInvoke;
        }

        public final <T> T withTabControl(TabControlStyle tabControl, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(tabControl, "tabControl");
            Intrinsics.checkNotNullParameter(block, "block");
            StyleFactoryScope styleFactoryScopeCopy$default = copy$default(this, null, null, null, null, null, null, null, 0, null, null, null, null, 4095, null);
            this.tabControl = tabControl;
            T tInvoke = block.invoke(this);
            this.tabControl = styleFactoryScopeCopy$default.tabControl;
            return tInvoke;
        }

        public final <T> T withTabIndex(int tabIndex, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            StyleFactoryScope styleFactoryScopeCopy$default = copy$default(this, null, null, null, null, null, null, null, 0, null, null, null, null, 4095, null);
            this.tabIndex = Integer.valueOf(tabIndex);
            T tInvoke = block.invoke(this);
            this.tabIndex = styleFactoryScopeCopy$default.tabIndex;
            return tInvoke;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <T> T withTabsInteractionContext(String tabsComponentName, List<TabsComponent.Tab> tabs, String defaultTabId, Function1<? super StyleFactoryScope, ? extends T> block) {
            Pair pairM1606to;
            Intrinsics.checkNotNullParameter(tabs, "tabs");
            Intrinsics.checkNotNullParameter(block, "block");
            String str = this.enclosingTabsComponentName;
            List<String> list = this.enclosingTabsOrderedTabIds;
            Map<String, String> map = this.enclosingTabContextNamesById;
            int i = this.enclosingTabsDefaultTabIndexForInteraction;
            if (tabsComponentName == null || StringsKt.isBlank(tabsComponentName)) {
                tabsComponentName = null;
            }
            this.enclosingTabsComponentName = tabsComponentName;
            List<TabsComponent.Tab> list2 = tabs;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((TabsComponent.Tab) it.next()).getId());
            }
            this.enclosingTabsOrderedTabIds = arrayList;
            ArrayList arrayList2 = new ArrayList();
            for (TabsComponent.Tab tab : list2) {
                String name = tab.getName();
                if (name == null) {
                    pairM1606to = null;
                } else {
                    if (StringsKt.isBlank(name)) {
                        name = null;
                    }
                    if (name != null) {
                        pairM1606to = TuplesKt.m1606to(tab.getId(), name);
                    }
                }
                if (pairM1606to != null) {
                    arrayList2.add(pairM1606to);
                }
            }
            this.enclosingTabContextNamesById = MapsKt.toMap(arrayList2);
            int iIntValue = 0;
            if (defaultTabId != null) {
                if (StringsKt.isBlank(defaultTabId)) {
                    defaultTabId = null;
                }
                if (defaultTabId != null) {
                    Iterator<TabsComponent.Tab> it2 = tabs.iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            i2 = -1;
                            break;
                        }
                        if (Intrinsics.areEqual(it2.next().getId(), defaultTabId)) {
                            break;
                        }
                        i2++;
                    }
                    Integer numValueOf = Integer.valueOf(i2);
                    Integer num = numValueOf.intValue() != -1 ? numValueOf : null;
                    if (num != null) {
                        iIntValue = num.intValue();
                    }
                }
            }
            this.enclosingTabsDefaultTabIndexForInteraction = iIntValue;
            try {
                return block.invoke(this);
            } finally {
                this.enclosingTabsComponentName = str;
                this.enclosingTabsOrderedTabIds = list;
                this.enclosingTabContextNamesById = map;
                this.enclosingTabsDefaultTabIndexForInteraction = i;
            }
        }

        public final <T> T withCountdown(Date countdownDate, CountdownComponent.CountFrom countFrom, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(countdownDate, "countdownDate");
            Intrinsics.checkNotNullParameter(countFrom, "countFrom");
            Intrinsics.checkNotNullParameter(block, "block");
            StyleFactoryScope styleFactoryScopeCopy$default = copy$default(this, null, null, null, null, null, null, null, 0, null, null, null, null, 4095, null);
            this.countdownDate = countdownDate;
            this.countFrom = countFrom;
            T tInvoke = block.invoke(this);
            this.countdownDate = styleFactoryScopeCopy$default.countdownDate;
            this.countFrom = styleFactoryScopeCopy$default.countFrom;
            return tInvoke;
        }

        public final <T> WithCount<T> withCount(Function1<? super PaywallComponent, Boolean> predicate, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            Intrinsics.checkNotNullParameter(block, "block");
            Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) this.countPredicates.keySet());
            int iIntValue = (num != null ? num.intValue() : -1) + 1;
            this.countPredicates.put(Integer.valueOf(iIntValue), predicate);
            this.countValues.put(Integer.valueOf(iIntValue), 0);
            WithCount<T> withCount = new WithCount<>(block.invoke(this), ((Number) MapsKt.getValue(this.countValues, Integer.valueOf(iIntValue))).intValue());
            this.countPredicates.remove(Integer.valueOf(iIntValue));
            this.countValues.remove(Integer.valueOf(iIntValue));
            return withCount;
        }

        public final void recordComponent(PaywallComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            for (Map.Entry<Integer, Function1<PaywallComponent, Boolean>> entry : this.countPredicates.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                if (entry.getValue().invoke(component).booleanValue()) {
                    Integer num = this.countValues.get(Integer.valueOf(iIntValue));
                    this.countValues.put(Integer.valueOf(iIntValue), Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                }
            }
            this.windowInsetsState.handleHeaderMediaViewWindowInsets(component);
        }

        public final ComponentStyle applyTopWindowInsetsIfNotYetApplied(ComponentStyle to) {
            Intrinsics.checkNotNullParameter(to, "to");
            if (to instanceof StackComponentStyle) {
                return StackComponentStyle.m14004copyh6c5tkY$default((StackComponentStyle) to, null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, !this.windowInsetsState.getTopWindowInsetsApplied(), false, false, false, 15728639, null);
            }
            if (!(to instanceof HeaderComponentStyle)) {
                return to;
            }
            HeaderComponentStyle headerComponentStyle = (HeaderComponentStyle) to;
            return headerComponentStyle.copy(StackComponentStyle.m14004copyh6c5tkY$default(headerComponentStyle.getStackComponentStyle(), null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, !this.windowInsetsState.getTopWindowInsetsApplied(), true, false, false, 13631487, null));
        }

        public final <T extends ComponentStyle> T applyBottomWindowInsetsIfNecessary(T t, boolean z) {
            StickyFooterComponentStyle stickyFooterComponentStyleCopy = t;
            Intrinsics.checkNotNullParameter(stickyFooterComponentStyleCopy, "<this>");
            if (z) {
                if (stickyFooterComponentStyleCopy instanceof StackComponentStyle) {
                    stickyFooterComponentStyleCopy = StackComponentStyle.m14004copyh6c5tkY$default((StackComponentStyle) stickyFooterComponentStyleCopy, null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, true, false, 12582911, null);
                } else if (stickyFooterComponentStyleCopy instanceof StickyFooterComponentStyle) {
                    StickyFooterComponentStyle stickyFooterComponentStyle = (StickyFooterComponentStyle) stickyFooterComponentStyleCopy;
                    stickyFooterComponentStyleCopy = stickyFooterComponentStyle.copy(StackComponentStyle.m14004copyh6c5tkY$default(stickyFooterComponentStyle.getStackComponentStyle(), null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, true, false, 12582911, null));
                }
                Intrinsics.checkNotNull(stickyFooterComponentStyleCopy, "null cannot be cast to non-null type T of com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.StyleFactoryScope.applyBottomWindowInsetsIfNecessary");
            }
            return stickyFooterComponentStyleCopy;
        }

        public final <T extends ComponentStyle> T applyHorizontalWindowInsetsIfNecessary(T t, boolean z) {
            HeaderComponentStyle headerComponentStyleCopy = t;
            Intrinsics.checkNotNullParameter(headerComponentStyleCopy, "<this>");
            if (z) {
                if (headerComponentStyleCopy instanceof StackComponentStyle) {
                    headerComponentStyleCopy = StackComponentStyle.m14004copyh6c5tkY$default((StackComponentStyle) headerComponentStyleCopy, null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, true, GroupFlagsSpec.CHILD_NODE_COUNT_MASK, null);
                } else if (headerComponentStyleCopy instanceof StickyFooterComponentStyle) {
                    StickyFooterComponentStyle stickyFooterComponentStyle = (StickyFooterComponentStyle) headerComponentStyleCopy;
                    headerComponentStyleCopy = stickyFooterComponentStyle.copy(StackComponentStyle.m14004copyh6c5tkY$default(stickyFooterComponentStyle.getStackComponentStyle(), null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, true, GroupFlagsSpec.CHILD_NODE_COUNT_MASK, null));
                } else if (headerComponentStyleCopy instanceof HeaderComponentStyle) {
                    HeaderComponentStyle headerComponentStyle = (HeaderComponentStyle) headerComponentStyleCopy;
                    headerComponentStyleCopy = headerComponentStyle.copy(StackComponentStyle.m14004copyh6c5tkY$default(headerComponentStyle.getStackComponentStyle(), null, null, false, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, true, GroupFlagsSpec.CHILD_NODE_COUNT_MASK, null));
                }
                Intrinsics.checkNotNull(headerComponentStyleCopy, "null cannot be cast to non-null type T of com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.StyleFactoryScope.applyHorizontalWindowInsetsIfNecessary");
            }
            return headerComponentStyleCopy;
        }

        private final void recordPackage(PaywallState.Loaded.Components.AvailablePackages.Info pkg) {
            Integer num = this.tabIndex;
            if (num == null) {
                this.packagesOutsideTabs.add(pkg);
                return;
            }
            Map<Integer, List<PaywallState.Loaded.Components.AvailablePackages.Info>> map = this.packagesByTab;
            ArrayList arrayList = map.get(num);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(num, arrayList);
            }
            arrayList.add(pkg);
        }
    }

    /* JADX INFO: compiled from: StyleFactory.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StyleFactory$StyleResult;", "", "componentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "availablePackages", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "defaultTabIndex", "", "heroImageDetected", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;Ljava/lang/Integer;Z)V", "getAvailablePackages", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "getComponentStyle", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "getDefaultTabIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeroImageDetected", "()Z", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class StyleResult {
        public static final int $stable = 0;
        private final PaywallState.Loaded.Components.AvailablePackages availablePackages;
        private final ComponentStyle componentStyle;
        private final Integer defaultTabIndex;
        private final boolean heroImageDetected;

        public StyleResult(ComponentStyle componentStyle, PaywallState.Loaded.Components.AvailablePackages availablePackages, Integer num, boolean z) {
            Intrinsics.checkNotNullParameter(componentStyle, "componentStyle");
            Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
            this.componentStyle = componentStyle;
            this.availablePackages = availablePackages;
            this.defaultTabIndex = num;
            this.heroImageDetected = z;
        }

        public /* synthetic */ StyleResult(ComponentStyle componentStyle, PaywallState.Loaded.Components.AvailablePackages availablePackages, Integer num, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(componentStyle, availablePackages, num, (i & 8) != 0 ? false : z);
        }

        public final ComponentStyle getComponentStyle() {
            return this.componentStyle;
        }

        public final PaywallState.Loaded.Components.AvailablePackages getAvailablePackages() {
            return this.availablePackages;
        }

        public final Integer getDefaultTabIndex() {
            return this.defaultTabIndex;
        }

        public final boolean getHeroImageDetected() {
            return this.heroImageDetected;
        }
    }

    public static /* synthetic */ Result create$default(StyleFactory styleFactory, PaywallComponent paywallComponent, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            z3 = false;
        }
        return styleFactory.create(paywallComponent, z, z2, z3);
    }

    public final Result<StyleResult, NonEmptyList<PaywallValidationError>> create(PaywallComponent component, boolean applyTopWindowInsets, boolean applyBottomWindowInsets, boolean applyHorizontalWindowInsets) {
        Intrinsics.checkNotNullParameter(component, "component");
        StyleFactoryScope styleFactoryScope = new StyleFactoryScope(null, null, null, null, null, null, null, 0, null, null, null, null, 4095, null);
        Result.Error errorCreateInternal = createInternal(styleFactoryScope, component);
        if (errorCreateInternal instanceof Result.Success) {
            ComponentStyle componentStyle = (ComponentStyle) ((Result.Success) errorCreateInternal).getValue();
            if (componentStyle != null) {
                errorCreateInternal = new Result.Success(componentStyle);
            } else {
                errorCreateInternal = new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.RootComponentUnsupportedProperties(component), new PaywallValidationError.RootComponentUnsupportedProperties[0]));
            }
        } else if (!(errorCreateInternal instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (errorCreateInternal instanceof Result.Success) {
            ComponentStyle componentStyleApplyTopWindowInsetsIfNotYetApplied = (ComponentStyle) ((Result.Success) errorCreateInternal).getValue();
            if (applyTopWindowInsets) {
                componentStyleApplyTopWindowInsetsIfNotYetApplied = styleFactoryScope.applyTopWindowInsetsIfNotYetApplied(componentStyleApplyTopWindowInsetsIfNotYetApplied);
            }
            errorCreateInternal = new Result.Success(componentStyleApplyTopWindowInsetsIfNotYetApplied);
        } else if (!(errorCreateInternal instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (errorCreateInternal instanceof Result.Success) {
            errorCreateInternal = new Result.Success(styleFactoryScope.applyBottomWindowInsetsIfNecessary((ComponentStyle) ((Result.Success) errorCreateInternal).getValue(), applyBottomWindowInsets));
        } else if (!(errorCreateInternal instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (errorCreateInternal instanceof Result.Success) {
            errorCreateInternal = new Result.Success(styleFactoryScope.applyHorizontalWindowInsetsIfNecessary((ComponentStyle) ((Result.Success) errorCreateInternal).getValue(), applyHorizontalWindowInsets));
        } else if (!(errorCreateInternal instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (errorCreateInternal instanceof Result.Success) {
            return new Result.Success(new StyleResult((ComponentStyle) ((Result.Success) errorCreateInternal).getValue(), styleFactoryScope.getPackages(), styleFactoryScope.getDefaultTabIndex(), styleFactoryScope.getHeroImageDetected()));
        }
        if (errorCreateInternal instanceof Result.Error) {
            return errorCreateInternal;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<ComponentStyle, NonEmptyList<PaywallValidationError>> createInternal(StyleFactoryScope styleFactoryScope, PaywallComponent paywallComponent) {
        styleFactoryScope.recordComponent(paywallComponent);
        if (paywallComponent instanceof ButtonComponent) {
            return createButtonComponentStyleOrNull(styleFactoryScope, (ButtonComponent) paywallComponent);
        }
        if (paywallComponent instanceof ImageComponent) {
            return createImageComponentStyle(styleFactoryScope, (ImageComponent) paywallComponent);
        }
        if (paywallComponent instanceof PackageComponent) {
            return createPackageComponentStyle(styleFactoryScope, (PackageComponent) paywallComponent);
        }
        if (paywallComponent instanceof PurchaseButtonComponent) {
            return createPurchaseButtonComponentStyle(styleFactoryScope, (PurchaseButtonComponent) paywallComponent);
        }
        if (paywallComponent instanceof StackComponent) {
            return createStackComponentStyle(styleFactoryScope, (StackComponent) paywallComponent);
        }
        if (paywallComponent instanceof HeaderComponent) {
            return createHeaderComponentStyle(styleFactoryScope, (HeaderComponent) paywallComponent);
        }
        if (paywallComponent instanceof StickyFooterComponent) {
            return createStickyFooterComponentStyle(styleFactoryScope, (StickyFooterComponent) paywallComponent);
        }
        if (paywallComponent instanceof TextComponent) {
            return createTextComponentStyle(styleFactoryScope, (TextComponent) paywallComponent);
        }
        if (paywallComponent instanceof IconComponent) {
            return createIconComponentStyle(styleFactoryScope, (IconComponent) paywallComponent);
        }
        if (paywallComponent instanceof TimelineComponent) {
            return createTimelineComponentStyle(styleFactoryScope, (TimelineComponent) paywallComponent);
        }
        if (paywallComponent instanceof CarouselComponent) {
            return createCarouselComponentStyle(styleFactoryScope, (CarouselComponent) paywallComponent);
        }
        if (paywallComponent instanceof TabControlButtonComponent) {
            return createTabControlButtonComponentStyle(styleFactoryScope, (TabControlButtonComponent) paywallComponent);
        }
        if (paywallComponent instanceof TabControlToggleComponent) {
            return createTabControlToggleComponentStyle(styleFactoryScope, (TabControlToggleComponent) paywallComponent);
        }
        if (paywallComponent instanceof TabControlComponent) {
            return ResultKt.errorIfNull(styleFactoryScope.getTabControl(), NonEmptyListKt.nonEmptyListOf(PaywallValidationError.TabControlNotInTab.INSTANCE, new PaywallValidationError.TabControlNotInTab[0]));
        }
        if (paywallComponent instanceof TabsComponent) {
            return createTabsComponentStyle(styleFactoryScope, (TabsComponent) paywallComponent);
        }
        if (paywallComponent instanceof VideoComponent) {
            return createVideoComponentStyle(styleFactoryScope, (VideoComponent) paywallComponent);
        }
        if (paywallComponent instanceof FallbackHeaderComponent) {
            return new Result.Success(null);
        }
        if (paywallComponent instanceof WebViewComponent) {
            return createWebViewComponentStyle(styleFactoryScope, (WebViewComponent) paywallComponent);
        }
        if (paywallComponent instanceof CountdownComponent) {
            return createCountdownComponentStyle(styleFactoryScope, (CountdownComponent) paywallComponent);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<WebViewComponentStyle, NonEmptyList<PaywallValidationError>> createWebViewComponentStyle(StyleFactoryScope styleFactoryScope, WebViewComponent webViewComponent) {
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(webViewComponent.getOverrides(), this.stripRules, new Function1<PartialWebViewComponent, Result<? extends PresentedWebViewPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createWebViewComponentStyle.1
            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedWebViewPartial, NonEmptyList<PaywallValidationError>> invoke(PartialWebViewComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return new Result.Success(new PresentedWebViewPartial(partial));
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (presentedOverrides instanceof Result.Error) {
                presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (presentedOverrides instanceof Result.Success) {
            List list = (List) ((Result.Success) presentedOverrides).getValue();
            String url = webViewComponent.getUrl();
            Boolean visible = webViewComponent.getVisible();
            return new Result.Success(new WebViewComponentStyle(url, visible != null ? visible.booleanValue() : true, webViewComponent.getSize(), webViewComponent.getId(), list, styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), styleFactoryScope.getIgnoreTopWindowInsets()));
        }
        if (presentedOverrides instanceof Result.Error) {
            return presentedOverrides;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<CountdownComponentStyle, NonEmptyList<PaywallValidationError>> createCountdownComponentStyle(StyleFactoryScope styleFactoryScope, final CountdownComponent countdownComponent) {
        return (Result) styleFactoryScope.withCountdown(countdownComponent.getStyle().getDate(), countdownComponent.getCountFrom(), new Function1<StyleFactoryScope, Result<? extends CountdownComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createCountdownComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<CountdownComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withCountdown) {
                Intrinsics.checkNotNullParameter(withCountdown, "$this$withCountdown");
                Result resultCreateStackComponentStyle = StyleFactory.this.createStackComponentStyle(withCountdown, countdownComponent.getCountdownStack());
                StackComponent endStack = countdownComponent.getEndStack();
                Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(endStack != null ? StyleFactory.this.createStackComponentStyle(withCountdown, endStack) : null);
                StackComponent fallback = countdownComponent.getFallback();
                Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(fallback != null ? StyleFactory.this.createStackComponentStyle(withCountdown, fallback) : null);
                CountdownComponent countdownComponent2 = countdownComponent;
                Result.Success success = new Result.Success(Unit.INSTANCE);
                Result.Success success2 = new Result.Success(Unit.INSTANCE);
                Result.Success success3 = new Result.Success(Unit.INSTANCE);
                NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultCreateStackComponentStyle, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, success, success2, success3})));
                if (nonEmptyListOrNull != null) {
                    return new Result.Error(nonEmptyListOrNull);
                }
                Intrinsics.checkNotNull(resultCreateStackComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value = ((Result.Success) resultCreateStackComponentStyle).getValue();
                Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value2 = ((Result.Success) resultOrSuccessfullyNull).getValue();
                Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value3 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
                Object value4 = success.getValue();
                Object value5 = success2.getValue();
                return new Result.Success(new CountdownComponentStyle(countdownComponent2.getStyle().getDate(), countdownComponent2.getCountFrom(), (StackComponentStyle) value, (StackComponentStyle) value2, (StackComponentStyle) value3));
            }
        });
    }

    private final Result<HeaderComponentStyle, NonEmptyList<PaywallValidationError>> createHeaderComponentStyle(StyleFactoryScope styleFactoryScope, final HeaderComponent headerComponent) {
        return (Result) styleFactoryScope.withSelectedScope(null, null, new Function1<StyleFactoryScope, Result<? extends HeaderComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createHeaderComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<HeaderComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                Result<HeaderComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = StyleFactory.this.createStackComponentStyle(withSelectedScope, headerComponent.getStack());
                if (resultCreateStackComponentStyle instanceof Result.Success) {
                    return new Result.Success(new HeaderComponentStyle((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue()));
                }
                if (resultCreateStackComponentStyle instanceof Result.Error) {
                    return resultCreateStackComponentStyle;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    private final Result<StickyFooterComponentStyle, NonEmptyList<PaywallValidationError>> createStickyFooterComponentStyle(StyleFactoryScope styleFactoryScope, final StickyFooterComponent stickyFooterComponent) {
        return (Result) styleFactoryScope.withSelectedScope(null, null, new Function1<StyleFactoryScope, Result<? extends StickyFooterComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createStickyFooterComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<StickyFooterComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                Result<StickyFooterComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = StyleFactory.this.createStackComponentStyle(withSelectedScope, stickyFooterComponent.getStack());
                if (resultCreateStackComponentStyle instanceof Result.Success) {
                    return new Result.Success(new StickyFooterComponentStyle((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue()));
                }
                if (resultCreateStackComponentStyle instanceof Result.Error) {
                    return resultCreateStackComponentStyle;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    private final Result<ButtonComponentStyle, NonEmptyList<PaywallValidationError>> createButtonComponentStyleOrNull(StyleFactoryScope styleFactoryScope, ButtonComponent buttonComponent) {
        Result.Success success;
        Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = createStackComponentStyle(styleFactoryScope, buttonComponent.getStack());
        Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> resultConvertAction = convertAction(styleFactoryScope, buttonComponent.getAction());
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        Result.Success success3 = new Result.Success(Unit.INSTANCE);
        Result.Success success4 = new Result.Success(Unit.INSTANCE);
        Result.Success success5 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultCreateStackComponentStyle, resultConvertAction, success2, success3, success4, success5})));
        if (nonEmptyListOrNull != null) {
            success = new Result.Error(nonEmptyListOrNull);
        } else {
            Intrinsics.checkNotNull(resultCreateStackComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value = ((Result.Success) resultCreateStackComponentStyle).getValue();
            Intrinsics.checkNotNull(resultConvertAction, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value2 = ((Result.Success) resultConvertAction).getValue();
            Object value3 = success2.getValue();
            Object value4 = success3.getValue();
            Object value5 = success4.getValue();
            ButtonComponentStyle.Action action = (ButtonComponentStyle.Action) value2;
            success = new Result.Success(action != null ? new ButtonComponentStyle((StackComponentStyle) value, action, buttonComponent.getTransition(), buttonComponent.getName(), buttonComponent.getId()) : null);
        }
        if (!(success instanceof Result.Success)) {
            if (success instanceof Result.Error) {
                return success;
            }
            throw new NoWhenBranchMatchedException();
        }
        ButtonComponentStyle buttonComponentStyle = (ButtonComponentStyle) ((Result.Success) success).getValue();
        if (((buttonComponentStyle != null ? buttonComponentStyle.getAction() : null) instanceof ButtonComponentStyle.Action.WorkflowTrigger) && buttonComponentStyle.getComponentId() == null) {
            return new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.WorkflowButtonMissingComponentId(buttonComponent.getName()), new PaywallValidationError.WorkflowButtonMissingComponentId[0]));
        }
        return new Result.Success(buttonComponentStyle);
    }

    private final Result<PackageComponentStyle, NonEmptyList<PaywallValidationError>> createPackageComponentStyle(StyleFactoryScope styleFactoryScope, final PackageComponent packageComponent) {
        final Package r2 = (Package) new Result.Success(getPackageOrNull(this.offering, packageComponent.getPackageId())).getValue();
        if (r2 == null) {
            String identifier = this.offering.getIdentifier();
            String packageId = packageComponent.getPackageId();
            List<Package> availablePackages = this.offering.getAvailablePackages();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availablePackages, 10));
            Iterator<T> it = availablePackages.iterator();
            while (it.hasNext()) {
                arrayList.add(((Package) it.next()).getIdentifier());
            }
            Logger.INSTANCE.m1587w(new PaywallValidationError.MissingPackage(identifier, packageId, arrayList).getMessage());
            return new Result.Success(null);
        }
        final ResolvedOffer resolvedOfferResolve = PromoOfferResolver.INSTANCE.resolve(r2, packageComponent.getPlayStoreOffer());
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(packageComponent.getOverrides(), this.stripRules, new Function1<PartialPackageComponent, Result<? extends PresentedPackagePartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createPackageComponentStyle$1$presentedOverridesResult$1
            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedPackagePartial, NonEmptyList<PaywallValidationError>> invoke(PartialPackageComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return PresentedPackagePartial.INSTANCE.invoke(partial);
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (presentedOverrides instanceof Result.Error) {
                presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        final Result result = presentedOverrides;
        final OfferEligibility offerEligibilityCalculateOfferEligibility = PackageExtensionsKt.calculateOfferEligibility(resolvedOfferResolve, r2);
        boolean isSelectedByDefault = packageComponent.getIsSelectedByDefault();
        Boolean visible = packageComponent.getVisible();
        boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
        Result.Success success = result instanceof Result.Success ? (Result.Success) result : null;
        List listEmptyList = success != null ? (List) success.getValue() : null;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return (Result) styleFactoryScope.withSelectedScope(new PaywallState.Loaded.Components.AvailablePackages.Info(r2, isSelectedByDefault, resolvedOfferResolve, zBooleanValue, listEmptyList, offerEligibilityCalculateOfferEligibility), null, new Function1<StyleFactoryScope, Result<? extends PackageComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createPackageComponentStyle$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PackageComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactory.StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                C77641 c77641 = new Function1<PaywallComponent, Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createPackageComponentStyle$1$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(PaywallComponent it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return Boolean.valueOf(it2 instanceof PurchaseButtonComponent);
                    }
                };
                StyleFactory styleFactory = this;
                PackageComponent packageComponent2 = packageComponent;
                Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) withSelectedScope.countPredicates.keySet());
                int iIntValue = (num != null ? num.intValue() : -1) + 1;
                withSelectedScope.countPredicates.put(Integer.valueOf(iIntValue), c77641);
                withSelectedScope.countValues.put(Integer.valueOf(iIntValue), 0);
                StyleFactory.StyleFactoryScope.WithCount withCount = new StyleFactory.StyleFactoryScope.WithCount(styleFactory.createStackComponentStyle(withSelectedScope, packageComponent2.getStack()), ((Number) MapsKt.getValue(withSelectedScope.countValues, Integer.valueOf(iIntValue))).intValue());
                withSelectedScope.countPredicates.remove(Integer.valueOf(iIntValue));
                withSelectedScope.countValues.remove(Integer.valueOf(iIntValue));
                Result result2 = (Result) withCount.component1();
                int count = withCount.getCount();
                Result<List<PresentedOverride<PresentedPackagePartial>>, NonEmptyList<PaywallValidationError>> result3 = result;
                PackageComponent packageComponent3 = packageComponent;
                Package r10 = r2;
                ResolvedOffer resolvedOffer = resolvedOfferResolve;
                OfferEligibility offerEligibility = offerEligibilityCalculateOfferEligibility;
                Result.Success success2 = new Result.Success(Unit.INSTANCE);
                Result.Success success3 = new Result.Success(Unit.INSTANCE);
                Result.Success success4 = new Result.Success(Unit.INSTANCE);
                Result.Success success5 = new Result.Success(Unit.INSTANCE);
                NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{result3, result2, success2, success3, success4, success5})));
                if (nonEmptyListOrNull != null) {
                    return new Result.Error(nonEmptyListOrNull);
                }
                Intrinsics.checkNotNull(result3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value = ((Result.Success) result3).getValue();
                Intrinsics.checkNotNull(result2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value2 = ((Result.Success) result2).getValue();
                Object value3 = success2.getValue();
                Object value4 = success3.getValue();
                Object value5 = success4.getValue();
                StackComponentStyle stackComponentStyle = (StackComponentStyle) value2;
                List list = (List) value;
                boolean isSelectedByDefault2 = packageComponent3.getIsSelectedByDefault();
                String name = packageComponent3.getName();
                boolean z = count == 0;
                Boolean visible2 = packageComponent3.getVisible();
                return new Result.Success(new PackageComponentStyle(r10, isSelectedByDefault2, name, stackComponentStyle, z, resolvedOffer, visible2 != null ? visible2.booleanValue() : true, list, offerEligibility));
            }
        });
    }

    private final Result<ButtonComponentStyle, NonEmptyList<PaywallValidationError>> createPurchaseButtonComponentStyle(StyleFactoryScope styleFactoryScope, PurchaseButtonComponent purchaseButtonComponent) {
        Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = createStackComponentStyle(styleFactoryScope, purchaseButtonComponent.getStack());
        PurchaseButtonComponent.Method method = purchaseButtonComponent.getMethod();
        if (method == null) {
            PurchaseButtonComponent.Action action = purchaseButtonComponent.getAction();
            method = action != null ? action.toMethod() : null;
        }
        Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> resultConvertPurchaseButtonMethod = convertPurchaseButtonMethod(styleFactoryScope, method);
        Result.Success success = new Result.Success(Unit.INSTANCE);
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        Result.Success success3 = new Result.Success(Unit.INSTANCE);
        Result.Success success4 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultCreateStackComponentStyle, resultConvertPurchaseButtonMethod, success, success2, success3, success4})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(resultCreateStackComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) resultCreateStackComponentStyle).getValue();
        Intrinsics.checkNotNull(resultConvertPurchaseButtonMethod, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultConvertPurchaseButtonMethod).getValue();
        Object value3 = success.getValue();
        Object value4 = success2.getValue();
        Object value5 = success3.getValue();
        return new Result.Success(new ButtonComponentStyle((StackComponentStyle) value, (ButtonComponentStyle.Action) value2, null, purchaseButtonComponent.getName(), null, 20, null));
    }

    private final Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> convertAction(StyleFactoryScope styleFactoryScope, ButtonComponent.Action action) {
        if (action instanceof ButtonComponent.Action.NavigateBack) {
            return new Result.Success(ButtonComponentStyle.Action.NavigateBack.INSTANCE);
        }
        if (action instanceof ButtonComponent.Action.RestorePurchases) {
            return new Result.Success(ButtonComponentStyle.Action.RestorePurchases.INSTANCE);
        }
        if (action instanceof ButtonComponent.Action.NavigateTo) {
            ButtonComponent.Destination destination = ((ButtonComponent.Action.NavigateTo) action).getDestination();
            if ((destination instanceof ButtonComponent.Destination.Sheet) && ((ButtonComponent.Destination.Sheet) destination).getStack() == null) {
                return new Result.Success(ButtonComponentStyle.Action.NoOp.INSTANCE);
            }
            Result resultConvertDestination = convertDestination(styleFactoryScope, destination);
            if (resultConvertDestination instanceof Result.Success) {
                ButtonComponentStyle.Action.NavigateTo.Destination destination2 = (ButtonComponentStyle.Action.NavigateTo.Destination) ((Result.Success) resultConvertDestination).getValue();
                return new Result.Success(destination2 != null ? new ButtonComponentStyle.Action.NavigateTo(destination2) : null);
            }
            if (resultConvertDestination instanceof Result.Error) {
                return resultConvertDestination;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (action instanceof ButtonComponent.Action.WorkflowTrigger) {
            return new Result.Success(ButtonComponentStyle.Action.WorkflowTrigger.INSTANCE);
        }
        if (action instanceof ButtonComponent.Action.CloseWorkflow) {
            return new Result.Success(ButtonComponentStyle.Action.CloseWorkflow.INSTANCE);
        }
        if (action instanceof ButtonComponent.Action.Unknown) {
            return new Result.Success(null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> convertPurchaseButtonMethod(StyleFactoryScope styleFactoryScope, PurchaseButtonComponent.Method method) {
        boolean zBooleanValue;
        if (method == null) {
            return new Result.Success(new ButtonComponentStyle.Action.PurchasePackage(styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer()));
        }
        if (method instanceof PurchaseButtonComponent.Method.InAppCheckout) {
            return new Result.Success(new ButtonComponentStyle.Action.PurchasePackage(styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer()));
        }
        if (method instanceof PurchaseButtonComponent.Method.WebCheckout) {
            Package rcPackage = styleFactoryScope.getRcPackage();
            PurchaseButtonComponent.Method.WebCheckout webCheckout = (PurchaseButtonComponent.Method.WebCheckout) method;
            Boolean autoDismiss = webCheckout.getAutoDismiss();
            zBooleanValue = autoDismiss != null ? autoDismiss.booleanValue() : true;
            ButtonComponent.UrlMethod openMethod = webCheckout.getOpenMethod();
            if (openMethod == null) {
                openMethod = ButtonComponent.UrlMethod.EXTERNAL_BROWSER;
            }
            return new Result.Success(new ButtonComponentStyle.Action.WebCheckout(rcPackage, zBooleanValue, openMethod));
        }
        if (method instanceof PurchaseButtonComponent.Method.WebProductSelection) {
            PurchaseButtonComponent.Method.WebProductSelection webProductSelection = (PurchaseButtonComponent.Method.WebProductSelection) method;
            Boolean autoDismiss2 = webProductSelection.getAutoDismiss();
            zBooleanValue = autoDismiss2 != null ? autoDismiss2.booleanValue() : true;
            ButtonComponent.UrlMethod openMethod2 = webProductSelection.getOpenMethod();
            if (openMethod2 == null) {
                openMethod2 = ButtonComponent.UrlMethod.EXTERNAL_BROWSER;
            }
            return new Result.Success(new ButtonComponentStyle.Action.WebProductSelection(zBooleanValue, openMethod2));
        }
        if (method instanceof PurchaseButtonComponent.Method.CustomWebCheckout) {
            PurchaseButtonComponent.Method.CustomWebCheckout customWebCheckout = (PurchaseButtonComponent.Method.CustomWebCheckout) method;
            Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> resultM13900stringForAllLocales7v81vok = LocalizationKt.m13900stringForAllLocales7v81vok(this.localizations, customWebCheckout.getCustomUrl().m13789getUrlLidz7Tp4o());
            if (resultM13900stringForAllLocales7v81vok instanceof Result.Success) {
                NonEmptyMap nonEmptyMap = (NonEmptyMap) ((Result.Success) resultM13900stringForAllLocales7v81vok).getValue();
                Boolean autoDismiss3 = customWebCheckout.getAutoDismiss();
                boolean zBooleanValue2 = autoDismiss3 != null ? autoDismiss3.booleanValue() : true;
                ButtonComponent.UrlMethod openMethod3 = customWebCheckout.getOpenMethod();
                if (openMethod3 == null) {
                    openMethod3 = ButtonComponent.UrlMethod.EXTERNAL_BROWSER;
                }
                return new Result.Success(new ButtonComponentStyle.Action.CustomWebCheckout(nonEmptyMap, zBooleanValue2, openMethod3, styleFactoryScope.getRcPackage(), customWebCheckout.getCustomUrl().getPackageParam(), customWebCheckout.getCustomUrl().getAppUserIdParam(), customWebCheckout.getCustomUrl().getEnvParam()));
            }
            if (resultM13900stringForAllLocales7v81vok instanceof Result.Error) {
                return resultM13900stringForAllLocales7v81vok;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!(method instanceof PurchaseButtonComponent.Method.Unknown)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.INSTANCE.m1584e("Unknown purchase button method. Defaulting to purchasing current/default package.");
        return new Result.Success(new ButtonComponentStyle.Action.PurchasePackage(styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer()));
    }

    private final Result<ButtonComponentStyle.Action.NavigateTo.Destination, NonEmptyList<PaywallValidationError>> convertDestination(StyleFactoryScope styleFactoryScope, ButtonComponent.Destination destination) {
        if (destination instanceof ButtonComponent.Destination.CustomerCenter) {
            return new Result.Success(ButtonComponentStyle.Action.NavigateTo.Destination.CustomerCenter.INSTANCE);
        }
        if (destination instanceof ButtonComponent.Destination.PrivacyPolicy) {
            ButtonComponent.Destination.PrivacyPolicy privacyPolicy = (ButtonComponent.Destination.PrivacyPolicy) destination;
            return m14010buttonComponentStyleUrlDestinationxW_dp2A(privacyPolicy.m13762getUrlLidz7Tp4o(), privacyPolicy.getMethod(), PaywallLegacyComponentInteraction.Value.NAVIGATE_TO_PRIVACY_POLICY);
        }
        if (destination instanceof ButtonComponent.Destination.Terms) {
            ButtonComponent.Destination.Terms terms = (ButtonComponent.Destination.Terms) destination;
            return m14010buttonComponentStyleUrlDestinationxW_dp2A(terms.m13766getUrlLidz7Tp4o(), terms.getMethod(), PaywallLegacyComponentInteraction.Value.NAVIGATE_TO_TERMS);
        }
        if (destination instanceof ButtonComponent.Destination.Url) {
            ButtonComponent.Destination.Url url = (ButtonComponent.Destination.Url) destination;
            return m14010buttonComponentStyleUrlDestinationxW_dp2A(url.m13770getUrlLidz7Tp4o(), url.getMethod(), "navigate_to_url");
        }
        if (destination instanceof ButtonComponent.Destination.Sheet) {
            ButtonComponent.Destination.Sheet sheet = (ButtonComponent.Destination.Sheet) destination;
            StackComponent stack = sheet.getStack();
            if (stack == null) {
                Logger.INSTANCE.m1584e("Sheet destination reached convertDestination without a stack.");
                return new Result.Success(null);
            }
            Result resultCreateStackComponentStyle = createStackComponentStyle(styleFactoryScope, stack);
            if (resultCreateStackComponentStyle instanceof Result.Success) {
                resultCreateStackComponentStyle = new Result.Success((StackComponentStyle) styleFactoryScope.applyBottomWindowInsetsIfNecessary((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue(), true));
            } else if (!(resultCreateStackComponentStyle instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (resultCreateStackComponentStyle instanceof Result.Success) {
                resultCreateStackComponentStyle = new Result.Success((StackComponentStyle) styleFactoryScope.applyHorizontalWindowInsetsIfNecessary((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue(), true));
            } else if (!(resultCreateStackComponentStyle instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (resultCreateStackComponentStyle instanceof Result.Success) {
                return new Result.Success(new ButtonComponentStyle.Action.NavigateTo.Destination.Sheet(sheet.getId(), sheet.getName(), (StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue(), sheet.getBackgroundBlur(), sheet.getSize()));
            }
            if (resultCreateStackComponentStyle instanceof Result.Error) {
                return resultCreateStackComponentStyle;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (destination instanceof ButtonComponent.Destination.Unknown) {
            return new Result.Success(null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: buttonComponentStyleUrlDestination-xW_dp2A, reason: not valid java name */
    private final Result<ButtonComponentStyle.Action.NavigateTo.Destination.Url, NonEmptyList<PaywallValidationError.MissingStringLocalization>> m14010buttonComponentStyleUrlDestinationxW_dp2A(String urlLid, ButtonComponent.UrlMethod method, String componentInteractionValue) {
        Result.Success successM13900stringForAllLocales7v81vok = LocalizationKt.m13900stringForAllLocales7v81vok(this.localizations, urlLid);
        if (successM13900stringForAllLocales7v81vok instanceof Result.Success) {
            successM13900stringForAllLocales7v81vok = new Result.Success(new ButtonComponentStyle.Action.NavigateTo.Destination.Url((NonEmptyMap) ((Result.Success) successM13900stringForAllLocales7v81vok).getValue(), method, componentInteractionValue));
        } else if (!(successM13900stringForAllLocales7v81vok instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (successM13900stringForAllLocales7v81vok instanceof Result.Success) {
            ButtonComponentStyle.Action.NavigateTo.Destination.Url url = (ButtonComponentStyle.Action.NavigateTo.Destination.Url) ((Result.Success) successM13900stringForAllLocales7v81vok).getValue();
            int i = WhenMappings.$EnumSwitchMapping$0[url.getMethod().ordinal()];
            if (i != 1 && i != 2 && i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                url = null;
            }
            return new Result.Success(url);
        }
        if (successM13900stringForAllLocales7v81vok instanceof Result.Error) {
            return successM13900stringForAllLocales7v81vok;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> createStackComponentStyle(final StyleFactoryScope styleFactoryScope, StackComponent stackComponent) {
        Result.Success success;
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(stackComponent.getOverrides(), this.stripRules, new Function1<PartialStackComponent, Result<? extends PresentedStackPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createStackComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedStackPartial, NonEmptyList<PaywallValidationError>> invoke(PartialStackComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                PresentedStackPartial.Companion companion = PresentedStackPartial.INSTANCE;
                Map map = StyleFactory.this.colorAliases;
                final StyleFactory styleFactory = StyleFactory.this;
                final StyleFactoryScope styleFactoryScope2 = styleFactoryScope;
                return companion.invoke(partial, map, new Function1<StackComponent, Result<? extends StackComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createStackComponentStyle.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StackComponent stackComponent2) {
                        Intrinsics.checkNotNullParameter(stackComponent2, "stackComponent");
                        return styleFactory.createStackComponentStyle(styleFactoryScope2, stackComponent2);
                    }
                });
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (presentedOverrides instanceof Result.Error) {
                presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        List components = stackComponent.getComponents();
        ArrayList<Result> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(components, 10));
        Iterator it = components.iterator();
        while (it.hasNext()) {
            arrayList.add(createInternal(styleFactoryScope, (PaywallComponent) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Result result : arrayList) {
            if (result instanceof Result.Success) {
                if (arrayList3.isEmpty()) {
                    arrayList2.add((ComponentStyle) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList3.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList3);
        if (nonEmptyListOrNull != null) {
            success = new Result.Error(nonEmptyListOrNull);
        } else {
            success = new Result.Success(arrayList2);
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(CollectionsKt.filterNotNull((List) ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Badge badge = stackComponent.getBadge();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(badge != null ? BadgeStyleKt.toBadgeStyle(badge, new Function1<StackComponent, Result<? extends StackComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createStackComponentStyle.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StackComponent stackComponent2) {
                Intrinsics.checkNotNullParameter(stackComponent2, "stackComponent");
                return StyleFactory.this.createStackComponentStyle(styleFactoryScope, stackComponent2);
            }
        }) : null);
        Result<BackgroundStyles, NonEmptyList<PaywallValidationError>> resultCreateBackgroundStyles = createBackgroundStyles(stackComponent.getBackground(), stackComponent.getBackgroundColor());
        Border border = stackComponent.getBorder();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, this.colorAliases) : null);
        Shadow shadow = stackComponent.getShadow();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, this.colorAliases) : null);
        NonEmptyList nonEmptyListOrNull2 = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, success, resultOrSuccessfullyNull, resultCreateBackgroundStyles, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3})));
        if (nonEmptyListOrNull2 != null) {
            return new Result.Error(nonEmptyListOrNull2);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Object value2 = ((Result.Success) success).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultCreateBackgroundStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultCreateBackgroundStyles).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<F of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        ShadowStyles shadowStyles = (ShadowStyles) ((Result.Success) resultOrSuccessfullyNull3).getValue();
        BorderStyles borderStyles = (BorderStyles) value5;
        BackgroundStyles backgroundStyles = (BackgroundStyles) value4;
        BadgeStyle badgeStyle = (BadgeStyle) value3;
        List list = (List) value2;
        List list2 = (List) value;
        Dimension dimension = stackComponent.getDimension();
        Boolean visible = stackComponent.getVisible();
        boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
        Size size = stackComponent.getSize();
        Float spacing = stackComponent.getSpacing();
        float fM11017constructorimpl = C1486Dp.m11017constructorimpl(spacing != null ? spacing.floatValue() : 0.0f);
        PaddingValues paddingValues = PaddingKt.toPaddingValues(stackComponent.getPadding(), true);
        PaddingValues paddingValues2 = PaddingKt.toPaddingValues(stackComponent.getMargin(), true);
        Shape.Rectangle shape = stackComponent.getShape();
        if (shape == null) {
            shape = DEFAULT_SHAPE;
        }
        Shape shape2 = shape;
        StackComponent.Overflow overflow = stackComponent.getOverflow();
        return new Result.Success(new StackComponentStyle(list, dimension, zBooleanValue, size, fM11017constructorimpl, backgroundStyles, paddingValues, paddingValues2, shape2, borderStyles, shadowStyles, badgeStyle, overflow != null ? OverflowExtensionsKt.toOrientation(overflow, stackComponent.getDimension()) : null, styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), styleFactoryScope.getCountdownDate(), styleFactoryScope.getCountFrom(), list2, styleFactoryScope.getApplyTopWindowInsets(), false, false, false, 14680064, null));
    }

    private final Result<TextComponentStyle, NonEmptyList<PaywallValidationError>> createTextComponentStyle(StyleFactoryScope styleFactoryScope, TextComponent textComponent) {
        Result resultM13956getFontSpecpDyximM;
        Result.Success success = new Result.Success(LocalizationKt.m13901stringForAllLocalesOrEmpty7v81vok(this.localizations, textComponent.getText()));
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(textComponent.getOverrides(), this.stripRules, new Function1<PartialTextComponent, Result<? extends LocalizedTextPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTextComponentStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<LocalizedTextPartial, NonEmptyList<PaywallValidationError>> invoke(PartialTextComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return LocalizedTextPartial.INSTANCE.invoke(it, StyleFactory.this.localizations, StyleFactory.this.colorAliases, StyleFactory.this.fontAliases);
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (presentedOverrides instanceof Result.Error) {
                presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        Result colorStyles = ColorStyleKt.toColorStyles(textComponent.getColor(), this.colorAliases);
        ColorScheme backgroundColor = textComponent.getBackgroundColor();
        Result resultRecoverFromFontAliasError = null;
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(backgroundColor != null ? ColorStyleKt.toColorStyles(backgroundColor, this.colorAliases) : null);
        String fontName = textComponent.getFontName();
        if (fontName != null && (resultM13956getFontSpecpDyximM = FontSpecKt.m13956getFontSpecpDyximM(this.fontAliases, fontName)) != null) {
            resultRecoverFromFontAliasError = FontSpecKt.recoverFromFontAliasError(resultM13956getFontSpecpDyximM);
        }
        Result.Error errorOrSuccessfullyNull = ResultKt.orSuccessfullyNull(resultRecoverFromFontAliasError);
        if (!(errorOrSuccessfullyNull instanceof Result.Success)) {
            if (errorOrSuccessfullyNull instanceof Result.Error) {
                errorOrSuccessfullyNull = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) errorOrSuccessfullyNull).getValue(), new PaywallValidationError[0]));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{success, presentedOverrides, colorStyles, resultOrSuccessfullyNull, errorOrSuccessfullyNull, success2})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Object value = success.getValue();
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) presentedOverrides).getValue();
        Intrinsics.checkNotNull(colorStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) colorStyles).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(errorOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) errorOrSuccessfullyNull).getValue();
        FontSpec fontSpec = (FontSpec) value5;
        ColorStyles colorStyles2 = (ColorStyles) value4;
        ColorStyles colorStyles3 = (ColorStyles) value3;
        List list = (List) value2;
        NonEmptyMap nonEmptyMap = (NonEmptyMap) value;
        Integer fontWeightInt = textComponent.getFontWeightInt();
        FontWeight fontWeight = fontWeightInt != null ? new FontWeight(fontWeightInt.intValue()) : FontKt.toFontWeight(textComponent.getFontWeight());
        int fontSize = textComponent.getFontSize();
        TextAlign textAlignM10888boximpl = TextAlign.m10888boximpl(AlignmentKt.toTextAlign(textComponent.getHorizontalAlignment()));
        Alignment.Horizontal alignment = AlignmentKt.toAlignment(textComponent.getHorizontalAlignment());
        Boolean visible = textComponent.getVisible();
        return new Result.Success(new TextComponentStyle(nonEmptyMap, colorStyles3, fontSize, fontWeight, fontSpec, textAlignM10888boximpl, alignment, colorStyles2, visible != null ? visible.booleanValue() : true, textComponent.getSize(), PaddingKt.toPaddingValues(textComponent.getPadding(), true), PaddingKt.toPaddingValues(textComponent.getMargin(), true), styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), styleFactoryScope.getCountdownDate(), styleFactoryScope.getCountFrom(), this.variableLocalizations, list, textComponent.getName(), null));
    }

    private final Result<ImageComponentStyle, NonEmptyList<PaywallValidationError>> createImageComponentStyle(StyleFactoryScope styleFactoryScope, ImageComponent imageComponent) {
        Result<NonEmptyMap<LocaleId, ThemeImageUrls>, NonEmptyList<PaywallValidationError.MissingImageLocalization>> resultM14011withLocalizedOverridesTDPsjl0 = m14011withLocalizedOverridesTDPsjl0(imageComponent.getSource(), imageComponent.getOverrideSourceLid());
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(imageComponent.getOverrides(), this.stripRules, new Function1<PartialImageComponent, Result<? extends PresentedImagePartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createImageComponentStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedImagePartial, NonEmptyList<PaywallValidationError>> invoke(PartialImageComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ThemeImageUrls source = it.getSource();
                Result<PresentedImagePartial, NonEmptyList<PaywallValidationError>> resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(source != null ? StyleFactory.this.m14011withLocalizedOverridesTDPsjl0(source, it.getOverrideSourceLid()) : null);
                StyleFactory styleFactory = StyleFactory.this;
                if (resultOrSuccessfullyNull instanceof Result.Success) {
                    return PresentedImagePartial.INSTANCE.invoke(it, (NonEmptyMap) ((Result.Success) resultOrSuccessfullyNull).getValue(), styleFactory.colorAliases);
                }
                if (resultOrSuccessfullyNull instanceof Result.Error) {
                    return resultOrSuccessfullyNull;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (presentedOverrides instanceof Result.Error) {
                presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        ColorScheme colorOverlay = imageComponent.getColorOverlay();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(colorOverlay != null ? ColorStyleKt.toColorStyles(colorOverlay, this.colorAliases) : null);
        Border border = imageComponent.getBorder();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, this.colorAliases) : null);
        Shadow shadow = imageComponent.getShadow();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, this.colorAliases) : null);
        Result.Success success = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultM14011withLocalizedOverridesTDPsjl0, presentedOverrides, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, success})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(resultM14011withLocalizedOverridesTDPsjl0, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) resultM14011withLocalizedOverridesTDPsjl0).getValue();
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) presentedOverrides).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull3).getValue();
        ShadowStyles shadowStyles = (ShadowStyles) value5;
        BorderStyles borderStyles = (BorderStyles) value4;
        ColorStyles colorStyles = (ColorStyles) value3;
        List list = (List) value2;
        NonEmptyMap nonEmptyMap = (NonEmptyMap) value;
        Boolean visible = imageComponent.getVisible();
        boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
        Size size = imageComponent.getSize();
        PaddingValues paddingValues = PaddingKt.toPaddingValues(imageComponent.getPadding(), true);
        PaddingValues paddingValues2 = PaddingKt.toPaddingValues(imageComponent.getMargin(), true);
        MaskShape maskShape = imageComponent.getMaskShape();
        return new Result.Success(new ImageComponentStyle(nonEmptyMap, zBooleanValue, size, paddingValues, paddingValues2, maskShape != null ? ShapeKt.toShape(maskShape) : null, borderStyles, shadowStyles, colorStyles, FitModeKt.toContentScale(imageComponent.getFitMode()), styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list, styleFactoryScope.getIgnoreTopWindowInsets()));
    }

    private final Result<VideoComponentStyle, NonEmptyList<PaywallValidationError>> createVideoComponentStyle(StyleFactoryScope styleFactoryScope, VideoComponent videoComponent) {
        Result.Error presentedOverrides;
        PaddingValues paddingValuesM2849PaddingValuesYgX7TsA$default;
        PaddingValues paddingValuesM2849PaddingValuesYgX7TsA$default2;
        Result<NonEmptyMap<LocaleId, ThemeVideoUrls>, NonEmptyList<PaywallValidationError.MissingVideoLocalization>> resultM14012withLocalizedOverridesTDPsjl0 = m14012withLocalizedOverridesTDPsjl0(videoComponent.getSource(), videoComponent.getOverrideSourceLid());
        ThemeImageUrls fallbackSource = videoComponent.getFallbackSource();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(fallbackSource != null ? m14011withLocalizedOverridesTDPsjl0(fallbackSource, videoComponent.getOverrideSourceLid()) : null);
        List overrides = videoComponent.getOverrides();
        if (overrides == null || (presentedOverrides = PresentedPartialKt.toPresentedOverrides(overrides, this.stripRules, new Function1<PartialVideoComponent, Result<? extends PresentedVideoPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createVideoComponentStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedVideoPartial, NonEmptyList<PaywallValidationError>> invoke(PartialVideoComponent videoPartial) {
                Result resultM14011withLocalizedOverridesTDPsjl0;
                Intrinsics.checkNotNullParameter(videoPartial, "videoPartial");
                ThemeVideoUrls source = videoPartial.getSource();
                NonEmptyMap nonEmptyMap = null;
                Result<PresentedVideoPartial, NonEmptyList<PaywallValidationError>> resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(source != null ? StyleFactory.this.m14012withLocalizedOverridesTDPsjl0(source, videoPartial.getOverrideSourceLid()) : null);
                StyleFactory styleFactory = StyleFactory.this;
                if (resultOrSuccessfullyNull2 instanceof Result.Success) {
                    NonEmptyMap nonEmptyMap2 = (NonEmptyMap) ((Result.Success) resultOrSuccessfullyNull2).getValue();
                    PresentedVideoPartial.Companion companion = PresentedVideoPartial.INSTANCE;
                    ThemeImageUrls fallbackSource2 = videoPartial.getFallbackSource();
                    if (fallbackSource2 != null && (resultM14011withLocalizedOverridesTDPsjl0 = styleFactory.m14011withLocalizedOverridesTDPsjl0(fallbackSource2, videoPartial.getOverrideSourceLid())) != null && (resultM14011withLocalizedOverridesTDPsjl0 instanceof Result.Success)) {
                        nonEmptyMap = (NonEmptyMap) ((Result.Success) resultM14011withLocalizedOverridesTDPsjl0).getValue();
                    }
                    return companion.invoke(videoPartial, nonEmptyMap2, nonEmptyMap, styleFactory.colorAliases);
                }
                if (resultOrSuccessfullyNull2 instanceof Result.Error) {
                    return resultOrSuccessfullyNull2;
                }
                throw new NoWhenBranchMatchedException();
            }
        })) == null) {
            presentedOverrides = null;
        } else if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(presentedOverrides);
        ColorScheme colorOverlay = videoComponent.getColorOverlay();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(colorOverlay != null ? ColorStyleKt.toColorStyles(colorOverlay, this.colorAliases) : null);
        Border border = videoComponent.getBorder();
        Result resultOrSuccessfullyNull4 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, this.colorAliases) : null);
        Shadow shadow = videoComponent.getShadow();
        Result resultOrSuccessfullyNull5 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, this.colorAliases) : null);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultM14012withLocalizedOverridesTDPsjl0, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, resultOrSuccessfullyNull4, resultOrSuccessfullyNull5})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(resultM14012withLocalizedOverridesTDPsjl0, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) resultM14012withLocalizedOverridesTDPsjl0).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull3).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull4, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull4).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull5, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<F of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        ShadowStyles shadowStyles = (ShadowStyles) ((Result.Success) resultOrSuccessfullyNull5).getValue();
        BorderStyles borderStyles = (BorderStyles) value5;
        ColorStyles colorStyles = (ColorStyles) value4;
        List listEmptyList = (List) value3;
        NonEmptyMap nonEmptyMap = (NonEmptyMap) value2;
        NonEmptyMap nonEmptyMap2 = (NonEmptyMap) value;
        Boolean visible = videoComponent.getVisible();
        boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
        Size size = videoComponent.getSize();
        Padding padding = videoComponent.getPadding();
        if (padding == null || (paddingValuesM2849PaddingValuesYgX7TsA$default = PaddingKt.toPaddingValues(padding, true)) == null) {
            paddingValuesM2849PaddingValuesYgX7TsA$default = androidx.compose.foundation.layout.PaddingKt.m2849PaddingValuesYgX7TsA$default(0.0f, 0.0f, 3, null);
        }
        PaddingValues paddingValues = paddingValuesM2849PaddingValuesYgX7TsA$default;
        Padding margin = videoComponent.getMargin();
        if (margin == null || (paddingValuesM2849PaddingValuesYgX7TsA$default2 = PaddingKt.toPaddingValues(margin, true)) == null) {
            paddingValuesM2849PaddingValuesYgX7TsA$default2 = androidx.compose.foundation.layout.PaddingKt.m2849PaddingValuesYgX7TsA$default(0.0f, 0.0f, 3, null);
        }
        PaddingValues paddingValues2 = paddingValuesM2849PaddingValuesYgX7TsA$default2;
        Package rcPackage = styleFactoryScope.getRcPackage();
        ResolvedOffer resolvedOffer = styleFactoryScope.getResolvedOffer();
        Integer tabControlIndex = styleFactoryScope.getTabControlIndex();
        OfferEligibility offerEligibility = styleFactoryScope.getOfferEligibility();
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List list = listEmptyList;
        boolean showControls = videoComponent.getShowControls();
        boolean autoplay = videoComponent.getAutoplay();
        boolean loop = videoComponent.getLoop();
        boolean muteAudio = videoComponent.getMuteAudio();
        MaskShape maskShape = videoComponent.getMaskShape();
        return new Result.Success(new VideoComponentStyle(nonEmptyMap2, nonEmptyMap, showControls, autoplay, loop, muteAudio, size, zBooleanValue, paddingValues, paddingValues2, maskShape != null ? ShapeKt.toShape(maskShape) : null, borderStyles, shadowStyles, colorStyles, FitModeKt.toContentScale(videoComponent.getFitMode()), rcPackage, resolvedOffer, tabControlIndex, offerEligibility, styleFactoryScope.getIgnoreTopWindowInsets(), list));
    }

    private final Result<IconComponentStyle, NonEmptyList<PaywallValidationError>> createIconComponentStyle(StyleFactoryScope styleFactoryScope, IconComponent iconComponent) {
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(iconComponent.getOverrides(), this.stripRules, new Function1<PartialIconComponent, Result<? extends PresentedIconPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createIconComponentStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedIconPartial, NonEmptyList<PaywallValidationError>> invoke(PartialIconComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return PresentedIconPartial.INSTANCE.invoke(partial, StyleFactory.this.colorAliases);
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (presentedOverrides instanceof Result.Error) {
                presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        ColorScheme color = iconComponent.getColor();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(color != null ? ColorStyleKt.toColorStyles(color, this.colorAliases) : null);
        IconComponent.IconBackground iconBackground = iconComponent.getIconBackground();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(iconBackground != null ? IconComponentStyleKt.toBackground(iconBackground, this.colorAliases) : null);
        Result.Success success = new Result.Success(Unit.INSTANCE);
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        Result.Success success3 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, success, success2, success3})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Object value4 = success.getValue();
        Object value5 = success2.getValue();
        IconComponentStyle.Background background = (IconComponentStyle.Background) value3;
        ColorStyles colorStyles = (ColorStyles) value2;
        List list = (List) value;
        String baseUrl = iconComponent.getBaseUrl();
        String iconName = iconComponent.getIconName();
        IconComponent.Formats formats = iconComponent.getFormats();
        Boolean visible = iconComponent.getVisible();
        return new Result.Success(new IconComponentStyle(baseUrl, iconName, formats, visible != null ? visible.booleanValue() : true, iconComponent.getSize(), colorStyles, PaddingKt.toPaddingValues(iconComponent.getPadding(), true), PaddingKt.toPaddingValues(iconComponent.getMargin(), true), background, styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list));
    }

    private final Result<TimelineComponentStyle, NonEmptyList<PaywallValidationError>> createTimelineComponentStyle(StyleFactoryScope styleFactoryScope, TimelineComponent timelineComponent) {
        Result.Success success;
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(timelineComponent.getOverrides(), this.stripRules, new Function1<PartialTimelineComponent, Result<? extends PresentedTimelinePartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTimelineComponentStyle.1
            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedTimelinePartial, NonEmptyList<PaywallValidationError>> invoke(PartialTimelineComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return new Result.Success(new PresentedTimelinePartial(partial));
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (presentedOverrides instanceof Result.Error) {
                presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        List items = timelineComponent.getItems();
        ArrayList<Result> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        Iterator it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(createTimelineComponentItemStyle(styleFactoryScope, (TimelineComponent.Item) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Result result : arrayList) {
            if (result instanceof Result.Success) {
                if (arrayList3.isEmpty()) {
                    arrayList2.add((TimelineComponentStyle.ItemStyle) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList3.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList3);
        if (nonEmptyListOrNull != null) {
            success = new Result.Error(nonEmptyListOrNull);
        } else {
            success = new Result.Success(arrayList2);
        }
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        Result.Success success3 = new Result.Success(Unit.INSTANCE);
        Result.Success success4 = new Result.Success(Unit.INSTANCE);
        Result.Success success5 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull2 = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, success, success2, success3, success4, success5})));
        if (nonEmptyListOrNull2 != null) {
            return new Result.Error(nonEmptyListOrNull2);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Object value2 = ((Result.Success) success).getValue();
        Object value3 = success2.getValue();
        Object value4 = success3.getValue();
        Object value5 = success4.getValue();
        List list = (List) value2;
        List list2 = (List) value;
        int itemSpacing = timelineComponent.getItemSpacing();
        int textSpacing = timelineComponent.getTextSpacing();
        int columnGutter = timelineComponent.getColumnGutter();
        TimelineComponent.IconAlignment iconAlignment = timelineComponent.getIconAlignment();
        Boolean visible = timelineComponent.getVisible();
        return new Result.Success(new TimelineComponentStyle(itemSpacing, textSpacing, columnGutter, iconAlignment, visible != null ? visible.booleanValue() : true, timelineComponent.getSize(), PaddingKt.toPaddingValues(timelineComponent.getPadding(), true), PaddingKt.toPaddingValues(timelineComponent.getMargin(), true), list, styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list2));
    }

    private final Result<TimelineComponentStyle.ItemStyle, NonEmptyList<PaywallValidationError>> createTimelineComponentItemStyle(StyleFactoryScope styleFactoryScope, TimelineComponent.Item item) {
        ColorScheme color;
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(item.getOverrides(), this.stripRules, new Function1<PartialTimelineComponentItem, Result<? extends PresentedTimelineItemPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTimelineComponentItemStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedTimelineItemPartial, NonEmptyList<PaywallValidationError>> invoke(PartialTimelineComponentItem partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return PresentedTimelineItemPartial.INSTANCE.invoke(partial, StyleFactory.this.colorAliases);
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (presentedOverrides instanceof Result.Error) {
                presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        Result<TextComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateTextComponentStyle = createTextComponentStyle(styleFactoryScope, item.getTitle());
        TextComponent description = item.getDescription();
        TimelineComponentStyle.ConnectorStyle connectorStyle = null;
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(description != null ? createTextComponentStyle(styleFactoryScope, description) : null);
        Result<IconComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateIconComponentStyle = createIconComponentStyle(styleFactoryScope, item.getIcon());
        TimelineComponent.Connector connector = item.getConnector();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull((connector == null || (color = connector.getColor()) == null) ? null : ColorStyleKt.toColorStyles(color, this.colorAliases));
        Result.Success success = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, resultCreateTextComponentStyle, resultOrSuccessfullyNull, resultCreateIconComponentStyle, resultOrSuccessfullyNull2, success})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Intrinsics.checkNotNull(resultCreateTextComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultCreateTextComponentStyle).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultCreateIconComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultCreateIconComponentStyle).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        ColorStyles colorStyles = (ColorStyles) value5;
        IconComponentStyle iconComponentStyle = (IconComponentStyle) value4;
        TextComponentStyle textComponentStyle = (TextComponentStyle) value3;
        TextComponentStyle textComponentStyle2 = (TextComponentStyle) value2;
        List list = (List) value;
        TimelineComponent.Connector connector2 = item.getConnector();
        if (connector2 != null && colorStyles != null) {
            connectorStyle = new TimelineComponentStyle.ConnectorStyle(connector2.getWidth(), PaddingKt.toPaddingValues(connector2.getMargin(), true), colorStyles);
        }
        TimelineComponentStyle.ConnectorStyle connectorStyle2 = connectorStyle;
        Boolean visible = item.getVisible();
        return new Result.Success(new TimelineComponentStyle.ItemStyle(textComponentStyle2, visible != null ? visible.booleanValue() : true, textComponentStyle, iconComponentStyle, connectorStyle2, styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list));
    }

    private final Result<CarouselComponentStyle, NonEmptyList<PaywallValidationError>> createCarouselComponentStyle(StyleFactoryScope styleFactoryScope, CarouselComponent carouselComponent) {
        Result.Success success;
        Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(carouselComponent.getOverrides(), this.stripRules, new Function1<PartialCarouselComponent, Result<? extends PresentedCarouselPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createCarouselComponentStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedCarouselPartial, NonEmptyList<PaywallValidationError>> invoke(PartialCarouselComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return PresentedCarouselPartial.INSTANCE.invoke(partial, StyleFactory.this.colorAliases);
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (presentedOverrides instanceof Result.Error) {
                presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        List pages = carouselComponent.getPages();
        ArrayList<Result> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages, 10));
        Iterator it = pages.iterator();
        while (it.hasNext()) {
            arrayList.add(createStackComponentStyle(styleFactoryScope, (StackComponent) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Result result : arrayList) {
            if (result instanceof Result.Success) {
                if (arrayList3.isEmpty()) {
                    arrayList2.add((StackComponentStyle) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList3.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList3);
        if (nonEmptyListOrNull != null) {
            success = new Result.Error(nonEmptyListOrNull);
        } else {
            success = new Result.Success(arrayList2);
        }
        Border border = carouselComponent.getBorder();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, this.colorAliases) : null);
        Shadow shadow = carouselComponent.getShadow();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, this.colorAliases) : null);
        Result<BackgroundStyles, NonEmptyList<PaywallValidationError>> resultCreateBackgroundStyles = createBackgroundStyles(carouselComponent.getBackground(), carouselComponent.getBackgroundColor());
        CarouselComponent.PageControl pageControl = carouselComponent.getPageControl();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(pageControl != null ? PageControlExtensionsKt.toPageControlStyles(pageControl, this.colorAliases) : null);
        NonEmptyList nonEmptyListOrNull2 = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, success, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultCreateBackgroundStyles, resultOrSuccessfullyNull3})));
        if (nonEmptyListOrNull2 != null) {
            return new Result.Error(nonEmptyListOrNull2);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Object value2 = ((Result.Success) success).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultCreateBackgroundStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultCreateBackgroundStyles).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<F of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        CarouselComponentStyle.PageControlStyles pageControlStyles = (CarouselComponentStyle.PageControlStyles) ((Result.Success) resultOrSuccessfullyNull3).getValue();
        BackgroundStyles backgroundStyles = (BackgroundStyles) value5;
        ShadowStyles shadowStyles = (ShadowStyles) value4;
        BorderStyles borderStyles = (BorderStyles) value3;
        List list = (List) value2;
        List list2 = (List) value;
        List pages2 = carouselComponent.getPages();
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages2, 10));
        Iterator it2 = pages2.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((StackComponent) it2.next()).getName());
        }
        ArrayList arrayList5 = arrayList4;
        Integer initialPageIndex = carouselComponent.getInitialPageIndex();
        int iIntValue = initialPageIndex != null ? initialPageIndex.intValue() : 0;
        Alignment.Vertical alignment = AlignmentKt.toAlignment(carouselComponent.getPageAlignment());
        Boolean visible = carouselComponent.getVisible();
        boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
        Size size = carouselComponent.getSize();
        float fM11017constructorimpl = C1486Dp.m11017constructorimpl(carouselComponent.getPagePeek() != null ? r1.intValue() : 0);
        Float pageSpacing = carouselComponent.getPageSpacing();
        float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(pageSpacing != null ? pageSpacing.floatValue() : 0.0f);
        PaddingValues paddingValues = PaddingKt.toPaddingValues(carouselComponent.getPadding(), true);
        PaddingValues paddingValues2 = PaddingKt.toPaddingValues(carouselComponent.getMargin(), true);
        Shape.Rectangle shape = carouselComponent.getShape();
        if (shape == null) {
            shape = DEFAULT_SHAPE;
        }
        Shape shape2 = shape;
        Boolean loop = carouselComponent.getLoop();
        return new Result.Success(new CarouselComponentStyle(list, arrayList5, iIntValue, alignment, zBooleanValue, size, fM11017constructorimpl, fM11017constructorimpl2, backgroundStyles, paddingValues, paddingValues2, shape2, borderStyles, shadowStyles, pageControlStyles, loop != null ? loop.booleanValue() : false, carouselComponent.getAutoAdvance(), styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list2, carouselComponent.getName(), null));
    }

    private final Result<TabControlButtonComponentStyle, NonEmptyList<PaywallValidationError>> createTabControlButtonComponentStyle(StyleFactoryScope styleFactoryScope, final TabControlButtonComponent tabControlButtonComponent) {
        return (Result) styleFactoryScope.withSelectedScope(null, Integer.valueOf(tabControlButtonComponent.getTabIndex()), new Function1<StyleFactoryScope, Result<? extends TabControlButtonComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabControlButtonComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<TabControlButtonComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                withSelectedScope.setDefaultTabIndex(0);
                Result<TabControlButtonComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = StyleFactory.this.createStackComponentStyle(withSelectedScope, tabControlButtonComponent.getStack());
                TabControlButtonComponent tabControlButtonComponent2 = tabControlButtonComponent;
                if (resultCreateStackComponentStyle instanceof Result.Success) {
                    return new Result.Success(new TabControlButtonComponentStyle(tabControlButtonComponent2.getTabIndex(), tabControlButtonComponent2.getTabId(), (StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue(), withSelectedScope.getEnclosingTabsComponentName(), tabControlButtonComponent2.getName(), withSelectedScope.getEnclosingTabsOrderedTabIds(), withSelectedScope.getEnclosingTabContextNamesById(), withSelectedScope.getEnclosingTabsDefaultTabIndexForInteraction()));
                }
                if (resultCreateStackComponentStyle instanceof Result.Error) {
                    return resultCreateStackComponentStyle;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    private final Result<TabControlToggleComponentStyle, NonEmptyList<PaywallValidationError>> createTabControlToggleComponentStyle(StyleFactoryScope styleFactoryScope, TabControlToggleComponent tabControlToggleComponent) {
        Result colorStyles = ColorStyleKt.toColorStyles(tabControlToggleComponent.getThumbColorOn(), this.colorAliases);
        Result colorStyles2 = ColorStyleKt.toColorStyles(tabControlToggleComponent.getThumbColorOff(), this.colorAliases);
        Result colorStyles3 = ColorStyleKt.toColorStyles(tabControlToggleComponent.getTrackColorOn(), this.colorAliases);
        Result colorStyles4 = ColorStyleKt.toColorStyles(tabControlToggleComponent.getTrackColorOff(), this.colorAliases);
        Result.Success success = new Result.Success(Unit.INSTANCE);
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{colorStyles, colorStyles2, colorStyles3, colorStyles4, success, success2})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(colorStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) colorStyles).getValue();
        Intrinsics.checkNotNull(colorStyles2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) colorStyles2).getValue();
        Intrinsics.checkNotNull(colorStyles3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) colorStyles3).getValue();
        Intrinsics.checkNotNull(colorStyles4, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) colorStyles4).getValue();
        Object value5 = success.getValue();
        ColorStyles colorStyles5 = (ColorStyles) value4;
        ColorStyles colorStyles6 = (ColorStyles) value3;
        ColorStyles colorStyles7 = (ColorStyles) value2;
        ColorStyles colorStyles8 = (ColorStyles) value;
        styleFactoryScope.setDefaultTabIndex(tabControlToggleComponent.getDefaultValue() ? 1 : 0);
        String enclosingTabsComponentName = styleFactoryScope.getEnclosingTabsComponentName();
        if (enclosingTabsComponentName == null) {
            enclosingTabsComponentName = tabControlToggleComponent.getName();
        }
        return new Result.Success(new TabControlToggleComponentStyle(colorStyles8, colorStyles7, colorStyles6, colorStyles5, enclosingTabsComponentName));
    }

    private final Result<TabsComponentStyle, NonEmptyList<PaywallValidationError>> createTabsComponentStyle(StyleFactoryScope styleFactoryScope, final TabsComponent tabsComponent) {
        return (Result) styleFactoryScope.withTabsInteractionContext(tabsComponent.getName(), tabsComponent.getTabs(), tabsComponent.getDefaultTabId(), new Function1<StyleFactoryScope, Result<? extends TabsComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<TabsComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withTabsInteractionContext) {
                Intrinsics.checkNotNullParameter(withTabsInteractionContext, "$this$withTabsInteractionContext");
                Result<TabsComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateTabsComponentStyleTabControl = StyleFactory.this.createTabsComponentStyleTabControl(withTabsInteractionContext, tabsComponent.getControl());
                TabsComponent tabsComponent2 = tabsComponent;
                final StyleFactory styleFactory = StyleFactory.this;
                if (resultCreateTabsComponentStyleTabControl instanceof Result.Success) {
                    TabControlStyle tabControlStyle = (TabControlStyle) ((Result.Success) resultCreateTabsComponentStyleTabControl).getValue();
                    String defaultTabId = tabsComponent2.getDefaultTabId();
                    if (defaultTabId != null) {
                        if (StringsKt.isBlank(defaultTabId)) {
                            defaultTabId = null;
                        }
                        if (defaultTabId != null) {
                            Iterator it = tabsComponent2.getTabs().iterator();
                            int i = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i = -1;
                                    break;
                                }
                                if (Intrinsics.areEqual(((TabsComponent.Tab) it.next()).getId(), defaultTabId)) {
                                    break;
                                }
                                i++;
                            }
                            Integer numValueOf = Integer.valueOf(i);
                            if (numValueOf.intValue() == -1) {
                                numValueOf = null;
                            }
                            if (numValueOf != null) {
                                withTabsInteractionContext.setDefaultTabIndex(Integer.valueOf(numValueOf.intValue()));
                            }
                        }
                    }
                    Result.Error presentedOverrides = PresentedPartialKt.toPresentedOverrides(tabsComponent2.getOverrides(), styleFactory.stripRules, new Function1<PartialTabsComponent, Result<? extends PresentedTabsPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createTabsComponentStyle$1$1$5
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Result<PresentedTabsPartial, NonEmptyList<PaywallValidationError>> invoke(PartialTabsComponent partial) {
                            Intrinsics.checkNotNullParameter(partial, "partial");
                            return PresentedTabsPartial.INSTANCE.invoke(partial, styleFactory.colorAliases);
                        }
                    });
                    if (!(presentedOverrides instanceof Result.Success)) {
                        if (presentedOverrides instanceof Result.Error) {
                            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    Result resultCreateTabsComponentStyleTabs = styleFactory.createTabsComponentStyleTabs(withTabsInteractionContext, tabsComponent2.getTabs(), tabControlStyle);
                    Result resultCreateBackgroundStyles = styleFactory.createBackgroundStyles(tabsComponent2.getBackground(), tabsComponent2.getBackgroundColor());
                    Border border = tabsComponent2.getBorder();
                    Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, styleFactory.colorAliases) : null);
                    Shadow shadow = tabsComponent2.getShadow();
                    Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, styleFactory.colorAliases) : null);
                    Result.Success success = new Result.Success(Unit.INSTANCE);
                    NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, resultCreateTabsComponentStyleTabs, resultCreateBackgroundStyles, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, success})));
                    if (nonEmptyListOrNull != null) {
                        return new Result.Error(nonEmptyListOrNull);
                    }
                    Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                    Object value = ((Result.Success) presentedOverrides).getValue();
                    Intrinsics.checkNotNull(resultCreateTabsComponentStyleTabs, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                    Object value2 = ((Result.Success) resultCreateTabsComponentStyleTabs).getValue();
                    Intrinsics.checkNotNull(resultCreateBackgroundStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                    Object value3 = ((Result.Success) resultCreateBackgroundStyles).getValue();
                    Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                    Object value4 = ((Result.Success) resultOrSuccessfullyNull).getValue();
                    Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                    Object value5 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
                    ShadowStyles shadowStyles = (ShadowStyles) value5;
                    BorderStyles borderStyles = (BorderStyles) value4;
                    BackgroundStyles backgroundStyles = (BackgroundStyles) value3;
                    NonEmptyList nonEmptyList = (NonEmptyList) value2;
                    List list = (List) value;
                    Boolean visible = tabsComponent2.getVisible();
                    boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
                    Size size = tabsComponent2.getSize();
                    PaddingValues paddingValues = PaddingKt.toPaddingValues(tabsComponent2.getPadding(), true);
                    PaddingValues paddingValues2 = PaddingKt.toPaddingValues(tabsComponent2.getMargin(), true);
                    Shape.Rectangle shape = tabsComponent2.getShape();
                    if (shape == null) {
                        shape = StyleFactory.INSTANCE.getDEFAULT_SHAPE$revenuecatui_defaultsRelease();
                    }
                    return new Result.Success(new TabsComponentStyle(zBooleanValue, size, paddingValues, paddingValues2, backgroundStyles, shape, borderStyles, shadowStyles, tabControlStyle, nonEmptyList, list, tabsComponent2.getStateUpdates()));
                }
                if (resultCreateTabsComponentStyleTabControl instanceof Result.Error) {
                    return resultCreateTabsComponentStyleTabControl;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<TabControlStyle, NonEmptyList<PaywallValidationError>> createTabsComponentStyleTabControl(StyleFactoryScope styleFactoryScope, final TabsComponent.TabControl tabControl) {
        return (Result) styleFactoryScope.withSelectedScope(null, null, new Function1<StyleFactoryScope, Result<? extends TabControlStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyleTabControl.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<TabControlStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                TabsComponent.TabControl tabControl2 = tabControl;
                if (tabControl2 instanceof TabsComponent.TabControl.Buttons) {
                    Result<TabControlStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = this.createStackComponentStyle(withSelectedScope, ((TabsComponent.TabControl.Buttons) tabControl2).getStack());
                    if (resultCreateStackComponentStyle instanceof Result.Success) {
                        return new Result.Success(new TabControlStyle.Buttons((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue()));
                    }
                    if (resultCreateStackComponentStyle instanceof Result.Error) {
                        return resultCreateStackComponentStyle;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (tabControl2 instanceof TabsComponent.TabControl.Toggle) {
                    Result<TabControlStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle2 = this.createStackComponentStyle(withSelectedScope, ((TabsComponent.TabControl.Toggle) tabControl2).getStack());
                    if (resultCreateStackComponentStyle2 instanceof Result.Success) {
                        return new Result.Success(new TabControlStyle.Toggle((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle2).getValue()));
                    }
                    if (resultCreateStackComponentStyle2 instanceof Result.Error) {
                        return resultCreateStackComponentStyle2;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<NonEmptyList<TabsComponentStyle.Tab>, NonEmptyList<PaywallValidationError>> createTabsComponentStyleTabs(final StyleFactoryScope styleFactoryScope, List<TabsComponent.Tab> list, final TabControlStyle tabControlStyle) {
        Result<NonEmptyList<TabsComponentStyle.Tab>, NonEmptyList<PaywallValidationError>> resultErrorIfNull = ResultKt.errorIfNull(NonEmptyListKt.toNonEmptyListOrNull(list), NonEmptyListKt.nonEmptyListOf(PaywallValidationError.TabsComponentWithoutTabs.INSTANCE, new PaywallValidationError.TabsComponentWithoutTabs[0]));
        if (resultErrorIfNull instanceof Result.Success) {
            return NonEmptyListKt.flatten(((NonEmptyList) ((Result.Success) resultErrorIfNull).getValue()).mapIndexed(new Function2<Integer, TabsComponent.Tab, Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createTabsComponentStyleTabs$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> invoke(int i, TabsComponent.Tab tab) {
                    Intrinsics.checkNotNullParameter(tab, "tab");
                    return this.this$0.createTabsComponentStyleTab(styleFactoryScope, tab, tabControlStyle, i);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>> invoke(Integer num, TabsComponent.Tab tab) {
                    return invoke(num.intValue(), tab);
                }
            }));
        }
        if (resultErrorIfNull instanceof Result.Error) {
            return resultErrorIfNull;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> createTabsComponentStyleTab(StyleFactoryScope styleFactoryScope, final TabsComponent.Tab tab, final TabControlStyle tabControlStyle, final int i) {
        return (Result) styleFactoryScope.withSelectedScope(null, null, new Function1<StyleFactoryScope, Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyleTab.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                int i2 = i;
                final TabControlStyle tabControlStyle2 = tabControlStyle;
                final StyleFactory styleFactory = this;
                final TabsComponent.Tab tab2 = tab;
                return (Result) withSelectedScope.withTabIndex(i2, new Function1<StyleFactoryScope, Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyleTab.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withTabIndex) {
                        Intrinsics.checkNotNullParameter(withTabIndex, "$this$withTabIndex");
                        TabControlStyle tabControlStyle3 = tabControlStyle2;
                        final StyleFactory styleFactory2 = styleFactory;
                        final TabsComponent.Tab tab3 = tab2;
                        return (Result) withTabIndex.withTabControl(tabControlStyle3, new Function1<StyleFactoryScope, Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyleTab.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withTabControl) {
                                Intrinsics.checkNotNullParameter(withTabControl, "$this$withTabControl");
                                Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = styleFactory2.createStackComponentStyle(withTabControl, tab3.getStack());
                                TabsComponent.Tab tab4 = tab3;
                                if (resultCreateStackComponentStyle instanceof Result.Success) {
                                    return new Result.Success(new TabsComponentStyle.Tab(tab4.getId(), (StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue()));
                                }
                                if (resultCreateStackComponentStyle instanceof Result.Error) {
                                    return resultCreateStackComponentStyle;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                        });
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<BackgroundStyles, NonEmptyList<PaywallValidationError>> createBackgroundStyles(Background background, ColorScheme backgroundColor) {
        Result.Success colorStyles;
        Result<BackgroundStyles, NonEmptyList<PaywallValidationError>> backgroundStyles;
        if (background != null && (backgroundStyles = BackgroundStyleKt.toBackgroundStyles(background, this.colorAliases)) != null) {
            return backgroundStyles;
        }
        if (backgroundColor == null || (colorStyles = ColorStyleKt.toColorStyles(backgroundColor, this.colorAliases)) == null) {
            colorStyles = null;
        } else if (colorStyles instanceof Result.Success) {
            colorStyles = new Result.Success(BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl((ColorStyles) ((Result.Success) colorStyles).getValue())));
        } else if (!(colorStyles instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return ResultKt.orSuccessfullyNull(colorStyles);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: withLocalizedOverrides-TDPsjl0, reason: not valid java name */
    public final Result<NonEmptyMap<LocaleId, ThemeImageUrls>, NonEmptyList<PaywallValidationError.MissingImageLocalization>> m14011withLocalizedOverridesTDPsjl0(ThemeImageUrls themeImageUrls, String str) {
        Result<NonEmptyMap<LocaleId, ThemeImageUrls>, NonEmptyList<PaywallValidationError.MissingImageLocalization>> resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(str != null ? LocalizationKt.m13898imageForAllLocales7v81vok(this.localizations, str) : null);
        if (resultOrSuccessfullyNull instanceof Result.Success) {
            NonEmptyMap nonEmptyMap = (NonEmptyMap) ((Result.Success) resultOrSuccessfullyNull).getValue();
            Pair pairM1606to = TuplesKt.m1606to(this.localizations.getEntry().getKey(), themeImageUrls);
            NonEmptyMap nonEmptyMapEmptyMap = nonEmptyMap;
            if (nonEmptyMapEmptyMap == null) {
                nonEmptyMapEmptyMap = MapsKt.emptyMap();
            }
            return new Result.Success(NonEmptyMapKt.nonEmptyMapOf(pairM1606to, nonEmptyMapEmptyMap));
        }
        if (resultOrSuccessfullyNull instanceof Result.Error) {
            return resultOrSuccessfullyNull;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: withLocalizedOverrides-TDPsjl0, reason: not valid java name */
    public final Result<NonEmptyMap<LocaleId, ThemeVideoUrls>, NonEmptyList<PaywallValidationError.MissingVideoLocalization>> m14012withLocalizedOverridesTDPsjl0(ThemeVideoUrls themeVideoUrls, String str) {
        Result<NonEmptyMap<LocaleId, ThemeVideoUrls>, NonEmptyList<PaywallValidationError.MissingVideoLocalization>> resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(str != null ? LocalizationKt.m13905videoForAllLocales7v81vok(this.localizations, str) : null);
        if (resultOrSuccessfullyNull instanceof Result.Success) {
            NonEmptyMap nonEmptyMap = (NonEmptyMap) ((Result.Success) resultOrSuccessfullyNull).getValue();
            Pair pairM1606to = TuplesKt.m1606to(this.localizations.getEntry().getKey(), themeVideoUrls);
            NonEmptyMap nonEmptyMapEmptyMap = nonEmptyMap;
            if (nonEmptyMapEmptyMap == null) {
                nonEmptyMapEmptyMap = MapsKt.emptyMap();
            }
            return new Result.Success(NonEmptyMapKt.nonEmptyMapOf(pairM1606to, nonEmptyMapEmptyMap));
        }
        if (resultOrSuccessfullyNull instanceof Result.Error) {
            return resultOrSuccessfullyNull;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Package getPackageOrNull(Offering offering, String str) {
        try {
            return offering.getPackage(str);
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}

package com.revenuecat.purchases.p036ui.revenuecatui.components;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.emergetools.snapshots.annotations.EmergeSnapshotConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.data.MockPurchasesType;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ImagePreviewsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResultKt;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.ImageComponent;
import com.revenuecat.purchases.paywalls.components.PackageComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.PaywallTransition;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TextComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.paywalls.components.common.PromoOfferConfig;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0006\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\n\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002¨\u0006\u000b"}, m1599d2 = {"LoadedPaywallComponents_Header_ZLayer_Preview", "", "(Landroidx/compose/runtime/Composer;I)V", "LoadedPaywallComponents_Preview_CenteredBodyFooter", "LoadedPaywallComponents_Preview_DirectImageAsBackground", "LoadedPaywallComponents_Preview_HeaderDirectHeroImage", "LoadedPaywallComponents_Preview_HeaderNestedStackWithImage", "LoadedPaywallComponents_Preview_HeaderNoZStackNoImage", "LoadedPaywallComponents_Preview_HeaderTextOnly", "LoadedPaywallComponents_Preview_LargeFooter", "LoadedPaywallComponents_Preview_TransparentFooter", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class LoadedPaywallComponentsPreviewsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Header_ZLayer_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-187042489);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Header_ZLayer_Preview)197@10101L48,205@10423L20,205@10445L173,205@10397L221:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-187042489, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Header_ZLayer_Preview (LoadedPaywallComponentsPreviews.kt:66)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            URL url = new URL("https://assets.pawwalls.com/1172568_1774614615_69db5d9d.webp");
            ButtonComponent buttonComponent = new ButtonComponent(ButtonComponent.Action.NavigateBack.INSTANCE, new StackComponent(CollectionsKt.listOf(new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8174getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65266, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, (List) null, 60, (DefaultConstructorMarker) null);
            Offering offering = new Offering("header_zlayer", "Header with ZLayer image + text", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_zlayer", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new ImageComponent(new ThemeImageUrls(new ImageUrls(url, url, url, 1024, 1024, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null), (Boolean) null, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (String) null, (MaskShape) null, (ColorScheme) null, FitMode.FIT, (Padding) null, (Padding) null, (Border) null, (Shadow) null, (List) null, 4026, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m13834constructorimpl("overlay-text"), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4284677123L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, HorizontalAlignment.LEADING, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, (Padding) null, (List) null, (String) null, 15484, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_LEADING), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m13834constructorimpl("title"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 24, HorizontalAlignment.CENTER, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, new Padding(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 50.0d, 50.0d), (List) null, (String) null, 13404, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("footer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16380, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), (Size) null, (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65498, (DefaultConstructorMarker) null)), new HeaderComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(buttonComponent), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 63474, (DefaultConstructorMarker) null)))), MapsKt.mapOf(TuplesKt.m1606to(LocaleId.m13797boximpl(LocaleId.m13798constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("title")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("overlay-text")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Featured"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("footer")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Try free for 1 week")))))), LocaleId.m13798constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, false, (Map) null, 4032, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Header_ZLayer_Preview$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, null, null, 63, null), null, null, null, null, null, 496, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(-969555742, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Header_ZLayer_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C206@10455L157:LoadedPaywallComponentsPreviews.kt#dnqhhd");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-969555742, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Header_ZLayer_Preview.<anonymous> (LoadedPaywallComponentsPreviews.kt:206)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new AnonymousClass1(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composer2, 432, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Header_ZLayer_Preview$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
                @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Header_ZLayer_Preview$1$1", m1609f = "LoadedPaywallComponentsPreviews.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Header_ZLayer_Preview.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Header_ZLayer_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void LoadedPaywallComponents_Preview_HeaderDirectHeroImage(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1461797559);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_HeaderDirectHeroImage)456@23319L48,464@23641L20,464@23663L156,464@23615L204:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1461797559, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderDirectHeroImage (LoadedPaywallComponentsPreviews.kt:219)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8185getWhite0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme3 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4283782485L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            URL url = new URL("https://assets.pawwalls.com/1172568_1774614837_7df8aa27.webp");
            ImageComponent imageComponent = new ImageComponent(new ThemeImageUrls(new ImageUrls(url, url, url, 1024, 1024, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null), (Boolean) null, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (String) null, (MaskShape) null, new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), FitMode.FIT, (Padding) null, (Padding) null, (Border) null, (Shadow) null, (List) null, 3994, (DefaultConstructorMarker) null);
            ButtonComponent buttonComponent = new ButtonComponent(ButtonComponent.Action.NavigateBack.INSTANCE, new StackComponent(CollectionsKt.listOf(new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8174getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65266, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, (List) null, 60, (DefaultConstructorMarker) null);
            Offering offering = new Offering("header_direct_hero", "Header with direct hero image", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_direct_hero", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new TextComponent(LocalizationKey.m13834constructorimpl("title"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 24, HorizontalAlignment.CENTER, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, new Padding(16.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 50.0d, 50.0d), (List) null, (String) null, 13404, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m13834constructorimpl("subtitle"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 15, HorizontalAlignment.CENTER, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, new Padding(8.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 24.0d, 24.0d), (List) null, (String) null, 13436, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new PackageComponent("$rc_annual", true, new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("package-info"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, HorizontalAlignment.LEADING, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, (Padding) null, (List) null, (String) null, 15484, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, new Shape.Rectangle(new CornerRadiuses.C7411Dp(8.0d)), (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65010, (DefaultConstructorMarker) null), (PromoOfferConfig) null, (String) null, (Boolean) null, (List) null, 120, (DefaultConstructorMarker) null), new PurchaseButtonComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("cta"), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4278979596L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, FontWeight.SEMI_BOLD, (Integer) null, 16, HorizontalAlignment.CENTER, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, (Padding) null, (List) null, (String) null, 15452, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, new ColorScheme(new ColorInfo.Gradient.Linear(15.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4286377127L)), 0.0f), new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4286509283L)), 100.0f)})), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, new Padding(12.0d, 12.0d, 8.0d, 8.0d), (Padding) null, new Shape.Rectangle(new CornerRadiuses.C7411Dp(12.0d)), (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(2156724156L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 8.0d, 4.0d, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 62802, (DefaultConstructorMarker) null), (PurchaseButtonComponent.Action) null, (PurchaseButtonComponent.Method) null, (String) null, 14, (DefaultConstructorMarker) null), new StackComponent(CollectionsKt.listOf(new ButtonComponent(ButtonComponent.Action.RestorePurchases.INSTANCE, new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("restore"), colorScheme3, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.SEMI_BOLD, (Integer) null, 13, HorizontalAlignment.LEADING, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, (Padding) null, (List) null, (String) null, 15452, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.SPACE_BETWEEN), new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, (List) null, 60, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Horizontal(VerticalAlignment.TOP, FlexDistribution.CENTER), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), Float.valueOf(32.0f), (ColorScheme) null, (Background) null, (Padding) null, new Padding(12.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65250, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, colorScheme2, (Background) null, new Padding(12.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 16.0d, 16.0d), (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(251658240))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, -4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 63314, (DefaultConstructorMarker) null)), new HeaderComponent(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{imageComponent, buttonComponent}), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, new Border(new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(1140850688))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 1.0d), (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 64498, (DefaultConstructorMarker) null)))), MapsKt.mapOf(TuplesKt.m1606to(LocaleId.m13797boximpl(LocaleId.m13798constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("title")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("subtitle")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("AI-powered flashcards, smart scheduling, and progress tracking."))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("package-info")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Subscribe to Pro for just {{ product.price_per_period_abbreviated }}"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("cta")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Continue"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("restore")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Restore Purchases")))))), LocaleId.m13798constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, false, (Map) null, 4032, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderDirectHeroImage$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, null, null, 63, null), null, null, null, null, null, 496, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(-122765852, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderDirectHeroImage.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C465@23673L140:LoadedPaywallComponentsPreviews.kt#dnqhhd");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-122765852, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderDirectHeroImage.<anonymous> (LoadedPaywallComponentsPreviews.kt:465)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new AnonymousClass1(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composer2, 432, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderDirectHeroImage$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
                @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderDirectHeroImage$1$1", m1609f = "LoadedPaywallComponentsPreviews.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderDirectHeroImage.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderDirectHeroImage(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_HeaderTextOnly(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(762914118);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_HeaderTextOnly)694@35733L48,702@36055L20,702@36077L156,702@36029L204:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(762914118, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderTextOnly (LoadedPaywallComponentsPreviews.kt:476)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme3 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4283124041L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ButtonComponent buttonComponent = new ButtonComponent(ButtonComponent.Action.NavigateBack.INSTANCE, new StackComponent(CollectionsKt.listOf(new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8174getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65266, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, (List) null, 60, (DefaultConstructorMarker) null);
            List listListOf = CollectionsKt.listOf((Object[]) new String[]{"feature-1", "feature-2"});
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                arrayList.add(new TextComponent(LocalizationKey.m13834constructorimpl((String) it.next()), colorScheme3, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), new Padding(2.0d, 2.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), (Padding) null, (List) null, (String) null, 14460, (DefaultConstructorMarker) null));
            }
            Offering offering = new Offering("header_text_only", "Header with text only (no hero image)", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_text_only", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new TextComponent(LocalizationKey.m13834constructorimpl("title"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 24, HorizontalAlignment.CENTER, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, new Padding(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 50.0d, 50.0d), (List) null, (String) null, 13404, (DefaultConstructorMarker) null), new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.plus((Collection) CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("features-header"), colorScheme2, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 16, HorizontalAlignment.LEADING, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, (Padding) null, (List) null, (String) null, 15452, (DefaultConstructorMarker) null)), (Iterable) arrayList), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), Float.valueOf(4.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65394, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new PurchaseButtonComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("cta"), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4278979596L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, FontWeight.SEMI_BOLD, (Integer) null, 16, HorizontalAlignment.CENTER, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, (Padding) null, (List) null, (String) null, 15452, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, new ColorScheme(new ColorInfo.Gradient.Linear(15.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4286377127L)), 0.0f), new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4286509283L)), 100.0f)})), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, new Padding(12.0d, 12.0d, 8.0d, 8.0d), (Padding) null, new Shape.Rectangle(new CornerRadiuses.C7411Dp(12.0d)), (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 64850, (DefaultConstructorMarker) null), (PurchaseButtonComponent.Action) null, (PurchaseButtonComponent.Method) null, (String) null, 14, (DefaultConstructorMarker) null), new StackComponent(CollectionsKt.listOf(new ButtonComponent(ButtonComponent.Action.RestorePurchases.INSTANCE, new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("restore"), colorScheme3, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.SEMI_BOLD, (Integer) null, 13, HorizontalAlignment.LEADING, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, (Padding) null, (List) null, (String) null, 15452, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.SPACE_BETWEEN), new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, (List) null, 60, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Horizontal(VerticalAlignment.TOP, FlexDistribution.CENTER), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(12.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65266, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, colorScheme2, (Background) null, new Padding(12.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 16.0d, 16.0d), (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(251658240))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, -4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 63314, (DefaultConstructorMarker) null)), new HeaderComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(buttonComponent), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 63474, (DefaultConstructorMarker) null)))), MapsKt.mapOf(TuplesKt.m1606to(LocaleId.m13797boximpl(LocaleId.m13798constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("title")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("features-header")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Features"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("feature-1")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Assignment Tracker"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("feature-2")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("AI-generated Study Plans"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("cta")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Continue"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("restore")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Restore Purchases")))))), LocaleId.m13798constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, false, (Map) null, 4032, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderTextOnly$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, null, null, 63, null), null, null, null, null, null, 496, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(-2020160245, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderTextOnly.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C703@36087L140:LoadedPaywallComponentsPreviews.kt#dnqhhd");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2020160245, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderTextOnly.<anonymous> (LoadedPaywallComponentsPreviews.kt:703)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new AnonymousClass1(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composer2, 432, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderTextOnly$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
                @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderTextOnly$1$1", m1609f = "LoadedPaywallComponentsPreviews.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderTextOnly.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderTextOnly(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_HeaderNoZStackNoImage(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1717104956);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_HeaderNoZStackNoImage)813@40945L48,821@41267L20,821@41289L156,821@41241L204:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1717104956, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage (LoadedPaywallComponentsPreviews.kt:714)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            Offering offering = new Offering("header_no_zstack_no_image", "Header with no ZStack and no image", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_no_zstack_no_image", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new TextComponent(LocalizationKey.m13834constructorimpl("title"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 24, HorizontalAlignment.CENTER, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, new Padding(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 50.0d, 50.0d), (List) null, (String) null, 13404, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("footer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16380, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), (Size) null, (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65498, (DefaultConstructorMarker) null)), new HeaderComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(new ButtonComponent(ButtonComponent.Action.NavigateBack.INSTANCE, new StackComponent(CollectionsKt.listOf(new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8174getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65266, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, (List) null, 60, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 63474, (DefaultConstructorMarker) null)))), MapsKt.mapOf(TuplesKt.m1606to(LocaleId.m13797boximpl(LocaleId.m13798constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("title")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("footer")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Try free for 1 week")))))), LocaleId.m13798constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, false, (Map) null, 4032, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNoZStackNoImage$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, null, null, 63, null), null, null, null, null, null, 496, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(-1238830633, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C822@41299L140:LoadedPaywallComponentsPreviews.kt#dnqhhd");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1238830633, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage.<anonymous> (LoadedPaywallComponentsPreviews.kt:822)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new AnonymousClass1(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composer2, 432, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNoZStackNoImage$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
                @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNoZStackNoImage$1$1", m1609f = "LoadedPaywallComponentsPreviews.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_DirectImageAsBackground(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1936797168);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_DirectImageAsBackground)921@45509L48,929@45831L20,929@45853L156,929@45805L204:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1936797168, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_DirectImageAsBackground (LoadedPaywallComponentsPreviews.kt:833)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            URL url = new URL("https://assets.pawwalls.com/1172568_1774614837_7df8aa27.webp");
            Offering offering = new Offering("direct_image_background", "Direct image as background, no header", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_direct_image_background", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("overlay-text"), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4294508801L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, HorizontalAlignment.LEADING, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, (Padding) null, (List) null, (String) null, 15484, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_LEADING), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fixed(300, null)), (Float) null, (ColorScheme) null, new Background.Image(new ThemeImageUrls(new ImageUrls(url, url, url, 1024, 1024, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null), FitMode.FILL, (ColorScheme) null, 4, (DefaultConstructorMarker) null), (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65458, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m13834constructorimpl("title"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 24, HorizontalAlignment.CENTER, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, new Padding(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 50.0d, 50.0d), (List) null, (String) null, 13404, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("footer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16380, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), (Size) null, (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65498, (DefaultConstructorMarker) null)), (HeaderComponent) null, 8, (DefaultConstructorMarker) null)), MapsKt.mapOf(TuplesKt.m1606to(LocaleId.m13797boximpl(LocaleId.m13798constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("title")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("overlay-text")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Text in stack"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("footer")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Try free for 1 week")))))), LocaleId.m13798constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, false, (Map) null, 4032, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_DirectImageAsBackground$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, null, null, 63, null), null, null, null, null, null, 496, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(677451755, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_DirectImageAsBackground.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C930@45863L140:LoadedPaywallComponentsPreviews.kt#dnqhhd");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(677451755, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_DirectImageAsBackground.<anonymous> (LoadedPaywallComponentsPreviews.kt:930)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new AnonymousClass1(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composer2, 432, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_DirectImageAsBackground$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
                @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_DirectImageAsBackground$1$1", m1609f = "LoadedPaywallComponentsPreviews.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_DirectImageAsBackground.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_DirectImageAsBackground(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_HeaderNestedStackWithImage(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(847814897);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_HeaderNestedStackWithImage)1078@52437L48,1086@52759L20,1086@52781L156,1086@52733L204:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(847814897, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage (LoadedPaywallComponentsPreviews.kt:941)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            URL url = new URL("https://assets.pawwalls.com/1172568_1774614837_7df8aa27.webp");
            ButtonComponent buttonComponent = new ButtonComponent(ButtonComponent.Action.NavigateBack.INSTANCE, new StackComponent(CollectionsKt.listOf(new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8174getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65266, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, (List) null, 60, (DefaultConstructorMarker) null);
            Offering offering = new Offering("header_nested_stack_image", "Header with nested stack containing image", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_nested_stack_image", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new ImageComponent(new ThemeImageUrls(new ImageUrls(url, url, url, 1024, 1024, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null), (Boolean) null, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (String) null, (MaskShape) null, (ColorScheme) null, FitMode.FIT, (Padding) null, (Padding) null, (Border) null, (Shadow) null, (List) null, 4026, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m13834constructorimpl("overlay-text"), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4294508801L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, HorizontalAlignment.LEADING, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, (Padding) null, (List) null, (String) null, 15484, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_LEADING), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m13834constructorimpl("title"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 24, HorizontalAlignment.CENTER, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, new Padding(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 50.0d, 50.0d), (List) null, (String) null, 13404, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("footer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16380, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), (Size) null, (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65498, (DefaultConstructorMarker) null)), new HeaderComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(buttonComponent), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 63474, (DefaultConstructorMarker) null)))), MapsKt.mapOf(TuplesKt.m1606to(LocaleId.m13797boximpl(LocaleId.m13798constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("title")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("overlay-text")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Text in stack"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("footer")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Try free for 1 week")))))), LocaleId.m13798constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, false, (Map) null, 4032, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNestedStackWithImage$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, null, null, 63, null), null, null, null, null, null, 496, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(1295501622, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C1087@52791L140:LoadedPaywallComponentsPreviews.kt#dnqhhd");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1295501622, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage.<anonymous> (LoadedPaywallComponentsPreviews.kt:1087)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new AnonymousClass1(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composer2, 432, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNestedStackWithImage$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
                @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
                @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNestedStackWithImage$1$1", m1609f = "LoadedPaywallComponentsPreviews.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [kotlin.UInt, kotlin.jvm.internal.DefaultConstructorMarker] */
    public static final void LoadedPaywallComponents_Preview_TransparentFooter(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(445047691);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_TransparentFooter)1201@58349L48,1209@58645L124:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(445047691, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_TransparentFooter (LoadedPaywallComponentsPreviews.kt:1105)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4280756007L))), new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4294835709L))));
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4294835709L))), new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4279374354L))));
            ColorScheme colorScheme3 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(2567273563L))), new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(2567273563L))));
            ?? r5 = 0;
            char c = 2;
            ColorScheme colorScheme4 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8185getWhite0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme5 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4278549595L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            int i2 = 1;
            IntRange intRange = new IntRange(1, 25);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                ArrayList arrayList2 = arrayList;
                arrayList2.add(new TextComponent(LocalizationKey.m13834constructorimpl("feature-" + ((IntIterator) it).nextInt()), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) r5, i2, (DefaultConstructorMarker) r5)), (Padding) null, new Padding(8.0d, 8.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), (List) null, (String) null, 13564, (DefaultConstructorMarker) null));
                i2 = i2;
                arrayList = arrayList2;
                r5 = 0;
                c = 2;
                colorScheme3 = colorScheme3;
            }
            ColorScheme colorScheme6 = colorScheme3;
            int i3 = i2;
            URL url = new URL("https://assets.pawwalls.com");
            ComponentsConfig componentsConfig = new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.plus((Collection) CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("title"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 28, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, i3, (DefaultConstructorMarker) null)), (Padding) null, new Padding(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 24.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), (List) null, (String) null, 13404, (DefaultConstructorMarker) null)), (Iterable) arrayList), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, new Padding(32.0d, 16.0d, 32.0d, 32.0d), (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65394, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("cta"), colorScheme4, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16348, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.CENTER), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, i3, (DefaultConstructorMarker) null)), (Float) null, colorScheme5, (Background) null, new Padding(16.0d, 16.0d, 32.0d, 32.0d), (Padding) null, Shape.Pill.INSTANCE, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 64850, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, i3, (DefaultConstructorMarker) null)), (Float) null, colorScheme6, (Background) null, new Padding(16.0d, 16.0d, 32.0d, 32.0d), (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65362, (DefaultConstructorMarker) null)), (HeaderComponent) null, 8, (DefaultConstructorMarker) null));
            LocaleId localeIdM13797boximpl = LocaleId.m13797boximpl(LocaleId.m13798constructorimpl("en_US"));
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("title")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Unlock everything")));
            pairArr[i3] = TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("cta")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Continue")));
            Map mapMapOf = MapsKt.mapOf(pairArr);
            IntRange intRange2 = new IntRange(i3, 25);
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange2, 10)), 16));
            Iterator<Integer> it2 = intRange2.iterator();
            while (it2.hasNext()) {
                int iNextInt = ((IntIterator) it2).nextInt();
                Pair pairM1606to = TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("feature-" + iNextInt)), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("✓ Premium feature number " + iNextInt)));
                linkedHashMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
            }
            Offering offering = new Offering("transparent_footer", "Transparent overlapping footer", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_transparent_footer", "template", url, componentsConfig, MapsKt.mapOf(TuplesKt.m1606to(localeIdM13797boximpl, MapsKt.plus(mapMapOf, linkedHashMap))), LocaleId.m13798constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, false, (Map) null, 4032, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            LoadedPaywallComponentsKt.LoadedPaywallComponents(OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_TransparentFooter$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, null, null, 63, null), null, null, null, null, null, 496, null), new C75581(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, i3, null), null, composerStartRestartGroup, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_TransparentFooter.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_TransparentFooter(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_TransparentFooter$1 */
    /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_TransparentFooter$1", m1609f = "LoadedPaywallComponentsPreviews.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C75581 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C75581(Continuation<? super C75581> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C75581(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C75581) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_CenteredBodyFooter(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-811946735);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_CenteredBodyFooter)1301@63295L48,1309@63591L124:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-811946735, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_CenteredBodyFooter (LoadedPaywallComponentsPreviews.kt:1223)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            Offering offering = new Offering("centered_body_footer", "Centered body with footer", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_centered_body_footer", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new TextComponent[]{new TextComponent(LocalizationKey.m13834constructorimpl("title"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 28, HorizontalAlignment.CENTER, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, new Padding(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 12.0d, 32.0d, 32.0d), (List) null, (String) null, 13404, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m13834constructorimpl("subtitle"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, HorizontalAlignment.CENTER, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, new Padding(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 32.0d, 32.0d), (List) null, (String) null, 13564, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.CENTER), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null), new Background.Color(new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null)), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("cta"), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8185getWhite0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16348, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.CENTER), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4278861102L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, new Padding(16.0d, 16.0d, 32.0d, 32.0d), (Padding) null, Shape.Pill.INSTANCE, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 64850, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(2567273563L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, new Padding(16.0d, 16.0d, 32.0d, 32.0d), (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65362, (DefaultConstructorMarker) null)), (HeaderComponent) null, 8, (DefaultConstructorMarker) null)), MapsKt.mapOf(TuplesKt.m1606to(LocaleId.m13797boximpl(LocaleId.m13798constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("title")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Centered body"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("subtitle")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("This should be centered above the footer"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("cta")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Continue")))))), LocaleId.m13798constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, false, (Map) null, 4032, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            LoadedPaywallComponentsKt.LoadedPaywallComponents(OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_CenteredBodyFooter$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, null, null, 63, null), null, null, null, null, null, 496, null), new C75371(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composerStartRestartGroup, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_CenteredBodyFooter.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_CenteredBodyFooter(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_CenteredBodyFooter$1 */
    /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_CenteredBodyFooter$1", m1609f = "LoadedPaywallComponentsPreviews.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C75371 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C75371(Continuation<? super C75371> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C75371(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C75371) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_LargeFooter(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1392829644);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_LargeFooter)1417@68916L48,1425@69212L124:LoadedPaywallComponentsPreviews.kt#dnqhhd");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1392829644, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_LargeFooter (LoadedPaywallComponentsPreviews.kt:1323)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme3 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4278549595L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme4 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8185getWhite0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme5 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4278861102L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            char c = '\b';
            IntRange intRange = new IntRange(1, 8);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                ArrayList arrayList2 = arrayList;
                arrayList2.add(new TextComponent(LocalizationKey.m13834constructorimpl("footer-line-" + ((IntIterator) it).nextInt()), colorScheme4, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, HorizontalAlignment.CENTER, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, new Padding(6.0d, 6.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), (List) null, (String) null, 13564, (DefaultConstructorMarker) null));
                arrayList = arrayList2;
                c = '\b';
            }
            URL url = new URL("https://assets.pawwalls.com");
            ComponentsConfig componentsConfig = new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new TextComponent[]{new TextComponent(LocalizationKey.m13834constructorimpl("title"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 28, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, new Padding(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 12.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), (List) null, (String) null, 13404, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m13834constructorimpl("subtitle"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Padding) null, (Padding) null, (List) null, (String) null, 15612, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, new Padding(32.0d, 16.0d, 32.0d, 32.0d), (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65394, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.plus((Collection<? extends StackComponent>) arrayList, new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("cta"), colorScheme4, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16348, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.CENTER), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, colorScheme5, (Background) null, new Padding(16.0d, 16.0d, 32.0d, 32.0d), new Padding(16.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), Shape.Pill.INSTANCE, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 64594, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.CENTER), new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fixed(520, null)), (Float) null, colorScheme3, (Background) null, new Padding(24.0d, 24.0d, 32.0d, 32.0d), (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65362, (DefaultConstructorMarker) null)), (HeaderComponent) null, 8, (DefaultConstructorMarker) null));
            LocaleId localeIdM13797boximpl = LocaleId.m13797boximpl(LocaleId.m13798constructorimpl("en_US"));
            Map mapMapOf = MapsKt.mapOf(TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("title")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Big footer"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("subtitle")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("The footer below is taller than half the screen."))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("cta")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Continue"))));
            IntRange intRange2 = new IntRange(1, 8);
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(intRange2, 10)), 16));
            Iterator<Integer> it2 = intRange2.iterator();
            while (it2.hasNext()) {
                int iNextInt = ((IntIterator) it2).nextInt();
                Pair pairM1606to = TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("footer-line-" + iNextInt)), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Footer line " + iNextInt)));
                linkedHashMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
            }
            Offering offering = new Offering("large_footer", "Footer taller than half the screen", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_large_footer", "template", url, componentsConfig, MapsKt.mapOf(TuplesKt.m1606to(localeIdM13797boximpl, MapsKt.plus(mapMapOf, linkedHashMap))), LocaleId.m13798constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, false, (Map) null, 4032, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            LoadedPaywallComponentsKt.LoadedPaywallComponents(OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_LargeFooter$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, null, null, 63, null), null, null, null, null, null, 496, null), new C75551(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composerStartRestartGroup, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_LargeFooter.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_LargeFooter(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_LargeFooter$1 */
    /* JADX INFO: compiled from: LoadedPaywallComponentsPreviews.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_LargeFooter$1", m1609f = "LoadedPaywallComponentsPreviews.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C75551 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C75551(Continuation<? super C75551> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C75551(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C75551) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }
}

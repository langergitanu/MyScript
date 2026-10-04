package com.revenuecat.purchases.p036ui.revenuecatui.components.properties;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.TileMode;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.tooling.preview.PreviewParameter;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.ColorAlias;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResultKt;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorStyle.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0007\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\t\u001a\r\u0010\u000b\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\t\u001a\r\u0010\f\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\t\u001a\r\u0010\r\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\t\u001a\r\u0010\u000e\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\t\u001a\u0017\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\t\u001a\\\u0010\u0013\u001a\u00020\u00142*\u0010\u0015\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00180\u00170\u0016\"\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001aP\u0010 \u001a\u00020\u00142*\u0010\u0015\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00180\u00170\u0016\"\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0003ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a)\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00180\u00170\u0016*\b\u0012\u0004\u0012\u00020%0$H\u0002¢\u0006\u0002\u0010&\u001a4\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(*\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,2\u0006\u0010/\u001a\u000200H\u0000\u001a\f\u0010'\u001a\u00020\u0003*\u000201H\u0000\u001a2\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020)030(*\u00020.2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, m1599d2 = {"PERCENT_SCALE", "", "forCurrentTheme", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getForCurrentTheme", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "LinearGradient_Preview_Rectangle", "", "(Landroidx/compose/runtime/Composer;I)V", "LinearGradient_Preview_Rectangle_OrangeCyan", "LinearGradient_Preview_Rectangle_RedBlue", "LinearGradient_Preview_Rectangle_Template014Button", "LinearGradient_Preview_Square", "LinearGradient_Preview_Square_BluePink", "LinearGradient_Preview_SquaresDegrees", "degrees", "(FLandroidx/compose/runtime/Composer;I)V", "RadialGradient_Preview", "radialGradient", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;", "colorStops", "", "Lkotlin/Pair;", "Landroidx/compose/ui/graphics/Color;", TtmlNode.CENTER, "Landroidx/compose/ui/geometry/Offset;", "radius", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "radialGradient-P_Vx-Ks", "([Lkotlin/Pair;JFI)Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;", "relativeLinearGradient", "relativeLinearGradient-3YTHUZs", "([Lkotlin/Pair;FI)Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;", "toColorStops", "", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient$Point;", "(Ljava/util/List;)[Lkotlin/Pair;", "toColorStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo;", "aliases", "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "useLightAlias", "", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Gradient;", "toColorStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ColorStyleKt {
    private static final float PERCENT_SCALE = 100.0f;

    public static final /* synthetic */ ColorStyle getForCurrentTheme(ColorStyles colorStyles, Composer composer, int i) {
        ColorStyle light;
        Intrinsics.checkNotNullParameter(colorStyles, "<this>");
        composer.startReplaceGroup(-375069960);
        ComposerKt.sourceInformation(composer, "C(<get-forCurrentTheme>)75@2890L21:ColorStyle.kt#nqkcqm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-375069960, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.<get-forCurrentTheme> (ColorStyle.kt:75)");
        }
        if (!DarkThemeKt.isSystemInDarkTheme(composer, 0) || (light = colorStyles.getDark()) == null) {
            light = colorStyles.getLight();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return light;
    }

    public static final /* synthetic */ ColorStyle toColorStyle(ColorInfo.Gradient gradient) {
        GradientBrush gradientBrushM13953radialGradientP_VxKs$default;
        Intrinsics.checkNotNullParameter(gradient, "<this>");
        if (gradient instanceof ColorInfo.Gradient.Linear) {
            ColorInfo.Gradient.Linear linear = (ColorInfo.Gradient.Linear) gradient;
            Pair<Float, Color>[] colorStops = toColorStops(linear.getPoints());
            gradientBrushM13953radialGradientP_VxKs$default = m13955relativeLinearGradient3YTHUZs$default((Pair[]) Arrays.copyOf(colorStops, colorStops.length), linear.getDegrees(), 0, 4, null);
        } else {
            if (!(gradient instanceof ColorInfo.Gradient.Radial)) {
                throw new NoWhenBranchMatchedException();
            }
            Pair<Float, Color>[] colorStops2 = toColorStops(((ColorInfo.Gradient.Radial) gradient).getPoints());
            gradientBrushM13953radialGradientP_VxKs$default = m13953radialGradientP_VxKs$default((Pair[]) Arrays.copyOf(colorStops2, colorStops2.length), 0L, 0.0f, 0, 14, null);
        }
        return ColorStyle.Gradient.m13937boximpl(ColorStyle.Gradient.m13938constructorimpl(gradientBrushM13953radialGradientP_VxKs$default));
    }

    public static final /* synthetic */ Result toColorStyles(ColorScheme colorScheme, Map aliases) {
        Intrinsics.checkNotNullParameter(colorScheme, "<this>");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Result.Error colorStyle = toColorStyle(colorScheme.getLight(), aliases, true);
        if (!(colorStyle instanceof Result.Success)) {
            if (colorStyle instanceof Result.Error) {
                colorStyle = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) colorStyle).getValue(), new PaywallValidationError[0]));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        ColorInfo dark = colorScheme.getDark();
        Result.Error errorOrSuccessfullyNull = ResultKt.orSuccessfullyNull(dark != null ? toColorStyle(dark, aliases, false) : null);
        if (!(errorOrSuccessfullyNull instanceof Result.Success)) {
            if (errorOrSuccessfullyNull instanceof Result.Error) {
                errorOrSuccessfullyNull = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) errorOrSuccessfullyNull).getValue(), new PaywallValidationError[0]));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        Result.Success success = new Result.Success(Unit.INSTANCE);
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        Result.Success success3 = new Result.Success(Unit.INSTANCE);
        Result.Success success4 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{colorStyle, errorOrSuccessfullyNull, success, success2, success3, success4})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(colorStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) colorStyle).getValue();
        Intrinsics.checkNotNull(errorOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) errorOrSuccessfullyNull).getValue();
        Object value3 = success.getValue();
        Object value4 = success2.getValue();
        Object value5 = success3.getValue();
        return new Result.Success(new ColorStyles((ColorStyle) value, (ColorStyle) value2));
    }

    public static final /* synthetic */ Result toColorStyle(ColorInfo colorInfo, Map aliases, boolean z) {
        GradientBrush gradientBrushM13953radialGradientP_VxKs$default;
        ColorInfo light;
        ColorInfo dark;
        Intrinsics.checkNotNullParameter(colorInfo, "<this>");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (colorInfo instanceof ColorInfo.Alias) {
            ColorInfo.Alias alias = (ColorInfo.Alias) colorInfo;
            ColorScheme colorScheme = (ColorScheme) aliases.get(ColorAlias.m13622boximpl(alias.getValue()));
            if (colorScheme != null) {
                light = (z || (dark = colorScheme.getDark()) == null) ? colorScheme.getLight() : dark;
            } else {
                light = null;
            }
            if (light instanceof ColorInfo.Gradient ? true : light instanceof ColorInfo.Hex) {
                return toColorStyle(light, aliases, z);
            }
            if (light instanceof ColorInfo.Alias) {
                return new Result.Error(new PaywallValidationError.AliasedColorIsAlias(alias.getValue(), ((ColorInfo.Alias) light).getValue(), defaultConstructorMarker));
            }
            if (light == null) {
                return new Result.Error(new PaywallValidationError.MissingColorAlias(alias.getValue(), defaultConstructorMarker));
            }
            throw new NoWhenBranchMatchedException();
        }
        if (colorInfo instanceof ColorInfo.Hex) {
            return new Result.Success(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(ColorKt.Color(((ColorInfo.Hex) colorInfo).getValue()))));
        }
        if (!(colorInfo instanceof ColorInfo.Gradient)) {
            throw new NoWhenBranchMatchedException();
        }
        if (colorInfo instanceof ColorInfo.Gradient.Linear) {
            ColorInfo.Gradient.Linear linear = (ColorInfo.Gradient.Linear) colorInfo;
            Pair<Float, Color>[] colorStops = toColorStops(linear.getPoints());
            gradientBrushM13953radialGradientP_VxKs$default = m13955relativeLinearGradient3YTHUZs$default((Pair[]) Arrays.copyOf(colorStops, colorStops.length), linear.getDegrees(), 0, 4, null);
        } else {
            if (!(colorInfo instanceof ColorInfo.Gradient.Radial)) {
                throw new NoWhenBranchMatchedException();
            }
            Pair<Float, Color>[] colorStops2 = toColorStops(((ColorInfo.Gradient.Radial) colorInfo).getPoints());
            gradientBrushM13953radialGradientP_VxKs$default = m13953radialGradientP_VxKs$default((Pair[]) Arrays.copyOf(colorStops2, colorStops2.length), 0L, 0.0f, 0, 14, null);
        }
        return new Result.Success(ColorStyle.Gradient.m13937boximpl(ColorStyle.Gradient.m13938constructorimpl(gradientBrushM13953radialGradientP_VxKs$default)));
    }

    private static final Pair<Float, Color>[] toColorStops(List<ColorInfo.Gradient.Point> list) {
        List<ColorInfo.Gradient.Point> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ColorInfo.Gradient.Point point : list2) {
            arrayList.add(TuplesKt.m1606to(Float.valueOf(point.getPercent() / PERCENT_SCALE), Color.m8138boximpl(ColorKt.Color(point.getColor()))));
        }
        return (Pair[]) arrayList.toArray(new Pair[0]);
    }

    /* JADX INFO: renamed from: relativeLinearGradient-3YTHUZs$default, reason: not valid java name */
    static /* synthetic */ GradientBrush m13955relativeLinearGradient3YTHUZs$default(Pair[] pairArr, float f, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = TileMode.INSTANCE.m8545getClamp3opZhB0();
        }
        return m13954relativeLinearGradient3YTHUZs(pairArr, f, i);
    }

    /* JADX INFO: renamed from: relativeLinearGradient-3YTHUZs, reason: not valid java name */
    private static final GradientBrush m13954relativeLinearGradient3YTHUZs(Pair<Float, Color>[] pairArr, float f, int i) {
        ArrayList arrayList = new ArrayList(pairArr.length);
        for (Pair<Float, Color> pair : pairArr) {
            arrayList.add(Color.m8138boximpl(pair.getSecond().m8158unboximpl()));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(pairArr.length);
        for (Pair<Float, Color> pair2 : pairArr) {
            arrayList3.add(Float.valueOf(pair2.getFirst().floatValue()));
        }
        return new RelativeLinearGradient(arrayList2, arrayList3, f, i, null);
    }

    /* JADX INFO: renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
    static /* synthetic */ GradientBrush m13953radialGradientP_VxKs$default(Pair[] pairArr, long j, float f, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = Offset.INSTANCE.m7918getUnspecifiedF1C5BW0();
        }
        if ((i2 & 4) != 0) {
            f = Float.POSITIVE_INFINITY;
        }
        if ((i2 & 8) != 0) {
            i = TileMode.INSTANCE.m8545getClamp3opZhB0();
        }
        return m13952radialGradientP_VxKs(pairArr, j, f, i);
    }

    /* JADX INFO: renamed from: radialGradient-P_Vx-Ks, reason: not valid java name */
    private static final GradientBrush m13952radialGradientP_VxKs(Pair<Float, Color>[] pairArr, long j, float f, int i) {
        return new RadialGradient((Pair[]) Arrays.copyOf(pairArr, pairArr.length), j, f, i, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_Square(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1721100010);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearGradient_Preview_Square)301@11096L400:ColorStyle.kt#nqkcqm");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1721100010, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_Square (ColorStyle.kt:300)");
            }
            BoxKt.Box(BackgroundKt.background$default(SizeKt.m2916requiredSize3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(200)), m13955relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.m1606to(Float.valueOf(0.0f), Color.m8138boximpl(Color.INSTANCE.m8186getYellow0d7_KjU())), TuplesKt.m1606to(Float.valueOf(0.5f), Color.m8138boximpl(Color.INSTANCE.m8182getRed0d7_KjU())), TuplesKt.m1606to(Float.valueOf(1.0f), Color.m8138boximpl(Color.INSTANCE.m8175getBlue0d7_KjU()))}, 45.0f, 0, 4, null), null, 0.0f, 6, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_Square.1
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
                    ColorStyleKt.LinearGradient_Preview_Square(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_Rectangle(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2011369738);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearGradient_Preview_Rectangle)321@11599L408:ColorStyle.kt#nqkcqm");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2011369738, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_Rectangle (ColorStyle.kt:320)");
            }
            BoxKt.Box(BackgroundKt.background$default(SizeKt.m2918requiredSizeVpY3zN4(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(300), C1486Dp.m11017constructorimpl(100)), m13955relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.m1606to(Float.valueOf(0.0f), Color.m8138boximpl(Color.INSTANCE.m8186getYellow0d7_KjU())), TuplesKt.m1606to(Float.valueOf(0.5f), Color.m8138boximpl(Color.INSTANCE.m8182getRed0d7_KjU())), TuplesKt.m1606to(Float.valueOf(1.0f), Color.m8138boximpl(Color.INSTANCE.m8175getBlue0d7_KjU()))}, 45.0f, 0, 4, null), null, 0.0f, 6, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_Rectangle.1
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
                    ColorStyleKt.LinearGradient_Preview_Rectangle(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_Rectangle_RedBlue(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1224320034);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearGradient_Preview_Rectangle_RedBlue)343@12221L361:ColorStyle.kt#nqkcqm");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1224320034, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_Rectangle_RedBlue (ColorStyle.kt:342)");
            }
            BoxKt.Box(BackgroundKt.background$default(SizeKt.m2918requiredSizeVpY3zN4(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(300), C1486Dp.m11017constructorimpl(55)), m13955relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.m1606to(Float.valueOf(0.0f), Color.m8138boximpl(Color.INSTANCE.m8182getRed0d7_KjU())), TuplesKt.m1606to(Float.valueOf(1.0f), Color.m8138boximpl(Color.INSTANCE.m8175getBlue0d7_KjU()))}, 45.0f, 0, 4, null), null, 0.0f, 6, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_Rectangle_RedBlue.1
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
                    ColorStyleKt.LinearGradient_Preview_Rectangle_RedBlue(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_Rectangle_OrangeCyan(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-123893266);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearGradient_Preview_Rectangle_OrangeCyan)365@12842L399:ColorStyle.kt#nqkcqm");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-123893266, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_Rectangle_OrangeCyan (ColorStyle.kt:364)");
            }
            BoxKt.Box(BackgroundKt.background$default(SizeKt.m2918requiredSizeVpY3zN4(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(300), C1486Dp.m11017constructorimpl(55)), m13955relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.m1606to(Float.valueOf(0.6f), Color.m8138boximpl(ColorKt.Color$default(255, 165, 0, 0, 8, null))), TuplesKt.m1606to(Float.valueOf(1.0f), Color.m8138boximpl(Color.INSTANCE.m8176getCyan0d7_KjU()))}, 135.0f, 0, 4, null), null, 0.0f, 6, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_Rectangle_OrangeCyan.1
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
                    ColorStyleKt.LinearGradient_Preview_Rectangle_OrangeCyan(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_Rectangle_Template014Button(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1429933954);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearGradient_Preview_Rectangle_Template014Button)384@13362L556:ColorStyle.kt#nqkcqm");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1429933954, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_Rectangle_Template014Button (ColorStyle.kt:383)");
            }
            BoxKt.Box(BackgroundKt.background$default(SizeKt.m2918requiredSizeVpY3zN4(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(300), C1486Dp.m11017constructorimpl(55)), m13955relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.m1606to(Float.valueOf(0.0f), Color.m8138boximpl(ColorKt.Color$default(1, 1, 87, 0, 8, null))), TuplesKt.m1606to(Float.valueOf(0.46f), Color.m8138boximpl(ColorKt.Color$default(35, 35, 151, 0, 8, null))), TuplesKt.m1606to(Float.valueOf(1.0f), Color.m8138boximpl(ColorKt.Color$default(PDFACompliance.e_PDFA2_2_1, 2, 92, 0, 8, null)))}, 8.0f, 0, 4, null), RoundedCornerShapeKt.RoundedCornerShape(50), 0.0f, 4, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_Rectangle_Template014Button.1
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
                    ColorStyleKt.LinearGradient_Preview_Rectangle_Template014Button(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_Square_BluePink(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1487537977);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearGradient_Preview_Square_BluePink)407@14119L389:ColorStyle.kt#nqkcqm");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1487537977, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_Square_BluePink (ColorStyle.kt:406)");
            }
            BoxKt.Box(BackgroundKt.background$default(SizeKt.m2916requiredSize3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(100)), m13955relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.m1606to(Float.valueOf(0.0f), Color.m8138boximpl(Color.INSTANCE.m8175getBlue0d7_KjU())), TuplesKt.m1606to(Float.valueOf(1.0f), Color.m8138boximpl(ColorKt.Color$default(255, PsExtractor.AUDIO_STREAM, 203, 0, 8, null)))}, 70.0f, 0, 4, null), null, 0.0f, 6, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_Square_BluePink.1
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
                    ColorStyleKt.LinearGradient_Preview_Square_BluePink(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearGradient_Preview_SquaresDegrees(@PreviewParameter(provider = DegreesProvider.class) final float f, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1866931670);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearGradient_Preview_SquaresDegrees)440@14979L472:ColorStyle.kt#nqkcqm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1866931670, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.LinearGradient_Preview_SquaresDegrees (ColorStyle.kt:439)");
            }
            Modifier modifierBackground$default = BackgroundKt.background$default(SizeKt.m2916requiredSize3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(100)), m13955relativeLinearGradient3YTHUZs$default(new Pair[]{TuplesKt.m1606to(Float.valueOf(0.0f), Color.m8138boximpl(Color.INSTANCE.m8182getRed0d7_KjU())), TuplesKt.m1606to(Float.valueOf(1.0f), Color.m8138boximpl(Color.INSTANCE.m8185getWhite0d7_KjU()))}, f, 0, 4, null), null, 0.0f, 6, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -190621525, "C454@15394L51:ColorStyle.kt#nqkcqm");
            composer2 = composerStartRestartGroup;
            TextKt.m5868Text4IGK_g(f + "deg", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 0, 0, 131070);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.LinearGradient_Preview_SquaresDegrees.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    ColorStyleKt.LinearGradient_Preview_SquaresDegrees(f, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RadialGradient_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1776704032);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RadialGradient_Preview)463@15519L390:ColorStyle.kt#nqkcqm");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1776704032, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.RadialGradient_Preview (ColorStyle.kt:462)");
            }
            Modifier modifierBackground$default = BackgroundKt.background$default(SizeKt.m2918requiredSizeVpY3zN4(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(300), C1486Dp.m11017constructorimpl(100)), m13953radialGradientP_VxKs$default(new Pair[]{TuplesKt.m1606to(Float.valueOf(0.0f), Color.m8138boximpl(Color.INSTANCE.m8182getRed0d7_KjU())), TuplesKt.m1606to(Float.valueOf(1.0f), Color.m8138boximpl(Color.INSTANCE.m8185getWhite0d7_KjU()))}, 0L, 0.0f, 0, 14, null), null, 0.0f, 6, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 108467200, "C:ColorStyle.kt#nqkcqm");
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt.RadialGradient_Preview.2
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
                    ColorStyleKt.RadialGradient_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}

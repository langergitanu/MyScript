package com.myscript.android.utils.p019ui.compose.autosizetext;

import android.util.Log;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.material3.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextMeasurer;
import androidx.compose.p004ui.text.TextMeasurerHelperKt;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.text.style.TextOverflow;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DensityKt;
import androidx.compose.p004ui.unit.DpKt;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C2181C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AutoSizeText.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001aù\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)H\u0007¢\u0006\u0004\b*\u0010+\u001a\u008f\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020,2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020/0.2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u00100\u001a\u00020)H\u0007¢\u0006\u0004\b1\u00102\u001aL\u00103\u001a\u00020\u001f*\u0002042\u0006\u0010\u0004\u001a\u00020,2\u0006\u00105\u001a\u00020'2\u0006\u0010 \u001a\u00020!2\u0006\u00106\u001a\u0002072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002\u001a=\u0010>\u001a\u00020?2\u0006\u00108\u001a\u0002092\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000bH\u0003¢\u0006\u0004\bB\u0010C\u001a1\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E*\b\u0012\u0004\u0012\u0002HE0\n2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u0002HE\u0012\u0004\u0012\u00020\u001f0$H\u0000¢\u0006\u0002\u0010G\u001a?\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E*\u00020?2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u0002HE0$2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u0002HE\u0012\u0004\u0012\u00020\u001f0$H\u0002¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006J"}, m1599d2 = {"TAG", "", AutoSizeTextKt.TAG, "", "text", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "suggestedFontSizes", "", "Landroidx/compose/ui/unit/TextUnit;", "suggestedFontSizesStatus", "Lcom/myscript/android/utils/ui/compose/autosizetext/SuggestedFontSizesStatus;", "stepGranularityTextSize", "minTextSize", "maxTextSize", TtmlNode.ATTR_TTS_FONT_STYLE, "Landroidx/compose/ui/text/font/FontStyle;", TtmlNode.ATTR_TTS_FONT_WEIGHT, "Landroidx/compose/ui/text/font/FontWeight;", TtmlNode.ATTR_TTS_FONT_FAMILY, "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", TtmlNode.ATTR_TTS_TEXT_DECORATION, "Landroidx/compose/ui/text/style/TextDecoration;", "alignment", "Landroidx/compose/ui/Alignment;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Landroidx/compose/ui/text/TextStyle;", "lineSpaceRatio", "", "AutoSizeText-EUA8-Og", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JLjava/util/List;Lcom/myscript/android/utils/ui/compose/autosizetext/SuggestedFontSizesStatus;JJJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/Alignment;IZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/runtime/Composer;IIII)V", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "lineSpacingRatio", "AutoSizeText-VkjzWmM", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JLjava/util/List;Lcom/myscript/android/utils/ui/compose/autosizetext/SuggestedFontSizesStatus;JJJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/Alignment;IZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/runtime/Composer;IIII)V", "shouldShrink", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "textStyle", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "rememberCandidateFontSizesIntProgress", "Lkotlin/ranges/IntProgression;", "containerDpSize", "Landroidx/compose/ui/unit/DpSize;", "rememberCandidateFontSizesIntProgress-DC-WUXg", "(Landroidx/compose/ui/unit/Density;JJJJLandroidx/compose/runtime/Composer;II)Lkotlin/ranges/IntProgression;", "findElectedValue", ExifInterface.GPS_DIRECTION_TRUE, "shouldMoveBackward", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "transform", "(Lkotlin/ranges/IntProgression;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AutoSizeTextKt {
    private static final String TAG = "AutoSizeText";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSizeText_EUA8_Og$lambda$1(String str, Modifier modifier, long j, List list, SuggestedFontSizesStatus suggestedFontSizesStatus, long j2, long j3, long j4, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j5, TextDecoration textDecoration, Alignment alignment, int i, boolean z, int i2, int i3, Function1 function1, TextStyle textStyle, float f, int i4, int i5, int i6, int i7, Composer composer, int i8) {
        m12528AutoSizeTextEUA8Og(str, modifier, j, list, suggestedFontSizesStatus, j2, j3, j4, fontStyle, fontWeight, fontFamily, j5, textDecoration, alignment, i, z, i2, i3, function1, textStyle, f, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSizeText_VkjzWmM$lambda$2(AnnotatedString annotatedString, Modifier modifier, long j, List list, SuggestedFontSizesStatus suggestedFontSizesStatus, long j2, long j3, long j4, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j5, TextDecoration textDecoration, Alignment alignment, int i, boolean z, int i2, int i3, Map map, Function1 function1, TextStyle textStyle, float f, int i4, int i5, int i6, int i7, Composer composer, int i8) {
        m12529AutoSizeTextVkjzWmM(annotatedString, modifier, j, list, suggestedFontSizesStatus, j2, j3, j4, fontStyle, fontWeight, fontFamily, j5, textDecoration, alignment, i, z, i2, i3, map, function1, textStyle, f, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSizeText_EUA8_Og$lambda$0$0(TextLayoutResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:323:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013c  */
    /* JADX INFO: renamed from: AutoSizeText-EUA8-Og, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m12528AutoSizeTextEUA8Og(final String text, Modifier modifier, long j, List<TextUnit> list, SuggestedFontSizesStatus suggestedFontSizesStatus, long j2, long j3, long j4, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j5, TextDecoration textDecoration, Alignment alignment, int i, boolean z, int i2, int i3, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, float f, Composer composer, final int i4, final int i5, final int i6, final int i7) {
        int i8;
        Modifier modifier2;
        int i9;
        long jM8184getUnspecified0d7_KjU;
        int i10;
        int i11;
        int i12;
        long j6;
        int i13;
        int i14;
        long jM11222getUnspecifiedXSAIIZE;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        Composer composer2;
        final List<TextUnit> list2;
        final SuggestedFontSizesStatus suggestedFontSizesStatus2;
        final FontStyle fontStyle2;
        final long j7;
        final TextDecoration textDecoration2;
        final Alignment alignment2;
        final int i36;
        final boolean z2;
        final int i37;
        final int i38;
        final Function1<? super TextLayoutResult, Unit> function12;
        final TextStyle textStyle2;
        final float f2;
        final long j8;
        final Modifier modifier3;
        final long j9;
        final long j10;
        final long j11;
        final FontWeight fontWeight2;
        final FontFamily fontFamily2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM11222getUnspecifiedXSAIIZE2;
        Modifier modifier4;
        Function1<? super TextLayoutResult, Unit> function13;
        Function1<? super TextLayoutResult, Unit> function14;
        TextStyle textStyle3;
        Function1<? super TextLayoutResult, Unit> function15;
        TextStyle textStyle4;
        int i39;
        Alignment alignment3;
        int i40;
        FontStyle fontStyle3;
        FontFamily fontFamily3;
        Modifier modifier5;
        int i41;
        boolean z3;
        FontWeight fontWeight3;
        int i42;
        TextDecoration textDecoration3;
        long j12;
        float f3;
        List<TextUnit> list3;
        SuggestedFontSizesStatus suggestedFontSizesStatus3;
        long j13;
        long j14;
        long j15;
        int i43;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1922566056);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AutoSizeText)N(text,modifier,color:c#ui.graphics.Color,suggestedFontSizes,suggestedFontSizesStatus,stepGranularityTextSize:c#ui.unit.TextUnit,minTextSize:c#ui.unit.TextUnit,maxTextSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,alignment,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,onTextLayout,style,lineSpaceRatio)117@6560L775:AutoSizeText.kt#jo4mkz");
        if ((i4 & 6) == 0) {
            i8 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i4;
        } else {
            i8 = i4;
        }
        int i44 = i7 & 2;
        if (i44 != 0) {
            i8 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i8 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i9 = i7 & 4;
            if (i9 == 0) {
                i8 |= RendererCapabilities.DECODER_SUPPORT_MASK;
                jM8184getUnspecified0d7_KjU = j;
            } else {
                jM8184getUnspecified0d7_KjU = j;
                if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    i8 |= composerStartRestartGroup.changed(jM8184getUnspecified0d7_KjU) ? 256 : 128;
                }
            }
            i10 = i7 & 8;
            if (i10 == 0) {
                i8 |= 3072;
            } else {
                if ((i4 & 3072) == 0) {
                    i8 |= composerStartRestartGroup.changedInstance(list) ? 2048 : 1024;
                }
                i11 = i7 & 16;
                if (i11 != 0) {
                    i8 |= 24576;
                } else if ((i4 & 24576) == 0) {
                    i8 |= composerStartRestartGroup.changed(suggestedFontSizesStatus == null ? -1 : suggestedFontSizesStatus.ordinal()) ? 16384 : 8192;
                }
                i12 = i7 & 32;
                if (i12 != 0) {
                    i8 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                    j6 = j2;
                } else {
                    j6 = j2;
                    if ((i4 & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                        i8 |= composerStartRestartGroup.changed(j6) ? 131072 : 65536;
                    }
                }
                i13 = i7 & 64;
                if (i13 != 0) {
                    i8 |= 1572864;
                    i14 = i44;
                    jM11222getUnspecifiedXSAIIZE = j3;
                } else {
                    i14 = i44;
                    jM11222getUnspecifiedXSAIIZE = j3;
                    if ((i4 & 1572864) == 0) {
                        i8 |= composerStartRestartGroup.changed(jM11222getUnspecifiedXSAIIZE) ? 1048576 : 524288;
                    }
                }
                i15 = i7 & 128;
                if (i15 != 0) {
                    i8 |= 12582912;
                } else {
                    if ((i4 & 12582912) == 0) {
                        i16 = i8 | (composerStartRestartGroup.changed(j4) ? 8388608 : 4194304);
                    }
                    i17 = i7 & 256;
                    if (i17 == 0) {
                        i16 |= 100663296;
                    } else {
                        if ((i4 & 100663296) == 0) {
                            i18 = i17;
                            i16 |= composerStartRestartGroup.changed(fontStyle) ? 67108864 : 33554432;
                        }
                        i19 = i7 & 512;
                        if (i19 != 0) {
                            i16 |= 805306368;
                            i20 = i19;
                        } else if ((i4 & 805306368) == 0) {
                            i20 = i19;
                            i16 |= composerStartRestartGroup.changed(fontWeight) ? 536870912 : 268435456;
                        } else {
                            i20 = i19;
                        }
                        i21 = i16;
                        i22 = i7 & 1024;
                        if (i22 != 0) {
                            i23 = i5 | 6;
                        } else if ((i5 & 6) == 0) {
                            i23 = i5 | (composerStartRestartGroup.changed(fontFamily) ? 4 : 2);
                        } else {
                            i23 = i5;
                        }
                        i24 = i7 & 2048;
                        if (i24 != 0) {
                            i23 |= 48;
                            i25 = i24;
                        } else if ((i5 & 48) == 0) {
                            i25 = i24;
                            i23 |= composerStartRestartGroup.changed(j5) ? 32 : 16;
                        } else {
                            i25 = i24;
                        }
                        int i45 = i23;
                        i26 = i7 & 4096;
                        if (i26 != 0) {
                            i27 = i45 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            i27 = i45 | (composerStartRestartGroup.changed(textDecoration) ? 256 : 128);
                        } else {
                            i27 = i45;
                        }
                        i28 = i7 & 8192;
                        if (i28 != 0) {
                            i29 = i27 | 3072;
                        } else {
                            int i46 = i27;
                            if ((i5 & 3072) == 0) {
                                i29 = i46 | (composerStartRestartGroup.changed(alignment) ? 2048 : 1024);
                            } else {
                                i29 = i46;
                            }
                        }
                        i30 = i7 & 16384;
                        if (i30 == 0) {
                            if ((i5 & 24576) == 0) {
                                i29 |= composerStartRestartGroup.changed(i) ? 16384 : 8192;
                            }
                            i31 = i7 & 32768;
                            if (i31 == 0) {
                                i29 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                            } else if ((i5 & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                                i29 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
                            }
                            i32 = i7 & 65536;
                            if (i32 == 0) {
                                i29 |= 1572864;
                            } else if ((i5 & 1572864) == 0) {
                                i29 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i33 = i7 & 131072;
                            if (i33 == 0) {
                                i29 |= 12582912;
                            } else if ((i5 & 12582912) == 0) {
                                i29 |= composerStartRestartGroup.changed(i3) ? 8388608 : 4194304;
                            }
                            i34 = i7 & 262144;
                            if (i34 == 0) {
                                i29 |= 100663296;
                            } else if ((i5 & 100663296) == 0) {
                                i29 |= composerStartRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
                            }
                            if ((i5 & 805306368) == 0) {
                                i29 |= ((i7 & 524288) == 0 && composerStartRestartGroup.changed(textStyle)) ? 536870912 : 268435456;
                            }
                            if ((i6 & 6) != 0) {
                                i35 = i6 | (((i7 & 1048576) == 0 && composerStartRestartGroup.changed(f)) ? 4 : 2);
                            } else {
                                i35 = i6;
                            }
                            if (!composerStartRestartGroup.shouldExecute(((i21 & 306783379) != 306783378 && (306783379 & i29) == 306783378 && (i35 & 3) == 2) ? false : true, i21 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "113@6426L2,114@6468L7");
                                if ((i4 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i7 & 524288) != 0) {
                                        i29 &= -1879048193;
                                    }
                                    if ((i7 & 1048576) != 0) {
                                        i35 &= -15;
                                    }
                                    fontStyle3 = fontStyle;
                                    fontWeight3 = fontWeight;
                                    j12 = j5;
                                    textDecoration3 = textDecoration;
                                    alignment3 = alignment;
                                    i39 = i;
                                    z3 = z;
                                    i42 = i2;
                                    i41 = i3;
                                    function15 = function1;
                                    textStyle4 = textStyle;
                                    f3 = f;
                                    modifier5 = modifier2;
                                    j13 = j6;
                                    i40 = i35;
                                    jM11222getUnspecifiedXSAIIZE2 = j4;
                                    fontFamily3 = fontFamily;
                                    j14 = jM11222getUnspecifiedXSAIIZE;
                                    j15 = jM8184getUnspecified0d7_KjU;
                                    list3 = list;
                                    suggestedFontSizesStatus3 = suggestedFontSizesStatus;
                                } else {
                                    Modifier.Companion companion = i14 != 0 ? Modifier.INSTANCE : modifier2;
                                    if (i9 != 0) {
                                        jM8184getUnspecified0d7_KjU = Color.INSTANCE.m8184getUnspecified0d7_KjU();
                                    }
                                    List<TextUnit> listEmptyList = i10 != 0 ? CollectionsKt.emptyList() : list;
                                    SuggestedFontSizesStatus suggestedFontSizesStatus4 = i11 != 0 ? SuggestedFontSizesStatus.UNKNOWN : suggestedFontSizesStatus;
                                    long jM11222getUnspecifiedXSAIIZE3 = i12 != 0 ? TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE() : j6;
                                    if (i13 != 0) {
                                        jM11222getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE();
                                    }
                                    jM11222getUnspecifiedXSAIIZE2 = i15 != 0 ? TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE() : j4;
                                    FontStyle fontStyle4 = i18 != 0 ? null : fontStyle;
                                    FontWeight fontWeight4 = i20 != 0 ? null : fontWeight;
                                    FontFamily fontFamily4 = i22 != 0 ? null : fontFamily;
                                    long jM11222getUnspecifiedXSAIIZE4 = i25 != 0 ? TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE() : j5;
                                    TextDecoration textDecoration4 = i26 != 0 ? null : textDecoration;
                                    Alignment topStart = i28 != 0 ? Alignment.INSTANCE.getTopStart() : alignment;
                                    int iM10952getClipgIe3tQ8 = i30 != 0 ? TextOverflow.INSTANCE.m10952getClipgIe3tQ8() : i;
                                    boolean z4 = i31 != 0 ? true : z;
                                    int i47 = i32 != 0 ? Integer.MAX_VALUE : i2;
                                    int i48 = i33 == 0 ? i3 : 1;
                                    if (i34 != 0) {
                                        modifier4 = companion;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -750015398, "CC(remember):AutoSizeText.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = new Function1() { // from class: com.myscript.android.utils.ui.compose.autosizetext.AutoSizeTextKt$$ExternalSyntheticLambda0
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return AutoSizeTextKt.AutoSizeText_EUA8_Og$lambda$0$0((TextLayoutResult) obj);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        function13 = (Function1) objRememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    } else {
                                        modifier4 = companion;
                                        function13 = function1;
                                    }
                                    if ((i7 & 524288) != 0) {
                                        ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                        function14 = function13;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        textStyle3 = (TextStyle) objConsume;
                                        i29 &= -1879048193;
                                    } else {
                                        function14 = function13;
                                        textStyle3 = textStyle;
                                    }
                                    if ((i7 & 1048576) != 0) {
                                        float fM11211getValueimpl = TextUnit.m11211getValueimpl(textStyle3.m10492getLineHeightXSAIIZE()) / TextUnit.m11211getValueimpl(textStyle3.m10484getFontSizeXSAIIZE());
                                        function15 = function14;
                                        textStyle4 = textStyle3;
                                        i39 = iM10952getClipgIe3tQ8;
                                        alignment3 = topStart;
                                        i40 = i35 & (-15);
                                        fontStyle3 = fontStyle4;
                                        fontFamily3 = fontFamily4;
                                        modifier5 = modifier4;
                                        i41 = i48;
                                        z3 = z4;
                                        fontWeight3 = fontWeight4;
                                        i42 = i47;
                                        textDecoration3 = textDecoration4;
                                        j12 = jM11222getUnspecifiedXSAIIZE4;
                                        f3 = fM11211getValueimpl;
                                    } else {
                                        function15 = function14;
                                        textStyle4 = textStyle3;
                                        i39 = iM10952getClipgIe3tQ8;
                                        alignment3 = topStart;
                                        i40 = i35;
                                        fontStyle3 = fontStyle4;
                                        fontFamily3 = fontFamily4;
                                        modifier5 = modifier4;
                                        i41 = i48;
                                        z3 = z4;
                                        fontWeight3 = fontWeight4;
                                        i42 = i47;
                                        textDecoration3 = textDecoration4;
                                        j12 = jM11222getUnspecifiedXSAIIZE4;
                                        f3 = f;
                                    }
                                    long j16 = jM8184getUnspecified0d7_KjU;
                                    list3 = listEmptyList;
                                    suggestedFontSizesStatus3 = suggestedFontSizesStatus4;
                                    j13 = jM11222getUnspecifiedXSAIIZE3;
                                    j14 = jM11222getUnspecifiedXSAIIZE;
                                    j15 = j16;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    i43 = i40;
                                    ComposerKt.traceEventStart(-1922566056, i21, i29, "com.myscript.android.utils.ui.compose.autosizetext.AutoSizeText (AutoSizeText.kt:116)");
                                } else {
                                    i43 = i40;
                                }
                                int i49 = i29;
                                composer2 = composerStartRestartGroup;
                                m12529AutoSizeTextVkjzWmM(new AnnotatedString(text, null, 2, null), modifier5, j15, list3, suggestedFontSizesStatus3, j13, j14, jM11222getUnspecifiedXSAIIZE2, fontStyle3, fontWeight3, fontFamily3, j12, textDecoration3, alignment3, i39, z3, i42, i41, null, function15, textStyle4, f3, composer2, i21 & 2147483632, (33554430 & i49) | ((i49 << 3) & C2181C.ENCODING_PCM_DOUBLE), ((i49 >> 27) & 14) | ((i43 << 3) & 112), 262144);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier5;
                                j8 = j15;
                                list2 = list3;
                                suggestedFontSizesStatus2 = suggestedFontSizesStatus3;
                                j11 = j13;
                                j10 = j14;
                                j9 = jM11222getUnspecifiedXSAIIZE2;
                                fontStyle2 = fontStyle3;
                                fontWeight2 = fontWeight3;
                                fontFamily2 = fontFamily3;
                                j7 = j12;
                                textDecoration2 = textDecoration3;
                                alignment2 = alignment3;
                                i36 = i39;
                                z2 = z3;
                                i37 = i42;
                                i38 = i41;
                                function12 = function15;
                                textStyle2 = textStyle4;
                                f2 = f3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                list2 = list;
                                suggestedFontSizesStatus2 = suggestedFontSizesStatus;
                                fontStyle2 = fontStyle;
                                j7 = j5;
                                textDecoration2 = textDecoration;
                                alignment2 = alignment;
                                i36 = i;
                                z2 = z;
                                i37 = i2;
                                i38 = i3;
                                function12 = function1;
                                textStyle2 = textStyle;
                                f2 = f;
                                j8 = jM8184getUnspecified0d7_KjU;
                                modifier3 = modifier2;
                                j9 = j4;
                                j10 = jM11222getUnspecifiedXSAIIZE;
                                j11 = j6;
                                fontWeight2 = fontWeight;
                                fontFamily2 = fontFamily;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.android.utils.ui.compose.autosizetext.AutoSizeTextKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AutoSizeTextKt.AutoSizeText_EUA8_Og$lambda$1(text, modifier3, j8, list2, suggestedFontSizesStatus2, j11, j10, j9, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration2, alignment2, i36, z2, i37, i38, function12, textStyle2, f2, i4, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i29 |= 24576;
                        i31 = i7 & 32768;
                        if (i31 == 0) {
                        }
                        i32 = i7 & 65536;
                        if (i32 == 0) {
                        }
                        i33 = i7 & 131072;
                        if (i33 == 0) {
                        }
                        i34 = i7 & 262144;
                        if (i34 == 0) {
                        }
                        if ((i5 & 805306368) == 0) {
                        }
                        if ((i6 & 6) != 0) {
                        }
                        if (!composerStartRestartGroup.shouldExecute(((i21 & 306783379) != 306783378 && (306783379 & i29) == 306783378 && (i35 & 3) == 2) ? false : true, i21 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i18 = i17;
                    i19 = i7 & 512;
                    if (i19 != 0) {
                    }
                    i21 = i16;
                    i22 = i7 & 1024;
                    if (i22 != 0) {
                    }
                    i24 = i7 & 2048;
                    if (i24 != 0) {
                    }
                    int i452 = i23;
                    i26 = i7 & 4096;
                    if (i26 != 0) {
                    }
                    i28 = i7 & 8192;
                    if (i28 != 0) {
                    }
                    i30 = i7 & 16384;
                    if (i30 == 0) {
                    }
                    i31 = i7 & 32768;
                    if (i31 == 0) {
                    }
                    i32 = i7 & 65536;
                    if (i32 == 0) {
                    }
                    i33 = i7 & 131072;
                    if (i33 == 0) {
                    }
                    i34 = i7 & 262144;
                    if (i34 == 0) {
                    }
                    if ((i5 & 805306368) == 0) {
                    }
                    if ((i6 & 6) != 0) {
                    }
                    if (!composerStartRestartGroup.shouldExecute(((i21 & 306783379) != 306783378 && (306783379 & i29) == 306783378 && (i35 & 3) == 2) ? false : true, i21 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i16 = i8;
                i17 = i7 & 256;
                if (i17 == 0) {
                }
                i18 = i17;
                i19 = i7 & 512;
                if (i19 != 0) {
                }
                i21 = i16;
                i22 = i7 & 1024;
                if (i22 != 0) {
                }
                i24 = i7 & 2048;
                if (i24 != 0) {
                }
                int i4522 = i23;
                i26 = i7 & 4096;
                if (i26 != 0) {
                }
                i28 = i7 & 8192;
                if (i28 != 0) {
                }
                i30 = i7 & 16384;
                if (i30 == 0) {
                }
                i31 = i7 & 32768;
                if (i31 == 0) {
                }
                i32 = i7 & 65536;
                if (i32 == 0) {
                }
                i33 = i7 & 131072;
                if (i33 == 0) {
                }
                i34 = i7 & 262144;
                if (i34 == 0) {
                }
                if ((i5 & 805306368) == 0) {
                }
                if ((i6 & 6) != 0) {
                }
                if (!composerStartRestartGroup.shouldExecute(((i21 & 306783379) != 306783378 && (306783379 & i29) == 306783378 && (i35 & 3) == 2) ? false : true, i21 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i11 = i7 & 16;
            if (i11 != 0) {
            }
            i12 = i7 & 32;
            if (i12 != 0) {
            }
            i13 = i7 & 64;
            if (i13 != 0) {
            }
            i15 = i7 & 128;
            if (i15 != 0) {
            }
            i16 = i8;
            i17 = i7 & 256;
            if (i17 == 0) {
            }
            i18 = i17;
            i19 = i7 & 512;
            if (i19 != 0) {
            }
            i21 = i16;
            i22 = i7 & 1024;
            if (i22 != 0) {
            }
            i24 = i7 & 2048;
            if (i24 != 0) {
            }
            int i45222 = i23;
            i26 = i7 & 4096;
            if (i26 != 0) {
            }
            i28 = i7 & 8192;
            if (i28 != 0) {
            }
            i30 = i7 & 16384;
            if (i30 == 0) {
            }
            i31 = i7 & 32768;
            if (i31 == 0) {
            }
            i32 = i7 & 65536;
            if (i32 == 0) {
            }
            i33 = i7 & 131072;
            if (i33 == 0) {
            }
            i34 = i7 & 262144;
            if (i34 == 0) {
            }
            if ((i5 & 805306368) == 0) {
            }
            if ((i6 & 6) != 0) {
            }
            if (!composerStartRestartGroup.shouldExecute(((i21 & 306783379) != 306783378 && (306783379 & i29) == 306783378 && (i35 & 3) == 2) ? false : true, i21 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i9 = i7 & 4;
        if (i9 == 0) {
        }
        i10 = i7 & 8;
        if (i10 == 0) {
        }
        i11 = i7 & 16;
        if (i11 != 0) {
        }
        i12 = i7 & 32;
        if (i12 != 0) {
        }
        i13 = i7 & 64;
        if (i13 != 0) {
        }
        i15 = i7 & 128;
        if (i15 != 0) {
        }
        i16 = i8;
        i17 = i7 & 256;
        if (i17 == 0) {
        }
        i18 = i17;
        i19 = i7 & 512;
        if (i19 != 0) {
        }
        i21 = i16;
        i22 = i7 & 1024;
        if (i22 != 0) {
        }
        i24 = i7 & 2048;
        if (i24 != 0) {
        }
        int i452222 = i23;
        i26 = i7 & 4096;
        if (i26 != 0) {
        }
        i28 = i7 & 8192;
        if (i28 != 0) {
        }
        i30 = i7 & 16384;
        if (i30 == 0) {
        }
        i31 = i7 & 32768;
        if (i31 == 0) {
        }
        i32 = i7 & 65536;
        if (i32 == 0) {
        }
        i33 = i7 & 131072;
        if (i33 == 0) {
        }
        i34 = i7 & 262144;
        if (i34 == 0) {
        }
        if ((i5 & 805306368) == 0) {
        }
        if ((i6 & 6) != 0) {
        }
        if (!composerStartRestartGroup.shouldExecute(((i21 & 306783379) != 306783378 && (306783379 & i29) == 306783378 && (i35 & 3) == 2) ? false : true, i21 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSizeText_VkjzWmM$lambda$0$0(TextLayoutResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:332:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0133  */
    /* JADX INFO: renamed from: AutoSizeText-VkjzWmM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m12529AutoSizeTextVkjzWmM(final AnnotatedString text, Modifier modifier, long j, List<TextUnit> list, SuggestedFontSizesStatus suggestedFontSizesStatus, long j2, long j3, long j4, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j5, TextDecoration textDecoration, Alignment alignment, int i, boolean z, int i2, int i3, Map<String, InlineTextContent> map, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, float f, Composer composer, final int i4, final int i5, final int i6, final int i7) {
        int i8;
        Modifier modifier2;
        int i9;
        long jM8184getUnspecified0d7_KjU;
        int i10;
        List<TextUnit> list2;
        int i11;
        int i12;
        long j6;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        Composer composer2;
        final long j7;
        final FontFamily fontFamily2;
        final long j8;
        final TextDecoration textDecoration2;
        final Alignment alignment2;
        final int i38;
        final boolean z2;
        final int i39;
        final int i40;
        Map<String, InlineTextContent> map2;
        Function1<? super TextLayoutResult, Unit> function12;
        final TextStyle textStyle2;
        final float f2;
        final long j9;
        final List<TextUnit> list3;
        final long j10;
        final SuggestedFontSizesStatus suggestedFontSizesStatus2;
        final long j11;
        final FontStyle fontStyle2;
        final FontWeight fontWeight2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        FontWeight fontWeight3;
        final int iM10952getClipgIe3tQ8;
        Modifier modifier3;
        Function1<? super TextLayoutResult, Unit> function13;
        Function1<? super TextLayoutResult, Unit> function14;
        List<TextUnit> list4;
        TextStyle textStyle3;
        float fM11211getValueimpl;
        final long j12;
        FontStyle fontStyle3;
        Alignment alignment3;
        final long j13;
        final List<TextUnit> list5;
        final SuggestedFontSizesStatus suggestedFontSizesStatus3;
        final FontFamily fontFamily3;
        final Map<String, InlineTextContent> map3;
        final int i41;
        TextStyle textStyle4;
        Modifier modifier4;
        final Function1<? super TextLayoutResult, Unit> function15;
        final TextDecoration textDecoration3;
        final boolean z3;
        int i42;
        final long j14;
        FontStyle fontStyle4;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(239456742);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AutoSizeText)N(text,modifier,color:c#ui.graphics.Color,suggestedFontSizes,suggestedFontSizesStatus,stepGranularityTextSize:c#ui.unit.TextUnit,minTextSize:c#ui.unit.TextUnit,maxTextSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,alignment,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent,onTextLayout,style,lineSpacingRatio)178@8939L7,179@9035L4591,179@8976L4650:AutoSizeText.kt#jo4mkz");
        if ((i4 & 6) == 0) {
            i8 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i4;
        } else {
            i8 = i4;
        }
        int i43 = i7 & 2;
        if (i43 != 0) {
            i8 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i8 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i9 = i7 & 4;
            if (i9 == 0) {
                i8 |= RendererCapabilities.DECODER_SUPPORT_MASK;
                jM8184getUnspecified0d7_KjU = j;
            } else {
                jM8184getUnspecified0d7_KjU = j;
                if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    i8 |= composerStartRestartGroup.changed(jM8184getUnspecified0d7_KjU) ? 256 : 128;
                }
            }
            i10 = i7 & 8;
            if (i10 == 0) {
                i8 |= 3072;
            } else {
                if ((i4 & 3072) == 0) {
                    list2 = list;
                    i8 |= composerStartRestartGroup.changedInstance(list2) ? 2048 : 1024;
                }
                i11 = i7 & 16;
                if (i11 != 0) {
                    i8 |= 24576;
                } else if ((i4 & 24576) == 0) {
                    i8 |= composerStartRestartGroup.changed(suggestedFontSizesStatus == null ? -1 : suggestedFontSizesStatus.ordinal()) ? 16384 : 8192;
                }
                i12 = i7 & 32;
                if (i12 != 0) {
                    i8 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                    j6 = j2;
                } else {
                    j6 = j2;
                    if ((i4 & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                        i8 |= composerStartRestartGroup.changed(j6) ? 131072 : 65536;
                    }
                }
                i13 = i7 & 64;
                if (i13 != 0) {
                    i8 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    i8 |= composerStartRestartGroup.changed(j3) ? 1048576 : 524288;
                }
                i14 = i7 & 128;
                if (i14 != 0) {
                    i8 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    i8 |= composerStartRestartGroup.changed(j4) ? 8388608 : 4194304;
                }
                i15 = i7 & 256;
                if (i15 != 0) {
                    i8 |= 100663296;
                } else {
                    if ((i4 & 100663296) == 0) {
                        i16 = 100663296;
                        i8 |= composerStartRestartGroup.changed(fontStyle) ? 67108864 : 33554432;
                    }
                    i17 = i7 & 512;
                    if (i17 == 0) {
                        i8 |= 805306368;
                    } else {
                        if ((i4 & 805306368) == 0) {
                            i18 = i17;
                            i8 |= composerStartRestartGroup.changed(fontWeight) ? 536870912 : 268435456;
                        }
                        i19 = i7 & 1024;
                        if (i19 != 0) {
                            i21 = i5 | 6;
                            i20 = i19;
                        } else if ((i5 & 6) == 0) {
                            i20 = i19;
                            i21 = i5 | (composerStartRestartGroup.changed(fontFamily) ? 4 : 2);
                        } else {
                            i20 = i19;
                            i21 = i5;
                        }
                        i22 = i7 & 2048;
                        if (i22 != 0) {
                            i21 |= 48;
                            i23 = i22;
                        } else if ((i5 & 48) == 0) {
                            i23 = i22;
                            i21 |= composerStartRestartGroup.changed(j5) ? 32 : 16;
                        } else {
                            i23 = i22;
                        }
                        int i44 = i21;
                        i24 = i7 & 4096;
                        if (i24 != 0) {
                            i25 = i44 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            i25 = i44 | (composerStartRestartGroup.changed(textDecoration) ? 256 : 128);
                        } else {
                            i25 = i44;
                        }
                        i26 = i7 & 8192;
                        if (i26 != 0) {
                            i27 = i25 | 3072;
                        } else {
                            int i45 = i25;
                            if ((i5 & 3072) == 0) {
                                i27 = i45 | (composerStartRestartGroup.changed(alignment) ? 2048 : 1024);
                            } else {
                                i27 = i45;
                            }
                        }
                        i28 = i7 & 16384;
                        if (i28 == 0) {
                            i29 = i27;
                            if ((i5 & 24576) == 0) {
                                i29 |= composerStartRestartGroup.changed(i) ? 16384 : 8192;
                            }
                            i30 = i7 & 32768;
                            if (i30 == 0) {
                                i29 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                            } else if ((i5 & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                                i29 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
                            }
                            i31 = i7 & 65536;
                            if (i31 == 0) {
                                i29 |= 1572864;
                            } else if ((i5 & 1572864) == 0) {
                                i29 |= composerStartRestartGroup.changed(i2) ? 1048576 : 524288;
                            }
                            i32 = i7 & 131072;
                            if (i32 == 0) {
                                i29 |= 12582912;
                            } else if ((i5 & 12582912) == 0) {
                                i29 |= composerStartRestartGroup.changed(i3) ? 8388608 : 4194304;
                            }
                            i33 = i7 & 262144;
                            if (i33 == 0) {
                                i29 |= i16;
                            } else if ((i5 & i16) == 0) {
                                i29 |= composerStartRestartGroup.changedInstance(map) ? 67108864 : 33554432;
                            }
                            i34 = i7 & 524288;
                            if (i34 == 0) {
                                i29 |= 805306368;
                            } else if ((i5 & 805306368) == 0) {
                                i29 |= composerStartRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                            }
                            i35 = i29;
                            if ((i6 & 6) != 0) {
                                if ((i7 & 1048576) == 0) {
                                    i36 = i28;
                                    int i46 = composerStartRestartGroup.changed(textStyle) ? 4 : 2;
                                    i37 = i6 | i46;
                                } else {
                                    i36 = i28;
                                }
                                i37 = i6 | i46;
                            } else {
                                i36 = i28;
                                i37 = i6;
                            }
                            if ((i6 & 48) == 0) {
                                i37 |= ((i7 & 2097152) == 0 && composerStartRestartGroup.changed(f)) ? 32 : 16;
                            }
                            if (!composerStartRestartGroup.shouldExecute(((i8 & 306783379) != 306783378 && (306783379 & i35) == 306783378 && (i37 & 19) == 18) ? false : true, i8 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "173@8724L2,174@8766L7");
                                if ((i4 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    suggestedFontSizesStatus3 = suggestedFontSizesStatus;
                                    j14 = j3;
                                    j7 = j4;
                                    fontStyle3 = fontStyle;
                                    fontWeight3 = fontWeight;
                                    fontFamily3 = fontFamily;
                                    alignment3 = alignment;
                                    iM10952getClipgIe3tQ8 = i;
                                    z3 = z;
                                    i42 = i3;
                                    map3 = map;
                                    function15 = function1;
                                    fM11211getValueimpl = f;
                                    list5 = list2;
                                    modifier4 = modifier2;
                                    j12 = j6;
                                    j13 = j5;
                                    textDecoration3 = textDecoration;
                                    i41 = i2;
                                    textStyle4 = textStyle;
                                } else {
                                    Modifier.Companion companion = i43 != 0 ? Modifier.INSTANCE : modifier2;
                                    if (i9 != 0) {
                                        jM8184getUnspecified0d7_KjU = Color.INSTANCE.m8184getUnspecified0d7_KjU();
                                    }
                                    List<TextUnit> listEmptyList = i10 != 0 ? CollectionsKt.emptyList() : list2;
                                    SuggestedFontSizesStatus suggestedFontSizesStatus4 = i11 != 0 ? SuggestedFontSizesStatus.UNKNOWN : suggestedFontSizesStatus;
                                    long jM11222getUnspecifiedXSAIIZE = i12 != 0 ? TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE() : j6;
                                    long jM11222getUnspecifiedXSAIIZE2 = i13 != 0 ? TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE() : j3;
                                    long jM11222getUnspecifiedXSAIIZE3 = i14 != 0 ? TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE() : j4;
                                    FontStyle fontStyle5 = i15 != 0 ? null : fontStyle;
                                    fontWeight3 = i18 != 0 ? null : fontWeight;
                                    FontFamily fontFamily4 = i20 != 0 ? null : fontFamily;
                                    long jM11222getUnspecifiedXSAIIZE4 = i23 != 0 ? TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE() : j5;
                                    TextDecoration textDecoration4 = i24 == 0 ? textDecoration : null;
                                    Alignment topStart = i26 != 0 ? Alignment.INSTANCE.getTopStart() : alignment;
                                    iM10952getClipgIe3tQ8 = i36 != 0 ? TextOverflow.INSTANCE.m10952getClipgIe3tQ8() : i;
                                    boolean z4 = i30 != 0 ? true : z;
                                    int i47 = i31 != 0 ? Integer.MAX_VALUE : i2;
                                    int i48 = i32 != 0 ? 1 : i3;
                                    Map<String, InlineTextContent> mapEmptyMap = i33 != 0 ? MapsKt.emptyMap() : map;
                                    if (i34 != 0) {
                                        modifier3 = companion;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1810275544, "CC(remember):AutoSizeText.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = new Function1() { // from class: com.myscript.android.utils.ui.compose.autosizetext.AutoSizeTextKt$$ExternalSyntheticLambda6
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return AutoSizeTextKt.AutoSizeText_VkjzWmM$lambda$0$0((TextLayoutResult) obj);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        function13 = (Function1) objRememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    } else {
                                        modifier3 = companion;
                                        function13 = function1;
                                    }
                                    if ((i7 & 1048576) != 0) {
                                        ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                        function14 = function13;
                                        list4 = listEmptyList;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        textStyle3 = (TextStyle) objConsume;
                                    } else {
                                        function14 = function13;
                                        list4 = listEmptyList;
                                        textStyle3 = textStyle;
                                    }
                                    fM11211getValueimpl = (i7 & 2097152) != 0 ? TextUnit.m11211getValueimpl(textStyle3.m10492getLineHeightXSAIIZE()) / TextUnit.m11211getValueimpl(textStyle3.m10484getFontSizeXSAIIZE()) : f;
                                    j12 = jM11222getUnspecifiedXSAIIZE;
                                    fontStyle3 = fontStyle5;
                                    alignment3 = topStart;
                                    j13 = jM11222getUnspecifiedXSAIIZE4;
                                    list5 = list4;
                                    suggestedFontSizesStatus3 = suggestedFontSizesStatus4;
                                    fontFamily3 = fontFamily4;
                                    map3 = mapEmptyMap;
                                    j7 = jM11222getUnspecifiedXSAIIZE3;
                                    i41 = i47;
                                    textStyle4 = textStyle3;
                                    modifier4 = modifier3;
                                    boolean z5 = z4;
                                    function15 = function14;
                                    long j15 = jM11222getUnspecifiedXSAIIZE2;
                                    textDecoration3 = textDecoration4;
                                    z3 = z5;
                                    i42 = i48;
                                    j14 = j15;
                                }
                                composerStartRestartGroup.endDefaults();
                                final Modifier modifier5 = modifier4;
                                if (ComposerKt.isTraceInProgress()) {
                                    fontStyle4 = fontStyle3;
                                    ComposerKt.traceEventStart(239456742, i8, i35, "com.myscript.android.utils.ui.compose.autosizetext.AutoSizeText (AutoSizeText.kt:176)");
                                } else {
                                    fontStyle4 = fontStyle3;
                                }
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ProvidedValue<Density> providedValueProvides = CompositionLocalsKt.getLocalDensity().provides(DensityKt.Density(((Density) objConsume2).getDensity(), 1.0f));
                                final Alignment alignment4 = alignment3;
                                final long j16 = jM8184getUnspecified0d7_KjU;
                                final TextStyle textStyle5 = textStyle4;
                                final FontWeight fontWeight4 = fontWeight3;
                                final FontStyle fontStyle6 = fontStyle4;
                                final int i49 = i42;
                                final float f3 = fM11211getValueimpl;
                                Function2 function2 = new Function2() { // from class: com.myscript.android.utils.ui.compose.autosizetext.AutoSizeTextKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AutoSizeTextKt.AutoSizeText_VkjzWmM$lambda$1(modifier5, alignment4, j16, textStyle5, fontStyle6, fontWeight4, fontFamily3, j13, textDecoration3, f3, text, i41, z3, list5, suggestedFontSizesStatus3, iM10952getClipgIe3tQ8, i49, map3, function15, j14, j7, j12, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                composer2 = composerStartRestartGroup;
                                CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(685315366, true, function2, composer2, 54), composer2, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                j9 = j16;
                                fontStyle2 = fontStyle6;
                                suggestedFontSizesStatus2 = suggestedFontSizesStatus3;
                                map2 = map3;
                                function12 = function15;
                                z2 = z3;
                                i38 = iM10952getClipgIe3tQ8;
                                fontFamily2 = fontFamily3;
                                textDecoration2 = textDecoration3;
                                modifier2 = modifier5;
                                alignment2 = alignment4;
                                long j17 = j12;
                                textStyle2 = textStyle5;
                                f2 = f3;
                                list3 = list5;
                                j8 = j13;
                                j11 = j14;
                                i39 = i41;
                                i40 = i49;
                                fontWeight2 = fontWeight4;
                                j10 = j17;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                j7 = j4;
                                fontFamily2 = fontFamily;
                                j8 = j5;
                                textDecoration2 = textDecoration;
                                alignment2 = alignment;
                                i38 = i;
                                z2 = z;
                                i39 = i2;
                                i40 = i3;
                                map2 = map;
                                function12 = function1;
                                textStyle2 = textStyle;
                                f2 = f;
                                j9 = jM8184getUnspecified0d7_KjU;
                                list3 = list2;
                                j10 = j6;
                                suggestedFontSizesStatus2 = suggestedFontSizesStatus;
                                j11 = j3;
                                fontStyle2 = fontStyle;
                                fontWeight2 = fontWeight;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                final long j18 = j7;
                                final Modifier modifier6 = modifier2;
                                final Map<String, InlineTextContent> map4 = map2;
                                final Function1<? super TextLayoutResult, Unit> function16 = function12;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.android.utils.ui.compose.autosizetext.AutoSizeTextKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AutoSizeTextKt.AutoSizeText_VkjzWmM$lambda$2(text, modifier6, j9, list3, suggestedFontSizesStatus2, j10, j11, j18, fontStyle2, fontWeight2, fontFamily2, j8, textDecoration2, alignment2, i38, z2, i39, i40, map4, function16, textStyle2, f2, i4, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i29 = i27 | 24576;
                        i30 = i7 & 32768;
                        if (i30 == 0) {
                        }
                        i31 = i7 & 65536;
                        if (i31 == 0) {
                        }
                        i32 = i7 & 131072;
                        if (i32 == 0) {
                        }
                        i33 = i7 & 262144;
                        if (i33 == 0) {
                        }
                        i34 = i7 & 524288;
                        if (i34 == 0) {
                        }
                        i35 = i29;
                        if ((i6 & 6) != 0) {
                        }
                        if ((i6 & 48) == 0) {
                        }
                        if (!composerStartRestartGroup.shouldExecute(((i8 & 306783379) != 306783378 && (306783379 & i35) == 306783378 && (i37 & 19) == 18) ? false : true, i8 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i18 = i17;
                    i19 = i7 & 1024;
                    if (i19 != 0) {
                    }
                    i22 = i7 & 2048;
                    if (i22 != 0) {
                    }
                    int i442 = i21;
                    i24 = i7 & 4096;
                    if (i24 != 0) {
                    }
                    i26 = i7 & 8192;
                    if (i26 != 0) {
                    }
                    i28 = i7 & 16384;
                    if (i28 == 0) {
                    }
                    i30 = i7 & 32768;
                    if (i30 == 0) {
                    }
                    i31 = i7 & 65536;
                    if (i31 == 0) {
                    }
                    i32 = i7 & 131072;
                    if (i32 == 0) {
                    }
                    i33 = i7 & 262144;
                    if (i33 == 0) {
                    }
                    i34 = i7 & 524288;
                    if (i34 == 0) {
                    }
                    i35 = i29;
                    if ((i6 & 6) != 0) {
                    }
                    if ((i6 & 48) == 0) {
                    }
                    if (!composerStartRestartGroup.shouldExecute(((i8 & 306783379) != 306783378 && (306783379 & i35) == 306783378 && (i37 & 19) == 18) ? false : true, i8 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i16 = 100663296;
                i17 = i7 & 512;
                if (i17 == 0) {
                }
                i18 = i17;
                i19 = i7 & 1024;
                if (i19 != 0) {
                }
                i22 = i7 & 2048;
                if (i22 != 0) {
                }
                int i4422 = i21;
                i24 = i7 & 4096;
                if (i24 != 0) {
                }
                i26 = i7 & 8192;
                if (i26 != 0) {
                }
                i28 = i7 & 16384;
                if (i28 == 0) {
                }
                i30 = i7 & 32768;
                if (i30 == 0) {
                }
                i31 = i7 & 65536;
                if (i31 == 0) {
                }
                i32 = i7 & 131072;
                if (i32 == 0) {
                }
                i33 = i7 & 262144;
                if (i33 == 0) {
                }
                i34 = i7 & 524288;
                if (i34 == 0) {
                }
                i35 = i29;
                if ((i6 & 6) != 0) {
                }
                if ((i6 & 48) == 0) {
                }
                if (!composerStartRestartGroup.shouldExecute(((i8 & 306783379) != 306783378 && (306783379 & i35) == 306783378 && (i37 & 19) == 18) ? false : true, i8 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            list2 = list;
            i11 = i7 & 16;
            if (i11 != 0) {
            }
            i12 = i7 & 32;
            if (i12 != 0) {
            }
            i13 = i7 & 64;
            if (i13 != 0) {
            }
            i14 = i7 & 128;
            if (i14 != 0) {
            }
            i15 = i7 & 256;
            if (i15 != 0) {
            }
            i16 = 100663296;
            i17 = i7 & 512;
            if (i17 == 0) {
            }
            i18 = i17;
            i19 = i7 & 1024;
            if (i19 != 0) {
            }
            i22 = i7 & 2048;
            if (i22 != 0) {
            }
            int i44222 = i21;
            i24 = i7 & 4096;
            if (i24 != 0) {
            }
            i26 = i7 & 8192;
            if (i26 != 0) {
            }
            i28 = i7 & 16384;
            if (i28 == 0) {
            }
            i30 = i7 & 32768;
            if (i30 == 0) {
            }
            i31 = i7 & 65536;
            if (i31 == 0) {
            }
            i32 = i7 & 131072;
            if (i32 == 0) {
            }
            i33 = i7 & 262144;
            if (i33 == 0) {
            }
            i34 = i7 & 524288;
            if (i34 == 0) {
            }
            i35 = i29;
            if ((i6 & 6) != 0) {
            }
            if ((i6 & 48) == 0) {
            }
            if (!composerStartRestartGroup.shouldExecute(((i8 & 306783379) != 306783378 && (306783379 & i35) == 306783378 && (i37 & 19) == 18) ? false : true, i8 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i9 = i7 & 4;
        if (i9 == 0) {
        }
        i10 = i7 & 8;
        if (i10 == 0) {
        }
        list2 = list;
        i11 = i7 & 16;
        if (i11 != 0) {
        }
        i12 = i7 & 32;
        if (i12 != 0) {
        }
        i13 = i7 & 64;
        if (i13 != 0) {
        }
        i14 = i7 & 128;
        if (i14 != 0) {
        }
        i15 = i7 & 256;
        if (i15 != 0) {
        }
        i16 = 100663296;
        i17 = i7 & 512;
        if (i17 == 0) {
        }
        i18 = i17;
        i19 = i7 & 1024;
        if (i19 != 0) {
        }
        i22 = i7 & 2048;
        if (i22 != 0) {
        }
        int i442222 = i21;
        i24 = i7 & 4096;
        if (i24 != 0) {
        }
        i26 = i7 & 8192;
        if (i26 != 0) {
        }
        i28 = i7 & 16384;
        if (i28 == 0) {
        }
        i30 = i7 & 32768;
        if (i30 == 0) {
        }
        i31 = i7 & 65536;
        if (i31 == 0) {
        }
        i32 = i7 & 131072;
        if (i32 == 0) {
        }
        i33 = i7 & 262144;
        if (i33 == 0) {
        }
        i34 = i7 & 524288;
        if (i34 == 0) {
        }
        i35 = i29;
        if ((i6 & 6) != 0) {
        }
        if ((i6 & 48) == 0) {
        }
        if (!composerStartRestartGroup.shouldExecute(((i8 & 306783379) != 306783378 && (306783379 & i35) == 306783378 && (i37 & 19) == 18) ? false : true, i8 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSizeText_VkjzWmM$lambda$1(Modifier modifier, final Alignment alignment, final long j, final TextStyle textStyle, final FontStyle fontStyle, final FontWeight fontWeight, final FontFamily fontFamily, final long j2, final TextDecoration textDecoration, final float f, final AnnotatedString annotatedString, final int i, final boolean z, final List list, final SuggestedFontSizesStatus suggestedFontSizesStatus, final int i2, final int i3, final Map map, final Function1 function1, final long j3, final long j4, final long j5, Composer composer, int i4) {
        ComposerKt.sourceInformation(composer, "C183@9150L4470,180@9045L4575:AutoSizeText.kt#jo4mkz");
        if (!composer.shouldExecute((i4 & 3) != 2, i4 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(685315366, i4, -1, "com.myscript.android.utils.ui.compose.autosizetext.AutoSizeText.<anonymous> (AutoSizeText.kt:180)");
            }
            BoxWithConstraintsKt.BoxWithConstraints(modifier, alignment, false, ComposableLambdaKt.rememberComposableLambda(-2062899952, true, new Function3() { // from class: com.myscript.android.utils.ui.compose.autosizetext.AutoSizeTextKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AutoSizeTextKt.AutoSizeText_VkjzWmM$lambda$1$0(j, textStyle, fontStyle, fontWeight, fontFamily, j2, textDecoration, alignment, f, annotatedString, i, z, list, suggestedFontSizesStatus, i2, i3, map, function1, j3, j4, j5, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3072, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit AutoSizeText_VkjzWmM$lambda$1$0(long j, TextStyle textStyle, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j2, TextDecoration textDecoration, Alignment alignment, float f, final AnnotatedString annotatedString, final int i, final boolean z, List list, SuggestedFontSizesStatus suggestedFontSizesStatus, int i2, int i3, Map map, Function1 function1, long j3, long j4, long j5, final BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i4) {
        int i5;
        float f2;
        final Density density;
        TextUnit textUnitM11201boximpl;
        long packedValue;
        List validSuggestedFontSizes = list;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C184@9203L7,201@10235L7,202@10282L7,203@10351L7,204@10390L22,206@10574L567,222@11177L334,266@13131L479:AutoSizeText.kt#jo4mkz");
        if ((i4 & 6) == 0) {
            i5 = i4 | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i5 = i4;
        }
        if (composer.shouldExecute((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2062899952, i5, -1, "com.myscript.android.utils.ui.compose.autosizetext.AutoSizeText.<anonymous>.<anonymous> (AutoSizeText.kt:184)");
            }
            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localTextStyle);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextStyle textStyle2 = (TextStyle) objConsume;
            Color colorM8138boximpl = Color.m8138boximpl(j);
            if (colorM8138boximpl.m8158unboximpl() == 16) {
                colorM8138boximpl = null;
            }
            long jM8158unboximpl = colorM8138boximpl != null ? colorM8138boximpl.m8158unboximpl() : textStyle.m10483getColor0d7_KjU();
            FontStyle fontStyleM10485getFontStyle4Lr2A7w = fontStyle == null ? textStyle.m10485getFontStyle4Lr2A7w() : fontStyle;
            FontWeight fontWeight2 = fontWeight == null ? textStyle.getFontWeight() : fontWeight;
            FontFamily fontFamily2 = fontFamily == null ? textStyle.getFontFamily() : fontFamily;
            TextUnit textUnitM11201boximpl2 = TextUnit.m11201boximpl(j2);
            if (TextUnit.m11209getRawTypeimpl(textUnitM11201boximpl2.getPackedValue()) == 0) {
                textUnitM11201boximpl2 = null;
            }
            final TextStyle textStylePlus = textStyle2.plus(TextStyle.m10466copyp1EtxEg$default(textStyle, jM8158unboximpl, 0L, fontWeight2, fontStyleM10485getFontStyle4Lr2A7w, null, fontFamily2, null, textUnitM11201boximpl2 != null ? textUnitM11201boximpl2.getPackedValue() : textStyle.m10489getLetterSpacingXSAIIZE(), null, null, null, 0L, textDecoration == null ? textStyle.getTextDecoration() : textDecoration, null, null, TextAlign.m10891equalsimpl0(textStyle.m10494getTextAligne0LSkKk(), TextAlign.INSTANCE.m10897getJustifye0LSkKk()) ? TextAlign.INSTANCE.m10897getJustifye0LSkKk() : (Intrinsics.areEqual(alignment, Alignment.INSTANCE.getTopStart()) || Intrinsics.areEqual(alignment, Alignment.INSTANCE.getCenterStart()) || Intrinsics.areEqual(alignment, Alignment.INSTANCE.getBottomStart())) ? TextAlign.INSTANCE.m10900getStarte0LSkKk() : (Intrinsics.areEqual(alignment, Alignment.INSTANCE.getTopCenter()) || Intrinsics.areEqual(alignment, Alignment.INSTANCE.getCenter()) || Intrinsics.areEqual(alignment, Alignment.INSTANCE.getBottomCenter())) ? TextAlign.INSTANCE.m10895getCentere0LSkKk() : (Intrinsics.areEqual(alignment, Alignment.INSTANCE.getTopEnd()) || Intrinsics.areEqual(alignment, Alignment.INSTANCE.getCenterEnd()) || Intrinsics.areEqual(alignment, Alignment.INSTANCE.getBottomEnd())) ? TextAlign.INSTANCE.m10896getEnde0LSkKk() : TextAlign.INSTANCE.m10901getUnspecifiede0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16740178, null));
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            final LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            final Density density2 = (Density) objConsume3;
            ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composer.consume(localFontFamilyResolver);
            ComposerKt.sourceInformationMarkerEnd(composer);
            final FontFamily.Resolver resolver = (FontFamily.Resolver) objConsume4;
            final TextMeasurer textMeasurerRememberTextMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, composer, 0, 1);
            Float fValueOf = Float.valueOf(f);
            float fFloatValue = fValueOf.floatValue();
            if (Math.abs(fFloatValue) > Float.MAX_VALUE || fFloatValue < 1.0f) {
                fValueOf = null;
            }
            final float fFloatValue2 = fValueOf != null ? fValueOf.floatValue() : 1.0f;
            ComposerKt.sourceInformationMarkerStart(composer, 1828083015, "CC(remember):AutoSizeText.kt#9igjgp");
            boolean zChanged = composer.changed(annotatedString) | ((i5 & 14) == 4) | composer.changed(textStylePlus) | composer.changed(fFloatValue2) | composer.changed(i) | composer.changed(layoutDirection.ordinal()) | composer.changed(z) | composer.changed(density2) | composer.changedInstance(resolver) | composer.changed(textMeasurerRememberTextMeasurer);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.android.utils.ui.compose.autosizetext.AutoSizeTextKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(AutoSizeTextKt.AutoSizeText_VkjzWmM$lambda$1$0$3$0(BoxWithConstraints, annotatedString, textStylePlus, fFloatValue2, i, layoutDirection, z, density2, resolver, textMeasurerRememberTextMeasurer, (TextUnit) obj));
                    }
                };
                f2 = fFloatValue2;
                density = density2;
                composer.updateRememberedValue(objRememberedValue);
            } else {
                density = density2;
                f2 = fFloatValue2;
            }
            Function1 function12 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1828102078, "CC(remember):AutoSizeText.kt#9igjgp");
            boolean zChanged2 = composer.changed(validSuggestedFontSizes) | composer.changed(suggestedFontSizesStatus.ordinal());
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                if (suggestedFontSizesStatus != SuggestedFontSizesStatus.VALID) {
                    validSuggestedFontSizes = SuggestedFontSizesStatus.INSTANCE.getValidSuggestedFontSizes(validSuggestedFontSizes);
                }
                composer.updateRememberedValue(validSuggestedFontSizes);
                objRememberedValue2 = validSuggestedFontSizes;
            }
            List list2 = (List) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (list2 == null) {
                composer.startReplaceGroup(836920031);
                composer.endReplaceGroup();
                textUnitM11201boximpl = null;
            } else {
                composer.startReplaceGroup(836920032);
                ComposerKt.sourceInformation(composer, "*231@11535L206");
                ComposerKt.sourceInformationMarkerStart(composer, 1512500326, "CC(remember):AutoSizeText.kt#9igjgp");
                boolean zChanged3 = composer.changed(list2) | composer.changed(function12);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = TextUnit.m11201boximpl(((TextUnit) findElectedValue(list2, function12)).getPackedValue());
                    composer.updateRememberedValue(objRememberedValue3);
                }
                long packedValue2 = ((TextUnit) objRememberedValue3).getPackedValue();
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
                textUnitM11201boximpl = TextUnit.m11201boximpl(packedValue2);
            }
            if (textUnitM11201boximpl == null) {
                composer.startReplaceGroup(837180928);
                ComposerKt.sourceInformation(composer, "*238@11817L327,245@12161L370");
                IntProgression intProgressionM12530rememberCandidateFontSizesIntProgressDCWUXg = m12530rememberCandidateFontSizesIntProgressDCWUXg(density, DpKt.m11039DpSizeYgX7TsA(BoxWithConstraints.mo2557getMaxWidthD9Ej5fM(), BoxWithConstraints.mo2556getMaxHeightD9Ej5fM()), j3, j4, j5, composer, 0, 0);
                ComposerKt.sourceInformationMarkerStart(composer, 711982773, "CC(remember):AutoSizeText.kt#9igjgp");
                boolean zChanged4 = composer.changed(intProgressionM12530rememberCandidateFontSizesIntProgressDCWUXg) | composer.changed(function12);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = TextUnit.m11201boximpl(((TextUnit) findElectedValue(intProgressionM12530rememberCandidateFontSizesIntProgressDCWUXg, new Function1() { // from class: com.myscript.android.utils.ui.compose.autosizetext.AutoSizeTextKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AutoSizeTextKt.AutoSizeText_VkjzWmM$lambda$1$0$6$0$0(density, ((Integer) obj).intValue());
                        }
                    }, function12)).getPackedValue());
                    composer.updateRememberedValue(objRememberedValue4);
                }
                packedValue = ((TextUnit) objRememberedValue4).getPackedValue();
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1828103112);
                composer.endReplaceGroup();
                packedValue = textUnitM11201boximpl.getPackedValue();
            }
            if (TextUnit.m11208equalsimpl0(packedValue, TextUnitKt.getSp(0))) {
                Log.w(TAG, "The text cannot be displayed. Please consider the following options:\n  1. Providing 'suggestedFontSizes' with smaller values that can be utilized.\n  2. Decreasing the 'stepGranularityTextSize' value.\n  3. Adjusting the 'minTextSize' parameter to a suitable value and ensuring the overflow parameter is set to \"TextOverflow.Ellipsis\".");
            }
            TextUnitKt.m11224checkArithmeticR2X_6o(packedValue);
            TextKt.m5871TextZ58ophY(annotatedString, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, i2, z, i, i3, map, function1, TextStyle.m10466copyp1EtxEg$default(textStylePlus, 0L, packedValue, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.pack(TextUnit.m11209getRawTypeimpl(packedValue), TextUnit.m11211getValueimpl(packedValue) * f2), null, null, null, 0, 0, null, 16646141, null), composer, 0, 0, 4094);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AutoSizeText_VkjzWmM$lambda$1$0$3$0(BoxWithConstraintsScope boxWithConstraintsScope, AnnotatedString annotatedString, TextStyle textStyle, float f, int i, LayoutDirection layoutDirection, boolean z, Density density, FontFamily.Resolver resolver, TextMeasurer textMeasurer, TextUnit textUnit) {
        long packedValue = textUnit.getPackedValue();
        long packedValue2 = textUnit.getPackedValue();
        TextUnitKt.m11224checkArithmeticR2X_6o(packedValue2);
        return shouldShrink(boxWithConstraintsScope, annotatedString, TextStyle.m10466copyp1EtxEg$default(textStyle, 0L, packedValue, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.pack(TextUnit.m11209getRawTypeimpl(packedValue2), TextUnit.m11211getValueimpl(packedValue2) * f), null, null, null, 0, 0, null, 16646141, null), i, layoutDirection, z, density, resolver, textMeasurer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextUnit AutoSizeText_VkjzWmM$lambda$1$0$6$0$0(Density density, int i) {
        return TextUnit.m11201boximpl(DensityKt.intPxToSp(density, i));
    }

    private static final boolean shouldShrink(BoxWithConstraintsScope boxWithConstraintsScope, AnnotatedString annotatedString, TextStyle textStyle, int i, LayoutDirection layoutDirection, boolean z, Density density, FontFamily.Resolver resolver, TextMeasurer textMeasurer) {
        return TextMeasurer.m10427measurexDpz5zY$default(textMeasurer, annotatedString, textStyle, TextOverflow.INSTANCE.m10952getClipgIe3tQ8(), z, i, null, boxWithConstraintsScope.mo2555getConstraintsmsEJaDk(), layoutDirection, density, resolver, false, 1056, null).getHasVisualOverflow();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x008a  */
    /* JADX INFO: renamed from: rememberCandidateFontSizesIntProgress-DC-WUXg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final IntProgression m12530rememberCandidateFontSizesIntProgressDCWUXg(Density density, long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        boolean z;
        ComposerKt.sourceInformationMarkerStart(composer, 455583339, "C(rememberCandidateFontSizesIntProgress)N(density,containerDpSize:c#ui.unit.DpSize,minTextSize:c#ui.unit.TextUnit,maxTextSize:c#ui.unit.TextUnit,stepGranularityTextSize:c#ui.unit.TextUnit)313@14539L386,324@14941L216,332@15174L310,347@15497L80:AutoSizeText.kt#jo4mkz");
        long jM11222getUnspecifiedXSAIIZE = (i2 & 4) != 0 ? TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE() : j2;
        long jM11222getUnspecifiedXSAIIZE2 = (i2 & 8) != 0 ? TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE() : j3;
        long jM11222getUnspecifiedXSAIIZE3 = (i2 & 16) != 0 ? TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(455583339, i, -1, "com.myscript.android.utils.ui.compose.autosizetext.rememberCandidateFontSizesIntProgress (AutoSizeText.kt:312)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -271065747, "CC(remember):AutoSizeText.kt#9igjgp");
        int i3 = (i & 14) ^ 6;
        boolean z2 = ((((i & 7168) ^ 3072) > 2048 && composer.changed(jM11222getUnspecifiedXSAIIZE2)) || (i & 3072) == 2048) | ((i3 > 4 && composer.changed(density)) || (i & 6) == 4);
        if (((i & 112) ^ 48) <= 32 || !composer.changed(j)) {
            z = (i & 48) == 32;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            long jM12535dpSizeRoundToIntSize6HolHcs = DensityKt.m12535dpSizeRoundToIntSize6HolHcs(density, j);
            int iMin = Math.min((int) (jM12535dpSizeRoundToIntSize6HolHcs >> 32), (int) (jM12535dpSizeRoundToIntSize6HolHcs & 4294967295L));
            TextUnit textUnitM11201boximpl = TextUnit.m11201boximpl(jM11222getUnspecifiedXSAIIZE2);
            if (!TextUnit.m11214isSpimpl(textUnitM11201boximpl.getPackedValue())) {
                textUnitM11201boximpl = null;
            }
            if (textUnitM11201boximpl != null) {
                iMin = RangesKt.coerceIn(DensityKt.m12552spRoundToPxmpE4wyQ(density, textUnitM11201boximpl.getPackedValue()), (ClosedRange<Integer>) new IntRange(0, iMin));
            }
            objRememberedValue = Integer.valueOf(iMin);
            composer.updateRememberedValue(objRememberedValue);
        }
        int iIntValue = ((Number) objRememberedValue).intValue();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -271053053, "CC(remember):AutoSizeText.kt#9igjgp");
        boolean zChanged = ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(jM11222getUnspecifiedXSAIIZE)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((i3 > 4 && composer.changed(density)) || (i & 6) == 4) | composer.changed(iIntValue);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            TextUnit textUnitM11201boximpl2 = TextUnit.m11201boximpl(jM11222getUnspecifiedXSAIIZE);
            if (!TextUnit.m11214isSpimpl(textUnitM11201boximpl2.getPackedValue())) {
                textUnitM11201boximpl2 = null;
            }
            objRememberedValue2 = Integer.valueOf(textUnitM11201boximpl2 != null ? RangesKt.coerceIn(DensityKt.m12555spToIntPxmpE4wyQ(density, textUnitM11201boximpl2.getPackedValue()), (ClosedRange<Integer>) new IntRange(0, iIntValue)) : 0);
            composer.updateRememberedValue(objRememberedValue2);
        }
        int iIntValue2 = ((Number) objRememberedValue2).intValue();
        ComposerKt.sourceInformationMarkerEnd(composer);
        List listListOf = CollectionsKt.listOf(density, Integer.valueOf(iIntValue2), Integer.valueOf(iIntValue), TextUnit.m11201boximpl(jM11222getUnspecifiedXSAIIZE3));
        ComposerKt.sourceInformationMarkerStart(composer, -271045503, "CC(remember):AutoSizeText.kt#9igjgp");
        boolean zChanged2 = composer.changed(listListOf);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            TextUnit textUnitM11201boximpl3 = TextUnit.m11201boximpl(jM11222getUnspecifiedXSAIIZE3);
            TextUnit textUnit = TextUnit.m11214isSpimpl(textUnitM11201boximpl3.getPackedValue()) ? textUnitM11201boximpl3 : null;
            objRememberedValue3 = Integer.valueOf(textUnit != null ? RangesKt.coerceIn(DensityKt.m12555spToIntPxmpE4wyQ(density, textUnit.getPackedValue()), 1, iIntValue - iIntValue2) : 1);
            composer.updateRememberedValue(objRememberedValue3);
        }
        int iIntValue3 = ((Number) objRememberedValue3).intValue();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -271035397, "CC(remember):AutoSizeText.kt#9igjgp");
        boolean zChanged3 = composer.changed(iIntValue2) | composer.changed(iIntValue) | composer.changed(iIntValue3);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = RangesKt.step(new IntRange(iIntValue2, iIntValue), iIntValue3);
            composer.updateRememberedValue(objRememberedValue4);
        }
        IntProgression intProgression = (IntProgression) objRememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return intProgression;
    }

    public static final <T> T findElectedValue(final List<? extends T> list, Function1<? super T, Boolean> shouldMoveBackward) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(shouldMoveBackward, "shouldMoveBackward");
        return (T) findElectedValue(CollectionsKt.getIndices(list), new Function1() { // from class: com.myscript.android.utils.ui.compose.autosizetext.AutoSizeTextKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return list.get(((Integer) obj).intValue());
            }
        }, shouldMoveBackward);
    }

    private static final <T> T findElectedValue(IntProgression intProgression, Function1<? super Integer, ? extends T> function1, Function1<? super T, Boolean> function12) {
        int first = intProgression.getFirst() / intProgression.getStep();
        int last = intProgression.getLast() / intProgression.getStep();
        while (first <= last) {
            int i = ((last - first) / 2) + first;
            if (function12.invoke(function1.invoke(Integer.valueOf(intProgression.getStep() * i))).booleanValue()) {
                last = i - 1;
            } else {
                first = i + 1;
            }
        }
        return function1.invoke(Integer.valueOf(RangesKt.coerceAtLeast(last * intProgression.getStep(), intProgression.getFirst() * intProgression.getStep())));
    }
}

package androidx.compose.material;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;

/* JADX INFO: compiled from: MaterialTextSelectionColors.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a'\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a/\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\"\u000e\u0010\u0018\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m1599d2 = {"rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "colors", "Landroidx/compose/material/Colors;", "(Landroidx/compose/material/Colors;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "calculateSelectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "selectionColor", "textColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "calculateSelectionBackgroundColor-ysEtTa8", "(JJJ)J", "binarySearchForAccessibleSelectionColorAlpha", "", "binarySearchForAccessibleSelectionColorAlpha-ysEtTa8", "(JJJ)F", "calculateContrastRatio", "selectionColorAlpha", "calculateContrastRatio-nb2GgbA", "(JFJJ)F", DownloadService.KEY_FOREGROUND, "background", "calculateContrastRatio--OWjLjI", "(JJ)F", "DefaultSelectionBackgroundAlpha", "MinimumSelectionBackgroundAlpha", "DesiredContrastRatio", "material"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    public static final TextSelectionColors rememberTextSelectionColors(Colors colors, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -721696685, "C(rememberTextSelectionColors)N(colors)45@1907L6,46@1926L418:MaterialTextSelectionColors.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721696685, i, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        }
        long jM4203getPrimary0d7_KjU = colors.m4203getPrimary0d7_KjU();
        long jM4196getBackground0d7_KjU = colors.m4196getBackground0d7_KjU();
        composer.startReplaceGroup(-2060762245);
        ComposerKt.sourceInformation(composer, "*44@1858L7");
        long jM4220contentColorFor4WTKRHQ = ColorsKt.m4220contentColorFor4WTKRHQ(colors, jM4196getBackground0d7_KjU);
        if (jM4220contentColorFor4WTKRHQ == 16) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM4220contentColorFor4WTKRHQ = ((Color) objConsume).m8158unboximpl();
        }
        composer.endReplaceGroup();
        long jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(jM4220contentColorFor4WTKRHQ, ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        ComposerKt.sourceInformationMarkerStart(composer, -2060758699, "CC(remember):MaterialTextSelectionColors.kt#9igjgp");
        boolean zChanged = composer.changed(jM4203getPrimary0d7_KjU) | composer.changed(jM4196getBackground0d7_KjU) | composer.changed(jM8147copywmQWz5c$default);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(colors.m4203getPrimary0d7_KjU(), m4309calculateSelectionBackgroundColorysEtTa8(jM4203getPrimary0d7_KjU, jM8147copywmQWz5c$default, jM4196getBackground0d7_KjU), null);
            composer.updateRememberedValue(textSelectionColors);
            objRememberedValue = textSelectionColors;
        }
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textSelectionColors2;
    }

    /* JADX INFO: renamed from: calculateSelectionBackgroundColor-ysEtTa8, reason: not valid java name */
    public static final long m4309calculateSelectionBackgroundColorysEtTa8(long j, long j2, long j3) {
        float fM4306binarySearchForAccessibleSelectionColorAlphaysEtTa8;
        float fM4308calculateContrastRationb2GgbA = m4308calculateContrastRationb2GgbA(j, 0.4f, j2, j3);
        float fM4308calculateContrastRationb2GgbA2 = m4308calculateContrastRationb2GgbA(j, 0.2f, j2, j3);
        if (fM4308calculateContrastRationb2GgbA >= DesiredContrastRatio) {
            fM4306binarySearchForAccessibleSelectionColorAlphaysEtTa8 = 0.4f;
        } else {
            fM4306binarySearchForAccessibleSelectionColorAlphaysEtTa8 = fM4308calculateContrastRationb2GgbA2 < DesiredContrastRatio ? 0.2f : m4306binarySearchForAccessibleSelectionColorAlphaysEtTa8(j, j2, j3);
        }
        return Color.m8147copywmQWz5c$default(j, fM4306binarySearchForAccessibleSelectionColorAlphaysEtTa8, 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* JADX INFO: renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8, reason: not valid java name */
    private static final float m4306binarySearchForAccessibleSelectionColorAlphaysEtTa8(long j, long j2, long j3) {
        int i = 0;
        float f = 0.2f;
        float f2 = 0.4f;
        float f3 = 0.4f;
        while (i < 7) {
            long j4 = j;
            long j5 = j2;
            long j6 = j3;
            float fM4308calculateContrastRationb2GgbA = (m4308calculateContrastRationb2GgbA(j4, f2, j5, j6) / DesiredContrastRatio) - 1.0f;
            if (0.0f <= fM4308calculateContrastRationb2GgbA && fM4308calculateContrastRationb2GgbA <= 0.01f) {
                return f2;
            }
            if (fM4308calculateContrastRationb2GgbA < 0.0f) {
                f3 = f2;
            } else {
                f = f2;
            }
            f2 = (f3 + f) / 2.0f;
            i++;
            j = j4;
            j2 = j5;
            j3 = j6;
        }
        return f2;
    }

    /* JADX INFO: renamed from: calculateContrastRatio-nb2GgbA, reason: not valid java name */
    private static final float m4308calculateContrastRationb2GgbA(long j, float f, long j2, long j3) {
        long jM8193compositeOverOWjLjI = ColorKt.m8193compositeOverOWjLjI(Color.m8147copywmQWz5c$default(j, f, 0.0f, 0.0f, 0.0f, 14, null), j3);
        return m4307calculateContrastRatioOWjLjI(ColorKt.m8193compositeOverOWjLjI(j2, jM8193compositeOverOWjLjI), jM8193compositeOverOWjLjI);
    }

    /* JADX INFO: renamed from: calculateContrastRatio--OWjLjI, reason: not valid java name */
    public static final float m4307calculateContrastRatioOWjLjI(long j, long j2) {
        float fM8200luminance8_81llA = ColorKt.m8200luminance8_81llA(j) + 0.05f;
        float fM8200luminance8_81llA2 = ColorKt.m8200luminance8_81llA(j2) + 0.05f;
        return Math.max(fM8200luminance8_81llA, fM8200luminance8_81llA2) / Math.min(fM8200luminance8_81llA, fM8200luminance8_81llA2);
    }
}

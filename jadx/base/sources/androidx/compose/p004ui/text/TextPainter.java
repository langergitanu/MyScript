package androidx.compose.p004ui.text;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.geometry.RectKt;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.graphics.drawscope.Fill;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.text.style.TextForegroundStyle;
import androidx.compose.p004ui.text.style.TextOverflow;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextPainter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, m1599d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "<init>", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TextPainter {
    public static final int $stable = 0;
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void paint(Canvas canvas, TextLayoutResult textLayoutResult) {
        Canvas canvas2;
        Throwable th;
        Brush brush;
        Canvas canvas3;
        long jM8174getBlack0d7_KjU;
        float alpha;
        boolean z = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m10943equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m10956getVisiblegIe3tQ8());
        if (z) {
            float size = (int) (textLayoutResult.getSize() >> 32);
            Rect rectM7943Recttz77jQw = RectKt.m7943Recttz77jQw(Offset.INSTANCE.m7919getZeroF1C5BW0(), Size.m7963constructorimpl((((long) Float.floatToRawIntBits((int) (textLayoutResult.getSize() & 4294967295L))) & 4294967295L) | (((long) Float.floatToRawIntBits(size)) << 32)));
            canvas.save();
            canvas2 = null;
            Canvas.m8121clipRectmtrdDE$default(canvas, rectM7943Recttz77jQw, 0, 2, null);
        }
        SpanStyle spanStyle = textLayoutResult.getLayoutInput().getStyle().getSpanStyle();
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.INSTANCE.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.INSTANCE.getNone();
        }
        Shadow shadow2 = shadow;
        Fill drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        try {
            brush = spanStyle.getBrush();
        } catch (Throwable th2) {
            th = th2;
            canvas2 = canvas;
        }
        try {
            if (brush != null) {
                if (spanStyle.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE) {
                    try {
                        alpha = spanStyle.getTextForegroundStyle().getAlpha();
                    } catch (Throwable th3) {
                        th = th3;
                        canvas2 = canvas;
                        if (z) {
                            throw th;
                        }
                        canvas2.restore();
                        throw th;
                    }
                } else {
                    alpha = 1.0f;
                }
                canvas3 = canvas;
                MultiParagraph.m10285painthn5TExg$default(textLayoutResult.getMultiParagraph(), canvas3, brush, alpha, shadow2, textDecoration2, drawStyle2, 0, 64, null);
            } else {
                canvas3 = canvas;
                if (spanStyle.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE) {
                    jM8174getBlack0d7_KjU = spanStyle.getTextForegroundStyle().mo10775getColor0d7_KjU();
                } else {
                    jM8174getBlack0d7_KjU = Color.INSTANCE.m8174getBlack0d7_KjU();
                }
                textLayoutResult.getMultiParagraph().m10290paintLG529CI(canvas3, (30 & 2) != 0 ? Color.INSTANCE.m8184getUnspecified0d7_KjU() : jM8174getBlack0d7_KjU, (30 & 4) != 0 ? null : shadow2, (30 & 8) != 0 ? null : textDecoration2, (30 & 16) == 0 ? drawStyle2 : null, (30 & 32) != 0 ? DrawScope.INSTANCE.m8731getDefaultBlendMode0nO6VwU() : 0);
            }
            if (z) {
                canvas3.restore();
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            if (z) {
            }
        }
    }
}

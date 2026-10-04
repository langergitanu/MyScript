package androidx.compose.p004ui.graphics.drawscope;

import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.InlineClassHelperKt;
import androidx.compose.p004ui.graphics.Path;
import kotlin.Metadata;

/* JADX INFO: compiled from: CanvasDrawScope.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m1599d2 = {"asDrawTransform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "ui-graphics"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class CanvasDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt.asDrawTransform.1
            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long mo8655getSizeNHjbRc() {
                return drawContext.mo8650getSizeNHjbRc();
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
            public long mo8654getCenterF1C5BW0() {
                return SizeKt.m7982getCenteruvyYCjk(mo8655getSizeNHjbRc());
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            public void inset(float left, float top, float right, float bottom) {
                Canvas canvas = drawContext.getCanvas();
                DrawContext drawContext2 = drawContext;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (mo8655getSizeNHjbRc() >> 32)) - (right + left);
                long jM7963constructorimpl = Size.m7963constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (mo8655getSizeNHjbRc() & 4294967295L)) - (bottom + top))) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32));
                if (!(Float.intBitsToFloat((int) (jM7963constructorimpl >> 32)) >= 0.0f && Float.intBitsToFloat((int) (jM7963constructorimpl & 4294967295L)) >= 0.0f)) {
                    InlineClassHelperKt.throwIllegalArgumentException("Width and height must be greater than or equal to zero");
                }
                drawContext2.mo8651setSizeuvyYCjk(jM7963constructorimpl);
                canvas.translate(left, top);
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo8653clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
                drawContext.getCanvas().mo7998clipRectN_I0leg(left, top, right, bottom, clipOp);
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo8652clipPathmtrdDE(Path path, int clipOp) {
                drawContext.getCanvas().mo7997clipPathmtrdDE(path, clipOp);
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            public void translate(float left, float top) {
                drawContext.getCanvas().translate(left, top);
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo8656rotateUv8p0NA(float degrees, long pivot) {
                Canvas canvas = drawContext.getCanvas();
                int i = (int) (pivot >> 32);
                int i2 = (int) (pivot & 4294967295L);
                canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
                canvas.rotate(degrees);
                canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo8657scale0AR0LA0(float scaleX, float scaleY, long pivot) {
                Canvas canvas = drawContext.getCanvas();
                int i = (int) (pivot >> 32);
                int i2 = (int) (pivot & 4294967295L);
                canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
                canvas.scale(scaleX, scaleY);
                canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo8658transform58bKbWc(float[] matrix) {
                drawContext.getCanvas().mo7999concat58bKbWc(matrix);
            }
        };
    }
}

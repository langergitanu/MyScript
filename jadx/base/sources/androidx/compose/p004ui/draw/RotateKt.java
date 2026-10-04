package androidx.compose.p004ui.draw;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Rotate.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, m1599d2 = {"rotate", "Landroidx/compose/ui/Modifier;", "degrees", "", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class RotateKt {
    public static final Modifier rotate(Modifier modifier, float f) {
        return f == 0.0f ? modifier : GraphicsLayerModifierKt.m8315graphicsLayer_6ThJ44$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 0, null, 524031, null);
    }
}

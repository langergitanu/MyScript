package androidx.compose.p004ui.draw;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Scale.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0003H\u0007¨\u0006\u0005"}, m1599d2 = {"scale", "Landroidx/compose/ui/Modifier;", "scaleX", "", "scaleY", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ScaleKt {
    public static final Modifier scale(Modifier modifier, float f, float f2) {
        return (f == 1.0f && f2 == 1.0f) ? modifier : GraphicsLayerModifierKt.m8315graphicsLayer_6ThJ44$default(modifier, f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 0, null, 524284, null);
    }

    public static final Modifier scale(Modifier modifier, float f) {
        return scale(modifier, f, f);
    }
}

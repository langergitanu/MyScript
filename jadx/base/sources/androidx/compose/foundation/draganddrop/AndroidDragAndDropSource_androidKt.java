package androidx.compose.foundation.draganddrop;

import androidx.compose.p004ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: LegacyDragAndDropSourceWithDefaultPainter.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"androidx/compose/foundation/draganddrop/AndroidDragAndDropSource_androidKt__LegacyDragAndDropSourceWithDefaultPainter_androidKt"}, m1600k = 4, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidDragAndDropSource_androidKt {
    @Deprecated(message = "Replaced by overload with a callback for obtain a transfer data,start detection is performed by Compose itself", replaceWith = @ReplaceWith(expression = "Modifier.dragAndDropSource(transferData)", imports = {}))
    public static final Modifier dragAndDropSource(Modifier modifier, Function2<? super DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return C0344x91ddc036.dragAndDropSource(modifier, function2);
    }
}

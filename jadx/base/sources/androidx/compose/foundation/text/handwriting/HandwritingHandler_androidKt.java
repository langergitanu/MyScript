package androidx.compose.foundation.text.handwriting;

import androidx.compose.p004ui.Modifier;
import kotlin.Metadata;

/* JADX INFO: compiled from: HandwritingHandler.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, m1599d2 = {"handwritingHandler", "Landroidx/compose/ui/Modifier;", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class HandwritingHandler_androidKt {
    public static final Modifier handwritingHandler(Modifier modifier) {
        return StylusHandwriting_androidKt.isStylusHandwritingSupported() ? modifier.then(new HandwritingHandlerElement()) : modifier;
    }
}

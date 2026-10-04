package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ContentAlpha.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"LocalContentAlpha", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalContentAlpha", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ContentAlphaKt {
    private static final ProvidableCompositionLocal<Float> LocalContentAlpha = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material.ContentAlphaKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Float.valueOf(ContentAlphaKt.LocalContentAlpha$lambda$0());
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LocalContentAlpha$lambda$0() {
        return 1.0f;
    }

    public static final ProvidableCompositionLocal<Float> getLocalContentAlpha() {
        return LocalContentAlpha;
    }
}

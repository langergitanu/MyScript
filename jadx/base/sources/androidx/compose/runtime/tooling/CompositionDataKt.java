package androidx.compose.runtime.tooling;

import kotlin.Metadata;

/* JADX INFO: compiled from: CompositionData.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"findCompositionInstance", "Landroidx/compose/runtime/tooling/CompositionInstance;", "Landroidx/compose/runtime/tooling/CompositionData;", "runtime"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class CompositionDataKt {
    public static final CompositionInstance findCompositionInstance(CompositionData compositionData) {
        if (compositionData instanceof CompositionInstance) {
            return (CompositionInstance) compositionData;
        }
        return null;
    }
}

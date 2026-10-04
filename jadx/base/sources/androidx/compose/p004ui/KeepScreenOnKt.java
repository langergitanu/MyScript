package androidx.compose.p004ui;

import kotlin.Metadata;

/* JADX INFO: compiled from: KeepScreenOn.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, m1599d2 = {"keepScreenOn", "Landroidx/compose/ui/Modifier;", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class KeepScreenOnKt {
    public static final Modifier keepScreenOn(Modifier modifier) {
        return modifier.then(KeepScreenOnElement.INSTANCE);
    }
}

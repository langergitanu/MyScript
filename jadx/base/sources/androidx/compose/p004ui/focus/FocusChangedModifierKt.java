package androidx.compose.p004ui.focus;

import androidx.compose.p004ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FocusChangedModifier.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¨\u0006\u0005"}, m1599d2 = {"onFocusChanged", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusState;", "", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class FocusChangedModifierKt {
    public static final Modifier onFocusChanged(Modifier modifier, Function1<? super FocusState, Unit> function1) {
        return modifier.then(new FocusChangedElement(function1));
    }
}

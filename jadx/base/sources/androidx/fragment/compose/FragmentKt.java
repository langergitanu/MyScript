package androidx.fragment.compose;

import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.p004ui.platform.ViewCompositionStrategy;
import androidx.compose.runtime.Composer;
import androidx.fragment.app.Fragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Fragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0011\u0010\u0000\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m1599d2 = {FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/ui/platform/ComposeView;", "Landroidx/fragment/app/Fragment;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/platform/ComposeView;", "fragment-compose_release"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class FragmentKt {
    public static final ComposeView content(Fragment fragment, Function2<? super Composer, ? super Integer, Unit> function2) {
        ComposeView composeView = new ComposeView(fragment.requireContext(), null, 0, 6, null);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(function2);
        return composeView;
    }
}

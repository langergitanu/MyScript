package androidx.navigation;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ActivityNavigatorDestinationBuilder.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"androidx/navigation/ActivityNavigatorDestinationBuilderKt__ActivityNavigatorDestinationBuilder_androidKt"}, m1600k = 4, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ActivityNavigatorDestinationBuilderKt {
    @Deprecated(message = "Use routes to build your ActivityDestination instead", replaceWith = @ReplaceWith(expression = "activity(route = id.toString()) { builder.invoke() }", imports = {}))
    public static final void activity(NavGraphBuilder navGraphBuilder, int i, Function1<? super ActivityNavigatorDestinationBuilder, Unit> function1) {
        C2494x70fa4890.activity(navGraphBuilder, i, function1);
    }

    public static final void activity(NavGraphBuilder navGraphBuilder, String str, Function1<? super ActivityNavigatorDestinationBuilder, Unit> function1) {
        C2494x70fa4890.activity(navGraphBuilder, str, function1);
    }
}

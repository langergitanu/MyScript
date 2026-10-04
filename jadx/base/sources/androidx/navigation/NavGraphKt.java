package androidx.navigation;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"androidx/navigation/NavGraphKt__NavGraphKt", "androidx/navigation/NavGraphKt__NavGraph_androidKt"}, m1600k = 4, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class NavGraphKt {
    public static final boolean contains(NavGraph navGraph, int i) {
        return NavGraphKt__NavGraph_androidKt.contains(navGraph, i);
    }

    public static final <T> boolean contains(NavGraph navGraph, T t) {
        return NavGraphKt__NavGraphKt.contains(navGraph, t);
    }

    public static final boolean contains(NavGraph navGraph, String str) {
        return NavGraphKt__NavGraphKt.contains(navGraph, str);
    }

    public static final NavDestination get(NavGraph navGraph, int i) {
        return NavGraphKt__NavGraph_androidKt.get(navGraph, i);
    }

    public static final <T> NavDestination get(NavGraph navGraph, T t) {
        return NavGraphKt__NavGraphKt.get(navGraph, t);
    }

    public static final NavDestination get(NavGraph navGraph, String str) {
        return NavGraphKt__NavGraphKt.get(navGraph, str);
    }

    public static final void minusAssign(NavGraph navGraph, NavDestination navDestination) {
        NavGraphKt__NavGraphKt.minusAssign(navGraph, navDestination);
    }

    public static final void plusAssign(NavGraph navGraph, NavDestination navDestination) {
        NavGraphKt__NavGraphKt.plusAssign(navGraph, navDestination);
    }

    public static final void plusAssign(NavGraph navGraph, NavGraph navGraph2) {
        NavGraphKt__NavGraphKt.plusAssign(navGraph, navGraph2);
    }
}

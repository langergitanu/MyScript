package androidx.navigation;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"androidx/navigation/NavHostKt__NavHostKt", "androidx/navigation/NavHostKt__NavHost_androidKt"}, m1600k = 4, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class NavHostKt {
    @Deprecated(message = "Use routes to create your NavGraph instead", replaceWith = @ReplaceWith(expression = "createGraph(startDestination = startDestination.toString(), route = id.toString()) { builder.invoke() }", imports = {}))
    public static final NavGraph createGraph(NavHost navHost, int i, int i2, Function1<? super NavGraphBuilder, Unit> function1) {
        return NavHostKt__NavHost_androidKt.createGraph(navHost, i, i2, function1);
    }

    public static final NavGraph createGraph(NavHost navHost, Object obj, KClass<?> kClass, Map<KType, NavType<?>> map, Function1<? super NavGraphBuilder, Unit> function1) {
        return NavHostKt__NavHostKt.createGraph(navHost, obj, kClass, map, function1);
    }

    public static final NavGraph createGraph(NavHost navHost, String str, String str2, Function1<? super NavGraphBuilder, Unit> function1) {
        return NavHostKt__NavHostKt.createGraph(navHost, str, str2, function1);
    }

    public static final NavGraph createGraph(NavHost navHost, KClass<?> kClass, KClass<?> kClass2, Map<KType, NavType<?>> map, Function1<? super NavGraphBuilder, Unit> function1) {
        return NavHostKt__NavHostKt.createGraph(navHost, kClass, kClass2, map, function1);
    }
}

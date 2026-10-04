package androidx.navigation.compose;

import androidx.collection.MutableObjectFloatMap;
import androidx.collection.ObjectFloatMapKt;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SizeTransform;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavType;
import androidx.navigation.Navigator;
import androidx.navigation.compose.ComposeNavGraphNavigator;
import androidx.navigation.compose.ComposeNavigator;
import androidx.navigation.compose.internal.NavComposeUtils_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NavHost.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r\u001aÚ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u001f\b\u0002\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0017\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0018\u001a\u0098\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052$\b\u0002\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2(\b\u0002\u0010\u001a\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u001c\u001a¿\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u001d2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\u001d\b\u0002\u0010\u001e\u001a\u0017\u0012\u0004\u0012\u00020 \u0012\r\u0012\u000b\u0012\u0002\b\u00030!¢\u0006\u0002\b\u00190\u001f2$\b\u0002\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2(\b\u0002\u0010\u001a\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\"\u001a»\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020#2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\u001d\b\u0002\u0010\u001e\u001a\u0017\u0012\u0004\u0012\u00020 \u0012\r\u0012\u000b\u0012\u0002\b\u00030!¢\u0006\u0002\b\u00190\u001f2$\b\u0002\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2(\b\u0002\u0010\u001a\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010$\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010'\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001f\b\u0002\u0010\u0010\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0016\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\f2\u001f\b\u0002\u0010\u0017\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010(\u001aó\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2$\b\u0002\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2$\b\u0002\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\f2(\b\u0002\u0010\u001a\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\n¢\u0006\u0002\b\u0019¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010)\u001a\u001c\u0010*\u001a\u0004\u0018\u00010\u0013*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u001a\u001c\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u001a\u001c\u0010.\u001a\u0004\u0018\u00010\u0013*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u001a\u001c\u0010/\u001a\u0004\u0018\u00010\u0015*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002\u001a\u001c\u00100\u001a\u0004\u0018\u00010\u001b*\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¨\u00061²\u0006\u0010\u00102\u001a\b\u0012\u0004\u0012\u00020\u001203X\u008a\u0084\u0002²\u0006\n\u00104\u001a\u000205X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u000207X\u008a\u008e\u0002²\u0006\u0010\u00108\u001a\b\u0012\u0004\u0012\u00020\u001203X\u008a\u0084\u0002²\u0006\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\u001203X\u008a\u0084\u0002"}, m1599d2 = {"NavHost", "", "navController", "Landroidx/navigation/NavHostController;", "startDestination", "", "modifier", "Landroidx/compose/ui/Modifier;", "route", "builder", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "contentAlignment", "Landroidx/compose/ui/Alignment;", "enterTransition", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "exitTransition", "Landroidx/compose/animation/ExitTransition;", "popEnterTransition", "popExitTransition", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Lkotlin/jvm/JvmSuppressWildcards;", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "Lkotlin/reflect/KClass;", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "(Landroidx/navigation/NavHostController;Lkotlin/reflect/KClass;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/reflect/KClass;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "", "(Landroidx/navigation/NavHostController;Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/reflect/KClass;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "graph", "Landroidx/navigation/NavGraph;", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createEnterTransition", "Landroidx/navigation/NavDestination;", "scope", "createExitTransition", "createPopEnterTransition", "createPopExitTransition", "createSizeTransform", "navigation-compose_release", "currentBackStack", "", "progress", "", "inPredictiveBack", "", "allVisibleEntries", "visibleEntries"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class NavHostKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$1(NavHostController navHostController, String str, Modifier modifier, String str2, Function1 function1, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, str, modifier, str2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$13(NavHostController navHostController, String str, Modifier modifier, Alignment alignment, String str2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, int i2, int i3, Composer composer, int i4) {
        NavHost(navHostController, str, modifier, alignment, str2, function1, function12, function13, function14, function15, function16, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$19(NavHostController navHostController, KClass kClass, Modifier modifier, Alignment alignment, KClass kClass2, Map map, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, int i2, int i3, Composer composer, int i4) {
        NavHost(navHostController, (KClass<?>) kClass, modifier, alignment, (KClass<?>) kClass2, (Map<KType, NavType<?>>) map, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function1, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function12, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function13, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function14, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) function15, (Function1<? super NavGraphBuilder, Unit>) function16, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$25(NavHostController navHostController, Object obj, Modifier modifier, Alignment alignment, KClass kClass, Map map, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, int i2, int i3, Composer composer, int i4) {
        NavHost(navHostController, obj, modifier, alignment, (KClass<?>) kClass, (Map<KType, NavType<?>>) map, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function1, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function12, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition>) function13, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition>) function14, (Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform>) function15, (Function1<? super NavGraphBuilder, Unit>) function16, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$26(NavHostController navHostController, NavGraph navGraph, Modifier modifier, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$31(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$37(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$7(NavHostController navHostController, String str, Modifier modifier, Alignment alignment, String str2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, str, modifier, alignment, str2, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$79(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavHost$lambda$80(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, int i2, Composer composer, int i3) {
        NavHost(navHostController, navGraph, modifier, alignment, function1, function12, function13, function14, function15, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void NavHost(final NavHostController navHostController, final String str, Modifier modifier, String str2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        String str3;
        String str4;
        boolean z;
        Object objRememberedValue;
        final Modifier modifier3;
        final String str5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(141827520);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavHost)P(2,4,1,3)93@3782L126,91@3742L190:NavHost.kt#opm8kd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    str3 = str2;
                    i3 |= composerStartRestartGroup.changed(str3) ? 2048 : 1024;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
                }
                if ((i3 & 9363) != 9362 || !composerStartRestartGroup.getSkipping()) {
                    Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    str4 = i4 == 0 ? null : str3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(141827520, i3, -1, "androidx.navigation.compose.NavHost (NavHost.kt:90)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1142694498, "CC(remember):NavHost.kt#9igjgp");
                    z = ((i3 & 7168) != 2048) | ((i3 & 112) != 32) | ((57344 & i3) == 16384);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str4);
                        function1.invoke(navGraphBuilder);
                        objRememberedValue = navGraphBuilder.build();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i6 = i3 & 910;
                    Modifier modifier4 = companion;
                    NavHost(navHostController, (NavGraph) objRememberedValue, modifier4, null, null, null, null, null, null, composerStartRestartGroup, i6, 504);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    str5 = str4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    str5 = str3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavHostKt.NavHost$lambda$1(navHostController, str, modifier3, str5, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 3072;
            str3 = str2;
            if ((i2 & 16) != 0) {
            }
            if ((i3 & 9363) != 9362) {
                if (i5 == 0) {
                }
                if (i4 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1142694498, "CC(remember):NavHost.kt#9igjgp");
                z = ((i3 & 7168) != 2048) | ((i3 & 112) != 32) | ((57344 & i3) == 16384);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str4);
                    function1.invoke(navGraphBuilder2);
                    objRememberedValue = navGraphBuilder2.build();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i62 = i3 & 910;
                    Modifier modifier42 = companion;
                    NavHost(navHostController, (NavGraph) objRememberedValue, modifier42, null, null, null, null, null, null, composerStartRestartGroup, i62, 504);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                    str5 = str4;
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        str3 = str2;
        if ((i2 & 16) != 0) {
        }
        if ((i3 & 9363) != 9362) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition NavHost$lambda$3$lambda$2(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition NavHost$lambda$5$lambda$4(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports sizeTransform")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void NavHost(final NavHostController navHostController, final String str, Modifier modifier, Alignment alignment, String str2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, final Function1 function15, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Alignment topStart;
        int i5;
        String str3;
        int i6;
        Function1 function16;
        int i7;
        Function1 function17;
        Function1 function18;
        Function1 function19;
        int i8;
        Modifier modifier3;
        Alignment alignment2;
        Function1 function110;
        Function1 function111;
        String str4;
        Modifier modifier4;
        boolean z;
        Object objRememberedValue;
        final Function1 function112;
        Composer composer2;
        final Function1 function113;
        final Function1 function114;
        final Alignment alignment3;
        final Function1 function115;
        final String str5;
        final Modifier modifier5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(410432995);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavHost)P(5,9,4,1,8,2,3,6,7)145@6007L126,143@5967L320:NavHost.kt#opm8kd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    topStart = alignment;
                    i3 |= composerStartRestartGroup.changed(topStart) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        str3 = str2;
                        i3 |= composerStartRestartGroup.changed(str3) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                        function16 = function1;
                    } else {
                        function16 = function1;
                        if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function16) ? 131072 : 65536;
                        }
                    }
                    i7 = i2 & 64;
                    if (i7 == 0) {
                        i3 |= 1572864;
                        function17 = function12;
                    } else {
                        function17 = function12;
                        if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function17) ? 1048576 : 524288;
                        }
                    }
                    if ((i & 12582912) == 0) {
                        i3 |= ((i2 & 128) == 0 && composerStartRestartGroup.changedInstance(function13)) ? 8388608 : 4194304;
                    }
                    if ((i & 100663296) == 0) {
                        i3 |= ((i2 & 256) == 0 && composerStartRestartGroup.changedInstance(function14)) ? 67108864 : 33554432;
                    }
                    if ((i2 & 512) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function15) ? 536870912 : 268435456;
                    }
                    if ((i3 & 306783379) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "131@5472L50,134@5619L51");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                topStart = Alignment.INSTANCE.getTopStart();
                            }
                            if (i5 != 0) {
                                str3 = null;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -710868907, "CC(remember):NavHost.kt#9igjgp");
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NavHostKt.NavHost$lambda$3$lambda$2((AnimatedContentTransitionScope) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function16 = (Function1) objRememberedValue2;
                            }
                            if (i7 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -710864202, "CC(remember):NavHost.kt#9igjgp");
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NavHostKt.NavHost$lambda$5$lambda$4((AnimatedContentTransitionScope) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function17 = (Function1) objRememberedValue3;
                            }
                            if ((i2 & 128) == 0) {
                                i3 &= -29360129;
                                function18 = function16;
                            } else {
                                function18 = function13;
                            }
                            if ((i2 & 256) == 0) {
                                function19 = function18;
                                i8 = i3 & (-234881025);
                                modifier3 = modifier2;
                                alignment2 = topStart;
                                function110 = function17;
                                function111 = function110;
                                str4 = str3;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    modifier4 = modifier3;
                                } else {
                                    modifier4 = modifier3;
                                    ComposerKt.traceEventStart(410432995, i8, -1, "androidx.navigation.compose.NavHost (NavHost.kt:142)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -710851711, "CC(remember):NavHost.kt#9igjgp");
                                z = ((57344 & i8) != 16384) | ((i8 & 112) != 32) | ((1879048192 & i8) != 536870912);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str4);
                                    function15.invoke(navGraphBuilder);
                                    objRememberedValue = navGraphBuilder.build();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                NavGraph navGraph = (NavGraph) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i10 = i8 & 8078;
                                int i11 = i8 >> 3;
                                int i12 = i10 | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (i11 & 29360128);
                                Modifier modifier6 = modifier4;
                                String str6 = str4;
                                NavHost(navHostController, navGraph, modifier6, alignment2, function16, function110, function19, function111, null, composerStartRestartGroup, i12, 256);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function112 = function19;
                                composer2 = composerStartRestartGroup;
                                function113 = function16;
                                function114 = function111;
                                alignment3 = alignment2;
                                function115 = function110;
                                str5 = str6;
                                modifier5 = modifier6;
                            } else {
                                function19 = function18;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                            }
                            function19 = function13;
                        }
                        i8 = i3;
                        modifier3 = modifier2;
                        alignment2 = topStart;
                        function110 = function17;
                        str4 = str3;
                        function111 = function14;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -710851711, "CC(remember):NavHost.kt#9igjgp");
                        z = ((57344 & i8) != 16384) | ((i8 & 112) != 32) | ((1879048192 & i8) != 536870912);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str4);
                            function15.invoke(navGraphBuilder2);
                            objRememberedValue = navGraphBuilder2.build();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            NavGraph navGraph2 = (NavGraph) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i102 = i8 & 8078;
                            int i112 = i8 >> 3;
                            int i122 = i102 | (57344 & i112) | (458752 & i112) | (3670016 & i112) | (i112 & 29360128);
                            Modifier modifier62 = modifier4;
                            String str62 = str4;
                            NavHost(navHostController, navGraph2, modifier62, alignment2, function16, function110, function19, function111, null, composerStartRestartGroup, i122, 256);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function112 = function19;
                            composer2 = composerStartRestartGroup;
                            function113 = function16;
                            function114 = function111;
                            alignment3 = alignment2;
                            function115 = function110;
                            str5 = str62;
                            modifier5 = modifier62;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function112 = function13;
                        function113 = function16;
                        modifier5 = modifier2;
                        alignment3 = topStart;
                        composer2 = composerStartRestartGroup;
                        function115 = function17;
                        str5 = str3;
                        function114 = function14;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavHostKt.NavHost$lambda$7(navHostController, str, modifier5, alignment3, str5, function113, function115, function112, function114, function15, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                str3 = str2;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i2 & 512) == 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "131@5472L50,134@5619L51");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if ((i2 & 128) == 0) {
                        }
                        if ((i2 & 256) == 0) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            topStart = alignment;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            str3 = str2;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i2 & 512) == 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        topStart = alignment;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        str3 = str2;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i2 & 512) == 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition NavHost$lambda$9$lambda$8(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition NavHost$lambda$11$lambda$10(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavHost(final NavHostController navHostController, final String str, Modifier modifier, Alignment alignment, String str2, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, final Function1<? super NavGraphBuilder, Unit> function16, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        Alignment alignment2;
        int i6;
        String str3;
        int i7;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function17;
        int i8;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function18;
        int i9;
        int i10;
        int i11;
        int i12;
        Modifier.Companion companion;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function19;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function110;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function111;
        Alignment alignment3;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function112;
        String str4;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function113;
        int i13;
        Alignment alignment4;
        boolean z;
        Object objRememberedValue;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function114;
        Composer composer2;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function115;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function116;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function117;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function118;
        final String str5;
        final Alignment alignment5;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1840250294);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavHost)P(5,10,4,1,8,2,3,6,7,9)213@8658L126,211@8618L343:NavHost.kt#opm8kd");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        int i14 = i3 & 4;
        if (i14 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    alignment2 = alignment;
                    i4 |= composerStartRestartGroup.changed(alignment2) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        str3 = str2;
                        i4 |= composerStartRestartGroup.changed(str3) ? 16384 : 8192;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                        function17 = function1;
                    } else {
                        function17 = function1;
                        if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function17) ? 131072 : 65536;
                        }
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function12) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            function18 = function13;
                            int i15 = composerStartRestartGroup.changedInstance(function18) ? 8388608 : 4194304;
                            i4 |= i15;
                        } else {
                            function18 = function13;
                        }
                        i4 |= i15;
                    } else {
                        function18 = function13;
                    }
                    if ((i & 100663296) == 0) {
                        i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changedInstance(function14)) ? 67108864 : 33554432;
                    }
                    i9 = i3 & 512;
                    if (i9 != 0) {
                        if ((i & 805306368) == 0) {
                            i10 = i9;
                            i4 |= composerStartRestartGroup.changedInstance(function15) ? 536870912 : 268435456;
                        }
                        if ((i3 & 1024) != 0) {
                            i11 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i11 = i2 | (composerStartRestartGroup.changedInstance(function16) ? 4 : 2);
                        } else {
                            i11 = i2;
                        }
                        i12 = i4;
                        if ((i4 & 306783379) != 306783378 || (i11 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "188@7838L58,194@8039L59");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                companion = i14 == 0 ? Modifier.INSTANCE : modifier2;
                                Alignment topStart = i5 == 0 ? Alignment.INSTANCE.getTopStart() : alignment2;
                                if (i6 != 0) {
                                    str3 = null;
                                }
                                if (i7 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1045981872, "CC(remember):NavHost.kt#9igjgp");
                                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda14
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return NavHostKt.NavHost$lambda$9$lambda$8((AnimatedContentTransitionScope) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    function17 = (Function1) objRememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                }
                                if (i8 == 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1045975439, "CC(remember):NavHost.kt#9igjgp");
                                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda15
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return NavHostKt.NavHost$lambda$11$lambda$10((AnimatedContentTransitionScope) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    function19 = (Function1) objRememberedValue3;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    function19 = function12;
                                }
                                if ((i3 & 128) != 0) {
                                    i12 &= -29360129;
                                    function18 = function17;
                                }
                                if ((i3 & 256) == 0) {
                                    i12 &= -234881025;
                                    function110 = function19;
                                } else {
                                    function110 = function14;
                                }
                                if (i10 == 0) {
                                    function113 = null;
                                    Alignment alignment6 = topStart;
                                    function111 = function17;
                                    alignment3 = alignment6;
                                    String str6 = str3;
                                    function112 = function18;
                                    str4 = str6;
                                } else {
                                    Alignment alignment7 = topStart;
                                    function111 = function17;
                                    alignment3 = alignment7;
                                    String str7 = str3;
                                    function112 = function18;
                                    str4 = str7;
                                    function113 = function15;
                                }
                                i13 = i12;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                int i16 = (i3 & 128) != 0 ? i12 & (-29360129) : i12;
                                if ((i3 & 256) != 0) {
                                    i16 &= -234881025;
                                }
                                String str8 = str3;
                                function112 = function18;
                                str4 = str8;
                                function110 = function14;
                                i13 = i16;
                                function111 = function17;
                                companion = modifier2;
                                alignment3 = alignment2;
                                function19 = function12;
                                function113 = function15;
                            }
                            composerStartRestartGroup.endDefaults();
                            Modifier modifier4 = companion;
                            if (ComposerKt.isTraceInProgress()) {
                                alignment4 = alignment3;
                            } else {
                                alignment4 = alignment3;
                                ComposerKt.traceEventStart(1840250294, i13, i11, "androidx.navigation.compose.NavHost (NavHost.kt:210)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1045955564, "CC(remember):NavHost.kt#9igjgp");
                            z = ((57344 & i13) != 16384) | ((i13 & 112) != 32) | ((i11 & 14) != 4);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str4);
                                function16.invoke(navGraphBuilder);
                                objRememberedValue = navGraphBuilder.build();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i17 = i13 >> 3;
                            Alignment alignment8 = alignment4;
                            String str9 = str4;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function119 = function111;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function120 = function19;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function121 = function110;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function122 = function113;
                            NavHost(navHostController, (NavGraph) objRememberedValue, modifier4, alignment8, function119, function120, function112, function121, function122, composerStartRestartGroup, (i13 & 8078) | (57344 & i17) | (458752 & i17) | (3670016 & i17) | (29360128 & i17) | (i17 & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function114 = function122;
                            composer2 = composerStartRestartGroup;
                            function115 = function112;
                            function116 = function121;
                            function117 = function119;
                            function118 = function120;
                            str5 = str9;
                            alignment5 = alignment8;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            function115 = function18;
                            str5 = str3;
                            composer2 = composerStartRestartGroup;
                            alignment5 = alignment2;
                            function116 = function14;
                            function114 = function15;
                            function117 = function17;
                            modifier3 = modifier2;
                            function118 = function12;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavHostKt.NavHost$lambda$13(navHostController, str, modifier3, alignment5, str5, function117, function118, function115, function116, function114, function16, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 805306368;
                    i10 = i9;
                    if ((i3 & 1024) != 0) {
                    }
                    i12 = i4;
                    if ((i4 & 306783379) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "188@7838L58,194@8039L59");
                        if ((i & 1) != 0) {
                            if (i14 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                            }
                            if ((i3 & 256) == 0) {
                            }
                            if (i10 == 0) {
                            }
                            i13 = i12;
                            composerStartRestartGroup.endDefaults();
                            Modifier modifier42 = companion;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1045955564, "CC(remember):NavHost.kt#9igjgp");
                            z = ((57344 & i13) != 16384) | ((i13 & 112) != 32) | ((i11 & 14) != 4);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z) {
                                NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navHostController.getNavigatorProvider(), str, str4);
                                function16.invoke(navGraphBuilder2);
                                objRememberedValue = navGraphBuilder2.build();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i172 = i13 >> 3;
                                Alignment alignment82 = alignment4;
                                String str92 = str4;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1192 = function111;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1202 = function19;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1212 = function110;
                                Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1222 = function113;
                                NavHost(navHostController, (NavGraph) objRememberedValue, modifier42, alignment82, function1192, function1202, function112, function1212, function1222, composerStartRestartGroup, (i13 & 8078) | (57344 & i172) | (458752 & i172) | (3670016 & i172) | (29360128 & i172) | (i172 & 234881024), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function114 = function1222;
                                composer2 = composerStartRestartGroup;
                                function115 = function112;
                                function116 = function1212;
                                function117 = function1192;
                                function118 = function1202;
                                str5 = str92;
                                alignment5 = alignment82;
                                modifier3 = modifier42;
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                str3 = str2;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                }
                i10 = i9;
                if ((i3 & 1024) != 0) {
                }
                i12 = i4;
                if ((i4 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            alignment2 = alignment;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            str3 = str2;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i9 = i3 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            if ((i3 & 1024) != 0) {
            }
            i12 = i4;
            if ((i4 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        alignment2 = alignment;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        str3 = str2;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i9 = i3 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        if ((i3 & 1024) != 0) {
        }
        i12 = i4;
        if ((i4 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition NavHost$lambda$15$lambda$14(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition NavHost$lambda$17$lambda$16(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:204:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavHost(final NavHostController navHostController, final KClass<?> kClass, Modifier modifier, Alignment alignment, KClass<?> kClass2, Map<KType, NavType<?>> map, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, final Function1<? super NavGraphBuilder, Unit> function16, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        Alignment alignment2;
        int i6;
        KClass<?> kClass3;
        int i7;
        Map<KType, NavType<?>> mapEmptyMap;
        int i8;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function17;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function18;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function19;
        int i14;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function110;
        KClass<?> kClass4;
        Alignment alignment3;
        Map<KType, NavType<?>> map2;
        Modifier modifier3;
        int i15;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function111;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function112;
        boolean zChanged;
        Object objRememberedValue;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function113;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function114;
        Composer composer2;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function115;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function116;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function117;
        final KClass<?> kClass5;
        final Map<KType, NavType<?>> map3;
        final Alignment alignment4;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(750467758);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavHost)P(5,10,4,1,8,11,2,3,6,7,9)285@11605L135,283@11565L352:NavHost.kt#opm8kd");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(kClass) ? 32 : 16;
        }
        int i16 = i3 & 4;
        if (i16 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    alignment2 = alignment;
                    i4 |= composerStartRestartGroup.changed(alignment2) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 == 0) {
                    if ((i & 24576) == 0) {
                        kClass3 = kClass2;
                        i4 |= composerStartRestartGroup.changedInstance(kClass3) ? 16384 : 8192;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                        mapEmptyMap = map;
                    } else {
                        mapEmptyMap = map;
                        if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(mapEmptyMap) ? 131072 : 65536;
                        }
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                        function17 = function1;
                    } else {
                        function17 = function1;
                        if ((i & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function17) ? 1048576 : 524288;
                        }
                    }
                    i9 = i3 & 128;
                    if (i9 == 0) {
                        i4 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
                    }
                    if ((i & 100663296) == 0) {
                        i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changedInstance(function13)) ? 67108864 : 33554432;
                    }
                    if ((i & 805306368) == 0) {
                        i4 |= ((i3 & 512) == 0 && composerStartRestartGroup.changedInstance(function14)) ? 536870912 : 268435456;
                    }
                    i10 = i3 & 1024;
                    if (i10 == 0) {
                        i12 = i2 | 6;
                        i11 = i10;
                    } else if ((i2 & 6) == 0) {
                        i11 = i10;
                        i12 = i2 | (composerStartRestartGroup.changedInstance(function15) ? 4 : 2);
                    } else {
                        i11 = i10;
                        i12 = i2;
                    }
                    if ((i3 & 2048) == 0) {
                        i12 |= 48;
                    } else if ((i2 & 48) == 0) {
                        i12 |= composerStartRestartGroup.changedInstance(function16) ? 32 : 16;
                    }
                    i13 = i12;
                    int i17 = i4;
                    if ((i4 & 306783379) == 306783378 || (i13 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "260@10785L58,266@10986L59");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i16 == 0 ? Modifier.INSTANCE : modifier2;
                            Alignment topStart = i5 == 0 ? Alignment.INSTANCE.getTopStart() : alignment2;
                            if (i6 != 0) {
                                kClass3 = null;
                            }
                            if (i7 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -354976248, "CC(remember):NavHost.kt#9igjgp");
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda19
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NavHostKt.NavHost$lambda$15$lambda$14((AnimatedContentTransitionScope) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                function17 = (Function1) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            if (i9 == 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -354969815, "CC(remember):NavHost.kt#9igjgp");
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda20
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NavHostKt.NavHost$lambda$17$lambda$16((AnimatedContentTransitionScope) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                function18 = (Function1) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function18 = function12;
                            }
                            if ((i3 & 256) == 0) {
                                i14 = i17 & (-234881025);
                                function19 = function17;
                            } else {
                                function19 = function13;
                                i14 = i17;
                            }
                            if ((i3 & 512) == 0) {
                                i14 = (-1879048193) & i14;
                                function110 = function18;
                            } else {
                                function110 = function14;
                            }
                            Map<KType, NavType<?>> map4 = mapEmptyMap;
                            kClass4 = kClass3;
                            alignment3 = topStart;
                            map2 = map4;
                            modifier3 = companion;
                            i15 = i14;
                            if (i11 == 0) {
                                function111 = null;
                            }
                            composerStartRestartGroup.endDefaults();
                            Alignment alignment5 = alignment3;
                            if (ComposerKt.isTraceInProgress()) {
                                function112 = function17;
                                ComposerKt.traceEventStart(750467758, i15, i13, "androidx.navigation.compose.NavHost (NavHost.kt:282)");
                            } else {
                                function112 = function17;
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -354949931, "CC(remember):NavHost.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(kClass4) | composerStartRestartGroup.changed(kClass) | ((i13 & 112) == 32);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.getNavigatorProvider(), kClass, kClass4, map2);
                                function16.invoke(navGraphBuilder);
                                objRememberedValue = navGraphBuilder.build();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i18 = i15 & 8078;
                            int i19 = i15 >> 6;
                            int i20 = ((i13 << 24) & 234881024) | (i19 & 29360128) | i18 | (57344 & i19) | (458752 & i19) | (3670016 & i19);
                            Map<KType, NavType<?>> map5 = map2;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function118 = function18;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function119 = function110;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function120 = function111;
                            Modifier modifier5 = modifier3;
                            KClass<?> kClass6 = kClass4;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function121 = function19;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function122 = function112;
                            NavHost(navHostController, (NavGraph) objRememberedValue, modifier5, alignment5, function122, function118, function121, function119, function120, composerStartRestartGroup, i20, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function113 = function119;
                            function114 = function120;
                            composer2 = composerStartRestartGroup;
                            function115 = function122;
                            function116 = function118;
                            function117 = function121;
                            kClass5 = kClass6;
                            map3 = map5;
                            alignment4 = alignment5;
                            modifier4 = modifier5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i15 = (i3 & 256) != 0 ? i17 & (-234881025) : i17;
                            if ((i3 & 512) != 0) {
                                i15 &= -1879048193;
                            }
                            function18 = function12;
                            function19 = function13;
                            map2 = mapEmptyMap;
                            modifier3 = modifier2;
                            function110 = function14;
                            kClass4 = kClass3;
                            alignment3 = alignment2;
                        }
                        function111 = function15;
                        composerStartRestartGroup.endDefaults();
                        Alignment alignment52 = alignment3;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -354949931, "CC(remember):NavHost.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(kClass4) | composerStartRestartGroup.changed(kClass) | ((i13 & 112) == 32);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navHostController.getNavigatorProvider(), kClass, kClass4, map2);
                            function16.invoke(navGraphBuilder2);
                            objRememberedValue = navGraphBuilder2.build();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i182 = i15 & 8078;
                            int i192 = i15 >> 6;
                            int i202 = ((i13 << 24) & 234881024) | (i192 & 29360128) | i182 | (57344 & i192) | (458752 & i192) | (3670016 & i192);
                            Map<KType, NavType<?>> map52 = map2;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1182 = function18;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1192 = function110;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1202 = function111;
                            Modifier modifier52 = modifier3;
                            KClass<?> kClass62 = kClass4;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1212 = function19;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1222 = function112;
                            NavHost(navHostController, (NavGraph) objRememberedValue, modifier52, alignment52, function1222, function1182, function1212, function1192, function1202, composerStartRestartGroup, i202, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function113 = function1192;
                            function114 = function1202;
                            composer2 = composerStartRestartGroup;
                            function115 = function1222;
                            function116 = function1182;
                            function117 = function1212;
                            kClass5 = kClass62;
                            map3 = map52;
                            alignment4 = alignment52;
                            modifier4 = modifier52;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function113 = function14;
                        kClass5 = kClass3;
                        function115 = function17;
                        modifier4 = modifier2;
                        composer2 = composerStartRestartGroup;
                        function116 = function12;
                        function117 = function13;
                        map3 = mapEmptyMap;
                        alignment4 = alignment2;
                        function114 = function15;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavHostKt.NavHost$lambda$19(navHostController, kClass, modifier4, alignment4, kClass5, map3, function115, function116, function117, function113, function114, function16, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 24576;
                kClass3 = kClass2;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                i9 = i3 & 128;
                if (i9 == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i10 = i3 & 1024;
                if (i10 == 0) {
                }
                if ((i3 & 2048) == 0) {
                }
                i13 = i12;
                int i172 = i4;
                if ((i4 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "260@10785L58,266@10986L59");
                    if ((i & 1) != 0) {
                        if (i16 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 == 0) {
                        }
                        if ((i3 & 256) == 0) {
                        }
                        if ((i3 & 512) == 0) {
                        }
                        Map<KType, NavType<?>> map42 = mapEmptyMap;
                        kClass4 = kClass3;
                        alignment3 = topStart;
                        map2 = map42;
                        modifier3 = companion;
                        i15 = i14;
                        if (i11 == 0) {
                            function111 = function15;
                        }
                        composerStartRestartGroup.endDefaults();
                        Alignment alignment522 = alignment3;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -354949931, "CC(remember):NavHost.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(kClass4) | composerStartRestartGroup.changed(kClass) | ((i13 & 112) == 32);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            alignment2 = alignment;
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            kClass3 = kClass2;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            i9 = i3 & 128;
            if (i9 == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i10 = i3 & 1024;
            if (i10 == 0) {
            }
            if ((i3 & 2048) == 0) {
            }
            i13 = i12;
            int i1722 = i4;
            if ((i4 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        alignment2 = alignment;
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        kClass3 = kClass2;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        i9 = i3 & 128;
        if (i9 == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i10 = i3 & 1024;
        if (i10 == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        i13 = i12;
        int i17222 = i4;
        if ((i4 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition NavHost$lambda$21$lambda$20(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition NavHost$lambda$23$lambda$22(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:204:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavHost(final NavHostController navHostController, final Object obj, Modifier modifier, Alignment alignment, KClass<?> kClass, Map<KType, NavType<?>> map, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, final Function1<? super NavGraphBuilder, Unit> function16, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        Alignment alignment2;
        int i6;
        KClass<?> kClass2;
        int i7;
        Map<KType, NavType<?>> mapEmptyMap;
        int i8;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function17;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function18;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function19;
        int i14;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function110;
        KClass<?> kClass3;
        Alignment alignment3;
        Map<KType, NavType<?>> map2;
        Modifier modifier3;
        int i15;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function111;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function112;
        boolean zChanged;
        Object objRememberedValue;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function113;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function114;
        Composer composer2;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function115;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function116;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function117;
        final KClass<?> kClass4;
        final Map<KType, NavType<?>> map3;
        final Alignment alignment4;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1476019057);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavHost)P(5,10,4,1,8,11,2,3,6,7,9)357@14557L135,355@14517L352:NavHost.kt#opm8kd");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(obj) ? 32 : 16;
        }
        int i16 = i3 & 4;
        if (i16 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    alignment2 = alignment;
                    i4 |= composerStartRestartGroup.changed(alignment2) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 == 0) {
                    if ((i & 24576) == 0) {
                        kClass2 = kClass;
                        i4 |= composerStartRestartGroup.changedInstance(kClass2) ? 16384 : 8192;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                        mapEmptyMap = map;
                    } else {
                        mapEmptyMap = map;
                        if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(mapEmptyMap) ? 131072 : 65536;
                        }
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                        function17 = function1;
                    } else {
                        function17 = function1;
                        if ((i & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function17) ? 1048576 : 524288;
                        }
                    }
                    i9 = i3 & 128;
                    if (i9 == 0) {
                        i4 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
                    }
                    if ((i & 100663296) == 0) {
                        i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changedInstance(function13)) ? 67108864 : 33554432;
                    }
                    if ((i & 805306368) == 0) {
                        i4 |= ((i3 & 512) == 0 && composerStartRestartGroup.changedInstance(function14)) ? 536870912 : 268435456;
                    }
                    i10 = i3 & 1024;
                    if (i10 == 0) {
                        i12 = i2 | 6;
                        i11 = i10;
                    } else if ((i2 & 6) == 0) {
                        i11 = i10;
                        i12 = i2 | (composerStartRestartGroup.changedInstance(function15) ? 4 : 2);
                    } else {
                        i11 = i10;
                        i12 = i2;
                    }
                    if ((i3 & 2048) == 0) {
                        i12 |= 48;
                    } else if ((i2 & 48) == 0) {
                        i12 |= composerStartRestartGroup.changedInstance(function16) ? 32 : 16;
                    }
                    i13 = i12;
                    int i17 = i4;
                    if ((i4 & 306783379) == 306783378 || (i13 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "332@13737L58,338@13938L59");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i16 == 0 ? Modifier.INSTANCE : modifier2;
                            Alignment topStart = i5 == 0 ? Alignment.INSTANCE.getTopStart() : alignment2;
                            if (i6 != 0) {
                                kClass2 = null;
                            }
                            if (i7 != 0) {
                                mapEmptyMap = MapsKt.emptyMap();
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1115092247, "CC(remember):NavHost.kt#9igjgp");
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda7
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return NavHostKt.NavHost$lambda$21$lambda$20((AnimatedContentTransitionScope) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                function17 = (Function1) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            if (i9 == 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1115085814, "CC(remember):NavHost.kt#9igjgp");
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return NavHostKt.NavHost$lambda$23$lambda$22((AnimatedContentTransitionScope) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                function18 = (Function1) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function18 = function12;
                            }
                            if ((i3 & 256) == 0) {
                                i14 = i17 & (-234881025);
                                function19 = function17;
                            } else {
                                function19 = function13;
                                i14 = i17;
                            }
                            if ((i3 & 512) == 0) {
                                i14 = (-1879048193) & i14;
                                function110 = function18;
                            } else {
                                function110 = function14;
                            }
                            Map<KType, NavType<?>> map4 = mapEmptyMap;
                            kClass3 = kClass2;
                            alignment3 = topStart;
                            map2 = map4;
                            modifier3 = companion;
                            i15 = i14;
                            if (i11 == 0) {
                                function111 = null;
                            }
                            composerStartRestartGroup.endDefaults();
                            Alignment alignment5 = alignment3;
                            if (ComposerKt.isTraceInProgress()) {
                                function112 = function17;
                                ComposerKt.traceEventStart(-1476019057, i15, i13, "androidx.navigation.compose.NavHost (NavHost.kt:354)");
                            } else {
                                function112 = function17;
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1115065930, "CC(remember):NavHost.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(kClass3) | composerStartRestartGroup.changed(obj) | ((i13 & 112) == 32);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController.getNavigatorProvider(), obj, kClass3, map2);
                                function16.invoke(navGraphBuilder);
                                objRememberedValue = navGraphBuilder.build();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i18 = i15 & 8078;
                            int i19 = i15 >> 6;
                            int i20 = ((i13 << 24) & 234881024) | (i19 & 29360128) | i18 | (57344 & i19) | (458752 & i19) | (3670016 & i19);
                            Map<KType, NavType<?>> map5 = map2;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function118 = function18;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function119 = function110;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function120 = function111;
                            Modifier modifier5 = modifier3;
                            KClass<?> kClass5 = kClass3;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function121 = function19;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function122 = function112;
                            NavHost(navHostController, (NavGraph) objRememberedValue, modifier5, alignment5, function122, function118, function121, function119, function120, composerStartRestartGroup, i20, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function113 = function119;
                            function114 = function120;
                            composer2 = composerStartRestartGroup;
                            function115 = function122;
                            function116 = function118;
                            function117 = function121;
                            kClass4 = kClass5;
                            map3 = map5;
                            alignment4 = alignment5;
                            modifier4 = modifier5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i15 = (i3 & 256) != 0 ? i17 & (-234881025) : i17;
                            if ((i3 & 512) != 0) {
                                i15 &= -1879048193;
                            }
                            function18 = function12;
                            function19 = function13;
                            map2 = mapEmptyMap;
                            modifier3 = modifier2;
                            function110 = function14;
                            kClass3 = kClass2;
                            alignment3 = alignment2;
                        }
                        function111 = function15;
                        composerStartRestartGroup.endDefaults();
                        Alignment alignment52 = alignment3;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1115065930, "CC(remember):NavHost.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(kClass3) | composerStartRestartGroup.changed(obj) | ((i13 & 112) == 32);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navHostController.getNavigatorProvider(), obj, kClass3, map2);
                            function16.invoke(navGraphBuilder2);
                            objRememberedValue = navGraphBuilder2.build();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i182 = i15 & 8078;
                            int i192 = i15 >> 6;
                            int i202 = ((i13 << 24) & 234881024) | (i192 & 29360128) | i182 | (57344 & i192) | (458752 & i192) | (3670016 & i192);
                            Map<KType, NavType<?>> map52 = map2;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1182 = function18;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function1192 = function110;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function1202 = function111;
                            Modifier modifier52 = modifier3;
                            KClass<?> kClass52 = kClass3;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1212 = function19;
                            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1222 = function112;
                            NavHost(navHostController, (NavGraph) objRememberedValue, modifier52, alignment52, function1222, function1182, function1212, function1192, function1202, composerStartRestartGroup, i202, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function113 = function1192;
                            function114 = function1202;
                            composer2 = composerStartRestartGroup;
                            function115 = function1222;
                            function116 = function1182;
                            function117 = function1212;
                            kClass4 = kClass52;
                            map3 = map52;
                            alignment4 = alignment52;
                            modifier4 = modifier52;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function113 = function14;
                        kClass4 = kClass2;
                        function115 = function17;
                        modifier4 = modifier2;
                        composer2 = composerStartRestartGroup;
                        function116 = function12;
                        function117 = function13;
                        map3 = mapEmptyMap;
                        alignment4 = alignment2;
                        function114 = function15;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return NavHostKt.NavHost$lambda$25(navHostController, obj, modifier4, alignment4, kClass4, map3, function115, function116, function117, function113, function114, function16, i, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= 24576;
                kClass2 = kClass;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                i9 = i3 & 128;
                if (i9 == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i10 = i3 & 1024;
                if (i10 == 0) {
                }
                if ((i3 & 2048) == 0) {
                }
                i13 = i12;
                int i172 = i4;
                if ((i4 & 306783379) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "332@13737L58,338@13938L59");
                    if ((i & 1) != 0) {
                        if (i16 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 == 0) {
                        }
                        if ((i3 & 256) == 0) {
                        }
                        if ((i3 & 512) == 0) {
                        }
                        Map<KType, NavType<?>> map42 = mapEmptyMap;
                        kClass3 = kClass2;
                        alignment3 = topStart;
                        map2 = map42;
                        modifier3 = companion;
                        i15 = i14;
                        if (i11 == 0) {
                            function111 = function15;
                        }
                        composerStartRestartGroup.endDefaults();
                        Alignment alignment522 = alignment3;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1115065930, "CC(remember):NavHost.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(kClass3) | composerStartRestartGroup.changed(obj) | ((i13 & 112) == 32);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            alignment2 = alignment;
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            kClass2 = kClass;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            i9 = i3 & 128;
            if (i9 == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i10 = i3 & 1024;
            if (i10 == 0) {
            }
            if ((i3 & 2048) == 0) {
            }
            i13 = i12;
            int i1722 = i4;
            if ((i4 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        alignment2 = alignment;
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        kClass2 = kClass;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        i9 = i3 & 128;
        if (i9 == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i10 = i3 & 1024;
        if (i10 == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        i13 = i12;
        int i17222 = i4;
        if ((i4 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports AnimatedContent")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void NavHost(final NavHostController navHostController, final NavGraph navGraph, Modifier modifier, Composer composer, final int i, final int i2) {
        NavHostController navHostController2;
        int i3;
        NavGraph navGraph2;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-957014592);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavHost)P(2)392@15649L39:NavHost.kt#opm8kd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            navHostController2 = navHostController;
        } else if ((i & 6) == 0) {
            navHostController2 = navHostController;
            i3 = (composerStartRestartGroup.changedInstance(navHostController2) ? 4 : 2) | i;
        } else {
            navHostController2 = navHostController;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            navGraph2 = navGraph;
        } else {
            navGraph2 = navGraph;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(navGraph2) ? 32 : 16;
            }
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-957014592, i3, -1, "androidx.navigation.compose.NavHost (NavHost.kt:392)");
                }
                NavHost(navHostController2, navGraph2, modifier4, null, null, null, null, null, null, composerStartRestartGroup, i3 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, 504);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavHostKt.NavHost$lambda$26(navHostController, navGraph, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        modifier2 = modifier;
        if ((i3 & 147) == 146) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            NavHost(navHostController2, navGraph2, modifier4, null, null, null, null, null, null, composerStartRestartGroup, i3 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, 504);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition NavHost$lambda$28$lambda$27(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition NavHost$lambda$30$lambda$29(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0114  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of NavHost that supports sizeTransform")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void NavHost(final NavHostController navHostController, final NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Composer composer, final int i, final int i2) {
        NavHostController navHostController2;
        int i3;
        NavGraph navGraph2;
        Modifier modifier2;
        int i4;
        Alignment topStart;
        int i5;
        Function1 function15;
        int i6;
        Function1 function16;
        Function1 function17;
        int i7;
        Function1 function18;
        Modifier modifier3;
        int i8;
        Function1 function19;
        Composer composer2;
        final Modifier modifier4;
        final Alignment alignment2;
        final Function1 function110;
        final Function1 function111;
        final Function1 function112;
        final Function1 function113;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1818191915);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavHost)P(5,3,4)430@17381L199:NavHost.kt#opm8kd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            navHostController2 = navHostController;
        } else {
            navHostController2 = navHostController;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(navHostController2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            navGraph2 = navGraph;
        } else {
            navGraph2 = navGraph;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(navGraph2) ? 32 : 16;
            }
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    topStart = alignment;
                    i3 |= composerStartRestartGroup.changed(topStart) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        function15 = function1;
                        i3 |= composerStartRestartGroup.changedInstance(function15) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 != 0) {
                        if ((196608 & i) == 0) {
                            function16 = function12;
                            i3 |= composerStartRestartGroup.changedInstance(function16) ? 131072 : 65536;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                function17 = function13;
                                int i10 = composerStartRestartGroup.changedInstance(function17) ? 1048576 : 524288;
                                i3 |= i10;
                            } else {
                                function17 = function13;
                            }
                            i3 |= i10;
                        } else {
                            function17 = function13;
                        }
                        if ((i & 12582912) == 0) {
                            i3 |= ((i2 & 128) == 0 && composerStartRestartGroup.changedInstance(function14)) ? 8388608 : 4194304;
                        }
                        int i11 = i3;
                        if ((i3 & 4793491) != 4793490 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "419@16926L50,422@17073L51");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    topStart = Alignment.INSTANCE.getTopStart();
                                }
                                if (i5 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 769272135, "CC(remember):NavHost.kt#9igjgp");
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda10
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return NavHostKt.NavHost$lambda$28$lambda$27((AnimatedContentTransitionScope) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    function15 = (Function1) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 769276840, "CC(remember):NavHost.kt#9igjgp");
                                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda12
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return NavHostKt.NavHost$lambda$30$lambda$29((AnimatedContentTransitionScope) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    function16 = (Function1) objRememberedValue2;
                                }
                                if ((i2 & 64) == 0) {
                                    i7 = i11 & (-3670017);
                                    function17 = function15;
                                } else {
                                    i7 = i11;
                                }
                                if ((i2 & 128) == 0) {
                                    modifier3 = companion;
                                    i8 = (-29360129) & i7;
                                    function19 = function16;
                                    function18 = function19;
                                    Function1 function114 = function17;
                                    Alignment alignment3 = topStart;
                                    Function1 function115 = function15;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1818191915, i8, -1, "androidx.navigation.compose.NavHost (NavHost.kt:429)");
                                    }
                                    composer2 = composerStartRestartGroup;
                                    NavHost(navHostController2, navGraph2, modifier3, alignment3, function115, function19, function114, function18, null, composer2, i8 & 33554430, 256);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier4 = modifier3;
                                    alignment2 = alignment3;
                                    function110 = function115;
                                    function111 = function19;
                                    function112 = function114;
                                    function113 = function18;
                                } else {
                                    function18 = function14;
                                    modifier3 = companion;
                                    i8 = i7;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                i8 = (i2 & 64) != 0 ? i11 & (-3670017) : i11;
                                if ((i2 & 128) != 0) {
                                    i8 &= -29360129;
                                }
                                function18 = function14;
                                modifier3 = modifier2;
                            }
                            function19 = function16;
                            Function1 function1142 = function17;
                            Alignment alignment32 = topStart;
                            Function1 function1152 = function15;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = composerStartRestartGroup;
                            NavHost(navHostController2, navGraph2, modifier3, alignment32, function1152, function19, function1142, function18, null, composer2, i8 & 33554430, 256);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            alignment2 = alignment32;
                            function110 = function1152;
                            function111 = function19;
                            function112 = function1142;
                            function113 = function18;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier2;
                            alignment2 = topStart;
                            function110 = function15;
                            function111 = function16;
                            function112 = function17;
                            function113 = function14;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavHostKt.NavHost$lambda$31(navHostController, navGraph, modifier4, alignment2, function110, function111, function112, function113, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                    function16 = function12;
                    if ((1572864 & i) == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    int i112 = i3;
                    if ((i3 & 4793491) != 4793490) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "419@16926L50,422@17073L51");
                        if ((i & 1) != 0) {
                            if (i9 == 0) {
                            }
                            if (i4 != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if ((i2 & 64) == 0) {
                            }
                            if ((i2 & 128) == 0) {
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function15 = function1;
                i6 = i2 & 32;
                if (i6 != 0) {
                }
                function16 = function12;
                if ((1572864 & i) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                int i1122 = i3;
                if ((i3 & 4793491) != 4793490) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            topStart = alignment;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function15 = function1;
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            function16 = function12;
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            int i11222 = i3;
            if ((i3 & 4793491) != 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        topStart = alignment;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function15 = function1;
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        function16 = function12;
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        int i112222 = i3;
        if ((i3 & 4793491) != 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition NavHost$lambda$33$lambda$32(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition NavHost$lambda$35$lambda$34(AnimatedContentTransitionScope animatedContentTransitionScope) {
        return EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0665  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0703  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0714  */
    /* JADX WARN: Removed duplicated region for block: B:304:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fb  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavHost(final NavHostController navHostController, final NavGraph navGraph, Modifier modifier, Alignment alignment, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function1, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function12, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function13, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function14, Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function15, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        Alignment alignment2;
        int i6;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function16;
        int i7;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function17;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function18;
        int i8;
        int i9;
        int i10;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function19;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function110;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function111;
        final Alignment alignment3;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function112;
        final Modifier modifier3;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function113;
        String str;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function114;
        int i11;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function115;
        ViewModelStoreOwner current;
        MutableFloatState mutableFloatState;
        MutableFloatState mutableFloatState2;
        final MutableState mutableState;
        Alignment alignment4;
        NavHostKt$NavHost$25$1 navHostKt$NavHost$25$1;
        final Alignment alignment5;
        final Modifier modifier4;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function116;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function117;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function118;
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function119;
        int i12;
        DialogNavigator dialogNavigator;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function120;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function121;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function122;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function123;
        Composer composer2;
        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function124;
        MutableState mutableState2;
        Object objRememberedValue;
        Transition transitionRememberTransition;
        DialogNavigator dialogNavigator2;
        int i13;
        boolean zChangedInstance;
        Object objRememberedValue2;
        MutableObjectFloatMap mutableObjectFloatMap;
        MutableState mutableState3;
        Object objRememberedValue3;
        boolean zChanged;
        NavHostKt$NavHost$33$1 navHostKt$NavHost$33$1RememberedValue;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1964664536);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavHost)P(5,3,4)490@19612L7,492@19696L7,507@20301L16,509@20339L36,510@20404L34,511@20492L1319,511@20443L1368,545@21850L138,545@21817L171,551@22020L29,553@22109L16,556@22214L186,566@22495L46,738@30904L27:NavHost.kt#opm8kd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(navGraph) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        alignment2 = alignment;
                        i3 |= composerStartRestartGroup.changed(alignment2) ? 2048 : 1024;
                    }
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            function16 = function1;
                            i3 |= composerStartRestartGroup.changedInstance(function16) ? 16384 : 8192;
                        }
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                        } else {
                            if ((196608 & i) == 0) {
                                function17 = function12;
                                i3 |= composerStartRestartGroup.changedInstance(function17) ? 131072 : 65536;
                            }
                            if ((i & 1572864) != 0) {
                                function18 = function13;
                                i3 |= ((i2 & 64) == 0 && composerStartRestartGroup.changedInstance(function18)) ? 1048576 : 524288;
                            } else {
                                function18 = function13;
                            }
                            if ((i & 12582912) == 0) {
                                i3 |= ((i2 & 128) == 0 && composerStartRestartGroup.changedInstance(function14)) ? 8388608 : 4194304;
                            }
                            i8 = i2 & 256;
                            if (i8 != 0) {
                                if ((i & 100663296) == 0) {
                                    i9 = i8;
                                    i3 |= composerStartRestartGroup.changedInstance(function15) ? 67108864 : 33554432;
                                }
                                i10 = i3;
                                if ((i3 & 38347923) != 38347922 || !composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "467@18831L58,473@19032L59");
                                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i4 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        Alignment topStart = i5 == 0 ? Alignment.INSTANCE.getTopStart() : alignment;
                                        if (i6 == 0) {
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743001538, "CC(remember):NavHost.kt#9igjgp");
                                            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue4 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda0
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return NavHostKt.NavHost$lambda$33$lambda$32((AnimatedContentTransitionScope) obj);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                            }
                                            function19 = (Function1) objRememberedValue4;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        } else {
                                            function19 = function16;
                                        }
                                        if (i7 == 0) {
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743007971, "CC(remember):NavHost.kt#9igjgp");
                                            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue5 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda24
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return NavHostKt.NavHost$lambda$35$lambda$34((AnimatedContentTransitionScope) obj);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                            }
                                            function110 = (Function1) objRememberedValue5;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        } else {
                                            function110 = function17;
                                        }
                                        if ((i2 & 64) != 0) {
                                            i10 &= -3670017;
                                            function18 = function19;
                                        }
                                        if ((i2 & 128) == 0) {
                                            i10 &= -29360129;
                                            function111 = function110;
                                        } else {
                                            function111 = function14;
                                        }
                                        alignment3 = topStart;
                                        function112 = function18;
                                        modifier3 = modifier2;
                                        function113 = function110;
                                        str = "CC(remember):NavHost.kt#9igjgp";
                                        function114 = function111;
                                        i11 = i10;
                                        if (i9 == 0) {
                                            function115 = null;
                                        }
                                        composerStartRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1964664536, i11, -1, "androidx.navigation.compose.NavHost (NavHost.kt:488)");
                                        }
                                        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(localLifecycleOwner);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        final LifecycleOwner lifecycleOwner = (LifecycleOwner) objConsume;
                                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                                        if (current == null) {
                                            throw new IllegalStateException("NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner".toString());
                                        }
                                        navHostController.setViewModelStore(current.getViewModelStore());
                                        navHostController.setGraph(navGraph);
                                        Navigator navigator = navHostController.getNavigatorProvider().getNavigator(ComposeNavigator.NAME);
                                        final ComposeNavigator composeNavigator = navigator instanceof ComposeNavigator ? (ComposeNavigator) navigator : null;
                                        if (composeNavigator == null) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                                            if (scopeUpdateScopeEndRestartGroup2 != null) {
                                                final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function125 = function112;
                                                scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda25
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(Object obj, Object obj2) {
                                                        return NavHostKt.NavHost$lambda$37(navHostController, navGraph, modifier3, alignment3, function19, function113, function125, function114, function115, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                                    }
                                                });
                                                return;
                                            }
                                            return;
                                        }
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function126 = function112;
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function127 = function19;
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function128 = function113;
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function129 = function114;
                                        final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function130 = function115;
                                        Modifier modifier5 = modifier3;
                                        State stateCollectAsState = SnapshotStateKt.collectAsState(composeNavigator.getBackStack(), null, composerStartRestartGroup, 0, 1);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743049772, str);
                                        Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue6 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                        }
                                        MutableFloatState mutableFloatState3 = (MutableFloatState) objRememberedValue6;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743051850, str);
                                        Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                            mutableFloatState = mutableFloatState3;
                                            objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                        } else {
                                            mutableFloatState = mutableFloatState3;
                                        }
                                        MutableState mutableState4 = (MutableState) objRememberedValue7;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        boolean z = NavHost$lambda$38(stateCollectAsState).size() > 1;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743055951, str);
                                        boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(composeNavigator);
                                        Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                        if (zChanged2 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                            mutableFloatState2 = mutableFloatState;
                                            mutableState = mutableState4;
                                            alignment4 = alignment3;
                                            navHostKt$NavHost$25$1 = new NavHostKt$NavHost$25$1(composeNavigator, stateCollectAsState, mutableFloatState, mutableState4, null);
                                            composerStartRestartGroup.updateRememberedValue(navHostKt$NavHost$25$1);
                                        } else {
                                            mutableFloatState2 = mutableFloatState;
                                            alignment4 = alignment3;
                                            navHostKt$NavHost$25$1 = objRememberedValue8;
                                            mutableState = mutableState4;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        int i14 = i11;
                                        NavComposeUtils_androidKt.PredictiveBackHandler(z, (Function2) navHostKt$NavHost$25$1, composerStartRestartGroup, 0, 0);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743098226, str);
                                        boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(navHostController) | composerStartRestartGroup.changedInstance(lifecycleOwner);
                                        Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                                        if (zChangedInstance2 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue9 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda26
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return NavHostKt.NavHost$lambda$48$lambda$47(navHostController, lifecycleOwner, (DisposableEffectScope) obj);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        EffectsKt.DisposableEffect(lifecycleOwner, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue9, composerStartRestartGroup, 0);
                                        final SaveableStateHolder saveableStateHolderRememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(composerStartRestartGroup, 0);
                                        final State stateCollectAsState2 = SnapshotStateKt.collectAsState(navHostController.getVisibleEntries(), null, composerStartRestartGroup, 0, 1);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743109922, str);
                                        Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue10 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda27
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return NavHostKt.NavHost$lambda$52$lambda$51(stateCollectAsState2);
                                                }
                                            });
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                        }
                                        final State state = (State) objRememberedValue10;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        final NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt.lastOrNull((List) NavHost$lambda$53(state));
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743118774, str);
                                        Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue11 = ObjectFloatMapKt.mutableObjectFloatMapOf();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                                        }
                                        final MutableObjectFloatMap mutableObjectFloatMap2 = (MutableObjectFloatMap) objRememberedValue11;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        if (navBackStackEntry != null) {
                                            composerStartRestartGroup.startReplaceGroup(-1797563167);
                                            ComposerKt.sourceInformation(composerStartRestartGroup, "569@22675L597,583@23370L597,599@24098L301,607@24432L146,607@24409L169,613@24610L348,620@24985L52,664@27129L1175,689@28361L9,690@28381L1465,662@27061L2785,717@29919L771,717@29855L835");
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743125085, str);
                                            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(composeNavigator) | ((((i14 & 3670016) ^ 1572864) > 1048576 && composerStartRestartGroup.changed(function126)) || (i14 & 1572864) == 1048576) | ((i14 & 57344) == 16384);
                                            Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance3 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue12 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda28
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return NavHostKt.NavHost$lambda$58$lambda$57(composeNavigator, function126, function127, mutableState, (AnimatedContentTransitionScope) obj);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                                            }
                                            final Function1 function131 = (Function1) objRememberedValue12;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743147325, str);
                                            function118 = function127;
                                            boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(composeNavigator) | ((((i14 & 29360128) ^ 12582912) > 8388608 && composerStartRestartGroup.changed(function129)) || (i14 & 12582912) == 8388608) | ((i14 & 458752) == 131072);
                                            Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance4 || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue13 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda29
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return NavHostKt.NavHost$lambda$62$lambda$61(composeNavigator, function129, function128, mutableState, (AnimatedContentTransitionScope) obj);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                                            }
                                            final Function1 function132 = (Function1) objRememberedValue13;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743170325, str);
                                            function116 = function129;
                                            boolean z2 = (i14 & 234881024) == 67108864;
                                            Object objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                                            if (z2 || objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue14 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return NavHostKt.NavHost$lambda$65$lambda$64(function130, (AnimatedContentTransitionScope) obj);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                                            }
                                            final Function1 function133 = (Function1) objRememberedValue14;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            function117 = function130;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743180858, str);
                                            boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(composeNavigator);
                                            Object objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance5) {
                                                mutableState2 = mutableState;
                                            } else {
                                                mutableState2 = mutableState;
                                                if (objRememberedValue15 == Composer.INSTANCE.getEmpty()) {
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                EffectsKt.DisposableEffect((Object) true, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue15, composerStartRestartGroup, 6);
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743186756, str);
                                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue = new SeekableTransitionState(navBackStackEntry);
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                                }
                                                final SeekableTransitionState seekableTransitionState = (SeekableTransitionState) objRememberedValue;
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                function119 = function126;
                                                transitionRememberTransition = TransitionKt.rememberTransition(seekableTransitionState, "entry", composerStartRestartGroup, SeekableTransitionState.$stable | 48, 0);
                                                if (!NavHost$lambda$43(mutableState2)) {
                                                    composerStartRestartGroup.startReplaceGroup(-1795329152);
                                                    ComposerKt.sourceInformation(composerStartRestartGroup, "623@25108L329,623@25083L354");
                                                    Float fValueOf = Float.valueOf(NavHost$lambda$40(mutableFloatState2));
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743202673, str);
                                                    boolean zChanged3 = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(seekableTransitionState);
                                                    NavHostKt$NavHost$28$1 navHostKt$NavHost$28$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                                    if (zChanged3 || navHostKt$NavHost$28$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                                        navHostKt$NavHost$28$1RememberedValue = new NavHostKt$NavHost$28$1(seekableTransitionState, stateCollectAsState, mutableFloatState2, null);
                                                        composerStartRestartGroup.updateRememberedValue(navHostKt$NavHost$28$1RememberedValue);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    EffectsKt.LaunchedEffect(fValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navHostKt$NavHost$28$1RememberedValue, composerStartRestartGroup, 0);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                    i13 = 0;
                                                    dialogNavigator2 = null;
                                                } else {
                                                    composerStartRestartGroup.startReplaceGroup(-1794910745);
                                                    ComposerKt.sourceInformation(composerStartRestartGroup, "631@25498L1532,631@25467L1563");
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743216356, str);
                                                    boolean zChangedInstance6 = composerStartRestartGroup.changedInstance(seekableTransitionState) | composerStartRestartGroup.changedInstance(navBackStackEntry) | composerStartRestartGroup.changed(transitionRememberTransition);
                                                    NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                                    if (zChangedInstance6 || navHostKt$NavHost$29$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                                        dialogNavigator2 = null;
                                                        navHostKt$NavHost$29$1RememberedValue = new NavHostKt$NavHost$29$1(seekableTransitionState, navBackStackEntry, transitionRememberTransition, null);
                                                        composerStartRestartGroup.updateRememberedValue(navHostKt$NavHost$29$1RememberedValue);
                                                    } else {
                                                        dialogNavigator2 = null;
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    i13 = 0;
                                                    EffectsKt.LaunchedEffect(navBackStackEntry, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navHostKt$NavHost$29$1RememberedValue, composerStartRestartGroup, 0);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                }
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743268191, str);
                                                zChangedInstance = composerStartRestartGroup.changedInstance(mutableObjectFloatMap2) | composerStartRestartGroup.changedInstance(composeNavigator) | composerStartRestartGroup.changed(function131) | composerStartRestartGroup.changed(function132) | composerStartRestartGroup.changed(function133);
                                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                                if (!zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    final MutableState mutableState5 = mutableState2;
                                                    final ComposeNavigator composeNavigator2 = composeNavigator;
                                                    objRememberedValue2 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            return NavHostKt.NavHost$lambda$75$lambda$74(mutableObjectFloatMap2, composeNavigator2, function131, function132, function133, state, mutableState5, (AnimatedContentTransitionScope) obj);
                                                        }
                                                    };
                                                    mutableObjectFloatMap = mutableObjectFloatMap2;
                                                    mutableState3 = mutableState5;
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                                } else {
                                                    mutableState3 = mutableState2;
                                                    mutableObjectFloatMap = mutableObjectFloatMap2;
                                                }
                                                Function1 function134 = (Function1) objRememberedValue2;
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743306449, str);
                                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue3 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda11
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            return ((NavBackStackEntry) obj).getId();
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                final MutableState mutableState6 = mutableState3;
                                                alignment5 = alignment4;
                                                i12 = i13;
                                                dialogNavigator = dialogNavigator2;
                                                AnimatedContentKt.AnimatedContent(transitionRememberTransition, modifier5, function134, alignment5, (Function1) objRememberedValue3, ComposableLambdaKt.rememberComposableLambda(820763100, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.32
                                                    @Override // kotlin.jvm.functions.Function4
                                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry2, Composer composer3, Integer num) {
                                                        invoke(animatedContentScope, navBackStackEntry2, composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(final AnimatedContentScope animatedContentScope, final NavBackStackEntry navBackStackEntry2, Composer composer3, int i15) {
                                                        Object objPrevious;
                                                        ComposerKt.sourceInformation(composer3, "C:NavHost.kt#opm8kd");
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(820763100, i15, -1, "androidx.navigation.compose.NavHost.<anonymous> (NavHost.kt:697)");
                                                        }
                                                        boolean zAreEqual = Intrinsics.areEqual(seekableTransitionState.getCurrentState(), navBackStackEntry);
                                                        if (!NavHostKt.NavHost$lambda$43(mutableState6) && !zAreEqual) {
                                                            List listNavHost$lambda$53 = NavHostKt.NavHost$lambda$53(state);
                                                            ListIterator listIterator = listNavHost$lambda$53.listIterator(listNavHost$lambda$53.size());
                                                            while (true) {
                                                                if (!listIterator.hasPrevious()) {
                                                                    objPrevious = null;
                                                                    break;
                                                                } else {
                                                                    objPrevious = listIterator.previous();
                                                                    if (Intrinsics.areEqual(navBackStackEntry2, (NavBackStackEntry) objPrevious)) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            navBackStackEntry2 = (NavBackStackEntry) objPrevious;
                                                        }
                                                        if (navBackStackEntry2 == null) {
                                                            composer3.startReplaceGroup(105930796);
                                                        } else {
                                                            composer3.startReplaceGroup(-1520603531);
                                                            ComposerKt.sourceInformation(composer3, "710@29660L176,710@29619L217");
                                                            NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry2, saveableStateHolderRememberSaveableStateHolder, ComposableLambdaKt.rememberComposableLambda(-1263531443, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.32.1
                                                                @Override // kotlin.jvm.functions.Function2
                                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                                    invoke(composer4, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Composer composer4, int i16) {
                                                                    ComposerKt.sourceInformation(composer4, "C711@29737L85:NavHost.kt#opm8kd");
                                                                    if ((i16 & 3) == 2 && composer4.getSkipping()) {
                                                                        composer4.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1263531443, i16, -1, "androidx.navigation.compose.NavHost.<anonymous>.<anonymous> (NavHost.kt:711)");
                                                                    }
                                                                    NavDestination destination = navBackStackEntry2.getDestination();
                                                                    Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                                                                    ((ComposeNavigator.Destination) destination).getContent$navigation_compose_release().invoke(animatedContentScope, navBackStackEntry2, composer4, 0);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }, composer3, 54), composer3, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                        }
                                                        composer3.endReplaceGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 3) & 112) | 221184 | (i14 & 7168), 0);
                                                modifier4 = modifier5;
                                                Object currentState = transitionRememberTransition.getCurrentState();
                                                Object targetState = transitionRememberTransition.getTargetState();
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743357067, str);
                                                zChanged = composerStartRestartGroup.changed(transitionRememberTransition) | composerStartRestartGroup.changedInstance(navHostController) | composerStartRestartGroup.changedInstance(navBackStackEntry) | composerStartRestartGroup.changedInstance(composeNavigator) | composerStartRestartGroup.changedInstance(mutableObjectFloatMap);
                                                navHostKt$NavHost$33$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (!zChanged || navHostKt$NavHost$33$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    navHostKt$NavHost$33$1RememberedValue = new NavHostKt$NavHost$33$1(transitionRememberTransition, navHostController, navBackStackEntry, mutableObjectFloatMap, state, composeNavigator, null);
                                                    composerStartRestartGroup.updateRememberedValue(navHostKt$NavHost$33$1RememberedValue);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                EffectsKt.LaunchedEffect(currentState, targetState, (Function2) navHostKt$NavHost$33$1RememberedValue, composerStartRestartGroup, i12);
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                            objRememberedValue15 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return NavHostKt.NavHost$lambda$69$lambda$68(state, composeNavigator, (DisposableEffectScope) obj);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            EffectsKt.DisposableEffect((Object) true, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue15, composerStartRestartGroup, 6);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743186756, str);
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            }
                                            final SeekableTransitionState<NavBackStackEntry> seekableTransitionState2 = (SeekableTransitionState) objRememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            function119 = function126;
                                            transitionRememberTransition = TransitionKt.rememberTransition(seekableTransitionState2, "entry", composerStartRestartGroup, SeekableTransitionState.$stable | 48, 0);
                                            if (!NavHost$lambda$43(mutableState2)) {
                                            }
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743268191, str);
                                            zChangedInstance = composerStartRestartGroup.changedInstance(mutableObjectFloatMap2) | composerStartRestartGroup.changedInstance(composeNavigator) | composerStartRestartGroup.changed(function131) | composerStartRestartGroup.changed(function132) | composerStartRestartGroup.changed(function133);
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (zChangedInstance) {
                                                final MutableState mutableState52 = mutableState2;
                                                final ComposeNavigator composeNavigator22 = composeNavigator;
                                                objRememberedValue2 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return NavHostKt.NavHost$lambda$75$lambda$74(mutableObjectFloatMap2, composeNavigator22, function131, function132, function133, state, mutableState52, (AnimatedContentTransitionScope) obj);
                                                    }
                                                };
                                                mutableObjectFloatMap = mutableObjectFloatMap2;
                                                mutableState3 = mutableState52;
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                                Function1 function1342 = (Function1) objRememberedValue2;
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743306449, str);
                                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                final MutableState<Boolean> mutableState62 = mutableState3;
                                                alignment5 = alignment4;
                                                i12 = i13;
                                                dialogNavigator = dialogNavigator2;
                                                AnimatedContentKt.AnimatedContent(transitionRememberTransition, modifier5, function1342, alignment5, (Function1) objRememberedValue3, ComposableLambdaKt.rememberComposableLambda(820763100, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.32
                                                    @Override // kotlin.jvm.functions.Function4
                                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry2, Composer composer3, Integer num) {
                                                        invoke(animatedContentScope, navBackStackEntry2, composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(final AnimatedContentScope animatedContentScope, final NavBackStackEntry navBackStackEntry2, Composer composer3, int i15) {
                                                        Object objPrevious;
                                                        ComposerKt.sourceInformation(composer3, "C:NavHost.kt#opm8kd");
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(820763100, i15, -1, "androidx.navigation.compose.NavHost.<anonymous> (NavHost.kt:697)");
                                                        }
                                                        boolean zAreEqual = Intrinsics.areEqual(seekableTransitionState2.getCurrentState(), navBackStackEntry);
                                                        if (!NavHostKt.NavHost$lambda$43(mutableState62) && !zAreEqual) {
                                                            List listNavHost$lambda$53 = NavHostKt.NavHost$lambda$53(state);
                                                            ListIterator listIterator = listNavHost$lambda$53.listIterator(listNavHost$lambda$53.size());
                                                            while (true) {
                                                                if (!listIterator.hasPrevious()) {
                                                                    objPrevious = null;
                                                                    break;
                                                                } else {
                                                                    objPrevious = listIterator.previous();
                                                                    if (Intrinsics.areEqual(navBackStackEntry2, (NavBackStackEntry) objPrevious)) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            navBackStackEntry2 = (NavBackStackEntry) objPrevious;
                                                        }
                                                        if (navBackStackEntry2 == null) {
                                                            composer3.startReplaceGroup(105930796);
                                                        } else {
                                                            composer3.startReplaceGroup(-1520603531);
                                                            ComposerKt.sourceInformation(composer3, "710@29660L176,710@29619L217");
                                                            NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry2, saveableStateHolderRememberSaveableStateHolder, ComposableLambdaKt.rememberComposableLambda(-1263531443, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavHostKt.NavHost.32.1
                                                                @Override // kotlin.jvm.functions.Function2
                                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                                    invoke(composer4, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Composer composer4, int i16) {
                                                                    ComposerKt.sourceInformation(composer4, "C711@29737L85:NavHost.kt#opm8kd");
                                                                    if ((i16 & 3) == 2 && composer4.getSkipping()) {
                                                                        composer4.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1263531443, i16, -1, "androidx.navigation.compose.NavHost.<anonymous>.<anonymous> (NavHost.kt:711)");
                                                                    }
                                                                    NavDestination destination = navBackStackEntry2.getDestination();
                                                                    Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
                                                                    ((ComposeNavigator.Destination) destination).getContent$navigation_compose_release().invoke(animatedContentScope, navBackStackEntry2, composer4, 0);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }, composer3, 54), composer3, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                        }
                                                        composer3.endReplaceGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 3) & 112) | 221184 | (i14 & 7168), 0);
                                                modifier4 = modifier5;
                                                Object currentState2 = transitionRememberTransition.getCurrentState();
                                                Object targetState2 = transitionRememberTransition.getTargetState();
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1743357067, str);
                                                zChanged = composerStartRestartGroup.changed(transitionRememberTransition) | composerStartRestartGroup.changedInstance(navHostController) | composerStartRestartGroup.changedInstance(navBackStackEntry) | composerStartRestartGroup.changedInstance(composeNavigator) | composerStartRestartGroup.changedInstance(mutableObjectFloatMap);
                                                navHostKt$NavHost$33$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                                if (!zChanged) {
                                                    navHostKt$NavHost$33$1RememberedValue = new NavHostKt$NavHost$33$1(transitionRememberTransition, navHostController, navBackStackEntry, mutableObjectFloatMap, state, composeNavigator, null);
                                                    composerStartRestartGroup.updateRememberedValue(navHostKt$NavHost$33$1RememberedValue);
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    EffectsKt.LaunchedEffect(currentState2, targetState2, (Function2) navHostKt$NavHost$33$1RememberedValue, composerStartRestartGroup, i12);
                                                    composerStartRestartGroup.endReplaceGroup();
                                                }
                                            }
                                        } else {
                                            alignment5 = alignment4;
                                            modifier4 = modifier5;
                                            function116 = function129;
                                            function117 = function130;
                                            function118 = function127;
                                            function119 = function126;
                                            i12 = 0;
                                            dialogNavigator = null;
                                            composerStartRestartGroup.startReplaceGroup(-1789758886);
                                            composerStartRestartGroup.endReplaceGroup();
                                        }
                                        Navigator navigator2 = navHostController.getNavigatorProvider().getNavigator("dialog");
                                        DialogNavigator dialogNavigator3 = navigator2 instanceof DialogNavigator ? (DialogNavigator) navigator2 : dialogNavigator;
                                        if (dialogNavigator3 == null) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            ScopeUpdateScope scopeUpdateScopeEndRestartGroup3 = composerStartRestartGroup.endRestartGroup();
                                            if (scopeUpdateScopeEndRestartGroup3 != null) {
                                                final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function135 = function118;
                                                final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> function136 = function116;
                                                final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> function137 = function117;
                                                final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function138 = function119;
                                                scopeUpdateScopeEndRestartGroup3.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda22
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(Object obj, Object obj2) {
                                                        return NavHostKt.NavHost$lambda$79(navHostController, navGraph, modifier4, alignment5, function135, function128, function138, function136, function137, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                                    }
                                                });
                                                return;
                                            }
                                            return;
                                        }
                                        function120 = function128;
                                        function121 = function118;
                                        function122 = function116;
                                        function123 = function117;
                                        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> function139 = function119;
                                        DialogHostKt.DialogHost(dialogNavigator3, composerStartRestartGroup, i12);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer2 = composerStartRestartGroup;
                                        function124 = function139;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i2 & 64) != 0) {
                                            i10 &= -3670017;
                                        }
                                        if ((i2 & 128) != 0) {
                                            i10 &= -29360129;
                                        }
                                        alignment3 = alignment;
                                        function114 = function14;
                                        function112 = function18;
                                        modifier3 = modifier2;
                                        function19 = function16;
                                        function113 = function17;
                                        i11 = i10;
                                        str = "CC(remember):NavHost.kt#9igjgp";
                                    }
                                    function115 = function15;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner2 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composerStartRestartGroup.consume(localLifecycleOwner2);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    final LifecycleOwner lifecycleOwner2 = (LifecycleOwner) objConsume2;
                                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                                    if (current == null) {
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    function122 = function14;
                                    composer2 = composerStartRestartGroup;
                                    alignment5 = alignment2;
                                    function121 = function16;
                                    function123 = function15;
                                    function124 = function18;
                                    modifier4 = modifier2;
                                    function120 = function17;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda23
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return NavHostKt.NavHost$lambda$80(navHostController, navGraph, modifier4, alignment5, function121, function120, function124, function122, function123, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i3 |= 100663296;
                            i9 = i8;
                            i10 = i3;
                            if ((i3 & 38347923) != 38347922) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "467@18831L58,473@19032L59");
                                if ((i & 1) != 0) {
                                    if (i4 != 0) {
                                    }
                                    if (i5 == 0) {
                                    }
                                    if (i6 == 0) {
                                    }
                                    if (i7 == 0) {
                                    }
                                    if ((i2 & 64) != 0) {
                                    }
                                    if ((i2 & 128) == 0) {
                                    }
                                    alignment3 = topStart;
                                    function112 = function18;
                                    modifier3 = modifier2;
                                    function113 = function110;
                                    str = "CC(remember):NavHost.kt#9igjgp";
                                    function114 = function111;
                                    i11 = i10;
                                    if (i9 == 0) {
                                        function115 = function15;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner22 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume22 = composerStartRestartGroup.consume(localLifecycleOwner22);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    final LifecycleOwner lifecycleOwner22 = (LifecycleOwner) objConsume22;
                                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                                    if (current == null) {
                                    }
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        function17 = function12;
                        if ((i & 1572864) != 0) {
                        }
                        if ((i & 12582912) == 0) {
                        }
                        i8 = i2 & 256;
                        if (i8 != 0) {
                        }
                        i9 = i8;
                        i10 = i3;
                        if ((i3 & 38347923) != 38347922) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    function16 = function1;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    function17 = function12;
                    if ((i & 1572864) != 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i8 = i2 & 256;
                    if (i8 != 0) {
                    }
                    i9 = i8;
                    i10 = i3;
                    if ((i3 & 38347923) != 38347922) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                alignment2 = alignment;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                function16 = function1;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                function17 = function12;
                if ((i & 1572864) != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                }
                i9 = i8;
                i10 = i3;
                if ((i3 & 38347923) != 38347922) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            alignment2 = alignment;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            function16 = function1;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            function17 = function12;
            if ((i & 1572864) != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i8 = i2 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i3;
            if ((i3 & 38347923) != 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        alignment2 = alignment;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        function16 = function1;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        function17 = function12;
        if ((i & 1572864) != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i8 = i2 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i3;
        if ((i3 & 38347923) != 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavHost$lambda$40(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NavHost$lambda$43(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavHost$lambda$44(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult NavHost$lambda$48$lambda$47(NavHostController navHostController, LifecycleOwner lifecycleOwner, DisposableEffectScope disposableEffectScope) {
        navHostController.setLifecycleOwner(lifecycleOwner);
        return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$lambda$48$lambda$47$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List NavHost$lambda$52$lambda$51(State state) {
        List<NavBackStackEntry> listNavHost$lambda$49 = NavHost$lambda$49(state);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listNavHost$lambda$49) {
            if (Intrinsics.areEqual(((NavBackStackEntry) obj).getDestination().getNavigatorName(), ComposeNavigator.NAME)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final EnterTransition NavHost$lambda$58$lambda$57(ComposeNavigator composeNavigator, Function1 function1, Function1 function12, MutableState mutableState, AnimatedContentTransitionScope animatedContentTransitionScope) {
        NavDestination destination = ((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) destination;
        EnterTransition enterTransition = null;
        if (composeNavigator.isPop$navigation_compose_release().getValue().booleanValue() || NavHost$lambda$43(mutableState)) {
            Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EnterTransition enterTransitionCreatePopEnterTransition = createPopEnterTransition(it.next(), animatedContentTransitionScope);
                if (enterTransitionCreatePopEnterTransition != null) {
                    enterTransition = enterTransitionCreatePopEnterTransition;
                    break;
                }
            }
            return enterTransition == null ? (EnterTransition) function1.invoke(animatedContentTransitionScope) : enterTransition;
        }
        Iterator<NavDestination> it2 = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            EnterTransition enterTransitionCreateEnterTransition = createEnterTransition(it2.next(), animatedContentTransitionScope);
            if (enterTransitionCreateEnterTransition != null) {
                enterTransition = enterTransitionCreateEnterTransition;
                break;
            }
        }
        return enterTransition == null ? (EnterTransition) function12.invoke(animatedContentTransitionScope) : enterTransition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ExitTransition NavHost$lambda$62$lambda$61(ComposeNavigator composeNavigator, Function1 function1, Function1 function12, MutableState mutableState, AnimatedContentTransitionScope animatedContentTransitionScope) {
        NavDestination destination = ((NavBackStackEntry) animatedContentTransitionScope.getInitialState()).getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) destination;
        ExitTransition exitTransition = null;
        if (composeNavigator.isPop$navigation_compose_release().getValue().booleanValue() || NavHost$lambda$43(mutableState)) {
            Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ExitTransition exitTransitionCreatePopExitTransition = createPopExitTransition(it.next(), animatedContentTransitionScope);
                if (exitTransitionCreatePopExitTransition != null) {
                    exitTransition = exitTransitionCreatePopExitTransition;
                    break;
                }
            }
            return exitTransition == null ? (ExitTransition) function1.invoke(animatedContentTransitionScope) : exitTransition;
        }
        Iterator<NavDestination> it2 = NavDestination.INSTANCE.getHierarchy(destination2).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            ExitTransition exitTransitionCreateExitTransition = createExitTransition(it2.next(), animatedContentTransitionScope);
            if (exitTransitionCreateExitTransition != null) {
                exitTransition = exitTransitionCreateExitTransition;
                break;
            }
        }
        return exitTransition == null ? (ExitTransition) function12.invoke(animatedContentTransitionScope) : exitTransition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final SizeTransform NavHost$lambda$65$lambda$64(Function1 function1, AnimatedContentTransitionScope animatedContentTransitionScope) {
        SizeTransform sizeTransformCreateSizeTransform;
        NavDestination destination = ((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).getDestination();
        Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.ComposeNavigator.Destination");
        Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy((ComposeNavigator.Destination) destination).iterator();
        while (true) {
            if (!it.hasNext()) {
                sizeTransformCreateSizeTransform = null;
                break;
            }
            sizeTransformCreateSizeTransform = createSizeTransform(it.next(), animatedContentTransitionScope);
            if (sizeTransformCreateSizeTransform != null) {
                break;
            }
        }
        if (sizeTransformCreateSizeTransform != null) {
            return sizeTransformCreateSizeTransform;
        }
        if (function1 != null) {
            return (SizeTransform) function1.invoke(animatedContentTransitionScope);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ContentTransform NavHost$lambda$75$lambda$74(MutableObjectFloatMap mutableObjectFloatMap, ComposeNavigator composeNavigator, Function1 function1, Function1 function12, Function1 function13, State state, MutableState mutableState, AnimatedContentTransitionScope animatedContentTransitionScope) {
        float f;
        if (NavHost$lambda$53(state).contains(animatedContentTransitionScope.getInitialState())) {
            String id = ((NavBackStackEntry) animatedContentTransitionScope.getInitialState()).getId();
            int iFindKeyIndex = mutableObjectFloatMap.findKeyIndex(id);
            if (iFindKeyIndex >= 0) {
                f = mutableObjectFloatMap.values[iFindKeyIndex];
            } else {
                mutableObjectFloatMap.set(id, 0.0f);
                f = 0.0f;
            }
            if (!Intrinsics.areEqual(((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).getId(), ((NavBackStackEntry) animatedContentTransitionScope.getInitialState()).getId())) {
                f = (composeNavigator.isPop$navigation_compose_release().getValue().booleanValue() || NavHost$lambda$43(mutableState)) ? f - 1.0f : f + 1.0f;
            }
            mutableObjectFloatMap.set(((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).getId(), f);
            return new ContentTransform((EnterTransition) function1.invoke(animatedContentTransitionScope), (ExitTransition) function12.invoke(animatedContentTransitionScope), f, (SizeTransform) function13.invoke(animatedContentTransitionScope));
        }
        return AnimatedContentKt.togetherWith(EnterTransition.INSTANCE.getNone(), ExitTransition.INSTANCE.getNone());
    }

    private static final EnterTransition createEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> enterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getEnterTransition$navigation_compose_release();
            if (enterTransition$navigation_compose_release2 != null) {
                return enterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (enterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getEnterTransition$navigation_compose_release()) == null) {
            return null;
        }
        return enterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    private static final ExitTransition createExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> exitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getExitTransition$navigation_compose_release();
            if (exitTransition$navigation_compose_release2 != null) {
                return exitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (exitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getExitTransition$navigation_compose_release()) == null) {
            return null;
        }
        return exitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    private static final EnterTransition createPopEnterTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> popEnterTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopEnterTransition$navigation_compose_release();
            if (popEnterTransition$navigation_compose_release2 != null) {
                return popEnterTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popEnterTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopEnterTransition$navigation_compose_release()) == null) {
            return null;
        }
        return popEnterTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    private static final ExitTransition createPopExitTransition(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> popExitTransition$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getPopExitTransition$navigation_compose_release();
            if (popExitTransition$navigation_compose_release2 != null) {
                return popExitTransition$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (popExitTransition$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getPopExitTransition$navigation_compose_release()) == null) {
            return null;
        }
        return popExitTransition$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    private static final SizeTransform createSizeTransform(NavDestination navDestination, AnimatedContentTransitionScope<NavBackStackEntry> animatedContentTransitionScope) {
        Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform$navigation_compose_release;
        if (navDestination instanceof ComposeNavigator.Destination) {
            Function1<AnimatedContentTransitionScope<NavBackStackEntry>, SizeTransform> sizeTransform$navigation_compose_release2 = ((ComposeNavigator.Destination) navDestination).getSizeTransform$navigation_compose_release();
            if (sizeTransform$navigation_compose_release2 != null) {
                return sizeTransform$navigation_compose_release2.invoke(animatedContentTransitionScope);
            }
            return null;
        }
        if (!(navDestination instanceof ComposeNavGraphNavigator.ComposeNavGraph) || (sizeTransform$navigation_compose_release = ((ComposeNavGraphNavigator.ComposeNavGraph) navDestination).getSizeTransform$navigation_compose_release()) == null) {
            return null;
        }
        return sizeTransform$navigation_compose_release.invoke(animatedContentTransitionScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$38(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    private static final List<NavBackStackEntry> NavHost$lambda$49(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<NavBackStackEntry> NavHost$lambda$53(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult NavHost$lambda$69$lambda$68(final State state, final ComposeNavigator composeNavigator, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.navigation.compose.NavHostKt$NavHost$lambda$69$lambda$68$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Iterator it = NavHostKt.NavHost$lambda$53(state).iterator();
                while (it.hasNext()) {
                    composeNavigator.onTransitionComplete((NavBackStackEntry) it.next());
                }
            }
        };
    }
}

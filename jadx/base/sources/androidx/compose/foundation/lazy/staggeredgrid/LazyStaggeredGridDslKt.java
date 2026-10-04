package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C2181C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u008c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0080\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u001f\u001a\u008c\u0001\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b%\u0010&\u001a\u0080\u0001\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b'\u0010(\u001a%\u0010)\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010*\u001aÐ\u0001\u0010+\u001a\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0-2%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010\u00162%\b\u0006\u00103\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u0001020\u00162%\b\n\u00104\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u00010\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0087\b¢\u0006\u0002\u0010:\u001a¤\u0002\u0010;\u001a\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0-2:\b\n\u0010.\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u0001072:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u000102072:\b\n\u00104\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u0001072H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0087\b¢\u0006\u0002\u0010?\u001aÐ\u0001\u0010+\u001a\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0@2%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010\u00162%\b\u0006\u00103\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u0001020\u00162%\b\n\u00104\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u00010\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0087\b¢\u0006\u0002\u0010A\u001a¤\u0002\u0010;\u001a\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0@2:\b\n\u0010.\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u0001072:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u000102072:\b\n\u00104\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u0001072H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0087\b¢\u0006\u0002\u0010B¨\u0006C"}, m1599d2 = {"LazyVerticalStaggeredGrid", "", "columns", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalItemSpacing", "Landroidx/compose/ui/unit/Dp;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyVerticalStaggeredGrid-6qCrX9Q", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "LazyVerticalStaggeredGrid-zadm560", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "LazyHorizontalStaggeredGrid", "rows", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalItemSpacing", "LazyHorizontalStaggeredGrid-121YqSk", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "LazyHorizontalStaggeredGrid-cJHQLPU", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberRowSlots", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", FirebaseAnalytics.Param.ITEMS, ExifInterface.GPS_DIRECTION_TRUE, "", SubscriberAttributeKt.JSON_NAME_KEY, "Lkotlin/ParameterName;", "name", "item", "", "contentType", TtmlNode.TAG_SPAN, "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LazyStaggeredGridDslKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyHorizontalStaggeredGrid_121YqSk$lambda$0(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, float f, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        m3119LazyHorizontalStaggeredGrid121YqSk(staggeredGridCells, modifier, lazyStaggeredGridState, paddingValues, z, vertical, f, flingBehavior, z2, overscrollEffect, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyHorizontalStaggeredGrid_cJHQLPU$lambda$0(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, float f, FlingBehavior flingBehavior, boolean z2, Function1 function1, int i, int i2, Composer composer, int i3) {
        m3120LazyHorizontalStaggeredGridcJHQLPU(staggeredGridCells, modifier, lazyStaggeredGridState, paddingValues, z, vertical, f, flingBehavior, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyVerticalStaggeredGrid_6qCrX9Q$lambda$0(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, float f, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        m3121LazyVerticalStaggeredGrid6qCrX9Q(staggeredGridCells, modifier, lazyStaggeredGridState, paddingValues, z, f, horizontal, flingBehavior, z2, overscrollEffect, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyVerticalStaggeredGrid_zadm560$lambda$0(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, float f, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, Function1 function1, int i, int i2, Composer composer, int i3) {
        m3122LazyVerticalStaggeredGridzadm560(staggeredGridCells, modifier, lazyStaggeredGridState, paddingValues, z, f, horizontal, flingBehavior, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0116  */
    /* JADX INFO: renamed from: LazyVerticalStaggeredGrid-6qCrX9Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3121LazyVerticalStaggeredGrid6qCrX9Q(final StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, float f, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        LazyStaggeredGridState lazyStaggeredGridState2;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        boolean z3;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final float f2;
        final boolean z4;
        final Modifier modifier3;
        final LazyStaggeredGridState lazyStaggeredGridState3;
        final PaddingValues paddingValues3;
        final boolean z5;
        final Arrangement.Horizontal horizontal2;
        final FlingBehavior flingBehavior2;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        LazyStaggeredGridState lazyStaggeredGridStateRememberLazyStaggeredGridState;
        PaddingValues paddingValuesM2847PaddingValues0680j_4;
        Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4;
        FlingBehavior flingBehavior3;
        OverscrollEffect overscrollEffectRememberOverscrollEffect;
        Modifier modifier4;
        LazyStaggeredGridState lazyStaggeredGridState4;
        float f3;
        FlingBehavior flingBehavior4;
        boolean z6;
        boolean z7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-578931208);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyVerticalStaggeredGrid)N(columns,modifier,state,contentPadding,reverseLayout,verticalItemSpacing:c#ui.unit.Dp,horizontalArrangement,flingBehavior,userScrollEnabled,overscrollEffect,content)93@4432L67,82@3985L548:LazyStaggeredGridDsl.kt#fzvcnm");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(staggeredGridCells) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i12 = i3 & 2;
        if (i12 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i3 & 4) == 0) {
                    lazyStaggeredGridState2 = lazyStaggeredGridState;
                    int i13 = composerStartRestartGroup.changed(lazyStaggeredGridState2) ? 256 : 128;
                    i4 |= i13;
                } else {
                    lazyStaggeredGridState2 = lazyStaggeredGridState;
                }
                i4 |= i13;
            } else {
                lazyStaggeredGridState2 = lazyStaggeredGridState;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    paddingValues2 = paddingValues;
                    i4 |= composerStartRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z;
                        i4 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                    } else if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                        i4 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i4 |= composerStartRestartGroup.changed(horizontal) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) == 0) {
                        i4 |= ((i3 & 128) == 0 && composerStartRestartGroup.changed(flingBehavior)) ? 8388608 : 4194304;
                    }
                    i9 = i3 & 256;
                    if (i9 != 0) {
                        if ((i & 100663296) == 0) {
                            i10 = i9;
                            i4 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                        }
                        if ((i & 805306368) == 0) {
                            i4 |= ((i3 & 512) == 0 && composerStartRestartGroup.changed(overscrollEffect)) ? 536870912 : 268435456;
                        }
                        if ((i2 & 6) == 0) {
                            i11 = i2 | (composerStartRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i11 = i2;
                        }
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "72@3506L32,77@3803L15,79@3901L26");
                            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                }
                                f3 = f;
                                flingBehavior4 = flingBehavior;
                                z6 = z2;
                                overscrollEffectRememberOverscrollEffect = overscrollEffect;
                                modifier4 = modifier2;
                                lazyStaggeredGridState4 = lazyStaggeredGridState2;
                                paddingValuesM2847PaddingValues0680j_4 = paddingValues2;
                                z7 = z3;
                                horizontalOrVerticalM2528spacedBy0680j_4 = horizontal;
                            } else {
                                Modifier.Companion companion = i12 != 0 ? Modifier.INSTANCE : modifier2;
                                if ((i3 & 4) != 0) {
                                    lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                    i4 &= -897;
                                } else {
                                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState2;
                                }
                                paddingValuesM2847PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : paddingValues2;
                                if (i6 != 0) {
                                    z3 = false;
                                }
                                float fM11017constructorimpl = i7 != 0 ? C1486Dp.m11017constructorimpl(0) : f;
                                horizontalOrVerticalM2528spacedBy0680j_4 = i8 != 0 ? Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(0)) : horizontal;
                                if ((i3 & 128) != 0) {
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i4 &= -29360129;
                                } else {
                                    flingBehavior3 = flingBehavior;
                                }
                                boolean z8 = i10 == 0 ? z2 : true;
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                    modifier4 = companion;
                                    overscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(composerStartRestartGroup, 0);
                                } else {
                                    overscrollEffectRememberOverscrollEffect = overscrollEffect;
                                    modifier4 = companion;
                                }
                                lazyStaggeredGridState4 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                                f3 = fM11017constructorimpl;
                                flingBehavior4 = flingBehavior3;
                                z6 = z8;
                                z7 = z3;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-578931208, i4, i11, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:81)");
                            }
                            int i14 = i4 >> 3;
                            int i15 = i4 << 3;
                            composer2 = composerStartRestartGroup;
                            PaddingValues paddingValues4 = paddingValuesM2847PaddingValues0680j_4;
                            LazyStaggeredGridKt.m3129LazyStaggeredGridw41Enmo(lazyStaggeredGridState4, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalOrVerticalM2528spacedBy0680j_4, paddingValuesM2847PaddingValues0680j_4, composerStartRestartGroup, (i4 & 14) | ((i4 >> 15) & 112) | (i14 & 896)), modifier4, paddingValues4, z7, flingBehavior4, z6, overscrollEffectRememberOverscrollEffect, f3, horizontalOrVerticalM2528spacedBy0680j_4.getSpacing(), function1, composer2, ((i4 >> 6) & 14) | 48 | ((i4 << 6) & 7168) | (57344 & i15) | (i15 & 458752) | (3670016 & i14) | (29360128 & i14) | (i14 & 234881024) | ((i4 << 12) & C2181C.ENCODING_PCM_DOUBLE), (i11 << 3) & 112, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            horizontal2 = horizontalOrVerticalM2528spacedBy0680j_4;
                            lazyStaggeredGridState3 = lazyStaggeredGridState4;
                            modifier3 = modifier4;
                            paddingValues3 = paddingValues4;
                            z5 = z7;
                            flingBehavior2 = flingBehavior4;
                            z4 = z6;
                            overscrollEffect2 = overscrollEffectRememberOverscrollEffect;
                            f2 = f3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            f2 = f;
                            z4 = z2;
                            modifier3 = modifier2;
                            lazyStaggeredGridState3 = lazyStaggeredGridState2;
                            paddingValues3 = paddingValues2;
                            z5 = z3;
                            horizontal2 = horizontal;
                            flingBehavior2 = flingBehavior;
                            overscrollEffect2 = overscrollEffect;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid_6qCrX9Q$lambda$0(staggeredGridCells, modifier3, lazyStaggeredGridState3, paddingValues3, z5, f2, horizontal2, flingBehavior2, z4, overscrollEffect2, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 100663296;
                    i10 = i9;
                    if ((i & 805306368) == 0) {
                    }
                    if ((i2 & 6) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z3 = z;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                }
                i10 = i9;
                if ((i & 805306368) == 0) {
                }
                if ((i2 & 6) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            paddingValues2 = paddingValues;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i9 = i3 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            if ((i & 805306368) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        paddingValues2 = paddingValues;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i9 = i3 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        if ((i & 805306368) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0116  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* JADX INFO: renamed from: LazyVerticalStaggeredGrid-zadm560, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3122LazyVerticalStaggeredGridzadm560(final StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, float f, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        LazyStaggeredGridState lazyStaggeredGridStateRememberLazyStaggeredGridState;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        boolean z3;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        Composer composer2;
        final Modifier modifier2;
        final FlingBehavior flingBehavior2;
        final LazyStaggeredGridState lazyStaggeredGridState2;
        final PaddingValues paddingValues3;
        final boolean z4;
        final float f3;
        final Arrangement.Horizontal horizontal2;
        final boolean z5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        FlingBehavior flingBehavior3;
        boolean z6;
        Modifier modifier3;
        LazyStaggeredGridState lazyStaggeredGridState3;
        PaddingValues paddingValues4;
        float f4;
        Arrangement.Horizontal horizontal3;
        boolean z7;
        FlingBehavior flingBehavior4;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(1695323794);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyVerticalStaggeredGrid)N(columns,modifier,state,contentPadding,reverseLayout,verticalItemSpacing:c#ui.unit.Dp,horizontalArrangement,flingBehavior,userScrollEnabled,content)122@5578L26,112@5173L465:LazyStaggeredGridDsl.kt#fzvcnm");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(staggeredGridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    int i12 = composerStartRestartGroup.changed(lazyStaggeredGridStateRememberLazyStaggeredGridState) ? 256 : 128;
                    i3 |= i12;
                } else {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                }
                i3 |= i12;
            } else {
                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    paddingValues2 = paddingValues;
                    i3 |= composerStartRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z;
                        i3 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                    } else {
                        if ((196608 & i) == 0) {
                            f2 = f;
                            i3 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
                        }
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changed(horizontal) ? 1048576 : 524288;
                        }
                        if ((i & 12582912) == 0) {
                            i3 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(flingBehavior)) ? 8388608 : 4194304;
                        }
                        i8 = i2 & 256;
                        if (i8 == 0) {
                            if ((i & 100663296) == 0) {
                                i9 = i8;
                                i3 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                            }
                            if ((i & 805306368) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                            }
                            if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "103@4764L32,108@5061L15");
                                if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i3 &= -29360129;
                                    }
                                    horizontal3 = horizontal;
                                    flingBehavior4 = flingBehavior;
                                    z6 = z2;
                                    lazyStaggeredGridState3 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                                    paddingValues4 = paddingValues2;
                                    z7 = z3;
                                    f4 = f2;
                                    i10 = 1695323794;
                                    modifier3 = modifier;
                                } else {
                                    Modifier.Companion companion = i11 != 0 ? Modifier.INSTANCE : modifier;
                                    if ((i2 & 4) != 0) {
                                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                        i3 &= -897;
                                    }
                                    PaddingValues paddingValuesM2847PaddingValues0680j_4 = i4 != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : paddingValues2;
                                    if (i5 != 0) {
                                        z3 = false;
                                    }
                                    float fM11017constructorimpl = i6 != 0 ? C1486Dp.m11017constructorimpl(0) : f2;
                                    Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = i7 != 0 ? Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(0)) : horizontal;
                                    if ((i2 & 128) != 0) {
                                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                        i3 &= -29360129;
                                    } else {
                                        flingBehavior3 = flingBehavior;
                                    }
                                    if (i9 != 0) {
                                        modifier3 = companion;
                                        lazyStaggeredGridState3 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                                        paddingValues4 = paddingValuesM2847PaddingValues0680j_4;
                                        horizontal3 = horizontalOrVerticalM2528spacedBy0680j_4;
                                        z7 = z3;
                                        flingBehavior4 = flingBehavior3;
                                        z6 = true;
                                        i10 = 1695323794;
                                        f4 = fM11017constructorimpl;
                                    } else {
                                        z6 = z2;
                                        modifier3 = companion;
                                        lazyStaggeredGridState3 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                                        paddingValues4 = paddingValuesM2847PaddingValues0680j_4;
                                        f4 = fM11017constructorimpl;
                                        horizontal3 = horizontalOrVerticalM2528spacedBy0680j_4;
                                        z7 = z3;
                                        flingBehavior4 = flingBehavior3;
                                        i10 = 1695323794;
                                    }
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i10, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:111)");
                                }
                                composer2 = composerStartRestartGroup;
                                m3121LazyVerticalStaggeredGrid6qCrX9Q(staggeredGridCells, modifier3, lazyStaggeredGridState3, paddingValues4, z7, f4, horizontal3, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(composerStartRestartGroup, 0), function1, composer2, i3 & 268435454, (i3 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                lazyStaggeredGridState2 = lazyStaggeredGridState3;
                                paddingValues3 = paddingValues4;
                                z4 = z7;
                                f3 = f4;
                                horizontal2 = horizontal3;
                                flingBehavior2 = flingBehavior4;
                                z5 = z6;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = modifier;
                                flingBehavior2 = flingBehavior;
                                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                                paddingValues3 = paddingValues2;
                                z4 = z3;
                                f3 = f2;
                                horizontal2 = horizontal;
                                z5 = z2;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid_zadm560$lambda$0(staggeredGridCells, modifier2, lazyStaggeredGridState2, paddingValues3, z4, f3, horizontal2, flingBehavior2, z5, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 100663296;
                        i9 = i8;
                        if ((i & 805306368) == 0) {
                        }
                        if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    f2 = f;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    if ((i & 805306368) == 0) {
                    }
                    if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z3 = z;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                f2 = f;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i & 805306368) == 0) {
                }
                if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            f2 = f;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i & 805306368) == 0) {
            }
            if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        paddingValues2 = paddingValues;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        f2 = f;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i & 805306368) == 0) {
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberColumnSlots(final StaggeredGridCells staggeredGridCells, final Arrangement.Horizontal horizontal, final PaddingValues paddingValues, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1267076841, "C(rememberColumnSlots)N(columns,horizontalArrangement,contentPadding)134@5881L1194:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1267076841, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnSlots (LazyStaggeredGridDsl.kt:134)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2109873921, "CC(remember):LazyStaggeredGridDsl.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(staggeredGridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i & 48) == 32) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(paddingValues)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        LazyStaggeredGridSlotCache lazyStaggeredGridSlotCacheRememberedValue = composer.rememberedValue();
        if (z || lazyStaggeredGridSlotCacheRememberedValue == Composer.INSTANCE.getEmpty()) {
            lazyStaggeredGridSlotCacheRememberedValue = new LazyStaggeredGridSlotCache(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazyStaggeredGridDslKt.rememberColumnSlots$lambda$0$0(paddingValues, staggeredGridCells, horizontal, (Density) obj, (Constraints) obj2);
                }
            });
            composer.updateRememberedValue(lazyStaggeredGridSlotCacheRememberedValue);
        }
        LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider = (LazyGridStaggeredGridSlotsProvider) lazyStaggeredGridSlotCacheRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridStaggeredGridSlotsProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyStaggeredGridSlots rememberColumnSlots$lambda$0$0(PaddingValues paddingValues, StaggeredGridCells staggeredGridCells, Arrangement.Horizontal horizontal, Density density, Constraints constraints) {
        if (!(Constraints.m10970getMaxWidthimpl(constraints.getValue()) != Integer.MAX_VALUE)) {
            InlineClassHelperKt.throwIllegalArgumentException("LazyVerticalStaggeredGrid's width should be bound by parent.");
        }
        int iM10970getMaxWidthimpl = Constraints.m10970getMaxWidthimpl(constraints.getValue()) - density.mo2185roundToPx0680j_4(C1486Dp.m11017constructorimpl(PaddingKt.calculateStartPadding(paddingValues, LayoutDirection.Ltr) + PaddingKt.calculateEndPadding(paddingValues, LayoutDirection.Ltr)));
        int[] iArrCalculateCrossAxisCellSizes = staggeredGridCells.calculateCrossAxisCellSizes(density, iM10970getMaxWidthimpl, density.mo2185roundToPx0680j_4(horizontal.getSpacing()));
        int[] iArr = new int[iArrCalculateCrossAxisCellSizes.length];
        horizontal.arrange(density, iM10970getMaxWidthimpl, iArrCalculateCrossAxisCellSizes, LayoutDirection.Ltr, iArr);
        return new LazyStaggeredGridSlots(iArr, iArrCalculateCrossAxisCellSizes);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0116  */
    /* JADX INFO: renamed from: LazyHorizontalStaggeredGrid-121YqSk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3119LazyHorizontalStaggeredGrid121YqSk(final StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, float f, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        LazyStaggeredGridState lazyStaggeredGridState2;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        boolean z3;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final Arrangement.Vertical vertical2;
        final boolean z4;
        final Modifier modifier3;
        final LazyStaggeredGridState lazyStaggeredGridState3;
        final PaddingValues paddingValues3;
        final boolean z5;
        final float f2;
        final FlingBehavior flingBehavior2;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        LazyStaggeredGridState lazyStaggeredGridStateRememberLazyStaggeredGridState;
        PaddingValues paddingValuesM2847PaddingValues0680j_4;
        Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4;
        FlingBehavior flingBehavior3;
        OverscrollEffect overscrollEffectRememberOverscrollEffect;
        Modifier modifier4;
        LazyStaggeredGridState lazyStaggeredGridState4;
        float f3;
        FlingBehavior flingBehavior4;
        boolean z6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-670735644);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyHorizontalStaggeredGrid)N(rows,modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalItemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,overscrollEffect,content)214@9926L59,203@9477L542:LazyStaggeredGridDsl.kt#fzvcnm");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(staggeredGridCells) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i12 = i3 & 2;
        if (i12 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i3 & 4) == 0) {
                    lazyStaggeredGridState2 = lazyStaggeredGridState;
                    int i13 = composerStartRestartGroup.changed(lazyStaggeredGridState2) ? 256 : 128;
                    i4 |= i13;
                } else {
                    lazyStaggeredGridState2 = lazyStaggeredGridState;
                }
                i4 |= i13;
            } else {
                lazyStaggeredGridState2 = lazyStaggeredGridState;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    paddingValues2 = paddingValues;
                    i4 |= composerStartRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z;
                        i4 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                    } else if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                        i4 |= composerStartRestartGroup.changed(vertical) ? 131072 : 65536;
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i4 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) == 0) {
                        i4 |= ((i3 & 128) == 0 && composerStartRestartGroup.changed(flingBehavior)) ? 8388608 : 4194304;
                    }
                    i9 = i3 & 256;
                    if (i9 != 0) {
                        if ((i & 100663296) == 0) {
                            i10 = i9;
                            i4 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                        }
                        if ((i & 805306368) == 0) {
                            i4 |= ((i3 & 512) == 0 && composerStartRestartGroup.changed(overscrollEffect)) ? 536870912 : 268435456;
                        }
                        if ((i2 & 6) == 0) {
                            i11 = i2 | (composerStartRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i11 = i2;
                        }
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "193@9000L32,198@9295L15,200@9393L26");
                            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                }
                                horizontalOrVerticalM2528spacedBy0680j_4 = vertical;
                                f3 = f;
                                flingBehavior4 = flingBehavior;
                                z6 = z2;
                                overscrollEffectRememberOverscrollEffect = overscrollEffect;
                                modifier4 = modifier2;
                                lazyStaggeredGridState4 = lazyStaggeredGridState2;
                                paddingValuesM2847PaddingValues0680j_4 = paddingValues2;
                            } else {
                                Modifier.Companion companion = i12 != 0 ? Modifier.INSTANCE : modifier2;
                                if ((i3 & 4) != 0) {
                                    lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                    i4 &= -897;
                                } else {
                                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState2;
                                }
                                paddingValuesM2847PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : paddingValues2;
                                if (i6 != 0) {
                                    z3 = false;
                                }
                                horizontalOrVerticalM2528spacedBy0680j_4 = i7 != 0 ? Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(0)) : vertical;
                                float fM11017constructorimpl = i8 != 0 ? C1486Dp.m11017constructorimpl(0) : f;
                                if ((i3 & 128) != 0) {
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i4 &= -29360129;
                                } else {
                                    flingBehavior3 = flingBehavior;
                                }
                                boolean z7 = i10 == 0 ? z2 : true;
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                    modifier4 = companion;
                                    overscrollEffectRememberOverscrollEffect = OverscrollKt.rememberOverscrollEffect(composerStartRestartGroup, 0);
                                } else {
                                    overscrollEffectRememberOverscrollEffect = overscrollEffect;
                                    modifier4 = companion;
                                }
                                lazyStaggeredGridState4 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                                f3 = fM11017constructorimpl;
                                flingBehavior4 = flingBehavior3;
                                z6 = z7;
                            }
                            boolean z8 = z3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-670735644, i4, i11, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:202)");
                            }
                            int i14 = i4 >> 3;
                            int i15 = i4 << 3;
                            composer2 = composerStartRestartGroup;
                            PaddingValues paddingValues4 = paddingValuesM2847PaddingValues0680j_4;
                            LazyStaggeredGridKt.m3129LazyStaggeredGridw41Enmo(lazyStaggeredGridState4, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, horizontalOrVerticalM2528spacedBy0680j_4, paddingValuesM2847PaddingValues0680j_4, composerStartRestartGroup, (i4 & 14) | ((i4 >> 12) & 112) | (i14 & 896)), modifier4, paddingValues4, z8, flingBehavior4, z6, overscrollEffectRememberOverscrollEffect, f3, horizontalOrVerticalM2528spacedBy0680j_4.getSpacing(), function1, composer2, ((i4 >> 6) & 14) | 48 | ((i4 << 6) & 7168) | (57344 & i15) | (i15 & 458752) | (3670016 & i14) | (29360128 & i14) | (i14 & 234881024) | ((i4 << 9) & C2181C.ENCODING_PCM_DOUBLE), (i11 << 3) & 112, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            vertical2 = horizontalOrVerticalM2528spacedBy0680j_4;
                            lazyStaggeredGridState3 = lazyStaggeredGridState4;
                            modifier3 = modifier4;
                            paddingValues3 = paddingValues4;
                            z5 = z8;
                            flingBehavior2 = flingBehavior4;
                            z4 = z6;
                            overscrollEffect2 = overscrollEffectRememberOverscrollEffect;
                            f2 = f3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            vertical2 = vertical;
                            z4 = z2;
                            modifier3 = modifier2;
                            lazyStaggeredGridState3 = lazyStaggeredGridState2;
                            paddingValues3 = paddingValues2;
                            z5 = z3;
                            f2 = f;
                            flingBehavior2 = flingBehavior;
                            overscrollEffect2 = overscrollEffect;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return LazyStaggeredGridDslKt.LazyHorizontalStaggeredGrid_121YqSk$lambda$0(staggeredGridCells, modifier3, lazyStaggeredGridState3, paddingValues3, z5, vertical2, f2, flingBehavior2, z4, overscrollEffect2, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 100663296;
                    i10 = i9;
                    if ((i & 805306368) == 0) {
                    }
                    if ((i2 & 6) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z3 = z;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                }
                i10 = i9;
                if ((i & 805306368) == 0) {
                }
                if ((i2 & 6) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            paddingValues2 = paddingValues;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i9 = i3 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            if ((i & 805306368) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        paddingValues2 = paddingValues;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i9 = i3 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        if ((i & 805306368) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0116  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* JADX INFO: renamed from: LazyHorizontalStaggeredGrid-cJHQLPU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3120LazyHorizontalStaggeredGridcJHQLPU(final StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, float f, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        LazyStaggeredGridState lazyStaggeredGridStateRememberLazyStaggeredGridState;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        boolean z3;
        int i6;
        Arrangement.Vertical vertical2;
        int i7;
        int i8;
        int i9;
        Composer composer2;
        final Modifier modifier2;
        final FlingBehavior flingBehavior2;
        final LazyStaggeredGridState lazyStaggeredGridState2;
        final PaddingValues paddingValues3;
        final boolean z4;
        final Arrangement.Vertical vertical3;
        final float f2;
        final boolean z5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        FlingBehavior flingBehavior3;
        boolean z6;
        Modifier modifier3;
        LazyStaggeredGridState lazyStaggeredGridState3;
        PaddingValues paddingValues4;
        Arrangement.Vertical vertical4;
        float f3;
        boolean z7;
        FlingBehavior flingBehavior4;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-8666074);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyHorizontalStaggeredGrid)N(rows,modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalItemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,content)243@11057L26,233@10656L461:LazyStaggeredGridDsl.kt#fzvcnm");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(staggeredGridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    int i12 = composerStartRestartGroup.changed(lazyStaggeredGridStateRememberLazyStaggeredGridState) ? 256 : 128;
                    i3 |= i12;
                } else {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                }
                i3 |= i12;
            } else {
                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    paddingValues2 = paddingValues;
                    i3 |= composerStartRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z;
                        i3 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                    } else {
                        if ((196608 & i) == 0) {
                            vertical2 = vertical;
                            i3 |= composerStartRestartGroup.changed(vertical2) ? 131072 : 65536;
                        }
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
                        }
                        if ((i & 12582912) == 0) {
                            i3 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(flingBehavior)) ? 8388608 : 4194304;
                        }
                        i8 = i2 & 256;
                        if (i8 == 0) {
                            if ((i & 100663296) == 0) {
                                i9 = i8;
                                i3 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                            }
                            if ((i & 805306368) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                            }
                            if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "224@10249L32,229@10544L15");
                                if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i3 &= -29360129;
                                    }
                                    f3 = f;
                                    flingBehavior4 = flingBehavior;
                                    z6 = z2;
                                    lazyStaggeredGridState3 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                                    paddingValues4 = paddingValues2;
                                    z7 = z3;
                                    vertical4 = vertical2;
                                    i10 = -8666074;
                                    modifier3 = modifier;
                                } else {
                                    Modifier.Companion companion = i11 != 0 ? Modifier.INSTANCE : modifier;
                                    if ((i2 & 4) != 0) {
                                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                        i3 &= -897;
                                    }
                                    PaddingValues paddingValuesM2847PaddingValues0680j_4 = i4 != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : paddingValues2;
                                    if (i5 != 0) {
                                        z3 = false;
                                    }
                                    Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = i6 != 0 ? Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(0)) : vertical2;
                                    float fM11017constructorimpl = i7 != 0 ? C1486Dp.m11017constructorimpl(0) : f;
                                    if ((i2 & 128) != 0) {
                                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                        i3 &= -29360129;
                                    } else {
                                        flingBehavior3 = flingBehavior;
                                    }
                                    if (i9 != 0) {
                                        modifier3 = companion;
                                        lazyStaggeredGridState3 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                                        paddingValues4 = paddingValuesM2847PaddingValues0680j_4;
                                        f3 = fM11017constructorimpl;
                                        z7 = z3;
                                        flingBehavior4 = flingBehavior3;
                                        z6 = true;
                                        i10 = -8666074;
                                        vertical4 = horizontalOrVerticalM2528spacedBy0680j_4;
                                    } else {
                                        z6 = z2;
                                        modifier3 = companion;
                                        lazyStaggeredGridState3 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                                        paddingValues4 = paddingValuesM2847PaddingValues0680j_4;
                                        vertical4 = horizontalOrVerticalM2528spacedBy0680j_4;
                                        f3 = fM11017constructorimpl;
                                        z7 = z3;
                                        flingBehavior4 = flingBehavior3;
                                        i10 = -8666074;
                                    }
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i10, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:232)");
                                }
                                composer2 = composerStartRestartGroup;
                                m3119LazyHorizontalStaggeredGrid121YqSk(staggeredGridCells, modifier3, lazyStaggeredGridState3, paddingValues4, z7, vertical4, f3, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(composerStartRestartGroup, 0), function1, composer2, i3 & 268435454, (i3 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                lazyStaggeredGridState2 = lazyStaggeredGridState3;
                                paddingValues3 = paddingValues4;
                                z4 = z7;
                                vertical3 = vertical4;
                                f2 = f3;
                                flingBehavior2 = flingBehavior4;
                                z5 = z6;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = modifier;
                                flingBehavior2 = flingBehavior;
                                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                                paddingValues3 = paddingValues2;
                                z4 = z3;
                                vertical3 = vertical2;
                                f2 = f;
                                z5 = z2;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return LazyStaggeredGridDslKt.LazyHorizontalStaggeredGrid_cJHQLPU$lambda$0(staggeredGridCells, modifier2, lazyStaggeredGridState2, paddingValues3, z4, vertical3, f2, flingBehavior2, z5, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 100663296;
                        i9 = i8;
                        if ((i & 805306368) == 0) {
                        }
                        if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    vertical2 = vertical;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    if ((i & 805306368) == 0) {
                    }
                    if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z3 = z;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                vertical2 = vertical;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i & 805306368) == 0) {
                }
                if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            vertical2 = vertical;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i & 805306368) == 0) {
            }
            if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        paddingValues2 = paddingValues;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        vertical2 = vertical;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i & 805306368) == 0) {
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberRowSlots(final StaggeredGridCells staggeredGridCells, final Arrangement.Vertical vertical, final PaddingValues paddingValues, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1532383053, "C(rememberRowSlots)N(rows,verticalArrangement,contentPadding)255@11347L956:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1532383053, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowSlots (LazyStaggeredGridDsl.kt:255)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 553674095, "CC(remember):LazyStaggeredGridDsl.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(staggeredGridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(vertical)) || (i & 48) == 32) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(paddingValues)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        LazyStaggeredGridSlotCache lazyStaggeredGridSlotCacheRememberedValue = composer.rememberedValue();
        if (z || lazyStaggeredGridSlotCacheRememberedValue == Composer.INSTANCE.getEmpty()) {
            lazyStaggeredGridSlotCacheRememberedValue = new LazyStaggeredGridSlotCache(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazyStaggeredGridDslKt.rememberRowSlots$lambda$0$0(paddingValues, staggeredGridCells, vertical, (Density) obj, (Constraints) obj2);
                }
            });
            composer.updateRememberedValue(lazyStaggeredGridSlotCacheRememberedValue);
        }
        LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider = (LazyGridStaggeredGridSlotsProvider) lazyStaggeredGridSlotCacheRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridStaggeredGridSlotsProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyStaggeredGridSlots rememberRowSlots$lambda$0$0(PaddingValues paddingValues, StaggeredGridCells staggeredGridCells, Arrangement.Vertical vertical, Density density, Constraints constraints) {
        if (!(Constraints.m10969getMaxHeightimpl(constraints.getValue()) != Integer.MAX_VALUE)) {
            InlineClassHelperKt.throwIllegalArgumentException("LazyHorizontalStaggeredGrid's height should be bound by parent.");
        }
        int iM10969getMaxHeightimpl = Constraints.m10969getMaxHeightimpl(constraints.getValue()) - density.mo2185roundToPx0680j_4(C1486Dp.m11017constructorimpl(paddingValues.getTop() + paddingValues.getBottom()));
        int[] iArrCalculateCrossAxisCellSizes = staggeredGridCells.calculateCrossAxisCellSizes(density, iM10969getMaxHeightimpl, density.mo2185roundToPx0680j_4(vertical.getSpacing()));
        int[] iArr = new int[iArrCalculateCrossAxisCellSizes.length];
        vertical.arrange(density, iM10969getMaxHeightimpl, iArrCalculateCrossAxisCellSizes, iArr);
        return new LazyStaggeredGridSlots(iArr, iArrCalculateCrossAxisCellSizes);
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function1 function1, Function1 function12, Function1 function13, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        lazyStaggeredGridScope.items(list.size(), function1 != null ? new LazyStaggeredGridDslKt$items$2$1(function1, list) : null, new C05973(function12, list), function13 != null ? new LazyStaggeredGridDslKt$items$4$1(function13, list) : null, ComposableLambdaKt.composableLambdaInstance(-334987442, true, new C05985(function4, list)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$3 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 176)
    public static final class C05973 implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C05973(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
            this.$contentType = function1;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int i) {
            return this.$contentType.invoke((T) this.$items.get(i));
        }
    }

    public static final <T> void items(LazyStaggeredGridScope lazyStaggeredGridScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function1<? super T, StaggeredGridItemSpan> function13, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyStaggeredGridScope.items(list.size(), function1 != null ? new LazyStaggeredGridDslKt$items$2$1(function1, list) : null, new C05973(function12, list), function13 != null ? new LazyStaggeredGridDslKt$items$4$1(function13, list) : null, ComposableLambdaKt.composableLambdaInstance(-334987442, true, new C05985(function4, list)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$5 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 176)
    public static final class C05985 implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyStaggeredGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C05985(Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, List<? extends T> list) {
            this.$itemContent = function4;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyStaggeredGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, int i, Composer composer, int i2) {
            int i3;
            ComposerKt.sourceInformation(composer, "CN(index)400@18558L25:LazyStaggeredGridDsl.kt#fzvcnm");
            if ((i2 & 6) == 0) {
                i3 = (composer.changed(lazyStaggeredGridItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-334987442, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.items.<anonymous> (LazyStaggeredGridDsl.kt:400)");
            }
            this.$itemContent.invoke(lazyStaggeredGridItemScope, (T) this.$items.get(i), composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function2 function2, Function2 function22, Function2 function23, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.1
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), obj3);
                }
            };
        }
        if ((i & 8) != 0) {
            function23 = null;
        }
        lazyStaggeredGridScope.items(list.size(), function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(function2, list) : null, new C06033(function22, list), function23 != null ? new LazyStaggeredGridDslKt$itemsIndexed$4$1(function23, list) : null, ComposableLambdaKt.composableLambdaInstance(-1466459515, true, new C06045(function5, list)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$3 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 176)
    public static final class C06033 implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C06033(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
            this.$contentType = function2;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int i) {
            return this.$contentType.invoke(Integer.valueOf(i), (T) this.$items.get(i));
        }
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope lazyStaggeredGridScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function23, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyStaggeredGridScope.items(list.size(), function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(function2, list) : null, new C06033(function22, list), function23 != null ? new LazyStaggeredGridDslKt$itemsIndexed$4$1(function23, list) : null, ComposableLambdaKt.composableLambdaInstance(-1466459515, true, new C06045(function5, list)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$5 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 176)
    public static final class C06045 implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyStaggeredGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C06045(Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, List<? extends T> list) {
            this.$itemContent = function5;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyStaggeredGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, int i, Composer composer, int i2) {
            int i3;
            ComposerKt.sourceInformation(composer, "CN(index)436@20481L32:LazyStaggeredGridDsl.kt#fzvcnm");
            if ((i2 & 6) == 0) {
                i3 = (composer.changed(lazyStaggeredGridItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1466459515, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed.<anonymous> (LazyStaggeredGridDsl.kt:436)");
            }
            this.$itemContent.invoke(lazyStaggeredGridItemScope, Integer.valueOf(i), (T) this.$items.get(i), composer, Integer.valueOf(i3 & WebSocketProtocol.PAYLOAD_SHORT));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function1 function1, Function1 function12, Function1 function13, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.6
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        lazyStaggeredGridScope.items(objArr.length, function1 != null ? new LazyStaggeredGridDslKt$items$7$1(function1, objArr) : null, new C06008(function12, objArr), function13 != null ? new LazyStaggeredGridDslKt$items$9$1(function13, objArr) : null, ComposableLambdaKt.composableLambdaInstance(-1775984467, true, new C059610(function4, objArr)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$8 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 176)
    public static final class C06008 implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C06008(Function1<? super T, ? extends Object> function1, T[] tArr) {
            this.$contentType = function1;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int i) {
            return this.$contentType.invoke(this.$items[i]);
        }
    }

    public static final <T> void items(LazyStaggeredGridScope lazyStaggeredGridScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function1<? super T, StaggeredGridItemSpan> function13, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyStaggeredGridScope.items(tArr.length, function1 != null ? new LazyStaggeredGridDslKt$items$7$1(function1, tArr) : null, new C06008(function12, tArr), function13 != null ? new LazyStaggeredGridDslKt$items$9$1(function13, tArr) : null, ComposableLambdaKt.composableLambdaInstance(-1775984467, true, new C059610(function4, tArr)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$10 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 176)
    public static final class C059610 implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyStaggeredGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C059610(Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
            this.$itemContent = function4;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyStaggeredGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, int i, Composer composer, int i2) {
            int i3;
            ComposerKt.sourceInformation(composer, "CN(index)472@22306L25:LazyStaggeredGridDsl.kt#fzvcnm");
            if ((i2 & 6) == 0) {
                i3 = (composer.changed(lazyStaggeredGridItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1775984467, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.items.<anonymous> (LazyStaggeredGridDsl.kt:472)");
            }
            this.$itemContent.invoke(lazyStaggeredGridItemScope, this.$items[i], composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function2 function2, Function2 function22, Function2 function23, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.6
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), obj3);
                }
            };
        }
        if ((i & 8) != 0) {
            function23 = null;
        }
        lazyStaggeredGridScope.items(objArr.length, function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(function2, objArr) : null, new C06068(function22, objArr), function23 != null ? new LazyStaggeredGridDslKt$itemsIndexed$9$1(function23, objArr) : null, ComposableLambdaKt.composableLambdaInstance(425846862, true, new C060210(function5, objArr)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$8 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 176)
    public static final class C06068 implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C06068(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
            this.$contentType = function2;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int i) {
            return this.$contentType.invoke(Integer.valueOf(i), this.$items[i]);
        }
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope lazyStaggeredGridScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function23, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyStaggeredGridScope.items(tArr.length, function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(function2, tArr) : null, new C06068(function22, tArr), function23 != null ? new LazyStaggeredGridDslKt$itemsIndexed$9$1(function23, tArr) : null, ComposableLambdaKt.composableLambdaInstance(425846862, true, new C060210(function5, tArr)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$10 */
    /* JADX INFO: compiled from: LazyStaggeredGridDsl.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 176)
    public static final class C060210 implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyStaggeredGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C060210(Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, T[] tArr) {
            this.$itemContent = function5;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyStaggeredGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, int i, Composer composer, int i2) {
            int i3;
            ComposerKt.sourceInformation(composer, "CN(index)508@24233L32:LazyStaggeredGridDsl.kt#fzvcnm");
            if ((i2 & 6) == 0) {
                i3 = (composer.changed(lazyStaggeredGridItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(425846862, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed.<anonymous> (LazyStaggeredGridDsl.kt:508)");
            }
            this.$itemContent.invoke(lazyStaggeredGridItemScope, Integer.valueOf(i), this.$items[i], composer, Integer.valueOf(i3 & WebSocketProtocol.PAYLOAD_SHORT));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}

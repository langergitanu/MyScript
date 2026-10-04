package coil.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.LayoutKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.common.C2181C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.compose.SubcomposeAsyncImageKt;
import coil.request.ImageRequest;
import coil.size.SizeResolver;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.purchase.NeboUserProfileManager;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubcomposeAsyncImage.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÓ\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2&\b\u0002\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'H\u0007¢\u0006\u0004\b(\u0010)\u001a©\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2&\b\u0002\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b*\u0010+\u001aÉ\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u001c\u0010-\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0004\b.\u0010/\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\u001c\u0010-\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0004\b0\u00101\u001a¥\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00102\u001a\u0002032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u001c\u0010-\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0004\b4\u00105\u001ae\u00106\u001a\u00020\u0001*\u00020\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0002\u00109\u001a[\u00106\u001a\u00020\u0001*\u00020\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0002\u0010:\u001a\u0095\u0001\u0010;\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0002\u0010<¨\u0006="}, m1599d2 = {"SubcomposeAsyncImage", "", NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, "", "contentDescription", "", "imageLoader", "Lcoil/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "loading", "Lkotlin/Function2;", "Lcoil/compose/SubcomposeAsyncImageScope;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", FirebaseAnalytics.Param.SUCCESS, "Lcoil/compose/AsyncImagePainter$State$Success;", "error", "Lcoil/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "modelEqualityDelegate", "Lcoil/compose/EqualityDelegate;", "SubcomposeAsyncImage-TCQMD7g", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLcoil/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;III)V", "SubcomposeAsyncImage-Q4Kwu38", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "onState", FirebaseAnalytics.Param.CONTENT, "SubcomposeAsyncImage-FSyRiR8", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLcoil/compose/EqualityDelegate;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SubcomposeAsyncImage-sKDTAoQ", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "state", "Lcoil/compose/AsyncImageState;", "SubcomposeAsyncImage-gl8XCv8", "(Lcoil/compose/AsyncImageState;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SubcomposeAsyncImageContent", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcoil/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLandroidx/compose/runtime/Composer;II)V", "(Lcoil/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "contentOf", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function3;", "coil-compose-base_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SubcomposeAsyncImageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubcomposeAsyncImageContent$lambda$3(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, int i, int i2, Composer composer, int i3) {
        SubcomposeAsyncImageContent(subcomposeAsyncImageScope, modifier, painter, str, alignment, contentScale, f, colorFilter, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubcomposeAsyncImageContent$lambda$4(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, int i2, Composer composer, int i3) {
        SubcomposeAsyncImageContent(subcomposeAsyncImageScope, modifier, painter, str, alignment, contentScale, f, colorFilter, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubcomposeAsyncImage_gl8XCv8$lambda$1(AsyncImageState asyncImageState, String str, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Function3 function3, int i2, int i3, int i4, Composer composer, int i5) {
        m12357SubcomposeAsyncImagegl8XCv8(asyncImageState, str, modifier, function1, function12, alignment, contentScale, f, colorFilter, i, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: SubcomposeAsyncImage-TCQMD7g, reason: not valid java name */
    public static final void m12356SubcomposeAsyncImageTCQMD7g(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43, Function1<? super AsyncImagePainter.State.Loading, Unit> function12, Function1<? super AsyncImagePainter.State.Success, Unit> function13, Function1<? super AsyncImagePainter.State.Error, Unit> function14, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-1545157471);
        Modifier.Companion companion = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function44 = (i4 & 32) != 0 ? null : function4;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function45 = (i4 & 64) != 0 ? null : function42;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function46 = (i4 & 128) != 0 ? null : function43;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function15 = (i4 & 256) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Success, Unit> function16 = (i4 & 512) != 0 ? null : function13;
        Function1<? super AsyncImagePainter.State.Error, Unit> function17 = (i4 & 1024) != 0 ? null : function14;
        Alignment center = (i4 & 2048) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 4096) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i4 & 8192) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 16384) == 0 ? colorFilter : null;
        int iM8732getDefaultFilterQualityfv9h1I = (32768 & i4) != 0 ? DrawScope.INSTANCE.m8732getDefaultFilterQualityfv9h1I() : i;
        boolean z2 = (65536 & i4) != 0 ? true : z;
        Modifier modifier2 = companion;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function18 = defaultTransform;
        AsyncImageState asyncImageState = new AsyncImageState(obj, (i4 & 131072) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader);
        Function1<AsyncImagePainter.State, Unit> function1OnStateOf = UtilsKt.onStateOf(function15, function16, function17);
        Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> function3ContentOf = contentOf(function44, function45, function46);
        int i5 = i2 >> 3;
        int i6 = (i2 & 112) | (i5 & 896) | (i5 & 7168);
        int i7 = i3 << 12;
        m12357SubcomposeAsyncImagegl8XCv8(asyncImageState, str, modifier2, function18, function1OnStateOf, center, fit, f2, colorFilter2, iM8732getDefaultFilterQualityfv9h1I, z2, function3ContentOf, composer, i6 | (458752 & i7) | (3670016 & i7) | (29360128 & i7) | (234881024 & i7) | (i7 & C2181C.ENCODING_PCM_DOUBLE), (i3 >> 18) & 14, 0);
        composer.endReplaceableGroup();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* JADX INFO: renamed from: SubcomposeAsyncImage-Q4Kwu38, reason: not valid java name */
    public static final /* synthetic */ void m12355SubcomposeAsyncImageQ4Kwu38(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function4 function4, Function4 function42, Function4 function43, Function1 function1, Function1 function12, Function1 function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-976228417);
        Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function4 function44 = (i4 & 16) != 0 ? null : function4;
        Function4 function45 = (i4 & 32) != 0 ? null : function42;
        Function4 function46 = (i4 & 64) != 0 ? null : function43;
        Function1 function14 = (i4 & 128) != 0 ? null : function1;
        Function1 function15 = (i4 & 256) != 0 ? null : function12;
        Function1 function16 = (i4 & 512) != 0 ? null : function13;
        Alignment center = (i4 & 1024) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 2048) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i4 & 4096) != 0 ? 1.0f : f;
        int i5 = i3 << 15;
        m12357SubcomposeAsyncImagegl8XCv8(new AsyncImageState(obj, EqualityDelegateKt.getDefaultModelEqualityDelegate(), imageLoader), str, modifier2, AsyncImagePainter.INSTANCE.getDefaultTransform(), UtilsKt.onStateOf(function14, function15, function16), center, fit, f2, (i4 & 8192) == 0 ? colorFilter : null, (i4 & 16384) != 0 ? DrawScope.INSTANCE.m8732getDefaultFilterQualityfv9h1I() : i, true, contentOf(function44, function45, function46), composer, (i2 & 112) | 3072 | ((i2 >> 3) & 896) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (i5 & C2181C.ENCODING_PCM_DOUBLE), 6, 0);
        composer.endReplaceableGroup();
    }

    /* JADX INFO: renamed from: SubcomposeAsyncImage-FSyRiR8, reason: not valid java name */
    public static final void m12354SubcomposeAsyncImageFSyRiR8(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, EqualityDelegate equalityDelegate, Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-105413282);
        int i5 = i2 >> 3;
        m12357SubcomposeAsyncImagegl8XCv8(new AsyncImageState(obj, (i4 & 4096) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader), str, (i4 & 8) != 0 ? Modifier.INSTANCE : modifier, (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1, (i4 & 32) != 0 ? null : function12, (i4 & 64) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i4 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale, (i4 & 256) != 0 ? 1.0f : f, (i4 & 512) != 0 ? null : colorFilter, (i4 & 1024) != 0 ? DrawScope.INSTANCE.m8732getDefaultFilterQualityfv9h1I() : i, (i4 & 2048) != 0 ? true : z, function3, composer, (i2 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (i5 & 234881024) | ((i3 << 27) & C2181C.ENCODING_PCM_DOUBLE), ((i3 >> 3) & 14) | ((i3 >> 6) & 112), 0);
        composer.endReplaceableGroup();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* JADX INFO: renamed from: SubcomposeAsyncImage-sKDTAoQ, reason: not valid java name */
    public static final /* synthetic */ void m12358SubcomposeAsyncImagesKDTAoQ(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Function3 function3, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(1166576943);
        int i5 = i2 >> 3;
        m12357SubcomposeAsyncImagegl8XCv8(new AsyncImageState(obj, EqualityDelegateKt.getDefaultModelEqualityDelegate(), imageLoader), str, (i4 & 8) != 0 ? Modifier.INSTANCE : modifier, (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1, (i4 & 32) != 0 ? null : function12, (i4 & 64) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i4 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale, (i4 & 256) != 0 ? 1.0f : f, (i4 & 512) != 0 ? null : colorFilter, (i4 & 1024) != 0 ? DrawScope.INSTANCE.m8732getDefaultFilterQualityfv9h1I() : i, true, function3, composer, (i2 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (i5 & 234881024) | ((i3 << 27) & C2181C.ENCODING_PCM_DOUBLE), (i3 & 112) | 6, 0);
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ff  */
    /* JADX INFO: renamed from: SubcomposeAsyncImage-gl8XCv8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m12357SubcomposeAsyncImagegl8XCv8(AsyncImageState asyncImageState, final String str, Modifier modifier, final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, final Function1<? super AsyncImagePainter.State, Unit> function12, final Alignment alignment, final ContentScale contentScale, final float f, final ColorFilter colorFilter, final int i, final boolean z, final Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3, final int i4) {
        AsyncImageState asyncImageState2;
        int i5;
        int i6;
        Modifier modifier2;
        int i7;
        int i8;
        int i9;
        final SizeResolver sizeResolver;
        Modifier modifier3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-605638725);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
            asyncImageState2 = asyncImageState;
        } else {
            asyncImageState2 = asyncImageState;
            if ((i2 & 14) == 0) {
                i5 = (composerStartRestartGroup.changed(asyncImageState2) ? 4 : 2) | i2;
            } else {
                i5 = i2;
            }
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else {
            if ((i2 & 112) == 0) {
                i5 |= composerStartRestartGroup.changed(str) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i2 & 896) == 0) {
                    modifier2 = modifier;
                    i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                }
                if ((i4 & 8) != 0) {
                    i5 |= 3072;
                } else {
                    if ((i2 & 7168) == 0) {
                        i5 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
                    }
                    if ((i4 & 16) == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 57344) == 0) {
                        i5 |= composerStartRestartGroup.changedInstance(function12) ? 16384 : 8192;
                    }
                    if ((i4 & 32) == 0) {
                        i7 = ProfileVerifier.CompilationStatus.f379xf2722a21;
                    } else {
                        if ((i2 & 458752) == 0) {
                            i7 = composerStartRestartGroup.changed(alignment) ? 131072 : 65536;
                        }
                        if ((i4 & 64) == 0) {
                            i10 = (i2 & 3670016) == 0 ? composerStartRestartGroup.changed(contentScale) ? 1048576 : 524288 : 1572864;
                            if ((i4 & 128) == 0) {
                                i5 |= 12582912;
                            } else {
                                if ((29360128 & i2) == 0) {
                                    i5 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
                                }
                                if ((i4 & 256) != 0) {
                                    i5 |= 100663296;
                                } else {
                                    if ((234881024 & i2) == 0) {
                                        i5 |= composerStartRestartGroup.changed(colorFilter) ? 67108864 : 33554432;
                                    }
                                    if ((i4 & 512) != 0) {
                                        if ((1879048192 & i2) == 0) {
                                            i5 |= composerStartRestartGroup.changed(i) ? 536870912 : 268435456;
                                        }
                                        i8 = i5;
                                        if ((i4 & 1024) != 0) {
                                            i9 = i3 | 6;
                                        } else if ((i3 & 14) == 0) {
                                            i9 = i3 | (composerStartRestartGroup.changed(z) ? 4 : 2);
                                        } else {
                                            i9 = i3;
                                        }
                                        if ((i4 & 2048) != 0) {
                                            i9 |= 48;
                                        } else if ((i3 & 112) == 0) {
                                            i9 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
                                        }
                                        if ((i8 & 1533916891) != 306783378 || (i9 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
                                            Modifier modifier5 = i6 == 0 ? Modifier.INSTANCE : modifier2;
                                            ImageRequest imageRequestRequestOfWithSizeResolver = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale, composerStartRestartGroup, ((i8 >> 15) & 112) | 8);
                                            int i11 = i8 >> 3;
                                            int i12 = i8 >> 6;
                                            int i13 = i8 >> 12;
                                            final AsyncImagePainter asyncImagePainterM12317rememberAsyncImagePainter0YpotYA = AsyncImagePainterKt.m12317rememberAsyncImagePainter0YpotYA(imageRequestRequestOfWithSizeResolver, asyncImageState2.getImageLoader(), function1, function12, contentScale, i, null, composerStartRestartGroup, (i11 & 7168) | (i11 & 896) | 72 | (i12 & 57344) | (i13 & 458752), 64);
                                            sizeResolver = imageRequestRequestOfWithSizeResolver.getSizeResolver();
                                            if (sizeResolver instanceof ConstraintsSizeResolver) {
                                                composerStartRestartGroup.startReplaceableGroup(-2080018031);
                                                int i14 = (i12 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | (i13 & 112);
                                                composerStartRestartGroup.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(alignment, true, composerStartRestartGroup, ((i14 >> 3) & 14) | 48);
                                                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier5);
                                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composerStartRestartGroup.startReusableNode();
                                                if (composerStartRestartGroup.getInserting()) {
                                                    composerStartRestartGroup.createNode(constructor);
                                                } else {
                                                    composerStartRestartGroup.useNode();
                                                }
                                                Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                                                Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                function3ModifierMaterializerOf.invoke(SkippableUpdater.m7218boximpl(SkippableUpdater.m7219constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                                                composerStartRestartGroup.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                function3.invoke(new RealSubcomposeAsyncImageScope(BoxScopeInstance.INSTANCE, asyncImagePainterM12317rememberAsyncImagePainter0YpotYA, str, alignment, contentScale, f, colorFilter, z), composerStartRestartGroup, Integer.valueOf(i9 & 112));
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                composerStartRestartGroup.endReplaceableGroup();
                                                composerStartRestartGroup.endNode();
                                                composerStartRestartGroup.endReplaceableGroup();
                                                composerStartRestartGroup.endReplaceableGroup();
                                                composerStartRestartGroup.endReplaceableGroup();
                                                composerStartRestartGroup = composerStartRestartGroup;
                                                modifier3 = modifier5;
                                            } else {
                                                composerStartRestartGroup.startReplaceableGroup(-2079329304);
                                                composerStartRestartGroup = composerStartRestartGroup;
                                                modifier3 = modifier5;
                                                BoxWithConstraintsKt.BoxWithConstraints(modifier3, alignment, true, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -888190719, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$2
                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                                                        invoke(boxWithConstraintsScope, composer2, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i15) {
                                                        if ((i15 & 14) == 0) {
                                                            i15 |= composer2.changed(boxWithConstraintsScope) ? 4 : 2;
                                                        }
                                                        if ((i15 & 91) != 18 || !composer2.getSkipping()) {
                                                            ((ConstraintsSizeResolver) sizeResolver).m12325setConstraintsBRTryo0(boxWithConstraintsScope.mo2555getConstraintsmsEJaDk());
                                                            function3.invoke(new RealSubcomposeAsyncImageScope(boxWithConstraintsScope, asyncImagePainterM12317rememberAsyncImagePainter0YpotYA, str, alignment, contentScale, f, colorFilter, z), composer2, 0);
                                                        } else {
                                                            composer2.skipToGroupEnd();
                                                        }
                                                    }
                                                }), composerStartRestartGroup, (i12 & 14) | 3456 | (i13 & 112), 0);
                                                composerStartRestartGroup.endReplaceableGroup();
                                            }
                                            modifier4 = modifier3;
                                        } else {
                                            composerStartRestartGroup.skipToGroupEnd();
                                            modifier4 = modifier2;
                                        }
                                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                        if (scopeUpdateScopeEndRestartGroup != null) {
                                            final AsyncImageState asyncImageState3 = asyncImageState2;
                                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: coil.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda2
                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(Object obj, Object obj2) {
                                                    return SubcomposeAsyncImageKt.SubcomposeAsyncImage_gl8XCv8$lambda$1(asyncImageState3, str, modifier4, function1, function12, alignment, contentScale, f, colorFilter, i, z, function3, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    i5 |= 805306368;
                                    i8 = i5;
                                    if ((i4 & 1024) != 0) {
                                    }
                                    if ((i4 & 2048) != 0) {
                                    }
                                    if ((i8 & 1533916891) != 306783378) {
                                        if (i6 == 0) {
                                        }
                                        ImageRequest imageRequestRequestOfWithSizeResolver2 = UtilsKt.requestOfWithSizeResolver(asyncImageState2.getModel(), contentScale, composerStartRestartGroup, ((i8 >> 15) & 112) | 8);
                                        int i112 = i8 >> 3;
                                        int i122 = i8 >> 6;
                                        int i132 = i8 >> 12;
                                        final AsyncImagePainter asyncImagePainterM12317rememberAsyncImagePainter0YpotYA2 = AsyncImagePainterKt.m12317rememberAsyncImagePainter0YpotYA(imageRequestRequestOfWithSizeResolver2, asyncImageState2.getImageLoader(), function1, function12, contentScale, i, null, composerStartRestartGroup, (i112 & 7168) | (i112 & 896) | 72 | (i122 & 57344) | (i132 & 458752), 64);
                                        sizeResolver = imageRequestRequestOfWithSizeResolver2.getSizeResolver();
                                        if (sizeResolver instanceof ConstraintsSizeResolver) {
                                        }
                                        modifier4 = modifier3;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup != null) {
                                    }
                                }
                                if ((i4 & 512) != 0) {
                                }
                                i8 = i5;
                                if ((i4 & 1024) != 0) {
                                }
                                if ((i4 & 2048) != 0) {
                                }
                                if ((i8 & 1533916891) != 306783378) {
                                }
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                }
                            }
                            if ((i4 & 256) != 0) {
                            }
                            if ((i4 & 512) != 0) {
                            }
                            i8 = i5;
                            if ((i4 & 1024) != 0) {
                            }
                            if ((i4 & 2048) != 0) {
                            }
                            if ((i8 & 1533916891) != 306783378) {
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i5 |= i10;
                        if ((i4 & 128) == 0) {
                        }
                        if ((i4 & 256) != 0) {
                        }
                        if ((i4 & 512) != 0) {
                        }
                        i8 = i5;
                        if ((i4 & 1024) != 0) {
                        }
                        if ((i4 & 2048) != 0) {
                        }
                        if ((i8 & 1533916891) != 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i5 |= i7;
                    if ((i4 & 64) == 0) {
                    }
                    i5 |= i10;
                    if ((i4 & 128) == 0) {
                    }
                    if ((i4 & 256) != 0) {
                    }
                    if ((i4 & 512) != 0) {
                    }
                    i8 = i5;
                    if ((i4 & 1024) != 0) {
                    }
                    if ((i4 & 2048) != 0) {
                    }
                    if ((i8 & 1533916891) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                if ((i4 & 16) == 0) {
                }
                if ((i4 & 32) == 0) {
                }
                i5 |= i7;
                if ((i4 & 64) == 0) {
                }
                i5 |= i10;
                if ((i4 & 128) == 0) {
                }
                if ((i4 & 256) != 0) {
                }
                if ((i4 & 512) != 0) {
                }
                i8 = i5;
                if ((i4 & 1024) != 0) {
                }
                if ((i4 & 2048) != 0) {
                }
                if ((i8 & 1533916891) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            if ((i4 & 8) != 0) {
            }
            if ((i4 & 16) == 0) {
            }
            if ((i4 & 32) == 0) {
            }
            i5 |= i7;
            if ((i4 & 64) == 0) {
            }
            i5 |= i10;
            if ((i4 & 128) == 0) {
            }
            if ((i4 & 256) != 0) {
            }
            if ((i4 & 512) != 0) {
            }
            i8 = i5;
            if ((i4 & 1024) != 0) {
            }
            if ((i4 & 2048) != 0) {
            }
            if ((i8 & 1533916891) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        modifier2 = modifier;
        if ((i4 & 8) != 0) {
        }
        if ((i4 & 16) == 0) {
        }
        if ((i4 & 32) == 0) {
        }
        i5 |= i7;
        if ((i4 & 64) == 0) {
        }
        i5 |= i10;
        if ((i4 & 128) == 0) {
        }
        if ((i4 & 256) != 0) {
        }
        if ((i4 & 512) != 0) {
        }
        i8 = i5;
        if ((i4 & 1024) != 0) {
        }
        if ((i4 & 2048) != 0) {
        }
        if ((i8 & 1533916891) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SubcomposeAsyncImageContent(final SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, Composer composer, final int i, final int i2) {
        SubcomposeAsyncImageScope subcomposeAsyncImageScope2;
        int i3;
        Modifier modifier2;
        int i4;
        String contentDescription;
        Alignment alignment2;
        ContentScale contentScale2;
        float alpha;
        ColorFilter colorFilter2;
        boolean clipToBounds;
        AsyncImagePainter painter2;
        int currentCompositeKeyHash;
        Composer composerM7248constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(880638523);
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
            subcomposeAsyncImageScope2 = subcomposeAsyncImageScope;
        } else if ((i & 14) == 0) {
            subcomposeAsyncImageScope2 = subcomposeAsyncImageScope;
            i3 = (composerStartRestartGroup.changed(subcomposeAsyncImageScope2) ? 4 : 2) | i;
        } else {
            subcomposeAsyncImageScope2 = subcomposeAsyncImageScope;
            i3 = i;
        }
        int i5 = i2 & 1;
        if (i5 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 2;
            if (i4 != 0) {
                i3 |= 128;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 4) == 0) {
                    contentDescription = str;
                    int i6 = composerStartRestartGroup.changed(contentDescription) ? 2048 : 1024;
                    i3 |= i6;
                } else {
                    contentDescription = str;
                }
                i3 |= i6;
            } else {
                contentDescription = str;
            }
            if ((57344 & i) != 0) {
                if ((i2 & 8) == 0) {
                    alignment2 = alignment;
                    int i7 = composerStartRestartGroup.changed(alignment2) ? 16384 : 8192;
                    i3 |= i7;
                } else {
                    alignment2 = alignment;
                }
                i3 |= i7;
            } else {
                alignment2 = alignment;
            }
            if ((458752 & i) != 0) {
                if ((i2 & 16) == 0) {
                    contentScale2 = contentScale;
                    int i8 = composerStartRestartGroup.changed(contentScale2) ? 131072 : 65536;
                    i3 |= i8;
                } else {
                    contentScale2 = contentScale;
                }
                i3 |= i8;
            } else {
                contentScale2 = contentScale;
            }
            if ((3670016 & i) != 0) {
                if ((i2 & 32) == 0) {
                    alpha = f;
                    int i9 = composerStartRestartGroup.changed(alpha) ? 1048576 : 524288;
                    i3 |= i9;
                } else {
                    alpha = f;
                }
                i3 |= i9;
            } else {
                alpha = f;
            }
            if ((29360128 & i) != 0) {
                if ((i2 & 64) == 0) {
                    colorFilter2 = colorFilter;
                    int i10 = composerStartRestartGroup.changed(colorFilter2) ? 8388608 : 4194304;
                    i3 |= i10;
                } else {
                    colorFilter2 = colorFilter;
                }
                i3 |= i10;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((234881024 & i) != 0) {
                if ((i2 & 128) == 0) {
                    clipToBounds = z;
                    int i11 = composerStartRestartGroup.changed(clipToBounds) ? 67108864 : 33554432;
                    i3 |= i11;
                } else {
                    clipToBounds = z;
                }
                i3 |= i11;
            } else {
                clipToBounds = z;
            }
            if (i4 == 2 || (191739611 & i3) != 38347922 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    painter2 = i4 == 0 ? subcomposeAsyncImageScope2.getPainter() : painter;
                    if ((i2 & 4) != 0) {
                        contentDescription = subcomposeAsyncImageScope2.getContentDescription();
                    }
                    if ((i2 & 8) != 0) {
                        alignment2 = subcomposeAsyncImageScope2.getAlignment();
                    }
                    if ((i2 & 16) != 0) {
                        contentScale2 = subcomposeAsyncImageScope2.getContentScale();
                    }
                    if ((i2 & 32) != 0) {
                        alpha = subcomposeAsyncImageScope2.getAlpha();
                    }
                    if ((i2 & 64) != 0) {
                        colorFilter2 = subcomposeAsyncImageScope2.getColorFilter();
                    }
                    if ((i2 & 128) != 0) {
                        clipToBounds = subcomposeAsyncImageScope2.getClipToBounds();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    painter2 = painter;
                }
                composerStartRestartGroup.endDefaults();
                Modifier modifierContentDescription = UtilsKt.contentDescription(modifier2, contentDescription);
                if (clipToBounds) {
                    modifierContentDescription = ClipKt.clipToBounds(modifierContentDescription);
                }
                painter = painter2;
                Modifier modifierThen = modifierContentDescription.then(new ContentPainterElement(painter, alignment2, contentScale2, alpha, colorFilter2));
                C38172 c38172 = C38172.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(544976794);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(1)123@4784L23,126@4935L385:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                final Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                composerStartRestartGroup.startReplaceableGroup(1405779621);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (!composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new Function0<ComposeUiNode>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$$inlined$Layout$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        public final ComposeUiNode invoke() {
                            return constructor.invoke();
                        }
                    });
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                Updater.m7256setimpl(composerM7248constructorimpl, c38172, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            final Painter painter3 = painter;
            final Modifier modifier3 = modifier2;
            final String str2 = contentDescription;
            final Alignment alignment3 = alignment2;
            final ContentScale contentScale3 = contentScale2;
            final float f2 = alpha;
            final ColorFilter colorFilter3 = colorFilter2;
            final boolean z2 = clipToBounds;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: coil.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SubcomposeAsyncImageKt.SubcomposeAsyncImageContent$lambda$3(subcomposeAsyncImageScope, modifier3, painter3, str2, alignment3, contentScale3, f2, colorFilter3, z2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 2;
        if (i4 != 0) {
        }
        if ((i & 7168) != 0) {
        }
        if ((57344 & i) != 0) {
        }
        if ((458752 & i) != 0) {
        }
        if ((3670016 & i) != 0) {
        }
        if ((29360128 & i) != 0) {
        }
        if ((234881024 & i) != 0) {
        }
        if (i4 == 2) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                composerStartRestartGroup.endDefaults();
                Modifier modifierContentDescription2 = UtilsKt.contentDescription(modifier2, contentDescription);
                if (clipToBounds) {
                }
                painter = painter2;
                Modifier modifierThen2 = modifierContentDescription2.then(new ContentPainterElement(painter, alignment2, contentScale2, alpha, colorFilter2));
                C38172 c381722 = C38172.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(544976794);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(1)123@4784L23,126@4935L385:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen2);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                final Function0 constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                composerStartRestartGroup.startReplaceableGroup(1405779621);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                }
                composerStartRestartGroup.startReusableNode();
                if (!composerStartRestartGroup.getInserting()) {
                }
                composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                Updater.m7256setimpl(composerM7248constructorimpl, c381722, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM7248constructorimpl.getInserting()) {
                    composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
            }
        }
        final Painter painter32 = painter;
        final Modifier modifier32 = modifier2;
        final String str22 = contentDescription;
        final Alignment alignment32 = alignment2;
        final ContentScale contentScale32 = contentScale2;
        final float f22 = alpha;
        final ColorFilter colorFilter32 = colorFilter2;
        final boolean z22 = clipToBounds;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: renamed from: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2 */
    /* JADX INFO: compiled from: SubcomposeAsyncImage.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    static final class C38172 implements MeasurePolicy {
        public static final C38172 INSTANCE = new C38172();

        C38172() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope placementScope) {
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.p004ui.layout.MeasurePolicy
        /* JADX INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo1747measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
            return MeasureScope.layout$default(measureScope, Constraints.m10972getMinWidthimpl(j), Constraints.m10971getMinHeightimpl(j), null, new Function1() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SubcomposeAsyncImageKt.C38172.measure_3p2s80s$lambda$0((Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void SubcomposeAsyncImageContent(final SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, final int i, final int i2) {
        SubcomposeAsyncImageScope subcomposeAsyncImageScope2;
        int i3;
        Modifier modifier2;
        int i4;
        String contentDescription;
        Alignment alignment2;
        ContentScale contentScale2;
        float alpha;
        int i5;
        ColorFilter colorFilter2;
        int i6;
        AsyncImagePainter painter2;
        Modifier modifier3;
        ColorFilter colorFilter3;
        int i7;
        int i8;
        ContentScale contentScale3;
        float f2;
        Painter painter3;
        Alignment alignment3;
        int i9;
        String str2;
        Composer composer2;
        final Modifier modifier4;
        final Painter painter4;
        final String str3;
        final Alignment alignment4;
        final ContentScale contentScale4;
        final float f3;
        final ColorFilter colorFilter4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-263982313);
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
            subcomposeAsyncImageScope2 = subcomposeAsyncImageScope;
        } else {
            subcomposeAsyncImageScope2 = subcomposeAsyncImageScope;
            if ((i & 14) == 0) {
                i3 = (composerStartRestartGroup.changed(subcomposeAsyncImageScope2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 1;
        if (i10 != 0) {
            i3 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 2;
            if (i4 != 0) {
                i3 |= 128;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 4) == 0) {
                    contentDescription = str;
                    int i11 = composerStartRestartGroup.changed(contentDescription) ? 2048 : 1024;
                    i3 |= i11;
                } else {
                    contentDescription = str;
                }
                i3 |= i11;
            } else {
                contentDescription = str;
            }
            if ((i & 57344) != 0) {
                if ((i2 & 8) == 0) {
                    alignment2 = alignment;
                    int i12 = composerStartRestartGroup.changed(alignment2) ? 16384 : 8192;
                    i3 |= i12;
                } else {
                    alignment2 = alignment;
                }
                i3 |= i12;
            } else {
                alignment2 = alignment;
            }
            if ((i & 458752) != 0) {
                if ((i2 & 16) == 0) {
                    contentScale2 = contentScale;
                    int i13 = composerStartRestartGroup.changed(contentScale2) ? 131072 : 65536;
                    i3 |= i13;
                } else {
                    contentScale2 = contentScale;
                }
                i3 |= i13;
            } else {
                contentScale2 = contentScale;
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 32) == 0) {
                    alpha = f;
                    int i14 = composerStartRestartGroup.changed(alpha) ? 1048576 : 524288;
                    i3 |= i14;
                } else {
                    alpha = f;
                }
                i3 |= i14;
            } else {
                alpha = f;
            }
            if ((i & 29360128) != 0) {
                i5 = 57344;
                colorFilter2 = colorFilter;
                i3 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(colorFilter2)) ? 8388608 : 4194304;
            } else {
                i5 = 57344;
                colorFilter2 = colorFilter;
            }
            if (i4 != 2) {
                i6 = 458752;
                if ((23967451 & i3) == 4793490 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    painter4 = painter;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier2;
                    str3 = contentDescription;
                    alignment4 = alignment2;
                    contentScale4 = contentScale2;
                    colorFilter4 = colorFilter2;
                    f3 = alpha;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: coil.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SubcomposeAsyncImageKt.SubcomposeAsyncImageContent$lambda$4(subcomposeAsyncImageScope, modifier4, painter4, str3, alignment4, contentScale4, f3, colorFilter4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i6 = 458752;
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                Modifier.Companion companion = i10 == 0 ? Modifier.INSTANCE : modifier2;
                if (i4 == 0) {
                    painter2 = subcomposeAsyncImageScope2.getPainter();
                    i3 &= -897;
                } else {
                    painter2 = painter;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -7169;
                    contentDescription = subcomposeAsyncImageScope2.getContentDescription();
                }
                if ((i2 & 8) != 0) {
                    i3 &= -57345;
                    alignment2 = subcomposeAsyncImageScope2.getAlignment();
                }
                if ((i2 & 16) != 0) {
                    i3 &= -458753;
                    contentScale2 = subcomposeAsyncImageScope2.getContentScale();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -3670017;
                    alpha = subcomposeAsyncImageScope2.getAlpha();
                }
                if ((i2 & 64) == 0) {
                    i3 &= -29360129;
                    modifier3 = companion;
                    colorFilter3 = subcomposeAsyncImageScope2.getColorFilter();
                } else {
                    modifier3 = companion;
                    colorFilter3 = colorFilter2;
                }
                i7 = 29360128;
                i8 = i6;
                contentScale3 = contentScale2;
                f2 = alpha;
                painter3 = painter2;
                alignment3 = alignment2;
                i9 = 3670016;
                str2 = contentDescription;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if (i4 != 0) {
                    i3 &= -897;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -7169;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -57345;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -458753;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -3670017;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -29360129;
                }
                modifier3 = modifier2;
                colorFilter3 = colorFilter2;
                i9 = 3670016;
                i7 = 29360128;
                i8 = i6;
                str2 = contentDescription;
                contentScale3 = contentScale2;
                f2 = alpha;
                painter3 = painter;
                alignment3 = alignment2;
            }
            composerStartRestartGroup.endDefaults();
            composer2 = composerStartRestartGroup;
            SubcomposeAsyncImageContent(subcomposeAsyncImageScope2, modifier3, painter3, str2, alignment3, contentScale3, f2, colorFilter3, false, composer2, (i9 & i3) | (i8 & i3) | (i3 & 14) | 512 | (i3 & 112) | (i3 & 7168) | (i3 & i5) | (i3 & i7), 128);
            modifier4 = modifier3;
            painter4 = painter3;
            str3 = str2;
            alignment4 = alignment3;
            contentScale4 = contentScale3;
            f3 = f2;
            colorFilter4 = colorFilter3;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 2;
        if (i4 != 0) {
        }
        if ((i & 7168) != 0) {
        }
        if ((i & 57344) != 0) {
        }
        if ((i & 458752) != 0) {
        }
        if ((i & 3670016) != 0) {
        }
        if ((i & 29360128) != 0) {
        }
        if (i4 != 2) {
        }
        composerStartRestartGroup.startDefaults();
        if ((i & 1) != 0) {
            if (i10 == 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) == 0) {
            }
            i7 = 29360128;
            i8 = i6;
            contentScale3 = contentScale2;
            f2 = alpha;
            painter3 = painter2;
            alignment3 = alignment2;
            i9 = 3670016;
            str2 = contentDescription;
            composerStartRestartGroup.endDefaults();
            composer2 = composerStartRestartGroup;
            SubcomposeAsyncImageContent(subcomposeAsyncImageScope2, modifier3, painter3, str2, alignment3, contentScale3, f2, colorFilter3, false, composer2, (i9 & i3) | (i8 & i3) | (i3 & 14) | 512 | (i3 & 112) | (i3 & 7168) | (i3 & i5) | (i3 & i7), 128);
            modifier4 = modifier3;
            painter4 = painter3;
            str3 = str2;
            alignment4 = alignment3;
            contentScale4 = contentScale3;
            f3 = f2;
            colorFilter4 = colorFilter3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf(final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43) {
        return (function4 == null && function42 == null && function43 == null) ? ComposableSingletons$SubcomposeAsyncImageKt.INSTANCE.m12324getLambda1$coil_compose_base_release() : ComposableLambdaKt.composableLambdaInstance(750771424, true, new Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt.contentOf.1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, Integer num) {
                invoke(subcomposeAsyncImageScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:43:0x009e  */
            /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, int i) {
                int i2;
                if ((i & 14) == 0) {
                    i2 = (composer.changed(subcomposeAsyncImageScope) ? 4 : 2) | i;
                } else {
                    i2 = i;
                }
                if ((i2 & 91) != 18 || !composer.getSkipping()) {
                    AsyncImagePainter.State state = subcomposeAsyncImageScope.getPainter().getState();
                    boolean z = false;
                    boolean z2 = true;
                    if (state instanceof AsyncImagePainter.State.Loading) {
                        composer.startReplaceableGroup(1739512213);
                        Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Loading, Composer, Integer, Unit> function44 = function4;
                        if (function44 != null) {
                            function44.invoke(subcomposeAsyncImageScope, (AsyncImagePainter.State.Loading) state, composer, Integer.valueOf((i2 & 14) | 64));
                            Unit unit = Unit.INSTANCE;
                        } else {
                            z = true;
                        }
                        composer.endReplaceableGroup();
                    } else if (state instanceof AsyncImagePainter.State.Success) {
                        composer.startReplaceableGroup(1739605461);
                        Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Success, Composer, Integer, Unit> function45 = function42;
                        if (function45 != null) {
                            function45.invoke(subcomposeAsyncImageScope, (AsyncImagePainter.State.Success) state, composer, Integer.valueOf((i2 & 14) | 64));
                            Unit unit2 = Unit.INSTANCE;
                        } else {
                            z = true;
                        }
                        composer.endReplaceableGroup();
                    } else {
                        if (!(state instanceof AsyncImagePainter.State.Error)) {
                            if (!(state instanceof AsyncImagePainter.State.Empty)) {
                                composer.startReplaceableGroup(-82435959);
                                composer.endReplaceableGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composer.startReplaceableGroup(1739782316);
                            composer.endReplaceableGroup();
                            if (z2) {
                                return;
                            }
                            SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, false, composer, i2 & 14, 255);
                            return;
                        }
                        composer.startReplaceableGroup(1739696601);
                        Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Error, Composer, Integer, Unit> function46 = function43;
                        if (function46 != null) {
                            function46.invoke(subcomposeAsyncImageScope, (AsyncImagePainter.State.Error) state, composer, Integer.valueOf((i2 & 14) | 64));
                            Unit unit3 = Unit.INSTANCE;
                        } else {
                            z = true;
                        }
                        composer.endReplaceableGroup();
                    }
                    z2 = z;
                    if (z2) {
                    }
                } else {
                    composer.skipToGroupEnd();
                }
            }
        });
    }
}

package coil.compose;

import android.graphics.drawable.Drawable;
import android.os.Trace;
import android.view.View;
import androidx.compose.p004ui.graphics.ImageBitmap;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.platform.InspectionModeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.size.Dimension;
import coil.size.Dimensions;
import coil.size.Size;
import coil.transition.TransitionTarget;
import com.myscript.nebo.purchase.NeboUserProfileManager;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: AsyncImagePainter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0081\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003*\u00015\u001a«\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a¡\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001am\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u000b2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001f\u0010 \u001ac\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u000b2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0004\b!\u0010\"\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u000b2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0004\b%\u0010&\u001a\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)H\u0002\u001a\u001a\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-H\u0002\u001a\u0015\u0010/\u001a\u0004\u0018\u000100*\u000201H\u0002¢\u0006\u0004\b2\u00103\"\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106¨\u00067"}, m1599d2 = {"rememberAsyncImagePainter", "Lcoil/compose/AsyncImagePainter;", NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, "", "imageLoader", "Lcoil/ImageLoader;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "modelEqualityDelegate", "Lcoil/compose/EqualityDelegate;", "rememberAsyncImagePainter-10Xjiaw", "(Ljava/lang/Object;Lcoil/ImageLoader;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILcoil/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;III)Lcoil/compose/AsyncImagePainter;", "rememberAsyncImagePainter-3HmZ8SU", "(Ljava/lang/Object;Lcoil/ImageLoader;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "transform", "Lcoil/compose/AsyncImagePainter$State;", "onState", "rememberAsyncImagePainter-0YpotYA", "(Ljava/lang/Object;Lcoil/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILcoil/compose/EqualityDelegate;Landroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "rememberAsyncImagePainter-5jETZwI", "(Ljava/lang/Object;Lcoil/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "state", "Lcoil/compose/AsyncImageState;", "rememberAsyncImagePainter-GSdzBsE", "(Lcoil/compose/AsyncImageState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;I)Lcoil/compose/AsyncImagePainter;", "validateRequest", "request", "Lcoil/request/ImageRequest;", "unsupportedData", "", "name", "", "description", "toSizeOrNull", "Lcoil/size/Size;", "Landroidx/compose/ui/geometry/Size;", "toSizeOrNull-uvyYCjk", "(J)Lcoil/size/Size;", "fakeTransitionTarget", "coil/compose/AsyncImagePainterKt$fakeTransitionTarget$1", "Lcoil/compose/AsyncImagePainterKt$fakeTransitionTarget$1;", "coil-compose-base_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class AsyncImagePainterKt {
    private static final AsyncImagePainterKt$fakeTransitionTarget$1 fakeTransitionTarget = new TransitionTarget() { // from class: coil.compose.AsyncImagePainterKt$fakeTransitionTarget$1
        @Override // coil.transition.TransitionTarget
        public Drawable getDrawable() {
            return null;
        }

        @Override // coil.transition.TransitionTarget
        public /* bridge */ /* synthetic */ View getView() {
            return (View) m12323getView();
        }

        /* JADX INFO: renamed from: getView, reason: collision with other method in class */
        public Void m12323getView() {
            throw new UnsupportedOperationException();
        }
    };

    /* JADX INFO: renamed from: rememberAsyncImagePainter-10Xjiaw, reason: not valid java name */
    public static final AsyncImagePainter m12318rememberAsyncImagePainter10Xjiaw(Object obj, ImageLoader imageLoader, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, ContentScale contentScale, int i, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3, int i4) {
        composer.startReplaceableGroup(-79978785);
        if ((i4 & 4) != 0) {
            painter = null;
        }
        if ((i4 & 8) != 0) {
            painter2 = null;
        }
        if ((i4 & 16) != 0) {
            painter3 = painter2;
        }
        AsyncImagePainter asyncImagePainterM12321rememberAsyncImagePainterGSdzBsE = m12321rememberAsyncImagePainterGSdzBsE(new AsyncImageState(obj, (i4 & 1024) != 0 ? EqualityDelegateKt.getDefaultModelEqualityDelegate() : equalityDelegate, imageLoader), UtilsKt.transformOf(painter, painter2, painter3), UtilsKt.onStateOf((i4 & 32) != 0 ? null : function1, (i4 & 64) != 0 ? null : function12, (i4 & 128) == 0 ? function13 : null), (i4 & 256) != 0 ? ContentScale.INSTANCE.getFit() : contentScale, (i4 & 512) != 0 ? DrawScope.INSTANCE.m8732getDefaultFilterQualityfv9h1I() : i, composer, (i2 >> 15) & 64512);
        composer.endReplaceableGroup();
        return asyncImagePainterM12321rememberAsyncImagePainterGSdzBsE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* JADX INFO: renamed from: rememberAsyncImagePainter-3HmZ8SU, reason: not valid java name */
    public static final /* synthetic */ AsyncImagePainter m12319rememberAsyncImagePainter3HmZ8SU(Object obj, ImageLoader imageLoader, Painter painter, Painter painter2, Painter painter3, Function1 function1, Function1 function12, Function1 function13, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(2140758544);
        if ((i3 & 4) != 0) {
            painter = null;
        }
        if ((i3 & 8) != 0) {
            painter2 = null;
        }
        if ((i3 & 16) != 0) {
            painter3 = painter2;
        }
        AsyncImagePainter asyncImagePainterM12321rememberAsyncImagePainterGSdzBsE = m12321rememberAsyncImagePainterGSdzBsE(new AsyncImageState(obj, EqualityDelegateKt.getDefaultModelEqualityDelegate(), imageLoader), UtilsKt.transformOf(painter, painter2, painter3), UtilsKt.onStateOf((i3 & 32) != 0 ? null : function1, (i3 & 64) != 0 ? null : function12, (i3 & 128) == 0 ? function13 : null), (i3 & 256) != 0 ? ContentScale.INSTANCE.getFit() : contentScale, (i3 & 512) != 0 ? DrawScope.INSTANCE.m8732getDefaultFilterQualityfv9h1I() : i, composer, (i2 >> 15) & 64512);
        composer.endReplaceableGroup();
        return asyncImagePainterM12321rememberAsyncImagePainterGSdzBsE;
    }

    /* JADX INFO: renamed from: rememberAsyncImagePainter-0YpotYA, reason: not valid java name */
    public static final AsyncImagePainter m12317rememberAsyncImagePainter0YpotYA(Object obj, ImageLoader imageLoader, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i, EqualityDelegate equalityDelegate, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(1645646697);
        if ((i3 & 4) != 0) {
            function1 = AsyncImagePainter.INSTANCE.getDefaultTransform();
        }
        if ((i3 & 8) != 0) {
            function12 = null;
        }
        if ((i3 & 16) != 0) {
            contentScale = ContentScale.INSTANCE.getFit();
        }
        if ((i3 & 32) != 0) {
            i = DrawScope.INSTANCE.m8732getDefaultFilterQualityfv9h1I();
        }
        if ((i3 & 64) != 0) {
            equalityDelegate = EqualityDelegateKt.getDefaultModelEqualityDelegate();
        }
        int i4 = i;
        ContentScale contentScale2 = contentScale;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function13 = function1;
        AsyncImagePainter asyncImagePainterM12321rememberAsyncImagePainterGSdzBsE = m12321rememberAsyncImagePainterGSdzBsE(new AsyncImageState(obj, equalityDelegate, imageLoader), function13, function12, contentScale2, i4, composer, (i2 >> 3) & 65520);
        composer.endReplaceableGroup();
        return asyncImagePainterM12321rememberAsyncImagePainterGSdzBsE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    /* JADX INFO: renamed from: rememberAsyncImagePainter-5jETZwI, reason: not valid java name */
    public static final /* synthetic */ AsyncImagePainter m12320rememberAsyncImagePainter5jETZwI(Object obj, ImageLoader imageLoader, Function1 function1, Function1 function12, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-2020614074);
        if ((i3 & 4) != 0) {
            function1 = AsyncImagePainter.INSTANCE.getDefaultTransform();
        }
        Function1 function13 = function1;
        if ((i3 & 8) != 0) {
            function12 = null;
        }
        Function1 function14 = function12;
        if ((i3 & 16) != 0) {
            contentScale = ContentScale.INSTANCE.getFit();
        }
        ContentScale contentScale2 = contentScale;
        if ((i3 & 32) != 0) {
            i = DrawScope.INSTANCE.m8732getDefaultFilterQualityfv9h1I();
        }
        AsyncImagePainter asyncImagePainterM12321rememberAsyncImagePainterGSdzBsE = m12321rememberAsyncImagePainterGSdzBsE(new AsyncImageState(obj, EqualityDelegateKt.getDefaultModelEqualityDelegate(), imageLoader), function13, function14, contentScale2, i, composer, (i2 >> 3) & 65520);
        composer.endReplaceableGroup();
        return asyncImagePainterM12321rememberAsyncImagePainterGSdzBsE;
    }

    /* JADX INFO: renamed from: rememberAsyncImagePainter-GSdzBsE, reason: not valid java name */
    private static final AsyncImagePainter m12321rememberAsyncImagePainterGSdzBsE(AsyncImageState asyncImageState, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i, Composer composer, int i2) {
        composer.startReplaceableGroup(952940650);
        Trace.beginSection("rememberAsyncImagePainter");
        try {
            ImageRequest imageRequestRequestOf = UtilsKt.requestOf(asyncImageState.getModel(), composer, 8);
            validateRequest(imageRequestRequestOf);
            composer.startReplaceableGroup(1094691773);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new AsyncImagePainter(imageRequestRequestOf, asyncImageState.getImageLoader());
                composer.updateRememberedValue(objRememberedValue);
            }
            AsyncImagePainter asyncImagePainter = (AsyncImagePainter) objRememberedValue;
            composer.endReplaceableGroup();
            asyncImagePainter.setTransform$coil_compose_base_release(function1);
            asyncImagePainter.setOnState$coil_compose_base_release(function12);
            asyncImagePainter.setContentScale$coil_compose_base_release(contentScale);
            asyncImagePainter.m12314setFilterQualityvDHp3xo$coil_compose_base_release(i);
            ProvidableCompositionLocal<Boolean> localInspectionMode = InspectionModeKt.getLocalInspectionMode();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localInspectionMode);
            ComposerKt.sourceInformationMarkerEnd(composer);
            asyncImagePainter.setPreview$coil_compose_base_release(((Boolean) objConsume).booleanValue());
            asyncImagePainter.setImageLoader$coil_compose_base_release(asyncImageState.getImageLoader());
            asyncImagePainter.setRequest$coil_compose_base_release(imageRequestRequestOf);
            asyncImagePainter.onRemembered();
            composer.endReplaceableGroup();
            return asyncImagePainter;
        } finally {
            Trace.endSection();
        }
    }

    private static final void validateRequest(ImageRequest imageRequest) {
        Object data = imageRequest.getData();
        if (data instanceof ImageRequest.Builder) {
            unsupportedData("ImageRequest.Builder", "Did you forget to call ImageRequest.Builder.build()?");
            throw new KotlinNothingValueException();
        }
        if (data instanceof ImageBitmap) {
            unsupportedData$default("ImageBitmap", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (data instanceof ImageVector) {
            unsupportedData$default("ImageVector", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (data instanceof Painter) {
            unsupportedData$default("Painter", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (imageRequest.getTarget() != null) {
            throw new IllegalArgumentException("request.target must be null.".toString());
        }
    }

    static /* synthetic */ Void unsupportedData$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "If you wish to display this " + str + ", use androidx.compose.foundation.Image.";
        }
        return unsupportedData(str, str2);
    }

    private static final Void unsupportedData(String str, String str2) {
        throw new IllegalArgumentException("Unsupported type: " + str + ". " + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toSizeOrNull-uvyYCjk, reason: not valid java name */
    public static final Size m12322toSizeOrNulluvyYCjk(long j) {
        if (j == androidx.compose.p004ui.geometry.Size.INSTANCE.m7980getUnspecifiedNHjbRc()) {
            return Size.ORIGINAL;
        }
        if (!UtilsKt.m12363isPositiveuvyYCjk(j)) {
            return null;
        }
        float fM7972getWidthimpl = androidx.compose.p004ui.geometry.Size.m7972getWidthimpl(j);
        Dimension Dimension = (Float.isInfinite(fM7972getWidthimpl) || Float.isNaN(fM7972getWidthimpl)) ? Dimension.Undefined.INSTANCE : Dimensions.Dimension(MathKt.roundToInt(androidx.compose.p004ui.geometry.Size.m7972getWidthimpl(j)));
        float fM7969getHeightimpl = androidx.compose.p004ui.geometry.Size.m7969getHeightimpl(j);
        return new Size(Dimension, (Float.isInfinite(fM7969getHeightimpl) || Float.isNaN(fM7969getHeightimpl)) ? Dimension.Undefined.INSTANCE : Dimensions.Dimension(MathKt.roundToInt(androidx.compose.p004ui.geometry.Size.m7969getHeightimpl(j))));
    }
}

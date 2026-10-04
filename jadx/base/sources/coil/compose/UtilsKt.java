package coil.compose;

import android.content.Context;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.semantics.Role;
import androidx.compose.p004ui.semantics.SemanticsModifierKt;
import androidx.compose.p004ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.request.NullRequestDataException;
import coil.size.Dimension;
import coil.size.Dimensions;
import coil.size.Scale;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.size.SizeResolvers;
import com.myscript.nebo.purchase.NeboUserProfileManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a2\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0001\u001aX\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nH\u0001\u001a\u0016\u0010\u0018\u001a\u00020\u0019*\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u001aH\u0001\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u0007H\u0001\u001a\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e*\u00020\u001fH\u0001¢\u0006\u0004\b \u0010!\u001a\u001b\u0010\"\u001a\u00020#*\u00020\u001f2\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b%\u0010&\u001a\u001b\u0010'\u001a\u00020#*\u00020\u001f2\u0006\u0010(\u001a\u00020#H\u0000¢\u0006\u0004\b)\u0010&\u001a\u001b\u0010*\u001a\u00020#*\u00020#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020#0,H\u0080\b\u001a\u0013\u0010-\u001a\u00020.*\u00020/H\u0000¢\u0006\u0004\b0\u00101\"\u0018\u00102\u001a\u000203*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u00105\"\u0016\u00106\u001a\u00020\u001fX\u0080\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108\"\u0014\u0010:\u001a\u00020;X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006>"}, m1599d2 = {"requestOf", "Lcoil/request/ImageRequest;", NeboUserProfileManager.CUSTOM_ATTRIBUTE_OEM_MODEL_KEY, "", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Lcoil/request/ImageRequest;", "requestOfWithSizeResolver", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "(Ljava/lang/Object;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;I)Lcoil/request/ImageRequest;", "transformOf", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onStateOf", "", "onLoading", "Lcoil/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "contentDescription", "Landroidx/compose/ui/Modifier;", "", "toScale", "Lcoil/size/Scale;", "toSizeOrNull", "Lcoil/size/Size;", "Landroidx/compose/ui/unit/Constraints;", "toSizeOrNull-BRTryo0", "(J)Lcoil/size/Size;", "constrainWidth", "", "width", "constrainWidth-K40F9xA", "(JF)F", "constrainHeight", "height", "constrainHeight-K40F9xA", "takeOrElse", "block", "Lkotlin/Function0;", "toIntSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/geometry/Size;", "toIntSize-uvyYCjk", "(J)J", "isPositive", "", "isPositive-uvyYCjk", "(J)Z", "ZeroConstraints", "getZeroConstraints", "()J", "J", "OriginalSizeResolver", "Lcoil/size/SizeResolver;", "getOriginalSizeResolver", "()Lcoil/size/SizeResolver;", "coil-compose-base_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class UtilsKt {
    private static final long ZeroConstraints = Constraints.INSTANCE.m10980fixedJhjzzOo(0, 0);
    private static final SizeResolver OriginalSizeResolver = SizeResolvers.create(Size.ORIGINAL);

    public static final ImageRequest requestOf(Object obj, Composer composer, int i) {
        composer.startReplaceableGroup(1087186730);
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            composer.endReplaceableGroup();
            return imageRequest;
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        composer.startReplaceableGroup(-1245195153);
        boolean zChanged = composer.changed(context) | composer.changed(obj);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new ImageRequest.Builder(context).data(obj).build();
            composer.updateRememberedValue(objRememberedValue);
        }
        ImageRequest imageRequest2 = (ImageRequest) objRememberedValue;
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return imageRequest2;
    }

    public static final ImageRequest requestOfWithSizeResolver(Object obj, ContentScale contentScale, Composer composer, int i) {
        ConstraintsSizeResolver constraintsSizeResolver;
        composer.startReplaceableGroup(1677680258);
        boolean z = obj instanceof ImageRequest;
        if (z) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (imageRequest.getDefined().getSizeResolver() != null) {
                composer.endReplaceableGroup();
                return imageRequest;
            }
        }
        composer.startReplaceableGroup(408306591);
        if (Intrinsics.areEqual(contentScale, ContentScale.INSTANCE.getNone())) {
            constraintsSizeResolver = OriginalSizeResolver;
        } else {
            composer.startReplaceableGroup(408309406);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new ConstraintsSizeResolver();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            constraintsSizeResolver = (ConstraintsSizeResolver) objRememberedValue;
        }
        composer.endReplaceableGroup();
        if (z) {
            composer.startReplaceableGroup(-227230258);
            ImageRequest imageRequest2 = (ImageRequest) obj;
            composer.startReplaceableGroup(408312509);
            boolean zChanged = composer.changed(imageRequest2) | composer.changed(constraintsSizeResolver);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = ImageRequest.newBuilder$default(imageRequest2, null, 1, null).size(constraintsSizeResolver).build();
                composer.updateRememberedValue(objRememberedValue2);
            }
            ImageRequest imageRequest3 = (ImageRequest) objRememberedValue2;
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            return imageRequest3;
        }
        composer.startReplaceableGroup(-227066702);
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        composer.startReplaceableGroup(408319118);
        boolean zChanged2 = composer.changed(context) | composer.changed(obj) | composer.changed(constraintsSizeResolver);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new ImageRequest.Builder(context).data(obj).size(constraintsSizeResolver).build();
            composer.updateRememberedValue(objRememberedValue3);
        }
        ImageRequest imageRequest4 = (ImageRequest) objRememberedValue3;
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return imageRequest4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncImagePainter.State transformOf$lambda$4(Painter painter, Painter painter2, Painter painter3, AsyncImagePainter.State state) {
        if (state instanceof AsyncImagePainter.State.Loading) {
            return painter != null ? ((AsyncImagePainter.State.Loading) state).copy(painter) : (AsyncImagePainter.State.Loading) state;
        }
        if (!(state instanceof AsyncImagePainter.State.Error)) {
            return state;
        }
        AsyncImagePainter.State.Error errorCopy$default = (AsyncImagePainter.State.Error) state;
        if (errorCopy$default.getResult().getThrowable() instanceof NullRequestDataException) {
            if (painter2 != null) {
                errorCopy$default = AsyncImagePainter.State.Error.copy$default(errorCopy$default, painter2, null, 2, null);
            }
        } else if (painter3 != null) {
            errorCopy$default = AsyncImagePainter.State.Error.copy$default(errorCopy$default, painter3, null, 2, null);
        }
        return errorCopy$default;
    }

    public static final Function1<AsyncImagePainter.State, AsyncImagePainter.State> transformOf(final Painter painter, final Painter painter2, final Painter painter3) {
        if (painter != null || painter2 != null || painter3 != null) {
            return new Function1() { // from class: coil.compose.UtilsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UtilsKt.transformOf$lambda$4(painter, painter3, painter2, (AsyncImagePainter.State) obj);
                }
            };
        }
        return AsyncImagePainter.INSTANCE.getDefaultTransform();
    }

    public static final Function1<AsyncImagePainter.State, Unit> onStateOf(final Function1<? super AsyncImagePainter.State.Loading, Unit> function1, final Function1<? super AsyncImagePainter.State.Success, Unit> function12, final Function1<? super AsyncImagePainter.State.Error, Unit> function13) {
        if (function1 == null && function12 == null && function13 == null) {
            return null;
        }
        return new Function1() { // from class: coil.compose.UtilsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UtilsKt.onStateOf$lambda$5(function1, function12, function13, (AsyncImagePainter.State) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStateOf$lambda$5(Function1 function1, Function1 function12, Function1 function13, AsyncImagePainter.State state) {
        if (state instanceof AsyncImagePainter.State.Loading) {
            if (function1 != null) {
                function1.invoke(state);
            }
        } else if (state instanceof AsyncImagePainter.State.Success) {
            if (function12 != null) {
                function12.invoke(state);
            }
        } else if (state instanceof AsyncImagePainter.State.Error) {
            if (function13 != null) {
                function13.invoke(state);
            }
        } else if (!(state instanceof AsyncImagePainter.State.Empty)) {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    public static final Modifier contentDescription(Modifier modifier, final String str) {
        return str != null ? SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: coil.compose.UtilsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UtilsKt.contentDescription$lambda$6(str, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contentDescription$lambda$6(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.m10212setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m10197getImageo7Vup1c());
        return Unit.INSTANCE;
    }

    public static final Scale toScale(ContentScale contentScale) {
        if (Intrinsics.areEqual(contentScale, ContentScale.INSTANCE.getFit()) || Intrinsics.areEqual(contentScale, ContentScale.INSTANCE.getInside())) {
            return Scale.FIT;
        }
        return Scale.FILL;
    }

    /* JADX INFO: renamed from: toSizeOrNull-BRTryo0, reason: not valid java name */
    public static final Size m12365toSizeOrNullBRTryo0(long j) {
        if (Constraints.m10974isZeroimpl(j)) {
            return null;
        }
        return new Size(Constraints.m10966getHasBoundedWidthimpl(j) ? Dimensions.Dimension(Constraints.m10970getMaxWidthimpl(j)) : Dimension.Undefined.INSTANCE, Constraints.m10965getHasBoundedHeightimpl(j) ? Dimensions.Dimension(Constraints.m10969getMaxHeightimpl(j)) : Dimension.Undefined.INSTANCE);
    }

    /* JADX INFO: renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final float m12362constrainWidthK40F9xA(long j, float f) {
        return RangesKt.coerceIn(f, Constraints.m10972getMinWidthimpl(j), Constraints.m10970getMaxWidthimpl(j));
    }

    /* JADX INFO: renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final float m12361constrainHeightK40F9xA(long j, float f) {
        return RangesKt.coerceIn(f, Constraints.m10971getMinHeightimpl(j), Constraints.m10969getMaxHeightimpl(j));
    }

    public static final float takeOrElse(float f, Function0<Float> function0) {
        return (Float.isInfinite(f) || Float.isNaN(f)) ? function0.invoke().floatValue() : f;
    }

    /* JADX INFO: renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m12364toIntSizeuvyYCjk(long j) {
        return IntSizeKt.IntSize(MathKt.roundToInt(androidx.compose.p004ui.geometry.Size.m7972getWidthimpl(j)), MathKt.roundToInt(androidx.compose.p004ui.geometry.Size.m7969getHeightimpl(j)));
    }

    /* JADX INFO: renamed from: isPositive-uvyYCjk, reason: not valid java name */
    public static final boolean m12363isPositiveuvyYCjk(long j) {
        return ((double) androidx.compose.p004ui.geometry.Size.m7972getWidthimpl(j)) >= 0.5d && ((double) androidx.compose.p004ui.geometry.Size.m7969getHeightimpl(j)) >= 0.5d;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final SizeResolver getOriginalSizeResolver() {
        return OriginalSizeResolver;
    }
}

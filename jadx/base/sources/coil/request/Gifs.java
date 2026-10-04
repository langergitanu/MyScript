package coil.request;

import coil.decode.GifDecoder;
import coil.request.ImageRequest;
import coil.transform.AnimatedTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Gifs.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002\u001a\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0002*\u00020\u0003¢\u0006\u0002\u0010\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0003H\u0007\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u001a\u0012\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t*\u00020\u0003\u001a\u001a\u0010\f\u001a\u00020\u0001*\u00020\u00012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u001a\u0012\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t*\u00020\u0003¨\u0006\u000e"}, m1599d2 = {"repeatCount", "Lcoil/request/ImageRequest$Builder;", "", "Lcoil/request/Parameters;", "(Lcoil/request/Parameters;)Ljava/lang/Integer;", "animatedTransformation", "Lcoil/transform/AnimatedTransformation;", "onAnimationStart", "callback", "Lkotlin/Function0;", "", "animationStartCallback", "onAnimationEnd", "animationEndCallback", "coil-gif_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class Gifs {
    public static final ImageRequest.Builder repeatCount(ImageRequest.Builder builder, int i) {
        if (i < -1) {
            throw new IllegalArgumentException(("Invalid repeatCount: " + i).toString());
        }
        return ImageRequest.Builder.setParameter$default(builder, GifDecoder.REPEAT_COUNT_KEY, Integer.valueOf(i), null, 4, null);
    }

    public static final Integer repeatCount(Parameters parameters) {
        return (Integer) parameters.value(GifDecoder.REPEAT_COUNT_KEY);
    }

    public static final ImageRequest.Builder animatedTransformation(ImageRequest.Builder builder, AnimatedTransformation animatedTransformation) {
        return ImageRequest.Builder.setParameter$default(builder, GifDecoder.ANIMATED_TRANSFORMATION_KEY, animatedTransformation, null, 4, null);
    }

    public static final AnimatedTransformation animatedTransformation(Parameters parameters) {
        return (AnimatedTransformation) parameters.value(GifDecoder.ANIMATED_TRANSFORMATION_KEY);
    }

    public static final ImageRequest.Builder onAnimationStart(ImageRequest.Builder builder, Function0<Unit> function0) {
        return ImageRequest.Builder.setParameter$default(builder, GifDecoder.ANIMATION_START_CALLBACK_KEY, function0, null, 4, null);
    }

    public static final Function0<Unit> animationStartCallback(Parameters parameters) {
        return (Function0) parameters.value(GifDecoder.ANIMATION_START_CALLBACK_KEY);
    }

    public static final ImageRequest.Builder onAnimationEnd(ImageRequest.Builder builder, Function0<Unit> function0) {
        return ImageRequest.Builder.setParameter$default(builder, GifDecoder.ANIMATION_END_CALLBACK_KEY, function0, null, 4, null);
    }

    public static final Function0<Unit> animationEndCallback(Parameters parameters) {
        return (Function0) parameters.value(GifDecoder.ANIMATION_END_CALLBACK_KEY);
    }
}

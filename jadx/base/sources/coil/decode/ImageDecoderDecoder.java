package coil.decode;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Size;
import coil.ImageLoader;
import coil.decode.Decoder;
import coil.decode.ImageSource;
import coil.drawable.ScaleDrawable;
import coil.fetch.SourceResult;
import coil.request.Gifs;
import coil.request.Options;
import coil.size.Sizes;
import coil.transform.AnimatedTransformation;
import coil.util.GifUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okio.BufferedSource;
import okio.Okio;
import okio.Path;

/* JADX INFO: compiled from: ImageDecoderDecoder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0003H\u0002J\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Lcoil/decode/ImageDecoderDecoder;", "Lcoil/decode/Decoder;", FirebaseAnalytics.Param.SOURCE, "Lcoil/decode/ImageSource;", "options", "Lcoil/request/Options;", "enforceMinimumFrameDelay", "", "<init>", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Z)V", "decode", "Lcoil/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wrapImageSource", "toImageDecoderSource", "Landroid/graphics/ImageDecoder$Source;", "configureImageDecoderProperties", "", "Landroid/graphics/ImageDecoder;", "wrapDrawable", "Landroid/graphics/drawable/Drawable;", "baseDrawable", "(Landroid/graphics/drawable/Drawable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "coil-gif_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ImageDecoderDecoder implements Decoder {
    private final boolean enforceMinimumFrameDelay;
    private final Options options;
    private final ImageSource source;

    /* JADX INFO: renamed from: coil.decode.ImageDecoderDecoder$decode$1 */
    /* JADX INFO: compiled from: ImageDecoderDecoder.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.decode.ImageDecoderDecoder", m1609f = "ImageDecoderDecoder.kt", m1610i = {0, 0, 1}, m1611l = {50, 90}, m1612m = "decode", m1613n = {"this", "isSampled", "isSampled"}, m1615s = {"L$0", "L$1", "L$0"})
    static final class C38231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C38231(Continuation<? super C38231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImageDecoderDecoder.this.decode(this);
        }
    }

    /* JADX INFO: renamed from: coil.decode.ImageDecoderDecoder$wrapDrawable$1 */
    /* JADX INFO: compiled from: ImageDecoderDecoder.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.decode.ImageDecoderDecoder", m1609f = "ImageDecoderDecoder.kt", m1610i = {0, 0}, m1611l = {158}, m1612m = "wrapDrawable", m1613n = {"this", "baseDrawable"}, m1615s = {"L$0", "L$1"})
    static final class C38241 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C38241(Continuation<? super C38241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImageDecoderDecoder.this.wrapDrawable(null, this);
        }
    }

    public ImageDecoderDecoder(ImageSource imageSource, Options options) {
        this(imageSource, options, false, 4, null);
    }

    public ImageDecoderDecoder(ImageSource imageSource, Options options, boolean z) {
        this.source = imageSource;
        this.options = options;
        this.enforceMinimumFrameDelay = z;
    }

    public /* synthetic */ ImageDecoderDecoder(ImageSource imageSource, Options options, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options, (i & 4) != 0 ? true : z);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // coil.decode.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object decode(Continuation<? super DecodeResult> continuation) {
        C38231 c38231;
        Ref.BooleanRef booleanRef;
        ImageDecoderDecoder imageDecoderDecoder;
        Ref.BooleanRef booleanRef2;
        if (continuation instanceof C38231) {
            c38231 = (C38231) continuation;
            if ((c38231.label & Integer.MIN_VALUE) != 0) {
                c38231.label -= Integer.MIN_VALUE;
            } else {
                c38231 = new C38231(continuation);
            }
        }
        Object objWrapDrawable = c38231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c38231.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWrapDrawable);
            final Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
            Function0 function0 = new Function0() { // from class: coil.decode.ImageDecoderDecoder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImageDecoderDecoder.decode$lambda$3(this.f$0, booleanRef3);
                }
            };
            c38231.L$0 = this;
            c38231.L$1 = booleanRef3;
            c38231.label = 1;
            Object objRunInterruptible$default = InterruptibleKt.runInterruptible$default(null, function0, c38231, 1, null);
            if (objRunInterruptible$default != coroutine_suspended) {
                booleanRef = booleanRef3;
                objWrapDrawable = objRunInterruptible$default;
                imageDecoderDecoder = this;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            booleanRef2 = (Ref.BooleanRef) c38231.L$0;
            ResultKt.throwOnFailure(objWrapDrawable);
            return new DecodeResult((Drawable) objWrapDrawable, booleanRef2.element);
        }
        booleanRef = (Ref.BooleanRef) c38231.L$1;
        imageDecoderDecoder = (ImageDecoderDecoder) c38231.L$0;
        ResultKt.throwOnFailure(objWrapDrawable);
        c38231.L$0 = booleanRef;
        c38231.L$1 = null;
        c38231.label = 2;
        objWrapDrawable = imageDecoderDecoder.wrapDrawable((Drawable) objWrapDrawable, c38231);
        if (objWrapDrawable != coroutine_suspended) {
            booleanRef2 = booleanRef;
            return new DecodeResult((Drawable) objWrapDrawable, booleanRef2.element);
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Drawable decode$lambda$3(final ImageDecoderDecoder imageDecoderDecoder, final Ref.BooleanRef booleanRef) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ImageSource imageSourceWrapImageSource = imageDecoderDecoder.wrapImageSource(imageDecoderDecoder.source);
        try {
            return ImageDecoder.decodeDrawable(imageDecoderDecoder.toImageDecoderSource(imageSourceWrapImageSource), new ImageDecoder.OnHeaderDecodedListener() { // from class: coil.decode.ImageDecoderDecoder$decode$lambda$3$$inlined$decodeDrawable$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                    objectRef.element = imageDecoder;
                    Size size = imageInfo.getSize();
                    int width = size.getWidth();
                    int height = size.getHeight();
                    coil.size.Size size2 = imageDecoderDecoder.options.getSize();
                    int px = Sizes.isOriginal(size2) ? width : GifUtils.toPx(size2.getWidth(), imageDecoderDecoder.options.getScale());
                    coil.size.Size size3 = imageDecoderDecoder.options.getSize();
                    int px2 = Sizes.isOriginal(size3) ? height : GifUtils.toPx(size3.getHeight(), imageDecoderDecoder.options.getScale());
                    if (width > 0 && height > 0 && (width != px || height != px2)) {
                        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, px, px2, imageDecoderDecoder.options.getScale());
                        booleanRef.element = dComputeSizeMultiplier < 1.0d;
                        if (booleanRef.element || !imageDecoderDecoder.options.getAllowInexactSize()) {
                            imageDecoder.setTargetSize(MathKt.roundToInt(((double) width) * dComputeSizeMultiplier), MathKt.roundToInt(dComputeSizeMultiplier * ((double) height)));
                        }
                    }
                    imageDecoderDecoder.configureImageDecoderProperties(imageDecoder);
                }
            });
        } finally {
            ImageDecoder imageDecoder = (ImageDecoder) objectRef.element;
            if (imageDecoder != null) {
                imageDecoder.close();
            }
            imageSourceWrapImageSource.close();
        }
    }

    private final ImageSource wrapImageSource(ImageSource source) {
        return (this.enforceMinimumFrameDelay && GifDecodeUtils.isGif(DecodeUtils.INSTANCE, source.source())) ? ImageSources.create(Okio.buffer(new FrameDelayRewritingSource(source.source())), this.options.getContext()) : source;
    }

    private final ImageDecoder.Source toImageDecoderSource(ImageSource imageSource) {
        Path pathFileOrNull = imageSource.fileOrNull();
        if (pathFileOrNull != null) {
            return ImageDecoder.createSource(pathFileOrNull.toFile());
        }
        ImageSource.Metadata metadata = imageSource.getMetadata();
        if (metadata instanceof AssetMetadata) {
            return ImageDecoder.createSource(this.options.getContext().getAssets(), ((AssetMetadata) metadata).getFilePath());
        }
        if (metadata instanceof ContentMetadata) {
            return ImageDecoder.createSource(this.options.getContext().getContentResolver(), ((ContentMetadata) metadata).getUri());
        }
        if (metadata instanceof ResourceMetadata) {
            ResourceMetadata resourceMetadata = (ResourceMetadata) metadata;
            if (Intrinsics.areEqual(resourceMetadata.getPackageName(), this.options.getContext().getPackageName())) {
                return ImageDecoder.createSource(this.options.getContext().getResources(), resourceMetadata.getResId());
            }
        }
        return Build.VERSION.SDK_INT >= 31 ? ImageDecoder.createSource(imageSource.source().readByteArray()) : Build.VERSION.SDK_INT == 30 ? ImageDecoder.createSource(ByteBuffer.wrap(imageSource.source().readByteArray())) : ImageDecoder.createSource(imageSource.file().toFile());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureImageDecoderProperties(ImageDecoder imageDecoder) {
        imageDecoder.setAllocator(GifUtils.isHardware(this.options.getConfig()) ? 3 : 1);
        imageDecoder.setMemorySizePolicy(!this.options.getAllowRgb565() ? 1 : 0);
        if (this.options.getColorSpace() != null) {
            imageDecoder.setTargetColorSpace(this.options.getColorSpace());
        }
        imageDecoder.setUnpremultipliedRequired(!this.options.getPremultipliedAlpha());
        AnimatedTransformation animatedTransformation = Gifs.animatedTransformation(this.options.getParameters());
        imageDecoder.setPostProcessor(animatedTransformation != null ? GifUtils.asPostProcessor(animatedTransformation) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object wrapDrawable(Drawable drawable, Continuation<? super Drawable> continuation) {
        C38241 c38241;
        ImageDecoderDecoder imageDecoderDecoder;
        if (continuation instanceof C38241) {
            c38241 = (C38241) continuation;
            if ((c38241.label & Integer.MIN_VALUE) != 0) {
                c38241.label -= Integer.MIN_VALUE;
            } else {
                c38241 = new C38241(continuation);
            }
        }
        Object obj = c38241.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c38241.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!(drawable instanceof AnimatedImageDrawable)) {
                return drawable;
            }
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable;
            Integer numRepeatCount = Gifs.repeatCount(this.options.getParameters());
            animatedImageDrawable.setRepeatCount(numRepeatCount != null ? numRepeatCount.intValue() : -1);
            Function0<Unit> function0AnimationStartCallback = Gifs.animationStartCallback(this.options.getParameters());
            Function0<Unit> function0AnimationEndCallback = Gifs.animationEndCallback(this.options.getParameters());
            if (function0AnimationStartCallback != null || function0AnimationEndCallback != null) {
                MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
                C38252 c38252 = new C38252(drawable, function0AnimationStartCallback, function0AnimationEndCallback, null);
                c38241.L$0 = this;
                c38241.L$1 = drawable;
                c38241.label = 1;
                if (BuildersKt.withContext(immediate, c38252, c38241) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            imageDecoderDecoder = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            drawable = (Drawable) c38241.L$1;
            imageDecoderDecoder = (ImageDecoderDecoder) c38241.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new ScaleDrawable(drawable, imageDecoderDecoder.options.getScale());
    }

    /* JADX INFO: renamed from: coil.decode.ImageDecoderDecoder$wrapDrawable$2 */
    /* JADX INFO: compiled from: ImageDecoderDecoder.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "coil.decode.ImageDecoderDecoder$wrapDrawable$2", m1609f = "ImageDecoderDecoder.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C38252 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Drawable $baseDrawable;
        final /* synthetic */ Function0<Unit> $onEnd;
        final /* synthetic */ Function0<Unit> $onStart;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C38252(Drawable drawable, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C38252> continuation) {
            super(2, continuation);
            this.$baseDrawable = drawable;
            this.$onStart = function0;
            this.$onEnd = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C38252(this.$baseDrawable, this.$onStart, this.$onEnd, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C38252) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((AnimatedImageDrawable) this.$baseDrawable).registerAnimationCallback(GifUtils.animatable2CallbackOf(this.$onStart, this.$onEnd));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: ImageDecoderDecoder.kt */
    @Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcoil/decode/ImageDecoderDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", "enforceMinimumFrameDelay", "", "<init>", "(Z)V", "create", "Lcoil/decode/Decoder;", "result", "Lcoil/fetch/SourceResult;", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", FirebaseAnalytics.Param.SOURCE, "Lokio/BufferedSource;", "equals", "other", "", "hashCode", "", "coil-gif_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class Factory implements Decoder.Factory {
        private final boolean enforceMinimumFrameDelay;

        public Factory() {
            this(false, 1, null);
        }

        public Factory(boolean z) {
            this.enforceMinimumFrameDelay = z;
        }

        public /* synthetic */ Factory(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        @Override // coil.decode.Decoder.Factory
        public Decoder create(SourceResult result, Options options, ImageLoader imageLoader) {
            if (isApplicable(result.getSource().source())) {
                return new ImageDecoderDecoder(result.getSource(), options, this.enforceMinimumFrameDelay);
            }
            return null;
        }

        private final boolean isApplicable(BufferedSource source) {
            if (GifDecodeUtils.isGif(DecodeUtils.INSTANCE, source) || GifDecodeUtils.isAnimatedWebP(DecodeUtils.INSTANCE, source)) {
                return true;
            }
            return Build.VERSION.SDK_INT >= 30 && GifDecodeUtils.isAnimatedHeif(DecodeUtils.INSTANCE, source);
        }

        public boolean equals(Object other) {
            return other instanceof Factory;
        }

        public int hashCode() {
            return getClass().hashCode();
        }
    }
}

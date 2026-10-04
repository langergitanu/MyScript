package coil.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import coil.ImageLoader;
import coil.decode.Decoder;
import coil.fetch.SourceResult;
import coil.request.Options;
import coil.request.Svgs;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.util.SvgUtils;
import com.caverock.androidsvg.RenderOptions;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.p039io.CloseableKt;
import kotlinx.coroutines.InterruptibleKt;
import okio.BufferedSource;

/* JADX INFO: compiled from: SvgDecoder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ,\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, m1599d2 = {"Lcoil/decode/SvgDecoder;", "Lcoil/decode/Decoder;", FirebaseAnalytics.Param.SOURCE, "Lcoil/decode/ImageSource;", "options", "Lcoil/request/Options;", "useViewBoundsAsIntrinsicSize", "", "<init>", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Z)V", "getUseViewBoundsAsIntrinsicSize", "()Z", "decode", "Lcoil/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDstSize", "Lkotlin/Pair;", "", "srcWidth", "srcHeight", "scale", "Lcoil/size/Scale;", "Factory", "Companion", "coil-svg_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SvgDecoder implements Decoder {
    public static final String CSS_KEY = "coil#css";
    private static final float DEFAULT_SIZE = 512.0f;
    private static final String MIME_TYPE_SVG = "image/svg+xml";
    private final Options options;
    private final ImageSource source;
    private final boolean useViewBoundsAsIntrinsicSize;

    public SvgDecoder(ImageSource imageSource, Options options) {
        this(imageSource, options, false, 4, null);
    }

    public SvgDecoder(ImageSource imageSource, Options options, boolean z) {
        this.source = imageSource;
        this.options = options;
        this.useViewBoundsAsIntrinsicSize = z;
    }

    public /* synthetic */ SvgDecoder(ImageSource imageSource, Options options, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options, (i & 4) != 0 ? true : z);
    }

    public final boolean getUseViewBoundsAsIntrinsicSize() {
        return this.useViewBoundsAsIntrinsicSize;
    }

    @Override // coil.decode.Decoder
    public Object decode(Continuation<? super DecodeResult> continuation) {
        return InterruptibleKt.runInterruptible$default(null, new Function0() { // from class: coil.decode.SvgDecoder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SvgDecoder.decode$lambda$2(this.f$0);
            }
        }, continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DecodeResult decode$lambda$2(SvgDecoder svgDecoder) throws SVGParseException {
        float documentWidth;
        float documentHeight;
        int iRoundToInt;
        int iRoundToInt2;
        BufferedSource bufferedSourceSource = svgDecoder.source.source();
        try {
            SVG fromInputStream = SVG.getFromInputStream(bufferedSourceSource.inputStream());
            CloseableKt.closeFinally(bufferedSourceSource, null);
            RectF documentViewBox = fromInputStream.getDocumentViewBox();
            if (svgDecoder.useViewBoundsAsIntrinsicSize && documentViewBox != null) {
                documentWidth = documentViewBox.width();
                documentHeight = documentViewBox.height();
            } else {
                documentWidth = fromInputStream.getDocumentWidth();
                documentHeight = fromInputStream.getDocumentHeight();
            }
            Pair<Float, Float> dstSize = svgDecoder.getDstSize(documentWidth, documentHeight, svgDecoder.options.getScale());
            float fFloatValue = dstSize.component1().floatValue();
            float fFloatValue2 = dstSize.component2().floatValue();
            if (documentWidth > 0.0f && documentHeight > 0.0f) {
                float fComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(documentWidth, documentHeight, fFloatValue, fFloatValue2, svgDecoder.options.getScale());
                iRoundToInt = (int) (fComputeSizeMultiplier * documentWidth);
                iRoundToInt2 = (int) (fComputeSizeMultiplier * documentHeight);
            } else {
                iRoundToInt = MathKt.roundToInt(fFloatValue);
                iRoundToInt2 = MathKt.roundToInt(fFloatValue2);
            }
            if (documentViewBox == null && documentWidth > 0.0f && documentHeight > 0.0f) {
                fromInputStream.setDocumentViewBox(0.0f, 0.0f, documentWidth, documentHeight);
            }
            fromInputStream.setDocumentWidth("100%");
            fromInputStream.setDocumentHeight("100%");
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iRoundToInt, iRoundToInt2, SvgUtils.toSoftware(svgDecoder.options.getConfig()));
            String strCss = Svgs.css(svgDecoder.options.getParameters());
            fromInputStream.renderToCanvas(new Canvas(bitmapCreateBitmap), strCss != null ? new RenderOptions().css(strCss) : null);
            return new DecodeResult(new BitmapDrawable(svgDecoder.options.getContext().getResources(), bitmapCreateBitmap), true);
        } finally {
        }
    }

    private final Pair<Float, Float> getDstSize(float srcWidth, float srcHeight, Scale scale) {
        if (Sizes.isOriginal(this.options.getSize())) {
            if (srcWidth <= 0.0f) {
                srcWidth = 512.0f;
            }
            if (srcHeight <= 0.0f) {
                srcHeight = 512.0f;
            }
            return TuplesKt.m1606to(Float.valueOf(srcWidth), Float.valueOf(srcHeight));
        }
        Size size = this.options.getSize();
        return TuplesKt.m1606to(Float.valueOf(SvgUtils.toPx(size.getWidth(), scale)), Float.valueOf(SvgUtils.toPx(size.getHeight(), scale)));
    }

    /* JADX INFO: compiled from: SvgDecoder.kt */
    @Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, m1599d2 = {"Lcoil/decode/SvgDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", "useViewBoundsAsIntrinsicSize", "", "<init>", "(Z)V", "getUseViewBoundsAsIntrinsicSize", "()Z", "create", "Lcoil/decode/Decoder;", "result", "Lcoil/fetch/SourceResult;", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "equals", "other", "", "hashCode", "", "coil-svg_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    public static final class Factory implements Decoder.Factory {
        private final boolean useViewBoundsAsIntrinsicSize;

        public Factory() {
            this(false, 1, null);
        }

        public Factory(boolean z) {
            this.useViewBoundsAsIntrinsicSize = z;
        }

        public /* synthetic */ Factory(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public final boolean getUseViewBoundsAsIntrinsicSize() {
            return this.useViewBoundsAsIntrinsicSize;
        }

        @Override // coil.decode.Decoder.Factory
        public Decoder create(SourceResult result, Options options, ImageLoader imageLoader) {
            if (isApplicable(result)) {
                return new SvgDecoder(result.getSource(), options, this.useViewBoundsAsIntrinsicSize);
            }
            return null;
        }

        private final boolean isApplicable(SourceResult result) {
            return Intrinsics.areEqual(result.getMimeType(), SvgDecoder.MIME_TYPE_SVG) || SvgDecodeUtils.isSvg(DecodeUtils.INSTANCE, result.getSource().source());
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Factory) && this.useViewBoundsAsIntrinsicSize == ((Factory) other).useViewBoundsAsIntrinsicSize;
        }

        public int hashCode() {
            return Boolean.hashCode(this.useViewBoundsAsIntrinsicSize);
        }
    }
}

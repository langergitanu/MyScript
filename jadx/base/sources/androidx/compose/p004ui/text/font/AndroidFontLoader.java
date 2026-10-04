package androidx.compose.p004ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.p004ui.text.font.AndroidFont;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AndroidFontLoader.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\fR\u0016\u0010\u0002\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "kotlin.jvm.PlatformType", "loadBlocking", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "awaitLoad", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "ui-text"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidFontLoader implements PlatformFontLoader {
    public static final int $stable = 8;
    private final Object cacheKey;
    private final Context context;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 */
    /* JADX INFO: compiled from: AndroidFontLoader.android.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.ui.text.font.AndroidFontLoader", m1609f = "AndroidFontLoader.android.kt", m1610i = {1}, m1611l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE, 57}, m1612m = "awaitLoad", m1613n = {"font"}, m1615s = {"L$0"}, m1616v = 1)
    static final class C14721 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14721(Continuation<? super C14721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidFontLoader.this.awaitLoad(null, this);
        }
    }

    public AndroidFontLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override // androidx.compose.p004ui.text.font.PlatformFontLoader
    public Typeface loadBlocking(Font font) {
        Object objM14499constructorimpl;
        Typeface typefaceLoad;
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            return androidFont.getTypefaceLoader().loadBlocking(this.context, androidFont);
        }
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        ResourceFont resourceFont = (ResourceFont) font;
        int loadingStrategy = resourceFont.getLoadingStrategy();
        if (FontLoadingStrategy.m10554equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m10559getBlockingPKNRLFQ())) {
            typefaceLoad = AndroidFontLoader_androidKt.load(resourceFont, this.context);
        } else if (FontLoadingStrategy.m10554equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m10560getOptionalLocalPKNRLFQ())) {
            try {
                Result.Companion companion = Result.INSTANCE;
                AndroidFontLoader androidFontLoader = this;
                objM14499constructorimpl = Result.m14499constructorimpl(AndroidFontLoader_androidKt.load((ResourceFont) font, this.context));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
            typefaceLoad = (Typeface) (Result.m14505isFailureimpl(objM14499constructorimpl) ? null : objM14499constructorimpl);
        } else {
            if (FontLoadingStrategy.m10554equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m10558getAsyncPKNRLFQ())) {
                throw new UnsupportedOperationException("Unsupported Async font load path");
            }
            throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m10556toStringimpl(resourceFont.getLoadingStrategy())));
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typefaceLoad, resourceFont.getVariationSettings(), this.context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        if (r7 == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.p004ui.text.font.PlatformFontLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitLoad(Font font, Continuation<? super Typeface> continuation) {
        C14721 c14721;
        if (continuation instanceof C14721) {
            c14721 = (C14721) continuation;
            if ((c14721.label & Integer.MIN_VALUE) != 0) {
                c14721.label -= Integer.MIN_VALUE;
            } else {
                c14721 = new C14721(continuation);
            }
        }
        Object objLoadAsync = c14721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14721.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objLoadAsync);
            if (font instanceof AndroidFont) {
                AndroidFont androidFont = (AndroidFont) font;
                AndroidFont.TypefaceLoader typefaceLoader = androidFont.getTypefaceLoader();
                Context context = this.context;
                c14721.label = 1;
                Object objAwaitLoad = typefaceLoader.awaitLoad(context, androidFont, c14721);
                if (objAwaitLoad != coroutine_suspended) {
                    return objAwaitLoad;
                }
            } else if (font instanceof ResourceFont) {
                Context context2 = this.context;
                c14721.L$0 = font;
                c14721.label = 2;
                objLoadAsync = AndroidFontLoader_androidKt.loadAsync((ResourceFont) font, context2, c14721);
            } else {
                throw new IllegalArgumentException("Unknown font type: " + font);
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(objLoadAsync);
            return objLoadAsync;
        }
        if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        font = (Font) c14721.L$0;
        ResultKt.throwOnFailure(objLoadAsync);
        return PlatformTypefaces_androidKt.setFontVariationSettings((Typeface) objLoadAsync, ((ResourceFont) font).getVariationSettings(), this.context);
    }

    @Override // androidx.compose.p004ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }
}

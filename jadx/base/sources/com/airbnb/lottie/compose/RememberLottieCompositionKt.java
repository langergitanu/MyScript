package com.airbnb.lottie.compose;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import androidx.compose.material.TextFieldImplKt;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.fasterxml.jackson.core.JsonPointer;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.surveys.FormSurveyFieldType;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: rememberLottieComposition.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\u001a0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\n\u001a(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0082@¢\u0006\u0002\u0010\r\u001aL\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0086@¢\u0006\u0002\u0010\u0012\u001a2\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\u001a\"\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002\u001a*\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0002\u001a\u008b\u0001\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012H\b\u0002\u0010 \u001aB\b\u0001\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110&¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160(\u0012\u0006\u0012\u0004\u0018\u00010)0!H\u0007¢\u0006\u0002\u0010*\u001a\u001a\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a\u001e\u0010/\u001a\u0002H0\"\u0004\b\u0000\u00100*\b\u0012\u0004\u0012\u0002H00\u0014H\u0082@¢\u0006\u0002\u00101\u001a\f\u00102\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\u0010\u00103\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u00064²\u0006\n\u00105\u001a\u000206X\u008a\u0084\u0002"}, m1599d2 = {"DefaultCacheKey", "", "loadFontsFromAssets", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "composition", "Lcom/airbnb/lottie/LottieComposition;", "fontAssetsFolder", "fontFileExtension", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieComposition;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadImagesFromAssets", "imageAssetsFolder", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieComposition;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lottieComposition", "spec", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "cacheKey", "(Landroid/content/Context;Lcom/airbnb/lottie/compose/LottieCompositionSpec;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lottieTask", "Lcom/airbnb/lottie/LottieTask;", "isWarmingCache", "", "maybeDecodeBase64Image", "asset", "Lcom/airbnb/lottie/LottieImageAsset;", "maybeLoadImageFromAsset", "maybeLoadTypefaceFromAssets", "font", "Lcom/airbnb/lottie/model/Font;", "rememberLottieComposition", "Lcom/airbnb/lottie/compose/LottieCompositionResult;", "onRetry", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "failCount", "", "previousException", "Lkotlin/coroutines/Continuation;", "", "(Lcom/airbnb/lottie/compose/LottieCompositionSpec;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Lcom/airbnb/lottie/compose/LottieCompositionResult;", "typefaceForStyle", "Landroid/graphics/Typeface;", "typeface", "style", "await", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/airbnb/lottie/LottieTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureLeadingPeriod", "ensureTrailingSlash", "lottie-compose_release", "result", "Lcom/airbnb/lottie/compose/LottieCompositionResultImpl;"}, m1600k = 2, m1601mv = {1, 9, 0}, m1603xi = 48)
public final class RememberLottieCompositionKt {
    private static final String DefaultCacheKey = "__LottieInternalDefaultCacheKey__";

    /* JADX INFO: renamed from: com.airbnb.lottie.compose.RememberLottieCompositionKt$lottieComposition$1 */
    /* JADX INFO: compiled from: rememberLottieComposition.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 9, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.airbnb.lottie.compose.RememberLottieCompositionKt", m1609f = "rememberLottieComposition.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, m1611l = {TextFieldImplKt.AnimationDuration, 151, 152}, m1612m = "lottieComposition", m1613n = {WebViewMessageType.CONTEXT, "imageAssetsFolder", "fontAssetsFolder", "fontFileExtension", WebViewMessageType.CONTEXT, "fontAssetsFolder", "fontFileExtension", "composition", "composition"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
    static final class C38831 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C38831(Continuation<? super C38831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RememberLottieCompositionKt.lottieComposition(null, null, null, null, null, null, this);
        }
    }

    public static final LottieCompositionResult rememberLottieComposition(LottieCompositionSpec spec, String str, String str2, String str3, String str4, Function3<? super Integer, ? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function3, Composer composer, int i, int i2) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(spec, "spec");
        composer.startReplaceableGroup(-1248473602);
        String str5 = (i2 & 2) != 0 ? null : str;
        String str6 = (i2 & 4) != 0 ? "fonts/" : str2;
        String str7 = (i2 & 8) != 0 ? ".ttf" : str3;
        String str8 = (i2 & 16) != 0 ? DefaultCacheKey : str4;
        C38841 c38841 = (i2 & 32) != 0 ? new C38841(null) : function3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1248473602, i, -1, "com.airbnb.lottie.compose.rememberLottieComposition (rememberLottieComposition.kt:83)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        composer.startReplaceableGroup(1388713953);
        int i3 = i & 14;
        int i4 = i3 ^ 6;
        boolean z = (i4 > 4 && composer.changed(spec)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new LottieCompositionResultImpl(), null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(1388714244);
        boolean z2 = ((i4 > 4 && composer.changed(spec)) || (i & 6) == 4) | ((((57344 & i) ^ 24576) > 16384 && composer.changed(str8)) || (i & 24576) == 16384);
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = lottieTask(context, spec, str8, true);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(spec, str8, new C38853(c38841, context, spec, str5, str6, str7, str8, mutableState, null), composer, i3 | 512 | ((i >> 9) & 112));
        LottieCompositionResultImpl lottieCompositionResultImplRememberLottieComposition$lambda$1 = rememberLottieComposition$lambda$1(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lottieCompositionResultImplRememberLottieComposition$lambda$1;
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$1 */
    /* JADX INFO: compiled from: rememberLottieComposition.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 9, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$1", m1609f = "rememberLottieComposition.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C38841 extends SuspendLambda implements Function3<Integer, Throwable, Continuation<? super Boolean>, Object> {
        int label;

        C38841(Continuation<? super C38841> continuation) {
            super(3, continuation);
        }

        public final Object invoke(int i, Throwable th, Continuation<? super Boolean> continuation) {
            return new C38841(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Throwable th, Continuation<? super Boolean> continuation) {
            return invoke(num.intValue(), th, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LottieCompositionResultImpl rememberLottieComposition$lambda$1(MutableState<LottieCompositionResultImpl> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$3 */
    /* JADX INFO: compiled from: rememberLottieComposition.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 9, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$3", m1609f = "rememberLottieComposition.kt", m1610i = {0, 0, 1, 1}, m1611l = {PDFACompliance.e_PDFA9_3, PDFACompliance.e_PDFA9_5}, m1612m = "invokeSuspend", m1613n = {"exception", "failedCount", "exception", "failedCount"}, m1615s = {"L$0", "I$0", "L$0", "I$0"})
    static final class C38853 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cacheKey;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $fontAssetsFolder;
        final /* synthetic */ String $fontFileExtension;
        final /* synthetic */ String $imageAssetsFolder;
        final /* synthetic */ Function3<Integer, Throwable, Continuation<? super Boolean>, Object> $onRetry;
        final /* synthetic */ MutableState<LottieCompositionResultImpl> $result$delegate;
        final /* synthetic */ LottieCompositionSpec $spec;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C38853(Function3<? super Integer, ? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function3, Context context, LottieCompositionSpec lottieCompositionSpec, String str, String str2, String str3, String str4, MutableState<LottieCompositionResultImpl> mutableState, Continuation<? super C38853> continuation) {
            super(2, continuation);
            this.$onRetry = function3;
            this.$context = context;
            this.$spec = lottieCompositionSpec;
            this.$imageAssetsFolder = str;
            this.$fontAssetsFolder = str2;
            this.$fontFileExtension = str3;
            this.$cacheKey = str4;
            this.$result$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C38853(this.$onRetry, this.$context, this.$spec, this.$imageAssetsFolder, this.$fontAssetsFolder, this.$fontFileExtension, this.$cacheKey, this.$result$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C38853) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
        
            if (r14 == r1) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
        
            if (((java.lang.Boolean) r14).booleanValue() != false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
        
            if (r14 == r1) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ad A[ADDED_TO_REGION] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x008c -> B:27:0x008f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                i = 0;
                th = null;
                if (!RememberLottieCompositionKt.rememberLottieComposition$lambda$1(this.$result$delegate).isSuccess()) {
                }
                if (!RememberLottieCompositionKt.rememberLottieComposition$lambda$1(this.$result$delegate).isComplete()) {
                    RememberLottieCompositionKt.rememberLottieComposition$lambda$1(this.$result$delegate).completeExceptionally$lottie_compose_release(th);
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = this.I$0;
                Throwable th2 = (Throwable) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th3) {
                    int i4 = i3;
                    th = th3;
                    i = i4 + 1;
                    if (!RememberLottieCompositionKt.rememberLottieComposition$lambda$1(this.$result$delegate).isSuccess()) {
                    }
                    if (!RememberLottieCompositionKt.rememberLottieComposition$lambda$1(this.$result$delegate).isComplete()) {
                    }
                    return Unit.INSTANCE;
                }
                RememberLottieCompositionKt.rememberLottieComposition$lambda$1(this.$result$delegate).complete$lottie_compose_release((LottieComposition) obj);
                int i5 = i3;
                th = th2;
                i = i5;
                if (!RememberLottieCompositionKt.rememberLottieComposition$lambda$1(this.$result$delegate).isSuccess()) {
                    if (i != 0) {
                        Function3<Integer, Throwable, Continuation<? super Boolean>, Object> function3 = this.$onRetry;
                        Integer numBoxInt = Boxing.boxInt(i);
                        Intrinsics.checkNotNull(th);
                        this.L$0 = th;
                        this.I$0 = i;
                        this.label = 1;
                        obj = function3.invoke(numBoxInt, th, this);
                    } else {
                        Throwable th4 = th;
                        i3 = i;
                        th2 = th4;
                        this.L$0 = th2;
                        this.I$0 = i3;
                        this.label = 2;
                        obj = RememberLottieCompositionKt.lottieComposition(this.$context, this.$spec, RememberLottieCompositionKt.ensureTrailingSlash(this.$imageAssetsFolder), RememberLottieCompositionKt.ensureTrailingSlash(this.$fontAssetsFolder), RememberLottieCompositionKt.ensureLeadingPeriod(this.$fontFileExtension), this.$cacheKey, this);
                    }
                    return coroutine_suspended;
                }
                if (!RememberLottieCompositionKt.rememberLottieComposition$lambda$1(this.$result$delegate).isComplete() && th != null) {
                    RememberLottieCompositionKt.rememberLottieComposition$lambda$1(this.$result$delegate).completeExceptionally$lottie_compose_release(th);
                }
                return Unit.INSTANCE;
            }
            i = this.I$0;
            th = (Throwable) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object lottieComposition(Context context, LottieCompositionSpec lottieCompositionSpec, String str, String str2, String str3, String str4, Continuation<? super LottieComposition> continuation) throws FileNotFoundException {
        C38831 c38831;
        String str5;
        Context context2;
        LottieComposition lottieComposition;
        String str6;
        if (continuation instanceof C38831) {
            c38831 = (C38831) continuation;
            if ((c38831.label & Integer.MIN_VALUE) != 0) {
                c38831.label -= Integer.MIN_VALUE;
            } else {
                c38831 = new C38831(continuation);
            }
        }
        Object objAwait = c38831.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c38831.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            LottieTask<LottieComposition> lottieTask = lottieTask(context, lottieCompositionSpec, str4, false);
            if (lottieTask == null) {
                throw new IllegalArgumentException(("Unable to create parsing task for " + lottieCompositionSpec + ".").toString());
            }
            c38831.L$0 = context;
            c38831.L$1 = str;
            c38831.L$2 = str2;
            c38831.L$3 = str3;
            c38831.label = 1;
            objAwait = await(lottieTask, c38831);
            if (objAwait != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LottieComposition lottieComposition2 = (LottieComposition) c38831.L$0;
                ResultKt.throwOnFailure(objAwait);
                return lottieComposition2;
            }
            lottieComposition = (LottieComposition) c38831.L$3;
            str6 = (String) c38831.L$2;
            str5 = (String) c38831.L$1;
            context2 = (Context) c38831.L$0;
            ResultKt.throwOnFailure(objAwait);
            c38831.L$0 = lottieComposition;
            c38831.L$1 = null;
            c38831.L$2 = null;
            c38831.L$3 = null;
            c38831.label = 3;
            return loadFontsFromAssets(context2, lottieComposition, str5, str6, c38831) != coroutine_suspended ? coroutine_suspended : lottieComposition;
        }
        str3 = (String) c38831.L$3;
        str2 = (String) c38831.L$2;
        str = (String) c38831.L$1;
        context = (Context) c38831.L$0;
        ResultKt.throwOnFailure(objAwait);
        LottieComposition lottieComposition3 = (LottieComposition) objAwait;
        c38831.L$0 = context;
        c38831.L$1 = str2;
        c38831.L$2 = str3;
        c38831.L$3 = lottieComposition3;
        c38831.label = 2;
        if (loadImagesFromAssets(context, lottieComposition3, str, c38831) != coroutine_suspended) {
            str5 = str2;
            context2 = context;
            lottieComposition = lottieComposition3;
            str6 = str3;
            c38831.L$0 = lottieComposition;
            c38831.L$1 = null;
            c38831.L$2 = null;
            c38831.L$3 = null;
            c38831.label = 3;
            if (loadFontsFromAssets(context2, lottieComposition, str5, str6, c38831) != coroutine_suspended) {
            }
        }
    }

    public static /* synthetic */ Object lottieComposition$default(Context context, LottieCompositionSpec lottieCompositionSpec, String str, String str2, String str3, String str4, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        String str5 = str;
        if ((i & 8) != 0) {
            str2 = "fonts/";
        }
        String str6 = str2;
        if ((i & 16) != 0) {
            str3 = ".ttf";
        }
        String str7 = str3;
        if ((i & 32) != 0) {
            str4 = DefaultCacheKey;
        }
        return lottieComposition(context, lottieCompositionSpec, str5, str6, str7, str4, continuation);
    }

    private static final LottieTask<LottieComposition> lottieTask(Context context, LottieCompositionSpec lottieCompositionSpec, String str, boolean z) throws FileNotFoundException {
        if (lottieCompositionSpec instanceof LottieCompositionSpec.RawRes) {
            if (Intrinsics.areEqual(str, DefaultCacheKey)) {
                return LottieCompositionFactory.fromRawRes(context, ((LottieCompositionSpec.RawRes) lottieCompositionSpec).m12427unboximpl());
            }
            return LottieCompositionFactory.fromRawRes(context, ((LottieCompositionSpec.RawRes) lottieCompositionSpec).m12427unboximpl(), str);
        }
        if (lottieCompositionSpec instanceof LottieCompositionSpec.Url) {
            if (Intrinsics.areEqual(str, DefaultCacheKey)) {
                return LottieCompositionFactory.fromUrl(context, ((LottieCompositionSpec.Url) lottieCompositionSpec).m12434unboximpl());
            }
            return LottieCompositionFactory.fromUrl(context, ((LottieCompositionSpec.Url) lottieCompositionSpec).m12434unboximpl(), str);
        }
        if (lottieCompositionSpec instanceof LottieCompositionSpec.File) {
            if (z) {
                return null;
            }
            LottieCompositionSpec.File file = (LottieCompositionSpec.File) lottieCompositionSpec;
            FileInputStream fileInputStream = new FileInputStream(file.m12413unboximpl());
            if (Intrinsics.areEqual(str, DefaultCacheKey)) {
                str = file.m12413unboximpl();
            }
            if (StringsKt.endsWith$default(file.m12413unboximpl(), FormSurveyFieldType.ZIP, false, 2, (Object) null)) {
                return LottieCompositionFactory.fromZipStream(new ZipInputStream(fileInputStream), str);
            }
            if (StringsKt.endsWith$default(file.m12413unboximpl(), "tgs", false, 2, (Object) null)) {
                return LottieCompositionFactory.fromJsonInputStream(new GZIPInputStream(fileInputStream), str);
            }
            return LottieCompositionFactory.fromJsonInputStream(fileInputStream, str);
        }
        if (lottieCompositionSpec instanceof LottieCompositionSpec.Asset) {
            if (Intrinsics.areEqual(str, DefaultCacheKey)) {
                return LottieCompositionFactory.fromAsset(context, ((LottieCompositionSpec.Asset) lottieCompositionSpec).m12399unboximpl());
            }
            return LottieCompositionFactory.fromAsset(context, ((LottieCompositionSpec.Asset) lottieCompositionSpec).m12399unboximpl(), str);
        }
        if (lottieCompositionSpec instanceof LottieCompositionSpec.JsonString) {
            if (Intrinsics.areEqual(str, DefaultCacheKey)) {
                str = String.valueOf(((LottieCompositionSpec.JsonString) lottieCompositionSpec).m12420unboximpl().hashCode());
            }
            return LottieCompositionFactory.fromJsonString(((LottieCompositionSpec.JsonString) lottieCompositionSpec).m12420unboximpl(), str);
        }
        if (!(lottieCompositionSpec instanceof LottieCompositionSpec.ContentProvider)) {
            throw new NoWhenBranchMatchedException();
        }
        LottieCompositionSpec.ContentProvider contentProvider = (LottieCompositionSpec.ContentProvider) lottieCompositionSpec;
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(contentProvider.m12406unboximpl());
        if (Intrinsics.areEqual(str, DefaultCacheKey)) {
            str = contentProvider.m12406unboximpl().toString();
        }
        return LottieCompositionFactory.fromInputStream(context, inputStreamOpenInputStream, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object loadImagesFromAssets(Context context, LottieComposition lottieComposition, String str, Continuation<? super Unit> continuation) {
        if (!lottieComposition.hasImages()) {
            return Unit.INSTANCE;
        }
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C38822(lottieComposition, context, str, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.compose.RememberLottieCompositionKt$loadImagesFromAssets$2 */
    /* JADX INFO: compiled from: rememberLottieComposition.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 9, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.airbnb.lottie.compose.RememberLottieCompositionKt$loadImagesFromAssets$2", m1609f = "rememberLottieComposition.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C38822 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LottieComposition $composition;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $imageAssetsFolder;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C38822(LottieComposition lottieComposition, Context context, String str, Continuation<? super C38822> continuation) {
            super(2, continuation);
            this.$composition = lottieComposition;
            this.$context = context;
            this.$imageAssetsFolder = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C38822(this.$composition, this.$context, this.$imageAssetsFolder, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C38822) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            for (LottieImageAsset lottieImageAsset : this.$composition.getImages().values()) {
                Intrinsics.checkNotNull(lottieImageAsset);
                RememberLottieCompositionKt.maybeDecodeBase64Image(lottieImageAsset);
                RememberLottieCompositionKt.maybeLoadImageFromAsset(this.$context, lottieImageAsset, this.$imageAssetsFolder);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void maybeLoadImageFromAsset(Context context, LottieImageAsset lottieImageAsset, String str) {
        if (lottieImageAsset.getBitmap() != null || str == null) {
            return;
        }
        try {
            InputStream inputStreamOpen = context.getAssets().open(str + lottieImageAsset.getFileName());
            Intrinsics.checkNotNull(inputStreamOpen);
            Bitmap bitmapDecodeStream = null;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen, null, options);
            } catch (IllegalArgumentException e) {
                Logger.warning("Unable to decode image.", e);
            }
            if (bitmapDecodeStream != null) {
                lottieImageAsset.setBitmap(Utils.resizeBitmapIfNeeded(bitmapDecodeStream, lottieImageAsset.getWidth(), lottieImageAsset.getHeight()));
            }
        } catch (IOException e2) {
            Logger.warning("Unable to open asset.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void maybeDecodeBase64Image(LottieImageAsset lottieImageAsset) {
        if (lottieImageAsset.getBitmap() != null) {
            return;
        }
        String fileName = lottieImageAsset.getFileName();
        Intrinsics.checkNotNull(fileName);
        if (!StringsKt.startsWith$default(fileName, "data:", false, 2, (Object) null) || StringsKt.indexOf$default((CharSequence) fileName, "base64,", 0, false, 6, (Object) null) <= 0) {
            return;
        }
        try {
            String strSubstring = fileName.substring(StringsKt.indexOf$default((CharSequence) fileName, AbstractJsonLexerKt.COMMA, 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            byte[] bArrDecode = Base64.decode(strSubstring, 0);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = true;
            options.inDensity = 160;
            lottieImageAsset.setBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
        } catch (IllegalArgumentException e) {
            Logger.warning("data URL did not have correct base64 format.", e);
        }
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.compose.RememberLottieCompositionKt$loadFontsFromAssets$2 */
    /* JADX INFO: compiled from: rememberLottieComposition.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 9, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.airbnb.lottie.compose.RememberLottieCompositionKt$loadFontsFromAssets$2", m1609f = "rememberLottieComposition.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C38812 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LottieComposition $composition;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $fontAssetsFolder;
        final /* synthetic */ String $fontFileExtension;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C38812(LottieComposition lottieComposition, Context context, String str, String str2, Continuation<? super C38812> continuation) {
            super(2, continuation);
            this.$composition = lottieComposition;
            this.$context = context;
            this.$fontAssetsFolder = str;
            this.$fontFileExtension = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C38812(this.$composition, this.$context, this.$fontAssetsFolder, this.$fontFileExtension, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C38812) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            for (Font font : this.$composition.getFonts().values()) {
                Context context = this.$context;
                Intrinsics.checkNotNull(font);
                RememberLottieCompositionKt.maybeLoadTypefaceFromAssets(context, font, this.$fontAssetsFolder, this.$fontFileExtension);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object loadFontsFromAssets(Context context, LottieComposition lottieComposition, String str, String str2, Continuation<? super Unit> continuation) {
        Object objWithContext;
        return (!lottieComposition.getFonts().isEmpty() && (objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C38812(lottieComposition, context, str, str2, null), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void maybeLoadTypefaceFromAssets(Context context, Font font, String str, String str2) {
        String str3 = str + font.getFamily() + str2;
        try {
            Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), str3);
            try {
                Intrinsics.checkNotNull(typefaceCreateFromAsset);
                String style = font.getStyle();
                Intrinsics.checkNotNullExpressionValue(style, "getStyle(...)");
                font.setTypeface(typefaceForStyle(typefaceCreateFromAsset, style));
            } catch (Exception e) {
                Logger.error("Failed to create " + font.getFamily() + " typeface with style=" + font.getStyle() + "!", e);
            }
        } catch (Exception e2) {
            Logger.error("Failed to find typeface in assets with path " + str3 + ".", e2);
        }
    }

    private static final Typeface typefaceForStyle(Typeface typeface, String str) {
        String str2 = str;
        int i = 0;
        boolean zContains$default = StringsKt.contains$default((CharSequence) str2, (CharSequence) "Italic", false, 2, (Object) null);
        boolean zContains$default2 = StringsKt.contains$default((CharSequence) str2, (CharSequence) "Bold", false, 2, (Object) null);
        if (zContains$default && zContains$default2) {
            i = 3;
        } else if (zContains$default) {
            i = 2;
        } else if (zContains$default2) {
            i = 1;
        }
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ensureTrailingSlash(String str) {
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return null;
        }
        return StringsKt.endsWith$default((CharSequence) str2, JsonPointer.SEPARATOR, false, 2, (Object) null) ? str : str + DomExceptionUtils.SEPARATOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ensureLeadingPeriod(String str) {
        return (StringsKt.isBlank(str) || StringsKt.startsWith$default(str, ".", false, 2, (Object) null)) ? str : "." + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object await(LottieTask<T> lottieTask, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        lottieTask.addListener(new LottieListener() { // from class: com.airbnb.lottie.compose.RememberLottieCompositionKt$await$2$1
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(T t) {
                if (cancellableContinuationImpl2.isCompleted()) {
                    return;
                }
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m14499constructorimpl(t));
            }
        }).addFailureListener(new LottieListener() { // from class: com.airbnb.lottie.compose.RememberLottieCompositionKt$await$2$2
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Throwable th) {
                if (cancellableContinuationImpl2.isCompleted()) {
                    return;
                }
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNull(th);
                cancellableContinuation.resumeWith(Result.m14499constructorimpl(ResultKt.createFailure(th)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}

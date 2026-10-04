package androidx.compose.p004ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.media.Image;
import android.media.ImageReader;
import android.os.Looper;
import android.view.Surface;
import androidx.compose.p004ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.core.os.HandlerCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: LayerSnapshot.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, m1599d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV22;", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "<init>", "()V", "toBitmap", "Landroid/graphics/Bitmap;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-graphics"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LayerSnapshotV22 implements LayerSnapshotImpl {
    public static final int $stable = 0;
    public static final LayerSnapshotV22 INSTANCE = new LayerSnapshotV22();

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1 */
    /* JADX INFO: compiled from: LayerSnapshot.android.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.compose.ui.graphics.layer.LayerSnapshotV22", m1609f = "LayerSnapshot.android.kt", m1610i = {0, 0, 0, 0}, m1611l = {225}, m1612m = "toBitmap", m1613n = {"graphicsLayer", "looper", "reader", "$completion$iv"}, m1615s = {"L$0", "L$1", "L$3", "L$4"}, m1616v = 1)
    static final class C13091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C13091(Continuation<? super C13091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayerSnapshotV22.this.toBitmap(null, this);
        }
    }

    private LayerSnapshotV22() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.p004ui.graphics.layer.LayerSnapshotImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object toBitmap(GraphicsLayer graphicsLayer, Continuation<? super Bitmap> continuation) {
        C13091 c13091;
        AutoCloseable autoCloseable;
        if (continuation instanceof C13091) {
            c13091 = (C13091) continuation;
            if ((c13091.label & Integer.MIN_VALUE) != 0) {
                c13091.label -= Integer.MIN_VALUE;
            } else {
                c13091 = new C13091(continuation);
            }
        }
        Object result = c13091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13091.label;
        if (i == 0) {
            ResultKt.throwOnFailure(result);
            long size = graphicsLayer.getSize();
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                looperMyLooper = Looper.getMainLooper();
            }
            ImageReader imageReaderNewInstance = ImageReader.newInstance((int) (size >> 32), (int) (size & 4294967295L), 1, 1);
            try {
                ImageReader imageReader = imageReaderNewInstance;
                c13091.L$0 = graphicsLayer;
                c13091.L$1 = looperMyLooper;
                c13091.L$2 = imageReaderNewInstance;
                c13091.L$3 = imageReader;
                c13091.L$4 = c13091;
                c13091.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c13091), 1);
                cancellableContinuationImpl.initCancellability();
                final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$2$image$1$1
                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public final void onImageAvailable(ImageReader imageReader2) {
                        CancellableContinuation<Image> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m14499constructorimpl(imageReader2.acquireLatestImage()));
                    }
                }, HandlerCompat.createAsync(looperMyLooper));
                Surface surface = imageReader.getSurface();
                Canvas canvasLockCanvas = SurfaceUtils.INSTANCE.lockCanvas(surface);
                try {
                    canvasLockCanvas.drawColor(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8174getBlack0d7_KjU()), PorterDuff.Mode.CLEAR);
                    graphicsLayer.draw$ui_graphics(AndroidCanvas_androidKt.Canvas(canvasLockCanvas), null);
                    surface.unlockCanvasAndPost(canvasLockCanvas);
                    result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(c13091);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    autoCloseable = imageReaderNewInstance;
                } catch (Throwable th) {
                    surface.unlockCanvasAndPost(canvasLockCanvas);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                autoCloseable = imageReaderNewInstance;
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            autoCloseable = (AutoCloseable) c13091.L$2;
            try {
                ResultKt.throwOnFailure(result);
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    AutoCloseableKt.closeFinally(autoCloseable, th);
                    throw th4;
                }
            }
        }
        Bitmap bitmap = LayerSnapshot_androidKt.toBitmap((Image) result);
        AutoCloseableKt.closeFinally(autoCloseable, null);
        return bitmap;
    }
}

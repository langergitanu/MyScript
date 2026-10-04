package androidx.media3.p008ui.compose;

import android.view.AttachedSurfaceControl;
import android.view.SurfaceControl;
import android.view.SurfaceView;
import android.window.SurfaceSyncGroup;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PlayerSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.media3.ui.compose.PlayerSurfaceKt$PlayerSurface$onSurfaceSizeChanged$1$1$1", m1609f = "PlayerSurface.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class PlayerSurfaceKt$PlayerSurface$onSurfaceSizeChanged$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<SurfaceSyncGroup> $surfaceSyncGroup$delegate;
    final /* synthetic */ SurfaceView $surfaceView;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerSurfaceKt$PlayerSurface$onSurfaceSizeChanged$1$1$1(SurfaceView surfaceView, MutableState<SurfaceSyncGroup> mutableState, Continuation<? super PlayerSurfaceKt$PlayerSurface$onSurfaceSizeChanged$1$1$1> continuation) {
        super(2, continuation);
        this.$surfaceView = surfaceView;
        this.$surfaceSyncGroup$delegate = mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$3$lambda$2$lambda$0() {
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerSurfaceKt$PlayerSurface$onSurfaceSizeChanged$1$1$1(this.$surfaceView, this.$surfaceSyncGroup$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerSurfaceKt$PlayerSurface$onSurfaceSizeChanged$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        AttachedSurfaceControl rootSurfaceControl = this.$surfaceView.getRootSurfaceControl();
        if (rootSurfaceControl != null) {
            SurfaceView surfaceView = this.$surfaceView;
            MutableState<SurfaceSyncGroup> mutableState = this.$surfaceSyncGroup$delegate;
            SurfaceSyncGroup surfaceSyncGroup = new SurfaceSyncGroup("exo-sync-b-334901521");
            if (!surfaceSyncGroup.add(rootSurfaceControl, new Runnable() { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$PlayerSurface$onSurfaceSizeChanged$1$1$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PlayerSurfaceKt$PlayerSurface$onSurfaceSizeChanged$1$1$1.invokeSuspend$lambda$3$lambda$2$lambda$0();
                }
            })) {
                throw new IllegalStateException("Failed to add rootSurfaceControl to SurfaceSyncGroup".toString());
            }
            mutableState.setValue(surfaceSyncGroup);
            surfaceView.invalidate();
            rootSurfaceControl.applyTransactionOnDraw(new SurfaceControl.Transaction());
        }
        return Unit.INSTANCE;
    }
}

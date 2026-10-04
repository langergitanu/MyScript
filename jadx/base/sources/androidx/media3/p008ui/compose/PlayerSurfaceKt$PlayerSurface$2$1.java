package androidx.media3.p008ui.compose;

import android.view.SurfaceView;
import androidx.media3.common.Player;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
/* synthetic */ class PlayerSurfaceKt$PlayerSurface$2$1 extends FunctionReferenceImpl implements Function2<Player, SurfaceView, Unit> {
    public static final PlayerSurfaceKt$PlayerSurface$2$1 INSTANCE = new PlayerSurfaceKt$PlayerSurface$2$1();

    PlayerSurfaceKt$PlayerSurface$2$1() {
        super(2, Player.class, "clearVideoSurfaceView", "clearVideoSurfaceView(Landroid/view/SurfaceView;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Player player, SurfaceView surfaceView) {
        invoke2(player, surfaceView);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Player p0, SurfaceView surfaceView) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        p0.clearVideoSurfaceView(surfaceView);
    }
}

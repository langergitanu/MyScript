package androidx.media3.p008ui.compose;

import android.view.TextureView;
import androidx.media3.common.Player;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
/* synthetic */ class PlayerSurfaceKt$PlayerSurface$5$1 extends FunctionReferenceImpl implements Function2<Player, TextureView, Unit> {
    public static final PlayerSurfaceKt$PlayerSurface$5$1 INSTANCE = new PlayerSurfaceKt$PlayerSurface$5$1();

    PlayerSurfaceKt$PlayerSurface$5$1() {
        super(2, Player.class, "clearVideoTextureView", "clearVideoTextureView(Landroid/view/TextureView;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Player player, TextureView textureView) {
        invoke2(player, textureView);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Player p0, TextureView textureView) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        p0.clearVideoTextureView(textureView);
    }
}

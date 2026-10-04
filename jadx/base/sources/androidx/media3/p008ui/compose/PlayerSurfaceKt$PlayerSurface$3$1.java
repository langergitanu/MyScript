package androidx.media3.p008ui.compose;

import android.content.Context;
import android.view.TextureView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
/* synthetic */ class PlayerSurfaceKt$PlayerSurface$3$1 extends FunctionReferenceImpl implements Function1<Context, TextureView> {
    public static final PlayerSurfaceKt$PlayerSurface$3$1 INSTANCE = new PlayerSurfaceKt$PlayerSurface$3$1();

    PlayerSurfaceKt$PlayerSurface$3$1() {
        super(1, TextureView.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final TextureView invoke(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new TextureView(p0);
    }
}

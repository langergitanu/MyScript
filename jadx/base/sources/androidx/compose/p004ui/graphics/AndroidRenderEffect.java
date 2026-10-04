package androidx.compose.p004ui.graphics;

import android.graphics.RenderEffect;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidRenderEffect.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Landroidx/compose/ui/graphics/AndroidRenderEffect;", "Landroidx/compose/ui/graphics/RenderEffect;", "androidRenderEffect", "Landroid/graphics/RenderEffect;", "<init>", "(Landroid/graphics/RenderEffect;)V", "getAndroidRenderEffect", "()Landroid/graphics/RenderEffect;", "createRenderEffect", "ui-graphics"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidRenderEffect extends RenderEffect {
    public static final int $stable = 0;
    private final RenderEffect androidRenderEffect;

    public AndroidRenderEffect(RenderEffect renderEffect) {
        super(null);
        this.androidRenderEffect = renderEffect;
    }

    public final RenderEffect getAndroidRenderEffect() {
        return this.androidRenderEffect;
    }

    @Override // androidx.compose.p004ui.graphics.RenderEffect
    /* JADX INFO: renamed from: createRenderEffect, reason: from getter */
    protected RenderEffect getAndroidRenderEffect() {
        return this.androidRenderEffect;
    }
}

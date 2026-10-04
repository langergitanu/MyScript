package com.revenuecat.purchases.p036ui.revenuecatui.components.video;

import androidx.compose.p004ui.Modifier;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.AspectRatio;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.AspectRatioKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: VideoComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
public /* synthetic */ class VideoComponentViewKt$VideoComponentView$5$1 extends FunctionReferenceImpl implements Function2<Modifier, AspectRatio, Modifier> {
    public static final VideoComponentViewKt$VideoComponentView$5$1 INSTANCE = new VideoComponentViewKt$VideoComponentView$5$1();

    VideoComponentViewKt$VideoComponentView$5$1() {
        super(2, AspectRatioKt.class, "aspectRatio", "aspectRatio(Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/components/modifier/AspectRatio;)Landroidx/compose/ui/Modifier;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Modifier invoke(Modifier p0, AspectRatio p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return AspectRatioKt.aspectRatio(p0, p1);
    }
}

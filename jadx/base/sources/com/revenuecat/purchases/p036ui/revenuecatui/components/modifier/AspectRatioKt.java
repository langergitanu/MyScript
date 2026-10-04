package com.revenuecat.purchases.p036ui.revenuecatui.components.modifier;

import androidx.compose.p004ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AspectRatio.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0001¨\u0006\u0003"}, m1599d2 = {"aspectRatio", "Landroidx/compose/ui/Modifier;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/modifier/AspectRatio;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class AspectRatioKt {
    public static final /* synthetic */ Modifier aspectRatio(Modifier modifier, AspectRatio aspectRatio) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(aspectRatio, "aspectRatio");
        return modifier.then(androidx.compose.foundation.layout.AspectRatioKt.aspectRatio(Modifier.INSTANCE, aspectRatio.getRatio(), aspectRatio.getMatchHeightConstraintsFirst()));
    }
}

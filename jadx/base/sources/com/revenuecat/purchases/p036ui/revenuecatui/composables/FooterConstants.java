package com.revenuecat.purchases.p036ui.revenuecatui.composables;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Footer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/FooterConstants;", "", "()V", "style", "Landroidx/compose/ui/text/TextStyle;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
final class FooterConstants {
    public static final FooterConstants INSTANCE = new FooterConstants();

    private FooterConstants() {
    }

    public final TextStyle style(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2026212701, "C(style)283@10857L10:Footer.kt#51odh9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2026212701, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.FooterConstants.style (Footer.kt:283)");
        }
        TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return bodySmall;
    }
}

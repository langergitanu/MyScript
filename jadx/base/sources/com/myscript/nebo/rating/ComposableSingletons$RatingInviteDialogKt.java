package com.myscript.nebo.rating;

import androidx.compose.material.IconKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.myscript.nebo.common.C6183R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: RatingInviteDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$RatingInviteDialogKt {
    public static final ComposableSingletons$RatingInviteDialogKt INSTANCE = new ComposableSingletons$RatingInviteDialogKt();
    private static Function2<Composer, Integer, Unit> lambda$1284633071 = ComposableLambdaKt.composableLambdaInstance(1284633071, false, new Function2() { // from class: com.myscript.nebo.rating.ComposableSingletons$RatingInviteDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingInviteDialogKt.lambda_1284633071$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1284633071$app_standardRelease() {
        return lambda$1284633071;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1284633071$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C214@8156L42,213@8124L189:RatingInviteDialog.kt#y4ltlv");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1284633071, i, -1, "com.myscript.nebo.rating.ComposableSingletons$RatingInviteDialogKt.lambda$1284633071.<anonymous> (RatingInviteDialog.kt:213)");
            }
            IconKt.m4300Iconww6aTOc(PainterResources_androidKt.painterResource(C6183R.drawable.ic_close, composer, 0), HTTP.CONN_CLOSE, (Modifier) null, Color.m8147copywmQWz5c$default(Color.INSTANCE.m8185getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), composer, Painter.$stable | 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}

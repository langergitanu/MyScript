package androidx.media3.p008ui.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ContentFrame.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ComposableSingletons$ContentFrameKt {
    public static final ComposableSingletons$ContentFrameKt INSTANCE = new ComposableSingletons$ContentFrameKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f2882lambda1 = ComposableLambdaKt.composableLambdaInstance(1121364498, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.media3.ui.compose.ComposableSingletons$ContentFrameKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C56@2487L51:ContentFrame.kt#gavle6");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1121364498, i, -1, "androidx.media3.ui.compose.ComposableSingletons$ContentFrameKt.lambda-1.<anonymous> (ContentFrame.kt:56)");
            }
            BoxKt.Box(BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m8174getBlack0d7_KjU(), null, 2, null), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$lib_ui_compose_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11709getLambda1$lib_ui_compose_release() {
        return f2882lambda1;
    }
}

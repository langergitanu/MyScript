package com.myscript.android.utils;

import androidx.compose.material.MaterialThemeKt;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.p004ui.platform.ViewCompositionStrategy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComposeViewManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, m1599d2 = {"Lcom/myscript/android/utils/ComposeViewManager;", "", "<init>", "()V", "setComposableContent", "", "Landroidx/compose/ui/platform/ComposeView;", FirebaseAnalytics.Param.CONTENT, "Lcom/myscript/android/utils/ComposeViewManager$ComposableProvider;", "ComposableProvider", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposeViewManager {
    public static final int $stable = 0;
    public static final ComposeViewManager INSTANCE = new ComposeViewManager();

    /* JADX INFO: compiled from: ComposeViewManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\r\u0010\u0002\u001a\u00020\u0003H'¢\u0006\u0002\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/android/utils/ComposeViewManager$ComposableProvider;", "", "ProvideComposableContent", "", "(Landroidx/compose/runtime/Composer;I)V", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface ComposableProvider {
        void ProvideComposableContent(Composer composer, int i);
    }

    private ComposeViewManager() {
    }

    public final void setComposableContent(ComposeView composeView, final ComposableProvider content) {
        Intrinsics.checkNotNullParameter(composeView, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(216355311, true, new Function2() { // from class: com.myscript.android.utils.ComposeViewManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ComposeViewManager.setComposableContent$lambda$0(content, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setComposableContent$lambda$0(final ComposableProvider composableProvider, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C17@569L66,17@555L80:ComposeViewManager.kt#ryeda0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(216355311, i, -1, "com.myscript.android.utils.ComposeViewManager.setComposableContent.<anonymous> (ComposeViewManager.kt:17)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableLambdaKt.rememberComposableLambda(-1051336253, true, new Function2() { // from class: com.myscript.android.utils.ComposeViewManager$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeViewManager.setComposableContent$lambda$0$0(composableProvider, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setComposableContent$lambda$0$0(ComposableProvider composableProvider, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C18@595L26:ComposeViewManager.kt#ryeda0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1051336253, i, -1, "com.myscript.android.utils.ComposeViewManager.setComposableContent.<anonymous>.<anonymous> (ComposeViewManager.kt:18)");
            }
            composableProvider.ProvideComposableContent(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}

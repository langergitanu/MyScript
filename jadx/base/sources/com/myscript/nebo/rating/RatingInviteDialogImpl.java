package com.myscript.nebo.rating;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.myscript.android.utils.ComposeViewManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RatingInviteDialogImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0006H\u0017¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/rating/RatingInviteDialogImpl;", "Lcom/myscript/android/utils/ComposeViewManager$ComposableProvider;", "origin", "", "onDismiss", "Lkotlin/Function0;", "", "onFeedbackClick", "onLoveClick", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "ProvideComposableContent", "(Landroidx/compose/runtime/Composer;I)V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RatingInviteDialogImpl implements ComposeViewManager.ComposableProvider {
    public static final int $stable = 0;
    private final Function0<Unit> onDismiss;
    private final Function0<Unit> onFeedbackClick;
    private final Function0<Unit> onLoveClick;
    private final String origin;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvideComposableContent$lambda$0(RatingInviteDialogImpl ratingInviteDialogImpl, int i, Composer composer, int i2) {
        ratingInviteDialogImpl.ProvideComposableContent(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public RatingInviteDialogImpl(String origin, Function0<Unit> onDismiss, Function0<Unit> onFeedbackClick, Function0<Unit> onLoveClick) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onFeedbackClick, "onFeedbackClick");
        Intrinsics.checkNotNullParameter(onLoveClick, "onLoveClick");
        this.origin = origin;
        this.onDismiss = onDismiss;
        this.onFeedbackClick = onFeedbackClick;
        this.onLoveClick = onLoveClick;
    }

    @Override // com.myscript.android.utils.ComposeViewManager.ComposableProvider
    public void ProvideComposableContent(Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1515200878);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvideComposableContent)15@476L67:RatingInviteDialogImpl.kt#y4ltlv");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1515200878, i2, -1, "com.myscript.nebo.rating.RatingInviteDialogImpl.ProvideComposableContent (RatingInviteDialogImpl.kt:14)");
            }
            RatingInviteDialogKt.RatingInviteDialog(this.origin, this.onDismiss, this.onFeedbackClick, this.onLoveClick, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.rating.RatingInviteDialogImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RatingInviteDialogImpl.ProvideComposableContent$lambda$0(this.f$0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

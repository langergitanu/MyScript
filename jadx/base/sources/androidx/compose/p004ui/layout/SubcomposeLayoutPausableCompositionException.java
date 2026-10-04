package androidx.compose.p004ui.layout;

import androidx.collection.IntList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SubcomposeLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutPausableCompositionException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "operations", "Landroidx/collection/IntList;", "slotId", "", "cause", "", "<init>", "(Landroidx/collection/IntList;Ljava/lang/Object;Ljava/lang/Throwable;)V", "operationsList", "", "", "message", "getMessage$annotations", "()V", "getMessage", "()Ljava/lang/String;", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class SubcomposeLayoutPausableCompositionException extends IllegalStateException {
    private final IntList operations;
    private final Object slotId;

    public static /* synthetic */ void getMessage$annotations() {
    }

    public SubcomposeLayoutPausableCompositionException(IntList intList, Object obj, Throwable th) {
        super(th);
        this.operations = intList;
        this.slotId = obj;
    }

    private final List<String> operationsList() {
        String str;
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        for (int i = this.operations._size - 1; i >= 0; i--) {
            int i2 = this.operations.get(i);
            int iM9708constructorimpl = SLOperation.m9708constructorimpl(i2);
            if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9715getCancelPausedPrecompositionNjRlDlw())) {
                str = "CancelPausedPrecomposition";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9721getReuseForceSyncDeactivationNjRlDlw())) {
                str = "ReuseForceSyncDeactivation";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9722getReuseScheduleOutOfFrameDeactivationNjRlDlw())) {
                str = "ReuseScheduleOutOfFrameDeactivation";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9723getReuseSyncDeactivationNjRlDlw())) {
                str = "ReuseSyncDeactivation";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9720getReuseDeactivationViaHostNjRlDlw())) {
                str = "ReuseDeactivationViaHost";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9731getTookFromPrecomposeMapNjRlDlw())) {
                str = "TookFromPrecomposeMap";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9727getSubcomposeNjRlDlw())) {
                str = "Subcompose";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9729getSubcomposeNewNjRlDlw())) {
                str = "SubcomposeNew";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9730getSubcomposePausableNjRlDlw())) {
                str = "SubcomposePausable";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9728getSubcomposeForceReuseNjRlDlw())) {
                str = "SubcomposeForceReuse";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9716getDeactivateOutOfFrameNjRlDlw())) {
                str = "DeactivateOutOfFrame";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9717getDeactivateOutOfFrameCancelledNjRlDlw())) {
                str = "DeactivateOutOfFrameCancelled";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9725getSlotToReusedFromOnDeactivateNjRlDlw())) {
                str = "SlotToReusedFromOnDeactivate";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9726getSlotToReusedFromOnReuseNjRlDlw())) {
                str = "SlotToReusedFromOnReuse";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9724getReusedNjRlDlw())) {
                str = "Reused";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9719getResumePausedNjRlDlw())) {
                str = "ResumePaused";
            } else if (SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9718getPausePausedNjRlDlw())) {
                str = "PausePaused";
            } else {
                str = SLOperation.m9710equalsimpl0(iM9708constructorimpl, SLOperation.INSTANCE.m9714getApplyPausedNjRlDlw()) ? "ApplyPaused" : "Unexpected " + i2;
            }
            listCreateListBuilder.add(i + ": " + str);
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return StringsKt.trimMargin$default("\n            |slotid=" + this.slotId + ". Last operations:\n            |" + CollectionsKt.joinToString$default(operationsList(), "\n", null, null, 0, null, null, 62, null) + "\n            ", null, 1, null);
    }
}

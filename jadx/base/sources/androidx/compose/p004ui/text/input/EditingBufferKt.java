package androidx.compose.p004ui.text.input;

import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: EditingBuffer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m10628updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM10449getLengthimpl;
        int iM10451getMinimpl = TextRange.m10451getMinimpl(j);
        int iM10450getMaximpl = TextRange.m10450getMaximpl(j);
        if (TextRange.m10455intersects5zctL8(j2, j)) {
            if (TextRange.m10443contains5zctL8(j2, j)) {
                iM10451getMinimpl = TextRange.m10451getMinimpl(j2);
                iM10450getMaximpl = iM10451getMinimpl;
            } else {
                if (TextRange.m10443contains5zctL8(j, j2)) {
                    iM10449getLengthimpl = TextRange.m10449getLengthimpl(j2);
                } else if (TextRange.m10444containsimpl(j2, iM10451getMinimpl)) {
                    iM10451getMinimpl = TextRange.m10451getMinimpl(j2);
                    iM10449getLengthimpl = TextRange.m10449getLengthimpl(j2);
                } else {
                    iM10450getMaximpl = TextRange.m10451getMinimpl(j2);
                }
                iM10450getMaximpl -= iM10449getLengthimpl;
            }
        } else if (iM10450getMaximpl > TextRange.m10451getMinimpl(j2)) {
            iM10451getMinimpl -= TextRange.m10449getLengthimpl(j2);
            iM10449getLengthimpl = TextRange.m10449getLengthimpl(j2);
            iM10450getMaximpl -= iM10449getLengthimpl;
        }
        return TextRangeKt.TextRange(iM10451getMinimpl, iM10450getMaximpl);
    }
}

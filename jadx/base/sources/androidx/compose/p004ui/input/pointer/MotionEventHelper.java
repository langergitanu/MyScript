package androidx.compose.p004ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.p004ui.geometry.Offset;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: MotionEventAdapter.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Landroidx/compose/ui/input/pointer/MotionEventHelper;", "", "<init>", "()V", "toRawOffset", "Landroidx/compose/ui/geometry/Offset;", "motionEvent", "Landroid/view/MotionEvent;", FirebaseAnalytics.Param.INDEX, "", "toRawOffset-dBAh8RU", "(Landroid/view/MotionEvent;I)J", "ui"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class MotionEventHelper {
    public static final MotionEventHelper INSTANCE = new MotionEventHelper();

    private MotionEventHelper() {
    }

    /* JADX INFO: renamed from: toRawOffset-dBAh8RU, reason: not valid java name */
    public final long m9414toRawOffsetdBAh8RU(MotionEvent motionEvent, int index) {
        float rawX = motionEvent.getRawX(index);
        return Offset.m7895constructorimpl((((long) Float.floatToRawIntBits(motionEvent.getRawY(index))) & 4294967295L) | (Float.floatToRawIntBits(rawX) << 32));
    }
}

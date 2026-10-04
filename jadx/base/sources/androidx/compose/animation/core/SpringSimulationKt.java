package androidx.compose.animation.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: SpringSimulation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m1599d2 = {TypedValues.MotionType.NAME, "Landroidx/compose/animation/core/Motion;", "value", "", "velocity", "(FF)J", "animation-core"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SpringSimulationKt {
    public static final long Motion(float f, float f2) {
        return Motion.m1926constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }
}

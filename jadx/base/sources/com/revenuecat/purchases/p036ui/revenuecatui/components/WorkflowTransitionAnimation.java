package com.revenuecat.purchases.p036ui.revenuecatui.components;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkflowTransitionAnimation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionAnimation;", "", "()V", "SlideInOut", "Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionAnimation$SlideInOut;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class WorkflowTransitionAnimation {
    public static final int $stable = 0;

    public /* synthetic */ WorkflowTransitionAnimation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private WorkflowTransitionAnimation() {
    }

    /* JADX INFO: compiled from: WorkflowTransitionAnimation.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionAnimation$SlideInOut;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionAnimation;", "durationMs", "", "easing", "Landroidx/compose/animation/core/Easing;", "(ILandroidx/compose/animation/core/Easing;)V", "getDurationMs", "()I", "getEasing", "()Landroidx/compose/animation/core/Easing;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class SlideInOut extends WorkflowTransitionAnimation {
        public static final int $stable = 0;
        private final int durationMs;
        private final Easing easing;

        /* JADX WARN: Multi-variable type inference failed */
        public SlideInOut() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SlideInOut copy$default(SlideInOut slideInOut, int i, Easing easing, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = slideInOut.durationMs;
            }
            if ((i2 & 2) != 0) {
                easing = slideInOut.easing;
            }
            return slideInOut.copy(i, easing);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDurationMs() {
            return this.durationMs;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Easing getEasing() {
            return this.easing;
        }

        public final SlideInOut copy(int durationMs, Easing easing) {
            Intrinsics.checkNotNullParameter(easing, "easing");
            return new SlideInOut(durationMs, easing);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SlideInOut)) {
                return false;
            }
            SlideInOut slideInOut = (SlideInOut) other;
            return this.durationMs == slideInOut.durationMs && Intrinsics.areEqual(this.easing, slideInOut.easing);
        }

        public int hashCode() {
            return (Integer.hashCode(this.durationMs) * 31) + this.easing.hashCode();
        }

        public String toString() {
            return "SlideInOut(durationMs=" + this.durationMs + ", easing=" + this.easing + ')';
        }

        public final int getDurationMs() {
            return this.durationMs;
        }

        public /* synthetic */ SlideInOut(int i, Easing easing, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? WorkflowTransitionState.SLIDE_DURATION_MS : i, (i2 & 2) != 0 ? EasingKt.getFastOutSlowInEasing() : easing);
        }

        public final Easing getEasing() {
            return this.easing;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SlideInOut(int i, Easing easing) {
            super(null);
            Intrinsics.checkNotNullParameter(easing, "easing");
            this.durationMs = i;
            this.easing = easing;
        }
    }
}

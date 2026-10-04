package com.revenuecat.purchases.p036ui.revenuecatui.checkpoints;

import com.revenuecat.purchases.checkpoints.CheckpointResolution;
import com.revenuecat.purchases.p036ui.revenuecatui.checkpoints.CheckpointResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: CheckpointsManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m1599d2 = {"toResultReason", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult$NoAction$Reason;", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$NoAction$Reason;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CheckpointsManagerKt {

    /* JADX INFO: compiled from: CheckpointsManager.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CheckpointResolution.NoAction.Reason.values().length];
            try {
                iArr[CheckpointResolution.NoAction.Reason.NO_MATCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CheckpointResolution.NoAction.Reason.CONFIGURATION_UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CheckpointResolution.NoAction.Reason.UNKNOWN_CHECKPOINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CheckpointResult.NoAction.Reason toResultReason(CheckpointResolution.NoAction.Reason reason) {
        int i = WhenMappings.$EnumSwitchMapping$0[reason.ordinal()];
        if (i == 1) {
            return CheckpointResult.NoAction.Reason.NO_MATCH;
        }
        if (i == 2) {
            return CheckpointResult.NoAction.Reason.CONFIGURATION_UNAVAILABLE;
        }
        if (i == 3) {
            return CheckpointResult.NoAction.Reason.UNKNOWN_CHECKPOINT;
        }
        throw new NoWhenBranchMatchedException();
    }
}

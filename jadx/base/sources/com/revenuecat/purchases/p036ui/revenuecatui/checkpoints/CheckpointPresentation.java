package com.revenuecat.purchases.p036ui.revenuecatui.checkpoints;

import com.revenuecat.purchases.checkpoints.CheckpointResolution;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckpointsManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPresentation;", "", "resolution", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$MatchedWorkflow;", "customVariables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$MatchedWorkflow;Ljava/util/Map;)V", "getCustomVariables", "()Ljava/util/Map;", "getResolution", "()Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$MatchedWorkflow;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CheckpointPresentation {
    public static final int $stable = 8;
    private final Map<String, CustomVariableValue> customVariables;
    private final CheckpointResolution.MatchedWorkflow resolution;

    /* JADX WARN: Multi-variable type inference failed */
    public CheckpointPresentation(CheckpointResolution.MatchedWorkflow resolution, Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        this.resolution = resolution;
        this.customVariables = customVariables;
    }

    public final CheckpointResolution.MatchedWorkflow getResolution() {
        return this.resolution;
    }

    public final Map<String, CustomVariableValue> getCustomVariables() {
        return this.customVariables;
    }
}

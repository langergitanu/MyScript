package com.revenuecat.purchases.p036ui.revenuecatui.checkpoints;

import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckpointListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointHitContext;", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointContext;", Keys.IDENTIFIER, "", "customVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Ljava/lang/String;Ljava/util/Map;)V", "getCustomVariables", "()Ljava/util/Map;", "getIdentifier", "()Ljava/lang/String;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CheckpointHitContext extends CheckpointContext {
    public static final int $stable = 8;
    private final Map<String, CustomVariableValue> customVariables;
    private final String identifier;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckpointHitContext)) {
            return false;
        }
        CheckpointHitContext checkpointHitContext = (CheckpointHitContext) obj;
        return Intrinsics.areEqual(this.identifier, checkpointHitContext.identifier) && Intrinsics.areEqual(this.customVariables, checkpointHitContext.customVariables);
    }

    public int hashCode() {
        return (this.identifier.hashCode() * 31) + this.customVariables.hashCode();
    }

    public String toString() {
        return "CheckpointHitContext(identifier=" + this.identifier + ", customVariables=" + this.customVariables + ')';
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.checkpoints.CheckpointContext
    public String getIdentifier() {
        return this.identifier;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.checkpoints.CheckpointContext
    public Map<String, CustomVariableValue> getCustomVariables() {
        return this.customVariables;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CheckpointHitContext(String identifier, Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        this.identifier = identifier;
        this.customVariables = customVariables;
    }
}

package com.myscript.nebo.penpanel;

import com.myscript.snt.core.ToolConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToolbarViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolPill;", "", "displayedColor", "", "toolConfiguration", "Lcom/myscript/snt/core/ToolConfiguration;", "<init>", "(ILcom/myscript/snt/core/ToolConfiguration;)V", "getDisplayedColor", "()I", "getToolConfiguration", "()Lcom/myscript/snt/core/ToolConfiguration;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ToolPill {
    private final int displayedColor;
    private final ToolConfiguration toolConfiguration;

    public static /* synthetic */ ToolPill copy$default(ToolPill toolPill, int i, ToolConfiguration toolConfiguration, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = toolPill.displayedColor;
        }
        if ((i2 & 2) != 0) {
            toolConfiguration = toolPill.toolConfiguration;
        }
        return toolPill.copy(i, toolConfiguration);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDisplayedColor() {
        return this.displayedColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ToolConfiguration getToolConfiguration() {
        return this.toolConfiguration;
    }

    public final ToolPill copy(int displayedColor, ToolConfiguration toolConfiguration) {
        Intrinsics.checkNotNullParameter(toolConfiguration, "toolConfiguration");
        return new ToolPill(displayedColor, toolConfiguration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolPill)) {
            return false;
        }
        ToolPill toolPill = (ToolPill) other;
        return this.displayedColor == toolPill.displayedColor && Intrinsics.areEqual(this.toolConfiguration, toolPill.toolConfiguration);
    }

    public int hashCode() {
        return (Integer.hashCode(this.displayedColor) * 31) + this.toolConfiguration.hashCode();
    }

    public String toString() {
        return "ToolPill(displayedColor=" + this.displayedColor + ", toolConfiguration=" + this.toolConfiguration + ")";
    }

    public ToolPill(int i, ToolConfiguration toolConfiguration) {
        Intrinsics.checkNotNullParameter(toolConfiguration, "toolConfiguration");
        this.displayedColor = i;
        this.toolConfiguration = toolConfiguration;
    }

    public final int getDisplayedColor() {
        return this.displayedColor;
    }

    public final ToolConfiguration getToolConfiguration() {
        return this.toolConfiguration;
    }
}

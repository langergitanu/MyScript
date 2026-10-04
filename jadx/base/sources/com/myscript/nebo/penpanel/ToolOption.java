package com.myscript.nebo.penpanel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOption;", "", "iconRes", "", "labelRes", "propertyKey", "", "propertyValue", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "getIconRes", "()I", "getLabelRes", "getPropertyKey", "()Ljava/lang/String;", "getPropertyValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ToolOption {
    private final int iconRes;
    private final int labelRes;
    private final String propertyKey;
    private final String propertyValue;

    public static /* synthetic */ ToolOption copy$default(ToolOption toolOption, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = toolOption.iconRes;
        }
        if ((i3 & 2) != 0) {
            i2 = toolOption.labelRes;
        }
        if ((i3 & 4) != 0) {
            str = toolOption.propertyKey;
        }
        if ((i3 & 8) != 0) {
            str2 = toolOption.propertyValue;
        }
        return toolOption.copy(i, i2, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLabelRes() {
        return this.labelRes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPropertyKey() {
        return this.propertyKey;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPropertyValue() {
        return this.propertyValue;
    }

    public final ToolOption copy(int iconRes, int labelRes, String propertyKey, String propertyValue) {
        Intrinsics.checkNotNullParameter(propertyKey, "propertyKey");
        Intrinsics.checkNotNullParameter(propertyValue, "propertyValue");
        return new ToolOption(iconRes, labelRes, propertyKey, propertyValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolOption)) {
            return false;
        }
        ToolOption toolOption = (ToolOption) other;
        return this.iconRes == toolOption.iconRes && this.labelRes == toolOption.labelRes && Intrinsics.areEqual(this.propertyKey, toolOption.propertyKey) && Intrinsics.areEqual(this.propertyValue, toolOption.propertyValue);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.iconRes) * 31) + Integer.hashCode(this.labelRes)) * 31) + this.propertyKey.hashCode()) * 31) + this.propertyValue.hashCode();
    }

    public String toString() {
        return "ToolOption(iconRes=" + this.iconRes + ", labelRes=" + this.labelRes + ", propertyKey=" + this.propertyKey + ", propertyValue=" + this.propertyValue + ")";
    }

    public ToolOption(int i, int i2, String propertyKey, String propertyValue) {
        Intrinsics.checkNotNullParameter(propertyKey, "propertyKey");
        Intrinsics.checkNotNullParameter(propertyValue, "propertyValue");
        this.iconRes = i;
        this.labelRes = i2;
        this.propertyKey = propertyKey;
        this.propertyValue = propertyValue;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getLabelRes() {
        return this.labelRes;
    }

    public final String getPropertyKey() {
        return this.propertyKey;
    }

    public final String getPropertyValue() {
        return this.propertyValue;
    }
}

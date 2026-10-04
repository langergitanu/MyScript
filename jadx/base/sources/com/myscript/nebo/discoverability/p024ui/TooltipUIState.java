package com.myscript.nebo.discoverability.p024ui;

import com.myscript.nebo.discoverability.IDiscoverableFeature;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TooltipUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001-BS\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010&\u001a\u00020\u000eHÆ\u0003J[\u0010'\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0014\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010+\u001a\u00020,HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "", "title", "", "message", "illustration", "Lcom/myscript/nebo/discoverability/ui/TooltipIllustration;", "id", "type", "Lcom/myscript/nebo/discoverability/ui/TooltipType;", "visible", "", "userData", "toolTipPosition", "Lcom/myscript/nebo/discoverability/ui/TooltipPosition;", "<init>", "(IILcom/myscript/nebo/discoverability/ui/TooltipIllustration;ILcom/myscript/nebo/discoverability/ui/TooltipType;ZLjava/lang/Object;Lcom/myscript/nebo/discoverability/ui/TooltipPosition;)V", "getTitle", "()I", "getMessage", "getIllustration", "()Lcom/myscript/nebo/discoverability/ui/TooltipIllustration;", "getId", "getType", "()Lcom/myscript/nebo/discoverability/ui/TooltipType;", "getVisible", "()Z", "getUserData", "()Ljava/lang/Object;", "getToolTipPosition", "()Lcom/myscript/nebo/discoverability/ui/TooltipPosition;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "Provider", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class TooltipUIState {
    public static final int $stable = 8;
    private final int id;
    private final TooltipIllustration illustration;
    private final int message;
    private final int title;
    private final TooltipPosition toolTipPosition;
    private final TooltipType type;
    private final Object userData;
    private final boolean visible;

    /* JADX INFO: compiled from: TooltipUIState.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/TooltipUIState$Provider;", "", "provideFeatureToTooltipState", "Lkotlin/Function1;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        Function1<IDiscoverableFeature, TooltipUIState> provideFeatureToTooltipState();
    }

    public static /* synthetic */ TooltipUIState copy$default(TooltipUIState tooltipUIState, int i, int i2, TooltipIllustration tooltipIllustration, int i3, TooltipType tooltipType, boolean z, Object obj, TooltipPosition tooltipPosition, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            i = tooltipUIState.title;
        }
        if ((i4 & 2) != 0) {
            i2 = tooltipUIState.message;
        }
        if ((i4 & 4) != 0) {
            tooltipIllustration = tooltipUIState.illustration;
        }
        if ((i4 & 8) != 0) {
            i3 = tooltipUIState.id;
        }
        if ((i4 & 16) != 0) {
            tooltipType = tooltipUIState.type;
        }
        if ((i4 & 32) != 0) {
            z = tooltipUIState.visible;
        }
        if ((i4 & 64) != 0) {
            obj = tooltipUIState.userData;
        }
        if ((i4 & 128) != 0) {
            tooltipPosition = tooltipUIState.toolTipPosition;
        }
        Object obj3 = obj;
        TooltipPosition tooltipPosition2 = tooltipPosition;
        TooltipType tooltipType2 = tooltipType;
        boolean z2 = z;
        return tooltipUIState.copy(i, i2, tooltipIllustration, i3, tooltipType2, z2, obj3, tooltipPosition2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TooltipIllustration getIllustration() {
        return this.illustration;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final TooltipType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Object getUserData() {
        return this.userData;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final TooltipPosition getToolTipPosition() {
        return this.toolTipPosition;
    }

    public final TooltipUIState copy(int title, int message, TooltipIllustration illustration, int id, TooltipType type, boolean visible, Object userData, TooltipPosition toolTipPosition) {
        Intrinsics.checkNotNullParameter(illustration, "illustration");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(toolTipPosition, "toolTipPosition");
        return new TooltipUIState(title, message, illustration, id, type, visible, userData, toolTipPosition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TooltipUIState)) {
            return false;
        }
        TooltipUIState tooltipUIState = (TooltipUIState) other;
        return this.title == tooltipUIState.title && this.message == tooltipUIState.message && Intrinsics.areEqual(this.illustration, tooltipUIState.illustration) && this.id == tooltipUIState.id && this.type == tooltipUIState.type && this.visible == tooltipUIState.visible && Intrinsics.areEqual(this.userData, tooltipUIState.userData) && this.toolTipPosition == tooltipUIState.toolTipPosition;
    }

    public int hashCode() {
        int iHashCode = ((((((((((Integer.hashCode(this.title) * 31) + Integer.hashCode(this.message)) * 31) + this.illustration.hashCode()) * 31) + Integer.hashCode(this.id)) * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.visible)) * 31;
        Object obj = this.userData;
        return ((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31) + this.toolTipPosition.hashCode();
    }

    public String toString() {
        return "TooltipUIState(title=" + this.title + ", message=" + this.message + ", illustration=" + this.illustration + ", id=" + this.id + ", type=" + this.type + ", visible=" + this.visible + ", userData=" + this.userData + ", toolTipPosition=" + this.toolTipPosition + ")";
    }

    public TooltipUIState(int i, int i2, TooltipIllustration illustration, int i3, TooltipType type, boolean z, Object obj, TooltipPosition toolTipPosition) {
        Intrinsics.checkNotNullParameter(illustration, "illustration");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(toolTipPosition, "toolTipPosition");
        this.title = i;
        this.message = i2;
        this.illustration = illustration;
        this.id = i3;
        this.type = type;
        this.visible = z;
        this.userData = obj;
        this.toolTipPosition = toolTipPosition;
    }

    public final int getTitle() {
        return this.title;
    }

    public final int getMessage() {
        return this.message;
    }

    public final TooltipIllustration getIllustration() {
        return this.illustration;
    }

    public final int getId() {
        return this.id;
    }

    public final TooltipType getType() {
        return this.type;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final Object getUserData() {
        return this.userData;
    }

    public /* synthetic */ TooltipUIState(int i, int i2, TooltipIllustration tooltipIllustration, int i3, TooltipType tooltipType, boolean z, Object obj, TooltipPosition tooltipPosition, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, tooltipIllustration, i3, tooltipType, (i4 & 32) != 0 ? false : z, (i4 & 64) != 0 ? null : obj, (i4 & 128) != 0 ? TooltipPosition.Auto : tooltipPosition);
    }

    public final TooltipPosition getToolTipPosition() {
        return this.toolTipPosition;
    }
}

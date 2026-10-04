package com.revenuecat.purchases.p036ui.revenuecatui.components;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResultKt;
import com.revenuecat.purchases.paywalls.components.PartialTimelineComponentItem;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PresentedTimelinePartial.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0000H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTimelineItemPartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "partial", "Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponentItem;", "connectorStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;", "(Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponentItem;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;)V", "getConnectorStyle", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;", "getPartial", "()Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponentItem;", "combine", "with", "Companion", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PresentedTimelineItemPartial implements PresentedPartial<PresentedTimelineItemPartial> {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final TimelineComponentStyle.ConnectorStyle connectorStyle;
    private final PartialTimelineComponentItem partial;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentedTimelineItemPartial)) {
            return false;
        }
        PresentedTimelineItemPartial presentedTimelineItemPartial = (PresentedTimelineItemPartial) obj;
        return Intrinsics.areEqual(this.partial, presentedTimelineItemPartial.partial) && Intrinsics.areEqual(this.connectorStyle, presentedTimelineItemPartial.connectorStyle);
    }

    public int hashCode() {
        int iHashCode = this.partial.hashCode() * 31;
        TimelineComponentStyle.ConnectorStyle connectorStyle = this.connectorStyle;
        return iHashCode + (connectorStyle == null ? 0 : connectorStyle.hashCode());
    }

    public String toString() {
        return "PresentedTimelineItemPartial(partial=" + this.partial + ", connectorStyle=" + this.connectorStyle + ')';
    }

    public PresentedTimelineItemPartial(PartialTimelineComponentItem partial, TimelineComponentStyle.ConnectorStyle connectorStyle) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.partial = partial;
        this.connectorStyle = connectorStyle;
    }

    public final /* synthetic */ PartialTimelineComponentItem getPartial() {
        return this.partial;
    }

    public final /* synthetic */ TimelineComponentStyle.ConnectorStyle getConnectorStyle() {
        return this.connectorStyle;
    }

    /* JADX INFO: compiled from: PresentedTimelinePartial.kt */
    @Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0086\u0002¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTimelineItemPartial$Companion;", "", "()V", "invoke", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTimelineItemPartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", TypedValues.TransitionType.S_FROM, "Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponentItem;", "aliases", "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ Result invoke(PartialTimelineComponentItem from, Map aliases) {
            ColorScheme color;
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(aliases, "aliases");
            TimelineComponent.Connector connector = from.getConnector();
            TimelineComponentStyle.ConnectorStyle connectorStyle = null;
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull((connector == null || (color = connector.getColor()) == null) ? null : ColorStyleKt.toColorStyles(color, aliases));
            if (resultOrSuccessfullyNull instanceof Result.Success) {
                ColorStyles colorStyles = (ColorStyles) ((Result.Success) resultOrSuccessfullyNull).getValue();
                TimelineComponent.Connector connector2 = from.getConnector();
                if (connector2 != null && colorStyles != null) {
                    connectorStyle = new TimelineComponentStyle.ConnectorStyle(connector2.getWidth(), PaddingKt.toPaddingValues$default(connector2.getMargin(), false, 1, null), colorStyles);
                }
                return new Result.Success(new PresentedTimelineItemPartial(from, connectorStyle));
            }
            if (resultOrSuccessfullyNull instanceof Result.Error) {
                return resultOrSuccessfullyNull;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedPartial
    public PresentedTimelineItemPartial combine(PresentedTimelineItemPartial with) {
        Boolean visible;
        TimelineComponent.Connector connector;
        TimelineComponentStyle.ConnectorStyle connectorStyle;
        PartialTimelineComponentItem partialTimelineComponentItem = with != null ? with.partial : null;
        if (partialTimelineComponentItem == null || (visible = partialTimelineComponentItem.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        if (partialTimelineComponentItem == null || (connector = partialTimelineComponentItem.getConnector()) == null) {
            connector = this.partial.getConnector();
        }
        PartialTimelineComponentItem partialTimelineComponentItem2 = new PartialTimelineComponentItem(visible, connector);
        if (with == null || (connectorStyle = with.connectorStyle) == null) {
            connectorStyle = this.connectorStyle;
        }
        return new PresentedTimelineItemPartial(partialTimelineComponentItem2, connectorStyle);
    }
}

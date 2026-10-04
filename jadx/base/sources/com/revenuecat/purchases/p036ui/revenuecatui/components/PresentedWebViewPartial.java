package com.revenuecat.purchases.p036ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.PartialWebViewComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PresentedWebViewPartial.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0000H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedWebViewPartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "partial", "Lcom/revenuecat/purchases/paywalls/components/PartialWebViewComponent;", "(Lcom/revenuecat/purchases/paywalls/components/PartialWebViewComponent;)V", "getPartial", "()Lcom/revenuecat/purchases/paywalls/components/PartialWebViewComponent;", "combine", "with", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PresentedWebViewPartial implements PresentedPartial<PresentedWebViewPartial> {
    public static final int $stable = 0;
    private final PartialWebViewComponent partial;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PresentedWebViewPartial) && Intrinsics.areEqual(this.partial, ((PresentedWebViewPartial) obj).partial);
    }

    public int hashCode() {
        return this.partial.hashCode();
    }

    public String toString() {
        return "PresentedWebViewPartial(partial=" + this.partial + ')';
    }

    public PresentedWebViewPartial(PartialWebViewComponent partial) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.partial = partial;
    }

    public final /* synthetic */ PartialWebViewComponent getPartial() {
        return this.partial;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedPartial
    public PresentedWebViewPartial combine(PresentedWebViewPartial with) {
        Boolean visible;
        PartialWebViewComponent partialWebViewComponent = with != null ? with.partial : null;
        if (partialWebViewComponent == null || (visible = partialWebViewComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        return new PresentedWebViewPartial(new PartialWebViewComponent(visible));
    }
}

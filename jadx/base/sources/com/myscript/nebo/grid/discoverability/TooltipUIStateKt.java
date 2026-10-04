package com.myscript.nebo.grid.discoverability;

import com.myscript.nebo.C6079R;
import com.myscript.nebo.discoverability.p024ui.TooltipIllustration;
import com.myscript.nebo.discoverability.p024ui.TooltipPosition;
import com.myscript.nebo.discoverability.p024ui.TooltipType;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import com.myscript.nebo.dms.discoverability.GridDiscoverableFeature;
import com.myscript.nebo.dms.discoverability.GridDiscoverableFeatureKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TooltipUIState.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m1599d2 = {"toTooltipState", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature;", "visible", "", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TooltipUIStateKt {
    public static /* synthetic */ TooltipUIState toTooltipState$default(GridDiscoverableFeature gridDiscoverableFeature, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return toTooltipState(gridDiscoverableFeature, z);
    }

    public static final TooltipUIState toTooltipState(GridDiscoverableFeature gridDiscoverableFeature, boolean z) {
        Intrinsics.checkNotNullParameter(gridDiscoverableFeature, "<this>");
        if (gridDiscoverableFeature instanceof GridDiscoverableFeature.AddNoteFeature) {
            int i = C6079R.string.discovery_grid_add_button_title;
            int i2 = C6079R.string.discovery_grid_add_button_message;
            TooltipIllustration.DrawableIllustration drawableIllustration = new TooltipIllustration.DrawableIllustration(C6079R.drawable.tooltip_formats);
            return new TooltipUIState(i, i2, drawableIllustration, GridDiscoverableFeatureKt.getGridDiscoverableFeatures().indexOf(gridDiscoverableFeature), TooltipType.Large, z, GridDiscoverableFeature.AddNoteFeature.INSTANCE.getDestination(), TooltipPosition.Auto);
        }
        if (!(gridDiscoverableFeature instanceof GridDiscoverableFeature.SyncButtonFeature)) {
            throw new NoWhenBranchMatchedException();
        }
        int i3 = C6079R.string.discovery_grid_sync_button_title;
        int i4 = C6079R.string.discovery_grid_sync_button_message;
        TooltipIllustration.DrawableIllustration drawableIllustration2 = new TooltipIllustration.DrawableIllustration(C6079R.drawable.ic_cloud_outline);
        return new TooltipUIState(i3, i4, drawableIllustration2, GridDiscoverableFeatureKt.getGridDiscoverableFeatures().indexOf(gridDiscoverableFeature), TooltipType.Small, z, GridDiscoverableFeature.SyncButtonFeature.INSTANCE.getDestination(), TooltipPosition.Right);
    }
}

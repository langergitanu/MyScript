package com.myscript.nebo.dms.discoverability;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.discoverability.FeatureDiscoveryState;
import com.myscript.nebo.discoverability.IDiscoverableFeature;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GridDiscoverableFeature.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\f\r¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature;", "", "<init>", "()V", FirebaseAnalytics.Param.DESTINATION, "Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature$DiscoverableFeatureDestination;", "getDestination", "()Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature$DiscoverableFeatureDestination;", "DiscoverableFeatureDestination", "AddNoteFeature", "SyncButtonFeature", "Companion", "Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature$AddNoteFeature;", "Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature$SyncButtonFeature;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class GridDiscoverableFeature {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DiscoverableFeatureDestination destination;

    public /* synthetic */ GridDiscoverableFeature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GridDiscoverableFeature() {
        this.destination = DiscoverableFeatureDestination.MAIN_FRAGMENT;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: GridDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature$DiscoverableFeatureDestination;", "", "<init>", "(Ljava/lang/String;I)V", "DMS_LIST_FRAGMENT", "MAIN_FRAGMENT", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DiscoverableFeatureDestination {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DiscoverableFeatureDestination[] $VALUES;
        public static final DiscoverableFeatureDestination DMS_LIST_FRAGMENT = new DiscoverableFeatureDestination("DMS_LIST_FRAGMENT", 0);
        public static final DiscoverableFeatureDestination MAIN_FRAGMENT = new DiscoverableFeatureDestination("MAIN_FRAGMENT", 1);

        private static final /* synthetic */ DiscoverableFeatureDestination[] $values() {
            return new DiscoverableFeatureDestination[]{DMS_LIST_FRAGMENT, MAIN_FRAGMENT};
        }

        public static EnumEntries<DiscoverableFeatureDestination> getEntries() {
            return $ENTRIES;
        }

        public static DiscoverableFeatureDestination valueOf(String str) {
            return (DiscoverableFeatureDestination) Enum.valueOf(DiscoverableFeatureDestination.class, str);
        }

        public static DiscoverableFeatureDestination[] values() {
            return (DiscoverableFeatureDestination[]) $VALUES.clone();
        }

        private DiscoverableFeatureDestination(String str, int i) {
        }

        static {
            DiscoverableFeatureDestination[] discoverableFeatureDestinationArr$values = $values();
            $VALUES = discoverableFeatureDestinationArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(discoverableFeatureDestinationArr$values);
        }
    }

    public DiscoverableFeatureDestination getDestination() {
        return this.destination;
    }

    /* JADX INFO: compiled from: GridDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature$AddNoteFeature;", "Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class AddNoteFeature extends GridDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final AddNoteFeature INSTANCE = new AddNoteFeature();
        private static final String discoveryKey = "is_add_note_feature_discovered";
        private static final int minimumSessionCount = 0;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddNoteFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -70754283;
        }

        public String toString() {
            return "AddNoteFeature";
        }

        private AddNoteFeature() {
            super(null);
        }

        @Override // com.myscript.nebo.discoverability.IDiscoverableFeature
        public /* bridge */ String getPrerequisiteKey() {
            return super.getPrerequisiteKey();
        }

        @Override // com.myscript.nebo.discoverability.IDiscoverableFeature
        public String getDiscoveryKey() {
            return discoveryKey;
        }

        @Override // com.myscript.nebo.discoverability.IDiscoverableFeature
        public int getMinimumSessionCount() {
            return minimumSessionCount;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // com.myscript.nebo.discoverability.IDiscoverableFeature
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object needsDiscovery(FeatureDiscoveryState featureDiscoveryState, Continuation<? super Boolean> continuation) {
            GridDiscoverableFeature$AddNoteFeature$needsDiscovery$1 gridDiscoverableFeature$AddNoteFeature$needsDiscovery$1;
            if (continuation instanceof GridDiscoverableFeature$AddNoteFeature$needsDiscovery$1) {
                gridDiscoverableFeature$AddNoteFeature$needsDiscovery$1 = (GridDiscoverableFeature$AddNoteFeature$needsDiscovery$1) continuation;
                if ((gridDiscoverableFeature$AddNoteFeature$needsDiscovery$1.label & Integer.MIN_VALUE) != 0) {
                    gridDiscoverableFeature$AddNoteFeature$needsDiscovery$1.label -= Integer.MIN_VALUE;
                } else {
                    gridDiscoverableFeature$AddNoteFeature$needsDiscovery$1 = new GridDiscoverableFeature$AddNoteFeature$needsDiscovery$1(this, continuation);
                }
            }
            Object objIsDiscovered = gridDiscoverableFeature$AddNoteFeature$needsDiscovery$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = gridDiscoverableFeature$AddNoteFeature$needsDiscovery$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscovered);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    gridDiscoverableFeature$AddNoteFeature$needsDiscovery$1.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                    gridDiscoverableFeature$AddNoteFeature$needsDiscovery$1.label = 1;
                    objIsDiscovered = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, gridDiscoverableFeature$AddNoteFeature$needsDiscovery$1);
                    if (objIsDiscovered == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Boxing.boxBoolean(z);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objIsDiscovered);
            boolean z = ((Boolean) objIsDiscovered).booleanValue() ? false : true;
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: compiled from: GridDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature$SyncButtonFeature;", "Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", FirebaseAnalytics.Param.DESTINATION, "Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature$DiscoverableFeatureDestination;", "getDestination", "()Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature$DiscoverableFeatureDestination;", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SyncButtonFeature extends GridDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final SyncButtonFeature INSTANCE = new SyncButtonFeature();
        private static final String discoveryKey = "is_sync_button_feature_discovered";
        private static final int minimumSessionCount = 2;
        private static final DiscoverableFeatureDestination destination = DiscoverableFeatureDestination.DMS_LIST_FRAGMENT;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SyncButtonFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1638109577;
        }

        public String toString() {
            return "SyncButtonFeature";
        }

        private SyncButtonFeature() {
            super(null);
        }

        @Override // com.myscript.nebo.discoverability.IDiscoverableFeature
        public /* bridge */ String getPrerequisiteKey() {
            return super.getPrerequisiteKey();
        }

        @Override // com.myscript.nebo.discoverability.IDiscoverableFeature
        public String getDiscoveryKey() {
            return discoveryKey;
        }

        @Override // com.myscript.nebo.discoverability.IDiscoverableFeature
        public int getMinimumSessionCount() {
            return minimumSessionCount;
        }

        @Override // com.myscript.nebo.dms.discoverability.GridDiscoverableFeature
        public DiscoverableFeatureDestination getDestination() {
            return destination;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // com.myscript.nebo.discoverability.IDiscoverableFeature
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object needsDiscovery(FeatureDiscoveryState featureDiscoveryState, Continuation<? super Boolean> continuation) {
            GridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1 gridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1;
            if (continuation instanceof GridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1) {
                gridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1 = (GridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1) continuation;
                if ((gridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1.label & Integer.MIN_VALUE) != 0) {
                    gridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1.label -= Integer.MIN_VALUE;
                } else {
                    gridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1 = new GridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1(this, continuation);
                }
            }
            Object objIsDiscovered = gridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = gridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscovered);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    gridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                    gridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1.label = 1;
                    objIsDiscovered = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, gridDiscoverableFeature$SyncButtonFeature$needsDiscovery$1);
                    if (objIsDiscovered == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Boxing.boxBoolean(z);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objIsDiscovered);
            boolean z = ((Boolean) objIsDiscovered).booleanValue() ? false : true;
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: compiled from: GridDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/dms/discoverability/GridDiscoverableFeature$Companion;", "", "<init>", "()V", "fromTooltipState", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "tooltipState", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IDiscoverableFeature fromTooltipState(TooltipUIState tooltipState) {
            if (tooltipState == null) {
                return null;
            }
            int size = GridDiscoverableFeatureKt.getGridDiscoverableFeatures().size();
            int id = tooltipState.getId();
            if (id < 0 || id >= size) {
                return null;
            }
            return GridDiscoverableFeatureKt.getGridDiscoverableFeatures().get(tooltipState.getId());
        }
    }
}

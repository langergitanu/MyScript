package com.myscript.nebo.editing.discoverability;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.discoverability.FeatureDiscoveryState;
import com.myscript.nebo.discoverability.IDiscoverableFeature;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u001a2\u00020\u0001:\u000f\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001aB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\r\u001b\u001c\u001d\u001e\u001f !\"#$%&'¨\u0006("}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "", "<init>", "()V", FirebaseAnalytics.Param.DESTINATION, "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$DiscoverableFeatureDestination;", "getDestination", "()Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$DiscoverableFeatureDestination;", "id", "", "getId", "()I", "DiscoverableFeatureDestination", "NotebookFeature", "BoardFeature", "DocumentFeature", "PdfFeature", "AIExplainFeature", "PenOptionsFeature", "AIQuizFeature", "PdfAddPageFeature", "PdfOptimizationFeature", "DocumentConvertTextFeature", "ConvertTextFeature", "ScratchOutGestureFeature", "ShapesFeature", "Companion", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$AIExplainFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$AIQuizFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$BoardFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$ConvertTextFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$DocumentConvertTextFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$DocumentFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$NotebookFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$PdfAddPageFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$PdfFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$PdfOptimizationFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$PenOptionsFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$ScratchOutGestureFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$ShapesFeature;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class EditingDiscoverableFeature {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DiscoverableFeatureDestination destination;

    public /* synthetic */ EditingDiscoverableFeature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private EditingDiscoverableFeature() {
        this.destination = DiscoverableFeatureDestination.MAIN_FRAGMENT;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$DiscoverableFeatureDestination;", "", "<init>", "(Ljava/lang/String;I)V", "CHILD_PAGES", "MAIN_FRAGMENT", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DiscoverableFeatureDestination {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DiscoverableFeatureDestination[] $VALUES;
        public static final DiscoverableFeatureDestination CHILD_PAGES = new DiscoverableFeatureDestination("CHILD_PAGES", 0);
        public static final DiscoverableFeatureDestination MAIN_FRAGMENT = new DiscoverableFeatureDestination("MAIN_FRAGMENT", 1);

        private static final /* synthetic */ DiscoverableFeatureDestination[] $values() {
            return new DiscoverableFeatureDestination[]{CHILD_PAGES, MAIN_FRAGMENT};
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

    /* JADX WARN: Multi-variable type inference failed */
    public final int getId() {
        List<IDiscoverableFeature> editingDiscoverableFeatures = EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures();
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.myscript.nebo.discoverability.IDiscoverableFeature");
        return CollectionsKt.indexOf((List<? extends IDiscoverableFeature>) editingDiscoverableFeatures, (IDiscoverableFeature) this);
    }

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$NotebookFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class NotebookFeature extends EditingDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final NotebookFeature INSTANCE = new NotebookFeature();
        private static final String discoveryKey = "is_notebook_feature_discovered";
        private static final int minimumSessionCount = 0;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotebookFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1425887979;
        }

        public String toString() {
            return "NotebookFeature";
        }

        private NotebookFeature() {
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
            EditingDiscoverableFeature$NotebookFeature$needsDiscovery$1 editingDiscoverableFeature$NotebookFeature$needsDiscovery$1;
            if (continuation instanceof EditingDiscoverableFeature$NotebookFeature$needsDiscovery$1) {
                editingDiscoverableFeature$NotebookFeature$needsDiscovery$1 = (EditingDiscoverableFeature$NotebookFeature$needsDiscovery$1) continuation;
                if ((editingDiscoverableFeature$NotebookFeature$needsDiscovery$1.label & Integer.MIN_VALUE) != 0) {
                    editingDiscoverableFeature$NotebookFeature$needsDiscovery$1.label -= Integer.MIN_VALUE;
                } else {
                    editingDiscoverableFeature$NotebookFeature$needsDiscovery$1 = new EditingDiscoverableFeature$NotebookFeature$needsDiscovery$1(this, continuation);
                }
            }
            Object objIsDiscovered = editingDiscoverableFeature$NotebookFeature$needsDiscovery$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = editingDiscoverableFeature$NotebookFeature$needsDiscovery$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscovered);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    editingDiscoverableFeature$NotebookFeature$needsDiscovery$1.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                    editingDiscoverableFeature$NotebookFeature$needsDiscovery$1.label = 1;
                    objIsDiscovered = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, editingDiscoverableFeature$NotebookFeature$needsDiscovery$1);
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

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$BoardFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class BoardFeature extends EditingDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final BoardFeature INSTANCE = new BoardFeature();
        private static final String discoveryKey = "is_board_feature_discovered";
        private static final int minimumSessionCount = 0;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BoardFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1709623072;
        }

        public String toString() {
            return "BoardFeature";
        }

        private BoardFeature() {
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
            EditingDiscoverableFeature$BoardFeature$needsDiscovery$1 editingDiscoverableFeature$BoardFeature$needsDiscovery$1;
            if (continuation instanceof EditingDiscoverableFeature$BoardFeature$needsDiscovery$1) {
                editingDiscoverableFeature$BoardFeature$needsDiscovery$1 = (EditingDiscoverableFeature$BoardFeature$needsDiscovery$1) continuation;
                if ((editingDiscoverableFeature$BoardFeature$needsDiscovery$1.label & Integer.MIN_VALUE) != 0) {
                    editingDiscoverableFeature$BoardFeature$needsDiscovery$1.label -= Integer.MIN_VALUE;
                } else {
                    editingDiscoverableFeature$BoardFeature$needsDiscovery$1 = new EditingDiscoverableFeature$BoardFeature$needsDiscovery$1(this, continuation);
                }
            }
            Object objIsDiscovered = editingDiscoverableFeature$BoardFeature$needsDiscovery$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = editingDiscoverableFeature$BoardFeature$needsDiscovery$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscovered);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    editingDiscoverableFeature$BoardFeature$needsDiscovery$1.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                    editingDiscoverableFeature$BoardFeature$needsDiscovery$1.label = 1;
                    objIsDiscovered = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, editingDiscoverableFeature$BoardFeature$needsDiscovery$1);
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

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$DocumentFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class DocumentFeature extends EditingDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final DocumentFeature INSTANCE = new DocumentFeature();
        private static final String discoveryKey = "is_document_feature_discovered";
        private static final int minimumSessionCount = 0;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DocumentFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1684896683;
        }

        public String toString() {
            return "DocumentFeature";
        }

        private DocumentFeature() {
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
            EditingDiscoverableFeature$DocumentFeature$needsDiscovery$1 editingDiscoverableFeature$DocumentFeature$needsDiscovery$1;
            if (continuation instanceof EditingDiscoverableFeature$DocumentFeature$needsDiscovery$1) {
                editingDiscoverableFeature$DocumentFeature$needsDiscovery$1 = (EditingDiscoverableFeature$DocumentFeature$needsDiscovery$1) continuation;
                if ((editingDiscoverableFeature$DocumentFeature$needsDiscovery$1.label & Integer.MIN_VALUE) != 0) {
                    editingDiscoverableFeature$DocumentFeature$needsDiscovery$1.label -= Integer.MIN_VALUE;
                } else {
                    editingDiscoverableFeature$DocumentFeature$needsDiscovery$1 = new EditingDiscoverableFeature$DocumentFeature$needsDiscovery$1(this, continuation);
                }
            }
            Object objIsDiscovered = editingDiscoverableFeature$DocumentFeature$needsDiscovery$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = editingDiscoverableFeature$DocumentFeature$needsDiscovery$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscovered);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    editingDiscoverableFeature$DocumentFeature$needsDiscovery$1.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                    editingDiscoverableFeature$DocumentFeature$needsDiscovery$1.label = 1;
                    objIsDiscovered = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, editingDiscoverableFeature$DocumentFeature$needsDiscovery$1);
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

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$PdfFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class PdfFeature extends EditingDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final PdfFeature INSTANCE = new PdfFeature();
        private static final String discoveryKey = "is_pdf_feature_discovered";
        private static final int minimumSessionCount = 0;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PdfFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -974291628;
        }

        public String toString() {
            return "PdfFeature";
        }

        private PdfFeature() {
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
            EditingDiscoverableFeature$PdfFeature$needsDiscovery$1 editingDiscoverableFeature$PdfFeature$needsDiscovery$1;
            if (continuation instanceof EditingDiscoverableFeature$PdfFeature$needsDiscovery$1) {
                editingDiscoverableFeature$PdfFeature$needsDiscovery$1 = (EditingDiscoverableFeature$PdfFeature$needsDiscovery$1) continuation;
                if ((editingDiscoverableFeature$PdfFeature$needsDiscovery$1.label & Integer.MIN_VALUE) != 0) {
                    editingDiscoverableFeature$PdfFeature$needsDiscovery$1.label -= Integer.MIN_VALUE;
                } else {
                    editingDiscoverableFeature$PdfFeature$needsDiscovery$1 = new EditingDiscoverableFeature$PdfFeature$needsDiscovery$1(this, continuation);
                }
            }
            Object objIsDiscovered = editingDiscoverableFeature$PdfFeature$needsDiscovery$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = editingDiscoverableFeature$PdfFeature$needsDiscovery$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscovered);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    editingDiscoverableFeature$PdfFeature$needsDiscovery$1.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                    editingDiscoverableFeature$PdfFeature$needsDiscovery$1.label = 1;
                    objIsDiscovered = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, editingDiscoverableFeature$PdfFeature$needsDiscovery$1);
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

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$AIExplainFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class AIExplainFeature extends EditingDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final AIExplainFeature INSTANCE = new AIExplainFeature();
        private static final String discoveryKey = "is_ai_feature_discovered";
        private static final int minimumSessionCount = 1;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AIExplainFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1119522857;
        }

        public String toString() {
            return "AIExplainFeature";
        }

        private AIExplainFeature() {
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
            EditingDiscoverableFeature$AIExplainFeature$needsDiscovery$1 editingDiscoverableFeature$AIExplainFeature$needsDiscovery$1;
            if (continuation instanceof EditingDiscoverableFeature$AIExplainFeature$needsDiscovery$1) {
                editingDiscoverableFeature$AIExplainFeature$needsDiscovery$1 = (EditingDiscoverableFeature$AIExplainFeature$needsDiscovery$1) continuation;
                if ((editingDiscoverableFeature$AIExplainFeature$needsDiscovery$1.label & Integer.MIN_VALUE) != 0) {
                    editingDiscoverableFeature$AIExplainFeature$needsDiscovery$1.label -= Integer.MIN_VALUE;
                } else {
                    editingDiscoverableFeature$AIExplainFeature$needsDiscovery$1 = new EditingDiscoverableFeature$AIExplainFeature$needsDiscovery$1(this, continuation);
                }
            }
            Object objIsDiscovered = editingDiscoverableFeature$AIExplainFeature$needsDiscovery$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = editingDiscoverableFeature$AIExplainFeature$needsDiscovery$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscovered);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    editingDiscoverableFeature$AIExplainFeature$needsDiscovery$1.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                    editingDiscoverableFeature$AIExplainFeature$needsDiscovery$1.label = 1;
                    objIsDiscovered = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, editingDiscoverableFeature$AIExplainFeature$needsDiscovery$1);
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

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$PenOptionsFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class PenOptionsFeature extends EditingDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final PenOptionsFeature INSTANCE = new PenOptionsFeature();
        private static final String discoveryKey = "is_pen_options_feature_discovered";
        private static final int minimumSessionCount = 2;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PenOptionsFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 131458625;
        }

        public String toString() {
            return "PenOptionsFeature";
        }

        private PenOptionsFeature() {
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
            EditingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1 editingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1;
            if (continuation instanceof EditingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1) {
                editingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1 = (EditingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1) continuation;
                if ((editingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1.label & Integer.MIN_VALUE) != 0) {
                    editingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1.label -= Integer.MIN_VALUE;
                } else {
                    editingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1 = new EditingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1(this, continuation);
                }
            }
            Object objIsDiscovered = editingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = editingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscovered);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    editingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                    editingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1.label = 1;
                    objIsDiscovered = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, editingDiscoverableFeature$PenOptionsFeature$needsDiscovery$1);
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

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$AIQuizFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class AIQuizFeature extends EditingDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final AIQuizFeature INSTANCE = new AIQuizFeature();
        private static final String discoveryKey = "is_ai_quiz_feature_discovered";
        private static final int minimumSessionCount = 3;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AIQuizFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1044983799;
        }

        public String toString() {
            return "AIQuizFeature";
        }

        private AIQuizFeature() {
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
            EditingDiscoverableFeature$AIQuizFeature$needsDiscovery$1 editingDiscoverableFeature$AIQuizFeature$needsDiscovery$1;
            if (continuation instanceof EditingDiscoverableFeature$AIQuizFeature$needsDiscovery$1) {
                editingDiscoverableFeature$AIQuizFeature$needsDiscovery$1 = (EditingDiscoverableFeature$AIQuizFeature$needsDiscovery$1) continuation;
                if ((editingDiscoverableFeature$AIQuizFeature$needsDiscovery$1.label & Integer.MIN_VALUE) != 0) {
                    editingDiscoverableFeature$AIQuizFeature$needsDiscovery$1.label -= Integer.MIN_VALUE;
                } else {
                    editingDiscoverableFeature$AIQuizFeature$needsDiscovery$1 = new EditingDiscoverableFeature$AIQuizFeature$needsDiscovery$1(this, continuation);
                }
            }
            Object objIsDiscovered = editingDiscoverableFeature$AIQuizFeature$needsDiscovery$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = editingDiscoverableFeature$AIQuizFeature$needsDiscovery$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscovered);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    editingDiscoverableFeature$AIQuizFeature$needsDiscovery$1.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                    editingDiscoverableFeature$AIQuizFeature$needsDiscovery$1.label = 1;
                    objIsDiscovered = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, editingDiscoverableFeature$AIQuizFeature$needsDiscovery$1);
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

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$PdfAddPageFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", FirebaseAnalytics.Param.DESTINATION, "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$DiscoverableFeatureDestination;", "getDestination", "()Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$DiscoverableFeatureDestination;", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class PdfAddPageFeature extends EditingDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        private static final int minimumSessionCount = 0;
        public static final PdfAddPageFeature INSTANCE = new PdfAddPageFeature();
        private static final String discoveryKey = "is_pdf_add_page_feature_discovered";
        private static final DiscoverableFeatureDestination destination = DiscoverableFeatureDestination.CHILD_PAGES;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PdfAddPageFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1317017112;
        }

        public String toString() {
            return "PdfAddPageFeature";
        }

        private PdfAddPageFeature() {
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

        @Override // com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature
        public DiscoverableFeatureDestination getDestination() {
            return destination;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // com.myscript.nebo.discoverability.IDiscoverableFeature
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object needsDiscovery(FeatureDiscoveryState featureDiscoveryState, Continuation<? super Boolean> continuation) {
            EditingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1 editingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1;
            if (continuation instanceof EditingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1) {
                editingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1 = (EditingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1) continuation;
                if ((editingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1.label & Integer.MIN_VALUE) != 0) {
                    editingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1.label -= Integer.MIN_VALUE;
                } else {
                    editingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1 = new EditingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1(this, continuation);
                }
            }
            Object objIsDiscovered = editingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = editingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscovered);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    editingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                    editingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1.label = 1;
                    objIsDiscovered = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, editingDiscoverableFeature$PdfAddPageFeature$needsDiscovery$1);
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

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$PdfOptimizationFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class PdfOptimizationFeature extends EditingDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final PdfOptimizationFeature INSTANCE = new PdfOptimizationFeature();
        private static final String discoveryKey = "is_pdf_optimization_feature_discovered";
        private static final int minimumSessionCount = 1;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PdfOptimizationFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -90054105;
        }

        public String toString() {
            return "PdfOptimizationFeature";
        }

        private PdfOptimizationFeature() {
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
            C6424x2072ea44 c6424x2072ea44;
            if (continuation instanceof C6424x2072ea44) {
                c6424x2072ea44 = (C6424x2072ea44) continuation;
                if ((c6424x2072ea44.label & Integer.MIN_VALUE) != 0) {
                    c6424x2072ea44.label -= Integer.MIN_VALUE;
                } else {
                    c6424x2072ea44 = new C6424x2072ea44(this, continuation);
                }
            }
            Object objIsDiscovered = c6424x2072ea44.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = c6424x2072ea44.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscovered);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    c6424x2072ea44.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                    c6424x2072ea44.label = 1;
                    objIsDiscovered = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, c6424x2072ea44);
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

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$DocumentConvertTextFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class DocumentConvertTextFeature extends EditingDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final DocumentConvertTextFeature INSTANCE = new DocumentConvertTextFeature();
        private static final String discoveryKey = "is_document_convert_text_feature_discovered";
        private static final int minimumSessionCount = 0;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DocumentConvertTextFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1361381761;
        }

        public String toString() {
            return "DocumentConvertTextFeature";
        }

        private DocumentConvertTextFeature() {
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

        /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
        
            if (r8 == r1) goto L25;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // com.myscript.nebo.discoverability.IDiscoverableFeature
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object needsDiscovery(FeatureDiscoveryState featureDiscoveryState, Continuation<? super Boolean> continuation) {
            C6423xf01c6aa c6423xf01c6aa;
            if (continuation instanceof C6423xf01c6aa) {
                c6423xf01c6aa = (C6423xf01c6aa) continuation;
                if ((c6423xf01c6aa.label & Integer.MIN_VALUE) != 0) {
                    c6423xf01c6aa.label -= Integer.MIN_VALUE;
                } else {
                    c6423xf01c6aa = new C6423xf01c6aa(this, continuation);
                }
            }
            Object objIsDiscoverable = c6423xf01c6aa.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = c6423xf01c6aa.label;
            boolean z = false;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscoverable);
                if (featureDiscoveryState.getSessionCount() >= ShapesFeature.INSTANCE.getMinimumSessionCount()) {
                    c6423xf01c6aa.L$0 = featureDiscoveryState;
                    c6423xf01c6aa.label = 1;
                    objIsDiscoverable = featureDiscoveryState.getDiscoveryRepository().isDiscoverable(this, false, c6423xf01c6aa);
                    if (objIsDiscoverable != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(z);
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objIsDiscoverable);
                if (!((Boolean) objIsDiscoverable).booleanValue()) {
                    z = true;
                }
                return Boxing.boxBoolean(z);
            }
            featureDiscoveryState = (FeatureDiscoveryState) c6423xf01c6aa.L$0;
            ResultKt.throwOnFailure(objIsDiscoverable);
            if (((Boolean) objIsDiscoverable).booleanValue()) {
                c6423xf01c6aa.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                c6423xf01c6aa.label = 2;
                objIsDiscoverable = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, c6423xf01c6aa);
            }
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$ConvertTextFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ConvertTextFeature extends EditingDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final ConvertTextFeature INSTANCE = new ConvertTextFeature();
        private static final String discoveryKey = "is_convert_text_feature_discovered";
        private static final int minimumSessionCount = 0;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConvertTextFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1956715782;
        }

        public String toString() {
            return "ConvertTextFeature";
        }

        private ConvertTextFeature() {
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

        /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
        
            if (r8 == r1) goto L25;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // com.myscript.nebo.discoverability.IDiscoverableFeature
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object needsDiscovery(FeatureDiscoveryState featureDiscoveryState, Continuation<? super Boolean> continuation) {
            EditingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1 editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1;
            if (continuation instanceof EditingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1) {
                editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1 = (EditingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1) continuation;
                if ((editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1.label & Integer.MIN_VALUE) != 0) {
                    editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1.label -= Integer.MIN_VALUE;
                } else {
                    editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1 = new EditingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1(this, continuation);
                }
            }
            Object objIsDiscoverable = editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1.label;
            boolean z = false;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscoverable);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1.L$0 = featureDiscoveryState;
                    editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1.label = 1;
                    objIsDiscoverable = featureDiscoveryState.getDiscoveryRepository().isDiscoverable(this, false, editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1);
                    if (objIsDiscoverable != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(z);
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objIsDiscoverable);
                if (!((Boolean) objIsDiscoverable).booleanValue()) {
                    z = true;
                }
                return Boxing.boxBoolean(z);
            }
            featureDiscoveryState = (FeatureDiscoveryState) editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1.L$0;
            ResultKt.throwOnFailure(objIsDiscoverable);
            if (((Boolean) objIsDiscoverable).booleanValue()) {
                editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1.label = 2;
                objIsDiscoverable = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, editingDiscoverableFeature$ConvertTextFeature$needsDiscovery$1);
            }
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$ScratchOutGestureFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ScratchOutGestureFeature extends EditingDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final ScratchOutGestureFeature INSTANCE = new ScratchOutGestureFeature();
        private static final String discoveryKey = "is_scratch_out_gesture_feature_discovered";
        private static final int minimumSessionCount = 0;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScratchOutGestureFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1342597071;
        }

        public String toString() {
            return "ScratchOutGestureFeature";
        }

        private ScratchOutGestureFeature() {
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

        /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
        
            if (r8 == r1) goto L25;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // com.myscript.nebo.discoverability.IDiscoverableFeature
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object needsDiscovery(FeatureDiscoveryState featureDiscoveryState, Continuation<? super Boolean> continuation) {
            C6425xb16a63ba c6425xb16a63ba;
            if (continuation instanceof C6425xb16a63ba) {
                c6425xb16a63ba = (C6425xb16a63ba) continuation;
                if ((c6425xb16a63ba.label & Integer.MIN_VALUE) != 0) {
                    c6425xb16a63ba.label -= Integer.MIN_VALUE;
                } else {
                    c6425xb16a63ba = new C6425xb16a63ba(this, continuation);
                }
            }
            Object objIsDiscoverable = c6425xb16a63ba.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = c6425xb16a63ba.label;
            boolean z = false;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscoverable);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    c6425xb16a63ba.L$0 = featureDiscoveryState;
                    c6425xb16a63ba.label = 1;
                    objIsDiscoverable = featureDiscoveryState.getDiscoveryRepository().isDiscoverable(this, false, c6425xb16a63ba);
                    if (objIsDiscoverable != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(z);
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objIsDiscoverable);
                if (!((Boolean) objIsDiscoverable).booleanValue()) {
                    z = true;
                }
                return Boxing.boxBoolean(z);
            }
            featureDiscoveryState = (FeatureDiscoveryState) c6425xb16a63ba.L$0;
            ResultKt.throwOnFailure(objIsDiscoverable);
            if (((Boolean) objIsDiscoverable).booleanValue()) {
                c6425xb16a63ba.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                c6425xb16a63ba.label = 2;
                objIsDiscoverable = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, c6425xb16a63ba);
            }
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$ShapesFeature;", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature;", "<init>", "()V", "discoveryKey", "", "getDiscoveryKey", "()Ljava/lang/String;", "minimumSessionCount", "", "getMinimumSessionCount", "()I", "needsDiscovery", "", "state", "Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;", "(Lcom/myscript/nebo/discoverability/FeatureDiscoveryState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ShapesFeature extends EditingDiscoverableFeature implements IDiscoverableFeature {
        public static final int $stable = 0;
        public static final ShapesFeature INSTANCE = new ShapesFeature();
        private static final String discoveryKey = "is_shapes_feature_discovered";
        private static final int minimumSessionCount = 0;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShapesFeature)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -703443980;
        }

        public String toString() {
            return "ShapesFeature";
        }

        private ShapesFeature() {
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

        /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
        
            if (r8 == r1) goto L25;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // com.myscript.nebo.discoverability.IDiscoverableFeature
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object needsDiscovery(FeatureDiscoveryState featureDiscoveryState, Continuation<? super Boolean> continuation) {
            EditingDiscoverableFeature$ShapesFeature$needsDiscovery$1 editingDiscoverableFeature$ShapesFeature$needsDiscovery$1;
            if (continuation instanceof EditingDiscoverableFeature$ShapesFeature$needsDiscovery$1) {
                editingDiscoverableFeature$ShapesFeature$needsDiscovery$1 = (EditingDiscoverableFeature$ShapesFeature$needsDiscovery$1) continuation;
                if ((editingDiscoverableFeature$ShapesFeature$needsDiscovery$1.label & Integer.MIN_VALUE) != 0) {
                    editingDiscoverableFeature$ShapesFeature$needsDiscovery$1.label -= Integer.MIN_VALUE;
                } else {
                    editingDiscoverableFeature$ShapesFeature$needsDiscovery$1 = new EditingDiscoverableFeature$ShapesFeature$needsDiscovery$1(this, continuation);
                }
            }
            Object objIsDiscoverable = editingDiscoverableFeature$ShapesFeature$needsDiscovery$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = editingDiscoverableFeature$ShapesFeature$needsDiscovery$1.label;
            boolean z = false;
            if (i == 0) {
                ResultKt.throwOnFailure(objIsDiscoverable);
                if (featureDiscoveryState.getSessionCount() >= getMinimumSessionCount()) {
                    editingDiscoverableFeature$ShapesFeature$needsDiscovery$1.L$0 = featureDiscoveryState;
                    editingDiscoverableFeature$ShapesFeature$needsDiscovery$1.label = 1;
                    objIsDiscoverable = featureDiscoveryState.getDiscoveryRepository().isDiscoverable(this, false, editingDiscoverableFeature$ShapesFeature$needsDiscovery$1);
                    if (objIsDiscoverable != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(z);
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objIsDiscoverable);
                if (!((Boolean) objIsDiscoverable).booleanValue()) {
                    z = true;
                }
                return Boxing.boxBoolean(z);
            }
            featureDiscoveryState = (FeatureDiscoveryState) editingDiscoverableFeature$ShapesFeature$needsDiscovery$1.L$0;
            ResultKt.throwOnFailure(objIsDiscoverable);
            if (((Boolean) objIsDiscoverable).booleanValue()) {
                editingDiscoverableFeature$ShapesFeature$needsDiscovery$1.L$0 = SpillingKt.nullOutSpilledVariable(featureDiscoveryState);
                editingDiscoverableFeature$ShapesFeature$needsDiscovery$1.label = 2;
                objIsDiscoverable = featureDiscoveryState.getDiscoveryRepository().isDiscovered(this, editingDiscoverableFeature$ShapesFeature$needsDiscovery$1);
            }
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: compiled from: EditingDiscoverableFeature.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/editing/discoverability/EditingDiscoverableFeature$Companion;", "", "<init>", "()V", "fromTooltipState", "Lcom/myscript/nebo/discoverability/IDiscoverableFeature;", "tooltipState", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IDiscoverableFeature fromTooltipState(TooltipUIState tooltipState) {
            Intrinsics.checkNotNullParameter(tooltipState, "tooltipState");
            int id = tooltipState.getId();
            if (id < 0 || id >= EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().size()) {
                return null;
            }
            return EditingDiscoverableFeatureKt.getEditingDiscoverableFeatures().get(tooltipState.getId());
        }
    }
}

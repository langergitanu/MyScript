package com.myscript.nebo.penpanel;

import com.myscript.snt.core.ToolPropertyExt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\rX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0001\u0004\u0015\u0016\u0017\u0018¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState;", "", "<init>", "()V", "toolOption", "Lcom/myscript/nebo/penpanel/ToolOption;", "getToolOption", "()Lcom/myscript/nebo/penpanel/ToolOption;", "color", "", "getColor", "()I", "isSelected", "", "()Z", "setSelected", "(Z)V", "Brush", "HighLighterPolicy", "EraserPolicy", "LassoShape", "Lcom/myscript/nebo/penpanel/ToolOptionState$Brush;", "Lcom/myscript/nebo/penpanel/ToolOptionState$EraserPolicy;", "Lcom/myscript/nebo/penpanel/ToolOptionState$HighLighterPolicy;", "Lcom/myscript/nebo/penpanel/ToolOptionState$LassoShape;", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class ToolOptionState {
    public /* synthetic */ ToolOptionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getColor();

    public abstract ToolOption getToolOption();

    /* JADX INFO: renamed from: isSelected */
    public abstract boolean getIsSelected();

    public abstract void setSelected(boolean z);

    private ToolOptionState() {
    }

    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015B!\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u00020\u00058\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u0082\u0001\u0003\u0016\u0017\u0018¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState$Brush;", "Lcom/myscript/nebo/penpanel/ToolOptionState;", "toolOption", "Lcom/myscript/nebo/penpanel/ToolOption;", "color", "", "isSelected", "", "<init>", "(Lcom/myscript/nebo/penpanel/ToolOption;IZ)V", "getToolOption", "()Lcom/myscript/nebo/penpanel/ToolOption;", "getColor", "()I", "setColor", "(I)V", "()Z", "setSelected", "(Z)V", "Felt", "Fountain", "Calligraphic", "Lcom/myscript/nebo/penpanel/ToolOptionState$Brush$Calligraphic;", "Lcom/myscript/nebo/penpanel/ToolOptionState$Brush$Felt;", "Lcom/myscript/nebo/penpanel/ToolOptionState$Brush$Fountain;", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class Brush extends ToolOptionState {
        private int color;
        private boolean isSelected;
        private final ToolOption toolOption;

        public /* synthetic */ Brush(ToolOption toolOption, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(toolOption, i, z);
        }

        /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState$Brush$Felt;", "Lcom/myscript/nebo/penpanel/ToolOptionState$Brush;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Felt extends Brush {
            public static final Felt INSTANCE = new Felt();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Felt)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1893533976;
            }

            public String toString() {
                return "Felt";
            }

            /* JADX WARN: Illegal instructions before constructor call */
            /* JADX WARN: Multi-variable type inference failed */
            private Felt() {
                int i = C6693R.drawable.ic_felt_pen;
                int i2 = C6693R.string.pen_stroker_felt;
                String TOOL_PROPERTY_PEN_STROKER = ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_PEN_STROKER, "TOOL_PROPERTY_PEN_STROKER");
                String TOOL_PROPERTY_PEN_STROKER_FELT = ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_FELT;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_PEN_STROKER_FELT, "TOOL_PROPERTY_PEN_STROKER_FELT");
                super(new ToolOption(i, i2, TOOL_PROPERTY_PEN_STROKER, TOOL_PROPERTY_PEN_STROKER_FELT), 0, 0 == true ? 1 : 0, null);
            }
        }

        private Brush(ToolOption toolOption, int i, boolean z) {
            super(null);
            this.toolOption = toolOption;
            this.color = i;
            this.isSelected = z;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        public int getColor() {
            return this.color;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        public ToolOption getToolOption() {
            return this.toolOption;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        /* JADX INFO: renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        public void setColor(int i) {
            this.color = i;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        public void setSelected(boolean z) {
            this.isSelected = z;
        }

        /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState$Brush$Fountain;", "Lcom/myscript/nebo/penpanel/ToolOptionState$Brush;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Fountain extends Brush {
            public static final Fountain INSTANCE = new Fountain();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Fountain)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -440870827;
            }

            public String toString() {
                return "Fountain";
            }

            /* JADX WARN: Illegal instructions before constructor call */
            /* JADX WARN: Multi-variable type inference failed */
            private Fountain() {
                int i = C6693R.drawable.ic_fountain_pen;
                int i2 = C6693R.string.pen_stroker_fountain;
                String TOOL_PROPERTY_PEN_STROKER = ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_PEN_STROKER, "TOOL_PROPERTY_PEN_STROKER");
                String TOOL_PROPERTY_PEN_STROKER_FOUNTAIN_PEN = ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_FOUNTAIN_PEN;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_PEN_STROKER_FOUNTAIN_PEN, "TOOL_PROPERTY_PEN_STROKER_FOUNTAIN_PEN");
                super(new ToolOption(i, i2, TOOL_PROPERTY_PEN_STROKER, TOOL_PROPERTY_PEN_STROKER_FOUNTAIN_PEN), 0, 0 == true ? 1 : 0, null);
            }
        }

        /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState$Brush$Calligraphic;", "Lcom/myscript/nebo/penpanel/ToolOptionState$Brush;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Calligraphic extends Brush {
            public static final Calligraphic INSTANCE = new Calligraphic();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Calligraphic)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 219641374;
            }

            public String toString() {
                return "Calligraphic";
            }

            /* JADX WARN: Illegal instructions before constructor call */
            /* JADX WARN: Multi-variable type inference failed */
            private Calligraphic() {
                int i = C6693R.drawable.ic_calligraphic_brush;
                int i2 = C6693R.string.pen_stroker_brush;
                String TOOL_PROPERTY_PEN_STROKER = ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_PEN_STROKER, "TOOL_PROPERTY_PEN_STROKER");
                String TOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC = ToolPropertyExt.TOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC, "TOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC");
                super(new ToolOption(i, i2, TOOL_PROPERTY_PEN_STROKER, TOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC), 0, 0 == true ? 1 : 0, null);
            }
        }
    }

    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u0082\u0001\u0002\u0015\u0016¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState$HighLighterPolicy;", "Lcom/myscript/nebo/penpanel/ToolOptionState;", "toolOption", "Lcom/myscript/nebo/penpanel/ToolOption;", "isSelected", "", "<init>", "(Lcom/myscript/nebo/penpanel/ToolOption;Z)V", "getToolOption", "()Lcom/myscript/nebo/penpanel/ToolOption;", "()Z", "setSelected", "(Z)V", "color", "", "getColor", "()I", "setColor", "(I)V", "Sketch", "Smart", "Lcom/myscript/nebo/penpanel/ToolOptionState$HighLighterPolicy$Sketch;", "Lcom/myscript/nebo/penpanel/ToolOptionState$HighLighterPolicy$Smart;", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class HighLighterPolicy extends ToolOptionState {
        private int color;
        private boolean isSelected;
        private final ToolOption toolOption;

        public /* synthetic */ HighLighterPolicy(ToolOption toolOption, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(toolOption, z);
        }

        private HighLighterPolicy(ToolOption toolOption, boolean z) {
            super(null);
            this.toolOption = toolOption;
            this.isSelected = z;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        public ToolOption getToolOption() {
            return this.toolOption;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        /* JADX INFO: renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        public void setSelected(boolean z) {
            this.isSelected = z;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        public int getColor() {
            return this.color;
        }

        public void setColor(int i) {
            this.color = i;
        }

        /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState$HighLighterPolicy$Sketch;", "Lcom/myscript/nebo/penpanel/ToolOptionState$HighLighterPolicy;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Sketch extends HighLighterPolicy {
            public static final Sketch INSTANCE = new Sketch();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Sketch)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 912151700;
            }

            public String toString() {
                return "Sketch";
            }

            /* JADX WARN: Illegal instructions before constructor call */
            private Sketch() {
                int i = C6693R.drawable.ic_highlighter_freehand;
                int i2 = C6693R.string.highlighter_policy_freehand;
                String TOOL_PROPERTY_HIGHLIGHTER_POLICY = ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_HIGHLIGHTER_POLICY, "TOOL_PROPERTY_HIGHLIGHTER_POLICY");
                String TOOL_PROPERTY_HIGHLIGHTER_POLICY_SKETCH = ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SKETCH;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_HIGHLIGHTER_POLICY_SKETCH, "TOOL_PROPERTY_HIGHLIGHTER_POLICY_SKETCH");
                super(new ToolOption(i, i2, TOOL_PROPERTY_HIGHLIGHTER_POLICY, TOOL_PROPERTY_HIGHLIGHTER_POLICY_SKETCH), false, null);
            }
        }

        /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState$HighLighterPolicy$Smart;", "Lcom/myscript/nebo/penpanel/ToolOptionState$HighLighterPolicy;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Smart extends HighLighterPolicy {
            public static final Smart INSTANCE = new Smart();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Smart)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1078898719;
            }

            public String toString() {
                return "Smart";
            }

            /* JADX WARN: Illegal instructions before constructor call */
            private Smart() {
                int i = C6693R.drawable.ic_highlighter_smart;
                int i2 = C6693R.string.highlighter_policy_smart;
                String TOOL_PROPERTY_HIGHLIGHTER_POLICY = ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_HIGHLIGHTER_POLICY, "TOOL_PROPERTY_HIGHLIGHTER_POLICY");
                String TOOL_PROPERTY_HIGHLIGHTER_POLICY_SMART = ToolPropertyExt.TOOL_PROPERTY_HIGHLIGHTER_POLICY_SMART;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_HIGHLIGHTER_POLICY_SMART, "TOOL_PROPERTY_HIGHLIGHTER_POLICY_SMART");
                super(new ToolOption(i, i2, TOOL_PROPERTY_HIGHLIGHTER_POLICY, TOOL_PROPERTY_HIGHLIGHTER_POLICY_SMART), false, null);
            }
        }
    }

    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u0082\u0001\u0002\u0015\u0016¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState$EraserPolicy;", "Lcom/myscript/nebo/penpanel/ToolOptionState;", "toolOption", "Lcom/myscript/nebo/penpanel/ToolOption;", "isSelected", "", "<init>", "(Lcom/myscript/nebo/penpanel/ToolOption;Z)V", "getToolOption", "()Lcom/myscript/nebo/penpanel/ToolOption;", "()Z", "setSelected", "(Z)V", "color", "", "getColor", "()I", "setColor", "(I)V", "Stroke", "Precise", "Lcom/myscript/nebo/penpanel/ToolOptionState$EraserPolicy$Precise;", "Lcom/myscript/nebo/penpanel/ToolOptionState$EraserPolicy$Stroke;", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class EraserPolicy extends ToolOptionState {
        private int color;
        private boolean isSelected;
        private final ToolOption toolOption;

        public /* synthetic */ EraserPolicy(ToolOption toolOption, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(toolOption, z);
        }

        private EraserPolicy(ToolOption toolOption, boolean z) {
            super(null);
            this.toolOption = toolOption;
            this.isSelected = z;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        public ToolOption getToolOption() {
            return this.toolOption;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        /* JADX INFO: renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        public void setSelected(boolean z) {
            this.isSelected = z;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        public int getColor() {
            return this.color;
        }

        public void setColor(int i) {
            this.color = i;
        }

        /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState$EraserPolicy$Stroke;", "Lcom/myscript/nebo/penpanel/ToolOptionState$EraserPolicy;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Stroke extends EraserPolicy {
            public static final Stroke INSTANCE = new Stroke();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Stroke)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -36278277;
            }

            public String toString() {
                return "Stroke";
            }

            /* JADX WARN: Illegal instructions before constructor call */
            private Stroke() {
                int i = C6693R.drawable.ic_eraser_stroke;
                int i2 = C6693R.string.eraser_policy_stroke;
                String TOOL_PROPERTY_ERASER_POLICY = ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_ERASER_POLICY, "TOOL_PROPERTY_ERASER_POLICY");
                String TOOL_PROPERTY_ERASER_POLICY_STROKE = ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY_STROKE;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_ERASER_POLICY_STROKE, "TOOL_PROPERTY_ERASER_POLICY_STROKE");
                super(new ToolOption(i, i2, TOOL_PROPERTY_ERASER_POLICY, TOOL_PROPERTY_ERASER_POLICY_STROKE), false, null);
            }
        }

        /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState$EraserPolicy$Precise;", "Lcom/myscript/nebo/penpanel/ToolOptionState$EraserPolicy;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Precise extends EraserPolicy {
            public static final Precise INSTANCE = new Precise();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Precise)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 438206712;
            }

            public String toString() {
                return "Precise";
            }

            /* JADX WARN: Illegal instructions before constructor call */
            private Precise() {
                int i = C6693R.drawable.ic_eraser_precise;
                int i2 = C6693R.string.eraser_policy_precise;
                String TOOL_PROPERTY_ERASER_POLICY = ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_ERASER_POLICY, "TOOL_PROPERTY_ERASER_POLICY");
                String TOOL_PROPERTY_ERASER_POLICY_PRECISE = ToolPropertyExt.TOOL_PROPERTY_ERASER_POLICY_PRECISE;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_ERASER_POLICY_PRECISE, "TOOL_PROPERTY_ERASER_POLICY_PRECISE");
                super(new ToolOption(i, i2, TOOL_PROPERTY_ERASER_POLICY, TOOL_PROPERTY_ERASER_POLICY_PRECISE), false, null);
            }
        }
    }

    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u0082\u0001\u0002\u0015\u0016¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState$LassoShape;", "Lcom/myscript/nebo/penpanel/ToolOptionState;", "toolOption", "Lcom/myscript/nebo/penpanel/ToolOption;", "isSelected", "", "<init>", "(Lcom/myscript/nebo/penpanel/ToolOption;Z)V", "getToolOption", "()Lcom/myscript/nebo/penpanel/ToolOption;", "()Z", "setSelected", "(Z)V", "color", "", "getColor", "()I", "setColor", "(I)V", "Polygon", "Rectangle", "Lcom/myscript/nebo/penpanel/ToolOptionState$LassoShape$Polygon;", "Lcom/myscript/nebo/penpanel/ToolOptionState$LassoShape$Rectangle;", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class LassoShape extends ToolOptionState {
        private int color;
        private boolean isSelected;
        private final ToolOption toolOption;

        public /* synthetic */ LassoShape(ToolOption toolOption, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(toolOption, z);
        }

        private LassoShape(ToolOption toolOption, boolean z) {
            super(null);
            this.toolOption = toolOption;
            this.isSelected = z;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        public ToolOption getToolOption() {
            return this.toolOption;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        /* JADX INFO: renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        public void setSelected(boolean z) {
            this.isSelected = z;
        }

        @Override // com.myscript.nebo.penpanel.ToolOptionState
        public int getColor() {
            return this.color;
        }

        public void setColor(int i) {
            this.color = i;
        }

        /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState$LassoShape$Polygon;", "Lcom/myscript/nebo/penpanel/ToolOptionState$LassoShape;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Polygon extends LassoShape {
            public static final Polygon INSTANCE = new Polygon();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Polygon)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1816054400;
            }

            public String toString() {
                return "Polygon";
            }

            /* JADX WARN: Illegal instructions before constructor call */
            private Polygon() {
                int i = C6693R.drawable.ic_lasso;
                int i2 = C6693R.string.lasso_shape_polygon;
                String TOOL_PROPERTY_LASSO_SHAPE = ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_LASSO_SHAPE, "TOOL_PROPERTY_LASSO_SHAPE");
                String TOOL_PROPERTY_LASSO_SHAPE_POLYGON = ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE_POLYGON;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_LASSO_SHAPE_POLYGON, "TOOL_PROPERTY_LASSO_SHAPE_POLYGON");
                super(new ToolOption(i, i2, TOOL_PROPERTY_LASSO_SHAPE, TOOL_PROPERTY_LASSO_SHAPE_POLYGON), false, null);
            }
        }

        /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolOptionState$LassoShape$Rectangle;", "Lcom/myscript/nebo/penpanel/ToolOptionState$LassoShape;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class Rectangle extends LassoShape {
            public static final Rectangle INSTANCE = new Rectangle();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Rectangle)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1937905355;
            }

            public String toString() {
                return "Rectangle";
            }

            /* JADX WARN: Illegal instructions before constructor call */
            private Rectangle() {
                int i = C6693R.drawable.ic_lasso_rectangle;
                int i2 = C6693R.string.lasso_shape_rectangle;
                String TOOL_PROPERTY_LASSO_SHAPE = ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_LASSO_SHAPE, "TOOL_PROPERTY_LASSO_SHAPE");
                String TOOL_PROPERTY_LASSO_SHAPE_RECTANGLE = ToolPropertyExt.TOOL_PROPERTY_LASSO_SHAPE_RECTANGLE;
                Intrinsics.checkNotNullExpressionValue(TOOL_PROPERTY_LASSO_SHAPE_RECTANGLE, "TOOL_PROPERTY_LASSO_SHAPE_RECTANGLE");
                super(new ToolOption(i, i2, TOOL_PROPERTY_LASSO_SHAPE, TOOL_PROPERTY_LASSO_SHAPE_RECTANGLE), false, null);
            }
        }
    }
}

package com.myscript.nebo.penpanel;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.myscript.snt.core.ToolConfiguration;
import com.myscript.snt.core.ToolType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00152\u00020\u0001:\u0005\u0011\u0012\u0013\u0014\u0015B)\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0004\u0016\u0017\u0018\u0019¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/DialogState;", "", "titleRes", "", "thicknesses", "", "Lcom/myscript/nebo/penpanel/ThicknessPill;", "showTestArea", "", "<init>", "(ILjava/util/List;Z)V", "getTitleRes", "()I", "getThicknesses", "()Ljava/util/List;", "getShowTestArea", "()Z", "Pen", "Highlighter", "Eraser", "Lasso", "Companion", "Lcom/myscript/nebo/penpanel/DialogState$Eraser;", "Lcom/myscript/nebo/penpanel/DialogState$Highlighter;", "Lcom/myscript/nebo/penpanel/DialogState$Lasso;", "Lcom/myscript/nebo/penpanel/DialogState$Pen;", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class DialogState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<ToolType, DialogState> mapping = MapsKt.mapOf(TuplesKt.m1606to(ToolType.Pen, Pen.INSTANCE), TuplesKt.m1606to(ToolType.Highlighter, Highlighter.INSTANCE), TuplesKt.m1606to(ToolType.Eraser, Eraser.INSTANCE), TuplesKt.m1606to(ToolType.Lasso, Lasso.INSTANCE));
    private final boolean showTestArea;
    private final List<ThicknessPill> thicknesses;
    private final int titleRes;

    public /* synthetic */ DialogState(int i, List list, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z);
    }

    private DialogState(int i, List<ThicknessPill> list, boolean z) {
        this.titleRes = i;
        this.thicknesses = list;
        this.showTestArea = z;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final List<ThicknessPill> getThicknesses() {
        return this.thicknesses;
    }

    public final boolean getShowTestArea() {
        return this.showTestArea;
    }

    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/DialogState$Pen;", "Lcom/myscript/nebo/penpanel/DialogState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Pen extends DialogState {
        public static final Pen INSTANCE = new Pen();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Pen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 359117681;
        }

        public String toString() {
            return "Pen";
        }

        private Pen() {
            super(C6693R.string.toolconfiguration_dialog_title_pen, ToolConfigurationDialogFragmentKt.getThicknessPills(ToolType.Pen), true, null);
        }
    }

    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/DialogState$Highlighter;", "Lcom/myscript/nebo/penpanel/DialogState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Highlighter extends DialogState {
        public static final Highlighter INSTANCE = new Highlighter();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Highlighter)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1677682361;
        }

        public String toString() {
            return "Highlighter";
        }

        private Highlighter() {
            super(C6693R.string.toolconfiguration_dialog_title_highlighter, ToolConfigurationDialogFragmentKt.getThicknessPills(ToolType.Highlighter), true, null);
        }
    }

    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/DialogState$Eraser;", "Lcom/myscript/nebo/penpanel/DialogState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Eraser extends DialogState {
        public static final Eraser INSTANCE = new Eraser();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Eraser)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -591888076;
        }

        public String toString() {
            return "Eraser";
        }

        private Eraser() {
            super(C6693R.string.toolconfiguration_dialog_title_eraser, ToolConfigurationDialogFragmentKt.getThicknessPills(ToolType.Eraser), false, null);
        }
    }

    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/DialogState$Lasso;", "Lcom/myscript/nebo/penpanel/DialogState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Lasso extends DialogState {
        public static final Lasso INSTANCE = new Lasso();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Lasso)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1510902994;
        }

        public String toString() {
            return "Lasso";
        }

        private Lasso() {
            super(C6693R.string.toolconfiguration_dialog_title_lasso, ToolConfigurationDialogFragmentKt.getThicknessPills(ToolType.Lasso), false, null);
        }
    }

    /* JADX INFO: compiled from: ToolConfigurationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/DialogState$Companion;", "", "<init>", "()V", "mapping", "", "Lcom/myscript/snt/core/ToolType;", "Lcom/myscript/nebo/penpanel/DialogState;", TypedValues.TransitionType.S_FROM, "toolConfiguration", "Lcom/myscript/snt/core/ToolConfiguration;", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DialogState from(ToolConfiguration toolConfiguration) {
            Intrinsics.checkNotNullParameter(toolConfiguration, "toolConfiguration");
            DialogState dialogState = (DialogState) DialogState.mapping.get(toolConfiguration.getType());
            if (dialogState != null) {
                return dialogState;
            }
            throw new IllegalStateException(("Unsupported tool type " + toolConfiguration.getType()).toString());
        }
    }
}

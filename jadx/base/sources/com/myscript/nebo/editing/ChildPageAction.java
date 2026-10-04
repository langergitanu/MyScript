package com.myscript.nebo.editing;

import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.dms.C6208R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ChildPagesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018B7\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0001\b\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPageAction;", "", "drawableResId", "", "labelResId", "isCritical", "", "showDividerBefore", "showDividerAfter", "<init>", "(IIZZZ)V", "getDrawableResId", "()I", "getLabelResId", "()Z", "getShowDividerBefore", "getShowDividerAfter", "Insert", "MoveUp", "MoveDown", "Remove", "Duplicate", "Export", "UpdateBackground", "ManagePages", "Lcom/myscript/nebo/editing/ChildPageAction$Duplicate;", "Lcom/myscript/nebo/editing/ChildPageAction$Export;", "Lcom/myscript/nebo/editing/ChildPageAction$Insert;", "Lcom/myscript/nebo/editing/ChildPageAction$ManagePages;", "Lcom/myscript/nebo/editing/ChildPageAction$MoveDown;", "Lcom/myscript/nebo/editing/ChildPageAction$MoveUp;", "Lcom/myscript/nebo/editing/ChildPageAction$Remove;", "Lcom/myscript/nebo/editing/ChildPageAction$UpdateBackground;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class ChildPageAction {
    public static final int $stable = 0;
    private final int drawableResId;
    private final boolean isCritical;
    private final int labelResId;
    private final boolean showDividerAfter;
    private final boolean showDividerBefore;

    public /* synthetic */ ChildPageAction(int i, int i2, boolean z, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, z, z2, z3);
    }

    private ChildPageAction(int i, int i2, boolean z, boolean z2, boolean z3) {
        this.drawableResId = i;
        this.labelResId = i2;
        this.isCritical = z;
        this.showDividerBefore = z2;
        this.showDividerAfter = z3;
    }

    public /* synthetic */ ChildPageAction(int i, int i2, boolean z, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? false : z3, null);
    }

    public final int getDrawableResId() {
        return this.drawableResId;
    }

    public final int getLabelResId() {
        return this.labelResId;
    }

    /* JADX INFO: renamed from: isCritical, reason: from getter */
    public final boolean getIsCritical() {
        return this.isCritical;
    }

    public final boolean getShowDividerBefore() {
        return this.showDividerBefore;
    }

    public final boolean getShowDividerAfter() {
        return this.showDividerAfter;
    }

    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPageAction$Insert;", "Lcom/myscript/nebo/editing/ChildPageAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Insert extends ChildPageAction {
        public static final int $stable = 0;
        public static final Insert INSTANCE = new Insert();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Insert)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1669074940;
        }

        public String toString() {
            return "Insert";
        }

        private Insert() {
            super(C6183R.drawable.ic_add_blank_page, C6421R.string.editing_action_menu_pdf_page_insert, false, false, false, 28, null);
        }
    }

    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPageAction$MoveUp;", "Lcom/myscript/nebo/editing/ChildPageAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class MoveUp extends ChildPageAction {
        public static final int $stable = 0;
        public static final MoveUp INSTANCE = new MoveUp();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MoveUp)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1784603535;
        }

        public String toString() {
            return "MoveUp";
        }

        private MoveUp() {
            super(C6183R.drawable.ic_arrow_upward, C6421R.string.editing_action_menu_pdf_page_move_up, false, false, false, 28, null);
        }
    }

    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPageAction$MoveDown;", "Lcom/myscript/nebo/editing/ChildPageAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class MoveDown extends ChildPageAction {
        public static final int $stable = 0;
        public static final MoveDown INSTANCE = new MoveDown();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MoveDown)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1311542422;
        }

        public String toString() {
            return "MoveDown";
        }

        private MoveDown() {
            super(C6183R.drawable.ic_arrow_downward, C6421R.string.editing_action_menu_pdf_page_move_down, false, false, false, 28, null);
        }
    }

    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPageAction$Remove;", "Lcom/myscript/nebo/editing/ChildPageAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Remove extends ChildPageAction {
        public static final int $stable = 0;
        public static final Remove INSTANCE = new Remove();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Remove)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1918256583;
        }

        public String toString() {
            return "Remove";
        }

        private Remove() {
            super(C6183R.drawable.ic_delete_outline, C6421R.string.editing_action_menu_pdf_page_remove, true, true, false, 16, null);
        }
    }

    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPageAction$Duplicate;", "Lcom/myscript/nebo/editing/ChildPageAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Duplicate extends ChildPageAction {
        public static final int $stable = 0;
        public static final Duplicate INSTANCE = new Duplicate();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Duplicate)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2133568280;
        }

        public String toString() {
            return "Duplicate";
        }

        private Duplicate() {
            super(C6079R.drawable.ic_duplicate, C6079R.string.paginated_panel_menu_duplicate, false, false, false, 28, null);
        }
    }

    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPageAction$Export;", "Lcom/myscript/nebo/editing/ChildPageAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Export extends ChildPageAction {
        public static final int $stable = 0;
        public static final Export INSTANCE = new Export();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Export)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1563713783;
        }

        public String toString() {
            return "Export";
        }

        private Export() {
            super(C6208R.drawable.ic_ios_share, C6079R.string.paginated_panel_menu_export_page, false, false, false, 28, null);
        }
    }

    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPageAction$UpdateBackground;", "Lcom/myscript/nebo/editing/ChildPageAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class UpdateBackground extends ChildPageAction {
        public static final int $stable = 0;
        public static final UpdateBackground INSTANCE = new UpdateBackground();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateBackground)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -33646502;
        }

        public String toString() {
            return "UpdateBackground";
        }

        private UpdateBackground() {
            super(C6079R.drawable.ic_grid, C6079R.string.paginated_panel_menu_update_page_background, false, false, false, 28, null);
        }
    }

    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPageAction$ManagePages;", "Lcom/myscript/nebo/editing/ChildPageAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ManagePages extends ChildPageAction {
        public static final int $stable = 0;
        public static final ManagePages INSTANCE = new ManagePages();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ManagePages)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1127252484;
        }

        public String toString() {
            return "ManagePages";
        }

        private ManagePages() {
            super(C6079R.drawable.ic_grid_view, C6079R.string.paginated_panel_menu_manage_pages, false, false, false, 28, null);
        }
    }
}

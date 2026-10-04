package com.myscript.nebo.dms.dialog;

import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.dms.C6208R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CollectionDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058'X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/DialogSpec;", "", "<init>", "()V", "title", "", "getTitle", "()I", "positiveAction", "getPositiveAction", "negativeAction", "getNegativeAction", "New", "Edit", "Lcom/myscript/nebo/dms/dialog/DialogSpec$Edit;", "Lcom/myscript/nebo/dms/dialog/DialogSpec$New;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
abstract class DialogSpec {
    private final int negativeAction;

    public /* synthetic */ DialogSpec(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getPositiveAction();

    public abstract int getTitle();

    private DialogSpec() {
        this.negativeAction = C6183R.string.dialog_cancel;
    }

    public int getNegativeAction() {
        return this.negativeAction;
    }

    /* JADX INFO: compiled from: CollectionDialog.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/DialogSpec$New;", "Lcom/myscript/nebo/dms/dialog/DialogSpec;", "<init>", "()V", "title", "", "getTitle", "()I", "positiveAction", "getPositiveAction", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class New extends DialogSpec {
        public static final int $stable = 0;
        public static final New INSTANCE = new New();
        private static final int title = C6208R.string.dialog_newCollectionTitle;
        private static final int positiveAction = C6208R.string.action_create_collection;

        private New() {
            super(null);
        }

        @Override // com.myscript.nebo.dms.dialog.DialogSpec
        public int getTitle() {
            return title;
        }

        @Override // com.myscript.nebo.dms.dialog.DialogSpec
        public int getPositiveAction() {
            return positiveAction;
        }
    }

    /* JADX INFO: compiled from: CollectionDialog.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/DialogSpec$Edit;", "Lcom/myscript/nebo/dms/dialog/DialogSpec;", "<init>", "()V", "title", "", "getTitle", "()I", "positiveAction", "getPositiveAction", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Edit extends DialogSpec {
        public static final int $stable = 0;
        public static final Edit INSTANCE = new Edit();
        private static final int title = C6208R.string.dialog_edit_collection_title;
        private static final int positiveAction = C6183R.string.dialog_ok;

        private Edit() {
            super(null);
        }

        @Override // com.myscript.nebo.dms.dialog.DialogSpec
        public int getTitle() {
            return title;
        }

        @Override // com.myscript.nebo.dms.dialog.DialogSpec
        public int getPositiveAction() {
            return positiveAction;
        }
    }
}

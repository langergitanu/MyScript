package com.myscript.nebo.trash.p033ui;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.myscript.android.utils.SelectionMode;
import com.myscript.nebo.C6079R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrashedPagesFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, m1599d2 = {"com/myscript/nebo/trash/ui/TrashedPagesFragment$selectionModeCallback$1", "Lcom/myscript/android/utils/SelectionMode$Callback;", "onCreateSelectionMode", "", "mode", "Lcom/myscript/android/utils/SelectionMode;", "menu", "Landroid/view/Menu;", "onPrepareSelectionMode", "onSelectionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroySelectionMode", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TrashedPagesFragment$selectionModeCallback$1 implements SelectionMode.Callback {
    final /* synthetic */ TrashedPagesFragment this$0;

    TrashedPagesFragment$selectionModeCallback$1(TrashedPagesFragment trashedPagesFragment) {
        this.this$0 = trashedPagesFragment;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onCreateSelectionMode(SelectionMode mode, Menu menu) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        MenuInflater menuInflater = mode.getMenuInflater();
        if (menuInflater != null) {
            menuInflater.inflate(C6079R.menu.trashed_pages_selection_mode_menu, menu);
        }
        this.this$0.getViewModel().activatePagesSelectionMode(true);
        return true;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onPrepareSelectionMode(SelectionMode mode, Menu menu) {
        MenuItem menuItemFindItem;
        MenuItem menuItemFindItem2;
        MenuItem menuItemFindItem3;
        MenuItem menuItemFindItem4;
        Intrinsics.checkNotNullParameter(mode, "mode");
        int selectedPagesCount = this.this$0.getViewModel().getSelectedPagesCount();
        mode.setTitle(this.this$0.getResources().getQuantityString(C6079R.plurals.note_selected_count, selectedPagesCount, Integer.valueOf(selectedPagesCount)));
        boolean enablePagesMenuActions = this.this$0.getViewModel().getEnablePagesMenuActions();
        if (menu != null && (menuItemFindItem4 = menu.findItem(C6079R.id.trash_deselect_all_menu_item)) != null) {
            menuItemFindItem4.setEnabled(enablePagesMenuActions);
        }
        if (menu != null && (menuItemFindItem3 = menu.findItem(C6079R.id.trash_select_all_menu_item)) != null) {
            menuItemFindItem3.setEnabled(this.this$0.getViewModel().getEnableSelectAllPages());
        }
        if (menu != null && (menuItemFindItem2 = menu.findItem(C6079R.id.trash_delete_selection_menu_item)) != null) {
            menuItemFindItem2.setEnabled(enablePagesMenuActions);
        }
        if (menu == null || (menuItemFindItem = menu.findItem(C6079R.id.trash_restore_selection_menu_item)) == null) {
            return true;
        }
        menuItemFindItem.setEnabled(enablePagesMenuActions);
        return true;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onSelectionItemClicked(SelectionMode mode, MenuItem item) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Integer numValueOf = item != null ? Integer.valueOf(item.getItemId()) : null;
        int i = C6079R.id.trash_delete_selection_menu_item;
        if (numValueOf != null && numValueOf.intValue() == i) {
            int selectedPagesCount = this.this$0.getViewModel().getSelectedPagesCount();
            final TrashedPagesFragment trashedPagesFragment = this.this$0;
            trashedPagesFragment.displayDeleteConfirmationDialog(selectedPagesCount, new Function0() { // from class: com.myscript.nebo.trash.ui.TrashedPagesFragment$selectionModeCallback$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TrashedPagesFragment$selectionModeCallback$1.onSelectionItemClicked$lambda$0(trashedPagesFragment);
                }
            });
            return true;
        }
        int i2 = C6079R.id.trash_restore_selection_menu_item;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            this.this$0.getViewModel().restoreSelectedPages();
            return true;
        }
        int i3 = C6079R.id.trash_select_all_menu_item;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            this.this$0.getViewModel().selectAllPages();
            return true;
        }
        int i4 = C6079R.id.trash_deselect_all_menu_item;
        if (numValueOf == null || numValueOf.intValue() != i4) {
            return false;
        }
        this.this$0.getViewModel().deselectAllPages();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSelectionItemClicked$lambda$0(TrashedPagesFragment trashedPagesFragment) {
        trashedPagesFragment.getViewModel().deleteSelectedPages();
        return Unit.INSTANCE;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public void onDestroySelectionMode(SelectionMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.this$0.getViewModel().activatePagesSelectionMode(false);
    }
}

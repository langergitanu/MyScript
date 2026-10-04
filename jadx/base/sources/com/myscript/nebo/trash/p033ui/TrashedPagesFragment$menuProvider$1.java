package com.myscript.nebo.trash.p033ui;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.core.view.MenuProvider;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.trash.TrashedPagesUIState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;

/* JADX INFO: compiled from: TrashedPagesFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, m1599d2 = {"com/myscript/nebo/trash/ui/TrashedPagesFragment$menuProvider$1", "Landroidx/core/view/MenuProvider;", "onCreateMenu", "", "menu", "Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "onPrepareMenu", "onMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TrashedPagesFragment$menuProvider$1 implements MenuProvider {
    final /* synthetic */ TrashedPagesFragment this$0;

    TrashedPagesFragment$menuProvider$1(TrashedPagesFragment trashedPagesFragment) {
        this.this$0 = trashedPagesFragment;
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "menuInflater");
        menu.clear();
        menuInflater.inflate(C6079R.menu.trashed_pages_menu, menu);
    }

    @Override // androidx.core.view.MenuProvider
    public void onPrepareMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        super.onPrepareMenu(menu);
        MenuItem menuItemFindItem = menu.findItem(C6079R.id.trash_pages_select);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(this.this$0.getViewModel().getEnablePagesMenuActions());
        }
        MenuItem menuItemFindItem2 = menu.findItem(C6079R.id.trash_recover_all_pages);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setEnabled(this.this$0.getViewModel().getEnablePagesMenuActions());
        }
        MenuItem menuItemFindItem3 = menu.findItem(C6079R.id.trash_delete_all_pages);
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setEnabled(this.this$0.getViewModel().getEnablePagesMenuActions());
        }
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        ImmutableList<PageModel> pages;
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        int itemId = menuItem.getItemId();
        if (itemId == C6079R.id.trash_recover_all_pages) {
            this.this$0.getViewModel().restoreAllPages();
        } else if (itemId == C6079R.id.trash_pages_select) {
            this.this$0.getViewModel().activatePagesSelectionMode(true);
        } else {
            int size = 0;
            if (itemId != C6079R.id.trash_delete_all_pages) {
                return false;
            }
            TrashedPagesUIState value = this.this$0.getViewModel().getTrashedPagesState().getValue();
            if (value != null && (pages = value.getPages()) != null) {
                size = pages.size();
            }
            final TrashedPagesFragment trashedPagesFragment = this.this$0;
            trashedPagesFragment.displayDeleteConfirmationDialog(size, new Function0() { // from class: com.myscript.nebo.trash.ui.TrashedPagesFragment$menuProvider$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TrashedPagesFragment$menuProvider$1.onMenuItemSelected$lambda$0(trashedPagesFragment);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onMenuItemSelected$lambda$0(TrashedPagesFragment trashedPagesFragment) {
        trashedPagesFragment.getViewModel().deleteAllPages();
        return Unit.INSTANCE;
    }
}

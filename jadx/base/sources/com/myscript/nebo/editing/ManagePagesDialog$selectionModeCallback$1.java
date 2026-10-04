package com.myscript.nebo.editing;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.FragmentManager;
import com.myscript.android.utils.SelectionMode;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.RetailMode;
import com.myscript.nebo.export.ExportDialog;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.p022ai.AISummarizeTrigger;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.PDFManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManagePagesDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000e"}, m1599d2 = {"com/myscript/nebo/editing/ManagePagesDialog$selectionModeCallback$1", "Lcom/myscript/android/utils/SelectionMode$Callback;", "onCreateSelectionMode", "", "mode", "Lcom/myscript/android/utils/SelectionMode;", "menu", "Landroid/view/Menu;", "onPrepareSelectionMode", "onSelectionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroySelectionMode", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ManagePagesDialog$selectionModeCallback$1 implements SelectionMode.Callback {
    final /* synthetic */ ManagePagesDialog this$0;

    ManagePagesDialog$selectionModeCallback$1(ManagePagesDialog managePagesDialog) {
        this.this$0 = managePagesDialog;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onCreateSelectionMode(SelectionMode mode, Menu menu) {
        MenuInflater menuInflater;
        if (mode == null || (menuInflater = mode.getMenuInflater()) == null) {
            return true;
        }
        menuInflater.inflate(C6079R.menu.manage_pages_mode_menu, menu);
        return true;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onPrepareSelectionMode(SelectionMode mode, Menu menu) {
        int selectedPagesCount = this.this$0.getViewModel().getSelectedPagesCount();
        if (mode != null) {
            mode.setTitle(this.this$0.getResources().getQuantityString(C6079R.plurals.page_selected_count, selectedPagesCount, Integer.valueOf(selectedPagesCount)));
        }
        MenuItem menuItemFindItem = menu != null ? menu.findItem(C6079R.id.manage_pages_delete) : null;
        MenuItem menuItemFindItem2 = menu != null ? menu.findItem(C6079R.id.manage_pages_select_all) : null;
        MenuItem menuItemFindItem3 = menu != null ? menu.findItem(C6079R.id.manage_pages_deselect_all) : null;
        MenuItem menuItemFindItem4 = menu != null ? menu.findItem(C6079R.id.editing_view_more_menu_ai_summarize) : null;
        MenuItem menuItemFindItem5 = menu != null ? menu.findItem(C6079R.id.editing_view_more_menu_export) : null;
        MenuItem menuItemFindItem6 = menu != null ? menu.findItem(C6079R.id.editing_view_more_menu_ai_quiz) : null;
        if (menuItemFindItem4 != null) {
            menuItemFindItem4.setVisible(this.this$0.getAiSummarizationActive());
        }
        if (menuItemFindItem6 != null) {
            menuItemFindItem6.setVisible(this.this$0.getAiQuizActive());
        }
        boolean z = false;
        if (menuItemFindItem5 != null) {
            menuItemFindItem5.setVisible((this.this$0.getAiSummarizationActive() || this.this$0.getAiQuizActive() || RetailMode.INSTANCE.isEnabled()) ? false : true);
        }
        if (menuItemFindItem != null) {
            if (!this.this$0.getAiSummarizationActive() && !this.this$0.getAiQuizActive()) {
                z = true;
            }
            menuItemFindItem.setVisible(z);
        }
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(this.this$0.getViewModel().getCanDelete());
        }
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setVisible(this.this$0.getViewModel().getCanSelectAll());
        }
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setVisible(this.this$0.getViewModel().getCanDeselectAll());
        }
        return true;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onSelectionItemClicked(SelectionMode mode, MenuItem item) {
        Integer numValueOf = item != null ? Integer.valueOf(item.getItemId()) : null;
        int i = C6079R.id.manage_pages_delete;
        if (numValueOf != null && numValueOf.intValue() == i) {
            final ManagePagesDialog managePagesDialog = this.this$0;
            managePagesDialog.showDeleteConfirmationDialog(new Function0() { // from class: com.myscript.nebo.editing.ManagePagesDialog$selectionModeCallback$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ManagePagesDialog$selectionModeCallback$1.onSelectionItemClicked$lambda$0(managePagesDialog);
                }
            });
            return true;
        }
        int i2 = C6079R.id.manage_pages_select_all;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            this.this$0.getViewModel().selectAllPages();
            return true;
        }
        int i3 = C6079R.id.manage_pages_deselect_all;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            this.this$0.getViewModel().deselectAllPages();
            this.this$0.getViewModel().toggleSelectionMode(false);
            return true;
        }
        int i4 = C6079R.id.editing_view_more_menu_export;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            if (this.this$0.getViewModel().getPaginatedContainer() instanceof PDFManager) {
                TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), ManagePagesDialog.TAG, "Export from PDF multiple selection", null, 4, null);
                ExportDialog.Companion companion = ExportDialog.INSTANCE;
                PageKey openNoteKey = this.this$0.getViewModel().getOpenNoteKey();
                if (openNoteKey != null) {
                    ExportDialog exportDialogNewInstance$default = ExportDialog.Companion.newInstance$default(companion, CollectionsKt.listOf(openNoteKey), this.this$0.getViewModel().selectedPagesIndexes(), (String) null, 4, (Object) null);
                    FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                    exportDialogNewInstance$default.show(childFragmentManager);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), ManagePagesDialog.TAG, "Export from multiple selection", null, 4, null);
                ExportDialog exportDialogNewInstance$default2 = ExportDialog.Companion.newInstance$default(ExportDialog.INSTANCE, this.this$0.getViewModel().selectedPagesKeys(), (List) null, (String) null, 6, (Object) null);
                FragmentManager childFragmentManager2 = this.this$0.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
                exportDialogNewInstance$default2.show(childFragmentManager2);
            }
            return true;
        }
        int i5 = C6079R.id.editing_view_more_menu_ai_summarize;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            this.this$0.getAiSummarizeViewModel().summarizeAllPages(this.this$0.getViewModel().selectedPagesIds(), AISummarizeTrigger.CONTEXTUAL_MENU);
            this.this$0.dismiss();
            return true;
        }
        int i6 = C6079R.id.editing_view_more_menu_ai_quiz;
        if (numValueOf != null && numValueOf.intValue() == i6) {
            this.this$0.getAiQuizViewModel().onSourceSelectedChoosePages(this.this$0.getViewModel().selectedPagesIds());
            this.this$0.dismiss();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSelectionItemClicked$lambda$0(ManagePagesDialog managePagesDialog) {
        managePagesDialog.getViewModel().deleteSelectedPages();
        return Unit.INSTANCE;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public void onDestroySelectionMode(SelectionMode mode) {
        this.this$0.getViewModel().toggleSelectionMode(false);
    }
}

package com.myscript.atk.p021ui;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.myscript.atk.p021ui.SmartGuide;

/* JADX INFO: loaded from: classes4.dex */
public class SmartGuideContextualMenuController {
    private ActionMode mActionMode;

    public void showMoreMenu(final View view, final SmartGuideComponent smartGuideComponent, final SmartGuide.ActionListener actionListener) {
        this.mActionMode = view.startActionMode(new ActionMode.Callback2() { // from class: com.myscript.atk.ui.SmartGuideContextualMenuController.1
            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                MenuInflater menuInflater;
                if (actionMode == null || (menuInflater = actionMode.getMenuInflater()) == null) {
                    return true;
                }
                menuInflater.inflate(C6033R.menu.more_menu, menu);
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                int iAvailableActions = smartGuideComponent.availableActions();
                if (iAvailableActions != SmartGuideMoreActions.None.swigValue()) {
                    boolean z = true;
                    boolean z2 = (SmartGuideMoreActions.Beautify.swigValue() & iAvailableActions) == SmartGuideMoreActions.Beautify.swigValue() || (SmartGuideMoreActions.Typeset.swigValue() & iAvailableActions) == SmartGuideMoreActions.Typeset.swigValue();
                    MenuItem menuItemFindItem = menu.findItem(C6033R.id.more_menu_convert);
                    menuItemFindItem.setVisible(z2);
                    menuItemFindItem.setEnabled(!actionListener.isProcessPendingOrRequired());
                    menu.findItem(C6033R.id.more_menu_delete).setVisible((SmartGuideMoreActions.Delete.swigValue() & iAvailableActions) == SmartGuideMoreActions.Delete.swigValue());
                    boolean z3 = (SmartGuideMoreActions.Copy.swigValue() & iAvailableActions) == SmartGuideMoreActions.Copy.swigValue();
                    MenuItem menuItemFindItem2 = menu.findItem(C6033R.id.more_menu_copy);
                    menuItemFindItem2.setVisible(z3);
                    menuItemFindItem2.setEnabled(!actionListener.isProcessPendingOrRequired());
                    boolean z4 = (SmartGuideMoreActions.Cut.swigValue() & iAvailableActions) == SmartGuideMoreActions.Cut.swigValue();
                    MenuItem menuItemFindItem3 = menu.findItem(C6033R.id.more_menu_cut);
                    menuItemFindItem3.setVisible(z4);
                    menuItemFindItem3.setEnabled(!actionListener.isProcessPendingOrRequired());
                    menu.findItem(C6033R.id.more_menu_edit).setVisible((SmartGuideMoreActions.Edit.swigValue() & iAvailableActions) == SmartGuideMoreActions.Edit.swigValue());
                    menu.findItem(C6033R.id.more_menu_finish).setVisible((SmartGuideMoreActions.Finish.swigValue() & iAvailableActions) == SmartGuideMoreActions.Finish.swigValue());
                    menu.findItem(C6033R.id.more_menu_export_ppt).setVisible((SmartGuideMoreActions.ExportPPT.swigValue() & iAvailableActions) == SmartGuideMoreActions.ExportPPT.swigValue());
                    if ((SmartGuideMoreActions.MathApprox.swigValue() & iAvailableActions) != SmartGuideMoreActions.MathApprox.swigValue() && (SmartGuideMoreActions.MathDegRad.swigValue() & iAvailableActions) != SmartGuideMoreActions.MathDegRad.swigValue() && (iAvailableActions & SmartGuideMoreActions.MathSolver.swigValue()) != SmartGuideMoreActions.MathSolver.swigValue()) {
                        z = false;
                    }
                    menu.findItem(C6033R.id.more_menu_settings).setVisible(z);
                }
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                if (SmartGuideContextualMenuController.this.mActionMode != null) {
                    SmartGuideContextualMenuController.this.mActionMode.finish();
                }
                if (smartGuideComponent == null || actionListener == null) {
                    return true;
                }
                int itemId = menuItem.getItemId();
                if (itemId == C6033R.id.more_menu_convert || itemId == C6033R.id.more_menu_edit || itemId == C6033R.id.more_menu_finish) {
                    actionListener.onTypesetTriggered(smartGuideComponent);
                    return true;
                }
                if (itemId == C6033R.id.more_menu_copy) {
                    actionListener.onCopyTriggered(smartGuideComponent);
                    return true;
                }
                if (itemId == C6033R.id.more_menu_cut) {
                    actionListener.onCutTriggered(smartGuideComponent);
                    return true;
                }
                if (itemId == C6033R.id.more_menu_delete) {
                    actionListener.onDeleteTriggered(smartGuideComponent);
                    return true;
                }
                if (itemId == C6033R.id.more_menu_export_ppt) {
                    actionListener.onPowerPointExportTriggered(smartGuideComponent);
                    return true;
                }
                if (itemId != C6033R.id.more_menu_settings) {
                    return true;
                }
                SmartGuideContextualMenuController.this.showMathSettingsMenu(view, smartGuideComponent);
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
                SmartGuideContextualMenuController.this.mActionMode = null;
            }
        }, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMathSettingsMenu(final View view, final SmartGuideComponent smartGuideComponent) {
        this.mActionMode = view.startActionMode(new ActionMode.Callback2() { // from class: com.myscript.atk.ui.SmartGuideContextualMenuController.2
            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                MenuInflater menuInflater;
                if (actionMode == null || (menuInflater = actionMode.getMenuInflater()) == null) {
                    return true;
                }
                menuInflater.inflate(C6033R.menu.math_settings, menu);
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                if (SmartGuideContextualMenuController.this.mActionMode != null) {
                    SmartGuideContextualMenuController.this.mActionMode.finish();
                }
                int itemId = menuItem.getItemId();
                if (itemId == C6033R.id.more_menu_math_approx) {
                    new SettingsDialog(view.getContext(), smartGuideComponent, SmartGuideMoreActions.MathApprox);
                    return false;
                }
                if (itemId == C6033R.id.more_menu_math_degrad) {
                    new SettingsDialog(view.getContext(), smartGuideComponent, SmartGuideMoreActions.MathDegRad);
                    return false;
                }
                if (itemId != C6033R.id.more_menu_math_solver) {
                    return false;
                }
                new SettingsDialog(view.getContext(), smartGuideComponent, SmartGuideMoreActions.MathSolver);
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
                SmartGuideContextualMenuController.this.mActionMode = null;
            }
        }, 1);
    }

    public boolean finish() {
        ActionMode actionMode = this.mActionMode;
        if (actionMode == null) {
            return false;
        }
        actionMode.finish();
        return true;
    }
}

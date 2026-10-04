package com.myscript.nebo.editing;

import android.app.Application;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.core.view.MenuCompat;
import androidx.core.view.MenuProvider;
import androidx.preference.PreferenceManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.atk.core.ContentTypes;
import com.myscript.atk.core.EngineError;
import com.myscript.atk.core.p020ui.PageView;
import com.myscript.atk.core.p020ui.utils.FontManager;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.RetailMode;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.common.utils.PlatformUtils;
import com.myscript.nebo.editing.PageFragment;
import com.myscript.nebo.editing.PageViewModel;
import com.myscript.nebo.editing.background.PageBackgroundFragment;
import com.myscript.nebo.freemium.FreemiumLimitationTrigger;
import com.myscript.nebo.freemium.FreemiumLimitationViewModel;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.penpanel.PenDetectionDialog;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.Page;
import com.myscript.snt.dms.PageType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, m1599d2 = {"com/myscript/nebo/editing/PageFragment$menuProvider$1", "Landroidx/core/view/MenuProvider;", "onCreateMenu", "", "menu", "Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "onPrepareMenu", "onMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageFragment$menuProvider$1 implements MenuProvider {
    final /* synthetic */ PageFragment this$0;

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "menuInflater");
    }

    PageFragment$menuProvider$1(PageFragment pageFragment) {
        this.this$0 = pageFragment;
    }

    @Override // androidx.core.view.MenuProvider
    public void onPrepareMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        super.onPrepareMenu(menu);
        TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Prepare options menu", null, 4, null);
        boolean z = this.this$0.getPageViewModel().getContainerPageKey() != null;
        PageViewModel.MenuCapabilities value = this.this$0.getPageViewModel().getMenuCapabilities().getValue();
        if (value == null) {
            value = new PageViewModel.MenuCapabilities(false, null, false, false, false, false, false, 127, null);
        }
        boolean zIsTypesetAvailable = value.isTypesetAvailable();
        boolean zContains = value.getAddBlockTypes().contains(ContentTypes.IMAGE);
        boolean zContains2 = value.getAddBlockTypes().contains(ContentTypes.DRAWING);
        boolean zContains3 = value.getAddBlockTypes().contains(ContentTypes.DIAGRAM);
        boolean zContains4 = value.getAddBlockTypes().contains(ContentTypes.MATH);
        boolean zContains5 = value.getAddBlockTypes().contains(ContentTypes.RAW_CONTENT);
        boolean hasContentToTypeset = value.getHasContentToTypeset();
        boolean hasContentToClear = value.getHasContentToClear();
        boolean z2 = value.isClearAllAvailable() && !z;
        boolean z3 = value.isClearAllAnnotationsAvailable() && !z;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.this$0.requireActivity().getApplication());
        PageViewModel.PageState value2 = this.this$0.getPageViewModel().getPageState().getValue();
        if (value2 == null) {
            value2 = new PageViewModel.PageState(false, false, false, 7, null);
        }
        boolean z4 = z;
        MenuItem menuItemFindItem = menu.findItem(C6079R.id.editing_view_more_menu_undo);
        PageViewModel.PageState pageState = value2;
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(pageState.getCanUndo());
        }
        MenuItem menuItemFindItem2 = menu.findItem(C6079R.id.editing_view_more_menu_redo);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setEnabled(pageState.getCanRedo());
        }
        MenuItem menuItemFindItem3 = menu.findItem(C6079R.id.editing_view_more_menu_search);
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setEnabled(pageState.getHasContent() || z4);
            menuItemFindItem3.setVisible(z4 || pageState.getHasContent());
        }
        MenuItem menuItemFindItem4 = menu.findItem(C6079R.id.editing_view_more_menu_typesetAll);
        if (menuItemFindItem4 != null) {
            menuItemFindItem4.setEnabled(hasContentToTypeset);
            menuItemFindItem4.setVisible(zIsTypesetAvailable);
        }
        MenuItem menuItemFindItem5 = menu.findItem(C6079R.id.editing_view_more_menu_add);
        if (menuItemFindItem5 != null) {
            boolean z5 = zContains || zContains || zContains2 || zContains3 || zContains4 || zContains5;
            menuItemFindItem5.setVisible(z5);
            menuItemFindItem5.setEnabled(z5);
        }
        MenuItem menuItemFindItem6 = menu.findItem(C6079R.id.toolbar_add_blocks_category);
        if (menuItemFindItem6 != null) {
            menuItemFindItem6.setVisible(zContains || zContains || zContains2 || zContains3 || zContains4);
        }
        MenuItem menuItemFindItem7 = menu.findItem(C6079R.id.toolbar_add_block_camera);
        if (menuItemFindItem7 != null) {
            menuItemFindItem7.setVisible(zContains);
        }
        MenuItem menuItemFindItem8 = menu.findItem(C6079R.id.toolbar_add_block_picture);
        if (menuItemFindItem8 != null) {
            menuItemFindItem8.setVisible(zContains);
        }
        MenuItem menuItemFindItem9 = menu.findItem(C6079R.id.toolbar_add_block_sketch);
        if (menuItemFindItem9 != null) {
            menuItemFindItem9.setVisible(zContains2);
        }
        MenuItem menuItemFindItem10 = menu.findItem(C6079R.id.toolbar_add_block_diagram);
        if (menuItemFindItem10 != null) {
            menuItemFindItem10.setVisible(zContains3);
        }
        MenuItem menuItemFindItem11 = menu.findItem(C6079R.id.toolbar_add_block_math);
        if (menuItemFindItem11 != null) {
            menuItemFindItem11.setVisible(zContains4);
        }
        MenuItem menuItemFindItem12 = menu.findItem(C6079R.id.toolbar_add_sections_category);
        if (menuItemFindItem12 != null) {
            menuItemFindItem12.setVisible(zContains5);
        }
        MenuItem menuItemFindItem13 = menu.findItem(C6079R.id.toolbar_add_section_draft);
        if (menuItemFindItem13 != null) {
            menuItemFindItem13.setVisible(zContains5);
        }
        MenuItem menuItemFindItem14 = menu.findItem(C6079R.id.editing_view_more_menu_clearAll);
        if (menuItemFindItem14 != null) {
            menuItemFindItem14.setVisible(z2);
            menuItemFindItem14.setEnabled(hasContentToClear);
        }
        MenuItem menuItemFindItem15 = menu.findItem(C6079R.id.editing_view_more_menu_clear_all_annotations);
        if (menuItemFindItem15 != null) {
            menuItemFindItem15.setVisible(z3);
            menuItemFindItem15.setEnabled(hasContentToClear);
        }
        MenuItem menuItemFindItem16 = menu.findItem(C6079R.id.editing_view_more_menu_pdf_optimization);
        if (menuItemFindItem16 != null) {
            menuItemFindItem16.setVisible(this.this$0.getPageViewModel().getOpenPageProperties().getPageType() == PageType.PDF && !z4);
        }
        MenuItem menuItemFindItem17 = menu.findItem(C6079R.id.editing_view_more_menu_share_page);
        if (menuItemFindItem17 != null) {
            menuItemFindItem17.setEnabled(value.getCanExport() && !z4);
            menuItemFindItem17.setVisible((z4 || RetailMode.INSTANCE.isEnabled()) ? false : true);
        }
        MenuItem menuItemFindItem18 = menu.findItem(C6079R.id.editing_view_more_menu_help);
        if (menuItemFindItem18 != null) {
            menuItemFindItem18.setVisible(!RetailMode.INSTANCE.isEnabled());
        }
        MenuItem menuItemFindItem19 = menu.findItem(C6079R.id.editing_view_more_menu_export);
        if (menuItemFindItem19 != null) {
            menuItemFindItem19.setVisible(!RetailMode.INSTANCE.isEnabled());
        }
        boolean zIsActivePenMode = CommonUtils.isActivePenMode(this.this$0.requireActivity().getApplication());
        MenuItem menuItemFindItem20 = menu.findItem(C6079R.id.editing_view_more_menu_toggle_active_pen_mode);
        if (menuItemFindItem20 != null) {
            menuItemFindItem20.setTitle(zIsActivePenMode ? C6079R.string.app_more_menu_disable_active_pen_mode : C6079R.string.app_more_menu_enable_active_pen_mode);
        }
        PageType pageType = this.this$0.getPageViewModel().getOpenPageProperties().getPageType();
        String strContentType = pageType != null ? Page.contentType(pageType) : null;
        MenuItem menuItemFindItem21 = menu.findItem(C6079R.id.editing_view_more_menu_toggle_conversion_preview);
        boolean zIsConversionPreviewSupported = strContentType != null ? PageController.isConversionPreviewSupported(strContentType) : false;
        if (menuItemFindItem21 != null) {
            menuItemFindItem21.setVisible(zIsConversionPreviewSupported);
        }
        if (zIsConversionPreviewSupported) {
            boolean z6 = defaultSharedPreferences.getBoolean(this.this$0.getString(C6079R.string.pref_prompter_key), this.this$0.getResources().getBoolean(C6079R.bool.pref_enable_prompter_default));
            if (menuItemFindItem21 != null) {
                menuItemFindItem21.setTitle(z6 ? C6079R.string.app_more_menu_disable_conversion_preview : C6079R.string.app_more_menu_enable_conversion_preview);
            }
        }
        boolean zCanConfigureBackgroundColor = strContentType != null ? PageController.canConfigureBackgroundColor(strContentType) : z4;
        MenuItem menuItemFindItem22 = menu.findItem(C6079R.id.editing_view_more_menu_configure_background);
        if (menuItemFindItem22 != null) {
            menuItemFindItem22.setVisible(zCanConfigureBackgroundColor);
        }
        MenuItem menuItemFindItem23 = menu.findItem(C6079R.id.editing_view_more_menu_toggle_freeform_alignment_guides);
        if (menuItemFindItem23 != null) {
            menuItemFindItem23.setTitle(this.this$0.getPageViewModel().hasFreeformAlignmentGuides() ? C6079R.string.app_more_menu_disable_freeform_alignment_guides : C6079R.string.app_more_menu_enable_freeform_alignment_guides);
        }
        MenuItem menuItemFindItem24 = menu.findItem(C6079R.id.editing_view_more_menu_toggle_tap_keyboard);
        if (menuItemFindItem24 != null) {
            menuItemFindItem24.setTitle(this.this$0.getPageViewModel().getShowKeyboardOnTap() ? C6079R.string.app_more_menu_disable_tap_for_keyboard : C6079R.string.app_more_menu_tap_for_keyboard);
        }
        MenuCompat.setGroupDividerEnabled(menu, true);
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        PageFragment.Callback callback;
        PageKey openPageKey;
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        this.this$0.blockPosition = null;
        int itemId = menuItem.getItemId();
        if (itemId == C6079R.id.editing_view_more_menu_undo) {
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Undo Menu", null, 4, null);
            this.this$0.getPageViewModel().undo();
            return true;
        }
        if (itemId == C6079R.id.editing_view_more_menu_redo) {
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Redo Menu", null, 4, null);
            this.this$0.getPageViewModel().redo();
            return true;
        }
        if (itemId == C6079R.id.double_tap_add_section_draft || itemId == C6079R.id.long_press_add_section_draft) {
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Create section from popup menu", null, 4, null);
            PageFragment pageFragment = this.this$0;
            String RAW_CONTENT = ContentTypes.RAW_CONTENT;
            Intrinsics.checkNotNullExpressionValue(RAW_CONTENT, "RAW_CONTENT");
            pageFragment.createAndAddBlock(RAW_CONTENT);
            return true;
        }
        if (itemId == C6079R.id.toolbar_add_section_draft) {
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Add Freeform Section Block Menu", null, 4, null);
            PageViewModel pageViewModel = this.this$0.getPageViewModel();
            String RAW_CONTENT2 = ContentTypes.RAW_CONTENT;
            Intrinsics.checkNotNullExpressionValue(RAW_CONTENT2, "RAW_CONTENT");
            pageViewModel.addBlock(RAW_CONTENT2);
            return true;
        }
        if (itemId == C6079R.id.toolbar_add_block_camera) {
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Request Camera Menu", null, 4, null);
            this.this$0.requestImageCapture();
            return true;
        }
        if (itemId == C6079R.id.toolbar_add_block_picture) {
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Request Image Menu", null, 4, null);
            this.this$0.requestImagePick();
            return true;
        }
        if (itemId == C6079R.id.toolbar_add_block_sketch) {
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Add Drawing Block Menu", null, 4, null);
            PageViewModel pageViewModel2 = this.this$0.getPageViewModel();
            String DRAWING = ContentTypes.DRAWING;
            Intrinsics.checkNotNullExpressionValue(DRAWING, "DRAWING");
            pageViewModel2.addBlock(DRAWING);
            return true;
        }
        if (itemId == C6079R.id.toolbar_add_block_diagram) {
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Add Diagram Block Menu", null, 4, null);
            PageViewModel pageViewModel3 = this.this$0.getPageViewModel();
            String DIAGRAM = ContentTypes.DIAGRAM;
            Intrinsics.checkNotNullExpressionValue(DIAGRAM, "DIAGRAM");
            pageViewModel3.addBlock(DIAGRAM);
            return true;
        }
        if (itemId == C6079R.id.toolbar_add_block_math) {
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Add Math Block Menu", null, 4, null);
            PageViewModel pageViewModel4 = this.this$0.getPageViewModel();
            String MATH = ContentTypes.MATH;
            Intrinsics.checkNotNullExpressionValue(MATH, "MATH");
            pageViewModel4.addBlock(MATH);
            return true;
        }
        if (itemId == C6079R.id.editing_view_more_menu_typesetAll) {
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Convert All Menu", null, 4, null);
            FreemiumLimitationViewModel freemiumLimitationViewModel = this.this$0.getFreemiumLimitationViewModel();
            FreemiumLimitationTrigger freemiumLimitationTrigger = FreemiumLimitationTrigger.TRIGGER_CONVERT_BLOCK;
            final PageFragment pageFragment2 = this.this$0;
            freemiumLimitationViewModel.tryUsePremiumFeature(freemiumLimitationTrigger, new Function0() { // from class: com.myscript.nebo.editing.PageFragment$menuProvider$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PageFragment$menuProvider$1.onMenuItemSelected$lambda$11(pageFragment2);
                }
            });
            return true;
        }
        if (itemId == C6079R.id.editing_view_more_menu_configure_background) {
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Show note background settings", null, 4, null);
            PageKey containerPageKey = this.this$0.getPageViewModel().getContainerPageKey();
            if (containerPageKey == null) {
                openPageKey = this.this$0.getPageViewModel().getOpenPageKey();
                if (openPageKey == null) {
                    return false;
                }
            } else {
                openPageKey = containerPageKey;
            }
            PageBackgroundFragment.INSTANCE.newInstance(containerPageKey != null, false, openPageKey, this.this$0.getPageViewModel().computeBackgroundSettingsUIState(openPageKey)).show(this.this$0.getParentFragmentManager(), PageBackgroundFragment.TAG);
            return true;
        }
        if (itemId == C6079R.id.editing_view_more_menu_clear_all_annotations || itemId == C6079R.id.editing_view_more_menu_clearAll) {
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Clear All Menu", null, 4, null);
            MaterialAlertDialogBuilder message = new MaterialAlertDialogBuilder(this.this$0.requireContext()).setMessage(C6079R.string.confirm_clear_all_message);
            int i = C6079R.string.app_more_menu_confirm_clearAll;
            final PageFragment pageFragment3 = this.this$0;
            MaterialAlertDialogBuilder positiveButton = message.setPositiveButton(i, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.editing.PageFragment$menuProvider$1$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    PageFragment$menuProvider$1.onMenuItemSelected$lambda$12(pageFragment3, dialogInterface, i2);
                }
            });
            int i2 = C6183R.string.dialog_cancel;
            final PageFragment pageFragment4 = this.this$0;
            positiveButton.setNegativeButton(i2, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.editing.PageFragment$menuProvider$1$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PageFragment$menuProvider$1.onMenuItemSelected$lambda$13(pageFragment4, dialogInterface, i3);
                }
            }).show();
            return true;
        }
        if (itemId == C6079R.id.editing_view_more_menu_pdf_optimization) {
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "PDF Optimization Menu", null, 4, null);
            this.this$0.getPageViewModel().showPdfOptimizationDialog();
            return true;
        }
        if (itemId == C6079R.id.editing_view_more_menu_share_page) {
            this.this$0.openSharePageDialog();
            return true;
        }
        if (itemId == C6079R.id.editing_view_more_menu_toggle_active_pen_mode) {
            final Application application = this.this$0.requireActivity().getApplication();
            Application application2 = application;
            boolean zIsActivePenMode = CommonUtils.isActivePenMode(application2);
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Toggle active pen (was " + (zIsActivePenMode ? "enabled" : "disabled") + ")", null, 4, null);
            if (!zIsActivePenMode && !CommonUtils.isPenUsed(this.this$0.requireContext())) {
                PenDetectionDialog penDetectionDialogNewInstance$default = PenDetectionDialog.Companion.newInstance$default(PenDetectionDialog.INSTANCE, false, 1, null);
                penDetectionDialogNewInstance$default.setCallback(new PenDetectionDialog.Callback() { // from class: com.myscript.nebo.editing.PageFragment$menuProvider$1$onMenuItemSelected$4$1
                    @Override // com.myscript.nebo.penpanel.PenDetectionDialog.Callback
                    public void onPenDetectionClosed(boolean penDetected, boolean aborted) {
                        if (penDetected) {
                            CommonUtils.savePenUsed(application, true);
                            CommonUtils.saveActivePenMode(application, true);
                        }
                    }
                });
                penDetectionDialogNewInstance$default.show(this.this$0.getParentFragmentManager(), PenDetectionDialog.TAG);
                return true;
            }
            CommonUtils.saveActivePenMode(application2, !zIsActivePenMode);
            return true;
        }
        if (itemId == C6079R.id.editing_view_more_menu_toggle_freeform_alignment_guides) {
            boolean zHasFreeformAlignmentGuides = this.this$0.getPageViewModel().hasFreeformAlignmentGuides();
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Toggle alignment guides preview (was " + (zHasFreeformAlignmentGuides ? "enabled" : "disabled") + ")", null, 4, null);
            this.this$0.getPageViewModel().setFreeformAlignmentGuides(!zHasFreeformAlignmentGuides);
            return true;
        }
        if (itemId == C6079R.id.editing_view_more_menu_toggle_conversion_preview) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.this$0.requireActivity().getApplication());
            boolean z = defaultSharedPreferences.getBoolean(this.this$0.getString(C6079R.string.pref_prompter_key), this.this$0.getResources().getBoolean(C6079R.bool.pref_enable_prompter_default));
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Toggle conversion preview (was " + (z ? "enabled" : "disabled") + ")", null, 4, null);
            Intrinsics.checkNotNull(defaultSharedPreferences);
            PageFragment pageFragment5 = this.this$0;
            SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
            editorEdit.putBoolean(pageFragment5.getString(C6079R.string.pref_prompter_key), !z);
            editorEdit.apply();
            return true;
        }
        if (itemId == C6079R.id.editing_view_more_menu_toggle_tap_keyboard) {
            Application application3 = this.this$0.requireActivity().getApplication();
            Intrinsics.checkNotNullExpressionValue(application3, "getApplication(...)");
            TechnicalLoggerExt.logAction$default(this.this$0.getLogger(), PageFragment.TAG, "Toggle show keyboard on tap (was " + (NeboKeyboardSettings.settings(application3).getShowKeyboardOnTap() ? "enabled" : "disabled") + ")", null, 4, null);
            this.this$0.getPageViewModel().toggleInteractionsToShowKeyboard();
            return true;
        }
        if (itemId == C6079R.id.editing_view_more_menu_help) {
            if (!PlatformUtils.openUrl(this.this$0.requireContext(), this.this$0.getString(C6079R.string.help_knowledge_base_from_page_url))) {
                Log.e(PageFragment.TAG, "No app found to handle url intent");
                return true;
            }
        } else {
            if (itemId == C6079R.id.app_moremenu_debugUnloadPage) {
                this.this$0.getPageViewModel().unloadPage();
                return true;
            }
            if (itemId == C6079R.id.app_moremenu_debug_toggle_pen_detected) {
                CommonUtils.savePenUsed(this.this$0.requireContext(), !CommonUtils.isPenUsed(this.this$0.requireContext()));
                CommonUtils.saveActivePenMode(this.this$0.requireContext(), !CommonUtils.isActivePenMode(this.this$0.requireContext()));
                PageFragment.Callback callback2 = this.this$0.callback;
                if (callback2 != null) {
                    callback2.onForceFinish(-1);
                    return true;
                }
            } else {
                if (itemId == C6079R.id.app_moremenu_debug_toggle_typeset_box_display) {
                    PageView.toggleTypesetBoxesDisplay();
                    return true;
                }
                if (itemId == C6079R.id.app_moremenu_debug_toggle_inter_font_tracking) {
                    FontManager.toggleInterFontTracking();
                    return true;
                }
                if (itemId == C6079R.id.app_moremenu_debugCrash) {
                    throw new EngineError(42, "This is a debug menu to simulate EngineError thrown from editing screen");
                }
                if (itemId != C6079R.id.app_moremenu_debugCorrupt) {
                    return false;
                }
                this.this$0.getPageViewModel().tagCorruptionInfoPage("Simulated corruption", "Page tagged corrupted for debug purpose");
                if (this.this$0.getPageViewModel().getOpenPageKey() != null && (callback = this.this$0.callback) != null) {
                    callback.onForceFinish(40);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onMenuItemSelected$lambda$11(PageFragment pageFragment) {
        pageFragment.getPageViewModel().convertAll();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMenuItemSelected$lambda$12(PageFragment pageFragment, DialogInterface dialogInterface, int i) {
        TechnicalLoggerExt.logAction$default(pageFragment.getLogger(), PageFragment.TAG, "Clear all confirmed", null, 4, null);
        pageFragment.getPageViewModel().clearAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMenuItemSelected$lambda$13(PageFragment pageFragment, DialogInterface dialogInterface, int i) {
        TechnicalLoggerExt.logAction$default(pageFragment.getLogger(), PageFragment.TAG, "Clear all canceled", null, 4, null);
        dialogInterface.dismiss();
    }
}

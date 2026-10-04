package com.myscript.nebo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.view.View;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.core.p020ui.utils.FontManager;
import com.myscript.atk.p021ui.MenuType;
import com.myscript.atk.p021ui.SmartGuide;
import com.myscript.atk.p021ui.SmartGuideComponent;
import com.myscript.atk.text.StyleType;
import com.myscript.nebo.common.utils.FeatureHelper;
import com.myscript.nebo.editing.EditingController;
import com.myscript.nebo.editing.impl.p027ui.DocumentTouchController;
import com.myscript.nebo.freemium.FreemiumLimitationTrigger;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.snt.core.LayoutGrid;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.SmartGuideManager;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes5.dex */
public class SmartGuideController implements DocumentTouchController.ScrollListener, SmartGuide.ActionListener, SharedPreferences.OnSharedPreferenceChangeListener {
    private static final String TAG = "SmartGuideController";
    private BlockActionCallback mBlockActionCallback;
    private WeakReference<EditingController> mEditingCtrlRef = new WeakReference<>(null);
    private TechnicalLogger mLogger;
    private SmartGuide mSmartGuide;

    public interface BlockActionCallback {
        void exportToPowerPoint(String str);

        void tryUsePremiumFeature(FreemiumLimitationTrigger freemiumLimitationTrigger, Function0<Unit> function0);
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ScrollListener
    public void onHorizontalScrollDisabledChanged(boolean z) {
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ScrollListener
    public void onScrollEnd(int i, int i2) {
    }

    public SmartGuideController(TechnicalLogger technicalLogger, BlockActionCallback blockActionCallback) {
        this.mLogger = technicalLogger;
        this.mBlockActionCallback = blockActionCallback;
    }

    public void setEditingController(EditingController editingController, View view) {
        PageController pageControllerNewRef;
        SmartGuideManager smartGuideManager;
        EditingController editingController2 = this.mEditingCtrlRef.get();
        if (editingController2 != null) {
            if (editingController2 == editingController) {
                return;
            }
            pageControllerNewRef = editingController2.getPageControllerNewRef();
            if (pageControllerNewRef != null) {
                try {
                    smartGuideManager = pageControllerNewRef.getSmartGuideManager();
                    if (smartGuideManager != null) {
                        try {
                            smartGuideManager.setSmartGuideComponentListener(null);
                            smartGuideManager.clearSmartGuide();
                        } finally {
                        }
                    }
                    if (smartGuideManager != null) {
                        smartGuideManager.close();
                    }
                } finally {
                }
            }
            if (pageControllerNewRef != null) {
                pageControllerNewRef.close();
            }
            Context context = editingController2.getContext();
            if (context != null) {
                PreferenceManager.getDefaultSharedPreferences(context).unregisterOnSharedPreferenceChangeListener(this);
            }
        }
        if (editingController != null && view != null) {
            pageControllerNewRef = editingController.getPageControllerNewRef();
            try {
                Context context2 = editingController.getContext();
                if (pageControllerNewRef != null && context2 != null) {
                    smartGuideManager = pageControllerNewRef.getSmartGuideManager();
                    try {
                        if (this.mSmartGuide == null) {
                            ViewTransform viewTransform = pageControllerNewRef.getViewTransform();
                            LayoutGrid grid = pageControllerNewRef.getGrid();
                            float fLineGap = grid.lineGap();
                            grid.delete();
                            SmartGuide smartGuide = new SmartGuide(context2, view, smartGuideManager.getSmartGuideComponent(), viewTransform, fLineGap, editingController.getTouchFeatureImpl().getVerticalScrollPos());
                            this.mSmartGuide = smartGuide;
                            smartGuide.setCustomTypeface(FontManager.getTypeface("MyScriptInter Regular"));
                            this.mSmartGuide.setBackgroundColor(-1);
                            this.mSmartGuide.setActionListener(this);
                        }
                        editingController.getTouchFeatureImpl().addScrollListener(this);
                        smartGuideManager.setSmartGuideComponentListener(this.mSmartGuide);
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
                        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
                        applyPreferences(defaultSharedPreferences, context2.getResources(), smartGuideManager);
                        if (smartGuideManager != null) {
                            smartGuideManager.close();
                        }
                        if (pageControllerNewRef != null) {
                            pageControllerNewRef.close();
                        }
                    } finally {
                        if (smartGuideManager == null) {
                            throw th;
                        }
                        try {
                            smartGuideManager.close();
                            throw th;
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                    }
                }
                if (pageControllerNewRef != null) {
                    pageControllerNewRef.close();
                    return;
                }
                return;
            } finally {
            }
        } else {
            this.mBlockActionCallback = null;
            SmartGuide smartGuide2 = this.mSmartGuide;
            if (smartGuide2 != null) {
                smartGuide2.setActionListener(null);
                this.mSmartGuide.clearSmartGuide();
                this.mSmartGuide.delete();
                this.mSmartGuide = null;
            }
        }
        this.mEditingCtrlRef = new WeakReference<>(editingController);
    }

    @Override // com.myscript.atk.ui.SmartGuide.ActionListener
    public boolean hasSelection() {
        EditingController editingController = this.mEditingCtrlRef.get();
        PageController pageControllerNewRef = editingController != null ? editingController.getPageControllerNewRef() : null;
        if (pageControllerNewRef == null) {
            if (pageControllerNewRef == null) {
                return false;
            }
            pageControllerNewRef.close();
            return false;
        }
        try {
            boolean zHasSelection = pageControllerNewRef.hasSelection();
            if (pageControllerNewRef != null) {
                pageControllerNewRef.close();
            }
            return zHasSelection;
        } catch (Throwable th) {
            if (pageControllerNewRef != null) {
                try {
                    pageControllerNewRef.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ScrollListener
    public void onScrollTo(int i, int i2) {
        SmartGuide smartGuide = this.mSmartGuide;
        if (smartGuide != null) {
            smartGuide.onScrollTo(i2);
        }
    }

    public boolean requestActionMenuDismiss() {
        SmartGuide smartGuide = this.mSmartGuide;
        if (smartGuide != null) {
            return smartGuide.requestActionMenuDismiss();
        }
        return false;
    }

    private void applyPreferences(SharedPreferences sharedPreferences, Resources resources, SmartGuideManager smartGuideManager) {
        smartGuideManager.setSettingsShowConversionPreview(sharedPreferences.getBoolean(resources.getString(C6079R.string.pref_prompter_key), resources.getBoolean(C6079R.bool.pref_enable_prompter_default)));
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        EditingController editingController = this.mEditingCtrlRef.get();
        Context context = editingController != null ? editingController.getContext() : null;
        if (context == null) {
            return;
        }
        PageController pageControllerNewRef = editingController.getPageControllerNewRef();
        if (pageControllerNewRef == null) {
            if (pageControllerNewRef != null) {
                pageControllerNewRef.close();
                return;
            }
            return;
        }
        try {
            SmartGuideManager smartGuideManager = pageControllerNewRef.getSmartGuideManager();
            try {
                applyPreferences(sharedPreferences, context.getResources(), smartGuideManager);
                if (smartGuideManager != null) {
                    smartGuideManager.close();
                }
                if (pageControllerNewRef != null) {
                    pageControllerNewRef.close();
                }
            } finally {
            }
        } catch (Throwable th) {
            if (pageControllerNewRef != null) {
                try {
                    pageControllerNewRef.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.myscript.atk.ui.SmartGuide.ActionListener
    public void onPowerPointExportTriggered(SmartGuideComponent smartGuideComponent) {
        EditingController editingController = this.mEditingCtrlRef.get();
        Context context = editingController != null ? editingController.getContext() : null;
        if (this.mBlockActionCallback == null || context == null || !FeatureHelper.checkFeatureAvailable(context, C6079R.bool.export_enabled)) {
            return;
        }
        TechnicalLogger technicalLogger = this.mLogger;
        Objects.requireNonNull(smartGuideComponent);
        TechnicalLoggerExt.logAction(technicalLogger, TAG, "Export to PPTX", new SmartGuideController$$ExternalSyntheticLambda0(smartGuideComponent));
        this.mBlockActionCallback.exportToPowerPoint(smartGuideComponent.prompterId());
    }

    @Override // com.myscript.atk.ui.SmartGuide.ActionListener
    public void onCopyTriggered(SmartGuideComponent smartGuideComponent) {
        EditingController editingController = this.mEditingCtrlRef.get();
        PageController pageControllerNewRef = editingController != null ? editingController.getPageControllerNewRef() : null;
        if (pageControllerNewRef != null) {
            try {
                TechnicalLogger technicalLogger = this.mLogger;
                Objects.requireNonNull(smartGuideComponent);
                TechnicalLoggerExt.logAction(technicalLogger, TAG, "Copy Block", new SmartGuideController$$ExternalSyntheticLambda0(smartGuideComponent));
                pageControllerNewRef.copy();
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }

    @Override // com.myscript.atk.ui.SmartGuide.ActionListener
    public void onCutTriggered(SmartGuideComponent smartGuideComponent) {
        EditingController editingController = this.mEditingCtrlRef.get();
        PageController pageControllerNewRef = editingController != null ? editingController.getPageControllerNewRef() : null;
        if (pageControllerNewRef != null) {
            try {
                TechnicalLogger technicalLogger = this.mLogger;
                Objects.requireNonNull(smartGuideComponent);
                TechnicalLoggerExt.logAction(technicalLogger, TAG, "Cut Block", new SmartGuideController$$ExternalSyntheticLambda0(smartGuideComponent));
                pageControllerNewRef.cut();
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }

    @Override // com.myscript.atk.ui.SmartGuide.ActionListener
    public void onDeleteTriggered(SmartGuideComponent smartGuideComponent) {
        EditingController editingController = this.mEditingCtrlRef.get();
        PageController pageControllerNewRef = editingController != null ? editingController.getPageControllerNewRef() : null;
        if (pageControllerNewRef != null) {
            try {
                TechnicalLogger technicalLogger = this.mLogger;
                Objects.requireNonNull(smartGuideComponent);
                TechnicalLoggerExt.logAction(technicalLogger, TAG, "Delete Block", new SmartGuideController$$ExternalSyntheticLambda0(smartGuideComponent));
                pageControllerNewRef.remove();
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }

    @Override // com.myscript.atk.ui.SmartGuide.ActionListener
    public void onTypesetTriggered(final SmartGuideComponent smartGuideComponent) {
        TechnicalLogger technicalLogger = this.mLogger;
        Objects.requireNonNull(smartGuideComponent);
        TechnicalLoggerExt.logAction(technicalLogger, TAG, "Convert Block", new SmartGuideController$$ExternalSyntheticLambda0(smartGuideComponent));
        this.mBlockActionCallback.tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_AI_BUTTON_SHOW_HIDE_SETTING, new Function0() { // from class: com.myscript.nebo.SmartGuideController$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SmartGuideController.lambda$onTypesetTriggered$0(smartGuideComponent);
            }
        });
    }

    static /* synthetic */ Unit lambda$onTypesetTriggered$0(SmartGuideComponent smartGuideComponent) {
        smartGuideComponent.typesetCurrentBox();
        return Unit.INSTANCE;
    }

    @Override // com.myscript.atk.ui.SmartGuide.ActionListener
    public void onListify(final SmartGuideComponent smartGuideComponent, final String str) {
        EditingController editingController = this.mEditingCtrlRef.get();
        PageController pageControllerNewRef = editingController != null ? editingController.getPageControllerNewRef() : null;
        if (pageControllerNewRef != null) {
            try {
                TechnicalLoggerExt.logAction(this.mLogger, TAG, "Listify Block", new Function0() { // from class: com.myscript.nebo.SmartGuideController$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SmartGuideController.lambda$onListify$1(str, smartGuideComponent);
                    }
                });
                pageControllerNewRef.listify(str, MenuType.SMARTGUIDE);
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }

    static /* synthetic */ String lambda$onListify$1(String str, SmartGuideComponent smartGuideComponent) {
        return str + " on " + smartGuideComponent.prompterId();
    }

    @Override // com.myscript.atk.ui.SmartGuide.ActionListener
    public void onTextify(SmartGuideComponent smartGuideComponent) {
        EditingController editingController = this.mEditingCtrlRef.get();
        PageController pageControllerNewRef = editingController != null ? editingController.getPageControllerNewRef() : null;
        if (pageControllerNewRef != null) {
            try {
                TechnicalLogger technicalLogger = this.mLogger;
                Objects.requireNonNull(smartGuideComponent);
                TechnicalLoggerExt.logAction(technicalLogger, TAG, "Textify Block", new SmartGuideController$$ExternalSyntheticLambda0(smartGuideComponent));
                pageControllerNewRef.textify(MenuType.SMARTGUIDE);
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }

    static /* synthetic */ String lambda$onBlockTypeChanged$2(StyleType styleType, SmartGuideComponent smartGuideComponent) {
        return styleType.name() + " on " + smartGuideComponent.prompterId();
    }

    @Override // com.myscript.atk.ui.SmartGuide.ActionListener
    public void onBlockTypeChanged(final SmartGuideComponent smartGuideComponent, final StyleType styleType) {
        TechnicalLoggerExt.logAction(this.mLogger, TAG, "Change Block Type", new Function0() { // from class: com.myscript.nebo.SmartGuideController$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SmartGuideController.lambda$onBlockTypeChanged$2(styleType, smartGuideComponent);
            }
        });
        smartGuideComponent.changeStyle(styleType.swigValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0026  */
    @Override // com.myscript.atk.ui.SmartGuide.ActionListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isProcessPendingOrRequired() {
        boolean z;
        EditingController editingController = this.mEditingCtrlRef.get();
        PageController pageControllerNewRef = editingController != null ? editingController.getPageControllerNewRef() : null;
        if (pageControllerNewRef != null) {
            try {
                z = pageControllerNewRef.isBusy();
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
        return z;
    }

    public void setBackgroundColor(int i) {
        SmartGuide smartGuide = this.mSmartGuide;
        if (smartGuide != null) {
            smartGuide.setBackgroundColor(i);
        }
    }
}

package com.myscript.nebo.editing.impl.p027ui;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import com.myscript.android.utils.ContextualMenu;
import com.myscript.android.utils.ContextualMenuExt;
import com.myscript.atk.core.IntInterval;
import com.myscript.atk.core.Point;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.p021ui.ActionMenuCallback;
import com.myscript.atk.p021ui.ActionMenuEntry;
import com.myscript.nebo.editing.impl.ActionMenuMapping;
import com.myscript.nebo.editing.impl.p027ui.ContextualMenuManager;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.p022ai.domain.AIActionMenuHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ContextualMenuManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 V2\u00020\u0001:\u0002UVB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010#H\u0002J\u0010\u00108\u001a\u0002062\b\u0010\u0013\u001a\u0004\u0018\u00010\u001eJ\u0010\u00109\u001a\u0002062\b\u0010\u0013\u001a\u0004\u0018\u00010 J\u0006\u0010:\u001a\u000206J\b\u0010;\u001a\u000201H\u0007J\b\u0010<\u001a\u000206H\u0007J\b\u0010=\u001a\u000206H\u0002J\b\u0010>\u001a\u000206H\u0002J*\u0010@\u001a\u0002062\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u000fH\u0007J\u0006\u0010F\u001a\u000201J\u0006\u0010G\u001a\u000201J$\u0010J\u001a\u0002062\b\u0010C\u001a\u0004\u0018\u00010\t2\b\u0010D\u001a\u0004\u0018\u00010\u000e2\b\u0010E\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010K\u001a\u0002062\b\u0010L\u001a\u0004\u0018\u00010\u0007J*\u0010M\u001a\u0002062\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010%2\b\u0010L\u001a\u0004\u0018\u00010'J\u0016\u0010@\u001a\u0002062\u0006\u0010A\u001a\u00020B2\u0006\u0010Q\u001a\u00020)J\u0016\u0010R\u001a\u0002062\u0006\u0010S\u001a\u0002032\u0006\u0010T\u001a\u000203R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010H\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\bI\u0010\u0012¨\u0006W"}, m1599d2 = {"Lcom/myscript/nebo/editing/impl/ui/ContextualMenuManager;", "", "<init>", "()V", "contextualMenu", "Lcom/myscript/android/utils/ContextualMenu;", "contextualMenuCallback", "Lcom/myscript/android/utils/ContextualMenu$Callback;", "value", "Landroid/graphics/RectF;", "offsetSelectionRect", "getOffsetSelectionRect", "()Landroid/graphics/RectF;", "selectionRange", "Lcom/myscript/atk/core/IntInterval;", "", "text", "getText", "()Ljava/lang/String;", "handler", "Landroid/os/Handler;", "backgroundThreadExecutor", "Ljava/util/concurrent/Executor;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "getLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "setLogger", "(Lcom/myscript/nebo/log/TechnicalLogger;)V", "aiActionMenuHandler", "Lcom/myscript/nebo/ai/domain/AIActionMenuHandler;", "localActionMenuHandler", "Lcom/myscript/nebo/editing/impl/ui/LocalActionMenuHandler;", "actionMenuEntries", "", "Lcom/myscript/atk/ui/ActionMenuEntry;", "actionMenuPoint", "Lcom/myscript/atk/core/Point;", "actionMenuCallback", "Lcom/myscript/atk/ui/ActionMenuCallback;", "viewTransform", "Lcom/myscript/atk/core/ViewTransform;", "actionMenuRetentionPolicy", "Lcom/myscript/nebo/editing/impl/ui/ContextualMenuManager$ActionMenuRetentionPolicy;", "getActionMenuRetentionPolicy", "()Lcom/myscript/nebo/editing/impl/ui/ContextualMenuManager$ActionMenuRetentionPolicy;", "setActionMenuRetentionPolicy", "(Lcom/myscript/nebo/editing/impl/ui/ContextualMenuManager$ActionMenuRetentionPolicy;)V", "actionMenuRetained", "", "verticalScrollPos", "", "horizontalScrollPos", "logAction", "", "action", "setAIActionMenuHandler", "setLocalActionMenuHandler", "requestActionMenuDismiss", "finishContextualMenu", "resetActionContextualMenuState", "closeActionContextualMenu", "showFloatingToolbar", "Ljava/lang/Runnable;", "showContextualMenu", "view", "Landroid/view/View;", "selectionRect", "range", "selectedText", "hasSelection", "hasValidSelection", "textSelection", "getTextSelection", "invalidateContextualMenu", "setContextualMenuCallback", "callback", "updateActionMenu", "actions", "", "inputPoint", "viewTransform2", "updateScrollPos", "scrollPosX", "scrollPosY", "ActionMenuRetentionPolicy", "Companion", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ContextualMenuManager {
    private static final boolean DBG = false;
    private static final String TAG;
    private ActionMenuCallback actionMenuCallback;
    private final List<ActionMenuEntry> actionMenuEntries;
    private Point actionMenuPoint;
    private boolean actionMenuRetained;
    private ActionMenuRetentionPolicy actionMenuRetentionPolicy;
    private AIActionMenuHandler aiActionMenuHandler;
    private final Executor backgroundThreadExecutor;
    private ContextualMenu contextualMenu;
    private ContextualMenu.Callback contextualMenuCallback;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private int horizontalScrollPos;
    private LocalActionMenuHandler localActionMenuHandler;
    private TechnicalLogger logger;
    private RectF offsetSelectionRect;
    private IntInterval selectionRange;
    private final Runnable showFloatingToolbar;
    private String text;
    private int verticalScrollPos;
    private ViewTransform viewTransform;

    /* JADX INFO: compiled from: ContextualMenuManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/editing/impl/ui/ContextualMenuManager$ActionMenuRetentionPolicy;", "", "shouldRetainActionMenu", "", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface ActionMenuRetentionPolicy {
        boolean shouldRetainActionMenu();
    }

    public ContextualMenuManager() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.backgroundThreadExecutor = executorServiceNewSingleThreadExecutor;
        this.actionMenuEntries = new ArrayList();
        this.showFloatingToolbar = new Runnable() { // from class: com.myscript.nebo.editing.impl.ui.ContextualMenuManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ContextualMenuManager.showFloatingToolbar$lambda$0(this.f$0);
            }
        };
    }

    public final RectF getOffsetSelectionRect() {
        return this.offsetSelectionRect;
    }

    public final String getText() {
        return this.text;
    }

    public final TechnicalLogger getLogger() {
        return this.logger;
    }

    public final void setLogger(TechnicalLogger technicalLogger) {
        this.logger = technicalLogger;
    }

    public final ActionMenuRetentionPolicy getActionMenuRetentionPolicy() {
        return this.actionMenuRetentionPolicy;
    }

    public final void setActionMenuRetentionPolicy(ActionMenuRetentionPolicy actionMenuRetentionPolicy) {
        this.actionMenuRetentionPolicy = actionMenuRetentionPolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logAction(ActionMenuEntry action) {
        TechnicalLogger technicalLogger;
        if (action == null || (technicalLogger = this.logger) == null) {
            return;
        }
        technicalLogger.logTrace("[" + TAG + "] " + action.name());
    }

    public final void setAIActionMenuHandler(AIActionMenuHandler handler) {
        this.aiActionMenuHandler = handler;
    }

    public final void setLocalActionMenuHandler(LocalActionMenuHandler handler) {
        this.localActionMenuHandler = handler;
    }

    public final void requestActionMenuDismiss() {
        ActionMenuCallback actionMenuCallback = this.actionMenuCallback;
        if (actionMenuCallback != null) {
            logAction(ActionMenuEntry.CLOSE);
        }
        if (actionMenuCallback != null) {
            actionMenuCallback.triggerActionAt(ActionMenuEntry.CLOSE, new Point());
        }
    }

    public final boolean finishContextualMenu() {
        ContextualMenu contextualMenu = this.contextualMenu;
        if (contextualMenu == null) {
            return false;
        }
        this.offsetSelectionRect = null;
        this.selectionRange = null;
        this.text = null;
        contextualMenu.finish();
        this.contextualMenu = null;
        return true;
    }

    public final void resetActionContextualMenuState() {
        finishContextualMenu();
        this.actionMenuEntries.clear();
        this.actionMenuRetained = false;
        ViewTransform viewTransform = this.viewTransform;
        if (viewTransform != null) {
            viewTransform.delete();
        }
        this.viewTransform = null;
        ActionMenuCallback actionMenuCallback = this.actionMenuCallback;
        if (actionMenuCallback != null) {
            actionMenuCallback.delete();
        }
        this.actionMenuCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeActionContextualMenu() {
        ActionMenuRetentionPolicy actionMenuRetentionPolicy = this.actionMenuRetentionPolicy;
        if (actionMenuRetentionPolicy != null && actionMenuRetentionPolicy.shouldRetainActionMenu() && !this.actionMenuEntries.isEmpty()) {
            this.actionMenuRetained = true;
            finishContextualMenu();
        } else {
            resetActionContextualMenuState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFloatingToolbar$lambda$0(ContextualMenuManager contextualMenuManager) {
        ContextualMenu contextualMenu = contextualMenuManager.contextualMenu;
        if (contextualMenu != null) {
            contextualMenu.hide(0L);
        }
    }

    private final void showFloatingToolbar() {
        ContextualMenu contextualMenu = this.contextualMenu;
        if (contextualMenu != null) {
            int doubleTapTimeout = ViewConfiguration.getDoubleTapTimeout();
            this.handler.removeCallbacks(this.showFloatingToolbar);
            this.handler.postDelayed(this.showFloatingToolbar, doubleTapTimeout);
            contextualMenu.invalidate();
        }
    }

    public final void showContextualMenu(final View view, final RectF selectionRect, final IntInterval range, final String selectedText) {
        ActionMenuRetentionPolicy actionMenuRetentionPolicy;
        Intrinsics.checkNotNullParameter(selectionRect, "selectionRect");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        if (this.actionMenuRetained && ((actionMenuRetentionPolicy = this.actionMenuRetentionPolicy) == null || !actionMenuRetentionPolicy.shouldRetainActionMenu())) {
            resetActionContextualMenuState();
        }
        this.offsetSelectionRect = selectionRect;
        this.selectionRange = range;
        this.text = selectedText;
        ViewTransform viewTransform = this.viewTransform;
        if (viewTransform != null && view != null) {
            showContextualMenu(view, viewTransform);
        } else {
            this.handler.post(new Runnable() { // from class: com.myscript.nebo.editing.impl.ui.ContextualMenuManager$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ContextualMenuManager.showContextualMenu$lambda$1(selectionRect, this, range, selectedText, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showContextualMenu$lambda$1(RectF rectF, final ContextualMenuManager contextualMenuManager, IntInterval intInterval, String str, View view) {
        IntInterval intInterval2;
        IntInterval intInterval3;
        if (Intrinsics.areEqual(rectF, contextualMenuManager.offsetSelectionRect) && (intInterval2 = contextualMenuManager.selectionRange) != null && intInterval.getBegin() == intInterval2.getBegin() && (intInterval3 = contextualMenuManager.selectionRange) != null && intInterval.getEnd() == intInterval3.getEnd() && Intrinsics.areEqual(str, contextualMenuManager.text)) {
            if (contextualMenuManager.contextualMenu == null) {
                if (view == null || contextualMenuManager.contextualMenuCallback == null) {
                    return;
                }
                contextualMenuManager.contextualMenu = ContextualMenuExt.startContextualMenu(view, new ContextualMenu.Callback() { // from class: com.myscript.nebo.editing.impl.ui.ContextualMenuManager$showContextualMenu$2$1
                    @Override // com.myscript.android.utils.ContextualMenu.Callback
                    public boolean onCreateContextualMenu(ContextualMenu contextualMenu, Menu menu) {
                        Intrinsics.checkNotNullParameter(contextualMenu, "contextualMenu");
                        Intrinsics.checkNotNullParameter(menu, "menu");
                        ContextualMenu.Callback callback = this.this$0.contextualMenuCallback;
                        if (callback != null) {
                            return callback.onCreateContextualMenu(contextualMenu, menu);
                        }
                        return false;
                    }

                    @Override // com.myscript.android.utils.ContextualMenu.Callback
                    public boolean onPrepareContextualMenu(ContextualMenu contextualMenu, Menu menu) {
                        Intrinsics.checkNotNullParameter(contextualMenu, "contextualMenu");
                        Intrinsics.checkNotNullParameter(menu, "menu");
                        ContextualMenu.Callback callback = this.this$0.contextualMenuCallback;
                        if (callback != null) {
                            return callback.onPrepareContextualMenu(contextualMenu, menu);
                        }
                        return false;
                    }

                    @Override // com.myscript.android.utils.ContextualMenu.Callback
                    public boolean onContextualMenuItemClicked(ContextualMenu contextualMenu, MenuItem item) {
                        Intrinsics.checkNotNullParameter(contextualMenu, "contextualMenu");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ContextualMenu.Callback callback = this.this$0.contextualMenuCallback;
                        if (callback != null) {
                            return callback.onContextualMenuItemClicked(contextualMenu, item);
                        }
                        return false;
                    }

                    @Override // com.myscript.android.utils.ContextualMenu.Callback
                    public boolean onContextualActionRequested(Function0<Unit> action, Object userData) {
                        Intrinsics.checkNotNullParameter(action, "action");
                        ContextualMenu.Callback callback = this.this$0.contextualMenuCallback;
                        if (callback != null) {
                            return callback.onContextualActionRequested(action, userData);
                        }
                        return false;
                    }

                    @Override // com.myscript.android.utils.ContextualMenu.Callback
                    public void onDestroyContextualMenu(ContextualMenu menu) {
                        Intrinsics.checkNotNullParameter(menu, "menu");
                        ContextualMenu.Callback callback = this.this$0.contextualMenuCallback;
                        if (callback != null) {
                            callback.onDestroyContextualMenu(menu);
                        }
                        if (menu == this.this$0.contextualMenu) {
                            this.this$0.contextualMenu = null;
                        }
                    }

                    @Override // com.myscript.android.utils.ContextualMenu.Callback
                    public void onGetContentRect(ContextualMenu contextualMenu, View view2, Rect outRect) {
                        Intrinsics.checkNotNullParameter(contextualMenu, "contextualMenu");
                        Intrinsics.checkNotNullParameter(view2, "view");
                        Intrinsics.checkNotNullParameter(outRect, "outRect");
                        ContextualMenu.Callback callback = this.this$0.contextualMenuCallback;
                        if (callback != null) {
                            callback.onGetContentRect(contextualMenu, view2, outRect);
                        }
                    }
                });
                return;
            }
            contextualMenuManager.showFloatingToolbar();
            ContextualMenu contextualMenu = contextualMenuManager.contextualMenu;
            if (contextualMenu != null) {
                contextualMenu.invalidateContentRect();
            }
        }
    }

    public final boolean hasSelection() {
        return this.offsetSelectionRect != null;
    }

    public final boolean hasValidSelection() {
        RectF rectF = this.offsetSelectionRect;
        if (!Intrinsics.areEqual(rectF != null ? Float.valueOf(rectF.width()) : null, 0.0f)) {
            return true;
        }
        RectF rectF2 = this.offsetSelectionRect;
        return !Intrinsics.areEqual(rectF2 != null ? Float.valueOf(rectF2.height()) : null, 0.0f);
    }

    public final String getTextSelection() {
        IntInterval intInterval;
        String str;
        if (!hasValidSelection() || (intInterval = this.selectionRange) == null || (str = this.text) == null) {
            return null;
        }
        String strSubstring = str.substring(intInterval.getBegin(), intInterval.getEnd());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final void invalidateContextualMenu(RectF selectionRect, IntInterval range, String selectedText) {
        this.offsetSelectionRect = selectionRect;
        this.selectionRange = range;
        this.text = selectedText;
        ContextualMenu contextualMenu = this.contextualMenu;
        if (contextualMenu != null) {
            contextualMenu.invalidateContentRect();
        }
        ContextualMenu contextualMenu2 = this.contextualMenu;
        if (contextualMenu2 != null) {
            contextualMenu2.invalidate();
        }
    }

    public final void setContextualMenuCallback(ContextualMenu.Callback callback) {
        this.contextualMenuCallback = callback;
    }

    public final void updateActionMenu(List<? extends ActionMenuEntry> actions, Point inputPoint, ActionMenuCallback callback) {
        List<? extends ActionMenuEntry> list = actions;
        if (list == null || list.isEmpty()) {
            if (!Looper.getMainLooper().isCurrentThread()) {
                this.handler.post(new Runnable() { // from class: com.myscript.nebo.editing.impl.ui.ContextualMenuManager$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.closeActionContextualMenu();
                    }
                });
                return;
            } else {
                closeActionContextualMenu();
                return;
            }
        }
        this.actionMenuRetained = false;
        this.actionMenuPoint = inputPoint;
        this.actionMenuCallback = callback;
        this.actionMenuEntries.clear();
        this.actionMenuEntries.addAll(list);
    }

    public final void showContextualMenu(View view, ViewTransform viewTransform2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewTransform2, "viewTransform2");
        this.viewTransform = ViewTransform.newRef(viewTransform2);
        ContextualMenu contextualMenu = this.contextualMenu;
        if (contextualMenu == null) {
            this.contextualMenu = ContextualMenuExt.startContextualMenu(view, new C64303());
        } else if (contextualMenu != null) {
            contextualMenu.invalidate();
            contextualMenu.invalidateContentRect();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.impl.ui.ContextualMenuManager$showContextualMenu$3 */
    /* JADX INFO: compiled from: ContextualMenuManager.kt */
    @Metadata(m1598d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¨\u0006\u0018"}, m1599d2 = {"com/myscript/nebo/editing/impl/ui/ContextualMenuManager$showContextualMenu$3", "Lcom/myscript/android/utils/ContextualMenu$Callback;", "onCreateContextualMenu", "", "contextualMenu", "Lcom/myscript/android/utils/ContextualMenu;", "menu", "Landroid/view/Menu;", "onPrepareContextualMenu", "onContextualMenuItemClicked", "item", "Landroid/view/MenuItem;", "onContextualActionRequested", "action", "Lkotlin/Function0;", "", "userData", "", "onDestroyContextualMenu", "onGetContentRect", "view", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class C64303 implements ContextualMenu.Callback {

        /* JADX INFO: renamed from: com.myscript.nebo.editing.impl.ui.ContextualMenuManager$showContextualMenu$3$WhenMappings */
        /* JADX INFO: compiled from: ContextualMenuManager.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ActionMenuEntry.values().length];
                try {
                    iArr[ActionMenuEntry.ADD_OBJECT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ActionMenuEntry.AI_SUMMARIZE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ActionMenuEntry.AI_EXPLAIN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ActionMenuEntry.AI_QUIZ.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ActionMenuEntry.CROP.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // com.myscript.android.utils.ContextualMenu.Callback
        public boolean onContextualActionRequested(Function0<Unit> action, Object userData) {
            Intrinsics.checkNotNullParameter(action, "action");
            return false;
        }

        @Override // com.myscript.android.utils.ContextualMenu.Callback
        public boolean onCreateContextualMenu(ContextualMenu contextualMenu, Menu menu) {
            Intrinsics.checkNotNullParameter(contextualMenu, "contextualMenu");
            Intrinsics.checkNotNullParameter(menu, "menu");
            return true;
        }

        @Override // com.myscript.android.utils.ContextualMenu.Callback
        public void onDestroyContextualMenu(ContextualMenu menu) {
            Intrinsics.checkNotNullParameter(menu, "menu");
        }

        C64303() {
        }

        @Override // com.myscript.android.utils.ContextualMenu.Callback
        public boolean onPrepareContextualMenu(ContextualMenu contextualMenu, Menu menu) {
            Intrinsics.checkNotNullParameter(contextualMenu, "contextualMenu");
            Intrinsics.checkNotNullParameter(menu, "menu");
            menu.clear();
            List list = ContextualMenuManager.this.actionMenuEntries;
            ContextualMenuManager contextualMenuManager = ContextualMenuManager.this;
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ActionMenuEntry actionMenuEntry = (ActionMenuEntry) obj;
                int iSwigValue = actionMenuEntry.swigValue();
                int i3 = ActionMenuMapping.ACTION_MENU_IDS.get(iSwigValue);
                int i4 = ActionMenuMapping.ACTION_MENU_LABELS.get(iSwigValue);
                if (i3 == 0 || i4 == 0) {
                    TechnicalLogger logger = contextualMenuManager.getLogger();
                    if (logger != null) {
                        logger.logTrace("Action not supported " + actionMenuEntry.name());
                    }
                } else {
                    menu.add(0, i3, i, i4);
                }
                i = i2;
            }
            TechnicalLogger logger2 = ContextualMenuManager.this.getLogger();
            if (logger2 == null) {
                return true;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("[%s] %s: %s", Arrays.copyOf(new Object[]{ContextualMenuManager.TAG, "Prepare lasso selection contextual menu", list}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            logger2.logTrace(str);
            return true;
        }

        @Override // com.myscript.android.utils.ContextualMenu.Callback
        public boolean onContextualMenuItemClicked(ContextualMenu contextualMenu, MenuItem item) {
            Intrinsics.checkNotNullParameter(contextualMenu, "contextualMenu");
            Intrinsics.checkNotNullParameter(item, "item");
            final ActionMenuCallback actionMenuCallback = ContextualMenuManager.this.actionMenuCallback;
            final Point point = ContextualMenuManager.this.actionMenuPoint;
            if (actionMenuCallback != null && point != null) {
                int iIndexOfValue = ActionMenuMapping.ACTION_MENU_IDS.indexOfValue(item.getItemId());
                int iKeyAt = iIndexOfValue != -1 ? ActionMenuMapping.ACTION_MENU_IDS.keyAt(iIndexOfValue) : -1;
                final ActionMenuEntry actionMenuEntrySwigToEnum = iKeyAt != -1 ? ActionMenuEntry.swigToEnum(iKeyAt) : null;
                int i = actionMenuEntrySwigToEnum != null ? WhenMappings.$EnumSwitchMapping$0[actionMenuEntrySwigToEnum.ordinal()] : -1;
                if (i == 1) {
                    ContextualMenuManager.this.logAction(ActionMenuEntry.CLOSE);
                    actionMenuCallback.triggerActionAt(ActionMenuEntry.CLOSE, point);
                    ContextualMenu.Callback callback = ContextualMenuManager.this.contextualMenuCallback;
                    if (callback != null) {
                        callback.onContextualMenuItemClicked(contextualMenu, item);
                    }
                } else if (i == 2) {
                    ContextualMenuManager.this.logAction(ActionMenuEntry.CLOSE);
                    actionMenuCallback.triggerActionAt(ActionMenuEntry.CLOSE, point);
                    ContextualMenu.Callback callback2 = ContextualMenuManager.this.contextualMenuCallback;
                    if (callback2 != null) {
                        final ContextualMenuManager contextualMenuManager = ContextualMenuManager.this;
                        callback2.onContextualActionRequested(new Function0() { // from class: com.myscript.nebo.editing.impl.ui.ContextualMenuManager$showContextualMenu$3$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ContextualMenuManager.C64303.onContextualMenuItemClicked$lambda$1(contextualMenuManager);
                            }
                        }, actionMenuEntrySwigToEnum);
                    }
                } else if (i == 3) {
                    ContextualMenuManager.this.logAction(ActionMenuEntry.CLOSE);
                    actionMenuCallback.triggerActionAt(ActionMenuEntry.CLOSE, point);
                    ContextualMenu.Callback callback3 = ContextualMenuManager.this.contextualMenuCallback;
                    if (callback3 != null) {
                        final ContextualMenuManager contextualMenuManager2 = ContextualMenuManager.this;
                        callback3.onContextualActionRequested(new Function0() { // from class: com.myscript.nebo.editing.impl.ui.ContextualMenuManager$showContextualMenu$3$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ContextualMenuManager.C64303.onContextualMenuItemClicked$lambda$2(contextualMenuManager2);
                            }
                        }, actionMenuEntrySwigToEnum);
                    }
                } else if (i == 4) {
                    ContextualMenuManager.this.logAction(ActionMenuEntry.CLOSE);
                    actionMenuCallback.triggerActionAt(ActionMenuEntry.CLOSE, point);
                    ContextualMenu.Callback callback4 = ContextualMenuManager.this.contextualMenuCallback;
                    if (callback4 != null) {
                        final ContextualMenuManager contextualMenuManager3 = ContextualMenuManager.this;
                        callback4.onContextualActionRequested(new Function0() { // from class: com.myscript.nebo.editing.impl.ui.ContextualMenuManager$showContextualMenu$3$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ContextualMenuManager.C64303.onContextualMenuItemClicked$lambda$3(contextualMenuManager3);
                            }
                        }, actionMenuEntrySwigToEnum);
                    }
                } else if (i != 5) {
                    ContextualMenuManager.this.logAction(actionMenuEntrySwigToEnum);
                    ContextualMenuManager.this.finishContextualMenu();
                    Executor executor = ContextualMenuManager.this.backgroundThreadExecutor;
                    final ContextualMenuManager contextualMenuManager4 = ContextualMenuManager.this;
                    executor.execute(new Runnable() { // from class: com.myscript.nebo.editing.impl.ui.ContextualMenuManager$showContextualMenu$3$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            ContextualMenuManager.C64303.onContextualMenuItemClicked$lambda$4(contextualMenuManager4, actionMenuEntrySwigToEnum, actionMenuCallback, point);
                        }
                    });
                } else {
                    LocalActionMenuHandler localActionMenuHandler = ContextualMenuManager.this.localActionMenuHandler;
                    if (localActionMenuHandler != null) {
                        localActionMenuHandler.cropImage(point);
                    }
                    ContextualMenuManager.this.logAction(ActionMenuEntry.CLOSE);
                    actionMenuCallback.triggerActionAt(ActionMenuEntry.CLOSE, point);
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onContextualMenuItemClicked$lambda$1(ContextualMenuManager contextualMenuManager) {
            AIActionMenuHandler aIActionMenuHandler = contextualMenuManager.aiActionMenuHandler;
            if (aIActionMenuHandler != null) {
                aIActionMenuHandler.summarizeText();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onContextualMenuItemClicked$lambda$2(ContextualMenuManager contextualMenuManager) {
            AIActionMenuHandler aIActionMenuHandler = contextualMenuManager.aiActionMenuHandler;
            if (aIActionMenuHandler != null) {
                aIActionMenuHandler.explainText();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onContextualMenuItemClicked$lambda$3(ContextualMenuManager contextualMenuManager) {
            AIActionMenuHandler aIActionMenuHandler = contextualMenuManager.aiActionMenuHandler;
            if (aIActionMenuHandler != null) {
                aIActionMenuHandler.quiz();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onContextualMenuItemClicked$lambda$4(ContextualMenuManager contextualMenuManager, final ActionMenuEntry actionMenuEntry, final ActionMenuCallback actionMenuCallback, final Point point) {
            try {
                ContextualMenu.Callback callback = contextualMenuManager.contextualMenuCallback;
                if (callback != null) {
                    callback.onContextualActionRequested(new Function0() { // from class: com.myscript.nebo.editing.impl.ui.ContextualMenuManager$showContextualMenu$3$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ContextualMenuManager.C64303.onContextualMenuItemClicked$lambda$4$0(actionMenuCallback, actionMenuEntry, point);
                        }
                    }, actionMenuEntry);
                }
            } catch (Exception e) {
                Log.e(ContextualMenuManager.TAG, "Trigger contextual menu action " + actionMenuEntry, e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onContextualMenuItemClicked$lambda$4$0(ActionMenuCallback actionMenuCallback, ActionMenuEntry actionMenuEntry, Point point) {
            actionMenuCallback.triggerActionAt(actionMenuEntry, point);
            return Unit.INSTANCE;
        }

        @Override // com.myscript.android.utils.ContextualMenu.Callback
        public void onGetContentRect(ContextualMenu contextualMenu, View view, Rect outRect) {
            ContextualMenuManager contextualMenuManager;
            Point point;
            Intrinsics.checkNotNullParameter(contextualMenu, "contextualMenu");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            if (ContextualMenuManager.this.actionMenuRetained) {
                ContextualMenu.Callback callback = ContextualMenuManager.this.contextualMenuCallback;
                if (callback != null) {
                    callback.onGetContentRect(contextualMenu, view, outRect);
                    return;
                }
                return;
            }
            ViewTransform viewTransform = ContextualMenuManager.this.viewTransform;
            if (viewTransform == null || (point = (contextualMenuManager = ContextualMenuManager.this).actionMenuPoint) == null) {
                return;
            }
            float fMapY = viewTransform.mapY(5.0f);
            float fMapX = viewTransform.mapX(point.getX()) - contextualMenuManager.horizontalScrollPos;
            float fMapY2 = (viewTransform.mapY(point.getY()) - contextualMenuManager.verticalScrollPos) - fMapY;
            int i = (int) fMapX;
            int i2 = (int) fMapY2;
            outRect.set(i, i2, i, view.getMeasuredHeight() + i2);
        }
    }

    public final void updateScrollPos(int scrollPosX, int scrollPosY) {
        this.horizontalScrollPos = scrollPosX;
        this.verticalScrollPos = scrollPosY;
    }

    static {
        Intrinsics.checkNotNullExpressionValue("ContextualMenuManager", "getSimpleName(...)");
        TAG = "ContextualMenuManager";
    }
}

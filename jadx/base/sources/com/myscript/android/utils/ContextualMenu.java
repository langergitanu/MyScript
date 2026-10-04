package com.myscript.android.utils;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextualMenu.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001b\u001c\u001dB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00002\u0006\u0010\t\u001a\u00020\nH ¢\u0006\u0002\b\u000bJ\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0082\u0001\u0001\u001e¨\u0006\u001f"}, m1599d2 = {"Lcom/myscript/android/utils/ContextualMenu;", "", "callback", "Lcom/myscript/android/utils/ContextualMenu$Callback;", "<init>", "(Lcom/myscript/android/utils/ContextualMenu$Callback;)V", "getCallback$android_utils_release", "()Lcom/myscript/android/utils/ContextualMenu$Callback;", TtmlNode.START, "view", "Landroid/view/View;", "start$android_utils_release", "invalidate", "", "invalidateContentRect", "hide", TypedValues.TransitionType.S_DURATION, "", "finish", "menu", "Landroid/view/Menu;", "getMenu", "()Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "getMenuInflater", "()Landroid/view/MenuInflater;", "Callback", "ActionModeMenu", "Companion", "Lcom/myscript/android/utils/ContextualMenu$ActionModeMenu;", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class ContextualMenu {
    public static final int DEFAULT_HIDE_DURATION = -1;
    private final Callback callback;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ContextualMenu.kt */
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/android/utils/ContextualMenu$Callback;", "", "onCreateContextualMenu", "", "contextualMenu", "Lcom/myscript/android/utils/ContextualMenu;", "menu", "Landroid/view/Menu;", "onPrepareContextualMenu", "onContextualMenuItemClicked", "item", "Landroid/view/MenuItem;", "onContextualActionRequested", "action", "Lkotlin/Function0;", "", "userData", "onDestroyContextualMenu", "onGetContentRect", "view", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        boolean onContextualActionRequested(Function0<Unit> action, Object userData);

        boolean onContextualMenuItemClicked(ContextualMenu contextualMenu, MenuItem item);

        boolean onCreateContextualMenu(ContextualMenu contextualMenu, Menu menu);

        void onDestroyContextualMenu(ContextualMenu menu);

        void onGetContentRect(ContextualMenu contextualMenu, View view, Rect outRect);

        boolean onPrepareContextualMenu(ContextualMenu contextualMenu, Menu menu);
    }

    public /* synthetic */ ContextualMenu(Callback callback, DefaultConstructorMarker defaultConstructorMarker) {
        this(callback);
    }

    public abstract void finish();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public void hide(long duration) {
    }

    public abstract void invalidate();

    public abstract void invalidateContentRect();

    public abstract ContextualMenu start$android_utils_release(View view);

    private ContextualMenu(Callback callback) {
        this.callback = callback;
    }

    /* JADX INFO: renamed from: getCallback$android_utils_release, reason: from getter */
    public final Callback getCallback() {
        return this.callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ContextualMenu.kt */
    @Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0010¢\u0006\u0002\b\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/android/utils/ContextualMenu$ActionModeMenu;", "Lcom/myscript/android/utils/ContextualMenu;", "callback", "Lcom/myscript/android/utils/ContextualMenu$Callback;", "floating", "", "<init>", "(Lcom/myscript/android/utils/ContextualMenu$Callback;Z)V", "actionMode", "Landroid/view/ActionMode;", TtmlNode.START, "view", "Landroid/view/View;", "start$android_utils_release", "hide", "", TypedValues.TransitionType.S_DURATION, "", "finish", "invalidate", "invalidateContentRect", "isFloatingMenu", "menu", "Landroid/view/Menu;", "getMenu", "()Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "getMenuInflater", "()Landroid/view/MenuInflater;", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final class ActionModeMenu extends ContextualMenu {
        private ActionMode actionMode;
        private final boolean floating;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionModeMenu(Callback callback, boolean z) {
            super(callback, null);
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.floating = z;
        }

        public /* synthetic */ ActionModeMenu(Callback callback, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(callback, (i & 2) != 0 ? true : z);
        }

        @Override // com.myscript.android.utils.ContextualMenu
        public ContextualMenu start$android_utils_release(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.startActionMode(new ActionMode.Callback2() { // from class: com.myscript.android.utils.ContextualMenu$ActionModeMenu$start$1
                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    Intrinsics.checkNotNullParameter(menu, "menu");
                    this.this$0.actionMode = mode;
                    return this.this$0.getCallback().onCreateContextualMenu(this.this$0, menu);
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    Intrinsics.checkNotNullParameter(mode, "mode");
                    Intrinsics.checkNotNullParameter(menu, "menu");
                    return this.this$0.getCallback().onPrepareContextualMenu(this.this$0, menu);
                }

                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    Intrinsics.checkNotNullParameter(mode, "mode");
                    Intrinsics.checkNotNullParameter(item, "item");
                    return this.this$0.getCallback().onContextualMenuItemClicked(this.this$0, item);
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(ActionMode mode) {
                    Intrinsics.checkNotNullParameter(mode, "mode");
                    this.this$0.getCallback().onDestroyContextualMenu(this.this$0);
                    this.this$0.actionMode = null;
                }

                @Override // android.view.ActionMode.Callback2
                public void onGetContentRect(ActionMode mode, View view2, Rect outRect) {
                    Intrinsics.checkNotNullParameter(mode, "mode");
                    Intrinsics.checkNotNullParameter(view2, "view");
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    super.onGetContentRect(mode, view2, outRect);
                    this.this$0.getCallback().onGetContentRect(this.this$0, view2, outRect);
                }
            }, this.floating ? 1 : 0);
            if (this.actionMode != null) {
                return this;
            }
            return null;
        }

        @Override // com.myscript.android.utils.ContextualMenu
        public void hide(long duration) {
            ActionMode actionMode;
            if (!getFloating() || (actionMode = this.actionMode) == null) {
                return;
            }
            actionMode.hide(duration);
        }

        @Override // com.myscript.android.utils.ContextualMenu
        public void finish() {
            ActionMode actionMode = this.actionMode;
            if (actionMode != null) {
                actionMode.finish();
            }
        }

        @Override // com.myscript.android.utils.ContextualMenu
        public void invalidate() {
            ActionMode actionMode = this.actionMode;
            if (actionMode != null) {
                actionMode.invalidate();
            }
        }

        @Override // com.myscript.android.utils.ContextualMenu
        public void invalidateContentRect() {
            ActionMode actionMode;
            if (!getFloating() || (actionMode = this.actionMode) == null) {
                return;
            }
            actionMode.invalidateContentRect();
        }

        /* JADX INFO: renamed from: isFloatingMenu, reason: from getter */
        public final boolean getFloating() {
            return this.floating;
        }

        @Override // com.myscript.android.utils.ContextualMenu
        public Menu getMenu() {
            ActionMode actionMode = this.actionMode;
            if (actionMode != null) {
                return actionMode.getMenu();
            }
            return null;
        }

        @Override // com.myscript.android.utils.ContextualMenu
        public MenuInflater getMenuInflater() {
            ActionMode actionMode = this.actionMode;
            if (actionMode != null) {
                return actionMode.getMenuInflater();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ContextualMenu.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\b\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/android/utils/ContextualMenu$Companion;", "", "<init>", "()V", "DEFAULT_HIDE_DURATION", "", "newInstance", "Lcom/myscript/android/utils/ContextualMenu;", "callback", "Lcom/myscript/android/utils/ContextualMenu$Callback;", "newInstance$android_utils_release", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ContextualMenu newInstance$android_utils_release(Callback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            return new ActionModeMenu(callback, true);
        }
    }
}

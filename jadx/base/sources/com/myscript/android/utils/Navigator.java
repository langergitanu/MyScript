package com.myscript.android.utils;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.myscript.android.utils.SelectionMode;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NestedFragmentNavigator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u00016B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\u0018\u001a\u0002H\u0019\"\b\b\u0000\u0010\u0019*\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0012¢\u0006\u0002\u0010\u001fJ&\u0010 \u001a\u00020\u0013\"\b\b\u0000\u0010\u0019*\u00020\u00152\u0006\u0010!\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0012J\u0006\u0010\"\u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u000fJ\u000e\u0010%\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u000fJ\u0006\u0010&\u001a\u00020\u0013J\u0006\u0010'\u001a\u00020\u0013J\u0006\u0010(\u001a\u00020\u0013J\r\u0010)\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010*J\u0006\u0010+\u001a\u00020\u001dJ\u001c\u0010,\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001c\u00100\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001c\u00101\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u00010\f2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u00104\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010\fH\u0016J\n\u00105\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u00067"}, m1599d2 = {"Lcom/myscript/android/utils/Navigator;", "Lcom/myscript/android/utils/SelectionMode$Callback;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerRes", "", "toolbarContainerRes", "<init>", "(Landroidx/fragment/app/FragmentManager;II)V", "getToolbarContainerRes", "()I", "selectionMode", "Lcom/myscript/android/utils/SelectionMode;", "listeners", "Ljava/util/HashSet;", "Lcom/myscript/android/utils/Navigator$Listener;", "Lkotlin/collections/HashSet;", "backStackChangedListener", "Lkotlin/Function0;", "", "activeFragment", "Landroidx/fragment/app/Fragment;", "getActiveFragment", "()Landroidx/fragment/app/Fragment;", "pushFragment", ExifInterface.GPS_DIRECTION_TRUE, "tag", "", "popBackStack", "", "newInstance", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)Landroidx/fragment/app/Fragment;", "restoreFragment", "fallbackTag", "popFragment", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "invalidateOptionsMenu", "startSelectionMode", "stopSelectionMode", "invalidateSelectionMode", "()Lkotlin/Unit;", "hasSelectionMode", "onCreateSelectionMode", "mode", "menu", "Landroid/view/Menu;", "onPrepareSelectionMode", "onSelectionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroySelectionMode", "getSelectionModeCallback", "Listener", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Navigator implements SelectionMode.Callback {
    public static final int $stable = 8;
    private final Function0<Unit> backStackChangedListener;
    private final int containerRes;
    private final FragmentManager fragmentManager;
    private final HashSet<Listener> listeners;
    private SelectionMode selectionMode;
    private final int toolbarContainerRes;

    /* JADX INFO: compiled from: NestedFragmentNavigator.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/android/utils/Navigator$Listener;", "", "onFragmentChanged", "", "fragment", "Landroidx/fragment/app/Fragment;", "invalidateOptionsMenu", "onSelectionModeStarted", "onSelectionModeStopped", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Listener {
        void invalidateOptionsMenu();

        void onFragmentChanged(Fragment fragment);

        void onSelectionModeStarted();

        void onSelectionModeStopped();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Fragment restoreFragment$lambda$0(Fragment fragment) {
        return fragment;
    }

    public Navigator(FragmentManager fragmentManager, int i, int i2) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.fragmentManager = fragmentManager;
        this.containerRes = i;
        this.toolbarContainerRes = i2;
        this.listeners = new HashSet<>();
        this.backStackChangedListener = new Function0() { // from class: com.myscript.android.utils.Navigator$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Navigator.backStackChangedListener$lambda$0(this.f$0);
            }
        };
    }

    public final int getToolbarContainerRes() {
        return this.toolbarContainerRes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit backStackChangedListener$lambda$0(Navigator navigator) {
        Fragment fragmentFindFragmentById = navigator.fragmentManager.findFragmentById(navigator.containerRes);
        Iterator<T> it = navigator.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onFragmentChanged(fragmentFindFragmentById);
        }
        return Unit.INSTANCE;
    }

    public final Fragment getActiveFragment() {
        return this.fragmentManager.findFragmentById(this.containerRes);
    }

    public final <T extends Fragment> T pushFragment(String tag, boolean popBackStack, Function0<? extends T> newInstance) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(newInstance, "newInstance");
        T t = (T) NestedFragmentNavigatorKt.showFragment(this.fragmentManager, this.containerRes, tag, popBackStack, newInstance);
        NestedFragment nestedFragment = t instanceof NestedFragment ? (NestedFragment) t : null;
        if (nestedFragment != null) {
            nestedFragment.setNavigator(this);
        }
        return t;
    }

    public final <T extends Fragment> void restoreFragment(String fallbackTag, Function0<? extends T> newInstance) {
        String name;
        Intrinsics.checkNotNullParameter(fallbackTag, "fallbackTag");
        Intrinsics.checkNotNullParameter(newInstance, "newInstance");
        int backStackEntryCount = this.fragmentManager.getBackStackEntryCount() - 1;
        if (backStackEntryCount >= 0 && (name = this.fragmentManager.getBackStackEntryAt(backStackEntryCount).getName()) != null) {
            fallbackTag = name;
        }
        final T tFindFragmentById = this.fragmentManager.findFragmentById(this.containerRes);
        if (tFindFragmentById == null) {
            tFindFragmentById = newInstance.invoke();
        }
        pushFragment(fallbackTag, true, new Function0() { // from class: com.myscript.android.utils.Navigator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Navigator.restoreFragment$lambda$0(tFindFragmentById);
            }
        });
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onFragmentChanged(tFindFragmentById);
        }
    }

    public final void popFragment() {
        this.fragmentManager.popBackStack();
        if (hasSelectionMode()) {
            stopSelectionMode();
        }
    }

    public final void addListener(Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
        if (this.listeners.size() == 1) {
            FragmentManager fragmentManager = this.fragmentManager;
            final Function0<Unit> function0 = this.backStackChangedListener;
            fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: com.myscript.android.utils.Navigator$$ExternalSyntheticLambda0
                @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
                public final void onBackStackChanged() {
                    function0.invoke();
                }
            });
        }
    }

    public final void removeListener(Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
        if (this.listeners.isEmpty()) {
            FragmentManager fragmentManager = this.fragmentManager;
            final Function0<Unit> function0 = this.backStackChangedListener;
            fragmentManager.removeOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: com.myscript.android.utils.Navigator$$ExternalSyntheticLambda2
                @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
                public final void onBackStackChanged() {
                    function0.invoke();
                }
            });
        }
    }

    public final void invalidateOptionsMenu() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).invalidateOptionsMenu();
        }
    }

    public final void startSelectionMode() {
        Fragment fragmentFindFragmentById = this.fragmentManager.findFragmentById(this.containerRes);
        FragmentActivity activity = fragmentFindFragmentById != null ? fragmentFindFragmentById.getActivity() : null;
        if (activity != null) {
            SelectionMode selectionModeStartSelectionMode = SelectionMode.startSelectionMode(activity, (ViewGroup) activity.findViewById(this.toolbarContainerRes), this);
            this.selectionMode = selectionModeStartSelectionMode;
            if (selectionModeStartSelectionMode != null) {
                selectionModeStartSelectionMode.invalidate();
            }
        }
    }

    public final void stopSelectionMode() {
        SelectionMode selectionMode = this.selectionMode;
        if (selectionMode != null) {
            selectionMode.finish();
        }
        this.selectionMode = null;
    }

    public final Unit invalidateSelectionMode() {
        SelectionMode selectionMode = this.selectionMode;
        if (selectionMode == null) {
            return null;
        }
        selectionMode.invalidate();
        return Unit.INSTANCE;
    }

    public final boolean hasSelectionMode() {
        return this.selectionMode != null;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onCreateSelectionMode(SelectionMode mode, Menu menu) {
        SelectionMode.Callback selectionModeCallback = getSelectionModeCallback();
        boolean zOnCreateSelectionMode = selectionModeCallback != null ? selectionModeCallback.onCreateSelectionMode(mode, menu) : false;
        if (zOnCreateSelectionMode) {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).onSelectionModeStarted();
            }
        }
        return zOnCreateSelectionMode;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onPrepareSelectionMode(SelectionMode mode, Menu menu) {
        SelectionMode.Callback selectionModeCallback = getSelectionModeCallback();
        if (selectionModeCallback != null) {
            return selectionModeCallback.onPrepareSelectionMode(mode, menu);
        }
        return false;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onSelectionItemClicked(SelectionMode mode, MenuItem item) {
        SelectionMode.Callback selectionModeCallback = getSelectionModeCallback();
        if (selectionModeCallback != null) {
            return selectionModeCallback.onSelectionItemClicked(mode, item);
        }
        return false;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public void onDestroySelectionMode(SelectionMode mode) {
        SelectionMode.Callback selectionModeCallback = getSelectionModeCallback();
        if (selectionModeCallback != null) {
            selectionModeCallback.onDestroySelectionMode(mode);
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onSelectionModeStopped();
        }
    }

    private final SelectionMode.Callback getSelectionModeCallback() {
        ActivityResultCaller activityResultCallerFindFragmentById = this.fragmentManager.findFragmentById(this.containerRes);
        if (activityResultCallerFindFragmentById instanceof SelectionMode.Callback) {
            return (SelectionMode.Callback) activityResultCallerFindFragmentById;
        }
        return null;
    }
}

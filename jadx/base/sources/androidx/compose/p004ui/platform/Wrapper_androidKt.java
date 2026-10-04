package androidx.compose.p004ui.platform;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.p004ui.C1271R;
import androidx.compose.p004ui.node.LayoutNode;
import androidx.compose.p004ui.node.UiApplier;
import androidx.compose.p004ui.platform.LifecycleRetainedValuesStoreOwner;
import androidx.compose.runtime.AbstractApplier;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.WeakHashMap;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Wrapper.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a,\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\r\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"createApplier", "Landroidx/compose/runtime/AbstractApplier;", "Landroidx/compose/ui/node/LayoutNode;", TtmlNode.RUBY_CONTAINER, "setContent", "Landroidx/compose/runtime/Composition;", "Landroidx/compose/ui/platform/AbstractComposeView;", "composeViewContext", "Landroidx/compose/ui/platform/ComposeViewContext;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AbstractComposeView;Landroidx/compose/ui/platform/ComposeViewContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "DefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class Wrapper_androidKt {
    private static final ViewGroup.LayoutParams DefaultLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    public static final AbstractApplier<LayoutNode> createApplier(LayoutNode layoutNode) {
        return new UiApplier(layoutNode);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Composition setContent(AbstractComposeView abstractComposeView, ComposeViewContext composeViewContext, Function2<? super Composer, ? super Integer, Unit> function2) {
        AndroidComposeView androidComposeView;
        WrappedComposition wrappedComposition;
        GlobalSnapshotManager.INSTANCE.ensureStarted();
        if (abstractComposeView.getChildCount() > 0) {
            View childAt = abstractComposeView.getChildAt(0);
            androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
            if (androidComposeView != null) {
                androidComposeView.setComposeViewContext(composeViewContext);
            }
            if (androidComposeView == null) {
                androidComposeView = new AndroidComposeView(abstractComposeView.getContext(), composeViewContext);
                abstractComposeView.addView(androidComposeView.getView(), DefaultLayoutParams);
            }
            androidComposeView.setComposeViewContext(composeViewContext);
            if (abstractComposeView.getComposeViewContext() != null) {
                composeViewContext.incrementViewCount$ui();
                androidComposeView.setComposeViewContextIncrementedDuringInit$ui(true);
            }
            if (InspectableValueKt.isDebugInspectorInfoEnabled() && androidComposeView.getTag(C1271R.id.inspection_slot_table_set) == null) {
                androidComposeView.setTag(C1271R.id.inspection_slot_table_set, Collections.newSetFromMap(new WeakHashMap()));
            }
            Object tag = androidComposeView.getTag(C1271R.id.wrapped_composition_tag);
            wrappedComposition = tag instanceof WrappedComposition ? (WrappedComposition) tag : null;
            if (wrappedComposition == null) {
                wrappedComposition = new WrappedComposition(androidComposeView, CompositionKt.Composition(new UiApplier(androidComposeView.getRoot()), composeViewContext.getCompositionContext()));
                androidComposeView.setTag(C1271R.id.wrapped_composition_tag, wrappedComposition);
            }
            wrappedComposition.setContent(function2);
            androidComposeView.setFrameEndScheduler$ui(new C14481(composeViewContext.getCompositionContext()));
            return wrappedComposition;
        }
        abstractComposeView.removeAllViews();
        androidComposeView = null;
        if (androidComposeView == null) {
        }
        androidComposeView.setComposeViewContext(composeViewContext);
        if (abstractComposeView.getComposeViewContext() != null) {
        }
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            androidComposeView.setTag(C1271R.id.inspection_slot_table_set, Collections.newSetFromMap(new WeakHashMap()));
        }
        Object tag2 = androidComposeView.getTag(C1271R.id.wrapped_composition_tag);
        if (tag2 instanceof WrappedComposition) {
        }
        if (wrappedComposition == null) {
        }
        wrappedComposition.setContent(function2);
        androidComposeView.setFrameEndScheduler$ui(new C14481(composeViewContext.getCompositionContext()));
        return wrappedComposition;
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.Wrapper_androidKt$setContent$1 */
    /* JADX INFO: compiled from: Wrapper.android.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    static final /* synthetic */ class C14481 implements LifecycleRetainedValuesStoreOwner.FrameEndScheduler, FunctionAdapter {
        final /* synthetic */ CompositionContext $tmp0;

        C14481(CompositionContext compositionContext) {
            this.$tmp0 = compositionContext;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof LifecycleRetainedValuesStoreOwner.FrameEndScheduler) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, this.$tmp0, CompositionContext.class, "scheduleFrameEndCallback", "scheduleFrameEndCallback(Lkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/CancellationHandle;", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.compose.ui.platform.LifecycleRetainedValuesStoreOwner.FrameEndScheduler
        public final CancellationHandle scheduleFrameEndCallback(Function0<Unit> function0) {
            return this.$tmp0.scheduleFrameEndCallback(function0);
        }
    }
}

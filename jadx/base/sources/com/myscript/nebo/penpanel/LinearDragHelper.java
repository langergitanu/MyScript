package com.myscript.nebo.penpanel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.TypedValue;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.common.utils.DisplayMetricsExtKt;
import com.myscript.nebo.penpanel.LinearDragHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LinearDragHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/LinearDragHelper;", "Landroidx/recyclerview/widget/ItemTouchHelper;", "orientation", "", "isLocked", "Lkotlin/Function1;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "onDrop", "Lkotlin/Function2;", "", "<init>", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LinearDragHelper extends ItemTouchHelper {
    private final Function1<RecyclerView.ViewHolder, Boolean> isLocked;
    private final Function2<Integer, Integer, Unit> onDrop;
    private final int orientation;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(RecyclerView.ViewHolder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return false;
    }

    public /* synthetic */ LinearDragHelper(int i, Function1 function1, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new Function1() { // from class: com.myscript.nebo.penpanel.LinearDragHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(LinearDragHelper._init_$lambda$0((RecyclerView.ViewHolder) obj));
            }
        } : function1, function2);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.penpanel.LinearDragHelper$2 */
    /* JADX INFO: compiled from: LinearDragHelper.kt */
    @Metadata(m1598d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J \u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J@\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\tH\u0016J@\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0016J\u0018\u0010#\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010$\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J(\u0010%\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u0010'\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, m1599d2 = {"com/myscript/nebo/penpanel/LinearDragHelper$2", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "itemAnimator", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "sourcePosition", "", "originalElevation", "", "isLongPressDragEnabled", "", "isItemViewSwipeEnabled", "onSwiped", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "direction", "getMovementFlags", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onMove", TypedValues.AttributesType.S_TARGET, "canDropOver", "current", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMoved", "fromPos", "toPos", "x", "y", "clearView", "onDragViewStart", "onDropView", FirebaseAnalytics.Param.SOURCE, "onCancel", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class C66882 extends ItemTouchHelper.Callback {
        final /* synthetic */ Function1<RecyclerView.ViewHolder, Boolean> $isLocked;
        final /* synthetic */ Function2<Integer, Integer, Unit> $onDrop;
        final /* synthetic */ int $orientation;
        private RecyclerView.ItemAnimator itemAnimator;
        private int sourcePosition = -1;
        private float originalElevation = -1.0f;

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isItemViewSwipeEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(target, "target");
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }

        /* JADX WARN: Multi-variable type inference failed */
        C66882(int i, Function1<? super RecyclerView.ViewHolder, Boolean> function1, Function2<? super Integer, ? super Integer, Unit> function2) {
            this.$orientation = i;
            this.$isLocked = function1;
            this.$onDrop = function2;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            if (this.itemAnimator == null) {
                this.itemAnimator = recyclerView.getItemAnimator();
            }
            int i = this.$orientation;
            int i2 = i != 0 ? i != 1 ? 0 : 3 : 48;
            if (this.$isLocked.invoke(viewHolder).booleanValue()) {
                return 0;
            }
            return ItemTouchHelper.Callback.makeMovementFlags(i2, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder current, RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(current, "current");
            Intrinsics.checkNotNullParameter(target, "target");
            if (this.$isLocked.invoke(target).booleanValue()) {
                return false;
            }
            return super.canDropOver(recyclerView, current, target);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            Intrinsics.checkNotNullParameter(c, "c");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            if (actionState == 2 && isCurrentlyActive && this.originalElevation < 0.0f) {
                onDragViewStart(recyclerView, viewHolder);
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int fromPos, RecyclerView.ViewHolder target, int toPos, int x, int y) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(target, "target");
            super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
            if (fromPos != toPos) {
                if (this.sourcePosition == -1) {
                    this.sourcePosition = fromPos;
                }
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyItemMoved(fromPos, toPos);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.clearView(recyclerView, viewHolder);
            int adapterPosition = viewHolder.getAdapterPosition();
            int i = this.sourcePosition;
            if (i != -1 && i != adapterPosition && adapterPosition != -1) {
                onDropView(recyclerView, viewHolder, i, adapterPosition);
            } else {
                onCancel(recyclerView, viewHolder);
            }
        }

        private final void onDragViewStart(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            float elevation = view.getElevation();
            this.originalElevation = elevation;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            float fApplyDimension = elevation + TypedValue.applyDimension(1, 8.0f, DisplayMetricsExtKt.getFixedDisplayMetrics(context));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "elevation", fApplyDimension), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleX", 1.1f), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleY", 1.1f));
            animatorSet.setDuration(view.getContext().getResources().getInteger(android.R.integer.config_shortAnimTime));
            animatorSet.start();
        }

        private final void onDropView(final RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, final int source, final int target) {
            View view = viewHolder.itemView;
            final Function2<Integer, Integer, Unit> function2 = this.$onDrop;
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "elevation", this.originalElevation), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleX", 1.0f), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleY", 1.0f));
            animatorSet.setDuration(view.getContext().getResources().getInteger(android.R.integer.config_shortAnimTime));
            animatorSet.start();
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.myscript.nebo.penpanel.LinearDragHelper$2$onDropView$lambda$1$0$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    recyclerView.setItemAnimator(null);
                    RecyclerView recyclerView2 = recyclerView;
                    final RecyclerView recyclerView3 = recyclerView;
                    final LinearDragHelper.C66882 c66882 = this;
                    recyclerView2.postDelayed(new Runnable() { // from class: com.myscript.nebo.penpanel.LinearDragHelper$2$onDropView$lambda$1$0$0$$inlined$postDelayed$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            recyclerView3.setItemAnimator(c66882.itemAnimator);
                        }
                    }, 100L);
                    function2.invoke(Integer.valueOf(source), Integer.valueOf(target));
                    this.sourcePosition = -1;
                    this.originalElevation = -1.0f;
                }
            });
        }

        private final void onCancel(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "elevation", this.originalElevation), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleX", 1.0f), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleY", 1.0f));
            animatorSet.setDuration(view.getContext().getResources().getInteger(android.R.integer.config_shortAnimTime));
            animatorSet.start();
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.myscript.nebo.penpanel.LinearDragHelper$2$onCancel$lambda$2$0$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.this$0.sourcePosition = -1;
                    this.this$0.originalElevation = -1.0f;
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LinearDragHelper(int i, Function1<? super RecyclerView.ViewHolder, Boolean> isLocked, Function2<? super Integer, ? super Integer, Unit> onDrop) {
        super(new C66882(i, isLocked, onDrop));
        Intrinsics.checkNotNullParameter(isLocked, "isLocked");
        Intrinsics.checkNotNullParameter(onDrop, "onDrop");
        this.orientation = i;
        this.isLocked = isLocked;
        this.onDrop = onDrop;
    }
}

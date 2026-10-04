package com.myscript.nebo.editing;

import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import androidx.viewpager2.widget.ViewPager2;
import com.myscript.nebo.C6079R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: renamed from: com.myscript.nebo.editing.EditingActivity$onChildPagesPagerUpdate$1$onPageScrollStateChanged$7 */
/* JADX INFO: compiled from: EditingActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.EditingActivity$onChildPagesPagerUpdate$1$onPageScrollStateChanged$7", m1609f = "EditingActivity.kt", m1610i = {0, 0, 0, 0, 0}, m1611l = {715}, m1612m = "invokeSuspend", m1613n = {"selectedPage", "progressFeedbackIndicator", "t0", "targetTime", "elapsedTime"}, m1614nl = {AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD}, m1615s = {"L$0", "L$1", "J$0", "J$1", "J$2"}, m1616v = 2)
final class C6353xf53906e0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $insertAtBottom;
    final /* synthetic */ View $progressFeedbackLayout;
    final /* synthetic */ Integer $selectedIndex;
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ EditingActivity this$0;
    final /* synthetic */ EditingActivity$onChildPagesPagerUpdate$1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C6353xf53906e0(EditingActivity editingActivity, EditingActivity$onChildPagesPagerUpdate$1 editingActivity$onChildPagesPagerUpdate$1, View view, Integer num, boolean z, Continuation<? super C6353xf53906e0> continuation) {
        super(2, continuation);
        this.this$0 = editingActivity;
        this.this$1 = editingActivity$onChildPagesPagerUpdate$1;
        this.$progressFeedbackLayout = view;
        this.$selectedIndex = num;
        this.$insertAtBottom = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C6353xf53906e0(this.this$0, this.this$1, this.$progressFeedbackLayout, this.$selectedIndex, this.$insertAtBottom, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C6353xf53906e0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        long j2;
        final ChildPage childPage;
        ProgressBar progressBar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ImmutableList<ChildPage> value = this.this$0.getChildPagesViewModel().getChildPages().getValue();
            ChildPage childPage2 = null;
            if (value != null) {
                Iterator<ChildPage> it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ChildPage next = it.next();
                    if (next.isActive()) {
                        childPage2 = next;
                        break;
                    }
                }
                childPage2 = childPage2;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            long j3 = this.this$1.createPageDelayMs + jUptimeMillis;
            ProgressBar progressBar2 = (ProgressBar) this.$progressFeedbackLayout.findViewById(C6079R.id.new_page_insertion_feedback_timer_progress_bar);
            progressBar2.setMax((int) this.this$1.createPageDelayMs);
            progressBar2.setProgress(0);
            j = jUptimeMillis;
            j2 = j3;
            childPage = childPage2;
            progressBar = progressBar2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j2 = this.J$1;
            j = this.J$0;
            progressBar = (ProgressBar) this.L$1;
            childPage = (ChildPage) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (SystemClock.uptimeMillis() < j2) {
            long jUptimeMillis2 = SystemClock.uptimeMillis() - j;
            progressBar.setProgress((int) jUptimeMillis2);
            this.L$0 = childPage;
            this.L$1 = progressBar;
            this.J$0 = j;
            this.J$1 = j2;
            this.J$2 = jUptimeMillis2;
            this.label = 1;
            if (DelayKt.delay(16L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        ViewPager2 viewPager2 = this.this$0.childPagesViewPager;
        if (viewPager2 == null || this.$selectedIndex.intValue() != viewPager2.getCurrentItem()) {
            return Unit.INSTANCE;
        }
        if (childPage != null) {
            EditingActivity$onChildPagesPagerUpdate$1 editingActivity$onChildPagesPagerUpdate$1 = this.this$1;
            final EditingActivity editingActivity = this.this$0;
            final boolean z = this.$insertAtBottom;
            editingActivity$onChildPagesPagerUpdate$1.createPageAction = new Function0() { // from class: com.myscript.nebo.editing.EditingActivity$onChildPagesPagerUpdate$1$onPageScrollStateChanged$7$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return C6353xf53906e0.invokeSuspend$lambda$0(editingActivity, childPage, z);
                }
            };
        }
        View view = this.$progressFeedbackLayout;
        Intrinsics.checkNotNull(view);
        view.setVisibility(8);
        ViewPager2 viewPager22 = this.this$0.childPagesViewPager;
        if (viewPager22 != null) {
            EditingActivityKt.cancelSwipeGesture(viewPager22);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(EditingActivity editingActivity, ChildPage childPage, boolean z) {
        editingActivity.getChildPagesViewModel().insertPage(childPage, z);
        return Unit.INSTANCE;
    }
}

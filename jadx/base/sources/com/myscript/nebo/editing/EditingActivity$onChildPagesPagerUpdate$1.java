package com.myscript.nebo.editing;

import android.gesture.GestureOverlayView;
import android.gesture.GesturePoint;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.myscript.android.utils.ViewExt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.editing.impl.p027ui.DocumentRenderingView;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.IPaginatedContainer;
import com.myscript.snt.dms.NotebookManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: EditingActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"com/myscript/nebo/editing/EditingActivity$onChildPagesPagerUpdate$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "createPageJob", "Lkotlinx/coroutines/Job;", "createPageAction", "Lkotlin/Function0;", "createPageDelayMs", "", "onPageScrollStateChanged", "state", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EditingActivity$onChildPagesPagerUpdate$1 extends ViewPager2.OnPageChangeCallback {
    private Function0<Unit> createPageAction;
    private final long createPageDelayMs = 1500;
    private Job createPageJob;
    final /* synthetic */ EditingActivity this$0;

    EditingActivity$onChildPagesPagerUpdate$1(EditingActivity editingActivity) {
        this.this$0 = editingActivity;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int position) {
        if (this.this$0.formerPagerPosition != -1) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new EditingActivity$onChildPagesPagerUpdate$1$onPageSelected$1(this.this$0, this.this$0.formerPagerPosition, null), 3, null);
        }
        this.this$0.formerPagerPosition = position;
        IPaginatedContainer paginatedContainer = this.this$0.getChildPagesViewModel().getPaginatedContainer();
        if (paginatedContainer instanceof NotebookManager) {
            NotebookManager notebookManager = (NotebookManager) paginatedContainer;
            List<com.myscript.snt.dms.PageProperties> listPages = notebookManager.pages();
            if (position < 0 || position >= listPages.size()) {
                return;
            }
            String pageId = listPages.get(position).getPageId();
            if (!Intrinsics.areEqual(notebookManager.selectedPage(), pageId)) {
                notebookManager.selectPage(pageId);
            }
            PageKey pageKeyCreateKeyFromUuid = PageKey.createKeyFromUuid(pageId);
            LibraryRepository libraryRepository = this.this$0.getLibraryRepository();
            Intrinsics.checkNotNull(pageKeyCreateKeyFromUuid);
            libraryRepository.saveOpenedPage(pageKeyCreateKeyFromUuid);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int state) {
        EditingController editingController;
        DocumentRenderingView renderingView;
        RecyclerView.Adapter adapter;
        ArrayList<GesturePoint> currentStroke;
        EditingController editingController2;
        EditingController editingController3;
        PageController pageController;
        PageFragment pageFragment;
        PageController pageController2;
        List listTakeLast;
        View viewFindViewById = this.this$0.findViewById(C6079R.id.new_page_insertion_feedback_layout);
        if (state != 1) {
            if (state == 2) {
                viewFindViewById.clearAnimation();
                Intrinsics.checkNotNull(viewFindViewById);
                viewFindViewById.setVisibility(8);
                Job job = this.createPageJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.createPageJob = null;
                this.createPageAction = null;
                return;
            }
            viewFindViewById.clearAnimation();
            Intrinsics.checkNotNull(viewFindViewById);
            viewFindViewById.setVisibility(8);
            Job job2 = this.createPageJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            this.createPageJob = null;
            Function0<Unit> function0 = this.createPageAction;
            if (function0 != null) {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new C6355x8b12d72e(function0, null), 3, null);
            }
            this.createPageAction = null;
            return;
        }
        PageFragment pageFragment2 = this.this$0.getPageFragment();
        if (pageFragment2 == null || !pageFragment2.isSpenToolboxVisible()) {
            PageFragment pageFragment3 = this.this$0.getPageFragment();
            if (pageFragment3 != null && (editingController = pageFragment3.getEditingController()) != null && (renderingView = editingController.getRenderingView()) != null) {
                ViewPager2 viewPager2 = this.this$0.childPagesViewPager;
                Integer numValueOf = viewPager2 != null ? Integer.valueOf(viewPager2.getCurrentItem()) : null;
                ViewPager2 viewPager22 = this.this$0.childPagesViewPager;
                if (viewPager22 != null && (adapter = viewPager22.getAdapter()) != null) {
                    GestureOverlayView gestureOverlayView = this.this$0.swipeTouchOverlay;
                    if (gestureOverlayView == null || (currentStroke = gestureOverlayView.getCurrentStroke()) == null || currentStroke.size() < 2) {
                        currentStroke = null;
                    }
                    boolean z = (currentStroke == null || (listTakeLast = CollectionsKt.takeLast(currentStroke, 10)) == null || ((GesturePoint) CollectionsKt.last(listTakeLast)).y >= ((GesturePoint) CollectionsKt.first(listTakeLast)).y) ? false : true;
                    boolean z2 = (renderingView.canScrollVertically(-1) || z) ? false : true;
                    boolean z3 = numValueOf != null && numValueOf.intValue() == 0 && z2;
                    int itemCount = adapter.getItemCount() - 1;
                    boolean z4 = !renderingView.canScrollVertically(1) && z;
                    boolean z5 = numValueOf != null && numValueOf.intValue() == itemCount && z4;
                    if (currentStroke != null) {
                        if (z2 || z4) {
                            if (z2 && numValueOf != null && numValueOf.intValue() > 0) {
                                PageFragment fragmentAtPosition = this.this$0.getFragmentAtPosition(numValueOf.intValue() - 1);
                                if (fragmentAtPosition != null && (editingController3 = fragmentAtPosition.getEditingController()) != null) {
                                    editingController3.scrollAtBottomByDefault(true);
                                    editingController3.computeGrid();
                                } else {
                                    EditingActivity editingActivity = this.this$0;
                                    String fragmentTagAtPosition = editingActivity.getFragmentTagAtPosition(numValueOf.intValue() - 1);
                                    editingActivity.scrollToBottom = fragmentTagAtPosition != null ? new Pair(fragmentTagAtPosition, true) : new Pair("", false);
                                }
                            }
                            if (z4 && numValueOf != null && numValueOf.intValue() < adapter.getItemCount() - 1) {
                                PageFragment fragmentAtPosition2 = this.this$0.getFragmentAtPosition(numValueOf.intValue() + 1);
                                if (fragmentAtPosition2 != null && (editingController2 = fragmentAtPosition2.getEditingController()) != null) {
                                    editingController2.scrollAtBottomByDefault(false);
                                    editingController2.computeGrid();
                                } else {
                                    EditingActivity editingActivity2 = this.this$0;
                                    String fragmentTagAtPosition2 = editingActivity2.getFragmentTagAtPosition(numValueOf.intValue() + 1);
                                    editingActivity2.scrollToBottom = fragmentTagAtPosition2 != null ? new Pair(fragmentTagAtPosition2, false) : new Pair("", false);
                                }
                            }
                        }
                        PageFragment pageFragment4 = this.this$0.getPageFragment();
                        if (pageFragment4 != null && (pageController = pageFragment4.getPageController()) != null && pageController.isCurrentToolPenDown() && (pageFragment = this.this$0.getPageFragment()) != null && (pageController2 = pageFragment.getPageController()) != null) {
                            pageController2.penAbort();
                        }
                        if (this.createPageJob == null && (z3 || z5)) {
                            this.createPageAction = null;
                            ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0.findViewById(C6079R.id.content_constraint_layout);
                            ConstraintSet constraintSet = new ConstraintSet();
                            constraintSet.clone(constraintLayout);
                            if (z3) {
                                constraintSet.connect(C6079R.id.new_page_insertion_feedback_layout, 3, 0, 3);
                                constraintSet.clear(C6079R.id.new_page_insertion_feedback_layout, 4);
                            } else {
                                constraintSet.clear(C6079R.id.new_page_insertion_feedback_layout, 3);
                                constraintSet.connect(C6079R.id.new_page_insertion_feedback_layout, 4, 0, 4);
                            }
                            constraintSet.applyTo(constraintLayout);
                            Intrinsics.checkNotNull(viewFindViewById);
                            ViewExt.fadeIn$default(viewFindViewById, 0L, 0L, 3, null);
                            this.createPageJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new C6353xf53906e0(this.this$0, this, viewFindViewById, numValueOf, z5, null), 3, null);
                        }
                    }
                }
            }
        }
    }
}

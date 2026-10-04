package com.myscript.nebo.videotutorial;

import android.app.Dialog;
import android.content.ComponentCallbacks2;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.viewpager.widget.ViewPager;
import com.myscript.nebo.videotutorial.IMediaPlayerConfigurer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TutorialFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\n\b&\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020#2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\u0012\u0010*\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0014H\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\b\u0010.\u001a\u00020\u001fH\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J \u00100\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00142\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0014H\u0016J\u0010\u00104\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0014H\u0016J\u0010\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u0014H\u0016J\u0010\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020!H\u0016J\b\u00109\u001a\u00020\u001fH\u0016J\b\u0010:\u001a\u00020\u001fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006<"}, m1599d2 = {"Lcom/myscript/nebo/videotutorial/TutorialFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "<init>", "()V", "tutorialPagerAdapter", "Lcom/myscript/nebo/videotutorial/TutorialPagerAdapter;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "pageIndicator", "Lcom/myscript/nebo/videotutorial/PageIndicator;", "doneButton", "Landroid/view/View;", "nextButton", "backButton", "firstLaunch", "", "title", "", "getTitle", "()I", "data", "", "Lcom/myscript/nebo/videotutorial/TutorialData;", "getData", "()[Lcom/myscript/nebo/videotutorial/TutorialData;", "isCompleted", "()Z", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onStart", "onActivityCreated", "updateButtonsState", "position", "onDoneButtonClicked", "onNextButtonClicked", "onBackButtonClicked", "onPageScrolled", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onPageScrollStateChanged", "state", "onSaveInstanceState", "outState", "onStop", "onDestroy", "Companion", "video-tutorial_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class TutorialFragment extends DialogFragment implements ViewPager.OnPageChangeListener {
    public static final String TAG = "TutorialFragment";
    public static final String TUTORIAL_DIALOG_REQUEST_KEY = "TutorialFragment_DIALOG_REQUEST_KEY";
    public static final String TUTORIAL_DIALOG_RESULT_KEY = "TutorialFragment_DIALOG_RESULT_KEY";
    private View backButton;
    private View doneButton;
    private boolean firstLaunch;
    private View nextButton;
    private PageIndicator pageIndicator;
    private Toolbar toolbar;
    private TutorialPagerAdapter tutorialPagerAdapter;
    private ViewPager viewPager;

    public abstract TutorialData[] getData();

    public abstract int getTitle();

    /* JADX INFO: renamed from: isCompleted */
    public abstract boolean getIsCompleted();

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(2, getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new Dialog(requireActivity(), 0);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Window window;
        Window window2;
        Window window3;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.firstLaunch = getIsCompleted();
        View viewInflate = inflater.inflate(C6903R.layout.tutorial_fragment, container, false);
        if (viewInflate == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.videotutorial.IMediaPlayerConfigurer.Provider");
        IMediaPlayerConfigurer mediaPlayerConfigurer = ((IMediaPlayerConfigurer.Provider) application).getMediaPlayerConfigurer();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        this.tutorialPagerAdapter = new TutorialPagerAdapter(childFragmentManager, mediaPlayerConfigurer, getData());
        View viewFindViewById = viewInflate.findViewById(C6903R.id.tutorial_title_appbar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(getTitle() != 0 ? 0 : 8);
        View viewFindViewById2 = viewInflate.findViewById(C6903R.id.tutorial_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.toolbar = (Toolbar) viewFindViewById2;
        final View decorView = null;
        if (getTitle() != 0) {
            Toolbar toolbar = this.toolbar;
            if (toolbar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
                toolbar = null;
            }
            toolbar.setTitle(getTitle());
        } else {
            Toolbar toolbar2 = this.toolbar;
            if (toolbar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
                toolbar2 = null;
            }
            toolbar2.setTitle((CharSequence) null);
        }
        View viewFindViewById3 = viewInflate.findViewById(C6903R.id.tutorial_pager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewPager viewPager = (ViewPager) viewFindViewById3;
        this.viewPager = viewPager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager = null;
        }
        TutorialPagerAdapter tutorialPagerAdapter = this.tutorialPagerAdapter;
        if (tutorialPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tutorialPagerAdapter");
            tutorialPagerAdapter = null;
        }
        viewPager.setAdapter(tutorialPagerAdapter);
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setCurrentItem(savedInstanceState != null ? savedInstanceState.getInt("CURRENT_STEP_KEY", 0) : 0);
        View viewFindViewById4 = viewInflate.findViewById(C6903R.id.tutorial_pager_indicator);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.pageIndicator = (PageIndicator) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(C6903R.id.tutorial_done_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.doneButton = viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(C6903R.id.tutorial_next_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.nextButton = viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(C6903R.id.tutorial_back_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.backButton = viewFindViewById7;
        Dialog dialog = getDialog();
        if (dialog != null && (window3 = dialog.getWindow()) != null) {
            window3.requestFeature(1);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(true);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null && (window = dialog3.getWindow()) != null) {
            if (getResources().getBoolean(C6903R.bool.video_tutorial_fullscreen)) {
                window.setBackgroundDrawable(new ColorDrawable(-1));
                window.setLayout(-1, -1);
                return viewInflate;
            }
            FragmentActivity activity = getActivity();
            if (activity != null && (window2 = activity.getWindow()) != null) {
                decorView = window2.getDecorView();
            }
            if (decorView != null) {
                decorView.post(new Runnable() { // from class: com.myscript.nebo.videotutorial.TutorialFragment$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TutorialFragment.onCreateView$lambda$0(this.f$0, decorView, window);
                    }
                });
            }
        }
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(TutorialFragment tutorialFragment, View view, Window window) {
        if (tutorialFragment.isAdded()) {
            int dimensionPixelSize = tutorialFragment.getResources().getDimensionPixelSize(C6903R.dimen.tutorial_dialog_max_size);
            window.setLayout(RangesKt.coerceAtMost(view.getMeasuredWidth(), dimensionPixelSize), RangesKt.coerceAtMost(view.getMeasuredHeight(), dimensionPixelSize) + tutorialFragment.getResources().getDimensionPixelSize(C6903R.dimen.tutorial_control_bar_size));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ViewPager viewPager = null;
        if (getData().length > 1) {
            PageIndicator pageIndicator = this.pageIndicator;
            if (pageIndicator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageIndicator");
                pageIndicator = null;
            }
            pageIndicator.setPageChangeListener(this);
            PageIndicator pageIndicator2 = this.pageIndicator;
            if (pageIndicator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageIndicator");
                pageIndicator2 = null;
            }
            ViewPager viewPager2 = this.viewPager;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager2 = null;
            }
            pageIndicator2.setViewPager(viewPager2);
            PageIndicator pageIndicator3 = this.pageIndicator;
            if (pageIndicator3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageIndicator");
                pageIndicator3 = null;
            }
            pageIndicator3.setVisibility(0);
        } else {
            PageIndicator pageIndicator4 = this.pageIndicator;
            if (pageIndicator4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageIndicator");
                pageIndicator4 = null;
            }
            pageIndicator4.setVisibility(8);
        }
        View view = this.doneButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doneButton");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.videotutorial.TutorialFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.onDoneButtonClicked();
            }
        });
        View view2 = this.nextButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.videotutorial.TutorialFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.onNextButtonClicked();
            }
        });
        View view3 = this.backButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            view3 = null;
        }
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.videotutorial.TutorialFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                this.f$0.onBackButtonClicked();
            }
        });
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager = viewPager3;
        }
        updateButtonsState(viewPager.getCurrentItem());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private final void updateButtonsState(int position) {
        boolean z = position == 0;
        View view = this.backButton;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            view = null;
        }
        view.setVisibility(!z ? 0 : 8);
        TutorialPagerAdapter tutorialPagerAdapter = this.tutorialPagerAdapter;
        if (tutorialPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tutorialPagerAdapter");
            tutorialPagerAdapter = null;
        }
        boolean z2 = position == tutorialPagerAdapter.getCount() - 1;
        View view3 = this.nextButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
            view3 = null;
        }
        view3.setVisibility(!z2 ? 0 : 8);
        View view4 = this.doneButton;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doneButton");
        } else {
            view2 = view4;
        }
        view2.setVisibility(this.firstLaunch && z2 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDoneButtonClicked() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putBoolean(TUTORIAL_DIALOG_RESULT_KEY, true);
        Unit unit = Unit.INSTANCE;
        parentFragmentManager.setFragmentResult(TUTORIAL_DIALOG_REQUEST_KEY, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1);
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNextButtonClicked() {
        ViewPager viewPager = this.viewPager;
        ViewPager viewPager2 = null;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager = null;
        }
        int currentItem = viewPager.getCurrentItem() + 1;
        TutorialPagerAdapter tutorialPagerAdapter = this.tutorialPagerAdapter;
        if (tutorialPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tutorialPagerAdapter");
            tutorialPagerAdapter = null;
        }
        if (currentItem < tutorialPagerAdapter.getCount()) {
            ViewPager viewPager3 = this.viewPager;
            if (viewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager2 = viewPager3;
            }
            viewPager2.setCurrentItem(currentItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBackButtonClicked() {
        ViewPager viewPager = this.viewPager;
        ViewPager viewPager2 = null;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager = null;
        }
        int currentItem = viewPager.getCurrentItem() - 1;
        if (currentItem >= 0) {
            ViewPager viewPager3 = this.viewPager;
            if (viewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager2 = viewPager3;
            }
            viewPager2.setCurrentItem(currentItem);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        TutorialPagerAdapter tutorialPagerAdapter = this.tutorialPagerAdapter;
        if (tutorialPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tutorialPagerAdapter");
            tutorialPagerAdapter = null;
        }
        tutorialPagerAdapter.getItem(position).restartVideo();
        updateButtonsState(position);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        ViewPager viewPager = this.viewPager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager = null;
        }
        outState.putInt("CURRENT_STEP_KEY", viewPager.getCurrentItem());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnCancelListener(null);
        }
        View view = this.doneButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doneButton");
            view = null;
        }
        view.setOnClickListener(null);
        View view2 = this.nextButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
            view2 = null;
        }
        view2.setOnClickListener(null);
        View view3 = this.backButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            view3 = null;
        }
        view3.setOnClickListener(null);
        PageIndicator pageIndicator = this.pageIndicator;
        if (pageIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageIndicator");
            pageIndicator = null;
        }
        pageIndicator.setViewPager(null);
        PageIndicator pageIndicator2 = this.pageIndicator;
        if (pageIndicator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageIndicator");
            pageIndicator2 = null;
        }
        pageIndicator2.setPageChangeListener(null);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        TutorialPagerAdapter tutorialPagerAdapter = this.tutorialPagerAdapter;
        if (tutorialPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tutorialPagerAdapter");
            tutorialPagerAdapter = null;
        }
        tutorialPagerAdapter.resetMediaPlayerConfigurer$video_tutorial_release();
        super.onDestroy();
    }
}

package com.myscript.nebo.dms.views;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.google.android.material.C4627R;
import com.myscript.android.utils.ViewExt;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.OngoingProgress;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.LibraryViewModel;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: SyncToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0014R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1599d2 = {"Lcom/myscript/nebo/dms/views/SyncToolbar;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "progress", "Landroid/widget/ProgressBar;", "rightButton", "Landroid/widget/TextView;", "text", "subtext", "initialHeight", "detailsUpdateJob", "Lkotlinx/coroutines/Job;", "update", "", "state", "Lcom/myscript/nebo/dms/core/LibraryViewModel$SyncToolbarUIState;", "updateSubtext", "onDetachedFromWindow", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SyncToolbar extends FrameLayout {
    public static final int $stable = 8;
    private Job detailsUpdateJob;
    private final int initialHeight;
    private final ProgressBar progress;
    private final TextView rightButton;
    private final TextView subtext;
    private final TextView text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncToolbar(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C6208R.layout.sync_toolbar, (ViewGroup) this, true);
        View viewFindViewById = viewInflate.findViewById(C6208R.id.view_dms_navigation_sync_progress);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.progress = (ProgressBar) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C6208R.id.view_dms_navigation_right_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.rightButton = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C6208R.id.view_dms_navigation_sync_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.text = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C6208R.id.view_dms_navigation_sync_duration);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.subtext = (TextView) viewFindViewById4;
        this.initialHeight = getResources().getDimensionPixelSize(C6208R.dimen.secondary_toolbar_height);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C6208R.layout.sync_toolbar, (ViewGroup) this, true);
        View viewFindViewById = viewInflate.findViewById(C6208R.id.view_dms_navigation_sync_progress);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.progress = (ProgressBar) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C6208R.id.view_dms_navigation_right_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.rightButton = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C6208R.id.view_dms_navigation_sync_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.text = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C6208R.id.view_dms_navigation_sync_duration);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.subtext = (TextView) viewFindViewById4;
        this.initialHeight = getResources().getDimensionPixelSize(C6208R.dimen.secondary_toolbar_height);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncToolbar(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C6208R.layout.sync_toolbar, (ViewGroup) this, true);
        View viewFindViewById = viewInflate.findViewById(C6208R.id.view_dms_navigation_sync_progress);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.progress = (ProgressBar) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C6208R.id.view_dms_navigation_right_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.rightButton = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C6208R.id.view_dms_navigation_sync_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.text = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C6208R.id.view_dms_navigation_sync_duration);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.subtext = (TextView) viewFindViewById4;
        this.initialHeight = getResources().getDimensionPixelSize(C6208R.dimen.secondary_toolbar_height);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncToolbar(Context context, AttributeSet attrs, int i, int i2) {
        super(context, attrs, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C6208R.layout.sync_toolbar, (ViewGroup) this, true);
        View viewFindViewById = viewInflate.findViewById(C6208R.id.view_dms_navigation_sync_progress);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.progress = (ProgressBar) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C6208R.id.view_dms_navigation_right_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.rightButton = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C6208R.id.view_dms_navigation_sync_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.text = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C6208R.id.view_dms_navigation_sync_duration);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.subtext = (TextView) viewFindViewById4;
        this.initialHeight = getResources().getDimensionPixelSize(C6208R.dimen.secondary_toolbar_height);
    }

    public final void update(final LibraryViewModel.SyncToolbarUIState state) {
        int color;
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.isVisible()) {
            ViewExt.expand$default(this, this.initialHeight, null, 0, 6, null);
        } else if (state.getAnimateVisibilityChange()) {
            ViewExt.collapse(this, new FastOutSlowInInterpolator(), R.integer.config_mediumAnimTime, false);
        } else {
            setVisibility(8);
        }
        int statusResourceId = state.getStatusResourceId();
        Job jobLaunch$default = null;
        if (statusResourceId != 0) {
            this.text.setText(statusResourceId);
        } else {
            this.text.setText((CharSequence) null);
        }
        int numberOfNotebookToSync = state.getNumberOfNotebookToSync();
        int statusPluralsResourceId = state.getStatusPluralsResourceId();
        if (statusPluralsResourceId != 0) {
            this.text.setText(getResources().getQuantityString(statusPluralsResourceId, numberOfNotebookToSync, Integer.valueOf(numberOfNotebookToSync)));
        }
        if (state.isStatusColorRed()) {
            color = ContextCompat.getColor(getContext(), C6183R.color.color_sync_failed);
        } else {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(C4627R.attr.colorOnSurface, typedValue, true);
            color = typedValue.data;
        }
        this.text.setTextColor(color);
        this.text.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.views.SyncToolbar$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncToolbar.update$lambda$0(state, view);
            }
        });
        int buttonTextResourceId = state.getButtonTextResourceId();
        if (buttonTextResourceId != 0) {
            this.rightButton.setText(buttonTextResourceId);
        } else {
            this.rightButton.setText((CharSequence) null);
        }
        this.rightButton.setCompoundDrawablesWithIntrinsicBounds(state.getIconResourceId(), 0, 0, 0);
        this.rightButton.setVisibility(state.getIconResourceId() != 0 || state.getButtonTextResourceId() != 0 ? 0 : 8);
        this.rightButton.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.views.SyncToolbar$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncToolbar.update$lambda$1(state, view);
            }
        });
        ProgressBar progressBar = this.progress;
        OngoingProgress progress = state.getProgress();
        progressBar.setMax(progress != null ? progress.getMax() : 0);
        ProgressBar progressBar2 = this.progress;
        OngoingProgress progress2 = state.getProgress();
        ViewExt.animateProgress(progressBar2, progress2 != null ? progress2.getProgress() : 0);
        this.progress.setVisibility(state.isProgressVisible() ? 0 : 8);
        updateSubtext(state);
        Job job = this.detailsUpdateJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.detailsUpdateJob = null;
        if (state.getStatusDetailsResourceId() == 0 || state.getStatusDetailsText() != null || state.getSyncStartTime() == -1) {
            return;
        }
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this);
        if (lifecycleOwner != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
            jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(lifecycleScope, Dispatchers.getUnconfined(), null, new C63123(state, null), 2, null);
        }
        this.detailsUpdateJob = jobLaunch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void update$lambda$0(LibraryViewModel.SyncToolbarUIState syncToolbarUIState, View view) {
        syncToolbarUIState.getOnTextClick().invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void update$lambda$1(LibraryViewModel.SyncToolbarUIState syncToolbarUIState, View view) {
        syncToolbarUIState.getOnButtonClick().invoke();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.views.SyncToolbar$update$3 */
    /* JADX INFO: compiled from: SyncToolbar.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.views.SyncToolbar$update$3", m1609f = "SyncToolbar.kt", m1610i = {0, 1}, m1611l = {128, TsExtractor.TS_STREAM_TYPE_AC3}, m1612m = "invokeSuspend", m1613n = {"$this$launch", "$this$launch"}, m1614nl = {TsExtractor.TS_STREAM_TYPE_AC3, PDFACompliance.e_PDFA1_3_3}, m1615s = {"L$0", "L$0"}, m1616v = 2)
    static final class C63123 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LibraryViewModel.SyncToolbarUIState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C63123(LibraryViewModel.SyncToolbarUIState syncToolbarUIState, Continuation<? super C63123> continuation) {
            super(2, continuation);
            this.$state = syncToolbarUIState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C63123 c63123 = SyncToolbar.this.new C63123(this.$state, continuation);
            c63123.L$0 = obj;
            return c63123;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C63123) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005b -> B:11:0x0022). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = coroutineScope;
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(SyncToolbar.this, this.$state, null), this) != coroutine_suspended) {
                        if (!CoroutineScopeKt.isActive(coroutineScope)) {
                            Duration.Companion companion = Duration.INSTANCE;
                            this.L$0 = coroutineScope;
                            this.label = 1;
                            if (DelayKt.m16008delayVtjQ1oo(DurationKt.toDuration(1, DurationUnit.MINUTES), this) != coroutine_suspended) {
                                this.L$0 = coroutineScope;
                                this.label = 2;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(SyncToolbar.this, this.$state, null), this) != coroutine_suspended) {
                                }
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    }
                    return coroutine_suspended;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            ResultKt.throwOnFailure(obj);
            if (!CoroutineScopeKt.isActive(coroutineScope)) {
            }
        }

        /* JADX INFO: renamed from: com.myscript.nebo.dms.views.SyncToolbar$update$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: SyncToolbar.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.dms.views.SyncToolbar$update$3$1", m1609f = "SyncToolbar.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ LibraryViewModel.SyncToolbarUIState $state;
            int label;
            final /* synthetic */ SyncToolbar this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SyncToolbar syncToolbar, LibraryViewModel.SyncToolbarUIState syncToolbarUIState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = syncToolbar;
                this.$state = syncToolbarUIState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$state, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.updateSubtext(this.$state);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubtext(LibraryViewModel.SyncToolbarUIState state) {
        String string;
        int statusDetailsResourceId = state.getStatusDetailsResourceId();
        String statusDetailsText = state.getStatusDetailsText();
        if (statusDetailsText == null) {
            boolean z = (statusDetailsResourceId == 0 || state.getSyncStartTime() == -1) ? false : true;
            TextView textView = this.subtext;
            textView.setVisibility(z ? 0 : 8);
            if (z) {
                Duration.Companion companion = Duration.INSTANCE;
                long jCoerceAtLeast = RangesKt.coerceAtLeast(Duration.m15868getInWholeMinutesimpl(DurationKt.toDuration((int) (System.currentTimeMillis() - state.getSyncStartTime()), DurationUnit.MILLISECONDS)), 1L);
                textView.setText(textView.getResources().getString(statusDetailsResourceId, Integer.valueOf((int) jCoerceAtLeast), Long.valueOf(jCoerceAtLeast)));
                return;
            }
            return;
        }
        this.subtext.setVisibility(0);
        TextView textView2 = this.subtext;
        if (statusDetailsResourceId != 0) {
            string = getResources().getString(statusDetailsResourceId, statusDetailsText);
        } else {
            string = statusDetailsText;
        }
        textView2.setText(string);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job job = this.detailsUpdateJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }
}

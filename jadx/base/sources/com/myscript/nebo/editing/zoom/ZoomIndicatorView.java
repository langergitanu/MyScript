package com.myscript.nebo.editing.zoom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.myscript.android.utils.ViewExt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.editing.ZoomState;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ZoomIndicatorView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0003J\b\u0010$\u001a\u00020\u001eH\u0007R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006'"}, m1599d2 = {"Lcom/myscript/nebo/editing/zoom/ZoomIndicatorView;", "Landroid/widget/LinearLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "valueButton", "Landroid/widget/TextView;", "lockButton", "Landroid/view/View;", "separator", "toggleArea", "feedbackView", "dismissFeedbackRunnable", "Ljava/lang/Runnable;", "zoomIndicatorListener", "Lcom/myscript/nebo/editing/zoom/ZoomIndicatorView$ZoomIndicatorListener;", "getZoomIndicatorListener", "()Lcom/myscript/nebo/editing/zoom/ZoomIndicatorView$ZoomIndicatorListener;", "setZoomIndicatorListener", "(Lcom/myscript/nebo/editing/zoom/ZoomIndicatorView$ZoomIndicatorListener;)V", "displayZoom", "", "zoomState", "Lcom/myscript/nebo/editing/ZoomState;", "updateZoomLocked", "locked", "", "notifyZoomLocked", "ZoomIndicatorListener", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ZoomIndicatorView extends LinearLayout {
    private static final String TAG = "ZoomIndicatorView";
    private static final long ZOOM_CONTROL_LOCKED_NOTIFICATION_HIDE_DELAY = 3000;
    private final Runnable dismissFeedbackRunnable;
    private TextView feedbackView;
    private final View lockButton;
    private TechnicalLogger logger;
    private final View separator;
    private final View toggleArea;
    private final TextView valueButton;
    private ZoomIndicatorListener zoomIndicatorListener;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ZoomIndicatorView.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/editing/zoom/ZoomIndicatorView$ZoomIndicatorListener;", "", "onZoomIndicatorClicked", "", "onLockButtonClicked", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface ZoomIndicatorListener {
        void onLockButtonClicked();

        void onZoomIndicatorClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissFeedbackRunnable$lambda$0(ZoomIndicatorView zoomIndicatorView) {
        TransitionManager.beginDelayedTransition(zoomIndicatorView, new AutoTransition());
        TextView textView = zoomIndicatorView.feedbackView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedbackView");
            textView = null;
        }
        textView.setVisibility(8);
    }

    public final ZoomIndicatorListener getZoomIndicatorListener() {
        return this.zoomIndicatorListener;
    }

    public final void setZoomIndicatorListener(ZoomIndicatorListener zoomIndicatorListener) {
        this.zoomIndicatorListener = zoomIndicatorListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomIndicatorView(Context context) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dismissFeedbackRunnable = new Runnable() { // from class: com.myscript.nebo.editing.zoom.ZoomIndicatorView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ZoomIndicatorView.dismissFeedbackRunnable$lambda$0(this.f$0);
            }
        };
        View.inflate(getContext(), C6079R.layout.zoom_panel_view, this);
        Object applicationContext = getContext().getApplicationContext();
        TechnicalLoggerProvider technicalLoggerProvider = applicationContext instanceof TechnicalLoggerProvider ? (TechnicalLoggerProvider) applicationContext : null;
        this.logger = technicalLoggerProvider != null ? technicalLoggerProvider.provideTechnicalLogger() : null;
        View viewFindViewById = findViewById(C6079R.id.zoom_feedback_lock_toggle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.toggleArea = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.zoom.ZoomIndicatorView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZoomIndicatorView._init_$lambda$0(this.f$0, view);
            }
        });
        View viewFindViewById2 = findViewById(C6079R.id.zoom_feedback_value);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        this.valueButton = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.zoom.ZoomIndicatorView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZoomIndicatorView._init_$lambda$1(this.f$0, view);
            }
        });
        View viewFindViewById3 = getRootView().findViewById(C6079R.id.zoom_feedback_divider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.separator = viewFindViewById3;
        View viewFindViewById4 = getRootView().findViewById(C6079R.id.zoom_feedback_lock_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.lockButton = viewFindViewById4;
        View viewFindViewById5 = getRootView().findViewById(C6079R.id.zoom_feedback_lock_notif);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.feedbackView = (TextView) viewFindViewById5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dismissFeedbackRunnable = new Runnable() { // from class: com.myscript.nebo.editing.zoom.ZoomIndicatorView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ZoomIndicatorView.dismissFeedbackRunnable$lambda$0(this.f$0);
            }
        };
        View.inflate(getContext(), C6079R.layout.zoom_panel_view, this);
        Object applicationContext = getContext().getApplicationContext();
        TechnicalLoggerProvider technicalLoggerProvider = applicationContext instanceof TechnicalLoggerProvider ? (TechnicalLoggerProvider) applicationContext : null;
        this.logger = technicalLoggerProvider != null ? technicalLoggerProvider.provideTechnicalLogger() : null;
        View viewFindViewById = findViewById(C6079R.id.zoom_feedback_lock_toggle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.toggleArea = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.zoom.ZoomIndicatorView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZoomIndicatorView._init_$lambda$0(this.f$0, view);
            }
        });
        View viewFindViewById2 = findViewById(C6079R.id.zoom_feedback_value);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        this.valueButton = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.zoom.ZoomIndicatorView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZoomIndicatorView._init_$lambda$1(this.f$0, view);
            }
        });
        View viewFindViewById3 = getRootView().findViewById(C6079R.id.zoom_feedback_divider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.separator = viewFindViewById3;
        View viewFindViewById4 = getRootView().findViewById(C6079R.id.zoom_feedback_lock_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.lockButton = viewFindViewById4;
        View viewFindViewById5 = getRootView().findViewById(C6079R.id.zoom_feedback_lock_notif);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.feedbackView = (TextView) viewFindViewById5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dismissFeedbackRunnable = new Runnable() { // from class: com.myscript.nebo.editing.zoom.ZoomIndicatorView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ZoomIndicatorView.dismissFeedbackRunnable$lambda$0(this.f$0);
            }
        };
        View.inflate(getContext(), C6079R.layout.zoom_panel_view, this);
        Object applicationContext = getContext().getApplicationContext();
        TechnicalLoggerProvider technicalLoggerProvider = applicationContext instanceof TechnicalLoggerProvider ? (TechnicalLoggerProvider) applicationContext : null;
        this.logger = technicalLoggerProvider != null ? technicalLoggerProvider.provideTechnicalLogger() : null;
        View viewFindViewById = findViewById(C6079R.id.zoom_feedback_lock_toggle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.toggleArea = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.zoom.ZoomIndicatorView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZoomIndicatorView._init_$lambda$0(this.f$0, view);
            }
        });
        View viewFindViewById2 = findViewById(C6079R.id.zoom_feedback_value);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        this.valueButton = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.zoom.ZoomIndicatorView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZoomIndicatorView._init_$lambda$1(this.f$0, view);
            }
        });
        View viewFindViewById3 = getRootView().findViewById(C6079R.id.zoom_feedback_divider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.separator = viewFindViewById3;
        View viewFindViewById4 = getRootView().findViewById(C6079R.id.zoom_feedback_lock_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.lockButton = viewFindViewById4;
        View viewFindViewById5 = getRootView().findViewById(C6079R.id.zoom_feedback_lock_notif);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.feedbackView = (TextView) viewFindViewById5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(ZoomIndicatorView zoomIndicatorView, View view) {
        TechnicalLoggerExt.logAction$default(zoomIndicatorView.logger, TAG, "Zoom toggle", null, 4, null);
        ZoomIndicatorListener zoomIndicatorListener = zoomIndicatorView.zoomIndicatorListener;
        if (zoomIndicatorListener != null) {
            zoomIndicatorListener.onLockButtonClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(ZoomIndicatorView zoomIndicatorView, View view) {
        TechnicalLoggerExt.logAction$default(zoomIndicatorView.logger, TAG, "Zoom reset", null, 4, null);
        ZoomIndicatorListener zoomIndicatorListener = zoomIndicatorView.zoomIndicatorListener;
        if (zoomIndicatorListener != null) {
            zoomIndicatorListener.onZoomIndicatorClicked();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.zoom.ZoomIndicatorView$displayZoom$1 */
    /* JADX INFO: compiled from: ZoomIndicatorView.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C64561 extends FunctionReferenceImpl implements Function0<String> {
        C64561(Object obj) {
            super(0, obj, ZoomState.class, "toString", "toString()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return ((ZoomState) this.receiver).toString();
        }
    }

    public final void displayZoom(ZoomState zoomState) {
        Intrinsics.checkNotNullParameter(zoomState, "zoomState");
        if (!zoomState.getReady()) {
            TechnicalLoggerExt.logAction(this.logger, TAG, "Zoom update requested but not ready", new C64561(zoomState));
            return;
        }
        if (!zoomState.getIntermediate()) {
            TechnicalLoggerExt.logAction(this.logger, TAG, "Zoom update", new C64572(zoomState));
        }
        updateZoomLocked(zoomState.getLocked());
        if (zoomState.getNotifyLocked()) {
            notifyZoomLocked();
        }
        this.valueButton.setText(getContext().getString(C6079R.string.current_zoom_format, Integer.valueOf(zoomState.getZoomLevel())));
        if (isShown()) {
            return;
        }
        ViewExt.fadeIn$default(this, 0L, 0L, 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.zoom.ZoomIndicatorView$displayZoom$2 */
    /* JADX INFO: compiled from: ZoomIndicatorView.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C64572 extends FunctionReferenceImpl implements Function0<String> {
        C64572(Object obj) {
            super(0, obj, ZoomState.class, "toString", "toString()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return ((ZoomState) this.receiver).toString();
        }
    }

    private final void updateZoomLocked(boolean locked) {
        this.separator.setVisibility(locked ? 4 : 0);
        this.toggleArea.setSelected(locked);
        this.lockButton.setSelected(locked);
        if (locked) {
            return;
        }
        TextView textView = this.feedbackView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedbackView");
            textView = null;
        }
        textView.setVisibility(8);
    }

    public final void notifyZoomLocked() {
        TextView textView = this.feedbackView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedbackView");
            textView = null;
        }
        if (textView.getVisibility() == 0) {
            return;
        }
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), C6079R.anim.zoom_locked_shake_anim);
        TransitionManager.beginDelayedTransition(this, new AutoTransition());
        TextView textView3 = this.feedbackView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedbackView");
        } else {
            textView2 = textView3;
        }
        textView2.setVisibility(0);
        startAnimation(animationLoadAnimation);
        removeCallbacks(this.dismissFeedbackRunnable);
        postDelayed(this.dismissFeedbackRunnable, 3000L);
    }
}

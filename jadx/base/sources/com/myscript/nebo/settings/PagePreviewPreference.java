package com.myscript.nebo.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.editing.EditingController;
import com.myscript.nebo.editing.PageControllerState;
import com.myscript.nebo.editing.impl.p027ui.ContextualMenuManager;
import com.myscript.snt.core.PageController;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: PagePreviewPreference.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\rJ(\u0010#\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010%\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0013J\u000e\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0013J\u000e\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0016J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020$H\u0016J\b\u00100\u001a\u00020$H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00062"}, m1599d2 = {"Lcom/myscript/nebo/settings/PagePreviewPreference;", "Landroidx/preference/Preference;", "Lkotlinx/coroutines/CoroutineScope;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "neboAssetPath", "", "pageControllerState", "Lcom/myscript/nebo/editing/PageControllerState;", TtmlNode.ATTR_TTS_FONT_SIZE, "", "lineHeight", "colorPolicy", "Lcom/myscript/atk/core/IColorInversionPolicy;", "loadingView", "Landroid/view/View;", "editingCtrl", "Lcom/myscript/nebo/editing/EditingController;", "isDetached", "", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "configure", "", "applyDisplayPreferencesToPreview", "setFontSize", "newFontSize", "setLineHeight", "newLineHeight", "setColorPolicy", "newColorPolicy", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "onDetached", "unbindPageController", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PagePreviewPreference extends Preference implements CoroutineScope {
    public static final String TAG = "PagePreviewPreference";
    private IColorInversionPolicy colorPolicy;
    private final CoroutineContext coroutineContext;
    private EditingController editingCtrl;
    private float fontSize;
    private boolean isDetached;
    private final CompletableJob job;
    private float lineHeight;
    private View loadingView;
    private String neboAssetPath;
    private PageControllerState pageControllerState;
    public static final int $stable = 8;

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagePreviewPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.neboAssetPath = "";
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = completableJobSupervisorJob$default.plus(Dispatchers.getMain());
        configure(context, attrs, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagePreviewPreference(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.neboAssetPath = "";
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = completableJobSupervisorJob$default.plus(Dispatchers.getMain());
        configure(context, attrs, i, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagePreviewPreference(Context context, AttributeSet attrs, int i, int i2) {
        super(context, attrs, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.neboAssetPath = "";
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = completableJobSupervisorJob$default.plus(Dispatchers.getMain());
        configure(context, attrs, i, i2);
    }

    private final void configure(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        setLayoutResource(C6079R.layout.page_preview_preference);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, C6079R.styleable.PagePreviewPreference, defStyleAttr, defStyleRes);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            String string = typedArrayObtainStyledAttributes.getString(C6079R.styleable.PagePreviewPreference_neboAssetPath);
            if (string == null) {
                throw new IllegalArgumentException("app:neboAssetPath is mandatory and should denote a path within APK assets/".toString());
            }
            this.neboAssetPath = string;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final void applyDisplayPreferencesToPreview(float fontSize, float lineHeight) {
        EditingController editingController;
        if (fontSize <= 0.0f || lineHeight <= 0.0f || (editingController = this.editingCtrl) == null) {
            return;
        }
        editingController.setTextDisplaySettings(fontSize, lineHeight);
    }

    public final void setFontSize(float newFontSize) {
        this.fontSize = newFontSize;
        applyDisplayPreferencesToPreview(newFontSize, this.lineHeight);
    }

    public final void setLineHeight(float newLineHeight) {
        this.lineHeight = newLineHeight;
        applyDisplayPreferencesToPreview(this.fontSize, newLineHeight);
    }

    public final void setColorPolicy(IColorInversionPolicy newColorPolicy) {
        PageController pageController;
        Intrinsics.checkNotNullParameter(newColorPolicy, "newColorPolicy");
        this.colorPolicy = newColorPolicy;
        PageControllerState pageControllerState = this.pageControllerState;
        if (pageControllerState == null || (pageController = pageControllerState.getPageController()) == null) {
            return;
        }
        pageController.setColorInversionPolicy(this.colorPolicy);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(final PreferenceViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        holder.itemView.setClickable(false);
        this.loadingView = holder.itemView.findViewById(C6079R.id.page_preview_loading);
        final View viewFindViewById = holder.itemView.findViewById(C6079R.id.page_preview_ink_test_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final View viewFindViewById2 = holder.itemView.findViewById(C6079R.id.page_preview_ink_test_here_label);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final ViewGroup viewGroup = (ViewGroup) holder.itemView.findViewById(C6079R.id.page_preview);
        if (viewGroup == null) {
            return;
        }
        this.editingCtrl = new EditingController(viewGroup, new ContextualMenuManager());
        View view = this.loadingView;
        if (view != null) {
            view.setVisibility(0);
        }
        viewGroup.setVisibility(4);
        ViewGroup viewGroup2 = viewGroup;
        if (viewGroup2.isLaidOut() && !viewGroup2.isLayoutRequested()) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new PagePreviewPreference$onBindViewHolder$1$1(this, holder, viewGroup, viewFindViewById, viewFindViewById2, null), 3, null);
        } else {
            viewGroup2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.myscript.nebo.settings.PagePreviewPreference$onBindViewHolder$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view2.removeOnLayoutChangeListener(this);
                    BuildersKt__Builders_commonKt.launch$default(this.this$0, null, null, new PagePreviewPreference$onBindViewHolder$1$1(this.this$0, holder, viewGroup, viewFindViewById, viewFindViewById2, null), 3, null);
                }
            });
        }
    }

    @Override // androidx.preference.Preference
    public void onDetached() {
        super.onDetached();
        setOnPreferenceClickListener(null);
        this.isDetached = true;
        unbindPageController();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unbindPageController() {
        PageControllerState pageControllerState = this.pageControllerState;
        if (pageControllerState != null) {
            pageControllerState.unbind();
        }
        this.pageControllerState = null;
        EditingController editingController = this.editingCtrl;
        if (editingController != null) {
            editingController.release();
        }
        this.editingCtrl = null;
    }
}

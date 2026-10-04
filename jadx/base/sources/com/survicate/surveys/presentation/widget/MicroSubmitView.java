package com.survicate.surveys.presentation.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.colors.MicroColorControlOpacity;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.theming.ColorHelper;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.presentation.theming.MicroButtonDrawableFactory;
import com.survicate.surveys.presentation.widget.SubmitViewState;
import com.survicate.surveys.utils.ScreenUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSubmitView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\fH\u0002J\u0016\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"J\u0018\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(H\u0002R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/MicroSubmitView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onSubmitClick", "Lkotlin/Function0;", "", "getOnSubmitClick", "()Lkotlin/jvm/functions/Function0;", "setOnSubmitClick", "(Lkotlin/jvm/functions/Function0;)V", "onBackClick", "getOnBackClick", "setOnBackClick", "divider", "Landroid/view/View;", "backButton", "Lcom/survicate/surveys/presentation/widget/MicroNavigationButtonBack;", "submitButton", "Landroid/widget/Button;", "setupListeners", "inject", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "setState", "state", "Lcom/survicate/surveys/presentation/widget/SubmitViewState;", "adjustButtonWidth", "button", "adjustSubmitButtonPadding", "getTabletButtonWidth", "hasNavigationButtons", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSubmitView extends FrameLayout {
    private final MicroNavigationButtonBack backButton;
    private final View divider;
    private Function0<Unit> onBackClick;
    private Function0<Unit> onSubmitClick;
    private final Button submitButton;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSubmitView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSubmitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSubmitView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSubmitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_submit, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_submit_divider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.divider = viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_submit_button_back);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.backButton = (MicroNavigationButtonBack) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_micro_submit_button_submit);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.submitButton = (Button) viewFindViewById3;
        setupListeners();
    }

    public final Function0<Unit> getOnSubmitClick() {
        return this.onSubmitClick;
    }

    public final void setOnSubmitClick(Function0<Unit> function0) {
        this.onSubmitClick = function0;
    }

    public final Function0<Unit> getOnBackClick() {
        return this.onBackClick;
    }

    public final void setOnBackClick(Function0<Unit> function0) {
        this.onBackClick = function0;
    }

    private final void setupListeners() {
        this.backButton.setOnClickListener(new View.OnClickListener() { // from class: com.survicate.surveys.presentation.widget.MicroSubmitView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MicroSubmitView.setupListeners$lambda$0(this.f$0, view);
            }
        });
        this.submitButton.setOnClickListener(new View.OnClickListener() { // from class: com.survicate.surveys.presentation.widget.MicroSubmitView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MicroSubmitView.setupListeners$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0(MicroSubmitView microSubmitView, View view) {
        Function0<Unit> function0 = microSubmitView.onBackClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$1(MicroSubmitView microSubmitView, View view) {
        Function0<Unit> function0 = microSubmitView.onSubmitClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.divider.setBackgroundColor(ColorHelper.getArgbValue(colorScheme.getQuestion(), MicroColorControlOpacity.Divider.getOpacityValue()));
        this.backButton.inject(viewDependencies, colorScheme);
        this.submitButton.setTextColor(MicroButtonDrawableFactory.INSTANCE.createButtonTextColorStateList(colorScheme));
        Button button = this.submitButton;
        MicroButtonDrawableFactory microButtonDrawableFactory = MicroButtonDrawableFactory.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        button.setBackground(microButtonDrawableFactory.createFilledButtonBackground(context, colorScheme));
        Button button2 = this.submitButton;
        FontProvider fontProvider = viewDependencies.getFontProvider();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        button2.setTypeface(fontProvider.provideFont(context2, FontType.BOLD));
    }

    public final void setState(SubmitViewState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!Intrinsics.areEqual(state, SubmitViewState.Hidden.INSTANCE)) {
            if (!(state instanceof SubmitViewState.Submit)) {
                if (!(state instanceof SubmitViewState.Navigation)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.divider.setVisibility(0);
                this.backButton.setVisibility(0);
                SubmitViewState.Navigation navigation = (SubmitViewState.Navigation) state;
                this.backButton.setEnabled(navigation.getBackEnabled());
                this.backButton.setText(navigation.getBackText());
                this.submitButton.setVisibility(0);
                this.submitButton.setEnabled(navigation.getSubmitEnabled());
                this.submitButton.setText(navigation.getSubmitText());
            } else {
                this.divider.setVisibility(0);
                this.backButton.setVisibility(8);
                this.submitButton.setVisibility(0);
                SubmitViewState.Submit submit = (SubmitViewState.Submit) state;
                this.submitButton.setEnabled(submit.getSubmitEnabled());
                this.submitButton.setText(submit.getSubmitText());
            }
        } else {
            this.divider.setVisibility(8);
            this.backButton.setVisibility(8);
            this.submitButton.setVisibility(8);
        }
        adjustButtonWidth(this.backButton, state);
        adjustButtonWidth(this.submitButton, state);
        adjustSubmitButtonPadding(state);
    }

    private final void adjustButtonWidth(View button, SubmitViewState state) {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        int tabletButtonWidth = (!ScreenUtils.isWideScreen(resources) || state.getForceCenter()) ? 0 : getTabletButtonWidth(state instanceof SubmitViewState.Navigation);
        float f = tabletButtonWidth == 0 ? 1.0f : 0.0f;
        ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        LinearLayout.LayoutParams layoutParams3 = layoutParams2;
        layoutParams3.width = tabletButtonWidth;
        layoutParams3.weight = f;
        button.setLayoutParams(layoutParams2);
    }

    private final void adjustSubmitButtonPadding(SubmitViewState state) {
        int dimensionPixelSize;
        if (state instanceof SubmitViewState.Navigation) {
            dimensionPixelSize = getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_button_navigation_horizontal_padding);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_button_horizontal_padding);
        }
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_button_vertical_padding);
        this.submitButton.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
    }

    private final int getTabletButtonWidth(boolean hasNavigationButtons) {
        if (hasNavigationButtons) {
            return getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_button_navigation_tablet_width);
        }
        return -2;
    }
}

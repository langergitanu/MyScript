package com.survicate.surveys.presentation.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.attributes.MicroSurvicateSelectionType;
import com.survicate.surveys.entities.colors.MicroColorControlOpacity;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.theming.ColorHelper;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.presentation.theming.MicroDrawableFactory;
import com.survicate.surveys.presentation.theming.MicroSelectionDrawableFactory;
import com.survicate.surveys.utils.HtmlTextUtil;
import com.survicate.surveys.utils.extensions.TextViewExtensionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MicroDisclaimerView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 62\u00020\u0001:\u000267B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010%\u001a\u00020\u000fH\u0002J\u0016\u0010&\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-J\n\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0012\u00100\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0006\u00101\u001a\u00020-J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u000205H\u0002R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000¨\u00068"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/MicroDisclaimerView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrsSet", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isDisclaimerAccepted", "", "()Z", "onCheckboxToggle", "Lkotlin/Function0;", "", "getOnCheckboxToggle", "()Lkotlin/jvm/functions/Function0;", "setOnCheckboxToggle", "(Lkotlin/jvm/functions/Function0;)V", "isChecked", "checkboxSection", "Landroid/view/View;", "checkboxTouchArea", "checkbox", "Landroid/widget/CheckBox;", "checkboxLabel", "Landroid/widget/TextView;", "dividerTop", "dividerMiddle", "textSection", "titleTextView", "titleSpace", "Landroid/widget/Space;", "descriptionTextView", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "setupView", "inject", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "bindData", "data", "Lcom/survicate/surveys/presentation/widget/MicroDisclaimerView$BindingData;", "savedState", "Landroid/os/Bundle;", "getRegularFontConfig", "Lcom/survicate/surveys/utils/HtmlTextUtil$FontConfig;", "restoreCheckboxState", "getCurrentUiState", "provideFont", "Landroid/graphics/Typeface;", "fontType", "Lcom/survicate/surveys/presentation/theming/FontType;", "Companion", "BindingData", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroDisclaimerView extends FrameLayout {
    public static final String IS_CHECKBOX_CHECKED = "IS_DISCLAIMER_CHECKBOX_CHECKED";
    private final CheckBox checkbox;
    private final TextView checkboxLabel;
    private final View checkboxSection;
    private final View checkboxTouchArea;
    private final TextView descriptionTextView;
    private final View dividerMiddle;
    private final View dividerTop;
    private Function0<Unit> onCheckboxToggle;
    private final View textSection;
    private final Space titleSpace;
    private final TextView titleTextView;
    private ViewDependencies viewDependencies;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroDisclaimerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroDisclaimerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroDisclaimerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroDisclaimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_disclaimer, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_disclaimer_checkbox_section);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.checkboxSection = viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_disclaimer_checkbox_touch_area);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.checkboxTouchArea = viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_micro_disclaimer_checkbox);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.checkbox = (CheckBox) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C8369R.id.view_micro_disclaimer_checkbox_label);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.checkboxLabel = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(C8369R.id.view_micro_disclaimer_divider_top);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.dividerTop = viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(C8369R.id.view_micro_disclaimer_divider_middle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.dividerMiddle = viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(C8369R.id.view_micro_disclaimer_text_section);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.textSection = viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(C8369R.id.view_micro_disclaimer_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.titleTextView = (TextView) viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(C8369R.id.view_micro_disclaimer_title_space);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.titleSpace = (Space) viewFindViewById9;
        View viewFindViewById10 = viewInflate.findViewById(C8369R.id.view_micro_disclaimer_description);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.descriptionTextView = (TextView) viewFindViewById10;
        setupView();
    }

    public final boolean isDisclaimerAccepted() {
        return this.checkbox.isChecked();
    }

    public final Function0<Unit> getOnCheckboxToggle() {
        return this.onCheckboxToggle;
    }

    public final void setOnCheckboxToggle(Function0<Unit> function0) {
        this.onCheckboxToggle = function0;
    }

    public final boolean isChecked() {
        return this.checkbox.isChecked();
    }

    private final void setupView() {
        this.checkbox.setSaveEnabled(false);
        View view = this.checkboxTouchArea;
        MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        view.setBackground(MicroDrawableFactory.createFocusBorderBackground$default(microDrawableFactory, context, 0.0f, 2, null));
        this.checkboxTouchArea.setOnClickListener(new View.OnClickListener() { // from class: com.survicate.surveys.presentation.widget.MicroDisclaimerView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MicroDisclaimerView.setupView$lambda$0(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupView$lambda$0(MicroDisclaimerView microDisclaimerView, View view) {
        microDisclaimerView.checkbox.setChecked(!r2.isChecked());
        Function0<Unit> function0 = microDisclaimerView.onCheckboxToggle;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        int argbValue = ColorHelper.getArgbValue(colorScheme.getQuestion(), MicroColorControlOpacity.Divider.getOpacityValue());
        this.dividerTop.setBackgroundColor(argbValue);
        this.dividerMiddle.setBackgroundColor(argbValue);
        this.titleTextView.setTypeface(provideFont(FontType.BOLD));
        this.titleTextView.setTextColor(colorScheme.getAnswer());
        this.descriptionTextView.setTypeface(provideFont(FontType.REGULAR));
        TextViewExtensionsKt.setHtmlTextColor(this.descriptionTextView, colorScheme.getAnswer());
        TextView textView = this.descriptionTextView;
        MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setBackground(MicroDrawableFactory.createFocusBorderBackground$default(microDrawableFactory, context, 0.0f, 2, null));
        this.checkboxLabel.setTypeface(provideFont(FontType.REGULAR));
        this.checkboxLabel.setTextColor(colorScheme.getAnswer());
        this.checkbox.setBackground(MicroSelectionDrawableFactory.INSTANCE.createRipple(colorScheme));
        CheckBox checkBox = this.checkbox;
        MicroSelectionDrawableFactory microSelectionDrawableFactory = MicroSelectionDrawableFactory.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        checkBox.setButtonDrawable(microSelectionDrawableFactory.createDrawable(context2, colorScheme, MicroSurvicateSelectionType.Checkbox));
    }

    public final void bindData(BindingData data, Bundle savedState) {
        Intrinsics.checkNotNullParameter(data, "data");
        boolean zIsBlank = StringsKt.isBlank(data.getCheckboxLabel());
        this.checkboxSection.setVisibility(!zIsBlank ? 0 : 8);
        this.checkboxLabel.setText(data.getCheckboxLabel());
        restoreCheckboxState(savedState);
        boolean z = (StringsKt.isBlank(data.getTitle()) && StringsKt.isBlank(data.getDescription())) ? false : true;
        this.textSection.setVisibility(z ? 0 : 8);
        this.titleTextView.setText(data.getTitle());
        this.titleTextView.setVisibility(!StringsKt.isBlank(data.getTitle()) ? 0 : 8);
        this.titleSpace.setVisibility(!StringsKt.isBlank(data.getTitle()) && !StringsKt.isBlank(data.getDescription()) ? 0 : 8);
        TextViewExtensionsKt.setHtmlTextOrHide(this.descriptionTextView, data.getDescription(), getRegularFontConfig());
        this.dividerMiddle.setVisibility(z && !zIsBlank ? 0 : 8);
    }

    private final HtmlTextUtil.FontConfig getRegularFontConfig() {
        Typeface typefaceProvideFont;
        Typeface typefaceProvideFont2;
        Typeface typefaceProvideFont3 = provideFont(FontType.BOLD);
        if (typefaceProvideFont3 == null || (typefaceProvideFont = provideFont(FontType.REGULAR_ITALIC)) == null || (typefaceProvideFont2 = provideFont(FontType.BOLD_ITALIC)) == null) {
            return null;
        }
        return new HtmlTextUtil.FontConfig(typefaceProvideFont3, typefaceProvideFont, typefaceProvideFont2);
    }

    private final void restoreCheckboxState(Bundle savedState) {
        this.checkbox.setChecked(savedState != null ? savedState.getBoolean(IS_CHECKBOX_CHECKED) : false);
    }

    public final Bundle getCurrentUiState() {
        return BundleKt.bundleOf(TuplesKt.m1606to(IS_CHECKBOX_CHECKED, Boolean.valueOf(this.checkbox.isChecked())));
    }

    private final Typeface provideFont(FontType fontType) {
        ViewDependencies viewDependencies = this.viewDependencies;
        if (viewDependencies == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
            viewDependencies = null;
        }
        FontProvider fontProvider = viewDependencies.getFontProvider();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return fontProvider.provideFont(context, fontType);
    }

    /* JADX INFO: compiled from: MicroDisclaimerView.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0013\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/MicroDisclaimerView$BindingData;", "", "title", "", "description", "checkboxLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "disclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "(Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;)V", "getTitle", "()Ljava/lang/String;", "getDescription", "getCheckboxLabel", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class BindingData {
        private final String checkboxLabel;
        private final String description;
        private final String title;

        public static /* synthetic */ BindingData copy$default(BindingData bindingData, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bindingData.title;
            }
            if ((i & 2) != 0) {
                str2 = bindingData.description;
            }
            if ((i & 4) != 0) {
                str3 = bindingData.checkboxLabel;
            }
            return bindingData.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCheckboxLabel() {
            return this.checkboxLabel;
        }

        public final BindingData copy(String title, String description, String checkboxLabel) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(checkboxLabel, "checkboxLabel");
            return new BindingData(title, description, checkboxLabel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BindingData)) {
                return false;
            }
            BindingData bindingData = (BindingData) other;
            return Intrinsics.areEqual(this.title, bindingData.title) && Intrinsics.areEqual(this.description, bindingData.description) && Intrinsics.areEqual(this.checkboxLabel, bindingData.checkboxLabel);
        }

        public int hashCode() {
            return (((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + this.checkboxLabel.hashCode();
        }

        public String toString() {
            return "BindingData(title=" + this.title + ", description=" + this.description + ", checkboxLabel=" + this.checkboxLabel + ')';
        }

        public BindingData(String title, String description, String checkboxLabel) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(checkboxLabel, "checkboxLabel");
            this.title = title;
            this.description = description;
            this.checkboxLabel = checkboxLabel;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getCheckboxLabel() {
            return this.checkboxLabel;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public BindingData(DisclaimerSettings disclaimerSettings) {
            String title = disclaimerSettings != null ? disclaimerSettings.getTitle() : null;
            title = title == null ? "" : title;
            String description = disclaimerSettings != null ? disclaimerSettings.getDescription() : null;
            description = description == null ? "" : description;
            String checkboxLabel = disclaimerSettings != null ? disclaimerSettings.getCheckboxLabel() : null;
            this(title, description, checkboxLabel != null ? checkboxLabel : "");
        }
    }
}

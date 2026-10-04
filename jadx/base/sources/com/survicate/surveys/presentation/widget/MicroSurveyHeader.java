package com.survicate.surveys.presentation.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.colors.MicroColorControlOpacity;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.entities.survey.theme.ThemeSettings;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.base.DebouncingOnClickListener;
import com.survicate.surveys.presentation.theming.ColorHelper;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.presentation.theming.MicroButtonDrawableFactory;
import com.survicate.surveys.utils.AccessibilityUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MicroSurveyHeader.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010 \u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010#J\u000e\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0010\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020,H\u0002J\u0016\u0010-\u001a\u00020\r*\u00020\u00152\b\b\u0002\u0010.\u001a\u00020,H\u0002R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000¨\u0006/"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/MicroSurveyHeader;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onLanguageSelected", "Lkotlin/Function1;", "", "", "getOnLanguageSelected", "()Lkotlin/jvm/functions/Function1;", "setOnLanguageSelected", "(Lkotlin/jvm/functions/Function1;)V", "containerView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "imageView", "Landroid/widget/ImageView;", "shortMessageTextView", "Landroid/widget/TextView;", "closeButton", "languageButton", "progressBar", "Lcom/survicate/surveys/presentation/widget/MicroProgressBar;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "inject", "setOnCloseButtonListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/survicate/surveys/presentation/base/DebouncingOnClickListener;", "bindData", "data", "Lcom/survicate/surveys/presentation/widget/SurveyHeaderBindingData;", "bindLanguageSelector", "updateImageWidth", "width", "updateProgressConstraints", "isBrandingOrPersonalizationSet", "", "applyColorSchemeTint", "highlight", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyHeader extends FrameLayout {
    private final ImageView closeButton;
    private ColorScheme colorScheme;
    private final ConstraintLayout containerView;
    private final ImageView imageView;
    private final ImageView languageButton;
    private Function1<? super String, Unit> onLanguageSelected;
    private final MicroProgressBar progressBar;
    private final TextView shortMessageTextView;
    private ViewDependencies viewDependencies;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyHeader(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSurveyHeader(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurveyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_survicate_micro_card_header, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_survicate_micro_header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.containerView = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_survicate_micro_card_header_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.imageView = (ImageView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_survicate_micro_card_header_short_message);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.shortMessageTextView = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C8369R.id.view_survicate_micro_card_header_close_btn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.closeButton = (ImageView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(C8369R.id.view_survicate_micro_card_header_language_btn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.languageButton = (ImageView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(C8369R.id.view_survicate_micro_card_header_progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.progressBar = (MicroProgressBar) viewFindViewById6;
    }

    public final Function1<String, Unit> getOnLanguageSelected() {
        return this.onLanguageSelected;
    }

    public final void setOnLanguageSelected(Function1<? super String, Unit> function1) {
        this.onLanguageSelected = function1;
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        this.colorScheme = colorScheme;
        this.progressBar.inject(colorScheme);
        TextView textView = this.shortMessageTextView;
        FontProvider fontProvider = viewDependencies.getFontProvider();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setTypeface(fontProvider.provideFont(context, FontType.REGULAR));
        this.shortMessageTextView.setTextColor(colorScheme.getQuestion());
        applyColorSchemeTint$default(this, this.closeButton, false, 1, null);
        ImageView imageView = this.closeButton;
        MicroButtonDrawableFactory microButtonDrawableFactory = MicroButtonDrawableFactory.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        imageView.setBackground(microButtonDrawableFactory.createIconButtonBackground(context2));
        applyColorSchemeTint$default(this, this.languageButton, false, 1, null);
        ImageView imageView2 = this.languageButton;
        MicroButtonDrawableFactory microButtonDrawableFactory2 = MicroButtonDrawableFactory.INSTANCE;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        imageView2.setBackground(microButtonDrawableFactory2.createIconButtonBackground(context3));
    }

    public final void setOnCloseButtonListener(DebouncingOnClickListener listener) {
        this.closeButton.setOnClickListener(listener);
    }

    public final void bindData(SurveyHeaderBindingData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ViewCompat.setAccessibilityDelegate(this.languageButton, new AccessibilityUtils.ButtonRoleAccessibilityDelegate());
        ViewCompat.setAccessibilityDelegate(this.closeButton, new AccessibilityUtils.ButtonRoleAccessibilityDelegate());
        ThemeSettings themeSettings = data.getThemeSettings();
        boolean zAreEqual = Intrinsics.areEqual((Object) themeSettings.getPersonalization(), (Object) true);
        String avatarImage = themeSettings.getAvatarImage();
        boolean z = avatarImage != null && (StringsKt.isBlank(avatarImage) ^ true);
        String shortTextMessage = themeSettings.getShortTextMessage();
        boolean z2 = shortTextMessage != null && (StringsKt.isBlank(shortTextMessage) ^ true);
        String companyLogo = themeSettings.getCompanyLogo();
        boolean z3 = companyLogo != null && (StringsKt.isBlank(companyLogo) ^ true);
        if (zAreEqual && z3) {
            updateImageWidth(-2);
            String companyLogo2 = themeSettings.getCompanyLogo();
            data.getImageLoader().loadCompanyLogo(null, this.imageView, companyLogo2);
            String str = companyLogo2;
            this.imageView.setVisibility(!(str == null || StringsKt.isBlank(str)) ? 0 : 8);
            this.shortMessageTextView.setText("");
            updateProgressConstraints(true);
        } else if (zAreEqual && (z || z2)) {
            updateImageWidth((int) getResources().getDimension(C8369R.dimen.survicate_micro_card_header_avatar_width));
            String avatarImage2 = themeSettings.getAvatarImage();
            data.getImageLoader().loadAvatar(null, this.imageView, avatarImage2);
            String str2 = avatarImage2;
            this.imageView.setVisibility(!(str2 == null || StringsKt.isBlank(str2)) ? 0 : 8);
            TextView textView = this.shortMessageTextView;
            String shortTextMessage2 = themeSettings.getShortTextMessage();
            textView.setText(shortTextMessage2 != null ? shortTextMessage2 : "");
            updateProgressConstraints(true);
        } else {
            this.imageView.setVisibility(8);
            this.shortMessageTextView.setText("");
            updateProgressConstraints(false);
        }
        this.progressBar.setVisibility(data.getShowProgressBar() ? 0 : 8);
        this.progressBar.setProgressValue(data.getSurveyProgressInPercents());
        bindLanguageSelector(data);
    }

    private final void bindLanguageSelector(final SurveyHeaderBindingData data) {
        this.languageButton.setVisibility(data.getHasLanguageSelector() ? 0 : 8);
        this.languageButton.setOnClickListener(new View.OnClickListener() { // from class: com.survicate.surveys.presentation.widget.MicroSurveyHeader$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MicroSurveyHeader.bindLanguageSelector$lambda$2(this.f$0, data, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindLanguageSelector$lambda$2(final MicroSurveyHeader microSurveyHeader, SurveyHeaderBindingData surveyHeaderBindingData, View view) {
        Context context = microSurveyHeader.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ColorScheme colorScheme = microSurveyHeader.colorScheme;
        ViewDependencies viewDependencies = null;
        if (colorScheme == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme = null;
        }
        ViewDependencies viewDependencies2 = microSurveyHeader.viewDependencies;
        if (viewDependencies2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
        } else {
            viewDependencies = viewDependencies2;
        }
        LanguageSelectorPopup languageSelectorPopup = new LanguageSelectorPopup(context, colorScheme, viewDependencies);
        languageSelectorPopup.show(microSurveyHeader.languageButton, surveyHeaderBindingData.getLanguageCodes(), surveyHeaderBindingData.getSelectedLanguageCode(), new Function1() { // from class: com.survicate.surveys.presentation.widget.MicroSurveyHeader$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MicroSurveyHeader.bindLanguageSelector$lambda$2$lambda$0(this.f$0, (String) obj);
            }
        });
        microSurveyHeader.applyColorSchemeTint(microSurveyHeader.languageButton, true);
        languageSelectorPopup.setOnDismiss(new Function0() { // from class: com.survicate.surveys.presentation.widget.MicroSurveyHeader$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyHeader.bindLanguageSelector$lambda$2$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindLanguageSelector$lambda$2$lambda$0(MicroSurveyHeader microSurveyHeader, String langCode) {
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        Function1<? super String, Unit> function1 = microSurveyHeader.onLanguageSelected;
        if (function1 != null) {
            function1.invoke(langCode);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindLanguageSelector$lambda$2$lambda$1(MicroSurveyHeader microSurveyHeader) {
        microSurveyHeader.applyColorSchemeTint(microSurveyHeader.languageButton, false);
        return Unit.INSTANCE;
    }

    private final void updateImageWidth(int width) {
        ViewGroup.LayoutParams layoutParams = this.imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.width = width;
        this.imageView.setLayoutParams(layoutParams);
    }

    private final void updateProgressConstraints(boolean isBrandingOrPersonalizationSet) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.containerView);
        if (isBrandingOrPersonalizationSet) {
            int i = C8369R.id.view_survicate_micro_header_barrier;
            constraintSet.clear(this.progressBar.getId(), 4);
            constraintSet.connect(this.progressBar.getId(), 6, this.containerView.getId(), 6);
            constraintSet.connect(this.progressBar.getId(), 3, i, 4, getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_survey_progress_margin_top));
            constraintSet.connect(this.progressBar.getId(), 7, this.containerView.getId(), 7, getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_space_xl));
        } else {
            constraintSet.clear(this.progressBar.getId(), 3);
            constraintSet.connect(this.progressBar.getId(), 6, this.containerView.getId(), 6);
            constraintSet.connect(this.progressBar.getId(), 4, this.closeButton.getId(), 4, getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_survey_progress_margin_bottom_no_branding));
            constraintSet.connect(this.progressBar.getId(), 7, this.languageButton.getId(), 6, getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_space_md));
        }
        constraintSet.applyTo(this.containerView);
    }

    static /* synthetic */ void applyColorSchemeTint$default(MicroSurveyHeader microSurveyHeader, ImageView imageView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        microSurveyHeader.applyColorSchemeTint(imageView, z);
    }

    private final void applyColorSchemeTint(ImageView imageView, boolean z) {
        int argbValue;
        ColorScheme colorScheme = null;
        if (z) {
            ColorScheme colorScheme2 = this.colorScheme;
            if (colorScheme2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            } else {
                colorScheme = colorScheme2;
            }
            argbValue = colorScheme.getQuestion();
        } else {
            ColorScheme colorScheme3 = this.colorScheme;
            if (colorScheme3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            } else {
                colorScheme = colorScheme3;
            }
            argbValue = ColorHelper.getArgbValue(colorScheme.getQuestion(), MicroColorControlOpacity.IconButton.getOpacityValue());
        }
        imageView.setColorFilter(argbValue, PorterDuff.Mode.SRC_IN);
    }
}

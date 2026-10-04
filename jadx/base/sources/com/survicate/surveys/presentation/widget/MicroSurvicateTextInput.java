package com.survicate.surveys.presentation.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.fasterxml.jackson.core.JsonPointer;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.attributes.MicroSurvicateTextInputStyle;
import com.survicate.surveys.entities.colors.MicroColorControlOpacity;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.entities.views.InitialValidationView;
import com.survicate.surveys.entities.views.InputValidationResult;
import com.survicate.surveys.entities.views.InputValidationView;
import com.survicate.surveys.entities.views.InputValidator;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.theming.ColorHelper;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.presentation.theming.MicroDrawableFactory;
import com.survicate.surveys.utils.AccessibilityUtils;
import com.survicate.surveys.utils.AfterTextChangedWatcher;
import com.survicate.surveys.utils.extensions.TextViewExtensionsKt;
import com.survicate.surveys.utils.extensions.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MicroSurvicateTextInput.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010#\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&J\u0016\u0010'\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\nJ\u0006\u0010*\u001a\u00020\u001dJ\u0012\u0010+\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010-\u001a\u00020\u001d2\b\u0010.\u001a\u0004\u0018\u00010\u0003J\u000e\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0003J\u000e\u00101\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0003J.\u00102\u001a\u00020\u001d2\b\u00103\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\"\u001a\u00020\n2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001cJ\u0010\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\nH\u0002J\u0010\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\nH\u0002J\u0006\u00109\u001a\u00020\u001dJ\u001c\u0010:\u001a\u00020\u001d2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u001cH\u0016J\b\u0010;\u001a\u00020\u001fH\u0016J\u0016\u0010<\u001a\u00020\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030!H\u0016J\b\u0010=\u001a\u00020\u001fH\u0016J\u0010\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u0003H\u0002J\b\u0010@\u001a\u00020\u001dH\u0002J\u000e\u0010A\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020\u001fJ\u0006\u0010C\u001a\u00020\u001dJ\u0012\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020GH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/MicroSurvicateTextInput;", "Landroid/widget/FrameLayout;", "Lcom/survicate/surveys/entities/views/InitialValidationView;", "", "Lcom/survicate/surveys/entities/views/InputValidationView;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrsSet", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "inputLabelTextView", "Landroid/widget/TextView;", "errorPopup", "Landroid/view/View;", "errorTextView", "inputTextView", "Landroid/widget/EditText;", "charLimitTextView", "textWatcher", "Landroid/text/TextWatcher;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "afterTextChanged", "Lkotlin/Function1;", "", "initialValidator", "", "validator", "Lcom/survicate/surveys/entities/views/InputValidator;", "characterLimit", "setupView", "setInputStyle", "inputStyle", "Lcom/survicate/surveys/entities/attributes/MicroSurvicateTextInputStyle;", "inject", "setInputType", "inputType", "setImeActionDone", "setAutofillHint", "hint", "setInputLabel", "label", "setLabelContentDescription", "description", "setInputHint", "bindTextInput", "initialText", "onAfterTextChanged", "setCharacterLimit", "limit", "updateCharacterCount", "length", "clearInputFocus", "bindInitialValidator", "isInitiallyValid", "bindValidator", "validate", "setError", "error", "clearError", "setAutoSaveEnabled", "enabled", "scrollTo", "provideFont", "Landroid/graphics/Typeface;", "fontType", "Lcom/survicate/surveys/presentation/theming/FontType;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurvicateTextInput extends FrameLayout implements InitialValidationView<String>, InputValidationView<String> {
    private Function1<? super String, Unit> afterTextChanged;
    private final TextView charLimitTextView;
    private int characterLimit;
    private ColorScheme colorScheme;
    private final View errorPopup;
    private final TextView errorTextView;
    private Function1<? super String, Boolean> initialValidator;
    private final TextView inputLabelTextView;
    private final EditText inputTextView;
    private final TextWatcher textWatcher;
    private InputValidator<String> validator;
    private ViewDependencies viewDependencies;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurvicateTextInput(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurvicateTextInput(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialValidator$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    public /* synthetic */ MicroSurvicateTextInput(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurvicateTextInput(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.initialValidator = new Function1() { // from class: com.survicate.surveys.presentation.widget.MicroSurvicateTextInput$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MicroSurvicateTextInput.initialValidator$lambda$0((String) obj));
            }
        };
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_survicate_text_input, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_survicate_text_input_label);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.inputLabelTextView = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_survicate_text_input_error_popup);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.errorPopup = viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_micro_survicate_text_input_error);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.errorTextView = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(C8369R.id.view_micro_survicate_text_input);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.inputTextView = (EditText) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(C8369R.id.view_micro_survicate_text_input_char_limit);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.charLimitTextView = (TextView) viewFindViewById5;
        this.textWatcher = new AfterTextChangedWatcher(new Function1() { // from class: com.survicate.surveys.presentation.widget.MicroSurvicateTextInput$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MicroSurvicateTextInput._init_$lambda$1(this.f$0, (String) obj);
            }
        });
        setupView(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(MicroSurvicateTextInput microSurvicateTextInput, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        microSurvicateTextInput.clearError();
        microSurvicateTextInput.updateCharacterCount(text.length());
        Function1<? super String, Unit> function1 = microSurvicateTextInput.afterTextChanged;
        if (function1 != null) {
            function1.invoke(text);
        }
        return Unit.INSTANCE;
    }

    private final void setupView(AttributeSet attrsSet) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int[] MicroSurvicateTextInput = C8369R.styleable.MicroSurvicateTextInput;
        Intrinsics.checkNotNullExpressionValue(MicroSurvicateTextInput, "MicroSurvicateTextInput");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrsSet, MicroSurvicateTextInput, 0, 0);
        setInputStyle(MicroSurvicateTextInputStyle.INSTANCE.fromId(typedArrayObtainStyledAttributes.getInteger(C8369R.styleable.MicroSurvicateTextInput_survicateTextInputStyle, MicroSurvicateTextInputStyle.TEXT_ANSWER.getId())));
        typedArrayObtainStyledAttributes.recycle();
        ViewCompat.setAccessibilityDelegate(this.inputTextView, new AccessibilityUtils.ErrorAccessibilityDelegate());
    }

    public final void setInputStyle(MicroSurvicateTextInputStyle inputStyle) {
        Intrinsics.checkNotNullParameter(inputStyle, "inputStyle");
        int dimensionPixelSize = inputStyle.getHeight() != null ? getContext().getResources().getDimensionPixelSize(inputStyle.getHeight().intValue()) : -2;
        EditText editText = this.inputTextView;
        ViewGroup.LayoutParams layoutParams = editText.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = dimensionPixelSize;
            editText.setLayoutParams(layoutParams);
            this.inputTextView.setMaxLines(inputStyle.getSingleLine() ? 1 : Integer.MAX_VALUE);
            if (inputStyle.getSingleLine()) {
                return;
            }
            TextViewExtensionsKt.allowInnerScrolling(this.inputTextView);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        this.colorScheme = colorScheme;
        this.inputLabelTextView.setTypeface(provideFont(FontType.BOLD));
        this.inputLabelTextView.setTextColor(colorScheme.getQuestion());
        this.inputTextView.setTypeface(provideFont(FontType.REGULAR));
        EditText editText = this.inputTextView;
        MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        editText.setBackground(MicroDrawableFactory.createInputTextBackground$default(microDrawableFactory, context, colorScheme, false, 4, null));
        this.inputTextView.setTextColor(colorScheme.getAnswer());
        this.inputTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.survicate.surveys.presentation.widget.MicroSurvicateTextInput$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                MicroSurvicateTextInput.inject$lambda$4(this.f$0, view, z);
            }
        });
        this.inputTextView.setHintTextColor(ColorHelper.getArgbValue(colorScheme.getAnswer(), MicroColorControlOpacity.InputHint.getOpacityValue()));
        this.charLimitTextView.setTypeface(provideFont(FontType.REGULAR));
        this.charLimitTextView.setTextColor(colorScheme.getAnswer());
        this.errorTextView.setTypeface(provideFont(FontType.REGULAR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void inject$lambda$4(MicroSurvicateTextInput microSurvicateTextInput, View view, boolean z) {
        if (z) {
            return;
        }
        microSurvicateTextInput.validate();
    }

    public final void setInputType(int inputType) {
        this.inputTextView.setInputType(inputType);
    }

    public final void setImeActionDone() {
        this.inputTextView.setImeOptions(6);
    }

    public final void setAutofillHint(String hint) {
        this.inputTextView.setImportantForAutofill(hint != null ? 1 : 2);
        this.inputTextView.setAutofillHints(new String[]{hint});
    }

    public final void setInputLabel(String label) {
        this.inputLabelTextView.setText(label == null ? "" : label);
        String str = label;
        this.inputLabelTextView.setVisibility(str == null || StringsKt.isBlank(str) ? 8 : 0);
        this.inputLabelTextView.setLabelFor((str == null || StringsKt.isBlank(str)) ? -1 : C8369R.id.view_micro_survicate_text_input);
    }

    public final void setLabelContentDescription(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.inputLabelTextView.setContentDescription(description);
    }

    public final void setInputHint(String hint) {
        Intrinsics.checkNotNullParameter(hint, "hint");
        this.inputTextView.setHint(hint);
    }

    public static /* synthetic */ void bindTextInput$default(MicroSurvicateTextInput microSurvicateTextInput, String str, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        microSurvicateTextInput.bindTextInput(str, i, function1);
    }

    public final void bindTextInput(String initialText, int characterLimit, Function1<? super String, Unit> onAfterTextChanged) {
        Intrinsics.checkNotNullParameter(onAfterTextChanged, "onAfterTextChanged");
        this.afterTextChanged = onAfterTextChanged;
        this.inputTextView.removeTextChangedListener(this.textWatcher);
        EditText editText = this.inputTextView;
        if (initialText == null) {
            initialText = "";
        }
        editText.setText(initialText);
        this.inputTextView.addTextChangedListener(this.textWatcher);
        setCharacterLimit(characterLimit);
        updateCharacterCount(this.inputTextView.getText().length());
    }

    private final void setCharacterLimit(int limit) {
        this.characterLimit = limit;
        this.charLimitTextView.setVisibility(limit > 0 ? 0 : 8);
        if (limit > 0) {
            this.inputTextView.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(limit)});
        } else {
            this.inputTextView.setFilters(new InputFilter[0]);
        }
    }

    private final void updateCharacterCount(int length) {
        if (this.characterLimit > 0) {
            this.charLimitTextView.setText(new StringBuilder().append(length).append(JsonPointer.SEPARATOR).append(this.characterLimit).toString());
        }
    }

    public final void clearInputFocus() {
        this.inputTextView.clearFocus();
    }

    @Override // com.survicate.surveys.entities.views.InitialValidationView
    public void bindInitialValidator(Function1<? super String, Boolean> validator) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        this.initialValidator = validator;
    }

    @Override // com.survicate.surveys.entities.views.InitialValidationView
    public boolean isInitiallyValid() {
        return this.initialValidator.invoke(this.inputTextView.getText().toString()).booleanValue();
    }

    @Override // com.survicate.surveys.entities.views.InputValidationView
    public void bindValidator(InputValidator<String> validator) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        this.validator = validator;
    }

    @Override // com.survicate.surveys.entities.views.InputValidationView
    public boolean validate() {
        InputValidator<String> inputValidator = this.validator;
        if (inputValidator == null) {
            return true;
        }
        InputValidationResult inputValidationResultValidate = inputValidator.validate(this.inputTextView.getText().toString());
        if (inputValidationResultValidate.isSuccess()) {
            clearError();
        } else {
            String errorMessage = inputValidationResultValidate.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = "";
            }
            setError(errorMessage);
        }
        return inputValidationResultValidate.isSuccess();
    }

    private final void setError(String error) {
        this.errorPopup.setVisibility(0);
        this.errorTextView.setText(error);
        EditText editText = this.inputTextView;
        MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ColorScheme colorScheme = this.colorScheme;
        if (colorScheme == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme = null;
        }
        editText.setBackground(microDrawableFactory.createInputTextBackground(context, colorScheme, true));
        AccessibilityUtils.INSTANCE.setErrorState(this.inputTextView, error);
    }

    private final void clearError() {
        this.errorPopup.setVisibility(8);
        EditText editText = this.inputTextView;
        MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ColorScheme colorScheme = this.colorScheme;
        if (colorScheme == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
            colorScheme = null;
        }
        editText.setBackground(microDrawableFactory.createInputTextBackground(context, colorScheme, false));
        AccessibilityUtils.INSTANCE.setErrorState(this.inputTextView, null);
    }

    public final void setAutoSaveEnabled(boolean enabled) {
        this.inputTextView.setSaveEnabled(enabled);
    }

    public final void scrollTo() {
        ViewExtensionsKt.requestOnScreen(this, false);
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
}

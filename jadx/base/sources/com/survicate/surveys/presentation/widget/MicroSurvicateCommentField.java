package com.survicate.surveys.presentation.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.attributes.MicroSurvicateCommentFieldStyle;
import com.survicate.surveys.entities.colors.MicroColorControlOpacity;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.theming.ColorHelper;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.FontType;
import com.survicate.surveys.presentation.theming.MicroDrawableFactory;
import com.survicate.surveys.utils.AfterTextChangedWatcher;
import com.survicate.surveys.utils.extensions.TextViewExtensionsKt;
import com.survicate.surveys.utils.extensions.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MicroSurvicateCommentField.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010'\u001a\u00020\u001a2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010)\u001a\u00020\u001aH\u0002J\b\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001aH\u0002J\u0016\u0010,\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.J$\u0010/\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010\u00192\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018J\u000e\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u0019J\u0010\u00104\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\u0006\u00105\u001a\u00020\u001aJ\u0006\u00106\u001a\u00020\u001aJ\u0012\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:H\u0002J\f\u0010;\u001a\u00020\u0016*\u00020<H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006="}, m1599d2 = {"Lcom/survicate/surveys/presentation/widget/MicroSurvicateCommentField;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrsSet", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commentView", "Landroid/view/View;", "labelSpace", "labelTextView", "Landroid/widget/TextView;", "inputTextView", "Landroid/widget/EditText;", "textWatcher", "Landroid/text/TextWatcher;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "style", "Lcom/survicate/surveys/entities/attributes/MicroSurvicateCommentFieldStyle;", "afterTextChanged", "Lkotlin/Function1;", "", "", "onInputFocus", "Lkotlin/Function0;", "getOnInputFocus", "()Lkotlin/jvm/functions/Function0;", "setOnInputFocus", "(Lkotlin/jvm/functions/Function0;)V", "value", "label", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "setupView", "setStyle", "setupImeAction", "disableAutoSave", "allowInnerScrolling", "inject", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "bindTextInput", "initialText", "onAfterTextChanged", "setInputHint", "hint", "setContentDescriptionForLabel", "clearInputFocus", "scrollTo", "provideFont", "Landroid/graphics/Typeface;", "fontType", "Lcom/survicate/surveys/presentation/theming/FontType;", "readCommentFieldStyle", "Landroid/content/res/TypedArray;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurvicateCommentField extends FrameLayout {
    private Function1<? super String, Unit> afterTextChanged;
    private final View commentView;
    private final EditText inputTextView;
    private final View labelSpace;
    private final TextView labelTextView;
    private Function0<Unit> onInputFocus;
    private MicroSurvicateCommentFieldStyle style;
    private final TextWatcher textWatcher;
    private ViewDependencies viewDependencies;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurvicateCommentField(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurvicateCommentField(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MicroSurvicateCommentField(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurvicateCommentField(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.style = MicroSurvicateCommentFieldStyle.STANDALONE;
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_comment, this);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        this.commentView = viewInflate;
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_comment_label_space);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.labelSpace = viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_comment_label);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.labelTextView = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(C8369R.id.view_micro_comment_input_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.inputTextView = (EditText) viewFindViewById3;
        this.textWatcher = new AfterTextChangedWatcher(new Function1() { // from class: com.survicate.surveys.presentation.widget.MicroSurvicateCommentField$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MicroSurvicateCommentField._init_$lambda$0(this.f$0, (String) obj);
            }
        });
        setupView(attributeSet);
    }

    public final Function0<Unit> getOnInputFocus() {
        return this.onInputFocus;
    }

    public final void setOnInputFocus(Function0<Unit> function0) {
        this.onInputFocus = function0;
    }

    public final String getLabel() {
        return this.labelTextView.getText().toString();
    }

    public final void setLabel(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String str = value;
        this.labelTextView.setText(str);
        setContentDescriptionForLabel(value);
        this.labelTextView.setVisibility(!StringsKt.isBlank(str) ? 0 : 8);
        this.labelSpace.setVisibility(StringsKt.isBlank(str) ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(MicroSurvicateCommentField microSurvicateCommentField, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Function1<? super String, Unit> function1 = microSurvicateCommentField.afterTextChanged;
        if (function1 != null) {
            function1.invoke(text);
        }
        return Unit.INSTANCE;
    }

    private final void setupView(AttributeSet attrsSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrsSet, C8369R.styleable.MicroSurvicateCommentField);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        MicroSurvicateCommentFieldStyle commentFieldStyle = readCommentFieldStyle(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        setStyle(commentFieldStyle);
        setupImeAction();
        disableAutoSave();
        allowInnerScrolling();
    }

    public final void setStyle(MicroSurvicateCommentFieldStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.style = style;
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(style.getHeight());
        EditText editText = this.inputTextView;
        ViewGroup.LayoutParams layoutParams = editText.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = dimensionPixelSize;
            editText.setLayoutParams(layoutParams);
            this.labelSpace.setVisibility(style == MicroSurvicateCommentFieldStyle.STANDALONE ? 0 : 8);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final void setupImeAction() {
        this.inputTextView.setImeOptions(6);
    }

    private final void disableAutoSave() {
        this.inputTextView.setSaveEnabled(false);
    }

    private final void allowInnerScrolling() {
        TextViewExtensionsKt.allowInnerScrolling(this.inputTextView);
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        if (this.style == MicroSurvicateCommentFieldStyle.STANDALONE) {
            MicroDrawableFactory microDrawableFactory = MicroDrawableFactory.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            setBackground(microDrawableFactory.createAnswerItemBackground(context, colorScheme, true));
            ViewExtensionsKt.clipChildrenToBackground(this.commentView);
        } else {
            setBackground(null);
        }
        this.labelTextView.setTypeface(provideFont(FontType.BOLD));
        this.labelTextView.setTextColor(colorScheme.getAnswer());
        this.inputTextView.setTypeface(provideFont(FontType.REGULAR));
        EditText editText = this.inputTextView;
        MicroDrawableFactory microDrawableFactory2 = MicroDrawableFactory.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        editText.setBackground(MicroDrawableFactory.createInputTextBackground$default(microDrawableFactory2, context2, colorScheme, false, 4, null));
        this.inputTextView.setTextColor(colorScheme.getAnswer());
        this.inputTextView.setHintTextColor(ColorHelper.getArgbValue(colorScheme.getAnswer(), MicroColorControlOpacity.InputHint.getOpacityValue()));
        this.inputTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.survicate.surveys.presentation.widget.MicroSurvicateCommentField$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                MicroSurvicateCommentField.inject$lambda$2(this.f$0, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void inject$lambda$2(MicroSurvicateCommentField microSurvicateCommentField, View view, boolean z) {
        Function0<Unit> function0;
        if (!z || (function0 = microSurvicateCommentField.onInputFocus) == null) {
            return;
        }
        function0.invoke();
    }

    public final void bindTextInput(String initialText, Function1<? super String, Unit> onAfterTextChanged) {
        Intrinsics.checkNotNullParameter(onAfterTextChanged, "onAfterTextChanged");
        this.afterTextChanged = onAfterTextChanged;
        this.inputTextView.removeTextChangedListener(this.textWatcher);
        EditText editText = this.inputTextView;
        if (initialText == null) {
            initialText = "";
        }
        editText.setText(initialText);
        this.inputTextView.addTextChangedListener(this.textWatcher);
    }

    public final void setInputHint(String hint) {
        Intrinsics.checkNotNullParameter(hint, "hint");
        this.inputTextView.setHint(hint);
    }

    private final void setContentDescriptionForLabel(String label) {
        this.labelTextView.setContentDescription(!StringsKt.isBlank(label) ? getContext().getString(C8369R.string.survicate_micro_field_required_content_description, label) : null);
    }

    public final void clearInputFocus() {
        this.inputTextView.clearFocus();
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

    private final MicroSurvicateCommentFieldStyle readCommentFieldStyle(TypedArray typedArray) {
        return MicroSurvicateCommentFieldStyle.INSTANCE.fromId(typedArray.getInteger(C8369R.styleable.MicroSurvicateCommentField_survicateCommentFieldStyle, MicroSurvicateCommentFieldStyle.STANDALONE.getId()));
    }
}

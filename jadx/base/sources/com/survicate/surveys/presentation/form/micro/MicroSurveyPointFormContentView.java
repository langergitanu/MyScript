package com.survicate.surveys.presentation.form.micro;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.attributes.MicroSurvicateTextInputStyle;
import com.survicate.surveys.entities.survey.questions.form.SurveyFormField;
import com.survicate.surveys.entities.survey.questions.form.SurveyFormSurveyPoint;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.entities.views.InitialValidationView;
import com.survicate.surveys.entities.views.InputValidationView;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.presentation.widget.MicroQuestionHeader;
import com.survicate.surveys.presentation.widget.MicroSurvicateTextInput;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.utils.AccessibilityUtils;
import com.survicate.surveys.utils.ContactFormValidatorFactory;
import com.survicate.surveys.utils.SurvicateViewUtils;
import com.survicate.surveys.utils.extensions.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MicroSurveyPointFormContentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 <2\u00020\u0001:\u0003<=>B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010%\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010&\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010(J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010*\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u001c\u0010+\u001a\u00020\u00122\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100-H\u0002J,\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100-2\u0006\u00101\u001a\u000202H\u0002J \u00103\u001a\u0002042\u0006\u0010/\u001a\u0002002\u0006\u00105\u001a\u00020\u00102\u0006\u00101\u001a\u000202H\u0002J\b\u00106\u001a\u000207H\u0002J\u0006\u00108\u001a\u000202J\u0006\u00109\u001a\u000202J\b\u0010:\u001a\u00020\u0012H\u0002J\b\u0010;\u001a\u00020\u0012H\u0002RL\u0010\n\u001a4\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, m1599d2 = {"Lcom/survicate/surveys/presentation/form/micro/MicroSurveyPointFormContentView;", "Landroid/widget/FrameLayout;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onFieldInputChanged", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "fieldId", "", "value", "", "getOnFieldInputChanged", "()Lkotlin/jvm/functions/Function2;", "setOnFieldInputChanged", "(Lkotlin/jvm/functions/Function2;)V", "bindingData", "Lcom/survicate/surveys/presentation/form/micro/MicroSurveyPointFormContentView$BindingData;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint;", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint;", "questionHeaderView", "Lcom/survicate/surveys/presentation/widget/MicroQuestionHeader;", "formContainer", "Landroid/widget/LinearLayout;", "inject", "bindData", "savedState", "Landroid/os/Bundle;", "bindHeader", "bindFormFields", "generateForm", "savedInputs", "", "generateFormField", "formField", "Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormField;", "isLastField", "", "createTextInput", "Lcom/survicate/surveys/presentation/widget/MicroSurvicateTextInput;", "initialValue", "createTextInputParams", "Landroid/view/ViewGroup$LayoutParams;", "validateRequiredFieldsFilled", "validateRequiredFieldsCorrect", "setupScrollOnInputFocus", "scrollFocusedInputIntoView", "Companion", "BindingData", "SavedState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSurveyPointFormContentView extends FrameLayout {
    public static final String SAVED_STATE = "SAVED_STATE";
    private BindingData bindingData;
    private ColorScheme colorScheme;
    private final LinearLayout formContainer;
    private Function2<? super Long, ? super String, Unit> onFieldInputChanged;
    private final MicroQuestionHeader questionHeaderView;
    private ViewDependencies viewDependencies;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointFormContentView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointFormContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createTextInput$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    public /* synthetic */ MicroSurveyPointFormContentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicroSurveyPointFormContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = FrameLayout.inflate(context, C8369R.layout.view_micro_survey_point_form_content, this);
        View viewFindViewById = viewInflate.findViewById(C8369R.id.view_micro_survey_point_form_content_header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.questionHeaderView = (MicroQuestionHeader) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C8369R.id.view_micro_survey_point_form_content_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.formContainer = (LinearLayout) viewFindViewById2;
        setupScrollOnInputFocus();
    }

    public final Function2<Long, String, Unit> getOnFieldInputChanged() {
        return this.onFieldInputChanged;
    }

    public final void setOnFieldInputChanged(Function2<? super Long, ? super String, Unit> function2) {
        this.onFieldInputChanged = function2;
    }

    private final SurveyFormSurveyPoint getSurveyPoint() {
        BindingData bindingData = this.bindingData;
        if (bindingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingData");
            bindingData = null;
        }
        return bindingData.getSurveyPoint();
    }

    public final void inject(ViewDependencies viewDependencies, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.viewDependencies = viewDependencies;
        this.colorScheme = colorScheme;
        this.questionHeaderView.inject(viewDependencies, colorScheme);
    }

    public final void bindData(BindingData bindingData, Bundle savedState) {
        Intrinsics.checkNotNullParameter(bindingData, "bindingData");
        this.bindingData = bindingData;
        bindHeader(bindingData);
        bindFormFields(savedState);
    }

    private final void bindHeader(BindingData bindingData) {
        this.questionHeaderView.bindData(bindingData.getQuestionHeaderBindingData());
    }

    private final void generateForm(Map<Long, String> savedInputs) {
        this.formContainer.removeAllViews();
        Iterator<T> it = getSurveyPoint().getFields().iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            generateFormField((SurveyFormField) it.next(), savedInputs, i == CollectionsKt.getLastIndex(getSurveyPoint().getFields()));
            i = i2;
        }
    }

    private final void generateFormField(SurveyFormField formField, Map<Long, String> savedInputs, boolean isLastField) {
        String str = savedInputs.get(Long.valueOf(formField.getId()));
        if (str == null) {
            str = "";
        }
        this.formContainer.addView(createTextInput(formField, str, isLastField), createTextInputParams());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final MicroSurvicateTextInput createTextInput(final SurveyFormField formField, String initialValue, boolean isLastField) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ColorScheme colorScheme = null;
        MicroSurvicateTextInput microSurvicateTextInput = new MicroSurvicateTextInput(context, 0 == true ? 1 : 0, 0, 6, null);
        ViewDependencies viewDependencies = this.viewDependencies;
        if (viewDependencies == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDependencies");
            viewDependencies = null;
        }
        ColorScheme colorScheme2 = this.colorScheme;
        if (colorScheme2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorScheme");
        } else {
            colorScheme = colorScheme2;
        }
        microSurvicateTextInput.inject(viewDependencies, colorScheme);
        microSurvicateTextInput.setAutoSaveEnabled(false);
        microSurvicateTextInput.setInputStyle(MicroSurvicateTextInputStyle.FORM);
        ViewCompat.setScreenReaderFocusable(microSurvicateTextInput, true);
        microSurvicateTextInput.setInputType(MicroFormUtils.INSTANCE.getInputType(formField.getFieldType()));
        if (isLastField) {
            microSurvicateTextInput.setImeActionDone();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            microSurvicateTextInput.setAutofillHint(MicroFormUtils.INSTANCE.getAutofillHint(formField.getFieldType()));
        }
        MicroSurvicateTextInput.bindTextInput$default(microSurvicateTextInput, initialValue, 0, new Function1() { // from class: com.survicate.surveys.presentation.form.micro.MicroSurveyPointFormContentView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MicroSurveyPointFormContentView.createTextInput$lambda$0(this.f$0, formField, (String) obj);
            }
        }, 2, null);
        microSurvicateTextInput.setInputLabel(formField.getLabel() + (formField.getRequired() ? "*" : ""));
        ContactFormValidatorFactory contactFormValidatorFactory = ContactFormValidatorFactory.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        microSurvicateTextInput.bindValidator(contactFormValidatorFactory.createValidator(formField, context2));
        if (formField.getRequired()) {
            microSurvicateTextInput.bindInitialValidator(C84382.INSTANCE);
            String string = getContext().getString(C8369R.string.survicate_micro_field_required_content_description, formField.getLabel());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            microSurvicateTextInput.setLabelContentDescription(string);
            return microSurvicateTextInput;
        }
        microSurvicateTextInput.bindInitialValidator(new Function1() { // from class: com.survicate.surveys.presentation.form.micro.MicroSurveyPointFormContentView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MicroSurveyPointFormContentView.createTextInput$lambda$1((String) obj));
            }
        });
        return microSurvicateTextInput;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createTextInput$lambda$0(MicroSurveyPointFormContentView microSurveyPointFormContentView, SurveyFormField surveyFormField, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Function2<? super Long, ? super String, Unit> function2 = microSurveyPointFormContentView.onFieldInputChanged;
        if (function2 != null) {
            function2.invoke(Long.valueOf(surveyFormField.getId()), value);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.form.micro.MicroSurveyPointFormContentView$createTextInput$2 */
    /* JADX INFO: compiled from: MicroSurveyPointFormContentView.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    /* synthetic */ class C84382 extends FunctionReferenceImpl implements Function1<String, Boolean> {
        public static final C84382 INSTANCE = new C84382();

        C84382() {
            super(1, StringsKt.class, "isNotBlank", "isNotBlank(Ljava/lang/CharSequence;)Z", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return Boolean.valueOf(!StringsKt.isBlank(p0));
        }
    }

    private final ViewGroup.LayoutParams createTextInputParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_space_xs);
        return layoutParams;
    }

    public final boolean validateRequiredFieldsFilled() {
        List<SurveyFormField> fields = getSurveyPoint().getFields();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : fields) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View childAt = this.formContainer.getChildAt(i);
            if (childAt != null) {
                arrayList.add(childAt);
            }
            i = i2;
        }
        List listFilterIsInstance = CollectionsKt.filterIsInstance(arrayList, InitialValidationView.class);
        if ((listFilterIsInstance instanceof Collection) && listFilterIsInstance.isEmpty()) {
            return true;
        }
        Iterator it = listFilterIsInstance.iterator();
        while (it.hasNext()) {
            if (!((InitialValidationView) it.next()).isInitiallyValid()) {
                return false;
            }
        }
        return true;
    }

    public final boolean validateRequiredFieldsCorrect() {
        List<SurveyFormField> fields = getSurveyPoint().getFields();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : fields) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View childAt = this.formContainer.getChildAt(i);
            if (childAt != null) {
                arrayList.add(childAt);
            }
            i = i2;
        }
        List listFilterIsInstance = CollectionsKt.filterIsInstance(arrayList, InputValidationView.class);
        if ((listFilterIsInstance instanceof Collection) && listFilterIsInstance.isEmpty()) {
            return true;
        }
        Iterator it = listFilterIsInstance.iterator();
        while (it.hasNext()) {
            if (!((InputValidationView) it.next()).validate()) {
                return false;
            }
        }
        return true;
    }

    private final void setupScrollOnInputFocus() {
        SurvicateViewUtils.INSTANCE.observeShowKeyboardAnimationEnd(this, new Function0() { // from class: com.survicate.surveys.presentation.form.micro.MicroSurveyPointFormContentView$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MicroSurveyPointFormContentView.setupScrollOnInputFocus$lambda$6(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupScrollOnInputFocus$lambda$6(MicroSurveyPointFormContentView microSurveyPointFormContentView) {
        microSurveyPointFormContentView.scrollFocusedInputIntoView();
        return Unit.INSTANCE;
    }

    private final void scrollFocusedInputIntoView() {
        View viewFindFocus;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (AccessibilityUtils.isTalkbackEnabled(context) || (viewFindFocus = findFocus()) == null) {
            return;
        }
        ViewExtensionsKt.requestOnScreen$default(viewFindFocus, false, 1, null);
    }

    /* JADX INFO: compiled from: MicroSurveyPointFormContentView.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/presentation/form/micro/MicroSurveyPointFormContentView$BindingData;", "", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint;", "questionHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint;Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint;", "getQuestionHeaderBindingData", "()Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class BindingData {
        private final QuestionHeaderBindingData questionHeaderBindingData;
        private final SurveyFormSurveyPoint surveyPoint;

        public static /* synthetic */ BindingData copy$default(BindingData bindingData, SurveyFormSurveyPoint surveyFormSurveyPoint, QuestionHeaderBindingData questionHeaderBindingData, int i, Object obj) {
            if ((i & 1) != 0) {
                surveyFormSurveyPoint = bindingData.surveyPoint;
            }
            if ((i & 2) != 0) {
                questionHeaderBindingData = bindingData.questionHeaderBindingData;
            }
            return bindingData.copy(surveyFormSurveyPoint, questionHeaderBindingData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SurveyFormSurveyPoint getSurveyPoint() {
            return this.surveyPoint;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final QuestionHeaderBindingData getQuestionHeaderBindingData() {
            return this.questionHeaderBindingData;
        }

        public final BindingData copy(SurveyFormSurveyPoint surveyPoint, QuestionHeaderBindingData questionHeaderBindingData) {
            Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            return new BindingData(surveyPoint, questionHeaderBindingData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BindingData)) {
                return false;
            }
            BindingData bindingData = (BindingData) other;
            return Intrinsics.areEqual(this.surveyPoint, bindingData.surveyPoint) && Intrinsics.areEqual(this.questionHeaderBindingData, bindingData.questionHeaderBindingData);
        }

        public int hashCode() {
            return (this.surveyPoint.hashCode() * 31) + this.questionHeaderBindingData.hashCode();
        }

        public String toString() {
            return "BindingData(surveyPoint=" + this.surveyPoint + ", questionHeaderBindingData=" + this.questionHeaderBindingData + ')';
        }

        public BindingData(SurveyFormSurveyPoint surveyPoint, QuestionHeaderBindingData questionHeaderBindingData) {
            Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
            Intrinsics.checkNotNullParameter(questionHeaderBindingData, "questionHeaderBindingData");
            this.surveyPoint = surveyPoint;
            this.questionHeaderBindingData = questionHeaderBindingData;
        }

        public final SurveyFormSurveyPoint getSurveyPoint() {
            return this.surveyPoint;
        }

        public final QuestionHeaderBindingData getQuestionHeaderBindingData() {
            return this.questionHeaderBindingData;
        }
    }

    /* JADX INFO: compiled from: MicroSurveyPointFormContentView.kt */
    @Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, m1599d2 = {"Lcom/survicate/surveys/presentation/form/micro/MicroSurveyPointFormContentView$SavedState;", "Landroid/os/Parcelable;", Keys.INPUTS, "", "", "", "<init>", "(Ljava/util/Map;)V", "getInputs", "()Ljava/util/Map;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator();
        private final Map<Long, String> inputs;

        /* JADX INFO: compiled from: MicroSurveyPointFormContentView.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
        public static final class Creator implements Parcelable.Creator<SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int i = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i);
                for (int i2 = 0; i2 != i; i2++) {
                    linkedHashMap.put(Long.valueOf(parcel.readLong()), parcel.readString());
                }
                return new SavedState(linkedHashMap);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SavedState copy$default(SavedState savedState, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = savedState.inputs;
            }
            return savedState.copy(map);
        }

        public final Map<Long, String> component1() {
            return this.inputs;
        }

        public final SavedState copy(Map<Long, String> inputs) {
            Intrinsics.checkNotNullParameter(inputs, "inputs");
            return new SavedState(inputs);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SavedState) && Intrinsics.areEqual(this.inputs, ((SavedState) other).inputs);
        }

        public int hashCode() {
            return this.inputs.hashCode();
        }

        public String toString() {
            return "SavedState(inputs=" + this.inputs + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            Map<Long, String> map = this.inputs;
            dest.writeInt(map.size());
            for (Map.Entry<Long, String> entry : map.entrySet()) {
                dest.writeLong(entry.getKey().longValue());
                dest.writeString(entry.getValue());
            }
        }

        public SavedState(Map<Long, String> inputs) {
            Intrinsics.checkNotNullParameter(inputs, "inputs");
            this.inputs = inputs;
        }

        public final Map<Long, String> getInputs() {
            return this.inputs;
        }
    }

    private final void bindFormFields(Bundle savedState) {
        Parcelable parcelable;
        Map<Long, String> mapEmptyMap = null;
        if (savedState != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", SavedState.class);
            } else {
                Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
                if (!(parcelable2 instanceof SavedState)) {
                    parcelable2 = null;
                }
                parcelable = (SavedState) parcelable2;
            }
            SavedState savedState2 = (SavedState) parcelable;
            if (savedState2 != null) {
                mapEmptyMap = savedState2.getInputs();
            }
        }
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        generateForm(mapEmptyMap);
    }
}

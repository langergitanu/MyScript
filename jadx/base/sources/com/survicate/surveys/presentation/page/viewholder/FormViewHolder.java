package com.survicate.surveys.presentation.page.viewholder;

import com.survicate.surveys.presentation.form.FormQuestionViewModel;
import com.survicate.surveys.presentation.form.micro.MicroSurveyPointFormContentView;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormViewHolder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/viewholder/FormViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/QuestionViewHolder;", "contentView", "Lcom/survicate/surveys/presentation/form/micro/MicroSurveyPointFormContentView;", "<init>", "(Lcom/survicate/surveys/presentation/form/micro/MicroSurveyPointFormContentView;)V", "boundViewModel", "Lcom/survicate/surveys/presentation/form/FormQuestionViewModel;", "bind", "", "viewModel", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "unbind", "setupListeners", "vm", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class FormViewHolder extends QuestionViewHolder {
    private FormQuestionViewModel boundViewModel;
    private final MicroSurveyPointFormContentView contentView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormViewHolder(MicroSurveyPointFormContentView contentView) {
        super(contentView, null);
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.contentView = contentView;
    }

    @Override // com.survicate.surveys.presentation.page.viewholder.QuestionViewHolder
    public void bind(QuestionViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        FormQuestionViewModel formQuestionViewModel = (FormQuestionViewModel) viewModel;
        this.boundViewModel = formQuestionViewModel;
        this.contentView.bindData(formQuestionViewModel.getBindingData(), formQuestionViewModel.toSavedState());
        setupListeners(formQuestionViewModel);
    }

    @Override // com.survicate.surveys.presentation.page.viewholder.QuestionViewHolder
    public void unbind() {
        this.contentView.setOnFieldInputChanged(null);
        FormQuestionViewModel formQuestionViewModel = this.boundViewModel;
        if (formQuestionViewModel != null) {
            formQuestionViewModel.setOnValidateFieldsRequested(null);
        }
        this.boundViewModel = null;
    }

    private final void setupListeners(final FormQuestionViewModel vm) {
        this.contentView.setOnFieldInputChanged(new Function2() { // from class: com.survicate.surveys.presentation.page.viewholder.FormViewHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FormViewHolder.setupListeners$lambda$0(vm, ((Long) obj).longValue(), (String) obj2);
            }
        });
        vm.setOnValidateFieldsRequested(new Function0() { // from class: com.survicate.surveys.presentation.page.viewholder.FormViewHolder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(FormViewHolder.setupListeners$lambda$1(this.f$0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0(FormQuestionViewModel formQuestionViewModel, long j, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        formQuestionViewModel.onFieldInputChanged(j, value);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupListeners$lambda$1(FormViewHolder formViewHolder) {
        return formViewHolder.contentView.validateRequiredFieldsCorrect();
    }
}

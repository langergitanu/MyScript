package com.survicate.surveys.presentation.page.viewholder;

import com.survicate.surveys.presentation.page.QuestionViewModel;
import com.survicate.surveys.presentation.text.TextQuestionViewModel;
import com.survicate.surveys.presentation.text.micro.MicroSurveyPointTextContentView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextViewHolder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/viewholder/TextViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/QuestionViewHolder;", "contentView", "Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView;", "<init>", "(Lcom/survicate/surveys/presentation/text/micro/MicroSurveyPointTextContentView;)V", "boundViewModel", "Lcom/survicate/surveys/presentation/text/TextQuestionViewModel;", "bind", "", "viewModel", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "unbind", "setupListeners", "vm", "renderFollowUpState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TextViewHolder extends QuestionViewHolder {
    private TextQuestionViewModel boundViewModel;
    private final MicroSurveyPointTextContentView contentView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextViewHolder(MicroSurveyPointTextContentView contentView) {
        super(contentView, null);
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.contentView = contentView;
    }

    @Override // com.survicate.surveys.presentation.page.viewholder.QuestionViewHolder
    public void bind(QuestionViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        TextQuestionViewModel textQuestionViewModel = (TextQuestionViewModel) viewModel;
        this.boundViewModel = textQuestionViewModel;
        this.contentView.bindData(textQuestionViewModel.getBindingData(), textQuestionViewModel.toSavedState());
        if (textQuestionViewModel.getIsRequestingFollowUp()) {
            this.contentView.showProgressAnimation();
        }
        setupListeners(textQuestionViewModel);
    }

    @Override // com.survicate.surveys.presentation.page.viewholder.QuestionViewHolder
    public void unbind() {
        TextQuestionViewModel textQuestionViewModel = this.boundViewModel;
        if (textQuestionViewModel == null) {
            return;
        }
        textQuestionViewModel.setOnFollowUpStateChanged(null);
        this.contentView.setOnAnswerChanged(null);
        this.boundViewModel = null;
    }

    private final void setupListeners(final TextQuestionViewModel vm) {
        this.contentView.setOnAnswerChanged(new Function2() { // from class: com.survicate.surveys.presentation.page.viewholder.TextViewHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TextViewHolder.setupListeners$lambda$0(vm, ((Integer) obj).intValue(), (String) obj2);
            }
        });
        vm.setOnFollowUpStateChanged(new Function0() { // from class: com.survicate.surveys.presentation.page.viewholder.TextViewHolder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextViewHolder.setupListeners$lambda$1(this.f$0, vm);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0(TextQuestionViewModel textQuestionViewModel, int i, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        textQuestionViewModel.onAnswerChanged(i, text);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$1(TextViewHolder textViewHolder, TextQuestionViewModel textQuestionViewModel) {
        textViewHolder.renderFollowUpState(textQuestionViewModel);
        return Unit.INSTANCE;
    }

    private final void renderFollowUpState(TextQuestionViewModel vm) {
        if (vm.getIsRequestingFollowUp()) {
            this.contentView.showProgressAnimation();
        } else {
            this.contentView.bindData(vm.getBindingData(), vm.toSavedState());
        }
        this.contentView.post(new Runnable() { // from class: com.survicate.surveys.presentation.page.viewholder.TextViewHolder$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                TextViewHolder.renderFollowUpState$lambda$2(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderFollowUpState$lambda$2(TextViewHolder textViewHolder) {
        textViewHolder.contentView.scrollToEnd();
    }
}

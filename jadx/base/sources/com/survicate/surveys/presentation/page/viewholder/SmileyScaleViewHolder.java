package com.survicate.surveys.presentation.page.viewholder;

import com.survicate.surveys.presentation.page.QuestionViewModel;
import com.survicate.surveys.presentation.smileyscale.SmileyScaleQuestionViewModel;
import com.survicate.surveys.presentation.smileyscale.micro.MicroSurveyPointSmileyScaleContentView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmileyScaleViewHolder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/viewholder/SmileyScaleViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/QuestionViewHolder;", "contentView", "Lcom/survicate/surveys/presentation/smileyscale/micro/MicroSurveyPointSmileyScaleContentView;", "<init>", "(Lcom/survicate/surveys/presentation/smileyscale/micro/MicroSurveyPointSmileyScaleContentView;)V", "providesOwnHorizontalPadding", "", "getProvidesOwnHorizontalPadding", "()Z", "bind", "", "viewModel", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "setupListeners", "vm", "Lcom/survicate/surveys/presentation/smileyscale/SmileyScaleQuestionViewModel;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SmileyScaleViewHolder extends QuestionViewHolder {
    private final MicroSurveyPointSmileyScaleContentView contentView;
    private final boolean providesOwnHorizontalPadding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmileyScaleViewHolder(MicroSurveyPointSmileyScaleContentView contentView) {
        super(contentView, null);
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.contentView = contentView;
        this.providesOwnHorizontalPadding = true;
    }

    @Override // com.survicate.surveys.presentation.page.viewholder.QuestionViewHolder
    public boolean getProvidesOwnHorizontalPadding() {
        return this.providesOwnHorizontalPadding;
    }

    @Override // com.survicate.surveys.presentation.page.viewholder.QuestionViewHolder
    public void bind(QuestionViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        SmileyScaleQuestionViewModel smileyScaleQuestionViewModel = (SmileyScaleQuestionViewModel) viewModel;
        this.contentView.bindData(smileyScaleQuestionViewModel.getBindingData(), smileyScaleQuestionViewModel.toSavedState());
        setupListeners(smileyScaleQuestionViewModel);
    }

    private final void setupListeners(final SmileyScaleQuestionViewModel vm) {
        this.contentView.setOnAnswerSelected(new Function1() { // from class: com.survicate.surveys.presentation.page.viewholder.SmileyScaleViewHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SmileyScaleViewHolder.setupListeners$lambda$0(vm, ((Long) obj).longValue());
            }
        });
        this.contentView.setOnCommentChanged(new Function1() { // from class: com.survicate.surveys.presentation.page.viewholder.SmileyScaleViewHolder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SmileyScaleViewHolder.setupListeners$lambda$1(vm, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0(SmileyScaleQuestionViewModel smileyScaleQuestionViewModel, long j) {
        smileyScaleQuestionViewModel.onAnswerSelected(j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$1(SmileyScaleQuestionViewModel smileyScaleQuestionViewModel, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        smileyScaleQuestionViewModel.onCommentChanged(text);
        return Unit.INSTANCE;
    }
}

package com.survicate.surveys.presentation.page.viewholder;

import com.survicate.surveys.presentation.csat.CsatQuestionViewModel;
import com.survicate.surveys.presentation.csat.micro.MicroSurveyPointCsatContentView;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CsatViewHolder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/viewholder/CsatViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/QuestionViewHolder;", "contentView", "Lcom/survicate/surveys/presentation/csat/micro/MicroSurveyPointCsatContentView;", "<init>", "(Lcom/survicate/surveys/presentation/csat/micro/MicroSurveyPointCsatContentView;)V", "bind", "", "viewModel", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "setupListeners", "vm", "Lcom/survicate/surveys/presentation/csat/CsatQuestionViewModel;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class CsatViewHolder extends QuestionViewHolder {
    private final MicroSurveyPointCsatContentView contentView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CsatViewHolder(MicroSurveyPointCsatContentView contentView) {
        super(contentView, null);
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.contentView = contentView;
    }

    @Override // com.survicate.surveys.presentation.page.viewholder.QuestionViewHolder
    public void bind(QuestionViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        CsatQuestionViewModel csatQuestionViewModel = (CsatQuestionViewModel) viewModel;
        this.contentView.bindData(csatQuestionViewModel.getBindingData(), csatQuestionViewModel.toSavedState());
        setupListeners(csatQuestionViewModel);
    }

    private final void setupListeners(final CsatQuestionViewModel vm) {
        this.contentView.setOnAnswerSelected(new Function1() { // from class: com.survicate.surveys.presentation.page.viewholder.CsatViewHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CsatViewHolder.setupListeners$lambda$0(vm, ((Long) obj).longValue());
            }
        });
        this.contentView.setOnCommentChanged(new Function1() { // from class: com.survicate.surveys.presentation.page.viewholder.CsatViewHolder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CsatViewHolder.setupListeners$lambda$1(vm, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0(CsatQuestionViewModel csatQuestionViewModel, long j) {
        csatQuestionViewModel.onAnswerSelected(j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$1(CsatQuestionViewModel csatQuestionViewModel, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        csatQuestionViewModel.onCommentChanged(text);
        return Unit.INSTANCE;
    }
}

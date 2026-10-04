package com.survicate.surveys.presentation.page.viewholder;

import com.survicate.surveys.presentation.cta.CtaQuestionViewModel;
import com.survicate.surveys.presentation.cta.micro.MicroSurveyPointCtaContentView;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CtaViewHolder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/viewholder/CtaViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/QuestionViewHolder;", "contentView", "Lcom/survicate/surveys/presentation/cta/micro/MicroSurveyPointCtaContentView;", "<init>", "(Lcom/survicate/surveys/presentation/cta/micro/MicroSurveyPointCtaContentView;)V", "bind", "", "viewModel", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class CtaViewHolder extends QuestionViewHolder {
    private final MicroSurveyPointCtaContentView contentView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CtaViewHolder(MicroSurveyPointCtaContentView contentView) {
        super(contentView, null);
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.contentView = contentView;
    }

    @Override // com.survicate.surveys.presentation.page.viewholder.QuestionViewHolder
    public void bind(QuestionViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.contentView.bindData(((CtaQuestionViewModel) viewModel).getBindingData());
    }
}

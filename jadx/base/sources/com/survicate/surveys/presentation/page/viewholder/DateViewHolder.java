package com.survicate.surveys.presentation.page.viewholder;

import com.survicate.surveys.presentation.date.DateQuestionViewModel;
import com.survicate.surveys.presentation.date.micro.MicroSurveyPointDateContentView;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import com.survicate.surveys.utils.SurvicateLocalDate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateViewHolder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/viewholder/DateViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/QuestionViewHolder;", "contentView", "Lcom/survicate/surveys/presentation/date/micro/MicroSurveyPointDateContentView;", "<init>", "(Lcom/survicate/surveys/presentation/date/micro/MicroSurveyPointDateContentView;)V", "bind", "", "viewModel", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "setupListeners", "vm", "Lcom/survicate/surveys/presentation/date/DateQuestionViewModel;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DateViewHolder extends QuestionViewHolder {
    private final MicroSurveyPointDateContentView contentView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateViewHolder(MicroSurveyPointDateContentView contentView) {
        super(contentView, null);
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.contentView = contentView;
    }

    @Override // com.survicate.surveys.presentation.page.viewholder.QuestionViewHolder
    public void bind(QuestionViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        DateQuestionViewModel dateQuestionViewModel = (DateQuestionViewModel) viewModel;
        this.contentView.bindData(dateQuestionViewModel.getBindingData(), dateQuestionViewModel.toSavedState());
        setupListeners(dateQuestionViewModel);
    }

    private final void setupListeners(final DateQuestionViewModel vm) {
        this.contentView.setOnSelectDateClick(new Function0() { // from class: com.survicate.surveys.presentation.page.viewholder.DateViewHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DateViewHolder.setupListeners$lambda$0(vm);
            }
        });
        this.contentView.setOnCommentChanged(new Function1() { // from class: com.survicate.surveys.presentation.page.viewholder.DateViewHolder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DateViewHolder.setupListeners$lambda$1(vm, (String) obj);
            }
        });
        vm.setOnSelectedDateChanged(new Function1() { // from class: com.survicate.surveys.presentation.page.viewholder.DateViewHolder$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DateViewHolder.setupListeners$lambda$2(this.f$0, (SurvicateLocalDate) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0(DateQuestionViewModel dateQuestionViewModel) {
        dateQuestionViewModel.onSelectDate();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$1(DateQuestionViewModel dateQuestionViewModel, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        dateQuestionViewModel.onCommentChanged(text);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$2(DateViewHolder dateViewHolder, SurvicateLocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        dateViewHolder.contentView.updateSelectedDate(date);
        return Unit.INSTANCE;
    }
}

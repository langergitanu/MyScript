package com.survicate.surveys.presentation.page.viewholder;

import com.survicate.surveys.presentation.matrix.MatrixQuestionViewModel;
import com.survicate.surveys.presentation.matrix.micro.MicroSurveyPointMatrixContentView;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixViewHolder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/viewholder/MatrixViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/QuestionViewHolder;", "contentView", "Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixContentView;", "<init>", "(Lcom/survicate/surveys/presentation/matrix/micro/MicroSurveyPointMatrixContentView;)V", "bind", "", "viewModel", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "setupListeners", "vm", "Lcom/survicate/surveys/presentation/matrix/MatrixQuestionViewModel;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MatrixViewHolder extends QuestionViewHolder {
    private final MicroSurveyPointMatrixContentView contentView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatrixViewHolder(MicroSurveyPointMatrixContentView contentView) {
        super(contentView, null);
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.contentView = contentView;
    }

    @Override // com.survicate.surveys.presentation.page.viewholder.QuestionViewHolder
    public void bind(QuestionViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        MatrixQuestionViewModel matrixQuestionViewModel = (MatrixQuestionViewModel) viewModel;
        this.contentView.bindData(matrixQuestionViewModel.getBindingData(), matrixQuestionViewModel.toSavedState());
        setupListeners(matrixQuestionViewModel);
    }

    private final void setupListeners(final MatrixQuestionViewModel vm) {
        this.contentView.setOnColumnSelected(new Function2() { // from class: com.survicate.surveys.presentation.page.viewholder.MatrixViewHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MatrixViewHolder.setupListeners$lambda$0(vm, ((Long) obj).longValue(), ((Long) obj2).longValue());
            }
        });
        this.contentView.setOnCommentChanged(new Function3() { // from class: com.survicate.surveys.presentation.page.viewholder.MatrixViewHolder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MatrixViewHolder.setupListeners$lambda$1(vm, ((Long) obj).longValue(), ((Long) obj2).longValue(), (String) obj3);
            }
        });
        this.contentView.setOnExpandedChanged(new Function2() { // from class: com.survicate.surveys.presentation.page.viewholder.MatrixViewHolder$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MatrixViewHolder.setupListeners$lambda$2(vm, ((Long) obj).longValue(), ((Boolean) obj2).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0(MatrixQuestionViewModel matrixQuestionViewModel, long j, long j2) {
        matrixQuestionViewModel.onColumnSelected(j, j2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$1(MatrixQuestionViewModel matrixQuestionViewModel, long j, long j2, String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        matrixQuestionViewModel.onCommentChanged(j, j2, comment);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$2(MatrixQuestionViewModel matrixQuestionViewModel, long j, boolean z) {
        matrixQuestionViewModel.onExpandedChanged(j, z);
        return Unit.INSTANCE;
    }
}

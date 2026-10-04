package com.survicate.surveys.presentation.page.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: QuestionViewHolder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0082\u0001\f\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/viewholder/QuestionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "providesOwnHorizontalPadding", "", "getProvidesOwnHorizontalPadding", "()Z", "bind", "", "viewModel", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "unbind", "Lcom/survicate/surveys/presentation/page/viewholder/CsatViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/CtaViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/DateViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/FormViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/MatrixViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/MultipleViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/NpsViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/NumericalViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/ShapeViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/SingleViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/SmileyScaleViewHolder;", "Lcom/survicate/surveys/presentation/page/viewholder/TextViewHolder;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public abstract class QuestionViewHolder extends RecyclerView.ViewHolder {
    private final boolean providesOwnHorizontalPadding;

    public /* synthetic */ QuestionViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }

    public abstract void bind(QuestionViewModel viewModel);

    public void unbind() {
    }

    private QuestionViewHolder(View view) {
        super(view);
    }

    public boolean getProvidesOwnHorizontalPadding() {
        return this.providesOwnHorizontalPadding;
    }
}

package com.survicate.surveys.presentation.page.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import com.survicate.surveys.presentation.widget.MicroDisclaimerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisclaimerViewHolder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/viewholder/DisclaimerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "disclaimerView", "Lcom/survicate/surveys/presentation/widget/MicroDisclaimerView;", "<init>", "(Lcom/survicate/surveys/presentation/widget/MicroDisclaimerView;)V", "getDisclaimerView", "()Lcom/survicate/surveys/presentation/widget/MicroDisclaimerView;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisclaimerViewHolder extends RecyclerView.ViewHolder {
    private final MicroDisclaimerView disclaimerView;

    public final MicroDisclaimerView getDisclaimerView() {
        return this.disclaimerView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisclaimerViewHolder(MicroDisclaimerView disclaimerView) {
        super(disclaimerView);
        Intrinsics.checkNotNullParameter(disclaimerView, "disclaimerView");
        this.disclaimerView = disclaimerView;
    }
}

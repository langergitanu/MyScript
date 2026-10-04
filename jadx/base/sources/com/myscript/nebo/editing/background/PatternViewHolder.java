package com.myscript.nebo.editing.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.note.p030ui.PageBackgroundPattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackgroundPatternListAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0\u000fJ\u0006\u0010\u0011\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/editing/background/PatternViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "patternView", "Lcom/google/android/material/card/MaterialCardView;", "illustrationView", "Landroid/widget/ImageView;", "bind", "", "state", "Lcom/myscript/nebo/note/ui/PageBackgroundPattern;", "onPatternSelected", "Lkotlin/Function1;", "Lcom/myscript/atk/core/BackgroundPattern;", "unbind", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PatternViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final ImageView illustrationView;
    private final MaterialCardView patternView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PatternViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(C6079R.layout.background_pattern_pill_view, parent, false));
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewFindViewById = this.itemView.findViewById(C6079R.id.page_pattern_card);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.patternView = (MaterialCardView) viewFindViewById;
        View viewFindViewById2 = this.itemView.findViewById(C6079R.id.page_pattern_illustration);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.illustrationView = (ImageView) viewFindViewById2;
    }

    public final void bind(final PageBackgroundPattern state, final Function1<? super BackgroundPattern, Unit> onPatternSelected) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onPatternSelected, "onPatternSelected");
        this.illustrationView.setImageDrawable(ContextCompat.getDrawable(this.patternView.getContext(), state.getAssetRes()));
        this.patternView.setChecked(state.isSelected());
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.background.PatternViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PatternViewHolder.bind$lambda$0(onPatternSelected, state, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0(Function1 function1, PageBackgroundPattern pageBackgroundPattern, View view) {
        function1.invoke(pageBackgroundPattern.getPattern());
    }

    public final void unbind() {
        this.itemView.setOnClickListener(null);
    }
}

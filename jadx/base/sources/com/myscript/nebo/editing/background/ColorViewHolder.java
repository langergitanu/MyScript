package com.myscript.nebo.editing.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.note.p030ui.PageBackgroundColor;
import com.myscript.nebo.penpanel.ColorPillView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackgroundColorListAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\rJ\u0006\u0010\u000e\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/editing/background/ColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "colorView", "Lcom/myscript/nebo/penpanel/ColorPillView;", "bind", "", "state", "Lcom/myscript/nebo/note/ui/PageBackgroundColor;", "onColorSelected", "Lkotlin/Function1;", "unbind", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ColorViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final ColorPillView colorView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(C6079R.layout.background_color_pill_view, parent, false));
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewFindViewById = this.itemView.findViewById(C6079R.id.color_pill_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.colorView = (ColorPillView) viewFindViewById;
    }

    public final void bind(final PageBackgroundColor state, final Function1<? super PageBackgroundColor, Unit> onColorSelected) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onColorSelected, "onColorSelected");
        this.colorView.setTint(state.getColor2());
        this.colorView.setChecked(state.isSelected());
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.background.ColorViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onColorSelected.invoke(state);
            }
        });
    }

    public final void unbind() {
        this.itemView.setOnClickListener(null);
    }
}

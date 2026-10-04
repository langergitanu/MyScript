package com.myscript.nebo.penpanel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorListAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\u0011j\u0002`\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0006\u0010\u0016\u001a\u00020\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ColorPillViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "colorPill", "Lcom/myscript/nebo/penpanel/ColorPill;", "getColorPill", "()Lcom/myscript/nebo/penpanel/ColorPill;", "setColorPill", "(Lcom/myscript/nebo/penpanel/ColorPill;)V", "colorPillView", "Lcom/myscript/nebo/penpanel/ColorPillView;", "bind", "", "callback", "Lkotlin/Function1;", "Lcom/myscript/nebo/penpanel/ColorPillCallback;", "payloads", "", "", "unbind", "Companion", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ColorPillViewHolder extends RecyclerView.ViewHolder {
    public static final String SELECTED_STATE_UPDATE = "SELECTED_STATE_UPDATE";
    private ColorPill colorPill;
    private final ColorPillView colorPillView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorPillViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(C6693R.layout.color_pill_view, parent, false));
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewFindViewById = this.itemView.findViewById(C6693R.id.color_pill_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.colorPillView = (ColorPillView) viewFindViewById;
    }

    public final ColorPill getColorPill() {
        return this.colorPill;
    }

    public final void setColorPill(ColorPill colorPill) {
        this.colorPill = colorPill;
    }

    public final void bind(ColorPill colorPill, final Function1<? super ColorPillViewHolder, Unit> callback, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(colorPill, "colorPill");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.colorPill = colorPill;
        List<Object> list = payloads;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(it.next(), SELECTED_STATE_UPDATE)) {
                    z = true;
                    break;
                }
            }
        }
        ColorPillView colorPillView = this.colorPillView;
        if (!z) {
            colorPillView.setTint(colorPill.getDisplayedColor());
        }
        colorPillView.setChecked(colorPill.isSelected(), z);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.penpanel.ColorPillViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                callback.invoke(this);
            }
        });
    }

    public final void unbind() {
        this.colorPill = null;
        this.itemView.setOnClickListener(null);
    }
}

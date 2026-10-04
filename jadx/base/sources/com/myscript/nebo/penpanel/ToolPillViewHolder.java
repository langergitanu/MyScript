package com.myscript.nebo.penpanel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.myscript.snt.core.ToolConfiguration;
import com.myscript.snt.core.ToolState;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToolListAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J:\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\rj\u0002`\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolPillViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "toolPillView", "Lcom/myscript/nebo/penpanel/ToolPillView;", "bind", "", "toolPill", "Lcom/myscript/nebo/penpanel/ToolPill;", "callback", "Lkotlin/Function2;", "Lcom/myscript/snt/core/ToolConfiguration;", "Lcom/myscript/nebo/penpanel/ToolPillCallback;", "payloads", "", "", "unbind", "Companion", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ToolPillViewHolder extends RecyclerView.ViewHolder {
    public static final String COLOR_UPDATE_PAYLOAD = "COLOR_UPDATE_PAYLOAD";
    private final ToolPillView toolPillView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolPillViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(C6693R.layout.tool_pill_view, parent, false));
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewFindViewById = this.itemView.findViewById(C6693R.id.tool_pill_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.toolPillView = (ToolPillView) viewFindViewById;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bind(ToolPill toolPill, final Function2<? super ToolConfiguration, ? super ToolPillView, Unit> callback, List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(toolPill, "toolPill");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        final ToolConfiguration toolConfiguration = toolPill.getToolConfiguration();
        ToolPillView toolPillView = this.toolPillView;
        List<? extends Object> list = payloads;
        if ((list instanceof Collection) && list.isEmpty()) {
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Drawable drawableAsDrawable = ToolConfigurationUIKt.asDrawable(toolConfiguration, context);
            toolPillView.setImageDrawable(drawableAsDrawable);
            toolPillView.setVisibility(!(drawableAsDrawable == null) ? 0 : 8);
            toolPillView.setPaused(toolConfiguration.getState() != ToolState.Paused);
            toolPillView.setSelected(toolConfiguration.getState() != ToolState.Unselected);
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next(), COLOR_UPDATE_PAYLOAD)) {
                    break;
                }
            }
            Context context2 = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            Drawable drawableAsDrawable2 = ToolConfigurationUIKt.asDrawable(toolConfiguration, context2);
            toolPillView.setImageDrawable(drawableAsDrawable2);
            toolPillView.setVisibility(!(drawableAsDrawable2 == null) ? 0 : 8);
            toolPillView.setPaused(toolConfiguration.getState() != ToolState.Paused);
            toolPillView.setSelected(toolConfiguration.getState() != ToolState.Unselected);
        }
        toolPillView.setTint(toolPill.getDisplayedColor());
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.penpanel.ToolPillViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToolPillViewHolder.bind$lambda$1(callback, toolConfiguration, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1(Function2 function2, ToolConfiguration toolConfiguration, ToolPillViewHolder toolPillViewHolder, View view) {
        function2.invoke(toolConfiguration, toolPillViewHolder.toolPillView);
    }

    public final void unbind() {
        this.itemView.setOnClickListener(null);
    }
}

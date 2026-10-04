package com.myscript.nebo.inspector;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NeboFilesAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/inspector/NeboFileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "fileLabelView", "Landroid/widget/TextView;", "bind", "", "neboFile", "Lcom/myscript/nebo/inspector/NeboFile;", "unbind", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboFileViewHolder extends RecyclerView.ViewHolder {
    private final TextView fileLabelView;

    public final void unbind() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NeboFileViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(C6609R.layout.inspector_nebo_file, parent, false));
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewFindViewById = this.itemView.findViewById(C6609R.id.inspector_nebo_file_label);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.fileLabelView = (TextView) viewFindViewById;
    }

    public final void bind(NeboFile neboFile) {
        Intrinsics.checkNotNullParameter(neboFile, "neboFile");
        this.fileLabelView.setText(neboFile.getLabel());
    }
}

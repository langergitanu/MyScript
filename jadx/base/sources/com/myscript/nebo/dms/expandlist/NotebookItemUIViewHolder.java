package com.myscript.nebo.dms.expandlist;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.myscript.nebo.analytics.firebase.AIQuizConstants;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.core.model.SelectionState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DmsSimpleAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006JJ\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u0014J\u0006\u0010\u0018\u001a\u00020\u0011R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \t*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/dms/expandlist/NotebookItemUIViewHolder;", "Lcom/bignerdranch/expandablerecyclerview/ChildViewHolder;", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "coverIcon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "coverSelectionBackground", "nameLabel", "Landroid/widget/TextView;", "selectionBackground", "Landroid/view/View;", "detailsLabel", "bind", "", AIQuizConstants.NOTEBOOK, "onNotebookClicked", "Lkotlin/Function1;", "onNotebookCoverClicked", "onNotebookLongClicked", "", "unbind", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NotebookItemUIViewHolder extends ChildViewHolder<FolderModel> {
    public static final int $stable = 8;
    private final ImageView coverIcon;
    private final ImageView coverSelectionBackground;
    private final TextView detailsLabel;
    private final TextView nameLabel;
    private final View selectionBackground;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotebookItemUIViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(C6208R.layout.dms_notebook_item, parent, false));
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.coverIcon = (ImageView) this.itemView.findViewById(C6208R.id.dms_notebook_cover);
        this.coverSelectionBackground = (ImageView) this.itemView.findViewById(C6208R.id.dms_notebook_cover_selection_mode);
        this.nameLabel = (TextView) this.itemView.findViewById(C6208R.id.dms_notebook_name);
        this.selectionBackground = this.itemView.findViewById(C6208R.id.selected_background_color);
        this.detailsLabel = (TextView) this.itemView.findViewById(C6208R.id.dms_notebook_details);
    }

    public final void bind(final FolderModel notebook, final Function1<? super FolderModel, Unit> onNotebookClicked, final Function1<? super FolderModel, Unit> onNotebookCoverClicked, final Function1<? super FolderModel, Boolean> onNotebookLongClicked) {
        Intrinsics.checkNotNullParameter(notebook, "notebook");
        Intrinsics.checkNotNullParameter(onNotebookClicked, "onNotebookClicked");
        Intrinsics.checkNotNullParameter(onNotebookCoverClicked, "onNotebookCoverClicked");
        Intrinsics.checkNotNullParameter(onNotebookLongClicked, "onNotebookLongClicked");
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        FolderUI folderUI = new FolderUI(context, notebook, null, false, false, 28, null);
        this.coverIcon.setImageResource(folderUI.getCoverIconRes());
        this.coverIcon.setColorFilter(folderUI.getCoverColor(), PorterDuff.Mode.SRC_IN);
        ImageView coverIcon = this.coverIcon;
        Intrinsics.checkNotNullExpressionValue(coverIcon, "coverIcon");
        coverIcon.setVisibility(folderUI.isCoverVisible() ? 0 : 8);
        this.coverSelectionBackground.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.expandlist.NotebookItemUIViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onNotebookCoverClicked.invoke(notebook);
            }
        });
        this.coverSelectionBackground.setImageResource(folderUI.getCoverBackgroundRes());
        this.selectionBackground.setSelected(notebook.getSelectionState() == SelectionState.SELECTED);
        this.nameLabel.setText(notebook.getName());
        TextView detailsLabel = this.detailsLabel;
        Intrinsics.checkNotNullExpressionValue(detailsLabel, "detailsLabel");
        detailsLabel.setVisibility(folderUI.isTrashedPagesCountVisible() ? 0 : 8);
        this.detailsLabel.setText(String.valueOf(folderUI.getTrashedPagesCount()));
        this.itemView.setActivated(notebook.isOpened());
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.expandlist.NotebookItemUIViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onNotebookClicked.invoke(notebook);
            }
        });
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.myscript.nebo.dms.expandlist.NotebookItemUIViewHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return NotebookItemUIViewHolder.bind$lambda$2(onNotebookLongClicked, notebook, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$2(Function1 function1, FolderModel folderModel, View view) {
        return ((Boolean) function1.invoke(folderModel)).booleanValue();
    }

    public final void unbind() {
        this.itemView.setOnClickListener(null);
        this.coverSelectionBackground.setOnClickListener(null);
    }
}

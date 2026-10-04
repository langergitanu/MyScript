package com.myscript.nebo.languagemanager.presentation;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.myscript.android.utils.ViewExt;
import com.myscript.nebo.languagemanager.C6611R;
import com.myscript.nebo.languagemanager.databinding.ItemLanguageBinding;
import com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\"\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0006\u0010\u0013\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/LanguageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/myscript/nebo/languagemanager/databinding/ItemLanguageBinding;", "<init>", "(Lcom/myscript/nebo/languagemanager/databinding/ItemLanguageBinding;)V", "bind", "", "lang", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem$Lang;", "callback", "Lcom/myscript/nebo/languagemanager/presentation/Callback;", "getDownloadProgressSummary", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "max", "", "progress", "unbind", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguageViewHolder extends RecyclerView.ViewHolder {
    private final ItemLanguageBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LanguageViewHolder(ItemLanguageBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void bind(final LanguageManagerItem.Lang lang, final Callback callback) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.binding.txtTitle.setText(lang.getLabel());
        this.binding.imgDownload.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LanguageViewHolder.bind$lambda$0(callback, lang, view);
            }
        });
        this.binding.imgRemove.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LanguageViewHolder.bind$lambda$1(callback, lang, view);
            }
        });
        this.binding.imgCancel.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageViewHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LanguageViewHolder.bind$lambda$2(callback, lang, view);
            }
        });
        this.binding.imgUpdate.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageViewHolder$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LanguageViewHolder.bind$lambda$3(callback, lang, view);
            }
        });
        ImageView imgCancel = this.binding.imgCancel;
        Intrinsics.checkNotNullExpressionValue(imgCancel, "imgCancel");
        imgCancel.setVisibility(lang.isDownloadOnGoing() ? 0 : 8);
        LinearLayout progressGroup = this.binding.progressGroup;
        Intrinsics.checkNotNullExpressionValue(progressGroup, "progressGroup");
        progressGroup.setVisibility(lang.isDownloadOnGoing() ? 0 : 8);
        TextView txtDownloadingSummary = this.binding.txtDownloadingSummary;
        Intrinsics.checkNotNullExpressionValue(txtDownloadingSummary, "txtDownloadingSummary");
        txtDownloadingSummary.setVisibility(lang.isDownloadOnGoing() ? 0 : 8);
        ImageView imgUpdate = this.binding.imgUpdate;
        Intrinsics.checkNotNullExpressionValue(imgUpdate, "imgUpdate");
        imgUpdate.setVisibility(!lang.isUpToDate() ? 0 : 8);
        ImageView imgRemove = this.binding.imgRemove;
        Intrinsics.checkNotNullExpressionValue(imgRemove, "imgRemove");
        imgRemove.setVisibility(lang.isRemoveVisible() ? 0 : 8);
        this.binding.imgRemove.setEnabled(lang.isRemovable());
        ImageView imgDownload = this.binding.imgDownload;
        Intrinsics.checkNotNullExpressionValue(imgDownload, "imgDownload");
        imgDownload.setVisibility(lang.isDownloadVisible() ? 0 : 8);
        this.binding.imgDownload.setEnabled(lang.isDownloadable());
        if (lang.isDownloadOnGoing()) {
            int max = lang.getMax();
            int progress = lang.getProgress();
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.binding.txtDownloadingSummary.setText(getDownloadProgressSummary(context, max, progress));
            this.binding.progressBar.setIndeterminate(false);
            this.binding.progressBar.setMax(max);
            ProgressBar progressBar = this.binding.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
            ViewExt.animateProgress(progressBar, progress);
        }
        if (lang.getPending()) {
            TextView txtDownloadingSummary2 = this.binding.txtDownloadingSummary;
            Intrinsics.checkNotNullExpressionValue(txtDownloadingSummary2, "txtDownloadingSummary");
            txtDownloadingSummary2.setVisibility(0);
            LinearLayout progressGroup2 = this.binding.progressGroup;
            Intrinsics.checkNotNullExpressionValue(progressGroup2, "progressGroup");
            progressGroup2.setVisibility(0);
            this.binding.progressBar.setIndeterminate(true);
            this.binding.txtDownloadingSummary.setText(this.itemView.getContext().getString(C6611R.string.resourcemanager_download_enqueued));
            ImageView imgRemove2 = this.binding.imgRemove;
            Intrinsics.checkNotNullExpressionValue(imgRemove2, "imgRemove");
            imgRemove2.setVisibility(8);
            ImageView imgDownload2 = this.binding.imgDownload;
            Intrinsics.checkNotNullExpressionValue(imgDownload2, "imgDownload");
            imgDownload2.setVisibility(8);
        }
        this.binding.viewLanguageItem.setSelected(lang.isSelected());
        ImageView imgCheck = this.binding.imgCheck;
        Intrinsics.checkNotNullExpressionValue(imgCheck, "imgCheck");
        imgCheck.setVisibility(lang.isSelected() && lang.getInstalled() ? 0 : 8);
        this.binding.viewLanguageItem.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.languagemanager.presentation.LanguageViewHolder$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LanguageViewHolder.bind$lambda$4(callback, lang, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0(Callback callback, LanguageManagerItem.Lang lang, View view) {
        callback.onLanguageDownloadRequested(lang.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1(Callback callback, LanguageManagerItem.Lang lang, View view) {
        callback.onRemoveLanguageRequest(lang.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$2(Callback callback, LanguageManagerItem.Lang lang, View view) {
        callback.onCancelLanguageDownloadRequest(lang.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$3(Callback callback, LanguageManagerItem.Lang lang, View view) {
        callback.onLanguageDownloadRequested(lang.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$4(Callback callback, LanguageManagerItem.Lang lang, View view) {
        callback.onLanguageClicked(lang.getKey());
    }

    private final String getDownloadProgressSummary(Context context, int max, int progress) {
        DecimalFormat decimalFormat = new DecimalFormat(IdManager.DEFAULT_VERSION_NAME);
        return context.getString(C6611R.string.resourcemanager_download_summary, decimalFormat.format(progress / 1048576.0f), decimalFormat.format(max / 1048576.0f));
    }

    public final void unbind() {
        this.binding.imgDownload.setOnClickListener(null);
        this.binding.imgRemove.setOnClickListener(null);
        this.binding.imgCancel.setOnClickListener(null);
        this.binding.imgUpdate.setOnClickListener(null);
        this.binding.viewLanguageItem.setOnClickListener(null);
    }
}

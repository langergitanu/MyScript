package com.myscript.nebo.whatsnew;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.os.BundleCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.button.MaterialButton;
import com.myscript.android.utils.DialogFragmentExt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.databinding.FancyWhatsNewDialogLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FancyWhatsNewDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/FancyWhatsNewDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "data", "Lcom/myscript/nebo/whatsnew/FancyWhatsNewData;", "ctaTriggered", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onCreateDialog", "Landroid/app/Dialog;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FancyWhatsNewDialog extends DialogFragment {
    private static final String DATA_KEY = "DATA_KEY";
    public static final String REQUEST_KEY = "FancyWhatsNewDialog_REQUEST_KEY";
    public static final String RESULT_KEY = "RESULT_KEY";
    public static final String TAG = "FancyWhatsNewDialog";
    private boolean ctaTriggered;
    private FancyWhatsNewData data;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final FancyWhatsNewDialog newInstance(FancyWhatsNewData fancyWhatsNewData) {
        return INSTANCE.newInstance(fancyWhatsNewData);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FancyWhatsNewData fancyWhatsNewData = (FancyWhatsNewData) BundleCompat.getParcelable(requireArguments(), DATA_KEY, FancyWhatsNewData.class);
        if (fancyWhatsNewData == null) {
            throw new IllegalStateException("Missing data".toString());
        }
        this.data = fancyWhatsNewData;
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return C6079R.style.Theme_FancyWhatsNew_Dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FancyWhatsNewDialogLayoutBinding fancyWhatsNewDialogLayoutBindingInflate = FancyWhatsNewDialogLayoutBinding.inflate(inflater, container, false);
        fancyWhatsNewDialogLayoutBindingInflate.fancyWhatsNewToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.myscript.nebo.whatsnew.FancyWhatsNewDialog$$ExternalSyntheticLambda0
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return FancyWhatsNewDialog.onCreateView$lambda$0$0(this.f$0, menuItem);
            }
        });
        TextView textView = fancyWhatsNewDialogLayoutBindingInflate.fancyWhatsNewTitle;
        FancyWhatsNewData fancyWhatsNewData = this.data;
        FancyWhatsNewData fancyWhatsNewData2 = null;
        if (fancyWhatsNewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            fancyWhatsNewData = null;
        }
        textView.setText(fancyWhatsNewData.getTitleRes());
        TextView textView2 = fancyWhatsNewDialogLayoutBindingInflate.fancyWhatsNewMessage;
        FancyWhatsNewData fancyWhatsNewData3 = this.data;
        if (fancyWhatsNewData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            fancyWhatsNewData3 = null;
        }
        textView2.setText(fancyWhatsNewData3.getMessageRes());
        ImageView imageView = fancyWhatsNewDialogLayoutBindingInflate.fancyWhatsNewIllustration;
        FancyWhatsNewData fancyWhatsNewData4 = this.data;
        if (fancyWhatsNewData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            fancyWhatsNewData4 = null;
        }
        imageView.setImageResource(fancyWhatsNewData4.getIllustrationRes());
        MaterialButton materialButton = fancyWhatsNewDialogLayoutBindingInflate.fancyWhatsNewCta;
        FancyWhatsNewData fancyWhatsNewData5 = this.data;
        if (fancyWhatsNewData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        } else {
            fancyWhatsNewData2 = fancyWhatsNewData5;
        }
        materialButton.setText(fancyWhatsNewData2.getCtaLabelRes());
        fancyWhatsNewDialogLayoutBindingInflate.fancyWhatsNewCta.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.whatsnew.FancyWhatsNewDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FancyWhatsNewDialog.onCreateView$lambda$0$1(this.f$0, view);
            }
        });
        FrameLayout root = fancyWhatsNewDialogLayoutBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$0$0(FancyWhatsNewDialog fancyWhatsNewDialog, MenuItem menuItem) {
        if (menuItem.getItemId() != C6079R.id.whats_new_dialog_close) {
            return true;
        }
        fancyWhatsNewDialog.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0$1(FancyWhatsNewDialog fancyWhatsNewDialog, View view) {
        fancyWhatsNewDialog.ctaTriggered = true;
        fancyWhatsNewDialog.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "apply(...)");
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Bundle bundle = new Bundle();
        if (this.ctaTriggered) {
            FancyWhatsNewData fancyWhatsNewData = this.data;
            if (fancyWhatsNewData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
                fancyWhatsNewData = null;
            }
            bundle.putString("RESULT_KEY", fancyWhatsNewData.getTag());
        }
        FragmentKt.setFragmentResult(this, REQUEST_KEY, bundle);
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        DialogFragmentExt.showAtMostOnce(this, manager, TAG);
    }

    /* JADX INFO: compiled from: FancyWhatsNewDialog.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/FancyWhatsNewDialog$Companion;", "", "<init>", "()V", "TAG", "", FancyWhatsNewDialog.DATA_KEY, "REQUEST_KEY", "RESULT_KEY", "newInstance", "Lcom/myscript/nebo/whatsnew/FancyWhatsNewDialog;", "data", "Lcom/myscript/nebo/whatsnew/FancyWhatsNewData;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FancyWhatsNewDialog newInstance(FancyWhatsNewData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            FancyWhatsNewDialog fancyWhatsNewDialog = new FancyWhatsNewDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(FancyWhatsNewDialog.DATA_KEY, data);
            fancyWhatsNewDialog.setArguments(bundle);
            return fancyWhatsNewDialog;
        }
    }
}

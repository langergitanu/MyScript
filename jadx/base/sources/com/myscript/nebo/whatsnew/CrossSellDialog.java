package com.myscript.nebo.whatsnew;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.android.utils.DialogFragmentExt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.common.utils.PlatformUtils;
import com.myscript.nebo.databinding.CrossSellDialogLayoutBinding;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CrossSellDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/CrossSellDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "origin", "", "getOrigin", "()Ljava/lang/String;", "choiceLogged", "", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "logChoice", "selected", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CrossSellDialog extends DialogFragment {
    private static final String ARG_ORIGIN = "origin";
    public static final int CROSS_SELL_NUMBER = 2;
    private static final String SELECTED_DOWNLOAD = "download";
    private static final String SELECTED_LATER = "later";
    public static final String TAG = "CrossSellDialog";
    private boolean choiceLogged;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final CrossSellDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    private final String getOrigin() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("origin") : null;
        return string == null ? "" : string;
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return C6079R.style.Theme_FancyWhatsNew_Dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(CrossSellDialog crossSellDialog, Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("origin", crossSellDialog.getOrigin());
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (savedInstanceState == null) {
            NeboFirebaseEvent.CrossSellDisplay.log(new Function1() { // from class: com.myscript.nebo.whatsnew.CrossSellDialog$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CrossSellDialog.onCreateView$lambda$0(this.f$0, (Bundle) obj);
                }
            });
        }
        CrossSellDialogLayoutBinding crossSellDialogLayoutBindingInflate = CrossSellDialogLayoutBinding.inflate(inflater, container, false);
        crossSellDialogLayoutBindingInflate.crossSellToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.myscript.nebo.whatsnew.CrossSellDialog$$ExternalSyntheticLambda1
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return CrossSellDialog.onCreateView$lambda$1$0(this.f$0, menuItem);
            }
        });
        crossSellDialogLayoutBindingInflate.crossSellTitle.setText(C6079R.string.cross_sell_dialog_title2);
        crossSellDialogLayoutBindingInflate.crossSellMessage.setText(C6079R.string.cross_sell_dialog_message);
        crossSellDialogLayoutBindingInflate.crossSellIllustration.setImageResource(C6079R.drawable.cross_sell_illustration);
        crossSellDialogLayoutBindingInflate.crossSellCta.setText(C6079R.string.cross_sell_dialog_cta);
        crossSellDialogLayoutBindingInflate.crossSellCta.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.whatsnew.CrossSellDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CrossSellDialog.onCreateView$lambda$1$1(this.f$0, view);
            }
        });
        FrameLayout root = crossSellDialogLayoutBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$1$0(CrossSellDialog crossSellDialog, MenuItem menuItem) {
        if (menuItem.getItemId() != C6079R.id.whats_new_dialog_close) {
            return true;
        }
        crossSellDialog.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$1(CrossSellDialog crossSellDialog, View view) {
        crossSellDialog.logChoice(SELECTED_DOWNLOAD);
        try {
            String string = crossSellDialog.getString(C6079R.string.cross_sell_math_url);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(string));
            intent.addFlags(268435456);
            crossSellDialog.requireActivity().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            FragmentActivity fragmentActivityRequireActivity = crossSellDialog.requireActivity();
            String playStoreURL = PlatformUtils.getPlayStoreURL("com.myscript.math");
            Intrinsics.checkNotNullExpressionValue(playStoreURL, "getPlayStoreURL(...)");
            fragmentActivityRequireActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(playStoreURL)));
        }
        crossSellDialog.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "apply(...)");
        return dialogOnCreateDialog;
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        DialogFragmentExt.showAtMostOnce(this, manager, TAG);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        FragmentActivity activity = getActivity();
        if (activity == null || !activity.isChangingConfigurations()) {
            logChoice(SELECTED_LATER);
        }
    }

    private final void logChoice(final String selected) {
        if (this.choiceLogged) {
            return;
        }
        this.choiceLogged = true;
        NeboFirebaseEvent.CrossSellChoice.log(new Function1() { // from class: com.myscript.nebo.whatsnew.CrossSellDialog$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CrossSellDialog.logChoice$lambda$0(this.f$0, selected, (Bundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit logChoice$lambda$0(CrossSellDialog crossSellDialog, String str, Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("origin", crossSellDialog.getOrigin());
        log.putString("selected", str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: CrossSellDialog.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/CrossSellDialog$Companion;", "", "<init>", "()V", "TAG", "", "CROSS_SELL_NUMBER", "", "ARG_ORIGIN", "SELECTED_LATER", "SELECTED_DOWNLOAD", "newInstance", "Lcom/myscript/nebo/whatsnew/CrossSellDialog;", "origin", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CrossSellDialog newInstance(String origin) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            CrossSellDialog crossSellDialog = new CrossSellDialog();
            crossSellDialog.setArguments(BundleKt.bundleOf(TuplesKt.m1606to("origin", origin)));
            return crossSellDialog;
        }
    }
}

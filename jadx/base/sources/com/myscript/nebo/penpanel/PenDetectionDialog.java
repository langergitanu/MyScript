package com.myscript.nebo.penpanel;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.android.utils.C6014R;
import com.myscript.android.utils.ImageViewExtKt;
import com.myscript.android.utils.ViewExt;
import com.myscript.nebo.penpanel.InkTestView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PenDetectionDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\"\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0018H\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J\b\u0010)\u001a\u00020\u0016H\u0016J\u0012\u0010*\u001a\u00020\u00162\b\b\u0002\u0010+\u001a\u00020\fH\u0002J\b\u0010,\u001a\u00020\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006/"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/PenDetectionDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "penDetectionWriteHereLabel", "Landroid/view/View;", "penDetectionDoneCheck", "Landroid/widget/ImageView;", "penDetectionArea", "Lcom/myscript/nebo/penpanel/InkTestView;", "negativeButton", "isModal", "", "penDetected", "skipped", "callback", "Lcom/myscript/nebo/penpanel/PenDetectionDialog$Callback;", "getCallback", "()Lcom/myscript/nebo/penpanel/PenDetectionDialog$Callback;", "setCallback", "(Lcom/myscript/nebo/penpanel/PenDetectionDialog$Callback;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onCreateDialog", "Landroid/app/Dialog;", "onActivityCreated", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onSaveInstanceState", "outState", "onDestroyView", "onDestroy", "onPenDetected", "animate", "dismiss", "Callback", "Companion", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PenDetectionDialog extends DialogFragment {
    private static final long AUTOMATIC_DISMISS_DELAY = 800;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String IS_MODAL_KEY = "IS_MODAL_KEY";
    private static final String PEN_DETECTED_KEY = "PEN_DETECTED_KEY";
    public static final String TAG = "PenDetectionDialog";
    private Callback callback;
    private boolean isModal = true;
    private View negativeButton;
    private boolean penDetected;
    private InkTestView penDetectionArea;
    private ImageView penDetectionDoneCheck;
    private View penDetectionWriteHereLabel;
    private boolean skipped;

    /* JADX INFO: compiled from: PenDetectionDialog.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/PenDetectionDialog$Callback;", "", "onPenDetectionClosed", "", "penDetected", "", "aborted", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        void onPenDetectionClosed(boolean penDetected, boolean aborted);
    }

    @JvmStatic
    public static final PenDetectionDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @JvmStatic
    public static final PenDetectionDialog newInstance(boolean z) {
        return INSTANCE.newInstance(z);
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (savedInstanceState != null) {
            this.isModal = savedInstanceState.getBoolean(IS_MODAL_KEY, this.isModal);
        } else if (arguments != null) {
            this.isModal = arguments.getBoolean(IS_MODAL_KEY);
        }
        setStyle(0, getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return C6014R.style.AutoSize_Dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        View viewInflate = LayoutInflater.from(requireActivity()).inflate(C6693R.layout.pen_detection_dialog, container, false);
        ImageView imageView = null;
        if (viewInflate == null) {
            return null;
        }
        View viewFindViewById = viewInflate.findViewById(C6693R.id.pen_detection_panel_user_input);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(this.penDetected ? 8 : 0);
        } else {
            viewFindViewById = null;
        }
        this.penDetectionWriteHereLabel = viewFindViewById;
        ImageView imageView2 = (ImageView) viewInflate.findViewById(C6693R.id.pen_detection_panel_done);
        if (imageView2 != null) {
            imageView2.setVisibility(this.penDetected ? 0 : 8);
            imageView = imageView2;
        }
        this.penDetectionDoneCheck = imageView;
        InkTestView inkTestView = (InkTestView) viewInflate.findViewById(C6693R.id.pen_detection_area);
        inkTestView.setCapacitiveInputAllowed(false);
        this.penDetectionArea = inkTestView;
        this.negativeButton = viewInflate.findViewById(C6693R.id.pen_detection_dialog_negative_button);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setTitle(C6693R.string.pen_detection_dialog_title);
        dialogOnCreateDialog.setCanceledOnTouchOutside(!this.isModal);
        dialogOnCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.myscript.nebo.penpanel.PenDetectionDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return PenDetectionDialog.onCreateDialog$lambda$0$0(this.f$0, dialogOnCreateDialog, dialogInterface, i, keyEvent);
            }
        });
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "apply(...)");
        return dialogOnCreateDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateDialog$lambda$0$0(PenDetectionDialog penDetectionDialog, Dialog dialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (!penDetectionDialog.isModal || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        dialog.dismiss();
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InkTestView inkTestView = this.penDetectionArea;
        if (inkTestView != null) {
            inkTestView.setOnPenDetectedListener(new InkTestView.OnPenDetectedListener() { // from class: com.myscript.nebo.penpanel.PenDetectionDialog$$ExternalSyntheticLambda2
                @Override // com.myscript.nebo.penpanel.InkTestView.OnPenDetectedListener
                public final void onPenDetected() {
                    PenDetectionDialog.onActivityCreated$lambda$0(this.f$0);
                }
            });
        }
        View view = this.negativeButton;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.penpanel.PenDetectionDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PenDetectionDialog.onActivityCreated$lambda$1(this.f$0, view2);
                }
            });
        }
        boolean z = savedInstanceState != null ? savedInstanceState.getBoolean(PEN_DETECTED_KEY) : false;
        this.penDetected = z;
        if (z) {
            onPenDetected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityCreated$lambda$0(PenDetectionDialog penDetectionDialog) {
        InkTestView inkTestView = penDetectionDialog.penDetectionArea;
        if (inkTestView != null) {
            inkTestView.setOnPenDetectedListener(null);
        }
        onPenDetected$default(penDetectionDialog, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityCreated$lambda$1(PenDetectionDialog penDetectionDialog, View view) {
        penDetectionDialog.skipped = true;
        penDetectionDialog.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Callback callback;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        InkTestView inkTestView = this.penDetectionArea;
        if (inkTestView != null) {
            inkTestView.setOnPenDetectedListener(null);
        }
        View view = this.negativeButton;
        if (view != null) {
            view.setOnClickListener(null);
        }
        if (isAdded()) {
            boolean z = (this.penDetected || this.skipped) ? false : true;
            if (requireActivity().isChangingConfigurations() || (callback = this.callback) == null) {
                return;
            }
            callback.onPenDetectionClosed(this.penDetected, z);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putBoolean(PEN_DETECTED_KEY, this.penDetected);
        outState.putBoolean(IS_MODAL_KEY, this.isModal);
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.penDetectionWriteHereLabel = null;
        this.penDetectionDoneCheck = null;
        this.penDetectionArea = null;
        this.negativeButton = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.callback = null;
        super.onDestroy();
    }

    static /* synthetic */ void onPenDetected$default(PenDetectionDialog penDetectionDialog, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        penDetectionDialog.onPenDetected(z);
    }

    private final void onPenDetected(boolean animate) {
        this.penDetected = true;
        long integer = animate ? getResources().getInteger(android.R.integer.config_mediumAnimTime) : 0L;
        InkTestView inkTestView = this.penDetectionArea;
        if (inkTestView != null) {
            inkTestView.reset();
        }
        View view = this.penDetectionWriteHereLabel;
        if (view != null) {
            ViewExt.fadeOut$default(view, integer, 0L, 2, null);
        }
        ImageView imageView = this.penDetectionDoneCheck;
        if (imageView != null) {
            imageView.setVisibility(0);
            ImageViewExtKt.animateDrawable(imageView);
        }
        View view2 = getView();
        if (view2 != null) {
            view2.postDelayed(new Runnable() { // from class: com.myscript.nebo.penpanel.PenDetectionDialog$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.dismiss();
                }
            }, integer + AUTOMATIC_DISMISS_DELAY);
        }
        View view3 = this.negativeButton;
        if (view3 != null) {
            view3.setEnabled(false);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (isAdded()) {
            super.dismiss();
        }
    }

    /* JADX INFO: compiled from: PenDetectionDialog.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/PenDetectionDialog$Companion;", "", "<init>", "()V", "TAG", "", PenDetectionDialog.PEN_DETECTED_KEY, PenDetectionDialog.IS_MODAL_KEY, "AUTOMATIC_DISMISS_DELAY", "", "newInstance", "Lcom/myscript/nebo/penpanel/PenDetectionDialog;", "isModal", "", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PenDetectionDialog newInstance() {
            return newInstance$default(this, false, 1, null);
        }

        private Companion() {
        }

        public static /* synthetic */ PenDetectionDialog newInstance$default(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            return companion.newInstance(z);
        }

        @JvmStatic
        public final PenDetectionDialog newInstance(boolean isModal) {
            PenDetectionDialog penDetectionDialog = new PenDetectionDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(PenDetectionDialog.IS_MODAL_KEY, isModal);
            penDetectionDialog.setArguments(bundle);
            return penDetectionDialog;
        }
    }
}

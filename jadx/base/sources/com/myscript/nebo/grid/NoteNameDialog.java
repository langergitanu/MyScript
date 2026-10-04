package com.myscript.nebo.grid;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;
import com.myscript.snt.core.PageKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: NoteNameDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/grid/NoteNameDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "title", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NoteNameDialog extends DialogFragment {
    public static final String NOTE_NAME_KEY = "NOTE_NAME_KEY";
    public static final String PAGE_KEY_KEY = "PAGE_KEY_KEY";
    public static final String REQUEST_KEY = "NoteNameDialog_KEY";
    public static final String TAG = "NoteNameDialog";
    private String title;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final NoteNameDialog newInstance(PageKey pageKey, String str) {
        return INSTANCE.newInstance(pageKey, str);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String string = requireArguments().getString(NOTE_NAME_KEY, "");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.title = string;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View viewInflate = getLayoutInflater().inflate(C6079R.layout.page_title_dialog, (ViewGroup) null);
        final EditText editText = (EditText) viewInflate.findViewById(C6079R.id.page_title);
        String str = this.title;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            str = null;
        }
        editText.setText(str);
        String str2 = this.title;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            str2 = null;
        }
        editText.setSelection(RangesKt.coerceAtMost(str2.length(), 5000));
        editText.requestFocus();
        AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(requireContext()).setView(viewInflate).setTitle(C6079R.string.note_title_dialog_title).setPositiveButton(C6183R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.grid.NoteNameDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                NoteNameDialog.onCreateDialog$lambda$1(this.f$0, editText, dialogInterface, i);
            }
        }).setNegativeButton(C6183R.string.dialog_cancel, (DialogInterface.OnClickListener) null).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.show();
        final Button button = alertDialogCreate.getButton(-1);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.myscript.nebo.grid.NoteNameDialog$$ExternalSyntheticLambda1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return NoteNameDialog.onCreateDialog$lambda$2(button, textView, i, keyEvent);
            }
        });
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(NoteNameDialog noteNameDialog, EditText editText, DialogInterface dialogInterface, int i) {
        NoteNameDialog noteNameDialog2 = noteNameDialog;
        Bundle bundle = new Bundle();
        Bundle arguments = noteNameDialog.getArguments();
        bundle.putString("PAGE_KEY_KEY", arguments != null ? arguments.getString("PAGE_KEY_KEY") : null);
        bundle.putString(NOTE_NAME_KEY, editText.getText().toString());
        Unit unit = Unit.INSTANCE;
        FragmentKt.setFragmentResult(noteNameDialog2, REQUEST_KEY, bundle);
        noteNameDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateDialog$lambda$2(Button button, TextView textView, int i, KeyEvent keyEvent) {
        if (!button.isEnabled()) {
            return false;
        }
        button.callOnClick();
        return true;
    }

    public final void show(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        show(fragmentManager, TAG);
    }

    /* JADX INFO: compiled from: NoteNameDialog.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/grid/NoteNameDialog$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_KEY_KEY", NoteNameDialog.NOTE_NAME_KEY, "REQUEST_KEY", "newInstance", "Lcom/myscript/nebo/grid/NoteNameDialog;", "pageKey", "Lcom/myscript/snt/core/PageKey;", "name", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NoteNameDialog newInstance(PageKey pageKey, String name) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            Intrinsics.checkNotNullParameter(name, "name");
            NoteNameDialog noteNameDialog = new NoteNameDialog();
            Bundle bundle = new Bundle();
            bundle.putString("PAGE_KEY_KEY", pageKey.serialize());
            bundle.putString(NoteNameDialog.NOTE_NAME_KEY, name);
            noteNameDialog.setArguments(bundle);
            return noteNameDialog;
        }
    }
}

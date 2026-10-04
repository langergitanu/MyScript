package com.myscript.nebo.userdict.p035ui;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import com.myscript.nebo.userdict.C6889R;
import com.myscript.nebo.userdict.p035ui.InputStatus;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UserDictionaryPrompter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m1599d2 = {"promptNewWord", "", "viewModel", "Lcom/myscript/nebo/userdict/ui/UserDictionaryViewModel;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "user-dictionary_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserDictionaryPrompter {
    /* JADX WARN: Type inference failed for: r2v3, types: [com.myscript.nebo.userdict.ui.UserDictionaryPrompter$promptNewWord$watcher$1] */
    public static final void promptNewWord(final UserDictionaryViewModel viewModel, final Context context) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C6889R.layout.user_dictionary_add_word_edit_text_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.google.android.material.textfield.TextInputLayout");
        final TextInputLayout textInputLayout = (TextInputLayout) viewInflate;
        final AlertDialog alertDialogShow = new MaterialAlertDialogBuilder(context).setTitle(C6889R.string.user_dictionary_add_word_dialog_title).setView((View) textInputLayout).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setCancelable(true).show();
        View viewFindViewById = textInputLayout.findViewById(C6889R.id.user_dict_add_word_new);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.EditText");
        final EditText editText = (EditText) viewFindViewById;
        editText.requestFocus();
        final Button button = alertDialogShow.getButton(-1);
        final ?? r2 = new TextWatcher() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryPrompter$promptNewWord$watcher$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                UserDictionaryPrompter.promptNewWord$updateButton$default(viewModel, button, textInputLayout, context, s, false, 32, null);
            }
        };
        promptNewWord$updateButton(viewModel, button, textInputLayout, context, editText.getText(), true);
        editText.addTextChangedListener((TextWatcher) r2);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryPrompter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserDictionaryPrompter.promptNewWord$lambda$0(viewModel, editText, r2, alertDialogShow, view);
            }
        });
    }

    static /* synthetic */ void promptNewWord$updateButton$default(UserDictionaryViewModel userDictionaryViewModel, Button button, TextInputLayout textInputLayout, Context context, Editable editable, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            z = false;
        }
        promptNewWord$updateButton(userDictionaryViewModel, button, textInputLayout, context, editable, z);
    }

    private static final void promptNewWord$updateButton(UserDictionaryViewModel userDictionaryViewModel, Button button, TextInputLayout textInputLayout, Context context, Editable editable, boolean z) {
        InputStatus inputStatusCheckInput = userDictionaryViewModel.checkInput(editable);
        button.setEnabled(Intrinsics.areEqual(inputStatusCheckInput, InputStatus.Valid.INSTANCE));
        String string = null;
        if (z) {
            textInputLayout.setError(null);
            return;
        }
        if (!Intrinsics.areEqual(inputStatusCheckInput, InputStatus.Valid.INSTANCE) && !Intrinsics.areEqual(inputStatusCheckInput, InputStatus.Invalid.IsEmpty.INSTANCE)) {
            if (inputStatusCheckInput instanceof InputStatus.Invalid.TooLong) {
                string = context.getString(C6889R.string.user_dictionary_add_word_dialog_error_too_long);
            } else if (inputStatusCheckInput instanceof InputStatus.Invalid.ContainsWhiteSpace) {
                string = context.getString(C6889R.string.user_dictionary_add_word_dialog_error_contains_whitespace);
            } else if (inputStatusCheckInput instanceof InputStatus.Invalid.ForbiddenChar) {
                InputStatus.Invalid.ForbiddenChar forbiddenChar = (InputStatus.Invalid.ForbiddenChar) inputStatusCheckInput;
                string = context.getResources().getQuantityString(C6889R.plurals.user_dictionary_add_word_dialog_error_contains_forbidden_char, forbiddenChar.getInvalidCharsCount(), forbiddenChar.getInvalidChars());
            } else {
                if (!(inputStatusCheckInput instanceof InputStatus.Invalid.Exists)) {
                    throw new NoWhenBranchMatchedException();
                }
                string = context.getString(C6889R.string.user_dictionary_add_word_dialog_error_existing_label);
            }
        }
        textInputLayout.setError(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void promptNewWord$lambda$0(UserDictionaryViewModel userDictionaryViewModel, EditText editText, UserDictionaryPrompter$promptNewWord$watcher$1 userDictionaryPrompter$promptNewWord$watcher$1, AlertDialog alertDialog, View view) {
        UserDictionaryViewModel.addWord$default(userDictionaryViewModel, new UserDictionaryItem(StringsKt.trim((CharSequence) editText.getText().toString()).toString()), false, 2, null);
        editText.removeTextChangedListener(userDictionaryPrompter$promptNewWord$watcher$1);
        alertDialog.dismiss();
    }
}

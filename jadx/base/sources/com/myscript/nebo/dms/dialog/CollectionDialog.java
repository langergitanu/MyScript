package com.myscript.nebo.dms.dialog;

import android.app.Dialog;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.CollectionPropertiesValidator;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.dialog.DialogSpec;
import com.myscript.snt.core.CollectionKey;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J(\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016J(\u0010\"\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0017H\u0016J\b\u0010(\u001a\u00020\u0015H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/CollectionDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/text/TextWatcher;", "<init>", "()V", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "spec", "Lcom/myscript/nebo/dms/dialog/DialogSpec;", "initialCollectionKey", "Lcom/myscript/snt/core/CollectionKey;", "initialCollectionName", "", "collectionName", "collectionInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "collectionNameField", "Lcom/google/android/material/textfield/TextInputEditText;", "positiveButton", "Landroid/widget/Button;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onDestroyView", "beforeTextChanged", "charSequence", "", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "", "i1", "i2", "onTextChanged", "afterTextChanged", "editable", "Landroid/text/Editable;", "onSaveInstanceState", "outState", "updateUIState", "Companion", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CollectionDialog extends DialogFragment implements TextWatcher {
    public static final String COLLECTION_KEY_KEY = "COLLECTION_KEY_KEY";
    public static final String COLLECTION_NAME_KEY = "COLLECTION_NAME_KEY";
    private static final String REQUEST_KEY = "REQUEST_KEY";
    public static final String REQUEST_KEY_EDIT = "EDIT_COLLECTION_REQUEST_KEY";
    public static final String REQUEST_KEY_NEW = "NEW_COLLECTION_REQUEST_KEY";
    public static final String TAG_EDIT = "TAG_EDIT";
    public static final String TAG_NEW = "TAG_NEW";
    private TextInputLayout collectionInputLayout;
    private TextInputEditText collectionNameField;
    private CollectionKey initialCollectionKey;
    private LibraryRepository libraryRepository;
    private Button positiveButton;
    private DialogSpec spec;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private String initialCollectionName = "";
    private String collectionName = "";

    @JvmStatic
    public static final CollectionDialog newInstance(String str, CollectionKey collectionKey) {
        return INSTANCE.newInstance(str, collectionKey);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "editable");
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        this.libraryRepository = ((LibraryRepository.Provider) application).provideLibraryRepository();
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        String string = bundleRequireArguments.getString(REQUEST_KEY);
        if (string == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        LibraryRepository libraryRepository = null;
        String string2 = "";
        if (Intrinsics.areEqual(string, REQUEST_KEY_EDIT)) {
            this.spec = DialogSpec.Edit.INSTANCE;
            String string3 = bundleRequireArguments.getString(COLLECTION_KEY_KEY);
            if (string3 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            this.initialCollectionKey = CollectionKey.deserialize(string3);
            LibraryRepository libraryRepository2 = this.libraryRepository;
            if (libraryRepository2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
            } else {
                libraryRepository = libraryRepository2;
            }
            CollectionModel collection = libraryRepository.getCollection(this.initialCollectionKey);
            if (collection == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            this.initialCollectionName = collection.getName();
        } else {
            this.spec = DialogSpec.New.INSTANCE;
            this.initialCollectionKey = null;
            this.initialCollectionName = "";
        }
        if (savedInstanceState != null) {
            string2 = savedInstanceState.getString(COLLECTION_NAME_KEY, "");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        } else if (this.initialCollectionKey != null) {
            string2 = this.initialCollectionName;
        }
        this.collectionName = string2;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        TextInputEditText textInputEditText = null;
        View viewInflate = LayoutInflater.from(contextRequireContext).inflate(C6208R.layout.collection_dialog, (ViewGroup) null);
        MaterialAlertDialogBuilder view = new MaterialAlertDialogBuilder(contextRequireContext).setView(viewInflate);
        DialogSpec dialogSpec = this.spec;
        if (dialogSpec == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spec");
            dialogSpec = null;
        }
        MaterialAlertDialogBuilder title = view.setTitle(dialogSpec.getTitle());
        DialogSpec dialogSpec2 = this.spec;
        if (dialogSpec2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spec");
            dialogSpec2 = null;
        }
        MaterialAlertDialogBuilder positiveButton = title.setPositiveButton(dialogSpec2.getPositiveAction(), new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.dms.dialog.CollectionDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CollectionDialog.onCreateDialog$lambda$0(this.f$0, dialogInterface, i);
            }
        });
        DialogSpec dialogSpec3 = this.spec;
        if (dialogSpec3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spec");
            dialogSpec3 = null;
        }
        MaterialAlertDialogBuilder negativeButton = positiveButton.setNegativeButton(dialogSpec3.getNegativeAction(), (DialogInterface.OnClickListener) null);
        Intrinsics.checkNotNullExpressionValue(negativeButton, "setNegativeButton(...)");
        this.collectionInputLayout = (TextInputLayout) viewInflate.findViewById(C6208R.id.collection_input_layout);
        TextInputEditText textInputEditText2 = (TextInputEditText) viewInflate.findViewById(C6208R.id.collection_title);
        if (textInputEditText2 != null) {
            textInputEditText2.addTextChangedListener(this);
            textInputEditText2.setText(this.collectionName);
            textInputEditText2.setSelection(this.collectionName.length());
            textInputEditText2.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.myscript.nebo.dms.dialog.CollectionDialog$$ExternalSyntheticLambda1
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return CollectionDialog.onCreateDialog$lambda$1$0(this.f$0, textView, i, keyEvent);
                }
            });
            textInputEditText = textInputEditText2;
        }
        this.collectionNameField = textInputEditText;
        AlertDialog alertDialogCreate = negativeButton.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
        TextInputEditText textInputEditText3 = this.collectionNameField;
        if (textInputEditText3 != null) {
            textInputEditText3.requestFocus();
        }
        this.positiveButton = alertDialogCreate.getButton(-1);
        updateUIState();
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(CollectionDialog collectionDialog, DialogInterface dialogInterface, int i) {
        String str;
        Bundle bundle = new Bundle();
        CollectionKey collectionKey = collectionDialog.initialCollectionKey;
        DialogSpec dialogSpec = null;
        bundle.putString(COLLECTION_KEY_KEY, collectionKey != null ? collectionKey.serialize() : null);
        bundle.putString(COLLECTION_NAME_KEY, collectionDialog.collectionName);
        DialogSpec dialogSpec2 = collectionDialog.spec;
        if (dialogSpec2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spec");
        } else {
            dialogSpec = dialogSpec2;
        }
        if (Intrinsics.areEqual(dialogSpec, DialogSpec.Edit.INSTANCE)) {
            str = REQUEST_KEY_EDIT;
        } else {
            if (!Intrinsics.areEqual(dialogSpec, DialogSpec.New.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            str = REQUEST_KEY_NEW;
        }
        collectionDialog.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateDialog$lambda$1$0(CollectionDialog collectionDialog, TextView textView, int i, KeyEvent keyEvent) {
        Button button = collectionDialog.positiveButton;
        if (button == null || !button.isEnabled()) {
            return false;
        }
        Button button2 = collectionDialog.positiveButton;
        if (button2 != null) {
            button2.callOnClick();
        }
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        TextInputEditText textInputEditText = this.collectionNameField;
        if (textInputEditText != null) {
            textInputEditText.removeTextChangedListener(this);
        }
        TextInputEditText textInputEditText2 = this.collectionNameField;
        if (textInputEditText2 != null) {
            textInputEditText2.setOnEditorActionListener(null);
        }
        this.collectionNameField = null;
        this.collectionInputLayout = null;
        this.positiveButton = null;
        super.onDestroyView();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        this.collectionName = charSequence.toString();
        updateUIState();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putString(COLLECTION_NAME_KEY, this.collectionName);
        super.onSaveInstanceState(outState);
    }

    private final void updateUIState() {
        LibraryRepository libraryRepository = this.libraryRepository;
        if (libraryRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryRepository");
            libraryRepository = null;
        }
        CollectionPropertiesValidator.Status statusValidateCollection = libraryRepository.validateCollection(this.collectionName);
        Button button = this.positiveButton;
        if (button != null) {
            button.setEnabled(statusValidateCollection instanceof CollectionPropertiesValidator.Status.Valid);
        }
    }

    /* JADX INFO: compiled from: CollectionDialog.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/dms/dialog/CollectionDialog$Companion;", "", "<init>", "()V", CollectionDialog.TAG_EDIT, "", CollectionDialog.TAG_NEW, "REQUEST_KEY_EDIT", "REQUEST_KEY_NEW", CollectionDialog.REQUEST_KEY, CollectionDialog.COLLECTION_KEY_KEY, CollectionDialog.COLLECTION_NAME_KEY, "newInstance", "Lcom/myscript/nebo/dms/dialog/CollectionDialog;", "requestKey", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CollectionDialog newInstance(String requestKey, CollectionKey collectionKey) {
            Intrinsics.checkNotNullParameter(requestKey, "requestKey");
            CollectionDialog collectionDialog = new CollectionDialog();
            if (Intrinsics.areEqual(requestKey, CollectionDialog.TAG_EDIT) && collectionKey == null) {
                throw new IllegalArgumentException("Editing a collection without its key can't work".toString());
            }
            Bundle bundle = new Bundle();
            bundle.putString(CollectionDialog.REQUEST_KEY, requestKey);
            bundle.putString(CollectionDialog.COLLECTION_KEY_KEY, collectionKey != null ? collectionKey.serialize() : null);
            collectionDialog.setArguments(bundle);
            return collectionDialog;
        }
    }
}

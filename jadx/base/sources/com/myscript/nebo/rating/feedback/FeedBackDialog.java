package com.myscript.nebo.rating.feedback;

import android.R;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.C6014R;
import com.myscript.android.utils.DialogFragmentExt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.rating.feedback.FeedbackState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: FeedBackDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u000f\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010%\u001a\u00020\u001aH\u0016J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006-"}, m1599d2 = {"Lcom/myscript/nebo/rating/feedback/FeedBackDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "feedbackEditText", "Landroid/widget/EditText;", "closeButton", "Landroid/widget/Button;", "submitButton", "noInternetConnection", "Landroid/widget/TextView;", "submitFeedbackIndicator", "Landroid/widget/ProgressBar;", "subTitle", "textWatcher", "com/myscript/nebo/rating/feedback/FeedBackDialog$textWatcher$1", "Lcom/myscript/nebo/rating/feedback/FeedBackDialog$textWatcher$1;", "feedbackViewModel", "Lcom/myscript/nebo/rating/feedback/FeedbackViewModel;", "getFeedbackViewModel", "()Lcom/myscript/nebo/rating/feedback/FeedbackViewModel;", "feedbackViewModel$delegate", "Lkotlin/Lazy;", "getTheme", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroy", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "submitFeedback", "feedbackContent", "", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FeedBackDialog extends DialogFragment {
    public static final String TAG = "FeedBackDialog";
    private Button closeButton;
    private EditText feedbackEditText;

    /* JADX INFO: renamed from: feedbackViewModel$delegate, reason: from kotlin metadata */
    private final Lazy feedbackViewModel;
    private TextView noInternetConnection;
    private TextView subTitle;
    private Button submitButton;
    private ProgressBar submitFeedbackIndicator;
    private final FeedBackDialog$textWatcher$1 textWatcher = new TextWatcher() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$textWatcher$1
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            String string;
            if (s == null || (string = s.toString()) == null) {
                string = "";
            }
            if (string.length() > 0) {
                this.this$0.getFeedbackViewModel().onFeedbackTextChanged(string);
            }
        }
    };

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final FeedBackDialog newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.myscript.nebo.rating.feedback.FeedBackDialog$textWatcher$1] */
    public FeedBackDialog() {
        final FeedBackDialog feedBackDialog = this;
        Function0 function0 = new Function0() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FeedBackDialog.feedbackViewModel_delegate$lambda$0();
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return feedBackDialog;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function02.invoke();
            }
        });
        final Function0 function03 = null;
        this.feedbackViewModel = FragmentViewModelLazyKt.createViewModelLazy(feedBackDialog, Reflection.getOrCreateKotlinClass(FeedbackViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM11616viewModels$lambda1 = FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM11616viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM11616viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeedbackViewModel getFeedbackViewModel() {
        return (FeedbackViewModel) this.feedbackViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory feedbackViewModel_delegate$lambda$0() {
        return FeedbackViewModel.INSTANCE.getFactory();
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return C6014R.style.AutoSize_DialogNoTitle;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = LayoutInflater.from(requireActivity()).inflate(C6079R.layout.share_feedback_dialog, container);
        DialogFragmentExt.allowWindowToBeResizedWithVirtualKeyboard(this);
        this.feedbackEditText = (EditText) viewInflate.findViewById(C6079R.id.feedback_edit_text);
        this.closeButton = (Button) viewInflate.findViewById(C6079R.id.close_button);
        this.submitButton = (Button) viewInflate.findViewById(C6079R.id.submit_button);
        this.noInternetConnection = (TextView) viewInflate.findViewById(C6079R.id.no_internet_connection);
        this.submitFeedbackIndicator = (ProgressBar) viewInflate.findViewById(C6079R.id.progressBar);
        this.subTitle = (TextView) viewInflate.findViewById(C6079R.id.subtitle_text_view);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Button button = this.submitButton;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FeedBackDialog.onViewCreated$lambda$0(this.f$0, view2);
                }
            });
        }
        Button button2 = this.closeButton;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FeedBackDialog.onViewCreated$lambda$1(this.f$0, view2);
                }
            });
        }
        EditText editText = this.feedbackEditText;
        if (editText != null) {
            editText.addTextChangedListener(this.textWatcher);
        }
        getFeedbackViewModel().getFeedbackText().observe(getViewLifecycleOwner(), new FeedBackDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedBackDialog.onViewCreated$lambda$2(this.f$0, (String) obj);
            }
        }));
        getFeedbackViewModel().getConnected().observe(getViewLifecycleOwner(), new FeedBackDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedBackDialog.onViewCreated$lambda$3(this.f$0, (Boolean) obj);
            }
        }));
        getFeedbackViewModel().getProgressBarVisible().observe(getViewLifecycleOwner(), new FeedBackDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedBackDialog.onViewCreated$lambda$4(this.f$0, (Boolean) obj);
            }
        }));
        getFeedbackViewModel().getFeedbackState().observe(getViewLifecycleOwner(), new FeedBackDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedBackDialog.onViewCreated$lambda$5(this.f$0, (FeedbackState) obj);
            }
        }));
        TextView textView = this.subTitle;
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(FeedBackDialog feedBackDialog, View view) {
        Editable text;
        EditText editText = feedBackDialog.feedbackEditText;
        String string = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
        String str = string;
        if (str == null || str.length() == 0) {
            return;
        }
        feedBackDialog.submitFeedback(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(FeedBackDialog feedBackDialog, View view) {
        NeboFirebaseEvent.ShareFeedbackModal.log(new Function1() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedBackDialog.onViewCreated$lambda$1$0((Bundle) obj);
            }
        });
        feedBackDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1$0(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("selected", "share_feedback_cross");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(FeedBackDialog feedBackDialog, String str) {
        Boolean value = feedBackDialog.getFeedbackViewModel().getConnected().getValue();
        boolean z = false;
        boolean zBooleanValue = value != null ? value.booleanValue() : false;
        Button button = feedBackDialog.submitButton;
        if (button != null) {
            Intrinsics.checkNotNull(str);
            if (str.length() > 0 && zBooleanValue) {
                z = true;
            }
            button.setEnabled(z);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(FeedBackDialog feedBackDialog, Boolean bool) {
        TextView textView = feedBackDialog.noInternetConnection;
        if (textView != null) {
            textView.setVisibility(!bool.booleanValue() ? 0 : 8);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4(FeedBackDialog feedBackDialog, Boolean bool) {
        ProgressBar progressBar = feedBackDialog.submitFeedbackIndicator;
        if (progressBar != null) {
            ProgressBar progressBar2 = progressBar;
            Intrinsics.checkNotNull(bool);
            progressBar2.setVisibility(bool.booleanValue() ? 0 : 8);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(final FeedBackDialog feedBackDialog, FeedbackState feedbackState) {
        if (feedbackState instanceof FeedbackState.Error) {
            MaterialAlertDialogBuilder negativeButton = new MaterialAlertDialogBuilder(feedBackDialog.requireContext()).setTitle(C6079R.string.pre_rating_unable_to_submit_feedback).setMessage(C6079R.string.pre_rating_unable_to_submit_feedback_description).setPositiveButton(C6079R.string.pre_rating_unable_to_submit_feedback_try_gain, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    FeedBackDialog.onViewCreated$lambda$5$0(this.f$0, dialogInterface, i);
                }
            }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
            Intrinsics.checkNotNullExpressionValue(negativeButton, "setNegativeButton(...)");
            negativeButton.show();
        } else {
            if (!Intrinsics.areEqual(feedbackState, FeedbackState.Success.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            ProgressBar progressBar = feedBackDialog.submitFeedbackIndicator;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            NeboFirebaseEvent.ShareFeedbackModal.log(new Function1() { // from class: com.myscript.nebo.rating.feedback.FeedBackDialog$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FeedBackDialog.onViewCreated$lambda$5$1((Bundle) obj);
                }
            });
            FeedbackSentDialog feedbackSentDialogNewInstance = FeedbackSentDialog.INSTANCE.newInstance();
            FragmentManager parentFragmentManager = feedBackDialog.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
            feedbackSentDialogNewInstance.show(parentFragmentManager);
            feedBackDialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$0(FeedBackDialog feedBackDialog, DialogInterface dialogInterface, int i) {
        Editable text;
        EditText editText = feedBackDialog.feedbackEditText;
        String string = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
        String str = string;
        if (str == null || str.length() == 0) {
            return;
        }
        feedBackDialog.submitFeedback(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5$1(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("selected", "send_feedback");
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EditText editText = this.feedbackEditText;
        if (editText != null) {
            editText.removeTextChangedListener(this.textWatcher);
        }
        Button button = this.closeButton;
        if (button != null) {
            button.setOnClickListener(null);
        }
        Button button2 = this.submitButton;
        if (button2 != null) {
            button2.setOnClickListener(null);
        }
        this.feedbackEditText = null;
        this.closeButton = null;
        this.submitButton = null;
        this.noInternetConnection = null;
        this.submitFeedbackIndicator = null;
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        DialogFragmentExt.showAtMostOnce(this, manager, TAG);
    }

    private final void submitFeedback(String feedbackContent) {
        getFeedbackViewModel().sendFeedback(feedbackContent);
    }

    /* JADX INFO: compiled from: FeedBackDialog.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/rating/feedback/FeedBackDialog$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/myscript/nebo/rating/feedback/FeedBackDialog;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FeedBackDialog newInstance() {
            return new FeedBackDialog();
        }
    }
}

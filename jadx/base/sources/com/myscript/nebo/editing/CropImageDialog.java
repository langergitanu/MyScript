package com.myscript.nebo.editing;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0028R;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.android.utils.DialogFragmentExt;
import com.myscript.android.utils.ScreenUtils;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.databinding.CropImageDialogBinding;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropFragment;
import com.yalantis.ucrop.UCropFragmentCallback;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CropImageDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J \u0010%\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0014H\u0002J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0014H\u0016J\u0016\u0010)\u001a\u00020\"2\f\u0010*\u001a\b\u0018\u00010+R\u00020\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006-"}, m1599d2 = {"Lcom/myscript/nebo/editing/CropImageDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/yalantis/ucrop/UCropFragmentCallback;", "<init>", "()V", "binding", "Lcom/myscript/nebo/databinding/CropImageDialogBinding;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "getLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "logger$delegate", "Lkotlin/Lazy;", "srcUri", "Landroid/net/Uri;", "getSrcUri", "()Landroid/net/Uri;", "dstUri", "getDstUri", "existing", "", "getExisting", "()Z", "fragment", "Lcom/yalantis/ucrop/UCropFragment;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "setupFragment", "hideControls", "loadingProgress", "showLoader", "onCropFinish", "result", "Lcom/yalantis/ucrop/UCropFragment$UCropResult;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CropImageDialog extends DialogFragment implements UCropFragmentCallback {
    public static final String CROPPED_IMAGE_FILENAME = "cropped_image";
    public static final String IMAGE_CROPPED_URI_KEY = "IMAGE_CROPPED_URI_KEY";
    public static final String IMAGE_TO_CROP_EXISTING_KEY = "imageToCropExistingKey";
    public static final String IMAGE_TO_CROP_URI_KEY = "imageToCropUriKey";
    public static final String REQUEST_KEY = "CropImageDialog_REQUEST_KEY";
    public static final String RESULT_SUCCESS_KEY = "RESULT_KEY";
    public static final String TAG = "CropImageDialog";
    private CropImageDialogBinding binding;
    private UCropFragment fragment;

    /* JADX INFO: renamed from: logger$delegate, reason: from kotlin metadata */
    private final Lazy logger = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.editing.CropImageDialog$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CropImageDialog.logger_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    private final TechnicalLogger getLogger() {
        return (TechnicalLogger) this.logger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TechnicalLogger logger_delegate$lambda$0(CropImageDialog cropImageDialog) {
        Context context = cropImageDialog.getContext();
        Object applicationContext = context != null ? context.getApplicationContext() : null;
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        return ((TechnicalLoggerProvider) applicationContext).provideTechnicalLogger();
    }

    private final Uri getSrcUri() {
        String string = requireArguments().getString(IMAGE_TO_CROP_URI_KEY);
        if (string != null) {
            return Uri.parse(string);
        }
        return null;
    }

    private final Uri getDstUri() {
        String string = requireArguments().getString(IMAGE_CROPPED_URI_KEY);
        if (string != null) {
            return Uri.parse(string);
        }
        return null;
    }

    private final boolean getExisting() {
        return requireArguments().getBoolean(IMAGE_TO_CROP_EXISTING_KEY, false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        CropImageDialogBinding cropImageDialogBindingInflate = CropImageDialogBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(cropImageDialogBindingInflate, "inflate(...)");
        this.binding = cropImageDialogBindingInflate;
        setCancelable(false);
        DisplayMetrics fixedDisplayMetrics = ScreenUtils.getFixedDisplayMetrics(getContext());
        Intrinsics.checkNotNullExpressionValue(fixedDisplayMetrics, "getFixedDisplayMetrics(...)");
        boolean z = ScreenUtils.pxToDp(getContext(), fixedDisplayMetrics.heightPixels) < 600;
        final Uri srcUri = getSrcUri();
        CropImageDialogBinding cropImageDialogBinding = null;
        if (srcUri != null) {
            Uri dstUri = getDstUri();
            if (dstUri != null) {
                setupFragment(srcUri, dstUri, z);
                CropImageDialogBinding cropImageDialogBinding2 = this.binding;
                if (cropImageDialogBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cropImageDialogBinding2 = null;
                }
                cropImageDialogBinding2.okButton.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.CropImageDialog$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CropImageDialog.onCreateView$lambda$0$0$0(this.f$0, view);
                    }
                });
                CropImageDialogBinding cropImageDialogBinding3 = this.binding;
                if (cropImageDialogBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cropImageDialogBinding3 = null;
                }
                cropImageDialogBinding3.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.CropImageDialog$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CropImageDialog.onCreateView$lambda$0$0$1(this.f$0, view);
                    }
                });
            } else {
                new Function0() { // from class: com.myscript.nebo.editing.CropImageDialog$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CropImageDialog.onCreateView$lambda$0$1(this.f$0, srcUri);
                    }
                };
            }
            CropImageDialogBinding cropImageDialogBinding4 = this.binding;
            if (cropImageDialogBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cropImageDialogBinding4 = null;
            }
            FragmentContainerView fragmentContainerView = cropImageDialogBinding4.fragmentContainer;
            CropImageDialogBinding cropImageDialogBinding5 = this.binding;
            if (cropImageDialogBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cropImageDialogBinding5 = null;
            }
            ViewGroup.LayoutParams layoutParams = cropImageDialogBinding5.fragmentContainer.getLayoutParams();
            layoutParams.height = fixedDisplayMetrics.heightPixels / 2;
            fragmentContainerView.setLayoutParams(layoutParams);
        } else {
            new Function0() { // from class: com.myscript.nebo.editing.CropImageDialog$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CropImageDialog.onCreateView$lambda$1(this.f$0);
                }
            };
        }
        CropImageDialogBinding cropImageDialogBinding6 = this.binding;
        if (cropImageDialogBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cropImageDialogBinding = cropImageDialogBinding6;
        }
        return cropImageDialogBinding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0$0$0(CropImageDialog cropImageDialog, View view) {
        UCropFragment uCropFragment = cropImageDialog.fragment;
        UCropFragment uCropFragment2 = null;
        if (uCropFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            uCropFragment = null;
        }
        if (uCropFragment.isAdded()) {
            UCropFragment uCropFragment3 = cropImageDialog.fragment;
            if (uCropFragment3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragment");
            } else {
                uCropFragment2 = uCropFragment3;
            }
            uCropFragment2.cropAndSaveImage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0$0$1(CropImageDialog cropImageDialog, View view) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("RESULT_KEY", false);
        Unit unit = Unit.INSTANCE;
        FragmentKt.setFragmentResult(cropImageDialog, REQUEST_KEY, bundle);
        cropImageDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$1(CropImageDialog cropImageDialog, Uri uri) {
        cropImageDialog.getLogger().logError(new IllegalStateException("Crop image, invalid destination uri: " + uri));
        cropImageDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$1(CropImageDialog cropImageDialog) {
        cropImageDialog.getLogger().logError(new IllegalStateException("Crop image, invalid source uri: " + cropImageDialog.getSrcUri()));
        cropImageDialog.dismiss();
        return Unit.INSTANCE;
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        DialogFragmentExt.showAtMostOnce(this, manager, TAG);
    }

    private final void setupFragment(Uri srcUri, Uri dstUri, boolean hideControls) {
        Bundle extras = UCrop.m1588of(srcUri, dstUri).getIntent(requireContext()).getExtras();
        if (extras != null) {
            extras.putBoolean(UCrop.Options.EXTRA_FREE_STYLE_CROP, true);
            extras.putBoolean(UCrop.Options.EXTRA_HIDE_BOTTOM_CONTROLS, hideControls);
            TypedValue typedValue = new TypedValue();
            requireContext().getTheme().resolveAttribute(C0028R.attr.colorPrimary, typedValue, true);
            extras.putInt(UCrop.Options.EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, typedValue.data);
            UCropFragment uCropFragmentNewInstance = UCropFragment.newInstance(extras);
            Intrinsics.checkNotNullExpressionValue(uCropFragmentNewInstance, "newInstance(...)");
            this.fragment = uCropFragmentNewInstance;
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            int i = C6079R.id.fragment_container;
            UCropFragment uCropFragment = this.fragment;
            if (uCropFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragment");
                uCropFragment = null;
            }
            Integer.valueOf(fragmentTransactionBeginTransaction.add(i, uCropFragment, UCropFragment.TAG).commitAllowingStateLoss());
            return;
        }
        new Function0() { // from class: com.myscript.nebo.editing.CropImageDialog$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CropImageDialog.setupFragment$lambda$2(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupFragment$lambda$2(CropImageDialog cropImageDialog) {
        cropImageDialog.getLogger().logError(new IllegalStateException("UCrop intent extras is null"));
        cropImageDialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // com.yalantis.ucrop.UCropFragmentCallback
    public void loadingProgress(boolean showLoader) {
        CropImageDialogBinding cropImageDialogBinding = this.binding;
        if (cropImageDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cropImageDialogBinding = null;
        }
        cropImageDialogBinding.okButton.setEnabled(!showLoader);
    }

    @Override // com.yalantis.ucrop.UCropFragmentCallback
    public void onCropFinish(UCropFragment.UCropResult result) {
        Intent intent;
        Intent intent2;
        String path;
        CropImageDialog cropImageDialog = this;
        Bundle bundle = new Bundle();
        if (result != null && result.mResultCode == -1) {
            bundle.putBoolean("RESULT_KEY", true);
            Uri dstUri = getDstUri();
            if (dstUri != null && (path = dstUri.getPath()) != null) {
                bundle.putString(IMAGE_CROPPED_URI_KEY, path);
            }
            bundle.putBoolean(IMAGE_TO_CROP_EXISTING_KEY, getExisting());
        } else {
            Serializable serializableExtra = null;
            th = null;
            Throwable th = null;
            serializableExtra = null;
            if (Build.VERSION.SDK_INT < 33) {
                if (result != null && (intent = result.mResultData) != null) {
                    serializableExtra = intent.getSerializableExtra(UCrop.EXTRA_ERROR);
                }
                th = (Throwable) serializableExtra;
            } else if (result != null && (intent2 = result.mResultData) != null) {
                th = (Throwable) intent2.getSerializableExtra(UCrop.EXTRA_ERROR, Throwable.class);
            }
            if (th != null) {
                getLogger().logError(new IllegalStateException(th));
            }
        }
        Unit unit = Unit.INSTANCE;
        FragmentKt.setFragmentResult(cropImageDialog, REQUEST_KEY, bundle);
        dismiss();
    }

    /* JADX INFO: compiled from: CropImageDialog.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/editing/CropImageDialog$Companion;", "", "<init>", "()V", "TAG", "", "IMAGE_TO_CROP_URI_KEY", CropImageDialog.IMAGE_CROPPED_URI_KEY, "IMAGE_TO_CROP_EXISTING_KEY", "REQUEST_KEY", "RESULT_SUCCESS_KEY", "CROPPED_IMAGE_FILENAME", "newInstance", "Lcom/myscript/nebo/editing/CropImageDialog;", "srcUri", "Landroid/net/Uri;", "dstUri", "existing", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CropImageDialog newInstance(Uri srcUri, Uri dstUri, boolean existing) {
            Intrinsics.checkNotNullParameter(srcUri, "srcUri");
            Intrinsics.checkNotNullParameter(dstUri, "dstUri");
            CropImageDialog cropImageDialog = new CropImageDialog();
            Bundle bundle = new Bundle();
            bundle.putString(CropImageDialog.IMAGE_TO_CROP_URI_KEY, srcUri.toString());
            bundle.putString(CropImageDialog.IMAGE_CROPPED_URI_KEY, dstUri.toString());
            bundle.putBoolean(CropImageDialog.IMAGE_TO_CROP_EXISTING_KEY, existing);
            cropImageDialog.setArguments(bundle);
            return cropImageDialog;
        }
    }
}

package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class ExportDialogLayoutBinding implements ViewBinding {
    public final Button cancelButton;
    public final SwitchMaterial exportAnnotationOptions;
    public final SwitchMaterial exportBackgroundColorOptions;
    public final SwitchMaterial exportBackgroundPatternOptions;
    public final Button exportButton;
    public final SwitchMaterial exportCombineOptions;
    public final TextView exportDescription;
    public final LinearLayout exportDialogConfigurationContainer;
    public final LinearLayout exportDialogContainer;
    public final LinearLayout exportDialogProgressContainer;
    public final TextInputEditText exportFilename;
    public final TextView exportFilenameCategory;
    public final TextInputLayout exportFilenameContainer;
    public final SwitchMaterial exportFlattenOptions;
    public final TextView exportOptionsCategory;
    public final ProgressBar exportProgressBar;
    public final AppCompatSpinner exportType;
    private final LinearLayout rootView;

    private ExportDialogLayoutBinding(LinearLayout linearLayout, Button button, SwitchMaterial switchMaterial, SwitchMaterial switchMaterial2, SwitchMaterial switchMaterial3, Button button2, SwitchMaterial switchMaterial4, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextInputEditText textInputEditText, TextView textView2, TextInputLayout textInputLayout, SwitchMaterial switchMaterial5, TextView textView3, ProgressBar progressBar, AppCompatSpinner appCompatSpinner) {
        this.rootView = linearLayout;
        this.cancelButton = button;
        this.exportAnnotationOptions = switchMaterial;
        this.exportBackgroundColorOptions = switchMaterial2;
        this.exportBackgroundPatternOptions = switchMaterial3;
        this.exportButton = button2;
        this.exportCombineOptions = switchMaterial4;
        this.exportDescription = textView;
        this.exportDialogConfigurationContainer = linearLayout2;
        this.exportDialogContainer = linearLayout3;
        this.exportDialogProgressContainer = linearLayout4;
        this.exportFilename = textInputEditText;
        this.exportFilenameCategory = textView2;
        this.exportFilenameContainer = textInputLayout;
        this.exportFlattenOptions = switchMaterial5;
        this.exportOptionsCategory = textView3;
        this.exportProgressBar = progressBar;
        this.exportType = appCompatSpinner;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ExportDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ExportDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.export_dialog_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExportDialogLayoutBinding bind(View view) {
        int i = C6079R.id.cancel_button;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = C6079R.id.export_annotation_options;
            SwitchMaterial switchMaterial = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
            if (switchMaterial != null) {
                i = C6079R.id.export_background_color_options;
                SwitchMaterial switchMaterial2 = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
                if (switchMaterial2 != null) {
                    i = C6079R.id.export_background_pattern_options;
                    SwitchMaterial switchMaterial3 = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
                    if (switchMaterial3 != null) {
                        i = C6079R.id.export_button;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button2 != null) {
                            i = C6079R.id.export_combine_options;
                            SwitchMaterial switchMaterial4 = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
                            if (switchMaterial4 != null) {
                                i = C6079R.id.export_description;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = C6079R.id.export_dialog_configuration_container;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        LinearLayout linearLayout2 = (LinearLayout) view;
                                        i = C6079R.id.export_dialog_progress_container;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = C6079R.id.export_filename;
                                            TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, i);
                                            if (textInputEditText != null) {
                                                i = C6079R.id.export_filename_category;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = C6079R.id.export_filename_container;
                                                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                                    if (textInputLayout != null) {
                                                        i = C6079R.id.export_flatten_options;
                                                        SwitchMaterial switchMaterial5 = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
                                                        if (switchMaterial5 != null) {
                                                            i = C6079R.id.export_options_category;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView3 != null) {
                                                                i = C6079R.id.export_progress_bar;
                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                if (progressBar != null) {
                                                                    i = C6079R.id.export_type;
                                                                    AppCompatSpinner appCompatSpinner = (AppCompatSpinner) ViewBindings.findChildViewById(view, i);
                                                                    if (appCompatSpinner != null) {
                                                                        return new ExportDialogLayoutBinding(linearLayout2, button, switchMaterial, switchMaterial2, switchMaterial3, button2, switchMaterial4, textView, linearLayout, linearLayout2, linearLayout3, textInputEditText, textView2, textInputLayout, switchMaterial5, textView3, progressBar, appCompatSpinner);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

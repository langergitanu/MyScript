package com.myscript.atk.p021ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
public class SettingsDialog extends AlertDialog.Builder {
    public SettingsDialog(Context context, final SmartGuideComponent smartGuideComponent, final SmartGuideMoreActions smartGuideMoreActions) {
        int i;
        super(context);
        if (smartGuideMoreActions.swigValue() == SmartGuideMoreActions.MathApprox.swigValue() || smartGuideMoreActions.swigValue() == SmartGuideMoreActions.MathDegRad.swigValue() || smartGuideMoreActions.swigValue() == SmartGuideMoreActions.MathSolver.swigValue()) {
            if (smartGuideMoreActions.swigValue() == SmartGuideMoreActions.MathApprox.swigValue()) {
                setTitle(context.getResources().getString(C6033R.string.pref_math_solver_approximation_label));
                i = C6033R.array.pref_smartguide_approximation_labels;
            } else if (smartGuideMoreActions.swigValue() == SmartGuideMoreActions.MathDegRad.swigValue()) {
                setTitle(context.getResources().getString(C6033R.string.pref_math_solver_angle_unit_label));
                i = C6033R.array.pref_smartguide_angle_unit_labels;
            } else if (smartGuideMoreActions.swigValue() == SmartGuideMoreActions.MathSolver.swigValue()) {
                setTitle(context.getResources().getString(C6033R.string.pref_solver_label));
                i = C6033R.array.pref_smartguide_solver_labels;
            } else {
                i = 0;
            }
            setSingleChoiceItems(i, !Boolean.parseBoolean(smartGuideComponent.getOptionValueKey(smartGuideMoreActions.swigValue())) ? 1 : 0, new DialogInterface.OnClickListener() { // from class: com.myscript.atk.ui.SettingsDialog$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    SettingsDialog.lambda$new$0(smartGuideComponent, smartGuideMoreActions, dialogInterface, i2);
                }
            });
            setNegativeButton(context.getResources().getString(C6033R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.myscript.atk.ui.SettingsDialog$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            show();
        }
    }

    static /* synthetic */ void lambda$new$0(SmartGuideComponent smartGuideComponent, SmartGuideMoreActions smartGuideMoreActions, DialogInterface dialogInterface, int i) {
        smartGuideComponent.setValueForOption(Boolean.toString(i == 0), smartGuideMoreActions.swigValue());
        dialogInterface.dismiss();
    }
}

package com.revenuecat.purchases.utils;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AlertDialogHelper.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001Jb\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH&¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/utils/AlertDialogHelper;", "", "showDialog", "", "activity", "Landroid/app/Activity;", "title", "", "message", "positiveButtonText", "negativeButtonText", "neutralButtonText", "onPositiveButtonClicked", "Lkotlin/Function0;", "onNegativeButtonClicked", "onNeutralButtonClicked", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface AlertDialogHelper {
    void showDialog(Activity activity, String title, String message, String positiveButtonText, String negativeButtonText, String neutralButtonText, Function0<Unit> onPositiveButtonClicked, Function0<Unit> onNegativeButtonClicked, Function0<Unit> onNeutralButtonClicked);
}

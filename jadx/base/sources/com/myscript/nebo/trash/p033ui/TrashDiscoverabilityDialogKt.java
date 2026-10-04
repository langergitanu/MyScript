package com.myscript.nebo.trash.p033ui;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrashDiscoverabilityDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"showTrashDiscoverabilityDialog", "", "Landroidx/appcompat/app/AppCompatActivity;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TrashDiscoverabilityDialogKt {
    public static final void showTrashDiscoverabilityDialog(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        TrashDiscoverabilityDialog trashDiscoverabilityDialogNewInstance = TrashDiscoverabilityDialog.INSTANCE.newInstance();
        trashDiscoverabilityDialogNewInstance.setCancelable(false);
        trashDiscoverabilityDialogNewInstance.show(appCompatActivity.getSupportFragmentManager(), TrashDiscoverabilityDialog.TAG);
    }
}

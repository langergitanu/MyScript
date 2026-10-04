package com.myscript.android.utils;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MotionEventSPenExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"S_PEN_ACTION_DOWN", "", "S_PEN_ACTION_UP", "S_PEN_ACTION_MOVE", "S_PEN_ACTION_CANCEL", "actionMaskedSPen", "Landroid/view/MotionEvent;", "getActionMaskedSPen", "(Landroid/view/MotionEvent;)I", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MotionEventSPenExt {
    private static final int S_PEN_ACTION_CANCEL = 214;
    private static final int S_PEN_ACTION_DOWN = 211;
    private static final int S_PEN_ACTION_MOVE = 213;
    private static final int S_PEN_ACTION_UP = 212;

    public static final int getActionMaskedSPen(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "<this>");
        switch (motionEvent.getActionMasked()) {
            case S_PEN_ACTION_DOWN /* 211 */:
                return 0;
            case S_PEN_ACTION_UP /* 212 */:
                return 1;
            case S_PEN_ACTION_MOVE /* 213 */:
                return 2;
            case S_PEN_ACTION_CANCEL /* 214 */:
                return 3;
            default:
                return motionEvent.getActionMasked();
        }
    }
}

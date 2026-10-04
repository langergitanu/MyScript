package com.myscript.nebo.editing;

import android.content.Context;
import android.content.SharedPreferences;
import com.myscript.nebo.C6079R;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PaperSize;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0006H\u0002\u001a\u001c\u0010\u000e\u001a\u00020\f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000*d\b\u0002\u0010\u0007\".\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\b2.\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\b¨\u0006\u0014"}, m1599d2 = {"toJson", "", "", "", "([Ljava/lang/Float;)Ljava/lang/String;", "toJsonPageSize", "Lcom/myscript/snt/core/PaperSize;", "ActionMenuListenerDelegate", "Lkotlin/Function4;", "Lcom/myscript/atk/ui/ActionMenuEntry;", "Lcom/myscript/atk/core/Point;", "Lcom/myscript/atk/ui/ActionMenuCallback;", "", "MATH_BLOCK_SUBTYPE", "applyMathBlockPreferences", "Landroid/content/SharedPreferences;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "pageController", "Lcom/myscript/snt/core/PageController;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageViewModelKt {
    private static final String MATH_BLOCK_SUBTYPE = "com.myscript.math";

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toJson(Float[] fArr) {
        return ArraysKt.joinToString$default(fArr, ",", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toJsonPageSize(PaperSize paperSize) {
        Float fValueOf = Float.valueOf(0.0f);
        return toJson(new Float[]{fValueOf, fValueOf, Float.valueOf(paperSize.getWidth()), Float.valueOf(paperSize.getHeight())});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyMathBlockPreferences(SharedPreferences sharedPreferences, Context context, PageController pageController) {
        String string = context.getString(C6079R.string.pref_solver_key);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(C6079R.string.pref_math_solver_angle_unit_key);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = context.getString(C6079R.string.pref_math_solver_approximation_key);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = sharedPreferences.getString(string2, context.getString(C6079R.string.pref_math_solver_angle_unit_degree));
        String string5 = sharedPreferences.getString(string3, context.getString(C6079R.string.pref_math_solver_approximation_truncated));
        boolean zAreEqual = Intrinsics.areEqual(string4, context.getString(C6079R.string.pref_math_solver_angle_unit_radian));
        boolean zAreEqual2 = Intrinsics.areEqual(string5, context.getString(C6079R.string.pref_math_solver_approximation_rounded));
        pageController.updateBlocksSettings(MATH_BLOCK_SUBTYPE, string, sharedPreferences.getBoolean(string, context.getResources().getBoolean(C6079R.bool.pref_enable_solver_default)));
        pageController.updateBlocksSettings(MATH_BLOCK_SUBTYPE, string2, zAreEqual);
        pageController.updateBlocksSettings(MATH_BLOCK_SUBTYPE, string3, zAreEqual2);
    }
}

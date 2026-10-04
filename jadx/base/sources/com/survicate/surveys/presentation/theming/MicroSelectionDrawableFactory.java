package com.survicate.surveys.presentation.theming;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.entities.attributes.MicroSurvicateSelectionType;
import com.survicate.surveys.entities.colors.MicroColorControlOpacity;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroSelectionDrawableFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, m1599d2 = {"Lcom/survicate/surveys/presentation/theming/MicroSelectionDrawableFactory;", "", "<init>", "()V", "createRipple", "Landroid/graphics/drawable/RippleDrawable;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "createDrawable", "Landroid/graphics/drawable/Drawable;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "selectionType", "Lcom/survicate/surveys/entities/attributes/MicroSurvicateSelectionType;", "createMaskDrawable", "maskColor", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroSelectionDrawableFactory {
    public static final MicroSelectionDrawableFactory INSTANCE = new MicroSelectionDrawableFactory();

    private MicroSelectionDrawableFactory() {
    }

    public final RippleDrawable createRipple(ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        int argbValue = ColorHelper.getArgbValue(colorScheme.getAnswer(), MicroColorControlOpacity.Pressed.getOpacityValue());
        return new RippleDrawable(ColorStateList.valueOf(argbValue), null, createMaskDrawable(argbValue));
    }

    public final Drawable createDrawable(Context context, ColorScheme colorScheme, MicroSurvicateSelectionType selectionType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(selectionType, "selectionType");
        Drawable drawable = ContextCompat.getDrawable(context, selectionType.getDrawableRes());
        if (drawable == null) {
            return null;
        }
        drawable.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(colorScheme.getAnswer(), BlendModeCompat.SRC_ATOP));
        return drawable;
    }

    private final Drawable createMaskDrawable(int maskColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(maskColor, BlendModeCompat.SRC_ATOP));
        return gradientDrawable;
    }
}

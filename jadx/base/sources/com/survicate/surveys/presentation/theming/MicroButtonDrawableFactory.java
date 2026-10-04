package com.survicate.surveys.presentation.theming;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.colors.MicroColorControlOpacity;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroButtonDrawableFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0012"}, m1599d2 = {"Lcom/survicate/surveys/presentation/theming/MicroButtonDrawableFactory;", "", "<init>", "()V", "createIconButtonBackground", "Landroid/graphics/drawable/Drawable;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "createFilledButtonBackground", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "createOutlinedButtonBackground", "createButtonTextColorStateList", "Landroid/content/res/ColorStateList;", "withFocusOffsetBorder", "createFocusedButtonDrawable", "cornerRadius", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroButtonDrawableFactory {
    public static final MicroButtonDrawableFactory INSTANCE = new MicroButtonDrawableFactory();

    private MicroButtonDrawableFactory() {
    }

    public final Drawable createIconButtonBackground(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return createFocusedButtonDrawable(context, context.getResources().getDimension(C8369R.dimen.survicate_micro_icon_button_focus_border_radius));
    }

    public final Drawable createFilledButtonBackground(Context context, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        int[][] iArr = {new int[]{R.attr.state_enabled}, new int[]{-16842910}};
        int[] iArr2 = {colorScheme.getButton(), ColorHelper.getArgbValue(colorScheme.getButton(), MicroColorControlOpacity.ButtonDisabled.getOpacityValue())};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(context.getResources().getDimension(C8369R.dimen.survicate_micro_button_radius));
        gradientDrawable.setColor(new ColorStateList(iArr, iArr2));
        return withFocusOffsetBorder(gradientDrawable, context);
    }

    public final Drawable createOutlinedButtonBackground(Context context, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        int[][] iArr = {new int[]{R.attr.state_enabled}, new int[]{-16842910}};
        int[] iArr2 = {ColorHelper.getArgbValue(colorScheme.getButton(), 1.0f), ColorHelper.getArgbValue(colorScheme.getAnswer(), MicroColorControlOpacity.OutlinedButtonBorderDisabled.getOpacityValue())};
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_border_width_default);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(context.getResources().getDimension(C8369R.dimen.survicate_micro_button_radius));
        gradientDrawable.setStroke(dimensionPixelSize, new ColorStateList(iArr, iArr2));
        return withFocusOffsetBorder(gradientDrawable, context);
    }

    public final ColorStateList createButtonTextColorStateList(ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        int[][] iArr = {new int[]{R.attr.state_enabled}, new int[]{-16842910}};
        int contrastColor = ColorHelper.INSTANCE.getContrastColor(colorScheme.getButton());
        return new ColorStateList(iArr, new int[]{contrastColor, ColorHelper.getArgbValue(contrastColor, MicroColorControlOpacity.ButtonTextDisabled.getOpacityValue())});
    }

    private final Drawable withFocusOffsetBorder(Drawable drawable, Context context) {
        Drawable[] drawableArr = {drawable, createFocusedButtonDrawable(context, context.getResources().getDimension(C8369R.dimen.survicate_micro_button_radius))};
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_button_focus_offset);
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        int i = -dimensionPixelSize;
        layerDrawable.setLayerInset(1, i, i, i, i);
        return layerDrawable;
    }

    private final Drawable createFocusedButtonDrawable(Context context, float cornerRadius) {
        Drawable drawableCreateFocusBorderBackground = MicroDrawableFactory.INSTANCE.createFocusBorderBackground(context, cornerRadius);
        Drawable drawableCreateTransparentBackground = MicroDrawableFactory.INSTANCE.createTransparentBackground();
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_focused}, drawableCreateFocusBorderBackground);
        stateListDrawable.addState(new int[0], drawableCreateTransparentBackground);
        return stateListDrawable;
    }
}

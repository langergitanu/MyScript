package com.survicate.surveys.presentation.theming;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.content.ContextCompat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.colors.MicroColorControlOpacity;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MicroDrawableFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ \u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0005J4\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u001f"}, m1599d2 = {"Lcom/survicate/surveys/presentation/theming/MicroDrawableFactory;", "", "<init>", "()V", "createAnswerItemBackground", "Landroid/graphics/drawable/Drawable;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "isSelected", "", "createInputTextBackground", "isError", "createLanguageSelectorBackground", "createLanguageItemBackground", "forceHighlight", "createFocusBorderBackground", "cornerRadius", "", "createTransparentBackground", "createStateListDrawable", "Landroid/graphics/drawable/StateListDrawable;", "defaultDrawable", "focusedDrawable", "pressedDrawable", "selectedDrawable", "getFocusColor", "", "getErrorColor", "getDefaultBorderWidth", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MicroDrawableFactory {
    public static final MicroDrawableFactory INSTANCE = new MicroDrawableFactory();

    private MicroDrawableFactory() {
    }

    public final Drawable createAnswerItemBackground(Context context, ColorScheme colorScheme, boolean isSelected) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        int argbValue = ColorHelper.getArgbValue(colorScheme.getAnswer(), MicroColorControlOpacity.AnswerBackground.getOpacityValue());
        float dimension = context.getResources().getDimension(C8369R.dimen.survicate_micro_question_border_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(argbValue);
        if (isSelected) {
            gradientDrawable.setStroke(getDefaultBorderWidth(context), colorScheme.getAnswer());
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(argbValue);
        MicroDrawableFactory microDrawableFactory = INSTANCE;
        gradientDrawable2.setStroke(microDrawableFactory.getDefaultBorderWidth(context), microDrawableFactory.getFocusColor(context));
        gradientDrawable2.setCornerRadius(dimension);
        return createStateListDrawable$default(this, gradientDrawable, gradientDrawable2, null, null, 12, null);
    }

    public static /* synthetic */ Drawable createInputTextBackground$default(MicroDrawableFactory microDrawableFactory, Context context, ColorScheme colorScheme, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return microDrawableFactory.createInputTextBackground(context, colorScheme, z);
    }

    public final Drawable createInputTextBackground(Context context, ColorScheme colorScheme, boolean isError) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        int argbValue = ColorHelper.getArgbValue(colorScheme.getAnswer(), MicroColorControlOpacity.AnswerBackground.getOpacityValue());
        float dimension = context.getResources().getDimension(C8369R.dimen.survicate_micro_input_border_radius);
        int defaultBorderWidth = getDefaultBorderWidth(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(argbValue);
        gradientDrawable.setCornerRadius(dimension);
        if (isError) {
            gradientDrawable.setStroke(defaultBorderWidth, getErrorColor(context));
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(argbValue);
        gradientDrawable2.setStroke(defaultBorderWidth, isError ? INSTANCE.getErrorColor(context) : colorScheme.getAnswer());
        gradientDrawable2.setCornerRadius(dimension);
        return createStateListDrawable$default(this, gradientDrawable, gradientDrawable2, null, null, 12, null);
    }

    public final Drawable createLanguageSelectorBackground(Context context, ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        int background = colorScheme.getBackground();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_language_selector_border_width);
        int argbValue = ColorHelper.getArgbValue(colorScheme.getAnswer(), MicroColorControlOpacity.LanguageSelectorBorder.getOpacityValue());
        float dimension = context.getResources().getDimension(C8369R.dimen.survicate_micro_language_selector_border_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(background);
        gradientDrawable.setStroke(dimensionPixelSize, argbValue);
        gradientDrawable.setCornerRadius(dimension);
        return gradientDrawable;
    }

    public final Drawable createLanguageItemBackground(Context context, ColorScheme colorScheme, boolean forceHighlight) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        int argbValue = ColorHelper.getArgbValue(colorScheme.getAnswer(), MicroColorControlOpacity.SelectedLanguageItemBackground.getOpacityValue());
        int i = forceHighlight ? argbValue : 0;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(argbValue);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(i);
        MicroDrawableFactory microDrawableFactory = INSTANCE;
        gradientDrawable3.setStroke(microDrawableFactory.getDefaultBorderWidth(context), microDrawableFactory.getFocusColor(context));
        return createStateListDrawable$default(this, gradientDrawable, null, gradientDrawable2, gradientDrawable3, 2, null);
    }

    public static /* synthetic */ Drawable createFocusBorderBackground$default(MicroDrawableFactory microDrawableFactory, Context context, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return microDrawableFactory.createFocusBorderBackground(context, f);
    }

    public final Drawable createFocusBorderBackground(Context context, float cornerRadius) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawableCreateTransparentBackground = createTransparentBackground();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        MicroDrawableFactory microDrawableFactory = INSTANCE;
        gradientDrawable.setStroke(microDrawableFactory.getDefaultBorderWidth(context), microDrawableFactory.getFocusColor(context));
        gradientDrawable.setCornerRadius(cornerRadius);
        return createStateListDrawable$default(this, drawableCreateTransparentBackground, gradientDrawable, null, null, 12, null);
    }

    public final Drawable createTransparentBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        return gradientDrawable;
    }

    static /* synthetic */ StateListDrawable createStateListDrawable$default(MicroDrawableFactory microDrawableFactory, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, int i, Object obj) {
        if ((i & 2) != 0) {
            drawable2 = null;
        }
        if ((i & 4) != 0) {
            drawable3 = null;
        }
        if ((i & 8) != 0) {
            drawable4 = null;
        }
        return microDrawableFactory.createStateListDrawable(drawable, drawable2, drawable3, drawable4);
    }

    private final StateListDrawable createStateListDrawable(Drawable defaultDrawable, Drawable focusedDrawable, Drawable pressedDrawable, Drawable selectedDrawable) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (focusedDrawable != null) {
            stateListDrawable.addState(new int[]{R.attr.state_focused}, focusedDrawable);
        }
        if (pressedDrawable != null) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, pressedDrawable);
        }
        if (selectedDrawable != null) {
            stateListDrawable.addState(new int[]{R.attr.state_selected}, selectedDrawable);
        }
        stateListDrawable.addState(new int[0], defaultDrawable);
        return stateListDrawable;
    }

    private final int getFocusColor(Context context) {
        return ContextCompat.getColor(context, C8369R.color.survicate_focus_border);
    }

    private final int getErrorColor(Context context) {
        return ContextCompat.getColor(context, C8369R.color.survicate_micro_error);
    }

    private final int getDefaultBorderWidth(Context context) {
        return context.getResources().getDimensionPixelSize(C8369R.dimen.survicate_micro_border_width_default);
    }
}

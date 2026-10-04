package com.survicate.surveys.presentation.shape.micro;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import com.survicate.surveys.entities.colors.MicroColorControlOpacity;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.presentation.theming.ColorHelper;
import com.survicate.surveys.surveys.QuestionRatingShapeType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShapeDrawableLoader.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/survicate/surveys/presentation/shape/micro/ShapeDrawableLoader;", "", "colorScheme", "Lcom/survicate/surveys/entities/survey/theme/ColorScheme;", "shape", "", "<init>", "(Lcom/survicate/surveys/entities/survey/theme/ColorScheme;Ljava/lang/String;)V", "selectedDrawableCached", "Landroid/graphics/drawable/Drawable;", "unselectedDrawableCached", "getShapeDrawable", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "isSelected", "", "loadShapeDrawable", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ShapeDrawableLoader {
    private final ColorScheme colorScheme;
    private Drawable selectedDrawableCached;
    private final String shape;
    private Drawable unselectedDrawableCached;

    public ShapeDrawableLoader(ColorScheme colorScheme, String str) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.colorScheme = colorScheme;
        this.shape = str;
    }

    public final Drawable getShapeDrawable(Context context, boolean isSelected) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isSelected) {
            Drawable drawable = this.selectedDrawableCached;
            if (drawable != null) {
                return drawable;
            }
            Drawable drawableLoadShapeDrawable = loadShapeDrawable(context, true);
            this.selectedDrawableCached = drawableLoadShapeDrawable;
            return drawableLoadShapeDrawable;
        }
        Drawable drawable2 = this.unselectedDrawableCached;
        if (drawable2 != null) {
            return drawable2;
        }
        Drawable drawableLoadShapeDrawable2 = loadShapeDrawable(context, false);
        this.unselectedDrawableCached = drawableLoadShapeDrawable2;
        return drawableLoadShapeDrawable2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Drawable loadShapeDrawable(Context context, boolean isSelected) {
        Drawable drawable;
        float opacityValue;
        String str = this.shape;
        if (str == null) {
            drawable = null;
        } else {
            int iHashCode = str.hashCode();
            if (iHashCode != -1221256979) {
                if (iHashCode != -874346147) {
                    if (iHashCode == 109757537 && str.equals(QuestionRatingShapeType.STARS)) {
                        drawable = ContextCompat.getDrawable(context, C8369R.drawable.ic_micro_star);
                    }
                } else if (str.equals(QuestionRatingShapeType.THUMBS)) {
                    drawable = ContextCompat.getDrawable(context, C8369R.drawable.ic_micro_thumb);
                }
            } else if (str.equals(QuestionRatingShapeType.HEARTS)) {
                drawable = ContextCompat.getDrawable(context, C8369R.drawable.ic_micro_heart);
            }
        }
        if (drawable == null) {
            return null;
        }
        if (isSelected) {
            opacityValue = MicroColorControlOpacity.ShapeSelected.getOpacityValue();
        } else {
            opacityValue = MicroColorControlOpacity.ShapeNotSelected.getOpacityValue();
        }
        ColorFilter colorFilterCreateBlendModeColorFilterCompat = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ColorHelper.getArgbValue(this.colorScheme.getAnswer(), opacityValue), BlendModeCompat.SRC_IN);
        Drawable drawableMutate = drawable.mutate();
        Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
        drawableMutate.setColorFilter(colorFilterCreateBlendModeColorFilterCompat);
        return drawableMutate;
    }
}

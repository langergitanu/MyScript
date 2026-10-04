package com.myscript.atk.p021ui;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes4.dex */
public final class SmartGuideUtils {
    private SmartGuideUtils() {
    }

    public static ValueAnimator expand(final View view, int i) {
        view.measure(-2, -2);
        int measuredHeight = view.getMeasuredHeight();
        view.setVisibility(0);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, measuredHeight);
        valueAnimatorOfInt.setDuration(i);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.myscript.atk.ui.SmartGuideUtils.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                view.getLayoutParams().height = num.intValue();
                view.requestLayout();
            }
        });
        return valueAnimatorOfInt;
    }

    public static ValueAnimator collapse(final View view, int i) {
        view.clearAnimation();
        view.measure(-2, -2);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(view.getMeasuredHeight(), 0);
        valueAnimatorOfInt.setDuration(i);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.myscript.atk.ui.SmartGuideUtils.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                view.getLayoutParams().height = num.intValue();
                view.requestLayout();
            }
        });
        return valueAnimatorOfInt;
    }

    public static String toTitleCase(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        boolean z = true;
        for (int i = 0; i < length; i++) {
            char cCharAt = sb.charAt(i);
            if (z) {
                if (!Character.isWhitespace(cCharAt)) {
                    sb.setCharAt(i, Character.toTitleCase(cCharAt));
                    z = false;
                }
            } else if (Character.isWhitespace(cCharAt)) {
                z = true;
            } else {
                sb.setCharAt(i, Character.toLowerCase(cCharAt));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int drawableFromShapeLabel(String str) {
        byte b;
        str.hashCode();
        switch (str.hashCode()) {
            case -2015892335:
                b = !str.equals("equilateral triangle") ? (byte) -1 : (byte) 0;
                break;
            case -1862350964:
                b = !str.equals("right triangle") ? (byte) -1 : (byte) 1;
                break;
            case -1656480802:
                b = !str.equals("ellipse") ? (byte) -1 : (byte) 2;
                break;
            case -1509580990:
                b = !str.equals("right isosceles triangle") ? (byte) -1 : (byte) 3;
                break;
            case -1360216880:
                b = !str.equals(TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE) ? (byte) -1 : (byte) 4;
                break;
            case -894674659:
                b = !str.equals("square") ? (byte) -1 : (byte) 5;
                break;
            case -431152390:
                b = !str.equals("double arrow") ? (byte) -1 : (byte) 6;
                break;
            case 3321844:
                b = !str.equals("line") ? (byte) -1 : (byte) 7;
                break;
            case 93090825:
                b = !str.equals("arrow") ? (byte) -1 : (byte) 8;
                break;
            case 375977662:
                b = !str.equals("isosceles triangle") ? (byte) -1 : (byte) 9;
                break;
            case 513358239:
                b = !str.equals("parallelogram") ? (byte) -1 : (byte) 10;
                break;
            case 1097591272:
                b = !str.equals("trapezoid") ? (byte) -1 : Ascii.f994VT;
                break;
            case 1114411065:
                b = !str.equals("quadrilateral") ? (byte) -1 : Ascii.f983FF;
                break;
            case 1121299823:
                b = !str.equals("rectangle") ? (byte) -1 : Ascii.f981CR;
                break;
            case 1179492204:
                b = !str.equals("rhombus") ? (byte) -1 : Ascii.f991SO;
                break;
            case 1497762312:
                b = !str.equals("triangle") ? (byte) -1 : Ascii.f990SI;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return C6033R.drawable.triangle_equilateral;
            case 1:
                return C6033R.drawable.triangle_rectangle;
            case 2:
                return C6033R.drawable.ellipse;
            case 3:
            case 9:
                return C6033R.drawable.triangle_isosceles;
            case 4:
                return C6033R.drawable.circle;
            case 5:
                return C6033R.drawable.square;
            case 6:
                return C6033R.drawable.double_arrow;
            case 7:
                return C6033R.drawable.line;
            case 8:
                return C6033R.drawable.arrow;
            case 10:
                return C6033R.drawable.parallelogram;
            case 11:
                return C6033R.drawable.trapezoid;
            case 12:
                return C6033R.drawable.quadrilateral;
            case 13:
                return C6033R.drawable.rectangle;
            case 14:
                return C6033R.drawable.rhombus;
            case 15:
                return C6033R.drawable.triangle;
            default:
                return -1;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int drawableFromShapeMenuLabel(String str) {
        byte b;
        str.hashCode();
        switch (str.hashCode()) {
            case -2015892335:
                b = !str.equals("equilateral triangle") ? (byte) -1 : (byte) 0;
                break;
            case -1862350964:
                b = !str.equals("right triangle") ? (byte) -1 : (byte) 1;
                break;
            case -1656480802:
                b = !str.equals("ellipse") ? (byte) -1 : (byte) 2;
                break;
            case -1509580990:
                b = !str.equals("right isosceles triangle") ? (byte) -1 : (byte) 3;
                break;
            case -1360216880:
                b = !str.equals(TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE) ? (byte) -1 : (byte) 4;
                break;
            case -894674659:
                b = !str.equals("square") ? (byte) -1 : (byte) 5;
                break;
            case -431152390:
                b = !str.equals("double arrow") ? (byte) -1 : (byte) 6;
                break;
            case 3321844:
                b = !str.equals("line") ? (byte) -1 : (byte) 7;
                break;
            case 93090825:
                b = !str.equals("arrow") ? (byte) -1 : (byte) 8;
                break;
            case 375977662:
                b = !str.equals("isosceles triangle") ? (byte) -1 : (byte) 9;
                break;
            case 513358239:
                b = !str.equals("parallelogram") ? (byte) -1 : (byte) 10;
                break;
            case 1097591272:
                b = !str.equals("trapezoid") ? (byte) -1 : Ascii.f994VT;
                break;
            case 1114411065:
                b = !str.equals("quadrilateral") ? (byte) -1 : Ascii.f983FF;
                break;
            case 1121299823:
                b = !str.equals("rectangle") ? (byte) -1 : Ascii.f981CR;
                break;
            case 1179492204:
                b = !str.equals("rhombus") ? (byte) -1 : Ascii.f991SO;
                break;
            case 1497762312:
                b = !str.equals("triangle") ? (byte) -1 : Ascii.f990SI;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return C6033R.drawable.triangle_equilateral_menu;
            case 1:
                return C6033R.drawable.triangle_rectangle_menu;
            case 2:
                return C6033R.drawable.ellipse_menu;
            case 3:
            case 9:
                return C6033R.drawable.triangle_isosceles_menu;
            case 4:
                return C6033R.drawable.circle_menu;
            case 5:
                return C6033R.drawable.square_menu;
            case 6:
                return C6033R.drawable.double_arrow_menu;
            case 7:
                return C6033R.drawable.line_menu;
            case 8:
                return C6033R.drawable.arrow_menu;
            case 10:
                return C6033R.drawable.parallelogram_menu;
            case 11:
                return C6033R.drawable.trapezoid_menu;
            case 12:
                return C6033R.drawable.quadrilateral_menu;
            case 13:
                return C6033R.drawable.rectangle_menu;
            case 14:
                return C6033R.drawable.rhombus_menu;
            case 15:
                return C6033R.drawable.triangle_menu;
            default:
                return -1;
        }
    }

    /* JADX INFO: renamed from: com.myscript.atk.ui.SmartGuideUtils$3 */
    static /* synthetic */ class C60443 {
        static final /* synthetic */ int[] $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport;

        static {
            int[] iArr = new int[PrompterShapeSupport.values().length];
            $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport = iArr;
            try {
                iArr[PrompterShapeSupport.Arc.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.Arrow.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.Circle.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.CurvedArrow.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.CurvedDoubleArrow.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.Drawing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.DoubleArrow.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.Ellipse.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.Line.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.Parallelogram.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.Polygon.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.Polyline.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.Rectangle.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.Rhombus.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.SetToText.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.SetToShape.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.Square.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.Triangle.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.DraftText.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[PrompterShapeSupport.DraftDrawing.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    public static int drawableFromPrompterShapeSupport(PrompterShapeSupport prompterShapeSupport, ShapeCandidate shapeCandidate) {
        if (prompterShapeSupport == null) {
            return -1;
        }
        switch (C60443.$SwitchMap$com$myscript$atk$ui$PrompterShapeSupport[prompterShapeSupport.ordinal()]) {
            case 11:
                if (shapeCandidate == null) {
                }
                break;
            case 18:
                if (shapeCandidate == null) {
                }
                break;
        }
        return -1;
    }
}

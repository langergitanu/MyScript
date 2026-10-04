package com.myscript.atk.p021ui;

/* JADX INFO: loaded from: classes4.dex */
public enum PrompterShapeSupport {
    None,
    Line,
    Arc,
    Arrow,
    CurvedArrow,
    DoubleArrow,
    CurvedDoubleArrow,
    Circle,
    Ellipse,
    Drawing,
    DraftText,
    DraftDrawing,
    Square,
    Rectangle,
    Polyline,
    Polygon,
    Parallelogram,
    Trapezoid,
    Quadrilateral,
    Rhombus,
    Triangle,
    RightTriangle,
    IsoscelesTriangle,
    RightIsoscelesTriangle,
    EquilateralTriangle,
    Multi,
    Doodle,
    SetToText,
    SetToShape,
    Count;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static PrompterShapeSupport swigToEnum(int i) {
        PrompterShapeSupport[] prompterShapeSupportArr = (PrompterShapeSupport[]) PrompterShapeSupport.class.getEnumConstants();
        if (i < prompterShapeSupportArr.length && i >= 0) {
            PrompterShapeSupport prompterShapeSupport = prompterShapeSupportArr[i];
            if (prompterShapeSupport.swigValue == i) {
                return prompterShapeSupport;
            }
        }
        for (PrompterShapeSupport prompterShapeSupport2 : prompterShapeSupportArr) {
            if (prompterShapeSupport2.swigValue == i) {
                return prompterShapeSupport2;
            }
        }
        throw new IllegalArgumentException("No enum " + PrompterShapeSupport.class + " with value " + i);
    }

    PrompterShapeSupport() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    PrompterShapeSupport(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    PrompterShapeSupport(PrompterShapeSupport prompterShapeSupport) {
        int i = prompterShapeSupport.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}

package androidx.compose.p004ui.graphics;

import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.graphics.PathSegment;
import androidx.compose.p004ui.graphics.vector.PathParser;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: PathSvg.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\f"}, m1599d2 = {"addSvg", "", "Landroidx/compose/ui/graphics/Path;", "pathData", "", "toSvg", "asDocument", "", "command", "type", "Landroidx/compose/ui/graphics/PathSegment$Type;", "lastType", "ui-graphics"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class PathSvgKt {

    /* JADX INFO: compiled from: PathSvg.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.Move.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathSegment.Type.Line.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PathSegment.Type.Conic.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PathSegment.Type.Cubic.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PathSegment.Type.Close.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PathSegment.Type.Done.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void addSvg(Path path, String str) {
        new PathParser().parsePathString(str).toPath(path);
    }

    public static final String toSvg(Path path, boolean z) {
        StringBuilder sb = new StringBuilder();
        Rect bounds = path.getBounds();
        if (z) {
            sb.append("<svg xmlns=\"http://www.w3.org/2000/svg\" ");
            sb.append("viewBox=\"" + bounds.getLeft() + TokenParser.f2383SP + bounds.getTop() + TokenParser.f2383SP + (bounds.getRight() - bounds.getLeft()) + TokenParser.f2383SP + (bounds.getBottom() - bounds.getTop()) + "\">").append('\n');
        }
        PathIterator it = path.iterator();
        float[] fArr = new float[8];
        PathSegment.Type type = PathSegment.Type.Done;
        if (it.hasNext()) {
            if (z) {
                if (PathFillType.m8442equalsimpl0(path.mo8036getFillTypeRgk1Os(), PathFillType.INSTANCE.m8446getEvenOddRgk1Os())) {
                    sb.append("  <path fill-rule=\"evenodd\" d=\"");
                } else {
                    sb.append("  <path d=\"");
                }
            }
            while (it.hasNext()) {
                PathSegment.Type typeNext$default = PathIterator.next$default(it, fArr, 0, 2, null);
                switch (WhenMappings.$EnumSwitchMapping$0[typeNext$default.ordinal()]) {
                    case 1:
                        sb.append(command(PathSegment.Type.Move, type) + fArr[0] + TokenParser.f2383SP + fArr[1]);
                        type = typeNext$default;
                        break;
                    case 2:
                        sb.append(command(PathSegment.Type.Line, type) + fArr[2] + TokenParser.f2383SP + fArr[3]);
                        type = typeNext$default;
                        break;
                    case 3:
                        sb.append(command(PathSegment.Type.Quadratic, type));
                        sb.append(new StringBuilder().append(fArr[2]).append(TokenParser.f2383SP).append(fArr[3]).append(TokenParser.f2383SP).append(fArr[4]).append(TokenParser.f2383SP).append(fArr[5]).toString());
                        type = typeNext$default;
                        break;
                    case 4:
                    case 7:
                        break;
                    case 5:
                        sb.append(command(PathSegment.Type.Cubic, type));
                        sb.append(new StringBuilder().append(fArr[2]).append(TokenParser.f2383SP).append(fArr[3]).append(TokenParser.f2383SP).toString());
                        sb.append(new StringBuilder().append(fArr[4]).append(TokenParser.f2383SP).append(fArr[5]).append(TokenParser.f2383SP).toString());
                        sb.append(new StringBuilder().append(fArr[6]).append(TokenParser.f2383SP).append(fArr[7]).toString());
                        type = typeNext$default;
                        break;
                    case 6:
                        sb.append(command(PathSegment.Type.Close, type));
                        type = typeNext$default;
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            if (z) {
                sb.append("\"/>\n");
            }
        }
        if (z) {
            sb.append("</svg>\n");
        }
        return sb.toString();
    }

    public static /* synthetic */ String toSvg$default(Path path, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toSvg(path, z);
    }

    private static final String command(PathSegment.Type type, PathSegment.Type type2) {
        if (type != type2) {
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                return "M";
            }
            if (i == 2) {
                return "L";
            }
            if (i == 3) {
                return "Q";
            }
            if (i == 5) {
                return "C";
            }
            if (i == 6) {
                return "Z";
            }
            return "";
        }
        return " ";
    }
}

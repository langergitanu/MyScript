package com.revenuecat.purchases.p036ui.revenuecatui.components.properties;

import android.graphics.Shader;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ShaderKt;
import androidx.compose.p004ui.graphics.TileMode;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorStyle.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001BO\u0012*\u0010\u0002\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR$\u0010\u000e\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/RadialGradient;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/GradientBrush;", "colorStops", "", "Lkotlin/Pair;", "", "Landroidx/compose/ui/graphics/Color;", TtmlNode.CENTER, "Landroidx/compose/ui/geometry/Offset;", "radius", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "([Lkotlin/Pair;JFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "colorStopsArray", "[Lkotlin/Pair;", "colors", "", "getColors$revenuecatui_defaultsRelease", "()Ljava/util/List;", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
final class RadialGradient extends GradientBrush {
    private final long center;
    private final Pair<Float, Color>[] colorStopsArray;
    private final List<Color> colors;
    private final float radius;
    private final int tileMode;

    public /* synthetic */ RadialGradient(Pair[] pairArr, long j, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pairArr, j, f, i);
    }

    public /* synthetic */ RadialGradient(Pair[] pairArr, long j, float f, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(pairArr, (i2 & 2) != 0 ? Offset.INSTANCE.m7918getUnspecifiedF1C5BW0() : j, (i2 & 4) != 0 ? Float.POSITIVE_INFINITY : f, (i2 & 8) != 0 ? TileMode.INSTANCE.m8545getClamp3opZhB0() : i, null);
    }

    private RadialGradient(Pair<Float, Color>[] colorStops, long j, float f, int i) {
        Intrinsics.checkNotNullParameter(colorStops, "colorStops");
        this.center = j;
        this.radius = f;
        this.tileMode = i;
        this.colorStopsArray = colorStops;
        ArrayList arrayList = new ArrayList(colorStops.length);
        for (Pair<Float, Color> pair : colorStops) {
            arrayList.add(Color.m8138boximpl(pair.getSecond().m8158unboximpl()));
        }
        this.colors = arrayList;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.properties.GradientBrush
    public List<Color> getColors$revenuecatui_defaultsRelease() {
        return this.colors;
    }

    @Override // androidx.compose.p004ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo8117createShaderuvyYCjk(long size) {
        long jM7982getCenteruvyYCjk;
        float fMax = this.radius;
        if (fMax == Float.POSITIVE_INFINITY) {
            fMax = Math.max(Size.m7972getWidthimpl(size), Size.m7969getHeightimpl(size)) / 2.0f;
        }
        float f = fMax;
        if (Offset.m7900equalsimpl0(this.center, Offset.INSTANCE.m7918getUnspecifiedF1C5BW0())) {
            jM7982getCenteruvyYCjk = SizeKt.m7982getCenteruvyYCjk(size);
        } else {
            jM7982getCenteruvyYCjk = this.center;
        }
        long j = jM7982getCenteruvyYCjk;
        Pair<Float, Color>[] pairArr = this.colorStopsArray;
        ArrayList arrayList = new ArrayList(pairArr.length);
        for (Pair<Float, Color> pair : pairArr) {
            arrayList.add(Color.m8138boximpl(pair.getSecond().m8158unboximpl()));
        }
        ArrayList arrayList2 = arrayList;
        Pair<Float, Color>[] pairArr2 = this.colorStopsArray;
        ArrayList arrayList3 = new ArrayList(pairArr2.length);
        for (Pair<Float, Color> pair2 : pairArr2) {
            arrayList3.add(Float.valueOf(pair2.getFirst().floatValue()));
        }
        return ShaderKt.m8486RadialGradientShader8uybcMk(j, f, arrayList2, arrayList3, this.tileMode);
    }

    public boolean equals(Object other) {
        if (!(other instanceof RadialGradient)) {
            return false;
        }
        RadialGradient radialGradient = (RadialGradient) other;
        return Arrays.equals(radialGradient.colorStopsArray, this.colorStopsArray) && Offset.m7900equalsimpl0(radialGradient.center, this.center) && radialGradient.radius == this.radius && TileMode.m8541equalsimpl0(radialGradient.tileMode, this.tileMode);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.colorStopsArray) * 31) + (Offset.m7905hashCodeimpl(this.center) * 31) + (Float.hashCode(this.radius) * 31) + TileMode.m8542hashCodeimpl(this.tileMode);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RadialGradient(colorStops=");
        String string = Arrays.toString(this.colorStopsArray);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return sb.append(string).append(')').toString();
    }
}

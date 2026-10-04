package androidx.media3.extractor.mp4;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.SniffFailure;
import com.google.common.primitives.ImmutableIntArray;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class UnsupportedBrandsSniffFailure implements SniffFailure {
    public final ImmutableIntArray compatibleBrands;
    public final int majorBrand;

    public UnsupportedBrandsSniffFailure(int i, int[] iArr) {
        ImmutableIntArray immutableIntArrayM919of;
        this.majorBrand = i;
        if (iArr != null) {
            immutableIntArrayM919of = ImmutableIntArray.copyOf(iArr);
        } else {
            immutableIntArrayM919of = ImmutableIntArray.m919of();
        }
        this.compatibleBrands = immutableIntArrayM919of;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(this.compatibleBrands.length());
        for (int i = 0; i < this.compatibleBrands.length(); i++) {
            arrayList.add(Util.toFourccString(this.compatibleBrands.get(i)));
        }
        return "UnsupportedBrands{major=" + Util.toFourccString(this.majorBrand) + ", compatible=" + arrayList + "}";
    }
}

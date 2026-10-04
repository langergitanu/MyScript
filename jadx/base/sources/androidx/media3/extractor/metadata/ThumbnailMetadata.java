package androidx.media3.extractor.metadata;

import androidx.media3.common.Metadata;
import com.google.common.primitives.Longs;
import com.pdftron.pdf.pdfa.PDFACompliance;

/* JADX INFO: loaded from: classes3.dex */
public final class ThumbnailMetadata implements Metadata.Entry {
    public final long presentationTimeUs;

    public ThumbnailMetadata(long j) {
        this.presentationTimeUs = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.presentationTimeUs == ((ThumbnailMetadata) obj).presentationTimeUs;
    }

    public int hashCode() {
        return PDFACompliance.e_PDFA5_2_7 + Longs.hashCode(this.presentationTimeUs);
    }

    public String toString() {
        return "ThumbnailMetadata: presentationTimeUs=" + this.presentationTimeUs;
    }
}

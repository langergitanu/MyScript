package androidx.media3.extractor.metadata.id3;

import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class BinaryFrame extends Id3Frame {
    public final byte[] data;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.data = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BinaryFrame binaryFrame = (BinaryFrame) obj;
            if (this.f358id.equals(binaryFrame.f358id) && Arrays.equals(this.data, binaryFrame.data)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((PDFACompliance.e_PDFA5_2_7 + this.f358id.hashCode()) * 31) + Arrays.hashCode(this.data);
    }
}

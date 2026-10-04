package androidx.media3.extractor.metadata.id3;

import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class CommentFrame extends Id3Frame {

    /* JADX INFO: renamed from: ID */
    public static final String f356ID = "COMM";
    public final String description;
    public final String language;
    public final String text;

    public CommentFrame(String str, String str2, String str3) {
        super(f356ID);
        this.language = str;
        this.description = str2;
        this.text = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CommentFrame commentFrame = (CommentFrame) obj;
            if (Objects.equals(this.description, commentFrame.description) && Objects.equals(this.language, commentFrame.language) && Objects.equals(this.text, commentFrame.text)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.language;
        int iHashCode = (PDFACompliance.e_PDFA5_2_7 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public String toString() {
        return this.f358id + ": language=" + this.language + ", description=" + this.description + ", text=" + this.text;
    }
}

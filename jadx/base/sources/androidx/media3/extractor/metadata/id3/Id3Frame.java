package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.Metadata;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Id3Frame implements Metadata.Entry {

    /* JADX INFO: renamed from: id */
    public final String f358id;

    public Id3Frame(String str) {
        this.f358id = str;
    }

    public String toString() {
        return this.f358id;
    }
}

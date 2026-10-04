package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.ObjSet;

/* JADX INFO: loaded from: classes7.dex */
public class ViewerOptimizedOptions {
    public static final int e_op_off = 0;
    public static final int e_op_on = 1;
    public static final int e_op_pdfx_on = 2;

    /* JADX INFO: renamed from: a */
    Obj f2100a;

    /* JADX INFO: renamed from: b */
    private ObjSet f2101b;

    public ViewerOptimizedOptions() {
        try {
            ObjSet objSet = new ObjSet();
            this.f2101b = objSet;
            this.f2100a = objSet.createDict();
        } catch (PDFNetException unused) {
            System.err.println("Error Occurred when creating ViewerOptimizedOptions.");
        }
    }

    public void setThumbnailRenderingThreshold(int i) throws PDFNetException {
        this.f2100a.putNumber("COMPLEXITY_THRESHOLD", i);
    }

    public void setMinimumInitialThumbnails(int i) throws PDFNetException {
        this.f2100a.putNumber("MINIMUM_INITIAL_THUMBNAILS", i);
    }

    public void setThumbnailSize(int i) throws PDFNetException {
        this.f2100a.putNumber("THUMB_SIZE", i);
    }

    public void setOverprint(int i) throws PDFNetException {
        if (i == 0) {
            this.f2100a.putName("OVERPRINT_MODE", "OFF");
        } else if (i == 1) {
            this.f2100a.putName("OVERPRINT_MODE", "ON");
        } else {
            if (i != 2) {
                return;
            }
            this.f2100a.putName("OVERPRINT_MODE", "PDFX");
        }
    }
}

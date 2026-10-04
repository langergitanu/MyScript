package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class BarcodeOptions extends OptionsBase {

    public static final class BarcodeOrientation {
        public static final int e_diagonal = 4;
        public static final int e_horizontal = 1;
        public static final int e_vertical = 2;
    }

    public static final class BarcodeTypeGroup {
        public static final int e_aztec = 64;
        public static final int e_data_matrix = 32;
        public static final int e_four_state = 4;
        public static final int e_gs1_databar_stacked = 8;
        public static final int e_linear = 1;
        public static final int e_maxi = 128;
        public static final int e_micro_pdf417 = 1024;
        public static final int e_micro_qr = 256;
        public static final int e_none = 0;
        public static final int e_patch_code = 2048;
        public static final int e_pdf417 = 512;
        public static final int e_pharma_code = 4096;
        public static final int e_post_net_planet = 2;
        public static final int e_qr = 16;
    }

    public enum BarcodeProfile {
        e_high_quality_source_profile(1),
        e_low_quality_source_profile(2),
        e_small_barcodes_profile(3),
        e_natural_picture_profile(4);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, BarcodeProfile> f1442b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1444a;

        static {
            for (BarcodeProfile barcodeProfile : values()) {
                f1442b.put(Integer.valueOf(barcodeProfile.f1444a), barcodeProfile);
            }
        }

        BarcodeProfile(int i) {
            this.f1444a = i;
        }

        /* JADX INFO: renamed from: a */
        static BarcodeProfile m1135a(int i) {
            return f1442b.get(Integer.valueOf(i));
        }
    }

    public enum OutputFormat {
        e_auto(0),
        e_binary(1);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, OutputFormat> f1445b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1447a;

        static {
            for (OutputFormat outputFormat : values()) {
                f1445b.put(Integer.valueOf(outputFormat.f1447a), outputFormat);
            }
        }

        OutputFormat(int i) {
            this.f1447a = i;
        }

        /* JADX INFO: renamed from: a */
        static OutputFormat m1136a(int i) {
            return f1445b.get(Integer.valueOf(i));
        }
    }

    public BarcodeOptions() throws PDFNetException {
    }

    public BarcodeOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public int getBarcodeOrientations() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("BarcodeOrientations");
        if (objFindObj == null || objFindObj.isNull()) {
            return Integer.MAX_VALUE;
        }
        return (int) objFindObj.getNumber();
    }

    public BarcodeOptions setBarcodeOrientations(int i) throws PDFNetException {
        putNumber("BarcodeOrientations", i);
        return this;
    }

    public BarcodeProfile getBarcodeProfile() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("BarcodeProfile");
        if (objFindObj != null && !objFindObj.isNull()) {
            return BarcodeProfile.m1135a((int) objFindObj.getNumber());
        }
        return BarcodeProfile.m1135a(1);
    }

    public BarcodeOptions setBarcodeProfile(BarcodeProfile barcodeProfile) throws PDFNetException {
        putNumber("BarcodeProfile", barcodeProfile.f1444a);
        return this;
    }

    public int getBarcodeSearchTypes() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("BarcodeSearchTypes");
        if (objFindObj == null || objFindObj.isNull()) {
            return Integer.MAX_VALUE;
        }
        return (int) objFindObj.getNumber();
    }

    public BarcodeOptions setBarcodeSearchTypes(int i) throws PDFNetException {
        putNumber("BarcodeSearchTypes", i);
        return this;
    }

    public OutputFormat getDataOutputFormat() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DataOutputFormat");
        if (objFindObj != null && !objFindObj.isNull()) {
            return OutputFormat.m1136a((int) objFindObj.getNumber());
        }
        return OutputFormat.m1136a(0);
    }

    public BarcodeOptions setDataOutputFormat(OutputFormat outputFormat) throws PDFNetException {
        putNumber("DataOutputFormat", outputFormat.f1447a);
        return this;
    }

    public String getPages() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Pages");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public BarcodeOptions setPages(String str) throws PDFNetException {
        putText("Pages", str);
        return this;
    }
}

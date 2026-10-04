package com.pdftron.pdf.pdfa;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.PDFDoc;

/* JADX INFO: loaded from: classes7.dex */
public class PDFACompliance implements AutoCloseable {
    public static final int e_Level1A = 1;
    public static final int e_Level1B = 2;
    public static final int e_Level2A = 3;
    public static final int e_Level2B = 4;
    public static final int e_Level2U = 5;
    public static final int e_Level3A = 6;
    public static final int e_Level3B = 7;
    public static final int e_Level3U = 8;
    public static final int e_Level4 = 9;
    public static final int e_Level4E = 10;
    public static final int e_Level4F = 11;
    public static final int e_PDFA0_1_0 = 10;
    public static final int e_PDFA0_1_1 = 11;
    public static final int e_PDFA0_1_2 = 12;
    public static final int e_PDFA0_1_3 = 13;
    public static final int e_PDFA0_1_4 = 14;
    public static final int e_PDFA0_1_5 = 15;
    public static final int e_PDFA11_0_0 = 11000;
    public static final int e_PDFA1_10_1 = 1101;
    public static final int e_PDFA1_10_2 = 1102;
    public static final int e_PDFA1_10_3 = 1103;
    public static final int e_PDFA1_11_1 = 1111;
    public static final int e_PDFA1_11_2 = 1112;
    public static final int e_PDFA1_12_1 = 1121;
    public static final int e_PDFA1_12_10 = 11210;
    public static final int e_PDFA1_12_11 = 11211;
    public static final int e_PDFA1_12_12 = 11212;
    public static final int e_PDFA1_12_13 = 11213;
    public static final int e_PDFA1_12_14 = 11214;
    public static final int e_PDFA1_12_15 = 11215;
    public static final int e_PDFA1_12_2 = 1122;
    public static final int e_PDFA1_12_3 = 1123;
    public static final int e_PDFA1_12_4 = 1124;
    public static final int e_PDFA1_12_5 = 1125;
    public static final int e_PDFA1_12_6 = 1126;
    public static final int e_PDFA1_12_7 = 1127;
    public static final int e_PDFA1_12_8 = 1128;
    public static final int e_PDFA1_12_9 = 1129;
    public static final int e_PDFA1_13_1 = 1131;
    public static final int e_PDFA1_13_5 = 1135;
    public static final int e_PDFA1_2_1 = 121;
    public static final int e_PDFA1_2_2 = 122;
    public static final int e_PDFA1_2_3 = 123;
    public static final int e_PDFA1_3_1 = 131;
    public static final int e_PDFA1_3_2 = 132;
    public static final int e_PDFA1_3_3 = 133;
    public static final int e_PDFA1_3_4 = 134;
    public static final int e_PDFA1_3_5 = 135;
    public static final int e_PDFA1_4_1 = 141;
    public static final int e_PDFA1_4_2 = 142;
    public static final int e_PDFA1_6_1 = 161;
    public static final int e_PDFA1_7_1 = 171;
    public static final int e_PDFA1_7_2 = 172;
    public static final int e_PDFA1_7_3 = 173;
    public static final int e_PDFA1_7_4 = 174;
    public static final int e_PDFA1_8_1 = 181;
    public static final int e_PDFA1_8_2 = 182;
    public static final int e_PDFA1_8_3 = 183;
    public static final int e_PDFA1_8_4 = 184;
    public static final int e_PDFA1_8_5 = 185;
    public static final int e_PDFA1_8_6 = 186;
    public static final int e_PDFA1_8_7 = 187;
    public static final int e_PDFA2_10_1 = 2101;
    public static final int e_PDFA2_10_20 = 21020;
    public static final int e_PDFA2_10_21 = 21021;
    public static final int e_PDFA2_2_1 = 221;
    public static final int e_PDFA2_3_10 = 2310;
    public static final int e_PDFA2_3_2 = 232;
    public static final int e_PDFA2_3_3 = 233;
    public static final int e_PDFA2_3_3_1 = 2331;
    public static final int e_PDFA2_3_3_2 = 2332;
    public static final int e_PDFA2_3_4_1 = 2341;
    public static final int e_PDFA2_4_1 = 241;
    public static final int e_PDFA2_4_2 = 242;
    public static final int e_PDFA2_4_2_10 = 24210;
    public static final int e_PDFA2_4_2_11 = 24211;
    public static final int e_PDFA2_4_2_12 = 24212;
    public static final int e_PDFA2_4_2_13 = 24213;
    public static final int e_PDFA2_4_3 = 243;
    public static final int e_PDFA2_4_4 = 244;
    public static final int e_PDFA2_5_1 = 251;
    public static final int e_PDFA2_5_10 = 2510;
    public static final int e_PDFA2_5_11 = 2511;
    public static final int e_PDFA2_5_12 = 2512;
    public static final int e_PDFA2_5_2 = 252;
    public static final int e_PDFA2_6_1 = 261;
    public static final int e_PDFA2_7_1 = 271;
    public static final int e_PDFA2_8_1 = 281;
    public static final int e_PDFA2_8_3_1 = 2831;
    public static final int e_PDFA2_8_3_2 = 2832;
    public static final int e_PDFA2_8_3_3 = 2833;
    public static final int e_PDFA2_8_3_4 = 2834;
    public static final int e_PDFA2_8_3_5 = 2835;
    public static final int e_PDFA2_9_1 = 291;
    public static final int e_PDFA3_2_1 = 321;
    public static final int e_PDFA3_2_2 = 322;
    public static final int e_PDFA3_2_3 = 323;
    public static final int e_PDFA3_2_4 = 324;
    public static final int e_PDFA3_2_5 = 325;
    public static final int e_PDFA3_2_6 = 326;
    public static final int e_PDFA3_2_7 = 327;
    public static final int e_PDFA3_3_1 = 331;
    public static final int e_PDFA3_3_2 = 332;
    public static final int e_PDFA3_3_3_1 = 3331;
    public static final int e_PDFA3_3_3_2 = 3332;
    public static final int e_PDFA3_3_4 = 334;
    public static final int e_PDFA3_4_1 = 341;
    public static final int e_PDFA3_5_1 = 351;
    public static final int e_PDFA3_5_2 = 352;
    public static final int e_PDFA3_5_3 = 353;
    public static final int e_PDFA3_5_4 = 354;
    public static final int e_PDFA3_5_5 = 355;
    public static final int e_PDFA3_5_6 = 356;
    public static final int e_PDFA3_5_7 = 357;
    public static final int e_PDFA3_6_1 = 361;
    public static final int e_PDFA3_7_1 = 371;
    public static final int e_PDFA3_7_2 = 372;
    public static final int e_PDFA3_7_3 = 373;
    public static final int e_PDFA3_8_1 = 381;
    public static final int e_PDFA4_1 = 41;
    public static final int e_PDFA4_2 = 42;
    public static final int e_PDFA4_3 = 43;
    public static final int e_PDFA4_4 = 44;
    public static final int e_PDFA4_5 = 45;
    public static final int e_PDFA4_6 = 46;
    public static final int e_PDFA5_2_1 = 521;
    public static final int e_PDFA5_2_10 = 5210;
    public static final int e_PDFA5_2_11 = 5211;
    public static final int e_PDFA5_2_12 = 5212;
    public static final int e_PDFA5_2_2 = 522;
    public static final int e_PDFA5_2_3 = 523;
    public static final int e_PDFA5_2_4 = 524;
    public static final int e_PDFA5_2_5 = 525;
    public static final int e_PDFA5_2_6 = 526;
    public static final int e_PDFA5_2_7 = 527;
    public static final int e_PDFA5_2_8 = 528;
    public static final int e_PDFA5_2_9 = 529;
    public static final int e_PDFA5_3_1 = 531;
    public static final int e_PDFA5_3_2_1 = 5321;
    public static final int e_PDFA5_3_2_2 = 5322;
    public static final int e_PDFA5_3_2_3 = 5323;
    public static final int e_PDFA5_3_2_4 = 5324;
    public static final int e_PDFA5_3_2_5 = 5325;
    public static final int e_PDFA5_3_3_1 = 5331;
    public static final int e_PDFA5_3_3_2 = 5332;
    public static final int e_PDFA5_3_3_3 = 5333;
    public static final int e_PDFA5_3_3_4 = 5334;
    public static final int e_PDFA5_3_4_1 = 5341;
    public static final int e_PDFA5_3_4_2 = 5342;
    public static final int e_PDFA5_3_4_3 = 5343;
    public static final int e_PDFA6_10_0 = 6100;
    public static final int e_PDFA6_10_1 = 6101;
    public static final int e_PDFA6_1_1 = 611;
    public static final int e_PDFA6_1_2 = 612;
    public static final int e_PDFA6_2_1 = 621;
    public static final int e_PDFA6_2_11_3_3 = 621133;
    public static final int e_PDFA6_2_11_5 = 62115;
    public static final int e_PDFA6_2_11_6 = 62116;
    public static final int e_PDFA6_2_11_7 = 62117;
    public static final int e_PDFA6_2_11_8 = 62118;
    public static final int e_PDFA6_2_2 = 622;
    public static final int e_PDFA6_2_3 = 623;
    public static final int e_PDFA6_9_1 = 69001;
    public static final int e_PDFA6_9_3 = 69003;
    public static final int e_PDFA7_11_1 = 7111;
    public static final int e_PDFA7_11_2 = 7112;
    public static final int e_PDFA7_11_3 = 7113;
    public static final int e_PDFA7_11_4 = 7114;
    public static final int e_PDFA7_11_5 = 7115;
    public static final int e_PDFA7_2_1 = 721;
    public static final int e_PDFA7_2_2 = 722;
    public static final int e_PDFA7_2_3 = 723;
    public static final int e_PDFA7_2_4 = 724;
    public static final int e_PDFA7_2_5 = 725;
    public static final int e_PDFA7_3_1 = 731;
    public static final int e_PDFA7_3_2 = 732;
    public static final int e_PDFA7_3_3 = 733;
    public static final int e_PDFA7_3_4 = 734;
    public static final int e_PDFA7_3_5 = 735;
    public static final int e_PDFA7_3_6 = 736;
    public static final int e_PDFA7_3_7 = 737;
    public static final int e_PDFA7_3_8 = 738;
    public static final int e_PDFA7_3_9 = 739;
    public static final int e_PDFA7_5_1 = 751;
    public static final int e_PDFA7_8_1 = 781;
    public static final int e_PDFA7_8_10 = 7810;
    public static final int e_PDFA7_8_11 = 7811;
    public static final int e_PDFA7_8_12 = 7812;
    public static final int e_PDFA7_8_13 = 7813;
    public static final int e_PDFA7_8_14 = 7814;
    public static final int e_PDFA7_8_15 = 7815;
    public static final int e_PDFA7_8_16 = 7816;
    public static final int e_PDFA7_8_17 = 7817;
    public static final int e_PDFA7_8_18 = 7818;
    public static final int e_PDFA7_8_19 = 7819;
    public static final int e_PDFA7_8_2 = 782;
    public static final int e_PDFA7_8_20 = 7820;
    public static final int e_PDFA7_8_21 = 7821;
    public static final int e_PDFA7_8_22 = 7822;
    public static final int e_PDFA7_8_23 = 7823;
    public static final int e_PDFA7_8_24 = 7824;
    public static final int e_PDFA7_8_25 = 7825;
    public static final int e_PDFA7_8_26 = 7826;
    public static final int e_PDFA7_8_27 = 7827;
    public static final int e_PDFA7_8_28 = 7828;
    public static final int e_PDFA7_8_29 = 7829;
    public static final int e_PDFA7_8_3 = 783;
    public static final int e_PDFA7_8_30 = 7830;
    public static final int e_PDFA7_8_31 = 7831;
    public static final int e_PDFA7_8_4 = 784;
    public static final int e_PDFA7_8_5 = 785;
    public static final int e_PDFA7_8_6 = 786;
    public static final int e_PDFA7_8_7 = 787;
    public static final int e_PDFA7_8_8 = 788;
    public static final int e_PDFA7_8_9 = 789;
    public static final int e_PDFA8_1 = 81;
    public static final int e_PDFA8_2_2 = 822;
    public static final int e_PDFA8_3_3_1 = 8331;
    public static final int e_PDFA8_3_3_2 = 8332;
    public static final int e_PDFA8_3_4_1 = 8341;
    public static final int e_PDFA8_4_1 = 841;
    public static final int e_PDFA9_1 = 91;
    public static final int e_PDFA9_2 = 92;
    public static final int e_PDFA9_3 = 93;
    public static final int e_PDFA9_4 = 94;
    public static final int e_PDFA9_5 = 95;
    public static final int e_PDFA_3E1 = 1;
    public static final int e_PDFA_3E1_1 = 101;
    public static final int e_PDFA_3E2 = 2;
    public static final int e_PDFA_3E3 = 3;
    public static final int e_PDFA_4_6_1_12_1 = 461121;
    public static final int e_PDFA_4_6_1_3_4 = 46134;
    public static final int e_PDFA_4_6_1_3_5 = 46135;
    public static final int e_PDFA_4_6_1_6_1_3 = 461613;
    public static final int e_PDFA_4_6_2_10_6_1 = 4621061;
    public static final int e_PDFA_4_6_2_10_6_4 = 4621064;
    public static final int e_PDFA_4_6_2_10_8_1 = 4621081;
    public static final int e_PDFA_4_6_2_2_3 = 46223;
    public static final int e_PDFA_4_6_2_4_2_3 = 462423;
    public static final int e_PDFA_4_6_2_5_3 = 46253;
    public static final int e_PDFA_4_6_3_1_6 = 46316;
    public static final int e_PDFA_4_6_6_3_1 = 46631;
    public static final int e_PDFA_4_6_7_3_5 = 46735;
    public static final int e_PDFA_4_6_9_5 = 4695;

    /* JADX INFO: renamed from: a */
    private long f2159a;

    static native void Destroy(long j);

    static native int GetDeclaredConformance(long j);

    static native int GetError(long j, int i);

    static native int GetErrorCount(long j);

    static native String GetPDFAErrorMessage(int i);

    static native int GetRefObj(long j, int i, int i2);

    static native int GetRefObjCount(long j, int i);

    static native long PDFAComplianceCreate(boolean z, String str, long j);

    static native long PDFAComplianceCreate(boolean z, String str, String str2, int i, int[] iArr, int i2, int i3);

    static native long PDFAComplianceCreate(boolean z, String str, String str2, int i, int[] iArr, int i2, int i3, boolean z2);

    static native long PDFAComplianceCreate(boolean z, String str, String str2, int[] iArr, int i);

    static native long PDFAComplianceCreate(boolean z, byte[] bArr, int i, long j);

    static native long PDFAComplianceCreate(boolean z, byte[] bArr, int i, String str, int i2, int[] iArr, int i3, int i4);

    static native long PDFAComplianceCreate(boolean z, byte[] bArr, int i, String str, int i2, int[] iArr, int i3, int i4, boolean z2);

    static native long PDFAComplianceCreate(boolean z, byte[] bArr, int i, String str, int[] iArr, int i2);

    static native void Save(long j, String str, boolean z);

    static native byte[] Save(long j, boolean z);

    public PDFACompliance(boolean z, String str, PDFAOptions pDFAOptions) throws PDFNetException {
        this.f2159a = PDFAComplianceCreate(z, str, pDFAOptions.m1538a());
        ReachabilityHelper.ensureReachable(pDFAOptions);
    }

    public PDFACompliance(boolean z, byte[] bArr, PDFAOptions pDFAOptions) throws PDFNetException {
        this.f2159a = PDFAComplianceCreate(z, bArr, bArr == null ? 0 : bArr.length, pDFAOptions.m1538a());
        ReachabilityHelper.ensureReachable(pDFAOptions);
    }

    public PDFACompliance(boolean z, String str, String str2, int i, int[] iArr, int i2, boolean z2) throws PDFNetException {
        this.f2159a = PDFAComplianceCreate(z, str, str2, i, iArr, iArr == null ? 0 : iArr.length, i2, z2);
    }

    public PDFACompliance(boolean z, String str, String str2, int i, int[] iArr, int i2) throws PDFNetException {
        this.f2159a = PDFAComplianceCreate(z, str, str2, i, iArr, iArr == null ? 0 : iArr.length, i2);
    }

    public PDFACompliance(boolean z, String str, String str2, int[] iArr) throws PDFNetException {
        this.f2159a = PDFAComplianceCreate(z, str, str2, iArr, iArr == null ? 0 : iArr.length);
    }

    public PDFACompliance(boolean z, byte[] bArr, String str, int i, int[] iArr, int i2, boolean z2) throws PDFNetException {
        this.f2159a = PDFAComplianceCreate(z, bArr, bArr != null ? bArr.length : 0, str, i, iArr, iArr == null ? 0 : iArr.length, i2, z2);
    }

    public PDFACompliance(boolean z, byte[] bArr, String str, int i, int[] iArr, int i2) throws PDFNetException {
        this.f2159a = PDFAComplianceCreate(z, bArr, bArr != null ? bArr.length : 0, str, i, iArr, iArr == null ? 0 : iArr.length, i2);
    }

    public PDFACompliance(boolean z, byte[] bArr, String str, int[] iArr) throws PDFNetException {
        this.f2159a = PDFAComplianceCreate(z, bArr, bArr != null ? bArr.length : 0, str, iArr, iArr == null ? 0 : iArr.length);
    }

    public void saveAs(String str, boolean z) throws PDFNetException {
        Save(this.f2159a, str, z);
    }

    public byte[] saveAs(boolean z) throws PDFNetException {
        return Save(this.f2159a, z);
    }

    public int getErrorCount() throws PDFNetException {
        return GetErrorCount(this.f2159a);
    }

    public int getError(int i) throws PDFNetException {
        return GetError(this.f2159a, i);
    }

    public int getRefObjCount(int i) throws PDFNetException {
        return GetRefObjCount(this.f2159a, i);
    }

    public int getRefObj(int i, int i2) throws PDFNetException {
        return GetRefObj(this.f2159a, i, i2);
    }

    public static String getPDFAErrorMessage(int i) throws PDFNetException {
        return GetPDFAErrorMessage(i);
    }

    public static int getDeclaredConformance(PDFDoc pDFDoc) throws PDFNetException {
        int iGetDeclaredConformance = GetDeclaredConformance(pDFDoc.__GetHandle());
        ReachabilityHelper.ensureReachable(pDFDoc);
        return iGetDeclaredConformance;
    }

    public void destroy() {
        long j = this.f2159a;
        if (j != 0) {
            Destroy(j);
            this.f2159a = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}

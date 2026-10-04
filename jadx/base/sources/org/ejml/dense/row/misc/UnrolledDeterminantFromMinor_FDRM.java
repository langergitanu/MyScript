package org.ejml.dense.row.misc;

import org.ejml.data.FMatrix1Row;

/* JADX INFO: loaded from: classes9.dex */
public class UnrolledDeterminantFromMinor_FDRM {
    public static final int MAX = 6;

    public static float det(FMatrix1Row fMatrix1Row) {
        int i = fMatrix1Row.numRows;
        if (i == 2) {
            return det2(fMatrix1Row);
        }
        if (i == 3) {
            return det3(fMatrix1Row);
        }
        if (i == 4) {
            return det4(fMatrix1Row);
        }
        if (i == 5) {
            return det5(fMatrix1Row);
        }
        if (i == 6) {
            return det6(fMatrix1Row);
        }
        throw new IllegalArgumentException("Not supported");
    }

    public static float det2(FMatrix1Row fMatrix1Row) {
        float[] fArr = fMatrix1Row.data;
        return (fArr[0] * fArr[3]) - (fArr[1] * fArr[2]);
    }

    public static float det3(FMatrix1Row fMatrix1Row) {
        float[] fArr = fMatrix1Row.data;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        float f9 = fArr[8];
        return ((f * ((f5 * f9) - (f6 * f8))) - (f2 * ((f9 * f4) - (f6 * f7)))) + (f3 * ((f4 * f8) - (f7 * f5)));
    }

    public static float det4(FMatrix1Row fMatrix1Row) {
        float[] fArr = fMatrix1Row.data;
        float f = fArr[5];
        float f2 = fArr[6];
        float f3 = fArr[7];
        float f4 = fArr[9];
        float f5 = fArr[10];
        float f6 = fArr[11];
        float f7 = fArr[13];
        float f8 = fArr[14];
        float f9 = fArr[15];
        float f10 = (f5 * f9) - (f6 * f8);
        float f11 = (fArr[0] * (((f * f10) - (((f4 * f9) - (f6 * f7)) * f2)) + (((f4 * f8) - (f5 * f7)) * f3))) + 0.0f;
        float f12 = fArr[4];
        float f13 = fArr[8];
        float f14 = fArr[12];
        float f15 = (f13 * f9) - (f6 * f14);
        float f16 = (((f9 * f4) - (f6 * f7)) * f12) - (f15 * f);
        float f17 = (f13 * f7) - (f4 * f14);
        return ((f11 - (fArr[1] * (((f10 * f12) - (f2 * f15)) + (((f13 * f8) - (f5 * f14)) * f3)))) + (fArr[2] * (f16 + (f3 * f17)))) - (fArr[3] * (((f12 * ((f4 * f8) - (f7 * f5))) - (f * ((f13 * f8) - (f5 * f14)))) + (f2 * f17)));
    }

    public static float det5(FMatrix1Row fMatrix1Row) {
        float[] fArr = fMatrix1Row.data;
        float f = fArr[6];
        float f2 = fArr[7];
        float f3 = fArr[8];
        float f4 = fArr[9];
        float f5 = fArr[11];
        float f6 = fArr[12];
        float f7 = fArr[13];
        float f8 = fArr[14];
        float f9 = fArr[16];
        float f10 = fArr[17];
        float f11 = fArr[18];
        float f12 = fArr[19];
        float f13 = fArr[21];
        float f14 = fArr[22];
        float f15 = fArr[23];
        float f16 = fArr[24];
        float f17 = (f11 * f16) - (f12 * f15);
        float f18 = (f10 * f16) - (f12 * f14);
        float f19 = (f10 * f15) - (f11 * f14);
        float f20 = ((f6 * f17) - (f7 * f18)) + (f8 * f19);
        float f21 = (f9 * f16) - (f12 * f13);
        float f22 = (f9 * f15) - (f11 * f13);
        float f23 = (f * f20) - ((((f5 * f17) - (f7 * f21)) + (f8 * f22)) * f2);
        float f24 = (f5 * f18) - (f21 * f6);
        float f25 = (f9 * f14) - (f10 * f13);
        float f26 = (fArr[0] * ((f23 + ((f24 + (f8 * f25)) * f3)) - ((((f5 * f19) - (f22 * f6)) + (f25 * f7)) * f4))) + 0.0f;
        float f27 = fArr[5];
        float f28 = fArr[10];
        float f29 = fArr[15];
        float f30 = fArr[20];
        float f31 = (f29 * f16) - (f12 * f30);
        float f32 = (f29 * f15) - (f11 * f30);
        float f33 = ((f28 * f17) - (f7 * f31)) + (f8 * f32);
        float f34 = (f29 * f14) - (f10 * f30);
        float f35 = f26 - (fArr[1] * ((((f20 * f27) - (f2 * f33)) + ((((f18 * f28) - (f6 * f31)) + (f8 * f34)) * f3)) - ((((f19 * f28) - (f6 * f32)) + (f34 * f7)) * f4)));
        float f36 = (f9 * f16) - (f12 * f13);
        float f37 = (f9 * f15) - (f11 * f13);
        float f38 = ((((f17 * f5) - (f7 * f36)) + (f8 * f37)) * f27) - (f33 * f);
        float f39 = (f29 * f13) - (f9 * f30);
        float f40 = ((f28 * f36) - (f5 * f31)) + (f8 * f39);
        float f41 = (f16 * f10) - (f12 * f14);
        float f42 = (f9 * f14) - (f10 * f13);
        float f43 = (((f5 * f41) - (f36 * f6)) + (f8 * f42)) * f27;
        float f44 = (f29 * f14) - (f10 * f30);
        float f45 = (f43 - ((((f41 * f28) - (f31 * f6)) + (f8 * f44)) * f)) + (f40 * f2);
        float f46 = ((f28 * f42) - (f5 * f44)) + (f6 * f39);
        float f47 = (f10 * f15) - (f14 * f11);
        float f48 = (f9 * f15) - (f13 * f11);
        float f49 = (f29 * f15) - (f11 * f30);
        return ((f35 + (fArr[2] * ((f38 + (f3 * f40)) - ((((f37 * f28) - (f32 * f5)) + (f7 * f39)) * f4)))) - (fArr[3] * (f45 - (f4 * f46)))) + (fArr[4] * ((((f27 * (((f5 * f47) - (f6 * f48)) + (f42 * f7))) - (f * (((f47 * f28) - (f6 * f49)) + (f44 * f7)))) + (f2 * (((f28 * f48) - (f5 * f49)) + (f7 * f39)))) - (f3 * f46)));
    }

    public static float det6(FMatrix1Row fMatrix1Row) {
        float[] fArr = fMatrix1Row.data;
        float f = fArr[7];
        float f2 = fArr[8];
        float f3 = fArr[9];
        float f4 = fArr[10];
        float f5 = fArr[11];
        float f6 = fArr[13];
        float f7 = fArr[14];
        float f8 = fArr[15];
        float f9 = fArr[16];
        float f10 = fArr[17];
        float f11 = fArr[19];
        float f12 = fArr[20];
        float f13 = fArr[21];
        float f14 = fArr[22];
        float f15 = fArr[23];
        float f16 = fArr[25];
        float f17 = fArr[26];
        float f18 = fArr[27];
        float f19 = fArr[28];
        float f20 = fArr[29];
        float f21 = fArr[31];
        float f22 = fArr[32];
        float f23 = fArr[33];
        float f24 = fArr[34];
        float f25 = fArr[35];
        float f26 = (f19 * f25) - (f20 * f24);
        float f27 = (f18 * f25) - (f20 * f23);
        float f28 = (f18 * f24) - (f19 * f23);
        float f29 = ((f13 * f26) - (f14 * f27)) + (f15 * f28);
        float f30 = (f17 * f25) - (f20 * f22);
        float f31 = (f17 * f24) - (f19 * f22);
        float f32 = ((f12 * f26) - (f14 * f30)) + (f15 * f31);
        float f33 = (f17 * f23) - (f18 * f22);
        float f34 = ((f12 * f27) - (f13 * f30)) + (f15 * f33);
        float f35 = ((f12 * f28) - (f13 * f31)) + (f14 * f33);
        float f36 = (((f7 * f29) - (f8 * f32)) + (f9 * f34)) - (f10 * f35);
        float f37 = (f16 * f25) - (f20 * f21);
        float f38 = (f16 * f24) - (f19 * f21);
        float f39 = ((f11 * f26) - (f14 * f37)) + (f15 * f38);
        float f40 = (f16 * f23) - (f18 * f21);
        float f41 = ((f11 * f27) - (f13 * f37)) + (f15 * f40);
        float f42 = ((f11 * f28) - (f13 * f38)) + (f14 * f40);
        float f43 = (f * f36) - (((((f6 * f29) - (f8 * f39)) + (f9 * f41)) - (f10 * f42)) * f2);
        float f44 = (f6 * f32) - (f39 * f7);
        float f45 = (f11 * f30) - (f37 * f12);
        float f46 = (f16 * f22) - (f17 * f21);
        float f47 = f45 + (f15 * f46);
        float f48 = ((f11 * f31) - (f38 * f12)) + (f14 * f46);
        float f49 = f43 + (((f44 + (f9 * f47)) - (f10 * f48)) * f3);
        float f50 = ((f6 * f34) - (f41 * f7)) + (f47 * f8);
        float f51 = ((f11 * f33) - (f40 * f12)) + (f46 * f13);
        float f52 = (fArr[0] * ((f49 - ((f50 - (f10 * f51)) * f4)) + (((((f6 * f35) - (f42 * f7)) + (f48 * f8)) - (f51 * f9)) * f5))) + 0.0f;
        float f53 = fArr[6];
        float f54 = fArr[12];
        float f55 = fArr[18];
        float f56 = fArr[24];
        float f57 = fArr[30];
        float f58 = (f56 * f25) - (f20 * f57);
        float f59 = (f56 * f24) - (f19 * f57);
        float f60 = ((f55 * f26) - (f14 * f58)) + (f15 * f59);
        float f61 = (f56 * f23) - (f18 * f57);
        float f62 = ((f55 * f27) - (f13 * f58)) + (f15 * f61);
        float f63 = ((f55 * f28) - (f13 * f59)) + (f14 * f61);
        float f64 = (((f54 * f29) - (f8 * f60)) + (f9 * f62)) - (f10 * f63);
        float f65 = (f56 * f22) - (f17 * f57);
        float f66 = ((f30 * f55) - (f12 * f58)) + (f15 * f65);
        float f67 = ((f31 * f55) - (f12 * f59)) + (f14 * f65);
        float f68 = ((f33 * f55) - (f12 * f61)) + (f65 * f13);
        float f69 = f52 - (fArr[1] * (((((f36 * f53) - (f2 * f64)) + (((((f32 * f54) - (f7 * f60)) + (f9 * f66)) - (f10 * f67)) * f3)) - (((((f34 * f54) - (f7 * f62)) + (f66 * f8)) - (f10 * f68)) * f4)) + (((((f35 * f54) - (f7 * f63)) + (f67 * f8)) - (f68 * f9)) * f5)));
        float f70 = (f16 * f25) - (f20 * f21);
        float f71 = (f16 * f24) - (f19 * f21);
        float f72 = ((f11 * f26) - (f14 * f70)) + (f15 * f71);
        float f73 = (f16 * f23) - (f18 * f21);
        float f74 = ((f27 * f11) - (f13 * f70)) + (f15 * f73);
        float f75 = ((f28 * f11) - (f13 * f71)) + (f14 * f73);
        float f76 = (((((f29 * f6) - (f8 * f72)) + (f9 * f74)) - (f10 * f75)) * f53) - (f64 * f);
        float f77 = (f56 * f21) - (f16 * f57);
        float f78 = ((f55 * f70) - (f11 * f58)) + (f15 * f77);
        float f79 = ((f55 * f71) - (f11 * f59)) + (f14 * f77);
        float f80 = (((f54 * f72) - (f6 * f60)) + (f9 * f78)) - (f10 * f79);
        float f81 = ((f73 * f55) - (f61 * f11)) + (f13 * f77);
        float f82 = f69 + (fArr[2] * (((f76 + (f3 * f80)) - (((((f74 * f54) - (f62 * f6)) + (f8 * f78)) - (f10 * f81)) * f4)) + (((((f75 * f54) - (f63 * f6)) + (f8 * f79)) - (f81 * f9)) * f5)));
        float f83 = (f17 * f25) - (f20 * f22);
        float f84 = (f17 * f24) - (f19 * f22);
        float f85 = ((f26 * f12) - (f14 * f83)) + (f15 * f84);
        float f86 = (f6 * f85) - (f72 * f7);
        float f87 = (f16 * f22) - (f17 * f21);
        float f88 = ((f11 * f83) - (f12 * f70)) + (f15 * f87);
        float f89 = ((f11 * f84) - (f71 * f12)) + (f14 * f87);
        float f90 = (f85 * f54) - (f60 * f7);
        float f91 = (f56 * f22) - (f17 * f57);
        float f92 = ((f55 * f83) - (f12 * f58)) + (f15 * f91);
        float f93 = ((f84 * f55) - (f59 * f12)) + (f14 * f91);
        float f94 = ((((f86 + (f9 * f88)) - (f10 * f89)) * f53) - (((f90 + (f9 * f92)) - (f10 * f93)) * f)) + (f80 * f2);
        float f95 = ((f55 * f87) - (f11 * f91)) + (f12 * f77);
        float f96 = (((f54 * f88) - (f6 * f92)) + (f7 * f78)) - (f10 * f95);
        float f97 = f82 - (fArr[3] * ((f94 - (f4 * f96)) + (((((f89 * f54) - (f93 * f6)) + (f79 * f7)) - (f9 * f95)) * f5)));
        float f98 = (f25 * f18) - (f20 * f23);
        float f99 = (f12 * f98) - (f83 * f13);
        float f100 = (f17 * f23) - (f18 * f22);
        float f101 = f99 + (f15 * f100);
        float f102 = (f11 * f98) - (f70 * f13);
        float f103 = (f16 * f23) - (f18 * f21);
        float f104 = f102 + (f15 * f103);
        float f105 = ((f6 * f101) - (f7 * f104)) + (f88 * f8);
        float f106 = ((f11 * f100) - (f12 * f103)) + (f13 * f87);
        float f107 = (f56 * f23) - (f18 * f57);
        float f108 = ((f98 * f55) - (f58 * f13)) + (f15 * f107);
        float f109 = ((f55 * f100) - (f12 * f107)) + (f13 * f91);
        float f110 = ((f55 * f103) - (f11 * f107)) + (f13 * f77);
        float f111 = ((((f105 - (f10 * f106)) * f53) - (((((f101 * f54) - (f7 * f108)) + (f92 * f8)) - (f10 * f109)) * f)) + (((((f104 * f54) - (f108 * f6)) + (f78 * f8)) - (f10 * f110)) * f2)) - (f96 * f3);
        float f112 = (((f54 * f106) - (f6 * f109)) + (f7 * f110)) - (f8 * f95);
        float f113 = f97 + (fArr[4] * (f111 + (f5 * f112)));
        float f114 = (f18 * f24) - (f23 * f19);
        float f115 = (f17 * f24) - (f22 * f19);
        float f116 = ((f12 * f114) - (f13 * f115)) + (f100 * f14);
        float f117 = (f16 * f24) - (f21 * f19);
        float f118 = ((f11 * f114) - (f13 * f117)) + (f103 * f14);
        float f119 = ((f11 * f115) - (f12 * f117)) + (f87 * f14);
        float f120 = (f56 * f24) - (f19 * f57);
        float f121 = ((f114 * f55) - (f13 * f120)) + (f107 * f14);
        float f122 = ((f115 * f55) - (f12 * f120)) + (f91 * f14);
        float f123 = ((f55 * f117) - (f11 * f120)) + (f14 * f77);
        return f113 - (fArr[5] * (((((f53 * ((((f6 * f116) - (f7 * f118)) + (f8 * f119)) - (f106 * f9))) - (f * ((((f116 * f54) - (f7 * f121)) + (f8 * f122)) - (f109 * f9)))) + (f2 * ((((f118 * f54) - (f121 * f6)) + (f8 * f123)) - (f110 * f9)))) - (f3 * ((((f54 * f119) - (f6 * f122)) + (f7 * f123)) - (f9 * f95)))) + (f4 * f112)));
    }
}

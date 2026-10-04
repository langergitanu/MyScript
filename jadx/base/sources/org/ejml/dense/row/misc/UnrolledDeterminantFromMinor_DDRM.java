package org.ejml.dense.row.misc;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix1Row;

/* JADX INFO: loaded from: classes9.dex */
public class UnrolledDeterminantFromMinor_DDRM {
    public static final int MAX = 6;

    public static double det(DMatrix1Row dMatrix1Row) {
        int i = dMatrix1Row.numRows;
        if (i == 2) {
            return det2(dMatrix1Row);
        }
        if (i == 3) {
            return det3(dMatrix1Row);
        }
        if (i == 4) {
            return det4(dMatrix1Row);
        }
        if (i == 5) {
            return det5(dMatrix1Row);
        }
        if (i == 6) {
            return det6(dMatrix1Row);
        }
        throw new IllegalArgumentException("Not supported");
    }

    public static double det2(DMatrix1Row dMatrix1Row) {
        double[] dArr = dMatrix1Row.data;
        return (dArr[0] * dArr[3]) - (dArr[1] * dArr[2]);
    }

    public static double det3(DMatrix1Row dMatrix1Row) {
        double[] dArr = dMatrix1Row.data;
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double d5 = dArr[4];
        double d6 = dArr[5];
        double d7 = dArr[6];
        double d8 = dArr[7];
        double d9 = dArr[8];
        return ((d * ((d5 * d9) - (d6 * d8))) - (d2 * ((d9 * d4) - (d6 * d7)))) + (d3 * ((d4 * d8) - (d7 * d5)));
    }

    public static double det4(DMatrix1Row dMatrix1Row) {
        double[] dArr = dMatrix1Row.data;
        double d = dArr[5];
        double d2 = dArr[6];
        double d3 = dArr[7];
        double d4 = dArr[9];
        double d5 = dArr[10];
        double d6 = dArr[11];
        double d7 = dArr[13];
        double d8 = dArr[14];
        double d9 = dArr[15];
        double d10 = (d5 * d9) - (d6 * d8);
        double d11 = (dArr[0] * (((d * d10) - (((d4 * d9) - (d6 * d7)) * d2)) + (((d4 * d8) - (d5 * d7)) * d3))) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d12 = dArr[4];
        double d13 = dArr[8];
        double d14 = dArr[12];
        double d15 = (d13 * d9) - (d6 * d14);
        double d16 = (((d9 * d4) - (d6 * d7)) * d12) - (d15 * d);
        double d17 = (d13 * d7) - (d4 * d14);
        return ((d11 - (dArr[1] * (((d10 * d12) - (d2 * d15)) + (((d13 * d8) - (d5 * d14)) * d3)))) + (dArr[2] * (d16 + (d3 * d17)))) - (dArr[3] * (((d12 * ((d4 * d8) - (d7 * d5))) - (d * ((d13 * d8) - (d5 * d14)))) + (d2 * d17)));
    }

    public static double det5(DMatrix1Row dMatrix1Row) {
        double[] dArr = dMatrix1Row.data;
        double d = dArr[6];
        double d2 = dArr[7];
        double d3 = dArr[8];
        double d4 = dArr[9];
        double d5 = dArr[11];
        double d6 = dArr[12];
        double d7 = dArr[13];
        double d8 = dArr[14];
        double d9 = dArr[16];
        double d10 = dArr[17];
        double d11 = dArr[18];
        double d12 = dArr[19];
        double d13 = dArr[21];
        double d14 = dArr[22];
        double d15 = dArr[23];
        double d16 = dArr[24];
        double d17 = (d11 * d16) - (d12 * d15);
        double d18 = (d10 * d16) - (d12 * d14);
        double d19 = (d10 * d15) - (d11 * d14);
        double d20 = ((d6 * d17) - (d7 * d18)) + (d8 * d19);
        double d21 = (d9 * d16) - (d12 * d13);
        double d22 = (d9 * d15) - (d11 * d13);
        double d23 = (d * d20) - ((((d5 * d17) - (d7 * d21)) + (d8 * d22)) * d2);
        double d24 = (d5 * d18) - (d21 * d6);
        double d25 = (d9 * d14) - (d10 * d13);
        double d26 = (dArr[0] * ((d23 + ((d24 + (d8 * d25)) * d3)) - ((((d5 * d19) - (d22 * d6)) + (d25 * d7)) * d4))) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d27 = dArr[5];
        double d28 = dArr[10];
        double d29 = dArr[15];
        double d30 = dArr[20];
        double d31 = (d29 * d16) - (d12 * d30);
        double d32 = (d29 * d15) - (d11 * d30);
        double d33 = ((d28 * d17) - (d7 * d31)) + (d8 * d32);
        double d34 = (d29 * d14) - (d10 * d30);
        double d35 = d26 - (dArr[1] * ((((d20 * d27) - (d2 * d33)) + ((((d18 * d28) - (d6 * d31)) + (d8 * d34)) * d3)) - ((((d19 * d28) - (d6 * d32)) + (d34 * d7)) * d4)));
        double d36 = (d9 * d16) - (d12 * d13);
        double d37 = (d9 * d15) - (d11 * d13);
        double d38 = ((((d17 * d5) - (d7 * d36)) + (d8 * d37)) * d27) - (d33 * d);
        double d39 = (d29 * d13) - (d9 * d30);
        double d40 = ((d28 * d36) - (d5 * d31)) + (d8 * d39);
        double d41 = (d16 * d10) - (d12 * d14);
        double d42 = (d9 * d14) - (d10 * d13);
        double d43 = (((d5 * d41) - (d36 * d6)) + (d8 * d42)) * d27;
        double d44 = (d29 * d14) - (d10 * d30);
        double d45 = (d43 - ((((d41 * d28) - (d31 * d6)) + (d8 * d44)) * d)) + (d40 * d2);
        double d46 = ((d28 * d42) - (d5 * d44)) + (d6 * d39);
        double d47 = (d10 * d15) - (d14 * d11);
        double d48 = (d9 * d15) - (d13 * d11);
        double d49 = (d29 * d15) - (d11 * d30);
        return ((d35 + (dArr[2] * ((d38 + (d3 * d40)) - ((((d37 * d28) - (d32 * d5)) + (d7 * d39)) * d4)))) - (dArr[3] * (d45 - (d4 * d46)))) + (dArr[4] * ((((d27 * (((d5 * d47) - (d6 * d48)) + (d42 * d7))) - (d * (((d47 * d28) - (d6 * d49)) + (d44 * d7)))) + (d2 * (((d28 * d48) - (d5 * d49)) + (d7 * d39)))) - (d3 * d46)));
    }

    public static double det6(DMatrix1Row dMatrix1Row) {
        double[] dArr = dMatrix1Row.data;
        double d = dArr[7];
        double d2 = dArr[8];
        double d3 = dArr[9];
        double d4 = dArr[10];
        double d5 = dArr[11];
        double d6 = dArr[13];
        double d7 = dArr[14];
        double d8 = dArr[15];
        double d9 = dArr[16];
        double d10 = dArr[17];
        double d11 = dArr[19];
        double d12 = dArr[20];
        double d13 = dArr[21];
        double d14 = dArr[22];
        double d15 = dArr[23];
        double d16 = dArr[25];
        double d17 = dArr[26];
        double d18 = dArr[27];
        double d19 = dArr[28];
        double d20 = dArr[29];
        double d21 = dArr[31];
        double d22 = dArr[32];
        double d23 = dArr[33];
        double d24 = dArr[34];
        double d25 = dArr[35];
        double d26 = (d19 * d25) - (d20 * d24);
        double d27 = (d18 * d25) - (d20 * d23);
        double d28 = (d18 * d24) - (d19 * d23);
        double d29 = ((d13 * d26) - (d14 * d27)) + (d15 * d28);
        double d30 = (d17 * d25) - (d20 * d22);
        double d31 = (d17 * d24) - (d19 * d22);
        double d32 = ((d12 * d26) - (d14 * d30)) + (d15 * d31);
        double d33 = (d17 * d23) - (d18 * d22);
        double d34 = ((d12 * d27) - (d13 * d30)) + (d15 * d33);
        double d35 = ((d12 * d28) - (d13 * d31)) + (d14 * d33);
        double d36 = (((d7 * d29) - (d8 * d32)) + (d9 * d34)) - (d10 * d35);
        double d37 = (d16 * d25) - (d20 * d21);
        double d38 = (d16 * d24) - (d19 * d21);
        double d39 = ((d11 * d26) - (d14 * d37)) + (d15 * d38);
        double d40 = (d16 * d23) - (d18 * d21);
        double d41 = ((d11 * d27) - (d13 * d37)) + (d15 * d40);
        double d42 = ((d11 * d28) - (d13 * d38)) + (d14 * d40);
        double d43 = (d * d36) - (((((d6 * d29) - (d8 * d39)) + (d9 * d41)) - (d10 * d42)) * d2);
        double d44 = (d6 * d32) - (d39 * d7);
        double d45 = (d11 * d30) - (d37 * d12);
        double d46 = (d16 * d22) - (d17 * d21);
        double d47 = d45 + (d15 * d46);
        double d48 = ((d11 * d31) - (d38 * d12)) + (d14 * d46);
        double d49 = d43 + (((d44 + (d9 * d47)) - (d10 * d48)) * d3);
        double d50 = ((d6 * d34) - (d41 * d7)) + (d47 * d8);
        double d51 = ((d11 * d33) - (d40 * d12)) + (d46 * d13);
        double d52 = (dArr[0] * ((d49 - ((d50 - (d10 * d51)) * d4)) + (((((d6 * d35) - (d42 * d7)) + (d48 * d8)) - (d51 * d9)) * d5))) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d53 = dArr[6];
        double d54 = dArr[12];
        double d55 = dArr[18];
        double d56 = dArr[24];
        double d57 = dArr[30];
        double d58 = (d56 * d25) - (d20 * d57);
        double d59 = (d56 * d24) - (d19 * d57);
        double d60 = ((d55 * d26) - (d14 * d58)) + (d15 * d59);
        double d61 = (d56 * d23) - (d18 * d57);
        double d62 = ((d55 * d27) - (d13 * d58)) + (d15 * d61);
        double d63 = ((d55 * d28) - (d13 * d59)) + (d14 * d61);
        double d64 = (((d54 * d29) - (d8 * d60)) + (d9 * d62)) - (d10 * d63);
        double d65 = (d56 * d22) - (d17 * d57);
        double d66 = ((d30 * d55) - (d12 * d58)) + (d15 * d65);
        double d67 = ((d31 * d55) - (d12 * d59)) + (d14 * d65);
        double d68 = ((d33 * d55) - (d12 * d61)) + (d65 * d13);
        double d69 = d52 - (dArr[1] * (((((d36 * d53) - (d2 * d64)) + (((((d32 * d54) - (d7 * d60)) + (d9 * d66)) - (d10 * d67)) * d3)) - (((((d34 * d54) - (d7 * d62)) + (d66 * d8)) - (d10 * d68)) * d4)) + (((((d35 * d54) - (d7 * d63)) + (d67 * d8)) - (d68 * d9)) * d5)));
        double d70 = (d16 * d25) - (d20 * d21);
        double d71 = (d16 * d24) - (d19 * d21);
        double d72 = ((d11 * d26) - (d14 * d70)) + (d15 * d71);
        double d73 = (d16 * d23) - (d18 * d21);
        double d74 = ((d27 * d11) - (d13 * d70)) + (d15 * d73);
        double d75 = ((d28 * d11) - (d13 * d71)) + (d14 * d73);
        double d76 = (((((d29 * d6) - (d8 * d72)) + (d9 * d74)) - (d10 * d75)) * d53) - (d64 * d);
        double d77 = (d56 * d21) - (d16 * d57);
        double d78 = ((d55 * d70) - (d11 * d58)) + (d15 * d77);
        double d79 = ((d55 * d71) - (d11 * d59)) + (d14 * d77);
        double d80 = (((d54 * d72) - (d6 * d60)) + (d9 * d78)) - (d10 * d79);
        double d81 = ((d73 * d55) - (d61 * d11)) + (d13 * d77);
        double d82 = d69 + (dArr[2] * (((d76 + (d3 * d80)) - (((((d74 * d54) - (d62 * d6)) + (d8 * d78)) - (d10 * d81)) * d4)) + (((((d75 * d54) - (d63 * d6)) + (d8 * d79)) - (d81 * d9)) * d5)));
        double d83 = (d17 * d25) - (d20 * d22);
        double d84 = (d17 * d24) - (d19 * d22);
        double d85 = ((d26 * d12) - (d14 * d83)) + (d15 * d84);
        double d86 = (d6 * d85) - (d72 * d7);
        double d87 = (d16 * d22) - (d17 * d21);
        double d88 = ((d11 * d83) - (d12 * d70)) + (d15 * d87);
        double d89 = ((d11 * d84) - (d71 * d12)) + (d14 * d87);
        double d90 = (d85 * d54) - (d60 * d7);
        double d91 = (d56 * d22) - (d17 * d57);
        double d92 = ((d55 * d83) - (d12 * d58)) + (d15 * d91);
        double d93 = ((d84 * d55) - (d59 * d12)) + (d14 * d91);
        double d94 = ((((d86 + (d9 * d88)) - (d10 * d89)) * d53) - (((d90 + (d9 * d92)) - (d10 * d93)) * d)) + (d80 * d2);
        double d95 = ((d55 * d87) - (d11 * d91)) + (d12 * d77);
        double d96 = (((d54 * d88) - (d6 * d92)) + (d7 * d78)) - (d10 * d95);
        double d97 = d82 - (dArr[3] * ((d94 - (d4 * d96)) + (((((d89 * d54) - (d93 * d6)) + (d79 * d7)) - (d9 * d95)) * d5)));
        double d98 = (d25 * d18) - (d20 * d23);
        double d99 = (d12 * d98) - (d83 * d13);
        double d100 = (d17 * d23) - (d18 * d22);
        double d101 = d99 + (d15 * d100);
        double d102 = (d11 * d98) - (d70 * d13);
        double d103 = (d16 * d23) - (d18 * d21);
        double d104 = d102 + (d15 * d103);
        double d105 = ((d6 * d101) - (d7 * d104)) + (d88 * d8);
        double d106 = ((d11 * d100) - (d12 * d103)) + (d13 * d87);
        double d107 = (d56 * d23) - (d18 * d57);
        double d108 = ((d98 * d55) - (d58 * d13)) + (d15 * d107);
        double d109 = ((d55 * d100) - (d12 * d107)) + (d13 * d91);
        double d110 = ((d55 * d103) - (d11 * d107)) + (d13 * d77);
        double d111 = ((((d105 - (d10 * d106)) * d53) - (((((d101 * d54) - (d7 * d108)) + (d92 * d8)) - (d10 * d109)) * d)) + (((((d104 * d54) - (d108 * d6)) + (d78 * d8)) - (d10 * d110)) * d2)) - (d96 * d3);
        double d112 = (((d54 * d106) - (d6 * d109)) + (d7 * d110)) - (d8 * d95);
        double d113 = (d18 * d24) - (d23 * d19);
        double d114 = (d17 * d24) - (d22 * d19);
        double d115 = ((d12 * d113) - (d13 * d114)) + (d100 * d14);
        double d116 = (d16 * d24) - (d21 * d19);
        double d117 = ((d11 * d113) - (d13 * d116)) + (d103 * d14);
        double d118 = ((d11 * d114) - (d12 * d116)) + (d87 * d14);
        double d119 = (d56 * d24) - (d19 * d57);
        double d120 = ((d113 * d55) - (d13 * d119)) + (d107 * d14);
        double d121 = ((d114 * d55) - (d12 * d119)) + (d91 * d14);
        double d122 = ((d55 * d116) - (d11 * d119)) + (d14 * d77);
        return (d97 + (dArr[4] * (d111 + (d5 * d112)))) - (dArr[5] * (((((d53 * ((((d6 * d115) - (d7 * d117)) + (d8 * d118)) - (d106 * d9))) - (d * ((((d115 * d54) - (d7 * d120)) + (d8 * d121)) - (d109 * d9)))) + (d2 * ((((d117 * d54) - (d120 * d6)) + (d8 * d122)) - (d110 * d9)))) - (d3 * ((((d54 * d118) - (d6 * d121)) + (d7 * d122)) - (d9 * d95)))) + (d4 * d112)));
    }
}

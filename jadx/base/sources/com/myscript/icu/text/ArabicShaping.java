package com.myscript.icu.text;

import androidx.core.view.MotionEventCompat;

/* JADX INFO: loaded from: classes4.dex */
public class ArabicShaping {
    private static final int ALEFTYPE = 32;
    private static final int DESHAPE_MODE = 1;
    public static final int DIGITS_AN2EN = 64;
    public static final int DIGITS_EN2AN = 32;
    public static final int DIGITS_EN2AN_INIT_AL = 128;
    public static final int DIGITS_EN2AN_INIT_LR = 96;
    public static final int DIGITS_MASK = 224;
    public static final int DIGITS_NOOP = 0;
    public static final int DIGIT_TYPE_AN = 0;
    public static final int DIGIT_TYPE_AN_EXTENDED = 256;
    public static final int DIGIT_TYPE_MASK = 256;
    private static final char HAMZA06_CHAR = 1569;
    private static final char HAMZAFE_CHAR = 65152;
    private static final int IRRELEVANT = 4;
    public static final int LAMALEF_AUTO = 65536;
    public static final int LAMALEF_BEGIN = 3;
    public static final int LAMALEF_END = 2;
    public static final int LAMALEF_MASK = 65539;
    public static final int LAMALEF_NEAR = 1;
    public static final int LAMALEF_RESIZE = 0;
    private static final char LAMALEF_SPACE_SUB = 65535;
    private static final int LAMTYPE = 16;
    private static final char LAM_CHAR = 1604;
    public static final int LENGTH_FIXED_SPACES_AT_BEGINNING = 3;
    public static final int LENGTH_FIXED_SPACES_AT_END = 2;
    public static final int LENGTH_FIXED_SPACES_NEAR = 1;
    public static final int LENGTH_GROW_SHRINK = 0;
    public static final int LENGTH_MASK = 65539;
    public static final int LETTERS_MASK = 24;
    public static final int LETTERS_NOOP = 0;
    public static final int LETTERS_SHAPE = 8;
    public static final int LETTERS_SHAPE_TASHKEEL_ISOLATED = 24;
    public static final int LETTERS_UNSHAPE = 16;
    private static final int LINKL = 2;
    private static final int LINKR = 1;
    private static final int LINK_MASK = 3;
    private static final char NEW_TAIL_CHAR = 65139;
    private static final char OLD_TAIL_CHAR = 8203;
    public static final int SEEN_MASK = 7340032;
    public static final int SEEN_TWOCELL_NEAR = 2097152;
    private static final char SHADDA_CHAR = 65148;
    private static final char SHADDA_TATWEEL_CHAR = 65149;
    private static final int SHAPE_MODE = 0;
    public static final int SHAPE_TAIL_NEW_UNICODE = 134217728;
    public static final int SHAPE_TAIL_TYPE_MASK = 134217728;
    public static final int SPACES_RELATIVE_TO_TEXT_BEGIN_END = 67108864;
    public static final int SPACES_RELATIVE_TO_TEXT_MASK = 67108864;
    private static final char SPACE_CHAR = ' ';
    private static final char SPACE_CHAR_FOR_LAMALEF = 65279;
    public static final int TASHKEEL_BEGIN = 262144;
    public static final int TASHKEEL_END = 393216;
    public static final int TASHKEEL_MASK = 917504;
    public static final int TASHKEEL_REPLACE_BY_TATWEEL = 786432;
    public static final int TASHKEEL_RESIZE = 524288;
    private static final char TASHKEEL_SPACE_SUB = 65534;
    private static final char TATWEEL_CHAR = 1600;
    public static final int TEXT_DIRECTION_LOGICAL = 0;
    public static final int TEXT_DIRECTION_MASK = 4;
    public static final int TEXT_DIRECTION_VISUAL_LTR = 4;
    public static final int TEXT_DIRECTION_VISUAL_RTL = 0;
    public static final int YEHHAMZA_MASK = 58720256;
    public static final int YEHHAMZA_TWOCELL_NEAR = 16777216;
    private static final char YEH_HAMZAFE_CHAR = 65161;
    private static final char YEH_HAMZA_CHAR = 1574;
    private boolean isLogical;
    private final int options;
    private boolean spacesRelativeToTextBeginEnd;
    private char tailChar;
    public static final ArabicShaping SHAPER = new ArabicShaping(9);
    private static final int[] irrelevantPos = {0, 2, 4, 6, 8, 10, 12, 14};
    private static final int[] tailFamilyIsolatedFinal = {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1};
    private static final int[] tashkeelMedial = {0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
    private static final char[] yehHamzaToYeh = {65263, 65264};
    private static final char[] convertNormalizedLamAlef = {1570, 1571, 1573, 1575};
    private static final int[] araLink = {4385, 4897, 5377, 5921, 6403, 7457, 7939, 8961, 9475, 10499, 11523, 12547, 13571, 14593, 15105, 15617, 16129, 16643, 17667, 18691, 19715, 20739, 21763, 22787, 23811, 0, 0, 0, 0, 0, 3, 24835, 25859, 26883, 27923, 28931, 29955, 30979, 32001, 32513, 33027, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 34049, 34561, 35073, 35585, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 33, 33, 0, 33, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 3, 3, 3, 3, 1, 1};
    private static final int[] presLink = {3, 3, 3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 32, 33, 32, 33, 0, 1, 32, 33, 0, 2, 3, 1, 32, 33, 0, 2, 3, 1, 0, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 16, 18, 19, 17, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 1, 0, 1, 0, 2, 3, 1, 0, 1, 0, 1, 0, 1, 0, 1};
    private static int[] convertFEto06 = {1611, 1611, 1612, 1612, 1613, 1613, 1614, 1614, 1615, 1615, 1616, 1616, 1617, 1617, 1618, 1618, 1569, 1570, 1570, 1571, 1571, 1572, 1572, 1573, 1573, 1574, 1574, 1574, 1574, 1575, 1575, 1576, 1576, 1576, 1576, 1577, 1577, 1578, 1578, 1578, 1578, 1579, 1579, 1579, 1579, 1580, 1580, 1580, 1580, 1581, 1581, 1581, 1581, 1582, 1582, 1582, 1582, 1583, 1583, 1584, 1584, 1585, 1585, 1586, 1586, 1587, 1587, 1587, 1587, 1588, 1588, 1588, 1588, 1589, 1589, 1589, 1589, 1590, 1590, 1590, 1590, 1591, 1591, 1591, 1591, 1592, 1592, 1592, 1592, 1593, 1593, 1593, 1593, 1594, 1594, 1594, 1594, 1601, 1601, 1601, 1601, 1602, 1602, 1602, 1602, 1603, 1603, 1603, 1603, 1604, 1604, 1604, 1604, 1605, 1605, 1605, 1605, 1606, 1606, 1606, 1606, 1607, 1607, 1607, 1607, 1608, 1608, 1609, 1609, 1610, 1610, 1610, 1610, 1628, 1628, 1629, 1629, 1630, 1630, 1631, 1631};
    private static final int[][][] shapeTable = {new int[][]{new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}, new int[]{0, 1, 0, 3}, new int[]{0, 1, 0, 1}}, new int[][]{new int[]{0, 0, 2, 2}, new int[]{0, 0, 1, 2}, new int[]{0, 1, 1, 2}, new int[]{0, 1, 1, 3}}, new int[][]{new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}, new int[]{0, 1, 0, 3}, new int[]{0, 1, 0, 3}}, new int[][]{new int[]{0, 0, 1, 2}, new int[]{0, 0, 1, 2}, new int[]{0, 1, 1, 2}, new int[]{0, 1, 1, 3}}};

    private static char changeLamAlef(char c) {
        if (c == 1570) {
            return (char) 1628;
        }
        if (c == 1571) {
            return (char) 1629;
        }
        if (c != 1573) {
            return c != 1575 ? (char) 0 : (char) 1631;
        }
        return (char) 1630;
    }

    private static boolean isAlefChar(char c) {
        return c == 1570 || c == 1571 || c == 1573 || c == 1575;
    }

    private static boolean isAlefMaksouraChar(char c) {
        return c == 65263 || c == 65264 || c == 1609;
    }

    private static boolean isLamAlefChar(char c) {
        return c >= 65269 && c <= 65276;
    }

    private static boolean isNormalizedLamAlefChar(char c) {
        return c >= 1628 && c <= 1631;
    }

    private static int isSeenFamilyChar(char c) {
        return (c < 1587 || c > 1590) ? 0 : 1;
    }

    private static boolean isTailChar(char c) {
        return c == 8203 || c == 65139;
    }

    private static boolean isTashkeelChar(char c) {
        return c >= 1611 && c <= 1618;
    }

    private static boolean isTashkeelCharFE(char c) {
        return c != 65141 && c >= 65136 && c <= 65151;
    }

    private static boolean isYehHamzaChar(char c) {
        return c == 65161 || c == 65162;
    }

    private static int specialChar(char c) {
        if ((c > 1569 && c < 1574) || c == 1575) {
            return 1;
        }
        if (c > 1582 && c < 1587) {
            return 1;
        }
        if ((c > 1607 && c < 1610) || c == 1577) {
            return 1;
        }
        if (c >= 1611 && c <= 1618) {
            return 2;
        }
        if ((c < 1619 || c > 1621) && c != 1648) {
            return (c < 65136 || c > 65151) ? 0 : 3;
        }
        return 3;
    }

    public int shape(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4) throws ArabicShapingException {
        if (cArr == null) {
            throw new IllegalArgumentException("source cannot be null");
        }
        if (i < 0 || i2 < 0 || i + i2 > cArr.length) {
            throw new IllegalArgumentException("bad source start (" + i + ") or length (" + i2 + ") for buffer of length " + cArr.length);
        }
        if (cArr2 == null && i4 != 0) {
            throw new IllegalArgumentException("null dest requires destSize == 0");
        }
        if (i4 != 0 && (i3 < 0 || i4 < 0 || i3 + i4 > cArr2.length)) {
            throw new IllegalArgumentException("bad dest start (" + i3 + ") or size (" + i4 + ") for buffer of length " + cArr2.length);
        }
        int i5 = this.options;
        if ((i5 & TASHKEEL_MASK) > 0 && (i5 & TASHKEEL_MASK) != 262144 && (i5 & TASHKEEL_MASK) != 393216 && (i5 & TASHKEEL_MASK) != 524288 && (i5 & TASHKEEL_MASK) != 786432) {
            throw new IllegalArgumentException("Wrong Tashkeel argument");
        }
        if ((i5 & 65539) > 0 && (i5 & 65539) != 3 && (i5 & 65539) != 2 && (i5 & 65539) != 0 && (i5 & 65539) != 65536 && (65539 & i5) != 1) {
            throw new IllegalArgumentException("Wrong Lam Alef argument");
        }
        if ((917504 & i5) > 0 && (i5 & 24) == 16) {
            throw new IllegalArgumentException("Tashkeel replacement should not be enabled in deshaping mode ");
        }
        return internalShape(cArr, i, i2, cArr2, i3, i4);
    }

    public void shape(char[] cArr, int i, int i2) throws ArabicShapingException {
        if ((this.options & 65539) == 0) {
            throw new ArabicShapingException("Cannot shape in place with length option resize.");
        }
        shape(cArr, i, i2, cArr, i, i2);
    }

    public String shape(String str) throws ArabicShapingException {
        char[] charArray = str.toCharArray();
        int i = this.options;
        char[] cArr = ((65539 & i) == 0 && (i & 24) == 16) ? new char[charArray.length * 2] : charArray;
        return new String(cArr, 0, shape(charArray, 0, charArray.length, cArr, 0, cArr.length));
    }

    public ArabicShaping(int i) {
        this.options = i;
        if ((i & 224) > 128) {
            throw new IllegalArgumentException("bad DIGITS options");
        }
        this.isLogical = (i & 4) == 0;
        this.spacesRelativeToTextBeginEnd = (i & 67108864) == 67108864;
        if ((i & 134217728) == 134217728) {
            this.tailChar = NEW_TAIL_CHAR;
        } else {
            this.tailChar = OLD_TAIL_CHAR;
        }
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == ArabicShaping.class && this.options == ((ArabicShaping) obj).options;
    }

    public int hashCode() {
        return this.options;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(super.toString());
        stringBuffer.append('[');
        int i = this.options & 65539;
        if (i == 0) {
            stringBuffer.append("LamAlef resize");
        } else if (i == 1) {
            stringBuffer.append("LamAlef spaces at near");
        } else if (i == 2) {
            stringBuffer.append("LamAlef spaces at end");
        } else if (i == 3) {
            stringBuffer.append("LamAlef spaces at begin");
        } else if (i == 65536) {
            stringBuffer.append("lamAlef auto");
        }
        int i2 = this.options & 4;
        if (i2 == 0) {
            stringBuffer.append(", logical");
        } else if (i2 == 4) {
            stringBuffer.append(", visual");
        }
        int i3 = this.options & 24;
        if (i3 == 0) {
            stringBuffer.append(", no letter shaping");
        } else if (i3 == 8) {
            stringBuffer.append(", shape letters");
        } else if (i3 == 16) {
            stringBuffer.append(", unshape letters");
        } else if (i3 == 24) {
            stringBuffer.append(", shape letters tashkeel isolated");
        }
        if ((this.options & SEEN_MASK) == 2097152) {
            stringBuffer.append(", Seen at near");
        }
        if ((this.options & 58720256) == 16777216) {
            stringBuffer.append(", Yeh Hamza at near");
        }
        int i4 = this.options & TASHKEEL_MASK;
        if (i4 == 262144) {
            stringBuffer.append(", Tashkeel at begin");
        } else if (i4 == 393216) {
            stringBuffer.append(", Tashkeel at end");
        } else if (i4 == 524288) {
            stringBuffer.append(", Tashkeel resize");
        } else if (i4 == 786432) {
            stringBuffer.append(", Tashkeel replace with tatweel");
        }
        int i5 = this.options & 224;
        if (i5 == 0) {
            stringBuffer.append(", no digit shaping");
        } else if (i5 == 32) {
            stringBuffer.append(", shape digits to AN");
        } else if (i5 == 64) {
            stringBuffer.append(", shape digits to EN");
        } else if (i5 == 96) {
            stringBuffer.append(", shape digits to AN contextually: default EN");
        } else if (i5 == 128) {
            stringBuffer.append(", shape digits to AN contextually: default AL");
        }
        int i6 = this.options & 256;
        if (i6 == 0) {
            stringBuffer.append(", standard Arabic-Indic digits");
        } else if (i6 == 256) {
            stringBuffer.append(", extended Arabic-Indic digits");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    private void shapeToArabicDigitsWithContext(char[] cArr, int i, int i2, char c, boolean z) {
        char c2 = (char) (c - '0');
        int i3 = i2 + i;
        while (true) {
            i3--;
            if (i3 < i) {
                return;
            }
            char c3 = cArr[i3];
            byte directionality = Character.getDirectionality(c3);
            if (directionality == 0 || directionality == 1) {
                z = false;
            } else if (directionality == 2) {
                z = true;
            } else if (directionality == 3 && z && c3 <= '9') {
                cArr[i3] = (char) (c3 + c2);
            }
        }
    }

    private static void invertBuffer(char[] cArr, int i, int i2) {
        for (int i3 = (i2 + i) - 1; i < i3; i3--) {
            char c = cArr[i];
            cArr[i] = cArr[i3];
            cArr[i3] = c;
            i++;
        }
    }

    private static int getLink(char c) {
        if (c >= 1570 && c <= 1747) {
            return araLink[c - 1570];
        }
        if (c == 8205) {
            return 3;
        }
        if (c >= 8301 && c <= 8303) {
            return 4;
        }
        if (c < 65136 || c > 65276) {
            return 0;
        }
        return presLink[c - 65136];
    }

    private static int countSpacesLeft(char[] cArr, int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            if (cArr[i4] != ' ') {
                return i4 - i;
            }
        }
        return i2;
    }

    private static int countSpacesRight(char[] cArr, int i, int i2) {
        int i3 = i + i2;
        int i4 = i3;
        do {
            i4--;
            if (i4 < i) {
                return i2;
            }
        } while (cArr[i4] == ' ');
        return (i3 - 1) - i4;
    }

    private static int isSeenTailFamilyChar(char c) {
        if (c < 65201 || c >= 65215) {
            return 0;
        }
        return tailFamilyIsolatedFinal[c - 65201];
    }

    private static int isTashkeelOnTatweelChar(char c) {
        if (c < 65136 || c > 65151 || c == 65139 || c == 65141 || c == 65149) {
            return ((c < 64754 || c > 64756) && c != 65149) ? 0 : 2;
        }
        return tashkeelMedial[c - 65136];
    }

    private static int isIsolatedTashkeelChar(char c) {
        if (c < 65136 || c > 65151 || c == 65139 || c == 65141) {
            return (c < 64606 || c > 64611) ? 0 : 1;
        }
        return 1 - tashkeelMedial[c - 65136];
    }

    private int calculateSize(char[] cArr, int i, int i2) {
        int i3 = this.options & 24;
        if (i3 != 8) {
            if (i3 == 16) {
                int i4 = i + i2;
                while (i < i4) {
                    if (isLamAlefChar(cArr[i])) {
                        i2++;
                    }
                    i++;
                }
                return i2;
            }
            if (i3 != 24) {
                return i2;
            }
        }
        if (this.isLogical) {
            int i5 = (i + i2) - 1;
            while (i < i5) {
                if ((cArr[i] == 1604 && isAlefChar(cArr[i + 1])) || isTashkeelCharFE(cArr[i])) {
                    i2--;
                }
                i++;
            }
            return i2;
        }
        int i6 = i + i2;
        for (int i7 = i + 1; i7 < i6; i7++) {
            if ((cArr[i7] == 1604 && isAlefChar(cArr[i7 - 1])) || isTashkeelCharFE(cArr[i7])) {
                i2--;
            }
        }
        return i2;
    }

    public static int countSpaceSub(char[] cArr, int i, char c) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (cArr[i3] == c) {
                i2++;
            }
        }
        return i2;
    }

    public static void shiftArray(char[] cArr, int i, int i2, char c) {
        int i3 = i2;
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            }
            char c2 = cArr[i2];
            if (c2 != c && i3 - 1 != i2) {
                cArr[i3] = c2;
            }
        }
    }

    public static int flipArray(char[] cArr, int i, int i2, int i3) {
        if (i3 <= i) {
            return i2;
        }
        while (i3 < i2) {
            cArr[i] = cArr[i3];
            i++;
            i3++;
        }
        return i;
    }

    private static int handleTashkeelWithTatweel(char[] cArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (isTashkeelOnTatweelChar(cArr[i2]) == 1) {
                cArr[i2] = TATWEEL_CHAR;
            } else if (isTashkeelOnTatweelChar(cArr[i2]) == 2) {
                cArr[i2] = SHADDA_TATWEEL_CHAR;
            } else if (isIsolatedTashkeelChar(cArr[i2]) == 1 && cArr[i2] != 65148) {
                cArr[i2] = ' ';
            }
        }
        return i;
    }

    private int handleGeneratedSpaces(char[] cArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int i5 = this.options;
        int i6 = 65539 & i5;
        int i7 = i5 & TASHKEEL_MASK;
        if ((!this.isLogical) & (!this.spacesRelativeToTextBeginEnd)) {
            if (i6 == 2) {
                i6 = 3;
            } else if (i6 == 3) {
                i6 = 2;
            }
            if (i7 == 262144) {
                i7 = 393216;
            } else if (i7 == 393216) {
                i7 = 262144;
            }
        }
        if (i6 == 1) {
            int i8 = i3 + i4;
            while (i3 < i8) {
                if (cArr[i3] == 65535) {
                    cArr[i3] = SPACE_CHAR_FOR_LAMALEF;
                }
                i3++;
            }
            return i4;
        }
        int i9 = i3 + i4;
        int iCountSpaceSub = countSpaceSub(cArr, i4, (char) 65535);
        int iCountSpaceSub2 = countSpaceSub(cArr, i4, TASHKEEL_SPACE_SUB);
        boolean z = i6 == 2;
        boolean z2 = i7 == 393216;
        if (z && i6 == 2) {
            shiftArray(cArr, i3, i9, (char) 65535);
            while (iCountSpaceSub > i3) {
                iCountSpaceSub--;
                cArr[iCountSpaceSub] = ' ';
            }
        }
        if (z2 && i7 == 393216) {
            shiftArray(cArr, i3, i9, TASHKEEL_SPACE_SUB);
            while (iCountSpaceSub2 > i3) {
                iCountSpaceSub2--;
                cArr[iCountSpaceSub2] = ' ';
            }
        }
        boolean z3 = i6 == 0;
        boolean z4 = i7 == 524288;
        if (z3 && i6 == 0) {
            shiftArray(cArr, i3, i9, (char) 65535);
            iCountSpaceSub = flipArray(cArr, i3, i9, iCountSpaceSub);
            i4 = iCountSpaceSub - i3;
        }
        if (z4 && i7 == 524288) {
            shiftArray(cArr, i3, i9, TASHKEEL_SPACE_SUB);
            iCountSpaceSub2 = flipArray(cArr, i3, i9, iCountSpaceSub2);
            i4 = iCountSpaceSub2 - i3;
        }
        boolean z5 = i6 == 3 || i6 == 65536;
        boolean z6 = i7 == 262144;
        if (z5 && (i6 == 3 || i6 == 65536)) {
            shiftArray(cArr, i3, i9, (char) 65535);
            for (int iFlipArray = flipArray(cArr, i3, i9, iCountSpaceSub); iFlipArray < i9; iFlipArray++) {
                cArr[iFlipArray] = ' ';
            }
        }
        if (z6 && i7 == 262144) {
            shiftArray(cArr, i3, i9, TASHKEEL_SPACE_SUB);
            for (int iFlipArray2 = flipArray(cArr, i3, i9, iCountSpaceSub2); iFlipArray2 < i9; iFlipArray2++) {
                cArr[iFlipArray2] = ' ';
            }
        }
        return i4;
    }

    private boolean expandCompositCharAtBegin(char[] cArr, int i, int i2, int i3) {
        if (i3 > countSpacesRight(cArr, i, i2)) {
            return true;
        }
        int i4 = i2 + i;
        int i5 = i4 - i3;
        while (true) {
            i5--;
            if (i5 < i) {
                return false;
            }
            char c = cArr[i5];
            if (isNormalizedLamAlefChar(c)) {
                cArr[i4 - 1] = LAM_CHAR;
                i4 -= 2;
                cArr[i4] = convertNormalizedLamAlef[c - 1628];
            } else {
                i4--;
                cArr[i4] = c;
            }
        }
    }

    private boolean expandCompositCharAtEnd(char[] cArr, int i, int i2, int i3) {
        if (i3 > countSpacesLeft(cArr, i, i2)) {
            return true;
        }
        int i4 = i2 + i;
        for (int i5 = i3 + i; i5 < i4; i5++) {
            char c = cArr[i5];
            if (isNormalizedLamAlefChar(c)) {
                int i6 = i + 1;
                cArr[i] = convertNormalizedLamAlef[c - 1628];
                i += 2;
                cArr[i6] = LAM_CHAR;
            } else {
                cArr[i] = c;
                i++;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean expandCompositCharAtNear(char[] cArr, int i, int i2, int i3, int i4, int i5) {
        if (isNormalizedLamAlefChar(cArr[i])) {
            return true;
        }
        int i6 = i2 + i;
        while (true) {
            int i7 = i6 - 1;
            if (i7 < i) {
                return false;
            }
            char c = cArr[i7];
            if (i5 == 1 && isNormalizedLamAlefChar(c)) {
                if (i7 <= i || cArr[i6 - 2] != ' ') {
                    break;
                }
                cArr[i7] = LAM_CHAR;
                i6 -= 2;
                cArr[i6] = convertNormalizedLamAlef[c - 1628];
            } else {
                if (i4 != 1 || isSeenTailFamilyChar(c) != 1) {
                    if (i3 == 1 && isYehHamzaChar(c)) {
                        if (i7 <= i) {
                            break;
                        }
                        int i8 = i6 - 2;
                        if (cArr[i8] != ' ') {
                            break;
                        }
                        cArr[i7] = yehHamzaToYeh[c - YEH_HAMZAFE_CHAR];
                        cArr[i8] = HAMZAFE_CHAR;
                    }
                } else {
                    if (i7 <= i) {
                        break;
                    }
                    int i9 = i6 - 2;
                    if (cArr[i9] != ' ') {
                        break;
                    }
                    cArr[i9] = this.tailChar;
                }
                i6 = i7;
            }
        }
        return true;
    }

    private int expandCompositChar(char[] cArr, int i, int i2, int i3, int i4) throws ArabicShapingException {
        char[] cArr2;
        int i5;
        int i6;
        int i7 = this.options;
        int i8 = 65539 & i7;
        int i9 = 7340032 & i7;
        int i10 = i7 & 58720256;
        boolean z = this.isLogical;
        if (!z && !this.spacesRelativeToTextBeginEnd) {
            if (i8 == 2) {
                i8 = 3;
            } else if (i8 == 3) {
                i8 = 2;
            }
        }
        if (i4 != 1) {
            if (i9 == 2097152) {
                cArr2 = cArr;
                if (expandCompositCharAtNear(cArr2, i, i2, 0, 1, 0)) {
                    throw new ArabicShapingException("No space for Seen tail expansion");
                }
            } else {
                cArr2 = cArr;
            }
            if (i10 == 16777216 && expandCompositCharAtNear(cArr2, i, i2, 1, 0, 0)) {
                throw new ArabicShapingException("No space for YehHamza expansion");
            }
            return i2;
        }
        if (i8 != 65536) {
            i5 = i2;
            if (i8 == 2) {
                if (expandCompositCharAtEnd(cArr, i, i5, i3)) {
                    throw new ArabicShapingException("No spacefor lamalef");
                }
            } else if (i8 == 3) {
                if (expandCompositCharAtBegin(cArr, i, i5, i3)) {
                    throw new ArabicShapingException("No spacefor lamalef");
                }
            } else {
                if (i8 == 1) {
                    if (expandCompositCharAtNear(cArr, i, i5, 0, 0, 1)) {
                        throw new ArabicShapingException("No spacefor lamalef");
                    }
                    return i5;
                }
                if (i8 != 0) {
                    return i5;
                }
                int i11 = i + i5;
                int i12 = i11 + i3;
                while (true) {
                    i11--;
                    if (i11 < i) {
                        return i5 + i3;
                    }
                    char c = cArr[i11];
                    if (isNormalizedLamAlefChar(c)) {
                        cArr[i12 - 1] = LAM_CHAR;
                        i12 -= 2;
                        cArr[i12] = convertNormalizedLamAlef[c - 1628];
                    } else {
                        i12--;
                        cArr[i12] = c;
                    }
                }
            }
        } else {
            if (z) {
                boolean zExpandCompositCharAtEnd = expandCompositCharAtEnd(cArr, i, i2, i3);
                if (zExpandCompositCharAtEnd) {
                    zExpandCompositCharAtEnd = expandCompositCharAtBegin(cArr, i, i2, i3);
                }
                if (zExpandCompositCharAtEnd) {
                    i6 = i2;
                    zExpandCompositCharAtEnd = expandCompositCharAtNear(cArr, i, i6, 0, 0, 1);
                } else {
                    i6 = i2;
                }
                if (zExpandCompositCharAtEnd) {
                    throw new ArabicShapingException("No spacefor lamalef");
                }
                return i6;
            }
            boolean zExpandCompositCharAtBegin = expandCompositCharAtBegin(cArr, i, i2, i3);
            if (zExpandCompositCharAtBegin) {
                zExpandCompositCharAtBegin = expandCompositCharAtEnd(cArr, i, i2, i3);
            }
            if (zExpandCompositCharAtBegin) {
                zExpandCompositCharAtBegin = expandCompositCharAtNear(cArr, i, i2, 0, 0, 1);
            }
            i5 = i2;
            if (zExpandCompositCharAtBegin) {
                throw new ArabicShapingException("No spacefor lamalef");
            }
        }
        return i5;
    }

    private int normalize(char[] cArr, int i, int i2) {
        int i3 = i2 + i;
        int i4 = 0;
        while (i < i3) {
            char c = cArr[i];
            if (c >= 65136 && c <= 65276) {
                if (isLamAlefChar(c)) {
                    i4++;
                }
                cArr[i] = (char) convertFEto06[c - 65136];
            }
            i++;
        }
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int deshapeNormalize(char[] cArr, int i, int i2) {
        int i3 = this.options;
        int i4 = 0;
        boolean z = (58720256 & i3) == 16777216;
        boolean z2 = (i3 & SEEN_MASK) == 2097152;
        int i5 = i + i2;
        while (i < i5) {
            char c = cArr[i];
            if (z && ((c == 1569 || c == 65152) && i < i2 - 1)) {
                int i6 = i + 1;
                if (isAlefMaksouraChar(cArr[i6])) {
                    cArr[i] = ' ';
                    cArr[i6] = YEH_HAMZA_CHAR;
                }
            } else if (z2 && isTailChar(c) && i < i2 - 1 && isSeenTailFamilyChar(cArr[i + 1]) == 1) {
                cArr[i] = ' ';
            } else if (c >= 65136 && c <= 65276) {
                if (isLamAlefChar(c)) {
                    i4++;
                }
                cArr[i] = (char) convertFEto06[c - 65136];
            }
            i++;
        }
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int shapeUnicode(char[] cArr, int i, int i2, int i3, int i4) throws ArabicShapingException {
        int i5;
        int iSpecialChar;
        char c;
        int iNormalize = normalize(cArr, i, i2);
        int i6 = 1;
        int i7 = (i + i2) - 1;
        int link = getLink(cArr[i7]);
        int i8 = 0;
        boolean z = false;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int link2 = 0;
        int i13 = -2;
        int i14 = i7;
        while (i7 >= 0) {
            if ((link & MotionEventCompat.ACTION_POINTER_INDEX_MASK) > 0 || isTashkeelChar(cArr[i7])) {
                int i15 = i7 - 1;
                i13 = -2;
                while (i13 < 0) {
                    if (i15 == -1) {
                        i13 = Integer.MAX_VALUE;
                        link2 = 0;
                    } else {
                        link2 = getLink(cArr[i15]);
                        if ((link2 & 4) == 0) {
                            i13 = i15;
                        } else {
                            i15--;
                        }
                    }
                }
                if ((link & 32) > 0 && (i11 & 16) > 0) {
                    char cChangeLamAlef = changeLamAlef(cArr[i7]);
                    if (cChangeLamAlef != 0) {
                        cArr[i7] = 65535;
                        cArr[i14] = cChangeLamAlef;
                        i7 = i14;
                    }
                    link = getLink(cChangeLamAlef);
                    i8 = i6;
                    i11 = i12;
                }
                i5 = -1;
                if (i7 > 0 && cArr[i7 - 1] == ' ') {
                    if (isSeenFamilyChar(cArr[i7]) != i6) {
                        if (cArr[i7] == 1574) {
                        }
                    }
                    iSpecialChar = specialChar(cArr[i7]);
                    int i16 = shapeTable[link2 & 3][i11 & 3][link & 3];
                    int i17 = i7;
                    if (iSpecialChar != i6) {
                    }
                    if (iSpecialChar == 2) {
                    }
                    i7 = i17;
                } else {
                    if (i7 == 0) {
                        if (isSeenFamilyChar(cArr[i7]) == i6) {
                            i9 = i6;
                        } else if (cArr[i7] == 1574) {
                            i10 = i6;
                        }
                    }
                    iSpecialChar = specialChar(cArr[i7]);
                    int i162 = shapeTable[link2 & 3][i11 & 3][link & 3];
                    int i172 = i7;
                    if (iSpecialChar != i6) {
                        i162 &= 1;
                    } else if (iSpecialChar == 2) {
                        i162 = (i4 != 0 || (i11 & 2) == 0 || (link2 & 1) == 0 || (c = cArr[i172]) == 1612 || c == 1613 || ((link2 & 32) == 32 && (i11 & 16) == 16)) ? 0 : 1;
                    }
                    if (iSpecialChar == 2) {
                        cArr[i172] = (char) ((link >> 8) + 65136 + i162);
                    } else if (i4 == 2) {
                        cArr[i172] = TASHKEEL_SPACE_SUB;
                        i7 = i172;
                        z = true;
                    } else {
                        cArr[i172] = (char) (irrelevantPos[cArr[i172] - 1611] + 65136 + i162);
                    }
                    i7 = i172;
                }
            } else {
                i5 = -1;
            }
            if ((link & 4) == 0) {
                i14 = i7;
                i12 = i11;
                i11 = link;
            }
            i7--;
            if (i7 == i13) {
                link = link2;
                i6 = 1;
                i13 = -2;
            } else {
                if (i7 != i5) {
                    link = getLink(cArr[i7]);
                }
                i6 = 1;
            }
        }
        int iHandleGeneratedSpaces = (i8 != 0 || z) ? handleGeneratedSpaces(cArr, i, i2) : i2;
        return (i9 == 0 && i10 == 0) ? iHandleGeneratedSpaces : expandCompositChar(cArr, i, iHandleGeneratedSpaces, iNormalize, 0);
    }

    private int deShapeUnicode(char[] cArr, int i, int i2, int i3) throws ArabicShapingException {
        int iDeshapeNormalize = deshapeNormalize(cArr, i, i2);
        return iDeshapeNormalize != 0 ? expandCompositChar(cArr, i, i2, iDeshapeNormalize, 1) : i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int internalShape(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4) throws ArabicShapingException {
        int i5;
        ArabicShaping arabicShaping;
        int i6;
        int iHandleTashkeelWithTatweel;
        char c;
        char c2;
        int i7;
        if (i2 == 0) {
            return 0;
        }
        if (i4 == 0) {
            int i8 = this.options;
            return ((i8 & 24) == 0 || (i8 & 65539) != 0) ? i2 : calculateSize(cArr, i, i2);
        }
        char[] cArr3 = new char[i2 * 2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        if (this.isLogical) {
            invertBuffer(cArr3, 0, i2);
        }
        int i9 = this.options;
        int i10 = i9 & 24;
        if (i10 != 8) {
            if (i10 == 16) {
                arabicShaping = this;
                i5 = i4;
                iHandleTashkeelWithTatweel = deShapeUnicode(cArr3, 0, i2, i5);
            } else if (i10 != 24) {
                arabicShaping = this;
                i6 = i2;
                i5 = i4;
            } else {
                arabicShaping = this;
                i5 = i4;
                iHandleTashkeelWithTatweel = arabicShaping.shapeUnicode(cArr3, 0, i2, i5, 1);
            }
            i6 = iHandleTashkeelWithTatweel;
        } else {
            i5 = i4;
            if ((i9 & TASHKEEL_MASK) > 0 && (i9 & TASHKEEL_MASK) != 786432) {
                iHandleTashkeelWithTatweel = shapeUnicode(cArr3, 0, i2, i5, 2);
                arabicShaping = this;
            } else {
                arabicShaping = this;
                int iShapeUnicode = arabicShaping.shapeUnicode(cArr3, 0, i2, i5, 0);
                if ((917504 & arabicShaping.options) == 786432) {
                    iHandleTashkeelWithTatweel = handleTashkeelWithTatweel(cArr3, i2);
                } else {
                    i6 = iShapeUnicode;
                }
            }
            i6 = iHandleTashkeelWithTatweel;
        }
        if (i6 > i5) {
            throw new ArabicShapingException("not enough room for result data");
        }
        int i11 = arabicShaping.options;
        if ((i11 & 224) != 0) {
            int i12 = i11 & 256;
            if (i12 == 0) {
                c = 1632;
            } else if (i12 != 256) {
                c2 = '0';
                i7 = i11 & 224;
                if (i7 != 32) {
                    int i13 = c2 - '0';
                    for (int i14 = 0; i14 < i6; i14++) {
                        char c3 = cArr3[i14];
                        if (c3 <= '9' && c3 >= '0') {
                            cArr3[i14] = (char) (c3 + i13);
                        }
                    }
                } else if (i7 == 64) {
                    char c4 = (char) (c2 + '\t');
                    int i15 = '0' - c2;
                    for (int i16 = 0; i16 < i6; i16++) {
                        char c5 = cArr3[i16];
                        if (c5 <= c4 && c5 >= c2) {
                            cArr3[i16] = (char) (c5 + i15);
                        }
                    }
                } else if (i7 == 96) {
                    arabicShaping = this;
                    arabicShaping.shapeToArabicDigitsWithContext(cArr3, 0, i6, c2, false);
                } else if (i7 == 128) {
                    arabicShaping.shapeToArabicDigitsWithContext(cArr3, 0, i6, c2, true);
                    arabicShaping = this;
                }
            } else {
                c = 1776;
            }
            c2 = c;
            i7 = i11 & 224;
            if (i7 != 32) {
            }
        }
        if (arabicShaping.isLogical) {
            invertBuffer(cArr3, 0, i6);
        }
        System.arraycopy(cArr3, 0, cArr2, i3, i6);
        return i6;
    }

    private static class ArabicShapingException extends RuntimeException {
        ArabicShapingException(String str) {
            super(str);
        }
    }
}

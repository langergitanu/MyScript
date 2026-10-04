package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public enum voListBulletKind2 {
    LIST_BULLET_KIND2_NONE,
    LIST_BULLET_KIND2_BULLET,
    LIST_BULLET_KIND2_NUMBER_ARABIC,
    LIST_BULLET_KIND2_NUMBER_CIRCLED,
    LIST_BULLET_KIND2_NUMBER_CHINESE,
    LIST_BULLET_KIND2_LATIN_LETTER_LOWER,
    LIST_BULLET_KIND2_LATIN_LETTER_UPPER,
    LIST_BULLET_KIND2_JAPANESE_HIRAGANA,
    LIST_BULLET_KIND2_JAPANESE_KATAKANA,
    LIST_BULLET_KIND2_KOREAN_HANGUL_CONSONANT,
    LIST_BULLET_KIND2_KOREAN_HANGUL_SYLLABLE,
    LIST_BULLET_KIND2_KOREAN_HANGUL_NUMBERING,
    LIST_BULLET_KIND2_KOREAN_CHINESE_NUMBERING,
    LIST_BULLET_KIND2_RUSSIAN_LETTER_LOWER,
    LIST_BULLET_KIND2_RUSSIAN_LETTER_UPPER,
    LIST_BULLET_KIND2_GREEK_NUMBER_LOWER,
    LIST_BULLET_KIND2_GREEK_NUMBER_UPPER,
    LIST_BULLET_KIND2_CHECKMARK,
    LIST_BULLET_KIND2_BALLOTBOX;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static voListBulletKind2 swigToEnum(int i) {
        voListBulletKind2[] volistbulletkind2Arr = (voListBulletKind2[]) voListBulletKind2.class.getEnumConstants();
        if (i < volistbulletkind2Arr.length && i >= 0) {
            voListBulletKind2 volistbulletkind2 = volistbulletkind2Arr[i];
            if (volistbulletkind2.swigValue == i) {
                return volistbulletkind2;
            }
        }
        for (voListBulletKind2 volistbulletkind22 : volistbulletkind2Arr) {
            if (volistbulletkind22.swigValue == i) {
                return volistbulletkind22;
            }
        }
        throw new IllegalArgumentException("No enum " + voListBulletKind2.class + " with value " + i);
    }

    voListBulletKind2() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    voListBulletKind2(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    voListBulletKind2(voListBulletKind2 volistbulletkind2) {
        int i = volistbulletkind2.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}

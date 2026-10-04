package com.ulduzsoft;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: FontManager.java */
/* JADX INFO: loaded from: classes8.dex */
class TTFAnalyzer {
    private RandomAccessFile m_file = null;

    TTFAnalyzer() {
    }

    public String getTtfFontName(String str) {
        int dword;
        try {
            this.m_file = new RandomAccessFile(str, "r");
            dword = readDword();
        } catch (FileNotFoundException | IOException unused) {
        }
        if (dword != 1953658213 && dword != 65536 && dword != 1330926671) {
            return null;
        }
        int word = readWord();
        readWord();
        readWord();
        readWord();
        for (int i = 0; i < word; i++) {
            int dword2 = readDword();
            readDword();
            int dword3 = readDword();
            int dword4 = readDword();
            if (dword2 == 1851878757) {
                byte[] bArr = new byte[dword4];
                this.m_file.seek(dword3);
                read(bArr);
                int word2 = getWord(bArr, 2);
                int word3 = getWord(bArr, 4);
                for (int i2 = 0; i2 < word2; i2++) {
                    int i3 = i2 * 12;
                    int word4 = getWord(bArr, i3 + 6);
                    if (getWord(bArr, i3 + 12) == 4 && word4 == 1) {
                        int word5 = getWord(bArr, i3 + 14);
                        int word6 = getWord(bArr, i3 + 16) + word3;
                        if (word6 >= 0 && word6 + word5 < dword4) {
                            this.m_file.close();
                            this.m_file = null;
                            return new String(bArr, word6, word5);
                        }
                    }
                }
            }
        }
        this.m_file.close();
        this.m_file = null;
        return null;
    }

    private int readByte() throws IOException {
        return this.m_file.read() & 255;
    }

    private int readWord() throws IOException {
        return (readByte() << 8) | readByte();
    }

    private int readDword() throws IOException {
        return (readByte() << 24) | (readByte() << 16) | (readByte() << 8) | readByte();
    }

    private void read(byte[] bArr) throws IOException {
        if (this.m_file.read(bArr) != bArr.length) {
            throw new IOException();
        }
    }

    private int getWord(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }
}

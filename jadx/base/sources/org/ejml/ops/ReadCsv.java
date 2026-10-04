package org.ejml.ops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class ReadCsv {
    private char comment;

    /* JADX INFO: renamed from: in */
    private BufferedReader f2757in;
    private boolean hasComment = false;
    private int lineNumber = 0;

    private boolean isSpace(char c) {
        return c == ' ' || c == '\t';
    }

    public ReadCsv(InputStream inputStream) {
        this.f2757in = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void setComment(char c) {
        this.hasComment = true;
        this.comment = c;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public BufferedReader getReader() {
        return this.f2757in;
    }

    protected List<String> extractWords() throws IOException {
        String line;
        do {
            this.lineNumber++;
            line = this.f2757in.readLine();
            if (line != null) {
                if (!this.hasComment) {
                    break;
                }
            } else {
                return null;
            }
        } while (line.charAt(0) == this.comment);
        return parseWords(line);
    }

    protected List<String> parseWords(String str) {
        ArrayList arrayList = new ArrayList();
        boolean z = !isSpace(str.charAt(0));
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (z) {
                if (isSpace(cCharAt)) {
                    arrayList.add(str.substring(i, i2));
                    z = false;
                }
            } else if (!isSpace(cCharAt)) {
                z = true;
                i = i2;
            }
        }
        if (z) {
            arrayList.add(str.substring(i));
        }
        return arrayList;
    }
}

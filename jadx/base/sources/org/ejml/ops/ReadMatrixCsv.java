package org.ejml.ops;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.ejml.data.CMatrixRMaj;
import org.ejml.data.DMatrix;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DMatrixSparseTriplet;
import org.ejml.data.FMatrix;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.FMatrixSparseTriplet;
import org.ejml.data.ZMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class ReadMatrixCsv extends ReadCsv {
    public ReadMatrixCsv(InputStream inputStream) {
        super(inputStream);
    }

    public <M extends FMatrix> M read32() throws IOException {
        boolean z;
        List<String> listExtractWords = extractWords();
        if (listExtractWords.size() == 3) {
            int i = Integer.parseInt(listExtractWords.get(0));
            int i2 = Integer.parseInt(listExtractWords.get(1));
            z = listExtractWords.get(2).compareToIgnoreCase("real") == 0;
            if (i < 0 || i2 < 0) {
                throw new IOException("Invalid number of rows and/or columns: " + i + " " + i2);
            }
            if (z) {
                return readFDRM(i, i2);
            }
            return (M) readCDRM(i, i2);
        }
        if (listExtractWords.size() == 4) {
            int i3 = Integer.parseInt(listExtractWords.get(0));
            int i4 = Integer.parseInt(listExtractWords.get(1));
            int i5 = Integer.parseInt(listExtractWords.get(2));
            z = listExtractWords.get(3).compareToIgnoreCase("real") == 0;
            if (i3 < 0 || i4 < 0) {
                throw new IOException("Invalid number of rows and/or columns: " + i3 + " " + i4);
            }
            if (z) {
                return readFSTR(i3, i4, i5);
            }
            throw new IllegalArgumentException("Sparse complex not yet supported");
        }
        throw new IOException("Unexpected number of words on the first line. Found " + listExtractWords.size());
    }

    public <M extends DMatrix> M read64() throws IOException {
        boolean z;
        List<String> listExtractWords = extractWords();
        if (listExtractWords.size() == 3) {
            int i = Integer.parseInt(listExtractWords.get(0));
            int i2 = Integer.parseInt(listExtractWords.get(1));
            z = listExtractWords.get(2).compareToIgnoreCase("real") == 0;
            if (i < 0 || i2 < 0) {
                throw new IOException("Invalid number of rows and/or columns: " + i + " " + i2);
            }
            if (z) {
                return readDDRM(i, i2);
            }
            return (M) readZDRM(i, i2);
        }
        if (listExtractWords.size() == 4) {
            int i3 = Integer.parseInt(listExtractWords.get(0));
            int i4 = Integer.parseInt(listExtractWords.get(1));
            int i5 = Integer.parseInt(listExtractWords.get(2));
            z = listExtractWords.get(3).compareToIgnoreCase("real") == 0;
            if (i3 < 0 || i4 < 0) {
                throw new IOException("Invalid number of rows and/or columns: " + i3 + " " + i4);
            }
            if (z) {
                return readDSTR(i3, i4, i5);
            }
            throw new IllegalArgumentException("Sparse complex not yet supported");
        }
        throw new IOException("Unexpected number of words on the first line. Found " + listExtractWords.size());
    }

    public DMatrixRMaj readDDRM(int i, int i2) throws IOException {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i2);
        for (int i3 = 0; i3 < i; i3++) {
            List<String> listExtractWords = extractWords();
            if (listExtractWords == null) {
                throw new IOException("Too few rows found. expected " + i + " actual " + i3);
            }
            if (listExtractWords.size() != i2) {
                throw new IOException("Unexpected number of words in column. Found " + listExtractWords.size() + " expected " + i2);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                dMatrixRMaj.set(i3, i4, Double.parseDouble(listExtractWords.get(i4)));
            }
        }
        return dMatrixRMaj;
    }

    public FMatrixRMaj readFDRM(int i, int i2) throws IOException {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i2);
        for (int i3 = 0; i3 < i; i3++) {
            List<String> listExtractWords = extractWords();
            if (listExtractWords == null) {
                throw new IOException("Too few rows found. expected " + i + " actual " + i3);
            }
            if (listExtractWords.size() != i2) {
                throw new IOException("Unexpected number of words in column. Found " + listExtractWords.size() + " expected " + i2);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                fMatrixRMaj.set(i3, i4, Float.parseFloat(listExtractWords.get(i4)));
            }
        }
        return fMatrixRMaj;
    }

    public ZMatrixRMaj readZDRM(int i, int i2) throws IOException {
        ZMatrixRMaj zMatrixRMaj = new ZMatrixRMaj(i, i2);
        int i3 = i2 * 2;
        for (int i4 = 0; i4 < i; i4++) {
            List<String> listExtractWords = extractWords();
            if (listExtractWords == null) {
                throw new IOException("Too few rows found. expected " + i + " actual " + i4);
            }
            if (listExtractWords.size() != i3) {
                throw new IOException("Unexpected number of words in column. Found " + listExtractWords.size() + " expected " + i3);
            }
            for (int i5 = 0; i5 < i3; i5 += 2) {
                zMatrixRMaj.set(i4, i5, Double.parseDouble(listExtractWords.get(i5)), Double.parseDouble(listExtractWords.get(i5 + 1)));
            }
        }
        return zMatrixRMaj;
    }

    public CMatrixRMaj readCDRM(int i, int i2) throws IOException {
        CMatrixRMaj cMatrixRMaj = new CMatrixRMaj(i, i2);
        int i3 = i2 * 2;
        for (int i4 = 0; i4 < i; i4++) {
            List<String> listExtractWords = extractWords();
            if (listExtractWords == null) {
                throw new IOException("Too few rows found. expected " + i + " actual " + i4);
            }
            if (listExtractWords.size() != i3) {
                throw new IOException("Unexpected number of words in column. Found " + listExtractWords.size() + " expected " + i3);
            }
            for (int i5 = 0; i5 < i3; i5 += 2) {
                cMatrixRMaj.set(i4, i5, Float.parseFloat(listExtractWords.get(i5)), Float.parseFloat(listExtractWords.get(i5 + 1)));
            }
        }
        return cMatrixRMaj;
    }

    private FMatrixSparseTriplet readFSTR(int i, int i2, int i3) throws IOException {
        FMatrixSparseTriplet fMatrixSparseTriplet = new FMatrixSparseTriplet(i, i2, i3);
        for (int i4 = 0; i4 < i3; i4++) {
            List<String> listExtractWords = extractWords();
            if (listExtractWords.size() != 3) {
                throw new IllegalArgumentException("Unexpected number of words on line " + getLineNumber());
            }
            fMatrixSparseTriplet.addItem(Integer.parseInt(listExtractWords.get(0)), Integer.parseInt(listExtractWords.get(1)), Float.parseFloat(listExtractWords.get(2)));
        }
        return fMatrixSparseTriplet;
    }

    private DMatrixSparseTriplet readDSTR(int i, int i2, int i3) throws IOException {
        DMatrixSparseTriplet dMatrixSparseTriplet = new DMatrixSparseTriplet(i, i2, i3);
        for (int i4 = 0; i4 < i3; i4++) {
            List<String> listExtractWords = extractWords();
            if (listExtractWords.size() != 3) {
                throw new IllegalArgumentException("Unexpected number of words on line " + getLineNumber());
            }
            dMatrixSparseTriplet.addItem(Integer.parseInt(listExtractWords.get(0)), Integer.parseInt(listExtractWords.get(1)), Double.parseDouble(listExtractWords.get(2)));
        }
        return dMatrixSparseTriplet;
    }
}

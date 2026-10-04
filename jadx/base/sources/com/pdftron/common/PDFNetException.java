package com.pdftron.common;

/* JADX INFO: loaded from: classes7.dex */
public class PDFNetException extends Exception {
    public static final long e_error_credentials = 2;
    public static final long e_error_general = 0;
    public static final long e_error_network = 1;
    public static final long e_error_num = 3;
    protected String cond_expr;
    protected long error_code;
    protected String file_name;
    protected String function;
    protected long line_number;
    protected String message;

    private PDFNetException(String str) {
        String[] strArrSplit = str.split("%%%");
        if (strArrSplit.length == 5) {
            this.cond_expr = strArrSplit[0];
            this.line_number = Long.parseLong(strArrSplit[1]);
            this.file_name = strArrSplit[2];
            this.function = strArrSplit[3];
            this.message = strArrSplit[4];
            return;
        }
        if (strArrSplit.length == 6) {
            this.cond_expr = strArrSplit[0];
            this.line_number = Long.parseLong(strArrSplit[1]);
            this.file_name = strArrSplit[2];
            this.function = strArrSplit[3];
            this.message = strArrSplit[4];
            this.error_code = Long.parseLong(strArrSplit[5]);
            return;
        }
        this.message = str;
        this.line_number = 0L;
    }

    public PDFNetException(String str, long j, String str2, String str3, String str4) {
        this.cond_expr = str;
        this.line_number = j;
        this.file_name = str2;
        this.function = str3;
        this.message = str4;
        this.error_code = 0L;
    }

    public PDFNetException(String str, long j, String str2, String str3, String str4, long j2) {
        this.cond_expr = str;
        this.line_number = j;
        this.file_name = str2;
        this.function = str3;
        this.message = str4;
        this.error_code = j2;
    }

    public String getCondExpr() {
        return this.cond_expr;
    }

    public String getFileName() {
        return this.file_name;
    }

    public int getLineNumber() {
        return (int) this.line_number;
    }

    public String getFunction() {
        return this.function;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public long getErrorCode() {
        return this.error_code;
    }

    @Override // java.lang.Throwable
    public String toString() {
        if (this.line_number != 0) {
            return "Exception: \n\t Message: " + getMessage() + "\n\t Conditional expression: " + getCondExpr() + "\n\t Filename   : " + getFileName() + "\n\t Function   : " + getFunction() + "\n\t Linenumber : " + getLineNumber() + "\n\t Error code : " + getErrorCode() + "\n";
        }
        return super.toString();
    }
}

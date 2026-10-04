package com.dropbox.core;

import java.io.IOException;
import java.security.cert.CertPathValidatorException;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkIOException extends DbxException {
    private static final long serialVersionUID = 0;

    public NetworkIOException(IOException iOException) {
        super(computeMessage(iOException), iOException);
    }

    private static String computeMessage(IOException iOException) {
        String message = iOException.getMessage();
        if (iOException instanceof SSLHandshakeException) {
            Throwable cause = iOException.getCause();
            if (cause instanceof CertPathValidatorException) {
                return message + "[CERT PATH: " + ((CertPathValidatorException) cause).getCertPath() + "]";
            }
        }
        return message;
    }

    @Override // java.lang.Throwable
    public IOException getCause() {
        return (IOException) super.getCause();
    }
}

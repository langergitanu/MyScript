package com.google.auth.oauth2;

/* JADX INFO: loaded from: classes6.dex */
public interface PKCEProvider {
    String getCodeChallenge();

    String getCodeChallengeMethod();

    String getCodeVerifier();
}

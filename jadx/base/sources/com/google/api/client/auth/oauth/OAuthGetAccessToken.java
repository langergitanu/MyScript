package com.google.api.client.auth.oauth;

/* JADX INFO: loaded from: classes6.dex */
public class OAuthGetAccessToken extends AbstractOAuthGetToken {
    public String temporaryToken;
    public String verifier;

    public OAuthGetAccessToken(String str) {
        super(str);
    }

    @Override // com.google.api.client.auth.oauth.AbstractOAuthGetToken
    public OAuthParameters createParameters() {
        OAuthParameters oAuthParametersCreateParameters = super.createParameters();
        oAuthParametersCreateParameters.token = this.temporaryToken;
        oAuthParametersCreateParameters.verifier = this.verifier;
        return oAuthParametersCreateParameters;
    }
}

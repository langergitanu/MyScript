package com.myscript.nebo.dms.gdrive;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpBackOffIOExceptionHandler;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.drive.Drive;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes7.dex */
public final class DriveLoginHelper {
    public static final String DRIVE_APP_NAME = "DriveDemo";
    private static final String TAG = "DriveLoginHelper";
    private static DriveLoginHelper mSingleton;
    private static final ExecutorService sExecutor = Executors.newSingleThreadExecutor();
    private static final Handler sMainHandler = new Handler(Looper.getMainLooper());
    private String mAccessToken = null;
    private TokenProvider mTokenProvider = null;
    private Drive mCachedDriveService = null;
    private String mCachedAccessToken = null;

    public interface ConnectionCallback {
        void onResult(boolean z, Exception exc);
    }

    public interface TokenProvider {
        String provideAccessToken();

        String refreshAccessToken();
    }

    static class DriveLoginException extends IllegalStateException {
        DriveLoginException(String str) {
            super(str);
        }
    }

    public static DriveLoginHelper getInstance() {
        if (!hasInstance()) {
            mSingleton = new DriveLoginHelper();
        }
        return mSingleton;
    }

    public static boolean hasInstance() {
        return mSingleton != null;
    }

    public static void destroy() {
        DriveLoginHelper driveLoginHelper = mSingleton;
        if (driveLoginHelper != null) {
            driveLoginHelper.mCachedDriveService = null;
            driveLoginHelper.mCachedAccessToken = null;
            driveLoginHelper.mTokenProvider = null;
        }
        mSingleton = null;
    }

    public void setAccessToken(String str) {
        if (!str.equals(this.mAccessToken)) {
            this.mCachedDriveService = null;
            this.mCachedAccessToken = null;
        }
        this.mAccessToken = str;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public void setTokenProvider(TokenProvider tokenProvider) {
        this.mTokenProvider = tokenProvider;
    }

    private GoogleCredentials createRefreshableCredentials(AccessToken accessToken) {
        return new GoogleCredentials(accessToken) { // from class: com.myscript.nebo.dms.gdrive.DriveLoginHelper.1
            @Override // com.google.auth.oauth2.OAuth2Credentials
            public AccessToken refreshAccessToken() throws DriveLoginException {
                String strRefreshAccessToken = DriveLoginHelper.this.mTokenProvider != null ? DriveLoginHelper.this.mTokenProvider.refreshAccessToken() : null;
                if (strRefreshAccessToken == null && DriveLoginHelper.this.mTokenProvider != null) {
                    Log.w(DriveLoginHelper.TAG, "Silent refresh returned null, trying full re-authorization");
                    strRefreshAccessToken = DriveLoginHelper.this.mTokenProvider.provideAccessToken();
                }
                if (strRefreshAccessToken != null) {
                    Log.i(DriveLoginHelper.TAG, "Access token refreshed successfully");
                    DriveLoginHelper.this.setAccessToken(strRefreshAccessToken);
                    return new AccessToken(strRefreshAccessToken, new Date(System.currentTimeMillis() + DurationKt.MILLIS_IN_HOUR));
                }
                throw new DriveLoginException("All token refresh strategies failed, cannot refresh access token.");
            }
        };
    }

    public Drive getDriveService() {
        String str = this.mAccessToken;
        if (str == null) {
            throw new DriveLoginException("Need to setup a valid access token");
        }
        if (this.mCachedDriveService != null && str.equals(this.mCachedAccessToken)) {
            return this.mCachedDriveService;
        }
        NetHttpTransport netHttpTransportBuild = new NetHttpTransport.Builder().build();
        final HttpCredentialsAdapter httpCredentialsAdapter = new HttpCredentialsAdapter(createRefreshableCredentials(new AccessToken(this.mAccessToken, new Date(System.currentTimeMillis() + DurationKt.MILLIS_IN_HOUR))));
        Drive driveBuild = new Drive.Builder(netHttpTransportBuild, GsonFactory.getDefaultInstance(), httpCredentialsAdapter).setApplicationName(DRIVE_APP_NAME).setHttpRequestInitializer(new HttpRequestInitializer() { // from class: com.myscript.nebo.dms.gdrive.DriveLoginHelper$$ExternalSyntheticLambda0
            @Override // com.google.api.client.http.HttpRequestInitializer
            public final void initialize(HttpRequest httpRequest) throws IOException {
                DriveLoginHelper.lambda$getDriveService$2(httpCredentialsAdapter, httpRequest);
            }
        }).build();
        this.mCachedDriveService = driveBuild;
        this.mCachedAccessToken = this.mAccessToken;
        return driveBuild;
    }

    static /* synthetic */ void lambda$getDriveService$2(final HttpCredentialsAdapter httpCredentialsAdapter, HttpRequest httpRequest) throws IOException {
        httpCredentialsAdapter.initialize(httpRequest);
        httpRequest.setIOExceptionHandler(new HttpBackOffIOExceptionHandler(new ExponentialBackOff()));
        final HttpBackOffUnsuccessfulResponseHandler httpBackOffUnsuccessfulResponseHandler = new HttpBackOffUnsuccessfulResponseHandler(new ExponentialBackOff());
        httpBackOffUnsuccessfulResponseHandler.setBackOffRequired(new HttpBackOffUnsuccessfulResponseHandler.BackOffRequired() { // from class: com.myscript.nebo.dms.gdrive.DriveLoginHelper$$ExternalSyntheticLambda3
            @Override // com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler.BackOffRequired
            public final boolean isRequired(HttpResponse httpResponse) {
                return DriveLoginHelper.lambda$getDriveService$0(httpResponse);
            }
        });
        httpRequest.setUnsuccessfulResponseHandler(new HttpUnsuccessfulResponseHandler() { // from class: com.myscript.nebo.dms.gdrive.DriveLoginHelper$$ExternalSyntheticLambda4
            @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
            public final boolean handleResponse(HttpRequest httpRequest2, HttpResponse httpResponse, boolean z) {
                return DriveLoginHelper.lambda$getDriveService$1(httpCredentialsAdapter, httpBackOffUnsuccessfulResponseHandler, httpRequest2, httpResponse, z);
            }
        });
    }

    static /* synthetic */ boolean lambda$getDriveService$0(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        if (statusCode == 403) {
            return GDriveCallbackKt.isUserLimitExceeded(GoogleJsonResponseException.from(GsonFactory.getDefaultInstance(), httpResponse));
        }
        return statusCode == 429;
    }

    static /* synthetic */ boolean lambda$getDriveService$1(HttpCredentialsAdapter httpCredentialsAdapter, HttpBackOffUnsuccessfulResponseHandler httpBackOffUnsuccessfulResponseHandler, HttpRequest httpRequest, HttpResponse httpResponse, boolean z) throws IOException {
        if (httpCredentialsAdapter.handleResponse(httpRequest, httpResponse, z)) {
            return true;
        }
        return httpBackOffUnsuccessfulResponseHandler.handleResponse(httpRequest, httpResponse, z);
    }

    public static void isWellConnectedAsync(final ConnectionCallback connectionCallback) {
        sExecutor.execute(new Runnable() { // from class: com.myscript.nebo.dms.gdrive.DriveLoginHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DriveLoginHelper.lambda$isWellConnectedAsync$4(connectionCallback);
            }
        });
    }

    static /* synthetic */ void lambda$isWellConnectedAsync$4(final ConnectionCallback connectionCallback) {
        final boolean z;
        try {
        } catch (Exception e) {
            e = e;
            Log.e(TAG, "isWellConnectedAsync error: " + e);
            z = false;
        }
        if (getInstance().mAccessToken == null || getInstance().mAccessToken.isEmpty()) {
            throw new DriveLoginException("Access token is null or empty");
        }
        getInstance().getDriveService().about().get().setFields2("user").execute();
        e = null;
        z = true;
        sMainHandler.post(new Runnable() { // from class: com.myscript.nebo.dms.gdrive.DriveLoginHelper$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                connectionCallback.onResult(z, e);
            }
        });
    }
}

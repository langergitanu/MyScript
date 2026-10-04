package org.apache.http.impl.client;

import androidx.credentials.provider.CredentialEntry;
import com.myscript.shared.datacollect.DataCollectAnalyticsEvents;
import java.net.ProxySelector;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class SystemDefaultHttpClient extends DefaultHttpClient {
    public SystemDefaultHttpClient(HttpParams httpParams) {
        super(null, httpParams);
    }

    public SystemDefaultHttpClient() {
        super(null, null);
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected ClientConnectionManager createClientConnectionManager() {
        PoolingClientConnectionManager poolingClientConnectionManager = new PoolingClientConnectionManager(SchemeRegistryFactory.createSystemDefault());
        if (CredentialEntry.TRUE_STRING.equalsIgnoreCase(System.getProperty("http.keepAlive", CredentialEntry.TRUE_STRING))) {
            int i = Integer.parseInt(System.getProperty("http.maxConnections", DataCollectAnalyticsEvents.COLLECT_FILE_COUNT_5));
            poolingClientConnectionManager.setDefaultMaxPerRoute(i);
            poolingClientConnectionManager.setMaxTotal(i * 2);
        }
        return poolingClientConnectionManager;
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected HttpRoutePlanner createHttpRoutePlanner() {
        return new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), ProxySelector.getDefault());
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected ConnectionReuseStrategy createConnectionReuseStrategy() {
        if (CredentialEntry.TRUE_STRING.equalsIgnoreCase(System.getProperty("http.keepAlive", CredentialEntry.TRUE_STRING))) {
            return new DefaultConnectionReuseStrategy();
        }
        return new NoConnectionReuseStrategy();
    }
}

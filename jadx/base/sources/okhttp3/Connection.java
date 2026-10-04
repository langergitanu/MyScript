package okhttp3;

import java.net.Socket;
import kotlin.Metadata;

/* JADX INFO: compiled from: Connection.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lokhttp3/Connection;", "", "route", "Lokhttp3/Route;", "socket", "Ljava/net/Socket;", "handshake", "Lokhttp3/Handshake;", "protocol", "Lokhttp3/Protocol;", "okhttp"}, m1600k = 1, m1601mv = {2, 2, 0}, m1603xi = 48)
public interface Connection {
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}

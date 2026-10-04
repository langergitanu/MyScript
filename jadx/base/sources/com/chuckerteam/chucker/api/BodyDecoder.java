package com.chuckerteam.chucker.api;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.IOException;
import kotlin.Metadata;
import okhttp3.Request;
import okhttp3.Response;
import okio.ByteString;

/* JADX INFO: compiled from: BodyDecoder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Lcom/chuckerteam/chucker/api/BodyDecoder;", "", "decodeRequest", "", "request", "Lokhttp3/Request;", TtmlNode.TAG_BODY, "Lokio/ByteString;", "decodeResponse", "response", "Lokhttp3/Response;", "com.github.ChuckerTeam.Chucker.library"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface BodyDecoder {
    String decodeRequest(Request request, ByteString body) throws IOException;

    String decodeResponse(Response response, ByteString body) throws IOException;
}

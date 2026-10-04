package org.apache.http.p044io;

import org.apache.http.HttpMessage;
import org.apache.http.config.MessageConstraints;

/* JADX INFO: loaded from: classes7.dex */
public interface HttpMessageParserFactory<T extends HttpMessage> {
    HttpMessageParser<T> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints);
}

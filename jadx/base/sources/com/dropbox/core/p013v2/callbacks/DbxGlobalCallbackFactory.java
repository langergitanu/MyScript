package com.dropbox.core.p013v2.callbacks;

/* JADX INFO: loaded from: classes4.dex */
public interface DbxGlobalCallbackFactory {
    DbxNetworkErrorCallback createNetworkErrorCallback(String str);

    <T> DbxRouteErrorCallback<T> createRouteErrorCallback(String str, T t);
}

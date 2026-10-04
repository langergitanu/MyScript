package com.myscript.atk.core;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IMessageListener {
    void notify(String str, MessageIdentifier messageIdentifier, String str2, String str3, String str4);

    void notify(String str, List<String> list, String str2, String str3, String str4);
}

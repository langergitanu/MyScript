package com.myscript.snt.core;

import com.myscript.atk.core.ChildPageSpec;
import com.myscript.atk.core.Point;
import com.myscript.atk.p021ui.ActionMenuEntry;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface IChildPageManager {
    void addChildPageListener(IChildPageListener iChildPageListener);

    String childPageCustomAttribute(String str, String str2);

    void childPageSetCustomAttribute(String str, String str2, String str3);

    String createChildPage(String str);

    String createChildPage(String str, boolean z);

    void displayChildPage(String str);

    String duplicateChildPage(String str);

    String duplicateChildPage(String str, boolean z);

    List<ActionMenuEntry> getChildPageActionMenuEntries(String str);

    String getChildPageIdAt(Point point);

    String getChildPageIdAtPageNumber(long j);

    String getChildPageIdDisplayed();

    List<ChildPageSpec> getChildPageList();

    ChildPageSpec getChildPageSpec(String str);

    String getChildPageText(String str);

    String getChildPageText(String str, boolean z);

    int getNumberOfChildPages();

    void moveChildPage(String str, String str2);

    void moveChildPage(String str, String str2, boolean z);

    void removeChildPage(String str);

    void removeChildPageListener(IChildPageListener iChildPageListener);
}

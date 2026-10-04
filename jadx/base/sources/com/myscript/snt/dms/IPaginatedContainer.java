package com.myscript.snt.dms;

import com.myscript.atk.core.BackgroundPattern;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.snt.core.IChildPageThumbnailGenerator;
import com.myscript.snt.core.IThumbnailerImageRequester;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface IPaginatedContainer {
    void addListener(IPaginatedContainerListener iPaginatedContainerListener);

    IChildPageThumbnailGenerator createChildPageThumbnailGenerator(IThumbnailerImageRequester iThumbnailerImageRequester, IColorInversionPolicy iColorInversionPolicy);

    String createPage(String str, boolean z);

    void delete();

    String duplicatePage(String str, boolean z);

    boolean isValidPageId(String str);

    void movePage(String str, String str2, boolean z);

    List<PageAction> pageActions(String str);

    String pageAt(long j);

    long pageCount();

    PageProperties pageProperties(String str);

    List<PageProperties> pages();

    void removeListener(IPaginatedContainerListener iPaginatedContainerListener);

    void removePage(String str);

    void removePages(List<String> list);

    void selectPage(String str, boolean z);

    String selectedPage();

    void setPageBackgroundColor(String str, int i);

    void setPageBackgroundPattern(String str, BackgroundPattern backgroundPattern);
}

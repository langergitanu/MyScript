package com.myscript.atk.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class Document {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Document(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Document document) {
        if (document == null) {
            return 0L;
        }
        return document.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Document(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static Document open(File file) {
        return open(file, true);
    }

    public static Document open(File file, boolean z) {
        return open(file.getAbsolutePath(), z);
    }

    public void saveAs(File file) {
        saveAs(file.getAbsolutePath());
    }

    public boolean move(File file) {
        return move(file.getAbsolutePath());
    }

    public File getFile() {
        return new File(getFilePath());
    }

    public void setStyleSheet(File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        setStyleSheet(file.getAbsolutePath());
    }

    public void setStyleSheet(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                } else {
                    bufferedReader.close();
                    setStyleSheetFromString(sb.toString());
                    return;
                }
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        }
    }

    public void setStyleSheet(URL url) throws IOException {
        setStyleSheet(url.openStream());
    }

    public static boolean isOpened(String str) {
        return ATKCoreJNI.Document_isOpened(str.getBytes());
    }

    public static Document open(String str, boolean z) {
        long jDocument_open__SWIG_0 = ATKCoreJNI.Document_open__SWIG_0(str.getBytes(), z);
        if (jDocument_open__SWIG_0 == 0) {
            return null;
        }
        return new Document(jDocument_open__SWIG_0, true);
    }

    public static Document open(String str) {
        long jDocument_open__SWIG_1 = ATKCoreJNI.Document_open__SWIG_1(str.getBytes());
        if (jDocument_open__SWIG_1 == 0) {
            return null;
        }
        return new Document(jDocument_open__SWIG_1, true);
    }

    public static Document open(String str, String str2, boolean z) {
        long jDocument_open__SWIG_2 = ATKCoreJNI.Document_open__SWIG_2(str.getBytes(), str2.getBytes(), z);
        if (jDocument_open__SWIG_2 == 0) {
            return null;
        }
        return new Document(jDocument_open__SWIG_2, true);
    }

    public static Document open(String str, String str2) {
        long jDocument_open__SWIG_3 = ATKCoreJNI.Document_open__SWIG_3(str.getBytes(), str2.getBytes());
        if (jDocument_open__SWIG_3 == 0) {
            return null;
        }
        return new Document(jDocument_open__SWIG_3, true);
    }

    public static Document open(String str, String str2, boolean z, boolean z2) {
        long jDocument_open__SWIG_4 = ATKCoreJNI.Document_open__SWIG_4(str.getBytes(), str2.getBytes(), z, z2);
        if (jDocument_open__SWIG_4 == 0) {
            return null;
        }
        return new Document(jDocument_open__SWIG_4, true);
    }

    public static Document open(String str, SWIGTYPE_p_ATK_CHAR_TYPE sWIGTYPE_p_ATK_CHAR_TYPE, boolean z) {
        long jDocument_open__SWIG_5 = ATKCoreJNI.Document_open__SWIG_5(str.getBytes(), SWIGTYPE_p_ATK_CHAR_TYPE.getCPtr(sWIGTYPE_p_ATK_CHAR_TYPE), z);
        if (jDocument_open__SWIG_5 == 0) {
            return null;
        }
        return new Document(jDocument_open__SWIG_5, true);
    }

    public static Document open(String str, SWIGTYPE_p_ATK_CHAR_TYPE sWIGTYPE_p_ATK_CHAR_TYPE) {
        long jDocument_open__SWIG_6 = ATKCoreJNI.Document_open__SWIG_6(str.getBytes(), SWIGTYPE_p_ATK_CHAR_TYPE.getCPtr(sWIGTYPE_p_ATK_CHAR_TYPE));
        if (jDocument_open__SWIG_6 == 0) {
            return null;
        }
        return new Document(jDocument_open__SWIG_6, true);
    }

    public static Document openTemp() {
        long jDocument_openTemp = ATKCoreJNI.Document_openTemp();
        if (jDocument_openTemp == 0) {
            return null;
        }
        return new Document(jDocument_openTemp, true);
    }

    public static boolean removeOnDestroy(Document document) {
        return ATKCoreJNI.Document_removeOnDestroy__SWIG_0(getCPtr(document), document);
    }

    public static boolean move(Document document, String str) {
        return ATKCoreJNI.Document_move__SWIG_0(getCPtr(document), document, str.getBytes());
    }

    public void setTemporaryDirectory(String str) {
        ATKCoreJNI.Document_setTemporaryDirectory(this.swigCPtr, this, str.getBytes());
    }

    public Json getMetadata() {
        return new Json(ATKCoreJNI.Document_getMetadata(this.swigCPtr, this), true);
    }

    public void setMetadata(Json json) {
        ATKCoreJNI.Document_setMetadata(this.swigCPtr, this, Json.getCPtr(json), json);
    }

    public String getFilePath() {
        return new String(ATKCoreJNI.Document_getFilePath(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public long sessionID() {
        return ATKCoreJNI.Document_sessionID(this.swigCPtr, this);
    }

    public boolean isModified() {
        return ATKCoreJNI.Document_isModified(this.swigCPtr, this);
    }

    public int getNumberOfPages() {
        return ATKCoreJNI.Document_getNumberOfPages(this.swigCPtr, this);
    }

    public boolean hasPages() {
        return ATKCoreJNI.Document_hasPages(this.swigCPtr, this);
    }

    public Page getPage(int i) {
        return new Page(ATKCoreJNI.Document_getPage__SWIG_0(this.swigCPtr, this, i), true);
    }

    public Page getPage(String str) {
        return new Page(ATKCoreJNI.Document_getPage__SWIG_1(this.swigCPtr, this, str.getBytes()), true);
    }

    public String pageId(int i) {
        return new String(ATKCoreJNI.Document_pageId(this.swigCPtr, this, i), StandardCharsets.UTF_8);
    }

    public Page addPage() {
        return new Page(ATKCoreJNI.Document_addPage(this.swigCPtr, this), true);
    }

    public Page addPageAt(int i) {
        return new Page(ATKCoreJNI.Document_addPageAt(this.swigCPtr, this, i), true);
    }

    public void movePage(int i, int i2) {
        ATKCoreJNI.Document_movePage(this.swigCPtr, this, i, i2);
    }

    public boolean removeFirstPage() {
        return ATKCoreJNI.Document_removeFirstPage(this.swigCPtr, this);
    }

    public boolean removePageAt(int i) {
        return ATKCoreJNI.Document_removePageAt(this.swigCPtr, this, i);
    }

    public boolean removeLastPage() {
        return ATKCoreJNI.Document_removeLastPage(this.swigCPtr, this);
    }

    public int indexOfPage(Page page) {
        return ATKCoreJNI.Document_indexOfPage(this.swigCPtr, this, Page.getCPtr(page), page);
    }

    public Page importPage(Page page) {
        return new Page(ATKCoreJNI.Document_importPage(this.swigCPtr, this, Page.getCPtr(page), page), true);
    }

    public void save() {
        ATKCoreJNI.Document_save(this.swigCPtr, this);
    }

    public void saveAs(String str) {
        ATKCoreJNI.Document_saveAs(this.swigCPtr, this, str.getBytes());
    }

    public void saveToTemp() {
        ATKCoreJNI.Document_saveToTemp(this.swigCPtr, this);
    }

    public boolean move(String str) {
        return ATKCoreJNI.Document_move__SWIG_1(this.swigCPtr, this, str.getBytes());
    }

    public void discardUnSavedChanges(boolean z) {
        ATKCoreJNI.Document_discardUnSavedChanges__SWIG_0(this.swigCPtr, this, z);
    }

    public void discardUnSavedChanges() {
        ATKCoreJNI.Document_discardUnSavedChanges__SWIG_1(this.swigCPtr, this);
    }

    public boolean existsOnFileSystem() {
        return ATKCoreJNI.Document_existsOnFileSystem(this.swigCPtr, this);
    }

    public boolean removeOnDestroy() {
        return ATKCoreJNI.Document_removeOnDestroy__SWIG_1(this.swigCPtr, this);
    }

    public boolean willBeRemoved() {
        return ATKCoreJNI.Document_willBeRemoved(this.swigCPtr, this);
    }

    public void setStyleSheet(String str) {
        ATKCoreJNI.Document_setStyleSheet(this.swigCPtr, this, str.getBytes());
    }

    public void setStyleSheetFromString(String str) {
        ATKCoreJNI.Document_setStyleSheetFromString(this.swigCPtr, this, str.getBytes());
    }

    public String getStyleSheet() {
        return new String(ATKCoreJNI.Document_getStyleSheet(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean callbackPending() {
        return ATKCoreJNI.Document_callbackPending(this.swigCPtr, this);
    }

    public void sync() {
        ATKCoreJNI.Document_sync(this.swigCPtr, this);
    }

    public void setAutoCleanUp(boolean z) {
        ATKCoreJNI.Document_setAutoCleanUp(this.swigCPtr, this, z);
    }

    public void setIOControlCallback(C6021x42cd04d1 c6021x42cd04d1, boolean z) {
        ATKCoreJNI.Document_setIOControlCallback__SWIG_0(this.swigCPtr, this, C6021x42cd04d1.getCPtr(c6021x42cd04d1), z);
    }

    public void setIOControlCallback(C6021x42cd04d1 c6021x42cd04d1) {
        ATKCoreJNI.Document_setIOControlCallback__SWIG_1(this.swigCPtr, this, C6021x42cd04d1.getCPtr(c6021x42cd04d1));
    }

    public void setPreventCompatWhenAnalyzerEnd2End(boolean z) {
        ATKCoreJNI.Document_setPreventCompatWhenAnalyzerEnd2End(this.swigCPtr, this, z);
    }

    public boolean isPreventCompatWhenAnalyzerEnd2End() {
        return ATKCoreJNI.Document_isPreventCompatWhenAnalyzerEnd2End(this.swigCPtr, this);
    }

    public int hashCode() {
        return ATKCoreJNI.Document_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(Document document) {
        return ATKCoreJNI.Document_nativeEquals(this.swigCPtr, this, getCPtr(document), document);
    }

    public String toString() {
        return new String(ATKCoreJNI.Document_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public enum IOControlAction {
        ON_DESTRUCT,
        ON_SAVE,
        ON_SAVE_TO_TEMP;

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static IOControlAction swigToEnum(int i) {
            IOControlAction[] iOControlActionArr = (IOControlAction[]) IOControlAction.class.getEnumConstants();
            if (i < iOControlActionArr.length && i >= 0) {
                IOControlAction iOControlAction = iOControlActionArr[i];
                if (iOControlAction.swigValue == i) {
                    return iOControlAction;
                }
            }
            for (IOControlAction iOControlAction2 : iOControlActionArr) {
                if (iOControlAction2.swigValue == i) {
                    return iOControlAction2;
                }
            }
            throw new IllegalArgumentException("No enum " + IOControlAction.class + " with value " + i);
        }

        IOControlAction() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        IOControlAction(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        IOControlAction(IOControlAction iOControlAction) {
            int i = iOControlAction.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }
}

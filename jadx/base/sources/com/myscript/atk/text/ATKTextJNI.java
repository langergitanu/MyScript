package com.myscript.atk.text;

import com.myscript.atk.core.Point;

/* JADX INFO: loaded from: classes4.dex */
public class ATKTextJNI {
    public static final native void ChildPageCursor_clear(long j, ChildPageCursor childPageCursor);

    public static final native byte[] ChildPageCursor_id_get(long j, ChildPageCursor childPageCursor);

    public static final native void ChildPageCursor_id_set(long j, ChildPageCursor childPageCursor, byte[] bArr);

    public static final native long ChildPageCursor_index_get(long j, ChildPageCursor childPageCursor);

    public static final native void ChildPageCursor_index_set(long j, ChildPageCursor childPageCursor, long j2);

    public static final native boolean ClipboardConfiguration_exportHeader_get(long j, ClipboardConfiguration clipboardConfiguration);

    public static final native void ClipboardConfiguration_exportHeader_set(long j, ClipboardConfiguration clipboardConfiguration, boolean z);

    public static final native boolean ClipboardConfiguration_exportImage_get(long j, ClipboardConfiguration clipboardConfiguration);

    public static final native void ClipboardConfiguration_exportImage_set(long j, ClipboardConfiguration clipboardConfiguration, boolean z);

    public static final native boolean ClipboardConfiguration_saveInsteadOfSaveToTemp_get(long j, ClipboardConfiguration clipboardConfiguration);

    public static final native void ClipboardConfiguration_saveInsteadOfSaveToTemp_set(long j, ClipboardConfiguration clipboardConfiguration, boolean z);

    public static final native byte[] ClipboardData_CLIPBOARD_BASE_DIR_get();

    public static final native byte[] ClipboardData_CLIPBOARD_BASE_NAME_get();

    public static final native byte[] ClipboardData_CLIPBOARD_HTML_DATA_DIR_KEY_get();

    public static final native byte[] ClipboardData_getClipboardFileName(int i);

    public static final native boolean CursorPlatformBehavior_isCursorSwapAllowed_get(long j, CursorPlatformBehavior cursorPlatformBehavior);

    public static final native void CursorPlatformBehavior_isCursorSwapAllowed_set(long j, CursorPlatformBehavior cursorPlatformBehavior, boolean z);

    public static final native boolean CursorPlatformBehavior_isFullContext_get(long j, CursorPlatformBehavior cursorPlatformBehavior);

    public static final native void CursorPlatformBehavior_isFullContext_set(long j, CursorPlatformBehavior cursorPlatformBehavior, boolean z);

    public static final native int CursorPlatformBehavior_setCursorBehavior_get(long j, CursorPlatformBehavior cursorPlatformBehavior);

    public static final native void CursorPlatformBehavior_setCursorBehavior_set(long j, CursorPlatformBehavior cursorPlatformBehavior, int i);

    public static final native void Cursor_addToIntervalValue(long j, Cursor cursor, int i);

    public static final native byte[] Cursor_boxId(long j, Cursor cursor);

    public static final native long Cursor_childPageCursor(long j, Cursor cursor);

    public static final native long Cursor_childPageCursorIndex(long j, Cursor cursor);

    public static final native byte[] Cursor_childPageCursorPageId(long j, Cursor cursor);

    public static final native int Cursor_column(long j, Cursor cursor);

    public static final native int Cursor_intervalValue(long j, Cursor cursor);

    public static final native void Cursor_invalidate(long j, Cursor cursor);

    public static final native void Cursor_invalidatePosition(long j, Cursor cursor);

    public static final native int Cursor_line(long j, Cursor cursor);

    public static final native long Cursor_position(long j, Cursor cursor);

    public static final native void Cursor_setBox(long j, Cursor cursor, byte[] bArr, int i);

    public static final native void Cursor_setChildPageCursor__SWIG_0(long j, Cursor cursor, long j2, ChildPageCursor childPageCursor);

    public static final native void Cursor_setChildPageCursor__SWIG_1(long j, Cursor cursor, byte[] bArr, long j2);

    public static final native void Cursor_setGridPosition(long j, Cursor cursor, int i, int i2);

    public static final native void Cursor_setIntervalValue(long j, Cursor cursor, int i);

    public static final native void Cursor_setPosition__SWIG_0(long j, Cursor cursor, long j2, Point point);

    public static final native void Cursor_setPosition__SWIG_1(long j, Cursor cursor, float f, float f2);

    public static final native void Cursor_setSize(long j, Cursor cursor, float f);

    public static final native float Cursor_size(long j, Cursor cursor);

    public static final native int Cursor_state(long j, Cursor cursor);

    public static final native float HANDLE_PEN_ATTRACTION_get();

    public static final native float HANDLE_TOUCH_ATTRACTION_get();

    public static final native long SWIGClipboard_getKeys(long j, SWIGClipboard sWIGClipboard);

    public static final native long SWIGClipboard_getMimeTypes(long j, SWIGClipboard sWIGClipboard);

    public static final native byte[] SWIGClipboard_get__SWIG_0(long j, SWIGClipboard sWIGClipboard, byte[] bArr);

    public static final native byte[] SWIGClipboard_get__SWIG_1(long j, SWIGClipboard sWIGClipboard, int i);

    public static final native boolean SWIGClipboard_hasKey__SWIG_0(long j, SWIGClipboard sWIGClipboard, byte[] bArr);

    public static final native boolean SWIGClipboard_hasKey__SWIG_1(long j, SWIGClipboard sWIGClipboard, int i);

    public static final native void SWIGClipboard_put__SWIG_0(long j, SWIGClipboard sWIGClipboard, int i, byte[] bArr);

    public static final native void SWIGClipboard_put__SWIG_1(long j, SWIGClipboard sWIGClipboard, byte[] bArr, byte[] bArr2);

    public static final native long StyleTypeDecorationLabels_get();

    public static final native byte[] StyleUtils_BOLD_STYLE_NAME_get();

    public static final native byte[] StyleUtils_DOUBLE_UNDERLINE_STYLE_NAME_get();

    public static final native byte[] StyleUtils_EMPHASIS_1_STYLE_NAME_get();

    public static final native byte[] StyleUtils_EMPHASIS_2_STYLE_NAME_get();

    public static final native byte[] StyleUtils_HIGHLIGHT_STYLE_NAME_get();

    public static final native byte[] StyleUtils_STRIKETHROUGH_STYLE_NAME_get();

    public static final native long StyleUtils_STYLE_TYPE_STYLE_CLASSES_get();

    public static final native byte[] StyleUtils_TITLE_H1_STYLE_NAME_get();

    public static final native byte[] StyleUtils_TITLE_H2_STYLE_NAME_get();

    public static final native byte[] StyleUtils_TITLE_H3_STYLE_NAME_get();

    public static final native byte[] StyleUtils_UNDERLINE_STYLE_NAME_get();

    public static final native byte[] UserDictionaryConfiguration_lexiconPath(long j, UserDictionaryConfiguration userDictionaryConfiguration);

    public static final native byte[] UserDictionaryConfiguration_resourceFileName_get(long j, UserDictionaryConfiguration userDictionaryConfiguration);

    public static final native void UserDictionaryConfiguration_resourceFileName_set(long j, UserDictionaryConfiguration userDictionaryConfiguration, byte[] bArr);

    public static final native byte[] UserDictionaryConfiguration_rootDir_get(long j, UserDictionaryConfiguration userDictionaryConfiguration);

    public static final native void UserDictionaryConfiguration_rootDir_set(long j, UserDictionaryConfiguration userDictionaryConfiguration, byte[] bArr);

    public static final native void UserDictionary_addLabel(long j, UserDictionary userDictionary, byte[] bArr);

    public static final native void UserDictionary_clear(long j, UserDictionary userDictionary);

    public static final native byte[] UserDictionary_getFilepath(long j, UserDictionary userDictionary);

    public static final native long UserDictionary_getLabels(long j, UserDictionary userDictionary);

    public static final native long UserDictionary_newRef(long j, UserDictionary userDictionary);

    public static final native void UserDictionary_removeLabel(long j, UserDictionary userDictionary, byte[] bArr);

    public static final native long UserDictionary_stealLexicon(long j, UserDictionary userDictionary);

    public static final native void UserDictionary_store(long j, UserDictionary userDictionary);

    public static final native void delete_ChildPageCursor(long j);

    public static final native void delete_ClipboardConfiguration(long j);

    public static final native void delete_ClipboardData(long j);

    public static final native void delete_Cursor(long j);

    public static final native void delete_CursorPlatformBehavior(long j);

    public static final native void delete_KeyboardListenerTransaction(long j);

    public static final native void delete_SWIGClipboard(long j);

    public static final native void delete_StyleUtils(long j);

    public static final native void delete_UserDictionary(long j);

    public static final native void delete_UserDictionaryConfiguration(long j);

    public static final native long new_ChildPageCursor__SWIG_0();

    public static final native long new_ChildPageCursor__SWIG_1(byte[] bArr, long j);

    public static final native long new_ClipboardConfiguration();

    public static final native long new_ClipboardData();

    public static final native long new_Cursor();

    public static final native long new_CursorPlatformBehavior__SWIG_0();

    public static final native long new_CursorPlatformBehavior__SWIG_1(boolean z, int i, boolean z2);

    public static final native long new_KeyboardListenerTransaction__SWIG_0(IKeyboardListener iKeyboardListener);

    public static final native long new_KeyboardListenerTransaction__SWIG_1(long j, KeyboardListenerTransaction keyboardListenerTransaction);

    public static final native long new_SWIGClipboard__SWIG_0(long j);

    public static final native long new_SWIGClipboard__SWIG_1(long j);

    public static final native long new_SWIGClipboard__SWIG_2();

    public static final native long new_StyleUtils();

    public static final native long new_UserDictionary(long j, UserDictionaryConfiguration userDictionaryConfiguration);

    public static final native long new_UserDictionaryConfiguration(byte[] bArr, byte[] bArr2);
}

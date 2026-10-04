package com.myscript.snt.core;

import com.myscript.atk.core.Box;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.ICancelableTaskProgressCallback;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.atk.core.IMessageListener;
import com.myscript.atk.core.ITypesetListener;
import com.myscript.atk.core.IURIListener;
import com.myscript.atk.core.Json;
import com.myscript.atk.core.LayoutGroup;
import com.myscript.atk.core.MotionPredictionParams;
import com.myscript.atk.core.Page;
import com.myscript.atk.core.Point;
import com.myscript.atk.core.PointerInfo;
import com.myscript.atk.core.SWIGVectorCustomResource;
import com.myscript.atk.core.SWIGVectorExtent;
import com.myscript.atk.core.SWIGVectorMimeType;
import com.myscript.atk.core.SWIGVectorPointerInfo;
import com.myscript.atk.core.SWIGVectorString;
import com.myscript.atk.core.SWIGVectorTagId;
import com.myscript.atk.core.Selection;
import com.myscript.atk.core.Transform;
import com.myscript.atk.core.ValuedAngle;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.p021ui.IActionMenuListener;
import com.myscript.atk.p021ui.ISmartGuideComponentListener;
import com.myscript.atk.p021ui.SmartGuideComponent;
import com.myscript.atk.text.ClipboardConfiguration;
import com.myscript.atk.text.CursorPlatformBehavior;
import com.myscript.atk.text.IKeyboardListener;
import com.myscript.atk.text.INativeClipboard;
import com.myscript.atk.text.UserDictionary;
import com.myscript.snt.core.LayoutGrid;
import com.myscript.snt.core.NeboSanitizer;
import com.myscript.snt.core.SearchController;

/* JADX INFO: loaded from: classes7.dex */
class NeboEngineJNI {
    public static final native String BALLOT_BOX_CHECK_get();

    public static final native String BALLOT_BOX_X_get();

    public static final native String BALLOT_BOX_get();

    public static final native long COLOR_NONE_get();

    public static final native long ChildPageContainer_getChildPageExtent(long j, ChildPageContainer childPageContainer, byte[] bArr);

    public static final native long ChildPageContainer_getChildPageIds(long j, ChildPageContainer childPageContainer);

    public static final native long ChildPageContainer_getChildPageRowId(long j, ChildPageContainer childPageContainer, byte[] bArr);

    public static final native byte[] ChildPageContainer_getChildPageThumbnailTag(long j, ChildPageContainer childPageContainer, byte[] bArr);

    public static final native long ChildPageContainer_getContainerRowId(long j, ChildPageContainer childPageContainer);

    public static final native long ChildPageContainer_getLayout(long j, ChildPageContainer childPageContainer, byte[] bArr);

    public static final native byte[] ChildPageContainer_getWorkingDirPath(long j, ChildPageContainer childPageContainer);

    public static final native void ChildPageThumbnailGenerator_addListener(long j, ChildPageThumbnailGenerator childPageThumbnailGenerator, IChildPageThumbnailListener iChildPageThumbnailListener);

    public static final native void ChildPageThumbnailGenerator_cleanOldThumbnails(long j, ChildPageThumbnailGenerator childPageThumbnailGenerator);

    public static final native long ChildPageThumbnailGenerator_create__SWIG_0(long j, IThumbnailerImageRequester iThumbnailerImageRequester, IColorInversionPolicy iColorInversionPolicy);

    public static final native long ChildPageThumbnailGenerator_create__SWIG_1(long j, IThumbnailerImageRequester iThumbnailerImageRequester);

    public static final native boolean ChildPageThumbnailGenerator_generateThumbnail(long j, ChildPageThumbnailGenerator childPageThumbnailGenerator, byte[] bArr, boolean z);

    public static final native byte[] ChildPageThumbnailGenerator_getThumbnailPath(long j, ChildPageThumbnailGenerator childPageThumbnailGenerator, byte[] bArr);

    public static final native long ChildPageThumbnailGenerator_newRef(long j, ChildPageThumbnailGenerator childPageThumbnailGenerator);

    public static final native void ChildPageThumbnailGenerator_removeListener(long j, ChildPageThumbnailGenerator childPageThumbnailGenerator, IChildPageThumbnailListener iChildPageThumbnailListener);

    public static final native void ChildPageThumbnailGenerator_setColorInversionPolicy(long j, ChildPageThumbnailGenerator childPageThumbnailGenerator, IColorInversionPolicy iColorInversionPolicy);

    public static final native void ChildPageThumbnailGenerator_setThumbnailSize(long j, ChildPageThumbnailGenerator childPageThumbnailGenerator, long j2);

    public static final native void ChildPageThumbnailGenerator_stop(long j, ChildPageThumbnailGenerator childPageThumbnailGenerator);

    public static final native long CollectionKey_createKey(byte[] bArr);

    public static final native long CollectionKey_createKeyFromAbsolutePath(byte[] bArr, byte[] bArr2);

    public static final native long CollectionKey_createKeyFromUuid(byte[] bArr);

    public static final native long CollectionKey_deserialize(byte[] bArr);

    public static final native int CollectionKey_hashCode(long j, CollectionKey collectionKey);

    public static final native boolean CollectionKey_isValid(long j, CollectionKey collectionKey);

    public static final native boolean CollectionKey_nativeEquals(long j, CollectionKey collectionKey, long j2, CollectionKey collectionKey2);

    public static final native long CollectionKey_pathSize(long j, CollectionKey collectionKey);

    public static final native byte[] CollectionKey_relativePath(long j, CollectionKey collectionKey);

    public static final native byte[] CollectionKey_serialize(long j, CollectionKey collectionKey);

    public static final native byte[] CollectionKey_toString(long j, CollectionKey collectionKey);

    public static final native byte[] CollectionKey_uuid(long j, CollectionKey collectionKey);

    public static final native byte[] CompositeBox_ATTR_PADDING_get();

    public static final native byte[] CompositeBox_ATTR_SUBTYPE_get();

    public static final native long CompositeBox_SWIGSmartPtrUpcast(long j);

    public static final native byte[] CompositeBox_TYPE_get();

    public static final native long CompositeBox_activeArea(long j, CompositeBox compositeBox);

    public static final native long CompositeBox_activeBackend(long j, CompositeBox compositeBox);

    public static final native long CompositeBox_backgroundObject(long j, CompositeBox compositeBox);

    public static final native void CompositeBox_createBorderObject(long j, CompositeBox compositeBox);

    public static final native boolean CompositeBox_empty(long j, CompositeBox compositeBox);

    public static final native long CompositeBox_extent(long j, CompositeBox compositeBox);

    public static final native boolean CompositeBox_fitTo(long j, CompositeBox compositeBox, long j2, Extent extent, long j3, LayoutGrid layoutGrid, long j4);

    public static final native byte[] CompositeBox_getActiveIDfromFieldName(byte[] bArr);

    public static final native long CompositeBox_getBorderExtent(long j, CompositeBox compositeBox);

    public static final native long CompositeBox_getBorderSelection(long j, CompositeBox compositeBox);

    public static final native byte[] CompositeBox_getType(long j, CompositeBox compositeBox);

    public static final native boolean CompositeBox_hasValidContent(long j, CompositeBox compositeBox);

    public static final native long CompositeBox_importBackgroundObject__SWIG_0(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid, byte[] bArr, byte[] bArr2, byte[] bArr3, int i);

    public static final native long CompositeBox_importBackgroundObject__SWIG_1(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native byte[] CompositeBox_importObjectAt__SWIG_0(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid, byte[] bArr, byte[] bArr2, byte[] bArr3, long j3, Point point, float f, long j4, Extent extent, boolean z, boolean z2);

    public static final native byte[] CompositeBox_importObjectAt__SWIG_1(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid, byte[] bArr, byte[] bArr2, byte[] bArr3, long j3, Point point, float f, long j4, Extent extent, boolean z);

    public static final native byte[] CompositeBox_importObjectAt__SWIG_2(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid, byte[] bArr, byte[] bArr2, byte[] bArr3, long j3, Point point, float f, long j4, Extent extent);

    public static final native byte[] CompositeBox_importObjectAt__SWIG_3(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid, byte[] bArr, byte[] bArr2, byte[] bArr3, long j3, Point point, float f);

    public static final native byte[] CompositeBox_importObjectAt__SWIG_4(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid, byte[] bArr, byte[] bArr2, byte[] bArr3, long j3, Point point);

    public static final native byte[] CompositeBox_importObjectAt__SWIG_5(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native byte[] CompositeBox_importObjectToExtent__SWIG_0(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid, byte[] bArr, byte[] bArr2, byte[] bArr3, long j3, Extent extent, float f, boolean z, boolean z2);

    public static final native byte[] CompositeBox_importObjectToExtent__SWIG_1(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid, byte[] bArr, byte[] bArr2, byte[] bArr3, long j3, Extent extent, float f, boolean z);

    public static final native byte[] CompositeBox_importObjectToExtent__SWIG_2(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid, byte[] bArr, byte[] bArr2, byte[] bArr3, long j3, Extent extent, float f);

    public static final native byte[] CompositeBox_importObjectToExtent__SWIG_3(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid, byte[] bArr, byte[] bArr2, byte[] bArr3, long j3, Extent extent);

    public static final native int CompositeBox_minNbLines(long j, CompositeBox compositeBox, float f);

    public static final native void CompositeBox_move(long j, CompositeBox compositeBox, float f, float f2);

    public static final native boolean CompositeBox_needsRefit(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid);

    public static final native boolean CompositeBox_needsTypeset(long j, CompositeBox compositeBox);

    public static final native float CompositeBox_padding(long j, CompositeBox compositeBox);

    public static final native void CompositeBox_remove(long j, CompositeBox compositeBox);

    public static final native boolean CompositeBox_removeBorderObject(long j, long j2, LayoutGroup layoutGroup);

    public static final native byte[] CompositeBox_replaceSelectedObject(long j, CompositeBox compositeBox, long j2, LayoutGrid layoutGrid, byte[] bArr, byte[] bArr2);

    public static final native long CompositeBox_selection__SWIG_0(long j, CompositeBox compositeBox);

    public static final native long CompositeBox_selection__SWIG_1(long j, CompositeBox compositeBox, long j2);

    public static final native void CompositeBox_setBackend(long j, CompositeBox compositeBox, long j2);

    public static final native byte[] CompositeBox_subtype(long j, CompositeBox compositeBox);

    public static final native void CompositeBox_transform(long j, CompositeBox compositeBox, long j2, Transform transform, float f, float f2, float f3);

    public static final native void CompositeBox_typeset(long j, CompositeBox compositeBox, long j2);

    public static final native long CompositeBox_typesetSettings(long j, CompositeBox compositeBox, long j2);

    public static final native float DEFAULT_PRESSURE_SENSITIVITY_get();

    public static final native float DEFAULT_THICKNESS_RATIO_get();

    public static final native String DIAGRAM_PROPERTY_PAGE_SIZE_DEFAULT_get();

    public static final native String DIAGRAM_PROPERTY_PAGE_SIZE_FIT_SCREEN_DEFAULT_get();

    public static final native String DIAGRAM_PROPERTY_PAGE_SIZE_INSET_DEFAULT_get();

    /* JADX INFO: renamed from: DefaultDocumentControllerFactory_createDocumentController__SWIG_0 */
    public static final native long m1077xe24bb793(byte[] bArr, byte[] bArr2, byte[] bArr3);

    /* JADX INFO: renamed from: DefaultDocumentControllerFactory_createDocumentController__SWIG_1 */
    public static final native long m1078xe24bb794(byte[] bArr, byte[] bArr2);

    public static final native long DefaultReflowOptions_get();

    public static final native boolean DisplayContext_hasAnimations_get(long j, DisplayContext displayContext);

    public static final native void DisplayContext_hasAnimations_set(long j, DisplayContext displayContext, boolean z);

    public static final native boolean DisplayContext_hasDisplay_get(long j, DisplayContext displayContext);

    public static final native void DisplayContext_hasDisplay_set(long j, DisplayContext displayContext, boolean z);

    public static final native boolean DisplayContext_hasPlatformTiles_get(long j, DisplayContext displayContext);

    public static final native void DisplayContext_hasPlatformTiles_set(long j, DisplayContext displayContext, boolean z);

    public static final native boolean DisplayContext_isVerticalOnly_get(long j, DisplayContext displayContext);

    public static final native void DisplayContext_isVerticalOnly_set(long j, DisplayContext displayContext, boolean z);

    public static final native short DisplayContext_maxThreads_get(long j, DisplayContext displayContext);

    public static final native void DisplayContext_maxThreads_set(long j, DisplayContext displayContext, short s);

    public static final native boolean DisplayContext_needGridBackground_get(long j, DisplayContext displayContext);

    public static final native void DisplayContext_needGridBackground_set(long j, DisplayContext displayContext, boolean z);

    public static final native boolean DisplayContext_usesTiles_get(long j, DisplayContext displayContext);

    public static final native void DisplayContext_usesTiles_set(long j, DisplayContext displayContext, boolean z);

    public static final native byte[] DivisionBox_ATTR_VERTICAL_get();

    public static final native boolean DivisionBox_HORIZONTAL_get();

    public static final native long DivisionBox_SWIGSmartPtrUpcast(long j);

    public static final native byte[] DivisionBox_TYPE_get();

    public static final native boolean DivisionBox_VERTICAL_get();

    public static final native long DivisionBox_childAt(long j, DivisionBox divisionBox, int i);

    public static final native int DivisionBox_childCount(long j, DivisionBox divisionBox);

    public static final native boolean DivisionBox_empty(long j, DivisionBox divisionBox);

    public static final native long DivisionBox_extent(long j, DivisionBox divisionBox);

    public static final native boolean DivisionBox_fitTo(long j, DivisionBox divisionBox, long j2, Extent extent, long j3, LayoutGrid layoutGrid, long j4);

    public static final native byte[] DivisionBox_getType(long j, DivisionBox divisionBox);

    public static final native boolean DivisionBox_hasValidContent(long j, DivisionBox divisionBox);

    public static final native boolean DivisionBox_isHorizontal(long j, DivisionBox divisionBox);

    public static final native boolean DivisionBox_isVertical(long j, DivisionBox divisionBox);

    public static final native void DivisionBox_move(long j, DivisionBox divisionBox, float f, float f2);

    public static final native void DivisionBox_remove(long j, DivisionBox divisionBox);

    public static final native long DivisionBox_selection(long j, DivisionBox divisionBox);

    public static final native byte[] DivisionBox_toString(long j, DivisionBox divisionBox);

    public static final native void DocumentControllerListener_documentModified(long j, DocumentControllerListener documentControllerListener, long j2, NotebookKey notebookKey);

    public static final native void DocumentControllerListener_documentRemoved(long j, DocumentControllerListener documentControllerListener, long j2, NotebookKey notebookKey, long j3, SWIGVectorString sWIGVectorString);

    public static final native void DocumentControllerListener_pageDeleted(long j, DocumentControllerListener documentControllerListener, long j2, PageKey pageKey, byte[] bArr);

    public static final native void DocumentControllerListener_pageModified(long j, DocumentControllerListener documentControllerListener, long j2, PageKey pageKey, byte[] bArr);

    public static final native void DocumentControllerListener_pageUUIDReseted(long j, DocumentControllerListener documentControllerListener, long j2, PageKey pageKey, byte[] bArr, byte[] bArr2);

    public static final native void DocumentController_addDocumentControllerListener(long j, DocumentController documentController, long j2);

    public static final native void DocumentController_addPageSaveListener(long j, DocumentController documentController, IPageSaveListener iPageSaveListener);

    public static final native void DocumentController_clearThumbnails(long j, DocumentController documentController);

    public static final native void DocumentController_configureMetadataForDuplicatedPage(long j, DocumentController documentController, long j2, PageKey pageKey);

    public static final native long DocumentController_confsDir(long j, DocumentController documentController);

    public static final native boolean DocumentController_createThumbnail__SWIG_0(long j, DocumentController documentController, long j2, PageKey pageKey, long j3, ViewTransform viewTransform, boolean z);

    public static final native boolean DocumentController_createThumbnail__SWIG_1(long j, DocumentController documentController, long j2, PageKey pageKey, long j3, ViewTransform viewTransform);

    public static final native long DocumentController_getPageController(long j, DocumentController documentController, long j2, PageKey pageKey, long j3, DisplayContext displayContext, long j4, RecoContext recoContext, long j5, SWIGOptionContext sWIGOptionContext);

    public static final native long DocumentController_getTemporaryPage(long j, DocumentController documentController, long j2, PageKey pageKey, byte[] bArr);

    public static final native long DocumentController_getTemporaryPageController(long j, DocumentController documentController, long j2, Page page, long j3, DisplayContext displayContext, long j4, RecoContext recoContext, long j5);

    public static final native long DocumentController_getThumbnailer(long j, DocumentController documentController);

    public static final native byte[] DocumentController_lastOpenedPageId(long j, DocumentController documentController, long j2, NotebookKey notebookKey);

    public static final native long DocumentController_lastOpenedPageKey(long j, DocumentController documentController, long j2, NotebookKey notebookKey);

    public static final native long DocumentController_neboExporter(long j, DocumentController documentController);

    public static final native void DocumentController_removeAllDocumentControllerListeners(long j, DocumentController documentController);

    public static final native void DocumentController_removeDocumentControllerListener(long j, DocumentController documentController, long j2);

    public static final native void DocumentController_removeLastOpenedPageId(long j, DocumentController documentController, long j2, NotebookKey notebookKey);

    public static final native void DocumentController_removePageSaveListener(long j, DocumentController documentController, IPageSaveListener iPageSaveListener);

    public static final native byte[] DocumentController_resetPageUUID(long j, DocumentController documentController, long j2, PageKey pageKey);

    public static final native byte[] DocumentController_rootNotesPath(long j, DocumentController documentController);

    public static final native void DocumentController_saveAs(long j, DocumentController documentController, long j2, NotebookKey notebookKey, byte[] bArr);

    public static final native void DocumentController_saveToTemp__SWIG_0(long j, DocumentController documentController, long j2, NotebookKey notebookKey);

    public static final native long DocumentController_saveToTemp__SWIG_1(long j, DocumentController documentController, long j2, PageKey pageKey);

    public static final native void DocumentController_save__SWIG_0(long j, DocumentController documentController, long j2, NotebookKey notebookKey, boolean z, boolean z2);

    public static final native void DocumentController_save__SWIG_1(long j, DocumentController documentController, long j2, NotebookKey notebookKey, boolean z);

    public static final native void DocumentController_save__SWIG_2(long j, DocumentController documentController, long j2, NotebookKey notebookKey);

    public static final native long DocumentController_save__SWIG_3(long j, DocumentController documentController, long j2, PageKey pageKey, boolean z);

    public static final native long DocumentController_save__SWIG_4(long j, DocumentController documentController, long j2, PageKey pageKey);

    public static final native void DocumentController_setDocumentConfRequester(long j, DocumentController documentController, IDocumentConfRequester iDocumentConfRequester);

    public static final native void DocumentController_setDocumentCorruptedPageListener(long j, DocumentController documentController, IDocumentCorruptedPageListener iDocumentCorruptedPageListener);

    public static final native void DocumentController_setLastOpenedPageId(long j, DocumentController documentController, long j2, PageKey pageKey);

    public static final native void DocumentController_setPublicAuthorId(long j, DocumentController documentController, byte[] bArr);

    public static final native void DocumentController_setThumbnailConfiguration__SWIG_0(long j, DocumentController documentController, long j2, ThumbnailConfiguration thumbnailConfiguration);

    public static final native void DocumentController_setThumbnailConfiguration__SWIG_1(long j, DocumentController documentController, float f, float f2, byte[] bArr, IColorInversionPolicy iColorInversionPolicy);

    public static final native void DocumentController_setTypesetListener(long j, DocumentController documentController, ITypesetListener iTypesetListener);

    public static final native void DocumentController_setWorkingPath(long j, DocumentController documentController, byte[] bArr);

    public static final native long DocumentController_standalonePageController__SWIG_0(long j, DocumentController documentController, byte[] bArr, int i, long j2, DisplayContext displayContext, long j3, RecoContext recoContext, long j4);

    public static final native long DocumentController_standalonePageController__SWIG_1(long j, DocumentController documentController, byte[] bArr, int i, long j2, DisplayContext displayContext, long j3, RecoContext recoContext, long j4, SWIGOptionContext sWIGOptionContext);

    public static final native void DocumentController_tagCorruptionInfoPage(long j, DocumentController documentController, long j2, PageKey pageKey, long j3, NeboSanitizer.SanitizerResult sanitizerResult);

    public static final native byte[] DocumentController_thumbnailParentPath(long j, DocumentController documentController, long j2, PageKey pageKey);

    public static final native byte[] DocumentController_thumbnailPath(long j, DocumentController documentController, long j2, PageKey pageKey, long j3, long j4);

    public static final native void DocumentController_untagCorruptedPage(long j, DocumentController documentController, long j2, PageKey pageKey);

    public static final native void EventListenerBroadcaster_flush(long j, EventListenerBroadcaster eventListenerBroadcaster);

    public static final native void EventListenerBroadcaster_gestureCanceled(long j, EventListenerBroadcaster eventListenerBroadcaster, byte[] bArr, long j2, long j3, long j4, byte[] bArr2);

    public static final native void EventListenerBroadcaster_gestureTriggered(long j, EventListenerBroadcaster eventListenerBroadcaster, byte[] bArr, long j2, long j3, long j4, long j5, byte[] bArr2);

    public static final native void EventListenerBroadcaster_holdItemAdded(long j, EventListenerBroadcaster eventListenerBroadcaster, byte[] bArr, long j2, SWIGVectorTagId sWIGVectorTagId);

    public static final native void EventListenerBroadcaster_itemAdded(long j, EventListenerBroadcaster eventListenerBroadcaster, byte[] bArr, long j2);

    public static final native void EventListenerBroadcaster_itemChanged(long j, EventListenerBroadcaster eventListenerBroadcaster, byte[] bArr, long j2);

    public static final native void EventListenerBroadcaster_itemRemoved(long j, EventListenerBroadcaster eventListenerBroadcaster, byte[] bArr, long j2);

    public static final native void EventListenerBroadcaster_onHold(long j, EventListenerBroadcaster eventListenerBroadcaster, byte[] bArr, long j2, long j3, int i, long j4, Json json, boolean z);

    public static final native void EventListenerBroadcaster_selectionChanged(long j, EventListenerBroadcaster eventListenerBroadcaster);

    public static final native void ExportController_combineAsOneDocument(long j, ExportController exportController, boolean z);

    public static final native long ExportController_exportAllToText(long j, ExportController exportController, ICancelableTaskProgressCallback iCancelableTaskProgressCallback);

    public static final native long ExportController_exportOptions(long j, ExportController exportController);

    public static final native byte[] ExportController_filename(long j, ExportController exportController);

    public static final native void ExportController_flatten(long j, ExportController exportController, boolean z);

    public static final native void ExportController_includeAnnotations(long j, ExportController exportController, boolean z);

    public static final native void ExportController_includeBackgroundColor(long j, ExportController exportController, boolean z);

    public static final native void ExportController_includeBackgroundPattern(long j, ExportController exportController, boolean z);

    public static final native void ExportController_includeEmptyPages(long j, ExportController exportController, boolean z);

    public static final native long ExportController_makeExport(long j, ExportController exportController, byte[] bArr, ICancelableTaskProgressCallback iCancelableTaskProgressCallback);

    public static final native long ExportController_makeExport2(long j, ExportController exportController, byte[] bArr);

    public static final native long ExportController_pagesToExportCount(long j, ExportController exportController);

    public static final native void ExportController_setDefaultLang(long j, ExportController exportController, byte[] bArr);

    public static final native void ExportController_setExportDelegate(long j, ExportController exportController, IExportControllerDelegate iExportControllerDelegate);

    public static final native void ExportController_setExportMimeType(long j, ExportController exportController, int i);

    public static final native void ExportController_setExtraNeboMetadata(long j, ExportController exportController, long j2, Json json);

    public static final native void ExportController_setName(long j, ExportController exportController, byte[] bArr);

    public static final native void ExportController_setNeboExporter(long j, ExportController exportController, long j2);

    public static final native void ExportController_setPdfPageIndexesFilter(long j, ExportController exportController, long j2, SWIGVectorColors sWIGVectorColors);

    public static final native void ExportController_setWatermarkData(long j, ExportController exportController, byte[] bArr, byte[] bArr2);

    public static final native long ExportOptions_availableMimeTypes_get(long j, ExportOptions exportOptions);

    public static final native void ExportOptions_availableMimeTypes_set(long j, ExportOptions exportOptions, long j2, SWIGVectorMimeType sWIGVectorMimeType);

    public static final native int ExportOptions_combineAsOneDocument_get(long j, ExportOptions exportOptions);

    public static final native void ExportOptions_combineAsOneDocument_set(long j, ExportOptions exportOptions, int i);

    public static final native int ExportOptions_currentMimeType_get(long j, ExportOptions exportOptions);

    public static final native void ExportOptions_currentMimeType_set(long j, ExportOptions exportOptions, int i);

    public static final native int ExportOptions_flatten_get(long j, ExportOptions exportOptions);

    public static final native void ExportOptions_flatten_set(long j, ExportOptions exportOptions, int i);

    public static final native int ExportOptions_includeAnnotations_get(long j, ExportOptions exportOptions);

    public static final native void ExportOptions_includeAnnotations_set(long j, ExportOptions exportOptions, int i);

    public static final native int ExportOptions_includeBackgroundColor_get(long j, ExportOptions exportOptions);

    public static final native void ExportOptions_includeBackgroundColor_set(long j, ExportOptions exportOptions, int i);

    public static final native int ExportOptions_includeBackgroundPattern_get(long j, ExportOptions exportOptions);

    public static final native void ExportOptions_includeBackgroundPattern_set(long j, ExportOptions exportOptions, int i);

    public static final native int ExportOptions_nameOption_get(long j, ExportOptions exportOptions);

    public static final native void ExportOptions_nameOption_set(long j, ExportOptions exportOptions, int i);

    public static final native byte[] ExportOptions_name_get(long j, ExportOptions exportOptions);

    public static final native void ExportOptions_name_set(long j, ExportOptions exportOptions, byte[] bArr);

    public static final native long ExportOptions_pdfPageIndexesFilter_get(long j, ExportOptions exportOptions);

    public static final native void ExportOptions_pdfPageIndexesFilter_set(long j, ExportOptions exportOptions, long j2);

    public static final native long ExportPageLoader_load(long j, ExportPageLoader exportPageLoader, long j2, ExportPageModel exportPageModel);

    public static final native int ExportPageModel_backgroundColor_get(long j, ExportPageModel exportPageModel);

    public static final native void ExportPageModel_backgroundColor_set(long j, ExportPageModel exportPageModel, int i);

    public static final native int ExportPageModel_backgroundPattern_get(long j, ExportPageModel exportPageModel);

    public static final native void ExportPageModel_backgroundPattern_set(long j, ExportPageModel exportPageModel, int i);

    public static final native byte[] ExportPageModel_contentType_get(long j, ExportPageModel exportPageModel);

    public static final native void ExportPageModel_contentType_set(long j, ExportPageModel exportPageModel, byte[] bArr);

    public static final native boolean ExportPageModel_corrupted_get(long j, ExportPageModel exportPageModel);

    public static final native void ExportPageModel_corrupted_set(long j, ExportPageModel exportPageModel, boolean z);

    public static final native float ExportPageModel_height_get(long j, ExportPageModel exportPageModel);

    public static final native void ExportPageModel_height_set(long j, ExportPageModel exportPageModel, float f);

    public static final native byte[] ExportPageModel_serializedPageKey_get(long j, ExportPageModel exportPageModel);

    public static final native void ExportPageModel_serializedPageKey_set(long j, ExportPageModel exportPageModel, byte[] bArr);

    public static final native byte[] ExportPageModel_title_get(long j, ExportPageModel exportPageModel);

    public static final native void ExportPageModel_title_set(long j, ExportPageModel exportPageModel, byte[] bArr);

    public static final native float ExportPageModel_width_get(long j, ExportPageModel exportPageModel);

    public static final native void ExportPageModel_width_set(long j, ExportPageModel exportPageModel, float f);

    public static final native boolean FileTypeInspector_searchable(long j, FileTypeInspector fileTypeInspector, byte[] bArr);

    public static final native byte[] FileUtils_absolutePath(byte[] bArr);

    public static final native byte[] FileUtils_addDotAtFileExtension(byte[] bArr);

    public static final native byte[] FileUtils_addSlashAtBeginningOfPath(byte[] bArr);

    public static final native byte[] FileUtils_addSlashAtEndOfPath__SWIG_0(byte[] bArr, byte[] bArr2);

    public static final native byte[] FileUtils_addSlashAtEndOfPath__SWIG_1(byte[] bArr);

    public static final native byte[] FileUtils_appendPaths(byte[] bArr, byte[] bArr2);

    public static final native byte[] FileUtils_convertPathToUnixPath(byte[] bArr);

    public static final native boolean FileUtils_copyFile(byte[] bArr, byte[] bArr2);

    public static final native boolean FileUtils_createFolders(byte[] bArr);

    public static final native boolean FileUtils_endsWith(byte[] bArr, byte[] bArr2);

    public static final native byte[] FileUtils_extensionFromPath__SWIG_0(byte[] bArr, boolean z);

    public static final native byte[] FileUtils_extensionFromPath__SWIG_1(byte[] bArr);

    public static final native byte[] FileUtils_fileDisplayNameFromPath(byte[] bArr);

    public static final native byte[] FileUtils_fileNameFromFullPath(byte[] bArr);

    public static final native byte[] FileUtils_fileNameWithoutExtension(byte[] bArr);

    public static final native long FileUtils_fileSize(byte[] bArr);

    public static final native long FileUtils_findFiles(byte[] bArr, byte[] bArr2);

    public static final native boolean FileUtils_hasExtension(byte[] bArr);

    public static final native boolean FileUtils_isAbsolutePath(byte[] bArr);

    public static final native boolean FileUtils_isFileExists(byte[] bArr);

    public static final native byte[] FileUtils_parentFolder(byte[] bArr);

    public static final native byte[] FileUtils_readFile(byte[] bArr);

    public static final native byte[] FileUtils_relativePath(byte[] bArr, byte[] bArr2);

    public static final native byte[] FileUtils_relativePathFromAbsolute(byte[] bArr, byte[] bArr2);

    public static final native boolean FileUtils_removeFile(byte[] bArr);

    public static final native boolean FileUtils_removeFiles(byte[] bArr, byte[] bArr2);

    public static final native boolean FileUtils_removeFolder(byte[] bArr);

    public static final native byte[] FileUtils_removeSlashAtBeginningOfPath(byte[] bArr);

    public static final native byte[] FileUtils_removeSlashAtEndOfPath(byte[] bArr);

    public static final native byte[] FileUtils_removeSlashesAtBeginingAndEnd(byte[] bArr);

    public static final native boolean FileUtils_renameFile(byte[] bArr, byte[] bArr2);

    public static final native byte[] FileUtils_replaceWinSeparatorFromPath(byte[] bArr);

    public static final native byte[] FileUtils_separator__SWIG_0();

    public static final native byte[] FileUtils_separator__SWIG_1(byte[] bArr);

    public static final native byte[] FileUtils_sha256(byte[] bArr);

    public static final native byte[] FileUtils_temporaryPath__SWIG_0(long j);

    public static final native byte[] FileUtils_temporaryPath__SWIG_1(byte[] bArr);

    public static final native byte[] FileUtils_temporaryPath__SWIG_2();

    public static final native byte[] FileUtils_unix_separator();

    public static final native byte[] FileUtils_win_separator();

    public static final native boolean FileUtils_writeFile(byte[] bArr, byte[] bArr2);

    public static final native float FullPageColumnGridFactoryStrategy_FullPageColumnGap_get();

    public static final native long FullPageColumnGridFactoryStrategy_SWIGSmartPtrUpcast(long j);

    public static final native float FullPageColumnGridFactoryStrategy_columnGutter(long j, FullPageColumnGridFactoryStrategy fullPageColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float FullPageColumnGridFactoryStrategy_getLeftMargin(long j, FullPageColumnGridFactoryStrategy fullPageColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float FullPageColumnGridFactoryStrategy_getRightMargin(long j, FullPageColumnGridFactoryStrategy fullPageColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float FullPageColumnGridFactoryStrategy_left(long j, FullPageColumnGridFactoryStrategy fullPageColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float FullPageColumnGridFactoryStrategy_width(long j, FullPageColumnGridFactoryStrategy fullPageColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native byte[] GridBox_ATTR_CONTENT_FIELD_ID_get();

    public static final native byte[] GridBox_ATTR_FULL_WIDTH_get();

    public static final native byte[] GridBox_ATTR_ID_get();

    public static final native byte[] GridBox_ATTR_SHOULD_REFLOW_get();

    public static final native byte[] GridBox_ATTR_TYPE_get();

    public static final native byte[] GridBox_ATTR_WIDTH_RATIO_get();

    public static final native byte[] GridBox_ATTR_X_RELATIVE_RATIO_get();

    public static final native byte[] GridBox_ATTR_Y_OFFSET_get();

    public static final native long GridBox_SWIGSmartPtrUpcast(long j);

    public static final native long GridBox_activeBackend(long j, GridBox gridBox);

    public static final native byte[] GridBox_anchorId(long j, GridBox gridBox);

    public static final native long GridBox_boxFactory(long j, GridBox gridBox);

    public static final native long GridBox_content(long j, GridBox gridBox);

    public static final native long GridBox_extent(long j, GridBox gridBox);

    public static final native long GridBox_extentWithStrokes__SWIG_0(long j, GridBox gridBox, long j2, LayoutGrid layoutGrid);

    public static final native long GridBox_extentWithStrokes__SWIG_1(long j, GridBox gridBox, long j2, LayoutGrid layoutGrid, long j3, Selection selection);

    public static final native boolean GridBox_find(long j, long j2, GridBox gridBox);

    public static final native boolean GridBox_fitTo(long j, GridBox gridBox, long j2, Extent extent, long j3, LayoutGrid layoutGrid, long j4);

    public static final native byte[] GridBox_getType(long j, GridBox gridBox);

    public static final native boolean GridBox_hasValidContent(long j, GridBox gridBox);

    public static final native byte[] GridBox_id(long j, GridBox gridBox);

    public static final native boolean GridBox_isDetached(long j, GridBox gridBox);

    public static final native boolean GridBox_isFullWidth(long j, GridBox gridBox);

    public static final native boolean GridBox_isRoot(long j, GridBox gridBox);

    public static final native boolean GridBox_isStack(long j, GridBox gridBox);

    public static final native long GridBox_layout(long j, GridBox gridBox);

    public static final native int GridBox_minNbLines(long j, GridBox gridBox, float f);

    public static final native int GridBox_minWidthColumn(long j, GridBox gridBox, long j2, LayoutGrid layoutGrid);

    public static final native void GridBox_moveTo(long j, GridBox gridBox, long j2, LayoutGrid layoutGrid, float f, float f2);

    public static final native boolean GridBox_needCheckReco(long j, GridBox gridBox);

    public static final native long GridBox_nextBrother(long j, GridBox gridBox);

    public static final native long GridBox_parent(long j, GridBox gridBox);

    public static final native byte[] GridBox_previousAnchorId(long j, GridBox gridBox);

    public static final native long GridBox_previousBrother(long j, GridBox gridBox);

    public static final native long GridBox_previousExtent(long j, GridBox gridBox);

    public static final native long GridBox_previousExtentPreviousBrother(long j, GridBox gridBox);

    public static final native float GridBox_previousParentXmin(long j, GridBox gridBox);

    public static final native int GridBox_previousPositionInParent(long j, GridBox gridBox);

    public static final native void GridBox_resetShouldReflow(long j, GridBox gridBox);

    public static final native void GridBox_setAnchorId(long j, GridBox gridBox, byte[] bArr);

    public static final native void GridBox_setFullWidth(long j, GridBox gridBox, boolean z);

    public static final native void GridBox_setPreviousAnchorId(long j, GridBox gridBox, byte[] bArr);

    public static final native void GridBox_setPreviousExtent(long j, GridBox gridBox, long j2, Extent extent);

    public static final native void GridBox_setPreviousExtentPreviousBrother(long j, GridBox gridBox, long j2, Extent extent);

    public static final native void GridBox_setPreviousParentXmin(long j, GridBox gridBox, float f);

    public static final native void GridBox_setPreviousPositionInParent(long j, GridBox gridBox, int i);

    public static final native void GridBox_setShouldReflow(long j, GridBox gridBox);

    public static final native void GridBox_setWidthRatio(long j, GridBox gridBox, float f);

    public static final native void GridBox_setXRelativeRatio(long j, GridBox gridBox, float f);

    public static final native void GridBox_setYOffset(long j, GridBox gridBox, float f);

    public static final native boolean GridBox_shouldReflow(long j, GridBox gridBox);

    public static final native byte[] GridBox_toString(long j, GridBox gridBox);

    public static final native long GridBox_typesetSettings(long j, GridBox gridBox, long j2);

    public static final native void GridBox_updateExtent(long j, GridBox gridBox, long j2, LayoutGrid layoutGrid);

    public static final native void GridBox_updateSelection(long j, GridBox gridBox);

    public static final native int GridBox_widthColumn(long j, GridBox gridBox, long j2, LayoutGrid layoutGrid);

    public static final native float GridBox_widthRatio(long j, GridBox gridBox);

    public static final native int GridBox_xRelativeColumn(long j, GridBox gridBox, long j2, LayoutGrid layoutGrid);

    public static final native float GridBox_xRelativeRatio(long j, GridBox gridBox);

    public static final native float GridBox_yOffset(long j, GridBox gridBox);

    public static final native float IGridFactoryStrategy_columnGutter(long j, IGridFactoryStrategy iGridFactoryStrategy, float f, float f2, float f3);

    public static final native boolean IGridFactoryStrategy_compact(long j, IGridFactoryStrategy iGridFactoryStrategy, int i, float f, float f2, float f3);

    public static final native int IGridFactoryStrategy_getColumnCount(long j, IGridFactoryStrategy iGridFactoryStrategy, float f, float f2, float f3);

    public static final native float IGridFactoryStrategy_getLeftMargin(long j, IGridFactoryStrategy iGridFactoryStrategy, float f, float f2, float f3);

    public static final native float IGridFactoryStrategy_getRightMargin(long j, IGridFactoryStrategy iGridFactoryStrategy, float f, float f2, float f3);

    public static final native float IGridFactoryStrategy_getTopMargin(long j, IGridFactoryStrategy iGridFactoryStrategy, float f, float f2, float f3);

    public static final native float IGridFactoryStrategy_left(long j, IGridFactoryStrategy iGridFactoryStrategy, float f, float f2, float f3);

    public static final native float IGridFactoryStrategy_width(long j, IGridFactoryStrategy iGridFactoryStrategy, float f, float f2, float f3);

    public static final native byte[] ImageParameter_filePath_get(long j, ImageParameter imageParameter);

    public static final native void ImageParameter_filePath_set(long j, ImageParameter imageParameter, byte[] bArr);

    public static final native byte[] ImageParameter_mimeType_get(long j, ImageParameter imageParameter);

    public static final native void ImageParameter_mimeType_set(long j, ImageParameter imageParameter, byte[] bArr);

    public static final native long LanguageManager_availableLanguages__SWIG_0(long j, LanguageManager languageManager, byte[] bArr);

    public static final native long LanguageManager_availableLanguages__SWIG_1(long j, LanguageManager languageManager, long j2, Json json);

    public static final native long LanguageManager_availableLanguages__SWIG_2(long j, LanguageManager languageManager);

    public static final native boolean LayoutGrid_StyleProperties_compact_get(long j, LayoutGrid.StyleProperties styleProperties);

    public static final native void LayoutGrid_StyleProperties_compact_set(long j, LayoutGrid.StyleProperties styleProperties, boolean z);

    public static final native float LayoutGrid_StyleProperties_fontSize_get(long j, LayoutGrid.StyleProperties styleProperties);

    public static final native void LayoutGrid_StyleProperties_fontSize_set(long j, LayoutGrid.StyleProperties styleProperties, float f);

    public static final native float LayoutGrid_StyleProperties_lineHeight_get(long j, LayoutGrid.StyleProperties styleProperties);

    public static final native void LayoutGrid_StyleProperties_lineHeight_set(long j, LayoutGrid.StyleProperties styleProperties, float f);

    public static final native float LayoutGrid_StyleProperties_rem_get(long j, LayoutGrid.StyleProperties styleProperties);

    public static final native void LayoutGrid_StyleProperties_rem_set(long j, LayoutGrid.StyleProperties styleProperties, float f);

    public static final native float LayoutGrid_column(long j, LayoutGrid layoutGrid, int i);

    public static final native float LayoutGrid_columnAt(long j, LayoutGrid layoutGrid, float f);

    public static final native float LayoutGrid_columnClosestAt(long j, LayoutGrid layoutGrid, float f);

    public static final native int LayoutGrid_columnClosestIndexAt(long j, LayoutGrid layoutGrid, float f);

    public static final native int LayoutGrid_columnCount(long j, LayoutGrid layoutGrid);

    public static final native float LayoutGrid_columnFirst(long j, LayoutGrid layoutGrid);

    public static final native float LayoutGrid_columnGap(long j, LayoutGrid layoutGrid);

    public static final native float LayoutGrid_columnGutter(long j, LayoutGrid layoutGrid);

    public static final native float LayoutGrid_columnGutterLeft(long j, LayoutGrid layoutGrid, int i);

    public static final native float LayoutGrid_columnGutterLeftAt(long j, LayoutGrid layoutGrid, float f);

    public static final native float LayoutGrid_columnGutterRight(long j, LayoutGrid layoutGrid, int i);

    public static final native float LayoutGrid_columnGutterRightAt(long j, LayoutGrid layoutGrid, float f);

    public static final native int LayoutGrid_columnIndexAt(long j, LayoutGrid layoutGrid, float f);

    public static final native boolean LayoutGrid_compact(long j, LayoutGrid layoutGrid);

    public static final native float LayoutGrid_fontSize(long j, LayoutGrid layoutGrid);

    public static final native float LayoutGrid_fullWidth(long j, LayoutGrid layoutGrid);

    public static final native byte[] LayoutGrid_guideLinesBig(long j, LayoutGrid layoutGrid);

    public static final native float LayoutGrid_lastColumn(long j, LayoutGrid layoutGrid);

    public static final native float LayoutGrid_line(long j, LayoutGrid layoutGrid, int i);

    public static final native float LayoutGrid_lineAt(long j, LayoutGrid layoutGrid, float f);

    public static final native float LayoutGrid_lineClosestAt(long j, LayoutGrid layoutGrid, float f);

    public static final native int LayoutGrid_lineClosestIndexAt(long j, LayoutGrid layoutGrid, float f);

    public static final native float LayoutGrid_lineFirst(long j, LayoutGrid layoutGrid);

    public static final native float LayoutGrid_lineGap(long j, LayoutGrid layoutGrid);

    public static final native float LayoutGrid_lineHeight(long j, LayoutGrid layoutGrid);

    public static final native int LayoutGrid_lineIndexAt(long j, LayoutGrid layoutGrid, float f);

    public static final native float LayoutGrid_rem(long j, LayoutGrid layoutGrid);

    public static final native boolean LayoutGrid_set__SWIG_0(long j, LayoutGrid layoutGrid, float f, float f2, int i, float f3, float f4, float f5, float f6, float f7, boolean z, byte[] bArr);

    public static final native boolean LayoutGrid_set__SWIG_1(long j, LayoutGrid layoutGrid, long j2, LayoutGrid layoutGrid2);

    public static final native float LayoutGrid_snapLineAt__SWIG_0(long j, LayoutGrid layoutGrid, float f, float f2);

    public static final native float LayoutGrid_snapLineAt__SWIG_1(long j, LayoutGrid layoutGrid, float f);

    public static final native long LayoutGrid_styleProperties(long j, LayoutGrid layoutGrid);

    public static final native float LayoutGrid_width(long j, LayoutGrid layoutGrid);

    public static final native byte[] ListItemInfo_bulletValue(long j, ListItemInfo listItemInfo);

    public static final native float ListItemInfo_rightLimitOffset(long j, ListItemInfo listItemInfo);

    public static final native float ListItemInfo_rightLimitOffsetForSmallTypeset(long j, ListItemInfo listItemInfo);

    public static final native void ListItemInfo_setBulletValue(long j, ListItemInfo listItemInfo, byte[] bArr);

    public static final native void ListItemInfo_setRightLimitOffset(long j, ListItemInfo listItemInfo, float f);

    public static final native void ListItemInfo_setRightLimitOffsetForSmallTypeset(long j, ListItemInfo listItemInfo, float f);

    public static final native void ListItemInfo_setType(long j, ListItemInfo listItemInfo, int i);

    public static final native void ListItemInfo_setWordCountBeforeOffset(long j, ListItemInfo listItemInfo, int i);

    public static final native int ListItemInfo_type(long j, ListItemInfo listItemInfo);

    public static final native byte[] ListItemInfo_uuid(long j, ListItemInfo listItemInfo);

    public static final native int ListItemInfo_wordCountBeforeOffset(long j, ListItemInfo listItemInfo);

    public static final native byte[] LocaleInfo_country_get(long j, LocaleInfo localeInfo);

    public static final native void LocaleInfo_country_set(long j, LocaleInfo localeInfo, byte[] bArr);

    public static final native byte[] LocaleInfo_language_get(long j, LocaleInfo localeInfo);

    public static final native void LocaleInfo_language_set(long j, LocaleInfo localeInfo, byte[] bArr);

    public static final native byte[] LocaleInfo_name_get(long j, LocaleInfo localeInfo);

    public static final native void LocaleInfo_name_set(long j, LocaleInfo localeInfo, byte[] bArr);

    public static final native void MigrationAssistant_cancel(long j, MigrationAssistant migrationAssistant);

    public static final native boolean MigrationAssistant_findFileSystemCallback(Object obj, Object obj2);

    public static final native long MigrationAssistant_iinkSdkExtraPartTypes_get(long j, MigrationAssistant migrationAssistant);

    public static final native void MigrationAssistant_migrate__SWIG_0(long j, MigrationAssistant migrationAssistant, byte[] bArr, int i);

    public static final native void MigrationAssistant_migrate__SWIG_1(long j, MigrationAssistant migrationAssistant, long j2, Page page, long j3, byte[] bArr);

    public static final native void MigrationAssistant_migrate__SWIG_2(long j, MigrationAssistant migrationAssistant, long j2, Page page, long j3);

    public static final native void MigrationAssistant_migrate__SWIG_3(long j, MigrationAssistant migrationAssistant, long j2, Page page);

    public static final native void MigrationAssistant_setConfDirs(long j, MigrationAssistant migrationAssistant, long j2, SWIGVectorString sWIGVectorString);

    public static final native void MigrationAssistant_setMigrationAssistantListener(long j, MigrationAssistant migrationAssistant, IMigrationAssistantListener iMigrationAssistantListener);

    public static final native long MultiColumnGridFactoryStrategy_SWIGSmartPtrUpcast(long j);

    public static final native float MultiColumnGridFactoryStrategy_columnGutter(long j, MultiColumnGridFactoryStrategy multiColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native boolean MultiColumnGridFactoryStrategy_compact(long j, MultiColumnGridFactoryStrategy multiColumnGridFactoryStrategy, int i, float f, float f2, float f3);

    public static final native int MultiColumnGridFactoryStrategy_getColumnCount(long j, MultiColumnGridFactoryStrategy multiColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float MultiColumnGridFactoryStrategy_getLeftMargin(long j, MultiColumnGridFactoryStrategy multiColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float MultiColumnGridFactoryStrategy_getRightMargin(long j, MultiColumnGridFactoryStrategy multiColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float MultiColumnGridFactoryStrategy_getTopMargin(long j, MultiColumnGridFactoryStrategy multiColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float MultiColumnGridFactoryStrategy_left(long j, MultiColumnGridFactoryStrategy multiColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float MultiColumnGridFactoryStrategy_width(long j, MultiColumnGridFactoryStrategy multiColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native byte[] NeboCustomTheme_getCustomTheme__SWIG_0(int i, int i2, boolean z);

    public static final native byte[] NeboCustomTheme_getCustomTheme__SWIG_1(int i, int i2);

    public static final native boolean NeboExporter_exportPages(long j, NeboExporter neboExporter, long j2, SWIGVectorString sWIGVectorString, boolean z, byte[] bArr, long j3, Json json, byte[] bArr2, boolean z2, boolean z3);

    public static final native long NeboExporter_exportRaw(long j, NeboExporter neboExporter, byte[] bArr, long j2, SWIGVectorString sWIGVectorString);

    public static final native byte[] NeboSanitizer_SanitizerResult_message_get(long j, NeboSanitizer.SanitizerResult sanitizerResult);

    public static final native void NeboSanitizer_SanitizerResult_message_set(long j, NeboSanitizer.SanitizerResult sanitizerResult, byte[] bArr);

    public static final native byte[] NeboSanitizer_SanitizerResult_reason_get(long j, NeboSanitizer.SanitizerResult sanitizerResult);

    public static final native void NeboSanitizer_SanitizerResult_reason_set(long j, NeboSanitizer.SanitizerResult sanitizerResult, byte[] bArr);

    public static final native byte[] NeboSanitizer_SanitizerResult_source_get(long j, NeboSanitizer.SanitizerResult sanitizerResult);

    public static final native void NeboSanitizer_SanitizerResult_source_set(long j, NeboSanitizer.SanitizerResult sanitizerResult, byte[] bArr);

    public static final native int NeboSanitizer_SanitizerResult_status_get(long j, NeboSanitizer.SanitizerResult sanitizerResult);

    public static final native void NeboSanitizer_SanitizerResult_status_set(long j, NeboSanitizer.SanitizerResult sanitizerResult, int i);

    public static final native boolean NeboSanitizer_isPageTreeInvalid(long j, Page page);

    public static final native long NeboSanitizer_sanitizePage__SWIG_0(byte[] bArr, long j, Page page);

    public static final native long NeboSanitizer_sanitizePage__SWIG_1(long j, PageKey pageKey, long j2, Page page);

    public static final native long NoDisplayContext_get();

    public static final native long NoRecoContext_get();

    public static final native long NoStackingtReflowOptions_get();

    public static final native long NotebookKey_createKeyFromAbsolutePath(byte[] bArr, byte[] bArr2);

    public static final native long NotebookKey_createKeyFromPageKey(long j, PageKey pageKey);

    public static final native long NotebookKey_createKeyFromUuid(byte[] bArr);

    public static final native long NotebookKey_deserialize(byte[] bArr);

    public static final native int NotebookKey_hashCode(long j, NotebookKey notebookKey);

    public static final native boolean NotebookKey_isValid(long j, NotebookKey notebookKey);

    public static final native boolean NotebookKey_nativeEquals(long j, NotebookKey notebookKey, long j2, NotebookKey notebookKey2);

    public static final native long NotebookKey_pathSize(long j, NotebookKey notebookKey);

    public static final native byte[] NotebookKey_relativePath(long j, NotebookKey notebookKey);

    public static final native byte[] NotebookKey_serialize(long j, NotebookKey notebookKey);

    public static final native byte[] NotebookKey_toString(long j, NotebookKey notebookKey);

    public static final native byte[] NotebookKey_uuid(long j, NotebookKey notebookKey);

    public static final native String PAGECONTROLLER_ATTR_NEED_COMPUTEGRID_get();

    /* JADX INFO: renamed from: PAGECONTROLLER_FEATUREFLAG_FIT_TO_WIDTH_DEFAULT_RESTORE_SCROLL_POSITION_ENABLE_DEFAULT_get */
    public static final native String m1079x20ec9d8d();

    /* JADX INFO: renamed from: PAGECONTROLLER_FEATUREFLAG_FIT_TO_WIDTH_DEFAULT_RESTORE_SCROLL_POSITION_ENABLE_get */
    public static final native String m1080xf61329ab();

    public static final native String PAGECONTROLLER_PROPERTY_ACTIVEPEN_ENABLE_DEFAULT_get();

    public static final native String PAGECONTROLLER_PROPERTY_ACTIVEPEN_ENABLE_get();

    public static final native String PAGECONTROLLER_PROPERTY_ACTIVEPEN_FORCE_DISABLE_DEFAULT_get();

    public static final native String PAGECONTROLLER_PROPERTY_ACTIVEPEN_FORCE_DISABLE_get();

    public static final native String PAGECONTROLLER_PROPERTY_ANIMATIONS_ENABLE_DEFAULT_get();

    public static final native String PAGECONTROLLER_PROPERTY_ANIMATIONS_ENABLE_get();

    /* JADX INFO: renamed from: PAGECONTROLLER_PROPERTY_CENTER_AT_BOTTOM_DEFAULT_RESTORE_SCROLL_POSITION_ENABLE_DEFAULT_get */
    public static final native String m1081x3f07004b();

    /* JADX INFO: renamed from: PAGECONTROLLER_PROPERTY_CENTER_AT_BOTTOM_DEFAULT_RESTORE_SCROLL_POSITION_ENABLE_get */
    public static final native String m1082x59632a69();

    public static final native String PAGECONTROLLER_PROPERTY_DIAGRAM_TYPEFEEDBACK_ENABLE_DEFAULT_get();

    public static final native String PAGECONTROLLER_PROPERTY_DIAGRAM_TYPEFEEDBACK_ENABLE_get();

    public static final native String PAGECONTROLLER_PROPERTY_FALSE_get();

    /* JADX INFO: renamed from: PAGECONTROLLER_PROPERTY_FREEFORM_PDF_ALIGNMENT_GUIDES_ENABLE_DEFAULT_get */
    public static final native String m1083x5b3a30a2();

    public static final native String PAGECONTROLLER_PROPERTY_FREEFORM_PDF_ALIGNMENT_GUIDES_ENABLE_get();

    /* JADX INFO: renamed from: PAGECONTROLLER_PROPERTY_FREEFORM_SELECTION_CHANGED_LISTENER_DEFAULT_get */
    public static final native String m1084x180a9dc4();

    public static final native String PAGECONTROLLER_PROPERTY_FREEFORM_SELECTION_CHANGED_LISTENER_get();

    /* JADX INFO: renamed from: PAGECONTROLLER_PROPERTY_GESTURE_STRIKE_THROUGH_BEHAVIOR_DEFAULT_get */
    public static final native String m1085x98e71166();

    public static final native String PAGECONTROLLER_PROPERTY_GESTURE_STRIKE_THROUGH_BEHAVIOR_get();

    public static final native String PAGECONTROLLER_PROPERTY_GESTURE_UNDERLINES_BEHAVIOR_DEFAULT_get();

    public static final native String PAGECONTROLLER_PROPERTY_GESTURE_UNDERLINES_BEHAVIOR_get();

    /* JADX INFO: renamed from: PAGECONTROLLER_PROPERTY_KEYBOARD_SHOW_ON_TAP_INTERACTIONS_ENABLE_DEFAULT_get */
    public static final native String m1086x9e6d4a3e();

    /* JADX INFO: renamed from: PAGECONTROLLER_PROPERTY_KEYBOARD_SHOW_ON_TAP_INTERACTIONS_ENABLE_get */
    public static final native String m1087xc180175c();

    public static final native String PAGECONTROLLER_PROPERTY_LONG_PAGE_HARD_LIMIT_get();

    public static final native String PAGECONTROLLER_PROPERTY_LONG_PAGE_SOFT_LIMIT_get();

    public static final native String PAGECONTROLLER_PROPERTY_MATH_BONUS_ENABLE_DEFAULT_get();

    public static final native String PAGECONTROLLER_PROPERTY_MATH_BONUS_ENABLE_get();

    public static final native String PAGECONTROLLER_PROPERTY_PDF_SQUASH_DEFAULT_get();

    public static final native String PAGECONTROLLER_PROPERTY_PDF_SQUASH_get();

    public static final native String PAGECONTROLLER_PROPERTY_REFLOW_STACKING_ENABLE_DEFAULT_get();

    public static final native String PAGECONTROLLER_PROPERTY_REFLOW_STACKING_ENABLE_get();

    /* JADX INFO: renamed from: PAGECONTROLLER_PROPERTY_RESTORE_SCROLL_POSITION_ENABLE_DEFAULT_get */
    public static final native String m1088x40a29127();

    public static final native String PAGECONTROLLER_PROPERTY_RESTORE_SCROLL_POSITION_ENABLE_get();

    public static final native String PAGECONTROLLER_PROPERTY_SHAPE_BONUS_ENABLE_DEFAULT_get();

    public static final native String PAGECONTROLLER_PROPERTY_SHAPE_BONUS_ENABLE_get();

    public static final native String PAGECONTROLLER_PROPERTY_SLICE_GESTURE_ENABLE_DEFAULT_get();

    public static final native String PAGECONTROLLER_PROPERTY_SLICE_GESTURE_ENABLE_get();

    public static final native String PAGECONTROLLER_PROPERTY_STYLUS_BUTTON_ERASER_ENABLE_DEFAULT_get();

    public static final native String PAGECONTROLLER_PROPERTY_STYLUS_BUTTON_ERASER_ENABLE_get();

    /* JADX INFO: renamed from: PAGECONTROLLER_PROPERTY_STYLUS_BUTTON_SELECTOR_ENABLE_DEFAULT_get */
    public static final native String m1089x5b34dc46();

    public static final native String PAGECONTROLLER_PROPERTY_STYLUS_BUTTON_SELECTOR_ENABLE_get();

    public static final native String PAGECONTROLLER_PROPERTY_TITLE_GESTURE_ENABLE_DEFAULT_get();

    public static final native String PAGECONTROLLER_PROPERTY_TITLE_GESTURE_ENABLE_get();

    public static final native String PAGECONTROLLER_PROPERTY_TRUE_get();

    public static final native float PAGECONTROLLER_PROPERTY_ZOOM_FULL_PAGE_PDF_DEFAULT_get();

    public static final native String PAGECONTROLLER_PROPERTY_ZOOM_FULL_PAGE_PDF_get();

    public static final native String PROPERTY_PREFIX_PDF_get();

    public static final native String PROPERTY_PREFIX_RAW_CONTENT_get();

    public static final native long PageControllerSanitized_pageController_get(long j, PageControllerSanitized pageControllerSanitized);

    public static final native void PageControllerSanitized_pageController_set(long j, PageControllerSanitized pageControllerSanitized, long j2, PageController pageController);

    public static final native long PageControllerSanitized_sanitizerResult_get(long j, PageControllerSanitized pageControllerSanitized);

    public static final native void PageControllerSanitized_sanitizerResult_set(long j, PageControllerSanitized pageControllerSanitized, long j2, NeboSanitizer.SanitizerResult sanitizerResult);

    public static final native long PageController_DefaultOptionContext_get();

    public static final native long PageController_FreeformTypesetOptionContext_get();

    public static final native long PageController_NoStackingOptionContext_get();

    public static final native byte[] PageController_activeAreaId(long j, PageController pageController);

    public static final native long PageController_activeBlockManager(long j, PageController pageController);

    public static final native long PageController_activeTool(long j, PageController pageController);

    public static final native long PageController_activeToolKind(long j, PageController pageController);

    public static final native void PageController_addChildPageListener(long j, PageController pageController, IChildPageListener iChildPageListener);

    public static final native void PageController_addDecorationNotificationListener(long j, PageController pageController, long j2);

    public static final native void PageController_addEventListener(long j, PageController pageController, IEventListener iEventListener);

    public static final native void PageController_addGesturesNotificationListener(long j, PageController pageController, IGesturesNotificationListener iGesturesNotificationListener);

    public static final native boolean PageController_addImage__SWIG_0(long j, PageController pageController, long j2, ImageParameter imageParameter);

    public static final native boolean PageController_addImage__SWIG_1(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native void PageController_addImages(long j, PageController pageController, long j2, SWIGVectorImageParameter sWIGVectorImageParameter);

    public static final native void PageController_addKeyboardListener(long j, PageController pageController, IKeyboardListener iKeyboardListener);

    public static final native void PageController_addMessageListener(long j, PageController pageController, IMessageListener iMessageListener);

    public static final native void PageController_addPageStateListener(long j, PageController pageController, IPageStateListener iPageStateListener);

    public static final native void PageController_addReflowSessionListener(long j, PageController pageController, IReflowSessionListener iReflowSessionListener);

    public static final native void PageController_addResourceSearchDir(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_addResourceSearchDirs(long j, PageController pageController, long j2, SWIGVectorString sWIGVectorString);

    public static final native void PageController_addURIListener(long j, PageController pageController, IURIListener iURIListener);

    public static final native void PageController_applyStyleSelector__SWIG_0(long j, PageController pageController, long j2, byte[] bArr, byte[] bArr2);

    public static final native void PageController_applyStyleSelector__SWIG_1(long j, PageController pageController, long j2, byte[] bArr);

    public static final native boolean PageController_atLeastContainsOneText(long j, Page page, long j2, Selection selection);

    public static final native void PageController_autoActivateSmartPen(long j, PageController pageController);

    public static final native byte[] PageController_automaticPageTitle(long j, PageController pageController);

    public static final native long PageController_backendDispatcher(long j, PageController pageController);

    public static final native long PageController_backgroundObject__SWIG_0(long j, PageController pageController, long j2, CompositeBox compositeBox);

    public static final native long PageController_backgroundObject__SWIG_1(long j, PageController pageController);

    public static final native long PageController_boxAt(long j, PageController pageController, long j2, Point point);

    public static final native long PageController_boxByContentFieldId(long j, PageController pageController, byte[] bArr);

    public static final native long PageController_boxFactory(long j, PageController pageController);

    public static final native byte[] PageController_boxTypeFromId(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_bypassCurrentSessionTimer(long j, PageController pageController);

    public static final native void PageController_bypassSessionTimerOnce(long j, PageController pageController, boolean z);

    public static final native void PageController_callKeyboardCallbacksAgain(long j, PageController pageController);

    public static final native boolean PageController_canConfigureBackgroundColor(byte[] bArr);

    public static final native boolean PageController_canConfigureBackgroundPattern(byte[] bArr);

    public static final native boolean PageController_canRedo(long j, PageController pageController);

    public static final native boolean PageController_canUndo(long j, PageController pageController);

    public static final native void PageController_checkForLongPage(long j, PageController pageController);

    public static final native byte[] PageController_childPageCustomAttribute(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native void PageController_childPageSetCustomAttribute(long j, PageController pageController, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native void PageController_clean(long j, PageController pageController);

    public static final native void PageController_clear(long j, PageController pageController);

    public static final native void PageController_clearInteractionState(long j, PageController pageController);

    public static final native long PageController_componentData(long j, PageController pageController);

    public static final native boolean PageController_computeGrid__SWIG_0(long j, PageController pageController, float f, float f2, long j2, Point point, long j3, Point point2, float f3, float f4, boolean z, boolean z2, int i, float f5, boolean z3);

    public static final native boolean PageController_computeGrid__SWIG_1(long j, PageController pageController, float f, float f2, long j2, Point point, long j3, Point point2, float f3, float f4, boolean z, boolean z2, int i, float f5);

    public static final native boolean PageController_computeGrid__SWIG_2(long j, PageController pageController, float f, float f2, long j2, Point point, long j3, Point point2, float f3, float f4, boolean z, boolean z2, int i);

    public static final native void PageController_configureTool(long j, PageController pageController, long j2, ToolConfiguration toolConfiguration);

    public static final native boolean PageController_configure__SWIG_0(long j, PageController pageController, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native boolean PageController_configure__SWIG_1(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native long PageController_contentExtent__SWIG_0(long j, PageController pageController, int i);

    public static final native long PageController_contentExtent__SWIG_1(long j, PageController pageController);

    public static final native long PageController_contentSelection(long j, PageController pageController);

    public static final native long PageController_contentSelectionFromGroup(long j, PageController pageController);

    public static final native byte[] PageController_contentTypeAt(long j, PageController pageController, long j2, Point point);

    public static final native void PageController_convert(long j, PageController pageController);

    public static final native void PageController_convertSelection(long j, PageController pageController);

    public static final native void PageController_copyAs__SWIG_0(long j, PageController pageController, long j2, Selection selection, byte[] bArr, long j3, byte[] bArr2);

    public static final native void PageController_copyAs__SWIG_1(long j, PageController pageController, long j2, Selection selection, byte[] bArr, long j3);

    public static final native void PageController_copyAs__SWIG_2(long j, PageController pageController, long j2, Selection selection, byte[] bArr);

    public static final native void PageController_copyAs__SWIG_3(long j, PageController pageController, byte[] bArr, long j2, byte[] bArr2);

    public static final native void PageController_copyAs__SWIG_4(long j, PageController pageController, byte[] bArr, long j2);

    public static final native void PageController_copyAs__SWIG_5(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_copyRedirect(long j, PageController pageController);

    public static final native void PageController_copy__SWIG_0(long j, PageController pageController);

    public static final native void PageController_copy__SWIG_1(long j, PageController pageController, long j2, GridBox gridBox, long j3, Page page);

    public static final native void PageController_copy__SWIG_2(long j, PageController pageController, long j2, GridBox gridBox, long j3, Selection selection, boolean z, byte[] bArr, long j4, long j5, Page page);

    public static final native long PageController_createBlock__SWIG_0(long j, PageController pageController, byte[] bArr);

    public static final native long PageController_createBlock__SWIG_1(long j, PageController pageController, long j2, Point point, byte[] bArr);

    public static final native long PageController_createBlock__SWIG_2(long j, PageController pageController, long j2, Point point, byte[] bArr, boolean z);

    public static final native byte[] PageController_createChildPage__SWIG_0(long j, PageController pageController, byte[] bArr, boolean z);

    public static final native byte[] PageController_createChildPage__SWIG_1(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_createContentField__SWIG_0(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native void PageController_createContentField__SWIG_1(long j, PageController pageController, byte[] bArr);

    public static final native boolean PageController_createSectionAt(long j, PageController pageController, long j2);

    public static final native int PageController_currentInlineSelectionTextType(long j, PageController pageController);

    public static final native long PageController_currentTool(long j, PageController pageController);

    public static final native int PageController_currentToolType(long j, PageController pageController);

    public static final native float PageController_currentToolWidth(long j, PageController pageController);

    public static final native long PageController_cursorDimensionAtCharIndex(long j, PageController pageController, int i);

    public static final native void PageController_cut(long j, PageController pageController);

    public static final native long PageController_dataCollect(long j, PageController pageController);

    public static final native byte[] PageController_defaultActiveAreaId(long j, PageController pageController);

    public static final native byte[] PageController_defaultLayoutGroupId(long j, PageController pageController);

    public static final native void PageController_disableGestures__SWIG_0(long j, PageController pageController, long j2);

    public static final native void PageController_disableGestures__SWIG_1(long j, PageController pageController);

    public static final native void PageController_displayChildPage(long j, PageController pageController, byte[] bArr);

    public static final native boolean PageController_dragAbort(long j, PageController pageController);

    public static final native boolean PageController_dragBegin(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native boolean PageController_dragEnd(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native boolean PageController_dragMove(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native void PageController_dropColorAt(long j, PageController pageController, int i, long j2, Point point);

    public static final native byte[] PageController_duplicateChildPage__SWIG_0(long j, PageController pageController, byte[] bArr, boolean z);

    public static final native byte[] PageController_duplicateChildPage__SWIG_1(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_enableActivePen(long j, PageController pageController, boolean z);

    public static final native void PageController_enableFreeformAligmentGuides(long j, PageController pageController, boolean z);

    public static final native void PageController_enableGestures(long j, PageController pageController);

    public static final native void PageController_enableTapInteractionsToShowKeyboard(long j, PageController pageController, boolean z);

    public static final native boolean PageController_exportAllToDocx(long j, PageController pageController, byte[] bArr, IRendererListener iRendererListener);

    public static final native boolean PageController_exportAllToHTML(long j, PageController pageController, byte[] bArr);

    public static final native boolean PageController_exportAllToJiix(long j, PageController pageController, byte[] bArr);

    public static final native boolean PageController_exportAllToPDF(long j, PageController pageController, byte[] bArr, int i);

    public static final native boolean PageController_exportAllToPNG(long j, PageController pageController, byte[] bArr, IRendererListener iRendererListener);

    public static final native boolean PageController_exportAllToSVG(long j, PageController pageController, byte[] bArr, IRendererListener iRendererListener);

    public static final native boolean PageController_exportAllToText(long j, PageController pageController, byte[] bArr);

    public static final native boolean PageController_exportBoxToHTML(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native boolean PageController_exportBoxToJiix(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native byte[] PageController_exportCurrentSelectionContextToText(long j, PageController pageController);

    public static final native boolean PageController_exportCurrentSelectionToPNG__SWIG_0(long j, PageController pageController, byte[] bArr, IRendererListener iRendererListener, int i);

    public static final native boolean PageController_exportCurrentSelectionToPNG__SWIG_1(long j, PageController pageController, byte[] bArr, IRendererListener iRendererListener);

    public static final native byte[] PageController_exportCurrentSelectionToText(long j, PageController pageController);

    public static final native byte[] PageController_exportRawText__SWIG_0(long j, PageController pageController, long j2, Box box, boolean z);

    public static final native byte[] PageController_exportRawText__SWIG_1(long j, PageController pageController, long j2, Box box);

    public static final native boolean PageController_exportToJiix__SWIG_0(long j, PageController pageController, long j2, GridBox gridBox, byte[] bArr, long j3, long j4);

    public static final native boolean PageController_exportToJiix__SWIG_1(long j, PageController pageController, long j2, GridBox gridBox, long j3, long j4, long j5);

    public static final native long PageController_exportToJiix__SWIG_2(long j, PageController pageController, long j2, GridBox gridBox, long j3, long j4);

    public static final native boolean PageController_exportToPNG2__SWIG_0(long j, PageController pageController, byte[] bArr, byte[] bArr2, IRendererListener iRendererListener, int i);

    public static final native boolean PageController_exportToPNG2__SWIG_1(long j, PageController pageController, byte[] bArr, byte[] bArr2, IRendererListener iRendererListener);

    public static final native boolean PageController_exportToPNG__SWIG_0(long j, PageController pageController, long j2, Box box, byte[] bArr, IRendererListener iRendererListener, int i);

    public static final native boolean PageController_exportToPNG__SWIG_1(long j, PageController pageController, long j2, Box box, byte[] bArr, IRendererListener iRendererListener);

    public static final native boolean PageController_exportToSVG(long j, PageController pageController, long j2, Box box, byte[] bArr, IRendererListener iRendererListener);

    public static final native long PageController_forcedPageSize(long j, PageController pageController);

    public static final native byte[] PageController_fullPageMainBoxId(long j, PageController pageController);

    public static final native boolean PageController_getBoolProperty(long j, PageController pageController, byte[] bArr);

    public static final native long PageController_getBoxExtent(long j, PageController pageController, byte[] bArr);

    public static final native byte[] PageController_getBoxId(long j, PageController pageController, int i);

    public static final native byte[] PageController_getBoxLabel(long j, PageController pageController, byte[] bArr);

    public static final native long PageController_getBox__SWIG_0(long j, PageController pageController, int i);

    public static final native long PageController_getBox__SWIG_1(long j, PageController pageController, byte[] bArr);

    public static final native long PageController_getChildPageActionMenuEntries(long j, PageController pageController, byte[] bArr);

    public static final native byte[] PageController_getChildPageIdAt(long j, PageController pageController, long j2, Point point);

    public static final native byte[] PageController_getChildPageIdAtPageNumber(long j, PageController pageController, long j2);

    public static final native byte[] PageController_getChildPageIdDisplayed(long j, PageController pageController);

    public static final native long PageController_getChildPageList(long j, PageController pageController);

    public static final native long PageController_getChildPageSpec(long j, PageController pageController, byte[] bArr);

    public static final native byte[] PageController_getChildPageText__SWIG_0(long j, PageController pageController, byte[] bArr, boolean z);

    public static final native byte[] PageController_getChildPageText__SWIG_1(long j, PageController pageController, byte[] bArr);

    public static final native int PageController_getCurrentActiveInputManagerState(long j, PageController pageController);

    public static final native long PageController_getEmptySpace(long j, PageController pageController, float f, float f2);

    public static final native byte[] PageController_getFilePath(long j, PageController pageController);

    public static final native boolean PageController_getFreeformAlignmentGuides(long j, PageController pageController);

    public static final native long PageController_getGrid(long j, PageController pageController);

    public static final native int PageController_getNumberOfChildPages(long j, PageController pageController);

    public static final native byte[] PageController_getProperty(long j, PageController pageController, byte[] bArr);

    public static final native long PageController_getRenderer(long j, PageController pageController);

    public static final native float PageController_getScaleAtPosition(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native long PageController_getScrollPosition(long j, PageController pageController, long j2, Json json, long j3);

    public static final native byte[] PageController_getSelectedImage(long j, PageController pageController, byte[] bArr, long j2, Point point, long j3, SWIGAngle sWIGAngle);

    public static final native long PageController_getSmartGuideManager(long j, PageController pageController);

    public static final native long PageController_getSupportedAddBlockTypes(long j, PageController pageController);

    public static final native long PageController_getSupportedAddBlockTypesAt__SWIG_0(long j, PageController pageController, long j2, Point point);

    public static final native long PageController_getSupportedAddBlockTypesAt__SWIG_1(long j, PageController pageController, float f, float f2);

    public static final native long PageController_getSupportedExportMimeTypes(long j, PageController pageController);

    public static final native long PageController_getViewTransform(long j, PageController pageController);

    public static final native boolean PageController_hasContent(long j, PageController pageController);

    public static final native boolean PageController_hasContentToClear(long j, PageController pageController);

    public static final native boolean PageController_hasContentToTypeset(long j, PageController pageController);

    public static final native boolean PageController_hasMissingAttachment(long j, PageController pageController);

    public static final native boolean PageController_hasSelection(long j, PageController pageController);

    public static final native boolean PageController_hasSelectionAt(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native long PageController_importBackgroundObject__SWIG_0(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2, int i, boolean z);

    public static final native long PageController_importBackgroundObject__SWIG_1(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2, int i);

    public static final native long PageController_importBackgroundObject__SWIG_2(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2);

    public static final native long PageController_importBackgroundObject__SWIG_3(long j, PageController pageController, byte[] bArr, byte[] bArr2, int i, boolean z);

    public static final native long PageController_importBackgroundObject__SWIG_4(long j, PageController pageController, byte[] bArr, byte[] bArr2, int i);

    public static final native long PageController_importBackgroundObject__SWIG_5(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native byte[] PageController_importObjectAt__SWIG_0(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2, long j3, Point point, float f, long j4, Extent extent, boolean z, boolean z2, boolean z3);

    public static final native byte[] PageController_importObjectAt__SWIG_1(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2, long j3, Point point, float f, long j4, Extent extent, boolean z, boolean z2);

    public static final native byte[] PageController_importObjectAt__SWIG_10(long j, PageController pageController, byte[] bArr, byte[] bArr2, long j2, Point point, float f, long j3, Extent extent);

    public static final native byte[] PageController_importObjectAt__SWIG_11(long j, PageController pageController, byte[] bArr, byte[] bArr2, long j2, Point point, float f);

    public static final native byte[] PageController_importObjectAt__SWIG_12(long j, PageController pageController, byte[] bArr, byte[] bArr2, long j2, Point point);

    public static final native byte[] PageController_importObjectAt__SWIG_13(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native byte[] PageController_importObjectAt__SWIG_2(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2, long j3, Point point, float f, long j4, Extent extent, boolean z);

    public static final native byte[] PageController_importObjectAt__SWIG_3(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2, long j3, Point point, float f, long j4, Extent extent);

    public static final native byte[] PageController_importObjectAt__SWIG_4(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2, long j3, Point point, float f);

    public static final native byte[] PageController_importObjectAt__SWIG_5(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2, long j3, Point point);

    public static final native byte[] PageController_importObjectAt__SWIG_6(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2);

    public static final native byte[] PageController_importObjectAt__SWIG_7(long j, PageController pageController, byte[] bArr, byte[] bArr2, long j2, Point point, float f, long j3, Extent extent, boolean z, boolean z2, boolean z3);

    public static final native byte[] PageController_importObjectAt__SWIG_8(long j, PageController pageController, byte[] bArr, byte[] bArr2, long j2, Point point, float f, long j3, Extent extent, boolean z, boolean z2);

    public static final native byte[] PageController_importObjectAt__SWIG_9(long j, PageController pageController, byte[] bArr, byte[] bArr2, long j2, Point point, float f, long j3, Extent extent, boolean z);

    public static final native byte[] PageController_importObjectToExtent__SWIG_0(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2, long j3, Extent extent, float f, boolean z, boolean z2, boolean z3);

    public static final native byte[] PageController_importObjectToExtent__SWIG_1(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2, long j3, Extent extent, float f, boolean z, boolean z2);

    public static final native byte[] PageController_importObjectToExtent__SWIG_2(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2, long j3, Extent extent, float f, boolean z);

    public static final native byte[] PageController_importObjectToExtent__SWIG_3(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2, long j3, Extent extent, float f);

    public static final native byte[] PageController_importObjectToExtent__SWIG_4(long j, PageController pageController, long j2, CompositeBox compositeBox, byte[] bArr, byte[] bArr2, long j3, Extent extent);

    public static final native byte[] PageController_importObjectToExtent__SWIG_5(long j, PageController pageController, byte[] bArr, byte[] bArr2, long j2, Extent extent, float f, boolean z, boolean z2, boolean z3);

    public static final native byte[] PageController_importObjectToExtent__SWIG_6(long j, PageController pageController, byte[] bArr, byte[] bArr2, long j2, Extent extent, float f, boolean z, boolean z2);

    public static final native byte[] PageController_importObjectToExtent__SWIG_7(long j, PageController pageController, byte[] bArr, byte[] bArr2, long j2, Extent extent, float f, boolean z);

    public static final native byte[] PageController_importObjectToExtent__SWIG_8(long j, PageController pageController, byte[] bArr, byte[] bArr2, long j2, Extent extent, float f);

    public static final native byte[] PageController_importObjectToExtent__SWIG_9(long j, PageController pageController, byte[] bArr, byte[] bArr2, long j2, Extent extent);

    public static final native void PageController_init(long j, PageController pageController);

    public static final native long PageController_inputDispatcher(long j, PageController pageController);

    public static final native void PageController_insertText__SWIG_0(long j, PageController pageController, byte[] bArr, int i, int i2, boolean z);

    public static final native void PageController_insertText__SWIG_1(long j, PageController pageController, byte[] bArr, int i, int i2);

    public static final native void PageController_insertText__SWIG_2(long j, PageController pageController, byte[] bArr, int i);

    public static final native void PageController_insertText__SWIG_3(long j, PageController pageController, byte[] bArr);

    public static final native long PageController_insertText__SWIG_4(long j, PageController pageController, byte[] bArr, long j2, long j3, Extent extent, long j4, long j5);

    public static final native long PageController_insertText__SWIG_5(long j, PageController pageController, byte[] bArr, long j2, long j3, Extent extent, long j4);

    public static final native long PageController_insertText__SWIG_6(long j, PageController pageController, byte[] bArr, long j2, long j3, Extent extent);

    public static final native boolean PageController_isActivePenAvailable(long j, PageController pageController);

    public static final native boolean PageController_isActivePenEnabled(long j, PageController pageController);

    public static final native boolean PageController_isBusy(long j, PageController pageController);

    public static final native boolean PageController_isCaptureAllowed(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native boolean PageController_isChildPageNavigationCompatible__SWIG_0(long j, PageController pageController);

    public static final native boolean PageController_isChildPageNavigationCompatible__SWIG_1(byte[] bArr);

    public static final native boolean PageController_isClearAllAnnotationsAvailable(long j, PageController pageController);

    public static final native boolean PageController_isClearAllAvailable(long j, PageController pageController);

    public static final native boolean PageController_isConversionPreviewSupported__SWIG_0(byte[] bArr);

    public static final native boolean PageController_isConversionPreviewSupported__SWIG_1(long j, PageController pageController);

    public static final native boolean PageController_isConvertActionAllowed(long j, PageController pageController);

    public static final native boolean PageController_isCopyAuthorized(long j, PageController pageController, byte[] bArr);

    public static final native boolean PageController_isCurrentToolPenDown(long j, PageController pageController);

    public static final native boolean PageController_isEmpty(long j, PageController pageController);

    public static final native boolean PageController_isFingerWritingAllowed(long j, PageController pageController);

    public static final native boolean PageController_isIdle(long j, PageController pageController);

    public static final native boolean PageController_isIndentActionAllowed(long j, PageController pageController);

    public static final native boolean PageController_isKeyboardCompatible(byte[] bArr);

    public static final native boolean PageController_isModified(long j, PageController pageController, long j2, Extent extent, int i);

    public static final native boolean PageController_isOverCheckableItem(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native boolean PageController_isPasteAuthorized(long j, PageController pageController, byte[] bArr);

    public static final native boolean PageController_isReadOnly(long j, PageController pageController);

    public static final native boolean PageController_isSpaceManagementActivable(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native boolean PageController_isSwipeToIndentSupported(long j, PageController pageController);

    public static final native boolean PageController_isTypesetAvailable(long j, PageController pageController);

    public static final native boolean PageController_isUndoRedoAvailable(long j, PageController pageController);

    public static final native boolean PageController_isWriting(long j, PageController pageController);

    public static final native boolean PageController_isWritingInput(long j, PageController pageController, int i);

    public static final native boolean PageController_isZoomIndicatorCompatible__SWIG_0(long j, PageController pageController);

    public static final native boolean PageController_isZoomIndicatorCompatible__SWIG_1(byte[] bArr);

    public static final native boolean PageController_isZoomSupported(long j, PageController pageController);

    public static final native void PageController_keyboardAction(long j, PageController pageController, int i);

    public static final native long PageController_lineBreaks(long j, PageController pageController, long j2, TextBox textBox);

    public static final native long PageController_listItems(long j, PageController pageController, long j2, TextBox textBox);

    public static final native void PageController_listify(long j, PageController pageController, byte[] bArr, int i);

    public static final native boolean PageController_loadActiveAreaData(long j, PageController pageController, byte[] bArr);

    public static final native long PageController_mainBackend(long j, PageController pageController);

    public static final native void PageController_monitor(long j, PageController pageController, long j2);

    public static final native void PageController_moveChildPage__SWIG_0(long j, PageController pageController, byte[] bArr, byte[] bArr2, boolean z);

    public static final native void PageController_moveChildPage__SWIG_1(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native long PageController_newRef(long j, PageController pageController);

    public static final native byte[] PageController_nextPageId(long j, PageController pageController, byte[] bArr);

    public static final native long PageController_objectInteractivity(long j, PageController pageController, byte[] bArr);

    public static final native boolean PageController_objectVisible(long j, PageController pageController, byte[] bArr);

    public static final native boolean PageController_onDoubleTap(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native boolean PageController_onLongPress(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native boolean PageController_onSwipe(long j, PageController pageController, long j2, PointerInfo pointerInfo, boolean z);

    public static final native boolean PageController_onTap(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native boolean PageController_onlyContainsText(long j, Page page, boolean z);

    public static final native long PageController_pageContentEditor(long j, PageController pageController);

    public static final native byte[] PageController_pageInfos__SWIG_0(long j, PageController pageController, boolean z);

    public static final native byte[] PageController_pageInfos__SWIG_1(long j, PageController pageController);

    public static final native long PageController_pageLayoutListener(long j, PageController pageController);

    public static final native long PageController_pageRowid(long j, PageController pageController);

    public static final native byte[] PageController_pageType(long j, PageController pageController);

    public static final native void PageController_paste(long j, PageController pageController);

    public static final native void PageController_pasteAt2(long j, PageController pageController, float f, float f2);

    public static final native void PageController_pasteInline(long j, PageController pageController, byte[] bArr);

    public static final native long PageController_pasteText(long j, PageController pageController, byte[] bArr, long j2, Point point);

    public static final native void PageController_penAbort__SWIG_0(long j, PageController pageController, int i);

    public static final native void PageController_penAbort__SWIG_1(long j, PageController pageController);

    public static final native void PageController_penDown(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native void PageController_penMove__SWIG_0(long j, PageController pageController, long j2, SWIGVectorPointerInfo sWIGVectorPointerInfo);

    public static final native void PageController_penMove__SWIG_1(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native void PageController_penMove__SWIG_2(long j, PageController pageController, int i, float[] fArr, float[] fArr2, float[] fArr3, long[] jArr, int i2, int i3, int i4);

    public static final native void PageController_penMove__SWIG_3(long j, PageController pageController, int i, float[] fArr, float[] fArr2, float[] fArr3, long[] jArr, int i2, int i3);

    public static final native void PageController_penUp(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native void PageController_postRedo(long j, PageController pageController);

    public static final native void PageController_postUndo(long j, PageController pageController);

    public static final native void PageController_preRedo(long j, PageController pageController);

    public static final native void PageController_preUndo(long j, PageController pageController);

    public static final native byte[] PageController_prevPageId(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_preventUndo(long j, PageController pageController);

    public static final native void PageController_reAttachAll(long j, PageController pageController);

    public static final native void PageController_reTypeset__SWIG_0(long j, PageController pageController, long j2, SWIGVectorString sWIGVectorString);

    public static final native void PageController_reTypeset__SWIG_1(long j, PageController pageController);

    public static final native long PageController_recoContext(long j, PageController pageController);

    public static final native void PageController_recognize(long j, PageController pageController);

    public static final native void PageController_redo(long j, PageController pageController);

    public static final native boolean PageController_reflow(long j, PageController pageController);

    public static final native long PageController_reflowSession(long j, PageController pageController);

    public static final native boolean PageController_reflowWithLimit(long j, PageController pageController, float f);

    public static final native void PageController_refreshEmphasisInformation(long j, PageController pageController);

    public static final native void PageController_refreshSpaceInformation(long j, PageController pageController);

    public static final native void PageController_releaseCurrentSelection(long j, PageController pageController);

    public static final native void PageController_reloadUserDictionary(long j, PageController pageController, long j2, UserDictionary userDictionary);

    public static final native void PageController_remove(long j, PageController pageController);

    public static final native void PageController_removeBox(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_removeChildPage(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_removeChildPageListener(long j, PageController pageController, IChildPageListener iChildPageListener);

    public static final native void PageController_removeDecorationNotificationListener(long j, PageController pageController, long j2);

    public static final native void PageController_removeEventListener(long j, PageController pageController, IEventListener iEventListener);

    public static final native void PageController_removeGesturesNotificationListener(long j, PageController pageController, IGesturesNotificationListener iGesturesNotificationListener);

    public static final native void PageController_removeKeyboardListener(long j, PageController pageController, IKeyboardListener iKeyboardListener);

    public static final native void PageController_removeListenersFromSmartGuide(long j, PageController pageController);

    public static final native void PageController_removeMessageListener(long j, PageController pageController, IMessageListener iMessageListener);

    public static final native void PageController_removePageStateListener(long j, PageController pageController, IPageStateListener iPageStateListener);

    public static final native void PageController_removeReflowSessionListener(long j, PageController pageController, IReflowSessionListener iReflowSessionListener);

    public static final native void PageController_removeURIListener(long j, PageController pageController, IURIListener iURIListener);

    public static final native byte[] PageController_replaceSelectedImage(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native void PageController_resetStyles(long j, PageController pageController);

    public static final native void PageController_resize(long j, PageController pageController);

    public static final native boolean PageController_retrieveObjectUserData(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native void PageController_saveScrollPosition(long j, PageController pageController);

    public static final native long PageController_scrollBehavior(long j, PageController pageController);

    public static final native void PageController_scrollTo(long j, PageController pageController, float f, float f2);

    public static final native void PageController_scrollToStroke(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native long PageController_selectedIds(long j, PageController pageController);

    public static final native long PageController_selectionExtent(long j, PageController pageController);

    public static final native int PageController_selectionState(long j, PageController pageController);

    public static final native void PageController_setActionMenuListener(long j, PageController pageController, IActionMenuListener iActionMenuListener);

    public static final native void PageController_setActiveToolKind(long j, PageController pageController, long j2);

    public static final native void PageController_setAutoScrollListener(long j, PageController pageController, IAutoScrollListener iAutoScrollListener);

    public static final native void PageController_setBackgroundColor(long j, PageController pageController, int i);

    public static final native boolean PageController_setBackgroundImage__SWIG_0(long j, PageController pageController, byte[] bArr, byte[] bArr2, int i);

    public static final native boolean PageController_setBackgroundImage__SWIG_1(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native void PageController_setBackgroundPattern__SWIG_0(long j, PageController pageController, int i);

    public static final native void PageController_setBackgroundPattern__SWIG_1(long j, PageController pageController, int i, float[] fArr);

    public static final native void PageController_setBigTypesetExtraStyle(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_setClipboardConfiguration(long j, PageController pageController, long j2, ClipboardConfiguration clipboardConfiguration);

    public static final native void PageController_setColor(long j, PageController pageController, int i);

    public static final native void PageController_setColorInversionPolicy(long j, PageController pageController, IColorInversionPolicy iColorInversionPolicy);

    public static final native void PageController_setCursorIndex(long j, PageController pageController, int i, int i2);

    public static final native void PageController_setCursorPlatformBehavior(long j, PageController pageController, long j2, CursorPlatformBehavior cursorPlatformBehavior);

    public static final native void PageController_setCursorPosition(long j, PageController pageController, int i, long j2, PointerInfo pointerInfo, boolean z);

    public static final native void PageController_setDefaultLanguage__SWIG_0(long j, PageController pageController, byte[] bArr, boolean z);

    public static final native void PageController_setDefaultLanguage__SWIG_1(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_setEnablePartialInvalidates(long j, PageController pageController, boolean z);

    public static final native void PageController_setEraserStylusButton(long j, PageController pageController, boolean z);

    public static final native boolean PageController_setGridAndStylesheet__SWIG_0(long j, PageController pageController, long j2, LayoutGrid layoutGrid, boolean z, boolean z2, float f);

    public static final native boolean PageController_setGridAndStylesheet__SWIG_1(long j, PageController pageController, long j2, LayoutGrid layoutGrid, boolean z, boolean z2);

    public static final native boolean PageController_setGridAndStylesheet__SWIG_2(long j, PageController pageController, long j2, LayoutGrid layoutGrid, boolean z);

    public static final native boolean PageController_setGridAndStylesheet__SWIG_3(long j, PageController pageController, long j2, LayoutGrid layoutGrid);

    public static final native void PageController_setGridStrategy(long j, PageController pageController, long j2, IGridFactoryStrategy iGridFactoryStrategy);

    public static final native void PageController_setHasMissingAttachment(long j, PageController pageController, boolean z);

    public static final native void PageController_setInlineSelectionOverrideStyle(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_setMotionPredictionParams(long j, PageController pageController, long j2, MotionPredictionParams motionPredictionParams);

    public static final native void PageController_setNativeClipboard(long j, PageController pageController, INativeClipboard iNativeClipboard);

    public static final native boolean PageController_setObjectInteractivity__SWIG_0(long j, PageController pageController, byte[] bArr, long j2);

    public static final native boolean PageController_setObjectInteractivity__SWIG_1(long j, PageController pageController, byte[] bArr);

    public static final native boolean PageController_setObjectVisible__SWIG_0(long j, PageController pageController, byte[] bArr, boolean z);

    public static final native boolean PageController_setObjectVisible__SWIG_1(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_setPageHeight(long j, PageController pageController, float f);

    public static final native void PageController_setPageRowid(long j, PageController pageController, long j2);

    public static final native void PageController_setPressureSensitivity(long j, PageController pageController, float f);

    public static final native void PageController_setProperties(long j, PageController pageController, long j2);

    public static final native void PageController_setProperty__SWIG_0(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native void PageController_setProperty__SWIG_1(long j, PageController pageController, byte[] bArr, boolean z);

    public static final native void PageController_setRendererListener(long j, PageController pageController, IRendererListener iRendererListener);

    public static final native void PageController_setSearchController(long j, PageController pageController, long j2, SearchController searchController, long j3, PageKey pageKey);

    public static final native void PageController_setSmallTypesetExtraStyle(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_setStyleClasses(long j, PageController pageController, byte[] bArr);

    public static final native void PageController_setTheme(long j, PageController pageController, byte[] bArr, boolean z);

    public static final native void PageController_setThicknessRatio(long j, PageController pageController, float f);

    public static final native void PageController_setTool(long j, PageController pageController, int i);

    public static final native void PageController_setToolbarConfigurationListener(long j, PageController pageController, IToolbarConfigurationListener iToolbarConfigurationListener);

    public static final native void PageController_setTypesetListener(long j, PageController pageController, ITypesetListener iTypesetListener);

    public static final native void PageController_setViewbox(long j, PageController pageController, float f, float f2, float f3, float f4);

    public static final native void PageController_setViewport__SWIG_0(long j, PageController pageController, long j2, Extent extent, long j3, ViewTransform viewTransform, boolean z);

    public static final native void PageController_setViewport__SWIG_1(long j, PageController pageController, long j2, Extent extent, float f, boolean z);

    public static final native void PageController_setViewport__SWIG_2(long j, PageController pageController, long j2, Extent extent, float f);

    public static final native void PageController_setViewport__SWIG_3(long j, PageController pageController, long j2, Extent extent);

    public static final native void PageController_setWaitIdleForExport(long j, PageController pageController, boolean z);

    public static final native void PageController_setWritingPosition(long j, PageController pageController, byte[] bArr);

    public static final native boolean PageController_shouldPreserveImageProperties__SWIG_0(long j, PageController pageController);

    public static final native boolean PageController_shouldPreserveImageProperties__SWIG_1(long j, PageController pageController, long j2, Point point);

    public static final native boolean PageController_shouldPreserveImageProperties__SWIG_2(long j, PageController pageController, float f, float f2);

    public static final native void PageController_spaceManagement(long j, PageController pageController, long j2, PointerInfo pointerInfo);

    public static final native void PageController_stack(long j, PageController pageController);

    public static final native long PageController_startKeyboardListenerTransaction(long j, PageController pageController);

    public static final native long PageController_style(long j, PageController pageController);

    public static final native long PageController_textSelectionWithContext(long j, PageController pageController);

    public static final native void PageController_textify(long j, PageController pageController, int i);

    public static final native byte[] PageController_toString(long j, PageController pageController);

    public static final native void PageController_typesetAll(long j, PageController pageController);

    public static final native void PageController_undo(long j, PageController pageController);

    public static final native void PageController_unmonitor(long j, PageController pageController, long j2);

    public static final native void PageController_unsetCursor(long j, PageController pageController, int i);

    public static final native void PageController_updateBlocksSettings(long j, PageController pageController, byte[] bArr, byte[] bArr2, boolean z);

    public static final native void PageController_updateKeyboardModifiers(long j, PageController pageController, boolean z, boolean z2, boolean z3);

    public static final native byte[] PageController_updateObjectAt__SWIG_0(long j, PageController pageController, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, Point point, float f, long j3, Extent extent, boolean z, boolean z2);

    public static final native byte[] PageController_updateObjectAt__SWIG_1(long j, PageController pageController, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, Point point, float f, long j3, Extent extent, boolean z);

    public static final native byte[] PageController_updateObjectAt__SWIG_2(long j, PageController pageController, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, Point point, float f, long j3, Extent extent);

    public static final native byte[] PageController_updateObjectAt__SWIG_3(long j, PageController pageController, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, Point point, float f);

    public static final native byte[] PageController_updateObjectAt__SWIG_4(long j, PageController pageController, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, Point point);

    public static final native byte[] PageController_updateObjectAt__SWIG_5(long j, PageController pageController, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native byte[] PageController_updateObjectToExtent__SWIG_0(long j, PageController pageController, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, Extent extent, float f, boolean z, boolean z2);

    public static final native byte[] PageController_updateObjectToExtent__SWIG_1(long j, PageController pageController, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, Extent extent, float f, boolean z);

    public static final native byte[] PageController_updateObjectToExtent__SWIG_2(long j, PageController pageController, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, Extent extent, float f);

    public static final native byte[] PageController_updateObjectToExtent__SWIG_3(long j, PageController pageController, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, Extent extent);

    public static final native boolean PageController_updateObjectUserData(long j, PageController pageController, byte[] bArr, byte[] bArr2);

    public static final native byte[] PageController_updateTextBox2(long j, PageController pageController, byte[] bArr, byte[] bArr2, boolean z);

    public static final native long PageController_updateTextBox__SWIG_0(long j, PageController pageController, long j2, TextBox textBox, byte[] bArr, long j3);

    public static final native long PageController_updateTextBox__SWIG_1(long j, PageController pageController, long j2, TextBox textBox, byte[] bArr);

    public static final native long PageController_viewport(long j, PageController pageController);

    public static final native void PageController_waitForIdle(long j, PageController pageController);

    public static final native byte[] PageController_workingDirPath(long j, PageController pageController);

    public static final native long PageKey_createKeyFromAbsolutePath(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native long PageKey_createKeyFromUuid(byte[] bArr);

    public static final native long PageKey_deserialize(byte[] bArr);

    public static final native int PageKey_hashCode(long j, PageKey pageKey);

    public static final native boolean PageKey_isValid(long j, PageKey pageKey);

    public static final native byte[] PageKey_loweredRelativeDocumentPath(long j, PageKey pageKey);

    public static final native boolean PageKey_move(long j, PageKey pageKey, byte[] bArr);

    public static final native boolean PageKey_nativeEquals(long j, PageKey pageKey, long j2, PageKey pageKey2);

    public static final native byte[] PageKey_pageId(long j, PageKey pageKey);

    public static final native byte[] PageKey_relativeDocumentPath(long j, PageKey pageKey);

    public static final native byte[] PageKey_serialize(long j, PageKey pageKey);

    public static final native byte[] PageKey_toString(long j, PageKey pageKey);

    public static final native byte[] PageKey_uuid(long j, PageKey pageKey);

    public static final native long PaperSize_A0_get();

    public static final native long PaperSize_A10_get();

    public static final native long PaperSize_A1_get();

    public static final native long PaperSize_A2_get();

    public static final native long PaperSize_A3_get();

    public static final native long PaperSize_A4_get();

    public static final native long PaperSize_A5_get();

    public static final native long PaperSize_A6_get();

    public static final native long PaperSize_A7_get();

    public static final native long PaperSize_A8_get();

    public static final native long PaperSize_A9_get();

    public static final native long PaperSize_US_Legal_get();

    public static final native long PaperSize_US_Letter_get();

    public static final native long PaperSize_US_Tabloid_get();

    public static final native long PaperSize_Unlimited_get();

    public static final native double PaperSize_aspectRatio(long j, PaperSize paperSize);

    public static final native int PaperSize_hashCode(long j, PaperSize paperSize);

    public static final native float PaperSize_height_get(long j, PaperSize paperSize);

    public static final native void PaperSize_height_set(long j, PaperSize paperSize, float f);

    public static final native boolean PaperSize_isLandscape(long j, PaperSize paperSize);

    public static final native boolean PaperSize_isPortrait(long j, PaperSize paperSize);

    public static final native boolean PaperSize_isUnlimited(long j, PaperSize paperSize);

    public static final native boolean PaperSize_nativeEquals(long j, PaperSize paperSize, long j2, PaperSize paperSize2);

    public static final native void PaperSize_rotate(long j, PaperSize paperSize);

    public static final native long PaperSize_rotated(long j, PaperSize paperSize);

    public static final native float PaperSize_surface(long j, PaperSize paperSize);

    public static final native byte[] PaperSize_toString(long j, PaperSize paperSize);

    public static final native float PaperSize_width_get(long j, PaperSize paperSize);

    public static final native void PaperSize_width_set(long j, PaperSize paperSize, float f);

    public static final native byte[] QueryBuilder_build(byte[] bArr);

    public static final native boolean QueryBuilder_valid(byte[] bArr);

    public static final native String RAW_CONTENT_PROPERTIES_PREFIX_get();

    public static final native long RecoContext_customResources_get(long j, RecoContext recoContext);

    public static final native void RecoContext_customResources_set(long j, RecoContext recoContext, long j2, SWIGVectorCustomResource sWIGVectorCustomResource);

    public static final native boolean RecoContext_hasReco(long j, RecoContext recoContext);

    public static final native long RecoContext_resourcesDirs_get(long j, RecoContext recoContext);

    public static final native void RecoContext_resourcesDirs_set(long j, RecoContext recoContext, long j2, SWIGVectorString sWIGVectorString);

    public static final native long RecoContext_typesetListener_get(long j, RecoContext recoContext);

    public static final native void RecoContext_typesetListener_set(long j, RecoContext recoContext, long j2);

    public static final native boolean ReflowOptions_enableStacking_get(long j, ReflowOptions reflowOptions);

    public static final native void ReflowOptions_enableStacking_set(long j, ReflowOptions reflowOptions, boolean z);

    public static final native byte[] SN2_TEXT_CONFIGURATION_NAME_get();

    public static final native long SWIGAngle_SWIGUpcast(long j);

    public static final native long SWIGAngle_Undefined();

    public static final native long SWIGAngle_abs(long j, SWIGAngle sWIGAngle);

    public static final native boolean SWIGAngle_almostEquals__SWIG_0(long j, SWIGAngle sWIGAngle, long j2, SWIGAngle sWIGAngle2, double d);

    public static final native boolean SWIGAngle_almostEquals__SWIG_1(long j, SWIGAngle sWIGAngle, long j2, SWIGAngle sWIGAngle2);

    public static final native long SWIGAngle_fromDegrees(double d);

    public static final native boolean SWIGAngle_isInRange(long j, SWIGAngle sWIGAngle, long j2, SWIGAngle sWIGAngle2, long j3, ValuedAngle valuedAngle);

    public static final native long SWIGAngle_maxDiff__SWIG_0(long j, SWIGAngle sWIGAngle, long j2, SWIGAngle sWIGAngle2, double d);

    public static final native long SWIGAngle_maxDiff__SWIG_1(long j, SWIGAngle sWIGAngle, long j2, SWIGAngle sWIGAngle2);

    public static final native long SWIGAngle_minDiff__SWIG_0(long j, SWIGAngle sWIGAngle, long j2, SWIGAngle sWIGAngle2, double d);

    public static final native long SWIGAngle_minDiff__SWIG_1(long j, SWIGAngle sWIGAngle, long j2, SWIGAngle sWIGAngle2);

    public static final native long SWIGAngle_roundedAround(long j, SWIGAngle sWIGAngle, long j2, SWIGAngle sWIGAngle2, double d);

    public static final native double SWIGAngle_valueModuloTwoPI(long j, SWIGAngle sWIGAngle);

    public static final native float SWIGAngle_valueModuloTwoPIAsFloat(long j, SWIGAngle sWIGAngle);

    public static final native void SWIGOptionContext_setProperty(long j, SWIGOptionContext sWIGOptionContext, byte[] bArr, byte[] bArr2);

    public static final native long SWIGVectorCollectionKey_at(long j, SWIGVectorCollectionKey sWIGVectorCollectionKey, int i);

    public static final native void SWIGVectorCollectionKey_push_back(long j, SWIGVectorCollectionKey sWIGVectorCollectionKey, long j2, CollectionKey collectionKey);

    public static final native int SWIGVectorCollectionKey_size(long j, SWIGVectorCollectionKey sWIGVectorCollectionKey);

    public static final native int SWIGVectorColors_at(long j, SWIGVectorColors sWIGVectorColors, int i);

    public static final native void SWIGVectorColors_push_back(long j, SWIGVectorColors sWIGVectorColors, int i);

    public static final native int SWIGVectorColors_size(long j, SWIGVectorColors sWIGVectorColors);

    public static final native long SWIGVectorImageParameter_at(long j, SWIGVectorImageParameter sWIGVectorImageParameter, int i);

    public static final native void SWIGVectorImageParameter_push_back(long j, SWIGVectorImageParameter sWIGVectorImageParameter, long j2, ImageParameter imageParameter);

    public static final native int SWIGVectorImageParameter_size(long j, SWIGVectorImageParameter sWIGVectorImageParameter);

    public static final native long SWIGVectorLocaleInfo_at(long j, SWIGVectorLocaleInfo sWIGVectorLocaleInfo, int i);

    public static final native void SWIGVectorLocaleInfo_push_back(long j, SWIGVectorLocaleInfo sWIGVectorLocaleInfo, long j2, LocaleInfo localeInfo);

    public static final native int SWIGVectorLocaleInfo_size(long j, SWIGVectorLocaleInfo sWIGVectorLocaleInfo);

    public static final native long SWIGVectorNotebookKey_at(long j, SWIGVectorNotebookKey sWIGVectorNotebookKey, int i);

    public static final native void SWIGVectorNotebookKey_push_back(long j, SWIGVectorNotebookKey sWIGVectorNotebookKey, long j2, NotebookKey notebookKey);

    public static final native int SWIGVectorNotebookKey_size(long j, SWIGVectorNotebookKey sWIGVectorNotebookKey);

    public static final native long SWIGVectorPageKey_at(long j, SWIGVectorPageKey sWIGVectorPageKey, int i);

    public static final native void SWIGVectorPageKey_push_back(long j, SWIGVectorPageKey sWIGVectorPageKey, long j2, PageKey pageKey);

    public static final native int SWIGVectorPageKey_size(long j, SWIGVectorPageKey sWIGVectorPageKey);

    public static final native long SWIGVectorSearchMatch_at(long j, SWIGVectorSearchMatch sWIGVectorSearchMatch, int i);

    public static final native void SWIGVectorSearchMatch_push_back(long j, SWIGVectorSearchMatch sWIGVectorSearchMatch, long j2, SearchMatch searchMatch);

    public static final native int SWIGVectorSearchMatch_size(long j, SWIGVectorSearchMatch sWIGVectorSearchMatch);

    public static final native long SWIGVectorToolConfiguration_at(long j, SWIGVectorToolConfiguration sWIGVectorToolConfiguration, int i);

    public static final native void SWIGVectorToolConfiguration_push_back(long j, SWIGVectorToolConfiguration sWIGVectorToolConfiguration, long j2, ToolConfiguration toolConfiguration);

    public static final native int SWIGVectorToolConfiguration_size(long j, SWIGVectorToolConfiguration sWIGVectorToolConfiguration);

    public static final native boolean ScrollBarBehavior_isHorizontalScrollAllowed_get(long j, ScrollBarBehavior scrollBarBehavior);

    public static final native void ScrollBarBehavior_isHorizontalScrollAllowed_set(long j, ScrollBarBehavior scrollBarBehavior, boolean z);

    public static final native boolean ScrollBarBehavior_isVerticalScrollAllowed_get(long j, ScrollBarBehavior scrollBarBehavior);

    public static final native void ScrollBarBehavior_isVerticalScrollAllowed_set(long j, ScrollBarBehavior scrollBarBehavior, boolean z);

    public static final native boolean ScrollBarBehavior_isZoomAllowed_get(long j, ScrollBarBehavior scrollBarBehavior);

    public static final native void ScrollBarBehavior_isZoomAllowed_set(long j, ScrollBarBehavior scrollBarBehavior, boolean z);

    public static final native float ScrollBarBehavior_maxZoom_get(long j, ScrollBarBehavior scrollBarBehavior);

    public static final native void ScrollBarBehavior_maxZoom_set(long j, ScrollBarBehavior scrollBarBehavior, float f);

    public static final native float ScrollBarBehavior_minZoom_get(long j, ScrollBarBehavior scrollBarBehavior);

    public static final native void ScrollBarBehavior_minZoom_set(long j, ScrollBarBehavior scrollBarBehavior, float f);

    public static final native long SearchController_SearchDMSFileSystem_SWIGUpcast(long j);

    public static final native long SearchController_SearchDMSFileSystem_collectionKeyFromEntry(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, byte[] bArr);

    /* JADX INFO: renamed from: SearchController_SearchDMSFileSystem_collectionKeyFromNotebookKey */
    public static final native long m1090x5e7e4b26(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, long j2, NotebookKey notebookKey);

    public static final native long SearchController_SearchDMSFileSystem_collections(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem);

    public static final native long SearchController_SearchDMSFileSystem_notebookKeyFromEntry(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, byte[] bArr);

    public static final native long SearchController_SearchDMSFileSystem_notebookKeyFromPageKey(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, long j2, PageKey pageKey);

    public static final native long SearchController_SearchDMSFileSystem_notebooks(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, byte[] bArr);

    public static final native long SearchController_SearchDMSFileSystem_openPage(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, long j2, PageKey pageKey);

    public static final native int SearchController_SearchDMSFileSystem_pageCount__SWIG_0(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, long j2, NotebookKey notebookKey);

    public static final native int SearchController_SearchDMSFileSystem_pageCount__SWIG_1(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, long j2, PageKey pageKey);

    public static final native boolean SearchController_SearchDMSFileSystem_pageIsContainer(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, long j2, PageKey pageKey);

    public static final native long SearchController_SearchDMSFileSystem_pageKeyFromEntry(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, byte[] bArr);

    /* JADX INFO: renamed from: SearchController_SearchDMSFileSystem_pageKeyFromPageIndex__SWIG_0 */
    public static final native long m1091xa0595be9(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, long j2, NotebookKey notebookKey, int i);

    /* JADX INFO: renamed from: SearchController_SearchDMSFileSystem_pageKeyFromPageIndex__SWIG_1 */
    public static final native long m1092xa0595bea(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, long j2, PageKey pageKey, int i);

    public static final native byte[] SearchController_SearchDMSFileSystem_pageTitle(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, long j2, PageKey pageKey);

    public static final native long SearchController_SearchDMSFileSystem_pages(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, long j2, PageKey pageKey);

    public static final native long SearchController_SearchDMSFileSystem_parentContainer(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, long j2, PageKey pageKey);

    public static final native boolean SearchController_SearchDMSFileSystem_parentIsContainer(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem, long j2, PageKey pageKey);

    public static final native byte[] SearchController_SearchDMSFileSystem_rootEntry(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem);

    public static final native boolean SearchController_SearchDMSFileSystem_valid(long j, SearchController.SearchDMSFileSystem searchDMSFileSystem);

    public static final native long SearchController_SearchDMSInterface_collectionKeyFromEntry(long j, SearchController.SearchDMSInterface searchDMSInterface, byte[] bArr);

    public static final native long SearchController_SearchDMSInterface_collectionKeyFromNotebookKey(long j, SearchController.SearchDMSInterface searchDMSInterface, long j2, NotebookKey notebookKey);

    public static final native long SearchController_SearchDMSInterface_collections(long j, SearchController.SearchDMSInterface searchDMSInterface);

    public static final native long SearchController_SearchDMSInterface_notebookKeyFromEntry(long j, SearchController.SearchDMSInterface searchDMSInterface, byte[] bArr);

    public static final native long SearchController_SearchDMSInterface_notebookKeyFromPageKey(long j, SearchController.SearchDMSInterface searchDMSInterface, long j2, PageKey pageKey);

    public static final native long SearchController_SearchDMSInterface_notebooks(long j, SearchController.SearchDMSInterface searchDMSInterface, byte[] bArr);

    public static final native long SearchController_SearchDMSInterface_openPage(long j, SearchController.SearchDMSInterface searchDMSInterface, long j2, PageKey pageKey);

    public static final native int SearchController_SearchDMSInterface_pageCount__SWIG_0(long j, SearchController.SearchDMSInterface searchDMSInterface, long j2, NotebookKey notebookKey);

    public static final native int SearchController_SearchDMSInterface_pageCount__SWIG_1(long j, SearchController.SearchDMSInterface searchDMSInterface, long j2, PageKey pageKey);

    public static final native boolean SearchController_SearchDMSInterface_pageIsContainer(long j, SearchController.SearchDMSInterface searchDMSInterface, long j2, PageKey pageKey);

    public static final native long SearchController_SearchDMSInterface_pageKeyFromEntry(long j, SearchController.SearchDMSInterface searchDMSInterface, byte[] bArr);

    public static final native long SearchController_SearchDMSInterface_pageKeyFromPageIndex__SWIG_0(long j, SearchController.SearchDMSInterface searchDMSInterface, long j2, NotebookKey notebookKey, int i);

    public static final native long SearchController_SearchDMSInterface_pageKeyFromPageIndex__SWIG_1(long j, SearchController.SearchDMSInterface searchDMSInterface, long j2, PageKey pageKey, int i);

    public static final native byte[] SearchController_SearchDMSInterface_pageTitle(long j, SearchController.SearchDMSInterface searchDMSInterface, long j2, PageKey pageKey);

    public static final native long SearchController_SearchDMSInterface_pages(long j, SearchController.SearchDMSInterface searchDMSInterface, long j2, PageKey pageKey);

    public static final native long SearchController_SearchDMSInterface_parentContainer(long j, SearchController.SearchDMSInterface searchDMSInterface, long j2, PageKey pageKey);

    public static final native boolean SearchController_SearchDMSInterface_parentIsContainer(long j, SearchController.SearchDMSInterface searchDMSInterface, long j2, PageKey pageKey);

    public static final native byte[] SearchController_SearchDMSInterface_rootEntry(long j, SearchController.SearchDMSInterface searchDMSInterface);

    public static final native boolean SearchController_SearchDMSInterface_valid(long j, SearchController.SearchDMSInterface searchDMSInterface);

    public static final native boolean SearchController_active(long j, SearchController searchController);

    public static final native void SearchController_clearSearchWorkers(long j, SearchController searchController);

    public static final native int SearchController_cumulativeNumberOfHits(long j, SearchController searchController);

    public static final native long SearchController_currentPageKey(long j, SearchController searchController);

    public static final native int SearchController_currentSearchMatchColorIndex(long j, SearchController searchController);

    public static final native void SearchController_enableSearchInNotebooksFeatureFlag(long j, SearchController searchController, boolean z);

    public static final native void SearchController_init(long j, SearchController searchController);

    public static final native void SearchController_interruptSearch(long j, SearchController searchController);

    public static final native boolean SearchController_isEnabledSearchInNotebooksFeatureFlag(long j, SearchController searchController);

    public static final native int SearchController_notificationFlag(long j, SearchController searchController);

    public static final native int SearchController_numberOfCollectionHits(long j, SearchController searchController);

    public static final native int SearchController_numberOfCollectionsForSearch(long j, SearchController searchController);

    public static final native int SearchController_numberOfDocumentHits(long j, SearchController searchController);

    public static final native int SearchController_numberOfDocumentHitsInCollection(long j, SearchController searchController, long j2, CollectionKey collectionKey);

    public static final native int SearchController_numberOfDocumentsForSearch(long j, SearchController searchController, long j2, CollectionKey collectionKey);

    public static final native int SearchController_numberOfHitsInCollection(long j, SearchController searchController, long j2, CollectionKey collectionKey);

    public static final native int SearchController_numberOfHitsInDocument(long j, SearchController searchController, long j2, NotebookKey notebookKey);

    public static final native int SearchController_numberOfHitsInPage__SWIG_0(long j, SearchController searchController, long j2, NotebookKey notebookKey, long j3, PageKey pageKey);

    public static final native int SearchController_numberOfHitsInPage__SWIG_1(long j, SearchController searchController, long j2, PageKey pageKey);

    public static final native int SearchController_numberOfPageHitsInDocument(long j, SearchController searchController, long j2, NotebookKey notebookKey);

    public static final native void SearchController_registerSearchListener(long j, SearchController searchController, ISearchListener iSearchListener);

    public static final native void SearchController_removeCollectionForSearch(long j, SearchController searchController, long j2, CollectionKey collectionKey);

    public static final native void SearchController_removeDocumentForSearch__SWIG_0(long j, SearchController searchController, long j2, CollectionKey collectionKey, long j3, NotebookKey notebookKey);

    public static final native void SearchController_removeDocumentForSearch__SWIG_1(long j, SearchController searchController, long j2, NotebookKey notebookKey);

    public static final native void SearchController_removeResultInPage__SWIG_0(long j, SearchController searchController, long j2, CollectionKey collectionKey, long j3, NotebookKey notebookKey, long j4, PageKey pageKey);

    public static final native void SearchController_removeResultInPage__SWIG_1(long j, SearchController searchController, long j2, PageKey pageKey);

    public static final native long SearchController_retrieveDeserializedSearchResults__SWIG_0(long j, SearchController searchController, long j2, NotebookKey notebookKey, long j3, PageKey pageKey);

    public static final native long SearchController_retrieveDeserializedSearchResults__SWIG_1(long j, SearchController searchController, long j2, PageKey pageKey);

    public static final native long SearchController_retrieveSerializedResults__SWIG_0(long j, SearchController searchController, long j2, NotebookKey notebookKey, long j3, PageKey pageKey);

    public static final native long SearchController_retrieveSerializedResults__SWIG_1(long j, SearchController searchController, long j2, PageKey pageKey);

    public static final native long SearchController_searchDMSInterface(long j, SearchController searchController);

    public static final native long SearchController_searchHelper(long j, SearchController searchController);

    public static final native byte[] SearchController_searchPage(long j, SearchController searchController, byte[] bArr, long j2, PageKey pageKey);

    public static final native void SearchController_setCurrentPageKey(long j, SearchController searchController, long j2, PageKey pageKey);

    public static final native void SearchController_setCurrentSearchMatchColorIndex(long j, SearchController searchController, int i);

    public static final native void SearchController_setGrid(long j, SearchController searchController, long j2, LayoutGrid layoutGrid);

    public static final native void SearchController_setPriorityCollections(long j, SearchController searchController, long j2, SWIGVectorCollectionKey sWIGVectorCollectionKey);

    public static final native void SearchController_setPriorityNotebooks(long j, SearchController searchController, long j2, SWIGVectorNotebookKey sWIGVectorNotebookKey);

    public static final native byte[] SearchController_startSearch(long j, SearchController searchController, byte[] bArr);

    public static final native void SearchController_stopSearch(long j, SearchController searchController);

    public static final native void SearchController_unregisterSearchListener(long j, SearchController searchController, ISearchListener iSearchListener);

    public static final native long SearchController_updateSearchResultWithMatch(long j, SearchController searchController, long j2, CollectionKey collectionKey, long j3, NotebookKey notebookKey, long j4, PageKey pageKey, long j5, Page page, byte[] bArr, long j6);

    public static final native void SearchController_waitEnd(long j, SearchController searchController);

    public static final native int SearchMatchParser_PDF_SEARCH_HIT_TOKENS_SIZE_get(long j, SearchMatchParser searchMatchParser);

    public static final native int SearchMatchParser_TEXT_SEARCH_HIT_TOKENS_SIZE_get(long j, SearchMatchParser searchMatchParser);

    public static final native long SearchMatchParser_extent(long j, SearchMatchParser searchMatchParser, long j2, Page page);

    public static final native boolean SearchMatchParser_hasExtent(long j, SearchMatchParser searchMatchParser);

    public static final native byte[] SearchMatchParser_identification(long j, SearchMatchParser searchMatchParser);

    public static final native long SearchMatchParser_interval(long j, SearchMatchParser searchMatchParser);

    public static final native long SearchMatch_extents_get(long j, SearchMatch searchMatch);

    public static final native void SearchMatch_extents_set(long j, SearchMatch searchMatch, long j2, SWIGVectorExtent sWIGVectorExtent);

    public static final native byte[] SearchMatch_pageUUID_get(long j, SearchMatch searchMatch);

    public static final native void SearchMatch_pageUUID_set(long j, SearchMatch searchMatch, byte[] bArr);

    public static final native long SearchQuery_emptyQuery();

    public static final native long SearchQuery_pageKey(long j, SearchQuery searchQuery);

    public static final native byte[] SearchQuery_pattern(long j, SearchQuery searchQuery);

    public static final native int SearchQuery_type(long j, SearchQuery searchQuery);

    public static final native long SingleColumnGridFactoryStrategy_SWIGSmartPtrUpcast(long j);

    public static final native float SingleColumnGridFactoryStrategy_columnGutter(long j, SingleColumnGridFactoryStrategy singleColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native boolean SingleColumnGridFactoryStrategy_compact(long j, SingleColumnGridFactoryStrategy singleColumnGridFactoryStrategy, int i, float f, float f2, float f3);

    public static final native int SingleColumnGridFactoryStrategy_getColumnCount(long j, SingleColumnGridFactoryStrategy singleColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float SingleColumnGridFactoryStrategy_getLeftMargin(long j, SingleColumnGridFactoryStrategy singleColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float SingleColumnGridFactoryStrategy_getRightMargin(long j, SingleColumnGridFactoryStrategy singleColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float SingleColumnGridFactoryStrategy_getTopMargin(long j, SingleColumnGridFactoryStrategy singleColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float SingleColumnGridFactoryStrategy_left(long j, SingleColumnGridFactoryStrategy singleColumnGridFactoryStrategy, float f, float f2, float f3);

    public static final native float SingleColumnGridFactoryStrategy_width(long j, SingleColumnGridFactoryStrategy singleColumnGridFactoryStrategy, float f, float f2, float f3);

    /* JADX INFO: renamed from: SingleColumnWithoutTopMarginGridFactoryStrategy_SWIGSmartPtrUpcast */
    public static final native long m1093xeb0a99e2(long j);

    public static final native float SingleColumnWithoutTopMarginGridFactoryStrategy_getTopMargin(long j, SingleColumnWithoutTopMarginGridFactoryStrategy singleColumnWithoutTopMarginGridFactoryStrategy, float f, float f2, float f3);

    public static final native void SmartGuideManager_clearSmartGuideIfCurrentBoxIsRemoved(long j, SmartGuideManager smartGuideManager);

    public static final native void SmartGuideManager_clearSmartGuide__SWIG_0(long j, SmartGuideManager smartGuideManager);

    public static final native void SmartGuideManager_clearSmartGuide__SWIG_1(long j, SmartGuideManager smartGuideManager, byte[] bArr);

    public static final native void SmartGuideManager_enableFullBlock(long j, SmartGuideManager smartGuideManager, boolean z);

    public static final native long SmartGuideManager_getSmartGuideComponent(long j, SmartGuideManager smartGuideManager);

    public static final native void SmartGuideManager_hide(long j, SmartGuideManager smartGuideManager, boolean z);

    public static final native boolean SmartGuideManager_isBoxExistForPrompterId(long j, SmartGuideManager smartGuideManager, byte[] bArr);

    public static final native boolean SmartGuideManager_isSmartGuideVisible(long j, SmartGuideManager smartGuideManager);

    public static final native long SmartGuideManager_newRef(long j, SmartGuideManager smartGuideManager);

    public static final native void SmartGuideManager_reflowGridChanged(long j, SmartGuideManager smartGuideManager, long j2, LayoutGrid layoutGrid);

    public static final native void SmartGuideManager_reflowRollback(long j, SmartGuideManager smartGuideManager, boolean z);

    public static final native void SmartGuideManager_setSearchController(long j, SmartGuideManager smartGuideManager, long j2, SearchController searchController);

    public static final native void SmartGuideManager_setSettingsShowConversionPreview(long j, SmartGuideManager smartGuideManager, boolean z);

    public static final native void SmartGuideManager_setSmartGuideComponent(long j, SmartGuideManager smartGuideManager, long j2, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideManager_setSmartGuideComponentListener(long j, SmartGuideManager smartGuideManager, ISmartGuideComponentListener iSmartGuideComponentListener);

    public static final native void SmartGuideManager_setStartWritingOnPrompter(long j, SmartGuideManager smartGuideManager, boolean z);

    public static final native boolean SmartGuideManager_settingsShowConversionPreview(long j, SmartGuideManager smartGuideManager);

    public static final native boolean SmartGuideManager_startWritingOnPrompter(long j, SmartGuideManager smartGuideManager);

    public static final native boolean StandalonePageControllerProvider_clear(long j, StandalonePageControllerProvider standalonePageControllerProvider);

    public static final native long StandalonePageControllerProvider_pageController__SWIG_0(long j, StandalonePageControllerProvider standalonePageControllerProvider, byte[] bArr, long j2, DisplayContext displayContext, long j3, RecoContext recoContext, byte[] bArr2, byte[] bArr3);

    public static final native long StandalonePageControllerProvider_pageController__SWIG_1(long j, StandalonePageControllerProvider standalonePageControllerProvider, byte[] bArr, long j2, DisplayContext displayContext, long j3, RecoContext recoContext, byte[] bArr2);

    public static final native long StandalonePageControllerProvider_pageController__SWIG_2(long j, StandalonePageControllerProvider standalonePageControllerProvider, byte[] bArr, long j2, DisplayContext displayContext, long j3, RecoContext recoContext);

    public static final native boolean StandalonePageControllerProvider_save(long j, StandalonePageControllerProvider standalonePageControllerProvider);

    public static final native byte[] StyleUtils_BIG_TYPESET_STYLE_NAME_get();

    public static final native byte[] StyleUtils_BRUSH_ORIENTED_STYLE_NAME_get();

    public static final native byte[] StyleUtils_BRUSH_STYLE_NAME_get();

    public static final native byte[] StyleUtils_ERASER_PEN_STYLE_NAME_get();

    public static final native byte[] StyleUtils_GUIDE_COLOR_DARK_get();

    public static final native byte[] StyleUtils_GUIDE_COLOR_get();

    public static final native byte[] StyleUtils_GUIDE_DASH_STYLE_NAME_get();

    public static final native byte[] StyleUtils_GUIDE_STYLE_NAME_get();

    public static final native byte[] StyleUtils_INK_RUBBER_STYLE_NAME_get();

    public static final native int StyleUtils_PROPERTY_FONTSIZE_get();

    public static final native int StyleUtils_PROPERTY_LINEGAP_get();

    public static final native int StyleUtils_PROPERTY_MASKING_BOTTOM_get();

    public static final native int StyleUtils_PROPERTY_MASKING_TOP_get();

    public static final native int StyleUtils_PROPERTY_PADDING_BOTTOM_get();

    public static final native int StyleUtils_PROPERTY_PADDING_TOP_get();

    public static final native byte[] StyleUtils_SEARCH_STYLE_ACTIVE_get();

    public static final native byte[] StyleUtils_SEARCH_STYLE_INACTIVE_get();

    public static final native byte[] StyleUtils_SMALL_TYPESET_STYLE_NAME_get();

    public static final native byte[] StyleUtils_SPACE_MANAGEMENT_STYLE_LINE_get();

    public static final native byte[] StyleUtils_TRANSPARENT_INK_STYLE_NAME_get();

    public static final native int StyleUtils_TYPE_2D_get();

    public static final native int StyleUtils_TYPE_HANDWRITING_get();

    public static final native int StyleUtils_TYPE_TYPESET_BIG_get();

    public static final native int StyleUtils_TYPE_TYPESET_H1_get();

    public static final native int StyleUtils_TYPE_TYPESET_H2_get();

    public static final native int StyleUtils_TYPE_TYPESET_H3_get();

    public static final native int StyleUtils_TYPE_TYPESET_SMALL_get();

    public static final native float StyleUtils_defaultFontSize();

    public static final native float StyleUtils_defaultLineGapMM__SWIG_0(long j, ViewTransform viewTransform, ITypesetListener iTypesetListener, float f);

    public static final native float StyleUtils_defaultLineGapMM__SWIG_1(long j, ViewTransform viewTransform, ITypesetListener iTypesetListener);

    public static final native float StyleUtils_defaultLineGapMM__SWIG_2(float f, ITypesetListener iTypesetListener, float f2);

    public static final native float StyleUtils_defaultLineGapMM__SWIG_3(float f, ITypesetListener iTypesetListener);

    public static final native float StyleUtils_defaultLineHeight();

    public static final native byte[] StyleUtils_defaultStyle__SWIG_0(long j, LayoutGrid.StyleProperties styleProperties, boolean z);

    public static final native byte[] StyleUtils_defaultStyle__SWIG_1(long j, LayoutGrid.StyleProperties styleProperties);

    public static final native float StyleUtils_diagramLineGapMM(long j, LayoutGrid.StyleProperties styleProperties);

    public static final native byte[] StyleUtils_fontName();

    public static final native byte[] StyleUtils_getOverallStyleName(int i);

    public static final native float StyleUtils_getValue(int i, int i2, long j, LayoutGrid.StyleProperties styleProperties);

    public static final native float StyleUtils_lineGapMM__SWIG_0(long j, ViewTransform viewTransform, ITypesetListener iTypesetListener, long j2, LayoutGrid.StyleProperties styleProperties, float f);

    public static final native float StyleUtils_lineGapMM__SWIG_1(long j, ViewTransform viewTransform, ITypesetListener iTypesetListener, long j2, LayoutGrid.StyleProperties styleProperties);

    public static final native float StyleUtils_lineGapMM__SWIG_2(float f, ITypesetListener iTypesetListener, long j, LayoutGrid.StyleProperties styleProperties, float f2);

    public static final native float StyleUtils_lineGapMM__SWIG_3(float f, ITypesetListener iTypesetListener, long j, LayoutGrid.StyleProperties styleProperties);

    public static final native int StyleUtils_type(long j, long j2);

    public static final native String TOOL_PROPERTY_BRUSH_CLEAR_DEFAULT_get();

    public static final native String TOOL_PROPERTY_BRUSH_CLEAR_FALSE_get();

    public static final native String TOOL_PROPERTY_BRUSH_CLEAR_TRUE_get();

    public static final native String TOOL_PROPERTY_BRUSH_CLEAR_get();

    public static final native String TOOL_PROPERTY_BRUSH_FEEDBACK_COLOR_get();

    public static final native String TOOL_PROPERTY_BRUSH_POLICY_DRAWINGS_get();

    public static final native String TOOL_PROPERTY_BRUSH_POLICY_SEMANTIC_get();

    public static final native String TOOL_PROPERTY_BRUSH_POLICY_get();

    public static final native String TOOL_PROPERTY_COLOR_get();

    public static final native String TOOL_PROPERTY_ERASER_DYNAMIC_RADIUS_DEFAULT_get();

    public static final native String TOOL_PROPERTY_ERASER_DYNAMIC_RADIUS_FALSE_get();

    public static final native String TOOL_PROPERTY_ERASER_DYNAMIC_RADIUS_TRUE_get();

    public static final native String TOOL_PROPERTY_ERASER_DYNAMIC_RADIUS_get();

    public static final native String TOOL_PROPERTY_ERASER_POLICY_DEFAULT_get();

    public static final native String TOOL_PROPERTY_ERASER_POLICY_PRECISE_get();

    public static final native String TOOL_PROPERTY_ERASER_POLICY_STROKE_get();

    public static final native String TOOL_PROPERTY_ERASER_POLICY_get();

    public static final native String TOOL_PROPERTY_ERASER_RADIUS_get();

    public static final native String TOOL_PROPERTY_ERASER_SHOW_DEFAULT_get();

    public static final native String TOOL_PROPERTY_ERASER_SHOW_FALSE_get();

    public static final native String TOOL_PROPERTY_ERASER_SHOW_TRUE_get();

    public static final native String TOOL_PROPERTY_ERASER_SHOW_get();

    public static final native String TOOL_PROPERTY_LASSO_SHAPE_DEFAULT_get();

    public static final native String TOOL_PROPERTY_LASSO_SHAPE_POLYGON_get();

    public static final native String TOOL_PROPERTY_LASSO_SHAPE_RECTANGLE_get();

    public static final native String TOOL_PROPERTY_LASSO_SHAPE_get();

    public static final native String TOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC_BRUSH_get();

    public static final native String TOOL_PROPERTY_PEN_STROKER_CALLIGRAPHIC_QUILL_get();

    public static final native String TOOL_PROPERTY_PEN_STROKER_DEFAULT_get();

    public static final native String TOOL_PROPERTY_PEN_STROKER_FELT_get();

    public static final native String TOOL_PROPERTY_PEN_STROKER_FOUNTAIN_PEN_get();

    public static final native String TOOL_PROPERTY_PEN_STROKER_QALAM_get();

    public static final native String TOOL_PROPERTY_PEN_STROKER_get();

    public static final native String TOOL_PROPERTY_PRESSURE_SENSITIVITY_get();

    public static final native String TOOL_PROPERTY_THICKNESS_RATIO_get();

    public static final native byte[] TextBox_ATTR_LIST_LINE_FROM_get();

    public static final native byte[] TextBox_ATTR_LIST_LINE_TO_get();

    public static final native byte[] TextBox_ATTR_SHOULD_REFLOW_PIVOT_STOP_get();

    public static final native byte[] TextBox_ATTR_SHOULD_REFLOW_PIVOT_get();

    public static final native byte[] TextBox_ATTR_TEXTBOX_STYLE_get();

    public static final native byte[] TextBox_ATTR_TEXTBOX_TYPE_get();

    public static final native byte[] TextBox_ATTR_TEXTBOX_USECACHE_get();

    public static final native byte[] TextBox_ATTR_TEXT_ALIGNMENT_get();

    public static final native long TextBox_SWIGSmartPtrUpcast(long j);

    public static final native byte[] TextBox_TYPE_get();

    public static final native long TextBox_asTextBox2(long j, GridBox gridBox);

    public static final native boolean TextBox_check(long j, TextBox textBox, long j2, LayoutGrid layoutGrid);

    public static final native long TextBox_computeExtent__SWIG_0(long j, TextBox textBox, long j2, LayoutGrid layoutGrid);

    public static final native long TextBox_computeExtent__SWIG_1(long j, TextBox textBox, long j2, LayoutGrid layoutGrid, long j3, Selection selection);

    public static final native long TextBox_computePaddingTopBottom(long j, LayoutGrid layoutGrid, float f, int i);

    public static final native String TextBox_contentField(long j, TextBox textBox);

    public static final native byte[] TextBox_contentFieldId(long j, TextBox textBox);

    public static final native boolean TextBox_empty(long j, TextBox textBox);

    public static final native long TextBox_extentWithStrokes__SWIG_0(long j, TextBox textBox, long j2, LayoutGrid layoutGrid);

    public static final native long TextBox_extentWithStrokes__SWIG_1(long j, TextBox textBox, long j2, LayoutGrid layoutGrid, long j3, Selection selection);

    public static final native float TextBox_firstLine(long j, TextBox textBox);

    public static final native boolean TextBox_fitTo(long j, TextBox textBox, long j2, Extent extent, long j3, LayoutGrid layoutGrid, long j4);

    public static final native float TextBox_fontDescender(long j, TextBox textBox);

    public static final native float TextBox_fontSize(long j, TextBox textBox, long j2, LayoutGrid layoutGrid);

    public static final native byte[] TextBox_getLabel__SWIG_0(long j, TextBox textBox);

    public static final native byte[] TextBox_getType(long j, TextBox textBox);

    public static final native boolean TextBox_hasValidContent(long j, TextBox textBox);

    public static final native boolean TextBox_isProcessPending(long j, TextBox textBox);

    public static final native boolean TextBox_isProcessPendingOrRequired(long j, TextBox textBox);

    public static final native boolean TextBox_isProcessRequired(long j, TextBox textBox);

    public static final native float TextBox_lastLine(long j, TextBox textBox);

    public static final native float TextBox_lineGap(long j, TextBox textBox, long j2, LayoutGrid layoutGrid);

    public static final native int TextBox_minWidthColumn(long j, TextBox textBox, long j2, LayoutGrid layoutGrid);

    public static final native void TextBox_move(long j, TextBox textBox, float f, float f2);

    public static final native void TextBox_process(long j, TextBox textBox);

    public static final native long TextBox_reflowContext(long j, TextBox textBox);

    public static final native void TextBox_remove(long j, TextBox textBox);

    public static final native int TextBox_removeEmptyLines(long j, TextBox textBox, long j2, LayoutGrid layoutGrid);

    public static final native long TextBox_selection(long j, TextBox textBox);

    public static final native void TextBox_setFontDescender(long j, TextBox textBox, float f);

    public static final native void TextBox_setShouldReflow__SWIG_0(long j, TextBox textBox, int i, int i2);

    public static final native void TextBox_setShouldReflow__SWIG_1(long j, TextBox textBox, int i);

    public static final native void TextBox_setShouldReflow__SWIG_2(long j, TextBox textBox);

    public static final native void TextBox_setTextAlignment(long j, TextBox textBox, long j2);

    public static final native void TextBox_setTextBoxStyle(long j, TextBox textBox, long j2);

    public static final native void TextBox_setTextBoxType(long j, TextBox textBox, long j2);

    public static final native long TextBox_textAlignment(long j, TextBox textBox);

    public static final native long TextBox_textBoxStyle(long j, TextBox textBox);

    public static final native int TextBox_textBoxStyleType(long j, TextBox textBox);

    public static final native long TextBox_textBoxTag(long j, TextBox textBox, long j2, LayoutGrid layoutGrid);

    public static final native int TextBox_textBoxTagType(long j, LayoutGrid layoutGrid, long j2, TextBox textBox);

    public static final native long TextBox_textBoxType(long j, TextBox textBox);

    public static final native byte[] TextBox_toString(long j, TextBox textBox);

    public static final native void TextBox_transform(long j, TextBox textBox, long j2, Transform transform, long j3, LayoutGrid.StyleProperties styleProperties, boolean z, float f);

    public static final native long TextBox_typesetSettings(long j, TextBox textBox, long j2);

    public static final native void TextBox_updateExtent__SWIG_0(long j, TextBox textBox, long j2, LayoutGrid layoutGrid);

    public static final native void TextBox_updateExtent__SWIG_1(long j, TextBox textBox, long j2, LayoutGrid layoutGrid, float f, float f2);

    public static final native void TextBox_updateSelection(long j, TextBox textBox);

    public static final native void TextBox_updateTextStructureIndentations(long j, TextBox textBox, long j2, LayoutGrid layoutGrid, boolean z);

    public static final native byte[] TextSelectionWithContext_context_get(long j, TextSelectionWithContext textSelectionWithContext);

    public static final native void TextSelectionWithContext_context_set(long j, TextSelectionWithContext textSelectionWithContext, byte[] bArr);

    public static final native byte[] TextSelectionWithContext_selectedText_get(long j, TextSelectionWithContext textSelectionWithContext);

    public static final native void TextSelectionWithContext_selectedText_set(long j, TextSelectionWithContext textSelectionWithContext, byte[] bArr);

    public static final native long ThumbnailConfiguration_colorInversionPolicy_get(long j, ThumbnailConfiguration thumbnailConfiguration);

    public static final native void ThumbnailConfiguration_colorInversionPolicy_set(long j, ThumbnailConfiguration thumbnailConfiguration, long j2);

    public static final native byte[] ThumbnailConfiguration_fileExtension_get(long j, ThumbnailConfiguration thumbnailConfiguration);

    public static final native void ThumbnailConfiguration_fileExtension_set(long j, ThumbnailConfiguration thumbnailConfiguration, byte[] bArr);

    public static final native float ThumbnailConfiguration_height_get(long j, ThumbnailConfiguration thumbnailConfiguration);

    public static final native void ThumbnailConfiguration_height_set(long j, ThumbnailConfiguration thumbnailConfiguration, float f);

    public static final native float ThumbnailConfiguration_width_get(long j, ThumbnailConfiguration thumbnailConfiguration);

    public static final native void ThumbnailConfiguration_width_set(long j, ThumbnailConfiguration thumbnailConfiguration, float f);

    public static final native void Thumbnailer_addThumbnailNotificationListener(long j, Thumbnailer thumbnailer, IThumbnailerNotificationListener iThumbnailerNotificationListener);

    public static final native long Thumbnailer_newRef(long j, Thumbnailer thumbnailer);

    public static final native void Thumbnailer_notifyDrawThumbnailFailed(long j, Thumbnailer thumbnailer, long j2, PageKey pageKey, byte[] bArr);

    public static final native void Thumbnailer_removeThumbnailNotificationListener(long j, Thumbnailer thumbnailer, IThumbnailerNotificationListener iThumbnailerNotificationListener);

    public static final native void Thumbnailer_restart(long j, Thumbnailer thumbnailer);

    public static final native void Thumbnailer_setThumbnailImageResquester(long j, Thumbnailer thumbnailer, IThumbnailerImageRequester iThumbnailerImageRequester);

    public static final native void Thumbnailer_stop(long j, Thumbnailer thumbnailer);

    public static final native long ToolConfiguration_SWIGUpcast(long j);

    public static final native int ToolConfiguration_hashCode(long j, ToolConfiguration toolConfiguration);

    public static final native boolean ToolConfiguration_nativeEquals(long j, ToolConfiguration toolConfiguration, long j2, ToolConfiguration toolConfiguration2);

    public static final native int ToolConfiguration_state_get(long j, ToolConfiguration toolConfiguration);

    public static final native void ToolConfiguration_state_set(long j, ToolConfiguration toolConfiguration, int i);

    public static final native byte[] ToolConfiguration_toString(long j, ToolConfiguration toolConfiguration);

    public static final native byte[] ToolConfiguration_to_string(long j, ToolConfiguration toolConfiguration);

    public static final native int ToolConfiguration_type_get(long j, ToolConfiguration toolConfiguration);

    public static final native void ToolConfiguration_type_set(long j, ToolConfiguration toolConfiguration, int i);

    public static final native int ToolProperty_getColor2(long j, ToolProperty toolProperty);

    public static final native float ToolProperty_getPressureSensitivity(long j, ToolProperty toolProperty);

    public static final native byte[] ToolProperty_getProperty(long j, ToolProperty toolProperty, byte[] bArr);

    public static final native float ToolProperty_getThicknessRatio(long j, ToolProperty toolProperty);

    public static final native long ToolProperty_properties_get(long j, ToolProperty toolProperty);

    public static final native void ToolProperty_properties_set(long j, ToolProperty toolProperty, long j2);

    public static final native void ToolProperty_setColor(long j, ToolProperty toolProperty, int i);

    public static final native void ToolProperty_setPressureSensitivity(long j, ToolProperty toolProperty, float f);

    public static final native void ToolProperty_setProperty(long j, ToolProperty toolProperty, byte[] bArr, byte[] bArr2);

    public static final native void ToolProperty_setThicknessRatio(long j, ToolProperty toolProperty, float f);

    public static final native byte[] ToolType_to_string(int i);

    public static final native long ToolbarConfiguration_availableTools_get(long j, ToolbarConfiguration toolbarConfiguration);

    public static final native void ToolbarConfiguration_availableTools_set(long j, ToolbarConfiguration toolbarConfiguration, long j2, SWIGVectorToolConfiguration sWIGVectorToolConfiguration);

    public static final native byte[] ToolbarConfiguration_contentType_get(long j, ToolbarConfiguration toolbarConfiguration);

    public static final native void ToolbarConfiguration_contentType_set(long j, ToolbarConfiguration toolbarConfiguration, byte[] bArr);

    public static final native int ToolbarConfiguration_getSelectedToolType(long j, ToolbarConfiguration toolbarConfiguration);

    public static final native int ToolbarConfiguration_hashCode(long j, ToolbarConfiguration toolbarConfiguration);

    public static final native boolean ToolbarConfiguration_isPaused(long j, ToolbarConfiguration toolbarConfiguration);

    public static final native boolean ToolbarConfiguration_nativeEquals(long j, ToolbarConfiguration toolbarConfiguration, long j2, ToolbarConfiguration toolbarConfiguration2);

    public static final native int ToolbarConfiguration_selectedColor_get(long j, ToolbarConfiguration toolbarConfiguration);

    public static final native void ToolbarConfiguration_selectedColor_set(long j, ToolbarConfiguration toolbarConfiguration, int i);

    public static final native byte[] ToolbarConfiguration_toString(long j, ToolbarConfiguration toolbarConfiguration);

    public static final native byte[] ToolbarConfiguration_to_string(long j, ToolbarConfiguration toolbarConfiguration);

    public static final native void ToolbarController_applyToolConfiguration(long j, ToolbarController toolbarController, long j2, ToolConfiguration toolConfiguration);

    public static final native long ToolbarController_currentTool(long j, ToolbarController toolbarController);

    public static final native int ToolbarController_defaultToolType(long j, ToolbarController toolbarController);

    public static final native void ToolbarController_enableActivePen(long j, ToolbarController toolbarController, boolean z);

    public static final native long ToolbarController_getDefaultToolbarConfiguration__SWIG_0(byte[] bArr, boolean z, long j, ToolConfiguration toolConfiguration, boolean z2, boolean z3);

    public static final native long ToolbarController_getDefaultToolbarConfiguration__SWIG_1(byte[] bArr, boolean z, long j, ToolConfiguration toolConfiguration, boolean z2);

    public static final native long ToolbarController_getDefaultToolbarConfiguration__SWIG_2(byte[] bArr, boolean z, long j, ToolConfiguration toolConfiguration);

    public static final native long ToolbarController_getToolbarConfiguration(long j, ToolbarController toolbarController);

    public static final native boolean ToolbarController_isActivePenModeEnabled(long j, ToolbarController toolbarController);

    public static final native void ToolbarController_selectToolKind(long j, ToolbarController toolbarController, long j2);

    public static final native void ToolbarController_setColor(long j, ToolbarController toolbarController, int i);

    public static final native void ToolbarController_setCurrentTool(long j, ToolbarController toolbarController, long j2);

    public static final native void ToolbarController_setPaused(long j, ToolbarController toolbarController, boolean z);

    public static final native void ToolbarController_setPressureSensitivity(long j, ToolbarController toolbarController, float f);

    public static final native void ToolbarController_setReadOnly(long j, ToolbarController toolbarController, boolean z);

    public static final native void ToolbarController_setThicknessRatio(long j, ToolbarController toolbarController, float f);

    public static final native void ToolbarController_setTool(long j, ToolbarController toolbarController, int i);

    public static final native long ToolbarController_toolConfiguration(long j, ToolbarController toolbarController, int i);

    public static final native int ToolbarController_toolKindToToolType(long j);

    public static final native long ToolbarController_toolTypeToToolKind(int i);

    public static final native void delete_ChildPageContainer(long j);

    public static final native void delete_ChildPageThumbnailGenerator(long j);

    public static final native void delete_CollectionKey(long j);

    public static final native void delete_CollectionKey_Hash(long j);

    public static final native void delete_CompositeBox(long j);

    public static final native void delete_DefaultDocumentControllerFactory(long j);

    public static final native void delete_DisplayContext(long j);

    public static final native void delete_DivisionBox(long j);

    public static final native void delete_DocumentController(long j);

    public static final native void delete_DocumentControllerListener(long j);

    public static final native void delete_EventListenerBroadcaster(long j);

    public static final native void delete_ExportController(long j);

    public static final native void delete_ExportOptions(long j);

    public static final native void delete_ExportPageLoader(long j);

    public static final native void delete_ExportPageModel(long j);

    public static final native void delete_FileTypeInspector(long j);

    public static final native void delete_FileUtils(long j);

    public static final native void delete_FullPageColumnGridFactoryStrategy(long j);

    public static final native void delete_GridBox(long j);

    public static final native void delete_IGridFactoryStrategy(long j);

    public static final native void delete_ImageParameter(long j);

    public static final native void delete_LanguageManager(long j);

    public static final native void delete_LayoutGrid(long j);

    public static final native void delete_LayoutGrid_StyleProperties(long j);

    public static final native void delete_ListItemInfo(long j);

    public static final native void delete_LocaleInfo(long j);

    public static final native void delete_MigrationAssistant(long j);

    public static final native void delete_MultiColumnGridFactoryStrategy(long j);

    public static final native void delete_NeboCustomTheme(long j);

    public static final native void delete_NeboExporter(long j);

    public static final native void delete_NeboSanitizer(long j);

    public static final native void delete_NeboSanitizer_SanitizerResult(long j);

    public static final native void delete_NotebookKey(long j);

    public static final native void delete_NotebookKey_Hash(long j);

    public static final native void delete_PageController(long j);

    public static final native void delete_PageControllerSanitized(long j);

    public static final native void delete_PageKey(long j);

    public static final native void delete_PageKey_Hash(long j);

    public static final native void delete_PaperSize(long j);

    public static final native void delete_QueryBuilder(long j);

    public static final native void delete_RecoContext(long j);

    public static final native void delete_ReflowOptions(long j);

    public static final native void delete_SWIGAngle(long j);

    public static final native void delete_SWIGOptionContext(long j);

    public static final native void delete_SWIGVectorCollectionKey(long j);

    public static final native void delete_SWIGVectorColors(long j);

    public static final native void delete_SWIGVectorImageParameter(long j);

    public static final native void delete_SWIGVectorLocaleInfo(long j);

    public static final native void delete_SWIGVectorNotebookKey(long j);

    public static final native void delete_SWIGVectorPageKey(long j);

    public static final native void delete_SWIGVectorSearchMatch(long j);

    public static final native void delete_SWIGVectorToolConfiguration(long j);

    public static final native void delete_ScrollBarBehavior(long j);

    public static final native void delete_SearchController(long j);

    public static final native void delete_SearchController_SearchDMSFileSystem(long j);

    public static final native void delete_SearchController_SearchDMSInterface(long j);

    public static final native void delete_SearchMatch(long j);

    public static final native void delete_SearchMatchParser(long j);

    public static final native void delete_SearchQuery(long j);

    public static final native void delete_SingleColumnGridFactoryStrategy(long j);

    public static final native void delete_SingleColumnWithoutTopMarginGridFactoryStrategy(long j);

    public static final native void delete_SmartGuideManager(long j);

    public static final native void delete_StandalonePageControllerProvider(long j);

    public static final native void delete_StyleUtils(long j);

    public static final native void delete_TextBox(long j);

    public static final native void delete_TextSelectionWithContext(long j);

    public static final native void delete_ThumbnailConfiguration(long j);

    public static final native void delete_Thumbnailer(long j);

    public static final native void delete_ToolConfiguration(long j);

    public static final native void delete_ToolProperty(long j);

    public static final native void delete_ToolbarConfiguration(long j);

    public static final native void delete_ToolbarController(long j);

    public static final native long new_CollectionKey_Hash();

    public static final native long new_CollectionKey__SWIG_0();

    public static final native long new_CollectionKey__SWIG_1(byte[] bArr);

    public static final native long new_CollectionKey__SWIG_2(long j, NotebookKey notebookKey);

    public static final native long new_CollectionKey__SWIG_3(long j, PageKey pageKey);

    public static final native long new_DefaultDocumentControllerFactory();

    public static final native long new_DisplayContext__SWIG_0(long j, ViewTransform viewTransform, boolean z, boolean z2, boolean z3, boolean z4, short s, boolean z5, boolean z6, boolean z7);

    public static final native long new_DisplayContext__SWIG_1(long j, ViewTransform viewTransform, boolean z, boolean z2, boolean z3, boolean z4, short s, boolean z5, boolean z6);

    public static final native long new_DisplayContext__SWIG_10(float f, float f2, boolean z, boolean z2, boolean z3, boolean z4, short s);

    public static final native long new_DisplayContext__SWIG_11(float f, float f2, boolean z, boolean z2, boolean z3, boolean z4);

    public static final native long new_DisplayContext__SWIG_12(float f, float f2, boolean z, boolean z2, boolean z3);

    public static final native long new_DisplayContext__SWIG_13(float f, float f2, boolean z, boolean z2);

    public static final native long new_DisplayContext__SWIG_14(float f, float f2, boolean z);

    public static final native long new_DisplayContext__SWIG_15(float f, float f2);

    public static final native long new_DisplayContext__SWIG_2(long j, ViewTransform viewTransform, boolean z, boolean z2, boolean z3, boolean z4, short s, boolean z5);

    public static final native long new_DisplayContext__SWIG_3(long j, ViewTransform viewTransform, boolean z, boolean z2, boolean z3, boolean z4, short s);

    public static final native long new_DisplayContext__SWIG_4(long j, ViewTransform viewTransform, boolean z, boolean z2, boolean z3, boolean z4);

    public static final native long new_DisplayContext__SWIG_5(long j, ViewTransform viewTransform, boolean z, boolean z2, boolean z3);

    public static final native long new_DisplayContext__SWIG_6(long j, ViewTransform viewTransform, boolean z, boolean z2);

    public static final native long new_DisplayContext__SWIG_7(long j, ViewTransform viewTransform, boolean z);

    public static final native long new_DisplayContext__SWIG_8(long j, ViewTransform viewTransform);

    public static final native long new_DisplayContext__SWIG_9(float f, float f2, boolean z, boolean z2, boolean z3, boolean z4, short s, boolean z5);

    public static final native long new_EventListenerBroadcaster();

    public static final native long new_ExportOptions();

    public static final native long new_ExportPageModel();

    public static final native long new_FileTypeInspector(long j, SWIGVectorString sWIGVectorString);

    public static final native long new_FileUtils();

    public static final native long new_FullPageColumnGridFactoryStrategy();

    public static final native long new_ImageParameter();

    public static final native long new_LanguageManager__SWIG_0(long j);

    public static final native long new_LanguageManager__SWIG_1(long j, SWIGVectorString sWIGVectorString);

    public static final native long new_LayoutGrid();

    public static final native long new_LayoutGrid_StyleProperties();

    public static final native long new_ListItemInfo__SWIG_0(byte[] bArr, int i, float f, float f2, int i2, byte[] bArr2);

    public static final native long new_ListItemInfo__SWIG_1();

    public static final native long new_LocaleInfo();

    public static final native long new_MigrationAssistant(byte[] bArr, long j, SWIGVectorString sWIGVectorString, ITypesetListener iTypesetListener, byte[] bArr2);

    public static final native long new_MultiColumnGridFactoryStrategy();

    public static final native long new_NeboCustomTheme();

    public static final native long new_NeboSanitizer();

    public static final native long new_NeboSanitizer_SanitizerResult();

    public static final native long new_NotebookKey_Hash();

    public static final native long new_NotebookKey__SWIG_0();

    public static final native long new_NotebookKey__SWIG_1(byte[] bArr);

    public static final native long new_NotebookKey__SWIG_2(long j, PageKey pageKey);

    public static final native long new_NotebookKey__SWIG_3(long j, CollectionKey collectionKey, byte[] bArr);

    public static final native long new_PageControllerSanitized();

    public static final native long new_PageKey_Hash();

    public static final native long new_PageKey__SWIG_0();

    public static final native long new_PageKey__SWIG_1(byte[] bArr, byte[] bArr2);

    public static final native long new_PageKey__SWIG_2(long j, NotebookKey notebookKey, byte[] bArr);

    public static final native long new_PageKey__SWIG_3(byte[] bArr);

    public static final native long new_PaperSize__SWIG_0();

    public static final native long new_PaperSize__SWIG_1(float f, float f2);

    public static final native long new_QueryBuilder();

    public static final native long new_RecoContext__SWIG_0(ITypesetListener iTypesetListener, long j, SWIGVectorString sWIGVectorString, long j2, SWIGVectorCustomResource sWIGVectorCustomResource);

    public static final native long new_RecoContext__SWIG_1(ITypesetListener iTypesetListener, long j, SWIGVectorString sWIGVectorString);

    public static final native long new_ReflowOptions();

    public static final native long new_SWIGAngle__SWIG_0();

    public static final native long new_SWIGAngle__SWIG_1(float f);

    public static final native long new_SWIGAngle__SWIG_2(double d);

    public static final native long new_SWIGAngle__SWIG_3(long j, ValuedAngle valuedAngle);

    public static final native long new_SWIGAngle__SWIG_4(long j, Point point, long j2, Point point2);

    public static final native long new_SWIGAngle__SWIG_5(long j, Point point, long j2, Point point2, long j3, Point point3);

    public static final native long new_SWIGAngle__SWIG_6(double d, double d2, double d3, double d4, long j, Point point);

    public static final native long new_SWIGAngle__SWIG_7(int i);

    public static final native long new_SWIGOptionContext__SWIG_0(boolean z);

    public static final native long new_SWIGOptionContext__SWIG_1();

    public static final native long new_SWIGVectorCollectionKey();

    public static final native long new_SWIGVectorColors();

    public static final native long new_SWIGVectorImageParameter();

    public static final native long new_SWIGVectorLocaleInfo();

    public static final native long new_SWIGVectorNotebookKey();

    public static final native long new_SWIGVectorPageKey();

    public static final native long new_SWIGVectorSearchMatch();

    public static final native long new_SWIGVectorToolConfiguration();

    public static final native long new_ScrollBarBehavior();

    public static final native long new_SearchController_SearchDMSFileSystem(byte[] bArr);

    public static final native long new_SearchController__SWIG_0(byte[] bArr, int i);

    public static final native long new_SearchController__SWIG_1(byte[] bArr);

    public static final native long new_SearchController__SWIG_2(long j, int i);

    public static final native long new_SearchController__SWIG_3(long j);

    public static final native long new_SearchController__SWIG_4(long j, SearchController searchController);

    public static final native long new_SearchMatch();

    public static final native long new_SearchMatchParser(byte[] bArr);

    public static final native long new_SearchQuery__SWIG_0(byte[] bArr);

    public static final native long new_SearchQuery__SWIG_1(byte[] bArr, long j, PageKey pageKey);

    public static final native long new_SingleColumnGridFactoryStrategy();

    public static final native long new_SingleColumnWithoutTopMarginGridFactoryStrategy();

    public static final native long new_StandalonePageControllerProvider(byte[] bArr);

    public static final native long new_StyleUtils();

    public static final native long new_TextSelectionWithContext();

    public static final native long new_ThumbnailConfiguration__SWIG_0();

    public static final native long new_ThumbnailConfiguration__SWIG_1(float f, float f2, byte[] bArr);

    public static final native long new_ThumbnailConfiguration__SWIG_2(float f, float f2, byte[] bArr, IColorInversionPolicy iColorInversionPolicy);

    public static final native long new_Thumbnailer();

    public static final native long new_ToolConfiguration__SWIG_0();

    public static final native long new_ToolConfiguration__SWIG_1(int i);

    public static final native long new_ToolConfiguration__SWIG_2(int i, int i2);

    public static final native long new_ToolConfiguration__SWIG_3(int i, int i2, float f, long j);

    public static final native long new_ToolConfiguration__SWIG_4(int i, int i2, float f);

    public static final native long new_ToolProperty__SWIG_0();

    public static final native long new_ToolProperty__SWIG_1(int i);

    public static final native long new_ToolProperty__SWIG_2(int i, float f, long j);

    public static final native long new_ToolProperty__SWIG_3(int i, float f);

    public static final native long new_ToolbarConfiguration__SWIG_0();

    public static final native long new_ToolbarConfiguration__SWIG_1(byte[] bArr);

    public static final native long new_ToolbarConfiguration__SWIG_2(byte[] bArr, int i);

    public static final native long new_ToolbarController__SWIG_0(byte[] bArr, boolean z, boolean z2);

    public static final native long new_ToolbarController__SWIG_1(byte[] bArr, boolean z);

    public static final native long new_ToolbarController__SWIG_2(byte[] bArr);

    public static final native void setNativeCrashHandlerClass(Object obj);

    NeboEngineJNI() {
    }
}

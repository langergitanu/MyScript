package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
class ATKCoreJNI {
    public static final native byte[] ANALYTICS_get();

    public static final native byte[] ActiveArea_getCustomAttribute(long j, ActiveArea activeArea, byte[] bArr);

    public static final native float ActiveArea_getCustomAttributeAsFloat(long j, ActiveArea activeArea, byte[] bArr, float f);

    public static final native long ActiveArea_getCustomAttributeAsInt64(long j, ActiveArea activeArea, byte[] bArr, long j2);

    public static final native int ActiveArea_getCustomAttributeCount(long j, ActiveArea activeArea);

    public static final native long ActiveArea_getExtent(long j, ActiveArea activeArea);

    public static final native int ActiveArea_getFieldCount(long j, ActiveArea activeArea, int i);

    public static final native String ActiveArea_getFieldNameAt(long j, ActiveArea activeArea, int i, int i2);

    public static final native long ActiveArea_getFields(long j, ActiveArea activeArea);

    public static final native long ActiveArea_getFieldsForType(long j, ActiveArea activeArea, int i);

    public static final native byte[] ActiveArea_getId(long j, ActiveArea activeArea);

    public static final native int ActiveArea_getIndex(long j, ActiveArea activeArea);

    public static final native void ActiveArea_removeCustomAttribute(long j, ActiveArea activeArea, byte[] bArr);

    public static final native void ActiveArea_setCustomAttribute(long j, ActiveArea activeArea, byte[] bArr, byte[] bArr2);

    public static final native void ActiveArea_setCustomAttributeAsFloat(long j, ActiveArea activeArea, byte[] bArr, float f);

    public static final native void ActiveArea_setCustomAttributeAsInt64(long j, ActiveArea activeArea, byte[] bArr, long j2);

    public static final native void ActiveArea_setExtent(long j, ActiveArea activeArea, long j2);

    public static final native void ActiveArea_setIndex(long j, ActiveArea activeArea, int i);

    public static final native void AtomicString_clear(long j, AtomicString atomicString);

    public static final native boolean AtomicString_empty(long j, AtomicString atomicString);

    public static final native long AtomicString_length(long j, AtomicString atomicString);

    public static final native byte[] AtomicString_load(long j, AtomicString atomicString);

    public static final native void AtomicString_store(long j, AtomicString atomicString, byte[] bArr);

    public static final native byte[] BANNER_get();

    public static final native float BackgroundDescription_dx_get(long j, BackgroundDescription backgroundDescription);

    public static final native void BackgroundDescription_dx_set(long j, BackgroundDescription backgroundDescription, float f);

    public static final native float BackgroundDescription_dy_get(long j, BackgroundDescription backgroundDescription);

    public static final native void BackgroundDescription_dy_set(long j, BackgroundDescription backgroundDescription, float f);

    public static final native int BackgroundDescription_pattern_get(long j, BackgroundDescription backgroundDescription);

    public static final native void BackgroundDescription_pattern_set(long j, BackgroundDescription backgroundDescription, int i);

    public static final native long BackgroundPatternLabels_get();

    public static final native long Box_content(long j, Box box);

    public static final native boolean Box_empty(long j, Box box);

    public static final native long Box_extent(long j, Box box);

    public static final native boolean Box_hasValidContent(long j, Box box);

    public static final native byte[] Box_id(long j, Box box);

    public static final native boolean Box_isRoot(long j, Box box);

    public static final native long Box_layout(long j, Box box);

    public static final native long Box_layoutGroup(long j, Box box);

    public static final native void Box_move(long j, Box box, float f, float f2);

    public static final native boolean Box_needCheckReco(long j, Box box);

    public static final native long Box_nextBrother(long j, Box box);

    public static final native long Box_page(long j, Box box);

    public static final native long Box_parent(long j, Box box);

    public static final native long Box_previousBrother(long j, Box box);

    public static final native void Box_remove(long j, Box box);

    public static final native long Box_selection(long j, Box box);

    public static final native long Box_tagId(long j, Box box);

    public static final native byte[] Box_toString(long j, Box box);

    public static final native byte[] Box_type(long j, Box box);

    public static final native long Box_typesetRequest__SWIG_0(long j, Box box, long j2);

    public static final native long Box_typesetRequest__SWIG_1(long j, Box box);

    public static final native long Box_typesetSettings(long j, Box box, long j2);

    public static final native void Box_updateSelection(long j, Box box);

    public static final native long ButtonTypeLabels_get();

    public static final native long ButtonTypeSetLabels_get();

    public static final native byte[] CONTAINER_get();

    public static final native long CaptureInfo_pagePoint(long j, CaptureInfo captureInfo);

    public static final native long CaptureInfo_pointerInfo(long j, CaptureInfo captureInfo);

    public static final native long CaptureInfo_pointerInfoData(long j, CaptureInfo captureInfo);

    public static final native long CaptureInfo_toolKind(long j, CaptureInfo captureInfo);

    public static final native float CenterEllipticArc_cx_get(long j, CenterEllipticArc centerEllipticArc);

    public static final native void CenterEllipticArc_cx_set(long j, CenterEllipticArc centerEllipticArc, float f);

    public static final native float CenterEllipticArc_cy_get(long j, CenterEllipticArc centerEllipticArc);

    public static final native void CenterEllipticArc_cy_set(long j, CenterEllipticArc centerEllipticArc, float f);

    public static final native float CenterEllipticArc_phi_get(long j, CenterEllipticArc centerEllipticArc);

    public static final native void CenterEllipticArc_phi_set(long j, CenterEllipticArc centerEllipticArc, float f);

    public static final native float CenterEllipticArc_rx_get(long j, CenterEllipticArc centerEllipticArc);

    public static final native void CenterEllipticArc_rx_set(long j, CenterEllipticArc centerEllipticArc, float f);

    public static final native float CenterEllipticArc_ry_get(long j, CenterEllipticArc centerEllipticArc);

    public static final native void CenterEllipticArc_ry_set(long j, CenterEllipticArc centerEllipticArc, float f);

    public static final native float CenterEllipticArc_startAngle_get(long j, CenterEllipticArc centerEllipticArc);

    public static final native void CenterEllipticArc_startAngle_set(long j, CenterEllipticArc centerEllipticArc, float f);

    public static final native float CenterEllipticArc_sweepAngle_get(long j, CenterEllipticArc centerEllipticArc);

    public static final native void CenterEllipticArc_sweepAngle_set(long j, CenterEllipticArc centerEllipticArc, float f);

    public static final native long ChildPageSpec_extent_get(long j, ChildPageSpec childPageSpec);

    public static final native void ChildPageSpec_extent_set(long j, ChildPageSpec childPageSpec, long j2, Extent extent);

    public static final native byte[] ChildPageSpec_id_get(long j, ChildPageSpec childPageSpec);

    public static final native void ChildPageSpec_id_set(long j, ChildPageSpec childPageSpec, byte[] bArr);

    public static final native boolean Content_activeAreaExist(long j, Content content, byte[] bArr);

    public static final native long Content_addActiveArea(long j, Content content, long j2, byte[] bArr);

    public static final native void Content_addConfigurationSearchDir(long j, Content content, byte[] bArr);

    public static final native void Content_addContentField(long j, Content content, byte[] bArr, int i);

    public static final native boolean Content_addContentFieldFromOtherContentField(long j, Content content, byte[] bArr, byte[] bArr2);

    public static final native long Content_addGuide__SWIG_0(long j, Content content, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, GuideData guideData, byte[] bArr4, boolean z);

    public static final native long Content_addGuide__SWIG_1(long j, Content content, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, GuideData guideData, byte[] bArr4);

    public static final native long Content_addGuide__SWIG_2(long j, Content content, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, GuideData guideData);

    public static final native long Content_addGuide__SWIG_3(long j, Content content, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, GuideData guideData, long j3, GuidePositioning guidePositioning, byte[] bArr4, boolean z);

    public static final native long Content_addGuide__SWIG_4(long j, Content content, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, GuideData guideData, long j3, GuidePositioning guidePositioning, byte[] bArr4);

    public static final native long Content_addGuide__SWIG_5(long j, Content content, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2, GuideData guideData, long j3, GuidePositioning guidePositioning);

    public static final native boolean Content_addGuide__SWIG_6(long j, Content content, byte[] bArr, byte[] bArr2);

    public static final native boolean Content_addItems(long j, Content content, byte[] bArr, long j2, Selection selection);

    public static final native boolean Content_applyTypesetData(long j, Content content, long j2, TypesetData typesetData, long j3, Selection selection);

    public static final native boolean Content_autoProcess(long j, Content content);

    public static final native void Content_cancelProcessing(long j, Content content);

    public static final native void Content_cleanSkipOneProcess(long j, Content content, byte[] bArr);

    public static final native boolean Content_clearField(long j, Content content, byte[] bArr);

    public static final native void Content_clearSearchPath(long j, Content content);

    public static final native void Content_configure__SWIG_0(long j, Content content, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static final native void Content_configure__SWIG_1(long j, Content content, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native void Content_configure__SWIG_2(long j, Content content, byte[] bArr, byte[] bArr2);

    public static final native void Content_configure__SWIG_3(long j, Content content, byte[] bArr);

    public static final native void Content_disableAutoProcess__SWIG_0(long j, Content content, boolean z);

    public static final native void Content_disableAutoProcess__SWIG_1(long j, Content content);

    public static final native void Content_enableAutoBeautification(long j, Content content, long j2, boolean z);

    public static final native void Content_enableAutoProcess(long j, Content content);

    public static final native String Content_field(long j, Content content, int i, int i2);

    public static final native long Content_fieldsInput(long j, Content content, byte[] bArr, int i);

    public static final native long Content_getActiveArea(long j, Content content, byte[] bArr);

    public static final native long Content_getActiveAreaAt(long j, Content content, int i);

    public static final native int Content_getActiveAreaCount(long j, Content content);

    public static final native int Content_getFieldCount(long j, Content content, int i);

    public static final native long Content_getFieldInput__SWIG_0(long j, Content content, byte[] bArr);

    public static final native long Content_getFieldInput__SWIG_1(long j, Content content, long j2);

    public static final native byte[] Content_getFieldName(long j, Content content, int i, int i2);

    public static final native long Content_getGuide(long j, Content content, byte[] bArr);

    public static final native long Content_getGuides(long j, Content content, byte[] bArr);

    public static final native float Content_getLineSpacing(long j, Content content, byte[] bArr);

    public static final native long Content_getSearchDirs(long j, Content content);

    public static final native long Content_getTypesetData__SWIG_0(long j, Content content, byte[] bArr, long j2, Selection selection);

    public static final native long Content_getTypesetData__SWIG_1(long j, Content content, long j2, long j3, Selection selection);

    public static final native boolean Content_hasContentField(long j, Content content, byte[] bArr);

    public static final native boolean Content_hasFieldToSkip(long j, Content content);

    public static final native boolean Content_hasGuide(long j, Content content, byte[] bArr);

    public static final native boolean Content_hasLineSpacing(long j, Content content, byte[] bArr);

    public static final native boolean Content_isCanceling(long j, Content content);

    public static final native boolean Content_isProcessPendingOnPage(long j, Content content);

    public static final native boolean Content_isProcessPendingOrRequired__SWIG_0(long j, Content content, int i);

    public static final native boolean Content_isProcessPendingOrRequired__SWIG_1(long j, Content content);

    public static final native boolean Content_isProcessPending__SWIG_0(long j, Content content, long j2);

    public static final native boolean Content_isProcessPending__SWIG_1(long j, Content content, byte[] bArr);

    public static final native long Content_page(long j, Content content);

    public static final native long Content_patchApplicationScheduler(long j, Content content);

    public static final native void Content_process(long j, Content content, byte[] bArr);

    public static final native boolean Content_removeActiveArea(long j, Content content, byte[] bArr);

    public static final native boolean Content_removeContentField(long j, Content content, byte[] bArr);

    public static final native void Content_removeGuide(long j, Content content, byte[] bArr);

    public static final native boolean Content_removeItems(long j, Content content, byte[] bArr, long j2, Selection selection);

    public static final native void Content_removeLineSpacing(long j, Content content, byte[] bArr);

    public static final native void Content_setCustomResources(long j, Content content, int i, long j2, SWIGVectorCustomResource sWIGVectorCustomResource);

    public static final native void Content_setLineSpacing(long j, Content content, byte[] bArr, float f);

    public static final native void Content_setMathRecognizerTimeOut(long j, Content content, float f);

    public static final native void Content_setMaxRecognitionThreadCount(long j, Content content, int i, long j2);

    public static final native void Content_skipOneProcess(long j, Content content, byte[] bArr);

    public static final native void Content_sync(long j, Content content);

    public static final native long Content_tagId(long j, Content content, byte[] bArr);

    public static final native void Content_transformGuide(long j, Content content, byte[] bArr, long j2, Transform transform);

    public static final native boolean Content_valid(long j, Content content);

    public static final native long Context_getInstance__SWIG_0(byte[] bArr, long j, Object obj, boolean z);

    public static final native long Context_getInstance__SWIG_1(byte[] bArr, long j, Object obj);

    public static final native long Context_getInstance__SWIG_2(byte[] bArr, long j);

    public static final native long Context_getInstance__SWIG_3(long j, boolean z);

    public static final native long Context_getUserObjectCount(long j, Context context);

    public static final native long Context_getUserObjectLimit(long j, Context context);

    public static final native void Context_setUserHandwritingContextCountLimit(long j, Context context, long j2);

    public static final native void Context_setUserObjectCountLimit(long j, Context context, long j2);

    public static final native long Context_userHandwritingContextCount(long j, Context context);

    public static final native long Context_userHandwritingContextLimit(long j, Context context);

    public static final native byte[] CustomResource_resourcePath_get(long j, CustomResource customResource);

    public static final native void CustomResource_resourcePath_set(long j, CustomResource customResource, byte[] bArr);

    public static final native byte[] CustomResource_toString(long j, CustomResource customResource);

    public static final native int CustomResource_type_get(long j, CustomResource customResource);

    public static final native void CustomResource_type_set(long j, CustomResource customResource, int i);

    public static final native byte[] DBG_get();

    public static final native byte[] DIAGRAM_get();

    public static final native byte[] DRAWING_get();

    public static final native double DVector2_magnitude(long j, DVector2 dVector2);

    public static final native void DVector2_set__SWIG_0(long j, DVector2 dVector2, double d, double d2);

    public static final native void DVector2_set__SWIG_1(long j, DVector2 dVector2, long j2, DVector2 dVector22);

    public static final native double DVector2_x_get(long j, DVector2 dVector2);

    public static final native void DVector2_x_set(long j, DVector2 dVector2, double d);

    public static final native double DVector2_y_get(long j, DVector2 dVector2);

    public static final native void DVector2_y_set(long j, DVector2 dVector2, double d);

    public static final native long DebugConsoleCategoryLabels_get();

    public static final native long DebugConsoleCategoryMasks_get();

    public static final native long DebugConsoleLevelLabels_get();

    public static final native long DebugConsolePrefixLabels_get();

    public static final native long DebugConsolePrefixMasks_get();

    public static final native long DefaultPendingStrokeIdProvider_SWIGUpcast(long j);

    public static final native long DefaultPendingStrokeIdProvider_allocatePendingStrokeId(long j, DefaultPendingStrokeIdProvider defaultPendingStrokeIdProvider);

    public static final native long DefaultPendingStrokeIdProvider_nextPendingStrokeId(long j, DefaultPendingStrokeIdProvider defaultPendingStrokeIdProvider);

    public static final native long DisplayingCursorStates_get();

    public static final native long Document_addPage(long j, Document document);

    public static final native long Document_addPageAt(long j, Document document, int i);

    public static final native boolean Document_callbackPending(long j, Document document);

    public static final native void Document_discardUnSavedChanges__SWIG_0(long j, Document document, boolean z);

    public static final native void Document_discardUnSavedChanges__SWIG_1(long j, Document document);

    public static final native boolean Document_existsOnFileSystem(long j, Document document);

    public static final native byte[] Document_getFilePath(long j, Document document);

    public static final native long Document_getMetadata(long j, Document document);

    public static final native int Document_getNumberOfPages(long j, Document document);

    public static final native long Document_getPage__SWIG_0(long j, Document document, int i);

    public static final native long Document_getPage__SWIG_1(long j, Document document, byte[] bArr);

    public static final native byte[] Document_getStyleSheet(long j, Document document);

    public static final native boolean Document_hasPages(long j, Document document);

    public static final native int Document_hashCode(long j, Document document);

    public static final native long Document_importPage(long j, Document document, long j2, Page page);

    public static final native int Document_indexOfPage(long j, Document document, long j2, Page page);

    public static final native boolean Document_isModified(long j, Document document);

    public static final native boolean Document_isOpened(byte[] bArr);

    public static final native boolean Document_isPreventCompatWhenAnalyzerEnd2End(long j, Document document);

    public static final native void Document_movePage(long j, Document document, int i, int i2);

    public static final native boolean Document_move__SWIG_0(long j, Document document, byte[] bArr);

    public static final native boolean Document_move__SWIG_1(long j, Document document, byte[] bArr);

    public static final native boolean Document_nativeEquals(long j, Document document, long j2, Document document2);

    public static final native long Document_openTemp();

    public static final native long Document_open__SWIG_0(byte[] bArr, boolean z);

    public static final native long Document_open__SWIG_1(byte[] bArr);

    public static final native long Document_open__SWIG_2(byte[] bArr, byte[] bArr2, boolean z);

    public static final native long Document_open__SWIG_3(byte[] bArr, byte[] bArr2);

    public static final native long Document_open__SWIG_4(byte[] bArr, byte[] bArr2, boolean z, boolean z2);

    public static final native long Document_open__SWIG_5(byte[] bArr, long j, boolean z);

    public static final native long Document_open__SWIG_6(byte[] bArr, long j);

    public static final native byte[] Document_pageId(long j, Document document, int i);

    public static final native boolean Document_removeFirstPage(long j, Document document);

    public static final native boolean Document_removeLastPage(long j, Document document);

    public static final native boolean Document_removeOnDestroy__SWIG_0(long j, Document document);

    public static final native boolean Document_removeOnDestroy__SWIG_1(long j, Document document);

    public static final native boolean Document_removePageAt(long j, Document document, int i);

    public static final native void Document_save(long j, Document document);

    public static final native void Document_saveAs(long j, Document document, byte[] bArr);

    public static final native void Document_saveToTemp(long j, Document document);

    public static final native long Document_sessionID(long j, Document document);

    public static final native void Document_setAutoCleanUp(long j, Document document, boolean z);

    public static final native void Document_setIOControlCallback__SWIG_0(long j, Document document, long j2, boolean z);

    public static final native void Document_setIOControlCallback__SWIG_1(long j, Document document, long j2);

    public static final native void Document_setMetadata(long j, Document document, long j2, Json json);

    public static final native void Document_setPreventCompatWhenAnalyzerEnd2End(long j, Document document, boolean z);

    public static final native void Document_setStyleSheet(long j, Document document, byte[] bArr);

    public static final native void Document_setStyleSheetFromString(long j, Document document, byte[] bArr);

    public static final native void Document_setTemporaryDirectory(long j, Document document, byte[] bArr);

    public static final native void Document_sync(long j, Document document);

    public static final native byte[] Document_toString(long j, Document document);

    public static final native boolean Document_willBeRemoved(long j, Document document);

    public static final native byte[] EDGE_get();

    public static final native float EPSILON_get();

    public static final native long EXTENT_EMPTY_get();

    public static final native byte[] EXTERNAL_get();

    public static final native long EmptyPdfChildPageSize_get();

    public static final native String EmptyPdfChildPage_get();

    public static final native int EndpointEllipticArc_fA_get(long j, EndpointEllipticArc endpointEllipticArc);

    public static final native void EndpointEllipticArc_fA_set(long j, EndpointEllipticArc endpointEllipticArc, int i);

    public static final native int EndpointEllipticArc_fS_get(long j, EndpointEllipticArc endpointEllipticArc);

    public static final native void EndpointEllipticArc_fS_set(long j, EndpointEllipticArc endpointEllipticArc, int i);

    public static final native long EndpointEllipticArc_getP1(long j, EndpointEllipticArc endpointEllipticArc);

    public static final native long EndpointEllipticArc_getP2(long j, EndpointEllipticArc endpointEllipticArc);

    public static final native float EndpointEllipticArc_phi_get(long j, EndpointEllipticArc endpointEllipticArc);

    public static final native void EndpointEllipticArc_phi_set(long j, EndpointEllipticArc endpointEllipticArc, float f);

    public static final native float EndpointEllipticArc_rx_get(long j, EndpointEllipticArc endpointEllipticArc);

    public static final native void EndpointEllipticArc_rx_set(long j, EndpointEllipticArc endpointEllipticArc, float f);

    public static final native float EndpointEllipticArc_ry_get(long j, EndpointEllipticArc endpointEllipticArc);

    public static final native void EndpointEllipticArc_ry_set(long j, EndpointEllipticArc endpointEllipticArc, float f);

    public static final native void EndpointEllipticArc_setP1(long j, EndpointEllipticArc endpointEllipticArc, long j2, Point point);

    public static final native void EndpointEllipticArc_setP2(long j, EndpointEllipticArc endpointEllipticArc, long j2, Point point);

    public static final native int EngineError_getErrorId(long j, EngineError engineError);

    public static final native String EngineError_getMessage(long j, EngineError engineError);

    public static final native void Extent_add__SWIG_0(long j, Extent extent, long j2, Extent extent2);

    public static final native void Extent_add__SWIG_1(long j, Extent extent, float f, float f2);

    public static final native boolean Extent_almostEquals__SWIG_0(long j, Extent extent, long j2, Extent extent2, float f);

    public static final native boolean Extent_almostEquals__SWIG_1(long j, Extent extent, long j2, Extent extent2);

    public static final native long Extent_bottomLeft(long j, Extent extent);

    public static final native long Extent_bottomRight(long j, Extent extent);

    public static final native long Extent_centroid(long j, Extent extent);

    public static final native boolean Extent_contains__SWIG_0(long j, Extent extent, long j2, Extent extent2);

    public static final native boolean Extent_contains__SWIG_1(long j, Extent extent, float f, float f2);

    public static final native boolean Extent_contains__SWIG_2(long j, Extent extent, long j2, Point point);

    public static final native float Extent_diagonalLength(long j, Extent extent);

    public static final native boolean Extent_empty(long j, Extent extent);

    public static final native float Extent_getHeight(long j, Extent extent);

    public static final native float Extent_getWidth(long j, Extent extent);

    public static final native float Extent_getXMax(long j, Extent extent);

    public static final native float Extent_getXMin(long j, Extent extent);

    public static final native float Extent_getYMax(long j, Extent extent);

    public static final native float Extent_getYMin(long j, Extent extent);

    public static final native long Extent_inset(long j, Extent extent, float f, float f2);

    public static final native long Extent_intersection(long j, Extent extent, long j2, Extent extent2);

    public static final native boolean Extent_intersects(long j, Extent extent, long j2, Extent extent2);

    public static final native boolean Extent_intersectsStrict(long j, Extent extent, long j2, Extent extent2);

    public static final native boolean Extent_isWorld(long j, Extent extent);

    public static final native long Extent_mapped(long j, Extent extent, long j2, Transform transform);

    public static final native long Extent_midBottom(long j, Extent extent);

    public static final native long Extent_midLeft(long j, Extent extent);

    public static final native long Extent_midRight(long j, Extent extent);

    public static final native long Extent_midTop(long j, Extent extent);

    public static final native long Extent_scale__SWIG_0(long j, Extent extent, float f, float f2);

    public static final native long Extent_scale__SWIG_1(long j, Extent extent, float f);

    public static final native void Extent_set__SWIG_0(long j, Extent extent, long j2);

    public static final native void Extent_set__SWIG_1(long j, Extent extent, float f, float f2, float f3, float f4);

    public static final native boolean Extent_strictlyEquals(long j, Extent extent, long j2, Extent extent2);

    public static final native long Extent_subtract(long j, Extent extent, long j2, Extent extent2);

    public static final native long Extent_topLeft(long j, Extent extent);

    public static final native long Extent_topRight(long j, Extent extent);

    public static final native long Extent_translate(long j, Extent extent, float f, float f2);

    public static final native boolean Extent_valid(long j, Extent extent);

    public static final native boolean FileLogLevelAtLeast(int i, int i2);

    public static final native float FontWeightBlack_get();

    public static final native float FontWeightNormal_get();

    public static final native float FontWeightThin_get();

    public static final native byte[] GEOMETRY_get();

    public static final native byte[] GESTURE_get();

    public static final native float GlyphLines_baseline_get(long j, GlyphLines glyphLines);

    public static final native void GlyphLines_baseline_set(long j, GlyphLines glyphLines, float f);

    public static final native float GlyphLines_x_height_get(long j, GlyphLines glyphLines);

    public static final native void GlyphLines_x_height_set(long j, GlyphLines glyphLines, float f);

    public static final native long GlyphMetrics_boundingBox_get(long j, GlyphMetrics glyphMetrics);

    public static final native void GlyphMetrics_boundingBox_set(long j, GlyphMetrics glyphMetrics, long j2, Rectangle rectangle);

    public static final native long GlyphMetrics_labelSize_get(long j, GlyphMetrics glyphMetrics);

    public static final native void GlyphMetrics_labelSize_set(long j, GlyphMetrics glyphMetrics, long j2);

    public static final native float GlyphMetrics_leftSideBearing_get(long j, GlyphMetrics glyphMetrics);

    public static final native void GlyphMetrics_leftSideBearing_set(long j, GlyphMetrics glyphMetrics, float f);

    public static final native float GlyphMetrics_rightSideBearing_get(long j, GlyphMetrics glyphMetrics);

    public static final native void GlyphMetrics_rightSideBearing_set(long j, GlyphMetrics glyphMetrics, float f);

    public static final native float GlyphSlices_bottom_get(long j, GlyphSlices glyphSlices);

    public static final native void GlyphSlices_bottom_set(long j, GlyphSlices glyphSlices, float f);

    public static final native float GlyphSlices_left_get(long j, GlyphSlices glyphSlices);

    public static final native void GlyphSlices_left_set(long j, GlyphSlices glyphSlices, float f);

    public static final native float GlyphSlices_right_get(long j, GlyphSlices glyphSlices);

    public static final native void GlyphSlices_right_set(long j, GlyphSlices glyphSlices, float f);

    public static final native float GlyphSlices_top_get(long j, GlyphSlices glyphSlices);

    public static final native void GlyphSlices_top_set(long j, GlyphSlices glyphSlices, float f);

    public static final native long Glyph_SWIGUpcast(long j);

    public static final native long Glyph_getAlternateAt(long j, Glyph glyph, int i);

    public static final native int Glyph_getAlternateCount(long j, Glyph glyph);

    public static final native byte[] Glyph_getLabel(long j, Glyph glyph);

    public static final native long Glyph_getLines(long j, Glyph glyph);

    public static final native float Glyph_getLinesBaseLine(long j, Glyph glyph);

    public static final native long Glyph_getParallelogram(long j, Glyph glyph);

    public static final native float Glyph_getParallelogramUX(long j, Glyph glyph);

    public static final native float Glyph_getParallelogramUY(long j, Glyph glyph);

    public static final native float Glyph_getParallelogramVX(long j, Glyph glyph);

    public static final native float Glyph_getParallelogramVY(long j, Glyph glyph);

    public static final native float Glyph_getParallelogramX(long j, Glyph glyph);

    public static final native float Glyph_getParallelogramY(long j, Glyph glyph);

    public static final native long Glyph_getSlices(long j, Glyph glyph);

    public static final native float Glyph_getSlicesLeft(long j, Glyph glyph);

    public static final native float Glyph_getSlicesRight(long j, Glyph glyph);

    public static final native boolean Glyph_hasLines(long j, Glyph glyph);

    public static final native boolean Glyph_hasSlices(long j, Glyph glyph);

    public static final native long GuideData_getHorizontalLineSet(long j, GuideData guideData);

    public static final native long GuideData_getVerticalLineSet(long j, GuideData guideData);

    public static final native int GuideData_purpose_get(long j, GuideData guideData);

    public static final native int GuideData_type_get(long j, GuideData guideData);

    public static final native long GuideIterator_getData(long j, GuideIterator guideIterator);

    public static final native byte[] GuideIterator_getId(long j, GuideIterator guideIterator);

    public static final native boolean GuideIterator_isAtEnd(long j, GuideIterator guideIterator);

    public static final native void GuideIterator_next(long j, GuideIterator guideIterator);

    public static final native void GuideIterator_remove(long j, GuideIterator guideIterator);

    public static final native int GuidePositioning_lineBeginning_get(long j, GuidePositioning guidePositioning);

    public static final native void GuidePositioning_lineBeginning_set(long j, GuidePositioning guidePositioning, int i);

    public static final native int GuidePositioning_lineEnd_get(long j, GuidePositioning guidePositioning);

    public static final native void GuidePositioning_lineEnd_set(long j, GuidePositioning guidePositioning, int i);

    public static final native int GuidePositioning_zeroIndexedLine_get(long j, GuidePositioning guidePositioning);

    public static final native void GuidePositioning_zeroIndexedLine_set(long j, GuidePositioning guidePositioning, int i);

    public static final native byte[] HOLD_get();

    public static final native int HSLColorInversionPolicy_invertColor2(long j, HSLColorInversionPolicy hSLColorInversionPolicy, int i);

    public static final native int HorizontalLineSet_count_get(long j, HorizontalLineSet horizontalLineSet);

    public static final native float HorizontalLineSet_dy_get(long j, HorizontalLineSet horizontalLineSet);

    public static final native int HorizontalLineSet_first_get(long j, HorizontalLineSet horizontalLineSet);

    public static final native float HorizontalLineSet_x1_get(long j, HorizontalLineSet horizontalLineSet);

    public static final native float HorizontalLineSet_x2_get(long j, HorizontalLineSet horizontalLineSet);

    public static final native float HorizontalLineSet_y0_get(long j, HorizontalLineSet horizontalLineSet);

    public static final native void IConfigurationUpdateListener_configurationChanged(long j, IConfigurationUpdateListener iConfigurationUpdateListener, long j2, Page page, long j3, Json json);

    public static final native byte[] IGlyph_getAlternateAt_result_t_label_get(long j, IGlyph_getAlternateAt_result_t iGlyph_getAlternateAt_result_t);

    public static final native void IGlyph_getAlternateAt_result_t_label_set(long j, IGlyph_getAlternateAt_result_t iGlyph_getAlternateAt_result_t, byte[] bArr);

    public static final native float IGlyph_getAlternateAt_result_t_p_get(long j, IGlyph_getAlternateAt_result_t iGlyph_getAlternateAt_result_t);

    public static final native void IGlyph_getAlternateAt_result_t_p_set(long j, IGlyph_getAlternateAt_result_t iGlyph_getAlternateAt_result_t, float f);

    public static final native byte[] IMAGE_get();

    public static final native long IObjectManagerFactory_create(long j, IObjectManagerFactory iObjectManagerFactory, long j2);

    public static final native boolean IObjectManager_add(long j, IObjectManager iObjectManager, byte[] bArr, byte[] bArr2);

    public static final native long IObjectManager_clone(long j, IObjectManager iObjectManager, long j2);

    public static final native boolean IObjectManager_contains(long j, IObjectManager iObjectManager, byte[] bArr);

    public static final native void IObjectManager_extract(long j, IObjectManager iObjectManager, byte[] bArr, byte[] bArr2);

    public static final native void IObjectManager_remove(long j, IObjectManager iObjectManager, byte[] bArr);

    public static final native void IObjectManager_trackUpdates(long j, IObjectManager iObjectManager);

    public static final native long IPendingStrokeIdProvider_allocatePendingStrokeId(long j, IPendingStrokeIdProvider iPendingStrokeIdProvider);

    public static final native long IPendingStrokeIdProvider_nextPendingStrokeId(long j, IPendingStrokeIdProvider iPendingStrokeIdProvider);

    public static final native int IdentityColorInversionPolicy_invertColor2(long j, IdentityColorInversionPolicy identityColorInversionPolicy, int i);

    public static final native long InkStroke_getPath(long j, InkStroke inkStroke);

    public static final native long InkStroke_getPointArray(long j, InkStroke inkStroke);

    public static final native int InkStroke_getSampleCount(long j, InkStroke inkStroke);

    public static final native long InkStroke_getTimestamp(long j, InkStroke inkStroke);

    public static final native boolean InkStroke_isFirstPointIncluded(long j, InkStroke inkStroke);

    public static final native boolean InkStroke_isFirstPointPenDown(long j, InkStroke inkStroke);

    public static final native boolean InkStroke_isFloatArrayCompatible(long j, InkStroke inkStroke, int i);

    public static final native boolean InkStroke_isInt32ArrayCompatible(long j, InkStroke inkStroke, int i);

    public static final native boolean InkStroke_isInt64ArrayCompatible(long j, InkStroke inkStroke, int i);

    public static final native boolean InkStroke_isLastPointIncluded(long j, InkStroke inkStroke);

    public static final native boolean InkStroke_isLastPointPenUp(long j, InkStroke inkStroke);

    public static final native boolean InkStroke_isPointArrayCompatible(long j, InkStroke inkStroke);

    public static final native float InkStyle_FontLineHeight_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_FontLineHeight_set(long j, InkStyle inkStyle, float f);

    public static final native float InkStyle_FontSize_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_FontSize_set(long j, InkStyle inkStyle, float f);

    public static final native int InkStyle_FontWeight_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_FontWeight_set(long j, InkStyle inkStyle, int i);

    public static final native int InkStyle_backgroundColor_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_backgroundColor_set(long j, InkStyle inkStyle, int i);

    public static final native float InkStyle_beginArrowSize_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_beginArrowSize_set(long j, InkStyle inkStyle, float f);

    public static final native String InkStyle_beginArrowType_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_beginArrowType_set(long j, InkStyle inkStyle, String str);

    public static final native int InkStyle_color_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_color_set(long j, InkStyle inkStyle, int i);

    public static final native int InkStyle_compare(long j, InkStyle inkStyle, long j2, InkStyle inkStyle2, int i);

    public static final native float InkStyle_endArrowSize_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_endArrowSize_set(long j, InkStyle inkStyle, float f);

    public static final native String InkStyle_endArrowType_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_endArrowType_set(long j, InkStyle inkStyle, String str);

    public static final native int InkStyle_fillColor_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_fillColor_set(long j, InkStyle inkStyle, int i);

    public static final native byte[] InkStyle_getBrush(long j, InkStyle inkStyle);

    public static final native byte[] InkStyle_getFillStyle(long j, InkStyle inkStyle);

    public static final native byte[] InkStyle_getFontFamily(long j, InkStyle inkStyle);

    public static final native byte[] InkStyle_getFontStyle(long j, InkStyle inkStyle);

    public static final native byte[] InkStyle_getFontVariant(long j, InkStyle inkStyle);

    public static final native byte[] InkStyle_getSmoothing(long j, InkStyle inkStyle);

    public static final native byte[] InkStyle_getTextDecorationStyle(long j, InkStyle inkStyle);

    public static final native float InkStyle_orientation_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_orientation_set(long j, InkStyle inkStyle, float f);

    public static final native float InkStyle_pressure_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_pressure_set(long j, InkStyle inkStyle, float f);

    public static final native void InkStyle_setBrush(long j, InkStyle inkStyle, byte[] bArr);

    public static final native void InkStyle_setFillStyle(long j, InkStyle inkStyle, byte[] bArr);

    public static final native void InkStyle_setFontFamily(long j, InkStyle inkStyle, byte[] bArr);

    public static final native void InkStyle_setFontStyle(long j, InkStyle inkStyle, byte[] bArr);

    public static final native void InkStyle_setFontVariant(long j, InkStyle inkStyle, byte[] bArr);

    public static final native void InkStyle_setSmoothing(long j, InkStyle inkStyle, byte[] bArr);

    public static final native void InkStyle_setTextDecorationStyle(long j, InkStyle inkStyle, byte[] bArr);

    public static final native int InkStyle_textDecorationBackgroundColor_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_textDecorationBackgroundColor_set(long j, InkStyle inkStyle, int i);

    public static final native String InkStyle_textDecorationBrush_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_textDecorationBrush_set(long j, InkStyle inkStyle, String str);

    public static final native int InkStyle_textDecorationColor_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_textDecorationColor_set(long j, InkStyle inkStyle, int i);

    public static final native String InkStyle_textDecorationSmoothing_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_textDecorationSmoothing_set(long j, InkStyle inkStyle, String str);

    public static final native float InkStyle_textDecorationWidth_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_textDecorationWidth_set(long j, InkStyle inkStyle, float f);

    public static final native float InkStyle_tilt_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_tilt_set(long j, InkStyle inkStyle, float f);

    public static final native float InkStyle_width_get(long j, InkStyle inkStyle);

    public static final native void InkStyle_width_set(long j, InkStyle inkStyle, float f);

    public static final native void InputCharacter_addAlternate(long j, InputCharacter inputCharacter, byte[] bArr, float f);

    public static final native void InputCharacter_clear(long j, InputCharacter inputCharacter);

    public static final native float Insets_bottom_get(long j, Insets insets);

    public static final native void Insets_bottom_set(long j, Insets insets, float f);

    public static final native float Insets_left_get(long j, Insets insets);

    public static final native void Insets_left_set(long j, Insets insets, float f);

    public static final native long Insets_mapped(long j, Insets insets, long j2, Transform transform);

    public static final native float Insets_right_get(long j, Insets insets);

    public static final native void Insets_right_set(long j, Insets insets, float f);

    public static final native float Insets_top_get(long j, Insets insets);

    public static final native void Insets_top_set(long j, Insets insets, float f);

    public static final native int IntInterval_begin_get(long j, IntInterval intInterval);

    public static final native void IntInterval_begin_set(long j, IntInterval intInterval, int i);

    public static final native int IntInterval_end_get(long j, IntInterval intInterval);

    public static final native void IntInterval_end_set(long j, IntInterval intInterval, int i);

    public static final native String InvalidChildPageId_get();

    public static final native byte[] JOURNAL_get();

    public static final native boolean JsonObjectIterator_equals(long j, JsonObjectIterator jsonObjectIterator, long j2);

    public static final native byte[] JsonObjectIterator_getKey(long j, JsonObjectIterator jsonObjectIterator);

    public static final native long JsonObjectIterator_getValue(long j, JsonObjectIterator jsonObjectIterator);

    public static final native boolean JsonObjectIterator_isAtEnd(long j, JsonObjectIterator jsonObjectIterator);

    public static final native void JsonObjectIterator_next(long j, JsonObjectIterator jsonObjectIterator);

    public static final native long Json_createArray();

    public static final native long Json_createBoolean(boolean z);

    public static final native long Json_createInteger(long j);

    public static final native long Json_createNull();

    public static final native long Json_createNumber(double d);

    public static final native long Json_createObject();

    public static final native long Json_createString(byte[] bArr);

    public static final native long Json_createStringFromTimestamp(long j);

    public static final native boolean Json_equals(long j, Json json, long j2, Json json2);

    public static final native long Json_generateUUID();

    public static final native int Json_getArrayLength(long j, Json json);

    public static final native long Json_getArrayValueAt(long j, Json json, int i);

    public static final native boolean Json_getBooleanValue(long j, Json json);

    public static final native boolean Json_getBooleanValueForPath(long j, Json json, byte[] bArr);

    public static final native boolean Json_getBooleanValueForPath2(long j, Json json, byte[] bArr, boolean z);

    public static final native long Json_getIntegerValue(long j, Json json);

    public static final native long Json_getIntegerValueForPath(long j, Json json, byte[] bArr);

    public static final native long Json_getIntegerValueForPath2(long j, Json json, byte[] bArr, long j2);

    public static final native double Json_getNumberValue(long j, Json json);

    public static final native double Json_getNumberValueForPath(long j, Json json, byte[] bArr);

    public static final native double Json_getNumberValueForPath2(long j, Json json, byte[] bArr, double d);

    public static final native long Json_getObjectEntries(long j, Json json);

    public static final native long Json_getObjectEntryValue(long j, Json json, byte[] bArr);

    public static final native byte[] Json_getStringValue(long j, Json json);

    public static final native long Json_getStringValueAsTimestamp(long j, Json json);

    public static final native byte[] Json_getStringValueForPath(long j, Json json, byte[] bArr);

    public static final native byte[] Json_getStringValueForPath2(long j, Json json, byte[] bArr, byte[] bArr2);

    public static final native int Json_getType(long j, Json json);

    public static final native long Json_getValueForPath(long j, Json json, byte[] bArr);

    public static final native void Json_insertArrayValueAt(long j, Json json, int i, long j2, Json json2);

    public static final native long Json_parse(byte[] bArr);

    public static final native void Json_putObjectEntry(long j, Json json, byte[] bArr, long j2, Json json2);

    public static final native void Json_removeArrayValueAt(long j, Json json, int i);

    public static final native void Json_removeObjectEntry(long j, Json json, byte[] bArr);

    public static final native void Json_removeValueForPath(long j, Json json, byte[] bArr);

    public static final native void Json_setBooleanValueForPath(long j, Json json, byte[] bArr, boolean z);

    public static final native void Json_setIntegerValueForPath(long j, Json json, byte[] bArr, long j2);

    public static final native void Json_setNumberValueForPath(long j, Json json, byte[] bArr, double d);

    public static final native void Json_setStringValueForPath(long j, Json json, byte[] bArr, byte[] bArr2);

    public static final native void Json_setValueForPath(long j, Json json, byte[] bArr, long j2, Json json2);

    public static final native long KeyboardActionLabels_get();

    public static final native long KeyboardModifierLabels_get();

    public static final native byte[] LOCKED_GESTURE_get();

    public static final native int LanguageUpdater_updateLanguage(long j, LanguageUpdater languageUpdater, long j2, Page page, byte[] bArr);

    public static final native long LayerIterator_getBackgroundColor(long j, LayerIterator layerIterator);

    public static final native long LayerIterator_getExtent(long j, LayerIterator layerIterator);

    public static final native byte[] LayerIterator_getId(long j, LayerIterator layerIterator);

    public static final native int LayerIterator_getItemCount(long j, LayerIterator layerIterator);

    public static final native long LayerIterator_getItems(long j, LayerIterator layerIterator);

    public static final native boolean LayerIterator_isAtEnd(long j, LayerIterator layerIterator);

    public static final native void LayerIterator_next(long j, LayerIterator layerIterator);

    public static final native void LayerIterator_remove(long j, LayerIterator layerIterator);

    public static final native void LayerIterator_setBackgroundColor(long j, LayerIterator layerIterator, int i);

    public static final native void LayoutGroup_addToGroup(long j, LayoutGroup layoutGroup, long j2, Selection selection);

    public static final native long LayoutGroup_appendChildGroup(long j, LayoutGroup layoutGroup);

    public static final native long LayoutGroup_getBox(long j, LayoutGroup layoutGroup);

    public static final native long LayoutGroup_getChildGroupAt(long j, LayoutGroup layoutGroup, int i);

    public static final native int LayoutGroup_getChildGroupCount(long j, LayoutGroup layoutGroup);

    public static final native byte[] LayoutGroup_getCustomAttribute(long j, LayoutGroup layoutGroup, byte[] bArr);

    public static final native float LayoutGroup_getCustomAttributeAsFloat(long j, LayoutGroup layoutGroup, byte[] bArr, float f);

    public static final native long LayoutGroup_getCustomAttributeAsInt64(long j, LayoutGroup layoutGroup, byte[] bArr, long j2);

    public static final native int LayoutGroup_getCustomAttributeCount(long j, LayoutGroup layoutGroup);

    public static final native long LayoutGroup_getExtent(long j, LayoutGroup layoutGroup);

    public static final native byte[] LayoutGroup_getId(long j, LayoutGroup layoutGroup);

    public static final native int LayoutGroup_getIndexInParentGroup(long j, LayoutGroup layoutGroup);

    public static final native long LayoutGroup_getParentGroup(long j, LayoutGroup layoutGroup);

    public static final native boolean LayoutGroup_isLayer(long j, LayoutGroup layoutGroup);

    public static final native void LayoutGroup_removeChildGroup(long j, LayoutGroup layoutGroup, long j2, LayoutGroup layoutGroup2);

    public static final native void LayoutGroup_removeChildGroupAt(long j, LayoutGroup layoutGroup, int i);

    public static final native void LayoutGroup_removeCustomAttribute(long j, LayoutGroup layoutGroup, byte[] bArr);

    public static final native void LayoutGroup_removeFromGroup(long j, LayoutGroup layoutGroup, long j2, Selection selection);

    public static final native void LayoutGroup_setBox(long j, LayoutGroup layoutGroup, long j2);

    public static final native void LayoutGroup_setChildGroupIndex(long j, LayoutGroup layoutGroup, long j2, LayoutGroup layoutGroup2, int i);

    public static final native void LayoutGroup_setCustomAttribute(long j, LayoutGroup layoutGroup, byte[] bArr, byte[] bArr2);

    public static final native void LayoutGroup_setCustomAttributeAsFloat(long j, LayoutGroup layoutGroup, byte[] bArr, float f);

    public static final native void LayoutGroup_setCustomAttributeAsInt64(long j, LayoutGroup layoutGroup, byte[] bArr, long j2);

    public static final native long LayoutItemArc_SWIGUpcast(long j);

    public static final native long LayoutItemArc_getCenterParametrization(long j, LayoutItemArc layoutItemArc);

    public static final native byte[] LayoutItemArc_getClasses(long j, LayoutItemArc layoutItemArc);

    public static final native long LayoutItemArc_getEndPointParametrization(long j, LayoutItemArc layoutItemArc);

    public static final native int LayoutItemArc_getFirstDecoration(long j, LayoutItemArc layoutItemArc);

    public static final native int LayoutItemArc_getLastDecoration(long j, LayoutItemArc layoutItemArc);

    public static final native byte[] LayoutItemArc_getOverrideStyle(long j, LayoutItemArc layoutItemArc);

    public static final native long LayoutItemArc_getPath(long j, LayoutItemArc layoutItemArc);

    public static final native long LayoutItemArc_getStyle(long j, LayoutItemArc layoutItemArc);

    public static final native boolean LayoutItemArc_renderWithNextItem(long j, LayoutItemArc layoutItemArc);

    public static final native long LayoutItemDecoration_SWIGUpcast(long j);

    public static final native byte[] LayoutItemDecoration_getClasses(long j, LayoutItemDecoration layoutItemDecoration);

    public static final native int LayoutItemDecoration_getDecorationType(long j, LayoutItemDecoration layoutItemDecoration);

    public static final native byte[] LayoutItemDecoration_getOverrideStyle(long j, LayoutItemDecoration layoutItemDecoration);

    public static final native long LayoutItemDecoration_getPath(long j, LayoutItemDecoration layoutItemDecoration);

    public static final native int LayoutItemDecoration_getPointCount(long j, LayoutItemDecoration layoutItemDecoration);

    public static final native long LayoutItemDecoration_getStyle(long j, LayoutItemDecoration layoutItemDecoration);

    public static final native long LayoutItemGuide_SWIGUpcast(long j);

    public static final native byte[] LayoutItemGuide_getClasses(long j, LayoutItemGuide layoutItemGuide);

    public static final native byte[] LayoutItemGuide_getContentGuideId(long j, LayoutItemGuide layoutItemGuide);

    public static final native long LayoutItemGuide_getData(long j, LayoutItemGuide layoutItemGuide);

    public static final native byte[] LayoutItemGuide_getOverrideStyle(long j, LayoutItemGuide layoutItemGuide);

    public static final native long LayoutItemGuide_getStyle(long j, LayoutItemGuide layoutItemGuide);

    public static final native void LayoutItemGuide_setLineRange(long j, LayoutItemGuide layoutItemGuide, int i, int i2);

    public static final native long LayoutItemIterator_getExtent(long j, LayoutItemIterator layoutItemIterator);

    public static final native boolean LayoutItemIterator_isAtEnd(long j, LayoutItemIterator layoutItemIterator);

    public static final native void LayoutItemIterator_next(long j, LayoutItemIterator layoutItemIterator);

    public static final native long LayoutItemLine_SWIGUpcast(long j);

    public static final native byte[] LayoutItemLine_getClasses(long j, LayoutItemLine layoutItemLine);

    public static final native int LayoutItemLine_getFirstDecoration(long j, LayoutItemLine layoutItemLine);

    public static final native int LayoutItemLine_getLastDecoration(long j, LayoutItemLine layoutItemLine);

    public static final native long LayoutItemLine_getLineSegment(long j, LayoutItemLine layoutItemLine);

    public static final native byte[] LayoutItemLine_getOverrideStyle(long j, LayoutItemLine layoutItemLine);

    public static final native long LayoutItemLine_getPath(long j, LayoutItemLine layoutItemLine);

    public static final native int LayoutItemLine_getSampleCount(long j, LayoutItemLine layoutItemLine);

    public static final native long LayoutItemLine_getStyle(long j, LayoutItemLine layoutItemLine);

    public static final native long LayoutItemLine_getTimestamp(long j, LayoutItemLine layoutItemLine);

    public static final native boolean LayoutItemLine_isFirstPointIncluded(long j, LayoutItemLine layoutItemLine);

    public static final native boolean LayoutItemLine_isFirstPointPenDown(long j, LayoutItemLine layoutItemLine);

    public static final native boolean LayoutItemLine_isLastPointIncluded(long j, LayoutItemLine layoutItemLine);

    public static final native boolean LayoutItemLine_isLastPointPenUp(long j, LayoutItemLine layoutItemLine);

    public static final native boolean LayoutItemLine_renderWithNextItem(long j, LayoutItemLine layoutItemLine);

    public static final native long LayoutItemObject_SWIGUpcast(long j);

    public static final native byte[] LayoutItemObject_getCustomAttribute(long j, LayoutItemObject layoutItemObject, byte[] bArr);

    public static final native float LayoutItemObject_getCustomAttributeAsFloat(long j, LayoutItemObject layoutItemObject, byte[] bArr, float f);

    public static final native long LayoutItemObject_getCustomAttributeAsInt64(long j, LayoutItemObject layoutItemObject, byte[] bArr, long j2);

    public static final native int LayoutItemObject_getCustomAttributeCount(long j, LayoutItemObject layoutItemObject);

    public static final native long LayoutItemObject_getData(long j, LayoutItemObject layoutItemObject);

    public static final native long LayoutItemObject_getTransform(long j, LayoutItemObject layoutItemObject);

    public static final native byte[] LayoutItemObject_getUrl(long j, LayoutItemObject layoutItemObject);

    public static final native void LayoutItemObject_removeCustomAttribute(long j, LayoutItemObject layoutItemObject, byte[] bArr);

    public static final native void LayoutItemObject_setCustomAttribute(long j, LayoutItemObject layoutItemObject, byte[] bArr, byte[] bArr2);

    public static final native void LayoutItemObject_setCustomAttributeAsFloat(long j, LayoutItemObject layoutItemObject, byte[] bArr, float f);

    public static final native void LayoutItemObject_setCustomAttributeAsInt64(long j, LayoutItemObject layoutItemObject, byte[] bArr, long j2);

    public static final native long LayoutItemPoint_SWIGUpcast(long j);

    public static final native byte[] LayoutItemPoint_getClasses(long j, LayoutItemPoint layoutItemPoint);

    public static final native byte[] LayoutItemPoint_getOverrideStyle(long j, LayoutItemPoint layoutItemPoint);

    public static final native long LayoutItemPoint_getPath(long j, LayoutItemPoint layoutItemPoint);

    public static final native long LayoutItemPoint_getPoint(long j, LayoutItemPoint layoutItemPoint);

    public static final native int LayoutItemPoint_getSampleCount(long j, LayoutItemPoint layoutItemPoint);

    public static final native long LayoutItemPoint_getStyle(long j, LayoutItemPoint layoutItemPoint);

    public static final native long LayoutItemPoint_getTimestamp(long j, LayoutItemPoint layoutItemPoint);

    public static final native boolean LayoutItemPoint_isFirstPointIncluded(long j, LayoutItemPoint layoutItemPoint);

    public static final native boolean LayoutItemPoint_isFirstPointPenDown(long j, LayoutItemPoint layoutItemPoint);

    public static final native boolean LayoutItemPoint_isLastPointIncluded(long j, LayoutItemPoint layoutItemPoint);

    public static final native boolean LayoutItemPoint_isLastPointPenUp(long j, LayoutItemPoint layoutItemPoint);

    public static final native boolean LayoutItemPoint_renderWithNextItem(long j, LayoutItemPoint layoutItemPoint);

    public static final native long LayoutItemString_SWIGUpcast(long j);

    public static final native boolean LayoutItemString_containsStretchedGlyphs(long j, LayoutItemString layoutItemString);

    public static final native long LayoutItemString_getGlyphAt(long j, LayoutItemString layoutItemString, int i);

    public static final native int LayoutItemString_getGlyphCount(long j, LayoutItemString layoutItemString);

    public static final native byte[] LayoutItemString_getLabel(long j, LayoutItemString layoutItemString);

    public static final native byte[] LayoutItemString_getOverrideStyleAt(long j, LayoutItemString layoutItemString, int i);

    public static final native long LayoutItemString_getStyleAt(long j, LayoutItemString layoutItemString, int i);

    public static final native byte[] LayoutItemString_getStyleClassesAt(long j, LayoutItemString layoutItemString, int i);

    public static final native int LayoutItemString_getStyleCount(long j, LayoutItemString layoutItemString);

    public static final native int LayoutItemString_getStyleRangeAt_fromGlyph(long j, LayoutItemString layoutItemString, int i);

    public static final native int LayoutItemString_getStyleRangeAt_toGlyph(long j, LayoutItemString layoutItemString, int i);

    public static final native boolean LayoutItemString_isGlyphSelected(long j, LayoutItemString layoutItemString, int i);

    public static final native long LayoutItemStroke_SWIGUpcast(long j);

    public static final native byte[] LayoutItemStroke_getClasses(long j, LayoutItemStroke layoutItemStroke);

    public static final native long LayoutItemStroke_getInkStroke(long j, LayoutItemStroke layoutItemStroke);

    public static final native byte[] LayoutItemStroke_getOverrideStyle(long j, LayoutItemStroke layoutItemStroke);

    public static final native long LayoutItemStroke_getPath(long j, LayoutItemStroke layoutItemStroke);

    public static final native int LayoutItemStroke_getSampleCount(long j, LayoutItemStroke layoutItemStroke);

    public static final native long LayoutItemStroke_getStyle(long j, LayoutItemStroke layoutItemStroke);

    public static final native long LayoutItemStroke_getTimestamp(long j, LayoutItemStroke layoutItemStroke);

    public static final native boolean LayoutItemStroke_isFirstPointIncluded(long j, LayoutItemStroke layoutItemStroke);

    public static final native boolean LayoutItemStroke_isFirstPointPenDown(long j, LayoutItemStroke layoutItemStroke);

    public static final native boolean LayoutItemStroke_isLastPointIncluded(long j, LayoutItemStroke layoutItemStroke);

    public static final native boolean LayoutItemStroke_isLastPointPenUp(long j, LayoutItemStroke layoutItemStroke);

    public static final native boolean LayoutItemStroke_renderWithNextItem(long j, LayoutItemStroke layoutItemStroke);

    public static final native long LayoutItem_getExtent(long j, LayoutItem layoutItem);

    public static final native byte[] LayoutItem_getId(long j, LayoutItem layoutItem);

    public static final native long LayoutItem_getRawExtent(long j, LayoutItem layoutItem);

    public static final native long LayoutIterator_getExtent(long j, LayoutIterator layoutIterator);

    public static final native int LayoutIterator_getType(long j, LayoutIterator layoutIterator);

    public static final native boolean LayoutIterator_groupChanged(long j, LayoutIterator layoutIterator);

    public static final native boolean LayoutIterator_hasNext(long j, LayoutIterator layoutIterator);

    public static final native long LayoutIterator_next(long j, LayoutIterator layoutIterator);

    public static final native void LayoutIterator_remove(long j, LayoutIterator layoutIterator);

    public static final native boolean LayoutIterator_styleChanged(long j, LayoutIterator layoutIterator);

    public static final native long LayoutObjectData_getRectangle(long j, LayoutObjectData layoutObjectData);

    public static final native String LayoutObjectData_mimeType_get(long j, LayoutObjectData layoutObjectData);

    public static final native void LayoutObjectData_mimeType_set(long j, LayoutObjectData layoutObjectData, String str);

    public static final native void LayoutObjectData_setRectangle(long j, LayoutObjectData layoutObjectData, long j2, Rectangle rectangle);

    public static final native String LayoutObjectData_transformId_get(long j, LayoutObjectData layoutObjectData);

    public static final native void LayoutObjectData_transformId_set(long j, LayoutObjectData layoutObjectData, String str);

    public static final native String LayoutObjectData_url_get(long j, LayoutObjectData layoutObjectData);

    public static final native void LayoutObjectData_url_set(long j, LayoutObjectData layoutObjectData, String str);

    public static final native byte[] Layout_BACKGROUND_LAYER_NAME_get();

    public static final native byte[] Layout_BACKGROUND_OBJECT_LAYER_NAME_get();

    public static final native byte[] Layout_DOCUMENT_LAYER_NAME_get();

    public static final native long Layout_addGuide__SWIG_0(long j, Layout layout, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static final native long Layout_addGuide__SWIG_1(long j, Layout layout, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native void Layout_addLayer(long j, Layout layout, byte[] bArr);

    public static final native long Layout_addLayoutItem__SWIG_0(long j, Layout layout, long j2, LayoutItem layoutItem, byte[] bArr, long j3);

    public static final native long Layout_addLayoutItem__SWIG_1(long j, Layout layout, long j2, LayoutItem layoutItem, byte[] bArr);

    public static final native long Layout_addLayoutItem__SWIG_2(long j, Layout layout, long j2, LayoutItem layoutItem);

    public static final native long Layout_addObject__SWIG_0(long j, Layout layout, byte[] bArr, byte[] bArr2, long j2, Rectangle rectangle, byte[] bArr3, byte[] bArr4, boolean z);

    public static final native long Layout_addObject__SWIG_1(long j, Layout layout, byte[] bArr, byte[] bArr2, long j2, Rectangle rectangle, byte[] bArr3, byte[] bArr4);

    public static final native long Layout_addObject__SWIG_2(long j, Layout layout, byte[] bArr, byte[] bArr2, long j2, Rectangle rectangle, byte[] bArr3);

    public static final native long Layout_addStrokeToGroup__SWIG_0(long j, Layout layout, long j2, LayoutGroup layoutGroup, long j3, InkStroke inkStroke, byte[] bArr, byte[] bArr2);

    public static final native long Layout_addStrokeToGroup__SWIG_1(long j, Layout layout, long j2, LayoutGroup layoutGroup, long j3, InkStroke inkStroke, byte[] bArr);

    public static final native long Layout_addStrokeToGroup__SWIG_2(long j, Layout layout, long j2, LayoutGroup layoutGroup, long j3, InkStroke inkStroke);

    public static final native long Layout_addStroke__SWIG_0(long j, Layout layout, long j2, InkStroke inkStroke, byte[] bArr, byte[] bArr2);

    public static final native long Layout_addStroke__SWIG_1(long j, Layout layout, long j2, InkStroke inkStroke, byte[] bArr);

    public static final native long Layout_addTag__SWIG_0(long j, Layout layout, long j2, Selection selection, byte[] bArr, long j3, Json json);

    public static final native long Layout_addTag__SWIG_1(long j, Layout layout, long j2, Selection selection, byte[] bArr);

    public static final native long Layout_addTag__SWIG_2(long j, Layout layout, long j2, Selection selection);

    public static final native long Layout_addTag__SWIG_3(long j, Layout layout, long j2, byte[] bArr, long j3, Json json);

    public static final native long Layout_addTag__SWIG_4(long j, Layout layout, long j2, byte[] bArr);

    public static final native long Layout_addTag__SWIG_5(long j, Layout layout, long j2);

    public static final native void Layout_applyStyle__SWIG_0(long j, Layout layout, long j2, Selection selection, byte[] bArr, byte[] bArr2);

    public static final native void Layout_applyStyle__SWIG_1(long j, Layout layout, long j2, Selection selection, byte[] bArr);

    public static final native void Layout_bringToFront(long j, Layout layout, long j2, Selection selection);

    public static final native void Layout_clear(long j, Layout layout);

    public static final native int Layout_countLayoutItemObjects(long j, Layout layout, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native long Layout_createGlyphsFromLabel__SWIG_0(long j, Layout layout, long j2, SWIGVectorParallelogram sWIGVectorParallelogram, byte[] bArr);

    public static final native long Layout_createGlyphsFromLabel__SWIG_1(long j, Layout layout, long j2, SWIGVectorGlyphLines sWIGVectorGlyphLines, long j3, SWIGVectorParallelogram sWIGVectorParallelogram, byte[] bArr);

    public static final native long Layout_createGlyphsFromLabel__SWIG_2(long j, Layout layout, long j2, SWIGVectorParallelogram sWIGVectorParallelogram, long j3, byte[] bArr);

    public static final native long Layout_createGlyphsFromLabel__SWIG_3(long j, Layout layout, long j2, SWIGVectorGlyphLines sWIGVectorGlyphLines, long j3, SWIGVectorParallelogram sWIGVectorParallelogram, long j4, byte[] bArr);

    public static final native void Layout_erase(long j, Layout layout, long j2, Selection selection);

    public static final native long Layout_findGroupUsingCustomAttribute(long j, Layout layout, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native long Layout_getAllSelection(long j, Layout layout);

    public static final native float Layout_getFontSpaceWidth(long j, Layout layout, byte[] bArr, float f);

    public static final native long Layout_getLayoutGroup(long j, Layout layout, byte[] bArr);

    public static final native long Layout_getPage(long j, Layout layout);

    public static final native long Layout_getViewPort(long j, Layout layout);

    public static final native boolean Layout_hasFontSpaceWidth(long j, Layout layout, byte[] bArr, float f);

    public static final native boolean Layout_hasMetadata(long j, Layout layout, long j2);

    public static final native boolean Layout_hasTag(long j, Layout layout, long j2);

    public static final native boolean Layout_isAbove(long j, Layout layout, long j2, Selection selection, long j3, Selection selection2);

    public static final native boolean Layout_itemCanBeDetached(long j, LayoutItem layoutItem);

    public static final native long Layout_layoutItemObjectFromCustomAttribute__SWIG_0(long j, Layout layout, byte[] bArr, byte[] bArr2, byte[] bArr3, long j2);

    public static final native long Layout_layoutItemObjectFromCustomAttribute__SWIG_1(long j, Layout layout, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native long Layout_layoutItemObjectsFromCustomAttribute(long j, Layout layout, byte[] bArr, byte[] bArr2, long j2, Selection selection);

    public static final native long Layout_layoutItemObjectsFromMimeType(long j, Layout layout, byte[] bArr);

    public static final native long Layout_layoutItemObjectsFromUrl(long j, Layout layout, byte[] bArr);

    public static final native long Layout_makeArc__SWIG_0(long j, Layout layout, long j2, Point point, float f, float f2, float f3, float f4, float f5, byte[] bArr, byte[] bArr2, boolean z, boolean z2);

    public static final native long Layout_makeArc__SWIG_1(long j, Layout layout, long j2, Point point, float f, float f2, float f3, float f4, float f5, byte[] bArr, byte[] bArr2, boolean z);

    public static final native long Layout_makeArc__SWIG_2(long j, Layout layout, long j2, Point point, float f, float f2, float f3, float f4, float f5, byte[] bArr, byte[] bArr2);

    public static final native long Layout_makeArc__SWIG_3(long j, Layout layout, long j2, Point point, float f, float f2, float f3, float f4, float f5, byte[] bArr);

    public static final native long Layout_makeArc__SWIG_4(long j, Layout layout, long j2, CenterEllipticArc centerEllipticArc, byte[] bArr, byte[] bArr2, boolean z, boolean z2);

    public static final native long Layout_makeArc__SWIG_5(long j, Layout layout, long j2, CenterEllipticArc centerEllipticArc, byte[] bArr, byte[] bArr2, boolean z);

    public static final native long Layout_makeArc__SWIG_6(long j, Layout layout, long j2, CenterEllipticArc centerEllipticArc, byte[] bArr, byte[] bArr2);

    public static final native long Layout_makeArc__SWIG_7(long j, Layout layout, long j2, CenterEllipticArc centerEllipticArc, byte[] bArr);

    public static final native long Layout_makeGuide__SWIG_0(long j, Layout layout, byte[] bArr, long j2, GuideData guideData, byte[] bArr2, byte[] bArr3);

    public static final native long Layout_makeGuide__SWIG_1(long j, Layout layout, byte[] bArr, long j2, GuideData guideData, byte[] bArr2);

    public static final native long Layout_makeGuide__SWIG_2(long j, Layout layout, byte[] bArr, long j2, GuideData guideData, long j3, GuidePositioning guidePositioning, byte[] bArr2, byte[] bArr3);

    public static final native long Layout_makeGuide__SWIG_3(long j, Layout layout, byte[] bArr, long j2, GuideData guideData, long j3, GuidePositioning guidePositioning, byte[] bArr2);

    public static final native long Layout_makeLine__SWIG_0(long j, Layout layout, long j2, Point point, long j3, Point point2, byte[] bArr, byte[] bArr2, boolean z, boolean z2);

    public static final native long Layout_makeLine__SWIG_1(long j, Layout layout, long j2, Point point, long j3, Point point2, byte[] bArr, byte[] bArr2, boolean z);

    public static final native long Layout_makeLine__SWIG_2(long j, Layout layout, long j2, Point point, long j3, Point point2, byte[] bArr, byte[] bArr2);

    public static final native long Layout_makeLine__SWIG_3(long j, Layout layout, long j2, Point point, long j3, Point point2, byte[] bArr);

    public static final native long Layout_makePoint__SWIG_0(long j, Layout layout, long j2, Point point, byte[] bArr, byte[] bArr2);

    public static final native long Layout_makePoint__SWIG_1(long j, Layout layout, long j2, Point point, byte[] bArr);

    public static final native long Layout_makeString__SWIG_0(long j, Layout layout, long j2, Glyph glyph, byte[] bArr, byte[] bArr2);

    public static final native long Layout_makeString__SWIG_1(long j, Layout layout, long j2, Glyph glyph, byte[] bArr);

    public static final native long Layout_makeStroke__SWIG_0(long j, Layout layout, long j2, InkStroke inkStroke, byte[] bArr, byte[] bArr2);

    public static final native long Layout_makeStroke__SWIG_1(long j, Layout layout, long j2, InkStroke inkStroke, byte[] bArr);

    public static final native long Layout_makeStroke__SWIG_2(long j, Layout layout, long j2, Path path, byte[] bArr, byte[] bArr2);

    public static final native long Layout_makeStroke__SWIG_3(long j, Layout layout, long j2, Path path, byte[] bArr);

    public static final native long Layout_metadata(long j, Layout layout, long j2);

    public static final native void Layout_moveSelectionToLayer(long j, Layout layout, long j2, Selection selection, byte[] bArr);

    public static final native void Layout_pushToBack(long j, Layout layout, long j2, Selection selection);

    public static final native void Layout_removeLayer(long j, Layout layout, byte[] bArr);

    public static final native void Layout_removeObject(long j, Layout layout, byte[] bArr);

    public static final native void Layout_removeStyle(long j, Layout layout, long j2, Selection selection, byte[] bArr);

    public static final native void Layout_removeTag(long j, Layout layout, long j2);

    public static final native void Layout_removeTags(long j, Layout layout, long j2, SWIGVectorTagId sWIGVectorTagId);

    public static final native long Layout_resolveStyle__SWIG_0(long j, Layout layout, int i, byte[] bArr, byte[] bArr2);

    public static final native long Layout_resolveStyle__SWIG_1(long j, Layout layout, int i, byte[] bArr);

    public static final native void Layout_setFontSpaceWidth(long j, Layout layout, byte[] bArr, float f, float f2);

    public static final native void Layout_setLayerColor(long j, Layout layout, byte[] bArr, int i);

    public static final native void Layout_setMetadata(long j, Layout layout, long j2, long j3, Json json);

    public static final native void Layout_setViewPort(long j, Layout layout, long j2, Rectangle rectangle);

    public static final native void Layout_stackAbove(long j, Layout layout, long j2, Selection selection, long j3, Selection selection2);

    public static final native void Layout_stackUnder(long j, Layout layout, long j2, Selection selection, long j3, Selection selection2);

    public static final native long Layout_tags(long j, Layout layout, byte[] bArr);

    public static final native void Layout_transform__SWIG_0(long j, Layout layout, long j2, Selection selection, long j3, Transform transform);

    public static final native long Layout_transform__SWIG_1(long j, Layout layout, byte[] bArr);

    public static final native void Layout_updateTag__SWIG_0(long j, Layout layout, long j2, long j3, Selection selection, long j4, Json json);

    public static final native void Layout_updateTag__SWIG_1(long j, Layout layout, long j2, long j3, Selection selection);

    public static final native void Layout_updateTag__SWIG_2(long j, Layout layout, long j2, long j3, long j4, Json json);

    public static final native void Layout_updateTag__SWIG_3(long j, Layout layout, long j2, long j3);

    public static final native boolean Layout_valid(long j, Layout layout);

    public static final native long LineSegment_getP1(long j, LineSegment lineSegment);

    public static final native long LineSegment_getP2(long j, LineSegment lineSegment);

    public static final native void LineSegment_setP1(long j, LineSegment lineSegment, long j2, Point point);

    public static final native void LineSegment_setP2(long j, LineSegment lineSegment, long j2, Point point);

    public static final native long Line_Undefined_get();

    public static final native long Line_angle(long j, Line line);

    public static final native long Line_center(long j, Line line);

    public static final native float Line_distanceTo(long j, Line line, long j2, Point point);

    public static final native long Line_intersection(long j, Line line, long j2, Line line2);

    public static final native long Line_intersectorOf(long j, Rectangle rectangle, long j2, Point point, long j3);

    public static final native boolean Line_intersects__SWIG_0(long j, Line line, long j2, Rectangle rectangle);

    public static final native boolean Line_intersects__SWIG_1(long j, Line line, long j2, Line line2);

    public static final native boolean Line_isDefined(long j, Line line);

    public static final native boolean Line_isUndefined(long j, Line line);

    public static final native float Line_length(long j, Line line);

    public static final native float Line_lengthSquared(long j, Line line);

    public static final native long Line_orthogonalProjection__SWIG_0(long j, Line line, long j2, Point point, boolean z);

    public static final native long Line_orthogonalProjection__SWIG_1(long j, Line line, long j2, Point point);

    public static final native long Line_p1_get(long j, Line line);

    public static final native void Line_p1_set(long j, Line line, long j2, Point point);

    public static final native long Line_p2_get(long j, Line line);

    public static final native void Line_p2_set(long j, Line line, long j2, Point point);

    public static final native byte[] Line_toString(long j, Line line);

    public static final native void Line_translate(long j, Line line, float f, float f2);

    public static final native long Logger_getLogger();

    public static final native long Logger_get_category(long j, Logger logger);

    public static final native int Logger_get_level(long j, Logger logger);

    public static final native int Logger_indent__SWIG_0(long j, Logger logger, int i);

    public static final native int Logger_indent__SWIG_1(long j, Logger logger);

    public static final native void Logger_prefix_disable(long j, Logger logger, long j2);

    public static final native void Logger_prefix_enable(long j, Logger logger, long j2);

    public static final native long Logger_prefix_filter(long j, Logger logger);

    public static final native void Logger_print(long j, Logger logger, int i, int i2, byte[] bArr);

    public static final native void Logger_setLevel(long j, Logger logger, int i);

    public static final native void Logger_set_prefix(long j, Logger logger, long j2);

    public static final native long Logger_timestamp(long j, Logger logger);

    public static final native byte[] MATH_get();

    public static final native byte[] MIXED_get();

    public static final native long MessageIdentifierLabels_get();

    public static final native void MessageListener_notify__SWIG_0(long j, MessageListener messageListener, byte[] bArr, long j2, SWIGVectorString sWIGVectorString, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static final native void MessageListener_notify__SWIG_1(long j, MessageListener messageListener, byte[] bArr, long j2, SWIGVectorString sWIGVectorString, byte[] bArr2, byte[] bArr3);

    public static final native void MessageListener_notify__SWIG_2(long j, MessageListener messageListener, byte[] bArr, long j2, SWIGVectorString sWIGVectorString, byte[] bArr2);

    public static final native void MessageListener_notify__SWIG_3(long j, MessageListener messageListener, byte[] bArr, long j2, SWIGVectorString sWIGVectorString);

    public static final native void MessageListener_notify__SWIG_4(long j, MessageListener messageListener, byte[] bArr, int i, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static final native void MessageListener_notify__SWIG_5(long j, MessageListener messageListener, byte[] bArr, int i, byte[] bArr2, byte[] bArr3);

    public static final native void MessageListener_notify__SWIG_6(long j, MessageListener messageListener, byte[] bArr, int i, byte[] bArr2);

    public static final native void MessageListener_notify__SWIG_7(long j, MessageListener messageListener, byte[] bArr, int i);

    public static final native long MessageNotifier_SWIGUpcast(long j);

    public static final native void MessageNotifier_addMessageListener(long j, MessageNotifier messageNotifier, long j2);

    public static final native void MessageNotifier_notify__SWIG_0(long j, MessageNotifier messageNotifier, byte[] bArr, long j2, SWIGVectorString sWIGVectorString, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static final native void MessageNotifier_notify__SWIG_1(long j, MessageNotifier messageNotifier, byte[] bArr, long j2, SWIGVectorString sWIGVectorString, byte[] bArr2, byte[] bArr3);

    public static final native void MessageNotifier_notify__SWIG_2(long j, MessageNotifier messageNotifier, byte[] bArr, long j2, SWIGVectorString sWIGVectorString, byte[] bArr2);

    public static final native void MessageNotifier_notify__SWIG_3(long j, MessageNotifier messageNotifier, byte[] bArr, long j2, SWIGVectorString sWIGVectorString);

    public static final native void MessageNotifier_notify__SWIG_4(long j, MessageNotifier messageNotifier, byte[] bArr, int i, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static final native void MessageNotifier_notify__SWIG_5(long j, MessageNotifier messageNotifier, byte[] bArr, int i, byte[] bArr2, byte[] bArr3);

    public static final native void MessageNotifier_notify__SWIG_6(long j, MessageNotifier messageNotifier, byte[] bArr, int i, byte[] bArr2);

    public static final native void MessageNotifier_notify__SWIG_7(long j, MessageNotifier messageNotifier, byte[] bArr, int i);

    public static final native void MessageNotifier_removeMessageListener(long j, MessageNotifier messageNotifier, long j2);

    public static final native long MotionEventPredictor_getNumIterations(long j, MotionEventPredictor motionEventPredictor);

    public static final native long MotionEventPredictor_getPointerId(long j, MotionEventPredictor motionEventPredictor);

    public static final native long MotionEventPredictor_predict(long j, MotionEventPredictor motionEventPredictor, long j2);

    public static final native void MotionEventPredictor_record(long j, MotionEventPredictor motionEventPredictor, long j2, MotionEvent motionEvent);

    public static final native void MotionEventPredictor_reset(long j, MotionEventPredictor motionEventPredictor);

    public static final native void MotionEventPredictor_setPointerId(long j, MotionEventPredictor motionEventPredictor, long j2);

    public static final native void MotionEventPredictor_setWritingModeParams(long j, MotionEventPredictor motionEventPredictor, double d, double d2, long j2, long j3);

    public static final native long MotionEvent_t_get(long j, MotionEvent motionEvent);

    public static final native void MotionEvent_t_set(long j, MotionEvent motionEvent, long j2);

    public static final native double MotionEvent_x_get(long j, MotionEvent motionEvent);

    public static final native void MotionEvent_x_set(long j, MotionEvent motionEvent, double d);

    public static final native double MotionEvent_y_get(long j, MotionEvent motionEvent);

    public static final native void MotionEvent_y_set(long j, MotionEvent motionEvent, double d);

    public static final native double MotionFilter_getAcceleration(long j, MotionFilter motionFilter, double d);

    public static final native double MotionFilter_getContinuity(long j, MotionFilter motionFilter, double d);

    public static final native double MotionFilter_getCurvature(long j, MotionFilter motionFilter, double d);

    public static final native long MotionFilter_getIterationDelta(long j, MotionFilter motionFilter);

    public static final native long MotionFilter_getIterations(long j, MotionFilter motionFilter);

    public static final native double MotionFilter_getJank(long j, MotionFilter motionFilter, double d, double d2);

    public static final native long MotionFilter_getLastPosition(long j, MotionFilter motionFilter);

    public static final native long MotionFilter_getLastPositions(long j, MotionFilter motionFilter);

    public static final native long MotionFilter_getPredictionVelocity(long j, MotionFilter motionFilter, double d);

    public static final native double MotionFilter_getVelocity(long j, MotionFilter motionFilter, double d);

    public static final native boolean MotionFilter_isReady(long j, MotionFilter motionFilter);

    public static final native void MotionFilter_reset(long j, MotionFilter motionFilter);

    public static final native void MotionFilter_update(long j, MotionFilter motionFilter, double d, double d2);

    public static final native long MotionPredictionParams_durationMs_get(long j, MotionPredictionParams motionPredictionParams);

    public static final native void MotionPredictionParams_durationMs_set(long j, MotionPredictionParams motionPredictionParams, long j2);

    public static final native boolean MotionPredictionParams_enabled_get(long j, MotionPredictionParams motionPredictionParams);

    public static final native void MotionPredictionParams_enabled_set(long j, MotionPredictionParams motionPredictionParams, boolean z);

    public static final native boolean MotionPredictionParams_showPredictionInRed_get(long j, MotionPredictionParams motionPredictionParams);

    public static final native void MotionPredictionParams_showPredictionInRed_set(long j, MotionPredictionParams motionPredictionParams, boolean z);

    public static final native double MotionPredictionParams_writingModeFactor_get(long j, MotionPredictionParams motionPredictionParams);

    public static final native void MotionPredictionParams_writingModeFactor_set(long j, MotionPredictionParams motionPredictionParams, double d);

    public static final native double MotionPredictionParams_writingModeLength_get(long j, MotionPredictionParams motionPredictionParams);

    public static final native void MotionPredictionParams_writingModeLength_set(long j, MotionPredictionParams motionPredictionParams, double d);

    public static final native long MotionPredictionParams_writingModeMaxCount_get(long j, MotionPredictionParams motionPredictionParams);

    public static final native void MotionPredictionParams_writingModeMaxCount_set(long j, MotionPredictionParams motionPredictionParams, long j2);

    public static final native long MotionPredictionParams_writingModeMinCount_get(long j, MotionPredictionParams motionPredictionParams);

    public static final native void MotionPredictionParams_writingModeMinCount_set(long j, MotionPredictionParams motionPredictionParams, long j2);

    public static final native byte[] NODE_get();

    public static final native byte[] NOTHING_get();

    public static final native byte[] PDF_get();

    public static final native byte[] PLACEHOLDER_get();

    public static final native long PageFormat_build(int i);

    public static final native int PageFormat_formatsFromLocale(boolean z);

    public static final native float PageFormat_marginBottom_get(long j, PageFormat pageFormat);

    public static final native void PageFormat_marginBottom_set(long j, PageFormat pageFormat, float f);

    public static final native float PageFormat_marginLeft_get(long j, PageFormat pageFormat);

    public static final native void PageFormat_marginLeft_set(long j, PageFormat pageFormat, float f);

    public static final native float PageFormat_marginRight_get(long j, PageFormat pageFormat);

    public static final native void PageFormat_marginRight_set(long j, PageFormat pageFormat, float f);

    public static final native float PageFormat_marginTop_get(long j, PageFormat pageFormat);

    public static final native void PageFormat_marginTop_set(long j, PageFormat pageFormat, float f);

    public static final native float PageFormat_pageHeight_get(long j, PageFormat pageFormat);

    public static final native void PageFormat_pageHeight_set(long j, PageFormat pageFormat, float f);

    public static final native float PageFormat_pageWidth_get(long j, PageFormat pageFormat);

    public static final native void PageFormat_pageWidth_set(long j, PageFormat pageFormat, float f);

    public static final native void Page_addConfigurationListener(long j, Page page, long j2);

    public static final native void Page_applyConfigurationChangeset(long j, Page page, long j2, Json json);

    public static final native boolean Page_canRedo(long j, Page page);

    public static final native boolean Page_canUndo(long j, Page page);

    public static final native long Page_configuration(long j, Page page);

    public static final native long Page_createTemporaryClone(long j, Page page);

    public static final native long Page_document(long j, Page page);

    public static final native int Page_getConfigurationType(long j, Page page, byte[] bArr, byte[] bArr2);

    public static final native long Page_getContent__SWIG_0(long j, Page page);

    public static final native long Page_getContent__SWIG_1(long j, Page page, long j2);

    public static final native byte[] Page_getId(long j, Page page);

    public static final native long Page_getLayout(long j, Page page);

    public static final native long Page_getMetadata(long j, Page page);

    public static final native long Page_getObjectManager(long j, Page page);

    public static final native byte[] Page_getStyleSheet(long j, Page page);

    public static final native long Page_getTextStructureProvider(long j, Page page);

    public static final native int Page_hashCode(long j, Page page);

    public static final native long Page_ink(long j, Page page);

    public static final native boolean Page_isInitialized(long j, Page page);

    public static final native long Page_loadFromSerializedPath(byte[] bArr);

    public static final native long Page_metadataOverride(long j, Page page);

    public static final native boolean Page_nativeEquals(long j, Page page, long j2, Page page2);

    public static final native long Page_paste(long j, Page page, long j2, Selection selection);

    public static final native boolean Page_preventUndo(long j, Page page);

    public static final native boolean Page_redo(long j, Page page);

    public static final native void Page_removeConfigurationListener(long j, Page page, long j2);

    public static final native byte[] Page_serializePath(long j, Page page);

    public static final native void Page_setMetadata(long j, Page page, long j2, Json json);

    public static final native void Page_setMetadataOverride(long j, Page page, long j2, Json json);

    public static final native void Page_setObjectManager(long j, Page page, long j2);

    public static final native void Page_setStyleSheetFromFile(long j, Page page, byte[] bArr);

    public static final native void Page_setStyleSheetFromString(long j, Page page, byte[] bArr);

    public static final native void Page_setTextStructureProvider(long j, Page page, long j2);

    public static final native void Page_setTheme(long j, Page page, byte[] bArr);

    public static final native byte[] Page_theme(long j, Page page);

    public static final native byte[] Page_toString(long j, Page page);

    public static final native boolean Page_undo(long j, Page page);

    public static final native boolean Page_valid(long j, Page page);

    public static final native float Parallelogram_ux_get(long j, Parallelogram parallelogram);

    public static final native void Parallelogram_ux_set(long j, Parallelogram parallelogram, float f);

    public static final native float Parallelogram_uy_get(long j, Parallelogram parallelogram);

    public static final native void Parallelogram_uy_set(long j, Parallelogram parallelogram, float f);

    public static final native float Parallelogram_vx_get(long j, Parallelogram parallelogram);

    public static final native void Parallelogram_vx_set(long j, Parallelogram parallelogram, float f);

    public static final native float Parallelogram_vy_get(long j, Parallelogram parallelogram);

    public static final native void Parallelogram_vy_set(long j, Parallelogram parallelogram, float f);

    public static final native float Parallelogram_x_get(long j, Parallelogram parallelogram);

    public static final native void Parallelogram_x_set(long j, Parallelogram parallelogram, float f);

    public static final native float Parallelogram_y_get(long j, Parallelogram parallelogram);

    public static final native void Parallelogram_y_set(long j, Parallelogram parallelogram, float f);

    public static final native long PathToStrokeOffsets_fromRawStroke_get(long j, PathToStrokeOffsets pathToStrokeOffsets);

    public static final native void PathToStrokeOffsets_fromRawStroke_set(long j, PathToStrokeOffsets pathToStrokeOffsets, long j2, StrokeOffsets strokeOffsets);

    public static final native long PathToStrokeOffsets_strokeOrientationAtBegin_get(long j, PathToStrokeOffsets pathToStrokeOffsets);

    public static final native void PathToStrokeOffsets_strokeOrientationAtBegin_set(long j, PathToStrokeOffsets pathToStrokeOffsets, long j2);

    public static final native long PathToStrokeOffsets_timingsFromRawStroke_get(long j, PathToStrokeOffsets pathToStrokeOffsets);

    public static final native void PathToStrokeOffsets_timingsFromRawStroke_set(long j, PathToStrokeOffsets pathToStrokeOffsets, long j2, TimingOffsets timingOffsets);

    public static final native long PathToStrokeOffsets_toInkStroke_get(long j, PathToStrokeOffsets pathToStrokeOffsets);

    public static final native void PathToStrokeOffsets_toInkStroke_set(long j, PathToStrokeOffsets pathToStrokeOffsets, long j2, StrokeOffsets strokeOffsets);

    public static final native long Path_accessPoints(long j, Path path);

    public static final native float Path_area(long j, Path path);

    public static final native long Path_centroid(long j, Path path);

    public static final native void Path_chop(long j, Path path);

    public static final native void Path_clear(long j, Path path);

    public static final native void Path_close(long j, Path path);

    public static final native boolean Path_closed(long j, Path path);

    public static final native long Path_closestPoint(long j, Path path, long j2, Point point);

    public static final native boolean Path_compareFloat(float f, float f2);

    public static final native long Path_concat(long j);

    public static final native boolean Path_continuous(long j, Path path);

    public static final native long Path_convexHullSpaced__SWIG_0(long j, Path path, float f);

    public static final native long Path_convexHullSpaced__SWIG_1(long j, Path path);

    public static final native float Path_distanceTo(long j, Path path, long j2, Point point);

    public static final native boolean Path_empty(long j, Path path);

    public static final native void Path_endTo__SWIG_0(long j, Path path, long j2, PointerInfo pointerInfo);

    public static final native void Path_endTo__SWIG_1(long j, Path path, long j2, Point point);

    public static final native void Path_endTo__SWIG_2(long j, Path path, float f, float f2);

    public static final native boolean Path_fitsInRectangles__SWIG_0(long j, Path path, long j2, SWIGRectangleList sWIGRectangleList, boolean z);

    public static final native boolean Path_fitsInRectangles__SWIG_1(long j, Path path, long j2, SWIGRectangleList sWIGRectangleList);

    public static final native long Path_fromExtent(long j, Extent extent);

    public static final native long Path_fromLine(long j, Line line);

    public static final native long Path_fromPointerInfos(long j, SWIGVectorPointerInfo sWIGVectorPointerInfo);

    public static final native long Path_fromPoints(long j, SWIGVectorPoint sWIGVectorPoint);

    public static final native long Path_fromRectangle(long j, Rectangle rectangle);

    public static final native long Path_get(long j, Path path, int i);

    public static final native long Path_getBack(long j, Path path);

    public static final native long Path_getBoundingRect(long j, Path path);

    public static final native float Path_getClosingDistance(long j, Path path);

    public static final native long Path_getConvexHull(long j, Path path);

    public static final native float Path_getDistance(long j, Path path);

    public static final native long Path_getFront(long j, Path path);

    public static final native int Path_getLength(long j, Path path);

    public static final native boolean Path_hasGap(long j, Path path);

    public static final native boolean Path_hasPointsInside(long j, Path path, long j2, Rectangle rectangle);

    public static final native boolean Path_hasTiltAndOrientation(long j, Path path);

    public static final native int Path_hashCode(long j, Path path);

    public static final native boolean Path_isGap(long j, Path path, long j2);

    public static final native void Path_lineTo__SWIG_0(long j, Path path, long j2, PointerInfo pointerInfo);

    public static final native void Path_lineTo__SWIG_1(long j, Path path, long j2, Point point);

    public static final native void Path_lineTo__SWIG_2(long j, Path path, float f, float f2);

    public static final native void Path_linesTo(long j, Path path, long j2, SWIGVectorPointerInfo sWIGVectorPointerInfo);

    public static final native void Path_makeGap(long j, Path path);

    public static final native long Path_mapped(long j, Path path, long j2, Transform transform);

    public static final native void Path_moveTo(long j, Path path, long j2, PointerInfo pointerInfo);

    public static final native boolean Path_nativeEquals(long j, Path path, long j2, Path path2);

    public static final native long Path_pointAt(long j, Path path, int i);

    public static final native long Path_points(long j, Path path);

    public static final native long Path_resample(long j, Path path, int i, float f);

    public static final native void Path_reserve(long j, Path path, int i);

    public static final native void Path_startAt__SWIG_0(long j, Path path, long j2, PointerInfo pointerInfo);

    public static final native void Path_startAt__SWIG_1(long j, Path path, long j2, Point point);

    public static final native void Path_startAt__SWIG_2(long j, Path path, float f, float f2);

    public static final native boolean Path_strokeFinished(long j, Path path);

    public static final native long Path_subPaths(long j, Path path);

    public static final native boolean Path_surrounds(long j, Path path, long j2, Point point);

    public static final native void Path_toInkPoints(long j, Path path, long j2, PathToStrokeOffsets pathToStrokeOffsets, long j3, long j4, long j5, long j6, long j7, long j8);

    public static final native long Path_toPoints(long j, Path path);

    public static final native byte[] Path_toString(long j, Path path);

    public static final native int PendingStroke_button_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_button_set(long j, PendingStroke pendingStroke, int i);

    public static final native long PendingStroke_captureView_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_captureView_set(long j, PendingStroke pendingStroke, long j2);

    public static final native void PendingStroke_discard(long j, PendingStroke pendingStroke);

    public static final native float PendingStroke_extentOffset_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_extentOffset_set(long j, PendingStroke pendingStroke, float f);

    public static final native int PendingStroke_inkSamplerIndex_get(long j, PendingStroke pendingStroke);

    public static final native long PendingStroke_inkStrokeId_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_inkStrokeId_set(long j, PendingStroke pendingStroke, long j2);

    public static final native byte[] PendingStroke_layer_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_layer_set(long j, PendingStroke pendingStroke, byte[] bArr);

    public static final native byte[] PendingStroke_overrideStyle_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_overrideStyle_set(long j, PendingStroke pendingStroke, byte[] bArr);

    public static final native long PendingStroke_pendingStrokeId_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_pendingStrokeId_set(long j, PendingStroke pendingStroke, long j2);

    public static final native int PendingStroke_pointerId_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_pointerId_set(long j, PendingStroke pendingStroke, int i);

    public static final native int PendingStroke_strokeState_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_strokeState_set(long j, PendingStroke pendingStroke, int i);

    public static final native long PendingStroke_stroke_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_stroke_set(long j, PendingStroke pendingStroke, long j2, InkStroke inkStroke);

    public static final native byte[] PendingStroke_styleSelector_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_styleSelector_set(long j, PendingStroke pendingStroke, byte[] bArr);

    public static final native long PendingStroke_style_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_style_set(long j, PendingStroke pendingStroke, long j2, InkStyle inkStyle);

    public static final native boolean PendingStroke_syncRefreshWithTemporaries_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_syncRefreshWithTemporaries_set(long j, PendingStroke pendingStroke, boolean z);

    public static final native int PendingStroke_type_get(long j, PendingStroke pendingStroke);

    public static final native void PendingStroke_type_set(long j, PendingStroke pendingStroke, int i);

    public static final native long Point_Origin_get();

    public static final native long Point_Undefined_get();

    public static final native void Point_add(long j, Point point, int i, float f);

    public static final native boolean Point_almostEqualsRelatively(long j, Point point, long j2, Point point2, float f, float f2);

    public static final native boolean Point_almostEquals__SWIG_0(long j, Point point, long j2, Point point2, float f);

    public static final native boolean Point_almostEquals__SWIG_1(long j, Point point, long j2, Point point2);

    public static final native long Point_angle(long j, Point point);

    public static final native void Point_assign(long j, Point point, int i, float f);

    public static final native float Point_coord(long j, Point point, int i);

    public static final native float Point_distanceTo(long j, Point point, long j2, Point point2);

    public static final native float Point_getX(long j, Point point);

    public static final native float Point_getY(long j, Point point);

    public static final native int Point_hashCode(long j, Point point);

    public static final native boolean Point_isDefined(long j, Point point);

    public static final native boolean Point_isUndefined(long j, Point point);

    public static final native float Point_length(long j, Point point);

    public static final native float Point_lengthSquared(long j, Point point);

    public static final native float Point_manhattanLength(long j, Point point);

    public static final native long Point_middle(long j, Point point, long j2, Point point2);

    public static final native boolean Point_nativeEquals(long j, Point point, long j2, Point point2);

    public static final native float Point_norm(long j, Point point);

    public static final native long Point_normalized(long j, Point point);

    public static final native void Point_rotate__SWIG_0(long j, Point point, double d);

    public static final native void Point_rotate__SWIG_1(long j, Point point, long j2);

    public static final native long Point_rotated__SWIG_0(long j, Point point, double d);

    public static final native long Point_rotated__SWIG_1(long j, Point point, long j2);

    public static final native void Point_set(long j, Point point, float f, float f2);

    public static final native void Point_setX(long j, Point point, float f);

    public static final native void Point_setY(long j, Point point, float f);

    public static final native boolean Point_strictlyEquals(long j, Point point, long j2, Point point2);

    public static final native byte[] Point_toString(long j, Point point);

    public static final native void Point_translate(long j, Point point, float f, float f2);

    public static final native long Point_translated(long j, Point point, float f, float f2);

    public static final native int PointerInfoData_button_get(long j, PointerInfoData pointerInfoData);

    public static final native void PointerInfoData_button_set(long j, PointerInfoData pointerInfoData, int i);

    public static final native float PointerInfoData_f_get(long j, PointerInfoData pointerInfoData);

    public static final native void PointerInfoData_f_set(long j, PointerInfoData pointerInfoData, float f);

    public static final native long PointerInfoData_flags_get(long j, PointerInfoData pointerInfoData);

    public static final native void PointerInfoData_flags_set(long j, PointerInfoData pointerInfoData, long j2);

    public static final native int PointerInfoData_id_get(long j, PointerInfoData pointerInfoData);

    public static final native void PointerInfoData_id_set(long j, PointerInfoData pointerInfoData, int i);

    public static final native float PointerInfoData_orientation_get(long j, PointerInfoData pointerInfoData);

    public static final native void PointerInfoData_orientation_set(long j, PointerInfoData pointerInfoData, float f);

    public static final native long PointerInfoData_t_get(long j, PointerInfoData pointerInfoData);

    public static final native void PointerInfoData_t_set(long j, PointerInfoData pointerInfoData, long j2);

    public static final native float PointerInfoData_tilt_get(long j, PointerInfoData pointerInfoData);

    public static final native void PointerInfoData_tilt_set(long j, PointerInfoData pointerInfoData, float f);

    public static final native int PointerInfoData_type_get(long j, PointerInfoData pointerInfoData);

    public static final native void PointerInfoData_type_set(long j, PointerInfoData pointerInfoData, int i);

    public static final native float PointerInfoData_x_get(long j, PointerInfoData pointerInfoData);

    public static final native void PointerInfoData_x_set(long j, PointerInfoData pointerInfoData, float f);

    public static final native float PointerInfoData_y_get(long j, PointerInfoData pointerInfoData);

    public static final native void PointerInfoData_y_set(long j, PointerInfoData pointerInfoData, float f);

    public static final native long PointerInfo_SWIGUpcast(long j);

    public static final native long PointerInfo_Undefined_get();

    public static final native void PointerInfo_add(long j, PointerInfo pointerInfo, int i, float f);

    public static final native void PointerInfo_assign(long j, PointerInfo pointerInfo, int i, float f);

    public static final native float PointerInfo_coord(long j, PointerInfo pointerInfo, int i);

    public static final native boolean PointerInfo_hasTiltAndOrientation(long j, PointerInfo pointerInfo);

    public static final native int PointerInfo_hashCode(long j, PointerInfo pointerInfo);

    public static final native long PointerInfo_interpolate(float f, long j, PointerInfo pointerInfo, long j2, PointerInfo pointerInfo2);

    public static final native boolean PointerInfo_isDefined(long j, PointerInfo pointerInfo);

    public static final native boolean PointerInfo_isUndefined(long j, PointerInfo pointerInfo);

    public static final native boolean PointerInfo_isValidOrientation(float f);

    public static final native boolean PointerInfo_isValidTilt(float f);

    public static final native boolean PointerInfo_nativeEquals(long j, PointerInfo pointerInfo, long j2, PointerInfo pointerInfo2);

    public static final native boolean PointerInfo_pointAlmostEquals(long j, PointerInfo pointerInfo, long j2, PointerInfo pointerInfo2);

    public static final native long PointerInfo_setButtonType(long j, PointerInfo pointerInfo, int i);

    public static final native long PointerInfo_setForce(long j, PointerInfo pointerInfo, float f);

    public static final native long PointerInfo_setOrientationAngle(long j, PointerInfo pointerInfo, float f);

    public static final native long PointerInfo_setPointerId(long j, PointerInfo pointerInfo, int i);

    public static final native long PointerInfo_setPointerType(long j, PointerInfo pointerInfo, int i);

    public static final native long PointerInfo_setPosition__SWIG_0(long j, PointerInfo pointerInfo, float f, float f2);

    public static final native long PointerInfo_setPosition__SWIG_1(long j, PointerInfo pointerInfo, long j2, Point point);

    public static final native long PointerInfo_setTiltAngle(long j, PointerInfo pointerInfo, float f);

    public static final native long PointerInfo_setTimestamp(long j, PointerInfo pointerInfo, long j2);

    public static final native byte[] PointerInfo_toString(long j, PointerInfo pointerInfo);

    public static final native long PointerInfo_withF(long j, PointerInfoData pointerInfoData, float f);

    public static final native long PointerTypeLabels_get();

    public static final native long PointerTypeSetLabels_get();

    public static final native long PointerTypeSetMasks_get();

    public static final native byte[] RAW_CONTENT_get();

    public static final native long Rectangle_Undefined_get();

    public static final native void Rectangle_add__SWIG_0(long j, Rectangle rectangle, long j2, Rectangle rectangle2);

    public static final native void Rectangle_add__SWIG_1(long j, Rectangle rectangle, long j2, SWIGRectangleList sWIGRectangleList);

    public static final native void Rectangle_adjust(long j, Rectangle rectangle, float f, float f2, float f3, float f4);

    public static final native long Rectangle_adjusted(long j, Rectangle rectangle, float f, float f2, float f3, float f4);

    public static final native boolean Rectangle_almostEquals__SWIG_0(long j, Rectangle rectangle, long j2, Rectangle rectangle2, float f);

    public static final native boolean Rectangle_almostEquals__SWIG_1(long j, Rectangle rectangle, long j2, Rectangle rectangle2);

    public static final native float Rectangle_aspectRatio(long j, Rectangle rectangle);

    public static final native void Rectangle_clip(long j, Rectangle rectangle, long j2, SemiAxis semiAxis);

    public static final native long Rectangle_clipped(long j, Rectangle rectangle, long j2, SemiAxis semiAxis);

    public static final native boolean Rectangle_contains__SWIG_0(long j, Rectangle rectangle, long j2, Point point);

    public static final native boolean Rectangle_contains__SWIG_1(long j, Rectangle rectangle, float f, float f2);

    public static final native boolean Rectangle_contains__SWIG_2(long j, Rectangle rectangle, long j2, Rectangle rectangle2);

    public static final native boolean Rectangle_fitTo(long j, Rectangle rectangle, long j2, Rectangle rectangle2, int i);

    public static final native long Rectangle_forceInside__SWIG_0(long j, Rectangle rectangle, long j2, Point point);

    public static final native long Rectangle_forceInside__SWIG_1(long j, Rectangle rectangle, long j2, Rectangle rectangle2);

    public static final native long Rectangle_fromExtentEx(long j, Extent extent);

    public static final native long Rectangle_fromPoints(long j, SWIGVectorPoint sWIGVectorPoint);

    public static final native float Rectangle_getBottom(long j, Rectangle rectangle);

    public static final native long Rectangle_getBottomLeft(long j, Rectangle rectangle);

    public static final native long Rectangle_getBottomRight(long j, Rectangle rectangle);

    public static final native long Rectangle_getCenter(long j, Rectangle rectangle);

    public static final native float Rectangle_getHeight(long j, Rectangle rectangle);

    public static final native float Rectangle_getLeft(long j, Rectangle rectangle);

    public static final native float Rectangle_getRight(long j, Rectangle rectangle);

    public static final native float Rectangle_getTop(long j, Rectangle rectangle);

    public static final native long Rectangle_getTopLeft(long j, Rectangle rectangle);

    public static final native long Rectangle_getTopRight(long j, Rectangle rectangle);

    public static final native float Rectangle_getWidth(long j, Rectangle rectangle);

    public static final native int Rectangle_hashCode(long j, Rectangle rectangle);

    public static final native void Rectangle_inset(long j, Rectangle rectangle, float f, float f2);

    public static final native long Rectangle_intersected(long j, Rectangle rectangle, long j2, Rectangle rectangle2);

    public static final native boolean Rectangle_intersects(long j, Rectangle rectangle, long j2, Rectangle rectangle2);

    public static final native boolean Rectangle_isDefined(long j, Rectangle rectangle);

    public static final native boolean Rectangle_isEmpty(long j, Rectangle rectangle);

    public static final native boolean Rectangle_isPoint(long j, Rectangle rectangle);

    public static final native boolean Rectangle_isUndefined(long j, Rectangle rectangle);

    public static final native long Rectangle_midBottom(long j, Rectangle rectangle);

    public static final native long Rectangle_midLeft(long j, Rectangle rectangle);

    public static final native long Rectangle_midRight(long j, Rectangle rectangle);

    public static final native long Rectangle_midTop(long j, Rectangle rectangle);

    public static final native boolean Rectangle_nativeEquals(long j, Rectangle rectangle, long j2, Rectangle rectangle2);

    public static final native boolean Rectangle_strictlyEquals(long j, Rectangle rectangle, long j2, Rectangle rectangle2);

    public static final native byte[] Rectangle_toString(long j, Rectangle rectangle);

    public static final native void Rectangle_translate__SWIG_0(long j, Rectangle rectangle, float f, float f2);

    public static final native void Rectangle_translate__SWIG_1(long j, Rectangle rectangle, long j2, Point point);

    public static final native long Rectangle_translated__SWIG_0(long j, Rectangle rectangle, float f, float f2);

    public static final native long Rectangle_translated__SWIG_1(long j, Rectangle rectangle, long j2, Point point);

    public static final native long Rectangle_unitedEx(long j, Rectangle rectangle, long j2, Rectangle rectangle2);

    public static final native long Rectangle_united__SWIG_0(long j, Rectangle rectangle, long j2, Rectangle rectangle2);

    public static final native long Rectangle_united__SWIG_1(long j, Rectangle rectangle, long j2, Point point);

    public static final native long Renderer_addTemporaries__SWIG_0(long j, Renderer renderer, long j2, long j3, Extent extent, long j4, Transform transform, int i, float f, boolean z, float f2, boolean z2, boolean z3);

    public static final native long Renderer_addTemporaries__SWIG_1(long j, Renderer renderer, long j2, long j3, Extent extent, long j4, Transform transform, int i, float f, boolean z, float f2, boolean z2);

    public static final native long Renderer_addTemporaries__SWIG_2(long j, Renderer renderer, long j2, long j3, Extent extent, long j4, Transform transform, int i, float f, boolean z, float f2);

    public static final native long Renderer_addTemporaries__SWIG_3(long j, Renderer renderer, long j2, long j3, Extent extent, long j4, Transform transform, int i, float f, boolean z);

    public static final native long Renderer_addTemporaries__SWIG_4(long j, Renderer renderer, long j2, long j3, Extent extent, long j4, Transform transform, int i, float f);

    public static final native long Renderer_addTemporaries__SWIG_5(long j, Renderer renderer, long j2, long j3, Extent extent, long j4, Transform transform, int i);

    public static final native long Renderer_addTemporaries__SWIG_6(long j, Renderer renderer, long j2, long j3, Extent extent, long j4, Transform transform);

    public static final native long Renderer_addTemporaries__SWIG_7(long j, Renderer renderer, long j2, long j3, Extent extent);

    public static final native long Renderer_addTemporary__SWIG_0(long j, Renderer renderer, long j2, LayoutItem layoutItem, long j3, Transform transform, int i, float f, float f2, boolean z, boolean z2);

    public static final native long Renderer_addTemporary__SWIG_1(long j, Renderer renderer, long j2, LayoutItem layoutItem, long j3, Transform transform, int i, float f, float f2, boolean z);

    public static final native long Renderer_addTemporary__SWIG_2(long j, Renderer renderer, long j2, LayoutItem layoutItem, long j3, Transform transform, int i, float f, float f2);

    public static final native long Renderer_addTemporary__SWIG_3(long j, Renderer renderer, long j2, LayoutItem layoutItem, long j3, Transform transform, int i, float f);

    public static final native long Renderer_addTemporary__SWIG_4(long j, Renderer renderer, long j2, LayoutItem layoutItem, long j3, Transform transform, int i);

    public static final native long Renderer_addTemporary__SWIG_5(long j, Renderer renderer, long j2, LayoutItem layoutItem, long j3, Transform transform);

    public static final native long Renderer_addTemporary__SWIG_6(long j, Renderer renderer, long j2, LayoutItem layoutItem);

    public static final native void Renderer_addToCutSelection(long j, Renderer renderer, long j2, Selection selection);

    public static final native void Renderer_applyAnimation(long j, Renderer renderer, long j2, long j3);

    public static final native long Renderer_clampExtentToViewPort__SWIG_0(long j, Renderer renderer, long j2, Extent extent, float f, float f2);

    public static final native long Renderer_clampExtentToViewPort__SWIG_1(long j, Renderer renderer, long j2, Extent extent, float f);

    public static final native long Renderer_clampExtentToViewPort__SWIG_2(long j, Renderer renderer, long j2, Extent extent);

    public static final native void Renderer_drawCapture__SWIG_0(long j, Renderer renderer, long j2, Extent extent, Object obj);

    public static final native void Renderer_drawCapture__SWIG_1(long j, Renderer renderer, long j2, Extent extent);

    public static final native void Renderer_drawSync__SWIG_0(long j, Renderer renderer, long j2, Extent extent, int i, Object obj);

    public static final native void Renderer_drawSync__SWIG_1(long j, Renderer renderer, long j2, Extent extent, int i);

    public static final native void Renderer_drawWithoutOffscreenRendering__SWIG_0(long j, Renderer renderer, long j2, Extent extent, int i, Object obj);

    public static final native void Renderer_drawWithoutOffscreenRendering__SWIG_1(long j, Renderer renderer, long j2, Extent extent, int i);

    public static final native void Renderer_draw__SWIG_0(long j, Renderer renderer, long j2, Extent extent, int i, Object obj);

    public static final native void Renderer_draw__SWIG_1(long j, Renderer renderer, long j2, Extent extent, int i);

    public static final native void Renderer_endIntensiveOperations(long j, Renderer renderer);

    public static final native void Renderer_forceRedraw(long j, Renderer renderer);

    public static final native long Renderer_getLayout(long j, Renderer renderer);

    public static final native long Renderer_getTemporaryTransform(long j, Renderer renderer, long j2);

    public static final native boolean Renderer_hasCaptureStrokes__SWIG_0(long j, Renderer renderer, boolean z);

    public static final native boolean Renderer_hasCaptureStrokes__SWIG_1(long j, Renderer renderer);

    public static final native boolean Renderer_isUserWriting(long j, Renderer renderer);

    public static final native long Renderer_newRef(long j, Renderer renderer);

    public static final native void Renderer_pauseRendering__SWIG_0(long j, Renderer renderer, boolean z);

    public static final native void Renderer_pauseRendering__SWIG_1(long j, Renderer renderer);

    public static final native void Renderer_recreateDrawingSurfaces(long j, Renderer renderer);

    public static final native void Renderer_removeFromCutSelection(long j, Renderer renderer, long j2, Selection selection);

    public static final native void Renderer_removeTemporary(long j, Renderer renderer, long j2);

    public static final native void Renderer_resfreshTemporary(long j, Renderer renderer, long j2);

    public static final native void Renderer_restrictToLayers(long j, Renderer renderer, long j2, SWIGVectorString sWIGVectorString);

    public static final native void Renderer_resumeRendering(long j, Renderer renderer);

    public static final native void Renderer_setTempClipArea(long j, Renderer renderer, long j2, Extent extent);

    public static final native void Renderer_setView(long j, Renderer renderer, IPageView iPageView, long j2, ViewTransform viewTransform, byte[] bArr);

    public static final native void Renderer_setViewport(long j, Renderer renderer, long j2, Extent extent, long j3, ViewTransform viewTransform, boolean z);

    public static final native void Renderer_startIntensiveOperations(long j, Renderer renderer);

    public static final native long Renderer_tilesManager(long j, Renderer renderer);

    public static final native void Renderer_updateTemporary__SWIG_0(long j, Renderer renderer, long j2, float f);

    public static final native void Renderer_updateTemporary__SWIG_1(long j, Renderer renderer, long j2, long j3, Transform transform);

    public static final native void Renderer_updateTemporary__SWIG_2(long j, Renderer renderer, long j2, long j3, Transform transform, int i, float f);

    public static final native void Renderer_updateTemporary__SWIG_3(long j, Renderer renderer, long j2, long j3, Transform transform, int i);

    public static final native void Renderer_updateTemporary__SWIG_4(long j, Renderer renderer, long j2, long j3, LayoutItem layoutItem);

    public static final native void Renderer_useTiles(long j, Renderer renderer, long j2);

    public static final native long Renderer_viewTransform__SWIG_0(long j, Renderer renderer, boolean z);

    public static final native long Renderer_viewTransform__SWIG_1(long j, Renderer renderer);

    public static final native byte[] SHAPE_get();

    public static final native byte[] SNAP_get();

    public static final native long SWIGGlyphMetricsList_at(long j, SWIGGlyphMetricsList sWIGGlyphMetricsList, int i);

    public static final native void SWIGGlyphMetricsList_push_back(long j, SWIGGlyphMetricsList sWIGGlyphMetricsList, long j2, GlyphMetrics glyphMetrics);

    public static final native int SWIGGlyphMetricsList_size(long j, SWIGGlyphMetricsList sWIGGlyphMetricsList);

    public static final native long SWIGRectangleList_at(long j, SWIGRectangleList sWIGRectangleList, int i);

    public static final native void SWIGRectangleList_push_back(long j, SWIGRectangleList sWIGRectangleList, long j2, Rectangle rectangle);

    public static final native int SWIGRectangleList_size(long j, SWIGRectangleList sWIGRectangleList);

    public static final native byte[] SWIGVectorAtkStringType_at(long j, SWIGVectorAtkStringType sWIGVectorAtkStringType, int i);

    public static final native void SWIGVectorAtkStringType_push_back(long j, SWIGVectorAtkStringType sWIGVectorAtkStringType, byte[] bArr);

    public static final native int SWIGVectorAtkStringType_size(long j, SWIGVectorAtkStringType sWIGVectorAtkStringType);

    public static final native long SWIGVectorChildPageSpec_at(long j, SWIGVectorChildPageSpec sWIGVectorChildPageSpec, int i);

    public static final native void SWIGVectorChildPageSpec_push_back(long j, SWIGVectorChildPageSpec sWIGVectorChildPageSpec, long j2, ChildPageSpec childPageSpec);

    public static final native int SWIGVectorChildPageSpec_size(long j, SWIGVectorChildPageSpec sWIGVectorChildPageSpec);

    public static final native long SWIGVectorCustomResource_at(long j, SWIGVectorCustomResource sWIGVectorCustomResource, int i);

    public static final native void SWIGVectorCustomResource_push_back(long j, SWIGVectorCustomResource sWIGVectorCustomResource, long j2, CustomResource customResource);

    public static final native int SWIGVectorCustomResource_size(long j, SWIGVectorCustomResource sWIGVectorCustomResource);

    public static final native long SWIGVectorExtent_at(long j, SWIGVectorExtent sWIGVectorExtent, int i);

    public static final native void SWIGVectorExtent_push_back(long j, SWIGVectorExtent sWIGVectorExtent, long j2, Extent extent);

    public static final native int SWIGVectorExtent_size(long j, SWIGVectorExtent sWIGVectorExtent);

    public static final native long SWIGVectorGlyphLines_at(long j, SWIGVectorGlyphLines sWIGVectorGlyphLines, int i);

    public static final native void SWIGVectorGlyphLines_push_back(long j, SWIGVectorGlyphLines sWIGVectorGlyphLines, long j2, GlyphLines glyphLines);

    public static final native int SWIGVectorGlyphLines_size(long j, SWIGVectorGlyphLines sWIGVectorGlyphLines);

    public static final native long SWIGVectorGlyph_at(long j, SWIGVectorGlyph sWIGVectorGlyph, int i);

    public static final native void SWIGVectorGlyph_push_back(long j, SWIGVectorGlyph sWIGVectorGlyph, long j2, Glyph glyph);

    public static final native int SWIGVectorGlyph_size(long j, SWIGVectorGlyph sWIGVectorGlyph);

    public static final native long SWIGVectorInkStyle_at(long j, SWIGVectorInkStyle sWIGVectorInkStyle, int i);

    public static final native void SWIGVectorInkStyle_push_back(long j, SWIGVectorInkStyle sWIGVectorInkStyle, long j2, InkStyle inkStyle);

    public static final native int SWIGVectorInkStyle_size(long j, SWIGVectorInkStyle sWIGVectorInkStyle);

    public static final native int SWIGVectorMimeType_at(long j, SWIGVectorMimeType sWIGVectorMimeType, int i);

    public static final native void SWIGVectorMimeType_push_back(long j, SWIGVectorMimeType sWIGVectorMimeType, int i);

    public static final native int SWIGVectorMimeType_size(long j, SWIGVectorMimeType sWIGVectorMimeType);

    public static final native long SWIGVectorMotionEvent_at(long j, SWIGVectorMotionEvent sWIGVectorMotionEvent, int i);

    public static final native void SWIGVectorMotionEvent_push_back(long j, SWIGVectorMotionEvent sWIGVectorMotionEvent, long j2, MotionEvent motionEvent);

    public static final native int SWIGVectorMotionEvent_size(long j, SWIGVectorMotionEvent sWIGVectorMotionEvent);

    public static final native long SWIGVectorParallelogram_at(long j, SWIGVectorParallelogram sWIGVectorParallelogram, int i);

    public static final native void SWIGVectorParallelogram_push_back(long j, SWIGVectorParallelogram sWIGVectorParallelogram, long j2, Parallelogram parallelogram);

    public static final native int SWIGVectorParallelogram_size(long j, SWIGVectorParallelogram sWIGVectorParallelogram);

    public static final native long SWIGVectorPendingStroke_at(long j, SWIGVectorPendingStroke sWIGVectorPendingStroke, int i);

    public static final native void SWIGVectorPendingStroke_push_back(long j, SWIGVectorPendingStroke sWIGVectorPendingStroke, long j2, PendingStroke pendingStroke);

    public static final native int SWIGVectorPendingStroke_size(long j, SWIGVectorPendingStroke sWIGVectorPendingStroke);

    public static final native long SWIGVectorPoint_at(long j, SWIGVectorPoint sWIGVectorPoint, int i);

    public static final native void SWIGVectorPoint_push_back(long j, SWIGVectorPoint sWIGVectorPoint, long j2, Point point);

    public static final native int SWIGVectorPoint_size(long j, SWIGVectorPoint sWIGVectorPoint);

    public static final native long SWIGVectorPointerInfo_at(long j, SWIGVectorPointerInfo sWIGVectorPointerInfo, int i);

    public static final native void SWIGVectorPointerInfo_push_back(long j, SWIGVectorPointerInfo sWIGVectorPointerInfo, long j2, PointerInfo pointerInfo);

    public static final native int SWIGVectorPointerInfo_size(long j, SWIGVectorPointerInfo sWIGVectorPointerInfo);

    public static final native long SWIGVectorSpanInterval_at(long j, SWIGVectorSpanInterval sWIGVectorSpanInterval, int i);

    public static final native void SWIGVectorSpanInterval_push_back(long j, SWIGVectorSpanInterval sWIGVectorSpanInterval, long j2, SpanInterval spanInterval);

    public static final native int SWIGVectorSpanInterval_size(long j, SWIGVectorSpanInterval sWIGVectorSpanInterval);

    public static final native byte[] SWIGVectorString_at(long j, SWIGVectorString sWIGVectorString, int i);

    public static final native void SWIGVectorString_push_back(long j, SWIGVectorString sWIGVectorString, byte[] bArr);

    public static final native int SWIGVectorString_size(long j, SWIGVectorString sWIGVectorString);

    public static final native long SWIGVectorTagId_at(long j, SWIGVectorTagId sWIGVectorTagId, int i);

    public static final native void SWIGVectorTagId_push_back(long j, SWIGVectorTagId sWIGVectorTagId, long j2);

    public static final native int SWIGVectorTagId_size(long j, SWIGVectorTagId sWIGVectorTagId);

    public static final native long SelectionDataTypeLabels_get();

    public static final native long SelectionEventLabels_get();

    public static final native long SelectionStateLabels_get();

    public static final native long Selection_adjustToStrokeBoundaries(long j, Selection selection, float f);

    public static final native void Selection_applyFontStyle(long j, Selection selection, long j2, Transform transform);

    public static final native long Selection_clone(long j, Selection selection);

    public static final native long Selection_combine__SWIG_0(long j, Selection selection, long j2, Selection selection2, int i);

    public static final native long Selection_combine__SWIG_1(long j, Selection selection, long j2, Selection selection2);

    public static final native boolean Selection_contains(long j, Selection selection, long j2, Selection selection2);

    public static final native long Selection_getExtent__SWIG_0(long j, Selection selection, int i);

    public static final native long Selection_getExtent__SWIG_1(long j, Selection selection);

    public static final native int Selection_getInkItemsCount(long j, Selection selection);

    public static final native long Selection_getLayout(long j, Selection selection);

    public static final native boolean Selection_hasGlyph(long j, Selection selection);

    public static final native boolean Selection_hasPrimitive(long j, Selection selection);

    public static final native boolean Selection_hasStroke(long j, Selection selection);

    public static final native long Selection_inkSegment(long j, Selection selection);

    public static final native float Selection_inkWidth(long j, LayoutItem layoutItem);

    public static final native boolean Selection_intersects(long j, Selection selection, long j2, Selection selection2);

    public static final native boolean Selection_isAbove(long j, Selection selection, long j2, Selection selection2, boolean z);

    public static final native boolean Selection_isEmpty(long j, Selection selection);

    public static final native long Selection_iterator__SWIG_0(long j, Selection selection, boolean z);

    public static final native long Selection_iterator__SWIG_1(long j, Selection selection);

    public static final native long Selection_layoutItems__SWIG_0(long j, Selection selection, boolean z);

    public static final native long Selection_layoutItems__SWIG_1(long j, Selection selection);

    public static final native float Selection_length(long j, Selection selection);

    public static final native void Selection_reset__SWIG_0(long j, Selection selection);

    public static final native void Selection_reset__SWIG_1(long j, Selection selection, long j2, ModelLock modelLock);

    public static final native long Selection_selectAll(long j, Selection selection);

    public static final native long Selection_selectByType__SWIG_0(long j, Selection selection, int i, int i2);

    public static final native long Selection_selectByType__SWIG_1(long j, Selection selection, int i);

    public static final native long Selection_selectInkItemIfValid__SWIG_0(long j, Selection selection, long j2, int i);

    public static final native long Selection_selectInkItemIfValid__SWIG_1(long j, Selection selection, long j2);

    public static final native void Selection_selectInkSegment__SWIG_0(long j, Selection selection, long j2, int i);

    public static final native void Selection_selectInkSegment__SWIG_1(long j, Selection selection, long j2);

    public static final native long Selection_selectLayer__SWIG_0(long j, Selection selection, byte[] bArr, int i);

    public static final native long Selection_selectLayer__SWIG_1(long j, Selection selection, byte[] bArr);

    public static final native long Selection_selectLayoutGroup__SWIG_0(long j, Selection selection, long j2, LayoutGroup layoutGroup, int i);

    public static final native long Selection_selectLayoutGroup__SWIG_1(long j, Selection selection, long j2, LayoutGroup layoutGroup);

    public static final native long Selection_selectLayoutItem__SWIG_0(long j, Selection selection, long j2, LayoutItem layoutItem, int i);

    public static final native long Selection_selectLayoutItem__SWIG_1(long j, Selection selection, long j2, LayoutItem layoutItem);

    public static final native long Selection_selectNone(long j, Selection selection);

    public static final native long Selection_selectPolygon__SWIG_0(long j, Selection selection, long j2, Path path, int i);

    public static final native long Selection_selectPolygon__SWIG_1(long j, Selection selection, long j2, Path path);

    public static final native long Selection_selectPolygon__SWIG_2(long j, Selection selection, long j2, Point point, int i, int i2);

    public static final native long Selection_selectPolygon__SWIG_3(long j, Selection selection, long j2, Point point, int i);

    public static final native long Selection_selectRectangle__SWIG_0(long j, Selection selection, long j2, Rectangle rectangle, int i);

    public static final native long Selection_selectRectangle__SWIG_1(long j, Selection selection, long j2, Rectangle rectangle);

    public static final native long Selection_selectStrokeIds__SWIG_0(long j, Selection selection, boolean z, long j2, int i);

    public static final native long Selection_selectStrokeIds__SWIG_1(long j, Selection selection, boolean z, long j2);

    public static final native long Selection_selectTag__SWIG_0(long j, Selection selection, long j2, int i);

    public static final native long Selection_selectTag__SWIG_1(long j, Selection selection, long j2);

    public static final native long Selection_selectTags__SWIG_0(long j, Selection selection, long j2, SWIGVectorTagId sWIGVectorTagId, int i);

    public static final native long Selection_selectTags__SWIG_1(long j, Selection selection, long j2, SWIGVectorTagId sWIGVectorTagId);

    public static final native void Selection_setMode(long j, Selection selection, int i);

    public static final native long Selection_tags(long j, Selection selection, byte[] bArr);

    public static final native byte[] Selection_toString(long j, Selection selection);

    public static final native void Selection_transform(long j, Selection selection, long j2, Transform transform);

    public static final native boolean Selection_valid(long j, Selection selection);

    public static final native int SemiAxis_axis_get(long j, SemiAxis semiAxis);

    public static final native void SemiAxis_axis_set(long j, SemiAxis semiAxis, int i);

    public static final native boolean SemiAxis_beforeBound_get(long j, SemiAxis semiAxis);

    public static final native void SemiAxis_beforeBound_set(long j, SemiAxis semiAxis, boolean z);

    public static final native float SemiAxis_bound_get(long j, SemiAxis semiAxis);

    public static final native void SemiAxis_bound_set(long j, SemiAxis semiAxis, float f);

    public static final native boolean SemiAxis_isDefined(long j, SemiAxis semiAxis);

    public static final native boolean SemiAxis_isUndefined(long j, SemiAxis semiAxis);

    public static final native boolean Settings_assertOnError(long j, Settings settings);

    public static final native void Settings_enableEventLogger(long j, Settings settings, boolean z);

    public static final native void Settings_enableFontCaching(long j, Settings settings, boolean z);

    public static final native void Settings_enableGestureNN(long j, Settings settings, boolean z);

    public static final native void Settings_enableMigrationAtSync(long j, Settings settings, boolean z);

    public static final native long Settings_getInstance();

    public static final native float Settings_indentFactor(long j, Settings settings);

    public static final native boolean Settings_isEventLoggerEnabled(long j, Settings settings);

    public static final native boolean Settings_isFontCachingEnabled(long j, Settings settings);

    public static final native boolean Settings_isGestureNNEnabled(long j, Settings settings);

    public static final native boolean Settings_isMigrationAtSyncEnabled(long j, Settings settings);

    public static final native void Settings_setAssertOnError(long j, Settings settings, boolean z);

    public static final native long SinglePointerPredictor_getNumIterations(long j, SinglePointerPredictor singlePointerPredictor);

    public static final native long SinglePointerPredictor_getPointerId(long j, SinglePointerPredictor singlePointerPredictor);

    public static final native void SinglePointerPredictor_initStrokePrediction(long j, SinglePointerPredictor singlePointerPredictor);

    public static final native void SinglePointerPredictor_onTouchEvent(long j, SinglePointerPredictor singlePointerPredictor, long j2, MotionEvent motionEvent);

    public static final native long SinglePointerPredictor_predict(long j, SinglePointerPredictor singlePointerPredictor, long j2);

    public static final native void SinglePointerPredictor_setPointerId(long j, SinglePointerPredictor singlePointerPredictor, long j2);

    public static final native void SinglePointerPredictor_setReportRate(long j, SinglePointerPredictor singlePointerPredictor, long j2);

    public static final native void SinglePointerPredictor_setWritingModeParams(long j, SinglePointerPredictor singlePointerPredictor, double d, double d2, long j2, long j3);

    public static final native void SinglePointerPredictor_update(long j, SinglePointerPredictor singlePointerPredictor, double d, double d2, long j2);

    public static final native int SpanInterval_beginCharPosition_get(long j, SpanInterval spanInterval);

    public static final native void SpanInterval_beginCharPosition_set(long j, SpanInterval spanInterval, int i);

    public static final native int SpanInterval_endCharPosition_get(long j, SpanInterval spanInterval);

    public static final native void SpanInterval_endCharPosition_set(long j, SpanInterval spanInterval, int i);

    public static final native long Sprite_batchID_get(long j, Sprite sprite);

    public static final native int Sprite_color_get(long j, Sprite sprite);

    public static final native void Sprite_color_set(long j, Sprite sprite, int i);

    public static final native void Sprite_crop(long j, Sprite sprite, long j2, Extent extent);

    public static final native long Sprite_deltaTransform_get(long j, Sprite sprite);

    public static final native void Sprite_deltaTransform_set(long j, Sprite sprite, long j2, Transform transform);

    public static final native long Sprite_destExtent_get(long j, Sprite sprite);

    public static final native void Sprite_destExtent_set(long j, Sprite sprite, long j2, Extent extent);

    public static final native long Sprite_initTransform_get(long j, Sprite sprite);

    public static final native void Sprite_initTransform_set(long j, Sprite sprite, long j2, Transform transform);

    public static final native long Sprite_srcRectangle_get(long j, Sprite sprite);

    public static final native void Sprite_srcRectangle_set(long j, Sprite sprite, long j2, Rectangle rectangle);

    public static final native boolean StateMachineLock_owns_lock(long j, StateMachineLock stateMachineLock);

    public static final native float StrokeOffsets_beginInterpolation_get(long j, StrokeOffsets strokeOffsets);

    public static final native void StrokeOffsets_beginInterpolation_set(long j, StrokeOffsets strokeOffsets, float f);

    public static final native float StrokeOffsets_endInterpolation_get(long j, StrokeOffsets strokeOffsets);

    public static final native void StrokeOffsets_endInterpolation_set(long j, StrokeOffsets strokeOffsets, float f);

    public static final native long StrokeOffsets_fromBegin_get(long j, StrokeOffsets strokeOffsets);

    public static final native void StrokeOffsets_fromBegin_set(long j, StrokeOffsets strokeOffsets, long j2);

    public static final native long StrokeOffsets_toEnd_get(long j, StrokeOffsets strokeOffsets);

    public static final native void StrokeOffsets_toEnd_set(long j, StrokeOffsets strokeOffsets, long j2);

    public static final native boolean StyleSelectorIterator_equals(long j, StyleSelectorIterator styleSelectorIterator, long j2);

    public static final native long StyleSelectorIterator_getResolvedStyle(long j, StyleSelectorIterator styleSelectorIterator);

    public static final native byte[] StyleSelectorIterator_getSelector(long j, StyleSelectorIterator styleSelectorIterator);

    public static final native boolean StyleSelectorIterator_isAtEnd(long j, StyleSelectorIterator styleSelectorIterator);

    public static final native void StyleSelectorIterator_next(long j, StyleSelectorIterator styleSelectorIterator);

    public static final native byte[] TABLE_get();

    public static final native byte[] TEXT_DOCUMENT_get();

    public static final native byte[] TEXT_get();

    public static final native byte[] TRACE_get();

    public static final native int TextImpl_getGlyphCount(long j, TextImpl textImpl);

    public static final native int TextImpl_getGlyphIndexUtf16At(long j, TextImpl textImpl, int i);

    public static final native int TextImpl_getGlyphIndexUtf8At(long j, TextImpl textImpl, int i);

    public static final native byte[] TextImpl_getGlyphLabelAt(long j, TextImpl textImpl, int i);

    public static final native int TextImpl_getGlyphUtf16BeginAt(long j, TextImpl textImpl, int i);

    public static final native int TextImpl_getGlyphUtf16EndAt(long j, TextImpl textImpl, int i);

    public static final native int TextImpl_getGlyphUtf8BeginAt(long j, TextImpl textImpl, int i);

    public static final native int TextImpl_getGlyphUtf8EndAt(long j, TextImpl textImpl, int i);

    public static final native long TextStructureProvider_getGeometry(long j, TextStructureProvider textStructureProvider, long j2, Content content, byte[] bArr);

    public static final native boolean TextStructureProvider_getHideListItems(long j, TextStructureProvider textStructureProvider, long j2, Content content, byte[] bArr);

    public static final native int TextStructureProvider_getMaxIndentationLevel(long j, TextStructureProvider textStructureProvider, long j2, Content content, byte[] bArr);

    public static final native long TimingOffsets_fromBegin_get(long j, TimingOffsets timingOffsets);

    public static final native void TimingOffsets_fromBegin_set(long j, TimingOffsets timingOffsets, long j2);

    public static final native long TimingOffsets_toEnd_get(long j, TimingOffsets timingOffsets);

    public static final native void TimingOffsets_toEnd_set(long j, TimingOffsets timingOffsets, long j2);

    public static final native boolean Transform_almostEqual(long j, Transform transform, long j2, Transform transform2);

    public static final native void Transform_decomposeQR(long j, Transform transform, long j2, Transform transform2, long j3, Transform transform3);

    public static final native long Transform_fixRemarkableValues__SWIG_0(long j, Transform transform, float f);

    public static final native long Transform_fixRemarkableValues__SWIG_1(long j, Transform transform);

    public static final native long Transform_getAngle(long j, Transform transform);

    public static final native float Transform_getXScale(long j, Transform transform);

    public static final native float Transform_getXShear(long j, Transform transform);

    public static final native float Transform_getXTranslate(long j, Transform transform);

    public static final native float Transform_getYScale(long j, Transform transform);

    public static final native float Transform_getYShear(long j, Transform transform);

    public static final native float Transform_getYTranslate(long j, Transform transform);

    public static final native void Transform_invert2(long j, Transform transform);

    public static final native long Transform_inverted(long j, Transform transform);

    public static final native boolean Transform_invertible(long j, Transform transform);

    public static final native boolean Transform_isIdentity(long j, Transform transform);

    public static final native boolean Transform_isRotation(long j, Transform transform);

    public static final native boolean Transform_isTranslation(long j, Transform transform);

    public static final native long Transform_map(long j, Transform transform, float f, float f2);

    public static final native boolean Transform_maybeRotation(long j, Transform transform);

    public static final native long Transform_multiplied(long j, Transform transform, long j2, Transform transform2);

    public static final native void Transform_multiply2(long j, Transform transform, long j2, Transform transform2);

    public static final native double Transform_rawAngle(long j, Transform transform);

    public static final native void Transform_rotate2__SWIG_0(long j, Transform transform, float f);

    public static final native void Transform_rotate2__SWIG_1(long j, Transform transform, float f, float f2, float f3);

    public static final native void Transform_scale2(long j, Transform transform, float f, float f2);

    public static final native long Transform_scaleFromPoint(long j, Transform transform, float f, float f2, long j2, Point point);

    public static final native void Transform_setIdentity(long j, Transform transform);

    public static final native void Transform_shear2(long j, Transform transform, float f, float f2);

    public static final native void Transform_shearX2(long j, Transform transform, float f, float f2);

    public static final native void Transform_shearY2(long j, Transform transform, float f, float f2);

    public static final native byte[] Transform_toString(long j, Transform transform);

    public static final native void Transform_translate2__SWIG_0(long j, Transform transform, float f, float f2);

    public static final native void Transform_translate2__SWIG_1(long j, Transform transform, long j2, Point point);

    public static final native boolean TransitionContext_internalStateLocked_get(long j, TransitionContext transitionContext);

    public static final native void TransitionContext_internalStateLocked_set(long j, TransitionContext transitionContext, boolean z);

    public static final native long TransitionStates_get();

    public static final native long TypesetData_getItemAt(long j, TypesetData typesetData, int i);

    public static final native int TypesetData_getItemCount(long j, TypesetData typesetData);

    public static final native int TypesetItem_getAlternateCount(long j, TypesetItem typesetItem);

    public static final native void TypesetItem_getData(long j, TypesetItem typesetItem, Object obj, long j2);

    public static final native long TypesetItem_getExtent(long j, TypesetItem typesetItem);

    public static final native int TypesetItem_getFirstDecoration(long j, TypesetItem typesetItem);

    public static final native byte[] TypesetItem_getLabel(long j, TypesetItem typesetItem);

    public static final native int TypesetItem_getLastDecoration(long j, TypesetItem typesetItem);

    public static final native long TypesetItem_getLines(long j, TypesetItem typesetItem);

    public static final native long TypesetItem_getParallelogram(long j, TypesetItem typesetItem);

    public static final native long TypesetItem_getStrokeAt(long j, TypesetItem typesetItem, int i);

    public static final native int TypesetItem_getStrokeCount(long j, TypesetItem typesetItem);

    public static final native int TypesetItem_getType(long j, TypesetItem typesetItem);

    public static final native boolean TypesetItem_hasLines(long j, TypesetItem typesetItem);

    public static final native void TypesetItem_setGlyphGeometry(long j, TypesetItem typesetItem, long j2, Parallelogram parallelogram, long j3, GlyphLines glyphLines);

    public static final native void TypesetItem_setPrimitiveData(long j, TypesetItem typesetItem, Object obj, long j2);

    public static final native byte[] UNKNOWN_get();

    public static final native boolean URIListener_isEmpty(long j, URIListener uRIListener);

    public static final native void URIListener_linkActivated(long j, URIListener uRIListener, byte[] bArr);

    public static final native long URINotifier_SWIGUpcast(long j);

    public static final native void URINotifier_addURIListener(long j, URINotifier uRINotifier, long j2);

    public static final native boolean URINotifier_isEmpty(long j, URINotifier uRINotifier);

    public static final native void URINotifier_linkActivated(long j, URINotifier uRINotifier, byte[] bArr);

    public static final native void URINotifier_removeURIListener(long j, URINotifier uRINotifier, long j2);

    public static final native long ValuedAngle_Undefined();

    public static final native double ValuedAngle_degrees(long j, ValuedAngle valuedAngle);

    public static final native float ValuedAngle_degreesAsFloat(long j, ValuedAngle valuedAngle);

    public static final native long ValuedAngle_fromDegrees(double d);

    public static final native boolean ValuedAngle_isDefined(long j, ValuedAngle valuedAngle);

    public static final native boolean ValuedAngle_isUndefined(long j, ValuedAngle valuedAngle);

    public static final native boolean ValuedAngle_strictlyEquals(long j, ValuedAngle valuedAngle, long j2, ValuedAngle valuedAngle2);

    public static final native double ValuedAngle_value(long j, ValuedAngle valuedAngle);

    public static final native float ValuedAngle_valueAsFloat(long j, ValuedAngle valuedAngle);

    public static final native int VerticalLineSet_count_get(long j, VerticalLineSet verticalLineSet);

    public static final native float VerticalLineSet_dx_get(long j, VerticalLineSet verticalLineSet);

    public static final native int VerticalLineSet_first_get(long j, VerticalLineSet verticalLineSet);

    public static final native float VerticalLineSet_x0_get(long j, VerticalLineSet verticalLineSet);

    public static final native float VerticalLineSet_y1_get(long j, VerticalLineSet verticalLineSet);

    public static final native float VerticalLineSet_y2_get(long j, VerticalLineSet verticalLineSet);

    public static final native float ViewTransform_dpiX(long j, ViewTransform viewTransform);

    public static final native float ViewTransform_dpiY(long j, ViewTransform viewTransform);

    public static final native long ViewTransform_fitToWidth(long j, Extent extent, float f, float f2, float f3, float f4, int i, int i2);

    public static final native void ViewTransform_fitTo__SWIG_0(long j, ViewTransform viewTransform, long j2, Extent extent, int i, int i2, int i3, int i4);

    public static final native void ViewTransform_fitTo__SWIG_1(long j, ViewTransform viewTransform, long j2, Extent extent, int i, int i2, int i3);

    public static final native void ViewTransform_fitTo__SWIG_2(long j, ViewTransform viewTransform, long j2, Extent extent, int i, int i2);

    public static final native boolean ViewTransform_hasZoomOffset(long j, ViewTransform viewTransform);

    public static final native float ViewTransform_imapX(long j, ViewTransform viewTransform, float f);

    public static final native float ViewTransform_imapY(long j, ViewTransform viewTransform, float f);

    public static final native long ViewTransform_imap__SWIG_0(long j, ViewTransform viewTransform, float f, float f2);

    public static final native long ViewTransform_imap__SWIG_1(long j, ViewTransform viewTransform, long j2, Point point);

    public static final native long ViewTransform_imap__SWIG_2(long j, ViewTransform viewTransform, long j2, PointerInfo pointerInfo);

    public static final native long ViewTransform_imap__SWIG_3(long j, ViewTransform viewTransform, long j2, Extent extent);

    public static final native long ViewTransform_itransform__SWIG_0(long j, ViewTransform viewTransform, boolean z);

    public static final native long ViewTransform_itransform__SWIG_1(long j, ViewTransform viewTransform);

    public static final native float ViewTransform_mapX(long j, ViewTransform viewTransform, float f);

    public static final native float ViewTransform_mapY(long j, ViewTransform viewTransform, float f);

    public static final native long ViewTransform_map__SWIG_0(long j, ViewTransform viewTransform, float f, float f2);

    public static final native long ViewTransform_map__SWIG_1(long j, ViewTransform viewTransform, long j2, Point point);

    public static final native long ViewTransform_map__SWIG_2(long j, ViewTransform viewTransform, long j2, PointerInfo pointerInfo);

    public static final native long ViewTransform_map__SWIG_3(long j, ViewTransform viewTransform, long j2, Extent extent);

    public static final native long ViewTransform_newRef(long j, ViewTransform viewTransform);

    public static final native void ViewTransform_pan(long j, ViewTransform viewTransform, long j2, Point point);

    public static final native float ViewTransform_scaleX(long j, ViewTransform viewTransform);

    public static final native float ViewTransform_scaleY(long j, ViewTransform viewTransform);

    public static final native boolean ViewTransform_setDPI(long j, ViewTransform viewTransform, float f, float f2);

    public static final native void ViewTransform_setTransform(long j, ViewTransform viewTransform, long j2, Transform transform);

    public static final native void ViewTransform_setZoomOffset__SWIG_0(long j, ViewTransform viewTransform, long j2, Point point);

    public static final native void ViewTransform_setZoomOffset__SWIG_1(long j, ViewTransform viewTransform, float f, float f2);

    public static final native void ViewTransform_setZoomScale(long j, ViewTransform viewTransform, float f);

    public static final native long ViewTransform_transform__SWIG_0(long j, ViewTransform viewTransform, boolean z);

    public static final native long ViewTransform_transform__SWIG_1(long j, ViewTransform viewTransform);

    public static final native void ViewTransform_verticalScrollTo(long j, ViewTransform viewTransform, long j2, Extent extent, int i, int i2);

    public static final native void ViewTransform_zoomAt(long j, ViewTransform viewTransform, long j2, Point point, float f);

    public static final native long ViewTransform_zoomOffset(long j, ViewTransform viewTransform);

    public static final native float ViewTransform_zoomScale(long j, ViewTransform viewTransform);

    public static final native float VinculumFactor_get();

    public static final native int convertButtonType(int i);

    public static final native void delete_ActiveArea(long j);

    public static final native void delete_AtomicString(long j);

    public static final native void delete_BackgroundDescription(long j);

    public static final native void delete_Box(long j);

    public static final native void delete_CaptureInfo(long j);

    public static final native void delete_CenterEllipticArc(long j);

    public static final native void delete_ChildPageSpec(long j);

    public static final native void delete_Content(long j);

    public static final native void delete_Context(long j);

    public static final native void delete_CustomResource(long j);

    public static final native void delete_DVector2(long j);

    public static final native void delete_DefaultPendingStrokeIdProvider(long j);

    public static final native void delete_Document(long j);

    public static final native void delete_EndpointEllipticArc(long j);

    public static final native void delete_EngineError(long j);

    public static final native void delete_Extent(long j);

    public static final native void delete_Glyph(long j);

    public static final native void delete_GlyphLines(long j);

    public static final native void delete_GlyphMetrics(long j);

    public static final native void delete_GlyphSlices(long j);

    public static final native void delete_GuideData(long j);

    public static final native void delete_GuideIterator(long j);

    public static final native void delete_GuidePositioning(long j);

    public static final native void delete_HSLColorInversionPolicy(long j);

    public static final native void delete_HorizontalLineSet(long j);

    public static final native void delete_IConfigurationUpdateListener(long j);

    public static final native void delete_IGlyph_getAlternateAt_result_t(long j);

    public static final native void delete_IObjectManager(long j);

    public static final native void delete_IObjectManagerFactory(long j);

    public static final native void delete_IPendingStrokeIdProvider(long j);

    public static final native void delete_IdentityColorInversionPolicy(long j);

    public static final native void delete_InkStroke(long j);

    public static final native void delete_InkStyle(long j);

    public static final native void delete_InputCharacter(long j);

    public static final native void delete_Insets(long j);

    public static final native void delete_IntInterval(long j);

    public static final native void delete_Json(long j);

    public static final native void delete_JsonObjectIterator(long j);

    public static final native void delete_LanguageUpdater(long j);

    public static final native void delete_LayerIterator(long j);

    public static final native void delete_Layout(long j);

    public static final native void delete_LayoutGroup(long j);

    public static final native void delete_LayoutItem(long j);

    public static final native void delete_LayoutItemArc(long j);

    public static final native void delete_LayoutItemDecoration(long j);

    public static final native void delete_LayoutItemGuide(long j);

    public static final native void delete_LayoutItemIterator(long j);

    public static final native void delete_LayoutItemLine(long j);

    public static final native void delete_LayoutItemObject(long j);

    public static final native void delete_LayoutItemPoint(long j);

    public static final native void delete_LayoutItemString(long j);

    public static final native void delete_LayoutItemStroke(long j);

    public static final native void delete_LayoutIterator(long j);

    public static final native void delete_LayoutObjectData(long j);

    public static final native void delete_Line(long j);

    public static final native void delete_LineSegment(long j);

    public static final native void delete_LogIndenter(long j);

    public static final native void delete_Logger(long j);

    public static final native void delete_MapCompare(long j);

    public static final native void delete_MessageListener(long j);

    public static final native void delete_MessageNotifier(long j);

    public static final native void delete_ModelLock(long j);

    public static final native void delete_MotionEvent(long j);

    public static final native void delete_MotionEventPredictor(long j);

    public static final native void delete_MotionFilter(long j);

    public static final native void delete_MotionPredictionParams(long j);

    public static final native void delete_Page(long j);

    public static final native void delete_PageFormat(long j);

    public static final native void delete_Parallelogram(long j);

    public static final native void delete_Path(long j);

    public static final native void delete_PathToStrokeOffsets(long j);

    public static final native void delete_PendingStroke(long j);

    public static final native void delete_Point(long j);

    public static final native void delete_PointerInfo(long j);

    public static final native void delete_PointerInfoData(long j);

    public static final native void delete_Rectangle(long j);

    public static final native void delete_Renderer(long j);

    public static final native void delete_RenderingUpdateSession(long j);

    public static final native void delete_SWIGGlyphMetricsList(long j);

    public static final native void delete_SWIGRectangleList(long j);

    public static final native void delete_SWIGVectorAtkStringType(long j);

    public static final native void delete_SWIGVectorChildPageSpec(long j);

    public static final native void delete_SWIGVectorCustomResource(long j);

    public static final native void delete_SWIGVectorExtent(long j);

    public static final native void delete_SWIGVectorMimeType(long j);

    public static final native void delete_SWIGVectorMotionEvent(long j);

    public static final native void delete_SWIGVectorPendingStroke(long j);

    public static final native void delete_SWIGVectorPoint(long j);

    public static final native void delete_SWIGVectorPointerInfo(long j);

    public static final native void delete_SWIGVectorSpanInterval(long j);

    public static final native void delete_SWIGVectorString(long j);

    public static final native void delete_SWIGVectorTagId(long j);

    public static final native void delete_Selection(long j);

    public static final native void delete_SemiAxis(long j);

    public static final native void delete_Settings(long j);

    public static final native void delete_SinglePointerPredictor(long j);

    public static final native void delete_SpanInterval(long j);

    public static final native void delete_Sprite(long j);

    public static final native void delete_StateMachineLock(long j);

    public static final native void delete_StrokeOffsets(long j);

    public static final native void delete_StyleSelectorIterator(long j);

    public static final native void delete_TextImpl(long j);

    public static final native void delete_TextStructureProvider(long j);

    public static final native void delete_TimingOffsets(long j);

    public static final native void delete_Transform(long j);

    public static final native void delete_TransitionContext(long j);

    public static final native void delete_TypesetData(long j);

    public static final native void delete_TypesetItem(long j);

    public static final native void delete_URIListener(long j);

    public static final native void delete_URINotifier(long j);

    public static final native void delete_ValuedAngle(long j);

    public static final native void delete_VerticalLineSet(long j);

    public static final native void delete_ViewTransform(long j);

    public static final native byte[] getFileExtension(int i);

    public static final native long getFileExtensionList(int i);

    public static final native byte[] getFileExtensions(int i);

    public static final native int getMimeTypeFromPath(byte[] bArr);

    public static final native int getMimeTypeFromTypeName(byte[] bArr);

    public static final native byte[] getName(int i);

    public static final native byte[] getTypeName(int i);

    public static final native long getTypeNames(int i);

    public static final native boolean hasButtonType(int i, int i2);

    public static final native float[] insetForPattern(int i);

    public static final native boolean isImage(int i);

    public static final native boolean isTextual(int i);

    public static final native void logDisable();

    public static final native void logEnable__SWIG_0(int i);

    public static final native void logEnable__SWIG_1();

    public static final native void logSelection(long j, Selection selection);

    public static final native long mapped__SWIG_0(long j, Point point, long j2, Transform transform);

    public static final native long mapped__SWIG_1(long j, PointerInfo pointerInfo, long j2, Transform transform);

    public static final native long mapped__SWIG_2(long j, Line line, long j2, Transform transform);

    public static final native long mapped__SWIG_3(long j, Rectangle rectangle, long j2, Transform transform);

    public static final native long mapped__SWIG_4(long j, Extent extent, long j2, Transform transform);

    public static final native long mapped__SWIG_5(long j, Insets insets, long j2, Transform transform);

    public static final native long mapped__SWIG_6(long j, Path path, long j2, Transform transform);

    public static final native long new_ActiveArea(long j, ActiveArea activeArea);

    public static final native long new_AtomicString();

    public static final native long new_BackgroundDescription();

    public static final native long new_CaptureInfo__SWIG_0(long j, PointerInfo pointerInfo, long j2);

    public static final native long new_CaptureInfo__SWIG_1(long j, PointerInfo pointerInfo, long j2, int i);

    public static final native long new_CaptureInfo__SWIG_2(long j, PointerInfo pointerInfo, long j2);

    public static final native long new_CaptureInfo__SWIG_3(long j);

    public static final native long new_CenterEllipticArc();

    public static final native long new_ChildPageSpec__SWIG_0();

    public static final native long new_ChildPageSpec__SWIG_1(byte[] bArr, long j, Extent extent);

    public static final native long new_Content();

    public static final native long new_CustomResource__SWIG_0(byte[] bArr, int i);

    public static final native long new_CustomResource__SWIG_1(byte[] bArr);

    public static final native long new_DVector2__SWIG_0();

    public static final native long new_DVector2__SWIG_1(double d, double d2);

    public static final native long new_DefaultPendingStrokeIdProvider();

    public static final native long new_EndpointEllipticArc();

    public static final native long new_EngineError__SWIG_0(int i);

    public static final native long new_EngineError__SWIG_1(int i, String str);

    public static final native long new_Extent__SWIG_0();

    public static final native long new_Extent__SWIG_1(long j);

    public static final native long new_Extent__SWIG_2(float f, float f2, float f3, float f4);

    public static final native long new_GlyphLines();

    public static final native long new_GlyphMetrics();

    public static final native long new_GlyphSlices();

    public static final native long new_Glyph__SWIG_0(long j, InputCharacter inputCharacter, long j2, byte[] bArr);

    public static final native long new_Glyph__SWIG_1(long j, InputCharacter inputCharacter, long j2, Parallelogram parallelogram, byte[] bArr);

    public static final native long new_Glyph__SWIG_2(long j, InputCharacter inputCharacter, long j2, Parallelogram parallelogram, long j3, GlyphLines glyphLines, byte[] bArr);

    public static final native long new_GuideData__SWIG_0(long j, VerticalLineSet verticalLineSet);

    public static final native long new_GuideData__SWIG_1(long j, VerticalLineSet verticalLineSet, int i);

    public static final native long new_GuideData__SWIG_2(long j, HorizontalLineSet horizontalLineSet);

    public static final native long new_GuideData__SWIG_3(long j, HorizontalLineSet horizontalLineSet, int i);

    public static final native long new_GuideIterator__SWIG_0(long j, GuideIterator guideIterator);

    public static final native long new_GuidePositioning();

    public static final native long new_HSLColorInversionPolicy();

    public static final native long new_HorizontalLineSet(float f, float f2, int i, int i2, float f3, float f4);

    public static final native long new_IGlyph_getAlternateAt_result_t();

    public static final native long new_IdentityColorInversionPolicy();

    public static final native long new_InkStroke__SWIG_0(long j, InkStroke inkStroke);

    public static final native long new_InkStyle();

    public static final native long new_InputCharacter__SWIG_0();

    public static final native long new_InputCharacter__SWIG_1(long j, InputCharacter inputCharacter);

    public static final native long new_Insets__SWIG_0();

    public static final native long new_Insets__SWIG_1(float f, float f2, float f3, float f4);

    public static final native long new_IntInterval__SWIG_0();

    public static final native long new_IntInterval__SWIG_1(int i, int i2);

    public static final native long new_Json(long j, Json json);

    public static final native long new_JsonObjectIterator__SWIG_0(long j);

    public static final native long new_JsonObjectIterator__SWIG_1(long j, JsonObjectIterator jsonObjectIterator);

    public static final native long new_LanguageUpdater();

    public static final native long new_LayoutItemArc(long j, long j2, byte[] bArr, byte[] bArr2);

    public static final native long new_LayoutItemGuide__SWIG_0(byte[] bArr, long j, GuideData guideData, long j2, GuidePositioning guidePositioning, long j3, byte[] bArr2);

    public static final native long new_LayoutItemGuide__SWIG_1(byte[] bArr, long j, GuideData guideData, long j2, GuidePositioning guidePositioning, long j3, byte[] bArr2, byte[] bArr3);

    public static final native long new_LayoutItemIterator__SWIG_0(long j, LayoutItemIterator layoutItemIterator);

    public static final native long new_LayoutItemLine(long j, long j2, byte[] bArr, byte[] bArr2);

    public static final native long new_LayoutItemPoint(long j, long j2, byte[] bArr, byte[] bArr2);

    public static final native long new_LayoutItemString(long j, Glyph glyph, long j2, byte[] bArr, byte[] bArr2);

    public static final native long new_LayoutItemStroke(long j, InkStroke inkStroke, long j2, byte[] bArr, byte[] bArr2);

    public static final native long new_LayoutIterator__SWIG_0(long j, boolean z);

    public static final native long new_LayoutIterator__SWIG_2(long j, Selection selection);

    public static final native long new_LayoutObjectData();

    public static final native long new_Layout__SWIG_0();

    public static final native long new_Layout__SWIG_1(long j, Layout layout);

    public static final native long new_LineSegment();

    public static final native long new_Line__SWIG_0();

    public static final native long new_Line__SWIG_1(long j, Point point, long j2, Point point2);

    public static final native long new_LogIndenter__SWIG_0(long j, Logger logger, int i);

    public static final native long new_LogIndenter__SWIG_1(long j, Logger logger);

    public static final native long new_Logger__SWIG_0(int i, long j, long j2);

    public static final native long new_Logger__SWIG_1(int i, long j);

    public static final native long new_MapCompare();

    public static final native long new_MessageNotifier();

    public static final native long new_ModelLock__SWIG_0(long j, Page page);

    public static final native long new_ModelLock__SWIG_1(long j, Document document);

    public static final native long new_ModelLock__SWIG_2(long j, Layout layout);

    public static final native long new_ModelLock__SWIG_3(long j, Content content);

    public static final native long new_MotionEvent();

    public static final native long new_MotionEventPredictor();

    public static final native long new_MotionFilter();

    public static final native long new_MotionPredictionParams();

    public static final native long new_PageFormat__SWIG_0(float f, float f2, float f3, float f4, float f5, float f6);

    public static final native long new_PageFormat__SWIG_1(float f, float f2, float f3);

    public static final native long new_Page__SWIG_0();

    public static final native long new_Page__SWIG_1(long j, Page page);

    public static final native long new_Parallelogram();

    public static final native long new_PathToStrokeOffsets();

    public static final native long new_Path__SWIG_0();

    public static final native long new_Path__SWIG_1(long j, SWIGVectorPointerInfo sWIGVectorPointerInfo);

    public static final native long new_Path__SWIG_2(long j, Path path);

    public static final native long new_PendingStroke__SWIG_0(int i, long j, InkStroke inkStroke, byte[] bArr, byte[] bArr2, long j2, InkStyle inkStyle, long j3, int i2, int i3, int i4, byte[] bArr3, long j4, long j5);

    public static final native long new_PendingStroke__SWIG_1(int i, long j, InkStroke inkStroke, byte[] bArr, byte[] bArr2, long j2, InkStyle inkStyle, long j3, int i2, int i3, int i4, byte[] bArr3, long j4);

    public static final native long new_PendingStroke__SWIG_2(int i, long j, InkStroke inkStroke, byte[] bArr, byte[] bArr2, long j2, InkStyle inkStyle, long j3, int i2, int i3, int i4, byte[] bArr3);

    public static final native long new_PendingStroke__SWIG_3(int i, long j, InkStroke inkStroke, byte[] bArr, byte[] bArr2, long j2, InkStyle inkStyle, long j3, int i2, int i3, int i4);

    public static final native long new_PendingStroke__SWIG_4(long j, PendingStroke pendingStroke);

    public static final native long new_PendingStroke__SWIG_5(long j);

    public static final native long new_Point__SWIG_0();

    public static final native long new_Point__SWIG_1(float f, float f2);

    public static final native long new_Point__SWIG_2(long j, PointerInfo pointerInfo);

    public static final native long new_Point__SWIG_3(long j, float f);

    public static final native long new_Point__SWIG_4(long j);

    public static final native long new_PointerInfoData();

    public static final native long new_PointerInfo__SWIG_0();

    public static final native long new_PointerInfo__SWIG_1(float f, float f2);

    public static final native long new_PointerInfo__SWIG_10(float f, float f2, long j, float f3, float f4, float f5, int i, int i2);

    public static final native long new_PointerInfo__SWIG_11(float f, float f2, long j, float f3, float f4, float f5, int i);

    public static final native long new_PointerInfo__SWIG_12(float f, float f2, long j, float f3, float f4, float f5);

    public static final native long new_PointerInfo__SWIG_13(long j, Point point);

    public static final native long new_PointerInfo__SWIG_14(long j, Point point, long j2, float f, int i, int i2, int i3, long j3);

    public static final native long new_PointerInfo__SWIG_15(long j, Point point, long j2, float f, int i, int i2, int i3);

    public static final native long new_PointerInfo__SWIG_16(long j, Point point, long j2, float f, int i, int i2);

    public static final native long new_PointerInfo__SWIG_17(long j, Point point, long j2, float f, int i);

    public static final native long new_PointerInfo__SWIG_18(long j, Point point, long j2, float f);

    public static final native long new_PointerInfo__SWIG_19(long j, Point point, long j2);

    public static final native long new_PointerInfo__SWIG_2(float f, float f2, long j, float f3, int i, int i2, int i3, long j2);

    public static final native long new_PointerInfo__SWIG_20(float f, float f2, long j, PointerInfoData pointerInfoData);

    public static final native long new_PointerInfo__SWIG_21(long j, Point point, long j2, PointerInfoData pointerInfoData);

    public static final native long new_PointerInfo__SWIG_22(long j, PointerInfoData pointerInfoData);

    public static final native long new_PointerInfo__SWIG_3(float f, float f2, long j, float f3, int i, int i2, int i3);

    public static final native long new_PointerInfo__SWIG_4(float f, float f2, long j, float f3, int i, int i2);

    public static final native long new_PointerInfo__SWIG_5(float f, float f2, long j, float f3, int i);

    public static final native long new_PointerInfo__SWIG_6(float f, float f2, long j, float f3);

    public static final native long new_PointerInfo__SWIG_7(float f, float f2, long j);

    public static final native long new_PointerInfo__SWIG_8(float f, float f2, long j, float f3, float f4, float f5, int i, int i2, int i3, long j2);

    public static final native long new_PointerInfo__SWIG_9(float f, float f2, long j, float f3, float f4, float f5, int i, int i2, int i3);

    public static final native long new_Rectangle__SWIG_0();

    public static final native long new_Rectangle__SWIG_1(float f, float f2, float f3, float f4);

    public static final native long new_Rectangle__SWIG_2(long j, Point point, long j2, Point point2);

    public static final native long new_Renderer__SWIG_0(long j, Layout layout, long j2, long j3);

    public static final native long new_Renderer__SWIG_1(long j, Layout layout, long j2);

    public static final native long new_Renderer__SWIG_2(long j, Layout layout);

    public static final native long new_RenderingUpdateSession(long j, Renderer renderer);

    public static final native long new_SWIGGlyphMetricsList();

    public static final native long new_SWIGRectangleList();

    public static final native long new_SWIGVectorAtkStringType();

    public static final native long new_SWIGVectorChildPageSpec();

    public static final native long new_SWIGVectorCustomResource();

    public static final native long new_SWIGVectorExtent();

    public static final native long new_SWIGVectorGlyph();

    public static final native long new_SWIGVectorGlyphLines();

    public static final native long new_SWIGVectorInkStyle();

    public static final native long new_SWIGVectorMimeType();

    public static final native long new_SWIGVectorMotionEvent();

    public static final native long new_SWIGVectorParallelogram();

    public static final native long new_SWIGVectorPendingStroke();

    public static final native long new_SWIGVectorPoint();

    public static final native long new_SWIGVectorPointerInfo();

    public static final native long new_SWIGVectorSpanInterval();

    public static final native long new_SWIGVectorString();

    public static final native long new_SWIGVectorTagId();

    public static final native long new_Selection__SWIG_0(long j, Page page);

    public static final native long new_Selection__SWIG_1(long j, Layout layout);

    public static final native long new_Selection__SWIG_2(long j, Content content);

    public static final native long new_Selection__SWIG_3(long j, Selection selection);

    public static final native long new_SemiAxis__SWIG_0();

    public static final native long new_SemiAxis__SWIG_1(int i, float f, boolean z);

    public static final native long new_SinglePointerPredictor();

    public static final native long new_SpanInterval(int i, int i2);

    public static final native long new_Sprite__SWIG_0(long j);

    public static final native long new_Sprite__SWIG_1(long j, long j2, Rectangle rectangle, long j3, Extent extent, long j4, Transform transform);

    public static final native long new_Sprite__SWIG_2(long j, Sprite sprite);

    public static final native long new_StateMachineLock__SWIG_0(long j, boolean z);

    public static final native long new_StateMachineLock__SWIG_1(long j);

    public static final native long new_StateMachineLock__SWIG_2(long j, long j2, boolean z);

    public static final native long new_StateMachineLock__SWIG_3(long j, long j2);

    public static final native long new_StateMachineLock__SWIG_4(long j, StateMachineLock stateMachineLock);

    public static final native long new_StrokeOffsets();

    public static final native long new_StyleSelectorIterator(long j, StyleSelectorIterator styleSelectorIterator);

    public static final native long new_TextImpl(byte[] bArr);

    public static final native long new_TimingOffsets();

    public static final native long new_Transform__SWIG_0();

    public static final native long new_Transform__SWIG_1(float f, float f2, float f3, float f4);

    public static final native long new_Transform__SWIG_2(float f, float f2, float f3, float f4, float f5, float f6);

    public static final native long new_Transform__SWIG_3(long j, long j2, Point point);

    public static final native long new_TransitionContext();

    public static final native long new_TypesetData(long j, TypesetData typesetData);

    public static final native long new_TypesetItem(long j, TypesetItem typesetItem);

    public static final native long new_URINotifier();

    public static final native long new_ValuedAngle__SWIG_0();

    public static final native long new_ValuedAngle__SWIG_1(double d);

    public static final native long new_VerticalLineSet(float f, float f2, int i, int i2, float f3, float f4);

    public static final native long new_ViewTransform(float f, float f2);

    public static final native int patternFromString(byte[] bArr);

    public static final native byte[] patternToString(int i);

    ATKCoreJNI() {
    }
}

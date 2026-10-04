package com.pdftron.pdf;

import android.R;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.GestureDetector;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.OverScroller;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.filters.SecondaryFileFilter;
import com.pdftron.pdf.C6963b;
import com.pdftron.pdf.C6966e;
import com.pdftron.pdf.ImageCache;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.pdftron.sdf.DictIterator;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.ObjSet;
import com.pdftron.sdf.SDFDoc;
import com.pdftron.sdf.SecurityHandler;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes7.dex */
public class PDFViewCtrl extends ViewGroup {
    public static final double SCROLL_ZOOM_FACTOR = 1.5d;

    /* JADX INFO: renamed from: a */
    static boolean f1639a = false;

    /* JADX INFO: renamed from: b */
    static boolean f1640b = false;

    /* JADX INFO: renamed from: c */
    private static final String f1641c = "com.pdftron.pdf.PDFViewCtrl";

    /* JADX INFO: renamed from: A */
    private boolean f1643A;

    /* JADX INFO: renamed from: B */
    private PointF f1644B;

    /* JADX INFO: renamed from: C */
    private final Lock f1645C;

    /* JADX INFO: renamed from: D */
    private int f1646D;

    /* JADX INFO: renamed from: E */
    private int f1647E;

    /* JADX INFO: renamed from: F */
    private int f1648F;

    /* JADX INFO: renamed from: G */
    private int f1649G;

    /* JADX INFO: renamed from: H */
    private int f1650H;

    /* JADX INFO: renamed from: I */
    private SparseArray<android.graphics.Rect> f1651I;

    /* JADX INFO: renamed from: J */
    private List<Integer> f1652J;

    /* JADX INFO: renamed from: L */
    private Set<Long> f1653L;

    /* JADX INFO: renamed from: M */
    private boolean f1654M;

    /* JADX INFO: renamed from: N */
    private int f1655N;

    /* JADX INFO: renamed from: O */
    private int f1656O;

    /* JADX INFO: renamed from: P */
    private boolean f1657P;

    /* JADX INFO: renamed from: Q */
    private boolean f1658Q;

    /* JADX INFO: renamed from: R */
    private boolean f1659R;

    /* JADX INFO: renamed from: S */
    private boolean f1660S;

    /* JADX INFO: renamed from: T */
    private boolean f1661T;

    /* JADX INFO: renamed from: U */
    private boolean f1662U;

    /* JADX INFO: renamed from: V */
    private boolean f1663V;

    /* JADX INFO: renamed from: W */
    private boolean f1664W;

    /* JADX INFO: renamed from: aA */
    private int f1665aA;

    /* JADX INFO: renamed from: aB */
    private int f1666aB;

    /* JADX INFO: renamed from: aC */
    private int f1667aC;

    /* JADX INFO: renamed from: aD */
    private int f1668aD;

    /* JADX INFO: renamed from: aE */
    private int f1669aE;

    /* JADX INFO: renamed from: aF */
    private int f1670aF;

    /* JADX INFO: renamed from: aG */
    private int f1671aG;

    /* JADX INFO: renamed from: aH */
    private int f1672aH;

    /* JADX INFO: renamed from: aI */
    private int f1673aI;

    /* JADX INFO: renamed from: aJ */
    private int f1674aJ;

    /* JADX INFO: renamed from: aK */
    private int f1675aK;

    /* JADX INFO: renamed from: aL */
    private int f1676aL;

    /* JADX INFO: renamed from: aM */
    private RectF f1677aM;

    /* JADX INFO: renamed from: aN */
    private RectF f1678aN;

    /* JADX INFO: renamed from: aO */
    private SparseArray<RectF> f1679aO;

    /* JADX INFO: renamed from: aP */
    private SparseArray<RectF> f1680aP;

    /* JADX INFO: renamed from: aQ */
    private int f1681aQ;

    /* JADX INFO: renamed from: aR */
    private float f1682aR;

    /* JADX INFO: renamed from: aS */
    private float f1683aS;

    /* JADX INFO: renamed from: aT */
    private float f1684aT;

    /* JADX INFO: renamed from: aU */
    private float f1685aU;

    /* JADX INFO: renamed from: aV */
    private float f1686aV;

    /* JADX INFO: renamed from: aW */
    private float f1687aW;

    /* JADX INFO: renamed from: aX */
    private float f1688aX;

    /* JADX INFO: renamed from: aY */
    private int f1689aY;

    /* JADX INFO: renamed from: aZ */
    private int f1690aZ;

    /* JADX INFO: renamed from: aa */
    private boolean f1691aa;

    /* JADX INFO: renamed from: ab */
    private boolean f1692ab;

    /* JADX INFO: renamed from: ac */
    private boolean f1693ac;

    /* JADX INFO: renamed from: ad */
    private MotionEvent f1694ad;

    /* JADX INFO: renamed from: ae */
    private boolean f1695ae;

    /* JADX INFO: renamed from: af */
    private Matrix f1696af;

    /* JADX INFO: renamed from: ag */
    private Matrix f1697ag;

    /* JADX INFO: renamed from: ah */
    private android.graphics.Rect f1698ah;

    /* JADX INFO: renamed from: ai */
    private android.graphics.Rect f1699ai;

    /* JADX INFO: renamed from: aj */
    private RectF f1700aj;

    /* JADX INFO: renamed from: ak */
    private RectF f1701ak;

    /* JADX INFO: renamed from: al */
    private Paint f1702al;

    /* JADX INFO: renamed from: am */
    private Paint f1703am;

    /* JADX INFO: renamed from: an */
    private Paint f1704an;

    /* JADX INFO: renamed from: ao */
    private Paint f1705ao;

    /* JADX INFO: renamed from: ap */
    private Paint f1706ap;

    /* JADX INFO: renamed from: aq */
    private Paint f1707aq;

    /* JADX INFO: renamed from: ar */
    private Paint f1708ar;

    /* JADX INFO: renamed from: as */
    private Paint f1709as;

    /* JADX INFO: renamed from: at */
    private Paint f1710at;

    /* JADX INFO: renamed from: au */
    private Paint f1711au;

    /* JADX INFO: renamed from: av */
    private Paint f1712av;

    /* JADX INFO: renamed from: aw */
    private Paint f1713aw;

    /* JADX INFO: renamed from: ax */
    private Paint f1714ax;

    /* JADX INFO: renamed from: ay */
    private Paint f1715ay;

    /* JADX INFO: renamed from: az */
    private C6966e.a[] f1716az;

    /* JADX INFO: renamed from: bA */
    private TextSearchListener f1717bA;

    /* JADX INFO: renamed from: bB */
    private ArrayList<TextSearchListener> f1718bB;

    /* JADX INFO: renamed from: bC */
    private CopyOnWriteArrayList<DocumentDownloadListener> f1719bC;

    /* JADX INFO: renamed from: bD */
    private CopyOnWriteArrayList<UniversalDocumentConversionListener> f1720bD;

    /* JADX INFO: renamed from: bE */
    private boolean f1721bE;

    /* JADX INFO: renamed from: bF */
    private CopyOnWriteArrayList<PageChangeListener> f1722bF;

    /* JADX INFO: renamed from: bG */
    private int f1723bG;

    /* JADX INFO: renamed from: bH */
    private int f1724bH;

    /* JADX INFO: renamed from: bI */
    private PageChangeState f1725bI;

    /* JADX INFO: renamed from: bJ */
    private CopyOnWriteArrayList<DocumentLoadListener> f1726bJ;

    /* JADX INFO: renamed from: bK */
    private boolean f1727bK;

    /* JADX INFO: renamed from: bL */
    private ErrorReportListener f1728bL;

    /* JADX INFO: renamed from: bM */
    private ArrayList<ThumbAsyncListener> f1729bM;

    /* JADX INFO: renamed from: bN */
    private ArrayList<PageSlidingListener> f1730bN;

    /* JADX INFO: renamed from: bO */
    private ActionCompletedListener f1731bO;

    /* JADX INFO: renamed from: bP */
    private RenderingListener f1732bP;

    /* JADX INFO: renamed from: bQ */
    private UniversalDocumentProgressIndicatorListener f1733bQ;

    /* JADX INFO: renamed from: bR */
    private boolean f1734bR;

    /* JADX INFO: renamed from: bS */
    private AlertDialogC6939c f1735bS;

    /* JADX INFO: renamed from: bT */
    private ToolManager f1736bT;

    /* JADX INFO: renamed from: bU */
    private PageViewMode f1737bU;

    /* JADX INFO: renamed from: bV */
    private PageViewMode f1738bV;

    /* JADX INFO: renamed from: bW */
    private PagePresentationMode f1739bW;

    /* JADX INFO: renamed from: bX */
    private boolean f1740bX;

    /* JADX INFO: renamed from: bY */
    private boolean f1741bY;

    /* JADX INFO: renamed from: bZ */
    private boolean f1742bZ;

    /* JADX INFO: renamed from: ba */
    private float f1743ba;

    /* JADX INFO: renamed from: bb */
    private float f1744bb;

    /* JADX INFO: renamed from: bc */
    private float f1745bc;

    /* JADX INFO: renamed from: bd */
    private float f1746bd;

    /* JADX INFO: renamed from: be */
    private float f1747be;

    /* JADX INFO: renamed from: bf */
    private boolean f1748bf;

    /* JADX INFO: renamed from: bg */
    private double f1749bg;

    /* JADX INFO: renamed from: bh */
    private double f1750bh;

    /* JADX INFO: renamed from: bi */
    private ZoomLimitMode f1751bi;

    /* JADX INFO: renamed from: bj */
    private double f1752bj;

    /* JADX INFO: renamed from: bk */
    private double f1753bk;

    /* JADX INFO: renamed from: bl */
    private double f1754bl;

    /* JADX INFO: renamed from: bm */
    private double f1755bm;

    /* JADX INFO: renamed from: bn */
    private double f1756bn;

    /* JADX INFO: renamed from: bo */
    private int f1757bo;

    /* JADX INFO: renamed from: bp */
    private float f1758bp;

    /* JADX INFO: renamed from: bq */
    private float f1759bq;

    /* JADX INFO: renamed from: br */
    private boolean f1760br;

    /* JADX INFO: renamed from: bs */
    private PointF f1761bs;

    /* JADX INFO: renamed from: bt */
    private float f1762bt;

    /* JADX INFO: renamed from: bu */
    private boolean f1763bu;

    /* JADX INFO: renamed from: bv */
    private boolean f1764bv;

    /* JADX INFO: renamed from: bw */
    private boolean f1765bw;

    /* JADX INFO: renamed from: bx */
    private int f1766bx;

    /* JADX INFO: renamed from: by */
    private boolean f1767by;

    /* JADX INFO: renamed from: bz */
    private boolean f1768bz;

    /* JADX INFO: renamed from: cA */
    private boolean f1769cA;

    /* JADX INFO: renamed from: cB */
    private boolean f1770cB;

    /* JADX INFO: renamed from: cC */
    private boolean f1771cC;

    /* JADX INFO: renamed from: cD */
    private CopyOnWriteArrayList<OnCanvasSizeChangeListener> f1772cD;

    /* JADX INFO: renamed from: cE */
    private CopyOnWriteArrayList<OnPageLayoutChangeListener> f1773cE;

    /* JADX INFO: renamed from: cF */
    private C6957u f1774cF;

    /* JADX INFO: renamed from: cG */
    private int f1775cG;

    /* JADX INFO: renamed from: cH */
    private SparseArray<double[]> f1776cH;

    /* JADX INFO: renamed from: cI */
    private android.graphics.Rect f1777cI;

    /* JADX INFO: renamed from: cJ */
    private android.graphics.Rect f1778cJ;

    /* JADX INFO: renamed from: cK */
    private android.graphics.Rect f1779cK;

    /* JADX INFO: renamed from: cL */
    private android.graphics.Rect f1780cL;

    /* JADX INFO: renamed from: cM */
    private android.graphics.Rect f1781cM;

    /* JADX INFO: renamed from: cN */
    private android.graphics.Rect f1782cN;

    /* JADX INFO: renamed from: cO */
    private android.graphics.Rect f1783cO;

    /* JADX INFO: renamed from: cP */
    private RectF f1784cP;

    /* JADX INFO: renamed from: cQ */
    private RectF f1785cQ;

    /* JADX INFO: renamed from: cR */
    private RectF f1786cR;

    /* JADX INFO: renamed from: cS */
    private float f1787cS;

    /* JADX INFO: renamed from: cT */
    private float f1788cT;

    /* JADX INFO: renamed from: cU */
    private float f1789cU;

    /* JADX INFO: renamed from: cV */
    private float f1790cV;

    /* JADX INFO: renamed from: cW */
    private UniversalDocumentConversionListener f1791cW;

    /* JADX INFO: renamed from: cX */
    private final AtomicInteger f1792cX;

    /* JADX INFO: renamed from: cY */
    private final AtomicBoolean f1793cY;

    /* JADX INFO: renamed from: cZ */
    private boolean f1794cZ;

    /* JADX INFO: renamed from: ca */
    private boolean f1795ca;

    /* JADX INFO: renamed from: cb */
    private boolean f1796cb;

    /* JADX INFO: renamed from: cc */
    private boolean f1797cc;

    /* JADX INFO: renamed from: cd */
    private int f1798cd;

    /* JADX INFO: renamed from: ce */
    private int f1799ce;

    /* JADX INFO: renamed from: cf */
    private C6946j f1800cf;

    /* JADX INFO: renamed from: cg */
    private Object f1801cg;

    /* JADX INFO: renamed from: ch */
    private int f1802ch;

    /* JADX INFO: renamed from: ci */
    private int f1803ci;

    /* JADX INFO: renamed from: cj */
    private final Lock f1804cj;

    /* JADX INFO: renamed from: ck */
    private boolean f1805ck;

    /* JADX INFO: renamed from: cl */
    private boolean f1806cl;

    /* JADX INFO: renamed from: cm */
    private boolean f1807cm;

    /* JADX INFO: renamed from: cn */
    private int f1808cn;

    /* JADX INFO: renamed from: co */
    private int f1809co;

    /* JADX INFO: renamed from: cp */
    private boolean f1810cp;

    /* JADX INFO: renamed from: cq */
    private boolean f1811cq;

    /* JADX INFO: renamed from: cr */
    private EnumC6951o f1812cr;

    /* JADX INFO: renamed from: cs */
    private EnumC6950n f1813cs;

    /* JADX INFO: renamed from: ct */
    private float f1814ct;

    /* JADX INFO: renamed from: cu */
    private float f1815cu;

    /* JADX INFO: renamed from: cv */
    private float f1816cv;

    /* JADX INFO: renamed from: cw */
    private boolean f1817cw;

    /* JADX INFO: renamed from: cx */
    private SparseIntArray f1818cx;

    /* JADX INFO: renamed from: cy */
    private SparseIntArray f1819cy;

    /* JADX INFO: renamed from: cz */
    private PageViewMode f1820cz;

    /* JADX INFO: renamed from: da */
    private int[] f1821da;

    /* JADX INFO: renamed from: db */
    private long f1822db;

    /* JADX INFO: renamed from: dc */
    private long f1823dc;

    /* JADX INFO: renamed from: dd */
    private long f1824dd;

    /* JADX INFO: renamed from: de */
    private GestureDetector f1825de;

    /* JADX INFO: renamed from: df */
    private ScaleGestureDetector f1826df;

    /* JADX INFO: renamed from: dg */
    private final HandlerC6945i f1827dg;

    /* JADX INFO: renamed from: dh */
    private final HandlerC6949m f1828dh;

    /* JADX INFO: renamed from: di */
    private final HandlerC6947k f1829di;

    /* JADX INFO: renamed from: dj */
    private final HandlerC6940d f1830dj;

    /* JADX INFO: renamed from: dk */
    private final HandlerC6938b f1831dk;

    /* JADX INFO: renamed from: dl */
    private final HandlerC6948l f1832dl;

    /* JADX INFO: renamed from: dm */
    private final HandlerC6944h f1833dm;

    /* JADX INFO: renamed from: dn */
    private final HandlerC6953q f1834dn;

    /* JADX INFO: renamed from: do */
    private final HandlerC6952p f1835do;

    /* JADX INFO: renamed from: dp */
    private final HandlerC6956t f1836dp;

    /* JADX INFO: renamed from: dq */
    private final HandlerC6943g f1837dq;

    /* JADX INFO: renamed from: dr */
    private final HandlerC6941e f1838dr;

    /* JADX INFO: renamed from: ds */
    private final HandlerC6942f f1839ds;

    /* JADX INFO: renamed from: dt */
    private final HandlerC6955s f1840dt;

    /* JADX INFO: renamed from: du */
    private final HandlerC6937a f1841du;

    /* JADX INFO: renamed from: dv */
    private final HandlerC6954r f1842dv;

    /* JADX INFO: renamed from: dw */
    private Thread f1843dw;

    /* JADX INFO: renamed from: e */
    private ExternalAnnotManager f1844e;

    /* JADX INFO: renamed from: f */
    private OverScroller f1845f;

    /* JADX INFO: renamed from: g */
    private OverScroller f1846g;

    /* JADX INFO: renamed from: h */
    private OverScroller f1847h;

    /* JADX INFO: renamed from: i */
    private C6967f f1848i;

    /* JADX INFO: renamed from: j */
    private final Lock f1849j;

    /* JADX INFO: renamed from: k */
    private final Lock f1850k;

    /* JADX INFO: renamed from: l */
    private C6966e f1851l;

    /* JADX INFO: renamed from: m */
    private C6964c f1852m;
    protected PDFDoc mDoc;
    protected SecondaryFileFilter mDocumentConversionFilter;

    /* JADX INFO: renamed from: n */
    private Bitmap f1853n;

    /* JADX INFO: renamed from: o */
    private boolean f1854o;

    /* JADX INFO: renamed from: p */
    private int f1855p;

    /* JADX INFO: renamed from: q */
    private int f1856q;

    /* JADX INFO: renamed from: r */
    private boolean f1857r;

    /* JADX INFO: renamed from: s */
    private boolean f1858s;

    /* JADX INFO: renamed from: t */
    private boolean f1859t;

    /* JADX INFO: renamed from: u */
    private boolean f1860u;

    /* JADX INFO: renamed from: v */
    private int f1861v;

    /* JADX INFO: renamed from: w */
    private boolean f1862w;

    /* JADX INFO: renamed from: x */
    private int f1863x;

    /* JADX INFO: renamed from: y */
    private int f1864y;

    /* JADX INFO: renamed from: z */
    private int f1865z;

    /* JADX INFO: renamed from: d */
    private static boolean f1642d = false;

    /* JADX INFO: renamed from: K */
    private static int f1638K = 2;
    public static int DEFAULT_BG_COLOR = -1709592;
    public static int DEFAULT_DARK_BG_COLOR = -14606047;

    public interface ActionCompletedListener {
        void onActionCompleted(Action action);
    }

    public interface DocumentDownloadListener {
        void onDownloadEvent(DownloadState downloadState, int i, int i2, int i3, String str);
    }

    public interface DocumentLoadListener {
        void onDocumentLoaded();
    }

    public interface ErrorReportListener {
        void onErrorReportEvent(String str);
    }

    public interface LockRunnable {
        void run() throws Exception;
    }

    public interface OnCanvasSizeChangeListener {
        void onCanvasSizeChanged();
    }

    public interface OnPageLayoutChangeListener {
        void onPageLayoutChanged();
    }

    public interface PageChangeListener {
        void onPageChange(int i, int i2, PageChangeState pageChangeState);
    }

    public interface PageSlidingListener {
        void onScrollOffsetChanged(int i, int i2);
    }

    public interface RenderingListener {
        void onRenderingFinished();

        void onRenderingStarted();
    }

    public interface TextSearchListener {
        void onTextSearchEnd(TextSearchResult textSearchResult);

        void onTextSearchProgress(int i);

        void onTextSearchStart();
    }

    public interface ThumbAsyncListener {
        void onThumbReceived(int i, int[] iArr, int i2, int i3);
    }

    public interface ToolManager {
        boolean isCreatingAnnotation();

        void onAnnotPainterUpdated(int i, long j, CurvePainter curvePainter);

        void onChangePointerIcon(PointerIcon pointerIcon);

        void onClose();

        void onConfigurationChanged(Configuration configuration);

        void onControlReady();

        void onCustomEvent(Object obj);

        void onDestroy();

        void onDocumentDownloadEvent(DownloadState downloadState, int i, int i2, int i3, String str);

        boolean onDoubleTap(MotionEvent motionEvent);

        void onDoubleTapEnd(MotionEvent motionEvent);

        boolean onDoubleTapEvent(MotionEvent motionEvent);

        void onDoubleTapZoomAnimationBegin();

        void onDoubleTapZoomAnimationEnd();

        boolean onDown(MotionEvent motionEvent);

        void onDraw(Canvas canvas, Matrix matrix);

        boolean onDrawEdgeEffects(Canvas canvas, int i, int i2);

        boolean onFlingStop();

        boolean onGenericMotionEvent(MotionEvent motionEvent);

        boolean onKeyUp(int i, KeyEvent keyEvent);

        void onLayout(boolean z, int i, int i2, int i3, int i4);

        boolean onLongPress(MotionEvent motionEvent);

        boolean onMove(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        void onPageTurning(int i, int i2);

        void onPause();

        boolean onPointerDown(MotionEvent motionEvent);

        void onPostSingleTapConfirmed();

        void onPullEdgeEffects(int i, float f);

        void onReleaseEdgeEffects();

        void onRenderingFinished();

        void onResume();

        boolean onScale(float f, float f2);

        boolean onScaleBegin(float f, float f2);

        boolean onScaleEnd(float f, float f2);

        void onScrollChanged(int i, int i2, int i3, int i4);

        void onSetDoc();

        boolean onShowPress(MotionEvent motionEvent);

        boolean onSingleTapConfirmed(MotionEvent motionEvent);

        boolean onSingleTapUp(MotionEvent motionEvent);

        boolean onUp(MotionEvent motionEvent, PriorEventMode priorEventMode);
    }

    public interface UniversalDocumentConversionListener {
        void onConversionEvent(ConversionState conversionState, int i);
    }

    public interface UniversalDocumentProgressIndicatorListener {
        void onAddProgressIndicator();

        void onPositionProgressIndicatorPage(Rect rect);

        void onProgressIndicatorPageVisibilityChanged(boolean z);

        void onRemoveContentPendingIndicator();

        void onRemoveProgressIndicator();

        void onShowContentPendingIndicator();
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$n */
    enum EnumC6950n {
        SCALE,
        VERTICAL_SCROLL,
        HORIZONTAL_SCROLL,
        UNKNOWN
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$o */
    enum EnumC6951o {
        VERTICAL,
        HORIZONTAL,
        NONE,
        UNKNOWN
    }

    private static native boolean CanRedo(long j);

    private static native boolean CanUndo(long j);

    private static native void CancelAllThumbRequests(long j);

    private static native void CancelFindText(long j);

    private static native void CancelRendering(long j);

    private static native void CancelRenderingAsync(long j);

    private static native void ClearSelection(long j);

    private static native void ClearThumbCache(long j);

    private static native void CloseDoc(long j);

    private static native double[] ConvCanvasPtToPagePt(long j, double d, double d2, int i);

    private static native double[] ConvCanvasPtToScreenPt(long j, double d, double d2);

    private static native double[] ConvCanvasPtToScreenPt(long j, double d, double d2, int i);

    private static native double[] ConvPagePtToCanvasPt(long j, double d, double d2, int i);

    private static native double[] ConvPagePtToScreenPt(long j, double d, double d2, int i);

    private static native double[] ConvScreenPtToCanvasPt(long j, double d, double d2);

    private static native double[] ConvScreenPtToCanvasPt(long j, double d, double d2, int i);

    private static native double[] ConvScreenPtToPagePt(long j, double d, double d2, int i);

    private static native void Destroy(long j);

    private static native void DestroyRenderData(long j, long j2, long j3, long j4, long j5, long j6, long j7);

    private static native void DoProgressiveRender(long j);

    private static native void DocLock(long j, boolean z);

    private static native void DocLockRead(long j);

    private static native boolean DocTryLock(long j, int i);

    private static native boolean DocTryLockRead(long j, int i);

    private static native void DocUnlock(long j);

    private static native void DocUnlockRead(long j);

    private static native void DownloaderFinishedDownload(long j, long j2);

    private static native boolean DownloaderIsCorrectDoc(long j, long j2);

    private static native void DownloaderOpened(long j, long j2);

    private static native void DownloaderUpdateOutline(long j, long j2);

    private static native boolean DownloaderUpdatePage(long j, long j2, int i, int i2);

    private static native void DownloaderUpdateThumb(long j, long j2, int i, int i2);

    private static native void EnableFloatingAnnotTiles(long j, long j2, int i);

    private static native void EnableUndoRedo(long j);

    private static native void ExecuteAction(long j, long j2);

    private static native void FindTextAsync(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, int i);

    private static native long[] GetAllCanvasPixelSizes(long j);

    private static native int GetAnnotTypeUnder(long j, double d, double d2);

    private static native long GetAnnotationAt(long j, int i, int i2, double d, double d2);

    private static native long[] GetAnnotationListAt(long j, int i, int i2, int i3, int i4);

    private static native long[] GetAnnotationsOnPage(long j, int i);

    private static native double GetCanvasHeight(long j);

    private static native double GetCanvasWidth(long j);

    private static native int GetColorPostProcessMode(long j);

    private static native int GetCurCanvasId(long j);

    private static native int GetCurrentPage(long j);

    private static native long GetDeviceTransform(long j, int i);

    private static native long GetExternalAnnotManager(long j, String str, int i);

    private static native double GetFindTextProgress(long j);

    private static native double GetHScrollPos(long j);

    private static native LinkInfo GetLinkAt(long j, int i, int i2);

    private static native String GetNextRedoInfo(long j);

    private static native String GetNextUndoInfo(long j);

    private static native long GetOCGContext(long j);

    private static native int GetPageBox(long j);

    private static native int GetPageNumberFromScreenPt(long j, double d, double d2);

    private static native int GetPagePresentationMode(long j);

    private static native double[] GetPageRects(long j, double d, double d2, double d3, double d4);

    private static native double[] GetPageRectsOnCanvas(long j, int i);

    private static native int GetPageRefViewMode(long j);

    private static native int[] GetPageSpacing(long j);

    private static native int GetPageViewMode(long j);

    private static native int GetPagesCount(long j);

    private static native long GetPostProcessedColor(long j, long j2);

    private static native double GetRefZoom(long j, int i);

    private static native double GetRefZoomForPage(long j, int i, int i2);

    private static native int GetRotation(long j);

    private static native long GetScreenRectForAnnot(long j, long j2, int i);

    private static native long GetSelection(long j, int i);

    private static native int GetSelectionBeginPage(long j);

    private static native int GetSelectionEndPage(long j);

    private static native void GetThumbAsync(long j, long j2, long j3);

    private static native int GetTilingRegionHeight(long j);

    private static native int GetTilingRegionWidth(long j);

    private static native double GetVScrollPos(long j);

    private static native int[] GetVisiblePages(long j);

    private static native double GetZoom(long j);

    private static native boolean GotoFirstPage(long j);

    private static native boolean GotoLastPage(long j);

    private static native boolean GotoNextPage(long j);

    private static native boolean GotoPreviousPage(long j);

    private static native boolean HasSelection(long j);

    private static native boolean HasSelectionOnPage(long j, int i);

    private static native void HideAnnotation(long j, long j2);

    private static native boolean IsFinishedRendering(long j, boolean z);

    private static native boolean IsThereTextInRect(long j, double d, double d2, double d3, double d4);

    private static native void OnScroll(long j, int i, int i2, boolean z);

    private static native void OnSize(long j, int i, int i2, int i3, boolean z);

    private static native void OpenURL(long j, String str, String str2, String str3, long j2);

    private static native void OpenUniversalDocumentNoDoc(long j, long j2);

    private native long[] PDFViewCtrlCreate(RenderCallback renderCallback);

    private static native void PrepareAnnotsForMouse(long j, int i, double d, double d2);

    private static native void PrepareWords(long j, int i);

    private static native void PurgeMemory(long j);

    private static native String Redo(long j);

    private static native void RefreshAndUpdate(long j, long j2);

    private static native void RequestRender(long j);

    private static native void RevertAllChanges(long j);

    private static native void RotateClockwise(long j);

    private static native void RotateCounterClockwise(long j);

    private static native boolean Select(long j, double d, double d2, double d3, double d4);

    private static native boolean Select(long j, double d, double d2, int i, double d3, double d4, int i2);

    private static native void SelectAll(long j);

    private static native boolean SelectByHighlights(long j, long j2);

    private static native boolean SelectByRect(long j, double d, double d2, double d3, double d4);

    private static native boolean SelectBySelection(long j, long j2);

    private static native boolean SelectByStructWithSmartSnapping(long j, double d, double d2, double d3, double d4);

    private static native boolean SelectByStructWithSnapping(long j, double d, double d2, double d3, double d4, boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String SelectionGetAsHtml(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String SelectionGetAsUnicode(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int SelectionGetPageNum(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native double[] SelectionGetQuads(long j);

    private static native void SetAntiAliasing(long j, boolean z);

    private static native void SetBackgroundColor(long j, byte b, byte b2, byte b3, byte b4);

    private static native void SetCaching(long j, boolean z);

    private static native void SetColorPostProcessColors(long j, int i, int i2);

    private static native void SetColorPostProcessMapFile(long j, long j2);

    private static native void SetColorPostProcessMode(long j, int i);

    private static native boolean SetCurrentPage(long j, int i);

    private static native void SetDefaultPageColor(long j, byte b, byte b2, byte b3);

    private static native void SetDevicePixelDensity(long j, double d, double d2);

    private static native void SetDoc(long j, long j2);

    private static native void SetDrawAnnotations(long j, boolean z);

    private static native void SetFieldHighlightColor(long j, long j2);

    private static native void SetGamma(long j, double d);

    private static native void SetHighlightFields(long j, boolean z);

    private static native void SetHorizontalAlign(long j, int i);

    private static native void SetImageSmoothing(long j, boolean z);

    private static native long SetJavaScriptEventCallback(long j, JavaScriptEventProc javaScriptEventProc, Object obj);

    private static native void SetMemInfo(long j, double d, double d2);

    private static native void SetOCGContext(long j, long j2);

    private static native void SetOverprint(long j, int i);

    private static native void SetPageBorderVisibility(long j, boolean z);

    private static native void SetPageBox(long j, int i);

    private static native void SetPagePresentationMode(long j, int i);

    private static native void SetPageRefViewMode(long j, int i);

    private static native void SetPageSpacing(long j, int i, int i2, int i3, int i4);

    private static native void SetPageTransparencyGrid(long j, boolean z);

    private static native void SetPageViewMode(long j, int i);

    private static native void SetPathHinting(long j, boolean z);

    private static native void SetRequiredFieldBorderColor(long j, long j2);

    private static native void SetRightToLeftLanguage(long j, boolean z);

    private static native void SetSignatureHighlightColor(long j, long j2);

    private static native void SetSnappingMode(long j, int i);

    private static native void SetTextSelectionMode(long j, int i);

    private static native void SetThinLineAdjustment(long j, boolean z, boolean z2);

    private static native void SetUrlExtraction(long j, boolean z);

    private static native void SetVerticalAlign(long j, int i);

    private static native void SetViewerCache(long j, int i, boolean z);

    private static native boolean SetZoom(long j, double d, boolean z);

    private static native boolean SetZoom(long j, int i, int i2, double d, boolean z);

    private static native void SetupThumbnails(long j, boolean z, boolean z2, boolean z3, int i, long j2, double d);

    private static native long ShowAnnotOnPage(long j, long j2, int i);

    private static native void ShowAnnotation(long j, long j2);

    private static native boolean ShowRect(long j, int i, long j2);

    private static native boolean SmartZoom(long j, int i, int i2);

    private static native double[] SnapToNearestInDoc(long j, double d, double d2);

    private static native void TakeSnapshot(long j, String str);

    private static native String Undo(long j);

    private static native void Update(long j, long j2);

    private static native void Update(long j, long j2, int i);

    private static native void Update(long j, boolean z);

    private static native void UpdateField(long j, long j2);

    private static native void UpdateOCGContext(long j);

    private static native void UpdatePageLayout(long j);

    private static native boolean WereAnnotsForMousePrepared(long j, int i);

    private static native boolean WereWordsPrepared(long j, int i);

    /* JADX INFO: renamed from: i */
    private static boolean m1351i(int i) {
        return (i & 1) == 0;
    }

    /* JADX INFO: renamed from: W */
    static /* synthetic */ int m1221W(PDFViewCtrl pDFViewCtrl) {
        int i = pDFViewCtrl.f1766bx;
        pDFViewCtrl.f1766bx = i - 1;
        return i;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m1257a(PDFViewCtrl pDFViewCtrl, PagePresentationMode pagePresentationMode) {
        return m1255a(pagePresentationMode);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m1258a(PDFViewCtrl pDFViewCtrl, boolean z) {
        pDFViewCtrl.f1862w = true;
        return true;
    }

    /* JADX INFO: renamed from: ag */
    static /* synthetic */ int m1280ag(PDFViewCtrl pDFViewCtrl) {
        int i = pDFViewCtrl.f1802ch;
        pDFViewCtrl.f1802ch = i + 1;
        return i;
    }

    /* JADX INFO: renamed from: c */
    static /* synthetic */ boolean m1318c(PDFViewCtrl pDFViewCtrl, boolean z) {
        pDFViewCtrl.f1658Q = true;
        return true;
    }

    /* JADX INFO: renamed from: f */
    static /* synthetic */ boolean m1336f(PDFViewCtrl pDFViewCtrl, int i) {
        return m1351i(i);
    }

    /* JADX INFO: renamed from: f */
    static /* synthetic */ boolean m1337f(PDFViewCtrl pDFViewCtrl, boolean z) {
        pDFViewCtrl.f1659R = true;
        return true;
    }

    /* JADX INFO: renamed from: g */
    static /* synthetic */ boolean m1342g(PDFViewCtrl pDFViewCtrl, boolean z) {
        pDFViewCtrl.f1695ae = true;
        return true;
    }

    /* JADX INFO: renamed from: h */
    static /* synthetic */ boolean m1347h(PDFViewCtrl pDFViewCtrl, boolean z) {
        pDFViewCtrl.f1691aa = false;
        return false;
    }

    /* JADX INFO: renamed from: j */
    static /* synthetic */ boolean m1356j(PDFViewCtrl pDFViewCtrl, boolean z) {
        pDFViewCtrl.f1643A = true;
        return true;
    }

    /* JADX INFO: renamed from: k */
    static /* synthetic */ boolean m1359k(PDFViewCtrl pDFViewCtrl, boolean z) {
        pDFViewCtrl.f1727bK = false;
        return false;
    }

    /* JADX INFO: renamed from: l */
    static /* synthetic */ boolean m1362l(PDFViewCtrl pDFViewCtrl, boolean z) {
        pDFViewCtrl.f1767by = false;
        return false;
    }

    /* JADX INFO: renamed from: m */
    static /* synthetic */ boolean m1365m(PDFViewCtrl pDFViewCtrl, boolean z) {
        pDFViewCtrl.f1768bz = false;
        return false;
    }

    /* JADX INFO: renamed from: n */
    static /* synthetic */ boolean m1368n(PDFViewCtrl pDFViewCtrl, boolean z) {
        pDFViewCtrl.f1721bE = false;
        return false;
    }

    /* JADX INFO: renamed from: a */
    static void m1239a(int i, String str, int i2) {
        try {
            PDFNetInternalTools.logMessage(i, "WRAPPER - " + Process.myTid() + " - " + i2 + ": " + str, "PDFViewCtrl.java", i2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    static int m1230a(boolean z) {
        if (!f1642d) {
            return 0;
        }
        int length = !z ? 1 : 0;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i = f1638K;
        if (i + length >= stackTrace.length) {
            length = (stackTrace.length - 1) - i;
        }
        return stackTrace[i + length].getLineNumber();
    }

    public enum PriorEventMode {
        SCROLLING(1),
        PINCH(2),
        FLING(3),
        DOUBLE_TAP(4),
        PAGE_SLIDING(5),
        OTHER(0);


        /* JADX INFO: renamed from: a */
        private final int f1894a;

        PriorEventMode(int i) {
            this.f1894a = i;
        }

        public final int getValue() {
            return this.f1894a;
        }
    }

    public enum PageViewMode {
        FIT_PAGE(0),
        FIT_WIDTH(1),
        FIT_HEIGHT(2),
        ZOOM(3),
        NOT_DEFINED(-1);


        /* JADX INFO: renamed from: b */
        private static SparseArray<PageViewMode> f1890b = new SparseArray<>(5);

        /* JADX INFO: renamed from: a */
        private final int f1892a;

        static {
            for (PageViewMode pageViewMode : values()) {
                f1890b.put(pageViewMode.f1892a, pageViewMode);
            }
        }

        PageViewMode(int i) {
            this.f1892a = i;
        }

        public final int getValue() {
            return this.f1892a;
        }

        public static PageViewMode valueOf(int i) {
            return f1890b.get(i);
        }
    }

    public enum PagePresentationMode {
        SINGLE(1),
        SINGLE_CONT(2),
        FACING(3),
        FACING_CONT(4),
        FACING_COVER(5),
        FACING_COVER_CONT(6),
        SINGLE_VERT(7),
        FACING_VERT(8),
        FACING_COVER_VERT(9);


        /* JADX INFO: renamed from: b */
        private static SparseArray<PagePresentationMode> f1887b = new SparseArray<>(9);

        /* JADX INFO: renamed from: a */
        private final int f1889a;

        static {
            for (PagePresentationMode pagePresentationMode : values()) {
                f1887b.put(pagePresentationMode.f1889a, pagePresentationMode);
            }
        }

        PagePresentationMode(int i) {
            this.f1889a = i;
        }

        public final int getValue() {
            return this.f1889a;
        }

        public static PagePresentationMode valueOf(int i) {
            return f1887b.get(i);
        }
    }

    public enum TextSearchResult {
        NOT_FOUND(0),
        FOUND(1),
        CANCELED(-1),
        INVALID_INPUT(2);


        /* JADX INFO: renamed from: a */
        private final int f1897a;

        TextSearchResult(int i) {
            this.f1897a = i;
        }

        public final int getValue() {
            return this.f1897a;
        }
    }

    public enum TextSelectionMode {
        STRUCTURAL(0),
        RECTANGULAR(1);


        /* JADX INFO: renamed from: a */
        private final int f1899a;

        TextSelectionMode(int i) {
            this.f1899a = i;
        }

        public final int getValue() {
            return this.f1899a;
        }
    }

    public enum OverPrintMode {
        OFF(0),
        ON(1),
        PDFX(2);


        /* JADX INFO: renamed from: a */
        private final int f1884a;

        OverPrintMode(int i) {
            this.f1884a = i;
        }

        public final int getValue() {
            return this.f1884a;
        }
    }

    public enum ZoomLimitMode {
        ABSOLUTE(1),
        RELATIVE(2),
        NONE(3);


        /* JADX INFO: renamed from: a */
        private final int f1901a;

        ZoomLimitMode(int i) {
            this.f1901a = i;
        }

        public final int getValue() {
            return this.f1901a;
        }
    }

    public enum PageChangeState {
        BEGIN(-1),
        ONGOING(0),
        END(1),
        SILENT(0);


        /* JADX INFO: renamed from: a */
        private final int f1886a;

        PageChangeState(int i) {
            this.f1886a = i;
        }

        public final int getValue() {
            return this.f1886a;
        }
    }

    public enum DownloadState {
        PAGE(0),
        THUMB(1),
        NAMED_DESTS(2),
        OUTLINE(3),
        FINISHED(4),
        FAILED(5),
        OPENED(6);


        /* JADX INFO: renamed from: b */
        private static SparseArray<DownloadState> f1877b = new SparseArray<>(7);

        /* JADX INFO: renamed from: a */
        private final int f1879a;

        static {
            for (DownloadState downloadState : values()) {
                f1877b.put(downloadState.f1879a, downloadState);
            }
        }

        DownloadState(int i) {
            this.f1879a = i;
        }

        public final int getValue() {
            return this.f1879a;
        }

        public static DownloadState valueOf(int i) {
            return f1877b.get(i);
        }
    }

    public enum ConversionState {
        FINISHED(0),
        PROGRESS(1),
        FAILED(2);


        /* JADX INFO: renamed from: a */
        private final int f1876a;

        ConversionState(int i) {
            this.f1876a = i;
        }

        public final int getValue() {
            return this.f1876a;
        }
    }

    public enum AnnotationManagerMode {
        ADMIN_UNDO_OTHERS(1),
        ADMIN_UNDO_OWN(2);


        /* JADX INFO: renamed from: b */
        private static final SparseArray<AnnotationManagerMode> f1872b = new SparseArray<>(2);

        /* JADX INFO: renamed from: a */
        private final int f1874a;

        static {
            for (AnnotationManagerMode annotationManagerMode : values()) {
                f1872b.put(annotationManagerMode.f1874a, annotationManagerMode);
            }
        }

        AnnotationManagerMode(int i) {
            this.f1874a = i;
        }

        public final int getValue() {
            return this.f1874a;
        }

        public static AnnotationManagerMode valueOf(int i) {
            return f1872b.get(i);
        }
    }

    public void refreshAndUpdate(ViewChangeCollection viewChangeCollection) throws PDFNetException {
        RefreshAndUpdate(this.f1823dc, viewChangeCollection.f2099a);
    }

    public static class HTTPRequestOptions {

        /* JADX INFO: renamed from: a */
        Obj f1880a;

        /* JADX INFO: renamed from: b */
        private ObjSet f1881b;

        public HTTPRequestOptions() {
            try {
                ObjSet objSet = new ObjSet();
                this.f1881b = objSet;
                this.f1880a = objSet.createDict();
            } catch (PDFNetException unused) {
                System.err.println("Error Occurred when creating HTTPRequestOptions.");
            }
        }

        public void addHeader(String str, String str2) throws PDFNetException {
            this.f1880a.putText(str, str2);
        }

        public void restrictDownloadUsage(boolean z) throws PDFNetException {
            this.f1880a.putBool("MINIMAL_DOWNLOAD", z);
        }

        public void skipByteRangeTest(boolean z) throws PDFNetException {
            this.f1880a.putBool("SKIP_BYTE_RANGE_TEST", z);
        }

        public void useRemoteFileSize(long j) throws PDFNetException {
            this.f1880a.putNumber("FORCE_REMOTE_SIZE", j);
        }
    }

    public class Selection {

        /* JADX INFO: renamed from: a */
        private long f1895a;

        /* synthetic */ Selection(PDFViewCtrl pDFViewCtrl, long j, Object obj, byte b) {
            this(pDFViewCtrl, j, obj);
        }

        public int getPageNum() {
            return PDFViewCtrl.SelectionGetPageNum(this.f1895a);
        }

        public double[] getQuads() {
            return PDFViewCtrl.SelectionGetQuads(this.f1895a);
        }

        public String getAsUnicode() {
            return PDFViewCtrl.SelectionGetAsUnicode(this.f1895a);
        }

        public String getAsHtml() {
            return PDFViewCtrl.SelectionGetAsHtml(this.f1895a);
        }

        private Selection(PDFViewCtrl pDFViewCtrl, long j, Object obj) {
            this.f1895a = j;
        }
    }

    public static class LinkInfo {
        private double mX1 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        private double mX2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        private double mY1 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        private double mY2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        private String mUrl = "";

        private LinkInfo() {
        }

        public String getURL() {
            return this.mUrl;
        }

        public Rect getRect() {
            try {
                return new Rect(this.mX1, this.mY1, this.mX2, this.mY2);
            } catch (PDFNetException unused) {
                return null;
            }
        }
    }

    public PDFViewCtrl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PDFViewCtrl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1849j = new ReentrantLock();
        this.f1850k = new ReentrantLock();
        this.f1644B = new PointF(0.0f, 0.0f);
        this.f1645C = new ReentrantLock();
        this.f1646D = 0;
        this.f1647E = 0;
        this.f1648F = 3;
        this.f1649G = 3;
        this.f1650H = 0;
        this.f1651I = new SparseArray<>();
        this.f1653L = new HashSet();
        this.f1665aA = 0;
        this.f1666aB = 0;
        this.f1667aC = 0;
        this.f1668aD = 0;
        this.f1669aE = 0;
        this.f1670aF = 0;
        this.f1671aG = 0;
        this.f1672aH = 0;
        this.f1673aI = 0;
        this.f1674aJ = 0;
        this.f1675aK = 0;
        this.f1676aL = 0;
        this.f1677aM = new RectF();
        this.f1678aN = new RectF();
        this.f1679aO = new SparseArray<>();
        this.f1680aP = new SparseArray<>();
        this.f1754bl = 1.0d;
        this.f1804cj = new ReentrantLock();
        this.f1806cl = true;
        this.f1807cm = false;
        this.f1808cn = 0;
        this.f1809co = 0;
        this.f1810cp = false;
        this.f1811cq = false;
        this.f1812cr = EnumC6951o.UNKNOWN;
        this.f1817cw = false;
        this.f1818cx = new SparseIntArray();
        this.f1819cy = new SparseIntArray();
        this.f1769cA = false;
        this.f1770cB = false;
        this.f1771cC = true;
        this.f1775cG = 0;
        this.f1777cI = new android.graphics.Rect();
        this.f1778cJ = new android.graphics.Rect();
        this.f1779cK = new android.graphics.Rect();
        this.f1780cL = new android.graphics.Rect();
        this.f1781cM = new android.graphics.Rect();
        this.f1782cN = new android.graphics.Rect();
        this.f1783cO = new android.graphics.Rect();
        this.f1784cP = new RectF();
        this.f1785cQ = new RectF();
        this.f1786cR = new RectF();
        this.f1787cS = 1.7014117E38f;
        this.f1788cT = -1.7014117E38f;
        this.f1789cU = 1.7014117E38f;
        this.f1790cV = -1.7014117E38f;
        this.f1791cW = new UniversalDocumentConversionListener() { // from class: com.pdftron.pdf.PDFViewCtrl.1
            @Override // com.pdftron.pdf.PDFViewCtrl.UniversalDocumentConversionListener
            public final void onConversionEvent(ConversionState conversionState, int i2) {
                int i3 = C69365.f1871b[conversionState.ordinal()];
                if (i3 == 2) {
                    if (PDFViewCtrl.this.mDocumentConversionFilter != null) {
                        PDFViewCtrl.this.mDocumentConversionFilter.close();
                        PDFViewCtrl.this.mDocumentConversionFilter = null;
                    }
                    PDFViewCtrl pDFViewCtrl = PDFViewCtrl.this;
                    pDFViewCtrl.removeUniversalDocumentConversionListener(pDFViewCtrl.f1791cW);
                    return;
                }
                if (i3 != 3) {
                    return;
                }
                if (PDFViewCtrl.this.mDocumentConversionFilter != null) {
                    PDFViewCtrl.this.mDocumentConversionFilter.close();
                    PDFViewCtrl.this.mDocumentConversionFilter = null;
                }
                PDFViewCtrl pDFViewCtrl2 = PDFViewCtrl.this;
                pDFViewCtrl2.removeUniversalDocumentConversionListener(pDFViewCtrl2.f1791cW);
            }
        };
        this.f1792cX = new AtomicInteger(0);
        this.f1793cY = new AtomicBoolean(false);
        this.f1794cZ = false;
        this.f1825de = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.pdftron.pdf.PDFViewCtrl.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (motionEvent2.getButtonState() == 2) {
                    return false;
                }
                InputDevice device = motionEvent != null ? InputDevice.getDevice(motionEvent.getDeviceId()) : null;
                if (device == null || (device.getSources() & 8194) == 0) {
                    PDFViewCtrl.this.f1657P = true;
                }
                return PDFViewCtrl.this.onScroll(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (motionEvent2.getButtonState() == 2) {
                    return false;
                }
                PDFViewCtrl.this.f1657P = false;
                PDFViewCtrl.m1318c(PDFViewCtrl.this, true);
                return PDFViewCtrl.this.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onDoubleTap(MotionEvent motionEvent) {
                if (motionEvent.getButtonState() == 2) {
                    return false;
                }
                if (PDFViewCtrl.this.f1800cf.f1933b) {
                    return true;
                }
                return PDFViewCtrl.this.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
                if (motionEvent.getButtonState() == 2) {
                    return false;
                }
                if (PDFViewCtrl.this.f1800cf.f1933b) {
                    return true;
                }
                return PDFViewCtrl.this.onDoubleTapEvent(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                if (motionEvent.getButtonState() == 2) {
                    return false;
                }
                return PDFViewCtrl.this.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
                if (motionEvent.getButtonState() == 2) {
                    return;
                }
                PDFViewCtrl.this.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
                if (motionEvent.getButtonState() == 2) {
                    return;
                }
                PDFViewCtrl.this.onShowPress(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                if (motionEvent.getButtonState() == 2 || PDFViewCtrl.this.f1800cf.f1933b) {
                    return true;
                }
                return PDFViewCtrl.this.onSingleTapUp(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (motionEvent.getButtonState() == 2) {
                    return false;
                }
                if (PDFViewCtrl.this.f1800cf.f1933b) {
                    return true;
                }
                if (PDFViewCtrl.this.f1692ab) {
                    PDFViewCtrl.this.f1692ab = false;
                    return false;
                }
                return PDFViewCtrl.this.onSingleTapConfirmed(motionEvent);
            }
        }, null, true);
        this.f1826df = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.pdftron.pdf.PDFViewCtrl.4
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                PDFViewCtrl.this.f1660S = false;
                return PDFViewCtrl.this.onScale(scaleGestureDetector);
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                PDFViewCtrl.m1337f(PDFViewCtrl.this, true);
                PDFViewCtrl.m1342g(PDFViewCtrl.this, true);
                PDFViewCtrl.m1347h(PDFViewCtrl.this, false);
                PDFViewCtrl.this.f1663V = true;
                return PDFViewCtrl.this.onScaleBegin(scaleGestureDetector);
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) throws Throwable {
                PDFViewCtrl.this.f1660S = true;
                PDFViewCtrl.this.f1663V = false;
                PDFViewCtrl.this.onScaleEnd(scaleGestureDetector);
            }
        });
        this.f1827dg = new HandlerC6945i(this);
        this.f1828dh = new HandlerC6949m(this);
        this.f1829di = new HandlerC6947k(this);
        this.f1830dj = new HandlerC6940d(this);
        this.f1831dk = new HandlerC6938b(this);
        this.f1832dl = new HandlerC6948l(this);
        this.f1833dm = new HandlerC6944h(this);
        this.f1834dn = new HandlerC6953q(this);
        this.f1835do = new HandlerC6952p(this);
        this.f1836dp = new HandlerC6956t(this);
        this.f1837dq = new HandlerC6943g(this);
        this.f1838dr = new HandlerC6941e(this);
        this.f1839ds = new HandlerC6942f(this);
        this.f1840dt = new HandlerC6955s(this);
        this.f1841du = new HandlerC6937a(this);
        this.f1842dv = new HandlerC6954r(this);
        this.f1734bR = false;
        this.f1858s = true;
        this.f1854o = false;
        this.f1857r = false;
        this.f1859t = false;
        this.f1860u = false;
        this.f1776cH = new SparseArray<>();
        this.f1654M = true;
        this.f1655N = 2000;
        this.f1656O = 750;
        this.f1657P = false;
        this.f1658Q = false;
        this.f1659R = false;
        this.f1660S = false;
        this.f1748bf = false;
        this.f1691aa = false;
        this.f1693ac = false;
        this.f1643A = false;
        this.f1861v = 0;
        this.f1717bA = null;
        this.f1766bx = 0;
        this.f1767by = false;
        this.f1768bz = false;
        this.f1722bF = null;
        this.f1723bG = 1;
        this.f1724bH = 1;
        this.f1725bI = PageChangeState.END;
        this.f1719bC = null;
        this.f1732bP = null;
        this.f1733bQ = null;
        this.f1727bK = false;
        this.f1728bL = null;
        this.f1749bg = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.f1750bh = 500000.0d;
        this.f1751bi = ZoomLimitMode.NONE;
        this.f1752bj = 1.0d;
        this.f1753bk = 1.0d;
        this.f1755bm = 1.0d;
        this.f1756bn = 1.0d;
        this.f1737bU = PageViewMode.FIT_PAGE;
        this.f1738bV = PageViewMode.NOT_DEFINED;
        this.f1739bW = PagePresentationMode.SINGLE;
        this.f1716az = new C6966e.a[2];
        this.f1652J = new ArrayList(10);
        this.f1863x = Color.argb(255, 255, 255, 255);
        this.f1864y = Color.argb(255, 255, 255, 255);
        Paint paint = new Paint();
        this.f1702al = paint;
        paint.setColor(this.f1863x);
        this.f1702al.setStyle(Paint.Style.FILL);
        this.f1702al.setAntiAlias(true);
        this.f1702al.setFilterBitmap(false);
        Paint paint2 = new Paint(this.f1702al);
        this.f1703am = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        this.f1740bX = true;
        this.f1742bZ = true;
        int i2 = DEFAULT_BG_COLOR;
        this.f1865z = i2;
        setBackgroundColor(i2);
        Paint paint3 = new Paint();
        this.f1704an = paint3;
        paint3.setColor(this.f1865z);
        this.f1704an.setStyle(Paint.Style.FILL);
        this.f1704an.setAntiAlias(true);
        this.f1704an.setFilterBitmap(false);
        if (f1639a) {
            Paint paint4 = new Paint();
            this.f1705ao = paint4;
            paint4.setColor(Color.argb(50, PsExtractor.VIDEO_STREAM_MASK, 177, 114));
            this.f1705ao.setStyle(Paint.Style.FILL);
            this.f1705ao.setAntiAlias(true);
            this.f1705ao.setFilterBitmap(false);
            Paint paint5 = new Paint();
            this.f1706ap = paint5;
            paint5.setColor(Color.argb(50, 255, 0, 0));
            this.f1706ap.setStyle(Paint.Style.STROKE);
            this.f1706ap.setAntiAlias(true);
            this.f1706ap.setFilterBitmap(false);
            Paint paint6 = new Paint(this.f1705ao);
            this.f1707aq = paint6;
            paint6.setColor(Color.argb(50, 10, PDFACompliance.e_PDFA1_8_6, PDFACompliance.e_PDFA1_8_1));
            Paint paint7 = new Paint(this.f1707aq);
            this.f1708ar = paint7;
            paint7.setColor(Color.argb(50, 255, 198, PDFACompliance.e_PDFA1_2_3));
            Paint paint8 = new Paint();
            this.f1709as = paint8;
            paint8.setColor(Color.argb(50, 255, 0, 0));
            this.f1709as.setStyle(Paint.Style.FILL);
            this.f1709as.setAntiAlias(true);
            this.f1709as.setFilterBitmap(false);
            Paint paint9 = new Paint();
            this.f1710at = paint9;
            paint9.setColor(Color.argb(50, 0, 0, 255));
            this.f1710at.setStyle(Paint.Style.FILL);
            this.f1710at.setAntiAlias(true);
            this.f1710at.setFilterBitmap(false);
            Paint paint10 = new Paint();
            this.f1711au = paint10;
            paint10.setColor(-16777216);
            this.f1711au.setStrokeJoin(Paint.Join.ROUND);
            this.f1711au.setStrokeCap(Paint.Cap.ROUND);
            this.f1711au.setStyle(Paint.Style.STROKE);
            this.f1711au.setTextAlign(Paint.Align.LEFT);
            this.f1711au.setTextSize(30.0f);
            Paint paint11 = new Paint();
            this.f1712av = paint11;
            paint11.setColor(Color.argb(100, 0, 255, 0));
            this.f1712av.setStyle(Paint.Style.FILL);
            this.f1712av.setAntiAlias(true);
            this.f1712av.setFilterBitmap(false);
            Paint paint12 = new Paint();
            this.f1713aw = paint12;
            paint12.setColor(Color.argb(100, 0, 255, 100));
            this.f1713aw.setStyle(Paint.Style.FILL);
            this.f1713aw.setAntiAlias(true);
            this.f1713aw.setFilterBitmap(false);
            Paint paint13 = new Paint();
            this.f1714ax = paint13;
            paint13.setColor(Color.argb(100, 100, 255, 0));
            this.f1714ax.setStyle(Paint.Style.FILL);
            this.f1714ax.setAntiAlias(true);
            this.f1714ax.setFilterBitmap(false);
            Paint paint14 = new Paint();
            this.f1715ay = paint14;
            paint14.setColor(Color.argb(100, 100, 255, 100));
            this.f1715ay.setStyle(Paint.Style.FILL);
            this.f1715ay.setAntiAlias(true);
            this.f1715ay.setFilterBitmap(false);
        }
        this.mDoc = null;
        this.f1851l = new C6966e();
        this.f1852m = new C6964c();
        this.f1845f = new OverScroller(context);
        this.f1846g = new OverScroller(context);
        this.f1847h = new OverScroller(context);
        this.f1697ag = new Matrix();
        this.f1696af = new Matrix();
        this.f1698ah = new android.graphics.Rect();
        this.f1699ai = new android.graphics.Rect();
        this.f1700aj = new RectF();
        this.f1701ak = new RectF();
        this.f1825de.setIsLongpressEnabled(false);
        this.f1795ca = true;
        this.f1692ab = false;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setVerticalScrollBarEnabled(true);
        setHorizontalScrollBarEnabled(true);
        setScrollBarStyle(50331648);
        setWillNotDraw(false);
        this.f1796cb = true;
        this.f1797cc = true;
        this.f1798cd = context.getResources().getInteger(R.integer.config_longAnimTime);
        this.f1799ce = 1000;
        this.f1800cf = new C6946j(this.f1798cd, this.f1799ce);
        this.f1681aQ = context.getResources().getInteger(R.integer.config_shortAnimTime);
        this.f1848i = new C6967f(this.f1681aQ);
        this.f1801cg = null;
        this.f1802ch = 0;
        this.f1803ci = 0;
        this.f1805ck = false;
        this.f1774cF = new C6957u(this);
        try {
            long[] jArrPDFViewCtrlCreate = PDFViewCtrlCreate(new RenderCallback());
            long j = jArrPDFViewCtrlCreate[0];
            this.f1823dc = j;
            this.f1824dd = jArrPDFViewCtrlCreate[1];
            this.f1822db = SetJavaScriptEventCallback(j, new C6962a(context), null);
            setImageSmoothing(false);
            setCaching(false);
            setOverprint(OverPrintMode.PDFX);
            setPageViewMode(this.f1737bU);
            setPageRefViewMode(this.f1737bU);
            PagePresentationMode pagePresentationMode = this.f1739bW;
            this.f1739bW = getPagePresentationMode();
            setPagePresentationMode(pagePresentationMode);
            setRenderedContentCacheSize((long) ((Runtime.getRuntime().maxMemory() / 1048576) * 0.25d));
            boolean z = f1642d;
            if (z && z && m1230a(true) == m1230a(true)) {
                f1638K = 3;
            }
            C6963b.a.f2110a.m1503a(64);
        } catch (Exception unused) {
        }
    }

    public boolean isValid() {
        return this.f1823dc != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        double d;
        double d2;
        int i5 = this.f1808cn;
        int i6 = this.f1809co;
        boolean z2 = this.f1810cp;
        this.f1808cn = 0;
        this.f1809co = 0;
        this.f1810cp = false;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        if (this.f1665aA == i7 && this.f1666aB == i8 && this.mDoc != null && !this.f1859t && !this.f1748bf) {
            if (this.f1727bK) {
                this.f1830dj.removeMessages(0);
                this.f1830dj.sendEmptyMessage(0);
                return;
            }
            return;
        }
        this.f1666aB = i8;
        this.f1665aA = i7;
        PDFDoc pDFDoc = this.mDoc;
        if (pDFDoc != null && i7 > 0 && i8 > 0) {
            this.f1748bf = false;
            try {
                OnSize(this.f1823dc, i7, i8, i7, false);
            } catch (Exception unused) {
            }
            if (this.f1859t) {
                this.f1859t = false;
                setPagePresentationMode(this.f1739bW);
                setPageViewMode(this.f1737bU);
                scrollTo(0, 0);
                double dM1357k = m1357k();
                this.f1752bj = dM1357k;
                this.f1753bk = m1225a(dM1357k);
                double dM1360l = m1360l();
                this.f1755bm = dM1360l;
                this.f1756bn = m1225a(dM1360l);
                int currentPage = getCurrentPage();
                this.f1724bH = currentPage;
                this.f1723bG = currentPage;
                ToolManager toolManager = this.f1736bT;
                if (toolManager != null) {
                    toolManager.onSetDoc();
                }
            }
            m1315c();
            if (i5 != 0 || i6 != 0) {
                OnScroll(this.f1823dc, i5, i6, false);
            }
            scrollTo(m1373q(), m1375r());
            requestRendering();
        } else if (pDFDoc == null) {
            this.f1667aC = 0;
            this.f1668aD = 0;
            this.f1669aE = 0;
            this.f1673aI = 0;
        }
        if (z && this.mDoc != null && this.f1751bi == ZoomLimitMode.RELATIVE) {
            double zoom = getZoom();
            double dM1357k2 = m1357k();
            this.f1752bj = dM1357k2;
            this.f1753bk = m1225a(dM1357k2);
            double dM1360l2 = m1360l();
            this.f1755bm = dM1360l2;
            double dM1225a = m1225a(dM1360l2);
            this.f1756bn = dM1225a;
            boolean z3 = this.f1817cw;
            if (z3) {
                d = this.f1749bg * this.f1755bm;
                d2 = this.f1750bh * dM1225a;
            } else {
                d = this.f1752bj * this.f1749bg;
                d2 = this.f1753bk * this.f1750bh;
            }
            double d3 = d2;
            if (zoom < d) {
                if (z3) {
                    if (this.f1820cz == PageViewMode.FIT_PAGE || this.f1820cz == PageViewMode.FIT_WIDTH || this.f1820cz == PageViewMode.FIT_HEIGHT) {
                        setPageViewMode(this.f1820cz, this.f1665aA / 2, this.f1666aB / 2, z2);
                        setPageViewMode(PageViewMode.ZOOM);
                    }
                } else {
                    PageViewMode pageRefViewMode = this.f1738bV;
                    if (pageRefViewMode != PageViewMode.FIT_PAGE && this.f1738bV != PageViewMode.FIT_WIDTH && this.f1738bV != PageViewMode.FIT_HEIGHT) {
                        pageRefViewMode = getPageRefViewMode();
                    }
                    setPageViewMode(pageRefViewMode, this.f1665aA / 2, this.f1666aB / 2, z2);
                }
            }
            if (zoom > d3) {
                setZoom(this.f1665aA / 2, this.f1666aB / 2, d3, z2, z2);
            }
            requestRendering();
        }
        if (this.f1666aB > 0 && this.f1665aA > 0 && this.mDoc != null) {
            this.f1830dj.removeMessages(0);
            this.f1830dj.sendEmptyMessage(0);
            ToolManager toolManager2 = this.f1736bT;
            if (toolManager2 != null && !this.f1734bR) {
                this.f1734bR = true;
                toolManager2.onControlReady();
            }
            this.f1774cF.m1464c();
        }
        ToolManager toolManager3 = this.f1736bT;
        if (toolManager3 != null) {
            toolManager3.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m1315c() {
        this.f1794cZ = false;
        this.f1818cx.clear();
        this.f1819cy.clear();
        this.f1667aC = GetTilingRegionWidth(this.f1823dc);
        this.f1668aD = GetTilingRegionHeight(this.f1823dc);
        this.f1851l.m1525b(getCurCanvasId());
        this.f1774cF.m1464c();
        if (!this.f1817cw || !m1335f()) {
            m1378s();
        }
        CopyOnWriteArrayList<OnCanvasSizeChangeListener> copyOnWriteArrayList = this.f1772cD;
        if (copyOnWriteArrayList != null) {
            Iterator<OnCanvasSizeChangeListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onCanvasSizeChanged();
            }
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        this.f1645C.lock();
        this.f1644B.x = motionEvent.getX();
        this.f1644B.y = motionEvent.getY();
        this.f1645C.unlock();
        ToolManager toolManager = this.f1736bT;
        if (toolManager == null || !toolManager.onGenericMotionEvent(motionEvent)) {
            return super.onGenericMotionEvent(motionEvent);
        }
        return true;
    }

    public PointF getCurrentMousePosition() {
        this.f1645C.lock();
        PointF pointF = new PointF(this.f1644B.x, this.f1644B.y);
        this.f1645C.unlock();
        return pointF;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ToolManager toolManager;
        ToolManager toolManager2;
        ToolManager toolManager3;
        super.onTouchEvent(motionEvent);
        if (this.mDoc == null || !this.f1795ca) {
            return true;
        }
        if (this.f1835do.hasMessages(0)) {
            this.f1835do.removeMessages(0);
            HandlerC6952p handlerC6952p = this.f1835do;
            handlerC6952p.dispatchMessage(handlerC6952p.obtainMessage(0));
        }
        if (this.f1836dp.hasMessages(0)) {
            this.f1836dp.removeMessages(0);
            HandlerC6956t handlerC6956t = this.f1836dp;
            handlerC6956t.dispatchMessage(handlerC6956t.obtainMessage(0));
        }
        if (motionEvent.getToolType(0) == 2 && !this.f1742bZ) {
            if (motionEvent.getAction() == 211) {
                ToolManager toolManager4 = this.f1736bT;
                if (toolManager4 != null) {
                    toolManager4.onDown(motionEvent);
                }
            } else if (motionEvent.getAction() == 213) {
                ToolManager toolManager5 = this.f1736bT;
                if (toolManager5 != null) {
                    toolManager5.onMove(motionEvent, motionEvent, -1.0f, -1.0f);
                }
            } else if (motionEvent.getAction() == 212 && (toolManager3 = this.f1736bT) != null) {
                toolManager3.onUp(motionEvent, PriorEventMode.OTHER);
            }
        }
        boolean zOnTouchEvent = this.f1825de.onTouchEvent(motionEvent);
        if (!zOnTouchEvent && motionEvent.getAction() == 2 && (toolManager2 = this.f1736bT) != null) {
            toolManager2.onMove(motionEvent, motionEvent, -1.0f, -1.0f);
        }
        if (motionEvent.getPointerCount() > 1 && (motionEvent.getAction() & 255) == 5 && (toolManager = this.f1736bT) != null) {
            toolManager.onPointerDown(motionEvent);
        }
        this.f1695ae = false;
        ToolManager toolManager6 = this.f1736bT;
        this.f1826df.setQuickScaleEnabled(this.f1741bY && (toolManager6 != null ? toolManager6.isCreatingAnnotation() ^ true : true));
        if (motionEvent.getAction() == 2 && this.f1761bs != null) {
            if (motionEvent.getY() < this.f1761bs.y) {
                this.f1763bu = true;
                if (f1639a) {
                    Log.d(f1641c, "scale: ABOVE");
                }
            } else {
                this.f1763bu = false;
                if (f1639a) {
                    Log.d(f1641c, "scale: BELOW");
                }
            }
        }
        this.f1826df.setStylusScaleEnabled(this.f1742bZ);
        boolean zOnTouchEvent2 = this.f1826df.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.f1833dm.removeMessages(1);
            this.f1694ad = MotionEvent.obtain(motionEvent);
            this.f1833dm.sendEmptyMessageAtTime(1, motionEvent.getDownTime() + 500);
        } else if (motionEvent.getAction() == 1 || zOnTouchEvent || this.f1695ae) {
            this.f1833dm.removeMessages(1);
        }
        boolean z = zOnTouchEvent | zOnTouchEvent2;
        if (motionEvent.getAction() == 1) {
            this.f1812cr = EnumC6951o.UNKNOWN;
            if (this.f1657P) {
                onUp(motionEvent, PriorEventMode.SCROLLING);
                this.f1657P = false;
                this.f1659R = false;
                return z;
            }
            if (this.f1659R && this.f1660S) {
                onUp(motionEvent, PriorEventMode.PINCH);
                this.f1659R = false;
                return z;
            }
            if (this.f1661T) {
                this.f1661T = false;
                onUp(motionEvent, PriorEventMode.DOUBLE_TAP);
                return z;
            }
            if (this.f1658Q) {
                onUp(motionEvent, PriorEventMode.FLING);
                return z;
            }
            onUp(motionEvent, PriorEventMode.OTHER);
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:306:0x06ae A[Catch: all -> 0x0715, Exception -> 0x0718, TryCatch #18 {Exception -> 0x0718, all -> 0x0715, blocks: (B:7:0x0011, B:23:0x004e, B:33:0x008a, B:40:0x00a1, B:53:0x00d2, B:77:0x0151, B:91:0x0182, B:105:0x01ae, B:108:0x01c1, B:110:0x01f0, B:112:0x022e, B:113:0x0270, B:115:0x0276, B:117:0x02a5, B:119:0x02bd, B:120:0x02cb, B:122:0x02d1, B:124:0x02fd, B:128:0x0307, B:130:0x030b, B:300:0x069e, B:302:0x06a2, B:304:0x06aa, B:306:0x06ae, B:308:0x06b6, B:312:0x06d3, B:309:0x06c3, B:313:0x06d6, B:293:0x068e, B:296:0x0696, B:297:0x069b), top: B:371:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x06d0  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x06d3 A[Catch: all -> 0x0715, Exception -> 0x0718, TryCatch #18 {Exception -> 0x0718, all -> 0x0715, blocks: (B:7:0x0011, B:23:0x004e, B:33:0x008a, B:40:0x00a1, B:53:0x00d2, B:77:0x0151, B:91:0x0182, B:105:0x01ae, B:108:0x01c1, B:110:0x01f0, B:112:0x022e, B:113:0x0270, B:115:0x0276, B:117:0x02a5, B:119:0x02bd, B:120:0x02cb, B:122:0x02d1, B:124:0x02fd, B:128:0x0307, B:130:0x030b, B:300:0x069e, B:302:0x06a2, B:304:0x06aa, B:306:0x06ae, B:308:0x06b6, B:312:0x06d3, B:309:0x06c3, B:313:0x06d6, B:293:0x068e, B:296:0x0696, B:297:0x069b), top: B:371:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x06df A[Catch: all -> 0x071b, Exception -> 0x071e, TryCatch #15 {Exception -> 0x071e, all -> 0x071b, blocks: (B:6:0x000c, B:314:0x06db, B:316:0x06df, B:318:0x06e5, B:320:0x06e9, B:322:0x06ed, B:324:0x0702, B:326:0x070b), top: B:375:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0726 A[Catch: all -> 0x0768, TryCatch #6 {all -> 0x0768, blocks: (B:340:0x0720, B:342:0x0726, B:344:0x072a, B:345:0x0748), top: B:359:0x0720 }] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0762  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x076c  */
    /* JADX WARN: Removed duplicated region for block: B:400:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:403:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) throws Throwable {
        boolean z;
        int i;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        PDFViewCtrl pDFViewCtrl;
        Canvas canvas2;
        Canvas canvas3;
        Canvas canvas4;
        boolean z3;
        boolean zOnDrawEdgeEffects;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        double d;
        int i12;
        double d2;
        double d3;
        double[] dArr;
        int i13;
        int i14;
        RectF rectF;
        int scrollOffsetForCanvasId;
        int scrollOffsetForCanvasId2;
        Canvas canvas5;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z4;
        int i20;
        int i21;
        double[] dArr2;
        int i22;
        PDFViewCtrl pDFViewCtrl2 = this;
        if (pDFViewCtrl2.mDoc == null) {
            return;
        }
        boolean z5 = true;
        try {
            pDFViewCtrl2.f1849j.lock();
            try {
                boolean zM1255a = m1255a(pDFViewCtrl2.f1739bW);
                int curCanvasId = pDFViewCtrl2.getCurCanvasId();
                int scrollX = pDFViewCtrl2.getScrollX();
                int scrollY = pDFViewCtrl2.getScrollY();
                try {
                    if (pDFViewCtrl2.m1369o()) {
                        if (zM1255a) {
                            if (pDFViewCtrl2.f1817cw) {
                                pDFViewCtrl2.f1675aK = pDFViewCtrl2.getScrollOffsetForCanvasId(curCanvasId);
                            }
                            scrollY -= pDFViewCtrl2.f1675aK;
                        } else {
                            if (pDFViewCtrl2.f1817cw) {
                                pDFViewCtrl2.f1671aG = pDFViewCtrl2.getScrollOffsetForCanvasId(curCanvasId);
                            }
                            scrollX -= pDFViewCtrl2.f1671aG;
                        }
                    }
                    int iM1536b = pDFViewCtrl2.f1848i.m1536b();
                    if (iM1536b == 2) {
                        pDFViewCtrl2.f1774cF.m1464c();
                        Iterator<Integer> it = pDFViewCtrl2.f1652J.iterator();
                        while (it.hasNext()) {
                            int iIntValue = it.next().intValue();
                            android.graphics.Rect rect = pDFViewCtrl2.f1651I.get(iIntValue, null);
                            if (rect != null) {
                                C6963b.a.f2110a.m1504a(rect);
                                pDFViewCtrl2.f1651I.remove(iIntValue);
                            }
                        }
                    }
                    if (!pDFViewCtrl2.m1335f() && !pDFViewCtrl2.f1857r && !pDFViewCtrl2.f1831dk.hasMessages(0)) {
                        pDFViewCtrl2.f1831dk.sendEmptyMessage(0);
                    }
                    C6966e.a aVarM1527c = pDFViewCtrl2.f1851l.m1527c(curCanvasId);
                    if (aVarM1527c == null && !pDFViewCtrl2.isContinuousPagePresentationMode(pDFViewCtrl2.f1739bW)) {
                        int curCanvasId2 = pDFViewCtrl2.getCurCanvasId();
                        if (pDFViewCtrl2.f1851l.m1527c(curCanvasId2) == null) {
                            pDFViewCtrl2.f1851l.m1525b(curCanvasId2);
                        }
                        aVarM1527c = pDFViewCtrl2.f1851l.m1527c(curCanvasId);
                    }
                    C6966e.a aVar = aVarM1527c;
                    if (aVar != null) {
                        pDFViewCtrl2.f1716az[0] = aVar;
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (pDFViewCtrl2.f1800cf.f1933b) {
                        int iM1379t = pDFViewCtrl2.f1800cf.f1957z;
                        if (pDFViewCtrl2.f1800cf.f1934c) {
                            if (zM1255a) {
                                iM1379t = pDFViewCtrl2.m1381u();
                            } else {
                                iM1379t = pDFViewCtrl2.m1379t();
                            }
                        }
                        boolean zM1254a = pDFViewCtrl2.m1254a(canvas, iM1379t, !pDFViewCtrl2.f1857r);
                        if (!pDFViewCtrl2.f1851l.m1521a()) {
                            pDFViewCtrl2.m1240a(canvas, iM1379t);
                        }
                        if (pDFViewCtrl2.f1800cf.m1403b(iM1379t, iM1379t)) {
                            int iM1414d = pDFViewCtrl2.f1800cf.m1414d(iM1379t);
                            zM1254a |= pDFViewCtrl2.m1254a(canvas, iM1414d, !pDFViewCtrl2.f1857r);
                            if (!pDFViewCtrl2.f1851l.m1521a()) {
                                pDFViewCtrl2.m1240a(canvas, iM1414d);
                            }
                        }
                        if (pDFViewCtrl2.f1800cf.m1410c(iM1379t, iM1379t)) {
                            int iM1419e = pDFViewCtrl2.f1800cf.m1419e(iM1379t);
                            zM1254a |= pDFViewCtrl2.m1254a(canvas, iM1419e, !pDFViewCtrl2.f1857r);
                            if (!pDFViewCtrl2.f1851l.m1521a()) {
                                pDFViewCtrl2.m1240a(canvas, iM1419e);
                            }
                        }
                        if (!zM1254a) {
                            C6957u.m1456a(pDFViewCtrl2.f1774cF, false);
                        }
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!pDFViewCtrl2.m1369o()) {
                        i2 = 0;
                        i3 = 0;
                    } else if (m1255a(pDFViewCtrl2.f1739bW)) {
                        if (pDFViewCtrl2.f1817cw) {
                            pDFViewCtrl2.f1675aK = pDFViewCtrl2.getScrollOffsetForCanvasId(curCanvasId);
                        }
                        i3 = pDFViewCtrl2.f1675aK;
                        i2 = 0;
                    } else {
                        if (pDFViewCtrl2.f1817cw) {
                            pDFViewCtrl2.f1671aG = pDFViewCtrl2.getScrollOffsetForCanvasId(curCanvasId);
                        }
                        i2 = pDFViewCtrl2.f1671aG;
                        i3 = 0;
                    }
                    if (pDFViewCtrl2.f1857r) {
                        int i23 = scrollX;
                        int i24 = scrollY;
                        pDFViewCtrl2.m1241a(canvas, i23, i24, i23, i24, false);
                        i4 = i23;
                        i5 = i24;
                        pDFViewCtrl2.f1651I.clear();
                    } else {
                        i4 = scrollX;
                        i5 = scrollY;
                    }
                    int i25 = iM1536b == 1 ? 0 : i;
                    int i26 = 0;
                    while (i26 < i25) {
                        try {
                            C6966e.a aVar2 = pDFViewCtrl2.f1716az[i26];
                            if (pDFViewCtrl2.f1851l.m1521a() || z2) {
                                canvas5 = canvas;
                                i15 = i4;
                                i16 = i5;
                                i17 = i25;
                                i18 = i26;
                                i19 = iM1536b;
                                z4 = true;
                            } else {
                                pDFViewCtrl2.f1777cI.set(i4, i5, pDFViewCtrl2.f1665aA + i4, pDFViewCtrl2.f1666aB + i5);
                                if (pDFViewCtrl2.f1857r) {
                                    i2 = -i4;
                                    i3 = -i5;
                                }
                                i19 = iM1536b;
                                canvas5 = canvas;
                                i15 = i4;
                                int i27 = i5;
                                int i28 = i3;
                                i17 = i25;
                                i18 = i26;
                                double[] dArrM1261a = pDFViewCtrl2.m1261a(pDFViewCtrl2.f1777cI.left, pDFViewCtrl2.f1777cI.top, pDFViewCtrl2.f1777cI.right, pDFViewCtrl2.f1777cI.bottom);
                                int length = dArrM1261a.length;
                                boolean z6 = false;
                                int i29 = 0;
                                while (i29 < length) {
                                    int i30 = (int) dArrM1261a[i29];
                                    double[] dArr3 = dArrM1261a;
                                    int i31 = length;
                                    boolean z7 = z6;
                                    int i32 = i29;
                                    pDFViewCtrl2.f1778cJ.set((int) (dArrM1261a[i29 + 1] + 0.5d), (int) (dArrM1261a[i29 + 2] + 0.5d), (int) (dArr3[i29 + 3] + 0.5d), (int) (dArr3[i29 + 4] + 0.5d));
                                    pDFViewCtrl2.f1779cK.set(pDFViewCtrl2.f1778cJ);
                                    if (pDFViewCtrl2.f1778cJ.intersect(pDFViewCtrl2.f1777cI)) {
                                        pDFViewCtrl2.f1780cL.set(pDFViewCtrl2.f1778cJ.left - pDFViewCtrl2.f1779cK.left, pDFViewCtrl2.f1778cJ.top - pDFViewCtrl2.f1779cK.top, pDFViewCtrl2.f1778cJ.right - pDFViewCtrl2.f1779cK.left, pDFViewCtrl2.f1778cJ.bottom - pDFViewCtrl2.f1779cK.top);
                                        int iWidth = pDFViewCtrl2.f1778cJ.width() * pDFViewCtrl2.f1778cJ.height();
                                        Iterator<C6965d> it2 = pDFViewCtrl2.f1851l.m1523b(i30, 0).iterator();
                                        int iWidth2 = 0;
                                        while (it2.hasNext()) {
                                            C6965d next = it2.next();
                                            Iterator<C6965d> it3 = it2;
                                            double[] dArr4 = dArr3;
                                            int i33 = i27;
                                            pDFViewCtrl2.f1781cM.set(next.f2116e, next.f2117f, next.f2116e + next.f2113b, next.f2117f + next.f2114c);
                                            if (pDFViewCtrl2.f1781cM.intersect(pDFViewCtrl2.f1780cL)) {
                                                iWidth2 += pDFViewCtrl2.f1781cM.width() * pDFViewCtrl2.f1781cM.height();
                                                pDFViewCtrl2.m1242a(canvas5, next, i2, i28);
                                            }
                                            it2 = it3;
                                            dArr3 = dArr4;
                                            i27 = i33;
                                        }
                                        dArr2 = dArr3;
                                        i22 = i27;
                                        Iterator<C6965d> it4 = pDFViewCtrl2.f1851l.m1530f(i30).iterator();
                                        while (it4.hasNext()) {
                                            C6965d next2 = it4.next();
                                            Iterator<C6965d> it5 = it4;
                                            pDFViewCtrl2.f1781cM.set(next2.f2116e, next2.f2117f, next2.f2116e + next2.f2113b, next2.f2117f + next2.f2114c);
                                            if (!pDFViewCtrl2.f1653L.contains(Long.valueOf(next2.f2112a))) {
                                                pDFViewCtrl2.m1242a(canvas5, next2, i2, i28);
                                            }
                                            it4 = it5;
                                        }
                                        if (iWidth > iWidth2) {
                                            z6 = true;
                                            i29 = i32 + 5;
                                            length = i31;
                                            dArrM1261a = dArr2;
                                            i27 = i22;
                                        } else if (pDFViewCtrl2.f1857r) {
                                            android.graphics.Rect rectM1502a = C6963b.a.f2110a.m1502a();
                                            rectM1502a.set(pDFViewCtrl2.f1779cK.left - pDFViewCtrl2.f1777cI.left, pDFViewCtrl2.f1779cK.top - pDFViewCtrl2.f1777cI.top, pDFViewCtrl2.f1779cK.right - pDFViewCtrl2.f1777cI.left, pDFViewCtrl2.f1779cK.bottom - pDFViewCtrl2.f1777cI.top);
                                            pDFViewCtrl2.f1651I.put(i30, rectM1502a);
                                        }
                                    } else {
                                        dArr2 = dArr3;
                                        i22 = i27;
                                    }
                                    z6 = z7;
                                    i29 = i32 + 5;
                                    length = i31;
                                    dArrM1261a = dArr2;
                                    i27 = i22;
                                }
                                z4 = z6;
                                i16 = i27;
                                i3 = i28;
                            }
                            if (pDFViewCtrl2.f1857r || !z4 || z2) {
                                i20 = i15;
                                i21 = i16;
                            } else {
                                i20 = i15;
                                i21 = i16;
                                pDFViewCtrl2.m1241a(canvas5, i20, i21, i15, i16, true);
                            }
                            i26 = i18 + 1;
                            i4 = i20;
                            i5 = i21;
                            i25 = i17;
                            aVar = aVar2;
                            iM1536b = i19;
                            pDFViewCtrl2 = this;
                        } catch (Exception e) {
                            e = e;
                            z = true;
                            pDFViewCtrl2 = this;
                        } catch (Throwable th) {
                            th = th;
                            z5 = true;
                            pDFViewCtrl2 = this;
                            if (z5) {
                            }
                            throw th;
                        }
                    }
                    int i34 = i5;
                    i6 = iM1536b;
                    int i35 = i4;
                    if (aVar == null) {
                        pDFViewCtrl2 = this;
                        canvas2 = canvas;
                        try {
                            pDFViewCtrl2.m1241a(canvas2, i35, i34, i35, i34, false);
                            pDFViewCtrl = pDFViewCtrl2;
                        } catch (Exception e2) {
                            e = e2;
                            z = true;
                            if (e.getMessage() != null) {
                            }
                            if (z) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            z5 = true;
                            if (z5) {
                            }
                            throw th;
                        }
                    } else {
                        pDFViewCtrl = this;
                        canvas2 = canvas;
                    }
                } catch (Exception e3) {
                    e = e3;
                    z = true;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e4) {
                e = e4;
            } catch (Throwable th4) {
                th = th4;
            }
            try {
            } catch (Exception e5) {
                e = e5;
                pDFViewCtrl2 = pDFViewCtrl;
                z = true;
                if (e.getMessage() != null) {
                }
                if (z) {
                }
            } catch (Throwable th5) {
                th = th5;
                pDFViewCtrl2 = pDFViewCtrl;
                z5 = true;
                if (z5) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            z = false;
        } catch (Throwable th6) {
            th = th6;
            z5 = false;
        }
        try {
            if (pDFViewCtrl.f1857r) {
                canvas3 = canvas2;
            } else if (i6 == 1) {
                pDFViewCtrl.f1850k.lock();
                try {
                    pDFViewCtrl.f1702al.setFilterBitmap(true);
                    SparseArray<RectF> sparseArrayM1537c = pDFViewCtrl.f1848i.m1537c();
                    int i36 = 0;
                    while (i36 < sparseArrayM1537c.size()) {
                        int iKeyAt = pDFViewCtrl.f1848i.m1537c().keyAt(i36);
                        pDFViewCtrl.f1785cQ.set(sparseArrayM1537c.get(iKeyAt));
                        Bitmap bitmapM1232a = pDFViewCtrl.m1232a(iKeyAt, pDFViewCtrl.f1784cP);
                        if (bitmapM1232a != null) {
                            canvas2.drawBitmap(bitmapM1232a, (android.graphics.Rect) null, pDFViewCtrl.f1785cQ, pDFViewCtrl.f1702al);
                            canvas4 = canvas2;
                        } else {
                            Canvas canvas6 = canvas2;
                            canvas6.drawRect(pDFViewCtrl.f1785cQ.left, pDFViewCtrl.f1785cQ.top, pDFViewCtrl.f1785cQ.right, pDFViewCtrl.f1785cQ.bottom, pDFViewCtrl.f1702al);
                            canvas4 = canvas6;
                        }
                        android.graphics.Rect rect2 = pDFViewCtrl.f1651I.get(iKeyAt);
                        if (rect2 != null) {
                            pDFViewCtrl.f1786cR.set(rect2);
                            pDFViewCtrl.f1697ag.setRectToRect(pDFViewCtrl.f1786cR, pDFViewCtrl.f1785cQ, Matrix.ScaleToFit.CENTER);
                            canvas4.save();
                            try {
                                canvas4.clipRect(pDFViewCtrl.f1785cQ.left, pDFViewCtrl.f1785cQ.top, pDFViewCtrl.f1785cQ.right, pDFViewCtrl.f1785cQ.bottom);
                                pDFViewCtrl.f1850k.lock();
                                try {
                                    Bitmap bitmap = pDFViewCtrl.f1853n;
                                    if (bitmap != null) {
                                        canvas4.drawBitmap(bitmap, pDFViewCtrl.f1697ag, pDFViewCtrl.f1702al);
                                    }
                                    pDFViewCtrl.f1850k.unlock();
                                    if (f1639a) {
                                        Paint paint = pDFViewCtrl.f1712av;
                                        if (iKeyAt % 4 == 1) {
                                            paint = pDFViewCtrl.f1713aw;
                                        }
                                        if (iKeyAt % 4 == 2) {
                                            paint = pDFViewCtrl.f1714ax;
                                        }
                                        if (iKeyAt % 4 == 3) {
                                            paint = pDFViewCtrl.f1715ay;
                                        }
                                        canvas4.drawRect(pDFViewCtrl.f1785cQ, paint);
                                    }
                                } catch (Throwable th7) {
                                    pDFViewCtrl.f1850k.unlock();
                                    throw th7;
                                }
                            } finally {
                                canvas4.restore();
                            }
                        }
                        i36++;
                        canvas2 = canvas4;
                    }
                    canvas3 = canvas2;
                    pDFViewCtrl.f1702al.setFilterBitmap(false);
                    pDFViewCtrl.m1345h();
                    pDFViewCtrl.f1850k.unlock();
                } finally {
                    pDFViewCtrl.f1850k.unlock();
                }
            } else {
                canvas3 = canvas2;
                if (pDFViewCtrl.f1860u) {
                    i7 = 0;
                    pDFViewCtrl.f1860u = false;
                    ToolManager toolManager = pDFViewCtrl.f1736bT;
                    if (toolManager != null) {
                        toolManager.onDoubleTapZoomAnimationEnd();
                    }
                } else {
                    i7 = 0;
                }
                pDFViewCtrl.f1850k.lock();
                try {
                    if (pDFViewCtrl.f1853n == null || pDFViewCtrl.f1651I.size() <= 0) {
                        pDFViewCtrl2 = pDFViewCtrl;
                        pDFViewCtrl2.f1850k.unlock();
                    } else {
                        int scrollX2 = pDFViewCtrl.getScrollX();
                        int scrollY2 = pDFViewCtrl.getScrollY();
                        RectF rectF2 = new RectF(scrollX2, scrollY2, pDFViewCtrl.f1665aA + scrollX2, pDFViewCtrl.f1666aB + scrollY2);
                        try {
                            if (pDFViewCtrl.m1369o()) {
                                if (m1255a(pDFViewCtrl.f1739bW)) {
                                    scrollOffsetForCanvasId2 = pDFViewCtrl.getScrollOffsetForCanvasId(pDFViewCtrl.f1861v);
                                    scrollOffsetForCanvasId = i7;
                                } else {
                                    scrollOffsetForCanvasId = pDFViewCtrl.getScrollOffsetForCanvasId(pDFViewCtrl.f1861v);
                                    scrollOffsetForCanvasId2 = i7;
                                }
                                if (RectF.intersects(new RectF(scrollOffsetForCanvasId, scrollOffsetForCanvasId2, pDFViewCtrl.f1667aC + scrollOffsetForCanvasId, pDFViewCtrl.f1668aD + scrollOffsetForCanvasId2), rectF2)) {
                                    i9 = scrollOffsetForCanvasId2;
                                    i8 = scrollOffsetForCanvasId;
                                }
                                pDFViewCtrl2 = pDFViewCtrl;
                                pDFViewCtrl2.f1850k.unlock();
                            } else {
                                i8 = i7;
                                i9 = i8;
                            }
                            double[] dArrM1261a2 = pDFViewCtrl2.m1261a(d, d2, d3, r2 + pDFViewCtrl.f1666aB);
                            if (dArrM1261a2 != null) {
                                int length2 = dArrM1261a2.length;
                                int i37 = 0;
                                boolean zIntersects = false;
                                while (i37 < length2) {
                                    int i38 = (int) dArrM1261a2[i37];
                                    if (pDFViewCtrl2.f1651I.get(i38) != null) {
                                        dArr = dArrM1261a2;
                                        pDFViewCtrl2.f1700aj.set(r7.left, r7.top, r7.right, r7.bottom);
                                        RectF rectF3 = pDFViewCtrl2.f1701ak;
                                        float f = i8;
                                        float f2 = i10;
                                        float f3 = (((float) dArr[i37 + 1]) + f) - f2;
                                        i13 = length2;
                                        i14 = i37;
                                        float f4 = (float) dArr[i37 + 2];
                                        float f5 = i9;
                                        float f6 = i12;
                                        boolean z8 = zIntersects;
                                        rectF3.set(f3, (f4 + f5) - f6, (((float) dArr[i14 + 3]) + f) - f2, (((float) dArr[i14 + 4]) + f5) - f6);
                                        pDFViewCtrl2.f1697ag.setRectToRect(pDFViewCtrl2.f1700aj, pDFViewCtrl2.f1701ak, Matrix.ScaleToFit.CENTER);
                                        canvas3.save();
                                        try {
                                            if (pDFViewCtrl2.m1369o() && !pDFViewCtrl2.f1701ak.intersect(new RectF(f, f5, pDFViewCtrl2.f1667aC + i8, pDFViewCtrl2.f1668aD + i9))) {
                                                Log.e("DRAW", "these should intersect");
                                            }
                                            canvas3.clipRect(pDFViewCtrl2.f1701ak.left, pDFViewCtrl2.f1701ak.top, pDFViewCtrl2.f1701ak.right, pDFViewCtrl2.f1701ak.bottom);
                                            pDFViewCtrl2.f1850k.lock();
                                            try {
                                                Bitmap bitmap2 = pDFViewCtrl2.f1853n;
                                                if (bitmap2 != null) {
                                                    canvas3.drawBitmap(bitmap2, pDFViewCtrl2.f1697ag, pDFViewCtrl2.f1702al);
                                                }
                                                pDFViewCtrl2.f1850k.unlock();
                                                if (f1639a) {
                                                    Paint paint2 = pDFViewCtrl2.f1712av;
                                                    if (i38 % 4 == 1) {
                                                        paint2 = pDFViewCtrl2.f1713aw;
                                                    }
                                                    if (i38 % 4 == 2) {
                                                        paint2 = pDFViewCtrl2.f1714ax;
                                                    }
                                                    if (i38 % 4 == 3) {
                                                        paint2 = pDFViewCtrl2.f1715ay;
                                                    }
                                                    canvas3.drawRect(pDFViewCtrl2.f1701ak, paint2);
                                                }
                                                zIntersects = z8 | RectF.intersects(rectF2, rectF);
                                            } catch (Throwable th8) {
                                                pDFViewCtrl2.f1850k.unlock();
                                                throw th8;
                                            }
                                        } finally {
                                            canvas3.restore();
                                            RectF.intersects(rectF2, pDFViewCtrl2.f1701ak);
                                        }
                                    } else {
                                        dArr = dArrM1261a2;
                                        i13 = length2;
                                        i14 = i37;
                                    }
                                    i37 = i14 + 5;
                                    dArrM1261a2 = dArr;
                                    length2 = i13;
                                }
                                if (!zIntersects) {
                                    pDFViewCtrl2.f1651I.clear();
                                }
                            }
                            pDFViewCtrl2.f1850k.unlock();
                        } catch (Throwable th9) {
                            th = th9;
                            throw th;
                        }
                        if (z2 && (pDFViewCtrl.f1817cw || pDFViewCtrl.f1800cf.f1918B || pDFViewCtrl.f1800cf.f1919C || pDFViewCtrl.f1800cf.f1920D)) {
                            int i39 = pDFViewCtrl.f1800cf.f1924H - (pDFViewCtrl.f1817cw ? i8 : i7);
                            i11 = pDFViewCtrl.f1800cf.f1925I - (pDFViewCtrl.f1817cw ? i9 : i7);
                            i10 = i39;
                        } else {
                            i10 = i7;
                            i11 = i10;
                        }
                        int i40 = scrollX2 - i8;
                        d = i40;
                        i12 = i11;
                        d2 = scrollY2 - i9;
                        d3 = i40 + pDFViewCtrl.f1665aA;
                        pDFViewCtrl2 = pDFViewCtrl;
                    }
                    if (pDFViewCtrl2.f1796cb && !pDFViewCtrl2.isContinuousPagePresentationMode(pDFViewCtrl2.f1739bW)) {
                        if (pDFViewCtrl2.f1736bT != null) {
                            zOnDrawEdgeEffects = false;
                        } else if (m1255a(pDFViewCtrl2.f1739bW)) {
                            zOnDrawEdgeEffects = pDFViewCtrl2.f1736bT.onDrawEdgeEffects(canvas4, pDFViewCtrl2.getScrollX(), pDFViewCtrl2.f1673aI);
                        } else {
                            zOnDrawEdgeEffects = pDFViewCtrl2.f1736bT.onDrawEdgeEffects(canvas4, pDFViewCtrl2.f1669aE, pDFViewCtrl2.getScrollY());
                        }
                        if (zOnDrawEdgeEffects) {
                            pDFViewCtrl2.m1345h();
                        }
                    }
                    pDFViewCtrl2.f1849j.unlock();
                    if (pDFViewCtrl2.f1736bT == null) {
                        if (!pDFViewCtrl2.m1335f() || pDFViewCtrl2.f1857r) {
                            if (pDFViewCtrl2.f1857r) {
                                canvas4.save();
                                canvas4.translate(-pDFViewCtrl2.getScrollX(), -pDFViewCtrl2.getScrollY());
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            pDFViewCtrl2.f1736bT.onDraw(canvas4, pDFViewCtrl2.f1696af);
                            if (z3) {
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } catch (Throwable th10) {
                    th = th10;
                    pDFViewCtrl2 = pDFViewCtrl;
                }
                if (e.getMessage() != null) {
                    if (f1640b) {
                        m1239a(4, "OnDraw Error: " + e.getMessage(), m1230a(true));
                    } else {
                        Log.e("PDFNet", "onDraw Error: " + e.getMessage());
                    }
                }
                if (z) {
                    return;
                }
                pDFViewCtrl2.f1849j.unlock();
                return;
            }
            if (e.getMessage() != null) {
            }
            if (z) {
            }
        } catch (Throwable th11) {
            th = th11;
            z5 = z;
            if (z5) {
                pDFViewCtrl2.f1849j.unlock();
            }
            throw th;
        }
        pDFViewCtrl2 = pDFViewCtrl;
        if (pDFViewCtrl2.f1796cb) {
            if (pDFViewCtrl2.f1736bT != null) {
            }
            if (zOnDrawEdgeEffects) {
            }
        }
        pDFViewCtrl2.f1849j.unlock();
        if (pDFViewCtrl2.f1736bT == null) {
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1242a(Canvas canvas, C6965d c6965d, int i, int i2) throws Throwable {
        Canvas canvas2 = canvas;
        int i3 = this.f1781cM.left - c6965d.f2116e;
        int i4 = this.f1781cM.top - c6965d.f2117f;
        this.f1698ah.set(i3, i4, this.f1781cM.width() + i3, this.f1781cM.height() + i4);
        int i5 = this.f1779cK.left + this.f1781cM.left + i;
        int i6 = this.f1779cK.top + this.f1781cM.top + i2;
        if (c6965d.f2122k == 1) {
            i5 += c6965d.f2118g;
            i6 += c6965d.f2119h;
        }
        this.f1699ai.set(i5, i6, this.f1781cM.width() + i5, this.f1781cM.height() + i6);
        Paint paint = this.f1702al;
        boolean z = false;
        if (c6965d.f2122k == 1) {
            if (c6965d.f2123l) {
                paint = this.f1703am;
            }
            Paint paint2 = paint;
            if (c6965d.f2115d == null) {
                double zoom = getZoom();
                int i7 = this.f1779cK.left + c6965d.f2116e + i;
                int i8 = this.f1779cK.top + c6965d.f2117f + i2;
                this.f1699ai.set(i7, i8, c6965d.f2113b + i7, c6965d.f2114c + i8);
                canvas2.save();
                try {
                    try {
                        canvas2.clipRect(this.f1699ai);
                        try {
                        } catch (Exception e) {
                            e = e;
                            canvas2 = canvas;
                        } catch (Throwable th) {
                            th = th;
                            canvas2 = canvas;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    c6965d.f2125n.draw(canvas, i7, i8, zoom, zoom, zoom, zoom);
                    canvas2 = canvas;
                } catch (Exception e3) {
                    e = e3;
                    canvas2 = canvas;
                    e.printStackTrace();
                } catch (Throwable th3) {
                    th = th3;
                    canvas2 = canvas;
                    canvas2.restore();
                    throw th;
                }
                canvas2.restore();
                z = true;
            }
            paint = paint2;
        }
        if (!z) {
            canvas2.drawBitmap(c6965d.f2115d, this.f1698ah, this.f1699ai, paint);
        }
        if (f1639a) {
            if (c6965d.f2122k == 0) {
                canvas2.drawText(String.valueOf(c6965d.f2112a) + "-t", this.f1699ai.left, this.f1699ai.bottom, this.f1711au);
                canvas2.drawRect(this.f1699ai, this.f1705ao);
                canvas2.drawLine(this.f1699ai.left, this.f1699ai.top, this.f1699ai.right, this.f1699ai.bottom, this.f1706ap);
                canvas2.drawRect(this.f1699ai, this.f1706ap);
                return;
            }
            if (c6965d.f2122k == 1) {
                Paint paint3 = this.f1707aq;
                if (z) {
                    paint3 = this.f1708ar;
                }
                canvas2.drawRect(this.f1699ai, paint3);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x0317 A[Catch: Exception -> 0x0367, TryCatch #0 {Exception -> 0x0367, blocks: (B:7:0x0016, B:9:0x001d, B:11:0x0028, B:16:0x003b, B:21:0x0067, B:23:0x0074, B:54:0x00fd, B:56:0x0104, B:58:0x010c, B:101:0x0277, B:110:0x0293, B:114:0x02a1, B:118:0x02af, B:122:0x02bc, B:126:0x02c9, B:128:0x02dc, B:129:0x02e9, B:106:0x0280, B:107:0x0283, B:130:0x02f5, B:132:0x02fd, B:134:0x0305, B:136:0x030d, B:139:0x0317, B:141:0x033a, B:143:0x0343, B:145:0x035c, B:144:0x0350, B:140:0x0329, B:18:0x0052, B:28:0x0083, B:38:0x00b8, B:40:0x00c5, B:30:0x009a, B:35:0x00a4, B:33:0x00a0, B:43:0x00cf, B:45:0x00d7, B:47:0x00df, B:50:0x00e9, B:5:0x000f), top: B:152:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0329 A[Catch: Exception -> 0x0367, TryCatch #0 {Exception -> 0x0367, blocks: (B:7:0x0016, B:9:0x001d, B:11:0x0028, B:16:0x003b, B:21:0x0067, B:23:0x0074, B:54:0x00fd, B:56:0x0104, B:58:0x010c, B:101:0x0277, B:110:0x0293, B:114:0x02a1, B:118:0x02af, B:122:0x02bc, B:126:0x02c9, B:128:0x02dc, B:129:0x02e9, B:106:0x0280, B:107:0x0283, B:130:0x02f5, B:132:0x02fd, B:134:0x0305, B:136:0x030d, B:139:0x0317, B:141:0x033a, B:143:0x0343, B:145:0x035c, B:144:0x0350, B:140:0x0329, B:18:0x0052, B:28:0x0083, B:38:0x00b8, B:40:0x00c5, B:30:0x009a, B:35:0x00a4, B:33:0x00a0, B:43:0x00cf, B:45:0x00d7, B:47:0x00df, B:50:0x00e9, B:5:0x000f), top: B:152:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0343 A[Catch: Exception -> 0x0367, TryCatch #0 {Exception -> 0x0367, blocks: (B:7:0x0016, B:9:0x001d, B:11:0x0028, B:16:0x003b, B:21:0x0067, B:23:0x0074, B:54:0x00fd, B:56:0x0104, B:58:0x010c, B:101:0x0277, B:110:0x0293, B:114:0x02a1, B:118:0x02af, B:122:0x02bc, B:126:0x02c9, B:128:0x02dc, B:129:0x02e9, B:106:0x0280, B:107:0x0283, B:130:0x02f5, B:132:0x02fd, B:134:0x0305, B:136:0x030d, B:139:0x0317, B:141:0x033a, B:143:0x0343, B:145:0x035c, B:144:0x0350, B:140:0x0329, B:18:0x0052, B:28:0x0083, B:38:0x00b8, B:40:0x00c5, B:30:0x009a, B:35:0x00a4, B:33:0x00a0, B:43:0x00cf, B:45:0x00d7, B:47:0x00df, B:50:0x00e9, B:5:0x000f), top: B:152:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0350 A[Catch: Exception -> 0x0367, TryCatch #0 {Exception -> 0x0367, blocks: (B:7:0x0016, B:9:0x001d, B:11:0x0028, B:16:0x003b, B:21:0x0067, B:23:0x0074, B:54:0x00fd, B:56:0x0104, B:58:0x010c, B:101:0x0277, B:110:0x0293, B:114:0x02a1, B:118:0x02af, B:122:0x02bc, B:126:0x02c9, B:128:0x02dc, B:129:0x02e9, B:106:0x0280, B:107:0x0283, B:130:0x02f5, B:132:0x02fd, B:134:0x0305, B:136:0x030d, B:139:0x0317, B:141:0x033a, B:143:0x0343, B:145:0x035c, B:144:0x0350, B:140:0x0329, B:18:0x0052, B:28:0x0083, B:38:0x00b8, B:40:0x00c5, B:30:0x009a, B:35:0x00a4, B:33:0x00a0, B:43:0x00cf, B:45:0x00d7, B:47:0x00df, B:50:0x00e9, B:5:0x000f), top: B:152:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fd A[Catch: Exception -> 0x0367, TryCatch #0 {Exception -> 0x0367, blocks: (B:7:0x0016, B:9:0x001d, B:11:0x0028, B:16:0x003b, B:21:0x0067, B:23:0x0074, B:54:0x00fd, B:56:0x0104, B:58:0x010c, B:101:0x0277, B:110:0x0293, B:114:0x02a1, B:118:0x02af, B:122:0x02bc, B:126:0x02c9, B:128:0x02dc, B:129:0x02e9, B:106:0x0280, B:107:0x0283, B:130:0x02f5, B:132:0x02fd, B:134:0x0305, B:136:0x030d, B:139:0x0317, B:141:0x033a, B:143:0x0343, B:145:0x035c, B:144:0x0350, B:140:0x0329, B:18:0x0052, B:28:0x0083, B:38:0x00b8, B:40:0x00c5, B:30:0x009a, B:35:0x00a4, B:33:0x00a0, B:43:0x00cf, B:45:0x00d7, B:47:0x00df, B:50:0x00e9, B:5:0x000f), top: B:152:0x000f }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean m1254a(Canvas canvas, int i, boolean z) throws Throwable {
        int scrollOffsetForCanvasId;
        int iMax;
        int iMax2;
        int i2;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        int i5;
        int i6;
        double[] dArr;
        int i7;
        Canvas canvas2;
        boolean z4;
        Bitmap bitmapM1232a;
        float f;
        int i8;
        int i9;
        int i10;
        boolean zM1255a = m1255a(this.f1739bW);
        if (zM1255a) {
            scrollOffsetForCanvasId = 0;
        } else {
            try {
                scrollOffsetForCanvasId = getScrollOffsetForCanvasId(i);
            } catch (Exception e) {
                Log.e("PDFNet", "drawThumbnailForCanvas error for canvas " + i + ": " + e.toString());
                return false;
            }
        }
        int scrollOffsetForCanvasId2 = zM1255a ? getScrollOffsetForCanvasId(i) : 0;
        double[] dArr2 = this.f1776cH.get(i);
        if (dArr2 == null) {
            return false;
        }
        int length = dArr2.length / 5;
        int i11 = this.f1800cf.f1957z;
        if (this.f1817cw) {
            if (zM1255a) {
                if (i == i11) {
                    iMax = this.f1800cf.f1924H;
                    iMax2 = (this.f1800cf.f1953v + this.f1800cf.f1925I) - scrollOffsetForCanvasId2;
                } else if (i < i11) {
                    iMax2 = (this.f1800cf.f1953v + this.f1800cf.f1925I) - scrollOffsetForCanvasId2;
                    iMax = 0;
                } else {
                    iMax = 0;
                    iMax2 = 0;
                }
                if (i < i11) {
                    iMax = Math.max(0, m1302b(dArr2) - this.f1665aA);
                }
                if (i != i11 && (i10 = this.f1818cx.get(i, Integer.MIN_VALUE)) != Integer.MIN_VALUE) {
                    iMax = i10;
                }
            } else {
                if (i != i11) {
                    if ((i >= i11 || this.f1805ck) && (i <= i11 || !this.f1805ck)) {
                        iMax = 0;
                        iMax2 = 0;
                    } else {
                        iMax = (this.f1800cf.f1953v + this.f1800cf.f1924H) - scrollOffsetForCanvasId;
                        iMax2 = 0;
                    }
                } else {
                    iMax = (this.f1800cf.f1953v + this.f1800cf.f1924H) - scrollOffsetForCanvasId;
                    iMax2 = this.f1800cf.f1925I;
                }
                if (i < i11) {
                    iMax2 = Math.max(0, m1231a(dArr2) - this.f1666aB);
                }
                if (i != i11 && (i9 = this.f1819cy.get(i, Integer.MIN_VALUE)) != Integer.MIN_VALUE) {
                    iMax2 = i9;
                }
            }
        } else {
            if ((!this.f1800cf.f1918B && !this.f1800cf.f1919C && !this.f1800cf.f1920D) || i != i11) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                boolean z5 = false;
                while (i4 < length) {
                    int i12 = i4 * 5;
                    int i13 = (int) dArr2[i12];
                    if (!z || (bitmapM1232a = m1232a(i13, this.f1784cP)) == null) {
                        z3 = zM1255a;
                        i5 = i4;
                        i6 = i13;
                        dArr = dArr2;
                        i7 = length;
                        canvas2 = canvas;
                        z4 = false;
                    } else {
                        float width = bitmapM1232a.getWidth();
                        float height = bitmapM1232a.getHeight();
                        float f2 = (float) dArr2[i12 + 1];
                        int i14 = scrollOffsetForCanvasId;
                        float f3 = (float) dArr2[i12 + 2];
                        int i15 = i4;
                        float f4 = (float) dArr2[i12 + 3];
                        float f5 = (float) dArr2[i12 + 4];
                        float f6 = f4 - f2;
                        float f7 = f5 - f3;
                        canvas.save();
                        z3 = zM1255a;
                        float f8 = i14;
                        float f9 = f2 + f8;
                        try {
                            boolean z6 = this.f1817cw;
                            float f10 = f9 - (z6 ? 0 : i2);
                            float f11 = scrollOffsetForCanvasId2;
                            float f12 = (f3 + f11) - (z6 ? 0 : i3);
                            float f13 = (f4 + f8) - (z6 ? 0 : i2);
                            float f14 = f5 + f11;
                            if (z6) {
                                f = f13;
                                i8 = 0;
                            } else {
                                f = f13;
                                i8 = i3;
                            }
                            i5 = i15;
                            i6 = i13;
                            scrollOffsetForCanvasId = i14;
                            canvas2 = canvas;
                            try {
                                canvas2.clipRect(f10, f12, f, f14 - i8, Region.Op.INTERSECT);
                                float f15 = (width - this.f1784cP.left) - this.f1784cP.right;
                                float f16 = (height - this.f1784cP.top) - this.f1784cP.bottom;
                                float f17 = f6 / f15;
                                float f18 = f2 - (this.f1784cP.left * f17);
                                float f19 = f4 + (this.f1784cP.right * f17);
                                float f20 = f7 / f16;
                                float f21 = f3 - (this.f1784cP.top * f20);
                                float f22 = f5 + (this.f1784cP.bottom * f20);
                                float f23 = f19 - f18;
                                float f24 = f22 - f21;
                                float fMax = Math.max(i2, f18);
                                float fMax2 = Math.max(i3, f21);
                                float fMin = Math.min(this.f1665aA + i2, f19);
                                float fMin2 = Math.min(this.f1666aB + i3, f22);
                                float f25 = ((fMax - f18) / f23) * width;
                                float f26 = height * ((fMax2 - f21) / f24);
                                float f27 = width * ((fMin - f18) / f23);
                                float f28 = height * ((fMin2 - f21) / f24);
                                float f29 = fMax + f8;
                                boolean z7 = this.f1817cw;
                                float f30 = f29 - (z7 ? 0 : i2);
                                float f31 = (fMax2 + f11) - (z7 ? 0 : i3);
                                float f32 = (fMin + f8) - (z7 ? 0 : i2);
                                dArr = dArr2;
                                i7 = length;
                                this.f1700aj.set(f25, f26, f27, f28);
                                this.f1701ak.set(f30, f31, f32, (fMin2 + f11) - (z7 ? 0 : i3));
                                if (this.f1697ag.setRectToRect(this.f1700aj, this.f1701ak, Matrix.ScaleToFit.CENTER)) {
                                    this.f1702al.setFilterBitmap(true);
                                    canvas2.drawBitmap(bitmapM1232a, this.f1697ag, this.f1702al);
                                    this.f1702al.setFilterBitmap(false);
                                    if (f1639a) {
                                        canvas2.drawRect(this.f1701ak, this.f1710at);
                                    }
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                canvas2.restore();
                            } catch (Throwable th) {
                                th = th;
                                canvas2.restore();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            canvas2 = canvas;
                        }
                    }
                    if (!z4) {
                        float f33 = scrollOffsetForCanvasId;
                        float f34 = ((float) dArr[i12 + 1]) + f33;
                        boolean z8 = this.f1817cw;
                        float f35 = f34 - (z8 ? 0 : i2);
                        float f36 = scrollOffsetForCanvasId2;
                        float f37 = (((float) dArr[i12 + 2]) + f36) - (z8 ? 0 : i3);
                        float f38 = (((float) dArr[i12 + 3]) + f33) - (z8 ? 0 : i2);
                        float f39 = (((float) dArr[i12 + 4]) + f36) - (z8 ? 0 : i3);
                        canvas2.drawRect(f35, f37, f38, f39, this.f1702al);
                        if (i6 == this.f1774cF.f1977b) {
                            C6957u.m1456a(this.f1774cF, true);
                            C6957u.m1454a(this.f1774cF, f35, f37, f38, f39);
                            z5 = true;
                        }
                    }
                    i4 = i5 + 1;
                    length = i7;
                    zM1255a = z3;
                    dArr2 = dArr;
                }
                z2 = zM1255a;
                if (!this.f1817cw && i == this.f1800cf.f1957z && this.f1800cf.f1918B && !this.f1800cf.f1934c) {
                    if (!z2) {
                        android.graphics.Rect rect = this.f1783cO;
                        int i16 = this.f1666aB;
                        rect.set(0, scrollOffsetForCanvasId2 + i16, this.f1665aA, (i16 << 1) + scrollOffsetForCanvasId2);
                    } else {
                        android.graphics.Rect rect2 = this.f1783cO;
                        int i17 = this.f1665aA;
                        rect2.set(scrollOffsetForCanvasId + i17, 0, (i17 << 1) + scrollOffsetForCanvasId, this.f1666aB);
                    }
                    canvas.drawRect(this.f1783cO, this.f1704an);
                    if (!z2) {
                        this.f1783cO.set(0, scrollOffsetForCanvasId2 - this.f1666aB, this.f1665aA, scrollOffsetForCanvasId2);
                    } else {
                        this.f1783cO.set(scrollOffsetForCanvasId - this.f1665aA, 0, scrollOffsetForCanvasId, this.f1666aB);
                    }
                    canvas.drawRect(this.f1783cO, this.f1704an);
                }
                return z5;
            }
            iMax = this.f1800cf.f1924H;
            iMax2 = this.f1800cf.f1925I;
        }
        i2 = iMax;
        i3 = iMax2;
        i4 = 0;
        boolean z52 = false;
        while (i4 < length) {
        }
        z2 = zM1255a;
        if (!this.f1817cw) {
            if (!z2) {
            }
            canvas.drawRect(this.f1783cO, this.f1704an);
            if (!z2) {
            }
            canvas.drawRect(this.f1783cO, this.f1704an);
        }
        return z52;
    }

    /* JADX INFO: renamed from: a */
    private void m1240a(Canvas canvas, int i) throws Throwable {
        int iMax;
        int i2;
        int iMax2;
        try {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            this.f1777cI.set(scrollX, scrollY, this.f1665aA + scrollX, this.f1666aB + scrollY);
            double[] dArr = this.f1776cH.get(i);
            if (dArr != null && dArr.length != 0) {
                int length = dArr.length;
                boolean zM1255a = m1255a(this.f1739bW);
                int scrollOffsetForCanvasId = zM1255a ? 0 : getScrollOffsetForCanvasId(i);
                int scrollY2 = getScrollY();
                int scrollOffsetForCanvasId2 = zM1255a ? getScrollOffsetForCanvasId(i) : 0;
                int scrollX2 = getScrollX();
                int i3 = this.f1800cf.f1957z;
                if (this.f1817cw) {
                    if (i == i3) {
                        if (zM1255a) {
                            iMax = this.f1800cf.f1924H;
                            i2 = 0;
                        } else {
                            iMax2 = this.f1800cf.f1925I;
                            i2 = iMax2;
                            iMax = 0;
                        }
                    } else if (i >= i3) {
                        iMax = 0;
                        i2 = 0;
                    } else if (zM1255a) {
                        iMax = Math.max(0, m1302b(dArr) - this.f1665aA);
                        i2 = 0;
                    } else {
                        iMax2 = Math.max(0, m1231a(dArr) - this.f1666aB);
                        i2 = iMax2;
                        iMax = 0;
                    }
                    if (i != i3) {
                        int i4 = this.f1818cx.get(i, Integer.MIN_VALUE);
                        int i5 = this.f1819cy.get(i, Integer.MIN_VALUE);
                        if (zM1255a) {
                            if (i4 != Integer.MIN_VALUE) {
                                iMax = i4;
                            }
                        } else if (i5 != Integer.MIN_VALUE) {
                            i2 = i5;
                        }
                    }
                } else if ((this.f1800cf.f1918B || this.f1800cf.f1919C || this.f1800cf.f1920D) && i == i3) {
                    iMax = this.f1800cf.f1924H;
                    i2 = this.f1800cf.f1925I;
                } else {
                    iMax = 0;
                    i2 = 0;
                }
                if (zM1255a) {
                    this.f1782cN.set(scrollX2, scrollOffsetForCanvasId2, this.f1665aA + scrollX2, this.f1666aB + scrollOffsetForCanvasId2);
                } else {
                    this.f1782cN.set(scrollOffsetForCanvasId, scrollY2, this.f1665aA + scrollOffsetForCanvasId, this.f1666aB + scrollY2);
                }
                int i6 = 0;
                while (i6 < length) {
                    int i7 = (int) dArr[i6];
                    int i8 = scrollOffsetForCanvasId;
                    int i9 = length;
                    boolean z = zM1255a;
                    int i10 = i6;
                    this.f1778cJ.set((((int) (dArr[i6 + 1] + 0.5d)) + this.f1782cN.left) - iMax, (((int) (dArr[i6 + 2] + 0.5d)) + this.f1782cN.top) - i2, (((int) dArr[i6 + 3]) + this.f1782cN.left) - iMax, (((int) dArr[i6 + 4]) + this.f1782cN.top) - i2);
                    this.f1779cK.set(this.f1778cJ);
                    if (this.f1778cJ.intersect(this.f1777cI)) {
                        this.f1780cL.set(this.f1778cJ.left - this.f1779cK.left, this.f1778cJ.top - this.f1779cK.top, this.f1778cJ.right - this.f1779cK.left, this.f1778cJ.bottom - this.f1779cK.top);
                        for (C6965d c6965d : this.f1851l.m1523b(i7, 0)) {
                            this.f1781cM.set(c6965d.f2116e, c6965d.f2117f, c6965d.f2116e + c6965d.f2113b, c6965d.f2117f + c6965d.f2114c);
                            if (this.f1781cM.intersect(this.f1780cL)) {
                                m1242a(canvas, c6965d, 0, 0);
                            }
                        }
                        for (C6965d c6965d2 : this.f1851l.m1523b(i7, 1)) {
                            this.f1781cM.set(c6965d2.f2116e, c6965d2.f2117f, c6965d2.f2116e + c6965d2.f2113b, c6965d2.f2117f + c6965d2.f2114c);
                            if (this.f1781cM.intersect(this.f1780cL) && !this.f1653L.contains(Long.valueOf(c6965d2.f2112a))) {
                                m1242a(canvas, c6965d2, 0, 0);
                            }
                        }
                    }
                    i6 = i10 + 5;
                    length = i9;
                    zM1255a = z;
                    scrollOffsetForCanvasId = i8;
                }
                boolean z2 = zM1255a;
                int i11 = scrollOffsetForCanvasId;
                if (this.f1817cw) {
                    return;
                }
                if (iMax > 0 || i2 > 0) {
                    if (z2) {
                        this.f1783cO.set(0, scrollOffsetForCanvasId2 - i2, this.f1665aA, scrollOffsetForCanvasId2);
                    } else {
                        this.f1783cO.set(i11 - iMax, 0, i11, this.f1666aB);
                    }
                    canvas.drawRect(this.f1783cO, this.f1704an);
                }
            }
        } catch (Exception e) {
            Log.e("PDFNet", "drawFullResTileForCanvas error for canvas " + i + ": " + e.toString());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1238a(int i) {
        this.f1680aP.clear();
        int scrollY = getScrollY() - i;
        int i2 = this.f1666aB;
        double[] dArrM1261a = m1261a(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, scrollY - (i2 * 5), this.f1667aC, scrollY + (i2 * 6));
        int length = dArrM1261a.length / 5;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 5;
            this.f1680aP.put((int) dArrM1261a[i4], new RectF((float) dArrM1261a[i4 + 1], (float) dArrM1261a[i4 + 2], (float) dArrM1261a[i4 + 3], (float) dArrM1261a[i4 + 4]));
        }
        for (int i5 = 0; i5 < this.f1679aO.size(); i5++) {
            RectF rectFValueAt = this.f1679aO.valueAt(i5);
            float scrollX = rectFValueAt.left + getScrollX();
            float scrollY2 = rectFValueAt.top + getScrollY();
            rectFValueAt.set(scrollX, scrollY2, rectFValueAt.width() + scrollX, rectFValueAt.height() + scrollY2);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m1322d() {
        float f;
        float zoom = (float) getZoom();
        float f2 = this.f1685aU * zoom;
        float f3 = this.f1686aV * zoom;
        float f4 = 0.0f;
        float[] fArr = {0.0f, 0.0f};
        float scrollX = getScrollX();
        float scrollY = getScrollY();
        if (m1369o()) {
            if (m1255a(this.f1739bW)) {
                if (this.f1817cw) {
                    this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
                }
                scrollY -= this.f1675aK;
            } else {
                if (this.f1817cw) {
                    this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
                }
                scrollX -= this.f1671aG;
            }
        }
        if (scrollX <= 0.0f || scrollY <= 0.0f) {
            double[] dArrConvCanvasPtToScreenPt = convCanvasPtToScreenPt(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            float f5 = (float) dArrConvCanvasPtToScreenPt[0];
            float f6 = (float) dArrConvCanvasPtToScreenPt[1];
            if (scrollX <= 0.0f && f5 > 0.0f) {
                fArr[0] = f5;
            }
            if (scrollY <= 0.0f && f6 > 0.0f) {
                fArr[1] = f6;
            }
        }
        float f7 = f2 + fArr[0];
        float f8 = f3 + fArr[1];
        float f9 = zoom / this.f1682aR;
        float f10 = this.f1683aS;
        float f11 = f7 - (f9 * f10);
        float f12 = this.f1684aT;
        float f13 = f8 - (f9 * f12);
        float f14 = ((this.f1665aA - f10) * f9) + f7;
        float f15 = f8 + ((this.f1666aB - f12) * f9);
        if (this.f1690aZ <= 1 || !isContinuousPagePresentationMode(this.f1739bW)) {
            f = 0.0f;
        } else {
            double[] dArrConvPagePtToCanvasPt = convPagePtToCanvasPt(this.f1687aW, this.f1688aX, this.f1689aY);
            f4 = (this.f1685aU - ((float) dArrConvPagePtToCanvasPt[0])) * zoom;
            f = (this.f1686aV - ((float) dArrConvPagePtToCanvasPt[1])) * zoom;
        }
        this.f1677aM.set(getScrollX(), getScrollY(), getScrollX() + this.f1665aA, getScrollY() + this.f1666aB);
        this.f1678aN.set(f11 - f4, f13 - f, f14 - f4, f15 - f);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        ToolManager toolManager = this.f1736bT;
        if (toolManager != null) {
            return toolManager.onKeyUp(i, keyEvent);
        }
        return false;
    }

    protected boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f1826df.isQuickScaleEnabled()) {
            this.f1761bs = new PointF(motionEvent.getX(), motionEvent.getY());
            return false;
        }
        boolean zHandleDoubleTap = handleDoubleTap(motionEvent);
        ToolManager toolManager = this.f1736bT;
        if (toolManager != null) {
            toolManager.onDoubleTapEnd(motionEvent);
        }
        return zHandleDoubleTap;
    }

    protected boolean handleDoubleTap(MotionEvent motionEvent) {
        this.f1661T = true;
        ToolManager toolManager = this.f1736bT;
        if (!(toolManager != null ? toolManager.onDoubleTap(motionEvent) : false) && this.mDoc != null) {
            cancelRendering();
            double zoom = getZoom();
            if (Math.abs(zoom - m1357k()) > 0.009999999776482582d) {
                m1245a(this.f1737bU, true);
            } else {
                m1249a(motionEvent.getX(), motionEvent.getY(), m1300b(zoom * 2.0d));
            }
        }
        return true;
    }

    protected boolean onDoubleTapEvent(MotionEvent motionEvent) {
        ToolManager toolManager = this.f1736bT;
        boolean zOnDoubleTapEvent = toolManager != null ? toolManager.onDoubleTapEvent(motionEvent) : false;
        if (!zOnDoubleTapEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f1662U = true;
            } else if (actionMasked == 1) {
                this.f1662U = false;
                boolean zIsQuickScaleEnabled = this.f1826df.isQuickScaleEnabled();
                if (!this.f1663V && zIsQuickScaleEnabled) {
                    boolean zHandleDoubleTap = handleDoubleTap(motionEvent);
                    ToolManager toolManager2 = this.f1736bT;
                    if (toolManager2 != null) {
                        toolManager2.onDoubleTapEnd(motionEvent);
                    }
                    return zHandleDoubleTap;
                }
            }
        }
        return zOnDoubleTapEvent;
    }

    protected boolean onDown(MotionEvent motionEvent) {
        this.f1813cs = EnumC6950n.UNKNOWN;
        this.f1816cv = 1.0f;
        this.f1815cu = 0.0f;
        this.f1814ct = 0.0f;
        this.f1693ac = false;
        if (!this.f1845f.isFinished()) {
            this.f1693ac = true;
            this.f1845f.forceFinished(true);
        }
        if (!this.f1800cf.f1933b && this.f1858s && this.mDoc != null) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (m1255a(this.f1739bW)) {
                if (this.f1817cw) {
                    this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
                }
                if (scrollY >= this.f1675aK && m1369o()) {
                    scrollY -= this.f1675aK;
                }
            } else {
                if (this.f1817cw) {
                    this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
                }
                if (scrollX >= this.f1671aG && m1369o()) {
                    scrollX -= this.f1671aG;
                }
            }
            int iM1373q = scrollX - m1373q();
            int iM1375r = scrollY - m1375r();
            if (iM1373q != 0 || iM1375r != 0) {
                scrollBy(iM1373q, iM1375r);
            }
        }
        this.f1760br = false;
        m1237a(motionEvent.getX(), motionEvent.getY());
        ToolManager toolManager = this.f1736bT;
        if (toolManager != null) {
            toolManager.onDown(motionEvent);
        }
        if (this.mDoc != null && !isContinuousPagePresentationMode(this.f1739bW)) {
            OverScroller overScrollerM1339g = m1339g();
            if (!overScrollerM1339g.isFinished()) {
                overScrollerM1339g.abortAnimation();
            }
            this.f1800cf.m1449a(motionEvent);
        }
        return true;
    }

    protected boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f1848i.m1536b() == 1) {
            return true;
        }
        this.f1800cf.f1929M = getScrollX();
        this.f1800cf.f1930N = getScrollY();
        if (this.f1800cf.f1933b && this.mDoc != null) {
            return this.f1800cf.m1450a(f, f2);
        }
        ToolManager toolManager = this.f1736bT;
        if ((toolManager != null && toolManager.onUp(motionEvent2, PriorEventMode.FLING)) || this.mDoc == null || (this.f1796cb && !isContinuousPagePresentationMode(this.f1739bW) && m1371p())) {
            return true;
        }
        int i = this.f1667aC - this.f1665aA;
        int i2 = this.f1668aD - this.f1666aB;
        if (Math.abs(f) < ((double) Math.abs(f2)) * 1.5d) {
            f = 0.0f;
        }
        float f3 = (float) (((double) f) * 0.75d);
        float f4 = (float) (((double) f2) * 0.75d);
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (m1255a(this.f1739bW)) {
            if (this.f1817cw) {
                this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
            }
            if (scrollY >= this.f1675aK && m1369o()) {
                scrollY -= this.f1675aK;
            }
        } else {
            if (this.f1817cw) {
                this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
            }
            if (scrollX >= this.f1671aG && m1369o()) {
                scrollX -= this.f1671aG;
            }
        }
        this.f1845f.fling(scrollX, scrollY, -((int) f3), -((int) f4), 0, i, 0, i2);
        if (this.f1858s) {
            try {
                OnScroll(this.f1823dc, this.f1845f.getFinalX() - this.f1845f.getStartX(), this.f1845f.getFinalY() - this.f1845f.getStartY(), false);
            } catch (Exception unused) {
            }
            requestRendering();
        }
        invalidate();
        return true;
    }

    public void forceFinishFling() {
        if (this.f1845f.isFinished()) {
            return;
        }
        this.f1845f.forceFinished(true);
    }

    protected void onFlingStop() throws Throwable {
        if (!this.f1800cf.f1933b) {
            this.f1774cF.m1463b();
        }
        ToolManager toolManager = this.f1736bT;
        if (toolManager != null) {
            toolManager.onFlingStop();
        }
        this.f1800cf.f1929M = 0;
        this.f1800cf.f1930N = 0;
        ArrayList<PageSlidingListener> arrayList = this.f1730bN;
        if (arrayList != null) {
            Iterator<PageSlidingListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onScrollOffsetChanged(this.f1800cf.f1924H, this.f1800cf.f1925I);
            }
        }
    }

    protected void onLongPress(MotionEvent motionEvent) {
        ToolManager toolManager;
        if (this.f1800cf.f1933b || !this.f1740bX || this.f1663V || this.f1662U || (toolManager = this.f1736bT) == null) {
            return;
        }
        toolManager.onLongPress(motionEvent);
    }

    /* JADX INFO: renamed from: e */
    private boolean m1328e() {
        return this.f1813cs == EnumC6950n.HORIZONTAL_SCROLL || this.f1813cs == EnumC6950n.VERTICAL_SCROLL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public boolean m1335f() {
        return this.f1854o && !m1328e();
    }

    protected boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) throws Throwable {
        ToolManager toolManager;
        this.f1760br = false;
        if (!this.f1806cl) {
            return false;
        }
        if (this.f1796cb && !isContinuousPagePresentationMode(this.f1739bW) && this.f1800cf.f1933b && this.mDoc != null) {
            if ((this.f1771cC && (toolManager = this.f1736bT) != null && toolManager.isCreatingAnnotation()) || Math.abs(this.f1800cf.f1953v) >= this.f1800cf.f1945n || this.f1800cf.f1934c) {
                return false;
            }
            m1305b(getPageNumberFromScreenPt(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
            this.f1800cf.f1935d = true;
        }
        this.f1774cF.m1465d();
        ToolManager toolManager2 = this.f1736bT;
        if (toolManager2 != null && toolManager2.onScaleBegin(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY())) {
            this.f1691aa = true;
            return true;
        }
        if (this.mDoc != null) {
            cancelRenderingAsync();
            this.f1855p = 1;
            this.f1856q = getPageCount();
            if (!isContinuousPagePresentationMode(this.f1739bW)) {
                double[] dArrGetPageRectsOnCanvas = GetPageRectsOnCanvas(this.f1823dc, GetCurCanvasId(this.f1823dc));
                if (dArrGetPageRectsOnCanvas.length > 0) {
                    this.f1855p = (int) dArrGetPageRectsOnCanvas[0];
                    this.f1856q = (int) dArrGetPageRectsOnCanvas[dArrGetPageRectsOnCanvas.length - 5];
                }
            }
            this.f1854o = true;
            m1304b(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            this.f1762bt = -1.0f;
            this.f1664W = false;
            this.f1746bd = -1.0f;
            this.f1747be = -1.0f;
            this.f1834dn.removeMessages(0);
            this.f1834dn.sendEmptyMessageDelayed(0, 1000L);
        }
        return true;
    }

    protected boolean onScale(ScaleGestureDetector scaleGestureDetector) throws Throwable {
        float f;
        double dM1300b;
        if (!this.f1806cl || this.f1848i.m1536b() == 1) {
            return true;
        }
        if (!this.f1800cf.f1935d && this.f1796cb && !isContinuousPagePresentationMode(this.f1739bW) && this.f1800cf.f1933b && this.mDoc != null) {
            if (Math.abs(this.f1800cf.f1953v) >= this.f1800cf.f1945n || this.f1800cf.f1934c) {
                return true;
            }
            m1305b(getPageNumberFromScreenPt(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
            this.f1800cf.f1935d = true;
        }
        if (!this.f1691aa && this.mDoc != null) {
            this.f1760br = true;
            this.f1744bb = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            this.f1745bc = focusY;
            if (this.f1746bd < 0.0f) {
                this.f1746bd = this.f1744bb;
            }
            if (this.f1747be < 0.0f) {
                this.f1747be = focusY;
            }
            float f2 = this.f1744bb;
            float f3 = (-f2) + this.f1746bd;
            float f4 = (-focusY) + this.f1747be;
            this.f1746bd = f2;
            this.f1747be = focusY;
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (this.f1762bt < 0.0f) {
                this.f1762bt = scaleFactor;
            }
            ToolManager toolManager = this.f1736bT;
            if (toolManager != null && toolManager.isCreatingAnnotation() && this.f1813cs == EnumC6950n.UNKNOWN) {
                float f5 = this.f1816cv * scaleFactor;
                this.f1816cv = f5;
                if (f5 > 2.0f || f5 < 0.5f || scaleFactor > 1.25f || scaleFactor < 0.8f) {
                    this.f1813cs = EnumC6950n.SCALE;
                } else if (scaleGestureDetector.getCurrentSpan() < ((double) scaleGestureDetector.getPreviousSpan()) * 1.1d && scaleGestureDetector.getCurrentSpan() > scaleGestureDetector.getPreviousSpan() * 0.9090909f) {
                    float f6 = (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0f) * 32.0f;
                    float f7 = this.f1815cu + f3;
                    this.f1815cu = f7;
                    this.f1814ct += f4;
                    if (Math.abs(f7) > f6 && Math.abs(this.f1815cu) > Math.abs(this.f1814ct)) {
                        this.f1813cs = EnumC6950n.HORIZONTAL_SCROLL;
                    } else if (Math.abs(this.f1814ct) > f6) {
                        this.f1813cs = EnumC6950n.VERTICAL_SCROLL;
                    }
                }
            }
            if (m1328e()) {
                if (this.f1813cs != EnumC6950n.HORIZONTAL_SCROLL) {
                    f3 = 0.0f;
                }
                scrollBy((int) f3, (int) (this.f1813cs == EnumC6950n.VERTICAL_SCROLL ? f4 : 0.0f));
                return true;
            }
            scrollBy((int) f3, (int) f4);
            if (this.f1662U) {
                if (this.f1763bu && this.f1764bv) {
                    f = this.f1762bt;
                    if (f1639a) {
                        Log.d(f1641c, "scale: HIT MIN AND ABOVE");
                    }
                } else {
                    f = scaleFactor;
                }
                if (!this.f1763bu && this.f1765bw) {
                    f = this.f1762bt;
                    if (f1639a) {
                        Log.d(f1641c, "scale: HIT MAX AND BELOW");
                    }
                }
                this.f1762bt = f;
            } else {
                f = scaleFactor;
            }
            if (this.f1662U) {
                this.f1664W = true;
                dM1300b = m1300b(this.f1743ba * f);
            } else {
                dM1300b = m1300b(this.f1743ba * scaleFactor);
            }
            double d = (float) dM1300b;
            if (Math.abs(d - getZoom()) >= 0.01d) {
                if (this.f1662U) {
                    setZoom(d);
                } else {
                    setZoom((int) (((double) this.f1744bb) + 0.5d), (int) (((double) this.f1745bc) + 0.5d), d);
                }
                this.f1834dn.removeMessages(0);
                this.f1834dn.sendEmptyMessageDelayed(0, 1000L);
                invalidate();
            }
        }
        ToolManager toolManager2 = this.f1736bT;
        return toolManager2 != null && toolManager2.onScale(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
    }

    protected void onScaleEnd(ScaleGestureDetector scaleGestureDetector) throws Throwable {
        double dM1300b;
        this.f1854o = false;
        if (m1328e()) {
            return;
        }
        m1315c();
        if (this.f1806cl) {
            if (!this.f1800cf.f1935d && this.f1796cb && !isContinuousPagePresentationMode(this.f1739bW) && this.f1800cf.f1933b && this.mDoc != null) {
                if (Math.abs(this.f1800cf.f1953v) >= this.f1800cf.f1945n || this.f1800cf.f1934c) {
                    return;
                }
                m1305b(getPageNumberFromScreenPt(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
                this.f1800cf.f1935d = true;
            }
            if (!this.f1691aa && this.mDoc != null) {
                this.f1744bb = scaleGestureDetector.getFocusX();
                this.f1745bc = scaleGestureDetector.getFocusY();
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (this.f1664W) {
                    dM1300b = m1300b(this.f1743ba * this.f1762bt);
                } else {
                    dM1300b = m1300b(this.f1743ba * scaleFactor);
                }
                float f = (float) dM1300b;
                this.f1834dn.removeMessages(0);
                if (this.f1664W) {
                    setZoom(f);
                } else {
                    setZoom((int) this.f1744bb, (int) this.f1745bc, f);
                }
            }
            this.f1800cf.f1935d = false;
            this.f1761bs = null;
            if (this.f1736bT != null && !m1328e()) {
                this.f1736bT.onScaleEnd(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                invalidate();
            }
            invalidate();
            this.f1774cF.m1464c();
        }
    }

    protected boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        ToolManager toolManager;
        if (!this.f1693ac && (toolManager = this.f1736bT) != null) {
            toolManager.onSingleTapConfirmed(motionEvent);
            this.f1835do.sendEmptyMessageDelayed(0, 200L);
        }
        return false;
    }

    protected boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        ToolManager toolManager;
        if (this.f1848i.m1536b() == 1 || this.f1800cf.f1935d) {
            return true;
        }
        ToolManager toolManager2 = this.f1736bT;
        float f3 = 0.0f;
        if (toolManager2 != null && toolManager2.isCreatingAnnotation() && motionEvent2.getPointerCount() == 2 && !this.f1854o) {
            if (this.f1813cs == EnumC6950n.UNKNOWN) {
                float f4 = (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0f) * 16.0f;
                this.f1815cu += f;
                this.f1814ct += f2;
                float x = motionEvent2.getX(0) - this.f1787cS;
                float x2 = motionEvent2.getX(1) - this.f1788cT;
                float y = motionEvent2.getY(0) - this.f1789cU;
                float y2 = motionEvent2.getY(1) - this.f1790cV;
                this.f1787cS = motionEvent2.getX(0);
                this.f1788cT = motionEvent2.getX(1);
                this.f1789cU = motionEvent2.getY(0);
                this.f1790cV = motionEvent2.getY(1);
                if ((x <= 0.0f && x2 >= 0.0f) || (x >= 0.0f && x2 <= 0.0f)) {
                    this.f1815cu = 0.0f;
                }
                if ((y <= 0.0f && y2 >= 0.0f) || (y >= 0.0f && y2 <= 0.0f)) {
                    this.f1814ct = 0.0f;
                }
                if (Math.abs(this.f1815cu) > f4 && Math.abs(this.f1815cu) > Math.abs(this.f1814ct)) {
                    this.f1813cs = EnumC6950n.HORIZONTAL_SCROLL;
                    f = this.f1815cu;
                } else if (Math.abs(this.f1814ct) > f4) {
                    this.f1813cs = EnumC6950n.VERTICAL_SCROLL;
                    f2 = this.f1814ct;
                }
            }
            if (!this.f1800cf.f1933b && m1328e()) {
                if (this.f1813cs != EnumC6950n.HORIZONTAL_SCROLL) {
                    f = 0.0f;
                }
                if (this.f1813cs != EnumC6950n.VERTICAL_SCROLL) {
                    f2 = 0.0f;
                }
                scrollBy((int) f, (int) f2);
            }
        }
        ToolManager toolManager3 = this.f1736bT;
        if ((toolManager3 == null || !toolManager3.onMove(motionEvent, motionEvent2, f, f2)) && this.mDoc != null) {
            if (this.f1796cb && !isContinuousPagePresentationMode(this.f1739bW)) {
                if (!this.f1800cf.f1933b) {
                    C6946j c6946j = this.f1800cf;
                    c6946j.f1924H = (c6946j.f1918B || this.f1817cw) ? getScrollX() : 0;
                    this.f1800cf.f1925I = getScrollY();
                    ArrayList<PageSlidingListener> arrayList = this.f1730bN;
                    if (arrayList != null) {
                        Iterator<PageSlidingListener> it = arrayList.iterator();
                        while (it.hasNext()) {
                            it.next().onScrollOffsetChanged(this.f1800cf.f1924H, this.f1800cf.f1925I);
                        }
                    }
                }
                this.f1800cf.m1451b(motionEvent2);
                if (m1371p()) {
                    return true;
                }
            }
            if (this.f1760br) {
                m1237a(motionEvent2.getX(), motionEvent2.getY());
                this.f1760br = false;
            }
            if (this.f1800cf.f1933b && (toolManager = this.f1736bT) != null && toolManager.isCreatingAnnotation() && motionEvent2.getPointerCount() == 2) {
                return true;
            }
            C6946j.m1405b(this.f1800cf, false);
            float x3 = motionEvent2.getX();
            float y3 = motionEvent2.getY();
            double[] dArrConvPagePtToScreenPt = convPagePtToScreenPt(this.f1758bp, this.f1759bq, this.f1757bo);
            float f5 = ((float) dArrConvPagePtToScreenPt[0]) - x3;
            float f6 = ((float) dArrConvPagePtToScreenPt[1]) - y3;
            if (this.f1811cq) {
                if (this.f1812cr == EnumC6951o.UNKNOWN) {
                    if (Math.abs(f2) > Math.abs(f) * 1.4f) {
                        this.f1812cr = EnumC6951o.VERTICAL;
                    } else if (Math.abs(f) > Math.abs(f2) * 1.4f) {
                        this.f1812cr = EnumC6951o.HORIZONTAL;
                    } else {
                        this.f1812cr = EnumC6951o.NONE;
                    }
                }
                int i = C69365.f1870a[this.f1812cr.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        f6 = 0.0f;
                    }
                    f3 = f5;
                }
                scrollBy((int) f3, (int) f6);
            } else {
                f3 = f5;
                scrollBy((int) f3, (int) f6);
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        ToolManager toolManager = this.f1736bT;
        if (toolManager != null) {
            toolManager.onScrollChanged(i, i2, i3, i4);
        }
    }

    protected void onShowPress(MotionEvent motionEvent) {
        ToolManager toolManager = this.f1736bT;
        if (toolManager != null) {
            toolManager.onShowPress(motionEvent);
        }
    }

    protected boolean onSingleTapUp(MotionEvent motionEvent) {
        ToolManager toolManager = this.f1736bT;
        if (toolManager == null) {
            return false;
        }
        toolManager.onSingleTapUp(motionEvent);
        return false;
    }

    protected boolean onUp(MotionEvent motionEvent, PriorEventMode priorEventMode) {
        boolean zOnUp;
        if (!this.f1800cf.f1933b || this.mDoc == null) {
            zOnUp = false;
        } else {
            zOnUp = this.f1800cf.m1450a(0.0f, 0.0f);
            priorEventMode = PriorEventMode.PAGE_SLIDING;
        }
        ToolManager toolManager = this.f1736bT;
        if (toolManager != null) {
            zOnUp = toolManager.onUp(motionEvent, priorEventMode);
        }
        if (zOnUp || priorEventMode != PriorEventMode.SCROLLING) {
            return true;
        }
        requestRendering();
        return true;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        if (this.f1817cw) {
            return this.f1673aI;
        }
        if (this.f1796cb && !isContinuousPagePresentationMode(this.f1739bW)) {
            if (m1255a(this.f1739bW)) {
                if (this.f1666aB == this.f1668aD || this.f1800cf.f1933b) {
                    return this.f1674aJ;
                }
            } else if (this.f1800cf.f1933b) {
                return this.f1666aB;
            }
        }
        return this.f1668aD;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.f1817cw) {
            return this.f1669aE;
        }
        if (this.f1796cb && !isContinuousPagePresentationMode(this.f1739bW) && (this.f1665aA == this.f1667aC || this.f1800cf.f1933b)) {
            return this.f1670aF;
        }
        return this.f1667aC;
    }

    @Override // android.view.View
    public void computeScroll() throws Throwable {
        int i;
        int i2;
        boolean z = true;
        if (this.f1846g.computeScrollOffset() || this.f1847h.computeScrollOffset()) {
            OverScroller overScrollerM1339g = m1339g();
            OverScroller overScroller = this.f1846g;
            if (overScrollerM1339g == overScroller) {
                this.f1800cf.f1951t = m1333f(overScroller.getCurrX() + (this.f1665aA / 2));
            } else {
                OverScroller overScroller2 = this.f1847h;
                if (overScrollerM1339g == overScroller2) {
                    this.f1800cf.f1951t = m1333f(overScroller2.getCurrY() + (this.f1666aB / 2));
                }
            }
            if (m1255a(this.f1739bW)) {
                if (this.f1668aD > this.f1666aB) {
                    if (this.f1800cf.f1955x) {
                        C6946j c6946j = this.f1800cf;
                        c6946j.f1951t = c6946j.m1393a(c6946j.f1951t);
                    } else {
                        C6946j c6946j2 = this.f1800cf;
                        c6946j2.f1951t = c6946j2.m1399b(c6946j2.f1951t);
                    }
                }
            } else if (this.f1667aC > this.f1665aA) {
                if (this.f1800cf.f1954w) {
                    C6946j c6946j3 = this.f1800cf;
                    c6946j3.f1951t = c6946j3.m1393a(c6946j3.f1951t);
                } else {
                    C6946j c6946j4 = this.f1800cf;
                    c6946j4.f1951t = c6946j4.m1399b(c6946j4.f1951t);
                }
            }
            C6946j c6946j5 = this.f1800cf;
            c6946j5.f1951t = Math.max(1, Math.min(c6946j5.f1951t, getPageCount()));
            if (this.f1800cf.f1934c && ((!this.f1800cf.f1923G || this.f1800cf.f1951t != this.f1800cf.f1957z) && this.f1800cf.f1917A)) {
                SetCurrentPage(this.f1823dc, this.f1800cf.f1951t);
                requestRendering();
            }
            super.scrollTo(overScrollerM1339g.getCurrX(), overScrollerM1339g.getCurrY());
            m1345h();
            return;
        }
        if (this.f1800cf.f1952u != -1) {
            m1305b(this.f1800cf.f1950s);
        }
        if (!this.f1858s) {
            if (this.f1845f.computeScrollOffset()) {
                int currX = this.f1845f.getCurrX() - getScrollX();
                int currY = this.f1845f.getCurrY() - getScrollY();
                if (currX != 0 || currY != 0) {
                    scrollBy(currX, currY);
                }
                z = false;
            }
        } else if (this.f1845f.computeScrollOffset()) {
            if (!m1369o()) {
                i = 0;
                i2 = 0;
            } else if (m1255a(this.f1739bW)) {
                if (this.f1817cw) {
                    this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
                }
                i2 = this.f1675aK;
                i = 0;
            } else {
                if (this.f1817cw) {
                    this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
                }
                i = this.f1671aG;
                i2 = 0;
            }
            ArrayList<PageSlidingListener> arrayList = this.f1730bN;
            if (arrayList != null) {
                Iterator<PageSlidingListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onScrollOffsetChanged(this.f1800cf.f1924H, this.f1800cf.f1925I);
                }
            }
            super.scrollTo(this.f1845f.getCurrX() + i, this.f1845f.getCurrY() + i2);
            m1345h();
            z = false;
        }
        if (this.f1658Q && z) {
            this.f1658Q = false;
            onFlingStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public OverScroller m1339g() {
        if (m1255a(this.f1739bW)) {
            return this.f1847h;
        }
        return this.f1846g;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1255a(PagePresentationMode pagePresentationMode) {
        return pagePresentationMode == PagePresentationMode.SINGLE_VERT || pagePresentationMode == PagePresentationMode.FACING_VERT || pagePresentationMode == PagePresentationMode.FACING_COVER_VERT;
    }

    /* JADX INFO: renamed from: b */
    private void m1305b(int i) throws Throwable {
        setCurrentPage(i);
        this.f1800cf.f1951t = i;
        C6946j.m1431j(this.f1800cf, -1);
        C6946j.m1440s(this.f1800cf);
        if (this.f1817cw) {
            if (m1255a(this.f1739bW)) {
                int i2 = this.f1668aD - this.f1666aB;
                int iMax = Math.max(0, m1302b(m1332e(this.f1800cf.f1950s)) - this.f1665aA);
                if (this.f1800cf.f1946o > this.f1800cf.f1950s) {
                    scrollTo(iMax, i2);
                } else if (this.f1800cf.f1946o < this.f1800cf.f1950s) {
                    scrollTo(0, 0);
                }
                int i3 = this.f1818cx.get(this.f1800cf.f1950s, Integer.MIN_VALUE);
                if (this.f1800cf.f1946o != this.f1800cf.f1950s) {
                    if (i3 != Integer.MIN_VALUE) {
                        scrollTo(i3, m1375r());
                        return;
                    }
                    return;
                } else {
                    if (this.f1800cf.f1936e) {
                        C6946j.m1412c(this.f1800cf, false);
                        if (i3 != Integer.MIN_VALUE) {
                            scrollTo(i3, this.f1800cf.f1927K - getScrollOffsetForCanvasId(this.f1800cf.f1946o));
                            return;
                        } else {
                            scrollTo(this.f1800cf.f1928L >= m1343h(this.f1800cf.f1946o) ? iMax : 0, this.f1800cf.f1927K - getScrollOffsetForCanvasId(this.f1800cf.f1946o));
                            return;
                        }
                    }
                    return;
                }
            }
            int i4 = this.f1667aC - this.f1665aA;
            int iMax2 = Math.max(0, m1231a(m1332e(this.f1800cf.f1950s)) - this.f1666aB);
            if (this.f1805ck) {
                if (this.f1800cf.f1946o > this.f1800cf.f1950s) {
                    scrollTo(0, iMax2);
                } else if (this.f1800cf.f1946o < this.f1800cf.f1950s) {
                    scrollTo(i4, 0);
                }
            } else if (this.f1800cf.f1946o > this.f1800cf.f1950s) {
                scrollTo(i4, iMax2);
            } else if (this.f1800cf.f1946o < this.f1800cf.f1950s) {
                scrollTo(0, 0);
            }
            int i5 = this.f1819cy.get(this.f1800cf.f1950s, Integer.MIN_VALUE);
            if (this.f1800cf.f1946o != this.f1800cf.f1950s) {
                if (i5 != Integer.MIN_VALUE) {
                    scrollTo(m1373q(), i5);
                }
            } else if (this.f1800cf.f1936e) {
                C6946j.m1412c(this.f1800cf, false);
                if (i5 != Integer.MIN_VALUE) {
                    scrollTo(this.f1800cf.f1926J - getScrollOffsetForCanvasId(this.f1800cf.f1946o), i5);
                } else {
                    scrollTo(this.f1800cf.f1926J - getScrollOffsetForCanvasId(this.f1800cf.f1946o), this.f1800cf.f1928L >= m1343h(this.f1800cf.f1946o) ? iMax2 : 0);
                }
            }
        }
    }

    public double getZoom() {
        return GetZoom(this.f1823dc);
    }

    public boolean setZoom(double d) {
        boolean zSetZoom = SetZoom(this.f1823dc, m1300b(d), false);
        m1315c();
        scrollTo(m1373q(), m1375r());
        return zSetZoom;
    }

    public boolean setZoom(double d, boolean z) {
        if (!z) {
            return setZoom(d);
        }
        return m1249a(this.f1665aA / 2.0f, this.f1666aB / 2.0f, d);
    }

    public boolean setZoom(int i, int i2, double d) {
        boolean zSetZoom = SetZoom(this.f1823dc, i, i2, m1300b(d), false);
        m1315c();
        scrollTo(m1373q(), m1375r());
        return zSetZoom;
    }

    public boolean setZoom(int i, int i2, double d, boolean z) {
        if (!z) {
            return setZoom(i, i2, d);
        }
        return m1249a(i, i2, d);
    }

    public boolean setZoom(int i, int i2, double d, boolean z, boolean z2) {
        if (!z2) {
            return setZoom(i, i2, d, z);
        }
        this.f1848i.m1534a(true);
        if (this.f1817cw) {
            if (m1255a(this.f1739bW)) {
                this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
            } else {
                this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
            }
        }
        m1323d(this.f1675aK);
        float f = i;
        float f2 = i2;
        m1316c(f, f2);
        m1304b(f, f2);
        boolean zoom = setZoom(i, i2, d, z);
        if (zoom) {
            m1367n();
            m1238a(this.f1675aK);
            m1322d();
            if (!isContinuousPagePresentationMode(this.f1739bW)) {
                this.f1678aN.left += this.f1671aG;
                this.f1678aN.right += this.f1671aG;
                this.f1678aN.top += this.f1675aK;
                this.f1678aN.bottom += this.f1675aK;
                for (int i3 = 0; i3 < this.f1680aP.size(); i3++) {
                    RectF rectFValueAt = this.f1680aP.valueAt(i3);
                    rectFValueAt.left += this.f1671aG;
                    rectFValueAt.right += this.f1671aG;
                    rectFValueAt.top += this.f1675aK;
                    rectFValueAt.bottom += this.f1675aK;
                }
            }
            ToolManager toolManager = this.f1736bT;
            if (toolManager != null) {
                toolManager.onDoubleTapZoomAnimationBegin();
            }
            this.f1848i.m1533a(this.f1677aM, this.f1678aN, this.f1679aO, this.f1680aP);
            this.f1860u = true;
        }
        return zoom;
    }

    public void setZoomLimits(ZoomLimitMode zoomLimitMode, double d, double d2) throws PDFNetException {
        this.f1751bi = zoomLimitMode;
        this.f1738bV = PageViewMode.NOT_DEFINED;
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d = 0.0d;
        }
        if (d > d2) {
            d2 = d;
        }
        if (this.f1751bi == ZoomLimitMode.RELATIVE) {
            if (d > 1.0d) {
                d = 1.0d;
            }
            if (d2 < 1.0d) {
                d2 = 1.0d;
            }
        }
        this.f1749bg = d;
        this.f1750bh = d2;
    }

    public void setMinimumRefZoomForMaximumZoomLimit(double d) {
        this.f1754bl = d;
        this.f1753bk = m1225a(this.f1752bj);
        this.f1756bn = m1225a(this.f1756bn);
    }

    public void setRelativeZoomLimits(PageViewMode pageViewMode, double d, double d2) throws PDFNetException {
        if (pageViewMode == PageViewMode.FIT_PAGE || pageViewMode == PageViewMode.FIT_WIDTH || pageViewMode == PageViewMode.FIT_HEIGHT) {
            this.f1738bV = pageViewMode;
            this.f1751bi = ZoomLimitMode.RELATIVE;
            if (d > 1.0d) {
                d = 1.0d;
            }
            if (d2 < 1.0d) {
                d2 = 1.0d;
            }
            this.f1749bg = d;
            this.f1750bh = d2;
            double dM1357k = m1357k();
            this.f1752bj = dM1357k;
            this.f1753bk = m1225a(dM1357k);
            double dM1360l = m1360l();
            this.f1755bm = dM1360l;
            this.f1756bn = m1225a(dM1360l);
            return;
        }
        Log.e("PDFNet", "ref_view_mode must be one of PageViewMode.FIT_PAGE, PageViewMode.FIT_WIDTH, or PageViewMode.FIT_HEIGHT");
    }

    public double getZoomForViewMode(PageViewMode pageViewMode) throws PDFNetException {
        if (pageViewMode == PageViewMode.FIT_PAGE || pageViewMode == PageViewMode.FIT_WIDTH || pageViewMode == PageViewMode.FIT_HEIGHT) {
            return GetRefZoom(this.f1823dc, pageViewMode.getValue());
        }
        throw new PDFNetException("", 0L, "PDFViewCtrl", "getZoomForViewMode", "viewMode must be one of PageViewMode.FIT_PAGE, PageViewMode.FIT_WIDTH, or PageViewMode.FIT_HEIGHT");
    }

    public boolean smartZoom(int i, int i2) {
        boolean zSmartZoom;
        cancelRendering();
        try {
            zSmartZoom = SmartZoom(this.f1823dc, i, i2);
            try {
                if (zSmartZoom) {
                    m1315c();
                    scrollTo(m1373q(), m1375r());
                    return zSmartZoom;
                }
                requestRendering();
                return zSmartZoom;
            } catch (Exception unused) {
                requestRendering();
                return zSmartZoom;
            }
        } catch (Exception unused2) {
            zSmartZoom = false;
        }
    }

    public boolean smartZoom(int i, int i2, boolean z) {
        if (!z) {
            return smartZoom(i, i2);
        }
        this.f1848i.m1534a(true);
        if (m1255a(this.f1739bW)) {
            if (this.f1817cw) {
                this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
            }
        } else if (this.f1817cw) {
            this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
        }
        m1323d(this.f1675aK);
        float f = i;
        float f2 = i2;
        m1316c(f, f2);
        m1304b(f, f2);
        this.f1652J.clear();
        boolean zSmartZoom = smartZoom(i, i2);
        if (zSmartZoom) {
            m1367n();
            m1238a(this.f1675aK);
            m1322d();
            if (!isContinuousPagePresentationMode(this.f1739bW)) {
                this.f1678aN.left += this.f1671aG;
                this.f1678aN.right += this.f1671aG;
                this.f1678aN.top += this.f1675aK;
                this.f1678aN.bottom += this.f1675aK;
                for (int i3 = 0; i3 < this.f1680aP.size(); i3++) {
                    RectF rectFValueAt = this.f1680aP.valueAt(i3);
                    rectFValueAt.left += this.f1671aG;
                    rectFValueAt.right += this.f1671aG;
                    rectFValueAt.top += this.f1675aK;
                    rectFValueAt.bottom += this.f1675aK;
                }
            }
            ToolManager toolManager = this.f1736bT;
            if (toolManager != null) {
                toolManager.onDoubleTapZoomAnimationBegin();
            }
            this.f1848i.m1533a(this.f1677aM, this.f1678aN, this.f1679aO, this.f1680aP);
            this.f1860u = true;
        }
        return zSmartZoom;
    }

    public void setLongPressEnabled(boolean z) {
        this.f1740bX = z;
    }

    public boolean getLongPressEnabled() {
        return this.f1740bX;
    }

    public void setQuickScaleEnabled(boolean z) {
        this.f1741bY = z;
    }

    public boolean getQuickScaleEnabled() {
        return this.f1741bY;
    }

    public boolean isStylusScaleEnabled() {
        return this.f1742bZ;
    }

    public void setStylusScaleEnabled(boolean z) {
        this.f1742bZ = z;
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        try {
            OnScroll(this.f1823dc, i, i2, false);
        } catch (Exception unused) {
        }
        if (this.f1817cw) {
            if (m1255a(this.f1739bW)) {
                this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
            } else {
                this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
            }
        }
        if (m1369o()) {
            super.scrollTo(m1373q() + this.f1671aG, m1375r() + this.f1675aK);
        } else {
            super.scrollTo(m1373q(), m1375r());
        }
        if (!this.f1845f.isFinished() || this.f1657P || m1335f()) {
            return;
        }
        requestRendering();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        try {
            OnScroll(this.f1823dc, i - m1373q(), i2 - m1375r(), false);
        } catch (Exception unused) {
        }
        if (this.f1817cw) {
            if (m1255a(this.f1739bW)) {
                this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
            } else {
                this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
            }
        }
        if (m1369o()) {
            super.scrollTo(m1373q() + this.f1671aG, m1375r() + this.f1675aK);
        } else {
            super.scrollTo(m1373q(), m1375r());
        }
        if (m1335f()) {
            return;
        }
        requestRendering();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        int iComputeHorizontalScrollOffset = computeHorizontalScrollOffset();
        if (iComputeHorizontalScrollOffset != 1) {
            return super.canScrollHorizontally(i);
        }
        int iComputeHorizontalScrollRange = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        if (iComputeHorizontalScrollRange == 0) {
            return false;
        }
        return i < 0 ? iComputeHorizontalScrollOffset > 1 : iComputeHorizontalScrollOffset < iComputeHorizontalScrollRange - 1;
    }

    /* JADX INFO: renamed from: h */
    private void m1345h() {
        postInvalidateOnAnimation();
    }

    public boolean getDirectionalLockEnabled() {
        return this.f1811cq;
    }

    public void setDirectionalLockEnabled(boolean z) {
        this.f1811cq = z;
    }

    public void setMaintainZoomEnabled(boolean z) throws PDFNetException {
        if (m1255a(this.f1739bW)) {
            Log.e(f1641c, "Non-continuous vertical mode is not available in maintain zoom mode, turning off maintain zoom mode...");
            z = false;
        }
        this.f1817cw = z;
        if (z) {
            SetPageRefViewMode(this.f1823dc, PageViewMode.ZOOM.getValue());
        } else {
            SetPageRefViewMode(this.f1823dc, this.f1737bU.getValue());
        }
    }

    public boolean isMaintainZoomEnabled() {
        return this.f1817cw;
    }

    public void setZoomingInAddingAnnotationEnabled(boolean z) {
        this.f1771cC = z;
    }

    public boolean isZoomingInAddingAnnotationEnabled() {
        return this.f1771cC;
    }

    public int getCurrentPage() {
        int i = 0;
        if (this.mDoc == null) {
            return 0;
        }
        if (!this.f1796cb || !this.f1800cf.f1933b) {
            if (!this.f1845f.isFinished() && this.f1858s && (isContinuousPagePresentationMode(this.f1739bW) || isFacingPagePresentationMode(this.f1739bW))) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                double d = scrollX;
                double d2 = scrollY;
                double[] dArrM1261a = m1261a(d, d2, this.f1665aA + scrollX, this.f1666aB + scrollY);
                if (dArrM1261a == null || dArrM1261a.length == 0) {
                    return GetCurrentPage(this.f1823dc);
                }
                int length = dArrM1261a.length / 5;
                int i2 = 0;
                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                while (i < length) {
                    int i3 = i * 5;
                    double d4 = dArrM1261a[i3 + 1];
                    double d5 = dArrM1261a[i3 + 2];
                    double d6 = dArrM1261a[i3 + 3];
                    double d7 = dArrM1261a[i3 + 4];
                    if (d4 < d) {
                        d4 = d;
                    }
                    if (d5 < d2) {
                        d5 = d2;
                    }
                    int i4 = this.f1665aA;
                    double d8 = d;
                    if (d6 > scrollX + i4) {
                        d6 = i4 + scrollX;
                    }
                    int i5 = this.f1666aB;
                    if (d7 > scrollY + i5) {
                        d7 = i5 + scrollY;
                    }
                    double d9 = (d6 - d4) * (d7 - d5);
                    if (d9 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        d9 = -d9;
                    }
                    if (d9 > d3) {
                        d3 = d9;
                        i2 = (int) dArrM1261a[i3];
                    }
                    i++;
                    d = d8;
                }
                return i2 > getPageCount() ? getPageCount() : i2;
            }
            return GetCurrentPage(this.f1823dc);
        }
        return this.f1800cf.f1951t;
    }

    public void setInteractionEnabled(boolean z) {
        this.f1795ca = z;
    }

    /* JADX INFO: renamed from: i */
    private void m1350i() {
        try {
            this.f1850k.lock();
            try {
                Bitmap bitmap = this.f1853n;
                if (bitmap == null || bitmap.getWidth() != this.f1665aA || this.f1853n.getHeight() != this.f1666aB) {
                    ImageCache imageCacheM1160a = ImageCache.m1160a();
                    imageCacheM1160a.m1162a(this.f1853n);
                    Bitmap bitmapM1161a = imageCacheM1160a.m1161a(this.f1665aA, this.f1666aB);
                    if (bitmapM1161a == null) {
                        bitmapM1161a = Bitmap.createBitmap(this.f1665aA, this.f1666aB, Bitmap.Config.ARGB_8888);
                    }
                    this.f1853n = bitmapM1161a;
                }
                if (!m1253a(this.f1853n)) {
                    Log.e("DRAW", "Error, couldn't take a snapshot");
                    this.f1829di.m1452a();
                } else {
                    this.f1862w = false;
                    this.f1861v = getCurCanvasId();
                    if (this.f1651I.size() == 0) {
                        Log.e("DRAW", "Error, we got a snapshot, but rects are empty");
                    }
                }
            } finally {
                this.f1850k.unlock();
            }
        } catch (Exception unused) {
        } catch (OutOfMemoryError unused2) {
            if (f1640b) {
                m1239a(4, "No snapshot due to out of memory", m1230a(true));
            } else {
                Log.e("PDFNet", "No snapshot due to out of memory");
            }
            this.f1829di.m1452a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.pdftron.pdf.PDFViewCtrl] */
    /* JADX INFO: renamed from: a */
    private boolean m1253a(Bitmap bitmap) {
        int[] iArr;
        int childCount = getChildCount();
        ?? r2 = 0;
        int i = 0;
        if (childCount > 0) {
            iArr = new int[childCount];
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                iArr[i2] = childAt.getVisibility();
                if (!(childAt instanceof VideoView)) {
                    childAt.setVisibility(4);
                }
            }
        } else {
            iArr = null;
        }
        Drawable background = getBackground();
        try {
            if (background != null) {
                try {
                    setBackground(null);
                } catch (Exception unused) {
                    this.f1857r = false;
                    if (background != null) {
                        setBackground(background);
                    }
                    if (childCount > 0) {
                        for (int i3 = 0; i3 < childCount; i3++) {
                            View childAt2 = getChildAt(i3);
                            if (!(childAt2 instanceof VideoView)) {
                                childAt2.setVisibility(iArr[i3]);
                            }
                        }
                    }
                    return false;
                } catch (OutOfMemoryError unused2) {
                    if (f1640b) {
                        m1239a(4, "Taking snapshot ran out of memory", m1230a(true));
                    } else {
                        Log.e("PDFNet", "Taking snapshot ran out of memory");
                    }
                    this.f1829di.m1452a();
                    this.f1857r = false;
                    if (background != null) {
                        setBackground(background);
                    }
                    if (childCount > 0) {
                        for (int i4 = 0; i4 < childCount; i4++) {
                            View childAt3 = getChildAt(i4);
                            if (!(childAt3 instanceof VideoView)) {
                                childAt3.setVisibility(iArr[i4]);
                            }
                        }
                    }
                    return false;
                }
            }
            Canvas canvas = new Canvas();
            canvas.setBitmap(bitmap);
            this.f1857r = true;
            draw(canvas);
            return true;
        } finally {
            this.f1857r = false;
            if (background != null) {
                setBackground(background);
            }
            if (childCount > 0) {
                while (r2 < childCount) {
                    View childAt4 = getChildAt(r2);
                    if (!(childAt4 instanceof VideoView)) {
                        childAt4.setVisibility(iArr[r2]);
                    }
                    r2++;
                }
            }
        }
    }

    public void setDebug(boolean z) {
        f1639a = z;
        f1640b = z;
        f1642d = z || z;
    }

    public void setBuiltInPageSlidingEnabled(boolean z) {
        this.f1797cc = z;
        this.f1796cb = z;
    }

    public void setBuiltInPageSlidingState(boolean z) {
        if (this.f1797cc) {
            this.f1796cb = z;
        }
    }

    public void setBuiltInPageSlidingThreshSpeed(int i) {
        this.f1799ce = i;
    }

    public void setBuiltInPageSlidingAnimationDuration(int i) {
        this.f1798cd = i;
    }

    public void setBuiltInZoomAnimationDuration(int i) {
        this.f1681aQ = i;
    }

    public boolean gotoFirstPage() {
        return m1250a(-2, 0, false);
    }

    public boolean gotoLastPage() {
        return m1250a(2, 0, false);
    }

    public boolean canGotoPreviousPage() {
        return m1251a(getCurrentPage(), false);
    }

    public boolean canGotoNextPage() {
        return m1251a(getCurrentPage(), true);
    }

    public boolean gotoPreviousPage() {
        return m1250a(-1, 0, false);
    }

    public void gotoPreviousPage(boolean z) {
        if (z && !isContinuousPagePresentationMode(this.f1739bW) && m1369o()) {
            int integer = getResources().getInteger(R.integer.config_shortAnimTime);
            C6946j c6946j = this.f1800cf;
            c6946j.m1395a(c6946j.m1414d(getCurCanvasId()), integer);
            return;
        }
        m1250a(-1, 0, z);
    }

    public boolean gotoNextPage() {
        return m1250a(1, 0, false);
    }

    public void gotoNextPage(boolean z) {
        if (z && !isContinuousPagePresentationMode(this.f1739bW) && m1369o()) {
            int integer = getResources().getInteger(R.integer.config_shortAnimTime);
            C6946j c6946j = this.f1800cf;
            c6946j.m1395a(c6946j.m1419e(getCurCanvasId()), integer);
            return;
        }
        m1250a(1, 0, z);
    }

    public boolean setCurrentPage(int i) {
        return m1250a(0, i, false);
    }

    public boolean showRect(int i, Rect rect) throws PDFNetException {
        setCurrentPage(i);
        boolean zShowRect = ShowRect(this.f1823dc, i, rect.f2037a);
        m1315c();
        scrollTo(m1373q(), m1375r());
        return zShowRect;
    }

    public Rect jumpToAnnotOnPage(Annot annot, int i) throws PDFNetException {
        Rect rect = new Rect(ShowAnnotOnPage(this.f1823dc, annot.__GetHandle(), i));
        m1315c();
        scrollTo(m1373q(), m1375r());
        return rect;
    }

    public Rect jumpToAnnotWithID(String str) {
        ExternalAnnotManager externalAnnotManager = this.f1844e;
        if (externalAnnotManager == null) {
            return null;
        }
        try {
            Rect rectJumpToAnnotWithID = externalAnnotManager.jumpToAnnotWithID(str);
            m1315c();
            scrollTo(m1373q(), m1375r());
            return rectJumpToAnnotWithID;
        } catch (Exception unused) {
            return null;
        }
    }

    public Matrix getPageSlidingCanvasTransform() {
        Matrix matrix = new Matrix();
        matrix.set(this.f1696af);
        return matrix;
    }

    public boolean isContinuousPagePresentationMode(PagePresentationMode pagePresentationMode) {
        return pagePresentationMode == PagePresentationMode.SINGLE_CONT || pagePresentationMode == PagePresentationMode.FACING_CONT || pagePresentationMode == PagePresentationMode.FACING_COVER_CONT;
    }

    public boolean isFacingPagePresentationMode(PagePresentationMode pagePresentationMode) {
        return pagePresentationMode == PagePresentationMode.FACING || pagePresentationMode == PagePresentationMode.FACING_CONT || pagePresentationMode == PagePresentationMode.FACING_COVER || pagePresentationMode == PagePresentationMode.FACING_COVER_CONT || pagePresentationMode == PagePresentationMode.FACING_VERT || pagePresentationMode == PagePresentationMode.FACING_COVER_VERT;
    }

    public PDFDoc openPDFUri(Uri uri, String str) throws PDFNetException, FileNotFoundException {
        return openPDFUri(uri, str, null, null);
    }

    public PDFDoc openPDFUri(Uri uri, String str, String str2, HTTPRequestOptions hTTPRequestOptions) throws Throwable {
        SecondaryFileFilter secondaryFileFilter = null;
        if (uri == null) {
            return null;
        }
        String string = uri.toString();
        if (FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme())) {
            try {
                SecondaryFileFilter secondaryFileFilter2 = new SecondaryFileFilter(getContext(), uri);
                try {
                    PDFDoc pDFDoc = new PDFDoc(secondaryFileFilter2);
                    m1243a(pDFDoc, str);
                    return pDFDoc;
                } catch (Throwable th) {
                    th = th;
                    secondaryFileFilter = secondaryFileFilter2;
                    if (secondaryFileFilter != null) {
                        secondaryFileFilter.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            if (URLUtil.isHttpUrl(string) || URLUtil.isHttpsUrl(string)) {
                openUrlAsync(string, str2, str, hTTPRequestOptions);
                return null;
            }
            PDFDoc pDFDoc2 = new PDFDoc(uri.getPath());
            m1243a(pDFDoc2, str);
            return pDFDoc2;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1243a(PDFDoc pDFDoc, String str) throws PDFNetException {
        if (str == null) {
            str = "";
        }
        if (!pDFDoc.initStdSecurityHandler(str)) {
            throw new PDFNetException("", 0L, "PDFViewCtrl", "openPDFUri", "Incorrect password");
        }
        if (pDFDoc.getPageCount() <= 0) {
            throw new PDFNetException("", 0L, "PDFViewCtrl", "openPDFUri", "Trying to open PDF with no pages.");
        }
        setDoc(pDFDoc);
    }

    public PDFDoc openPDFFilter(SecondaryFileFilter secondaryFileFilter, String str) throws PDFNetException {
        PDFDoc pDFDoc = new PDFDoc(secondaryFileFilter);
        m1243a(pDFDoc, str);
        return pDFDoc;
    }

    public DocumentConversion openNonPDFFilter(SecondaryFileFilter secondaryFileFilter, ConversionOptions conversionOptions) throws PDFNetException {
        this.mDocumentConversionFilter = secondaryFileFilter;
        DocumentConversion documentConversionUniversalConversion = Convert.universalConversion(secondaryFileFilter, conversionOptions);
        openUniversalDocument(documentConversionUniversalConversion);
        addUniversalDocumentConversionListener(this.f1791cW);
        return documentConversionUniversalConversion;
    }

    public DocumentConversion openNonPDFUri(Uri uri, ConversionOptions conversionOptions) throws PDFNetException, FileNotFoundException {
        DocumentConversion documentConversionUniversalConversion;
        if (FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme())) {
            SecondaryFileFilter secondaryFileFilter = new SecondaryFileFilter(getContext(), uri);
            this.mDocumentConversionFilter = secondaryFileFilter;
            documentConversionUniversalConversion = Convert.universalConversion(secondaryFileFilter, conversionOptions);
        } else {
            String path = uri.getPath();
            if (!new File(path).exists()) {
                return null;
            }
            documentConversionUniversalConversion = Convert.universalConversion(path, conversionOptions);
        }
        openUniversalDocument(documentConversionUniversalConversion);
        addUniversalDocumentConversionListener(this.f1791cW);
        return documentConversionUniversalConversion;
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$5 */
    static /* synthetic */ class C69365 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f1870a;

        /* JADX INFO: renamed from: b */
        static final /* synthetic */ int[] f1871b;

        static {
            int[] iArr = new int[ConversionState.values().length];
            f1871b = iArr;
            try {
                iArr[ConversionState.PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1871b[ConversionState.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1871b[ConversionState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[EnumC6951o.values().length];
            f1870a = iArr2;
            try {
                iArr2[EnumC6951o.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1870a[EnumC6951o.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public PDFDoc getDoc() {
        return this.mDoc;
    }

    public void setDoc(PDFDoc pDFDoc) throws PDFNetException {
        closeDoc();
        this.f1804cj.lock();
        try {
            if (pDFDoc != null) {
                try {
                    SecurityHandler securityHandler = pDFDoc.getSecurityHandler();
                    boolean z = false;
                    try {
                        if (securityHandler != null) {
                            if (securityHandler.getPermission(2)) {
                                m1244a(pDFDoc, false);
                            } else {
                                z = true;
                            }
                        } else {
                            boolean zInitSecurityHandler = pDFDoc.initSecurityHandler();
                            boolean z2 = !zInitSecurityHandler;
                            if (zInitSecurityHandler) {
                                m1244a(pDFDoc, false);
                            }
                            z = z2;
                        }
                        if (securityHandler != null) {
                            securityHandler.close();
                        }
                        if (z) {
                            if (this.f1735bS == null) {
                                this.f1735bS = new AlertDialogC6939c(getContext());
                            }
                            this.f1735bS.m1390a(pDFDoc);
                            this.f1735bS.show();
                        }
                    } finally {
                    }
                } catch (Exception e) {
                    throw new PDFNetException("", 0L, "PDFViewCtrl", "setDoc", e.getMessage());
                }
            }
            this.f1804cj.unlock();
        } catch (Throwable th) {
            this.f1804cj.unlock();
            throw th;
        }
    }

    public void openUniversalDocument(DocumentConversion documentConversion) throws PDFNetException {
        this.f1802ch = 0;
        this.f1803ci = 0;
        closeDoc();
        try {
            OpenUniversalDocumentNoDoc(this.f1823dc, documentConversion.__GetHandle());
            this.f1774cF.f1976a = documentConversion;
            this.f1721bE = true;
        } catch (Exception e) {
            CopyOnWriteArrayList<DocumentDownloadListener> copyOnWriteArrayList = this.f1719bC;
            if (copyOnWriteArrayList != null) {
                Iterator<DocumentDownloadListener> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    it.next().onDownloadEvent(DownloadState.FAILED, 0, 0, 0, e.getMessage());
                }
            }
        }
        requestLayout();
    }

    public void openUrlAsync(String str, String str2, String str3, HTTPRequestOptions hTTPRequestOptions) throws PDFNetException {
        long j__GetHandle;
        this.f1802ch = 0;
        this.f1803ci = 0;
        closeDoc();
        if (hTTPRequestOptions == null) {
            j__GetHandle = 0;
        } else {
            try {
                j__GetHandle = hTTPRequestOptions.f1880a.__GetHandle();
            } catch (Exception e) {
                CopyOnWriteArrayList<DocumentDownloadListener> copyOnWriteArrayList = this.f1719bC;
                if (copyOnWriteArrayList != null) {
                    Iterator<DocumentDownloadListener> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        it.next().onDownloadEvent(DownloadState.FAILED, 0, 0, 0, e.getMessage());
                    }
                    return;
                }
                return;
            }
        }
        OpenURL(this.f1823dc, str, str2 == null ? "" : str2, str3 == null ? "" : str3, j__GetHandle);
        this.f1721bE = true;
    }

    public void closeDoc() throws PDFNetException {
        this.f1804cj.lock();
        try {
            if (this.mDoc != null || this.f1774cF.f1976a != null) {
                m1355j();
                this.f1849j.lock();
                try {
                    this.f1851l.m1524b();
                    this.f1852m.m1512c();
                    this.f1849j.unlock();
                    CloseDoc(this.f1823dc);
                    this.f1775cG++;
                    this.f1774cF.m1460a();
                    this.mDoc = null;
                    m1355j();
                    if (this.mDoc != null) {
                        this.f1748bf = true;
                        requestLayout();
                    }
                } catch (Throwable th) {
                    this.f1849j.unlock();
                    throw th;
                }
            }
        } finally {
            this.f1804cj.unlock();
        }
    }

    public void docLockRead() throws PDFNetException {
        long j = this.f1823dc;
        if (j == 0) {
            throw new PDFNetException("", 0L, "PDFViewCtrl.java", "docLockRead", "PDFViewCtrl is destroyed");
        }
        DocLockRead(j);
    }

    public boolean docTryLockRead(int i) throws PDFNetException {
        long j = this.f1823dc;
        if (j == 0) {
            return false;
        }
        return DocTryLockRead(j, i);
    }

    public boolean docUnlockRead() {
        long j = this.f1823dc;
        if (j == 0) {
            return false;
        }
        try {
            DocUnlockRead(j);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void docLock(boolean z) throws PDFNetException {
        boolean z2;
        if (this.f1823dc == 0) {
            throw new PDFNetException("", 0L, "PDFViewCtrl.java", "docLock", "PDFViewCtrl is destroyed");
        }
        if (f1639a) {
            Log.d(f1641c, "==> docLock start | " + z + " | " + Thread.currentThread().getId());
        }
        this.f1792cX.incrementAndGet();
        if (this.f1793cY.get() || !z) {
            z2 = false;
        } else {
            z2 = true;
            this.f1793cY.set(true);
        }
        try {
            DocLock(this.f1823dc, z2);
            if (f1639a) {
                Log.d(f1641c, "===> docLock " + z2 + " | " + Thread.currentThread().getId());
            }
        } catch (Exception e) {
            this.f1792cX.decrementAndGet();
            if (e instanceof PDFNetException) {
                throw ((PDFNetException) e);
            }
        }
    }

    public boolean docTryLock(int i) throws PDFNetException {
        if (this.f1823dc == 0) {
            return false;
        }
        if (f1639a) {
            Log.d(f1641c, "==> docTryLock start | " + Thread.currentThread().getId());
        }
        this.f1792cX.incrementAndGet();
        boolean zDocTryLock = DocTryLock(this.f1823dc, i);
        if (!zDocTryLock) {
            this.f1792cX.decrementAndGet();
            return zDocTryLock;
        }
        if (f1639a) {
            Log.d(f1641c, "===> docTryLock | " + Thread.currentThread().getId());
        }
        return zDocTryLock;
    }

    public boolean docUnlock() {
        if (this.f1823dc == 0) {
            return false;
        }
        if (f1639a) {
            Log.d(f1641c, "<== docUnlock start | " + Thread.currentThread().getId());
        }
        try {
            DocUnlock(this.f1823dc);
            boolean z = this.f1793cY.get();
            int iDecrementAndGet = this.f1792cX.decrementAndGet();
            if (f1639a) {
                Log.d(f1641c, "<=== docUnlock DONE remove locked thread: " + Thread.currentThread().getId() + " | " + iDecrementAndGet);
            }
            if (!z || iDecrementAndGet != 0) {
                return true;
            }
            requestRendering();
            this.f1793cY.set(false);
            if (!f1639a) {
                return true;
            }
            Log.d(f1641c, "<=== docUnlock requestRendering after releasing all locks: " + Thread.currentThread().getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setToolManager(ToolManager toolManager) {
        this.f1736bT = toolManager;
    }

    public ToolManager getToolManager() {
        return this.f1736bT;
    }

    public void addDocumentDownloadListener(DocumentDownloadListener documentDownloadListener) {
        if (this.f1719bC == null) {
            this.f1719bC = new CopyOnWriteArrayList<>();
        }
        if (this.f1719bC.contains(documentDownloadListener)) {
            return;
        }
        this.f1719bC.add(documentDownloadListener);
    }

    public void removeDocumentDownloadListener(DocumentDownloadListener documentDownloadListener) {
        CopyOnWriteArrayList<DocumentDownloadListener> copyOnWriteArrayList = this.f1719bC;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(documentDownloadListener);
        }
    }

    public void addOnCanvasSizeChangeListener(OnCanvasSizeChangeListener onCanvasSizeChangeListener) {
        if (this.f1772cD == null) {
            this.f1772cD = new CopyOnWriteArrayList<>();
        }
        if (this.f1772cD.contains(onCanvasSizeChangeListener)) {
            return;
        }
        this.f1772cD.add(onCanvasSizeChangeListener);
    }

    public void removeOnCanvasSizeChangeListener(OnCanvasSizeChangeListener onCanvasSizeChangeListener) {
        CopyOnWriteArrayList<OnCanvasSizeChangeListener> copyOnWriteArrayList = this.f1772cD;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(onCanvasSizeChangeListener);
        }
    }

    public void addOnPageLayoutChangeListener(OnPageLayoutChangeListener onPageLayoutChangeListener) {
        if (this.f1773cE == null) {
            this.f1773cE = new CopyOnWriteArrayList<>();
        }
        if (this.f1773cE.contains(onPageLayoutChangeListener)) {
            return;
        }
        this.f1773cE.add(onPageLayoutChangeListener);
    }

    public void removeOnPageLayoutChangeListener(OnPageLayoutChangeListener onPageLayoutChangeListener) {
        CopyOnWriteArrayList<OnPageLayoutChangeListener> copyOnWriteArrayList = this.f1773cE;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(onPageLayoutChangeListener);
        }
    }

    public void addUniversalDocumentConversionListener(UniversalDocumentConversionListener universalDocumentConversionListener) {
        if (this.f1720bD == null) {
            this.f1720bD = new CopyOnWriteArrayList<>();
        }
        if (this.f1720bD.contains(universalDocumentConversionListener)) {
            return;
        }
        this.f1720bD.add(universalDocumentConversionListener);
    }

    public void removeUniversalDocumentConversionListener(UniversalDocumentConversionListener universalDocumentConversionListener) {
        CopyOnWriteArrayList<UniversalDocumentConversionListener> copyOnWriteArrayList = this.f1720bD;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(universalDocumentConversionListener);
        }
    }

    public void addPageChangeListener(PageChangeListener pageChangeListener) {
        if (this.f1722bF == null) {
            this.f1722bF = new CopyOnWriteArrayList<>();
        }
        this.f1722bF.add(pageChangeListener);
    }

    public void removePageChangeListener(PageChangeListener pageChangeListener) {
        CopyOnWriteArrayList<PageChangeListener> copyOnWriteArrayList = this.f1722bF;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(pageChangeListener);
        }
    }

    public void setRenderingListener(RenderingListener renderingListener) {
        this.f1732bP = renderingListener;
    }

    public void addDocumentLoadListener(DocumentLoadListener documentLoadListener) {
        if (this.f1726bJ == null) {
            this.f1726bJ = new CopyOnWriteArrayList<>();
        }
        if (this.f1726bJ.contains(documentLoadListener)) {
            return;
        }
        this.f1726bJ.add(documentLoadListener);
    }

    public void removeDocumentLoadListener(DocumentLoadListener documentLoadListener) {
        CopyOnWriteArrayList<DocumentLoadListener> copyOnWriteArrayList = this.f1726bJ;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(documentLoadListener);
        }
    }

    public void setErrorReportListener(ErrorReportListener errorReportListener) {
        this.f1728bL = errorReportListener;
    }

    public void addPageSlidingListener(PageSlidingListener pageSlidingListener) {
        if (this.f1730bN == null) {
            this.f1730bN = new ArrayList<>();
        }
        if (this.f1730bN.contains(pageSlidingListener)) {
            return;
        }
        this.f1730bN.add(pageSlidingListener);
    }

    public void removePageSlidingListener(PageSlidingListener pageSlidingListener) {
        ArrayList<PageSlidingListener> arrayList = this.f1730bN;
        if (arrayList != null) {
            arrayList.remove(pageSlidingListener);
        }
    }

    public void addThumbAsyncListener(ThumbAsyncListener thumbAsyncListener) {
        if (this.f1729bM == null) {
            this.f1729bM = new ArrayList<>();
        }
        if (this.f1729bM.contains(thumbAsyncListener)) {
            return;
        }
        this.f1729bM.add(thumbAsyncListener);
    }

    public void removeThumbAsyncListener(ThumbAsyncListener thumbAsyncListener) {
        ArrayList<ThumbAsyncListener> arrayList = this.f1729bM;
        if (arrayList != null) {
            arrayList.remove(thumbAsyncListener);
        }
    }

    public void setActionCompletedListener(ActionCompletedListener actionCompletedListener) {
        this.f1731bO = actionCompletedListener;
    }

    @Deprecated
    public void setTextSearchListener(TextSearchListener textSearchListener) {
        this.f1717bA = textSearchListener;
    }

    public void addTextSearchListener(TextSearchListener textSearchListener) {
        if (this.f1718bB == null) {
            this.f1718bB = new ArrayList<>();
        }
        if (this.f1718bB.contains(textSearchListener)) {
            return;
        }
        this.f1718bB.add(textSearchListener);
    }

    public void removeTextSearchListener(TextSearchListener textSearchListener) {
        ArrayList<TextSearchListener> arrayList = this.f1718bB;
        if (arrayList != null) {
            arrayList.remove(textSearchListener);
        }
    }

    public void setUniversalDocumentProgressIndicatorListener(UniversalDocumentProgressIndicatorListener universalDocumentProgressIndicatorListener) {
        this.f1733bQ = universalDocumentProgressIndicatorListener;
    }

    public void postCustomEvent(Object obj) {
        if (this.f1836dp.hasMessages(0)) {
            this.f1836dp.removeMessages(0);
        }
        this.f1801cg = obj;
        this.f1836dp.sendEmptyMessage(0);
    }

    public void closeTool() {
        ToolManager toolManager = this.f1736bT;
        if (toolManager != null) {
            toolManager.onClose();
        }
    }

    public double[] convScreenPtToCanvasPt(double d, double d2) {
        return ConvScreenPtToCanvasPt(this.f1823dc, d, d2);
    }

    public double[] convScreenPtToCanvasPt(double d, double d2, int i) {
        return ConvScreenPtToCanvasPt(this.f1823dc, d, d2, i);
    }

    public double[] convScreenPtToPagePt(double d, double d2) {
        return ConvScreenPtToPagePt(this.f1823dc, d, d2, -1);
    }

    public double[] convScreenPtToPagePt(double d, double d2, int i) {
        return ConvScreenPtToPagePt(this.f1823dc, d, d2, i);
    }

    public double[] convCanvasPtToScreenPt(double d, double d2) {
        return ConvCanvasPtToScreenPt(this.f1823dc, d, d2);
    }

    public double[] convCanvasPtToScreenPt(double d, double d2, int i) {
        return ConvCanvasPtToScreenPt(this.f1823dc, d, d2, i);
    }

    public double[] convCanvasPtToPagePt(double d, double d2) {
        return ConvCanvasPtToPagePt(this.f1823dc, d, d2, -1);
    }

    public double[] convCanvasPtToPagePt(double d, double d2, int i) {
        return ConvCanvasPtToPagePt(this.f1823dc, d, d2, i);
    }

    public double[] convPagePtToCanvasPt(double d, double d2) {
        return ConvPagePtToCanvasPt(this.f1823dc, d, d2, -1);
    }

    public double[] convPagePtToCanvasPt(double d, double d2, int i) {
        return ConvPagePtToCanvasPt(this.f1823dc, d, d2, i);
    }

    public double[] convPagePtToScreenPt(double d, double d2, int i) {
        return ConvPagePtToScreenPt(this.f1823dc, d, d2, i);
    }

    public boolean isDuringFling() {
        if (this.f1845f.getCurrX() == 0 && this.f1845f.getCurrY() == 0) {
            return false;
        }
        return (this.f1800cf.f1929M == 0 && this.f1800cf.f1930N == 0) ? false : true;
    }

    public double[] convPagePtToHorizontalScrollingPt(double d, double d2, int i) {
        int iM1343h = m1343h(i);
        double[] dArrConvPagePtToScreenPt = convPagePtToScreenPt(d, d2, i);
        if (!isContinuousPagePresentationMode(this.f1739bW)) {
            if (m1255a(this.f1739bW)) {
                if (this.f1666aB == this.f1668aD || this.f1800cf.f1933b) {
                    dArrConvPagePtToScreenPt[0] = dArrConvPagePtToScreenPt[0] + ((double) getScrollX());
                    dArrConvPagePtToScreenPt[1] = dArrConvPagePtToScreenPt[1] + ((double) getScrollOffsetForCanvasId(iM1343h));
                    return dArrConvPagePtToScreenPt;
                }
            } else if (this.f1665aA == this.f1667aC || this.f1800cf.f1933b) {
                dArrConvPagePtToScreenPt[0] = dArrConvPagePtToScreenPt[0] + ((double) getScrollOffsetForCanvasId(iM1343h));
                dArrConvPagePtToScreenPt[1] = dArrConvPagePtToScreenPt[1] + ((double) getScrollY());
                return dArrConvPagePtToScreenPt;
            }
            dArrConvPagePtToScreenPt[0] = dArrConvPagePtToScreenPt[0] + ((double) getScrollX());
            dArrConvPagePtToScreenPt[1] = dArrConvPagePtToScreenPt[1] + ((double) getScrollY());
            return dArrConvPagePtToScreenPt;
        }
        dArrConvPagePtToScreenPt[0] = dArrConvPagePtToScreenPt[0] + ((double) getScrollX());
        dArrConvPagePtToScreenPt[1] = dArrConvPagePtToScreenPt[1] + ((double) getScrollY());
        return dArrConvPagePtToScreenPt;
    }

    public double[] convHorizontalScrollingPtToPagePt(double d, double d2, int i) {
        int scrollY;
        int scrollY2;
        int iM1343h = m1343h(i);
        if (!isContinuousPagePresentationMode(this.f1739bW)) {
            boolean z = true;
            if (m1255a(this.f1739bW)) {
                if (this.f1666aB == this.f1668aD || this.f1800cf.f1933b) {
                    d -= (double) getScrollX();
                    scrollY2 = getScrollOffsetForCanvasId(iM1343h);
                    d2 -= (double) scrollY2;
                }
                z = false;
            } else {
                if (this.f1665aA == this.f1667aC || this.f1800cf.f1933b) {
                    d -= (double) getScrollOffsetForCanvasId(iM1343h);
                    scrollY2 = getScrollY();
                    d2 -= (double) scrollY2;
                }
                z = false;
            }
            if (!z) {
                d -= (double) getScrollX();
                scrollY = getScrollY();
            }
            return convScreenPtToPagePt(d, d2, i);
        }
        d -= (double) getScrollX();
        scrollY = getScrollY();
        d2 -= (double) scrollY;
        return convScreenPtToPagePt(d, d2, i);
    }

    public PointF snapToNearestInDoc(double d, double d2) {
        double[] dArrSnapToNearestInDoc = SnapToNearestInDoc(this.f1823dc, d, d2);
        return new PointF((float) dArrSnapToNearestInDoc[0], (float) dArrSnapToNearestInDoc[1]);
    }

    public void setSnappingMode(int i) {
        SetSnappingMode(this.f1823dc, i);
    }

    public boolean isSlidingWhileZoomed() {
        if (this.f1800cf.f1933b) {
            return this.f1800cf.f1918B || this.f1800cf.f1919C || this.f1800cf.f1920D;
        }
        return false;
    }

    public int getPageNumberFromScreenPt(double d, double d2) {
        return GetPageNumberFromScreenPt(this.f1823dc, d, d2);
    }

    public void prepareWords(int i) {
        try {
            PrepareWords(this.f1823dc, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean wereWordsPrepared(int i) {
        try {
            return WereWordsPrepared(this.f1823dc, i);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isThereTextInRect(double d, double d2, double d3, double d4) {
        try {
            return IsThereTextInRect(this.f1823dc, d, d2, d3, d4);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void prepareAnnotsForMouse(int i) {
        prepareAnnotsForMouse(i, 15.0d, 7.0d);
    }

    public void prepareAnnotsForMouse(int i, double d, double d2) {
        try {
            PrepareAnnotsForMouse(this.f1823dc, i, m1226a((float) d), m1226a((float) d2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean wereAnnotsForMousePrepared(int i) {
        try {
            return WereAnnotsForMousePrepared(this.f1823dc, i);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getAnnotTypeUnder(double d, double d2) {
        try {
            return GetAnnotTypeUnder(this.f1823dc, d, d2);
        } catch (Exception e) {
            e.printStackTrace();
            return 28;
        }
    }

    public void setTextSelectionMode(TextSelectionMode textSelectionMode) {
        SetTextSelectionMode(this.f1823dc, textSelectionMode.getValue());
    }

    public boolean select(double d, double d2, double d3, double d4) {
        return Select(this.f1823dc, d, d2, d3, d4);
    }

    public boolean select(double d, double d2, int i, double d3, double d4, int i2) {
        return Select(this.f1823dc, d, d2, i, d3, d4, i2);
    }

    public boolean selectByRect(double d, double d2, double d3, double d4) {
        return SelectByRect(this.f1823dc, d, d2, d3, d4);
    }

    public boolean selectByStructWithSmartSnapping(double d, double d2, double d3, double d4) {
        return SelectByStructWithSmartSnapping(this.f1823dc, d, d2, d3, d4);
    }

    public boolean selectByStructWithSnapping(double d, double d2, double d3, double d4, boolean z, boolean z2) {
        return SelectByStructWithSnapping(this.f1823dc, d, d2, d3, d4, z, z2);
    }

    public boolean selectWithHighlights(Highlights highlights) {
        return SelectByHighlights(this.f1823dc, highlights.f1566a);
    }

    public boolean selectAndJumpWithHighlights(Highlights highlights) {
        boolean zSelectWithHighlights = selectWithHighlights(highlights);
        if (zSelectWithHighlights) {
            if (!isContinuousPagePresentationMode(this.f1739bW)) {
                m1378s();
            }
            scrollTo(m1373q(), m1375r());
            invalidate();
        }
        return zSelectWithHighlights;
    }

    public boolean selectWithSelection(Selection selection) {
        return SelectBySelection(this.f1823dc, selection.f1895a);
    }

    public void selectAll() {
        SelectAll(this.f1823dc);
    }

    public boolean hasSelection() {
        return HasSelection(this.f1823dc);
    }

    public void clearSelection() {
        ClearSelection(this.f1823dc);
    }

    public Selection getSelection(int i) {
        return new Selection(this, GetSelection(this.f1823dc, i), this, (byte) 0);
    }

    public int getSelectionBeginPage() {
        return GetSelectionBeginPage(this.f1823dc);
    }

    public int getSelectionEndPage() {
        return GetSelectionEndPage(this.f1823dc);
    }

    public boolean hasSelectionOnPage(int i) {
        return HasSelectionOnPage(this.f1823dc, i);
    }

    public void findText(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        findText(str, z, z2, z3, z4, -1);
    }

    public void cancelFindText() {
        synchronized (this) {
            if (this.f1766bx > 0) {
                Thread thread = this.f1843dw;
                if (thread != null) {
                    thread.interrupt();
                }
                this.f1842dv.removeMessages(0);
                CancelFindText(this.f1823dc);
                this.f1767by = true;
            }
        }
    }

    public void cancelRendering() {
        this.f1827dg.removeMessages(0);
        long j = this.f1823dc;
        if (j != 0) {
            try {
                CancelRendering(j);
            } catch (Exception unused) {
            }
        }
    }

    public void cancelRenderingAsync() {
        this.f1827dg.removeMessages(0);
        long j = this.f1823dc;
        if (j != 0) {
            try {
                CancelRenderingAsync(j);
            } catch (Exception unused) {
            }
        }
    }

    public void requestRendering() {
        long j = this.f1823dc;
        if (j == 0 || this.f1807cm) {
            return;
        }
        try {
            RequestRender(j);
        } catch (Exception e) {
            Log.e("PDFNet", "RR1 " + e.getMessage());
            purgeMemory();
            try {
                RequestRender(this.f1823dc);
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    Log.e("PDFNet", "RR2 " + e2.getMessage());
                }
            }
        }
    }

    public boolean isFinishedRendering() {
        try {
            return IsFinishedRendering(this.f1823dc, false);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isFinishedRendering(boolean z) {
        try {
            return IsFinishedRendering(this.f1823dc, z);
        } catch (Exception unused) {
            return false;
        }
    }

    public void waitForRendering(int i) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (!isFinishedRendering(true)) {
            try {
                Thread.sleep(20L);
            } catch (InterruptedException unused) {
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis >= i) {
                return;
            }
        }
    }

    public void waitForRendering() {
        waitForRendering(1500);
    }

    @Override // android.view.View
    public boolean isHardwareAccelerated() {
        return super.isHardwareAccelerated();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0070 A[Catch: all -> 0x0074, Exception -> 0x0077, TRY_ENTER, TryCatch #3 {Exception -> 0x0077, blocks: (B:3:0x0013, B:5:0x001e, B:6:0x002c, B:19:0x005b, B:33:0x0070, B:34:0x0073), top: B:67:0x0013, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f9 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updatePageLayout() throws PDFNetException {
        CopyOnWriteArrayList<OnPageLayoutChangeListener> copyOnWriteArrayList;
        boolean zIsFinishedRendering;
        double zoom;
        double d;
        double d2;
        double d3;
        double d4;
        UpdatePageLayout(this.f1823dc);
        m1315c();
        boolean z = true;
        this.f1748bf = true;
        requestLayout();
        this.f1849j.lock();
        try {
            try {
                int[] iArrM1511b = this.f1852m.m1511b();
                for (int i : iArrM1511b) {
                    this.f1852m.m1509a(i).f1576c = null;
                }
                int pageBox = getPageBox();
                if (pageBox != 1) {
                    try {
                        docLockRead();
                        try {
                            try {
                                PDFDoc doc = getDoc();
                                for (int i2 : iArrM1511b) {
                                    if (i2 > 0 && i2 <= getPageCount()) {
                                        ImageCache.C69301 c69301M1509a = this.f1852m.m1509a(i2);
                                        Page page = doc.getPage(i2);
                                        if (page != null) {
                                            c69301M1509a.f1576c = page.getBox(pageBox);
                                        }
                                    }
                                }
                            } catch (PDFNetException e) {
                                e = e;
                                e.printStackTrace();
                                if (z) {
                                }
                                this.f1849j.unlock();
                                if (this.mDoc != null) {
                                    zIsFinishedRendering = isFinishedRendering();
                                    zoom = getZoom();
                                    cancelRendering();
                                    double dM1357k = m1357k();
                                    this.f1752bj = dM1357k;
                                    this.f1753bk = m1225a(dM1357k);
                                    double dM1360l = m1360l();
                                    this.f1755bm = dM1360l;
                                    this.f1756bn = m1225a(dM1360l);
                                    if (this.f1817cw) {
                                    }
                                    if (!this.f1817cw) {
                                    }
                                    d4 = d2 * d3;
                                    if (zoom < d) {
                                    }
                                    if (zoom > d4) {
                                    }
                                    if (!zIsFinishedRendering) {
                                    }
                                }
                                copyOnWriteArrayList = this.f1773cE;
                                if (copyOnWriteArrayList == null) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (z) {
                                docUnlockRead();
                            }
                            throw th;
                        }
                    } catch (PDFNetException e2) {
                        e = e2;
                        z = false;
                    } catch (Throwable th2) {
                        th = th2;
                        z = false;
                        if (z) {
                        }
                        throw th;
                    }
                    docUnlockRead();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f1849j.unlock();
            if (this.mDoc != null && this.f1751bi == ZoomLimitMode.RELATIVE) {
                zIsFinishedRendering = isFinishedRendering();
                zoom = getZoom();
                cancelRendering();
                double dM1357k2 = m1357k();
                this.f1752bj = dM1357k2;
                this.f1753bk = m1225a(dM1357k2);
                double dM1360l2 = m1360l();
                this.f1755bm = dM1360l2;
                this.f1756bn = m1225a(dM1360l2);
                if (this.f1817cw) {
                    setPageViewMode(this.f1820cz);
                }
                if (!this.f1817cw) {
                    d = this.f1749bg * this.f1755bm;
                    d2 = this.f1750bh;
                    d3 = this.f1756bn;
                } else {
                    d = this.f1749bg * this.f1752bj;
                    d2 = this.f1750bh;
                    d3 = this.f1753bk;
                }
                d4 = d2 * d3;
                if (zoom < d) {
                    setZoom(d);
                }
                if (zoom > d4) {
                    setZoom(d4);
                }
                if (!zIsFinishedRendering) {
                    requestRendering();
                }
            }
            copyOnWriteArrayList = this.f1773cE;
            if (copyOnWriteArrayList == null) {
                Iterator<OnPageLayoutChangeListener> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    it.next().onPageLayoutChanged();
                }
            }
        } catch (Throwable th3) {
            this.f1849j.unlock();
            throw th3;
        }
    }

    public void update() throws PDFNetException {
        update(false);
    }

    public void update(boolean z) throws PDFNetException {
        Update(this.f1823dc, z);
    }

    public void update(Rect rect) throws PDFNetException {
        Update(this.f1823dc, rect.f2037a);
    }

    public void update(Annot annot, int i) throws PDFNetException {
        Update(this.f1823dc, annot.f1439a, i);
    }

    public void update(Field field) throws PDFNetException {
        UpdateField(this.f1823dc, field.f1541a);
    }

    public void resume() {
        this.f1807cm = false;
        if (this.f1727bK) {
            requestLayout();
        }
        if (this.f1823dc != 0 && this.mDoc != null) {
            requestRendering();
        }
        ToolManager toolManager = this.f1736bT;
        if (toolManager != null) {
            toolManager.onResume();
        }
    }

    public void pause() {
        this.f1807cm = true;
        ToolManager toolManager = this.f1736bT;
        if (toolManager != null) {
            toolManager.onPause();
        }
        m1355j();
    }

    /* JADX INFO: renamed from: j */
    private void m1355j() {
        try {
            if (this.f1721bE) {
                CopyOnWriteArrayList<DocumentDownloadListener> copyOnWriteArrayList = this.f1719bC;
                if (copyOnWriteArrayList != null) {
                    Iterator<DocumentDownloadListener> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        it.next().onDownloadEvent(DownloadState.FAILED, 0, 0, 0, "cancelled");
                    }
                }
                CloseDoc(this.f1823dc);
                this.f1721bE = false;
            }
            cancelAllThumbRequests();
            cancelRendering();
            cancelFindText();
            closeTool();
            m1364m();
        } catch (Exception unused) {
        }
    }

    public void destroy() {
        if (this.f1823dc == 0) {
            return;
        }
        ImageCache imageCacheM1160a = ImageCache.m1160a();
        imageCacheM1160a.m1163a(false);
        imageCacheM1160a.m1164b();
        C6963b.a.f2110a.m1505b();
        imageCacheM1160a.m1163a(true);
        ToolManager toolManager = this.f1736bT;
        if (toolManager != null) {
            toolManager.onDestroy();
        }
        this.f1804cj.lock();
        try {
            AlertDialogC6939c alertDialogC6939c = this.f1735bS;
            if (alertDialogC6939c != null && alertDialogC6939c.isShowing()) {
                this.f1735bS.dismiss();
            }
        } catch (Exception unused) {
        }
        try {
            try {
                pause();
                this.f1849j.lock();
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    Log.e("PDFNet", e.getMessage());
                }
            }
            try {
                this.f1851l.m1524b();
                this.f1852m.m1512c();
                this.f1849j.unlock();
                CloseDoc(this.f1823dc);
                this.mDoc = null;
                pause();
                long j = this.f1823dc;
                if (j != 0) {
                    try {
                        Destroy(j);
                        this.f1823dc = 0L;
                    } catch (Exception unused2) {
                    }
                }
                m1364m();
                long j2 = this.f1824dd;
                if (j2 != 0) {
                    try {
                        DestroyRenderData(j2, 0L, 0L, 0L, 0L, 0L, this.f1822db);
                        this.f1824dd = 0L;
                    } catch (Exception unused3) {
                    }
                }
                SecondaryFileFilter secondaryFileFilter = this.mDocumentConversionFilter;
                if (secondaryFileFilter != null) {
                    secondaryFileFilter.close();
                    this.mDocumentConversionFilter = null;
                }
            } catch (Throwable th) {
                this.f1849j.unlock();
                throw th;
            }
        } finally {
            this.f1804cj.unlock();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        ToolManager toolManager = this.f1736bT;
        if (toolManager != null) {
            toolManager.onConfigurationChanged(configuration);
        }
    }

    public void purgeMemory() {
        this.f1643A = true;
        ImageCache imageCacheM1160a = ImageCache.m1160a();
        imageCacheM1160a.m1163a(false);
        imageCacheM1160a.m1164b();
        C6963b.a.f2110a.m1505b();
        try {
            cancelRendering();
            PurgeMemory(this.f1823dc);
            this.f1850k.lock();
            this.f1853n = null;
            this.f1850k.unlock();
        } finally {
            imageCacheM1160a.m1163a(true);
            this.f1643A = false;
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
    }

    public long[] getAllCanvasPixelSizes() {
        return GetAllCanvasPixelSizes(this.f1823dc);
    }

    public double getCanvasWidth() {
        return GetCanvasWidth(this.f1823dc);
    }

    public double getCanvasHeight() {
        return GetCanvasHeight(this.f1823dc);
    }

    public int getViewCanvasWidth() {
        return this.f1667aC;
    }

    public int getViewCanvasHeight() {
        return this.f1668aD;
    }

    public PagePresentationMode getPagePresentationMode() {
        PagePresentationMode pagePresentationMode = this.f1739bW;
        if (pagePresentationMode != null && (pagePresentationMode == PagePresentationMode.SINGLE_VERT || this.f1739bW == PagePresentationMode.FACING_VERT || this.f1739bW == PagePresentationMode.FACING_COVER_VERT)) {
            return this.f1739bW;
        }
        return PagePresentationMode.valueOf(GetPagePresentationMode(this.f1823dc));
    }

    public void setPagePresentationMode(PagePresentationMode pagePresentationMode) {
        int value;
        double d;
        double d2;
        if (this.f1817cw && m1255a(pagePresentationMode)) {
            Log.e(f1641c, "Non-continuous vertical mode is not available in maintain zoom mode, turning off maintain zoom mode...");
            try {
                setMaintainZoomEnabled(false);
            } catch (Exception unused) {
            }
        }
        try {
            if (pagePresentationMode != this.f1739bW) {
                if (!this.f1845f.isFinished()) {
                    this.f1845f.forceFinished(true);
                    if (this.f1858s && this.mDoc != null) {
                        int scrollX = getScrollX();
                        int scrollY = getScrollY();
                        if (m1255a(pagePresentationMode)) {
                            if (this.f1817cw) {
                                this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
                            }
                            if (scrollY >= this.f1675aK && m1369o()) {
                                scrollY -= this.f1675aK;
                            }
                        } else {
                            if (this.f1817cw) {
                                this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
                            }
                            if (scrollX >= this.f1671aG && m1369o()) {
                                scrollX -= this.f1671aG;
                            }
                        }
                        int iM1373q = scrollX - m1373q();
                        int iM1375r = scrollY - m1375r();
                        if (iM1373q != 0 || iM1375r != 0) {
                            scrollBy(iM1373q, iM1375r);
                        }
                    }
                }
                this.f1669aE = 0;
                this.f1670aF = 0;
                this.f1671aG = 0;
                this.f1672aH = 0;
                this.f1673aI = 0;
                this.f1674aJ = 0;
                this.f1675aK = 0;
                this.f1676aL = 0;
                this.f1739bW = pagePresentationMode;
                long j = this.f1823dc;
                if (pagePresentationMode == PagePresentationMode.SINGLE_VERT) {
                    value = PagePresentationMode.SINGLE.getValue();
                } else if (pagePresentationMode == PagePresentationMode.FACING_VERT) {
                    value = PagePresentationMode.FACING.getValue();
                } else if (pagePresentationMode == PagePresentationMode.FACING_COVER_VERT) {
                    value = PagePresentationMode.FACING_COVER.getValue();
                } else {
                    value = pagePresentationMode.getValue();
                }
                SetPagePresentationMode(j, value);
                requestLayout();
                if (this.mDoc != null && this.f1751bi == ZoomLimitMode.RELATIVE) {
                    double zoom = getZoom();
                    double dM1357k = m1357k();
                    this.f1752bj = dM1357k;
                    this.f1753bk = m1225a(dM1357k);
                    double dM1360l = m1360l();
                    this.f1755bm = dM1360l;
                    double dM1225a = m1225a(dM1360l);
                    this.f1756bn = dM1225a;
                    if (this.f1817cw) {
                        d = this.f1749bg * this.f1755bm;
                        d2 = this.f1750bh * dM1225a;
                    } else {
                        d = this.f1752bj * this.f1749bg;
                        d2 = this.f1753bk * this.f1750bh;
                    }
                    if (zoom < d) {
                        setZoom(d);
                        return;
                    } else if (zoom > d2) {
                        setZoom(d2);
                        return;
                    }
                }
                m1315c();
                scrollTo(m1373q(), m1375r());
            }
        } catch (Exception unused2) {
        }
    }

    public PageViewMode getPageViewMode() {
        return PageViewMode.valueOf(GetPageViewMode(this.f1823dc));
    }

    /* JADX INFO: renamed from: a */
    private void m1245a(PageViewMode pageViewMode, boolean z) {
        double d;
        double d2;
        if (getPageViewMode() != pageViewMode || z) {
            if (!this.f1845f.isFinished()) {
                this.f1845f.forceFinished(true);
                if (this.f1858s && this.mDoc != null) {
                    int scrollX = getScrollX();
                    int scrollY = getScrollY();
                    if (m1255a(this.f1739bW)) {
                        if (this.f1817cw) {
                            this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
                        }
                        if (scrollY >= this.f1675aK && m1369o()) {
                            scrollY -= this.f1675aK;
                        }
                    } else {
                        if (this.f1817cw) {
                            this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
                        }
                        if (scrollX >= this.f1671aG && m1369o()) {
                            scrollX -= this.f1671aG;
                        }
                    }
                    int iM1373q = scrollX - m1373q();
                    int iM1375r = scrollY - m1375r();
                    if (iM1373q != 0 || iM1375r != 0) {
                        scrollBy(iM1373q, iM1375r);
                    }
                }
            }
            SetPageViewMode(this.f1823dc, pageViewMode.getValue());
            this.f1737bU = pageViewMode;
            requestLayout();
            if (this.mDoc != null && this.f1751bi == ZoomLimitMode.RELATIVE) {
                double zoom = getZoom();
                double dM1357k = m1357k();
                this.f1752bj = dM1357k;
                double dM1225a = m1225a(dM1357k);
                this.f1753bk = dM1225a;
                if (this.f1817cw) {
                    d2 = this.f1749bg * this.f1755bm;
                    d = this.f1750bh * this.f1756bn;
                } else {
                    double d3 = this.f1749bg * this.f1752bj;
                    d = dM1225a * this.f1750bh;
                    d2 = d3;
                }
                if (zoom < d2) {
                    setZoom(d2);
                    return;
                } else if (zoom > d) {
                    setZoom(d);
                    return;
                }
            }
            m1315c();
            scrollTo(m1373q(), m1375r());
        }
    }

    public void setPageViewMode(PageViewMode pageViewMode) {
        try {
            m1245a(pageViewMode, false);
        } catch (Exception unused) {
        }
    }

    public void setPageViewMode(PageViewMode pageViewMode, int i, int i2, boolean z) {
        if (!z) {
            setPageViewMode(pageViewMode);
            return;
        }
        this.f1848i.m1534a(true);
        if (this.f1817cw) {
            if (m1255a(this.f1739bW)) {
                this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
            } else {
                this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
            }
        }
        m1323d(this.f1675aK);
        float f = i;
        float f2 = i2;
        m1316c(f, f2);
        m1304b(f, f2);
        this.f1652J.clear();
        setPageViewMode(pageViewMode);
        m1367n();
        m1238a(this.f1675aK);
        m1322d();
        boolean zIsContinuousPagePresentationMode = isContinuousPagePresentationMode(this.f1739bW);
        boolean zM1255a = m1255a(this.f1739bW);
        if (!zIsContinuousPagePresentationMode) {
            if (zM1255a) {
                this.f1678aN.top += getScrollY();
                this.f1678aN.bottom += getScrollY();
            } else {
                this.f1678aN.left += getScrollX();
                this.f1678aN.right += getScrollX();
            }
            for (int i3 = 0; i3 < this.f1680aP.size(); i3++) {
                RectF rectFValueAt = this.f1680aP.valueAt(i3);
                if (zM1255a) {
                    rectFValueAt.top += getScrollY();
                    rectFValueAt.bottom += getScrollY();
                } else {
                    rectFValueAt.left += getScrollX();
                    rectFValueAt.right += getScrollX();
                }
            }
        }
        ToolManager toolManager = this.f1736bT;
        if (toolManager != null) {
            toolManager.onDoubleTapZoomAnimationBegin();
        }
        this.f1848i.m1533a(this.f1677aM, this.f1678aN, this.f1679aO, this.f1680aP);
        this.f1860u = true;
    }

    public PageViewMode getPageRefViewMode() {
        return PageViewMode.valueOf(GetPageRefViewMode(this.f1823dc));
    }

    public void setPageRefViewMode(PageViewMode pageViewMode) throws PDFNetException {
        if (pageViewMode != PageViewMode.ZOOM && this.f1817cw) {
            throw new PDFNetException("", 0L, "PDFViewCtrl", "setPageRefViewMode", "Page Ref View Mode cannot be other than PAGE_VIEW_ZOOM when maintain zoom level feature is enabled.");
        }
        SetPageRefViewMode(this.f1823dc, pageViewMode.getValue());
    }

    public void setPreferredViewMode(PageViewMode pageViewMode) {
        this.f1820cz = pageViewMode;
    }

    public PageViewMode getPreferredViewMode() {
        return this.f1820cz;
    }

    public void setVerticalAlign(int i) throws PDFNetException {
        SetVerticalAlign(this.f1823dc, i);
    }

    public void setHorizontalAlign(int i) throws PDFNetException {
        SetHorizontalAlign(this.f1823dc, i);
    }

    /* JADX INFO: renamed from: k */
    private double m1357k() {
        if (this.f1738bV == PageViewMode.FIT_PAGE || this.f1738bV == PageViewMode.FIT_WIDTH || this.f1738bV == PageViewMode.FIT_HEIGHT) {
            return GetRefZoom(this.f1823dc, this.f1738bV.getValue());
        }
        return GetRefZoom(this.f1823dc, getPageRefViewMode().getValue());
    }

    /* JADX INFO: renamed from: a */
    private double m1225a(double d) {
        double d2 = this.f1754bl;
        return d < d2 ? d2 : d;
    }

    /* JADX INFO: renamed from: l */
    private double m1360l() {
        if (this.f1820cz == PageViewMode.FIT_PAGE || this.f1820cz == PageViewMode.FIT_WIDTH || this.f1820cz == PageViewMode.FIT_HEIGHT) {
            return GetRefZoom(this.f1823dc, this.f1820cz.getValue());
        }
        return 1.0d;
    }

    /* JADX INFO: renamed from: c */
    private double m1311c(int i) {
        if (this.f1820cz == PageViewMode.FIT_PAGE || this.f1820cz == PageViewMode.FIT_WIDTH || this.f1820cz == PageViewMode.FIT_HEIGHT) {
            return GetRefZoomForPage(this.f1823dc, this.f1820cz.getValue(), i);
        }
        return 1.0d;
    }

    public void setPageSpacingDP(int i, int i2, int i3, int i4) {
        setPageSpacing((int) (m1226a(i) + 0.5f), (int) (m1226a(i2) + 0.5f), (int) (m1226a(i3) + 0.5f), (int) (m1226a(i4) + 0.5f));
    }

    public void setPageSpacing(int i, int i2, int i3, int i4) {
        if (this.f1727bK) {
            return;
        }
        this.f1648F = i;
        this.f1649G = i2;
        this.f1650H = i3;
        SetPageSpacing(this.f1823dc, i, i2, i3, i4);
    }

    public void setDisplayCutout(int i, int i2) {
        if (this.f1727bK) {
            return;
        }
        this.f1646D = i;
        this.f1647E = i2;
        setPageSpacing(this.f1648F, this.f1649G, this.f1650H, Math.max(i, i2));
    }

    public int getDisplayCutoutTop() {
        return this.f1646D;
    }

    public int getDisplayCutoutBottom() {
        return this.f1647E;
    }

    public void setProgressiveRendering(boolean z) {
        this.f1654M = z;
    }

    public void setProgressiveRendering(boolean z, int i, int i2) {
        this.f1654M = z;
        if (z) {
            if (i <= 0) {
                i = this.f1655N;
            }
            this.f1655N = i;
            if (i2 <= 0) {
                i2 = this.f1656O;
            }
            this.f1656O = i2;
        }
    }

    public void setupThumbnails(boolean z, boolean z2, boolean z3, int i, long j, double d) throws PDFNetException {
        cancelRendering();
        this.f1852m.m1512c();
        SetupThumbnails(this.f1823dc, z, z2, z3, i, j, d);
        this.f1828dh.sendEmptyMessage(0);
    }

    public void clearThumbCache() throws PDFNetException {
        ClearThumbCache(this.f1823dc);
    }

    public void setOCGContext(com.pdftron.pdf.ocg.Context context) throws PDFNetException {
        if (context == null) {
            SetOCGContext(this.f1823dc, 0L);
        } else {
            SetOCGContext(this.f1823dc, context.__GetHandle());
        }
    }

    @Deprecated
    public void updateOCGContext() throws PDFNetException {
        UpdateOCGContext(this.f1823dc);
    }

    public com.pdftron.pdf.ocg.Context getOCGContext() throws PDFNetException {
        return com.pdftron.pdf.ocg.Context.__Create(GetOCGContext(this.f1823dc), this);
    }

    public void cancelAllThumbRequests() throws PDFNetException {
        long j = this.f1823dc;
        if (j != 0) {
            CancelAllThumbRequests(j);
        }
    }

    public void getThumbAsync(int i) throws PDFNetException {
        if (isValid()) {
            GetThumbAsync(this.f1823dc, i, this.f1824dd);
        }
    }

    public boolean getProgressiveRendering() {
        return this.f1654M;
    }

    public void setCaching(boolean z) throws PDFNetException {
        SetCaching(this.f1823dc, z);
    }

    public void setUrlExtraction(boolean z) throws PDFNetException {
        SetUrlExtraction(this.f1823dc, z);
    }

    public LinkInfo getLinkAt(int i, int i2) throws PDFNetException {
        if (isValid()) {
            return GetLinkAt(this.f1823dc, i, i2);
        }
        return null;
    }

    public void setRenderedContentCacheSize(long j) throws PDFNetException {
        SetMemInfo(this.f1823dc, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, j << 20);
    }

    public void setImageSmoothing(boolean z) throws PDFNetException {
        SetImageSmoothing(this.f1823dc, z);
        update();
    }

    public boolean getRightToLeftLanguage() {
        return this.f1805ck;
    }

    public void setRightToLeftLanguage(boolean z) throws PDFNetException {
        if (z != this.f1805ck) {
            this.f1805ck = z;
            SetRightToLeftLanguage(this.f1823dc, z);
            updatePageLayout();
            update(true);
        }
    }

    public int getPageBox() throws PDFNetException {
        return GetPageBox(this.f1823dc);
    }

    public void setPageBox(int i) throws PDFNetException {
        SetPageBox(this.f1823dc, i);
    }

    public void setDefaultPageColor(int i, int i2, int i3) throws PDFNetException {
        setDefaultPageColor(Color.argb(255, i, i2, i3));
    }

    public void setDefaultPageColor(int i) throws PDFNetException {
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        int iArgb = Color.argb(Color.alpha(i), iRed, iGreen, iBlue);
        if (this.f1863x != iArgb) {
            SetDefaultPageColor(this.f1823dc, (byte) iRed, (byte) iGreen, (byte) iBlue);
            this.f1863x = iArgb;
            this.f1864y = iArgb;
            this.f1702al.setColor(iArgb);
            update();
        }
    }

    public void setClientBackgroundColor(int i, int i2, int i3, boolean z) throws PDFNetException {
        int iArgb = Color.argb(z ? 0 : 255, i, i2, i3);
        if (this.f1865z != iArgb) {
            SetBackgroundColor(this.f1823dc, (byte) Color.red(iArgb), (byte) Color.green(iArgb), (byte) Color.blue(iArgb), (byte) Color.alpha(iArgb));
            this.f1865z = iArgb;
            setBackgroundColor(iArgb);
            this.f1704an.setColor(this.f1865z);
            invalidate();
            update();
        }
    }

    public void hideAnnotation(Annot annot) {
        if (this.f1770cB) {
            this.f1653L.add(Long.valueOf(annot.__GetHandle()));
            invalidate();
        } else {
            HideAnnotation(this.f1823dc, annot.f1439a);
        }
    }

    public void showAnnotation(Annot annot) {
        if (this.f1770cB) {
            this.f1653L.remove(Long.valueOf(annot.__GetHandle()));
            invalidate();
        } else {
            ShowAnnotation(this.f1823dc, annot.f1439a);
        }
    }

    public int getClientBackgroundColor() {
        return this.f1865z;
    }

    public void setDrawAnnotations(boolean z) throws PDFNetException {
        SetDrawAnnotations(this.f1823dc, z);
        update(true);
    }

    public void setAntiAliasing(boolean z) throws PDFNetException {
        SetAntiAliasing(this.f1823dc, z);
        update(true);
    }

    public void setHighlightFields(boolean z) throws PDFNetException {
        SetHighlightFields(this.f1823dc, z);
        update(true);
    }

    public void setFieldHighlightColor(ColorPt colorPt) throws PDFNetException {
        SetFieldHighlightColor(this.f1823dc, colorPt.__GetHandle());
        update(true);
    }

    public void setSignatureHighlightColor(ColorPt colorPt) throws PDFNetException {
        SetSignatureHighlightColor(this.f1823dc, colorPt.__GetHandle());
        update(true);
    }

    public void setRequiredFieldBorderColor(ColorPt colorPt) throws PDFNetException {
        SetRequiredFieldBorderColor(this.f1823dc, colorPt.__GetHandle());
        update(true);
    }

    public void setPathHinting(boolean z) throws PDFNetException {
        SetPathHinting(this.f1823dc, z);
        update(true);
    }

    public void setPageBorderVisibility(boolean z) throws PDFNetException {
        SetPageBorderVisibility(this.f1823dc, z);
    }

    public void setPageTransparencyGrid(boolean z) throws PDFNetException {
        SetPageTransparencyGrid(this.f1823dc, z);
    }

    public void setThinLineAdjustment(boolean z, boolean z2) throws PDFNetException {
        SetThinLineAdjustment(this.f1823dc, z, z2);
        update(true);
    }

    public void setOverprint(OverPrintMode overPrintMode) throws PDFNetException {
        SetOverprint(this.f1823dc, overPrintMode.getValue());
        update(true);
    }

    public void setGamma(double d) throws PDFNetException {
        SetGamma(this.f1823dc, d);
        update(true);
    }

    public void setNextOnLayoutAdjustments(int i, int i2, boolean z) {
        this.f1808cn = i;
        this.f1809co = i2;
        this.f1810cp = z;
    }

    public void getContentSize(int[] iArr) {
        char c;
        int iMin;
        int iMax;
        int iMin2;
        int iMax2;
        double[] dArrM1261a = m1261a(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, this.f1667aC, this.f1668aD);
        char c2 = 3;
        boolean z = true;
        char c3 = 2;
        if (dArrM1261a.length > 0) {
            iMin = (int) Math.min(dArrM1261a[1], dArrM1261a[3]);
            iMax = (int) Math.max(dArrM1261a[1], dArrM1261a[3]);
            iMin2 = (int) Math.min(dArrM1261a[2], dArrM1261a[4]);
            iMax2 = (int) Math.max(dArrM1261a[2], dArrM1261a[4]);
            int length = dArrM1261a.length;
            int i = 5;
            while (i < length) {
                int i2 = i + 1;
                int i3 = i + 3;
                char c4 = c2;
                iMin = (int) Math.min(dArrM1261a[i2], Math.min(dArrM1261a[i3], iMin));
                iMax = (int) Math.max(dArrM1261a[i2], Math.max(dArrM1261a[i3], iMax));
                int i4 = i + 2;
                int i5 = i + 4;
                iMin2 = (int) Math.min(dArrM1261a[i4], Math.min(dArrM1261a[i5], iMin2));
                iMax2 = (int) Math.max(dArrM1261a[i4], Math.max(dArrM1261a[i5], iMax2));
                i += 5;
                c2 = c4;
                z = z;
                c3 = c3;
            }
            c = 0;
        } else {
            c = 0;
            iMin = 0;
            iMax = 0;
            iMin2 = 0;
            iMax2 = 0;
        }
        int[] iArrGetPageSpacing = GetPageSpacing(this.f1823dc);
        int i6 = iMax - iMin;
        int i7 = iArrGetPageSpacing[c3];
        iArr[c] = i6 + i7 + i7;
        int i8 = iArrGetPageSpacing[c2];
        iArr[z ? 1 : 0] = (iMax2 - iMin2) + i8 + i8;
    }

    public void setDevicePixelDensity(double d, double d2) {
        SetDevicePixelDensity(this.f1823dc, d, d2);
    }

    public Rect getScreenRectForAnnot(Annot annot, int i) throws PDFNetException {
        return new Rect(GetScreenRectForAnnot(this.f1823dc, annot.f1439a, i));
    }

    public Rect getPageRectForAnnot(Annot annot, int i) throws PDFNetException {
        Rect screenRectForAnnot = getScreenRectForAnnot(annot, i);
        double[] dArrConvScreenPtToPagePt = convScreenPtToPagePt(screenRectForAnnot.getX1(), screenRectForAnnot.getY1(), i);
        double d = dArrConvScreenPtToPagePt[0];
        double d2 = dArrConvScreenPtToPagePt[1];
        double[] dArrConvScreenPtToPagePt2 = convScreenPtToPagePt(screenRectForAnnot.getX2(), screenRectForAnnot.getY2(), i);
        double d3 = dArrConvScreenPtToPagePt2[0];
        double d4 = dArrConvScreenPtToPagePt2[1];
        return new Rect(d < d3 ? d : d3, d2 < d4 ? d2 : d4, d > d3 ? d : d3, d2 > d4 ? d2 : d4);
    }

    public Annot getAnnotationAt(int i, int i2) {
        return getAnnotationAt(i, i2, 15.0d, 7.0d);
    }

    public Annot getAnnotationAt(int i, int i2, double d, double d2) {
        if (this.mDoc == null) {
            return null;
        }
        try {
            return new Annot(GetAnnotationAt(this.f1823dc, i, i2, m1226a((float) d), m1226a((float) d2)), this);
        } catch (Exception unused) {
            return null;
        }
    }

    public ArrayList<Annot> getAnnotationListAt(int i, int i2, int i3, int i4) {
        ArrayList<Annot> arrayList = new ArrayList<>();
        try {
            long[] jArrGetAnnotationListAt = GetAnnotationListAt(this.f1823dc, i, i2, i3, i4);
            for (long j : jArrGetAnnotationListAt) {
                arrayList.add(new Annot(j, this));
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public ArrayList<Annot> getAnnotationsOnPage(int i) {
        ArrayList<Annot> arrayList = new ArrayList<>();
        try {
            for (long j : GetAnnotationsOnPage(this.f1823dc, i)) {
                arrayList.add(new Annot(j, this));
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public CurvePainter getAnnotationPainter(int i, long j) {
        this.f1849j.lock();
        try {
            C6965d c6965dM1515a = this.f1851l.m1515a(i, j, 1);
            if (c6965dM1515a != null && c6965dM1515a.f2125n != null) {
                return CurvePainter.create(c6965dM1515a.f2125n);
            }
            this.f1849j.unlock();
            return null;
        } finally {
            this.f1849j.unlock();
        }
    }

    public void setColorPostProcessMode(int i) throws PDFNetException {
        if (i != getColorPostProcessMode()) {
            SetColorPostProcessMode(this.f1823dc, i);
            if (i == 3) {
                int i2 = this.f1864y;
                int iArgb = Color.argb(Color.alpha(i2), 255 - Color.red(i2), 255 - Color.green(i2), 255 - Color.blue(i2));
                this.f1863x = iArgb;
                this.f1702al.setColor(iArgb);
            } else if (i == 0) {
                int i3 = this.f1864y;
                this.f1863x = i3;
                this.f1702al.setColor(i3);
            }
            update();
        }
    }

    public void setColorPostProcessColors(int i, int i2) throws PDFNetException {
        SetColorPostProcessColors(this.f1823dc, i, i2);
        this.f1863x = i;
        this.f1702al.setColor(i);
        update();
    }

    public void setColorPostProcessMapFile(Filter filter) throws PDFNetException {
        SetColorPostProcessMapFile(this.f1823dc, filter.__GetHandle());
        this.f1863x = -5422;
        this.f1702al.setColor(-5422);
        update();
    }

    public ColorPt getPostProcessedColor(ColorPt colorPt) {
        return new ColorPt(GetPostProcessedColor(this.f1823dc, colorPt.__GetHandle()));
    }

    public boolean isUndoRedoEnabled() {
        return this.f1769cA;
    }

    public void enableUndoRedo() throws PDFNetException {
        EnableUndoRedo(this.f1823dc);
        this.f1769cA = true;
    }

    public String undo() throws PDFNetException {
        ExternalAnnotManager externalAnnotManager = this.f1844e;
        if (externalAnnotManager != null) {
            return externalAnnotManager.undo();
        }
        return Undo(this.f1823dc);
    }

    public String redo() throws PDFNetException {
        ExternalAnnotManager externalAnnotManager = this.f1844e;
        if (externalAnnotManager != null) {
            return externalAnnotManager.redo();
        }
        return Redo(this.f1823dc);
    }

    public String takeUndoSnapshot(String str) throws PDFNetException {
        ExternalAnnotManager externalAnnotManager = this.f1844e;
        if (externalAnnotManager != null) {
            return externalAnnotManager.takeSnapshot(str);
        }
        TakeSnapshot(this.f1823dc, str);
        return null;
    }

    public String getNextUndoInfo() throws PDFNetException {
        ExternalAnnotManager externalAnnotManager = this.f1844e;
        if (externalAnnotManager != null) {
            return externalAnnotManager.getNextUndoInfo();
        }
        return GetNextUndoInfo(this.f1823dc);
    }

    public String getNextRedoInfo() throws PDFNetException {
        ExternalAnnotManager externalAnnotManager = this.f1844e;
        if (externalAnnotManager != null) {
            return externalAnnotManager.getNextRedoInfo();
        }
        return GetNextRedoInfo(this.f1823dc);
    }

    public boolean canUndo() throws PDFNetException {
        return CanUndo(this.f1823dc);
    }

    public boolean canRedo() throws PDFNetException {
        return CanRedo(this.f1823dc);
    }

    public void revertAllChanges() throws PDFNetException {
        RevertAllChanges(this.f1823dc);
    }

    public ExternalAnnotManager enableExternalAnnotManager(String str) throws PDFNetException {
        return enableExternalAnnotManager(str, AnnotationManagerMode.ADMIN_UNDO_OWN);
    }

    public ExternalAnnotManager enableExternalAnnotManager(String str, AnnotationManagerMode annotationManagerMode) throws PDFNetException {
        ExternalAnnotManager externalAnnotManager = new ExternalAnnotManager(GetExternalAnnotManager(this.f1823dc, str, annotationManagerMode.getValue()));
        this.f1844e = externalAnnotManager;
        return externalAnnotManager;
    }

    public ExternalAnnotManager getExternalAnnotManager() throws PDFNetException, NullPointerException {
        ExternalAnnotManager externalAnnotManager = this.f1844e;
        if (externalAnnotManager != null) {
            return externalAnnotManager;
        }
        throw new NullPointerException("ExternalAnnotManager is not set");
    }

    public void enableAnnotationLayer() {
        EnableFloatingAnnotTiles(this.f1823dc, this.f1824dd, 33);
        this.f1770cB = true;
    }

    public boolean isAnnotationLayerEnabled() {
        return this.f1770cB;
    }

    public int getColorPostProcessMode() throws PDFNetException {
        return GetColorPostProcessMode(this.f1823dc);
    }

    /* JADX INFO: renamed from: a */
    private boolean m1259a(Obj obj, HashSet<Long> hashSet) {
        if (obj != null) {
            try {
                Long lValueOf = Long.valueOf(obj.__GetHandle());
                if (!hashSet.contains(lValueOf)) {
                    hashSet.add(lValueOf);
                    Action action = new Action(obj);
                    int type = action.getType();
                    if (type == 13 || type == 0 || type == 9) {
                        return true;
                    }
                    return m1259a(action.GetNext(), hashSet);
                }
            } catch (PDFNetException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void executeAction(Action action) throws PDFNetException {
        executeAction(new ActionParameter(action));
    }

    public void executeAction(ActionParameter actionParameter) throws PDFNetException {
        double d;
        double d2;
        double d3;
        char c;
        char c2;
        double d4;
        double d5;
        double d6;
        int currentPage = getCurrentPage();
        Obj sDFObj = actionParameter.getAction().getSDFObj();
        HashSet<Long> hashSet = new HashSet<>();
        double zoom = getZoom();
        ExecuteAction(this.f1823dc, actionParameter.f1437a);
        if (m1259a(sDFObj, hashSet)) {
            if (!this.f1817cw) {
                zoom = getZoom();
            }
            double d7 = zoom;
            int[] iArrGetVisiblePages = GetVisiblePages(this.f1823dc);
            int i = iArrGetVisiblePages.length > 0 ? iArrGetVisiblePages[0] : -1;
            if (i > 0) {
                double[] dArrConvScreenPtToPagePt = convScreenPtToPagePt(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, i);
                double d8 = dArrConvScreenPtToPagePt[0];
                double d9 = dArrConvScreenPtToPagePt[1];
                d = d8;
                d2 = d9;
            } else {
                d = 0.0d;
                d2 = 0.0d;
            }
            int currentPage2 = getCurrentPage();
            if (currentPage2 != currentPage) {
                setCurrentPage(currentPage2);
            }
            if (this.f1751bi == ZoomLimitMode.RELATIVE) {
                if (this.f1817cw) {
                    d5 = this.f1749bg;
                    d6 = this.f1755bm;
                } else {
                    d5 = this.f1749bg;
                    d6 = this.f1752bj;
                }
                d3 = d5 * d6;
            } else {
                d3 = this.f1749bg;
            }
            if (this.f1751bi == ZoomLimitMode.RELATIVE) {
                if (this.f1817cw) {
                    c = 0;
                    c2 = 1;
                    d4 = this.f1750bh * this.f1756bn;
                } else {
                    c = 0;
                    c2 = 1;
                    d4 = this.f1753bk * this.f1750bh;
                }
            } else {
                c = 0;
                c2 = 1;
                d4 = this.f1750bh;
            }
            if (d7 < d3) {
                d7 = d3;
            } else if (d7 > d4) {
                d7 = d4;
            }
            setZoom(d7);
            if (i > 0) {
                double[] dArrConvPagePtToScreenPt = convPagePtToScreenPt(d, d2, i);
                scrollTo(((int) dArrConvPagePtToScreenPt[c]) + m1373q(), ((int) dArrConvPagePtToScreenPt[c2]) + m1375r());
            }
            double dM1357k = m1357k();
            this.f1752bj = dM1357k;
            this.f1753bk = m1225a(dM1357k);
        }
    }

    public static void setViewerCache(SDFDoc sDFDoc, int i, boolean z) throws PDFNetException {
        SetViewerCache(sDFDoc.__GetHandle(), i, z);
    }

    public void rotateClockwise() {
        RotateClockwise(this.f1823dc);
    }

    public void rotateCounterClockwise() {
        RotateCounterClockwise(this.f1823dc);
    }

    public int getPageRotation() {
        return GetRotation(this.f1823dc);
    }

    public int getHScrollPos() {
        return isMaintainZoomEnabled() ? m1373q() : getScrollX();
    }

    public void setHScrollPos(int i) {
        setScrollX(i);
    }

    public int getVScrollPos() {
        return isMaintainZoomEnabled() ? m1375r() : getScrollY();
    }

    public void setVScrollPos(int i) {
        setScrollY(i);
    }

    public Matrix2D getDeviceTransform() {
        return Matrix2D.__Create(GetDeviceTransform(this.f1823dc, -1));
    }

    public Matrix2D getDeviceTransform(int i) {
        return Matrix2D.__Create(GetDeviceTransform(this.f1823dc, i));
    }

    public void setZoomEnabled(boolean z) {
        this.f1806cl = z;
    }

    public boolean getZoomEnabled() {
        return this.f1806cl;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public void purgeMemoryDueToOOM() {
        ImageCache imageCacheM1160a = ImageCache.m1160a();
        imageCacheM1160a.m1163a(false);
        imageCacheM1160a.m1164b();
        imageCacheM1160a.m1163a(true);
        C6963b.a.f2110a.m1505b();
        HandlerC6947k handlerC6947k = this.f1829di;
        if (handlerC6947k != null) {
            handlerC6947k.m1452a();
        }
    }

    /* JADX INFO: renamed from: m */
    private void m1364m() {
        this.f1828dh.removeCallbacksAndMessages(null);
        this.f1831dk.removeCallbacksAndMessages(null);
        this.f1834dn.removeCallbacksAndMessages(null);
        this.f1833dm.removeCallbacksAndMessages(null);
        this.f1832dl.removeCallbacksAndMessages(null);
        this.f1835do.removeCallbacksAndMessages(null);
        this.f1836dp.removeCallbacksAndMessages(null);
        this.f1842dv.removeCallbacksAndMessages(null);
        this.f1837dq.removeCallbacksAndMessages(null);
        this.f1838dr.removeCallbacksAndMessages(null);
        this.f1830dj.removeCallbacksAndMessages(null);
        this.f1839ds.removeCallbacksAndMessages(null);
        this.f1840dt.removeCallbacksAndMessages(null);
        this.f1841du.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: renamed from: a */
    private void m1237a(float f, float f2) {
        double d = f;
        double d2 = f2;
        int pageNumberFromScreenPt = getPageNumberFromScreenPt(d, d2);
        this.f1757bo = pageNumberFromScreenPt;
        if (pageNumberFromScreenPt <= 0) {
            this.f1757bo = getCurrentPage();
        }
        double[] dArrConvScreenPtToPagePt = convScreenPtToPagePt(d, d2, this.f1757bo);
        this.f1758bp = (float) dArrConvScreenPtToPagePt[0];
        this.f1759bq = (float) dArrConvScreenPtToPagePt[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m1252a(long j, int i, int i2) {
        try {
            return DownloaderUpdatePage(this.f1823dc, j, i, i2);
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public boolean m1329e(long j) {
        try {
            return DownloaderIsCorrectDoc(this.f1823dc, j);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m1250a(int i, int i2, boolean z) {
        boolean zGotoFirstPage;
        try {
            if (this.mDoc != null) {
                int currentPage = getCurrentPage();
                boolean zIsContinuousPagePresentationMode = isContinuousPagePresentationMode(this.f1739bW);
                if (i == -2) {
                    zGotoFirstPage = GotoFirstPage(this.f1823dc);
                } else if (i == -1) {
                    zGotoFirstPage = GotoPreviousPage(this.f1823dc);
                } else if (i == 0) {
                    zGotoFirstPage = SetCurrentPage(this.f1823dc, i2);
                } else if (i == 1) {
                    zGotoFirstPage = GotoNextPage(this.f1823dc);
                } else {
                    zGotoFirstPage = i != 2 ? false : GotoLastPage(this.f1823dc);
                }
                if (zGotoFirstPage) {
                    if (!this.f1845f.isFinished()) {
                        this.f1845f.forceFinished(true);
                    }
                    if (!zIsContinuousPagePresentationMode) {
                        this.f1667aC = GetTilingRegionWidth(this.f1823dc);
                        this.f1668aD = GetTilingRegionHeight(this.f1823dc);
                        if (!this.f1857r) {
                            if (currentPage != i2 && !this.f1817cw && (!this.f1800cf.f1923G || ((getPagePresentationMode() != PagePresentationMode.FACING_COVER && getPagePresentationMode() != PagePresentationMode.FACING && getPagePresentationMode() != PagePresentationMode.FACING_COVER_VERT && getPagePresentationMode() != PagePresentationMode.FACING_VERT) || Math.abs(currentPage - i2) != 1))) {
                                double dM1357k = m1357k();
                                this.f1752bj = dM1357k;
                                this.f1753bk = m1225a(dM1357k);
                            }
                            this.f1725bI = PageChangeState.END;
                            this.f1831dk.removeMessages(0);
                            this.f1831dk.sendEmptyMessage(0);
                            C6946j.m1417d(this.f1800cf, false);
                            int currentPage2 = getCurrentPage();
                            m1378s();
                            ToolManager toolManager = this.f1736bT;
                            if (toolManager != null) {
                                toolManager.onPageTurning(this.f1800cf.f1956y, currentPage2);
                            }
                        }
                    }
                    int iM1343h = m1343h(currentPage);
                    int iM1343h2 = m1343h(i2);
                    if (this.f1817cw && iM1343h != iM1343h2) {
                        this.f1818cx.put(iM1343h, m1373q());
                        this.f1819cy.put(iM1343h, m1375r());
                    }
                    if (!this.f1857r) {
                        int i3 = this.f1818cx.get(iM1343h2, Integer.MIN_VALUE);
                        int i4 = this.f1819cy.get(iM1343h2, Integer.MIN_VALUE);
                        if (!zIsContinuousPagePresentationMode && this.f1817cw && iM1343h2 != iM1343h && i3 != Integer.MIN_VALUE && i4 != Integer.MIN_VALUE) {
                            scrollTo(i3, i4);
                        } else if (z) {
                            this.f1845f.startScroll(getScrollX(), getScrollY(), m1373q() - getScrollX(), m1375r() - getScrollY());
                        } else {
                            scrollTo(m1373q(), m1375r());
                        }
                        invalidate();
                    }
                    if (this.f1817cw) {
                        this.f1755bm = Math.min(this.f1755bm, m1311c(i2));
                        double dMax = Math.max(this.f1756bn, m1311c(i2));
                        this.f1756bn = dMax;
                        this.f1756bn = m1225a(dMax);
                        return zGotoFirstPage;
                    }
                    double dM1357k2 = m1357k();
                    this.f1752bj = dM1357k2;
                    this.f1753bk = m1225a(dM1357k2);
                }
                return zGotoFirstPage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private void m1304b(float f, float f2) {
        this.f1743ba = (float) getZoom();
        this.f1744bb = f;
        this.f1745bc = f2;
        if (this.f1862w || this.f1853n == null || this.f1651I.size() <= 0) {
            m1350i();
        }
    }

    /* JADX INFO: renamed from: n */
    private void m1367n() {
        scrollBy(0, (int) (((float) convPagePtToScreenPt(this.f1687aW, this.f1688aX, this.f1689aY)[1]) - this.f1684aT));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m1323d(int i) {
        int i2;
        int i3;
        this.f1679aO.clear();
        int scrollY = getScrollY() - i;
        int i4 = this.f1666aB;
        double[] dArrM1261a = m1261a(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, scrollY - (i4 * 5), this.f1667aC, scrollY + (i4 * 6));
        int length = dArrM1261a.length / 5;
        if (m1255a(this.f1739bW)) {
            if (this.f1817cw) {
                this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
            }
            if (m1369o()) {
                i3 = this.f1675aK;
                i2 = 0;
            } else {
                i2 = 0;
                i3 = 0;
            }
        } else {
            if (this.f1817cw) {
                this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
            }
            if (m1369o()) {
                i2 = this.f1671aG;
                i3 = 0;
            }
        }
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 5;
            float f = i2;
            float f2 = i3;
            this.f1679aO.put((int) dArrM1261a[i6], new RectF((((float) dArrM1261a[i6 + 1]) - getScrollX()) + f, (((float) dArrM1261a[i6 + 2]) - getScrollY()) + f2, (((float) dArrM1261a[i6 + 3]) - getScrollX()) + f, (((float) dArrM1261a[i6 + 4]) - getScrollY()) + f2));
        }
    }

    /* JADX INFO: renamed from: c */
    private void m1316c(float f, float f2) {
        this.f1774cF.m1465d();
        this.f1682aR = (float) getZoom();
        this.f1683aS = f;
        this.f1684aT = f2;
        this.f1690aZ = getCurrentPage();
        double[] dArrConvScreenPtToCanvasPt = convScreenPtToCanvasPt(this.f1683aS, this.f1684aT);
        this.f1685aU = (float) dArrConvScreenPtToCanvasPt[0];
        this.f1686aV = (float) dArrConvScreenPtToCanvasPt[1];
        int pageNumberFromScreenPt = getPageNumberFromScreenPt(this.f1683aS, this.f1684aT);
        this.f1689aY = pageNumberFromScreenPt;
        double[] dArrConvScreenPtToPagePt = convScreenPtToPagePt(this.f1683aS, this.f1684aT, pageNumberFromScreenPt);
        this.f1687aW = (float) dArrConvScreenPtToPagePt[0];
        this.f1688aX = (float) dArrConvScreenPtToPagePt[1];
    }

    /* JADX INFO: renamed from: a */
    private boolean m1249a(float f, float f2, double d) {
        m1304b(f, f2);
        this.f1652J.clear();
        boolean zSetZoom = SetZoom(this.f1823dc, (int) this.f1744bb, (int) this.f1745bc, m1300b(d), false);
        m1315c();
        scrollTo(m1373q(), m1375r());
        return zSetZoom;
    }

    /* JADX INFO: renamed from: b */
    private double m1300b(double d) {
        double d2;
        double d3;
        double d4;
        double d5;
        if (this.f1751bi == ZoomLimitMode.NONE) {
            return d;
        }
        if (this.f1751bi == ZoomLimitMode.RELATIVE) {
            if (this.f1817cw) {
                d2 = this.f1749bg * this.f1755bm;
                d4 = this.f1750bh;
                d5 = this.f1756bn;
            } else {
                d2 = this.f1749bg * this.f1752bj;
                d4 = this.f1750bh;
                d5 = this.f1753bk;
            }
            d3 = d4 * d5;
        } else {
            d2 = this.f1749bg;
            d3 = this.f1750bh;
        }
        if (d2 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d < d2) {
            if (f1639a) {
                Log.d(f1641c, "scale: hit MIN_ZOOM");
            }
            this.f1764bv = true;
            d = d2;
        } else {
            this.f1764bv = false;
        }
        if (d3 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d > d3) {
            if (f1639a) {
                Log.d(f1641c, "scale: hit MAX_ZOOM");
            }
            this.f1765bw = true;
            return d3;
        }
        this.f1765bw = false;
        return d;
    }

    /* JADX INFO: renamed from: o */
    private boolean m1369o() {
        if (isContinuousPagePresentationMode(this.f1739bW)) {
            return false;
        }
        return m1255a(this.f1739bW) ? this.f1800cf.f1933b || this.f1817cw || this.f1666aB == this.f1668aD : this.f1800cf.f1933b || this.f1817cw || this.f1665aA == this.f1667aC;
    }

    /* JADX INFO: renamed from: p */
    private boolean m1371p() {
        if (isContinuousPagePresentationMode(this.f1739bW)) {
            return false;
        }
        return (this.f1665aA == this.f1667aC && this.f1666aB == this.f1668aD) || this.f1800cf.f1933b;
    }

    /* JADX INFO: renamed from: a */
    private boolean m1251a(int i, boolean z) {
        if (isContinuousPagePresentationMode(this.f1739bW)) {
            return false;
        }
        return z ? i < getPageCount() : i > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public float m1226a(float f) {
        return f * getContext().getResources().getDisplayMetrics().density;
    }

    public int getPageCount() {
        return GetPagesCount(this.f1823dc);
    }

    public int[] getVisiblePages() {
        return GetVisiblePages(this.f1823dc);
    }

    public int[] getVisiblePagesInTransition() {
        int iM1333f;
        if (this.f1800cf.f1933b) {
            int scrollX = (this.f1665aA == this.f1667aC || this.f1817cw) ? getScrollX() : this.f1672aH;
            int scrollY = (this.f1666aB == this.f1668aD || this.f1817cw) ? getScrollY() : this.f1676aL;
            if (m1255a(this.f1739bW)) {
                iM1333f = m1333f(scrollY);
            } else {
                iM1333f = m1333f(scrollX);
            }
            int iM1414d = this.f1800cf.m1414d(iM1333f);
            int iM1419e = this.f1800cf.m1419e(iM1333f);
            ArrayList arrayList = new ArrayList();
            for (Integer num : m1340g(iM1414d)) {
                if (!arrayList.contains(num)) {
                    arrayList.add(num);
                }
            }
            for (Integer num2 : m1340g(iM1333f)) {
                if (!arrayList.contains(num2)) {
                    arrayList.add(num2);
                }
            }
            for (Integer num3 : m1340g(iM1419e)) {
                if (!arrayList.contains(num3)) {
                    arrayList.add(num3);
                }
            }
            int[] iArr = new int[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = ((Integer) it.next()).intValue();
                i++;
            }
            return iArr;
        }
        return GetVisiblePages(this.f1823dc);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m1241a(Canvas canvas, int i, int i2, int i3, int i4, boolean z) throws Throwable {
        int i5;
        int i6;
        int i7;
        boolean z2;
        double[] dArr;
        int i8;
        int i9;
        RectF rectF;
        Bitmap bitmapM1232a;
        Canvas canvas2;
        int i10 = i;
        double[] dArrM1261a = m1261a(i3, i4, i3 + this.f1665aA, this.f1666aB + i4);
        if (dArrM1261a == null) {
            return;
        }
        int length = dArrM1261a.length / 5;
        if (!m1369o()) {
            i5 = 0;
        } else {
            if (m1255a(this.f1739bW)) {
                if (this.f1817cw) {
                    this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
                }
                i6 = this.f1675aK;
                i5 = 0;
                i7 = 0;
                z2 = false;
                while (i7 < length) {
                    int i11 = i7 * 5;
                    int i12 = (int) dArrM1261a[i11];
                    if (z && (bitmapM1232a = m1232a(i12, (rectF = new RectF()))) != null) {
                        float width = bitmapM1232a.getWidth();
                        float height = bitmapM1232a.getHeight();
                        float f = (float) dArrM1261a[i11 + 1];
                        int i13 = i5;
                        float f2 = (float) dArrM1261a[i11 + 2];
                        float f3 = (float) dArrM1261a[i11 + 3];
                        float f4 = (float) dArrM1261a[i11 + 4];
                        float f5 = f3 - f;
                        float f6 = f4 - f2;
                        canvas.save();
                        float f7 = i13;
                        float f8 = f + f7;
                        dArr = dArrM1261a;
                        float f9 = i6;
                        float f10 = f2 + f9;
                        float f11 = f3 + f7;
                        try {
                            i8 = length;
                            i9 = i13;
                            canvas2 = canvas;
                        } catch (Throwable th) {
                            th = th;
                            canvas2 = canvas;
                        }
                        try {
                            canvas2.clipRect(f8, f10, f11, f4 + f9, Region.Op.INTERSECT);
                            float f12 = width + rectF.left + rectF.right;
                            float f13 = height + rectF.top + rectF.bottom;
                            float f14 = f5 / f12;
                            float f15 = f - (rectF.left * f14);
                            float f16 = f3 + (rectF.right * f14);
                            float f17 = f6 / f13;
                            float f18 = f2 - (rectF.top * f17);
                            float f19 = f4 + (rectF.bottom * f17);
                            float f20 = f16 - f15;
                            float f21 = f19 - f18;
                            float fMax = Math.max(i10, f15);
                            float fMax2 = Math.max(i2, f18);
                            float fMin = Math.min(i + this.f1665aA, f16);
                            float fMin2 = Math.min(this.f1666aB + i2, f19);
                            this.f1700aj.set(((fMax - f15) / f20) * width, height * ((fMax2 - f18) / f21), ((fMin - f15) / f20) * width, height * ((fMin2 - f18) / f21));
                            this.f1701ak.set(fMax + f7, fMax2 + f9, fMin + f7, fMin2 + f9);
                            this.f1697ag.setRectToRect(this.f1700aj, this.f1701ak, Matrix.ScaleToFit.CENTER);
                            this.f1702al.setFilterBitmap(true);
                            canvas2.drawBitmap(bitmapM1232a, this.f1697ag, this.f1702al);
                            this.f1702al.setFilterBitmap(false);
                            if (f1639a) {
                                canvas2.drawRect(this.f1701ak, this.f1709as);
                            }
                            canvas2.restore();
                        } catch (Throwable th2) {
                            th = th2;
                            canvas2.restore();
                            throw th;
                        }
                    } else {
                        dArr = dArrM1261a;
                        i8 = length;
                        i9 = i5;
                        float f22 = i9;
                        float f23 = ((float) dArr[i11 + 1]) + f22;
                        float f24 = i6;
                        float f25 = ((float) dArr[i11 + 2]) + f24;
                        float f26 = ((float) dArr[i11 + 3]) + f22;
                        float f27 = f24 + ((float) dArr[i11 + 4]);
                        canvas.drawRect(f23, f25, f26, f27, this.f1702al);
                        if (i12 == this.f1774cF.f1977b) {
                            C6957u.m1456a(this.f1774cF, true);
                            C6957u.m1454a(this.f1774cF, f23, f25, f26, f27);
                            z2 = true;
                        }
                    }
                    i7++;
                    i10 = i;
                    length = i8;
                    i5 = i9;
                    dArrM1261a = dArr;
                }
                if (z2) {
                    C6957u.m1456a(this.f1774cF, false);
                    return;
                }
                return;
            }
            if (this.f1817cw) {
                this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
            }
            i5 = this.f1671aG;
        }
        i6 = 0;
        i7 = 0;
        z2 = false;
        while (i7 < length) {
        }
        if (z2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m1244a(PDFDoc pDFDoc, boolean z) throws PDFNetException {
        cancelRendering();
        this.f1849j.lock();
        try {
            this.f1851l.m1524b();
            this.f1852m.m1512c();
            if (!z) {
                try {
                    SetDoc(this.f1823dc, pDFDoc.__GetHandle());
                    this.mDoc = pDFDoc;
                } catch (Exception e) {
                    this.mDoc = null;
                    invalidate();
                    throw new PDFNetException("", 0L, "PDFViewCtrl.java", "setDocHelper", e.getMessage());
                }
            } else {
                this.mDoc = pDFDoc;
            }
            if (this.mDoc == null) {
                throw new PDFNetException("", 0L, "PDFViewCtrl.java", "setDocHelper", "PDFDoc is null");
            }
            closeTool();
            ToolManager toolManager = this.f1736bT;
            if (toolManager != null) {
                this.f1734bR = true;
                toolManager.onControlReady();
            }
            this.f1727bK = true;
            this.f1859t = true;
            this.f1748bf = true;
            requestLayout();
        } finally {
            this.f1849j.unlock();
        }
    }

    /* JADX INFO: renamed from: a */
    private double[] m1261a(double d, double d2, double d3, double d4) {
        return GetPageRects(this.f1823dc, d, d2, d3, d4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public double[] m1332e(int i) {
        return GetPageRectsOnCanvas(this.f1823dc, i);
    }

    public int getCurCanvasId() {
        return GetCurCanvasId(this.f1823dc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public int m1373q() {
        return (int) (GetHScrollPos(this.f1823dc) + 0.5d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r */
    public int m1375r() {
        return (int) (GetVScrollPos(this.f1823dc) + 0.5d);
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m1232a(int i, RectF rectF) {
        ImageCache.C69301 c69301M1509a = this.f1852m.m1509a(i);
        if (c69301M1509a != null) {
            return m1233a(c69301M1509a.f1574a, i, c69301M1509a.f1575b, c69301M1509a.f1576c, rectF);
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:16|(17:(1:(1:21))(1:22)|25|88|26|27|81|28|29|78|30|31|39|53|(2:55|(2:57|(1:59)(1:60))(1:61))(1:62)|92|63|64)(1:23)|24|25|88|26|27|81|28|29|78|30|31|39|53|(0)(0)|92|63|64) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00db, code lost:
    
        r9 = r4;
        r12 = r5;
        r15 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00de, code lost:
    
        r19 = r11;
        r7 = 0.0f;
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e3, code lost:
    
        r9 = r4;
        r12 = r5;
        r15 = r6;
        r7 = 0.0f;
        r8 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c0  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap m1233a(Bitmap bitmap, int i, Rect rect, Rect rect2, RectF rectF) throws Throwable {
        boolean z;
        int i2;
        int i3;
        float f;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        float f2;
        int i9;
        int i10;
        int i11;
        int i12;
        double d;
        if (bitmap == null) {
            return null;
        }
        int pageRotation = getPageRotation();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        try {
            docLockRead();
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    if (z) {
                        docUnlockRead();
                    }
                    throw th;
                }
            } catch (Exception unused) {
                i2 = width;
                i3 = height;
            }
        } catch (Exception unused2) {
            i2 = width;
            i3 = height;
            f = 0.0f;
            z = false;
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        try {
            if (GetPageBox(this.f1823dc) == 1 || rect == null || rect2 == null) {
                i2 = width;
                i3 = height;
                try {
                    rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
                } catch (Exception unused3) {
                    f = 0.0f;
                    z = true;
                    i4 = 0;
                    int i13 = 0;
                    try {
                        rectF.set(f, f, f, f);
                        if (z) {
                        }
                        i5 = i2;
                        i6 = i3;
                        i7 = i4;
                        i8 = i13;
                    } catch (Throwable th3) {
                        th = th3;
                        if (z) {
                        }
                        throw th;
                    }
                }
            } else {
                if (rect.getHeight() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && rect2.getWidth() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    double x1 = (rect2.getX1() - rect.getX1()) / rect.getWidth();
                    double x2 = (rect.getX2() - rect2.getX2()) / rect.getWidth();
                    double y2 = (rect.getY2() - rect2.getY2()) / rect.getHeight();
                    double y1 = (rect2.getY1() - rect.getY1()) / rect.getHeight();
                    int rotation = this.mDoc.getPage(i).getRotation();
                    if (rotation != 1) {
                        if (rotation == 2) {
                            x2 = x1;
                            x1 = x2;
                            y1 = y2;
                            y2 = y1;
                        } else if (rotation == 3) {
                            d = y1;
                            y1 = x1;
                            x1 = y2;
                            y2 = x2;
                        }
                        double d2 = width;
                        double d3 = x1 * d2;
                        double d4 = (1.0d - x2) * d2;
                        double d5 = height;
                        double d6 = y2 * d5;
                        double d7 = (1.0d - y1) * d5;
                        int i14 = (int) d3;
                        int iCeil = (int) Math.ceil(d4);
                        i12 = (int) d6;
                        int iCeil2 = (int) Math.ceil(d7);
                        i2 = width;
                        i3 = height;
                        i4 = i14;
                        rectF.set((float) (d3 - ((double) i14)), (float) (d6 - ((double) i12)), (float) (((double) iCeil) - d4), (float) (((double) iCeil2) - d7));
                        i10 = iCeil2 - i12;
                        i9 = iCeil - i4;
                        i11 = i4;
                        docUnlockRead();
                        i5 = i9;
                        i6 = i10;
                        i7 = i11;
                        i8 = i12;
                        f = 0.0f;
                        if (pageRotation != 1) {
                            float f3 = rectF.left;
                            rectF.left = rectF.bottom;
                            rectF.bottom = rectF.right;
                            rectF.right = rectF.top;
                            rectF.top = f3;
                            f2 = 90.0f;
                        } else if (pageRotation == 2) {
                            float f4 = rectF.left;
                            rectF.left = rectF.right;
                            rectF.right = f4;
                            float f5 = rectF.top;
                            rectF.top = rectF.bottom;
                            rectF.bottom = f5;
                            f2 = 180.0f;
                        } else if (pageRotation != 3) {
                            f2 = f;
                        } else {
                            float f6 = rectF.left;
                            rectF.left = rectF.top;
                            rectF.top = rectF.right;
                            rectF.right = rectF.bottom;
                            rectF.bottom = f6;
                            f2 = 270.0f;
                        }
                        Matrix matrix = new Matrix();
                        matrix.postRotate(f2);
                        return Bitmap.createBitmap(bitmap, i7, i8, i5, i6, matrix, true);
                    }
                    d = y2;
                    y2 = x1;
                    x1 = y1;
                    y1 = x2;
                    x2 = d;
                    double d22 = width;
                    double d32 = x1 * d22;
                    double d42 = (1.0d - x2) * d22;
                    double d52 = height;
                    double d62 = y2 * d52;
                    double d72 = (1.0d - y1) * d52;
                    int i142 = (int) d32;
                    int iCeil3 = (int) Math.ceil(d42);
                    i12 = (int) d62;
                    int iCeil22 = (int) Math.ceil(d72);
                    i2 = width;
                    i3 = height;
                    i4 = i142;
                    rectF.set((float) (d32 - ((double) i142)), (float) (d62 - ((double) i12)), (float) (((double) iCeil3) - d42), (float) (((double) iCeil22) - d72));
                    i10 = iCeil22 - i12;
                    i9 = iCeil3 - i4;
                    i11 = i4;
                    docUnlockRead();
                    i5 = i9;
                    i6 = i10;
                    i7 = i11;
                    i8 = i12;
                    f = 0.0f;
                    if (pageRotation != 1) {
                    }
                    Matrix matrix2 = new Matrix();
                    matrix2.postRotate(f2);
                    return Bitmap.createBitmap(bitmap, i7, i8, i5, i6, matrix2, true);
                }
                i2 = width;
                i3 = height;
                f = 0.0f;
                z = true;
                i4 = 0;
                int i132 = 0;
                rectF.set(f, f, f, f);
                if (z) {
                    docUnlockRead();
                }
                i5 = i2;
                i6 = i3;
                i7 = i4;
                i8 = i132;
                if (pageRotation != 1) {
                }
                Matrix matrix22 = new Matrix();
                matrix22.postRotate(f2);
                return Bitmap.createBitmap(bitmap, i7, i8, i5, i6, matrix22, true);
            }
            Matrix matrix222 = new Matrix();
            matrix222.postRotate(f2);
            return Bitmap.createBitmap(bitmap, i7, i8, i5, i6, matrix222, true);
        } catch (Exception unused4) {
            return bitmap;
        } catch (OutOfMemoryError unused5) {
            if (f1640b) {
                m1239a(4, "Rotate thumbnail for page " + i + " ran out of memory", m1230a(true));
            } else {
                Log.e("PDFNet", "Rotate thumbnail for page " + i + " ran out of memory");
            }
            this.f1829di.m1452a();
            return bitmap;
        }
        i9 = i2;
        i10 = i3;
        i11 = 0;
        i12 = 0;
        docUnlockRead();
        i5 = i9;
        i6 = i10;
        i7 = i11;
        i8 = i12;
        f = 0.0f;
        if (pageRotation != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public void m1378s() {
        boolean zM1255a = m1255a(this.f1739bW);
        PagePresentationMode pagePresentationMode = getPagePresentationMode();
        int pageCount = getPageCount();
        int i = 0;
        if (this.f1817cw) {
            if (m1335f()) {
                return;
            }
            int i2 = pageCount + 1;
            if (pagePresentationMode == PagePresentationMode.FACING || pagePresentationMode == PagePresentationMode.FACING_VERT) {
                i2 = !m1351i(i2) ? pageCount + 2 : pageCount + 3;
            } else if (pagePresentationMode == PagePresentationMode.FACING_COVER || pagePresentationMode == PagePresentationMode.FACING_COVER_VERT) {
                i2 = m1351i(i2) ? pageCount + 2 : pageCount + 3;
                i = -1;
            }
            if (zM1255a) {
                this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
                this.f1673aI = getScrollOffsetForCanvasId(i2);
                return;
            } else {
                this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
                this.f1669aE = !this.f1805ck ? getScrollOffsetForCanvasId(i2) : getScrollOffsetForCanvasId(i);
                return;
            }
        }
        if (zM1255a) {
            if (this.f1666aB != this.f1668aD) {
                this.f1673aI = 0;
                this.f1675aK = 0;
                return;
            }
        } else if (this.f1665aA != this.f1667aC) {
            this.f1669aE = 0;
            this.f1671aG = 0;
            return;
        }
        if (pagePresentationMode != PagePresentationMode.SINGLE) {
            if (pagePresentationMode != PagePresentationMode.FACING) {
                if (pagePresentationMode != PagePresentationMode.FACING_COVER) {
                    if (pagePresentationMode != PagePresentationMode.SINGLE_VERT) {
                        if (pagePresentationMode != PagePresentationMode.FACING_VERT) {
                            if (pagePresentationMode == PagePresentationMode.FACING_COVER_VERT) {
                                double d = ((double) (pageCount + 1)) / 2.0d;
                                this.f1673aI = (int) ((this.f1666aB * ((int) Math.ceil(d))) + (this.f1800cf.f1942k * ((int) (Math.ceil(d) - 1.0d))));
                                this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
                            }
                        } else {
                            double d2 = ((double) pageCount) / 2.0d;
                            this.f1673aI = (int) ((this.f1666aB * ((int) Math.ceil(d2))) + (this.f1800cf.f1942k * ((int) (Math.ceil(d2) - 1.0d))));
                            this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
                        }
                    } else {
                        this.f1673aI = (int) ((this.f1666aB * pageCount) + (this.f1800cf.f1942k * (pageCount - 1)));
                        this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
                    }
                } else {
                    double d3 = ((double) (pageCount + 1)) / 2.0d;
                    this.f1669aE = (int) ((this.f1665aA * ((int) Math.ceil(d3))) + (this.f1800cf.f1942k * ((int) (Math.ceil(d3) - 1.0d))));
                    this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
                }
            } else {
                double d4 = ((double) pageCount) / 2.0d;
                this.f1669aE = (int) ((this.f1665aA * ((int) Math.ceil(d4))) + (this.f1800cf.f1942k * ((int) (Math.ceil(d4) - 1.0d))));
                this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
            }
        } else {
            this.f1669aE = (int) ((this.f1665aA * pageCount) + (this.f1800cf.f1942k * (pageCount - 1)));
            this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
        }
        if (zM1255a) {
            this.f1674aJ = this.f1673aI;
            this.f1676aL = this.f1675aK;
        } else {
            this.f1670aF = this.f1669aE;
            this.f1672aH = this.f1671aG;
        }
    }

    /* JADX INFO: renamed from: a */
    private int m1231a(double[] dArr) {
        boolean z;
        if (dArr == null || dArr.length < 5) {
            return 0;
        }
        return (dArr.length <= 5 || (((z = this.f1805ck) || dArr[3] >= dArr[8]) && (!z || dArr[3] <= dArr[8]))) ? (int) dArr[4] : (int) dArr[9];
    }

    /* JADX INFO: renamed from: b */
    private static int m1302b(double[] dArr) {
        if (dArr == null || dArr.length < 5) {
            return 0;
        }
        return (dArr.length <= 5 || dArr[2] >= dArr[7]) ? (int) dArr[3] : (int) dArr[8];
    }

    public boolean turnPageInNonContinuousMode(int i, boolean z) {
        if (isContinuousPagePresentationMode(this.f1739bW)) {
            return false;
        }
        if (m1255a(this.f1739bW)) {
            if (this.f1666aB == this.f1668aD) {
                if (z) {
                    if (i < getPageCount()) {
                        gotoNextPage();
                        return true;
                    }
                } else if (i > 1) {
                    gotoPreviousPage();
                    return true;
                }
                return false;
            }
            if (i > 0) {
                if (this.f1817cw) {
                    this.f1675aK = getScrollOffsetForCanvasId(getCurCanvasId());
                }
                int scrollY = getScrollY() - this.f1675aK;
                if (z) {
                    if (scrollY + getHeight() >= this.f1668aD - 1.0f) {
                        if (i < getPageCount()) {
                            this.f1800cf.m1448a().m1395a(this.f1800cf.m1419e(getCurCanvasId()), 0);
                        }
                        return true;
                    }
                } else if (scrollY <= 1.0f) {
                    if (i > 1) {
                        this.f1800cf.m1448a();
                        this.f1800cf.m1448a().m1395a(this.f1800cf.m1414d(getCurCanvasId()), 0);
                    }
                    return true;
                }
            }
        } else {
            if (this.f1665aA == this.f1667aC) {
                if (z) {
                    if (i < getPageCount()) {
                        gotoNextPage();
                        return true;
                    }
                } else if (i > 1) {
                    gotoPreviousPage();
                    return true;
                }
                return false;
            }
            if (i > 0) {
                if (this.f1817cw) {
                    this.f1671aG = getScrollOffsetForCanvasId(getCurCanvasId());
                }
                int scrollX = getScrollX() - this.f1671aG;
                if (z) {
                    if (scrollX + getWidth() >= this.f1667aC - 1.0f) {
                        if (i < getPageCount()) {
                            if (!this.f1805ck) {
                                this.f1800cf.m1448a().m1395a(this.f1800cf.m1419e(getCurCanvasId()), 0);
                            } else {
                                this.f1800cf.m1448a().m1395a(this.f1800cf.m1414d(getCurCanvasId()), 0);
                            }
                        }
                        return true;
                    }
                } else if (scrollX <= 1.0f) {
                    if (i > 1) {
                        this.f1800cf.m1448a();
                        if (!this.f1805ck) {
                            this.f1800cf.m1448a().m1395a(this.f1800cf.m1414d(getCurCanvasId()), 0);
                        } else {
                            this.f1800cf.m1448a().m1395a(this.f1800cf.m1419e(getCurCanvasId()), 0);
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int getScrollOffsetForCanvasId(int i) {
        int i2;
        int i3;
        PagePresentationMode pagePresentationMode = getPagePresentationMode();
        boolean zM1255a = m1255a(pagePresentationMode);
        boolean z = !zM1255a && this.f1805ck;
        int pageCount = getPageCount();
        if (this.f1817cw) {
            int i4 = (((pagePresentationMode == PagePresentationMode.FACING_COVER || pagePresentationMode == PagePresentationMode.FACING_COVER_VERT) && m1351i(pageCount)) || ((pagePresentationMode == PagePresentationMode.FACING || pagePresentationMode == PagePresentationMode.FACING_VERT) && !m1351i(pageCount))) ? pageCount + 1 : pageCount;
            int i5 = (pagePresentationMode == PagePresentationMode.SINGLE || pagePresentationMode == PagePresentationMode.SINGLE_VERT) ? 1 : 2;
            if (!m1335f() && !this.f1794cZ) {
                int i6 = (int) this.f1800cf.f1942k;
                long[] allCanvasPixelSizes = getAllCanvasPixelSizes();
                if (allCanvasPixelSizes == null || allCanvasPixelSizes.length == 0) {
                    return 0;
                }
                int[] iArr = new int[pageCount + 2];
                this.f1821da = iArr;
                iArr[0] = 0;
                int i7 = (pagePresentationMode == PagePresentationMode.FACING || pagePresentationMode == PagePresentationMode.FACING_VERT) ? 2 : 1;
                int length = !z ? 1 : allCanvasPixelSizes.length - 2;
                int i8 = !z ? 3 : -3;
                int i9 = 0;
                while (i7 <= i4) {
                    int[] iArr2 = this.f1821da;
                    i9 += ((int) allCanvasPixelSizes[length]) + i6;
                    iArr2[i7] = i9;
                    i7 += i5;
                    length += i8;
                }
                this.f1794cZ = true;
            }
            int[] iArr3 = this.f1821da;
            if (iArr3 == null || iArr3.length == 0) {
                return 0;
            }
            if (z) {
                if (pagePresentationMode == PagePresentationMode.FACING_COVER) {
                    i4--;
                }
                int[] iArr4 = this.f1821da;
                return iArr4[Math.min(iArr4.length - 1, Math.max(0, i4 - i))];
            }
            return iArr3[Math.min(iArr3.length - 1, Math.max(0, i - i5))];
        }
        if (z) {
            if (getPagePresentationMode() == PagePresentationMode.FACING) {
                if (!m1351i(pageCount)) {
                    pageCount++;
                }
                i3 = 2;
            } else {
                if (getPagePresentationMode() == PagePresentationMode.FACING_COVER && m1351i(pageCount)) {
                    pageCount++;
                }
                i3 = 1;
            }
            i2 = i3 + (pageCount - i);
        } else {
            i2 = i;
        }
        if (pagePresentationMode != PagePresentationMode.SINGLE && pagePresentationMode != PagePresentationMode.SINGLE_VERT) {
            if (pagePresentationMode != PagePresentationMode.FACING && pagePresentationMode != PagePresentationMode.FACING_VERT) {
                if (pagePresentationMode != PagePresentationMode.FACING_COVER && pagePresentationMode != PagePresentationMode.FACING_COVER_VERT) {
                    return 0;
                }
                return (int) (((zM1255a ? this.f1666aB : this.f1665aA) * r5) + (this.f1800cf.f1942k * (((i2 + 1) / 2) - 1)));
            }
            return (int) (((zM1255a ? this.f1666aB : this.f1665aA) * r5) + (this.f1800cf.f1942k * ((i2 / 2) - 1)));
        }
        return (int) (((zM1255a ? this.f1666aB : this.f1665aA) * r5) + (this.f1800cf.f1942k * (i2 - 1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: t */
    public int m1379t() {
        return m1333f(((this.f1665aA == this.f1667aC || this.f1817cw) ? getScrollX() : this.f1672aH) + (this.f1665aA / 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: u */
    public int m1381u() {
        return m1333f(((this.f1666aB == this.f1668aD || this.f1817cw) ? getScrollY() : this.f1676aL) + (this.f1666aB / 2));
    }

    /* JADX INFO: renamed from: f */
    private int m1333f(int i) {
        float f;
        float f2;
        float f3;
        int i2;
        int i3;
        int i4;
        int i5;
        PagePresentationMode pagePresentationMode = getPagePresentationMode();
        boolean zM1255a = m1255a(pagePresentationMode);
        int i6 = 1;
        boolean z = !zM1255a && this.f1805ck;
        int pageCount = getPageCount();
        if (this.f1817cw) {
            if (pagePresentationMode == PagePresentationMode.FACING || pagePresentationMode == PagePresentationMode.FACING_VERT) {
                i2 = pageCount + 1;
                int i7 = i2 / 2;
                if (m1351i(pageCount)) {
                    pageCount = i7;
                    i5 = 1;
                    i3 = 2;
                    i4 = 2;
                } else {
                    i2 = pageCount;
                    i3 = 2;
                    i4 = 2;
                    pageCount = i7;
                    i5 = 1;
                }
            } else if (pagePresentationMode == PagePresentationMode.FACING_COVER || pagePresentationMode == PagePresentationMode.FACING_COVER_VERT) {
                int i8 = (pageCount + 2) / 2;
                if (m1351i(pageCount)) {
                    pageCount++;
                }
                int i9 = pageCount;
                pageCount = i8;
                i2 = i9;
                i5 = 1;
                i4 = 1;
                i3 = 2;
            } else {
                i5 = 1;
                i3 = 1;
                i4 = 1;
                i2 = pageCount;
            }
            while (i5 != pageCount) {
                int i10 = (i5 + pageCount) / 2;
                int i11 = (i3 * i10) + i4;
                if (z) {
                    i11 = (i2 - i11) + 1;
                }
                if (getScrollOffsetForCanvasId(i11) <= i) {
                    i5 = i10 + 1;
                } else {
                    pageCount = i10;
                }
            }
            int i12 = (i5 * i3) - ((i3 - 1) * (2 - i4));
            return z ? (i2 - i12) + 1 : i12;
        }
        float f4 = i + 0.5f;
        int curCanvasId = getCurCanvasId();
        if (pagePresentationMode == PagePresentationMode.SINGLE || pagePresentationMode == PagePresentationMode.SINGLE_VERT) {
            if (zM1255a) {
                f = this.f1666aB;
            } else {
                f = this.f1665aA + this.f1800cf.f1942k;
            }
            curCanvasId = Math.max(1, Math.min(((int) (f4 / f)) + 1, getPageCount()));
        } else if (pagePresentationMode == PagePresentationMode.FACING || pagePresentationMode == PagePresentationMode.FACING_VERT) {
            int pageCount2 = m1351i(getPageCount()) ? getPageCount() : getPageCount() + 1;
            if (zM1255a) {
                f2 = this.f1666aB;
            } else {
                f2 = this.f1665aA + this.f1800cf.f1942k;
            }
            curCanvasId = Math.max(2, Math.min((((int) (f4 / f2)) + 1) << 1, pageCount2));
        } else if (pagePresentationMode == PagePresentationMode.FACING_COVER || pagePresentationMode == PagePresentationMode.FACING_COVER_VERT) {
            int pageCount3 = m1351i(getPageCount()) ? getPageCount() + 1 : getPageCount();
            if (zM1255a) {
                f3 = this.f1666aB;
            } else {
                f3 = this.f1665aA + this.f1800cf.f1942k;
            }
            curCanvasId = Math.max(1, Math.min(((((int) (f4 / f3)) + 1) << 1) - 1, pageCount3));
        }
        if (!z) {
            return curCanvasId;
        }
        int pageCount4 = getPageCount();
        if (getPagePresentationMode() == PagePresentationMode.FACING) {
            if (!m1351i(pageCount4)) {
                pageCount4++;
            }
            i6 = 2;
        } else if (getPagePresentationMode() == PagePresentationMode.FACING_COVER && m1351i(pageCount4)) {
            pageCount4++;
        }
        return (pageCount4 - curCanvasId) + i6;
    }

    public int getScrollXOffsetInTools(int i) {
        if (!this.f1817cw || !this.f1800cf.f1933b) {
            return 0;
        }
        int i2 = this.f1800cf.f1957z;
        return i2 == m1343h(i) ? this.f1800cf.f1924H : this.f1800cf.f1924H - getScrollOffsetForCanvasId(i2);
    }

    public int getScrollYOffsetInTools(int i) {
        double[] dArr;
        int i2;
        int iMax = 0;
        if (this.f1817cw && this.f1800cf.f1933b) {
            int i3 = this.f1800cf.f1957z;
            int iM1343h = m1343h(i);
            if (iM1343h == i3) {
                iMax = this.f1800cf.f1925I;
            } else if (iM1343h < i3 && (dArr = this.f1776cH.get(iM1343h)) != null) {
                iMax = Math.max(0, m1231a(dArr) - this.f1666aB);
            }
            if (iM1343h != i3 && (i2 = this.f1819cy.get(iM1343h, Integer.MIN_VALUE)) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return iMax;
    }

    public boolean isCurrentSlidingCanvas(int i) {
        return this.f1800cf.f1957z == m1343h(i);
    }

    public int getSlidingScrollX() {
        if (this.f1800cf.f1933b) {
            return this.f1800cf.f1924H;
        }
        return 0;
    }

    public int getSlidingScrollY() {
        if (this.f1800cf.f1933b) {
            return this.f1800cf.f1925I;
        }
        return 0;
    }

    /* JADX INFO: renamed from: g */
    private ArrayList<Integer> m1340g(int i) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (getPagePresentationMode() == PagePresentationMode.SINGLE || getPagePresentationMode() == PagePresentationMode.SINGLE_VERT) {
            arrayList.add(Integer.valueOf(Math.max(1, Math.min(i, getPageCount()))));
            return arrayList;
        }
        if (getPagePresentationMode() == PagePresentationMode.FACING || getPagePresentationMode() == PagePresentationMode.FACING_COVER || getPagePresentationMode() == PagePresentationMode.FACING_VERT || getPagePresentationMode() == PagePresentationMode.FACING_COVER_VERT) {
            int iMax = Math.max(1, Math.min(i, getPageCount()));
            arrayList.add(Integer.valueOf(iMax));
            int iMax2 = Math.max(1, Math.min(i - 1, getPageCount()));
            if (iMax2 != iMax) {
                arrayList.add(0, Integer.valueOf(iMax2));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: h */
    private int m1343h(int i) {
        PagePresentationMode pagePresentationMode = getPagePresentationMode();
        return (pagePresentationMode == PagePresentationMode.FACING || pagePresentationMode == PagePresentationMode.FACING_VERT) ? !m1351i(i) ? i + 1 : i : ((pagePresentationMode == PagePresentationMode.FACING_COVER || pagePresentationMode == PagePresentationMode.FACING_COVER_VERT) && m1351i(i)) ? i + 1 : i;
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$u */
    static class C6957u {

        /* JADX INFO: renamed from: c */
        private final WeakReference<PDFViewCtrl> f1978c;

        /* JADX INFO: renamed from: h */
        private Rect f1983h;

        /* JADX INFO: renamed from: a */
        DocumentConversion f1976a = null;

        /* JADX INFO: renamed from: b */
        int f1977b = -1;

        /* JADX INFO: renamed from: e */
        private Handler f1980e = new Handler();

        /* JADX INFO: renamed from: f */
        private long f1981f = 0;

        /* JADX INFO: renamed from: g */
        private boolean f1982g = false;

        /* JADX INFO: renamed from: i */
        private boolean f1984i = false;

        /* JADX INFO: renamed from: j */
        private boolean f1985j = false;

        /* JADX INFO: renamed from: d */
        private Queue<a> f1979d = new LinkedList();

        /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$u$a */
        static class a {

            /* JADX INFO: renamed from: a */
            long f1987a;

            /* JADX INFO: renamed from: b */
            int f1988b;

            /* JADX INFO: renamed from: c */
            int f1989c;

            a(long j, int i, int i2, String str) {
                this.f1987a = j;
                this.f1988b = i;
                this.f1989c = i2;
            }
        }

        C6957u(PDFViewCtrl pDFViewCtrl) {
            this.f1978c = new WeakReference<>(pDFViewCtrl);
            try {
                this.f1983h = new Rect();
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: renamed from: a */
        final void m1460a() {
            m1465d();
            this.f1977b = -1;
            this.f1984i = false;
            this.f1976a = null;
            this.f1979d.clear();
            this.f1981f = 0L;
            this.f1985j = false;
            this.f1980e.removeCallbacksAndMessages(null);
        }

        /* JADX INFO: renamed from: a */
        final void m1461a(long j, int i, int i2, String str) {
            this.f1979d.add(new a(j, i, i2, str));
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
        /* JADX INFO: renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        final void m1463b() throws Throwable {
            PDFViewCtrl pDFViewCtrl;
            boolean zDocTryLockRead;
            boolean z;
            if (this.f1979d.size() <= 0 || (pDFViewCtrl = this.f1978c.get()) == null) {
                return;
            }
            boolean z2 = false;
            try {
                zDocTryLockRead = pDFViewCtrl.docTryLockRead(50);
                if (zDocTryLockRead) {
                    int i = 0;
                    while (this.f1979d.size() > 0) {
                        try {
                            if (i >= 100 && pDFViewCtrl.f1774cF.f1976a == null) {
                                z = true;
                                break;
                            } else {
                                a aVarRemove = this.f1979d.remove();
                                pDFViewCtrl.m1252a(aVarRemove.f1987a, aVarRemove.f1988b, aVarRemove.f1989c);
                                i++;
                            }
                        } catch (PDFNetException unused) {
                            if (zDocTryLockRead) {
                                pDFViewCtrl.docUnlockRead();
                            }
                            z = false;
                        } catch (Throwable th) {
                            th = th;
                            z2 = zDocTryLockRead;
                            if (z2) {
                                pDFViewCtrl.docUnlockRead();
                            }
                            throw th;
                        }
                    }
                    z = false;
                    if (zDocTryLockRead) {
                        pDFViewCtrl.docUnlockRead();
                    }
                } else {
                    z = false;
                    if (zDocTryLockRead) {
                    }
                }
            } catch (PDFNetException unused2) {
                zDocTryLockRead = false;
            } catch (Throwable th2) {
                th = th2;
            }
            if (z) {
                this.f1980e.postDelayed(new Runnable() { // from class: com.pdftron.pdf.PDFViewCtrl.u.1
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        PDFViewCtrl pDFViewCtrl2 = (PDFViewCtrl) C6957u.this.f1978c.get();
                        if (pDFViewCtrl2 == null || pDFViewCtrl2.f1800cf.f1933b || pDFViewCtrl2.f1658Q) {
                            return;
                        }
                        C6957u.this.m1463b();
                    }
                }, 50L);
            }
            int pageCount = pDFViewCtrl.getPageCount();
            pDFViewCtrl.f1803ci = pageCount;
            if (pDFViewCtrl.f1720bD != null) {
                Iterator it = pDFViewCtrl.f1720bD.iterator();
                while (it.hasNext()) {
                    ((UniversalDocumentConversionListener) it.next()).onConversionEvent(ConversionState.PROGRESS, pageCount);
                }
            }
            m1462a(false);
            this.f1977b = pageCount + 1;
            PDFViewCtrl.m1346h(pDFViewCtrl);
            if (this.f1979d.size() == 0) {
                m1458e();
            }
            if (pDFViewCtrl.f1828dh.hasMessages(0)) {
                return;
            }
            pDFViewCtrl.f1828dh.sendEmptyMessageDelayed(0, 200L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: e */
        public void m1458e() {
            PDFViewCtrl pDFViewCtrl;
            if (this.f1981f == 0 || (pDFViewCtrl = this.f1978c.get()) == null) {
                return;
            }
            PDFViewCtrl.m1247a(pDFViewCtrl, this.f1981f);
            pDFViewCtrl.f1774cF.m1465d();
            this.f1981f = 0L;
            m1462a(false);
            if (pDFViewCtrl.f1774cF.f1976a == null || pDFViewCtrl.f1720bD == null) {
                return;
            }
            Iterator it = pDFViewCtrl.f1720bD.iterator();
            while (it.hasNext()) {
                ((UniversalDocumentConversionListener) it.next()).onConversionEvent(ConversionState.FINISHED, 0);
            }
        }

        /* JADX INFO: renamed from: c */
        final void m1464c() {
            m1465d();
            try {
                PDFViewCtrl pDFViewCtrl = this.f1978c.get();
                if (pDFViewCtrl == null || !m1459f() || this.f1982g) {
                    return;
                }
                pDFViewCtrl.f1733bQ.onAddProgressIndicator();
                this.f1982g = true;
                pDFViewCtrl.f1733bQ.onProgressIndicatorPageVisibilityChanged(false);
                this.f1984i = false;
            } catch (PDFNetException unused) {
            }
        }

        /* JADX INFO: renamed from: d */
        final void m1465d() {
            PDFViewCtrl pDFViewCtrl = this.f1978c.get();
            if (pDFViewCtrl == null || !this.f1982g || pDFViewCtrl.f1733bQ == null) {
                return;
            }
            pDFViewCtrl.f1733bQ.onRemoveProgressIndicator();
            this.f1982g = false;
            this.f1984i = false;
        }

        /* JADX INFO: renamed from: a */
        final void m1462a(boolean z) {
            PDFViewCtrl pDFViewCtrl = this.f1978c.get();
            if (pDFViewCtrl == null) {
                return;
            }
            try {
                if (m1459f() && z && !this.f1985j) {
                    pDFViewCtrl.f1733bQ.onShowContentPendingIndicator();
                    this.f1985j = true;
                } else {
                    if (z || !this.f1985j || pDFViewCtrl.f1733bQ == null) {
                        return;
                    }
                    pDFViewCtrl.f1733bQ.onRemoveContentPendingIndicator();
                    this.f1985j = false;
                }
            } catch (PDFNetException unused) {
            }
        }

        /* JADX INFO: renamed from: f */
        private boolean m1459f() throws PDFNetException {
            PDFViewCtrl pDFViewCtrl = this.f1978c.get();
            DocumentConversion documentConversion = this.f1976a;
            return (documentConversion == null || documentConversion.getConversionStatus() != 1 || pDFViewCtrl == null || pDFViewCtrl.f1733bQ == null) ? false : true;
        }

        /* JADX INFO: renamed from: a */
        static /* synthetic */ void m1456a(C6957u c6957u, boolean z) {
            PDFViewCtrl pDFViewCtrl;
            try {
                if (c6957u.m1459f() && c6957u.f1982g && z != c6957u.f1984i && (pDFViewCtrl = c6957u.f1978c.get()) != null) {
                    pDFViewCtrl.f1733bQ.onProgressIndicatorPageVisibilityChanged(z);
                    c6957u.f1984i = z;
                }
            } catch (PDFNetException unused) {
            }
        }

        /* JADX INFO: renamed from: a */
        static /* synthetic */ void m1454a(C6957u c6957u, float f, float f2, float f3, float f4) {
            PDFViewCtrl pDFViewCtrl;
            try {
                if (c6957u.m1459f() && c6957u.f1982g && (pDFViewCtrl = c6957u.f1978c.get()) != null) {
                    c6957u.f1983h.set(f, f2, f3, f4);
                    pDFViewCtrl.f1733bQ.onPositionProgressIndicatorPage(c6957u.f1983h);
                }
            } catch (PDFNetException unused) {
            }
        }
    }

    protected static class PrivateDownloader {
        protected PrivateDownloader() {
        }

        protected static void partDownloadRequested(long j, long j2) throws Throwable {
            String message;
            StringBuilder sb;
            byte[] bArr;
            if (j == 0 || j2 == 0) {
                return;
            }
            Boolean bool = Boolean.FALSE;
            String stream = "";
            HttpURLConnection httpURLConnection = null;
            Obj obj__Create = Obj.__Create(j, null);
            Obj obj__Create2 = Obj.__Create(j2, null);
            try {
                try {
                    Obj objFindObj = obj__Create.findObj(ImagesContract.URL);
                    if (objFindObj == null) {
                        try {
                            if ("".length() > 0) {
                                obj__Create2.putNumber(NotificationCompat.CATEGORY_STATUS, 400.0d);
                                obj__Create2.putString("message", "");
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e = e;
                            message = e.getMessage();
                            if (message == null) {
                                return;
                            } else {
                                sb = new StringBuilder();
                            }
                        }
                    } else {
                        String asPDFText = objFindObj.getAsPDFText();
                        String asPDFText2 = obj__Create.findObj(FirebaseAnalytics.Param.METHOD).getAsPDFText();
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(asPDFText).openConnection();
                        try {
                            if (asPDFText2.equalsIgnoreCase(TtmlNode.TAG_HEAD)) {
                                httpURLConnection2.setRequestMethod("HEAD");
                            } else if (asPDFText2.equalsIgnoreCase("get")) {
                                httpURLConnection2.setRequestMethod("GET");
                                bool = Boolean.TRUE;
                            } else if (asPDFText2.equalsIgnoreCase("post")) {
                                httpURLConnection2.setRequestMethod("POST");
                                httpURLConnection2.setDoOutput(true);
                                bool = Boolean.TRUE;
                            } else {
                                obj__Create2.putString("message", "Unsupported HTTP Method called");
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                try {
                                    if ("".length() > 0) {
                                        obj__Create2.putNumber(NotificationCompat.CATEGORY_STATUS, 400.0d);
                                        obj__Create2.putString("message", "");
                                        return;
                                    }
                                    return;
                                } catch (Exception e2) {
                                    e = e2;
                                    message = e.getMessage();
                                    if (message == null) {
                                        return;
                                    } else {
                                        sb = new StringBuilder();
                                    }
                                }
                            }
                            Obj objFindObj2 = obj__Create.findObj("headers");
                            if (objFindObj2 != null) {
                                DictIterator dictIterator = objFindObj2.getDictIterator();
                                while (dictIterator.hasNext()) {
                                    httpURLConnection2.setRequestProperty(dictIterator.key().getName(), dictIterator.value().getAsPDFText());
                                    dictIterator.next();
                                }
                            }
                            Obj objFindObj3 = obj__Create.findObj(TtmlNode.TAG_BODY);
                            if (objFindObj3 != null) {
                                byte[] buffer = objFindObj3.getBuffer();
                                httpURLConnection2.setFixedLengthStreamingMode(buffer.length);
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection2.getOutputStream());
                                try {
                                    bufferedOutputStream.write(buffer);
                                    bufferedOutputStream.flush();
                                    bufferedOutputStream.close();
                                } finally {
                                }
                            }
                            int responseCode = httpURLConnection2.getResponseCode();
                            obj__Create2.putNumber(NotificationCompat.CATEGORY_STATUS, responseCode);
                            Obj objPutDict = obj__Create2.putDict("headers");
                            Iterator<Map.Entry<String, List<String>>> it = httpURLConnection2.getHeaderFields().entrySet().iterator();
                            while (it.hasNext()) {
                                String key = it.next().getKey();
                                objPutDict.putString(key, httpURLConnection2.getHeaderField(key));
                            }
                            if (bool.booleanValue() && (responseCode == 200 || responseCode == 206)) {
                                int contentLength = httpURLConnection2.getContentLength();
                                if (contentLength > 0) {
                                    bArr = new byte[contentLength];
                                    DataInputStream dataInputStream = new DataInputStream(httpURLConnection2.getInputStream());
                                    try {
                                        dataInputStream.readFully(bArr);
                                        dataInputStream.close();
                                    } finally {
                                    }
                                } else {
                                    InputStream inputStream = httpURLConnection2.getInputStream();
                                    try {
                                        byte[] bArrM1260a = PDFViewCtrl.m1260a(inputStream);
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        bArr = bArrM1260a;
                                    } finally {
                                    }
                                }
                                if (bArr != null) {
                                    obj__Create2.putString("response_body", bArr);
                                    obj__Create2.putNumber("response_length", bArr.length);
                                }
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            try {
                                if ("".length() > 0) {
                                    obj__Create2.putNumber(NotificationCompat.CATEGORY_STATUS, 400.0d);
                                    obj__Create2.putString("message", "");
                                    return;
                                }
                                return;
                            } catch (Exception e3) {
                                e = e3;
                                message = e.getMessage();
                                if (message == null) {
                                    return;
                                } else {
                                    sb = new StringBuilder();
                                }
                            }
                        } catch (IOException unused) {
                            httpURLConnection = httpURLConnection2;
                            if (httpURLConnection != null) {
                                stream = PDFViewCtrl.readStream(httpURLConnection.getErrorStream());
                                Log.e("PDFNet", stream);
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (stream == null) {
                                return;
                            }
                            try {
                                if (stream.length() > 0) {
                                    obj__Create2.putNumber(NotificationCompat.CATEGORY_STATUS, 400.0d);
                                    obj__Create2.putString("message", stream);
                                    return;
                                }
                                return;
                            } catch (Exception e4) {
                                e = e4;
                                message = e.getMessage();
                                if (message == null) {
                                    return;
                                } else {
                                    sb = new StringBuilder();
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            httpURLConnection = httpURLConnection2;
                            String message2 = e.getMessage();
                            if (message2 != null) {
                                Log.e("PDFNet", message2);
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (message2 == null) {
                                return;
                            }
                            try {
                                if (message2.length() > 0) {
                                    obj__Create2.putNumber(NotificationCompat.CATEGORY_STATUS, 400.0d);
                                    obj__Create2.putString("message", message2);
                                    return;
                                }
                                return;
                            } catch (Exception e6) {
                                e = e6;
                                message = e.getMessage();
                                if (message == null) {
                                    return;
                                } else {
                                    sb = new StringBuilder();
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection = httpURLConnection2;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if ("" != 0) {
                                try {
                                    if ("".length() > 0) {
                                        obj__Create2.putNumber(NotificationCompat.CATEGORY_STATUS, 400.0d);
                                        obj__Create2.putString("message", "");
                                    }
                                } catch (Exception e7) {
                                    String message3 = e7.getMessage();
                                    if (message3 != null) {
                                        Log.e("PDFNet", e7.getMessage() + "\n" + message3);
                                    }
                                }
                            }
                            throw th;
                        }
                    }
                    Log.e("PDFNet", sb.append(e.getMessage()).append("\n").append(message).toString());
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused2) {
            } catch (Exception e8) {
                e = e8;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readStream(InputStream inputStream) throws Throwable {
        BufferedReader bufferedReader;
        IOException e;
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                        } else {
                            try {
                                break;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    try {
                        inputStream.close();
                        throw th;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        throw th;
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e7) {
            bufferedReader = null;
            e = e7;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            inputStream.close();
            throw th;
        }
        try {
            inputStream.close();
        } catch (IOException e8) {
            e8.printStackTrace();
        }
        return sb.toString();
    }

    class RenderCallback {
        private static final int ANNOT_OPERATION_ANNOT_RENDERS_COMPLETE = 131;
        private static final int ANNOT_OPERATION_CLEAR_ALL_ANNOT_BITMAPS = 130;
        private static final int ANNOT_OPERATION_MULT_BLEND_ANNOT_BITMAP = 2;
        private static final int ANNOT_OPERATION_MULT_BLEND_ANNOT_VECTOR = 4;
        private static final int ANNOT_OPERATION_NORMAL_ANNOT_BITMAP = 1;
        private static final int ANNOT_OPERATION_NORMAL_ANNOT_VECTOR = 3;
        private static final int ANNOT_OPERATION_REINDEX_ANNOT_BITMAP = 132;
        private static final int ANNOT_OPERATION_REMOVE_ANNOT_BITMAP = 129;
        private static final int ANNOT_OPERATION_RESIZE_ANNOT_BITMAP = 128;
        private static final int TILE_TYPE_FINAL_RENDER = 0;
        private static final int TILE_TYPE_LOW_RES_PREVIEW = 3;
        private static final int TILE_TYPE_OFFSCREEN_RENDER = 2;
        private static final int TILE_TYPE_PROGRESSIVE_RENDER = 1;

        private void CreateTileProc(PDFViewCtrl pDFViewCtrl, int[] iArr, int i, int i2, int i3, int i4, int i5, long j, boolean z, boolean z2, int i6, boolean z3, int i7, int i8, int i9, int i10, int i11, int i12) {
        }

        private void OnRequestRenderInWorkerThreadCallback() {
        }

        RenderCallback() {
        }

        private void AnnotBitmapProc(PDFViewCtrl pDFViewCtrl, int i, int[] iArr, int i2, int i3, int i4, int i5, int i6, long j, long j2, long j3, int i7, int i8, int i9, int i10) throws Throwable {
            boolean z;
            Bitmap bitmapCreateBitmap;
            RenderCallback renderCallback;
            String str;
            int i11;
            boolean z2;
            String str2;
            String str3;
            Bitmap bitmap;
            CurvePainter curvePainter;
            String str4;
            int i12;
            long j4;
            CurvePainter curvePainter2;
            if (PDFViewCtrl.f1639a) {
                Log.d("annotlayer", "operation: " + i);
                Log.d("annotlayer", String.format("w: %d, h: %d, pg: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5)));
                Log.d("annotlayer", String.format("annot_index %d, key %d, x: %d, y: %d, xOff: %d, yOff: %d", Integer.valueOf(i6), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i7), Integer.valueOf(i8)));
            }
            if (i == 128) {
                if (PDFViewCtrl.this.f1851l.m1522a(i10)) {
                    PDFViewCtrl.this.f1849j.lock();
                    try {
                        PDFViewCtrl.this.f1851l.m1520a(j, i5, i7, i8, (int) j2, (int) j3, i2, i3);
                    } catch (Exception e) {
                        if (PDFViewCtrl.f1639a) {
                            e.printStackTrace();
                        }
                    } finally {
                    }
                }
            } else {
                if (i != 132) {
                    if (i == 129) {
                        removeTileProc(-1, j, i5, i10, 1);
                        return;
                    }
                    if (i == 130) {
                        removeTileProc(-1, -1L, -1, i10, 1);
                        return;
                    }
                    if (i == 131) {
                        PDFViewCtrl.this.f1828dh.sendEmptyMessage(0);
                        PDFViewCtrl.this.postInvalidate();
                        return;
                    }
                    if (!PDFViewCtrl.this.f1643A) {
                        if (!PDFViewCtrl.this.m1335f() || i5 < PDFViewCtrl.this.f1855p || i5 > PDFViewCtrl.this.f1856q) {
                            if (iArr != null && iArr.length != 0) {
                                if (i == 1 || i == 2) {
                                    Bitmap bitmapM1161a = ImageCache.m1160a().m1161a(i2, i3);
                                    if (bitmapM1161a == null) {
                                        try {
                                            z = false;
                                            bitmapCreateBitmap = Bitmap.createBitmap(iArr, i2, i3, Bitmap.Config.ARGB_8888);
                                            renderCallback = this;
                                            str = "PDFNet";
                                            i11 = i3;
                                            z2 = true;
                                            str2 = "annotlayer";
                                        } catch (OutOfMemoryError unused) {
                                            if (PDFViewCtrl.f1640b) {
                                                PDFViewCtrl.m1239a(4, "Can't create bitmap due to out of memory:" + i6, PDFViewCtrl.m1230a(false));
                                            } else {
                                                Log.e("PDFNet", "Can't create bitmap due to out of memory:" + i6);
                                            }
                                            PDFViewCtrl.this.f1829di.m1452a();
                                            return;
                                        }
                                    } else {
                                        bitmapCreateBitmap = bitmapM1161a;
                                        renderCallback = this;
                                        z = false;
                                        str = "PDFNet";
                                        i11 = i3;
                                        z2 = true;
                                        str2 = "annotlayer";
                                        bitmapCreateBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i11);
                                    }
                                    CurvePainter curvePainter3 = new CurvePainter(bitmapCreateBitmap);
                                    str3 = str;
                                    curvePainter3.setRect(new android.graphics.Rect((int) (((double) i7) + 0.5d), (int) (((double) i8) + 0.5d), (int) (((double) (i7 + i2)) + 0.5d), (int) (((double) (i8 + i11)) + 0.5d)));
                                    bitmap = bitmapCreateBitmap;
                                    curvePainter = curvePainter3;
                                } else {
                                    curvePainter = null;
                                    if (i == 3 || i == 4) {
                                        CurvePainter curvePainter4 = new CurvePainter(iArr);
                                        curvePainter4.setMultBlend(i == 4);
                                        curvePainter4.setRect(new android.graphics.Rect((int) j2, (int) j3, (int) (((long) i7) + j2), (int) (j3 + ((long) i8))));
                                        str2 = "annotlayer";
                                        i11 = i3;
                                        z = false;
                                        renderCallback = this;
                                        str3 = "PDFNet";
                                        bitmap = null;
                                        z2 = true;
                                        curvePainter = curvePainter4;
                                    } else {
                                        str2 = "annotlayer";
                                        i11 = i3;
                                        z = false;
                                        renderCallback = this;
                                        z2 = true;
                                        str3 = "PDFNet";
                                        bitmap = null;
                                    }
                                }
                                PDFViewCtrl.this.f1849j.lock();
                                if (PDFViewCtrl.f1639a) {
                                    Log.i(str2, String.format("Got tile: page %d - index %d - sequence %d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i10)));
                                }
                                try {
                                    try {
                                        Log.d(str2, "addTile core w: " + i2 + " h:" + i11);
                                        curvePainter2 = curvePainter;
                                        str4 = str3;
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    i12 = i5;
                                    j4 = j;
                                    curvePainter2 = curvePainter;
                                } catch (OutOfMemoryError unused2) {
                                    str4 = str3;
                                    i12 = i5;
                                    j4 = j;
                                    curvePainter2 = curvePainter;
                                }
                                try {
                                    PDFViewCtrl.this.f1851l.m1516a(j, i5, i7, i8, (int) j2, (int) j3, i2, i11, bitmap, curvePainter2, i10, 1, (i == 2 || i == 4) ? z2 : z, i6);
                                    i12 = i5;
                                    j4 = j;
                                    renderCallback = this;
                                } catch (Exception e3) {
                                    e = e3;
                                    i12 = i5;
                                    j4 = j;
                                    renderCallback = this;
                                    if (PDFViewCtrl.f1639a) {
                                        e.printStackTrace();
                                    }
                                } catch (OutOfMemoryError unused3) {
                                    i12 = i5;
                                    j4 = j;
                                    renderCallback = this;
                                    if (PDFViewCtrl.f1640b) {
                                        PDFViewCtrl.m1239a(4, "Will invoke purge memory when batch of tiles is done", PDFViewCtrl.m1230a(z));
                                    } else {
                                        Log.e(str4, "Will invoke purge memory when batch of tiles is done");
                                    }
                                    PDFViewCtrl.this.f1829di.m1452a();
                                } catch (Throwable th2) {
                                    th = th2;
                                    renderCallback = this;
                                    PDFViewCtrl.this.f1849j.unlock();
                                    throw th;
                                }
                                PDFViewCtrl.this.f1849j.unlock();
                                if (PDFViewCtrl.this.f1736bT != null) {
                                    PDFViewCtrl.this.f1736bT.onAnnotPainterUpdated(i12, j4, CurvePainter.create(curvePainter2));
                                    return;
                                }
                                return;
                            }
                            if (PDFViewCtrl.f1640b) {
                                PDFViewCtrl.m1239a(4, String.format("Null buffer, will invoke purge memory", Integer.valueOf(i6)), PDFViewCtrl.m1230a(false));
                            } else {
                                Log.e("PDFNet", "not enough memory to allocate the bitmap");
                            }
                            PDFViewCtrl.this.f1829di.m1452a();
                            return;
                        }
                        return;
                    }
                    if (PDFViewCtrl.f1640b) {
                        PDFViewCtrl.m1239a(4, String.format("Ignore annotation %d due to out of memory", Integer.valueOf(i6)), PDFViewCtrl.m1230a(false));
                        return;
                    } else {
                        Log.e("PDFNet", String.format("Ignore annotation %d due to out of memory", Integer.valueOf(i6)));
                        return;
                    }
                }
                if (PDFViewCtrl.this.f1851l.m1522a(i10)) {
                    PDFViewCtrl.this.f1849j.lock();
                    try {
                        PDFViewCtrl.this.f1851l.m1519a(j, i5, i2);
                    } catch (Exception e4) {
                        if (PDFViewCtrl.f1639a) {
                            e4.printStackTrace();
                        }
                    } finally {
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:111:0x028d  */
        /* JADX WARN: Removed duplicated region for block: B:115:0x02ad  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x02e2  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0104  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x013d  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0197 A[Catch: all -> 0x01c0, OutOfMemoryError -> 0x01c3, Exception -> 0x01e0, TryCatch #0 {all -> 0x01c0, blocks: (B:61:0x0151, B:63:0x015d, B:64:0x0166, B:66:0x018b, B:76:0x01c3, B:79:0x01c9, B:81:0x01d6, B:80:0x01d1, B:83:0x01e1, B:85:0x01e5, B:70:0x0197, B:72:0x01a9), top: B:132:0x014f }] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01f6  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x01fd  */
        /* JADX WARN: Type inference failed for: r0v30, types: [android.util.SparseArray] */
        /* JADX WARN: Type inference failed for: r0v39, types: [android.util.SparseArray] */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v15 */
        /* JADX WARN: Type inference failed for: r5v16 */
        /* JADX WARN: Type inference failed for: r5v17 */
        /* JADX WARN: Type inference failed for: r5v18 */
        /* JADX WARN: Type inference failed for: r5v19, types: [int] */
        /* JADX WARN: Type inference failed for: r5v26 */
        /* JADX WARN: Type inference failed for: r5v27 */
        /* JADX WARN: Type inference failed for: r5v30 */
        /* JADX WARN: Type inference failed for: r5v42 */
        /* JADX WARN: Type inference failed for: r5v43 */
        /* JADX WARN: Type inference failed for: r5v44 */
        /* JADX WARN: Type inference failed for: r5v45 */
        /* JADX WARN: Type inference failed for: r5v46 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void DeluxeCreateTileProc(PDFViewCtrl pDFViewCtrl, int[] iArr, int i, int i2, int i3, int i4, long j, long j2, int i5, int i6, int i7, int i8, int i9, int i10, int i11) throws Throwable {
            Rect rect;
            boolean z;
            Rect rect2;
            boolean z2;
            String str;
            int i12;
            ActivityManager activityManager;
            int i13 = i5;
            boolean z3 = false;
            if (!PDFViewCtrl.this.f1643A) {
                if (PDFViewCtrl.this.m1335f() && i10 != 3 && i4 >= PDFViewCtrl.this.f1855p && i4 <= PDFViewCtrl.this.f1856q) {
                    return;
                }
                if (iArr == null || iArr.length == 0) {
                    if (PDFViewCtrl.f1640b) {
                        PDFViewCtrl.m1239a(4, String.format("Null buffer, will invoke purge memory", Integer.valueOf(i13)), PDFViewCtrl.m1230a(false));
                    } else {
                        Log.e("PDFNet", "not enough memory to allocate the bitmap");
                    }
                    PDFViewCtrl.this.f1829di.m1452a();
                    return;
                }
                Bitmap bitmapM1161a = ImageCache.m1160a().m1161a(i, i2);
                if (bitmapM1161a == null) {
                    try {
                        bitmapM1161a = Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError unused) {
                        if (PDFViewCtrl.f1640b) {
                            PDFViewCtrl.m1239a(4, "Can't create bitmap due to out of memory:" + i13, PDFViewCtrl.m1230a(false));
                        } else {
                            Log.e("PDFNet", "Can't create bitmap due to out of memory:" + i13);
                        }
                        PDFViewCtrl.this.f1829di.m1452a();
                        return;
                    }
                } else {
                    bitmapM1161a.setPixels(iArr, 0, i, 0, 0, i, i2);
                }
                Rect rect3 = null;
                if (i10 == 3) {
                    try {
                        try {
                            rect2 = new Rect();
                            try {
                                rect = new Rect();
                                try {
                                    PDFViewCtrl.this.docLockRead();
                                } catch (Exception unused2) {
                                    rect3 = rect2;
                                    z = false;
                                    if (z) {
                                        PDFViewCtrl.this.docUnlockRead();
                                    }
                                    PDFViewCtrl.this.f1849j.lock();
                                    if (PDFViewCtrl.f1639a) {
                                    }
                                    z2 = PDFViewCtrl.this.f1851l.f2127b;
                                    ?? r5 = z2;
                                    if (!z2) {
                                    }
                                    try {
                                        if (i10 == 3) {
                                        }
                                        PDFViewCtrl.this.f1849j.unlock();
                                        if (i10 != 3) {
                                        }
                                        i12 = 1;
                                        if (PDFViewCtrl.f1640b) {
                                        }
                                        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                                        activityManager = (ActivityManager) PDFViewCtrl.this.getContext().getSystemService("activity");
                                        if (activityManager != null) {
                                        }
                                        if (PDFViewCtrl.f1639a) {
                                        }
                                    } catch (Throwable th) {
                                        PDFViewCtrl.this.f1849j.unlock();
                                        throw th;
                                    }
                                }
                            } catch (Exception unused3) {
                                rect = null;
                            }
                        } catch (Exception unused4) {
                            rect = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        Page page = PDFViewCtrl.this.getDoc().getPage(i4);
                        rect2 = page.getCropBox();
                        Rect box = page.getBox(PDFViewCtrl.this.getPageBox());
                        PDFViewCtrl.this.docUnlockRead();
                        rect = box;
                        rect3 = rect2;
                    } catch (Exception unused5) {
                        rect3 = rect2;
                        z = true;
                        if (z) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z3 = true;
                        if (z3) {
                            PDFViewCtrl.this.docUnlockRead();
                        }
                        throw th;
                    }
                } else {
                    rect = null;
                }
                PDFViewCtrl.this.f1849j.lock();
                if (PDFViewCtrl.f1639a) {
                    Log.i("TILES", String.format("Got tile: page %d - id %d - sequence %d", Integer.valueOf(i4), Integer.valueOf(i13), Integer.valueOf(i11)));
                }
                z2 = PDFViewCtrl.this.f1851l.f2127b;
                ?? r52 = z2;
                if (!z2) {
                    PDFViewCtrl.this.f1851l.f2127b = true;
                    C6966e c6966e = PDFViewCtrl.this.f1851l;
                    c6966e.f2126a = i11 - 1;
                    r52 = c6966e;
                }
                try {
                    if (i10 == 3) {
                        try {
                            if (PDFViewCtrl.this.f1851l.m1527c(i8) == null) {
                                PDFViewCtrl.this.f1851l.m1525b(i8);
                            }
                            long j3 = i13;
                            str = "PDFNet";
                            int i14 = i4;
                            i13 = 4;
                            PDFViewCtrl.this.f1851l.m1516a(j3, i14 == true ? 1 : 0, j, j2, i6, i7, i, i2, bitmapM1161a, null, i11, 0, false, -1);
                            r52 = i14;
                        } catch (Exception e) {
                            e = e;
                            r52 = i4;
                            if (PDFViewCtrl.f1639a) {
                                e.printStackTrace();
                            }
                        } catch (OutOfMemoryError unused6) {
                            r52 = i4;
                            i13 = 4;
                            str = "PDFNet";
                            if (PDFViewCtrl.f1640b) {
                                PDFViewCtrl.m1239a(i13, "Will invoke purge memory when batch of tiles is done", PDFViewCtrl.m1230a(false));
                            } else {
                                Log.e(str, "Will invoke purge memory when batch of tiles is done");
                            }
                            PDFViewCtrl.this.f1829di.m1452a();
                        }
                    } else {
                        int i15 = i4;
                        i13 = 4;
                        str = "PDFNet";
                        PDFViewCtrl.this.f1852m.m1508a(i15 == true ? 1 : 0, bitmapM1161a, rect3, rect);
                        r52 = i15;
                        if (PDFViewCtrl.f1639a) {
                            Log.d(PDFViewCtrl.f1641c, "received thumbnails for page: " + (i15 == true ? 1 : 0));
                            r52 = i15;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                } catch (OutOfMemoryError unused7) {
                }
                PDFViewCtrl.this.f1849j.unlock();
                if (i10 != 3) {
                    PDFViewCtrl.this.postInvalidate();
                } else {
                    if (i9 == 0) {
                        PDFViewCtrl.this.f1850k.lock();
                        try {
                            i12 = 1;
                            PDFViewCtrl.m1258a(PDFViewCtrl.this, true);
                            android.graphics.Rect rect4 = (android.graphics.Rect) PDFViewCtrl.this.f1651I.get(r52);
                            if (rect4 != null) {
                                if (PDFViewCtrl.this.f1848i != null && !PDFViewCtrl.this.f1848i.m1535a()) {
                                    PDFViewCtrl.this.f1652J.add(Integer.valueOf((int) r52));
                                } else {
                                    C6963b.a.f2110a.m1504a(rect4);
                                    PDFViewCtrl.this.f1651I.remove(r52);
                                    if (PDFViewCtrl.this.f1651I.size() == 0) {
                                        PDFViewCtrl.this.f1652J.clear();
                                    }
                                }
                            }
                            if (i10 == 0) {
                                PDFViewCtrl.this.f1828dh.sendEmptyMessage(1);
                            }
                            PDFViewCtrl.this.postInvalidate();
                        } finally {
                            PDFViewCtrl.this.f1850k.unlock();
                        }
                    }
                    if (!PDFViewCtrl.f1640b || PDFViewCtrl.f1639a) {
                        ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
                        activityManager = (ActivityManager) PDFViewCtrl.this.getContext().getSystemService("activity");
                        if (activityManager != null) {
                            activityManager.getMemoryInfo(memoryInfo2);
                            if (PDFViewCtrl.f1640b) {
                                PDFViewCtrl.m1239a(i12, "available memory size: " + (memoryInfo2.availMem / 1048576) + "MB, native heap allocated size: " + (Debug.getNativeHeapAllocatedSize() / 1048576) + "MB", PDFViewCtrl.m1230a(false));
                            }
                        }
                        if (PDFViewCtrl.f1639a) {
                            Log.v("MemorySize", "available memory size: " + (memoryInfo2.availMem / 1048576) + "MB");
                            Log.v("MemorySize", "native heap allocated size: " + (Debug.getNativeHeapAllocatedSize() / 1048576) + "MB");
                            return;
                        }
                        return;
                    }
                    return;
                }
                i12 = 1;
                if (PDFViewCtrl.f1640b) {
                }
                ActivityManager.MemoryInfo memoryInfo22 = new ActivityManager.MemoryInfo();
                activityManager = (ActivityManager) PDFViewCtrl.this.getContext().getSystemService("activity");
                if (activityManager != null) {
                }
                if (PDFViewCtrl.f1639a) {
                }
            } else if (PDFViewCtrl.f1640b) {
                PDFViewCtrl.m1239a(4, String.format("Ignore Tile %d due to out of memory", Integer.valueOf(i13)), PDFViewCtrl.m1230a(false));
            } else {
                Log.e("PDFNet", String.format("Ignore Tile %d due to out of memory", Integer.valueOf(i13)));
            }
        }

        private void RemoveTileProc(int i, long j, int i2, int i3) throws Throwable {
            removeTileProc(i, j, i2, i3, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:72:0x01b2  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01be  */
        /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:86:? A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void removeTileProc(int i, long j, int i2, int i3, int i4) throws Throwable {
            Throwable th;
            Exception exc;
            PDFViewCtrl.this.f1849j.lock();
            boolean z = true;
            if (i4 == 0) {
                PDFViewCtrl.this.f1851l.f2127b = true;
                PDFViewCtrl.this.f1851l.f2126a = i3;
            } else if (i4 == 1 && !PDFViewCtrl.this.f1851l.m1522a(i3)) {
                return;
            }
            try {
                try {
                    try {
                        if (i2 <= 0 || j > 0) {
                            if (PDFViewCtrl.this.f1851l.m1528d(i4)) {
                                PDFViewCtrl.this.f1849j.unlock();
                                return;
                            }
                            try {
                                if (i < 0 && j < 0) {
                                    if (PDFViewCtrl.f1639a) {
                                        Log.i("TILES", String.format("Removing all tiles - sequence %d, doc %s", Integer.valueOf(i3), PDFViewCtrl.this.mDoc.getFileName()));
                                    }
                                    PDFViewCtrl.this.f1851l.m1529e(i4);
                                    if (i4 == 1) {
                                        PDFViewCtrl.this.f1851l.f2128c = i3;
                                    }
                                } else if (i >= 0 || j < 0 || i2 <= 0) {
                                    if (i > 0 && j < 0) {
                                        double[] dArrM1332e = PDFViewCtrl.this.m1332e(i);
                                        int length = dArrM1332e.length;
                                        for (int i5 = 0; i5 < length; i5 += 5) {
                                            if (PDFViewCtrl.f1639a) {
                                                Log.i("TILES", String.format("Removing page %d - sequence %d, doc %s", Integer.valueOf((int) dArrM1332e[i5]), Integer.valueOf(i3), PDFViewCtrl.this.mDoc.getFileName()));
                                            }
                                            PDFViewCtrl.this.f1851l.m1517a((int) dArrM1332e[i5], i4);
                                        }
                                    } else if (i >= 0 && j >= 0) {
                                        PDFViewCtrl.this.f1851l.m1518a(i2, j, i3, i4);
                                        if (PDFViewCtrl.f1639a) {
                                            Log.i("TILES", String.format("Removing page %d - id %d, sequence %d, tile count %d, doc %s", Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(PDFViewCtrl.this.f1851l.m1526c()), PDFViewCtrl.this.mDoc.getFileName()));
                                        }
                                    }
                                } else if (i4 == 1) {
                                    PDFViewCtrl.this.f1851l.m1518a(i2, j, i3, i4);
                                }
                                PDFViewCtrl.this.f1849j.unlock();
                                return;
                            } catch (Throwable th2) {
                                PDFViewCtrl.this.f1849j.unlock();
                                throw th2;
                            }
                        }
                        try {
                            PDFViewCtrl.this.f1852m.m1510b(i2);
                            if (PDFViewCtrl.f1639a) {
                                Log.i("TILES", String.format("Removing thumb - id %d, thumb count %d, doc %s", Integer.valueOf(i2), Integer.valueOf(PDFViewCtrl.this.f1852m.m1507a()), PDFViewCtrl.this.mDoc.getFileName()));
                            }
                            PDFViewCtrl.this.f1849j.unlock();
                        } catch (Throwable th3) {
                            PDFViewCtrl.this.f1849j.unlock();
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (!z) {
                            PDFViewCtrl.this.f1849j.unlock();
                            throw th;
                        }
                        throw th;
                    }
                } catch (Exception e) {
                    exc = e;
                    Log.e("TILES", "Error in remove tile proc!!!! " + exc.toString());
                    if (z) {
                        return;
                    }
                    PDFViewCtrl.this.f1849j.unlock();
                }
            } catch (Exception e2) {
                exc = e2;
                z = false;
                Log.e("TILES", "Error in remove tile proc!!!! " + exc.toString());
                if (z) {
                }
            } catch (Throwable th5) {
                th = th5;
                z = false;
                if (!z) {
                }
            }
        }

        private long GetAvailableTileBytes() {
            return PDFViewCtrl.this.m1303b();
        }

        private void RenderBegin(PDFViewCtrl pDFViewCtrl, boolean z) {
            PDFViewCtrl.this.f1827dg.removeMessages(0);
            PDFViewCtrl.this.f1827dg.sendEmptyMessageDelayed(0, PDFViewCtrl.this.f1655N);
            if (!z || PDFViewCtrl.this.f1732bP == null) {
                return;
            }
            PDFViewCtrl.this.f1832dl.sendEmptyMessage(0);
        }

        private void RenderEnd(boolean z) {
            PDFViewCtrl.this.f1827dg.removeMessages(0);
            if (!z || PDFViewCtrl.this.f1732bP == null) {
                return;
            }
            PDFViewCtrl.this.f1832dl.sendEmptyMessage(1);
        }

        private void FindTextProcCallback(boolean z, long j) {
            Thread.yield();
            Message message = new Message();
            message.setTarget(PDFViewCtrl.this.f1837dq);
            PDFViewCtrl pDFViewCtrl = PDFViewCtrl.this;
            Selection selection = new Selection(pDFViewCtrl, j, pDFViewCtrl, (byte) 0);
            Vector vector = new Vector();
            vector.add(Boolean.valueOf(z));
            vector.add(selection);
            message.obj = vector;
            message.sendToTarget();
        }

        private void PartDownloadedProcCallback(int i, long j, int i2, int i3, String str, PDFViewCtrl pDFViewCtrl) {
            Thread.yield();
            Message message = new Message();
            message.setTarget(PDFViewCtrl.this.f1838dr);
            Vector vector = new Vector();
            vector.add(Integer.valueOf(i));
            vector.add(Long.valueOf(j));
            vector.add(Integer.valueOf(i2));
            vector.add(Integer.valueOf(i3));
            vector.add(str);
            vector.add(Integer.valueOf(PDFViewCtrl.this.f1775cG));
            message.obj = vector;
            message.sendToTarget();
        }

        private void ErrorReportProcCallback(String str) {
            Thread.yield();
            Message message = new Message();
            message.setTarget(PDFViewCtrl.this.f1839ds);
            Vector vector = new Vector();
            vector.add(str);
            message.obj = vector;
            message.sendToTarget();
        }

        private void ThumbAsyncHandlerProc(int i, boolean z, int[] iArr, int i2, int i3) {
            Thread.yield();
            Message message = new Message();
            message.setTarget(PDFViewCtrl.this.f1840dt);
            if (z) {
                Vector vector = new Vector();
                vector.add(Integer.valueOf(i));
                vector.add(iArr);
                vector.add(Integer.valueOf(i2));
                vector.add(Integer.valueOf(i3));
                message.obj = vector;
                message.sendToTarget();
            }
        }

        private void DoActionCompletedCallback(PDFViewCtrl pDFViewCtrl, long j) {
            Thread.yield();
            Action action = new Action(j, null);
            Message message = new Message();
            message.setTarget(PDFViewCtrl.this.f1841du);
            Vector vector = new Vector();
            vector.add(action);
            message.obj = vector;
            message.sendToTarget();
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$i */
    static class HandlerC6945i extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1916a;

        HandlerC6945i(PDFViewCtrl pDFViewCtrl) {
            this.f1916a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            PDFViewCtrl pDFViewCtrl = this.f1916a.get();
            if (pDFViewCtrl != null) {
                PDFViewCtrl.m1210L(pDFViewCtrl);
                sendEmptyMessageDelayed(0, pDFViewCtrl.f1656O);
            }
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$m */
    static class HandlerC6949m extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1960a;

        HandlerC6949m(PDFViewCtrl pDFViewCtrl) {
            this.f1960a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            PDFViewCtrl pDFViewCtrl = this.f1960a.get();
            if (pDFViewCtrl != null) {
                pDFViewCtrl.requestRendering();
                if (message.what != 1 || pDFViewCtrl.f1736bT == null) {
                    return;
                }
                pDFViewCtrl.f1736bT.onRenderingFinished();
            }
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$k */
    static class HandlerC6947k extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1958a;

        HandlerC6947k(PDFViewCtrl pDFViewCtrl) {
            this.f1958a = new WeakReference<>(pDFViewCtrl);
        }

        /* JADX INFO: renamed from: a */
        public final void m1452a() {
            PDFViewCtrl pDFViewCtrl = this.f1958a.get();
            if (pDFViewCtrl != null) {
                PDFViewCtrl.m1356j(pDFViewCtrl, true);
                if (hasMessages(0)) {
                    return;
                }
                sendEmptyMessage(0);
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            PDFViewCtrl pDFViewCtrl = this.f1958a.get();
            if (pDFViewCtrl == null || pDFViewCtrl.f1823dc == 0) {
                return;
            }
            pDFViewCtrl.purgeMemory();
            try {
                pDFViewCtrl.update();
            } catch (PDFNetException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$d */
    static class HandlerC6940d extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1911a;

        HandlerC6940d(PDFViewCtrl pDFViewCtrl) {
            this.f1911a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            PDFViewCtrl pDFViewCtrl = this.f1911a.get();
            if (pDFViewCtrl != null) {
                if (pDFViewCtrl.f1726bJ != null && pDFViewCtrl.f1727bK) {
                    PDFViewCtrl.m1359k(pDFViewCtrl, false);
                    Iterator it = pDFViewCtrl.f1726bJ.iterator();
                    while (it.hasNext()) {
                        ((DocumentLoadListener) it.next()).onDocumentLoaded();
                    }
                }
                pDFViewCtrl.f1774cF.m1464c();
            }
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$b */
    static class HandlerC6938b extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1903a;

        HandlerC6938b(PDFViewCtrl pDFViewCtrl) {
            this.f1903a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            PDFViewCtrl pDFViewCtrl = this.f1903a.get();
            if (pDFViewCtrl == null || pDFViewCtrl.f1722bF == null) {
                return;
            }
            pDFViewCtrl.f1724bH = pDFViewCtrl.getCurrentPage();
            if (pDFViewCtrl.f1723bG != pDFViewCtrl.f1724bH || pDFViewCtrl.f1725bI == PageChangeState.BEGIN || pDFViewCtrl.f1725bI == PageChangeState.END) {
                if (pDFViewCtrl.f1723bG != pDFViewCtrl.f1724bH && pDFViewCtrl.f1725bI == PageChangeState.SILENT) {
                    pDFViewCtrl.f1725bI = PageChangeState.END;
                }
                int i = pDFViewCtrl.f1723bG;
                pDFViewCtrl.f1723bG = pDFViewCtrl.f1724bH;
                PageChangeState pageChangeState = pDFViewCtrl.f1725bI;
                if (pageChangeState == PageChangeState.BEGIN) {
                    Iterator it = pDFViewCtrl.f1722bF.iterator();
                    while (it.hasNext()) {
                        ((PageChangeListener) it.next()).onPageChange(i, i, PageChangeState.BEGIN);
                    }
                    pDFViewCtrl.f1725bI = PageChangeState.ONGOING;
                    return;
                }
                if (pageChangeState == PageChangeState.ONGOING) {
                    Iterator it2 = pDFViewCtrl.f1722bF.iterator();
                    while (it2.hasNext()) {
                        ((PageChangeListener) it2.next()).onPageChange(i, pDFViewCtrl.f1724bH, PageChangeState.ONGOING);
                    }
                } else if (pageChangeState == PageChangeState.END) {
                    pDFViewCtrl.f1725bI = PageChangeState.SILENT;
                    Iterator it3 = pDFViewCtrl.f1722bF.iterator();
                    while (it3.hasNext()) {
                        ((PageChangeListener) it3.next()).onPageChange(pDFViewCtrl.f1724bH, pDFViewCtrl.f1724bH, PageChangeState.END);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$l */
    static class HandlerC6948l extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1959a;

        HandlerC6948l(PDFViewCtrl pDFViewCtrl) {
            this.f1959a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            PDFViewCtrl pDFViewCtrl = this.f1959a.get();
            if (pDFViewCtrl == null || pDFViewCtrl.f1732bP == null) {
                return;
            }
            if (message.what == 0) {
                pDFViewCtrl.f1732bP.onRenderingStarted();
            } else {
                pDFViewCtrl.f1732bP.onRenderingFinished();
            }
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$h */
    static class HandlerC6944h extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1915a;

        HandlerC6944h(PDFViewCtrl pDFViewCtrl) {
            this.f1915a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            PDFViewCtrl pDFViewCtrl = this.f1915a.get();
            if (pDFViewCtrl != null) {
                pDFViewCtrl.onLongPress(pDFViewCtrl.f1694ad);
                pDFViewCtrl.f1692ab = true;
            }
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$q */
    static class HandlerC6953q extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1972a;

        HandlerC6953q(PDFViewCtrl pDFViewCtrl) {
            this.f1972a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            PDFViewCtrl pDFViewCtrl = this.f1972a.get();
            if (pDFViewCtrl != null) {
                pDFViewCtrl.requestRendering();
            }
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$p */
    static class HandlerC6952p extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1971a;

        HandlerC6952p(PDFViewCtrl pDFViewCtrl) {
            this.f1971a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            PDFViewCtrl pDFViewCtrl = this.f1971a.get();
            if (pDFViewCtrl == null || pDFViewCtrl.f1736bT == null) {
                return;
            }
            pDFViewCtrl.f1736bT.onPostSingleTapConfirmed();
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$t */
    static class HandlerC6956t extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1975a;

        HandlerC6956t(PDFViewCtrl pDFViewCtrl) {
            this.f1975a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            PDFViewCtrl pDFViewCtrl = this.f1975a.get();
            if (pDFViewCtrl == null || pDFViewCtrl.f1736bT == null) {
                return;
            }
            pDFViewCtrl.f1736bT.onCustomEvent(pDFViewCtrl.f1801cg);
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$g */
    static class HandlerC6943g extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1914a;

        HandlerC6943g(PDFViewCtrl pDFViewCtrl) {
            this.f1914a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z;
            PDFViewCtrl pDFViewCtrl = this.f1914a.get();
            if (pDFViewCtrl == null || !(message.obj instanceof Vector)) {
                return;
            }
            Vector vector = (Vector) message.obj;
            boolean z2 = false;
            boolean zBooleanValue = ((Boolean) vector.elementAt(0)).booleanValue();
            Selection selection = (Selection) vector.elementAt(1);
            synchronized (this.f1914a.get()) {
                PDFViewCtrl.m1221W(pDFViewCtrl);
            }
            if (pDFViewCtrl.f1843dw != null) {
                pDFViewCtrl.f1843dw.interrupt();
            }
            pDFViewCtrl.f1842dv.removeMessages(0);
            if (zBooleanValue) {
                pDFViewCtrl.selectWithSelection(selection);
                if (!pDFViewCtrl.isContinuousPagePresentationMode(pDFViewCtrl.f1739bW)) {
                    pDFViewCtrl.m1378s();
                }
                pDFViewCtrl.scrollTo(pDFViewCtrl.m1373q(), pDFViewCtrl.m1375r());
                pDFViewCtrl.invalidate();
                if (pDFViewCtrl.f1717bA != null) {
                    pDFViewCtrl.f1717bA.onTextSearchEnd(TextSearchResult.FOUND);
                }
                if (pDFViewCtrl.f1718bB != null) {
                    Iterator it = pDFViewCtrl.f1718bB.iterator();
                    while (it.hasNext()) {
                        ((TextSearchListener) it.next()).onTextSearchEnd(TextSearchResult.FOUND);
                    }
                    return;
                }
                return;
            }
            synchronized (this) {
                if (pDFViewCtrl.f1767by) {
                    PDFViewCtrl.m1362l(pDFViewCtrl, false);
                    z = true;
                } else {
                    z = false;
                }
                if (pDFViewCtrl.f1768bz) {
                    PDFViewCtrl.m1365m(pDFViewCtrl, false);
                    z2 = true;
                }
            }
            if (pDFViewCtrl.f1717bA != null) {
                if (z) {
                    pDFViewCtrl.f1717bA.onTextSearchEnd(TextSearchResult.CANCELED);
                } else if (z2) {
                    pDFViewCtrl.f1717bA.onTextSearchEnd(TextSearchResult.INVALID_INPUT);
                } else {
                    pDFViewCtrl.f1717bA.onTextSearchEnd(TextSearchResult.NOT_FOUND);
                }
            }
            if (pDFViewCtrl.f1718bB != null) {
                for (TextSearchListener textSearchListener : pDFViewCtrl.f1718bB) {
                    if (z) {
                        textSearchListener.onTextSearchEnd(TextSearchResult.CANCELED);
                    } else if (z2) {
                        textSearchListener.onTextSearchEnd(TextSearchResult.INVALID_INPUT);
                    } else {
                        textSearchListener.onTextSearchEnd(TextSearchResult.NOT_FOUND);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$e */
    static class HandlerC6941e extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1912a;

        HandlerC6941e(PDFViewCtrl pDFViewCtrl) {
            this.f1912a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) throws Throwable {
            PDFViewCtrl pDFViewCtrl = this.f1912a.get();
            if (pDFViewCtrl == null || !(message.obj instanceof Vector)) {
                return;
            }
            Vector vector = (Vector) message.obj;
            DownloadState downloadStateValueOf = DownloadState.valueOf(((Integer) vector.elementAt(0)).intValue());
            Long l = (Long) vector.elementAt(1);
            Integer num = (Integer) vector.elementAt(2);
            Integer num2 = (Integer) vector.elementAt(3);
            String str = (String) vector.elementAt(4);
            if (((Integer) vector.elementAt(5)).intValue() != pDFViewCtrl.f1775cG) {
                Log.i("UNIVERSAL", "Got Event for conversion but sequence number doesn't match");
                return;
            }
            if (downloadStateValueOf == DownloadState.FAILED || pDFViewCtrl.m1329e(l.longValue())) {
                if (downloadStateValueOf == DownloadState.PAGE) {
                    pDFViewCtrl.f1774cF.m1461a(l.longValue(), num.intValue(), num2.intValue(), str);
                    if (!pDFViewCtrl.f1800cf.f1933b && !pDFViewCtrl.f1658Q) {
                        pDFViewCtrl.f1774cF.m1463b();
                    }
                    if (pDFViewCtrl.f1774cF.f1976a == null) {
                        PDFViewCtrl.m1280ag(pDFViewCtrl);
                        if (pDFViewCtrl.f1802ch > pDFViewCtrl.f1803ci) {
                            pDFViewCtrl.f1802ch = pDFViewCtrl.f1803ci;
                        }
                    }
                } else if (downloadStateValueOf == DownloadState.THUMB) {
                    PDFViewCtrl.m1306b(pDFViewCtrl, l.longValue(), num.intValue(), num2.intValue());
                } else if (downloadStateValueOf == DownloadState.OUTLINE) {
                    PDFViewCtrl.m1317c(pDFViewCtrl, l.longValue());
                } else if (downloadStateValueOf == DownloadState.FINISHED) {
                    pDFViewCtrl.f1774cF.f1981f = l.longValue();
                    if (!pDFViewCtrl.f1800cf.f1933b && !pDFViewCtrl.f1658Q) {
                        pDFViewCtrl.f1774cF.m1458e();
                    }
                } else if (downloadStateValueOf == DownloadState.FAILED) {
                    if (pDFViewCtrl.f1774cF.f1976a != null) {
                        pDFViewCtrl.f1774cF.m1465d();
                        if (pDFViewCtrl.f1720bD != null) {
                            Iterator it = pDFViewCtrl.f1720bD.iterator();
                            while (it.hasNext()) {
                                ((UniversalDocumentConversionListener) it.next()).onConversionEvent(ConversionState.FAILED, 0);
                            }
                        }
                    }
                } else if (downloadStateValueOf == DownloadState.OPENED) {
                    PDFViewCtrl.m1324d(pDFViewCtrl, l.longValue());
                    try {
                        PDFViewCtrl.m1327e(pDFViewCtrl, l.longValue());
                    } catch (PDFNetException e) {
                        e.printStackTrace();
                    }
                }
                if (downloadStateValueOf == DownloadState.FINISHED || downloadStateValueOf == DownloadState.FAILED) {
                    PDFViewCtrl.m1368n(pDFViewCtrl, false);
                }
                if (pDFViewCtrl.f1774cF.f1976a == null) {
                    if (downloadStateValueOf == DownloadState.PAGE || downloadStateValueOf == DownloadState.FINISHED || downloadStateValueOf == DownloadState.NAMED_DESTS || downloadStateValueOf == DownloadState.THUMB || downloadStateValueOf == DownloadState.OUTLINE || downloadStateValueOf == DownloadState.FAILED) {
                        if (pDFViewCtrl.f1719bC != null) {
                            Iterator it2 = pDFViewCtrl.f1719bC.iterator();
                            while (it2.hasNext()) {
                                ((DocumentDownloadListener) it2.next()).onDownloadEvent(downloadStateValueOf, num.intValue(), pDFViewCtrl.f1802ch, pDFViewCtrl.f1803ci, str);
                            }
                        }
                        if (pDFViewCtrl.f1736bT != null) {
                            pDFViewCtrl.f1736bT.onDocumentDownloadEvent(downloadStateValueOf, num.intValue(), pDFViewCtrl.f1802ch, pDFViewCtrl.f1803ci, str);
                        }
                    }
                    if (pDFViewCtrl.f1828dh.hasMessages(0)) {
                        return;
                    }
                    pDFViewCtrl.f1828dh.sendEmptyMessageDelayed(0, 200L);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$f */
    static class HandlerC6942f extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1913a;

        HandlerC6942f(PDFViewCtrl pDFViewCtrl) {
            this.f1913a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            PDFViewCtrl pDFViewCtrl = this.f1913a.get();
            if (pDFViewCtrl == null || pDFViewCtrl.f1728bL == null || !(message.obj instanceof Vector)) {
                return;
            }
            pDFViewCtrl.f1728bL.onErrorReportEvent((String) ((Vector) message.obj).elementAt(0));
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$s */
    static class HandlerC6955s extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1974a;

        HandlerC6955s(PDFViewCtrl pDFViewCtrl) {
            this.f1974a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            PDFViewCtrl pDFViewCtrl = this.f1974a.get();
            if (pDFViewCtrl == null || pDFViewCtrl.f1729bM == null || !(message.obj instanceof Vector)) {
                return;
            }
            Vector vector = (Vector) message.obj;
            int iIntValue = ((Integer) vector.elementAt(0)).intValue();
            int[] iArr = (int[]) vector.elementAt(1);
            int iIntValue2 = ((Integer) vector.elementAt(2)).intValue();
            int iIntValue3 = ((Integer) vector.elementAt(3)).intValue();
            Iterator it = pDFViewCtrl.f1729bM.iterator();
            while (it.hasNext()) {
                ((ThumbAsyncListener) it.next()).onThumbReceived(iIntValue, iArr, iIntValue2, iIntValue3);
            }
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$a */
    static class HandlerC6937a extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1902a;

        HandlerC6937a(PDFViewCtrl pDFViewCtrl) {
            this.f1902a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            PDFViewCtrl pDFViewCtrl = this.f1902a.get();
            if (pDFViewCtrl == null || pDFViewCtrl.f1731bO == null || !(message.obj instanceof Vector)) {
                return;
            }
            pDFViewCtrl.f1731bO.onActionCompleted((Action) ((Vector) message.obj).elementAt(0));
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$r */
    static class HandlerC6954r extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<PDFViewCtrl> f1973a;

        HandlerC6954r(PDFViewCtrl pDFViewCtrl) {
            this.f1973a = new WeakReference<>(pDFViewCtrl);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int iM1287an;
            PDFViewCtrl pDFViewCtrl = this.f1973a.get();
            if (pDFViewCtrl != null) {
                if (pDFViewCtrl.f1717bA != null && (iM1287an = (int) (PDFViewCtrl.m1287an(pDFViewCtrl) * 100.0f)) >= 0) {
                    pDFViewCtrl.f1717bA.onTextSearchProgress(iM1287an);
                }
                if (pDFViewCtrl.f1718bB != null) {
                    for (TextSearchListener textSearchListener : pDFViewCtrl.f1718bB) {
                        int iM1287an2 = (int) (PDFViewCtrl.m1287an(pDFViewCtrl) * 100.0f);
                        if (iM1287an2 >= 0) {
                            textSearchListener.onTextSearchProgress(iM1287an2);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$c */
    class AlertDialogC6939c extends AlertDialog {

        /* JADX INFO: renamed from: b */
        private EditText f1905b;

        /* JADX INFO: renamed from: c */
        private PDFDoc f1906c;

        /* JADX INFO: renamed from: d */
        private int f1907d;

        AlertDialogC6939c(Context context) {
            super(context);
            this.f1907d = 0;
            this.f1906c = null;
            setTitle("Password");
            EditText editText = new EditText(context);
            this.f1905b = editText;
            editText.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f1905b.setSingleLine();
            this.f1905b.setTransformationMethod(new PasswordTransformationMethod());
            this.f1905b.setOnEditorActionListener(new TextView.OnEditorActionListener(PDFViewCtrl.this) { // from class: com.pdftron.pdf.PDFViewCtrl.c.1
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 0 && i != 6 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                        return false;
                    }
                    AlertDialogC6939c.m1389a(AlertDialogC6939c.this);
                    return true;
                }
            });
            setOnShowListener(new DialogInterface.OnShowListener(PDFViewCtrl.this) { // from class: com.pdftron.pdf.PDFViewCtrl.c.2
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    Button button = PDFViewCtrl.this.f1735bS != null ? PDFViewCtrl.this.f1735bS.getButton(-1) : null;
                    if (button != null) {
                        button.setOnClickListener(new View.OnClickListener() { // from class: com.pdftron.pdf.PDFViewCtrl.c.2.1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                AlertDialogC6939c.m1389a(AlertDialogC6939c.this);
                            }
                        });
                    }
                }
            });
            setView(this.f1905b, 8, 8, 8, 8);
            setButton(-1, "OK", new DialogInterface.OnClickListener(this, PDFViewCtrl.this) { // from class: com.pdftron.pdf.PDFViewCtrl.c.3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            setButton(-2, "Cancel", new DialogInterface.OnClickListener(this, PDFViewCtrl.this) { // from class: com.pdftron.pdf.PDFViewCtrl.c.4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }

        /* JADX INFO: renamed from: a */
        public final void m1390a(PDFDoc pDFDoc) {
            this.f1906c = pDFDoc;
            this.f1907d = 0;
        }

        @Override // android.app.Dialog
        public final void show() {
            this.f1905b.setText("");
            super.show();
        }

        /* JADX INFO: renamed from: a */
        static /* synthetic */ void m1389a(AlertDialogC6939c alertDialogC6939c) {
            alertDialogC6939c.f1907d++;
            String string = alertDialogC6939c.f1905b.getText().toString();
            try {
                PDFDoc pDFDoc = alertDialogC6939c.f1906c;
                if (pDFDoc != null) {
                    if (pDFDoc.initStdSecurityHandler(string)) {
                        alertDialogC6939c.dismiss();
                        PDFViewCtrl.this.m1244a(alertDialogC6939c.f1906c, false);
                        return;
                    }
                    alertDialogC6939c.f1905b.setText("");
                    if (alertDialogC6939c.f1907d == 3) {
                        alertDialogC6939c.dismiss();
                        Toast toastMakeText = Toast.makeText(alertDialogC6939c.getContext(), "Opening document failed - incorrect password.", 0);
                        toastMakeText.setGravity(17, 0, 0);
                        toastMakeText.show();
                        return;
                    }
                    return;
                }
                alertDialogC6939c.dismiss();
            } catch (Exception unused) {
                alertDialogC6939c.dismiss();
                Toast toastMakeText2 = Toast.makeText(alertDialogC6939c.getContext(), "Opening document failed - unknown reason.", 0);
                toastMakeText2.setGravity(17, 0, 0);
                toastMakeText2.show();
            }
        }
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.PDFViewCtrl$j */
    class C6946j {

        /* JADX INFO: renamed from: A */
        private boolean f1917A;

        /* JADX INFO: renamed from: G */
        private boolean f1923G;

        /* JADX INFO: renamed from: H */
        private int f1924H;

        /* JADX INFO: renamed from: I */
        private int f1925I;

        /* JADX INFO: renamed from: J */
        private int f1926J;

        /* JADX INFO: renamed from: K */
        private int f1927K;

        /* JADX INFO: renamed from: L */
        private int f1928L;

        /* JADX INFO: renamed from: M */
        private int f1929M;

        /* JADX INFO: renamed from: N */
        private int f1930N;

        /* JADX INFO: renamed from: g */
        private float f1938g;

        /* JADX INFO: renamed from: h */
        private float f1939h;

        /* JADX INFO: renamed from: i */
        private float f1940i;

        /* JADX INFO: renamed from: j */
        private float f1941j;

        /* JADX INFO: renamed from: k */
        private float f1942k;

        /* JADX INFO: renamed from: l */
        private final float f1943l;

        /* JADX INFO: renamed from: m */
        private final int f1944m;

        /* JADX INFO: renamed from: n */
        private final float f1945n;

        /* JADX INFO: renamed from: o */
        private int f1946o;

        /* JADX INFO: renamed from: p */
        private int f1947p;

        /* JADX INFO: renamed from: q */
        private int f1948q;

        /* JADX INFO: renamed from: r */
        private int f1949r;

        /* JADX INFO: renamed from: s */
        private int f1950s;

        /* JADX INFO: renamed from: t */
        private int f1951t;

        /* JADX INFO: renamed from: v */
        private int f1953v;

        /* JADX INFO: renamed from: y */
        private int f1956y;

        /* JADX INFO: renamed from: z */
        private int f1957z;

        /* JADX INFO: renamed from: u */
        private int f1952u = -1;

        /* JADX INFO: renamed from: w */
        private boolean f1954w = false;

        /* JADX INFO: renamed from: x */
        private boolean f1955x = false;

        /* JADX INFO: renamed from: b */
        private boolean f1933b = false;

        /* JADX INFO: renamed from: d */
        private boolean f1935d = false;

        /* JADX INFO: renamed from: c */
        private boolean f1934c = false;

        /* JADX INFO: renamed from: e */
        private boolean f1936e = false;

        /* JADX INFO: renamed from: f */
        private boolean f1937f = false;

        /* JADX INFO: renamed from: E */
        private boolean f1921E = false;

        /* JADX INFO: renamed from: F */
        private boolean f1922F = false;

        /* JADX INFO: renamed from: B */
        private boolean f1918B = false;

        /* JADX INFO: renamed from: C */
        private boolean f1919C = false;

        /* JADX INFO: renamed from: D */
        private boolean f1920D = false;

        /* JADX INFO: renamed from: a */
        private boolean f1932a = false;

        /* JADX INFO: renamed from: b */
        static /* synthetic */ boolean m1405b(C6946j c6946j, boolean z) {
            c6946j.f1933b = false;
            return false;
        }

        /* JADX INFO: renamed from: c */
        static /* synthetic */ boolean m1412c(C6946j c6946j, boolean z) {
            c6946j.f1936e = false;
            return false;
        }

        /* JADX INFO: renamed from: d */
        static /* synthetic */ boolean m1417d(C6946j c6946j, boolean z) {
            c6946j.f1937f = false;
            return false;
        }

        /* JADX INFO: renamed from: j */
        static /* synthetic */ int m1431j(C6946j c6946j, int i) {
            c6946j.f1952u = -1;
            return -1;
        }

        C6946j(int i, int i2) {
            this.f1942k = PDFViewCtrl.this.m1226a(10.0f);
            this.f1943l = PDFViewCtrl.this.m1226a(i2);
            this.f1944m = i;
            this.f1945n = PDFViewCtrl.this.m1226a(30.0f);
        }

        /* JADX INFO: renamed from: a */
        final C6946j m1448a() {
            int currentPage = PDFViewCtrl.this.getCurrentPage();
            this.f1946o = currentPage;
            this.f1950s = currentPage;
            this.f1951t = currentPage;
            this.f1952u = -1;
            this.f1948q = PDFViewCtrl.this.getPageCount();
            boolean z = this.f1933b;
            if (!z) {
                this.f1917A = false;
                this.f1957z = PDFViewCtrl.this.getCurCanvasId();
                this.f1956y = PDFViewCtrl.this.getCurrentPage();
            }
            this.f1949r = this.f1948q;
            PagePresentationMode pagePresentationMode = PDFViewCtrl.this.getPagePresentationMode();
            if (pagePresentationMode == PagePresentationMode.FACING || pagePresentationMode == PagePresentationMode.FACING_VERT) {
                this.f1949r = PDFViewCtrl.m1336f(PDFViewCtrl.this, this.f1948q) ? this.f1948q : this.f1948q + 1;
            } else if (pagePresentationMode == PagePresentationMode.FACING_COVER || pagePresentationMode == PagePresentationMode.FACING_COVER_VERT) {
                this.f1949r = PDFViewCtrl.m1336f(PDFViewCtrl.this, this.f1948q) ? this.f1948q + 1 : this.f1948q;
            }
            this.f1921E = false;
            this.f1922F = true;
            this.f1935d = false;
            this.f1923G = false;
            this.f1932a = false;
            PDFViewCtrl.m1289ap(PDFViewCtrl.this);
            this.f1919C = false;
            this.f1920D = false;
            if (PDFViewCtrl.m1257a(PDFViewCtrl.this, pagePresentationMode)) {
                if (PDFViewCtrl.this.f1666aB == PDFViewCtrl.this.f1668aD) {
                    this.f1918B = false;
                    if (PDFViewCtrl.this.f1665aA != PDFViewCtrl.this.f1667aC) {
                        this.f1920D = true;
                    }
                } else {
                    this.f1918B = true;
                }
            } else if (PDFViewCtrl.this.f1665aA == PDFViewCtrl.this.f1667aC) {
                this.f1918B = false;
                if (PDFViewCtrl.this.f1666aB != PDFViewCtrl.this.f1668aD) {
                    this.f1919C = true;
                }
            } else {
                this.f1918B = true;
            }
            if (this.f1934c) {
                this.f1936e = true;
                if (PDFViewCtrl.m1257a(PDFViewCtrl.this, pagePresentationMode)) {
                    this.f1947p = PDFViewCtrl.this.m1381u();
                } else {
                    this.f1947p = PDFViewCtrl.this.m1379t();
                }
            } else {
                this.f1947p = PDFViewCtrl.this.getCurCanvasId();
            }
            if (!z) {
                if (PDFViewCtrl.m1257a(PDFViewCtrl.this, pagePresentationMode)) {
                    this.f1924H = PDFViewCtrl.this.getScrollX();
                    this.f1925I = (this.f1918B || PDFViewCtrl.this.f1817cw) ? 0 : PDFViewCtrl.this.getScrollY();
                } else {
                    this.f1924H = (this.f1918B || PDFViewCtrl.this.f1817cw) ? PDFViewCtrl.this.getScrollX() : 0;
                    this.f1925I = PDFViewCtrl.this.getScrollY();
                }
                if (PDFViewCtrl.this.f1730bN != null) {
                    Iterator it = PDFViewCtrl.this.f1730bN.iterator();
                    while (it.hasNext()) {
                        ((PageSlidingListener) it.next()).onScrollOffsetChanged(this.f1924H, this.f1925I);
                    }
                }
            }
            this.f1953v = 0;
            return this;
        }

        /* JADX INFO: renamed from: a */
        final void m1449a(MotionEvent motionEvent) {
            this.f1938g = motionEvent.getX();
            this.f1939h = motionEvent.getY();
            this.f1940i = motionEvent.getX();
            this.f1941j = motionEvent.getY();
            m1448a();
        }

        /* JADX INFO: renamed from: b */
        final boolean m1451b(MotionEvent motionEvent) {
            boolean z;
            int i;
            int scrollX;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int scrollY;
            int i7;
            int i8;
            boolean z2 = false;
            if (this.f1922F && this.f1948q != 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int scrollX2 = PDFViewCtrl.this.getScrollX();
                int scrollY2 = PDFViewCtrl.this.getScrollY();
                float f = this.f1940i - x;
                float f2 = this.f1941j - y;
                float f3 = x - this.f1938g;
                float f4 = y - this.f1939h;
                this.f1940i = x;
                this.f1941j = y;
                if (PDFViewCtrl.this.f1817cw) {
                    PDFViewCtrl.this.m1378s();
                    PDFViewCtrl pDFViewCtrl = PDFViewCtrl.this;
                    if (PDFViewCtrl.m1257a(pDFViewCtrl, pDFViewCtrl.f1739bW)) {
                        PDFViewCtrl pDFViewCtrl2 = PDFViewCtrl.this;
                        pDFViewCtrl2.f1675aK = pDFViewCtrl2.getScrollOffsetForCanvasId(pDFViewCtrl2.getCurCanvasId());
                        PDFViewCtrl pDFViewCtrl3 = PDFViewCtrl.this;
                        pDFViewCtrl3.f1676aL = pDFViewCtrl3.f1675aK;
                    } else {
                        PDFViewCtrl pDFViewCtrl4 = PDFViewCtrl.this;
                        pDFViewCtrl4.f1671aG = pDFViewCtrl4.getScrollOffsetForCanvasId(pDFViewCtrl4.getCurCanvasId());
                        PDFViewCtrl pDFViewCtrl5 = PDFViewCtrl.this;
                        pDFViewCtrl5.f1672aH = pDFViewCtrl5.f1671aG;
                    }
                }
                int i9 = (!this.f1918B || PDFViewCtrl.this.f1817cw) ? scrollX2 - PDFViewCtrl.this.f1672aH : scrollX2;
                int iAbs = (this.f1918B || PDFViewCtrl.this.f1817cw) ? PDFViewCtrl.this.f1672aH + Math.abs(this.f1953v) : PDFViewCtrl.this.getScrollX();
                int i10 = (!this.f1918B || PDFViewCtrl.this.f1817cw) ? scrollY2 - PDFViewCtrl.this.f1676aL : scrollY2;
                int iAbs2 = (this.f1918B || PDFViewCtrl.this.f1817cw) ? PDFViewCtrl.this.f1676aL + Math.abs(this.f1953v) : PDFViewCtrl.this.getScrollY();
                if (!this.f1933b) {
                    PDFViewCtrl pDFViewCtrl6 = PDFViewCtrl.this;
                    if (PDFViewCtrl.m1257a(pDFViewCtrl6, pDFViewCtrl6.f1739bW) || Math.abs(f3) <= Math.abs(f4)) {
                        PDFViewCtrl pDFViewCtrl7 = PDFViewCtrl.this;
                        if (!PDFViewCtrl.m1257a(pDFViewCtrl7, pDFViewCtrl7.f1739bW) || Math.abs(f4) <= Math.abs(f3)) {
                            if (this.f1933b) {
                                return true;
                            }
                        } else if (f4 >= 3.0f) {
                            if (i10 <= 1.0f) {
                                if (scrollY2 != iAbs2 && !PDFViewCtrl.this.f1817cw && !this.f1932a) {
                                    this.f1932a = true;
                                    PDFViewCtrl.super.scrollTo(0, iAbs2);
                                }
                                this.f1933b = true;
                            }
                        } else if (f4 <= -3.0f && i10 + PDFViewCtrl.this.f1666aB >= PDFViewCtrl.this.getViewCanvasHeight() - 1.0f) {
                            if (scrollY2 != iAbs2 && !PDFViewCtrl.this.f1817cw && !this.f1932a) {
                                this.f1932a = true;
                                PDFViewCtrl.super.scrollTo(0, iAbs2);
                            }
                            this.f1933b = true;
                        }
                    } else if (f3 >= 3.0f) {
                        if (i9 <= 1.0f) {
                            if (scrollX2 != iAbs && !PDFViewCtrl.this.f1817cw && !this.f1932a) {
                                this.f1932a = true;
                                PDFViewCtrl.super.scrollTo(iAbs, 0);
                            }
                            this.f1933b = true;
                        }
                    } else if (f3 <= -3.0f && i9 + PDFViewCtrl.this.f1665aA >= PDFViewCtrl.this.getViewCanvasWidth() - 1.0f) {
                        if (scrollX2 != iAbs && !PDFViewCtrl.this.f1817cw && !this.f1932a) {
                            this.f1932a = true;
                            PDFViewCtrl.super.scrollTo(iAbs, 0);
                        }
                        this.f1933b = true;
                    }
                }
                if (this.f1933b) {
                    m1407c(this.f1947p);
                    if (m1403b(this.f1946o, this.f1947p)) {
                        m1407c(m1414d(this.f1947p));
                    }
                    if (m1410c(this.f1946o, this.f1947p)) {
                        m1407c(m1419e(this.f1947p));
                    }
                    PDFViewCtrl pDFViewCtrl8 = PDFViewCtrl.this;
                    if (PDFViewCtrl.m1257a(pDFViewCtrl8, pDFViewCtrl8.f1739bW)) {
                        if (f2 < 0.0f) {
                            this.f1955x = false;
                            if (iAbs2 > 0) {
                                int iMax = Math.max(-iAbs2, (int) f2);
                                this.f1953v += iMax;
                                i8 = iMax;
                            } else {
                                int i11 = this.f1946o;
                                if ((i11 == 1 || i11 == 2) && PDFViewCtrl.this.f1736bT != null) {
                                    PDFViewCtrl.this.f1736bT.onPullEdgeEffects(-1, Math.abs(f2) / PDFViewCtrl.this.f1666aB);
                                }
                                i8 = 0;
                            }
                            PDFViewCtrl.this.f1847h.startScroll(0, PDFViewCtrl.this.getScrollY(), 0, i8, 0);
                        } else if (f2 > 0.0f) {
                            this.f1955x = true;
                            if (PDFViewCtrl.this.f1817cw) {
                                i6 = (PDFViewCtrl.this.f1673aI - PDFViewCtrl.this.f1666aB) - ((int) PDFViewCtrl.this.f1800cf.f1942k);
                                scrollY = PDFViewCtrl.this.getScrollY();
                            } else {
                                i6 = (this.f1918B ? PDFViewCtrl.this.f1674aJ : PDFViewCtrl.this.f1673aI) - iAbs2;
                                scrollY = PDFViewCtrl.this.f1666aB;
                            }
                            int i12 = i6 - scrollY;
                            if (i12 > 0) {
                                int iMin = Math.min(i12, (int) f2);
                                this.f1953v += iMin;
                                i7 = iMin;
                            } else {
                                if (this.f1946o == this.f1948q && PDFViewCtrl.this.f1736bT != null) {
                                    PDFViewCtrl.this.f1736bT.onPullEdgeEffects(1, Math.abs(f2) / PDFViewCtrl.this.f1666aB);
                                    PDFViewCtrl.this.f1774cF.m1462a(true);
                                }
                                i7 = 0;
                            }
                            PDFViewCtrl.this.f1847h.startScroll(0, PDFViewCtrl.this.getScrollY(), 0, i7, 0);
                        } else {
                            z = false;
                            if (!this.f1917A && Math.abs(PDFViewCtrl.this.getScrollOffsetForCanvasId(this.f1957z) - PDFViewCtrl.this.getScrollY()) > PDFViewCtrl.this.f1666aB) {
                                this.f1917A = true;
                            }
                        }
                        z = true;
                        if (!this.f1917A) {
                            this.f1917A = true;
                        }
                    } else {
                        if (f < 0.0f) {
                            this.f1954w = false;
                            if (iAbs <= 0) {
                                if (PDFViewCtrl.this.f1805ck ? this.f1946o == this.f1948q : !((i5 = this.f1946o) != 1 && i5 != 2)) {
                                    if (PDFViewCtrl.this.f1736bT != null) {
                                        PDFViewCtrl.this.f1736bT.onPullEdgeEffects(-1, Math.abs(f) / PDFViewCtrl.this.f1665aA);
                                        if (PDFViewCtrl.this.f1805ck) {
                                            PDFViewCtrl.this.f1774cF.m1462a(true);
                                        }
                                    }
                                }
                                i4 = 0;
                            } else {
                                int iMax2 = Math.max(-iAbs, (int) f);
                                this.f1953v += iMax2;
                                i4 = iMax2;
                            }
                            PDFViewCtrl.this.f1846g.startScroll(PDFViewCtrl.this.getScrollX(), 0, i4, 0, 0);
                        } else if (f > 0.0f) {
                            this.f1954w = true;
                            if (PDFViewCtrl.this.f1817cw) {
                                i = (PDFViewCtrl.this.f1669aE - PDFViewCtrl.this.f1665aA) - ((int) PDFViewCtrl.this.f1800cf.f1942k);
                                scrollX = PDFViewCtrl.this.getScrollX();
                            } else {
                                i = (this.f1918B ? PDFViewCtrl.this.f1670aF : PDFViewCtrl.this.f1669aE) - iAbs;
                                scrollX = PDFViewCtrl.this.f1665aA;
                            }
                            int i13 = i - scrollX;
                            if (i13 <= 0) {
                                if (PDFViewCtrl.this.f1805ck ? (i2 = this.f1946o) == 1 || i2 == 2 : this.f1946o == this.f1948q) {
                                    if (PDFViewCtrl.this.f1736bT != null) {
                                        PDFViewCtrl.this.f1736bT.onPullEdgeEffects(1, Math.abs(f) / PDFViewCtrl.this.f1665aA);
                                        if (!PDFViewCtrl.this.f1805ck) {
                                            PDFViewCtrl.this.f1774cF.m1462a(true);
                                        }
                                    }
                                }
                                i3 = 0;
                            } else {
                                int iMin2 = Math.min(i13, (int) f);
                                this.f1953v += iMin2;
                                i3 = iMin2;
                            }
                            PDFViewCtrl.this.f1846g.startScroll(PDFViewCtrl.this.getScrollX(), 0, i3, 0, 0);
                        } else {
                            z = false;
                            if (!this.f1917A && Math.abs(PDFViewCtrl.this.getScrollOffsetForCanvasId(this.f1957z) - PDFViewCtrl.this.getScrollX()) > PDFViewCtrl.this.f1665aA) {
                                this.f1917A = true;
                            }
                        }
                        z = true;
                        if (!this.f1917A) {
                            this.f1917A = true;
                        }
                    }
                    if (!this.f1937f) {
                        PDFViewCtrl.this.f1725bI = PageChangeState.BEGIN;
                        PDFViewCtrl.this.f1831dk.removeMessages(0);
                        PDFViewCtrl.this.f1831dk.sendEmptyMessage(0);
                        this.f1937f = true;
                    }
                    if (this.f1951t <= 0) {
                        this.f1951t = 1;
                    }
                    int i14 = this.f1951t;
                    int i15 = this.f1948q;
                    if (i14 > i15) {
                        this.f1951t = i15;
                    }
                    z2 = z;
                }
                if (z2) {
                    PDFViewCtrl.this.invalidate();
                }
            }
            return z2;
        }

        /* JADX WARN: Removed duplicated region for block: B:114:0x01f3  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        final boolean m1450a(float f, float f2) {
            int scrollOffsetForCanvasId;
            int scrollY;
            boolean z = false;
            if (!this.f1922F || this.f1921E) {
                return false;
            }
            PDFViewCtrl.m1289ap(PDFViewCtrl.this);
            PDFViewCtrl pDFViewCtrl = PDFViewCtrl.this;
            if (PDFViewCtrl.m1257a(pDFViewCtrl, pDFViewCtrl.f1739bW)) {
                if (Math.abs(f2) <= this.f1943l) {
                    this.f1923G = true;
                    int width = PDFViewCtrl.this.getWidth();
                    int height = PDFViewCtrl.this.getHeight();
                    int scrollX = PDFViewCtrl.this.getScrollX();
                    int scrollY2 = PDFViewCtrl.this.getScrollY();
                    PDFViewCtrl pDFViewCtrl2 = PDFViewCtrl.this;
                    boolean zM1257a = PDFViewCtrl.m1257a(pDFViewCtrl2, pDFViewCtrl2.f1739bW);
                    if (zM1257a) {
                        scrollY2 = PDFViewCtrl.this.f1847h.computeScrollOffset() ? PDFViewCtrl.this.f1847h.getCurrY() : PDFViewCtrl.this.getScrollY();
                    } else {
                        scrollX = PDFViewCtrl.this.f1846g.computeScrollOffset() ? PDFViewCtrl.this.f1846g.getCurrX() : PDFViewCtrl.this.getScrollX();
                    }
                    int iM1419e = this.f1947p;
                    if (zM1257a) {
                        scrollY = scrollY2 - PDFViewCtrl.this.getScrollOffsetForCanvasId(iM1419e);
                        scrollOffsetForCanvasId = 0;
                    } else {
                        scrollOffsetForCanvasId = scrollX - PDFViewCtrl.this.getScrollOffsetForCanvasId(iM1419e);
                        scrollY = 0;
                    }
                    PagePresentationMode pagePresentationMode = PDFViewCtrl.this.getPagePresentationMode();
                    int i = (pagePresentationMode == PagePresentationMode.FACING || pagePresentationMode == PagePresentationMode.FACING_VERT) ? 2 : 1;
                    boolean z2 = !zM1257a ? PDFViewCtrl.this.f1805ck ? this.f1947p >= this.f1949r : this.f1947p <= i : this.f1947p <= i;
                    if (!zM1257a ? !(PDFViewCtrl.this.f1805ck ? this.f1947p <= i : this.f1947p >= this.f1948q) : this.f1947p < this.f1948q) {
                        z = true;
                    }
                    if (zM1257a) {
                        if (scrollY < 0 && z2 && Math.abs(scrollY) > height / 2) {
                            iM1419e = m1414d(iM1419e);
                        } else if (scrollY > 0 && z) {
                            if (PDFViewCtrl.this.f1817cw) {
                                scrollY = PDFViewCtrl.this.getScrollY() - PDFViewCtrl.this.f1800cf.f1925I;
                            }
                            if (scrollY > height / 2) {
                                iM1419e = m1419e(iM1419e);
                            }
                        }
                        m1395a(iM1419e, -1);
                    } else if (scrollOffsetForCanvasId < 0 && z2 && Math.abs(scrollOffsetForCanvasId) > width / 2) {
                        if (PDFViewCtrl.this.f1805ck) {
                            iM1419e = m1419e(iM1419e);
                        }
                        m1395a(iM1419e, -1);
                    } else {
                        if (scrollOffsetForCanvasId > 0 && z) {
                            if (PDFViewCtrl.this.f1817cw) {
                                scrollOffsetForCanvasId = PDFViewCtrl.this.getScrollX() - PDFViewCtrl.this.f1800cf.f1924H;
                            }
                            if (scrollOffsetForCanvasId > width / 2) {
                                if (!PDFViewCtrl.this.f1805ck) {
                                    iM1419e = m1419e(iM1419e);
                                }
                            }
                        }
                        m1395a(iM1419e, -1);
                    }
                } else if (f2 < 0.0f) {
                    this.f1955x = true;
                    if (m1409c()) {
                        int iM1418e = m1418e();
                        this.f1952u = iM1418e;
                        m1395a(iM1418e, -1);
                    }
                } else {
                    this.f1955x = false;
                    if (m1402b()) {
                        int iM1413d = m1413d();
                        this.f1952u = iM1413d;
                        m1395a(iM1413d, -1);
                    }
                }
            } else if (Math.abs(f) > this.f1943l) {
                if (f < 0.0f) {
                    this.f1954w = true;
                    if (!PDFViewCtrl.this.f1805ck) {
                        if (m1409c()) {
                            int iM1418e2 = m1418e();
                            this.f1952u = iM1418e2;
                            m1395a(iM1418e2, -1);
                        }
                    } else if (m1402b()) {
                        int iM1413d2 = m1413d();
                        this.f1952u = iM1413d2;
                        m1395a(iM1413d2, -1);
                    }
                } else {
                    this.f1954w = false;
                    if (!PDFViewCtrl.this.f1805ck) {
                        if (m1402b()) {
                            int iM1413d3 = m1413d();
                            this.f1952u = iM1413d3;
                            m1395a(iM1413d3, -1);
                        }
                    } else if (m1409c()) {
                        int iM1418e3 = m1418e();
                        this.f1952u = iM1418e3;
                        m1395a(iM1418e3, -1);
                    }
                }
            }
            this.f1921E = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public int m1393a(int i) {
            try {
                double[] dArrM1332e = PDFViewCtrl.this.m1332e(i);
                if (dArrM1332e != null) {
                    int length = dArrM1332e.length / 5;
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = (int) dArrM1332e[i2 * 5];
                        if (i3 < i) {
                            i = i3;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public int m1399b(int i) {
            try {
                double[] dArrM1332e = PDFViewCtrl.this.m1332e(i);
                if (dArrM1332e != null) {
                    int length = dArrM1332e.length / 5;
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = (int) dArrM1332e[i2 * 5];
                        if (i3 > i) {
                            i = i3;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return i;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x0060  */
        /* JADX INFO: renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void m1407c(int i) {
            if (PDFViewCtrl.this.mDoc == null || i <= 0 || i > this.f1949r || PDFViewCtrl.this.f1776cH.get(i) != null) {
                return;
            }
            try {
                double[] dArrM1332e = PDFViewCtrl.this.m1332e(i);
                if (dArrM1332e != null) {
                    int length = dArrM1332e.length / 5;
                    boolean z = true;
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = (int) dArrM1332e[i2 * 5];
                        PagePresentationMode pagePresentationMode = PDFViewCtrl.this.getPagePresentationMode();
                        if (pagePresentationMode == PagePresentationMode.SINGLE || pagePresentationMode == PagePresentationMode.SINGLE_VERT) {
                            if (i3 != i) {
                                z = false;
                            }
                        } else if (pagePresentationMode == PagePresentationMode.FACING || pagePresentationMode == PagePresentationMode.FACING_VERT) {
                            if (i3 > i || i3 < i - 1) {
                            }
                        } else if ((pagePresentationMode == PagePresentationMode.FACING_COVER || pagePresentationMode == PagePresentationMode.FACING_COVER_VERT) && (i3 > i || i3 < i - 1)) {
                        }
                    }
                    if (z) {
                        PDFViewCtrl.this.f1776cH.put(i, dArrM1332e);
                    }
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m1395a(int i, int i2) {
            this.f1933b = true;
            int curCanvasId = PDFViewCtrl.this.getCurCanvasId();
            if (PDFViewCtrl.this.f1817cw && curCanvasId != i) {
                PDFViewCtrl.this.f1818cx.put(curCanvasId, PDFViewCtrl.this.m1373q());
                PDFViewCtrl.this.f1819cy.put(curCanvasId, PDFViewCtrl.this.m1375r());
            }
            this.f1952u = Math.max(1, Math.min(i, this.f1949r));
            this.f1950s = Math.max(1, Math.min(i, this.f1948q));
            if (this.f1952u == this.f1957z) {
                this.f1950s = this.f1956y;
            }
            int scrollX = PDFViewCtrl.this.getScrollX();
            int scrollY = PDFViewCtrl.this.getScrollY();
            PDFViewCtrl pDFViewCtrl = PDFViewCtrl.this;
            if (PDFViewCtrl.m1257a(pDFViewCtrl, pDFViewCtrl.f1739bW)) {
                scrollY = PDFViewCtrl.this.f1847h.computeScrollOffset() ? PDFViewCtrl.this.f1847h.getCurrY() : PDFViewCtrl.this.getScrollY();
                this.f1927K = PDFViewCtrl.this.getScrollOffsetForCanvasId(this.f1952u);
            } else {
                scrollX = PDFViewCtrl.this.f1846g.computeScrollOffset() ? PDFViewCtrl.this.f1846g.getCurrX() : PDFViewCtrl.this.getScrollX();
                this.f1926J = PDFViewCtrl.this.getScrollOffsetForCanvasId(this.f1952u);
            }
            int i3 = scrollX;
            int i4 = scrollY;
            if (!this.f1934c) {
                this.f1928L = curCanvasId;
            }
            if (PDFViewCtrl.this.f1817cw) {
                if (this.f1947p == this.f1952u) {
                    PagePresentationMode pagePresentationMode = PDFViewCtrl.this.getPagePresentationMode();
                    int i5 = (pagePresentationMode == PagePresentationMode.FACING || pagePresentationMode == PagePresentationMode.FACING_COVER || pagePresentationMode == PagePresentationMode.FACING_VERT || pagePresentationMode == PagePresentationMode.FACING_COVER_VERT) ? 2 : 1;
                    if (PDFViewCtrl.m1257a(PDFViewCtrl.this, pagePresentationMode)) {
                        int scrollOffsetForCanvasId = PDFViewCtrl.this.getScrollOffsetForCanvasId(this.f1947p + i5);
                        if (Math.abs(i4 - PDFViewCtrl.this.getScrollOffsetForCanvasId(this.f1947p)) > Math.abs((PDFViewCtrl.this.f1666aB + i4) - scrollOffsetForCanvasId)) {
                            this.f1927K = (scrollOffsetForCanvasId - PDFViewCtrl.this.f1666aB) - ((int) PDFViewCtrl.this.f1800cf.f1942k);
                        }
                    } else {
                        int i6 = this.f1947p;
                        if (PDFViewCtrl.this.f1805ck) {
                            i5 = -i5;
                        }
                        int scrollOffsetForCanvasId2 = PDFViewCtrl.this.getScrollOffsetForCanvasId(i6 + i5);
                        if (Math.abs(i3 - PDFViewCtrl.this.getScrollOffsetForCanvasId(this.f1947p)) > Math.abs((PDFViewCtrl.this.f1665aA + i3) - scrollOffsetForCanvasId2)) {
                            this.f1926J = (scrollOffsetForCanvasId2 - PDFViewCtrl.this.f1665aA) - ((int) PDFViewCtrl.this.f1800cf.f1942k);
                        }
                    }
                } else {
                    PDFViewCtrl pDFViewCtrl2 = PDFViewCtrl.this;
                    if (PDFViewCtrl.m1257a(pDFViewCtrl2, pDFViewCtrl2.f1739bW)) {
                        int i7 = this.f1947p;
                        if (i7 > this.f1952u) {
                            this.f1927K = (PDFViewCtrl.this.getScrollOffsetForCanvasId(i7) - PDFViewCtrl.this.f1666aB) - ((int) PDFViewCtrl.this.f1800cf.f1942k);
                        }
                    } else if ((this.f1947p > this.f1952u && !PDFViewCtrl.this.f1805ck) || (this.f1947p < this.f1952u && PDFViewCtrl.this.f1805ck)) {
                        this.f1926J = (PDFViewCtrl.this.getScrollOffsetForCanvasId(this.f1947p) - PDFViewCtrl.this.f1665aA) - ((int) PDFViewCtrl.this.f1800cf.f1942k);
                    }
                }
            }
            PDFViewCtrl pDFViewCtrl3 = PDFViewCtrl.this;
            if (PDFViewCtrl.m1257a(pDFViewCtrl3, pDFViewCtrl3.f1739bW)) {
                int i8 = this.f1927K - i4;
                if (i2 < 0) {
                    i2 = Math.min(1000, (int) ((Math.abs(i8) / PDFViewCtrl.this.getHeight()) * this.f1944m));
                }
                PDFViewCtrl.this.f1847h.startScroll(0, i4, 0, i8, i2);
            } else {
                int i9 = this.f1926J - i3;
                if (i2 < 0) {
                    i2 = Math.min(1000, (int) ((Math.abs(i9) / PDFViewCtrl.this.getWidth()) * this.f1944m));
                }
                PDFViewCtrl.this.f1846g.startScroll(i3, 0, i9, 0, i2);
            }
            this.f1934c = true;
            m1407c(this.f1952u);
            int i10 = this.f1952u;
            if (m1403b(i10, i10)) {
                m1407c(m1414d(this.f1952u));
            }
            int i11 = this.f1952u;
            if (m1410c(i11, i11)) {
                m1407c(m1419e(this.f1952u));
            }
            int i12 = this.f1947p;
            int i13 = this.f1952u;
            if (i12 != i13) {
                m1407c(i13);
                int i14 = this.f1947p;
                if (m1403b(i14, i14)) {
                    m1407c(m1414d(this.f1947p));
                }
                int i15 = this.f1947p;
                if (m1410c(i15, i15)) {
                    m1407c(m1419e(this.f1947p));
                }
            }
            PDFViewCtrl.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public boolean m1403b(int i, int i2) {
            if (this.f1948q <= 1) {
                return false;
            }
            PagePresentationMode pagePresentationMode = PDFViewCtrl.this.getPagePresentationMode();
            return (pagePresentationMode == PagePresentationMode.SINGLE || pagePresentationMode == PagePresentationMode.SINGLE_VERT) ? i > 1 : (pagePresentationMode == PagePresentationMode.FACING || pagePresentationMode == PagePresentationMode.FACING_VERT) ? this.f1948q > 2 && i2 > 2 : (pagePresentationMode == PagePresentationMode.FACING_COVER || pagePresentationMode == PagePresentationMode.FACING_COVER_VERT) && i2 >= 2;
        }

        /* JADX INFO: renamed from: b */
        private boolean m1402b() {
            return m1403b(this.f1946o, this.f1947p);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: c */
        public boolean m1410c(int i, int i2) {
            if (this.f1948q <= 1) {
                return false;
            }
            PagePresentationMode pagePresentationMode = PDFViewCtrl.this.getPagePresentationMode();
            if (pagePresentationMode == PagePresentationMode.SINGLE || pagePresentationMode == PagePresentationMode.SINGLE_VERT) {
                return i < this.f1948q;
            }
            if (pagePresentationMode != PagePresentationMode.FACING && pagePresentationMode != PagePresentationMode.FACING_VERT) {
                return (pagePresentationMode == PagePresentationMode.FACING_COVER || pagePresentationMode == PagePresentationMode.FACING_COVER_VERT) && i2 < this.f1948q;
            }
            int i3 = this.f1948q;
            return i3 > 2 && i2 < i3;
        }

        /* JADX INFO: renamed from: c */
        private boolean m1409c() {
            return m1410c(this.f1946o, this.f1947p);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0027, code lost:
        
            r0 = r3 - 2;
         */
        /* JADX INFO: renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int m1414d(int i) {
            int i2;
            PagePresentationMode pagePresentationMode = PDFViewCtrl.this.getPagePresentationMode();
            if (pagePresentationMode == PagePresentationMode.SINGLE || pagePresentationMode == PagePresentationMode.SINGLE_VERT) {
                i2 = i > 1 ? i - 1 : i;
            } else if (pagePresentationMode != PagePresentationMode.FACING) {
            }
            return i2 < 0 ? i : i2;
        }

        /* JADX INFO: renamed from: d */
        private int m1413d() {
            return m1414d(this.f1947p);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: e */
        public int m1419e(int i) {
            PagePresentationMode pagePresentationMode = PDFViewCtrl.this.getPagePresentationMode();
            int pageCount = PDFViewCtrl.this.getPageCount();
            if (pagePresentationMode == PagePresentationMode.SINGLE || pagePresentationMode == PagePresentationMode.SINGLE_VERT) {
                return i < pageCount ? i + 1 : i;
            }
            if (pagePresentationMode == PagePresentationMode.FACING || pagePresentationMode == PagePresentationMode.FACING_VERT) {
                if (i >= pageCount) {
                    return i;
                }
                int i2 = i + 2;
                return i2 > pageCount ? !PDFViewCtrl.m1336f(PDFViewCtrl.this, this.f1948q) ? pageCount + 1 : pageCount : i2;
            }
            if ((pagePresentationMode != PagePresentationMode.FACING_COVER && pagePresentationMode != PagePresentationMode.FACING_COVER_VERT) || i >= pageCount) {
                return i;
            }
            int i3 = i + 2;
            return i3 > pageCount ? PDFViewCtrl.m1336f(PDFViewCtrl.this, this.f1948q) ? pageCount + 1 : pageCount : i3;
        }

        /* JADX INFO: renamed from: e */
        private int m1418e() {
            return m1419e(this.f1947p);
        }

        /* JADX INFO: renamed from: s */
        static /* synthetic */ void m1440s(C6946j c6946j) throws Throwable {
            OverScroller overScrollerM1339g = PDFViewCtrl.this.m1339g();
            if (!overScrollerM1339g.isFinished()) {
                overScrollerM1339g.abortAnimation();
            }
            c6946j.f1933b = false;
            c6946j.f1934c = false;
            c6946j.f1918B = false;
            c6946j.f1919C = false;
            c6946j.f1920D = false;
            c6946j.f1932a = false;
            c6946j.f1923G = false;
            c6946j.f1922F = false;
            c6946j.f1924H = 0;
            c6946j.f1925I = 0;
            if (PDFViewCtrl.this.f1730bN != null) {
                Iterator it = PDFViewCtrl.this.f1730bN.iterator();
                while (it.hasNext()) {
                    ((PageSlidingListener) it.next()).onScrollOffsetChanged(c6946j.f1924H, c6946j.f1925I);
                }
            }
            c6946j.f1953v = 0;
            PDFViewCtrl.this.f1725bI = PageChangeState.END;
            PDFViewCtrl.this.f1831dk.removeMessages(0);
            PDFViewCtrl.this.f1831dk.sendEmptyMessage(0);
            c6946j.f1937f = false;
            PDFViewCtrl.this.f1776cH.clear();
            PDFViewCtrl.this.f1774cF.m1463b();
            PDFViewCtrl.this.invalidate();
        }
    }

    public void docLockRead(LockRunnable lockRunnable) throws Exception {
        boolean z;
        try {
            docLockRead();
            try {
                lockRunnable.run();
                docUnlockRead();
            } catch (Throwable th) {
                th = th;
                z = true;
                if (z) {
                    docUnlockRead();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    public void docLock(boolean z, LockRunnable lockRunnable) throws Exception {
        boolean z2;
        try {
            docLock(z);
            try {
                lockRunnable.run();
                docUnlock();
            } catch (Throwable th) {
                th = th;
                z2 = true;
                if (z2) {
                    docUnlock();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public long m1303b() {
        long jMaxMemory = Runtime.getRuntime().maxMemory();
        if (f1640b) {
            m1239a(1, "getAllowedMaxHeapSize: " + jMaxMemory, m1230a(true));
        }
        long jFreeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (f1640b) {
            m1239a(1, "getAllocatedHeapSize: " + jFreeMemory, m1230a(true));
        }
        long j = jMaxMemory - jFreeMemory;
        if (j < 10485760) {
            j = 0;
        }
        if (f1640b) {
            m1239a(1, "getAvailableHeapSize: " + j, m1230a(true));
        }
        return j;
    }

    public void findText(String str, boolean z, boolean z2, boolean z3, boolean z4, int i) {
        StringBuilder sb = new StringBuilder(str);
        if (Bidi.requiresBidi(str.toCharArray(), 0, str.length())) {
            Bidi bidi = new Bidi(str, -2);
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < bidi.getRunCount(); i2++) {
                String strSubstring = str.substring(bidi.getRunStart(i2), bidi.getRunLimit(i2));
                if (bidi.getRunLevel(i2) % 2 == 1) {
                    strSubstring = new StringBuffer(strSubstring).reverse().toString();
                }
                sb2.append(strSubstring);
            }
            sb = sb2;
        }
        String string = sb.toString();
        cancelFindText();
        if (this.mDoc == null) {
            TextSearchListener textSearchListener = this.f1717bA;
            if (textSearchListener != null) {
                textSearchListener.onTextSearchEnd(TextSearchResult.INVALID_INPUT);
            }
            ArrayList<TextSearchListener> arrayList = this.f1718bB;
            if (arrayList != null) {
                Iterator<TextSearchListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onTextSearchEnd(TextSearchResult.INVALID_INPUT);
                }
                return;
            }
            return;
        }
        synchronized (this) {
            this.f1766bx++;
        }
        TextSearchListener textSearchListener2 = this.f1717bA;
        if (textSearchListener2 != null) {
            textSearchListener2.onTextSearchStart();
        }
        ArrayList<TextSearchListener> arrayList2 = this.f1718bB;
        if (arrayList2 != null) {
            Iterator<TextSearchListener> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onTextSearchStart();
            }
        }
        Thread thread = new Thread(new Runnable() { // from class: com.pdftron.pdf.PDFViewCtrl.2
            @Override // java.lang.Runnable
            public final void run() {
                while (PDFViewCtrl.this.f1766bx > 0) {
                    try {
                        Thread.sleep(50L);
                        PDFViewCtrl.this.f1842dv.sendEmptyMessage(0);
                    } catch (InterruptedException unused) {
                        return;
                    }
                }
            }
        });
        this.f1843dw = thread;
        thread.start();
        try {
            FindTextAsync(this.f1823dc, string, z, z2, z3, z4, i);
        } catch (Exception unused) {
            synchronized (this) {
                this.f1768bz = z4;
            }
        }
    }

    /* JADX INFO: renamed from: h */
    static /* synthetic */ void m1346h(PDFViewCtrl pDFViewCtrl) {
        pDFViewCtrl.m1315c();
        pDFViewCtrl.setHScrollPos(pDFViewCtrl.m1373q());
        pDFViewCtrl.setVScrollPos(pDFViewCtrl.m1375r());
        double dM1357k = pDFViewCtrl.m1357k();
        pDFViewCtrl.f1752bj = dM1357k;
        pDFViewCtrl.f1753bk = pDFViewCtrl.m1225a(dM1357k);
        pDFViewCtrl.f1774cF.m1464c();
        pDFViewCtrl.requestRendering();
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m1247a(PDFViewCtrl pDFViewCtrl, long j) {
        try {
            DownloaderFinishedDownload(pDFViewCtrl.f1823dc, j);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ byte[] m1260a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX INFO: renamed from: L */
    static /* synthetic */ void m1210L(PDFViewCtrl pDFViewCtrl) {
        try {
            if (pDFViewCtrl.f1654M && pDFViewCtrl.getColorPostProcessMode() == 0) {
                DoProgressiveRender(pDFViewCtrl.f1823dc);
            }
        } catch (Exception unused) {
        } catch (OutOfMemoryError unused2) {
            if (f1640b) {
                m1239a(4, "progressive render ran out of memory", m1230a(true));
            } else {
                Log.e("PDFNet", "progressive render ran out of memory");
            }
            pDFViewCtrl.f1829di.m1452a();
        }
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ void m1306b(PDFViewCtrl pDFViewCtrl, long j, int i, int i2) {
        try {
            DownloaderUpdateThumb(pDFViewCtrl.f1823dc, j, i, i2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: c */
    static /* synthetic */ void m1317c(PDFViewCtrl pDFViewCtrl, long j) {
        try {
            DownloaderUpdateOutline(pDFViewCtrl.f1823dc, j);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: d */
    static /* synthetic */ void m1324d(PDFViewCtrl pDFViewCtrl, long j) {
        try {
            DownloaderOpened(pDFViewCtrl.f1823dc, j);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: e */
    static /* synthetic */ void m1327e(PDFViewCtrl pDFViewCtrl, long j) throws PDFNetException {
        PDFDoc pDFDoc = pDFViewCtrl.mDoc;
        if (pDFDoc == null) {
            pDFViewCtrl.m1244a(PDFDoc.__Create(j), true);
        } else {
            pDFViewCtrl.m1244a(pDFDoc, true);
        }
        if (pDFViewCtrl.mDoc == null) {
            throw new PDFNetException("Unknown", 0L, "com.pdftron.pdf.PDFViewCtrl", "openURL()", "openURL(): unknow error, missing password?");
        }
        pDFViewCtrl.f1803ci = pDFViewCtrl.getPageCount();
    }

    /* JADX INFO: renamed from: an */
    static /* synthetic */ float m1287an(PDFViewCtrl pDFViewCtrl) {
        return (float) GetFindTextProgress(pDFViewCtrl.f1823dc);
    }

    /* JADX INFO: renamed from: ap */
    static /* synthetic */ void m1289ap(PDFViewCtrl pDFViewCtrl) {
        ToolManager toolManager = pDFViewCtrl.f1736bT;
        if (toolManager != null) {
            toolManager.onReleaseEdgeEffects();
        }
    }
}

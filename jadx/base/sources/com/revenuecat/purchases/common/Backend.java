package com.revenuecat.purchases.common;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.ReplacementModeKt;
import com.revenuecat.purchases.RewardVerificationError;
import com.revenuecat.purchases.RewardVerificationPollStatus;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.caching.WorkflowMetadata;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.events.EventsRequest;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPRequest;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.PostReceiptResponse;
import com.revenuecat.purchases.common.networking.PostReceiptResponseKt;
import com.revenuecat.purchases.common.networking.RCContainer;
import com.revenuecat.purchases.common.networking.RCContainerFormatException;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.networking.RewardVerificationResponse;
import com.revenuecat.purchases.common.networking.WebBillingProductsResponse;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfigFetchContext;
import com.revenuecat.purchases.common.remoteconfig.RemoteConfiguration;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.common.workflows.WorkflowScreenType;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterRoot;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.JsonElementExtensionsKt;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrenciesFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Backend.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000¦\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 Í\u00012\u00020\u0001:\u0002Í\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ<\u0010\u007f\u001a\u00020\u00152\u0007\u0010\u0080\u0001\u001a\u00020\u00102\u0007\u0010\u0081\u0001\u001a\u00020\u00102\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0013\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u0016J\u0007\u0010\u0084\u0001\u001a\u00020\u0015J\u0007\u0010\u0085\u0001\u001a\u00020\u0015J\u001c\u0010\u0086\u0001\u001a\u00020K2\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u0017H\u0002J:\u0010\u008a\u0001\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020\u00102\u0013\u0010\u0082\u0001\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00150\u00162\u0013\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u0016JX\u0010\u008c\u0001\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020\u00102\u0007\u0010\u008d\u0001\u001a\u00020!2\u0013\u0010\u008e\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00150\u00162(\u0010\u008f\u0001\u001a#\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00150 Jh\u0010\u0090\u0001\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020\u00102\u0007\u0010\u008d\u0001\u001a\u00020!22\u0010\u008e\u0001\u001a-\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020<\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u00150;j\u0002`>2\u0019\u0010\u008f\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00150 J1\u0010\u0091\u0001\u001a\u00020\u00152\u0013\u0010\u0082\u0001\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\u00150\u00162\u0013\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u0016J\u0091\u0001\u0010\u0092\u0001\u001a\u00020\u00152\u0007\u0010\u008d\u0001\u001a\u00020!2\u0007\u0010\u008b\u0001\u001a\u00020\u00102\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u00102\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00102\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010^2\r\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2#\u0010\u008e\u0001\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010]\u0012\u0006\u0012\u0004\u0018\u00010^\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00150;2\u0019\u0010\u008f\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020\u00150 JI\u0010\u0099\u0001\u001a\u00020\u00152\u0007\u0010\u008d\u0001\u001a\u00020!2\u0007\u0010\u0095\u0001\u001a\u00020\u00102\u0019\u0010\u008e\u0001\u001a\u0014\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00150 2\u0013\u0010\u008f\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u0016JC\u0010\u009a\u0001\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020\u00102\u0007\u0010\u009b\u0001\u001a\u00020\u00102\u0013\u0010\u008e\u0001\u001a\u000e\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020\u00150\u00162\u0013\u0010\u008f\u0001\u001a\u000e\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020\u00150\u0016JC\u0010\u009c\u0001\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020\u00102\u0007\u0010\u008d\u0001\u001a\u00020!2\u0013\u0010\u008e\u0001\u001a\u000e\u0012\u0004\u0012\u00020u\u0012\u0004\u0012\u00020\u00150\u00162\u0013\u0010\u008f\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u0016JJ\u0010\u009d\u0001\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020\u00102\u000e\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u00020\u00100\u009f\u00012\u0013\u0010\u008e\u0001\u001a\u000e\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\u00150\u00162\u0013\u0010\u008f\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u0016JI\u0010 \u0001\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020\u00102\u0007\u0010\u0081\u0001\u001a\u00020\u00102\u0019\u0010\u0082\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00150 2\u0013\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u0016JL\u0010¡\u0001\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020\u00102\u0007\u0010¢\u0001\u001a\u00020\u00102\u0007\u0010£\u0001\u001a\u00020\u00102\u0013\u0010\u0082\u0001\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00150\u00162\u0013\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u0016JF\u0010¤\u0001\u001a\u00020\u00152\r\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u0002020\u000f2\u0013\u0010\u0082\u0001\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u00150\u00162\u0019\u0010\u0083\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00150 Jo\u0010¦\u0001\u001a\u00020\u00152\b\u0010§\u0001\u001a\u00030¨\u00012\b\u0010©\u0001\u001a\u00030ª\u00012\b\u0010«\u0001\u001a\u00030¬\u00012\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150\u001429\u0010\u0083\u0001\u001a4\u0012\u0014\u0012\u00120\u0017¢\u0006\r\b\"\u0012\t\b#\u0012\u0005\b\b(\u00ad\u0001\u0012\u0014\u0012\u00120!¢\u0006\r\b\"\u0012\t\b#\u0012\u0005\b\b(®\u0001\u0012\u0004\u0012\u00020\u00150 Jæ\u0001\u0010¯\u0001\u001a\u00020\u00152\u0007\u0010°\u0001\u001a\u00020\u00102\u0007\u0010\u008b\u0001\u001a\u00020\u00102\u0007\u0010±\u0001\u001a\u00020!2\u0007\u0010²\u0001\u001a\u00020!2#\u0010³\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010´\u00010´\u00012\b\u0010µ\u0001\u001a\u00030¶\u00012\b\u0010·\u0001\u001a\u00030¸\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010º\u00012\f\b\u0002\u0010»\u0001\u001a\u0005\u0018\u00010¼\u00012\b\u0010½\u0001\u001a\u00030¾\u00012\u0017\u0010\u008e\u0001\u001a\u0012\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00150\u0016j\u0002`J2C\u0010\u008f\u0001\u001a>\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110K¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(L\u0012\u0015\u0012\u0013\u0018\u000102¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020\u00150;j\u0002`NJ.\u0010¿\u0001\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020\u00102\u0007\u0010À\u0001\u001a\u00020\u00102\u0013\u0010Á\u0001\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00150\u0016Jy\u0010Â\u0001\u001a\u00020\u0015\"\u0005\b\u0000\u0010Ã\u0001\"\u0005\b\u0001\u0010Ä\u0001*\"\u0012\u0004\u0012\u00020\u001e\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u0003HÃ\u0001\u0012\u0005\u0012\u0003HÄ\u00010\u00130\u00120\u000e2\b\u0010Å\u0001\u001a\u00030Æ\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0007\u0010Ç\u0001\u001a\u00020\u001e2\u0015\u0010È\u0001\u001a\u0010\u0012\u0005\u0012\u0003HÃ\u0001\u0012\u0005\u0012\u0003HÄ\u00010\u00132\n\b\u0002\u0010«\u0001\u001a\u00030¬\u0001H\u0002Jg\u0010É\u0001\u001a\u00020\u0015\"\u0005\b\u0000\u0010Ê\u0001\"\u0005\b\u0001\u0010Ë\u0001*\u0016\u0012\u0005\u0012\u0003HÊ\u0001\u0012\u000b\u0012\t\u0012\u0005\u0012\u0003HË\u00010\u00120\u000e2\b\u0010Å\u0001\u001a\u00030Æ\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010Ç\u0001\u001a\u0003HÊ\u00012\b\u0010È\u0001\u001a\u0003HË\u00012\n\b\u0002\u0010«\u0001\u001a\u00030¬\u0001H\u0002¢\u0006\u0003\u0010Ì\u0001R¢\u0001\u0010\u0019\u001a@\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011\u0012,\u0012*\u0012&\u0012$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`\u00180\u00120\u000e2D\u0010\r\u001a@\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011\u0012,\u0012*\u0012&\u0012$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`\u00180\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000RÄ\u0001\u0010&\u001aQ\u0012\u0004\u0012\u00020\u001e\u0012G\u0012E\u0012A\u0012?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00150\u0016\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00150 0\u0013j\u0002`%0\u00120\u000e2U\u0010\r\u001aQ\u0012\u0004\u0012\u00020\u001e\u0012G\u0012E\u0012A\u0012?\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00150\u0016\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00150 0\u0013j\u0002`%0\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001dR\u009a\u0001\u0010*\u001a<\u0012\u0004\u0012\u00020\u0010\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`)0\u00120\u000e2@\u0010\r\u001a<\u0012\u0004\u0012\u00020\u0010\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`)0\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u009a\u0001\u0010/\u001a<\u0012\u0004\u0012\u00020\u0010\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`.0\u00120\u000e2@\u0010\r\u001a<\u0012\u0004\u0012\u00020\u0010\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`.0\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dRº\u0001\u00104\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011\u00128\u00126\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00150 0\u0013j\u0002`30\u00120\u000e2P\u0010\r\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011\u00128\u00126\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00150 0\u0013j\u0002`30\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000Rº\u0001\u00108\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011\u00128\u00126\u00122\u00120\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00150 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`70\u00120\u000e2P\u0010\r\u001aL\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011\u00128\u00126\u00122\u00120\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00150 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`70\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010\u001dR\u0082\u0002\u0010B\u001ap\u0012\u0004\u0012\u00020\u001e\u0012f\u0012d\u0012`\u0012^\u0012/\u0012-\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020<\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u00150;j\u0002`>\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110?¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u00150 0\u0013j\u0002`A0\u00120\u000e2t\u0010\r\u001ap\u0012\u0004\u0012\u00020\u001e\u0012f\u0012d\u0012`\u0012^\u0012/\u0012-\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020<\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u00150;j\u0002`>\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110?¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u00150 0\u0013j\u0002`A0\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001b\"\u0004\bD\u0010\u001dR®\u0001\u0010F\u001aF\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011\u00122\u00120\u0012,\u0012*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00150 0\u0013j\u0002`E0\u00120\u000e2J\u0010\r\u001aF\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011\u00122\u00120\u0012,\u0012*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00150 0\u0013j\u0002`E0\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001b\"\u0004\bH\u0010\u001dR\u0096\u0002\u0010P\u001az\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011\u0012f\u0012d\u0012`\u0012^\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00150\u0016j\u0002`J\u0012@\u0012>\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110K¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(L\u0012\u0015\u0012\u0013\u0018\u000102¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020\u00150;j\u0002`N0\u0013j\u0002`O0\u00120\u000e2~\u0010\r\u001az\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011\u0012f\u0012d\u0012`\u0012^\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00150\u0016j\u0002`J\u0012@\u0012>\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110K¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(L\u0012\u0015\u0012\u0013\u0018\u000102¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020\u00150;j\u0002`N0\u0013j\u0002`O0\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001b\"\u0004\bR\u0010\u001dR\u009a\u0001\u0010U\u001a<\u0012\u0004\u0012\u00020\u0010\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`T0\u00120\u000e2@\u0010\r\u001a<\u0012\u0004\u0012\u00020\u0010\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`T0\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u001b\"\u0004\bW\u0010\u001dRj\u0010Z\u001a$\u0012\u0004\u0012\u00020\u0010\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00150\u0016j\u0002`Y0\u00120\u000e2(\u0010\r\u001a$\u0012\u0004\u0012\u00020\u0010\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00150\u0016j\u0002`Y0\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u001b\"\u0004\b\\\u0010\u001dR\u0082\u0002\u0010c\u001ap\u0012\u0004\u0012\u00020\u001e\u0012f\u0012d\u0012`\u0012^\u0012/\u0012-\u0012\u0006\u0012\u0004\u0018\u00010]\u0012\u0015\u0012\u0013\u0018\u00010^¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00150;\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110a¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u00150 0\u0013j\u0002`b0\u00120\u000e2t\u0010\r\u001ap\u0012\u0004\u0012\u00020\u001e\u0012f\u0012d\u0012`\u0012^\u0012/\u0012-\u0012\u0006\u0012\u0004\u0018\u00010]\u0012\u0015\u0012\u0013\u0018\u00010^¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00150;\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110a¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u00150 0\u0013j\u0002`b0\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u001b\"\u0004\be\u0010\u001dR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R¦\u0001\u0010h\u001aB\u0012\u0004\u0012\u00020\u001e\u00128\u00126\u00122\u00120\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00150 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`g0\u00120\u000e2F\u0010\r\u001aB\u0012\u0004\u0012\u00020\u001e\u00128\u00126\u00122\u00120\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00150 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`g0\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u001b\"\u0004\bj\u0010\u001dR\u009a\u0001\u0010n\u001a<\u0012\u0004\u0012\u00020\u001e\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`m0\u00120\u000e2@\u0010\r\u001a<\u0012\u0004\u0012\u00020\u001e\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`m0\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u001b\"\u0004\bp\u0010\u001dR\u0011\u0010q\u001a\u00020r8F¢\u0006\u0006\u001a\u0004\bs\u0010tR\u009a\u0001\u0010w\u001a<\u0012\u0004\u0012\u00020\u001e\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020u\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`v0\u00120\u000e2@\u0010\r\u001a<\u0012\u0004\u0012\u00020\u001e\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020u\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`v0\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u001b\"\u0004\by\u0010\u001dR\u009a\u0001\u0010|\u001a<\u0012\u0004\u0012\u00020\u0010\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`{0\u00120\u000e2@\u0010\r\u001a<\u0012\u0004\u0012\u00020\u0010\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020\u00150\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00160\u0013j\u0002`{0\u00120\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u001b\"\u0004\b~\u0010\u001d¨\u0006Î\u0001"}, m1599d2 = {"Lcom/revenuecat/purchases/common/Backend;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "eventsDispatcher", "httpClient", "Lcom/revenuecat/purchases/common/HTTPClient;", "backendHelper", "Lcom/revenuecat/purchases/common/BackendHelper;", "remoteConfigDispatcher", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/HTTPClient;Lcom/revenuecat/purchases/common/BackendHelper;Lcom/revenuecat/purchases/common/Dispatcher;)V", "<set-?>", "", "", "", "Lcom/revenuecat/purchases/common/CallbackCacheKey;", "", "Lkotlin/Pair;", "Lkotlin/Function0;", "", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/common/AliasCallback;", "aliasCallbacks", "getAliasCallbacks", "()Ljava/util/Map;", "setAliasCallbacks", "(Ljava/util/Map;)V", "Lcom/revenuecat/purchases/common/BackgroundAwareCallbackCacheKey;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isServerError", "Lcom/revenuecat/purchases/common/CustomerInfoCallback;", "callbacks", "getCallbacks", "setCallbacks", "Lcom/revenuecat/purchases/common/CreateSupportTicketCallback;", "createSupportTicketCallbacks", "getCreateSupportTicketCallbacks", "setCreateSupportTicketCallbacks", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "Lcom/revenuecat/purchases/common/CustomerCenterCallback;", "customerCenterCallbacks", "getCustomerCenterCallbacks", "setCustomerCenterCallbacks", "Lorg/json/JSONObject;", "Lcom/revenuecat/purchases/common/DiagnosticsCallback;", "diagnosticsCallbacks", "getDiagnosticsCallbacks", "setDiagnosticsCallbacks", "Lcom/revenuecat/purchases/common/IdentifyCallback;", "identifyCallbacks", "getIdentifyCallbacks", "setIdentifyCallbacks", "Lkotlin/Function3;", "Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;", "responsePayload", "Lcom/revenuecat/purchases/common/OfferingsSuccessCallback;", "Lcom/revenuecat/purchases/common/GetOfferingsErrorHandlingBehavior;", "errorHandlingBehavior", "Lcom/revenuecat/purchases/common/OfferingsCallback;", "offeringsCallbacks", "getOfferingsCallbacks", "setOfferingsCallbacks", "Lcom/revenuecat/purchases/common/PaywallEventsCallback;", "paywallEventsCallbacks", "getPaywallEventsCallbacks", "setPaywallEventsCallbacks", "Lcom/revenuecat/purchases/common/networking/PostReceiptResponse;", "Lcom/revenuecat/purchases/common/PostReceiptDataSuccessCallback;", "Lcom/revenuecat/purchases/common/PostReceiptErrorHandlingBehavior;", "postReceiptErrorHandlingBehavior", TtmlNode.TAG_BODY, "Lcom/revenuecat/purchases/common/PostReceiptDataErrorCallback;", "Lcom/revenuecat/purchases/common/PostReceiptCallback;", "postReceiptCallbacks", "getPostReceiptCallbacks", "setPostReceiptCallbacks", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "Lcom/revenuecat/purchases/common/ProductEntitlementCallback;", "productEntitlementCallbacks", "getProductEntitlementCallbacks", "setProductEntitlementCallbacks", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result;", "Lcom/revenuecat/purchases/common/RedeemWebPurchaseCallback;", "redeemWebPurchaseCallbacks", "getRedeemWebPurchaseCallbacks", "setRedeemWebPurchaseCallbacks", "Lcom/revenuecat/purchases/common/networking/RCContainer;", "Ljava/util/Date;", "requestDate", "Lcom/revenuecat/purchases/VerificationResult;", "Lcom/revenuecat/purchases/common/GetRemoteConfigErrorHandlingBehavior;", "Lcom/revenuecat/purchases/common/RemoteConfigCallback;", "remoteConfigCallbacks", "getRemoteConfigCallbacks", "setRemoteConfigCallbacks", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfiguration;", "Lcom/revenuecat/purchases/common/RemoteConfigFallbackCallback;", "remoteConfigFallbackCallbacks", "getRemoteConfigFallbackCallbacks", "setRemoteConfigFallbackCallbacks", "Lcom/revenuecat/purchases/RewardVerificationPollStatus;", "Lcom/revenuecat/purchases/RewardVerificationError;", "Lcom/revenuecat/purchases/common/RewardVerificationResultCallback;", "rewardVerificationResultCallbacks", "getRewardVerificationResultCallbacks", "setRewardVerificationResultCallbacks", "verificationMode", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "getVerificationMode", "()Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "Lcom/revenuecat/purchases/common/VirtualCurrenciesCallback;", "virtualCurrenciesCallbacks", "getVirtualCurrenciesCallbacks", "setVirtualCurrenciesCallbacks", "Lcom/revenuecat/purchases/common/networking/WebBillingProductsResponse;", "Lcom/revenuecat/purchases/common/WebBillingProductsCallback;", "webBillingProductsCallbacks", "getWebBillingProductsCallbacks", "setWebBillingProductsCallbacks", "aliasUsers", "oldAppUserID", "newAppUserID", "onSuccessHandler", "onErrorHandler", "clearCaches", "close", "determinePostReceiptErrorHandlingBehavior", "responseCode", "", "purchasesError", "getCustomerCenterConfig", "appUserID", "getCustomerInfo", "appInBackground", "onSuccess", "onError", "getOfferings", "getProductEntitlementMapping", "getRemoteConfig", "fetchContext", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigFetchContext;", ClientCookie.DOMAIN_ATTR, "manifest", "lastRefreshTime", "prefetchedBlobs", "getRemoteConfigFallback", "getRewardVerificationResult", "clientTransactionId", "getVirtualCurrencies", "getWebBillingProducts", "productIds", "", "logIn", "postCreateSupportTicket", "email", "description", "postDiagnostics", "diagnosticsList", "postEvents", "paywallEventRequest", "Lcom/revenuecat/purchases/common/events/EventsRequest;", "baseURL", "Ljava/net/URL;", "delay", "Lcom/revenuecat/purchases/common/Delay;", "error", "shouldMarkAsSynced", "postReceiptData", "purchaseToken", "isRestore", "finishTransactions", "subscriberAttributes", "", "receiptInfo", "Lcom/revenuecat/purchases/common/ReceiptInfo;", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "paywallPostReceiptData", "Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "workflowMetadata", "Lcom/revenuecat/purchases/common/caching/WorkflowMetadata;", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "postRedeemWebPurchase", "redemptionToken", "onResultHandler", "addBackgroundAwareCallback", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, NotificationCompat.CATEGORY_CALL, "Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "cacheKey", "functions", "addCallback", "K", "F", "(Ljava/util/Map;Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;Lcom/revenuecat/purchases/common/Dispatcher;Ljava/lang/Object;Ljava/lang/Object;Lcom/revenuecat/purchases/common/Delay;)V", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class Backend {
    private static final String APP_USER_ID = "app_user_id";
    private static final String FETCH_TOKEN = "fetch_token";
    private static final String NEW_APP_USER_ID = "new_app_user_id";
    private static final int POST_RECEIPT_PAYLOAD_VERSION = 1;
    private volatile Map<List<String>, List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>>> aliasCallbacks;
    private final AppConfig appConfig;
    private final BackendHelper backendHelper;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> callbacks;
    private volatile Map<String, List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>>> createSupportTicketCallbacks;
    private volatile Map<String, List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>>> customerCenterCallbacks;
    private volatile Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> diagnosticsCallbacks;
    private final Dispatcher dispatcher;
    private final Dispatcher eventsDispatcher;
    private final HTTPClient httpClient;
    private volatile Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> identifyCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function3<JSONObject, HTTPResponseOriginalSource, String, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>>> offeringsCallbacks;
    private volatile Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> paywallEventsCallbacks;
    private volatile Map<List<String>, List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> postReceiptCallbacks;
    private volatile Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> productEntitlementCallbacks;
    private volatile Map<String, List<Function1<RedeemWebPurchaseListener.Result, Unit>>> redeemWebPurchaseCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function3<RCContainer, Date, VerificationResult, Unit>, Function2<PurchasesError, GetRemoteConfigErrorHandlingBehavior, Unit>>>> remoteConfigCallbacks;
    private final Dispatcher remoteConfigDispatcher;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function2<RemoteConfiguration, VerificationResult, Unit>, Function1<PurchasesError, Unit>>>> remoteConfigFallbackCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<RewardVerificationPollStatus, Unit>, Function1<RewardVerificationError, Unit>>>> rewardVerificationResultCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>>> virtualCurrenciesCallbacks;
    private volatile Map<String, List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>>> webBillingProductsCallbacks;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Json json = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.revenuecat.purchases.common.Backend$Companion$json$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
        }
    }, 1, null);

    public Backend(AppConfig appConfig, Dispatcher dispatcher, Dispatcher eventsDispatcher, HTTPClient httpClient, BackendHelper backendHelper, Dispatcher remoteConfigDispatcher) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(eventsDispatcher, "eventsDispatcher");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        Intrinsics.checkNotNullParameter(remoteConfigDispatcher, "remoteConfigDispatcher");
        this.appConfig = appConfig;
        this.dispatcher = dispatcher;
        this.eventsDispatcher = eventsDispatcher;
        this.httpClient = httpClient;
        this.backendHelper = backendHelper;
        this.remoteConfigDispatcher = remoteConfigDispatcher;
        this.callbacks = new LinkedHashMap();
        this.postReceiptCallbacks = new LinkedHashMap();
        this.offeringsCallbacks = new LinkedHashMap();
        this.identifyCallbacks = new LinkedHashMap();
        this.aliasCallbacks = new LinkedHashMap();
        this.diagnosticsCallbacks = new LinkedHashMap();
        this.paywallEventsCallbacks = new LinkedHashMap();
        this.productEntitlementCallbacks = new LinkedHashMap();
        this.customerCenterCallbacks = new LinkedHashMap();
        this.createSupportTicketCallbacks = new LinkedHashMap();
        this.redeemWebPurchaseCallbacks = new LinkedHashMap();
        this.virtualCurrenciesCallbacks = new LinkedHashMap();
        this.webBillingProductsCallbacks = new LinkedHashMap();
        this.rewardVerificationResultCallbacks = new LinkedHashMap();
        this.remoteConfigCallbacks = new LinkedHashMap();
        this.remoteConfigFallbackCallbacks = new LinkedHashMap();
    }

    public /* synthetic */ Backend(AppConfig appConfig, Dispatcher dispatcher, Dispatcher dispatcher2, HTTPClient hTTPClient, BackendHelper backendHelper, Dispatcher dispatcher3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appConfig, dispatcher, dispatcher2, hTTPClient, backendHelper, (i & 32) != 0 ? dispatcher : dispatcher3);
    }

    /* JADX INFO: compiled from: Backend.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/common/Backend$Companion;", "", "()V", "APP_USER_ID", "", "FETCH_TOKEN", "NEW_APP_USER_ID", "POST_RECEIPT_PAYLOAD_VERSION", "", "json", "Lkotlinx/serialization/json/Json;", "getJson$purchases_defaultsRelease$annotations", "getJson$purchases_defaultsRelease", "()Lkotlinx/serialization/json/Json;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getJson$purchases_defaultsRelease$annotations() {
        }

        private Companion() {
        }

        public final Json getJson$purchases_defaultsRelease() {
            return Backend.json;
        }
    }

    public final SignatureVerificationMode getVerificationMode() {
        return this.httpClient.getSigningManager().getSignatureVerificationMode();
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> getCallbacks() {
        return this.callbacks;
    }

    public final synchronized void setCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.callbacks = map;
    }

    public final synchronized Map<List<String>, List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> getPostReceiptCallbacks() {
        return this.postReceiptCallbacks;
    }

    public final synchronized void setPostReceiptCallbacks(Map<List<String>, List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.postReceiptCallbacks = map;
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function3<JSONObject, HTTPResponseOriginalSource, String, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>>> getOfferingsCallbacks() {
        return this.offeringsCallbacks;
    }

    public final synchronized void setOfferingsCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function3<JSONObject, HTTPResponseOriginalSource, String, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.offeringsCallbacks = map;
    }

    public final synchronized Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> getIdentifyCallbacks() {
        return this.identifyCallbacks;
    }

    public final synchronized void setIdentifyCallbacks(Map<List<String>, List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.identifyCallbacks = map;
    }

    public final synchronized Map<List<String>, List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>>> getAliasCallbacks() {
        return this.aliasCallbacks;
    }

    public final synchronized void setAliasCallbacks(Map<List<String>, List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.aliasCallbacks = map;
    }

    public final synchronized Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> getDiagnosticsCallbacks() {
        return this.diagnosticsCallbacks;
    }

    public final synchronized void setDiagnosticsCallbacks(Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.diagnosticsCallbacks = map;
    }

    public final synchronized Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> getPaywallEventsCallbacks() {
        return this.paywallEventsCallbacks;
    }

    public final synchronized void setPaywallEventsCallbacks(Map<List<String>, List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.paywallEventsCallbacks = map;
    }

    public final synchronized Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> getProductEntitlementCallbacks() {
        return this.productEntitlementCallbacks;
    }

    public final synchronized void setProductEntitlementCallbacks(Map<String, List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.productEntitlementCallbacks = map;
    }

    public final synchronized Map<String, List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>>> getCustomerCenterCallbacks() {
        return this.customerCenterCallbacks;
    }

    public final synchronized void setCustomerCenterCallbacks(Map<String, List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.customerCenterCallbacks = map;
    }

    public final synchronized Map<String, List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>>> getCreateSupportTicketCallbacks() {
        return this.createSupportTicketCallbacks;
    }

    public final synchronized void setCreateSupportTicketCallbacks(Map<String, List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.createSupportTicketCallbacks = map;
    }

    public final synchronized Map<String, List<Function1<RedeemWebPurchaseListener.Result, Unit>>> getRedeemWebPurchaseCallbacks() {
        return this.redeemWebPurchaseCallbacks;
    }

    public final synchronized void setRedeemWebPurchaseCallbacks(Map<String, List<Function1<RedeemWebPurchaseListener.Result, Unit>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.redeemWebPurchaseCallbacks = map;
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>>> getVirtualCurrenciesCallbacks() {
        return this.virtualCurrenciesCallbacks;
    }

    public final synchronized void setVirtualCurrenciesCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.virtualCurrenciesCallbacks = map;
    }

    public final synchronized Map<String, List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>>> getWebBillingProductsCallbacks() {
        return this.webBillingProductsCallbacks;
    }

    public final synchronized void setWebBillingProductsCallbacks(Map<String, List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.webBillingProductsCallbacks = map;
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<RewardVerificationPollStatus, Unit>, Function1<RewardVerificationError, Unit>>>> getRewardVerificationResultCallbacks() {
        return this.rewardVerificationResultCallbacks;
    }

    public final synchronized void setRewardVerificationResultCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function1<RewardVerificationPollStatus, Unit>, Function1<RewardVerificationError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.rewardVerificationResultCallbacks = map;
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function3<RCContainer, Date, VerificationResult, Unit>, Function2<PurchasesError, GetRemoteConfigErrorHandlingBehavior, Unit>>>> getRemoteConfigCallbacks() {
        return this.remoteConfigCallbacks;
    }

    public final synchronized void setRemoteConfigCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function3<RCContainer, Date, VerificationResult, Unit>, Function2<PurchasesError, GetRemoteConfigErrorHandlingBehavior, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.remoteConfigCallbacks = map;
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<Pair<Function2<RemoteConfiguration, VerificationResult, Unit>, Function1<PurchasesError, Unit>>>> getRemoteConfigFallbackCallbacks() {
        return this.remoteConfigFallbackCallbacks;
    }

    public final synchronized void setRemoteConfigFallbackCallbacks(Map<BackgroundAwareCallbackCacheKey, List<Pair<Function2<RemoteConfiguration, VerificationResult, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.remoteConfigFallbackCallbacks = map;
    }

    public final void close() {
        this.dispatcher.close();
        this.remoteConfigDispatcher.close();
    }

    public final void getCustomerInfo(String appUserID, boolean appInBackground, Function1<? super CustomerInfo, Unit> onSuccess, Function2<? super PurchasesError, ? super Boolean, Unit> onError) {
        Throwable th;
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetCustomerInfo getCustomerInfo = new Endpoint.GetCustomerInfo(appUserID);
        String path$default = Endpoint.getPath$default(getCustomerInfo, false, 1, null);
        synchronized (this) {
            try {
                if (this.postReceiptCallbacks.isEmpty()) {
                    try {
                        backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(path$default), appInBackground);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.plus((Collection<? extends String>) CollectionsKt.listOf(path$default), String.valueOf(this.callbacks.size())), appInBackground);
                }
                final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getCustomerInfo$call$1
                    @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                    public HTTPResult call() {
                        return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getCustomerInfo, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
                    }

                    @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                    public void onCompletion(HTTPResult result) {
                        List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                        Intrinsics.checkNotNullParameter(result, "result");
                        Backend backend = this.this$0;
                        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey3 = backgroundAwareCallbackCacheKey2;
                        synchronized (backend) {
                            listRemove = backend.getCallbacks().remove(backgroundAwareCallbackCacheKey3);
                        }
                        if (listRemove != null) {
                            Iterator<T> it = listRemove.iterator();
                            while (it.hasNext()) {
                                Pair pair = (Pair) it.next();
                                Function1 function1 = (Function1) pair.component1();
                                Function2 function2 = (Function2) pair.component2();
                                try {
                                    if (BackendHelperKt.isSuccessful(result)) {
                                        function1.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result));
                                    } else {
                                        PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                                        LogUtilsKt.errorLog(purchasesError);
                                        function2.invoke(purchasesError, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode())));
                                    }
                                } catch (JSONException e) {
                                    PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e);
                                    LogUtilsKt.errorLog(purchasesError2);
                                    function2.invoke(purchasesError2, false);
                                }
                            }
                        }
                    }

                    @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                    public void onError(PurchasesError error) {
                        List<Pair<Function1<CustomerInfo, Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                        Intrinsics.checkNotNullParameter(error, "error");
                        Backend backend = this.this$0;
                        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey3 = backgroundAwareCallbackCacheKey2;
                        synchronized (backend) {
                            listRemove = backend.getCallbacks().remove(backgroundAwareCallbackCacheKey3);
                        }
                        if (listRemove != null) {
                            Iterator<T> it = listRemove.iterator();
                            while (it.hasNext()) {
                                ((Function2) ((Pair) it.next()).component2()).invoke(error, false);
                            }
                        }
                    }
                };
                synchronized (this) {
                    try {
                        try {
                            addBackgroundAwareCallback(this.callbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey2, TuplesKt.m1606to(onSuccess, onError), Delay.INSTANCE.jitterOnlyIfInBackground(appInBackground));
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    public final void postReceiptData(String purchaseToken, String appUserID, boolean isRestore, boolean finishTransactions, Map<String, ? extends Map<String, ? extends Object>> subscriberAttributes, ReceiptInfo receiptInfo, PostReceiptInitiationSource initiationSource, PaywallPostReceiptData paywallPostReceiptData, WorkflowMetadata workflowMetadata, PurchasesAreCompletedBy purchasesAreCompletedBy, Function1<? super PostReceiptResponse, Unit> onSuccess, Function3<? super PurchasesError, ? super PostReceiptErrorHandlingBehavior, ? super JSONObject, Unit> onError) {
        int i;
        Map mapMapOf;
        ArrayList arrayList;
        PresentedOfferingContext.TargetingContext targetingContext;
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Map<String, ? extends Map<String, ? extends Object>> subscriberAttributes2 = subscriberAttributes;
        Intrinsics.checkNotNullParameter(subscriberAttributes2, "subscriberAttributes");
        Intrinsics.checkNotNullParameter(receiptInfo, "receiptInfo");
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{purchaseToken, appUserID, String.valueOf(isRestore), String.valueOf(finishTransactions), subscriberAttributes2.toString(), receiptInfo.toString(), purchasesAreCompletedBy.toString()});
        Pair[] pairArr = new Pair[23];
        pairArr[0] = TuplesKt.m1606to(FETCH_TOKEN, purchaseToken);
        pairArr[1] = TuplesKt.m1606to(DiagnosticsTracker.PRODUCT_IDS_KEY, receiptInfo.getProductIDs());
        pairArr[2] = TuplesKt.m1606to("platform_product_ids", receiptInfo.getPlatformProductIds());
        pairArr[3] = TuplesKt.m1606to(APP_USER_ID, appUserID);
        pairArr[4] = TuplesKt.m1606to("is_restore", Boolean.valueOf(isRestore));
        PresentedOfferingContext presentedOfferingContext = receiptInfo.getPresentedOfferingContext();
        pairArr[5] = TuplesKt.m1606to("presented_offering_identifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext2 = receiptInfo.getPresentedOfferingContext();
        pairArr[6] = TuplesKt.m1606to("presented_placement_identifier", presentedOfferingContext2 != null ? presentedOfferingContext2.getPlacementIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext3 = receiptInfo.getPresentedOfferingContext();
        if (presentedOfferingContext3 == null || (targetingContext = presentedOfferingContext3.getTargetingContext()) == null) {
            i = 1;
            mapMapOf = null;
        } else {
            i = 1;
            mapMapOf = MapsKt.mapOf(TuplesKt.m1606to("revision", Integer.valueOf(targetingContext.getRevision())), TuplesKt.m1606to("rule_id", targetingContext.getRuleId()));
        }
        pairArr[7] = TuplesKt.m1606to("applied_targeting_rule", mapMapOf);
        pairArr[8] = TuplesKt.m1606to("observer_mode", Boolean.valueOf(!finishTransactions));
        String lowerCase = purchasesAreCompletedBy.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        pairArr[9] = TuplesKt.m1606to("purchase_completed_by", lowerCase);
        pairArr[10] = TuplesKt.m1606to("price", receiptInfo.getPrice());
        pairArr[11] = TuplesKt.m1606to("currency", receiptInfo.getCurrency());
        if (subscriberAttributes2.isEmpty() || this.appConfig.getCustomEntitlementComputation()) {
            subscriberAttributes2 = null;
        }
        pairArr[12] = TuplesKt.m1606to("attributes", subscriberAttributes2);
        pairArr[13] = TuplesKt.m1606to("normal_duration", receiptInfo.getDuration());
        pairArr[14] = TuplesKt.m1606to("store_user_id", receiptInfo.getStoreUserID());
        List<PricingPhase> pricingPhases = receiptInfo.getPricingPhases();
        if (pricingPhases != null) {
            List<PricingPhase> list = pricingPhases;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(BackendKt.toMap((PricingPhase) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        pairArr[15] = TuplesKt.m1606to("pricing_phases", arrayList);
        ReplacementMode replacementMode = receiptInfo.getReplacementMode();
        pairArr[16] = TuplesKt.m1606to("proration_mode", replacementMode != null ? ReplacementModeKt.backendName(replacementMode, this.appConfig.getStore()) : null);
        pairArr[17] = TuplesKt.m1606to("initiation_source", initiationSource.getPostReceiptFieldValue());
        pairArr[18] = TuplesKt.m1606to(WorkflowScreenType.PAYWALL, paywallPostReceiptData != null ? paywallPostReceiptData.toMap() : null);
        pairArr[19] = TuplesKt.m1606to("presented_workflow_id", workflowMetadata != null ? workflowMetadata.getWorkflowId() : null);
        pairArr[20] = TuplesKt.m1606to("presented_step_id", workflowMetadata != null ? workflowMetadata.getStepId() : null);
        pairArr[21] = TuplesKt.m1606to("sdk_originated", Boolean.valueOf(receiptInfo.getSdkOriginated()));
        pairArr[22] = TuplesKt.m1606to("payload_version", Integer.valueOf(i));
        final Map mapFilterNotNullValues = MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(pairArr));
        Pair[] pairArr2 = new Pair[2];
        pairArr2[0] = TuplesKt.m1606to(APP_USER_ID, appUserID);
        pairArr2[i] = TuplesKt.m1606to(FETCH_TOKEN, purchaseToken);
        final List listListOf = CollectionsKt.listOf((Object[]) pairArr2);
        Pair[] pairArr3 = new Pair[2];
        pairArr3[0] = TuplesKt.m1606to("price_string", receiptInfo.getFormattedPrice());
        pairArr3[i] = TuplesKt.m1606to("marketplace", receiptInfo.getMarketplace());
        final Map mapFilterNotNullValues2 = MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(pairArr3));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postReceiptData$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), Endpoint.PostReceipt.INSTANCE, mapFilterNotNullValues, listListOf, MapsKt.plus(this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), mapFilterNotNullValues2), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                List<String> list2 = listListOfNotNull;
                synchronized (backend) {
                    listRemove = backend.getPostReceiptCallbacks().remove(list2);
                }
                if (listRemove != null) {
                    Backend backend2 = this.this$0;
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        Pair pair = (Pair) it2.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function3 function3 = (Function3) pair.component2();
                        try {
                            if (BackendHelperKt.isSuccessful(result)) {
                                function1.invoke(PostReceiptResponseKt.buildPostReceiptResponse(result));
                            } else {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                                LogUtilsKt.errorLog(purchasesError);
                                function3.invoke(purchasesError, backend2.determinePostReceiptErrorHandlingBehavior(result.getResponseCode(), purchasesError), result.getBody());
                            }
                        } catch (JSONException e) {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e);
                            LogUtilsKt.errorLog(purchasesError2);
                            function3.invoke(purchasesError2, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<PostReceiptResponse, Unit>, Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                List<String> list2 = listListOfNotNull;
                synchronized (backend) {
                    listRemove = backend.getPostReceiptCallbacks().remove(list2);
                }
                if (listRemove != null) {
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        ((Function3) ((Pair) it2.next()).component2()).invoke(error, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
                    }
                }
            }
        };
        synchronized (this) {
            addCallback$default(this, this.postReceiptCallbacks, asyncCall, this.dispatcher, listListOfNotNull, TuplesKt.m1606to(onSuccess, onError), null, 16, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void getOfferings(String appUserID, boolean appInBackground, Function3<? super JSONObject, ? super HTTPResponseOriginalSource, ? super String, Unit> onSuccess, Function2<? super PurchasesError, ? super GetOfferingsErrorHandlingBehavior, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetOfferings getOfferings = new Endpoint.GetOfferings(appUserID);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(Endpoint.getPath$default(getOfferings, false, 1, null)), appInBackground);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getOfferings$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getOfferings, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function3<JSONObject, HTTPResponseOriginalSource, String, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getOfferingsCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function2) ((Pair) it.next()).component2()).invoke(error, GetOfferingsErrorHandlingBehavior.SHOULD_FALLBACK_TO_CACHED_OFFERINGS);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function3<JSONObject, HTTPResponseOriginalSource, String, Unit>, Function2<PurchasesError, GetOfferingsErrorHandlingBehavior, Unit>>> listRemove;
                GetOfferingsErrorHandlingBehavior getOfferingsErrorHandlingBehavior;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getOfferingsCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function3 function3 = (Function3) pair.component1();
                        Function2 function2 = (Function2) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function3.invoke(result.getBody(), HTTPResponseOriginalSourceKt.getOriginalDataSource(result), result.getPayloadText());
                            } catch (JSONException e) {
                                GetOfferingsErrorHandlingBehavior getOfferingsErrorHandlingBehavior2 = GetOfferingsErrorHandlingBehavior.SHOULD_FALLBACK_TO_CACHED_OFFERINGS;
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function2.invoke(purchasesError, getOfferingsErrorHandlingBehavior2);
                            }
                        } else {
                            if (RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode())) {
                                getOfferingsErrorHandlingBehavior = GetOfferingsErrorHandlingBehavior.SHOULD_FALLBACK_TO_CACHED_OFFERINGS;
                            } else {
                                getOfferingsErrorHandlingBehavior = GetOfferingsErrorHandlingBehavior.SHOULD_NOT_FALLBACK;
                            }
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError2);
                            function2.invoke(purchasesError2, getOfferingsErrorHandlingBehavior);
                        }
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addBackgroundAwareCallback(this.offeringsCallbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey, TuplesKt.m1606to(onSuccess, onError), Delay.INSTANCE.jitterOnlyIfInBackground(appInBackground));
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void logIn(final String appUserID, final String newAppUserID, Function2<? super CustomerInfo, ? super Boolean, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) throws Throwable {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{appUserID, newAppUserID});
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$logIn$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.httpClient, this.appConfig.getBaseURL(), Endpoint.LogIn.INSTANCE, MapsKt.mapOf(TuplesKt.m1606to("app_user_id", appUserID), TuplesKt.m1606to("new_app_user_id", newAppUserID)), CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.m1606to("app_user_id", appUserID), TuplesKt.m1606to("new_app_user_id", newAppUserID)}), this.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this;
                List<String> list = listListOfNotNull;
                synchronized (backend) {
                    listRemove = backend.getIdentifyCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function2<CustomerInfo, Boolean, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                if (BackendHelperKt.isSuccessful(result)) {
                    Backend backend = this;
                    List<String> list = listListOfNotNull;
                    synchronized (backend) {
                        listRemove = backend.getIdentifyCallbacks().remove(list);
                    }
                    if (listRemove != null) {
                        Iterator<T> it = listRemove.iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            Function2 function2 = (Function2) pair.component1();
                            Function1 function1 = (Function1) pair.component2();
                            boolean z = result.getResponseCode() == 201;
                            if (result.getBody().length() > 0) {
                                function2.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result), Boolean.valueOf(z));
                            } else {
                                PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnknownError, null, 2, null);
                                LogUtilsKt.errorLog(purchasesError);
                                function1.invoke(purchasesError);
                            }
                        }
                        return;
                    }
                    return;
                }
                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                LogUtilsKt.errorLog(purchasesError2);
                onError(purchasesError2);
            }
        };
        synchronized (this) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                addCallback$default(this, this.identifyCallbacks, asyncCall, this.dispatcher, listListOfNotNull, TuplesKt.m1606to(onSuccessHandler, onErrorHandler), null, 16, null);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final void aliasUsers(final String oldAppUserID, final String newAppUserID, Function0<Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) throws Throwable {
        Intrinsics.checkNotNullParameter(oldAppUserID, "oldAppUserID");
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{oldAppUserID, newAppUserID});
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$aliasUsers$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.httpClient, this.appConfig.getBaseURL(), new Endpoint.AliasUsers(oldAppUserID), MapsKt.mapOf(TuplesKt.m1606to("app_user_id", oldAppUserID), TuplesKt.m1606to("new_app_user_id", newAppUserID)), null, this.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this;
                List<String> list = listListOfNotNull;
                synchronized (backend) {
                    listRemove = backend.getAliasCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function0<Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                if (BackendHelperKt.isSuccessful(result)) {
                    Backend backend = this;
                    List<String> list = listListOfNotNull;
                    synchronized (backend) {
                        listRemove = backend.getAliasCallbacks().remove(list);
                    }
                    if (listRemove != null) {
                        Iterator<T> it = listRemove.iterator();
                        while (it.hasNext()) {
                            ((Function0) ((Pair) it.next()).component1()).invoke();
                        }
                        return;
                    }
                    return;
                }
                PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                LogUtilsKt.errorLog(purchasesError);
                onError(purchasesError);
            }
        };
        synchronized (this) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                addCallback$default(this, this.aliasCallbacks, asyncCall, this.dispatcher, listListOfNotNull, TuplesKt.m1606to(onSuccessHandler, onErrorHandler), null, 16, null);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final void postDiagnostics(List<? extends JSONObject> diagnosticsList, Function1<? super JSONObject, Unit> onSuccessHandler, Function2<? super PurchasesError, ? super Boolean, Unit> onErrorHandler) throws Throwable {
        Intrinsics.checkNotNullParameter(diagnosticsList, "diagnosticsList");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        List<? extends JSONObject> list = diagnosticsList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((JSONObject) it.next()).hashCode()));
        }
        final ArrayList arrayList2 = arrayList;
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.m1606to(RemoteConfigConstants.ResponseFieldKey.ENTRIES, new JSONArray((Collection) diagnosticsList)));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postDiagnostics$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, AppConfig.INSTANCE.getDiagnosticsURL(), Endpoint.PostDiagnostics.INSTANCE, mapMapOf, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                List<String> list2 = arrayList2;
                synchronized (backend) {
                    listRemove = backend.getDiagnosticsCallbacks().remove(list2);
                }
                if (listRemove != null) {
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        ((Function2) ((Pair) it2.next()).component2()).invoke(error, Boolean.valueOf(error.getCode() == PurchasesErrorCode.NetworkError));
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<JSONObject, Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                List<String> list2 = arrayList2;
                synchronized (backend) {
                    listRemove = backend.getDiagnosticsCallbacks().remove(list2);
                }
                if (listRemove != null) {
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        Pair pair = (Pair) it2.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function2 function2 = (Function2) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            function1.invoke(result.getBody());
                        } else {
                            PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                            function2.invoke(purchasesError, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode()) || purchasesError.getCode() == PurchasesErrorCode.NetworkError));
                        }
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.diagnosticsCallbacks, asyncCall, this.eventsDispatcher, arrayList2, TuplesKt.m1606to(onSuccessHandler, onErrorHandler), Delay.LONG);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void postEvents(final EventsRequest paywallEventRequest, final URL baseURL, Delay delay, Function0<Unit> onSuccessHandler, Function2<? super PurchasesError, ? super Boolean, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(paywallEventRequest, "paywallEventRequest");
        Intrinsics.checkNotNullParameter(baseURL, "baseURL");
        Intrinsics.checkNotNullParameter(delay, "delay");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        Json defaultJson = JsonProvider.INSTANCE.getDefaultJson();
        defaultJson.getSerializersModule();
        final Map<String, Object> mapAsMap = JsonElementExtensionsKt.asMap(defaultJson.encodeToJsonElement(EventsRequest.INSTANCE.serializer(), paywallEventRequest));
        if (mapAsMap == null) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnknownError, "Error encoding paywall event request");
            LogUtilsKt.errorLog(purchasesError);
            onErrorHandler.invoke(purchasesError, true);
            return;
        }
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postEvents$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, baseURL, Endpoint.PostEvents.INSTANCE, mapAsMap, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                EventsRequest eventsRequest = paywallEventRequest;
                synchronized (backend) {
                    listRemove = backend.getPaywallEventsCallbacks().remove(eventsRequest.getCacheKey());
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function2) ((Pair) it.next()).component2()).invoke(error, false);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function0<Unit>, Function2<PurchasesError, Boolean, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                EventsRequest eventsRequest = paywallEventRequest;
                synchronized (backend) {
                    listRemove = backend.getPaywallEventsCallbacks().remove(eventsRequest.getCacheKey());
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function0 function0 = (Function0) pair.component1();
                        Function2 function2 = (Function2) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            function0.invoke();
                        } else {
                            function2.invoke(ErrorsKt.toPurchasesError(result), Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isSynced(result.getResponseCode())));
                        }
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.paywallEventsCallbacks, asyncCall, this.eventsDispatcher, paywallEventRequest.getCacheKey(), TuplesKt.m1606to(onSuccessHandler, onErrorHandler), delay);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void getProductEntitlementMapping(Function1<? super ProductEntitlementMapping, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final Endpoint.GetProductEntitlementMapping getProductEntitlementMapping = Endpoint.GetProductEntitlementMapping.INSTANCE;
        final String path$default = Endpoint.getPath$default(getProductEntitlementMapping, false, 1, null);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getProductEntitlementMapping$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getProductEntitlementMapping, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getProductEntitlementCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<ProductEntitlementMapping, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getProductEntitlementCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function1 function12 = (Function1) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function1.invoke(ProductEntitlementMapping.INSTANCE.fromNetwork$purchases_defaultsRelease(result.getBody(), result));
                            } catch (JSONException e) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            }
                        } else {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError2);
                            function12.invoke(purchasesError2);
                        }
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.productEntitlementCallbacks, asyncCall, this.dispatcher, path$default, TuplesKt.m1606to(onSuccessHandler, onErrorHandler), Delay.LONG);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void getCustomerCenterConfig(String appUserID, Function1<? super CustomerCenterConfigData, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final Endpoint.GetCustomerCenterConfig getCustomerCenterConfig = new Endpoint.GetCustomerCenterConfig(appUserID);
        final String path$default = Endpoint.getPath$default(getCustomerCenterConfig, false, 1, null);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getCustomerCenterConfig$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getCustomerCenterConfig, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCustomerCenterCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<CustomerCenterConfigData, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCustomerCenterCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function1 function12 = (Function1) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                Json json$purchases_defaultsRelease = Backend.INSTANCE.getJson$purchases_defaultsRelease();
                                String payloadText = result.getPayloadText();
                                json$purchases_defaultsRelease.getSerializersModule();
                                function1.invoke(((CustomerCenterRoot) json$purchases_defaultsRelease.decodeFromString(CustomerCenterRoot.INSTANCE.serializer(), payloadText)).getCustomerCenter());
                            } catch (SerializationException e) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            } catch (IllegalArgumentException e2) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e2);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            function12.invoke(purchasesError3);
                        }
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.customerCenterCallbacks, asyncCall, this.dispatcher, path$default, TuplesKt.m1606to(onSuccessHandler, onErrorHandler), Delay.NONE);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void postCreateSupportTicket(String appUserID, String email, String description, Function1<? super Boolean, Unit> onSuccessHandler, Function1<? super PurchasesError, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        final Endpoint.PostCreateSupportTicket postCreateSupportTicket = Endpoint.PostCreateSupportTicket.INSTANCE;
        final String path$default = Endpoint.getPath$default(postCreateSupportTicket, false, 1, null);
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.m1606to(APP_USER_ID, appUserID), TuplesKt.m1606to("customer_email", email), TuplesKt.m1606to("issue_description", description));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postCreateSupportTicket$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), postCreateSupportTicket, mapMapOf, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCreateSupportTicketCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<Boolean, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCreateSupportTicketCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function1 function12 = (Function1) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function1.invoke(Boolean.valueOf(result.getBody().optBoolean("sent", false)));
                            } catch (SerializationException e) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            } catch (IllegalArgumentException e2) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e2);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            function12.invoke(purchasesError3);
                        }
                    }
                }
            }
        };
        synchronized (this) {
            addCallback(this.createSupportTicketCallbacks, asyncCall, this.dispatcher, path$default, TuplesKt.m1606to(onSuccessHandler, onErrorHandler), Delay.NONE);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void postRedeemWebPurchase(String appUserID, String redemptionToken, Function1<? super RedeemWebPurchaseListener.Result, Unit> onResultHandler) throws Throwable {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(redemptionToken, "redemptionToken");
        Intrinsics.checkNotNullParameter(onResultHandler, "onResultHandler");
        final Endpoint.PostRedeemWebPurchase postRedeemWebPurchase = Endpoint.PostRedeemWebPurchase.INSTANCE;
        final String path$default = Endpoint.getPath$default(postRedeemWebPurchase, false, 1, null);
        final Map mapMapOf = MapsKt.mapOf(TuplesKt.m1606to("redemption_token", redemptionToken), TuplesKt.m1606to(APP_USER_ID, appUserID));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postRedeemWebPurchase$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), postRedeemWebPurchase, mapMapOf, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Function1<RedeemWebPurchaseListener.Result, Unit>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getRedeemWebPurchaseCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) it.next()).invoke(new RedeemWebPurchaseListener.Result.Error(error));
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Function1<RedeemWebPurchaseListener.Result, Unit>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getRedeemWebPurchaseCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Function1 function1 = (Function1) it.next();
                        if (BackendHelperKt.isSuccessful(result)) {
                            function1.invoke(new RedeemWebPurchaseListener.Result.Success(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result)));
                        } else {
                            Integer backendErrorCode = result.getBackendErrorCode();
                            int value = BackendErrorCode.BackendInvalidWebRedemptionToken.getValue();
                            if (backendErrorCode != null && backendErrorCode.intValue() == value) {
                                function1.invoke(RedeemWebPurchaseListener.Result.InvalidToken.INSTANCE);
                            } else {
                                int value2 = BackendErrorCode.BackendExpiredWebRedemptionToken.getValue();
                                if (backendErrorCode != null && backendErrorCode.intValue() == value2) {
                                    JSONObject body = result.getBody();
                                    JSONObject jSONObjectOptJSONObject = body.optJSONObject("purchase_redemption_error_info");
                                    String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("obfuscated_email") : null;
                                    if (strOptString != null) {
                                        function1.invoke(new RedeemWebPurchaseListener.Result.Expired(strOptString));
                                    } else {
                                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Error parsing expired redemption token response: " + body, null);
                                        function1.invoke(new RedeemWebPurchaseListener.Result.Error(ErrorsKt.toPurchasesError(result)));
                                    }
                                } else {
                                    int value3 = BackendErrorCode.BackendPurchaseBelongsToOtherUser.getValue();
                                    if (backendErrorCode != null && backendErrorCode.intValue() == value3) {
                                        function1.invoke(RedeemWebPurchaseListener.Result.PurchaseBelongsToOtherUser.INSTANCE);
                                    } else {
                                        function1.invoke(new RedeemWebPurchaseListener.Result.Error(ErrorsKt.toPurchasesError(result)));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.redeemWebPurchaseCallbacks, asyncCall, this.dispatcher, path$default, onResultHandler, Delay.NONE);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void getVirtualCurrencies(String appUserID, boolean appInBackground, Function1<? super VirtualCurrencies, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) throws Throwable {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetVirtualCurrencies getVirtualCurrencies = new Endpoint.GetVirtualCurrencies(appUserID);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(Endpoint.getPath$default(getVirtualCurrencies, false, 1, null)), appInBackground);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getVirtualCurrencies$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getVirtualCurrencies, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getVirtualCurrenciesCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<VirtualCurrencies, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getVirtualCurrenciesCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function1 function12 = (Function1) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function1.invoke(VirtualCurrenciesFactory.INSTANCE.buildVirtualCurrencies(result));
                            } catch (SerializationException e) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            } catch (IllegalArgumentException e2) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e2);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(purchasesError2);
                            } catch (JSONException e3) {
                                PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(e3);
                                LogUtilsKt.errorLog(purchasesError3);
                                function12.invoke(purchasesError3);
                            }
                        } else {
                            PurchasesError purchasesError4 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError4);
                            function12.invoke(purchasesError4);
                        }
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addBackgroundAwareCallback(this.virtualCurrenciesCallbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey, TuplesKt.m1606to(onSuccess, onError), Delay.INSTANCE.jitterOnlyIfInBackground(appInBackground));
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void getWebBillingProducts(String appUserID, Set<String> productIds, Function1<? super WebBillingProductsResponse, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) throws Throwable {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.WebBillingGetProducts webBillingGetProducts = new Endpoint.WebBillingGetProducts(appUserID, productIds);
        final String path$default = Endpoint.getPath$default(webBillingGetProducts, false, 1, null);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getWebBillingProducts$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), webBillingGetProducts, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getWebBillingProductsCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<WebBillingProductsResponse, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getWebBillingProductsCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function1 function12 = (Function1) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                Json json$purchases_defaultsRelease = Backend.INSTANCE.getJson$purchases_defaultsRelease();
                                String payloadText = result.getPayloadText();
                                json$purchases_defaultsRelease.getSerializersModule();
                                function1.invoke((WebBillingProductsResponse) json$purchases_defaultsRelease.decodeFromString(WebBillingProductsResponse.INSTANCE.serializer(), payloadText));
                            } catch (SerializationException e) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(purchasesError);
                            } catch (IllegalArgumentException e2) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e2);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            function12.invoke(purchasesError3);
                        }
                    }
                }
            }
        };
        synchronized (this) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                addCallback(this.webBillingProductsCallbacks, asyncCall, this.dispatcher, path$default, TuplesKt.m1606to(onSuccess, onError), Delay.NONE);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final void getRewardVerificationResult(String appUserID, String clientTransactionId, Function1<? super RewardVerificationPollStatus, Unit> onSuccess, Function1<? super RewardVerificationError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(clientTransactionId, "clientTransactionId");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetRewardVerification getRewardVerification = new Endpoint.GetRewardVerification(appUserID, clientTransactionId);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(Endpoint.getPath$default(getRewardVerification, false, 1, null)), false);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getRewardVerificationResult$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getRewardVerification, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function1<RewardVerificationPollStatus, Unit>, Function1<RewardVerificationError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getRewardVerificationResultCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(new RewardVerificationError(error, false));
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function1<RewardVerificationPollStatus, Unit>, Function1<RewardVerificationError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getRewardVerificationResultCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function1 function1 = (Function1) pair.component1();
                        Function1 function12 = (Function1) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                Json json$purchases_defaultsRelease = Backend.INSTANCE.getJson$purchases_defaultsRelease();
                                String payloadText = result.getPayloadText();
                                json$purchases_defaultsRelease.getSerializersModule();
                                function1.invoke(((RewardVerificationResponse) json$purchases_defaultsRelease.decodeFromString(RewardVerificationResponse.INSTANCE.serializer(), payloadText)).toRewardVerificationPollStatus());
                            } catch (SerializationException e) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError);
                                function12.invoke(new RewardVerificationError(purchasesError, false));
                            } catch (IllegalArgumentException e2) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e2);
                                LogUtilsKt.errorLog(purchasesError2);
                                function12.invoke(new RewardVerificationError(purchasesError2, false));
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            function12.invoke(new RewardVerificationError(purchasesError3, RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode())));
                        }
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addBackgroundAwareCallback(this.rewardVerificationResultCallbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey, TuplesKt.m1606to(onSuccess, onError), Delay.NONE);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void getRemoteConfig(boolean appInBackground, String appUserID, RemoteConfigFetchContext fetchContext, String domain, String manifest, Date lastRefreshTime, List<String> prefetchedBlobs, Function3<? super RCContainer, ? super Date, ? super VerificationResult, Unit> onSuccess, Function2<? super PurchasesError, ? super GetRemoteConfigErrorHandlingBehavior, Unit> onError) {
        Map<String, String> authenticationHeaders$purchases_defaultsRelease;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(fetchContext, "fetchContext");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(prefetchedBlobs, "prefetchedBlobs");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final Endpoint.GetRemoteConfig getRemoteConfig = new Endpoint.GetRemoteConfig(domain);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf((Object[]) new String[]{Endpoint.getPath$default(getRemoteConfig, false, 1, null), appUserID}), appInBackground);
        final URL baseURL = this.appConfig.getBaseURL();
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put(APP_USER_ID, appUserID);
        mapCreateMapBuilder.put("fetch_context", fetchContext.getWireName());
        if (manifest != null) {
            mapCreateMapBuilder.put("manifest", manifest);
        }
        mapCreateMapBuilder.put("prefetched_blobs", prefetchedBlobs);
        final Map mapBuild = MapsKt.build(mapCreateMapBuilder);
        if (lastRefreshTime == null || (authenticationHeaders$purchases_defaultsRelease = MapsKt.plus(this.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), TuplesKt.m1606to(HTTPRequest.LAST_REFRESH_TIME_HEADER_NAME, String.valueOf(lastRefreshTime.getTime())))) == null) {
            authenticationHeaders$purchases_defaultsRelease = this.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease();
        }
        final Map<String, String> map = authenticationHeaders$purchases_defaultsRelease;
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getRemoteConfig$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, baseURL, getRemoteConfig, mapBuild, null, map, false, null, 0, 224, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function3<RCContainer, Date, VerificationResult, Unit>, Function2<PurchasesError, GetRemoteConfigErrorHandlingBehavior, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getRemoteConfigCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function2) ((Pair) it.next()).component2()).invoke(error, GetRemoteConfigErrorHandlingBehavior.SHOULD_RETRY);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function3<RCContainer, Date, VerificationResult, Unit>, Function2<PurchasesError, GetRemoteConfigErrorHandlingBehavior, Unit>>> listRemove;
                GetRemoteConfigErrorHandlingBehavior getRemoteConfigErrorHandlingBehavior;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getRemoteConfigCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function3 function3 = (Function3) pair.component1();
                        Function2 function2 = (Function2) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            if (result.getResponseCode() == 204) {
                                function3.invoke(null, result.getRequestDate(), result.getVerificationResult());
                            } else {
                                HTTPResult.Payload payload = result.getPayload();
                                if (!(payload instanceof HTTPResult.Payload.RCFormat)) {
                                    PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnknownError, "Expected an RC Container Format payload for remote config.");
                                    LogUtilsKt.errorLog(purchasesError);
                                    function2.invoke(purchasesError, GetRemoteConfigErrorHandlingBehavior.SHOULD_RETRY);
                                } else {
                                    try {
                                        function3.invoke(RCContainer.INSTANCE.parse(((HTTPResult.Payload.RCFormat) payload).getBytes()), result.getRequestDate(), result.getVerificationResult());
                                    } catch (RCContainerFormatException e) {
                                        PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e);
                                        LogUtilsKt.errorLog(purchasesError2);
                                        function2.invoke(purchasesError2, GetRemoteConfigErrorHandlingBehavior.SHOULD_RETRY);
                                    }
                                }
                            }
                        } else {
                            if (!RCHTTPStatusCodes.INSTANCE.isSuccessful(result.getResponseCode()) && !RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode())) {
                                getRemoteConfigErrorHandlingBehavior = GetRemoteConfigErrorHandlingBehavior.SHOULD_NOT_TRY_FALLBACK;
                            } else {
                                getRemoteConfigErrorHandlingBehavior = GetRemoteConfigErrorHandlingBehavior.SHOULD_RETRY;
                            }
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            function2.invoke(purchasesError3, getRemoteConfigErrorHandlingBehavior);
                        }
                    }
                }
            }
        };
        synchronized (this) {
            addBackgroundAwareCallback(this.remoteConfigCallbacks, asyncCall, this.remoteConfigDispatcher, backgroundAwareCallbackCacheKey, TuplesKt.m1606to(onSuccess, onError), Delay.INSTANCE.jitterOnlyIfInBackground(appInBackground));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void getRemoteConfigFallback(boolean appInBackground, String domain, Function2<? super RemoteConfiguration, ? super VerificationResult, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final URL url = (URL) CollectionsKt.firstOrNull((List) this.appConfig.getFallbackBaseURLs());
        if (url == null) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnknownError, "No fallback base URL configured for remote config.");
            LogUtilsKt.errorLog(purchasesError);
            onError.invoke(purchasesError);
            return;
        }
        final Endpoint.GetRemoteConfigFallback getRemoteConfigFallback = new Endpoint.GetRemoteConfigFallback(domain);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(CollectionsKt.listOf(Endpoint.getPath$default(getRemoteConfigFallback, false, 1, null)), appInBackground);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getRemoteConfigFallback$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, url, getRemoteConfigFallback, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, null, 0, 224, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<Pair<Function2<RemoteConfiguration, VerificationResult, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(error, "error");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getRemoteConfigFallbackCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function1) ((Pair) it.next()).component2()).invoke(error);
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<Pair<Function2<RemoteConfiguration, VerificationResult, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                Intrinsics.checkNotNullParameter(result, "result");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getRemoteConfigFallbackCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        Function2 function2 = (Function2) pair.component1();
                        Function1 function1 = (Function1) pair.component2();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                function2.invoke(RemoteConfiguration.INSTANCE.parse(StringsKt.encodeToByteArray(result.getPayloadText())), result.getVerificationResult());
                            } catch (SerializationException e) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e);
                                LogUtilsKt.errorLog(purchasesError2);
                                function1.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            function1.invoke(purchasesError3);
                        }
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addBackgroundAwareCallback(this.remoteConfigFallbackCallbacks, asyncCall, this.remoteConfigDispatcher, backgroundAwareCallbackCacheKey, TuplesKt.m1606to(onSuccess, onError), Delay.INSTANCE.jitterOnlyIfInBackground(appInBackground));
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void clearCaches() {
        this.httpClient.clearCaches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostReceiptErrorHandlingBehavior determinePostReceiptErrorHandlingBehavior(int responseCode, PurchasesError purchasesError) {
        if (RCHTTPStatusCodes.INSTANCE.isServerError(responseCode)) {
            return PostReceiptErrorHandlingBehavior.SHOULD_USE_OFFLINE_ENTITLEMENTS_AND_NOT_CONSUME;
        }
        if (purchasesError.getCode() == PurchasesErrorCode.UnsupportedError) {
            return PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME;
        }
        return PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED;
    }

    static /* synthetic */ void addBackgroundAwareCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, Pair pair, Delay delay, int i, Object obj) {
        if ((i & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addBackgroundAwareCallback(map, asyncCall, dispatcher, backgroundAwareCallbackCacheKey, pair, delay);
    }

    private final synchronized <S, E> void addBackgroundAwareCallback(Map<BackgroundAwareCallbackCacheKey, List<Pair<S, E>>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, Pair<? extends S, ? extends E> pair, Delay delay) {
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2;
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKeyCopy$default = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey, null, false, 1, null);
        boolean zContainsKey = map.containsKey(backgroundAwareCallbackCacheKeyCopy$default);
        if (backgroundAwareCallbackCacheKey.getAppInBackground() && zContainsKey) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                String str = "[Purchases] - " + logLevel.name();
                String str2 = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITHOUT_JITTER, Arrays.copyOf(new Object[]{backgroundAwareCallbackCacheKeyCopy$default}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                currentLogHandler.mo1541d(str, str2);
            }
            backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKeyCopy$default;
        } else {
            backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
        }
        addCallback(map, asyncCall, dispatcher, backgroundAwareCallbackCacheKey2, pair, delay);
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKeyCopy$default2 = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey, null, true, 1, null);
        boolean zContainsKey2 = map.containsKey(backgroundAwareCallbackCacheKeyCopy$default);
        if (!backgroundAwareCallbackCacheKey.getAppInBackground() && zContainsKey2) {
            LogLevel logLevel2 = LogLevel.DEBUG;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                String str3 = "[Purchases] - " + logLevel2.name();
                String str4 = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITH_JITTER, Arrays.copyOf(new Object[]{backgroundAwareCallbackCacheKeyCopy$default}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                currentLogHandler2.mo1541d(str3, str4);
            }
            List<Pair<S, E>> listRemove = map.remove(backgroundAwareCallbackCacheKeyCopy$default2);
            if (listRemove != null) {
                List<Pair<S, E>> list = listRemove.isEmpty() ? null : listRemove;
                if (list != null) {
                    if (map.containsKey(backgroundAwareCallbackCacheKey)) {
                        List<Pair<S, E>> list2 = map.get(backgroundAwareCallbackCacheKey);
                        if (list2 != null) {
                            list2.addAll(list);
                        }
                    } else {
                        map.put(backgroundAwareCallbackCacheKey, list);
                    }
                }
            }
        }
    }

    static /* synthetic */ void addCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, Object obj, Object obj2, Delay delay, int i, Object obj3) {
        if ((i & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addCallback(map, asyncCall, dispatcher, obj, obj2, delay);
    }

    private final <K, F> void addCallback(Map<K, List<F>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, K k, F f, Delay delay) {
        if (!map.containsKey(k)) {
            map.put(k, CollectionsKt.mutableListOf(f));
            this.backendHelper.enqueue(asyncCall, dispatcher, delay);
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format(NetworkStrings.SAME_CALL_ALREADY_IN_PROGRESS, Arrays.copyOf(new Object[]{k}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            currentLogHandler.mo1541d(str, str2);
        }
        List<F> list = map.get(k);
        Intrinsics.checkNotNull(list);
        list.add(f);
    }
}

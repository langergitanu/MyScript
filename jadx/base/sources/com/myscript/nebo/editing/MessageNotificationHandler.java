package com.myscript.nebo.editing;

import com.myscript.android.utils.SingleLiveEvent;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.IMessageListener;
import com.myscript.atk.core.MessageIdentifier;
import com.myscript.atk.core.MessageKey;
import com.myscript.atk.core.PendingStroke;
import com.myscript.atk.core.SWIGVectorPendingStroke;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.draft.videotutorial.C6313R;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.snt.core.GestureResult;
import com.myscript.snt.core.IGesturesNotificationListener;
import com.myscript.snt.core.IReflowSessionListener;
import com.myscript.snt.core.InkRejected;
import com.myscript.snt.core.PageController;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageNotificationHandler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0006*\u0001\u0013\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0012\u0010\u001a\u001a\u00020\u00182\b\b\u0001\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J6\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001f0 2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0002J\u000e\u0010$\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0018R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m1599d2 = {"Lcom/myscript/nebo/editing/MessageNotificationHandler;", "", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "<init>", "(Lcom/myscript/nebo/log/TechnicalLogger;)V", "pageController", "Lcom/myscript/snt/core/PageController;", "message", "Lcom/myscript/android/utils/SingleLiveEvent;", "", "getMessage$app_standardRelease", "()Lcom/myscript/android/utils/SingleLiveEvent;", "messageIdentifier", "Lcom/myscript/atk/core/MessageIdentifier;", "getMessageIdentifier$app_standardRelease", "gesturesNotifListenerRef", "Lcom/myscript/snt/core/IGesturesNotificationListener;", "messageListenerRef", "com/myscript/nebo/editing/MessageNotificationHandler$messageListenerRef$1", "Lcom/myscript/nebo/editing/MessageNotificationHandler$messageListenerRef$1;", "reflowListenerRef", "Lcom/myscript/snt/core/IReflowSessionListener;", "onInkRejected", "", "causes", "pushMessage", "messageRes", "messageId", "logTraceInternalNotification", SubscriberAttributeKt.JSON_NAME_KEY, "", "", "activeArea", "blockType", "contentType", "bind", "unbind", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MessageNotificationHandler {
    public static final int $stable = 8;
    private final IGesturesNotificationListener gesturesNotifListenerRef;
    private final TechnicalLogger logger;
    private final SingleLiveEvent<Integer> message;
    private final SingleLiveEvent<MessageIdentifier> messageIdentifier;
    private final MessageNotificationHandler$messageListenerRef$1 messageListenerRef;
    private PageController pageController;
    private final IReflowSessionListener reflowListenerRef;

    /* JADX INFO: compiled from: MessageNotificationHandler.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GestureResult.values().length];
            try {
                iArr[GestureResult.NO_WORDS_TO_JOIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GestureResult.CANNOT_MOVE_ABOVE_FIRSTLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GestureResult.APPLIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessageNotificationHandler() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.myscript.nebo.editing.MessageNotificationHandler$messageListenerRef$1] */
    public MessageNotificationHandler(TechnicalLogger technicalLogger) {
        this.logger = technicalLogger;
        this.message = new SingleLiveEvent<>();
        this.messageIdentifier = new SingleLiveEvent<>();
        this.gesturesNotifListenerRef = new IGesturesNotificationListener() { // from class: com.myscript.nebo.editing.MessageNotificationHandler$$ExternalSyntheticLambda0
            @Override // com.myscript.snt.core.IGesturesNotificationListener
            public final void gesture(GestureResult gestureResult) {
                MessageNotificationHandler.gesturesNotifListenerRef$lambda$0(this.f$0, gestureResult);
            }
        };
        this.messageListenerRef = new IMessageListener() { // from class: com.myscript.nebo.editing.MessageNotificationHandler$messageListenerRef$1

            /* JADX INFO: compiled from: MessageNotificationHandler.kt */
            @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[MessageIdentifier.values().length];
                    try {
                        iArr[MessageIdentifier.UNABLE_TO_MIX_LANGUAGE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[MessageIdentifier.SMART_PEN_AUTO_ACTIVATION.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[MessageIdentifier.PAGE_ITEM_SOFT_LIMIT_REACHED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[MessageIdentifier.PAGE_ITEM_HARD_LIMIT_REACHED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[MessageIdentifier.PAGE_ITEM_LIMIT_OK.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[MessageIdentifier.LIMIT_EXCEEDED.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[MessageIdentifier.SNAPPING_ROTATION.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[MessageIdentifier.SNAPPING_ALIGNMENT.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr[MessageIdentifier.SNAPPING_CONNECTION.ordinal()] = 9;
                    } catch (NoSuchFieldError unused9) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.myscript.atk.core.IMessageListener
            public void notify(String key, List<String> message, String activeArea, String blockType, String contentType) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(message, "message");
                Intrinsics.checkNotNullParameter(activeArea, "activeArea");
                Intrinsics.checkNotNullParameter(blockType, "blockType");
                Intrinsics.checkNotNullParameter(contentType, "contentType");
                this.this$0.logTraceInternalNotification(key, message, activeArea, blockType, contentType);
            }

            @Override // com.myscript.atk.core.IMessageListener
            public void notify(String key, MessageIdentifier messageId, String activeArea, String blockType, String contentType) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(messageId, "messageId");
                Intrinsics.checkNotNullParameter(activeArea, "activeArea");
                Intrinsics.checkNotNullParameter(blockType, "blockType");
                Intrinsics.checkNotNullParameter(contentType, "contentType");
                switch (WhenMappings.$EnumSwitchMapping$0[messageId.ordinal()]) {
                    case 1:
                        this.this$0.pushMessage(C6079R.string.unable_to_mix_language);
                        break;
                    case 2:
                        this.this$0.pushMessage(C6079R.string.interaction_banner_pen_detection);
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        this.this$0.pushMessage(messageId);
                        break;
                    default:
                        this.this$0.logTraceInternalNotification(key, CollectionsKt.arrayListOf(messageId.name()), activeArea, blockType, contentType);
                        break;
                }
                int i = WhenMappings.$EnumSwitchMapping$0[messageId.ordinal()];
                if (i == 3 || i == 4 || i == 5) {
                    MessageNotificationHandler messageNotificationHandler = this.this$0;
                    String TRACE = MessageKey.TRACE;
                    Intrinsics.checkNotNullExpressionValue(TRACE, "TRACE");
                    messageNotificationHandler.logTraceInternalNotification(TRACE, CollectionsKt.arrayListOf(messageId.name(), activeArea, blockType), activeArea, blockType, contentType);
                }
            }
        };
        this.reflowListenerRef = new ReflowListenerAdapter() { // from class: com.myscript.nebo.editing.MessageNotificationHandler$reflowListenerRef$1
            @Override // com.myscript.nebo.editing.ReflowListenerAdapter, com.myscript.snt.core.IReflowSessionListener
            public void reflowInkRejected(int causes, List<? extends PendingStroke> strokes) {
                Intrinsics.checkNotNullParameter(strokes, "strokes");
                try {
                    this.this$0.onInkRejected(causes);
                } finally {
                    if (strokes instanceof SWIGVectorPendingStroke) {
                        ((SWIGVectorPendingStroke) strokes).delete();
                    }
                }
            }

            @Override // com.myscript.nebo.editing.ReflowListenerAdapter, com.myscript.snt.core.IReflowSessionListener
            public void reflowTypesetRejected(List<String> boxesId) {
                Intrinsics.checkNotNullParameter(boxesId, "boxesId");
                this.this$0.pushMessage(C6079R.string.notification_typeset_rejected);
            }

            @Override // com.myscript.nebo.editing.ReflowListenerAdapter, com.myscript.snt.core.IReflowSessionListener
            public void reflowInsertRejected(Extent docExtent) {
                try {
                    this.this$0.pushMessage(C6079R.string.notification_insert_rejected);
                } finally {
                    if (docExtent != null) {
                        docExtent.delete();
                    }
                }
            }
        };
    }

    public /* synthetic */ MessageNotificationHandler(TechnicalLogger technicalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : technicalLogger);
    }

    public final SingleLiveEvent<Integer> getMessage$app_standardRelease() {
        return this.message;
    }

    public final SingleLiveEvent<MessageIdentifier> getMessageIdentifier$app_standardRelease() {
        return this.messageIdentifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gesturesNotifListenerRef$lambda$0(MessageNotificationHandler messageNotificationHandler, GestureResult gestureResult) {
        int i = gestureResult == null ? -1 : WhenMappings.$EnumSwitchMapping$0[gestureResult.ordinal()];
        if (i == 1) {
            messageNotificationHandler.pushMessage(C6079R.string.gesture_notification_no_words_to_join);
        } else if (i == 2) {
            messageNotificationHandler.pushMessage(C6079R.string.gesture_notification_no_line_above);
        } else if (i != 3) {
            messageNotificationHandler.pushMessage(C6079R.string.gesture_notification_unable_to_apply);
        }
    }

    private static final boolean onInkRejected$has(int i, InkRejected inkRejected) {
        return (i & inkRejected.swigValue()) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onInkRejected(int causes) {
        int i;
        if (causes != InkRejected.NONE.swigValue()) {
            if (onInkRejected$has(causes, InkRejected.INK_SLICE)) {
                i = C6313R.string.tutorial_freeform_section_board_step1_body;
            } else if (onInkRejected$has(causes, InkRejected.INK_TOO_LONG)) {
                i = C6079R.string.ink_rejected_too_long;
            } else if (onInkRejected$has(causes, InkRejected.INK_TOO_SMALL)) {
                i = C6079R.string.ink_rejected_too_small;
            } else if (onInkRejected$has(causes, InkRejected.INK_TOO_BIG)) {
                i = C6079R.string.ink_rejected_too_big;
            } else if (onInkRejected$has(causes, InkRejected.INK_ABOVE_FIRST_LINE)) {
                i = C6079R.string.ink_rejected_above_first_line;
            } else if (onInkRejected$has(causes, InkRejected.INK_SMALL_TYPESET)) {
                PageController pageController = this.pageController;
                if (pageController == null) {
                    i = 0;
                } else if (pageController.isActivePenEnabled()) {
                    i = C6079R.string.ink_rejected_small_typeset_active_pen;
                } else {
                    i = C6079R.string.ink_rejected_small_typeset_capacitive_input;
                }
            } else if (onInkRejected$has(causes, InkRejected.INK_ACTIVE_BLOCK)) {
                i = C6079R.string.ink_rejected_active_block;
            } else if (onInkRejected$has(causes, InkRejected.INK_MERGE)) {
                i = C6079R.string.ink_rejected_merge;
            } else if (onInkRejected$has(causes, InkRejected.INK_BEFORE_FIRST_COLUMN)) {
                i = C6079R.string.ink_rejected_before_first_column;
            } else {
                i = onInkRejected$has(causes, InkRejected.INK_OUT_OF_PAGE) ? C6079R.string.ink_rejected_out_of_page : C6079R.string.ink_rejected_unknown;
            }
            pushMessage(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pushMessage(int messageRes) {
        this.message.postValue(Integer.valueOf(messageRes));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pushMessage(MessageIdentifier messageId) {
        this.messageIdentifier.postValue(messageId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logTraceInternalNotification(String key, List<String> message, final String activeArea, final String blockType, final String contentType) {
        final String strJoinToString$default = CollectionsKt.joinToString$default(message, " ", null, null, 0, null, null, 62, null);
        if (Intrinsics.areEqual(key, MessageKey.TRACE)) {
            TechnicalLogger technicalLogger = this.logger;
            if (technicalLogger != null) {
                technicalLogger.logTrace("[ EditingActivity] " + strJoinToString$default);
                return;
            }
            return;
        }
        TechnicalLoggerExt.logAction(this.logger, EditingActivity.TAG, "Notif[" + key + "]", new Function0() { // from class: com.myscript.nebo.editing.MessageNotificationHandler$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MessageNotificationHandler.logTraceInternalNotification$lambda$0(strJoinToString$default, activeArea, blockType, contentType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String logTraceInternalNotification$lambda$0(String str, String str2, String str3, String str4) {
        return str + " (activeArea=" + str2 + ", blockType=" + str3 + ", contentType=" + str4 + ")";
    }

    public final void bind(PageController pageController) {
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        PageController pageControllerNewRef = PageController.newRef(pageController);
        pageControllerNewRef.addGesturesNotificationListener(this.gesturesNotifListenerRef);
        pageControllerNewRef.addMessageListener(this.messageListenerRef);
        pageControllerNewRef.addReflowSessionListener(this.reflowListenerRef);
        this.pageController = pageControllerNewRef;
    }

    public final void unbind() {
        PageController pageController = this.pageController;
        if (pageController != null) {
            pageController.removeGesturesNotificationListener(this.gesturesNotifListenerRef);
            pageController.removeMessageListener(this.messageListenerRef);
            pageController.removeReflowSessionListener(this.reflowListenerRef);
            pageController.delete();
        }
        this.pageController = null;
    }
}

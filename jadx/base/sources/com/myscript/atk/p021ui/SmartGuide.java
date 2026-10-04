package com.myscript.atk.p021ui;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.Point;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.p021ui.SmartGuideEvent;
import com.myscript.atk.text.StyleType;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public class SmartGuide implements ISmartGuideComponentListener {
    private static final int CHECK_LIST_TAG = 5;
    private static final int H1_TAG = 0;
    private static final int H2_TAG = 1;
    private static final int ORDERED_LIST_TAG = 4;
    private static final int P_TAG = 2;
    private static final int UNORDERED_LIST_TAG = 3;
    private final SmartGuideContextualMenuController contextualMenuController;
    private ActionListener mActionListener;
    private int mBackgroundColor;
    private final ImageView mBlockTypeButton;
    private boolean mCandidateOptions;
    private final Context mContext;
    private int mCurrentOffsetY;
    private Prompter mCurrentPrompter;
    private String mCurrentPrompterId;
    private Typeface mCustomTypeface;
    private ObjectAnimator mFadeOutAnimator;
    private SmartGuideHideTask mHideSmartGuideTask;
    private final LayoutInflater mInflater;
    private boolean mIsAnimating;
    private float mLineGap;
    private View.OnClickListener mMainButtonListener;
    private Handler mMainHandler;
    private SmartGuideMenu mMenuWindow;
    private int mMenuWindowX;
    private int mMenuWindowY;
    private final View mMoreButton;
    private final ViewGroup mParentLayout;
    private PrompterBox mPrompterBox;
    private PrompterShapeSupport mPrompterShape;
    private List<ShapeCandidate> mPrompterShapeCandidate;
    private PrompterWord mPrompterWord;
    private Map<String, Prompter> mPrompters;
    private final Resources mResources;
    private final SmartGuideCapture mScrollView;
    private PrompterWordControl mSelectedWordControl;
    private View.OnClickListener mShapeListener;
    private View mShapeMenuView;
    private boolean mShowPrompter;
    private final View mSmartGuide;
    private SmartGuideComponent mSmartGuideComponent;
    private int mSmartGuideHeight;
    private int mSmartGuideHeightWithSelection;
    private boolean mSmartGuideOutside;
    private final View mSmartGuideShadow;
    private SmartGuideBlockType mSmartGuideType;
    private ViewGroup mSmartGuideWindow;
    private int mSmartGuideWindowX;
    private int mSmartGuideWindowY;
    private View mTagMenuView;
    private View.OnClickListener mTextListener;
    private View mTextMenuView;
    private Timer mTimer;
    private ViewTransform mTransform;
    private final Object mTransformLock = new Object();
    private final Rect mExtent = new Rect();
    private int mInitialOffset = 0;

    public interface ActionListener {
        boolean hasSelection();

        boolean isProcessPendingOrRequired();

        void onBlockTypeChanged(SmartGuideComponent smartGuideComponent, StyleType styleType);

        void onCopyTriggered(SmartGuideComponent smartGuideComponent);

        void onCutTriggered(SmartGuideComponent smartGuideComponent);

        void onDeleteTriggered(SmartGuideComponent smartGuideComponent);

        void onListify(SmartGuideComponent smartGuideComponent, String str);

        void onPowerPointExportTriggered(SmartGuideComponent smartGuideComponent);

        void onTextify(SmartGuideComponent smartGuideComponent);

        void onTypesetTriggered(SmartGuideComponent smartGuideComponent);
    }

    @Override // com.myscript.atk.p021ui.ISmartGuideComponentListener
    public void conversionPreviewSettingChanged(boolean z) {
    }

    class SmartGuideHideTask extends TimerTask {
        private SmartGuide mSmartGuide;

        SmartGuideHideTask(SmartGuide smartGuide) {
            this.mSmartGuide = smartGuide;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.mSmartGuide.changeVisibility(false, true);
        }
    }

    public SmartGuide(Context context, View view, SmartGuideComponent smartGuideComponent, ViewTransform viewTransform, float f, float f2) {
        this.mContext = context;
        this.mResources = context.getResources();
        this.mMainHandler = new Handler(context.getMainLooper());
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.mInflater = layoutInflaterFrom;
        this.mSmartGuideComponent = smartGuideComponent;
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        this.mParentLayout = viewGroup;
        this.mMenuWindow = new SmartGuideMenu(context, this, viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflaterFrom.inflate(C6033R.layout.smartguide_layout, viewGroup, false);
        this.mSmartGuideWindow = viewGroup2;
        viewGroup2.setVisibility(8);
        this.mSmartGuide = this.mSmartGuideWindow.findViewById(C6033R.id.smartguide_layout);
        this.mSmartGuideShadow = this.mSmartGuideWindow.findViewById(C6033R.id.smartguide_shadow);
        this.mBlockTypeButton = (ImageView) this.mSmartGuideWindow.findViewById(C6033R.id.block_type);
        this.mShapeMenuView = layoutInflaterFrom.inflate(C6033R.layout.shape_menu_layout, (ViewGroup) null);
        this.mTextMenuView = layoutInflaterFrom.inflate(C6033R.layout.text_menu_layout, (ViewGroup) null);
        this.mTagMenuView = layoutInflaterFrom.inflate(C6033R.layout.tag_menu_layout, (ViewGroup) null);
        SmartGuideCapture smartGuideCapture = (SmartGuideCapture) this.mSmartGuideWindow.findViewById(C6033R.id.prompter_horizontal_scroll);
        this.mScrollView = smartGuideCapture;
        smartGuideCapture.setParentViews(this, view);
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.disableTransitionType(0);
        this.mSmartGuideWindow.setLayoutTransition(layoutTransition);
        viewGroup.addView(this.mSmartGuideWindow, -2, -2);
        viewGroup.addView(this.mMenuWindow);
        this.mPrompters = new HashMap();
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.mBackgroundColor = typedValue.data;
        this.mCandidateOptions = false;
        this.mShowPrompter = true;
        this.mTimer = null;
        this.mHideSmartGuideTask = null;
        this.mSmartGuideWindowX = 0;
        this.mSmartGuideWindowY = 0;
        this.mMenuWindowY = 0;
        this.mCurrentOffsetY = (int) f2;
        this.mTransform = viewTransform;
        setLineGap(f);
        initMainButtonListener();
        initShapeButtonListener();
        initTextButtonListener();
        initTagMenuButtons();
        View viewFindViewById = this.mSmartGuideWindow.findViewById(C6033R.id.more);
        this.mMoreButton = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$0(view2);
            }
        });
        this.contextualMenuController = new SmartGuideContextualMenuController();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        showMoreMenu();
    }

    public void setCustomTypeface(Typeface typeface) {
        this.mCustomTypeface = typeface;
    }

    public void setBackgroundColor(int i) {
        if (i != this.mBackgroundColor) {
            if (i != 0) {
                i = ColorUtils.setAlphaComponent(i, this.mContext.getResources().getInteger(C6033R.integer.smartguide_background_alpha));
            }
            this.mBackgroundColor = i;
            if (this.mSmartGuideType != SmartGuideBlockType.Draft) {
                Drawable background = this.mSmartGuide.getBackground();
                int color = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
                if (color == 0) {
                    this.mSmartGuide.setBackgroundColor(this.mBackgroundColor);
                } else {
                    ObjectAnimator.ofArgb(this.mSmartGuide, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, color, this.mBackgroundColor).start();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerMarkSmartGuideComponentUIReady(boolean z) {
        SmartGuideComponent smartGuideComponent = this.mSmartGuideComponent;
        if (smartGuideComponent != null) {
            smartGuideComponent.setIsUIReady(z);
        }
    }

    private void initMainButtonListener() {
        this.mMainButtonListener = new View.OnClickListener() { // from class: com.myscript.atk.ui.SmartGuide.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SmartGuide.this.mIsAnimating) {
                    return;
                }
                SmartGuideEvent smartGuideEvent = (SmartGuideEvent) view.getTag();
                SmartGuideEvent.SmartGuideButtons smartGuideButtons = smartGuideEvent.type;
                int i = 2;
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                boolean z = false;
                SmartGuide.this.mMenuWindowX = iArr[0];
                int measuredHeight = SmartGuide.this.mSmartGuideWindowY + SmartGuide.this.mSmartGuideWindow.getMeasuredHeight();
                if (smartGuideButtons == SmartGuideEvent.SmartGuideButtons.SELECT_SHAPE) {
                    SmartGuide smartGuide = SmartGuide.this;
                    smartGuide.mMenuWindowX = smartGuide.mExtent.left - SmartGuide.this.mShapeMenuView.getPaddingLeft();
                    SmartGuide smartGuide2 = SmartGuide.this;
                    smartGuide2.mMenuWindowY = measuredHeight - smartGuide2.mShapeMenuView.getPaddingTop();
                    SmartGuide.this.showShapeMenu();
                    return;
                }
                if (smartGuideButtons == SmartGuideEvent.SmartGuideButtons.SELECT_TEXT) {
                    if (SmartGuide.this.mActionListener.isProcessPendingOrRequired()) {
                        return;
                    }
                    SmartGuide smartGuide3 = SmartGuide.this;
                    smartGuide3.mMenuWindowX = (iArr[0] - smartGuide3.mTextMenuView.getPaddingLeft()) - ((int) SmartGuide.this.mResources.getDimension(C6033R.dimen.menu_button_padding));
                    SmartGuide smartGuide4 = SmartGuide.this;
                    smartGuide4.mMenuWindowY = measuredHeight - smartGuide4.mTextMenuView.getPaddingTop();
                    SmartGuide.this.showTextMenu(smartGuideEvent.index);
                    if (SmartGuide.this.mSelectedWordControl != null) {
                        SmartGuide.this.mSelectedWordControl.unselect();
                    }
                    SmartGuide.this.mSelectedWordControl = (PrompterWordControl) view;
                    SmartGuide.this.mSelectedWordControl.select();
                    return;
                }
                if (smartGuideButtons == SmartGuideEvent.SmartGuideButtons.SELECT_TAG && SmartGuide.this.mPrompterBox != null && SmartGuide.this.mSmartGuideType == SmartGuideBlockType.Text) {
                    int tagType = SmartGuide.this.mPrompterBox.getTagType();
                    if (tagType == StyleType.H2.swigValue()) {
                        i = 1;
                    } else if (tagType == StyleType.UNORDERED_LIST.swigValue()) {
                        i = 3;
                    } else if (tagType == StyleType.ORDERED_LIST.swigValue()) {
                        i = 4;
                    } else if (tagType == StyleType.CHECK_LIST.swigValue()) {
                        i = 5;
                    }
                    SmartGuide smartGuide5 = SmartGuide.this;
                    smartGuide5.mMenuWindowX = smartGuide5.mExtent.left - SmartGuide.this.mTagMenuView.getPaddingLeft();
                    SmartGuide smartGuide6 = SmartGuide.this;
                    smartGuide6.mMenuWindowY = (measuredHeight - ((i + 1) * smartGuide6.getSmartGuideHeight())) - SmartGuide.this.mTagMenuView.getPaddingTop();
                    boolean z2 = SmartGuide.this.mPrompterBox != null;
                    int tagType2 = z2 ? SmartGuide.this.mPrompterBox.getTagType() : -1;
                    boolean z3 = z2 && (StyleType.H1.swigValue() & tagType2) != 0;
                    boolean z4 = z2 && (StyleType.H2.swigValue() & tagType2) != 0;
                    boolean z5 = z3 || z4;
                    boolean z6 = z2 && (StyleType.UNORDERED_LIST.swigValue() & tagType2) != 0;
                    boolean z7 = z2 && (StyleType.ORDERED_LIST.swigValue() & tagType2) != 0;
                    boolean z8 = z2 && (StyleType.CHECK_LIST.swigValue() & tagType2) != 0;
                    boolean z9 = z6 || z7 || (z2 && (tagType2 & StyleType.MIXED_LIST.swigValue()) != 0) || z8;
                    SmartGuide.this.mTagMenuView.findViewById(C6033R.id.tag_h1).setSelected(z3);
                    SmartGuide.this.mTagMenuView.findViewById(C6033R.id.tag_h2).setSelected(z4);
                    View viewFindViewById = SmartGuide.this.mTagMenuView.findViewById(C6033R.id.tag_p);
                    if (z2 && !z5 && !z9) {
                        z = true;
                    }
                    viewFindViewById.setSelected(z);
                    SmartGuide.this.mTagMenuView.findViewById(C6033R.id.tag_unordered_list).setSelected(z6);
                    SmartGuide.this.mTagMenuView.findViewById(C6033R.id.tag_ordered_list).setSelected(z7);
                    SmartGuide.this.mTagMenuView.findViewById(C6033R.id.tag_check_list).setSelected(z8);
                    SmartGuide smartGuide7 = SmartGuide.this;
                    smartGuide7.showMenu(smartGuide7.mTagMenuView);
                }
            }
        };
    }

    private void initShapeButtonListener() {
        this.mShapeListener = new View.OnClickListener() { // from class: com.myscript.atk.ui.SmartGuide.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SmartGuideEvent smartGuideEvent = (SmartGuideEvent) view.getTag();
                SmartGuideEvent.SmartGuideButtons smartGuideButtons = smartGuideEvent.type;
                SmartGuideComponent smartGuideComponent = SmartGuide.this.mSmartGuideComponent;
                if (smartGuideComponent != null) {
                    if (smartGuideButtons == SmartGuideEvent.SmartGuideButtons.SELECT_SHAPE) {
                        int i = smartGuideEvent.index;
                        smartGuideComponent.changeShapeCandidate((ShapeCandidate) SmartGuide.this.mPrompterShapeCandidate.get(i), i);
                        SmartGuide.this.mSmartGuideWindow.setVisibility(8);
                    } else if (smartGuideButtons == SmartGuideEvent.SmartGuideButtons.SELECT_DOODLE) {
                        smartGuideComponent.setAsDrawing();
                        SmartGuide.this.mSmartGuideWindow.setVisibility(8);
                    }
                }
                SmartGuide.this.mMenuWindow.setVisibility(8);
            }
        };
    }

    private void initTextButtonListener() {
        this.mTextListener = new View.OnClickListener() { // from class: com.myscript.atk.ui.SmartGuide.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SmartGuideEvent smartGuideEvent = (SmartGuideEvent) view.getTag();
                SmartGuideEvent.SmartGuideButtons smartGuideButtons = smartGuideEvent.type;
                SmartGuideComponent smartGuideComponent = SmartGuide.this.mSmartGuideComponent;
                if (smartGuideComponent != null) {
                    if (smartGuideButtons == SmartGuideEvent.SmartGuideButtons.SELECT_TEXT) {
                        smartGuideComponent.changeTextCandidate(SmartGuide.this.mPrompterWord, smartGuideEvent.index);
                    } else if (smartGuideButtons == SmartGuideEvent.SmartGuideButtons.SELECT_DOODLE) {
                        smartGuideComponent.setAsDrawing();
                        SmartGuide.this.mSmartGuideWindow.setVisibility(8);
                    }
                    smartGuideComponent.setIsUIReady(true);
                }
                SmartGuide.this.mMenuWindow.setVisibility(8);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTagMenuClicked(View view) {
        StyleType styleType;
        ActionListener actionListener;
        ActionListener actionListener2;
        ActionListener actionListener3;
        ActionListener actionListener4;
        ActionListener actionListener5;
        ActionListener actionListener6;
        SmartGuideEvent smartGuideEvent = (SmartGuideEvent) view.getTag();
        if (smartGuideEvent.type != SmartGuideEvent.SmartGuideButtons.SELECT_TAG) {
            return;
        }
        SmartGuideComponent smartGuideComponent = this.mSmartGuideComponent;
        int i = smartGuideEvent.index;
        if (i == 0) {
            styleType = StyleType.H1;
            if (smartGuideComponent != null && (actionListener = this.mActionListener) != null) {
                actionListener.onBlockTypeChanged(smartGuideComponent, styleType);
            }
        } else if (i == 1) {
            styleType = StyleType.H2;
            if (smartGuideComponent != null && (actionListener2 = this.mActionListener) != null) {
                actionListener2.onBlockTypeChanged(smartGuideComponent, styleType);
            }
        } else if (i == 2) {
            styleType = StyleType.NORMAL;
            if (smartGuideComponent != null && (actionListener3 = this.mActionListener) != null) {
                actionListener3.onTextify(smartGuideComponent);
            }
        } else if (i == 3) {
            styleType = StyleType.UNORDERED_LIST;
            if (smartGuideComponent != null && (actionListener4 = this.mActionListener) != null) {
                actionListener4.onListify(smartGuideComponent, "•");
            }
        } else if (i == 4) {
            styleType = StyleType.ORDERED_LIST;
            if (smartGuideComponent != null && (actionListener5 = this.mActionListener) != null) {
                actionListener5.onListify(smartGuideComponent, "1.");
            }
        } else {
            if (i != 5) {
                return;
            }
            styleType = StyleType.CHECK_LIST;
            if (smartGuideComponent != null && (actionListener6 = this.mActionListener) != null) {
                actionListener6.onListify(smartGuideComponent, "☐");
            }
        }
        this.mPrompterBox.setTagType(styleType.swigValue());
        updateBlockTypeButton();
        hideMenu();
    }

    private void initTagMenuButtons() {
        View viewFindViewById = this.mTagMenuView.findViewById(C6033R.id.tag_h1);
        viewFindViewById.setTag(new SmartGuideEvent(SmartGuideEvent.SmartGuideButtons.SELECT_TAG, 0));
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onTagMenuClicked(view);
            }
        });
        View viewFindViewById2 = this.mTagMenuView.findViewById(C6033R.id.tag_h2);
        viewFindViewById2.setTag(new SmartGuideEvent(SmartGuideEvent.SmartGuideButtons.SELECT_TAG, 1));
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onTagMenuClicked(view);
            }
        });
        View viewFindViewById3 = this.mTagMenuView.findViewById(C6033R.id.tag_p);
        viewFindViewById3.setTag(new SmartGuideEvent(SmartGuideEvent.SmartGuideButtons.SELECT_TAG, 2));
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onTagMenuClicked(view);
            }
        });
        View viewFindViewById4 = this.mTagMenuView.findViewById(C6033R.id.tag_unordered_list);
        viewFindViewById4.setTag(new SmartGuideEvent(SmartGuideEvent.SmartGuideButtons.SELECT_TAG, 3));
        viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onTagMenuClicked(view);
            }
        });
        View viewFindViewById5 = this.mTagMenuView.findViewById(C6033R.id.tag_ordered_list);
        viewFindViewById5.setTag(new SmartGuideEvent(SmartGuideEvent.SmartGuideButtons.SELECT_TAG, 4));
        viewFindViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onTagMenuClicked(view);
            }
        });
        View viewFindViewById6 = this.mTagMenuView.findViewById(C6033R.id.tag_check_list);
        viewFindViewById6.setTag(new SmartGuideEvent(SmartGuideEvent.SmartGuideButtons.SELECT_TAG, 5));
        viewFindViewById6.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onTagMenuClicked(view);
            }
        });
    }

    private void startSmartGuideHideTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer.purge();
        }
        this.mTimer = new Timer();
        SmartGuideHideTask smartGuideHideTask = new SmartGuideHideTask(this);
        this.mHideSmartGuideTask = smartGuideHideTask;
        this.mTimer.schedule(smartGuideHideTask, this.mResources.getInteger(C6033R.integer.autohide_delay));
    }

    private void stopSmartGuideHideTimer() {
        SmartGuideHideTask smartGuideHideTask = this.mHideSmartGuideTask;
        if (smartGuideHideTask != null) {
            smartGuideHideTask.cancel();
            this.mHideSmartGuideTask = null;
        }
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer.purge();
            this.mTimer = null;
        }
    }

    private void dismiss(boolean z) {
        SmartGuideMenu smartGuideMenu = this.mMenuWindow;
        if (smartGuideMenu != null && smartGuideMenu.isShown()) {
            this.mMenuWindow.setVisibility(8);
        }
        ViewGroup viewGroup = this.mSmartGuideWindow;
        if (viewGroup != null && viewGroup.isShown()) {
            if (z) {
                dismissWithFade();
                return;
            } else {
                this.mSmartGuideWindow.setVisibility(8);
                this.mSmartGuideWindow.findViewById(C6033R.id.block_type).setVisibility(8);
            }
        }
        innerMarkSmartGuideComponentUIReady(true);
    }

    private void dismissWithFade() {
        if (!this.mSmartGuideWindow.isShown() || this.mIsAnimating) {
            return;
        }
        ObjectAnimator objectAnimator = this.mFadeOutAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ViewGroup viewGroup = this.mSmartGuideWindow;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroup, "alpha", viewGroup.getAlpha(), 0.0f);
        this.mFadeOutAnimator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(this.mResources.getInteger(C6033R.integer.config_mediumAnimTime));
        this.mFadeOutAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.myscript.atk.ui.SmartGuide.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SmartGuide.this.mIsAnimating = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartGuide.this.mSmartGuideWindow.setVisibility(8);
                SmartGuide.this.mBlockTypeButton.setVisibility(8);
                SmartGuide.this.mSmartGuideWindow.setAlpha(1.0f);
                SmartGuide.this.innerMarkSmartGuideComponentUIReady(true);
                SmartGuide.this.mIsAnimating = false;
            }
        });
        this.mFadeOutAnimator.start();
    }

    private void showSmartGuide() {
        ObjectAnimator objectAnimator = this.mFadeOutAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        updateSmartGuideWindow();
        clearAnimation();
        this.mSmartGuideWindow.setVisibility(0);
        innerMarkSmartGuideComponentUIReady(true);
    }

    private void updateSmartGuideWindow() {
        this.mInitialOffset = this.mCurrentOffsetY;
        int smartGuideHeight = getSmartGuideHeight();
        int dimensionPixelSize = this.mResources.getDimensionPixelSize(C6033R.dimen.smartguide_shadow_height);
        this.mSmartGuideWindowX = this.mExtent.left - this.mSmartGuideWindow.getPaddingLeft();
        if (this.mSmartGuideType != SmartGuideBlockType.Draft) {
            this.mSmartGuideWindowY = (((this.mExtent.top - smartGuideHeight) - dimensionPixelSize) - this.mInitialOffset) + getSmartGuideOffsetY();
            this.mSmartGuideShadow.setVisibility(0);
            this.mSmartGuide.setBackgroundColor(this.mBackgroundColor);
        } else {
            this.mSmartGuideWindowY = (this.mExtent.top - this.mInitialOffset) - this.mSmartGuideWindow.getPaddingTop();
            this.mSmartGuideShadow.setVisibility(8);
            this.mSmartGuide.setBackgroundColor(0);
        }
        this.mMenuWindowY = this.mExtent.top - ((int) this.mLineGap);
        if (this.mSmartGuideWindowY < 0) {
            this.mSmartGuideWindowY = -dimensionPixelSize;
            this.mMenuWindowY = smartGuideHeight;
        }
        int minimumWidth = this.mSmartGuideWindow.getMinimumWidth();
        int iWidth = this.mExtent.width();
        if (iWidth >= minimumWidth) {
            minimumWidth = iWidth;
        }
        ViewGroup.LayoutParams layoutParams = this.mSmartGuide.getLayoutParams();
        layoutParams.width = minimumWidth;
        layoutParams.height = smartGuideHeight;
        this.mSmartGuide.setLayoutParams(layoutParams);
        this.mSmartGuideWindow.setX(this.mSmartGuideWindowX);
        this.mSmartGuideWindow.setY(this.mSmartGuideWindowY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSmartGuideHeight() {
        ActionListener actionListener = this.mActionListener;
        return (actionListener == null || !actionListener.hasSelection()) ? this.mSmartGuideHeight : this.mSmartGuideHeightWithSelection;
    }

    private int getSmartGuideOffsetY() {
        int dimensionPixelSize = this.mResources.getDimensionPixelSize(C6033R.dimen.selection_border_thickness);
        ActionListener actionListener = this.mActionListener;
        if (actionListener == null || !actionListener.hasSelection()) {
            return dimensionPixelSize;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMenu(View view) {
        if (this.mIsAnimating) {
            return;
        }
        stopSmartGuideHideTimer();
        view.setVisibility(0);
        this.mMenuWindow.removeAllViews();
        this.mMenuWindow.setLayoutParams(new FrameLayout.LayoutParams(this.mParentLayout.getWidth(), this.mParentLayout.getHeight()));
        this.mMenuWindow.setX(0.0f);
        this.mMenuWindow.setY(0.0f);
        this.mMenuWindow.setVisibility(0);
        view.measure(this.mParentLayout.getMeasuredWidth(), this.mParentLayout.getMeasuredHeight());
        int measuredHeight = view.getMeasuredHeight();
        int measuredWidth = view.getMeasuredWidth();
        int i = this.mMenuWindowY;
        if (i < 0) {
            this.mMenuWindowY = -this.mTagMenuView.getPaddingTop();
        } else if (i + measuredHeight > this.mParentLayout.getMeasuredHeight()) {
            this.mMenuWindowY = this.mParentLayout.getMeasuredHeight() - (measuredHeight + this.mTagMenuView.getPaddingBottom());
        }
        if (this.mMenuWindowX + measuredWidth > this.mParentLayout.getMeasuredWidth()) {
            this.mMenuWindowX = this.mParentLayout.getMeasuredWidth() - (measuredWidth + this.mTagMenuView.getPaddingEnd());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        view.setX(this.mMenuWindowX);
        view.setY(this.mMenuWindowY);
        this.mMenuWindow.addView(view, layoutParams);
        ValueAnimator valueAnimatorExpand = SmartGuideUtils.expand(view, this.mResources.getInteger(C6033R.integer.config_shortAnimTime) / 2);
        valueAnimatorExpand.addListener(new Animator.AnimatorListener() { // from class: com.myscript.atk.ui.SmartGuide.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SmartGuide.this.mIsAnimating = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartGuide.this.mIsAnimating = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                SmartGuide.this.mIsAnimating = false;
            }
        });
        valueAnimatorExpand.start();
        this.mMenuWindow.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showShapeMenu() {
        updateShapeCandidates();
        showMenu(this.mShapeMenuView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTextMenu(int i) {
        ScrollView scrollView = (ScrollView) this.mTextMenuView.findViewById(C6033R.id.text_menu_scrollview);
        scrollView.setVerticalScrollBarEnabled(false);
        updateTextCandidates(i);
        showMenu(this.mTextMenuView);
        scrollView.setVerticalScrollBarEnabled(true);
    }

    private void showMoreMenu() {
        ActionListener actionListener;
        View view;
        SmartGuideComponent smartGuideComponent = this.mSmartGuideComponent;
        if (smartGuideComponent == null || (actionListener = this.mActionListener) == null || (view = this.mMoreButton) == null) {
            return;
        }
        this.contextualMenuController.showMoreMenu(view, smartGuideComponent, actionListener);
    }

    void hideMenu() {
        if (this.mIsAnimating) {
            return;
        }
        if (this.mMenuWindow.isShown()) {
            View childAt = this.mMenuWindow.getChildAt(0);
            if (childAt == null) {
                return;
            }
            ValueAnimator valueAnimatorCollapse = SmartGuideUtils.collapse(childAt, this.mResources.getInteger(C6033R.integer.config_shortAnimTime) / 2);
            valueAnimatorCollapse.addListener(new Animator.AnimatorListener() { // from class: com.myscript.atk.ui.SmartGuide.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    SmartGuide.this.mIsAnimating = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SmartGuide.this.mIsAnimating = false;
                    SmartGuide.this.mMenuWindow.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    SmartGuide.this.mIsAnimating = false;
                }
            });
            valueAnimatorCollapse.start();
        }
        PrompterWordControl prompterWordControl = this.mSelectedWordControl;
        if (prompterWordControl != null) {
            prompterWordControl.unselect();
            this.mSelectedWordControl = null;
        }
    }

    private void updateShapeCandidates() {
        SmartGuideComponent smartGuideComponent = this.mSmartGuideComponent;
        if (smartGuideComponent == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.mShapeMenuView.findViewById(C6033R.id.shape_menu_linear_layout);
        linearLayout.removeAllViews();
        this.mPrompterShapeCandidate = smartGuideComponent.candidateLabelsForShape();
        linearLayout.addView(createShapeCandidateButton(C6033R.drawable.drawing_menu, this.mResources.getString(C6033R.string.set_as_doodle), false, new SmartGuideEvent(SmartGuideEvent.SmartGuideButtons.SELECT_DOODLE)), 0);
    }

    private View createShapeCandidateButton(int i, String str, boolean z, SmartGuideEvent smartGuideEvent) {
        float f = this.mResources.getDisplayMetrics().density;
        this.mResources.getDimension(C6033R.dimen.shape_menu_drawable_padding);
        int dimension = (int) (this.mResources.getDimension(C6033R.dimen.shape_menu_text_padding) / f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        ImageButton imageButton = new ImageButton(this.mContext);
        imageButton.setImageResource(i);
        imageButton.setClickable(false);
        Button button = (Button) this.mInflater.inflate(C6033R.layout.text_menu_button, (ViewGroup) null);
        button.setAllCaps(false);
        button.setGravity(19);
        button.setPadding(dimension, button.getPaddingTop(), dimension, button.getPaddingBottom());
        button.setText(str);
        button.setTextSize(0, this.mResources.getDimension(C6033R.dimen.prompter_text_size));
        button.setTypeface(null, z ? 1 : 0);
        button.setSingleLine();
        button.setClickable(false);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(this.mShapeListener);
        linearLayout.setTag(smartGuideEvent);
        linearLayout.setClickable(true);
        linearLayout.addView(imageButton, 0, layoutParams);
        linearLayout.addView(button, 1, layoutParams);
        return linearLayout;
    }

    private void updateTextCandidates(int i) {
        PrompterBox prompterBox;
        SmartGuideComponent smartGuideComponent = this.mSmartGuideComponent;
        if (smartGuideComponent == null || (prompterBox = this.mPrompterBox) == null) {
            return;
        }
        List<PrompterWord> words = prompterBox.getWords();
        if (i >= words.size()) {
            return;
        }
        PrompterWord prompterWord = words.get(i);
        this.mPrompterWord = prompterWord;
        List<String> listCandidateLabelsForWord = smartGuideComponent.candidateLabelsForWord(prompterWord);
        LinearLayout linearLayout = (LinearLayout) this.mTextMenuView.findViewById(C6033R.id.text_menu_linear_layout);
        linearLayout.removeAllViews();
        int i2 = 0;
        for (String str : listCandidateLabelsForWord) {
            Button button = (Button) this.mInflater.inflate(C6033R.layout.text_menu_button, (ViewGroup) null);
            button.setTag(new SmartGuideEvent(SmartGuideEvent.SmartGuideButtons.SELECT_TEXT, i2));
            button.setOnClickListener(this.mTextListener);
            button.setText(str);
            linearLayout.addView(button, i2);
            boolean zEquals = this.mPrompterWord.label().equals(str);
            button.setTypeface(this.mCustomTypeface, zEquals ? 1 : 0);
            if (zEquals) {
                button.setPressed(true);
            }
            i2++;
        }
        if (this.mCandidateOptions) {
            linearLayout.addView(createShapeCandidateButton(C6033R.drawable.drawing_menu, this.mResources.getString(C6033R.string.set_as_doodle), false, new SmartGuideEvent(SmartGuideEvent.SmartGuideButtons.SELECT_DOODLE)), i2);
        }
    }

    private void updatePrompterTextButtons(String str) {
        ViewGroup viewGroup = (ViewGroup) this.mSmartGuideWindow.findViewById(C6033R.id.prompter);
        if (!str.equals(this.mCurrentPrompterId)) {
            this.mCurrentPrompter = this.mPrompters.get(str);
        }
        int i = 0;
        if (this.mCurrentPrompter == null) {
            Prompter prompter = (Prompter) this.mInflater.inflate(C6033R.layout.prompter_layout, viewGroup, false);
            this.mCurrentPrompter = prompter;
            prompter.setListener(this.mMainButtonListener);
            this.mCurrentPrompter.setMinimumWidth(this.mScrollView.getMeasuredWidth() - this.mScrollView.getPaddingLeft());
            this.mCurrentPrompter.setCustomTypeface(this.mCustomTypeface);
        }
        this.mCurrentPrompter.setVisibility(this.mShowPrompter ? 0 : 4);
        List<PrompterWord> words = this.mCurrentPrompter.getWords();
        if (viewGroup.getChildCount() == 0 && !words.isEmpty()) {
            replacePrompterLayout(viewGroup, this.mCurrentPrompter);
            this.mCurrentPrompter.getAdapter().notifyDataSetChanged();
            this.mPrompters.put(str, this.mCurrentPrompter);
            return;
        }
        if (viewGroup != this.mCurrentPrompter && !str.equals(this.mCurrentPrompterId)) {
            replacePrompterLayout(viewGroup, this.mCurrentPrompter);
        }
        this.mCurrentPrompterId = str;
        PrompterBox prompterBox = this.mPrompterBox;
        if (prompterBox != null) {
            List<PrompterWord> words2 = prompterBox.getWords();
            this.mCurrentPrompter.setWords(words2);
            for (PrompterWord prompterWord : words2) {
                if (prompterWord.state() == PrompterWordState.New || prompterWord.state() == PrompterWordState.Update) {
                    this.mCurrentPrompter.scrollToPosition(i);
                }
                i++;
            }
            this.mPrompters.put(str, this.mCurrentPrompter);
        }
    }

    private void setVisibility(View view, int i) {
        if (view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    private synchronized void replacePrompterLayout(ViewGroup viewGroup, ViewGroup viewGroup2) {
        ViewGroup viewGroup3 = (ViewGroup) this.mSmartGuideWindow.findViewById(C6033R.id.prompter_horizontal_scroll);
        int iIndexOfChild = viewGroup3.indexOfChild(viewGroup);
        viewGroup3.removeViewAt(iIndexOfChild);
        viewGroup3.addView(viewGroup2, iIndexOfChild, new LinearLayout.LayoutParams(-1, -1));
    }

    private void updatePrompterShapeButton() {
        int iDrawableFromPrompterShapeSupport;
        PrompterShapeSupport prompterShapeSupport = this.mPrompterShape;
        if (prompterShapeSupport == null || prompterShapeSupport == PrompterShapeSupport.None) {
            return;
        }
        if (this.mPrompterShape == PrompterShapeSupport.DraftText || this.mPrompterShape == PrompterShapeSupport.DraftDrawing) {
            iDrawableFromPrompterShapeSupport = SmartGuideUtils.drawableFromPrompterShapeSupport(this.mPrompterShape, new ShapeCandidate("", true));
        } else {
            this.mPrompterShapeCandidate = Collections.EMPTY_LIST;
            SmartGuideComponent smartGuideComponent = this.mSmartGuideComponent;
            if (smartGuideComponent != null) {
                this.mPrompterShapeCandidate = smartGuideComponent.candidateLabelsForShape();
            }
            Iterator<ShapeCandidate> it = this.mPrompterShapeCandidate.iterator();
            while (true) {
                if (!it.hasNext()) {
                    iDrawableFromPrompterShapeSupport = -1;
                    break;
                }
                ShapeCandidate next = it.next();
                if (next.getSelected()) {
                    iDrawableFromPrompterShapeSupport = SmartGuideUtils.drawableFromPrompterShapeSupport(this.mPrompterShape, next);
                    break;
                }
            }
        }
        if (iDrawableFromPrompterShapeSupport > 0) {
            this.mBlockTypeButton.setImageDrawable(ResourcesCompat.getDrawable(this.mResources, iDrawableFromPrompterShapeSupport, this.mContext.getTheme()));
        }
        this.mBlockTypeButton.setOnClickListener(iDrawableFromPrompterShapeSupport == C6033R.drawable.drawing ? null : this.mMainButtonListener);
        this.mBlockTypeButton.setTag(new SmartGuideEvent(SmartGuideEvent.SmartGuideButtons.SELECT_SHAPE, 0));
        this.mBlockTypeButton.setEnabled(true);
        this.mBlockTypeButton.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateBlockTypeButton() {
        int i;
        SmartGuideBlockType smartGuideBlockType = this.mSmartGuideType;
        if (smartGuideBlockType == null) {
            return;
        }
        if (smartGuideBlockType == SmartGuideBlockType.Text) {
            PrompterBox prompterBox = this.mPrompterBox;
            if (prompterBox == null) {
                i = 0;
            } else {
                int tagType = prompterBox.getTagType();
                if (tagType == StyleType.NONE.swigValue()) {
                    setVisibility(this.mBlockTypeButton, 8);
                    return;
                }
                this.mBlockTypeButton.setTag(new SmartGuideEvent(SmartGuideEvent.SmartGuideButtons.SELECT_TAG));
                this.mBlockTypeButton.setOnClickListener(this.mMainButtonListener);
                this.mBlockTypeButton.setEnabled(true);
                if ((StyleType.H1.swigValue() & tagType) == StyleType.H1.swigValue()) {
                    i = C6033R.drawable.f1264h1;
                } else if ((StyleType.H2.swigValue() & tagType) == StyleType.H2.swigValue()) {
                    i = C6033R.drawable.f1265h2;
                } else if ((StyleType.NORMAL.swigValue() & tagType) == StyleType.NORMAL.swigValue()) {
                    i = C6033R.drawable.paragraph;
                } else if ((StyleType.UNORDERED_LIST.swigValue() & tagType) == StyleType.UNORDERED_LIST.swigValue()) {
                    i = C6033R.drawable.ic_tag_listbullet;
                } else if ((StyleType.ORDERED_LIST.swigValue() & tagType) == StyleType.ORDERED_LIST.swigValue()) {
                    i = C6033R.drawable.ic_tag_listnumber;
                } else if ((StyleType.CHECK_LIST.swigValue() & tagType) == StyleType.CHECK_LIST.swigValue()) {
                    i = C6033R.drawable.ic_tag_listcheck;
                } else if ((tagType & StyleType.MIXED_LIST.swigValue()) == StyleType.MIXED_LIST.swigValue()) {
                    i = C6033R.drawable.ic_tag_listmixed;
                }
            }
        } else {
            this.mBlockTypeButton.setEnabled(false);
            if (this.mSmartGuideType == SmartGuideBlockType.Draft) {
                setVisibility(this.mBlockTypeButton, 8);
                return;
            }
            if (this.mSmartGuideType == SmartGuideBlockType.Diagram) {
                i = C6033R.drawable.diagram;
            } else if (this.mSmartGuideType == SmartGuideBlockType.Math) {
                i = C6033R.drawable.math;
            } else {
                i = this.mSmartGuideType == SmartGuideBlockType.Sketch ? C6033R.drawable.sketch : 0;
            }
            this.mBlockTypeButton.setOnClickListener(null);
        }
        if (i != 0) {
            this.mBlockTypeButton.setImageDrawable(ResourcesCompat.getDrawable(this.mResources, i, this.mContext.getTheme()));
        }
        this.mBlockTypeButton.setVisibility(0);
    }

    private void textCandidateOptions(boolean z) {
        this.mCandidateOptions = z;
    }

    private void showOrHideMoreButton(boolean z) {
        int i = z ? 0 : 8;
        if (i != this.mMoreButton.getVisibility()) {
            this.mMoreButton.setVisibility(i);
        }
    }

    @Override // com.myscript.atk.p021ui.ISmartGuideComponentListener
    public void smartGuideTextUpdated(final Extent extent, final PrompterBox prompterBox, PrompterWord prompterWord, final boolean z, final boolean z2, final boolean z3, final boolean z4) {
        Handler handler = this.mMainHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$smartGuideTextUpdated$1(z3, extent, z2, prompterBox, z, z4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$smartGuideTextUpdated$1(boolean z, Extent extent, boolean z2, PrompterBox prompterBox, boolean z3, boolean z4) {
        if (this.mMainHandler == null) {
            return;
        }
        this.mShowPrompter = z;
        smartGuidePrompterChanged(z);
        setExtent(extent);
        showOrHideMoreButton(z2);
        this.mPrompterBox = prompterBox;
        this.mSmartGuideType = SmartGuideBlockType.Text;
        updateBlockTypeButton();
        textCandidateOptions(z3);
        updatePrompterTextButtons(this.mPrompterBox.getPrompterId());
        updateSmartGuideWindow();
        if (z4) {
            startSmartGuideHideTimer();
        } else {
            stopSmartGuideHideTimer();
        }
    }

    @Override // com.myscript.atk.p021ui.ISmartGuideComponentListener
    public void smartGuideBlockTypeUpdated(String str, final Extent extent, final SmartGuideBlockType smartGuideBlockType, final boolean z, final boolean z2) {
        Handler handler = this.mMainHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$smartGuideBlockTypeUpdated$2(extent, smartGuideBlockType, z, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$smartGuideBlockTypeUpdated$2(Extent extent, SmartGuideBlockType smartGuideBlockType, boolean z, boolean z2) {
        if (this.mMainHandler == null) {
            return;
        }
        setExtent(extent);
        this.mSmartGuideType = smartGuideBlockType;
        this.mScrollView.setHorizontalScrollBarEnabled(smartGuideBlockType == SmartGuideBlockType.Text);
        updateBlockTypeButton();
        if (this.mSmartGuideType != SmartGuideBlockType.Text) {
            updateSmartGuideWindow();
            showOrHideMoreButton(z);
            if (z2) {
                startSmartGuideHideTimer();
            } else {
                stopSmartGuideHideTimer();
            }
        }
    }

    @Override // com.myscript.atk.p021ui.ISmartGuideComponentListener
    public void smartGuideModelShapeUpdated(final Extent extent, final PrompterShapeSupport prompterShapeSupport, final boolean z, final boolean z2, boolean z3, final boolean z4) {
        Handler handler = this.mMainHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$smartGuideModelShapeUpdated$3(extent, prompterShapeSupport, z, z2, z4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$smartGuideModelShapeUpdated$3(Extent extent, PrompterShapeSupport prompterShapeSupport, boolean z, boolean z2, boolean z3) {
        if (this.mMainHandler == null) {
            return;
        }
        setExtent(extent);
        this.mPrompterShape = prompterShapeSupport;
        updatePrompterShapeButton();
        showOrHideMoreButton(z);
        boolean z4 = this.mShowPrompter & (!z2);
        this.mShowPrompter = z4;
        smartGuidePrompterChanged(z4);
        updateSmartGuideWindow();
        if (z3) {
            startSmartGuideHideTimer();
        } else {
            stopSmartGuideHideTimer();
        }
    }

    @Override // com.myscript.atk.p021ui.ISmartGuideComponentListener
    public void clearSmartGuide() {
        Handler handler = this.mMainHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearSmartGuide$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearSmartGuide$4() {
        if (this.mMainHandler == null) {
            return;
        }
        this.mPrompterBox = null;
        this.mPrompterWord = null;
        this.mPrompterShape = PrompterShapeSupport.None;
        this.mPrompterShapeCandidate = null;
        this.mSmartGuideType = null;
        stopSmartGuideHideTimer();
        Prompter prompter = this.mCurrentPrompter;
        if (prompter != null) {
            dismiss(false);
            prompter.clear();
            this.mPrompters.clear();
        }
        innerMarkSmartGuideComponentUIReady(true);
    }

    @Override // com.myscript.atk.p021ui.ISmartGuideComponentListener
    public void clearSmartGuide(final String str) {
        Handler handler = this.mMainHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearSmartGuide$5(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearSmartGuide$5(String str) {
        if (this.mMainHandler == null) {
            return;
        }
        clearPrompter();
        Prompter prompter = this.mPrompters.get(str);
        if (prompter != null) {
            prompter.clear();
        }
        this.mPrompters.remove(str);
        changeVisibility(false, false);
    }

    @Override // com.myscript.atk.p021ui.ISmartGuideComponentListener
    public void clearPrompter() {
        Handler handler = this.mMainHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearPrompter$6();
            }
        });
        innerMarkSmartGuideComponentUIReady(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearPrompter$6() {
        if (this.mMainHandler == null) {
            return;
        }
        ((Prompter) this.mSmartGuideWindow.findViewById(C6033R.id.prompter)).setVisibility(4);
    }

    @Override // com.myscript.atk.p021ui.ISmartGuideComponentListener
    public void changeVisibility(final boolean z, final boolean z2) {
        Handler handler = this.mMainHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$changeVisibility$7(z, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeVisibility$7(boolean z, boolean z2) {
        if (this.mMainHandler == null) {
            return;
        }
        if (z) {
            showSmartGuide();
        } else {
            this.mSmartGuideOutside = false;
            dismiss(z2);
        }
        innerMarkSmartGuideComponentUIReady(true);
    }

    private void smartGuidePrompterChanged(final boolean z) {
        Handler handler = this.mMainHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$smartGuidePrompterChanged$8(z);
            }
        });
        innerMarkSmartGuideComponentUIReady(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$smartGuidePrompterChanged$8(boolean z) {
        if (this.mMainHandler == null) {
            return;
        }
        View viewFindViewById = this.mSmartGuideWindow.findViewById(C6033R.id.prompter);
        this.mShowPrompter = z;
        if (z) {
            this.mScrollView.setHorizontalScrollBarEnabled(true);
            viewFindViewById.setVisibility(0);
        } else {
            this.mScrollView.setHorizontalScrollBarEnabled(false);
            viewFindViewById.setVisibility(4);
        }
    }

    private void setExtent(Extent extent) {
        ViewTransform viewTransform;
        synchronized (this.mTransformLock) {
            viewTransform = this.mTransform;
        }
        if (viewTransform == null) {
            return;
        }
        Point map = viewTransform.map(extent.getXMin(), extent.getYMin());
        Point map2 = viewTransform.map(extent.getXMax(), extent.getYMax());
        this.mExtent.set((int) map.getX(), (int) map.getY(), (int) map2.getX(), (int) map2.getY());
    }

    public void delete() {
        stopSmartGuideHideTimer();
        Handler handler = this.mMainHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        SmartGuideComponent smartGuideComponent = this.mSmartGuideComponent;
        this.mSmartGuideComponent = null;
        if (smartGuideComponent != null) {
            smartGuideComponent.delete();
        }
        PrompterBox prompterBox = this.mPrompterBox;
        if (prompterBox != null) {
            prompterBox.delete();
            this.mPrompterBox = null;
        }
        PrompterWord prompterWord = this.mPrompterWord;
        if (prompterWord != null) {
            prompterWord.delete();
            this.mPrompterWord = null;
        }
        synchronized (this.mTransformLock) {
            ViewTransform viewTransform = this.mTransform;
            if (viewTransform != null) {
                viewTransform.delete();
                this.mTransform = null;
            }
        }
    }

    public void setLineGap(float f) {
        if (this.mTransform == null) {
            return;
        }
        int dimensionPixelSize = this.mResources.getDimensionPixelSize(C6033R.dimen.selection_border_thickness);
        this.mLineGap = f / this.mTransform.scaleY();
        int iMax = Math.max(this.mSmartGuide.getMinimumHeight(), ((int) this.mLineGap) + (dimensionPixelSize * 2));
        this.mSmartGuideHeight = iMax;
        this.mSmartGuideHeightWithSelection = iMax - dimensionPixelSize;
        View viewFindViewById = this.mSmartGuideWindow.findViewById(C6033R.id.smartguide_layout);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        layoutParams.height = getSmartGuideHeight();
        viewFindViewById.setLayoutParams(layoutParams);
    }

    public void onScrollTo(int i) {
        this.mCurrentOffsetY = i;
        int i2 = i - this.mInitialOffset;
        int measuredHeight = this.mSmartGuideShadow.isShown() ? this.mSmartGuideShadow.getMeasuredHeight() : 0;
        if (((this.mExtent.bottom - this.mInitialOffset) - i2) - this.mSmartGuide.getMeasuredHeight() < 0) {
            if (this.mSmartGuideWindow.isShown()) {
                Handler handler = this.mMainHandler;
                if (handler == null) {
                    return;
                }
                handler.post(new Runnable() { // from class: com.myscript.atk.ui.SmartGuide$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onScrollTo$9();
                    }
                });
                this.mSmartGuideOutside = true;
            }
        } else if (this.mSmartGuideOutside) {
            clearAnimation();
            this.mSmartGuideWindow.setVisibility(0);
            this.mSmartGuideWindow.findViewById(C6033R.id.block_type).setVisibility(0);
            this.mSmartGuideOutside = false;
        }
        this.mSmartGuideWindowX = this.mExtent.left - this.mSmartGuideWindow.getPaddingLeft();
        int smartGuideHeight = getSmartGuideHeight();
        if (this.mSmartGuideType != SmartGuideBlockType.Draft) {
            this.mSmartGuideWindowY = ((((this.mExtent.top - this.mInitialOffset) - smartGuideHeight) - this.mSmartGuideShadow.getMeasuredHeight()) - i2) + getSmartGuideOffsetY();
        } else {
            this.mSmartGuideWindowY = (this.mExtent.top - this.mInitialOffset) - i2;
        }
        this.mSmartGuideWindowY = Math.max(-measuredHeight, this.mSmartGuideWindowY);
        int minimumWidth = this.mSmartGuideWindow.getMinimumWidth();
        int iWidth = this.mExtent.width();
        if (iWidth >= minimumWidth) {
            minimumWidth = iWidth;
        }
        ViewGroup.LayoutParams layoutParams = this.mSmartGuide.getLayoutParams();
        layoutParams.width = minimumWidth;
        layoutParams.height = smartGuideHeight;
        this.mSmartGuide.setLayoutParams(layoutParams);
        this.mSmartGuideWindow.setX(this.mSmartGuideWindowX);
        this.mSmartGuideWindow.setY(this.mSmartGuideWindowY);
        innerMarkSmartGuideComponentUIReady(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onScrollTo$9() {
        if (this.mMainHandler == null) {
            return;
        }
        dismissWithFade();
    }

    private void clearAnimation() {
        Animation animation = this.mSmartGuideWindow.getAnimation();
        if (animation != null) {
            animation.setAnimationListener(null);
        }
        this.mSmartGuideWindow.clearAnimation();
        this.mIsAnimating = false;
    }

    public void setActionListener(ActionListener actionListener) {
        this.mActionListener = actionListener;
    }

    public boolean requestActionMenuDismiss() {
        return this.contextualMenuController.finish();
    }
}

package com.myscript.atk.p021ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes4.dex */
public class SmartGuideMenu extends LinearLayout {
    private SmartGuide mSmartGuide;

    public SmartGuideMenu(Context context, SmartGuide smartGuide, ViewGroup viewGroup) {
        super(context);
        this.mSmartGuide = smartGuide;
        setLayoutParams(new FrameLayout.LayoutParams(viewGroup.getWidth(), viewGroup.getHeight()));
        setBackgroundColor(0);
        setClipToPadding(false);
        setVisibility(8);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        this.mSmartGuide.hideMenu();
        return true;
    }
}

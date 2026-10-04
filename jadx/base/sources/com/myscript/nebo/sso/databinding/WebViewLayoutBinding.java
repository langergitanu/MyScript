package com.myscript.nebo.sso.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.sso.C6821R;

/* JADX INFO: loaded from: classes7.dex */
public final class WebViewLayoutBinding implements ViewBinding {
    public final RelativeLayout activityWebViewChrome;
    private final FrameLayout rootView;
    public final ImageView webViewButtonBack;
    public final ImageView webViewButtonClose;
    public final ImageView webViewButtonForward;
    public final ImageView webViewButtonRefresh;
    public final LinearLayout webViewContent;
    public final ProgressBar webViewProgressBar;
    public final ProgressBar webViewProgressBarOverlap;
    public final WebView webViewWebView;

    private WebViewLayoutBinding(FrameLayout frameLayout, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, ProgressBar progressBar, ProgressBar progressBar2, WebView webView) {
        this.rootView = frameLayout;
        this.activityWebViewChrome = relativeLayout;
        this.webViewButtonBack = imageView;
        this.webViewButtonClose = imageView2;
        this.webViewButtonForward = imageView3;
        this.webViewButtonRefresh = imageView4;
        this.webViewContent = linearLayout;
        this.webViewProgressBar = progressBar;
        this.webViewProgressBarOverlap = progressBar2;
        this.webViewWebView = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static WebViewLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WebViewLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6821R.layout.web_view_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static WebViewLayoutBinding bind(View view) {
        int i = C6821R.id.activity_web_view_chrome;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = C6821R.id.web_view_button_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C6821R.id.web_view_button_close;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = C6821R.id.web_view_button_forward;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = C6821R.id.web_view_button_refresh;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = C6821R.id.web_view_content;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = C6821R.id.web_view_progress_bar;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                if (progressBar != null) {
                                    i = C6821R.id.web_view_progress_bar_overlap;
                                    ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                    if (progressBar2 != null) {
                                        i = C6821R.id.web_view_web_view;
                                        WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
                                        if (webView != null) {
                                            return new WebViewLayoutBinding((FrameLayout) view, relativeLayout, imageView, imageView2, imageView3, imageView4, linearLayout, progressBar, progressBar2, webView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

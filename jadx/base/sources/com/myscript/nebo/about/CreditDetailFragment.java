package com.myscript.nebo.about;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.about.CreditsActivity;

/* JADX INFO: loaded from: classes5.dex */
public class CreditDetailFragment extends Fragment {
    static final String CREDIT_DETAILS_INTENT_DESCRIPTION = "CreditDetailActivity#Description";
    static final String CREDIT_DETAILS_INTENT_TITLE = "CreditDetailActivity#Title";
    CreditsActivity.CreditData mData;

    public static CreditDetailFragment newInstance(int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(CREDIT_DETAILS_INTENT_TITLE, i);
        bundle.putInt(CREDIT_DETAILS_INTENT_DESCRIPTION, i2);
        CreditDetailFragment creditDetailFragment = new CreditDetailFragment();
        creditDetailFragment.setArguments(bundle);
        return creditDetailFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt(CREDIT_DETAILS_INTENT_TITLE);
            this.mData = new CreditsActivity.CreditData(i, arguments.getInt(CREDIT_DETAILS_INTENT_DESCRIPTION));
            getActivity().setTitle(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.credit_detail, viewGroup, false);
        if (this.mData != null) {
            TextView textView = (TextView) viewInflate.findViewById(C6079R.id.credit_details_content);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setLinksClickable(true);
            textView.setText(Html.fromHtml(getString(this.mData.content), 0));
        }
        return viewInflate;
    }
}

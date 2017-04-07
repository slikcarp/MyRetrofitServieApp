package com.mobileappscompany.training.myretrofitservieapp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by User on 2/23/2017.
 */

public class ListItemView extends LinearLayout {
    private TextView nameView;
    private TextView htmlUrl;
    private GitHub gitHub;

    public ListItemView(Context context) {
        super(context);
        init();
    }

    public ListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        nameView = (TextView) findViewById(R.id.nameView);
        htmlUrl = (TextView) findViewById(R.id.htmlUrlView);
    }

    public TextView getNameView() {
        return nameView;
    }

    public void setNameView(TextView nameView) {
        this.nameView = nameView;
    }

    public TextView getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(TextView htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public GitHub getGitHub() {
        return gitHub;
    }

    public void setGitHub(GitHub gitHub) {
        this.gitHub = gitHub;
        nameView.setText(gitHub.getName());
        htmlUrl.setText(gitHub.getHtmlUrl());
    }
}

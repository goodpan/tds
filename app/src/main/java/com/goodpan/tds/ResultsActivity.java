package com.goodpan.tds;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsActivity extends FragmentActivity
        implements FragmentCoversation.OnFragmentInteractionListener,
        FragmentFriends.OnFragmentInteractionListener,
        FragmentFind.OnFragmentInteractionListener,
        FragmentProfile.OnFragmentInteractionListener
        {
    protected static final String TAG = "MainActivity";
    private Fragment[] fragments;
    public FragmentCoversation homefragment;
    private FragmentFriends contactlistfragment;
    private FragmentFind findfragment;
    private FragmentProfile profilefragment;
    private ImageView[] imagebuttons;
    private TextView[] textviews;
    private int index;
    // 当前fragment的index
    private int currentTabIndex;
    private android.app.AlertDialog.Builder conflictBuilder;
    private android.app.AlertDialog.Builder accountRemovedBuilder;
    private ImageView iv_add;
    private ImageView iv_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        initView();
        iv_add = (ImageView) this.findViewById(R.id.iv_add);
        iv_search = (ImageView) this.findViewById(R.id.iv_search);
        iv_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }

        });
        iv_search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }

        });

        TextView tv_online = (TextView) this.findViewById(R.id.tv_online);
        tv_online.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }

        });
    }

    private void initView() {

        homefragment = new FragmentCoversation();
        contactlistfragment = new FragmentFriends();
        findfragment = new FragmentFind();
        profilefragment = new FragmentProfile();
        fragments = new Fragment[] { homefragment, contactlistfragment,
                findfragment, profilefragment };
        imagebuttons = new ImageView[4];
        imagebuttons[0] = (ImageView) findViewById(R.id.ib_weixin);
        imagebuttons[1] = (ImageView) findViewById(R.id.ib_contact_list);
        imagebuttons[2] = (ImageView) findViewById(R.id.ib_find);
        imagebuttons[3] = (ImageView) findViewById(R.id.ib_profile);
        imagebuttons[0].setSelected(true);

        textviews = new TextView[4];
        textviews[0] = (TextView) findViewById(R.id.tv_weixin);
        textviews[1] = (TextView) findViewById(R.id.tv_contact_list);
        textviews[2] = (TextView) findViewById(R.id.tv_find);
        textviews[3] = (TextView) findViewById(R.id.tv_profile);
        textviews[0].setTextColor(0xFF45C01A);
        // 添加显示第一个fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, homefragment)
                .add(R.id.fragment_container, contactlistfragment)
                .add(R.id.fragment_container, profilefragment)
                .add(R.id.fragment_container, findfragment)
                .hide(contactlistfragment).hide(profilefragment)
                .hide(findfragment).show(homefragment).commit();
    }
    public void onTabClicked(View view) {
        switch (view.getId()) {
            case R.id.re_weixin:
                index = 0;
                break;
            case R.id.re_contact_list:
                index = 1;
                break;
            case R.id.re_find:
                index = 2;
                break;
            case R.id.re_profile:
                index = 3;
                break;
        }

        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager()
                    .beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragment_container, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }
        imagebuttons[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        imagebuttons[index].setSelected(true);
        textviews[currentTabIndex].setTextColor(0xFF999999);
        textviews[index].setTextColor(0xFF45C01A);
        currentTabIndex = index;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

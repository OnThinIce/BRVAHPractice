package com.zlcp.brvahpractice.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zlcp.brvahpractice.R;
import com.zlcp.brvahpractice.adapter.HomeAdapter;
import com.zlcp.brvahpractice.entity.HomeItem;

import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mRecyclerView = findViewById(R.id.rv_list);
        initAdapter();
    }

    private void initAdapter() {
        BaseQuickAdapter homeAdapter = new HomeAdapter(R.layout.home_item_view, getHomeItemData());
        homeAdapter.openLoadAnimation();
        View top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) mRecyclerView.getParent(), false);
        homeAdapter.addHeaderView(top);
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HomeItem item = (HomeItem) adapter.getItem(position);
                Intent intent = new Intent(HomeActivity.this, item.getActivity());
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(homeAdapter);
    }

    private List<HomeItem> getHomeItemData() {
        return Arrays.asList(
                new HomeItem("Animation", AnimationUseActivity.class, R.mipmap.gv_animation),
                new HomeItem("MultipleItem", ChooseMultipleItemUseTypeActivity.class, R.mipmap.gv_multipleltem),
                new HomeItem("Header/Footer", HeaderAndFooterUseActivity.class, R.mipmap.gv_header_and_footer),
                new HomeItem("PullToRefresh", PullToRefreshUseActivity.class, R.mipmap.gv_pulltorefresh),
                new HomeItem("Section", SectionUseActivity.class, R.mipmap.gv_section),
                new HomeItem("EmptyView", EmptyVIewUseActivity.class, R.mipmap.gv_empty),
                new HomeItem("DragAndSwipe", ItemDragAndSwipeUseActivity.class, R.mipmap.gv_drag_and_swipe),
                new HomeItem("ItemClick", ItemClickActivity.class, R.mipmap.gv_item_click),
                new HomeItem("ExpandableItem", ExpandableUseActivity.class, R.mipmap.gv_expandable),
                new HomeItem("DataBinding", DataBindingUseActivity.class, R.mipmap.gv_databinding),
                new HomeItem("UpFetchData", UpFetchUseActivity.class, R.drawable.gv_up_fetch),
                new HomeItem("SectionMultipleItem", SectionMultipleItemUseActivity.class, R.mipmap.gv_multipleltem),
                new HomeItem("DiffUtil", DiffUtilActivity.class, R.mipmap.gv_databinding)
        );
    }
}

package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    private  int cnt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativelayout);

        TextView content = findViewById(R.id.tv_center);
        ViewGroup viewGroup = null;

        //viewgroup=..........
        //viewgroup 没有实现,就是示范地调用一下递归函数
        cnt=getAllChildViewCount(viewGroup);
        content.setText(cnt);
    }

    public int getAllChildViewCount(ViewGroup viewgroup) {
        int fCount=viewgroup.getChildCount();
        int totalCount = fCount;
        for(int i = 0 ; i < fCount ;i++ ){
            View view = viewgroup.getChildAt(i);
            if( view != null && view instanceof ViewGroup )
                totalCount += getAllChildViewCount((ViewGroup)view);
        }
        return totalCount;
    }
}

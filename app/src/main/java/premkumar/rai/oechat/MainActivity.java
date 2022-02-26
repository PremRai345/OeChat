package premkumar.rai.oechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import premkumar.rai.oechat.databinding.ActivityMainBinding;
import premkumar.rai.oechat.menu.CallsFragment;
import premkumar.rai.oechat.menu.ChatsFragment;
import premkumar.rai.oechat.menu.StatusFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setUpWithViewPager(Binding.viewPaper);
        Binding.tabLayout.setupWithViewPager(Binding.viewPaper);
        setSupportActionBar(Binding.toolabr);

        Binding.viewPaper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                changeFabICon(position);//Change icons in calls status and chats while change screen

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setUpWithViewPager(ViewPager viewPager) {
        MainActivity.SelectionsPagerAdapter adapter=new SelectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChatsFragment(),"Chats");
        adapter.addFragment(new StatusFragment(),"Status");
        adapter.addFragment(new CallsFragment(),"Calls");

        viewPager.setAdapter(adapter);


    }
    private  static class  SelectionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList=new ArrayList<>();
        private  final List<String> mFragmentTitleList=new ArrayList<>();

        public SelectionsPagerAdapter(FragmentManager manager){super(manager);}

        @Override
        public  Fragment getItem(int position){return mFragmentList.get(position);}

        @Override
        public int getCount(){return mFragmentList.size();}

        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position){return mFragmentTitleList.get(position);}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        switch (id){

            case R.id.ic_menu_search:Toast.makeText(MainActivity.this,"Action Search",Toast.LENGTH_LONG).show();break;
            case R.id.menu_more:Toast.makeText(MainActivity.this,"Action More",Toast.LENGTH_LONG).show();break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeFabICon(final int index){
        Binding.tabAction.hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (index){
                    case 0: Binding.tabAction.setImageDrawable(getDrawable(R.drawable.ic_round_chat_24));break;
                    case 1: Binding.tabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_photo_camera_24));break;
                    case 2: Binding.tabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_call_24));break;
                }
                Binding.tabAction.show();

            }
        },400);
    }
}
package wereh.gradedehorarios.apresentacao;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import wereh.gradedehorarios.Fragments.FiveFragment;
import wereh.gradedehorarios.Fragments.FourFragment;
import wereh.gradedehorarios.Fragments.OneFragment;
import wereh.gradedehorarios.Fragments.TreeFragment;
import wereh.gradedehorarios.Fragments.TwoFragment;
import wereh.gradedehorarios.R;

public class Inicio extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarActivityInicio);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpagerAtivityInicio);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Inicio.this, AddDisciplina.class);
                startActivity(i);
            }
        });

    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "Segunda");
        adapter.addFragment(new TwoFragment(), "Terça");
        adapter.addFragment(new TreeFragment(), "Quarta");
        adapter.addFragment(new FourFragment(), "Quinta");
        adapter.addFragment(new FiveFragment(), "Sexta");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();


        public ViewPagerAdapter(android.support.v4.app.FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);

        MenuItem m1 = menu.add(0, 0, 0,"Dicas");
        // m1.setIcon(R.mipmap.ic_launcher);
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

        MenuItem m2 = menu.add(0, 1, 1,"Todas as Disciplinas");
        //m1.setIcon(R.mipmap.ic_launcher);
        m2.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);


        MenuItem m3 = menu.add(0, 2, 2,"Sobre");
        //m1.setIcon(R.mipmap.ic_launcher);
        m3.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

        return(true);
    }

//    @Override
//    public boolean onMenuItemSelected(int panel, MenuItem item){
//
//        switch (item.getItemId()){
//            case 0:
//
//                Toast.makeText(this, "Item1 selecionado", Toast.LENGTH_SHORT).show();
//                break;
//            case 1:
//                Toast.makeText(this,"Item2 selecionado", Toast.LENGTH_SHORT).show();
//                break;
//            case 2:
//                Toast.makeText(this,"Item3 selecionado", Toast.LENGTH_SHORT).show();
//                break;
//
//        }
//        return(true);
//    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }



}
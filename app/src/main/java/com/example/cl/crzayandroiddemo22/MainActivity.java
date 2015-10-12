package com.example.cl.crzayandroiddemo22;
/**
 * �õ�ƬʽͼƬ�����
 */
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;


public class MainActivity extends Activity {

    int [] imageIds = new int[]{
      R.drawable.shuangzi,R.drawable.shuangyu,
            R.drawable.chunv,R.drawable.tiancheng,
            R.drawable.tianxie,R.drawable.sheshou,
            R.drawable.juxie,R.drawable.shuiping,
            R.drawable.shizi,R.drawable.baiyang,
            R.drawable.jinniu,R.drawable.mojie
    };
    Gallery gallery;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery = (Gallery) findViewById(R.id.gallery);
        //��ȡ��ʾͼƬ��ImageView����
        imageView = (ImageView) findViewById(R.id.imageView);
        //����һ��BaseAdapter���󣬸ö������ṩGallery����ʾ���б���
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }
            //�÷������ص�View������ÿ���б���
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //����һ��ImageView
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(imageIds[position]);
                //����ImageView����������
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                //ΪimageView���ò��ֲ���
                imageView.setLayoutParams(new Gallery.LayoutParams(75,100));
                TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
                imageView.setBackgroundResource(typedArray.getResourceId(R.styleable.
                        Gallery_android_galleryItemBackground,0));

                return imageView;
            }
        };
        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //��Galleryѡ������ı�ʱ�����÷���
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}

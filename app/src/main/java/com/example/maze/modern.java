package com.example.maze;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.maze.adapter.ItemAdapter_recycler_sonati;
import com.example.maze.model.Item_recycler;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class modern extends AppCompatActivity {
    RecyclerView recyclerView_modern;
    List<Item_recycler> mItem_modern = new ArrayList<>();
    ItemAdapter_recycler_sonati mAdapter_recycler_modern;
    ImageView search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modern);
        search=findViewById(R.id.btn_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(modern.this, com.example.maze.search.class));
            }
        });
        recyclerView_modern =findViewById(R.id.recycler_modern);
        mAdapter_recycler_modern = new ItemAdapter_recycler_sonati(mItem_modern,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView_modern.setLayoutManager(mLayoutManager);
        recyclerView_modern.setAdapter(mAdapter_recycler_modern);
        setModern();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView myListRecyclerView = findViewById(R.id.recycler_modern);
        myListRecyclerView.setLayoutManager(layoutManager);
    }

    public void setModern() {
        mItem_modern.add(new Item_recycler(R.drawable.hamberger1, "همبرگر",
                " گوشت چرخ کرده :100 گرم\n" +
                        "پنیر پیتزا :به مقدار دلخواه\n" +
                        "زرده تخم مرغ :دو عدد\n" +
                        "پیاز :یک عدد\n" +
                        "نمک :به میزان لازم\n" +
                        "فلفل :به میزان لازم\n" +
                        "پودر گردو :در صورت تمایل\n" +
                        "روغن :به میزان لازمهمبرگر\n",
                "پیاز را سرخ میکنیم و بعد به گوشت اضافه کرده و به خوبی مخلوط میکنیم .\n" +
                        "    زرده را به گوشت اضافه کرده به خوبی ماساژ میدهیم و بعد نیز نمک و فلفل را به آن اضافه میکنیم .\n" +
                        "    روی تخته پودر نان میپاشیم ، گلوله هایی به اندازه نارنگی از مواد را برداشته ، بروی تخته گرد کرده و نازک میکنیم ، سپس در تابه چدنی سرخ میکنیم .\n" +
                        "    بعد از این که همبرگر ها آماده شدند ، بر روی آنها مقداری پنیر پیتزا ریخته و آن را برای مدت زمان چند دقیقه درون فر میگذاریم تا پنیر باز شود .\n"));
        mItem_modern.add(new Item_recycler(R.drawable.meigusokhari1,
                "میگو سوخاری",
                "میگو: 1 کیلو\n" +
                        "آبلیمو: یک قاشق سوپخوری\n" +
                        "ماست:دو قاشق سوپخوری\n" +
                        "پیاز: یک عدد\n" +
                        "آرد : 2/3 لیوان\n" +
                        "تخم مرغ : یک عدد\n" +
                        "زعفران : نصف قاشق چایخوری\n" +
                        "نمک : به مقدار لازم\n" +
                        "بیکینگ پودر:یک قاشق چایخوری\n" +
                        "فلفل : به مقدار لازم\n",
                "     اول میگو را تمیز میکنیم پوست آن را کنده ، میشوییم و سپس آن را در آب پیاز که قبلا آن را رنده کرده و آب آن را جدا کرده ایم می ریزیم.\n" +
                        "            بعلاوه مقداری آبلیمو و فلفل سیاه. بعد آن را مخلوط می کنیم .\n" +
                        "            در ظرف را بسته و یک ساعت داخل یخچال قرار می دهیم . \n" +
                        "            سس مخصوص میگو پفکی را با مخلوط کردن آرد ، تخم مرغ، زعفران ، ماست ،بیکینگ پودر و نمک تهیه می کنیم. \n" +
                        "            سس ما نباید زیاد سفت یا شل باشد. اگر سفت شد مقداری ماست و اگر شل شد مقداری آرد به آن بیافزایید.\n" +
                        "            سپس میگوها را از آب پیاز خارج کرده و داخل مایع ریخته ، مخلوط کرده و در ظرف را گذاشته و نیم ساعت درون یخچال قرار می دهیم .\n" +
                        "              یک ظرف کوچک نچسب را روی اجاق گاز قرارداده و داخل آن روغن ریخته و می گذاریم داغ شود.\n" +
                        "            ظرف باید کوچک باشد تا روغن روی میگو ها را بگیرد، پس از اینکه روغن کاملاً داغ شد حرارت را پائین کشیده و میگوها را یکی یکی داخل روغن می ریزیم وقتی یک طرف آن طلایی شد ، میگو را بر می گردانیم تا طرف دیگر آن نیز طلایی شود ، دقت کنید حرارت مقداری باشد که روغن نسوزد .\n"));
        mItem_modern.add(new Item_recycler(R.drawable.pitzza1,
                "پیتزا پپرونی",
                "گوشت چرخ کرده:200گرم\n" +
                        "فلفل دلمه ای:1عدد\n" +
                        "رب گوجه فرنگی :3قاشق غذاخوری\n" +
                        "قارچ :200گرم\n" +
                        "پیاز :1عدد\n" +
                        "کالباس : 200گرم\n" +
                        "پنیرپیتزا :به مقدازلازم\n" +
                        "نمک فلفل پودر اویشن:به مقذار دلخواه\n",
                "  پیاز راخرد کنید ودرون ماهیتابه بامقداری روغن تفت بدهید تانرم شود سپس گوشت نمک فلفل وپودر اویشن رابه ان اضافه کرده وباحرارت ملایم تفت میدهیم!پس از اینکه رنگ گوشت تغییر کرد 1قاشق رب گوجه فرنگی اضافه نموده ودوباره تفت میدهیم وپس از 5دقیقه از روی حرارت اجاق برمیداریم!\n" +
                        "        کالباس رامکعبی خرد کنید پیاز راحلقه ای خرد کنید فلفل دلمه ای را ریز کرده مقداری زیتون هم ریز کنید!\n" +
                        "        خمیر پیتزا را نازک پهن کنید 2قاشق رب گوجه فرنگی راتفت داده تا بوی خامی ندهد سپس با قلمو روی خمیر پیتزا پخش کنید ومقداری پنیر بریزید وتمامی موادی راکه خرد کرده بودید(کالباس پیاز و...)به همراه مایه گوشتی روی خمیر بچینید ودر انتها با لایه کاملی از پنیر پیتزا پوشش دهیدوروی ان زیتون بریزیدو اجازه دهید پیتزای شما 20دقیقه بماند تا خمیر استراحت کند ودر زمان پخت خوب ترد وبرشته شود.\n" +
                        "        پیتزا را به مدت 15الی 20 دقیقه در طبقه وسط فر میگذاریم البته فر را باید از قبل در دمای 180 درجه گرم کنید!\n" +
                        "        در صورتیکه میخواهید روی پیتزای شما طلایی شود گریل بالا را روشن کنید ومواظب باشد پنیر پیتزایتان نسوزد! پیتزایتان را باسس دلخواه سرو نمایید\n"));
        mItem_modern.add(new Item_recycler(R.drawable.danesgzorat,
                "ذرت مکزیکی",
                "ذرت شیرین 500 گرم\n" +
                        "نمک و فلفل به میزان لازم\n" +
                        "قارچ 250 گرم\n" +
                        "پنیر پیتزا 100 گرم\n" +
                        "آویشن 1 ق چ\n" +
                        "کره 30 گرم\n" +
                        "روغن مایع 3 تا 4 ق س\n" +
                        "سس مایونز 1 و نیم پیمانه\n" +
                        "نمک 1 ق چ\n" +
                        "فلفل سیاه نصف ق چ\n" +
                        "فلفل قرمز 1/2 ق چ\n" +
                        "پودر گلپر 1 ق چ\n" +
                        "ادویه کاری 1/2 ق چ\n",
                "رای درست کردن ذرت مکزیکی میتوانید از ذرت های شیرین تازه و یا از کنسرو ذرت استفاده کنید.قارچ ها را هم خرد میکنیم و در یک قابلمه ای که 2/3 آن را پر از آب کردیم و مقداری آبلیمو ریختیم و روی حرارت به جوش آمد میریزیم و فقط در حدی که یک جوش بخورد داخل قابلمه نگه میداریم و سریع داخل آبکش میریزیم و زیر آب سرد نگه میداریم .\n" +
                        "بعد از این مراحل، کره و روغن مایع را داخل قابلمه ای میریزیم تا داغ شود و بعد ذرت را داخل کره و روغن کمی تفت میدهیم در حدی که طعم دار شوند. بعد قارچ ها ی بلانچ شده را داخل آن میریزیم و در حد هم زدن و مخلوط کردن تفت میدهیم .\n" +
                        "نمک ، فلفل ، و بقیه ادویه ها را هم اضافه میکنیم و هم میزنیم تا مواد روی حرارت گرم شوند .\n"));
        mItem_modern.add(new Item_recycler(R.drawable.daneshmakaroni,
                "ماکارونی",
                "ماکارونی:1 بسته\n" +
                        "فلفل دلمه:1عدد\n" +
                        "نخود فرنگی:100 گرم\n" +
                        "پیازمتوسط:2عدد\n" +
                        "رب:2 قاشق غذا خوری\n" +
                        "قارچ:200گرم\n" +
                        "گوشت چرخ کرده:300 گرم\n" +
                        "نمک و ادویه کاری:به مقدار لازم\n",
                "تابه ای را روی حرارت قرار دهید و مقداری روغن داخلش بریزید تا داغ شود. بعد پیاز را داخل روغن تفت دهید تا طلایی شود.  سپس گوشت را به پیاز سرخ شده اضافه کنید و تفت دهید  تا گوشت کمی سرخ شود و رنگش تغییر کند.\n" +
                        "بعد از تفت گوشت فلفل دلمه و قارچ خرد شده را هم به آن اضافه کنید و تفت دهید تا نرم شوند. در آخر رب گوجه را به مواد تفت داده شده اضافه کنید و کمی تفت دهید تا رنگ رب باز شود.\n" +
                        "و به همراه یک استکان آب جوش بگذارید تا گوشت بپزد و آب آن  کاملا جذب شود. در مرحله بعد ماکارونی را طبق دستور بپزید و آبکش کنید .\n" +
                        " ته قابلمه مورد نظر تان را چرب کنید و کف آن ته دیگ سیب زمینی بچینید و مقداری از ماکارونی را روی آن بریزید و روی ماکارونی مقداری آز مواد گوشت تفت داده شده بریزید و این لایه را آنقدر تکرار کنید تا تمام شوند.\n" +
                        "البته میتوانید ماکارونی و مایه گوشت را قبل ریختن در قابلمه با هم مخلوط کنید و یکجا در قابلمه بریزید و دم دهید.\n"));
    }
    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

package com.duongdk.hust.it4785.googleplaystoreclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listPopular : List<AppModel> = listOf(
            AppModel(R.drawable.candycrushsaga, "Candy Crush Saga", 4.6f, "Popular"),
            AppModel(R.drawable.covuachoivahoc, "Cờ vua - Chơi và học", 4.5f, "Popular"),
            AppModel(R.drawable.genshinimpact, "Genshin Impact", 4.3f, "Popular"),
            AppModel(R.drawable.hillclimbracing, "Hill Climb Racing", 4.2f, "Popular"),
            AppModel(R.drawable.plantsvszombies, "Plants vs. Zombies", 4.2f, "Popular"),
            AppModel(R.drawable.subwaysurfers, "Subway Surfers", 4.4f, "Popular"),
            AppModel(R.drawable.tombofthemask, "Tomb of the Mask", 4.2f, "Popular"),
            AppModel(R.drawable.trafficrider, "Traffic Rider", 4.3f, "Popular")
        )

        val listEducation : List<AppModel> = listOf(
            AppModel(R.drawable.lingqlearn45languages, "LingQ - Learn 45 languages", 4.7f, "Education"),
            AppModel(R.drawable._englishtuhoctienganh, "4English - Tự học tiếng Anh", 4.7f, "Eduaction"),
            AppModel(R.drawable.busuuhocngonngu, "Busuu - Học ngôn ngữ", 4.7f, "Education"),
            AppModel(R.drawable.hoclaptrinhpython, "Học lập trình Python", 4.8f, "Education"),
            AppModel(R.drawable.wikipedia, "Wikipedia", 4.6f, "Education"),
            AppModel(R.drawable.wolframalphaclassic, "WolframAlpha Classic", 4.8f, "Education")
        )

        val listEditVideoProfessionally : List<AppModel> = listOf(
            AppModel(R.drawable.canvathietkeanhvavideo, "Canva: Thiết kế, Ảnh và Video", 4.8f, "Edit videos professionally"),
            AppModel(R.drawable.wutacameraniceshotalways, "Wuta Camera - Nice Shot Always", 4.4f, "Edit videos professionally"),
            AppModel(R.drawable.vivavideochinhsuavideo, "VivaVideo - chỉnh sửa video", 4.3f, "Edit videos professionally"),
            AppModel(R.drawable.capcutchinhsuavideo, "Capcut - chỉnh sửa video", 4.2f, "Edit videos professionally"),
            AppModel(R.drawable.inshotchinhsuavideo, "InShot - chỉnh sửa video", 4.9f, "Edit videos professionally"),
            AppModel(R.drawable.vscochinhsuaanhvavideo, "VSCO: Chỉnh sửa Ảnh và Video", 2.0f, "Edit videos professionally"),
            AppModel(R.drawable.stopmotionstudio, "Stop Motion Studio", 3.9f, "Edit videos professionally"),
            AppModel(R.drawable.adobepremiererushvideo, "Adobe Premiere Rush: Video", 4.2f, "Edit videos professionally"),
            AppModel(R.drawable.tezzaaestheticeditor, "Tezza: Aesthetic Editor", 4.3f, "Edit videos professionally")
        )

        val listNews : List<AppModel> = listOf(
            AppModel(R.drawable.baomoitintucmoi24h, "Báo Mới - Tin mới 24h", 4.3f, "News"),
            AppModel(R.drawable.googlenews, "Google News", 4.3f, "News"),
            AppModel(R.drawable.thenewyorktimes, "The New York Times", 4.6f, "News"),
            AppModel(R.drawable.bbcnews, "BBC News", 4.6f, "News"),
            AppModel(R.drawable.investingcomchungkhoanfx, "Investing.com chứng khoán, FX", 4.7f, "News"),
            AppModel(R.drawable.nhkworld_japan, "NHK WORLD-JAPAN", 4.5f, "News")
        )

        val listHealthAndFitness : List<AppModel> = listOf(
            AppModel(R.drawable.mifitnessxiamiwear, "Mi Fitness (Xiaomi Wear)", 4.6f, "Health and fitness"),
            AppModel(R.drawable.wearosbygoogle, "Wear OS by Google", 3.4f, "Health and fitness"),
            AppModel(R.drawable.yaziofoodandcaloriecounter, "YAZIO Food & Calorie Counter", 4.7f, "Health and fitness"),
            AppModel(R.drawable.evolveselfcareandmeditation, "Evolve: Self-Care & Meditaion", 4.9f, "Health and fitness"),
            AppModel(R.drawable.fitifyfitnesshomeworkout, "Fitify: Fitness, Home Workout", 3.6f, "Health and fitness"),
            AppModel(R.drawable.caloriecarbandfatcounter, "Calorie, Carb & Fat Counter", 4.7f, "Health and fitness"),
            AppModel(R.drawable.aluxselfhelpandprodutivity, "Alux: Self-Help & Productivity", 5.0f, "Health and fitness")
        )

        val outerData: List<List<AppModel>> = listOf(listPopular, listEducation, listEditVideoProfessionally, listNews, listHealthAndFitness)

        val outerAdapter = OuterRecyclerViewAdapter(outerData)
        val listRow = findViewById<RecyclerView>(R.id.listRow)
        listRow.layoutManager = LinearLayoutManager(this)
        listRow.adapter = outerAdapter

        for (adapter in outerAdapter.innerAdapters) {
            adapter.notifyDataSetChanged()
        }
    }
}
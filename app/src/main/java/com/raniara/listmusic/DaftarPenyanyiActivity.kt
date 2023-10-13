package com.raniara.listmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DaftarPenyanyiActivity : AppCompatActivity() {
    private var isLinearLayout = true
    private lateinit var recyclerView: RecyclerView //global

    private val daftarPenyanyi = listOf(
        PenyanyiData("Adele", R.drawable.adele, listOf(
            LaguData("Rolling in the Deep", "21"),
            LaguData("Set Fire to the Rain", "21"),
            LaguData("Someone Like You", "21"),
            LaguData("Hello", "25"),
            LaguData("Send My Love (To Your New Lover)", "25"),
            LaguData("When We Were Young", "25"),
            LaguData("All I Ask", "25")
        )),
        PenyanyiData("Alessia Cara", R.drawable.alessia, listOf(
            LaguData("Scars to Your Beautiful", "Know-It-All"),
            LaguData("How Far I’ll Go (Moana Soundtrack)", "Moana Soundtrack"),
            LaguData("Stay ft Zedd", "Stay - Single"),
            LaguData("All We Know", "Know-It-All")
        )),
        PenyanyiData("Ariana Grande", R.drawable.arianna, listOf(
            LaguData("Problem", "My Everything"),
            LaguData("Break Free", "My Everything"),
            LaguData("On Last Time", "My Everything"),
            LaguData("Stuck with U ft Justin Bieber", "Stuck with U - Single"),
            LaguData("Into You", "Dangerous Woman"),
            LaguData("Thank U, Next", "Thank U, Next"),
            LaguData("Boyfriend ft Social House", "Boyfriend - Single"),
            LaguData("Positions", "Positions")
        )),
        PenyanyiData("Billie Eilish", R.drawable.billie, listOf(
            LaguData("Bad Guy", "When We All Fall Asleep, Where Do We Go?"),
            LaguData("Bury a Friend", "When We All Fall Asleep, Where Do We Go?"),
            LaguData("When the party’s over", "When We All Fall Asleep, Where Do We Go?"),
            LaguData("Lovely", "Don’t Smile At Me"),
            LaguData("Happier Than Ever", "Happier Than Ever"),
            LaguData("Therefore I Am", "Happier Than Ever")
        )),
        PenyanyiData("Bruno Mars", R.drawable.bruno, listOf(
            LaguData("Just The Way You Are", "Doo-Wops & Hooligans"),
            LaguData("Grenade", "Doo-Wops & Hooligans"),
            LaguData("The Lazy Song", "Doo-Wops & Hooligans"),
            LaguData("It Will Rain", "The Twilight Saga: Breaking Dawn – Part 1"),
            LaguData("When I Was Your Man", "Unorthodox Jukebox"),
            LaguData("Uptown Funk ft Mark Ronson", "Uptown Special"),
            LaguData("That’s What I Like", "24K Magic"),
            LaguData("Count On Me", "Doo-Wops & Hooligans"),
            LaguData("Talking to the Moon", "Doo-Wops & Hooligans"),
            LaguData("Nothin’ On You ft B.o.B", "B.o.B Presents: The Adventures of Bobby Ray"),
            LaguData("Runaway", "Doo-Wops & Hooligans")
        )),

        PenyanyiData("Charlie Puth", R.drawable.charlie, listOf(
            LaguData("Attention", "Voicenotes"),
            LaguData("Patient", "Voicenotes"),
            LaguData("One Call Away", "Nine Track Mind"),
            LaguData("Dangerously", "Nine Track Mind"),
            LaguData("We don’t Talk Anymore ft Selena Gomez", "Nine Track Mind"),
            LaguData("See You Again ft Wiz Khalifa", "Furious 7 Soundtrack"),
            LaguData("Cheating on You", "Single")
        )),
        PenyanyiData("Christina Perry", R.drawable.cristina, listOf(
            LaguData("A Thousand Years", "Lovestrong"),
            LaguData("Jar of Hearts", "Lovestrong"),
            LaguData("Distance", "Lovestrong"),
            LaguData("The Words", "Head or Heart")
        )),
        PenyanyiData("Ed Sheeran", R.drawable.ed, listOf(
            LaguData("Perfect", "÷"),
            LaguData("Shape Of You", "÷"),
            LaguData("Thinking Out Loud", "x"),
            LaguData("Photograph", "x"),
            LaguData("I Don’t Care ft Justin Bieber", "No.6 Collaborations Project"),
            LaguData("Castle On The Hill", "÷")
        )),
        PenyanyiData("Hindia", R.drawable.hindia, listOf(
            LaguData("Secukupnya", "Album Tidak Diketahui"),
            LaguData("Dehidrasi", "Album Tidak Diketahui"),
            LaguData("Evakuasi", "Album Tidak Diketahui"),
            LaguData("Besok Mungkin Kita Sampai", "Album Tidak Diketahui"),
            LaguData("Untuk Apa", "Album Tidak Diketahui"),
            LaguData("Apapun yang Terjadi", "Album Tidak Diketahui"),
            LaguData("Rumah ke Rumah", "Album Tidak Diketahui"),
            LaguData("Belum Tidur ft Sal Priadi", "Album Tidak Diketahui"),
            LaguData("Membasuh", "Album Tidak Diketahui"),
            LaguData("Jam Makan Siang", "Album Tidak Diketahui"),
            LaguData("Evaluasi", "Album Tidak Diketahui"),
            LaguData("Mata Air ft Natasha Udu", "Album Tidak Diketahui")
        )),
        PenyanyiData("Justin Bieber", R.drawable.justin, listOf(
            LaguData("Ghost", "Justice"),
            LaguData("Peaches", "Justice"),
            LaguData("Yummy", "Changes"),
            LaguData("Intentions", "Changes"),
            LaguData("I Don’t Care ft Ed Sheeran", "No.6 Collaborations Project"),
            LaguData("I’m The One", "Grateful (by DJ Khaled)"),
            LaguData("Company", "Purpose"),
            LaguData("Hold On", "Justice"),
            LaguData("Confident", "Journals"),
            LaguData("Sorry", "Purpose"),
            LaguData("Love Yourself", "Purpose")
        )),
        PenyanyiData("Nadin Amizah", R.drawable.nadin, listOf(
            LaguData("Bertaut", "Album Tidak Diketahui"),
            LaguData("Sorai", "Album Tidak Diketahui"),
            LaguData("Rumpang", "Album Tidak Diketahui"),
            LaguData("Amin Paling Serius", "Album Tidak Diketahui"),
            LaguData("Beranjak Dewasa", "Album Tidak Diketahui"),
            LaguData("Seperti Tulang", "Album Tidak Diketahui"),
            LaguData("Cermin", "Album Tidak Diketahui"),
            LaguData("Rayuan Perempuan Gila", "Album Tidak Diketahui"),
            LaguData("Semua Aku Dirayakan", "Album Tidak Diketahui")
        )),
        PenyanyiData("Sia", R.drawable.sia, listOf(
            LaguData("Unstoppable", "This Is Acting"),
            LaguData("Snowman", "Everyday Is Christmas"),
            LaguData("Chandelier", "1000 Forms of Fear"),
            LaguData("Genius ft Diplo, Labrinth", "LSD"),
            LaguData("Cheap Thrills ft Sean Paul", "This Is Acting"),
            LaguData("No New Friends ft Diplo, Labrinth", "LSD")
        )),
        PenyanyiData("Taylor Swift", R.drawable.taylor, listOf(
            LaguData("Shake it off", "1989"),
            LaguData("Style", "1989"),
            LaguData("Blank Space", "1989"),
            LaguData("Love Story", "Fearless"),
            LaguData("Red", "Red"),
            LaguData("22", "Red"),
            LaguData("Look What You Made Me Do", "Reputation"),
            LaguData("Back To December", "Speak Now")
        )),
        PenyanyiData("Raisa", R.drawable.raaisaa, listOf(
            LaguData("Usai di Sini", "Handmade"),
            LaguData("Kali Kedua", "Handmade"),
            LaguData("Mantan Terindah", "Raisa"),
            LaguData("Could it be", "Raisa"),
            LaguData("Terjebak Nostalgia", "Raisa"),
            LaguData("Teka-teki", "Raisa")
        )),
        PenyanyiData("Tulus", R.drawable.tulus, listOf(
            LaguData("Gajah", "Gajah"),
            LaguData("1000 Tahun Lamanya", "Single OST Tenggelamnya Kapal Van Der Wijck"),
            LaguData("Pamit", "Monokrom"),
            LaguData("Manusia Kuat", "Monokrom"),
            LaguData("Hati-Hati di Jalan", "Monokrom"),
            LaguData("Sepatu", "Sepatu"),
            LaguData("Baru", "Gajah")
        ))

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_penyanyi)

        recyclerView = findViewById(R.id.recyclerViewPenyanyi)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PenyanyiAdapter(daftarPenyanyi)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle("")
        setSupportActionBar(toolbar)


    }

    private fun toggleLayoutManager(){
        if (isLinearLayout){
            recyclerView.layoutManager = GridLayoutManager(this, 2)
            isLinearLayout = false
        } else{
            recyclerView.layoutManager = LinearLayoutManager(this)
            isLinearLayout = true
        }
        invalidateOptionsMenu()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_change_layout ->{
                toggleLayoutManager()
                true
            }
            else ->{
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val layoutMenuItem = menu?.findItem(R.id.action_change_layout)
        if (isLinearLayout){
            layoutMenuItem?.setIcon(R.drawable.ic_grid_view)
            layoutMenuItem?.title = "Ganti ke Grid Layout"
        }else{
            layoutMenuItem?.setIcon(R.drawable.ic_view_list)
            layoutMenuItem?.title = "Ganti ke Linear Layout"
        }
        return super.onPrepareOptionsMenu(menu)
    }

}


//    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//        val layoutMenuItem = menu?.findItem(R.id.action_change_layout)
//        if (isLinearLayout){
//            layoutMenuItem?.setIcon(R.drawable.ic_grid_view)
//            layoutMenuItem?.title = "Ganti ke Grid Layout"
//        }else{
//            layoutMenuItem?.setIcon(R.drawable.ic_view_list)
//            layoutMenuItem?.title = "Ganti ke Linear Layout"
//        }
//        return super.onPrepareOptionsMenu(menu)
//    }

package com.raniara.fraglistmuic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentSinger : Fragment() {
    private  var isLinearLayout = true
    private  lateinit var recyclerView: RecyclerView


    private val daftarPenyanyi: List<Singer> = listOf(
        Singer("Adele", R.drawable.adele, listOf(
            Song("Rolling in the Deep", "21"),
            Song("Set Fire to the Rain", "21"),
            Song("Someone Like You", "21"),
            Song("Hello", "25"),
            Song("Send My Love (To Your New Lover)", "25"),
            Song("When We Were Young", "25"),
            Song("All I Ask", "25")
        )),
        Singer("Alessia Cara", R.drawable.alessia, listOf(
            Song("Scars to Your Beautiful", "Know-It-All"),
            Song("How Far I’ll Go (Moana Soundtrack)", "Moana Soundtrack"),
            Song("Stay ft Zedd", "Stay - Single"),
            Song("All We Know", "Know-It-All")
        )),
        Singer("Ariana Grande", R.drawable.arianna, listOf(
            Song("Problem", "My Everything"),
            Song("Break Free", "My Everything"),
            Song("On Last Time", "My Everything"),
            Song("Stuck with U ft Justin Bieber", "Stuck with U - Single"),
            Song("Into You", "Dangerous Woman"),
            Song("Thank U, Next", "Thank U, Next"),
            Song("Boyfriend ft Social House", "Boyfriend - Single"),
            Song("Positions", "Positions")
        )),
        Singer("Billie Eilish", R.drawable.billie, listOf(
            Song("Bad Guy", "When We All Fall Asleep, Where Do We Go?"),
            Song("Bury a Friend", "When We All Fall Asleep, Where Do We Go?"),
            Song("When the party’s over", "When We All Fall Asleep, Where Do We Go?"),
            Song("Lovely", "Don’t Smile At Me"),
            Song("Happier Than Ever", "Happier Than Ever"),
            Song("Therefore I Am", "Happier Than Ever")
        )),
        Singer("Bruno Mars", R.drawable.bruno, listOf(
            Song("Just The Way You Are", "Doo-Wops & Hooligans"),
            Song("Grenade", "Doo-Wops & Hooligans"),
            Song("The Lazy Song", "Doo-Wops & Hooligans"),
            Song("It Will Rain", "The Twilight Saga: Breaking Dawn – Part 1"),
            Song("When I Was Your Man", "Unorthodox Jukebox"),
            Song("Uptown Funk ft Mark Ronson", "Uptown Special"),
            Song("That’s What I Like", "24K Magic"),
            Song("Count On Me", "Doo-Wops & Hooligans"),
            Song("Talking to the Moon", "Doo-Wops & Hooligans"),
            Song("Nothin’ On You ft B.o.B", "B.o.B Presents: The Adventures of Bobby Ray"),
            Song("Runaway", "Doo-Wops & Hooligans")
        )),

        Singer("Charlie Puth", R.drawable.charlie, listOf(
            Song("Attention", "Voicenotes"),
            Song("Patient", "Voicenotes"),
            Song("One Call Away", "Nine Track Mind"),
            Song("Dangerously", "Nine Track Mind"),
            Song("We don’t Talk Anymore ft Selena Gomez", "Nine Track Mind"),
            Song("See You Again ft Wiz Khalifa", "Furious 7 Soundtrack"),
            Song("Cheating on You", "Single")
        )),
        Singer("Christina Perry", R.drawable.cristina, listOf(
            Song("A Thousand Years", "Lovestrong"),
            Song("Jar of Hearts", "Lovestrong"),
            Song("Distance", "Lovestrong"),
            Song("The Words", "Head or Heart")
        )),
        Singer("Ed Sheeran", R.drawable.ed, listOf(
            Song("Perfect", "÷"),
            Song("Shape Of You", "÷"),
            Song("Thinking Out Loud", "x"),
            Song("Photograph", "x"),
            Song("I Don’t Care ft Justin Bieber", "No.6 Collaborations Project"),
            Song("Castle On The Hill", "÷")
        )),
        Singer("Hindia", R.drawable.hindia, listOf(
            Song("Secukupnya", "Album Tidak Diketahui"),
            Song("Dehidrasi", "Album Tidak Diketahui"),
            Song("Evakuasi", "Album Tidak Diketahui"),
            Song("Besok Mungkin Kita Sampai", "Album Tidak Diketahui"),
            Song("Untuk Apa", "Album Tidak Diketahui"),
            Song("Apapun yang Terjadi", "Album Tidak Diketahui"),
            Song("Rumah ke Rumah", "Album Tidak Diketahui"),
            Song("Belum Tidur ft Sal Priadi", "Album Tidak Diketahui"),
            Song("Membasuh", "Album Tidak Diketahui"),
            Song("Jam Makan Siang", "Album Tidak Diketahui"),
            Song("Evaluasi", "Album Tidak Diketahui"),
            Song("Mata Air ft Natasha Udu", "Album Tidak Diketahui")
        )),
        Singer("Justin Bieber", R.drawable.justin, listOf(
            Song("Ghost", "Justice"),
            Song("Peaches", "Justice"),
            Song("Yummy", "Changes"),
            Song("Intentions", "Changes"),
            Song("I Don’t Care ft Ed Sheeran", "No.6 Collaborations Project"),
            Song("I’m The One", "Grateful (by DJ Khaled)"),
            Song("Company", "Purpose"),
            Song("Hold On", "Justice"),
            Song("Confident", "Journals"),
            Song("Sorry", "Purpose"),
            Song("Love Yourself", "Purpose")
        )),
        Singer("Nadin Amizah", R.drawable.nadin, listOf(
            Song("Bertaut", "Album Tidak Diketahui"),
            Song("Sorai", "Album Tidak Diketahui"),
            Song("Rumpang", "Album Tidak Diketahui"),
            Song("Amin Paling Serius", "Album Tidak Diketahui"),
            Song("Beranjak Dewasa", "Album Tidak Diketahui"),
            Song("Seperti Tulang", "Album Tidak Diketahui"),
            Song("Cermin", "Album Tidak Diketahui"),
            Song("Rayuan Perempuan Gila", "Album Tidak Diketahui"),
            Song("Semua Aku Dirayakan", "Album Tidak Diketahui")
        )),
        Singer("Sia", R.drawable.sia, listOf(
            Song("Snowman", "Everyday Is Christmas"),
            Song("Chandelier", "1000 Forms of Fear"),
            Song("Genius ft Diplo, Labrinth", "LSD"),
            Song("Cheap Thrills ft Sean Paul", "This Is Acting"),
            Song("No New Friends ft Diplo, Labrinth", "LSD")
    )),
        Singer("Taylor Swift", R.drawable.taylor, listOf(
            Song("Shake it off", "1989"),
            Song("Style", "1989"),
            Song("Blank Space", "1989"),
            Song("Love Story", "Fearless"),
            Song("Red", "Red"),
            Song("22", "Red"),
            Song("Look What You Made Me Do", "Reputation"),
            Song("Back To December", "Speak Now")
        )),
        Singer("Raisa", R.drawable.raaisaa, listOf(
            Song("Usai di Sini", "Handmade"),
            Song("Kali Kedua", "Handmade"),
            Song("Mantan Terindah", "Raisa"),
            Song("Could it be", "Raisa"),
            Song("Terjebak Nostalgia", "Raisa"),
            Song("Teka-teki", "Raisa")
        )),
        Singer("Tulus", R.drawable.tulus, listOf(
            Song("Gajah", "Gajah"),
            Song("1000 Tahun Lamanya", "Single OST Tenggelamnya Kapal Van Der Wijck"),
            Song("Pamit", "Monokrom"),
            Song("Manusia Kuat", "Monokrom"),
            Song("Hati-Hati di Jalan", "Monokrom"),
            Song("Sepatu", "Sepatu"),
            Song("Baru", "Gajah")
        ))
    )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_singer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar: Toolbar = view.findViewById(R.id.toolbar_nav)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        setHasOptionsMenu(true)

        recyclerView = view.findViewById(R.id.recyclerViewPenyanyi)
        updateLayoutManager()
        recyclerView.adapter = SingerAdapter(daftarPenyanyi) { penyanyiDipilih ->

            val fragment = FragmentSong.newInstance(penyanyiDipilih)

            fragmentManager?.beginTransaction()
                ?.replace(R.id.container, fragment)
                ?.addToBackStack(null)
                ?.commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_combined, menu)
        super.onCreateOptionsMenu(menu, inflater)

        val item = menu.findItem(R.id.menu_switch_layout)
        item.icon = if (isLinearLayout) ContextCompat.getDrawable(requireContext(), R.drawable.ic_grid_view) else ContextCompat.getDrawable(requireContext(), R.drawable.ic_view_list)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("DEBUG_LAYOUT", "Is Linear Layout: $isLinearLayout")

        if (item.itemId == R.id.menu_switch_layout) {
            isLinearLayout = !isLinearLayout
            item.icon = if (isLinearLayout) {
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_view_list)
            } else {
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_grid_view)
            }
            updateLayoutManager()
            return true

        }
        return super.onOptionsItemSelected(item)
    }
    private fun updateLayoutManager() {
        recyclerView.layoutManager = null
        if(isLinearLayout){
            recyclerView.layoutManager = LinearLayoutManager(context)
        }else {
            recyclerView.layoutManager = GridLayoutManager(context,2)
        }
        recyclerView.adapter?.notifyDataSetChanged()
        recyclerView.invalidate()


    }

}
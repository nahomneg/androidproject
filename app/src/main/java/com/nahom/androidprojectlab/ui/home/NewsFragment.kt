package com.nahom.androidprojectlab.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nahom.androidprojectlab.R
import com.nahom.androidprojectlab.ui.AddNewsDialogFragment
import com.nahom.androidprojectlab.ui.NewsAdapter
import com.nahom.androidprojectlab.ui.NewsItem

class NewsFragment : Fragment(),AddNewsDialogFragment.AddNewsListener {

    private val newsList = ArrayList<NewsItem>()
    private lateinit var recyclerView : RecyclerView;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_news, container, false)

        newsList.add(NewsItem("https://phantom-marca.unidadeditorial.es/c78022d63aa8325f5914e0582c201777/resize/660/f/webp/assets/multimedia/imagenes/2024/04/14/17131060704372.jpg", "Bayern Munich call Zinedine Zidane", "Compartir en Facebook " +
                "Champions League. Arsenal and Bayern Munich leave tie in the balance " +
                "Bayern Munich. Alphonso Davies possible move to Real Madrid now on hold " +
                "Zinedine Zidane left Real Madrid and the dugout in June 2021. Since then, he has been approached by several teams such as Juventus, PSG and even rumors of him taking over the French national team (Real Madrid has never been an option).\n" +
                "\n"))
        newsList.add(NewsItem("https://phantom-marca.unidadeditorial.es/dfcec87b02c504f293985c22ffc7f216/resize/660/f/webp/assets/multimedia/imagenes/2024/04/12/17129537652237.jpg", "Luka Doncic gets unexpected NBA MVP Award", "But actually winning the MVP this season won't be an easy task for Luka Doncic, there are at least two players on the current rankings who are above the Slovenian point guard. Real Madrid posting this video has a clear intention, they want people to show their public support in a complicated race to be the best player in the league. Doncic is playing at some of the highest levels we've seen from his entire career but he has remained consistent despite the Dallas Mavericks not getting too far in the Playoffs. Right now, thre is another two team sin the West with better chances than him to compete for a trophy." +
                "\n"))
        newsList.add(NewsItem("https://phantom-marca.unidadeditorial.es/6d4626d16de57d9923869088c3bcb38e/resize/660/f/webp/assets/multimedia/imagenes/2024/04/10/17127439407022.jpg", "Pep Guardiola dons exclusive watch worth \$1.4m", "The Manchester City coach was seen wearing the 27-01 watch, a special edition timepiece that was designed by the brand as a tribute to Spanish tennis icon Rafael Nadal."))
        newsList.add(NewsItem("https://example.com/image4.jpg", "Mbappe would have come to Barcelona", "a new revelation suggests that when he was still a promising youngster at Monaco, there were talks with Barcelona about a possible move. Something that, had it come to fruition, would have completely changed the competition between the most powerful football teams in the Old Continent."))
        newsList.add(NewsItem("https://phantom-marca.unidadeditorial.es/fc35a19dc529ab9f8a96d8f3fa814f0c/resize/660/f/webp/assets/multimedia/imagenes/2024/04/09/17126631112981.png", "New photos of ex-Manchester United striker Chicharito at a party", "Javier 'Chicharito' Hernandez's first goal for Chivas Rayadas del Guadalajara turned into an event, to the extent that the striker continued the celebrations late into the night on Saturday."))

        recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = NewsAdapter(newsList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val fabAddNews = rootView.findViewById<FloatingActionButton>(R.id.fabAddNews)

        fabAddNews.setOnClickListener {
            val dialog = AddNewsDialogFragment()
            dialog.show(childFragmentManager, "AddNewsDialog")
            dialog.setAddNewsListener(object : AddNewsDialogFragment.AddNewsListener {
                @SuppressLint("NotifyDataSetChanged")
                override fun onNewsAdded(news: NewsItem) {
                    // Add the news to the list
                    newsList.add(0,news)
                    // Notify the adapter of the data set change
                    recyclerView.adapter?.notifyDataSetChanged()
                }
            })
        }

        return rootView
    }

    override fun onNewsAdded(news: NewsItem) {
        newsList.add(news)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
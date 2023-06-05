package com.nsicyber.biographyapp.fragments

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.nsicyber.biographyapp.R
import com.nsicyber.biographyapp.activities.ImageReviewActivity
import com.nsicyber.biographyapp.adapter.MyAdapter


class GalleryFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_gallery, container, false)
        with(view){
          recyclerView = findViewById(R.id.recyclerView)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Sample usage from your Activity/Fragment
        var list=ArrayList<String>()

        list.add("https://i.pinimg.com/originals/2a/7e/f4/2a7ef42f53c77aff9430de39e5dac24b.jpg")
        list.add("https://whatismyspiritanimal.com/wp-content/uploads/2016/12/Spirit-Animal-Quiz-Laughing-Funny-Alligator-Crocodile-500x500.png")
        list.add("https://f6y2v6d2.rocketcdn.me/wp-content/uploads/2020/05/LUMHOLTZ-tree-kangaroo-fnqlow.jpg")
        list.add("https://www.petlog.org.uk/media/1098/petlog-main-banner.jpg?mode=pad&width=1000&rnd=132696856600000000")
        list.add("https://i.pinimg.com/564x/05/f9/ae/05f9aedf7848a4caa10a9b9ec9989de9.jpg")
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTWAZbECuXrwGsabFQ5nDAYNcaW4r8AL4pdxQ&usqp=CAU")
        list.add("https://i.pinimg.com/originals/2a/7e/f4/2a7ef42f53c77aff9430de39e5dac24b.jpg")
        list.add("https://whatismyspiritanimal.com/wp-content/uploads/2016/12/Spirit-Animal-Quiz-Laughing-Funny-Alligator-Crocodile-500x500.png")
        list.add("https://f6y2v6d2.rocketcdn.me/wp-content/uploads/2020/05/LUMHOLTZ-tree-kangaroo-fnqlow.jpg")
        list.add("https://www.petlog.org.uk/media/1098/petlog-main-banner.jpg?mode=pad&width=1000&rnd=132696856600000000")
        list.add("https://i.pinimg.com/564x/05/f9/ae/05f9aedf7848a4caa10a9b9ec9989de9.jpg")
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTWAZbECuXrwGsabFQ5nDAYNcaW4r8AL4pdxQ&usqp=CAU")

            recyclerView.layoutManager = StaggeredGridLayoutManager(2,RecyclerView.VERTICAL)
            recyclerView.adapter = MyAdapter(list,requireContext())



    }

}

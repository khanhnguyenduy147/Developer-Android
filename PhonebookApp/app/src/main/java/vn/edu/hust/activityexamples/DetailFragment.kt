package vn.edu.hust.activityexamples

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.os.Parcel
import android.os.Parcelable
class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val name = view.findViewById<TextView>(R.id.name)
        val phone = view.findViewById<TextView>(R.id.phone)
        val email = view.findViewById<TextView>(R.id.email)

        val personInfo = arguments?.getParcelable<Person>("item")
        name.text = "${personInfo?.id.toString()}. ${personInfo?.name}"
        phone.text = "${personInfo?.phone}"
        email.text = "${personInfo?.email}"

        return view
    }

}
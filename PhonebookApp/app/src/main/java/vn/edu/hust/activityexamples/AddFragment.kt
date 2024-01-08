package vn.edu.hust.activityexamples

import android.R.attr.button
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import vn.edu.hust.activityexamples.DanhBa.Companion.items


class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_add, container, false)
        val name = view.findViewById<EditText>(R.id.name)
        val email = view.findViewById<EditText>(R.id.email)
        val phone = view.findViewById<EditText>(R.id.phone)
        val addbtn = view.findViewById<Button>(R.id.addBtn)

        addbtn.setOnClickListener(View.OnClickListener {
            val newPerson = Person(items.size + 1,
                name.text.toString(),
                resources.getIdentifier("ic_launcher_background", "drawable", activity?.packageName),
                phone.text.toString())
            items.add(newPerson)
            val bundle = Bundle()
            findNavController().navigate(R.id.action_addFragment_to_listFragment, bundle)
        })

        return view
    }

}
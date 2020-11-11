package com.udacity.shoestore.models

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

    private lateinit var binding:FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)

        val lp = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 5)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            val iterator = it.listIterator()
            for (item in iterator) {
                val _name = TextView(this.context)
                _name.text = item.name
                val _size = TextView(this.context)
                _size.text = item.size
                val _company = TextView(this.context)
                _company.text = item.company
                val _description = TextView(this.context)
                _description.text = item.description
                _name.setTextColor(Color.parseColor("#504359"))
                _size.setTextColor(Color.parseColor("#504359"))
                _company.setTextColor(Color.parseColor("#504359"))
                _description.setTextColor(Color.parseColor("#504359"))
                _name.textSize= 26F;
                _size.textSize=22F
                _company.textSize=20F
                _description.textSize=15F
                val parentLayout = LinearLayout(this.context)
                val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(5,0,5,25)
                parentLayout.orientation = LinearLayout.VERTICAL;

                parentLayout.setBackgroundColor(Color.parseColor("#efdcf5"))
                parentLayout.setPadding(10,10,10,10)
                parentLayout.addView(_name)
                parentLayout.addView(_size)
                parentLayout.addView(_company)
                parentLayout.addView(_description)
                binding.shoeListView.addView(parentLayout,params)


            }
        })


        binding.createShoeButton.setOnClickListener{
            val action= ShoeListFragmentDirections.actionShoeListFragmentToCreateShoeFragment()
            NavHostFragment.findNavController(this).navigate(action)

        }


        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.logout,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())||super.onOptionsItemSelected(item)
    }



}
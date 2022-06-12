package com.example.tarea2.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tarea2.R
import com.example.tarea2.databinding.FragmentProductBinding
import com.example.tarea2.viewmodel.ProductViewModel

class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private lateinit var productViewModel: ProductViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        productViewModel =
            ViewModelProvider(this).get(ProductViewModel::class.java)

        _binding = FragmentProductBinding.inflate(inflater, container, false)

        //binds to fragment_lugar.xml

        binding.btnAddProduct.setOnClickListener {
            findNavController().navigate(R.id.action_nav_product_to_addProductFragment) //take meto  fragment
        }

        //Activar recycler view

        return  binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
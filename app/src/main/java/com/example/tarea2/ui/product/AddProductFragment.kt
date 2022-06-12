package com.example.tarea2.ui.product
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tarea2.R
import com.example.tarea2.databinding.FragmentAddProductBinding
import com.example.tarea2.model.Product
import com.example.tarea2.viewmodel.ProductViewModel

class AddProductFragment : Fragment() {
    private var _binding : FragmentAddProductBinding? = null
    private val  binding get() = _binding!!
    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddProductBinding.inflate(inflater,container,false)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        binding.btnSubmit.setOnClickListener {
            addProduct()
        }

        return binding.root
    }

    private fun addProduct(){


        val name = binding.productName.text.toString()
        val brand = binding.productBrand.text.toString()
        val size = binding.productSize.text.toString()
        val location = binding.productLocation.text.toString()
        val price = binding.productPrice.text.toString()

        if(validation(name)
            && validation(brand)
            && validation(size)
            && validation(location)
            && validation(price)){
            //guardar lugar

            try {
                val product = Product(0,name,brand,price.toDouble(),location,size)
                productViewModel.addProduct(product) //enviando a la bd
                Toast.makeText(requireContext(), getString(R.string.msg_success), Toast.LENGTH_LONG).show()
            } catch (e: NumberFormatException) {
                Toast.makeText(requireContext(), getString(R.string.msg_txtondeci), Toast.LENGTH_LONG).show()
            }

        } else{
            Toast.makeText(requireContext(), getString(R.string.msg_error), Toast.LENGTH_LONG).show()
        }
    }

    private fun validation(nombre: String): Boolean {
        return !(nombre.isEmpty())
    }

}
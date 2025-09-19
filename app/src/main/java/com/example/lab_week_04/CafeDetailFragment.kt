package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView   // ✅ import TextView

// konstanta untuk key Bundle
private const val TAB_CONTENT = "TAB_CONTENT"

class CafeDetailFragment : Fragment() {

    // variabel untuk menyimpan isi konten
    private var content: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            content = it.getString(TAB_CONTENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout untuk fragment ini
        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ✅ tampilkan teks ke TextView
        val textView = view.findViewById<TextView>(R.id.content_description)
        textView.text = content ?: "Tidak ada konten"
    }

    companion object {
        fun newInstance(content: String) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(TAB_CONTENT, content)
                }
            }
    }
}

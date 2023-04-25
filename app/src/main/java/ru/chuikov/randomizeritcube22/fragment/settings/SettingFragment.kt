package ru.chuikov.randomizeritcube22.fragment.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.chuikov.randomizeritcube22.MainActivityViewModel
import ru.chuikov.randomizeritcube22.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingBinding.inflate(layoutInflater,container,false)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = viewModel.audiences.value?.let { InputAudienceAdapter(it) }
        binding.inputAudienceList.adapter = adapter
        binding.inputAudienceAdd.setOnClickListener {
            (binding.inputAudienceList.adapter as InputAudienceAdapter).add()
        }
        binding.inputAudienceRmlast.setOnClickListener {
            (binding.inputAudienceList.adapter as InputAudienceAdapter).removeLast()
        }
        binding.inputAudienceSave.setOnClickListener {
            val l = (binding.inputAudienceList.adapter as InputAudienceAdapter).getList()
            viewModel.setList(l)
        }


    }
}
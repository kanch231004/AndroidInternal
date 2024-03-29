package com.kanchan.androidinternal

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kanchan.androidinternal.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    companion object {
        val TAG = "FirstFragment"
        var count = 0
    }


    private  var binding: FragmentFirstBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach() called with: context = $context")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate() called with: savedInstanceState = $savedInstanceState")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated() called with: savedInstanceState = $savedInstanceState")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        Log.d(TAG, "onCreateView() called with: inflater = $inflater, container = $container, savedInstanceState = $savedInstanceState")
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

     /*   view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/

        binding?.buttonFirst?.setOnClickListener {
            fragmentManager?.beginTransaction()?.add(R.id.fragmentContainerView, SecondFragment())?.commit()
        }

        Log.d(TAG, "onViewCreated() called with: view = $view, savedInstanceState = $savedInstanceState")
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        Log.d(TAG, "onAttachFragment() called with: childFragment = $childFragment")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(TAG, "onViewStateRestored() called with: savedInstanceState = $savedInstanceState")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {

        Log.d(TAG, "onResume() called")
        if (count > 0) {
            Log.d("Message", "fragment callback received resume")
        }
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        Log.d(TAG, "onStop() called")
        count++
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView() called")
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy() called")
        count = 0
        super.onDestroy()
        binding = null
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach() called")
    }

    private fun checkAddFragmentWithBackStack() {
        fragmentManager
    }
}

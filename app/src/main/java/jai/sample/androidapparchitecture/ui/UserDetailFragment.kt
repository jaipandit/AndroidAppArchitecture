package jai.sample.androidapparchitecture.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import jai.sample.androidapparchitecture.R
import jai.sample.androidapparchitecture.SampleApplication
import jai.sample.androidapparchitecture.model.UserProfileViewModel
import javax.inject.Inject

class UserDetailFragment : Fragment() {

    companion object {
        private const val KEY_USER_ID = "user_id"

        fun instance(userId: String): UserDetailFragment {
            val userDetailFragment = UserDetailFragment()
            val bundle = Bundle()
            bundle.putString(KEY_USER_ID, userId)
            userDetailFragment.arguments = bundle
            return userDetailFragment
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: UserProfileViewModel by activityViewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity!!.application as SampleApplication).getDependencyInjector().inject(this)
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.userId = arguments?.getString(KEY_USER_ID)!!
    }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.userdetailfragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userLiveData.observe(viewLifecycleOwner) {

        }
    }

}
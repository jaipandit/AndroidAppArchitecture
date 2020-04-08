package jai.sample.androidapparchitecture.ui

import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jai.sample.androidapparchitecture.R
import jai.sample.androidapparchitecture.SampleApplication
import jai.sample.androidapparchitecture.data.User
import jai.sample.androidapparchitecture.di.ViewModelFactory
import jai.sample.androidapparchitecture.model.UserProfileViewModel
import javax.inject.Inject

class UserListFragment : Fragment() {

    lateinit var list: RecyclerView

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: UserProfileViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity!!.application as SampleApplication).getDependencyInjector().inject(this)
        viewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(UserProfileViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.userlistfragment, container, false)
        list = view.findViewById(R.id.list)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userLiveData.observe(viewLifecycleOwner, Observer{
            list.layoutManager = LinearLayoutManager(activity)
            list.adapter = RecyclerViewAdapter(it)

        })
    }

    class RecyclerViewAdapter(private val data: List<User>) : RecyclerView.Adapter<UserViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
                UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.userlist_item, parent, false))

        override fun getItemCount() = data.size
        override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.bind(data[position])
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userId: TextView = itemView.findViewById(R.id.userId)
        private val id: TextView = itemView.findViewById(R.id.id)
        private val title: TextView = itemView.findViewById(R.id.title)
        private val body: TextView = itemView.findViewById(R.id.body)

        fun bind(user: User) {
            userId.text = user.userId.toString()
            id.text = user.id.toString()
            title.text = user.title
            body.text = user.body
        }
    }
}
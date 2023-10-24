package kz.android.tron.presentation.adapters.movie_adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import javax.inject.Inject
import kz.android.tron.databinding.MovieItemRowBinding
import kz.android.tron.domain.model.Movie
import kz.android.tron.presentation.adapters.banner_adapter.BaseViewHolder
import kz.android.tron.presentation.adapters.banner_adapter.toBinding


class MovieAdapter @Inject constructor() : PagingDataAdapter<Movie, BaseViewHolder<MovieItemRowBinding>>(MovieDiffUtil) {

    var onMovieClickListener: ((Movie) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder<MovieItemRowBinding>(parent.toBinding())

    override fun onBindViewHolder(holder: BaseViewHolder<MovieItemRowBinding>, position: Int) {
        getItem(position)?.apply {
            holder.binding.movie = this
            holder.binding.root.setOnClickListener { onMovieClickListener?.invoke(this) }
        }
    }
    object MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {

        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

}

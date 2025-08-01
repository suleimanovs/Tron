package kz.android.tron.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kz.android.tron.domain.model.Movie
import kz.android.tron.domain.model.Review
import kz.android.tron.domain.model.Trailer

interface MovieRepository : BaseRepository {

    suspend fun getMovieById(id: Int): Result<Movie>

    fun searchMovie(query: String): Flow<PagingData<Movie>>

    fun getMovieReview(id: Int): Flow<PagingData<Review>>

    fun getMovieTrailer(id: Int): Flow<PagingData<Trailer>>

    fun getMovieList(sortBy: String): Flow<PagingData<Movie>>

    fun getMoviesByGenre(genreId: Int): Flow<PagingData<Movie>>
}
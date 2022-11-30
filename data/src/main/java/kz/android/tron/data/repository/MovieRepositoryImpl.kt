package kz.android.tron.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kz.android.tron.data.mapper.movieDtoListToMovieList
import kz.android.tron.data.mapper.movieDtoToMovie
import kz.android.tron.data.mapper.reviewDtoToReview
import kz.android.tron.data.mapper.trailerDtoToTrailer
import kz.android.tron.data.network.paging.*
import kz.android.tron.data.network.retrofit.ApiService
import kz.android.tron.domain.MovieRepository
import kz.android.tron.domain.model.Movie
import kz.android.tron.domain.model.Review
import kz.android.tron.domain.model.Trailer
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(private val service: ApiService) : MovieRepository {

    override fun getMovieList(sortBy: String): Flow<PagingData<Movie>> {
        val config = PagingConfig(pageSize = 10)
        return Pager(config) { MovieListDataSource(service, sortBy) }.flow
    }

    override suspend fun getMovieById(id: Int): Movie {
        return service.getMovieById(id).movieDtoToMovie()
    }

    override fun searchMovie(query: String): Flow<PagingData<Movie>> {
        val config = PagingConfig(pageSize = 10)
        return Pager(config) { SearchMovieListDataSource(service, query) }.flow

    }

    override fun getMovieReview(id: Int): Flow<PagingData<Review>> {
        val config = PagingConfig(pageSize = 10)
        return Pager(config) { ReviewListDataSource(service, id) }.flow
    }

    override fun getMovieTrailer(id: Int): Flow<PagingData<Trailer>> {
        val config = PagingConfig(pageSize = 1)
        return Pager(config) { TrailerListDataSource(service, id) }.flow
    }

    override fun getMoviesByGenre(genreId: Int): Flow<PagingData<Movie>> {
        val config = PagingConfig(pageSize = 10)
        return Pager(config) { MovieListByGenreDataSource(service, genreId) }.flow
    }
}
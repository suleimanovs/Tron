/**
 * Created by osmanboy on 2/17/2022.
 */
data class Movie(
//    @PrimaryKey(autoGenerate = true)
//    var uniqueId: Int = 0,
    val id: Int,
//    val adult: Boolean,
    val backdrop_path: String,
//    val genre_ids: List<Int>,
//    val original_language: String,
    val original_title: String,
    val overview: String,
//    val popularity: Double,
    val poster_path: String,
//    val big_poster_path: String,
    val release_date: String,
    val title: String,
//    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) {
//    constructor()
}
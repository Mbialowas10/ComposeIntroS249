package com.mbialowas.composeintros249.data

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val year: Int,
    var isFavorite: Boolean = false // added to track which movies farvorited movied
)

val moviesList = listOf<Movie>(
    Movie(1, "The Shawshank Redemption", "Two imprisoned men bond over several years, finding solace and eventual redemption through acts of common decency.", 1994, false),
    Movie(2, "The Crow", "Soulmates Eric and Shelly are brutally murdered when the demons of her dark past catch up with them. Given the chance to save his true love by sacrificing himself, Eric sets out to seek merciless revenge on their killers, traversing the worlds of the living and the dead to put the wrong things right.", 2024, false),
    Movie(3,"Uglies", "In a futuristic dystopia with enforced beauty standards, a teen awaiting mandatory cosmetic surgery embarks on a journey to find her missing friend.", 2024, false),
    Movie(4,"Beetlejuice Beetlejuice", "After a family tragedy, three generations of the Deetz family return home to Winter River. Still haunted by Beetlejuice, Lydia's life is turned upside down when her teenage daughter, Astrid, accidentally opens the portal to the Afterlife.", 2024, false),
    Movie(5, "Rebel Ridge", "yada yada", 2024, false )
)
const API_KEY = "8260bf8922d9bcce0924612b2add4b09"
const BASE_URL = 'http://localhost:8090'

const requests = {
  fetchTrending: `${BASE_URL}/movies/trending`,
  fetchNetflixOriginals: `${BASE_URL}/movies/netflixOriginals`,
  fetchTopRated: `${BASE_URL}/movies/topRated`,
  fetchActionMovies: `${BASE_URL}/movies/actionMovies`,
  fetchComedyMovies: `${BASE_URL}/movies/comedyMovies`,
  fetchHorrorMovies: `${BASE_URL}/movies/horrorMovies`,
  fetchRomanceMovies: `${BASE_URL}/movies/romanceMovies`,
  fetchDocumentaries: `${BASE_URL}/movies/documentaries`,
  fetchOne: `${BASE_URL}/movie`
}

export default requests

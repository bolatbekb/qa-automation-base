package backend.scheme

data class SeedExpected(
		val results: List<Result>,
		val info: Info
)

data class Result(
		val gender: String,
		val name: Name,
		val location: Location,
		val email: String,
		val login: Login,
		val dob: String,
		val registered: String,
		val phone: String,
		val cell: String,
		val id: Id,
		val picture: Picture,
		val nat: String
)

data class Login(
		val username: String,
		val password: String,
		val salt: String,
		val md5: String,
		val sha1: String,
		val sha256: String
)

data class Location(
		val street: String,
		val city: String,
		val state: String,
		val postcode: Int
)

data class Id(
		val name: String,
		val value: String
)

data class Picture(
		val large: String,
		val medium: String,
		val thumbnail: String
)

data class Name(
		val title: String,
		val first: String,
		val last: String
)

data class Info(
		val seed: String,
		val results: Int,
		val page: Int,
		val version: String
)
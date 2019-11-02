package api

type AthleteResponse struct {
	Id        int    `json:"id"`
	Username  string `json:"username"`
	Firstname string `json:"firstname"`
	Lastname  string `json:"lastname"`
}

type ShortAthlete struct {
	Id            int `json:"id"`
	ResourceState int `json:"id"`
}

type AthleteActivity struct {
	Id             int          `json:"id"`
	Athlete        ShortAthlete `json:"athlete"`
	StartDate      string       `json:"start_date"`
	StartDateLocal string       `json:"start_date_local"`
	Distance       float64      `json:"distance"`
}

type TokenResponse struct {
	AccessToken string       `json:"access_token"`
	TokenType   string       `json:"token_type"`
	Athlete     ShortAthlete `json:"athlete"`
	State       string       `json:"state"`
}

type Error struct {
	Code     string `json:"code"`
	Field    string `json:"code"`
	Resource string `json:"resource"`
}

type Fault struct {
	Errors  []Error `json:"errors"`
	Message string  `json:"message"`
}

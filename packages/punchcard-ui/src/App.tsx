import axios from 'axios'
import * as React from 'react'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'

import './App.css'
import loginButton from './btn_strava_connectwith_light.svg'

import { Dashboard } from './dashboard/Dashboard';
import { DistancesPage} from './distances/DistancesPage'
import { Header } from './header/Header'
import { IWeeklyResults } from "./heatmap/actions"


interface IAppState {
  error: any,
  isLoaded: boolean,
  weeklyResults: IWeeklyResults | null
}

function Login() {
  return (
    <a href="/api/strava/login">
        <img src={loginButton} alt="Connect with Strava" className="home-connect-btn" />
    </a>
  )
}


async function loadWeeklyResults(): Promise<IWeeklyResults> {
  const storageContents = sessionStorage.getItem("results")
  if (storageContents != null) {
    return Promise.resolve(JSON.parse(storageContents))
  } else {
    const response = await axios
      .get("/api/punchcard");
    const data = response.data;
    sessionStorage.setItem("results", JSON.stringify(data));
    return data;
  }
}

class App extends React.Component<{}, IAppState> {
  private componentIsMounted: boolean

  constructor(props: any) {
    super(props)
    this.componentIsMounted = false
    this.state = {
      error: null,
      isLoaded: false,
      weeklyResults: null
    }
  }

  public componentDidMount() {
    this.componentIsMounted = true;
    loadWeeklyResults()
      .then(
        (data: IWeeklyResults) => {
          if (this.componentIsMounted) {
            this.setState({
              isLoaded: true,
              weeklyResults: data
            })
          }
        },
        (error) => {
          if (this.componentIsMounted) {
            this.setState({
              error: `Failed to load data from server: ${error.response.data}`,
              isLoaded: true
            })
          }
        })
  }

  public render() {
    return (
      <Router>
        <div className="App container-fluid">
          <Header />

          <div className="row justify-content-center">
            <Switch>
              <Route path="/dashboard/distances">
                <DistancesPage />
              </Route>

              <Route path="/dashboard">
                <Dashboard {...this.state} />
              </Route>

              <Route path="/">
                <Login />
              </Route>
            </Switch>
          </div>

          <footer>
            <div className="row justify-content-center">
              <div className="col-sm">
                <p className="text-center">
                  <a className="strava-link" href="https://strava.com">View on Strava</a>
                </p>
              </div>
            </div>
          </footer>
        </div>
      </Router>
    )
  }

  public componentWillUnmount() {
    this.componentIsMounted = false
  }
}

export default App;

import axios from 'axios'
import * as React from 'react'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'

import './App.css'
import loginButton from './btn_strava_connectwith_light.svg'

import { Dashboard } from './dashboard/Dashboard';
import { DistancesPage} from './distances/DistancesPage'
import { IDistanceResults } from './distances/actions'
import { Header } from './header/Header'
import { IWeeklyResults } from "./heatmap/actions"


interface IAppState {
  error: any,
  isLoaded: boolean,
  weeklyResults: IWeeklyResults | null,
  distanceResuls: IDistanceResults | null,
}

interface IRemoteData {
  weeklyResults: IWeeklyResults | null,
  distanceResults: IDistanceResults | null,
}

function Login() {
  return (
    <a href="/api/strava/login">
        <img src={loginButton} alt="Connect with Strava" className="home-connect-btn" />
    </a>
  )
}

async function loadDistanceResults(): Promise<IDistanceResults> {
  const sessionKey = "distancesResults"
  const endpoint = "/api/distances"

  const storageContents = sessionStorage.getItem(sessionKey)
  if (storageContents != null) {
    return Promise.resolve(JSON.parse(storageContents))
  } else {
    const response = await axios
      .get(endpoint);
    const data = response.data;
    sessionStorage.setItem(sessionKey, JSON.stringify(data));
    return data;
  }
}

async function loadWeeklyResults(): Promise<IWeeklyResults> {
  const sessionKey = "results"
  const endpoint = "/api/punchcard"

  const storageContents = sessionStorage.getItem(sessionKey)
  if (storageContents != null) {
    return Promise.resolve(JSON.parse(storageContents))
  } else {
    const response = await axios
      .get(endpoint);
    const data = response.data;
    sessionStorage.setItem(sessionKey, JSON.stringify(data));
    return data;
  }
}

async function loadRemoteData(): Promise<IRemoteData> {
  const weeklyResults = loadWeeklyResults()
  const distanceResults = loadDistanceResults()

  return {
    weeklyResults: (await weeklyResults),
    distanceResults: (await distanceResults)
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
      weeklyResults: null,
      distanceResuls: null,
    }
  }

  public componentDidMount() {
    this.componentIsMounted = true;
    loadRemoteData()
      .then(
        ({weeklyResults, distanceResults}: IRemoteData) => {
          if (this.componentIsMounted) {
            this.setState({
              isLoaded: true,
              weeklyResults: weeklyResults,
              distanceResuls: distanceResults
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
                <DistancesPage distances={this.state.distanceResuls}/>
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

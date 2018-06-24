import axios, {AxiosResponse} from 'axios'
import * as React from 'react'

import './App.css'
import logo from './logo.svg'

import {buildWeeklyGrid, IWeeklyResults} from "./heatmap/actions"
import {WeekMap} from './heatmap/WeekMap'

interface IAppState {
  error: any,
  isLoaded: boolean,
  weeklyResults: IWeeklyResults | null
}

class App extends React.Component<{}, IAppState> {
  constructor(props: any) {
    super(props)
    this.state = {
      error: null,
      isLoaded: false,
      weeklyResults: null
    }
  }

  public componentDidMount() {
    axios.get("/api/punchcard")
      .then(
        (response: AxiosResponse<IWeeklyResults>) => {
          this.setState({
            isLoaded: true,
            weeklyResults: response.data
          })
        },
        (error) => {
          this.setState({
            error: `Failed to load data from server: ${error.response.data}`,
            isLoaded: true
          })
        })
  }

  public render() {
    const {error, isLoaded, weeklyResults} = this.state;

    if (isLoaded && weeklyResults != null) {
      return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <h1 className="App-title">Welcome to React</h1>
          </header>
          <WeekMap data={buildWeeklyGrid(weeklyResults)}/>
        </div>
      );
    } else {
      return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <h1 className="App-title">Welcome to React</h1>
          </header>
          <p className="App-intro">
            {error}
          </p>
        </div>
      );
    }
  }
}

export default App;

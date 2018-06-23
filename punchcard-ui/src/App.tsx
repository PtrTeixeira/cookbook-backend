import * as React from 'react';
import HeatMap from 'react-heatmap-grid';
import './App.css';

import logo from './logo.svg';

const xLabels = new Array(24).fill(0).map((e, i) => `${i}`)
const yLabels = ['MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY'];

const data = new Array(yLabels.length)
  .fill(0)
  .map(e => new Array(xLabels.length).fill(0));

data[1][4] = 2;


class App extends React.Component {
  public render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.tsx</code> and save to reload.
        </p>
        <HeatMap xLabels={xLabels} yLabels={yLabels} data={data} />
      </div>
    );
  }
}




export default App;

import * as React from 'react'
import * as ReactDOM from 'react-dom'

const App = () => <span>Hello, React!</span>;

console.log("Module ran!")
ReactDOM.render(
  // <div>Hello!</div>,
  <App />,
  document.getElementById('root')
);

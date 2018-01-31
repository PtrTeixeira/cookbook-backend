import h from 'react-hyperscript'
import factory from 'hyperscript-helpers'
import {
  BrowserRouter as Router,
  Route
} from 'react-router-dom'

import Topmatter from './Topmatter'
import Home from './home/Home'
import Detail from './detail/Detail'

const {div} = factory(h)

export default () => {
  return h(Router, {}, [
    div({className: 'main-container'}, [
      h(Topmatter, {}),
      div({className: 'content-container'}, [
        h(Route, {exact: true, path: '/', component: Home}),
        h(Route, {path: '/rabbit', component: Detail})
      ])
    ])
  ])
}

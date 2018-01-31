import * as ReactDOM from 'react-dom'
import 'clarity-ui/clarity-ui.css'
import 'clarity-icons/clarity-icons.css'
import h from 'react-hyperscript'
import {createStore} from "redux"

import Body from './components/Main'
import {
  recipeReducer,
  initialRecipeState
} from './ducks/recipes'
import {Provider} from "react-redux"


const store = createStore(
  recipeReducer,
  initialRecipeState
)

ReactDOM.render(
  h(Provider, {store: store}, [
    h(Body, {})
  ]),
  document.getElementById('app')
)

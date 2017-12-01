import Inferno from 'inferno'
import 'clarity-ui/clarity-ui.css'
import 'clarity-icons/clarity-icons.css'
import h from 'inferno-hyperscript'
import Body from './components/Body'

Inferno.render(
  h(Body),
  document.getElementById('app')
)

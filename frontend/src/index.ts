import Inferno from 'inferno'
import 'bootstrap/dist/css/bootstrap.min.css'
import h from 'inferno-hyperscript'
import Body from './components/Body'

Inferno.render(
  h(Body),
  document.getElementById('app')
)

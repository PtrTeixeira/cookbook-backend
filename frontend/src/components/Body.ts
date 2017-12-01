import h from 'inferno-hyperscript'
import factory from 'hyperscript-helpers'
import Topmatter from './Topmatter'
import Main from './Main'

const {div} = factory(h)

export default () => {
  return div({className: 'main-container'}, [
    h(Topmatter),
    div({className: 'content-container'}, h(Main))
  ])
}

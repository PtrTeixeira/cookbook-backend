import h from 'inferno-hyperscript'
import factory from 'hyperscript-helpers'
import Topmatter from './Topmatter'
import Sidebar from './Sidebar'
import Main from './Main'

const {div} = factory(h)

export default () => {
  return div({className: 'container'}, [
    h(Topmatter),
    div({className: 'row'}, [
      div({className: 'col-3'}, h(Sidebar)),
      div({className: 'col-9'}, h(Main))
    ])
  ])
}

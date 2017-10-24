import h from 'inferno-hyperscript'
import factory from 'hyperscript-helpers'

const {div, p} = factory(h)

export default () => {
  return div({className: 'row justify-content-between'}, [
    div({className: 'col-md-3'}, p('Topmatter')),
    div({className: 'col-md-2'}, p('Hello Beautiful People!'))
  ])
}

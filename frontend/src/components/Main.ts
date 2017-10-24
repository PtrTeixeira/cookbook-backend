import h from 'inferno-hyperscript'
import factory from 'hyperscript-helpers'

const {div, p} = factory(h)

export default () => {
  return div({className: 'row'}, [
    div({className: 'col-md'}, p('Body Content'))
  ])
}

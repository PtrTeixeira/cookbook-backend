import h from 'inferno-hyperscript'
import factory from 'hyperscript-helpers'
import Card from './Card'

const {div} = factory(h)

export default () => {
  return div({className: 'content-area'},
    div({className: 'row'}, [
      h(Card),
      h(Card),
      h(Card),
      h(Card),
      h(Card),
      h(Card),
      h(Card),
      h(Card)
    ])
  )
}

import h from 'inferno-hyperscript'
import factory from 'hyperscript-helpers'

const {div, p, input} = factory(h)

export default () => {
  return div({className: 'row'}, [
    div({className: 'col-md'}, [
      h(SearchControl),
      h(ResultsDisplay)
    ])
  ])
}

const SearchControl = () => div({className: 'row'},
  div({className: 'col-md'}, [
    div({className: 'input-group'}, [
      input({type: 'text', className: 'form-control', placeholder: 'Search...'})
    ])
  ])
)

const ResultsDisplay = () => div({className: 'row'},
  div({className: 'col-md'}, [
    p('Sidebar - Bottom')
  ])
)

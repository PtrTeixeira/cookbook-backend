import h from 'inferno-hyperscript'
import factory from 'hyperscript-helpers'

const {div, a, span, form, label, input} = factory(h)

export default () => {
  return div({className: 'header header-5'}, [
    div({className: 'branding'}, [
      a({className: 'nav-link', href: '#'}, [
        span({className: 'title'}, 'Klaatu Cookbook')
      ])
    ]),
    form({className: 'search'}, [
      label({htmlFor: 'search_input'},
        input({id: 'search_input', type: 'text', placeholder: 'Search recipes'})
      )
    ])
  ])
}

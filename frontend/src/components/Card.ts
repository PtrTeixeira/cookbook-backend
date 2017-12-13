import h from 'inferno-hyperscript'
import factory from 'hyperscript-helpers'
import { Recipe } from '../data/Recipe' // eslint-disable-line

const {div, a, p} = factory(h)

const SAMPLE_RECIPE: Recipe = {
  id: '1',
  userId: 'xxx',
  name: 'SAMPLE',
  ingredients: [],
  instructions: '',
  summary: 'This is a summary of the recipe. Nom Nom Nom',
  description: ''
}

const RecipeCard = (recipe: Recipe) => {
  return div({className: 'col-lg-3 col-md-4 col-sm-6'},
    a({className: 'card clickable', href: '#'}, [
      div({className: 'card-header'}, recipe.name),
      div({className: 'card-block'},
        p({className: 'card-text'}, recipe.summary)
      )
    ])
  )
}

export default () => RecipeCard(SAMPLE_RECIPE)

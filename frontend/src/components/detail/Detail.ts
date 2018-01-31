import h from 'react-hyperscript'
import factory from 'hyperscript-helpers'

import {Recipe} from '../../data/Recipe'

const SAMPLE_RECIPE: Recipe = {
  id: '1',
  userId: 'xxx',
  name: 'SAMPLE',
  ingredients: [],
  instructions: '',
  summary: 'This is a summary of the recipe. Nom Nom Nom',
  description: ''
}

const {h1, p, div} = factory(h)

export default () => {
  return div({className: 'content-area'}, [
    div({className: 'row'}, [
      h1(SAMPLE_RECIPE.name),
      p(SAMPLE_RECIPE.summary)
    ])
  ])
}

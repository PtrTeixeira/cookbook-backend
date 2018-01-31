/* eslint-env jest */

import reducer, {
  RecipeState,
  recipeReducer,
  fetchRecipeAction, receiveRecipeAction, fetchRecipeFailedAction
} from '../../src/ducks/recipes'
import {Recipe} from '../../src/data/Recipe'

const INITIAL_STATE: RecipeState = {
  isFetching: false,
  recipes: [],
  error: null
}

const SAMPLE_RECIPE: Recipe = {
  id: '1',
  userId: 'xxx',
  name: 'SAMPLE',
  ingredients: [],
  instructions: '',
  summary: 'This is a summary of the recipe. Nom Nom Nom',
  description: ''
}

describe('Recipe actions & reducers', () => {
  describe('isFetching', () => {
    test('Fetching a recipe makes the state load', () => {
      const nextState = recipeReducer(INITIAL_STATE, fetchRecipeAction('0000'))
      expect(nextState.isFetching)
        .toEqual(true)
    })

    test('Receiving a recipe makes the state stop loading', () => {
      const loadingState = recipeReducer(INITIAL_STATE, fetchRecipeAction('0000'))
      const receivedState = recipeReducer(loadingState, receiveRecipeAction(SAMPLE_RECIPE))

      expect(receivedState.isFetching)
        .toEqual(false)
    })

    test('Receiving an error makes the state stop loading', () => {
      const loadingState = recipeReducer(INITIAL_STATE, fetchRecipeAction('0000'))
      const receivedState = recipeReducer(loadingState, fetchRecipeFailedAction('error message'))

      expect(receivedState.isFetching)
        .toEqual(false)
    })
  })

  describe('recipes', () => {
    test('Receiving a recipe adds it to the state', () => {
      const received = recipeReducer(INITIAL_STATE, receiveRecipeAction(SAMPLE_RECIPE))

      expect(received.recipes).toHaveLength(1)
      expect(received.recipes).toContain(SAMPLE_RECIPE)
    })
  })

  describe('error', () => {
    test('Receiving an error puts the error in the state', () => {
      const error = recipeReducer(INITIAL_STATE, fetchRecipeFailedAction('an error'))

      expect(error.error)
        .toEqual('an error')
    })
    test('Fetching a recipe does not clear the current error', () => {
      const error = recipeReducer(INITIAL_STATE, fetchRecipeFailedAction('an error'))
      const afterFetch = recipeReducer(error, fetchRecipeAction('0000'))

      expect(afterFetch.error)
        .toEqual('an error')
    })
    test('Receiving a recipe clears the current error', () => {
      const error = recipeReducer(INITIAL_STATE, fetchRecipeFailedAction('an error'))
      const afterReceive = recipeReducer(error, receiveRecipeAction(SAMPLE_RECIPE))

      expect(afterReceive.error)
        .toBeNull()
    })
  })
})

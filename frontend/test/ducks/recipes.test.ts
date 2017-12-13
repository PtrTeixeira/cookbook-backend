/* eslint-env jest */

import reducer, {selectRecipe, fetchSingle, fetchBulk} from "../../src/ducks/recipes"

const INITIAL_STATE = {
  isLoading: false,
  items: {}
}

describe('Recipe actions & reducers', () => {
  test('Selecting a recipe doesn\'t change the state', () => {
    const nextState = reducer(INITIAL_STATE, selectRecipe("0"))
    expect(nextState).toEqual(INITIAL_STATE)
  })

  test('Fetching one recipe turns on the loading indicator', () => {
    const nextState = reducer(INITIAL_STATE, fetchSingle("0"))
    expect(nextState).toEqual({
      isLoading: true,
      items: {}
    })
  })

  test('Fetching recipes in bulk turns on the loading inidicator', () => {
    const nextState = reducer(INITIAL_STATE, fetchBulk())
    expect(nextState).toEqual({
      isLoading: true,
      items: {}
    })
  })
})

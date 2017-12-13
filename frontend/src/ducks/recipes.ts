import { Recipe } from '../data/Recipe'   // eslint-disable-line
import { RecipeState } from "../data/State" // eslint-disable-line

const SELECT_RECIPE = 'cookbook/recipes/SELECT_RECIPE'

const FETCH_BULK_FETCHING = 'cookbook/recipes/FETCH_BULK_FETCHING'
const FETCH_BULK_SUCCESS = 'cookbook/recipes/FETCH_BULK_SUCCESS'
const FETCH_BULK_FAILURE = 'cookbook/recipes/FETCH_BULK_FAILURE'

const FETCH_SINGLE_FETCHING = 'cookbook/recipes/FETCH_BULK_FETCHING'
const FETCH_SINGLE_SUCCESS = 'cookbook/recipes/FETCH_SINGLE_SUCCESS'
const FETCH_SINGLE_FAILURE = 'cookbook/recipes/FETCH_SINGLE_FAILURE'

export default function reducer (state: RecipeState, action = {}): RecipeState {
  switch (action.type) {
    case SELECT_RECIPE: return state
    case FETCH_BULK_FETCHING: return { isLoading: true, items: state.items }
    case FETCH_BULK_FAILURE:  return { isLoading: false, items: state.items }
    case FETCH_BULK_SUCCESS: return {
      isLoading: false,
      items: {
        ...state.items,
        ...action.payload
      }
    }
    case FETCH_SINGLE_FETCHING: return { isLoading: true, items: state.items }
    case FETCH_SINGLE_FAILURE: return { isLoading: false, items: state.items }
    case FETCH_SINGLE_SUCCESS: return {
      isLoading: false,
      items: {
        [action.payload.id]: action.payload,
        ...state.items
      }
    }
    default: return state
  }
}

/* Action Creators */
export function selectRecipe(id: string) {
  return { type: SELECT_RECIPE, id }
}

export function fetchBulk() {
  return { type: FETCH_BULK_FETCHING }
}

export function fetchSingle(id: string) {
  return { type: FETCH_SINGLE_FETCHING, id }
}

export function fetchBulkSuccess(recipes: [Recipe]) {
  return {
    type: FETCH_BULK_SUCCESS,
    payload: recipes
  }
}

export function fetchBulkFailure() {
  return { type: FETCH_BULK_FAILURE }
}

export function fetchSingleSuccess(recipe: Recipe) {
  return {
    type: FETCH_SINGLE_SUCCESS,
    payload: recipe
  }
}

export function fetchSingleFailure() {
  return { type: FETCH_SINGLE_FAILURE }
}

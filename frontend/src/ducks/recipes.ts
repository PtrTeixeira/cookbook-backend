import {Recipe} from '../data/Recipe'   // eslint-disable-line
import {combineReducers} from 'redux'

export type RecipeState = {
  readonly isFetching: boolean,
  readonly error: string | null,
  readonly recipes: Recipe[]
}

export const initialRecipeState: RecipeState = {
  isFetching: false,
  error: null,
  recipes: [] as Recipe[]
}

export type RecipeAction =
  Action<'FETCH_RECIPE', string> |
  Action<'RECEIVE_RECIPE', Recipe> |
  Action<'FETCH_RECIPE_FAILED', string>

export type Action<Type, Payload> = {type: Type, payload: Payload}

export type ActionCreator<Type, Payload> = (value: Payload) => Action<Type, Payload>

export const fetchRecipeAction: ActionCreator<'FETCH_RECIPE', string> = (payload: string) => ({
  type: 'FETCH_RECIPE' as 'FETCH_RECIPE',
  payload
})

export const receiveRecipeAction: ActionCreator<'RECEIVE_RECIPE', Recipe> = (payload: Recipe) => ({
  type: 'RECEIVE_RECIPE' as 'RECEIVE_RECIPE',
  payload
})

export const fetchRecipeFailedAction: ActionCreator<'FETCH_RECIPE_FAILED', string> = (payload: string) => ({
  type: 'FETCH_RECIPE_FAILED' as 'FETCH_RECIPE_FAILED',
  payload
})

export const recipeReducer = combineReducers<RecipeState>({
  isFetching: (state = false, action: RecipeAction) => {
    switch (action.type) {
      case 'FETCH_RECIPE':
        return true
      case 'RECEIVE_RECIPE':
      case 'FETCH_RECIPE_FAILED':
        return false
      default:
        return state
    }
  },
  recipes: (state = [], action: RecipeAction) => {
    switch (action.type) {
      case 'RECEIVE_RECIPE':
        return [...state, action.payload]
      default:
        return state
    }
  },
  error: (state = null, action: RecipeAction) => {
    switch (action.type) {
      case 'FETCH_RECIPE_FAILED':
        return action.payload
      case 'RECEIVE_RECIPE':
        return null
      default:
        return state
    }
  }
})

/* eslint-disable no-undef */
import {Recipe} from './Recipe'

export type State = {
  readonly recipes: Recipe[],
  readonly loading: boolean
}

export const initialState: State = {
  recipes: [] as Recipe[],
  loading: false
}

/* eslint-enable no-undef */

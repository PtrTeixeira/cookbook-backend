/* eslint-disable no-undef */
import {Recipe} from './Recipe'

export interface RecipeState {
  isLoading: boolean,
  items: {
    [id: string]: Recipe
  }
}
/* eslint-enable no-undef */
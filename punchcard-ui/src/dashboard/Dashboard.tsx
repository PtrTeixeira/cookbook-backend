import * as React from 'react'

import '../App.css'

import { buildWeeklyGrid, IWeeklyResults } from '../heatmap/actions';
import { WeekMap } from '../heatmap/WeekMap';


export function Dashboard({error, isLoaded, weeklyResults}: {error: any, isLoaded: boolean, weeklyResults: IWeeklyResults | null}) {
    if (isLoaded && error != null) {
        return (
            <p className="App-intro">
                {error}
            </p>
        );
    } else if (weeklyResults != null) {
        return (
            <WeekMap data={buildWeeklyGrid(weeklyResults)} />
        )
    } else {
        return (
            <p className="App-intro">
               Loading ...
            </p>
        )
    }
}

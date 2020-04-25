import * as React from "react";

import "../App.css";

import { buildWeeklyGrid, IWeeklyResults } from "../heatmap/actions";
import { WeekMap } from "../heatmap/WeekMap";

export function Dashboard({
  error,
  isLoaded,
  weeklyResults,
}: {
  error: any;
  isLoaded: boolean;
  weeklyResults: IWeeklyResults | null;
}) {
  if (!isLoaded) {
    return <p className="App-intro">Loading...</p>;
  }

  if (error != null) {
    return <p className="App-intro">{error}</p>;
  }

  if (weeklyResults == null) {
    return <p className="App-intro">Could not load data from server</p>;
  }

  return <WeekMap data={buildWeeklyGrid(weeklyResults)} />;
}
